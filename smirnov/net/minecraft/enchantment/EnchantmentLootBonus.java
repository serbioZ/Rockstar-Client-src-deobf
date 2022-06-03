// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Enchantments;

public class EnchantmentLootBonus extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllIlIIlIIlIllllIlIIIIl) {
        return 15 + (llllllllllllIlIIlIIlIllllIlIIIIl - 1) * 9;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    public boolean canApplyTogether(final Enchantment llllllllllllIlIIlIIlIllllIIlIlII) {
        return super.canApplyTogether(llllllllllllIlIIlIIlIllllIIlIlII) && llllllllllllIlIIlIIlIllllIIlIlII != Enchantments.SILK_TOUCH;
    }
    
    protected EnchantmentLootBonus(final Rarity llllllllllllIlIIlIIlIllllIlIlIll, final EnumEnchantmentType llllllllllllIlIIlIIlIllllIlIIllI, final EntityEquipmentSlot... llllllllllllIlIIlIIlIllllIlIIlIl) {
        super(llllllllllllIlIIlIIlIllllIlIlIll, llllllllllllIlIIlIIlIllllIlIIllI, llllllllllllIlIIlIIlIllllIlIIlIl);
        if (llllllllllllIlIIlIIlIllllIlIIllI == EnumEnchantmentType.DIGGER) {
            this.setName("lootBonusDigger");
        }
        else if (llllllllllllIlIIlIIlIllllIlIIllI == EnumEnchantmentType.FISHING_ROD) {
            this.setName("lootBonusFishing");
        }
        else {
            this.setName("lootBonus");
        }
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIlIIlIIlIllllIIllIll) {
        return super.getMinEnchantability(llllllllllllIlIIlIIlIllllIIllIll) + 50;
    }
}
