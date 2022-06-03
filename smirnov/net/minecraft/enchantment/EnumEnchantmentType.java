// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemElytra;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSword;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;

public enum EnumEnchantmentType
{
    ARMOR_LEGS(3) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIlIIlllllIIIIllIlllII) {
            return lllllllllllIlIIlllllIIIIllIlllII instanceof ItemArmor && ((ItemArmor)lllllllllllIlIIlllllIIIIllIlllII).armorType == EntityEquipmentSlot.LEGS;
        }
    }, 
    ALL(0) {
        @Override
        public boolean canEnchantItem(final Item llllllllllIllllIllllIlIllllIlIII) {
            String llllllllllIllllIllllIlIllllIIIlI;
            for (double llllllllllIllllIllllIlIllllIIIll = ((EnumEnchantmentType[])(Object)(llllllllllIllllIllllIlIllllIIIlI = (String)(Object)EnumEnchantmentType.values())).length, llllllllllIllllIllllIlIllllIIlII = 0; llllllllllIllllIllllIlIllllIIlII < llllllllllIllllIllllIlIllllIIIll; ++llllllllllIllllIllllIlIllllIIlII) {
                final EnumEnchantmentType llllllllllIllllIllllIlIllllIIlll = llllllllllIllllIllllIlIllllIIIlI[llllllllllIllllIllllIlIllllIIlII];
                if (llllllllllIllllIllllIlIllllIIlll != EnumEnchantmentType.ALL && llllllllllIllllIllllIlIllllIIlll.canEnchantItem(llllllllllIllllIllllIlIllllIlIII)) {
                    return true;
                }
            }
            return false;
        }
    }, 
    FISHING_ROD(8) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllIIIIllIllllIlllIIlll) {
            return llllllllllllIIIIllIllllIlllIIlll instanceof ItemFishingRod;
        }
    }, 
    ARMOR_HEAD(5) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIIllIIIIIIlllIlIlIllI) {
            return lllllllllllIIllIIIIIIlllIlIlIllI instanceof ItemArmor && ((ItemArmor)lllllllllllIIllIIIIIIlllIlIlIllI).armorType == EntityEquipmentSlot.HEAD;
        }
    }, 
    BREAKABLE(9) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIIlIIIIllIIllIIIIlIll) {
            return lllllllllllIIlIIIIllIIllIIIIlIll.isDamageable();
        }
    }, 
    ARMOR(1) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllIIIIlIIIIIIllIIllIIl) {
            return llllllllllllIIIIlIIIIIIllIIllIIl instanceof ItemArmor;
        }
    }, 
    WEARABLE(11) {
        @Override
        public boolean canEnchantItem(final Item llllllllllIlllIlIllIlIllIlIlIlIl) {
            final boolean llllllllllIlllIlIllIlIllIlIlIllI = llllllllllIlllIlIllIlIllIlIlIlIl instanceof ItemBlock && ((ItemBlock)llllllllllIlllIlIllIlIllIlIlIlIl).getBlock() instanceof BlockPumpkin;
            return llllllllllIlllIlIllIlIllIlIlIlIl instanceof ItemArmor || llllllllllIlllIlIllIlIllIlIlIlIl instanceof ItemElytra || llllllllllIlllIlIllIlIllIlIlIlIl instanceof ItemSkull || llllllllllIlllIlIllIlIllIlIlIllI;
        }
    }, 
    ARMOR_FEET(2) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIllIIlIlllIlIlllllIIl) {
            return lllllllllllIllIIlIlllIlIlllllIIl instanceof ItemArmor && ((ItemArmor)lllllllllllIllIIlIlllIlIlllllIIl).armorType == EntityEquipmentSlot.FEET;
        }
    }, 
    DIGGER(7) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIlIlIIllIlIlIlIIIIlll) {
            return lllllllllllIlIlIIllIlIlIlIIIIlll instanceof ItemTool;
        }
    }, 
    BOW(10) {
        @Override
        public boolean canEnchantItem(final Item llllllllllllIlIIIllllIIlIIIIlIIl) {
            return llllllllllllIlIIIllllIIlIIIIlIIl instanceof ItemBow;
        }
    }, 
    ARMOR_CHEST(4) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIllIIIIllIIlllIlllIlI) {
            return lllllllllllIllIIIIllIIlllIlllIlI instanceof ItemArmor && ((ItemArmor)lllllllllllIllIIIIllIIlllIlllIlI).armorType == EntityEquipmentSlot.CHEST;
        }
    }, 
    WEAPON(6) {
        @Override
        public boolean canEnchantItem(final Item lllllllllllIlIlllIIIlIIlIIIlllIl) {
            return lllllllllllIlIlllIIIlIIlIIIlllIl instanceof ItemSword;
        }
    };
    
    public abstract boolean canEnchantItem(final Item p0);
    
    private EnumEnchantmentType(final String llllllllllllllIIlIlIIIIllIllIIlI, final int llllllllllllllIIlIlIIIIllIllIIIl) {
    }
}
