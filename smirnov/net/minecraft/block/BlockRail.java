// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public class BlockRail extends BlockRailBase
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIIIlIIIIIIllIIlI, final Rotation llllllllllllllllIIIlIIIIIIllIIIl) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIIIlIIIIIIllIIIl.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIIIIIIllIIlI.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIIIIIIllIIlI.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 1: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIIIIIIllIIlI.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 1: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIlIIIIIIllIIlI.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return llllllllllllllllIIIlIIIIIIllIIlI;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIIIlIIIIIIllllII) {
        return this.getDefaultState().withProperty(BlockRail.SHAPE, EnumRailDirection.byMetadata(llllllllllllllllIIIlIIIIIIllllII));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRail.SHAPE });
    }
    
    protected BlockRail() {
        super(false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH));
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final char llllllllllllllllIIIlIIIIIIIllllI = (Object)new int[EnumRailDirection.values().length];
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllllIIIlIIIIIIIllllI[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)llllllllllllllllIIIlIIIIIIIllllI;
    }
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRail.SHAPE;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRail.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final Exception llllllllllllllllIIIlIIIIIIIlllII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIIIlIIIIIIIlllII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIIIIIIIlllII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIIIIIIIlllII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIlIIIIIIIlllII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIIIlIIIIIIIlllII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIIIlIIIIIIllIllI) {
        return llllllllllllllllIIIlIIIIIIllIllI.getValue(BlockRail.SHAPE).getMetadata();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRail.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception llllllllllllllllIIIlIIIIIIIllIlI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllllIIIlIIIIIIIllIlI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIIIIIIIllIlI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIIIIIIIllIlI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllllIIIlIIIIIIIllIlI;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllllIIIlIIIIIIlIIlIl, final Mirror llllllllllllllllIIIlIIIIIIlIIlII) {
        final EnumRailDirection llllllllllllllllIIIlIIIIIIlIIlll = llllllllllllllllIIIlIIIIIIlIIlIl.getValue(BlockRail.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllllIIIlIIIIIIlIIlII.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIIIIIIlIIlll.ordinal()]) {
                        case 5: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(llllllllllllllllIIIlIIIIIIlIIlIl, llllllllllllllllIIIlIIIIIIlIIlII);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIIIIIIlIIlll.ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIIIIIIlIIlIl.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(llllllllllllllllIIIlIIIIIIlIIlIl, llllllllllllllllIIIlIIIIIIlIIlII);
    }
    
    @Override
    protected void updateState(final IBlockState llllllllllllllllIIIlIIIIIlIIlIIl, final World llllllllllllllllIIIlIIIIIlIIIIll, final BlockPos llllllllllllllllIIIlIIIIIlIIIlll, final Block llllllllllllllllIIIlIIIIIlIIIllI) {
        if (llllllllllllllllIIIlIIIIIlIIIllI.getDefaultState().canProvidePower() && new Rail(llllllllllllllllIIIlIIIIIlIIIIll, llllllllllllllllIIIlIIIIIlIIIlll, llllllllllllllllIIIlIIIIIlIIlIIl).countAdjacentRails() == 3) {
            this.updateDir(llllllllllllllllIIIlIIIIIlIIIIll, llllllllllllllllIIIlIIIIIlIIIlll, llllllllllllllllIIIlIIIIIlIIlIIl, false);
        }
    }
}
