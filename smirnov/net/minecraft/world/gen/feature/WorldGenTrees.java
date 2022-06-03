// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenTrees extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState DEFAULT_TRUNK;
    private final /* synthetic */ IBlockState metaWood;
    private final /* synthetic */ int minTreeHeight;
    private final /* synthetic */ IBlockState metaLeaves;
    private static final /* synthetic */ IBlockState DEFAULT_LEAF;
    private final /* synthetic */ boolean vinesGrow;
    
    public WorldGenTrees(final boolean lllllllllllIIlIlllIIlllllIIIlIII, final int lllllllllllIIlIlllIIlllllIIIIlll, final IBlockState lllllllllllIIlIlllIIlllllIIIIIII, final IBlockState lllllllllllIIlIlllIIlllllIIIIlIl, final boolean lllllllllllIIlIlllIIlllllIIIIlII) {
        super(lllllllllllIIlIlllIIlllllIIIlIII);
        this.minTreeHeight = lllllllllllIIlIlllIIlllllIIIIlll;
        this.metaWood = lllllllllllIIlIlllIIlllllIIIIIII;
        this.metaLeaves = lllllllllllIIlIlllIIlllllIIIIlIl;
        this.vinesGrow = lllllllllllIIlIlllIIlllllIIIIlII;
    }
    
    @Override
    public boolean generate(final World lllllllllllIIlIlllIIllllIlIIIIll, final Random lllllllllllIIlIlllIIllllIllIlIII, final BlockPos lllllllllllIIlIlllIIllllIllIIlll) {
        final int lllllllllllIIlIlllIIllllIllIIllI = lllllllllllIIlIlllIIllllIllIlIII.nextInt(3) + this.minTreeHeight;
        boolean lllllllllllIIlIlllIIllllIllIIlIl = true;
        if (lllllllllllIIlIlllIIllllIllIIlll.getY() < 1 || lllllllllllIIlIlllIIllllIllIIlll.getY() + lllllllllllIIlIlllIIllllIllIIllI + 1 > 256) {
            return false;
        }
        for (int lllllllllllIIlIlllIIllllIllIIlII = lllllllllllIIlIlllIIllllIllIIlll.getY(); lllllllllllIIlIlllIIllllIllIIlII <= lllllllllllIIlIlllIIllllIllIIlll.getY() + 1 + lllllllllllIIlIlllIIllllIllIIllI; ++lllllllllllIIlIlllIIllllIllIIlII) {
            int lllllllllllIIlIlllIIllllIllIIIll = 1;
            if (lllllllllllIIlIlllIIllllIllIIlII == lllllllllllIIlIlllIIllllIllIIlll.getY()) {
                lllllllllllIIlIlllIIllllIllIIIll = 0;
            }
            if (lllllllllllIIlIlllIIllllIllIIlII >= lllllllllllIIlIlllIIllllIllIIlll.getY() + 1 + lllllllllllIIlIlllIIllllIllIIllI - 2) {
                lllllllllllIIlIlllIIllllIllIIIll = 2;
            }
            final BlockPos.MutableBlockPos lllllllllllIIlIlllIIllllIllIIIlI = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIlIlllIIllllIllIIIIl = lllllllllllIIlIlllIIllllIllIIlll.getX() - lllllllllllIIlIlllIIllllIllIIIll; lllllllllllIIlIlllIIllllIllIIIIl <= lllllllllllIIlIlllIIllllIllIIlll.getX() + lllllllllllIIlIlllIIllllIllIIIll && lllllllllllIIlIlllIIllllIllIIlIl; ++lllllllllllIIlIlllIIllllIllIIIIl) {
                for (int lllllllllllIIlIlllIIllllIllIIIII = lllllllllllIIlIlllIIllllIllIIlll.getZ() - lllllllllllIIlIlllIIllllIllIIIll; lllllllllllIIlIlllIIllllIllIIIII <= lllllllllllIIlIlllIIllllIllIIlll.getZ() + lllllllllllIIlIlllIIllllIllIIIll && lllllllllllIIlIlllIIllllIllIIlIl; ++lllllllllllIIlIlllIIllllIllIIIII) {
                    if (lllllllllllIIlIlllIIllllIllIIlII >= 0 && lllllllllllIIlIlllIIllllIllIIlII < 256) {
                        if (!this.canGrowInto(lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIllIIIlI.setPos(lllllllllllIIlIlllIIllllIllIIIIl, lllllllllllIIlIlllIIllllIllIIlII, lllllllllllIIlIlllIIllllIllIIIII)).getBlock())) {
                            lllllllllllIIlIlllIIllllIllIIlIl = false;
                        }
                    }
                    else {
                        lllllllllllIIlIlllIIllllIllIIlIl = false;
                    }
                }
            }
        }
        if (!lllllllllllIIlIlllIIllllIllIIlIl) {
            return false;
        }
        final Block lllllllllllIIlIlllIIllllIlIlllll = lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIllIIlll.down()).getBlock();
        if ((lllllllllllIIlIlllIIllllIlIlllll == Blocks.GRASS || lllllllllllIIlIlllIIllllIlIlllll == Blocks.DIRT || lllllllllllIIlIlllIIllllIlIlllll == Blocks.FARMLAND) && lllllllllllIIlIlllIIllllIllIIlll.getY() < 256 - lllllllllllIIlIlllIIllllIllIIllI - 1) {
            this.setDirtAt(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.down());
            final int lllllllllllIIlIlllIIllllIlIllllI = 3;
            final int lllllllllllIIlIlllIIllllIlIlllIl = 0;
            for (int lllllllllllIIlIlllIIllllIlIlllII = lllllllllllIIlIlllIIllllIllIIlll.getY() - 3 + lllllllllllIIlIlllIIllllIllIIllI; lllllllllllIIlIlllIIllllIlIlllII <= lllllllllllIIlIlllIIllllIllIIlll.getY() + lllllllllllIIlIlllIIllllIllIIllI; ++lllllllllllIIlIlllIIllllIlIlllII) {
                final int lllllllllllIIlIlllIIllllIlIllIll = lllllllllllIIlIlllIIllllIlIlllII - (lllllllllllIIlIlllIIllllIllIIlll.getY() + lllllllllllIIlIlllIIllllIllIIllI);
                for (int lllllllllllIIlIlllIIllllIlIllIlI = 1 - lllllllllllIIlIlllIIllllIlIllIll / 2, lllllllllllIIlIlllIIllllIlIllIIl = lllllllllllIIlIlllIIllllIllIIlll.getX() - lllllllllllIIlIlllIIllllIlIllIlI; lllllllllllIIlIlllIIllllIlIllIIl <= lllllllllllIIlIlllIIllllIllIIlll.getX() + lllllllllllIIlIlllIIllllIlIllIlI; ++lllllllllllIIlIlllIIllllIlIllIIl) {
                    final int lllllllllllIIlIlllIIllllIlIllIII = lllllllllllIIlIlllIIllllIlIllIIl - lllllllllllIIlIlllIIllllIllIIlll.getX();
                    for (int lllllllllllIIlIlllIIllllIlIlIlll = lllllllllllIIlIlllIIllllIllIIlll.getZ() - lllllllllllIIlIlllIIllllIlIllIlI; lllllllllllIIlIlllIIllllIlIlIlll <= lllllllllllIIlIlllIIllllIllIIlll.getZ() + lllllllllllIIlIlllIIllllIlIllIlI; ++lllllllllllIIlIlllIIllllIlIlIlll) {
                        final int lllllllllllIIlIlllIIllllIlIlIllI = lllllllllllIIlIlllIIllllIlIlIlll - lllllllllllIIlIlllIIllllIllIIlll.getZ();
                        if (Math.abs(lllllllllllIIlIlllIIllllIlIllIII) != lllllllllllIIlIlllIIllllIlIllIlI || Math.abs(lllllllllllIIlIlllIIllllIlIlIllI) != lllllllllllIIlIlllIIllllIlIllIlI || (lllllllllllIIlIlllIIllllIllIlIII.nextInt(2) != 0 && lllllllllllIIlIlllIIllllIlIllIll != 0)) {
                            final BlockPos lllllllllllIIlIlllIIllllIlIlIlIl = new BlockPos(lllllllllllIIlIlllIIllllIlIllIIl, lllllllllllIIlIlllIIllllIlIlllII, lllllllllllIIlIlllIIllllIlIlIlll);
                            final Material lllllllllllIIlIlllIIllllIlIlIlII = lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIlIlIl).getMaterial();
                            if (lllllllllllIIlIlllIIllllIlIlIlII == Material.AIR || lllllllllllIIlIlllIIllllIlIlIlII == Material.LEAVES || lllllllllllIIlIlllIIllllIlIlIlII == Material.VINE) {
                                this.setBlockAndNotifyAdequately(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIlIlIlIl, this.metaLeaves);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllIIlIlllIIllllIlIlIIll = 0; lllllllllllIIlIlllIIllllIlIlIIll < lllllllllllIIlIlllIIllllIllIIllI; ++lllllllllllIIlIlllIIllllIlIlIIll) {
                final Material lllllllllllIIlIlllIIllllIlIlIIlI = lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIllIIlll.up(lllllllllllIIlIlllIIllllIlIlIIll)).getMaterial();
                if (lllllllllllIIlIlllIIllllIlIlIIlI == Material.AIR || lllllllllllIIlIlllIIllllIlIlIIlI == Material.LEAVES || lllllllllllIIlIlllIIllllIlIlIIlI == Material.VINE) {
                    this.setBlockAndNotifyAdequately(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.up(lllllllllllIIlIlllIIllllIlIlIIll), this.metaWood);
                    if (this.vinesGrow && lllllllllllIIlIlllIIllllIlIlIIll > 0) {
                        if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(3) > 0 && lllllllllllIIlIlllIIllllIlIIIIll.isAirBlock(lllllllllllIIlIlllIIllllIllIIlll.add(-1, lllllllllllIIlIlllIIllllIlIlIIll, 0))) {
                            this.addVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.add(-1, lllllllllllIIlIlllIIllllIlIlIIll, 0), BlockVine.EAST);
                        }
                        if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(3) > 0 && lllllllllllIIlIlllIIllllIlIIIIll.isAirBlock(lllllllllllIIlIlllIIllllIllIIlll.add(1, lllllllllllIIlIlllIIllllIlIlIIll, 0))) {
                            this.addVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.add(1, lllllllllllIIlIlllIIllllIlIlIIll, 0), BlockVine.WEST);
                        }
                        if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(3) > 0 && lllllllllllIIlIlllIIllllIlIIIIll.isAirBlock(lllllllllllIIlIlllIIllllIllIIlll.add(0, lllllllllllIIlIlllIIllllIlIlIIll, -1))) {
                            this.addVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.add(0, lllllllllllIIlIlllIIllllIlIlIIll, -1), BlockVine.SOUTH);
                        }
                        if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(3) > 0 && lllllllllllIIlIlllIIllllIlIIIIll.isAirBlock(lllllllllllIIlIlllIIllllIllIIlll.add(0, lllllllllllIIlIlllIIllllIlIlIIll, 1))) {
                            this.addVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIIlll.add(0, lllllllllllIIlIlllIIllllIlIlIIll, 1), BlockVine.NORTH);
                        }
                    }
                }
            }
            if (this.vinesGrow) {
                for (int lllllllllllIIlIlllIIllllIlIlIIIl = lllllllllllIIlIlllIIllllIllIIlll.getY() - 3 + lllllllllllIIlIlllIIllllIllIIllI; lllllllllllIIlIlllIIllllIlIlIIIl <= lllllllllllIIlIlllIIllllIllIIlll.getY() + lllllllllllIIlIlllIIllllIllIIllI; ++lllllllllllIIlIlllIIllllIlIlIIIl) {
                    final int lllllllllllIIlIlllIIllllIlIlIIII = lllllllllllIIlIlllIIllllIlIlIIIl - (lllllllllllIIlIlllIIllllIllIIlll.getY() + lllllllllllIIlIlllIIllllIllIIllI);
                    final int lllllllllllIIlIlllIIllllIlIIllll = 2 - lllllllllllIIlIlllIIllllIlIlIIII / 2;
                    final BlockPos.MutableBlockPos lllllllllllIIlIlllIIllllIlIIlllI = new BlockPos.MutableBlockPos();
                    for (int lllllllllllIIlIlllIIllllIlIIllIl = lllllllllllIIlIlllIIllllIllIIlll.getX() - lllllllllllIIlIlllIIllllIlIIllll; lllllllllllIIlIlllIIllllIlIIllIl <= lllllllllllIIlIlllIIllllIllIIlll.getX() + lllllllllllIIlIlllIIllllIlIIllll; ++lllllllllllIIlIlllIIllllIlIIllIl) {
                        for (int lllllllllllIIlIlllIIllllIlIIllII = lllllllllllIIlIlllIIllllIllIIlll.getZ() - lllllllllllIIlIlllIIllllIlIIllll; lllllllllllIIlIlllIIllllIlIIllII <= lllllllllllIIlIlllIIllllIllIIlll.getZ() + lllllllllllIIlIlllIIllllIlIIllll; ++lllllllllllIIlIlllIIllllIlIIllII) {
                            lllllllllllIIlIlllIIllllIlIIlllI.setPos(lllllllllllIIlIlllIIllllIlIIllIl, lllllllllllIIlIlllIIllllIlIlIIIl, lllllllllllIIlIlllIIllllIlIIllII);
                            if (lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIIlllI).getMaterial() == Material.LEAVES) {
                                final BlockPos lllllllllllIIlIlllIIllllIlIIlIll = lllllllllllIIlIlllIIllllIlIIlllI.west();
                                final BlockPos lllllllllllIIlIlllIIllllIlIIlIlI = lllllllllllIIlIlllIIllllIlIIlllI.east();
                                final BlockPos lllllllllllIIlIlllIIllllIlIIlIIl = lllllllllllIIlIlllIIllllIlIIlllI.north();
                                final BlockPos lllllllllllIIlIlllIIllllIlIIlIII = lllllllllllIIlIlllIIllllIlIIlllI.south();
                                if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(4) == 0 && lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIIlIll).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIlIIlIll, BlockVine.EAST);
                                }
                                if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(4) == 0 && lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIIlIlI).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIlIIlIlI, BlockVine.WEST);
                                }
                                if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(4) == 0 && lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIIlIIl).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIlIIlIIl, BlockVine.SOUTH);
                                }
                                if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(4) == 0 && lllllllllllIIlIlllIIllllIlIIIIll.getBlockState(lllllllllllIIlIlllIIllllIlIIlIII).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIlIIlIII, BlockVine.NORTH);
                                }
                            }
                        }
                    }
                }
                if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(5) == 0 && lllllllllllIIlIlllIIllllIllIIllI > 5) {
                    for (int lllllllllllIIlIlllIIllllIlIIIlll = 0; lllllllllllIIlIlllIIllllIlIIIlll < 2; ++lllllllllllIIlIlllIIllllIlIIIlll) {
                        for (final EnumFacing lllllllllllIIlIlllIIllllIlIIIllI : EnumFacing.Plane.HORIZONTAL) {
                            if (lllllllllllIIlIlllIIllllIllIlIII.nextInt(4 - lllllllllllIIlIlllIIllllIlIIIlll) == 0) {
                                final EnumFacing lllllllllllIIlIlllIIllllIlIIIlIl = lllllllllllIIlIlllIIllllIlIIIllI.getOpposite();
                                this.placeCocoa(lllllllllllIIlIlllIIllllIlIIIIll, lllllllllllIIlIlllIIllllIllIlIII.nextInt(3), lllllllllllIIlIlllIIllllIllIIlll.add(lllllllllllIIlIlllIIllllIlIIIlIl.getFrontOffsetX(), lllllllllllIIlIlllIIllllIllIIllI - 5 + lllllllllllIIlIlllIIllllIlIIIlll, lllllllllllIIlIlllIIllllIlIIIlIl.getFrontOffsetZ()), lllllllllllIIlIlllIIllllIlIIIllI);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    private void placeCocoa(final World lllllllllllIIlIlllIIllllIIlIIllI, final int lllllllllllIIlIlllIIllllIIlIlIlI, final BlockPos lllllllllllIIlIlllIIllllIIlIIlII, final EnumFacing lllllllllllIIlIlllIIllllIIlIlIII) {
        this.setBlockAndNotifyAdequately(lllllllllllIIlIlllIIllllIIlIIllI, lllllllllllIIlIlllIIllllIIlIIlII, Blocks.COCOA.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.AGE, lllllllllllIIlIlllIIllllIIlIlIlI).withProperty((IProperty<Comparable>)BlockCocoa.FACING, lllllllllllIIlIlllIIllllIIlIlIII));
    }
    
    static {
        DEFAULT_TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    private void addVine(final World lllllllllllIIlIlllIIllllIIIlllIl, final BlockPos lllllllllllIIlIlllIIllllIIIlllII, final PropertyBool lllllllllllIIlIlllIIllllIIIlIlll) {
        this.setBlockAndNotifyAdequately(lllllllllllIIlIlllIIllllIIIlllIl, lllllllllllIIlIlllIIllllIIIlllII, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)lllllllllllIIlIlllIIllllIIIlIlll, true));
    }
    
    public WorldGenTrees(final boolean lllllllllllIIlIlllIIlllllIIlIIII) {
        this(lllllllllllIIlIlllIIlllllIIlIIII, 4, WorldGenTrees.DEFAULT_TRUNK, WorldGenTrees.DEFAULT_LEAF, false);
    }
    
    private void addHangingVine(final World lllllllllllIIlIlllIIllllIIIIlIIl, final BlockPos lllllllllllIIlIlllIIllllIIIIlIII, final PropertyBool lllllllllllIIlIlllIIllllIIIIllIl) {
        this.addVine(lllllllllllIIlIlllIIllllIIIIlIIl, lllllllllllIIlIlllIIllllIIIIlIII, lllllllllllIIlIlllIIllllIIIIllIl);
        int lllllllllllIIlIlllIIllllIIIIllII = 4;
        for (BlockPos lllllllllllIIlIlllIIllllIIIIlIll = lllllllllllIIlIlllIIllllIIIIlIII.down(); lllllllllllIIlIlllIIllllIIIIlIIl.getBlockState(lllllllllllIIlIlllIIllllIIIIlIll).getMaterial() == Material.AIR && lllllllllllIIlIlllIIllllIIIIllII > 0; lllllllllllIIlIlllIIllllIIIIlIll = lllllllllllIIlIlllIIllllIIIIlIll.down(), --lllllllllllIIlIlllIIllllIIIIllII) {
            this.addVine(lllllllllllIIlIlllIIllllIIIIlIIl, lllllllllllIIlIlllIIllllIIIIlIll, lllllllllllIIlIlllIIllllIIIIllIl);
        }
    }
}
