// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.settings;

import shadersmod.client.Shaders;
import java.lang.reflect.ParameterizedType;
import org.apache.logging.log4j.LogManager;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import net.minecraft.world.World;
import optifine.ClearWater;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClientSettings;
import optifine.CustomGuis;
import net.minecraft.client.renderer.OpenGlHelper;
import optifine.DynamicLights;
import optifine.NaturalTextures;
import optifine.CustomSky;
import optifine.RandomMobs;
import optifine.CustomColors;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.FixTypes;
import java.util.Arrays;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.apache.commons.lang3.ArrayUtils;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.texture.TextureMap;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.lwjgl.opengl.DisplayMode;
import optifine.Lang;
import optifine.Config;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.Display;
import java.util.Iterator;
import optifine.Reflector;
import com.google.common.collect.Lists;
import net.minecraft.util.JsonUtils;
import net.minecraft.nbt.NBTTagCompound;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.util.Collection;
import com.google.common.collect.ImmutableSet;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.SoundCategory;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import com.google.common.base.Splitter;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.TutorialSteps;
import net.minecraft.entity.player.EnumPlayerModelParts;
import java.util.Set;
import java.io.File;

public class GameSettings
{
    public /* synthetic */ boolean forceUnicodeFont;
    public /* synthetic */ KeyBinding[] keyBindsHotbar;
    public /* synthetic */ int ofScreenshotSize;
    public /* synthetic */ KeyBinding keyBindAttack;
    private static final /* synthetic */ int[] OF_TREES_VALUES;
    public /* synthetic */ float chatWidth;
    public /* synthetic */ boolean ofAnimatedPortal;
    public /* synthetic */ KeyBinding keyBindDrop;
    public /* synthetic */ boolean ofCustomFonts;
    public /* synthetic */ boolean entityShadows;
    public /* synthetic */ int ofVignette;
    public /* synthetic */ int clouds;
    public /* synthetic */ KeyBinding field_193629_ap;
    public /* synthetic */ KeyBinding keyBindPickBlock;
    private /* synthetic */ File optionsFileOF;
    public /* synthetic */ boolean ofLagometer;
    public /* synthetic */ boolean ofPotionParticles;
    public /* synthetic */ boolean ofSwampColors;
    public /* synthetic */ String ofFullscreenMode;
    private final /* synthetic */ Set<EnumPlayerModelParts> setModelParts;
    public /* synthetic */ float chatHeightUnfocused;
    public /* synthetic */ KeyBinding field_194146_ao;
    public /* synthetic */ boolean ofPortalParticles;
    public /* synthetic */ float chatHeightFocused;
    public /* synthetic */ boolean showSubtitles;
    public /* synthetic */ KeyBinding keyBindSmoothCamera;
    public /* synthetic */ boolean ofDrippingWaterLava;
    public /* synthetic */ boolean ofAnimatedTerrain;
    public /* synthetic */ int ofAutoSaveTicks;
    public /* synthetic */ float chatOpacity;
    public /* synthetic */ KeyBinding keyBindUseItem;
    public /* synthetic */ boolean chatLinks;
    public /* synthetic */ KeyBinding keyBindLeft;
    public /* synthetic */ boolean ofClearWater;
    public /* synthetic */ KeyBinding ofKeyBindZoom;
    private static final /* synthetic */ String[] CLOUDS_TYPES;
    public /* synthetic */ TutorialSteps field_193631_S;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options;
    public /* synthetic */ int overrideHeight;
    public /* synthetic */ boolean viewBobbing;
    public /* synthetic */ boolean realmsNotifications;
    public /* synthetic */ boolean ofAlternateBlocks;
    public /* synthetic */ boolean anaglyph;
    public /* synthetic */ boolean enableWeakAttacks;
    private static final /* synthetic */ String[] KEYS_DYNAMIC_LIGHTS;
    public /* synthetic */ boolean ofCustomEntityModels;
    public /* synthetic */ boolean invertMouse;
    public /* synthetic */ KeyBinding keyBindPlayerList;
    public /* synthetic */ int field_192571_R;
    public /* synthetic */ boolean ofAnimatedFire;
    public /* synthetic */ boolean ofShowCapes;
    public /* synthetic */ int mipmapLevels;
    public /* synthetic */ int guiScale;
    public /* synthetic */ int ofConnectedTextures;
    public /* synthetic */ boolean useNativeTransport;
    public /* synthetic */ float ofFogStart;
    public /* synthetic */ boolean ofSmoothBiomes;
    public /* synthetic */ KeyBinding keyBindRight;
    public /* synthetic */ boolean fboEnable;
    public /* synthetic */ KeyBinding keyBindSwapHands;
    public /* synthetic */ boolean ofFastMath;
    public /* synthetic */ boolean useVbo;
    public /* synthetic */ boolean ofRandomMobs;
    private static final /* synthetic */ String[] GUISCALES;
    public /* synthetic */ boolean ofDynamicFov;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ boolean ofAnimatedSmoke;
    public /* synthetic */ KeyBinding keyBindCommand;
    public /* synthetic */ boolean reducedDebugInfo;
    public /* synthetic */ KeyBinding keyBindBack;
    public /* synthetic */ boolean ofChunkUpdatesDynamic;
    public /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    public /* synthetic */ boolean ofWaterParticles;
    public /* synthetic */ int ofAfLevel;
    private static final /* synthetic */ String[] ATTACK_INDICATORS;
    public /* synthetic */ boolean ofVoidParticles;
    public /* synthetic */ boolean advancedItemTooltips;
    public /* synthetic */ int ofDroppedItems;
    public /* synthetic */ boolean touchscreen;
    public /* synthetic */ int ofTime;
    public /* synthetic */ boolean ofWeather;
    public /* synthetic */ boolean ofAnimatedRedstone;
    public /* synthetic */ float ofCloudsHeight;
    public /* synthetic */ boolean ofSky;
    public /* synthetic */ boolean hideServerAddress;
    private static final /* synthetic */ String[] AMBIENT_OCCLUSIONS;
    public /* synthetic */ boolean ofAnimatedExplosion;
    public /* synthetic */ boolean fancyGraphics;
    public /* synthetic */ KeyBinding keyBindTogglePerspective;
    private static final /* synthetic */ Gson GSON;
    public /* synthetic */ int limitFramerate;
    public /* synthetic */ boolean ofCustomItems;
    public /* synthetic */ int ofAnimatedWater;
    public /* synthetic */ int ofMipmapType;
    public /* synthetic */ boolean chatColours;
    public /* synthetic */ float saturation;
    private /* synthetic */ boolean needsResourceRefresh;
    public /* synthetic */ float gammaSetting;
    public /* synthetic */ List<String> incompatibleResourcePacks;
    public /* synthetic */ boolean ofFastRender;
    public /* synthetic */ int attackIndicator;
    public /* synthetic */ int ofFogType;
    public /* synthetic */ String language;
    private static final /* synthetic */ Type TYPE_LIST_STRING;
    public /* synthetic */ float fovSetting;
    public /* synthetic */ KeyBinding keyBindSneak;
    public /* synthetic */ boolean ofNaturalTextures;
    public /* synthetic */ boolean ofBetterSnow;
    public /* synthetic */ KeyBinding keyBindChat;
    public /* synthetic */ KeyBinding keyBindScreenshot;
    public /* synthetic */ KeyBinding keyBindFullscreen;
    public /* synthetic */ int ofDynamicLights;
    public /* synthetic */ int ofAnimatedLava;
    public /* synthetic */ List<String> resourcePacks;
    public /* synthetic */ float mouseSensitivity;
    public /* synthetic */ KeyBinding field_193630_aq;
    public /* synthetic */ int ofRain;
    public /* synthetic */ boolean snooperEnabled;
    public /* synthetic */ boolean ofProfiler;
    public /* synthetic */ int ofChunkUpdates;
    public /* synthetic */ boolean ofOcclusionFancy;
    public /* synthetic */ boolean ofAnimatedFlame;
    public static final /* synthetic */ Splitter COLON_SPLITTER;
    public /* synthetic */ boolean ofStars;
    public /* synthetic */ int ofBetterGrass;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ boolean pauseOnLostFocus;
    public /* synthetic */ boolean ofSmoothWorld;
    public /* synthetic */ boolean ofFireworkParticles;
    public /* synthetic */ boolean ofAnimatedTextures;
    public /* synthetic */ KeyBinding keyBindSprint;
    public /* synthetic */ float ofAoLevel;
    public /* synthetic */ int ofTrees;
    public /* synthetic */ KeyBinding keyBindInventory;
    public static final /* synthetic */ String[] field_193632_b;
    public /* synthetic */ KeyBinding[] keyBindings;
    public /* synthetic */ boolean ofCustomSky;
    public /* synthetic */ boolean ofLazyChunkLoading;
    public /* synthetic */ String lastServer;
    public /* synthetic */ int renderDistanceChunks;
    private final /* synthetic */ Map<SoundCategory, Float> soundLevels;
    public /* synthetic */ boolean fullScreen;
    public /* synthetic */ boolean autoJump;
    public /* synthetic */ boolean ofCustomGuis;
    private /* synthetic */ File optionsFile;
    public /* synthetic */ KeyBinding keyBindForward;
    public /* synthetic */ boolean ofSmoothFps;
    public /* synthetic */ int particleSetting;
    public /* synthetic */ EnumDifficulty difficulty;
    public /* synthetic */ EnumHandSide mainHand;
    public /* synthetic */ int ambientOcclusion;
    private static final /* synthetic */ String[] PARTICLES;
    public /* synthetic */ float chatScale;
    public /* synthetic */ int ofAaLevel;
    public /* synthetic */ boolean ofRainSplash;
    public /* synthetic */ boolean ofCustomColors;
    public /* synthetic */ KeyBinding keyBindJump;
    private static final /* synthetic */ int[] OF_DYNAMIC_LIGHTS;
    public /* synthetic */ KeyBinding keyBindSpectatorOutlines;
    public /* synthetic */ boolean ofSunMoon;
    public /* synthetic */ boolean heldItemTooltips;
    public /* synthetic */ int overrideWidth;
    public /* synthetic */ boolean enableVsync;
    public /* synthetic */ boolean ofShowFps;
    public /* synthetic */ boolean chatLinksPrompt;
    public /* synthetic */ int ofTranslucentBlocks;
    public /* synthetic */ int ofClouds;
    
    private static int nextValue(final int lllllllllllIlIlIlllllllIlIllIlII, final int[] lllllllllllIlIlIlllllllIlIllIllI) {
        int lllllllllllIlIlIlllllllIlIllIlIl = indexOf(lllllllllllIlIlIlllllllIlIllIlII, lllllllllllIlIlIlllllllIlIllIllI);
        if (lllllllllllIlIlIlllllllIlIllIlIl < 0) {
            return lllllllllllIlIlIlllllllIlIllIllI[0];
        }
        if (++lllllllllllIlIlIlllllllIlIllIlIl >= lllllllllllIlIlIlllllllIlIllIllI.length) {
            lllllllllllIlIlIlllllllIlIllIlIl = 0;
        }
        return lllllllllllIlIlIlllllllIlIllIllI[lllllllllllIlIlIlllllllIlIllIlIl];
    }
    
    public Set<EnumPlayerModelParts> getModelParts() {
        return (Set<EnumPlayerModelParts>)ImmutableSet.copyOf((Collection)this.setModelParts);
    }
    
