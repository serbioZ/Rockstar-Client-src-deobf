// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.util.ResourceLocation;
import optifine.CustomColors;
import optifine.Config;
import net.minecraft.nbt.NBTBase;
import com.google.common.base.MoreObjects;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Tuple;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import java.util.Map;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.ItemStack;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.init.PotionTypes;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;

public class PotionUtils
{
    public static PotionType getPotionTypeFromNBT(@Nullable final NBTTagCompound llllllllllIlllIlllIllIIllllIlIIl) {
        return (llllllllllIlllIlllIllIIllllIlIIl == null) ? PotionTypes.EMPTY : PotionType.getPotionTypeForName(llllllllllIlllIlllIllIIllllIlIIl.getString("Potion"));
    }
    
    public static List<PotionEffect> getEffectsFromTag(@Nullable final NBTTagCompound llllllllllIlllIlllIllIlIIIllIIII) {
        final List<PotionEffect> llllllllllIlllIlllIllIlIIIllIIIl = (List<PotionEffect>)Lists.newArrayList();
        llllllllllIlllIlllIllIlIIIllIIIl.addAll(getPotionTypeFromNBT(llllllllllIlllIlllIllIlIIIllIIII).getEffects());
        addCustomPotionEffectToList(llllllllllIlllIlllIllIlIIIllIIII, llllllllllIlllIlllIllIlIIIllIIIl);
        return llllllllllIlllIlllIllIlIIIllIIIl;
    }
    
    public static List<PotionEffect> getEffectsFromStack(final ItemStack llllllllllIlllIlllIllIlIIIllllll) {
        return getEffectsFromTag(llllllllllIlllIlllIllIlIIIllllll.getTagCompound());
    }
    
