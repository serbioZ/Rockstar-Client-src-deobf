// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import optifine.Config;
import net.minecraft.client.renderer.chunk.ListedRenderChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.BlockRenderLayer;

public class RenderList extends ChunkRenderContainer
{
    @Override
    public void renderChunkLayer(final BlockRenderLayer lllllllllllIIllIlIlIlllIIlIlllll) {
        if (this.initialized) {
            if (this.renderChunks.size() == 0) {
                return;
            }
            for (final RenderChunk lllllllllllIIllIlIlIlllIIllIIIlI : this.renderChunks) {
                final ListedRenderChunk lllllllllllIIllIlIlIlllIIllIIIIl = (ListedRenderChunk)lllllllllllIIllIlIlIlllIIllIIIlI;
                GlStateManager.pushMatrix();
                this.preRenderChunk(lllllllllllIIllIlIlIlllIIllIIIlI);
                GlStateManager.callList(lllllllllllIIllIlIlIlllIIllIIIIl.getDisplayList(lllllllllllIIllIlIlIlllIIlIlllll, lllllllllllIIllIlIlIlllIIllIIIIl.getCompiledChunk()));
                GlStateManager.popMatrix();
            }
            if (Config.isMultiTexture()) {
                GlStateManager.bindCurrentTexture();
            }
            GlStateManager.resetColor();
            this.renderChunks.clear();
        }
    }
}
