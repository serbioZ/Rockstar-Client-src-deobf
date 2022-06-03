// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.Vec3i;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.material.Material;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenLakes extends WorldGenerator
{
    private final /* synthetic */ Block block;
    
    public WorldGenLakes(final Block lllllllllllIIIIIllIIIIIlIlIlllII) {
        this.block = lllllllllllIIIIIllIIIIIlIlIlllII;
    }
    
    @Override
    public boolean generate(final World lllllllllllIIIIIllIIIIIlIlIIIlII, final Random lllllllllllIIIIIllIIIIIlIIIllIll, BlockPos lllllllllllIIIIIllIIIIIlIIIllIlI) {
        for (lllllllllllIIIIIllIIIIIlIIIllIlI = (boolean)((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(-8, 0, -8); ((Vec3i)lllllllllllIIIIIllIIIIIlIIIllIlI).getY() > 5 && lllllllllllIIIIIllIIIIIlIlIIIlII.isAirBlock((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI); lllllllllllIIIIIllIIIIIlIIIllIlI = (boolean)((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).down()) {}
        if (((Vec3i)lllllllllllIIIIIllIIIIIlIIIllIlI).getY() <= 4) {
            return false;
        }
        lllllllllllIIIIIllIIIIIlIIIllIlI = (boolean)((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).down(4);
        final boolean[] lllllllllllIIIIIllIIIIIlIlIIIIIl = new boolean[2048];
        for (int lllllllllllIIIIIllIIIIIlIlIIIIII = lllllllllllIIIIIllIIIIIlIIIllIll.nextInt(4) + 4, lllllllllllIIIIIllIIIIIlIIllllll = 0; lllllllllllIIIIIllIIIIIlIIllllll < lllllllllllIIIIIllIIIIIlIlIIIIII; ++lllllllllllIIIIIllIIIIIlIIllllll) {
            final double lllllllllllIIIIIllIIIIIlIIlllllI = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * 6.0 + 3.0;
            final double lllllllllllIIIIIllIIIIIlIIllllIl = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * 4.0 + 2.0;
            final double lllllllllllIIIIIllIIIIIlIIllllII = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * 6.0 + 3.0;
            final double lllllllllllIIIIIllIIIIIlIIlllIll = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * (16.0 - lllllllllllIIIIIllIIIIIlIIlllllI - 2.0) + 1.0 + lllllllllllIIIIIllIIIIIlIIlllllI / 2.0;
            final double lllllllllllIIIIIllIIIIIlIIlllIlI = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * (8.0 - lllllllllllIIIIIllIIIIIlIIllllIl - 4.0) + 2.0 + lllllllllllIIIIIllIIIIIlIIllllIl / 2.0;
            final double lllllllllllIIIIIllIIIIIlIIlllIIl = lllllllllllIIIIIllIIIIIlIIIllIll.nextDouble() * (16.0 - lllllllllllIIIIIllIIIIIlIIllllII - 2.0) + 1.0 + lllllllllllIIIIIllIIIIIlIIllllII / 2.0;
            for (int lllllllllllIIIIIllIIIIIlIIlllIII = 1; lllllllllllIIIIIllIIIIIlIIlllIII < 15; ++lllllllllllIIIIIllIIIIIlIIlllIII) {
                for (int lllllllllllIIIIIllIIIIIlIIllIlll = 1; lllllllllllIIIIIllIIIIIlIIllIlll < 15; ++lllllllllllIIIIIllIIIIIlIIllIlll) {
                    for (int lllllllllllIIIIIllIIIIIlIIllIllI = 1; lllllllllllIIIIIllIIIIIlIIllIllI < 7; ++lllllllllllIIIIIllIIIIIlIIllIllI) {
                        final double lllllllllllIIIIIllIIIIIlIIllIlIl = (lllllllllllIIIIIllIIIIIlIIlllIII - lllllllllllIIIIIllIIIIIlIIlllIll) / (lllllllllllIIIIIllIIIIIlIIlllllI / 2.0);
                        final double lllllllllllIIIIIllIIIIIlIIllIlII = (lllllllllllIIIIIllIIIIIlIIllIllI - lllllllllllIIIIIllIIIIIlIIlllIlI) / (lllllllllllIIIIIllIIIIIlIIllllIl / 2.0);
                        final double lllllllllllIIIIIllIIIIIlIIllIIll = (lllllllllllIIIIIllIIIIIlIIllIlll - lllllllllllIIIIIllIIIIIlIIlllIIl) / (lllllllllllIIIIIllIIIIIlIIllllII / 2.0);
                        final double lllllllllllIIIIIllIIIIIlIIllIIlI = lllllllllllIIIIIllIIIIIlIIllIlIl * lllllllllllIIIIIllIIIIIlIIllIlIl + lllllllllllIIIIIllIIIIIlIIllIlII * lllllllllllIIIIIllIIIIIlIIllIlII + lllllllllllIIIIIllIIIIIlIIllIIll * lllllllllllIIIIIllIIIIIlIIllIIll;
                        if (lllllllllllIIIIIllIIIIIlIIllIIlI < 1.0) {
                            lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlllIII * 16 + lllllllllllIIIIIllIIIIIlIIllIlll) * 8 + lllllllllllIIIIIllIIIIIlIIllIllI] = true;
                        }
                    }
                }
            }
        }
        for (int lllllllllllIIIIIllIIIIIlIIllIIIl = 0; lllllllllllIIIIIllIIIIIlIIllIIIl < 16; ++lllllllllllIIIIIllIIIIIlIIllIIIl) {
            for (int lllllllllllIIIIIllIIIIIlIIllIIII = 0; lllllllllllIIIIIllIIIIIlIIllIIII < 16; ++lllllllllllIIIIIllIIIIIlIIllIIII) {
                for (int lllllllllllIIIIIllIIIIIlIIlIllll = 0; lllllllllllIIIIIllIIIIIlIIlIllll < 8; ++lllllllllllIIIIIllIIIIIlIIlIllll) {
                    final boolean lllllllllllIIIIIllIIIIIlIIlIlllI = !lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIllIIIl * 16 + lllllllllllIIIIIllIIIIIlIIllIIII) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll] && ((lllllllllllIIIIIllIIIIIlIIllIIIl < 15 && lllllllllllIIIIIllIIIIIlIlIIIIIl[((lllllllllllIIIIIllIIIIIlIIllIIIl + 1) * 16 + lllllllllllIIIIIllIIIIIlIIllIIII) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll]) || (lllllllllllIIIIIllIIIIIlIIllIIIl > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[((lllllllllllIIIIIllIIIIIlIIllIIIl - 1) * 16 + lllllllllllIIIIIllIIIIIlIIllIIII) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll]) || (lllllllllllIIIIIllIIIIIlIIllIIII < 15 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIllIIIl * 16 + lllllllllllIIIIIllIIIIIlIIllIIII + 1) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll]) || (lllllllllllIIIIIllIIIIIlIIllIIII > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIllIIIl * 16 + (lllllllllllIIIIIllIIIIIlIIllIIII - 1)) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll]) || (lllllllllllIIIIIllIIIIIlIIlIllll < 7 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIllIIIl * 16 + lllllllllllIIIIIllIIIIIlIIllIIII) * 8 + lllllllllllIIIIIllIIIIIlIIlIllll + 1]) || (lllllllllllIIIIIllIIIIIlIIlIllll > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIllIIIl * 16 + lllllllllllIIIIIllIIIIIlIIllIIII) * 8 + (lllllllllllIIIIIllIIIIIlIIlIllll - 1)]));
                    if (lllllllllllIIIIIllIIIIIlIIlIlllI) {
                        final Material lllllllllllIIIIIllIIIIIlIIlIllIl = lllllllllllIIIIIllIIIIIlIlIIIlII.getBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIllIIIl, lllllllllllIIIIIllIIIIIlIIlIllll, lllllllllllIIIIIllIIIIIlIIllIIII)).getMaterial();
                        if (lllllllllllIIIIIllIIIIIlIIlIllll >= 4 && lllllllllllIIIIIllIIIIIlIIlIllIl.isLiquid()) {
                            return false;
                        }
                        if (lllllllllllIIIIIllIIIIIlIIlIllll < 4 && !lllllllllllIIIIIllIIIIIlIIlIllIl.isSolid() && lllllllllllIIIIIllIIIIIlIlIIIlII.getBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIllIIIl, lllllllllllIIIIIllIIIIIlIIlIllll, lllllllllllIIIIIllIIIIIlIIllIIII)).getBlock() != this.block) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int lllllllllllIIIIIllIIIIIlIIlIllII = 0; lllllllllllIIIIIllIIIIIlIIlIllII < 16; ++lllllllllllIIIIIllIIIIIlIIlIllII) {
            for (int lllllllllllIIIIIllIIIIIlIIlIlIll = 0; lllllllllllIIIIIllIIIIIlIIlIlIll < 16; ++lllllllllllIIIIIllIIIIIlIIlIlIll) {
                for (int lllllllllllIIIIIllIIIIIlIIlIlIlI = 0; lllllllllllIIIIIllIIIIIlIIlIlIlI < 8; ++lllllllllllIIIIIllIIIIIlIIlIlIlI) {
                    if (lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIllII * 16 + lllllllllllIIIIIllIIIIIlIIlIlIll) * 8 + lllllllllllIIIIIllIIIIIlIIlIlIlI]) {
                        lllllllllllIIIIIllIIIIIlIlIIIlII.setBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIllII, lllllllllllIIIIIllIIIIIlIIlIlIlI, lllllllllllIIIIIllIIIIIlIIlIlIll), (lllllllllllIIIIIllIIIIIlIIlIlIlI >= 4) ? Blocks.AIR.getDefaultState() : this.block.getDefaultState(), 2);
                    }
                }
            }
        }
        for (int lllllllllllIIIIIllIIIIIlIIlIlIIl = 0; lllllllllllIIIIIllIIIIIlIIlIlIIl < 16; ++lllllllllllIIIIIllIIIIIlIIlIlIIl) {
            for (int lllllllllllIIIIIllIIIIIlIIlIlIII = 0; lllllllllllIIIIIllIIIIIlIIlIlIII < 16; ++lllllllllllIIIIIllIIIIIlIIlIlIII) {
                for (int lllllllllllIIIIIllIIIIIlIIlIIlll = 4; lllllllllllIIIIIllIIIIIlIIlIIlll < 8; ++lllllllllllIIIIIllIIIIIlIIlIIlll) {
                    if (lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIlIIl * 16 + lllllllllllIIIIIllIIIIIlIIlIlIII) * 8 + lllllllllllIIIIIllIIIIIlIIlIIlll]) {
                        final BlockPos lllllllllllIIIIIllIIIIIlIIlIIllI = ((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIlIIl, lllllllllllIIIIIllIIIIIlIIlIIlll - 1, lllllllllllIIIIIllIIIIIlIIlIlIII);
                        if (lllllllllllIIIIIllIIIIIlIlIIIlII.getBlockState(lllllllllllIIIIIllIIIIIlIIlIIllI).getBlock() == Blocks.DIRT && lllllllllllIIIIIllIIIIIlIlIIIlII.getLightFor(EnumSkyBlock.SKY, ((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIlIIl, lllllllllllIIIIIllIIIIIlIIlIIlll, lllllllllllIIIIIllIIIIIlIIlIlIII)) > 0) {
                            final Biome lllllllllllIIIIIllIIIIIlIIlIIlIl = lllllllllllIIIIIllIIIIIlIlIIIlII.getBiome(lllllllllllIIIIIllIIIIIlIIlIIllI);
                            if (lllllllllllIIIIIllIIIIIlIIlIIlIl.topBlock.getBlock() == Blocks.MYCELIUM) {
                                lllllllllllIIIIIllIIIIIlIlIIIlII.setBlockState(lllllllllllIIIIIllIIIIIlIIlIIllI, Blocks.MYCELIUM.getDefaultState(), 2);
                            }
                            else {
                                lllllllllllIIIIIllIIIIIlIlIIIlII.setBlockState(lllllllllllIIIIIllIIIIIlIIlIIllI, Blocks.GRASS.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        if (this.block.getDefaultState().getMaterial() == Material.LAVA) {
            for (int lllllllllllIIIIIllIIIIIlIIlIIlII = 0; lllllllllllIIIIIllIIIIIlIIlIIlII < 16; ++lllllllllllIIIIIllIIIIIlIIlIIlII) {
                for (int lllllllllllIIIIIllIIIIIlIIlIIIll = 0; lllllllllllIIIIIllIIIIIlIIlIIIll < 16; ++lllllllllllIIIIIllIIIIIlIIlIIIll) {
                    for (int lllllllllllIIIIIllIIIIIlIIlIIIlI = 0; lllllllllllIIIIIllIIIIIlIIlIIIlI < 8; ++lllllllllllIIIIIllIIIIIlIIlIIIlI) {
                        final boolean lllllllllllIIIIIllIIIIIlIIlIIIIl = !lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIIlII * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI] && ((lllllllllllIIIIIllIIIIIlIIlIIlII < 15 && lllllllllllIIIIIllIIIIIlIlIIIIIl[((lllllllllllIIIIIllIIIIIlIIlIIlII + 1) * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI]) || (lllllllllllIIIIIllIIIIIlIIlIIlII > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[((lllllllllllIIIIIllIIIIIlIIlIIlII - 1) * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI]) || (lllllllllllIIIIIllIIIIIlIIlIIIll < 15 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIIlII * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll + 1) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI]) || (lllllllllllIIIIIllIIIIIlIIlIIIll > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIIlII * 16 + (lllllllllllIIIIIllIIIIIlIIlIIIll - 1)) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI]) || (lllllllllllIIIIIllIIIIIlIIlIIIlI < 7 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIIlII * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll) * 8 + lllllllllllIIIIIllIIIIIlIIlIIIlI + 1]) || (lllllllllllIIIIIllIIIIIlIIlIIIlI > 0 && lllllllllllIIIIIllIIIIIlIlIIIIIl[(lllllllllllIIIIIllIIIIIlIIlIIlII * 16 + lllllllllllIIIIIllIIIIIlIIlIIIll) * 8 + (lllllllllllIIIIIllIIIIIlIIlIIIlI - 1)]));
                        if (lllllllllllIIIIIllIIIIIlIIlIIIIl && (lllllllllllIIIIIllIIIIIlIIlIIIlI < 4 || lllllllllllIIIIIllIIIIIlIIIllIll.nextInt(2) != 0) && lllllllllllIIIIIllIIIIIlIlIIIlII.getBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIIlII, lllllllllllIIIIIllIIIIIlIIlIIIlI, lllllllllllIIIIIllIIIIIlIIlIIIll)).getMaterial().isSolid()) {
                            lllllllllllIIIIIllIIIIIlIlIIIlII.setBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIIlII, lllllllllllIIIIIllIIIIIlIIlIIIlI, lllllllllllIIIIIllIIIIIlIIlIIIll), Blocks.STONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        if (this.block.getDefaultState().getMaterial() == Material.WATER) {
            for (int lllllllllllIIIIIllIIIIIlIIlIIIII = 0; lllllllllllIIIIIllIIIIIlIIlIIIII < 16; ++lllllllllllIIIIIllIIIIIlIIlIIIII) {
                for (int lllllllllllIIIIIllIIIIIlIIIlllll = 0; lllllllllllIIIIIllIIIIIlIIIlllll < 16; ++lllllllllllIIIIIllIIIIIlIIIlllll) {
                    final int lllllllllllIIIIIllIIIIIlIIIllllI = 4;
                    if (lllllllllllIIIIIllIIIIIlIlIIIlII.canBlockFreezeWater(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIIIII, 4, lllllllllllIIIIIllIIIIIlIIIlllll))) {
                        lllllllllllIIIIIllIIIIIlIlIIIlII.setBlockState(((BlockPos)lllllllllllIIIIIllIIIIIlIIIllIlI).add(lllllllllllIIIIIllIIIIIlIIlIIIII, 4, lllllllllllIIIIIllIIIIIlIIIlllll), Blocks.ICE.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
