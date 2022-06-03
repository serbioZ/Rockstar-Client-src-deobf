// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenSwamp extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState TRUNK;
    private static final /* synthetic */ IBlockState LEAF;
    
    public WorldGenSwamp() {
        super(false);
    }
    
    @Override
    public boolean generate(final World lllllllllllIIlIlIIllIIlIlllllIlI, final Random lllllllllllIIlIlIIllIIllIIIlllII, BlockPos lllllllllllIIlIlIIllIIlIlllllIII) {
        final int lllllllllllIIlIlIIllIIllIIIllIlI = lllllllllllIIlIlIIllIIllIIIlllII.nextInt(4) + 5;
        while (lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIlllllIII.down()).getMaterial() == Material.WATER) {
            lllllllllllIIlIlIIllIIlIlllllIII = lllllllllllIIlIlIIllIIlIlllllIII.down();
        }
        boolean lllllllllllIIlIlIIllIIllIIIllIIl = true;
        if (lllllllllllIIlIlIIllIIlIlllllIII.getY() < 1 || lllllllllllIIlIlIIllIIlIlllllIII.getY() + lllllllllllIIlIlIIllIIllIIIllIlI + 1 > 256) {
            return false;
        }
        for (int lllllllllllIIlIlIIllIIllIIIllIII = lllllllllllIIlIlIIllIIlIlllllIII.getY(); lllllllllllIIlIlIIllIIllIIIllIII <= lllllllllllIIlIlIIllIIlIlllllIII.getY() + 1 + lllllllllllIIlIlIIllIIllIIIllIlI; ++lllllllllllIIlIlIIllIIllIIIllIII) {
            int lllllllllllIIlIlIIllIIllIIIlIlll = 1;
            if (lllllllllllIIlIlIIllIIllIIIllIII == lllllllllllIIlIlIIllIIlIlllllIII.getY()) {
                lllllllllllIIlIlIIllIIllIIIlIlll = 0;
            }
            if (lllllllllllIIlIlIIllIIllIIIllIII >= lllllllllllIIlIlIIllIIlIlllllIII.getY() + 1 + lllllllllllIIlIlIIllIIllIIIllIlI - 2) {
                lllllllllllIIlIlIIllIIllIIIlIlll = 3;
            }
            final BlockPos.MutableBlockPos lllllllllllIIlIlIIllIIllIIIlIllI = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIlIlIIllIIllIIIlIlIl = lllllllllllIIlIlIIllIIlIlllllIII.getX() - lllllllllllIIlIlIIllIIllIIIlIlll; lllllllllllIIlIlIIllIIllIIIlIlIl <= lllllllllllIIlIlIIllIIlIlllllIII.getX() + lllllllllllIIlIlIIllIIllIIIlIlll && lllllllllllIIlIlIIllIIllIIIllIIl; ++lllllllllllIIlIlIIllIIllIIIlIlIl) {
                for (int lllllllllllIIlIlIIllIIllIIIlIlII = lllllllllllIIlIlIIllIIlIlllllIII.getZ() - lllllllllllIIlIlIIllIIllIIIlIlll; lllllllllllIIlIlIIllIIllIIIlIlII <= lllllllllllIIlIlIIllIIlIlllllIII.getZ() + lllllllllllIIlIlIIllIIllIIIlIlll && lllllllllllIIlIlIIllIIllIIIllIIl; ++lllllllllllIIlIlIIllIIllIIIlIlII) {
                    if (lllllllllllIIlIlIIllIIllIIIllIII >= 0 && lllllllllllIIlIlIIllIIllIIIllIII < 256) {
                        final IBlockState lllllllllllIIlIlIIllIIllIIIlIIll = lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIllIIIlIllI.setPos(lllllllllllIIlIlIIllIIllIIIlIlIl, lllllllllllIIlIlIIllIIllIIIllIII, lllllllllllIIlIlIIllIIllIIIlIlII));
                        final Block lllllllllllIIlIlIIllIIllIIIlIIlI = lllllllllllIIlIlIIllIIllIIIlIIll.getBlock();
                        if (lllllllllllIIlIlIIllIIllIIIlIIll.getMaterial() != Material.AIR && lllllllllllIIlIlIIllIIllIIIlIIll.getMaterial() != Material.LEAVES) {
                            if (lllllllllllIIlIlIIllIIllIIIlIIlI != Blocks.WATER && lllllllllllIIlIlIIllIIllIIIlIIlI != Blocks.FLOWING_WATER) {
                                lllllllllllIIlIlIIllIIllIIIllIIl = false;
                            }
                            else if (lllllllllllIIlIlIIllIIllIIIllIII > lllllllllllIIlIlIIllIIlIlllllIII.getY()) {
                                lllllllllllIIlIlIIllIIllIIIllIIl = false;
                            }
                        }
                    }
                    else {
                        lllllllllllIIlIlIIllIIllIIIllIIl = false;
                    }
                }
            }
        }
        if (!lllllllllllIIlIlIIllIIllIIIllIIl) {
            return false;
        }
        final Block lllllllllllIIlIlIIllIIllIIIlIIIl = lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIlllllIII.down()).getBlock();
        if ((lllllllllllIIlIlIIllIIllIIIlIIIl == Blocks.GRASS || lllllllllllIIlIlIIllIIllIIIlIIIl == Blocks.DIRT) && lllllllllllIIlIlIIllIIlIlllllIII.getY() < 256 - lllllllllllIIlIlIIllIIllIIIllIlI - 1) {
            this.setDirtAt(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIlllllIII.down());
            for (int lllllllllllIIlIlIIllIIllIIIlIIII = lllllllllllIIlIlIIllIIlIlllllIII.getY() - 3 + lllllllllllIIlIlIIllIIllIIIllIlI; lllllllllllIIlIlIIllIIllIIIlIIII <= lllllllllllIIlIlIIllIIlIlllllIII.getY() + lllllllllllIIlIlIIllIIllIIIllIlI; ++lllllllllllIIlIlIIllIIllIIIlIIII) {
                final int lllllllllllIIlIlIIllIIllIIIIllll = lllllllllllIIlIlIIllIIllIIIlIIII - (lllllllllllIIlIlIIllIIlIlllllIII.getY() + lllllllllllIIlIlIIllIIllIIIllIlI);
                for (int lllllllllllIIlIlIIllIIllIIIIlllI = 2 - lllllllllllIIlIlIIllIIllIIIIllll / 2, lllllllllllIIlIlIIllIIllIIIIllIl = lllllllllllIIlIlIIllIIlIlllllIII.getX() - lllllllllllIIlIlIIllIIllIIIIlllI; lllllllllllIIlIlIIllIIllIIIIllIl <= lllllllllllIIlIlIIllIIlIlllllIII.getX() + lllllllllllIIlIlIIllIIllIIIIlllI; ++lllllllllllIIlIlIIllIIllIIIIllIl) {
                    final int lllllllllllIIlIlIIllIIllIIIIllII = lllllllllllIIlIlIIllIIllIIIIllIl - lllllllllllIIlIlIIllIIlIlllllIII.getX();
                    for (int lllllllllllIIlIlIIllIIllIIIIlIll = lllllllllllIIlIlIIllIIlIlllllIII.getZ() - lllllllllllIIlIlIIllIIllIIIIlllI; lllllllllllIIlIlIIllIIllIIIIlIll <= lllllllllllIIlIlIIllIIlIlllllIII.getZ() + lllllllllllIIlIlIIllIIllIIIIlllI; ++lllllllllllIIlIlIIllIIllIIIIlIll) {
                        final int lllllllllllIIlIlIIllIIllIIIIlIlI = lllllllllllIIlIlIIllIIllIIIIlIll - lllllllllllIIlIlIIllIIlIlllllIII.getZ();
                        if (Math.abs(lllllllllllIIlIlIIllIIllIIIIllII) != lllllllllllIIlIlIIllIIllIIIIlllI || Math.abs(lllllllllllIIlIlIIllIIllIIIIlIlI) != lllllllllllIIlIlIIllIIllIIIIlllI || (lllllllllllIIlIlIIllIIllIIIlllII.nextInt(2) != 0 && lllllllllllIIlIlIIllIIllIIIIllll != 0)) {
                            final BlockPos lllllllllllIIlIlIIllIIllIIIIlIIl = new BlockPos(lllllllllllIIlIlIIllIIllIIIIllIl, lllllllllllIIlIlIIllIIllIIIlIIII, lllllllllllIIlIlIIllIIllIIIIlIll);
                            if (!lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIllIIIIlIIl).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIllIIIIlIIl, WorldGenSwamp.LEAF);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllIIlIlIIllIIllIIIIlIII = 0; lllllllllllIIlIlIIllIIllIIIIlIII < lllllllllllIIlIlIIllIIllIIIllIlI; ++lllllllllllIIlIlIIllIIllIIIIlIII) {
                final IBlockState lllllllllllIIlIlIIllIIllIIIIIlll = lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIlllllIII.up(lllllllllllIIlIlIIllIIllIIIIlIII));
                final Block lllllllllllIIlIlIIllIIllIIIIIllI = lllllllllllIIlIlIIllIIllIIIIIlll.getBlock();
                if (lllllllllllIIlIlIIllIIllIIIIIlll.getMaterial() == Material.AIR || lllllllllllIIlIlIIllIIllIIIIIlll.getMaterial() == Material.LEAVES || lllllllllllIIlIlIIllIIllIIIIIllI == Blocks.FLOWING_WATER || lllllllllllIIlIlIIllIIllIIIIIllI == Blocks.WATER) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIlllllIII.up(lllllllllllIIlIlIIllIIllIIIIlIII), WorldGenSwamp.TRUNK);
                }
            }
            for (int lllllllllllIIlIlIIllIIllIIIIIlIl = lllllllllllIIlIlIIllIIlIlllllIII.getY() - 3 + lllllllllllIIlIlIIllIIllIIIllIlI; lllllllllllIIlIlIIllIIllIIIIIlIl <= lllllllllllIIlIlIIllIIlIlllllIII.getY() + lllllllllllIIlIlIIllIIllIIIllIlI; ++lllllllllllIIlIlIIllIIllIIIIIlIl) {
                final int lllllllllllIIlIlIIllIIllIIIIIlII = lllllllllllIIlIlIIllIIllIIIIIlIl - (lllllllllllIIlIlIIllIIlIlllllIII.getY() + lllllllllllIIlIlIIllIIllIIIllIlI);
                final int lllllllllllIIlIlIIllIIllIIIIIIll = 2 - lllllllllllIIlIlIIllIIllIIIIIlII / 2;
                final BlockPos.MutableBlockPos lllllllllllIIlIlIIllIIllIIIIIIlI = new BlockPos.MutableBlockPos();
                for (int lllllllllllIIlIlIIllIIllIIIIIIIl = lllllllllllIIlIlIIllIIlIlllllIII.getX() - lllllllllllIIlIlIIllIIllIIIIIIll; lllllllllllIIlIlIIllIIllIIIIIIIl <= lllllllllllIIlIlIIllIIlIlllllIII.getX() + lllllllllllIIlIlIIllIIllIIIIIIll; ++lllllllllllIIlIlIIllIIllIIIIIIIl) {
                    for (int lllllllllllIIlIlIIllIIllIIIIIIII = lllllllllllIIlIlIIllIIlIlllllIII.getZ() - lllllllllllIIlIlIIllIIllIIIIIIll; lllllllllllIIlIlIIllIIllIIIIIIII <= lllllllllllIIlIlIIllIIlIlllllIII.getZ() + lllllllllllIIlIlIIllIIllIIIIIIll; ++lllllllllllIIlIlIIllIIllIIIIIIII) {
                        lllllllllllIIlIlIIllIIllIIIIIIlI.setPos(lllllllllllIIlIlIIllIIllIIIIIIIl, lllllllllllIIlIlIIllIIllIIIIIlIl, lllllllllllIIlIlIIllIIllIIIIIIII);
                        if (lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIllIIIIIIlI).getMaterial() == Material.LEAVES) {
                            final BlockPos lllllllllllIIlIlIIllIIlIllllllll = lllllllllllIIlIlIIllIIllIIIIIIlI.west();
                            final BlockPos lllllllllllIIlIlIIllIIlIlllllllI = lllllllllllIIlIlIIllIIllIIIIIIlI.east();
                            final BlockPos lllllllllllIIlIlIIllIIlIllllllIl = lllllllllllIIlIlIIllIIllIIIIIIlI.north();
                            final BlockPos lllllllllllIIlIlIIllIIlIllllllII = lllllllllllIIlIlIIllIIllIIIIIIlI.south();
                            if (lllllllllllIIlIlIIllIIllIIIlllII.nextInt(4) == 0 && lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIllllllll).getMaterial() == Material.AIR) {
                                this.addVine(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIllllllll, BlockVine.EAST);
                            }
                            if (lllllllllllIIlIlIIllIIllIIIlllII.nextInt(4) == 0 && lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIlllllllI).getMaterial() == Material.AIR) {
                                this.addVine(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIlllllllI, BlockVine.WEST);
                            }
                            if (lllllllllllIIlIlIIllIIllIIIlllII.nextInt(4) == 0 && lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIllllllIl).getMaterial() == Material.AIR) {
                                this.addVine(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIllllllIl, BlockVine.SOUTH);
                            }
                            if (lllllllllllIIlIlIIllIIllIIIlllII.nextInt(4) == 0 && lllllllllllIIlIlIIllIIlIlllllIlI.getBlockState(lllllllllllIIlIlIIllIIlIllllllII).getMaterial() == Material.AIR) {
                                this.addVine(lllllllllllIIlIlIIllIIlIlllllIlI, lllllllllllIIlIlIIllIIlIllllllII, BlockVine.NORTH);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    private void addVine(final World lllllllllllIIlIlIIllIIlIllIllIll, final BlockPos lllllllllllIIlIlIIllIIlIlllIIIIl, final PropertyBool lllllllllllIIlIlIIllIIlIllIllIIl) {
        final IBlockState lllllllllllIIlIlIIllIIlIllIlllll = Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)lllllllllllIIlIlIIllIIlIllIllIIl, true);
        this.setBlockAndNotifyAdequately(lllllllllllIIlIlIIllIIlIllIllIll, lllllllllllIIlIlIIllIIlIlllIIIIl, lllllllllllIIlIlIIllIIlIllIlllll);
        int lllllllllllIIlIlIIllIIlIllIllllI = 4;
        for (BlockPos lllllllllllIIlIlIIllIIlIllIlllIl = lllllllllllIIlIlIIllIIlIlllIIIIl.down(); lllllllllllIIlIlIIllIIlIllIllIll.getBlockState(lllllllllllIIlIlIIllIIlIllIlllIl).getMaterial() == Material.AIR && lllllllllllIIlIlIIllIIlIllIllllI > 0; lllllllllllIIlIlIIllIIlIllIlllIl = lllllllllllIIlIlIIllIIlIllIlllIl.down(), --lllllllllllIIlIlIIllIIlIllIllllI) {
            this.setBlockAndNotifyAdequately(lllllllllllIIlIlIIllIIlIllIllIll, lllllllllllIIlIlIIllIIlIllIlllIl, lllllllllllIIlIlIIllIIlIllIlllll);
        }
    }
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, false);
    }
}
