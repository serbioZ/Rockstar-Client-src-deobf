// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;

public class BlockHugeMushroom extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private final /* synthetic */ Block smallBlock;
    
    public BlockHugeMushroom(final Material lllllllllllIIlllllllIlllIllIIlll, final MapColor lllllllllllIIlllllllIlllIllIIllI, final Block lllllllllllIIlllllllIlllIllIIlIl) {
        super(lllllllllllIIlllllllIlllIllIIlll, lllllllllllIIlllllllIlllIllIIllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHugeMushroom.VARIANT, EnumType.ALL_OUTSIDE));
        this.smallBlock = lllllllllllIIlllllllIlllIllIIlIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
        }
        final double lllllllllllIIlllllllIlllIIIllIII = (Object)new int[EnumType.values().length];
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.ALL_INSIDE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.ALL_OUTSIDE.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.ALL_STEM.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.CENTER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.NORTH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.NORTH_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.NORTH_WEST.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.SOUTH.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.SOUTH_EAST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.SOUTH_WEST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.STEM.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            lllllllllllIIlllllllIlllIIIllIII[EnumType.WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType = (int[])(Object)lllllllllllIIlllllllIlllIIIllIII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlllllllIlllIIllIIIl) {
        return lllllllllllIIlllllllIlllIIllIIIl.getValue(BlockHugeMushroom.VARIANT).getMetadata();
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIIlllllllIlllIlIlIlll, final IBlockAccess lllllllllllIIlllllllIlllIlIlIllI, final BlockPos lllllllllllIIlllllllIlllIlIlIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIlIlIlll.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
            case 13: {
                return MapColor.CLOTH;
            }
            case 11: {
                return MapColor.SAND;
            }
            case 10: {
                return MapColor.SAND;
            }
            default: {
                return super.getMapColor(lllllllllllIIlllllllIlllIlIlIlll, lllllllllllIIlllllllIlllIlIlIllI, lllllllllllIIlllllllIlllIlIlIIIl);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final float lllllllllllIIlllllllIlllIIIlIlII = (Object)new int[Mirror.values().length];
        try {
            lllllllllllIIlllllllIlllIIIlIlII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllllllIlllIIIlIlII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllllllIlllIIIlIlII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIIlllllllIlllIIIlIlII;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlllllllIlllIIlIlIlI, final Rotation lllllllllllIIlllllllIlllIIlIlIll) {
        Label_0401: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIIlllllllIlllIIlIlIll.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIIlIlIlI.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 2: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 3: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 4: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 6: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 7: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 9: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        default: {
                            return lllllllllllIIlllllllIlllIIlIlIlI;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIIlIlIlI.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 2: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 3: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 4: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 6: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 7: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 8: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 9: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        default: {
                            return lllllllllllIIlllllllIlllIIlIlIlI;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIIlIlIlI.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        case 2: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 3: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 4: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 6: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 7: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 9: {
                            return lllllllllllIIlllllllIlllIIlIlIlI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        default: {
                            return lllllllllllIIlllllllIlllIIlIlIlI;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllIIlllllllIlllIIlIlIlI;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockHugeMushroom.VARIANT });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlllllllIlllIIllIlII) {
        return this.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, EnumType.byMetadata(lllllllllllIIlllllllIlllIIllIlII));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final char lllllllllllIIlllllllIlllIIIlIllI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIIlllllllIlllIIIlIllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllllllIlllIIIlIllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllllllIlllIIIlIllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlllllllIlllIIIlIllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIIlllllllIlllIIIlIllI;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlllllllIlllIlIIlllI, final Random lllllllllllIIlllllllIlllIlIIllIl, final int lllllllllllIIlllllllIlllIlIIllII) {
        return Item.getItemFromBlock(this.smallBlock);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlllllllIlllIlIIIIlI, final BlockPos lllllllllllIIlllllllIlllIlIIIIIl, final EnumFacing lllllllllllIIlllllllIlllIlIIIIII, final float lllllllllllIIlllllllIlllIIllllll, final float lllllllllllIIlllllllIlllIIlllllI, final float lllllllllllIIlllllllIlllIIllllIl, final int lllllllllllIIlllllllIlllIIllllII, final EntityLivingBase lllllllllllIIlllllllIlllIIlllIll) {
        return this.getDefaultState();
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIlllllllIlllIlIlllIl) {
        return Math.max(0, lllllllllllIIlllllllIlllIlIlllIl.nextInt(10) - 7);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlllllllIlllIIlIIIll, final Mirror lllllllllllIIlllllllIlllIIIllllI) {
        final EnumType lllllllllllIIlllllllIlllIIlIIIIl = lllllllllllIIlllllllIlllIIlIIIll.getValue(BlockHugeMushroom.VARIANT);
        Label_0329: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllIIlllllllIlllIIIllllI.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIIlIIIIl.ordinal()]) {
                        case 1: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 2: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 3: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(lllllllllllIIlllllllIlllIIlIIIll, lllllllllllIIlllllllIlllIIIllllI);
                        }
                        case 7: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 9: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllIIlllllllIlllIIlIIIIl.ordinal()]) {
                        case 1: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        default: {
                            break Label_0329;
                        }
                        case 3: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 4: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 6: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 7: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllIIlllllllIlllIIlIIIll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllIIlllllllIlllIIlIIIll, lllllllllllIIlllllllIlllIIIllllI);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIlllllllIlllIlIIlIII, final BlockPos lllllllllllIIlllllllIlllIlIIIlll, final IBlockState lllllllllllIIlllllllIlllIlIIIllI) {
        return new ItemStack(this.smallBlock);
    }
    
    public enum EnumType implements IStringSerializable
    {
        NORTH("NORTH", 1, 2, "north"), 
        NORTH_EAST("NORTH_EAST", 2, 3, "north_east"), 
        STEM("STEM", 9, 10, "stem"), 
        SOUTH_EAST("SOUTH_EAST", 8, 9, "south_east");
        
        private final /* synthetic */ String name;
        
        NORTH_WEST("NORTH_WEST", 0, 1, "north_west"), 
        ALL_STEM("ALL_STEM", 12, 15, "all_stem");
        
        private final /* synthetic */ int meta;
        
        ALL_OUTSIDE("ALL_OUTSIDE", 11, 14, "all_outside"), 
        CENTER("CENTER", 4, 5, "center"), 
        WEST("WEST", 3, 4, "west"), 
        ALL_INSIDE("ALL_INSIDE", 10, 0, "all_inside"), 
        SOUTH_WEST("SOUTH_WEST", 6, 7, "south_west"), 
        SOUTH("SOUTH", 7, 8, "south");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        EAST("EAST", 5, 6, "east");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String llllllllllllIlllllllIIllIIlIIlll, final int llllllllllllIlllllllIIllIIlIIllI, final int llllllllllllIlllllllIIllIIlIIlIl, final String llllllllllllIlllllllIIllIIlIIlII) {
            this.meta = llllllllllllIlllllllIIllIIlIIlIl;
            this.name = llllllllllllIlllllllIIllIIlIIlII;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = new EnumType[16];
            int llllllllllllIlllllllIIllIIllIIIl;
            for (double llllllllllllIlllllllIIllIIllIIlI = ((EnumType[])(Object)(llllllllllllIlllllllIIllIIllIIIl = (int)(Object)values())).length, llllllllllllIlllllllIIllIIllIIll = 0; llllllllllllIlllllllIIllIIllIIll < llllllllllllIlllllllIIllIIllIIlI; ++llllllllllllIlllllllIIllIIllIIll) {
                final EnumType llllllllllllIlllllllIIllIIllIlIl = llllllllllllIlllllllIIllIIllIIIl[llllllllllllIlllllllIIllIIllIIll];
                EnumType.META_LOOKUP[llllllllllllIlllllllIIllIIllIlIl.getMetadata()] = llllllllllllIlllllllIIllIIllIlIl;
            }
        }
        
        public static EnumType byMetadata(int llllllllllllIlllllllIIllIIIllIIl) {
            if (llllllllllllIlllllllIIllIIIllIIl < 0 || llllllllllllIlllllllIIllIIIllIIl >= EnumType.META_LOOKUP.length) {
                llllllllllllIlllllllIIllIIIllIIl = 0;
            }
            final EnumType llllllllllllIlllllllIIllIIIllIlI = EnumType.META_LOOKUP[llllllllllllIlllllllIIllIIIllIIl];
            return (llllllllllllIlllllllIIllIIIllIlI == null) ? EnumType.META_LOOKUP[0] : llllllllllllIlllllllIIllIIIllIlI;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
