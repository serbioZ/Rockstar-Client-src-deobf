// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;

public class WorldGenBirchTree extends WorldGenAbstractTree
{
    private final /* synthetic */ boolean useExtraRandomHeight;
    private static final /* synthetic */ IBlockState LOG;
    private static final /* synthetic */ IBlockState LEAF;
    
    static {
        LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, false);
    }
    
    public WorldGenBirchTree(final boolean lllllllllllIIlIllIIllIIllIIllIIl, final boolean lllllllllllIIlIllIIllIIllIIllIll) {
        super(lllllllllllIIlIllIIllIIllIIllIIl);
        this.useExtraRandomHeight = lllllllllllIIlIllIIllIIllIIllIll;
    }
    
    @Override
    public boolean generate(final World lllllllllllIIlIllIIllIIlIllIllll, final Random lllllllllllIIlIllIIllIIlIllIlllI, final BlockPos lllllllllllIIlIllIIllIIllIIIIlII) {
        int lllllllllllIIlIllIIllIIllIIIIIll = lllllllllllIIlIllIIllIIlIllIlllI.nextInt(3) + 5;
        if (this.useExtraRandomHeight) {
            lllllllllllIIlIllIIllIIllIIIIIll += lllllllllllIIlIllIIllIIlIllIlllI.nextInt(7);
        }
        boolean lllllllllllIIlIllIIllIIllIIIIIlI = true;
        if (lllllllllllIIlIllIIllIIllIIIIlII.getY() < 1 || lllllllllllIIlIllIIllIIllIIIIlII.getY() + lllllllllllIIlIllIIllIIllIIIIIll + 1 > 256) {
            return false;
        }
        for (int lllllllllllIIlIllIIllIIllIIIIIIl = lllllllllllIIlIllIIllIIllIIIIlII.getY(); lllllllllllIIlIllIIllIIllIIIIIIl <= lllllllllllIIlIllIIllIIllIIIIlII.getY() + 1 + lllllllllllIIlIllIIllIIllIIIIIll; ++lllllllllllIIlIllIIllIIllIIIIIIl) {
            int lllllllllllIIlIllIIllIIllIIIIIII = 1;
            if (lllllllllllIIlIllIIllIIllIIIIIIl == lllllllllllIIlIllIIllIIllIIIIlII.getY()) {
                lllllllllllIIlIllIIllIIllIIIIIII = 0;
            }
            if (lllllllllllIIlIllIIllIIllIIIIIIl >= lllllllllllIIlIllIIllIIllIIIIlII.getY() + 1 + lllllllllllIIlIllIIllIIllIIIIIll - 2) {
                lllllllllllIIlIllIIllIIllIIIIIII = 2;
            }
            final BlockPos.MutableBlockPos lllllllllllIIlIllIIllIIlIlllllll = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIlIllIIllIIlIllllllI = lllllllllllIIlIllIIllIIllIIIIlII.getX() - lllllllllllIIlIllIIllIIllIIIIIII; lllllllllllIIlIllIIllIIlIllllllI <= lllllllllllIIlIllIIllIIllIIIIlII.getX() + lllllllllllIIlIllIIllIIllIIIIIII && lllllllllllIIlIllIIllIIllIIIIIlI; ++lllllllllllIIlIllIIllIIlIllllllI) {
                for (int lllllllllllIIlIllIIllIIlIlllllIl = lllllllllllIIlIllIIllIIllIIIIlII.getZ() - lllllllllllIIlIllIIllIIllIIIIIII; lllllllllllIIlIllIIllIIlIlllllIl <= lllllllllllIIlIllIIllIIllIIIIlII.getZ() + lllllllllllIIlIllIIllIIllIIIIIII && lllllllllllIIlIllIIllIIllIIIIIlI; ++lllllllllllIIlIllIIllIIlIlllllIl) {
                    if (lllllllllllIIlIllIIllIIllIIIIIIl >= 0 && lllllllllllIIlIllIIllIIllIIIIIIl < 256) {
                        if (!this.canGrowInto(lllllllllllIIlIllIIllIIlIllIllll.getBlockState(lllllllllllIIlIllIIllIIlIlllllll.setPos(lllllllllllIIlIllIIllIIlIllllllI, lllllllllllIIlIllIIllIIllIIIIIIl, lllllllllllIIlIllIIllIIlIlllllIl)).getBlock())) {
                            lllllllllllIIlIllIIllIIllIIIIIlI = false;
                        }
                    }
                    else {
                        lllllllllllIIlIllIIllIIllIIIIIlI = false;
                    }
                }
            }
        }
        if (!lllllllllllIIlIllIIllIIllIIIIIlI) {
            return false;
        }
        final Block lllllllllllIIlIllIIllIIlIlllllII = lllllllllllIIlIllIIllIIlIllIllll.getBlockState(lllllllllllIIlIllIIllIIllIIIIlII.down()).getBlock();
        if ((lllllllllllIIlIllIIllIIlIlllllII == Blocks.GRASS || lllllllllllIIlIllIIllIIlIlllllII == Blocks.DIRT || lllllllllllIIlIllIIllIIlIlllllII == Blocks.FARMLAND) && lllllllllllIIlIllIIllIIllIIIIlII.getY() < 256 - lllllllllllIIlIllIIllIIllIIIIIll - 1) {
            this.setDirtAt(lllllllllllIIlIllIIllIIlIllIllll, lllllllllllIIlIllIIllIIllIIIIlII.down());
            for (int lllllllllllIIlIllIIllIIlIllllIll = lllllllllllIIlIllIIllIIllIIIIlII.getY() - 3 + lllllllllllIIlIllIIllIIllIIIIIll; lllllllllllIIlIllIIllIIlIllllIll <= lllllllllllIIlIllIIllIIllIIIIlII.getY() + lllllllllllIIlIllIIllIIllIIIIIll; ++lllllllllllIIlIllIIllIIlIllllIll) {
                final int lllllllllllIIlIllIIllIIlIllllIlI = lllllllllllIIlIllIIllIIlIllllIll - (lllllllllllIIlIllIIllIIllIIIIlII.getY() + lllllllllllIIlIllIIllIIllIIIIIll);
                for (int lllllllllllIIlIllIIllIIlIllllIIl = 1 - lllllllllllIIlIllIIllIIlIllllIlI / 2, lllllllllllIIlIllIIllIIlIllllIII = lllllllllllIIlIllIIllIIllIIIIlII.getX() - lllllllllllIIlIllIIllIIlIllllIIl; lllllllllllIIlIllIIllIIlIllllIII <= lllllllllllIIlIllIIllIIllIIIIlII.getX() + lllllllllllIIlIllIIllIIlIllllIIl; ++lllllllllllIIlIllIIllIIlIllllIII) {
                    final int lllllllllllIIlIllIIllIIlIlllIlll = lllllllllllIIlIllIIllIIlIllllIII - lllllllllllIIlIllIIllIIllIIIIlII.getX();
                    for (int lllllllllllIIlIllIIllIIlIlllIllI = lllllllllllIIlIllIIllIIllIIIIlII.getZ() - lllllllllllIIlIllIIllIIlIllllIIl; lllllllllllIIlIllIIllIIlIlllIllI <= lllllllllllIIlIllIIllIIllIIIIlII.getZ() + lllllllllllIIlIllIIllIIlIllllIIl; ++lllllllllllIIlIllIIllIIlIlllIllI) {
                        final int lllllllllllIIlIllIIllIIlIlllIlIl = lllllllllllIIlIllIIllIIlIlllIllI - lllllllllllIIlIllIIllIIllIIIIlII.getZ();
                        if (Math.abs(lllllllllllIIlIllIIllIIlIlllIlll) != lllllllllllIIlIllIIllIIlIllllIIl || Math.abs(lllllllllllIIlIllIIllIIlIlllIlIl) != lllllllllllIIlIllIIllIIlIllllIIl || (lllllllllllIIlIllIIllIIlIllIlllI.nextInt(2) != 0 && lllllllllllIIlIllIIllIIlIllllIlI != 0)) {
                            final BlockPos lllllllllllIIlIllIIllIIlIlllIlII = new BlockPos(lllllllllllIIlIllIIllIIlIllllIII, lllllllllllIIlIllIIllIIlIllllIll, lllllllllllIIlIllIIllIIlIlllIllI);
                            final Material lllllllllllIIlIllIIllIIlIlllIIll = lllllllllllIIlIllIIllIIlIllIllll.getBlockState(lllllllllllIIlIllIIllIIlIlllIlII).getMaterial();
                            if (lllllllllllIIlIllIIllIIlIlllIIll == Material.AIR || lllllllllllIIlIllIIllIIlIlllIIll == Material.LEAVES) {
                                this.setBlockAndNotifyAdequately(lllllllllllIIlIllIIllIIlIllIllll, lllllllllllIIlIllIIllIIlIlllIlII, WorldGenBirchTree.LEAF);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllIIlIllIIllIIlIlllIIlI = 0; lllllllllllIIlIllIIllIIlIlllIIlI < lllllllllllIIlIllIIllIIllIIIIIll; ++lllllllllllIIlIllIIllIIlIlllIIlI) {
                final Material lllllllllllIIlIllIIllIIlIlllIIIl = lllllllllllIIlIllIIllIIlIllIllll.getBlockState(lllllllllllIIlIllIIllIIllIIIIlII.up(lllllllllllIIlIllIIllIIlIlllIIlI)).getMaterial();
                if (lllllllllllIIlIllIIllIIlIlllIIIl == Material.AIR || lllllllllllIIlIllIIllIIlIlllIIIl == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIlIllIIllIIlIllIllll, lllllllllllIIlIllIIllIIllIIIIlII.up(lllllllllllIIlIllIIllIIlIlllIIlI), WorldGenBirchTree.LOG);
                }
            }
            return true;
        }
        return false;
    }
}
