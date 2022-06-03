// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.world.EnumSkyBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.stats.StatList;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.util.BlockRenderLayer;

public class BlockIce extends BlockBreakable
{
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllIllllllIIlIlllIIIIIlll) {
        return 0;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState llllllllllIllllllIIlIllIllllIIIl) {
        return EnumPushReaction.NORMAL;
    }
    
    public BlockIce() {
        super(Material.ICE, false);
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    protected void turnIntoWater(final World llllllllllIllllllIIlIllIllllIlII, final BlockPos llllllllllIllllllIIlIllIllllIllI) {
        if (llllllllllIllllllIIlIllIllllIlII.provider.doesWaterVaporize()) {
            llllllllllIllllllIIlIllIllllIlII.setBlockToAir(llllllllllIllllllIIlIllIllllIllI);
        }
        else {
            this.dropBlockAsItem(llllllllllIllllllIIlIllIllllIlII, llllllllllIllllllIIlIllIllllIllI, llllllllllIllllllIIlIllIllllIlII.getBlockState(llllllllllIllllllIIlIllIllllIllI), 0);
            llllllllllIllllllIIlIllIllllIlII.setBlockState(llllllllllIllllllIIlIllIllllIllI, Blocks.WATER.getDefaultState());
            llllllllllIllllllIIlIllIllllIlII.func_190524_a(llllllllllIllllllIIlIllIllllIllI, Blocks.WATER, llllllllllIllllllIIlIllIllllIllI);
        }
    }
    
    @Override
    public void harvestBlock(final World llllllllllIllllllIIlIlllIIIllIII, final EntityPlayer llllllllllIllllllIIlIlllIIIIlllI, final BlockPos llllllllllIllllllIIlIlllIIIIllIl, final IBlockState llllllllllIllllllIIlIlllIIIlIlIl, @Nullable final TileEntity llllllllllIllllllIIlIlllIIIlIlII, final ItemStack llllllllllIllllllIIlIlllIIIlIIll) {
        llllllllllIllllllIIlIlllIIIIlllI.addStat(StatList.getBlockStats(this));
        llllllllllIllllllIIlIlllIIIIlllI.addExhaustion(0.005f);
        if (this.canSilkHarvest() && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, llllllllllIllllllIIlIlllIIIlIIll) > 0) {
            Block.spawnAsEntity(llllllllllIllllllIIlIlllIIIllIII, llllllllllIllllllIIlIlllIIIIllIl, this.getSilkTouchDrop(llllllllllIllllllIIlIlllIIIlIlIl));
        }
        else {
            if (llllllllllIllllllIIlIlllIIIllIII.provider.doesWaterVaporize()) {
                llllllllllIllllllIIlIlllIIIllIII.setBlockToAir(llllllllllIllllllIIlIlllIIIIllIl);
                return;
            }
            final int llllllllllIllllllIIlIlllIIIlIIlI = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, llllllllllIllllllIIlIlllIIIlIIll);
            this.dropBlockAsItem(llllllllllIllllllIIlIlllIIIllIII, llllllllllIllllllIIlIlllIIIIllIl, llllllllllIllllllIIlIlllIIIlIlIl, llllllllllIllllllIIlIlllIIIlIIlI);
            final Material llllllllllIllllllIIlIlllIIIlIIIl = llllllllllIllllllIIlIlllIIIllIII.getBlockState(llllllllllIllllllIIlIlllIIIIllIl.down()).getMaterial();
            if (llllllllllIllllllIIlIlllIIIlIIIl.blocksMovement() || llllllllllIllllllIIlIlllIIIlIIIl.isLiquid()) {
                llllllllllIllllllIIlIlllIIIllIII.setBlockState(llllllllllIllllllIIlIlllIIIIllIl, Blocks.FLOWING_WATER.getDefaultState());
            }
        }
    }
    
    @Override
    public void updateTick(final World llllllllllIllllllIIlIlllIIIIIIlI, final BlockPos llllllllllIllllllIIlIllIllllllII, final IBlockState llllllllllIllllllIIlIlllIIIIIIII, final Random llllllllllIllllllIIlIllIllllllll) {
        if (llllllllllIllllllIIlIlllIIIIIIlI.getLightFor(EnumSkyBlock.BLOCK, llllllllllIllllllIIlIllIllllllII) > 11 - this.getDefaultState().getLightOpacity()) {
            this.turnIntoWater(llllllllllIllllllIIlIlllIIIIIIlI, llllllllllIllllllIIlIllIllllllII);
        }
    }
}