    public static void addPotionTooltip(final ItemStack llllllllllIlllIlllIllIIllIlIlIIl, final List<String> llllllllllIlllIlllIllIIllIlllIlI, final float llllllllllIlllIlllIllIIllIlIIlll) {
        final List<PotionEffect> llllllllllIlllIlllIllIIllIlllIII = getEffectsFromStack(llllllllllIlllIlllIllIIllIlIlIIl);
        final List<Tuple<String, AttributeModifier>> llllllllllIlllIlllIllIIllIllIlll = (List<Tuple<String, AttributeModifier>>)Lists.newArrayList();
        if (llllllllllIlllIlllIllIIllIlllIII.isEmpty()) {
            final String llllllllllIlllIlllIllIIllIllIllI = I18n.translateToLocal("effect.none").trim();
            llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.GRAY + llllllllllIlllIlllIllIIllIllIllI);
        }
        else {
            for (final PotionEffect llllllllllIlllIlllIllIIllIllIlIl : llllllllllIlllIlllIllIIllIlllIII) {
                String llllllllllIlllIlllIllIIllIllIlII = I18n.translateToLocal(llllllllllIlllIlllIllIIllIllIlIl.getEffectName()).trim();
                final Potion llllllllllIlllIlllIllIIllIllIIll = llllllllllIlllIlllIllIIllIllIlIl.getPotion();
                final Map<IAttribute, AttributeModifier> llllllllllIlllIlllIllIIllIllIIlI = llllllllllIlllIlllIllIIllIllIIll.getAttributeModifierMap();
                if (!llllllllllIlllIlllIllIIllIllIIlI.isEmpty()) {
                    for (final Map.Entry<IAttribute, AttributeModifier> llllllllllIlllIlllIllIIllIllIIIl : llllllllllIlllIlllIllIIllIllIIlI.entrySet()) {
                        final AttributeModifier llllllllllIlllIlllIllIIllIllIIII = llllllllllIlllIlllIllIIllIllIIIl.getValue();
                        final AttributeModifier llllllllllIlllIlllIllIIllIlIllll = new AttributeModifier(llllllllllIlllIlllIllIIllIllIIII.getName(), llllllllllIlllIlllIllIIllIllIIll.getAttributeModifierAmount(llllllllllIlllIlllIllIIllIllIlIl.getAmplifier(), llllllllllIlllIlllIllIIllIllIIII), llllllllllIlllIlllIllIIllIllIIII.getOperation());
                        llllllllllIlllIlllIllIIllIllIlll.add(new Tuple<String, AttributeModifier>(llllllllllIlllIlllIllIIllIllIIIl.getKey().getAttributeUnlocalizedName(), llllllllllIlllIlllIllIIllIlIllll));
                    }
                }
                if (llllllllllIlllIlllIllIIllIllIlIl.getAmplifier() > 0) {
                    llllllllllIlllIlllIllIIllIllIlII = String.valueOf(llllllllllIlllIlllIllIIllIllIlII) + " " + I18n.translateToLocal("potion.potency." + llllllllllIlllIlllIllIIllIllIlIl.getAmplifier()).trim();
                }
                if (llllllllllIlllIlllIllIIllIllIlIl.getDuration() > 20) {
                    llllllllllIlllIlllIllIIllIllIlII = String.valueOf(llllllllllIlllIlllIllIIllIllIlII) + " (" + Potion.getPotionDurationString(llllllllllIlllIlllIllIIllIllIlIl, llllllllllIlllIlllIllIIllIlIIlll) + ")";
                }
                if (llllllllllIlllIlllIllIIllIllIIll.isBadEffect()) {
                    llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.RED + llllllllllIlllIlllIllIIllIllIlII);
                }
                else {
                    llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.BLUE + llllllllllIlllIlllIllIIllIllIlII);
                }
            }
        }
        if (!llllllllllIlllIlllIllIIllIllIlll.isEmpty()) {
            llllllllllIlllIlllIllIIllIlllIlI.add("");
            llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.DARK_PURPLE + I18n.translateToLocal("potion.whenDrank"));
            for (final Tuple<String, AttributeModifier> llllllllllIlllIlllIllIIllIlIlllI : llllllllllIlllIlllIllIIllIllIlll) {
                final AttributeModifier llllllllllIlllIlllIllIIllIlIllIl = llllllllllIlllIlllIllIIllIlIlllI.getSecond();
                final double llllllllllIlllIlllIllIIllIlIllII = llllllllllIlllIlllIllIIllIlIllIl.getAmount();
                double llllllllllIlllIlllIllIIllIlIlIlI = 0.0;
                if (llllllllllIlllIlllIllIIllIlIllIl.getOperation() != 1 && llllllllllIlllIlllIllIIllIlIllIl.getOperation() != 2) {
                    final double llllllllllIlllIlllIllIIllIlIlIll = llllllllllIlllIlllIllIIllIlIllIl.getAmount();
                }
                else {
                    llllllllllIlllIlllIllIIllIlIlIlI = llllllllllIlllIlllIllIIllIlIllIl.getAmount() * 100.0;
                }
                if (llllllllllIlllIlllIllIIllIlIllII > 0.0) {
                    llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.BLUE + I18n.translateToLocalFormatted("attribute.modifier.plus." + llllllllllIlllIlllIllIIllIlIllIl.getOperation(), ItemStack.DECIMALFORMAT.format(llllllllllIlllIlllIllIIllIlIlIlI), I18n.translateToLocal("attribute.name." + llllllllllIlllIlllIllIIllIlIlllI.getFirst())));
                }
                else {
                    if (llllllllllIlllIlllIllIIllIlIllII >= 0.0) {
                        continue;
                    }
                    llllllllllIlllIlllIllIIllIlIlIlI *= -1.0;
                    llllllllllIlllIlllIllIIllIlllIlI.add(TextFormatting.RED + I18n.translateToLocalFormatted("attribute.modifier.take." + llllllllllIlllIlllIllIIllIlIllIl.getOperation(), ItemStack.DECIMALFORMAT.format(llllllllllIlllIlllIllIIllIlIlIlI), I18n.translateToLocal("attribute.name." + llllllllllIlllIlllIllIIllIlIlllI.getFirst())));
                }
            }
        }
    }
    
    public static PotionType getPotionFromItem(final ItemStack llllllllllIlllIlllIllIIllllIlIll) {
        return getPotionTypeFromNBT(llllllllllIlllIlllIllIIllllIlIll.getTagCompound());
    }
    
    public static int func_190932_c(final ItemStack llllllllllIlllIlllIllIlIIIIIllll) {
        final NBTTagCompound llllllllllIlllIlllIllIlIIIIlIIII = llllllllllIlllIlllIllIlIIIIIllll.getTagCompound();
        if (llllllllllIlllIlllIllIlIIIIlIIII != null && llllllllllIlllIlllIllIlIIIIlIIII.hasKey("CustomPotionColor", 99)) {
            return llllllllllIlllIlllIllIlIIIIlIIII.getInteger("CustomPotionColor");
        }
        return (getPotionFromItem(llllllllllIlllIlllIllIlIIIIIllll) == PotionTypes.EMPTY) ? 16253176 : getPotionColorFromEffectList(getEffectsFromStack(llllllllllIlllIlllIllIlIIIIIllll));
    }
    
    public static List<PotionEffect> getFullEffectsFromItem(final ItemStack llllllllllIlllIlllIllIlIIIlIllIl) {
        return getFullEffectsFromTag(llllllllllIlllIlllIllIlIIIlIllIl.getTagCompound());
    }
    
    public static List<PotionEffect> mergeEffects(final PotionType llllllllllIlllIlllIllIlIIIllIlll, final Collection<PotionEffect> llllllllllIlllIlllIllIlIIIlllIIl) {
        final List<PotionEffect> llllllllllIlllIlllIllIlIIIlllIII = (List<PotionEffect>)Lists.newArrayList();
        llllllllllIlllIlllIllIlIIIlllIII.addAll(llllllllllIlllIlllIllIlIIIllIlll.getEffects());
        llllllllllIlllIlllIllIlIIIlllIII.addAll(llllllllllIlllIlllIllIlIIIlllIIl);
        return llllllllllIlllIlllIllIlIIIlllIII;
    }
    
    public static int getPotionColor(final PotionType llllllllllIlllIlllIllIlIIIIIlIll) {
        return (llllllllllIlllIlllIllIlIIIIIlIll == PotionTypes.EMPTY) ? 16253176 : getPotionColorFromEffectList(llllllllllIlllIlllIllIlIIIIIlIll.getEffects());
    }
    
    public static void addCustomPotionEffectToList(@Nullable final NBTTagCompound llllllllllIlllIlllIllIlIIIIllIIl, final List<PotionEffect> llllllllllIlllIlllIllIlIIIIllIII) {
        if (llllllllllIlllIlllIllIlIIIIllIIl != null && llllllllllIlllIlllIllIlIIIIllIIl.hasKey("CustomPotionEffects", 9)) {
            final NBTTagList llllllllllIlllIlllIllIlIIIIlllIl = llllllllllIlllIlllIllIlIIIIllIIl.getTagList("CustomPotionEffects", 10);
            for (int llllllllllIlllIlllIllIlIIIIlllII = 0; llllllllllIlllIlllIllIlIIIIlllII < llllllllllIlllIlllIllIlIIIIlllIl.tagCount(); ++llllllllllIlllIlllIllIlIIIIlllII) {
                final NBTTagCompound llllllllllIlllIlllIllIlIIIIllIll = llllllllllIlllIlllIllIlIIIIlllIl.getCompoundTagAt(llllllllllIlllIlllIllIlIIIIlllII);
                final PotionEffect llllllllllIlllIlllIllIlIIIIllIlI = PotionEffect.readCustomPotionEffectFromNBT(llllllllllIlllIlllIllIlIIIIllIll);
                if (llllllllllIlllIlllIllIlIIIIllIlI != null) {
                    llllllllllIlllIlllIllIlIIIIllIII.add(llllllllllIlllIlllIllIlIIIIllIlI);
                }
            }
        }
    }
    
    public static ItemStack appendEffects(final ItemStack llllllllllIlllIlllIllIIlllIIllll, final Collection<PotionEffect> llllllllllIlllIlllIllIIlllIIlllI) {
        if (llllllllllIlllIlllIllIIlllIIlllI.isEmpty()) {
            return llllllllllIlllIlllIllIIlllIIllll;
        }
        final NBTTagCompound llllllllllIlllIlllIllIIlllIlIIlI = (NBTTagCompound)MoreObjects.firstNonNull((Object)llllllllllIlllIlllIllIIlllIIllll.getTagCompound(), (Object)new NBTTagCompound());
        final NBTTagList llllllllllIlllIlllIllIIlllIlIIIl = llllllllllIlllIlllIllIIlllIlIIlI.getTagList("CustomPotionEffects", 9);
        for (final PotionEffect llllllllllIlllIlllIllIIlllIlIIII : llllllllllIlllIlllIllIIlllIIlllI) {
            llllllllllIlllIlllIllIIlllIlIIIl.appendTag(llllllllllIlllIlllIllIIlllIlIIII.writeCustomPotionEffectToNBT(new NBTTagCompound()));
        }
        llllllllllIlllIlllIllIIlllIlIIlI.setTag("CustomPotionEffects", llllllllllIlllIlllIllIIlllIlIIIl);
        llllllllllIlllIlllIllIIlllIIllll.setTagCompound(llllllllllIlllIlllIllIIlllIlIIlI);
        return llllllllllIlllIlllIllIIlllIIllll;
    }
    
    public static int getPotionColorFromEffectList(final Collection<PotionEffect> llllllllllIlllIlllIllIIlllllIlll) {
        final int llllllllllIlllIlllIllIIlllllllll = 3694022;
        if (llllllllllIlllIlllIllIIlllllIlll.isEmpty()) {
            return Config.isCustomColors() ? CustomColors.getPotionColor((Potion)null, llllllllllIlllIlllIllIIlllllllll) : 3694022;
        }
        float llllllllllIlllIlllIllIIllllllllI = 0.0f;
        float llllllllllIlllIlllIllIIlllllllIl = 0.0f;
        float llllllllllIlllIlllIllIIlllllllII = 0.0f;
        int llllllllllIlllIlllIllIIllllllIll = 0;
        for (final PotionEffect llllllllllIlllIlllIllIIllllllIlI : llllllllllIlllIlllIllIIlllllIlll) {
            if (llllllllllIlllIlllIllIIllllllIlI.doesShowParticles()) {
                int llllllllllIlllIlllIllIIllllllIIl = llllllllllIlllIlllIllIIllllllIlI.getPotion().getLiquidColor();
                if (Config.isCustomColors()) {
                    llllllllllIlllIlllIllIIllllllIIl = CustomColors.getPotionColor(llllllllllIlllIlllIllIIllllllIlI.getPotion(), llllllllllIlllIlllIllIIllllllIIl);
                }
                final int llllllllllIlllIlllIllIIllllllIII = llllllllllIlllIlllIllIIllllllIlI.getAmplifier() + 1;
                llllllllllIlllIlllIllIIllllllllI += llllllllllIlllIlllIllIIllllllIII * (llllllllllIlllIlllIllIIllllllIIl >> 16 & 0xFF) / 255.0f;
                llllllllllIlllIlllIllIIlllllllIl += llllllllllIlllIlllIllIIllllllIII * (llllllllllIlllIlllIllIIllllllIIl >> 8 & 0xFF) / 255.0f;
                llllllllllIlllIlllIllIIlllllllII += llllllllllIlllIlllIllIIllllllIII * (llllllllllIlllIlllIllIIllllllIIl >> 0 & 0xFF) / 255.0f;
                llllllllllIlllIlllIllIIllllllIll += llllllllllIlllIlllIllIIllllllIII;
            }
        }
        if (llllllllllIlllIlllIllIIllllllIll == 0) {
            return 0;
        }
        llllllllllIlllIlllIllIIllllllllI = llllllllllIlllIlllIllIIllllllllI / llllllllllIlllIlllIllIIllllllIll * 255.0f;
        llllllllllIlllIlllIllIIlllllllIl = llllllllllIlllIlllIllIIlllllllIl / llllllllllIlllIlllIllIIllllllIll * 255.0f;
        llllllllllIlllIlllIllIIlllllllII = llllllllllIlllIlllIllIIlllllllII / llllllllllIlllIlllIllIIllllllIll * 255.0f;
        return (int)llllllllllIlllIlllIllIIllllllllI << 16 | (int)llllllllllIlllIlllIllIIlllllllIl << 8 | (int)llllllllllIlllIlllIllIIlllllllII;
    }
    
    public static List<PotionEffect> getFullEffectsFromTag(@Nullable final NBTTagCompound llllllllllIlllIlllIllIlIIIlIIlll) {
        final List<PotionEffect> llllllllllIlllIlllIllIlIIIlIlIII = (List<PotionEffect>)Lists.newArrayList();
        addCustomPotionEffectToList(llllllllllIlllIlllIllIlIIIlIIlll, llllllllllIlllIlllIllIlIIIlIlIII);
        return llllllllllIlllIlllIllIlIIIlIlIII;
    }
    
    public static ItemStack addPotionToItemStack(final ItemStack llllllllllIlllIlllIllIIlllIllllI, final PotionType llllllllllIlllIlllIllIIllllIIIlI) {
        final ResourceLocation llllllllllIlllIlllIllIIllllIIIIl = PotionType.REGISTRY.getNameForObject(llllllllllIlllIlllIllIIllllIIIlI);
        if (llllllllllIlllIlllIllIIllllIIIlI == PotionTypes.EMPTY) {
            if (llllllllllIlllIlllIllIIlllIllllI.hasTagCompound()) {
                final NBTTagCompound llllllllllIlllIlllIllIIllllIIIII = llllllllllIlllIlllIllIIlllIllllI.getTagCompound();
                llllllllllIlllIlllIllIIllllIIIII.removeTag("Potion");
                if (llllllllllIlllIlllIllIIllllIIIII.hasNoTags()) {
                    llllllllllIlllIlllIllIIlllIllllI.setTagCompound(null);
                }
            }
        }
        else {
            final NBTTagCompound llllllllllIlllIlllIllIIlllIlllll = llllllllllIlllIlllIllIIlllIllllI.hasTagCompound() ? llllllllllIlllIlllIllIIlllIllllI.getTagCompound() : new NBTTagCompound();
            llllllllllIlllIlllIllIIlllIlllll.setString("Potion", llllllllllIlllIlllIllIIllllIIIIl.toString());
            llllllllllIlllIlllIllIIlllIllllI.setTagCompound(llllllllllIlllIlllIllIIlllIlllll);
        }
        return llllllllllIlllIlllIllIIlllIllllI;
    }
}
