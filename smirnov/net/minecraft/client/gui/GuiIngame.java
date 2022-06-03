// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.potion.Potion;
import ru.rockstar.api.utils.render.ClientHelper;
import optifine.Reflector;
import net.minecraft.potion.PotionEffect;
import com.google.common.collect.Ordering;
import net.minecraft.client.gui.inventory.GuiContainer;
import ru.rockstar.api.event.event.EventRender2D;
import ru.rockstar.client.features.impl.visuals.ScoreBoard;
import ru.rockstar.api.event.event.Event2D;
import net.minecraft.item.Item;
import java.util.Iterator;
import java.util.Collection;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.ScorePlayerTeam;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import net.minecraft.scoreboard.Score;
import com.google.common.base.Predicate;
import net.minecraft.scoreboard.ScoreObjective;
import optifine.TextureAnimations;
import net.minecraft.client.gui.chat.OverlayChatListener;
import net.minecraft.client.gui.chat.NormalChatListener;
import net.minecraft.client.gui.chat.NarratorChatListener;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.util.StringUtils;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.FoodStats;
import net.minecraft.block.material.Material;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.TextureMap;
import optifine.CustomItems;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.text.ITextComponent;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.visuals.NoRender;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.resources.I18n;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.settings.GameSettings;
import ru.rockstar.client.features.impl.visuals.Crosshair;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.inventory.IInventory;
import optifine.ReflectorForge;
import net.minecraft.util.math.RayTraceResult;
import optifine.CustomColors;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.display.Hotbar;
import ru.rockstar.Main;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import optifine.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.chat.IChatListener;
import java.util.List;
import net.minecraft.util.text.ChatType;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.RenderItem;

public class GuiIngame extends Gui
{
    private /* synthetic */ String displayedSubTitle;
    /* synthetic */ double last;
    private /* synthetic */ long healthUpdateCounter;
    private final /* synthetic */ RenderItem itemRenderer;
    private final /* synthetic */ GuiPlayerTabOverlay overlayPlayerList;
    private /* synthetic */ int titlesTimer;
    private /* synthetic */ int remainingHighlightTicks;
    private static final /* synthetic */ ResourceLocation WIDGETS_TEX_PATH;
    private final /* synthetic */ GuiOverlayDebug overlayDebug;
    private /* synthetic */ int recordPlayingUpFor;
    private final /* synthetic */ GuiNewChat persistantChatGUI;
    private /* synthetic */ int titleDisplayTime;
    private static final /* synthetic */ ResourceLocation PUMPKIN_BLUR_TEX_PATH;
    private final /* synthetic */ Map<ChatType, List<IChatListener>> field_191743_I;
    private final /* synthetic */ GuiSpectator spectatorGui;
    private final /* synthetic */ GuiSubtitleOverlay overlaySubtitle;
    private /* synthetic */ long lastSystemTime;
    public /* synthetic */ float prevVignetteBrightness;
    private /* synthetic */ ItemStack highlightingItemStack;
    private /* synthetic */ int lastPlayerHealth;
    private /* synthetic */ int titleFadeIn;
    private /* synthetic */ String recordPlaying;
    private /* synthetic */ int updateCounter;
    private /* synthetic */ String displayedTitle;
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ResourceLocation VIGNETTE_TEX_PATH;
    private final /* synthetic */ GuiBossOverlay overlayBoss;
    private /* synthetic */ boolean recordIsPlaying;
    private final /* synthetic */ Random rand;
    private /* synthetic */ int titleFadeOut;
    private /* synthetic */ int playerHealth;
    /* synthetic */ double deltaSpeed;
    
