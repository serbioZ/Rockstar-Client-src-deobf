// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;

public class BlockRailPowered extends BlockRailBase
{
    public static final /* synthetic */ PropertyBool POWERED;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRailPowered.SHAPE;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIlllllllIlIlIIIIlI) {
        return this.getDefaultState().withProperty(BlockRailPowered.SHAPE, EnumRailDirection.byMetadata(llllllllllllIlIlllllllIlIlIIIIlI & 0x7)).withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, (llllllllllllIlIlllllllIlIlIIIIlI & 0x8) > 0);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIlIlllllllIlIIlIllII, final Mirror llllllllllllIlIlllllllIlIIlIlIll) {
        final EnumRailDirection llllllllllllIlIlllllllIlIIlIlIlI = llllllllllllIlIlllllllIlIIlIllII.getValue(BlockRailPowered.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIlIlllllllIlIIlIlIll.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIIlIlIlI.ordinal()]) {
                        case 5: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(llllllllllllIlIlllllllIlIIlIllII, llllllllllllIlIlllllllIlIIlIlIll);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIIlIlIlI.ordinal()]) {
                        case 3: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllIlIlllllllIlIIlIllII.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(llllllllllllIlIlllllllIlIIlIllII, llllllllllllIlIlllllllIlIIlIlIll);
    }
    
    protected boolean findPoweredRailSignal(final World llllllllllllIlIlllllllIlIllllIll, final BlockPos llllllllllllIlIlllllllIllIIIIlIl, final IBlockState llllllllllllIlIlllllllIlIllllIIl, final boolean llllllllllllIlIlllllllIllIIIIIll, final int llllllllllllIlIlllllllIlIlllIlll) {
        if (llllllllllllIlIlllllllIlIlllIlll >= 8) {
            return false;
        }
        int llllllllllllIlIlllllllIllIIIIIIl = llllllllllllIlIlllllllIllIIIIlIl.getX();
        int llllllllllllIlIlllllllIllIIIIIII = llllllllllllIlIlllllllIllIIIIlIl.getY();
        int llllllllllllIlIlllllllIlIlllllll = llllllllllllIlIlllllllIllIIIIlIl.getZ();
        boolean llllllllllllIlIlllllllIlIllllllI = true;
        EnumRailDirection llllllllllllIlIlllllllIlIlllllIl = llllllllllllIlIlllllllIlIllllIIl.getValue(BlockRailPowered.SHAPE);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIlllllIl.ordinal()]) {
            case 1: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    ++llllllllllllIlIlllllllIlIlllllll;
                    break;
                }
                --llllllllllllIlIlllllllIlIlllllll;
                break;
            }
            case 2: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    --llllllllllllIlIlllllllIllIIIIIIl;
                    break;
                }
                ++llllllllllllIlIlllllllIllIIIIIIl;
                break;
            }
            case 3: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    --llllllllllllIlIlllllllIllIIIIIIl;
                }
                else {
                    ++llllllllllllIlIlllllllIllIIIIIIl;
                    ++llllllllllllIlIlllllllIllIIIIIII;
                    llllllllllllIlIlllllllIlIllllllI = false;
                }
                llllllllllllIlIlllllllIlIlllllIl = EnumRailDirection.EAST_WEST;
                break;
            }
            case 4: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    --llllllllllllIlIlllllllIllIIIIIIl;
                    ++llllllllllllIlIlllllllIllIIIIIII;
                    llllllllllllIlIlllllllIlIllllllI = false;
                }
                else {
                    ++llllllllllllIlIlllllllIllIIIIIIl;
                }
                llllllllllllIlIlllllllIlIlllllIl = EnumRailDirection.EAST_WEST;
                break;
            }
            case 5: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    ++llllllllllllIlIlllllllIlIlllllll;
                }
                else {
                    --llllllllllllIlIlllllllIlIlllllll;
                    ++llllllllllllIlIlllllllIllIIIIIII;
                    llllllllllllIlIlllllllIlIllllllI = false;
                }
                llllllllllllIlIlllllllIlIlllllIl = EnumRailDirection.NORTH_SOUTH;
                break;
            }
            case 6: {
                if (llllllllllllIlIlllllllIllIIIIIll) {
                    ++llllllllllllIlIlllllllIlIlllllll;
                    ++llllllllllllIlIlllllllIllIIIIIII;
                    llllllllllllIlIlllllllIlIllllllI = false;
                }
                else {
                    --llllllllllllIlIlllllllIlIlllllll;
                }
                llllllllllllIlIlllllllIlIlllllIl = EnumRailDirection.NORTH_SOUTH;
                break;
            }
        }
        return this.isSameRailWithPower(llllllllllllIlIlllllllIlIllllIll, new BlockPos(llllllllllllIlIlllllllIllIIIIIIl, llllllllllllIlIlllllllIllIIIIIII, llllllllllllIlIlllllllIlIlllllll), llllllllllllIlIlllllllIllIIIIIll, llllllllllllIlIlllllllIlIlllIlll, llllllllllllIlIlllllllIlIlllllIl) || (llllllllllllIlIlllllllIlIllllllI && this.isSameRailWithPower(llllllllllllIlIlllllllIlIllllIll, new BlockPos(llllllllllllIlIlllllllIllIIIIIIl, llllllllllllIlIlllllllIllIIIIIII - 1, llllllllllllIlIlllllllIlIlllllll), llllllllllllIlIlllllllIllIIIIIll, llllllllllllIlIlllllllIlIlllIlll, llllllllllllIlIlllllllIlIlllllIl));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final Exception llllllllllllIlIlllllllIlIIIlllll = (Object)new int[Rotation.values().length];
        try {
            llllllllllllIlIlllllllIlIIIlllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIlllllllIlIIIlllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIlllllllIlIIIlllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIlllllllIlIIIlllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllIlIlllllllIlIIIlllll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRailPowered.SHAPE, BlockRailPowered.POWERED });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIlllllllIlIIllllII) {
        int llllllllllllIlIlllllllIlIIlllIll = 0;
        llllllllllllIlIlllllllIlIIlllIll |= llllllllllllIlIlllllllIlIIllllII.getValue(BlockRailPowered.SHAPE).getMetadata();
        if (llllllllllllIlIlllllllIlIIllllII.getValue((IProperty<Boolean>)BlockRailPowered.POWERED)) {
            llllllllllllIlIlllllllIlIIlllIll |= 0x8;
        }
        return llllllllllllIlIlllllllIlIIlllIll;
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class, (com.google.common.base.Predicate<EnumRailDirection>)new Predicate<EnumRailDirection>() {
            public boolean apply(@Nullable final EnumRailDirection llllllllllllIIlIIlIIIlIIllIllIII) {
                return llllllllllllIIlIIlIIIlIIllIllIII != EnumRailDirection.NORTH_EAST && llllllllllllIIlIIlIIIlIIllIllIII != EnumRailDirection.NORTH_WEST && llllllllllllIIlIIlIIIlIIllIllIII != EnumRailDirection.SOUTH_EAST && llllllllllllIIlIIlIIIlIIllIllIII != EnumRailDirection.SOUTH_WEST;
            }
        });
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    protected void updateState(final IBlockState llllllllllllIlIlllllllIlIlIlIIlI, final World llllllllllllIlIlllllllIlIlIIlIlI, final BlockPos llllllllllllIlIlllllllIlIlIlIIII, final Block llllllllllllIlIlllllllIlIlIIllll) {
        final boolean llllllllllllIlIlllllllIlIlIIlllI = llllllllllllIlIlllllllIlIlIlIIlI.getValue((IProperty<Boolean>)BlockRailPowered.POWERED);
        final boolean llllllllllllIlIlllllllIlIlIIllIl = llllllllllllIlIlllllllIlIlIIlIlI.isBlockPowered(llllllllllllIlIlllllllIlIlIlIIII) || this.findPoweredRailSignal(llllllllllllIlIlllllllIlIlIIlIlI, llllllllllllIlIlllllllIlIlIlIIII, llllllllllllIlIlllllllIlIlIlIIlI, true, 0) || this.findPoweredRailSignal(llllllllllllIlIlllllllIlIlIIlIlI, llllllllllllIlIlllllllIlIlIlIIII, llllllllllllIlIlllllllIlIlIlIIlI, false, 0);
        if (llllllllllllIlIlllllllIlIlIIllIl != llllllllllllIlIlllllllIlIlIIlllI) {
            llllllllllllIlIlllllllIlIlIIlIlI.setBlockState(llllllllllllIlIlllllllIlIlIlIIII, llllllllllllIlIlllllllIlIlIlIIlI.withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, llllllllllllIlIlllllllIlIlIIllIl), 3);
            llllllllllllIlIlllllllIlIlIIlIlI.notifyNeighborsOfStateChange(llllllllllllIlIlllllllIlIlIlIIII.down(), this, false);
            if (llllllllllllIlIlllllllIlIlIlIIlI.getValue(BlockRailPowered.SHAPE).isAscending()) {
                llllllllllllIlIlllllllIlIlIIlIlI.notifyNeighborsOfStateChange(llllllllllllIlIlllllllIlIlIlIIII.up(), this, false);
            }
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIlIlllllllIlIIllIlIl, final Rotation llllllllllllIlIlllllllIlIIllIIlI) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIlIlllllllIlIIllIIlI.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIIllIlIl.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIIllIlIl.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 1: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        case 3: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllIlIlllllllIlIIllIlIl.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 1: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        case 3: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllIlIlllllllIlIIllIlIl.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return llllllllllllIlIlllllllIlIIllIlIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRailPowered.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final char llllllllllllIlIlllllllIlIIlIIIIl = (Object)new int[EnumRailDirection.values().length];
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllIlIlllllllIlIIlIIIIl[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)llllllllllllIlIlllllllIlIIlIIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final String llllllllllllIlIlllllllIlIIIlllIl = (Object)new int[Mirror.values().length];
        try {
            llllllllllllIlIlllllllIlIIIlllIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIlllllllIlIIIlllIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIlllllllIlIIIlllIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllIlIlllllllIlIIIlllIl;
    }
    
    protected boolean isSameRailWithPower(final World llllllllllllIlIlllllllIlIllIlIII, final BlockPos llllllllllllIlIlllllllIlIlIlllll, final boolean llllllllllllIlIlllllllIlIllIIllI, final int llllllllllllIlIlllllllIlIlIlllIl, final EnumRailDirection llllllllllllIlIlllllllIlIllIIlII) {
        final IBlockState llllllllllllIlIlllllllIlIllIIIll = llllllllllllIlIlllllllIlIllIlIII.getBlockState(llllllllllllIlIlllllllIlIlIlllll);
        if (llllllllllllIlIlllllllIlIllIIIll.getBlock() != this) {
            return false;
        }
        final EnumRailDirection llllllllllllIlIlllllllIlIllIIIlI = llllllllllllIlIlllllllIlIllIIIll.getValue(BlockRailPowered.SHAPE);
        return (llllllllllllIlIlllllllIlIllIIlII != EnumRailDirection.EAST_WEST || (llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.NORTH_SOUTH && llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.ASCENDING_NORTH && llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.ASCENDING_SOUTH)) && (llllllllllllIlIlllllllIlIllIIlII != EnumRailDirection.NORTH_SOUTH || (llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.EAST_WEST && llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.ASCENDING_EAST && llllllllllllIlIlllllllIlIllIIIlI != EnumRailDirection.ASCENDING_WEST)) && llllllllllllIlIlllllllIlIllIIIll.getValue((IProperty<Boolean>)BlockRailPowered.POWERED) && (llllllllllllIlIlllllllIlIllIlIII.isBlockPowered(llllllllllllIlIlllllllIlIlIlllll) || this.findPoweredRailSignal(llllllllllllIlIlllllllIlIllIlIII, llllllllllllIlIlllllllIlIlIlllll, llllllllllllIlIlllllllIlIllIIIll, llllllllllllIlIlllllllIlIllIIllI, llllllllllllIlIlllllllIlIlIlllIl + 1));
    }
    
    protected BlockRailPowered() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH).withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, false));
    }
}
