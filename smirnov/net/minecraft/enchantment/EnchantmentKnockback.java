// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentKnockback extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIlIlIlIlIllllllllIIlI) {
        return super.getMinEnchantability(lllllllllllIlIlIlIlIllllllllIIlI) + 50;
    }
    
    protected EnchantmentKnockback(final Rarity lllllllllllIlIlIlIlIllllllllllIl, final EntityEquipmentSlot... lllllllllllIlIlIlIlIllllllllllll) {
        super(lllllllllllIlIlIlIlIllllllllllIl, EnumEnchantmentType.WEAPON, lllllllllllIlIlIlIlIllllllllllll);
        this.setName("knockback");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIlIlIlIlIlllllllllIIl) {
        return 5 + 20 * (lllllllllllIlIlIlIlIlllllllllIIl - 1);
    }
}
