// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;

public class BlockMobSpawner extends BlockContainer
{
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIlllIlllIIlIIllIIll, final Random llllllllllllIIlllIlllIIlIIllIIlI, final int llllllllllllIIlllIlllIIlIIllIIIl) {
        return Items.field_190931_a;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIlllIlllIIlIIllIllI, final int llllllllllllIIlllIlllIIlIIllIlIl) {
        return new TileEntityMobSpawner();
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIlllIlllIIlIIIlIIll, final BlockPos llllllllllllIIlllIlllIIlIIIlIIlI, final IBlockState llllllllllllIIlllIlllIIlIIIlIIIl) {
        return ItemStack.field_190927_a;
    }
    
    protected BlockMobSpawner() {
        super(Material.ROCK);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllIIlllIlllIIlIIIlIllI) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIlllIlllIIlIIIllIII) {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIIlllIlllIIlIIlIllll) {
        return 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllIIlllIlllIIlIIlIIllI, final BlockPos llllllllllllIIlllIlllIIlIIlIIlIl, final IBlockState llllllllllllIIlllIlllIIlIIIlllIl, final float llllllllllllIIlllIlllIIlIIlIIIll, final int llllllllllllIIlllIlllIIlIIlIIIlI) {
        super.dropBlockAsItemWithChance(llllllllllllIIlllIlllIIlIIlIIllI, llllllllllllIIlllIlllIIlIIlIIlIl, llllllllllllIIlllIlllIIlIIIlllIl, llllllllllllIIlllIlllIIlIIlIIIll, llllllllllllIIlllIlllIIlIIlIIIlI);
        final int llllllllllllIIlllIlllIIlIIlIIIIl = 15 + llllllllllllIIlllIlllIIlIIlIIllI.rand.nextInt(15) + llllllllllllIIlllIlllIIlIIlIIllI.rand.nextInt(15);
        this.dropXpOnBlockBreak(llllllllllllIIlllIlllIIlIIlIIllI, llllllllllllIIlllIlllIIlIIlIIlIl, llllllllllllIIlllIlllIIlIIlIIIIl);
    }
}
