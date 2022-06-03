// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import java.util.EnumSet;
import net.minecraft.util.EnumFacing;
import java.util.Set;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDynamicLiquid extends BlockLiquid
{
    /* synthetic */ int adjacentSourceBlocks;
    
    @Override
    public void onBlockAdded(final World llllllllllllIIllIIIllIIllllIlIII, final BlockPos llllllllllllIIllIIIllIIllllIIlll, final IBlockState llllllllllllIIllIIIllIIllllIlIlI) {
        if (!this.checkForMixing(llllllllllllIIllIIIllIIllllIlIII, llllllllllllIIllIIIllIIllllIIlll, llllllllllllIIllIIIllIIllllIlIlI)) {
            llllllllllllIIllIIIllIIllllIlIII.scheduleUpdate(llllllllllllIIllIIIllIIllllIIlll, this, this.tickRate(llllllllllllIIllIIIllIIllllIlIII));
        }
    }
    
    private Set<EnumFacing> getPossibleFlowDirections(final World llllllllllllIIllIIIllIlIIIlIIIll, final BlockPos llllllllllllIIllIIIllIlIIIlIIIlI) {
        int llllllllllllIIllIIIllIlIIIlIlIll = 1000;
        final Set<EnumFacing> llllllllllllIIllIIIllIlIIIlIlIlI = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing llllllllllllIIllIIIllIlIIIlIlIIl : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllIIllIIIllIlIIIlIlIII = llllllllllllIIllIIIllIlIIIlIIIlI.offset(llllllllllllIIllIIIllIlIIIlIlIIl);
            final IBlockState llllllllllllIIllIIIllIlIIIlIIlll = llllllllllllIIllIIIllIlIIIlIIIll.getBlockState(llllllllllllIIllIIIllIlIIIlIlIII);
            if (!this.isBlocked(llllllllllllIIllIIIllIlIIIlIIIll, llllllllllllIIllIIIllIlIIIlIlIII, llllllllllllIIllIIIllIlIIIlIIlll) && (llllllllllllIIllIIIllIlIIIlIIlll.getMaterial() != this.blockMaterial || llllllllllllIIllIIIllIlIIIlIIlll.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) > 0)) {
                int llllllllllllIIllIIIllIlIIIlIIlIl = 0;
                if (this.isBlocked(llllllllllllIIllIIIllIlIIIlIIIll, llllllllllllIIllIIIllIlIIIlIlIII.down(), llllllllllllIIllIIIllIlIIIlIIIll.getBlockState(llllllllllllIIllIIIllIlIIIlIlIII.down()))) {
                    final int llllllllllllIIllIIIllIlIIIlIIllI = this.getSlopeDistance(llllllllllllIIllIIIllIlIIIlIIIll, llllllllllllIIllIIIllIlIIIlIlIII, 1, llllllllllllIIllIIIllIlIIIlIlIIl.getOpposite());
                }
                else {
                    llllllllllllIIllIIIllIlIIIlIIlIl = 0;
                }
                if (llllllllllllIIllIIIllIlIIIlIIlIl < llllllllllllIIllIIIllIlIIIlIlIll) {
                    llllllllllllIIllIIIllIlIIIlIlIlI.clear();
                }
                if (llllllllllllIIllIIIllIlIIIlIIlIl > llllllllllllIIllIIIllIlIIIlIlIll) {
                    continue;
                }
                llllllllllllIIllIIIllIlIIIlIlIlI.add(llllllllllllIIllIIIllIlIIIlIlIIl);
                llllllllllllIIllIIIllIlIIIlIlIll = llllllllllllIIllIIIllIlIIIlIIlIl;
            }
        }
        return llllllllllllIIllIIIllIlIIIlIlIlI;
    }
    
    private boolean isBlocked(final World llllllllllllIIllIIIllIlIIIIlIllI, final BlockPos llllllllllllIIllIIIllIlIIIIlIIIl, final IBlockState llllllllllllIIllIIIllIlIIIIlIlII) {
        final Block llllllllllllIIllIIIllIlIIIIlIIll = llllllllllllIIllIIIllIlIIIIlIllI.getBlockState(llllllllllllIIllIIIllIlIIIIlIIIl).getBlock();
        return llllllllllllIIllIIIllIlIIIIlIIll instanceof BlockDoor || llllllllllllIIllIIIllIlIIIIlIIll == Blocks.STANDING_SIGN || llllllllllllIIllIIIllIlIIIIlIIll == Blocks.LADDER || llllllllllllIIllIIIllIlIIIIlIIll == Blocks.REEDS || llllllllllllIIllIIIllIlIIIIlIIll.blockMaterial == Material.PORTAL || llllllllllllIIllIIIllIlIIIIlIIll.blockMaterial == Material.STRUCTURE_VOID || llllllllllllIIllIIIllIlIIIIlIIll.blockMaterial.blocksMovement();
    }
    
    private void placeStaticBlock(final World llllllllllllIIllIIIllIlIlIIlllll, final BlockPos llllllllllllIIllIIIllIlIlIIllIlI, final IBlockState llllllllllllIIllIIIllIlIlIIlllIl) {
        llllllllllllIIllIIIllIlIlIIlllll.setBlockState(llllllllllllIIllIIIllIlIlIIllIlI, BlockLiquid.getStaticBlock(this.blockMaterial).getDefaultState().withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, (Integer)llllllllllllIIllIIIllIlIlIIlllIl.getValue((IProperty<V>)BlockDynamicLiquid.LEVEL)), 2);
    }
    
    protected BlockDynamicLiquid(final Material llllllllllllIIllIIIllIlIlIlIIlll) {
        super(llllllllllllIIllIIIllIlIlIlIIlll);
    }
    
    private boolean canFlowInto(final World llllllllllllIIllIIIllIIllllllIlI, final BlockPos llllllllllllIIllIIIllIIllllllIIl, final IBlockState llllllllllllIIllIIIllIIllllllIII) {
        final Material llllllllllllIIllIIIllIIlllllIlll = llllllllllllIIllIIIllIIllllllIII.getMaterial();
        return llllllllllllIIllIIIllIIlllllIlll != this.blockMaterial && llllllllllllIIllIIIllIIlllllIlll != Material.LAVA && !this.isBlocked(llllllllllllIIllIIIllIIllllllIlI, llllllllllllIIllIIIllIIllllllIIl, llllllllllllIIllIIIllIIllllllIII);
    }
    
    private void tryFlowInto(final World llllllllllllIIllIIIllIlIIllIIIlI, final BlockPos llllllllllllIIllIIIllIlIIllIIllI, final IBlockState llllllllllllIIllIIIllIlIIllIIlIl, final int llllllllllllIIllIIIllIlIIllIIlII) {
        if (this.canFlowInto(llllllllllllIIllIIIllIlIIllIIIlI, llllllllllllIIllIIIllIlIIllIIllI, llllllllllllIIllIIIllIlIIllIIlIl)) {
            if (llllllllllllIIllIIIllIlIIllIIlIl.getMaterial() != Material.AIR) {
                if (this.blockMaterial == Material.LAVA) {
                    this.triggerMixEffects(llllllllllllIIllIIIllIlIIllIIIlI, llllllllllllIIllIIIllIlIIllIIllI);
                }
                else {
                    llllllllllllIIllIIIllIlIIllIIlIl.getBlock().dropBlockAsItem(llllllllllllIIllIIIllIlIIllIIIlI, llllllllllllIIllIIIllIlIIllIIllI, llllllllllllIIllIIIllIlIIllIIlIl, 0);
                }
            }
            llllllllllllIIllIIIllIlIIllIIIlI.setBlockState(llllllllllllIIllIIIllIlIIllIIllI, this.getDefaultState().withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, llllllllllllIIllIIIllIlIIllIIlII), 3);
        }
    }
    
    protected int checkAdjacentBlock(final World llllllllllllIIllIIIllIlIIIIIlIIl, final BlockPos llllllllllllIIllIIIllIlIIIIIlIII, final int llllllllllllIIllIIIllIlIIIIIIlll) {
        int llllllllllllIIllIIIllIlIIIIIIllI = this.getDepth(llllllllllllIIllIIIllIlIIIIIlIIl.getBlockState(llllllllllllIIllIIIllIlIIIIIlIII));
        if (llllllllllllIIllIIIllIlIIIIIIllI < 0) {
            return llllllllllllIIllIIIllIlIIIIIIlll;
        }
        if (llllllllllllIIllIIIllIlIIIIIIllI == 0) {
            ++this.adjacentSourceBlocks;
        }
        if (llllllllllllIIllIIIllIlIIIIIIllI >= 8) {
            llllllllllllIIllIIIllIlIIIIIIllI = 0;
        }
        return (llllllllllllIIllIIIllIlIIIIIIlll >= 0 && llllllllllllIIllIIIllIlIIIIIIllI >= llllllllllllIIllIIIllIlIIIIIIlll) ? llllllllllllIIllIIIllIlIIIIIIlll : llllllllllllIIllIIIllIlIIIIIIllI;
    }
    
    private int getSlopeDistance(final World llllllllllllIIllIIIllIlIIlIlIIlI, final BlockPos llllllllllllIIllIIIllIlIIlIlIIIl, final int llllllllllllIIllIIIllIlIIlIIIllI, final EnumFacing llllllllllllIIllIIIllIlIIlIIllll) {
        int llllllllllllIIllIIIllIlIIlIIlllI = 1000;
        for (final EnumFacing llllllllllllIIllIIIllIlIIlIIllIl : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllIIllIIIllIlIIlIIllIl != llllllllllllIIllIIIllIlIIlIIllll) {
                final BlockPos llllllllllllIIllIIIllIlIIlIIllII = llllllllllllIIllIIIllIlIIlIlIIIl.offset(llllllllllllIIllIIIllIlIIlIIllIl);
                final IBlockState llllllllllllIIllIIIllIlIIlIIlIll = llllllllllllIIllIIIllIlIIlIlIIlI.getBlockState(llllllllllllIIllIIIllIlIIlIIllII);
                if (this.isBlocked(llllllllllllIIllIIIllIlIIlIlIIlI, llllllllllllIIllIIIllIlIIlIIllII, llllllllllllIIllIIIllIlIIlIIlIll) || (llllllllllllIIllIIIllIlIIlIIlIll.getMaterial() == this.blockMaterial && llllllllllllIIllIIIllIlIIlIIlIll.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) <= 0)) {
                    continue;
                }
                if (!this.isBlocked(llllllllllllIIllIIIllIlIIlIlIIlI, llllllllllllIIllIIIllIlIIlIIllII.down(), llllllllllllIIllIIIllIlIIlIIlIll)) {
                    return llllllllllllIIllIIIllIlIIlIIIllI;
                }
                if (llllllllllllIIllIIIllIlIIlIIIllI >= this.getSlopeFindDistance(llllllllllllIIllIIIllIlIIlIlIIlI)) {
                    continue;
                }
                final int llllllllllllIIllIIIllIlIIlIIlIlI = this.getSlopeDistance(llllllllllllIIllIIIllIlIIlIlIIlI, llllllllllllIIllIIIllIlIIlIIllII, llllllllllllIIllIIIllIlIIlIIIllI + 1, llllllllllllIIllIIIllIlIIlIIllIl.getOpposite());
                if (llllllllllllIIllIIIllIlIIlIIlIlI >= llllllllllllIIllIIIllIlIIlIIlllI) {
                    continue;
                }
                llllllllllllIIllIIIllIlIIlIIlllI = llllllllllllIIllIIIllIlIIlIIlIlI;
            }
        }
        return llllllllllllIIllIIIllIlIIlIIlllI;
    }
    
    private int getSlopeFindDistance(final World llllllllllllIIllIIIllIlIIIlllIll) {
        return (this.blockMaterial == Material.LAVA && !llllllllllllIIllIIIllIlIIIlllIll.provider.doesWaterVaporize()) ? 2 : 4;
    }
    
    @Override
    public void updateTick(final World llllllllllllIIllIIIllIlIlIIIlIlI, final BlockPos llllllllllllIIllIIIllIlIlIIIlIIl, IBlockState llllllllllllIIllIIIllIlIIlllIlll, final Random llllllllllllIIllIIIllIlIIlllIllI) {
        int llllllllllllIIllIIIllIlIlIIIIllI = llllllllllllIIllIIIllIlIIlllIlll.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL);
        int llllllllllllIIllIIIllIlIlIIIIlIl = 1;
        if (this.blockMaterial == Material.LAVA && !llllllllllllIIllIIIllIlIlIIIlIlI.provider.doesWaterVaporize()) {
            llllllllllllIIllIIIllIlIlIIIIlIl = 2;
        }
        int llllllllllllIIllIIIllIlIlIIIIlII = this.tickRate(llllllllllllIIllIIIllIlIlIIIlIlI);
        if (llllllllllllIIllIIIllIlIlIIIIllI > 0) {
            int llllllllllllIIllIIIllIlIlIIIIIll = -100;
            this.adjacentSourceBlocks = 0;
            for (final EnumFacing llllllllllllIIllIIIllIlIlIIIIIlI : EnumFacing.Plane.HORIZONTAL) {
                llllllllllllIIllIIIllIlIlIIIIIll = this.checkAdjacentBlock(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.offset(llllllllllllIIllIIIllIlIlIIIIIlI), llllllllllllIIllIIIllIlIlIIIIIll);
            }
            int llllllllllllIIllIIIllIlIlIIIIIIl = llllllllllllIIllIIIllIlIlIIIIIll + llllllllllllIIllIIIllIlIlIIIIlIl;
            if (llllllllllllIIllIIIllIlIlIIIIIIl >= 8 || llllllllllllIIllIIIllIlIlIIIIIll < 0) {
                llllllllllllIIllIIIllIlIlIIIIIIl = -1;
            }
            final int llllllllllllIIllIIIllIlIlIIIIIII = this.getDepth(llllllllllllIIllIIIllIlIlIIIlIlI.getBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.up()));
            if (llllllllllllIIllIIIllIlIlIIIIIII >= 0) {
                if (llllllllllllIIllIIIllIlIlIIIIIII >= 8) {
                    llllllllllllIIllIIIllIlIlIIIIIIl = llllllllllllIIllIIIllIlIlIIIIIII;
                }
                else {
                    llllllllllllIIllIIIllIlIlIIIIIIl = llllllllllllIIllIIIllIlIlIIIIIII + 8;
                }
            }
            if (this.adjacentSourceBlocks >= 2 && this.blockMaterial == Material.WATER) {
                final IBlockState llllllllllllIIllIIIllIlIIlllllll = llllllllllllIIllIIIllIlIlIIIlIlI.getBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.down());
                if (llllllllllllIIllIIIllIlIIlllllll.getMaterial().isSolid()) {
                    llllllllllllIIllIIIllIlIlIIIIIIl = 0;
                }
                else if (llllllllllllIIllIIIllIlIIlllllll.getMaterial() == this.blockMaterial && llllllllllllIIllIIIllIlIIlllllll.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) == 0) {
                    llllllllllllIIllIIIllIlIlIIIIIIl = 0;
                }
            }
            if (this.blockMaterial == Material.LAVA && llllllllllllIIllIIIllIlIlIIIIllI < 8 && llllllllllllIIllIIIllIlIlIIIIIIl < 8 && llllllllllllIIllIIIllIlIlIIIIIIl > llllllllllllIIllIIIllIlIlIIIIllI && llllllllllllIIllIIIllIlIIlllIllI.nextInt(4) != 0) {
                llllllllllllIIllIIIllIlIlIIIIlII *= 4;
            }
            if (llllllllllllIIllIIIllIlIlIIIIIIl == llllllllllllIIllIIIllIlIlIIIIllI) {
                this.placeStaticBlock(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl, llllllllllllIIllIIIllIlIIlllIlll);
            }
            else if ((llllllllllllIIllIIIllIlIlIIIIllI = llllllllllllIIllIIIllIlIlIIIIIIl) < 0) {
                llllllllllllIIllIIIllIlIlIIIlIlI.setBlockToAir(llllllllllllIIllIIIllIlIlIIIlIIl);
            }
            else {
                llllllllllllIIllIIIllIlIIlllIlll = llllllllllllIIllIIIllIlIIlllIlll.withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, llllllllllllIIllIIIllIlIlIIIIIIl);
                llllllllllllIIllIIIllIlIlIIIlIlI.setBlockState(llllllllllllIIllIIIllIlIlIIIlIIl, llllllllllllIIllIIIllIlIIlllIlll, 2);
                llllllllllllIIllIIIllIlIlIIIlIlI.scheduleUpdate(llllllllllllIIllIIIllIlIlIIIlIIl, this, llllllllllllIIllIIIllIlIlIIIIlII);
                llllllllllllIIllIIIllIlIlIIIlIlI.notifyNeighborsOfStateChange(llllllllllllIIllIIIllIlIlIIIlIIl, this, false);
            }
        }
        else {
            this.placeStaticBlock(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl, llllllllllllIIllIIIllIlIIlllIlll);
        }
        final IBlockState llllllllllllIIllIIIllIlIIllllllI = llllllllllllIIllIIIllIlIlIIIlIlI.getBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.down());
        if (this.canFlowInto(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.down(), llllllllllllIIllIIIllIlIIllllllI)) {
            if (this.blockMaterial == Material.LAVA && llllllllllllIIllIIIllIlIlIIIlIlI.getBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.down()).getMaterial() == Material.WATER) {
                llllllllllllIIllIIIllIlIlIIIlIlI.setBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.down(), Blocks.STONE.getDefaultState());
                this.triggerMixEffects(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.down());
                return;
            }
            if (llllllllllllIIllIIIllIlIlIIIIllI >= 8) {
                this.tryFlowInto(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.down(), llllllllllllIIllIIIllIlIIllllllI, llllllllllllIIllIIIllIlIlIIIIllI);
            }
            else {
                this.tryFlowInto(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.down(), llllllllllllIIllIIIllIlIIllllllI, llllllllllllIIllIIIllIlIlIIIIllI + 8);
            }
        }
        else if (llllllllllllIIllIIIllIlIlIIIIllI >= 0 && (llllllllllllIIllIIIllIlIlIIIIllI == 0 || this.isBlocked(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.down(), llllllllllllIIllIIIllIlIIllllllI))) {
            final Set<EnumFacing> llllllllllllIIllIIIllIlIIlllllIl = this.getPossibleFlowDirections(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl);
            int llllllllllllIIllIIIllIlIIlllllII = llllllllllllIIllIIIllIlIlIIIIllI + llllllllllllIIllIIIllIlIlIIIIlIl;
            if (llllllllllllIIllIIIllIlIlIIIIllI >= 8) {
                llllllllllllIIllIIIllIlIIlllllII = 1;
            }
            if (llllllllllllIIllIIIllIlIIlllllII >= 8) {
                return;
            }
            for (final EnumFacing llllllllllllIIllIIIllIlIIllllIll : llllllllllllIIllIIIllIlIIlllllIl) {
                this.tryFlowInto(llllllllllllIIllIIIllIlIlIIIlIlI, llllllllllllIIllIIIllIlIlIIIlIIl.offset(llllllllllllIIllIIIllIlIIllllIll), llllllllllllIIllIIIllIlIlIIIlIlI.getBlockState(llllllllllllIIllIIIllIlIlIIIlIIl.offset(llllllllllllIIllIIIllIlIIllllIll)), llllllllllllIIllIIIllIlIIlllllII);
            }
        }
    }
}
