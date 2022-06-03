// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerFuzzyZoom extends GenLayerZoom
{
    @Override
    protected int selectModeOrRandom(final int lllllllllllllIIIIIIlIIlllIlIIllI, final int lllllllllllllIIIIIIlIIlllIlIlIlI, final int lllllllllllllIIIIIIlIIlllIlIlIIl, final int lllllllllllllIIIIIIlIIlllIlIlIII) {
        return this.selectRandom(lllllllllllllIIIIIIlIIlllIlIIllI, lllllllllllllIIIIIIlIIlllIlIlIlI, lllllllllllllIIIIIIlIIlllIlIlIIl, lllllllllllllIIIIIIlIIlllIlIlIII);
    }
    
    public GenLayerFuzzyZoom(final long lllllllllllllIIIIIIlIIlllIllIIll, final GenLayer lllllllllllllIIIIIIlIIlllIllIIlI) {
        super(lllllllllllllIIIIIIlIIlllIllIIll, lllllllllllllIIIIIIlIIlllIllIIlI);
    }
}
