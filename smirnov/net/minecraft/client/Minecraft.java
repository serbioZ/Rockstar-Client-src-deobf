// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client;

import net.minecraft.client.gui.GuiIngameMenu;
import java.util.concurrent.Executors;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.gui.ScreenChatOptions;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.client.gui.GuiControls;
import java.text.DecimalFormat;
import org.apache.commons.io.IOUtils;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.MinecraftError;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import java.nio.IntBuffer;
import com.mojang.authlib.AuthenticationService;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.util.ISearchTree;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.client.gui.GuiSleepMP;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.io.InputStream;
import org.lwjgl.opengl.OpenGLException;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.resources.FoliageColorReloadListener;
import net.minecraft.client.resources.GrassColorReloadListener;
import ru.rockstar.api.utils.font.FontUtil;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.text.TextComponentKeybind;
import java.util.Locale;
import javax.imageio.ImageIO;
import com.google.common.collect.Queues;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.event.event.EventMouseKey;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.Futures;
import org.apache.commons.lang3.Validate;
import java.util.concurrent.Callable;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.opengl.ContextCapabilities;
import org.apache.commons.io.Charsets;
import com.google.common.hash.Hashing;
import org.lwjgl.opengl.GLContext;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.SocketAddress;
import net.minecraft.crash.CrashReportCategory;
import com.mojang.authlib.GameProfileRepository;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.INetHandler;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.resources.I18n;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.server.management.PlayerProfileCache;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.util.UUID;
import net.minecraft.world.storage.WorldInfo;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.misc.FastWorldLoad;
import net.minecraft.world.WorldSettings;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.IMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import net.minecraft.client.util.RecipeBookClient;
import java.util.function.Consumer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.NonNullList;
import net.minecraft.client.util.SearchTree;
import java.util.function.Function;
import net.minecraft.util.text.TextFormatting;
import com.mojang.authlib.GameProfile;
import com.google.common.collect.Multimap;
import ru.rockstar.api.event.event.EventKey;
import net.minecraft.util.ReportedException;
import org.lwjgl.util.glu.GLU;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Bootstrap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.Sets;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import ru.rockstar.api.event.event.EventAttackClient;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import java.io.IOException;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Util;
import org.lwjgl.opengl.PixelFormat;
import ru.rockstar.Main;
import org.lwjgl.Sys;
import org.lwjgl.LWJGLException;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMainMenu;
import java.nio.ByteOrder;
import net.minecraft.server.MinecraftServer;
import org.lwjgl.opengl.Display;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.item.Item;
import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import java.util.stream.Stream;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.settings.CreativeSettings;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.Session;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.profiler.Snooper;
import net.minecraft.crash.CrashReport;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.renderer.texture.TextureMap;
import java.util.concurrent.FutureTask;
import java.util.Queue;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.Timer;
import java.net.Proxy;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.client.multiplayer.ServerData;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.MouseHelper;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.renderer.EntityRenderer;
import javax.annotation.Nullable;
import net.minecraft.client.gui.GuiScreen;
import com.mojang.authlib.properties.PropertyMap;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.FrameTimer;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.profiler.Profiler;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.entity.EntityPlayerSP;
import java.io.File;
import org.lwjgl.opengl.DisplayMode;
import java.util.List;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.renderer.block.model.ModelManager;
import ru.rockstar.api.utils.font.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.IThreadListener;
import net.minecraft.profiler.ISnooperInfo;

public class Minecraft implements ISnooperInfo, IThreadListener
{
    private final /* synthetic */ String launchedVersion;
    public /* synthetic */ RenderGlobal renderGlobal;
    volatile /* synthetic */ boolean running;
    public /* synthetic */ FontRenderer neverlose500_15;
    public /* synthetic */ FontRenderer neverlose500_20;
    private /* synthetic */ ModelManager modelManager;
    public /* synthetic */ FontRenderer urwgeometric;
    /* synthetic */ long systemTime;
    public /* synthetic */ FontRenderer comicsans_14;
    public /* synthetic */ FontRenderer elegant_20;
    private final /* synthetic */ GuiToast field_193034_aS;
    private /* synthetic */ int leftClickCounter;
    private static final /* synthetic */ ResourceLocation LOCATION_MOJANG_PNG;
    public /* synthetic */ FontRenderer stylesicons_14;
    public /* synthetic */ FontRenderer mntsb_16;
    public /* synthetic */ IReloadableResourceManager mcResourceManager;
    public /* synthetic */ FontRenderer comicsans_30;
    private final /* synthetic */ MinecraftSessionService sessionService;
    public /* synthetic */ int displayWidth;
    private static final /* synthetic */ List<DisplayMode> MAC_DISPLAY_MODES;
    public /* synthetic */ int displayHeight;
    private final /* synthetic */ boolean isDemo;
    private final /* synthetic */ File fileAssets;
    public /* synthetic */ EntityPlayerSP player;
    public /* synthetic */ FontRenderer neverlose500_19;
    public /* synthetic */ FontRenderer robotoRegular;
    public /* synthetic */ WorldClient world;
    public /* synthetic */ boolean inGameHasFocus;
    public /* synthetic */ FontRenderer lato15;
    public /* synthetic */ FontRenderer neverlose500_17;
    private static /* synthetic */ int debugFPS;
    public /* synthetic */ FontRenderer comicsans_18;
    public /* synthetic */ LoadingScreenRenderer loadingScreen;
    public /* synthetic */ FontRenderer elegant_30;
    public /* synthetic */ FontRenderer comicsans_15;
    public final /* synthetic */ File mcDataDir;
    private /* synthetic */ RenderItem renderItem;
    private /* synthetic */ BlockRendererDispatcher blockRenderDispatcher;
    public /* synthetic */ FontRenderer elegant_18;
    public final /* synthetic */ Profiler mcProfiler;
    private final /* synthetic */ Tutorial field_193035_aW;
    public /* synthetic */ FontRenderer comicsans_19;
    public /* synthetic */ RayTraceResult objectMouseOver;
    public /* synthetic */ LanguageManager mcLanguageManager;
    public final /* synthetic */ FrameTimer frameTimer;
    private /* synthetic */ int joinPlayerCounter;
    public /* synthetic */ int rightClickDelayTimer;
    private static /* synthetic */ Minecraft theMinecraft;
    private final /* synthetic */ DataFixer dataFixer;
    private /* synthetic */ ResourcePackRepository mcResourcePackRepository;
    public static /* synthetic */ net.minecraft.client.gui.FontRenderer fontRendererObj;
    private final /* synthetic */ String versionType;
    private final /* synthetic */ PropertyMap profileProperties;
    public /* synthetic */ FontRenderer neverlose500_13;
    private /* synthetic */ long debugCrashKeyPressTime;
    private /* synthetic */ boolean actionKeyF3;
    @Nullable
    public /* synthetic */ GuiScreen currentScreen;
    public /* synthetic */ EntityRenderer entityRenderer;
    private /* synthetic */ String debugProfilerName;
    public /* synthetic */ FontRenderer neverlose500_18;
    private final /* synthetic */ List<IResourcePack> defaultResourcePacks;
    public /* synthetic */ MouseHelper mouseHelper;
    private final /* synthetic */ MetadataSerializer metadataSerializer_;
    @Nullable
    private /* synthetic */ NetworkManager myNetworkManager;
    @Nullable
    public /* synthetic */ Entity renderViewEntity;
    private /* synthetic */ SoundHandler mcSoundHandler;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type;
    public /* synthetic */ FontRenderer icons2_18;
    public /* synthetic */ boolean skipRenderWorld;
    private /* synthetic */ boolean fullscreen;
    private final /* synthetic */ Thread mcThread;
    public /* synthetic */ FontRenderer comicsans_20;
    private final /* synthetic */ int tempDisplayWidth;
    public /* synthetic */ FontRenderer mntsb_18;
    @Nullable
    private /* synthetic */ IntegratedServer theIntegratedServer;
    public /* synthetic */ ParticleManager effectRenderer;
    public /* synthetic */ FontRenderer icons_30;
    public /* synthetic */ boolean renderChunksMany;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ FontRenderer comicsans_17;
    private /* synthetic */ ServerData currentServerData;
    /* synthetic */ long startNanoTime;
    private /* synthetic */ SearchTreeManager field_193995_ae;
    public /* synthetic */ FontRenderer comicsans_16;
    private /* synthetic */ float field_193996_ah;
    public /* synthetic */ FontRenderer icons2_30;
    public static final /* synthetic */ boolean IS_RUNNING_ON_MAC;
    public /* synthetic */ DebugRenderer debugRenderer;
    private final /* synthetic */ Proxy proxy;
    private /* synthetic */ boolean hasCrashed;
    private /* synthetic */ boolean connectedToRealms;
    public final /* synthetic */ Timer timer;
    private /* synthetic */ int serverPort;
    public /* synthetic */ FontRenderer icons_20;
    public /* synthetic */ FontRenderer sfui16;
    public /* synthetic */ net.minecraft.client.gui.FontRenderer standardGalacticFontRenderer;
    public /* synthetic */ TextureManager renderEngine;
    public /* synthetic */ FontRenderer icons2_15;
    public /* synthetic */ FontRenderer icons2_17;
    private final /* synthetic */ Queue<FutureTask<?>> scheduledTasks;
    private /* synthetic */ TextureMap textureMapBlocks;
    private /* synthetic */ MusicTicker mcMusicTicker;
    private /* synthetic */ SkinManager skinManager;
    /* synthetic */ long prevFrameTime;
    private /* synthetic */ String serverName;
    private /* synthetic */ ResourceLocation mojangLogo;
    private /* synthetic */ int fpsCounter;
    public /* synthetic */ FontRenderer mntsb_19;
    private /* synthetic */ ItemColors itemColors;
    public /* synthetic */ FontRenderer icons2_20;
    public /* synthetic */ FontRenderer sfui18;
    private /* synthetic */ CrashReport crashReporter;
    public static /* synthetic */ double frameTime;
    private final /* synthetic */ boolean jvm64bit;
    public /* synthetic */ FontRenderer mntsb_30;
    private final /* synthetic */ Snooper usageSnooper;
    public /* synthetic */ FontRenderer mntsb_20;
    private final /* synthetic */ PropertyMap twitchDetails;
    private final /* synthetic */ int tempDisplayHeight;
    public /* synthetic */ PlayerControllerMP playerController;
    private /* synthetic */ ItemRenderer itemRenderer;
    public /* synthetic */ FontRenderer mntsb_17;
    public /* synthetic */ RenderManager renderManager;
    private final /* synthetic */ File fileResourcepacks;
    public /* synthetic */ FontRenderer icons2_19;
    public /* synthetic */ Session session;
    private /* synthetic */ boolean integratedServerIsRunning;
    private /* synthetic */ Framebuffer framebufferMc;
    public /* synthetic */ FontRenderer neverlose500_16;
    public /* synthetic */ CreativeSettings field_191950_u;
    public static /* synthetic */ byte[] memoryReserve;
    public /* synthetic */ FontRenderer lato;
    private /* synthetic */ BlockColors blockColors;
    public /* synthetic */ GameSettings gameSettings;
    public /* synthetic */ FontRenderer mntsb_15;
    private final /* synthetic */ DefaultResourcePack mcDefaultResourcePack;
    private /* synthetic */ ISaveFormat saveLoader;
    public /* synthetic */ String debug;
    public /* synthetic */ FontRenderer neverlose500_14;
    public /* synthetic */ FontRenderer icons2_16;
    public /* synthetic */ FontRenderer makslol;
    private /* synthetic */ boolean isGamePaused;
    public /* synthetic */ GuiIngame ingameGUI;
    public /* synthetic */ FontRenderer mntsb;
    private /* synthetic */ long debugUpdateTime;
    
