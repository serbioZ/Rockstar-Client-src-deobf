// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import com.google.common.base.MoreObjects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.block.state.IBlockState;

public class MapGenCaves extends MapGenBase
{
    protected static final /* synthetic */ IBlockState BLK_LAVA;
    protected static final /* synthetic */ IBlockState BLK_AIR;
    
    protected void addTunnel(final long llllllllllllIlIlIllIIlIlIIIIlIII, final int llllllllllllIlIlIllIIlIlIIlllIll, final int llllllllllllIlIlIllIIlIlIIIIIllI, final ChunkPrimer llllllllllllIlIlIllIIlIlIIlllIIl, double llllllllllllIlIlIllIIlIlIIIIIlII, double llllllllllllIlIlIllIIlIlIIIIIIll, double llllllllllllIlIlIllIIlIlIIIIIIlI, final float llllllllllllIlIlIllIIlIlIIIIIIIl, float llllllllllllIlIlIllIIlIlIIIIIIII, float llllllllllllIlIlIllIIlIIllllllll, int llllllllllllIlIlIllIIlIIlllllllI, int llllllllllllIlIlIllIIlIIllllllIl, final double llllllllllllIlIlIllIIlIIllllllII) {
        final double llllllllllllIlIlIllIIlIlIIlIllll = llllllllllllIlIlIllIIlIlIIlllIll * 16 + 8;
        final double llllllllllllIlIlIllIIlIlIIlIlllI = llllllllllllIlIlIllIIlIlIIIIIllI * 16 + 8;
        float llllllllllllIlIlIllIIlIlIIlIllIl = 0.0f;
        float llllllllllllIlIlIllIIlIlIIlIllII = 0.0f;
        final Random llllllllllllIlIlIllIIlIlIIlIlIll = new Random(llllllllllllIlIlIllIIlIlIIIIlIII);
        if (llllllllllllIlIlIllIIlIIllllllIl <= 0) {
            final int llllllllllllIlIlIllIIlIlIIlIlIlI = this.range * 16 - 16;
            llllllllllllIlIlIllIIlIIllllllIl = llllllllllllIlIlIllIIlIlIIlIlIlI - llllllllllllIlIlIllIIlIlIIlIlIll.nextInt(llllllllllllIlIlIllIIlIlIIlIlIlI / 4);
        }
        boolean llllllllllllIlIlIllIIlIlIIlIlIIl = false;
        if (llllllllllllIlIlIllIIlIIlllllllI == -1) {
            llllllllllllIlIlIllIIlIIlllllllI = llllllllllllIlIlIllIIlIIllllllIl / 2;
            llllllllllllIlIlIllIIlIlIIlIlIIl = true;
        }
        final int llllllllllllIlIlIllIIlIlIIlIlIII = llllllllllllIlIlIllIIlIlIIlIlIll.nextInt(llllllllllllIlIlIllIIlIIllllllIl / 2) + llllllllllllIlIlIllIIlIIllllllIl / 4;
        final boolean llllllllllllIlIlIllIIlIlIIlIIlll = llllllllllllIlIlIllIIlIlIIlIlIll.nextInt(6) == 0;
        while (llllllllllllIlIlIllIIlIIlllllllI < llllllllllllIlIlIllIIlIIllllllIl) {
            final double llllllllllllIlIlIllIIlIlIIlIIllI = 1.5 + MathHelper.sin(llllllllllllIlIlIllIIlIIlllllllI * 3.1415927f / llllllllllllIlIlIllIIlIIllllllIl) * llllllllllllIlIlIllIIlIlIIIIIIIl;
            final double llllllllllllIlIlIllIIlIlIIlIIlIl = llllllllllllIlIlIllIIlIlIIlIIllI * llllllllllllIlIlIllIIlIIllllllII;
            final float llllllllllllIlIlIllIIlIlIIlIIlII = MathHelper.cos(llllllllllllIlIlIllIIlIIllllllll);
            final float llllllllllllIlIlIllIIlIlIIlIIIll = MathHelper.sin(llllllllllllIlIlIllIIlIIllllllll);
            llllllllllllIlIlIllIIlIlIIIIIlII += MathHelper.cos(llllllllllllIlIlIllIIlIlIIIIIIII) * llllllllllllIlIlIllIIlIlIIlIIlII;
            llllllllllllIlIlIllIIlIlIIIIIIll += llllllllllllIlIlIllIIlIlIIlIIIll;
            llllllllllllIlIlIllIIlIlIIIIIIlI += MathHelper.sin(llllllllllllIlIlIllIIlIlIIIIIIII) * llllllllllllIlIlIllIIlIlIIlIIlII;
            if (llllllllllllIlIlIllIIlIlIIlIIlll) {
                llllllllllllIlIlIllIIlIIllllllll *= 0.92f;
            }
            else {
                llllllllllllIlIlIllIIlIIllllllll *= 0.7f;
            }
            llllllllllllIlIlIllIIlIIllllllll += llllllllllllIlIlIllIIlIlIIlIllII * 0.1f;
            llllllllllllIlIlIllIIlIlIIIIIIII += llllllllllllIlIlIllIIlIlIIlIllIl * 0.1f;
            llllllllllllIlIlIllIIlIlIIlIllII *= 0.9f;
            llllllllllllIlIlIllIIlIlIIlIllIl *= 0.75f;
            llllllllllllIlIlIllIIlIlIIlIllII += (llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() - llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat()) * llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() * 2.0f;
            llllllllllllIlIlIllIIlIlIIlIllIl += (llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() - llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat()) * llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() * 4.0f;
            if (!llllllllllllIlIlIllIIlIlIIlIlIIl && llllllllllllIlIlIllIIlIIlllllllI == llllllllllllIlIlIllIIlIlIIlIlIII && llllllllllllIlIlIllIIlIlIIIIIIIl > 1.0f && llllllllllllIlIlIllIIlIIllllllIl > 0) {
                this.addTunnel(llllllllllllIlIlIllIIlIlIIlIlIll.nextLong(), llllllllllllIlIlIllIIlIlIIlllIll, llllllllllllIlIlIllIIlIlIIIIIllI, llllllllllllIlIlIllIIlIlIIlllIIl, llllllllllllIlIlIllIIlIlIIIIIlII, llllllllllllIlIlIllIIlIlIIIIIIll, llllllllllllIlIlIllIIlIlIIIIIIlI, llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() * 0.5f + 0.5f, llllllllllllIlIlIllIIlIlIIIIIIII - 1.5707964f, llllllllllllIlIlIllIIlIIllllllll / 3.0f, llllllllllllIlIlIllIIlIIlllllllI, llllllllllllIlIlIllIIlIIllllllIl, 1.0);
                this.addTunnel(llllllllllllIlIlIllIIlIlIIlIlIll.nextLong(), llllllllllllIlIlIllIIlIlIIlllIll, llllllllllllIlIlIllIIlIlIIIIIllI, llllllllllllIlIlIllIIlIlIIlllIIl, llllllllllllIlIlIllIIlIlIIIIIlII, llllllllllllIlIlIllIIlIlIIIIIIll, llllllllllllIlIlIllIIlIlIIIIIIlI, llllllllllllIlIlIllIIlIlIIlIlIll.nextFloat() * 0.5f + 0.5f, llllllllllllIlIlIllIIlIlIIIIIIII + 1.5707964f, llllllllllllIlIlIllIIlIIllllllll / 3.0f, llllllllllllIlIlIllIIlIIlllllllI, llllllllllllIlIlIllIIlIIllllllIl, 1.0);
                return;
            }
            if (llllllllllllIlIlIllIIlIlIIlIlIIl || llllllllllllIlIlIllIIlIlIIlIlIll.nextInt(4) != 0) {
                final double llllllllllllIlIlIllIIlIlIIlIIIlI = llllllllllllIlIlIllIIlIlIIIIIlII - llllllllllllIlIlIllIIlIlIIlIllll;
                final double llllllllllllIlIlIllIIlIlIIlIIIIl = llllllllllllIlIlIllIIlIlIIIIIIlI - llllllllllllIlIlIllIIlIlIIlIlllI;
                final double llllllllllllIlIlIllIIlIlIIlIIIII = llllllllllllIlIlIllIIlIIllllllIl - llllllllllllIlIlIllIIlIIlllllllI;
                final double llllllllllllIlIlIllIIlIlIIIlllll = llllllllllllIlIlIllIIlIlIIIIIIIl + 2.0f + 16.0f;
                if (llllllllllllIlIlIllIIlIlIIlIIIlI * llllllllllllIlIlIllIIlIlIIlIIIlI + llllllllllllIlIlIllIIlIlIIlIIIIl * llllllllllllIlIlIllIIlIlIIlIIIIl - llllllllllllIlIlIllIIlIlIIlIIIII * llllllllllllIlIlIllIIlIlIIlIIIII > llllllllllllIlIlIllIIlIlIIIlllll * llllllllllllIlIlIllIIlIlIIIlllll) {
                    return;
                }
                if (llllllllllllIlIlIllIIlIlIIIIIlII >= llllllllllllIlIlIllIIlIlIIlIllll - 16.0 - llllllllllllIlIlIllIIlIlIIlIIllI * 2.0 && llllllllllllIlIlIllIIlIlIIIIIIlI >= llllllllllllIlIlIllIIlIlIIlIlllI - 16.0 - llllllllllllIlIlIllIIlIlIIlIIllI * 2.0 && llllllllllllIlIlIllIIlIlIIIIIlII <= llllllllllllIlIlIllIIlIlIIlIllll + 16.0 + llllllllllllIlIlIllIIlIlIIlIIllI * 2.0 && llllllllllllIlIlIllIIlIlIIIIIIlI <= llllllllllllIlIlIllIIlIlIIlIlllI + 16.0 + llllllllllllIlIlIllIIlIlIIlIIllI * 2.0) {
                    int llllllllllllIlIlIllIIlIlIIIllllI = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIlII - llllllllllllIlIlIllIIlIlIIlIIllI) - llllllllllllIlIlIllIIlIlIIlllIll * 16 - 1;
                    int llllllllllllIlIlIllIIlIlIIIlllIl = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIlII + llllllllllllIlIlIllIIlIlIIlIIllI) - llllllllllllIlIlIllIIlIlIIlllIll * 16 + 1;
                    int llllllllllllIlIlIllIIlIlIIIlllII = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIIll - llllllllllllIlIlIllIIlIlIIlIIlIl) - 1;
                    int llllllllllllIlIlIllIIlIlIIIllIll = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIIll + llllllllllllIlIlIllIIlIlIIlIIlIl) + 1;
                    int llllllllllllIlIlIllIIlIlIIIllIlI = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIIlI - llllllllllllIlIlIllIIlIlIIlIIllI) - llllllllllllIlIlIllIIlIlIIIIIllI * 16 - 1;
                    int llllllllllllIlIlIllIIlIlIIIllIIl = MathHelper.floor(llllllllllllIlIlIllIIlIlIIIIIIlI + llllllllllllIlIlIllIIlIlIIlIIllI) - llllllllllllIlIlIllIIlIlIIIIIllI * 16 + 1;
                    if (llllllllllllIlIlIllIIlIlIIIllllI < 0) {
                        llllllllllllIlIlIllIIlIlIIIllllI = 0;
                    }
                    if (llllllllllllIlIlIllIIlIlIIIlllIl > 16) {
                        llllllllllllIlIlIllIIlIlIIIlllIl = 16;
                    }
                    if (llllllllllllIlIlIllIIlIlIIIlllII < 1) {
                        llllllllllllIlIlIllIIlIlIIIlllII = 1;
                    }
                    if (llllllllllllIlIlIllIIlIlIIIllIll > 248) {
                        llllllllllllIlIlIllIIlIlIIIllIll = 248;
                    }
                    if (llllllllllllIlIlIllIIlIlIIIllIlI < 0) {
                        llllllllllllIlIlIllIIlIlIIIllIlI = 0;
                    }
                    if (llllllllllllIlIlIllIIlIlIIIllIIl > 16) {
                        llllllllllllIlIlIllIIlIlIIIllIIl = 16;
                    }
                    boolean llllllllllllIlIlIllIIlIlIIIllIII = false;
                    for (int llllllllllllIlIlIllIIlIlIIIlIlll = llllllllllllIlIlIllIIlIlIIIllllI; !llllllllllllIlIlIllIIlIlIIIllIII && llllllllllllIlIlIllIIlIlIIIlIlll < llllllllllllIlIlIllIIlIlIIIlllIl; ++llllllllllllIlIlIllIIlIlIIIlIlll) {
                        for (int llllllllllllIlIlIllIIlIlIIIlIllI = llllllllllllIlIlIllIIlIlIIIllIlI; !llllllllllllIlIlIllIIlIlIIIllIII && llllllllllllIlIlIllIIlIlIIIlIllI < llllllllllllIlIlIllIIlIlIIIllIIl; ++llllllllllllIlIlIllIIlIlIIIlIllI) {
                            for (int llllllllllllIlIlIllIIlIlIIIlIlIl = llllllllllllIlIlIllIIlIlIIIllIll + 1; !llllllllllllIlIlIllIIlIlIIIllIII && llllllllllllIlIlIllIIlIlIIIlIlIl >= llllllllllllIlIlIllIIlIlIIIlllII - 1; --llllllllllllIlIlIllIIlIlIIIlIlIl) {
                                if (llllllllllllIlIlIllIIlIlIIIlIlIl >= 0 && llllllllllllIlIlIllIIlIlIIIlIlIl < 256) {
                                    final IBlockState llllllllllllIlIlIllIIlIlIIIlIlII = llllllllllllIlIlIllIIlIlIIlllIIl.getBlockState(llllllllllllIlIlIllIIlIlIIIlIlll, llllllllllllIlIlIllIIlIlIIIlIlIl, llllllllllllIlIlIllIIlIlIIIlIllI);
                                    if (llllllllllllIlIlIllIIlIlIIIlIlII.getBlock() == Blocks.FLOWING_WATER || llllllllllllIlIlIllIIlIlIIIlIlII.getBlock() == Blocks.WATER) {
                                        llllllllllllIlIlIllIIlIlIIIllIII = true;
                                    }
                                    if (llllllllllllIlIlIllIIlIlIIIlIlIl != llllllllllllIlIlIllIIlIlIIIlllII - 1 && llllllllllllIlIlIllIIlIlIIIlIlll != llllllllllllIlIlIllIIlIlIIIllllI && llllllllllllIlIlIllIIlIlIIIlIlll != llllllllllllIlIlIllIIlIlIIIlllIl - 1 && llllllllllllIlIlIllIIlIlIIIlIllI != llllllllllllIlIlIllIIlIlIIIllIlI && llllllllllllIlIlIllIIlIlIIIlIllI != llllllllllllIlIlIllIIlIlIIIllIIl - 1) {
                                        llllllllllllIlIlIllIIlIlIIIlIlIl = llllllllllllIlIlIllIIlIlIIIlllII;
                                    }
                                }
                            }
                        }
                    }
                    if (!llllllllllllIlIlIllIIlIlIIIllIII) {
                        final BlockPos.MutableBlockPos llllllllllllIlIlIllIIlIlIIIlIIll = new BlockPos.MutableBlockPos();
                        for (int llllllllllllIlIlIllIIlIlIIIlIIlI = llllllllllllIlIlIllIIlIlIIIllllI; llllllllllllIlIlIllIIlIlIIIlIIlI < llllllllllllIlIlIllIIlIlIIIlllIl; ++llllllllllllIlIlIllIIlIlIIIlIIlI) {
                            final double llllllllllllIlIlIllIIlIlIIIlIIIl = (llllllllllllIlIlIllIIlIlIIIlIIlI + llllllllllllIlIlIllIIlIlIIlllIll * 16 + 0.5 - llllllllllllIlIlIllIIlIlIIIIIlII) / llllllllllllIlIlIllIIlIlIIlIIllI;
                            for (int llllllllllllIlIlIllIIlIlIIIlIIII = llllllllllllIlIlIllIIlIlIIIllIlI; llllllllllllIlIlIllIIlIlIIIlIIII < llllllllllllIlIlIllIIlIlIIIllIIl; ++llllllllllllIlIlIllIIlIlIIIlIIII) {
                                final double llllllllllllIlIlIllIIlIlIIIIllll = (llllllllllllIlIlIllIIlIlIIIlIIII + llllllllllllIlIlIllIIlIlIIIIIllI * 16 + 0.5 - llllllllllllIlIlIllIIlIlIIIIIIlI) / llllllllllllIlIlIllIIlIlIIlIIllI;
                                boolean llllllllllllIlIlIllIIlIlIIIIlllI = false;
                                if (llllllllllllIlIlIllIIlIlIIIlIIIl * llllllllllllIlIlIllIIlIlIIIlIIIl + llllllllllllIlIlIllIIlIlIIIIllll * llllllllllllIlIlIllIIlIlIIIIllll < 1.0) {
                                    for (int llllllllllllIlIlIllIIlIlIIIIllIl = llllllllllllIlIlIllIIlIlIIIllIll; llllllllllllIlIlIllIIlIlIIIIllIl > llllllllllllIlIlIllIIlIlIIIlllII; --llllllllllllIlIlIllIIlIlIIIIllIl) {
                                        final double llllllllllllIlIlIllIIlIlIIIIllII = (llllllllllllIlIlIllIIlIlIIIIllIl - 1 + 0.5 - llllllllllllIlIlIllIIlIlIIIIIIll) / llllllllllllIlIlIllIIlIlIIlIIlIl;
                                        if (llllllllllllIlIlIllIIlIlIIIIllII > -0.7 && llllllllllllIlIlIllIIlIlIIIlIIIl * llllllllllllIlIlIllIIlIlIIIlIIIl + llllllllllllIlIlIllIIlIlIIIIllII * llllllllllllIlIlIllIIlIlIIIIllII + llllllllllllIlIlIllIIlIlIIIIllll * llllllllllllIlIlIllIIlIlIIIIllll < 1.0) {
                                            final IBlockState llllllllllllIlIlIllIIlIlIIIIlIll = llllllllllllIlIlIllIIlIlIIlllIIl.getBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl, llllllllllllIlIlIllIIlIlIIIlIIII);
                                            final IBlockState llllllllllllIlIlIllIIlIlIIIIlIlI = (IBlockState)MoreObjects.firstNonNull((Object)llllllllllllIlIlIllIIlIlIIlllIIl.getBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl + 1, llllllllllllIlIlIllIIlIlIIIlIIII), (Object)MapGenCaves.BLK_AIR);
                                            if (llllllllllllIlIlIllIIlIlIIIIlIll.getBlock() == Blocks.GRASS || llllllllllllIlIlIllIIlIlIIIIlIll.getBlock() == Blocks.MYCELIUM) {
                                                llllllllllllIlIlIllIIlIlIIIIlllI = true;
                                            }
                                            if (this.canReplaceBlock(llllllllllllIlIlIllIIlIlIIIIlIll, llllllllllllIlIlIllIIlIlIIIIlIlI)) {
                                                if (llllllllllllIlIlIllIIlIlIIIIllIl - 1 < 10) {
                                                    llllllllllllIlIlIllIIlIlIIlllIIl.setBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl, llllllllllllIlIlIllIIlIlIIIlIIII, MapGenCaves.BLK_LAVA);
                                                }
                                                else {
                                                    llllllllllllIlIlIllIIlIlIIlllIIl.setBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl, llllllllllllIlIlIllIIlIlIIIlIIII, MapGenCaves.BLK_AIR);
                                                    if (llllllllllllIlIlIllIIlIlIIIIlllI && llllllllllllIlIlIllIIlIlIIlllIIl.getBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl - 1, llllllllllllIlIlIllIIlIlIIIlIIII).getBlock() == Blocks.DIRT) {
                                                        llllllllllllIlIlIllIIlIlIIIlIIll.setPos(llllllllllllIlIlIllIIlIlIIIlIIlI + llllllllllllIlIlIllIIlIlIIlllIll * 16, 0, llllllllllllIlIlIllIIlIlIIIlIIII + llllllllllllIlIlIllIIlIlIIIIIllI * 16);
                                                        llllllllllllIlIlIllIIlIlIIlllIIl.setBlockState(llllllllllllIlIlIllIIlIlIIIlIIlI, llllllllllllIlIlIllIIlIlIIIIllIl - 1, llllllllllllIlIlIllIIlIlIIIlIIII, this.worldObj.getBiome(llllllllllllIlIlIllIIlIlIIIlIIll).topBlock.getBlock().getDefaultState());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (llllllllllllIlIlIllIIlIlIIlIlIIl) {
                            break;
                        }
                    }
                }
            }
            ++llllllllllllIlIlIllIIlIIlllllllI;
        }
    }
    
    @Override
    protected void recursiveGenerate(final World llllllllllllIlIlIllIIlIIllIIIIIl, final int llllllllllllIlIlIllIIlIIllIIIIII, final int llllllllllllIlIlIllIIlIIlIlIllll, final int llllllllllllIlIlIllIIlIIlIlllllI, final int llllllllllllIlIlIllIIlIIlIllllIl, final ChunkPrimer llllllllllllIlIlIllIIlIIlIllllII) {
        int llllllllllllIlIlIllIIlIIlIlllIll = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
        if (this.rand.nextInt(7) != 0) {
            llllllllllllIlIlIllIIlIIlIlllIll = 0;
        }
        for (int llllllllllllIlIlIllIIlIIlIlllIlI = 0; llllllllllllIlIlIllIIlIIlIlllIlI < llllllllllllIlIlIllIIlIIlIlllIll; ++llllllllllllIlIlIllIIlIIlIlllIlI) {
            final double llllllllllllIlIlIllIIlIIlIlllIIl = llllllllllllIlIlIllIIlIIllIIIIII * 16 + this.rand.nextInt(16);
            final double llllllllllllIlIlIllIIlIIlIlllIII = this.rand.nextInt(this.rand.nextInt(120) + 8);
            final double llllllllllllIlIlIllIIlIIlIllIlll = llllllllllllIlIlIllIIlIIlIlIllll * 16 + this.rand.nextInt(16);
            int llllllllllllIlIlIllIIlIIlIllIllI = 1;
            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), llllllllllllIlIlIllIIlIIlIlllllI, llllllllllllIlIlIllIIlIIlIllllIl, llllllllllllIlIlIllIIlIIlIllllII, llllllllllllIlIlIllIIlIIlIlllIIl, llllllllllllIlIlIllIIlIIlIlllIII, llllllllllllIlIlIllIIlIIlIllIlll);
                llllllllllllIlIlIllIIlIIlIllIllI += this.rand.nextInt(4);
            }
            for (int llllllllllllIlIlIllIIlIIlIllIlIl = 0; llllllllllllIlIlIllIIlIIlIllIlIl < llllllllllllIlIlIllIIlIIlIllIllI; ++llllllllllllIlIlIllIIlIIlIllIlIl) {
                final float llllllllllllIlIlIllIIlIIlIllIlII = this.rand.nextFloat() * 6.2831855f;
                final float llllllllllllIlIlIllIIlIIlIllIIll = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float llllllllllllIlIlIllIIlIIlIllIIlI = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                if (this.rand.nextInt(10) == 0) {
                    llllllllllllIlIlIllIIlIIlIllIIlI *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0f + 1.0f;
                }
                this.addTunnel(this.rand.nextLong(), llllllllllllIlIlIllIIlIIlIlllllI, llllllllllllIlIlIllIIlIIlIllllIl, llllllllllllIlIlIllIIlIIlIllllII, llllllllllllIlIlIllIIlIIlIlllIIl, llllllllllllIlIlIllIIlIIlIlllIII, llllllllllllIlIlIllIIlIIlIllIlll, llllllllllllIlIlIllIIlIIlIllIIlI, llllllllllllIlIlIllIIlIIlIllIlII, llllllllllllIlIlIllIIlIIlIllIIll, 0, 0, 1.0);
            }
        }
    }
    
    protected void addRoom(final long llllllllllllIlIlIllIIlIlIlllllII, final int llllllllllllIlIlIllIIlIlIllllIll, final int llllllllllllIlIlIllIIlIlIllllIlI, final ChunkPrimer llllllllllllIlIlIllIIlIlIllllIIl, final double llllllllllllIlIlIllIIlIlIlllIIII, final double llllllllllllIlIlIllIIlIlIllIllll, final double llllllllllllIlIlIllIIlIlIllIlllI) {
        this.addTunnel(llllllllllllIlIlIllIIlIlIlllllII, llllllllllllIlIlIllIIlIlIllllIll, llllllllllllIlIlIllIIlIlIllllIlI, llllllllllllIlIlIllIIlIlIllllIIl, llllllllllllIlIlIllIIlIlIlllIIII, llllllllllllIlIlIllIIlIlIllIllll, llllllllllllIlIlIllIIlIlIllIlllI, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }
    
    static {
        BLK_LAVA = Blocks.LAVA.getDefaultState();
        BLK_AIR = Blocks.AIR.getDefaultState();
        BLK_SANDSTONE = Blocks.SANDSTONE.getDefaultState();
        BLK_RED_SANDSTONE = Blocks.RED_SANDSTONE.getDefaultState();
    }
    
    protected boolean canReplaceBlock(final IBlockState llllllllllllIlIlIllIIlIIllIlIlII, final IBlockState llllllllllllIlIlIllIIlIIllIlIlIl) {
        return llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.STONE || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.DIRT || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.GRASS || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.HARDENED_CLAY || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.STAINED_HARDENED_CLAY || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.SANDSTONE || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.RED_SANDSTONE || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.MYCELIUM || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.SNOW_LAYER || ((llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.SAND || llllllllllllIlIlIllIIlIIllIlIlII.getBlock() == Blocks.GRAVEL) && llllllllllllIlIlIllIIlIIllIlIlIl.getMaterial() != Material.WATER);
    }
}
