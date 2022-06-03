// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import com.google.common.collect.Lists;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.block.state.BlockPistonStructureHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockPistonBase extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_EAST_AABB;
    private final /* synthetic */ boolean isSticky;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_DOWN_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public static final /* synthetic */ PropertyBool EXTENDED;
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllllIllIllllIIlIIll) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlllllIllIlllIllIllll, final BlockPos lllllllllllIlllllIllIlllIllIlllI, final IBlockState lllllllllllIlllllIllIlllIllIlIIl) {
        if (!lllllllllllIlllllIllIlllIllIllll.isRemote && lllllllllllIlllllIllIlllIllIllll.getTileEntity(lllllllllllIlllllIllIlllIllIlllI) == null) {
            this.checkForMove(lllllllllllIlllllIllIlllIllIllll, lllllllllllIlllllIllIlllIllIlllI, lllllllllllIlllllIllIlllIllIlIIl);
        }
    }
    
    public BlockPistonBase(final boolean lllllllllllIlllllIllIllllIllIlIl) {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, false));
        this.isSticky = lllllllllllIlllllIllIllllIllIlIl;
        this.setSoundType(SoundType.STONE);
        this.setHardness(0.5f);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonBase.FACING, BlockPistonBase.EXTENDED });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlllllIllIllIlIIlllII, final Rotation lllllllllllIlllllIllIllIlIIlllIl) {
        return lllllllllllIlllllIllIllIlIIlllII.withProperty((IProperty<Comparable>)BlockPistonBase.FACING, lllllllllllIlllllIllIllIlIIlllIl.rotate(lllllllllllIlllllIllIllIlIIlllII.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING)));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction() {
        final int[] $switch_TABLE$net$minecraft$block$material$EnumPushReaction = BlockPistonBase.$SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction;
        if ($switch_TABLE$net$minecraft$block$material$EnumPushReaction != null) {
            return $switch_TABLE$net$minecraft$block$material$EnumPushReaction;
        }
        final double lllllllllllIlllllIllIllIIllllllI = (Object)new int[EnumPushReaction.values().length];
        try {
            lllllllllllIlllllIllIllIIllllllI[EnumPushReaction.BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllllIllIllIIllllllI[EnumPushReaction.DESTROY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllllIllIllIIllllllI[EnumPushReaction.IGNORE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllllIllIllIIllllllI[EnumPushReaction.NORMAL.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllllIllIllIIllllllI[EnumPushReaction.PUSH_ONLY.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockPistonBase.$SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction = (int[])(Object)lllllllllllIlllllIllIllIIllllllI;
    }
    
    static {
        EXTENDED = PropertyBool.create("extended");
        PISTON_BASE_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
        PISTON_BASE_WEST_AABB = new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 1.0);
        PISTON_BASE_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.75);
        PISTON_BASE_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 1.0, 1.0);
        PISTON_BASE_UP_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
        PISTON_BASE_DOWN_AABB = new AxisAlignedBB(0.0, 0.25, 0.0, 1.0, 1.0, 1.0);
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIlllllIllIllllIlIlIII) {
        return !lllllllllllIlllllIllIllllIlIlIII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED) || lllllllllllIlllllIllIllllIlIlIII.getValue((IProperty<Comparable>)BlockPistonBase.FACING) == EnumFacing.DOWN;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlllllIllIlllIlllIlll, final World lllllllllllIlllllIllIlllIlllIllI, final BlockPos lllllllllllIlllllIllIlllIllllIll, final Block lllllllllllIlllllIllIlllIllllIlI, final BlockPos lllllllllllIlllllIllIlllIllllIIl) {
        if (!lllllllllllIlllllIllIlllIlllIllI.isRemote) {
            this.checkForMove(lllllllllllIlllllIllIlllIlllIllI, lllllllllllIlllllIllIlllIllllIll, lllllllllllIlllllIllIlllIlllIlll);
        }
    }
    
    public static boolean canPush(final IBlockState lllllllllllIlllllIllIllIllllIllI, final World lllllllllllIlllllIllIllIlllIlllI, final BlockPos lllllllllllIlllllIllIllIllllIlII, final EnumFacing lllllllllllIlllllIllIllIllllIIll, final boolean lllllllllllIlllllIllIllIllllIIlI, final EnumFacing lllllllllllIlllllIllIllIllllIIIl) {
        final Block lllllllllllIlllllIllIllIllllIIII = lllllllllllIlllllIllIllIllllIllI.getBlock();
        if (lllllllllllIlllllIllIllIllllIIII == Blocks.OBSIDIAN) {
            return false;
        }
        if (!lllllllllllIlllllIllIllIlllIlllI.getWorldBorder().contains(lllllllllllIlllllIllIllIllllIlII)) {
            return false;
        }
        if (lllllllllllIlllllIllIllIllllIlII.getY() < 0 || (lllllllllllIlllllIllIllIllllIIll == EnumFacing.DOWN && lllllllllllIlllllIllIllIllllIlII.getY() == 0)) {
            return false;
        }
        if (lllllllllllIlllllIllIllIllllIlII.getY() <= lllllllllllIlllllIllIllIlllIlllI.getHeight() - 1 && (lllllllllllIlllllIllIllIllllIIll != EnumFacing.UP || lllllllllllIlllllIllIllIllllIlII.getY() != lllllllllllIlllllIllIllIlllIlllI.getHeight() - 1)) {
            if (lllllllllllIlllllIllIllIllllIIII != Blocks.PISTON && lllllllllllIlllllIllIllIllllIIII != Blocks.STICKY_PISTON) {
                if (lllllllllllIlllllIllIllIllllIllI.getBlockHardness(lllllllllllIlllllIllIllIlllIlllI, lllllllllllIlllllIllIllIllllIlII) == -1.0f) {
                    return false;
                }
                switch ($SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction()[lllllllllllIlllllIllIllIllllIllI.getMobilityFlag().ordinal()]) {
                    case 3: {
                        return false;
                    }
                    case 2: {
                        return lllllllllllIlllllIllIllIllllIIlI;
                    }
                    case 5: {
                        return lllllllllllIlllllIllIllIllllIIll == lllllllllllIlllllIllIllIllllIIIl;
                    }
                }
            }
            else if (lllllllllllIlllllIllIllIllllIllI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
                return false;
            }
            return !lllllllllllIlllllIllIllIllllIIII.hasTileEntity();
        }
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlllllIllIllIlIlIIIll) {
        int lllllllllllIlllllIllIllIlIlIIlII = 0;
        lllllllllllIlllllIllIllIlIlIIlII |= lllllllllllIlllllIllIllIlIlIIIll.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING).getIndex();
        if (lllllllllllIlllllIllIllIlIlIIIll.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllIlllllIllIllIlIlIIlII |= 0x8;
        }
        return lllllllllllIlllllIllIllIlIlIIlII;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlllllIllIllIlIIlIlIl, final Mirror lllllllllllIlllllIllIllIlIIlIlII) {
        return lllllllllllIlllllIllIllIlIIlIlIl.withRotation(lllllllllllIlllllIllIllIlIIlIlII.toRotation(lllllllllllIlllllIllIllIlIIlIlIl.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING)));
    }
    
    private boolean shouldBeExtended(final World lllllllllllIlllllIllIlllIIlllllI, final BlockPos lllllllllllIlllllIllIlllIIllIlll, final EnumFacing lllllllllllIlllllIllIlllIIllIllI) {
        Exception lllllllllllIlllllIllIlllIIllIIlI;
        Exception lllllllllllIlllllIllIlllIIllIIll = (Exception)((EnumFacing[])(Object)(lllllllllllIlllllIllIlllIIllIIlI = (Exception)(Object)EnumFacing.values())).length;
        for (short lllllllllllIlllllIllIlllIIllIlII = 0; lllllllllllIlllllIllIlllIIllIlII < lllllllllllIlllllIllIlllIIllIIll; ++lllllllllllIlllllIllIlllIIllIlII) {
            final EnumFacing lllllllllllIlllllIllIlllIIlllIll = lllllllllllIlllllIllIlllIIllIIlI[lllllllllllIlllllIllIlllIIllIlII];
            if (lllllllllllIlllllIllIlllIIlllIll != lllllllllllIlllllIllIlllIIllIllI && lllllllllllIlllllIllIlllIIlllllI.isSidePowered(lllllllllllIlllllIllIlllIIllIlll.offset(lllllllllllIlllllIllIlllIIlllIll), lllllllllllIlllllIllIlllIIlllIll)) {
                return true;
            }
        }
        if (lllllllllllIlllllIllIlllIIlllllI.isSidePowered(lllllllllllIlllllIllIlllIIllIlll, EnumFacing.DOWN)) {
            return true;
        }
        final BlockPos lllllllllllIlllllIllIlllIIlllIlI = lllllllllllIlllllIllIlllIIllIlll.up();
        double lllllllllllIlllllIllIlllIIllIIIl;
        for (lllllllllllIlllllIllIlllIIllIIlI = (Exception)((EnumFacing[])(Object)(lllllllllllIlllllIllIlllIIllIIIl = (double)(Object)EnumFacing.values())).length, lllllllllllIlllllIllIlllIIllIIll = (Exception)0; lllllllllllIlllllIllIlllIIllIIll < lllllllllllIlllllIllIlllIIllIIlI; ++lllllllllllIlllllIllIlllIIllIIll) {
            final EnumFacing lllllllllllIlllllIllIlllIIlllIIl = lllllllllllIlllllIllIlllIIllIIIl[lllllllllllIlllllIllIlllIIllIIll];
            if (lllllllllllIlllllIllIlllIIlllIIl != EnumFacing.DOWN && lllllllllllIlllllIllIlllIIlllllI.isSidePowered(lllllllllllIlllllIllIlllIIlllIlI.offset(lllllllllllIlllllIllIlllIIlllIIl), lllllllllllIlllllIllIlllIIlllIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlllllIllIlllIIIIIlII) {
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlllllIllIlllIllIIlII, final BlockPos lllllllllllIlllllIllIlllIllIIIll, final EnumFacing lllllllllllIlllllIllIlllIllIIIlI, final float lllllllllllIlllllIllIlllIllIIIIl, final float lllllllllllIlllllIllIlllIllIIIII, final float lllllllllllIlllllIllIlllIlIlllll, final int lllllllllllIlllllIllIlllIlIllllI, final EntityLivingBase lllllllllllIlllllIllIlllIlIlllIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.func_190914_a(lllllllllllIlllllIllIlllIllIIIll, lllllllllllIlllllIllIlllIlIlllIl)).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, false);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlllllIllIllIlIlIlIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, getFacing(lllllllllllIlllllIllIllIlIlIlIIl)).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, (lllllllllllIlllllIllIllIlIlIlIIl & 0x8) > 0);
    }
    
    private void checkForMove(final World lllllllllllIlllllIllIlllIlIIllII, final BlockPos lllllllllllIlllllIllIlllIlIIlIll, final IBlockState lllllllllllIlllllIllIlllIlIIlIlI) {
        final EnumFacing lllllllllllIlllllIllIlllIlIIllll = lllllllllllIlllllIllIlllIlIIlIlI.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING);
        final boolean lllllllllllIlllllIllIlllIlIIlllI = this.shouldBeExtended(lllllllllllIlllllIllIlllIlIIllII, lllllllllllIlllllIllIlllIlIIlIll, lllllllllllIlllllIllIlllIlIIllll);
        if (lllllllllllIlllllIllIlllIlIIlllI && !lllllllllllIlllllIllIlllIlIIlIlI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            if (new BlockPistonStructureHelper(lllllllllllIlllllIllIlllIlIIllII, lllllllllllIlllllIllIlllIlIIlIll, lllllllllllIlllllIllIlllIlIIllll, true).canMove()) {
                lllllllllllIlllllIllIlllIlIIllII.addBlockEvent(lllllllllllIlllllIllIlllIlIIlIll, this, 0, lllllllllllIlllllIllIlllIlIIllll.getIndex());
            }
        }
        else if (!lllllllllllIlllllIllIlllIlIIlllI && lllllllllllIlllllIllIlllIlIIlIlI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllIlllllIllIlllIlIIllII.addBlockEvent(lllllllllllIlllllIllIlllIlIIlIll, this, 1, lllllllllllIlllllIllIlllIlIIllll.getIndex());
        }
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIlllllIllIllllIlIIIII, final World lllllllllllIlllllIllIllllIIlllll, final BlockPos lllllllllllIlllllIllIllllIIllllI, final AxisAlignedBB lllllllllllIlllllIllIllllIIlllIl, final List<AxisAlignedBB> lllllllllllIlllllIllIllllIIlllII, @Nullable final Entity lllllllllllIlllllIllIllllIIllIll, final boolean lllllllllllIlllllIllIllllIIllIlI) {
        Block.addCollisionBoxToList(lllllllllllIlllllIllIllllIIllllI, lllllllllllIlllllIllIllllIIlllIl, lllllllllllIlllllIllIllllIIlllII, lllllllllllIlllllIllIllllIlIIIII.getBoundingBox(lllllllllllIlllllIllIllllIIlllll, lllllllllllIlllllIllIllllIIllllI));
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIlllllIllIllllIIIIllI, final BlockPos lllllllllllIlllllIllIllllIIIIlIl, final IBlockState lllllllllllIlllllIllIllllIIIlIlI, final EntityLivingBase lllllllllllIlllllIllIllllIIIlIIl, final ItemStack lllllllllllIlllllIllIllllIIIlIII) {
        lllllllllllIlllllIllIllllIIIIllI.setBlockState(lllllllllllIlllllIllIllllIIIIlIl, lllllllllllIlllllIllIllllIIIlIlI.withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.func_190914_a(lllllllllllIlllllIllIllllIIIIlIl, lllllllllllIlllllIllIllllIIIlIIl)), 2);
        if (!lllllllllllIlllllIllIllllIIIIllI.isRemote) {
            this.checkForMove(lllllllllllIlllllIllIllllIIIIllI, lllllllllllIlllllIllIllllIIIIlIl, lllllllllllIlllllIllIllllIIIlIlI);
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlllllIllIllIlIIIIlIl, IBlockState lllllllllllIlllllIllIllIlIIIIlII, final BlockPos lllllllllllIlllllIllIllIlIIIIIll, final EnumFacing lllllllllllIlllllIllIllIlIIIIIlI) {
        lllllllllllIlllllIllIllIlIIIIlII = this.getActualState(lllllllllllIlllllIllIllIlIIIIlII, lllllllllllIlllllIllIllIlIIIIlIl, lllllllllllIlllllIllIllIlIIIIIll);
        return (lllllllllllIlllllIllIllIlIIIIlII.getValue((IProperty<Comparable>)BlockPistonBase.FACING) != lllllllllllIlllllIllIllIlIIIIIlI.getOpposite() && lllllllllllIlllllIllIllIlIIIIlII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlllllIllIllllIlIlllI, final IBlockAccess lllllllllllIlllllIllIllllIlIllIl, final BlockPos lllllllllllIlllllIllIllllIlIllII) {
        if (!lllllllllllIlllllIllIllllIlIlllI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            return BlockPistonBase.FULL_BLOCK_AABB;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllllIllIllllIlIlllI.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING).ordinal()]) {
            case 1: {
                return BlockPistonBase.PISTON_BASE_DOWN_AABB;
            }
            default: {
                return BlockPistonBase.PISTON_BASE_UP_AABB;
            }
            case 3: {
                return BlockPistonBase.PISTON_BASE_NORTH_AABB;
            }
            case 4: {
                return BlockPistonBase.PISTON_BASE_SOUTH_AABB;
            }
            case 5: {
                return BlockPistonBase.PISTON_BASE_WEST_AABB;
            }
            case 6: {
                return BlockPistonBase.PISTON_BASE_EAST_AABB;
            }
        }
    }
    
    @Nullable
    public static EnumFacing getFacing(final int lllllllllllIlllllIllIllIllllllll) {
        final int lllllllllllIlllllIllIlllIIIIIIII = lllllllllllIlllllIllIllIllllllll & 0x7;
        return (lllllllllllIlllllIllIlllIIIIIIII > 5) ? null : EnumFacing.getFront(lllllllllllIlllllIllIlllIIIIIIII);
    }
    
    @Override
    public boolean eventReceived(final IBlockState lllllllllllIlllllIllIlllIIIlIIlI, final World lllllllllllIlllllIllIlllIIIlIIIl, final BlockPos lllllllllllIlllllIllIlllIIIlIIII, final int lllllllllllIlllllIllIlllIIIllllI, final int lllllllllllIlllllIllIlllIIIIlllI) {
        final EnumFacing lllllllllllIlllllIllIlllIIIlllII = lllllllllllIlllllIllIlllIIIlIIlI.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING);
        if (!lllllllllllIlllllIllIlllIIIlIIIl.isRemote) {
            final boolean lllllllllllIlllllIllIlllIIIllIll = this.shouldBeExtended(lllllllllllIlllllIllIlllIIIlIIIl, lllllllllllIlllllIllIlllIIIlIIII, lllllllllllIlllllIllIlllIIIlllII);
            if (lllllllllllIlllllIllIlllIIIllIll && lllllllllllIlllllIllIlllIIIllllI == 1) {
                lllllllllllIlllllIllIlllIIIlIIIl.setBlockState(lllllllllllIlllllIllIlllIIIlIIII, lllllllllllIlllllIllIlllIIIlIIlI.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true), 2);
                return false;
            }
            if (!lllllllllllIlllllIllIlllIIIllIll && lllllllllllIlllllIllIlllIIIllllI == 0) {
                return false;
            }
        }
        if (lllllllllllIlllllIllIlllIIIllllI == 0) {
            if (!this.doMove(lllllllllllIlllllIllIlllIIIlIIIl, lllllllllllIlllllIllIlllIIIlIIII, lllllllllllIlllllIllIlllIIIlllII, true)) {
                return false;
            }
            lllllllllllIlllllIllIlllIIIlIIIl.setBlockState(lllllllllllIlllllIllIlllIIIlIIII, lllllllllllIlllllIllIlllIIIlIIlI.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true), 3);
            lllllllllllIlllllIllIlllIIIlIIIl.playSound(null, lllllllllllIlllllIllIlllIIIlIIII, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.5f, lllllllllllIlllllIllIlllIIIlIIIl.rand.nextFloat() * 0.25f + 0.6f);
        }
        else if (lllllllllllIlllllIllIlllIIIllllI == 1) {
            final TileEntity lllllllllllIlllllIllIlllIIIllIlI = lllllllllllIlllllIllIlllIIIlIIIl.getTileEntity(lllllllllllIlllllIllIlllIIIlIIII.offset(lllllllllllIlllllIllIlllIIIlllII));
            if (lllllllllllIlllllIllIlllIIIllIlI instanceof TileEntityPiston) {
                ((TileEntityPiston)lllllllllllIlllllIllIlllIIIllIlI).clearPistonTileEntity();
            }
            lllllllllllIlllllIllIlllIIIlIIIl.setBlockState(lllllllllllIlllllIllIlllIIIlIIII, Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, lllllllllllIlllllIllIlllIIIlllII).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT), 3);
            lllllllllllIlllllIllIlllIIIlIIIl.setTileEntity(lllllllllllIlllllIllIlllIIIlIIII, BlockPistonMoving.createTilePiston(this.getStateFromMeta(lllllllllllIlllllIllIlllIIIIlllI), lllllllllllIlllllIllIlllIIIlllII, false, true));
            if (this.isSticky) {
                final BlockPos lllllllllllIlllllIllIlllIIIllIIl = lllllllllllIlllllIllIlllIIIlIIII.add(lllllllllllIlllllIllIlllIIIlllII.getFrontOffsetX() * 2, lllllllllllIlllllIllIlllIIIlllII.getFrontOffsetY() * 2, lllllllllllIlllllIllIlllIIIlllII.getFrontOffsetZ() * 2);
                final IBlockState lllllllllllIlllllIllIlllIIIllIII = lllllllllllIlllllIllIlllIIIlIIIl.getBlockState(lllllllllllIlllllIllIlllIIIllIIl);
                final Block lllllllllllIlllllIllIlllIIIlIlll = lllllllllllIlllllIllIlllIIIllIII.getBlock();
                boolean lllllllllllIlllllIllIlllIIIlIllI = false;
                if (lllllllllllIlllllIllIlllIIIlIlll == Blocks.PISTON_EXTENSION) {
                    final TileEntity lllllllllllIlllllIllIlllIIIlIlIl = lllllllllllIlllllIllIlllIIIlIIIl.getTileEntity(lllllllllllIlllllIllIlllIIIllIIl);
                    if (lllllllllllIlllllIllIlllIIIlIlIl instanceof TileEntityPiston) {
                        final TileEntityPiston lllllllllllIlllllIllIlllIIIlIlII = (TileEntityPiston)lllllllllllIlllllIllIlllIIIlIlIl;
                        if (lllllllllllIlllllIllIlllIIIlIlII.getFacing() == lllllllllllIlllllIllIlllIIIlllII && lllllllllllIlllllIllIlllIIIlIlII.isExtending()) {
                            lllllllllllIlllllIllIlllIIIlIlII.clearPistonTileEntity();
                            lllllllllllIlllllIllIlllIIIlIllI = true;
                        }
                    }
                }
                if (!lllllllllllIlllllIllIlllIIIlIllI && lllllllllllIlllllIllIlllIIIllIII.getMaterial() != Material.AIR && canPush(lllllllllllIlllllIllIlllIIIllIII, lllllllllllIlllllIllIlllIIIlIIIl, lllllllllllIlllllIllIlllIIIllIIl, lllllllllllIlllllIllIlllIIIlllII.getOpposite(), false, lllllllllllIlllllIllIlllIIIlllII) && (lllllllllllIlllllIllIlllIIIllIII.getMobilityFlag() == EnumPushReaction.NORMAL || lllllllllllIlllllIllIlllIIIlIlll == Blocks.PISTON || lllllllllllIlllllIllIlllIIIlIlll == Blocks.STICKY_PISTON)) {
                    this.doMove(lllllllllllIlllllIllIlllIIIlIIIl, lllllllllllIlllllIllIlllIIIlIIII, lllllllllllIlllllIllIlllIIIlllII, false);
                }
            }
            else {
                lllllllllllIlllllIllIlllIIIlIIIl.setBlockToAir(lllllllllllIlllllIllIlllIIIlIIII.offset(lllllllllllIlllllIllIlllIIIlllII));
            }
            lllllllllllIlllllIllIlllIIIlIIIl.playSound(null, lllllllllllIlllllIllIlllIIIlIIII, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.5f, lllllllllllIlllllIllIlllIIIlIIIl.rand.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }
    
    @Override
    public boolean causesSuffocation(final IBlockState lllllllllllIlllllIllIllllIllIIIl) {
        return !lllllllllllIlllllIllIllllIllIIIl.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED);
    }
    
    private boolean doMove(final World lllllllllllIlllllIllIllIlIllllIl, final BlockPos lllllllllllIlllllIllIllIlIllllII, final EnumFacing lllllllllllIlllllIllIllIllIlIlIl, final boolean lllllllllllIlllllIllIllIlIlllIlI) {
        if (!lllllllllllIlllllIllIllIlIlllIlI) {
            lllllllllllIlllllIllIllIlIllllIl.setBlockToAir(lllllllllllIlllllIllIllIlIllllII.offset(lllllllllllIlllllIllIllIllIlIlIl));
        }
        final BlockPistonStructureHelper lllllllllllIlllllIllIllIllIlIIll = new BlockPistonStructureHelper(lllllllllllIlllllIllIllIlIllllIl, lllllllllllIlllllIllIllIlIllllII, lllllllllllIlllllIllIllIllIlIlIl, lllllllllllIlllllIllIllIlIlllIlI);
        if (!lllllllllllIlllllIllIllIllIlIIll.canMove()) {
            return false;
        }
        final List<BlockPos> lllllllllllIlllllIllIllIllIlIIlI = lllllllllllIlllllIllIllIllIlIIll.getBlocksToMove();
        final List<IBlockState> lllllllllllIlllllIllIllIllIlIIIl = (List<IBlockState>)Lists.newArrayList();
        for (int lllllllllllIlllllIllIllIllIlIIII = 0; lllllllllllIlllllIllIllIllIlIIII < lllllllllllIlllllIllIllIllIlIIlI.size(); ++lllllllllllIlllllIllIllIllIlIIII) {
            final BlockPos lllllllllllIlllllIllIllIllIIllll = lllllllllllIlllllIllIllIllIlIIlI.get(lllllllllllIlllllIllIllIllIlIIII);
            lllllllllllIlllllIllIllIllIlIIIl.add(lllllllllllIlllllIllIllIlIllllIl.getBlockState(lllllllllllIlllllIllIllIllIIllll).getActualState(lllllllllllIlllllIllIllIlIllllIl, lllllllllllIlllllIllIllIllIIllll));
        }
        final List<BlockPos> lllllllllllIlllllIllIllIllIIlllI = lllllllllllIlllllIllIllIllIlIIll.getBlocksToDestroy();
        int lllllllllllIlllllIllIllIllIIllIl = lllllllllllIlllllIllIllIllIlIIlI.size() + lllllllllllIlllllIllIllIllIIlllI.size();
        final IBlockState[] lllllllllllIlllllIllIllIllIIllII = new IBlockState[lllllllllllIlllllIllIllIllIIllIl];
        final EnumFacing lllllllllllIlllllIllIllIllIIlIll = lllllllllllIlllllIllIllIlIlllIlI ? lllllllllllIlllllIllIllIllIlIlIl : lllllllllllIlllllIllIllIllIlIlIl.getOpposite();
        for (int lllllllllllIlllllIllIllIllIIlIlI = lllllllllllIlllllIllIllIllIIlllI.size() - 1; lllllllllllIlllllIllIllIllIIlIlI >= 0; --lllllllllllIlllllIllIllIllIIlIlI) {
            final BlockPos lllllllllllIlllllIllIllIllIIlIIl = lllllllllllIlllllIllIllIllIIlllI.get(lllllllllllIlllllIllIllIllIIlIlI);
            final IBlockState lllllllllllIlllllIllIllIllIIlIII = lllllllllllIlllllIllIllIlIllllIl.getBlockState(lllllllllllIlllllIllIllIllIIlIIl);
            lllllllllllIlllllIllIllIllIIlIII.getBlock().dropBlockAsItem(lllllllllllIlllllIllIllIlIllllIl, lllllllllllIlllllIllIllIllIIlIIl, lllllllllllIlllllIllIllIllIIlIII, 0);
            lllllllllllIlllllIllIllIlIllllIl.setBlockState(lllllllllllIlllllIllIllIllIIlIIl, Blocks.AIR.getDefaultState(), 4);
            --lllllllllllIlllllIllIllIllIIllIl;
            lllllllllllIlllllIllIllIllIIllII[lllllllllllIlllllIllIllIllIIllIl] = lllllllllllIlllllIllIllIllIIlIII;
        }
        for (int lllllllllllIlllllIllIllIllIIIlll = lllllllllllIlllllIllIllIllIlIIlI.size() - 1; lllllllllllIlllllIllIllIllIIIlll >= 0; --lllllllllllIlllllIllIllIllIIIlll) {
            BlockPos lllllllllllIlllllIllIllIllIIIllI = lllllllllllIlllllIllIllIllIlIIlI.get(lllllllllllIlllllIllIllIllIIIlll);
            final IBlockState lllllllllllIlllllIllIllIllIIIlIl = lllllllllllIlllllIllIllIlIllllIl.getBlockState(lllllllllllIlllllIllIllIllIIIllI);
            lllllllllllIlllllIllIllIlIllllIl.setBlockState(lllllllllllIlllllIllIllIllIIIllI, Blocks.AIR.getDefaultState(), 2);
            lllllllllllIlllllIllIllIllIIIllI = lllllllllllIlllllIllIllIllIIIllI.offset(lllllllllllIlllllIllIllIllIIlIll);
            lllllllllllIlllllIllIllIlIllllIl.setBlockState(lllllllllllIlllllIllIllIllIIIllI, Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, lllllllllllIlllllIllIllIllIlIlIl), 4);
            lllllllllllIlllllIllIllIlIllllIl.setTileEntity(lllllllllllIlllllIllIllIllIIIllI, BlockPistonMoving.createTilePiston(lllllllllllIlllllIllIllIllIlIIIl.get(lllllllllllIlllllIllIllIllIIIlll), lllllllllllIlllllIllIllIllIlIlIl, lllllllllllIlllllIllIllIlIlllIlI, false));
            --lllllllllllIlllllIllIllIllIIllIl;
            lllllllllllIlllllIllIllIllIIllII[lllllllllllIlllllIllIllIllIIllIl] = lllllllllllIlllllIllIllIllIIIlIl;
        }
        final BlockPos lllllllllllIlllllIllIllIllIIIlII = lllllllllllIlllllIllIllIlIllllII.offset(lllllllllllIlllllIllIllIllIlIlIl);
        if (lllllllllllIlllllIllIllIlIlllIlI) {
            final BlockPistonExtension.EnumPistonType lllllllllllIlllllIllIllIllIIIIll = this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
            final IBlockState lllllllllllIlllllIllIllIllIIIIlI = Blocks.PISTON_HEAD.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, lllllllllllIlllllIllIllIllIlIlIl).withProperty(BlockPistonExtension.TYPE, lllllllllllIlllllIllIllIllIIIIll);
            final IBlockState lllllllllllIlllllIllIllIllIIIIIl = Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, lllllllllllIlllllIllIllIllIlIlIl).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
            lllllllllllIlllllIllIllIlIllllIl.setBlockState(lllllllllllIlllllIllIllIllIIIlII, lllllllllllIlllllIllIllIllIIIIIl, 4);
            lllllllllllIlllllIllIllIlIllllIl.setTileEntity(lllllllllllIlllllIllIllIllIIIlII, BlockPistonMoving.createTilePiston(lllllllllllIlllllIllIllIllIIIIlI, lllllllllllIlllllIllIllIllIlIlIl, true, true));
        }
        for (int lllllllllllIlllllIllIllIllIIIIII = lllllllllllIlllllIllIllIllIIlllI.size() - 1; lllllllllllIlllllIllIllIllIIIIII >= 0; --lllllllllllIlllllIllIllIllIIIIII) {
            lllllllllllIlllllIllIllIlIllllIl.notifyNeighborsOfStateChange(lllllllllllIlllllIllIllIllIIlllI.get(lllllllllllIlllllIllIllIllIIIIII), lllllllllllIlllllIllIllIllIIllII[lllllllllllIlllllIllIllIllIIllIl++].getBlock(), false);
        }
        for (int lllllllllllIlllllIllIllIlIllllll = lllllllllllIlllllIllIllIllIlIIlI.size() - 1; lllllllllllIlllllIllIllIlIllllll >= 0; --lllllllllllIlllllIllIllIlIllllll) {
            lllllllllllIlllllIllIllIlIllllIl.notifyNeighborsOfStateChange(lllllllllllIlllllIllIllIllIlIIlI.get(lllllllllllIlllllIllIllIlIllllll), lllllllllllIlllllIllIllIllIIllII[lllllllllllIlllllIllIllIllIIllIl++].getBlock(), false);
        }
        if (lllllllllllIlllllIllIllIlIlllIlI) {
            lllllllllllIlllllIllIllIlIllllIl.notifyNeighborsOfStateChange(lllllllllllIlllllIllIllIllIIIlII, Blocks.PISTON_HEAD, false);
        }
        return true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPistonBase.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lllllllllllIlllllIllIllIlIIIIIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllllIllIllIlIIIIIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPistonBase.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllllIllIllIlIIIIIII;
    }
}
