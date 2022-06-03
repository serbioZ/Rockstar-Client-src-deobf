// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.shader.ShaderLinkHelper;
import ru.rockstar.api.event.event.EventFogColor;
import ru.rockstar.client.features.impl.visuals.FogColor;
import org.lwjgl.opengl.GLContext;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.passive.EntityAnimal;
import ru.rockstar.client.features.impl.visuals.NoRender;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockBed;
import net.minecraft.init.Blocks;
import optifine.RandomMobs;
import optifine.TextureUtils;
import com.google.gson.JsonSyntaxException;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldProvider;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import ru.rockstar.client.features.impl.visuals.Weather;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.EnumFacing;
import ru.rockstar.client.features.impl.combat.Reach;
import ru.rockstar.client.features.impl.player.NoInteract;
import net.minecraft.entity.item.EntityArmorStand;
import com.google.common.base.Predicates;
import com.google.common.base.Predicate;
import net.minecraft.util.EntitySelectors;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NightMode;
import ru.rockstar.Main;
import optifine.CustomColors;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.IInventory;
import optifine.ReflectorForge;
import net.minecraft.world.GameType;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityCreeper;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.chunk.RenderChunk;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.crash.CrashReportCategory;
import ru.rockstar.api.utils.notifications.NotificationPublisher;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import java.util.Date;
import java.util.Calendar;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.util.glu.GLU;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.particle.ParticleManager;
import ru.rockstar.api.event.event.Event3D;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import org.lwjgl.opengl.GL11;
import optifine.Lagometer;
import net.minecraft.client.renderer.texture.TextureMap;
import shadersmod.client.ShadersRender;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.entity.player.EntityPlayer;
import optifine.Reflector;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.init.MobEffects;
import org.lwjgl.util.glu.Project;
import org.apache.logging.log4j.LogManager;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.MouseFilter;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.entity.Entity;
import java.nio.FloatBuffer;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class EntityRenderer implements IResourceManagerReloadListener
{
    private /* synthetic */ boolean lightmapUpdateNeeded;
    private /* synthetic */ float bossColorModifierPrev;
    private final /* synthetic */ FloatBuffer fogColorBuffer;
    private /* synthetic */ Entity pointedEntity;
    public /* synthetic */ float fogColorGreen;
    private /* synthetic */ float avgServerTickDiff;
    private /* synthetic */ int lastServerTicks;
    private /* synthetic */ float smoothCamPitch;
    private final /* synthetic */ int[] lightmapColors;
    private final /* synthetic */ Random random;
    public static /* synthetic */ boolean anaglyphEnable;
    public /* synthetic */ float fogColorBlue;
    private /* synthetic */ float clipDistance;
    private /* synthetic */ boolean loadVisibleChunks;
    private /* synthetic */ World updatedWorld;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ float thirdPersonDistancePrev;
    private /* synthetic */ MouseFilter mouseFilterXAxis;
    public /* synthetic */ ItemRenderer itemRenderer;
    private /* synthetic */ float field_190568_ad;
    private static final /* synthetic */ ResourceLocation RAIN_TEXTURES;
    private /* synthetic */ boolean renderHand;
    private /* synthetic */ ShaderGroup[] fxaaShaders;
    private /* synthetic */ float farPlaneDistance;
    private final /* synthetic */ ResourceLocation locationLightMap;
    private /* synthetic */ boolean useShader;
    private /* synthetic */ long timeWorldIcon;
    private static final /* synthetic */ ResourceLocation SNOW_TEXTURES;
    private /* synthetic */ float smoothCamFilterX;
    private final /* synthetic */ float[] rainYCoords;
    private /* synthetic */ float smoothCamYaw;
    public /* synthetic */ int frameCount;
    private final /* synthetic */ IResourceManager resourceManager;
    public /* synthetic */ float fogColorRed;
    private /* synthetic */ boolean drawBlockOutline;
    private /* synthetic */ int debugViewDirection;
    private /* synthetic */ int shaderIndex;
    private /* synthetic */ int rendererUpdateCount;
    private /* synthetic */ float scopeMath;
    private /* synthetic */ int serverWaitTimeCurrent;
    private /* synthetic */ float fovModifierHandPrev;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ long lastErrorCheckTimeMs;
    private static final /* synthetic */ ResourceLocation[] SHADERS_TEXTURES;
    private /* synthetic */ int field_190567_ac;
    private /* synthetic */ float smoothCamFilterY;
    private /* synthetic */ float avgServerTimeDiff;
    private /* synthetic */ double cameraZoom;
    private /* synthetic */ float bossColorModifier;
    public /* synthetic */ boolean fogStandard;
    private final /* synthetic */ float[] rainXCoords;
    private /* synthetic */ long lastServerTime;
    private final /* synthetic */ MapItemRenderer theMapItemRenderer;
    private /* synthetic */ MouseFilter mouseFilterYAxis;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ long renderEndNanoTime;
    public static /* synthetic */ int anaglyphField;
    private /* synthetic */ int serverWaitTime;
    private /* synthetic */ float field_190569_ae;
    private /* synthetic */ float fovModifierHand;
    private /* synthetic */ boolean debugView;
    public /* synthetic */ ShaderGroup theShaderGroup;
    private /* synthetic */ float torchFlickerX;
    public static final /* synthetic */ int SHADER_COUNT;
    private final /* synthetic */ DynamicTexture lightmapTexture;
    private /* synthetic */ double cameraPitch;
    private /* synthetic */ float fogColor1;
    private /* synthetic */ ItemStack field_190566_ab;
    private /* synthetic */ float smoothCamPartialTicks;
    private /* synthetic */ int rainSoundCounter;
    private /* synthetic */ long prevFrameTime;
    private /* synthetic */ float fogColor2;
    private /* synthetic */ boolean cloudFog;
    private /* synthetic */ double cameraYaw;
    private /* synthetic */ float torchFlickerDX;
    
    public void enableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        final float llllllllllllIlIlIIlIlIllIlIlIIIl = 0.00390625f;
        GlStateManager.scale(0.00390625f, 0.00390625f, 0.00390625f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.matrixMode(5888);
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GlStateManager.glTexParameteri(3553, 10241, 9729);
        GlStateManager.glTexParameteri(3553, 10240, 9729);
        GlStateManager.glTexParameteri(3553, 10242, 10496);
        GlStateManager.glTexParameteri(3553, 10243, 10496);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.enableLightmap();
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RAIN_TEXTURES = new ResourceLocation("textures/environment/rain.png");
        SNOW_TEXTURES = new ResourceLocation("textures/environment/snow.png");
        SHADERS_TEXTURES = new ResourceLocation[] { new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json") };
        SHADER_COUNT = EntityRenderer.SHADERS_TEXTURES.length;
    }
    
    public void setupCameraTransform(final float llllllllllllIlIlIIlIlIlllIIIIllI, final int llllllllllllIlIlIIlIlIllIllllllI) {
        this.farPlaneDistance = (float)(this.mc.gameSettings.renderDistanceChunks * 16);
        if (Config.isFogFancy()) {
            this.farPlaneDistance *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.farPlaneDistance *= 0.83f;
        }
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        final float llllllllllllIlIlIIlIlIlllIIIIlII = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate(-(llllllllllllIlIlIIlIlIllIllllllI * 2 - 1) * 0.07f, 0.0f, 0.0f);
        }
        this.clipDistance = this.farPlaneDistance * 2.0f;
        if (this.clipDistance < 173.0f) {
            this.clipDistance = 173.0f;
        }
        if (this.cameraZoom != 1.0) {
            GlStateManager.translate((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIlllIIIIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((llllllllllllIlIlIIlIlIllIllllllI * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(llllllllllllIlIlIIlIlIlllIIIIllI);
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(llllllllllllIlIlIIlIlIlllIIIIllI);
        }
        final float llllllllllllIlIlIIlIlIlllIIIIIll = this.mc.player.prevTimeInPortal + (this.mc.player.timeInPortal - this.mc.player.prevTimeInPortal) * llllllllllllIlIlIIlIlIlllIIIIllI;
        if (llllllllllllIlIlIIlIlIlllIIIIIll > 0.0f) {
            int llllllllllllIlIlIIlIlIlllIIIIIlI = 20;
            if (this.mc.player.isPotionActive(MobEffects.NAUSEA)) {
                llllllllllllIlIlIIlIlIlllIIIIIlI = 7;
            }
            float llllllllllllIlIlIIlIlIlllIIIIIIl = 5.0f / (llllllllllllIlIlIIlIlIlllIIIIIll * llllllllllllIlIlIIlIlIlllIIIIIll + 5.0f) - llllllllllllIlIlIIlIlIlllIIIIIll * 0.04f;
            llllllllllllIlIlIIlIlIlllIIIIIIl *= llllllllllllIlIlIIlIlIlllIIIIIIl;
            GlStateManager.rotate((this.rendererUpdateCount + llllllllllllIlIlIIlIlIlllIIIIllI) * llllllllllllIlIlIIlIlIlllIIIIIlI, 0.0f, 1.0f, 1.0f);
            GlStateManager.scale(1.0f / llllllllllllIlIlIIlIlIlllIIIIIIl, 1.0f, 1.0f);
            GlStateManager.rotate(-(this.rendererUpdateCount + llllllllllllIlIlIIlIlIlllIIIIllI) * llllllllllllIlIlIIlIlIlllIIIIIlI, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(llllllllllllIlIlIIlIlIlllIIIIllI);
        if (this.debugView) {
            switch (this.debugViewDirection) {
                case 0: {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 1: {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
            }
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllIlIlIIlIllIIIlllIlll) {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        if (this.shaderIndex == EntityRenderer.SHADER_COUNT) {
            this.loadEntityShader(this.mc.getRenderViewEntity());
        }
        else {
            this.loadShader(EntityRenderer.SHADERS_TEXTURES[this.shaderIndex]);
        }
    }
    
    private void checkLoadVisibleChunks(final Entity llllllllllllIlIlIIlIlIIIlIIllIII, final float llllllllllllIlIlIIlIlIIIlIIlIlll, final ICamera llllllllllllIlIlIIlIlIIIlIIlllIl, final boolean llllllllllllIlIlIIlIlIIIlIIlllII) {
        final int llllllllllllIlIlIIlIlIIIlIIllIll = 201435902;
        if (this.loadVisibleChunks) {
            this.loadVisibleChunks = false;
            this.loadAllVisibleChunks(llllllllllllIlIlIIlIlIIIlIIllIII, llllllllllllIlIlIIlIlIIIlIIlIlll, llllllllllllIlIlIIlIlIIIlIIlllIl, llllllllllllIlIlIIlIlIIIlIIlllII);
            this.mc.ingameGUI.getChatGUI().deleteChatLine(llllllllllllIlIlIIlIlIIIlIIllIll);
        }
        if (Keyboard.isKeyDown(61) && Keyboard.isKeyDown(38)) {
            if (this.mc.gameSettings.field_194146_ao.getKeyCode() == 38) {
                if (this.mc.currentScreen instanceof GuiScreenAdvancements) {
                    this.mc.displayGuiScreen(null);
                }
                while (Keyboard.next()) {}
            }
            if (this.mc.currentScreen != null) {
                return;
            }
            this.loadVisibleChunks = true;
            final TextComponentString llllllllllllIlIlIIlIlIIIlIIllIlI = new TextComponentString(I18n.format("of.message.loadingVisibleChunks", new Object[0]));
            this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(llllllllllllIlIlIIlIlIIIlIIllIlI, llllllllllllIlIlIIlIlIIIlIIllIll);
            Reflector.Minecraft_actionKeyF3.setValue((Object)this.mc, (Object)Boolean.TRUE);
        }
    }
    
    private void renderWorldPass(final int llllllllllllIlIlIIlIlIlIIlllIlIl, final float llllllllllllIlIlIIlIlIlIIllIIIll, final long llllllllllllIlIlIIlIlIlIIlllIIll) {
        final boolean llllllllllllIlIlIIlIlIlIIlllIIlI = Config.isShaders();
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.beginRenderPass(llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIIll);
        }
        final RenderGlobal llllllllllllIlIlIIlIlIlIIlllIIIl = this.mc.renderGlobal;
        final ParticleManager llllllllllllIlIlIIlIlIlIIlllIIII = this.mc.effectRenderer;
        final boolean llllllllllllIlIlIIlIlIlIIllIllll = this.isDrawBlockOutline();
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("clear");
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.setViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        else {
            GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        this.updateFogColor(llllllllllllIlIlIIlIlIlIIllIIIll);
        GlStateManager.clear(16640);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.clearRenderBuffer();
        }
        this.mc.mcProfiler.endStartSection("camera");
        this.setupCameraTransform(llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.setCamera(llllllllllllIlIlIIlIlIlIIllIIIll);
        }
        ActiveRenderInfo.updateRenderInfo(this.mc.player, this.mc.gameSettings.thirdPersonView == 2);
        this.mc.mcProfiler.endStartSection("frustum");
        final ClippingHelper llllllllllllIlIlIIlIlIlIIllIlllI = ClippingHelperImpl.getInstance();
        this.mc.mcProfiler.endStartSection("culling");
        final ICamera llllllllllllIlIlIIlIlIlIIllIllIl = new Frustum(llllllllllllIlIlIIlIlIlIIllIlllI);
        final Entity llllllllllllIlIlIIlIlIlIIllIllII = this.mc.getRenderViewEntity();
        final double llllllllllllIlIlIIlIlIlIIllIlIll = llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosX + (llllllllllllIlIlIIlIlIlIIllIllII.posX - llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosX) * llllllllllllIlIlIIlIlIlIIllIIIll;
        final double llllllllllllIlIlIIlIlIlIIllIlIlI = llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosY + (llllllllllllIlIlIIlIlIlIIllIllII.posY - llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosY) * llllllllllllIlIlIIlIlIlIIllIIIll;
        final double llllllllllllIlIlIIlIlIlIIllIlIIl = llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosZ + (llllllllllllIlIlIIlIlIlIIllIllII.posZ - llllllllllllIlIlIIlIlIlIIllIllII.lastTickPosZ) * llllllllllllIlIlIIlIlIlIIllIIIll;
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.setFrustrumPosition(llllllllllllIlIlIIlIlIlIIllIllIl, llllllllllllIlIlIIlIlIlIIllIlIll, llllllllllllIlIlIIlIlIlIIllIlIlI, llllllllllllIlIlIIlIlIlIIllIlIIl);
        }
        else {
            llllllllllllIlIlIIlIlIlIIllIllIl.setPosition(llllllllllllIlIlIIlIlIlIIllIlIll, llllllllllllIlIlIIlIlIlIIllIlIlI, llllllllllllIlIlIIlIlIlIIllIlIIl);
        }
        if ((Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled()) && !Shaders.isShadowPass) {
            this.setupFog(-1, llllllllllllIlIlIIlIlIlIIllIIIll);
            this.mc.mcProfiler.endStartSection("sky");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIlIIllIIIll, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                Shaders.beginSky();
            }
            llllllllllllIlIlIIlIlIlIIlllIIIl.renderSky(llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                Shaders.endSky();
            }
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIlIIllIIIll, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
        else {
            GlStateManager.disableBlend();
        }
        this.setupFog(0, llllllllllllIlIlIIlIlIlIIllIIIll);
        GlStateManager.shadeModel(7425);
        if (llllllllllllIlIlIIlIlIlIIllIllII.posY + llllllllllllIlIlIIlIlIlIIllIllII.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.renderCloudsCheck(llllllllllllIlIlIIlIlIlIIlllIIIl, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIlIll, llllllllllllIlIlIIlIlIlIIllIlIlI, llllllllllllIlIlIIlIlIlIIllIlIIl);
        }
        this.mc.mcProfiler.endStartSection("prepareterrain");
        this.setupFog(0, llllllllllllIlIlIIlIlIlIIllIIIll);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("terrain_setup");
        this.checkLoadVisibleChunks(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIllIllIl, this.mc.player.isSpectator());
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.setupTerrain(llllllllllllIlIlIIlIlIlIIlllIIIl, llllllllllllIlIlIIlIlIlIIllIllII, (double)llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIllIllIl, this.frameCount++, this.mc.player.isSpectator());
        }
        else {
            llllllllllllIlIlIIlIlIlIIlllIIIl.setupTerrain(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIllIllIl, this.frameCount++, this.mc.player.isSpectator());
        }
        if (llllllllllllIlIlIIlIlIlIIlllIlIl == 0 || llllllllllllIlIlIIlIlIlIIlllIlIl == 2) {
            this.mc.mcProfiler.endStartSection("updatechunks");
            Lagometer.timerChunkUpload.start();
            this.mc.renderGlobal.updateChunks(llllllllllllIlIlIIlIlIlIIlllIIll);
            Lagometer.timerChunkUpload.end();
        }
        this.mc.mcProfiler.endStartSection("terrain");
        Lagometer.timerTerrain.start();
        if (this.mc.gameSettings.ofSmoothFps && llllllllllllIlIlIIlIlIlIIlllIlIl > 0) {
            this.mc.mcProfiler.endStartSection("finish");
            GL11.glFinish();
            this.mc.mcProfiler.endStartSection("terrain");
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.beginTerrainSolid();
        }
        llllllllllllIlIlIIlIlIlIIlllIIIl.renderBlockLayer(BlockRenderLayer.SOLID, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIllII);
        GlStateManager.enableAlpha();
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.beginTerrainCutoutMipped();
        }
        llllllllllllIlIlIIlIlIlIIlllIIIl.renderBlockLayer(BlockRenderLayer.CUTOUT_MIPPED, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIllII);
        this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.beginTerrainCutout();
        }
        llllllllllllIlIlIIlIlIlIIlllIIIl.renderBlockLayer(BlockRenderLayer.CUTOUT, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIllII);
        this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.endTerrain();
        }
        Lagometer.timerTerrain.end();
        GlStateManager.shadeModel(7424);
        GlStateManager.alphaFunc(516, 0.1f);
        if (!this.debugView) {
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, new Object[] { 0 });
            }
            llllllllllllIlIlIIlIlIlIIlllIIIl.renderEntities(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIllIl, llllllllllllIlIlIIlIlIlIIllIIIll);
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, new Object[] { -1 });
            }
            RenderHelper.disableStandardItemLighting();
            this.disableLightmap();
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        if (llllllllllllIlIlIIlIlIlIIllIllll && this.mc.objectMouseOver != null && !llllllllllllIlIlIIlIlIlIIllIllII.isInsideOfMaterial(Material.WATER)) {
            final EntityPlayer llllllllllllIlIlIIlIlIlIIllIlIII = (EntityPlayer)llllllllllllIlIlIIlIlIlIIllIllII;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            if (!Reflector.ForgeHooksClient_onDrawBlockHighlight.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, new Object[] { llllllllllllIlIlIIlIlIlIIlllIIIl, llllllllllllIlIlIIlIlIlIIllIlIII, this.mc.objectMouseOver, 0, llllllllllllIlIlIIlIlIlIIllIIIll })) {
                llllllllllllIlIlIIlIlIlIIlllIIIl.drawSelectionBox(llllllllllllIlIlIIlIlIlIIllIlIII, this.mc.objectMouseOver, 0, llllllllllllIlIlIIlIlIlIIllIIIll);
            }
            GlStateManager.enableAlpha();
        }
        if (this.mc.debugRenderer.shouldRender()) {
            final boolean llllllllllllIlIlIIlIlIlIIllIIlll = GlStateManager.isFogEnabled();
            GlStateManager.disableFog();
            this.mc.debugRenderer.renderDebug(llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIIll);
            GlStateManager.setFogEnabled(llllllllllllIlIlIIlIlIlIIllIIlll);
        }
        if (!llllllllllllIlIlIIlIlIlIIlllIIIl.damagedBlocks.isEmpty()) {
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            llllllllllllIlIlIIlIlIlIIlllIIIl.drawBlockDamageTexture(Tessellator.getInstance(), Tessellator.getInstance().getBuffer(), llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll);
            this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
            GlStateManager.disableBlend();
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableBlend();
        if (!this.debugView) {
            this.enableLightmap();
            this.mc.mcProfiler.endStartSection("litParticles");
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                Shaders.beginLitParticles();
            }
            llllllllllllIlIlIIlIlIlIIlllIIII.renderLitParticles(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll);
            RenderHelper.disableStandardItemLighting();
            this.setupFog(0, llllllllllllIlIlIIlIlIlIIllIIIll);
            this.mc.mcProfiler.endStartSection("particles");
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                Shaders.beginParticles();
            }
            llllllllllllIlIlIIlIlIlIIlllIIII.renderParticles(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll);
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                Shaders.endParticles();
            }
            this.disableLightmap();
        }
        GlStateManager.depthMask(false);
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("weather");
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.beginWeather();
        }
        this.renderRainSnow(llllllllllllIlIlIIlIlIlIIllIIIll);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.endWeather();
        }
        GlStateManager.depthMask(true);
        llllllllllllIlIlIIlIlIlIIlllIIIl.renderWorldBorder(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIIIll);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            ShadersRender.renderHand0(this, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
            Shaders.preWater();
        }
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc(516, 0.1f);
        this.setupFog(0, llllllllllllIlIlIIlIlIlIIllIIIll);
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.shadeModel(7425);
        this.mc.mcProfiler.endStartSection("translucent");
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.beginWater();
        }
        llllllllllllIlIlIIlIlIlIIlllIIIl.renderBlockLayer(BlockRenderLayer.TRANSLUCENT, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIllII);
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.endWater();
        }
        if (Reflector.ForgeHooksClient_setRenderPass.exists() && !this.debugView) {
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, new Object[] { 1 });
            this.mc.renderGlobal.renderEntities(llllllllllllIlIlIIlIlIlIIllIllII, llllllllllllIlIlIIlIlIlIIllIllIl, llllllllllllIlIlIIlIlIlIIllIIIll);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, new Object[] { -1 });
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.shadeModel(7424);
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        if (llllllllllllIlIlIIlIlIlIIllIllII.posY + llllllllllllIlIlIIlIlIlIIllIllII.getEyeHeight() >= 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.mc.mcProfiler.endStartSection("aboveClouds");
            this.renderCloudsCheck(llllllllllllIlIlIIlIlIlIIlllIIIl, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl, llllllllllllIlIlIIlIlIlIIllIlIll, llllllllllllIlIlIIlIlIlIIllIlIlI, llllllllllllIlIlIIlIlIlIIllIlIIl);
        }
        if (Reflector.ForgeHooksClient_dispatchRenderLast.exists()) {
            this.mc.mcProfiler.endStartSection("forge_render_last");
            Reflector.callVoid(Reflector.ForgeHooksClient_dispatchRenderLast, new Object[] { llllllllllllIlIlIIlIlIlIIlllIIIl, llllllllllllIlIlIIlIlIlIIllIIIll });
        }
        final Event3D llllllllllllIlIlIIlIlIlIIllIIllI = new Event3D(llllllllllllIlIlIIlIlIlIIllIIIll);
        llllllllllllIlIlIIlIlIlIIllIIllI.call();
        this.mc.mcProfiler.endStartSection("hand");
        if (this.renderHand && !Shaders.isShadowPass) {
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                ShadersRender.renderHand1(this, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
                Shaders.renderCompositeFinal();
            }
            GlStateManager.clear(256);
            if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
                ShadersRender.renderFPOverlay(this, llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
            }
            else {
                this.renderHand(llllllllllllIlIlIIlIlIlIIllIIIll, llllllllllllIlIlIIlIlIlIIlllIlIl);
            }
        }
        if (llllllllllllIlIlIIlIlIlIIlllIIlI) {
            Shaders.endRender();
        }
    }
    
    private void frameFinish() {
        if (this.mc.world != null) {
            final long llllllllllllIlIlIIlIlIIIllIIIllI = System.currentTimeMillis();
            if (llllllllllllIlIlIIlIlIIIllIIIllI > this.lastErrorCheckTimeMs + 10000L) {
                this.lastErrorCheckTimeMs = llllllllllllIlIlIIlIlIIIllIIIllI;
                final int llllllllllllIlIlIIlIlIIIllIIIlIl = GlStateManager.glGetError();
                if (llllllllllllIlIlIIlIlIIIllIIIlIl != 0) {
                    final String llllllllllllIlIlIIlIlIIIllIIIlII = GLU.gluErrorString(llllllllllllIlIlIIlIlIIIllIIIlIl);
                    final TextComponentString llllllllllllIlIlIIlIlIIIllIIIIll = new TextComponentString(I18n.format("of.message.openglError", llllllllllllIlIlIIlIlIIIllIIIlIl, llllllllllllIlIlIIlIlIIIllIIIlII));
                    this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllIlIlIIlIlIIIllIIIIll);
                }
            }
        }
    }
    
    public void disableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.disableLightmap();
        }
    }
    
    private void func_190563_a(final int llllllllllllIlIlIIlIlIIIIIllIIll, final int llllllllllllIlIlIIlIlIIIIIlIIlIl, final float llllllllllllIlIlIIlIlIIIIIllIIIl) {
        if (this.field_190566_ab != null && this.field_190567_ac > 0) {
            final int llllllllllllIlIlIIlIlIIIIIllIIII = 40 - this.field_190567_ac;
            final float llllllllllllIlIlIIlIlIIIIIlIllll = (llllllllllllIlIlIIlIlIIIIIllIIII + llllllllllllIlIlIIlIlIIIIIllIIIl) / 40.0f;
            final float llllllllllllIlIlIIlIlIIIIIlIlllI = llllllllllllIlIlIIlIlIIIIIlIllll * llllllllllllIlIlIIlIlIIIIIlIllll;
            final float llllllllllllIlIlIIlIlIIIIIlIllIl = llllllllllllIlIlIIlIlIIIIIlIllll * llllllllllllIlIlIIlIlIIIIIlIlllI;
            final float llllllllllllIlIlIIlIlIIIIIlIllII = 10.25f * llllllllllllIlIlIIlIlIIIIIlIllIl * llllllllllllIlIlIIlIlIIIIIlIlllI + -24.95f * llllllllllllIlIlIIlIlIIIIIlIlllI * llllllllllllIlIlIIlIlIIIIIlIlllI + 25.5f * llllllllllllIlIlIIlIlIIIIIlIllIl + -13.8f * llllllllllllIlIlIIlIlIIIIIlIlllI + 4.0f * llllllllllllIlIlIIlIlIIIIIlIllll;
            final float llllllllllllIlIlIIlIlIIIIIlIlIll = llllllllllllIlIlIIlIlIIIIIlIllII * 3.1415927f;
            final float llllllllllllIlIlIIlIlIIIIIlIlIlI = this.field_190568_ad * (llllllllllllIlIlIIlIlIIIIIllIIll / 4);
            final float llllllllllllIlIlIIlIlIIIIIlIlIIl = this.field_190569_ae * (llllllllllllIlIlIIlIlIIIIIlIIlIl / 4);
            GlStateManager.enableAlpha();
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.translate(llllllllllllIlIlIIlIlIIIIIllIIll / 2 + llllllllllllIlIlIIlIlIIIIIlIlIlI * MathHelper.abs(MathHelper.sin(llllllllllllIlIlIIlIlIIIIIlIlIll * 2.0f)), llllllllllllIlIlIIlIlIIIIIlIIlIl / 2 + llllllllllllIlIlIIlIlIIIIIlIlIIl * MathHelper.abs(MathHelper.sin(llllllllllllIlIlIIlIlIIIIIlIlIll * 2.0f)), -50.0f);
            final float llllllllllllIlIlIIlIlIIIIIlIlIII = 50.0f + 175.0f * MathHelper.sin(llllllllllllIlIlIIlIlIIIIIlIlIll);
            GlStateManager.scale(llllllllllllIlIlIIlIlIIIIIlIlIII, -llllllllllllIlIlIIlIlIIIIIlIlIII, llllllllllllIlIlIIlIlIIIIIlIlIII);
            GlStateManager.rotate(900.0f * MathHelper.abs(MathHelper.sin(llllllllllllIlIlIIlIlIIIIIlIlIll)), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(6.0f * MathHelper.cos(llllllllllllIlIlIIlIlIIIIIlIllll * 8.0f), 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(6.0f * MathHelper.cos(llllllllllllIlIlIIlIlIIIIIlIllll * 8.0f), 0.0f, 0.0f, 1.0f);
            this.mc.getRenderItem().renderItem(this.field_190566_ab, ItemCameraTransforms.TransformType.FIXED);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.disableDepth();
        }
    }
    
    private void updateMainMenu(final GuiMainMenu llllllllllllIlIlIIlIlIIIlIllIIlI) {
        try {
            String llllllllllllIlIlIIlIlIIIlIllIllI = null;
            final Calendar llllllllllllIlIlIIlIlIIIlIllIlIl = Calendar.getInstance();
            llllllllllllIlIlIIlIlIIIlIllIlIl.setTime(new Date());
            final int llllllllllllIlIlIIlIlIIIlIllIlII = llllllllllllIlIlIIlIlIIIlIllIlIl.get(5);
            final int llllllllllllIlIlIIlIlIIIlIllIIll = llllllllllllIlIlIIlIlIIIlIllIlIl.get(2) + 1;
            if (llllllllllllIlIlIIlIlIIIlIllIlII == 8 && llllllllllllIlIlIIlIlIIIlIllIIll == 4) {
                llllllllllllIlIlIIlIlIIIlIllIllI = "Happy birthday, OptiFine!";
            }
            if (llllllllllllIlIlIIlIlIIIlIllIlII == 14 && llllllllllllIlIlIIlIlIIIlIllIIll == 8) {
                llllllllllllIlIlIIlIlIIIlIllIllI = "Happy birthday, sp614x!";
            }
            if (llllllllllllIlIlIIlIlIIIlIllIllI == null) {
                return;
            }
            Reflector.setFieldValue((Object)llllllllllllIlIlIIlIlIIIlIllIIlI, Reflector.GuiMainMenu_splashText, (Object)llllllllllllIlIlIIlIlIIIlIllIllI);
        }
        catch (Throwable t) {}
    }
    
    public void updateCameraAndRender(final float llllllllllllIlIlIIlIlIlIllIIllIl, final long llllllllllllIlIlIIlIlIlIlllIIIlI) {
        this.frameInit();
        final boolean llllllllllllIlIlIIlIlIlIlllIIIIl = Display.isActive();
        if (!llllllllllllIlIlIIlIlIlIlllIIIIl && this.mc.gameSettings.pauseOnLostFocus && (!this.mc.gameSettings.touchscreen || !Mouse.isButtonDown(1))) {
            if (Minecraft.getSystemTime() - this.prevFrameTime > 500L) {
                this.mc.displayInGameMenu();
            }
        }
        else {
            this.prevFrameTime = Minecraft.getSystemTime();
        }
        this.mc.mcProfiler.startSection("mouse");
        if (llllllllllllIlIlIIlIlIlIlllIIIIl && Minecraft.IS_RUNNING_ON_MAC && this.mc.inGameHasFocus && !Mouse.isInsideWindow()) {
            Mouse.setGrabbed(false);
            Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2 - 20);
            Mouse.setGrabbed(true);
        }
        if (this.mc.inGameHasFocus && llllllllllllIlIlIIlIlIlIlllIIIIl) {
            this.mc.mouseHelper.mouseXYChange();
            this.mc.func_193032_ao().func_193299_a(this.mc.mouseHelper);
            final float llllllllllllIlIlIIlIlIlIlllIIIII = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float llllllllllllIlIlIIlIlIlIllIlllll = llllllllllllIlIlIIlIlIlIlllIIIII * llllllllllllIlIlIIlIlIlIlllIIIII * llllllllllllIlIlIIlIlIlIlllIIIII * 8.0f;
            float llllllllllllIlIlIIlIlIlIllIllllI = this.mc.mouseHelper.deltaX * llllllllllllIlIlIIlIlIlIllIlllll;
            float llllllllllllIlIlIIlIlIlIllIlllIl = this.mc.mouseHelper.deltaY * llllllllllllIlIlIIlIlIlIllIlllll;
            int llllllllllllIlIlIIlIlIlIllIlllII = 1;
            if (this.mc.gameSettings.invertMouse) {
                llllllllllllIlIlIIlIlIlIllIlllII = -1;
            }
            if (this.mc.gameSettings.smoothCamera) {
                this.smoothCamYaw += llllllllllllIlIlIIlIlIlIllIllllI;
                this.smoothCamPitch += llllllllllllIlIlIIlIlIlIllIlllIl;
                final float llllllllllllIlIlIIlIlIlIllIllIll = llllllllllllIlIlIIlIlIlIllIIllIl - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = llllllllllllIlIlIIlIlIlIllIIllIl;
                llllllllllllIlIlIIlIlIlIllIllllI = this.smoothCamFilterX * llllllllllllIlIlIIlIlIlIllIllIll;
                llllllllllllIlIlIIlIlIlIllIlllIl = this.smoothCamFilterY * llllllllllllIlIlIIlIlIlIllIllIll;
                this.mc.player.setAngles(llllllllllllIlIlIIlIlIlIllIllllI, llllllllllllIlIlIIlIlIlIllIlllIl * llllllllllllIlIlIIlIlIlIllIlllII);
            }
            else {
                this.smoothCamYaw = 0.0f;
                this.smoothCamPitch = 0.0f;
                this.mc.player.setAngles(llllllllllllIlIlIIlIlIlIllIllllI, llllllllllllIlIlIIlIlIlIllIlllIl * llllllllllllIlIlIIlIlIlIllIlllII);
            }
        }
        this.mc.mcProfiler.endSection();
        if (!this.mc.skipRenderWorld) {
            EntityRenderer.anaglyphEnable = this.mc.gameSettings.anaglyph;
            final ScaledResolution llllllllllllIlIlIIlIlIlIllIllIlI = new ScaledResolution(this.mc);
            final int llllllllllllIlIlIIlIlIlIllIllIIl = llllllllllllIlIlIIlIlIlIllIllIlI.getScaledWidth();
            final int llllllllllllIlIlIIlIlIlIllIllIII = llllllllllllIlIlIIlIlIlIllIllIlI.getScaledHeight();
            final int llllllllllllIlIlIIlIlIlIllIlIlll = Mouse.getX() * llllllllllllIlIlIIlIlIlIllIllIIl / this.mc.displayWidth;
            final int llllllllllllIlIlIIlIlIlIllIlIllI = llllllllllllIlIlIIlIlIlIllIllIII - Mouse.getY() * llllllllllllIlIlIIlIlIlIllIllIII / this.mc.displayHeight - 1;
            final int llllllllllllIlIlIIlIlIlIllIlIlIl = this.mc.gameSettings.limitFramerate;
            if (this.mc.world == null) {
                GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
                TileEntityRendererDispatcher.instance.renderEngine = this.mc.getTextureManager();
                TileEntityRendererDispatcher.instance.fontRenderer = Minecraft.fontRendererObj;
            }
            else {
                this.mc.mcProfiler.startSection("level");
                int llllllllllllIlIlIIlIlIlIllIlIlII = Math.min(Minecraft.getDebugFPS(), llllllllllllIlIlIIlIlIlIllIlIlIl);
                llllllllllllIlIlIIlIlIlIllIlIlII = Math.max(llllllllllllIlIlIIlIlIlIllIlIlII, 60);
                final long llllllllllllIlIlIIlIlIlIllIlIIll = System.nanoTime() - llllllllllllIlIlIIlIlIlIlllIIIlI;
                final long llllllllllllIlIlIIlIlIlIllIlIIlI = Math.max(1000000000 / llllllllllllIlIlIIlIlIlIllIlIlII / 4 - llllllllllllIlIlIIlIlIlIllIlIIll, 0L);
                this.renderWorld(llllllllllllIlIlIIlIlIlIllIIllIl, System.nanoTime() + llllllllllllIlIlIIlIlIlIllIlIIlI);
                if (this.mc.isSingleplayer() && this.timeWorldIcon < Minecraft.getSystemTime() - 1000L) {
                    this.timeWorldIcon = Minecraft.getSystemTime();
                    if (!this.mc.getIntegratedServer().isWorldIconSet()) {
                        this.createWorldIcon();
                    }
                }
                if (OpenGlHelper.shadersSupported) {
                    this.mc.renderGlobal.renderEntityOutlineFramebuffer();
                    if (this.theShaderGroup != null && this.useShader) {
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.loadIdentity();
                        this.theShaderGroup.loadShaderGroup(llllllllllllIlIlIIlIlIlIllIIllIl);
                        GlStateManager.popMatrix();
                    }
                    this.mc.getFramebuffer().bindFramebuffer(true);
                }
                this.renderEndNanoTime = System.nanoTime();
                this.mc.mcProfiler.endStartSection("gui");
                if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
                    GlStateManager.alphaFunc(516, 0.1f);
                    this.setupOverlayRendering();
                    this.func_190563_a(llllllllllllIlIlIIlIlIlIllIllIIl, llllllllllllIlIlIIlIlIlIllIllIII, llllllllllllIlIlIIlIlIlIllIIllIl);
                    this.mc.ingameGUI.renderGameOverlay(llllllllllllIlIlIIlIlIlIllIIllIl);
                    if (this.mc.gameSettings.ofShowFps && !this.mc.gameSettings.showDebugInfo) {
                        Config.drawFps();
                    }
                    if (this.mc.gameSettings.showDebugInfo) {
                        Lagometer.showLagometer(llllllllllllIlIlIIlIlIlIllIllIlI);
                    }
                }
                this.mc.mcProfiler.endSection();
            }
            if (this.mc.currentScreen != null) {
                GlStateManager.clear(256);
                try {
                    if (Reflector.ForgeHooksClient_drawScreen.exists()) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_drawScreen, new Object[] { this.mc.currentScreen, llllllllllllIlIlIIlIlIlIllIlIlll, llllllllllllIlIlIIlIlIlIllIlIllI, this.mc.func_193989_ak() });
                    }
                    else {
                        this.mc.currentScreen.drawScreen(llllllllllllIlIlIIlIlIlIllIlIlll, llllllllllllIlIlIIlIlIlIllIlIllI, this.mc.func_193989_ak());
                    }
                }
                catch (Throwable llllllllllllIlIlIIlIlIlIllIlIIIl) {
                    final CrashReport llllllllllllIlIlIIlIlIlIllIlIIII = CrashReport.makeCrashReport(llllllllllllIlIlIIlIlIlIllIlIIIl, "Rendering screen");
                    final CrashReportCategory llllllllllllIlIlIIlIlIlIllIIllll = llllllllllllIlIlIIlIlIlIllIlIIII.makeCategory("Screen render details");
                    llllllllllllIlIlIIlIlIlIllIIllll.setDetail("Screen name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return EntityRenderer.this.mc.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    llllllllllllIlIlIIlIlIlIllIIllll.setDetail("Mouse location", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", llllllllllllIlIlIIlIlIlIllIlIlll, llllllllllllIlIlIIlIlIlIllIlIllI, Mouse.getX(), Mouse.getY());
                        }
                    });
                    llllllllllllIlIlIIlIlIlIllIIllll.setDetail("Screen size", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", llllllllllllIlIlIIlIlIlIllIllIlI.getScaledWidth(), llllllllllllIlIlIIlIlIlIllIllIlI.getScaledHeight(), EntityRenderer.this.mc.displayWidth, EntityRenderer.this.mc.displayHeight, ScaledResolution.getScaleFactor());
                        }
                    });
                    throw new ReportedException(llllllllllllIlIlIIlIlIlIllIlIIII);
                }
            }
        }
        NotificationPublisher.publish();
        this.frameFinish();
        this.waitForServerThread();
        Lagometer.updateLagometer();
        if (this.mc.gameSettings.ofProfiler) {
            this.mc.gameSettings.showDebugProfilerChart = true;
        }
    }
    
    private void createWorldIcon() {
        if (this.mc.renderGlobal.getRenderedChunks() > 10 && this.mc.renderGlobal.hasNoChunkUpdates() && !this.mc.getIntegratedServer().isWorldIconSet()) {
            final BufferedImage llllllllllllIlIlIIlIlIlIlIllIlll = ScreenShotHelper.createScreenshot(this.mc.displayWidth, this.mc.displayHeight, this.mc.getFramebuffer());
            int llllllllllllIlIlIIlIlIlIlIllIllI = llllllllllllIlIlIIlIlIlIlIllIlll.getWidth();
            final int llllllllllllIlIlIIlIlIlIlIllIlIl = llllllllllllIlIlIIlIlIlIlIllIlll.getHeight();
            int llllllllllllIlIlIIlIlIlIlIllIlII = 0;
            int llllllllllllIlIlIIlIlIlIlIllIIll = 0;
            if (llllllllllllIlIlIIlIlIlIlIllIllI > llllllllllllIlIlIIlIlIlIlIllIlIl) {
                llllllllllllIlIlIIlIlIlIlIllIlII = (llllllllllllIlIlIIlIlIlIlIllIllI - llllllllllllIlIlIIlIlIlIlIllIlIl) / 2;
                llllllllllllIlIlIIlIlIlIlIllIllI = llllllllllllIlIlIIlIlIlIlIllIlIl;
            }
            else {
                llllllllllllIlIlIIlIlIlIlIllIIll = (llllllllllllIlIlIIlIlIlIlIllIlIl - llllllllllllIlIlIIlIlIlIlIllIllI) / 2;
            }
            try {
                final BufferedImage llllllllllllIlIlIIlIlIlIlIllIIlI = new BufferedImage(64, 64, 1);
                final Graphics llllllllllllIlIlIIlIlIlIlIllIIIl = llllllllllllIlIlIIlIlIlIlIllIIlI.createGraphics();
                llllllllllllIlIlIIlIlIlIlIllIIIl.drawImage(llllllllllllIlIlIIlIlIlIlIllIlll, 0, 0, 64, 64, llllllllllllIlIlIIlIlIlIlIllIlII, llllllllllllIlIlIIlIlIlIlIllIIll, llllllllllllIlIlIIlIlIlIlIllIlII + llllllllllllIlIlIIlIlIlIlIllIllI, llllllllllllIlIlIIlIlIlIlIllIIll + llllllllllllIlIlIIlIlIlIlIllIllI, null);
                llllllllllllIlIlIIlIlIlIlIllIIIl.dispose();
                ImageIO.write(llllllllllllIlIlIIlIlIlIlIllIIlI, "png", this.mc.getIntegratedServer().getWorldIconFile());
            }
            catch (IOException llllllllllllIlIlIIlIlIlIlIllIIII) {
                EntityRenderer.LOGGER.warn("Couldn't save auto screenshot", (Throwable)llllllllllllIlIlIIlIlIlIlIllIIII);
            }
        }
    }
    
    public void renderWorld(final float llllllllllllIlIlIIlIlIlIlIIIIlll, final long llllllllllllIlIlIIlIlIlIlIIIlIIl) {
        this.updateLightmap(llllllllllllIlIlIIlIlIlIlIIIIlll);
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.player);
        }
        this.getMouseOver(llllllllllllIlIlIIlIlIlIlIIIIlll);
        if (Config.isShaders()) {
            Shaders.beginRender(this.mc, llllllllllllIlIlIIlIlIlIlIIIIlll, llllllllllllIlIlIIlIlIlIlIIIlIIl);
        }
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.mc.mcProfiler.startSection("center");
        if (this.mc.gameSettings.anaglyph) {
            EntityRenderer.anaglyphField = 0;
            GlStateManager.colorMask(false, true, true, false);
            this.renderWorldPass(0, llllllllllllIlIlIIlIlIlIlIIIIlll, llllllllllllIlIlIIlIlIlIlIIIlIIl);
            EntityRenderer.anaglyphField = 1;
            GlStateManager.colorMask(true, false, false, false);
            this.renderWorldPass(1, llllllllllllIlIlIIlIlIlIlIIIIlll, llllllllllllIlIlIIlIlIlIlIIIlIIl);
            GlStateManager.colorMask(true, true, true, false);
        }
        else {
            this.renderWorldPass(2, llllllllllllIlIlIIlIlIlIlIIIIlll, llllllllllllIlIlIIlIlIlIlIIIlIIl);
        }
        this.mc.mcProfiler.endSection();
    }
    
    private void loadAllVisibleChunks(final Entity llllllllllllIlIlIIlIlIIIIllllIIl, final double llllllllllllIlIlIIlIlIIIlIIIIlII, final ICamera llllllllllllIlIlIIlIlIIIIlllIlll, final boolean llllllllllllIlIlIIlIlIIIIlllIllI) {
        final RenderGlobal llllllllllllIlIlIIlIlIIIlIIIIIIl = Config.getRenderGlobal();
        int llllllllllllIlIlIIlIlIIIlIIIIIII = llllllllllllIlIlIIlIlIIIlIIIIIIl.getCountLoadedChunks();
        final long llllllllllllIlIlIIlIlIIIIlllllll = System.currentTimeMillis();
        Config.dbg("Loading visible chunks");
        long llllllllllllIlIlIIlIlIIIIllllllI = System.currentTimeMillis() + 5000L;
        int llllllllllllIlIlIIlIlIIIIlllllIl = 0;
        boolean llllllllllllIlIlIIlIlIIIIlllllII = false;
        do {
            llllllllllllIlIlIIlIlIIIIlllllII = false;
            for (int llllllllllllIlIlIIlIlIIIIllllIll = 0; llllllllllllIlIlIIlIlIIIIllllIll < 100; ++llllllllllllIlIlIIlIlIIIIllllIll) {
                llllllllllllIlIlIIlIlIIIlIIIIIIl.displayListEntitiesDirty = true;
                llllllllllllIlIlIIlIlIIIlIIIIIIl.setupTerrain(llllllllllllIlIlIIlIlIIIIllllIIl, llllllllllllIlIlIIlIlIIIlIIIIlII, llllllllllllIlIlIIlIlIIIIlllIlll, this.frameCount++, llllllllllllIlIlIIlIlIIIIlllIllI);
                if (!llllllllllllIlIlIIlIlIIIlIIIIIIl.hasNoChunkUpdates()) {
                    llllllllllllIlIlIIlIlIIIIlllllII = true;
                }
                llllllllllllIlIlIIlIlIIIIlllllIl += llllllllllllIlIlIIlIlIIIlIIIIIIl.getCountChunksToUpdate();
                llllllllllllIlIlIIlIlIIIlIIIIIIl.updateChunks(System.nanoTime() + 1000000000L);
                llllllllllllIlIlIIlIlIIIIlllllIl -= llllllllllllIlIlIIlIlIIIlIIIIIIl.getCountChunksToUpdate();
            }
            if (llllllllllllIlIlIIlIlIIIlIIIIIIl.getCountLoadedChunks() != llllllllllllIlIlIIlIlIIIlIIIIIII) {
                llllllllllllIlIlIIlIlIIIIlllllII = true;
                llllllllllllIlIlIIlIlIIIlIIIIIII = llllllllllllIlIlIIlIlIIIlIIIIIIl.getCountLoadedChunks();
            }
            if (System.currentTimeMillis() > llllllllllllIlIlIIlIlIIIIllllllI) {
                Config.log("Chunks loaded: " + llllllllllllIlIlIIlIlIIIIlllllIl);
                llllllllllllIlIlIIlIlIIIIllllllI = System.currentTimeMillis() + 5000L;
            }
        } while (llllllllllllIlIlIIlIlIIIIlllllII);
        Config.log("Chunks loaded: " + llllllllllllIlIlIIlIlIIIIlllllIl);
        Config.log("Finished loading visible chunks");
        RenderChunk.renderChunksUpdated = 0;
    }
    
    public void loadEntityShader(@Nullable final Entity llllllllllllIlIlIIlIllIIlIIIIlII) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.theShaderGroup = null;
            if (llllllllllllIlIlIIlIllIIlIIIIlII instanceof EntityCreeper) {
                this.loadShader(new ResourceLocation("shaders/post/creeper.json"));
            }
            else if (llllllllllllIlIlIIlIllIIlIIIIlII instanceof EntitySpider) {
                this.loadShader(new ResourceLocation("shaders/post/spider.json"));
            }
            else if (llllllllllllIlIlIIlIllIIlIIIIlII instanceof EntityEnderman) {
                this.loadShader(new ResourceLocation("shaders/post/invert.json"));
            }
            else if (Reflector.ForgeHooksClient_loadEntityShader.exists()) {
                Reflector.call(Reflector.ForgeHooksClient_loadEntityShader, new Object[] { llllllllllllIlIlIIlIllIIlIIIIlII, this });
            }
        }
    }
    
    public void func_190565_a(final ItemStack llllllllllllIlIlIIlIlIIIIlIIIIlI) {
        this.field_190566_ab = llllllllllllIlIlIIlIlIIIIlIIIIlI;
        this.field_190567_ac = 40;
        this.field_190568_ad = this.random.nextFloat() * 2.0f - 1.0f;
        this.field_190569_ae = this.random.nextFloat() * 2.0f - 1.0f;
    }
    
    private boolean isDrawBlockOutline() {
        if (!this.drawBlockOutline) {
            return false;
        }
        final Entity llllllllllllIlIlIIlIlIlIlIIllIll = this.mc.getRenderViewEntity();
        boolean llllllllllllIlIlIIlIlIlIlIIllIlI = llllllllllllIlIlIIlIlIlIlIIllIll instanceof EntityPlayer && !this.mc.gameSettings.hideGUI;
        if (llllllllllllIlIlIIlIlIlIlIIllIlI && !((EntityPlayer)llllllllllllIlIlIIlIlIlIlIIllIll).capabilities.allowEdit) {
            final ItemStack llllllllllllIlIlIIlIlIlIlIIllIIl = ((EntityPlayer)llllllllllllIlIlIIlIlIlIlIIllIll).getHeldItemMainhand();
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos llllllllllllIlIlIIlIlIlIlIIllIII = this.mc.objectMouseOver.getBlockPos();
                final IBlockState llllllllllllIlIlIIlIlIlIlIIlIlll = this.mc.world.getBlockState(llllllllllllIlIlIIlIlIlIlIIllIII);
                final Block llllllllllllIlIlIIlIlIlIlIIlIllI = llllllllllllIlIlIIlIlIlIlIIlIlll.getBlock();
                if (this.mc.playerController.getCurrentGameType() == GameType.SPECTATOR) {
                    llllllllllllIlIlIIlIlIlIlIIllIlI = (ReflectorForge.blockHasTileEntity(llllllllllllIlIlIIlIlIlIlIIlIlll) && this.mc.world.getTileEntity(llllllllllllIlIlIIlIlIlIlIIllIII) instanceof IInventory);
                }
                else {
                    llllllllllllIlIlIIlIlIlIlIIllIlI = (!llllllllllllIlIlIIlIlIlIlIIllIIl.func_190926_b() && (llllllllllllIlIlIIlIlIlIlIIllIIl.canDestroy(llllllllllllIlIlIIlIlIlIlIIlIllI) || llllllllllllIlIlIIlIlIlIlIIllIIl.canPlaceOn(llllllllllllIlIlIIlIlIlIlIIlIllI)));
                }
            }
        }
        return llllllllllllIlIlIIlIlIlIlIIllIlI;
    }
    
    public float getNightVisionBrightness(final EntityLivingBase llllllllllllIlIlIIlIlIlIllllIlIl, final float llllllllllllIlIlIIlIlIlIllllIlll) {
        final int llllllllllllIlIlIIlIlIlIllllIllI = llllllllllllIlIlIIlIlIlIllllIlIl.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration();
        return (llllllllllllIlIlIIlIlIlIllllIllI > 200) ? 1.0f : (0.7f + MathHelper.sin((llllllllllllIlIlIIlIlIlIllllIllI - llllllllllllIlIlIIlIlIlIllllIlll) * 3.1415927f * 0.2f) * 0.3f);
    }
    
    private void updateLightmap(final float llllllllllllIlIlIIlIlIllIIllIIll) {
        if (this.lightmapUpdateNeeded) {
            this.mc.mcProfiler.startSection("lightTex");
            final World llllllllllllIlIlIIlIlIllIIllIIlI = this.mc.world;
            if (llllllllllllIlIlIIlIlIllIIllIIlI != null) {
                if (Config.isCustomColors() && CustomColors.updateLightmap(llllllllllllIlIlIIlIlIllIIllIIlI, this.torchFlickerX, this.lightmapColors, this.mc.player.isPotionActive(MobEffects.NIGHT_VISION))) {
                    this.lightmapTexture.updateDynamicTexture();
                    this.lightmapUpdateNeeded = false;
                    this.mc.mcProfiler.endSection();
                    return;
                }
                final float llllllllllllIlIlIIlIlIllIIllIIIl = llllllllllllIlIlIIlIlIllIIllIIlI.getSunBrightness(1.0f);
                final float llllllllllllIlIlIIlIlIllIIllIIII = llllllllllllIlIlIIlIlIllIIllIIIl * 0.95f + 0.05f;
                if (Main.featureDirector.getFeatureByClass(NightMode.class).isToggled()) {
                    final int llllllllllllIlIlIIlIlIllIIlIllll = NightMode.worldColor.getColorValue();
                    final int llllllllllllIlIlIIlIlIllIIlIlllI = llllllllllllIlIlIIlIlIllIIlIllll >> 16 & 0xFF;
                    final int llllllllllllIlIlIIlIlIllIIlIllIl = llllllllllllIlIlIIlIlIllIIlIllll >> 8 & 0xFF;
                    final int llllllllllllIlIlIIlIlIllIIlIllII = llllllllllllIlIlIIlIlIllIIlIllll & 0xFF;
                    final int llllllllllllIlIlIIlIlIllIIlIlIll = llllllllllllIlIlIIlIlIllIIlIllll >> 24 & 0xFF;
                    for (int llllllllllllIlIlIIlIlIllIIlIlIlI = 0; llllllllllllIlIlIIlIlIllIIlIlIlI < 256; ++llllllllllllIlIlIIlIlIllIIlIlIlI) {
                        this.lightmapColors[llllllllllllIlIlIIlIlIllIIlIlIlI] = (llllllllllllIlIlIIlIlIllIIlIlIll << 24 | llllllllllllIlIlIIlIlIllIIlIlllI << 16 | llllllllllllIlIlIIlIlIllIIlIllIl << 8 | llllllllllllIlIlIIlIlIllIIlIllII);
                        GlStateManager.resetColor();
                    }
                }
                else {
                    for (int llllllllllllIlIlIIlIlIllIIlIlIIl = 0; llllllllllllIlIlIIlIlIllIIlIlIIl < 256; ++llllllllllllIlIlIIlIlIllIIlIlIIl) {
                        float llllllllllllIlIlIIlIlIllIIlIlIII = llllllllllllIlIlIIlIlIllIIllIIlI.provider.getLightBrightnessTable()[llllllllllllIlIlIIlIlIllIIlIlIIl / 16] * llllllllllllIlIlIIlIlIllIIllIIII;
                        final float llllllllllllIlIlIIlIlIllIIlIIlll = llllllllllllIlIlIIlIlIllIIllIIlI.provider.getLightBrightnessTable()[llllllllllllIlIlIIlIlIllIIlIlIIl % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                        if (llllllllllllIlIlIIlIlIllIIllIIlI.getLastLightningBolt() > 0) {
                            llllllllllllIlIlIIlIlIllIIlIlIII = llllllllllllIlIlIIlIlIllIIllIIlI.provider.getLightBrightnessTable()[llllllllllllIlIlIIlIlIllIIlIlIIl / 16];
                        }
                        final float llllllllllllIlIlIIlIlIllIIlIIllI = llllllllllllIlIlIIlIlIllIIlIlIII * (llllllllllllIlIlIIlIlIllIIllIIIl * 0.65f + 0.35f);
                        final float llllllllllllIlIlIIlIlIllIIlIIlIl = llllllllllllIlIlIIlIlIllIIlIlIII * (llllllllllllIlIlIIlIlIllIIllIIIl * 0.65f + 0.35f);
                        final float llllllllllllIlIlIIlIlIllIIlIIlII = llllllllllllIlIlIIlIlIllIIlIIlll * ((llllllllllllIlIlIIlIlIllIIlIIlll * 0.6f + 0.4f) * 0.6f + 0.4f);
                        final float llllllllllllIlIlIIlIlIllIIlIIIll = llllllllllllIlIlIIlIlIllIIlIIlll * (llllllllllllIlIlIIlIlIllIIlIIlll * llllllllllllIlIlIIlIlIllIIlIIlll * 0.6f + 0.4f);
                        float llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIllI + llllllllllllIlIlIIlIlIllIIlIIlll;
                        float llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIlIl + llllllllllllIlIlIIlIlIllIIlIIlII;
                        float llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIlIII + llllllllllllIlIlIIlIlIllIIlIIIll;
                        llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIIlI * 0.96f + 0.03f;
                        llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIIIl * 0.96f + 0.03f;
                        llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIIIII * 0.96f + 0.03f;
                        if (this.bossColorModifier > 0.0f) {
                            final float llllllllllllIlIlIIlIlIllIIIlllll = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * llllllllllllIlIlIIlIlIllIIllIIll;
                            llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIIlI * (1.0f - llllllllllllIlIlIIlIlIllIIIlllll) + llllllllllllIlIlIIlIlIllIIlIIIlI * 0.7f * llllllllllllIlIlIIlIlIllIIIlllll;
                            llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIIIl * (1.0f - llllllllllllIlIlIIlIlIllIIIlllll) + llllllllllllIlIlIIlIlIllIIlIIIIl * 0.6f * llllllllllllIlIlIIlIlIllIIIlllll;
                            llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIIIII * (1.0f - llllllllllllIlIlIIlIlIllIIIlllll) + llllllllllllIlIlIIlIlIllIIlIIIII * 0.6f * llllllllllllIlIlIIlIlIllIIIlllll;
                        }
                        if (llllllllllllIlIlIIlIlIllIIllIIlI.provider.getDimensionType().getId() == 1) {
                            llllllllllllIlIlIIlIlIllIIlIIIlI = 0.22f + llllllllllllIlIlIIlIlIllIIlIIlll * 0.75f;
                            llllllllllllIlIlIIlIlIllIIlIIIIl = 0.28f + llllllllllllIlIlIIlIlIllIIlIIlII * 0.75f;
                            llllllllllllIlIlIIlIlIllIIlIIIII = 0.25f + llllllllllllIlIlIIlIlIllIIlIIIll * 0.75f;
                        }
                        if (Reflector.ForgeWorldProvider_getLightmapColors.exists()) {
                            final float[] llllllllllllIlIlIIlIlIllIIIllllI = { llllllllllllIlIlIIlIlIllIIlIIIlI, llllllllllllIlIlIIlIlIllIIlIIIIl, llllllllllllIlIlIIlIlIllIIlIIIII };
                            Reflector.call((Object)llllllllllllIlIlIIlIlIllIIllIIlI.provider, Reflector.ForgeWorldProvider_getLightmapColors, new Object[] { llllllllllllIlIlIIlIlIllIIllIIll, llllllllllllIlIlIIlIlIllIIllIIIl, llllllllllllIlIlIIlIlIllIIlIlIII, llllllllllllIlIlIIlIlIllIIlIIlll, llllllllllllIlIlIIlIlIllIIIllllI });
                            llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIIllllI[0];
                            llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIIllllI[1];
                            llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIIllllI[2];
                        }
                        llllllllllllIlIlIIlIlIllIIlIIIlI = MathHelper.clamp(llllllllllllIlIlIIlIlIllIIlIIIlI, 0.0f, 1.0f);
                        llllllllllllIlIlIIlIlIllIIlIIIIl = MathHelper.clamp(llllllllllllIlIlIIlIlIllIIlIIIIl, 0.0f, 1.0f);
                        llllllllllllIlIlIIlIlIllIIlIIIII = MathHelper.clamp(llllllllllllIlIlIIlIlIllIIlIIIII, 0.0f, 1.0f);
                        if (this.mc.player.isPotionActive(MobEffects.NIGHT_VISION)) {
                            final float llllllllllllIlIlIIlIlIllIIIlllIl = this.getNightVisionBrightness(this.mc.player, llllllllllllIlIlIIlIlIllIIllIIll);
                            float llllllllllllIlIlIIlIlIllIIIlllII = 1.0f / llllllllllllIlIlIIlIlIllIIlIIIlI;
                            if (llllllllllllIlIlIIlIlIllIIIlllII > 1.0f / llllllllllllIlIlIIlIlIllIIlIIIIl) {
                                llllllllllllIlIlIIlIlIllIIIlllII = 1.0f / llllllllllllIlIlIIlIlIllIIlIIIIl;
                            }
                            if (llllllllllllIlIlIIlIlIllIIIlllII > 1.0f / llllllllllllIlIlIIlIlIllIIlIIIII) {
                                llllllllllllIlIlIIlIlIllIIIlllII = 1.0f / llllllllllllIlIlIIlIlIllIIlIIIII;
                            }
                            llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIIlI * (1.0f - llllllllllllIlIlIIlIlIllIIIlllIl) + llllllllllllIlIlIIlIlIllIIlIIIlI * llllllllllllIlIlIIlIlIllIIIlllII * llllllllllllIlIlIIlIlIllIIIlllIl;
                            llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIIIl * (1.0f - llllllllllllIlIlIIlIlIllIIIlllIl) + llllllllllllIlIlIIlIlIllIIlIIIIl * llllllllllllIlIlIIlIlIllIIIlllII * llllllllllllIlIlIIlIlIllIIIlllIl;
                            llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIIIII * (1.0f - llllllllllllIlIlIIlIlIllIIIlllIl) + llllllllllllIlIlIIlIlIllIIlIIIII * llllllllllllIlIlIIlIlIllIIIlllII * llllllllllllIlIlIIlIlIllIIIlllIl;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIlI > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIlI = 1.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIIl > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIIl = 1.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIII > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIII = 1.0f;
                        }
                        final float llllllllllllIlIlIIlIlIllIIIllIll = this.mc.gameSettings.gammaSetting;
                        float llllllllllllIlIlIIlIlIllIIIllIlI = 1.0f - llllllllllllIlIlIIlIlIllIIlIIIlI;
                        float llllllllllllIlIlIIlIlIllIIIllIIl = 1.0f - llllllllllllIlIlIIlIlIllIIlIIIIl;
                        float llllllllllllIlIlIIlIlIllIIIllIII = 1.0f - llllllllllllIlIlIIlIlIllIIlIIIII;
                        llllllllllllIlIlIIlIlIllIIIllIlI = 1.0f - llllllllllllIlIlIIlIlIllIIIllIlI * llllllllllllIlIlIIlIlIllIIIllIlI * llllllllllllIlIlIIlIlIllIIIllIlI * llllllllllllIlIlIIlIlIllIIIllIlI;
                        llllllllllllIlIlIIlIlIllIIIllIIl = 1.0f - llllllllllllIlIlIIlIlIllIIIllIIl * llllllllllllIlIlIIlIlIllIIIllIIl * llllllllllllIlIlIIlIlIllIIIllIIl * llllllllllllIlIlIIlIlIllIIIllIIl;
                        llllllllllllIlIlIIlIlIllIIIllIII = 1.0f - llllllllllllIlIlIIlIlIllIIIllIII * llllllllllllIlIlIIlIlIllIIIllIII * llllllllllllIlIlIIlIlIllIIIllIII * llllllllllllIlIlIIlIlIllIIIllIII;
                        llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIIlI * (1.0f - llllllllllllIlIlIIlIlIllIIIllIll) + llllllllllllIlIlIIlIlIllIIIllIlI * llllllllllllIlIlIIlIlIllIIIllIll;
                        llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIIIl * (1.0f - llllllllllllIlIlIIlIlIllIIIllIll) + llllllllllllIlIlIIlIlIllIIIllIIl * llllllllllllIlIlIIlIlIllIIIllIll;
                        llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIIIII * (1.0f - llllllllllllIlIlIIlIlIllIIIllIll) + llllllllllllIlIlIIlIlIllIIIllIII * llllllllllllIlIlIIlIlIllIIIllIll;
                        llllllllllllIlIlIIlIlIllIIlIIIlI = llllllllllllIlIlIIlIlIllIIlIIIlI * 0.96f + 0.03f;
                        llllllllllllIlIlIIlIlIllIIlIIIIl = llllllllllllIlIlIIlIlIllIIlIIIIl * 0.96f + 0.03f;
                        llllllllllllIlIlIIlIlIllIIlIIIII = llllllllllllIlIlIIlIlIllIIlIIIII * 0.96f + 0.03f;
                        if (llllllllllllIlIlIIlIlIllIIlIIIlI > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIlI = 1.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIIl > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIIl = 1.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIII > 1.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIII = 1.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIlI < 0.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIlI = 0.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIIl < 0.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIIl = 0.0f;
                        }
                        if (llllllllllllIlIlIIlIlIllIIlIIIII < 0.0f) {
                            llllllllllllIlIlIIlIlIllIIlIIIII = 0.0f;
                        }
                        final int llllllllllllIlIlIIlIlIllIIIlIlll = 255;
                        final int llllllllllllIlIlIIlIlIllIIIlIllI = (int)(llllllllllllIlIlIIlIlIllIIlIIIlI * 255.0f);
                        final int llllllllllllIlIlIIlIlIllIIIlIlIl = (int)(llllllllllllIlIlIIlIlIllIIlIIIIl * 255.0f);
                        final int llllllllllllIlIlIIlIlIllIIIlIlII = (int)(llllllllllllIlIlIIlIlIllIIlIIIII * 255.0f);
                        this.lightmapColors[llllllllllllIlIlIIlIlIllIIlIlIIl] = (0xFF000000 | llllllllllllIlIlIIlIlIllIIIlIllI << 16 | llllllllllllIlIlIIlIlIllIIIlIlIl << 8 | llllllllllllIlIlIIlIlIllIIIlIlII);
                    }
                }
                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }
    
    public void getMouseOver(final float llllllllllllIlIlIIlIllIIIIlIlIlI) {
        final Entity llllllllllllIlIlIIlIllIIIIlllIll = this.mc.getRenderViewEntity();
        if (llllllllllllIlIlIIlIllIIIIlllIll != null && this.mc.world != null) {
            this.mc.mcProfiler.startSection("pick");
            this.mc.pointedEntity = null;
            double llllllllllllIlIlIIlIllIIIIlllIlI = this.mc.playerController.getBlockReachDistance();
            this.mc.objectMouseOver = llllllllllllIlIlIIlIllIIIIlllIll.rayTrace(llllllllllllIlIlIIlIllIIIIlllIlI, llllllllllllIlIlIIlIllIIIIlIlIlI);
            final Vec3d llllllllllllIlIlIIlIllIIIIlllIIl = llllllllllllIlIlIIlIllIIIIlllIll.getPositionEyes(llllllllllllIlIlIIlIllIIIIlIlIlI);
            boolean llllllllllllIlIlIIlIllIIIIlllIII = false;
            double llllllllllllIlIlIIlIllIIIIllIlll = llllllllllllIlIlIIlIllIIIIlllIlI;
            if (this.mc.playerController.extendedReach()) {
                llllllllllllIlIlIIlIllIIIIllIlll = (llllllllllllIlIlIIlIllIIIIlllIlI = 6.0);
            }
            else if (llllllllllllIlIlIIlIllIIIIlllIlI > 3.0) {
                llllllllllllIlIlIIlIllIIIIlllIII = true;
            }
            if (this.mc.objectMouseOver != null) {
                llllllllllllIlIlIIlIllIIIIllIlll = this.mc.objectMouseOver.hitVec.distanceTo(llllllllllllIlIlIIlIllIIIIlllIIl);
            }
            final Vec3d llllllllllllIlIlIIlIllIIIIllIllI = llllllllllllIlIlIIlIllIIIIlllIll.getLook(1.0f);
            final Vec3d llllllllllllIlIlIIlIllIIIIllIlIl = llllllllllllIlIlIIlIllIIIIlllIIl.addVector(llllllllllllIlIlIIlIllIIIIllIllI.xCoord * llllllllllllIlIlIIlIllIIIIlllIlI, llllllllllllIlIlIIlIllIIIIllIllI.yCoord * llllllllllllIlIlIIlIllIIIIlllIlI, llllllllllllIlIlIIlIllIIIIllIllI.zCoord * llllllllllllIlIlIIlIllIIIIlllIlI);
            this.pointedEntity = null;
            Vec3d llllllllllllIlIlIIlIllIIIIllIlII = null;
            final List<Entity> llllllllllllIlIlIIlIllIIIIllIIll = this.mc.world.getEntitiesInAABBexcluding(llllllllllllIlIlIIlIllIIIIlllIll, llllllllllllIlIlIIlIllIIIIlllIll.getEntityBoundingBox().addCoord(llllllllllllIlIlIIlIllIIIIllIllI.xCoord * llllllllllllIlIlIIlIllIIIIlllIlI, llllllllllllIlIlIIlIllIIIIllIllI.yCoord * llllllllllllIlIlIIlIllIIIIlllIlI, llllllllllllIlIlIIlIllIIIIllIllI.zCoord * llllllllllllIlIlIIlIllIIIIlllIlI).expand(1.0, 1.0, 1.0), (Predicate<? super Entity>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity lllllllllllIIlIIlIIIIlIlllIlIlIl) {
                    return lllllllllllIIlIIlIIIIlIlllIlIlIl != null && lllllllllllIIlIIlIIIIlIlllIlIlIl.canBeCollidedWith();
                }
            }));
            double llllllllllllIlIlIIlIllIIIIllIIlI = llllllllllllIlIlIIlIllIIIIllIlll;
            for (final Entity llllllllllllIlIlIIlIllIIIIllIIIl : llllllllllllIlIlIIlIllIIIIllIIll) {
                if (llllllllllllIlIlIIlIllIIIIllIIIl instanceof EntityArmorStand && Main.featureDirector.getFeatureByClass(NoInteract.class).isToggled() && NoInteract.armorStands.getBoolValue()) {
                    return;
                }
                final AxisAlignedBB llllllllllllIlIlIIlIllIIIIllIIII = llllllllllllIlIlIIlIllIIIIllIIIl.getEntityBoundingBox().expandXyz(llllllllllllIlIlIIlIllIIIIllIIIl.getCollisionBorderSize());
                final RayTraceResult llllllllllllIlIlIIlIllIIIIlIllll = llllllllllllIlIlIIlIllIIIIllIIII.calculateIntercept(llllllllllllIlIlIIlIllIIIIlllIIl, llllllllllllIlIlIIlIllIIIIllIlIl);
                if (llllllllllllIlIlIIlIllIIIIllIIII.isVecInside(llllllllllllIlIlIIlIllIIIIlllIIl)) {
                    if (llllllllllllIlIlIIlIllIIIIllIIlI < 0.0) {
                        continue;
                    }
                    this.pointedEntity = llllllllllllIlIlIIlIllIIIIllIIIl;
                    llllllllllllIlIlIIlIllIIIIllIlII = ((llllllllllllIlIlIIlIllIIIIlIllll == null) ? llllllllllllIlIlIIlIllIIIIlllIIl : llllllllllllIlIlIIlIllIIIIlIllll.hitVec);
                    llllllllllllIlIlIIlIllIIIIllIIlI = 0.0;
                }
                else {
                    if (llllllllllllIlIlIIlIllIIIIlIllll == null) {
                        continue;
                    }
                    final double llllllllllllIlIlIIlIllIIIIlIlllI = llllllllllllIlIlIIlIllIIIIlllIIl.distanceTo(llllllllllllIlIlIIlIllIIIIlIllll.hitVec);
                    if (llllllllllllIlIlIIlIllIIIIlIlllI >= llllllllllllIlIlIIlIllIIIIllIIlI && llllllllllllIlIlIIlIllIIIIllIIlI != 0.0) {
                        continue;
                    }
                    boolean llllllllllllIlIlIIlIllIIIIlIllIl = false;
                    if (Reflector.ForgeEntity_canRiderInteract.exists()) {
                        llllllllllllIlIlIIlIllIIIIlIllIl = Reflector.callBoolean((Object)llllllllllllIlIlIIlIllIIIIllIIIl, Reflector.ForgeEntity_canRiderInteract, new Object[0]);
                    }
                    if (!llllllllllllIlIlIIlIllIIIIlIllIl && llllllllllllIlIlIIlIllIIIIllIIIl.getLowestRidingEntity() == llllllllllllIlIlIIlIllIIIIlllIll.getLowestRidingEntity()) {
                        if (llllllllllllIlIlIIlIllIIIIllIIlI != 0.0) {
                            continue;
                        }
                        this.pointedEntity = llllllllllllIlIlIIlIllIIIIllIIIl;
                        llllllllllllIlIlIIlIllIIIIllIlII = llllllllllllIlIlIIlIllIIIIlIllll.hitVec;
                    }
                    else {
                        this.pointedEntity = llllllllllllIlIlIIlIllIIIIllIIIl;
                        llllllllllllIlIlIIlIllIIIIllIlII = llllllllllllIlIlIIlIllIIIIlIllll.hitVec;
                        llllllllllllIlIlIIlIllIIIIllIIlI = llllllllllllIlIlIIlIllIIIIlIlllI;
                    }
                }
            }
            final float llllllllllllIlIlIIlIllIIIIlIllII = Main.featureDirector.getFeatureByClass(Reach.class).isToggled() ? Reach.reachValue.getNumberValue() : 3.0f;
            if (this.pointedEntity != null && llllllllllllIlIlIIlIllIIIIlllIII && llllllllllllIlIlIIlIllIIIIlllIIl.distanceTo(llllllllllllIlIlIIlIllIIIIllIlII) > llllllllllllIlIlIIlIllIIIIlIllII) {
                this.pointedEntity = null;
                this.mc.objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, llllllllllllIlIlIIlIllIIIIllIlII, null, new BlockPos(llllllllllllIlIlIIlIllIIIIllIlII));
            }
            if (this.pointedEntity != null && (llllllllllllIlIlIIlIllIIIIllIIlI < llllllllllllIlIlIIlIllIIIIllIlll || this.mc.objectMouseOver == null)) {
                this.mc.objectMouseOver = new RayTraceResult(this.pointedEntity, llllllllllllIlIlIIlIllIIIIllIlII);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    this.mc.pointedEntity = this.pointedEntity;
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void renderStreamIndicator(final float llllllllllllIlIlIIlIlIlIlIlIIlIl) {
        this.setupOverlayRendering();
    }
    
    public void func_191514_d(final boolean llllllllllllIlIlIIlIlIIlIIIIIlll) {
        if (llllllllllllIlIlIIlIlIIlIIIIIlll) {
            GlStateManager.glFog(2918, this.setFogColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        }
        else {
            GlStateManager.glFog(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0f));
        }
    }
    
    protected void renderRainSnow(final float llllllllllllIlIlIIlIlIIllIlIIlIl) {
        final boolean llllllllllllIlIlIIlIlIIlllIllIIl = Main.featureDirector.getFeatureByClass(Weather.class).isToggled();
        if (Reflector.ForgeWorldProvider_getWeatherRenderer.exists()) {
            final WorldProvider llllllllllllIlIlIIlIlIIlllIllIII = this.mc.world.provider;
            final Object llllllllllllIlIlIIlIlIIlllIlIlll = Reflector.call((Object)llllllllllllIlIlIIlIlIIlllIllIII, Reflector.ForgeWorldProvider_getWeatherRenderer, new Object[0]);
            if (llllllllllllIlIlIIlIlIIlllIlIlll != null) {
                Reflector.callVoid(llllllllllllIlIlIIlIlIIlllIlIlll, Reflector.IRenderHandler_render, new Object[] { llllllllllllIlIlIIlIlIIllIlIIlIl, this.mc.world, this.mc });
                return;
            }
        }
        final float llllllllllllIlIlIIlIlIIlllIlIllI = llllllllllllIlIlIIlIlIIlllIllIIl ? 1.0f : this.mc.world.getRainStrength(llllllllllllIlIlIIlIlIIllIlIIlIl);
        if (llllllllllllIlIlIIlIlIIlllIlIllI > 0.0f) {
            if (Config.isRainOff()) {
                return;
            }
            this.enableLightmap();
            final Entity llllllllllllIlIlIIlIlIIlllIlIlIl = this.mc.getRenderViewEntity();
            final World llllllllllllIlIlIIlIlIIlllIlIlII = this.mc.world;
            final int llllllllllllIlIlIIlIlIIlllIlIIll = MathHelper.floor(llllllllllllIlIlIIlIlIIlllIlIlIl.posX);
            final int llllllllllllIlIlIIlIlIIlllIlIIlI = MathHelper.floor(llllllllllllIlIlIIlIlIIlllIlIlIl.posY);
            final int llllllllllllIlIlIIlIlIIlllIlIIIl = MathHelper.floor(llllllllllllIlIlIIlIlIIlllIlIlIl.posZ);
            final Tessellator llllllllllllIlIlIIlIlIIlllIlIIII = Tessellator.getInstance();
            final BufferBuilder llllllllllllIlIlIIlIlIIlllIIllll = llllllllllllIlIlIIlIlIIlllIlIIII.getBuffer();
            GlStateManager.disableCull();
            GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.alphaFunc(516, 0.1f);
            final double llllllllllllIlIlIIlIlIIlllIIlllI = llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosX + (llllllllllllIlIlIIlIlIIlllIlIlIl.posX - llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosX) * llllllllllllIlIlIIlIlIIllIlIIlIl;
            final double llllllllllllIlIlIIlIlIIlllIIllIl = llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosY + (llllllllllllIlIlIIlIlIIlllIlIlIl.posY - llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosY) * llllllllllllIlIlIIlIlIIllIlIIlIl;
            final double llllllllllllIlIlIIlIlIIlllIIllII = llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosZ + (llllllllllllIlIlIIlIlIIlllIlIlIl.posZ - llllllllllllIlIlIIlIlIIlllIlIlIl.lastTickPosZ) * llllllllllllIlIlIIlIlIIllIlIIlIl;
            final int llllllllllllIlIlIIlIlIIlllIIlIll = MathHelper.floor(llllllllllllIlIlIIlIlIIlllIIllIl);
            int llllllllllllIlIlIIlIlIIlllIIlIlI = 5;
            if (Config.isRainFancy()) {
                llllllllllllIlIlIIlIlIIlllIIlIlI = 10;
            }
            int llllllllllllIlIlIIlIlIIlllIIlIIl = -1;
            final float llllllllllllIlIlIIlIlIIlllIIlIII = this.rendererUpdateCount + llllllllllllIlIlIIlIlIIllIlIIlIl;
            llllllllllllIlIlIIlIlIIlllIIllll.setTranslation(-llllllllllllIlIlIIlIlIIlllIIlllI, -llllllllllllIlIlIIlIlIIlllIIllIl, -llllllllllllIlIlIIlIlIIlllIIllII);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final BlockPos.MutableBlockPos llllllllllllIlIlIIlIlIIlllIIIlll = new BlockPos.MutableBlockPos();
            for (int llllllllllllIlIlIIlIlIIlllIIIllI = llllllllllllIlIlIIlIlIIlllIlIIIl - llllllllllllIlIlIIlIlIIlllIIlIlI; llllllllllllIlIlIIlIlIIlllIIIllI <= llllllllllllIlIlIIlIlIIlllIlIIIl + llllllllllllIlIlIIlIlIIlllIIlIlI; ++llllllllllllIlIlIIlIlIIlllIIIllI) {
                for (int llllllllllllIlIlIIlIlIIlllIIIlIl = llllllllllllIlIlIIlIlIIlllIlIIll - llllllllllllIlIlIIlIlIIlllIIlIlI; llllllllllllIlIlIIlIlIIlllIIIlIl <= llllllllllllIlIlIIlIlIIlllIlIIll + llllllllllllIlIlIIlIlIIlllIIlIlI; ++llllllllllllIlIlIIlIlIIlllIIIlIl) {
                    final int llllllllllllIlIlIIlIlIIlllIIIlII = (llllllllllllIlIlIIlIlIIlllIIIllI - llllllllllllIlIlIIlIlIIlllIlIIIl + 16) * 32 + llllllllllllIlIlIIlIlIIlllIIIlIl - llllllllllllIlIlIIlIlIIlllIlIIll + 16;
                    final double llllllllllllIlIlIIlIlIIlllIIIIll = this.rainXCoords[llllllllllllIlIlIIlIlIIlllIIIlII] * 0.5;
                    final double llllllllllllIlIlIIlIlIIlllIIIIlI = this.rainYCoords[llllllllllllIlIlIIlIlIIlllIIIlII] * 0.5;
                    llllllllllllIlIlIIlIlIIlllIIIlll.setPos(llllllllllllIlIlIIlIlIIlllIIIlIl, 0, llllllllllllIlIlIIlIlIIlllIIIllI);
                    final Biome llllllllllllIlIlIIlIlIIlllIIIIIl = llllllllllllIlIlIIlIlIIlllIlIlII.getBiome(llllllllllllIlIlIIlIlIIlllIIIlll);
                    if (llllllllllllIlIlIIlIlIIlllIIIIIl.canRain() || llllllllllllIlIlIIlIlIIlllIIIIIl.getEnableSnow() || llllllllllllIlIlIIlIlIIlllIllIIl) {
                        final int llllllllllllIlIlIIlIlIIlllIIIIII = llllllllllllIlIlIIlIlIIlllIlIlII.getPrecipitationHeight(llllllllllllIlIlIIlIlIIlllIIIlll).getY();
                        int llllllllllllIlIlIIlIlIIllIllllll = llllllllllllIlIlIIlIlIIlllIlIIlI - llllllllllllIlIlIIlIlIIlllIIlIlI;
                        int llllllllllllIlIlIIlIlIIllIlllllI = llllllllllllIlIlIIlIlIIlllIlIIlI + llllllllllllIlIlIIlIlIIlllIIlIlI;
                        if (llllllllllllIlIlIIlIlIIllIllllll < llllllllllllIlIlIIlIlIIlllIIIIII) {
                            llllllllllllIlIlIIlIlIIllIllllll = llllllllllllIlIlIIlIlIIlllIIIIII;
                        }
                        if (llllllllllllIlIlIIlIlIIllIlllllI < llllllllllllIlIlIIlIlIIlllIIIIII) {
                            llllllllllllIlIlIIlIlIIllIlllllI = llllllllllllIlIlIIlIlIIlllIIIIII;
                        }
                        int llllllllllllIlIlIIlIlIIllIllllIl;
                        if ((llllllllllllIlIlIIlIlIIllIllllIl = llllllllllllIlIlIIlIlIIlllIIIIII) < llllllllllllIlIlIIlIlIIlllIIlIll) {
                            llllllllllllIlIlIIlIlIIllIllllIl = llllllllllllIlIlIIlIlIIlllIIlIll;
                        }
                        if (llllllllllllIlIlIIlIlIIllIllllll != llllllllllllIlIlIIlIlIIllIlllllI) {
                            this.random.setSeed(llllllllllllIlIlIIlIlIIlllIIIlIl * llllllllllllIlIlIIlIlIIlllIIIlIl * 3121 + llllllllllllIlIlIIlIlIIlllIIIlIl * 45238971 ^ llllllllllllIlIlIIlIlIIlllIIIllI * llllllllllllIlIlIIlIlIIlllIIIllI * 418711 + llllllllllllIlIlIIlIlIIlllIIIllI * 13761);
                            llllllllllllIlIlIIlIlIIlllIIIlll.setPos(llllllllllllIlIlIIlIlIIlllIIIlIl, llllllllllllIlIlIIlIlIIllIllllll, llllllllllllIlIlIIlIlIIlllIIIllI);
                            final float llllllllllllIlIlIIlIlIIllIllllII = llllllllllllIlIlIIlIlIIlllIIIIIl.getFloatTemperature(llllllllllllIlIlIIlIlIIlllIIIlll);
                            if (llllllllllllIlIlIIlIlIIlllIlIlII.getBiomeProvider().getTemperatureAtHeight(llllllllllllIlIlIIlIlIIllIllllII, llllllllllllIlIlIIlIlIIlllIIIIII) >= 0.15f && !llllllllllllIlIlIIlIlIIlllIllIIl) {
                                if (llllllllllllIlIlIIlIlIIlllIIlIIl != 0) {
                                    if (llllllllllllIlIlIIlIlIIlllIIlIIl >= 0) {
                                        llllllllllllIlIlIIlIlIIlllIlIIII.draw();
                                    }
                                    llllllllllllIlIlIIlIlIIlllIIlIIl = 0;
                                    this.mc.getTextureManager().bindTexture(EntityRenderer.RAIN_TEXTURES);
                                    llllllllllllIlIlIIlIlIIlllIIllll.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                                }
                                final double llllllllllllIlIlIIlIlIIllIlllIll = -((this.rendererUpdateCount + llllllllllllIlIlIIlIlIIlllIIIlIl * llllllllllllIlIlIIlIlIIlllIIIlIl * 3121 + llllllllllllIlIlIIlIlIIlllIIIlIl * 45238971 + llllllllllllIlIlIIlIlIIlllIIIllI * llllllllllllIlIlIIlIlIIlllIIIllI * 418711 + llllllllllllIlIlIIlIlIIlllIIIllI * 13761 & 0x1F) + (double)llllllllllllIlIlIIlIlIIllIlIIlIl) / 32.0 * (3.0 + this.random.nextDouble());
                                final double llllllllllllIlIlIIlIlIIllIlllIlI = llllllllllllIlIlIIlIlIIlllIIIlIl + 0.5f - llllllllllllIlIlIIlIlIIlllIlIlIl.posX;
                                final double llllllllllllIlIlIIlIlIIllIlllIIl = llllllllllllIlIlIIlIlIIlllIIIllI + 0.5f - llllllllllllIlIlIIlIlIIlllIlIlIl.posZ;
                                final float llllllllllllIlIlIIlIlIIllIlllIII = MathHelper.sqrt(llllllllllllIlIlIIlIlIIllIlllIlI * llllllllllllIlIlIIlIlIIllIlllIlI + llllllllllllIlIlIIlIlIIllIlllIIl * llllllllllllIlIlIIlIlIIllIlllIIl) / llllllllllllIlIlIIlIlIIlllIIlIlI;
                                final float llllllllllllIlIlIIlIlIIllIllIlll = ((1.0f - llllllllllllIlIlIIlIlIIllIlllIII * llllllllllllIlIlIIlIlIIllIlllIII) * 0.5f + 0.5f) * llllllllllllIlIlIIlIlIIlllIlIllI;
                                llllllllllllIlIlIIlIlIIlllIIIlll.setPos(llllllllllllIlIlIIlIlIIlllIIIlIl, llllllllllllIlIlIIlIlIIllIllllIl, llllllllllllIlIlIIlIlIIlllIIIllI);
                                final int llllllllllllIlIlIIlIlIIllIllIllI = llllllllllllIlIlIIlIlIIlllIlIlII.getCombinedLight(llllllllllllIlIlIIlIlIIlllIIIlll, 0);
                                final int llllllllllllIlIlIIlIlIIllIllIlIl = llllllllllllIlIlIIlIlIIllIllIllI >> 16 & 0xFFFF;
                                final int llllllllllllIlIlIIlIlIIllIllIlII = llllllllllllIlIlIIlIlIIllIllIllI & 0xFFFF;
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl - llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIlllllI, llllllllllllIlIlIIlIlIIlllIIIllI - llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(0.0, llllllllllllIlIlIIlIlIIllIllllll * 0.25 + llllllllllllIlIlIIlIlIIllIlllIll).color(1.0f, 1.0f, 1.0f, llllllllllllIlIlIIlIlIIllIllIlll).lightmap(llllllllllllIlIlIIlIlIIllIllIlIl, llllllllllllIlIlIIlIlIIllIllIlII).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl + llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIlllllI, llllllllllllIlIlIIlIlIIlllIIIllI + llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(1.0, llllllllllllIlIlIIlIlIIllIllllll * 0.25 + llllllllllllIlIlIIlIlIIllIlllIll).color(1.0f, 1.0f, 1.0f, llllllllllllIlIlIIlIlIIllIllIlll).lightmap(llllllllllllIlIlIIlIlIIllIllIlIl, llllllllllllIlIlIIlIlIIllIllIlII).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl + llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIllllll, llllllllllllIlIlIIlIlIIlllIIIllI + llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(1.0, llllllllllllIlIlIIlIlIIllIlllllI * 0.25 + llllllllllllIlIlIIlIlIIllIlllIll).color(1.0f, 1.0f, 1.0f, llllllllllllIlIlIIlIlIIllIllIlll).lightmap(llllllllllllIlIlIIlIlIIllIllIlIl, llllllllllllIlIlIIlIlIIllIllIlII).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl - llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIllllll, llllllllllllIlIlIIlIlIIlllIIIllI - llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(0.0, llllllllllllIlIlIIlIlIIllIlllllI * 0.25 + llllllllllllIlIlIIlIlIIllIlllIll).color(1.0f, 1.0f, 1.0f, llllllllllllIlIlIIlIlIIllIllIlll).lightmap(llllllllllllIlIlIIlIlIIllIllIlIl, llllllllllllIlIlIIlIlIIllIllIlII).endVertex();
                            }
                            else {
                                if (llllllllllllIlIlIIlIlIIlllIIlIIl != 1) {
                                    if (llllllllllllIlIlIIlIlIIlllIIlIIl >= 0) {
                                        llllllllllllIlIlIIlIlIIlllIlIIII.draw();
                                    }
                                    llllllllllllIlIlIIlIlIIlllIIlIIl = 1;
                                    this.mc.getTextureManager().bindTexture(EntityRenderer.SNOW_TEXTURES);
                                    llllllllllllIlIlIIlIlIIlllIIllll.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                                }
                                final double llllllllllllIlIlIIlIlIIllIllIIll = -((this.rendererUpdateCount & 0x1FF) + llllllllllllIlIlIIlIlIIllIlIIlIl) / 512.0f;
                                final double llllllllllllIlIlIIlIlIIllIllIIlI = this.random.nextDouble() + llllllllllllIlIlIIlIlIIlllIIlIII * 0.01 * (float)this.random.nextGaussian();
                                final double llllllllllllIlIlIIlIlIIllIllIIIl = this.random.nextDouble() + llllllllllllIlIlIIlIlIIlllIIlIII * (float)this.random.nextGaussian() * 0.001;
                                final double llllllllllllIlIlIIlIlIIllIllIIII = llllllllllllIlIlIIlIlIIlllIIIlIl + 0.5f - llllllllllllIlIlIIlIlIIlllIlIlIl.posX;
                                final double llllllllllllIlIlIIlIlIIllIlIllll = llllllllllllIlIlIIlIlIIlllIIIllI + 0.5f - llllllllllllIlIlIIlIlIIlllIlIlIl.posZ;
                                final float llllllllllllIlIlIIlIlIIllIlIlllI = MathHelper.sqrt(llllllllllllIlIlIIlIlIIllIllIIII * llllllllllllIlIlIIlIlIIllIllIIII + llllllllllllIlIlIIlIlIIllIlIllll * llllllllllllIlIlIIlIlIIllIlIllll) / llllllllllllIlIlIIlIlIIlllIIlIlI;
                                final float llllllllllllIlIlIIlIlIIllIlIllIl = ((1.0f - llllllllllllIlIlIIlIlIIllIlIlllI * llllllllllllIlIlIIlIlIIllIlIlllI) * 0.3f + 0.5f) * llllllllllllIlIlIIlIlIIlllIlIllI;
                                llllllllllllIlIlIIlIlIIlllIIIlll.setPos(llllllllllllIlIlIIlIlIIlllIIIlIl, llllllllllllIlIlIIlIlIIllIllllIl, llllllllllllIlIlIIlIlIIlllIIIllI);
                                final int llllllllllllIlIlIIlIlIIllIlIllII = (llllllllllllIlIlIIlIlIIlllIlIlII.getCombinedLight(llllllllllllIlIlIIlIlIIlllIIIlll, 0) * 3 + 15728880) / 4;
                                final int llllllllllllIlIlIIlIlIIllIlIlIll = llllllllllllIlIlIIlIlIIllIlIllII >> 16 & 0xFFFF;
                                final int llllllllllllIlIlIIlIlIIllIlIlIlI = llllllllllllIlIlIIlIlIIllIlIllII & 0xFFFF;
                                final int llllllllllllIlIlIIlIlIIllIlIlIIl = (int)((Weather.weatherColor.getColorValue() >> 16 & 0xFF) / 100.0f);
                                final int llllllllllllIlIlIIlIlIIllIlIlIII = (int)((Weather.weatherColor.getColorValue() >> 8 & 0xFF) / 100.0f);
                                final int llllllllllllIlIlIIlIlIIllIlIIlll = (int)((Weather.weatherColor.getColorValue() & 0xFF) / 100.0f);
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl - llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIlllllI, llllllllllllIlIlIIlIlIIlllIIIllI - llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(0.0 + llllllllllllIlIlIIlIlIIllIllIIlI, llllllllllllIlIlIIlIlIIllIllllll * 0.25 + llllllllllllIlIlIIlIlIIllIllIIll + llllllllllllIlIlIIlIlIIllIllIIIl).color((float)llllllllllllIlIlIIlIlIIllIlIlIIl, (float)llllllllllllIlIlIIlIlIIllIlIlIII, (float)llllllllllllIlIlIIlIlIIllIlIIlll, llllllllllllIlIlIIlIlIIllIlIllIl).lightmap(llllllllllllIlIlIIlIlIIllIlIlIll, llllllllllllIlIlIIlIlIIllIlIlIlI).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl + llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIlllllI, llllllllllllIlIlIIlIlIIlllIIIllI + llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(1.0 + llllllllllllIlIlIIlIlIIllIllIIlI, llllllllllllIlIlIIlIlIIllIllllll * 0.25 + llllllllllllIlIlIIlIlIIllIllIIll + llllllllllllIlIlIIlIlIIllIllIIIl).color((float)llllllllllllIlIlIIlIlIIllIlIlIIl, (float)llllllllllllIlIlIIlIlIIllIlIlIII, (float)llllllllllllIlIlIIlIlIIllIlIIlll, llllllllllllIlIlIIlIlIIllIlIllIl).lightmap(llllllllllllIlIlIIlIlIIllIlIlIll, llllllllllllIlIlIIlIlIIllIlIlIlI).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl + llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIllllll, llllllllllllIlIlIIlIlIIlllIIIllI + llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(1.0 + llllllllllllIlIlIIlIlIIllIllIIlI, llllllllllllIlIlIIlIlIIllIlllllI * 0.25 + llllllllllllIlIlIIlIlIIllIllIIll + llllllllllllIlIlIIlIlIIllIllIIIl).color((float)llllllllllllIlIlIIlIlIIllIlIlIIl, (float)llllllllllllIlIlIIlIlIIllIlIlIII, (float)llllllllllllIlIlIIlIlIIllIlIIlll, llllllllllllIlIlIIlIlIIllIlIllIl).lightmap(llllllllllllIlIlIIlIlIIllIlIlIll, llllllllllllIlIlIIlIlIIllIlIlIlI).endVertex();
                                llllllllllllIlIlIIlIlIIlllIIllll.pos(llllllllllllIlIlIIlIlIIlllIIIlIl - llllllllllllIlIlIIlIlIIlllIIIIll + 0.5, llllllllllllIlIlIIlIlIIllIllllll, llllllllllllIlIlIIlIlIIlllIIIllI - llllllllllllIlIlIIlIlIIlllIIIIlI + 0.5).tex(0.0 + llllllllllllIlIlIIlIlIIllIllIIlI, llllllllllllIlIlIIlIlIIllIlllllI * 0.25 + llllllllllllIlIlIIlIlIIllIllIIll + llllllllllllIlIlIIlIlIIllIllIIIl).color((float)llllllllllllIlIlIIlIlIIllIlIlIIl, (float)llllllllllllIlIlIIlIlIIllIlIlIII, (float)llllllllllllIlIlIIlIlIIllIlIIlll, llllllllllllIlIlIIlIlIIllIlIllIl).lightmap(llllllllllllIlIlIIlIlIIllIlIlIll, llllllllllllIlIlIIlIlIIllIlIlIlI).endVertex();
                            }
                        }
                    }
                }
            }
            if (llllllllllllIlIlIIlIlIIlllIIlIIl >= 0) {
                llllllllllllIlIlIIlIlIIlllIlIIII.draw();
            }
            llllllllllllIlIlIIlIlIIlllIIllll.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1f);
            this.disableLightmap();
        }
    }
    
    private void setupViewBobbing(final float llllllllllllIlIlIIlIlIlllllIIIIl) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer llllllllllllIlIlIIlIlIlllllIIIII = (EntityPlayer)this.mc.getRenderViewEntity();
            final float llllllllllllIlIlIIlIlIllllIlllll = llllllllllllIlIlIIlIlIlllllIIIII.distanceWalkedModified - llllllllllllIlIlIIlIlIlllllIIIII.prevDistanceWalkedModified;
            final float llllllllllllIlIlIIlIlIllllIllllI = -(llllllllllllIlIlIIlIlIlllllIIIII.distanceWalkedModified + llllllllllllIlIlIIlIlIllllIlllll * llllllllllllIlIlIIlIlIlllllIIIIl);
            final float llllllllllllIlIlIIlIlIllllIlllIl = llllllllllllIlIlIIlIlIlllllIIIII.prevCameraYaw + (llllllllllllIlIlIIlIlIlllllIIIII.cameraYaw - llllllllllllIlIlIIlIlIlllllIIIII.prevCameraYaw) * llllllllllllIlIlIIlIlIlllllIIIIl;
            final float llllllllllllIlIlIIlIlIllllIlllII = llllllllllllIlIlIIlIlIlllllIIIII.prevCameraPitch + (llllllllllllIlIlIIlIlIlllllIIIII.cameraPitch - llllllllllllIlIlIIlIlIlllllIIIII.prevCameraPitch) * llllllllllllIlIlIIlIlIlllllIIIIl;
            GlStateManager.translate(MathHelper.sin(llllllllllllIlIlIIlIlIllllIllllI * 3.1415927f) * llllllllllllIlIlIIlIlIllllIlllIl * 0.5f, -Math.abs(MathHelper.cos(llllllllllllIlIlIIlIlIllllIllllI * 3.1415927f) * llllllllllllIlIlIIlIlIllllIlllIl), 0.0f);
            GlStateManager.rotate(MathHelper.sin(llllllllllllIlIlIIlIlIllllIllllI * 3.1415927f) * llllllllllllIlIlIIlIlIllllIlllIl * 3.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(Math.abs(MathHelper.cos(llllllllllllIlIlIIlIlIllllIllllI * 3.1415927f - 0.2f) * llllllllllllIlIlIIlIlIllllIlllIl) * 5.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(llllllllllllIlIlIIlIlIllllIlllII, 1.0f, 0.0f, 0.0f);
        }
    }
    
    public boolean isShaderActive() {
        return OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }
    
    public MapItemRenderer getMapItemRenderer() {
        return this.theMapItemRenderer;
    }
    
    public void switchUseShader() {
        this.useShader = !this.useShader;
    }
    
    private void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (Config.isSmoothWorld() && Config.isSingleProcessor()) {
            if (this.mc.isIntegratedServerRunning()) {
                final IntegratedServer llllllllllllIlIlIIlIlIIIlllIlIIl = this.mc.getIntegratedServer();
                if (llllllllllllIlIlIIlIlIIIlllIlIIl != null) {
                    final boolean llllllllllllIlIlIIlIlIIIlllIlIII = this.mc.isGamePaused();
                    if (!llllllllllllIlIlIIlIlIIIlllIlIII && !(this.mc.currentScreen instanceof GuiDownloadTerrain)) {
                        if (this.serverWaitTime > 0) {
                            Lagometer.timerServer.start();
                            Config.sleep((long)this.serverWaitTime);
                            Lagometer.timerServer.end();
                            this.serverWaitTimeCurrent = this.serverWaitTime;
                        }
                        final long llllllllllllIlIlIIlIlIIIlllIIlll = System.nanoTime() / 1000000L;
                        if (this.lastServerTime != 0L && this.lastServerTicks != 0) {
                            long llllllllllllIlIlIIlIlIIIlllIIllI = llllllllllllIlIlIIlIlIIIlllIIlll - this.lastServerTime;
                            if (llllllllllllIlIlIIlIlIIIlllIIllI < 0L) {
                                this.lastServerTime = llllllllllllIlIlIIlIlIIIlllIIlll;
                                llllllllllllIlIlIIlIlIIIlllIIllI = 0L;
                            }
                            if (llllllllllllIlIlIIlIlIIIlllIIllI >= 50L) {
                                this.lastServerTime = llllllllllllIlIlIIlIlIIIlllIIlll;
                                final int llllllllllllIlIlIIlIlIIIlllIIlIl = llllllllllllIlIlIIlIlIIIlllIlIIl.getTickCounter();
                                int llllllllllllIlIlIIlIlIIIlllIIlII = llllllllllllIlIlIIlIlIIIlllIIlIl - this.lastServerTicks;
                                if (llllllllllllIlIlIIlIlIIIlllIIlII < 0) {
                                    this.lastServerTicks = llllllllllllIlIlIIlIlIIIlllIIlIl;
                                    llllllllllllIlIlIIlIlIIIlllIIlII = 0;
                                }
                                if (llllllllllllIlIlIIlIlIIIlllIIlII < 1 && this.serverWaitTime < 100) {
                                    this.serverWaitTime += 2;
                                }
                                if (llllllllllllIlIlIIlIlIIIlllIIlII > 1 && this.serverWaitTime > 0) {
                                    --this.serverWaitTime;
                                }
                                this.lastServerTicks = llllllllllllIlIlIIlIlIIIlllIIlIl;
                            }
                        }
                        else {
                            this.lastServerTime = llllllllllllIlIlIIlIlIIIlllIIlll;
                            this.lastServerTicks = llllllllllllIlIlIIlIlIIIlllIlIIl.getTickCounter();
                            this.avgServerTickDiff = 1.0f;
                            this.avgServerTimeDiff = 50.0f;
                        }
                    }
                    else {
                        if (this.mc.currentScreen instanceof GuiDownloadTerrain) {
                            Config.sleep(20L);
                        }
                        this.lastServerTime = 0L;
                        this.lastServerTicks = 0;
                    }
                }
            }
        }
        else {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        }
    }
    
    public void loadShader(final ResourceLocation llllllllllllIlIlIIlIllIIIllllIll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            try {
                this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), llllllllllllIlIlIIlIllIIIllllIll);
                this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.useShader = true;
            }
            catch (IOException llllllllllllIlIlIIlIllIIIllllllI) {
                EntityRenderer.LOGGER.warn("Failed to load shader: {}", (Object)llllllllllllIlIlIIlIllIIIllllIll, (Object)llllllllllllIlIlIIlIllIIIllllllI);
                this.shaderIndex = EntityRenderer.SHADER_COUNT;
                this.useShader = false;
            }
            catch (JsonSyntaxException llllllllllllIlIlIIlIllIIIlllllIl) {
                EntityRenderer.LOGGER.warn("Failed to load shader: {}", (Object)llllllllllllIlIlIIlIllIIIllllIll, (Object)llllllllllllIlIlIIlIllIIIlllllIl);
                this.shaderIndex = EntityRenderer.SHADER_COUNT;
                this.useShader = false;
            }
        }
    }
    
    private void frameInit() {
        if (!this.initialized) {
            TextureUtils.registerResourceListener();
            if (Config.getBitsOs() == 64 && Config.getBitsJre() == 32) {
                Config.setNotify64BitJava(true);
            }
            this.initialized = true;
        }
        Config.checkDisplayMode();
        final World llllllllllllIlIlIIlIlIIIllIlIllI = this.mc.world;
        if (llllllllllllIlIlIIlIlIIIllIlIllI != null) {
            if (Config.getNewRelease() != null) {
                final String llllllllllllIlIlIIlIlIIIllIlIlIl = "HD_U".replace("HD_U", "HD Ultra").replace("L", "Light");
                final String llllllllllllIlIlIIlIlIIIllIlIlII = String.valueOf(llllllllllllIlIlIIlIlIIIllIlIlIl) + " " + Config.getNewRelease();
                final TextComponentString llllllllllllIlIlIIlIlIIIllIlIIll = new TextComponentString(I18n.format("of.message.newVersion", llllllllllllIlIlIIlIlIIIllIlIlII));
                this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllIlIlIIlIlIIIllIlIIll);
                Config.setNewRelease((String)null);
            }
            if (Config.isNotify64BitJava()) {
                Config.setNotify64BitJava(false);
                final TextComponentString llllllllllllIlIlIIlIlIIIllIlIIlI = new TextComponentString(I18n.format("of.message.java64Bit", new Object[0]));
                this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllIlIlIIlIlIIIllIlIIlI);
            }
        }
        if (this.mc.currentScreen instanceof GuiMainMenu) {
            this.updateMainMenu((GuiMainMenu)this.mc.currentScreen);
        }
        if (this.updatedWorld != llllllllllllIlIlIIlIlIIIllIlIllI) {
            RandomMobs.worldChanged(this.updatedWorld, llllllllllllIlIlIIlIlIIIllIlIllI);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = llllllllllllIlIlIIlIlIIIllIlIllI;
        }
        if (!this.setFxaaShader(Shaders.configAntialiasingLevel)) {
            Shaders.configAntialiasingLevel = 0;
        }
    }
    
    public void orientCamera(final float llllllllllllIlIlIIlIlIlllIllllll) {
        final Entity llllllllllllIlIlIIlIlIlllIlllllI = this.mc.getRenderViewEntity();
        float llllllllllllIlIlIIlIlIlllIllllIl = llllllllllllIlIlIIlIlIlllIlllllI.getEyeHeight();
        double llllllllllllIlIlIIlIlIlllIllllII = llllllllllllIlIlIIlIlIlllIlllllI.prevPosX + (llllllllllllIlIlIIlIlIlllIlllllI.posX - llllllllllllIlIlIIlIlIlllIlllllI.prevPosX) * llllllllllllIlIlIIlIlIlllIllllll;
        double llllllllllllIlIlIIlIlIlllIlllIll = llllllllllllIlIlIIlIlIlllIlllllI.prevPosY + (llllllllllllIlIlIIlIlIlllIlllllI.posY - llllllllllllIlIlIIlIlIlllIlllllI.prevPosY) * llllllllllllIlIlIIlIlIlllIllllll + llllllllllllIlIlIIlIlIlllIllllIl;
        double llllllllllllIlIlIIlIlIlllIlllIlI = llllllllllllIlIlIIlIlIlllIlllllI.prevPosZ + (llllllllllllIlIlIIlIlIlllIlllllI.posZ - llllllllllllIlIlIIlIlIlllIlllllI.prevPosZ) * llllllllllllIlIlIIlIlIlllIllllll;
        if (llllllllllllIlIlIIlIlIlllIlllllI instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIlIlIIlIlIlllIlllllI).isPlayerSleeping()) {
            ++llllllllllllIlIlIIlIlIlllIllllIl;
            GlStateManager.translate(0.0f, 0.3f, 0.0f);
            if (!this.mc.gameSettings.debugCamEnable) {
                final BlockPos llllllllllllIlIlIIlIlIlllIlllIIl = new BlockPos(llllllllllllIlIlIIlIlIlllIlllllI);
                final IBlockState llllllllllllIlIlIIlIlIlllIlllIII = this.mc.world.getBlockState(llllllllllllIlIlIIlIlIlllIlllIIl);
                final Block llllllllllllIlIlIIlIlIlllIllIlll = llllllllllllIlIlIIlIlIlllIlllIII.getBlock();
                if (Reflector.ForgeHooksClient_orientBedCamera.exists()) {
                    Reflector.callVoid(Reflector.ForgeHooksClient_orientBedCamera, new Object[] { this.mc.world, llllllllllllIlIlIIlIlIlllIlllIIl, llllllllllllIlIlIIlIlIlllIlllIII, llllllllllllIlIlIIlIlIlllIlllllI });
                }
                else if (llllllllllllIlIlIIlIlIlllIllIlll == Blocks.BED) {
                    final int llllllllllllIlIlIIlIlIlllIllIllI = llllllllllllIlIlIIlIlIlllIlllIII.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
                    GlStateManager.rotate((float)(llllllllllllIlIlIIlIlIlllIllIllI * 90), 0.0f, 1.0f, 0.0f);
                }
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw + (llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw) * llllllllllllIlIlIIlIlIlllIllllll + 180.0f, 0.0f, -1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch + (llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch) * llllllllllllIlIlIIlIlIlllIllllll, -1.0f, 0.0f, 0.0f);
            }
        }
        else if (this.mc.gameSettings.thirdPersonView > 0) {
            double llllllllllllIlIlIIlIlIlllIllIlIl = this.thirdPersonDistancePrev - 0.5;
            if (this.mc.gameSettings.debugCamEnable) {
                GlStateManager.translate(0.0f, 0.0f, (float)(-llllllllllllIlIlIIlIlIlllIllIlIl));
            }
            else {
                final float llllllllllllIlIlIIlIlIlllIllIlII = llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw;
                float llllllllllllIlIlIIlIlIlllIllIIll = llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch;
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    llllllllllllIlIlIIlIlIlllIllIIll += 180.0f;
                }
                final double llllllllllllIlIlIIlIlIlllIllIIlI = -MathHelper.sin(llllllllllllIlIlIIlIlIlllIllIlII * 0.017453292f) * MathHelper.cos(llllllllllllIlIlIIlIlIlllIllIIll * 0.017453292f) * llllllllllllIlIlIIlIlIlllIllIlIl;
                final double llllllllllllIlIlIIlIlIlllIllIIIl = MathHelper.cos(llllllllllllIlIlIIlIlIlllIllIlII * 0.017453292f) * MathHelper.cos(llllllllllllIlIlIIlIlIlllIllIIll * 0.017453292f) * llllllllllllIlIlIIlIlIlllIllIlIl;
                final double llllllllllllIlIlIIlIlIlllIllIIII = -MathHelper.sin(llllllllllllIlIlIIlIlIlllIllIIll * 0.017453292f) * llllllllllllIlIlIIlIlIlllIllIlIl;
                for (int llllllllllllIlIlIIlIlIlllIlIllll = 0; llllllllllllIlIlIIlIlIlllIlIllll < 8; ++llllllllllllIlIlIIlIlIlllIlIllll) {
                    float llllllllllllIlIlIIlIlIlllIlIlllI = (float)((llllllllllllIlIlIIlIlIlllIlIllll & 0x1) * 2 - 1);
                    float llllllllllllIlIlIIlIlIlllIlIllIl = (float)((llllllllllllIlIlIIlIlIlllIlIllll >> 1 & 0x1) * 2 - 1);
                    float llllllllllllIlIlIIlIlIlllIlIllII = (float)((llllllllllllIlIlIIlIlIlllIlIllll >> 2 & 0x1) * 2 - 1);
                    llllllllllllIlIlIIlIlIlllIlIlllI *= 0.1f;
                    llllllllllllIlIlIIlIlIlllIlIllIl *= 0.1f;
                    llllllllllllIlIlIIlIlIlllIlIllII *= 0.1f;
                    final RayTraceResult llllllllllllIlIlIIlIlIlllIlIlIll = this.mc.world.rayTraceBlocks(new Vec3d(llllllllllllIlIlIIlIlIlllIllllII + llllllllllllIlIlIIlIlIlllIlIlllI, llllllllllllIlIlIIlIlIlllIlllIll + llllllllllllIlIlIIlIlIlllIlIllIl, llllllllllllIlIlIIlIlIlllIlllIlI + llllllllllllIlIlIIlIlIlllIlIllII), new Vec3d(llllllllllllIlIlIIlIlIlllIllllII - llllllllllllIlIlIIlIlIlllIllIIlI + llllllllllllIlIlIIlIlIlllIlIlllI + llllllllllllIlIlIIlIlIlllIlIllII, llllllllllllIlIlIIlIlIlllIlllIll - llllllllllllIlIlIIlIlIlllIllIIII + llllllllllllIlIlIIlIlIlllIlIllIl, llllllllllllIlIlIIlIlIlllIlllIlI - llllllllllllIlIlIIlIlIlllIllIIIl + llllllllllllIlIlIIlIlIlllIlIllII));
                    if (llllllllllllIlIlIIlIlIlllIlIlIll != null) {
                        final double llllllllllllIlIlIIlIlIlllIlIlIlI = llllllllllllIlIlIIlIlIlllIlIlIll.hitVec.distanceTo(new Vec3d(llllllllllllIlIlIIlIlIlllIllllII, llllllllllllIlIlIIlIlIlllIlllIll, llllllllllllIlIlIIlIlIlllIlllIlI));
                        if ((!NoRender.cameraClip.getBoolValue() || !Main.featureDirector.getFeatureByClass(NoRender.class).isToggled()) && llllllllllllIlIlIIlIlIlllIlIlIlI < llllllllllllIlIlIIlIlIlllIllIlIl) {
                            llllllllllllIlIlIIlIlIlllIllIlIl = llllllllllllIlIlIIlIlIlllIlIlIlI;
                        }
                    }
                }
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch - llllllllllllIlIlIIlIlIlllIllIIll, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw - llllllllllllIlIlIIlIlIlllIllIlII, 0.0f, 1.0f, 0.0f);
                GlStateManager.translate(0.0f, 0.0f, (float)(-llllllllllllIlIlIIlIlIlllIllIlIl));
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIllIlII - llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIllIIll - llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch, 1.0f, 0.0f, 0.0f);
            }
        }
        else {
            GlStateManager.translate(0.0f, 0.0f, 0.05f);
        }
        if (Reflector.EntityViewRenderEvent_CameraSetup_Constructor.exists()) {
            if (!this.mc.gameSettings.debugCamEnable) {
                float llllllllllllIlIlIIlIlIlllIlIlIIl = llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw + (llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw) * llllllllllllIlIlIIlIlIlllIllllll + 180.0f;
                float llllllllllllIlIlIIlIlIlllIlIlIII = llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch + (llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch) * llllllllllllIlIlIIlIlIlllIllllll;
                float llllllllllllIlIlIIlIlIlllIlIIlll = 0.0f;
                if (llllllllllllIlIlIIlIlIlllIlllllI instanceof EntityAnimal) {
                    final EntityAnimal llllllllllllIlIlIIlIlIlllIlIIllI = (EntityAnimal)llllllllllllIlIlIIlIlIlllIlllllI;
                    llllllllllllIlIlIIlIlIlllIlIlIIl = llllllllllllIlIlIIlIlIlllIlIIllI.prevRotationYawHead + (llllllllllllIlIlIIlIlIlllIlIIllI.rotationYawHead - llllllllllllIlIlIIlIlIlllIlIIllI.prevRotationYawHead) * llllllllllllIlIlIIlIlIlllIllllll + 180.0f;
                }
                final IBlockState llllllllllllIlIlIIlIlIlllIlIIlIl = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, llllllllllllIlIlIIlIlIlllIlllllI, llllllllllllIlIlIIlIlIlllIllllll);
                final Object llllllllllllIlIlIIlIlIlllIlIIlII = Reflector.newInstance(Reflector.EntityViewRenderEvent_CameraSetup_Constructor, new Object[] { this, llllllllllllIlIlIIlIlIlllIlllllI, llllllllllllIlIlIIlIlIlllIlIIlIl, llllllllllllIlIlIIlIlIlllIllllll, llllllllllllIlIlIIlIlIlllIlIlIIl, llllllllllllIlIlIIlIlIlllIlIlIII, llllllllllllIlIlIIlIlIlllIlIIlll });
                Reflector.postForgeBusEvent(llllllllllllIlIlIIlIlIlllIlIIlII);
                llllllllllllIlIlIIlIlIlllIlIIlll = Reflector.callFloat(llllllllllllIlIlIIlIlIlllIlIIlII, Reflector.EntityViewRenderEvent_CameraSetup_getRoll, new Object[0]);
                llllllllllllIlIlIIlIlIlllIlIlIII = Reflector.callFloat(llllllllllllIlIlIIlIlIlllIlIIlII, Reflector.EntityViewRenderEvent_CameraSetup_getPitch, new Object[0]);
                llllllllllllIlIlIIlIlIlllIlIlIIl = Reflector.callFloat(llllllllllllIlIlIIlIlIlllIlIIlII, Reflector.EntityViewRenderEvent_CameraSetup_getYaw, new Object[0]);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlIIlll, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlIlIII, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlIlIIl, 0.0f, 1.0f, 0.0f);
            }
        }
        else if (!this.mc.gameSettings.debugCamEnable) {
            GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch + (llllllllllllIlIlIIlIlIlllIlllllI.rotationPitch - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationPitch) * llllllllllllIlIlIIlIlIlllIllllll, 1.0f, 0.0f, 0.0f);
            if (llllllllllllIlIlIIlIlIlllIlllllI instanceof EntityAnimal) {
                final EntityAnimal llllllllllllIlIlIIlIlIlllIlIIIll = (EntityAnimal)llllllllllllIlIlIIlIlIlllIlllllI;
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlIIIll.prevRotationYawHead + (llllllllllllIlIlIIlIlIlllIlIIIll.rotationYawHead - llllllllllllIlIlIIlIlIlllIlIIIll.prevRotationYawHead) * llllllllllllIlIlIIlIlIlllIllllll + 180.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.rotate(llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw + (llllllllllllIlIlIIlIlIlllIlllllI.rotationYaw - llllllllllllIlIlIIlIlIlllIlllllI.prevRotationYaw) * llllllllllllIlIlIIlIlIlllIllllll + 180.0f, 0.0f, 1.0f, 0.0f);
            }
        }
        GlStateManager.translate(0.0f, -llllllllllllIlIlIIlIlIlllIllllIl, 0.0f);
        llllllllllllIlIlIIlIlIlllIllllII = llllllllllllIlIlIIlIlIlllIlllllI.prevPosX + (llllllllllllIlIlIIlIlIlllIlllllI.posX - llllllllllllIlIlIIlIlIlllIlllllI.prevPosX) * llllllllllllIlIlIIlIlIlllIllllll;
        llllllllllllIlIlIIlIlIlllIlllIll = llllllllllllIlIlIIlIlIlllIlllllI.prevPosY + (llllllllllllIlIlIIlIlIlllIlllllI.posY - llllllllllllIlIlIIlIlIlllIlllllI.prevPosY) * llllllllllllIlIlIIlIlIlllIllllll + llllllllllllIlIlIIlIlIlllIllllIl;
        llllllllllllIlIlIIlIlIlllIlllIlI = llllllllllllIlIlIIlIlIlllIlllllI.prevPosZ + (llllllllllllIlIlIIlIlIlllIlllllI.posZ - llllllllllllIlIlIIlIlIlllIlllllI.prevPosZ) * llllllllllllIlIlIIlIlIlllIllllll;
        this.cloudFog = this.mc.renderGlobal.hasCloudFog(llllllllllllIlIlIIlIlIlllIllllII, llllllllllllIlIlIIlIlIlllIlllIll, llllllllllllIlIlIIlIlIlllIlllIlI, llllllllllllIlIlIIlIlIlllIllllll);
    }
    
    public void renderHand(final float llllllllllllIlIlIIlIlIllIlIlllIl, final int llllllllllllIlIlIIlIlIllIlIlllII, final boolean llllllllllllIlIlIIlIlIllIlIllIll, final boolean llllllllllllIlIlIIlIlIllIlIllIlI, final boolean llllllllllllIlIlIIlIlIllIlIllIIl) {
        if (!this.debugView) {
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            final float llllllllllllIlIlIIlIlIllIllIIIIl = 0.07f;
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate(-(llllllllllllIlIlIIlIlIllIlIlllII * 2 - 1) * 0.07f, 0.0f, 0.0f);
            }
            if (Config.isShaders()) {
                Shaders.applyHandDepth();
            }
            Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIllIlIlllIl, false), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate((llllllllllllIlIlIIlIlIllIlIlllII * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            boolean llllllllllllIlIlIIlIlIllIllIIIII = false;
            if (llllllllllllIlIlIIlIlIllIlIllIll) {
                GlStateManager.pushMatrix();
                this.hurtCameraEffect(llllllllllllIlIlIIlIlIllIlIlllIl);
                if (this.mc.gameSettings.viewBobbing) {
                    this.setupViewBobbing(llllllllllllIlIlIIlIlIllIlIlllIl);
                }
                llllllllllllIlIlIIlIlIllIllIIIII = (this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping());
                final boolean llllllllllllIlIlIIlIlIllIlIlllll = !ReflectorForge.renderFirstPersonHand(this.mc.renderGlobal, llllllllllllIlIlIIlIlIllIlIlllIl, llllllllllllIlIlIIlIlIllIlIlllII);
                if (llllllllllllIlIlIIlIlIllIlIlllll && this.mc.gameSettings.thirdPersonView == 0 && !llllllllllllIlIlIIlIlIllIllIIIII && !this.mc.gameSettings.hideGUI && !this.mc.playerController.isSpectator()) {
                    this.enableLightmap();
                    if (Config.isShaders()) {
                        ShadersRender.renderItemFP(this.itemRenderer, llllllllllllIlIlIIlIlIllIlIlllIl, llllllllllllIlIlIIlIlIllIlIllIIl);
                    }
                    else {
                        this.itemRenderer.renderItemInFirstPerson(llllllllllllIlIlIIlIlIllIlIlllIl);
                    }
                    this.disableLightmap();
                }
                GlStateManager.popMatrix();
            }
            if (!llllllllllllIlIlIIlIlIllIlIllIlI) {
                return;
            }
            this.disableLightmap();
            if (this.mc.gameSettings.thirdPersonView == 0 && !llllllllllllIlIlIIlIlIllIllIIIII) {
                this.itemRenderer.renderOverlays(llllllllllllIlIlIIlIlIllIlIlllIl);
                this.hurtCameraEffect(llllllllllllIlIlIIlIlIllIlIlllIl);
            }
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(llllllllllllIlIlIIlIlIllIlIlllIl);
            }
        }
    }
    
    public void stopUseShader() {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        this.shaderIndex = EntityRenderer.SHADER_COUNT;
    }
    
    public ShaderGroup getShaderGroup() {
        return this.theShaderGroup;
    }
    
    public EntityRenderer(final Minecraft llllllllllllIlIlIIlIllIIlIIllIIl, final IResourceManager llllllllllllIlIlIIlIllIIlIlIIIII) {
        this.random = new Random();
        this.mouseFilterXAxis = new MouseFilter();
        this.mouseFilterYAxis = new MouseFilter();
        this.thirdPersonDistancePrev = 4.0f;
        this.renderHand = true;
        this.drawBlockOutline = true;
        this.prevFrameTime = Minecraft.getSystemTime();
        this.rainXCoords = new float[1024];
        this.rainYCoords = new float[1024];
        this.fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.cameraZoom = 1.0;
        this.initialized = false;
        this.updatedWorld = null;
        this.fogStandard = false;
        this.clipDistance = 128.0f;
        this.lastServerTime = 0L;
        this.lastServerTicks = 0;
        this.serverWaitTime = 0;
        this.serverWaitTimeCurrent = 0;
        this.avgServerTimeDiff = 0.0f;
        this.avgServerTickDiff = 0.0f;
        this.lastErrorCheckTimeMs = 0L;
        this.fxaaShaders = new ShaderGroup[10];
        this.loadVisibleChunks = false;
        this.scopeMath = 1.0f;
        this.shaderIndex = EntityRenderer.SHADER_COUNT;
        this.mc = llllllllllllIlIlIIlIllIIlIIllIIl;
        this.resourceManager = llllllllllllIlIlIIlIllIIlIlIIIII;
        this.itemRenderer = llllllllllllIlIlIIlIllIIlIIllIIl.getItemRenderer();
        this.theMapItemRenderer = new MapItemRenderer(llllllllllllIlIlIIlIllIIlIIllIIl.getTextureManager());
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = llllllllllllIlIlIIlIllIIlIIllIIl.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;
        for (int llllllllllllIlIlIIlIllIIlIIlllll = 0; llllllllllllIlIlIIlIllIIlIIlllll < 32; ++llllllllllllIlIlIIlIllIIlIIlllll) {
            for (int llllllllllllIlIlIIlIllIIlIIllllI = 0; llllllllllllIlIlIIlIllIIlIIllllI < 32; ++llllllllllllIlIlIIlIllIIlIIllllI) {
                final float llllllllllllIlIlIIlIllIIlIIlllIl = (float)(llllllllllllIlIlIIlIllIIlIIllllI - 16);
                final float llllllllllllIlIlIIlIllIIlIIlllII = (float)(llllllllllllIlIlIIlIllIIlIIlllll - 16);
                final float llllllllllllIlIlIIlIllIIlIIllIll = MathHelper.sqrt(llllllllllllIlIlIIlIllIIlIIlllIl * llllllllllllIlIlIIlIllIIlIIlllIl + llllllllllllIlIlIIlIllIIlIIlllII * llllllllllllIlIlIIlIllIIlIIlllII);
                this.rainXCoords[llllllllllllIlIlIIlIllIIlIIlllll << 5 | llllllllllllIlIlIIlIllIIlIIllllI] = -llllllllllllIlIlIIlIllIIlIIlllII / llllllllllllIlIlIIlIllIIlIIllIll;
                this.rainYCoords[llllllllllllIlIlIIlIllIIlIIlllll << 5 | llllllllllllIlIlIIlIllIIlIIllllI] = llllllllllllIlIlIIlIllIIlIIlllIl / llllllllllllIlIlIIlIllIIlIIllIll;
            }
        }
    }
    
    private void renderHand(final float llllllllllllIlIlIIlIlIllIlllIIlI, final int llllllllllllIlIlIIlIlIllIlllIlII) {
        this.renderHand(llllllllllllIlIlIIlIlIllIlllIIlI, llllllllllllIlIlIIlIlIllIlllIlII, true, true, false);
    }
    
    public static void drawNameplate(final FontRenderer llllllllllllIlIlIIlIlIIIIllIIIIl, final String llllllllllllIlIlIIlIlIIIIlIlIIll, final float llllllllllllIlIlIIlIlIIIIlIlIIlI, final float llllllllllllIlIlIIlIlIIIIlIlIIIl, final float llllllllllllIlIlIIlIlIIIIlIlllIl, final int llllllllllllIlIlIIlIlIIIIlIlllII, final float llllllllllllIlIlIIlIlIIIIlIIlllI, final float llllllllllllIlIlIIlIlIIIIlIIllIl, final boolean llllllllllllIlIlIIlIlIIIIlIIllII, final boolean llllllllllllIlIlIIlIlIIIIlIIlIll) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(llllllllllllIlIlIIlIlIIIIlIlIIlI, llllllllllllIlIlIIlIlIIIIlIlIIIl, llllllllllllIlIlIIlIlIIIIlIlllIl);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-llllllllllllIlIlIIlIlIIIIlIIlllI, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((llllllllllllIlIlIIlIlIIIIlIIllII ? -1 : 1) * llllllllllllIlIlIIlIlIIIIlIIllIl, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-0.025f, -0.025f, 0.025f);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        if (!llllllllllllIlIlIIlIlIIIIlIIlIll) {
            GlStateManager.disableDepth();
        }
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final int llllllllllllIlIlIIlIlIIIIlIlIlll = llllllllllllIlIlIIlIlIIIIllIIIIl.getStringWidth(llllllllllllIlIlIIlIlIIIIlIlIIll) / 2;
        GlStateManager.disableTexture2D();
        final Tessellator llllllllllllIlIlIIlIlIIIIlIlIllI = Tessellator.getInstance();
        final BufferBuilder llllllllllllIlIlIIlIlIIIIlIlIlIl = llllllllllllIlIlIIlIlIIIIlIlIllI.getBuffer();
        llllllllllllIlIlIIlIlIIIIlIlIlIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
        llllllllllllIlIlIIlIlIIIIlIlIlIl.pos(-llllllllllllIlIlIIlIlIIIIlIlIlll - 1, -1 + llllllllllllIlIlIIlIlIIIIlIlllII, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        llllllllllllIlIlIIlIlIIIIlIlIlIl.pos(-llllllllllllIlIlIIlIlIIIIlIlIlll - 1, 8 + llllllllllllIlIlIIlIlIIIIlIlllII, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        llllllllllllIlIlIIlIlIIIIlIlIlIl.pos(llllllllllllIlIlIIlIlIIIIlIlIlll + 1, 8 + llllllllllllIlIlIIlIlIIIIlIlllII, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        llllllllllllIlIlIIlIlIIIIlIlIlIl.pos(llllllllllllIlIlIIlIlIIIIlIlIlll + 1, -1 + llllllllllllIlIlIIlIlIIIIlIlllII, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        llllllllllllIlIlIIlIlIIIIlIlIllI.draw();
        GlStateManager.enableTexture2D();
        if (!llllllllllllIlIlIIlIlIIIIlIIlIll) {
            llllllllllllIlIlIIlIlIIIIllIIIIl.drawString(llllllllllllIlIlIIlIlIIIIlIlIIll, (float)(-llllllllllllIlIlIIlIlIIIIllIIIIl.getStringWidth(llllllllllllIlIlIIlIlIIIIlIlIIll) / 2), (float)llllllllllllIlIlIIlIlIIIIlIlllII, 553648127);
            GlStateManager.enableDepth();
        }
        GlStateManager.depthMask(true);
        llllllllllllIlIlIIlIlIIIIllIIIIl.drawString(llllllllllllIlIlIIlIlIIIIlIlIIll, (float)(-llllllllllllIlIlIIlIlIIIIllIIIIl.getStringWidth(llllllllllllIlIlIIlIlIIIIlIlIIll) / 2), (float)llllllllllllIlIlIIlIlIIIIlIlllII, llllllllllllIlIlIIlIlIIIIlIIlIll ? 553648127 : -1);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }
    
    public void updateShaderGroupSize(final int llllllllllllIlIlIIlIllIIIlIlIIIl, final int llllllllllllIlIlIIlIllIIIlIlIIll) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.createBindFramebuffers(llllllllllllIlIlIIlIllIIIlIlIIIl, llllllllllllIlIlIIlIllIIIlIlIIll);
            }
            this.mc.renderGlobal.createBindEntityOutlineFbs(llllllllllllIlIlIIlIllIIIlIlIIIl, llllllllllllIlIlIIlIllIIIlIlIIll);
        }
    }
    
    private void updateFogColor(final float llllllllllllIlIlIIlIlIIlIlIlllll) {
        final World llllllllllllIlIlIIlIlIIlIlIllllI = this.mc.world;
        final Entity llllllllllllIlIlIIlIlIIlIlIlllIl = this.mc.getRenderViewEntity();
        float llllllllllllIlIlIIlIlIIlIlIlllII = 0.25f + 0.75f * this.mc.gameSettings.renderDistanceChunks / 32.0f;
        llllllllllllIlIlIIlIlIIlIlIlllII = 1.0f - (float)Math.pow(llllllllllllIlIlIIlIlIIlIlIlllII, 0.25);
        Vec3d llllllllllllIlIlIIlIlIIlIlIllIll = llllllllllllIlIlIIlIlIIlIlIllllI.getSkyColor(this.mc.getRenderViewEntity(), llllllllllllIlIlIIlIlIIlIlIlllll);
        llllllllllllIlIlIIlIlIIlIlIllIll = CustomColors.getWorldSkyColor(llllllllllllIlIlIIlIlIIlIlIllIll, llllllllllllIlIlIIlIlIIlIlIllllI, this.mc.getRenderViewEntity(), llllllllllllIlIlIIlIlIIlIlIlllll);
        final float llllllllllllIlIlIIlIlIIlIlIllIlI = (float)llllllllllllIlIlIIlIlIIlIlIllIll.xCoord;
        final float llllllllllllIlIlIIlIlIIlIlIllIIl = (float)llllllllllllIlIlIIlIlIIlIlIllIll.yCoord;
        final float llllllllllllIlIlIIlIlIIlIlIllIII = (float)llllllllllllIlIlIIlIlIIlIlIllIll.zCoord;
        Vec3d llllllllllllIlIlIIlIlIIlIlIlIlll = llllllllllllIlIlIIlIlIIlIlIllllI.getFogColor(llllllllllllIlIlIIlIlIIlIlIlllll);
        llllllllllllIlIlIIlIlIIlIlIlIlll = CustomColors.getWorldFogColor(llllllllllllIlIlIIlIlIIlIlIlIlll, llllllllllllIlIlIIlIlIIlIlIllllI, this.mc.getRenderViewEntity(), llllllllllllIlIlIIlIlIIlIlIlllll);
        this.fogColorRed = (float)llllllllllllIlIlIIlIlIIlIlIlIlll.xCoord;
        this.fogColorGreen = (float)llllllllllllIlIlIIlIlIIlIlIlIlll.yCoord;
        this.fogColorBlue = (float)llllllllllllIlIlIIlIlIIlIlIlIlll.zCoord;
        if (this.mc.gameSettings.renderDistanceChunks >= 4) {
            final double llllllllllllIlIlIIlIlIIlIlIlIllI = (MathHelper.sin(llllllllllllIlIlIIlIlIIlIlIllllI.getCelestialAngleRadians(llllllllllllIlIlIIlIlIIlIlIlllll)) > 0.0f) ? -1.0 : 1.0;
            final Vec3d llllllllllllIlIlIIlIlIIlIlIlIlIl = new Vec3d(llllllllllllIlIlIIlIlIIlIlIlIllI, 0.0, 0.0);
            float llllllllllllIlIlIIlIlIIlIlIlIlII = (float)llllllllllllIlIlIIlIlIIlIlIlllIl.getLook(llllllllllllIlIlIIlIlIIlIlIlllll).dotProduct(llllllllllllIlIlIIlIlIIlIlIlIlIl);
            if (llllllllllllIlIlIIlIlIIlIlIlIlII < 0.0f) {
                llllllllllllIlIlIIlIlIIlIlIlIlII = 0.0f;
            }
            if (llllllllllllIlIlIIlIlIIlIlIlIlII > 0.0f) {
                final float[] llllllllllllIlIlIIlIlIIlIlIlIIll = llllllllllllIlIlIIlIlIIlIlIllllI.provider.calcSunriseSunsetColors(llllllllllllIlIlIIlIlIIlIlIllllI.getCelestialAngle(llllllllllllIlIlIIlIlIIlIlIlllll), llllllllllllIlIlIIlIlIIlIlIlllll);
                if (llllllllllllIlIlIIlIlIIlIlIlIIll != null) {
                    llllllllllllIlIlIIlIlIIlIlIlIlII *= llllllllllllIlIlIIlIlIIlIlIlIIll[3];
                    this.fogColorRed = this.fogColorRed * (1.0f - llllllllllllIlIlIIlIlIIlIlIlIlII) + llllllllllllIlIlIIlIlIIlIlIlIIll[0] * llllllllllllIlIlIIlIlIIlIlIlIlII;
                    this.fogColorGreen = this.fogColorGreen * (1.0f - llllllllllllIlIlIIlIlIIlIlIlIlII) + llllllllllllIlIlIIlIlIIlIlIlIIll[1] * llllllllllllIlIlIIlIlIIlIlIlIlII;
                    this.fogColorBlue = this.fogColorBlue * (1.0f - llllllllllllIlIlIIlIlIIlIlIlIlII) + llllllllllllIlIlIIlIlIIlIlIlIIll[2] * llllllllllllIlIlIIlIlIIlIlIlIlII;
                }
            }
        }
        this.fogColorRed += (llllllllllllIlIlIIlIlIIlIlIllIlI - this.fogColorRed) * llllllllllllIlIlIIlIlIIlIlIlllII;
        this.fogColorGreen += (llllllllllllIlIlIIlIlIIlIlIllIIl - this.fogColorGreen) * llllllllllllIlIlIIlIlIIlIlIlllII;
        this.fogColorBlue += (llllllllllllIlIlIIlIlIIlIlIllIII - this.fogColorBlue) * llllllllllllIlIlIIlIlIIlIlIlllII;
        final float llllllllllllIlIlIIlIlIIlIlIlIIlI = llllllllllllIlIlIIlIlIIlIlIllllI.getRainStrength(llllllllllllIlIlIIlIlIIlIlIlllll);
        if (llllllllllllIlIlIIlIlIIlIlIlIIlI > 0.0f) {
            final float llllllllllllIlIlIIlIlIIlIlIlIIIl = 1.0f - llllllllllllIlIlIIlIlIIlIlIlIIlI * 0.5f;
            final float llllllllllllIlIlIIlIlIIlIlIlIIII = 1.0f - llllllllllllIlIlIIlIlIIlIlIlIIlI * 0.4f;
            this.fogColorRed *= llllllllllllIlIlIIlIlIIlIlIlIIIl;
            this.fogColorGreen *= llllllllllllIlIlIIlIlIIlIlIlIIIl;
            this.fogColorBlue *= llllllllllllIlIlIIlIlIIlIlIlIIII;
        }
        final float llllllllllllIlIlIIlIlIIlIlIIllll = llllllllllllIlIlIIlIlIIlIlIllllI.getThunderStrength(llllllllllllIlIlIIlIlIIlIlIlllll);
        if (llllllllllllIlIlIIlIlIIlIlIIllll > 0.0f) {
            final float llllllllllllIlIlIIlIlIIlIlIIlllI = 1.0f - llllllllllllIlIlIIlIlIIlIlIIllll * 0.5f;
            this.fogColorRed *= llllllllllllIlIlIIlIlIIlIlIIlllI;
            this.fogColorGreen *= llllllllllllIlIlIIlIlIIlIlIIlllI;
            this.fogColorBlue *= llllllllllllIlIlIIlIlIIlIlIIlllI;
        }
        final IBlockState llllllllllllIlIlIIlIlIIlIlIIllIl = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, llllllllllllIlIlIIlIlIIlIlIlllIl, llllllllllllIlIlIIlIlIIlIlIlllll);
        if (this.cloudFog) {
            final Vec3d llllllllllllIlIlIIlIlIIlIlIIllII = llllllllllllIlIlIIlIlIIlIlIllllI.getCloudColour(llllllllllllIlIlIIlIlIIlIlIlllll);
            this.fogColorRed = (float)llllllllllllIlIlIIlIlIIlIlIIllII.xCoord;
            this.fogColorGreen = (float)llllllllllllIlIlIIlIlIIlIlIIllII.yCoord;
            this.fogColorBlue = (float)llllllllllllIlIlIIlIlIIlIlIIllII.zCoord;
        }
        else if (Reflector.ForgeBlock_getFogColor.exists()) {
            final Vec3d llllllllllllIlIlIIlIlIIlIlIIlIll = ActiveRenderInfo.projectViewFromEntity(llllllllllllIlIlIIlIlIIlIlIlllIl, llllllllllllIlIlIIlIlIIlIlIlllll);
            final BlockPos llllllllllllIlIlIIlIlIIlIlIIlIlI = new BlockPos(llllllllllllIlIlIIlIlIIlIlIIlIll);
            final IBlockState llllllllllllIlIlIIlIlIIlIlIIlIIl = this.mc.world.getBlockState(llllllllllllIlIlIIlIlIIlIlIIlIlI);
            final Vec3d llllllllllllIlIlIIlIlIIlIlIIlIII = (Vec3d)Reflector.call((Object)llllllllllllIlIlIIlIlIIlIlIIlIIl.getBlock(), Reflector.ForgeBlock_getFogColor, new Object[] { this.mc.world, llllllllllllIlIlIIlIlIIlIlIIlIlI, llllllllllllIlIlIIlIlIIlIlIIlIIl, llllllllllllIlIlIIlIlIIlIlIlllIl, new Vec3d(this.fogColorRed, this.fogColorGreen, this.fogColorBlue), llllllllllllIlIlIIlIlIIlIlIlllll });
            this.fogColorRed = (float)llllllllllllIlIlIIlIlIIlIlIIlIII.xCoord;
            this.fogColorGreen = (float)llllllllllllIlIlIIlIlIIlIlIIlIII.yCoord;
            this.fogColorBlue = (float)llllllllllllIlIlIIlIlIIlIlIIlIII.zCoord;
        }
        else if (llllllllllllIlIlIIlIlIIlIlIIllIl.getMaterial() == Material.WATER) {
            float llllllllllllIlIlIIlIlIIlIlIIIlll = 0.0f;
            if (llllllllllllIlIlIIlIlIIlIlIlllIl instanceof EntityLivingBase) {
                llllllllllllIlIlIIlIlIIlIlIIIlll = EnchantmentHelper.getRespirationModifier((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl) * 0.2f;
                if (((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl).isPotionActive(MobEffects.WATER_BREATHING)) {
                    llllllllllllIlIlIIlIlIIlIlIIIlll = llllllllllllIlIlIIlIlIIlIlIIIlll * 0.3f + 0.6f;
                }
            }
            this.fogColorRed = 0.02f + llllllllllllIlIlIIlIlIIlIlIIIlll;
            this.fogColorGreen = 0.02f + llllllllllllIlIlIIlIlIIlIlIIIlll;
            this.fogColorBlue = 0.2f + llllllllllllIlIlIIlIlIIlIlIIIlll;
            final Vec3d llllllllllllIlIlIIlIlIIlIlIIIllI = CustomColors.getUnderwaterColor((IBlockAccess)this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (llllllllllllIlIlIIlIlIIlIlIIIllI != null) {
                this.fogColorRed = (float)llllllllllllIlIlIIlIlIIlIlIIIllI.xCoord;
                this.fogColorGreen = (float)llllllllllllIlIlIIlIlIIlIlIIIllI.yCoord;
                this.fogColorBlue = (float)llllllllllllIlIlIIlIlIIlIlIIIllI.zCoord;
            }
        }
        else if (llllllllllllIlIlIIlIlIIlIlIIllIl.getMaterial() == Material.LAVA) {
            this.fogColorRed = 0.6f;
            this.fogColorGreen = 0.1f;
            this.fogColorBlue = 0.0f;
            final Vec3d llllllllllllIlIlIIlIlIIlIlIIIlIl = CustomColors.getUnderlavaColor((IBlockAccess)this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (llllllllllllIlIlIIlIlIIlIlIIIlIl != null) {
                this.fogColorRed = (float)llllllllllllIlIlIIlIlIIlIlIIIlIl.xCoord;
                this.fogColorGreen = (float)llllllllllllIlIlIIlIlIIlIlIIIlIl.yCoord;
                this.fogColorBlue = (float)llllllllllllIlIlIIlIlIIlIlIIIlIl.zCoord;
            }
        }
        final float llllllllllllIlIlIIlIlIIlIlIIIlII = this.fogColor2 + (this.fogColor1 - this.fogColor2) * llllllllllllIlIlIIlIlIIlIlIlllll;
        this.fogColorRed *= llllllllllllIlIlIIlIlIIlIlIIIlII;
        this.fogColorGreen *= llllllllllllIlIlIIlIlIIlIlIIIlII;
        this.fogColorBlue *= llllllllllllIlIlIIlIlIIlIlIIIlII;
        double llllllllllllIlIlIIlIlIIlIlIIIIll = (llllllllllllIlIlIIlIlIIlIlIlllIl.lastTickPosY + (llllllllllllIlIlIIlIlIIlIlIlllIl.posY - llllllllllllIlIlIIlIlIIlIlIlllIl.lastTickPosY) * llllllllllllIlIlIIlIlIIlIlIlllll) * llllllllllllIlIlIIlIlIIlIlIllllI.provider.getVoidFogYFactor();
        if (llllllllllllIlIlIIlIlIIlIlIlllIl instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl).isPotionActive(MobEffects.BLINDNESS)) {
            final int llllllllllllIlIlIIlIlIIlIlIIIIlI = ((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            if (llllllllllllIlIlIIlIlIIlIlIIIIlI < 20) {
                llllllllllllIlIlIIlIlIIlIlIIIIll *= 1.0f - llllllllllllIlIlIIlIlIIlIlIIIIlI / 20.0f;
            }
            else {
                llllllllllllIlIlIIlIlIIlIlIIIIll = 0.0;
            }
        }
        if (llllllllllllIlIlIIlIlIIlIlIIIIll < 1.0) {
            if (llllllllllllIlIlIIlIlIIlIlIIIIll < 0.0) {
                llllllllllllIlIlIIlIlIIlIlIIIIll = 0.0;
            }
            llllllllllllIlIlIIlIlIIlIlIIIIll *= llllllllllllIlIlIIlIlIIlIlIIIIll;
            this.fogColorRed *= (float)llllllllllllIlIlIIlIlIIlIlIIIIll;
            this.fogColorGreen *= (float)llllllllllllIlIlIIlIlIIlIlIIIIll;
            this.fogColorBlue *= (float)llllllllllllIlIlIIlIlIIlIlIIIIll;
        }
        if (this.bossColorModifier > 0.0f) {
            final float llllllllllllIlIlIIlIlIIlIlIIIIIl = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * llllllllllllIlIlIIlIlIIlIlIlllll;
            this.fogColorRed = this.fogColorRed * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIIl) + this.fogColorRed * 0.7f * llllllllllllIlIlIIlIlIIlIlIIIIIl;
            this.fogColorGreen = this.fogColorGreen * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIIl) + this.fogColorGreen * 0.6f * llllllllllllIlIlIIlIlIIlIlIIIIIl;
            this.fogColorBlue = this.fogColorBlue * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIIl) + this.fogColorBlue * 0.6f * llllllllllllIlIlIIlIlIIlIlIIIIIl;
        }
        if (llllllllllllIlIlIIlIlIIlIlIlllIl instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl).isPotionActive(MobEffects.NIGHT_VISION)) {
            final float llllllllllllIlIlIIlIlIIlIlIIIIII = this.getNightVisionBrightness((EntityLivingBase)llllllllllllIlIlIIlIlIIlIlIlllIl, llllllllllllIlIlIIlIlIIlIlIlllll);
            float llllllllllllIlIlIIlIlIIlIIllllll = 1.0f / this.fogColorRed;
            if (llllllllllllIlIlIIlIlIIlIIllllll > 1.0f / this.fogColorGreen) {
                llllllllllllIlIlIIlIlIIlIIllllll = 1.0f / this.fogColorGreen;
            }
            if (llllllllllllIlIlIIlIlIIlIIllllll > 1.0f / this.fogColorBlue) {
                llllllllllllIlIlIIlIlIIlIIllllll = 1.0f / this.fogColorBlue;
            }
            this.fogColorRed = this.fogColorRed * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIII) + this.fogColorRed * llllllllllllIlIlIIlIlIIlIIllllll * llllllllllllIlIlIIlIlIIlIlIIIIII;
            this.fogColorGreen = this.fogColorGreen * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIII) + this.fogColorGreen * llllllllllllIlIlIIlIlIIlIIllllll * llllllllllllIlIlIIlIlIIlIlIIIIII;
            this.fogColorBlue = this.fogColorBlue * (1.0f - llllllllllllIlIlIIlIlIIlIlIIIIII) + this.fogColorBlue * llllllllllllIlIlIIlIlIIlIIllllll * llllllllllllIlIlIIlIlIIlIlIIIIII;
        }
        if (this.mc.gameSettings.anaglyph) {
            final float llllllllllllIlIlIIlIlIIlIIlllllI = (this.fogColorRed * 30.0f + this.fogColorGreen * 59.0f + this.fogColorBlue * 11.0f) / 100.0f;
            final float llllllllllllIlIlIIlIlIIlIIllllIl = (this.fogColorRed * 30.0f + this.fogColorGreen * 70.0f) / 100.0f;
            final float llllllllllllIlIlIIlIlIIlIIllllII = (this.fogColorRed * 30.0f + this.fogColorBlue * 70.0f) / 100.0f;
            this.fogColorRed = llllllllllllIlIlIIlIlIIlIIlllllI;
            this.fogColorGreen = llllllllllllIlIlIIlIlIIlIIllllIl;
            this.fogColorBlue = llllllllllllIlIlIIlIlIIlIIllllII;
        }
        if (Reflector.EntityViewRenderEvent_FogColors_Constructor.exists()) {
            final Object llllllllllllIlIlIIlIlIIlIIlllIll = Reflector.newInstance(Reflector.EntityViewRenderEvent_FogColors_Constructor, new Object[] { this, llllllllllllIlIlIIlIlIIlIlIlllIl, llllllllllllIlIlIIlIlIIlIlIIllIl, llllllllllllIlIlIIlIlIIlIlIlllll, this.fogColorRed, this.fogColorGreen, this.fogColorBlue });
            Reflector.postForgeBusEvent(llllllllllllIlIlIIlIlIIlIIlllIll);
            this.fogColorRed = Reflector.callFloat(llllllllllllIlIlIIlIlIIlIIlllIll, Reflector.EntityViewRenderEvent_FogColors_getRed, new Object[0]);
            this.fogColorGreen = Reflector.callFloat(llllllllllllIlIlIIlIlIIlIIlllIll, Reflector.EntityViewRenderEvent_FogColors_getGreen, new Object[0]);
            this.fogColorBlue = Reflector.callFloat(llllllllllllIlIlIIlIlIIlIIlllIll, Reflector.EntityViewRenderEvent_FogColors_getBlue, new Object[0]);
        }
        Shaders.setClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0f);
    }
    
    private FloatBuffer setFogColorBuffer(final float llllllllllllIlIlIIlIlIIIlllllIll, final float llllllllllllIlIlIIlIlIIIlllllIlI, final float llllllllllllIlIlIIlIlIIIlllllllI, final float llllllllllllIlIlIIlIlIIIlllllIII) {
        if (Config.isShaders()) {
            Shaders.setFogColor(llllllllllllIlIlIIlIlIIIlllllIll, llllllllllllIlIlIIlIlIIIlllllIlI, llllllllllllIlIlIIlIlIIIlllllllI);
        }
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(llllllllllllIlIlIIlIlIIIlllllIll).put(llllllllllllIlIlIIlIlIIIlllllIlI).put(llllllllllllIlIlIIlIlIIIlllllllI).put(llllllllllllIlIlIIlIlIIIlllllIII);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }
    
    private void updateFovModifierHand() {
        float llllllllllllIlIlIIlIllIIIIIlIlIl = 1.0f;
        if (this.mc.getRenderViewEntity() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer llllllllllllIlIlIIlIllIIIIIlIlII = (AbstractClientPlayer)this.mc.getRenderViewEntity();
            llllllllllllIlIlIIlIllIIIIIlIlIl = llllllllllllIlIlIIlIllIIIIIlIlII.getFovModifier();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (llllllllllllIlIlIIlIllIIIIIlIlIl - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.1f) {
            this.fovModifierHand = 0.1f;
        }
    }
    
    public boolean setFxaaShader(final int llllllllllllIlIlIIlIlIIIlIlIlIlI) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            return false;
        }
        if (this.theShaderGroup != null && this.theShaderGroup != this.fxaaShaders[2] && this.theShaderGroup != this.fxaaShaders[4]) {
            return true;
        }
        if (llllllllllllIlIlIIlIlIIIlIlIlIlI != 2 && llllllllllllIlIlIIlIlIIIlIlIlIlI != 4) {
            if (this.theShaderGroup == null) {
                return true;
            }
            this.theShaderGroup.deleteShaderGroup();
            this.theShaderGroup = null;
            return true;
        }
        else {
            if (this.theShaderGroup != null && this.theShaderGroup == this.fxaaShaders[llllllllllllIlIlIIlIlIIIlIlIlIlI]) {
                return true;
            }
            if (this.mc.world == null) {
                return true;
            }
            this.loadShader(new ResourceLocation("shaders/post/fxaa_of_" + llllllllllllIlIlIIlIlIIIlIlIlIlI + "x.json"));
            this.fxaaShaders[llllllllllllIlIlIIlIlIIIlIlIlIlI] = this.theShaderGroup;
            return this.useShader;
        }
    }
    
    private void updateTorchFlicker() {
        this.torchFlickerDX += (float)((Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX *= (float)0.9;
        this.torchFlickerX += this.torchFlickerDX - this.torchFlickerX;
        this.lightmapUpdateNeeded = true;
    }
    
    private void addRainParticles() {
        float llllllllllllIlIlIIlIlIlIIIlIllIl = this.mc.world.getRainStrength(1.0f);
        if (!Config.isRainFancy()) {
            llllllllllllIlIlIIlIlIlIIIlIllIl /= 2.0f;
        }
        if (llllllllllllIlIlIIlIlIlIIIlIllIl != 0.0f && Config.isRainSplash()) {
            this.random.setSeed(this.rendererUpdateCount * 312987231L);
            final Entity llllllllllllIlIlIIlIlIlIIIlIllII = this.mc.getRenderViewEntity();
            final World llllllllllllIlIlIIlIlIlIIIlIlIll = this.mc.world;
            final BlockPos llllllllllllIlIlIIlIlIlIIIlIlIlI = new BlockPos(llllllllllllIlIlIIlIlIlIIIlIllII);
            final int llllllllllllIlIlIIlIlIlIIIlIlIIl = 10;
            double llllllllllllIlIlIIlIlIlIIIlIlIII = 0.0;
            double llllllllllllIlIlIIlIlIlIIIlIIlll = 0.0;
            double llllllllllllIlIlIIlIlIlIIIlIIllI = 0.0;
            int llllllllllllIlIlIIlIlIlIIIlIIlIl = 0;
            int llllllllllllIlIlIIlIlIlIIIlIIlII = (int)(100.0f * llllllllllllIlIlIIlIlIlIIIlIllIl * llllllllllllIlIlIIlIlIlIIIlIllIl);
            if (this.mc.gameSettings.particleSetting == 1) {
                llllllllllllIlIlIIlIlIlIIIlIIlII >>= 1;
            }
            else if (this.mc.gameSettings.particleSetting == 2) {
                llllllllllllIlIlIIlIlIlIIIlIIlII = 0;
            }
            for (int llllllllllllIlIlIIlIlIlIIIlIIIll = 0; llllllllllllIlIlIIlIlIlIIIlIIIll < llllllllllllIlIlIIlIlIlIIIlIIlII; ++llllllllllllIlIlIIlIlIlIIIlIIIll) {
                final BlockPos llllllllllllIlIlIIlIlIlIIIlIIIlI = llllllllllllIlIlIIlIlIlIIIlIlIll.getPrecipitationHeight(llllllllllllIlIlIIlIlIlIIIlIlIlI.add(this.random.nextInt(10) - this.random.nextInt(10), 0, this.random.nextInt(10) - this.random.nextInt(10)));
                final Biome llllllllllllIlIlIIlIlIlIIIlIIIIl = llllllllllllIlIlIIlIlIlIIIlIlIll.getBiome(llllllllllllIlIlIIlIlIlIIIlIIIlI);
                final BlockPos llllllllllllIlIlIIlIlIlIIIlIIIII = llllllllllllIlIlIIlIlIlIIIlIIIlI.down();
                final IBlockState llllllllllllIlIlIIlIlIlIIIIlllll = llllllllllllIlIlIIlIlIlIIIlIlIll.getBlockState(llllllllllllIlIlIIlIlIlIIIlIIIII);
                if (llllllllllllIlIlIIlIlIlIIIlIIIlI.getY() <= llllllllllllIlIlIIlIlIlIIIlIlIlI.getY() + 10 && llllllllllllIlIlIIlIlIlIIIlIIIlI.getY() >= llllllllllllIlIlIIlIlIlIIIlIlIlI.getY() - 10 && llllllllllllIlIlIIlIlIlIIIlIIIIl.canRain() && llllllllllllIlIlIIlIlIlIIIlIIIIl.getFloatTemperature(llllllllllllIlIlIIlIlIlIIIlIIIlI) >= 0.15f) {
                    final double llllllllllllIlIlIIlIlIlIIIIllllI = this.random.nextDouble();
                    final double llllllllllllIlIlIIlIlIlIIIIlllIl = this.random.nextDouble();
                    final AxisAlignedBB llllllllllllIlIlIIlIlIlIIIIlllII = llllllllllllIlIlIIlIlIlIIIIlllll.getBoundingBox(llllllllllllIlIlIIlIlIlIIIlIlIll, llllllllllllIlIlIIlIlIlIIIlIIIII);
                    if (llllllllllllIlIlIIlIlIlIIIIlllll.getMaterial() != Material.LAVA && llllllllllllIlIlIIlIlIlIIIIlllll.getBlock() != Blocks.MAGMA) {
                        if (llllllllllllIlIlIIlIlIlIIIIlllll.getMaterial() != Material.AIR) {
                            ++llllllllllllIlIlIIlIlIlIIIlIIlIl;
                            if (this.random.nextInt(llllllllllllIlIlIIlIlIlIIIlIIlIl) == 0) {
                                llllllllllllIlIlIIlIlIlIIIlIlIII = llllllllllllIlIlIIlIlIlIIIlIIIII.getX() + llllllllllllIlIlIIlIlIlIIIIllllI;
                                llllllllllllIlIlIIlIlIlIIIlIIlll = llllllllllllIlIlIIlIlIlIIIlIIIII.getY() + 0.1f + llllllllllllIlIlIIlIlIlIIIIlllII.maxY - 1.0;
                                llllllllllllIlIlIIlIlIlIIIlIIllI = llllllllllllIlIlIIlIlIlIIIlIIIII.getZ() + llllllllllllIlIlIIlIlIlIIIIlllIl;
                            }
                            this.mc.world.spawnParticle(EnumParticleTypes.WATER_DROP, llllllllllllIlIlIIlIlIlIIIlIIIII.getX() + llllllllllllIlIlIIlIlIlIIIIllllI, llllllllllllIlIlIIlIlIlIIIlIIIII.getY() + 0.1f + llllllllllllIlIlIIlIlIlIIIIlllII.maxY, llllllllllllIlIlIIlIlIlIIIlIIIII.getZ() + llllllllllllIlIlIIlIlIlIIIIlllIl, 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                    else {
                        this.mc.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllIlIlIIlIlIlIIIlIIIlI.getX() + llllllllllllIlIlIIlIlIlIIIIllllI, llllllllllllIlIlIIlIlIlIIIlIIIlI.getY() + 0.1f - llllllllllllIlIlIIlIlIlIIIIlllII.minY, llllllllllllIlIlIIlIlIlIIIlIIIlI.getZ() + llllllllllllIlIlIIlIlIlIIIIlllIl, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
            if (llllllllllllIlIlIIlIlIlIIIlIIlIl > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (llllllllllllIlIlIIlIlIlIIIlIIlll > llllllllllllIlIlIIlIlIlIIIlIlIlI.getY() + 1 && llllllllllllIlIlIIlIlIlIIIlIlIll.getPrecipitationHeight(llllllllllllIlIlIIlIlIlIIIlIlIlI).getY() > MathHelper.floor((float)llllllllllllIlIlIIlIlIlIIIlIlIlI.getY())) {
                    this.mc.world.playSound(llllllllllllIlIlIIlIlIlIIIlIlIII, llllllllllllIlIlIIlIlIlIIIlIIlll, llllllllllllIlIlIIlIlIlIIIlIIllI, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, 0.1f, 0.5f, false);
                }
                else {
                    this.mc.world.playSound(llllllllllllIlIlIIlIlIlIIIlIlIII, llllllllllllIlIlIIlIlIlIIIlIIlll, llllllllllllIlIlIIlIlIlIIIlIIllI, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 0.2f, 1.0f, false);
                }
            }
        }
    }
    
    private void setupFog(final int llllllllllllIlIlIIlIlIIlIIIllllI, final float llllllllllllIlIlIIlIlIIlIIIlIIlI) {
        if (Main.featureDirector.getFeatureByClass(NoRender.class).isToggled() && NoRender.fog.getBoolValue()) {
            return;
        }
        this.fogStandard = false;
        final Entity llllllllllllIlIlIIlIlIIlIIIlllII = this.mc.getRenderViewEntity();
        this.func_191514_d(false);
        GlStateManager.glNormal3f(0.0f, -1.0f, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final IBlockState llllllllllllIlIlIIlIlIIlIIIllIll = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, llllllllllllIlIlIIlIlIIlIIIlllII, llllllllllllIlIlIIlIlIIlIIIlIIlI);
        float llllllllllllIlIlIIlIlIIlIIIllIlI = -1.0f;
        if (Reflector.ForgeHooksClient_getFogDensity.exists()) {
            llllllllllllIlIlIIlIlIIlIIIllIlI = Reflector.callFloat(Reflector.ForgeHooksClient_getFogDensity, new Object[] { this, llllllllllllIlIlIIlIlIIlIIIlllII, llllllllllllIlIlIIlIlIIlIIIllIll, llllllllllllIlIlIIlIlIIlIIIlIIlI, 0.1f });
        }
        if (llllllllllllIlIlIIlIlIIlIIIllIlI >= 0.0f) {
            GlStateManager.setFogDensity(llllllllllllIlIlIIlIlIIlIIIllIlI);
        }
        else if (llllllllllllIlIlIIlIlIIlIIIlllII instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIlIlIIlIlIIlIIIlllII).isPotionActive(MobEffects.BLINDNESS)) {
            float llllllllllllIlIlIIlIlIIlIIIllIIl = 5.0f;
            final int llllllllllllIlIlIIlIlIIlIIIllIII = ((EntityLivingBase)llllllllllllIlIlIIlIlIIlIIIlllII).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            if (llllllllllllIlIlIIlIlIIlIIIllIII < 20) {
                llllllllllllIlIlIIlIlIIlIIIllIIl = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - llllllllllllIlIlIIlIlIIlIIIllIII / 20.0f);
            }
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.LINEAR);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.LINEAR);
            }
            if (llllllllllllIlIlIIlIlIIlIIIllllI == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(llllllllllllIlIlIIlIlIIlIIIllIIl * 0.8f);
            }
            else {
                GlStateManager.setFogStart(llllllllllllIlIlIIlIlIIlIIIllIIl * 0.25f);
                GlStateManager.setFogEnd(llllllllllllIlIlIIlIlIIlIIIllIIl);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance && Config.isFogFancy()) {
                GlStateManager.glFogi(34138, 34139);
            }
        }
        else if (this.cloudFog) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            GlStateManager.setFogDensity(0.1f);
        }
        else if (llllllllllllIlIlIIlIlIIlIIIllIll.getMaterial() == Material.WATER) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            if (llllllllllllIlIlIIlIlIIlIIIlllII instanceof EntityLivingBase) {
                if (((EntityLivingBase)llllllllllllIlIlIIlIlIIlIIIlllII).isPotionActive(MobEffects.WATER_BREATHING)) {
                    GlStateManager.setFogDensity(0.01f);
                }
                else {
                    GlStateManager.setFogDensity(0.1f - EnchantmentHelper.getRespirationModifier((EntityLivingBase)llllllllllllIlIlIIlIlIIlIIIlllII) * 0.03f);
                }
            }
            else {
                GlStateManager.setFogDensity(0.1f);
            }
            if (Config.isClearWater()) {
                GlStateManager.setFogDensity(0.02f);
            }
        }
        else if (llllllllllllIlIlIIlIlIIlIIIllIll.getMaterial() == Material.LAVA) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            GlStateManager.setFogDensity(2.0f);
        }
        else {
            final float llllllllllllIlIlIIlIlIIlIIIlIlll = this.farPlaneDistance;
            this.fogStandard = true;
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.LINEAR);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.LINEAR);
            }
            if (llllllllllllIlIlIIlIlIIlIIIllllI == -1) {
                GlStateManager.setFogStart(0.0f);
            }
            else {
                final float llllllllllllIlIlIIlIlIIlIIIlIllI = Main.featureDirector.getFeatureByClass(FogColor.class).isToggled() ? (-FogColor.distance.getNumberValue()) : Config.getFogStart();
                GlStateManager.setFogStart(llllllllllllIlIlIIlIlIIlIIIlIlll * llllllllllllIlIlIIlIlIIlIIIlIllI);
            }
            GlStateManager.setFogEnd(llllllllllllIlIlIIlIlIIlIIIlIlll);
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                if (Config.isFogFancy()) {
                    GlStateManager.glFogi(34138, 34139);
                }
                if (Config.isFogFast()) {
                    GlStateManager.glFogi(34138, 34140);
                }
            }
            if (this.mc.world.provider.doesXZShowFog((int)llllllllllllIlIlIIlIlIIlIIIlllII.posX, (int)llllllllllllIlIlIIlIlIIlIIIlllII.posZ) || this.mc.ingameGUI.getBossOverlay().shouldCreateFog()) {
                GlStateManager.setFogStart(llllllllllllIlIlIIlIlIIlIIIlIlll * 0.05f);
                GlStateManager.setFogEnd(llllllllllllIlIlIIlIlIIlIIIlIlll);
            }
            if (Reflector.ForgeHooksClient_onFogRender.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_onFogRender, new Object[] { this, llllllllllllIlIlIIlIlIIlIIIlllII, llllllllllllIlIlIIlIlIIlIIIllIll, llllllllllllIlIlIIlIlIIlIIIlIIlI, llllllllllllIlIlIIlIlIIlIIIllllI, llllllllllllIlIlIIlIlIIlIIIlIlll });
            }
        }
        final EventFogColor llllllllllllIlIlIIlIlIIlIIIlIlIl = new EventFogColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0);
        llllllllllllIlIlIIlIlIIlIIIlIlIl.call();
        this.fogColorRed = llllllllllllIlIlIIlIlIIlIIIlIlIl.red / 255.0f;
        this.fogColorGreen = llllllllllllIlIlIIlIlIIlIIIlIlIl.green / 255.0f;
        this.fogColorBlue = llllllllllllIlIlIIlIlIIlIIIlIlIl.blue / 255.0f;
        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial(1028, 4608);
    }
    
    public void updateRenderer() {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistancePrev = 4.0f;
        if (this.mc.gameSettings.smoothCamera) {
            final float llllllllllllIlIlIIlIllIIIllIllII = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float llllllllllllIlIlIIlIllIIIllIlIll = llllllllllllIlIlIIlIllIIIllIllII * llllllllllllIlIlIIlIllIIIllIllII * llllllllllllIlIlIIlIllIIIllIllII * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, 0.05f * llllllllllllIlIlIIlIllIIIllIlIll);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, 0.05f * llllllllllllIlIlIIlIllIIIllIlIll);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        }
        else {
            this.smoothCamFilterX = 0.0f;
            this.smoothCamFilterY = 0.0f;
            this.mouseFilterXAxis.reset();
            this.mouseFilterYAxis.reset();
        }
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.player);
        }
        final Entity llllllllllllIlIlIIlIllIIIllIlIlI = this.mc.getRenderViewEntity();
        final double llllllllllllIlIlIIlIllIIIllIlIIl = llllllllllllIlIlIIlIllIIIllIlIlI.posX;
        final double llllllllllllIlIlIIlIllIIIllIlIII = llllllllllllIlIlIIlIllIIIllIlIlI.posY + llllllllllllIlIlIIlIllIIIllIlIlI.getEyeHeight();
        final double llllllllllllIlIlIIlIllIIIllIIlll = llllllllllllIlIlIIlIllIIIllIlIlI.posZ;
        final float llllllllllllIlIlIIlIllIIIllIIllI = this.mc.world.getLightBrightness(new BlockPos(llllllllllllIlIlIIlIllIIIllIlIIl, llllllllllllIlIlIIlIllIIIllIlIII, llllllllllllIlIlIIlIllIIIllIIlll));
        float llllllllllllIlIlIIlIllIIIllIIlIl = this.mc.gameSettings.renderDistanceChunks / 16.0f;
        llllllllllllIlIlIIlIllIIIllIIlIl = MathHelper.clamp(llllllllllllIlIlIIlIllIIIllIIlIl, 0.0f, 1.0f);
        final float llllllllllllIlIlIIlIllIIIllIIlII = llllllllllllIlIlIIlIllIIIllIIllI * (1.0f - llllllllllllIlIlIIlIllIIIllIIlIl) + llllllllllllIlIlIIlIllIIIllIIlIl;
        this.fogColor1 += (llllllllllllIlIlIIlIllIIIllIIlII - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;
        if (this.mc.ingameGUI.getBossOverlay().shouldDarkenSky()) {
            this.bossColorModifier += 0.05f;
            if (this.bossColorModifier > 1.0f) {
                this.bossColorModifier = 1.0f;
            }
        }
        else if (this.bossColorModifier > 0.0f) {
            this.bossColorModifier -= 0.0125f;
        }
        if (this.field_190567_ac > 0) {
            --this.field_190567_ac;
            if (this.field_190567_ac == 0) {
                this.field_190566_ab = null;
            }
        }
    }
    
    private float getFOVModifier(final float llllllllllllIlIlIIlIllIIIIIIlIII, final boolean llllllllllllIlIlIIlIlIlllllllllI) {
        if (this.debugView) {
            return 90.0f;
        }
        final Entity llllllllllllIlIlIIlIllIIIIIIIllI = this.mc.getRenderViewEntity();
        float llllllllllllIlIlIIlIllIIIIIIIlIl = 70.0f;
        if (llllllllllllIlIlIIlIlIlllllllllI) {
            llllllllllllIlIlIIlIllIIIIIIIlIl = this.mc.gameSettings.fovSetting;
            if (Config.isDynamicFov()) {
                llllllllllllIlIlIIlIllIIIIIIIlIl *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * llllllllllllIlIlIIlIllIIIIIIlIII;
            }
        }
        boolean llllllllllllIlIlIIlIllIIIIIIIlII = false;
        if (this.mc.currentScreen == null) {
            final GameSettings llllllllllllIlIlIIlIllIIIIIIIIll = this.mc.gameSettings;
            llllllllllllIlIlIIlIllIIIIIIIlII = GameSettings.isKeyDown(this.mc.gameSettings.ofKeyBindZoom);
        }
        if (llllllllllllIlIlIIlIllIIIIIIIlII) {
            if (!Config.zoomMode) {
                Config.zoomMode = true;
                this.mc.gameSettings.smoothCamera = true;
                this.mc.renderGlobal.displayListEntitiesDirty = true;
            }
            if (Config.zoomMode && this.scopeMath < 5.0f) {
                this.scopeMath += (float)(2.0 * Feature.deltaTime());
            }
        }
        else {
            if (this.scopeMath > 1.0f) {
                this.scopeMath -= (float)(3.0 * Feature.deltaTime());
            }
            if (Config.zoomMode) {
                Config.zoomMode = false;
                this.mc.gameSettings.smoothCamera = false;
                this.mouseFilterXAxis = new MouseFilter();
                this.mouseFilterYAxis = new MouseFilter();
                this.mc.renderGlobal.displayListEntitiesDirty = true;
            }
        }
        llllllllllllIlIlIIlIllIIIIIIIlIl /= this.scopeMath;
        if (llllllllllllIlIlIIlIllIIIIIIIllI instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIlIlIIlIllIIIIIIIllI).getHealth() <= 0.0f) {
            final float llllllllllllIlIlIIlIllIIIIIIIIlI = ((EntityLivingBase)llllllllllllIlIlIIlIllIIIIIIIllI).deathTime + llllllllllllIlIlIIlIllIIIIIIlIII;
            llllllllllllIlIlIIlIllIIIIIIIlIl /= (1.0f - 500.0f / (llllllllllllIlIlIIlIllIIIIIIIIlI + 500.0f)) * 2.0f + 1.0f;
        }
        final IBlockState llllllllllllIlIlIIlIllIIIIIIIIIl = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, llllllllllllIlIlIIlIllIIIIIIIllI, llllllllllllIlIlIIlIllIIIIIIlIII);
        if (llllllllllllIlIlIIlIllIIIIIIIIIl.getMaterial() == Material.WATER) {
            llllllllllllIlIlIIlIllIIIIIIIlIl = llllllllllllIlIlIIlIllIIIIIIIlIl * 60.0f / 70.0f;
        }
        return Reflector.ForgeHooksClient_getFOVModifier.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getFOVModifier, new Object[] { this, llllllllllllIlIlIIlIllIIIIIIIllI, llllllllllllIlIlIIlIllIIIIIIIIIl, llllllllllllIlIlIIlIllIIIIIIlIII, llllllllllllIlIlIIlIllIIIIIIIlIl }) : llllllllllllIlIlIIlIllIIIIIIIlIl;
    }
    
    public void func_190564_k() {
        this.field_190566_ab = null;
        this.theMapItemRenderer.clearLoadedMaps();
    }
    
    public void setupOverlayRendering() {
        final ScaledResolution llllllllllllIlIlIIlIlIIlIlllIllI = new ScaledResolution(this.mc);
        GlStateManager.clear(256);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, llllllllllllIlIlIIlIlIIlIlllIllI.getScaledWidth_double(), llllllllllllIlIlIIlIlIIlIlllIllI.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }
    
    private void hurtCameraEffect(final float llllllllllllIlIlIIlIlIlllllIllIl) {
        if (this.mc.getRenderViewEntity() instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllllIlIlIIlIlIllllllIIlI = (EntityLivingBase)this.mc.getRenderViewEntity();
            float llllllllllllIlIlIIlIlIllllllIIIl = llllllllllllIlIlIIlIlIllllllIIlI.hurtTime - llllllllllllIlIlIIlIlIlllllIllIl;
            if (llllllllllllIlIlIIlIlIllllllIIlI.getHealth() <= 0.0f) {
                final float llllllllllllIlIlIIlIlIllllllIIII = llllllllllllIlIlIIlIlIllllllIIlI.deathTime + llllllllllllIlIlIIlIlIlllllIllIl;
                GlStateManager.rotate(40.0f - 8000.0f / (llllllllllllIlIlIIlIlIllllllIIII + 200.0f), 0.0f, 0.0f, 1.0f);
            }
            if (llllllllllllIlIlIIlIlIllllllIIIl < 0.0f) {
                return;
            }
            llllllllllllIlIlIIlIlIllllllIIIl /= llllllllllllIlIlIIlIlIllllllIIlI.maxHurtTime;
            llllllllllllIlIlIIlIlIllllllIIIl = MathHelper.sin(llllllllllllIlIlIIlIlIllllllIIIl * llllllllllllIlIlIIlIlIllllllIIIl * llllllllllllIlIlIIlIlIllllllIIIl * llllllllllllIlIlIIlIlIllllllIIIl * 3.1415927f);
            final float llllllllllllIlIlIIlIlIlllllIllll = llllllllllllIlIlIIlIlIllllllIIlI.attackedAtYaw;
            GlStateManager.rotate(-llllllllllllIlIlIIlIlIlllllIllll, 0.0f, 1.0f, 0.0f);
            if (NoRender.hurtcam.getBoolValue() && Main.featureDirector.getFeatureByClass(NoRender.class).isToggled()) {
                GlStateManager.rotate(-llllllllllllIlIlIIlIlIllllllIIIl * 0.0f, 0.0f, 0.0f, 1.0f);
            }
            else {
                GlStateManager.rotate(-llllllllllllIlIlIIlIlIllllllIIIl * 14.0f, 0.0f, 0.0f, 1.0f);
            }
            GlStateManager.rotate(llllllllllllIlIlIIlIlIlllllIllll, 0.0f, 1.0f, 0.0f);
        }
    }
    
    private void renderCloudsCheck(final RenderGlobal llllllllllllIlIlIIlIlIlIIlIIlllI, final float llllllllllllIlIlIIlIlIlIIlIIIllI, final int llllllllllllIlIlIIlIlIlIIlIIllII, final double llllllllllllIlIlIIlIlIlIIlIIIlII, final double llllllllllllIlIlIIlIlIlIIlIIIIll, final double llllllllllllIlIlIIlIlIlIIlIIIIlI) {
        if (this.mc.gameSettings.renderDistanceChunks >= 4 && !Config.isCloudsOff() && Shaders.shouldRenderClouds(this.mc.gameSettings)) {
            this.mc.mcProfiler.endStartSection("clouds");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIlIIlIIIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance * 4.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            this.setupFog(0, llllllllllllIlIlIIlIlIlIIlIIIllI);
            llllllllllllIlIlIIlIlIlIIlIIlllI.renderClouds(llllllllllllIlIlIIlIlIlIIlIIIllI, llllllllllllIlIlIIlIlIlIIlIIllII, llllllllllllIlIlIIlIlIlIIlIIIlII, llllllllllllIlIlIIlIlIlIIlIIIIll, llllllllllllIlIlIIlIlIlIIlIIIIlI);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(llllllllllllIlIlIIlIlIlIIlIIIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
    }
}
