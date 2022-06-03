// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.PropertyEnum;

public class BlockStainedGlassPane extends BlockPane
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception llllllllllllIIlIlIlIlIllIlIllIlI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllIIlIlIlIlIllIlIllIlI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIlIlIlIlIllIlIllIlI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIlIlIlIlIllIlIllIlI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllIIlIlIlIlIllIlIllIlI;
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIlIlIlIlIllIlllllIl, final Rotation llllllllllllIIlIlIlIlIllIlllllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIlIlIlIlIllIlllllII.ordinal()]) {
            case 3: {
                return llllllllllllIIlIlIlIlIllIlllllIl.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.NORTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.EAST));
            }
            case 4: {
                return llllllllllllIIlIlIlIlIllIlllllIl.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.EAST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.NORTH));
            }
            case 2: {
                return llllllllllllIIlIlIlIlIllIlllllIl.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.NORTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.EAST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)llllllllllllIIlIlIlIlIllIlllllIl.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH));
            }
            default: {
                return llllllllllllIIlIlIlIlIllIlllllIl;
            }
        }
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIlIlIlIlIllIllIIIlI, final BlockPos llllllllllllIIlIlIlIlIllIlIllllI, final IBlockState llllllllllllIIlIlIlIlIllIllIIIII) {
        if (!llllllllllllIIlIlIlIlIllIllIIIlI.isRemote) {
            BlockBeacon.updateColorAsync(llllllllllllIIlIlIlIlIllIllIIIlI, llllllllllllIIlIlIlIlIllIlIllllI);
        }
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIIlIlIlIlIllIllIlIlI, final BlockPos llllllllllllIIlIlIlIlIllIllIIllI, final IBlockState llllllllllllIIlIlIlIlIllIllIlIII) {
        if (!llllllllllllIIlIlIlIlIllIllIlIlI.isRemote) {
            BlockBeacon.updateColorAsync(llllllllllllIIlIlIlIlIllIllIlIlI, llllllllllllIIlIlIlIlIllIllIIllI);
        }
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIIlIlIlIlIlllIIlllIl) {
        return llllllllllllIIlIlIlIlIlllIIlllIl.getValue(BlockStainedGlassPane.COLOR).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStainedGlassPane.NORTH, BlockStainedGlassPane.EAST, BlockStainedGlassPane.WEST, BlockStainedGlassPane.SOUTH, BlockStainedGlassPane.COLOR });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIIlIlIlIlIlllIIIllII, final IBlockAccess llllllllllllIIlIlIlIlIlllIIIlllI, final BlockPos llllllllllllIIlIlIlIlIlllIIIllIl) {
        return MapColor.func_193558_a(llllllllllllIIlIlIlIlIlllIIIllII.getValue(BlockStainedGlassPane.COLOR));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlIlIlIlIlllIIIIIlI) {
        return llllllllllllIIlIlIlIlIlllIIIIIlI.getValue(BlockStainedGlassPane.COLOR).getMetadata();
    }
    
    public BlockStainedGlassPane() {
        super(Material.GLASS, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, false).withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlIlIlIlIlllIIIIlIl) {
        return this.getDefaultState().withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.byMetadata(llllllllllllIIlIlIlIlIlllIIIIlIl));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final long llllllllllllIIlIlIlIlIllIlIlllII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllIIlIlIlIlIllIlIlllII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIlIlIlIlIllIlIlllII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIlIlIlIlIllIlIlllII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIlIlIlIlIllIlIlllII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllIIlIlIlIlIllIlIlllII;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIlIlIlIlIllIlllIIlI, final Mirror llllllllllllIIlIlIlIlIllIlllIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIIlIlIlIlIllIlllIlII.ordinal()]) {
            case 2: {
                return llllllllllllIIlIlIlIlIllIlllIIlI.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)llllllllllllIIlIlIlIlIllIlllIIlI.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)llllllllllllIIlIlIlIlIllIlllIIlI.getValue((IProperty<V>)BlockStainedGlassPane.NORTH));
            }
            case 3: {
                return llllllllllllIIlIlIlIlIllIlllIIlI.withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)llllllllllllIIlIlIlIlIllIlllIIlI.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)llllllllllllIIlIlIlIlIllIlllIIlI.getValue((IProperty<V>)BlockStainedGlassPane.EAST));
            }
            default: {
                return super.withMirror(llllllllllllIIlIlIlIlIllIlllIIlI, llllllllllllIIlIlIlIlIllIlllIlII);
            }
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIIlIlIlIlIlllIIlIlll, final NonNullList<ItemStack> llllllllllllIIlIlIlIlIlllIIlIIll) {
        for (int llllllllllllIIlIlIlIlIlllIIlIlIl = 0; llllllllllllIIlIlIlIlIlllIIlIlIl < EnumDyeColor.values().length; ++llllllllllllIIlIlIlIlIlllIIlIlIl) {
            llllllllllllIIlIlIlIlIlllIIlIIll.add(new ItemStack(this, 1, llllllllllllIIlIlIlIlIlllIIlIlIl));
        }
    }
}
