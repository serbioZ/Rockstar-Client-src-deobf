// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import java.util.HashMap;
import java.nio.IntBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.BufferUtils;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.client.features.impl.display.ClientFont;
import java.util.Iterator;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemArmor;
import net.minecraft.enchantment.EnchantmentHelper;
import java.util.Objects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import optifine.CustomColors;
import org.lwjgl.opengl.GL11;
import net.minecraft.potion.PotionEffect;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.api.utils.math.MathHelper;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.api.event.event.Event3D;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventNameTags;
import net.minecraft.entity.EntityLivingBase;
import java.util.Map;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NameTags extends Feature
{
    public /* synthetic */ BooleanSetting baxerCheck;
    public /* synthetic */ BooleanSetting ntbg;
    public /* synthetic */ BooleanSetting showCoords;
    public /* synthetic */ BooleanSetting showPotions;
    public /* synthetic */ NumberSetting borderOpacity;
    public /* synthetic */ BooleanSetting showArmor;
    public static /* synthetic */ Map<EntityLivingBase, double[]> entityPositions;
    public /* synthetic */ NumberSetting ntsize;
    
    @EventTarget
    public void onNickRemove(final EventNameTags lllllllllllllIlIIlIllIllllIIlllI) {
        if (this.isToggled()) {
            lllllllllllllIlIIlIllIllllIIlllI.setCancelled(true);
        }
    }
    
    private double[] convertTo2D(final double lllllllllllllIlIIlIllIllIlIIIlII, final double lllllllllllllIlIIlIllIllIIllllII, final double lllllllllllllIlIIlIllIllIIlllIll, final Entity lllllllllllllIlIIlIllIllIlIIIIIl) {
        final float lllllllllllllIlIIlIllIllIlIIIIII = NameTags.mc.timer.renderPartialTicks;
        NameTags.mc.entityRenderer.setupCameraTransform(lllllllllllllIlIIlIllIllIlIIIIII, 0);
        final double[] lllllllllllllIlIIlIllIllIIllllll = this.convertTo2D(lllllllllllllIlIIlIllIllIlIIIlII, lllllllllllllIlIIlIllIllIIllllII, lllllllllllllIlIIlIllIllIIlllIll);
        NameTags.mc.entityRenderer.setupCameraTransform(lllllllllllllIlIIlIllIllIlIIIIII, 0);
        return lllllllllllllIlIIlIllIllIIllllll;
    }
    
    @EventTarget
    public void on3D(final Event3D lllllllllllllIlIIlIllIllllIIIlll) {
        try {
            this.updatePositions();
        }
        catch (Exception ex) {}
    }
    
    @EventTarget
    public void on2D(final Event2D lllllllllllllIlIIlIllIlllIlIlIll) {
        GlStateManager.pushMatrix();
        for (final EntityLivingBase lllllllllllllIlIIlIllIlllIlIlIlI : NameTags.entityPositions.keySet()) {
            final double n = lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosX + (lllllllllllllIlIIlIllIlllIlIlIlI.posX - lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosX) * NameTags.mc.getRenderPartialTicks();
            NameTags.mc.getRenderManager();
            final double lllllllllllllIlIIlIllIlllIlIlIIl = n - RenderManager.renderPosX;
            final double n2 = lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosY + (lllllllllllllIlIIlIllIlllIlIlIlI.posY - lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosY) * NameTags.mc.getRenderPartialTicks();
            NameTags.mc.getRenderManager();
            final double lllllllllllllIlIIlIllIlllIlIlIII = n2 - RenderManager.renderPosY;
            final double n3 = lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosZ + (lllllllllllllIlIIlIllIlllIlIlIlI.posZ - lllllllllllllIlIIlIllIlllIlIlIlI.lastTickPosZ) * NameTags.mc.getRenderPartialTicks();
            NameTags.mc.getRenderManager();
            final double lllllllllllllIlIIlIllIlllIlIIlll = n3 - RenderManager.renderPosZ;
            boolean lllllllllllllIlIIlIllIlllIlIIllI = false;
            if (lllllllllllllIlIIlIllIlllIlIlIlI.getHeldItemOffhand().getItem() == Items.END_CRYSTAL || lllllllllllllIlIIlIllIlllIlIlIlI.getHeldItemMainhand().getItem() == Items.END_CRYSTAL) {
                final FriendManager friendManager = Main.instance.friendManager;
                if (!FriendManager.isFriend(lllllllllllllIlIIlIllIlllIlIlIlI.getName())) {
                    lllllllllllllIlIIlIllIlllIlIIllI = true;
                }
            }
            GlStateManager.pushMatrix();
            final String lllllllllllllIlIIlIllIlllIlIIlIl = this.baxerCheck.getBoolValue() ? (lllllllllllllIlIIlIllIlllIlIIllI ? (TextFormatting.RED + " Baxer") : "") : "";
            if (lllllllllllllIlIIlIllIlllIlIlIlI instanceof EntityPlayer && lllllllllllllIlIIlIllIlllIlIlIlI != NameTags.mc.player) {
                final double[] lllllllllllllIlIIlIllIlllIlIIlII = NameTags.entityPositions.get(lllllllllllllIlIIlIllIlllIlIlIlI);
                if (lllllllllllllIlIIlIllIlllIlIIlII[3] < 0.0 || lllllllllllllIlIIlIllIlllIlIIlII[3] >= 1.0) {
                    GlStateManager.popMatrix();
                }
                else {
                    final ScaledResolution lllllllllllllIlIIlIllIlllIlIIIll = new ScaledResolution(NameTags.mc);
                    GlStateManager.translate(lllllllllllllIlIIlIllIlllIlIIlII[0] / ScaledResolution.getScaleFactor(), lllllllllllllIlIIlIllIlllIlIIlII[1] / ScaledResolution.getScaleFactor(), 0.0);
                    this.scale();
                    String lllllllllllllIlIIlIllIlllIlIIIlI = "";
                    if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled()) {
                        lllllllllllllIlIIlIllIlllIlIIIlI = "Protected";
                    }
                    else {
                        final FriendManager friendManager2 = Main.instance.friendManager;
                        if (FriendManager.isFriend(lllllllllllllIlIIlIllIlllIlIlIlI.getName())) {
                            lllllllllllllIlIIlIllIlllIlIIIlI = ChatFormatting.GREEN + "[F] " + ChatFormatting.RESET + lllllllllllllIlIIlIllIlllIlIlIlI.getDisplayName().getUnformattedText();
                        }
                        else {
                            lllllllllllllIlIIlIllIlllIlIIIlI = lllllllllllllIlIIlIllIlllIlIlIlI.getDisplayName().getUnformattedText();
                        }
                    }
                    final String lllllllllllllIlIIlIllIlllIlIIIIl = new StringBuilder().append(MathHelper.round(lllllllllllllIlIIlIllIlllIlIlIlI.getHealth(), 1)).toString();
                    if (this.showCoords.getBoolValue()) {
                        final float lllllllllllllIlIIlIllIlllIlIIIII = (float)(NameTags.mc.mntsb_20.getStringWidth("XYZ: " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posX + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posY + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posZ + " | " + lllllllllllllIlIIlIllIlllIlIIIIl + " " + lllllllllllllIlIIlIllIlllIlIIIlI + lllllllllllllIlIIlIllIlllIlIIlIl) + 2);
                        GlStateManager.translate(0.0, -10.0, 0.0);
                        if (this.ntbg.getBoolValue()) {
                            GlStateManager.enableBlend();
                            GlStateManager.enableAlpha();
                            DrawHelper.drawRectWithGlow(-lllllllllllllIlIIlIllIlllIlIIIII / 2.0f, -10.0, lllllllllllllIlIIlIllIlllIlIIIII / 2.0f + 5.0f, 3.0, 7.0, 5.0, new Color(1, 1, 1, 255));
                            GlStateManager.disableBlend();
                        }
                        NameTags.mc.mntsb_20.drawStringWithShadow("XYZ: " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posX + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posY + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posZ + " | " + lllllllllllllIlIIlIllIlllIlIIIlI + " " + getHealthColor(lllllllllllllIlIIlIllIlllIlIlIlI.getHealth()) + lllllllllllllIlIIlIllIlllIlIIIIl + lllllllllllllIlIIlIllIlllIlIIlIl, -lllllllllllllIlIIlIllIlllIlIIIII / 2.0f + 2.0f, -7.5, -1);
                    }
                    else {
                        final float lllllllllllllIlIIlIllIlllIIlllll = (float)(NameTags.mc.mntsb_20.getStringWidth(String.valueOf(lllllllllllllIlIIlIllIlllIlIIIIl) + " " + lllllllllllllIlIIlIllIlllIlIIIlI + lllllllllllllIlIIlIllIlllIlIIlIl) + 2);
                        GlStateManager.translate(0.0, -10.0, 0.0);
                        if (this.ntbg.getBoolValue()) {
                            GlStateManager.enableBlend();
                            GlStateManager.enableAlpha();
                            DrawHelper.drawRectWithGlow(-lllllllllllllIlIIlIllIlllIIlllll / 2.0f, -10.0, lllllllllllllIlIIlIllIlllIIlllll / 2.0f + 5.0f, 3.0, 7.0, 5.0, new Color(1, 1, 1, 255));
                            GlStateManager.disableBlend();
                        }
                        NameTags.mc.mntsb_20.drawStringWithShadow(String.valueOf(lllllllllllllIlIIlIllIlllIlIIIlI) + " " + getHealthColor(lllllllllllllIlIIlIllIlllIlIlIlI.getHealth()) + lllllllllllllIlIIlIllIlllIlIIIIl + lllllllllllllIlIIlIllIlllIlIIlIl, -lllllllllllllIlIIlIllIlllIIlllll / 2.0f + 2.0f, -7.5, -1);
                    }
                    if (this.showPotions.getBoolValue()) {
                        float lllllllllllllIlIIlIllIlllIIllllI = (float)(lllllllllllllIlIIlIllIlllIlIlIII - 60.0);
                        for (final PotionEffect lllllllllllllIlIIlIllIlllIIlllIl : lllllllllllllIlIIlIllIlllIlIlIlI.getActivePotionEffects()) {
                            GL11.glDisable(2929);
                            final Potion lllllllllllllIlIIlIllIlllIIlllII = Potion.getPotionById(CustomColors.getPotionId(lllllllllllllIlIIlIllIlllIIlllIl.getEffectName()));
                            if (lllllllllllllIlIIlIllIlllIIlllII != null) {
                                ChatFormatting lllllllllllllIlIIlIllIlllIIllIll = null;
                                if (lllllllllllllIlIIlIllIlllIIlllIl.getDuration() < 200) {
                                    lllllllllllllIlIIlIllIlllIIllIll = ChatFormatting.RED;
                                }
                                else if (lllllllllllllIlIIlIllIlllIIlllIl.getDuration() < 400) {
                                    lllllllllllllIlIIlIllIlllIIllIll = ChatFormatting.GOLD;
                                }
                                else if (lllllllllllllIlIIlIllIlllIIlllIl.getDuration() > 400) {
                                    lllllllllllllIlIIlIllIlllIIllIll = ChatFormatting.GRAY;
                                }
                                final String lllllllllllllIlIIlIllIlllIIllIlI = Potion.getDurationString(lllllllllllllIlIIlIllIlllIIlllIl);
                                String lllllllllllllIlIIlIllIlllIIllIIl = I18n.format(lllllllllllllIlIIlIllIlllIIlllII.getName(), new Object[0]);
                                if (lllllllllllllIlIIlIllIlllIIlllIl.getAmplifier() == 1) {
                                    lllllllllllllIlIIlIllIlllIIllIIl = String.valueOf(lllllllllllllIlIIlIllIlllIIllIIl) + " " + ChatFormatting.GRAY + I18n.format("enchantment.level.2", new Object[0]) + " (" + lllllllllllllIlIIlIllIlllIIllIll + lllllllllllllIlIIlIllIlllIIllIlI + ")";
                                }
                                else if (lllllllllllllIlIIlIllIlllIIlllIl.getAmplifier() == 2) {
                                    lllllllllllllIlIIlIllIlllIIllIIl = String.valueOf(lllllllllllllIlIIlIllIlllIIllIIl) + " " + ChatFormatting.GRAY + I18n.format("enchantment.level.3", new Object[0]) + " (" + lllllllllllllIlIIlIllIlllIIllIll + lllllllllllllIlIIlIllIlllIIllIlI + ")";
                                }
                                else if (lllllllllllllIlIIlIllIlllIIlllIl.getAmplifier() == 3) {
                                    lllllllllllllIlIIlIllIlllIIllIIl = String.valueOf(lllllllllllllIlIIlIllIlllIIllIIl) + " " + ChatFormatting.GRAY + I18n.format("enchantment.level.4", new Object[0]) + " (" + lllllllllllllIlIIlIllIlllIIllIll + lllllllllllllIlIIlIllIlllIIllIlI + ")";
                                }
                                if (this.showCoords.getBoolValue()) {
                                    final float lllllllllllllIlIIlIllIlllIIllIII = (float)(NameTags.mc.mntsb_20.getStringWidth("XYZ: " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posX + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posY + " " + (int)lllllllllllllIlIIlIllIlllIlIlIlI.posZ + " | " + lllllllllllllIlIIlIllIlllIlIIIIl + " " + lllllllllllllIlIIlIllIlllIlIIIlI) + 2);
                                    Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllllIlIIlIllIlllIIllIIl, MathematicHelper.getMiddle((int)(-lllllllllllllIlIIlIllIlllIIllIII) + 100, (int)lllllllllllllIlIIlIllIlllIIllIII + 100) - lllllllllllllIlIIlIllIlllIIllIII, lllllllllllllIlIIlIllIlllIIllllI, -1);
                                }
                                else {
                                    final float lllllllllllllIlIIlIllIlllIIlIlll = (float)(NameTags.mc.mntsb_20.getStringWidth(String.valueOf(lllllllllllllIlIIlIllIlllIlIIIIl) + " " + lllllllllllllIlIIlIllIlllIlIIIlI) + 2);
                                    Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllllIlIIlIllIlllIIllIIl, MathematicHelper.getMiddle((int)(-lllllllllllllIlIIlIllIlllIIlIlll) + 100, (int)lllllllllllllIlIIlIllIlllIIlIlll + 100) - lllllllllllllIlIIlIllIlllIIlIlll, lllllllllllllIlIIlIllIlllIIllllI, -1);
                                }
                            }
                            lllllllllllllIlIIlIllIlllIIllllI -= 10.0f;
                            GL11.glEnable(2929);
                        }
                    }
                    final ItemStack lllllllllllllIlIIlIllIlllIIlIllI = lllllllllllllIlIIlIllIlllIlIlIlI.getHeldItem(EnumHand.OFF_HAND);
                    if (this.showArmor.getBoolValue()) {
                        final ArrayList<ItemStack> lllllllllllllIlIIlIllIlllIIlIlIl = new ArrayList<ItemStack>();
                        for (int lllllllllllllIlIIlIllIlllIIlIlII = 0; lllllllllllllIlIIlIllIlllIIlIlII < 5; ++lllllllllllllIlIIlIllIlllIIlIlII) {
                            final ItemStack lllllllllllllIlIIlIllIlllIIlIIll = ((EntityPlayer)lllllllllllllIlIIlIllIlllIlIlIlI).getEquipmentInSlot(lllllllllllllIlIIlIllIlllIIlIlII);
                            lllllllllllllIlIIlIllIlllIIlIlIl.add(lllllllllllllIlIIlIllIlllIIlIIll);
                        }
                        int lllllllllllllIlIIlIllIlllIIlIIlI = -(lllllllllllllIlIIlIllIlllIIlIlIl.size() * 9);
                        NameTags.mc.getRenderItem().renderItemIntoGUI(lllllllllllllIlIIlIllIlllIIlIllI, (float)(lllllllllllllIlIIlIllIlllIIlIIlI + 105 - Minecraft.fontRendererObj.getStringWidth(new StringBuilder().append(lllllllllllllIlIIlIllIlllIIlIIlI).toString())), -29.0f);
                        NameTags.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, lllllllllllllIlIIlIllIlllIIlIllI, lllllllllllllIlIIlIllIlllIIlIIlI + 105 - Minecraft.fontRendererObj.getStringWidth(new StringBuilder().append(lllllllllllllIlIIlIllIlllIIlIIlI).toString()), -28);
                        for (final ItemStack lllllllllllllIlIIlIllIlllIIlIIIl : lllllllllllllIlIIlIllIlllIIlIlIl) {
                            RenderHelper.enableGUIStandardItemLighting();
                            NameTags.mc.getRenderItem().renderItemIntoGUI(lllllllllllllIlIIlIllIlllIIlIIIl, (float)(lllllllllllllIlIIlIllIlllIIlIIlI + 6), -28.0f);
                            NameTags.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, lllllllllllllIlIIlIllIlllIIlIIIl, lllllllllllllIlIIlIllIlllIIlIIlI + 5, -26);
                            lllllllllllllIlIIlIllIlllIIlIIlI += 3;
                            RenderHelper.disableStandardItemLighting();
                            int lllllllllllllIlIIlIllIlllIIlIIII = 7;
                            final int lllllllllllllIlIIlIllIlllIIIllll = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(16)), lllllllllllllIlIIlIllIlllIIlIIIl);
                            final int lllllllllllllIlIIlIllIlllIIIlllI = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(20)), lllllllllllllIlIIlIllIlllIIlIIIl);
                            final int lllllllllllllIlIIlIllIlllIIIllIl = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(19)), lllllllllllllIlIIlIllIlllIIlIIIl);
                            if (lllllllllllllIlIIlIllIlllIIIllll > 0) {
                                this.drawEnchantTag("S" + this.getColor(lllllllllllllIlIIlIllIlllIIIllll) + lllllllllllllIlIIlIllIlllIIIllll, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                lllllllllllllIlIIlIllIlllIIlIIII += 8;
                            }
                            if (lllllllllllllIlIIlIllIlllIIIlllI > 0) {
                                this.drawEnchantTag("F" + this.getColor(lllllllllllllIlIIlIllIlllIIIlllI) + lllllllllllllIlIIlIllIlllIIIlllI, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                lllllllllllllIlIIlIllIlllIIlIIII += 8;
                            }
                            if (lllllllllllllIlIIlIllIlllIIIllIl > 0) {
                                this.drawEnchantTag("Kb" + this.getColor(lllllllllllllIlIIlIllIlllIIIllIl) + lllllllllllllIlIIlIllIlllIIIllIl, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                            }
                            else if (lllllllllllllIlIIlIllIlllIIlIIIl.getItem() instanceof ItemArmor) {
                                final int lllllllllllllIlIIlIllIlllIIIllII = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(0)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                final int lllllllllllllIlIIlIllIlllIIIlIll = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(7)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                final int lllllllllllllIlIIlIllIlllIIIlIlI = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(34)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                if (lllllllllllllIlIIlIllIlllIIIllII > 0) {
                                    this.drawEnchantTag("P" + this.getColor(lllllllllllllIlIIlIllIlllIIIllII) + lllllllllllllIlIIlIllIlllIIIllII, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                    lllllllllllllIlIIlIllIlllIIlIIII += 8;
                                }
                                if (lllllllllllllIlIIlIllIlllIIIlIll > 0) {
                                    this.drawEnchantTag("Th" + this.getColor(lllllllllllllIlIIlIllIlllIIIlIll) + lllllllllllllIlIIlIllIlllIIIlIll, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                    lllllllllllllIlIIlIllIlllIIlIIII += 8;
                                }
                                if (lllllllllllllIlIIlIllIlllIIIlIlI > 0) {
                                    this.drawEnchantTag("U" + this.getColor(lllllllllllllIlIIlIllIlllIIIlIlI) + lllllllllllllIlIIlIllIlllIIIlIlI, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                }
                            }
                            else if (lllllllllllllIlIIlIllIlllIIlIIIl.getItem() instanceof ItemBow) {
                                final int lllllllllllllIlIIlIllIlllIIIlIIl = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(48)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                final int lllllllllllllIlIIlIllIlllIIIlIII = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(49)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                final int lllllllllllllIlIIlIllIlllIIIIlll = EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(50)), lllllllllllllIlIIlIllIlllIIlIIIl);
                                if (lllllllllllllIlIIlIllIlllIIIlIIl > 0) {
                                    this.drawEnchantTag("P" + this.getColor(lllllllllllllIlIIlIllIlllIIIlIIl) + lllllllllllllIlIIlIllIlllIIIlIIl, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                    lllllllllllllIlIIlIllIlllIIlIIII += 8;
                                }
                                if (lllllllllllllIlIIlIllIlllIIIlIII > 0) {
                                    this.drawEnchantTag("P" + this.getColor(lllllllllllllIlIIlIllIlllIIIlIII) + lllllllllllllIlIIlIllIlllIIIlIII, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                    lllllllllllllIlIIlIllIlllIIlIIII += 8;
                                }
                                if (lllllllllllllIlIIlIllIlllIIIIlll > 0) {
                                    this.drawEnchantTag("F" + this.getColor(lllllllllllllIlIIlIllIlllIIIIlll) + lllllllllllllIlIIlIllIlllIIIIlll, lllllllllllllIlIIlIllIlllIIlIIlI, lllllllllllllIlIIlIllIlllIIlIIII);
                                }
                            }
                            final int lllllllllllllIlIIlIllIlllIIIIllI = (int)Math.round(255.0 - lllllllllllllIlIIlIllIlllIIlIIIl.getItemDamage() * 255.0 / lllllllllllllIlIIlIllIlllIIlIIIl.getMaxDamage());
                            new Color(255 - lllllllllllllIlIIlIllIlllIIIIllI << 16 | lllllllllllllIlIIlIllIlllIIIIllI << 8).brighter();
                            if (lllllllllllllIlIIlIllIlllIIlIIIl.getMaxDamage() - lllllllllllllIlIIlIllIlllIIlIIIl.getItemDamage() > 0) {
                                GlStateManager.pushMatrix();
                                GlStateManager.disableDepth();
                                GlStateManager.enableDepth();
                                GlStateManager.popMatrix();
                            }
                            lllllllllllllIlIIlIllIlllIIlIIlI += (int)13.5;
                        }
                    }
                    GlStateManager.popMatrix();
                }
            }
        }
        GL11.glPopMatrix();
        GlStateManager.enableBlend();
    }
    
    private String getColor(final int lllllllllllllIlIIlIllIllIllIIIIl) {
        if (lllllllllllllIlIIlIllIllIllIIIIl != 1) {
            if (lllllllllllllIlIIlIllIllIllIIIIl == 2) {
                return "";
            }
            if (lllllllllllllIlIIlIllIllIllIIIIl == 3) {
                return "";
            }
            if (lllllllllllllIlIIlIllIllIllIIIIl == 4) {
                return "";
            }
            if (lllllllllllllIlIIlIllIllIllIIIIl >= 5) {
                return "";
            }
        }
        return "";
    }
    
    private void drawEnchantTag(final String lllllllllllllIlIIlIllIllIllIlIIl, final int lllllllllllllIlIIlIllIllIllIlIII, int lllllllllllllIlIIlIllIllIllIIlll) {
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        lllllllllllllIlIIlIllIllIllIIlll -= 7;
        if (!ClientFont.minecraftfont.getBoolValue()) {
            ClientHelper.getFontRender().drawStringWithShadow(lllllllllllllIlIIlIllIllIllIlIIl, lllllllllllllIlIIlIllIllIllIlIII + 6, -35 - lllllllllllllIlIIlIllIllIllIIlll, -1);
        }
        else {
            Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllllIlIIlIllIllIllIlIIl, (float)(lllllllllllllIlIIlIllIllIllIlIII + 6), (float)(-35 - lllllllllllllIlIIlIllIllIllIIlll), -1);
        }
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
    }
    
    private void updatePositions() {
        NameTags.entityPositions.clear();
        final float lllllllllllllIlIIlIllIllIlIlIlll = NameTags.mc.timer.renderPartialTicks;
        for (final Entity lllllllllllllIlIIlIllIllIlIlIllI : NameTags.mc.world.loadedEntityList) {
            if (lllllllllllllIlIIlIllIllIlIlIllI instanceof EntityPlayer && lllllllllllllIlIIlIllIllIlIlIllI != NameTags.mc.player) {
                final double n = lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosX + (lllllllllllllIlIIlIllIllIlIlIllI.posX - lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosX) * lllllllllllllIlIIlIllIllIlIlIlll;
                NameTags.mc.getRenderManager();
                final double lllllllllllllIlIIlIllIllIlIlIlIl = n - RenderManager.renderPosX;
                final double n2 = lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosY + (lllllllllllllIlIIlIllIllIlIlIllI.posY - lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosY) * lllllllllllllIlIIlIllIllIlIlIlll;
                NameTags.mc.getRenderManager();
                double lllllllllllllIlIIlIllIllIlIlIlII = n2 - RenderManager.renderPosY;
                final double n3 = lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosZ + (lllllllllllllIlIIlIllIllIlIlIllI.posZ - lllllllllllllIlIIlIllIllIlIlIllI.lastTickPosZ) * lllllllllllllIlIIlIllIllIlIlIlll;
                NameTags.mc.getRenderManager();
                final double lllllllllllllIlIIlIllIllIlIlIIll = n3 - RenderManager.renderPosZ;
                lllllllllllllIlIIlIllIllIlIlIlII += lllllllllllllIlIIlIllIllIlIlIllI.height + 0.2;
                if (Objects.requireNonNull(this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll))[2] < 0.0 || Objects.requireNonNull(this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll))[2] >= 1.0) {
                    continue;
                }
                NameTags.entityPositions.put((EntityPlayer)lllllllllllllIlIIlIllIllIlIlIllI, new double[] { Objects.requireNonNull(this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll))[0], Objects.requireNonNull(this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll))[1], Math.abs(this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII + 1.0, lllllllllllllIlIIlIllIllIlIlIIll, lllllllllllllIlIIlIllIllIlIlIllI)[1] - this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll, lllllllllllllIlIIlIllIllIlIlIllI)[1]), this.convertTo2D(lllllllllllllIlIIlIllIllIlIlIlIl, lllllllllllllIlIIlIllIllIlIlIlII, lllllllllllllIlIIlIllIllIlIlIIll)[2] });
            }
        }
    }
    
    public NameTags() {
        super("NameTags", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u043d\u0438\u043a, \u0431\u0440\u043e\u043d\u044e \u0438 \u0438\u0445 \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435 \u0441\u043a\u0432\u043e\u0437\u044c \u0441\u0442\u0435\u043d\u044b", 0, Category.VISUALS);
        this.ntsize = new NumberSetting("NameTags Size", "\u0420\u0430\u0437\u043c\u0435\u0440 \u043d\u0435\u0439\u043c\u0442\u0430\u0433\u043e\u0432", 1.0f, 0.5f, 2.0f, 0.1f, () -> true);
        this.ntbg = new BooleanSetting("NameTags Background", "\u0412\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0431\u044d\u043a-\u0433\u0440\u0430\u0443\u043d\u0434 \u043d\u0435\u0439\u043c\u0442\u0430\u0433\u043e\u0432", false, () -> true);
        this.borderOpacity = new NumberSetting("Border Opacity", "\u041f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0441\u0442\u044c \u0431\u044d\u043a-\u0433\u0440\u0430\u0443\u043d\u0434\u0430", 10.0f, 0.0f, 255.0f, 1.0f, () -> this.ntbg.getBoolValue());
        this.showArmor = new BooleanSetting("Show Armor", true, () -> true);
        this.showPotions = new BooleanSetting("Show Potion", true, () -> true);
        this.showCoords = new BooleanSetting("Show Coords", false, () -> true);
        this.baxerCheck = new BooleanSetting("Baxer Check", false, () -> true);
        this.addSettings(this.ntsize, this.ntbg, this.borderOpacity, this.showArmor, this.showPotions, this.showCoords, this.baxerCheck);
    }
    
    private void scale() {
        final float lllllllllllllIlIIlIllIllIIIlllII = NameTags.mc.gameSettings.smoothCamera ? 2.0f : this.ntsize.getNumberValue();
        GlStateManager.scale(lllllllllllllIlIIlIllIllIIIlllII, lllllllllllllIlIIlIllIllIIIlllII, lllllllllllllIlIIlIllIllIIIlllII);
    }
    
    private double[] convertTo2D(final double lllllllllllllIlIIlIllIllIIlIllll, final double lllllllllllllIlIIlIllIllIIlIlllI, final double lllllllllllllIlIIlIllIllIIlIllIl) {
        final FloatBuffer lllllllllllllIlIIlIllIllIIlIllII = BufferUtils.createFloatBuffer(3);
        final IntBuffer lllllllllllllIlIIlIllIllIIlIlIll = BufferUtils.createIntBuffer(16);
        final FloatBuffer lllllllllllllIlIIlIllIllIIlIlIlI = BufferUtils.createFloatBuffer(16);
        final FloatBuffer lllllllllllllIlIIlIllIllIIlIlIIl = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(2982, lllllllllllllIlIIlIllIllIIlIlIlI);
        GL11.glGetFloat(2983, lllllllllllllIlIIlIllIllIIlIlIIl);
        GL11.glGetInteger(2978, lllllllllllllIlIIlIllIllIIlIlIll);
        final boolean lllllllllllllIlIIlIllIllIIlIlIII = GLU.gluProject((float)lllllllllllllIlIIlIllIllIIlIllll, (float)lllllllllllllIlIIlIllIllIIlIlllI, (float)lllllllllllllIlIIlIllIllIIlIllIl, lllllllllllllIlIIlIllIllIIlIlIlI, lllllllllllllIlIIlIllIllIIlIlIIl, lllllllllllllIlIIlIllIllIIlIlIll, lllllllllllllIlIIlIllIllIIlIllII);
        if (lllllllllllllIlIIlIllIllIIlIlIII) {
            return new double[] { lllllllllllllIlIIlIllIllIIlIllII.get(0), Display.getHeight() - lllllllllllllIlIIlIllIllIIlIllII.get(1), lllllllllllllIlIIlIllIllIIlIllII.get(2) };
        }
        return null;
    }
    
    public static TextFormatting getHealthColor(final float lllllllllllllIlIIlIllIllllIIllII) {
        if (lllllllllllllIlIIlIllIllllIIllII <= 4.0f) {
            return TextFormatting.RED;
        }
        if (lllllllllllllIlIIlIllIllllIIllII <= 8.0f) {
            return TextFormatting.GOLD;
        }
        if (lllllllllllllIlIIlIllIllllIIllII <= 12.0f) {
            return TextFormatting.YELLOW;
        }
        if (lllllllllllllIlIIlIllIllllIIllII <= 16.0f) {
            return TextFormatting.DARK_GREEN;
        }
        return TextFormatting.GREEN;
    }
    
    static {
        NameTags.entityPositions = new HashMap<EntityLivingBase, double[]>();
    }
}