    public SkinManager getSkinManager() {
        return this.skinManager;
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lllllllllllIlllIIIlllIIlllllllll) {
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("fps", Minecraft.debugFPS);
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("vsync_enabled", this.gameSettings.enableVsync);
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("display_frequency", Display.getDisplayMode().getFrequency());
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("display_type", this.fullscreen ? "fullscreen" : "windowed");
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("run_time", (MinecraftServer.getCurrentTimeMillis() - lllllllllllIlllIIIlllIIlllllllll.getMinecraftStartTimeMillis()) / 60L * 1000L);
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("current_action", this.getCurrentAction());
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("language", (this.gameSettings.language == null) ? "en_us" : this.gameSettings.language);
        final String lllllllllllIlllIIIlllIlIIIIIIIll = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) ? "little" : "big";
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("endianness", lllllllllllIlllIIIlllIlIIIIIIIll);
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("subtitles", this.gameSettings.showSubtitles);
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("touch", this.gameSettings.touchscreen ? "touch" : "mouse");
        lllllllllllIlllIIIlllIIlllllllll.addClientStat("resource_packs", this.mcResourcePackRepository.getRepositoryEntries().size());
        int lllllllllllIlllIIIlllIlIIIIIIIlI = 0;
        for (final ResourcePackRepository.Entry lllllllllllIlllIIIlllIlIIIIIIIIl : this.mcResourcePackRepository.getRepositoryEntries()) {
            lllllllllllIlllIIIlllIIlllllllll.addClientStat("resource_pack[" + lllllllllllIlllIIIlllIlIIIIIIIlI++ + "]", lllllllllllIlllIIIlllIlIIIIIIIIl.getResourcePackName());
        }
        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null) {
            lllllllllllIlllIIIlllIIlllllllll.addClientStat("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }
    
    public Session getSession() {
        return this.session;
    }
    
    public void updateDisplay() {
        this.mcProfiler.startSection("display_update");
        Display.update();
        this.mcProfiler.endSection();
        this.checkWindowResize();
    }
    
    public void displayGuiScreen(@Nullable GuiScreen lllllllllllIlllIIIlllIllllIlllll) {
        if (this.currentScreen != null) {
            this.currentScreen.onGuiClosed();
        }
        if (lllllllllllIlllIIIlllIllllIlllll == null && this.world == null) {
            lllllllllllIlllIIIlllIllllIlllll = new GuiMainMenu();
        }
        else if (lllllllllllIlllIIIlllIllllIlllll == null && this.player.getHealth() <= 0.0f) {
            lllllllllllIlllIIIlllIllllIlllll = new GuiGameOver(null);
        }
        if (lllllllllllIlllIIIlllIllllIlllll instanceof GuiMainMenu || lllllllllllIlllIIIlllIllllIlllll instanceof GuiMultiplayer) {
            this.gameSettings.showDebugInfo = false;
            this.ingameGUI.getChatGUI().clearChatMessages(true);
        }
        if ((this.currentScreen = (GuiScreen)lllllllllllIlllIIIlllIllllIlllll) != null) {
            this.setIngameNotInFocus();
            KeyBinding.unPressAllKeys();
            while (Mouse.next()) {}
            while (Keyboard.next()) {}
            final ScaledResolution lllllllllllIlllIIIlllIlllllIIIll = new ScaledResolution(this);
            final int lllllllllllIlllIIIlllIlllllIIIlI = lllllllllllIlllIIIlllIlllllIIIll.getScaledWidth();
            final int lllllllllllIlllIIIlllIlllllIIIIl = lllllllllllIlllIIIlllIlllllIIIll.getScaledHeight();
            ((GuiScreen)lllllllllllIlllIIIlllIllllIlllll).setWorldAndResolution(this, lllllllllllIlllIIIlllIlllllIIIlI, lllllllllllIlllIIIlllIlllllIIIIl);
            this.skipRenderWorld = false;
        }
        else {
            this.mcSoundHandler.resumeSounds();
            this.setIngameFocus();
        }
    }
    
    private void setInitialDisplayMode() throws LWJGLException {
        if (this.fullscreen) {
            Display.setFullscreen(true);
            final DisplayMode lllllllllllIlllIIIllllIIlIllIIll = Display.getDisplayMode();
            this.displayWidth = Math.max(1, lllllllllllIlllIIIllllIIlIllIIll.getWidth());
            this.displayHeight = Math.max(1, lllllllllllIlllIIIllllIIlIllIIll.getHeight());
        }
        else {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
    }
    
    public boolean isGamePaused() {
        return this.isGamePaused;
    }
    
    public static long getSystemTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }
    
    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle("Loading " + Main.instance.name + " " + Main.instance.version);
        try {
            Display.create(new PixelFormat().withDepthBits(24));
        }
        catch (LWJGLException lllllllllllIlllIIIllllIIlIlllIlI) {
            Minecraft.LOGGER.error("Couldn't set pixel format", (Throwable)lllllllllllIlllIIIllllIIlIlllIlI);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex) {}
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }
    
    private void runGameLoop() throws IOException {
        final long lllllllllllIlllIIIlllIllllIIIIll = System.nanoTime();
        this.mcProfiler.startSection("root");
        if (Display.isCreated() && Display.isCloseRequested()) {
            this.shutdown();
        }
        this.timer.updateTimer();
        this.mcProfiler.startSection("scheduledExecutables");
        synchronized (this.scheduledTasks) {
            while (!this.scheduledTasks.isEmpty()) {
                Util.runTask(this.scheduledTasks.poll(), Minecraft.LOGGER);
            }
        }
        // monitorexit(this.scheduledTasks)
        this.mcProfiler.endSection();
        final long lllllllllllIlllIIIlllIllllIIIIlI = System.nanoTime();
        this.mcProfiler.startSection("tick");
        for (int lllllllllllIlllIIIlllIllllIIIIIl = 0; lllllllllllIlllIIIlllIllllIIIIIl < Math.min(10, this.timer.elapsedTicks); ++lllllllllllIlllIIIlllIllllIIIIIl) {
            this.runTick();
        }
        this.mcProfiler.endStartSection("preRenderErrors");
        final long lllllllllllIlllIIIlllIllllIIIIII = System.nanoTime() - lllllllllllIlllIIIlllIllllIIIIlI;
        this.checkGLError("Pre render");
        this.mcProfiler.endStartSection("sound");
        this.mcSoundHandler.setListener(this.player, this.timer.elapsedPartialTicks);
        this.mcProfiler.endSection();
        this.mcProfiler.startSection("render");
        GlStateManager.pushMatrix();
        GlStateManager.clear(16640);
        this.framebufferMc.bindFramebuffer(true);
        this.mcProfiler.startSection("display");
        GlStateManager.enableTexture2D();
        this.mcProfiler.endSection();
        if (!this.skipRenderWorld) {
            this.mcProfiler.endStartSection("gameRenderer");
            this.entityRenderer.updateCameraAndRender(this.isGamePaused ? this.field_193996_ah : this.timer.elapsedPartialTicks, lllllllllllIlllIIIlllIllllIIIIll);
            this.mcProfiler.endStartSection("toasts");
            this.field_193034_aS.func_191783_a(new ScaledResolution(this));
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart && !this.gameSettings.hideGUI) {
            if (!this.mcProfiler.profilingEnabled) {
                this.mcProfiler.clearProfiling();
            }
            this.mcProfiler.profilingEnabled = true;
            this.displayDebugInfo(lllllllllllIlllIIIlllIllllIIIIII);
        }
        else {
            this.mcProfiler.profilingEnabled = false;
            this.prevFrameTime = System.nanoTime();
        }
        this.framebufferMc.unbindFramebuffer();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.framebufferMc.framebufferRender(this.displayWidth, this.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.entityRenderer.renderStreamIndicator(this.timer.elapsedPartialTicks);
        GlStateManager.popMatrix();
        this.mcProfiler.startSection("root");
        this.updateDisplay();
        Thread.yield();
        this.checkGLError("Post render");
        ++this.fpsCounter;
        final boolean lllllllllllIlllIIIlllIlllIllllll = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic();
        if (this.isGamePaused != lllllllllllIlllIIIlllIlllIllllll) {
            if (this.isGamePaused) {
                this.field_193996_ah = this.timer.elapsedPartialTicks;
            }
            else {
                this.timer.elapsedPartialTicks = this.field_193996_ah;
            }
            this.isGamePaused = lllllllllllIlllIIIlllIlllIllllll;
        }
        final long lllllllllllIlllIIIlllIlllIlllllI = System.nanoTime();
        this.frameTimer.addFrame(lllllllllllIlllIIIlllIlllIlllllI - this.startNanoTime);
        this.startNanoTime = lllllllllllIlllIIIlllIlllIlllllI;
        while (getSystemTime() >= this.debugUpdateTime + 1000L) {
            Minecraft.debugFPS = this.fpsCounter;
            this.debug = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", Minecraft.debugFPS, RenderChunk.renderChunksUpdated, (RenderChunk.renderChunksUpdated == 1) ? "" : "s", (this.gameSettings.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax()) ? "inf" : Integer.valueOf(this.gameSettings.limitFramerate), this.gameSettings.enableVsync ? " vsync" : "", this.gameSettings.fancyGraphics ? "" : " fast", (this.gameSettings.clouds == 0) ? "" : ((this.gameSettings.clouds == 1) ? " fast-clouds" : " fancy-clouds"), OpenGlHelper.useVbo() ? " vbo" : "");
            RenderChunk.renderChunksUpdated = 0;
            this.debugUpdateTime += 1000L;
            this.fpsCounter = 0;
            this.usageSnooper.addMemoryStatsToSnooper();
            if (!this.usageSnooper.isSnooperRunning()) {
                this.usageSnooper.startSnooper();
            }
        }
        if (this.isFramerateLimitBelowMax()) {
            this.mcProfiler.startSection("fpslimit_wait");
            Display.sync(this.getLimitFramerate());
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
        Minecraft.frameTime = (System.nanoTime() - lllllllllllIlllIIIlllIllllIIIIll) / 1000000.0;
    }
    
    private void rightClickMouse() {
        if (!this.playerController.getIsHittingBlock()) {
            this.rightClickDelayTimer = 4;
            if (!this.player.isRowingBoat()) {
                if (this.objectMouseOver == null) {
                    Minecraft.LOGGER.warn("Null returned as 'hitResult', this shouldn't happen!");
                }
                final String lllllllllllIlllIIIlllIllIIIllIII;
                final short lllllllllllIlllIIIlllIllIIIllIIl = (short)((EnumHand[])(Object)(lllllllllllIlllIIIlllIllIIIllIII = (String)(Object)EnumHand.values())).length;
                for (boolean lllllllllllIlllIIIlllIllIIIllIlI = false; (lllllllllllIlllIIIlllIllIIIllIlI ? 1 : 0) < lllllllllllIlllIIIlllIllIIIllIIl; ++lllllllllllIlllIIIlllIllIIIllIlI) {
                    final EnumHand lllllllllllIlllIIIlllIllIIlIIIIl = lllllllllllIlllIIIlllIllIIIllIII[lllllllllllIlllIIIlllIllIIIllIlI];
                    final ItemStack lllllllllllIlllIIIlllIllIIlIIIII = this.player.getHeldItem(lllllllllllIlllIIIlllIllIIlIIIIl);
                    if (this.objectMouseOver != null) {
                        switch ($SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type()[this.objectMouseOver.typeOfHit.ordinal()]) {
                            case 3: {
                                if (this.playerController.interactWithEntity(this.player, this.objectMouseOver.entityHit, this.objectMouseOver, lllllllllllIlllIIIlllIllIIlIIIIl) == EnumActionResult.SUCCESS) {
                                    return;
                                }
                                if (this.playerController.interactWithEntity(this.player, this.objectMouseOver.entityHit, lllllllllllIlllIIIlllIllIIlIIIIl) == EnumActionResult.SUCCESS) {
                                    return;
                                }
                                break;
                            }
                            case 2: {
                                final BlockPos lllllllllllIlllIIIlllIllIIIlllll = this.objectMouseOver.getBlockPos();
                                if (this.world.getBlockState(lllllllllllIlllIIIlllIllIIIlllll).getMaterial() == Material.AIR) {
                                    break;
                                }
                                final int lllllllllllIlllIIIlllIllIIIllllI = lllllllllllIlllIIIlllIllIIlIIIII.func_190916_E();
                                final EnumActionResult lllllllllllIlllIIIlllIllIIIlllIl = this.playerController.processRightClickBlock(this.player, this.world, lllllllllllIlllIIIlllIllIIIlllll, this.objectMouseOver.sideHit, this.objectMouseOver.hitVec, lllllllllllIlllIIIlllIllIIlIIIIl);
                                if (lllllllllllIlllIIIlllIllIIIlllIl == EnumActionResult.SUCCESS) {
                                    this.player.swingArm(lllllllllllIlllIIIlllIllIIlIIIIl);
                                    if (!lllllllllllIlllIIIlllIllIIlIIIII.func_190926_b() && (lllllllllllIlllIIIlllIllIIlIIIII.func_190916_E() != lllllllllllIlllIIIlllIllIIIllllI || this.playerController.isInCreativeMode())) {
                                        this.entityRenderer.itemRenderer.resetEquippedProgress(lllllllllllIlllIIIlllIllIIlIIIIl);
                                    }
                                    return;
                                }
                                break;
                            }
                        }
                    }
                    if (!lllllllllllIlllIIIlllIllIIlIIIII.func_190926_b() && this.playerController.processRightClick(this.player, this.world, lllllllllllIlllIIIlllIllIIlIIIIl) == EnumActionResult.SUCCESS) {
                        this.entityRenderer.itemRenderer.resetEquippedProgress(lllllllllllIlllIIIlllIllIIlIIIIl);
                        return;
                    }
                }
            }
        }
    }
    
    private boolean processKeyF3(final int lllllllllllIlllIIIlllIlIllIIlllI) {
        if (lllllllllllIlllIIIlllIlIllIIlllI == 30) {
            this.renderGlobal.loadRenderers();
            this.func_190521_a("debug.reload_chunks.message", new Object[0]);
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 48) {
            final boolean lllllllllllIlllIIIlllIlIllIlIIlI = !this.renderManager.isDebugBoundingBox();
            this.renderManager.setDebugBoundingBox(lllllllllllIlllIIIlllIlIllIlIIlI);
            this.func_190521_a(lllllllllllIlllIIIlllIlIllIlIIlI ? "debug.show_hitboxes.on" : "debug.show_hitboxes.off", new Object[0]);
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 32) {
            if (this.ingameGUI != null) {
                this.ingameGUI.getChatGUI().clearChatMessages(false);
            }
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 33) {
            this.gameSettings.setOptionValue(GameSettings.Options.RENDER_DISTANCE, GuiScreen.isShiftKeyDown() ? -1 : 1);
            this.func_190521_a("debug.cycle_renderdistance.message", this.gameSettings.renderDistanceChunks);
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 34) {
            final boolean lllllllllllIlllIIIlllIlIllIlIIIl = this.debugRenderer.toggleDebugScreen();
            this.func_190521_a(lllllllllllIlllIIIlllIlIllIlIIIl ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off", new Object[0]);
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 35) {
            this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
            this.func_190521_a(this.gameSettings.advancedItemTooltips ? "debug.advanced_tooltips.on" : "debug.advanced_tooltips.off", new Object[0]);
            this.gameSettings.saveOptions();
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 49) {
            if (!this.player.canCommandSenderUseCommand(2, "")) {
                this.func_190521_a("debug.creative_spectator.error", new Object[0]);
            }
            else if (this.player.isCreative()) {
                this.player.sendChatMessage("/gamemode spectator");
            }
            else if (this.player.isSpectator()) {
                this.player.sendChatMessage("/gamemode creative");
            }
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 25) {
            this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
            this.gameSettings.saveOptions();
            this.func_190521_a(this.gameSettings.pauseOnLostFocus ? "debug.pause_focus.on" : "debug.pause_focus.off", new Object[0]);
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 16) {
            this.func_190521_a("debug.help.message", new Object[0]);
            final GuiNewChat lllllllllllIlllIIIlllIlIllIlIIII = this.ingameGUI.getChatGUI();
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.reload_chunks.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.show_hitboxes.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.clear_chat.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.cycle_renderdistance.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.chunk_boundaries.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.advanced_tooltips.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.creative_spectator.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.pause_focus.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.help.help", new Object[0]));
            lllllllllllIlllIIIlllIlIllIlIIII.printChatMessage(new TextComponentTranslation("debug.reload_resourcepacks.help", new Object[0]));
            return true;
        }
        if (lllllllllllIlllIIIlllIlIllIIlllI == 20) {
            this.func_190521_a("debug.reload_resourcepacks.message", new Object[0]);
            this.refreshResources();
            return true;
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LOCATION_MOJANG_PNG = new ResourceLocation("textures/gui/title/mojang.png");
        IS_RUNNING_ON_MAC = (Util.getOSType() == Util.EnumOS.OSX);
        Minecraft.memoryReserve = new byte[10485760];
        MAC_DISPLAY_MODES = Lists.newArrayList((Object[])new DisplayMode[] { new DisplayMode(2560, 1600), new DisplayMode(2880, 1800) });
    }
    
    private static boolean isJvm64bit() {
        final String[] lllllllllllIlllIIIllllIIlIIllIIl = { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
        int lllllllllllIlllIIIllllIIlIIlIIlI;
        for (short lllllllllllIlllIIIllllIIlIIlIIll = (short)((String[])(Object)(lllllllllllIlllIIIllllIIlIIlIIlI = (int)(Object)lllllllllllIlllIIIllllIIlIIllIIl)).length, lllllllllllIlllIIIllllIIlIIlIlII = 0; lllllllllllIlllIIIllllIIlIIlIlII < lllllllllllIlllIIIllllIIlIIlIIll; ++lllllllllllIlllIIIllllIIlIIlIlII) {
            final String lllllllllllIlllIIIllllIIlIIllIII = lllllllllllIlllIIIllllIIlIIlIIlI[lllllllllllIlllIIIllllIIlIIlIlII];
            final String lllllllllllIlllIIIllllIIlIIlIlll = System.getProperty(lllllllllllIlllIIIllllIIlIIllIII);
            if (lllllllllllIlllIIIllllIIlIIlIlll != null && lllllllllllIlllIIIllllIIlIIlIlll.contains("64")) {
                return true;
            }
        }
        return false;
    }
    
    public void clickMouse() {
        if (this.leftClickCounter <= 0) {
            final EventAttackClient lllllllllllIlllIIIlllIllIIllIIII = new EventAttackClient(this.objectMouseOver.entityHit);
            if (this.objectMouseOver != null) {
                lllllllllllIlllIIIlllIllIIllIIII.call();
            }
            if (this.objectMouseOver == null) {
                Minecraft.LOGGER.error("Null returned as 'hitResult', this shouldn't happen!");
                if (this.playerController.isNotCreative()) {
                    this.leftClickCounter = 10;
                }
            }
            else if (!this.player.isRowingBoat()) {
                switch ($SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type()[this.objectMouseOver.typeOfHit.ordinal()]) {
                    case 3: {
                        this.playerController.attackEntity(this.player, this.objectMouseOver.entityHit);
                        break;
                    }
                    case 2: {
                        final BlockPos lllllllllllIlllIIIlllIllIIlIllll = this.objectMouseOver.getBlockPos();
                        if (this.world.getBlockState(lllllllllllIlllIIIlllIllIIlIllll).getMaterial() != Material.AIR) {
                            this.playerController.clickBlock(lllllllllllIlllIIIlllIllIIlIllll, this.objectMouseOver.sideHit);
                            break;
                        }
                    }
                    case 1: {
                        if (this.playerController.isNotCreative()) {
                            this.leftClickCounter = 10;
                        }
                        this.player.resetCooldown();
                        break;
                    }
                }
                this.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.mcThread;
    }
    
    public RenderItem getRenderItem() {
        return this.renderItem;
    }
    
    public void setDimensionAndSpawnPlayer(final int lllllllllllIlllIIIlllIlIIllIIIII) {
        this.world.setInitialSpawnLocation();
        this.world.removeAllEntities();
        int lllllllllllIlllIIIlllIlIIlIlllll = 0;
        String lllllllllllIlllIIIlllIlIIlIllllI = null;
        if (this.player != null) {
            lllllllllllIlllIIIlllIlIIlIlllll = this.player.getEntityId();
            this.world.removeEntity(this.player);
            lllllllllllIlllIIIlllIlIIlIllllI = this.player.getServerBrand();
        }
        this.renderViewEntity = null;
        final EntityPlayerSP lllllllllllIlllIIIlllIlIIlIlllIl = this.player;
        this.player = this.playerController.func_192830_a(this.world, (this.player == null) ? new StatisticsManager() : this.player.getStatFileWriter(), (this.player == null) ? new RecipeBook() : this.player.func_192035_E());
        this.player.getDataManager().setEntryValues(lllllllllllIlllIIIlllIlIIlIlllIl.getDataManager().getAll());
        this.player.dimension = lllllllllllIlllIIIlllIlIIllIIIII;
        this.renderViewEntity = this.player;
        this.player.preparePlayerToSpawn();
        this.player.setServerBrand(lllllllllllIlllIIIlllIlIIlIllllI);
        this.world.spawnEntityInWorld(this.player);
        this.playerController.flipPlayer(this.player);
        this.player.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.player.setEntityId(lllllllllllIlllIIIlllIlIIlIlllll);
        this.playerController.setPlayerCapabilities(this.player);
        this.player.setReducedDebug(lllllllllllIlllIIIlllIlIIlIlllIl.hasReducedDebug());
        if (this.currentScreen instanceof GuiGameOver) {
            this.displayGuiScreen(null);
        }
    }
    
    public static int getDebugFPS() {
        return Minecraft.debugFPS;
    }
    
    private void updateDisplayMode() throws LWJGLException {
        final Set<DisplayMode> lllllllllllIlllIIIllllIIIlIIIIll = (Set<DisplayMode>)Sets.newHashSet();
        Collections.addAll(lllllllllllIlllIIIllllIIIlIIIIll, Display.getAvailableDisplayModes());
        DisplayMode lllllllllllIlllIIIllllIIIlIIIIlI = Display.getDesktopDisplayMode();
        if (!lllllllllllIlllIIIllllIIIlIIIIll.contains(lllllllllllIlllIIIllllIIIlIIIIlI) && Util.getOSType() == Util.EnumOS.OSX) {
            for (final DisplayMode lllllllllllIlllIIIllllIIIlIIIIIl : Minecraft.MAC_DISPLAY_MODES) {
                boolean lllllllllllIlllIIIllllIIIlIIIIII = true;
                for (final DisplayMode lllllllllllIlllIIIllllIIIIllllll : lllllllllllIlllIIIllllIIIlIIIIll) {
                    if (lllllllllllIlllIIIllllIIIIllllll.getBitsPerPixel() == 32 && lllllllllllIlllIIIllllIIIIllllll.getWidth() == lllllllllllIlllIIIllllIIIlIIIIIl.getWidth() && lllllllllllIlllIIIllllIIIIllllll.getHeight() == lllllllllllIlllIIIllllIIIlIIIIIl.getHeight()) {
                        lllllllllllIlllIIIllllIIIlIIIIII = false;
                        break;
                    }
                }
                if (!lllllllllllIlllIIIllllIIIlIIIIII) {
                    for (final DisplayMode lllllllllllIlllIIIllllIIIIllllIl : lllllllllllIlllIIIllllIIIlIIIIll) {
                        if (lllllllllllIlllIIIllllIIIIllllIl.getBitsPerPixel() == 32 && lllllllllllIlllIIIllllIIIIllllIl.getWidth() == lllllllllllIlllIIIllllIIIlIIIIIl.getWidth() / 2 && lllllllllllIlllIIIllllIIIIllllIl.getHeight() == lllllllllllIlllIIIllllIIIlIIIIIl.getHeight() / 2) {
                            lllllllllllIlllIIIllllIIIlIIIIlI = lllllllllllIlllIIIllllIIIIllllIl;
                            break;
                        }
                    }
                }
            }
        }
        Display.setDisplayMode(lllllllllllIlllIIIllllIIIlIIIIlI);
        this.displayWidth = lllllllllllIlllIIIllllIIIlIIIIlI.getWidth();
        this.displayHeight = lllllllllllIlllIIIllllIIIlIIIIlI.getHeight();
    }
    
    public void refreshResources() {
        final List<IResourcePack> lllllllllllIlllIIIllllIIIllIlIIl = (List<IResourcePack>)Lists.newArrayList((Iterable)this.defaultResourcePacks);
        if (this.theIntegratedServer != null) {
            this.theIntegratedServer.func_193031_aM();
        }
        for (final ResourcePackRepository.Entry lllllllllllIlllIIIllllIIIllIlIII : this.mcResourcePackRepository.getRepositoryEntries()) {
            lllllllllllIlllIIIllllIIIllIlIIl.add(lllllllllllIlllIIIllllIIIllIlIII.getResourcePack());
        }
        if (this.mcResourcePackRepository.getResourcePackInstance() != null) {
            lllllllllllIlllIIIllllIIIllIlIIl.add(this.mcResourcePackRepository.getResourcePackInstance());
        }
        try {
            this.mcResourceManager.reloadResources(lllllllllllIlllIIIllllIIIllIlIIl);
        }
        catch (RuntimeException lllllllllllIlllIIIllllIIIllIIlll) {
            Minecraft.LOGGER.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)lllllllllllIlllIIIllllIIIllIIlll);
            lllllllllllIlllIIIllllIIIllIlIIl.clear();
            lllllllllllIlllIIIllllIIIllIlIIl.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.setRepositories(Collections.emptyList());
            this.mcResourceManager.reloadResources(lllllllllllIlllIIIllllIIIllIlIIl);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.incompatibleResourcePacks.clear();
            this.gameSettings.saveOptions();
        }
        this.mcLanguageManager.parseLanguageMetadata(lllllllllllIlllIIIllllIIIllIlIIl);
        if (this.renderGlobal != null) {
            this.renderGlobal.loadRenderers();
        }
    }
    
    public FrameTimer getFrameTimer() {
        return this.frameTimer;
    }
    
    public void shutdownMinecraftApplet() {
        try {
            Main.instance.stopClient();
            Minecraft.LOGGER.info("Stopping!");
            try {
                this.loadWorld(null);
            }
            catch (Throwable t) {}
            this.mcSoundHandler.unloadSounds();
        }
        finally {
            Display.destroy();
            if (!this.hasCrashed) {
                System.exit(0);
            }
        }
        Display.destroy();
        if (!this.hasCrashed) {
            System.exit(0);
        }
        System.gc();
    }
    
    private void sendClickBlockToController(final boolean lllllllllllIlllIIIlllIllIIlllIIl) {
        if (!lllllllllllIlllIIIlllIllIIlllIIl) {
            this.leftClickCounter = 0;
        }
        if (this.leftClickCounter <= 0 && !this.player.isHandActive()) {
            if (lllllllllllIlllIIIlllIllIIlllIIl && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos lllllllllllIlllIIIlllIllIIlllIII = this.objectMouseOver.getBlockPos();
                if (this.world.getBlockState(lllllllllllIlllIIIlllIllIIlllIII).getMaterial() != Material.AIR && this.playerController.onPlayerDamageBlock(lllllllllllIlllIIIlllIllIIlllIII, this.objectMouseOver.sideHit)) {
                    this.effectRenderer.addBlockHitEffects(lllllllllllIlllIIIlllIllIIlllIII, this.objectMouseOver.sideHit);
                    this.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
            else {
                this.playerController.resetBlockRemoving();
            }
        }
    }
    
    public boolean isJava64bit() {
        return this.jvm64bit;
    }
    
    public ResourcePackRepository getResourcePackRepository() {
        return this.mcResourcePackRepository;
    }
    
    private void resize(final int lllllllllllIlllIIIlllIllIIIIIlII, final int lllllllllllIlllIIIlllIllIIIIIlll) {
        this.displayWidth = Math.max(1, lllllllllllIlllIIIlllIllIIIIIlII);
        this.displayHeight = Math.max(1, lllllllllllIlllIIIlllIllIIIIIlll);
        if (this.currentScreen != null) {
            final ScaledResolution lllllllllllIlllIIIlllIllIIIIIllI = new ScaledResolution(this);
            this.currentScreen.onResize(this, lllllllllllIlllIIIlllIllIIIIIllI.getScaledWidth(), lllllllllllIlllIIIlllIllIIIIIllI.getScaledHeight());
        }
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.updateFramebufferSize();
    }
    
    private void updateFramebufferSize() {
        this.framebufferMc.createBindFramebuffer(this.displayWidth, this.displayHeight);
        if (this.entityRenderer != null) {
            this.entityRenderer.updateShaderGroupSize(this.displayWidth, this.displayHeight);
        }
    }
    
    public Tutorial func_193032_ao() {
        return this.field_193035_aW;
    }
    
    private String getCurrentAction() {
        if (this.theIntegratedServer != null) {
            return this.theIntegratedServer.getPublic() ? "hosting_lan" : "singleplayer";
        }
        if (this.currentServerData != null) {
            return this.currentServerData.isOnLAN() ? "playing_lan" : "multiplayer";
        }
        return "out_of_game";
    }
    
    public void loadWorld(@Nullable final WorldClient lllllllllllIlllIIIlllIlIIlllllIl) {
        this.loadWorld(lllllllllllIlllIIIlllIlIIlllllIl, "");
    }
    
    public MusicTicker getMusicTicker() {
        return this.mcMusicTicker;
    }
    
    public ItemRenderer getItemRenderer() {
        return this.itemRenderer;
    }
    
    public void setIngameFocus() {
        if (Display.isActive() && !this.inGameHasFocus) {
            if (!Minecraft.IS_RUNNING_ON_MAC) {
                KeyBinding.updateKeyBindState();
            }
            this.inGameHasFocus = true;
            this.mouseHelper.grabMouseCursor();
            this.displayGuiScreen(null);
            this.leftClickCounter = 10000;
        }
    }
    
    public TextureManager getTextureManager() {
        return this.renderEngine;
    }
    
    public void displayCrashReport(final CrashReport lllllllllllIlllIIIllllIIIlllIlll) {
        final File lllllllllllIlllIIIllllIIIlllIllI = new File(getMinecraft().mcDataDir, "crash-reports");
        final File lllllllllllIlllIIIllllIIIlllIlIl = new File(lllllllllllIlllIIIllllIIIlllIllI, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
        Bootstrap.printToSYSOUT(lllllllllllIlllIIIllllIIIlllIlll.getCompleteReport());
        if (lllllllllllIlllIIIllllIIIlllIlll.getFile() != null) {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + lllllllllllIlllIIIllllIIIlllIlll.getFile());
            System.exit(-1);
        }
        else if (lllllllllllIlllIIIllllIIIlllIlll.saveToFile(lllllllllllIlllIIIllllIIIlllIlIl)) {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + lllllllllllIlllIIIllllIIIlllIlIl.getAbsolutePath());
            System.exit(-1);
        }
        else {
            Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type() {
        final int[] $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type = Minecraft.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        if ($switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type != null) {
            return $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        }
        final int lllllllllllIlllIIIlllIIlIlIIIIII = (Object)new int[EntityMinecart.Type.values().length];
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.COMMAND_BLOCK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.FURNACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.HOPPER.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.RIDEABLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.SPAWNER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIII[EntityMinecart.Type.TNT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return Minecraft.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type = (int[])(Object)lllllllllllIlllIIIlllIIlIlIIIIII;
    }
    
    private void checkGLError(final String lllllllllllIlllIIIlllIllllIlIlll) {
        final int lllllllllllIlllIIIlllIllllIlIllI = GlStateManager.glGetError();
        if (lllllllllllIlllIIIlllIllllIlIllI != 0) {
            final String lllllllllllIlllIIIlllIllllIlIlIl = GLU.gluErrorString(lllllllllllIlllIIIlllIllllIlIllI);
            Minecraft.LOGGER.error("########## GL ERROR ##########");
            Minecraft.LOGGER.error("@ {}", (Object)lllllllllllIlllIIIlllIllllIlIlll);
            Minecraft.LOGGER.error("{}: {}", (Object)lllllllllllIlllIIIlllIllllIlIllI, (Object)lllllllllllIlllIIIlllIllllIlIlIl);
        }
    }
    
    public static boolean isAmbientOcclusionEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.ambientOcclusion != 0;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public BlockRendererDispatcher getBlockRendererDispatcher() {
        return this.blockRenderDispatcher;
    }
    
    private void runTickKeyboard() throws IOException {
        while (Keyboard.next()) {
            final int lllllllllllIlllIIIlllIlIlllIIIlI = (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
            if (this.debugCrashKeyPressTime > 0L) {
                if (getSystemTime() - this.debugCrashKeyPressTime >= 6000L) {
                    throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                }
                if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                    this.debugCrashKeyPressTime = -1L;
                }
            }
            else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                this.actionKeyF3 = true;
                this.debugCrashKeyPressTime = getSystemTime();
            }
            this.dispatchKeypresses();
            if (this.currentScreen != null) {
                this.currentScreen.handleKeyboardInput();
            }
            final boolean lllllllllllIlllIIIlllIlIlllIIIIl = Keyboard.getEventKeyState();
            if (lllllllllllIlllIIIlllIlIlllIIIIl) {
                if (lllllllllllIlllIIIlllIlIlllIIIlI == 62 && this.entityRenderer != null) {
                    this.entityRenderer.switchUseShader();
                }
                boolean lllllllllllIlllIIIlllIlIlllIIIII = false;
                final EventKey lllllllllllIlllIIIlllIlIllIlllll = new EventKey(lllllllllllIlllIIIlllIlIlllIIIlI);
                lllllllllllIlllIIIlllIlIllIlllll.call();
                if (this.currentScreen == null) {
                    if (lllllllllllIlllIIIlllIlIlllIIIlI == 1) {
                        this.displayInGameMenu();
                    }
                    lllllllllllIlllIIIlllIlIlllIIIII = (Keyboard.isKeyDown(61) && this.processKeyF3(lllllllllllIlllIIIlllIlIlllIIIlI));
                    this.actionKeyF3 |= lllllllllllIlllIIIlllIlIlllIIIII;
                    if (lllllllllllIlllIIIlllIlIlllIIIlI == 59) {
                        this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                    }
                }
                if (lllllllllllIlllIIIlllIlIlllIIIII) {
                    KeyBinding.setKeyBindState(lllllllllllIlllIIIlllIlIlllIIIlI, false);
                }
                else {
                    KeyBinding.setKeyBindState(lllllllllllIlllIIIlllIlIlllIIIlI, true);
                    KeyBinding.onTick(lllllllllllIlllIIIlllIlIlllIIIlI);
                }
                if (!this.gameSettings.showDebugProfilerChart) {
                    continue;
                }
                if (lllllllllllIlllIIIlllIlIlllIIIlI == 11) {
                    this.updateDebugProfilerName(0);
                }
                for (int lllllllllllIlllIIIlllIlIllIllllI = 0; lllllllllllIlllIIIlllIlIllIllllI < 9; ++lllllllllllIlllIIIlllIlIllIllllI) {
                    if (lllllllllllIlllIIIlllIlIlllIIIlI == 2 + lllllllllllIlllIIIlllIlIllIllllI) {
                        this.updateDebugProfilerName(lllllllllllIlllIIIlllIlIllIllllI + 1);
                    }
                }
            }
            else {
                KeyBinding.setKeyBindState(lllllllllllIlllIIIlllIlIlllIIIlI, false);
                if (lllllllllllIlllIIIlllIlIlllIIIlI != 61) {
                    continue;
                }
                if (this.actionKeyF3) {
                    this.actionKeyF3 = false;
                }
                else {
                    this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                    this.gameSettings.showDebugProfilerChart = (this.gameSettings.showDebugInfo && GuiScreen.isShiftKeyDown());
                    this.gameSettings.showLagometer = (this.gameSettings.showDebugInfo && GuiScreen.isAltKeyDown());
                }
            }
        }
        this.processKeyBinds();
    }
    
    public static void stopIntegratedServer() {
        if (Minecraft.theMinecraft != null) {
            final IntegratedServer lllllllllllIlllIIIlllIIlllIIllll = Minecraft.theMinecraft.getIntegratedServer();
            if (lllllllllllIlllIIIlllIIlllIIllll != null) {
                lllllllllllIlllIIIlllIIlllIIllll.stopServer();
            }
        }
    }
    
    public PropertyMap getProfileProperties() {
        if (this.profileProperties.isEmpty()) {
            final GameProfile lllllllllllIlllIIIlllIIlllIIIIIl = this.getSessionService().fillProfileProperties(this.session.getProfile(), false);
            this.profileProperties.putAll((Multimap)lllllllllllIlllIIIlllIIlllIIIIIl.getProperties());
        }
        return this.profileProperties;
    }
    
    public boolean isFullScreen() {
        return this.fullscreen;
    }
    
    public Framebuffer getFramebuffer() {
        return this.framebufferMc;
    }
    
    private void func_193986_ar() {
        final SearchTree<ItemStack> lllllllllllIlllIIIllllIIllIIlIlI = new SearchTree<ItemStack>(lllllllllllIlllIIIlllIIlIIllllII -> lllllllllllIlllIIIlllIIlIIllllII.getTooltip(null, ITooltipFlag.TooltipFlags.NORMAL).stream().map((Function<? super Object, ?>)TextFormatting::getTextWithoutFormattingCodes).map((Function<? super Object, ?>)String::trim).filter(lllllllllllIlllIIIlllIIlIIllIIII -> !lllllllllllIlllIIIlllIIlIIllIIII.isEmpty()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()), lllllllllllIlllIIIlllIIlIIlllIII -> Collections.singleton(Item.REGISTRY.getNameForObject(lllllllllllIlllIIIlllIIlIIlllIII.getItem())));
        final NonNullList<ItemStack> lllllllllllIlllIIIllllIIllIIlIIl = NonNullList.func_191196_a();
        for (final Item lllllllllllIlllIIIllllIIllIIlIII : Item.REGISTRY) {
            lllllllllllIlllIIIllllIIllIIlIII.getSubItems(CreativeTabs.SEARCH, lllllllllllIlllIIIllllIIllIIlIIl);
        }
        lllllllllllIlllIIIllllIIllIIlIIl.forEach(lllllllllllIlllIIIllllIIllIIlIlI::func_194043_a);
        final SearchTree<RecipeList> lllllllllllIlllIIIllllIIllIIIlll = new SearchTree<RecipeList>(lllllllllllIlllIIIlllIIlIIllIllI -> lllllllllllIlllIIIlllIIlIIllIllI.func_192711_b().stream().flatMap(lllllllllllIlllIIIlllIIlIIlIllIl -> lllllllllllIlllIIIlllIIlIIlIllIl.getRecipeOutput().getTooltip(null, ITooltipFlag.TooltipFlags.NORMAL).stream()).map((Function<? super Object, ?>)TextFormatting::getTextWithoutFormattingCodes).map((Function<? super Object, ?>)String::trim).filter(lllllllllllIlllIIIlllIIlIIlIlIlI -> !lllllllllllIlllIIIlllIIlIIlIlIlI.isEmpty()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()), lllllllllllIlllIIIlllIIlIIllIIlI -> lllllllllllIlllIIIlllIIlIIllIIlI.func_192711_b().stream().map(lllllllllllIlllIIIlllIIlIIlIIllI -> Item.REGISTRY.getNameForObject(lllllllllllIlllIIIlllIIlIIlIIllI.getRecipeOutput().getItem())).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
        RecipeBookClient.field_194087_f.forEach(lllllllllllIlllIIIllllIIllIIIlll::func_194043_a);
        this.field_193995_ae.func_194009_a(SearchTreeManager.field_194011_a, lllllllllllIlllIIIllllIIllIIlIlI);
        this.field_193995_ae.func_194009_a(SearchTreeManager.field_194012_b, lllllllllllIlllIIIllllIIllIIIlll);
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return this.gameSettings.snooperEnabled;
    }
    
    private void registerMetadataSerializers() {
        this.metadataSerializer_.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
    }
    
    public IResourceManager getResourceManager() {
        return this.mcResourceManager;
    }
    
    public SoundHandler getSoundHandler() {
        return this.mcSoundHandler;
    }
    
    public int getLimitFramerate() {
        return (this.world == null && this.currentScreen != null) ? 30 : this.gameSettings.limitFramerate;
    }
    
    public void toggleFullscreen() {
        try {
            this.fullscreen = !this.fullscreen;
            this.gameSettings.fullScreen = this.fullscreen;
            if (this.fullscreen) {
                this.updateDisplayMode();
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            else {
                Display.setDisplayMode(new DisplayMode(this.tempDisplayWidth, this.tempDisplayHeight));
                this.displayWidth = this.tempDisplayWidth;
                this.displayHeight = this.tempDisplayHeight;
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            if (this.currentScreen != null) {
                this.resize(this.displayWidth, this.displayHeight);
            }
            else {
                this.updateFramebufferSize();
            }
            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            this.updateDisplay();
        }
        catch (Exception lllllllllllIlllIIIlllIllIIIlIIII) {
            Minecraft.LOGGER.error("Couldn't toggle fullscreen", (Throwable)lllllllllllIlllIIIlllIllIIIlIIII);
        }
    }
    
    public void launchIntegratedServer(final String lllllllllllIlllIIIlllIlIlIIllIll, final String lllllllllllIlllIIIlllIlIlIIIlIlI, @Nullable WorldSettings lllllllllllIlllIIIlllIlIlIIIlIIl) {
        if (!Main.featureDirector.getFeatureByClass(FastWorldLoad.class).isToggled()) {
            this.loadWorld(null);
            System.gc();
        }
        final ISaveHandler lllllllllllIlllIIIlllIlIlIIllIII = this.saveLoader.getSaveLoader(lllllllllllIlllIIIlllIlIlIIllIll, false);
        WorldInfo lllllllllllIlllIIIlllIlIlIIlIlll = lllllllllllIlllIIIlllIlIlIIllIII.loadWorldInfo();
        if (lllllllllllIlllIIIlllIlIlIIlIlll == null && lllllllllllIlllIIIlllIlIlIIIlIIl != null) {
            lllllllllllIlllIIIlllIlIlIIlIlll = new WorldInfo(lllllllllllIlllIIIlllIlIlIIIlIIl, lllllllllllIlllIIIlllIlIlIIllIll);
            lllllllllllIlllIIIlllIlIlIIllIII.saveWorldInfo(lllllllllllIlllIIIlllIlIlIIlIlll);
        }
        if (lllllllllllIlllIIIlllIlIlIIIlIIl == null) {
            lllllllllllIlllIIIlllIlIlIIIlIIl = new WorldSettings(lllllllllllIlllIIIlllIlIlIIlIlll);
        }
        try {
            final YggdrasilAuthenticationService lllllllllllIlllIIIlllIlIlIIlIllI = new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString());
            final MinecraftSessionService lllllllllllIlllIIIlllIlIlIIlIlIl = lllllllllllIlllIIIlllIlIlIIlIllI.createMinecraftSessionService();
            final GameProfileRepository lllllllllllIlllIIIlllIlIlIIlIlII = lllllllllllIlllIIIlllIlIlIIlIllI.createProfileRepository();
            final PlayerProfileCache lllllllllllIlllIIIlllIlIlIIlIIll = new PlayerProfileCache(lllllllllllIlllIIIlllIlIlIIlIlII, new File(this.mcDataDir, MinecraftServer.USER_CACHE_FILE.getName()));
            TileEntitySkull.setProfileCache(lllllllllllIlllIIIlllIlIlIIlIIll);
            TileEntitySkull.setSessionService(lllllllllllIlllIIIlllIlIlIIlIlIl);
            PlayerProfileCache.setOnlineMode(false);
            this.theIntegratedServer = new IntegratedServer(this, lllllllllllIlllIIIlllIlIlIIllIll, lllllllllllIlllIIIlllIlIlIIIlIlI, lllllllllllIlllIIIlllIlIlIIIlIIl, lllllllllllIlllIIIlllIlIlIIlIllI, lllllllllllIlllIIIlllIlIlIIlIlIl, lllllllllllIlllIIIlllIlIlIIlIlII, lllllllllllIlllIIIlllIlIlIIlIIll);
            this.theIntegratedServer.startServerThread();
            this.integratedServerIsRunning = true;
        }
        catch (Throwable lllllllllllIlllIIIlllIlIlIIlIIlI) {
            final CrashReport lllllllllllIlllIIIlllIlIlIIlIIIl = CrashReport.makeCrashReport(lllllllllllIlllIIIlllIlIlIIlIIlI, "Starting integrated server");
            final CrashReportCategory lllllllllllIlllIIIlllIlIlIIlIIII = lllllllllllIlllIIIlllIlIlIIlIIIl.makeCategory("Starting integrated server");
            lllllllllllIlllIIIlllIlIlIIlIIII.addCrashSection("Level ID", lllllllllllIlllIIIlllIlIlIIllIll);
            lllllllllllIlllIIIlllIlIlIIlIIII.addCrashSection("Level Name", lllllllllllIlllIIIlllIlIlIIIlIlI);
            throw new ReportedException(lllllllllllIlllIIIlllIlIlIIlIIIl);
        }
        this.loadingScreen.displaySavingString(I18n.format("menu.loadingLevel", new Object[0]));
        while (!this.theIntegratedServer.serverIsInRunLoop()) {
            final String lllllllllllIlllIIIlllIlIlIIIllll = this.theIntegratedServer.getUserMessage();
            if (lllllllllllIlllIIIlllIlIlIIIllll != null) {
                this.loadingScreen.displayLoadingString(I18n.format(lllllllllllIlllIIIlllIlIlIIIllll, new Object[0]));
            }
            else {
                this.loadingScreen.displayLoadingString("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException ex) {}
        }
        this.displayGuiScreen(new GuiScreenWorking());
        final SocketAddress lllllllllllIlllIIIlllIlIlIIIlllI = this.theIntegratedServer.getNetworkSystem().addLocalEndpoint();
        final NetworkManager lllllllllllIlllIIIlllIlIlIIIllIl = NetworkManager.provideLocalClient(lllllllllllIlllIIIlllIlIlIIIlllI);
        lllllllllllIlllIIIlllIlIlIIIllIl.setNetHandler(new NetHandlerLoginClient(lllllllllllIlllIIIlllIlIlIIIllIl, this, null));
        lllllllllllIlllIIIlllIlIlIIIllIl.sendPacket(new C00Handshake(lllllllllllIlllIIIlllIlIlIIIlllI.toString(), 0, EnumConnectionState.LOGIN));
        lllllllllllIlllIIIlllIlIlIIIllIl.sendPacket(new CPacketLoginStart(this.getSession().getProfile()));
        this.myNetworkManager = lllllllllllIlllIIIlllIlIlIIIllIl;
    }
    
    private void updateDebugProfilerName(int lllllllllllIlllIIIlllIlllIIllIlI) {
        final List<Profiler.Result> lllllllllllIlllIIIlllIlllIIllIIl = this.mcProfiler.getProfilingData(this.debugProfilerName);
        if (!lllllllllllIlllIIIlllIlllIIllIIl.isEmpty()) {
            final Profiler.Result lllllllllllIlllIIIlllIlllIIllIII = lllllllllllIlllIIIlllIlllIIllIIl.remove(0);
            if (lllllllllllIlllIIIlllIlllIIllIlI == 0) {
                if (!lllllllllllIlllIIIlllIlllIIllIII.profilerName.isEmpty()) {
                    final int lllllllllllIlllIIIlllIlllIIlIlll = this.debugProfilerName.lastIndexOf(46);
                    if (lllllllllllIlllIIIlllIlllIIlIlll >= 0) {
                        this.debugProfilerName = this.debugProfilerName.substring(0, lllllllllllIlllIIIlllIlllIIlIlll);
                    }
                }
            }
            else if (--lllllllllllIlllIIIlllIlllIIllIlI < lllllllllllIlllIIIlllIlllIIllIIl.size() && !"unspecified".equals(lllllllllllIlllIIIlllIlllIIllIIl.get(lllllllllllIlllIIIlllIlllIIllIlI).profilerName)) {
                if (!this.debugProfilerName.isEmpty()) {
                    this.debugProfilerName = String.valueOf(this.debugProfilerName) + ".";
                }
                this.debugProfilerName = String.valueOf(this.debugProfilerName) + lllllllllllIlllIIIlllIlllIIllIIl.get(lllllllllllIlllIIIlllIlllIIllIlI).profilerName;
            }
        }
    }
    
    private void startTimerHackThread() {
        final Thread lllllllllllIlllIIIllllIIlIIIIlII = new Thread("Timer hack thread") {
            @Override
            public void run() {
                while (Minecraft.this.running) {
                    try {
                        Thread.sleep(2147483647L);
                    }
                    catch (InterruptedException ex) {}
                }
            }
        };
        lllllllllllIlllIIIllllIIlIIIIlII.setDaemon(true);
        lllllllllllIlllIIIllllIIlIIIIlII.start();
    }
    
    public void setRenderViewEntity(final Entity lllllllllllIlllIIIlllIIllIIIllII) {
        this.renderViewEntity = lllllllllllIlllIIIlllIIllIIIllII;
        this.entityRenderer.loadEntityShader(lllllllllllIlllIIIlllIIllIIIllII);
    }
    
    public TextureMap getTextureMapBlocks() {
        return this.textureMapBlocks;
    }
    
    protected void checkWindowResize() {
        if (!this.fullscreen && Display.wasResized()) {
            final int lllllllllllIlllIIIlllIlllIllIIII = this.displayWidth;
            final int lllllllllllIlllIIIlllIlllIlIllll = this.displayHeight;
            this.displayWidth = Display.getWidth();
            this.displayHeight = Display.getHeight();
            if (this.displayWidth != lllllllllllIlllIIIlllIlllIllIIII || this.displayHeight != lllllllllllIlllIIIlllIlllIlIllll) {
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
                this.resize(this.displayWidth, this.displayHeight);
            }
        }
    }
    
    public ListenableFuture<Object> scheduleResourcesRefresh() {
        return this.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                Minecraft.this.refreshResources();
            }
        });
    }
    
    @Override
    public void addServerTypeToSnooper(final Snooper lllllllllllIlllIIIlllIIlllllIIlI) {
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("opengl_version", GlStateManager.glGetString(7938));
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("opengl_vendor", GlStateManager.glGetString(7936));
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("client_brand", ClientBrandRetriever.getClientModName());
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("launched_version", this.launchedVersion);
        final ContextCapabilities lllllllllllIlllIIIlllIIlllllIIIl = GLContext.getCapabilities();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_arrays_of_arrays]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_arrays_of_arrays);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_base_instance]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_base_instance);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_blend_func_extended]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_blend_func_extended);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_clear_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_clear_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_color_buffer_float]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_color_buffer_float);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_compatibility]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_compatibility);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_compressed_texture_pixel_storage]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_compressed_texture_pixel_storage);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_compute_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_compute_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_copy_buffer]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_copy_buffer);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_copy_image]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_copy_image);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_depth_buffer_float);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_compute_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_compute_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_copy_buffer]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_copy_buffer);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_copy_image]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_copy_image);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_depth_buffer_float);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_depth_clamp]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_depth_clamp);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_depth_texture]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_depth_texture);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_draw_buffers]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_draw_buffers);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_draw_buffers_blend]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_draw_buffers_blend);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_draw_elements_base_vertex]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_draw_elements_base_vertex);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_draw_indirect]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_draw_indirect);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_draw_instanced]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_draw_instanced);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_explicit_attrib_location]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_explicit_attrib_location);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_explicit_uniform_location]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_explicit_uniform_location);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_fragment_layer_viewport]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_fragment_layer_viewport);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_fragment_program]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_fragment_program);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_fragment_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_fragment_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_fragment_program_shadow]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_fragment_program_shadow);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_framebuffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_framebuffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_framebuffer_sRGB]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_framebuffer_sRGB);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_geometry_shader4]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_geometry_shader4);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_gpu_shader5]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_gpu_shader5);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_half_float_pixel]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_half_float_pixel);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_half_float_vertex]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_half_float_vertex);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_instanced_arrays]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_instanced_arrays);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_map_buffer_alignment]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_map_buffer_alignment);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_map_buffer_range]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_map_buffer_range);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_multisample]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_multisample);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_multitexture]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_multitexture);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_occlusion_query2]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_occlusion_query2);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_pixel_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_pixel_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_seamless_cube_map]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_seamless_cube_map);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_shader_objects]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_shader_objects);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_shader_stencil_export]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_shader_stencil_export);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_shader_texture_lod]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_shader_texture_lod);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_shadow]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_shadow);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_shadow_ambient]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_shadow_ambient);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_stencil_texturing]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_stencil_texturing);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_sync]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_sync);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_tessellation_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_tessellation_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_texture_border_clamp]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_texture_border_clamp);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_texture_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_texture_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_texture_cube_map]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_texture_cube_map);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_texture_cube_map_array]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_texture_cube_map_array);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_texture_non_power_of_two]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_texture_non_power_of_two);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_uniform_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_uniform_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_vertex_blend]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_vertex_blend);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_vertex_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_vertex_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_vertex_program]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_vertex_program);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[ARB_vertex_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_ARB_vertex_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_bindable_uniform]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_bindable_uniform);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_blend_equation_separate]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_blend_equation_separate);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_blend_func_separate]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_blend_func_separate);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_blend_minmax]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_blend_minmax);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_blend_subtract]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_blend_subtract);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_draw_instanced]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_draw_instanced);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_multisample]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_framebuffer_multisample);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_framebuffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_framebuffer_sRGB]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_framebuffer_sRGB);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_geometry_shader4]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_geometry_shader4);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_gpu_program_parameters]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_gpu_program_parameters);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_gpu_shader4]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_gpu_shader4);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_multi_draw_arrays]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_multi_draw_arrays);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_packed_depth_stencil]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_packed_depth_stencil);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_paletted_texture]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_paletted_texture);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_rescale_normal]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_rescale_normal);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_separate_shader_objects]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_separate_shader_objects);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_shader_image_load_store]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_shader_image_load_store);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_shadow_funcs]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_shadow_funcs);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_shared_texture_palette]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_shared_texture_palette);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_stencil_clear_tag]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_stencil_clear_tag);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_stencil_two_side]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_stencil_two_side);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_stencil_wrap]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_stencil_wrap);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_3d]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_3d);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_array]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_array);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_buffer_object]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_buffer_object);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_integer]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_integer);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_lod_bias]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_lod_bias);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_texture_sRGB]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_texture_sRGB);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_vertex_shader]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_vertex_shader);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[EXT_vertex_weighting]", lllllllllllIlllIIIlllIIlllllIIIl.GL_EXT_vertex_weighting);
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_uniforms]", GlStateManager.glGetInteger(35658));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_fragment_uniforms]", GlStateManager.glGetInteger(35657));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_attribs]", GlStateManager.glGetInteger(34921));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_vertex_texture_image_units]", GlStateManager.glGetInteger(35660));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GlStateManager.glGetInteger(34930));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_caps[gl_max_array_texture_layers]", GlStateManager.glGetInteger(35071));
        GlStateManager.glGetError();
        lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("gl_max_texture_size", getGLMaximumTextureSize());
        final GameProfile lllllllllllIlllIIIlllIIlllllIIII = this.session.getProfile();
        if (lllllllllllIlllIIIlllIIlllllIIII != null && lllllllllllIlllIIIlllIIlllllIIII.getId() != null) {
            lllllllllllIlllIIIlllIIlllllIIlI.addStatToSnooper("uuid", Hashing.sha1().hashBytes(lllllllllllIlllIIIlllIIlllllIIII.getId().toString().getBytes(Charsets.ISO_8859_1)).toString());
        }
    }
    
    public void setIngameNotInFocus() {
        if (this.inGameHasFocus) {
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }
    
    private void func_190521_a(final String lllllllllllIlllIIIlllIlIlIlIlIII, final Object... lllllllllllIlllIIIlllIlIlIlIlIlI) {
        this.ingameGUI.getChatGUI().printChatMessage(new TextComponentString("").appendSibling(new TextComponentTranslation("debug.prefix", new Object[0]).setStyle(new Style().setColor(TextFormatting.YELLOW).setBold(true))).appendText(" ").appendSibling(new TextComponentTranslation(lllllllllllIlllIIIlllIlIlIlIlIII, lllllllllllIlllIIIlllIlIlIlIlIlI)));
    }
    
    public <V> ListenableFuture<V> addScheduledTask(final Callable<V> lllllllllllIlllIIIlllIIllIIIIIlI) {
        Validate.notNull((Object)lllllllllllIlllIIIlllIIllIIIIIlI);
        if (this.isCallingFromMinecraftThread()) {
            try {
                return (ListenableFuture<V>)Futures.immediateFuture((Object)lllllllllllIlllIIIlllIIllIIIIIlI.call());
            }
            catch (Exception lllllllllllIlllIIIlllIIllIIIIlIl) {
                return (ListenableFuture<V>)Futures.immediateFailedCheckedFuture(lllllllllllIlllIIIlllIIllIIIIlIl);
            }
        }
        final ListenableFutureTask<V> lllllllllllIlllIIIlllIIllIIIIlII = (ListenableFutureTask<V>)ListenableFutureTask.create((Callable)lllllllllllIlllIIIlllIIllIIIIIlI);
        synchronized (this.scheduledTasks) {
            this.scheduledTasks.add((FutureTask<?>)lllllllllllIlllIIIlllIIllIIIIlII);
            final ListenableFutureTask<V> listenableFutureTask = lllllllllllIlllIIIlllIIllIIIIlII;
            // monitorexit(this.scheduledTasks)
            return (ListenableFuture<V>)listenableFutureTask;
        }
    }
    
    private void runTickMouse() throws IOException {
        while (Mouse.next()) {
            final int lllllllllllIlllIIIlllIlIlIlllIIl = Mouse.getEventButton();
            KeyBinding.setKeyBindState(lllllllllllIlllIIIlllIlIlIlllIIl - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
                final EventMouseKey lllllllllllIlllIIIlllIlIlIlllIII = new EventMouseKey(lllllllllllIlllIIIlllIlIlIlllIIl);
                lllllllllllIlllIIIlllIlIlIlllIII.call();
                if (this.player.isSpectator() && lllllllllllIlllIIIlllIlIlIlllIIl == 2) {
                    this.ingameGUI.getSpectatorGui().onMiddleClick();
                }
                else {
                    KeyBinding.onTick(lllllllllllIlllIIIlllIlIlIlllIIl - 100);
                }
            }
            final long lllllllllllIlllIIIlllIlIlIllIlll = getSystemTime() - this.systemTime;
            if (lllllllllllIlllIIIlllIlIlIllIlll <= 200L) {
                int lllllllllllIlllIIIlllIlIlIllIllI = Mouse.getEventDWheel();
                if (lllllllllllIlllIIIlllIlIlIllIllI != 0) {
                    if (this.player.isSpectator()) {
                        lllllllllllIlllIIIlllIlIlIllIllI = ((lllllllllllIlllIIIlllIlIlIllIllI < 0) ? -1 : 1);
                        if (this.ingameGUI.getSpectatorGui().isMenuActive()) {
                            this.ingameGUI.getSpectatorGui().onMouseScroll(-lllllllllllIlllIIIlllIlIlIllIllI);
                        }
                        else {
                            final float lllllllllllIlllIIIlllIlIlIllIlIl = MathHelper.clamp(this.player.capabilities.getFlySpeed() + lllllllllllIlllIIIlllIlIlIllIllI * 0.005f, 0.0f, 0.2f);
                            this.player.capabilities.setFlySpeed(lllllllllllIlllIIIlllIlIlIllIlIl);
                        }
                    }
                    else {
                        this.player.inventory.changeCurrentItem(lllllllllllIlllIIIlllIlIlIllIllI);
                    }
                }
                if (this.currentScreen == null) {
                    if (this.inGameHasFocus || !Mouse.getEventButtonState()) {
                        continue;
                    }
                    this.setIngameFocus();
                }
                else {
                    if (this.currentScreen == null) {
                        continue;
                    }
                    this.currentScreen.handleMouseInput();
                }
            }
        }
    }
    
    public void freeMemory() {
        try {
            Minecraft.memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable t) {}
        try {
            if (!Main.featureDirector.getFeatureByClass(FastWorldLoad.class).isToggled()) {
                System.gc();
                this.loadWorld(null);
            }
        }
        catch (Throwable t2) {}
        System.gc();
    }
    
    @Nullable
    public ServerData getCurrentServerData() {
        return this.currentServerData;
    }
    
    public Minecraft(final GameConfiguration lllllllllllIlllIIIllllIIlllIllIl) {
        this.timer = new Timer(20.0f);
        this.usageSnooper = new Snooper("client", this, MinecraftServer.getCurrentTimeMillis());
        this.field_193995_ae = new SearchTreeManager();
        this.systemTime = getSystemTime();
        this.frameTimer = new FrameTimer();
        this.startNanoTime = System.nanoTime();
        this.mcProfiler = new Profiler();
        this.debugCrashKeyPressTime = -1L;
        this.metadataSerializer_ = new MetadataSerializer();
        this.defaultResourcePacks = (List<IResourcePack>)Lists.newArrayList();
        this.scheduledTasks = (Queue<FutureTask<?>>)Queues.newArrayDeque();
        this.mcThread = Thread.currentThread();
        this.running = true;
        this.debug = "";
        this.renderChunksMany = true;
        this.debugUpdateTime = getSystemTime();
        this.prevFrameTime = -1L;
        this.debugProfilerName = "root";
        Minecraft.theMinecraft = this;
        this.mcDataDir = lllllllllllIlllIIIllllIIlllIllIl.folderInfo.mcDataDir;
        this.fileAssets = lllllllllllIlllIIIllllIIlllIllIl.folderInfo.assetsDir;
        this.fileResourcepacks = lllllllllllIlllIIIllllIIlllIllIl.folderInfo.resourcePacksDir;
        this.launchedVersion = lllllllllllIlllIIIllllIIlllIllIl.gameInfo.version;
        this.versionType = lllllllllllIlllIIIllllIIlllIllIl.gameInfo.versionType;
        this.twitchDetails = lllllllllllIlllIIIllllIIlllIllIl.userInfo.userProperties;
        this.profileProperties = lllllllllllIlllIIIllllIIlllIllIl.userInfo.profileProperties;
        this.mcDefaultResourcePack = new DefaultResourcePack(lllllllllllIlllIIIllllIIlllIllIl.folderInfo.getAssetsIndex());
        this.proxy = ((lllllllllllIlllIIIllllIIlllIllIl.userInfo.proxy == null) ? Proxy.NO_PROXY : lllllllllllIlllIIIllllIIlllIllIl.userInfo.proxy);
        this.sessionService = new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString()).createMinecraftSessionService();
        this.session = lllllllllllIlllIIIllllIIlllIllIl.userInfo.session;
        Minecraft.LOGGER.info("Setting user: {}", (Object)this.session.getUsername());
        Minecraft.LOGGER.debug("(Session ID is {})", (Object)this.session.getSessionID());
        this.isDemo = lllllllllllIlllIIIllllIIlllIllIl.gameInfo.isDemo;
        this.displayWidth = ((lllllllllllIlllIIIllllIIlllIllIl.displayInfo.width > 0) ? lllllllllllIlllIIIllllIIlllIllIl.displayInfo.width : 1);
        this.displayHeight = ((lllllllllllIlllIIIllllIIlllIllIl.displayInfo.height > 0) ? lllllllllllIlllIIIllllIIlllIllIl.displayInfo.height : 1);
        this.tempDisplayWidth = lllllllllllIlllIIIllllIIlllIllIl.displayInfo.width;
        this.tempDisplayHeight = lllllllllllIlllIIIllllIIlllIllIl.displayInfo.height;
        this.fullscreen = lllllllllllIlllIIIllllIIlllIllIl.displayInfo.fullscreen;
        this.jvm64bit = isJvm64bit();
        this.theIntegratedServer = null;
        if (lllllllllllIlllIIIllllIIlllIllIl.serverInfo.serverName != null) {
            this.serverName = lllllllllllIlllIIIllllIIlllIllIl.serverInfo.serverName;
            this.serverPort = lllllllllllIlllIIIllllIIlllIllIl.serverInfo.serverPort;
        }
        ImageIO.setUseCache(false);
        Locale.setDefault(Locale.ROOT);
        Bootstrap.register();
        TextComponentKeybind.field_193637_b = KeyBinding::func_193626_b;
        this.dataFixer = DataFixesManager.createFixer();
        this.field_193034_aS = new GuiToast(this);
        this.field_193035_aW = new Tutorial(this);
    }
    
    public static boolean isFancyGraphicsEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.fancyGraphics;
    }
    
    private void startGame() throws IOException, LWJGLException {
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.field_191950_u = new CreativeSettings(this, this.mcDataDir);
        this.defaultResourcePacks.add(this.mcDefaultResourcePack);
        this.startTimerHackThread();
        if (this.gameSettings.overrideHeight > 0 && this.gameSettings.overrideWidth > 0) {
            this.displayWidth = this.gameSettings.overrideWidth;
            this.displayHeight = this.gameSettings.overrideHeight;
        }
        Minecraft.LOGGER.info("LWJGL Version: {}", (Object)Sys.getVersion());
        this.setWindowIcon();
        this.setInitialDisplayMode();
        this.createDisplay();
        OpenGlHelper.initializeTextures();
        this.framebufferMc = new Framebuffer(this.displayWidth, this.displayHeight, true);
        this.framebufferMc.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.registerMetadataSerializers();
        this.mcResourcePackRepository = new ResourcePackRepository(this.fileResourcepacks, new File(this.mcDataDir, "server-resource-packs"), this.mcDefaultResourcePack, this.metadataSerializer_, this.gameSettings);
        this.mcResourceManager = new SimpleReloadableResourceManager(this.metadataSerializer_);
        this.mcLanguageManager = new LanguageManager(this.metadataSerializer_, this.gameSettings.language);
        this.mcResourceManager.registerReloadListener(this.mcLanguageManager);
        this.refreshResources();
        this.renderEngine = new TextureManager(this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.renderEngine);
        this.drawSplashScreen(this.renderEngine);
        this.skinManager = new SkinManager(this.renderEngine, new File(this.fileAssets, "skins"), this.sessionService);
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"), this.dataFixer);
        this.mcSoundHandler = new SoundHandler(this.mcResourceManager, this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.mcSoundHandler);
        this.mcMusicTicker = new MusicTicker(this);
        Minecraft.fontRendererObj = new net.minecraft.client.gui.FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii.png"), this.renderEngine, false);
        this.sfui18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/sf-ui.ttf"), 18.0f, 0), true, true);
        this.sfui16 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/sf-ui.ttf"), 16.0f, 0), true, true);
        this.comicsans_14 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 14.0f, 0), true, true);
        this.comicsans_15 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 15.0f, 0), true, true);
        this.comicsans_16 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 16.0f, 0), true, true);
        this.comicsans_17 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 17.0f, 0), true, true);
        this.comicsans_18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 18.0f, 0), true, true);
        this.comicsans_19 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 19.0f, 0), true, true);
        this.comicsans_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 20.0f, 0), true, true);
        this.comicsans_30 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/comicsans.ttf"), 30.0f, 0), true, true);
        this.mntsb = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 15.0f, 0), true, true);
        this.mntsb_15 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 15.0f, 0), true, true);
        this.mntsb_16 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 16.0f, 0), true, true);
        this.mntsb_17 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 17.0f, 0), true, true);
        this.mntsb_18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 18.0f, 0), true, true);
        this.mntsb_19 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 19.0f, 0), true, true);
        this.mntsb_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 20.0f, 0), true, true);
        this.mntsb_30 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/mntsb.ttf"), 30.0f, 0), true, true);
        this.icons2_15 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 15.0f, 0), true, true);
        this.icons2_16 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 16.0f, 0), true, true);
        this.icons2_17 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 17.0f, 0), true, true);
        this.icons2_18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 18.0f, 0), true, true);
        this.icons2_19 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 19.0f, 0), true, true);
        this.icons2_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 20.0f, 0), true, true);
        this.icons2_30 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons2.ttf"), 30.0f, 0), true, true);
        this.neverlose500_13 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 13.0f, 0), true, true);
        this.neverlose500_14 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 14.0f, 0), true, true);
        this.neverlose500_15 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 15.0f, 0), true, true);
        this.neverlose500_16 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 16.0f, 0), true, true);
        this.neverlose500_17 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 17.0f, 0), true, true);
        this.neverlose500_18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 18.0f, 0), true, true);
        this.neverlose500_19 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 19.0f, 0), true, true);
        this.neverlose500_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/neverlose500.ttf"), 20.0f, 0), true, true);
        this.stylesicons_14 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/stylesicons.ttf"), 14.0f, 0), true, true);
        this.robotoRegular = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/robotoregular.ttf"), 18.0f, 0), true, true);
        this.lato = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/lato.ttf"), 18.0f, 0), true, true);
        this.lato15 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/lato.ttf"), 15.0f, 0), true, true);
        this.makslol = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/makslol.ttf"), 26.0f, 0), true, true);
        this.icons_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons.ttf"), 20.0f, 0), true, true);
        this.icons_30 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/icons.ttf"), 30.0f, 0), true, true);
        this.elegant_20 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/elegent.ttf"), 20.0f, 0), true, true);
        this.elegant_18 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/elegent.ttf"), 18.0f, 0), true, true);
        this.elegant_30 = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/elegent.ttf"), 30.0f, 0), true, true);
        this.urwgeometric = new FontRenderer(FontUtil.getFontFromTTF(new ResourceLocation("font/urwgeometric.ttf"), 18.0f, 0), true, true);
        if (this.gameSettings.language != null) {
            Minecraft.fontRendererObj.setUnicodeFlag(this.isUnicode());
            Minecraft.fontRendererObj.setBidiFlag(this.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        this.standardGalacticFontRenderer = new net.minecraft.client.gui.FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii_sga.png"), this.renderEngine, false);
        this.mcResourceManager.registerReloadListener(Minecraft.fontRendererObj);
        this.mcResourceManager.registerReloadListener(this.standardGalacticFontRenderer);
        this.mcResourceManager.registerReloadListener(new GrassColorReloadListener());
        this.mcResourceManager.registerReloadListener(new FoliageColorReloadListener());
        this.mouseHelper = new MouseHelper();
        this.checkGLError("Pre startup");
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel(7425);
        GlStateManager.clearDepth(1.0);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.cullFace(GlStateManager.CullFace.BACK);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        this.checkGLError("Startup");
        this.textureMapBlocks = new TextureMap("textures");
        this.textureMapBlocks.setMipmapLevels(this.gameSettings.mipmapLevels);
        this.renderEngine.loadTickableTexture(TextureMap.LOCATION_BLOCKS_TEXTURE, this.textureMapBlocks);
        this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.textureMapBlocks.setBlurMipmapDirect(false, this.gameSettings.mipmapLevels > 0);
        this.modelManager = new ModelManager(this.textureMapBlocks);
        this.mcResourceManager.registerReloadListener(this.modelManager);
        this.blockColors = BlockColors.init();
        this.itemColors = ItemColors.init(this.blockColors);
        this.renderItem = new RenderItem(this.renderEngine, this.modelManager, this.itemColors);
        this.renderManager = new RenderManager(this.renderEngine, this.renderItem);
        this.itemRenderer = new ItemRenderer(this);
        this.mcResourceManager.registerReloadListener(this.renderItem);
        this.entityRenderer = new EntityRenderer(this, this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.entityRenderer);
        this.blockRenderDispatcher = new BlockRendererDispatcher(this.modelManager.getBlockModelShapes(), this.blockColors);
        this.mcResourceManager.registerReloadListener(this.blockRenderDispatcher);
        this.renderGlobal = new RenderGlobal(this);
        this.mcResourceManager.registerReloadListener(this.renderGlobal);
        this.func_193986_ar();
        this.mcResourceManager.registerReloadListener(this.field_193995_ae);
        GlStateManager.viewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new ParticleManager(this.world, this.renderEngine);
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);
        if (this.serverName != null) {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        }
        else {
            this.displayGuiScreen(new GuiMainMenu());
        }
        this.renderEngine.deleteTexture(this.mojangLogo);
        this.mojangLogo = null;
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.debugRenderer = new DebugRenderer(this);
        if (this.gameSettings.fullScreen && !this.fullscreen) {
            this.toggleFullscreen();
        }
        try {
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
        }
        catch (OpenGLException lllllllllllIlllIIIllllIIllIlIIll) {
            this.gameSettings.enableVsync = false;
            this.gameSettings.saveOptions();
        }
        Main.instance.startClient();
        this.renderGlobal.makeEntityOutlineShader();
    }
    
    public void setConnectedToRealms(final boolean lllllllllllIlllIIIlllIIlIlIllIll) {
        this.connectedToRealms = lllllllllllIlllIIIlllIIlIlIllIll;
    }
    
    public float getRenderPartialTicks() {
        return this.timer.elapsedPartialTicks;
    }
    
    private ByteBuffer readImageToBuffer(final InputStream lllllllllllIlllIIIllllIIIlIllIIl) throws IOException {
        final BufferedImage lllllllllllIlllIIIllllIIIlIllIII = ImageIO.read(lllllllllllIlllIIIllllIIIlIllIIl);
        final int[] lllllllllllIlllIIIllllIIIlIlIlll = lllllllllllIlllIIIllllIIIlIllIII.getRGB(0, 0, lllllllllllIlllIIIllllIIIlIllIII.getWidth(), lllllllllllIlllIIIllllIIIlIllIII.getHeight(), null, 0, lllllllllllIlllIIIllllIIIlIllIII.getWidth());
        final ByteBuffer lllllllllllIlllIIIllllIIIlIlIllI = ByteBuffer.allocate(4 * lllllllllllIlllIIIllllIIIlIlIlll.length);
        int lllllllllllIlllIIIllllIIIlIIllIl;
        for (char lllllllllllIlllIIIllllIIIlIIlllI = (char)((int[])(Object)(lllllllllllIlllIIIllllIIIlIIllIl = (int)(Object)lllllllllllIlllIIIllllIIIlIlIlll)).length, lllllllllllIlllIIIllllIIIlIIllll = '\0'; lllllllllllIlllIIIllllIIIlIIllll < lllllllllllIlllIIIllllIIIlIIlllI; ++lllllllllllIlllIIIllllIIIlIIllll) {
            final int lllllllllllIlllIIIllllIIIlIlIlIl = lllllllllllIlllIIIllllIIIlIIllIl[lllllllllllIlllIIIllllIIIlIIllll];
            lllllllllllIlllIIIllllIIIlIlIllI.putInt(lllllllllllIlllIIIllllIIIlIlIlIl << 8 | (lllllllllllIlllIIIllllIIIlIlIlIl >> 24 & 0xFF));
        }
        lllllllllllIlllIIIllllIIIlIlIllI.flip();
        return lllllllllllIlllIIIllllIIIlIlIllI;
    }
    
    public float func_193989_ak() {
        return (float)this.timer.elapsedTicks;
    }
    
    public ISaveFormat getSaveLoader() {
        return this.saveLoader;
    }
    
    public void setSession(final Session lllllllllllIlllIIIllllIIllIlIlll) {
        this.session = lllllllllllIlllIIIllllIIllIlIlll;
    }
    
    private void processKeyBinds() {
        while (this.gameSettings.keyBindTogglePerspective.isPressed()) {
            final GameSettings gameSettings = this.gameSettings;
            ++gameSettings.thirdPersonView;
            if (this.gameSettings.thirdPersonView > 2) {
                this.gameSettings.thirdPersonView = 0;
            }
            if (this.gameSettings.thirdPersonView == 0) {
                this.entityRenderer.loadEntityShader(this.getRenderViewEntity());
            }
            else if (this.gameSettings.thirdPersonView == 1) {
                this.entityRenderer.loadEntityShader(null);
            }
            this.renderGlobal.setDisplayListEntitiesDirty();
        }
        while (this.gameSettings.keyBindSmoothCamera.isPressed()) {
            this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
        }
        for (int lllllllllllIlllIIIlllIlIllIIIlll = 0; lllllllllllIlllIIIlllIlIllIIIlll < 9; ++lllllllllllIlllIIIlllIlIllIIIlll) {
            final boolean lllllllllllIlllIIIlllIlIllIIIllI = this.gameSettings.field_193629_ap.isKeyDown();
            final boolean lllllllllllIlllIIIlllIlIllIIIlIl = this.gameSettings.field_193630_aq.isKeyDown();
            if (this.gameSettings.keyBindsHotbar[lllllllllllIlllIIIlllIlIllIIIlll].isPressed()) {
                if (this.player.isSpectator()) {
                    this.ingameGUI.getSpectatorGui().onHotbarSelected(lllllllllllIlllIIIlllIlIllIIIlll);
                }
                else if (!this.player.isCreative() || this.currentScreen != null || (!lllllllllllIlllIIIlllIlIllIIIlIl && !lllllllllllIlllIIIlllIlIllIIIllI)) {
                    this.player.inventory.currentItem = lllllllllllIlllIIIlllIlIllIIIlll;
                }
                else {
                    GuiContainerCreative.func_192044_a(this, lllllllllllIlllIIIlllIlIllIIIlll, lllllllllllIlllIIIlllIlIllIIIlIl, lllllllllllIlllIIIlllIlIllIIIllI);
                }
            }
        }
        while (this.gameSettings.keyBindInventory.isPressed()) {
            if (this.playerController.isRidingHorse()) {
                this.player.sendHorseInventory();
            }
            else {
                this.field_193035_aW.func_193296_a();
                this.displayGuiScreen(new GuiInventory(this.player));
            }
        }
        while (this.gameSettings.field_194146_ao.isPressed()) {
            this.displayGuiScreen(new GuiScreenAdvancements(this.player.connection.func_191982_f()));
        }
        while (this.gameSettings.keyBindSwapHands.isPressed()) {
            if (!this.player.isSpectator()) {
                this.getConnection().sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.SWAP_HELD_ITEMS, BlockPos.ORIGIN, EnumFacing.DOWN));
            }
        }
        while (this.gameSettings.keyBindDrop.isPressed()) {
            if (!this.player.isSpectator()) {
                this.player.dropItem(GuiScreen.isCtrlKeyDown());
            }
        }
        final boolean lllllllllllIlllIIIlllIlIllIIIlII = this.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN;
        if (lllllllllllIlllIIIlllIlIllIIIlII) {
            while (this.gameSettings.keyBindChat.isPressed()) {
                this.displayGuiScreen(new GuiChat());
            }
            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed()) {
                this.displayGuiScreen(new GuiChat("/"));
            }
        }
        if (this.player.isHandActive()) {
            if (!this.gameSettings.keyBindUseItem.isKeyDown()) {
                this.playerController.onStoppedUsingItem(this.player);
            }
            while (this.gameSettings.keyBindAttack.isPressed()) {}
            while (this.gameSettings.keyBindUseItem.isPressed()) {}
            while (this.gameSettings.keyBindPickBlock.isPressed()) {}
        }
        else {
            while (this.gameSettings.keyBindAttack.isPressed()) {
                this.clickMouse();
            }
            while (this.gameSettings.keyBindUseItem.isPressed()) {
                this.rightClickMouse();
            }
            while (this.gameSettings.keyBindPickBlock.isPressed()) {
                this.middleClickMouse();
            }
        }
        if (this.gameSettings.keyBindUseItem.isKeyDown() && this.rightClickDelayTimer == 0 && !this.player.isHandActive()) {
            this.rightClickMouse();
        }
        this.sendClickBlockToController(this.currentScreen == null && this.gameSettings.keyBindAttack.isKeyDown() && this.inGameHasFocus);
    }
    
    public static boolean isGuiEnabled() {
        return Minecraft.theMinecraft == null || !Minecraft.theMinecraft.gameSettings.hideGUI;
    }
    
    private void middleClickMouse() {
        if (this.objectMouseOver != null && this.objectMouseOver.typeOfHit != RayTraceResult.Type.MISS) {
            final boolean lllllllllllIlllIIIlllIlIIlIIlIIl = this.player.capabilities.isCreativeMode;
            TileEntity lllllllllllIlllIIIlllIlIIlIIlIII = null;
            ItemStack lllllllllllIlllIIIlllIlIIIlllllI = null;
            if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos lllllllllllIlllIIIlllIlIIIllllIl = this.objectMouseOver.getBlockPos();
                final IBlockState lllllllllllIlllIIIlllIlIIIllllII = this.world.getBlockState(lllllllllllIlllIIIlllIlIIIllllIl);
                final Block lllllllllllIlllIIIlllIlIIIlllIll = lllllllllllIlllIIIlllIlIIIllllII.getBlock();
                if (lllllllllllIlllIIIlllIlIIIllllII.getMaterial() == Material.AIR) {
                    return;
                }
                final ItemStack lllllllllllIlllIIIlllIlIIlIIIlll = lllllllllllIlllIIIlllIlIIIlllIll.getItem(this.world, lllllllllllIlllIIIlllIlIIIllllIl, lllllllllllIlllIIIlllIlIIIllllII);
                if (lllllllllllIlllIIIlllIlIIlIIIlll.func_190926_b()) {
                    return;
                }
                if (lllllllllllIlllIIIlllIlIIlIIlIIl && GuiScreen.isCtrlKeyDown() && lllllllllllIlllIIIlllIlIIIlllIll.hasTileEntity()) {
                    lllllllllllIlllIIIlllIlIIlIIlIII = this.world.getTileEntity(lllllllllllIlllIIIlllIlIIIllllIl);
                }
            }
            else {
                if (this.objectMouseOver.typeOfHit != RayTraceResult.Type.ENTITY || this.objectMouseOver.entityHit == null || !lllllllllllIlllIIIlllIlIIlIIlIIl) {
                    return;
                }
                if (this.objectMouseOver.entityHit instanceof EntityPainting) {
                    final ItemStack lllllllllllIlllIIIlllIlIIlIIIllI = new ItemStack(Items.PAINTING);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityLeashKnot) {
                    final ItemStack lllllllllllIlllIIIlllIlIIlIIIlIl = new ItemStack(Items.LEAD);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityItemFrame) {
                    final EntityItemFrame lllllllllllIlllIIIlllIlIIIlllIlI = (EntityItemFrame)this.objectMouseOver.entityHit;
                    final ItemStack lllllllllllIlllIIIlllIlIIIlllIIl = lllllllllllIlllIIIlllIlIIIlllIlI.getDisplayedItem();
                    if (lllllllllllIlllIIIlllIlIIIlllIIl.func_190926_b()) {
                        final ItemStack lllllllllllIlllIIIlllIlIIlIIIlII = new ItemStack(Items.ITEM_FRAME);
                    }
                    else {
                        final ItemStack lllllllllllIlllIIIlllIlIIlIIIIll = lllllllllllIlllIIIlllIlIIIlllIIl.copy();
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityMinecart) {
                    final EntityMinecart lllllllllllIlllIIIlllIlIIIlllIII = (EntityMinecart)this.objectMouseOver.entityHit;
                    final Item lllllllllllIlllIIIlllIlIIIllIIlI;
                    switch ($SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type()[lllllllllllIlllIIIlllIlIIIlllIII.getType().ordinal()]) {
                        case 3: {
                            final Item lllllllllllIlllIIIlllIlIIIllIlll = Items.FURNACE_MINECART;
                            break;
                        }
                        case 2: {
                            final Item lllllllllllIlllIIIlllIlIIIllIllI = Items.CHEST_MINECART;
                            break;
                        }
                        case 4: {
                            final Item lllllllllllIlllIIIlllIlIIIllIlIl = Items.TNT_MINECART;
                            break;
                        }
                        case 6: {
                            final Item lllllllllllIlllIIIlllIlIIIllIlII = Items.HOPPER_MINECART;
                            break;
                        }
                        case 7: {
                            final Item lllllllllllIlllIIIlllIlIIIllIIll = Items.COMMAND_BLOCK_MINECART;
                            break;
                        }
                        default: {
                            lllllllllllIlllIIIlllIlIIIllIIlI = Items.MINECART;
                            break;
                        }
                    }
                    final ItemStack lllllllllllIlllIIIlllIlIIlIIIIlI = new ItemStack(lllllllllllIlllIIIlllIlIIIllIIlI);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityBoat) {
                    final ItemStack lllllllllllIlllIIIlllIlIIlIIIIIl = new ItemStack(((EntityBoat)this.objectMouseOver.entityHit).getItemBoat());
                }
                else if (this.objectMouseOver.entityHit instanceof EntityArmorStand) {
                    final ItemStack lllllllllllIlllIIIlllIlIIlIIIIII = new ItemStack(Items.ARMOR_STAND);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityEnderCrystal) {
                    final ItemStack lllllllllllIlllIIIlllIlIIIllllll = new ItemStack(Items.END_CRYSTAL);
                }
                else {
                    final ResourceLocation lllllllllllIlllIIIlllIlIIIllIIIl = EntityList.func_191301_a(this.objectMouseOver.entityHit);
                    if (lllllllllllIlllIIIlllIlIIIllIIIl == null || !EntityList.ENTITY_EGGS.containsKey(lllllllllllIlllIIIlllIlIIIllIIIl)) {
                        return;
                    }
                    lllllllllllIlllIIIlllIlIIIlllllI = new ItemStack(Items.SPAWN_EGG);
                    ItemMonsterPlacer.applyEntityIdToItemStack(lllllllllllIlllIIIlllIlIIIlllllI, lllllllllllIlllIIIlllIlIIIllIIIl);
                }
            }
            if (lllllllllllIlllIIIlllIlIIIlllllI.func_190926_b()) {
                String lllllllllllIlllIIIlllIlIIIllIIII = "";
                if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                    lllllllllllIlllIIIlllIlIIIllIIII = Block.REGISTRY.getNameForObject(this.world.getBlockState(this.objectMouseOver.getBlockPos()).getBlock()).toString();
                }
                else if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
                    lllllllllllIlllIIIlllIlIIIllIIII = EntityList.func_191301_a(this.objectMouseOver.entityHit).toString();
                }
                Minecraft.LOGGER.warn("Picking on: [{}] {} gave null item", (Object)this.objectMouseOver.typeOfHit, (Object)lllllllllllIlllIIIlllIlIIIllIIII);
            }
            else {
                final InventoryPlayer lllllllllllIlllIIIlllIlIIIlIllll = this.player.inventory;
                if (lllllllllllIlllIIIlllIlIIlIIlIII != null) {
                    this.storeTEInStack(lllllllllllIlllIIIlllIlIIIlllllI, lllllllllllIlllIIIlllIlIIlIIlIII);
                }
                final int lllllllllllIlllIIIlllIlIIIlIlllI = lllllllllllIlllIIIlllIlIIIlIllll.getSlotFor(lllllllllllIlllIIIlllIlIIIlllllI);
                if (lllllllllllIlllIIIlllIlIIlIIlIIl) {
                    lllllllllllIlllIIIlllIlIIIlIllll.setPickedItemStack(lllllllllllIlllIIIlllIlIIIlllllI);
                    this.playerController.sendSlotPacket(this.player.getHeldItem(EnumHand.MAIN_HAND), 36 + lllllllllllIlllIIIlllIlIIIlIllll.currentItem);
                }
                else if (lllllllllllIlllIIIlllIlIIIlIlllI != -1) {
                    if (InventoryPlayer.isHotbar(lllllllllllIlllIIIlllIlIIIlIlllI)) {
                        lllllllllllIlllIIIlllIlIIIlIllll.currentItem = lllllllllllIlllIIIlllIlIIIlIlllI;
                    }
                    else {
                        this.playerController.pickItem(lllllllllllIlllIIIlllIlIIIlIlllI);
                    }
                }
            }
        }
    }
    
    public MinecraftSessionService getSessionService() {
        return this.sessionService;
    }
    
    public Snooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    public boolean isFramerateLimitBelowMax() {
        return this.getLimitFramerate() < GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
    }
    
    public void runTick() throws IOException {
        if (this.rightClickDelayTimer > 0) {
            --this.rightClickDelayTimer;
        }
        this.mcProfiler.startSection("gui");
        if (!this.isGamePaused) {
            this.ingameGUI.updateTick();
        }
        this.mcProfiler.endSection();
        this.entityRenderer.getMouseOver(1.0f);
        this.field_193035_aW.func_193297_a(this.world, this.objectMouseOver);
        this.mcProfiler.startSection("gameMode");
        if (!this.isGamePaused && this.world != null) {
            this.playerController.updateController();
        }
        this.mcProfiler.endStartSection("textures");
        if (this.world != null) {
            this.renderEngine.tick();
        }
        if (this.currentScreen == null && this.player != null) {
            if (this.player.getHealth() <= 0.0f && !(this.currentScreen instanceof GuiGameOver)) {
                this.displayGuiScreen(null);
            }
            else if (this.player.isPlayerSleeping() && this.world != null) {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.player.isPlayerSleeping()) {
            this.displayGuiScreen(null);
        }
        if (this.currentScreen != null) {
            this.leftClickCounter = 10000;
        }
        if (this.currentScreen != null) {
            try {
                this.currentScreen.handleInput();
            }
            catch (Throwable lllllllllllIlllIIIlllIlIllllIllI) {
                final CrashReport lllllllllllIlllIIIlllIlIllllIlIl = CrashReport.makeCrashReport(lllllllllllIlllIIIlllIlIllllIllI, "Updating screen events");
                final CrashReportCategory lllllllllllIlllIIIlllIlIllllIlII = lllllllllllIlllIIIlllIlIllllIlIl.makeCategory("Affected screen");
                lllllllllllIlllIIIlllIlIllllIlII.setDetail("Screen name", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return Minecraft.this.currentScreen.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(lllllllllllIlllIIIlllIlIllllIlIl);
            }
            if (this.currentScreen != null) {
                try {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable lllllllllllIlllIIIlllIlIllllIIll) {
                    final CrashReport lllllllllllIlllIIIlllIlIllllIIlI = CrashReport.makeCrashReport(lllllllllllIlllIIIlllIlIllllIIll, "Ticking screen");
                    final CrashReportCategory lllllllllllIlllIIIlllIlIllllIIIl = lllllllllllIlllIIIlllIlIllllIIlI.makeCategory("Affected screen");
                    lllllllllllIlllIIIlllIlIllllIIIl.setDetail("Screen name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return Minecraft.this.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    throw new ReportedException(lllllllllllIlllIIIlllIlIllllIIlI);
                }
            }
        }
        if (this.currentScreen == null || this.currentScreen.allowUserInput) {
            this.mcProfiler.endStartSection("mouse");
            this.runTickMouse();
            if (this.leftClickCounter > 0) {
                --this.leftClickCounter;
            }
            this.mcProfiler.endStartSection("keyboard");
            this.runTickKeyboard();
        }
        if (this.world != null) {
            if (this.player != null) {
                ++this.joinPlayerCounter;
                if (this.joinPlayerCounter == 30) {
                    this.joinPlayerCounter = 0;
                    this.world.joinEntityInSurroundings(this.player);
                }
            }
            this.mcProfiler.endStartSection("gameRenderer");
            if (!this.isGamePaused) {
                this.entityRenderer.updateRenderer();
            }
            this.mcProfiler.endStartSection("levelRenderer");
            if (!this.isGamePaused) {
                this.renderGlobal.updateClouds();
            }
            this.mcProfiler.endStartSection("level");
            if (!this.isGamePaused) {
                if (this.world.getLastLightningBolt() > 0) {
                    this.world.setLastLightningBolt(this.world.getLastLightningBolt() - 1);
                }
                this.world.updateEntities();
            }
        }
        else if (this.entityRenderer.isShaderActive()) {
            this.entityRenderer.stopUseShader();
        }
        if (!this.isGamePaused) {
            this.mcMusicTicker.update();
            this.mcSoundHandler.update();
        }
        if (this.world != null) {
            if (!this.isGamePaused) {
                this.world.setAllowedSpawnTypes(this.world.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                this.field_193035_aW.func_193303_d();
                try {
                    this.world.tick();
                }
                catch (Throwable lllllllllllIlllIIIlllIlIllllIIII) {
                    final CrashReport lllllllllllIlllIIIlllIlIlllIllll = CrashReport.makeCrashReport(lllllllllllIlllIIIlllIlIllllIIII, "Exception in world tick");
                    if (this.world == null) {
                        final CrashReportCategory lllllllllllIlllIIIlllIlIlllIlllI = lllllllllllIlllIIIlllIlIlllIllll.makeCategory("Affected level");
                        lllllllllllIlllIIIlllIlIlllIlllI.addCrashSection("Problem", "Level is null!");
                    }
                    else {
                        this.world.addWorldInfoToCrashReport(lllllllllllIlllIIIlllIlIlllIllll);
                    }
                    throw new ReportedException(lllllllllllIlllIIIlllIlIlllIllll);
                }
            }
            this.mcProfiler.endStartSection("animateTick");
            if (!this.isGamePaused && this.world != null) {
                this.world.doVoidFogParticles(MathHelper.floor(this.player.posX), MathHelper.floor(this.player.posY), MathHelper.floor(this.player.posZ));
            }
            this.mcProfiler.endStartSection("particles");
            if (!this.isGamePaused) {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null) {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReceivedPackets();
        }
        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }
    
    public void draw(final int lllllllllllIlllIIIllllIIIIIIIlll, final int lllllllllllIlllIIIllllIIIIIIIllI, final int lllllllllllIlllIIIllllIIIIIIIlIl, final int lllllllllllIlllIIIlllIllllllIlll, final int lllllllllllIlllIIIllllIIIIIIIIll, final int lllllllllllIlllIIIllllIIIIIIIIlI, final int lllllllllllIlllIIIlllIllllllIlII, final int lllllllllllIlllIIIllllIIIIIIIIII, final int lllllllllllIlllIIIlllIllllllllll, final int lllllllllllIlllIIIlllIlllllllllI) {
        final BufferBuilder lllllllllllIlllIIIlllIllllllllIl = Tessellator.getInstance().getBuffer();
        lllllllllllIlllIIIlllIllllllllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        final float lllllllllllIlllIIIlllIllllllllII = 0.00390625f;
        final float lllllllllllIlllIIIlllIlllllllIll = 0.00390625f;
        lllllllllllIlllIIIlllIllllllllIl.pos(lllllllllllIlllIIIllllIIIIIIIlll, lllllllllllIlllIIIllllIIIIIIIllI + lllllllllllIlllIIIllllIIIIIIIIlI, 0.0).tex(lllllllllllIlllIIIllllIIIIIIIlIl * 0.00390625f, (lllllllllllIlllIIIlllIllllllIlll + lllllllllllIlllIIIllllIIIIIIIIlI) * 0.00390625f).color(lllllllllllIlllIIIlllIllllllIlII, lllllllllllIlllIIIllllIIIIIIIIII, lllllllllllIlllIIIlllIllllllllll, lllllllllllIlllIIIlllIlllllllllI).endVertex();
        lllllllllllIlllIIIlllIllllllllIl.pos(lllllllllllIlllIIIllllIIIIIIIlll + lllllllllllIlllIIIllllIIIIIIIIll, lllllllllllIlllIIIllllIIIIIIIllI + lllllllllllIlllIIIllllIIIIIIIIlI, 0.0).tex((lllllllllllIlllIIIllllIIIIIIIlIl + lllllllllllIlllIIIllllIIIIIIIIll) * 0.00390625f, (lllllllllllIlllIIIlllIllllllIlll + lllllllllllIlllIIIllllIIIIIIIIlI) * 0.00390625f).color(lllllllllllIlllIIIlllIllllllIlII, lllllllllllIlllIIIllllIIIIIIIIII, lllllllllllIlllIIIlllIllllllllll, lllllllllllIlllIIIlllIlllllllllI).endVertex();
        lllllllllllIlllIIIlllIllllllllIl.pos(lllllllllllIlllIIIllllIIIIIIIlll + lllllllllllIlllIIIllllIIIIIIIIll, lllllllllllIlllIIIllllIIIIIIIllI, 0.0).tex((lllllllllllIlllIIIllllIIIIIIIlIl + lllllllllllIlllIIIllllIIIIIIIIll) * 0.00390625f, lllllllllllIlllIIIlllIllllllIlll * 0.00390625f).color(lllllllllllIlllIIIlllIllllllIlII, lllllllllllIlllIIIllllIIIIIIIIII, lllllllllllIlllIIIlllIllllllllll, lllllllllllIlllIIIlllIlllllllllI).endVertex();
        lllllllllllIlllIIIlllIllllllllIl.pos(lllllllllllIlllIIIllllIIIIIIIlll, lllllllllllIlllIIIllllIIIIIIIllI, 0.0).tex(lllllllllllIlllIIIllllIIIIIIIlIl * 0.00390625f, lllllllllllIlllIIIlllIllllllIlll * 0.00390625f).color(lllllllllllIlllIIIlllIllllllIlII, lllllllllllIlllIIIllllIIIIIIIIII, lllllllllllIlllIIIlllIllllllllll, lllllllllllIlllIIIlllIlllllllllI).endVertex();
        Tessellator.getInstance().draw();
    }
    
    @Nullable
    public Entity getRenderViewEntity() {
        return this.renderViewEntity;
    }
    
    public MusicTicker.MusicType getAmbientMusicType() {
        if (this.currentScreen instanceof GuiWinGame) {
            return MusicTicker.MusicType.CREDITS;
        }
        if (this.player == null) {
            return MusicTicker.MusicType.MENU;
        }
        if (this.player.world.provider instanceof WorldProviderHell) {
            return MusicTicker.MusicType.NETHER;
        }
        if (this.player.world.provider instanceof WorldProviderEnd) {
            return this.ingameGUI.getBossOverlay().shouldPlayEndBossMusic() ? MusicTicker.MusicType.END_BOSS : MusicTicker.MusicType.END;
        }
        return (this.player.capabilities.isCreativeMode && this.player.capabilities.allowFlying) ? MusicTicker.MusicType.CREATIVE : MusicTicker.MusicType.GAME;
    }
    
    public <T> ISearchTree<T> func_193987_a(final SearchTreeManager.Key<T> lllllllllllIlllIIIlllIIlIllIIlIl) {
        return this.field_193995_ae.func_194010_a(lllllllllllIlllIIIlllIIlIllIIlIl);
    }
    
    public boolean isConnectedToRealms() {
        return this.connectedToRealms;
    }
    
    public void loadWorld(@Nullable final WorldClient lllllllllllIlllIIIlllIlIIllIllII, final String lllllllllllIlllIIIlllIlIIllIlIll) {
        if (lllllllllllIlllIIIlllIlIIllIllII == null) {
            final NetHandlerPlayClient lllllllllllIlllIIIlllIlIIlllIIlI = this.getConnection();
            if (lllllllllllIlllIIIlllIlIIlllIIlI != null) {
                lllllllllllIlllIIIlllIlIIlllIIlI.cleanup();
            }
            if (this.theIntegratedServer != null && this.theIntegratedServer.isAnvilFileSet()) {
                this.theIntegratedServer.initiateShutdown();
            }
            this.theIntegratedServer = null;
            this.entityRenderer.func_190564_k();
            this.playerController = null;
            NarratorChatListener.field_193643_a.func_193642_b();
        }
        this.renderViewEntity = null;
        this.myNetworkManager = null;
        if (this.loadingScreen != null) {
            this.loadingScreen.resetProgressAndMessage(lllllllllllIlllIIIlllIlIIllIlIll);
            if (!Main.featureDirector.getFeatureByClass(FastWorldLoad.class).isToggled()) {
                this.loadingScreen.displayLoadingString("");
            }
        }
        if (lllllllllllIlllIIIlllIlIIllIllII == null && this.world != null) {
            this.mcResourcePackRepository.clearResourcePack();
            this.ingameGUI.resetPlayersOverlayFooterHeader();
            this.setServerData(null);
            this.integratedServerIsRunning = false;
        }
        this.mcSoundHandler.stopSounds();
        this.world = lllllllllllIlllIIIlllIlIIllIllII;
        if (this.renderGlobal != null) {
            this.renderGlobal.setWorldAndLoadRenderers(lllllllllllIlllIIIlllIlIIllIllII);
        }
        if (this.effectRenderer != null) {
            this.effectRenderer.clearEffects(lllllllllllIlllIIIlllIlIIllIllII);
        }
        TileEntityRendererDispatcher.instance.setWorld(lllllllllllIlllIIIlllIlIIllIllII);
        if (lllllllllllIlllIIIlllIlIIllIllII != null) {
            if (!Main.featureDirector.getFeatureByClass(FastWorldLoad.class).isToggled() && !this.integratedServerIsRunning) {
                final AuthenticationService lllllllllllIlllIIIlllIlIIlllIIIl = (AuthenticationService)new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString());
                final MinecraftSessionService lllllllllllIlllIIIlllIlIIlllIIII = lllllllllllIlllIIIlllIlIIlllIIIl.createMinecraftSessionService();
                final GameProfileRepository lllllllllllIlllIIIlllIlIIllIllll = lllllllllllIlllIIIlllIlIIlllIIIl.createProfileRepository();
                final PlayerProfileCache lllllllllllIlllIIIlllIlIIllIlllI = new PlayerProfileCache(lllllllllllIlllIIIlllIlIIllIllll, new File(this.mcDataDir, MinecraftServer.USER_CACHE_FILE.getName()));
                TileEntitySkull.setProfileCache(lllllllllllIlllIIIlllIlIIllIlllI);
                TileEntitySkull.setSessionService(lllllllllllIlllIIIlllIlIIlllIIII);
                PlayerProfileCache.setOnlineMode(false);
            }
            if (this.player == null) {
                this.player = this.playerController.func_192830_a(lllllllllllIlllIIIlllIlIIllIllII, new StatisticsManager(), new RecipeBookClient());
                this.playerController.flipPlayer(this.player);
            }
            this.player.preparePlayerToSpawn();
            lllllllllllIlllIIIlllIlIIllIllII.spawnEntityInWorld(this.player);
            this.player.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.player);
            this.renderViewEntity = this.player;
        }
        else {
            this.saveLoader.flushCache();
            this.player = null;
        }
        if (!Main.featureDirector.getFeatureByClass(FastWorldLoad.class).isToggled()) {
            System.gc();
        }
        this.systemTime = 0L;
    }
    
    @Nullable
    public NetHandlerPlayClient getConnection() {
        return (this.player == null) ? null : this.player.connection;
    }
    
    public BlockColors getBlockColors() {
        return this.blockColors;
    }
    
    public static int getGLMaximumTextureSize() {
        for (int lllllllllllIlllIIIlllIIllllIlIIl = 16384; lllllllllllIlllIIIlllIIllllIlIIl > 0; lllllllllllIlllIIIlllIIllllIlIIl >>= 1) {
            GlStateManager.glTexImage2D(32868, 0, 6408, lllllllllllIlllIIIlllIIllllIlIIl, lllllllllllIlllIIIlllIIllllIlIIl, 0, 6408, 5121, null);
            final int lllllllllllIlllIIIlllIIllllIlIII = GlStateManager.glGetTexLevelParameteri(32868, 0, 4096);
            if (lllllllllllIlllIIIlllIIllllIlIII != 0) {
                return lllllllllllIlllIIIlllIIllllIlIIl;
            }
        }
        return -1;
    }
    
    public LanguageManager getLanguageManager() {
        return this.mcLanguageManager;
    }
    
    public void run() {
        this.running = true;
        try {
            this.startGame();
        }
        catch (Throwable lllllllllllIlllIIIllllIIlllIIlll) {
            final CrashReport lllllllllllIlllIIIllllIIlllIIllI = CrashReport.makeCrashReport(lllllllllllIlllIIIllllIIlllIIlll, "Initializing game");
            lllllllllllIlllIIIllllIIlllIIllI.makeCategory("Initialization");
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(lllllllllllIlllIIIllllIIlllIIllI));
            return;
        }
        try {
            do {
                if (this.hasCrashed) {
                    if (this.crashReporter != null) {
                        this.displayCrashReport(this.crashReporter);
                        continue;
                    }
                }
                try {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError lllllllllllIlllIIIllllIIlllIIlIl) {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            } while (this.running);
        }
        catch (MinecraftError lllllllllllIlllIIIllllIIlllIIlII) {}
        catch (ReportedException lllllllllllIlllIIIllllIIlllIIIll) {
            this.addGraphicsAndWorldToCrashReport(lllllllllllIlllIIIllllIIlllIIIll.getCrashReport());
            this.freeMemory();
            Minecraft.LOGGER.fatal("Reported exception thrown!", (Throwable)lllllllllllIlllIIIllllIIlllIIIll);
            this.displayCrashReport(lllllllllllIlllIIIllllIIlllIIIll.getCrashReport());
        }
        catch (Throwable lllllllllllIlllIIIllllIIlllIIIlI) {
            final CrashReport lllllllllllIlllIIIllllIIlllIIIIl = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", lllllllllllIlllIIIllllIIlllIIIlI));
            this.freeMemory();
            Minecraft.LOGGER.fatal("Unreported exception thrown!", lllllllllllIlllIIIllllIIlllIIIlI);
            this.displayCrashReport(lllllllllllIlllIIIllllIIlllIIIIl);
        }
        finally {
            this.shutdownMinecraftApplet();
        }
        this.shutdownMinecraftApplet();
    }
    
    public DataFixer getDataFixer() {
        return this.dataFixer;
    }
    
    public void setServerData(final ServerData lllllllllllIlllIIIlllIIlllIlllIl) {
        this.currentServerData = lllllllllllIlllIIIlllIIlllIlllIl;
    }
    
    public void shutdown() {
        this.running = false;
    }
    
    public String getVersionType() {
        return this.versionType;
    }
    
    private void drawSplashScreen(final TextureManager lllllllllllIlllIIIllllIIIIIllllI) throws LWJGLException {
        final ScaledResolution lllllllllllIlllIIIllllIIIIlIlIII = new ScaledResolution(this);
        final int lllllllllllIlllIIIllllIIIIlIIlll = ScaledResolution.getScaleFactor();
        final Framebuffer lllllllllllIlllIIIllllIIIIlIIllI = new Framebuffer(lllllllllllIlllIIIllllIIIIlIlIII.getScaledWidth() * lllllllllllIlllIIIllllIIIIlIIlll, lllllllllllIlllIIIllllIIIIlIlIII.getScaledHeight() * lllllllllllIlllIIIllllIIIIlIIlll, true);
        lllllllllllIlllIIIllllIIIIlIIllI.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, lllllllllllIlllIIIllllIIIIlIlIII.getScaledWidth(), lllllllllllIlllIIIllllIIIIlIlIII.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        InputStream lllllllllllIlllIIIllllIIIIlIIlIl = null;
        Label_0190: {
            try {
                lllllllllllIlllIIIllllIIIIlIIlIl = this.mcDefaultResourcePack.getInputStream(Minecraft.LOCATION_MOJANG_PNG);
                this.mojangLogo = lllllllllllIlllIIIllllIIIIIllllI.getDynamicTextureLocation("logo", new DynamicTexture(ImageIO.read(lllllllllllIlllIIIllllIIIIlIIlIl)));
                lllllllllllIlllIIIllllIIIIIllllI.bindTexture(this.mojangLogo);
            }
            catch (IOException lllllllllllIlllIIIllllIIIIlIIlII) {
                Minecraft.LOGGER.error("Unable to load logo: {}", (Object)Minecraft.LOCATION_MOJANG_PNG, (Object)lllllllllllIlllIIIllllIIIIlIIlII);
                break Label_0190;
            }
            finally {
                IOUtils.closeQuietly(lllllllllllIlllIIIllllIIIIlIIlIl);
            }
            IOUtils.closeQuietly(lllllllllllIlllIIIllllIIIIlIIlIl);
        }
        final Tessellator lllllllllllIlllIIIllllIIIIlIIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIlllIIIllllIIIIlIIIlI = lllllllllllIlllIIIllllIIIIlIIIll.getBuffer();
        lllllllllllIlllIIIllllIIIIlIIIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllIlllIIIllllIIIIlIIIlI.pos(0.0, this.displayHeight, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lllllllllllIlllIIIllllIIIIlIIIlI.pos(this.displayWidth, this.displayHeight, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lllllllllllIlllIIIllllIIIIlIIIlI.pos(this.displayWidth, 0.0, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lllllllllllIlllIIIllllIIIIlIIIlI.pos(0.0, 0.0, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lllllllllllIlllIIIllllIIIIlIIIll.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllIlllIIIllllIIIIlIIIIl = 256;
        final int lllllllllllIlllIIIllllIIIIlIIIII = 256;
        this.draw((lllllllllllIlllIIIllllIIIIlIlIII.getScaledWidth() - 256) / 2, (lllllllllllIlllIIIllllIIIIlIlIII.getScaledHeight() - 256) / 2, 0, 0, 256, 256, 255, 255, 255, 255);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        lllllllllllIlllIIIllllIIIIlIIllI.unbindFramebuffer();
        lllllllllllIlllIIIllllIIIIlIIllI.framebufferRender(lllllllllllIlllIIIllllIIIIlIlIII.getScaledWidth() * lllllllllllIlllIIIllllIIIIlIIlll, lllllllllllIlllIIIllllIIIIlIlIII.getScaledHeight() * lllllllllllIlllIIIllllIIIIlIIlll);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.updateDisplay();
    }
    
    public GuiToast func_193033_an() {
        return this.field_193034_aS;
    }
    
    public void crashed(final CrashReport lllllllllllIlllIIIllllIIIllllllI) {
        this.hasCrashed = true;
        this.crashReporter = lllllllllllIlllIIIllllIIIllllllI;
    }
    
    public RenderManager getRenderManager() {
        return this.renderManager;
    }
    
    public static Minecraft getMinecraft() {
        return Minecraft.theMinecraft;
    }
    
    public boolean isIntegratedServerRunning() {
        return this.integratedServerIsRunning;
    }
    
    private void displayDebugInfo(final long lllllllllllIlllIIIlllIllIlllllII) {
        if (this.mcProfiler.profilingEnabled) {
            final List<Profiler.Result> lllllllllllIlllIIIlllIllIllllIll = this.mcProfiler.getProfilingData(this.debugProfilerName);
            final Profiler.Result lllllllllllIlllIIIlllIllIllllIlI = lllllllllllIlllIIIlllIllIllllIll.remove(0);
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, this.displayWidth, this.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GlStateManager.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            final Tessellator lllllllllllIlllIIIlllIllIllllIIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllIlllIIIlllIllIllllIII = lllllllllllIlllIIIlllIllIllllIIl.getBuffer();
            final int lllllllllllIlllIIIlllIllIlllIlll = 160;
            final int lllllllllllIlllIIIlllIllIlllIllI = this.displayWidth - 160 - 10;
            final int lllllllllllIlllIIIlllIllIlllIlIl = this.displayHeight - 320;
            GlStateManager.enableBlend();
            lllllllllllIlllIIIlllIllIllllIII.begin(7, DefaultVertexFormats.POSITION_COLOR);
            lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI - 176.0f, lllllllllllIlllIIIlllIllIlllIlIl - 96.0f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI - 176.0f, lllllllllllIlllIIIlllIllIlllIlIl + 320, 0.0).color(200, 0, 0, 0).endVertex();
            lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI + 176.0f, lllllllllllIlllIIIlllIllIlllIlIl + 320, 0.0).color(200, 0, 0, 0).endVertex();
            lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI + 176.0f, lllllllllllIlllIIIlllIllIlllIlIl - 96.0f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            lllllllllllIlllIIIlllIllIllllIIl.draw();
            GlStateManager.disableBlend();
            double lllllllllllIlllIIIlllIllIlllIlII = 0.0;
            for (int lllllllllllIlllIIIlllIllIlllIIll = 0; lllllllllllIlllIIIlllIllIlllIIll < lllllllllllIlllIIIlllIllIllllIll.size(); ++lllllllllllIlllIIIlllIllIlllIIll) {
                final Profiler.Result lllllllllllIlllIIIlllIllIlllIIlI = lllllllllllIlllIIIlllIllIllllIll.get(lllllllllllIlllIIIlllIllIlllIIll);
                final int lllllllllllIlllIIIlllIllIlllIIIl = MathHelper.floor(lllllllllllIlllIIIlllIllIlllIIlI.usePercentage / 4.0) + 1;
                lllllllllllIlllIIIlllIllIllllIII.begin(6, DefaultVertexFormats.POSITION_COLOR);
                final int lllllllllllIlllIIIlllIllIlllIIII = lllllllllllIlllIIIlllIllIlllIIlI.getColor();
                final int lllllllllllIlllIIIlllIllIllIllll = lllllllllllIlllIIIlllIllIlllIIII >> 16 & 0xFF;
                final int lllllllllllIlllIIIlllIllIllIlllI = lllllllllllIlllIIIlllIllIlllIIII >> 8 & 0xFF;
                final int lllllllllllIlllIIIlllIllIllIllIl = lllllllllllIlllIIIlllIllIlllIIII & 0xFF;
                lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI, lllllllllllIlllIIIlllIllIlllIlIl, 0.0).color(lllllllllllIlllIIIlllIllIllIllll, lllllllllllIlllIIIlllIllIllIlllI, lllllllllllIlllIIIlllIllIllIllIl, 255).endVertex();
                for (int lllllllllllIlllIIIlllIllIllIllII = lllllllllllIlllIIIlllIllIlllIIIl; lllllllllllIlllIIIlllIllIllIllII >= 0; --lllllllllllIlllIIIlllIllIllIllII) {
                    final float lllllllllllIlllIIIlllIllIllIlIll = (float)((lllllllllllIlllIIIlllIllIlllIlII + lllllllllllIlllIIIlllIllIlllIIlI.usePercentage * lllllllllllIlllIIIlllIllIllIllII / lllllllllllIlllIIIlllIllIlllIIIl) * 6.283185307179586 / 100.0);
                    final float lllllllllllIlllIIIlllIllIllIlIlI = MathHelper.sin(lllllllllllIlllIIIlllIllIllIlIll) * 160.0f;
                    final float lllllllllllIlllIIIlllIllIllIlIIl = MathHelper.cos(lllllllllllIlllIIIlllIllIllIlIll) * 160.0f * 0.5f;
                    lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI + lllllllllllIlllIIIlllIllIllIlIlI, lllllllllllIlllIIIlllIllIlllIlIl - lllllllllllIlllIIIlllIllIllIlIIl, 0.0).color(lllllllllllIlllIIIlllIllIllIllll, lllllllllllIlllIIIlllIllIllIlllI, lllllllllllIlllIIIlllIllIllIllIl, 255).endVertex();
                }
                lllllllllllIlllIIIlllIllIllllIIl.draw();
                lllllllllllIlllIIIlllIllIllllIII.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lllllllllllIlllIIIlllIllIllIlIII = lllllllllllIlllIIIlllIllIlllIIIl; lllllllllllIlllIIIlllIllIllIlIII >= 0; --lllllllllllIlllIIIlllIllIllIlIII) {
                    final float lllllllllllIlllIIIlllIllIllIIlll = (float)((lllllllllllIlllIIIlllIllIlllIlII + lllllllllllIlllIIIlllIllIlllIIlI.usePercentage * lllllllllllIlllIIIlllIllIllIlIII / lllllllllllIlllIIIlllIllIlllIIIl) * 6.283185307179586 / 100.0);
                    final float lllllllllllIlllIIIlllIllIllIIllI = MathHelper.sin(lllllllllllIlllIIIlllIllIllIIlll) * 160.0f;
                    final float lllllllllllIlllIIIlllIllIllIIlIl = MathHelper.cos(lllllllllllIlllIIIlllIllIllIIlll) * 160.0f * 0.5f;
                    lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI + lllllllllllIlllIIIlllIllIllIIllI, lllllllllllIlllIIIlllIllIlllIlIl - lllllllllllIlllIIIlllIllIllIIlIl, 0.0).color(lllllllllllIlllIIIlllIllIllIllll >> 1, lllllllllllIlllIIIlllIllIllIlllI >> 1, lllllllllllIlllIIIlllIllIllIllIl >> 1, 255).endVertex();
                    lllllllllllIlllIIIlllIllIllllIII.pos(lllllllllllIlllIIIlllIllIlllIllI + lllllllllllIlllIIIlllIllIllIIllI, lllllllllllIlllIIIlllIllIlllIlIl - lllllllllllIlllIIIlllIllIllIIlIl + 10.0f, 0.0).color(lllllllllllIlllIIIlllIllIllIllll >> 1, lllllllllllIlllIIIlllIllIllIlllI >> 1, lllllllllllIlllIIIlllIllIllIllIl >> 1, 255).endVertex();
                }
                lllllllllllIlllIIIlllIllIllllIIl.draw();
                lllllllllllIlllIIIlllIllIlllIlII += lllllllllllIlllIIIlllIllIlllIIlI.usePercentage;
            }
            final DecimalFormat lllllllllllIlllIIIlllIllIllIIlII = new DecimalFormat("##0.00");
            GlStateManager.enableTexture2D();
            String lllllllllllIlllIIIlllIllIllIIIll = "";
            if (!"unspecified".equals(lllllllllllIlllIIIlllIllIllllIlI.profilerName)) {
                lllllllllllIlllIIIlllIllIllIIIll = String.valueOf(lllllllllllIlllIIIlllIllIllIIIll) + "[0] ";
            }
            if (lllllllllllIlllIIIlllIllIllllIlI.profilerName.isEmpty()) {
                lllllllllllIlllIIIlllIllIllIIIll = String.valueOf(lllllllllllIlllIIIlllIllIllIIIll) + "ROOT ";
            }
            else {
                lllllllllllIlllIIIlllIllIllIIIll = String.valueOf(lllllllllllIlllIIIlllIllIllIIIll) + lllllllllllIlllIIIlllIllIllllIlI.profilerName + ' ';
            }
            final int lllllllllllIlllIIIlllIllIllIIIlI = 16777215;
            Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIIIlllIllIllIIIll, (float)(lllllllllllIlllIIIlllIllIlllIllI - 160), (float)(lllllllllllIlllIIIlllIllIlllIlIl - 80 - 16), 16777215);
            lllllllllllIlllIIIlllIllIllIIIll = String.valueOf(lllllllllllIlllIIIlllIllIllIIlII.format(lllllllllllIlllIIIlllIllIllllIlI.totalUsePercentage)) + "%";
            Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIIIlllIllIllIIIll, (float)(lllllllllllIlllIIIlllIllIlllIllI + 160 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIIIlllIllIllIIIll)), (float)(lllllllllllIlllIIIlllIllIlllIlIl - 80 - 16), 16777215);
            for (int lllllllllllIlllIIIlllIllIllIIIIl = 0; lllllllllllIlllIIIlllIllIllIIIIl < lllllllllllIlllIIIlllIllIllllIll.size(); ++lllllllllllIlllIIIlllIllIllIIIIl) {
                final Profiler.Result lllllllllllIlllIIIlllIllIllIIIII = lllllllllllIlllIIIlllIllIllllIll.get(lllllllllllIlllIIIlllIllIllIIIIl);
                final StringBuilder lllllllllllIlllIIIlllIllIlIlllll = new StringBuilder();
                if ("unspecified".equals(lllllllllllIlllIIIlllIllIllIIIII.profilerName)) {
                    lllllllllllIlllIIIlllIllIlIlllll.append("[?] ");
                }
                else {
                    lllllllllllIlllIIIlllIllIlIlllll.append("[").append(lllllllllllIlllIIIlllIllIllIIIIl + 1).append("] ");
                }
                String lllllllllllIlllIIIlllIllIlIllllI = lllllllllllIlllIIIlllIllIlIlllll.append(lllllllllllIlllIIIlllIllIllIIIII.profilerName).toString();
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIIIlllIllIlIllllI, (float)(lllllllllllIlllIIIlllIllIlllIllI - 160), (float)(lllllllllllIlllIIIlllIllIlllIlIl + 80 + lllllllllllIlllIIIlllIllIllIIIIl * 8 + 20), lllllllllllIlllIIIlllIllIllIIIII.getColor());
                lllllllllllIlllIIIlllIllIlIllllI = String.valueOf(lllllllllllIlllIIIlllIllIllIIlII.format(lllllllllllIlllIIIlllIllIllIIIII.usePercentage)) + "%";
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIIIlllIllIlIllllI, (float)(lllllllllllIlllIIIlllIllIlllIllI + 160 - 50 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIIIlllIllIlIllllI)), (float)(lllllllllllIlllIIIlllIllIlllIlIl + 80 + lllllllllllIlllIIIlllIllIllIIIIl * 8 + 20), lllllllllllIlllIIIlllIllIllIIIII.getColor());
                lllllllllllIlllIIIlllIllIlIllllI = String.valueOf(lllllllllllIlllIIIlllIllIllIIlII.format(lllllllllllIlllIIIlllIllIllIIIII.totalUsePercentage)) + "%";
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIIIlllIllIlIllllI, (float)(lllllllllllIlllIIIlllIllIlllIllI + 160 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIIIlllIllIlIllllI)), (float)(lllllllllllIlllIIIlllIllIlllIlIl + 80 + lllllllllllIlllIIIlllIllIllIIIIl * 8 + 20), lllllllllllIlllIIIlllIllIllIIIII.getColor());
            }
        }
    }
    
    private void setWindowIcon() {
        final Util.EnumOS lllllllllllIlllIIIllllIIlIlIlIIl = Util.getOSType();
        if (lllllllllllIlllIIIllllIIlIlIlIIl != Util.EnumOS.OSX) {
            InputStream lllllllllllIlllIIIllllIIlIlIlIII = null;
            InputStream lllllllllllIlllIIIllllIIlIlIIlll = null;
            try {
                lllllllllllIlllIIIllllIIlIlIlIII = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
                lllllllllllIlllIIIllllIIlIlIIlll = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));
                if (lllllllllllIlllIIIllllIIlIlIlIII != null && lllllllllllIlllIIIllllIIlIlIIlll != null) {
                    Display.setIcon(new ByteBuffer[] { this.readImageToBuffer(lllllllllllIlllIIIllllIIlIlIlIII), this.readImageToBuffer(lllllllllllIlllIIIllllIIlIlIIlll) });
                }
            }
            catch (IOException lllllllllllIlllIIIllllIIlIlIIllI) {
                Minecraft.LOGGER.error("Couldn't set icon", (Throwable)lllllllllllIlllIIIllllIIlIlIIllI);
                return;
            }
            finally {
                IOUtils.closeQuietly(lllllllllllIlllIIIllllIIlIlIlIII);
                IOUtils.closeQuietly(lllllllllllIlllIIIllllIIlIlIIlll);
            }
            IOUtils.closeQuietly(lllllllllllIlllIIIllllIIlIlIlIII);
            IOUtils.closeQuietly(lllllllllllIlllIIIllllIIlIlIIlll);
        }
    }
    
    public boolean isReducedDebug() {
        return (this.player != null && this.player.hasReducedDebug()) || this.gameSettings.reducedDebugInfo;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type() {
        final int[] $switch_TABLE$net$minecraft$util$math$RayTraceResult$Type = Minecraft.$SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type;
        if ($switch_TABLE$net$minecraft$util$math$RayTraceResult$Type != null) {
            return $switch_TABLE$net$minecraft$util$math$RayTraceResult$Type;
        }
        final String lllllllllllIlllIIIlllIIlIlIIIIlI = (Object)new int[RayTraceResult.Type.values().length];
        try {
            lllllllllllIlllIIIlllIIlIlIIIIlI[RayTraceResult.Type.BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIlI[RayTraceResult.Type.ENTITY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIIIlllIIlIlIIIIlI[RayTraceResult.Type.MISS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Minecraft.$SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type = (int[])(Object)lllllllllllIlllIIIlllIIlIlIIIIlI;
    }
    
    public boolean isUnicode() {
        return this.mcLanguageManager.isCurrentLocaleUnicode() || this.gameSettings.forceUnicodeFont;
    }
    
    public void dispatchKeypresses() {
        final int lllllllllllIlllIIIlllIIllIIlllIl = (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
        if (lllllllllllIlllIIIlllIIllIIlllIl != 0 && !Keyboard.isRepeatEvent() && (!(this.currentScreen instanceof GuiControls) || ((GuiControls)this.currentScreen).time <= getSystemTime() - 20L) && Keyboard.getEventKeyState()) {
            if (lllllllllllIlllIIIlllIIllIIlllIl == this.gameSettings.keyBindFullscreen.getKeyCode()) {
                this.toggleFullscreen();
            }
            else if (lllllllllllIlllIIIlllIIllIIlllIl == this.gameSettings.keyBindScreenshot.getKeyCode()) {
                this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(this.mcDataDir, this.displayWidth, this.displayHeight, this.framebufferMc));
            }
            else if (lllllllllllIlllIIIlllIIllIIlllIl == 48 && GuiScreen.isCtrlKeyDown() && (this.currentScreen == null || (this.currentScreen != null && !this.currentScreen.func_193976_p()))) {
                this.gameSettings.setOptionValue(GameSettings.Options.NARRATOR, 1);
                if (this.currentScreen instanceof ScreenChatOptions) {
                    ((ScreenChatOptions)this.currentScreen).func_193024_a();
                }
            }
        }
    }
    
    public final boolean isDemo() {
        return this.isDemo;
    }
    
    public boolean isSingleplayer() {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }
    
    public CrashReport addGraphicsAndWorldToCrashReport(final CrashReport lllllllllllIlllIIIlllIlIIIIlIIIl) {
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Launched Version", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.launchedVersion;
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("LWJGL", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Sys.getVersion();
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("OpenGL", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(GlStateManager.glGetString(7937)) + " GL version " + GlStateManager.glGetString(7938) + ", " + GlStateManager.glGetString(7936);
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("GL Caps", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return OpenGlHelper.getLogText();
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Using VBOs", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return Minecraft.this.gameSettings.useVbo ? "Yes" : "No";
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Is Modded", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                final String llllllllllllIIIllIIIIllIIlllIIII = ClientBrandRetriever.getClientModName();
                if (!"vanilla".equals(llllllllllllIIIllIIIIllIIlllIIII)) {
                    return "Definitely; Client brand changed to '" + llllllllllllIIIllIIIIllIIlllIIII + "'";
                }
                return (Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.";
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return "Client (map_client.txt)";
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Resource Packs", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                final StringBuilder llllllllllllIllIIIIlIllIIIlllIIl = new StringBuilder();
                for (final String llllllllllllIllIIIIlIllIIIlllIII : Minecraft.this.gameSettings.resourcePacks) {
                    if (llllllllllllIllIIIIlIllIIIlllIIl.length() > 0) {
                        llllllllllllIllIIIIlIllIIIlllIIl.append(", ");
                    }
                    llllllllllllIllIIIIlIllIIIlllIIl.append(llllllllllllIllIIIIlIllIIIlllIII);
                    if (Minecraft.this.gameSettings.incompatibleResourcePacks.contains(llllllllllllIllIIIIlIllIIIlllIII)) {
                        llllllllllllIllIIIIlIllIIIlllIIl.append(" (incompatible)");
                    }
                }
                return llllllllllllIllIIIIlIllIIIlllIIl.toString();
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Current Language", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.mcLanguageManager.getCurrentLanguage().toString();
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("Profiler Position", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.mcProfiler.profilingEnabled ? Minecraft.this.mcProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        lllllllllllIlllIIIlllIlIIIIlIIIl.getCategory().setDetail("CPU", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return OpenGlHelper.getCpu();
            }
        });
        if (this.world != null) {
            this.world.addWorldInfoToCrashReport(lllllllllllIlllIIIlllIlIIIIlIIIl);
        }
        return lllllllllllIlllIIIlllIlIIIIlIIIl;
    }
    
    private ItemStack storeTEInStack(final ItemStack lllllllllllIlllIIIlllIlIIIIllIIl, final TileEntity lllllllllllIlllIIIlllIlIIIIlllll) {
        final NBTTagCompound lllllllllllIlllIIIlllIlIIIIllllI = lllllllllllIlllIIIlllIlIIIIlllll.writeToNBT(new NBTTagCompound());
        if (lllllllllllIlllIIIlllIlIIIIllIIl.getItem() == Items.SKULL && lllllllllllIlllIIIlllIlIIIIllllI.hasKey("Owner")) {
            final NBTTagCompound lllllllllllIlllIIIlllIlIIIIlllIl = lllllllllllIlllIIIlllIlIIIIllllI.getCompoundTag("Owner");
            final NBTTagCompound lllllllllllIlllIIIlllIlIIIIlllII = new NBTTagCompound();
            lllllllllllIlllIIIlllIlIIIIlllII.setTag("SkullOwner", lllllllllllIlllIIIlllIlIIIIlllIl);
            lllllllllllIlllIIIlllIlIIIIllIIl.setTagCompound(lllllllllllIlllIIIlllIlIIIIlllII);
            return lllllllllllIlllIIIlllIlIIIIllIIl;
        }
        lllllllllllIlllIIIlllIlIIIIllIIl.setTagInfo("BlockEntityTag", lllllllllllIlllIIIlllIlIIIIllllI);
        final NBTTagCompound lllllllllllIlllIIIlllIlIIIIllIll = new NBTTagCompound();
        final NBTTagList lllllllllllIlllIIIlllIlIIIIllIlI = new NBTTagList();
        lllllllllllIlllIIIlllIlIIIIllIlI.appendTag(new NBTTagString("(+NBT)"));
        lllllllllllIlllIIIlllIlIIIIllIll.setTag("Lore", lllllllllllIlllIIIlllIlIIIIllIlI);
        lllllllllllIlllIIIlllIlIIIIllIIl.setTagInfo("display", lllllllllllIlllIIIlllIlIIIIllIll);
        return lllllllllllIlllIIIlllIlIIIIllIIl;
    }
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable lllllllllllIlllIIIlllIIlIllllIlI) {
        Validate.notNull((Object)lllllllllllIlllIIIlllIIlIllllIlI);
        return this.addScheduledTask(Executors.callable(lllllllllllIlllIIIlllIIlIllllIlI));
    }
    
    public String getVersion() {
        return this.launchedVersion;
    }
    
    public void displayInGameMenu() {
        if (this.currentScreen == null) {
            this.displayGuiScreen(new GuiIngameMenu());
            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic()) {
                this.mcSoundHandler.pauseSounds();
            }
        }
    }
    
    @Nullable
    public IntegratedServer getIntegratedServer() {
        return this.theIntegratedServer;
    }
}
