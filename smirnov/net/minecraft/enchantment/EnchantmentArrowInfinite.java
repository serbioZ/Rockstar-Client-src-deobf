// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentArrowInfinite extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    public boolean canApplyTogether(final Enchantment llllllllllllIllIllllIlIllIllIlIl) {
        return !(llllllllllllIllIllllIlIllIllIlIl instanceof EnchantmentMending) && super.canApplyTogether(llllllllllllIllIllllIlIllIllIlIl);
    }
    
    public EnchantmentArrowInfinite(final Rarity llllllllllllIllIllllIlIllIllllll, final EntityEquipmentSlot... llllllllllllIllIllllIlIlllIIIIIl) {
        super(llllllllllllIllIllllIlIllIllllll, EnumEnchantmentType.BOW, llllllllllllIllIllllIlIlllIIIIIl);
        this.setName("arrowInfinite");
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllIllIllllIlIllIllllII) {
        return 20;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIllIllllIlIllIlllIlI) {
        return 50;
    }
}
