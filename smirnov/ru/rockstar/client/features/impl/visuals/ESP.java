// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityAnimal;
import ru.rockstar.client.ui.settings.Setting;
import java.util.ArrayList;
import net.minecraft.client.renderer.GLAllocation;
import ru.rockstar.client.features.Category;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import ru.rockstar.api.utils.shader.shaders.FlowShader;
import net.minecraft.entity.item.EntityItem;
import ru.rockstar.api.utils.shader.shaders.EntityGlowShader;
import java.awt.Color;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.utils.shader.shaders.OutlineShader;
import net.minecraft.client.renderer.GlStateManager;
import javax.vecmath.Vector4d;
import javax.vecmath.Vector3d;
import net.minecraft.util.math.AxisAlignedBB;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;
import ru.rockstar.api.event.event.Event2D;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventNameTags;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import java.nio.IntBuffer;
import ru.rockstar.api.utils.shader.FramebufferShader;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import java.nio.FloatBuffer;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class ESP extends Feature
{
    public static /* synthetic */ ListSetting espMode;
    private final /* synthetic */ int black;
    private final /* synthetic */ int backgroundColor;
    private final /* synthetic */ FloatBuffer modelview;
    public /* synthetic */ BooleanSetting name;
    /* synthetic */ boolean nameTags;
    public /* synthetic */ FramebufferShader framebuffer;
    private final /* synthetic */ IntBuffer viewport;
    public static /* synthetic */ ColorSetting color;
    public /* synthetic */ BooleanSetting health;
    private final /* synthetic */ FloatBuffer projection;
    public /* synthetic */ BooleanSetting showArmor;
    public static /* synthetic */ ColorSetting colorfriend;
    private final /* synthetic */ FloatBuffer vector;
    
    @EventTarget
    public void onRenderName(final EventNameTags lllllllllllIIlIIlIIIlllIllllllII) {
        if (!this.isToggled()) {
            return;
        }
        lllllllllllIIlIIlIIIlllIllllllII.setCancelled(this.name.getBoolValue());
    }
    
    @EventTarget
    public void onRender2D(final Event2D lllllllllllIIlIIlIIIllllIllIIIII) {
        final String lllllllllllIIlIIlIIIllllIlIlllll = ESP.espMode.getOptions();
        this.setSuffix(lllllllllllIIlIIlIIIllllIlIlllll, true);
        GL11.glPushMatrix();
        final float lllllllllllIIlIIlIIIllllIlIllllI = ESP.mc.timer.renderPartialTicks;
        final int lllllllllllIIlIIlIIIllllIlIlllIl = ScaledResolution.getScaleFactor();
        final double lllllllllllIIlIIlIIIllllIlIlllII = lllllllllllIIlIIlIIIllllIlIlllIl / Math.pow(lllllllllllIIlIIlIIIllllIlIlllIl, 2.0);
        GL11.glScaled(lllllllllllIIlIIlIIIllllIlIlllII, lllllllllllIIlIIlIIIllllIlIlllII, lllllllllllIIlIIlIIIllllIlIlllII);
        final int lllllllllllIIlIIlIIIllllIlIllIll = this.black;
        final float lllllllllllIIlIIlIIIllllIlIllIlI = 1.0f;
        final float lllllllllllIIlIIlIIIllllIlIllIIl = 1.0f / lllllllllllIIlIIlIIIllllIlIllIlI;
        final RenderManager lllllllllllIIlIIlIIIllllIlIllIII = ESP.mc.getRenderManager();
        final EntityRenderer lllllllllllIIlIIlIIIllllIlIlIlll = ESP.mc.entityRenderer;
        for (final Entity lllllllllllIIlIIlIIIllllIlIlIllI : ESP.mc.world.loadedEntityList) {
            if (this.isValid(lllllllllllIIlIIlIIIllllIlIlIllI) && DrawHelper.isInViewFrustrum(lllllllllllIIlIIlIIIllllIlIlIllI)) {
                final double lllllllllllIIlIIlIIIllllIlIlIlIl = DrawHelper.interpolate(lllllllllllIIlIIlIIIllllIlIlIllI.posX, lllllllllllIIlIIlIIIllllIlIlIllI.lastTickPosX, lllllllllllIIlIIlIIIllllIlIllllI);
                final double lllllllllllIIlIIlIIIllllIlIlIlII = DrawHelper.interpolate(lllllllllllIIlIIlIIIllllIlIlIllI.posY, lllllllllllIIlIIlIIIllllIlIlIllI.lastTickPosY, lllllllllllIIlIIlIIIllllIlIllllI);
                final double lllllllllllIIlIIlIIIllllIlIlIIll = DrawHelper.interpolate(lllllllllllIIlIIlIIIllllIlIlIllI.posZ, lllllllllllIIlIIlIIIllllIlIlIllI.lastTickPosZ, lllllllllllIIlIIlIIIllllIlIllllI);
                final double lllllllllllIIlIIlIIIllllIlIlIIlI = lllllllllllIIlIIlIIIllllIlIlIllI.width / 1.5;
                final double lllllllllllIIlIIlIIIllllIlIlIIIl = lllllllllllIIlIIlIIIllllIlIlIllI.height + ((lllllllllllIIlIIlIIIllllIlIlIllI.isSneaking() || (lllllllllllIIlIIlIIIllllIlIlIllI == ESP.mc.player && ESP.mc.player.isSneaking())) ? -0.3 : 0.2);
                final AxisAlignedBB lllllllllllIIlIIlIIIllllIlIlIIII = new AxisAlignedBB(lllllllllllIIlIIlIIIllllIlIlIlIl - lllllllllllIIlIIlIIIllllIlIlIIlI, lllllllllllIIlIIlIIIllllIlIlIlII, lllllllllllIIlIIlIIIllllIlIlIIll - lllllllllllIIlIIlIIIllllIlIlIIlI, lllllllllllIIlIIlIIIllllIlIlIlIl + lllllllllllIIlIIlIIIllllIlIlIIlI, lllllllllllIIlIIlIIIllllIlIlIlII + lllllllllllIIlIIlIIIllllIlIlIIIl, lllllllllllIIlIIlIIIllllIlIlIIll + lllllllllllIIlIIlIIIllllIlIlIIlI);
                final Vector3d[] lllllllllllIIlIIlIIIllllIlIIllll = { new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.minX, lllllllllllIIlIIlIIIllllIlIlIIII.minY, lllllllllllIIlIIlIIIllllIlIlIIII.minZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.minX, lllllllllllIIlIIlIIIllllIlIlIIII.maxY, lllllllllllIIlIIlIIIllllIlIlIIII.minZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.maxX, lllllllllllIIlIIlIIIllllIlIlIIII.minY, lllllllllllIIlIIlIIIllllIlIlIIII.minZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.maxX, lllllllllllIIlIIlIIIllllIlIlIIII.maxY, lllllllllllIIlIIlIIIllllIlIlIIII.minZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.minX, lllllllllllIIlIIlIIIllllIlIlIIII.minY, lllllllllllIIlIIlIIIllllIlIlIIII.maxZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.minX, lllllllllllIIlIIlIIIllllIlIlIIII.maxY, lllllllllllIIlIIlIIIllllIlIlIIII.maxZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.maxX, lllllllllllIIlIIlIIIllllIlIlIIII.minY, lllllllllllIIlIIlIIIllllIlIlIIII.maxZ), new Vector3d(lllllllllllIIlIIlIIIllllIlIlIIII.maxX, lllllllllllIIlIIlIIIllllIlIlIIII.maxY, lllllllllllIIlIIlIIIllllIlIlIIII.maxZ) };
                lllllllllllIIlIIlIIIllllIlIlIlll.setupCameraTransform(lllllllllllIIlIIlIIIllllIlIllllI, 0);
                Vector4d lllllllllllIIlIIlIIIllllIlIIlllI = null;
                final String lllllllllllIIlIIlIIIllllIIIlIIlI;
                final int length = (lllllllllllIIlIIlIIIllllIIIlIIlI = (String)(Object)lllllllllllIIlIIlIIIllllIlIIllll).length;
                for (byte lllllllllllIIlIIlIIIllllIIIlIlII = 0; lllllllllllIIlIIlIIIllllIIIlIlII < length; ++lllllllllllIIlIIlIIIllllIIIlIlII) {
                    Vector3d lllllllllllIIlIIlIIIllllIlIIllIl = lllllllllllIIlIIlIIIllllIIIlIIlI[lllllllllllIIlIIlIIIllllIIIlIlII];
                    lllllllllllIIlIIlIIIllllIlIIllIl = this.project2D(lllllllllllIIlIIlIIIllllIlIlllIl, lllllllllllIIlIIlIIIllllIlIIllIl.x - lllllllllllIIlIIlIIIllllIlIllIII.viewerPosX, lllllllllllIIlIIlIIIllllIlIIllIl.y - lllllllllllIIlIIlIIIllllIlIllIII.viewerPosY, lllllllllllIIlIIlIIIllllIlIIllIl.z - lllllllllllIIlIIlIIIllllIlIllIII.viewerPosZ);
                    if (lllllllllllIIlIIlIIIllllIlIIllIl != null && lllllllllllIIlIIlIIIllllIlIIllIl.z >= 0.0 && lllllllllllIIlIIlIIIllllIlIIllIl.z < 1.0) {
                        if (lllllllllllIIlIIlIIIllllIlIIlllI == null) {
                            lllllllllllIIlIIlIIIllllIlIIlllI = new Vector4d(lllllllllllIIlIIlIIIllllIlIIllIl.x, lllllllllllIIlIIlIIIllllIlIIllIl.y, lllllllllllIIlIIlIIIllllIlIIllIl.z, 0.0);
                        }
                        lllllllllllIIlIIlIIIllllIlIIlllI.x = Math.min(lllllllllllIIlIIlIIIllllIlIIllIl.x, lllllllllllIIlIIlIIIllllIlIIlllI.x);
                        lllllllllllIIlIIlIIIllllIlIIlllI.y = Math.min(lllllllllllIIlIIlIIIllllIlIIllIl.y, lllllllllllIIlIIlIIIllllIlIIlllI.y);
                        lllllllllllIIlIIlIIIllllIlIIlllI.z = Math.max(lllllllllllIIlIIlIIIllllIlIIllIl.x, lllllllllllIIlIIlIIIllllIlIIlllI.z);
                        lllllllllllIIlIIlIIIllllIlIIlllI.w = Math.max(lllllllllllIIlIIlIIIllllIlIIllIl.y, lllllllllllIIlIIlIIIllllIlIIlllI.w);
                    }
                }
                if (lllllllllllIIlIIlIIIllllIlIIlllI == null || lllllllllllIIlIIlIIIllllIlIlIllI == ESP.mc.player) {
                    continue;
                }
                lllllllllllIIlIIlIIIllllIlIlIlll.setupOverlayRendering();
                final double lllllllllllIIlIIlIIIllllIlIIllII = lllllllllllIIlIIlIIIllllIlIIlllI.x;
                final double lllllllllllIIlIIlIIIllllIlIIlIll = lllllllllllIIlIIlIIIllllIlIIlllI.y;
                final double lllllllllllIIlIIlIIIllllIlIIlIlI = lllllllllllIIlIIlIIIllllIlIIlllI.z;
                final double lllllllllllIIlIIlIIIllllIlIIlIIl = lllllllllllIIlIIlIIIllllIlIIlllI.w;
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Chroma")) {
                    GlStateManager.pushMatrix();
                    this.framebuffer = OutlineShader.INSTANCE;
                    OutlineShader.INSTANCE.startDraw(lllllllllllIIlIIlIIIllllIlIllllI);
                    this.nameTags = false;
                    final float lllllllllllIllllIlIlllIIllIIlllI;
                    ESP.mc.world.loadedEntityList.forEach(lllllllllllIIlIIlIIIlllIlllIIIlI -> {
                        if (lllllllllllIIlIIlIIIlllIlllIIIlI != ESP.mc.player && (lllllllllllIIlIIlIIIlllIlllIIIlI instanceof EntityPlayer || lllllllllllIIlIIlIIIlllIlllIIIlI instanceof EntityEnderCrystal)) {
                            ESP.mc.getRenderManager().renderEntityStatic(lllllllllllIIlIIlIIIlllIlllIIIlI, lllllllllllIllllIlIlllIIllIIlllI, true);
                        }
                        return;
                    });
                    this.nameTags = false;
                    OutlineShader.INSTANCE.stopDraw(new Color(209, 209, 209, 120), 1.2f, 1.0f, 0.8f, 2.0f, 0.5f, 0.5f);
                    GlStateManager.popMatrix();
                }
                final EntityGlowShader lllllllllllIIlIIlIIIllllIlIIlIII = EntityGlowShader.GLOW_SHADER;
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Glow")) {
                    ESP.mc.gameSettings.entityShadows = false;
                    lllllllllllIIlIIlIIIllllIlIIlIII.startDraw(lllllllllllIIlIIlIIIllllIlIllllI);
                    for (final Entity lllllllllllIIlIIlIIIllllIlIIIlll : ESP.mc.world.loadedEntityList) {
                        if (this.isValid(lllllllllllIIlIIlIIIllllIlIIIlll)) {
                            if (lllllllllllIIlIIlIIIllllIlIIIlll instanceof EntityItem) {
                                continue;
                            }
                            ESP.mc.getRenderManager().renderEntityStatic(lllllllllllIIlIIlIIIllllIlIIIlll, lllllllllllIIlIIlIIIllllIlIllllI, true);
                        }
                    }
                    lllllllllllIIlIIlIIIllllIlIIlIII.stopDraw(new Color(120, 120, 120, 255), 2.0f, 1.0f, 1.0f, 1.0f, 0.5f, 0.5f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Shader")) {
                    FlowShader.INSTANCE.startDraw(lllllllllllIIlIIlIIIllllIlIllllI);
                    ESP.mc.world.loadedEntityList.stream().filter(lllllllllllIIlIIlIIIlllIllIlllll -> lllllllllllIIlIIlIIIlllIllIlllll instanceof EntityPlayer && lllllllllllIIlIIlIIIlllIllIlllll != ESP.mc.player).forEach(lllllllllllIIlIIlIIIlllIllIlllII -> ESP.mc.getRenderManager().renderEntityStatic(lllllllllllIIlIIlIIIlllIllIlllII, lllllllllllIIlIIlIIIllllIlIllllI, true));
                    FlowShader.INSTANCE.stopDraw(Color.WHITE, 1.0f, 1.0f, 1.0f, 1.0f, 0.5f, 0.5f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("2D")) {
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIllII - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.color.getColorValue());
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII, lllllllllllIIlIIlIIIllllIlIIlIIl - 1.0, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.color.getColorValue());
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIll - 0.5, ESP.color.getColorValue());
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIlIlI - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.color.getColorValue());
                }
                else {
                    final FriendManager friendManager = Main.instance.friendManager;
                    if (FriendManager.isFriend(lllllllllllIIlIIlIIIllllIlIlIllI.getName())) {
                        DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIllII - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.colorfriend.getColorValue());
                        DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII, lllllllllllIIlIIlIIIllllIlIIlIIl - 1.0, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.colorfriend.getColorValue());
                        DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIll - 0.5, ESP.colorfriend.getColorValue());
                        DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIlIlI - 1.0, lllllllllllIIlIIlIIIllllIlIIlIll, lllllllllllIIlIIlIIIllllIlIIlIlI - 0.5, lllllllllllIIlIIlIIIllllIlIIlIIl - 0.5, ESP.colorfriend.getColorValue());
                    }
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Rockstar")) {
                    DrawHelper.drawGlow(lllllllllllIIlIIlIIIllllIlIIllII + 10.0, lllllllllllIIlIIlIIIllllIlIIlIll + 0.0, lllllllllllIIlIIlIIIllllIlIIllII + 10.0, lllllllllllIIlIIlIIIllllIlIIlIll + 60.0, ClientHelper.getClientColor().getRGB());
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Floppa")) {
                    ESP.mc.renderEngine.bindTexture(new ResourceLocation("rockstar/floppa.png"));
                    GlStateManager.color(255.0f, 255.0f, 255.0f);
                    Gui.drawScaledCustomSizeModalRect((int)lllllllllllIIlIIlIIIllllIlIIllII - 20, (int)lllllllllllIIlIIlIIIllllIlIIlIll - 20, 60.0f, 60.0f, 60, 60, 60, 60, 60.0f, 60.0f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Hentai")) {
                    ESP.mc.renderEngine.bindTexture(new ResourceLocation("rockstar/hentai.png"));
                    GlStateManager.color(255.0f, 255.0f, 255.0f);
                    Gui.drawScaledCustomSizeModalRect((int)lllllllllllIIlIIlIIIllllIlIIllII - 20, (int)lllllllllllIIlIIlIIIllllIlIIlIll - 20, 60.0f, 60.0f, 60, 60, 40, 60, 60.0f, 60.0f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Smirnov")) {
                    ESP.mc.renderEngine.bindTexture(new ResourceLocation("rockstar/smirnov.png"));
                    GlStateManager.color(255.0f, 255.0f, 255.0f);
                    Gui.drawScaledCustomSizeModalRect((int)lllllllllllIIlIIlIIIllllIlIIllII - 20, (int)lllllllllllIIlIIlIIIllllIlIIlIll - 20, 60.0f, 60.0f, 60, 60, 60, 60, 60.0f, 60.0f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Putin")) {
                    ESP.mc.renderEngine.bindTexture(new ResourceLocation("rockstar/putin.png"));
                    GlStateManager.color(255.0f, 255.0f, 255.0f);
                    Gui.drawScaledCustomSizeModalRect((int)lllllllllllIIlIIlIIIllllIlIIllII - 20, (int)lllllllllllIIlIIlIIIllllIlIIlIll - 20, 60.0f, 60.0f, 60, 60, 60, 60, 60.0f, 60.0f);
                }
                if (lllllllllllIIlIIlIIIllllIlIlllll.equalsIgnoreCase("Cat")) {
                    ESP.mc.renderEngine.bindTexture(new ResourceLocation("rockstar/cat.png"));
                    GlStateManager.color(255.0f, 255.0f, 255.0f);
                    Gui.drawScaledCustomSizeModalRect((int)lllllllllllIIlIIlIIIllllIlIIllII - 20, (int)lllllllllllIIlIIlIIIllllIlIIlIll - 20, 60.0f, 60.0f, 60, 60, 60, 60, 60.0f, 60.0f);
                }
                final boolean lllllllllllIIlIIlIIIllllIlIIIllI = lllllllllllIIlIIlIIIllllIlIlIllI instanceof EntityLivingBase;
                final EntityLivingBase lllllllllllIIlIIlIIIllllIlIIIIII = (EntityLivingBase)lllllllllllIIlIIlIIIllllIlIlIllI;
                final float lllllllllllIIlIIlIIIllllIIllllll = lllllllllllIIlIIlIIIllllIlIIIIII.getHealth();
                final float lllllllllllIIlIIlIIIllllIIlllllI = lllllllllllIIlIIlIIIllllIlIIIIII.getMaxHealth();
                final double lllllllllllIIlIIlIIIllllIIllllIl = lllllllllllIIlIIlIIIllllIIllllll / lllllllllllIIlIIlIIIllllIIlllllI;
                final double lllllllllllIIlIIlIIIllllIIllllII = (lllllllllllIIlIIlIIIllllIlIIlIIl - lllllllllllIIlIIlIIIllllIlIIlIll) * lllllllllllIIlIIlIIIllllIIllllIl;
                int lllllllllllIIlIIlIIIllllIlIIIIIl = 0;
                if (lllllllllllIIlIIlIIIllllIIllllll <= 4.0f) {
                    final int lllllllllllIIlIIlIIIllllIlIIIlIl = new Color(200, 0, 0).getRGB();
                }
                else if (lllllllllllIIlIIlIIIllllIIllllll <= 8.0f) {
                    final int lllllllllllIIlIIlIIIllllIlIIIlII = new Color(231, 143, 85).getRGB();
                }
                else if (lllllllllllIIlIIlIIIllllIIllllll <= 12.0f) {
                    final int lllllllllllIIlIIlIIIllllIlIIIIll = new Color(219, 201, 106).getRGB();
                }
                else if (lllllllllllIIlIIlIIIllllIIllllll <= 16.0f) {
                    final int lllllllllllIIlIIlIIIllllIlIIIIlI = new Color(117, 231, 85).getRGB();
                }
                else {
                    lllllllllllIIlIIlIIIllllIlIIIIIl = new Color(44, 186, 19).getRGB();
                }
                if (lllllllllllIIlIIlIIIllllIlIIIIII == null || lllllllllllIIlIIlIIIllllIIllllll <= 0.0f) {
                    continue;
                }
                if (lllllllllllIIlIIlIIIllllIlIIIllI && this.health.getBoolValue()) {
                    MathHelper.clamp(lllllllllllIIlIIlIIIllllIIllllll, 0.0f, 20.0f);
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 4.5, lllllllllllIIlIIlIIIllllIlIIlIll - 0.5, lllllllllllIIlIIlIIIllllIlIIllII - 2.5, lllllllllllIIlIIlIIIllllIlIIlIIl + 0.5, new Color(0, 0, 0, 125).getRGB());
                    DrawHelper.drawRect(lllllllllllIIlIIlIIIllllIlIIllII - 4.0, lllllllllllIIlIIlIIIllllIlIIlIIl, lllllllllllIIlIIlIIIllllIlIIllII - 3.0, lllllllllllIIlIIlIIIllllIlIIlIIl - lllllllllllIIlIIlIIIllllIIllllII, lllllllllllIIlIIlIIIllllIlIIIIIl);
                }
                if (lllllllllllIIlIIlIIIllllIlIIIllI && this.name.getBoolValue() && !Main.featureDirector.getFeatureByClass(NameTags.class).isToggled()) {
                    final float lllllllllllIIlIIlIIIllllIIlllIll = 20.0f;
                    String lllllllllllIIlIIlIIIllllIIlllIlI = lllllllllllIIlIIlIIIllllIlIlIllI.getName();
                    if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled()) {
                        lllllllllllIIlIIlIIIllllIIlllIlI = "Protected";
                    }
                    final double lllllllllllIIlIIlIIIllllIIlllIIl = (lllllllllllIIlIIlIIIllllIlIIlIlI - lllllllllllIIlIIlIIIllllIlIIllII) / 2.0;
                    final double lllllllllllIIlIIlIIIllllIIlllIII = Minecraft.fontRendererObj.getStringWidth(String.valueOf(lllllllllllIIlIIlIIIllllIIlllIlI) + " §7" + (int)ESP.mc.player.getDistanceToEntity(lllllllllllIIlIIlIIIllllIlIlIllI) + "m") * lllllllllllIIlIIlIIIllllIlIllIlI;
                    final float lllllllllllIIlIIlIIIllllIIllIlll = (float)((lllllllllllIIlIIlIIIllllIlIIllII + lllllllllllIIlIIlIIIllllIIlllIIl - lllllllllllIIlIIlIIIllllIIlllIII / 2.0) * lllllllllllIIlIIlIIIllllIlIllIIl);
                    final float lllllllllllIIlIIlIIIllllIIllIllI = (float)(lllllllllllIIlIIlIIIllllIlIIlIll * lllllllllllIIlIIlIIIllllIlIllIIl) - lllllllllllIIlIIlIIIllllIIlllIll;
                    GL11.glPushMatrix();
                    GlStateManager.scale(lllllllllllIIlIIlIIIllllIlIllIlI, lllllllllllIIlIIlIIIllllIlIllIlI, lllllllllllIIlIIlIIIllllIlIllIlI);
                    Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIIlIIlIIIllllIIlllIlI, lllllllllllIIlIIlIIIllllIIllIlll, lllllllllllIIlIIlIIIllllIIllIllI, Color.WHITE.getRGB());
                    GL11.glPopMatrix();
                }
                if (!lllllllllllIIlIIlIIIllllIlIIIllI || !this.showArmor.getBoolValue() || !(lllllllllllIIlIIlIIIllllIlIlIllI instanceof EntityPlayer)) {
                    continue;
                }
                final EntityPlayer lllllllllllIIlIIlIIIllllIIllIlIl = (EntityPlayer)lllllllllllIIlIIlIIIllllIlIlIllI;
                final double lllllllllllIIlIIlIIIllllIIllIlII = (lllllllllllIIlIIlIIIllllIlIIlIIl - lllllllllllIIlIIlIIIllllIlIIlIll) / 4.0;
                final ItemStack lllllllllllIIlIIlIIIllllIIllIIll = lllllllllllIIlIIlIIIllllIIllIlIl.getEquipmentInSlot(4);
                if (ESP.mc.player.getDistanceToEntity(lllllllllllIIlIIlIIIllllIIllIlIl) > 15.0f) {
                    continue;
                }
                if (lllllllllllIIlIIlIIIllllIIllIIll != null) {
                    final double lllllllllllIIlIIlIIIllllIIllIIlI = lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII - 1.0 - (lllllllllllIIlIIlIIIllllIlIIlIll + 2.0);
                    final double lllllllllllIIlIIlIIIllllIIllIIIl = 1.0 - lllllllllllIIlIIlIIIllllIIllIIll.getItemDamage() / (double)lllllllllllIIlIIlIIIllllIIllIIll.getMaxDamage();
                    DrawHelper.renderItem(lllllllllllIIlIIlIIIllllIIllIIll, (int)lllllllllllIIlIIlIIIllllIlIIlIlI + 4, (int)lllllllllllIIlIIlIIIllllIlIIlIll + (int)lllllllllllIIlIIlIIIllllIIllIlII - 1 - (int)(lllllllllllIIlIIlIIIllllIIllIIlI / 2.0) - 18);
                }
                final ItemStack lllllllllllIIlIIlIIIllllIIllIIII = lllllllllllIIlIIlIIIllllIIllIlIl.getEquipmentInSlot(3);
                if (lllllllllllIIlIIlIIIllllIIllIIII != null) {
                    final double lllllllllllIIlIIlIIIllllIIlIllll = lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 2.0 - (lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII + 2.0);
                    final String lllllllllllIIlIIlIIIllllIIlIlllI = lllllllllllIIlIIlIIIllllIIllIIll.getDisplayName().equalsIgnoreCase("Air") ? "0" : ((lllllllllllIIlIIlIIIllllIIllIIII.getItem() instanceof ItemArmor) ? new StringBuilder(String.valueOf(lllllllllllIIlIIlIIIllllIIllIIII.getMaxDamage() - lllllllllllIIlIIlIIIllllIIllIIII.getItemDamage())).toString() : lllllllllllIIlIIlIIIllllIIllIIII.getDisplayName());
                    if (ESP.mc.player.getDistanceToEntity(lllllllllllIIlIIlIIIllllIIllIlIl) < 10.0f) {
                        DrawHelper.renderItem(lllllllllllIIlIIlIIIllllIIllIIII, (int)lllllllllllIIlIIlIIIllllIlIIlIlI + 4, (int)(lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 2.0) - (int)(lllllllllllIIlIIlIIIllllIIlIllll / 2.0) - 18);
                    }
                }
                final ItemStack lllllllllllIIlIIlIIIllllIIlIllIl = lllllllllllIIlIIlIIIllllIIllIlIl.getEquipmentInSlot(2);
                if (lllllllllllIIlIIlIIIllllIIlIllIl != null) {
                    final double lllllllllllIIlIIlIIIllllIIlIllII = lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 3.0 - (lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 2.0 + 2.0);
                    if (ESP.mc.player.getDistanceToEntity(lllllllllllIIlIIlIIIllllIIllIlIl) < 10.0f) {
                        DrawHelper.renderItem(lllllllllllIIlIIlIIIllllIIlIllIl, (int)lllllllllllIIlIIlIIIllllIlIIlIlI + 4, (int)(lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 3.0) - (int)(lllllllllllIIlIIlIIIllllIIlIllII / 2.0) - 18);
                    }
                }
                final ItemStack lllllllllllIIlIIlIIIllllIIlIlIll = lllllllllllIIlIIlIIIllllIIllIlIl.getEquipmentInSlot(1);
                final double lllllllllllIIlIIlIIIllllIIlIlIlI = lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 4.0 - (lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 3.0 + 2.0);
                if (ESP.mc.player.getDistanceToEntity(lllllllllllIIlIIlIIIllllIIllIlIl) >= 10.0f) {
                    continue;
                }
                DrawHelper.renderItem(lllllllllllIIlIIlIIIllllIIlIlIll, (int)lllllllllllIIlIIlIIIllllIlIIlIlI + 4, (int)(lllllllllllIIlIIlIIIllllIlIIlIll + lllllllllllIIlIIlIIIllllIIllIlII * 4.0) - (int)(lllllllllllIIlIIlIIIllllIIlIlIlI / 2.0) - 18);
            }
        }
        GL11.glPopMatrix();
        GL11.glEnable(2929);
        GlStateManager.enableBlend();
        lllllllllllIIlIIlIIIllllIlIlIlll.setupOverlayRendering();
    }
    
    static {
        ESP.color = new ColorSetting("Color", new Color(16777215).getRGB(), () -> true);
        ESP.colorfriend = new ColorSetting("FriendColor", new Color(65535).getRGB(), () -> true);
    }
    
    public ESP() {
        super("ESP", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u043d\u0438\u043a \u0438 \u0438\u0445 \u0437\u0434\u043e\u0440\u043e\u0432\u044c\u0435 \u0441\u043a\u0432\u043e\u0437\u044c \u0441\u0442\u0435\u043d\u044b", 0, Category.VISUALS);
        this.viewport = GLAllocation.createDirectIntBuffer(16);
        this.modelview = GLAllocation.createDirectFloatBuffer(16);
        this.projection = GLAllocation.createDirectFloatBuffer(16);
        this.vector = GLAllocation.createDirectFloatBuffer(4);
        this.backgroundColor = new Color(0, 0, 0, 120).getRGB();
        this.black = Color.BLACK.getRGB();
        this.framebuffer = null;
        final ArrayList<String> lllllllllllIIlIIlIIIlllllIIIlllI = new ArrayList<String>();
        ESP.espMode = new ListSetting("Mode", "2D", () -> true, new String[] { "Chroma", "Glow", "Shader", "2D", "Rockstar", "Hentai", "Cat", "Floppa", "Putin" });
        this.showArmor = new BooleanSetting("Show Armor", false, () -> true);
        this.name = new BooleanSetting("Name", false, () -> true);
        this.health = new BooleanSetting("Health", false, () -> true);
        this.addSettings(ESP.espMode, this.showArmor, this.name, this.health, ESP.color, ESP.colorfriend);
    }
    
    private boolean isValid(final Entity lllllllllllIIlIIlIIIlllIllllIllI) {
        return (ESP.mc.gameSettings.thirdPersonView != 0 || lllllllllllIIlIIlIIIlllIllllIllI != ESP.mc.player) && !lllllllllllIIlIIlIIIlllIllllIllI.isDead && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityAnimal) && (lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityPlayer || (!(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityArmorStand) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof IAnimals) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityItemFrame) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityArrow) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntitySpectralArrow) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityMinecart) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityBoat) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityDragonFireball) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityXPOrb) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityMinecartChest) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityTNTPrimed) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityMinecartTNT) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityVillager) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityExpBottle) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityLightningBolt) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityPotion) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof Entity) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityMob) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntitySlime) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityDragon) && !(lllllllllllIIlIIlIIIlllIllllIllI instanceof EntityGolem) && lllllllllllIIlIIlIIIlllIllllIllI != ESP.mc.player));
    }
    
    private Vector3d project2D(final int lllllllllllIIlIIlIIIlllIlllIllll, final double lllllllllllIIlIIlIIIlllIlllIlIIl, final double lllllllllllIIlIIlIIIlllIlllIllIl, final double lllllllllllIIlIIlIIIlllIlllIllII) {
        GL11.glGetFloat(2982, this.modelview);
        GL11.glGetFloat(2983, this.projection);
        GL11.glGetInteger(2978, this.viewport);
        if (GLU.gluProject((float)lllllllllllIIlIIlIIIlllIlllIlIIl, (float)lllllllllllIIlIIlIIIlllIlllIllIl, (float)lllllllllllIIlIIlIIIlllIlllIllII, this.modelview, this.projection, this.viewport, this.vector)) {
            return new Vector3d((double)(this.vector.get(0) / lllllllllllIIlIIlIIIlllIlllIllll), (double)((Display.getHeight() - this.vector.get(1)) / lllllllllllIIlIIlIIIlllIlllIllll), (double)this.vector.get(2));
        }
        return null;
    }
}
