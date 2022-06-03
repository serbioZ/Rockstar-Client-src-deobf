// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.Material;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockWoodSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllIIlIIIllIllIlIIlIIll, final IBlockAccess llllllllllllIIlIIIllIllIlIIlIlIl, final BlockPos llllllllllllIIlIIIllIllIlIIlIlII) {
        return llllllllllllIIlIIIllIllIlIIlIIll.getValue(BlockWoodSlab.VARIANT).getMapColor();
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlIIIllIllIIlIlllIl) {
        int llllllllllllIIlIIIllIllIIlIlllll = 0;
        llllllllllllIIlIIIllIllIIlIlllll |= llllllllllllIIlIIIllIllIIlIlllIl.getValue(BlockWoodSlab.VARIANT).getMetadata();
        if (!this.isDouble() && llllllllllllIIlIIIllIllIIlIlllIl.getValue(BlockWoodSlab.HALF) == EnumBlockHalf.TOP) {
            llllllllllllIIlIIIllIllIIlIlllll |= 0x8;
        }
        return llllllllllllIIlIIIllIllIIlIlllll;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlIIIllIllIIllIlIIl) {
        IBlockState llllllllllllIIlIIIllIllIIllIlIII = this.getDefaultState().withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.byMetadata(llllllllllllIIlIIIllIllIIllIlIIl & 0x7));
        if (!this.isDouble()) {
            llllllllllllIIlIIIllIllIIllIlIII = llllllllllllIIlIIIllIllIIllIlIII.withProperty(BlockWoodSlab.HALF, ((llllllllllllIIlIIIllIllIIllIlIIl & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return llllllllllllIIlIIIllIllIIllIlIII;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIlIIIllIllIlIIIllII, final BlockPos llllllllllllIIlIIIllIllIlIIIlIll, final IBlockState llllllllllllIIlIIIllIllIlIIIlIIl) {
        return new ItemStack(Blocks.WOODEN_SLAB, 1, llllllllllllIIlIIIllIllIlIIIlIIl.getValue(BlockWoodSlab.VARIANT).getMetadata());
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockWoodSlab.VARIANT;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIlIIIllIllIlIIlIIIl, final Random llllllllllllIIlIIIllIllIlIIlIIII, final int llllllllllllIIlIIIllIllIlIIIllll) {
        return Item.getItemFromBlock(Blocks.WOODEN_SLAB);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIIlIIIllIllIIlllIllI, final NonNullList<ItemStack> llllllllllllIIlIIIllIllIIlllIlIl) {
        char llllllllllllIIlIIIllIllIIllIlllI;
        for (Exception llllllllllllIIlIIIllIllIIllIllll = (Exception)((BlockPlanks.EnumType[])(Object)(llllllllllllIIlIIIllIllIIllIlllI = (char)(Object)BlockPlanks.EnumType.values())).length, llllllllllllIIlIIIllIllIIlllIIII = (Exception)0; llllllllllllIIlIIIllIllIIlllIIII < llllllllllllIIlIIIllIllIIllIllll; ++llllllllllllIIlIIIllIllIIlllIIII) {
            final BlockPlanks.EnumType llllllllllllIIlIIIllIllIIlllIlII = llllllllllllIIlIIIllIllIIllIlllI[llllllllllllIIlIIIllIllIIlllIIII];
            llllllllllllIIlIIIllIllIIlllIlIl.add(new ItemStack(this, 1, llllllllllllIIlIIIllIllIIlllIlII.getMetadata()));
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class);
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack llllllllllllIIlIIIllIllIIlllllll) {
        return BlockPlanks.EnumType.byMetadata(llllllllllllIIlIIIllIllIIlllllll.getMetadata() & 0x7);
    }
    
    public BlockWoodSlab() {
        super(Material.WOOD);
        IBlockState llllllllllllIIlIIIllIllIlIIllIll = this.blockState.getBaseState();
        if (!this.isDouble()) {
            llllllllllllIIlIIIllIllIlIIllIll = llllllllllllIIlIIIllIllIlIIllIll.withProperty(BlockWoodSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(llllllllllllIIlIIIllIllIlIIllIll.withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.OAK));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIIlIIIllIllIIlIlIlIl) {
        return llllllllllllIIlIIIllIllIIlIlIlIl.getValue(BlockWoodSlab.VARIANT).getMetadata();
    }
    
    @Override
    public String getUnlocalizedName(final int llllllllllllIIlIIIllIllIlIIIIlIl) {
        return String.valueOf(super.getUnlocalizedName()) + "." + BlockPlanks.EnumType.byMetadata(llllllllllllIIlIIIllIllIlIIIIlIl).getUnlocalizedName();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWoodSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWoodSlab.HALF, BlockWoodSlab.VARIANT });
    }
}
