// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Mirror;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockLever extends Block
{
    protected static final /* synthetic */ AxisAlignedBB LEVER_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_DOWN_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_SOUTH_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyEnum<EnumOrientation> FACING;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
    public static final /* synthetic */ PropertyBool POWERED;
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIIllIIllIllIlIlIlIII, final Rotation lllllllllllIIIllIIllIllIlIlIIlll) {
        Label_0308: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIIIllIIllIllIlIlIIlll.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllIIIllIIllIllIlIlIlIII.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 3: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 4: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 5: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        default: {
                            return lllllllllllIIIllIIllIllIlIlIlIII;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllIIIllIIllIllIlIlIlIII.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 3: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        case 4: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 5: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 6: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.UP_X);
                        }
                        case 7: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.UP_Z);
                        }
                        case 1: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.DOWN_Z);
                        }
                        case 8: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.DOWN_X);
                        }
                        default: {
                            break Label_0308;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllIIIllIIllIllIlIlIlIII.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        case 3: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 4: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 5: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 6: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.UP_X);
                        }
                        case 7: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.UP_Z);
                        }
                        case 1: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.DOWN_Z);
                        }
                        case 8: {
                            return lllllllllllIIIllIIllIllIlIlIlIII.withProperty(BlockLever.FACING, EnumOrientation.DOWN_X);
                        }
                        default: {
                            break Label_0308;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllIIIllIIllIllIlIlIlIII;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLever.FACING, BlockLever.POWERED });
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIllIIllIlllIlIlIIII) {
        return false;
    }
    
    protected static boolean canAttachTo(final World lllllllllllIIIllIIllIlllIIllIIlI, final BlockPos lllllllllllIIIllIIllIlllIIllIIIl, final EnumFacing lllllllllllIIIllIIllIlllIIlIllIl) {
        return BlockButton.canPlaceBlock(lllllllllllIIIllIIllIlllIIllIIlI, lllllllllllIIIllIIllIlllIIllIIIl, lllllllllllIIIllIIllIlllIIlIllIl);
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIIIllIIllIllIllIIIlII, final IBlockAccess lllllllllllIIIllIIllIllIllIIIlll, final BlockPos lllllllllllIIIllIIllIllIllIIIllI, final EnumFacing lllllllllllIIIllIIllIllIllIIIlIl) {
        return lllllllllllIIIllIIllIllIllIIIlII.getValue((IProperty<Boolean>)BlockLever.POWERED) ? 15 : 0;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIIIllIIllIllIlIlllIIl) {
        return true;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIIllIIllIlllIIlIIIll, final BlockPos lllllllllllIIIllIIllIlllIIIlIlll, final EnumFacing lllllllllllIIIllIIllIlllIIIlIllI, final float lllllllllllIIIllIIllIlllIIlIIIII, final float lllllllllllIIIllIIllIlllIIIlllll, final float lllllllllllIIIllIIllIlllIIIllllI, final int lllllllllllIIIllIIllIlllIIIlllIl, final EntityLivingBase lllllllllllIIIllIIllIlllIIIlIlIl) {
        final IBlockState lllllllllllIIIllIIllIlllIIIllIll = this.getDefaultState().withProperty((IProperty<Comparable>)BlockLever.POWERED, false);
        if (canAttachTo(lllllllllllIIIllIIllIlllIIlIIIll, lllllllllllIIIllIIllIlllIIIlIlll, lllllllllllIIIllIIllIlllIIIlIllI)) {
            return lllllllllllIIIllIIllIlllIIIllIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(lllllllllllIIIllIIllIlllIIIlIllI, lllllllllllIIIllIIllIlllIIIlIlIl.getHorizontalFacing()));
        }
        for (final EnumFacing lllllllllllIIIllIIllIlllIIIllIlI : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllIIIllIIllIlllIIIllIlI != lllllllllllIIIllIIllIlllIIIlIllI && canAttachTo(lllllllllllIIIllIIllIlllIIlIIIll, lllllllllllIIIllIIllIlllIIIlIlll, lllllllllllIIIllIIllIlllIIIllIlI)) {
                return lllllllllllIIIllIIllIlllIIIllIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(lllllllllllIIIllIIllIlllIIIllIlI, lllllllllllIIIllIIllIlllIIIlIlIl.getHorizontalFacing()));
            }
        }
        if (lllllllllllIIIllIIllIlllIIlIIIll.getBlockState(lllllllllllIIIllIIllIlllIIIlIlll.down()).isFullyOpaque()) {
            return lllllllllllIIIllIIllIlllIIIllIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(EnumFacing.UP, lllllllllllIIIllIIllIlllIIIlIlIl.getHorizontalFacing()));
        }
        return lllllllllllIIIllIIllIlllIIIllIll;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIllIIllIlllIlIlIIlI) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation = BlockLever.$SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
        if ($switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation != null) {
            return $switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
        }
        final int lllllllllllIIIllIIllIllIlIIlIlII = (Object)new int[EnumOrientation.values().length];
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.DOWN_X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.DOWN_Z.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.EAST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.UP_X.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.UP_Z.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIlII[EnumOrientation.WEST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        return BlockLever.$SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation = (int[])(Object)lllllllllllIIIllIIllIllIlIIlIlII;
    }
    
    static {
        FACING = PropertyEnum.create("facing", EnumOrientation.class);
        POWERED = PropertyBool.create("powered");
        LEVER_NORTH_AABB = new AxisAlignedBB(0.3125, 0.20000000298023224, 0.625, 0.6875, 0.800000011920929, 1.0);
        LEVER_SOUTH_AABB = new AxisAlignedBB(0.3125, 0.20000000298023224, 0.0, 0.6875, 0.800000011920929, 0.375);
        LEVER_WEST_AABB = new AxisAlignedBB(0.625, 0.20000000298023224, 0.3125, 1.0, 0.800000011920929, 0.6875);
        LEVER_EAST_AABB = new AxisAlignedBB(0.0, 0.20000000298023224, 0.3125, 0.375, 0.800000011920929, 0.6875);
        LEVER_UP_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 0.6000000238418579, 0.75);
        LEVER_DOWN_AABB = new AxisAlignedBB(0.25, 0.4000000059604645, 0.25, 0.75, 1.0, 0.75);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIIIllIIllIlllIlIlIllI, final IBlockAccess lllllllllllIIIllIIllIlllIlIlIlIl, final BlockPos lllllllllllIIIllIIllIlllIlIlIlII) {
        return BlockLever.NULL_AABB;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIllIIllIllIlIlIllll) {
        int lllllllllllIIIllIIllIllIlIlIlllI = 0;
        lllllllllllIIIllIIllIllIlIlIlllI |= lllllllllllIIIllIIllIllIlIlIllll.getValue(BlockLever.FACING).getMetadata();
        if (lllllllllllIIIllIIllIllIlIlIllll.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            lllllllllllIIIllIIllIllIlIlIlllI |= 0x8;
        }
        return lllllllllllIIIllIIllIllIlIlIlllI;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIIIllIIllIllIllIIIIII, final IBlockAccess lllllllllllIIIllIIllIllIlIllllll, final BlockPos lllllllllllIIIllIIllIllIlIlllllI, final EnumFacing lllllllllllIIIllIIllIllIlIllllIl) {
        if (!lllllllllllIIIllIIllIllIllIIIIII.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            return 0;
        }
        return (lllllllllllIIIllIIllIllIllIIIIII.getValue(BlockLever.FACING).getFacing() == lllllllllllIIIllIIllIllIlIllllIl) ? 15 : 0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockLever.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final String lllllllllllIIIllIIllIllIlIIlIIlI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIIIllIIllIllIlIIlIIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIllIIllIllIlIIlIIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLever.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIIIllIIllIllIlIIlIIlI;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIllIIllIllIlIllIlIl) {
        return this.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.byMetadata(lllllllllllIIIllIIllIllIlIllIlIl & 0x7)).withProperty((IProperty<Comparable>)BlockLever.POWERED, (lllllllllllIIIllIIllIllIlIllIlIl & 0x8) > 0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIIllIIllIlllIIlllIll, final BlockPos lllllllllllIIIllIIllIlllIIlllIlI) {
        final long lllllllllllIIIllIIllIlllIIllIllI;
        final Exception lllllllllllIIIllIIllIlllIIllIlll = (Exception)((EnumFacing[])(Object)(lllllllllllIIIllIIllIlllIIllIllI = (long)(Object)EnumFacing.values())).length;
        for (final EnumFacing lllllllllllIIIllIIllIlllIIllllII : lllllllllllIIIllIIllIlllIIllIllI) {
            if (canAttachTo(lllllllllllIIIllIIllIlllIIlllIll, lllllllllllIIIllIIllIlllIIlllIlI, lllllllllllIIIllIIllIlllIIllllII)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIllIIllIllIlIIllIIl, final IBlockState lllllllllllIIIllIIllIllIlIIllIII, final BlockPos lllllllllllIIIllIIllIllIlIIlIlll, final EnumFacing lllllllllllIIIllIIllIllIlIIlIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private boolean checkCanSurvive(final World lllllllllllIIIllIIllIllIlllllIlI, final BlockPos lllllllllllIIIllIIllIllIlllllIIl, final IBlockState lllllllllllIIIllIIllIllIlllllIII) {
        if (this.canPlaceBlockAt(lllllllllllIIIllIIllIllIlllllIlI, lllllllllllIIIllIIllIllIlllllIIl)) {
            return true;
        }
        this.dropBlockAsItem(lllllllllllIIIllIIllIllIlllllIlI, lllllllllllIIIllIIllIllIlllllIIl, lllllllllllIIIllIIllIllIlllllIII, 0);
        lllllllllllIIIllIIllIllIlllllIlI.setBlockToAir(lllllllllllIIIllIIllIllIlllllIIl);
        return false;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIIllIIllIllIllIIlllI, final BlockPos lllllllllllIIIllIIllIllIllIIllIl, final IBlockState lllllllllllIIIllIIllIllIllIlIIIl) {
        if (lllllllllllIIIllIIllIllIllIlIIIl.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            lllllllllllIIIllIIllIllIllIIlllI.notifyNeighborsOfStateChange(lllllllllllIIIllIIllIllIllIIllIl, this, false);
            final EnumFacing lllllllllllIIIllIIllIllIllIlIIII = lllllllllllIIIllIIllIllIllIlIIIl.getValue(BlockLever.FACING).getFacing();
            lllllllllllIIIllIIllIllIllIIlllI.notifyNeighborsOfStateChange(lllllllllllIIIllIIllIllIllIIllIl.offset(lllllllllllIIIllIIllIllIllIlIIII.getOpposite()), this, false);
        }
        super.breakBlock(lllllllllllIIIllIIllIllIllIIlllI, lllllllllllIIIllIIllIllIllIIllIl, lllllllllllIIIllIIllIllIllIlIIIl);
    }
    
    protected BlockLever() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty((IProperty<Comparable>)BlockLever.POWERED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIIllIIllIllIlIIlllll, final Mirror lllllllllllIIIllIIllIllIlIIllllI) {
        return lllllllllllIIIllIIllIllIlIIlllll.withRotation(lllllllllllIIIllIIllIllIlIIllllI.toRotation(lllllllllllIIIllIIllIllIlIIlllll.getValue(BlockLever.FACING).getFacing()));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIllIIllIllIllIllllI, final BlockPos lllllllllllIIIllIIllIllIlllIlIIl, IBlockState lllllllllllIIIllIIllIllIllIlllII, final EntityPlayer lllllllllllIIIllIIllIllIlllIIlll, final EnumHand lllllllllllIIIllIIllIllIlllIIllI, final EnumFacing lllllllllllIIIllIIllIllIlllIIlIl, final float lllllllllllIIIllIIllIllIlllIIlII, final float lllllllllllIIIllIIllIllIlllIIIll, final float lllllllllllIIIllIIllIllIlllIIIlI) {
        if (lllllllllllIIIllIIllIllIllIllllI.isRemote) {
            return true;
        }
        lllllllllllIIIllIIllIllIllIlllII = (long)((IBlockState)lllllllllllIIIllIIllIllIllIlllII).cycleProperty((IProperty<Comparable>)BlockLever.POWERED);
        lllllllllllIIIllIIllIllIllIllllI.setBlockState(lllllllllllIIIllIIllIllIlllIlIIl, (IBlockState)lllllllllllIIIllIIllIllIllIlllII, 3);
        final float lllllllllllIIIllIIllIllIlllIIIIl = ((IBlockState)lllllllllllIIIllIIllIllIllIlllII).getValue((IProperty<Boolean>)BlockLever.POWERED) ? 0.6f : 0.5f;
        lllllllllllIIIllIIllIllIllIllllI.playSound(null, lllllllllllIIIllIIllIllIlllIlIIl, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3f, lllllllllllIIIllIIllIllIlllIIIIl);
        lllllllllllIIIllIIllIllIllIllllI.notifyNeighborsOfStateChange(lllllllllllIIIllIIllIllIlllIlIIl, this, false);
        final EnumFacing lllllllllllIIIllIIllIllIlllIIIII = ((IBlockState)lllllllllllIIIllIIllIllIllIlllII).getValue(BlockLever.FACING).getFacing();
        lllllllllllIIIllIIllIllIllIllllI.notifyNeighborsOfStateChange(lllllllllllIIIllIIllIllIlllIlIIl.offset(lllllllllllIIIllIIllIllIlllIIIII.getOpposite()), this, false);
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIIllIIllIlllIIIIllII, final World lllllllllllIIIllIIllIlllIIIIlIll, final BlockPos lllllllllllIIIllIIllIlllIIIIIlII, final Block lllllllllllIIIllIIllIlllIIIIlIIl, final BlockPos lllllllllllIIIllIIllIlllIIIIlIII) {
        if (this.checkCanSurvive(lllllllllllIIIllIIllIlllIIIIlIll, lllllllllllIIIllIIllIlllIIIIIlII, lllllllllllIIIllIIllIlllIIIIllII) && !canAttachTo(lllllllllllIIIllIIllIlllIIIIlIll, lllllllllllIIIllIIllIlllIIIIIlII, lllllllllllIIIllIIllIlllIIIIllII.getValue(BlockLever.FACING).getFacing())) {
            this.dropBlockAsItem(lllllllllllIIIllIIllIlllIIIIlIll, lllllllllllIIIllIIllIlllIIIIIlII, lllllllllllIIIllIIllIlllIIIIllII, 0);
            lllllllllllIIIllIIllIlllIIIIlIll.setBlockToAir(lllllllllllIIIllIIllIlllIIIIIlII);
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIllIIllIllIllllIIlI, final IBlockAccess lllllllllllIIIllIIllIllIllllIlII, final BlockPos lllllllllllIIIllIIllIllIllllIIll) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllIIIllIIllIllIllllIIlI.getValue(BlockLever.FACING).ordinal()]) {
            default: {
                return BlockLever.LEVER_EAST_AABB;
            }
            case 3: {
                return BlockLever.LEVER_WEST_AABB;
            }
            case 4: {
                return BlockLever.LEVER_SOUTH_AABB;
            }
            case 5: {
                return BlockLever.LEVER_NORTH_AABB;
            }
            case 6:
            case 7: {
                return BlockLever.LEVER_UP_AABB;
            }
            case 1:
            case 8: {
                return BlockLever.LEVER_DOWN_AABB;
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIIIllIIllIlllIlIIlIll, final BlockPos lllllllllllIIIllIIllIlllIlIIlIlI, final EnumFacing lllllllllllIIIllIIllIlllIlIIlIIl) {
        return canAttachTo(lllllllllllIIIllIIllIlllIlIIlIll, lllllllllllIIIllIIllIlllIlIIlIlI, lllllllllllIIIllIIllIlllIlIIlIIl);
    }
    
    public enum EnumOrientation implements IStringSerializable
    {
        NORTH("NORTH", 4, 4, "north", EnumFacing.NORTH), 
        EAST("EAST", 1, 1, "east", EnumFacing.EAST), 
        UP_Z("UP_Z", 5, 5, "up_z", EnumFacing.UP);
        
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        SOUTH("SOUTH", 3, 3, "south", EnumFacing.SOUTH);
        
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        private final /* synthetic */ int meta;
        
        DOWN_Z("DOWN_Z", 7, 7, "down_z", EnumFacing.DOWN);
        
        private static final /* synthetic */ EnumOrientation[] META_LOOKUP;
        
        UP_X("UP_X", 6, 6, "up_x", EnumFacing.UP);
        
        private final /* synthetic */ String name;
        
        DOWN_X("DOWN_X", 0, 0, "down_x", EnumFacing.DOWN);
        
        private final /* synthetic */ EnumFacing facing;
        
        WEST("WEST", 2, 2, "west", EnumFacing.WEST);
        
        private EnumOrientation(final String lllllllllllIlllllllIIllllIlIlIlI, final int lllllllllllIlllllllIIllllIlIlIIl, final int lllllllllllIlllllllIIllllIlIlllI, final String lllllllllllIlllllllIIllllIlIIlll, final EnumFacing lllllllllllIlllllllIIllllIlIllII) {
            this.meta = lllllllllllIlllllllIIllllIlIlllI;
            this.name = lllllllllllIlllllllIIllllIlIIlll;
            this.facing = lllllllllllIlllllllIIllllIlIllII;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public static EnumOrientation forFacings(final EnumFacing lllllllllllIlllllllIIllllIIlIlIl, final EnumFacing lllllllllllIlllllllIIllllIIlIlII) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllllllIIllllIIlIlIl.ordinal()]) {
                case 1: {
                    switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlllllllIIllllIIlIlII.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.DOWN_X;
                        }
                        case 3: {
                            return EnumOrientation.DOWN_Z;
                        }
                        default: {
                            throw new IllegalArgumentException("Invalid entityFacing " + lllllllllllIlllllllIIllllIIlIlII + " for facing " + lllllllllllIlllllllIIllllIIlIlIl);
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIlllllllIIllllIIlIlII.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.UP_X;
                        }
                        case 3: {
                            return EnumOrientation.UP_Z;
                        }
                        default: {
                            throw new IllegalArgumentException("Invalid entityFacing " + lllllllllllIlllllllIIllllIIlIlII + " for facing " + lllllllllllIlllllllIIllllIIlIlIl);
                        }
                    }
                    break;
                }
                case 3: {
                    return EnumOrientation.NORTH;
                }
                case 4: {
                    return EnumOrientation.SOUTH;
                }
                case 5: {
                    return EnumOrientation.WEST;
                }
                case 6: {
                    return EnumOrientation.EAST;
                }
                default: {
                    throw new IllegalArgumentException("Invalid facing: " + lllllllllllIlllllllIIllllIIlIlIl);
                }
            }
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final double lllllllllllIlllllllIIllllIIIIlIl = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllIlllllllIIllllIIIIlIl[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllllllIIllllIIIIlIl;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static EnumOrientation byMetadata(int lllllllllllIlllllllIIllllIIllIlI) {
            if (lllllllllllIlllllllIIllllIIllIlI < 0 || lllllllllllIlllllllIIllllIIllIlI >= EnumOrientation.META_LOOKUP.length) {
                lllllllllllIlllllllIIllllIIllIlI = 0;
            }
            return EnumOrientation.META_LOOKUP[lllllllllllIlllllllIIllllIIllIlI];
        }
        
        public EnumFacing getFacing() {
            return this.facing;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
            if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
            }
            final Exception lllllllllllIlllllllIIllllIIIIlll = (Object)new int[EnumFacing.Axis.values().length];
            try {
                lllllllllllIlllllllIIllllIIIIlll[EnumFacing.Axis.X.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIlllllllIIllllIIIIlll[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIlllllllIIllllIIIIlll[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            return EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIlllllllIIllllIIIIlll;
        }
        
        static {
            META_LOOKUP = new EnumOrientation[values().length];
            final char lllllllllllIlllllllIIllllIllIllI;
            final Exception lllllllllllIlllllllIIllllIllIlll = (Exception)((EnumOrientation[])(Object)(lllllllllllIlllllllIIllllIllIllI = (char)(Object)values())).length;
            for (final EnumOrientation lllllllllllIlllllllIIllllIlllIlI : lllllllllllIlllllllIIllllIllIllI) {
                EnumOrientation.META_LOOKUP[lllllllllllIlllllllIIllllIlllIlI.getMetadata()] = lllllllllllIlllllllIIllllIlllIlI;
            }
        }
    }
}
