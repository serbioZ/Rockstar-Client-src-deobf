// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenMegaPineTree extends WorldGenHugeTrees
{
    private final /* synthetic */ boolean useBaseHeight;
    private static final /* synthetic */ IBlockState TRUNK;
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState PODZOL;
    
    @Override
    public boolean generate(final World lllllllllllIIllIllIllIIIIIIlIIIl, final Random lllllllllllIIllIllIllIIIIIIlIlll, final BlockPos lllllllllllIIllIllIllIIIIIIIllll) {
        final int lllllllllllIIllIllIllIIIIIIlIlIl = this.getHeight(lllllllllllIIllIllIllIIIIIIlIlll);
        if (!this.ensureGrowable(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIlIlll, lllllllllllIIllIllIllIIIIIIIllll, lllllllllllIIllIllIllIIIIIIlIlIl)) {
            return false;
        }
        this.createCrown(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIIllll.getX(), lllllllllllIIllIllIllIIIIIIIllll.getZ(), lllllllllllIIllIllIllIIIIIIIllll.getY() + lllllllllllIIllIllIllIIIIIIlIlIl, 0, lllllllllllIIllIllIllIIIIIIlIlll);
        for (int lllllllllllIIllIllIllIIIIIIlIlII = 0; lllllllllllIIllIllIllIIIIIIlIlII < lllllllllllIIllIllIllIIIIIIlIlIl; ++lllllllllllIIllIllIllIIIIIIlIlII) {
            IBlockState lllllllllllIIllIllIllIIIIIIlIIll = lllllllllllIIllIllIllIIIIIIlIIIl.getBlockState(lllllllllllIIllIllIllIIIIIIIllll.up(lllllllllllIIllIllIllIIIIIIlIlII));
            if (lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.AIR || lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.LEAVES) {
                this.setBlockAndNotifyAdequately(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIIllll.up(lllllllllllIIllIllIllIIIIIIlIlII), this.woodMetadata);
            }
            if (lllllllllllIIllIllIllIIIIIIlIlII < lllllllllllIIllIllIllIIIIIIlIlIl - 1) {
                lllllllllllIIllIllIllIIIIIIlIIll = lllllllllllIIllIllIllIIIIIIlIIIl.getBlockState(lllllllllllIIllIllIllIIIIIIIllll.add(1, lllllllllllIIllIllIllIIIIIIlIlII, 0));
                if (lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.AIR || lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIIllll.add(1, lllllllllllIIllIllIllIIIIIIlIlII, 0), this.woodMetadata);
                }
                lllllllllllIIllIllIllIIIIIIlIIll = lllllllllllIIllIllIllIIIIIIlIIIl.getBlockState(lllllllllllIIllIllIllIIIIIIIllll.add(1, lllllllllllIIllIllIllIIIIIIlIlII, 1));
                if (lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.AIR || lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIIllll.add(1, lllllllllllIIllIllIllIIIIIIlIlII, 1), this.woodMetadata);
                }
                lllllllllllIIllIllIllIIIIIIlIIll = lllllllllllIIllIllIllIIIIIIlIIIl.getBlockState(lllllllllllIIllIllIllIIIIIIIllll.add(0, lllllllllllIIllIllIllIIIIIIlIlII, 1));
                if (lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.AIR || lllllllllllIIllIllIllIIIIIIlIIll.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIllIllIllIIIIIIlIIIl, lllllllllllIIllIllIllIIIIIIIllll.add(0, lllllllllllIIllIllIllIIIIIIlIlII, 1), this.woodMetadata);
                }
            }
        }
        return true;
    }
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
        PODZOL = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
    }
    
    private void placePodzolCircle(final World lllllllllllIIllIllIlIlllllIIIlII, final BlockPos lllllllllllIIllIllIlIlllllIIlIII) {
        for (int lllllllllllIIllIllIlIlllllIIIlll = -2; lllllllllllIIllIllIlIlllllIIIlll <= 2; ++lllllllllllIIllIllIlIlllllIIIlll) {
            for (int lllllllllllIIllIllIlIlllllIIIllI = -2; lllllllllllIIllIllIlIlllllIIIllI <= 2; ++lllllllllllIIllIllIlIlllllIIIllI) {
                if (Math.abs(lllllllllllIIllIllIlIlllllIIIlll) != 2 || Math.abs(lllllllllllIIllIllIlIlllllIIIllI) != 2) {
                    this.placePodzolAt(lllllllllllIIllIllIlIlllllIIIlII, lllllllllllIIllIllIlIlllllIIlIII.add(lllllllllllIIllIllIlIlllllIIIlll, 0, lllllllllllIIllIllIlIlllllIIIllI));
                }
            }
        }
    }
    
    private void placePodzolAt(final World lllllllllllIIllIllIlIllllIlllIII, final BlockPos lllllllllllIIllIllIlIllllIllIIII) {
        for (int lllllllllllIIllIllIlIllllIllIllI = 2; lllllllllllIIllIllIlIllllIllIllI >= -3; --lllllllllllIIllIllIlIllllIllIllI) {
            final BlockPos lllllllllllIIllIllIlIllllIllIlIl = lllllllllllIIllIllIlIllllIllIIII.up(lllllllllllIIllIllIlIllllIllIllI);
            final IBlockState lllllllllllIIllIllIlIllllIllIlII = lllllllllllIIllIllIlIllllIlllIII.getBlockState(lllllllllllIIllIllIlIllllIllIlIl);
            final Block lllllllllllIIllIllIlIllllIllIIll = lllllllllllIIllIllIlIllllIllIlII.getBlock();
            if (lllllllllllIIllIllIlIllllIllIIll == Blocks.GRASS || lllllllllllIIllIllIlIllllIllIIll == Blocks.DIRT) {
                this.setBlockAndNotifyAdequately(lllllllllllIIllIllIlIllllIlllIII, lllllllllllIIllIllIlIllllIllIlIl, WorldGenMegaPineTree.PODZOL);
                break;
            }
            if (lllllllllllIIllIllIlIllllIllIlII.getMaterial() != Material.AIR && lllllllllllIIllIllIlIllllIllIllI < 0) {
                break;
            }
        }
    }
    
    @Override
    public void generateSaplings(final World lllllllllllIIllIllIlIlllllIllllI, final Random lllllllllllIIllIllIlIlllllIlIlIl, final BlockPos lllllllllllIIllIllIlIlllllIlIlII) {
        this.placePodzolCircle(lllllllllllIIllIllIlIlllllIllllI, lllllllllllIIllIllIlIlllllIlIlII.west().north());
        this.placePodzolCircle(lllllllllllIIllIllIlIlllllIllllI, lllllllllllIIllIllIlIlllllIlIlII.east(2).north());
        this.placePodzolCircle(lllllllllllIIllIllIlIlllllIllllI, lllllllllllIIllIllIlIlllllIlIlII.west().south(2));
        this.placePodzolCircle(lllllllllllIIllIllIlIlllllIllllI, lllllllllllIIllIllIlIlllllIlIlII.east(2).south(2));
        for (int lllllllllllIIllIllIlIlllllIllIll = 0; lllllllllllIIllIllIlIlllllIllIll < 5; ++lllllllllllIIllIllIlIlllllIllIll) {
            final int lllllllllllIIllIllIlIlllllIllIlI = lllllllllllIIllIllIlIlllllIlIlIl.nextInt(64);
            final int lllllllllllIIllIllIlIlllllIllIIl = lllllllllllIIllIllIlIlllllIllIlI % 8;
            final int lllllllllllIIllIllIlIlllllIllIII = lllllllllllIIllIllIlIlllllIllIlI / 8;
            if (lllllllllllIIllIllIlIlllllIllIIl == 0 || lllllllllllIIllIllIlIlllllIllIIl == 7 || lllllllllllIIllIllIlIlllllIllIII == 0 || lllllllllllIIllIllIlIlllllIllIII == 7) {
                this.placePodzolCircle(lllllllllllIIllIllIlIlllllIllllI, lllllllllllIIllIllIlIlllllIlIlII.add(-3 + lllllllllllIIllIllIlIlllllIllIIl, 0, -3 + lllllllllllIIllIllIlIlllllIllIII));
            }
        }
    }
    
    private void createCrown(final World lllllllllllIIllIllIlIlllllllIIlI, final int lllllllllllIIllIllIlIlllllllllIl, final int lllllllllllIIllIllIlIlllllllIIII, final int lllllllllllIIllIllIlIllllllllIll, final int lllllllllllIIllIllIlIllllllIlllI, final Random lllllllllllIIllIllIlIllllllIllIl) {
        final int lllllllllllIIllIllIlIllllllllIII = lllllllllllIIllIllIlIllllllIllIl.nextInt(5) + (this.useBaseHeight ? this.baseHeight : 3);
        int lllllllllllIIllIllIlIlllllllIlll = 0;
        for (int lllllllllllIIllIllIlIlllllllIllI = lllllllllllIIllIllIlIllllllllIll - lllllllllllIIllIllIlIllllllllIII; lllllllllllIIllIllIlIlllllllIllI <= lllllllllllIIllIllIlIllllllllIll; ++lllllllllllIIllIllIlIlllllllIllI) {
            final int lllllllllllIIllIllIlIlllllllIlIl = lllllllllllIIllIllIlIllllllllIll - lllllllllllIIllIllIlIlllllllIllI;
            final int lllllllllllIIllIllIlIlllllllIlII = lllllllllllIIllIllIlIllllllIlllI + MathHelper.floor(lllllllllllIIllIllIlIlllllllIlIl / (float)lllllllllllIIllIllIlIllllllllIII * 3.5f);
            this.growLeavesLayerStrict(lllllllllllIIllIllIlIlllllllIIlI, new BlockPos(lllllllllllIIllIllIlIlllllllllIl, lllllllllllIIllIllIlIlllllllIllI, lllllllllllIIllIllIlIlllllllIIII), lllllllllllIIllIllIlIlllllllIlII + ((lllllllllllIIllIllIlIlllllllIlIl > 0 && lllllllllllIIllIllIlIlllllllIlII == lllllllllllIIllIllIlIlllllllIlll && (lllllllllllIIllIllIlIlllllllIllI & 0x1) == 0x0) ? 1 : 0));
            lllllllllllIIllIllIlIlllllllIlll = lllllllllllIIllIllIlIlllllllIlII;
        }
    }
    
    public WorldGenMegaPineTree(final boolean lllllllllllIIllIllIllIIIIIlIIIlI, final boolean lllllllllllIIllIllIllIIIIIlIIIIl) {
        super(lllllllllllIIllIllIllIIIIIlIIIlI, 13, 15, WorldGenMegaPineTree.TRUNK, WorldGenMegaPineTree.LEAF);
        this.useBaseHeight = lllllllllllIIllIllIllIIIIIlIIIIl;
    }
}
