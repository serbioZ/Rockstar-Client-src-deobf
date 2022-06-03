// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import java.util.Iterator;
import com.google.common.collect.Maps;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Util;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;

public class EnchantmentHelper
{
    private static final /* synthetic */ ModifierLiving ENCHANTMENT_MODIFIER_LIVING;
    private static final /* synthetic */ DamageIterator ENCHANTMENT_ITERATOR_DAMAGE;
    private static final /* synthetic */ HurtIterator ENCHANTMENT_ITERATOR_HURT;
    private static final /* synthetic */ ModifierDamage ENCHANTMENT_MODIFIER_DAMAGE;
    
    public static int getMaxEnchantmentLevel(final Enchantment llllllllllIllllllllIIllIIllIIIIl, final EntityLivingBase llllllllllIllllllllIIllIIllIIIII) {
        final Iterable<ItemStack> llllllllllIllllllllIIllIIllIIlIl = llllllllllIllllllllIIllIIllIIIIl.getEntityEquipment(llllllllllIllllllllIIllIIllIIIII);
        if (llllllllllIllllllllIIllIIllIIlIl == null) {
            return 0;
        }
        int llllllllllIllllllllIIllIIllIIlII = 0;
        for (final ItemStack llllllllllIllllllllIIllIIllIIIll : llllllllllIllllllllIIllIIllIIlIl) {
            final int llllllllllIllllllllIIllIIllIIIlI = getEnchantmentLevel(llllllllllIllllllllIIllIIllIIIIl, llllllllllIllllllllIIllIIllIIIll);
            if (llllllllllIllllllllIIllIIllIIIlI > llllllllllIllllllllIIllIIllIIlII) {
                llllllllllIllllllllIIllIIllIIlII = llllllllllIllllllllIIllIIllIIIlI;
            }
        }
        return llllllllllIllllllllIIllIIllIIlII;
    }
    
    public static boolean func_190938_b(final ItemStack llllllllllIllllllllIIllIIIlllIll) {
        return getEnchantmentLevel(Enchantments.field_190941_k, llllllllllIllllllllIIllIIIlllIll) > 0;
    }
    
    public static List<EnchantmentData> buildEnchantmentList(final Random llllllllllIllllllllIIlIlllllIIII, final ItemStack llllllllllIllllllllIIlIllllIllll, int llllllllllIllllllllIIlIllllIIlIl, final boolean llllllllllIllllllllIIlIllllIllIl) {
        final List<EnchantmentData> llllllllllIllllllllIIlIllllIllII = (List<EnchantmentData>)Lists.newArrayList();
        final Item llllllllllIllllllllIIlIllllIlIll = llllllllllIllllllllIIlIllllIllll.getItem();
        final int llllllllllIllllllllIIlIllllIlIlI = llllllllllIllllllllIIlIllllIlIll.getItemEnchantability();
        if (llllllllllIllllllllIIlIllllIlIlI <= 0) {
            return llllllllllIllllllllIIlIllllIllII;
        }
        llllllllllIllllllllIIlIllllIIlIl = llllllllllIllllllllIIlIllllIIlIl + 1 + llllllllllIllllllllIIlIlllllIIII.nextInt(llllllllllIllllllllIIlIllllIlIlI / 4 + 1) + llllllllllIllllllllIIlIlllllIIII.nextInt(llllllllllIllllllllIIlIllllIlIlI / 4 + 1);
        final float llllllllllIllllllllIIlIllllIlIIl = (llllllllllIllllllllIIlIlllllIIII.nextFloat() + llllllllllIllllllllIIlIlllllIIII.nextFloat() - 1.0f) * 0.15f;
        llllllllllIllllllllIIlIllllIIlIl = MathHelper.clamp(Math.round(llllllllllIllllllllIIlIllllIIlIl + llllllllllIllllllllIIlIllllIIlIl * llllllllllIllllllllIIlIllllIlIIl), 1, Integer.MAX_VALUE);
        final List<EnchantmentData> llllllllllIllllllllIIlIllllIlIII = getEnchantmentDatas(llllllllllIllllllllIIlIllllIIlIl, llllllllllIllllllllIIlIllllIllll, llllllllllIllllllllIIlIllllIllIl);
        if (!llllllllllIllllllllIIlIllllIlIII.isEmpty()) {
            llllllllllIllllllllIIlIllllIllII.add(WeightedRandom.getRandomItem(llllllllllIllllllllIIlIlllllIIII, llllllllllIllllllllIIlIllllIlIII));
            while (llllllllllIllllllllIIlIlllllIIII.nextInt(50) <= llllllllllIllllllllIIlIllllIIlIl) {
                removeIncompatible(llllllllllIllllllllIIlIllllIlIII, Util.getLastElement(llllllllllIllllllllIIlIllllIllII));
                if (llllllllllIllllllllIIlIllllIlIII.isEmpty()) {
                    break;
                }
                llllllllllIllllllllIIlIllllIllII.add(WeightedRandom.getRandomItem(llllllllllIllllllllIIlIlllllIIII, llllllllllIllllllllIIlIllllIlIII));
                llllllllllIllllllllIIlIllllIIlIl /= 2;
            }
        }
        return llllllllllIllllllllIIlIllllIllII;
    }
    
