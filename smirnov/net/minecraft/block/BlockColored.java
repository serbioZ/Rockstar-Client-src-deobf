// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.PropertyEnum;

public class BlockColored extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    
    @Override
    public int damageDropped(final IBlockState llllllllllIllllIllIIlIIIlIlIllII) {
        return llllllllllIllllIllIIlIIIlIlIllII.getValue(BlockColored.COLOR).getMetadata();
    }
    
    public BlockColored(final Material llllllllllIllllIllIIlIIIlIllIIlI) {
        super(llllllllllIllllIllIIlIIIlIllIIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIllllIllIIlIIIlIIIllIl) {
        return llllllllllIllllIllIIlIIIlIIIllIl.getValue(BlockColored.COLOR).getMetadata();
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIllllIllIIlIIIlIIlIIII) {
        return this.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(llllllllllIllllIllIIlIIIlIIlIIII));
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllIllllIllIIlIIIlIlIIlII, final NonNullList<ItemStack> llllllllllIllllIllIIlIIIlIlIIIII) {
        final int llllllllllIllllIllIIlIIIlIIlllII;
        final int llllllllllIllllIllIIlIIIlIIlllIl = ((EnumDyeColor[])(Object)(llllllllllIllllIllIIlIIIlIIlllII = (int)(Object)EnumDyeColor.values())).length;
        for (char llllllllllIllllIllIIlIIIlIIllllI = '\0'; llllllllllIllllIllIIlIIIlIIllllI < llllllllllIllllIllIIlIIIlIIlllIl; ++llllllllllIllllIllIIlIIIlIIllllI) {
            final EnumDyeColor llllllllllIllllIllIIlIIIlIlIIIlI = llllllllllIllllIllIIlIIIlIIlllII[llllllllllIllllIllIIlIIIlIIllllI];
            llllllllllIllllIllIIlIIIlIlIIIII.add(new ItemStack(this, 1, llllllllllIllllIllIIlIIIlIlIIIlI.getMetadata()));
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllIllllIllIIlIIIlIIlIllI, final IBlockAccess llllllllllIllllIllIIlIIIlIIllIII, final BlockPos llllllllllIllllIllIIlIIIlIIlIlll) {
        return MapColor.func_193558_a(llllllllllIllllIllIIlIIIlIIlIllI.getValue(BlockColored.COLOR));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockColored.COLOR });
    }
}
