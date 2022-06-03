// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenCanopyTree extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState DARK_OAK_LEAVES;
    private static final /* synthetic */ IBlockState DARK_OAK_LOG;
    
    @Override
    public boolean generate(final World lllllllllllIIllIIlIllIIlIlIIIlll, final Random lllllllllllIIllIIlIllIIlIIlIIlIl, final BlockPos lllllllllllIIllIIlIllIIlIlIIIlIl) {
        final int lllllllllllIIllIIlIllIIlIlIIIlII = lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(3) + lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(2) + 6;
        final int lllllllllllIIllIIlIllIIlIlIIIIll = lllllllllllIIllIIlIllIIlIlIIIlIl.getX();
        final int lllllllllllIIllIIlIllIIlIlIIIIlI = lllllllllllIIllIIlIllIIlIlIIIlIl.getY();
        final int lllllllllllIIllIIlIllIIlIlIIIIIl = lllllllllllIIllIIlIllIIlIlIIIlIl.getZ();
        if (lllllllllllIIllIIlIllIIlIlIIIIlI < 1 || lllllllllllIIllIIlIllIIlIlIIIIlI + lllllllllllIIllIIlIllIIlIlIIIlII + 1 >= 256) {
            return false;
        }
        final BlockPos lllllllllllIIllIIlIllIIlIlIIIIII = lllllllllllIIllIIlIllIIlIlIIIlIl.down();
        final Block lllllllllllIIllIIlIllIIlIIllllll = lllllllllllIIllIIlIllIIlIlIIIlll.getBlockState(lllllllllllIIllIIlIllIIlIlIIIIII).getBlock();
        if (lllllllllllIIllIIlIllIIlIIllllll != Blocks.GRASS && lllllllllllIIllIIlIllIIlIIllllll != Blocks.DIRT) {
            return false;
        }
        if (!this.placeTreeOfHeight(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIlIIIlIl, lllllllllllIIllIIlIllIIlIlIIIlII)) {
            return false;
        }
        this.setDirtAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIlIIIIII);
        this.setDirtAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIlIIIIII.east());
        this.setDirtAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIlIIIIII.south());
        this.setDirtAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIlIIIIII.south().east());
        final EnumFacing lllllllllllIIllIIlIllIIlIIlllllI = EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIllIIlIllIIlIIlIIlIl);
        final int lllllllllllIIllIIlIllIIlIIllllIl = lllllllllllIIllIIlIllIIlIlIIIlII - lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(4);
        int lllllllllllIIllIIlIllIIlIIllllII = 2 - lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(3);
        int lllllllllllIIllIIlIllIIlIIlllIll = lllllllllllIIllIIlIllIIlIlIIIIll;
        int lllllllllllIIllIIlIllIIlIIlllIlI = lllllllllllIIllIIlIllIIlIlIIIIIl;
        final int lllllllllllIIllIIlIllIIlIIlllIIl = lllllllllllIIllIIlIllIIlIlIIIIlI + lllllllllllIIllIIlIllIIlIlIIIlII - 1;
        for (int lllllllllllIIllIIlIllIIlIIlllIII = 0; lllllllllllIIllIIlIllIIlIIlllIII < lllllllllllIIllIIlIllIIlIlIIIlII; ++lllllllllllIIllIIlIllIIlIIlllIII) {
            if (lllllllllllIIllIIlIllIIlIIlllIII >= lllllllllllIIllIIlIllIIlIIllllIl && lllllllllllIIllIIlIllIIlIIllllII > 0) {
                lllllllllllIIllIIlIllIIlIIlllIll += lllllllllllIIllIIlIllIIlIIlllllI.getFrontOffsetX();
                lllllllllllIIllIIlIllIIlIIlllIlI += lllllllllllIIllIIlIllIIlIIlllllI.getFrontOffsetZ();
                --lllllllllllIIllIIlIllIIlIIllllII;
            }
            final int lllllllllllIIllIIlIllIIlIIllIlll = lllllllllllIIllIIlIllIIlIlIIIIlI + lllllllllllIIllIIlIllIIlIIlllIII;
            final BlockPos lllllllllllIIllIIlIllIIlIIllIllI = new BlockPos(lllllllllllIIllIIlIllIIlIIlllIll, lllllllllllIIllIIlIllIIlIIllIlll, lllllllllllIIllIIlIllIIlIIlllIlI);
            final Material lllllllllllIIllIIlIllIIlIIllIlIl = lllllllllllIIllIIlIllIIlIlIIIlll.getBlockState(lllllllllllIIllIIlIllIIlIIllIllI).getMaterial();
            if (lllllllllllIIllIIlIllIIlIIllIlIl == Material.AIR || lllllllllllIIllIIlIllIIlIIllIlIl == Material.LEAVES) {
                this.placeLogAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIllIllI);
                this.placeLogAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIllIllI.east());
                this.placeLogAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIllIllI.south());
                this.placeLogAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIllIllI.east().south());
            }
        }
        for (int lllllllllllIIllIIlIllIIlIIllIlII = -2; lllllllllllIIllIIlIllIIlIIllIlII <= 0; ++lllllllllllIIllIIlIllIIlIIllIlII) {
            for (int lllllllllllIIllIIlIllIIlIIllIIll = -2; lllllllllllIIllIIlIllIIlIIllIIll <= 0; ++lllllllllllIIllIIlIllIIlIIllIIll) {
                int lllllllllllIIllIIlIllIIlIIllIIlI = -1;
                this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIllIIll);
                this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, 1 + lllllllllllIIllIIlIllIIlIIlllIll - lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIllIIll);
                this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, 1 + lllllllllllIIllIIlIllIIlIIlllIlI - lllllllllllIIllIIlIllIIlIIllIIll);
                this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, 1 + lllllllllllIIllIIlIllIIlIIlllIll - lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, 1 + lllllllllllIIllIIlIllIIlIIlllIlI - lllllllllllIIllIIlIllIIlIIllIIll);
                if ((lllllllllllIIllIIlIllIIlIIllIlII > -2 || lllllllllllIIllIIlIllIIlIIllIIll > -1) && (lllllllllllIIllIIlIllIIlIIllIlII != -1 || lllllllllllIIllIIlIllIIlIIllIIll != -2)) {
                    lllllllllllIIllIIlIllIIlIIllIIlI = 1;
                    this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIllIIll);
                    this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, 1 + lllllllllllIIllIIlIllIIlIIlllIll - lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIllIIll);
                    this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, 1 + lllllllllllIIllIIlIllIIlIIlllIlI - lllllllllllIIllIIlIllIIlIIllIIll);
                    this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, 1 + lllllllllllIIllIIlIllIIlIIlllIll - lllllllllllIIllIIlIllIIlIIllIlII, lllllllllllIIllIIlIllIIlIIlllIIl + lllllllllllIIllIIlIllIIlIIllIIlI, 1 + lllllllllllIIllIIlIllIIlIIlllIlI - lllllllllllIIllIIlIllIIlIIllIIll);
                }
            }
        }
        if (lllllllllllIIllIIlIllIIlIIlIIlIl.nextBoolean()) {
            this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll, lllllllllllIIllIIlIllIIlIIlllIIl + 2, lllllllllllIIllIIlIllIIlIIlllIlI);
            this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + 1, lllllllllllIIllIIlIllIIlIIlllIIl + 2, lllllllllllIIllIIlIllIIlIIlllIlI);
            this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + 1, lllllllllllIIllIIlIllIIlIIlllIIl + 2, lllllllllllIIllIIlIllIIlIIlllIlI + 1);
            this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll, lllllllllllIIllIIlIllIIlIIlllIIl + 2, lllllllllllIIllIIlIllIIlIIlllIlI + 1);
        }
        for (int lllllllllllIIllIIlIllIIlIIllIIIl = -3; lllllllllllIIllIIlIllIIlIIllIIIl <= 4; ++lllllllllllIIllIIlIllIIlIIllIIIl) {
            for (int lllllllllllIIllIIlIllIIlIIllIIII = -3; lllllllllllIIllIIlIllIIlIIllIIII <= 4; ++lllllllllllIIllIIlIllIIlIIllIIII) {
                if ((lllllllllllIIllIIlIllIIlIIllIIIl != -3 || lllllllllllIIllIIlIllIIlIIllIIII != -3) && (lllllllllllIIllIIlIllIIlIIllIIIl != -3 || lllllllllllIIllIIlIllIIlIIllIIII != 4) && (lllllllllllIIllIIlIllIIlIIllIIIl != 4 || lllllllllllIIllIIlIllIIlIIllIIII != -3) && (lllllllllllIIllIIlIllIIlIIllIIIl != 4 || lllllllllllIIllIIlIllIIlIIllIIII != 4) && (Math.abs(lllllllllllIIllIIlIllIIlIIllIIIl) < 3 || Math.abs(lllllllllllIIllIIlIllIIlIIllIIII) < 3)) {
                    this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIllIIIl, lllllllllllIIllIIlIllIIlIIlllIIl, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIllIIII);
                }
            }
        }
        for (int lllllllllllIIllIIlIllIIlIIlIllll = -1; lllllllllllIIllIIlIllIIlIIlIllll <= 2; ++lllllllllllIIllIIlIllIIlIIlIllll) {
            for (int lllllllllllIIllIIlIllIIlIIlIlllI = -1; lllllllllllIIllIIlIllIIlIIlIlllI <= 2; ++lllllllllllIIllIIlIllIIlIIlIlllI) {
                if ((lllllllllllIIllIIlIllIIlIIlIllll < 0 || lllllllllllIIllIIlIllIIlIIlIllll > 1 || lllllllllllIIllIIlIllIIlIIlIlllI < 0 || lllllllllllIIllIIlIllIIlIIlIlllI > 1) && lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(3) <= 0) {
                    for (int lllllllllllIIllIIlIllIIlIIlIllIl = lllllllllllIIllIIlIllIIlIIlIIlIl.nextInt(3) + 2, lllllllllllIIllIIlIllIIlIIlIllII = 0; lllllllllllIIllIIlIllIIlIIlIllII < lllllllllllIIllIIlIllIIlIIlIllIl; ++lllllllllllIIllIIlIllIIlIIlIllII) {
                        this.placeLogAt(lllllllllllIIllIIlIllIIlIlIIIlll, new BlockPos(lllllllllllIIllIIlIllIIlIlIIIIll + lllllllllllIIllIIlIllIIlIIlIllll, lllllllllllIIllIIlIllIIlIIlllIIl - lllllllllllIIllIIlIllIIlIIlIllII - 1, lllllllllllIIllIIlIllIIlIlIIIIIl + lllllllllllIIllIIlIllIIlIIlIlllI));
                    }
                    for (int lllllllllllIIllIIlIllIIlIIlIlIll = -1; lllllllllllIIllIIlIllIIlIIlIlIll <= 1; ++lllllllllllIIllIIlIllIIlIIlIlIll) {
                        for (int lllllllllllIIllIIlIllIIlIIlIlIlI = -1; lllllllllllIIllIIlIllIIlIIlIlIlI <= 1; ++lllllllllllIIllIIlIllIIlIIlIlIlI) {
                            this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIlIllll + lllllllllllIIllIIlIllIIlIIlIlIll, lllllllllllIIllIIlIllIIlIIlllIIl, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIlIlllI + lllllllllllIIllIIlIllIIlIIlIlIlI);
                        }
                    }
                    for (int lllllllllllIIllIIlIllIIlIIlIlIIl = -2; lllllllllllIIllIIlIllIIlIIlIlIIl <= 2; ++lllllllllllIIllIIlIllIIlIIlIlIIl) {
                        for (int lllllllllllIIllIIlIllIIlIIlIlIII = -2; lllllllllllIIllIIlIllIIlIIlIlIII <= 2; ++lllllllllllIIllIIlIllIIlIIlIlIII) {
                            if (Math.abs(lllllllllllIIllIIlIllIIlIIlIlIIl) != 2 || Math.abs(lllllllllllIIllIIlIllIIlIIlIlIII) != 2) {
                                this.placeLeafAt(lllllllllllIIllIIlIllIIlIlIIIlll, lllllllllllIIllIIlIllIIlIIlllIll + lllllllllllIIllIIlIllIIlIIlIllll + lllllllllllIIllIIlIllIIlIIlIlIIl, lllllllllllIIllIIlIllIIlIIlllIIl - 1, lllllllllllIIllIIlIllIIlIIlllIlI + lllllllllllIIllIIlIllIIlIIlIlllI + lllllllllllIIllIIlIllIIlIIlIlIII);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    static {
        DARK_OAK_LOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
        DARK_OAK_LEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    private void placeLeafAt(final World lllllllllllIIllIIlIllIIIllIlIllI, final int lllllllllllIIllIIlIllIIIllIlllII, final int lllllllllllIIllIIlIllIIIllIllIll, final int lllllllllllIIllIIlIllIIIllIlIIll) {
        final BlockPos lllllllllllIIllIIlIllIIIllIllIIl = new BlockPos(lllllllllllIIllIIlIllIIIllIlllII, lllllllllllIIllIIlIllIIIllIllIll, lllllllllllIIllIIlIllIIIllIlIIll);
        final Material lllllllllllIIllIIlIllIIIllIllIII = lllllllllllIIllIIlIllIIIllIlIllI.getBlockState(lllllllllllIIllIIlIllIIIllIllIIl).getMaterial();
        if (lllllllllllIIllIIlIllIIIllIllIII == Material.AIR) {
            this.setBlockAndNotifyAdequately(lllllllllllIIllIIlIllIIIllIlIllI, lllllllllllIIllIIlIllIIIllIllIIl, WorldGenCanopyTree.DARK_OAK_LEAVES);
        }
    }
    
    public WorldGenCanopyTree(final boolean lllllllllllIIllIIlIllIIlIlIllllI) {
        super(lllllllllllIIllIIlIllIIlIlIllllI);
    }
    
    private void placeLogAt(final World lllllllllllIIllIIlIllIIIlllIIlll, final BlockPos lllllllllllIIllIIlIllIIIlllIlIIl) {
        if (this.canGrowInto(lllllllllllIIllIIlIllIIIlllIIlll.getBlockState(lllllllllllIIllIIlIllIIIlllIlIIl).getBlock())) {
            this.setBlockAndNotifyAdequately(lllllllllllIIllIIlIllIIIlllIIlll, lllllllllllIIllIIlIllIIIlllIlIIl, WorldGenCanopyTree.DARK_OAK_LOG);
        }
    }
    
    private boolean placeTreeOfHeight(final World lllllllllllIIllIIlIllIIlIIIIIlIl, final BlockPos lllllllllllIIllIIlIllIIlIIIIIlII, final int lllllllllllIIllIIlIllIIlIIIIIIll) {
        final int lllllllllllIIllIIlIllIIlIIIIIIlI = lllllllllllIIllIIlIllIIlIIIIIlII.getX();
        final int lllllllllllIIllIIlIllIIlIIIIIIIl = lllllllllllIIllIIlIllIIlIIIIIlII.getY();
        final int lllllllllllIIllIIlIllIIlIIIIIIII = lllllllllllIIllIIlIllIIlIIIIIlII.getZ();
        final BlockPos.MutableBlockPos lllllllllllIIllIIlIllIIIllllllll = new BlockPos.MutableBlockPos();
        for (int lllllllllllIIllIIlIllIIIlllllllI = 0; lllllllllllIIllIIlIllIIIlllllllI <= lllllllllllIIllIIlIllIIlIIIIIIll + 1; ++lllllllllllIIllIIlIllIIIlllllllI) {
            int lllllllllllIIllIIlIllIIIllllllIl = 1;
            if (lllllllllllIIllIIlIllIIIlllllllI == 0) {
                lllllllllllIIllIIlIllIIIllllllIl = 0;
            }
            if (lllllllllllIIllIIlIllIIIlllllllI >= lllllllllllIIllIIlIllIIlIIIIIIll - 1) {
                lllllllllllIIllIIlIllIIIllllllIl = 2;
            }
            for (int lllllllllllIIllIIlIllIIIllllllII = -lllllllllllIIllIIlIllIIIllllllIl; lllllllllllIIllIIlIllIIIllllllII <= lllllllllllIIllIIlIllIIIllllllIl; ++lllllllllllIIllIIlIllIIIllllllII) {
                for (int lllllllllllIIllIIlIllIIIlllllIll = -lllllllllllIIllIIlIllIIIllllllIl; lllllllllllIIllIIlIllIIIlllllIll <= lllllllllllIIllIIlIllIIIllllllIl; ++lllllllllllIIllIIlIllIIIlllllIll) {
                    if (!this.canGrowInto(lllllllllllIIllIIlIllIIlIIIIIlIl.getBlockState(lllllllllllIIllIIlIllIIIllllllll.setPos(lllllllllllIIllIIlIllIIlIIIIIIlI + lllllllllllIIllIIlIllIIIllllllII, lllllllllllIIllIIlIllIIlIIIIIIIl + lllllllllllIIllIIlIllIIIlllllllI, lllllllllllIIllIIlIllIIlIIIIIIII + lllllllllllIIllIIlIllIIIlllllIll)).getBlock())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
