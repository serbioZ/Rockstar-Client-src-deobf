// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Enchantments;

public class EnchantmentWaterWalker extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMinEnchantability(final int llIIllIIlllIlll) {
        return llIIllIIlllIlll * 10;
    }
    
    public boolean canApplyTogether(final Enchantment llIIllIIllIlIll) {
        return super.canApplyTogether(llIIllIIllIlIll) && llIIllIIllIlIll != Enchantments.FROST_WALKER;
    }
    
    public EnchantmentWaterWalker(final Rarity llIIllIIllllllI, final EntityEquipmentSlot... llIIllIIllllIlI) {
        super(llIIllIIllllllI, EnumEnchantmentType.ARMOR_FEET, llIIllIIllllIlI);
        this.setName("waterWalker");
    }
    
    @Override
    public int getMaxEnchantability(final int llIIllIIlllIIlI) {
        return this.getMinEnchantability(llIIllIIlllIIlI) + 15;
    }
}
