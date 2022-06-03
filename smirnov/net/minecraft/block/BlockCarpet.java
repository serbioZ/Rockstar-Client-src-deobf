// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.PropertyEnum;

public class BlockCarpet extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    protected static final /* synthetic */ AxisAlignedBB CARPET_AABB;
    
    private boolean canBlockStay(final World lllllllllllllIlIllIIIIllIIlIlIII, final BlockPos lllllllllllllIlIllIIIIllIIlIIlll) {
        return !lllllllllllllIlIllIIIIllIIlIlIII.isAirBlock(lllllllllllllIlIllIIIIllIIlIIlll.down());
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIllIIIIllIlIIIIlI, final World lllllllllllllIlIllIIIIllIIlllIll, final BlockPos lllllllllllllIlIllIIIIllIlIIIIII, final Block lllllllllllllIlIllIIIIllIIllllll, final BlockPos lllllllllllllIlIllIIIIllIIlllllI) {
        this.checkForDrop(lllllllllllllIlIllIIIIllIIlllIll, lllllllllllllIlIllIIIIllIlIIIIII, lllllllllllllIlIllIIIIllIlIIIIlI);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIllIIIIllIIIIllll, final NonNullList<ItemStack> lllllllllllllIlIllIIIIllIIIIlllI) {
        for (int lllllllllllllIlIllIIIIllIIIIllIl = 0; lllllllllllllIlIllIIIIllIIIIllIl < 16; ++lllllllllllllIlIllIIIIllIIIIllIl) {
            lllllllllllllIlIllIIIIllIIIIlllI.add(new ItemStack(this, 1, lllllllllllllIlIllIIIIllIIIIllIl));
        }
    }
    
    private boolean checkForDrop(final World lllllllllllllIlIllIIIIllIIllIIII, final BlockPos lllllllllllllIlIllIIIIllIIlIllll, final IBlockState lllllllllllllIlIllIIIIllIIllIIlI) {
        if (!this.canBlockStay(lllllllllllllIlIllIIIIllIIllIIII, lllllllllllllIlIllIIIIllIIlIllll)) {
            this.dropBlockAsItem(lllllllllllllIlIllIIIIllIIllIIII, lllllllllllllIlIllIIIIllIIlIllll, lllllllllllllIlIllIIIIllIIllIIlI, 0);
            lllllllllllllIlIllIIIIllIIllIIII.setBlockToAir(lllllllllllllIlIllIIIIllIIlIllll);
            return false;
        }
        return true;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIllIIIIllIlIlIlIl, final IBlockAccess lllllllllllllIlIllIIIIllIlIlIlll, final BlockPos lllllllllllllIlIllIIIIllIlIlIllI) {
        return MapColor.func_193558_a(lllllllllllllIlIllIIIIllIlIlIlIl.getValue(BlockCarpet.COLOR));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCarpet.COLOR });
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIllIIIIllIlIlllIl, final IBlockAccess lllllllllllllIlIllIIIIllIlIlllII, final BlockPos lllllllllllllIlIllIIIIllIlIllIll) {
        return BlockCarpet.CARPET_AABB;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIllIIIIllIIIIIlII) {
        return this.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.byMetadata(lllllllllllllIlIllIIIIllIIIIIlII));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIllIIIIlIlllllIlI, final IBlockState lllllllllllllIlIllIIIIlIlllllIIl, final BlockPos lllllllllllllIlIllIIIIlIlllllIII, final EnumFacing lllllllllllllIlIllIIIIlIllllIllI) {
        return (lllllllllllllIlIllIIIIlIllllIllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIllIIIIllIIIIIIIl) {
        return lllllllllllllIlIllIIIIllIIIIIIIl.getValue(BlockCarpet.COLOR).getMetadata();
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
        CARPET_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIllIIIIllIlIlIIll) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIllIIIIllIlIlIIIl) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIlIllIIIIllIlIIlIIl, final BlockPos lllllllllllllIlIllIIIIllIlIIlIll) {
        return super.canPlaceBlockAt(lllllllllllllIlIllIIIIllIlIIlIIl, lllllllllllllIlIllIIIIllIlIIlIll) && this.canBlockStay(lllllllllllllIlIllIIIIllIlIIlIIl, lllllllllllllIlIllIIIIllIlIIlIll);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIlIllIIIIllIIlIIIII, final IBlockAccess lllllllllllllIlIllIIIIllIIIllIlI, final BlockPos lllllllllllllIlIllIIIIllIIIllIIl, final EnumFacing lllllllllllllIlIllIIIIllIIIlllIl) {
        return lllllllllllllIlIllIIIIllIIIlllIl == EnumFacing.UP || lllllllllllllIlIllIIIIllIIIllIlI.getBlockState(lllllllllllllIlIllIIIIllIIIllIIl.offset(lllllllllllllIlIllIIIIllIIIlllIl)).getBlock() == this || super.shouldSideBeRendered(lllllllllllllIlIllIIIIllIIlIIIII, lllllllllllllIlIllIIIIllIIIllIlI, lllllllllllllIlIllIIIIllIIIllIIl, lllllllllllllIlIllIIIIllIIIlllIl);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIllIIIIllIIIlIlIl) {
        return lllllllllllllIlIllIIIIllIIIlIlIl.getValue(BlockCarpet.COLOR).getMetadata();
    }
    
    protected BlockCarpet() {
        super(Material.CARPET);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
