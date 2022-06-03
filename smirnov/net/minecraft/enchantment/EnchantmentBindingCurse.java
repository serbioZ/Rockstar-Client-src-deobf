// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentBindingCurse extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllIIIIIIlIIllllIIIIlII) {
        return 25;
    }
    
    @Override
    public boolean func_190936_d() {
        return true;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIIIIIIlIIllllIIIIIlI) {
        return 50;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    public EnchantmentBindingCurse(final Rarity llllllllllllIIIIIIlIIllllIIIlIlI, final EntityEquipmentSlot... llllllllllllIIIIIIlIIllllIIIIllI) {
        super(llllllllllllIIIIIIlIIllllIIIlIlI, EnumEnchantmentType.WEARABLE, llllllllllllIIIIIIlIIllllIIIIllI);
        this.setName("binding_curse");
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
