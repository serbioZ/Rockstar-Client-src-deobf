// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumHand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockFenceGate extends BlockHorizontal
{
    public static final /* synthetic */ PropertyBool POWERED;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_XAXIS_INWALL;
    protected static final /* synthetic */ AxisAlignedBB AABB_CLOSED_SELECTED_ZAXIS;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_ZAXIS_INWALL;
    public static final /* synthetic */ PropertyBool IN_WALL;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_XAXIS;
    public static final /* synthetic */ PropertyBool OPEN;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_ZAXIS;
    protected static final /* synthetic */ AxisAlignedBB AABB_CLOSED_SELECTED_XAXIS;
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlllllllIIlllIllIllI) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState llllllllllllIlllllllIIlllllIIlII, final IBlockAccess llllllllllllIlllllllIIlllllIIlll, final BlockPos llllllllllllIlllllllIIlllllIIIlI) {
        llllllllllllIlllllllIIlllllIIlII = (boolean)this.getActualState((IBlockState)llllllllllllIlllllllIIlllllIIlII, llllllllllllIlllllllIIlllllIIlll, llllllllllllIlllllllIIlllllIIIlI);
        if (((IBlockState)llllllllllllIlllllllIIlllllIIlII).getValue((IProperty<Boolean>)BlockFenceGate.IN_WALL)) {
            return (((IBlockState)llllllllllllIlllllllIIlllllIIlII).getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.X) ? BlockFenceGate.AABB_COLLIDE_XAXIS_INWALL : BlockFenceGate.AABB_COLLIDE_ZAXIS_INWALL;
        }
        return (((IBlockState)llllllllllllIlllllllIIlllllIIlII).getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.X) ? BlockFenceGate.AABB_COLLIDE_XAXIS : BlockFenceGate.AABB_COLLIDE_ZAXIS;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlllllllIIllIllIllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFenceGate.FACING, EnumFacing.getHorizontal(llllllllllllIlllllllIIllIllIllII)).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, (llllllllllllIlllllllIIllIllIllII & 0x4) != 0x0).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, (llllllllllllIlllllllIIllIllIllII & 0x8) != 0x0);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlllllllIIllIllllllI, final World llllllllllllIlllllllIIllIlllIlll, final BlockPos llllllllllllIlllllllIIllIlllllII, final Block llllllllllllIlllllllIIllIllllIll, final BlockPos llllllllllllIlllllllIIllIllllIlI) {
        if (!llllllllllllIlllllllIIllIlllIlll.isRemote) {
            final boolean llllllllllllIlllllllIIllIllllIIl = llllllllllllIlllllllIIllIlllIlll.isBlockPowered(llllllllllllIlllllllIIllIlllllII);
            if (llllllllllllIlllllllIIllIllllllI.getValue((IProperty<Boolean>)BlockFenceGate.POWERED) != llllllllllllIlllllllIIllIllllIIl) {
                llllllllllllIlllllllIIllIlllIlll.setBlockState(llllllllllllIlllllllIIllIlllllII, llllllllllllIlllllllIIllIllllllI.withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, llllllllllllIlllllllIIllIllllIIl).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, llllllllllllIlllllllIIllIllllIIl), 2);
                if (llllllllllllIlllllllIIllIllllllI.getValue((IProperty<Boolean>)BlockFenceGate.OPEN) != llllllllllllIlllllllIIllIllllIIl) {
                    llllllllllllIlllllllIIllIlllIlll.playEvent(null, llllllllllllIlllllllIIllIllllIIl ? 1008 : 1014, llllllllllllIlllllllIIllIlllllII, 0);
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFenceGate.FACING, BlockFenceGate.OPEN, BlockFenceGate.POWERED, BlockFenceGate.IN_WALL });
    }
    
    static {
        OPEN = PropertyBool.create("open");
        POWERED = PropertyBool.create("powered");
        IN_WALL = PropertyBool.create("in_wall");
        AABB_COLLIDE_ZAXIS = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625);
        AABB_COLLIDE_XAXIS = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0);
        AABB_COLLIDE_ZAXIS_INWALL = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 0.8125, 0.625);
        AABB_COLLIDE_XAXIS_INWALL = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 0.8125, 1.0);
        AABB_CLOSED_SELECTED_ZAXIS = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.5, 0.625);
        AABB_CLOSED_SELECTED_XAXIS = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.5, 1.0);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIlllllllIIllIlllIIll, final IBlockAccess llllllllllllIlllllllIIllIlllIIlI, final BlockPos llllllllllllIlllllllIIllIlllIIIl, final EnumFacing llllllllllllIlllllllIIllIlllIIII) {
        return true;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIlllllllIIllllIIlIII, final Mirror llllllllllllIlllllllIIllllIIlIIl) {
        return llllllllllllIlllllllIIllllIIlIII.withRotation(llllllllllllIlllllllIIllllIIlIIl.toRotation(llllllllllllIlllllllIIllllIIlIII.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING)));
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlllllllIIlllIllllll, final BlockPos llllllllllllIlllllllIIlllIlllllI) {
        return llllllllllllIlllllllIIlllIllllll.getBlockState(llllllllllllIlllllllIIlllIlllllI.down()).getMaterial().isSolid() && super.canPlaceBlockAt(llllllllllllIlllllllIIlllIllllll, llllllllllllIlllllllIIlllIlllllI);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIlllllllIIlllIlllIll, final IBlockAccess llllllllllllIlllllllIIlllIlllIlI, final BlockPos llllllllllllIlllllllIIlllIlllIIl) {
        if (llllllllllllIlllllllIIlllIlllIll.getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            return BlockFenceGate.NULL_AABB;
        }
        return (llllllllllllIlllllllIIlllIlllIll.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.Z) ? BlockFenceGate.AABB_CLOSED_SELECTED_ZAXIS : BlockFenceGate.AABB_CLOSED_SELECTED_XAXIS;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllIlllllllIIlllIlIlllI, final BlockPos llllllllllllIlllllllIIlllIlIllll) {
        return llllllllllllIlllllllIIlllIlIlllI.getBlockState(llllllllllllIlllllllIIlllIlIllll).getValue((IProperty<Boolean>)BlockFenceGate.OPEN);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIlllllllIIlllIIlllII, final BlockPos llllllllllllIlllllllIIlllIlIIlIl, final EnumFacing llllllllllllIlllllllIIlllIlIIlII, final float llllllllllllIlllllllIIlllIlIIIll, final float llllllllllllIlllllllIIlllIlIIIlI, final float llllllllllllIlllllllIIlllIlIIIIl, final int llllllllllllIlllllllIIlllIlIIIII, final EntityLivingBase llllllllllllIlllllllIIlllIIllIlI) {
        final boolean llllllllllllIlllllllIIlllIIllllI = llllllllllllIlllllllIIlllIIlllII.isBlockPowered(llllllllllllIlllllllIIlllIlIIlIl);
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFenceGate.FACING, llllllllllllIlllllllIIlllIIllIlI.getHorizontalFacing()).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, llllllllllllIlllllllIIlllIIllllI).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, llllllllllllIlllllllIIlllIIllllI).withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, false);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlllllllIIllIllIIlII) {
        int llllllllllllIlllllllIIllIllIIlIl = 0;
        llllllllllllIlllllllIIllIllIIlIl |= llllllllllllIlllllllIIllIllIIlII.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getHorizontalIndex();
        if (llllllllllllIlllllllIIllIllIIlII.getValue((IProperty<Boolean>)BlockFenceGate.POWERED)) {
            llllllllllllIlllllllIIllIllIIlIl |= 0x8;
        }
        if (llllllllllllIlllllllIIllIllIIlII.getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            llllllllllllIlllllllIIllIllIIlIl |= 0x4;
        }
        return llllllllllllIlllllllIIllIllIIlIl;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIlllllllIIllllIlIIIl, final Rotation llllllllllllIlllllllIIllllIlIIII) {
        return llllllllllllIlllllllIIllllIlIIIl.withProperty((IProperty<Comparable>)BlockFenceGate.FACING, llllllllllllIlllllllIIllllIlIIII.rotate(llllllllllllIlllllllIIllllIlIIIl.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING)));
    }
    
    @Override
    public IBlockState getActualState(IBlockState llllllllllllIlllllllIIllllIllIII, final IBlockAccess llllllllllllIlllllllIIllllIllIll, final BlockPos llllllllllllIlllllllIIllllIlIllI) {
        final EnumFacing.Axis llllllllllllIlllllllIIllllIllIIl = llllllllllllIlllllllIIllllIllIII.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis();
        if ((llllllllllllIlllllllIIllllIllIIl == EnumFacing.Axis.Z && (llllllllllllIlllllllIIllllIllIll.getBlockState(llllllllllllIlllllllIIllllIlIllI.west()).getBlock() == Blocks.COBBLESTONE_WALL || llllllllllllIlllllllIIllllIllIll.getBlockState(llllllllllllIlllllllIIllllIlIllI.east()).getBlock() == Blocks.COBBLESTONE_WALL)) || (llllllllllllIlllllllIIllllIllIIl == EnumFacing.Axis.X && (llllllllllllIlllllllIIllllIllIll.getBlockState(llllllllllllIlllllllIIllllIlIllI.north()).getBlock() == Blocks.COBBLESTONE_WALL || llllllllllllIlllllllIIllllIllIll.getBlockState(llllllllllllIlllllllIIllllIlIllI.south()).getBlock() == Blocks.COBBLESTONE_WALL))) {
            llllllllllllIlllllllIIllllIllIII = llllllllllllIlllllllIIllllIllIII.withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, true);
        }
        return llllllllllllIlllllllIIllllIllIII;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlllllllIIlllIllIlII) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlllllllIIllIlIlllII, final IBlockState llllllllllllIlllllllIIllIlIllIII, final BlockPos llllllllllllIlllllllIIllIlIllIlI, final EnumFacing llllllllllllIlllllllIIllIlIllIIl) {
        if (llllllllllllIlllllllIIllIlIllIIl != EnumFacing.UP && llllllllllllIlllllllIIllIlIllIIl != EnumFacing.DOWN) {
            return (llllllllllllIlllllllIIllIlIllIII.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == llllllllllllIlllllllIIllIlIllIIl.rotateY().getAxis()) ? BlockFaceShape.MIDDLE_POLE : BlockFaceShape.UNDEFINED;
        }
        return BlockFaceShape.UNDEFINED;
    }
    
    public BlockFenceGate(final BlockPlanks.EnumType llllllllllllIlllllllIIlllllIlllI) {
        super(Material.WOOD, llllllllllllIlllllllIIlllllIlllI.getMapColor());
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, false).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, false).withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIlllllllIIlllIIlIIlI, final BlockPos llllllllllllIlllllllIIlllIIIIlll, IBlockState llllllllllllIlllllllIIlllIIIIllI, final EntityPlayer llllllllllllIlllllllIIlllIIIIlIl, final EnumHand llllllllllllIlllllllIIlllIIIlllI, final EnumFacing llllllllllllIlllllllIIlllIIIllIl, final float llllllllllllIlllllllIIlllIIIllII, final float llllllllllllIlllllllIIlllIIIlIll, final float llllllllllllIlllllllIIlllIIIlIlI) {
        if (((IBlockState)llllllllllllIlllllllIIlllIIIIllI).getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            llllllllllllIlllllllIIlllIIIIllI = ((IBlockState)llllllllllllIlllllllIIlllIIIIllI).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, Boolean.valueOf(false));
            llllllllllllIlllllllIIlllIIlIIlI.setBlockState(llllllllllllIlllllllIIlllIIIIlll, (IBlockState)llllllllllllIlllllllIIlllIIIIllI, 10);
        }
        else {
            final EnumFacing llllllllllllIlllllllIIlllIIIlIIl = EnumFacing.fromAngle(llllllllllllIlllllllIIlllIIIIlIl.rotationYaw);
            if (((IBlockState)llllllllllllIlllllllIIlllIIIIllI).getValue((IProperty<Comparable>)BlockFenceGate.FACING) == llllllllllllIlllllllIIlllIIIlIIl.getOpposite()) {
                llllllllllllIlllllllIIlllIIIIllI = ((IBlockState)llllllllllllIlllllllIIlllIIIIllI).withProperty((IProperty<Comparable>)BlockFenceGate.FACING, llllllllllllIlllllllIIlllIIIlIIl);
            }
            llllllllllllIlllllllIIlllIIIIllI = ((IBlockState)llllllllllllIlllllllIIlllIIIIllI).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, Boolean.valueOf(true));
            llllllllllllIlllllllIIlllIIlIIlI.setBlockState(llllllllllllIlllllllIIlllIIIIlll, (IBlockState)llllllllllllIlllllllIIlllIIIIllI, 10);
        }
        llllllllllllIlllllllIIlllIIlIIlI.playEvent(llllllllllllIlllllllIIlllIIIIlIl, ((boolean)((IBlockState)llllllllllllIlllllllIIlllIIIIllI).getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) ? 1008 : 1014, llllllllllllIlllllllIIlllIIIIlll, 0);
        return true;
    }
}
