// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.block.state.IBlockState;

public class MapGenRavine extends MapGenBase
{
    protected static final /* synthetic */ IBlockState AIR;
    protected static final /* synthetic */ IBlockState FLOWING_LAVA;
    private final /* synthetic */ float[] rs;
    
    protected void addTunnel(final long lllllllllllIIlIIlIIllIlIIlIIlIIl, final int lllllllllllIIlIIlIIllIlIIlIIlIII, final int lllllllllllIIlIIlIIllIlIIlIIIlll, final ChunkPrimer lllllllllllIIlIIlIIllIlIIllllIIl, double lllllllllllIIlIIlIIllIlIIlIIIlIl, double lllllllllllIIlIIlIIllIlIIlIIIlII, double lllllllllllIIlIIlIIllIlIIlIIIIll, final float lllllllllllIIlIIlIIllIlIIlIIIIlI, float lllllllllllIIlIIlIIllIlIIlIIIIIl, float lllllllllllIIlIIlIIllIlIIlIIIIII, int lllllllllllIIlIIlIIllIlIIlllIIlI, int lllllllllllIIlIIlIIllIlIIlllIIIl, final double lllllllllllIIlIIlIIllIlIIIllllIl) {
        final Random lllllllllllIIlIIlIIllIlIIllIllll = new Random(lllllllllllIIlIIlIIllIlIIlIIlIIl);
        final double lllllllllllIIlIIlIIllIlIIllIlllI = lllllllllllIIlIIlIIllIlIIlIIlIII * 16 + 8;
        final double lllllllllllIIlIIlIIllIlIIllIllIl = lllllllllllIIlIIlIIllIlIIlIIIlll * 16 + 8;
        float lllllllllllIIlIIlIIllIlIIllIllII = 0.0f;
        float lllllllllllIIlIIlIIllIlIIllIlIll = 0.0f;
        if (lllllllllllIIlIIlIIllIlIIlllIIIl <= 0) {
            final int lllllllllllIIlIIlIIllIlIIllIlIlI = this.range * 16 - 16;
            lllllllllllIIlIIlIIllIlIIlllIIIl = lllllllllllIIlIIlIIllIlIIllIlIlI - lllllllllllIIlIIlIIllIlIIllIllll.nextInt(lllllllllllIIlIIlIIllIlIIllIlIlI / 4);
        }
        boolean lllllllllllIIlIIlIIllIlIIllIlIIl = false;
        if (lllllllllllIIlIIlIIllIlIIlllIIlI == -1) {
            lllllllllllIIlIIlIIllIlIIlllIIlI = lllllllllllIIlIIlIIllIlIIlllIIIl / 2;
            lllllllllllIIlIIlIIllIlIIllIlIIl = true;
        }
        float lllllllllllIIlIIlIIllIlIIllIlIII = 1.0f;
        for (int lllllllllllIIlIIlIIllIlIIllIIlll = 0; lllllllllllIIlIIlIIllIlIIllIIlll < 256; ++lllllllllllIIlIIlIIllIlIIllIIlll) {
            if (lllllllllllIIlIIlIIllIlIIllIIlll == 0 || lllllllllllIIlIIlIIllIlIIllIllll.nextInt(3) == 0) {
                lllllllllllIIlIIlIIllIlIIllIlIII = 1.0f + lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() * lllllllllllIIlIIlIIllIlIIllIllll.nextFloat();
            }
            this.rs[lllllllllllIIlIIlIIllIlIIllIIlll] = lllllllllllIIlIIlIIllIlIIllIlIII * lllllllllllIIlIIlIIllIlIIllIlIII;
        }
        while (lllllllllllIIlIIlIIllIlIIlllIIlI < lllllllllllIIlIIlIIllIlIIlllIIIl) {
            double lllllllllllIIlIIlIIllIlIIllIIllI = 1.5 + MathHelper.sin(lllllllllllIIlIIlIIllIlIIlllIIlI * 3.1415927f / lllllllllllIIlIIlIIllIlIIlllIIIl) * lllllllllllIIlIIlIIllIlIIlIIIIlI;
            double lllllllllllIIlIIlIIllIlIIllIIlIl = lllllllllllIIlIIlIIllIlIIllIIllI * lllllllllllIIlIIlIIllIlIIIllllIl;
            lllllllllllIIlIIlIIllIlIIllIIllI *= lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() * 0.25 + 0.75;
            lllllllllllIIlIIlIIllIlIIllIIlIl *= lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() * 0.25 + 0.75;
            final float lllllllllllIIlIIlIIllIlIIllIIlII = MathHelper.cos(lllllllllllIIlIIlIIllIlIIlIIIIII);
            final float lllllllllllIIlIIlIIllIlIIllIIIll = MathHelper.sin(lllllllllllIIlIIlIIllIlIIlIIIIII);
            lllllllllllIIlIIlIIllIlIIlIIIlIl += MathHelper.cos((float)lllllllllllIIlIIlIIllIlIIlIIIIIl) * lllllllllllIIlIIlIIllIlIIllIIlII;
            lllllllllllIIlIIlIIllIlIIlIIIlII += lllllllllllIIlIIlIIllIlIIllIIIll;
            lllllllllllIIlIIlIIllIlIIlIIIIll += MathHelper.sin((float)lllllllllllIIlIIlIIllIlIIlIIIIIl) * lllllllllllIIlIIlIIllIlIIllIIlII;
            lllllllllllIIlIIlIIllIlIIlIIIIII *= 0.7f;
            lllllllllllIIlIIlIIllIlIIlIIIIII += lllllllllllIIlIIlIIllIlIIllIlIll * 0.05f;
            lllllllllllIIlIIlIIllIlIIlIIIIIl += lllllllllllIIlIIlIIllIlIIllIllII * 0.05f;
            lllllllllllIIlIIlIIllIlIIllIlIll *= 0.8f;
            lllllllllllIIlIIlIIllIlIIllIllII *= 0.5f;
            lllllllllllIIlIIlIIllIlIIllIlIll += (lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() - lllllllllllIIlIIlIIllIlIIllIllll.nextFloat()) * lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() * 2.0f;
            lllllllllllIIlIIlIIllIlIIllIllII += (lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() - lllllllllllIIlIIlIIllIlIIllIllll.nextFloat()) * lllllllllllIIlIIlIIllIlIIllIllll.nextFloat() * 4.0f;
            if (lllllllllllIIlIIlIIllIlIIllIlIIl || lllllllllllIIlIIlIIllIlIIllIllll.nextInt(4) != 0) {
                final double lllllllllllIIlIIlIIllIlIIllIIIlI = (double)(lllllllllllIIlIIlIIllIlIIlIIIlIl - lllllllllllIIlIIlIIllIlIIllIlllI);
                final double lllllllllllIIlIIlIIllIlIIllIIIIl = lllllllllllIIlIIlIIllIlIIlIIIIll - lllllllllllIIlIIlIIllIlIIllIllIl;
                final double lllllllllllIIlIIlIIllIlIIllIIIII = lllllllllllIIlIIlIIllIlIIlllIIIl - lllllllllllIIlIIlIIllIlIIlllIIlI;
                final double lllllllllllIIlIIlIIllIlIIlIlllll = lllllllllllIIlIIlIIllIlIIlIIIIlI + 2.0f + 16.0f;
                if (lllllllllllIIlIIlIIllIlIIllIIIlI * lllllllllllIIlIIlIIllIlIIllIIIlI + lllllllllllIIlIIlIIllIlIIllIIIIl * lllllllllllIIlIIlIIllIlIIllIIIIl - lllllllllllIIlIIlIIllIlIIllIIIII * lllllllllllIIlIIlIIllIlIIllIIIII > lllllllllllIIlIIlIIllIlIIlIlllll * lllllllllllIIlIIlIIllIlIIlIlllll) {
                    return;
                }
                if (lllllllllllIIlIIlIIllIlIIlIIIlIl >= lllllllllllIIlIIlIIllIlIIllIlllI - 16.0 - lllllllllllIIlIIlIIllIlIIllIIllI * 2.0 && lllllllllllIIlIIlIIllIlIIlIIIIll >= lllllllllllIIlIIlIIllIlIIllIllIl - 16.0 - lllllllllllIIlIIlIIllIlIIllIIllI * 2.0 && lllllllllllIIlIIlIIllIlIIlIIIlIl <= lllllllllllIIlIIlIIllIlIIllIlllI + 16.0 + lllllllllllIIlIIlIIllIlIIllIIllI * 2.0 && lllllllllllIIlIIlIIllIlIIlIIIIll <= lllllllllllIIlIIlIIllIlIIllIllIl + 16.0 + lllllllllllIIlIIlIIllIlIIllIIllI * 2.0) {
                    int lllllllllllIIlIIlIIllIlIIlIllllI = MathHelper.floor((double)(lllllllllllIIlIIlIIllIlIIlIIIlIl - lllllllllllIIlIIlIIllIlIIllIIllI)) - lllllllllllIIlIIlIIllIlIIlIIlIII * 16 - 1;
                    int lllllllllllIIlIIlIIllIlIIlIlllIl = MathHelper.floor((double)(lllllllllllIIlIIlIIllIlIIlIIIlIl + lllllllllllIIlIIlIIllIlIIllIIllI)) - lllllllllllIIlIIlIIllIlIIlIIlIII * 16 + 1;
                    int lllllllllllIIlIIlIIllIlIIlIlllII = MathHelper.floor(lllllllllllIIlIIlIIllIlIIlIIIlII - lllllllllllIIlIIlIIllIlIIllIIlIl) - 1;
                    int lllllllllllIIlIIlIIllIlIIlIllIll = MathHelper.floor(lllllllllllIIlIIlIIllIlIIlIIIlII + lllllllllllIIlIIlIIllIlIIllIIlIl) + 1;
                    int lllllllllllIIlIIlIIllIlIIlIllIlI = MathHelper.floor(lllllllllllIIlIIlIIllIlIIlIIIIll - lllllllllllIIlIIlIIllIlIIllIIllI) - lllllllllllIIlIIlIIllIlIIlIIIlll * 16 - 1;
                    int lllllllllllIIlIIlIIllIlIIlIllIIl = MathHelper.floor(lllllllllllIIlIIlIIllIlIIlIIIIll + lllllllllllIIlIIlIIllIlIIllIIllI) - lllllllllllIIlIIlIIllIlIIlIIIlll * 16 + 1;
                    if (lllllllllllIIlIIlIIllIlIIlIllllI < 0) {
                        lllllllllllIIlIIlIIllIlIIlIllllI = 0;
                    }
                    if (lllllllllllIIlIIlIIllIlIIlIlllIl > 16) {
                        lllllllllllIIlIIlIIllIlIIlIlllIl = 16;
                    }
                    if (lllllllllllIIlIIlIIllIlIIlIlllII < 1) {
                        lllllllllllIIlIIlIIllIlIIlIlllII = 1;
                    }
                    if (lllllllllllIIlIIlIIllIlIIlIllIll > 248) {
                        lllllllllllIIlIIlIIllIlIIlIllIll = 248;
                    }
                    if (lllllllllllIIlIIlIIllIlIIlIllIlI < 0) {
                        lllllllllllIIlIIlIIllIlIIlIllIlI = 0;
                    }
                    if (lllllllllllIIlIIlIIllIlIIlIllIIl > 16) {
                        lllllllllllIIlIIlIIllIlIIlIllIIl = 16;
                    }
                    boolean lllllllllllIIlIIlIIllIlIIlIllIII = false;
                    for (int lllllllllllIIlIIlIIllIlIIlIlIlll = lllllllllllIIlIIlIIllIlIIlIllllI; !lllllllllllIIlIIlIIllIlIIlIllIII && lllllllllllIIlIIlIIllIlIIlIlIlll < lllllllllllIIlIIlIIllIlIIlIlllIl; ++lllllllllllIIlIIlIIllIlIIlIlIlll) {
                        for (int lllllllllllIIlIIlIIllIlIIlIlIllI = lllllllllllIIlIIlIIllIlIIlIllIlI; !lllllllllllIIlIIlIIllIlIIlIllIII && lllllllllllIIlIIlIIllIlIIlIlIllI < lllllllllllIIlIIlIIllIlIIlIllIIl; ++lllllllllllIIlIIlIIllIlIIlIlIllI) {
                            for (int lllllllllllIIlIIlIIllIlIIlIlIlIl = lllllllllllIIlIIlIIllIlIIlIllIll + 1; !lllllllllllIIlIIlIIllIlIIlIllIII && lllllllllllIIlIIlIIllIlIIlIlIlIl >= lllllllllllIIlIIlIIllIlIIlIlllII - 1; --lllllllllllIIlIIlIIllIlIIlIlIlIl) {
                                if (lllllllllllIIlIIlIIllIlIIlIlIlIl >= 0 && lllllllllllIIlIIlIIllIlIIlIlIlIl < 256) {
                                    final IBlockState lllllllllllIIlIIlIIllIlIIlIlIlII = lllllllllllIIlIIlIIllIlIIllllIIl.getBlockState(lllllllllllIIlIIlIIllIlIIlIlIlll, lllllllllllIIlIIlIIllIlIIlIlIlIl, lllllllllllIIlIIlIIllIlIIlIlIllI);
                                    if (lllllllllllIIlIIlIIllIlIIlIlIlII.getBlock() == Blocks.FLOWING_WATER || lllllllllllIIlIIlIIllIlIIlIlIlII.getBlock() == Blocks.WATER) {
                                        lllllllllllIIlIIlIIllIlIIlIllIII = true;
                                    }
                                    if (lllllllllllIIlIIlIIllIlIIlIlIlIl != lllllllllllIIlIIlIIllIlIIlIlllII - 1 && lllllllllllIIlIIlIIllIlIIlIlIlll != lllllllllllIIlIIlIIllIlIIlIllllI && lllllllllllIIlIIlIIllIlIIlIlIlll != lllllllllllIIlIIlIIllIlIIlIlllIl - 1 && lllllllllllIIlIIlIIllIlIIlIlIllI != lllllllllllIIlIIlIIllIlIIlIllIlI && lllllllllllIIlIIlIIllIlIIlIlIllI != lllllllllllIIlIIlIIllIlIIlIllIIl - 1) {
                                        lllllllllllIIlIIlIIllIlIIlIlIlIl = lllllllllllIIlIIlIIllIlIIlIlllII;
                                    }
                                }
                            }
                        }
                    }
                    if (!lllllllllllIIlIIlIIllIlIIlIllIII) {
                        final BlockPos.MutableBlockPos lllllllllllIIlIIlIIllIlIIlIlIIll = new BlockPos.MutableBlockPos();
                        for (int lllllllllllIIlIIlIIllIlIIlIlIIlI = lllllllllllIIlIIlIIllIlIIlIllllI; lllllllllllIIlIIlIIllIlIIlIlIIlI < lllllllllllIIlIIlIIllIlIIlIlllIl; ++lllllllllllIIlIIlIIllIlIIlIlIIlI) {
                            final double lllllllllllIIlIIlIIllIlIIlIlIIIl = (double)((lllllllllllIIlIIlIIllIlIIlIlIIlI + lllllllllllIIlIIlIIllIlIIlIIlIII * 16 + 0.5 - lllllllllllIIlIIlIIllIlIIlIIIlIl) / lllllllllllIIlIIlIIllIlIIllIIllI);
                            for (int lllllllllllIIlIIlIIllIlIIlIlIIII = lllllllllllIIlIIlIIllIlIIlIllIlI; lllllllllllIIlIIlIIllIlIIlIlIIII < lllllllllllIIlIIlIIllIlIIlIllIIl; ++lllllllllllIIlIIlIIllIlIIlIlIIII) {
                                final double lllllllllllIIlIIlIIllIlIIlIIllll = (lllllllllllIIlIIlIIllIlIIlIlIIII + lllllllllllIIlIIlIIllIlIIlIIIlll * 16 + 0.5 - lllllllllllIIlIIlIIllIlIIlIIIIll) / lllllllllllIIlIIlIIllIlIIllIIllI;
                                boolean lllllllllllIIlIIlIIllIlIIlIIlllI = false;
                                if (lllllllllllIIlIIlIIllIlIIlIlIIIl * lllllllllllIIlIIlIIllIlIIlIlIIIl + lllllllllllIIlIIlIIllIlIIlIIllll * lllllllllllIIlIIlIIllIlIIlIIllll < 1.0) {
                                    for (int lllllllllllIIlIIlIIllIlIIlIIllIl = lllllllllllIIlIIlIIllIlIIlIllIll; lllllllllllIIlIIlIIllIlIIlIIllIl > lllllllllllIIlIIlIIllIlIIlIlllII; --lllllllllllIIlIIlIIllIlIIlIIllIl) {
                                        final double lllllllllllIIlIIlIIllIlIIlIIllII = (lllllllllllIIlIIlIIllIlIIlIIllIl - 1 + 0.5 - lllllllllllIIlIIlIIllIlIIlIIIlII) / lllllllllllIIlIIlIIllIlIIllIIlIl;
                                        if ((lllllllllllIIlIIlIIllIlIIlIlIIIl * lllllllllllIIlIIlIIllIlIIlIlIIIl + lllllllllllIIlIIlIIllIlIIlIIllll * lllllllllllIIlIIlIIllIlIIlIIllll) * this.rs[lllllllllllIIlIIlIIllIlIIlIIllIl - 1] + lllllllllllIIlIIlIIllIlIIlIIllII * lllllllllllIIlIIlIIllIlIIlIIllII / 6.0 < 1.0) {
                                            final IBlockState lllllllllllIIlIIlIIllIlIIlIIlIll = lllllllllllIIlIIlIIllIlIIllllIIl.getBlockState(lllllllllllIIlIIlIIllIlIIlIlIIlI, lllllllllllIIlIIlIIllIlIIlIIllIl, lllllllllllIIlIIlIIllIlIIlIlIIII);
                                            if (lllllllllllIIlIIlIIllIlIIlIIlIll.getBlock() == Blocks.GRASS) {
                                                lllllllllllIIlIIlIIllIlIIlIIlllI = true;
                                            }
                                            if (lllllllllllIIlIIlIIllIlIIlIIlIll.getBlock() == Blocks.STONE || lllllllllllIIlIIlIIllIlIIlIIlIll.getBlock() == Blocks.DIRT || lllllllllllIIlIIlIIllIlIIlIIlIll.getBlock() == Blocks.GRASS) {
                                                if (lllllllllllIIlIIlIIllIlIIlIIllIl - 1 < 10) {
                                                    lllllllllllIIlIIlIIllIlIIllllIIl.setBlockState(lllllllllllIIlIIlIIllIlIIlIlIIlI, lllllllllllIIlIIlIIllIlIIlIIllIl, lllllllllllIIlIIlIIllIlIIlIlIIII, MapGenRavine.FLOWING_LAVA);
                                                }
                                                else {
                                                    lllllllllllIIlIIlIIllIlIIllllIIl.setBlockState(lllllllllllIIlIIlIIllIlIIlIlIIlI, lllllllllllIIlIIlIIllIlIIlIIllIl, lllllllllllIIlIIlIIllIlIIlIlIIII, MapGenRavine.AIR);
                                                    if (lllllllllllIIlIIlIIllIlIIlIIlllI && lllllllllllIIlIIlIIllIlIIllllIIl.getBlockState(lllllllllllIIlIIlIIllIlIIlIlIIlI, lllllllllllIIlIIlIIllIlIIlIIllIl - 1, lllllllllllIIlIIlIIllIlIIlIlIIII).getBlock() == Blocks.DIRT) {
                                                        lllllllllllIIlIIlIIllIlIIlIlIIll.setPos(lllllllllllIIlIIlIIllIlIIlIlIIlI + lllllllllllIIlIIlIIllIlIIlIIlIII * 16, 0, lllllllllllIIlIIlIIllIlIIlIlIIII + lllllllllllIIlIIlIIllIlIIlIIIlll * 16);
                                                        lllllllllllIIlIIlIIllIlIIllllIIl.setBlockState(lllllllllllIIlIIlIIllIlIIlIlIIlI, lllllllllllIIlIIlIIllIlIIlIIllIl - 1, lllllllllllIIlIIlIIllIlIIlIlIIII, this.worldObj.getBiome(lllllllllllIIlIIlIIllIlIIlIlIIll).topBlock);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (lllllllllllIIlIIlIIllIlIIllIlIIl) {
                            break;
                        }
                    }
                }
            }
            ++lllllllllllIIlIIlIIllIlIIlllIIlI;
        }
    }
    
    public MapGenRavine() {
        this.rs = new float[1024];
    }
    
    @Override
    protected void recursiveGenerate(final World lllllllllllIIlIIlIIllIlIIIIIllIl, final int lllllllllllIIlIIlIIllIIllllllllI, final int lllllllllllIIlIIlIIllIlIIIIIlIll, final int lllllllllllIIlIIlIIllIIlllllllII, final int lllllllllllIIlIIlIIllIIllllllIll, final ChunkPrimer lllllllllllIIlIIlIIllIlIIIIIlIII) {
        if (this.rand.nextInt(50) == 0) {
            final double lllllllllllIIlIIlIIllIlIIIIIIlll = lllllllllllIIlIIlIIllIIllllllllI * 16 + this.rand.nextInt(16);
            final double lllllllllllIIlIIlIIllIlIIIIIIllI = this.rand.nextInt(this.rand.nextInt(40) + 8) + 20;
            final double lllllllllllIIlIIlIIllIlIIIIIIlIl = lllllllllllIIlIIlIIllIlIIIIIlIll * 16 + this.rand.nextInt(16);
            final int lllllllllllIIlIIlIIllIlIIIIIIlII = 1;
            for (int lllllllllllIIlIIlIIllIlIIIIIIIll = 0; lllllllllllIIlIIlIIllIlIIIIIIIll < 1; ++lllllllllllIIlIIlIIllIlIIIIIIIll) {
                final float lllllllllllIIlIIlIIllIlIIIIIIIlI = this.rand.nextFloat() * 6.2831855f;
                final float lllllllllllIIlIIlIIllIlIIIIIIIIl = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                final float lllllllllllIIlIIlIIllIlIIIIIIIII = (this.rand.nextFloat() * 2.0f + this.rand.nextFloat()) * 2.0f;
                this.addTunnel(this.rand.nextLong(), lllllllllllIIlIIlIIllIIlllllllII, lllllllllllIIlIIlIIllIIllllllIll, lllllllllllIIlIIlIIllIlIIIIIlIII, lllllllllllIIlIIlIIllIlIIIIIIlll, lllllllllllIIlIIlIIllIlIIIIIIllI, lllllllllllIIlIIlIIllIlIIIIIIlIl, lllllllllllIIlIIlIIllIlIIIIIIIII, lllllllllllIIlIIlIIllIlIIIIIIIlI, lllllllllllIIlIIlIIllIlIIIIIIIIl, 0, 0, 3.0);
            }
        }
    }
    
    static {
        FLOWING_LAVA = Blocks.FLOWING_LAVA.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
    }
}
