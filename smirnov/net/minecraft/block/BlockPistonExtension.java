// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.util.Mirror;
import net.minecraft.block.material.Material;
import net.minecraft.util.Rotation;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockPistonExtension extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB field_190969_O;
    protected static final /* synthetic */ AxisAlignedBB field_190965_K;
    public static final /* synthetic */ PropertyEnum<EnumPistonType> TYPE;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_ARM_AABB;
    public static final /* synthetic */ PropertyBool SHORT;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB UP_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB field_190964_J;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_DOWN_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB DOWN_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB field_190967_M;
    protected static final /* synthetic */ AxisAlignedBB field_190966_L;
    protected static final /* synthetic */ AxisAlignedBB field_190968_N;
    
    @Override
    public void onBlockHarvested(final World lllllllllllIlIIIIllIlIlIlIIIlIlI, final BlockPos lllllllllllIlIIIIllIlIlIlIIIIIlI, final IBlockState lllllllllllIlIIIIllIlIlIlIIIlIII, final EntityPlayer lllllllllllIlIIIIllIlIlIlIIIIlll) {
        if (lllllllllllIlIIIIllIlIlIlIIIIlll.capabilities.isCreativeMode) {
            final BlockPos lllllllllllIlIIIIllIlIlIlIIIIllI = lllllllllllIlIIIIllIlIlIlIIIIIlI.offset(lllllllllllIlIIIIllIlIlIlIIIlIII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getOpposite());
            final Block lllllllllllIlIIIIllIlIlIlIIIIlIl = lllllllllllIlIIIIllIlIlIlIIIlIlI.getBlockState(lllllllllllIlIIIIllIlIlIlIIIIllI).getBlock();
            if (lllllllllllIlIIIIllIlIlIlIIIIlIl == Blocks.PISTON || lllllllllllIlIIIIllIlIlIlIIIIlIl == Blocks.STICKY_PISTON) {
                lllllllllllIlIIIIllIlIlIlIIIlIlI.setBlockToAir(lllllllllllIlIIIIllIlIlIlIIIIllI);
            }
        }
        super.onBlockHarvested(lllllllllllIlIIIIllIlIlIlIIIlIlI, lllllllllllIlIIIIllIlIlIlIIIIIlI, lllllllllllIlIIIIllIlIlIlIIIlIII, lllllllllllIlIIIIllIlIlIlIIIIlll);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIlIIIIllIlIlIIllIIIll, final BlockPos lllllllllllIlIIIIllIlIlIIllIIIlI, final EnumFacing lllllllllllIlIIIIllIlIlIIllIIIIl) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIIIIllIlIlIIIIlIIll, final IBlockState lllllllllllIlIIIIllIlIlIIIIIllll, final BlockPos lllllllllllIlIIIIllIlIlIIIIlIIIl, final EnumFacing lllllllllllIlIIIIllIlIlIIIIlIIII) {
        return (lllllllllllIlIIIIllIlIlIIIIlIIII == lllllllllllIlIIIIllIlIlIIIIIllll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIIIIllIlIlIIllIlIII) {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlIIIIllIlIlIIlIIIlII, final IBlockAccess lllllllllllIlIIIIllIlIlIIlIIIIll, final BlockPos lllllllllllIlIIIIllIlIlIIlIIIIlI, final EnumFacing lllllllllllIlIIIIllIlIlIIlIIIIIl) {
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlIIIIllIlIlIIlIIllIl, final World lllllllllllIlIIIIllIlIlIIlIIllII, final BlockPos lllllllllllIlIIIIllIlIlIIlIIlIll, final Block lllllllllllIlIIIIllIlIlIIlIlIIlI, final BlockPos lllllllllllIlIIIIllIlIlIIlIIlIIl) {
        final EnumFacing lllllllllllIlIIIIllIlIlIIlIlIIII = lllllllllllIlIIIIllIlIlIIlIIllIl.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING);
        final BlockPos lllllllllllIlIIIIllIlIlIIlIIllll = lllllllllllIlIIIIllIlIlIIlIIlIll.offset(lllllllllllIlIIIIllIlIlIIlIlIIII.getOpposite());
        final IBlockState lllllllllllIlIIIIllIlIlIIlIIlllI = lllllllllllIlIIIIllIlIlIIlIIllII.getBlockState(lllllllllllIlIIIIllIlIlIIlIIllll);
        if (lllllllllllIlIIIIllIlIlIIlIIlllI.getBlock() != Blocks.PISTON && lllllllllllIlIIIIllIlIlIIlIIlllI.getBlock() != Blocks.STICKY_PISTON) {
            lllllllllllIlIIIIllIlIlIIlIIllII.setBlockToAir(lllllllllllIlIIIIllIlIlIIlIIlIll);
        }
        else {
            lllllllllllIlIIIIllIlIlIIlIIlllI.neighborChanged(lllllllllllIlIIIIllIlIlIIlIIllII, lllllllllllIlIIIIllIlIlIIlIIllll, lllllllllllIlIIIIllIlIlIIlIlIIlI, lllllllllllIlIIIIllIlIlIIlIIlIIl);
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlIIIIllIlIlIIllIIllI, final BlockPos lllllllllllIlIIIIllIlIlIIllIIlIl) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPistonExtension.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lllllllllllIlIIIIllIlIlIIIIIllII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIIIIllIlIlIIIIIllII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPistonExtension.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIIIIllIlIlIIIIIllII;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIlIIIIllIlIlIlIlIlIlI, final World lllllllllllIlIIIIllIlIlIlIlIIIIl, final BlockPos lllllllllllIlIIIIllIlIlIlIlIlIII, final AxisAlignedBB lllllllllllIlIIIIllIlIlIlIlIIlll, final List<AxisAlignedBB> lllllllllllIlIIIIllIlIlIlIIllllI, @Nullable final Entity lllllllllllIlIIIIllIlIlIlIlIIlIl, final boolean lllllllllllIlIIIIllIlIlIlIlIIlII) {
        Block.addCollisionBoxToList(lllllllllllIlIIIIllIlIlIlIlIlIII, lllllllllllIlIIIIllIlIlIlIlIIlll, lllllllllllIlIIIIllIlIlIlIIllllI, lllllllllllIlIIIIllIlIlIlIlIlIlI.getBoundingBox(lllllllllllIlIIIIllIlIlIlIlIIIIl, lllllllllllIlIIIIllIlIlIlIlIlIII));
        Block.addCollisionBoxToList(lllllllllllIlIIIIllIlIlIlIlIlIII, lllllllllllIlIIIIllIlIlIlIlIIlll, lllllllllllIlIIIIllIlIlIlIIllllI, this.getArmShape(lllllllllllIlIIIIllIlIlIlIlIlIlI));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlIIIIllIlIlIIIlIIIlI, final Rotation lllllllllllIlIIIIllIlIlIIIlIIIIl) {
        return lllllllllllIlIIIIllIlIlIIIlIIIlI.withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, lllllllllllIlIIIIllIlIlIIIlIIIIl.rotate(lllllllllllIlIIIIllIlIlIIIlIIIlI.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIIIIllIlIlIlIllIIlI, final IBlockAccess lllllllllllIlIIIIllIlIlIlIllIlII, final BlockPos lllllllllllIlIIIIllIlIlIlIllIIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIIIllIlIlIlIllIIlI.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).ordinal()]) {
            default: {
                return BlockPistonExtension.PISTON_EXTENSION_DOWN_AABB;
            }
            case 2: {
                return BlockPistonExtension.PISTON_EXTENSION_UP_AABB;
            }
            case 3: {
                return BlockPistonExtension.PISTON_EXTENSION_NORTH_AABB;
            }
            case 4: {
                return BlockPistonExtension.PISTON_EXTENSION_SOUTH_AABB;
            }
            case 5: {
                return BlockPistonExtension.PISTON_EXTENSION_WEST_AABB;
            }
            case 6: {
                return BlockPistonExtension.PISTON_EXTENSION_EAST_AABB;
            }
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllIlIIIIllIlIlIIlllIllI, BlockPos lllllllllllIlIIIIllIlIlIIllIllll, final IBlockState lllllllllllIlIIIIllIlIlIIlllIlII) {
        super.breakBlock(lllllllllllIlIIIIllIlIlIIlllIllI, lllllllllllIlIIIIllIlIlIIllIllll, lllllllllllIlIIIIllIlIlIIlllIlII);
        final EnumFacing lllllllllllIlIIIIllIlIlIIlllIIll = lllllllllllIlIIIIllIlIlIIlllIlII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getOpposite();
        lllllllllllIlIIIIllIlIlIIllIllll = lllllllllllIlIIIIllIlIlIIllIllll.offset(lllllllllllIlIIIIllIlIlIIlllIIll);
        final IBlockState lllllllllllIlIIIIllIlIlIIlllIIlI = lllllllllllIlIIIIllIlIlIIlllIllI.getBlockState(lllllllllllIlIIIIllIlIlIIllIllll);
        if ((lllllllllllIlIIIIllIlIlIIlllIIlI.getBlock() == Blocks.PISTON || lllllllllllIlIIIIllIlIlIIlllIIlI.getBlock() == Blocks.STICKY_PISTON) && lllllllllllIlIIIIllIlIlIIlllIIlI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllIlIIIIllIlIlIIlllIIlI.getBlock().dropBlockAsItem(lllllllllllIlIIIIllIlIlIIlllIllI, lllllllllllIlIIIIllIlIlIIllIllll, lllllllllllIlIIIIllIlIlIIlllIIlI, 0);
            lllllllllllIlIIIIllIlIlIIlllIllI.setBlockToAir(lllllllllllIlIIIIllIlIlIIllIllll);
        }
    }
    
    @Nullable
    public static EnumFacing getFacing(final int lllllllllllIlIIIIllIlIlIIIllllII) {
        final int lllllllllllIlIIIIllIlIlIIIllllIl = lllllllllllIlIIIIllIlIlIIIllllII & 0x7;
        return (lllllllllllIlIIIIllIlIlIIIllllIl > 5) ? null : EnumFacing.getFront(lllllllllllIlIIIIllIlIlIIIllllIl);
    }
    
    public BlockPistonExtension() {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, EnumFacing.NORTH).withProperty(BlockPistonExtension.TYPE, EnumPistonType.DEFAULT).withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, false));
        this.setSoundType(SoundType.STONE);
        this.setHardness(0.5f);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlIIIIllIlIlIIIIllIll, final Mirror lllllllllllIlIIIIllIlIlIIIIllIlI) {
        return lllllllllllIlIIIIllIlIlIIIIllIll.withRotation(lllllllllllIlIIIIllIlIlIIIIllIlI.toRotation(lllllllllllIlIIIIllIlIlIIIIllIll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIIIIllIlIlIIllIlIlI) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIIIIllIlIlIIIlIlIIl) {
        int lllllllllllIlIIIIllIlIlIIIlIlIlI = 0;
        lllllllllllIlIIIIllIlIlIIIlIlIlI |= lllllllllllIlIIIIllIlIlIIIlIlIIl.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getIndex();
        if (lllllllllllIlIIIIllIlIlIIIlIlIIl.getValue(BlockPistonExtension.TYPE) == EnumPistonType.STICKY) {
            lllllllllllIlIIIIllIlIlIIIlIlIlI |= 0x8;
        }
        return lllllllllllIlIIIIllIlIlIIIlIlIlI;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIlIIIIllIlIlIlIIlIlII) {
        return lllllllllllIlIIIIllIlIlIlIIlIlII.getValue((IProperty<Comparable>)BlockPistonExtension.FACING) == EnumFacing.UP;
    }
    
    private AxisAlignedBB getArmShape(final IBlockState lllllllllllIlIIIIllIlIlIlIIllIII) {
        final boolean lllllllllllIlIIIIllIlIlIlIIllIIl = lllllllllllIlIIIIllIlIlIlIIllIII.getValue((IProperty<Boolean>)BlockPistonExtension.SHORT);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIIIllIlIlIlIIllIII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).ordinal()]) {
            default: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190965_K : BlockPistonExtension.DOWN_ARM_AABB;
            }
            case 2: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190964_J : BlockPistonExtension.UP_ARM_AABB;
            }
            case 3: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190967_M : BlockPistonExtension.NORTH_ARM_AABB;
            }
            case 4: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190966_L : BlockPistonExtension.SOUTH_ARM_AABB;
            }
            case 5: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190969_O : BlockPistonExtension.WEST_ARM_AABB;
            }
            case 6: {
                return lllllllllllIlIIIIllIlIlIlIIllIIl ? BlockPistonExtension.field_190968_N : BlockPistonExtension.EAST_ARM_AABB;
            }
        }
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlIIIIllIlIlIIlIlllll) {
        return 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonExtension.FACING, BlockPistonExtension.TYPE, BlockPistonExtension.SHORT });
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIIIIllIlIlIIIlllIII, final BlockPos lllllllllllIlIIIIllIlIlIIIllIlll, final IBlockState lllllllllllIlIIIIllIlIlIIIllIllI) {
        return new ItemStack((lllllllllllIlIIIIllIlIlIIIllIllI.getValue(BlockPistonExtension.TYPE) == EnumPistonType.STICKY) ? Blocks.STICKY_PISTON : Blocks.PISTON);
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumPistonType.class);
        SHORT = PropertyBool.create("short");
        PISTON_EXTENSION_EAST_AABB = new AxisAlignedBB(0.75, 0.0, 0.0, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.25, 1.0, 1.0);
        PISTON_EXTENSION_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.75, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.25);
        PISTON_EXTENSION_UP_AABB = new AxisAlignedBB(0.0, 0.75, 0.0, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_DOWN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
        UP_ARM_AABB = new AxisAlignedBB(0.375, -0.25, 0.375, 0.625, 0.75, 0.625);
        DOWN_ARM_AABB = new AxisAlignedBB(0.375, 0.25, 0.375, 0.625, 1.25, 0.625);
        SOUTH_ARM_AABB = new AxisAlignedBB(0.375, 0.375, -0.25, 0.625, 0.625, 0.75);
        NORTH_ARM_AABB = new AxisAlignedBB(0.375, 0.375, 0.25, 0.625, 0.625, 1.25);
        EAST_ARM_AABB = new AxisAlignedBB(-0.25, 0.375, 0.375, 0.75, 0.625, 0.625);
        WEST_ARM_AABB = new AxisAlignedBB(0.25, 0.375, 0.375, 1.25, 0.625, 0.625);
        field_190964_J = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.75, 0.625);
        field_190965_K = new AxisAlignedBB(0.375, 0.25, 0.375, 0.625, 1.0, 0.625);
        field_190966_L = new AxisAlignedBB(0.375, 0.375, 0.0, 0.625, 0.625, 0.75);
        field_190967_M = new AxisAlignedBB(0.375, 0.375, 0.25, 0.625, 0.625, 1.0);
        field_190968_N = new AxisAlignedBB(0.0, 0.375, 0.375, 0.75, 0.625, 0.625);
        field_190969_O = new AxisAlignedBB(0.25, 0.375, 0.375, 1.0, 0.625, 0.625);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIIIIllIlIlIIIllIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, getFacing(lllllllllllIlIIIIllIlIlIIIllIIIl)).withProperty(BlockPistonExtension.TYPE, ((lllllllllllIlIIIIllIlIlIIIllIIIl & 0x8) > 0) ? EnumPistonType.STICKY : EnumPistonType.DEFAULT);
    }
    
    public enum EnumPistonType implements IStringSerializable
    {
        private final /* synthetic */ String VARIANT;
        
        DEFAULT("DEFAULT", 0, "normal"), 
        STICKY("STICKY", 1, "sticky");
        
        @Override
        public String toString() {
            return this.VARIANT;
        }
        
        private EnumPistonType(final String lllllllllllIlIlIllIllIlIlIlIIllI, final int lllllllllllIlIlIllIllIlIlIlIIlIl, final String lllllllllllIlIlIllIllIlIlIlIIlII) {
            this.VARIANT = lllllllllllIlIlIllIllIlIlIlIIlII;
        }
        
        @Override
        public String getName() {
            return this.VARIANT;
        }
    }
}
