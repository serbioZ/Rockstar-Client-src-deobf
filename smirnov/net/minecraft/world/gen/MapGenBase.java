// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.world.chunk.ChunkPrimer;
import java.util.Random;
import net.minecraft.world.World;

public class MapGenBase
{
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ Random rand;
    protected /* synthetic */ int range;
    
    public static void func_191068_a(final long lllllllllllIIIlllIlIllIllIIIIlII, final Random lllllllllllIIIlllIlIllIllIIIIIll, final int lllllllllllIIIlllIlIllIlIllllIlI, final int lllllllllllIIIlllIlIllIlIllllIIl) {
        lllllllllllIIIlllIlIllIllIIIIIll.setSeed(lllllllllllIIIlllIlIllIllIIIIlII);
        final long lllllllllllIIIlllIlIllIllIIIIIII = lllllllllllIIIlllIlIllIllIIIIIll.nextLong();
        final long lllllllllllIIIlllIlIllIlIlllllll = lllllllllllIIIlllIlIllIllIIIIIll.nextLong();
        final long lllllllllllIIIlllIlIllIlIllllllI = lllllllllllIIIlllIlIllIlIllllIlI * lllllllllllIIIlllIlIllIllIIIIIII;
        final long lllllllllllIIIlllIlIllIlIlllllIl = lllllllllllIIIlllIlIllIlIllllIIl * lllllllllllIIIlllIlIllIlIlllllll;
        lllllllllllIIIlllIlIllIllIIIIIll.setSeed(lllllllllllIIIlllIlIllIlIllllllI ^ lllllllllllIIIlllIlIllIlIlllllIl ^ lllllllllllIIIlllIlIllIllIIIIlII);
    }
    
    public MapGenBase() {
        this.range = 8;
        this.rand = new Random();
    }
    
    protected void recursiveGenerate(final World lllllllllllIIIlllIlIllIlIlllIIll, final int lllllllllllIIIlllIlIllIlIlllIIlI, final int lllllllllllIIIlllIlIllIlIlllIIIl, final int lllllllllllIIIlllIlIllIlIlllIIII, final int lllllllllllIIIlllIlIllIlIllIllll, final ChunkPrimer lllllllllllIIIlllIlIllIlIllIlllI) {
    }
    
    public void generate(final World lllllllllllIIIlllIlIllIllIlIIIll, final int lllllllllllIIIlllIlIllIllIIlIllI, final int lllllllllllIIIlllIlIllIllIlIIIIl, final ChunkPrimer lllllllllllIIIlllIlIllIllIlIIIII) {
        final int lllllllllllIIIlllIlIllIllIIlllll = this.range;
        this.worldObj = lllllllllllIIIlllIlIllIllIlIIIll;
        this.rand.setSeed(lllllllllllIIIlllIlIllIllIlIIIll.getSeed());
        final long lllllllllllIIIlllIlIllIllIIllllI = this.rand.nextLong();
        final long lllllllllllIIIlllIlIllIllIIlllIl = this.rand.nextLong();
        for (int lllllllllllIIIlllIlIllIllIIlllII = lllllllllllIIIlllIlIllIllIIlIllI - lllllllllllIIIlllIlIllIllIIlllll; lllllllllllIIIlllIlIllIllIIlllII <= lllllllllllIIIlllIlIllIllIIlIllI + lllllllllllIIIlllIlIllIllIIlllll; ++lllllllllllIIIlllIlIllIllIIlllII) {
            for (int lllllllllllIIIlllIlIllIllIIllIll = lllllllllllIIIlllIlIllIllIlIIIIl - lllllllllllIIIlllIlIllIllIIlllll; lllllllllllIIIlllIlIllIllIIllIll <= lllllllllllIIIlllIlIllIllIlIIIIl + lllllllllllIIIlllIlIllIllIIlllll; ++lllllllllllIIIlllIlIllIllIIllIll) {
                final long lllllllllllIIIlllIlIllIllIIllIlI = lllllllllllIIIlllIlIllIllIIlllII * lllllllllllIIIlllIlIllIllIIllllI;
                final long lllllllllllIIIlllIlIllIllIIllIIl = lllllllllllIIIlllIlIllIllIIllIll * lllllllllllIIIlllIlIllIllIIlllIl;
                this.rand.setSeed(lllllllllllIIIlllIlIllIllIIllIlI ^ lllllllllllIIIlllIlIllIllIIllIIl ^ lllllllllllIIIlllIlIllIllIlIIIll.getSeed());
                this.recursiveGenerate(lllllllllllIIIlllIlIllIllIlIIIll, lllllllllllIIIlllIlIllIllIIlllII, lllllllllllIIIlllIlIllIllIIllIll, lllllllllllIIIlllIlIllIllIIlIllI, lllllllllllIIIlllIlIllIllIlIIIIl, lllllllllllIIIlllIlIllIllIlIIIII);
            }
        }
    }
}
