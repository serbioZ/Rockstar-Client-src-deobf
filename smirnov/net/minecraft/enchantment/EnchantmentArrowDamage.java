// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentArrowDamage extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllIllIIIIIIlIllIllIIlII) {
        return 1 + (lllllllllllIllIIIIIIlIllIllIIlII - 1) * 10;
    }
    
    public EnchantmentArrowDamage(final Rarity lllllllllllIllIIIIIIlIllIllIllII, final EntityEquipmentSlot... lllllllllllIllIIIIIIlIllIllIlIII) {
        super(lllllllllllIllIIIIIIlIllIllIllII, EnumEnchantmentType.BOW, lllllllllllIllIIIIIIlIllIllIlIII);
        this.setName("arrowDamage");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIllIIIIIIlIllIlIllllI) {
        return this.getMinEnchantability(lllllllllllIllIIIIIIlIllIlIllllI) + 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
