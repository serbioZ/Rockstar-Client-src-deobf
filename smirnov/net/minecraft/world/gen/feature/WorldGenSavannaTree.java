// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockNewLog;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenSavannaTree extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    private void placeLeafAt(final World lllllllllllIIIlIIllIlIIIIIIIIIII, final BlockPos lllllllllllIIIlIIllIIlllllllllll) {
        final Material lllllllllllIIIlIIllIIllllllllllI = lllllllllllIIIlIIllIlIIIIIIIIIII.getBlockState(lllllllllllIIIlIIllIIlllllllllll).getMaterial();
        if (lllllllllllIIIlIIllIIllllllllllI == Material.AIR || lllllllllllIIIlIIllIIllllllllllI == Material.LEAVES) {
            this.setBlockAndNotifyAdequately(lllllllllllIIIlIIllIlIIIIIIIIIII, lllllllllllIIIlIIllIIlllllllllll, WorldGenSavannaTree.LEAF);
        }
    }
    
    public WorldGenSavannaTree(final boolean lllllllllllIIIlIIllIlIIIIllIIIlI) {
        super(lllllllllllIIIlIIllIlIIIIllIIIlI);
    }
    
    static {
        TRUNK = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
        LEAF = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    private void placeLogAt(final World lllllllllllIIIlIIllIlIIIIIIIIlll, final BlockPos lllllllllllIIIlIIllIlIIIIIIIIllI) {
        this.setBlockAndNotifyAdequately(lllllllllllIIIlIIllIlIIIIIIIIlll, lllllllllllIIIlIIllIlIIIIIIIIllI, WorldGenSavannaTree.TRUNK);
    }
    
    @Override
    public boolean generate(final World lllllllllllIIIlIIllIlIIIIlIIlIIl, final Random lllllllllllIIIlIIllIlIIIIIlIIIIl, final BlockPos lllllllllllIIIlIIllIlIIIIlIIIlll) {
        final int lllllllllllIIIlIIllIlIIIIlIIIllI = lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(3) + lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(3) + 5;
        boolean lllllllllllIIIlIIllIlIIIIlIIIlIl = true;
        if (lllllllllllIIIlIIllIlIIIIlIIIlll.getY() < 1 || lllllllllllIIIlIIllIlIIIIlIIIlll.getY() + lllllllllllIIIlIIllIlIIIIlIIIllI + 1 > 256) {
            return false;
        }
        for (int lllllllllllIIIlIIllIlIIIIlIIIlII = lllllllllllIIIlIIllIlIIIIlIIIlll.getY(); lllllllllllIIIlIIllIlIIIIlIIIlII <= lllllllllllIIIlIIllIlIIIIlIIIlll.getY() + 1 + lllllllllllIIIlIIllIlIIIIlIIIllI; ++lllllllllllIIIlIIllIlIIIIlIIIlII) {
            int lllllllllllIIIlIIllIlIIIIlIIIIll = 1;
            if (lllllllllllIIIlIIllIlIIIIlIIIlII == lllllllllllIIIlIIllIlIIIIlIIIlll.getY()) {
                lllllllllllIIIlIIllIlIIIIlIIIIll = 0;
            }
            if (lllllllllllIIIlIIllIlIIIIlIIIlII >= lllllllllllIIIlIIllIlIIIIlIIIlll.getY() + 1 + lllllllllllIIIlIIllIlIIIIlIIIllI - 2) {
                lllllllllllIIIlIIllIlIIIIlIIIIll = 2;
            }
            final BlockPos.MutableBlockPos lllllllllllIIIlIIllIlIIIIlIIIIlI = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIIlIIllIlIIIIlIIIIIl = lllllllllllIIIlIIllIlIIIIlIIIlll.getX() - lllllllllllIIIlIIllIlIIIIlIIIIll; lllllllllllIIIlIIllIlIIIIlIIIIIl <= lllllllllllIIIlIIllIlIIIIlIIIlll.getX() + lllllllllllIIIlIIllIlIIIIlIIIIll && lllllllllllIIIlIIllIlIIIIlIIIlIl; ++lllllllllllIIIlIIllIlIIIIlIIIIIl) {
                for (int lllllllllllIIIlIIllIlIIIIlIIIIII = lllllllllllIIIlIIllIlIIIIlIIIlll.getZ() - lllllllllllIIIlIIllIlIIIIlIIIIll; lllllllllllIIIlIIllIlIIIIlIIIIII <= lllllllllllIIIlIIllIlIIIIlIIIlll.getZ() + lllllllllllIIIlIIllIlIIIIlIIIIll && lllllllllllIIIlIIllIlIIIIlIIIlIl; ++lllllllllllIIIlIIllIlIIIIlIIIIII) {
                    if (lllllllllllIIIlIIllIlIIIIlIIIlII >= 0 && lllllllllllIIIlIIllIlIIIIlIIIlII < 256) {
                        if (!this.canGrowInto(lllllllllllIIIlIIllIlIIIIlIIlIIl.getBlockState(lllllllllllIIIlIIllIlIIIIlIIIIlI.setPos(lllllllllllIIIlIIllIlIIIIlIIIIIl, lllllllllllIIIlIIllIlIIIIlIIIlII, lllllllllllIIIlIIllIlIIIIlIIIIII)).getBlock())) {
                            lllllllllllIIIlIIllIlIIIIlIIIlIl = false;
                        }
                    }
                    else {
                        lllllllllllIIIlIIllIlIIIIlIIIlIl = false;
                    }
                }
            }
        }
        if (!lllllllllllIIIlIIllIlIIIIlIIIlIl) {
            return false;
        }
        final Block lllllllllllIIIlIIllIlIIIIIllllll = lllllllllllIIIlIIllIlIIIIlIIlIIl.getBlockState(lllllllllllIIIlIIllIlIIIIlIIIlll.down()).getBlock();
        if ((lllllllllllIIIlIIllIlIIIIIllllll == Blocks.GRASS || lllllllllllIIIlIIllIlIIIIIllllll == Blocks.DIRT) && lllllllllllIIIlIIllIlIIIIlIIIlll.getY() < 256 - lllllllllllIIIlIIllIlIIIIlIIIllI - 1) {
            this.setDirtAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIlIIIlll.down());
            final EnumFacing lllllllllllIIIlIIllIlIIIIIlllllI = EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIIlIIllIlIIIIIlIIIIl);
            final int lllllllllllIIIlIIllIlIIIIIllllIl = lllllllllllIIIlIIllIlIIIIlIIIllI - lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(4) - 1;
            int lllllllllllIIIlIIllIlIIIIIllllII = 3 - lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(3);
            int lllllllllllIIIlIIllIlIIIIIlllIll = lllllllllllIIIlIIllIlIIIIlIIIlll.getX();
            int lllllllllllIIIlIIllIlIIIIIlllIlI = lllllllllllIIIlIIllIlIIIIlIIIlll.getZ();
            int lllllllllllIIIlIIllIlIIIIIlllIIl = 0;
            for (int lllllllllllIIIlIIllIlIIIIIlllIII = 0; lllllllllllIIIlIIllIlIIIIIlllIII < lllllllllllIIIlIIllIlIIIIlIIIllI; ++lllllllllllIIIlIIllIlIIIIIlllIII) {
                final int lllllllllllIIIlIIllIlIIIIIllIlll = lllllllllllIIIlIIllIlIIIIlIIIlll.getY() + lllllllllllIIIlIIllIlIIIIIlllIII;
                if (lllllllllllIIIlIIllIlIIIIIlllIII >= lllllllllllIIIlIIllIlIIIIIllllIl && lllllllllllIIIlIIllIlIIIIIllllII > 0) {
                    lllllllllllIIIlIIllIlIIIIIlllIll += lllllllllllIIIlIIllIlIIIIIlllllI.getFrontOffsetX();
                    lllllllllllIIIlIIllIlIIIIIlllIlI += lllllllllllIIIlIIllIlIIIIIlllllI.getFrontOffsetZ();
                    --lllllllllllIIIlIIllIlIIIIIllllII;
                }
                final BlockPos lllllllllllIIIlIIllIlIIIIIllIllI = new BlockPos(lllllllllllIIIlIIllIlIIIIIlllIll, lllllllllllIIIlIIllIlIIIIIllIlll, lllllllllllIIIlIIllIlIIIIIlllIlI);
                final Material lllllllllllIIIlIIllIlIIIIIllIlIl = lllllllllllIIIlIIllIlIIIIlIIlIIl.getBlockState(lllllllllllIIIlIIllIlIIIIIllIllI).getMaterial();
                if (lllllllllllIIIlIIllIlIIIIIllIlIl == Material.AIR || lllllllllllIIIlIIllIlIIIIIllIlIl == Material.LEAVES) {
                    this.placeLogAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIllI);
                    lllllllllllIIIlIIllIlIIIIIlllIIl = lllllllllllIIIlIIllIlIIIIIllIlll;
                }
            }
            BlockPos lllllllllllIIIlIIllIlIIIIIllIlII = new BlockPos(lllllllllllIIIlIIllIlIIIIIlllIll, lllllllllllIIIlIIllIlIIIIIlllIIl, lllllllllllIIIlIIllIlIIIIIlllIlI);
            for (int lllllllllllIIIlIIllIlIIIIIllIIll = -3; lllllllllllIIIlIIllIlIIIIIllIIll <= 3; ++lllllllllllIIIlIIllIlIIIIIllIIll) {
                for (int lllllllllllIIIlIIllIlIIIIIllIIlI = -3; lllllllllllIIIlIIllIlIIIIIllIIlI <= 3; ++lllllllllllIIIlIIllIlIIIIIllIIlI) {
                    if (Math.abs(lllllllllllIIIlIIllIlIIIIIllIIll) != 3 || Math.abs(lllllllllllIIIlIIllIlIIIIIllIIlI) != 3) {
                        this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.add(lllllllllllIIIlIIllIlIIIIIllIIll, 0, lllllllllllIIIlIIllIlIIIIIllIIlI));
                    }
                }
            }
            lllllllllllIIIlIIllIlIIIIIllIlII = lllllllllllIIIlIIllIlIIIIIllIlII.up();
            for (int lllllllllllIIIlIIllIlIIIIIllIIIl = -1; lllllllllllIIIlIIllIlIIIIIllIIIl <= 1; ++lllllllllllIIIlIIllIlIIIIIllIIIl) {
                for (int lllllllllllIIIlIIllIlIIIIIllIIII = -1; lllllllllllIIIlIIllIlIIIIIllIIII <= 1; ++lllllllllllIIIlIIllIlIIIIIllIIII) {
                    this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.add(lllllllllllIIIlIIllIlIIIIIllIIIl, 0, lllllllllllIIIlIIllIlIIIIIllIIII));
                }
            }
            this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.east(2));
            this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.west(2));
            this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.south(2));
            this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIllIlII.north(2));
            lllllllllllIIIlIIllIlIIIIIlllIll = lllllllllllIIIlIIllIlIIIIlIIIlll.getX();
            lllllllllllIIIlIIllIlIIIIIlllIlI = lllllllllllIIIlIIllIlIIIIlIIIlll.getZ();
            final EnumFacing lllllllllllIIIlIIllIlIIIIIlIllll = EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIIlIIllIlIIIIIlIIIIl);
            if (lllllllllllIIIlIIllIlIIIIIlIllll != lllllllllllIIIlIIllIlIIIIIlllllI) {
                final int lllllllllllIIIlIIllIlIIIIIlIlllI = lllllllllllIIIlIIllIlIIIIIllllIl - lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(2) - 1;
                int lllllllllllIIIlIIllIlIIIIIlIllIl = 1 + lllllllllllIIIlIIllIlIIIIIlIIIIl.nextInt(3);
                lllllllllllIIIlIIllIlIIIIIlllIIl = 0;
                for (int lllllllllllIIIlIIllIlIIIIIlIllII = lllllllllllIIIlIIllIlIIIIIlIlllI; lllllllllllIIIlIIllIlIIIIIlIllII < lllllllllllIIIlIIllIlIIIIlIIIllI && lllllllllllIIIlIIllIlIIIIIlIllIl > 0; ++lllllllllllIIIlIIllIlIIIIIlIllII, --lllllllllllIIIlIIllIlIIIIIlIllIl) {
                    if (lllllllllllIIIlIIllIlIIIIIlIllII >= 1) {
                        final int lllllllllllIIIlIIllIlIIIIIlIlIll = lllllllllllIIIlIIllIlIIIIlIIIlll.getY() + lllllllllllIIIlIIllIlIIIIIlIllII;
                        lllllllllllIIIlIIllIlIIIIIlllIll += lllllllllllIIIlIIllIlIIIIIlIllll.getFrontOffsetX();
                        lllllllllllIIIlIIllIlIIIIIlllIlI += lllllllllllIIIlIIllIlIIIIIlIllll.getFrontOffsetZ();
                        final BlockPos lllllllllllIIIlIIllIlIIIIIlIlIlI = new BlockPos(lllllllllllIIIlIIllIlIIIIIlllIll, lllllllllllIIIlIIllIlIIIIIlIlIll, lllllllllllIIIlIIllIlIIIIIlllIlI);
                        final Material lllllllllllIIIlIIllIlIIIIIlIlIIl = lllllllllllIIIlIIllIlIIIIlIIlIIl.getBlockState(lllllllllllIIIlIIllIlIIIIIlIlIlI).getMaterial();
                        if (lllllllllllIIIlIIllIlIIIIIlIlIIl == Material.AIR || lllllllllllIIIlIIllIlIIIIIlIlIIl == Material.LEAVES) {
                            this.placeLogAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIlIlIlI);
                            lllllllllllIIIlIIllIlIIIIIlllIIl = lllllllllllIIIlIIllIlIIIIIlIlIll;
                        }
                    }
                }
                if (lllllllllllIIIlIIllIlIIIIIlllIIl > 0) {
                    BlockPos lllllllllllIIIlIIllIlIIIIIlIlIII = new BlockPos(lllllllllllIIIlIIllIlIIIIIlllIll, lllllllllllIIIlIIllIlIIIIIlllIIl, lllllllllllIIIlIIllIlIIIIIlllIlI);
                    for (int lllllllllllIIIlIIllIlIIIIIlIIlll = -2; lllllllllllIIIlIIllIlIIIIIlIIlll <= 2; ++lllllllllllIIIlIIllIlIIIIIlIIlll) {
                        for (int lllllllllllIIIlIIllIlIIIIIlIIllI = -2; lllllllllllIIIlIIllIlIIIIIlIIllI <= 2; ++lllllllllllIIIlIIllIlIIIIIlIIllI) {
                            if (Math.abs(lllllllllllIIIlIIllIlIIIIIlIIlll) != 2 || Math.abs(lllllllllllIIIlIIllIlIIIIIlIIllI) != 2) {
                                this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIlIlIII.add(lllllllllllIIIlIIllIlIIIIIlIIlll, 0, lllllllllllIIIlIIllIlIIIIIlIIllI));
                            }
                        }
                    }
                    lllllllllllIIIlIIllIlIIIIIlIlIII = lllllllllllIIIlIIllIlIIIIIlIlIII.up();
                    for (int lllllllllllIIIlIIllIlIIIIIlIIlIl = -1; lllllllllllIIIlIIllIlIIIIIlIIlIl <= 1; ++lllllllllllIIIlIIllIlIIIIIlIIlIl) {
                        for (int lllllllllllIIIlIIllIlIIIIIlIIlII = -1; lllllllllllIIIlIIllIlIIIIIlIIlII <= 1; ++lllllllllllIIIlIIllIlIIIIIlIIlII) {
                            this.placeLeafAt(lllllllllllIIIlIIllIlIIIIlIIlIIl, lllllllllllIIIlIIllIlIIIIIlIlIII.add(lllllllllllIIIlIIllIlIIIIIlIIlIl, 0, lllllllllllIIIlIIllIlIIIIIlIIlII));
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
