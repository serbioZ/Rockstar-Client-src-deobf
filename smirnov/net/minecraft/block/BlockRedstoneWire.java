// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.math.MathHelper;
import java.util.EnumSet;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.item.Item;
import java.util.Random;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rotation;
import com.google.common.collect.Sets;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.BlockPos;
import java.util.Set;
import net.minecraft.block.properties.PropertyInteger;

public class BlockRedstoneWire extends Block
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyInteger POWER;
    private final /* synthetic */ Set<BlockPos> blocksNeedingUpdate;
    private /* synthetic */ boolean canProvidePower;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> WEST;
    protected static final /* synthetic */ AxisAlignedBB[] REDSTONE_WIRE_AABB;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> EAST;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> NORTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> SOUTH;
    
    protected static boolean canConnectTo(final IBlockState lllllllllllIlllIlIlIIIIllllIllII, @Nullable final EnumFacing lllllllllllIlllIlIlIIIIllllIlIll) {
        final Block lllllllllllIlllIlIlIIIIllllIlllI = lllllllllllIlllIlIlIIIIllllIllII.getBlock();
        if (lllllllllllIlllIlIlIIIIllllIlllI == Blocks.REDSTONE_WIRE) {
            return true;
        }
        if (Blocks.UNPOWERED_REPEATER.isSameDiode(lllllllllllIlllIlIlIIIIllllIllII)) {
            final EnumFacing lllllllllllIlllIlIlIIIIllllIllIl = lllllllllllIlllIlIlIIIIllllIllII.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
            return lllllllllllIlllIlIlIIIIllllIllIl == lllllllllllIlllIlIlIIIIllllIlIll || lllllllllllIlllIlIlIIIIllllIllIl.getOpposite() == lllllllllllIlllIlIlIIIIllllIlIll;
        }
        if (Blocks.field_190976_dk == lllllllllllIlllIlIlIIIIllllIllII.getBlock()) {
            return lllllllllllIlllIlIlIIIIllllIlIll == lllllllllllIlllIlIlIIIIllllIllII.getValue((IProperty<EnumFacing>)BlockObserver.FACING);
        }
        return lllllllllllIlllIlIlIIIIllllIllII.canProvidePower() && lllllllllllIlllIlIlIIIIllllIlIll != null;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlllIlIlIIIllIIlIIlII, final IBlockAccess lllllllllllIlllIlIlIIIllIIlIIIII, final BlockPos lllllllllllIlllIlIlIIIllIIlIIIlI) {
        return BlockRedstoneWire.REDSTONE_WIRE_AABB[getAABBIndex(lllllllllllIlllIlIlIIIllIIlIIlII.getActualState(lllllllllllIlllIlIlIIIllIIlIIIII, lllllllllllIlllIlIlIIIllIIlIIIlI))];
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlllIlIlIIIIllIIIIlII, final IBlockState lllllllllllIlllIlIlIIIIllIIIIIll, final BlockPos lllllllllllIlllIlIlIIIIllIIIIIlI, final EnumFacing lllllllllllIlllIlIlIIIIllIIIIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private void notifyWireNeighborsOfStateChange(final World lllllllllllIlllIlIlIIIlIlIIlIlIl, final BlockPos lllllllllllIlllIlIlIIIlIlIIlIlII) {
        if (lllllllllllIlllIlIlIIIlIlIIlIlIl.getBlockState(lllllllllllIlllIlIlIIIlIlIIlIlII).getBlock() == this) {
            lllllllllllIlllIlIlIIIlIlIIlIlIl.notifyNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIlIIlIlII, this, false);
            final String lllllllllllIlllIlIlIIIlIlIIIllII;
            final double lllllllllllIlllIlIlIIIlIlIIIllIl = ((EnumFacing[])(Object)(lllllllllllIlllIlIlIIIlIlIIIllII = (String)(Object)EnumFacing.values())).length;
            for (short lllllllllllIlllIlIlIIIlIlIIIlllI = 0; lllllllllllIlllIlIlIIIlIlIIIlllI < lllllllllllIlllIlIlIIIlIlIIIllIl; ++lllllllllllIlllIlIlIIIlIlIIIlllI) {
                final EnumFacing lllllllllllIlllIlIlIIIlIlIIlIIll = lllllllllllIlllIlIlIIIlIlIIIllII[lllllllllllIlllIlIlIIIlIlIIIlllI];
                lllllllllllIlllIlIlIIIlIlIIlIlIl.notifyNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIlIIlIlII.offset(lllllllllllIlllIlIlIIIlIlIIlIIll), this, false);
            }
        }
    }
    
    public BlockRedstoneWire() {
        super(Material.CIRCUITS);
        this.canProvidePower = true;
        this.blocksNeedingUpdate = (Set<BlockPos>)Sets.newHashSet();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedstoneWire.NORTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.EAST, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.SOUTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.WEST, EnumAttachPosition.NONE).withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, 0));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIlllIlIlIIIIllIIlIIll, final Rotation lllllllllllIlllIlIlIIIIllIIlIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIlllIlIlIIIIllIIlIlII.ordinal()]) {
            case 3: {
                return lllllllllllIlllIlIlIIIIllIIlIIll.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.NORTH)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.EAST));
            }
            case 4: {
                return lllllllllllIlllIlIlIIIIllIIlIIll.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.EAST)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.NORTH));
            }
            case 2: {
                return lllllllllllIlllIlIlIIIIllIIlIIll.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.NORTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.EAST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIlIIll.getValue((IProperty<V>)BlockRedstoneWire.SOUTH));
            }
            default: {
                return lllllllllllIlllIlIlIIIIllIIlIIll;
            }
        }
    }
    
    protected static boolean canConnectUpwardsTo(final IBlockAccess lllllllllllIlllIlIlIIIIllllllIIl, final BlockPos lllllllllllIlllIlIlIIIIllllllIII) {
        return canConnectUpwardsTo(lllllllllllIlllIlIlIIIIllllllIIl.getBlockState(lllllllllllIlllIlIlIIIIllllllIII));
    }
    
    protected static boolean canConnectUpwardsTo(final IBlockState lllllllllllIlllIlIlIIIIlllllIlIl) {
        return canConnectTo(lllllllllllIlllIlIlIIIIlllllIlIl, null);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIlllIlIlIIIlIlllIlIIl, final IBlockAccess lllllllllllIlllIlIlIIIlIlllIlIII, final BlockPos lllllllllllIlllIlIlIIIlIlllIIlll) {
        return BlockRedstoneWire.NULL_AABB;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlllIlIlIIIIllIlIIllI, final BlockPos lllllllllllIlllIlIlIIIIllIlIIlIl, final IBlockState lllllllllllIlllIlIlIIIIllIlIIlII) {
        return new ItemStack(Items.REDSTONE);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllIlIlIIIlIlllIIlIl) {
        return false;
    }
    
    private EnumAttachPosition getAttachPosition(final IBlockAccess lllllllllllIlllIlIlIIIlIlllllIII, final BlockPos lllllllllllIlllIlIlIIIlIllllIlll, final EnumFacing lllllllllllIlllIlIlIIIlIlllIllll) {
        final BlockPos lllllllllllIlllIlIlIIIlIllllIlIl = lllllllllllIlllIlIlIIIlIllllIlll.offset(lllllllllllIlllIlIlIIIlIlllIllll);
        final IBlockState lllllllllllIlllIlIlIIIlIllllIlII = lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlll.offset(lllllllllllIlllIlIlIIIlIlllIllll));
        if (!canConnectTo(lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlIl), lllllllllllIlllIlIlIIIlIlllIllll) && (lllllllllllIlllIlIlIIIlIllllIlII.isNormalCube() || !canConnectUpwardsTo(lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlIl.down())))) {
            final IBlockState lllllllllllIlllIlIlIIIlIllllIIll = lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlll.up());
            if (!lllllllllllIlllIlIlIIIlIllllIIll.isNormalCube()) {
                final boolean lllllllllllIlllIlIlIIIlIllllIIlI = lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlIl).isFullyOpaque() || lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlIl).getBlock() == Blocks.GLOWSTONE;
                if (lllllllllllIlllIlIlIIIlIllllIIlI && canConnectUpwardsTo(lllllllllllIlllIlIlIIIlIlllllIII.getBlockState(lllllllllllIlllIlIlIIIlIllllIlIl.up()))) {
                    if (lllllllllllIlllIlIlIIIlIllllIlII.isBlockNormalCube()) {
                        return EnumAttachPosition.UP;
                    }
                    return EnumAttachPosition.SIDE;
                }
            }
            return EnumAttachPosition.NONE;
        }
        return EnumAttachPosition.SIDE;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlllIlIlIIIlIIlIIlIIl, final World lllllllllllIlllIlIlIIIlIIlIIIIlI, final BlockPos lllllllllllIlllIlIlIIIlIIlIIIlll, final Block lllllllllllIlllIlIlIIIlIIlIIIllI, final BlockPos lllllllllllIlllIlIlIIIlIIlIIIlIl) {
        if (!lllllllllllIlllIlIlIIIlIIlIIIIlI.isRemote) {
            if (this.canPlaceBlockAt(lllllllllllIlllIlIlIIIlIIlIIIIlI, lllllllllllIlllIlIlIIIlIIlIIIlll)) {
                this.updateSurroundingRedstone(lllllllllllIlllIlIlIIIlIIlIIIIlI, lllllllllllIlllIlIlIIIlIIlIIIlll, lllllllllllIlllIlIlIIIlIIlIIlIIl);
            }
            else {
                this.dropBlockAsItem(lllllllllllIlllIlIlIIIlIIlIIIIlI, lllllllllllIlllIlIlIIIlIIlIIIlll, lllllllllllIlllIlIlIIIlIIlIIlIIl, 0);
                lllllllllllIlllIlIlIIIlIIlIIIIlI.setBlockToAir(lllllllllllIlllIlIlIIIlIIlIIIlll);
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlllIlIlIIIlIllIlllll, final BlockPos lllllllllllIlllIlIlIIIlIllIlllII) {
        return lllllllllllIlllIlIlIIIlIllIlllll.getBlockState(lllllllllllIlllIlIlIIIlIllIlllII.down()).isFullyOpaque() || lllllllllllIlllIlIlIIIlIllIlllll.getBlockState(lllllllllllIlllIlIlIIIlIllIlllII.down()).getBlock() == Blocks.GLOWSTONE;
    }
    
    private IBlockState updateSurroundingRedstone(final World lllllllllllIlllIlIlIIIlIllIIllIl, final BlockPos lllllllllllIlllIlIlIIIlIllIIllII, IBlockState lllllllllllIlllIlIlIIIlIllIIlIll) {
        lllllllllllIlllIlIlIIIlIllIIlIll = (byte)this.calculateCurrentChanges(lllllllllllIlllIlIlIIIlIllIIllIl, lllllllllllIlllIlIlIIIlIllIIllII, lllllllllllIlllIlIlIIIlIllIIllII, (IBlockState)lllllllllllIlllIlIlIIIlIllIIlIll);
        final List<BlockPos> lllllllllllIlllIlIlIIIlIllIlIIII = (List<BlockPos>)Lists.newArrayList((Iterable)this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();
        for (final BlockPos lllllllllllIlllIlIlIIIlIllIIllll : lllllllllllIlllIlIlIIIlIllIlIIII) {
            lllllllllllIlllIlIlIIIlIllIIllIl.notifyNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIllIIllll, this, false);
        }
        return (IBlockState)lllllllllllIlllIlIlIIIlIllIIlIll;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlllIlIlIIIlIIIllllll, final Random lllllllllllIlllIlIlIIIlIIIlllllI, final int lllllllllllIlllIlIlIIIlIIIllllIl) {
        return Items.REDSTONE;
    }
    
    private int getMaxCurrentStrength(final World lllllllllllIlllIlIlIIIlIIlIlIlll, final BlockPos lllllllllllIlllIlIlIIIlIIlIlIllI, final int lllllllllllIlllIlIlIIIlIIlIlIIII) {
        if (lllllllllllIlllIlIlIIIlIIlIlIlll.getBlockState(lllllllllllIlllIlIlIIIlIIlIlIllI).getBlock() != this) {
            return lllllllllllIlllIlIlIIIlIIlIlIIII;
        }
        final int lllllllllllIlllIlIlIIIlIIlIlIlII = lllllllllllIlllIlIlIIIlIIlIlIlll.getBlockState(lllllllllllIlllIlIlIIIlIIlIlIllI).getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        return (lllllllllllIlllIlIlIIIlIIlIlIlII > lllllllllllIlllIlIlIIIlIIlIlIIII) ? lllllllllllIlllIlIlIIIlIIlIlIlII : lllllllllllIlllIlIlIIIlIIlIlIIII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllIlllIlIlIIIIlIlllllll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIlllIlIlIIIIlIlllllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIlIlIIIIlIlllllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIlIlIIIIlIlllllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIlIlIIIIlIlllllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIlllIlIlIIIIlIlllllll;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIlllIlIlIIIlIIllIIlII, final BlockPos lllllllllllIlllIlIlIIIlIIllIlIll, final IBlockState lllllllllllIlllIlIlIIIlIIllIlIlI) {
        super.breakBlock(lllllllllllIlllIlIlIIIlIIllIIlII, lllllllllllIlllIlIlIIIlIIllIlIll, lllllllllllIlllIlIlIIIlIIllIlIlI);
        if (!lllllllllllIlllIlIlIIIlIIllIIlII.isRemote) {
            final char lllllllllllIlllIlIlIIIlIIlIllllI;
            final int length = (lllllllllllIlllIlIlIIIlIIlIllllI = (char)(Object)EnumFacing.values()).length;
            for (short lllllllllllIlllIlIlIIIlIIllIIIII = 0; lllllllllllIlllIlIlIIIlIIllIIIII < length; ++lllllllllllIlllIlIlIIIlIIllIIIII) {
                final EnumFacing lllllllllllIlllIlIlIIIlIIllIlIIl = lllllllllllIlllIlIlIIIlIIlIllllI[lllllllllllIlllIlIlIIIlIIllIIIII];
                lllllllllllIlllIlIlIIIlIIllIIlII.notifyNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllIlIll.offset(lllllllllllIlllIlIlIIIlIIllIlIIl), this, false);
            }
            this.updateSurroundingRedstone(lllllllllllIlllIlIlIIIlIIllIIlII, lllllllllllIlllIlIlIIIlIIllIlIll, lllllllllllIlllIlIlIIIlIIllIlIlI);
            for (final EnumFacing lllllllllllIlllIlIlIIIlIIllIlIII : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllIIlII, lllllllllllIlllIlIlIIIlIIllIlIll.offset(lllllllllllIlllIlIlIIIlIIllIlIII));
            }
            for (final EnumFacing lllllllllllIlllIlIlIIIlIIllIIlll : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos lllllllllllIlllIlIlIIIlIIllIIllI = lllllllllllIlllIlIlIIIlIIllIlIll.offset(lllllllllllIlllIlIlIIIlIIllIIlll);
                if (lllllllllllIlllIlIlIIIlIIllIIlII.getBlockState(lllllllllllIlllIlIlIIIlIIllIIllI).isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllIIlII, lllllllllllIlllIlIlIIIlIIllIIllI.up());
                }
                else {
                    this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllIIlII, lllllllllllIlllIlIlIIIlIIllIIllI.down());
                }
            }
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIlllIlIlIIIIllIIIllIl, final Mirror lllllllllllIlllIlIlIIIIllIIIlIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllIlllIlIlIIIIllIIIlIIl.ordinal()]) {
            case 2: {
                return lllllllllllIlllIlIlIIIIllIIIllIl.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIIllIl.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIIllIl.getValue((IProperty<V>)BlockRedstoneWire.NORTH));
            }
            case 3: {
                return lllllllllllIlllIlIlIIIIllIIIllIl.withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIIllIl.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllIlllIlIlIIIIllIIIllIl.getValue((IProperty<V>)BlockRedstoneWire.EAST));
            }
            default: {
                return super.withMirror(lllllllllllIlllIlIlIIIIllIIIllIl, lllllllllllIlllIlIlIIIIllIIIlIIl);
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlllIlIlIIIIllIIllIIl) {
        return lllllllllllIlllIlIlIIIIllIIllIIl.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlllIlIlIIIIllIllIIll, final World lllllllllllIlllIlIlIIIIllIllIIlI, final BlockPos lllllllllllIlllIlIlIIIIllIllIIIl, final Random lllllllllllIlllIlIlIIIIllIllIIII) {
        final int lllllllllllIlllIlIlIIIIllIlllIll = lllllllllllIlllIlIlIIIIllIllIIll.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        if (lllllllllllIlllIlIlIIIIllIlllIll != 0) {
            final double lllllllllllIlllIlIlIIIIllIlllIlI = lllllllllllIlllIlIlIIIIllIllIIIl.getX() + 0.5 + (lllllllllllIlllIlIlIIIIllIllIIII.nextFloat() - 0.5) * 0.2;
            final double lllllllllllIlllIlIlIIIIllIlllIIl = lllllllllllIlllIlIlIIIIllIllIIIl.getY() + 0.0625f;
            final double lllllllllllIlllIlIlIIIIllIlllIII = lllllllllllIlllIlIlIIIIllIllIIIl.getZ() + 0.5 + (lllllllllllIlllIlIlIIIIllIllIIII.nextFloat() - 0.5) * 0.2;
            final float lllllllllllIlllIlIlIIIIllIllIlll = lllllllllllIlllIlIlIIIIllIlllIll / 15.0f;
            final float lllllllllllIlllIlIlIIIIllIllIllI = lllllllllllIlllIlIlIIIIllIllIlll * 0.6f + 0.4f;
            final float lllllllllllIlllIlIlIIIIllIllIlIl = Math.max(0.0f, lllllllllllIlllIlIlIIIIllIllIlll * lllllllllllIlllIlIlIIIIllIllIlll * 0.7f - 0.5f);
            final float lllllllllllIlllIlIlIIIIllIllIlII = Math.max(0.0f, lllllllllllIlllIlIlIIIIllIllIlll * lllllllllllIlllIlIlIIIIllIllIlll * 0.6f - 0.7f);
            lllllllllllIlllIlIlIIIIllIllIIlI.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllIlllIlIlIIIIllIlllIlI, lllllllllllIlllIlIlIIIIllIlllIIl, lllllllllllIlllIlIlIIIIllIlllIII, lllllllllllIlllIlIlIIIIllIllIllI, lllllllllllIlllIlIlIIIIllIllIlIl, lllllllllllIlllIlIlIIIIllIllIlII, new int[0]);
        }
    }
    
    private static int getAABBIndex(final IBlockState lllllllllllIlllIlIlIIIllIIIllIII) {
        int lllllllllllIlllIlIlIIIllIIIlIlll = 0;
        final boolean lllllllllllIlllIlIlIIIllIIIlIllI = lllllllllllIlllIlIlIIIllIIIllIII.getValue(BlockRedstoneWire.NORTH) != EnumAttachPosition.NONE;
        final boolean lllllllllllIlllIlIlIIIllIIIlIlIl = lllllllllllIlllIlIlIIIllIIIllIII.getValue(BlockRedstoneWire.EAST) != EnumAttachPosition.NONE;
        final boolean lllllllllllIlllIlIlIIIllIIIlIlII = lllllllllllIlllIlIlIIIllIIIllIII.getValue(BlockRedstoneWire.SOUTH) != EnumAttachPosition.NONE;
        final boolean lllllllllllIlllIlIlIIIllIIIlIIll = lllllllllllIlllIlIlIIIllIIIllIII.getValue(BlockRedstoneWire.WEST) != EnumAttachPosition.NONE;
        if (lllllllllllIlllIlIlIIIllIIIlIllI || (lllllllllllIlllIlIlIIIllIIIlIlII && !lllllllllllIlllIlIlIIIllIIIlIllI && !lllllllllllIlllIlIlIIIllIIIlIlIl && !lllllllllllIlllIlIlIIIllIIIlIIll)) {
            lllllllllllIlllIlIlIIIllIIIlIlll |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (lllllllllllIlllIlIlIIIllIIIlIlIl || (lllllllllllIlllIlIlIIIllIIIlIIll && !lllllllllllIlllIlIlIIIllIIIlIllI && !lllllllllllIlllIlIlIIIllIIIlIlIl && !lllllllllllIlllIlIlIIIllIIIlIlII)) {
            lllllllllllIlllIlIlIIIllIIIlIlll |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (lllllllllllIlllIlIlIIIllIIIlIlII || (lllllllllllIlllIlIlIIIllIIIlIllI && !lllllllllllIlllIlIlIIIllIIIlIlIl && !lllllllllllIlllIlIlIIIllIIIlIlII && !lllllllllllIlllIlIlIIIllIIIlIIll)) {
            lllllllllllIlllIlIlIIIllIIIlIlll |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (lllllllllllIlllIlIlIIIllIIIlIIll || (lllllllllllIlllIlIlIIIllIIIlIlIl && !lllllllllllIlllIlIlIIIllIIIlIllI && !lllllllllllIlllIlIlIIIllIIIlIlII && !lllllllllllIlllIlIlIIIllIIIlIIll)) {
            lllllllllllIlllIlIlIIIllIIIlIlll |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return lllllllllllIlllIlIlIIIllIIIlIlll;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlllIlIlIIIIllIIlllIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, lllllllllllIlllIlIlIIIIllIIlllIl);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlllIlIlIIIlIlllIIIll) {
        return false;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllIlllIlIlIIIlIIIllIIIl, final IBlockAccess lllllllllllIlllIlIlIIIlIIIllIlIl, final BlockPos lllllllllllIlllIlIlIIIlIIIllIlII, final EnumFacing lllllllllllIlllIlIlIIIlIIIllIIll) {
        return this.canProvidePower ? lllllllllllIlllIlIlIIIlIIIllIIIl.getWeakPower(lllllllllllIlllIlIlIIIlIIIllIlIl, lllllllllllIlllIlIlIIIlIIIllIlII, lllllllllllIlllIlIlIIIlIIIllIIll) : 0;
    }
    
    static {
        NORTH = PropertyEnum.create("north", EnumAttachPosition.class);
        EAST = PropertyEnum.create("east", EnumAttachPosition.class);
        SOUTH = PropertyEnum.create("south", EnumAttachPosition.class);
        WEST = PropertyEnum.create("west", EnumAttachPosition.class);
        POWER = PropertyInteger.create("power", 0, 15);
        REDSTONE_WIRE_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.1875, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.1875, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.0, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.0, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.0, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.1875, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.1875, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.1875, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.1875, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.0, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.0, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0) };
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlllIlIlIIIlIIllllIll, final BlockPos lllllllllllIlllIlIlIIIlIlIIIIIlI, final IBlockState lllllllllllIlllIlIlIIIlIlIIIIIIl) {
        if (!lllllllllllIlllIlIlIIIlIIllllIll.isRemote) {
            this.updateSurroundingRedstone(lllllllllllIlllIlIlIIIlIIllllIll, lllllllllllIlllIlIlIIIlIlIIIIIlI, lllllllllllIlllIlIlIIIlIlIIIIIIl);
            for (final EnumFacing lllllllllllIlllIlIlIIIlIlIIIIIII : EnumFacing.Plane.VERTICAL) {
                lllllllllllIlllIlIlIIIlIIllllIll.notifyNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIlIIIIIlI.offset(lllllllllllIlllIlIlIIIlIlIIIIIII), this, false);
            }
            for (final EnumFacing lllllllllllIlllIlIlIIIlIIlllllll : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllllIll, lllllllllllIlllIlIlIIIlIlIIIIIlI.offset(lllllllllllIlllIlIlIIIlIIlllllll));
            }
            for (final EnumFacing lllllllllllIlllIlIlIIIlIIllllllI : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos lllllllllllIlllIlIlIIIlIIlllllIl = lllllllllllIlllIlIlIIIlIlIIIIIlI.offset(lllllllllllIlllIlIlIIIlIIllllllI);
                if (lllllllllllIlllIlIlIIIlIIllllIll.getBlockState(lllllllllllIlllIlIlIIIlIIlllllIl).isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllllIll, lllllllllllIlllIlIlIIIlIIlllllIl.up());
                }
                else {
                    this.notifyWireNeighborsOfStateChange(lllllllllllIlllIlIlIIIlIIllllIll, lllllllllllIlllIlIlIIIlIIlllllIl.down());
                }
            }
        }
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIlllIlIlIIIlIIIIllIll, final IBlockAccess lllllllllllIlllIlIlIIIlIIIIllIlI, final BlockPos lllllllllllIlllIlIlIIIlIIIIllIIl, final EnumFacing lllllllllllIlllIlIlIIIlIIIlIIIII) {
        if (!this.canProvidePower) {
            return 0;
        }
        final int lllllllllllIlllIlIlIIIlIIIIlllll = lllllllllllIlllIlIlIIIlIIIIllIll.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        if (lllllllllllIlllIlIlIIIlIIIIlllll == 0) {
            return 0;
        }
        if (lllllllllllIlllIlIlIIIlIIIlIIIII == EnumFacing.UP) {
            return lllllllllllIlllIlIlIIIlIIIIlllll;
        }
        final EnumSet<EnumFacing> lllllllllllIlllIlIlIIIlIIIIllllI = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing lllllllllllIlllIlIlIIIlIIIIlllIl : EnumFacing.Plane.HORIZONTAL) {
            if (this.isPowerSourceAt(lllllllllllIlllIlIlIIIlIIIIllIlI, lllllllllllIlllIlIlIIIlIIIIllIIl, lllllllllllIlllIlIlIIIlIIIIlllIl)) {
                lllllllllllIlllIlIlIIIlIIIIllllI.add(lllllllllllIlllIlIlIIIlIIIIlllIl);
            }
        }
        if (lllllllllllIlllIlIlIIIlIIIlIIIII.getAxis().isHorizontal() && lllllllllllIlllIlIlIIIlIIIIllllI.isEmpty()) {
            return lllllllllllIlllIlIlIIIlIIIIlllll;
        }
        if (lllllllllllIlllIlIlIIIlIIIIllllI.contains(lllllllllllIlllIlIlIIIlIIIlIIIII) && !lllllllllllIlllIlIlIIIlIIIIllllI.contains(lllllllllllIlllIlIlIIIlIIIlIIIII.rotateYCCW()) && !lllllllllllIlllIlIlIIIlIIIIllllI.contains(lllllllllllIlllIlIlIIIlIIIlIIIII.rotateY())) {
            return lllllllllllIlllIlIlIIIlIIIIlllll;
        }
        return 0;
    }
    
    public static int colorMultiplier(final int lllllllllllIlllIlIlIIIIlllIlIlII) {
        final float lllllllllllIlllIlIlIIIIlllIllIll = lllllllllllIlllIlIlIIIIlllIlIlII / 15.0f;
        float lllllllllllIlllIlIlIIIIlllIllIlI = lllllllllllIlllIlIlIIIIlllIllIll * 0.6f + 0.4f;
        if (lllllllllllIlllIlIlIIIIlllIlIlII == 0) {
            lllllllllllIlllIlIlIIIIlllIllIlI = 0.3f;
        }
        float lllllllllllIlllIlIlIIIIlllIllIIl = lllllllllllIlllIlIlIIIIlllIllIll * lllllllllllIlllIlIlIIIIlllIllIll * 0.7f - 0.5f;
        float lllllllllllIlllIlIlIIIIlllIllIII = lllllllllllIlllIlIlIIIIlllIllIll * lllllllllllIlllIlIlIIIIlllIllIll * 0.6f - 0.7f;
        if (lllllllllllIlllIlIlIIIIlllIllIIl < 0.0f) {
            lllllllllllIlllIlIlIIIIlllIllIIl = 0.0f;
        }
        if (lllllllllllIlllIlIlIIIIlllIllIII < 0.0f) {
            lllllllllllIlllIlIlIIIIlllIllIII = 0.0f;
        }
        final int lllllllllllIlllIlIlIIIIlllIlIlll = MathHelper.clamp((int)(lllllllllllIlllIlIlIIIIlllIllIlI * 255.0f), 0, 255);
        final int lllllllllllIlllIlIlIIIIlllIlIllI = MathHelper.clamp((int)(lllllllllllIlllIlIlIIIIlllIllIIl * 255.0f), 0, 255);
        final int lllllllllllIlllIlIlIIIIlllIlIlIl = MathHelper.clamp((int)(lllllllllllIlllIlIlIIIIlllIllIII * 255.0f), 0, 255);
        return 0xFF000000 | lllllllllllIlllIlIlIIIIlllIlIlll << 16 | lllllllllllIlllIlIlIIIIlllIlIllI << 8 | lllllllllllIlllIlIlIIIIlllIlIlIl;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneWire.NORTH, BlockRedstoneWire.EAST, BlockRedstoneWire.SOUTH, BlockRedstoneWire.WEST, BlockRedstoneWire.POWER });
    }
    
    private boolean isPowerSourceAt(final IBlockAccess lllllllllllIlllIlIlIIIlIIIIIlIll, final BlockPos lllllllllllIlllIlIlIIIlIIIIIIIll, final EnumFacing lllllllllllIlllIlIlIIIlIIIIIIIlI) {
        final BlockPos lllllllllllIlllIlIlIIIlIIIIIlIII = lllllllllllIlllIlIlIIIlIIIIIIIll.offset(lllllllllllIlllIlIlIIIlIIIIIIIlI);
        final IBlockState lllllllllllIlllIlIlIIIlIIIIIIlll = lllllllllllIlllIlIlIIIlIIIIIlIll.getBlockState(lllllllllllIlllIlIlIIIlIIIIIlIII);
        final boolean lllllllllllIlllIlIlIIIlIIIIIIllI = lllllllllllIlllIlIlIIIlIIIIIIlll.isNormalCube();
        final boolean lllllllllllIlllIlIlIIIlIIIIIIlIl = lllllllllllIlllIlIlIIIlIIIIIlIll.getBlockState(lllllllllllIlllIlIlIIIlIIIIIIIll.up()).isNormalCube();
        return (!lllllllllllIlllIlIlIIIlIIIIIIlIl && lllllllllllIlllIlIlIIIlIIIIIIllI && canConnectUpwardsTo(lllllllllllIlllIlIlIIIlIIIIIlIll, lllllllllllIlllIlIlIIIlIIIIIlIII.up())) || canConnectTo(lllllllllllIlllIlIlIIIlIIIIIIlll, lllllllllllIlllIlIlIIIlIIIIIIIlI) || (lllllllllllIlllIlIlIIIlIIIIIIlll.getBlock() == Blocks.POWERED_REPEATER && lllllllllllIlllIlIlIIIlIIIIIIlll.getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) == lllllllllllIlllIlIlIIIlIIIIIIIlI) || (!lllllllllllIlllIlIlIIIlIIIIIIllI && canConnectUpwardsTo(lllllllllllIlllIlIlIIIlIIIIIlIll, lllllllllllIlllIlIlIIIlIIIIIlIII.down()));
    }
    
    private IBlockState calculateCurrentChanges(final World lllllllllllIlllIlIlIIIlIlIlIlIlI, final BlockPos lllllllllllIlllIlIlIIIlIlIlIlIIl, final BlockPos lllllllllllIlllIlIlIIIlIlIllIllI, IBlockState lllllllllllIlllIlIlIIIlIlIlIIlll) {
        final IBlockState lllllllllllIlllIlIlIIIlIlIllIlII = lllllllllllIlllIlIlIIIlIlIlIIlll;
        final int lllllllllllIlllIlIlIIIlIlIllIIll = lllllllllllIlllIlIlIIIlIlIlIIlll.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        int lllllllllllIlllIlIlIIIlIlIllIIlI = 0;
        lllllllllllIlllIlIlIIIlIlIllIIlI = this.getMaxCurrentStrength(lllllllllllIlllIlIlIIIlIlIlIlIlI, lllllllllllIlllIlIlIIIlIlIllIllI, lllllllllllIlllIlIlIIIlIlIllIIlI);
        this.canProvidePower = false;
        final int lllllllllllIlllIlIlIIIlIlIllIIIl = lllllllllllIlllIlIlIIIlIlIlIlIlI.isBlockIndirectlyGettingPowered(lllllllllllIlllIlIlIIIlIlIlIlIIl);
        this.canProvidePower = true;
        if (lllllllllllIlllIlIlIIIlIlIllIIIl > 0 && lllllllllllIlllIlIlIIIlIlIllIIIl > lllllllllllIlllIlIlIIIlIlIllIIlI - 1) {
            lllllllllllIlllIlIlIIIlIlIllIIlI = lllllllllllIlllIlIlIIIlIlIllIIIl;
        }
        int lllllllllllIlllIlIlIIIlIlIllIIII = 0;
        for (final EnumFacing lllllllllllIlllIlIlIIIlIlIlIllll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllIlllIlIlIIIlIlIlIlllI = lllllllllllIlllIlIlIIIlIlIlIlIIl.offset(lllllllllllIlllIlIlIIIlIlIlIllll);
            final boolean lllllllllllIlllIlIlIIIlIlIlIllIl = lllllllllllIlllIlIlIIIlIlIlIlllI.getX() != lllllllllllIlllIlIlIIIlIlIllIllI.getX() || lllllllllllIlllIlIlIIIlIlIlIlllI.getZ() != lllllllllllIlllIlIlIIIlIlIllIllI.getZ();
            if (lllllllllllIlllIlIlIIIlIlIlIllIl) {
                lllllllllllIlllIlIlIIIlIlIllIIII = this.getMaxCurrentStrength(lllllllllllIlllIlIlIIIlIlIlIlIlI, lllllllllllIlllIlIlIIIlIlIlIlllI, lllllllllllIlllIlIlIIIlIlIllIIII);
            }
            if (lllllllllllIlllIlIlIIIlIlIlIlIlI.getBlockState(lllllllllllIlllIlIlIIIlIlIlIlllI).isNormalCube() && !lllllllllllIlllIlIlIIIlIlIlIlIlI.getBlockState(lllllllllllIlllIlIlIIIlIlIlIlIIl.up()).isNormalCube()) {
                if (!lllllllllllIlllIlIlIIIlIlIlIllIl || lllllllllllIlllIlIlIIIlIlIlIlIIl.getY() < lllllllllllIlllIlIlIIIlIlIllIllI.getY()) {
                    continue;
                }
                lllllllllllIlllIlIlIIIlIlIllIIII = this.getMaxCurrentStrength(lllllllllllIlllIlIlIIIlIlIlIlIlI, lllllllllllIlllIlIlIIIlIlIlIlllI.up(), lllllllllllIlllIlIlIIIlIlIllIIII);
            }
            else {
                if (lllllllllllIlllIlIlIIIlIlIlIlIlI.getBlockState(lllllllllllIlllIlIlIIIlIlIlIlllI).isNormalCube() || !lllllllllllIlllIlIlIIIlIlIlIllIl || lllllllllllIlllIlIlIIIlIlIlIlIIl.getY() > lllllllllllIlllIlIlIIIlIlIllIllI.getY()) {
                    continue;
                }
                lllllllllllIlllIlIlIIIlIlIllIIII = this.getMaxCurrentStrength(lllllllllllIlllIlIlIIIlIlIlIlIlI, lllllllllllIlllIlIlIIIlIlIlIlllI.down(), lllllllllllIlllIlIlIIIlIlIllIIII);
            }
        }
        if (lllllllllllIlllIlIlIIIlIlIllIIII > lllllllllllIlllIlIlIIIlIlIllIIlI) {
            lllllllllllIlllIlIlIIIlIlIllIIlI = lllllllllllIlllIlIlIIIlIlIllIIII - 1;
        }
        else if (lllllllllllIlllIlIlIIIlIlIllIIlI > 0) {
            --lllllllllllIlllIlIlIIIlIlIllIIlI;
        }
        else {
            lllllllllllIlllIlIlIIIlIlIllIIlI = 0;
        }
        if (lllllllllllIlllIlIlIIIlIlIllIIIl > lllllllllllIlllIlIlIIIlIlIllIIlI - 1) {
            lllllllllllIlllIlIlIIIlIlIllIIlI = lllllllllllIlllIlIlIIIlIlIllIIIl;
        }
        if (lllllllllllIlllIlIlIIIlIlIllIIll != lllllllllllIlllIlIlIIIlIlIllIIlI) {
            lllllllllllIlllIlIlIIIlIlIlIIlll = lllllllllllIlllIlIlIIIlIlIlIIlll.withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, lllllllllllIlllIlIlIIIlIlIllIIlI);
            if (lllllllllllIlllIlIlIIIlIlIlIlIlI.getBlockState(lllllllllllIlllIlIlIIIlIlIlIlIIl) == lllllllllllIlllIlIlIIIlIlIllIlII) {
                lllllllllllIlllIlIlIIIlIlIlIlIlI.setBlockState(lllllllllllIlllIlIlIIIlIlIlIlIIl, lllllllllllIlllIlIlIIIlIlIlIIlll, 2);
            }
            this.blocksNeedingUpdate.add(lllllllllllIlllIlIlIIIlIlIlIlIIl);
            final EnumFacing[] values;
            final String lllllllllllIlllIlIlIIIlIlIIlllll = (String)(values = EnumFacing.values()).length;
            for (boolean lllllllllllIlllIlIlIIIlIlIlIIIII = false; lllllllllllIlllIlIlIIIlIlIlIIIII < lllllllllllIlllIlIlIIIlIlIIlllll; ++lllllllllllIlllIlIlIIIlIlIlIIIII) {
                final EnumFacing lllllllllllIlllIlIlIIIlIlIlIllII = values[lllllllllllIlllIlIlIIIlIlIlIIIII];
                this.blocksNeedingUpdate.add(lllllllllllIlllIlIlIIIlIlIlIlIIl.offset(lllllllllllIlllIlIlIIIlIlIlIllII));
            }
        }
        return lllllllllllIlllIlIlIIIlIlIlIIlll;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIlllIlIlIIIIllllIIllI) {
        return this.canProvidePower;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final int lllllllllllIlllIlIlIIIIlIlllllIl = (Object)new int[Mirror.values().length];
        try {
            lllllllllllIlllIlIlIIIIlIlllllIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIlIlIIIIlIlllllIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIlIlIIIIlIlllllIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIlllIlIlIIIIlIlllllIl;
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllIlllIlIlIIIllIIIIIIll, final IBlockAccess lllllllllllIlllIlIlIIIllIIIIIllI, final BlockPos lllllllllllIlllIlIlIIIllIIIIIIIl) {
        lllllllllllIlllIlIlIIIllIIIIIIll = lllllllllllIlllIlIlIIIllIIIIIIll.withProperty(BlockRedstoneWire.WEST, this.getAttachPosition(lllllllllllIlllIlIlIIIllIIIIIllI, lllllllllllIlllIlIlIIIllIIIIIIIl, EnumFacing.WEST));
        lllllllllllIlllIlIlIIIllIIIIIIll = lllllllllllIlllIlIlIIIllIIIIIIll.withProperty(BlockRedstoneWire.EAST, this.getAttachPosition(lllllllllllIlllIlIlIIIllIIIIIllI, lllllllllllIlllIlIlIIIllIIIIIIIl, EnumFacing.EAST));
        lllllllllllIlllIlIlIIIllIIIIIIll = lllllllllllIlllIlIlIIIllIIIIIIll.withProperty(BlockRedstoneWire.NORTH, this.getAttachPosition(lllllllllllIlllIlIlIIIllIIIIIllI, lllllllllllIlllIlIlIIIllIIIIIIIl, EnumFacing.NORTH));
        lllllllllllIlllIlIlIIIllIIIIIIll = lllllllllllIlllIlIlIIIllIIIIIIll.withProperty(BlockRedstoneWire.SOUTH, this.getAttachPosition(lllllllllllIlllIlIlIIIllIIIIIllI, lllllllllllIlllIlIlIIIllIIIIIIIl, EnumFacing.SOUTH));
        return lllllllllllIlllIlIlIIIllIIIIIIll;
    }
    
    enum EnumAttachPosition implements IStringSerializable
    {
        NONE("NONE", 2, "none");
        
        private final /* synthetic */ String name;
        
        UP("UP", 0, "up"), 
        SIDE("SIDE", 1, "side");
        
        private EnumAttachPosition(final String lllllllllllllllIlllIllllllllIlIl, final int lllllllllllllllIlllIllllllllIlII, final String lllllllllllllllIlllIllllllllIlll) {
            this.name = lllllllllllllllIlllIllllllllIlll;
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
