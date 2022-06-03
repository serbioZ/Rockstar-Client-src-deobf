// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Enchantments;

public class EnchantmentUntouching extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    public boolean canApplyTogether(final Enchantment llllllllllIlllIlIllIllllllIIIllI) {
        return super.canApplyTogether(llllllllllIlllIlIllIllllllIIIllI) && llllllllllIlllIlIllIllllllIIIllI != Enchantments.FORTUNE;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllIlllIlIllIllllllIIllll) {
        return super.getMinEnchantability(llllllllllIlllIlIllIllllllIIllll) + 50;
    }
    
    protected EnchantmentUntouching(final Rarity llllllllllIlllIlIllIllllllIlIllI, final EntityEquipmentSlot... llllllllllIlllIlIllIllllllIllIII) {
        super(llllllllllIlllIlIllIllllllIlIllI, EnumEnchantmentType.DIGGER, llllllllllIlllIlIllIllllllIllIII);
        this.setName("untouching");
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllIlllIlIllIllllllIlIIll) {
        return 15;
    }
}
