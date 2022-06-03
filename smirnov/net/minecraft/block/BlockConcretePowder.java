// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.PropertyEnum;

public class BlockConcretePowder extends BlockFalling
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> field_192426_a;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIIlllIIIlIlllIII) {
        return this.getDefaultState().withProperty(BlockConcretePowder.field_192426_a, EnumDyeColor.byMetadata(lllllllllllllIllIIlllIIIlIlllIII));
    }
    
    static {
        field_192426_a = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockConcretePowder.field_192426_a });
    }
    
    @Override
    public void onEndFalling(final World lllllllllllllIllIIlllIIlIIIlIIlI, final BlockPos lllllllllllllIllIIlllIIlIIIlIlIl, final IBlockState lllllllllllllIllIIlllIIlIIIlIlII, final IBlockState lllllllllllllIllIIlllIIlIIIlIIll) {
        if (lllllllllllllIllIIlllIIlIIIlIIll.getMaterial().isLiquid()) {
            lllllllllllllIllIIlllIIlIIIlIIlI.setBlockState(lllllllllllllIllIIlllIIlIIIlIlIl, Blocks.field_192443_dR.getDefaultState().withProperty(BlockColored.COLOR, (EnumDyeColor)lllllllllllllIllIIlllIIlIIIlIlII.getValue((IProperty<V>)BlockConcretePowder.field_192426_a)), 3);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIllIIlllIIIlllIlllI, final World lllllllllllllIllIIlllIIIlllIllIl, final BlockPos lllllllllllllIllIIlllIIIlllIIllI, final Block lllllllllllllIllIIlllIIIlllIIlIl, final BlockPos lllllllllllllIllIIlllIIIlllIIlII) {
        if (!this.func_192425_e(lllllllllllllIllIIlllIIIlllIllIl, lllllllllllllIllIIlllIIIlllIIllI, lllllllllllllIllIIlllIIIlllIlllI)) {
            super.neighborChanged(lllllllllllllIllIIlllIIIlllIlllI, lllllllllllllIllIIlllIIIlllIllIl, lllllllllllllIllIIlllIIIlllIIllI, lllllllllllllIllIIlllIIIlllIIlIl, lllllllllllllIllIIlllIIIlllIIlII);
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllIIlllIIIllIllIlI, final BlockPos lllllllllllllIllIIlllIIIllIlllIl, final IBlockState lllllllllllllIllIIlllIIIllIlllII) {
        if (!this.func_192425_e(lllllllllllllIllIIlllIIIllIllIlI, lllllllllllllIllIIlllIIIllIlllIl, lllllllllllllIllIIlllIIIllIlllII)) {
            super.onBlockAdded(lllllllllllllIllIIlllIIIllIllIlI, lllllllllllllIllIIlllIIIllIlllIl, lllllllllllllIllIIlllIIIllIlllII);
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIIlllIIIlIlllllI, final IBlockAccess lllllllllllllIllIIlllIIIllIIIIII, final BlockPos lllllllllllllIllIIlllIIIlIllllll) {
        return MapColor.func_193558_a(lllllllllllllIllIIlllIIIlIlllllI.getValue(BlockConcretePowder.field_192426_a));
    }
    
    protected boolean func_192425_e(final World lllllllllllllIllIIlllIIIlllllllI, final BlockPos lllllllllllllIllIIlllIIIllllllIl, final IBlockState lllllllllllllIllIIlllIIlIIIIIIlI) {
        boolean lllllllllllllIllIIlllIIlIIIIIIIl = false;
        char lllllllllllllIllIIlllIIIllllIlll;
        for (byte lllllllllllllIllIIlllIIIlllllIII = (byte)((EnumFacing[])(Object)(lllllllllllllIllIIlllIIIllllIlll = (char)(Object)EnumFacing.values())).length, lllllllllllllIllIIlllIIIlllllIIl = 0; lllllllllllllIllIIlllIIIlllllIIl < lllllllllllllIllIIlllIIIlllllIII; ++lllllllllllllIllIIlllIIIlllllIIl) {
            final EnumFacing lllllllllllllIllIIlllIIlIIIIIIII = lllllllllllllIllIIlllIIIllllIlll[lllllllllllllIllIIlllIIIlllllIIl];
            if (lllllllllllllIllIIlllIIlIIIIIIII != EnumFacing.DOWN) {
                final BlockPos lllllllllllllIllIIlllIIIllllllll = lllllllllllllIllIIlllIIIllllllIl.offset(lllllllllllllIllIIlllIIlIIIIIIII);
                if (lllllllllllllIllIIlllIIIlllllllI.getBlockState(lllllllllllllIllIIlllIIIllllllll).getMaterial() == Material.WATER) {
                    lllllllllllllIllIIlllIIlIIIIIIIl = true;
                    break;
                }
            }
        }
        if (lllllllllllllIllIIlllIIlIIIIIIIl) {
            lllllllllllllIllIIlllIIIlllllllI.setBlockState(lllllllllllllIllIIlllIIIllllllIl, Blocks.field_192443_dR.getDefaultState().withProperty(BlockColored.COLOR, (EnumDyeColor)lllllllllllllIllIIlllIIlIIIIIIlI.getValue((IProperty<V>)BlockConcretePowder.field_192426_a)), 3);
        }
        return lllllllllllllIllIIlllIIlIIIIIIIl;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIIlllIIIlIllIlIl) {
        return lllllllllllllIllIIlllIIIlIllIlIl.getValue(BlockConcretePowder.field_192426_a).getMetadata();
    }
    
    public BlockConcretePowder() {
        super(Material.SAND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockConcretePowder.field_192426_a, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllIIlllIIIllIIllII, final NonNullList<ItemStack> lllllllllllllIllIIlllIIIllIIlIII) {
        final float lllllllllllllIllIIlllIIIllIIIlII;
        final Exception lllllllllllllIllIIlllIIIllIIIlIl = (Exception)((EnumDyeColor[])(Object)(lllllllllllllIllIIlllIIIllIIIlII = (float)(Object)EnumDyeColor.values())).length;
        for (long lllllllllllllIllIIlllIIIllIIIllI = 0; lllllllllllllIllIIlllIIIllIIIllI < lllllllllllllIllIIlllIIIllIIIlIl; ++lllllllllllllIllIIlllIIIllIIIllI) {
            final EnumDyeColor lllllllllllllIllIIlllIIIllIIlIlI = lllllllllllllIllIIlllIIIllIIIlII[lllllllllllllIllIIlllIIIllIIIllI];
            lllllllllllllIllIIlllIIIllIIlIII.add(new ItemStack(this, 1, lllllllllllllIllIIlllIIIllIIlIlI.getMetadata()));
        }
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllIIlllIIIllIlIlII) {
        return lllllllllllllIllIIlllIIIllIlIlII.getValue(BlockConcretePowder.field_192426_a).getMetadata();
    }
}
