// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentWaterWorker extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllIIlllIlIIIIIlllllIIIl) {
        return 1;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIIlllIlIIIIIllllIllIl) {
        return this.getMinEnchantability(lllllllllllIIlllIlIIIIIllllIllIl) + 40;
    }
    
    public EnchantmentWaterWorker(final Rarity lllllllllllIIlllIlIIIIIlllllIlII, final EntityEquipmentSlot... lllllllllllIIlllIlIIIIIlllllIllI) {
        super(lllllllllllIIlllIlIIIIIlllllIlII, EnumEnchantmentType.ARMOR_HEAD, lllllllllllIIlllIlIIIIIlllllIllI);
        this.setName("waterWorker");
    }
}
