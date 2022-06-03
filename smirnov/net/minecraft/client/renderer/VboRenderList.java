// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import shadersmod.client.ShadersRender;
import optifine.Config;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.BlockRenderLayer;

public class VboRenderList extends ChunkRenderContainer
{
    @Override
    public void renderChunkLayer(final BlockRenderLayer lIlllIllIllIlll) {
        if (this.initialized) {
            for (final RenderChunk lIlllIllIlllIlI : this.renderChunks) {
                final VertexBuffer lIlllIllIlllIIl = lIlllIllIlllIlI.getVertexBufferByLayer(lIlllIllIllIlll.ordinal());
                GlStateManager.pushMatrix();
                this.preRenderChunk(lIlllIllIlllIlI);
                lIlllIllIlllIlI.multModelviewMatrix();
                lIlllIllIlllIIl.bindBuffer();
                this.setupArrayPointers();
                lIlllIllIlllIIl.drawArrays(7);
                GlStateManager.popMatrix();
            }
            OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
            GlStateManager.resetColor();
            this.renderChunks.clear();
        }
    }
    
    private void setupArrayPointers() {
        if (Config.isShaders()) {
            ShadersRender.setupArrayPointersVbo();
        }
        else {
            GlStateManager.glVertexPointer(3, 5126, 28, 0);
            GlStateManager.glColorPointer(4, 5121, 28, 12);
            GlStateManager.glTexCoordPointer(2, 5126, 28, 16);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.glTexCoordPointer(2, 5122, 28, 24);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
        }
    }
}
