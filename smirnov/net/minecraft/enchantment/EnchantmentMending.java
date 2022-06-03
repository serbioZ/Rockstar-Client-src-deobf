// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentMending extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIIlllllIIIIlIlIlIlIl) {
        return this.getMinEnchantability(llllllllllllIIlllllIIIIlIlIlIlIl) + 50;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllIIlllllIIIIlIlIllIll) {
        return llllllllllllIIlllllIIIIlIlIllIll * 25;
    }
    
    public EnchantmentMending(final Rarity llllllllllllIIlllllIIIIlIllIIIII, final EntityEquipmentSlot... llllllllllllIIlllllIIIIlIlIlllll) {
        super(llllllllllllIIlllllIIIIlIllIIIII, EnumEnchantmentType.BREAKABLE, llllllllllllIIlllllIIIIlIlIlllll);
        this.setName("mending");
    }
}
