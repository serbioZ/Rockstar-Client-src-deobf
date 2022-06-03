// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import java.util.Random;
import net.minecraft.item.ItemStack;

public class EnchantmentDurability extends Enchantment
{
    public static boolean negateDamage(final ItemStack lllllllllllIllIIlIIlIllIIlllllIl, final int lllllllllllIllIIlIIlIllIIlllllII, final Random lllllllllllIllIIlIIlIllIIllllIll) {
        return (!(lllllllllllIllIIlIIlIllIIlllllIl.getItem() instanceof ItemArmor) || lllllllllllIllIIlIIlIllIIllllIll.nextFloat() >= 0.6f) && lllllllllllIllIIlIIlIllIIllllIll.nextInt(lllllllllllIllIIlIIlIllIIlllllII + 1) > 0;
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllIllIIlIIlIllIlIIIIIIl) {
        return lllllllllllIllIIlIIlIllIlIIIIIIl.isItemStackDamageable() || super.canApply(lllllllllllIllIIlIIlIllIlIIIIIIl);
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllIllIIlIIlIllIlIIIlIII) {
        return super.getMinEnchantability(lllllllllllIllIIlIIlIllIlIIIlIII) + 50;
    }
    
    protected EnchantmentDurability(final Rarity lllllllllllIllIIlIIlIllIlIIlIIll, final EntityEquipmentSlot... lllllllllllIllIIlIIlIllIlIIlIIlI) {
        super(lllllllllllIllIIlIIlIllIlIIlIIll, EnumEnchantmentType.BREAKABLE, lllllllllllIllIIlIIlIllIlIIlIIlI);
        this.setName("durability");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllIllIIlIIlIllIlIIIllll) {
        return 5 + (lllllllllllIllIIlIIlIllIlIIIllll - 1) * 8;
    }
}
