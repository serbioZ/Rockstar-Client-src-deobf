// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentArrowKnockback extends Enchantment
{
    public EnchantmentArrowKnockback(final Rarity lllllllllllIIllIlIIIIlIIlllIIIlI, final EntityEquipmentSlot... lllllllllllIIllIlIIIIlIIllIllllI) {
        super(lllllllllllIIllIlIIIIlIIlllIIIlI, EnumEnchantmentType.BOW, lllllllllllIIllIlIIIIlIIllIllllI);
        this.setName("arrowKnockback");
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIIllIlIIIIlIIllIllIlI) {
        return 12 + (lllllllllllIIllIlIIIIlIIllIllIlI - 1) * 20;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIIllIlIIIIlIIllIlIllI) {
        return this.getMinEnchantability(lllllllllllIIllIlIIIIlIIllIlIllI) + 25;
    }
}