    public void loadOptions() {
        try {
            if (!this.optionsFile.exists()) {
                return;
            }
            this.soundLevels.clear();
            final List<String> lllllllllllIlIlIlllllllllIlIIlIl = (List<String>)IOUtils.readLines((InputStream)new FileInputStream(this.optionsFile), StandardCharsets.UTF_8);
            NBTTagCompound lllllllllllIlIlIlllllllllIlIIlII = new NBTTagCompound();
            for (final String lllllllllllIlIlIlllllllllIlIIIll : lllllllllllIlIlIlllllllllIlIIlIl) {
                try {
                    final Iterator<String> lllllllllllIlIlIlllllllllIlIIIlI = GameSettings.COLON_SPLITTER.omitEmptyStrings().limit(2).split((CharSequence)lllllllllllIlIlIlllllllllIlIIIll).iterator();
                    lllllllllllIlIlIlllllllllIlIIlII.setString(lllllllllllIlIlIlllllllllIlIIIlI.next(), lllllllllllIlIlIlllllllllIlIIIlI.next());
                }
                catch (Exception lllllllllllIlIlIlllllllllIlIIIIl) {
                    GameSettings.LOGGER.warn("Skipping bad option: {}", (Object)lllllllllllIlIlIlllllllllIlIIIll);
                }
            }
            lllllllllllIlIlIlllllllllIlIIlII = this.dataFix(lllllllllllIlIlIlllllllllIlIIlII);
            for (final String lllllllllllIlIlIlllllllllIlIIIII : lllllllllllIlIlIlllllllllIlIIlII.getKeySet()) {
                final String lllllllllllIlIlIlllllllllIIlllll = lllllllllllIlIlIlllllllllIlIIlII.getString(lllllllllllIlIlIlllllllllIlIIIII);
                try {
                    if ("mouseSensitivity".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.mouseSensitivity = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("fov".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.fovSetting = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll) * 40.0f + 70.0f;
                    }
                    if ("gamma".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.gammaSetting = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("saturation".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.saturation = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("invertYMouse".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.invertMouse = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("renderDistance".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.renderDistanceChunks = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("guiScale".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.guiScale = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("particles".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.particleSetting = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("bobView".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.viewBobbing = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("anaglyph3d".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.anaglyph = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("maxFps".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.limitFramerate = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                        if (this.enableVsync) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                        if (this.limitFramerate <= 0) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                    }
                    if ("fboEnable".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.fboEnable = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("difficulty".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll));
                    }
                    if ("fancyGraphics".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.fancyGraphics = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                        this.updateRenderClouds();
                    }
                    if ("tutorialStep".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.field_193631_S = TutorialSteps.func_193307_a(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("ao".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        if ("true".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.ambientOcclusion = 2;
                        }
                        else if ("false".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.ambientOcclusion = 0;
                        }
                        else {
                            this.ambientOcclusion = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                        }
                    }
                    if ("renderClouds".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        if ("true".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.clouds = 2;
                        }
                        else if ("false".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.clouds = 0;
                        }
                        else if ("fast".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.clouds = 1;
                        }
                    }
                    if ("attackIndicator".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        if ("0".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.attackIndicator = 0;
                        }
                        else if ("1".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.attackIndicator = 1;
                        }
                        else if ("2".equals(lllllllllllIlIlIlllllllllIIlllll)) {
                            this.attackIndicator = 2;
                        }
                    }
                    if ("resourcePacks".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.resourcePacks = JsonUtils.func_193840_a(GameSettings.GSON, lllllllllllIlIlIlllllllllIIlllll, GameSettings.TYPE_LIST_STRING);
                        if (this.resourcePacks == null) {
                            this.resourcePacks = (List<String>)Lists.newArrayList();
                        }
                    }
                    if ("incompatibleResourcePacks".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.incompatibleResourcePacks = JsonUtils.func_193840_a(GameSettings.GSON, lllllllllllIlIlIlllllllllIIlllll, GameSettings.TYPE_LIST_STRING);
                        if (this.incompatibleResourcePacks == null) {
                            this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
                        }
                    }
                    if ("lastServer".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.lastServer = lllllllllllIlIlIlllllllllIIlllll;
                    }
                    if ("lang".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.language = lllllllllllIlIlIlllllllllIIlllll;
                    }
                    if ("chatVisibility".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll));
                    }
                    if ("chatColors".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatColours = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatLinks".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatLinks = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatLinksPrompt".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatLinksPrompt = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatOpacity".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatOpacity = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("snooperEnabled".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.snooperEnabled = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("fullscreen".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.fullScreen = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("enableVsync".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.enableVsync = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                        if (this.enableVsync) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                        this.updateVSync();
                    }
                    if ("useVbo".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.useVbo = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("hideServerAddress".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.hideServerAddress = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("advancedItemTooltips".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.advancedItemTooltips = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("pauseOnLostFocus".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.pauseOnLostFocus = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("touchscreen".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.touchscreen = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("overrideHeight".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.overrideHeight = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("overrideWidth".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.overrideWidth = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("heldItemTooltips".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.heldItemTooltips = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatHeightFocused".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatHeightFocused = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatHeightUnfocused".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatHeightUnfocused = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatScale".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatScale = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("chatWidth".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.chatWidth = this.parseFloat(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("mipmapLevels".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.mipmapLevels = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("forceUnicodeFont".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.forceUnicodeFont = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("reducedDebugInfo".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.reducedDebugInfo = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("useNativeTransport".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.useNativeTransport = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("entityShadows".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.entityShadows = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("mainHand".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.mainHand = ("left".equals(lllllllllllIlIlIlllllllllIIlllll) ? EnumHandSide.LEFT : EnumHandSide.RIGHT);
                    }
                    if ("showSubtitles".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.showSubtitles = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("realmsNotifications".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.realmsNotifications = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("enableWeakAttacks".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.enableWeakAttacks = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("autoJump".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.autoJump = "true".equals(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    if ("narrator".equals(lllllllllllIlIlIlllllllllIlIIIII)) {
                        this.field_192571_R = Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll);
                    }
                    char lllllllllllIlIlIlllllllllIIIllIl;
                    long lllllllllllIlIlIlllllllllIIIlllI = ((KeyBinding[])(Object)(lllllllllllIlIlIlllllllllIIIllIl = (char)(Object)this.keyBindings)).length;
                    for (short lllllllllllIlIlIlllllllllIIIllll = 0; lllllllllllIlIlIlllllllllIIIllll < lllllllllllIlIlIlllllllllIIIlllI; ++lllllllllllIlIlIlllllllllIIIllll) {
                        final KeyBinding lllllllllllIlIlIlllllllllIIllllI = lllllllllllIlIlIlllllllllIIIllIl[lllllllllllIlIlIlllllllllIIIllll];
                        if (lllllllllllIlIlIlllllllllIlIIIII.equals("key_" + lllllllllllIlIlIlllllllllIIllllI.getKeyDescription())) {
                            if (Reflector.KeyModifier_valueFromString.exists()) {
                                if (lllllllllllIlIlIlllllllllIIlllll.indexOf(58) != -1) {
                                    final String[] lllllllllllIlIlIlllllllllIIlllIl = lllllllllllIlIlIlllllllllIIlllll.split(":");
                                    final Object lllllllllllIlIlIlllllllllIIlllII = Reflector.call(Reflector.KeyModifier_valueFromString, new Object[] { lllllllllllIlIlIlllllllllIIlllIl[1] });
                                    Reflector.call((Object)lllllllllllIlIlIlllllllllIIllllI, Reflector.ForgeKeyBinding_setKeyModifierAndCode, new Object[] { lllllllllllIlIlIlllllllllIIlllII, Integer.parseInt(lllllllllllIlIlIlllllllllIIlllIl[0]) });
                                }
                                else {
                                    final Object lllllllllllIlIlIlllllllllIIllIll = Reflector.getFieldValue(Reflector.KeyModifier_NONE);
                                    Reflector.call((Object)lllllllllllIlIlIlllllllllIIllllI, Reflector.ForgeKeyBinding_setKeyModifierAndCode, new Object[] { lllllllllllIlIlIlllllllllIIllIll, Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll) });
                                }
                            }
                            else {
                                lllllllllllIlIlIlllllllllIIllllI.setKeyCode(Integer.parseInt(lllllllllllIlIlIlllllllllIIlllll));
                            }
                        }
                    }
                    lllllllllllIlIlIlllllllllIIIlllI = ((SoundCategory[])(Object)(lllllllllllIlIlIlllllllllIIIllIl = (char)(Object)SoundCategory.values())).length;
                    for (short lllllllllllIlIlIlllllllllIIIllll = 0; lllllllllllIlIlIlllllllllIIIllll < lllllllllllIlIlIlllllllllIIIlllI; ++lllllllllllIlIlIlllllllllIIIllll) {
                        final SoundCategory lllllllllllIlIlIlllllllllIIllIlI = lllllllllllIlIlIlllllllllIIIllIl[lllllllllllIlIlIlllllllllIIIllll];
                        if (lllllllllllIlIlIlllllllllIlIIIII.equals("soundCategory_" + lllllllllllIlIlIlllllllllIIllIlI.getName())) {
                            this.soundLevels.put(lllllllllllIlIlIlllllllllIIllIlI, this.parseFloat(lllllllllllIlIlIlllllllllIIlllll));
                        }
                    }
                    lllllllllllIlIlIlllllllllIIIlllI = ((EnumPlayerModelParts[])(Object)(lllllllllllIlIlIlllllllllIIIllIl = (char)(Object)EnumPlayerModelParts.values())).length;
                    for (short lllllllllllIlIlIlllllllllIIIllll = 0; lllllllllllIlIlIlllllllllIIIllll < lllllllllllIlIlIlllllllllIIIlllI; ++lllllllllllIlIlIlllllllllIIIllll) {
                        final EnumPlayerModelParts lllllllllllIlIlIlllllllllIIllIIl = lllllllllllIlIlIlllllllllIIIllIl[lllllllllllIlIlIlllllllllIIIllll];
                        if (lllllllllllIlIlIlllllllllIlIIIII.equals("modelPart_" + lllllllllllIlIlIlllllllllIIllIIl.getPartName())) {
                            this.setModelPartEnabled(lllllllllllIlIlIlllllllllIIllIIl, "true".equals(lllllllllllIlIlIlllllllllIIlllll));
                        }
                    }
                }
                catch (Exception lllllllllllIlIlIlllllllllIIllIII) {
                    GameSettings.LOGGER.warn("Skipping bad option: {}:{}", (Object)lllllllllllIlIlIlllllllllIlIIIII, (Object)lllllllllllIlIlIlllllllllIIlllll);
                    lllllllllllIlIlIlllllllllIIllIII.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        catch (Exception lllllllllllIlIlIlllllllllIIlIlll) {
            GameSettings.LOGGER.error("Failed to load options", (Throwable)lllllllllllIlIlIlllllllllIIlIlll);
        }
        this.loadOfOptions();
    }
    
    public boolean getOptionOrdinalValue(final Options lllllllllllIlIlIllllllllllIIllll) {
        switch ($SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options()[lllllllllllIlIlIllllllllllIIllll.ordinal()]) {
            case 1: {
                return this.invertMouse;
            }
            case 7: {
                return this.viewBobbing;
            }
            case 8: {
                return this.anaglyph;
            }
            case 10: {
                return this.fboEnable;
            }
            case 17: {
                return this.chatColours;
            }
            case 18: {
                return this.chatLinks;
            }
            case 20: {
                return this.chatLinksPrompt;
            }
            case 21: {
                return this.snooperEnabled;
            }
            case 22: {
                return this.fullScreen;
            }
            case 23: {
                return this.enableVsync;
            }
            case 24: {
                return this.useVbo;
            }
            case 25: {
                return this.touchscreen;
            }
            case 31: {
                return this.forceUnicodeFont;
            }
            case 32: {
                return this.reducedDebugInfo;
            }
            case 33: {
                return this.entityShadows;
            }
            case 37: {
                return this.showSubtitles;
            }
            case 38: {
                return this.realmsNotifications;
            }
            case 36: {
                return this.enableWeakAttacks;
            }
            case 39: {
                return this.autoJump;
            }
            default: {
                return false;
            }
        }
    }
    
    public void updateVSync() {
        Display.setVSyncEnabled(this.enableVsync);
    }
    
    public boolean isUsingNativeTransport() {
        return this.useNativeTransport;
    }
    
    public void setOptionKeyBinding(final KeyBinding lllllllllllIlIllIIIIIIIIIIIIIIIl, final int lllllllllllIlIlIllllllllllllllIl) {
        lllllllllllIlIllIIIIIIIIIIIIIIIl.setKeyCode(lllllllllllIlIlIllllllllllllllIl);
        this.saveOptions();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options() {
        final int[] $switch_TABLE$net$minecraft$client$settings$GameSettings$Options = GameSettings.$SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options;
        if ($switch_TABLE$net$minecraft$client$settings$GameSettings$Options != null) {
            return $switch_TABLE$net$minecraft$client$settings$GameSettings$Options;
        }
        final float lllllllllllIlIlIlllllllIlIIlIlIl = (Object)new int[Options.values().length];
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AA_LEVEL.ordinal()] = 91;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ADVANCED_TOOLTIPS.ordinal()] = 106;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AF_LEVEL.ordinal()] = 92;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ALTERNATE_BLOCKS.ordinal()] = 104;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AMBIENT_OCCLUSION.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANAGLYPH.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_EXPLOSION.ordinal()] = 59;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_FIRE.ordinal()] = 51;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_FLAME.ordinal()] = 60;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_LAVA.ordinal()] = 50;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_PORTAL.ordinal()] = 52;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_REDSTONE.ordinal()] = 58;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_SMOKE.ordinal()] = 61;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_TERRAIN.ordinal()] = 82;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_TEXTURES.ordinal()] = 93;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ANIMATED_WATER.ordinal()] = 49;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AO_LEVEL.ordinal()] = 53;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ATTACK_INDICATOR.ordinal()] = 35;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AUTOSAVE_TICKS.ordinal()] = 56;
        }
        catch (NoSuchFieldError noSuchFieldError19) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.AUTO_JUMP.ordinal()] = 39;
        }
        catch (NoSuchFieldError noSuchFieldError20) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.BETTER_GRASS.ordinal()] = 57;
        }
        catch (NoSuchFieldError noSuchFieldError21) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.BETTER_SNOW.ordinal()] = 80;
        }
        catch (NoSuchFieldError noSuchFieldError22) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_COLOR.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError23) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_HEIGHT_FOCUSED.ordinal()] = 28;
        }
        catch (NoSuchFieldError noSuchFieldError24) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_HEIGHT_UNFOCUSED.ordinal()] = 29;
        }
        catch (NoSuchFieldError noSuchFieldError25) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_LINKS.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError26) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_LINKS_PROMPT.ordinal()] = 20;
        }
        catch (NoSuchFieldError noSuchFieldError27) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_OPACITY.ordinal()] = 19;
        }
        catch (NoSuchFieldError noSuchFieldError28) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_SCALE.ordinal()] = 26;
        }
        catch (NoSuchFieldError noSuchFieldError29) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_VISIBILITY.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError30) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHAT_WIDTH.ordinal()] = 27;
        }
        catch (NoSuchFieldError noSuchFieldError31) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHUNK_UPDATES.ordinal()] = 67;
        }
        catch (NoSuchFieldError noSuchFieldError32) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CHUNK_UPDATES_DYNAMIC.ordinal()] = 68;
        }
        catch (NoSuchFieldError noSuchFieldError33) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CLEAR_WATER.ordinal()] = 70;
        }
        catch (NoSuchFieldError noSuchFieldError34) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CLOUDS.ordinal()] = 45;
        }
        catch (NoSuchFieldError noSuchFieldError35) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CLOUD_HEIGHT.ordinal()] = 46;
        }
        catch (NoSuchFieldError noSuchFieldError36) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CONNECTED_TEXTURES.ordinal()] = 89;
        }
        catch (NoSuchFieldError noSuchFieldError37) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_COLORS.ordinal()] = 87;
        }
        catch (NoSuchFieldError noSuchFieldError38) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_ENTITY_MODELS.ordinal()] = 105;
        }
        catch (NoSuchFieldError noSuchFieldError39) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_FONTS.ordinal()] = 86;
        }
        catch (NoSuchFieldError noSuchFieldError40) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_GUIS.ordinal()] = 108;
        }
        catch (NoSuchFieldError noSuchFieldError41) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_ITEMS.ordinal()] = 90;
        }
        catch (NoSuchFieldError noSuchFieldError42) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.CUSTOM_SKY.ordinal()] = 98;
        }
        catch (NoSuchFieldError noSuchFieldError43) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.DRIPPING_WATER_LAVA.ordinal()] = 79;
        }
        catch (NoSuchFieldError noSuchFieldError44) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.DROPPED_ITEMS.ordinal()] = 96;
        }
        catch (NoSuchFieldError noSuchFieldError45) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.DYNAMIC_FOV.ordinal()] = 102;
        }
        catch (NoSuchFieldError noSuchFieldError46) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.DYNAMIC_LIGHTS.ordinal()] = 103;
        }
        catch (NoSuchFieldError noSuchFieldError47) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ENABLE_VSYNC.ordinal()] = 23;
        }
        catch (NoSuchFieldError noSuchFieldError48) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ENABLE_WEAK_ATTACKS.ordinal()] = 36;
        }
        catch (NoSuchFieldError noSuchFieldError49) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.ENTITY_SHADOWS.ordinal()] = 33;
        }
        catch (NoSuchFieldError noSuchFieldError50) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FAST_MATH.ordinal()] = 99;
        }
        catch (NoSuchFieldError noSuchFieldError51) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FAST_RENDER.ordinal()] = 100;
        }
        catch (NoSuchFieldError noSuchFieldError52) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FBO_ENABLE.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError53) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FIREWORK_PARTICLES.ordinal()] = 77;
        }
        catch (NoSuchFieldError noSuchFieldError54) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FOG_FANCY.ordinal()] = 41;
        }
        catch (NoSuchFieldError noSuchFieldError55) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FOG_START.ordinal()] = 42;
        }
        catch (NoSuchFieldError noSuchFieldError56) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FORCE_UNICODE_FONT.ordinal()] = 31;
        }
        catch (NoSuchFieldError noSuchFieldError57) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FOV.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError58) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FRAMERATE_LIMIT.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError59) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.FULLSCREEN_MODE.ordinal()] = 81;
        }
        catch (NoSuchFieldError noSuchFieldError60) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.GAMMA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError61) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.GRAPHICS.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError62) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.GUI_SCALE.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError63) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.HELD_ITEM_TOOLTIPS.ordinal()] = 95;
        }
        catch (NoSuchFieldError noSuchFieldError64) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.INVERT_MOUSE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError65) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.LAGOMETER.ordinal()] = 54;
        }
        catch (NoSuchFieldError noSuchFieldError66) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.LAZY_CHUNK_LOADING.ordinal()] = 97;
        }
        catch (NoSuchFieldError noSuchFieldError67) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.MAIN_HAND.ordinal()] = 34;
        }
        catch (NoSuchFieldError noSuchFieldError68) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.MIPMAP_LEVELS.ordinal()] = 30;
        }
        catch (NoSuchFieldError noSuchFieldError69) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.MIPMAP_TYPE.ordinal()] = 43;
        }
        catch (NoSuchFieldError noSuchFieldError70) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.NARRATOR.ordinal()] = 40;
        }
        catch (NoSuchFieldError noSuchFieldError71) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.NATURAL_TEXTURES.ordinal()] = 94;
        }
        catch (NoSuchFieldError noSuchFieldError72) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.PARTICLES.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError73) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.PORTAL_PARTICLES.ordinal()] = 75;
        }
        catch (NoSuchFieldError noSuchFieldError74) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.POTION_PARTICLES.ordinal()] = 76;
        }
        catch (NoSuchFieldError noSuchFieldError75) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.PROFILER.ordinal()] = 78;
        }
        catch (NoSuchFieldError noSuchFieldError76) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.RAIN.ordinal()] = 48;
        }
        catch (NoSuchFieldError noSuchFieldError77) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.RAIN_SPLASH.ordinal()] = 74;
        }
        catch (NoSuchFieldError noSuchFieldError78) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.RANDOM_MOBS.ordinal()] = 84;
        }
        catch (NoSuchFieldError noSuchFieldError79) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.REALMS_NOTIFICATIONS.ordinal()] = 38;
        }
        catch (NoSuchFieldError noSuchFieldError80) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.REDUCED_DEBUG_INFO.ordinal()] = 32;
        }
        catch (NoSuchFieldError noSuchFieldError81) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.RENDER_CLOUDS.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError82) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.RENDER_DISTANCE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError83) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SATURATION.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError84) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SCREENSHOT_SIZE.ordinal()] = 107;
        }
        catch (NoSuchFieldError noSuchFieldError85) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SENSITIVITY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError86) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SHOW_CAPES.ordinal()] = 88;
        }
        catch (NoSuchFieldError noSuchFieldError87) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SHOW_FPS.ordinal()] = 55;
        }
        catch (NoSuchFieldError noSuchFieldError88) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SHOW_SUBTITLES.ordinal()] = 37;
        }
        catch (NoSuchFieldError noSuchFieldError89) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SKY.ordinal()] = 63;
        }
        catch (NoSuchFieldError noSuchFieldError90) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SMOOTH_BIOMES.ordinal()] = 85;
        }
        catch (NoSuchFieldError noSuchFieldError91) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SMOOTH_FPS.ordinal()] = 44;
        }
        catch (NoSuchFieldError noSuchFieldError92) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SMOOTH_WORLD.ordinal()] = 71;
        }
        catch (NoSuchFieldError noSuchFieldError93) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SNOOPER_ENABLED.ordinal()] = 21;
        }
        catch (NoSuchFieldError noSuchFieldError94) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.STARS.ordinal()] = 64;
        }
        catch (NoSuchFieldError noSuchFieldError95) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SUN_MOON.ordinal()] = 65;
        }
        catch (NoSuchFieldError noSuchFieldError96) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.SWAMP_COLORS.ordinal()] = 83;
        }
        catch (NoSuchFieldError noSuchFieldError97) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.TIME.ordinal()] = 69;
        }
        catch (NoSuchFieldError noSuchFieldError98) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.TOUCHSCREEN.ordinal()] = 25;
        }
        catch (NoSuchFieldError noSuchFieldError99) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.TRANSLUCENT_BLOCKS.ordinal()] = 101;
        }
        catch (NoSuchFieldError noSuchFieldError100) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.TREES.ordinal()] = 47;
        }
        catch (NoSuchFieldError noSuchFieldError101) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.USE_FULLSCREEN.ordinal()] = 22;
        }
        catch (NoSuchFieldError noSuchFieldError102) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.USE_VBO.ordinal()] = 24;
        }
        catch (NoSuchFieldError noSuchFieldError103) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.VIEW_BOBBING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError104) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.VIGNETTE.ordinal()] = 66;
        }
        catch (NoSuchFieldError noSuchFieldError105) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.VOID_PARTICLES.ordinal()] = 72;
        }
        catch (NoSuchFieldError noSuchFieldError106) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.WATER_PARTICLES.ordinal()] = 73;
        }
        catch (NoSuchFieldError noSuchFieldError107) {}
        try {
            lllllllllllIlIlIlllllllIlIIlIlIl[Options.WEATHER.ordinal()] = 62;
        }
        catch (NoSuchFieldError noSuchFieldError108) {}
        return GameSettings.$SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options = (int[])(Object)lllllllllllIlIlIlllllllIlIIlIlIl;
    }
    
    public String getKeyBinding(final Options lllllllllllIlIlIlllllllllIllIlll) {
        final String lllllllllllIlIlIlllllllllIlllllI = this.getKeyBindingOF(lllllllllllIlIlIlllllllllIllIlll);
        if (lllllllllllIlIlIlllllllllIlllllI != null) {
            return lllllllllllIlIlIlllllllllIlllllI;
        }
        final String lllllllllllIlIlIlllllllllIllllIl = String.valueOf(I18n.format(lllllllllllIlIlIlllllllllIllIlll.getEnumString(), new Object[0])) + ": ";
        if (lllllllllllIlIlIlllllllllIllIlll.getEnumFloat()) {
            final float lllllllllllIlIlIlllllllllIllllII = this.getOptionFloatValue(lllllllllllIlIlIlllllllllIllIlll);
            final float lllllllllllIlIlIlllllllllIlllIll = lllllllllllIlIlIlllllllllIllIlll.normalizeValue(lllllllllllIlIlIlllllllllIllllII);
            if (lllllllllllIlIlIlllllllllIllIlll == Options.SENSITIVITY) {
                if (lllllllllllIlIlIlllllllllIlllIll == 0.0f) {
                    return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.sensitivity.min", new Object[0]);
                }
                return (lllllllllllIlIlIlllllllllIlllIll == 1.0f) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.sensitivity.max", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)(lllllllllllIlIlIlllllllllIlllIll * 200.0f) + "%");
            }
            else if (lllllllllllIlIlIlllllllllIllIlll == Options.FOV) {
                if (lllllllllllIlIlIlllllllllIllllII == 70.0f) {
                    return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.fov.min", new Object[0]);
                }
                return (lllllllllllIlIlIlllllllllIllllII == 110.0f) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.fov.max", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)lllllllllllIlIlIlllllllllIllllII);
            }
            else {
                if (lllllllllllIlIlIlllllllllIllIlll == Options.FRAMERATE_LIMIT) {
                    return (lllllllllllIlIlIlllllllllIllllII == lllllllllllIlIlIlllllllllIllIlll.valueMax) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.framerateLimit.max", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.framerate", (int)lllllllllllIlIlIlllllllllIllllII));
                }
                if (lllllllllllIlIlIlllllllllIllIlll == Options.RENDER_CLOUDS) {
                    return (lllllllllllIlIlIlllllllllIllllII == lllllllllllIlIlIlllllllllIllIlll.valueMin) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.cloudHeight.min", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + ((int)lllllllllllIlIlIlllllllllIllllII + 128));
                }
                if (lllllllllllIlIlIlllllllllIllIlll == Options.GAMMA) {
                    if (lllllllllllIlIlIlllllllllIlllIll == 0.0f) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.gamma.min", new Object[0]);
                    }
                    return (lllllllllllIlIlIlllllllllIlllIll == 1.0f) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.gamma.max", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + "+" + (int)(lllllllllllIlIlIlllllllllIlllIll * 100.0f) + "%");
                }
                else {
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.SATURATION) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)(lllllllllllIlIlIlllllllllIlllIll * 400.0f) + "%";
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.CHAT_OPACITY) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)(lllllllllllIlIlIlllllllllIlllIll * 90.0f + 10.0f) + "%";
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.CHAT_HEIGHT_UNFOCUSED) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + GuiNewChat.calculateChatboxHeight(lllllllllllIlIlIlllllllllIlllIll) + "px";
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.CHAT_HEIGHT_FOCUSED) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + GuiNewChat.calculateChatboxHeight(lllllllllllIlIlIlllllllllIlllIll) + "px";
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.CHAT_WIDTH) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + GuiNewChat.calculateChatboxWidth(lllllllllllIlIlIlllllllllIlllIll) + "px";
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.RENDER_DISTANCE) {
                        return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.chunks", (int)lllllllllllIlIlIlllllllllIllllII);
                    }
                    if (lllllllllllIlIlIlllllllllIllIlll == Options.MIPMAP_LEVELS) {
                        return (lllllllllllIlIlIlllllllllIllllII == 0.0f) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.off", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)lllllllllllIlIlIlllllllllIllllII);
                    }
                    return (lllllllllllIlIlIlllllllllIlllIll == 0.0f) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.off", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + (int)(lllllllllllIlIlIlllllllllIlllIll * 100.0f) + "%");
                }
            }
        }
        else {
            if (lllllllllllIlIlIlllllllllIllIlll.getEnumBoolean()) {
                final boolean lllllllllllIlIlIlllllllllIlllIlI = this.getOptionOrdinalValue(lllllllllllIlIlIlllllllllIllIlll);
                return lllllllllllIlIlIlllllllllIlllIlI ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.on", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.off", new Object[0]));
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.MAIN_HAND) {
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + this.mainHand;
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.GUI_SCALE) {
                return (this.guiScale >= GameSettings.GUISCALES.length) ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + this.guiScale + "x") : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.GUISCALES, this.guiScale));
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.CHAT_VISIBILITY) {
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format(this.chatVisibility.getResourceKey(), new Object[0]);
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.PARTICLES) {
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.PARTICLES, this.particleSetting);
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.AMBIENT_OCCLUSION) {
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.AMBIENT_OCCLUSIONS, this.ambientOcclusion);
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.RENDER_CLOUDS) {
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.CLOUDS_TYPES, this.clouds);
            }
            if (lllllllllllIlIlIlllllllllIllIlll == Options.GRAPHICS) {
                if (this.fancyGraphics) {
                    return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.graphics.fancy", new Object[0]);
                }
                final String lllllllllllIlIlIlllllllllIlllIIl = "options.graphics.fast";
                return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.graphics.fast", new Object[0]);
            }
            else {
                if (lllllllllllIlIlIlllllllllIllIlll == Options.ATTACK_INDICATOR) {
                    return String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.ATTACK_INDICATORS, this.attackIndicator);
                }
                if (lllllllllllIlIlIlllllllllIllIlll == Options.NARRATOR) {
                    return NarratorChatListener.field_193643_a.func_193640_a() ? (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + getTranslation(GameSettings.field_193632_b, this.field_192571_R)) : (String.valueOf(lllllllllllIlIlIlllllllllIllllIl) + I18n.format("options.narrator.notavailable", new Object[0]));
                }
                return lllllllllllIlIlIlllllllllIllllIl;
            }
        }
    }
    
    public void setOptionValue(final Options lllllllllllIlIlIlllllllllllIIIIl, final int lllllllllllIlIlIlllllllllllIIlll) {
        this.setOptionValueOF(lllllllllllIlIlIlllllllllllIIIIl, lllllllllllIlIlIlllllllllllIIlll);
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.RENDER_DISTANCE) {
            this.setOptionFloatValue(lllllllllllIlIlIlllllllllllIIIIl, MathHelper.clamp((float)(this.renderDistanceChunks + lllllllllllIlIlIlllllllllllIIlll), lllllllllllIlIlIlllllllllllIIIIl.getValueMin(), lllllllllllIlIlIlllllllllllIIIIl.getValueMax()));
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.MAIN_HAND) {
            this.mainHand = this.mainHand.opposite();
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.INVERT_MOUSE) {
            this.invertMouse = !this.invertMouse;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.GUI_SCALE) {
            this.guiScale += lllllllllllIlIlIlllllllllllIIlll;
            if (GuiScreen.isShiftKeyDown()) {
                this.guiScale = 0;
            }
            final DisplayMode lllllllllllIlIlIlllllllllllIIllI = Config.getLargestDisplayMode();
            final int lllllllllllIlIlIlllllllllllIIlIl = lllllllllllIlIlIlllllllllllIIllI.getWidth() / 320;
            final int lllllllllllIlIlIlllllllllllIIlII = lllllllllllIlIlIlllllllllllIIllI.getHeight() / 240;
            final int lllllllllllIlIlIlllllllllllIIIll = Math.min(lllllllllllIlIlIlllllllllllIIlIl, lllllllllllIlIlIlllllllllllIIlII);
            if (this.guiScale < 0) {
                this.guiScale = lllllllllllIlIlIlllllllllllIIIll - 1;
            }
            if (this.mc.isUnicode() && this.guiScale % 2 != 0) {
                this.guiScale += lllllllllllIlIlIlllllllllllIIlll;
            }
            if (this.guiScale < 0 || this.guiScale >= lllllllllllIlIlIlllllllllllIIIll) {
                this.guiScale = 0;
            }
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.PARTICLES) {
            this.particleSetting = (this.particleSetting + lllllllllllIlIlIlllllllllllIIlll) % 3;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.VIEW_BOBBING) {
            this.viewBobbing = !this.viewBobbing;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.RENDER_CLOUDS) {
            this.clouds = (this.clouds + lllllllllllIlIlIlllllllllllIIlll) % 3;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.FORCE_UNICODE_FONT) {
            this.forceUnicodeFont = !this.forceUnicodeFont;
            Minecraft.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.FBO_ENABLE) {
            this.fboEnable = !this.fboEnable;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.ANAGLYPH) {
            if (!this.anaglyph && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.an.shaders1"), Lang.get("of.message.an.shaders2"));
                return;
            }
            this.anaglyph = !this.anaglyph;
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.GRAPHICS) {
            this.fancyGraphics = !this.fancyGraphics;
            this.updateRenderClouds();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.AMBIENT_OCCLUSION) {
            this.ambientOcclusion = (this.ambientOcclusion + lllllllllllIlIlIlllllllllllIIlll) % 3;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.CHAT_VISIBILITY) {
            this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + lllllllllllIlIlIlllllllllllIIlll) % 3);
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.CHAT_COLOR) {
            this.chatColours = !this.chatColours;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.CHAT_LINKS) {
            this.chatLinks = !this.chatLinks;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.CHAT_LINKS_PROMPT) {
            this.chatLinksPrompt = !this.chatLinksPrompt;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.SNOOPER_ENABLED) {
            this.snooperEnabled = !this.snooperEnabled;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.TOUCHSCREEN) {
            this.touchscreen = !this.touchscreen;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.USE_FULLSCREEN) {
            this.fullScreen = !this.fullScreen;
            if (this.mc.isFullScreen() != this.fullScreen) {
                this.mc.toggleFullscreen();
            }
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.ENABLE_VSYNC) {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.USE_VBO) {
            this.useVbo = !this.useVbo;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.REDUCED_DEBUG_INFO) {
            this.reducedDebugInfo = !this.reducedDebugInfo;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.ENTITY_SHADOWS) {
            this.entityShadows = !this.entityShadows;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.ATTACK_INDICATOR) {
            this.attackIndicator = (this.attackIndicator + lllllllllllIlIlIlllllllllllIIlll) % 3;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.SHOW_SUBTITLES) {
            this.showSubtitles = !this.showSubtitles;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.REALMS_NOTIFICATIONS) {
            this.realmsNotifications = !this.realmsNotifications;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.AUTO_JUMP) {
            this.autoJump = !this.autoJump;
        }
        if (lllllllllllIlIlIlllllllllllIIIIl == Options.NARRATOR) {
            if (NarratorChatListener.field_193643_a.func_193640_a()) {
                this.field_192571_R = (this.field_192571_R + lllllllllllIlIlIlllllllllllIIlll) % GameSettings.field_193632_b.length;
            }
            else {
                this.field_192571_R = 0;
            }
            NarratorChatListener.field_193643_a.func_193641_a(this.field_192571_R);
        }
        this.saveOptions();
    }
    
    private void setOptionFloatValueOF(final Options lllllllllllIlIlIllllllllIIlIIlII, final float lllllllllllIlIlIllllllllIIlIIIll) {
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.CLOUD_HEIGHT) {
            this.ofCloudsHeight = lllllllllllIlIlIllllllllIIlIIIll;
            this.mc.renderGlobal.resetClouds();
        }
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.AO_LEVEL) {
            this.ofAoLevel = lllllllllllIlIlIllllllllIIlIIIll;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.AA_LEVEL) {
            final int lllllllllllIlIlIllllllllIIlIIIlI = (int)lllllllllllIlIlIllllllllIIlIIIll;
            if (lllllllllllIlIlIllllllllIIlIIIlI > 0 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
                return;
            }
            final int[] lllllllllllIlIlIllllllllIIlIIIIl = { 0, 2, 4, 6, 8, 12, 16 };
            this.ofAaLevel = 0;
            for (int lllllllllllIlIlIllllllllIIlIIIII = 0; lllllllllllIlIlIllllllllIIlIIIII < lllllllllllIlIlIllllllllIIlIIIIl.length; ++lllllllllllIlIlIllllllllIIlIIIII) {
                if (lllllllllllIlIlIllllllllIIlIIIlI >= lllllllllllIlIlIllllllllIIlIIIIl[lllllllllllIlIlIllllllllIIlIIIII]) {
                    this.ofAaLevel = lllllllllllIlIlIllllllllIIlIIIIl[lllllllllllIlIlIllllllllIIlIIIII];
                }
            }
            this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
        }
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.AF_LEVEL) {
            final int lllllllllllIlIlIllllllllIIIlllll = (int)lllllllllllIlIlIllllllllIIlIIIll;
            if (lllllllllllIlIlIllllllllIIIlllll > 1 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
                return;
            }
            this.ofAfLevel = 1;
            while (this.ofAfLevel * 2 <= lllllllllllIlIlIllllllllIIIlllll) {
                this.ofAfLevel *= 2;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.MIPMAP_TYPE) {
            final int lllllllllllIlIlIllllllllIIIllllI = (int)lllllllllllIlIlIllllllllIIlIIIll;
            this.ofMipmapType = Config.limit(lllllllllllIlIlIllllllllIIIllllI, 0, 3);
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIllllllllIIlIIlII == Options.FULLSCREEN_MODE) {
            final int lllllllllllIlIlIllllllllIIIlllIl = (int)lllllllllllIlIlIllllllllIIlIIIll - 1;
            final String[] lllllllllllIlIlIllllllllIIIlllII = Config.getDisplayModeNames();
            if (lllllllllllIlIlIllllllllIIIlllIl < 0 || lllllllllllIlIlIllllllllIIIlllIl >= lllllllllllIlIlIllllllllIIIlllII.length) {
                this.ofFullscreenMode = "Default";
                return;
            }
            this.ofFullscreenMode = lllllllllllIlIlIllllllllIIIlllII[lllllllllllIlIlIllllllllIIIlllIl];
        }
    }
    
    private float parseFloat(final String lllllllllllIlIlIllllllllIlllllII) {
        if ("true".equals(lllllllllllIlIlIllllllllIlllllII)) {
            return 1.0f;
        }
        return "false".equals(lllllllllllIlIlIllllllllIlllllII) ? 0.0f : Float.parseFloat(lllllllllllIlIlIllllllllIlllllII);
    }
    
    public void setModelPartEnabled(final EnumPlayerModelParts lllllllllllIlIlIllllllllIIlllIIl, final boolean lllllllllllIlIlIllllllllIIlllIII) {
        if (lllllllllllIlIlIllllllllIIlllIII) {
            this.setModelParts.add(lllllllllllIlIlIllllllllIIlllIIl);
        }
        else {
            this.setModelParts.remove(lllllllllllIlIlIllllllllIIlllIIl);
        }
        this.sendSettingsToServer();
    }
    
    public void loadOfOptions() {
        try {
            File lllllllllllIlIlIlllllllIlllIIIIl = this.optionsFileOF;
            if (!lllllllllllIlIlIlllllllIlllIIIIl.exists()) {
                lllllllllllIlIlIlllllllIlllIIIIl = this.optionsFile;
            }
            if (!lllllllllllIlIlIlllllllIlllIIIIl.exists()) {
                return;
            }
            final BufferedReader lllllllllllIlIlIlllllllIlllIIIII = new BufferedReader(new InputStreamReader(new FileInputStream(lllllllllllIlIlIlllllllIlllIIIIl), StandardCharsets.UTF_8));
            String lllllllllllIlIlIlllllllIllIlllll = "";
            while ((lllllllllllIlIlIlllllllIllIlllll = lllllllllllIlIlIlllllllIlllIIIII.readLine()) != null) {
                try {
                    final String[] lllllllllllIlIlIlllllllIllIllllI = lllllllllllIlIlIlllllllIllIlllll.split(":");
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofRenderDistanceChunks") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.renderDistanceChunks = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, 2, 1024);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFogType") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFogType = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFogStart") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFogStart = Float.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        if (this.ofFogStart < 0.2f) {
                            this.ofFogStart = 0.2f;
                        }
                        if (this.ofFogStart > 0.81f) {
                            this.ofFogStart = 0.8f;
                        }
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofMipmapType") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofMipmapType = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofOcclusionFancy") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofOcclusionFancy = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSmoothFps") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSmoothFps = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSmoothWorld") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSmoothWorld = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAoLevel") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAoLevel = Float.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0f, 1.0f);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofClouds") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofClouds = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                        this.updateRenderClouds();
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCloudsHeight") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCloudsHeight = Float.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0f, 1.0f);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofTrees") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofTrees = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofTrees = limit(this.ofTrees, GameSettings.OF_TREES_VALUES);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofDroppedItems") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofDroppedItems = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofRain") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofRain = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedWater") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedWater = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedLava") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedLava = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedFire") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedFire = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedPortal") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedPortal = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedRedstone") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedRedstone = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedExplosion") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedExplosion = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedFlame") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedFlame = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedSmoke") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedSmoke = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofVoidParticles") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofVoidParticles = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofWaterParticles") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofWaterParticles = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofPortalParticles") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofPortalParticles = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofPotionParticles") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofPotionParticles = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFireworkParticles") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFireworkParticles = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofDrippingWaterLava") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofDrippingWaterLava = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedTerrain") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedTerrain = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAnimatedTextures") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAnimatedTextures = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofRainSplash") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofRainSplash = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofLagometer") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofLagometer = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofShowFps") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofShowFps = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAutoSaveTicks") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAutoSaveTicks = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofBetterGrass") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofBetterGrass = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofConnectedTextures") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofConnectedTextures = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofWeather") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofWeather = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSky") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSky = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofStars") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofStars = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSunMoon") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSunMoon = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofVignette") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofVignette = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofVignette = Config.limit(this.ofVignette, 0, 2);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofChunkUpdates") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofChunkUpdates = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofChunkUpdatesDynamic") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofTime") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofTime = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofTime = Config.limit(this.ofTime, 0, 2);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofClearWater") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofClearWater = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.updateWaterOpacity();
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAaLevel") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAaLevel = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAfLevel") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAfLevel = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofProfiler") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofProfiler = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofBetterSnow") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofBetterSnow = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSwampColors") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSwampColors = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofRandomMobs") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofRandomMobs = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofSmoothBiomes") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofSmoothBiomes = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomFonts") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomFonts = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomColors") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomColors = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomItems") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomItems = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomSky") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomSky = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofShowCapes") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofShowCapes = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofNaturalTextures") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofNaturalTextures = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofLazyChunkLoading") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofLazyChunkLoading = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofDynamicFov") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofDynamicFov = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofAlternateBlocks") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofAlternateBlocks = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofDynamicLights") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofDynamicLights = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofDynamicLights = limit(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofScreenshotSize") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofScreenshotSize = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofScreenshotSize = Config.limit(this.ofScreenshotSize, 1, 4);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomEntityModels") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomEntityModels = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofCustomGuis") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofCustomGuis = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFullscreenMode") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFullscreenMode = lllllllllllIlIlIlllllllIllIllllI[1];
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFastMath") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFastMath = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        MathHelper.fastMath = this.ofFastMath;
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofFastRender") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofFastRender = Boolean.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                    }
                    if (lllllllllllIlIlIlllllllIllIllllI[0].equals("ofTranslucentBlocks") && lllllllllllIlIlIlllllllIllIllllI.length >= 2) {
                        this.ofTranslucentBlocks = Integer.valueOf(lllllllllllIlIlIlllllllIllIllllI[1]);
                        this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, 2);
                    }
                    if (!lllllllllllIlIlIlllllllIllIllllI[0].equals("key_" + this.ofKeyBindZoom.getKeyDescription())) {
                        continue;
                    }
                    this.ofKeyBindZoom.setKeyCode(Integer.parseInt(lllllllllllIlIlIlllllllIllIllllI[1]));
                }
                catch (Exception lllllllllllIlIlIlllllllIllIlllIl) {
                    Config.dbg("Skipping bad option: " + lllllllllllIlIlIlllllllIllIlllll);
                    lllllllllllIlIlIlllllllIllIlllIl.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
            lllllllllllIlIlIlllllllIlllIIIII.close();
        }
        catch (Exception lllllllllllIlIlIlllllllIllIlllII) {
            Config.warn("Failed to load options");
            lllllllllllIlIlIlllllllIllIlllII.printStackTrace();
        }
    }
    
    private void setForgeKeybindProperties() {
        if (Reflector.KeyConflictContext_IN_GAME.exists() && Reflector.ForgeKeyBinding_setKeyConflictContext.exists()) {
            final Object lllllllllllIlIlIlllllllIlIIlllII = Reflector.getFieldValue(Reflector.KeyConflictContext_IN_GAME);
            Reflector.call((Object)this.keyBindForward, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindLeft, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindBack, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindRight, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindJump, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindSneak, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindSprint, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindAttack, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindChat, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindPlayerList, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindCommand, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindTogglePerspective, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindSmoothCamera, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
            Reflector.call((Object)this.keyBindSwapHands, Reflector.ForgeKeyBinding_setKeyConflictContext, new Object[] { lllllllllllIlIlIlllllllIlIIlllII });
        }
    }
    
    public float getSoundLevel(final SoundCategory lllllllllllIlIlIllllllllIlIllIlI) {
        return this.soundLevels.containsKey(lllllllllllIlIlIllllllllIlIllIlI) ? this.soundLevels.get(lllllllllllIlIlIllllllllIlIllIlI) : 1.0f;
    }
    
    public void setOptionFloatValue(final Options lllllllllllIlIlIllllllllllllIIll, final float lllllllllllIlIlIllllllllllllIllI) {
        this.setOptionFloatValueOF(lllllllllllIlIlIllllllllllllIIll, lllllllllllIlIlIllllllllllllIllI);
        if (lllllllllllIlIlIllllllllllllIIll == Options.SENSITIVITY) {
            this.mouseSensitivity = lllllllllllIlIlIllllllllllllIllI;
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.FOV) {
            this.fovSetting = lllllllllllIlIlIllllllllllllIllI;
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.GAMMA) {
            this.gammaSetting = lllllllllllIlIlIllllllllllllIllI;
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.FRAMERATE_LIMIT) {
            this.limitFramerate = (int)lllllllllllIlIlIllllllllllllIllI;
            this.enableVsync = false;
            if (this.limitFramerate <= 0) {
                this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                this.enableVsync = true;
            }
            this.updateVSync();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.CHAT_OPACITY) {
            this.chatOpacity = lllllllllllIlIlIllllllllllllIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.CHAT_HEIGHT_FOCUSED) {
            this.chatHeightFocused = lllllllllllIlIlIllllllllllllIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.CHAT_HEIGHT_UNFOCUSED) {
            this.chatHeightUnfocused = lllllllllllIlIlIllllllllllllIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.CHAT_WIDTH) {
            this.chatWidth = lllllllllllIlIlIllllllllllllIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.CHAT_SCALE) {
            this.chatScale = lllllllllllIlIlIllllllllllllIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.MIPMAP_LEVELS) {
            final int lllllllllllIlIlIllllllllllllIlIl = this.mipmapLevels;
            this.mipmapLevels = (int)lllllllllllIlIlIllllllllllllIllI;
            if (lllllllllllIlIlIllllllllllllIlIl != lllllllllllIlIlIllllllllllllIllI) {
                this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
                this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                this.mc.getTextureMapBlocks().setBlurMipmapDirect(false, this.mipmapLevels > 0);
                this.mc.scheduleResourcesRefresh();
            }
        }
        if (lllllllllllIlIlIllllllllllllIIll == Options.RENDER_DISTANCE) {
            this.renderDistanceChunks = (int)lllllllllllIlIlIllllllllllllIllI;
            this.mc.renderGlobal.setDisplayListEntitiesDirty();
        }
    }
    
    public GameSettings(final Minecraft lllllllllllIlIllIIIIIIIIIIIlIIll, final File lllllllllllIlIllIIIIIIIIIIIlIIlI) {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = 2;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = (List<String>)Lists.newArrayList();
        this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = true;
        this.pauseOnLostFocus = true;
        this.setModelParts = (Set<EnumPlayerModelParts>)Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.mainHand = EnumHandSide.RIGHT;
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.mipmapLevels = 4;
        this.soundLevels = (Map<SoundCategory, Float>)Maps.newEnumMap((Class)SoundCategory.class);
        this.useNativeTransport = true;
        this.entityShadows = true;
        this.attackIndicator = 1;
        this.realmsNotifications = true;
        this.autoJump = true;
        this.field_193631_S = TutorialSteps.MOVEMENT;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindSwapHands = new KeyBinding("key.swapHands", 33, "key.categories.inventory");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.field_194146_ao = new KeyBinding("key.advancements", 38, "key.categories.misc");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.field_193629_ap = new KeyBinding("key.saveToolbarActivator", 46, "key.categories.creative");
        this.field_193630_aq = new KeyBinding("key.loadToolbarActivator", 45, "key.categories.creative");
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofScreenshotSize = 1;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.needsResourceRefresh = false;
        this.setForgeKeybindProperties();
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines, this.keyBindSwapHands, this.field_193629_ap, this.field_193630_aq, this.field_194146_ao }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_us";
        this.mc = lllllllllllIlIllIIIIIIIIIIIlIIll;
        this.optionsFile = new File(lllllllllllIlIllIIIIIIIIIIIlIIlI, "options.txt");
        if (lllllllllllIlIllIIIIIIIIIIIlIIll.isJava64bit() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
            Options.RENDER_DISTANCE.setValueMax(32.0f);
        }
        else {
            Options.RENDER_DISTANCE.setValueMax(16.0f);
        }
        this.renderDistanceChunks = (lllllllllllIlIllIIIIIIIIIIIlIIll.isJava64bit() ? 12 : 8);
        this.optionsFileOF = new File(lllllllllllIlIllIIIIIIIIIIIlIIlI, "optionsof.txt");
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.ofKeyBindZoom = new KeyBinding("of.key.zoom", 46, "key.categories.misc");
        this.keyBindings = (KeyBinding[])ArrayUtils.add((Object[])this.keyBindings, (Object)this.ofKeyBindZoom);
        Options.RENDER_DISTANCE.setValueMax(32.0f);
        this.renderDistanceChunks = 8;
        this.loadOptions();
        Config.initGameSettings(this);
    }
    
    public static boolean isKeyDown(final KeyBinding lllllllllllIlIllIIIIIIIIIIIIIlll) {
        final int lllllllllllIlIllIIIIIIIIIIIIlIII = lllllllllllIlIllIIIIIIIIIIIIIlll.getKeyCode();
        return lllllllllllIlIllIIIIIIIIIIIIlIII != 0 && lllllllllllIlIllIIIIIIIIIIIIlIII < 256 && ((lllllllllllIlIllIIIIIIIIIIIIlIII < 0) ? Mouse.isButtonDown(lllllllllllIlIllIIIIIIIIIIIIlIII + 100) : Keyboard.isKeyDown(lllllllllllIlIllIIIIIIIIIIIIlIII));
    }
    
    private float getOptionFloatValueOF(final Options lllllllllllIlIlIllllllllIIIIllII) {
        if (lllllllllllIlIlIllllllllIIIIllII == Options.CLOUD_HEIGHT) {
            return this.ofCloudsHeight;
        }
        if (lllllllllllIlIlIllllllllIIIIllII == Options.AO_LEVEL) {
            return this.ofAoLevel;
        }
        if (lllllllllllIlIlIllllllllIIIIllII == Options.AA_LEVEL) {
            return (float)this.ofAaLevel;
        }
        if (lllllllllllIlIlIllllllllIIIIllII == Options.AF_LEVEL) {
            return (float)this.ofAfLevel;
        }
        if (lllllllllllIlIlIllllllllIIIIllII == Options.MIPMAP_TYPE) {
            return (float)this.ofMipmapType;
        }
        if (lllllllllllIlIlIllllllllIIIIllII == Options.FRAMERATE_LIMIT) {
            return (this.limitFramerate == Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync) ? 0.0f : ((float)this.limitFramerate);
        }
        if (lllllllllllIlIlIllllllllIIIIllII != Options.FULLSCREEN_MODE) {
            return Float.MAX_VALUE;
        }
        if (this.ofFullscreenMode.equals("Default")) {
            return 0.0f;
        }
        final List lllllllllllIlIlIllllllllIIIIllll = Arrays.asList(Config.getDisplayModeNames());
        final int lllllllllllIlIlIllllllllIIIIlllI = lllllllllllIlIlIllllllllIIIIllll.indexOf(this.ofFullscreenMode);
        return (lllllllllllIlIlIllllllllIIIIlllI < 0) ? 0.0f : ((float)(lllllllllllIlIlIllllllllIIIIlllI + 1));
    }
    
    public int shouldRenderClouds() {
        return (this.renderDistanceChunks >= 4) ? this.clouds : 0;
    }
    
    private NBTTagCompound dataFix(final NBTTagCompound lllllllllllIlIlIlllllllllIIIIlIl) {
        int lllllllllllIlIlIlllllllllIIIIlII = 0;
        try {
            lllllllllllIlIlIlllllllllIIIIlII = Integer.parseInt(lllllllllllIlIlIlllllllllIIIIlIl.getString("version"));
        }
        catch (RuntimeException ex) {}
        return this.mc.getDataFixer().process(FixTypes.OPTIONS, lllllllllllIlIlIlllllllllIIIIlIl, lllllllllllIlIlIlllllllllIIIIlII);
    }
    
    private void setOptionValueOF(final Options lllllllllllIlIlIllllllllIIIIIllI, final int lllllllllllIlIlIllllllllIIIIIlIl) {
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    this.ofFogType = 2;
                    if (!Config.isFancyFogAvailable()) {
                        this.ofFogType = 3;
                        break;
                    }
                    break;
                }
                case 2: {
                    this.ofFogType = 3;
                    break;
                }
                case 3: {
                    this.ofFogType = 1;
                    break;
                }
                default: {
                    this.ofFogType = 1;
                    break;
                }
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.FOG_START) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SMOOTH_FPS) {
            this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SMOOTH_WORLD) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CLOUDS) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
            this.updateRenderClouds();
            this.mc.renderGlobal.resetClouds();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.TREES) {
            this.ofTrees = nextValue(this.ofTrees, GameSettings.OF_TREES_VALUES);
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.DROPPED_ITEMS) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.RAIN) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_WATER) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater == 1) {
                ++this.ofAnimatedWater;
            }
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_LAVA) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava == 1) {
                ++this.ofAnimatedLava;
            }
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_FIRE) {
            this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_PORTAL) {
            this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_REDSTONE) {
            this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_EXPLOSION) {
            this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_FLAME) {
            this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_SMOKE) {
            this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.VOID_PARTICLES) {
            this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.WATER_PARTICLES) {
            this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.PORTAL_PARTICLES) {
            this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.POTION_PARTICLES) {
            this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.FIREWORK_PARTICLES) {
            this.ofFireworkParticles = !this.ofFireworkParticles;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.DRIPPING_WATER_LAVA) {
            this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_TERRAIN) {
            this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ANIMATED_TEXTURES) {
            this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.RAIN_SPLASH) {
            this.ofRainSplash = !this.ofRainSplash;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.LAGOMETER) {
            this.ofLagometer = !this.ofLagometer;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SHOW_FPS) {
            this.ofShowFps = !this.ofShowFps;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.AUTOSAVE_TICKS) {
            this.ofAutoSaveTicks *= 10;
            if (this.ofAutoSaveTicks > 40000) {
                this.ofAutoSaveTicks = 40;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.BETTER_GRASS) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CONNECTED_TEXTURES) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            if (this.ofConnectedTextures == 2) {
                this.mc.renderGlobal.loadRenderers();
            }
            else {
                this.mc.refreshResources();
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.WEATHER) {
            this.ofWeather = !this.ofWeather;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SKY) {
            this.ofSky = !this.ofSky;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.STARS) {
            this.ofStars = !this.ofStars;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SUN_MOON) {
            this.ofSunMoon = !this.ofSunMoon;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.VIGNETTE) {
            ++this.ofVignette;
            if (this.ofVignette > 2) {
                this.ofVignette = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CHUNK_UPDATES) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CHUNK_UPDATES_DYNAMIC) {
            this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.TIME) {
            ++this.ofTime;
            if (this.ofTime > 2) {
                this.ofTime = 0;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CLEAR_WATER) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.PROFILER) {
            this.ofProfiler = !this.ofProfiler;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.BETTER_SNOW) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SWAMP_COLORS) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.RANDOM_MOBS) {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SMOOTH_BIOMES) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_FONTS) {
            this.ofCustomFonts = !this.ofCustomFonts;
            Minecraft.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
            this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_COLORS) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColors.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_ITEMS) {
            this.ofCustomItems = !this.ofCustomItems;
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_SKY) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SHOW_CAPES) {
            this.ofShowCapes = !this.ofShowCapes;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.NATURAL_TEXTURES) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.FAST_MATH) {
            this.ofFastMath = !this.ofFastMath;
            MathHelper.fastMath = this.ofFastMath;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.FAST_RENDER) {
            if (!this.ofFastRender && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
                return;
            }
            this.ofFastRender = !this.ofFastRender;
            if (this.ofFastRender) {
                this.mc.entityRenderer.stopUseShader();
            }
            Config.updateFramebufferSize();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.TRANSLUCENT_BLOCKS) {
            if (this.ofTranslucentBlocks == 0) {
                this.ofTranslucentBlocks = 1;
            }
            else if (this.ofTranslucentBlocks == 1) {
                this.ofTranslucentBlocks = 2;
            }
            else if (this.ofTranslucentBlocks == 2) {
                this.ofTranslucentBlocks = 0;
            }
            else {
                this.ofTranslucentBlocks = 0;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.LAZY_CHUNK_LOADING) {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            Config.updateAvailableProcessors();
            if (!Config.isSingleProcessor()) {
                this.ofLazyChunkLoading = false;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.DYNAMIC_FOV) {
            this.ofDynamicFov = !this.ofDynamicFov;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ALTERNATE_BLOCKS) {
            this.ofAlternateBlocks = !this.ofAlternateBlocks;
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.DYNAMIC_LIGHTS) {
            this.ofDynamicLights = nextValue(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
            DynamicLights.removeLights(this.mc.renderGlobal);
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.SCREENSHOT_SIZE) {
            ++this.ofScreenshotSize;
            if (this.ofScreenshotSize > 4) {
                this.ofScreenshotSize = 1;
            }
            if (!OpenGlHelper.isFramebufferEnabled()) {
                this.ofScreenshotSize = 1;
            }
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_ENTITY_MODELS) {
            this.ofCustomEntityModels = !this.ofCustomEntityModels;
            this.mc.refreshResources();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.CUSTOM_GUIS) {
            this.ofCustomGuis = !this.ofCustomGuis;
            CustomGuis.update();
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.HELD_ITEM_TOOLTIPS) {
            this.heldItemTooltips = !this.heldItemTooltips;
        }
        if (lllllllllllIlIlIllllllllIIIIIllI == Options.ADVANCED_TOOLTIPS) {
            this.advancedItemTooltips = !this.advancedItemTooltips;
        }
    }
    
    public void sendSettingsToServer() {
        if (this.mc.player != null) {
            int lllllllllllIlIlIllllllllIlIIlIIl = 0;
            for (final EnumPlayerModelParts lllllllllllIlIlIllllllllIlIIlIII : this.setModelParts) {
                lllllllllllIlIlIllllllllIlIIlIIl |= lllllllllllIlIlIllllllllIlIIlIII.getPartMask();
            }
            this.mc.player.connection.sendPacket(new CPacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, lllllllllllIlIlIllllllllIlIIlIIl, this.mainHand));
        }
    }
    
    public GameSettings() {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = 2;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = (List<String>)Lists.newArrayList();
        this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = true;
        this.pauseOnLostFocus = true;
        this.setModelParts = (Set<EnumPlayerModelParts>)Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.mainHand = EnumHandSide.RIGHT;
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.mipmapLevels = 4;
        this.soundLevels = (Map<SoundCategory, Float>)Maps.newEnumMap((Class)SoundCategory.class);
        this.useNativeTransport = true;
        this.entityShadows = true;
        this.attackIndicator = 1;
        this.realmsNotifications = true;
        this.autoJump = true;
        this.field_193631_S = TutorialSteps.MOVEMENT;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindSwapHands = new KeyBinding("key.swapHands", 33, "key.categories.inventory");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.field_194146_ao = new KeyBinding("key.advancements", 38, "key.categories.misc");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.field_193629_ap = new KeyBinding("key.saveToolbarActivator", 46, "key.categories.creative");
        this.field_193630_aq = new KeyBinding("key.loadToolbarActivator", 45, "key.categories.creative");
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofScreenshotSize = 1;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.needsResourceRefresh = false;
        this.setForgeKeybindProperties();
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines, this.keyBindSwapHands, this.field_193629_ap, this.field_193630_aq, this.field_194146_ao }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_us";
    }
    
    public float getOptionFloatValue(final Options lllllllllllIlIlIllllllllllIlIlll) {
        final float lllllllllllIlIlIllllllllllIlIllI = this.getOptionFloatValueOF(lllllllllllIlIlIllllllllllIlIlll);
        if (lllllllllllIlIlIllllllllllIlIllI != Float.MAX_VALUE) {
            return lllllllllllIlIlIllllllllllIlIllI;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.FOV) {
            return this.fovSetting;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.GAMMA) {
            return this.gammaSetting;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.SATURATION) {
            return this.saturation;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.SENSITIVITY) {
            return this.mouseSensitivity;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.CHAT_OPACITY) {
            return this.chatOpacity;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.CHAT_HEIGHT_FOCUSED) {
            return this.chatHeightFocused;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.CHAT_HEIGHT_UNFOCUSED) {
            return this.chatHeightUnfocused;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.CHAT_SCALE) {
            return this.chatScale;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.CHAT_WIDTH) {
            return this.chatWidth;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.FRAMERATE_LIMIT) {
            return (float)this.limitFramerate;
        }
        if (lllllllllllIlIlIllllllllllIlIlll == Options.MIPMAP_LEVELS) {
            return (float)this.mipmapLevels;
        }
        return (lllllllllllIlIlIllllllllllIlIlll == Options.RENDER_DISTANCE) ? ((float)this.renderDistanceChunks) : 0.0f;
    }
    
    public void onGuiClosed() {
        if (this.needsResourceRefresh) {
            this.mc.scheduleResourcesRefresh();
            this.needsResourceRefresh = false;
        }
    }
    
    private void updateWaterOpacity() {
        if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
            Config.waterOpacityChanged = true;
        }
        ClearWater.updateWaterOpacity(this, (World)this.mc.world);
    }
    
    public static String getKeyDisplayString(final int lllllllllllIlIllIIIIIIIIIIIIllII) {
        if (lllllllllllIlIllIIIIIIIIIIIIllII >= 0) {
            return (lllllllllllIlIllIIIIIIIIIIIIllII < 256) ? Keyboard.getKeyName(lllllllllllIlIllIIIIIIIIIIIIllII) : String.format("%c", (char)(lllllllllllIlIllIIIIIIIIIIIIllII - 256)).toUpperCase();
        }
        switch (lllllllllllIlIllIIIIIIIIIIIIllII) {
            case -100: {
                return I18n.format("key.mouse.left", new Object[0]);
            }
            case -99: {
                return I18n.format("key.mouse.right", new Object[0]);
            }
            case -98: {
                return I18n.format("key.mouse.middle", new Object[0]);
            }
            default: {
                return I18n.format("key.mouseButton", lllllllllllIlIllIIIIIIIIIIIIllII + 101);
            }
        }
    }
    
    public void saveOptions() {
        if (Reflector.FMLClientHandler.exists()) {
            final Object lllllllllllIlIlIllllllllIlllIIII = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            if (lllllllllllIlIlIllllllllIlllIIII != null && Reflector.callBoolean(lllllllllllIlIlIllllllllIlllIIII, Reflector.FMLClientHandler_isLoading, new Object[0])) {
                return;
            }
        }
        PrintWriter lllllllllllIlIlIllllllllIllIllll = null;
        Label_1777: {
            try {
                lllllllllllIlIlIllllllllIllIllll = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.optionsFile), StandardCharsets.UTF_8));
                lllllllllllIlIlIllllllllIllIllll.println("version:1343");
                lllllllllllIlIlIllllllllIllIllll.println("invertYMouse:" + this.invertMouse);
                lllllllllllIlIlIllllllllIllIllll.println("mouseSensitivity:" + this.mouseSensitivity);
                lllllllllllIlIlIllllllllIllIllll.println("fov:" + (this.fovSetting - 70.0f) / 40.0f);
                lllllllllllIlIlIllllllllIllIllll.println("gamma:" + this.gammaSetting);
                lllllllllllIlIlIllllllllIllIllll.println("saturation:" + this.saturation);
                lllllllllllIlIlIllllllllIllIllll.println("renderDistance:" + this.renderDistanceChunks);
                lllllllllllIlIlIllllllllIllIllll.println("guiScale:" + this.guiScale);
                lllllllllllIlIlIllllllllIllIllll.println("particles:" + this.particleSetting);
                lllllllllllIlIlIllllllllIllIllll.println("bobView:" + this.viewBobbing);
                lllllllllllIlIlIllllllllIllIllll.println("anaglyph3d:" + this.anaglyph);
                lllllllllllIlIlIllllllllIllIllll.println("maxFps:" + this.limitFramerate);
                lllllllllllIlIlIllllllllIllIllll.println("fboEnable:" + this.fboEnable);
                lllllllllllIlIlIllllllllIllIllll.println("difficulty:" + this.difficulty.getDifficultyId());
                lllllllllllIlIlIllllllllIllIllll.println("fancyGraphics:" + this.fancyGraphics);
                lllllllllllIlIlIllllllllIllIllll.println("ao:" + this.ambientOcclusion);
                switch (this.clouds) {
                    case 0: {
                        lllllllllllIlIlIllllllllIllIllll.println("renderClouds:false");
                        break;
                    }
                    case 1: {
                        lllllllllllIlIlIllllllllIllIllll.println("renderClouds:fast");
                        break;
                    }
                    case 2: {
                        lllllllllllIlIlIllllllllIllIllll.println("renderClouds:true");
                        break;
                    }
                }
                lllllllllllIlIlIllllllllIllIllll.println("resourcePacks:" + GameSettings.GSON.toJson((Object)this.resourcePacks));
                lllllllllllIlIlIllllllllIllIllll.println("incompatibleResourcePacks:" + GameSettings.GSON.toJson((Object)this.incompatibleResourcePacks));
                lllllllllllIlIlIllllllllIllIllll.println("lastServer:" + this.lastServer);
                lllllllllllIlIlIllllllllIllIllll.println("lang:" + this.language);
                lllllllllllIlIlIllllllllIllIllll.println("chatVisibility:" + this.chatVisibility.getChatVisibility());
                lllllllllllIlIlIllllllllIllIllll.println("chatColors:" + this.chatColours);
                lllllllllllIlIlIllllllllIllIllll.println("chatLinks:" + this.chatLinks);
                lllllllllllIlIlIllllllllIllIllll.println("chatLinksPrompt:" + this.chatLinksPrompt);
                lllllllllllIlIlIllllllllIllIllll.println("chatOpacity:" + this.chatOpacity);
                lllllllllllIlIlIllllllllIllIllll.println("snooperEnabled:" + this.snooperEnabled);
                lllllllllllIlIlIllllllllIllIllll.println("fullscreen:" + this.fullScreen);
                lllllllllllIlIlIllllllllIllIllll.println("enableVsync:" + this.enableVsync);
                lllllllllllIlIlIllllllllIllIllll.println("useVbo:" + this.useVbo);
                lllllllllllIlIlIllllllllIllIllll.println("hideServerAddress:" + this.hideServerAddress);
                lllllllllllIlIlIllllllllIllIllll.println("advancedItemTooltips:" + this.advancedItemTooltips);
                lllllllllllIlIlIllllllllIllIllll.println("pauseOnLostFocus:" + this.pauseOnLostFocus);
                lllllllllllIlIlIllllllllIllIllll.println("touchscreen:" + this.touchscreen);
                lllllllllllIlIlIllllllllIllIllll.println("overrideWidth:" + this.overrideWidth);
                lllllllllllIlIlIllllllllIllIllll.println("overrideHeight:" + this.overrideHeight);
                lllllllllllIlIlIllllllllIllIllll.println("heldItemTooltips:" + this.heldItemTooltips);
                lllllllllllIlIlIllllllllIllIllll.println("chatHeightFocused:" + this.chatHeightFocused);
                lllllllllllIlIlIllllllllIllIllll.println("chatHeightUnfocused:" + this.chatHeightUnfocused);
                lllllllllllIlIlIllllllllIllIllll.println("chatScale:" + this.chatScale);
                lllllllllllIlIlIllllllllIllIllll.println("chatWidth:" + this.chatWidth);
                lllllllllllIlIlIllllllllIllIllll.println("mipmapLevels:" + this.mipmapLevels);
                lllllllllllIlIlIllllllllIllIllll.println("forceUnicodeFont:" + this.forceUnicodeFont);
                lllllllllllIlIlIllllllllIllIllll.println("reducedDebugInfo:" + this.reducedDebugInfo);
                lllllllllllIlIlIllllllllIllIllll.println("useNativeTransport:" + this.useNativeTransport);
                lllllllllllIlIlIllllllllIllIllll.println("entityShadows:" + this.entityShadows);
                lllllllllllIlIlIllllllllIllIllll.println("mainHand:" + ((this.mainHand == EnumHandSide.LEFT) ? "left" : "right"));
                lllllllllllIlIlIllllllllIllIllll.println("attackIndicator:" + this.attackIndicator);
                lllllllllllIlIlIllllllllIllIllll.println("showSubtitles:" + this.showSubtitles);
                lllllllllllIlIlIllllllllIllIllll.println("realmsNotifications:" + this.realmsNotifications);
                lllllllllllIlIlIllllllllIllIllll.println("enableWeakAttacks:" + this.enableWeakAttacks);
                lllllllllllIlIlIllllllllIllIllll.println("autoJump:" + this.autoJump);
                lllllllllllIlIlIllllllllIllIllll.println("narrator:" + this.field_192571_R);
                lllllllllllIlIlIllllllllIllIllll.println("tutorialStep:" + this.field_193631_S.func_193308_a());
                double lllllllllllIlIlIllllllllIllIIIlI;
                for (short lllllllllllIlIlIllllllllIllIIIll = (short)((KeyBinding[])(Object)(lllllllllllIlIlIllllllllIllIIIlI = (double)(Object)this.keyBindings)).length, lllllllllllIlIlIllllllllIllIIlII = 0; lllllllllllIlIlIllllllllIllIIlII < lllllllllllIlIlIllllllllIllIIIll; ++lllllllllllIlIlIllllllllIllIIlII) {
                    final KeyBinding lllllllllllIlIlIllllllllIllIlllI = lllllllllllIlIlIllllllllIllIIIlI[lllllllllllIlIlIllllllllIllIIlII];
                    if (Reflector.ForgeKeyBinding_getKeyModifier.exists()) {
                        final String lllllllllllIlIlIllllllllIllIllIl = "key_" + lllllllllllIlIlIllllllllIllIlllI.getKeyDescription() + ":" + lllllllllllIlIlIllllllllIllIlllI.getKeyCode();
                        final Object lllllllllllIlIlIllllllllIllIllII = Reflector.call((Object)lllllllllllIlIlIllllllllIllIlllI, Reflector.ForgeKeyBinding_getKeyModifier, new Object[0]);
                        final Object lllllllllllIlIlIllllllllIllIlIll = Reflector.getFieldValue(Reflector.KeyModifier_NONE);
                        lllllllllllIlIlIllllllllIllIllll.println((lllllllllllIlIlIllllllllIllIllII != lllllllllllIlIlIllllllllIllIlIll) ? (String.valueOf(lllllllllllIlIlIllllllllIllIllIl) + ":" + lllllllllllIlIlIllllllllIllIllII) : lllllllllllIlIlIllllllllIllIllIl);
                    }
                    else {
                        lllllllllllIlIlIllllllllIllIllll.println("key_" + lllllllllllIlIlIllllllllIllIlllI.getKeyDescription() + ":" + lllllllllllIlIlIllllllllIllIlllI.getKeyCode());
                    }
                }
                for (short lllllllllllIlIlIllllllllIllIIIll = (short)((SoundCategory[])(Object)(lllllllllllIlIlIllllllllIllIIIlI = (double)(Object)SoundCategory.values())).length, lllllllllllIlIlIllllllllIllIIlII = 0; lllllllllllIlIlIllllllllIllIIlII < lllllllllllIlIlIllllllllIllIIIll; ++lllllllllllIlIlIllllllllIllIIlII) {
                    final SoundCategory lllllllllllIlIlIllllllllIllIlIlI = lllllllllllIlIlIllllllllIllIIIlI[lllllllllllIlIlIllllllllIllIIlII];
                    lllllllllllIlIlIllllllllIllIllll.println("soundCategory_" + lllllllllllIlIlIllllllllIllIlIlI.getName() + ":" + this.getSoundLevel(lllllllllllIlIlIllllllllIllIlIlI));
                }
                for (short lllllllllllIlIlIllllllllIllIIIll = (short)((EnumPlayerModelParts[])(Object)(lllllllllllIlIlIllllllllIllIIIlI = (double)(Object)EnumPlayerModelParts.values())).length, lllllllllllIlIlIllllllllIllIIlII = 0; lllllllllllIlIlIllllllllIllIIlII < lllllllllllIlIlIllllllllIllIIIll; ++lllllllllllIlIlIllllllllIllIIlII) {
                    final EnumPlayerModelParts lllllllllllIlIlIllllllllIllIlIIl = lllllllllllIlIlIllllllllIllIIIlI[lllllllllllIlIlIllllllllIllIIlII];
                    lllllllllllIlIlIllllllllIllIllll.println("modelPart_" + lllllllllllIlIlIllllllllIllIlIIl.getPartName() + ":" + this.setModelParts.contains(lllllllllllIlIlIllllllllIllIlIIl));
                }
            }
            catch (Exception lllllllllllIlIlIllllllllIllIlIII) {
                GameSettings.LOGGER.error("Failed to save options", (Throwable)lllllllllllIlIlIllllllllIllIlIII);
                break Label_1777;
            }
            finally {
                IOUtils.closeQuietly((Writer)lllllllllllIlIlIllllllllIllIllll);
            }
            IOUtils.closeQuietly((Writer)lllllllllllIlIlIllllllllIllIllll);
        }
        this.saveOfOptions();
        this.sendSettingsToServer();
    }
    
    static {
        DEFAULT_STR = "Default";
        FAST = 1;
        OFF = 3;
        SMART = 4;
        FANCY = 2;
        ANIM_ON = 0;
        DEFAULT = 0;
        ANIM_GENERATED = 1;
        ANIM_OFF = 2;
        LOGGER = LogManager.getLogger();
        GSON = new Gson();
        TYPE_LIST_STRING = new ParameterizedType() {
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class };
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        COLON_SPLITTER = Splitter.on(':');
        GUISCALES = new String[] { "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large" };
        PARTICLES = new String[] { "options.particles.all", "options.particles.decreased", "options.particles.minimal" };
        AMBIENT_OCCLUSIONS = new String[] { "options.ao.off", "options.ao.min", "options.ao.max" };
        CLOUDS_TYPES = new String[] { "options.off", "options.clouds.fast", "options.clouds.fancy" };
        ATTACK_INDICATORS = new String[] { "options.off", "options.attack.crosshair", "options.attack.hotbar" };
        field_193632_b = new String[] { "options.narrator.off", "options.narrator.all", "options.narrator.chat", "options.narrator.system" };
        OF_TREES_VALUES = new int[] { 0, 1, 4, 2 };
        OF_DYNAMIC_LIGHTS = new int[] { 3, 1, 2 };
        KEYS_DYNAMIC_LIGHTS = new String[] { "options.off", "options.graphics.fast", "options.graphics.fancy" };
    }
    
    private static int indexOf(final int lllllllllllIlIlIlllllllIlIlIIlIl, final int[] lllllllllllIlIlIlllllllIlIlIIIIl) {
        for (int lllllllllllIlIlIlllllllIlIlIIIll = 0; lllllllllllIlIlIlllllllIlIlIIIll < lllllllllllIlIlIlllllllIlIlIIIIl.length; ++lllllllllllIlIlIlllllllIlIlIIIll) {
            if (lllllllllllIlIlIlllllllIlIlIIIIl[lllllllllllIlIlIlllllllIlIlIIIll] == lllllllllllIlIlIlllllllIlIlIIlIl) {
                return lllllllllllIlIlIlllllllIlIlIIIll;
            }
        }
        return -1;
    }
    
    private String getKeyBindingOF(final Options lllllllllllIlIlIlllllllIlllllIIl) {
        String lllllllllllIlIlIlllllllIlllllIII = String.valueOf(I18n.format(lllllllllllIlIlIlllllllIlllllIIl.getEnumString(), new Object[0])) + ": ";
        if (lllllllllllIlIlIlllllllIlllllIII == null) {
            lllllllllllIlIlIlllllllIlllllIII = lllllllllllIlIlIlllllllIlllllIIl.getEnumString();
        }
        if (lllllllllllIlIlIlllllllIlllllIIl == Options.RENDER_DISTANCE) {
            final int lllllllllllIlIlIlllllllIllllIlll = (int)this.getOptionFloatValue(lllllllllllIlIlIlllllllIlllllIIl);
            String lllllllllllIlIlIlllllllIllllIllI = I18n.format("of.options.renderDistance.tiny", new Object[0]);
            int lllllllllllIlIlIlllllllIllllIlIl = 2;
            if (lllllllllllIlIlIlllllllIllllIlll >= 4) {
                lllllllllllIlIlIlllllllIllllIllI = I18n.format("of.options.renderDistance.short", new Object[0]);
                lllllllllllIlIlIlllllllIllllIlIl = 4;
            }
            if (lllllllllllIlIlIlllllllIllllIlll >= 8) {
                lllllllllllIlIlIlllllllIllllIllI = I18n.format("of.options.renderDistance.normal", new Object[0]);
                lllllllllllIlIlIlllllllIllllIlIl = 8;
            }
            if (lllllllllllIlIlIlllllllIllllIlll >= 16) {
                lllllllllllIlIlIlllllllIllllIllI = I18n.format("of.options.renderDistance.far", new Object[0]);
                lllllllllllIlIlIlllllllIllllIlIl = 16;
            }
            if (lllllllllllIlIlIlllllllIllllIlll >= 32) {
                lllllllllllIlIlIlllllllIllllIllI = Lang.get("of.options.renderDistance.extreme");
                lllllllllllIlIlIlllllllIllllIlIl = 32;
            }
            final int lllllllllllIlIlIlllllllIllllIlII = this.renderDistanceChunks - lllllllllllIlIlIlllllllIllllIlIl;
            String lllllllllllIlIlIlllllllIllllIIll = lllllllllllIlIlIlllllllIllllIllI;
            if (lllllllllllIlIlIlllllllIllllIlII > 0) {
                lllllllllllIlIlIlllllllIllllIIll = String.valueOf(lllllllllllIlIlIlllllllIllllIllI) + "+";
            }
            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + lllllllllllIlIlIlllllllIllllIlll + " " + lllllllllllIlIlIlllllllIllllIIll;
        }
        if (lllllllllllIlIlIlllllllIlllllIIl == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                }
                case 2: {
                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                }
                case 3: {
                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                }
                default: {
                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                }
            }
        }
        else {
            if (lllllllllllIlIlIlllllllIlllllIIl == Options.FOG_START) {
                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofFogStart;
            }
            if (lllllllllllIlIlIlllllllIlllllIIl == Options.MIPMAP_TYPE) {
                switch (this.ofMipmapType) {
                    case 0: {
                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.mipmap.nearest");
                    }
                    case 1: {
                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.mipmap.linear");
                    }
                    case 2: {
                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.mipmap.bilinear");
                    }
                    case 3: {
                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.mipmap.trilinear");
                    }
                    default: {
                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + "of.options.mipmap.nearest";
                    }
                }
            }
            else {
                if (lllllllllllIlIlIlllllllIlllllIIl == Options.SMOOTH_FPS) {
                    return this.ofSmoothFps ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                }
                if (lllllllllllIlIlIlllllllIlllllIIl == Options.SMOOTH_WORLD) {
                    return this.ofSmoothWorld ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                }
                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CLOUDS) {
                    switch (this.ofClouds) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                        }
                        case 3: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault();
                        }
                    }
                }
                else if (lllllllllllIlIlIlllllllIlllllIIl == Options.TREES) {
                    switch (this.ofTrees) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault();
                        }
                        case 4: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.general.smart");
                        }
                    }
                }
                else if (lllllllllllIlIlIlllllllIlllllIIl == Options.DROPPED_ITEMS) {
                    switch (this.ofDroppedItems) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault();
                        }
                    }
                }
                else if (lllllllllllIlIlIlllllllIlllllIIl == Options.RAIN) {
                    switch (this.ofRain) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                        }
                        case 3: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault();
                        }
                    }
                }
                else if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_WATER) {
                    switch (this.ofAnimatedWater) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.animation.dynamic");
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn();
                        }
                    }
                }
                else if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_LAVA) {
                    switch (this.ofAnimatedLava) {
                        case 1: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.animation.dynamic");
                        }
                        case 2: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                        }
                        default: {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn();
                        }
                    }
                }
                else {
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_FIRE) {
                        return this.ofAnimatedFire ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_PORTAL) {
                        return this.ofAnimatedPortal ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_REDSTONE) {
                        return this.ofAnimatedRedstone ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_EXPLOSION) {
                        return this.ofAnimatedExplosion ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_FLAME) {
                        return this.ofAnimatedFlame ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_SMOKE) {
                        return this.ofAnimatedSmoke ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.VOID_PARTICLES) {
                        return this.ofVoidParticles ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.WATER_PARTICLES) {
                        return this.ofWaterParticles ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.PORTAL_PARTICLES) {
                        return this.ofPortalParticles ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.POTION_PARTICLES) {
                        return this.ofPotionParticles ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.FIREWORK_PARTICLES) {
                        return this.ofFireworkParticles ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.DRIPPING_WATER_LAVA) {
                        return this.ofDrippingWaterLava ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_TERRAIN) {
                        return this.ofAnimatedTerrain ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ANIMATED_TEXTURES) {
                        return this.ofAnimatedTextures ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.RAIN_SPLASH) {
                        return this.ofRainSplash ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.LAGOMETER) {
                        return this.ofLagometer ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.SHOW_FPS) {
                        return this.ofShowFps ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                    }
                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.AUTOSAVE_TICKS) {
                        if (this.ofAutoSaveTicks <= 40) {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.save.default");
                        }
                        if (this.ofAutoSaveTicks <= 400) {
                            return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.save.20s");
                        }
                        return (this.ofAutoSaveTicks <= 4000) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.save.3min")) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.save.30min"));
                    }
                    else if (lllllllllllIlIlIlllllllIlllllIIl == Options.BETTER_GRASS) {
                        switch (this.ofBetterGrass) {
                            case 1: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                            }
                            case 2: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                            }
                            default: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                            }
                        }
                    }
                    else if (lllllllllllIlIlIlllllllIlllllIIl == Options.CONNECTED_TEXTURES) {
                        switch (this.ofConnectedTextures) {
                            case 1: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                            }
                            case 2: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                            }
                            default: {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff();
                            }
                        }
                    }
                    else {
                        if (lllllllllllIlIlIlllllllIlllllIIl == Options.WEATHER) {
                            return this.ofWeather ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                        }
                        if (lllllllllllIlIlIlllllllIlllllIIl == Options.SKY) {
                            return this.ofSky ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                        }
                        if (lllllllllllIlIlIlllllllIlllllIIl == Options.STARS) {
                            return this.ofStars ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                        }
                        if (lllllllllllIlIlIlllllllIlllllIIl == Options.SUN_MOON) {
                            return this.ofSunMoon ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                        }
                        if (lllllllllllIlIlIlllllllIlllllIIl == Options.VIGNETTE) {
                            switch (this.ofVignette) {
                                case 1: {
                                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                                }
                                case 2: {
                                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy();
                                }
                                default: {
                                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault();
                                }
                            }
                        }
                        else {
                            if (lllllllllllIlIlIlllllllIlllllIIl == Options.CHUNK_UPDATES) {
                                return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofChunkUpdates;
                            }
                            if (lllllllllllIlIlIlllllllIlllllIIl == Options.CHUNK_UPDATES_DYNAMIC) {
                                return this.ofChunkUpdatesDynamic ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                            }
                            if (lllllllllllIlIlIlllllllIlllllIIl == Options.TIME) {
                                if (this.ofTime == 1) {
                                    return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.time.dayOnly");
                                }
                                return (this.ofTime == 2) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.time.nightOnly")) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault());
                            }
                            else {
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CLEAR_WATER) {
                                    return this.ofClearWater ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.AA_LEVEL) {
                                    String lllllllllllIlIlIlllllllIllllIIlI = "";
                                    if (this.ofAaLevel != Config.getAntialiasingLevel()) {
                                        lllllllllllIlIlIlllllllIllllIIlI = " (" + Lang.get("of.general.restart") + ")";
                                    }
                                    return (this.ofAaLevel == 0) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff() + lllllllllllIlIlIlllllllIllllIIlI) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofAaLevel + lllllllllllIlIlIlllllllIllllIIlI);
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.AF_LEVEL) {
                                    return (this.ofAfLevel == 1) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofAfLevel);
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.PROFILER) {
                                    return this.ofProfiler ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.BETTER_SNOW) {
                                    return this.ofBetterSnow ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.SWAMP_COLORS) {
                                    return this.ofSwampColors ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.RANDOM_MOBS) {
                                    return this.ofRandomMobs ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.SMOOTH_BIOMES) {
                                    return this.ofSmoothBiomes ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_FONTS) {
                                    return this.ofCustomFonts ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_COLORS) {
                                    return this.ofCustomColors ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_SKY) {
                                    return this.ofCustomSky ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.SHOW_CAPES) {
                                    return this.ofShowCapes ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_ITEMS) {
                                    return this.ofCustomItems ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.NATURAL_TEXTURES) {
                                    return this.ofNaturalTextures ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.FAST_MATH) {
                                    return this.ofFastMath ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.FAST_RENDER) {
                                    return this.ofFastRender ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                }
                                if (lllllllllllIlIlIlllllllIlllllIIl == Options.TRANSLUCENT_BLOCKS) {
                                    if (this.ofTranslucentBlocks == 1) {
                                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFast();
                                    }
                                    return (this.ofTranslucentBlocks == 2) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getFancy()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault());
                                }
                                else {
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.LAZY_CHUNK_LOADING) {
                                        return this.ofLazyChunkLoading ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.DYNAMIC_FOV) {
                                        return this.ofDynamicFov ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ALTERNATE_BLOCKS) {
                                        return this.ofAlternateBlocks ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.DYNAMIC_LIGHTS) {
                                        final int lllllllllllIlIlIlllllllIllllIIIl = indexOf(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + getTranslation(GameSettings.KEYS_DYNAMIC_LIGHTS, lllllllllllIlIlIlllllllIllllIIIl);
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.SCREENSHOT_SIZE) {
                                        return (this.ofScreenshotSize <= 1) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofScreenshotSize + "x");
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_ENTITY_MODELS) {
                                        return this.ofCustomEntityModels ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.CUSTOM_GUIS) {
                                        return this.ofCustomGuis ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.FULLSCREEN_MODE) {
                                        return this.ofFullscreenMode.equals("Default") ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getDefault()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + this.ofFullscreenMode);
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.HELD_ITEM_TOOLTIPS) {
                                        return this.heldItemTooltips ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl == Options.ADVANCED_TOOLTIPS) {
                                        return this.advancedItemTooltips ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOn()) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.getOff());
                                    }
                                    if (lllllllllllIlIlIlllllllIlllllIIl != Options.FRAMERATE_LIMIT) {
                                        return null;
                                    }
                                    final float lllllllllllIlIlIlllllllIllllIIII = this.getOptionFloatValue(lllllllllllIlIlIlllllllIlllllIIl);
                                    if (lllllllllllIlIlIlllllllIllllIIII == 0.0f) {
                                        return String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + Lang.get("of.options.framerateLimit.vsync");
                                    }
                                    return (lllllllllllIlIlIlllllllIllllIIII == lllllllllllIlIlIlllllllIlllllIIl.valueMax) ? (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + I18n.format("options.framerateLimit.max", new Object[0])) : (String.valueOf(lllllllllllIlIlIlllllllIlllllIII) + (int)lllllllllllIlIlIlllllllIllllIIII + " fps");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static int limit(final int lllllllllllIlIlIlllllllIlIlIlIll, final int[] lllllllllllIlIlIlllllllIlIlIlIlI) {
        final int lllllllllllIlIlIlllllllIlIlIllII = indexOf(lllllllllllIlIlIlllllllIlIlIlIll, lllllllllllIlIlIlllllllIlIlIlIlI);
        return (lllllllllllIlIlIlllllllIlIlIllII < 0) ? lllllllllllIlIlIlllllllIlIlIlIlI[0] : lllllllllllIlIlIlllllllIlIlIlIll;
    }
    
    public void resetSettings() {
        this.renderDistanceChunks = 8;
        this.viewBobbing = true;
        this.anaglyph = false;
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.enableVsync = false;
        this.updateVSync();
        this.mipmapLevels = 4;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.clouds = 2;
        this.fovSetting = 70.0f;
        this.gammaSetting = 0.0f;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.heldItemTooltips = true;
        this.useVbo = false;
        this.forceUnicodeFont = false;
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        Config.updateAvailableProcessors();
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofScreenshotSize = 1;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofShowFps = false;
        this.ofProfiler = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomItems = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofNaturalTextures = false;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        Shaders.setShaderPack(Shaders.packNameNone);
        Shaders.configAntialiasingLevel = 0;
        Shaders.uninit();
        Shaders.storeConfig();
        this.updateWaterOpacity();
        this.mc.refreshResources();
        this.saveOptions();
    }
    
    private void updateRenderClouds() {
        switch (this.ofClouds) {
            case 1: {
                this.clouds = 1;
                break;
            }
            case 2: {
                this.clouds = 2;
                break;
            }
            case 3: {
                this.clouds = 0;
                break;
            }
            default: {
                if (this.fancyGraphics) {
                    this.clouds = 2;
                    break;
                }
                this.clouds = 1;
                break;
            }
        }
    }
    
    private static String getTranslation(final String[] lllllllllllIlIlIllllllllllIIlIlI, int lllllllllllIlIlIllllllllllIIIlll) {
        if (lllllllllllIlIlIllllllllllIIIlll < 0 || lllllllllllIlIlIllllllllllIIIlll >= lllllllllllIlIlIllllllllllIIlIlI.length) {
            lllllllllllIlIlIllllllllllIIIlll = 0;
        }
        return I18n.format(lllllllllllIlIlIllllllllllIIlIlI[lllllllllllIlIlIllllllllllIIIlll], new Object[0]);
    }
    
    public void saveOfOptions() {
        try {
            final PrintWriter lllllllllllIlIlIlllllllIllIlIIll = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.optionsFileOF), StandardCharsets.UTF_8));
            lllllllllllIlIlIlllllllIllIlIIll.println("ofRenderDistanceChunks:" + this.renderDistanceChunks);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFogType:" + this.ofFogType);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFogStart:" + this.ofFogStart);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofMipmapType:" + this.ofMipmapType);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofOcclusionFancy:" + this.ofOcclusionFancy);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSmoothFps:" + this.ofSmoothFps);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSmoothWorld:" + this.ofSmoothWorld);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAoLevel:" + this.ofAoLevel);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofClouds:" + this.ofClouds);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCloudsHeight:" + this.ofCloudsHeight);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofTrees:" + this.ofTrees);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofDroppedItems:" + this.ofDroppedItems);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofRain:" + this.ofRain);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedWater:" + this.ofAnimatedWater);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedLava:" + this.ofAnimatedLava);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedFire:" + this.ofAnimatedFire);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedPortal:" + this.ofAnimatedPortal);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedFlame:" + this.ofAnimatedFlame);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofVoidParticles:" + this.ofVoidParticles);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofWaterParticles:" + this.ofWaterParticles);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofPortalParticles:" + this.ofPortalParticles);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofPotionParticles:" + this.ofPotionParticles);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFireworkParticles:" + this.ofFireworkParticles);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAnimatedTextures:" + this.ofAnimatedTextures);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofRainSplash:" + this.ofRainSplash);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofLagometer:" + this.ofLagometer);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofShowFps:" + this.ofShowFps);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofBetterGrass:" + this.ofBetterGrass);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofConnectedTextures:" + this.ofConnectedTextures);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofWeather:" + this.ofWeather);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSky:" + this.ofSky);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofStars:" + this.ofStars);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSunMoon:" + this.ofSunMoon);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofVignette:" + this.ofVignette);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofChunkUpdates:" + this.ofChunkUpdates);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofTime:" + this.ofTime);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofClearWater:" + this.ofClearWater);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAaLevel:" + this.ofAaLevel);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAfLevel:" + this.ofAfLevel);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofProfiler:" + this.ofProfiler);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofBetterSnow:" + this.ofBetterSnow);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSwampColors:" + this.ofSwampColors);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofRandomMobs:" + this.ofRandomMobs);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofSmoothBiomes:" + this.ofSmoothBiomes);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomFonts:" + this.ofCustomFonts);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomColors:" + this.ofCustomColors);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomItems:" + this.ofCustomItems);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomSky:" + this.ofCustomSky);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofShowCapes:" + this.ofShowCapes);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofNaturalTextures:" + this.ofNaturalTextures);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofLazyChunkLoading:" + this.ofLazyChunkLoading);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofDynamicFov:" + this.ofDynamicFov);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofAlternateBlocks:" + this.ofAlternateBlocks);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofDynamicLights:" + this.ofDynamicLights);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofScreenshotSize:" + this.ofScreenshotSize);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomEntityModels:" + this.ofCustomEntityModels);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofCustomGuis:" + this.ofCustomGuis);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFullscreenMode:" + this.ofFullscreenMode);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFastMath:" + this.ofFastMath);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofFastRender:" + this.ofFastRender);
            lllllllllllIlIlIlllllllIllIlIIll.println("ofTranslucentBlocks:" + this.ofTranslucentBlocks);
            lllllllllllIlIlIlllllllIllIlIIll.println("key_" + this.ofKeyBindZoom.getKeyDescription() + ":" + this.ofKeyBindZoom.getKeyCode());
            lllllllllllIlIlIlllllllIllIlIIll.close();
        }
        catch (Exception lllllllllllIlIlIlllllllIllIlIIlI) {
            Config.warn("Failed to save options");
            lllllllllllIlIlIlllllllIllIlIIlI.printStackTrace();
        }
    }
    
    public void setAllAnimations(final boolean lllllllllllIlIlIlllllllIlIllllll) {
        final int lllllllllllIlIlIlllllllIlIlllllI = lllllllllllIlIlIlllllllIlIllllll ? 0 : 2;
        this.ofAnimatedWater = lllllllllllIlIlIlllllllIlIlllllI;
        this.ofAnimatedLava = lllllllllllIlIlIlllllllIlIlllllI;
        this.ofAnimatedFire = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedPortal = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedRedstone = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedExplosion = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedFlame = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedSmoke = lllllllllllIlIlIlllllllIlIllllll;
        this.ofVoidParticles = lllllllllllIlIlIlllllllIlIllllll;
        this.ofWaterParticles = lllllllllllIlIlIlllllllIlIllllll;
        this.ofRainSplash = lllllllllllIlIlIlllllllIlIllllll;
        this.ofPortalParticles = lllllllllllIlIlIlllllllIlIllllll;
        this.ofPotionParticles = lllllllllllIlIlIlllllllIlIllllll;
        this.ofFireworkParticles = lllllllllllIlIlIlllllllIlIllllll;
        this.particleSetting = (lllllllllllIlIlIlllllllIlIllllll ? 0 : 2);
        this.ofDrippingWaterLava = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedTerrain = lllllllllllIlIlIlllllllIlIllllll;
        this.ofAnimatedTextures = lllllllllllIlIlIlllllllIlIllllll;
    }
    
    public void setSoundLevel(final SoundCategory lllllllllllIlIlIllllllllIlIlIIII, final float lllllllllllIlIlIllllllllIlIlIIlI) {
        this.mc.getSoundHandler().setSoundLevel(lllllllllllIlIlIllllllllIlIlIIII, lllllllllllIlIlIllllllllIlIlIIlI);
        this.soundLevels.put(lllllllllllIlIlIllllllllIlIlIIII, lllllllllllIlIlIllllllllIlIlIIlI);
    }
    
    public void switchModelPartEnabled(final EnumPlayerModelParts lllllllllllIlIlIllllllllIIllIIlI) {
        if (this.getModelParts().contains(lllllllllllIlIlIllllllllIIllIIlI)) {
            this.setModelParts.remove(lllllllllllIlIlIllllllllIIllIIlI);
        }
        else {
            this.setModelParts.add(lllllllllllIlIlIllllllllIIllIIlI);
        }
        this.sendSettingsToServer();
    }
    
    public enum Options
    {
        ANIMATED_EXPLOSION("ANIMATED_EXPLOSION", 58, "of.options.ANIMATED_EXPLOSION", false, false), 
        CONNECTED_TEXTURES("CONNECTED_TEXTURES", 88, "of.options.CONNECTED_TEXTURES", false, false), 
        VIGNETTE("VIGNETTE", 65, "of.options.VIGNETTE", false, false), 
        FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 0.0f, 260.0f, 5.0f), 
        BETTER_GRASS("BETTER_GRASS", 56, "of.options.BETTER_GRASS", false, false);
        
        private final /* synthetic */ boolean enumFloat;
        
        TREES("TREES", 46, "of.options.TREES", false, false), 
        FIREWORK_PARTICLES("FIREWORK_PARTICLES", 76, "of.options.FIREWORK_PARTICLES", false, false), 
        CUSTOM_FONTS("CUSTOM_FONTS", 85, "of.options.CUSTOM_FONTS", false, false), 
        SCREENSHOT_SIZE("SCREENSHOT_SIZE", 106, "of.options.SCREENSHOT_SIZE", false, false), 
        ATTACK_INDICATOR("ATTACK_INDICATOR", 34, "options.attackIndicator", false, false), 
        POTION_PARTICLES("POTION_PARTICLES", 75, "of.options.POTION_PARTICLES", false, false), 
        FAST_MATH("FAST_MATH", 98, "of.options.FAST_MATH", false, false), 
        ANIMATED_WATER("ANIMATED_WATER", 48, "of.options.ANIMATED_WATER", false, false), 
        CHAT_WIDTH("CHAT_WIDTH", 26, "options.chat.width", true, false), 
        FOG_START("FOG_START", 41, "of.options.FOG_START", false, false), 
        ANIMATED_PORTAL("ANIMATED_PORTAL", 51, "of.options.ANIMATED_PORTAL", false, false), 
        VOID_PARTICLES("VOID_PARTICLES", 71, "of.options.VOID_PARTICLES", false, false), 
        GAMMA("GAMMA", 3, "options.gamma", true, false), 
        ALTERNATE_BLOCKS("ALTERNATE_BLOCKS", 103, "of.options.ALTERNATE_BLOCKS", false, false), 
        ANAGLYPH("ANAGLYPH", 7, "options.anaglyph", false, true), 
        CUSTOM_ITEMS("CUSTOM_ITEMS", 89, "of.options.CUSTOM_ITEMS", false, false), 
        PROFILER("PROFILER", 77, "of.options.PROFILER", false, false), 
        TRANSLUCENT_BLOCKS("TRANSLUCENT_BLOCKS", 100, "of.options.TRANSLUCENT_BLOCKS", false, false);
        
        private final /* synthetic */ float valueStep;
        
        CHAT_OPACITY("CHAT_OPACITY", 18, "options.chat.opacity", true, false), 
        AUTOSAVE_TICKS("AUTOSAVE_TICKS", 55, "of.options.AUTOSAVE_TICKS", false, false);
        
        private /* synthetic */ float valueMax;
        
        GUI_SCALE("GUI_SCALE", 13, "options.guiScale", false, false), 
        CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false), 
        ADVANCED_TOOLTIPS("ADVANCED_TOOLTIPS", 105, "of.options.ADVANCED_TOOLTIPS", false, false), 
        FOV("FOV", 2, "options.fov", true, false, 30.0f, 110.0f, 1.0f), 
        NATURAL_TEXTURES("NATURAL_TEXTURES", 93, "of.options.NATURAL_TEXTURES", false, false), 
        RANDOM_MOBS("RANDOM_MOBS", 83, "of.options.RANDOM_MOBS", false, false), 
        FULLSCREEN_MODE("FULLSCREEN_MODE", 80, "of.options.FULLSCREEN_MODE", true, false, 0.0f, (float)Config.getDisplayModes().length, 1.0f), 
        FAST_RENDER("FAST_RENDER", 99, "of.options.FAST_RENDER", false, false), 
        FOG_FANCY("FOG_FANCY", 40, "of.options.FOG_FANCY", false, false), 
        LAZY_CHUNK_LOADING("LAZY_CHUNK_LOADING", 96, "of.options.LAZY_CHUNK_LOADING", false, false), 
        PARTICLES("PARTICLES", 14, "options.particles", false, false), 
        CUSTOM_SKY("CUSTOM_SKY", 97, "of.options.CUSTOM_SKY", false, false), 
        REALMS_NOTIFICATIONS("REALMS_NOTIFICATIONS", 37, "options.realmsNotifications", false, true), 
        ANIMATED_TERRAIN("ANIMATED_TERRAIN", 81, "of.options.ANIMATED_TERRAIN", false, false), 
        CHUNK_UPDATES_DYNAMIC("CHUNK_UPDATES_DYNAMIC", 67, "of.options.CHUNK_UPDATES_DYNAMIC", false, false), 
        RENDER_DISTANCE("RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0f, 16.0f, 1.0f), 
        WATER_PARTICLES("WATER_PARTICLES", 72, "of.options.WATER_PARTICLES", false, false), 
        SENSITIVITY("SENSITIVITY", 1, "options.sensitivity", true, false), 
        TOUCHSCREEN("TOUCHSCREEN", 24, "options.touchscreen", false, true), 
        SMOOTH_FPS("SMOOTH_FPS", 43, "of.options.SMOOTH_FPS", false, false), 
        CUSTOM_COLORS("CUSTOM_COLORS", 86, "of.options.CUSTOM_COLORS", false, false), 
        ANIMATED_SMOKE("ANIMATED_SMOKE", 60, "of.options.ANIMATED_SMOKE", false, false), 
        ANIMATED_TEXTURES("ANIMATED_TEXTURES", 92, "of.options.ANIMATED_TEXTURES", false, false), 
        SWAMP_COLORS("SWAMP_COLORS", 82, "of.options.SWAMP_COLORS", false, false), 
        ANIMATED_REDSTONE("ANIMATED_REDSTONE", 57, "of.options.ANIMATED_REDSTONE", false, false), 
        BETTER_SNOW("BETTER_SNOW", 79, "of.options.BETTER_SNOW", false, false), 
        MAIN_HAND("MAIN_HAND", 33, "options.mainHand", false, false), 
        ENABLE_WEAK_ATTACKS("ENABLE_WEAK_ATTACKS", 35, "options.enableWeakAttacks", false, true), 
        LAGOMETER("LAGOMETER", 53, "of.options.LAGOMETER", false, false), 
        SKY("SKY", 62, "of.options.SKY", false, false), 
        RAIN("RAIN", 47, "of.options.RAIN", false, false), 
        MIPMAP_TYPE("MIPMAP_TYPE", 42, "of.options.MIPMAP_TYPE", true, false, 0.0f, 3.0f, 1.0f), 
        SMOOTH_BIOMES("SMOOTH_BIOMES", 84, "of.options.SMOOTH_BIOMES", false, false), 
        ANIMATED_LAVA("ANIMATED_LAVA", 49, "of.options.ANIMATED_LAVA", false, false), 
        CHAT_COLOR("CHAT_COLOR", 16, "options.chat.color", false, true), 
        AA_LEVEL("AA_LEVEL", 90, "of.options.AA_LEVEL", true, false, 0.0f, 16.0f, 1.0f), 
        DROPPED_ITEMS("DROPPED_ITEMS", 95, "of.options.DROPPED_ITEMS", false, false), 
        ANIMATED_FIRE("ANIMATED_FIRE", 50, "of.options.ANIMATED_FIRE", false, false), 
        CHAT_SCALE("CHAT_SCALE", 25, "options.chat.scale", true, false), 
        ENABLE_VSYNC("ENABLE_VSYNC", 22, "options.vsync", false, true);
        
        private /* synthetic */ float valueMin;
        
        RENDER_CLOUDS("RENDER_CLOUDS", 10, "options.renderClouds", false, false), 
        HELD_ITEM_TOOLTIPS("HELD_ITEM_TOOLTIPS", 94, "of.options.HELD_ITEM_TOOLTIPS", false, false), 
        AO_LEVEL("AO_LEVEL", 52, "of.options.AO_LEVEL", true, false), 
        FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true), 
        AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "options.ao", false, false), 
        PORTAL_PARTICLES("PORTAL_PARTICLES", 74, "of.options.PORTAL_PARTICLES", false, false), 
        USE_FULLSCREEN("USE_FULLSCREEN", 21, "options.fullscreen", false, true), 
        DRIPPING_WATER_LAVA("DRIPPING_WATER_LAVA", 78, "of.options.DRIPPING_WATER_LAVA", false, false), 
        CUSTOM_ENTITY_MODELS("CUSTOM_ENTITY_MODELS", 104, "of.options.CUSTOM_ENTITY_MODELS", false, false), 
        SHOW_CAPES("SHOW_CAPES", 87, "of.options.SHOW_CAPES", false, false), 
        SATURATION("SATURATION", 4, "options.saturation", true, false), 
        INVERT_MOUSE("INVERT_MOUSE", 0, "options.invertMouse", false, true), 
        TIME("TIME", 68, "of.options.TIME", false, false), 
        CLEAR_WATER("CLEAR_WATER", 69, "of.options.CLEAR_WATER", false, false), 
        CHUNK_UPDATES("CHUNK_UPDATES", 66, "of.options.CHUNK_UPDATES", false, false), 
        GRAPHICS("GRAPHICS", 11, "options.graphics", false, false), 
        ANIMATED_FLAME("ANIMATED_FLAME", 59, "of.options.ANIMATED_FLAME", false, false), 
        SHOW_FPS("SHOW_FPS", 54, "of.options.SHOW_FPS", false, false), 
        WEATHER("WEATHER", 61, "of.options.WEATHER", false, false), 
        CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "options.chat.visibility", false, false), 
        SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "options.snooper", false, true), 
        VIEW_BOBBING("VIEW_BOBBING", 6, "options.viewBobbing", false, true), 
        CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true), 
        AUTO_JUMP("AUTO_JUMP", 38, "options.autoJump", false, true), 
        FBO_ENABLE("FBO_ENABLE", 9, "options.fboEnable", false, true), 
        CUSTOM_GUIS("CUSTOM_GUIS", 107, "of.options.CUSTOM_GUIS", false, false), 
        CLOUD_HEIGHT("CLOUD_HEIGHT", 45, "of.options.CLOUD_HEIGHT", true, false), 
        REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 31, "options.reducedDebugInfo", false, true), 
        SMOOTH_WORLD("SMOOTH_WORLD", 70, "of.options.SMOOTH_WORLD", false, false), 
        CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false), 
        NARRATOR("NARRATOR", 39, "options.narrator", false, false), 
        ENTITY_SHADOWS("ENTITY_SHADOWS", 32, "options.entityShadows", false, true), 
        CHAT_LINKS("CHAT_LINKS", 17, "options.chat.links", false, true), 
        CLOUDS("CLOUDS", 44, "of.options.CLOUDS", false, false);
        
        private final /* synthetic */ String enumString;
        
        RAIN_SPLASH("RAIN_SPLASH", 73, "of.options.RAIN_SPLASH", false, false), 
        DYNAMIC_LIGHTS("DYNAMIC_LIGHTS", 102, "of.options.DYNAMIC_LIGHTS", false, false), 
        USE_VBO("USE_VBO", 23, "options.vbo", false, true), 
        STARS("STARS", 63, "of.options.STARS", false, false), 
        DYNAMIC_FOV("DYNAMIC_FOV", 101, "of.options.DYNAMIC_FOV", false, false);
        
        private final /* synthetic */ boolean enumBoolean;
        
        SHOW_SUBTITLES("SHOW_SUBTITLES", 36, "options.showSubtitles", false, true), 
        MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0f, 4.0f, 1.0f), 
        AF_LEVEL("AF_LEVEL", 91, "of.options.AF_LEVEL", true, false, 1.0f, 16.0f, 1.0f), 
        SUN_MOON("SUN_MOON", 64, "of.options.SUN_MOON", false, false);
        
        public void setValueMax(final float llllllllllllllIIIllIIlIIIlIlllIl) {
            this.valueMax = llllllllllllllIIIllIIlIIIlIlllIl;
        }
        
        private Options(final String llllllllllllllIIIllIIlIIlIIlIIII, final int llllllllllllllIIIllIIlIIlIIIllll, final String llllllllllllllIIIllIIlIIlIIlIlII, final boolean llllllllllllllIIIllIIlIIlIIlIIll, final boolean llllllllllllllIIIllIIlIIlIIIllII) {
            this(llllllllllllllIIIllIIlIIlIIlIIII, llllllllllllllIIIllIIlIIlIIIllll, llllllllllllllIIIllIIlIIlIIlIlII, llllllllllllllIIIllIIlIIlIIlIIll, llllllllllllllIIIllIIlIIlIIIllII, 0.0f, 1.0f, 0.0f);
        }
        
        public String getEnumString() {
            return this.enumString;
        }
        
        public float getValueMax() {
            return this.valueMax;
        }
        
        private Options(final String llllllllllllllIIIllIIlIIIllllIlI, final int llllllllllllllIIIllIIlIIIllllIIl, final String llllllllllllllIIIllIIlIIlIIIIIIl, final boolean llllllllllllllIIIllIIlIIlIIIIIII, final boolean llllllllllllllIIIllIIlIIIlllIllI, final float llllllllllllllIIIllIIlIIIllllllI, final float llllllllllllllIIIllIIlIIIlllIlII, final float llllllllllllllIIIllIIlIIIlllllII) {
            this.enumString = llllllllllllllIIIllIIlIIlIIIIIIl;
            this.enumFloat = llllllllllllllIIIllIIlIIlIIIIIII;
            this.enumBoolean = llllllllllllllIIIllIIlIIIlllIllI;
            this.valueMin = llllllllllllllIIIllIIlIIIllllllI;
            this.valueMax = llllllllllllllIIIllIIlIIIlllIlII;
            this.valueStep = llllllllllllllIIIllIIlIIIlllllII;
        }
        
        public int returnEnumOrdinal() {
            return this.ordinal();
        }
        
        private float snapToStep(float llllllllllllllIIIllIIlIIIlIIIIll) {
            if (this.valueStep > 0.0f) {
                llllllllllllllIIIllIIlIIIlIIIIll = this.valueStep * Math.round(llllllllllllllIIIllIIlIIIlIIIIll / this.valueStep);
            }
            return llllllllllllllIIIllIIlIIIlIIIIll;
        }
        
        public boolean getEnumBoolean() {
            return this.enumBoolean;
        }
        
        public float snapToStepClamp(float llllllllllllllIIIllIIlIIIlIIlIIl) {
            llllllllllllllIIIllIIlIIIlIIlIIl = (byte)this.snapToStep(llllllllllllllIIIllIIlIIIlIIlIIl);
            return MathHelper.clamp(llllllllllllllIIIllIIlIIIlIIlIIl, this.valueMin, this.valueMax);
        }
        
        public float getValueMin() {
            return this.valueMin;
        }
        
        public boolean getEnumFloat() {
            return this.enumFloat;
        }
        
        public float denormalizeValue(final float llllllllllllllIIIllIIlIIIlIlIIIl) {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp(llllllllllllllIIIllIIlIIIlIlIIIl, 0.0f, 1.0f));
        }
        
        public float normalizeValue(final float llllllllllllllIIIllIIlIIIlIlIlll) {
            return MathHelper.clamp((this.snapToStepClamp(llllllllllllllIIIllIIlIIIlIlIlll) - this.valueMin) / (this.valueMax - this.valueMin), 0.0f, 1.0f);
        }
        
        public static Options getEnumOptions(final int llllllllllllllIIIllIIlIIlIlIIIlI) {
            final long llllllllllllllIIIllIIlIIlIIlllII;
            final double llllllllllllllIIIllIIlIIlIIlllIl = ((Options[])(Object)(llllllllllllllIIIllIIlIIlIIlllII = (long)(Object)values())).length;
            for (Exception llllllllllllllIIIllIIlIIlIIllllI = (Exception)0; llllllllllllllIIIllIIlIIlIIllllI < llllllllllllllIIIllIIlIIlIIlllIl; ++llllllllllllllIIIllIIlIIlIIllllI) {
                final Options llllllllllllllIIIllIIlIIlIlIIIIl = llllllllllllllIIIllIIlIIlIIlllII[llllllllllllllIIIllIIlIIlIIllllI];
                if (llllllllllllllIIIllIIlIIlIlIIIIl.returnEnumOrdinal() == llllllllllllllIIIllIIlIIlIlIIIlI) {
                    return llllllllllllllIIIllIIlIIlIlIIIIl;
                }
            }
            return null;
        }
    }
}
