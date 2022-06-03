// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockTrapDoor extends Block
{
    public static final /* synthetic */ PropertyBool OPEN;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_OPEN_AABB;
    public static final /* synthetic */ PropertyEnum<DoorHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB TOP_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB BOTTOM_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_OPEN_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_OPEN_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_OPEN_AABB;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlIIlIIllIlIlIlllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, getFacing(llllllllllllIIlIIlIIllIlIlIlllll)).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, (llllllllllllIIlIIlIIllIlIlIlllll & 0x4) != 0x0).withProperty(BlockTrapDoor.HALF, ((llllllllllllIIlIIlIIllIlIlIlllll & 0x8) == 0x0) ? DoorHalf.BOTTOM : DoorHalf.TOP);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTrapDoor.FACING, BlockTrapDoor.OPEN, BlockTrapDoor.HALF });
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        OPEN = PropertyBool.create("open");
        HALF = PropertyEnum.create("half", DoorHalf.class);
        EAST_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
        WEST_OPEN_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        SOUTH_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        NORTH_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
        BOTTOM_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0);
        TOP_AABB = new AxisAlignedBB(0.0, 0.8125, 0.0, 1.0, 1.0, 1.0);
    }
    
    protected static EnumFacing getFacing(final int llllllllllllIIlIIlIIllIlIllIlIII) {
        switch (llllllllllllIIlIIlIIllIlIllIlIII & 0x3) {
            case 0: {
                return EnumFacing.NORTH;
            }
            case 1: {
                return EnumFacing.SOUTH;
            }
            case 2: {
                return EnumFacing.WEST;
            }
            default: {
                return EnumFacing.EAST;
            }
        }
    }
    
    protected BlockTrapDoor(final Material llllllllllllIIlIIlIIllIlllIllllI) {
        super(llllllllllllIIlIIlIIllIlllIllllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false).withProperty(BlockTrapDoor.HALF, DoorHalf.BOTTOM));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected void playSound(@Nullable final EntityPlayer llllllllllllIIlIIlIIllIllIlIIIII, final World llllllllllllIIlIIlIIllIllIIlllll, final BlockPos llllllllllllIIlIIlIIllIllIIllllI, final boolean llllllllllllIIlIIlIIllIllIlIIlII) {
        if (llllllllllllIIlIIlIIllIllIlIIlII) {
            final int llllllllllllIIlIIlIIllIllIlIIIll = (this.blockMaterial == Material.IRON) ? 1037 : 1007;
            llllllllllllIIlIIlIIllIllIIlllll.playEvent(llllllllllllIIlIIlIIllIllIlIIIII, llllllllllllIIlIIlIIllIllIlIIIll, llllllllllllIIlIIlIIllIllIIllllI, 0);
        }
        else {
            final int llllllllllllIIlIIlIIllIllIlIIIlI = (this.blockMaterial == Material.IRON) ? 1036 : 1013;
            llllllllllllIIlIIlIIllIllIIlllll.playEvent(llllllllllllIIlIIlIIllIllIlIIIII, llllllllllllIIlIIlIIllIllIlIIIlI, llllllllllllIIlIIlIIllIllIIllllI, 0);
        }
    }
    
    protected static int getMetaForFacing(final EnumFacing llllllllllllIIlIIlIIllIlIllIIlIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIlIIlIIllIlIllIIlIl.ordinal()]) {
            case 3: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 5: {
                return 2;
            }
            default: {
                return 3;
            }
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIlIIlIIllIlIlIIlIll, final Mirror llllllllllllIIlIIlIIllIlIlIIlIII) {
        return llllllllllllIIlIIlIIllIlIlIIlIll.withRotation(llllllllllllIIlIIlIIllIlIlIIlIII.toRotation(llllllllllllIIlIIlIIllIlIlIIlIll.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING)));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIlIIlIIllIlllIIllII) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIIlIIlIIllIlllIIlIlI) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIIlIIlIIllIlllIIllll, final IBlockAccess llllllllllllIIlIIlIIllIlllIlIlll, final BlockPos llllllllllllIIlIIlIIllIlllIlIllI) {
        AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIIII = null;
        if (llllllllllllIIlIIlIIllIlllIIllll.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIlIIlIIllIlllIIllll.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING).ordinal()]) {
                default: {
                    final AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIlIl = BlockTrapDoor.NORTH_OPEN_AABB;
                    break;
                }
                case 4: {
                    final AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIlII = BlockTrapDoor.SOUTH_OPEN_AABB;
                    break;
                }
                case 5: {
                    final AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIIll = BlockTrapDoor.WEST_OPEN_AABB;
                    break;
                }
                case 6: {
                    final AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIIlI = BlockTrapDoor.EAST_OPEN_AABB;
                    break;
                }
            }
        }
        else if (llllllllllllIIlIIlIIllIlllIIllll.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) {
            final AxisAlignedBB llllllllllllIIlIIlIIllIlllIlIIIl = BlockTrapDoor.TOP_AABB;
        }
        else {
            llllllllllllIIlIIlIIllIlllIlIIII = BlockTrapDoor.BOTTOM_AABB;
        }
        return llllllllllllIIlIIlIIllIlllIlIIII;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIIlIIlIIllIllIllllII, final BlockPos llllllllllllIIlIIlIIllIllIlllIll, IBlockState llllllllllllIIlIIlIIllIllIllIIII, final EntityPlayer llllllllllllIIlIIlIIllIllIlIllll, final EnumHand llllllllllllIIlIIlIIllIllIlllIII, final EnumFacing llllllllllllIIlIIlIIllIllIllIlll, final float llllllllllllIIlIIlIIllIllIllIllI, final float llllllllllllIIlIIlIIllIllIllIlIl, final float llllllllllllIIlIIlIIllIllIllIlII) {
        if (this.blockMaterial == Material.IRON) {
            return false;
        }
        llllllllllllIIlIIlIIllIllIllIIII = (boolean)((IBlockState)llllllllllllIIlIIlIIllIllIllIIII).cycleProperty((IProperty<Comparable>)BlockTrapDoor.OPEN);
        llllllllllllIIlIIlIIllIllIllllII.setBlockState(llllllllllllIIlIIlIIllIllIlllIll, (IBlockState)llllllllllllIIlIIlIIllIllIllIIII, 2);
        this.playSound(llllllllllllIIlIIlIIllIllIlIllll, llllllllllllIIlIIlIIllIllIllllII, llllllllllllIIlIIlIIllIllIlllIll, ((IBlockState)llllllllllllIIlIIlIIllIllIllIIII).getValue((IProperty<Boolean>)BlockTrapDoor.OPEN));
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlIIlIIllIlIlIlIlll) {
        int llllllllllllIIlIIlIIllIlIlIllIII = 0;
        llllllllllllIIlIIlIIllIlIlIllIII |= getMetaForFacing(llllllllllllIIlIIlIIllIlIlIlIlll.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING));
        if (llllllllllllIIlIIlIIllIlIlIlIlll.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) {
            llllllllllllIIlIIlIIllIlIlIllIII |= 0x4;
        }
        if (llllllllllllIIlIIlIIllIlIlIlIlll.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) {
            llllllllllllIIlIIlIIllIlIlIllIII |= 0x8;
        }
        return llllllllllllIIlIIlIIllIlIlIllIII;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIIlIIlIIllIlIlIIIIIl, final IBlockState llllllllllllIIlIIlIIllIlIlIIIIII, final BlockPos llllllllllllIIlIIlIIllIlIIllllll, final EnumFacing llllllllllllIIlIIlIIllIlIIllllII) {
        return (((llllllllllllIIlIIlIIllIlIIllllII == EnumFacing.UP && llllllllllllIIlIIlIIllIlIlIIIIII.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) || (llllllllllllIIlIIlIIllIlIIllllII == EnumFacing.DOWN && llllllllllllIIlIIlIIllIlIlIIIIII.getValue(BlockTrapDoor.HALF) == DoorHalf.BOTTOM)) && !llllllllllllIIlIIlIIllIlIlIIIIII.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTrapDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char llllllllllllIIlIIlIIllIlIIlllIlI = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIIlIIlIIllIlIIlllIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTrapDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIIlIIlIIllIlIIlllIlI;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIIlIIlIIllIllIIlIIll, final World llllllllllllIIlIIlIIllIllIIlIIlI, final BlockPos llllllllllllIIlIIlIIllIllIIIlIIl, final Block llllllllllllIIlIIlIIllIllIIIlIII, final BlockPos llllllllllllIIlIIlIIllIllIIIllll) {
        if (!llllllllllllIIlIIlIIllIllIIlIIlI.isRemote) {
            final boolean llllllllllllIIlIIlIIllIllIIIlllI = llllllllllllIIlIIlIIllIllIIlIIlI.isBlockPowered(llllllllllllIIlIIlIIllIllIIIlIIl);
            if (llllllllllllIIlIIlIIllIllIIIlllI || llllllllllllIIlIIlIIllIllIIIlIII.getDefaultState().canProvidePower()) {
                final boolean llllllllllllIIlIIlIIllIllIIIllIl = llllllllllllIIlIIlIIllIllIIlIIll.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN);
                if (llllllllllllIIlIIlIIllIllIIIllIl != llllllllllllIIlIIlIIllIllIIIlllI) {
                    llllllllllllIIlIIlIIllIllIIlIIlI.setBlockState(llllllllllllIIlIIlIIllIllIIIlIIl, llllllllllllIIlIIlIIllIllIIlIIll.withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, llllllllllllIIlIIlIIllIllIIIlllI), 2);
                    this.playSound(null, llllllllllllIIlIIlIIllIllIIlIIlI, llllllllllllIIlIIlIIllIllIIIlIIl, llllllllllllIIlIIlIIllIllIIIlllI);
                }
            }
        }
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllIIlIIlIIllIlllIIIlII, final BlockPos llllllllllllIIlIIlIIllIlllIIIIll) {
        return !llllllllllllIIlIIlIIllIlllIIIlII.getBlockState(llllllllllllIIlIIlIIllIlllIIIIll).getValue((IProperty<Boolean>)BlockTrapDoor.OPEN);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIlIIlIIllIlIlllIIll, final BlockPos llllllllllllIIlIIlIIllIlIlllIIlI, final EnumFacing llllllllllllIIlIIlIIllIlIlllIIIl, final float llllllllllllIIlIIlIIllIlIllllIlI, final float llllllllllllIIlIIlIIllIlIllllIIl, final float llllllllllllIIlIIlIIllIlIllllIII, final int llllllllllllIIlIIlIIllIlIlllIlll, final EntityLivingBase llllllllllllIIlIIlIIllIlIlllIllI) {
        IBlockState llllllllllllIIlIIlIIllIlIlllIlIl = this.getDefaultState();
        if (llllllllllllIIlIIlIIllIlIlllIIIl.getAxis().isHorizontal()) {
            llllllllllllIIlIIlIIllIlIlllIlIl = llllllllllllIIlIIlIIllIlIlllIlIl.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, llllllllllllIIlIIlIIllIlIlllIIIl).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false);
            llllllllllllIIlIIlIIllIlIlllIlIl = llllllllllllIIlIIlIIllIlIlllIlIl.withProperty(BlockTrapDoor.HALF, (llllllllllllIIlIIlIIllIlIllllIIl > 0.5f) ? DoorHalf.TOP : DoorHalf.BOTTOM);
        }
        else {
            llllllllllllIIlIIlIIllIlIlllIlIl = llllllllllllIIlIIlIIllIlIlllIlIl.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, llllllllllllIIlIIlIIllIlIlllIllI.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false);
            llllllllllllIIlIIlIIllIlIlllIlIl = llllllllllllIIlIIlIIllIlIlllIlIl.withProperty(BlockTrapDoor.HALF, (llllllllllllIIlIIlIIllIlIlllIIIl == EnumFacing.UP) ? DoorHalf.BOTTOM : DoorHalf.TOP);
        }
        if (llllllllllllIIlIIlIIllIlIlllIIll.isBlockPowered(llllllllllllIIlIIlIIllIlIlllIIlI)) {
            llllllllllllIIlIIlIIllIlIlllIlIl = llllllllllllIIlIIlIIllIlIlllIlIl.withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, true);
        }
        return llllllllllllIIlIIlIIllIlIlllIlIl;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llllllllllllIIlIIlIIllIlIllIllII, final BlockPos llllllllllllIIlIIlIIllIlIllIlIll, final EnumFacing llllllllllllIIlIIlIIllIlIllIlIlI) {
        return true;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIlIIlIIllIlIlIlIIII, final Rotation llllllllllllIIlIIlIIllIlIlIIllll) {
        return llllllllllllIIlIIlIIllIlIlIlIIII.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, llllllllllllIIlIIlIIllIlIlIIllll.rotate(llllllllllllIIlIIlIIllIlIlIlIIII.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING)));
    }
    
    public enum DoorHalf implements IStringSerializable
    {
        BOTTOM("BOTTOM", 1, "bottom");
        
        private final /* synthetic */ String name;
        
        TOP("TOP", 0, "top");
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private DoorHalf(final String lllllllllllIIIIIIlIIIIllIlIIIlII, final int lllllllllllIIIIIIlIIIIllIlIIIIll, final String lllllllllllIIIIIIlIIIIllIlIIIIlI) {
            this.name = lllllllllllIIIIIIlIIIIllIlIIIIlI;
        }
    }
}
