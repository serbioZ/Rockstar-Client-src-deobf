// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentFishingSpeed extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllIIllIlIIIlllIlIIlIll) {
        return 15 + (llllllllllllIIllIlIIIlllIlIIlIll - 1) * 9;
    }
    
    protected EnchantmentFishingSpeed(final Rarity llllllllllllIIllIlIIIlllIlIlIIIl, final EnumEnchantmentType llllllllllllIIllIlIIIlllIlIlIIII, final EntityEquipmentSlot... llllllllllllIIllIlIIIlllIlIlIIll) {
        super(llllllllllllIIllIlIIIlllIlIlIIIl, llllllllllllIIllIlIIIlllIlIlIIII, llllllllllllIIllIlIIIlllIlIlIIll);
        this.setName("fishingSpeed");
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIIllIlIIIlllIlIIIlll) {
        return super.getMinEnchantability(llllllllllllIIllIlIIIlllIlIIIlll) + 50;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
}
