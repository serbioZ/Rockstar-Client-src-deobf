// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentOxygen extends Enchantment
{
    public EnchantmentOxygen(final Rarity lllllllllllIlIlllllIllllIIllIIIl, final EntityEquipmentSlot... lllllllllllIlIlllllIllllIIllIIll) {
        super(lllllllllllIlIlllllIllllIIllIIIl, EnumEnchantmentType.ARMOR_HEAD, lllllllllllIlIlllllIllllIIllIIll);
        this.setName("oxygen");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIlIlllllIllllIIlIllIl) {
        return 10 * lllllllllllIlIlllllIllllIIlIllIl;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIlIlllllIllllIIlIlIII) {
        return this.getMinEnchantability(lllllllllllIlIlllllIllllIIlIlIII) + 30;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
}
