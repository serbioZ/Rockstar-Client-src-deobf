// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EnchantmentDigging extends Enchantment
{
    @Override
    public boolean canApply(final ItemStack lllllllllllIlIIIllIlIIIlIllIIllI) {
        return lllllllllllIlIIIllIlIIIlIllIIllI.getItem() == Items.SHEARS || super.canApply(lllllllllllIlIIIllIlIIIlIllIIllI);
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIlIIIllIlIIIlIlllIIIl) {
        return 1 + 10 * (lllllllllllIlIIIllIlIIIlIlllIIIl - 1);
    }
    
    protected EnchantmentDigging(final Rarity lllllllllllIlIIIllIlIIIlIllllIIl, final EntityEquipmentSlot... lllllllllllIlIIIllIlIIIlIlllIlIl) {
        super(lllllllllllIlIIIllIlIIIlIllllIIl, EnumEnchantmentType.DIGGER, lllllllllllIlIIIllIlIIIlIlllIlIl);
        this.setName("digging");
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIlIIIllIlIIIlIllIllIl) {
        return super.getMinEnchantability(lllllllllllIlIIIllIlIIIlIllIllIl) + 50;
    }
}
