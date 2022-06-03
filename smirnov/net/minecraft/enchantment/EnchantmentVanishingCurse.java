// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentVanishingCurse extends Enchantment
{
    @Override
    public int getMaxEnchantability(final int lllllllllllIIlllIIlllIlllllIlIIl) {
        return 50;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    public EnchantmentVanishingCurse(final Rarity lllllllllllIIlllIIlllIllllllIIIl, final EntityEquipmentSlot... lllllllllllIIlllIIlllIlllllIllIl) {
        super(lllllllllllIIlllIIlllIllllllIIIl, EnumEnchantmentType.ALL, lllllllllllIIlllIIlllIlllllIllIl);
        this.setName("vanishing_curse");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIIlllIIlllIlllllIlIll) {
        return 25;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public boolean func_190936_d() {
        return true;
    }
}
