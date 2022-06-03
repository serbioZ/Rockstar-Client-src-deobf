// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;

public class MapGenCavesHell extends MapGenBase
{
    protected static final /* synthetic */ IBlockState AIR;
    
    static {
        AIR = Blocks.AIR.getDefaultState();
    }
    
    protected void addRoom(final long lllllllllllIIIlllIlIIlIlllIllIII, final int lllllllllllIIIlllIlIIlIlllIlIlll, final int lllllllllllIIIlllIlIIlIlllIIlllI, final ChunkPrimer lllllllllllIIIlllIlIIlIlllIlIlIl, final double lllllllllllIIIlllIlIIlIlllIIllII, final double lllllllllllIIIlllIlIIlIlllIlIIll, final double lllllllllllIIIlllIlIIlIlllIIlIlI) {
        this.addTunnel(lllllllllllIIIlllIlIIlIlllIllIII, lllllllllllIIIlllIlIIlIlllIlIlll, lllllllllllIIIlllIlIIlIlllIIlllI, lllllllllllIIIlllIlIIlIlllIlIlIl, lllllllllllIIIlllIlIIlIlllIIllII, lllllllllllIIIlllIlIIlIlllIlIIll, lllllllllllIIIlllIlIIlIlllIIlIlI, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    @Override
    protected void recursiveGenerate(final World lllllllllllIIIlllIlIIlIlIIlIllIl, final int lllllllllllIIIlllIlIIlIlIIlIllII, final int lllllllllllIIIlllIlIIlIlIIIllIll, final int lllllllllllIIIlllIlIIlIlIIlIlIlI, final int lllllllllllIIIlllIlIIlIlIIlIlIIl, final ChunkPrimer lllllllllllIIIlllIlIIlIlIIIllIII) {
        int lllllllllllIIIlllIlIIlIlIIlIIlll = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(10) + 1) + 1);
        if (this.rand.nextInt(5) != 0) {
            lllllllllllIIIlllIlIIlIlIIlIIlll = 0;
        }
        for (int lllllllllllIIIlllIlIIlIlIIlIIllI = 0; lllllllllllIIIlllIlIIlIlIIlIIllI < lllllllllllIIIlllIlIIlIlIIlIIlll; ++lllllllllllIIIlllIlIIlIlIIlIIllI) {
            final double lllllllllllIIIlllIlIIlIlIIlIIlIl = lllllllllllIIIlllIlIIlIlIIlIllII * 16 + this.rand.nextInt(16);
            final double lllllllllllIIIlllIlIIlIlIIlIIlII = this.rand.nextInt(128);
            final double lllllllllllIIIlllIlIIlIlIIlIIIll = lllllllllllIIIlllIlIIlIlIIIllIll * 16 + this.rand.nextInt(16);
            int lllllllllllIIIlllIlIIlIlIIlIIIlI = 1;
            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), lllllllllllIIIlllIlIIlIlIIlIlIlI, lllllllllllIIIlllIlIIlIlIIlIlIIl, lllllllllllIIIlllIlIIlIlIIIllIII, lllllllllllIIIlllIlIIlIlIIlIIlIl, lllllllllllIIIlllIlIIlIlIIlIIlII, lllllllllllIIIlllIlIIlIlIIlIIIll);
                lllllllllllIIIlllIlIIlIlIIlIIIlI += this.rand.nextInt(4);
            }
            for (int lllllllllllIIIlllIlIIlIlIIlIIIIl = 0; lllllllllllIIIlllIlIIlIlIIlIIIIl < lllllllllllIIIlllIlIIlIlIIlIIIlI; ++lllllllllllIIIlllIlIIlIlIIlIIIIl) {
                final float lllllllllllIIIlllIlIIlIlIIlIIIII = this.rand.nextFloat() * 6.2831855f;
                final float lllllllllllIIIlllIlIIlIlIIIlllll = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float lllllllllllIIIlllIlIIlIlIIIllllI = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                this.addTunnel(this.rand.nextLong(), lllllllllllIIIlllIlIIlIlIIlIlIlI, lllllllllllIIIlllIlIIlIlIIlIlIIl, lllllllllllIIIlllIlIIlIlIIIllIII, lllllllllllIIIlllIlIIlIlIIlIIlIl, lllllllllllIIIlllIlIIlIlIIlIIlII, lllllllllllIIIlllIlIIlIlIIlIIIll, lllllllllllIIIlllIlIIlIlIIIllllI * 2.0f, lllllllllllIIIlllIlIIlIlIIlIIIII, lllllllllllIIIlllIlIIlIlIIIlllll, 0, 0, 0.5);
            }
        }
    }
    
    protected void addTunnel(final long lllllllllllIIIlllIlIIlIlIllIlIlI, final int lllllllllllIIIlllIlIIlIllIIllIlI, final int lllllllllllIIIlllIlIIlIlIllIlIII, final ChunkPrimer lllllllllllIIIlllIlIIlIllIIllIII, double lllllllllllIIIlllIlIIlIlIllIIllI, double lllllllllllIIIlllIlIIlIlIllIIlIl, double lllllllllllIIIlllIlIIlIlIllIIlII, final float lllllllllllIIIlllIlIIlIllIIlIlII, float lllllllllllIIIlllIlIIlIlIllIIIlI, float lllllllllllIIIlllIlIIlIlIllIIIIl, int lllllllllllIIIlllIlIIlIlIllIIIII, int lllllllllllIIIlllIlIIlIlIlIlllll, final double lllllllllllIIIlllIlIIlIlIlIllllI) {
        final double lllllllllllIIIlllIlIIlIllIIIlllI = lllllllllllIIIlllIlIIlIllIIllIlI * 16 + 8;
        final double lllllllllllIIIlllIlIIlIllIIIllIl = lllllllllllIIIlllIlIIlIlIllIlIII * 16 + 8;
        float lllllllllllIIIlllIlIIlIllIIIllII = 0.0f;
        float lllllllllllIIIlllIlIIlIllIIIlIll = 0.0f;
        final Random lllllllllllIIIlllIlIIlIllIIIlIlI = new Random(lllllllllllIIIlllIlIIlIlIllIlIlI);
        if (lllllllllllIIIlllIlIIlIlIlIlllll <= 0) {
            final int lllllllllllIIIlllIlIIlIllIIIlIIl = this.range * 16 - 16;
            lllllllllllIIIlllIlIIlIlIlIlllll = lllllllllllIIIlllIlIIlIllIIIlIIl - lllllllllllIIIlllIlIIlIllIIIlIlI.nextInt(lllllllllllIIIlllIlIIlIllIIIlIIl / 4);
        }
        boolean lllllllllllIIIlllIlIIlIllIIIlIII = false;
        if (lllllllllllIIIlllIlIIlIlIllIIIII == -1) {
            lllllllllllIIIlllIlIIlIlIllIIIII = (int)(lllllllllllIIIlllIlIIlIlIlIlllll / 2);
            lllllllllllIIIlllIlIIlIllIIIlIII = true;
        }
        final int lllllllllllIIIlllIlIIlIllIIIIlll = (int)(lllllllllllIIIlllIlIIlIllIIIlIlI.nextInt((int)(lllllllllllIIIlllIlIIlIlIlIlllll / 2)) + lllllllllllIIIlllIlIIlIlIlIlllll / 4);
        final boolean lllllllllllIIIlllIlIIlIllIIIIllI = lllllllllllIIIlllIlIIlIllIIIlIlI.nextInt(6) == 0;
        while (lllllllllllIIIlllIlIIlIlIllIIIII < lllllllllllIIIlllIlIIlIlIlIlllll) {
            final double lllllllllllIIIlllIlIIlIllIIIIlIl = 1.5 + MathHelper.sin(lllllllllllIIIlllIlIIlIlIllIIIII * 3.1415927f / lllllllllllIIIlllIlIIlIlIlIlllll) * lllllllllllIIIlllIlIIlIllIIlIlII;
            final double lllllllllllIIIlllIlIIlIllIIIIlII = lllllllllllIIIlllIlIIlIllIIIIlIl * lllllllllllIIIlllIlIIlIlIlIllllI;
            final float lllllllllllIIIlllIlIIlIllIIIIIll = MathHelper.cos(lllllllllllIIIlllIlIIlIlIllIIIIl);
            final float lllllllllllIIIlllIlIIlIllIIIIIlI = MathHelper.sin(lllllllllllIIIlllIlIIlIlIllIIIIl);
            lllllllllllIIIlllIlIIlIlIllIIllI += MathHelper.cos((float)lllllllllllIIIlllIlIIlIlIllIIIlI) * lllllllllllIIIlllIlIIlIllIIIIIll;
            lllllllllllIIIlllIlIIlIlIllIIlIl += lllllllllllIIIlllIlIIlIllIIIIIlI;
            lllllllllllIIIlllIlIIlIlIllIIlII += MathHelper.sin((float)lllllllllllIIIlllIlIIlIlIllIIIlI) * lllllllllllIIIlllIlIIlIllIIIIIll;
            if (lllllllllllIIIlllIlIIlIllIIIIllI) {
                lllllllllllIIIlllIlIIlIlIllIIIIl *= 0.92f;
            }
            else {
                lllllllllllIIIlllIlIIlIlIllIIIIl *= 0.7f;
            }
            lllllllllllIIIlllIlIIlIlIllIIIIl += lllllllllllIIIlllIlIIlIllIIIlIll * 0.1f;
            lllllllllllIIIlllIlIIlIlIllIIIlI += lllllllllllIIIlllIlIIlIllIIIllII * 0.1f;
            lllllllllllIIIlllIlIIlIllIIIlIll *= 0.9f;
            lllllllllllIIIlllIlIIlIllIIIllII *= 0.75f;
            lllllllllllIIIlllIlIIlIllIIIlIll += (lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() - lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat()) * lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() * 2.0f;
            lllllllllllIIIlllIlIIlIllIIIllII += (lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() - lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat()) * lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() * 4.0f;
            if (!lllllllllllIIIlllIlIIlIllIIIlIII && lllllllllllIIIlllIlIIlIlIllIIIII == lllllllllllIIIlllIlIIlIllIIIIlll && lllllllllllIIIlllIlIIlIllIIlIlII > 1.0f) {
                this.addTunnel(lllllllllllIIIlllIlIIlIllIIIlIlI.nextLong(), lllllllllllIIIlllIlIIlIllIIllIlI, lllllllllllIIIlllIlIIlIlIllIlIII, lllllllllllIIIlllIlIIlIllIIllIII, lllllllllllIIIlllIlIIlIlIllIIllI, lllllllllllIIIlllIlIIlIlIllIIlIl, lllllllllllIIIlllIlIIlIlIllIIlII, lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() * 0.5f + 0.5f, (float)(lllllllllllIIIlllIlIIlIlIllIIIlI - 1.5707964f), lllllllllllIIIlllIlIIlIlIllIIIIl / 3.0f, lllllllllllIIIlllIlIIlIlIllIIIII, (int)lllllllllllIIIlllIlIIlIlIlIlllll, 1.0);
                this.addTunnel(lllllllllllIIIlllIlIIlIllIIIlIlI.nextLong(), lllllllllllIIIlllIlIIlIllIIllIlI, lllllllllllIIIlllIlIIlIlIllIlIII, lllllllllllIIIlllIlIIlIllIIllIII, lllllllllllIIIlllIlIIlIlIllIIllI, lllllllllllIIIlllIlIIlIlIllIIlIl, lllllllllllIIIlllIlIIlIlIllIIlII, lllllllllllIIIlllIlIIlIllIIIlIlI.nextFloat() * 0.5f + 0.5f, (float)(lllllllllllIIIlllIlIIlIlIllIIIlI + 1.5707964f), lllllllllllIIIlllIlIIlIlIllIIIIl / 3.0f, lllllllllllIIIlllIlIIlIlIllIIIII, (int)lllllllllllIIIlllIlIIlIlIlIlllll, 1.0);
                return;
            }
            if (lllllllllllIIIlllIlIIlIllIIIlIII || lllllllllllIIIlllIlIIlIllIIIlIlI.nextInt(4) != 0) {
                final double lllllllllllIIIlllIlIIlIllIIIIIIl = lllllllllllIIIlllIlIIlIlIllIIllI - lllllllllllIIIlllIlIIlIllIIIlllI;
                final double lllllllllllIIIlllIlIIlIllIIIIIII = lllllllllllIIIlllIlIIlIlIllIIlII - lllllllllllIIIlllIlIIlIllIIIllIl;
                final double lllllllllllIIIlllIlIIlIlIlllllll = lllllllllllIIIlllIlIIlIlIlIlllll - lllllllllllIIIlllIlIIlIlIllIIIII;
                final double lllllllllllIIIlllIlIIlIlIllllllI = lllllllllllIIIlllIlIIlIllIIlIlII + 2.0f + 16.0f;
                if (lllllllllllIIIlllIlIIlIllIIIIIIl * lllllllllllIIIlllIlIIlIllIIIIIIl + lllllllllllIIIlllIlIIlIllIIIIIII * lllllllllllIIIlllIlIIlIllIIIIIII - lllllllllllIIIlllIlIIlIlIlllllll * lllllllllllIIIlllIlIIlIlIlllllll > lllllllllllIIIlllIlIIlIlIllllllI * lllllllllllIIIlllIlIIlIlIllllllI) {
                    return;
                }
                if (lllllllllllIIIlllIlIIlIlIllIIllI >= lllllllllllIIIlllIlIIlIllIIIlllI - 16.0 - lllllllllllIIIlllIlIIlIllIIIIlIl * 2.0 && lllllllllllIIIlllIlIIlIlIllIIlII >= lllllllllllIIIlllIlIIlIllIIIllIl - 16.0 - lllllllllllIIIlllIlIIlIllIIIIlIl * 2.0 && lllllllllllIIIlllIlIIlIlIllIIllI <= lllllllllllIIIlllIlIIlIllIIIlllI + 16.0 + lllllllllllIIIlllIlIIlIllIIIIlIl * 2.0 && lllllllllllIIIlllIlIIlIlIllIIlII <= lllllllllllIIIlllIlIIlIllIIIllIl + 16.0 + lllllllllllIIIlllIlIIlIllIIIIlIl * 2.0) {
                    int lllllllllllIIIlllIlIIlIlIlllllIl = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIllI - lllllllllllIIIlllIlIIlIllIIIIlIl) - lllllllllllIIIlllIlIIlIllIIllIlI * 16 - 1;
                    int lllllllllllIIIlllIlIIlIlIlllllII = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIllI + lllllllllllIIIlllIlIIlIllIIIIlIl) - lllllllllllIIIlllIlIIlIllIIllIlI * 16 + 1;
                    int lllllllllllIIIlllIlIIlIlIllllIll = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIlIl - lllllllllllIIIlllIlIIlIllIIIIlII) - 1;
                    int lllllllllllIIIlllIlIIlIlIllllIlI = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIlIl + lllllllllllIIIlllIlIIlIllIIIIlII) + 1;
                    int lllllllllllIIIlllIlIIlIlIllllIIl = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIlII - lllllllllllIIIlllIlIIlIllIIIIlIl) - lllllllllllIIIlllIlIIlIlIllIlIII * 16 - 1;
                    int lllllllllllIIIlllIlIIlIlIllllIII = MathHelper.floor(lllllllllllIIIlllIlIIlIlIllIIlII + lllllllllllIIIlllIlIIlIllIIIIlIl) - lllllllllllIIIlllIlIIlIlIllIlIII * 16 + 1;
                    if (lllllllllllIIIlllIlIIlIlIlllllIl < 0) {
                        lllllllllllIIIlllIlIIlIlIlllllIl = 0;
                    }
                    if (lllllllllllIIIlllIlIIlIlIlllllII > 16) {
                        lllllllllllIIIlllIlIIlIlIlllllII = 16;
                    }
                    if (lllllllllllIIIlllIlIIlIlIllllIll < 1) {
                        lllllllllllIIIlllIlIIlIlIllllIll = 1;
                    }
                    if (lllllllllllIIIlllIlIIlIlIllllIlI > 120) {
                        lllllllllllIIIlllIlIIlIlIllllIlI = 120;
                    }
                    if (lllllllllllIIIlllIlIIlIlIllllIIl < 0) {
                        lllllllllllIIIlllIlIIlIlIllllIIl = 0;
                    }
                    if (lllllllllllIIIlllIlIIlIlIllllIII > 16) {
                        lllllllllllIIIlllIlIIlIlIllllIII = 16;
                    }
                    boolean lllllllllllIIIlllIlIIlIlIlllIlll = false;
                    for (int lllllllllllIIIlllIlIIlIlIlllIllI = lllllllllllIIIlllIlIIlIlIlllllIl; !lllllllllllIIIlllIlIIlIlIlllIlll && lllllllllllIIIlllIlIIlIlIlllIllI < lllllllllllIIIlllIlIIlIlIlllllII; ++lllllllllllIIIlllIlIIlIlIlllIllI) {
                        for (int lllllllllllIIIlllIlIIlIlIlllIlIl = lllllllllllIIIlllIlIIlIlIllllIIl; !lllllllllllIIIlllIlIIlIlIlllIlll && lllllllllllIIIlllIlIIlIlIlllIlIl < lllllllllllIIIlllIlIIlIlIllllIII; ++lllllllllllIIIlllIlIIlIlIlllIlIl) {
                            for (int lllllllllllIIIlllIlIIlIlIlllIlII = lllllllllllIIIlllIlIIlIlIllllIlI + 1; !lllllllllllIIIlllIlIIlIlIlllIlll && lllllllllllIIIlllIlIIlIlIlllIlII >= lllllllllllIIIlllIlIIlIlIllllIll - 1; --lllllllllllIIIlllIlIIlIlIlllIlII) {
                                if (lllllllllllIIIlllIlIIlIlIlllIlII >= 0 && lllllllllllIIIlllIlIIlIlIlllIlII < 128) {
                                    final IBlockState lllllllllllIIIlllIlIIlIlIlllIIll = lllllllllllIIIlllIlIIlIllIIllIII.getBlockState(lllllllllllIIIlllIlIIlIlIlllIllI, lllllllllllIIIlllIlIIlIlIlllIlII, lllllllllllIIIlllIlIIlIlIlllIlIl);
                                    if (lllllllllllIIIlllIlIIlIlIlllIIll.getBlock() == Blocks.FLOWING_LAVA || lllllllllllIIIlllIlIIlIlIlllIIll.getBlock() == Blocks.LAVA) {
                                        lllllllllllIIIlllIlIIlIlIlllIlll = true;
                                    }
                                    if (lllllllllllIIIlllIlIIlIlIlllIlII != lllllllllllIIIlllIlIIlIlIllllIll - 1 && lllllllllllIIIlllIlIIlIlIlllIllI != lllllllllllIIIlllIlIIlIlIlllllIl && lllllllllllIIIlllIlIIlIlIlllIllI != lllllllllllIIIlllIlIIlIlIlllllII - 1 && lllllllllllIIIlllIlIIlIlIlllIlIl != lllllllllllIIIlllIlIIlIlIllllIIl && lllllllllllIIIlllIlIIlIlIlllIlIl != lllllllllllIIIlllIlIIlIlIllllIII - 1) {
                                        lllllllllllIIIlllIlIIlIlIlllIlII = lllllllllllIIIlllIlIIlIlIllllIll;
                                    }
                                }
                            }
                        }
                    }
                    if (!lllllllllllIIIlllIlIIlIlIlllIlll) {
                        for (int lllllllllllIIIlllIlIIlIlIlllIIlI = lllllllllllIIIlllIlIIlIlIlllllIl; lllllllllllIIIlllIlIIlIlIlllIIlI < lllllllllllIIIlllIlIIlIlIlllllII; ++lllllllllllIIIlllIlIIlIlIlllIIlI) {
                            final double lllllllllllIIIlllIlIIlIlIlllIIIl = (lllllllllllIIIlllIlIIlIlIlllIIlI + lllllllllllIIIlllIlIIlIllIIllIlI * 16 + 0.5 - lllllllllllIIIlllIlIIlIlIllIIllI) / lllllllllllIIIlllIlIIlIllIIIIlIl;
                            for (int lllllllllllIIIlllIlIIlIlIlllIIII = lllllllllllIIIlllIlIIlIlIllllIIl; lllllllllllIIIlllIlIIlIlIlllIIII < lllllllllllIIIlllIlIIlIlIllllIII; ++lllllllllllIIIlllIlIIlIlIlllIIII) {
                                final double lllllllllllIIIlllIlIIlIlIllIllll = (lllllllllllIIIlllIlIIlIlIlllIIII + lllllllllllIIIlllIlIIlIlIllIlIII * 16 + 0.5 - lllllllllllIIIlllIlIIlIlIllIIlII) / lllllllllllIIIlllIlIIlIllIIIIlIl;
                                for (int lllllllllllIIIlllIlIIlIlIllIlllI = lllllllllllIIIlllIlIIlIlIllllIlI; lllllllllllIIIlllIlIIlIlIllIlllI > lllllllllllIIIlllIlIIlIlIllllIll; --lllllllllllIIIlllIlIIlIlIllIlllI) {
                                    final double lllllllllllIIIlllIlIIlIlIllIllIl = (lllllllllllIIIlllIlIIlIlIllIlllI - 1 + 0.5 - lllllllllllIIIlllIlIIlIlIllIIlIl) / lllllllllllIIIlllIlIIlIllIIIIlII;
                                    if (lllllllllllIIIlllIlIIlIlIllIllIl > -0.7 && lllllllllllIIIlllIlIIlIlIlllIIIl * lllllllllllIIIlllIlIIlIlIlllIIIl + lllllllllllIIIlllIlIIlIlIllIllIl * lllllllllllIIIlllIlIIlIlIllIllIl + lllllllllllIIIlllIlIIlIlIllIllll * lllllllllllIIIlllIlIIlIlIllIllll < 1.0) {
                                        final IBlockState lllllllllllIIIlllIlIIlIlIllIllII = lllllllllllIIIlllIlIIlIllIIllIII.getBlockState(lllllllllllIIIlllIlIIlIlIlllIIlI, lllllllllllIIIlllIlIIlIlIllIlllI, lllllllllllIIIlllIlIIlIlIlllIIII);
                                        if (lllllllllllIIIlllIlIIlIlIllIllII.getBlock() == Blocks.NETHERRACK || lllllllllllIIIlllIlIIlIlIllIllII.getBlock() == Blocks.DIRT || lllllllllllIIIlllIlIIlIlIllIllII.getBlock() == Blocks.GRASS) {
                                            lllllllllllIIIlllIlIIlIllIIllIII.setBlockState(lllllllllllIIIlllIlIIlIlIlllIIlI, lllllllllllIIIlllIlIIlIlIllIlllI, lllllllllllIIIlllIlIIlIlIlllIIII, MapGenCavesHell.AIR);
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllIIIlllIlIIlIllIIIlIII) {
                            break;
                        }
                    }
                }
            }
            ++lllllllllllIIIlllIlIIlIlIllIIIII;
        }
    }
}
