// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.util.BlockRenderLayer;

public class RegionRenderCacheBuilder
{
    private final /* synthetic */ BufferBuilder[] worldRenderers;
    
    public RegionRenderCacheBuilder() {
        this.worldRenderers = new BufferBuilder[BlockRenderLayer.values().length];
        this.worldRenderers[BlockRenderLayer.SOLID.ordinal()] = new BufferBuilder(2097152);
        this.worldRenderers[BlockRenderLayer.CUTOUT.ordinal()] = new BufferBuilder(131072);
        this.worldRenderers[BlockRenderLayer.CUTOUT_MIPPED.ordinal()] = new BufferBuilder(131072);
        this.worldRenderers[BlockRenderLayer.TRANSLUCENT.ordinal()] = new BufferBuilder(262144);
    }
    
    public BufferBuilder getWorldRendererByLayer(final BlockRenderLayer lllllllllllIlllIIIIllIlIIIIIlIIl) {
        return this.worldRenderers[lllllllllllIlllIIIIllIlIIIIIlIIl.ordinal()];
    }
    
    public BufferBuilder getWorldRendererByLayerId(final int lllllllllllIlllIIIIllIlIIIIIIlIl) {
        return this.worldRenderers[lllllllllllIlllIIIIllIlIIIIIIlIl];
    }
}
