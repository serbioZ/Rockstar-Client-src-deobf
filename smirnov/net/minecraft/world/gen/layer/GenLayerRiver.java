// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;

public class GenLayerRiver extends GenLayer
{
    private int riverFilter(final int llllllllllllIIlIlIlllIllllIIIIll) {
        return (llllllllllllIIlIlIlllIllllIIIIll >= 2) ? (2 + (llllllllllllIIlIlIlllIllllIIIIll & 0x1)) : llllllllllllIIlIlIlllIllllIIIIll;
    }
    
    public GenLayerRiver(final long llllllllllllIIlIlIlllIlllllllllI, final GenLayer llllllllllllIIlIlIllllIIIIIIIIII) {
        super(llllllllllllIIlIlIlllIlllllllllI);
        super.parent = llllllllllllIIlIlIllllIIIIIIIIII;
    }
    
    @Override
    public int[] getInts(final int llllllllllllIIlIlIlllIllllIlIlll, final int llllllllllllIIlIlIlllIlllllIlIII, final int llllllllllllIIlIlIlllIlllllIIlll, final int llllllllllllIIlIlIlllIlllllIIllI) {
        final int llllllllllllIIlIlIlllIlllllIIlIl = llllllllllllIIlIlIlllIllllIlIlll - 1;
        final int llllllllllllIIlIlIlllIlllllIIlII = llllllllllllIIlIlIlllIlllllIlIII - 1;
        final int llllllllllllIIlIlIlllIlllllIIIll = llllllllllllIIlIlIlllIlllllIIlll + 2;
        final int llllllllllllIIlIlIlllIlllllIIIlI = llllllllllllIIlIlIlllIlllllIIllI + 2;
        final int[] llllllllllllIIlIlIlllIlllllIIIIl = this.parent.getInts(llllllllllllIIlIlIlllIlllllIIlIl, llllllllllllIIlIlIlllIlllllIIlII, llllllllllllIIlIlIlllIlllllIIIll, llllllllllllIIlIlIlllIlllllIIIlI);
        final int[] llllllllllllIIlIlIlllIlllllIIIII = IntCache.getIntCache(llllllllllllIIlIlIlllIlllllIIlll * llllllllllllIIlIlIlllIlllllIIllI);
        for (int llllllllllllIIlIlIlllIllllIlllll = 0; llllllllllllIIlIlIlllIllllIlllll < llllllllllllIIlIlIlllIlllllIIllI; ++llllllllllllIIlIlIlllIllllIlllll) {
            for (int llllllllllllIIlIlIlllIllllIllllI = 0; llllllllllllIIlIlIlllIllllIllllI < llllllllllllIIlIlIlllIlllllIIlll; ++llllllllllllIIlIlIlllIllllIllllI) {
                final int llllllllllllIIlIlIlllIllllIlllIl = this.riverFilter(llllllllllllIIlIlIlllIlllllIIIIl[llllllllllllIIlIlIlllIllllIllllI + 0 + (llllllllllllIIlIlIlllIllllIlllll + 1) * llllllllllllIIlIlIlllIlllllIIIll]);
                final int llllllllllllIIlIlIlllIllllIlllII = this.riverFilter(llllllllllllIIlIlIlllIlllllIIIIl[llllllllllllIIlIlIlllIllllIllllI + 2 + (llllllllllllIIlIlIlllIllllIlllll + 1) * llllllllllllIIlIlIlllIlllllIIIll]);
                final int llllllllllllIIlIlIlllIllllIllIll = this.riverFilter(llllllllllllIIlIlIlllIlllllIIIIl[llllllllllllIIlIlIlllIllllIllllI + 1 + (llllllllllllIIlIlIlllIllllIlllll + 0) * llllllllllllIIlIlIlllIlllllIIIll]);
                final int llllllllllllIIlIlIlllIllllIllIlI = this.riverFilter(llllllllllllIIlIlIlllIlllllIIIIl[llllllllllllIIlIlIlllIllllIllllI + 1 + (llllllllllllIIlIlIlllIllllIlllll + 2) * llllllllllllIIlIlIlllIlllllIIIll]);
                final int llllllllllllIIlIlIlllIllllIllIIl = this.riverFilter(llllllllllllIIlIlIlllIlllllIIIIl[llllllllllllIIlIlIlllIllllIllllI + 1 + (llllllllllllIIlIlIlllIllllIlllll + 1) * llllllllllllIIlIlIlllIlllllIIIll]);
                if (llllllllllllIIlIlIlllIllllIllIIl == llllllllllllIIlIlIlllIllllIlllIl && llllllllllllIIlIlIlllIllllIllIIl == llllllllllllIIlIlIlllIllllIllIll && llllllllllllIIlIlIlllIllllIllIIl == llllllllllllIIlIlIlllIllllIlllII && llllllllllllIIlIlIlllIllllIllIIl == llllllllllllIIlIlIlllIllllIllIlI) {
                    llllllllllllIIlIlIlllIlllllIIIII[llllllllllllIIlIlIlllIllllIllllI + llllllllllllIIlIlIlllIllllIlllll * llllllllllllIIlIlIlllIlllllIIlll] = -1;
                }
                else {
                    llllllllllllIIlIlIlllIlllllIIIII[llllllllllllIIlIlIlllIllllIllllI + llllllllllllIIlIlIlllIllllIlllll * llllllllllllIIlIlIlllIlllllIIlll] = Biome.getIdForBiome(Biomes.RIVER);
                }
            }
        }
        return llllllllllllIIlIlIlllIlllllIIIII;
    }
}
