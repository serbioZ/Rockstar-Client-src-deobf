// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.world.Explosion;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Mirror;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockStairs extends Block
{
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_NE;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_NW;
    public static final /* synthetic */ PropertyEnum<EnumShape> SHAPE;
    protected static final /* synthetic */ AxisAlignedBB AABB_SLAB_TOP;
    private final /* synthetic */ Block modelBlock;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_NW;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_SW;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_EAST;
    protected static final /* synthetic */ AxisAlignedBB AABB_SLAB_BOTTOM;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_WEST;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_SOUTH;
    private final /* synthetic */ IBlockState modelState;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_WEST;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_SE;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_SE;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_SW;
    public static final /* synthetic */ PropertyEnum<EnumHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_NE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_EAST;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_SOUTH;
    
    private static EnumShape getStairsShape(final IBlockState lllllllllllIlIIlIlIlIllIIlIlIIIl, final IBlockAccess lllllllllllIlIIlIlIlIllIIlIlIIII, final BlockPos lllllllllllIlIIlIlIlIllIIlIlIlll) {
        final EnumFacing lllllllllllIlIIlIlIlIllIIlIlIllI = lllllllllllIlIIlIlIlIllIIlIlIIIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final IBlockState lllllllllllIlIIlIlIlIllIIlIlIlIl = lllllllllllIlIIlIlIlIllIIlIlIIII.getBlockState(lllllllllllIlIIlIlIlIllIIlIlIlll.offset(lllllllllllIlIIlIlIlIllIIlIlIllI));
        if (isBlockStairs(lllllllllllIlIIlIlIlIllIIlIlIlIl) && lllllllllllIlIIlIlIlIllIIlIlIIIl.getValue(BlockStairs.HALF) == lllllllllllIlIIlIlIlIllIIlIlIlIl.getValue(BlockStairs.HALF)) {
            final EnumFacing lllllllllllIlIIlIlIlIllIIlIlIlII = lllllllllllIlIIlIlIlIllIIlIlIlIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
            if (lllllllllllIlIIlIlIlIllIIlIlIlII.getAxis() != lllllllllllIlIIlIlIlIllIIlIlIIIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getAxis() && isDifferentStairs(lllllllllllIlIIlIlIlIllIIlIlIIIl, lllllllllllIlIIlIlIlIllIIlIlIIII, lllllllllllIlIIlIlIlIllIIlIlIlll, lllllllllllIlIIlIlIlIllIIlIlIlII.getOpposite())) {
                if (lllllllllllIlIIlIlIlIllIIlIlIlII == lllllllllllIlIIlIlIlIllIIlIlIllI.rotateYCCW()) {
                    return EnumShape.OUTER_LEFT;
                }
                return EnumShape.OUTER_RIGHT;
            }
        }
        final IBlockState lllllllllllIlIIlIlIlIllIIlIlIIll = lllllllllllIlIIlIlIlIllIIlIlIIII.getBlockState(lllllllllllIlIIlIlIlIllIIlIlIlll.offset(lllllllllllIlIIlIlIlIllIIlIlIllI.getOpposite()));
        if (isBlockStairs(lllllllllllIlIIlIlIlIllIIlIlIIll) && lllllllllllIlIIlIlIlIllIIlIlIIIl.getValue(BlockStairs.HALF) == lllllllllllIlIIlIlIlIllIIlIlIIll.getValue(BlockStairs.HALF)) {
            final EnumFacing lllllllllllIlIIlIlIlIllIIlIlIIlI = lllllllllllIlIIlIlIlIllIIlIlIIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
            if (lllllllllllIlIIlIlIlIllIIlIlIIlI.getAxis() != lllllllllllIlIIlIlIlIllIIlIlIIIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getAxis() && isDifferentStairs(lllllllllllIlIIlIlIlIllIIlIlIIIl, lllllllllllIlIIlIlIlIllIIlIlIIII, lllllllllllIlIIlIlIlIllIIlIlIlll, lllllllllllIlIIlIlIlIllIIlIlIIlI)) {
                if (lllllllllllIlIIlIlIlIllIIlIlIIlI == lllllllllllIlIIlIlIlIllIIlIlIllI.rotateYCCW()) {
                    return EnumShape.INNER_LEFT;
                }
                return EnumShape.INNER_RIGHT;
            }
        }
        return EnumShape.STRAIGHT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIIlIlIlIllllIIIlIlI) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return this.modelBlock.getBlockLayer();
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIlIIlIlIlIllIlllIIlII, final BlockPos lllllllllllIlIIlIlIlIllIlllIIIll, final IBlockState lllllllllllIlIIlIlIlIllIlllIIIlI, final EntityPlayer lllllllllllIlIIlIlIlIllIlllIIIIl, final EnumHand lllllllllllIlIIlIlIlIllIlllIIIII, final EnumFacing lllllllllllIlIIlIlIlIllIllIlllll, final float lllllllllllIlIIlIlIlIllIllIllllI, final float lllllllllllIlIIlIlIlIllIllIlllIl, final float lllllllllllIlIIlIlIlIllIllIlllII) {
        return this.modelBlock.onBlockActivated(lllllllllllIlIIlIlIlIllIlllIIlII, lllllllllllIlIIlIlIlIllIlllIIIll, this.modelState, lllllllllllIlIIlIlIlIllIlllIIIIl, lllllllllllIlIIlIlIlIllIlllIIIII, EnumFacing.DOWN, 0.0f, 0.0f, 0.0f);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        HALF = PropertyEnum.create("half", EnumHalf.class);
        SHAPE = PropertyEnum.create("shape", EnumShape.class);
        AABB_SLAB_TOP = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
        AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0, 0.5, 0.0, 0.5, 1.0, 1.0);
        AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5, 0.5, 0.0, 1.0, 1.0, 1.0);
        AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 0.5);
        AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0, 0.5, 0.5, 1.0, 1.0, 1.0);
        AABB_OCT_TOP_NW = new AxisAlignedBB(0.0, 0.5, 0.0, 0.5, 1.0, 0.5);
        AABB_OCT_TOP_NE = new AxisAlignedBB(0.5, 0.5, 0.0, 1.0, 1.0, 0.5);
        AABB_OCT_TOP_SW = new AxisAlignedBB(0.0, 0.5, 0.5, 0.5, 1.0, 1.0);
        AABB_OCT_TOP_SE = new AxisAlignedBB(0.5, 0.5, 0.5, 1.0, 1.0, 1.0);
        AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0, 0.0, 0.0, 0.5, 0.5, 1.0);
        AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 0.5);
        AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.5, 1.0, 0.5, 1.0);
        AABB_OCT_BOT_NW = new AxisAlignedBB(0.0, 0.0, 0.0, 0.5, 0.5, 0.5);
        AABB_OCT_BOT_NE = new AxisAlignedBB(0.5, 0.0, 0.0, 1.0, 0.5, 0.5);
        AABB_OCT_BOT_SW = new AxisAlignedBB(0.0, 0.0, 0.5, 0.5, 0.5, 1.0);
        AABB_OCT_BOT_SE = new AxisAlignedBB(0.5, 0.0, 0.5, 1.0, 0.5, 1.0);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlIIlIlIlIllIIIllIIll, final Rotation lllllllllllIlIIlIlIlIllIIIllIIlI) {
        return lllllllllllIlIIlIlIlIllIIIllIIll.withProperty((IProperty<Comparable>)BlockStairs.FACING, lllllllllllIlIIlIlIlIllIIIllIIlI.rotate(lllllllllllIlIIlIlIlIllIIIllIIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING)));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape() {
        final int[] $switch_TABLE$net$minecraft$block$BlockStairs$EnumShape = BlockStairs.$SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape;
        if ($switch_TABLE$net$minecraft$block$BlockStairs$EnumShape != null) {
            return $switch_TABLE$net$minecraft$block$BlockStairs$EnumShape;
        }
        final char lllllllllllIlIIlIlIlIllIIIIlllII = (Object)new int[EnumShape.values().length];
        try {
            lllllllllllIlIIlIlIlIllIIIIlllII[EnumShape.INNER_LEFT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIlllII[EnumShape.INNER_RIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIlllII[EnumShape.OUTER_LEFT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIlllII[EnumShape.OUTER_RIGHT.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIlllII[EnumShape.STRAIGHT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape = (int[])(Object)lllllllllllIlIIlIlIlIllIIIIlllII;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIIlIlIlIllIIlllIllI) {
        IBlockState lllllllllllIlIIlIlIlIllIIlllIlIl = this.getDefaultState().withProperty(BlockStairs.HALF, ((lllllllllllIlIIlIlIlIllIIlllIllI & 0x4) > 0) ? EnumHalf.TOP : EnumHalf.BOTTOM);
        lllllllllllIlIIlIlIlIllIIlllIlIl = lllllllllllIlIIlIlIlIllIIlllIlIl.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.getFront(5 - (lllllllllllIlIIlIlIlIllIIlllIllI & 0x3)));
        return lllllllllllIlIIlIlIlIllIIlllIlIl;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIIlIlIlIllllIIIlIII) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIIlIlIlIllIIllIllII) {
        int lllllllllllIlIIlIlIlIllIIllIllIl = 0;
        if (lllllllllllIlIIlIlIlIllIIllIllII.getValue(BlockStairs.HALF) == EnumHalf.TOP) {
            lllllllllllIlIIlIlIlIllIIllIllIl |= 0x4;
        }
        lllllllllllIlIIlIlIlIllIIllIllIl |= 5 - lllllllllllIlIIlIlIlIllIIllIllII.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getIndex();
        return lllllllllllIlIIlIlIlIllIIllIllIl;
    }
    
    private static AxisAlignedBB getCollEighthBlock(final IBlockState lllllllllllIlIIlIlIlIllllIlIlIll) {
        final EnumFacing lllllllllllIlIIlIlIlIllllIlIlIlI = lllllllllllIlIIlIlIlIllllIlIlIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final EnumFacing lllllllllllIlIIlIlIlIllllIlIIllI;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllIlIIlIlIlIllllIlIlIll.getValue(BlockStairs.SHAPE).ordinal()]) {
            default: {
                final EnumFacing lllllllllllIlIIlIlIlIllllIlIlIIl = lllllllllllIlIIlIlIlIllllIlIlIlI;
                break;
            }
            case 5: {
                final EnumFacing lllllllllllIlIIlIlIlIllllIlIlIII = lllllllllllIlIIlIlIlIllllIlIlIlI.rotateY();
                break;
            }
            case 3: {
                final EnumFacing lllllllllllIlIIlIlIlIllllIlIIlll = lllllllllllIlIIlIlIlIllllIlIlIlI.getOpposite();
                break;
            }
            case 2: {
                lllllllllllIlIIlIlIlIllllIlIIllI = lllllllllllIlIIlIlIlIllllIlIlIlI.rotateYCCW();
                break;
            }
        }
        final boolean lllllllllllIlIIlIlIlIllllIlIIlIl = lllllllllllIlIIlIlIlIllllIlIlIll.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIlIlIlIllllIlIIllI.ordinal()]) {
            default: {
                return lllllllllllIlIIlIlIlIllllIlIIlIl ? BlockStairs.AABB_OCT_BOT_NW : BlockStairs.AABB_OCT_TOP_NW;
            }
            case 4: {
                return lllllllllllIlIIlIlIlIllllIlIIlIl ? BlockStairs.AABB_OCT_BOT_SE : BlockStairs.AABB_OCT_TOP_SE;
            }
            case 5: {
                return lllllllllllIlIIlIlIlIllllIlIIlIl ? BlockStairs.AABB_OCT_BOT_SW : BlockStairs.AABB_OCT_TOP_SW;
            }
            case 6: {
                return lllllllllllIlIIlIlIlIllllIlIIlIl ? BlockStairs.AABB_OCT_BOT_NE : BlockStairs.AABB_OCT_TOP_NE;
            }
        }
    }
    
    @Override
    public void updateTick(final World lllllllllllIlIIlIlIlIllIlllIlllI, final BlockPos lllllllllllIlIIlIlIlIllIllllIIlI, final IBlockState lllllllllllIlIIlIlIlIllIllllIIIl, final Random lllllllllllIlIIlIlIlIllIllllIIII) {
        this.modelBlock.updateTick(lllllllllllIlIIlIlIlIllIlllIlllI, lllllllllllIlIIlIlIlIllIllllIIlI, lllllllllllIlIIlIlIlIllIllllIIIl, lllllllllllIlIIlIlIlIllIllllIIII);
    }
    
    @Override
    public void onBlockClicked(final World lllllllllllIlIIlIlIlIlllIlllIIll, final BlockPos lllllllllllIlIIlIlIlIlllIllIlllI, final EntityPlayer lllllllllllIlIIlIlIlIlllIlllIIIl) {
        this.modelBlock.onBlockClicked(lllllllllllIlIIlIlIlIlllIlllIIll, lllllllllllIlIIlIlIlIlllIllIlllI, lllllllllllIlIIlIlIlIlllIlllIIIl);
    }
    
    @Override
    public int tickRate(final World lllllllllllIlIIlIlIlIlllIlIIlIII) {
        return this.modelBlock.tickRate(lllllllllllIlIIlIlIlIlllIlIIlIII);
    }
    
    private static AxisAlignedBB getCollQuarterBlock(final IBlockState lllllllllllIlIIlIlIlIllllIllIIll) {
        final boolean lllllllllllIlIIlIlIlIllllIllIIlI = lllllllllllIlIIlIlIlIllllIllIIll.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIIlIlIlIllllIllIIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING).ordinal()]) {
            default: {
                return lllllllllllIlIIlIlIlIllllIllIIlI ? BlockStairs.AABB_QTR_BOT_NORTH : BlockStairs.AABB_QTR_TOP_NORTH;
            }
            case 4: {
                return lllllllllllIlIIlIlIlIllllIllIIlI ? BlockStairs.AABB_QTR_BOT_SOUTH : BlockStairs.AABB_QTR_TOP_SOUTH;
            }
            case 5: {
                return lllllllllllIlIIlIlIlIllllIllIIlI ? BlockStairs.AABB_QTR_BOT_WEST : BlockStairs.AABB_QTR_TOP_WEST;
            }
            case 6: {
                return lllllllllllIlIIlIlIlIllllIllIIlI ? BlockStairs.AABB_QTR_BOT_EAST : BlockStairs.AABB_QTR_TOP_EAST;
            }
        }
    }
    
    @Override
    public int getPackedLightmapCoords(final IBlockState lllllllllllIlIIlIlIlIlllIlIlllII, final IBlockAccess lllllllllllIlIIlIlIlIlllIlIllIll, final BlockPos lllllllllllIlIIlIlIlIlllIlIlIlll) {
        return this.modelState.getPackedLightmapCoords(lllllllllllIlIIlIlIlIlllIlIllIll, lllllllllllIlIIlIlIlIlllIlIlIlll);
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllIlIIlIlIlIllIllllllII, final BlockPos lllllllllllIlIIlIlIlIllIlllllIll, final Entity lllllllllllIlIIlIlIlIllIlllllIlI) {
        this.modelBlock.onEntityWalk(lllllllllllIlIIlIlIlIllIllllllII, lllllllllllIlIIlIlIlIllIlllllIll, lllllllllllIlIIlIlIlIllIlllllIlI);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllIlIIlIlIlIlllIllIIlll, final BlockPos lllllllllllIlIIlIlIlIlllIllIIIlI, final IBlockState lllllllllllIlIIlIlIlIlllIllIIIIl) {
        this.modelBlock.onBlockDestroyedByPlayer(lllllllllllIlIIlIlIlIlllIllIIlll, lllllllllllIlIIlIlIlIlllIllIIIlI, lllllllllllIlIIlIlIlIlllIllIIIIl);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlIIlIlIlIlllIIIllllI, final BlockPos lllllllllllIlIIlIlIlIlllIIIlllIl) {
        return this.modelBlock.canPlaceBlockAt(lllllllllllIlIIlIlIlIlllIIIllllI, lllllllllllIlIIlIlIlIlllIIIlllIl);
    }
    
    @Override
    public boolean isCollidable() {
        return this.modelBlock.isCollidable();
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlIIlIlIlIllIIIlIlIll, final Mirror lllllllllllIlIIlIlIlIllIIIlIIlIl) {
        final EnumFacing lllllllllllIlIIlIlIlIllIIIlIlIIl = lllllllllllIlIIlIlIlIllIIIlIlIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final EnumShape lllllllllllIlIIlIlIlIllIIIlIlIII = lllllllllllIlIIlIlIlIllIIIlIlIll.getValue(BlockStairs.SHAPE);
        Label_0346: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllIlIIlIlIlIllIIIlIIlIl.ordinal()]) {
                case 2: {
                    if (lllllllllllIlIIlIlIlIllIIIlIlIIl.getAxis() != EnumFacing.Axis.Z) {
                        break;
                    }
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllIlIIlIlIlIllIIIlIlIII.ordinal()]) {
                        case 4: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_RIGHT);
                        }
                        case 5: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_LEFT);
                        }
                        case 3: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_LEFT);
                        }
                        case 2: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_RIGHT);
                        }
                        default: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180);
                        }
                    }
                    break;
                }
                case 3: {
                    if (lllllllllllIlIIlIlIlIllIIIlIlIIl.getAxis() != EnumFacing.Axis.X) {
                        break;
                    }
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllIlIIlIlIlIllIIIlIlIII.ordinal()]) {
                        case 4: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_RIGHT);
                        }
                        case 5: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_LEFT);
                        }
                        case 3: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_RIGHT);
                        }
                        case 2: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_LEFT);
                        }
                        case 1: {
                            return lllllllllllIlIIlIlIlIllIIIlIlIll.withRotation(Rotation.CLOCKWISE_180);
                        }
                        default: {
                            break Label_0346;
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllIlIIlIlIlIllIIIlIlIll, lllllllllllIlIIlIlIlIllIIIlIIlIl);
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState lllllllllllIlIIlIlIlIlllIlIIIIll, final World lllllllllllIlIIlIlIlIlllIlIIIIlI, final BlockPos lllllllllllIlIIlIlIlIlllIlIIIIIl) {
        return this.modelState.getSelectedBoundingBox(lllllllllllIlIIlIlIlIlllIlIIIIlI, lllllllllllIlIIlIlIlIlllIlIIIIIl);
    }
    
    @Nullable
    @Override
    public RayTraceResult collisionRayTrace(final IBlockState lllllllllllIlIIlIlIlIllIlIIlIIIl, final World lllllllllllIlIIlIlIlIllIlIIIIlII, final BlockPos lllllllllllIlIIlIlIlIllIlIIIllll, final Vec3d lllllllllllIlIIlIlIlIllIlIIIlllI, final Vec3d lllllllllllIlIIlIlIlIllIlIIIIIIl) {
        final List<RayTraceResult> lllllllllllIlIIlIlIlIllIlIIIllII = (List<RayTraceResult>)Lists.newArrayList();
        for (final AxisAlignedBB lllllllllllIlIIlIlIlIllIlIIIlIll : getCollisionBoxList(this.getActualState(lllllllllllIlIIlIlIlIllIlIIlIIIl, lllllllllllIlIIlIlIlIllIlIIIIlII, lllllllllllIlIIlIlIlIllIlIIIllll))) {
            lllllllllllIlIIlIlIlIllIlIIIllII.add(this.rayTrace(lllllllllllIlIIlIlIlIllIlIIIllll, lllllllllllIlIIlIlIlIllIlIIIlllI, lllllllllllIlIIlIlIlIllIlIIIIIIl, lllllllllllIlIIlIlIlIllIlIIIlIll));
        }
        RayTraceResult lllllllllllIlIIlIlIlIllIlIIIlIlI = null;
        double lllllllllllIlIIlIlIlIllIlIIIlIIl = 0.0;
        for (final RayTraceResult lllllllllllIlIIlIlIlIllIlIIIlIII : lllllllllllIlIIlIlIlIllIlIIIllII) {
            if (lllllllllllIlIIlIlIlIllIlIIIlIII != null) {
                final double lllllllllllIlIIlIlIlIllIlIIIIlll = lllllllllllIlIIlIlIlIllIlIIIlIII.hitVec.squareDistanceTo(lllllllllllIlIIlIlIlIllIlIIIIIIl);
                if (lllllllllllIlIIlIlIlIllIlIIIIlll <= lllllllllllIlIIlIlIlIllIlIIIlIIl) {
                    continue;
                }
                lllllllllllIlIIlIlIlIllIlIIIlIlI = lllllllllllIlIIlIlIlIllIlIIIlIII;
                lllllllllllIlIIlIlIlIllIlIIIlIIl = lllllllllllIlIIlIlIlIllIlIIIIlll;
            }
        }
        return lllllllllllIlIIlIlIlIllIlIIIlIlI;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlIIlIlIlIlllIIIlIIIl, final BlockPos lllllllllllIlIIlIlIlIlllIIIlIIII, final IBlockState lllllllllllIlIIlIlIlIlllIIIlIIll) {
        this.modelState.neighborChanged(lllllllllllIlIIlIlIlIlllIIIlIIIl, lllllllllllIlIIlIlIlIlllIIIlIIII, Blocks.AIR, lllllllllllIlIIlIlIlIlllIIIlIIII);
        this.modelBlock.onBlockAdded(lllllllllllIlIIlIlIlIlllIIIlIIIl, lllllllllllIlIIlIlIlIlllIIIlIIII, this.modelState);
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllllllllllIlIIlIlIlIlllllIIlIIl, final World lllllllllllIlIIlIlIlIlllllIlIIIl, final BlockPos lllllllllllIlIIlIlIlIlllllIlIIII, final AxisAlignedBB lllllllllllIlIIlIlIlIlllllIIllll, final List<AxisAlignedBB> lllllllllllIlIIlIlIlIlllllIIlllI, @Nullable final Entity lllllllllllIlIIlIlIlIlllllIIllIl, final boolean lllllllllllIlIIlIlIlIlllllIIllII) {
        if (!lllllllllllIlIIlIlIlIlllllIIllII) {
            lllllllllllIlIIlIlIlIlllllIIlIIl = this.getActualState((IBlockState)lllllllllllIlIIlIlIlIlllllIIlIIl, lllllllllllIlIIlIlIlIlllllIlIIIl, lllllllllllIlIIlIlIlIlllllIlIIII);
        }
        for (final AxisAlignedBB lllllllllllIlIIlIlIlIlllllIIlIll : getCollisionBoxList((IBlockState)lllllllllllIlIIlIlIlIlllllIIlIIl)) {
            Block.addCollisionBoxToList(lllllllllllIlIIlIlIlIlllllIlIIII, lllllllllllIlIIlIlIlIlllllIIllll, lllllllllllIlIIlIlIlIlllllIIlllI, lllllllllllIlIIlIlIlIlllllIIlIll);
        }
    }
    
    @Override
    public float getExplosionResistance(final Entity lllllllllllIlIIlIlIlIlllIlIlIIIl) {
        return this.modelBlock.getExplosionResistance(lllllllllllIlIIlIlIlIlllIlIlIIIl);
    }
    
    protected BlockStairs(final IBlockState lllllllllllIlIIlIlIlIlllllIlllIl) {
        super(lllllllllllIlIIlIlIlIlllllIlllIl.getBlock().blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH).withProperty(BlockStairs.HALF, EnumHalf.BOTTOM).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT));
        this.modelBlock = lllllllllllIlIIlIlIlIlllllIlllIl.getBlock();
        this.modelState = lllllllllllIlIIlIlIlIlllllIlllIl;
        this.setHardness(this.modelBlock.blockHardness);
        this.setResistance(this.modelBlock.blockResistance / 3.0f);
        this.setSoundType(this.modelBlock.blockSoundType);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public static boolean isBlockStairs(final IBlockState lllllllllllIlIIlIlIlIllIIIlllIlI) {
        return lllllllllllIlIIlIlIlIllIIIlllIlI.getBlock() instanceof BlockStairs;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIlIIlIlIlIllIllIIIIlI, final IBlockAccess lllllllllllIlIIlIlIlIllIllIIIIIl, final BlockPos lllllllllllIlIIlIlIlIllIllIIIIII) {
        return this.modelBlock.getMapColor(this.modelState, lllllllllllIlIIlIlIlIllIllIIIIIl, lllllllllllIlIIlIlIlIllIllIIIIII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockStairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final String lllllllllllIlIIlIlIlIllIIIIllllI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIIlIlIlIllIIIIllllI;
    }
    
    @Override
    public Vec3d modifyAcceleration(final World lllllllllllIlIIlIlIlIlllIIllIIlI, final BlockPos lllllllllllIlIIlIlIlIlllIIllIIIl, final Entity lllllllllllIlIIlIlIlIlllIIllIlIl, final Vec3d lllllllllllIlIIlIlIlIlllIIlIllll) {
        return this.modelBlock.modifyAcceleration(lllllllllllIlIIlIlIlIlllIIllIIlI, lllllllllllIlIIlIlIlIlllIIllIIIl, lllllllllllIlIIlIlIlIlllIIllIlIl, lllllllllllIlIIlIlIlIlllIIlIllll);
    }
    
    private static boolean isDifferentStairs(final IBlockState lllllllllllIlIIlIlIlIllIIlIIIIII, final IBlockAccess lllllllllllIlIIlIlIlIllIIIllllll, final BlockPos lllllllllllIlIIlIlIlIllIIIlllllI, final EnumFacing lllllllllllIlIIlIlIlIllIIIllllIl) {
        final IBlockState lllllllllllIlIIlIlIlIllIIlIIIIIl = lllllllllllIlIIlIlIlIllIIIllllll.getBlockState(lllllllllllIlIIlIlIlIllIIIlllllI.offset(lllllllllllIlIIlIlIlIllIIIllllIl));
        return !isBlockStairs(lllllllllllIlIIlIlIlIllIIlIIIIIl) || lllllllllllIlIIlIlIlIllIIlIIIIIl.getValue((IProperty<Comparable>)BlockStairs.FACING) != lllllllllllIlIIlIlIlIllIIlIIIIII.getValue((IProperty<Comparable>)BlockStairs.FACING) || lllllllllllIlIIlIlIlIllIIlIIIIIl.getValue(BlockStairs.HALF) != lllllllllllIlIIlIlIlIllIIlIIIIII.getValue(BlockStairs.HALF);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIIlIlIlIllllIIIIIIl, final World lllllllllllIlIIlIlIlIlllIllllIll, final BlockPos lllllllllllIlIIlIlIlIlllIllllIlI, final Random lllllllllllIlIIlIlIlIlllIllllllI) {
        this.modelBlock.randomDisplayTick(lllllllllllIlIIlIlIlIllllIIIIIIl, lllllllllllIlIIlIlIlIlllIllllIll, lllllllllllIlIIlIlIlIlllIllllIlI, lllllllllllIlIIlIlIlIlllIllllllI);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStairs.FACING, BlockStairs.HALF, BlockStairs.SHAPE });
    }
    
    @Override
    public void breakBlock(final World lllllllllllIlIIlIlIlIlllIIIIlIll, final BlockPos lllllllllllIlIIlIlIlIlllIIIIlIlI, final IBlockState lllllllllllIlIIlIlIlIlllIIIIlIIl) {
        this.modelBlock.breakBlock(lllllllllllIlIIlIlIlIlllIIIIlIll, lllllllllllIlIIlIlIlIlllIIIIlIlI, this.modelState);
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lllllllllllIlIIlIlIlIlllIIlIIlII, final boolean lllllllllllIlIIlIlIlIlllIIlIIllI) {
        return this.modelBlock.canCollideCheck(lllllllllllIlIIlIlIlIlllIIlIIlII, lllllllllllIlIIlIlIlIlllIIlIIllI);
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIlIIlIlIlIllIllIIIlll) {
        return lllllllllllIlIIlIlIlIllIllIIIlll.getValue(BlockStairs.HALF) == EnumHalf.TOP;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIlIIlIlIlIllIIllIIllI, final IBlockAccess lllllllllllIlIIlIlIlIllIIllIIlIl, final BlockPos lllllllllllIlIIlIlIlIllIIllIIlII) {
        return lllllllllllIlIIlIlIlIllIIllIIllI.withProperty(BlockStairs.SHAPE, getStairsShape(lllllllllllIlIIlIlIlIllIIllIIllI, lllllllllllIlIIlIlIlIllIIllIIlIl, lllllllllllIlIIlIlIlIllIIllIIlII));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlIIlIlIlIllIlIlIIlll, final BlockPos lllllllllllIlIIlIlIlIllIlIlIIllI, final EnumFacing lllllllllllIlIIlIlIlIllIlIlIIlIl, final float lllllllllllIlIIlIlIlIllIlIlIlllI, final float lllllllllllIlIIlIlIlIllIlIlIllIl, final float lllllllllllIlIIlIlIlIllIlIlIIIlI, final int lllllllllllIlIIlIlIlIllIlIlIlIll, final EntityLivingBase lllllllllllIlIIlIlIlIllIlIlIIIII) {
        IBlockState lllllllllllIlIIlIlIlIllIlIlIlIIl = super.onBlockPlaced(lllllllllllIlIIlIlIlIllIlIlIIlll, lllllllllllIlIIlIlIlIllIlIlIIllI, lllllllllllIlIIlIlIlIllIlIlIIlIl, lllllllllllIlIIlIlIlIllIlIlIlllI, lllllllllllIlIIlIlIlIllIlIlIllIl, lllllllllllIlIIlIlIlIllIlIlIIIlI, lllllllllllIlIIlIlIlIllIlIlIlIll, lllllllllllIlIIlIlIlIllIlIlIIIII);
        lllllllllllIlIIlIlIlIllIlIlIlIIl = lllllllllllIlIIlIlIlIllIlIlIlIIl.withProperty((IProperty<Comparable>)BlockStairs.FACING, lllllllllllIlIIlIlIlIllIlIlIIIII.getHorizontalFacing()).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT);
        return (lllllllllllIlIIlIlIlIllIlIlIIlIl != EnumFacing.DOWN && (lllllllllllIlIIlIlIlIllIlIlIIlIl == EnumFacing.UP || lllllllllllIlIIlIlIlIllIlIlIllIl <= 0.5)) ? lllllllllllIlIIlIlIlIllIlIlIlIIl.withProperty(BlockStairs.HALF, EnumHalf.BOTTOM) : lllllllllllIlIIlIlIlIllIlIlIlIIl.withProperty(BlockStairs.HALF, EnumHalf.TOP);
    }
    
    private static List<AxisAlignedBB> getCollisionBoxList(final IBlockState lllllllllllIlIIlIlIlIllllIllllIl) {
        final List<AxisAlignedBB> lllllllllllIlIIlIlIlIllllIllllII = (List<AxisAlignedBB>)Lists.newArrayList();
        final boolean lllllllllllIlIIlIlIlIllllIlllIll = lllllllllllIlIIlIlIlIllllIllllIl.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        lllllllllllIlIIlIlIlIllllIllllII.add(lllllllllllIlIIlIlIlIllllIlllIll ? BlockStairs.AABB_SLAB_TOP : BlockStairs.AABB_SLAB_BOTTOM);
        final EnumShape lllllllllllIlIIlIlIlIllllIlllIlI = lllllllllllIlIIlIlIlIllllIllllIl.getValue(BlockStairs.SHAPE);
        if (lllllllllllIlIIlIlIlIllllIlllIlI == EnumShape.STRAIGHT || lllllllllllIlIIlIlIlIllllIlllIlI == EnumShape.INNER_LEFT || lllllllllllIlIIlIlIlIllllIlllIlI == EnumShape.INNER_RIGHT) {
            lllllllllllIlIIlIlIlIllllIllllII.add(getCollQuarterBlock(lllllllllllIlIIlIlIlIllllIllllIl));
        }
        if (lllllllllllIlIIlIlIlIllllIlllIlI != EnumShape.STRAIGHT) {
            lllllllllllIlIIlIlIlIllllIllllII.add(getCollEighthBlock(lllllllllllIlIIlIlIlIllllIllllIl));
        }
        return lllllllllllIlIIlIlIlIllllIllllII;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIIlIlIlIllllIIlIIIl, IBlockState lllllllllllIlIIlIlIlIllllIIlIIII, final BlockPos lllllllllllIlIIlIlIlIllllIIlIllI, final EnumFacing lllllllllllIlIIlIlIlIllllIIIlllI) {
        lllllllllllIlIIlIlIlIllllIIlIIII = this.getActualState(lllllllllllIlIIlIlIlIllllIIlIIII, lllllllllllIlIIlIlIlIllllIIlIIIl, lllllllllllIlIIlIlIlIllllIIlIllI);
        if (lllllllllllIlIIlIlIlIllllIIIlllI.getAxis() == EnumFacing.Axis.Y) {
            return (lllllllllllIlIIlIlIlIllllIIIlllI == EnumFacing.UP == (lllllllllllIlIIlIlIlIllllIIlIIII.getValue(BlockStairs.HALF) == EnumHalf.TOP)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
        }
        final EnumShape lllllllllllIlIIlIlIlIllllIIlIlII = lllllllllllIlIIlIlIlIllllIIlIIII.getValue(BlockStairs.SHAPE);
        if (lllllllllllIlIIlIlIlIllllIIlIlII == EnumShape.OUTER_LEFT || lllllllllllIlIIlIlIlIllllIIlIlII == EnumShape.OUTER_RIGHT) {
            return BlockFaceShape.UNDEFINED;
        }
        final EnumFacing lllllllllllIlIIlIlIlIllllIIlIIll = lllllllllllIlIIlIlIlIllllIIlIIII.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllIlIIlIlIlIllllIIlIlII.ordinal()]) {
            case 3: {
                return (lllllllllllIlIIlIlIlIllllIIlIIll != lllllllllllIlIIlIlIlIllllIIIlllI && lllllllllllIlIIlIlIlIllllIIlIIll != lllllllllllIlIIlIlIlIllllIIIlllI.rotateYCCW()) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
            }
            case 2: {
                return (lllllllllllIlIIlIlIlIllllIIlIIll != lllllllllllIlIIlIlIlIllllIIIlllI && lllllllllllIlIIlIlIlIllllIIlIIll != lllllllllllIlIIlIlIlIllllIIIlllI.rotateY()) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
            }
            case 1: {
                return (lllllllllllIlIIlIlIlIllllIIlIIll == lllllllllllIlIIlIlIlIllllIIIlllI) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
            }
            default: {
                return BlockFaceShape.UNDEFINED;
            }
        }
    }
    
    @Override
    public void onBlockDestroyedByExplosion(final World lllllllllllIlIIlIlIlIllIllIIllIl, final BlockPos lllllllllllIlIIlIlIlIllIllIIllII, final Explosion lllllllllllIlIIlIlIlIllIllIIllll) {
        this.modelBlock.onBlockDestroyedByExplosion(lllllllllllIlIIlIlIlIllIllIIllIl, lllllllllllIlIIlIlIlIllIllIIllII, lllllllllllIlIIlIlIlIllIllIIllll);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockStairs.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final char lllllllllllIlIIlIlIlIllIIIIllIlI = (Object)new int[Mirror.values().length];
        try {
            lllllllllllIlIIlIlIlIllIIIIllIlI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllIlI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIlIlIlIllIIIIllIlI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIlIIlIlIlIllIIIIllIlI;
    }
    
    public enum EnumShape implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        INNER_RIGHT("INNER_RIGHT", 2, "inner_right"), 
        INNER_LEFT("INNER_LEFT", 1, "inner_left"), 
        OUTER_LEFT("OUTER_LEFT", 3, "outer_left"), 
        OUTER_RIGHT("OUTER_RIGHT", 4, "outer_right"), 
        STRAIGHT("STRAIGHT", 0, "straight");
        
        private EnumShape(final String lllllllllllllIllIIllIlIIIlIlIllI, final int lllllllllllllIllIIllIlIIIlIlIlIl, final String lllllllllllllIllIIllIlIIIlIlIlII) {
            this.name = lllllllllllllIllIIllIlIIIlIlIlII;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
    
    public enum EnumHalf implements IStringSerializable
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
        
        private EnumHalf(final String lllllllllllllIlIlIlIIIlllIIlIlll, final int lllllllllllllIlIlIlIIIlllIIlIllI, final String lllllllllllllIlIlIlIIIlllIIllIIl) {
            this.name = lllllllllllllIlIlIlIIIlllIIllIIl;
        }
    }
}
