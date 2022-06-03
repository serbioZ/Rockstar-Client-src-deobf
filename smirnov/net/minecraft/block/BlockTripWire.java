// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.Rotation;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Mirror;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.BlockStateContainer;
import java.util.List;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockTripWire extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool POWERED;
    protected static final /* synthetic */ AxisAlignedBB AABB;
    public static final /* synthetic */ PropertyBool DISARMED;
    public static final /* synthetic */ PropertyBool NORTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    protected static final /* synthetic */ AxisAlignedBB TRIP_WRITE_ATTACHED_AABB;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool ATTACHED;
    public static final /* synthetic */ PropertyBool WEST;
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIIIIIIIlIlllllIIIllI, final IBlockAccess llllllllllllIIIIIIIlIlllllIIIlIl, final BlockPos llllllllllllIIIIIIIlIlllllIIIlII) {
        return BlockTripWire.NULL_AABB;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIIIIIIlIlllIIIlllIl) {
        int llllllllllllIIIIIIIlIlllIIIllllI = 0;
        if (llllllllllllIIIIIIIlIlllIIIlllIl.getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            llllllllllllIIIIIIIlIlllIIIllllI |= 0x1;
        }
        if (llllllllllllIIIIIIIlIlllIIIlllIl.getValue((IProperty<Boolean>)BlockTripWire.ATTACHED)) {
            llllllllllllIIIIIIIlIlllIIIllllI |= 0x4;
        }
        if (llllllllllllIIIIIIIlIlllIIIlllIl.getValue((IProperty<Boolean>)BlockTripWire.DISARMED)) {
            llllllllllllIIIIIIIlIlllIIIllllI |= 0x8;
        }
        return llllllllllllIIIIIIIlIlllIIIllllI;
    }
    
    public BlockTripWire() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTripWire.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, false).withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, false).withProperty((IProperty<Comparable>)BlockTripWire.NORTH, false).withProperty((IProperty<Comparable>)BlockTripWire.EAST, false).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, false).withProperty((IProperty<Comparable>)BlockTripWire.WEST, false));
        this.setTickRandomly(true);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllIIIIIIIlIlllIlllIIII, final BlockPos llllllllllllIIIIIIIlIlllIllIllll, final IBlockState llllllllllllIIIIIIIlIlllIllIlIIl, final Entity llllllllllllIIIIIIIlIlllIllIllIl) {
        if (!llllllllllllIIIIIIIlIlllIlllIIII.isRemote && !llllllllllllIIIIIIIlIlllIllIlIIl.getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            this.updateState(llllllllllllIIIIIIIlIlllIlllIIII, llllllllllllIIIIIIIlIlllIllIllll);
        }
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllIIIIIIIlIlllllIIlIlI, final IBlockAccess llllllllllllIIIIIIIlIlllllIIlIIl, final BlockPos llllllllllllIIIIIIIlIlllllIIlIII) {
        return llllllllllllIIIIIIIlIlllllIIlIlI.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, isConnectedTo(llllllllllllIIIIIIIlIlllllIIlIIl, llllllllllllIIIIIIIlIlllllIIlIII, llllllllllllIIIIIIIlIlllllIIlIlI, EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, isConnectedTo(llllllllllllIIIIIIIlIlllllIIlIIl, llllllllllllIIIIIIIlIlllllIIlIII, llllllllllllIIIIIIIlIlllllIIlIlI, EnumFacing.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, isConnectedTo(llllllllllllIIIIIIIlIlllllIIlIIl, llllllllllllIIIIIIIlIlllllIIlIII, llllllllllllIIIIIIIlIlllllIIlIlI, EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, isConnectedTo(llllllllllllIIIIIIIlIlllllIIlIIl, llllllllllllIIIIIIIlIlllllIIlIII, llllllllllllIIIIIIIlIlllllIIlIlI, EnumFacing.WEST));
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIIIIIIIlIlllllIIIIII) {
        return false;
    }
    
    private void updateState(final World llllllllllllIIIIIIIlIlllIlIIIllI, final BlockPos llllllllllllIIIIIIIlIlllIlIIIlIl) {
        IBlockState llllllllllllIIIIIIIlIlllIlIIllII = llllllllllllIIIIIIIlIlllIlIIIllI.getBlockState(llllllllllllIIIIIIIlIlllIlIIIlIl);
        final boolean llllllllllllIIIIIIIlIlllIlIIlIll = llllllllllllIIIIIIIlIlllIlIIllII.getValue((IProperty<Boolean>)BlockTripWire.POWERED);
        boolean llllllllllllIIIIIIIlIlllIlIIlIlI = false;
        final List<? extends Entity> llllllllllllIIIIIIIlIlllIlIIlIIl = llllllllllllIIIIIIIlIlllIlIIIllI.getEntitiesWithinAABBExcludingEntity(null, llllllllllllIIIIIIIlIlllIlIIllII.getBoundingBox(llllllllllllIIIIIIIlIlllIlIIIllI, llllllllllllIIIIIIIlIlllIlIIIlIl).offset(llllllllllllIIIIIIIlIlllIlIIIlIl));
        if (!llllllllllllIIIIIIIlIlllIlIIlIIl.isEmpty()) {
            for (final Entity llllllllllllIIIIIIIlIlllIlIIlIII : llllllllllllIIIIIIIlIlllIlIIlIIl) {
                if (!llllllllllllIIIIIIIlIlllIlIIlIII.doesEntityNotTriggerPressurePlate()) {
                    llllllllllllIIIIIIIlIlllIlIIlIlI = true;
                    break;
                }
            }
        }
        if (llllllllllllIIIIIIIlIlllIlIIlIlI != llllllllllllIIIIIIIlIlllIlIIlIll) {
            llllllllllllIIIIIIIlIlllIlIIllII = llllllllllllIIIIIIIlIlllIlIIllII.withProperty((IProperty<Comparable>)BlockTripWire.POWERED, llllllllllllIIIIIIIlIlllIlIIlIlI);
            llllllllllllIIIIIIIlIlllIlIIIllI.setBlockState(llllllllllllIIIIIIIlIlllIlIIIlIl, llllllllllllIIIIIIIlIlllIlIIllII, 3);
            this.notifyHook(llllllllllllIIIIIIIlIlllIlIIIllI, llllllllllllIIIIIIIlIlllIlIIIlIl, llllllllllllIIIIIIIlIlllIlIIllII);
        }
        if (llllllllllllIIIIIIIlIlllIlIIlIlI) {
            llllllllllllIIIIIIIlIlllIlIIIllI.scheduleUpdate(new BlockPos(llllllllllllIIIIIIIlIlllIlIIIlIl), this, this.tickRate(llllllllllllIIIIIIIlIlllIlIIIllI));
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIIIIIIlIllllIlIIIIl, final BlockPos llllllllllllIIIIIIIlIllllIlIIlII, final IBlockState llllllllllllIIIIIIIlIllllIlIIIll) {
        this.notifyHook(llllllllllllIIIIIIIlIllllIlIIIIl, llllllllllllIIIIIIIlIllllIlIIlII, llllllllllllIIIIIIIlIllllIlIIIll.withProperty((IProperty<Comparable>)BlockTripWire.POWERED, true));
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        ATTACHED = PropertyBool.create("attached");
        DISARMED = PropertyBool.create("disarmed");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        AABB = new AxisAlignedBB(0.0, 0.0625, 0.0, 1.0, 0.15625, 1.0);
        TRIP_WRITE_ATTACHED_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTripWire.POWERED, BlockTripWire.ATTACHED, BlockTripWire.DISARMED, BlockTripWire.NORTH, BlockTripWire.EAST, BlockTripWire.WEST, BlockTripWire.SOUTH });
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIIIIIIlIllllIlllIIl, final BlockPos llllllllllllIIIIIIIlIllllIlllIII, final IBlockState llllllllllllIIIIIIIlIllllIllIlll) {
        return new ItemStack(Items.STRING);
    }
    
    @Override
    public void updateTick(final World llllllllllllIIIIIIIlIlllIlIllIlI, final BlockPos llllllllllllIIIIIIIlIlllIlIllIIl, final IBlockState llllllllllllIIIIIIIlIlllIlIlllIl, final Random llllllllllllIIIIIIIlIlllIlIlllII) {
        if (!llllllllllllIIIIIIIlIlllIlIllIlI.isRemote && llllllllllllIIIIIIIlIlllIlIllIlI.getBlockState(llllllllllllIIIIIIIlIlllIlIllIIl).getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            this.updateState(llllllllllllIIIIIIIlIlllIlIllIlI, llllllllllllIIIIIIIlIlllIlIllIIl);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final char llllllllllllIIIIIIIlIlllIIIIIIII = (Object)new int[Mirror.values().length];
        try {
            llllllllllllIIIIIIIlIlllIIIIIIII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIIIIIlIlllIIIIIIII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIIIIIlIlllIIIIIIII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllIIIIIIIlIlllIIIIIIII;
    }
    
    @Override
    public void randomTick(final World llllllllllllIIIIIIIlIlllIllIIlll, final BlockPos llllllllllllIIIIIIIlIlllIllIIllI, final IBlockState llllllllllllIIIIIIIlIlllIllIIlIl, final Random llllllllllllIIIIIIIlIlllIllIIlII) {
    }
    
    @Override
    public void onBlockHarvested(final World llllllllllllIIIIIIIlIllllIIlIlIl, final BlockPos llllllllllllIIIIIIIlIllllIIllIII, final IBlockState llllllllllllIIIIIIIlIllllIIlIlll, final EntityPlayer llllllllllllIIIIIIIlIllllIIlIIlI) {
        if (!llllllllllllIIIIIIIlIllllIIlIlIl.isRemote && !llllllllllllIIIIIIIlIllllIIlIIlI.getHeldItemMainhand().func_190926_b() && llllllllllllIIIIIIIlIllllIIlIIlI.getHeldItemMainhand().getItem() == Items.SHEARS) {
            llllllllllllIIIIIIIlIllllIIlIlIl.setBlockState(llllllllllllIIIIIIIlIllllIIllIII, llllllllllllIIIIIIIlIllllIIlIlll.withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, true), 4);
        }
    }
    
    private void notifyHook(final World llllllllllllIIIIIIIlIlllIlllllll, final BlockPos llllllllllllIIIIIIIlIllllIIIIlIl, final IBlockState llllllllllllIIIIIIIlIllllIIIIlII) {
        final char llllllllllllIIIIIIIlIlllIllllIIl;
        final String llllllllllllIIIIIIIlIlllIllllIlI = (String)((EnumFacing[])(Object)(llllllllllllIIIIIIIlIlllIllllIIl = (char)(Object)new EnumFacing[] { EnumFacing.SOUTH, EnumFacing.WEST })).length;
        for (double llllllllllllIIIIIIIlIlllIllllIll = 0; llllllllllllIIIIIIIlIlllIllllIll < llllllllllllIIIIIIIlIlllIllllIlI; ++llllllllllllIIIIIIIlIlllIllllIll) {
            final EnumFacing llllllllllllIIIIIIIlIllllIIIIIll = llllllllllllIIIIIIIlIlllIllllIIl[llllllllllllIIIIIIIlIlllIllllIll];
            int llllllllllllIIIIIIIlIllllIIIIIlI = 1;
            while (llllllllllllIIIIIIIlIllllIIIIIlI < 42) {
                final BlockPos llllllllllllIIIIIIIlIllllIIIIIIl = llllllllllllIIIIIIIlIllllIIIIlIl.offset(llllllllllllIIIIIIIlIllllIIIIIll, llllllllllllIIIIIIIlIllllIIIIIlI);
                final IBlockState llllllllllllIIIIIIIlIllllIIIIIII = llllllllllllIIIIIIIlIlllIlllllll.getBlockState(llllllllllllIIIIIIIlIllllIIIIIIl);
                if (llllllllllllIIIIIIIlIllllIIIIIII.getBlock() == Blocks.TRIPWIRE_HOOK) {
                    if (llllllllllllIIIIIIIlIllllIIIIIII.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == llllllllllllIIIIIIIlIllllIIIIIll.getOpposite()) {
                        Blocks.TRIPWIRE_HOOK.calculateState(llllllllllllIIIIIIIlIlllIlllllll, llllllllllllIIIIIIIlIllllIIIIIIl, llllllllllllIIIIIIIlIllllIIIIIII, false, true, llllllllllllIIIIIIIlIllllIIIIIlI, llllllllllllIIIIIIIlIllllIIIIlII);
                        break;
                    }
                    break;
                }
                else {
                    if (llllllllllllIIIIIIIlIllllIIIIIII.getBlock() != Blocks.TRIPWIRE) {
                        break;
                    }
                    ++llllllllllllIIIIIIIlIllllIIIIIlI;
                }
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIIIIIIlIlllIIlIIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.POWERED, (llllllllllllIIIIIIIlIlllIIlIIlIl & 0x1) > 0).withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, (llllllllllllIIIIIIIlIlllIIlIIlIl & 0x4) > 0).withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, (llllllllllllIIIIIIIlIlllIIlIIlIl & 0x8) > 0);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIIIIIIlIlllIIIllIII, final Rotation llllllllllllIIIIIIIlIlllIIIlIlIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIIIIIIlIlllIIIlIlIl.ordinal()]) {
            case 3: {
                return llllllllllllIIIIIIIlIlllIIIllIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.EAST));
            }
            case 4: {
                return llllllllllllIIIIIIIlIlllIIIllIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.NORTH));
            }
            case 2: {
                return llllllllllllIIIIIIIlIlllIIIllIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)llllllllllllIIIIIIIlIlllIIIllIII.getValue((IProperty<V>)BlockTripWire.SOUTH));
            }
            default: {
                return llllllllllllIIIIIIIlIlllIIIllIII;
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIIIIIIIlIlllIIIIIlll, final IBlockState llllllllllllIIIIIIIlIlllIIIIIllI, final BlockPos llllllllllllIIIIIIIlIlllIIIIIlIl, final EnumFacing llllllllllllIIIIIIIlIlllIIIIIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIIIIIIlIlllIIIIllIl, final Mirror llllllllllllIIIIIIIlIlllIIIIllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIIIIIIIlIlllIIIIllll.ordinal()]) {
            case 2: {
                return llllllllllllIIIIIIIlIlllIIIIllIl.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)llllllllllllIIIIIIIlIlllIIIIllIl.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)llllllllllllIIIIIIIlIlllIIIIllIl.getValue((IProperty<V>)BlockTripWire.NORTH));
            }
            case 3: {
                return llllllllllllIIIIIIIlIlllIIIIllIl.withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)llllllllllllIIIIIIIlIlllIIIIllIl.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)llllllllllllIIIIIIIlIlllIIIIllIl.getValue((IProperty<V>)BlockTripWire.EAST));
            }
            default: {
                return super.withMirror(llllllllllllIIIIIIIlIlllIIIIllIl, llllllllllllIIIIIIIlIlllIIIIllll);
            }
        }
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIIIIIIIlIllllIllIIIl, final BlockPos llllllllllllIIIIIIIlIllllIllIIII, final IBlockState llllllllllllIIIIIIIlIllllIlIlIll) {
        llllllllllllIIIIIIIlIllllIllIIIl.setBlockState(llllllllllllIIIIIIIlIllllIllIIII, llllllllllllIIIIIIIlIllllIlIlIll, 3);
        this.notifyHook(llllllllllllIIIIIIIlIllllIllIIIl, llllllllllllIIIIIIIlIllllIllIIII, llllllllllllIIIIIIIlIllllIlIlIll);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final long llllllllllllIIIIIIIlIlllIIIIIIlI = (Object)new int[Rotation.values().length];
        try {
            llllllllllllIIIIIIIlIlllIIIIIIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIIIIIlIlllIIIIIIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIIIIIlIlllIIIIIIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIIIIIIlIlllIIIIIIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllIIIIIIIlIlllIIIIIIlI;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIIIIIIlIlllllIIIIlI) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIIIIIIIlIlllllIlIlIl, final IBlockAccess llllllllllllIIIIIIIlIlllllIlIlII, final BlockPos llllllllllllIIIIIIIlIlllllIlIIll) {
        return llllllllllllIIIIIIIlIlllllIlIlIl.getValue((IProperty<Boolean>)BlockTripWire.ATTACHED) ? BlockTripWire.AABB : BlockTripWire.TRIP_WRITE_ATTACHED_AABB;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIIIIIIlIllllIllllIl, final Random llllllllllllIIIIIIIlIllllIllllII, final int llllllllllllIIIIIIIlIllllIlllIll) {
        return Items.STRING;
    }
    
    public static boolean isConnectedTo(final IBlockAccess llllllllllllIIIIIIIlIlllIIllIlll, final BlockPos llllllllllllIIIIIIIlIlllIIlIlllI, final IBlockState llllllllllllIIIIIIIlIlllIIllIlIl, final EnumFacing llllllllllllIIIIIIIlIlllIIllIlII) {
        final BlockPos llllllllllllIIIIIIIlIlllIIllIIll = llllllllllllIIIIIIIlIlllIIlIlllI.offset(llllllllllllIIIIIIIlIlllIIllIlII);
        final IBlockState llllllllllllIIIIIIIlIlllIIllIIlI = llllllllllllIIIIIIIlIlllIIllIlll.getBlockState(llllllllllllIIIIIIIlIlllIIllIIll);
        final Block llllllllllllIIIIIIIlIlllIIllIIIl = llllllllllllIIIIIIIlIlllIIllIIlI.getBlock();
        if (llllllllllllIIIIIIIlIlllIIllIIIl == Blocks.TRIPWIRE_HOOK) {
            final EnumFacing llllllllllllIIIIIIIlIlllIIllIIII = llllllllllllIIIIIIIlIlllIIllIlII.getOpposite();
            return llllllllllllIIIIIIIlIlllIIllIIlI.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == llllllllllllIIIIIIIlIlllIIllIIII;
        }
        return llllllllllllIIIIIIIlIlllIIllIIIl == Blocks.TRIPWIRE;
    }
}
