// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.Rotation;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockLog extends BlockRotatedPillar
{
    public static final /* synthetic */ PropertyEnum<EnumAxis> LOG_AXIS;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockLog.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final Exception lllllllllllIIlIIIIlllllIIIllIlll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIIlIIIIlllllIIIllIlll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIIIlllllIIIllIlll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIIIlllllIIIllIlll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIIIIlllllIIIllIlll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLog.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIIlIIIIlllllIIIllIlll;
    }
    
    public BlockLog() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(2.0f);
        this.setSoundType(SoundType.WOOD);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final long lllllllllllIIlIIIIlllllIIIlllIIl = (Object)new int[EnumAxis.values().length];
        try {
            lllllllllllIIlIIIIlllllIIIlllIIl[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIIIlllllIIIlllIIl[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIIIlllllIIIlllIIl[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIIIIlllllIIIlllIIl[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)lllllllllllIIlIIIIlllllIIIlllIIl;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlIIIIlllllIIIllllII, final Rotation lllllllllllIIlIIIIlllllIIIlllIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIIlIIIIlllllIIIlllIll.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[lllllllllllIIlIIIIlllllIIIllllII.getValue(BlockLog.LOG_AXIS).ordinal()]) {
                    case 1: {
                        return lllllllllllIIlIIIIlllllIIIllllII.withProperty(BlockLog.LOG_AXIS, EnumAxis.Z);
                    }
                    case 3: {
                        return lllllllllllIIlIIIIlllllIIIllllII.withProperty(BlockLog.LOG_AXIS, EnumAxis.X);
                    }
                    default: {
                        return lllllllllllIIlIIIIlllllIIIllllII;
                    }
                }
                break;
            }
            default: {
                return lllllllllllIIlIIIIlllllIIIllllII;
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlIIIIlllllIIlIIllII, final BlockPos lllllllllllIIlIIIIlllllIIlIIlIll, final EnumFacing lllllllllllIIlIIIIlllllIIlIIIIll, final float lllllllllllIIlIIIIlllllIIlIIlIIl, final float lllllllllllIIlIIIIlllllIIlIIlIII, final float lllllllllllIIlIIIIlllllIIlIIIlll, final int lllllllllllIIlIIIIlllllIIlIIIllI, final EntityLivingBase lllllllllllIIlIIIIlllllIIlIIIlIl) {
        return this.getStateFromMeta(lllllllllllIIlIIIIlllllIIlIIIllI).withProperty(BlockLog.LOG_AXIS, EnumAxis.fromFacingAxis(lllllllllllIIlIIIIlllllIIlIIIIll.getAxis()));
    }
    
    static {
        LOG_AXIS = PropertyEnum.create("axis", EnumAxis.class);
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIlIIIIlllllIIlIlIlll, final BlockPos lllllllllllIIlIIIIlllllIIlIlIllI, final IBlockState lllllllllllIIlIIIIlllllIIlIlllII) {
        final int lllllllllllIIlIIIIlllllIIlIllIll = 4;
        final int lllllllllllIIlIIIIlllllIIlIllIlI = 5;
        if (lllllllllllIIlIIIIlllllIIlIlIlll.isAreaLoaded(lllllllllllIIlIIIIlllllIIlIlIllI.add(-5, -5, -5), lllllllllllIIlIIIIlllllIIlIlIllI.add(5, 5, 5))) {
            for (final BlockPos lllllllllllIIlIIIIlllllIIlIllIIl : BlockPos.getAllInBox(lllllllllllIIlIIIIlllllIIlIlIllI.add(-4, -4, -4), lllllllllllIIlIIIIlllllIIlIlIllI.add(4, 4, 4))) {
                final IBlockState lllllllllllIIlIIIIlllllIIlIllIII = lllllllllllIIlIIIIlllllIIlIlIlll.getBlockState(lllllllllllIIlIIIIlllllIIlIllIIl);
                if (lllllllllllIIlIIIIlllllIIlIllIII.getMaterial() == Material.LEAVES && !lllllllllllIIlIIIIlllllIIlIllIII.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY)) {
                    lllllllllllIIlIIIIlllllIIlIlIlll.setBlockState(lllllllllllIIlIIIIlllllIIlIllIIl, lllllllllllIIlIIIIlllllIIlIllIII.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, true), 4);
                }
            }
        }
    }
    
    public enum EnumAxis implements IStringSerializable
    {
        X("X", 0, "x"), 
        Y("Y", 1, "y"), 
        NONE("NONE", 3, "none");
        
        private final /* synthetic */ String name;
        
        Z("Z", 2, "z");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumAxis(final String lllllllllllIIIIIIIllIIllIllIlIIl, final int lllllllllllIIIIIIIllIIllIllIlIII, final String lllllllllllIIIIIIIllIIllIllIIlll) {
            this.name = lllllllllllIIIIIIIllIIllIllIIlll;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = EnumAxis.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
            if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
            }
            final long lllllllllllIIIIIIIllIIllIlIlIlII = (Object)new int[EnumFacing.Axis.values().length];
            try {
                lllllllllllIIIIIIIllIIllIlIlIlII[EnumFacing.Axis.X.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIIIIIIIllIIllIlIlIlII[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIIIIIIIllIIllIlIlIlII[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            return EnumAxis.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIIIIIIIllIIllIlIlIlII;
        }
        
        public static EnumAxis fromFacingAxis(final EnumFacing.Axis lllllllllllIIIIIIIllIIllIllIIIlI) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIIIIIIIllIIllIllIIIlI.ordinal()]) {
                case 1: {
                    return EnumAxis.X;
                }
                case 2: {
                    return EnumAxis.Y;
                }
                case 3: {
                    return EnumAxis.Z;
                }
                default: {
                    return EnumAxis.NONE;
                }
            }
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
