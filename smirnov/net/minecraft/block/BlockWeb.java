// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWeb extends Block
{
    @Override
    public void harvestBlock(final World lllllllllllIIIIIllIIIllIIIllIlll, final EntityPlayer lllllllllllIIIIIllIIIllIIIllIllI, final BlockPos lllllllllllIIIIIllIIIllIIIllIlIl, final IBlockState lllllllllllIIIIIllIIIllIIIllIlII, @Nullable final TileEntity lllllllllllIIIIIllIIIllIIIlIllII, final ItemStack lllllllllllIIIIIllIIIllIIIllIIlI) {
        if (!lllllllllllIIIIIllIIIllIIIllIlll.isRemote && lllllllllllIIIIIllIIIllIIIllIIlI.getItem() == Items.SHEARS) {
            lllllllllllIIIIIllIIIllIIIllIllI.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lllllllllllIIIIIllIIIllIIIllIlll, lllllllllllIIIIIllIIIllIIIllIlIl, new ItemStack(Item.getItemFromBlock(this), 1));
        }
        else {
            super.harvestBlock(lllllllllllIIIIIllIIIllIIIllIlll, lllllllllllIIIIIllIIIllIIIllIllI, lllllllllllIIIIIllIIIllIIIllIlIl, lllllllllllIIIIIllIIIllIIIllIlII, lllllllllllIIIIIllIIIllIIIlIllII, lllllllllllIIIIIllIIIllIIIllIIlI);
        }
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIIIllIIIllIIlIIIllI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIIIllIIIllIIIlIlIIl, final IBlockState lllllllllllIIIIIllIIIllIIIlIlIII, final BlockPos lllllllllllIIIIIllIIIllIIIlIIlll, final EnumFacing lllllllllllIIIIIllIIIllIIIlIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIIIllIIIllIIlIIllII) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIIIIIllIIIllIIlIIlIlI, final IBlockAccess lllllllllllIIIIIllIIIllIIlIIlIIl, final BlockPos lllllllllllIIIIIllIIIllIIlIIlIII) {
        return BlockWeb.NULL_AABB;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIIIIIllIIIllIIlIlIIlI, final BlockPos lllllllllllIIIIIllIIIllIIlIlIIIl, final IBlockState lllllllllllIIIIIllIIIllIIlIlIIII, final Entity lllllllllllIIIIIllIIIllIIlIIlllI) {
        lllllllllllIIIIIllIIIllIIlIIlllI.setInWeb();
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public BlockWeb() {
        super(Material.WEB);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIIIllIIIllIIlIIIlII, final Random lllllllllllIIIIIllIIIllIIlIIIIll, final int lllllllllllIIIIIllIIIllIIlIIIIlI) {
        return Items.STRING;
    }
}