    private void renderMountHealth(final ScaledResolution lllllllllllIllIlllllIllllllIllII) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer lllllllllllIllIlllllIlllllllllIl = (EntityPlayer)this.mc.getRenderViewEntity();
            final Entity lllllllllllIllIlllllIlllllllllII = lllllllllllIllIlllllIlllllllllIl.getRidingEntity();
            if (lllllllllllIllIlllllIlllllllllII instanceof EntityLivingBase) {
                this.mc.mcProfiler.endStartSection("mountHealth");
                final EntityLivingBase lllllllllllIllIlllllIllllllllIll = (EntityLivingBase)lllllllllllIllIlllllIlllllllllII;
                final int lllllllllllIllIlllllIllllllllIlI = (int)Math.ceil(lllllllllllIllIlllllIllllllllIll.getHealth());
                final float lllllllllllIllIlllllIllllllllIIl = lllllllllllIllIlllllIllllllllIll.getMaxHealth();
                int lllllllllllIllIlllllIllllllllIII = (int)(lllllllllllIllIlllllIllllllllIIl + 0.5f) / 2;
                if (lllllllllllIllIlllllIllllllllIII > 30) {
                    lllllllllllIllIlllllIllllllllIII = 30;
                }
                final int lllllllllllIllIlllllIlllllllIlll = lllllllllllIllIlllllIllllllIllII.getScaledHeight() - 39;
                final int lllllllllllIllIlllllIlllllllIllI = lllllllllllIllIlllllIllllllIllII.getScaledWidth() / 2 + 91;
                int lllllllllllIllIlllllIlllllllIlIl = lllllllllllIllIlllllIlllllllIlll;
                int lllllllllllIllIlllllIlllllllIlII = 0;
                final boolean lllllllllllIllIlllllIlllllllIIll = false;
                while (lllllllllllIllIlllllIllllllllIII > 0) {
                    final int lllllllllllIllIlllllIlllllllIIlI = Math.min(lllllllllllIllIlllllIllllllllIII, 10);
                    lllllllllllIllIlllllIllllllllIII -= lllllllllllIllIlllllIlllllllIIlI;
                    for (int lllllllllllIllIlllllIlllllllIIIl = 0; lllllllllllIllIlllllIlllllllIIIl < lllllllllllIllIlllllIlllllllIIlI; ++lllllllllllIllIlllllIlllllllIIIl) {
                        final int lllllllllllIllIlllllIlllllllIIII = 52;
                        final int lllllllllllIllIlllllIllllllIllll = 0;
                        final int lllllllllllIllIlllllIllllllIlllI = lllllllllllIllIlllllIlllllllIllI - lllllllllllIllIlllllIlllllllIIIl * 8 - 9;
                        this.drawTexturedModalRect(lllllllllllIllIlllllIllllllIlllI, lllllllllllIllIlllllIlllllllIlIl, 52 + lllllllllllIllIlllllIllllllIllll * 9, 9, 9, 9);
                        if (lllllllllllIllIlllllIlllllllIIIl * 2 + 1 + lllllllllllIllIlllllIlllllllIlII < lllllllllllIllIlllllIllllllllIlI) {
                            this.drawTexturedModalRect(lllllllllllIllIlllllIllllllIlllI, lllllllllllIllIlllllIlllllllIlIl, 88, 9, 9, 9);
                        }
                        if (lllllllllllIllIlllllIlllllllIIIl * 2 + 1 + lllllllllllIllIlllllIlllllllIlII == lllllllllllIllIlllllIllllllllIlI) {
                            this.drawTexturedModalRect(lllllllllllIllIlllllIllllllIlllI, lllllllllllIllIlllllIlllllllIlIl, 97, 9, 9, 9);
                        }
                    }
                    lllllllllllIllIlllllIlllllllIlIl -= 10;
                    lllllllllllIllIlllllIlllllllIlII += 20;
                }
            }
        }
    }
    
    private void renderVignette(float lllllllllllIllIlllllIllllIllllII, final ScaledResolution lllllllllllIllIlllllIlllllIIIlII) {
        if (!Config.isVignetteEnabled()) {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
        else {
            lllllllllllIllIlllllIllllIllllII = 1.0f - lllllllllllIllIlllllIllllIllllII;
            lllllllllllIllIlllllIllllIllllII = (String)MathHelper.clamp((float)lllllllllllIllIlllllIllllIllllII, 0.0f, 1.0f);
            final WorldBorder lllllllllllIllIlllllIlllllIIIIll = this.mc.world.getWorldBorder();
            float lllllllllllIllIlllllIlllllIIIIlI = (float)lllllllllllIllIlllllIlllllIIIIll.getClosestDistance(this.mc.player);
            final double lllllllllllIllIlllllIlllllIIIIIl = Math.min(lllllllllllIllIlllllIlllllIIIIll.getResizeSpeed() * lllllllllllIllIlllllIlllllIIIIll.getWarningTime() * 1000.0, Math.abs(lllllllllllIllIlllllIlllllIIIIll.getTargetSize() - lllllllllllIllIlllllIlllllIIIIll.getDiameter()));
            final double lllllllllllIllIlllllIlllllIIIIII = Math.max(lllllllllllIllIlllllIlllllIIIIll.getWarningDistance(), lllllllllllIllIlllllIlllllIIIIIl);
            if (lllllllllllIllIlllllIlllllIIIIlI < lllllllllllIllIlllllIlllllIIIIII) {
                lllllllllllIllIlllllIlllllIIIIlI = 1.0f - (float)(lllllllllllIllIlllllIlllllIIIIlI / lllllllllllIllIlllllIlllllIIIIII);
            }
            else {
                lllllllllllIllIlllllIlllllIIIIlI = 0.0f;
            }
            this.prevVignetteBrightness += (float)((double)(lllllllllllIllIlllllIllllIllllII - this.prevVignetteBrightness) * 0.01);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (lllllllllllIllIlllllIlllllIIIIlI > 0.0f) {
                GlStateManager.color(0.0f, lllllllllllIllIlllllIlllllIIIIlI, lllllllllllIllIlllllIlllllIIIIlI, 1.0f);
            }
            else {
                GlStateManager.color(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0f);
            }
            this.mc.getTextureManager().bindTexture(GuiIngame.VIGNETTE_TEX_PATH);
            final Tessellator lllllllllllIllIlllllIllllIllllll = Tessellator.getInstance();
            final BufferBuilder lllllllllllIllIlllllIllllIlllllI = lllllllllllIllIlllllIllllIllllll.getBuffer();
            lllllllllllIllIlllllIllllIlllllI.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIllIlllllIllllIlllllI.pos(0.0, lllllllllllIllIlllllIlllllIIIlII.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
            lllllllllllIllIlllllIllllIlllllI.pos(lllllllllllIllIlllllIlllllIIIlII.getScaledWidth(), lllllllllllIllIlllllIlllllIIIlII.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
            lllllllllllIllIlllllIllllIlllllI.pos(lllllllllllIllIlllllIlllllIIIlII.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
            lllllllllllIllIlllllIllllIlllllI.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
            lllllllllllIllIlllllIllllIllllll.draw();
            GlStateManager.depthMask(true);
            GlStateManager.enableDepth();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
    }
    
    public GuiSpectator getSpectatorGui() {
        return this.spectatorGui;
    }
    
    static {
        VIGNETTE_TEX_PATH = new ResourceLocation("textures/misc/vignette.png");
        WIDGETS_TEX_PATH = new ResourceLocation("textures/gui/widgets.png");
        PUMPKIN_BLUR_TEX_PATH = new ResourceLocation("textures/misc/pumpkinblur.png");
    }
    
    public void resetPlayersOverlayFooterHeader() {
        this.overlayPlayerList.resetFooterHeader();
        this.overlayBoss.clearBossInfos();
        this.mc.func_193033_an().func_191788_b();
    }
    
    public FontRenderer getFontRenderer() {
        return Minecraft.fontRendererObj;
    }
    
    public void setDefaultTitlesTimes() {
        this.titleFadeIn = 10;
        this.titleDisplayTime = 70;
        this.titleFadeOut = 20;
    }
    
    public void renderExpBar(final ScaledResolution lllllllllllIllIllllllIIIlllIIIII, final int lllllllllllIllIllllllIIIllIlIlII) {
        if (!Main.featureDirector.getFeatureByClass(Hotbar.class).isToggled()) {
            this.mc.mcProfiler.startSection("expBar");
            this.mc.getTextureManager().bindTexture(Gui.ICONS);
            final int lllllllllllIllIllllllIIIllIllllI = this.mc.player.xpBarCap();
            if (lllllllllllIllIllllllIIIllIllllI > 0) {
                final int lllllllllllIllIllllllIIIllIlllIl = 182;
                final int lllllllllllIllIllllllIIIllIlllII = (int)(this.mc.player.experience * 183.0f);
                final int lllllllllllIllIllllllIIIllIllIll = lllllllllllIllIllllllIIIlllIIIII.getScaledHeight() - 32 + 3;
                this.drawTexturedModalRect(lllllllllllIllIllllllIIIllIlIlII, lllllllllllIllIllllllIIIllIllIll, 0, 64, 182, 5);
                if (lllllllllllIllIllllllIIIllIlllII > 0) {
                    this.drawTexturedModalRect(lllllllllllIllIllllllIIIllIlIlII, lllllllllllIllIllllllIIIllIllIll, 0, 69, lllllllllllIllIllllllIIIllIlllII, 5);
                }
            }
            this.mc.mcProfiler.endSection();
            if (this.mc.player.experienceLevel > 0) {
                this.mc.mcProfiler.startSection("expLevel");
                int lllllllllllIllIllllllIIIllIllIlI = 8453920;
                if (Config.isCustomColors()) {
                    lllllllllllIllIllllllIIIllIllIlI = CustomColors.getExpBarTextColor(lllllllllllIllIllllllIIIllIllIlI);
                }
                final String lllllllllllIllIllllllIIIllIllIIl = new StringBuilder().append(this.mc.player.experienceLevel).toString();
                final int lllllllllllIllIllllllIIIllIllIII = (lllllllllllIllIllllllIIIlllIIIII.getScaledWidth() - this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIllIllIIl)) / 2;
                final int lllllllllllIllIllllllIIIllIlIlll = lllllllllllIllIllllllIIIlllIIIII.getScaledHeight() - 31 - 4;
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIllIllIIl, (float)(lllllllllllIllIllllllIIIllIllIII + 1), (float)lllllllllllIllIllllllIIIllIlIlll, 0);
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIllIllIIl, (float)(lllllllllllIllIllllllIIIllIllIII - 1), (float)lllllllllllIllIllllllIIIllIlIlll, 0);
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIllIllIIl, (float)lllllllllllIllIllllllIIIllIllIII, (float)(lllllllllllIllIllllllIIIllIlIlll + 1), 0);
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIllIllIIl, (float)lllllllllllIllIllllllIIIllIllIII, (float)(lllllllllllIllIllllllIIIllIlIlll - 1), 0);
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIllIllIIl, (float)lllllllllllIllIllllllIIIllIllIII, (float)lllllllllllIllIllllllIIIllIlIlll, lllllllllllIllIllllllIIIllIllIlI);
                this.mc.mcProfiler.endSection();
            }
        }
    }
    
    private void renderPumpkinOverlay(final ScaledResolution lllllllllllIllIlllllIlllllIlIIlI) {
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableAlpha();
        this.mc.getTextureManager().bindTexture(GuiIngame.PUMPKIN_BLUR_TEX_PATH);
        final Tessellator lllllllllllIllIlllllIlllllIlIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIllIlllllIlllllIlIlII = lllllllllllIllIlllllIlllllIlIlIl.getBuffer();
        lllllllllllIllIlllllIlllllIlIlII.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIllIlllllIlllllIlIlII.pos(0.0, lllllllllllIllIlllllIlllllIlIIlI.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
        lllllllllllIllIlllllIlllllIlIlII.pos(lllllllllllIllIlllllIlllllIlIIlI.getScaledWidth(), lllllllllllIllIlllllIlllllIlIIlI.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
        lllllllllllIllIlllllIlllllIlIlII.pos(lllllllllllIllIlllllIlllllIlIIlI.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
        lllllllllllIllIlllllIlllllIlIlII.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
        lllllllllllIllIlllllIlllllIlIlIl.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void renderAttackIndicator(final float lllllllllllIllIllllllIIlIlllIlIl, final ScaledResolution lllllllllllIllIllllllIIlIlllIlII) {
        final GameSettings lllllllllllIllIllllllIIlIlllIIll = this.mc.gameSettings;
        if (lllllllllllIllIllllllIIlIlllIIll.thirdPersonView == 0) {
            if (this.mc.playerController.isSpectator() && this.mc.pointedEntity == null) {
                final RayTraceResult lllllllllllIllIllllllIIlIlllIIlI = this.mc.objectMouseOver;
                if (lllllllllllIllIllllllIIlIlllIIlI == null || lllllllllllIllIllllllIIlIlllIIlI.typeOfHit != RayTraceResult.Type.BLOCK) {
                    return;
                }
                final BlockPos lllllllllllIllIllllllIIlIlllIIIl = lllllllllllIllIllllllIIlIlllIIlI.getBlockPos();
                final IBlockState lllllllllllIllIllllllIIlIlllIIII = this.mc.world.getBlockState(lllllllllllIllIllllllIIlIlllIIIl);
                if (!ReflectorForge.blockHasTileEntity(lllllllllllIllIllllllIIlIlllIIII) || !(this.mc.world.getTileEntity(lllllllllllIllIllllllIIlIlllIIIl) instanceof IInventory)) {
                    return;
                }
            }
            final int lllllllllllIllIllllllIIlIllIllll = lllllllllllIllIllllllIIlIlllIlII.getScaledWidth();
            final int lllllllllllIllIllllllIIlIllIlllI = lllllllllllIllIllllllIIlIlllIlII.getScaledHeight();
            if (lllllllllllIllIllllllIIlIlllIIll.showDebugInfo && !lllllllllllIllIllllllIIlIlllIIll.hideGUI && !this.mc.player.hasReducedDebug() && !lllllllllllIllIllllllIIlIlllIIll.reducedDebugInfo) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lllllllllllIllIllllllIIlIllIllll / 2), (float)(lllllllllllIllIllllllIIlIllIlllI / 2), this.zLevel);
                final Entity lllllllllllIllIllllllIIlIllIllIl = this.mc.getRenderViewEntity();
                GlStateManager.rotate(lllllllllllIllIllllllIIlIllIllIl.prevRotationPitch + (lllllllllllIllIllllllIIlIllIllIl.rotationPitch - lllllllllllIllIllllllIIlIllIllIl.prevRotationPitch) * lllllllllllIllIllllllIIlIlllIlIl, -1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lllllllllllIllIllllllIIlIllIllIl.prevRotationYaw + (lllllllllllIllIllllllIIlIllIllIl.rotationYaw - lllllllllllIllIllllllIIlIllIllIl.prevRotationYaw) * lllllllllllIllIllllllIIlIlllIlIl, 0.0f, 1.0f, 0.0f);
                GlStateManager.scale(-1.0f, -1.0f, -1.0f);
                OpenGlHelper.renderDirections(10);
                GlStateManager.popMatrix();
            }
            else {
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.enableAlpha();
                if (!Main.featureDirector.getFeatureByClass(Crosshair.class).isToggled()) {
                    this.drawTexturedModalRect(lllllllllllIllIllllllIIlIllIllll / 2 - 7, lllllllllllIllIllllllIIlIllIlllI / 2 - 7, 0, 0, 16, 16);
                }
                if (this.mc.gameSettings.attackIndicator == 1) {
                    final float lllllllllllIllIllllllIIlIllIllII = this.mc.player.getCooledAttackStrength(0.0f);
                    boolean lllllllllllIllIllllllIIlIllIlIll = false;
                    if (this.mc.pointedEntity != null && this.mc.pointedEntity instanceof EntityLivingBase && lllllllllllIllIllllllIIlIllIllII >= 1.0f) {
                        lllllllllllIllIllllllIIlIllIlIll = (this.mc.player.getCooldownPeriod() > 5.0f);
                        lllllllllllIllIllllllIIlIllIlIll &= ((EntityLivingBase)this.mc.pointedEntity).isEntityAlive();
                    }
                    final int lllllllllllIllIllllllIIlIllIlIlI = lllllllllllIllIllllllIIlIllIlllI / 2 - 7 + 16;
                    final int lllllllllllIllIllllllIIlIllIlIIl = lllllllllllIllIllllllIIlIllIllll / 2 - 8;
                    if (lllllllllllIllIllllllIIlIllIlIll) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIlIllIlIIl, lllllllllllIllIllllllIIlIllIlIlI, 68, 94, 16, 16);
                    }
                    else if (lllllllllllIllIllllllIIlIllIllII < 1.0f) {
                        final int lllllllllllIllIllllllIIlIllIlIII = (int)(lllllllllllIllIllllllIIlIllIllII * 17.0f);
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIlIllIlIIl, lllllllllllIllIllllllIIlIllIlIlI, 36, 94, 16, 4);
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIlIllIlIIl, lllllllllllIllIllllllIIlIllIlIlI, 52, 94, lllllllllllIllIllllllIIlIllIlIII, 4);
                    }
                }
            }
        }
    }
    
    public void setRecordPlayingMessage(final String lllllllllllIllIlllllIlllIlllIIll) {
        this.setRecordPlaying(I18n.format("record.nowPlaying", lllllllllllIllIlllllIlllIlllIIll), true);
    }
    
    public void renderSelectedItem(final ScaledResolution lllllllllllIllIllllllIIIllIIIIIl) {
        this.mc.mcProfiler.startSection("selectedItemName");
        if (this.remainingHighlightTicks > 0 && !this.highlightingItemStack.func_190926_b()) {
            String lllllllllllIllIllllllIIIllIIIllI = this.highlightingItemStack.getDisplayName();
            if (this.highlightingItemStack.hasDisplayName()) {
                lllllllllllIllIllllllIIIllIIIllI = TextFormatting.ITALIC + lllllllllllIllIllllllIIIllIIIllI;
            }
            final int lllllllllllIllIllllllIIIllIIIlIl = (lllllllllllIllIllllllIIIllIIIIIl.getScaledWidth() - this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIllIIIllI)) / 2;
            int lllllllllllIllIllllllIIIllIIIlII = lllllllllllIllIllllllIIIllIIIIIl.getScaledHeight() - 59;
            if (!this.mc.playerController.shouldDrawHUD()) {
                lllllllllllIllIllllllIIIllIIIlII += 14;
            }
            int lllllllllllIllIllllllIIIllIIIIll = (int)(this.remainingHighlightTicks * 256.0f / 10.0f);
            if (lllllllllllIllIllllllIIIllIIIIll > 255) {
                lllllllllllIllIllllllIIIllIIIIll = 255;
            }
            if (lllllllllllIllIllllllIIIllIIIIll > 0 && !NoRender.itemGui.getBoolValue()) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                DrawHelper.drawRectWithGlow(lllllllllllIllIllllllIIIllIIIlIl - 5.0f, lllllllllllIllIllllllIIIllIIIlII - 5.0f - 12.0f, lllllllllllIllIllllllIIIllIIIlIl + (float)Minecraft.getMinecraft().neverlose500_20.getStringWidth(lllllllllllIllIllllllIIIllIIIllI) + 5.0f, lllllllllllIllIllllllIIIllIIIlII + 15.0f - 10.0f, 5.0, 10.0, new Color(0, 0, 0, 255));
                Minecraft.getMinecraft().neverlose500_20.drawStringWithShadow(lllllllllllIllIllllllIIIllIIIllI, (float)lllllllllllIllIllllllIIIllIIIlIl, lllllllllllIllIllllllIIIllIIIlII - 10.0f, 16777215 + (lllllllllllIllIllllllIIIllIIIIll << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void func_191742_a(final ChatType lllllllllllIllIlllllIlllIlIIIlII, final ITextComponent lllllllllllIllIlllllIlllIlIIIlll) {
        for (final IChatListener lllllllllllIllIlllllIlllIlIIIllI : this.field_191743_I.get(lllllllllllIllIlllllIlllIlIIIlII)) {
            lllllllllllIllIlllllIlllIlIIIllI.func_192576_a(lllllllllllIllIlllllIlllIlIIIlII, lllllllllllIllIlllllIlllIlIIIlll);
        }
    }
    
    protected void renderHotbar(final ScaledResolution lllllllllllIllIllllllIIlIIlIIIlI, final float lllllllllllIllIllllllIIlIIlIIIIl) {
        if (!(this.mc.currentScreen instanceof GuiChat)) {
            if (Main.featureDirector.getFeatureByClass(Hotbar.class).isToggled()) {
                DrawHelper.drawRectWithGlow(lllllllllllIllIllllllIIlIIlIIIlI.getScaledWidth() / 2 + 94, lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 23 - Feature.deltaTime(), lllllllllllIllIllllllIIlIIlIIIlI.getScaledWidth() / 2 - 94, lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight(), 5.0, 10.0, new Color(10, 10, 10));
                final double lllllllllllIllIllllllIIlIIlIIIII = lllllllllllIllIllllllIIlIIlIIIlI.getScaledWidth() / 2 - 91 + this.mc.player.inventory.currentItem * 20;
                final double lllllllllllIllIllllllIIlIIIlllll = (lllllllllllIllIllllllIIlIIlIIIII - this.last) / Math.max((float)Minecraft.getDebugFPS(), 5.0f) * 15.0;
                if (Math.abs(lllllllllllIllIllllllIIlIIIlllll) > Math.abs(lllllllllllIllIllllllIIlIIlIIIII - this.last)) {
                    this.last = lllllllllllIllIllllllIIlIIlIIIII;
                }
                else {
                    this.last += lllllllllllIllIllllllIIlIIIlllll;
                }
                DrawHelper.drawRectWithGlow((float)this.last, lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 23 - Feature.deltaTime(), (float)this.last + 182.0f - this.mc.player.inventory.currentItem * 20 - 20 * (8 - this.mc.player.inventory.currentItem), lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - Feature.deltaTime(), 5.0, 5.0, new Color(255, 255, 255));
                GlStateManager.disableBlend();
            }
            else if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc.getTextureManager().bindTexture(GuiIngame.WIDGETS_TEX_PATH);
                final EntityPlayer lllllllllllIllIllllllIIlIIIllllI = (EntityPlayer)this.mc.getRenderViewEntity();
                final ItemStack lllllllllllIllIllllllIIlIIIlllIl = lllllllllllIllIllllllIIlIIIllllI.getHeldItemOffhand();
                final EnumHandSide lllllllllllIllIllllllIIlIIIlllII = lllllllllllIllIllllllIIlIIIllllI.getPrimaryHand().opposite();
                final int lllllllllllIllIllllllIIlIIIllIll = lllllllllllIllIllllllIIlIIlIIIlI.getScaledWidth() / 2;
                final float lllllllllllIllIllllllIIlIIIllIlI = this.zLevel;
                final int lllllllllllIllIllllllIIlIIIllIIl = 182;
                final int lllllllllllIllIllllllIIlIIIllIII = 91;
                this.zLevel = -90.0f;
                this.drawTexturedModalRect((float)(lllllllllllIllIllllllIIlIIIllIll - 91), (float)(lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 22 - Feature.deltaTime()), 0, 0, 182, 22);
                this.drawTexturedModalRect((float)(lllllllllllIllIllllllIIlIIIllIll - 91 - 1 + lllllllllllIllIllllllIIlIIIllllI.inventory.currentItem * 20), (float)(lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 22 - 1 - Feature.deltaTime()), 0, 22, 24, 22);
            }
            if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc.getTextureManager().bindTexture(GuiIngame.WIDGETS_TEX_PATH);
                final EntityPlayer lllllllllllIllIllllllIIlIIIlIlll = (EntityPlayer)this.mc.getRenderViewEntity();
                final ItemStack lllllllllllIllIllllllIIlIIIlIllI = lllllllllllIllIllllllIIlIIIlIlll.getHeldItemOffhand();
                final EnumHandSide lllllllllllIllIllllllIIlIIIlIlIl = lllllllllllIllIllllllIIlIIIlIlll.getPrimaryHand().opposite();
                final int lllllllllllIllIllllllIIlIIIlIlII = lllllllllllIllIllllllIIlIIlIIIlI.getScaledWidth() / 2;
                final float lllllllllllIllIllllllIIlIIIlIIll = this.zLevel;
                this.zLevel = -90.0f;
                if (Main.featureDirector.getFeatureByClass(Hotbar.class).isToggled() && !lllllllllllIllIllllllIIlIIIlIllI.func_190926_b()) {
                    if (lllllllllllIllIllllllIIlIIIlIlIl == EnumHandSide.LEFT) {
                        this.drawTexturedModalRect((float)(lllllllllllIllIllllllIIlIIIlIlII - 91 - 29), (float)(lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 23 - Feature.deltaTime()), 24, 22, 29, 24);
                    }
                    else {
                        this.drawTexturedModalRect((float)(lllllllllllIllIllllllIIlIIIlIlII + 91), (float)(lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 23 - Feature.deltaTime()), 53, 22, 29, 24);
                    }
                }
                this.zLevel = lllllllllllIllIllllllIIlIIIlIIll;
                GlStateManager.enableRescaleNormal();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                RenderHelper.enableGUIStandardItemLighting();
                CustomItems.setRenderOffHand(false);
                for (int lllllllllllIllIllllllIIlIIIlIIlI = 0; lllllllllllIllIllllllIIlIIIlIIlI < 9; ++lllllllllllIllIllllllIIlIIIlIIlI) {
                    final int lllllllllllIllIllllllIIlIIIlIIIl = lllllllllllIllIllllllIIlIIIlIlII - 90 + lllllllllllIllIllllllIIlIIIlIIlI * 20 + 2;
                    final int lllllllllllIllIllllllIIlIIIlIIII = lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 16 - 3;
                    this.renderHotbarItem(lllllllllllIllIllllllIIlIIIlIIIl, (int)(lllllllllllIllIllllllIIlIIIlIIII - Feature.deltaTime()), lllllllllllIllIllllllIIlIIlIIIIl, lllllllllllIllIllllllIIlIIIlIlll, lllllllllllIllIllllllIIlIIIlIlll.inventory.mainInventory.get(lllllllllllIllIllllllIIlIIIlIIlI));
                }
                if (!lllllllllllIllIllllllIIlIIIlIllI.func_190926_b()) {
                    CustomItems.setRenderOffHand(true);
                    final int lllllllllllIllIllllllIIlIIIIllll = (int)(lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 16 - 3 - Feature.deltaTime());
                    if (lllllllllllIllIllllllIIlIIIlIlIl == EnumHandSide.LEFT) {
                        this.renderHotbarItem(lllllllllllIllIllllllIIlIIIlIlII - 91 - 26, lllllllllllIllIllllllIIlIIIIllll, lllllllllllIllIllllllIIlIIlIIIIl, lllllllllllIllIllllllIIlIIIlIlll, lllllllllllIllIllllllIIlIIIlIllI);
                    }
                    else {
                        this.renderHotbarItem(lllllllllllIllIllllllIIlIIIlIlII + 91 + 10, lllllllllllIllIllllllIIlIIIIllll, lllllllllllIllIllllllIIlIIlIIIIl, lllllllllllIllIllllllIIlIIIlIlll, lllllllllllIllIllllllIIlIIIlIllI);
                    }
                    CustomItems.setRenderOffHand(false);
                }
                if (this.mc.gameSettings.attackIndicator == 2) {
                    final float lllllllllllIllIllllllIIlIIIIlllI = this.mc.player.getCooledAttackStrength(0.0f);
                    if (lllllllllllIllIllllllIIlIIIIlllI < 1.0f) {
                        final int lllllllllllIllIllllllIIlIIIIllIl = lllllllllllIllIllllllIIlIIlIIIlI.getScaledHeight() - 20;
                        int lllllllllllIllIllllllIIlIIIIllII = lllllllllllIllIllllllIIlIIIlIlII + 91 + 6;
                        if (lllllllllllIllIllllllIIlIIIlIlIl == EnumHandSide.RIGHT) {
                            lllllllllllIllIllllllIIlIIIIllII = lllllllllllIllIllllllIIlIIIlIlII - 91 - 22;
                        }
                        this.mc.getTextureManager().bindTexture(Gui.ICONS);
                        final int lllllllllllIllIllllllIIlIIIIlIll = (int)(lllllllllllIllIllllllIIlIIIIlllI * 19.0f);
                        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIlIIIIllII, lllllllllllIllIllllllIIlIIIIllIl, 0, 94, 18, 18);
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIlIIIIllII, lllllllllllIllIllllllIIlIIIIllIl + 18 - lllllllllllIllIllllllIIlIIIIlIll, 18, 112 - lllllllllllIllIllllllIIlIIIIlIll, 18, lllllllllllIllIllllllIIlIIIIlIll);
                    }
                }
                RenderHelper.disableStandardItemLighting();
                GlStateManager.disableRescaleNormal();
                GlStateManager.disableBlend();
            }
        }
    }
    
    public GuiNewChat getChatGUI() {
        return this.persistantChatGUI;
    }
    
    private void renderPortal(float lllllllllllIllIlllllIllllIIlllll, final ScaledResolution lllllllllllIllIlllllIllllIlIlIII) {
        if (lllllllllllIllIlllllIllllIIlllll < 1.0f) {
            lllllllllllIllIlllllIllllIIlllll *= lllllllllllIllIlllllIllllIIlllll;
            lllllllllllIllIlllllIllllIIlllll *= lllllllllllIllIlllllIllllIIlllll;
            lllllllllllIllIlllllIllllIIlllll = lllllllllllIllIlllllIllllIIlllll * 0.8f + 0.2f;
        }
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, (float)lllllllllllIllIlllllIllllIIlllll);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final TextureAtlasSprite lllllllllllIllIlllllIllllIlIIlll = this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(Blocks.PORTAL.getDefaultState());
        final float lllllllllllIllIlllllIllllIlIIllI = lllllllllllIllIlllllIllllIlIIlll.getMinU();
        final float lllllllllllIllIlllllIllllIlIIlIl = lllllllllllIllIlllllIllllIlIIlll.getMinV();
        final float lllllllllllIllIlllllIllllIlIIlII = lllllllllllIllIlllllIllllIlIIlll.getMaxU();
        final float lllllllllllIllIlllllIllllIlIIIll = lllllllllllIllIlllllIllllIlIIlll.getMaxV();
        final Tessellator lllllllllllIllIlllllIllllIlIIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIllIlllllIllllIlIIIIl = lllllllllllIllIlllllIllllIlIIIlI.getBuffer();
        lllllllllllIllIlllllIllllIlIIIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIllIlllllIllllIlIIIIl.pos(0.0, lllllllllllIllIlllllIllllIlIlIII.getScaledHeight(), -90.0).tex(lllllllllllIllIlllllIllllIlIIllI, lllllllllllIllIlllllIllllIlIIIll).endVertex();
        lllllllllllIllIlllllIllllIlIIIIl.pos(lllllllllllIllIlllllIllllIlIlIII.getScaledWidth(), lllllllllllIllIlllllIllllIlIlIII.getScaledHeight(), -90.0).tex(lllllllllllIllIlllllIllllIlIIlII, lllllllllllIllIlllllIllllIlIIIll).endVertex();
        lllllllllllIllIlllllIllllIlIIIIl.pos(lllllllllllIllIlllllIllllIlIlIII.getScaledWidth(), 0.0, -90.0).tex(lllllllllllIllIlllllIllllIlIIlII, lllllllllllIllIlllllIllllIlIIlIl).endVertex();
        lllllllllllIllIlllllIllllIlIIIIl.pos(0.0, 0.0, -90.0).tex(lllllllllllIllIlllllIllllIlIIllI, lllllllllllIllIlllllIllllIlIIlIl).endVertex();
        lllllllllllIllIlllllIllllIlIIIlI.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void renderPlayerStats(final ScaledResolution lllllllllllIllIllllllIIIIlIlIlII) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer lllllllllllIllIllllllIIIIlIlIIll = (EntityPlayer)this.mc.getRenderViewEntity();
            final int lllllllllllIllIllllllIIIIlIlIIlI = MathHelper.ceil(lllllllllllIllIllllllIIIIlIlIIll.getHealth());
            final boolean lllllllllllIllIllllllIIIIlIlIIIl = this.healthUpdateCounter > this.updateCounter && (this.healthUpdateCounter - this.updateCounter) / 3L % 2L == 1L;
            if (lllllllllllIllIllllllIIIIlIlIIlI < this.playerHealth && lllllllllllIllIllllllIIIIlIlIIll.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 20;
            }
            else if (lllllllllllIllIllllllIIIIlIlIIlI > this.playerHealth && lllllllllllIllIllllllIIIIlIlIIll.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 10;
            }
            if (Minecraft.getSystemTime() - this.lastSystemTime > 1000L) {
                this.playerHealth = lllllllllllIllIllllllIIIIlIlIIlI;
                this.lastPlayerHealth = lllllllllllIllIllllllIIIIlIlIIlI;
                this.lastSystemTime = Minecraft.getSystemTime();
            }
            this.playerHealth = lllllllllllIllIllllllIIIIlIlIIlI;
            final int lllllllllllIllIllllllIIIIlIlIIII = this.lastPlayerHealth;
            this.rand.setSeed(this.updateCounter * 312871);
            final FoodStats lllllllllllIllIllllllIIIIlIIllll = lllllllllllIllIllllllIIIIlIlIIll.getFoodStats();
            final int lllllllllllIllIllllllIIIIlIIlllI = lllllllllllIllIllllllIIIIlIIllll.getFoodLevel();
            final IAttributeInstance lllllllllllIllIllllllIIIIlIIllIl = lllllllllllIllIllllllIIIIlIlIIll.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
            final int lllllllllllIllIllllllIIIIlIIllII = lllllllllllIllIllllllIIIIlIlIlII.getScaledWidth() / 2 - 91;
            final int lllllllllllIllIllllllIIIIlIIlIll = lllllllllllIllIllllllIIIIlIlIlII.getScaledWidth() / 2 + 91;
            final int lllllllllllIllIllllllIIIIlIIlIlI = lllllllllllIllIllllllIIIIlIlIlII.getScaledHeight() - 39;
            final float lllllllllllIllIllllllIIIIlIIlIIl = (float)lllllllllllIllIllllllIIIIlIIllIl.getAttributeValue();
            final int lllllllllllIllIllllllIIIIlIIlIII = MathHelper.ceil(lllllllllllIllIllllllIIIIlIlIIll.getAbsorptionAmount());
            final int lllllllllllIllIllllllIIIIlIIIlll = MathHelper.ceil((lllllllllllIllIllllllIIIIlIIlIIl + lllllllllllIllIllllllIIIIlIIlIII) / 2.0f / 10.0f);
            final int lllllllllllIllIllllllIIIIlIIIllI = Math.max(10 - (lllllllllllIllIllllllIIIIlIIIlll - 2), 3);
            final int lllllllllllIllIllllllIIIIlIIIlIl = lllllllllllIllIllllllIIIIlIIlIlI - (lllllllllllIllIllllllIIIIlIIIlll - 1) * lllllllllllIllIllllllIIIIlIIIllI - 10;
            final int lllllllllllIllIllllllIIIIlIIIlII = lllllllllllIllIllllllIIIIlIIlIlI - 10;
            int lllllllllllIllIllllllIIIIlIIIIll = lllllllllllIllIllllllIIIIlIIlIII;
            final int lllllllllllIllIllllllIIIIlIIIIlI = lllllllllllIllIllllllIIIIlIlIIll.getTotalArmorValue();
            int lllllllllllIllIllllllIIIIlIIIIIl = -1;
            if (lllllllllllIllIllllllIIIIlIlIIll.isPotionActive(MobEffects.REGENERATION)) {
                lllllllllllIllIllllllIIIIlIIIIIl = this.updateCounter % MathHelper.ceil(lllllllllllIllIllllllIIIIlIIlIIl + 5.0f);
            }
            this.mc.mcProfiler.startSection("armor");
            for (int lllllllllllIllIllllllIIIIlIIIIII = 0; lllllllllllIllIllllllIIIIlIIIIII < 10; ++lllllllllllIllIllllllIIIIlIIIIII) {
                if (lllllllllllIllIllllllIIIIlIIIIlI > 0) {
                    final int lllllllllllIllIllllllIIIIIllllll = lllllllllllIllIllllllIIIIlIIllII + lllllllllllIllIllllllIIIIlIIIIII * 8;
                    if (lllllllllllIllIllllllIIIIlIIIIII * 2 + 1 < lllllllllllIllIllllllIIIIlIIIIlI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllllll, lllllllllllIllIllllllIIIIlIIIlIl, 34, 9, 9, 9);
                    }
                    if (lllllllllllIllIllllllIIIIlIIIIII * 2 + 1 == lllllllllllIllIllllllIIIIlIIIIlI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllllll, lllllllllllIllIllllllIIIIlIIIlIl, 25, 9, 9, 9);
                    }
                    if (lllllllllllIllIllllllIIIIlIIIIII * 2 + 1 > lllllllllllIllIllllllIIIIlIIIIlI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllllll, lllllllllllIllIllllllIIIIlIIIlIl, 16, 9, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endStartSection("health");
            for (int lllllllllllIllIllllllIIIIIlllllI = MathHelper.ceil((lllllllllllIllIllllllIIIIlIIlIIl + lllllllllllIllIllllllIIIIlIIlIII) / 2.0f) - 1; lllllllllllIllIllllllIIIIIlllllI >= 0; --lllllllllllIllIllllllIIIIIlllllI) {
                int lllllllllllIllIllllllIIIIIllllIl = 16;
                if (lllllllllllIllIllllllIIIIlIlIIll.isPotionActive(MobEffects.POISON)) {
                    lllllllllllIllIllllllIIIIIllllIl += 36;
                }
                else if (lllllllllllIllIllllllIIIIlIlIIll.isPotionActive(MobEffects.WITHER)) {
                    lllllllllllIllIllllllIIIIIllllIl += 72;
                }
                int lllllllllllIllIllllllIIIIIllllII = 0;
                if (lllllllllllIllIllllllIIIIlIlIIIl) {
                    lllllllllllIllIllllllIIIIIllllII = 1;
                }
                final int lllllllllllIllIllllllIIIIIlllIll = MathHelper.ceil((lllllllllllIllIllllllIIIIIlllllI + 1) / 10.0f) - 1;
                final int lllllllllllIllIllllllIIIIIlllIlI = lllllllllllIllIllllllIIIIlIIllII + lllllllllllIllIllllllIIIIIlllllI % 10 * 8;
                int lllllllllllIllIllllllIIIIIlllIIl = lllllllllllIllIllllllIIIIlIIlIlI - lllllllllllIllIllllllIIIIIlllIll * lllllllllllIllIllllllIIIIlIIIllI;
                if (lllllllllllIllIllllllIIIIlIlIIlI <= 4) {
                    lllllllllllIllIllllllIIIIIlllIIl += this.rand.nextInt(2);
                }
                if (lllllllllllIllIllllllIIIIlIIIIll <= 0 && lllllllllllIllIllllllIIIIIlllllI == lllllllllllIllIllllllIIIIlIIIIIl) {
                    lllllllllllIllIllllllIIIIIlllIIl -= 2;
                }
                int lllllllllllIllIllllllIIIIIlllIII = 0;
                if (lllllllllllIllIllllllIIIIlIlIIll.world.getWorldInfo().isHardcoreModeEnabled()) {
                    lllllllllllIllIllllllIIIIIlllIII = 5;
                }
                this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, 16 + lllllllllllIllIllllllIIIIIllllII * 9, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                if (lllllllllllIllIllllllIIIIlIlIIIl) {
                    if (lllllllllllIllIllllllIIIIIlllllI * 2 + 1 < lllllllllllIllIllllllIIIIlIlIIII) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 54, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                    }
                    if (lllllllllllIllIllllllIIIIIlllllI * 2 + 1 == lllllllllllIllIllllllIIIIlIlIIII) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 63, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                    }
                }
                if (lllllllllllIllIllllllIIIIlIIIIll > 0) {
                    if (lllllllllllIllIllllllIIIIlIIIIll == lllllllllllIllIllllllIIIIlIIlIII && lllllllllllIllIllllllIIIIlIIlIII % 2 == 1) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 153, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                        --lllllllllllIllIllllllIIIIlIIIIll;
                    }
                    else {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 144, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                        lllllllllllIllIllllllIIIIlIIIIll -= 2;
                    }
                }
                else {
                    if (lllllllllllIllIllllllIIIIIlllllI * 2 + 1 < lllllllllllIllIllllllIIIIlIlIIlI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 36, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                    }
                    if (lllllllllllIllIllllllIIIIIlllllI * 2 + 1 == lllllllllllIllIllllllIIIIlIlIIlI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIlllIlI, lllllllllllIllIllllllIIIIIlllIIl, lllllllllllIllIllllllIIIIIllllIl + 45, 9 * lllllllllllIllIllllllIIIIIlllIII, 9, 9);
                    }
                }
            }
            final Entity lllllllllllIllIllllllIIIIIllIlll = lllllllllllIllIllllllIIIIlIlIIll.getRidingEntity();
            if (lllllllllllIllIllllllIIIIIllIlll == null || !(lllllllllllIllIllllllIIIIIllIlll instanceof EntityLivingBase)) {
                this.mc.mcProfiler.endStartSection("food");
                for (int lllllllllllIllIllllllIIIIIllIllI = 0; lllllllllllIllIllllllIIIIIllIllI < 10; ++lllllllllllIllIllllllIIIIIllIllI) {
                    int lllllllllllIllIllllllIIIIIllIlIl = lllllllllllIllIllllllIIIIlIIlIlI;
                    int lllllllllllIllIllllllIIIIIllIlII = 16;
                    int lllllllllllIllIllllllIIIIIllIIll = 0;
                    if (lllllllllllIllIllllllIIIIlIlIIll.isPotionActive(MobEffects.HUNGER)) {
                        lllllllllllIllIllllllIIIIIllIlII += 36;
                        lllllllllllIllIllllllIIIIIllIIll = 13;
                    }
                    if (lllllllllllIllIllllllIIIIlIlIIll.getFoodStats().getSaturationLevel() <= 0.0f && this.updateCounter % (lllllllllllIllIllllllIIIIlIIlllI * 3 + 1) == 0) {
                        lllllllllllIllIllllllIIIIIllIlIl = lllllllllllIllIllllllIIIIlIIlIlI + (this.rand.nextInt(3) - 1);
                    }
                    final int lllllllllllIllIllllllIIIIIllIIlI = lllllllllllIllIllllllIIIIlIIlIll - lllllllllllIllIllllllIIIIIllIllI * 8 - 9;
                    this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllIIlI, lllllllllllIllIllllllIIIIIllIlIl, 16 + lllllllllllIllIllllllIIIIIllIIll * 9, 27, 9, 9);
                    if (lllllllllllIllIllllllIIIIIllIllI * 2 + 1 < lllllllllllIllIllllllIIIIlIIlllI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllIIlI, lllllllllllIllIllllllIIIIIllIlIl, lllllllllllIllIllllllIIIIIllIlII + 36, 27, 9, 9);
                    }
                    if (lllllllllllIllIllllllIIIIIllIllI * 2 + 1 == lllllllllllIllIllllllIIIIlIIlllI) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIIllIIlI, lllllllllllIllIllllllIIIIIllIlIl, lllllllllllIllIllllllIIIIIllIlII + 45, 27, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endStartSection("air");
            if (lllllllllllIllIllllllIIIIlIlIIll.isInsideOfMaterial(Material.WATER)) {
                final int lllllllllllIllIllllllIIIIIllIIIl = this.mc.player.getAir();
                for (int lllllllllllIllIllllllIIIIIllIIII = MathHelper.ceil((lllllllllllIllIllllllIIIIIllIIIl - 2) * 10.0 / 300.0), lllllllllllIllIllllllIIIIIlIllll = MathHelper.ceil(lllllllllllIllIllllllIIIIIllIIIl * 10.0 / 300.0) - lllllllllllIllIllllllIIIIIllIIII, lllllllllllIllIllllllIIIIIlIlllI = 0; lllllllllllIllIllllllIIIIIlIlllI < lllllllllllIllIllllllIIIIIllIIII + lllllllllllIllIllllllIIIIIlIllll; ++lllllllllllIllIllllllIIIIIlIlllI) {
                    if (lllllllllllIllIllllllIIIIIlIlllI < lllllllllllIllIllllllIIIIIllIIII) {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIlIIlIll - lllllllllllIllIllllllIIIIIlIlllI * 8 - 9, lllllllllllIllIllllllIIIIlIIIlII, 16, 18, 9, 9);
                    }
                    else {
                        this.drawTexturedModalRect(lllllllllllIllIllllllIIIIlIIlIll - lllllllllllIllIllllllIIIIIlIlllI * 8 - 9, lllllllllllIllIllllllIIIIlIIIlII, 25, 18, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void renderHorseJumpBar(final ScaledResolution lllllllllllIllIllllllIIIllllIllI, final int lllllllllllIllIllllllIIIllllIlIl) {
        this.mc.mcProfiler.startSection("jumpBar");
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
        final float lllllllllllIllIllllllIIIllllIlII = this.mc.player.getHorseJumpPower();
        final int lllllllllllIllIllllllIIIllllIIll = 182;
        final int lllllllllllIllIllllllIIIllllIIlI = (int)(lllllllllllIllIllllllIIIllllIlII * 183.0f);
        final int lllllllllllIllIllllllIIIllllIIIl = lllllllllllIllIllllllIIIllllIllI.getScaledHeight() - 32 + 3;
        this.drawTexturedModalRect(lllllllllllIllIllllllIIIllllIlIl, lllllllllllIllIllllllIIIllllIIIl, 0, 84, 182, 5);
        if (lllllllllllIllIllllllIIIllllIIlI > 0) {
            this.drawTexturedModalRect(lllllllllllIllIllllllIIIllllIlIl, lllllllllllIllIllllllIIIllllIIIl, 0, 89, lllllllllllIllIllllllIIIllllIIlI, 5);
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void setRecordPlaying(final String lllllllllllIllIlllllIlllIllIlIll, final boolean lllllllllllIllIlllllIlllIllIlIlI) {
        this.recordPlaying = lllllllllllIllIlllllIlllIllIlIll;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = lllllllllllIllIlllllIlllIllIlIlI;
    }
    
    public void displayTitle(final String lllllllllllIllIlllllIlllIlIlllII, final String lllllllllllIllIlllllIlllIllIIIIl, final int lllllllllllIllIlllllIlllIlIllIlI, final int lllllllllllIllIlllllIlllIlIlllll, final int lllllllllllIllIlllllIlllIlIllllI) {
        if (lllllllllllIllIlllllIlllIlIlllII == null && lllllllllllIllIlllllIlllIllIIIIl == null && lllllllllllIllIlllllIlllIlIllIlI < 0 && lllllllllllIllIlllllIlllIlIlllll < 0 && lllllllllllIllIlllllIlllIlIllllI < 0) {
            this.displayedTitle = "";
            this.displayedSubTitle = "";
            this.titlesTimer = 0;
        }
        else if (lllllllllllIllIlllllIlllIlIlllII != null) {
            this.displayedTitle = lllllllllllIllIlllllIlllIlIlllII;
            this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
        }
        else if (lllllllllllIllIlllllIlllIllIIIIl != null) {
            this.displayedSubTitle = lllllllllllIllIlllllIlllIllIIIIl;
        }
        else {
            if (lllllllllllIllIlllllIlllIlIllIlI >= 0) {
                this.titleFadeIn = lllllllllllIllIlllllIlllIlIllIlI;
            }
            if (lllllllllllIllIlllllIlllIlIlllll >= 0) {
                this.titleDisplayTime = lllllllllllIllIlllllIlllIlIlllll;
            }
            if (lllllllllllIllIlllllIlllIlIllllI >= 0) {
                this.titleFadeOut = lllllllllllIllIlllllIlllIlIllllI;
            }
            if (this.titlesTimer > 0) {
                this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
            }
        }
    }
    
    private void renderHotbarItem(final int lllllllllllIllIlllllIllllIIIllIl, final int lllllllllllIllIlllllIllllIIIIlII, final float lllllllllllIllIlllllIllllIIIlIll, final EntityPlayer lllllllllllIllIlllllIllllIIIlIlI, final ItemStack lllllllllllIllIlllllIllllIIIIIIl) {
        if (!lllllllllllIllIlllllIllllIIIIIIl.func_190926_b()) {
            final float lllllllllllIllIlllllIllllIIIlIII = lllllllllllIllIlllllIllllIIIIIIl.func_190921_D() - lllllllllllIllIlllllIllllIIIlIll;
            if (lllllllllllIllIlllllIllllIIIlIII > 0.0f) {
                GlStateManager.pushMatrix();
                final float lllllllllllIllIlllllIllllIIIIlll = 1.0f + lllllllllllIllIlllllIllllIIIlIII / 5.0f;
                GlStateManager.translate((float)(lllllllllllIllIlllllIllllIIIllIl + 8), (float)(lllllllllllIllIlllllIllllIIIIlII + 12), 0.0f);
                GlStateManager.scale(1.0f / lllllllllllIllIlllllIllllIIIIlll, (lllllllllllIllIlllllIllllIIIIlll + 1.0f) / 2.0f, 1.0f);
                GlStateManager.translate((float)(-(lllllllllllIllIlllllIllllIIIllIl + 8)), (float)(-(lllllllllllIllIlllllIllllIIIIlII + 12)), 0.0f);
            }
            this.itemRenderer.renderItemAndEffectIntoGUI(lllllllllllIllIlllllIllllIIIlIlI, lllllllllllIllIlllllIllllIIIIIIl, lllllllllllIllIlllllIllllIIIllIl, lllllllllllIllIlllllIllllIIIIlII);
            if (lllllllllllIllIlllllIllllIIIlIII > 0.0f) {
                GlStateManager.popMatrix();
            }
            this.itemRenderer.renderItemOverlays(Minecraft.fontRendererObj, lllllllllllIllIlllllIllllIIIIIIl, lllllllllllIllIlllllIllllIIIllIl, lllllllllllIllIlllllIllllIIIIlII);
        }
    }
    
    public void renderDemo(final ScaledResolution lllllllllllIllIllllllIIIlIllIlll) {
        this.mc.mcProfiler.startSection("demo");
        String lllllllllllIllIllllllIIIlIllIlIl = null;
        if (this.mc.world.getTotalWorldTime() >= 120500L) {
            final String lllllllllllIllIllllllIIIlIllIllI = I18n.format("demo.demoExpired", new Object[0]);
        }
        else {
            lllllllllllIllIllllllIIIlIllIlIl = I18n.format("demo.remainingTime", StringUtils.ticksToElapsedTime((int)(120500L - this.mc.world.getTotalWorldTime())));
        }
        final int lllllllllllIllIllllllIIIlIllIlII = this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIlIllIlIl);
        this.getFontRenderer().drawStringWithShadow(lllllllllllIllIllllllIIIlIllIlIl, (float)(lllllllllllIllIllllllIIIlIllIlll.getScaledWidth() - lllllllllllIllIllllllIIIlIllIlII - 10), 5.0f, 16777215);
        this.mc.mcProfiler.endSection();
    }
    
    public GuiIngame(final Minecraft lllllllllllIllIllllllIIllIllllll) {
        this.rand = new Random();
        this.recordPlaying = "";
        this.prevVignetteBrightness = 1.0f;
        this.highlightingItemStack = ItemStack.field_190927_a;
        this.displayedTitle = "";
        this.displayedSubTitle = "";
        this.field_191743_I = (Map<ChatType, List<IChatListener>>)Maps.newHashMap();
        this.deltaSpeed = 0.0;
        this.last = 0.0;
        this.mc = lllllllllllIllIllllllIIllIllllll;
        this.itemRenderer = lllllllllllIllIllllllIIllIllllll.getRenderItem();
        this.overlayDebug = new GuiOverlayDebug(lllllllllllIllIllllllIIllIllllll);
        this.spectatorGui = new GuiSpectator(lllllllllllIllIllllllIIllIllllll);
        this.persistantChatGUI = new GuiNewChat(lllllllllllIllIllllllIIllIllllll);
        this.overlayPlayerList = new GuiPlayerTabOverlay(lllllllllllIllIllllllIIllIllllll, this);
        this.overlayBoss = new GuiBossOverlay(lllllllllllIllIllllllIIllIllllll);
        this.overlaySubtitle = new GuiSubtitleOverlay(lllllllllllIllIllllllIIllIllllll);
        final double lllllllllllIllIllllllIIllIlllIll;
        final byte lllllllllllIllIllllllIIllIllllII = (byte)((ChatType[])(Object)(lllllllllllIllIllllllIIllIlllIll = (double)(Object)ChatType.values())).length;
        for (double lllllllllllIllIllllllIIllIllllIl = 0; lllllllllllIllIllllllIIllIllllIl < lllllllllllIllIllllllIIllIllllII; ++lllllllllllIllIllllllIIllIllllIl) {
            final ChatType lllllllllllIllIllllllIIlllIIIIlI = lllllllllllIllIllllllIIllIlllIll[lllllllllllIllIllllllIIllIllllIl];
            this.field_191743_I.put(lllllllllllIllIllllllIIlllIIIIlI, Lists.newArrayList());
        }
        final IChatListener lllllllllllIllIllllllIIlllIIIIIl = NarratorChatListener.field_193643_a;
        this.field_191743_I.get(ChatType.CHAT).add(new NormalChatListener(lllllllllllIllIllllllIIllIllllll));
        this.field_191743_I.get(ChatType.CHAT).add(lllllllllllIllIllllllIIlllIIIIIl);
        this.field_191743_I.get(ChatType.SYSTEM).add(new NormalChatListener(lllllllllllIllIllllllIIllIllllll));
        this.field_191743_I.get(ChatType.SYSTEM).add(lllllllllllIllIllllllIIlllIIIIIl);
        this.field_191743_I.get(ChatType.GAME_INFO).add(new OverlayChatListener(lllllllllllIllIllllllIIllIllllll));
        this.setDefaultTitlesTimes();
    }
    
    public void updateTick() {
        if (this.mc.world == null) {
            TextureAnimations.updateAnimations();
        }
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
        if (this.titlesTimer > 0) {
            --this.titlesTimer;
            if (this.titlesTimer <= 0) {
                this.displayedTitle = "";
                this.displayedSubTitle = "";
            }
        }
        ++this.updateCounter;
        if (this.mc.player != null) {
            final ItemStack lllllllllllIllIlllllIlllIllllIll = this.mc.player.inventory.getCurrentItem();
            if (lllllllllllIllIlllllIlllIllllIll.func_190926_b()) {
                this.remainingHighlightTicks = 0;
            }
            else if (!this.highlightingItemStack.func_190926_b() && lllllllllllIllIlllllIlllIllllIll.getItem() == this.highlightingItemStack.getItem() && ItemStack.areItemStackTagsEqual(lllllllllllIllIlllllIlllIllllIll, this.highlightingItemStack) && (lllllllllllIllIlllllIlllIllllIll.isItemStackDamageable() || lllllllllllIllIlllllIlllIllllIll.getMetadata() == this.highlightingItemStack.getMetadata())) {
                if (this.remainingHighlightTicks > 0) {
                    --this.remainingHighlightTicks;
                }
            }
            else {
                this.remainingHighlightTicks = 40;
            }
            this.highlightingItemStack = lllllllllllIllIlllllIlllIllllIll;
        }
    }
    
    public GuiPlayerTabOverlay getTabList() {
        return this.overlayPlayerList;
    }
    
    public GuiBossOverlay getBossOverlay() {
        return this.overlayBoss;
    }
    
    public void setRecordPlaying(final ITextComponent lllllllllllIllIlllllIlllIlIlIIll, final boolean lllllllllllIllIlllllIlllIlIlIIlI) {
        this.setRecordPlaying(lllllllllllIllIlllllIlllIlIlIIll.getUnformattedText(), lllllllllllIllIlllllIlllIlIlIIlI);
    }
    
    private void renderScoreboard(final ScoreObjective lllllllllllIllIllllllIIIlIIllIlI, final ScaledResolution lllllllllllIllIllllllIIIlIIIIIll) {
        final Scoreboard lllllllllllIllIllllllIIIlIIllIII = lllllllllllIllIllllllIIIlIIllIlI.getScoreboard();
        Collection<Score> lllllllllllIllIllllllIIIlIIlIlll = lllllllllllIllIllllllIIIlIIllIII.getSortedScores(lllllllllllIllIllllllIIIlIIllIlI);
        final List<Score> lllllllllllIllIllllllIIIlIIlIllI = (List<Score>)Lists.newArrayList(Iterables.filter((Iterable)lllllllllllIllIllllllIIIlIIlIlll, (Predicate)new Predicate<Score>() {
            public boolean apply(@Nullable final Score llllllllllllllIIIIIIllIlllllIIlI) {
                return llllllllllllllIIIIIIllIlllllIIlI.getPlayerName() != null && !llllllllllllllIIIIIIllIlllllIIlI.getPlayerName().startsWith("#");
            }
        }));
        if (lllllllllllIllIllllllIIIlIIlIllI.size() > 15) {
            lllllllllllIllIllllllIIIlIIlIlll = (Collection<Score>)Lists.newArrayList(Iterables.skip((Iterable)lllllllllllIllIllllllIIIlIIlIllI, lllllllllllIllIllllllIIIlIIlIlll.size() - 15));
        }
        else {
            lllllllllllIllIllllllIIIlIIlIlll = lllllllllllIllIllllllIIIlIIlIllI;
        }
        int lllllllllllIllIllllllIIIlIIlIlIl = this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIlIIllIlI.getDisplayName());
        for (final Score lllllllllllIllIllllllIIIlIIlIlII : lllllllllllIllIllllllIIIlIIlIlll) {
            final ScorePlayerTeam lllllllllllIllIllllllIIIlIIlIIll = lllllllllllIllIllllllIIIlIIllIII.getPlayersTeam(lllllllllllIllIllllllIIIlIIlIlII.getPlayerName());
            final String lllllllllllIllIllllllIIIlIIlIIlI = String.valueOf(ScorePlayerTeam.formatPlayerName(lllllllllllIllIllllllIIIlIIlIIll, lllllllllllIllIllllllIIIlIIlIlII.getPlayerName())) + ": " + TextFormatting.RED + lllllllllllIllIllllllIIIlIIlIlII.getScorePoints();
            lllllllllllIllIllllllIIIlIIlIlIl = Math.max(lllllllllllIllIllllllIIIlIIlIlIl, this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIlIIlIIlI));
        }
        final int lllllllllllIllIllllllIIIlIIlIIIl = lllllllllllIllIllllllIIIlIIlIlll.size() * this.getFontRenderer().FONT_HEIGHT;
        final int lllllllllllIllIllllllIIIlIIlIIII = lllllllllllIllIllllllIIIlIIIIIll.getScaledHeight() / 2 + lllllllllllIllIllllllIIIlIIlIIIl / 3;
        final int lllllllllllIllIllllllIIIlIIIllll = 3;
        final int lllllllllllIllIllllllIIIlIIIlllI = lllllllllllIllIllllllIIIlIIIIIll.getScaledWidth() - lllllllllllIllIllllllIIIlIIlIlIl - 3;
        int lllllllllllIllIllllllIIIlIIIllIl = 0;
        for (final Score lllllllllllIllIllllllIIIlIIIllII : lllllllllllIllIllllllIIIlIIlIlll) {
            ++lllllllllllIllIllllllIIIlIIIllIl;
            final ScorePlayerTeam lllllllllllIllIllllllIIIlIIIlIll = lllllllllllIllIllllllIIIlIIllIII.getPlayersTeam(lllllllllllIllIllllllIIIlIIIllII.getPlayerName());
            final String lllllllllllIllIllllllIIIlIIIlIlI = ScorePlayerTeam.formatPlayerName(lllllllllllIllIllllllIIIlIIIlIll, lllllllllllIllIllllllIIIlIIIllII.getPlayerName());
            final String lllllllllllIllIllllllIIIlIIIlIIl = new StringBuilder().append(TextFormatting.RED).append(lllllllllllIllIllllllIIIlIIIllII.getScorePoints()).toString();
            final int lllllllllllIllIllllllIIIlIIIlIII = lllllllllllIllIllllllIIIlIIlIIII - lllllllllllIllIllllllIIIlIIIllIl * this.getFontRenderer().FONT_HEIGHT;
            final int lllllllllllIllIllllllIIIlIIIIlll = lllllllllllIllIllllllIIIlIIIIIll.getScaledWidth() - 3 + 2;
            Gui.drawRect(lllllllllllIllIllllllIIIlIIIlllI - 2, lllllllllllIllIllllllIIIlIIIlIII, lllllllllllIllIllllllIIIlIIIIlll, lllllllllllIllIllllllIIIlIIIlIII + this.getFontRenderer().FONT_HEIGHT, 1342177280);
            this.getFontRenderer().drawString(lllllllllllIllIllllllIIIlIIIlIlI, (float)lllllllllllIllIllllllIIIlIIIlllI, (float)lllllllllllIllIllllllIIIlIIIlIII, 553648127);
            this.getFontRenderer().drawString(lllllllllllIllIllllllIIIlIIIlIIl, (float)(lllllllllllIllIllllllIIIlIIIIlll - this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIlIIIlIIl)), (float)lllllllllllIllIllllllIIIlIIIlIII, 553648127);
            if (lllllllllllIllIllllllIIIlIIIllIl == lllllllllllIllIllllllIIIlIIlIlll.size()) {
                final String lllllllllllIllIllllllIIIlIIIIllI = lllllllllllIllIllllllIIIlIIllIlI.getDisplayName();
                Gui.drawRect(lllllllllllIllIllllllIIIlIIIlllI - 2, lllllllllllIllIllllllIIIlIIIlIII - this.getFontRenderer().FONT_HEIGHT - 1, lllllllllllIllIllllllIIIlIIIIlll, lllllllllllIllIllllllIIIlIIIlIII - 1, 1610612736);
                Gui.drawRect(lllllllllllIllIllllllIIIlIIIlllI - 2, lllllllllllIllIllllllIIIlIIIlIII - 1, lllllllllllIllIllllllIIIlIIIIlll, lllllllllllIllIllllllIIIlIIIlIII, 1342177280);
                this.getFontRenderer().drawString(lllllllllllIllIllllllIIIlIIIIllI, (float)(lllllllllllIllIllllllIIIlIIIlllI + lllllllllllIllIllllllIIIlIIlIlIl / 2 - this.getFontRenderer().getStringWidth(lllllllllllIllIllllllIIIlIIIIllI) / 2), (float)(lllllllllllIllIllllllIIIlIIIlIII - this.getFontRenderer().FONT_HEIGHT), 553648127);
            }
        }
    }
    
    public void renderGameOverlay(final float lllllllllllIllIllllllIIllIlIlIII) {
        final ScaledResolution lllllllllllIllIllllllIIllIlIIlll = new ScaledResolution(this.mc);
        final int lllllllllllIllIllllllIIllIlIIllI = lllllllllllIllIllllllIIllIlIIlll.getScaledWidth();
        final int lllllllllllIllIllllllIIllIlIIlIl = lllllllllllIllIllllllIIllIlIIlll.getScaledHeight();
        final FontRenderer lllllllllllIllIllllllIIllIlIIlII = this.getFontRenderer();
        GlStateManager.enableBlend();
        if (Config.isVignetteEnabled()) {
            this.renderVignette(this.mc.player.getBrightness(), lllllllllllIllIllllllIIllIlIIlll);
        }
        else {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
        final ItemStack lllllllllllIllIllllllIIllIlIIIll = this.mc.player.inventory.armorItemInSlot(3);
        if (this.mc.gameSettings.thirdPersonView == 0 && lllllllllllIllIllllllIIllIlIIIll.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
            this.renderPumpkinOverlay(lllllllllllIllIllllllIIllIlIIlll);
        }
        if (!this.mc.player.isPotionActive(MobEffects.NAUSEA)) {
            final float lllllllllllIllIllllllIIllIlIIIlI = this.mc.player.prevTimeInPortal + (this.mc.player.timeInPortal - this.mc.player.prevTimeInPortal) * lllllllllllIllIllllllIIllIlIlIII;
            if (lllllllllllIllIllllllIIllIlIIIlI > 0.0f) {
                this.renderPortal(lllllllllllIllIllllllIIllIlIIIlI, lllllllllllIllIllllllIIllIlIIlll);
            }
        }
        if (this.mc.playerController.isSpectator()) {
            this.spectatorGui.renderTooltip(lllllllllllIllIllllllIIllIlIIlll, lllllllllllIllIllllllIIllIlIlIII);
        }
        else {
            this.renderHotbar(lllllllllllIllIllllllIIllIlIIlll, lllllllllllIllIllllllIIllIlIlIII);
        }
        final Event2D lllllllllllIllIllllllIIllIlIIIIl = new Event2D((float)lllllllllllIllIllllllIIllIlIIlll.getScaledWidth(), (float)lllllllllllIllIllllllIIllIlIIlll.getScaledHeight());
        lllllllllllIllIllllllIIllIlIIIIl.call();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiIngame.ICONS);
        GlStateManager.enableBlend();
        this.renderAttackIndicator(lllllllllllIllIllllllIIllIlIlIII, lllllllllllIllIllllllIIllIlIIlll);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        this.mc.mcProfiler.startSection("bossHealth");
        if (!Main.featureDirector.getFeatureByClass(NoRender.class).isToggled() || !NoRender.noBoss.getBoolValue()) {
            this.overlayBoss.renderBossHealth();
        }
        this.mc.mcProfiler.endSection();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiIngame.ICONS);
        if (this.mc.playerController.shouldDrawHUD()) {
            this.renderPlayerStats(lllllllllllIllIllllllIIllIlIIlll);
        }
        this.renderMountHealth(lllllllllllIllIllllllIIllIlIIlll);
        GlStateManager.disableBlend();
        if (this.mc.player.getSleepTimer() > 0) {
            this.mc.mcProfiler.startSection("sleep");
            GlStateManager.disableDepth();
            GlStateManager.disableAlpha();
            final int lllllllllllIllIllllllIIllIlIIIII = this.mc.player.getSleepTimer();
            float lllllllllllIllIllllllIIllIIlllll = lllllllllllIllIllllllIIllIlIIIII / 100.0f;
            if (lllllllllllIllIllllllIIllIIlllll > 1.0f) {
                lllllllllllIllIllllllIIllIIlllll = 1.0f - (lllllllllllIllIllllllIIllIlIIIII - 100) / 10.0f;
            }
            final int lllllllllllIllIllllllIIllIIllllI = (int)(220.0f * lllllllllllIllIllllllIIllIIlllll) << 24 | 0x101020;
            Gui.drawRect(0.0, 0.0, lllllllllllIllIllllllIIllIlIIllI, lllllllllllIllIllllllIIllIlIIlIl, lllllllllllIllIllllllIIllIIllllI);
            GlStateManager.enableAlpha();
            GlStateManager.enableDepth();
            this.mc.mcProfiler.endSection();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllIllIllllllIIllIIlllIl = lllllllllllIllIllllllIIllIlIIllI / 2 - 91;
        if (this.mc.player.isRidingHorse()) {
            this.renderHorseJumpBar(lllllllllllIllIllllllIIllIlIIlll, lllllllllllIllIllllllIIllIIlllIl);
        }
        else if (this.mc.playerController.gameIsSurvivalOrAdventure()) {
            this.renderExpBar(lllllllllllIllIllllllIIllIlIIlll, lllllllllllIllIllllllIIllIIlllIl);
        }
        if (this.mc.gameSettings.heldItemTooltips && !this.mc.playerController.isSpectator()) {
            this.renderSelectedItem(lllllllllllIllIllllllIIllIlIIlll);
        }
        else if (this.mc.player.isSpectator()) {
            this.spectatorGui.renderSelectedItem(lllllllllllIllIllllllIIllIlIIlll);
        }
        if (this.mc.isDemo()) {
            this.renderDemo(lllllllllllIllIllllllIIllIlIIlll);
        }
        this.renderPotionEffects(lllllllllllIllIllllllIIllIlIIlll);
        if (this.mc.gameSettings.showDebugInfo) {
            this.overlayDebug.renderDebugInfo(lllllllllllIllIllllllIIllIlIIlll);
        }
        if (this.recordPlayingUpFor > 0) {
            this.mc.mcProfiler.startSection("overlayMessage");
            final float lllllllllllIllIllllllIIllIIlllII = this.recordPlayingUpFor - lllllllllllIllIllllllIIllIlIlIII;
            int lllllllllllIllIllllllIIllIIllIll = (int)(lllllllllllIllIllllllIIllIIlllII * 255.0f / 20.0f);
            if (lllllllllllIllIllllllIIllIIllIll > 255) {
                lllllllllllIllIllllllIIllIIllIll = 255;
            }
            if (lllllllllllIllIllllllIIllIIllIll > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lllllllllllIllIllllllIIllIlIIllI / 2), (float)(lllllllllllIllIllllllIIllIlIIlIl - 68), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                int lllllllllllIllIllllllIIllIIllIlI = 16777215;
                if (this.recordIsPlaying) {
                    lllllllllllIllIllllllIIllIIllIlI = (MathHelper.hsvToRGB(lllllllllllIllIllllllIIllIIlllII / 50.0f, 0.7f, 0.6f) & 0xFFFFFF);
                }
                lllllllllllIllIllllllIIllIlIIlII.drawString(this.recordPlaying, (float)(-lllllllllllIllIllllllIIllIlIIlII.getStringWidth(this.recordPlaying) / 2), -4.0f, lllllllllllIllIllllllIIllIIllIlI + (lllllllllllIllIllllllIIllIIllIll << 24 & 0xFF000000));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        this.overlaySubtitle.renderSubtitles(lllllllllllIllIllllllIIllIlIIlll);
        if (this.titlesTimer > 0) {
            this.mc.mcProfiler.startSection("titleAndSubtitle");
            final float lllllllllllIllIllllllIIllIIllIIl = this.titlesTimer - lllllllllllIllIllllllIIllIlIlIII;
            int lllllllllllIllIllllllIIllIIllIII = 255;
            if (this.titlesTimer > this.titleFadeOut + this.titleDisplayTime) {
                final float lllllllllllIllIllllllIIllIIlIlll = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut - lllllllllllIllIllllllIIllIIllIIl;
                lllllllllllIllIllllllIIllIIllIII = (int)(lllllllllllIllIllllllIIllIIlIlll * 255.0f / this.titleFadeIn);
            }
            if (this.titlesTimer <= this.titleFadeOut) {
                lllllllllllIllIllllllIIllIIllIII = (int)(lllllllllllIllIllllllIIllIIllIIl * 255.0f / this.titleFadeOut);
            }
            lllllllllllIllIllllllIIllIIllIII = MathHelper.clamp(lllllllllllIllIllllllIIllIIllIII, 0, 255);
            if (lllllllllllIllIllllllIIllIIllIII > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lllllllllllIllIllllllIIllIlIIllI / 2), (float)(lllllllllllIllIllllllIIllIlIIlIl / 2), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.pushMatrix();
                GlStateManager.scale(4.0f, 4.0f, 4.0f);
                final int lllllllllllIllIllllllIIllIIlIllI = lllllllllllIllIllllllIIllIIllIII << 24 & 0xFF000000;
                lllllllllllIllIllllllIIllIlIIlII.drawString(this.displayedTitle, (float)(-lllllllllllIllIllllllIIllIlIIlII.getStringWidth(this.displayedTitle) / 2), -10.0f, 0xFFFFFF | lllllllllllIllIllllllIIllIIlIllI, true);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                lllllllllllIllIllllllIIllIlIIlII.drawString(this.displayedSubTitle, (float)(-lllllllllllIllIllllllIIllIlIIlII.getStringWidth(this.displayedSubTitle) / 2), 5.0f, 0xFFFFFF | lllllllllllIllIllllllIIllIIlIllI, true);
                GlStateManager.popMatrix();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        final Scoreboard lllllllllllIllIllllllIIllIIlIlIl = this.mc.world.getScoreboard();
        ScoreObjective lllllllllllIllIllllllIIllIIlIlII = null;
        final ScorePlayerTeam lllllllllllIllIllllllIIllIIlIIll = lllllllllllIllIllllllIIllIIlIlIl.getPlayersTeam(this.mc.player.getName());
        if (lllllllllllIllIllllllIIllIIlIIll != null) {
            final int lllllllllllIllIllllllIIllIIlIIlI = lllllllllllIllIllllllIIllIIlIIll.getChatFormat().getColorIndex();
            if (lllllllllllIllIllllllIIllIIlIIlI >= 0) {
                lllllllllllIllIllllllIIllIIlIlII = lllllllllllIllIllllllIIllIIlIlIl.getObjectiveInDisplaySlot(3 + lllllllllllIllIllllllIIllIIlIIlI);
            }
        }
        ScoreObjective lllllllllllIllIllllllIIllIIlIIIl = (lllllllllllIllIllllllIIllIIlIlII != null) ? lllllllllllIllIllllllIIllIIlIlII : lllllllllllIllIllllllIIllIIlIlIl.getObjectiveInDisplaySlot(1);
        if (lllllllllllIllIllllllIIllIIlIIIl != null && (!Main.featureDirector.getFeatureByClass(ScoreBoard.class).isToggled() || !ScoreBoard.noScore.getBoolValue())) {
            this.renderScoreboard(lllllllllllIllIllllllIIllIIlIIIl, lllllllllllIllIllllllIIllIlIIlll);
        }
        final EventRender2D lllllllllllIllIllllllIIllIIlIIII = new EventRender2D(lllllllllllIllIllllllIIllIlIIlll, lllllllllllIllIllllllIIllIlIlIII);
        lllllllllllIllIllllllIIllIIlIIII.call();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, (float)(lllllllllllIllIllllllIIllIlIIlIl - 48), 0.0f);
        this.mc.mcProfiler.startSection("chat");
        this.persistantChatGUI.drawChat(this.updateCounter);
        this.mc.mcProfiler.endSection();
        GlStateManager.popMatrix();
        lllllllllllIllIllllllIIllIIlIIIl = lllllllllllIllIllllllIIllIIlIlIl.getObjectiveInDisplaySlot(0);
        if (this.mc.gameSettings.keyBindPlayerList.isKeyDown() && (!this.mc.isIntegratedServerRunning() || this.mc.player.connection.getPlayerInfoMap().size() > 1 || lllllllllllIllIllllllIIllIIlIIIl != null)) {
            this.overlayPlayerList.updatePlayerList(true);
            this.overlayPlayerList.renderPlayerlist(lllllllllllIllIllllllIIllIlIIllI, lllllllllllIllIllllllIIllIIlIlIl, lllllllllllIllIllllllIIllIIlIIIl);
        }
        else {
            this.overlayPlayerList.updatePlayerList(false);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }
    
    public int getUpdateCounter() {
        return this.updateCounter;
    }
    
    protected void renderPotionEffects(final ScaledResolution lllllllllllIllIllllllIIlIIllllIl) {
        final ScaledResolution lllllllllllIllIllllllIIlIlIIlIll = new ScaledResolution(this.mc);
        final Collection<PotionEffect> lllllllllllIllIllllllIIlIlIIlIlI = this.mc.player.getActivePotionEffects();
        if (!lllllllllllIllIllllllIIlIlIIlIlI.isEmpty()) {
            this.mc.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
            GlStateManager.enableBlend();
            int lllllllllllIllIllllllIIlIlIIlIIl = 0;
            int lllllllllllIllIllllllIIlIlIIlIII = 0;
            for (final PotionEffect lllllllllllIllIllllllIIlIlIIIllI : Ordering.natural().reverse().sortedCopy((Iterable)lllllllllllIllIllllllIIlIlIIlIlI)) {
                final Potion lllllllllllIllIllllllIIlIlIIIlIl = lllllllllllIllIllllllIIlIlIIIllI.getPotion();
                boolean lllllllllllIllIllllllIIlIlIIIlII = lllllllllllIllIllllllIIlIlIIIlIl.hasStatusIcon();
                if (Reflector.ForgePotion_shouldRenderHUD.exists()) {
                    if (!Reflector.callBoolean((Object)lllllllllllIllIllllllIIlIlIIIlIl, Reflector.ForgePotion_shouldRenderHUD, new Object[] { lllllllllllIllIllllllIIlIlIIIllI })) {
                        continue;
                    }
                    this.mc.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
                    lllllllllllIllIllllllIIlIlIIIlII = true;
                }
                if (lllllllllllIllIllllllIIlIlIIIlII && lllllllllllIllIllllllIIlIlIIIllI.doesShowParticles()) {
                    int lllllllllllIllIllllllIIlIlIIIIll = lllllllllllIllIllllllIIlIIllllIl.getScaledWidth();
                    int lllllllllllIllIllllllIIlIlIIIIlI = 1;
                    if (this.mc.isDemo()) {
                        lllllllllllIllIllllllIIlIlIIIIlI += 15;
                    }
                    final int lllllllllllIllIllllllIIlIlIIIIIl = lllllllllllIllIllllllIIlIlIIIlIl.getStatusIconIndex();
                    if (lllllllllllIllIllllllIIlIlIIIlIl.isBeneficial()) {
                        ++lllllllllllIllIllllllIIlIlIIlIIl;
                        lllllllllllIllIllllllIIlIlIIIIll -= 25 * lllllllllllIllIllllllIIlIlIIlIIl;
                    }
                    else {
                        ++lllllllllllIllIllllllIIlIlIIlIII;
                        lllllllllllIllIllllllIIlIlIIIIll -= 25 * lllllllllllIllIllllllIIlIlIIlIII;
                        lllllllllllIllIllllllIIlIlIIIIlI += 26;
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    float lllllllllllIllIllllllIIlIlIIIIII = 1.0f;
                    if (lllllllllllIllIllllllIIlIlIIIllI.getIsAmbient() && lllllllllllIllIllllllIIlIlIIIllI.getDuration() <= 200) {
                        final int lllllllllllIllIllllllIIlIIllllll = 10 - lllllllllllIllIllllllIIlIlIIIllI.getDuration() / 20;
                        lllllllllllIllIllllllIIlIlIIIIII = MathHelper.clamp(lllllllllllIllIllllllIIlIlIIIllI.getDuration() / 10.0f / 5.0f * 0.5f, 0.0f, 0.5f) + MathHelper.cos(lllllllllllIllIllllllIIlIlIIIllI.getDuration() * 3.1415927f / 5.0f) * MathHelper.clamp(lllllllllllIllIllllllIIlIIllllll / 10.0f * 0.25f, 0.0f, 0.25f);
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllIllIllllllIIlIlIIIIII);
                    if (Reflector.ForgePotion_renderHUDEffect.exists()) {
                        if (lllllllllllIllIllllllIIlIlIIIlIl.hasStatusIcon()) {
                            this.drawTexturedModalRect(3, -lllllllllllIllIllllllIIlIlIIIIlI + lllllllllllIllIllllllIIlIlIIlIll.getScaledHeight() - 20 + lllllllllllIllIllllllIIlIlIIIIll - lllllllllllIllIllllllIIlIlIIlIll.getScaledWidth() + 30, lllllllllllIllIllllllIIlIlIIIIIl % 8 * 18, 198 + lllllllllllIllIllllllIIlIlIIIIIl / 8 * 18, 18, 18);
                        }
                        Reflector.call((Object)lllllllllllIllIllllllIIlIlIIIlIl, Reflector.ForgePotion_renderHUDEffect, new Object[] { lllllllllllIllIllllllIIlIlIIIIll, lllllllllllIllIllllllIIlIlIIIIlI, lllllllllllIllIllllllIIlIlIIIllI, this.mc, lllllllllllIllIllllllIIlIlIIIIII });
                    }
                    else {
                        this.drawTexturedModalRect(6, -lllllllllllIllIllllllIIlIlIIIIlI + lllllllllllIllIllllllIIlIlIIlIll.getScaledHeight() / 2 + lllllllllllIllIllllllIIlIlIIIIll - lllllllllllIllIllllllIIlIlIIlIll.getScaledWidth() + 30, lllllllllllIllIllllllIIlIlIIIIIl % 8 * 18, 198 + lllllllllllIllIllllllIIlIlIIIIIl / 8 * 18, 18, 18);
                    }
                    DrawHelper.drawCircle(14.8f, -lllllllllllIllIllllllIIlIlIIIIlI + lllllllllllIllIllllllIIlIlIIlIll.getScaledHeight() / 2 + lllllllllllIllIllllllIIlIlIIIIll - lllllllllllIllIllllllIIlIlIIlIll.getScaledWidth() + 38.5f, 0.0f, (float)lllllllllllIllIllllllIIlIlIIIllI.duration, 10.0f, 5.0f, false, ClientHelper.getClientColor());
                }
            }
        }
    }
}
