// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.PropertyEnum;

public class BlockStainedGlass extends BlockBreakable
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIIllIlllIIlIIIlllIl) {
        return this.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.byMetadata(lllllllllllIIIIllIlllIIlIIIlllIl));
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIIllIlllIIlIIlIIIll) {
        return false;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIIIllIlllIIlIIllIlll, final NonNullList<ItemStack> lllllllllllIIIIllIlllIIlIIllIIll) {
        final boolean lllllllllllIIIIllIlllIIlIIlIllll;
        final char lllllllllllIIIIllIlllIIlIIllIIII = (char)((EnumDyeColor[])(Object)(lllllllllllIIIIllIlllIIlIIlIllll = (boolean)(Object)EnumDyeColor.values())).length;
        for (String lllllllllllIIIIllIlllIIlIIllIIIl = (String)0; lllllllllllIIIIllIlllIIlIIllIIIl < lllllllllllIIIIllIlllIIlIIllIIII; ++lllllllllllIIIIllIlllIIlIIllIIIl) {
            final EnumDyeColor lllllllllllIIIIllIlllIIlIIllIlIl = lllllllllllIIIIllIlllIIlIIlIllll[lllllllllllIIIIllIlllIIlIIllIIIl];
            lllllllllllIIIIllIlllIIlIIllIIll.add(new ItemStack(this, 1, lllllllllllIIIIllIlllIIlIIllIlIl.getMetadata()));
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIIIllIlllIIlIIIlIIIl, final BlockPos lllllllllllIIIIllIlllIIlIIIlIIII, final IBlockState lllllllllllIIIIllIlllIIlIIIIllll) {
        if (!lllllllllllIIIIllIlllIIlIIIlIIIl.isRemote) {
            BlockBeacon.updateColorAsync(lllllllllllIIIIllIlllIIlIIIlIIIl, lllllllllllIIIIllIlllIIlIIIlIIII);
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIIIIllIlllIIlIIIlIllI, final BlockPos lllllllllllIIIIllIlllIIlIIIllIII, final IBlockState lllllllllllIIIIllIlllIIlIIIlIlll) {
        if (!lllllllllllIIIIllIlllIIlIIIlIllI.isRemote) {
            BlockBeacon.updateColorAsync(lllllllllllIIIIllIlllIIlIIIlIllI, lllllllllllIIIIllIlllIIlIIIllIII);
        }
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIIIIllIlllIIlIIlIlIIl, final IBlockAccess lllllllllllIIIIllIlllIIlIIlIlIll, final BlockPos lllllllllllIIIIllIlllIIlIIlIlIlI) {
        return MapColor.func_193558_a(lllllllllllIIIIllIlllIIlIIlIlIIl.getValue(BlockStainedGlass.COLOR));
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIIIllIlllIIlIIlIIllI) {
        return 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIIllIlllIIlIIIIlIIl) {
        return lllllllllllIIIIllIlllIIlIIIIlIIl.getValue(BlockStainedGlass.COLOR).getMetadata();
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStainedGlass.COLOR });
    }
    
    public BlockStainedGlass(final Material lllllllllllIIIIllIlllIIlIlIIIlIl) {
        super(lllllllllllIIIIllIlllIIlIlIIIlIl, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIIIIllIlllIIlIIllllll) {
        return lllllllllllIIIIllIlllIIlIIllllll.getValue(BlockStainedGlass.COLOR).getMetadata();
    }
}
