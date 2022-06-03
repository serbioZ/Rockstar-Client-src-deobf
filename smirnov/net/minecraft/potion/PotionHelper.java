// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.item.ItemFishFood;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.Items;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import com.google.common.base.Predicate;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import java.util.List;

public class PotionHelper
{
    private static final /* synthetic */ List<MixPredicate<Item>> POTION_ITEM_CONVERSIONS;
    private static final /* synthetic */ List<MixPredicate<PotionType>> POTION_TYPE_CONVERSIONS;
    private static final /* synthetic */ List<Ingredient> POTION_ITEMS;
    private static final /* synthetic */ Predicate<ItemStack> IS_POTION_ITEM;
    
    protected static boolean hasItemConversions(final ItemStack lllllllllllIIIIIlIIlIIIlllIlllII, final ItemStack lllllllllllIIIIIlIIlIIIlllIlIlIl) {
        final Item lllllllllllIIIIIlIIlIIIlllIllIlI = lllllllllllIIIIIlIIlIIIlllIlllII.getItem();
        for (int lllllllllllIIIIIlIIlIIIlllIllIIl = 0, lllllllllllIIIIIlIIlIIIlllIllIII = PotionHelper.POTION_ITEM_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIlllIllIIl < lllllllllllIIIIIlIIlIIIlllIllIII; ++lllllllllllIIIIIlIIlIIIlllIllIIl) {
            final MixPredicate<Item> lllllllllllIIIIIlIIlIIIlllIlIlll = PotionHelper.POTION_ITEM_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIlllIllIIl);
            if (lllllllllllIIIIIlIIlIIIlllIlIlll.input == lllllllllllIIIIIlIIlIIIlllIllIlI && lllllllllllIIIIIlIIlIIIlllIlIlll.reagent.apply(lllllllllllIIIIIlIIlIIIlllIlIlIl)) {
                return true;
            }
        }
        return false;
    }
    
    protected static boolean isTypeConversionReagent(final ItemStack lllllllllllIIIIIlIIlIIIllllIlIll) {
        for (int lllllllllllIIIIIlIIlIIIllllIllIl = 0, lllllllllllIIIIIlIIlIIIllllIllII = PotionHelper.POTION_TYPE_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIllllIllIl < lllllllllllIIIIIlIIlIIIllllIllII; ++lllllllllllIIIIIlIIlIIIllllIllIl) {
            if (PotionHelper.POTION_TYPE_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIllllIllIl).reagent.apply(lllllllllllIIIIIlIIlIIIllllIlIll)) {
                return true;
            }
        }
        return false;
    }
    
    public static ItemStack doReaction(final ItemStack lllllllllllIIIIIlIIlIIIllIlIlllI, final ItemStack lllllllllllIIIIIlIIlIIIllIlIllIl) {
        if (!lllllllllllIIIIIlIIlIIIllIlIllIl.func_190926_b()) {
            final PotionType lllllllllllIIIIIlIIlIIIllIllIlIl = PotionUtils.getPotionFromItem(lllllllllllIIIIIlIIlIIIllIlIllIl);
            final Item lllllllllllIIIIIlIIlIIIllIllIlII = lllllllllllIIIIIlIIlIIIllIlIllIl.getItem();
            for (int lllllllllllIIIIIlIIlIIIllIllIIll = 0, lllllllllllIIIIIlIIlIIIllIllIIlI = PotionHelper.POTION_ITEM_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIllIllIIll < lllllllllllIIIIIlIIlIIIllIllIIlI; ++lllllllllllIIIIIlIIlIIIllIllIIll) {
                final MixPredicate<Item> lllllllllllIIIIIlIIlIIIllIllIIIl = PotionHelper.POTION_ITEM_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIllIllIIll);
                if (lllllllllllIIIIIlIIlIIIllIllIIIl.input == lllllllllllIIIIIlIIlIIIllIllIlII && lllllllllllIIIIIlIIlIIIllIllIIIl.reagent.apply(lllllllllllIIIIIlIIlIIIllIlIlllI)) {
                    return PotionUtils.addPotionToItemStack(new ItemStack(lllllllllllIIIIIlIIlIIIllIllIIIl.output), lllllllllllIIIIIlIIlIIIllIllIlIl);
                }
            }
            for (int lllllllllllIIIIIlIIlIIIllIllIIll = 0, lllllllllllIIIIIlIIlIIIllIllIIII = PotionHelper.POTION_TYPE_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIllIllIIll < lllllllllllIIIIIlIIlIIIllIllIIII; ++lllllllllllIIIIIlIIlIIIllIllIIll) {
                final MixPredicate<PotionType> lllllllllllIIIIIlIIlIIIllIlIllll = PotionHelper.POTION_TYPE_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIllIllIIll);
                if (lllllllllllIIIIIlIIlIIIllIlIllll.input == lllllllllllIIIIIlIIlIIIllIllIlIl && lllllllllllIIIIIlIIlIIIllIlIllll.reagent.apply(lllllllllllIIIIIlIIlIIIllIlIlllI)) {
                    return PotionUtils.addPotionToItemStack(new ItemStack(lllllllllllIIIIIlIIlIIIllIllIlII), lllllllllllIIIIIlIIlIIIllIlIllll.output);
                }
            }
        }
        return lllllllllllIIIIIlIIlIIIllIlIllIl;
    }
    
    protected static boolean isItemConversionReagent(final ItemStack lllllllllllIIIIIlIIlIIIlllllIlII) {
        for (int lllllllllllIIIIIlIIlIIIlllllIllI = 0, lllllllllllIIIIIlIIlIIIlllllIlIl = PotionHelper.POTION_ITEM_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIlllllIllI < lllllllllllIIIIIlIIlIIIlllllIlIl; ++lllllllllllIIIIIlIIlIIIlllllIllI) {
            if (PotionHelper.POTION_ITEM_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIlllllIllI).reagent.apply(lllllllllllIIIIIlIIlIIIlllllIlII)) {
                return true;
            }
        }
        return false;
    }
    
    private static void func_193355_a(final ItemPotion lllllllllllIIIIIlIIlIIIllIlIIlII, final Item lllllllllllIIIIIlIIlIIIllIlIIIII, final ItemPotion lllllllllllIIIIIlIIlIIIllIlIIIlI) {
        PotionHelper.POTION_ITEM_CONVERSIONS.add(new MixPredicate<Item>(lllllllllllIIIIIlIIlIIIllIlIIlII, Ingredient.func_193368_a(lllllllllllIIIIIlIIlIIIllIlIIIII), lllllllllllIIIIIlIIlIIIllIlIIIlI));
    }
    
    static {
        POTION_TYPE_CONVERSIONS = Lists.newArrayList();
        POTION_ITEM_CONVERSIONS = Lists.newArrayList();
        POTION_ITEMS = Lists.newArrayList();
        IS_POTION_ITEM = (Predicate)new Predicate<ItemStack>() {
            public boolean apply(final ItemStack llllllllllIlllIlIIIIIlIlIlIlIlll) {
                for (final Ingredient llllllllllIlllIlIIIIIlIlIlIllIII : PotionHelper.POTION_ITEMS) {
                    if (llllllllllIlllIlIIIIIlIlIlIllIII.apply(llllllllllIlllIlIIIIIlIlIlIlIlll)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
    public static boolean isReagent(final ItemStack lllllllllllIIIIIlIIlIIIllllllIll) {
        return isItemConversionReagent(lllllllllllIIIIIlIIlIIIllllllIll) || isTypeConversionReagent(lllllllllllIIIIIlIIlIIIllllllIll);
    }
    
    private static void func_193354_a(final ItemPotion lllllllllllIIIIIlIIlIIIllIIlllII) {
        PotionHelper.POTION_ITEMS.add(Ingredient.func_193368_a(lllllllllllIIIIIlIIlIIIllIIlllII));
    }
    
    private static void func_193357_a(final PotionType lllllllllllIIIIIlIIlIIIllIIlIlIl, final Item lllllllllllIIIIIlIIlIIIllIIlIlll, final PotionType lllllllllllIIIIIlIIlIIIllIIlIIll) {
        func_193356_a(lllllllllllIIIIIlIIlIIIllIIlIlIl, Ingredient.func_193368_a(lllllllllllIIIIIlIIlIIIllIIlIlll), lllllllllllIIIIIlIIlIIIllIIlIIll);
    }
    
    public static void init() {
        func_193354_a(Items.POTIONITEM);
        func_193354_a(Items.SPLASH_POTION);
        func_193354_a(Items.LINGERING_POTION);
        func_193355_a(Items.POTIONITEM, Items.GUNPOWDER, Items.SPLASH_POTION);
        func_193355_a(Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION);
        func_193357_a(PotionTypes.WATER, Items.SPECKLED_MELON, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.GHAST_TEAR, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.RABBIT_FOOT, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.BLAZE_POWDER, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.SPIDER_EYE, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.SUGAR, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.MAGMA_CREAM, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.GLOWSTONE_DUST, PotionTypes.THICK);
        func_193357_a(PotionTypes.WATER, Items.REDSTONE, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.NETHER_WART, PotionTypes.AWKWARD);
        func_193357_a(PotionTypes.AWKWARD, Items.GOLDEN_CARROT, PotionTypes.NIGHT_VISION);
        func_193357_a(PotionTypes.NIGHT_VISION, Items.REDSTONE, PotionTypes.LONG_NIGHT_VISION);
        func_193357_a(PotionTypes.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, PotionTypes.INVISIBILITY);
        func_193357_a(PotionTypes.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_INVISIBILITY);
        func_193357_a(PotionTypes.INVISIBILITY, Items.REDSTONE, PotionTypes.LONG_INVISIBILITY);
        func_193357_a(PotionTypes.AWKWARD, Items.MAGMA_CREAM, PotionTypes.FIRE_RESISTANCE);
        func_193357_a(PotionTypes.FIRE_RESISTANCE, Items.REDSTONE, PotionTypes.LONG_FIRE_RESISTANCE);
        func_193357_a(PotionTypes.AWKWARD, Items.RABBIT_FOOT, PotionTypes.LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.REDSTONE, PotionTypes.LONG_LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.FERMENTED_SPIDER_EYE, PotionTypes.SLOWNESS);
        func_193357_a(PotionTypes.LONG_LEAPING, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.SLOWNESS, Items.REDSTONE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.FERMENTED_SPIDER_EYE, PotionTypes.SLOWNESS);
        func_193357_a(PotionTypes.LONG_SWIFTNESS, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.AWKWARD, Items.SUGAR, PotionTypes.SWIFTNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.REDSTONE, PotionTypes.LONG_SWIFTNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.GLOWSTONE_DUST, PotionTypes.STRONG_SWIFTNESS);
        func_193356_a(PotionTypes.AWKWARD, Ingredient.func_193369_a(new ItemStack(Items.FISH, 1, ItemFishFood.FishType.PUFFERFISH.getMetadata())), PotionTypes.WATER_BREATHING);
        func_193357_a(PotionTypes.WATER_BREATHING, Items.REDSTONE, PotionTypes.LONG_WATER_BREATHING);
        func_193357_a(PotionTypes.AWKWARD, Items.SPECKLED_MELON, PotionTypes.HEALING);
        func_193357_a(PotionTypes.HEALING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_HEALING);
        func_193357_a(PotionTypes.HEALING, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.STRONG_HEALING, Items.FERMENTED_SPIDER_EYE, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.HARMING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.LONG_POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.STRONG_POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.AWKWARD, Items.SPIDER_EYE, PotionTypes.POISON);
        func_193357_a(PotionTypes.POISON, Items.REDSTONE, PotionTypes.LONG_POISON);
        func_193357_a(PotionTypes.POISON, Items.GLOWSTONE_DUST, PotionTypes.STRONG_POISON);
        func_193357_a(PotionTypes.AWKWARD, Items.GHAST_TEAR, PotionTypes.REGENERATION);
        func_193357_a(PotionTypes.REGENERATION, Items.REDSTONE, PotionTypes.LONG_REGENERATION);
        func_193357_a(PotionTypes.REGENERATION, Items.GLOWSTONE_DUST, PotionTypes.STRONG_REGENERATION);
        func_193357_a(PotionTypes.AWKWARD, Items.BLAZE_POWDER, PotionTypes.STRENGTH);
        func_193357_a(PotionTypes.STRENGTH, Items.REDSTONE, PotionTypes.LONG_STRENGTH);
        func_193357_a(PotionTypes.STRENGTH, Items.GLOWSTONE_DUST, PotionTypes.STRONG_STRENGTH);
        func_193357_a(PotionTypes.WATER, Items.FERMENTED_SPIDER_EYE, PotionTypes.WEAKNESS);
        func_193357_a(PotionTypes.WEAKNESS, Items.REDSTONE, PotionTypes.LONG_WEAKNESS);
    }
    
    public static boolean hasConversions(final ItemStack lllllllllllIIIIIlIIlIIIllllIIllI, final ItemStack lllllllllllIIIIIlIIlIIIllllIIIll) {
        return PotionHelper.IS_POTION_ITEM.apply((Object)lllllllllllIIIIIlIIlIIIllllIIllI) && (hasItemConversions(lllllllllllIIIIIlIIlIIIllllIIllI, lllllllllllIIIIIlIIlIIIllllIIIll) || hasTypeConversions(lllllllllllIIIIIlIIlIIIllllIIllI, lllllllllllIIIIIlIIlIIIllllIIIll));
    }
    
    private static void func_193356_a(final PotionType lllllllllllIIIIIlIIlIIIllIIIllll, final Ingredient lllllllllllIIIIIlIIlIIIllIIIlIll, final PotionType lllllllllllIIIIIlIIlIIIllIIIllIl) {
        PotionHelper.POTION_TYPE_CONVERSIONS.add(new MixPredicate<PotionType>(lllllllllllIIIIIlIIlIIIllIIIllll, lllllllllllIIIIIlIIlIIIllIIIlIll, lllllllllllIIIIIlIIlIIIllIIIllIl));
    }
    
    protected static boolean hasTypeConversions(final ItemStack lllllllllllIIIIIlIIlIIIlllIIIlII, final ItemStack lllllllllllIIIIIlIIlIIIlllIIlIIl) {
        final PotionType lllllllllllIIIIIlIIlIIIlllIIlIII = PotionUtils.getPotionFromItem(lllllllllllIIIIIlIIlIIIlllIIIlII);
        for (int lllllllllllIIIIIlIIlIIIlllIIIlll = 0, lllllllllllIIIIIlIIlIIIlllIIIllI = PotionHelper.POTION_TYPE_CONVERSIONS.size(); lllllllllllIIIIIlIIlIIIlllIIIlll < lllllllllllIIIIIlIIlIIIlllIIIllI; ++lllllllllllIIIIIlIIlIIIlllIIIlll) {
            final MixPredicate<PotionType> lllllllllllIIIIIlIIlIIIlllIIIlIl = PotionHelper.POTION_TYPE_CONVERSIONS.get(lllllllllllIIIIIlIIlIIIlllIIIlll);
            if (lllllllllllIIIIIlIIlIIIlllIIIlIl.input == lllllllllllIIIIIlIIlIIIlllIIlIII && lllllllllllIIIIIlIIlIIIlllIIIlIl.reagent.apply(lllllllllllIIIIIlIIlIIIlllIIlIIl)) {
                return true;
            }
        }
        return false;
    }
    
    static class MixPredicate<T>
    {
        final /* synthetic */ Ingredient reagent;
        final /* synthetic */ T input;
        final /* synthetic */ T output;
        
        public MixPredicate(final T lllllllllllIIIllIllIlIIllIllIlIl, final Ingredient lllllllllllIIIllIllIlIIllIlllIII, final T lllllllllllIIIllIllIlIIllIllIlll) {
            this.input = lllllllllllIIIllIllIlIIllIllIlIl;
            this.reagent = lllllllllllIIIllIllIlIIllIlllIII;
            this.output = lllllllllllIIIllIllIlIIllIllIlll;
        }
    }
}
