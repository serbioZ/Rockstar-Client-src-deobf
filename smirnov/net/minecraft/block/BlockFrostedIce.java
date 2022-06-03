// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;

public class BlockFrostedIce extends BlockIce
{
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public void updateTick(final World llllllllllIlllllIlIIIlllIIllIlII, final BlockPos llllllllllIlllllIlIIIlllIIlllIII, final IBlockState llllllllllIlllllIlIIIlllIIllIlll, final Random llllllllllIlllllIlIIIlllIIllIllI) {
        if ((llllllllllIlllllIlIIIlllIIllIllI.nextInt(3) == 0 || this.countNeighbors(llllllllllIlllllIlIIIlllIIllIlII, llllllllllIlllllIlIIIlllIIlllIII) < 4) && llllllllllIlllllIlIIIlllIIllIlII.getLightFromNeighbors(llllllllllIlllllIlIIIlllIIlllIII) > 11 - llllllllllIlllllIlIIIlllIIllIlll.getValue((IProperty<Integer>)BlockFrostedIce.AGE) - llllllllllIlllllIlIIIlllIIllIlll.getLightOpacity()) {
            this.slightlyMelt(llllllllllIlllllIlIIIlllIIllIlII, llllllllllIlllllIlIIIlllIIlllIII, llllllllllIlllllIlIIIlllIIllIlll, llllllllllIlllllIlIIIlllIIllIllI, true);
        }
        else {
            llllllllllIlllllIlIIIlllIIllIlII.scheduleUpdate(llllllllllIlllllIlIIIlllIIlllIII, this, MathHelper.getInt(llllllllllIlllllIlIIIlllIIllIllI, 20, 40));
        }
    }
    
    @Override
    public ItemStack getItem(final World llllllllllIlllllIlIIIllIlllIIIlI, final BlockPos llllllllllIlllllIlIIIllIlllIIIIl, final IBlockState llllllllllIlllllIlIIIllIlllIIIII) {
        return ItemStack.field_190927_a;
    }
    
    protected void slightlyMelt(final World llllllllllIlllllIlIIIllIllllllII, final BlockPos llllllllllIlllllIlIIIllIlllllIll, final IBlockState llllllllllIlllllIlIIIllIlllllIlI, final Random llllllllllIlllllIlIIIllIlllIllll, final boolean llllllllllIlllllIlIIIllIlllllIII) {
        final int llllllllllIlllllIlIIIllIllllIlll = llllllllllIlllllIlIIIllIlllllIlI.getValue((IProperty<Integer>)BlockFrostedIce.AGE);
        if (llllllllllIlllllIlIIIllIllllIlll < 3) {
            llllllllllIlllllIlIIIllIllllllII.setBlockState(llllllllllIlllllIlIIIllIlllllIll, llllllllllIlllllIlIIIllIlllllIlI.withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, llllllllllIlllllIlIIIllIllllIlll + 1), 2);
            llllllllllIlllllIlIIIllIllllllII.scheduleUpdate(llllllllllIlllllIlIIIllIlllllIll, this, MathHelper.getInt(llllllllllIlllllIlIIIllIlllIllll, 20, 40));
        }
        else {
            this.turnIntoWater(llllllllllIlllllIlIIIllIllllllII, llllllllllIlllllIlIIIllIlllllIll);
            if (llllllllllIlllllIlIIIllIlllllIII) {
                final char llllllllllIlllllIlIIIllIlllIlIIl;
                final short llllllllllIlllllIlIIIllIlllIlIlI = (short)((EnumFacing[])(Object)(llllllllllIlllllIlIIIllIlllIlIIl = (char)(Object)EnumFacing.values())).length;
                for (float llllllllllIlllllIlIIIllIlllIlIll = 0; llllllllllIlllllIlIIIllIlllIlIll < llllllllllIlllllIlIIIllIlllIlIlI; ++llllllllllIlllllIlIIIllIlllIlIll) {
                    final EnumFacing llllllllllIlllllIlIIIllIllllIllI = llllllllllIlllllIlIIIllIlllIlIIl[llllllllllIlllllIlIIIllIlllIlIll];
                    final BlockPos llllllllllIlllllIlIIIllIllllIlIl = llllllllllIlllllIlIIIllIlllllIll.offset(llllllllllIlllllIlIIIllIllllIllI);
                    final IBlockState llllllllllIlllllIlIIIllIllllIlII = llllllllllIlllllIlIIIllIllllllII.getBlockState(llllllllllIlllllIlIIIllIllllIlIl);
                    if (llllllllllIlllllIlIIIllIllllIlII.getBlock() == this) {
                        this.slightlyMelt(llllllllllIlllllIlIIIllIllllllII, llllllllllIlllllIlIIIllIllllIlIl, llllllllllIlllllIlIIIllIllllIlII, llllllllllIlllllIlIIIllIlllIllll, false);
                    }
                }
            }
        }
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 3);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFrostedIce.AGE });
    }
    
    public BlockFrostedIce() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, 0));
    }
    
    private int countNeighbors(final World llllllllllIlllllIlIIIlllIIIlIIIl, final BlockPos llllllllllIlllllIlIIIlllIIIlIlIl) {
        int llllllllllIlllllIlIIIlllIIIlIlII = 0;
        final int llllllllllIlllllIlIIIlllIIIIlIll;
        final double llllllllllIlllllIlIIIlllIIIIllII = ((EnumFacing[])(Object)(llllllllllIlllllIlIIIlllIIIIlIll = (int)(Object)EnumFacing.values())).length;
        for (final EnumFacing llllllllllIlllllIlIIIlllIIIlIIll : llllllllllIlllllIlIIIlllIIIIlIll) {
            if (llllllllllIlllllIlIIIlllIIIlIIIl.getBlockState(llllllllllIlllllIlIIIlllIIIlIlIl.offset(llllllllllIlllllIlIIIlllIIIlIIll)).getBlock() == this && ++llllllllllIlllllIlIIIlllIIIlIlII >= 4) {
                return llllllllllIlllllIlIIIlllIIIlIlII;
            }
        }
        return llllllllllIlllllIlIIIlllIIIlIlII;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllIlllllIlIIIlllIIlIlIlI, final World llllllllllIlllllIlIIIlllIIlIlIIl, final BlockPos llllllllllIlllllIlIIIlllIIlIlIII, final Block llllllllllIlllllIlIIIlllIIlIIIIl, final BlockPos llllllllllIlllllIlIIIlllIIlIIllI) {
        if (llllllllllIlllllIlIIIlllIIlIIIIl == this) {
            final int llllllllllIlllllIlIIIlllIIlIIlIl = this.countNeighbors(llllllllllIlllllIlIIIlllIIlIlIIl, llllllllllIlllllIlIIIlllIIlIlIII);
            if (llllllllllIlllllIlIIIlllIIlIIlIl < 2) {
                this.turnIntoWater(llllllllllIlllllIlIIIlllIIlIlIIl, llllllllllIlllllIlIIIlllIIlIlIII);
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIlllllIlIIIlllIlIIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, MathHelper.clamp(llllllllllIlllllIlIIIlllIlIIIIlI, 0, 3));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIlllllIlIIIlllIlIIIllI) {
        return llllllllllIlllllIlIIIlllIlIIIllI.getValue((IProperty<Integer>)BlockFrostedIce.AGE);
    }
}
