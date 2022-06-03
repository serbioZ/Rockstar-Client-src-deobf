// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.Vec3i;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EntitySelectors;
import net.minecraft.entity.item.EntityMinecart;
import com.google.common.base.Predicate;
import net.minecraft.entity.item.EntityMinecartCommandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Mirror;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;

public class BlockRailDetector extends BlockRailBase
{
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    
    @Override
    public int tickRate(final World lllllllllllllIllllIIllIllIIIlIll) {
        return 20;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllllIIllIIlllIIIII, final Rotation lllllllllllllIllllIIllIIlllIIIIl) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIllllIIllIIlllIIIIl.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIllIIlllIIIII.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIllIIlllIIIII.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 1: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIllIIlllIIIII.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 1: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return lllllllllllllIllllIIllIIlllIIIII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllllIllllIIllIIlllIIIII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final String lllllllllllllIllllIIllIIllIIlIlI = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIllllIIllIIllIIlIlI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIllIIllIIlIlI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIllIIllIIlIlI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIllllIIllIIllIIlIlI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllllIllllIIllIIllIIllII = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIllllIIllIIllIIllII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIllIIllIIllII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIllIIllIIllII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIllIIllIIllII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIllllIIllIIllIIllII;
    }
    
    private AxisAlignedBB getDectectionBox(final BlockPos lllllllllllllIllllIIllIIllllIllI) {
        final float lllllllllllllIllllIIllIIllllIlIl = 0.2f;
        return new AxisAlignedBB(lllllllllllllIllllIIllIIllllIllI.getX() + 0.2f, lllllllllllllIllllIIllIIllllIllI.getY(), lllllllllllllIllllIIllIIllllIllI.getZ() + 0.2f, lllllllllllllIllllIIllIIllllIllI.getX() + 1 - 0.2f, lllllllllllllIllllIIllIIllllIllI.getY() + 1 - 0.2f, lllllllllllllIllllIIllIIllllIllI.getZ() + 1 - 0.2f);
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIllllIIllIlIlIlllll, final IBlockAccess lllllllllllllIllllIIllIlIlIllllI, final BlockPos lllllllllllllIllllIIllIlIlIlllIl, final EnumFacing lllllllllllllIllllIIllIlIlIllIlI) {
        if (!lllllllllllllIllllIIllIlIlIlllll.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            return 0;
        }
        return (lllllllllllllIllllIIllIlIlIllIlI == EnumFacing.UP) ? 15 : 0;
    }
    
    protected void updateConnectedRails(final World lllllllllllllIllllIIllIlIIlllIll, final BlockPos lllllllllllllIllllIIllIlIIllIIlI, final IBlockState lllllllllllllIllllIIllIlIIllIIIl, final boolean lllllllllllllIllllIIllIlIIlllIII) {
        final Rail lllllllllllllIllllIIllIlIIllIlll = new Rail(lllllllllllllIllllIIllIlIIlllIll, lllllllllllllIllllIIllIlIIllIIlI, lllllllllllllIllllIIllIlIIllIIIl);
        for (final BlockPos lllllllllllllIllllIIllIlIIllIllI : lllllllllllllIllllIIllIlIIllIlll.getConnectedRails()) {
            final IBlockState lllllllllllllIllllIIllIlIIllIlIl = lllllllllllllIllllIIllIlIIlllIll.getBlockState(lllllllllllllIllllIIllIlIIllIllI);
            if (lllllllllllllIllllIIllIlIIllIlIl != null) {
                lllllllllllllIllllIIllIlIIllIlIl.neighborChanged(lllllllllllllIllllIIllIlIIlllIll, lllllllllllllIllllIIllIlIIllIllI, lllllllllllllIllllIIllIlIIllIlIl.getBlock(), lllllllllllllIllllIIllIlIIllIIlI);
            }
        }
    }
    
    public BlockRailDetector() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, false).withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH));
        this.setTickRandomly(true);
    }
    
    @Override
    public void updateTick(final World lllllllllllllIllllIIllIlIllIllII, final BlockPos lllllllllllllIllllIIllIlIllIlIll, final IBlockState lllllllllllllIllllIIllIlIllIlIlI, final Random lllllllllllllIllllIIllIlIllIlllI) {
        if (!lllllllllllllIllllIIllIlIllIllII.isRemote && lllllllllllllIllllIIllIlIllIlIlI.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            this.updatePoweredState(lllllllllllllIllllIIllIlIllIllII, lllllllllllllIllllIIllIlIllIlIll, lllllllllllllIllllIIllIlIllIlIlI);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIIllIIlllIllIl) {
        return this.getDefaultState().withProperty(BlockRailDetector.SHAPE, EnumRailDirection.byMetadata(lllllllllllllIllllIIllIIlllIllIl & 0x7)).withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, (lllllllllllllIllllIIllIIlllIllIl & 0x8) > 0);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIllllIIllIlIIIllllI) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRailDetector.SHAPE, BlockRailDetector.POWERED });
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIllllIIllIlIllllllI, final BlockPos lllllllllllllIllllIIllIlIlllllIl, final IBlockState lllllllllllllIllllIIllIllIIIIIIl, final Entity lllllllllllllIllllIIllIllIIIIIII) {
        if (!lllllllllllllIllllIIllIlIllllllI.isRemote && !lllllllllllllIllllIIllIllIIIIIIl.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            this.updatePoweredState(lllllllllllllIllllIIllIlIllllllI, lllllllllllllIllllIIllIlIlllllIl, lllllllllllllIllllIIllIllIIIIIIl);
        }
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIllllIIllIlIIIlIllI, final World lllllllllllllIllllIIllIlIIIlIlIl, final BlockPos lllllllllllllIllllIIllIlIIIlIlII) {
        if (lllllllllllllIllllIIllIlIIIlIllI.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            final List<EntityMinecartCommandBlock> lllllllllllllIllllIIllIlIIIlIIll = this.findMinecarts(lllllllllllllIllllIIllIlIIIlIlIl, lllllllllllllIllllIIllIlIIIlIlII, EntityMinecartCommandBlock.class, (Predicate<Entity>[])new Predicate[0]);
            if (!lllllllllllllIllllIIllIlIIIlIIll.isEmpty()) {
                return lllllllllllllIllllIIllIlIIIlIIll.get(0).getCommandBlockLogic().getSuccessCount();
            }
            final List<EntityMinecart> lllllllllllllIllllIIllIlIIIlIIlI = this.findMinecarts(lllllllllllllIllllIIllIlIIIlIlIl, lllllllllllllIllllIIllIlIIIlIlII, EntityMinecart.class, EntitySelectors.HAS_INVENTORY);
            if (!lllllllllllllIllllIIllIlIIIlIIlI.isEmpty()) {
                return Container.calcRedstoneFromInventory((IInventory)lllllllllllllIllllIIllIlIIIlIIlI.get(0));
            }
        }
        return 0;
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class, (com.google.common.base.Predicate<EnumRailDirection>)new Predicate<EnumRailDirection>() {
            public boolean apply(@Nullable final EnumRailDirection lllllllllllllIIllIIIIIIllllIIIll) {
                return lllllllllllllIIllIIIIIIllllIIIll != EnumRailDirection.NORTH_EAST && lllllllllllllIIllIIIIIIllllIIIll != EnumRailDirection.NORTH_WEST && lllllllllllllIIllIIIIIIllllIIIll != EnumRailDirection.SOUTH_EAST && lllllllllllllIIllIIIIIIllllIIIll != EnumRailDirection.SOUTH_WEST;
            }
        });
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public void randomTick(final World lllllllllllllIllllIIllIlIllllIlI, final BlockPos lllllllllllllIllllIIllIlIllllIIl, final IBlockState lllllllllllllIllllIIllIlIllllIII, final Random lllllllllllllIllllIIllIlIlllIlll) {
    }
    
    protected <T extends EntityMinecart> List<T> findMinecarts(final World lllllllllllllIllllIIllIIlllllllI, final BlockPos lllllllllllllIllllIIllIIllllllIl, final Class<T> lllllllllllllIllllIIllIlIIIIIIlI, final Predicate<Entity>... lllllllllllllIllllIIllIlIIIIIIIl) {
        final AxisAlignedBB lllllllllllllIllllIIllIlIIIIIIII = this.getDectectionBox(lllllllllllllIllllIIllIIllllllIl);
        return (lllllllllllllIllllIIllIlIIIIIIIl.length != 1) ? lllllllllllllIllllIIllIIlllllllI.getEntitiesWithinAABB((Class<? extends T>)lllllllllllllIllllIIllIlIIIIIIlI, lllllllllllllIllllIIllIlIIIIIIII) : lllllllllllllIllllIIllIIlllllllI.getEntitiesWithinAABB((Class<? extends T>)lllllllllllllIllllIIllIlIIIIIIlI, lllllllllllllIllllIIllIlIIIIIIII, (com.google.common.base.Predicate<? super T>)lllllllllllllIllllIIllIlIIIIIIIl[0]);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRailDetector.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final boolean lllllllllllllIllllIIllIIllIIlllI = (Object)new int[EnumRailDirection.values().length];
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllIllllIIllIIllIIlllI[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)lllllllllllllIllllIIllIIllIIlllI;
    }
    
    private void updatePoweredState(final World lllllllllllllIllllIIllIlIlIIlIlI, final BlockPos lllllllllllllIllllIIllIlIlIIlIIl, final IBlockState lllllllllllllIllllIIllIlIlIIlIII) {
        final boolean lllllllllllllIllllIIllIlIlIIlllI = lllllllllllllIllllIIllIlIlIIlIII.getValue((IProperty<Boolean>)BlockRailDetector.POWERED);
        boolean lllllllllllllIllllIIllIlIlIIllIl = false;
        final List<EntityMinecart> lllllllllllllIllllIIllIlIlIIllII = this.findMinecarts(lllllllllllllIllllIIllIlIlIIlIlI, lllllllllllllIllllIIllIlIlIIlIIl, EntityMinecart.class, (Predicate<Entity>[])new Predicate[0]);
        if (!lllllllllllllIllllIIllIlIlIIllII.isEmpty()) {
            lllllllllllllIllllIIllIlIlIIllIl = true;
        }
        if (lllllllllllllIllllIIllIlIlIIllIl && !lllllllllllllIllllIIllIlIlIIlllI) {
            lllllllllllllIllllIIllIlIlIIlIlI.setBlockState(lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIII.withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, true), 3);
            this.updateConnectedRails(lllllllllllllIllllIIllIlIlIIlIlI, lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIII, true);
            lllllllllllllIllllIIllIlIlIIlIlI.notifyNeighborsOfStateChange(lllllllllllllIllllIIllIlIlIIlIIl, this, false);
            lllllllllllllIllllIIllIlIlIIlIlI.notifyNeighborsOfStateChange(lllllllllllllIllllIIllIlIlIIlIIl.down(), this, false);
            lllllllllllllIllllIIllIlIlIIlIlI.markBlockRangeForRenderUpdate(lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIIl);
        }
        if (!lllllllllllllIllllIIllIlIlIIllIl && lllllllllllllIllllIIllIlIlIIlllI) {
            lllllllllllllIllllIIllIlIlIIlIlI.setBlockState(lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIII.withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, false), 3);
            this.updateConnectedRails(lllllllllllllIllllIIllIlIlIIlIlI, lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIII, false);
            lllllllllllllIllllIIllIlIlIIlIlI.notifyNeighborsOfStateChange(lllllllllllllIllllIIllIlIlIIlIIl, this, false);
            lllllllllllllIllllIIllIlIlIIlIlI.notifyNeighborsOfStateChange(lllllllllllllIllllIIllIlIlIIlIIl.down(), this, false);
            lllllllllllllIllllIIllIlIlIIlIlI.markBlockRangeForRenderUpdate(lllllllllllllIllllIIllIlIlIIlIIl, lllllllllllllIllllIIllIlIlIIlIIl);
        }
        if (lllllllllllllIllllIIllIlIlIIllIl) {
            lllllllllllllIllllIIllIlIlIIlIlI.scheduleUpdate(new BlockPos(lllllllllllllIllllIIllIlIlIIlIIl), this, this.tickRate(lllllllllllllIllllIIllIlIlIIlIlI));
        }
        lllllllllllllIllllIIllIlIlIIlIlI.updateComparatorOutputLevel(lllllllllllllIllllIIllIlIlIIlIIl, this);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIIllIIlllIlIIl) {
        int lllllllllllllIllllIIllIIlllIlIII = 0;
        lllllllllllllIllllIIllIIlllIlIII |= lllllllllllllIllllIIllIIlllIlIIl.getValue(BlockRailDetector.SHAPE).getMetadata();
        if (lllllllllllllIllllIIllIIlllIlIIl.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            lllllllllllllIllllIIllIIlllIlIII |= 0x8;
        }
        return lllllllllllllIllllIIllIIlllIlIII;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIllllIIllIIllIlIlIl, final Mirror lllllllllllllIllllIIllIIllIllIII) {
        final EnumRailDirection lllllllllllllIllllIIllIIllIlIlll = lllllllllllllIllllIIllIIllIlIlIl.getValue(BlockRailDetector.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIllllIIllIIllIllIII.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIllIIllIlIlll.ordinal()]) {
                        case 5: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(lllllllllllllIllllIIllIIllIlIlIl, lllllllllllllIllllIIllIIllIllIII);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIllIIllIlIlll.ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIllIIllIlIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllllIllllIIllIIllIlIlIl, lllllllllllllIllllIIllIIllIllIII);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllllIIllIlIIlIIlll, final BlockPos lllllllllllllIllllIIllIlIIlIIllI, final IBlockState lllllllllllllIllllIIllIlIIlIIlIl) {
        super.onBlockAdded(lllllllllllllIllllIIllIlIIlIIlll, lllllllllllllIllllIIllIlIIlIIllI, lllllllllllllIllllIIllIlIIlIIlIl);
        this.updatePoweredState(lllllllllllllIllllIIllIlIIlIIlll, lllllllllllllIllllIIllIlIIlIIllI, lllllllllllllIllllIIllIlIIlIIlIl);
    }
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRailDetector.SHAPE;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIllllIIllIlIllIIlll, final IBlockAccess lllllllllllllIllllIIllIlIllIIllI, final BlockPos lllllllllllllIllllIIllIlIllIIlIl, final EnumFacing lllllllllllllIllllIIllIlIllIIlII) {
        return lllllllllllllIllllIIllIlIllIIlll.getValue((IProperty<Boolean>)BlockRailDetector.POWERED) ? 15 : 0;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIllllIIllIllIIIlIIl) {
        return true;
    }
}
