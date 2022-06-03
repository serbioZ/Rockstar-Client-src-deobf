// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentFireAspect extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllIIlIlIllIlIIllllIlIII) {
        return 10 + 20 * (lllllllllllIIlIlIllIlIIllllIlIII - 1);
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    protected EnchantmentFireAspect(final Rarity lllllllllllIIlIlIllIlIIlllllIIII, final EntityEquipmentSlot... lllllllllllIIlIlIllIlIIllllIllII) {
        super(lllllllllllIIlIlIllIlIIlllllIIII, EnumEnchantmentType.WEAPON, lllllllllllIIlIlIllIlIIllllIllII);
        this.setName("fire");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIIlIlIllIlIIllllIIIlI) {
        return super.getMinEnchantability(lllllllllllIIlIlIllIlIIllllIIIlI) + 50;
    }
}
