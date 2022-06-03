// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenTaiga1 extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    @Override
    public boolean generate(final World lllllllllllIIlIIllIllIllIIIIlllI, final Random lllllllllllIIlIIllIllIllIIlIIlIl, final BlockPos lllllllllllIIlIIllIllIllIIlIIlII) {
        final int lllllllllllIIlIIllIllIllIIlIIIll = lllllllllllIIlIIllIllIllIIlIIlIl.nextInt(5) + 7;
        final int lllllllllllIIlIIllIllIllIIlIIIlI = lllllllllllIIlIIllIllIllIIlIIIll - lllllllllllIIlIIllIllIllIIlIIlIl.nextInt(2) - 3;
        final int lllllllllllIIlIIllIllIllIIlIIIIl = lllllllllllIIlIIllIllIllIIlIIIll - lllllllllllIIlIIllIllIllIIlIIIlI;
        final int lllllllllllIIlIIllIllIllIIlIIIII = 1 + lllllllllllIIlIIllIllIllIIlIIlIl.nextInt(lllllllllllIIlIIllIllIllIIlIIIIl + 1);
        if (lllllllllllIIlIIllIllIllIIlIIlII.getY() < 1 || lllllllllllIIlIIllIllIllIIlIIlII.getY() + lllllllllllIIlIIllIllIllIIlIIIll + 1 > 256) {
            return false;
        }
        boolean lllllllllllIIlIIllIllIllIIIlllll = true;
        for (int lllllllllllIIlIIllIllIllIIIllllI = lllllllllllIIlIIllIllIllIIlIIlII.getY(); lllllllllllIIlIIllIllIllIIIllllI <= lllllllllllIIlIIllIllIllIIlIIlII.getY() + 1 + lllllllllllIIlIIllIllIllIIlIIIll && lllllllllllIIlIIllIllIllIIIlllll; ++lllllllllllIIlIIllIllIllIIIllllI) {
            int lllllllllllIIlIIllIllIllIIIlllIl = 1;
            if (lllllllllllIIlIIllIllIllIIIllllI - lllllllllllIIlIIllIllIllIIlIIlII.getY() < lllllllllllIIlIIllIllIllIIlIIIlI) {
                lllllllllllIIlIIllIllIllIIIlllIl = 0;
            }
            else {
                lllllllllllIIlIIllIllIllIIIlllIl = lllllllllllIIlIIllIllIllIIlIIIII;
            }
            final BlockPos.MutableBlockPos lllllllllllIIlIIllIllIllIIIlllII = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIlIIllIllIllIIIllIll = lllllllllllIIlIIllIllIllIIlIIlII.getX() - lllllllllllIIlIIllIllIllIIIlllIl; lllllllllllIIlIIllIllIllIIIllIll <= lllllllllllIIlIIllIllIllIIlIIlII.getX() + lllllllllllIIlIIllIllIllIIIlllIl && lllllllllllIIlIIllIllIllIIIlllll; ++lllllllllllIIlIIllIllIllIIIllIll) {
                for (int lllllllllllIIlIIllIllIllIIIllIlI = lllllllllllIIlIIllIllIllIIlIIlII.getZ() - lllllllllllIIlIIllIllIllIIIlllIl; lllllllllllIIlIIllIllIllIIIllIlI <= lllllllllllIIlIIllIllIllIIlIIlII.getZ() + lllllllllllIIlIIllIllIllIIIlllIl && lllllllllllIIlIIllIllIllIIIlllll; ++lllllllllllIIlIIllIllIllIIIllIlI) {
                    if (lllllllllllIIlIIllIllIllIIIllllI >= 0 && lllllllllllIIlIIllIllIllIIIllllI < 256) {
                        if (!this.canGrowInto(lllllllllllIIlIIllIllIllIIIIlllI.getBlockState(lllllllllllIIlIIllIllIllIIIlllII.setPos(lllllllllllIIlIIllIllIllIIIllIll, lllllllllllIIlIIllIllIllIIIllllI, lllllllllllIIlIIllIllIllIIIllIlI)).getBlock())) {
                            lllllllllllIIlIIllIllIllIIIlllll = false;
                        }
                    }
                    else {
                        lllllllllllIIlIIllIllIllIIIlllll = false;
                    }
                }
            }
        }
        if (!lllllllllllIIlIIllIllIllIIIlllll) {
            return false;
        }
        final Block lllllllllllIIlIIllIllIllIIIllIIl = lllllllllllIIlIIllIllIllIIIIlllI.getBlockState(lllllllllllIIlIIllIllIllIIlIIlII.down()).getBlock();
        if ((lllllllllllIIlIIllIllIllIIIllIIl == Blocks.GRASS || lllllllllllIIlIIllIllIllIIIllIIl == Blocks.DIRT) && lllllllllllIIlIIllIllIllIIlIIlII.getY() < 256 - lllllllllllIIlIIllIllIllIIlIIIll - 1) {
            this.setDirtAt(lllllllllllIIlIIllIllIllIIIIlllI, lllllllllllIIlIIllIllIllIIlIIlII.down());
            int lllllllllllIIlIIllIllIllIIIllIII = 0;
            for (int lllllllllllIIlIIllIllIllIIIlIlll = lllllllllllIIlIIllIllIllIIlIIlII.getY() + lllllllllllIIlIIllIllIllIIlIIIll; lllllllllllIIlIIllIllIllIIIlIlll >= lllllllllllIIlIIllIllIllIIlIIlII.getY() + lllllllllllIIlIIllIllIllIIlIIIlI; --lllllllllllIIlIIllIllIllIIIlIlll) {
                for (int lllllllllllIIlIIllIllIllIIIlIllI = lllllllllllIIlIIllIllIllIIlIIlII.getX() - lllllllllllIIlIIllIllIllIIIllIII; lllllllllllIIlIIllIllIllIIIlIllI <= lllllllllllIIlIIllIllIllIIlIIlII.getX() + lllllllllllIIlIIllIllIllIIIllIII; ++lllllllllllIIlIIllIllIllIIIlIllI) {
                    final int lllllllllllIIlIIllIllIllIIIlIlIl = lllllllllllIIlIIllIllIllIIIlIllI - lllllllllllIIlIIllIllIllIIlIIlII.getX();
                    for (int lllllllllllIIlIIllIllIllIIIlIlII = lllllllllllIIlIIllIllIllIIlIIlII.getZ() - lllllllllllIIlIIllIllIllIIIllIII; lllllllllllIIlIIllIllIllIIIlIlII <= lllllllllllIIlIIllIllIllIIlIIlII.getZ() + lllllllllllIIlIIllIllIllIIIllIII; ++lllllllllllIIlIIllIllIllIIIlIlII) {
                        final int lllllllllllIIlIIllIllIllIIIlIIll = lllllllllllIIlIIllIllIllIIIlIlII - lllllllllllIIlIIllIllIllIIlIIlII.getZ();
                        if (Math.abs(lllllllllllIIlIIllIllIllIIIlIlIl) != lllllllllllIIlIIllIllIllIIIllIII || Math.abs(lllllllllllIIlIIllIllIllIIIlIIll) != lllllllllllIIlIIllIllIllIIIllIII || lllllllllllIIlIIllIllIllIIIllIII <= 0) {
                            final BlockPos lllllllllllIIlIIllIllIllIIIlIIlI = new BlockPos(lllllllllllIIlIIllIllIllIIIlIllI, lllllllllllIIlIIllIllIllIIIlIlll, lllllllllllIIlIIllIllIllIIIlIlII);
                            if (!lllllllllllIIlIIllIllIllIIIIlllI.getBlockState(lllllllllllIIlIIllIllIllIIIlIIlI).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(lllllllllllIIlIIllIllIllIIIIlllI, lllllllllllIIlIIllIllIllIIIlIIlI, WorldGenTaiga1.LEAF);
                            }
                        }
                    }
                }
                if (lllllllllllIIlIIllIllIllIIIllIII >= 1 && lllllllllllIIlIIllIllIllIIIlIlll == lllllllllllIIlIIllIllIllIIlIIlII.getY() + lllllllllllIIlIIllIllIllIIlIIIlI + 1) {
                    --lllllllllllIIlIIllIllIllIIIllIII;
                }
                else if (lllllllllllIIlIIllIllIllIIIllIII < lllllllllllIIlIIllIllIllIIlIIIII) {
                    ++lllllllllllIIlIIllIllIllIIIllIII;
                }
            }
            for (int lllllllllllIIlIIllIllIllIIIlIIIl = 0; lllllllllllIIlIIllIllIllIIIlIIIl < lllllllllllIIlIIllIllIllIIlIIIll - 1; ++lllllllllllIIlIIllIllIllIIIlIIIl) {
                final Material lllllllllllIIlIIllIllIllIIIlIIII = lllllllllllIIlIIllIllIllIIIIlllI.getBlockState(lllllllllllIIlIIllIllIllIIlIIlII.up(lllllllllllIIlIIllIllIllIIIlIIIl)).getMaterial();
                if (lllllllllllIIlIIllIllIllIIIlIIII == Material.AIR || lllllllllllIIlIIllIllIllIIIlIIII == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIlIIllIllIllIIIIlllI, lllllllllllIIlIIllIllIllIIlIIlII.up(lllllllllllIIlIIllIllIllIIIlIIIl), WorldGenTaiga1.TRUNK);
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    public WorldGenTaiga1() {
        super(false);
    }
}
