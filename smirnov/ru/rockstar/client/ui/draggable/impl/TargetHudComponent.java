// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import java.util.Iterator;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.Main;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHand;
import net.minecraft.client.gui.Gui;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.other.Util;
import java.util.Objects;
import net.minecraft.client.network.NetHandlerPlayClient;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.client.features.Feature;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.client.features.impl.combat.KillAura;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class TargetHudComponent extends DraggableModule
{
    public static /* synthetic */ int x;
    public /* synthetic */ int lastS2;
    public /* synthetic */ int lastS;
    public /* synthetic */ int lastA;
    public static /* synthetic */ int y;
    public /* synthetic */ int lastJ;
    public /* synthetic */ int lastD;
    public /* synthetic */ int lastW;
    
    @Override
    public int getHeight() {
        return 100;
    }
    
    @Override
    public void render(final int lllllllllllIIllllIlllIIIIIIllIII, final int lllllllllllIIllllIlllIIIIIIlIlll) {
        final ScaledResolution lllllllllllIIllllIlllIIIIIIlIllI = new ScaledResolution(this.mc);
        final String lllllllllllIIllllIlllIIIIIIlIlIl = KillAura.targetHudMode.getOptions();
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Beach")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIlllIIIIIIlIlII = 15;
                final double lllllllllllIIllllIlllIIIIIIlIIll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIlIIll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIlllIIIIIIlIlII, lllllllllllIIllllIlllIIIIIIlIlII, lllllllllllIIllllIlllIIIIIIlIlII, 0).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 250), (float)(TargetHudComponent.y + 25), new Color(lllllllllllIIllllIlllIIIIIIlIlII, lllllllllllIIllllIlllIIIIIIlIlII, lllllllllllIIllllIlllIIIIIIlIlII, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead1(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 129, (int)(TargetHudComponent.y - 4.0f));
                Gui.drawRect(TargetHudComponent.x + 160, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth, TargetHudComponent.y + 18.0f, ClientHelper.getClientColor().getRGB());
                this.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() / 2.0f + " | Ground: " + (this.mc.player.onGround ? "true" : "false"), TargetHudComponent.x + 121.0f + 46.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 6.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 158, TargetHudComponent.y - 5.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Akrien")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIlllIIIIIIlIIlI = 15;
                final double lllllllllllIIllllIlllIIIIIIlIIIl = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIlIIIl, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 250), (float)(TargetHudComponent.y + 25), new Color(lllllllllllIIllllIlllIIIIIIlIIlI, lllllllllllIIllllIlllIIIIIIlIIlI, lllllllllllIIllllIlllIIIIIIlIIlI, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead1(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 129, (int)(TargetHudComponent.y - 4.0f));
                Gui.drawRect(TargetHudComponent.x + 160, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth, TargetHudComponent.y + 18.0f, ClientHelper.getClientColor().getRGB());
                this.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() / 2.0f + " | Ground: " + (this.mc.player.onGround ? "true" : "false"), TargetHudComponent.x + 121.0f + 46.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 6.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 158, TargetHudComponent.y - 5.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Rockstar")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIlllIIIIIIlIIII = 15;
                final double lllllllllllIIllllIlllIIIIIIIllll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIIllll, KillAura.healthBarWidth, 3.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIlllIIIIIIlIIII, lllllllllllIIllllIlllIIIIIIlIIII, lllllllllllIIllllIlllIIIIIIlIIII, 0).getRGB());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 13.5f, TargetHudComponent.x + 250, TargetHudComponent.y + 24.5f, new Color(0, 0, 0, 150).getRGB());
                DrawHelper.drawGradientRect(TargetHudComponent.x + 120, TargetHudComponent.y - 14, TargetHudComponent.x + 122, TargetHudComponent.y + 25, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                DrawHelper.drawGradientRect(TargetHudComponent.x + 250, TargetHudComponent.y - 14, TargetHudComponent.x + 252, TargetHudComponent.y + 25, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                Util.drawHead2(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 216, (int)(TargetHudComponent.y - 9.0f));
                this.mc.mntsb.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() + " | Distance: " + (int)this.mc.player.getDistanceToEntity(this.mc.player), TargetHudComponent.x + 101.0f + 35.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 4.0f, -1);
                this.mc.mntsb.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 128, TargetHudComponent.y - 7.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
                DrawHelper.drawGradientRect1(TargetHudComponent.x + 160 - 32, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth - 32.0, TargetHudComponent.y + 20.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (this.mc.player != null && lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Nursultan")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIlllIIIIIIIlllI = 15;
                final double lllllllllllIIllllIlllIIIIIIIllIl = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIIllIl, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIlllIIIIIIIlllI, lllllllllllIIllllIlllIIIIIIIlllI, lllllllllllIIllllIlllIIIIIIIlllI, 0).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 260), (float)(TargetHudComponent.y + 40), new Color(lllllllllllIIllllIlllIIIIIIIlllI, lllllllllllIIllllIlllIIIIIIIlllI, lllllllllllIIllllIlllIIIIIIIlllI, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead2(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 128, (int)(TargetHudComponent.y - 8.0f));
                DrawHelper.drawGradientRect1(TargetHudComponent.x + 160 - 32, TargetHudComponent.y + 13.0f + 12.0f, (float)(TargetHudComponent.x + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126), TargetHudComponent.y + 18.0f + 14.5f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                this.mc.neverlose500_14.drawStringWithShadow(new StringBuilder().append((int)this.mc.player.getHealth() / 2.0f).toString(), TargetHudComponent.x + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126 + 1.0, TargetHudComponent.y + 27.5f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 160, TargetHudComponent.y + 0.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow("Distance:" + (int)this.mc.player.getDistanceToEntity(this.mc.player), TargetHudComponent.x + 160, TargetHudComponent.y + 9.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Astolfo") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && this.mc.player instanceof EntityPlayer && KillAura.targetHud.getBoolValue()) {
            final float lllllllllllIIllllIlllIIIIIIIllII = (float)lllllllllllIIllllIlllIIIIIIlIllI.getScaledWidth();
            final float lllllllllllIIllllIlllIIIIIIIlIll = (float)lllllllllllIIllllIlllIIIIIIlIllI.getScaledHeight();
            TargetHudComponent.x = this.getX();
            TargetHudComponent.y = this.getY();
            double lllllllllllIIllllIlllIIIIIIIlIlI = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 120.0f;
            lllllllllllIIllllIlllIIIIIIIlIlI = MathHelper.clamp(lllllllllllIIllllIlllIIIIIIIlIlI, 0.0, 120.0);
            final double lllllllllllIIllllIlllIIIIIIIlIIl = (this.mc.player != null && this.mc.player.getHealth() < ((this.mc.player instanceof EntityPlayer) ? 18 : 10) && this.mc.player.getHealth() > 1.0f) ? 8 : 0;
            KillAura.healthBarWidth = MathHelper.lerp((float)lllllllllllIIllllIlllIIIIIIIlIlI, (float)KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
            DrawHelper.drawGlowRoundedRect((float)TargetHudComponent.x, (float)TargetHudComponent.y, (float)(TargetHudComponent.x + 155), (float)(TargetHudComponent.y + 62), new Color(20, 20, 20, 255).getRGB(), 6.0f, 5.0f);
            if (!this.mc.player.getName().isEmpty()) {
                Minecraft.fontRendererObj.drawStringWithShadow(Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() ? "Protected" : this.mc.player.getName(), (float)(TargetHudComponent.x + 31), (float)(TargetHudComponent.y + 5), -1);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)TargetHudComponent.x, (float)TargetHudComponent.y, 1.0f);
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GlStateManager.translate((float)(-TargetHudComponent.x - 3), (float)(-TargetHudComponent.y - 2), 1.0f);
            Minecraft.fontRendererObj.drawStringWithShadow(ru.rockstar.api.utils.math.MathHelper.round(this.mc.player.getHealth() / 2.0f, 1) + " \u2764", (float)(TargetHudComponent.x + 16), (float)(TargetHudComponent.y + 10), new Color(ClientHelper.getClientColor().getRGB()).getRGB());
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 137, TargetHudComponent.y + 7);
            this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 137), (float)(TargetHudComponent.y + 1));
            GuiInventory.drawEntityOnScreen(TargetHudComponent.x + 16, TargetHudComponent.y + 55, 25, this.mc.player.rotationYaw, -this.mc.player.rotationPitch, this.mc.player);
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, 120.0, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().darker().getRGB());
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, KillAura.healthBarWidth + lllllllllllIIllllIlllIIIIIIIlIIl, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().getRGB());
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, lllllllllllIIllllIlllIIIIIIIlIlI, 8.0, new Color(ClientHelper.getClientColor().getRGB()).getRGB());
        }
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Celestial Premium")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                final ScaledResolution lllllllllllIIllllIlllIIIIIIIlIII = new ScaledResolution(this.mc);
                final float lllllllllllIIllllIlllIIIIIIIIlll = (float)lllllllllllIIllllIlllIIIIIIIlIII.getScaledWidth();
                final float lllllllllllIIllllIlllIIIIIIIIllI = (float)lllllllllllIIllllIlllIIIIIIIlIII.getScaledHeight();
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final float lllllllllllIIllllIlllIIIIIIIIlIl = this.mc.player.getHealth();
                double lllllllllllIIllllIlllIIIIIIIIlII = lllllllllllIIllllIlllIIIIIIIIlIl / this.mc.player.getMaxHealth();
                lllllllllllIIllllIlllIIIIIIIIlII = MathHelper.clamp(lllllllllllIIllllIlllIIIIIIIIlII, 0.0, 1.0);
                final double lllllllllllIIllllIlllIIIIIIIIIll = 110.0 * lllllllllllIIllllIlllIIIIIIIIlII;
                final String lllllllllllIIllllIlllIIIIIIIIIlI = String.valueOf((int)this.mc.player.getHealth() / 2.0f);
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIIIIll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                KillAura.hudHeight = AnimationHelper.animate(40.0, KillAura.hudHeight, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect((float)(TargetHudComponent.x + 125), TargetHudComponent.y - 19, TargetHudComponent.x + 275, TargetHudComponent.y + 29, new Color(32, 31, 32, 150).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 120), (float)(TargetHudComponent.y - 26), (float)(TargetHudComponent.x + 280), TargetHudComponent.y + 35.0f, new Color(32, 31, 32, 150).getRGB(), 15.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 127.5), (float)(TargetHudComponent.y - 11.5), (float)(TargetHudComponent.x + 273), (float)(TargetHudComponent.y - 11), new Color(140, 140, 140).getRGB(), 6.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 162.0f, (float)(TargetHudComponent.y + 18), (float)(TargetHudComponent.x + 162.0f + KillAura.healthBarWidth), TargetHudComponent.y + 20.0f, new Color(ClientHelper.getClientColor().getRed() / 255.0f, ClientHelper.getClientColor().getGreen() / 255.0f, ClientHelper.getClientColor().getBlue() / 255.0f, 0.4509804f).getRGB(), 6.0f, 25.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 162.0f, (float)(TargetHudComponent.y + 18), (float)(TargetHudComponent.x + 162.0f + lllllllllllIIllllIlllIIIIIIIIIll), (float)(TargetHudComponent.y + 20), ClientHelper.getClientColor().getRGB(), 6.0f, 25.0f);
                this.mc.sfui16.drawStringWithShadow("Ground: " + (this.mc.player.onGround ? "true;" : "false;"), TargetHudComponent.x + 162.0f, TargetHudComponent.y - 3.0f, -1);
                this.mc.sfui16.drawStringWithShadow("HurtTime", TargetHudComponent.x + 162.5f, TargetHudComponent.y + 7.0f, -1);
                this.mc.neverlose500_13.drawCenteredString(this.mc.player.getName(), (float)(TargetHudComponent.x + 199.2753623188406), (float)(TargetHudComponent.y - 16.7), -1);
                final double lllllllllllIIllllIlllIIIIIIIIIIl = MathHelper.clamp(this.mc.player.hurtTime, 1.0, 0.3);
                final double lllllllllllIIllllIlllIIIIIIIIIII = 71.0 * lllllllllllIIllllIlllIIIIIIIIIIl;
                KillAura.hurttimeBarWidth = AnimationHelper.animate(lllllllllllIIllllIlllIIIIIIIIIII, KillAura.hurttimeBarWidth, 0.0529999852180481);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 201.0f, TargetHudComponent.y + 9.0f, (float)(TargetHudComponent.x + 272), (float)(TargetHudComponent.y + 11), new Color(40, 40, 40).getRGB(), 2.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 201.0f, TargetHudComponent.y + 9.0f, (float)(TargetHudComponent.x + 201 + KillAura.hurttimeBarWidth), (float)(TargetHudComponent.y + 11), ClientHelper.getClientColor().getRGB(), 2.0f, 4.0f);
                this.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 255, TargetHudComponent.y - 5);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 259), (float)(TargetHudComponent.y - 10));
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 125.5), TargetHudComponent.y - 20.5f, (float)(TargetHudComponent.x + 275), (float)(TargetHudComponent.y - 18), ClientHelper.getClientColor().getRGB(), 4.0f, 6.0f);
                Util.drawHead3(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 127 + this.mc.player.hurtTime / 2, (int)(TargetHudComponent.y - 8.0f) + this.mc.player.hurtTime / 2, 32 - this.mc.player.hurtTime, 32 - this.mc.player.hurtTime);
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
            }
        }
        if (lllllllllllIIllllIlllIIIIIIlIlIl.equalsIgnoreCase("Red-Blue")) {
            if (this.mc.gameSettings.ofFastRender) {
                this.mc.gameSettings.ofFastRender = false;
            }
            final ScaledResolution lllllllllllIIllllIllIlllllllllll = new ScaledResolution(this.mc);
            final float lllllllllllIIllllIllIllllllllllI = (float)lllllllllllIIllllIllIlllllllllll.getScaledWidth();
            final float lllllllllllIIllllIllIlllllllllIl = (float)lllllllllllIIllllIllIlllllllllll.getScaledHeight();
            TargetHudComponent.x = (int)(lllllllllllIIllllIllIllllllllllI / 2.0f - this.getX());
            TargetHudComponent.y = (int)(lllllllllllIIllllIllIlllllllllIl / 2.0f + this.getY());
            final double lllllllllllIIllllIllIlllllllllII = this.mc.player.getTotalArmorValue() * 4.8f;
            double lllllllllllIIllllIllIllllllllIll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 96.0f;
            lllllllllllIIllllIllIllllllllIll = MathHelper.clamp(lllllllllllIIllllIllIllllllllIll, 0.0, 96.0);
            KillAura.healthBarWidth = MathHelper.clamp(KillAura.healthBarWidth, 0.0, 104.0);
            final float lllllllllllIIllllIllIllllllllIlI = (float)TargetHudComponent.x;
            final float lllllllllllIIllllIllIllllllllIIl = (float)TargetHudComponent.y;
            final float lllllllllllIIllllIllIllllllllIII = lllllllllllIIllllIllIllllllllIlI + 48.0f + 120.0f;
            GlStateManager.pushMatrix();
            GlStateManager.disableBlend();
            DrawHelper.blurAreaBoarder((float)TargetHudComponent.x, (float)TargetHudComponent.y, 148.0f, 45.0f, 120.0f, 0.0f, 1.0f);
            DrawHelper.drawRect(TargetHudComponent.x - 1.0f, TargetHudComponent.y - 0.5f, lllllllllllIIllllIllIllllllllIII - 168.0f, TargetHudComponent.y + 45.0f, new Color(205, 205, 205).getRGB());
            if (this.mc.player instanceof EntityPlayer) {
                this.mc.robotoRegular.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 8.0f, TargetHudComponent.y + 5.0f, -1);
            }
            DrawHelper.renderItem(this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 133, TargetHudComponent.y - 20);
            if (Minecraft.getDebugFPS() > 5) {
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 19.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 19.0f, (float)KillAura.healthBarWidth, 5.0f, Color.RED.getRGB());
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 28.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                if (this.mc.player.getTotalArmorValue() > 0) {
                    DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 28.0f, (float)lllllllllllIIllllIllIlllllllllII, 5.0f, new Color(55, 175, 255).getRGB());
                }
                this.mc.player.getTotalArmorValue();
            }
            GlStateManager.pushMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            for (final NetworkPlayerInfo lllllllllllIIllllIllIlllllllIlll : this.mc.player.connection.getPlayerInfoMap()) {
                if (lllllllllllIIllllIllIlllllllIlll == null) {
                    continue;
                }
                if (!(this.mc.player instanceof EntityPlayer)) {
                    continue;
                }
                if (this.mc.world.getPlayerEntityByUUID(lllllllllllIIllllIllIlllllllIlll.getGameProfile().getId()) == this.mc.player) {
                    final float lllllllllllIIllllIllIlllllllIllI = (this.mc.player.hurtTime - this.mc.timer.renderPartialTicks) / 8.0f;
                    GlStateManager.color(1.0f, 1.0f - lllllllllllIIllllIllIlllllllIllI, 1.0f - lllllllllllIIllllIllIlllllllIllI, 1.0f);
                    this.mc.getTextureManager().bindTexture(lllllllllllIIllllIllIlllllllIlll.getLocationSkin());
                    Gui.drawScaledCustomSizeModalRect(TargetHudComponent.x + 104, TargetHudComponent.y, 8.0f, 8.0f, 8, 8, 44, 44, 64.0f, 64.0f);
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
            }
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
        super.render(lllllllllllIIllllIlllIIIIIIllIII, lllllllllllIIllllIlllIIIIIIlIlll);
    }
    
    public TargetHudComponent() {
        super("TargetHudComponent", 188, 100);
        this.lastA = 0;
        this.lastW = 0;
        this.lastS = 0;
        this.lastD = 0;
        this.lastJ = 0;
        this.lastS2 = 0;
    }
    
    @Override
    public int getWidth() {
        return 250;
    }
    
    @Override
    public void draw() {
        final ScaledResolution lllllllllllIIllllIllIlllllIlIIlI = new ScaledResolution(this.mc);
        final String lllllllllllIIllllIllIlllllIlIIIl = KillAura.targetHudMode.getOptions();
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Beach")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIllIlllllIlIIII = 15;
                final double lllllllllllIIllllIllIlllllIIllll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIlllllIIllll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIllIlllllIlIIII, lllllllllllIIllllIllIlllllIlIIII, lllllllllllIIllllIllIlllllIlIIII, 0).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 250), (float)(TargetHudComponent.y + 25), new Color(lllllllllllIIllllIllIlllllIlIIII, lllllllllllIIllllIllIlllllIlIIII, lllllllllllIIllllIllIlllllIlIIII, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead1(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 129, (int)(TargetHudComponent.y - 4.0f));
                Gui.drawRect(TargetHudComponent.x + 160, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth, TargetHudComponent.y + 18.0f, ClientHelper.getClientColor().getRGB());
                this.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() / 2.0f + " | Ground: " + (this.mc.player.onGround ? "true" : "false"), TargetHudComponent.x + 121.0f + 46.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 6.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 158, TargetHudComponent.y - 5.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Akrien")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIllIlllllIIlllI = 15;
                final double lllllllllllIIllllIllIlllllIIllIl = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIlllllIIllIl, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 250), (float)(TargetHudComponent.y + 25), new Color(lllllllllllIIllllIllIlllllIIlllI, lllllllllllIIllllIllIlllllIIlllI, lllllllllllIIllllIllIlllllIIlllI, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead1(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 129, (int)(TargetHudComponent.y - 4.0f));
                Gui.drawRect(TargetHudComponent.x + 160, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth, TargetHudComponent.y + 18.0f, ClientHelper.getClientColor().getRGB());
                this.mc.neverlose500_13.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() / 2.0f + " | Ground: " + (this.mc.player.onGround ? "true" : "false"), TargetHudComponent.x + 121.0f + 46.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 6.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 158, TargetHudComponent.y - 5.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Rockstar")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIllIlllllIIllII = 15;
                final double lllllllllllIIllllIllIlllllIIlIll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIlllllIIlIll, KillAura.healthBarWidth, 3.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIllIlllllIIllII, lllllllllllIIllllIllIlllllIIllII, lllllllllllIIllllIllIlllllIIllII, 0).getRGB());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 13.5f, TargetHudComponent.x + 250, TargetHudComponent.y + 24.5f, new Color(0, 0, 0, 150).getRGB());
                DrawHelper.drawGradientRect(TargetHudComponent.x + 120, TargetHudComponent.y - 14, TargetHudComponent.x + 122, TargetHudComponent.y + 25, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                DrawHelper.drawGradientRect(TargetHudComponent.x + 250, TargetHudComponent.y - 14, TargetHudComponent.x + 252, TargetHudComponent.y + 25, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                Util.drawHead2(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 216, (int)(TargetHudComponent.y - 9.0f));
                this.mc.mntsb.drawStringWithShadow("Hp: " + (int)this.mc.player.getHealth() + " | Distance: " + (int)this.mc.player.getDistanceToEntity(this.mc.player), TargetHudComponent.x + 101.0f + 35.0f - this.mc.neverlose500_16.getStringWidth(String.valueOf((int)this.mc.player.getHealth() / 2.0f)) / 2.0f, TargetHudComponent.y + 4.0f, -1);
                this.mc.mntsb.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 128, TargetHudComponent.y - 7.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
                DrawHelper.drawGradientRect1(TargetHudComponent.x + 160 - 32, TargetHudComponent.y + 13.0f, TargetHudComponent.x + 160.0f + KillAura.healthBarWidth - 32.0, TargetHudComponent.y + 20.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (this.mc.player != null && lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Nursultan")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final int lllllllllllIIllllIllIlllllIIlIlI = 15;
                final double lllllllllllIIllllIllIlllllIIlIIl = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 78.0f;
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIlllllIIlIIl, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect(TargetHudComponent.x + 122, TargetHudComponent.y - 14, TargetHudComponent.x + 250, TargetHudComponent.y + 25, new Color(lllllllllllIIllllIllIlllllIIlIlI, lllllllllllIIllllIllIlllllIIlIlI, lllllllllllIIllllIllIlllllIIlIlI, 0).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 122), (float)(TargetHudComponent.y - 14), (float)(TargetHudComponent.x + 260), (float)(TargetHudComponent.y + 40), new Color(lllllllllllIIllllIllIlllllIIlIlI, lllllllllllIIllllIllIlllllIIlIlI, lllllllllllIIllllIllIlllllIIlIlI, 150).getRGB(), 8.0f, 10.0f);
                Util.drawHead2(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 128, (int)(TargetHudComponent.y - 8.0f));
                DrawHelper.drawGradientRect1(TargetHudComponent.x + 160 - 32, TargetHudComponent.y + 13.0f + 12.0f, (float)(TargetHudComponent.x + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126), TargetHudComponent.y + 18.0f + 14.5f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
                this.mc.neverlose500_14.drawStringWithShadow(new StringBuilder().append((int)this.mc.player.getHealth() / 2.0f).toString(), TargetHudComponent.x + 160.0f - 32.0f + KillAura.healthBarWidth * 1.4299999475479126 + 1.0, TargetHudComponent.y + 27.5f, -1);
                this.mc.neverlose500_18.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 160, TargetHudComponent.y + 0.0f, -1);
                this.mc.neverlose500_18.drawStringWithShadow("Distance:" + (int)this.mc.player.getDistanceToEntity(this.mc.player), TargetHudComponent.x + 160, TargetHudComponent.y + 9.0f, -1);
                this.mc.getRenderItem().renderItemOverlays(this.mc.neverlose500_18, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 228, TargetHudComponent.y - 35);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 228), (float)(TargetHudComponent.y - 35));
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
                this.mc.player = null;
            }
        }
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Astolfo") && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && this.mc.player instanceof EntityPlayer && KillAura.targetHud.getBoolValue()) {
            final float lllllllllllIIllllIllIlllllIIlIII = (float)lllllllllllIIllllIllIlllllIlIIlI.getScaledWidth();
            final float lllllllllllIIllllIllIlllllIIIlll = (float)lllllllllllIIllllIllIlllllIlIIlI.getScaledHeight();
            TargetHudComponent.x = this.getX();
            TargetHudComponent.y = this.getY();
            double lllllllllllIIllllIllIlllllIIIllI = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 120.0f;
            lllllllllllIIllllIllIlllllIIIllI = MathHelper.clamp(lllllllllllIIllllIllIlllllIIIllI, 0.0, 120.0);
            final double lllllllllllIIllllIllIlllllIIIlIl = (this.mc.player != null && this.mc.player.getHealth() < ((this.mc.player instanceof EntityPlayer) ? 18 : 10) && this.mc.player.getHealth() > 1.0f) ? 8 : 0;
            KillAura.healthBarWidth = MathHelper.lerp((float)lllllllllllIIllllIllIlllllIIIllI, (float)KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
            DrawHelper.drawGlowRoundedRect((float)TargetHudComponent.x, (float)TargetHudComponent.y, (float)(TargetHudComponent.x + 155), (float)(TargetHudComponent.y + 62), new Color(20, 20, 20, 255).getRGB(), 6.0f, 5.0f);
            if (!this.mc.player.getName().isEmpty()) {
                Minecraft.fontRendererObj.drawStringWithShadow(Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() ? "Protected" : this.mc.player.getName(), (float)(TargetHudComponent.x + 31), (float)(TargetHudComponent.y + 5), -1);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)TargetHudComponent.x, (float)TargetHudComponent.y, 1.0f);
            GL11.glScalef(2.5f, 2.5f, 2.5f);
            GlStateManager.translate((float)(-TargetHudComponent.x - 3), (float)(-TargetHudComponent.y - 2), 1.0f);
            Minecraft.fontRendererObj.drawStringWithShadow(ru.rockstar.api.utils.math.MathHelper.round(this.mc.player.getHealth() / 2.0f, 1) + " \u2764", (float)(TargetHudComponent.x + 16), (float)(TargetHudComponent.y + 10), new Color(ClientHelper.getClientColor().getRGB()).getRGB());
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 137, TargetHudComponent.y + 7);
            this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 137), (float)(TargetHudComponent.y + 1));
            GuiInventory.drawEntityOnScreen(TargetHudComponent.x + 16, TargetHudComponent.y + 55, 25, this.mc.player.rotationYaw, -this.mc.player.rotationPitch, this.mc.player);
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, 120.0, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().darker().getRGB());
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, KillAura.healthBarWidth + lllllllllllIIllllIllIlllllIIIlIl, 8.0, new Color(ClientHelper.getClientColor().getRGB()).darker().darker().getRGB());
            DrawHelper.drawRect2(TargetHudComponent.x + 30, TargetHudComponent.y + 48, lllllllllllIIllllIllIlllllIIIllI, 8.0, new Color(ClientHelper.getClientColor().getRGB()).getRGB());
        }
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Celestial Premium")) {
            if (KillAura.targetHud.getBoolValue() && this.mc.player instanceof EntityPlayer) {
                final ScaledResolution lllllllllllIIllllIllIlllllIIIlII = new ScaledResolution(this.mc);
                final float lllllllllllIIllllIllIlllllIIIIll = (float)lllllllllllIIllllIllIlllllIIIlII.getScaledWidth();
                final float lllllllllllIIllllIllIlllllIIIIlI = (float)lllllllllllIIllllIllIlllllIIIlII.getScaledHeight();
                TargetHudComponent.x = this.getX();
                TargetHudComponent.y = this.getY();
                final float lllllllllllIIllllIllIlllllIIIIIl = this.mc.player.getHealth();
                double lllllllllllIIllllIllIlllllIIIIII = lllllllllllIIllllIllIlllllIIIIIl / this.mc.player.getMaxHealth();
                lllllllllllIIllllIllIlllllIIIIII = MathHelper.clamp(lllllllllllIIllllIllIlllllIIIIII, 0.0, 1.0);
                final double lllllllllllIIllllIllIllllIllllll = 110.0 * lllllllllllIIllllIllIlllllIIIIII;
                final String lllllllllllIIllllIllIllllIlllllI = String.valueOf((int)this.mc.player.getHealth() / 2.0f);
                KillAura.healthBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIllllIllllll, KillAura.healthBarWidth, 5.0 * Feature.deltaTime());
                KillAura.hudHeight = AnimationHelper.animate(40.0, KillAura.hudHeight, 5.0 * Feature.deltaTime());
                DrawHelper.drawNewRect((float)(TargetHudComponent.x + 125), TargetHudComponent.y - 19, TargetHudComponent.x + 275, TargetHudComponent.y + 29, new Color(32, 31, 32, 150).getRGB());
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 120), (float)(TargetHudComponent.y - 26), (float)(TargetHudComponent.x + 280), TargetHudComponent.y + 35.0f, new Color(32, 31, 32, 150).getRGB(), 15.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 127.5), (float)(TargetHudComponent.y - 11.5), (float)(TargetHudComponent.x + 273), (float)(TargetHudComponent.y - 11), new Color(140, 140, 140).getRGB(), 6.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 162.0f, (float)(TargetHudComponent.y + 18), (float)(TargetHudComponent.x + 162.0f + KillAura.healthBarWidth), TargetHudComponent.y + 20.0f, new Color(ClientHelper.getClientColor().getRed() / 255.0f, ClientHelper.getClientColor().getGreen() / 255.0f, ClientHelper.getClientColor().getBlue() / 255.0f, 0.4509804f).getRGB(), 6.0f, 25.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 162.0f, (float)(TargetHudComponent.y + 18), (float)(TargetHudComponent.x + 162.0f + lllllllllllIIllllIllIllllIllllll), (float)(TargetHudComponent.y + 20), ClientHelper.getClientColor().getRGB(), 6.0f, 25.0f);
                this.mc.sfui16.drawStringWithShadow("Ground: " + (this.mc.player.onGround ? "true;" : "false;"), TargetHudComponent.x + 162.0f, TargetHudComponent.y - 3.0f, -1);
                this.mc.sfui16.drawStringWithShadow("HurtTime", TargetHudComponent.x + 162.5f, TargetHudComponent.y + 7.0f, -1);
                this.mc.neverlose500_13.drawCenteredString(this.mc.player.getName(), (float)(TargetHudComponent.x + 199.2753623188406), (float)(TargetHudComponent.y - 16.7), -1);
                final double lllllllllllIIllllIllIllllIllllIl = MathHelper.clamp(this.mc.player.hurtTime, 1.0, 0.3);
                final double lllllllllllIIllllIllIllllIllllII = 71.0 * lllllllllllIIllllIllIllllIllllIl;
                KillAura.hurttimeBarWidth = AnimationHelper.animate(lllllllllllIIllllIllIllllIllllII, KillAura.hurttimeBarWidth, 0.0529999852180481);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 201.0f, TargetHudComponent.y + 9.0f, (float)(TargetHudComponent.x + 272), (float)(TargetHudComponent.y + 11), new Color(40, 40, 40).getRGB(), 2.0f, 10.0f);
                DrawHelper.drawGlowRoundedRect(TargetHudComponent.x + 201.0f, TargetHudComponent.y + 9.0f, (float)(TargetHudComponent.x + 201 + KillAura.hurttimeBarWidth), (float)(TargetHudComponent.y + 11), ClientHelper.getClientColor().getRGB(), 2.0f, 4.0f);
                this.mc.getRenderItem().renderItemOverlays(Minecraft.fontRendererObj, this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 255, TargetHudComponent.y - 5);
                this.mc.getRenderItem().renderItemIntoGUI(this.mc.player.getHeldItem(EnumHand.OFF_HAND), (float)(TargetHudComponent.x + 259), (float)(TargetHudComponent.y - 10));
                DrawHelper.drawGlowRoundedRect((float)(TargetHudComponent.x + 125.5), TargetHudComponent.y - 20.5f, (float)(TargetHudComponent.x + 275), (float)(TargetHudComponent.y - 18), ClientHelper.getClientColor().getRGB(), 4.0f, 6.0f);
                Util.drawHead3(Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.player.getUniqueID()).getLocationSkin(), TargetHudComponent.x + 127 + this.mc.player.hurtTime / 2, (int)(TargetHudComponent.y - 8.0f) + this.mc.player.hurtTime / 2, 32 - this.mc.player.hurtTime, 32 - this.mc.player.hurtTime);
            }
            else {
                KillAura.healthBarWidth = 92.0;
                KillAura.hudHeight = 0.0;
            }
        }
        if (lllllllllllIIllllIllIlllllIlIIIl.equalsIgnoreCase("Red-Blue")) {
            if (this.mc.gameSettings.ofFastRender) {
                this.mc.gameSettings.ofFastRender = false;
            }
            final ScaledResolution lllllllllllIIllllIllIllllIlllIll = new ScaledResolution(this.mc);
            final float lllllllllllIIllllIllIllllIlllIlI = (float)lllllllllllIIllllIllIllllIlllIll.getScaledWidth();
            final float lllllllllllIIllllIllIllllIlllIIl = (float)lllllllllllIIllllIllIllllIlllIll.getScaledHeight();
            TargetHudComponent.x = (int)(lllllllllllIIllllIllIllllIlllIlI / 2.0f - this.getX());
            TargetHudComponent.y = (int)(lllllllllllIIllllIllIllllIlllIIl / 2.0f + this.getY());
            final double lllllllllllIIllllIllIllllIlllIII = this.mc.player.getTotalArmorValue() * 4.8f;
            double lllllllllllIIllllIllIllllIllIlll = this.mc.player.getHealth() / this.mc.player.getMaxHealth() * 96.0f;
            lllllllllllIIllllIllIllllIllIlll = MathHelper.clamp(lllllllllllIIllllIllIllllIllIlll, 0.0, 96.0);
            KillAura.healthBarWidth = MathHelper.clamp(KillAura.healthBarWidth, 0.0, 104.0);
            final float lllllllllllIIllllIllIllllIllIllI = (float)TargetHudComponent.x;
            final float lllllllllllIIllllIllIllllIllIlIl = (float)TargetHudComponent.y;
            final float lllllllllllIIllllIllIllllIllIlII = lllllllllllIIllllIllIllllIllIllI + 48.0f + 120.0f;
            GlStateManager.pushMatrix();
            GlStateManager.disableBlend();
            DrawHelper.blurAreaBoarder((float)TargetHudComponent.x, (float)TargetHudComponent.y, 148.0f, 45.0f, 120.0f, 0.0f, 1.0f);
            DrawHelper.drawRect(TargetHudComponent.x - 1.0f, TargetHudComponent.y - 0.5f, lllllllllllIIllllIllIllllIllIlII - 168.0f, TargetHudComponent.y + 45.0f, new Color(205, 205, 205).getRGB());
            if (this.mc.player instanceof EntityPlayer) {
                this.mc.robotoRegular.drawStringWithShadow(this.mc.player.getName(), TargetHudComponent.x + 8.0f, TargetHudComponent.y + 5.0f, -1);
            }
            DrawHelper.renderItem(this.mc.player.getHeldItem(EnumHand.OFF_HAND), TargetHudComponent.x + 133, TargetHudComponent.y - 20);
            if (Minecraft.getDebugFPS() > 5) {
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 19.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 19.0f, (float)KillAura.healthBarWidth, 5.0f, Color.RED.getRGB());
                DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 28.0f, 96.0f, 5.0f, new Color(35, 35, 35, 255).getRGB());
                if (this.mc.player.getTotalArmorValue() > 0) {
                    DrawHelper.drawSmoothRectBetter(TargetHudComponent.x + 4.0f, TargetHudComponent.y + Minecraft.fontRendererObj.getStringHeight((Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) ? "Protected" : this.mc.player.getName()) + 28.0f, (float)lllllllllllIIllllIllIllllIlllIII, 5.0f, new Color(55, 175, 255).getRGB());
                }
                this.mc.player.getTotalArmorValue();
            }
            GlStateManager.pushMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            for (final NetworkPlayerInfo lllllllllllIIllllIllIllllIllIIll : this.mc.player.connection.getPlayerInfoMap()) {
                if (lllllllllllIIllllIllIllllIllIIll == null) {
                    continue;
                }
                if (!(this.mc.player instanceof EntityPlayer)) {
                    continue;
                }
                if (this.mc.world.getPlayerEntityByUUID(lllllllllllIIllllIllIllllIllIIll.getGameProfile().getId()) == this.mc.player) {
                    final float lllllllllllIIllllIllIllllIllIIlI = (this.mc.player.hurtTime - this.mc.timer.renderPartialTicks) / 8.0f;
                    GlStateManager.color(1.0f, 1.0f - lllllllllllIIllllIllIllllIllIIlI, 1.0f - lllllllllllIIllllIllIllllIllIIlI, 1.0f);
                    this.mc.getTextureManager().bindTexture(lllllllllllIIllllIllIllllIllIIll.getLocationSkin());
                    Gui.drawScaledCustomSizeModalRect(TargetHudComponent.x + 104, TargetHudComponent.y, 8.0f, 8.0f, 8, 8, 44, 44, 64.0f, 64.0f);
                    GlStateManager.bindTexture(0);
                }
                GL11.glDisable(3089);
            }
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
        super.draw();
    }
}