    public static boolean func_190939_c(final ItemStack llllllllllIllllllllIIllIIIllIlll) {
        return getEnchantmentLevel(Enchantments.field_190940_C, llllllllllIllllllllIIllIIIllIlll) > 0;
    }
    
    public static int getDepthStriderModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIlIIII) {
        return getMaxEnchantmentLevel(Enchantments.DEPTH_STRIDER, llllllllllIllllllllIIllIIlIlIIII);
    }
    
    public static int getLootingModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIIIlII) {
        return getMaxEnchantmentLevel(Enchantments.LOOTING, llllllllllIllllllllIIllIIlIIIlII);
    }
    
    public static void applyThornEnchantments(final EntityLivingBase llllllllllIllllllllIIllIIllllIII, final Entity llllllllllIllllllllIIllIIlllIlIl) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.attacker = llllllllllIllllllllIIllIIlllIlIl;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT.user = llllllllllIllllllllIIllIIllllIII;
        if (llllllllllIllllllllIIllIIllllIII != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT, llllllllllIllllllllIIllIIllllIII.getEquipmentAndArmor());
        }
        if (llllllllllIllllllllIIllIIlllIlIl instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_ITERATOR_HURT, llllllllllIllllllllIIllIIllllIII.getHeldItemMainhand());
        }
    }
    
    public static int calcItemStackEnchantability(final Random llllllllllIllllllllIIllIIIIlIlll, final int llllllllllIllllllllIIllIIIIlllIl, int llllllllllIllllllllIIllIIIIlIlIl, final ItemStack llllllllllIllllllllIIllIIIIllIll) {
        final Item llllllllllIllllllllIIllIIIIllIlI = llllllllllIllllllllIIllIIIIllIll.getItem();
        final int llllllllllIllllllllIIllIIIIllIIl = llllllllllIllllllllIIllIIIIllIlI.getItemEnchantability();
        if (llllllllllIllllllllIIllIIIIllIIl <= 0) {
            return 0;
        }
        if (llllllllllIllllllllIIllIIIIlIlIl > 15) {
            llllllllllIllllllllIIllIIIIlIlIl = 15;
        }
        final int llllllllllIllllllllIIllIIIIllIII = (int)(llllllllllIllllllllIIllIIIIlIlll.nextInt(8) + 1 + (llllllllllIllllllllIIllIIIIlIlIl >> 1) + llllllllllIllllllllIIllIIIIlIlll.nextInt((int)(llllllllllIllllllllIIllIIIIlIlIl + 1)));
        if (llllllllllIllllllllIIllIIIIlllIl == 0) {
            return Math.max(llllllllllIllllllllIIllIIIIllIII / 3, 1);
        }
        return (llllllllllIllllllllIIllIIIIlllIl == 1) ? (llllllllllIllllllllIIllIIIIllIII * 2 / 3 + 1) : Math.max(llllllllllIllllllllIIllIIIIllIII, (int)(llllllllllIllllllllIIllIIIIlIlIl * 2));
    }
    
    public static ItemStack getEnchantedItem(final Enchantment llllllllllIllllllllIIllIIIllIIII, final EntityLivingBase llllllllllIllllllllIIllIIIlIlIlI) {
        final List<ItemStack> llllllllllIllllllllIIllIIIlIlllI = llllllllllIllllllllIIllIIIllIIII.getEntityEquipment(llllllllllIllllllllIIllIIIlIlIlI);
        if (llllllllllIllllllllIIllIIIlIlllI.isEmpty()) {
            return ItemStack.field_190927_a;
        }
        final List<ItemStack> llllllllllIllllllllIIllIIIlIllIl = (List<ItemStack>)Lists.newArrayList();
        for (final ItemStack llllllllllIllllllllIIllIIIlIllII : llllllllllIllllllllIIllIIIlIlllI) {
            if (!llllllllllIllllllllIIllIIIlIllII.func_190926_b() && getEnchantmentLevel(llllllllllIllllllllIIllIIIllIIII, llllllllllIllllllllIIllIIIlIllII) > 0) {
                llllllllllIllllllllIIllIIIlIllIl.add(llllllllllIllllllllIIllIIIlIllII);
            }
        }
        return llllllllllIllllllllIIllIIIlIllIl.isEmpty() ? ItemStack.field_190927_a : llllllllllIllllllllIIllIIIlIllIl.get(llllllllllIllllllllIIllIIIlIlIlI.getRNG().nextInt(llllllllllIllllllllIIllIIIlIllIl.size()));
    }
    
    public static void setEnchantments(final Map<Enchantment, Integer> llllllllllIllllllllIIllIlIlllIII, final ItemStack llllllllllIllllllllIIllIlIllIlll) {
        final NBTTagList llllllllllIllllllllIIllIlIllIllI = new NBTTagList();
        for (final Map.Entry<Enchantment, Integer> llllllllllIllllllllIIllIlIllIlIl : llllllllllIllllllllIIllIlIlllIII.entrySet()) {
            final Enchantment llllllllllIllllllllIIllIlIllIlII = llllllllllIllllllllIIllIlIllIlIl.getKey();
            if (llllllllllIllllllllIIllIlIllIlII != null) {
                final int llllllllllIllllllllIIllIlIllIIll = llllllllllIllllllllIIllIlIllIlIl.getValue();
                final NBTTagCompound llllllllllIllllllllIIllIlIllIIlI = new NBTTagCompound();
                llllllllllIllllllllIIllIlIllIIlI.setShort("id", (short)Enchantment.getEnchantmentID(llllllllllIllllllllIIllIlIllIlII));
                llllllllllIllllllllIIllIlIllIIlI.setShort("lvl", (short)llllllllllIllllllllIIllIlIllIIll);
                llllllllllIllllllllIIllIlIllIllI.appendTag(llllllllllIllllllllIIllIlIllIIlI);
                if (llllllllllIllllllllIIllIlIllIlll.getItem() != Items.ENCHANTED_BOOK) {
                    continue;
                }
                ItemEnchantedBook.addEnchantment(llllllllllIllllllllIIllIlIllIlll, new EnchantmentData(llllllllllIllllllllIIllIlIllIlII, llllllllllIllllllllIIllIlIllIIll));
            }
        }
        if (llllllllllIllllllllIIllIlIllIllI.hasNoTags()) {
            if (llllllllllIllllllllIIllIlIllIlll.hasTagCompound()) {
                llllllllllIllllllllIIllIlIllIlll.getTagCompound().removeTag("ench");
            }
        }
        else if (llllllllllIllllllllIIllIlIllIlll.getItem() != Items.ENCHANTED_BOOK) {
            llllllllllIllllllllIIllIlIllIlll.setTagInfo("ench", llllllllllIllllllllIIllIlIllIllI);
        }
    }
    
    private static void applyEnchantmentModifier(final IModifier llllllllllIllllllllIIllIlIIlllIl, final ItemStack llllllllllIllllllllIIllIlIlIIIlI) {
        if (!llllllllllIllllllllIIllIlIlIIIlI.func_190926_b()) {
            final NBTTagList llllllllllIllllllllIIllIlIlIIIIl = llllllllllIllllllllIIllIlIlIIIlI.getEnchantmentTagList();
            for (int llllllllllIllllllllIIllIlIlIIIII = 0; llllllllllIllllllllIIllIlIlIIIII < llllllllllIllllllllIIllIlIlIIIIl.tagCount(); ++llllllllllIllllllllIIllIlIlIIIII) {
                final int llllllllllIllllllllIIllIlIIlllll = llllllllllIllllllllIIllIlIlIIIIl.getCompoundTagAt(llllllllllIllllllllIIllIlIlIIIII).getShort("id");
                final int llllllllllIllllllllIIllIlIIllllI = llllllllllIllllllllIIllIlIlIIIIl.getCompoundTagAt(llllllllllIllllllllIIllIlIlIIIII).getShort("lvl");
                if (Enchantment.getEnchantmentByID(llllllllllIllllllllIIllIlIIlllll) != null) {
                    llllllllllIllllllllIIllIlIIlllIl.calculateModifier(Enchantment.getEnchantmentByID(llllllllllIllllllllIIllIlIIlllll), llllllllllIllllllllIIllIlIIllllI);
                }
            }
        }
    }
    
    public static float getModifierForCreature(final ItemStack llllllllllIllllllllIIllIlIIIIIlI, final EnumCreatureAttribute llllllllllIllllllllIIllIlIIIIIll) {
        EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.livingModifier = 0.0f;
        EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.entityLiving = llllllllllIllllllllIIllIlIIIIIll;
        applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING, llllllllllIllllllllIIllIlIIIIIlI);
        return EnchantmentHelper.ENCHANTMENT_MODIFIER_LIVING.livingModifier;
    }
    
    public static boolean hasFrostWalkerEnchantment(final EntityLivingBase llllllllllIllllllllIIllIIIllllIl) {
        return getMaxEnchantmentLevel(Enchantments.FROST_WALKER, llllllllllIllllllllIIllIIIllllIl) > 0;
    }
    
    public static void applyArthropodEnchantments(final EntityLivingBase llllllllllIllllllllIIllIIlllIIlI, final Entity llllllllllIllllllllIIllIIlllIIIl) {
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.user = llllllllllIllllllllIIllIIlllIIlI;
        EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE.target = llllllllllIllllllllIIllIIlllIIIl;
        if (llllllllllIllllllllIIllIIlllIIlI != null) {
            applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE, llllllllllIllllllllIIllIIlllIIlI.getEquipmentAndArmor());
        }
        if (llllllllllIllllllllIIllIIlllIIlI instanceof EntityPlayer) {
            applyEnchantmentModifier(EnchantmentHelper.ENCHANTMENT_ITERATOR_DAMAGE, llllllllllIllllllllIIllIIlllIIlI.getHeldItemMainhand());
        }
    }
    
    public static int getEnchantmentLevel(final Enchantment llllllllllIllllllllIIllIllIlllII, final ItemStack llllllllllIllllllllIIllIllIllIll) {
        if (llllllllllIllllllllIIllIllIllIll.func_190926_b()) {
            return 0;
        }
        final NBTTagList llllllllllIllllllllIIllIlllIIIIl = llllllllllIllllllllIIllIllIllIll.getEnchantmentTagList();
        for (int llllllllllIllllllllIIllIlllIIIII = 0; llllllllllIllllllllIIllIlllIIIII < llllllllllIllllllllIIllIlllIIIIl.tagCount(); ++llllllllllIllllllllIIllIlllIIIII) {
            final NBTTagCompound llllllllllIllllllllIIllIllIlllll = llllllllllIllllllllIIllIlllIIIIl.getCompoundTagAt(llllllllllIllllllllIIllIlllIIIII);
            final Enchantment llllllllllIllllllllIIllIllIllllI = Enchantment.getEnchantmentByID(llllllllllIllllllllIIllIllIlllll.getShort("id"));
            final int llllllllllIllllllllIIllIllIlllIl = llllllllllIllllllllIIllIllIlllll.getShort("lvl");
            if (llllllllllIllllllllIIllIllIllllI == llllllllllIllllllllIIllIllIlllII) {
                return llllllllllIllllllllIIllIllIlllIl;
            }
        }
        return 0;
    }
    
    public static List<EnchantmentData> getEnchantmentDatas(final int llllllllllIllllllllIIlIlllIIIlII, final ItemStack llllllllllIllllllllIIlIlllIIlIll, final boolean llllllllllIllllllllIIlIlllIIIIlI) {
        final List<EnchantmentData> llllllllllIllllllllIIlIlllIIlIIl = (List<EnchantmentData>)Lists.newArrayList();
        final Item llllllllllIllllllllIIlIlllIIlIII = llllllllllIllllllllIIlIlllIIlIll.getItem();
        final boolean llllllllllIllllllllIIlIlllIIIlll = llllllllllIllllllllIIlIlllIIlIll.getItem() == Items.BOOK;
        for (final Enchantment llllllllllIllllllllIIlIlllIIIllI : Enchantment.REGISTRY) {
            if ((!llllllllllIllllllllIIlIlllIIIllI.isTreasureEnchantment() || llllllllllIllllllllIIlIlllIIIIlI) && (llllllllllIllllllllIIlIlllIIIllI.type.canEnchantItem(llllllllllIllllllllIIlIlllIIlIII) || llllllllllIllllllllIIlIlllIIIlll)) {
                for (int llllllllllIllllllllIIlIlllIIIlIl = llllllllllIllllllllIIlIlllIIIllI.getMaxLevel(); llllllllllIllllllllIIlIlllIIIlIl > llllllllllIllllllllIIlIlllIIIllI.getMinLevel() - 1; --llllllllllIllllllllIIlIlllIIIlIl) {
                    if (llllllllllIllllllllIIlIlllIIIlII >= llllllllllIllllllllIIlIlllIIIllI.getMinEnchantability(llllllllllIllllllllIIlIlllIIIlIl) && llllllllllIllllllllIIlIlllIIIlII <= llllllllllIllllllllIIlIlllIIIllI.getMaxEnchantability(llllllllllIllllllllIIlIlllIIIlIl)) {
                        llllllllllIllllllllIIlIlllIIlIIl.add(new EnchantmentData(llllllllllIllllllllIIlIlllIIIllI, llllllllllIllllllllIIlIlllIIIlIl));
                        break;
                    }
                }
            }
        }
        return llllllllllIllllllllIIlIlllIIlIIl;
    }
    
    public static float func_191527_a(final EntityLivingBase llllllllllIllllllllIIllIIllllllI) {
        final int llllllllllIllllllllIIllIIlllllIl = getMaxEnchantmentLevel(Enchantments.field_191530_r, llllllllllIllllllllIIllIIllllllI);
        return (llllllllllIllllllllIIllIIlllllIl > 0) ? EnchantmentSweepingEdge.func_191526_e(llllllllllIllllllllIIllIIlllllIl) : 0.0f;
    }
    
    private static void applyEnchantmentModifierArray(final IModifier llllllllllIllllllllIIllIlIIlIIll, final Iterable<ItemStack> llllllllllIllllllllIIllIlIIIllll) {
        for (final ItemStack llllllllllIllllllllIIllIlIIlIIIl : llllllllllIllllllllIIllIlIIIllll) {
            applyEnchantmentModifier(llllllllllIllllllllIIllIlIIlIIll, llllllllllIllllllllIIllIlIIlIIIl);
        }
    }
    
    public static int getEfficiencyModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIIllIl) {
        return getMaxEnchantmentLevel(Enchantments.EFFICIENCY, llllllllllIllllllllIIllIIlIIllIl);
    }
    
    public static int getEnchantmentModifierDamage(final Iterable<ItemStack> llllllllllIllllllllIIllIlIIIlIlI, final DamageSource llllllllllIllllllllIIllIlIIIIlll) {
        EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.damageModifier = 0;
        EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.source = llllllllllIllllllllIIllIlIIIIlll;
        applyEnchantmentModifierArray(EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE, llllllllllIllllllllIIllIlIIIlIlI);
        return EnchantmentHelper.ENCHANTMENT_MODIFIER_DAMAGE.damageModifier;
    }
    
    public static int getKnockbackModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIllIIl) {
        return getMaxEnchantmentLevel(Enchantments.KNOCKBACK, llllllllllIllllllllIIllIIlIllIIl);
    }
    
    public static Map<Enchantment, Integer> getEnchantments(final ItemStack llllllllllIllllllllIIllIllIIIlll) {
        final Map<Enchantment, Integer> llllllllllIllllllllIIllIllIIllIl = (Map<Enchantment, Integer>)Maps.newLinkedHashMap();
        final NBTTagList llllllllllIllllllllIIllIllIIllII = (llllllllllIllllllllIIllIllIIIlll.getItem() == Items.ENCHANTED_BOOK) ? ItemEnchantedBook.getEnchantments(llllllllllIllllllllIIllIllIIIlll) : llllllllllIllllllllIIllIllIIIlll.getEnchantmentTagList();
        for (int llllllllllIllllllllIIllIllIIlIll = 0; llllllllllIllllllllIIllIllIIlIll < llllllllllIllllllllIIllIllIIllII.tagCount(); ++llllllllllIllllllllIIllIllIIlIll) {
            final NBTTagCompound llllllllllIllllllllIIllIllIIlIlI = llllllllllIllllllllIIllIllIIllII.getCompoundTagAt(llllllllllIllllllllIIllIllIIlIll);
            final Enchantment llllllllllIllllllllIIllIllIIlIIl = Enchantment.getEnchantmentByID(llllllllllIllllllllIIllIllIIlIlI.getShort("id"));
            final int llllllllllIllllllllIIllIllIIlIII = llllllllllIllllllllIIllIllIIlIlI.getShort("lvl");
            llllllllllIllllllllIIllIllIIllIl.put(llllllllllIllllllllIIllIllIIlIIl, llllllllllIllllllllIIllIllIIlIII);
        }
        return llllllllllIllllllllIIllIllIIllIl;
    }
    
    public static int func_191529_b(final ItemStack llllllllllIllllllllIIllIIlIIlIIl) {
        return getEnchantmentLevel(Enchantments.LUCK_OF_THE_SEA, llllllllllIllllllllIIllIIlIIlIIl);
    }
    
    public static int func_191528_c(final ItemStack llllllllllIllllllllIIllIIlIIIlll) {
        return getEnchantmentLevel(Enchantments.LURE, llllllllllIllllllllIIllIIlIIIlll);
    }
    
    public static int getFireAspectModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIlIllI) {
        return getMaxEnchantmentLevel(Enchantments.FIRE_ASPECT, llllllllllIllllllllIIllIIlIlIllI);
    }
    
    static {
        ENCHANTMENT_MODIFIER_DAMAGE = new ModifierDamage(null);
        ENCHANTMENT_MODIFIER_LIVING = new ModifierLiving(null);
        ENCHANTMENT_ITERATOR_HURT = new HurtIterator(null);
        ENCHANTMENT_ITERATOR_DAMAGE = new DamageIterator(null);
    }
    
    public static boolean getAquaAffinityModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIIIIIl) {
        return getMaxEnchantmentLevel(Enchantments.AQUA_AFFINITY, llllllllllIllllllllIIllIIlIIIIIl) > 0;
    }
    
    public static void removeIncompatible(final List<EnchantmentData> llllllllllIllllllllIIlIlllIllIll, final EnchantmentData llllllllllIllllllllIIlIlllIllIlI) {
        final Iterator<EnchantmentData> llllllllllIllllllllIIlIlllIllIIl = llllllllllIllllllllIIlIlllIllIll.iterator();
        while (llllllllllIllllllllIIlIlllIllIIl.hasNext()) {
            if (!llllllllllIllllllllIIlIlllIllIlI.enchantmentobj.func_191560_c(llllllllllIllllllllIIlIlllIllIIl.next().enchantmentobj)) {
                llllllllllIllllllllIIlIlllIllIIl.remove();
            }
        }
    }
    
    public static ItemStack addRandomEnchantment(final Random llllllllllIllllllllIIllIIIIIIIIl, ItemStack llllllllllIllllllllIIllIIIIIIIII, final int llllllllllIllllllllIIlIlllllllll, final boolean llllllllllIllllllllIIllIIIIIIlIl) {
        final List<EnchantmentData> llllllllllIllllllllIIllIIIIIIlII = buildEnchantmentList(llllllllllIllllllllIIllIIIIIIIIl, llllllllllIllllllllIIllIIIIIIIII, llllllllllIllllllllIIlIlllllllll, llllllllllIllllllllIIllIIIIIIlIl);
        final boolean llllllllllIllllllllIIllIIIIIIIll = llllllllllIllllllllIIllIIIIIIIII.getItem() == Items.BOOK;
        if (llllllllllIllllllllIIllIIIIIIIll) {
            llllllllllIllllllllIIllIIIIIIIII = new ItemStack(Items.ENCHANTED_BOOK);
        }
        for (final EnchantmentData llllllllllIllllllllIIllIIIIIIIlI : llllllllllIllllllllIIllIIIIIIlII) {
            if (llllllllllIllllllllIIllIIIIIIIll) {
                ItemEnchantedBook.addEnchantment(llllllllllIllllllllIIllIIIIIIIII, llllllllllIllllllllIIllIIIIIIIlI);
            }
            else {
                llllllllllIllllllllIIllIIIIIIIII.addEnchantment(llllllllllIllllllllIIllIIIIIIIlI.enchantmentobj, llllllllllIllllllllIIllIIIIIIIlI.enchantmentLevel);
            }
        }
        return llllllllllIllllllllIIllIIIIIIIII;
    }
    
    public static int getRespirationModifier(final EntityLivingBase llllllllllIllllllllIIllIIlIlIIlI) {
        return getMaxEnchantmentLevel(Enchantments.RESPIRATION, llllllllllIllllllllIIllIIlIlIIlI);
    }
    
    static final class HurtIterator implements IModifier
    {
        public /* synthetic */ Entity attacker;
        public /* synthetic */ EntityLivingBase user;
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllIIllIlIlllllIlIIIIIl, final int llllllllllllIIllIlIlllllIIllllIl) {
            llllllllllllIIllIlIlllllIlIIIIIl.onUserHurt(this.user, this.attacker, llllllllllllIIllIlIlllllIIllllIl);
        }
        
        private HurtIterator() {
        }
    }
    
    interface IModifier
    {
        void calculateModifier(final Enchantment p0, final int p1);
    }
    
    static final class ModifierLiving implements IModifier
    {
        public /* synthetic */ float livingModifier;
        public /* synthetic */ EnumCreatureAttribute entityLiving;
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllllllIIIIlIIlIIIlIIll, final int llllllllllllllllIIIIlIIlIIIlIlIl) {
            this.livingModifier += llllllllllllllllIIIIlIIlIIIlIIll.calcDamageByCreature(llllllllllllllllIIIIlIIlIIIlIlIl, this.entityLiving);
        }
        
        private ModifierLiving() {
        }
    }
    
    static final class ModifierDamage implements IModifier
    {
        public /* synthetic */ int damageModifier;
        public /* synthetic */ DamageSource source;
        
        @Override
        public void calculateModifier(final Enchantment lllllllllllIlllIIIIllIIllllllIll, final int lllllllllllIlllIIIIllIIlllllIlll) {
            this.damageModifier += lllllllllllIlllIIIIllIIllllllIll.calcModifierDamage(lllllllllllIlllIIIIllIIlllllIlll, this.source);
        }
        
        private ModifierDamage() {
        }
    }
    
    static final class DamageIterator implements IModifier
    {
        public /* synthetic */ EntityLivingBase user;
        public /* synthetic */ Entity target;
        
        @Override
        public void calculateModifier(final Enchantment llllllllllllIIIIlIlIlIlIllIIIlII, final int llllllllllllIIIIlIlIlIlIllIIIllI) {
            llllllllllllIIIIlIlIlIlIllIIIlII.onEntityDamaged(this.user, this.target, llllllllllllIIIIlIlIlIlIllIIIllI);
        }
        
        private DamageIterator() {
        }
    }
}
