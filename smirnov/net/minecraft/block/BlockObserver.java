// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public class BlockObserver extends BlockDirectional
{
    public static final /* synthetic */ PropertyBool field_190963_a;
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIlIllIIlIlIlllllllI, final BlockPos llllllllllllIIlIllIIlIlIllllllIl, final EnumFacing llllllllllllIIlIllIIlIlIllllllII, final float llllllllllllIIlIllIIlIlIlllllIll, final float llllllllllllIIlIllIIlIlIlllllIlI, final float llllllllllllIIlIllIIlIlIlllllIIl, final int llllllllllllIIlIllIIlIlIlllllIII, final EntityLivingBase llllllllllllIIlIllIIlIlIllllIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.func_190914_a(llllllllllllIIlIllIIlIlIllllllIl, llllllllllllIIlIllIIlIlIllllIlll).getOpposite());
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlIllIIlIlIllllIIII) {
        int llllllllllllIIlIllIIlIlIlllIllll = 0;
        llllllllllllIIlIllIIlIlIlllIllll |= llllllllllllIIlIllIIlIlIllllIIII.getValue((IProperty<EnumFacing>)BlockObserver.FACING).getIndex();
        if (llllllllllllIIlIllIIlIlIllllIIII.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
            llllllllllllIIlIllIIlIlIlllIllll |= 0x8;
        }
        return llllllllllllIIlIllIIlIlIlllIllll;
    }
    
    public BlockObserver() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlIllIIlIlIlllIlIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.getFront(llllllllllllIIlIllIIlIlIlllIlIIl & 0x7));
    }
    
    protected void func_190961_e(final World llllllllllllIIlIllIIlIllIIllIlll, final BlockPos llllllllllllIIlIllIIlIllIIllllII, final IBlockState llllllllllllIIlIllIIlIllIIllIlIl) {
        final EnumFacing llllllllllllIIlIllIIlIllIIlllIlI = llllllllllllIIlIllIIlIllIIllIlIl.getValue((IProperty<EnumFacing>)BlockObserver.FACING);
        final BlockPos llllllllllllIIlIllIIlIllIIlllIIl = llllllllllllIIlIllIIlIllIIllllII.offset(llllllllllllIIlIllIIlIllIIlllIlI.getOpposite());
        llllllllllllIIlIllIIlIllIIllIlll.func_190524_a(llllllllllllIIlIllIIlIllIIlllIIl, this, llllllllllllIIlIllIIlIllIIllllII);
        llllllllllllIIlIllIIlIllIIllIlll.notifyNeighborsOfStateExcept(llllllllllllIIlIllIIlIllIIlllIIl, this, llllllllllllIIlIllIIlIllIIlllIlI);
    }
    
    @Override
    public int getStrongPower(final IBlockState llllllllllllIIlIllIIlIllIIlIIlll, final IBlockAccess llllllllllllIIlIllIIlIllIIlIIllI, final BlockPos llllllllllllIIlIllIIlIllIIlIIlIl, final EnumFacing llllllllllllIIlIllIIlIllIIlIlIII) {
        return llllllllllllIIlIllIIlIllIIlIIlll.getWeakPower(llllllllllllIIlIllIIlIllIIlIIllI, llllllllllllIIlIllIIlIllIIlIIlIl, llllllllllllIIlIllIIlIllIIlIlIII);
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIlIllIIlIllIIIIIlIl, final BlockPos llllllllllllIIlIllIIlIllIIIIlIII, final IBlockState llllllllllllIIlIllIIlIllIIIIIIll) {
        if (llllllllllllIIlIllIIlIllIIIIIIll.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && llllllllllllIIlIllIIlIllIIIIIlIl.isUpdateScheduled(llllllllllllIIlIllIIlIllIIIIlIII, this)) {
            this.func_190961_e(llllllllllllIIlIllIIlIllIIIIIlIl, llllllllllllIIlIllIIlIllIIIIlIII, llllllllllllIIlIllIIlIllIIIIIIll.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false));
        }
    }
    
    @Override
    public boolean canProvidePower(final IBlockState llllllllllllIIlIllIIlIllIIllIIIl) {
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIIlIllIIlIllIllIIlIl, final World llllllllllllIIlIllIIlIllIllIIlII, final BlockPos llllllllllllIIlIllIIlIllIllIIIll, final Block llllllllllllIIlIllIIlIllIllIIIlI, final BlockPos llllllllllllIIlIllIIlIllIllIIIIl) {
    }
    
    private void func_190960_d(final IBlockState llllllllllllIIlIllIIlIllIlIIlIll, final World llllllllllllIIlIllIIlIllIlIIIllI, final BlockPos llllllllllllIIlIllIIlIllIlIIlIIl) {
        if (!llllllllllllIIlIllIIlIllIlIIlIll.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && !llllllllllllIIlIllIIlIllIlIIIllI.isUpdateScheduled(llllllllllllIIlIllIIlIllIlIIlIIl, this)) {
            llllllllllllIIlIllIIlIllIlIIIllI.scheduleUpdate(llllllllllllIIlIllIIlIllIlIIlIIl, this, 2);
        }
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIIlIllIIlIllIIIlIlIl, final BlockPos llllllllllllIIlIllIIlIllIIIlIIII, final IBlockState llllllllllllIIlIllIIlIllIIIlIIll) {
        if (!llllllllllllIIlIllIIlIllIIIlIlIl.isRemote) {
            if (llllllllllllIIlIllIIlIllIIIlIIll.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
                this.updateTick(llllllllllllIIlIllIIlIllIIIlIlIl, llllllllllllIIlIllIIlIllIIIlIIII, llllllllllllIIlIllIIlIllIIIlIIll, llllllllllllIIlIllIIlIllIIIlIlIl.rand);
            }
            this.func_190960_d(llllllllllllIIlIllIIlIllIIIlIIll, llllllllllllIIlIllIIlIllIIIlIlIl, llllllllllllIIlIllIIlIllIIIlIIII);
        }
    }
    
    static {
        field_190963_a = PropertyBool.create("powered");
    }
    
    @Override
    public void updateTick(final World llllllllllllIIlIllIIlIllIllIlIIl, final BlockPos llllllllllllIIlIllIIlIllIllIllIl, final IBlockState llllllllllllIIlIllIIlIllIllIllII, final Random llllllllllllIIlIllIIlIllIllIlIll) {
        if (llllllllllllIIlIllIIlIllIllIllII.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
            llllllllllllIIlIllIIlIllIllIlIIl.setBlockState(llllllllllllIIlIllIIlIllIllIllIl, llllllllllllIIlIllIIlIllIllIllII.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false), 2);
        }
        else {
            llllllllllllIIlIllIIlIllIllIlIIl.setBlockState(llllllllllllIIlIllIIlIllIllIllIl, llllllllllllIIlIllIIlIllIllIllII.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, true), 2);
            llllllllllllIIlIllIIlIllIllIlIIl.scheduleUpdate(llllllllllllIIlIllIIlIllIllIllIl, this, 2);
        }
        this.func_190961_e(llllllllllllIIlIllIIlIllIllIlIIl, llllllllllllIIlIllIIlIllIllIllIl, llllllllllllIIlIllIIlIllIllIllII);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIlIllIIlIllIllllllI, final Rotation llllllllllllIIlIllIIlIllIlllllIl) {
        return llllllllllllIIlIllIIlIllIllllllI.withProperty((IProperty<Comparable>)BlockObserver.FACING, llllllllllllIIlIllIIlIllIlllllIl.rotate(llllllllllllIIlIllIIlIllIllllllI.getValue((IProperty<EnumFacing>)BlockObserver.FACING)));
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIlIllIIlIllIlllIlll, final Mirror llllllllllllIIlIllIIlIllIlllIllI) {
        return llllllllllllIIlIllIIlIllIlllIlll.withRotation(llllllllllllIIlIllIIlIllIlllIllI.toRotation(llllllllllllIIlIllIIlIllIlllIlll.getValue((IProperty<EnumFacing>)BlockObserver.FACING)));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockObserver.FACING, BlockObserver.field_190963_a });
    }
    
    @Override
    public int getWeakPower(final IBlockState llllllllllllIIlIllIIlIllIIIlllII, final IBlockAccess llllllllllllIIlIllIIlIllIIIlllll, final BlockPos llllllllllllIIlIllIIlIllIIIllllI, final EnumFacing llllllllllllIIlIllIIlIllIIIlllIl) {
        return (llllllllllllIIlIllIIlIllIIIlllII.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && llllllllllllIIlIllIIlIllIIIlllII.getValue((IProperty<Comparable>)BlockObserver.FACING) == llllllllllllIIlIllIIlIllIIIlllIl) ? 15 : 0;
    }
    
    public void func_190962_b(final IBlockState llllllllllllIIlIllIIlIllIlIllIlI, final World llllllllllllIIlIllIIlIllIlIlIIll, final BlockPos llllllllllllIIlIllIIlIllIlIlIIlI, final Block llllllllllllIIlIllIIlIllIlIlIlll, final BlockPos llllllllllllIIlIllIIlIllIlIlIIIl) {
        if (!llllllllllllIIlIllIIlIllIlIlIIll.isRemote && llllllllllllIIlIllIIlIllIlIlIIlI.offset(llllllllllllIIlIllIIlIllIlIllIlI.getValue((IProperty<EnumFacing>)BlockObserver.FACING)).equals(llllllllllllIIlIllIIlIllIlIlIIIl)) {
            this.func_190960_d(llllllllllllIIlIllIIlIllIlIllIlI, llllllllllllIIlIllIIlIllIlIlIIll, llllllllllllIIlIllIIlIllIlIlIIlI);
        }
    }
}
