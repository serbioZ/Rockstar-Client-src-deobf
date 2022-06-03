// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.util.BlockRenderLayer;

public class ListedRenderChunk extends RenderChunk
{
    private final /* synthetic */ int baseDisplayList;
    
    @Override
    public void deleteGlResources() {
        super.deleteGlResources();
        GLAllocation.deleteDisplayLists(this.baseDisplayList, BlockRenderLayer.values().length);
    }
    
    public ListedRenderChunk(final World lllllllllllllIlllIlIIlllIlIIIIII, final RenderGlobal lllllllllllllIlllIlIIlllIIllllll, final int lllllllllllllIlllIlIIlllIlIIIIlI) {
        super(lllllllllllllIlllIlIIlllIlIIIIII, lllllllllllllIlllIlIIlllIIllllll, lllllllllllllIlllIlIIlllIlIIIIlI);
        this.baseDisplayList = GLAllocation.generateDisplayLists(BlockRenderLayer.values().length);
    }
    
    public int getDisplayList(final BlockRenderLayer lllllllllllllIlllIlIIlllIIlllIIl, final CompiledChunk lllllllllllllIlllIlIIlllIIllIlIl) {
        return lllllllllllllIlllIlIIlllIIllIlIl.isLayerEmpty(lllllllllllllIlllIlIIlllIIlllIIl) ? -1 : (this.baseDisplayList + lllllllllllllIlllIlIIlllIIlllIIl.ordinal());
    }
}
