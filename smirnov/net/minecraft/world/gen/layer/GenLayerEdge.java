// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.layer;

public class GenLayerEdge extends GenLayer
{
    private final /* synthetic */ Mode mode;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode() {
        final int[] $switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode = GenLayerEdge.$SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode;
        if ($switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode != null) {
            return $switch_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode;
        }
        final boolean lllllllllllIIlllllIlIlllllIlllll = (Object)new int[Mode.values().length];
        try {
            lllllllllllIIlllllIlIlllllIlllll[Mode.COOL_WARM.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllllIlIlllllIlllll[Mode.HEAT_ICE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllllIlIlllllIlllll[Mode.SPECIAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GenLayerEdge.$SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode = (int[])(Object)lllllllllllIIlllllIlIlllllIlllll;
    }
    
    private int[] getIntsHeatIce(final int lllllllllllIIlllllIllIIIIIIlIIIl, final int lllllllllllIIlllllIllIIIIIlIIlII, final int lllllllllllIIlllllIllIIIIIIIllll, final int lllllllllllIIlllllIllIIIIIIIlllI) {
        final int lllllllllllIIlllllIllIIIIIlIIIIl = lllllllllllIIlllllIllIIIIIIlIIIl - 1;
        final int lllllllllllIIlllllIllIIIIIlIIIII = lllllllllllIIlllllIllIIIIIlIIlII - 1;
        final int lllllllllllIIlllllIllIIIIIIlllll = 1 + lllllllllllIIlllllIllIIIIIIIllll + 1;
        final int lllllllllllIIlllllIllIIIIIIllllI = 1 + lllllllllllIIlllllIllIIIIIIIlllI + 1;
        final int[] lllllllllllIIlllllIllIIIIIIlllIl = this.parent.getInts(lllllllllllIIlllllIllIIIIIlIIIIl, lllllllllllIIlllllIllIIIIIlIIIII, lllllllllllIIlllllIllIIIIIIlllll, lllllllllllIIlllllIllIIIIIIllllI);
        final int[] lllllllllllIIlllllIllIIIIIIlllII = IntCache.getIntCache(lllllllllllIIlllllIllIIIIIIIllll * lllllllllllIIlllllIllIIIIIIIlllI);
        for (int lllllllllllIIlllllIllIIIIIIllIll = 0; lllllllllllIIlllllIllIIIIIIllIll < lllllllllllIIlllllIllIIIIIIIlllI; ++lllllllllllIIlllllIllIIIIIIllIll) {
            for (int lllllllllllIIlllllIllIIIIIIllIlI = 0; lllllllllllIIlllllIllIIIIIIllIlI < lllllllllllIIlllllIllIIIIIIIllll; ++lllllllllllIIlllllIllIIIIIIllIlI) {
                int lllllllllllIIlllllIllIIIIIIllIIl = lllllllllllIIlllllIllIIIIIIlllIl[lllllllllllIIlllllIllIIIIIIllIlI + 1 + (lllllllllllIIlllllIllIIIIIIllIll + 1) * lllllllllllIIlllllIllIIIIIIlllll];
                if (lllllllllllIIlllllIllIIIIIIllIIl == 4) {
                    final int lllllllllllIIlllllIllIIIIIIllIII = lllllllllllIIlllllIllIIIIIIlllIl[lllllllllllIIlllllIllIIIIIIllIlI + 1 + (lllllllllllIIlllllIllIIIIIIllIll + 1 - 1) * lllllllllllIIlllllIllIIIIIIlllll];
                    final int lllllllllllIIlllllIllIIIIIIlIlll = lllllllllllIIlllllIllIIIIIIlllIl[lllllllllllIIlllllIllIIIIIIllIlI + 1 + 1 + (lllllllllllIIlllllIllIIIIIIllIll + 1) * lllllllllllIIlllllIllIIIIIIlllll];
                    final int lllllllllllIIlllllIllIIIIIIlIllI = lllllllllllIIlllllIllIIIIIIlllIl[lllllllllllIIlllllIllIIIIIIllIlI + 1 - 1 + (lllllllllllIIlllllIllIIIIIIllIll + 1) * lllllllllllIIlllllIllIIIIIIlllll];
                    final int lllllllllllIIlllllIllIIIIIIlIlIl = lllllllllllIIlllllIllIIIIIIlllIl[lllllllllllIIlllllIllIIIIIIllIlI + 1 + (lllllllllllIIlllllIllIIIIIIllIll + 1 + 1) * lllllllllllIIlllllIllIIIIIIlllll];
                    final boolean lllllllllllIIlllllIllIIIIIIlIlII = lllllllllllIIlllllIllIIIIIIllIII == 2 || lllllllllllIIlllllIllIIIIIIlIlll == 2 || lllllllllllIIlllllIllIIIIIIlIllI == 2 || lllllllllllIIlllllIllIIIIIIlIlIl == 2;
                    final boolean lllllllllllIIlllllIllIIIIIIlIIll = lllllllllllIIlllllIllIIIIIIllIII == 1 || lllllllllllIIlllllIllIIIIIIlIlll == 1 || lllllllllllIIlllllIllIIIIIIlIllI == 1 || lllllllllllIIlllllIllIIIIIIlIlIl == 1;
                    if (lllllllllllIIlllllIllIIIIIIlIIll || lllllllllllIIlllllIllIIIIIIlIlII) {
                        lllllllllllIIlllllIllIIIIIIllIIl = 3;
                    }
                }
                lllllllllllIIlllllIllIIIIIIlllII[lllllllllllIIlllllIllIIIIIIllIlI + lllllllllllIIlllllIllIIIIIIllIll * lllllllllllIIlllllIllIIIIIIIllll] = lllllllllllIIlllllIllIIIIIIllIIl;
            }
        }
        return lllllllllllIIlllllIllIIIIIIlllII;
    }
    
    private int[] getIntsSpecial(final int lllllllllllIIlllllIlIlllllllIIll, final int lllllllllllIIlllllIlIlllllllIIlI, final int lllllllllllIIlllllIlIllllllIIlll, final int lllllllllllIIlllllIlIllllllIIllI) {
        final int[] lllllllllllIIlllllIlIllllllIllll = this.parent.getInts(lllllllllllIIlllllIlIlllllllIIll, lllllllllllIIlllllIlIlllllllIIlI, lllllllllllIIlllllIlIllllllIIlll, lllllllllllIIlllllIlIllllllIIllI);
        final int[] lllllllllllIIlllllIlIllllllIlllI = IntCache.getIntCache(lllllllllllIIlllllIlIllllllIIlll * lllllllllllIIlllllIlIllllllIIllI);
        for (int lllllllllllIIlllllIlIllllllIllIl = 0; lllllllllllIIlllllIlIllllllIllIl < lllllllllllIIlllllIlIllllllIIllI; ++lllllllllllIIlllllIlIllllllIllIl) {
            for (int lllllllllllIIlllllIlIllllllIllII = 0; lllllllllllIIlllllIlIllllllIllII < lllllllllllIIlllllIlIllllllIIlll; ++lllllllllllIIlllllIlIllllllIllII) {
                this.initChunkSeed(lllllllllllIIlllllIlIllllllIllII + lllllllllllIIlllllIlIlllllllIIll, lllllllllllIIlllllIlIllllllIllIl + lllllllllllIIlllllIlIlllllllIIlI);
                int lllllllllllIIlllllIlIllllllIlIll = lllllllllllIIlllllIlIllllllIllll[lllllllllllIIlllllIlIllllllIllII + lllllllllllIIlllllIlIllllllIllIl * lllllllllllIIlllllIlIllllllIIlll];
                if (lllllllllllIIlllllIlIllllllIlIll != 0 && this.nextInt(13) == 0) {
                    lllllllllllIIlllllIlIllllllIlIll |= (1 + this.nextInt(15) << 8 & 0xF00);
                }
                lllllllllllIIlllllIlIllllllIlllI[lllllllllllIIlllllIlIllllllIllII + lllllllllllIIlllllIlIllllllIllIl * lllllllllllIIlllllIlIllllllIIlll] = lllllllllllIIlllllIlIllllllIlIll;
            }
        }
        return lllllllllllIIlllllIlIllllllIlllI;
    }
    
    @Override
    public int[] getInts(final int lllllllllllIIlllllIllIIIIlllllll, final int lllllllllllIIlllllIllIIIIllllllI, final int lllllllllllIIlllllIllIIIIllllIII, final int lllllllllllIIlllllIllIIIIlllllII) {
        switch ($SWITCH_TABLE$net$minecraft$world$gen$layer$GenLayerEdge$Mode()[this.mode.ordinal()]) {
            default: {
                return this.getIntsCoolWarm(lllllllllllIIlllllIllIIIIlllllll, lllllllllllIIlllllIllIIIIllllllI, lllllllllllIIlllllIllIIIIllllIII, lllllllllllIIlllllIllIIIIlllllII);
            }
            case 2: {
                return this.getIntsHeatIce(lllllllllllIIlllllIllIIIIlllllll, lllllllllllIIlllllIllIIIIllllllI, lllllllllllIIlllllIllIIIIllllIII, lllllllllllIIlllllIllIIIIlllllII);
            }
            case 3: {
                return this.getIntsSpecial(lllllllllllIIlllllIllIIIIlllllll, lllllllllllIIlllllIllIIIIllllllI, lllllllllllIIlllllIllIIIIllllIII, lllllllllllIIlllllIllIIIIlllllII);
            }
        }
    }
    
    public GenLayerEdge(final long lllllllllllIIlllllIllIIIlIIIllII, final GenLayer lllllllllllIIlllllIllIIIlIIIIlll, final Mode lllllllllllIIlllllIllIIIlIIIlIlI) {
        super(lllllllllllIIlllllIllIIIlIIIllII);
        this.parent = lllllllllllIIlllllIllIIIlIIIIlll;
        this.mode = lllllllllllIIlllllIllIIIlIIIlIlI;
    }
    
    private int[] getIntsCoolWarm(final int lllllllllllIIlllllIllIIIIllIIIIl, final int lllllllllllIIlllllIllIIIIllIIIII, final int lllllllllllIIlllllIllIIIIlIIlIll, final int lllllllllllIIlllllIllIIIIlIllllI) {
        final int lllllllllllIIlllllIllIIIIlIlllIl = lllllllllllIIlllllIllIIIIllIIIIl - 1;
        final int lllllllllllIIlllllIllIIIIlIlllII = lllllllllllIIlllllIllIIIIllIIIII - 1;
        final int lllllllllllIIlllllIllIIIIlIllIll = 1 + lllllllllllIIlllllIllIIIIlIIlIll + 1;
        final int lllllllllllIIlllllIllIIIIlIllIlI = 1 + lllllllllllIIlllllIllIIIIlIllllI + 1;
        final int[] lllllllllllIIlllllIllIIIIlIllIIl = this.parent.getInts(lllllllllllIIlllllIllIIIIlIlllIl, lllllllllllIIlllllIllIIIIlIlllII, lllllllllllIIlllllIllIIIIlIllIll, lllllllllllIIlllllIllIIIIlIllIlI);
        final int[] lllllllllllIIlllllIllIIIIlIllIII = IntCache.getIntCache(lllllllllllIIlllllIllIIIIlIIlIll * lllllllllllIIlllllIllIIIIlIllllI);
        for (int lllllllllllIIlllllIllIIIIlIlIlll = 0; lllllllllllIIlllllIllIIIIlIlIlll < lllllllllllIIlllllIllIIIIlIllllI; ++lllllllllllIIlllllIllIIIIlIlIlll) {
            for (int lllllllllllIIlllllIllIIIIlIlIllI = 0; lllllllllllIIlllllIllIIIIlIlIllI < lllllllllllIIlllllIllIIIIlIIlIll; ++lllllllllllIIlllllIllIIIIlIlIllI) {
                this.initChunkSeed(lllllllllllIIlllllIllIIIIlIlIllI + lllllllllllIIlllllIllIIIIllIIIIl, lllllllllllIIlllllIllIIIIlIlIlll + lllllllllllIIlllllIllIIIIllIIIII);
                int lllllllllllIIlllllIllIIIIlIlIlIl = lllllllllllIIlllllIllIIIIlIllIIl[lllllllllllIIlllllIllIIIIlIlIllI + 1 + (lllllllllllIIlllllIllIIIIlIlIlll + 1) * lllllllllllIIlllllIllIIIIlIllIll];
                if (lllllllllllIIlllllIllIIIIlIlIlIl == 1) {
                    final int lllllllllllIIlllllIllIIIIlIlIlII = lllllllllllIIlllllIllIIIIlIllIIl[lllllllllllIIlllllIllIIIIlIlIllI + 1 + (lllllllllllIIlllllIllIIIIlIlIlll + 1 - 1) * lllllllllllIIlllllIllIIIIlIllIll];
                    final int lllllllllllIIlllllIllIIIIlIlIIll = lllllllllllIIlllllIllIIIIlIllIIl[lllllllllllIIlllllIllIIIIlIlIllI + 1 + 1 + (lllllllllllIIlllllIllIIIIlIlIlll + 1) * lllllllllllIIlllllIllIIIIlIllIll];
                    final int lllllllllllIIlllllIllIIIIlIlIIlI = lllllllllllIIlllllIllIIIIlIllIIl[lllllllllllIIlllllIllIIIIlIlIllI + 1 - 1 + (lllllllllllIIlllllIllIIIIlIlIlll + 1) * lllllllllllIIlllllIllIIIIlIllIll];
                    final int lllllllllllIIlllllIllIIIIlIlIIIl = lllllllllllIIlllllIllIIIIlIllIIl[lllllllllllIIlllllIllIIIIlIlIllI + 1 + (lllllllllllIIlllllIllIIIIlIlIlll + 1 + 1) * lllllllllllIIlllllIllIIIIlIllIll];
                    final boolean lllllllllllIIlllllIllIIIIlIlIIII = lllllllllllIIlllllIllIIIIlIlIlII == 3 || lllllllllllIIlllllIllIIIIlIlIIll == 3 || lllllllllllIIlllllIllIIIIlIlIIlI == 3 || lllllllllllIIlllllIllIIIIlIlIIIl == 3;
                    final boolean lllllllllllIIlllllIllIIIIlIIllll = lllllllllllIIlllllIllIIIIlIlIlII == 4 || lllllllllllIIlllllIllIIIIlIlIIll == 4 || lllllllllllIIlllllIllIIIIlIlIIlI == 4 || lllllllllllIIlllllIllIIIIlIlIIIl == 4;
                    if (lllllllllllIIlllllIllIIIIlIlIIII || lllllllllllIIlllllIllIIIIlIIllll) {
                        lllllllllllIIlllllIllIIIIlIlIlIl = 2;
                    }
                }
                lllllllllllIIlllllIllIIIIlIllIII[lllllllllllIIlllllIllIIIIlIlIllI + lllllllllllIIlllllIllIIIIlIlIlll * lllllllllllIIlllllIllIIIIlIIlIll] = lllllllllllIIlllllIllIIIIlIlIlIl;
            }
        }
        return lllllllllllIIlllllIllIIIIlIllIII;
    }
    
    public enum Mode
    {
        HEAT_ICE("HEAT_ICE", 1), 
        SPECIAL("SPECIAL", 2), 
        COOL_WARM("COOL_WARM", 0);
        
        private Mode(final String llllllllllllIllIllllIIIIlIlIlIII, final int llllllllllllIllIllllIIIIlIlIIlll) {
        }
    }
}
