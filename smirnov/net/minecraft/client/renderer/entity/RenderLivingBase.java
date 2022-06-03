// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import org.apache.logging.log4j.LogManager;
import net.optifine.entity.model.CustomEntityModels;
import ru.rockstar.api.event.event.EventNameTags;
import optifine.Reflector;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import net.minecraft.client.renderer.GLAllocation;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.visuals.Chams;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Team;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import java.util.List;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.model.ModelBase;
import java.nio.FloatBuffer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;

public abstract class RenderLivingBase<T extends EntityLivingBase> extends Render<T>
{
    public static /* synthetic */ float NAME_TAG_RANGE;
    public /* synthetic */ float renderHeadPitch;
    private static final /* synthetic */ DynamicTexture TEXTURE_BRIGHTNESS;
    protected /* synthetic */ FloatBuffer brightnessBuffer;
    public /* synthetic */ float renderAgeInTicks;
    public /* synthetic */ float renderHeadYaw;
    public /* synthetic */ ModelBase mainModel;
    public static final /* synthetic */ boolean animateModelLiving;
    protected /* synthetic */ boolean renderMarker;
    public /* synthetic */ float renderLimbSwing;
    public /* synthetic */ float renderScaleFactor;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ float renderLimbSwingAmount;
    public static /* synthetic */ float NAME_TAG_RANGE_SNEAK;
    protected /* synthetic */ List<LayerRenderer<T>> layerRenderers;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible() {
        final int[] $switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible = RenderLivingBase.$SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
        if ($switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible != null) {
            return $switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
        }
        final byte llllllllllllllIIIllIlIlIIlIIlIlI = (Object)new int[Team.EnumVisible.values().length];
        try {
            llllllllllllllIIIllIlIlIIlIIlIlI[Team.EnumVisible.ALWAYS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIllIlIlIIlIIlIlI[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIllIlIlIIlIIlIlI[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIllIlIlIIlIIlIlI[Team.EnumVisible.NEVER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return RenderLivingBase.$SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible = (int[])(Object)llllllllllllllIIIllIlIlIIlIIlIlI;
    }
    
    protected boolean func_193115_c(final T llllllllllllllIIIllIlIllIIIlllll) {
        return !llllllllllllllIIIllIlIllIIIlllll.isInvisible() || this.renderOutlines;
    }
    
    @Override
    protected boolean canRenderName(final T llllllllllllllIIIllIlIlIIlllIlll) {
        final EntityPlayerSP llllllllllllllIIIllIlIlIIlllIllI = Minecraft.getMinecraft().player;
        final boolean llllllllllllllIIIllIlIlIIlllIlIl = !llllllllllllllIIIllIlIlIIlllIlll.isInvisibleToPlayer(llllllllllllllIIIllIlIlIIlllIllI);
        if (llllllllllllllIIIllIlIlIIlllIlll != llllllllllllllIIIllIlIlIIlllIllI) {
            final Team llllllllllllllIIIllIlIlIIlllIlII = llllllllllllllIIIllIlIlIIlllIlll.getTeam();
            final Team llllllllllllllIIIllIlIlIIlllIIll = llllllllllllllIIIllIlIlIIlllIllI.getTeam();
            if (llllllllllllllIIIllIlIlIIlllIlII != null) {
                final Team.EnumVisible llllllllllllllIIIllIlIlIIlllIIlI = llllllllllllllIIIllIlIlIIlllIlII.getNameTagVisibility();
                switch ($SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible()[llllllllllllllIIIllIlIlIIlllIIlI.ordinal()]) {
                    case 1: {
                        return llllllllllllllIIIllIlIlIIlllIlIl;
                    }
                    case 2: {
                        return false;
                    }
                    case 3: {
                        return (llllllllllllllIIIllIlIlIIlllIIll == null) ? llllllllllllllIIIllIlIlIIlllIlIl : (llllllllllllllIIIllIlIlIIlllIlII.isSameTeam(llllllllllllllIIIllIlIlIIlllIIll) && (llllllllllllllIIIllIlIlIIlllIlII.getSeeFriendlyInvisiblesEnabled() || llllllllllllllIIIllIlIlIIlllIlIl));
                    }
                    case 4: {
                        return (llllllllllllllIIIllIlIlIIlllIIll == null) ? llllllllllllllIIIllIlIlIIlllIlIl : (!llllllllllllllIIIllIlIlIIlllIlII.isSameTeam(llllllllllllllIIIllIlIlIIlllIIll) && llllllllllllllIIIllIlIlIIlllIlIl);
                    }
                    default: {
                        return true;
                    }
                }
            }
        }
        return Minecraft.isGuiEnabled() && llllllllllllllIIIllIlIlIIlllIlll != this.renderManager.renderViewEntity && llllllllllllllIIIllIlIlIIlllIlIl && !llllllllllllllIIIllIlIlIIlllIlll.isBeingRidden();
    }
    
    protected void renderLayers(final T llllllllllllllIIIllIlIlIlIlllIIl, final float llllllllllllllIIIllIlIlIlIlIllIl, final float llllllllllllllIIIllIlIlIlIllIlll, final float llllllllllllllIIIllIlIlIlIlIlIll, final float llllllllllllllIIIllIlIlIlIlIlIlI, final float llllllllllllllIIIllIlIlIlIlIlIIl, final float llllllllllllllIIIllIlIlIlIlIlIII, final float llllllllllllllIIIllIlIlIlIlIIlll) {
        for (final LayerRenderer<T> llllllllllllllIIIllIlIlIlIllIIIl : this.layerRenderers) {
            final boolean llllllllllllllIIIllIlIlIlIllIIII = this.setBrightness(llllllllllllllIIIllIlIlIlIlllIIl, llllllllllllllIIIllIlIlIlIlIlIll, llllllllllllllIIIllIlIlIlIllIIIl.shouldCombineTextures());
            llllllllllllllIIIllIlIlIlIllIIIl.doRenderLayer(llllllllllllllIIIllIlIlIlIlllIIl, llllllllllllllIIIllIlIlIlIlIllIl, llllllllllllllIIIllIlIlIlIllIlll, llllllllllllllIIIllIlIlIlIlIlIll, llllllllllllllIIIllIlIlIlIlIlIlI, llllllllllllllIIIllIlIlIlIlIlIIl, llllllllllllllIIIllIlIlIlIlIlIII, llllllllllllllIIIllIlIlIlIlIIlll);
            if (llllllllllllllIIIllIlIlIlIllIIII) {
                this.unsetBrightness();
            }
        }
    }
    
    protected void renderModel(final T llllllllllllllIIIllIlIllIIlIllll, final float llllllllllllllIIIllIlIllIIlllIlI, final float llllllllllllllIIIllIlIllIIlIllIl, final float llllllllllllllIIIllIlIllIIlIllII, final float llllllllllllllIIIllIlIllIIlIlIll, final float llllllllllllllIIIllIlIllIIlIlIlI, final float llllllllllllllIIIllIlIllIIlIlIIl) {
        final boolean llllllllllllllIIIllIlIllIIllIlII = this.func_193115_c(llllllllllllllIIIllIlIllIIlIllll);
        final boolean llllllllllllllIIIllIlIllIIllIIll = !llllllllllllllIIIllIlIllIIllIlII && !llllllllllllllIIIllIlIllIIlIllll.isInvisibleToPlayer(Minecraft.getMinecraft().player);
        final String llllllllllllllIIIllIlIllIIllIIlI = Chams.chamsMode.getCurrentMode();
        final boolean llllllllllllllIIIllIlIllIIllIIIl = Main.featureDirector.getFeatureByClass(Chams.class).isToggled() && llllllllllllllIIIllIlIllIIlIllll instanceof EntityPlayer;
        if (llllllllllllllIIIllIlIllIIllIlII || llllllllllllllIIIllIlIllIIllIIll) {
            if (!this.bindEntityTexture(llllllllllllllIIIllIlIllIIlIllll)) {
                return;
            }
            if (llllllllllllllIIIllIlIllIIllIIll) {
                GlStateManager.enableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
            if (llllllllllllllIIIllIlIllIIllIIIl && llllllllllllllIIIllIlIllIIllIIlI.equalsIgnoreCase("Fill")) {
                GL11.glPushMatrix();
                GlStateManager.disableBlend();
                GL11.glEnable(10754);
                GL11.glPolygonOffset(1.0f, 1000000.0f);
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
                GL11.glEnable(3042);
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glBlendFunc(770, 771);
                if (!Chams.clientColor.getBoolValue()) {
                    DrawHelper.setColor(Chams.colorChams.getColorValue());
                }
                else {
                    DrawHelper.setColor(ClientHelper.getClientColor().getRGB());
                }
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
            }
            this.mainModel.render(llllllllllllllIIIllIlIllIIlIllll, llllllllllllllIIIllIlIllIIlllIlI, llllllllllllllIIIllIlIllIIlIllIl, llllllllllllllIIIllIlIllIIlIllII, llllllllllllllIIIllIlIllIIlIlIll, llllllllllllllIIIllIlIllIIlIlIlI, llllllllllllllIIIllIlIllIIlIlIIl);
            if (llllllllllllllIIIllIlIllIIllIIIl && llllllllllllllIIIllIlIllIIllIIlI.equalsIgnoreCase("Fill")) {
                GlStateManager.disableBlend();
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                if (!Chams.clientColor.getBoolValue()) {
                    DrawHelper.setColor(Chams.colorChams.getColorValue());
                }
                else {
                    DrawHelper.setColor(ClientHelper.getClientColor().getRGB());
                }
                this.mainModel.render(llllllllllllllIIIllIlIllIIlIllll, llllllllllllllIIIllIlIllIIlllIlI, llllllllllllllIIIllIlIllIIlIllIl, llllllllllllllIIIllIlIllIIlIllII, llllllllllllllIIIllIlIllIIlIlIll, llllllllllllllIIIllIlIllIIlIlIlI, llllllllllllllIIIllIlIllIIlIlIIl);
                GL11.glEnable(3553);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glPolygonOffset(1.0f, -1000000.0f);
                GL11.glDisable(10754);
                GL11.glPopMatrix();
            }
            if (llllllllllllllIIIllIlIllIIllIIll) {
                GlStateManager.disableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
        }
    }
    
    protected float interpolateRotation(final float llllllllllllllIIIllIlIlllIIlIlII, final float llllllllllllllIIIllIlIlllIIlIIll, final float llllllllllllllIIIllIlIlllIIIlllI) {
        float llllllllllllllIIIllIlIlllIIlIIIl;
        for (llllllllllllllIIIllIlIlllIIlIIIl = llllllllllllllIIIllIlIlllIIlIIll - llllllllllllllIIIllIlIlllIIlIlII; llllllllllllllIIIllIlIlllIIlIIIl < -180.0f; llllllllllllllIIIllIlIlllIIlIIIl += 360.0f) {}
        while (llllllllllllllIIIllIlIlllIIlIIIl >= 180.0f) {
            llllllllllllllIIIllIlIlllIIlIIIl -= 360.0f;
        }
        return llllllllllllllIIIllIlIlllIIlIlII + llllllllllllllIIIllIlIlllIIIlllI * llllllllllllllIIIllIlIlllIIlIIIl;
    }
    
    public <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean addLayer(final U llllllllllllllIIIllIlIlllIIlllIl) {
        return this.layerRenderers.add((LayerRenderer<T>)llllllllllllllIIIllIlIlllIIlllIl);
    }
    
    public float prepareScale(final T llllllllllllllIIIllIlIllIlIlIIlI, final float llllllllllllllIIIllIlIllIlIIllIl) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.preRenderCallback(llllllllllllllIIIllIlIllIlIlIIlI, llllllllllllllIIIllIlIllIlIIllIl);
        final float llllllllllllllIIIllIlIllIlIlIIII = 0.0625f;
        GlStateManager.translate(0.0f, -1.501f, 0.0f);
        return 0.0625f;
    }
    
    public void transformHeldFull3DItemLayer() {
    }
    
    protected boolean setBrightness(final T llllllllllllllIIIllIlIllIIIIlIII, final float llllllllllllllIIIllIlIllIIIIIlll, final boolean llllllllllllllIIIllIlIllIIIIIllI) {
        final float llllllllllllllIIIllIlIllIIIIIlIl = llllllllllllllIIIllIlIllIIIIlIII.getBrightness();
        final int llllllllllllllIIIllIlIllIIIIIlII = this.getColorMultiplier(llllllllllllllIIIllIlIllIIIIlIII, llllllllllllllIIIllIlIllIIIIIlIl, llllllllllllllIIIllIlIllIIIIIlll);
        final boolean llllllllllllllIIIllIlIllIIIIIIll = (llllllllllllllIIIllIlIllIIIIIlII >> 24 & 0xFF) > 0;
        final boolean llllllllllllllIIIllIlIllIIIIIIlI = llllllllllllllIIIllIlIllIIIIlIII.hurtTime > 0 || llllllllllllllIIIllIlIllIIIIlIII.deathTime > 0;
        if (!llllllllllllllIIIllIlIllIIIIIIll && !llllllllllllllIIIllIlIllIIIIIIlI) {
            return false;
        }
        if (!llllllllllllllIIIllIlIllIIIIIIll && !llllllllllllllIIIllIlIllIIIIIllI) {
            return false;
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND2_RGB, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        this.brightnessBuffer.position(0);
        if (llllllllllllllIIIllIlIllIIIIIIlI) {
            this.brightnessBuffer.put(1.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.3f);
            if (Config.isShaders()) {
                Shaders.setEntityColor(1.0f, 0.0f, 0.0f, 0.3f);
            }
        }
        else {
            final float llllllllllllllIIIllIlIllIIIIIIIl = (llllllllllllllIIIllIlIllIIIIIlII >> 24 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIlIllIIIIIIII = (llllllllllllllIIIllIlIllIIIIIlII >> 16 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIlIlIllllllll = (llllllllllllllIIIllIlIllIIIIIlII >> 8 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIlIlIlllllllI = (llllllllllllllIIIllIlIllIIIIIlII & 0xFF) / 255.0f;
            this.brightnessBuffer.put(llllllllllllllIIIllIlIllIIIIIIII);
            this.brightnessBuffer.put(llllllllllllllIIIllIlIlIllllllll);
            this.brightnessBuffer.put(llllllllllllllIIIllIlIlIlllllllI);
            this.brightnessBuffer.put(1.0f - llllllllllllllIIIllIlIllIIIIIIIl);
            if (Config.isShaders()) {
                Shaders.setEntityColor(llllllllllllllIIIllIlIllIIIIIIII, llllllllllllllIIIllIlIlIllllllll, llllllllllllllIIIllIlIlIlllllllI, 1.0f - llllllllllllllIIIllIlIllIIIIIIIl);
            }
        }
        this.brightnessBuffer.flip();
        GlStateManager.glTexEnv(8960, 8705, this.brightnessBuffer);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(RenderLivingBase.TEXTURE_BRIGHTNESS.getGlTextureId());
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    protected boolean setScoreTeamColor(final T llllllllllllllIIIllIlIllIlIIlIlI) {
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    protected void unsetScoreTeamColor() {
        GlStateManager.enableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    protected boolean setDoRenderBrightness(final T llllllllllllllIIIllIlIllIIIlIlll, final float llllllllllllllIIIllIlIllIIIllIIl) {
        return this.setBrightness(llllllllllllllIIIllIlIllIIIlIlll, llllllllllllllIIIllIlIllIIIllIIl, true);
    }
    
    protected float handleRotationFloat(final T llllllllllllllIIIllIlIlIllIIlIII, final float llllllllllllllIIIllIlIlIllIIlIIl) {
        return llllllllllllllIIIllIlIlIllIIlIII.ticksExisted + llllllllllllllIIIllIlIlIllIIlIIl;
    }
    
    protected int getColorMultiplier(final T llllllllllllllIIIllIlIlIlIlIIIII, final float llllllllllllllIIIllIlIlIlIIlllll, final float llllllllllllllIIIllIlIlIlIIllllI) {
        return 0;
    }
    
    public RenderLivingBase(final RenderManager llllllllllllllIIIllIlIlllIlIlIIl, final ModelBase llllllllllllllIIIllIlIlllIlIIlII, final float llllllllllllllIIIllIlIlllIlIIIll) {
        super(llllllllllllllIIIllIlIlllIlIlIIl);
        this.brightnessBuffer = GLAllocation.createDirectFloatBuffer(4);
        this.layerRenderers = (List<LayerRenderer<T>>)Lists.newArrayList();
        this.mainModel = llllllllllllllIIIllIlIlllIlIIlII;
        this.shadowSize = llllllllllllllIIIllIlIlllIlIIIll;
    }
    
    protected void rotateCorpse(final T llllllllllllllIIIllIlIlIllIllIII, final float llllllllllllllIIIllIlIlIllIllllI, final float llllllllllllllIIIllIlIlIllIlIlll, final float llllllllllllllIIIllIlIlIllIlllII) {
        GlStateManager.rotate(180.0f - llllllllllllllIIIllIlIlIllIlIlll, 0.0f, 1.0f, 0.0f);
        if (llllllllllllllIIIllIlIlIllIllIII.deathTime > 0) {
            float llllllllllllllIIIllIlIlIllIllIll = (llllllllllllllIIIllIlIlIllIllIII.deathTime + llllllllllllllIIIllIlIlIllIlllII - 1.0f) / 20.0f * 1.6f;
            llllllllllllllIIIllIlIlIllIllIll = MathHelper.sqrt(llllllllllllllIIIllIlIlIllIllIll);
            if (llllllllllllllIIIllIlIlIllIllIll > 1.0f) {
                llllllllllllllIIIllIlIlIllIllIll = 1.0f;
            }
            GlStateManager.rotate(llllllllllllllIIIllIlIlIllIllIll * this.getDeathMaxRotation(llllllllllllllIIIllIlIlIllIllIII), 0.0f, 0.0f, 1.0f);
        }
        else {
            final String llllllllllllllIIIllIlIlIllIllIlI = TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIIllIlIlIllIllIII.getName());
            if (llllllllllllllIIIllIlIlIllIllIlI != null && ("Dinnerbone".equals(llllllllllllllIIIllIlIlIllIllIlI) || "Grumm".equals(llllllllllllllIIIllIlIlIllIllIlI)) && (!(llllllllllllllIIIllIlIlIllIllIII instanceof EntityPlayer) || ((EntityPlayer)llllllllllllllIIIllIlIlIllIllIII).isWearing(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate(0.0f, llllllllllllllIIIllIlIlIllIllIII.height + 0.1f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }
    
    protected void unsetBrightness() {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_ALPHA, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.disableTexture2D();
        GlStateManager.bindTexture(0);
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.setEntityColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    public void renderName(final T llllllllllllllIIIllIlIlIlIIIIlll, final double llllllllllllllIIIllIlIlIlIIIIllI, final double llllllllllllllIIIllIlIlIlIIIIlIl, final double llllllllllllllIIIllIlIlIlIIIIlII) {
        if (!Reflector.RenderLivingEvent_Specials_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Pre_Constructor, new Object[] { llllllllllllllIIIllIlIlIlIIIIlll, this, llllllllllllllIIIllIlIlIlIIIIllI, llllllllllllllIIIllIlIlIlIIIIlIl, llllllllllllllIIIllIlIlIlIIIIlII })) {
            if (this.canRenderName(llllllllllllllIIIllIlIlIlIIIIlll)) {
                final double llllllllllllllIIIllIlIlIlIIIllII = llllllllllllllIIIllIlIlIlIIIIlll.getDistanceSqToEntity(this.renderManager.renderViewEntity);
                final float llllllllllllllIIIllIlIlIlIIIlIll = llllllllllllllIIIllIlIlIlIIIIlll.isSneaking() ? RenderLivingBase.NAME_TAG_RANGE_SNEAK : RenderLivingBase.NAME_TAG_RANGE;
                if (llllllllllllllIIIllIlIlIlIIIllII < llllllllllllllIIIllIlIlIlIIIlIll * llllllllllllllIIIllIlIlIlIIIlIll) {
                    final EventNameTags llllllllllllllIIIllIlIlIlIIIlIlI = new EventNameTags(llllllllllllllIIIllIlIlIlIIIIlll, llllllllllllllIIIllIlIlIlIIIIlll.getDisplayName().getFormattedText());
                    llllllllllllllIIIllIlIlIlIIIlIlI.call();
                    if (llllllllllllllIIIllIlIlIlIIIlIlI.isCancelled()) {
                        return;
                    }
                    final String llllllllllllllIIIllIlIlIlIIIlIIl = llllllllllllllIIIllIlIlIlIIIIlll.getDisplayName().getFormattedText();
                    GlStateManager.alphaFunc(516, 0.1f);
                    this.renderEntityName(llllllllllllllIIIllIlIlIlIIIIlll, llllllllllllllIIIllIlIlIlIIIIllI, llllllllllllllIIIllIlIlIlIIIIlIl, llllllllllllllIIIllIlIlIlIIIIlII, llllllllllllllIIIllIlIlIlIIIlIIl, llllllllllllllIIIllIlIlIlIIIllII);
                }
            }
            if (Reflector.RenderLivingEvent_Specials_Post_Constructor.exists()) {
                Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Post_Constructor, new Object[] { llllllllllllllIIIllIlIlIlIIIIlll, this, llllllllllllllIIIllIlIlIlIIIIllI, llllllllllllllIIIllIlIlIlIIIIlIl, llllllllllllllIIIllIlIlIlIIIIlII });
            }
        }
    }
    
    protected float getSwingProgress(final T llllllllllllllIIIllIlIlIllIlIIIl, final float llllllllllllllIIIllIlIlIllIIlllI) {
        return llllllllllllllIIIllIlIlIllIlIIIl.getSwingProgress(llllllllllllllIIIllIlIlIllIIlllI);
    }
    
    @Override
    public void doRender(final T llllllllllllllIIIllIlIllIllIIllI, final double llllllllllllllIIIllIlIllIllllIIl, final double llllllllllllllIIIllIlIllIllllIII, final double llllllllllllllIIIllIlIllIlllIlll, final float llllllllllllllIIIllIlIllIllIIIlI, final float llllllllllllllIIIllIlIllIllIIIIl) {
        if (!Reflector.RenderLivingEvent_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Pre_Constructor, new Object[] { llllllllllllllIIIllIlIllIllIIllI, this, llllllllllllllIIIllIlIllIllIIIIl, llllllllllllllIIIllIlIllIllllIIl, llllllllllllllIIIllIlIllIllllIII, llllllllllllllIIIllIlIllIlllIlll })) {
            if (RenderLivingBase.animateModelLiving) {
                llllllllllllllIIIllIlIllIllIIllI.limbSwingAmount = 1.0f;
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            this.mainModel.swingProgress = this.getSwingProgress(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIIIIl);
            this.mainModel.isRiding = llllllllllllllIIIllIlIllIllIIllI.isRiding();
            if (Reflector.ForgeEntity_shouldRiderSit.exists()) {
                this.mainModel.isRiding = (llllllllllllllIIIllIlIllIllIIllI.isRiding() && llllllllllllllIIIllIlIllIllIIllI.getRidingEntity() != null && Reflector.callBoolean((Object)llllllllllllllIIIllIlIllIllIIllI.getRidingEntity(), Reflector.ForgeEntity_shouldRiderSit, new Object[0]));
            }
            this.mainModel.isChild = llllllllllllllIIIllIlIllIllIIllI.isChild();
            try {
                float llllllllllllllIIIllIlIllIlllIlII = this.interpolateRotation(llllllllllllllIIIllIlIllIllIIllI.prevRenderYawOffset, llllllllllllllIIIllIlIllIllIIllI.renderYawOffset, llllllllllllllIIIllIlIllIllIIIIl);
                final float llllllllllllllIIIllIlIllIlllIIll = this.interpolateRotation(llllllllllllllIIIllIlIllIllIIllI.prevRotationYawHead, llllllllllllllIIIllIlIllIllIIllI.rotationYawHead, llllllllllllllIIIllIlIllIllIIIIl);
                float llllllllllllllIIIllIlIllIlllIIlI = llllllllllllllIIIllIlIllIlllIIll - llllllllllllllIIIllIlIllIlllIlII;
                if (this.mainModel.isRiding && llllllllllllllIIIllIlIllIllIIllI.getRidingEntity() instanceof EntityLivingBase) {
                    final EntityLivingBase llllllllllllllIIIllIlIllIlllIIIl = (EntityLivingBase)llllllllllllllIIIllIlIllIllIIllI.getRidingEntity();
                    llllllllllllllIIIllIlIllIlllIlII = this.interpolateRotation(llllllllllllllIIIllIlIllIlllIIIl.prevRenderYawOffset, llllllllllllllIIIllIlIllIlllIIIl.renderYawOffset, llllllllllllllIIIllIlIllIllIIIIl);
                    llllllllllllllIIIllIlIllIlllIIlI = llllllllllllllIIIllIlIllIlllIIll - llllllllllllllIIIllIlIllIlllIlII;
                    float llllllllllllllIIIllIlIllIlllIIII = MathHelper.wrapDegrees(llllllllllllllIIIllIlIllIlllIIlI);
                    if (llllllllllllllIIIllIlIllIlllIIII < -85.0f) {
                        llllllllllllllIIIllIlIllIlllIIII = -85.0f;
                    }
                    if (llllllllllllllIIIllIlIllIlllIIII >= 85.0f) {
                        llllllllllllllIIIllIlIllIlllIIII = 85.0f;
                    }
                    llllllllllllllIIIllIlIllIlllIlII = llllllllllllllIIIllIlIllIlllIIll - llllllllllllllIIIllIlIllIlllIIII;
                    if (llllllllllllllIIIllIlIllIlllIIII * llllllllllllllIIIllIlIllIlllIIII > 2500.0f) {
                        llllllllllllllIIIllIlIllIlllIlII += llllllllllllllIIIllIlIllIlllIIII * 0.2f;
                    }
                    llllllllllllllIIIllIlIllIlllIIlI = llllllllllllllIIIllIlIllIlllIIll - llllllllllllllIIIllIlIllIlllIlII;
                }
                final float llllllllllllllIIIllIlIllIllIllll = (llllllllllllllIIIllIlIllIllIIllI instanceof EntityPlayer && llllllllllllllIIIllIlIllIllIIllI == Minecraft.getMinecraft().player) ? (llllllllllllllIIIllIlIllIllIIllI.prevRotationPitchHead + (llllllllllllllIIIllIlIllIllIIllI.rotationPitchHead - llllllllllllllIIIllIlIllIllIIllI.prevRotationPitchHead) * llllllllllllllIIIllIlIllIllIIIIl) : (llllllllllllllIIIllIlIllIllIIllI.prevRotationPitch + (llllllllllllllIIIllIlIllIllIIllI.rotationPitch - llllllllllllllIIIllIlIllIllIIllI.prevRotationPitch) * llllllllllllllIIIllIlIllIllIIIIl);
                this.renderLivingAt(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllllIIl, llllllllllllllIIIllIlIllIllllIII, llllllllllllllIIIllIlIllIlllIlll);
                final float llllllllllllllIIIllIlIllIllIlllI = this.handleRotationFloat(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIIIIl);
                this.rotateCorpse(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIlII, llllllllllllllIIIllIlIllIllIIIIl);
                final float llllllllllllllIIIllIlIllIllIllIl = this.prepareScale(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIIIIl);
                float llllllllllllllIIIllIlIllIllIllII = 0.0f;
                float llllllllllllllIIIllIlIllIllIlIll = 0.0f;
                if (!llllllllllllllIIIllIlIllIllIIllI.isRiding()) {
                    llllllllllllllIIIllIlIllIllIllII = llllllllllllllIIIllIlIllIllIIllI.prevLimbSwingAmount + (llllllllllllllIIIllIlIllIllIIllI.limbSwingAmount - llllllllllllllIIIllIlIllIllIIllI.prevLimbSwingAmount) * llllllllllllllIIIllIlIllIllIIIIl;
                    llllllllllllllIIIllIlIllIllIlIll = llllllllllllllIIIllIlIllIllIIllI.limbSwing - llllllllllllllIIIllIlIllIllIIllI.limbSwingAmount * (1.0f - llllllllllllllIIIllIlIllIllIIIIl);
                    if (llllllllllllllIIIllIlIllIllIIllI.isChild()) {
                        llllllllllllllIIIllIlIllIllIlIll *= 3.0f;
                    }
                    if (llllllllllllllIIIllIlIllIllIllII > 1.0f) {
                        llllllllllllllIIIllIlIllIllIllII = 1.0f;
                    }
                }
                GlStateManager.enableAlpha();
                this.mainModel.setLivingAnimations(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIIIIl);
                this.mainModel.setRotationAngles(llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIIlI, llllllllllllllIIIllIlIllIllIllll, llllllllllllllIIIllIlIllIllIllIl, llllllllllllllIIIllIlIllIllIIllI);
                if (CustomEntityModels.isActive()) {
                    this.renderLimbSwing = llllllllllllllIIIllIlIllIllIlIll;
                    this.renderLimbSwingAmount = llllllllllllllIIIllIlIllIllIllII;
                    this.renderAgeInTicks = llllllllllllllIIIllIlIllIllIlllI;
                    this.renderHeadYaw = llllllllllllllIIIllIlIllIlllIIlI;
                    this.renderHeadPitch = llllllllllllllIIIllIlIllIllIllll;
                    this.renderScaleFactor = llllllllllllllIIIllIlIllIllIllIl;
                }
                if (this.renderOutlines) {
                    final boolean llllllllllllllIIIllIlIllIllIlIlI = this.setScoreTeamColor(llllllllllllllIIIllIlIllIllIIllI);
                    GlStateManager.enableColorMaterial();
                    GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIIIllIlIllIllIIllI));
                    if (!this.renderMarker) {
                        this.renderModel(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIIlI, llllllllllllllIIIllIlIllIllIllll, llllllllllllllIIIllIlIllIllIllIl);
                    }
                    if (!(llllllllllllllIIIllIlIllIllIIllI instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllIlIllIllIIllI).isSpectator()) {
                        this.renderLayers(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIIIIl, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIIlI, llllllllllllllIIIllIlIllIllIllll, llllllllllllllIIIllIlIllIllIllIl);
                    }
                    GlStateManager.disableOutlineMode();
                    GlStateManager.disableColorMaterial();
                    if (llllllllllllllIIIllIlIllIllIlIlI) {
                        this.unsetScoreTeamColor();
                    }
                }
                else {
                    final boolean llllllllllllllIIIllIlIllIllIlIIl = this.setDoRenderBrightness(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIIIIl);
                    this.renderModel(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIIlI, llllllllllllllIIIllIlIllIllIllll, llllllllllllllIIIllIlIllIllIllIl);
                    if (llllllllllllllIIIllIlIllIllIlIIl) {
                        this.unsetBrightness();
                    }
                    GlStateManager.depthMask(true);
                    if (!(llllllllllllllIIIllIlIllIllIIllI instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllIlIllIllIIllI).isSpectator()) {
                        this.renderLayers(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllIlIll, llllllllllllllIIIllIlIllIllIllII, llllllllllllllIIIllIlIllIllIIIIl, llllllllllllllIIIllIlIllIllIlllI, llllllllllllllIIIllIlIllIlllIIlI, llllllllllllllIIIllIlIllIllIllll, llllllllllllllIIIllIlIllIllIllIl);
                    }
                }
                GlStateManager.disableRescaleNormal();
            }
            catch (Exception llllllllllllllIIIllIlIllIllIlIII) {
                RenderLivingBase.LOGGER.error("Couldn't render entity", (Throwable)llllllllllllllIIIllIlIllIllIlIII);
            }
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.enableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.enableCull();
            GlStateManager.popMatrix();
            super.doRender(llllllllllllllIIIllIlIllIllIIllI, llllllllllllllIIIllIlIllIllllIIl, llllllllllllllIIIllIlIllIllllIII, llllllllllllllIIIllIlIllIlllIlll, llllllllllllllIIIllIlIllIllIIIlI, llllllllllllllIIIllIlIllIllIIIIl);
            if (Reflector.RenderLivingEvent_Post_Constructor.exists()) {
                Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Post_Constructor, new Object[] { llllllllllllllIIIllIlIllIllIIllI, this, llllllllllllllIIIllIlIllIllIIIIl, llllllllllllllIIIllIlIllIllllIIl, llllllllllllllIIIllIlIllIllllIII, llllllllllllllIIIllIlIllIlllIlll });
            }
        }
    }
    
    protected float getDeathMaxRotation(final T llllllllllllllIIIllIlIlIlIlIIIlI) {
        return 90.0f;
    }
    
    public List<LayerRenderer<T>> getLayerRenderers() {
        return this.layerRenderers;
    }
    
    public ModelBase getMainModel() {
        return this.mainModel;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        TEXTURE_BRIGHTNESS = new DynamicTexture(16, 16);
        RenderLivingBase.NAME_TAG_RANGE = 64.0f;
        RenderLivingBase.NAME_TAG_RANGE_SNEAK = 32.0f;
        animateModelLiving = Boolean.getBoolean("animate.model.living");
        final int[] llllllllllllllIIIllIlIlllIllIIlI = RenderLivingBase.TEXTURE_BRIGHTNESS.getTextureData();
        for (int llllllllllllllIIIllIlIlllIllIIIl = 0; llllllllllllllIIIllIlIlllIllIIIl < 256; ++llllllllllllllIIIllIlIlllIllIIIl) {
            llllllllllllllIIIllIlIlllIllIIlI[llllllllllllllIIIllIlIlllIllIIIl] = -1;
        }
        RenderLivingBase.TEXTURE_BRIGHTNESS.updateDynamicTexture();
    }
    
    protected void preRenderCallback(final T llllllllllllllIIIllIlIlIlIIlllII, final float llllllllllllllIIIllIlIlIlIIllIll) {
    }
    
    protected void renderLivingAt(final T llllllllllllllIIIllIlIlIlllIllII, final double llllllllllllllIIIllIlIlIlllIlIll, final double llllllllllllllIIIllIlIlIlllIlIlI, final double llllllllllllllIIIllIlIlIlllIIllI) {
        GlStateManager.translate((float)llllllllllllllIIIllIlIlIlllIlIll, (float)llllllllllllllIIIllIlIlIlllIlIlI, (float)llllllllllllllIIIllIlIlIlllIIllI);
    }
}
