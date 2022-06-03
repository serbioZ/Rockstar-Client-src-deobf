// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.util.math.BlockPos;
import com.google.common.collect.Lists;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import java.util.List;

public abstract class ChunkRenderContainer
{
    protected /* synthetic */ List<RenderChunk> renderChunks;
    private /* synthetic */ double viewEntityX;
    private /* synthetic */ double viewEntityY;
    private /* synthetic */ double viewEntityZ;
    protected /* synthetic */ boolean initialized;
    
    public void initialize(final double lllllllllllIIlIlIIIIlllllIIlIlll, final double lllllllllllIIlIlIIIIlllllIIllIlI, final double lllllllllllIIlIlIIIIlllllIIllIIl) {
        this.initialized = true;
        this.renderChunks.clear();
        this.viewEntityX = lllllllllllIIlIlIIIIlllllIIlIlll;
        this.viewEntityY = lllllllllllIIlIlIIIIlllllIIllIlI;
        this.viewEntityZ = lllllllllllIIlIlIIIIlllllIIllIIl;
    }
    
    public void addRenderChunk(final RenderChunk lllllllllllIIlIlIIIIlllllIIIIlIl, final BlockRenderLayer lllllllllllIIlIlIIIIlllllIIIIlll) {
        this.renderChunks.add(lllllllllllIIlIlIIIIlllllIIIIlIl);
    }
    
    public ChunkRenderContainer() {
        this.renderChunks = (List<RenderChunk>)Lists.newArrayListWithCapacity(17424);
    }
    
    public abstract void renderChunkLayer(final BlockRenderLayer p0);
    
    public void preRenderChunk(final RenderChunk lllllllllllIIlIlIIIIlllllIIIllIl) {
        final BlockPos lllllllllllIIlIlIIIIlllllIIIllll = lllllllllllIIlIlIIIIlllllIIIllIl.getPosition();
        GlStateManager.translate((float)(lllllllllllIIlIlIIIIlllllIIIllll.getX() - this.viewEntityX), (float)(lllllllllllIIlIlIIIIlllllIIIllll.getY() - this.viewEntityY), (float)(lllllllllllIIlIlIIIIlllllIIIllll.getZ() - this.viewEntityZ));
    }
}
