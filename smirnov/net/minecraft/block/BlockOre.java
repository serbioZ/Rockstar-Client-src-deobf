// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.MathHelper;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;

public class BlockOre extends Block
{
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIIIIIlIlIlIIIlIl, final Random lllllllllllllllIIIIIIlIlIlIIIlII, final int lllllllllllllllIIIIIIlIlIlIIIIll) {
        if (this == Blocks.COAL_ORE) {
            return Items.COAL;
        }
        if (this == Blocks.DIAMOND_ORE) {
            return Items.DIAMOND;
        }
        if (this == Blocks.LAPIS_ORE) {
            return Items.DYE;
        }
        if (this == Blocks.EMERALD_ORE) {
            return Items.EMERALD;
        }
        return (this == Blocks.QUARTZ_ORE) ? Items.QUARTZ : Item.getItemFromBlock(this);
    }
    
    public BlockOre(final MapColor lllllllllllllllIIIIIIlIlIlIIlIII) {
        super(Material.ROCK, lllllllllllllllIIIIIIlIlIlIIlIII);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public BlockOre() {
        this(Material.ROCK.getMaterialMapColor());
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIIIIIIlIlIIIllIII, final BlockPos lllllllllllllllIIIIIIlIlIIIlIlll, final IBlockState lllllllllllllllIIIIIIlIlIIIlIllI) {
        return new ItemStack(this);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIIIIIIlIlIIllllII) {
        return (this == Blocks.LAPIS_ORE) ? (4 + lllllllllllllllIIIIIIlIlIIllllII.nextInt(5)) : 1;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIIIlIlIIIlIIlI) {
        return (this == Blocks.LAPIS_ORE) ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIIIIIIlIlIIlIIlll, final BlockPos lllllllllllllllIIIIIIlIlIIlIIllI, final IBlockState lllllllllllllllIIIIIIlIlIIlIIlIl, final float lllllllllllllllIIIIIIlIlIIIlllIl, final int lllllllllllllllIIIIIIlIlIIIlllII) {
        super.dropBlockAsItemWithChance(lllllllllllllllIIIIIIlIlIIlIIlll, lllllllllllllllIIIIIIlIlIIlIIllI, lllllllllllllllIIIIIIlIlIIlIIlIl, lllllllllllllllIIIIIIlIlIIIlllIl, lllllllllllllllIIIIIIlIlIIIlllII);
        if (this.getItemDropped(lllllllllllllllIIIIIIlIlIIlIIlIl, lllllllllllllllIIIIIIlIlIIlIIlll.rand, lllllllllllllllIIIIIIlIlIIIlllII) != Item.getItemFromBlock(this)) {
            int lllllllllllllllIIIIIIlIlIIlIIIlI = 0;
            if (this == Blocks.COAL_ORE) {
                lllllllllllllllIIIIIIlIlIIlIIIlI = MathHelper.getInt(lllllllllllllllIIIIIIlIlIIlIIlll.rand, 0, 2);
            }
            else if (this == Blocks.DIAMOND_ORE) {
                lllllllllllllllIIIIIIlIlIIlIIIlI = MathHelper.getInt(lllllllllllllllIIIIIIlIlIIlIIlll.rand, 3, 7);
            }
            else if (this == Blocks.EMERALD_ORE) {
                lllllllllllllllIIIIIIlIlIIlIIIlI = MathHelper.getInt(lllllllllllllllIIIIIIlIlIIlIIlll.rand, 3, 7);
            }
            else if (this == Blocks.LAPIS_ORE) {
                lllllllllllllllIIIIIIlIlIIlIIIlI = MathHelper.getInt(lllllllllllllllIIIIIIlIlIIlIIlll.rand, 2, 5);
            }
            else if (this == Blocks.QUARTZ_ORE) {
                lllllllllllllllIIIIIIlIlIIlIIIlI = MathHelper.getInt(lllllllllllllllIIIIIIlIlIIlIIlll.rand, 2, 5);
            }
            this.dropXpOnBlockBreak(lllllllllllllllIIIIIIlIlIIlIIlll, lllllllllllllllIIIIIIlIlIIlIIllI, lllllllllllllllIIIIIIlIlIIlIIIlI);
        }
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lllllllllllllllIIIIIIlIlIIllIIlI, final Random lllllllllllllllIIIIIIlIlIIllIlIl) {
        if (lllllllllllllllIIIIIIlIlIIllIIlI > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), lllllllllllllllIIIIIIlIlIIllIlIl, lllllllllllllllIIIIIIlIlIIllIIlI)) {
            int lllllllllllllllIIIIIIlIlIIllIlII = lllllllllllllllIIIIIIlIlIIllIlIl.nextInt(lllllllllllllllIIIIIIlIlIIllIIlI + 2) - 1;
            if (lllllllllllllllIIIIIIlIlIIllIlII < 0) {
                lllllllllllllllIIIIIIlIlIIllIlII = 0;
            }
            return this.quantityDropped(lllllllllllllllIIIIIIlIlIIllIlIl) * (lllllllllllllllIIIIIIlIlIIllIlII + 1);
        }
        return this.quantityDropped(lllllllllllllllIIIIIIlIlIIllIlIl);
    }
}
