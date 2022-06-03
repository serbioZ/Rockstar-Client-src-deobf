// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.stats.StatList;
import net.minecraft.world.IWorldNameable;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockContainer extends Block implements ITileEntityProvider
{
    protected boolean isInvalidNeighbor(final World lllllllllllIlIIIlIIlIlIIIIIlllIl, final BlockPos lllllllllllIlIIIlIIlIlIIIIIlllII, final EnumFacing lllllllllllIlIIIlIIlIlIIIIIllIll) {
        return lllllllllllIlIIIlIIlIlIIIIIlllIl.getBlockState(lllllllllllIlIIIlIIlIlIIIIIlllII.offset(lllllllllllIlIIIlIIlIlIIIIIllIll)).getMaterial() == Material.CACTUS;
    }
    
    protected BlockContainer(final Material lllllllllllIlIIIlIIlIlIIIIlIIllI, final MapColor lllllllllllIlIIIlIIlIlIIIIlIlIII) {
        super(lllllllllllIlIIIlIIlIlIIIIlIIllI, lllllllllllIlIIIlIIlIlIIIIlIlIII);
        this.isBlockContainer = true;
    }
    
    protected boolean hasInvalidNeighbor(final World lllllllllllIlIIIlIIlIlIIIIIlIIll, final BlockPos lllllllllllIlIIIlIIlIlIIIIIlIlIl) {
        return this.isInvalidNeighbor(lllllllllllIlIIIlIIlIlIIIIIlIIll, lllllllllllIlIIIlIIlIlIIIIIlIlIl, EnumFacing.NORTH) || this.isInvalidNeighbor(lllllllllllIlIIIlIIlIlIIIIIlIIll, lllllllllllIlIIIlIIlIlIIIIIlIlIl, EnumFacing.SOUTH) || this.isInvalidNeighbor(lllllllllllIlIIIlIIlIlIIIIIlIIll, lllllllllllIlIIIlIIlIlIIIIIlIlIl, EnumFacing.WEST) || this.isInvalidNeighbor(lllllllllllIlIIIlIIlIlIIIIIlIIll, lllllllllllIlIIIlIIlIlIIIIIlIlIl, EnumFacing.EAST);
    }
    
    @Override
    public void breakBlock(final World lllllllllllIlIIIlIIlIlIIIIIIIllI, final BlockPos lllllllllllIlIIIlIIlIlIIIIIIlIIl, final IBlockState lllllllllllIlIIIlIIlIlIIIIIIIlII) {
        super.breakBlock(lllllllllllIlIIIlIIlIlIIIIIIIllI, lllllllllllIlIIIlIIlIlIIIIIIlIIl, lllllllllllIlIIIlIIlIlIIIIIIIlII);
        lllllllllllIlIIIlIIlIlIIIIIIIllI.removeTileEntity(lllllllllllIlIIIlIIlIlIIIIIIlIIl);
    }
    
    @Override
    public boolean eventReceived(final IBlockState lllllllllllIlIIIlIIlIIllllIlllIl, final World lllllllllllIlIIIlIIlIIllllIlIlIl, final BlockPos lllllllllllIlIIIlIIlIIllllIlIlII, final int lllllllllllIlIIIlIIlIIllllIlIIll, final int lllllllllllIlIIIlIIlIIllllIlIIlI) {
        super.eventReceived(lllllllllllIlIIIlIIlIIllllIlllIl, lllllllllllIlIIIlIIlIIllllIlIlIl, lllllllllllIlIIIlIIlIIllllIlIlII, lllllllllllIlIIIlIIlIIllllIlIIll, lllllllllllIlIIIlIIlIIllllIlIIlI);
        final TileEntity lllllllllllIlIIIlIIlIIllllIllIII = lllllllllllIlIIIlIIlIIllllIlIlIl.getTileEntity(lllllllllllIlIIIlIIlIIllllIlIlII);
        return lllllllllllIlIIIlIIlIIllllIllIII != null && lllllllllllIlIIIlIIlIIllllIllIII.receiveClientEvent(lllllllllllIlIIIlIIlIIllllIlIIll, lllllllllllIlIIIlIIlIIllllIlIIlI);
    }
    
    protected BlockContainer(final Material lllllllllllIlIIIlIIlIlIIIIllIIII) {
        this(lllllllllllIlIIIlIIlIlIIIIllIIII, lllllllllllIlIIIlIIlIlIIIIllIIII.getMaterialMapColor());
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIlIIIlIIlIlIIIIIlIIII) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIlIIIlIIlIIlllllllIII, final EntityPlayer lllllllllllIlIIIlIIlIIlllllIllIl, final BlockPos lllllllllllIlIIIlIIlIIlllllIllII, final IBlockState lllllllllllIlIIIlIIlIIlllllIlIll, @Nullable final TileEntity lllllllllllIlIIIlIIlIIlllllIlIlI, final ItemStack lllllllllllIlIIIlIIlIIlllllIlIIl) {
        if (lllllllllllIlIIIlIIlIIlllllIlIlI instanceof IWorldNameable && ((IWorldNameable)lllllllllllIlIIIlIIlIIlllllIlIlI).hasCustomName()) {
            lllllllllllIlIIIlIIlIIlllllIllIl.addStat(StatList.getBlockStats(this));
            lllllllllllIlIIIlIIlIIlllllIllIl.addExhaustion(0.005f);
            if (lllllllllllIlIIIlIIlIIlllllllIII.isRemote) {
                return;
            }
            final int lllllllllllIlIIIlIIlIIllllllIIlI = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, lllllllllllIlIIIlIIlIIlllllIlIIl);
            final Item lllllllllllIlIIIlIIlIIllllllIIIl = this.getItemDropped(lllllllllllIlIIIlIIlIIlllllIlIll, lllllllllllIlIIIlIIlIIlllllllIII.rand, lllllllllllIlIIIlIIlIIllllllIIlI);
            if (lllllllllllIlIIIlIIlIIllllllIIIl == Items.field_190931_a) {
                return;
            }
            final ItemStack lllllllllllIlIIIlIIlIIllllllIIII = new ItemStack(lllllllllllIlIIIlIIlIIllllllIIIl, this.quantityDropped(lllllllllllIlIIIlIIlIIlllllllIII.rand));
            lllllllllllIlIIIlIIlIIllllllIIII.setStackDisplayName(((IWorldNameable)lllllllllllIlIIIlIIlIIlllllIlIlI).getName());
            Block.spawnAsEntity(lllllllllllIlIIIlIIlIIlllllllIII, lllllllllllIlIIIlIIlIIlllllIllII, lllllllllllIlIIIlIIlIIllllllIIII);
        }
        else {
            super.harvestBlock(lllllllllllIlIIIlIIlIIlllllllIII, lllllllllllIlIIIlIIlIIlllllIllIl, lllllllllllIlIIIlIIlIIlllllIllII, lllllllllllIlIIIlIIlIIlllllIlIll, null, lllllllllllIlIIIlIIlIIlllllIlIIl);
        }
    }
}
