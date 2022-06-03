// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentSweepingEdge extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllIllIlIllIlIlIIlIlIII) {
        return 5 + (llllllllllllIllIlIllIlIlIIlIlIII - 1) * 9;
    }
    
    public static float func_191526_e(final int llllllllllllIllIlIllIlIlIIIllllI) {
        return 1.0f - 1.0f / (llllllllllllIllIlIllIlIlIIIllllI + 1);
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIllIlIllIlIlIIlIIIlI) {
        return this.getMinEnchantability(llllllllllllIllIlIllIlIlIIlIIIlI) + 15;
    }
    
    public EnchantmentSweepingEdge(final Rarity llllllllllllIllIlIllIlIlIIlIllIl, final EntityEquipmentSlot... llllllllllllIllIlIllIlIlIIlIllll) {
        super(llllllllllllIllIlIllIlIlIIlIllIl, EnumEnchantmentType.WEAPON, llllllllllllIllIlIllIlIlIIlIllll);
    }
    
    @Override
    public String getName() {
        return "enchantment.sweeping";
    }
}
