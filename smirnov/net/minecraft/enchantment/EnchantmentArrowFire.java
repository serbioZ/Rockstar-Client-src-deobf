// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentArrowFire extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    public EnchantmentArrowFire(final Rarity lllllllllllIIIIlIIllllIIllIIIlII, final EntityEquipmentSlot... lllllllllllIIIIlIIllllIIllIIIIll) {
        super(lllllllllllIIIIlIIllllIIllIIIlII, EnumEnchantmentType.BOW, lllllllllllIIIIlIIllllIIllIIIIll);
        this.setName("arrowFire");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIIIIlIIllllIIlIllllll) {
        return 50;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIIIIlIIllllIIllIIIIIl) {
        return 20;
    }
}
