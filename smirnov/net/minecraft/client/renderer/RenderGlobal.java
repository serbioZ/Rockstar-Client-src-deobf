// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.world.border.WorldBorder;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import net.minecraft.client.renderer.chunk.VboChunkFactory;
import net.minecraft.client.renderer.chunk.ListChunkFactory;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldProvider;
import optifine.CustomSky;
import optifine.CustomColors;
import net.minecraft.world.DimensionType;
import optifine.RandomMobs;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import org.lwjgl.util.vector.Vector3f;
import com.google.common.collect.Sets;
import optifine.ChunkUtils;
import shadersmod.client.ShadowUtils;
import optifine.RenderInfoLazy;
import optifine.Lagometer;
import net.minecraft.client.renderer.culling.Frustum;
import optifine.DynamicLights;
import net.minecraft.client.particle.Particle;
import java.util.Random;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemDye;
import net.minecraft.init.Items;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.item.ItemRecord;
import javax.annotation.Nullable;
import net.minecraft.util.SoundEvent;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import net.minecraft.util.EnumFacing;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import shadersmod.client.ShadersRender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.culling.ICamera;
import java.util.Iterator;
import optifine.Reflector;
import shadersmod.client.Shaders;
import org.lwjgl.input.Keyboard;
import optifine.Config;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.shader.ShaderGroup;
import optifine.CloudRenderer;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.math.BlockPos;
import java.util.Map;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.chunk.Chunk;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.client.renderer.culling.ClippingHelper;
import org.apache.logging.log4j.Logger;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.util.vector.Vector4f;
import net.minecraft.entity.Entity;
import optifine.RenderEnv;
import net.minecraft.client.renderer.chunk.RenderChunk;
import java.util.Set;
import java.util.Deque;
import net.minecraft.client.multiplayer.WorldClient;
import java.util.List;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class RenderGlobal implements IResourceManagerReloadListener, IWorldEventListener
{
    private static final /* synthetic */ ResourceLocation FORCEFIELD_TEXTURES;
    private /* synthetic */ VertexBuffer skyVBO;
    private /* synthetic */ ChunkRenderDispatcher renderDispatcher;
    private /* synthetic */ ViewFrustum viewFrustum;
    private final /* synthetic */ TextureAtlasSprite[] destroyBlockIcons;
    private /* synthetic */ int countLoadedChunksPrev;
    public final /* synthetic */ Minecraft mc;
    private /* synthetic */ IChunkProvider worldChunkProvider;
    private /* synthetic */ int renderDistance;
    private /* synthetic */ Framebuffer entityOutlineFramebuffer;
    /* synthetic */ IRenderChunkFactory renderChunkFactory;
    private /* synthetic */ List<ContainerLocalRenderInformation> renderInfos;
    private /* synthetic */ WorldClient theWorld;
    static /* synthetic */ Deque<ContainerLocalRenderInformation> renderInfoCache;
    private /* synthetic */ Set<RenderChunk> chunksToUpdate;
    private /* synthetic */ RenderEnv renderEnv;
    public /* synthetic */ Entity renderedEntity;
    private /* synthetic */ boolean entityOutlinesRendered;
    private /* synthetic */ double prevRenderSortX;
    private /* synthetic */ int renderDistanceChunks;
    private final /* synthetic */ Vector4f[] debugTerrainMatrix;
    private static final /* synthetic */ ResourceLocation END_SKY_TEXTURES;
    private /* synthetic */ double frustumUpdatePosZ;
    private /* synthetic */ int renderEntitiesStartupCounter;
    private /* synthetic */ int glSkyList;
    private /* synthetic */ ChunkRenderContainer renderContainer;
    private static final /* synthetic */ ResourceLocation MOON_PHASES_TEXTURES;
    private final /* synthetic */ Set<TileEntity> setTileEntities;
    private /* synthetic */ int frustumUpdatePosChunkX;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ double prevRenderSortY;
    private /* synthetic */ ClippingHelper debugFixedClippingHelper;
    private /* synthetic */ Long2ObjectMap<Chunk> worldChunkProviderMap;
    private /* synthetic */ int countEntitiesRendered;
    public /* synthetic */ boolean displayListEntitiesDirty;
    private /* synthetic */ boolean vboEnabled;
    private /* synthetic */ int countTileEntitiesRendered;
    private /* synthetic */ List renderInfosNormal;
    private final /* synthetic */ RenderManager renderManager;
    private /* synthetic */ int frustumUpdatePosChunkY;
    private final /* synthetic */ Vector3d debugTerrainFrustumPosition;
    private /* synthetic */ int glSkyList2;
    private static final /* synthetic */ ResourceLocation SUN_TEXTURES;
    private /* synthetic */ int starGLCallList;
    private static final /* synthetic */ Set SET_ALL_FACINGS;
    private final /* synthetic */ Map<BlockPos, ISound> mapSoundPositions;
    private /* synthetic */ CloudRenderer cloudRenderer;
    public /* synthetic */ Set chunksToResortTransparency;
    public final /* synthetic */ Map<Integer, DestroyBlockProgress> damagedBlocks;
    private /* synthetic */ double lastViewEntityY;
    private /* synthetic */ List renderInfosShadow;
    private /* synthetic */ double lastViewEntityPitch;
    private /* synthetic */ ShaderGroup entityOutlineShader;
    private /* synthetic */ double frustumUpdatePosX;
    private /* synthetic */ double prevRenderSortZ;
    private final /* synthetic */ VertexFormat vertexBufferFormat;
    public /* synthetic */ boolean renderOverlayDamaged;
    private /* synthetic */ double lastViewEntityZ;
    private /* synthetic */ int countEntitiesTotal;
    public /* synthetic */ boolean renderOverlayEyes;
    private static final /* synthetic */ ResourceLocation CLOUDS_TEXTURES;
    private /* synthetic */ double lastViewEntityYaw;
    private /* synthetic */ List renderInfosTileEntitiesNormal;
    private /* synthetic */ List renderInfosTileEntities;
    private /* synthetic */ double frustumUpdatePosY;
    private /* synthetic */ List renderInfosEntities;
    private /* synthetic */ int renderDistanceSq;
    private /* synthetic */ List renderInfosEntitiesNormal;
    private final /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ int cloudTickCounter;
    private /* synthetic */ VertexBuffer starVBO;
    public /* synthetic */ Set chunksToUpdateForced;
    private /* synthetic */ int frustumUpdatePosChunkZ;
    private final /* synthetic */ Set<BlockPos> setLightUpdates;
    private /* synthetic */ Deque visibilityDeque;
    private /* synthetic */ VertexBuffer sky2VBO;
    private /* synthetic */ boolean debugFixTerrainFrustum;
    private /* synthetic */ List renderInfosTileEntitiesShadow;
    private /* synthetic */ int countEntitiesHidden;
    private /* synthetic */ double lastViewEntityX;
    private /* synthetic */ List renderInfosEntitiesShadow;
    
    public void updateClouds() {
        if (Config.isShaders() && Keyboard.isKeyDown(61) && Keyboard.isKeyDown(19)) {
            Shaders.uninit();
            Shaders.loadShaderPack();
            Reflector.Minecraft_actionKeyF3.setValue((Object)this.mc, (Object)Boolean.TRUE);
        }
        ++this.cloudTickCounter;
        if (this.cloudTickCounter % 20 == 0) {
            this.cleanupDamagedBlocks(this.damagedBlocks.values().iterator());
        }
        if (!this.setLightUpdates.isEmpty() && !this.renderDispatcher.hasNoFreeRenderBuilders() && this.chunksToUpdate.isEmpty()) {
            final Iterator<BlockPos> lllllllllllIIIlllIIlIllllllllIII = this.setLightUpdates.iterator();
            while (lllllllllllIIIlllIIlIllllllllIII.hasNext()) {
                final BlockPos lllllllllllIIIlllIIlIlllllllIlll = lllllllllllIIIlllIIlIllllllllIII.next();
                lllllllllllIIIlllIIlIllllllllIII.remove();
                final int lllllllllllIIIlllIIlIlllllllIllI = lllllllllllIIIlllIIlIlllllllIlll.getX();
                final int lllllllllllIIIlllIIlIlllllllIlIl = lllllllllllIIIlllIIlIlllllllIlll.getY();
                final int lllllllllllIIIlllIIlIlllllllIlII = lllllllllllIIIlllIIlIlllllllIlll.getZ();
                this.markBlocksForUpdate(lllllllllllIIIlllIIlIlllllllIllI - 1, lllllllllllIIIlllIIlIlllllllIlIl - 1, lllllllllllIIIlllIIlIlllllllIlII - 1, lllllllllllIIIlllIIlIlllllllIllI + 1, lllllllllllIIIlllIIlIlllllllIlIl + 1, lllllllllllIIIlllIIlIlllllllIlII + 1, false);
            }
        }
    }
    
    private boolean isOutlineActive(final Entity lllllllllllIIIlllIIllIIlIIllIIll, final Entity lllllllllllIIIlllIIllIIlIIllIIlI, final ICamera lllllllllllIIIlllIIllIIlIIllIIIl) {
        final boolean lllllllllllIIIlllIIllIIlIIllIIII = lllllllllllIIIlllIIllIIlIIllIIlI instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllIIIlllIIllIIlIIllIIlI).isPlayerSleeping();
        return (lllllllllllIIIlllIIllIIlIIllIIll != lllllllllllIIIlllIIllIIlIIllIIlI || this.mc.gameSettings.thirdPersonView != 0 || lllllllllllIIIlllIIllIIlIIllIIII) && (lllllllllllIIIlllIIllIIlIIllIIll.isGlowing() || (this.mc.player.isSpectator() && this.mc.gameSettings.keyBindSpectatorOutlines.isKeyDown() && lllllllllllIIIlllIIllIIlIIllIIll instanceof EntityPlayer && (lllllllllllIIIlllIIllIIlIIllIIll.ignoreFrustumCheck || lllllllllllIIIlllIIllIIlIIllIIIl.isBoundingBoxInFrustum(lllllllllllIIIlllIIllIIlIIllIIll.getEntityBoundingBox()) || lllllllllllIIIlllIIllIIlIIllIIll.isRidingOrBeingRiddenBy(this.mc.player))));
    }
    
    public RenderChunk getRenderChunk(final BlockPos lllllllllllIIIlllIIlIIllIIIllIll) {
        return this.viewFrustum.getRenderChunk(lllllllllllIIIlllIIlIIllIIIllIll);
    }
    
    private void postRenderDamagedBlocks() {
        GlStateManager.disableAlpha();
        GlStateManager.doPolygonOffset(0.0f, 0.0f);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableAlpha();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
        if (Config.isShaders()) {
            ShadersRender.endBlockDamage();
        }
    }
    
    public static void drawBoundingBox(final double lllllllllllIIIlllIIlIlIllIlIIIIl, final double lllllllllllIIIlllIIlIlIllIIlllll, final double lllllllllllIIIlllIIlIlIllIIllllI, final double lllllllllllIIIlllIIlIlIllIlIlIll, final double lllllllllllIIIlllIIlIlIllIIlllII, final double lllllllllllIIIlllIIlIlIllIlIlIIl, final float lllllllllllIIIlllIIlIlIllIIllIlI, final float lllllllllllIIIlllIIlIlIllIlIIlll, final float lllllllllllIIIlllIIlIlIllIIllIII, final float lllllllllllIIIlllIIlIlIllIlIIlIl) {
        final Tessellator lllllllllllIIIlllIIlIlIllIlIIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIlIlIllIlIIIll = lllllllllllIIIlllIIlIlIllIlIIlII.getBuffer();
        lllllllllllIIIlllIIlIlIllIlIIIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        drawBoundingBox(lllllllllllIIIlllIIlIlIllIlIIIll, lllllllllllIIIlllIIlIlIllIlIIIIl, lllllllllllIIIlllIIlIlIllIIlllll, lllllllllllIIIlllIIlIlIllIIllllI, lllllllllllIIIlllIIlIlIllIlIlIll, lllllllllllIIIlllIIlIlIllIIlllII, lllllllllllIIIlllIIlIlIllIlIlIIl, lllllllllllIIIlllIIlIlIllIIllIlI, lllllllllllIIIlllIIlIlIllIlIIlll, lllllllllllIIIlllIIlIlIllIIllIII, lllllllllllIIIlllIIlIlIllIlIIlIl);
        lllllllllllIIIlllIIlIlIllIlIIlII.draw();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MOON_PHASES_TEXTURES = new ResourceLocation("textures/environment/moon_phases.png");
        SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
        CLOUDS_TEXTURES = new ResourceLocation("textures/environment/clouds.png");
        END_SKY_TEXTURES = new ResourceLocation("textures/environment/end_sky.png");
        FORCEFIELD_TEXTURES = new ResourceLocation("textures/misc/forcefield.png");
        SET_ALL_FACINGS = Collections.unmodifiableSet((Set<?>)new HashSet<Object>(Arrays.asList(EnumFacing.VALUES)));
        RenderGlobal.renderInfoCache = new ArrayDeque<ContainerLocalRenderInformation>();
    }
    
    @Override
    public void playRecord(@Nullable final SoundEvent lllllllllllIIIlllIIlIlIIllIlIIlI, final BlockPos lllllllllllIIIlllIIlIlIIllIlIIIl) {
        final ISound lllllllllllIIIlllIIlIlIIllIlIIII = this.mapSoundPositions.get(lllllllllllIIIlllIIlIlIIllIlIIIl);
        if (lllllllllllIIIlllIIlIlIIllIlIIII != null) {
            this.mc.getSoundHandler().stopSound(lllllllllllIIIlllIIlIlIIllIlIIII);
            this.mapSoundPositions.remove(lllllllllllIIIlllIIlIlIIllIlIIIl);
        }
        if (lllllllllllIIIlllIIlIlIIllIlIIlI != null) {
            final ItemRecord lllllllllllIIIlllIIlIlIIllIIllll = ItemRecord.getBySound(lllllllllllIIIlllIIlIlIIllIlIIlI);
            if (lllllllllllIIIlllIIlIlIIllIIllll != null) {
                this.mc.ingameGUI.setRecordPlayingMessage(lllllllllllIIIlllIIlIlIIllIIllll.getRecordNameLocal());
            }
            final ISound lllllllllllIIIlllIIlIlIIllIIlllI = PositionedSoundRecord.getRecordSoundRecord(lllllllllllIIIlllIIlIlIIllIlIIlI, (float)lllllllllllIIIlllIIlIlIIllIlIIIl.getX(), (float)lllllllllllIIIlllIIlIlIIllIlIIIl.getY(), (float)lllllllllllIIIlllIIlIlIIllIlIIIl.getZ());
            this.mapSoundPositions.put(lllllllllllIIIlllIIlIlIIllIlIIIl, lllllllllllIIIlllIIlIlIIllIIlllI);
            this.mc.getSoundHandler().playSound(lllllllllllIIIlllIIlIlIIllIIlllI);
        }
        this.func_193054_a(this.theWorld, lllllllllllIIIlllIIlIlIIllIlIIIl, lllllllllllIIIlllIIlIlIIllIlIIlI != null);
    }
    
    public void setDisplayListEntitiesDirty() {
        this.displayListEntitiesDirty = true;
    }
    
    public void createBindEntityOutlineFbs(final int lllllllllllIIIlllIIllIIllIlIlIIl, final int lllllllllllIIIlllIIllIIllIlIlIll) {
        if (OpenGlHelper.shadersSupported && this.entityOutlineShader != null) {
            this.entityOutlineShader.createBindFramebuffers(lllllllllllIIIlllIIllIIllIlIlIIl, lllllllllllIIIlllIIllIIllIlIlIll);
        }
    }
    
    public static void addChainedFilledBoxVertices(final BufferBuilder lllllllllllIIIlllIIlIlIlIIlIllII, final double lllllllllllIIIlllIIlIlIlIIllIllI, final double lllllllllllIIIlllIIlIlIlIIllIlIl, final double lllllllllllIIIlllIIlIlIlIIllIlII, final double lllllllllllIIIlllIIlIlIlIIlIIlll, final double lllllllllllIIIlllIIlIlIlIIlIIllI, final double lllllllllllIIIlllIIlIlIlIIllIIIl, final float lllllllllllIIIlllIIlIlIlIIllIIII, final float lllllllllllIIIlllIIlIlIlIIlIIIll, final float lllllllllllIIIlllIIlIlIlIIlIlllI, final float lllllllllllIIIlllIIlIlIlIIlIlIll) {
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIllIlIl, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIllIllI, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIlII).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
        lllllllllllIIIlllIIlIlIlIIlIllII.pos(lllllllllllIIIlllIIlIlIlIIlIIlll, lllllllllllIIIlllIIlIlIlIIlIIllI, lllllllllllIIIlllIIlIlIlIIllIIIl).color(lllllllllllIIIlllIIlIlIlIIllIIII, lllllllllllIIIlllIIlIlIlIIlIIIll, lllllllllllIIIlllIIlIlIlIIlIlllI, lllllllllllIIIlllIIlIlIlIIlIlIll).endVertex();
    }
    
    private void renderSky(final BufferBuilder lllllllllllIIIlllIIllIlIIIllIIlI, final float lllllllllllIIIlllIIllIlIIIlllIlI, final boolean lllllllllllIIIlllIIllIlIIIlllIIl) {
        final int lllllllllllIIIlllIIllIlIIIlllIII = 64;
        final int lllllllllllIIIlllIIllIlIIIllIlll = 6;
        lllllllllllIIIlllIIllIlIIIllIIlI.begin(7, DefaultVertexFormats.POSITION);
        for (int lllllllllllIIIlllIIllIlIIIllIllI = -384; lllllllllllIIIlllIIllIlIIIllIllI <= 384; lllllllllllIIIlllIIllIlIIIllIllI += 64) {
            for (int lllllllllllIIIlllIIllIlIIIllIlIl = -384; lllllllllllIIIlllIIllIlIIIllIlIl <= 384; lllllllllllIIIlllIIllIlIIIllIlIl += 64) {
                float lllllllllllIIIlllIIllIlIIIllIlII = (float)lllllllllllIIIlllIIllIlIIIllIllI;
                float lllllllllllIIIlllIIllIlIIIllIIll = (float)(lllllllllllIIIlllIIllIlIIIllIllI + 64);
                if (lllllllllllIIIlllIIllIlIIIlllIIl) {
                    lllllllllllIIIlllIIllIlIIIllIIll = (float)lllllllllllIIIlllIIllIlIIIllIllI;
                    lllllllllllIIIlllIIllIlIIIllIlII = (float)(lllllllllllIIIlllIIllIlIIIllIllI + 64);
                }
                lllllllllllIIIlllIIllIlIIIllIIlI.pos(lllllllllllIIIlllIIllIlIIIllIlII, lllllllllllIIIlllIIllIlIIIlllIlI, lllllllllllIIIlllIIllIlIIIllIlIl).endVertex();
                lllllllllllIIIlllIIllIlIIIllIIlI.pos(lllllllllllIIIlllIIllIlIIIllIIll, lllllllllllIIIlllIIllIlIIIlllIlI, lllllllllllIIIlllIIllIlIIIllIlIl).endVertex();
                lllllllllllIIIlllIIllIlIIIllIIlI.pos(lllllllllllIIIlllIIllIlIIIllIIll, lllllllllllIIIlllIIllIlIIIlllIlI, lllllllllllIIIlllIIllIlIIIllIlIl + 64).endVertex();
                lllllllllllIIIlllIIllIlIIIllIIlI.pos(lllllllllllIIIlllIIllIlIIIllIlII, lllllllllllIIIlllIIllIlIIIlllIlI, lllllllllllIIIlllIIllIlIIIllIlIl + 64).endVertex();
            }
        }
    }
    
    @Override
    public void playEvent(final EntityPlayer lllllllllllIIIlllIIlIIlllIlIIIIl, final int lllllllllllIIIlllIIlIIllIllIllII, final BlockPos lllllllllllIIIlllIIlIIlllIIlllll, final int lllllllllllIIIlllIIlIIllIllIlIlI) {
        final Random lllllllllllIIIlllIIlIIlllIIlllIl = this.theWorld.rand;
        switch (lllllllllllIIIlllIIlIIllIllIllII) {
            case 1000: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_DISPENSER_LAUNCH, SoundCategory.BLOCKS, 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 1.0f, 1.2f, false);
                break;
            }
            case 1004: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_FIREWORK_SHOOT, SoundCategory.NEUTRAL, 1.0f, 1.2f, false);
                break;
            }
            case 1005: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1006: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1007: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1008: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_FENCE_GATE_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1009: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.8f, false);
                break;
            }
            case 1010: {
                if (Item.getItemById(lllllllllllIIIlllIIlIIllIllIlIlI) instanceof ItemRecord) {
                    this.theWorld.playRecord(lllllllllllIIIlllIIlIIlllIIlllll, ((ItemRecord)Item.getItemById(lllllllllllIIIlllIIlIIllIllIlIlI)).getSound());
                    break;
                }
                this.theWorld.playRecord(lllllllllllIIIlllIIlIIlllIIlllll, null);
                break;
            }
            case 1011: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1012: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1013: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1014: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1015: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_GHAST_WARN, SoundCategory.HOSTILE, 10.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.HOSTILE, 10.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ENDERDRAGON_SHOOT, SoundCategory.HOSTILE, 10.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1018: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1019: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ZOMBIE_ATTACK_DOOR_WOOD, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1021: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1022: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1024: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1025: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_BAT_TAKEOFF, SoundCategory.NEUTRAL, 0.05f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1026: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ZOMBIE_INFECT, SoundCategory.HOSTILE, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1027: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.NEUTRAL, 2.0f, (lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() - lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1029: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1030: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1031: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 0.3f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1032: {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.BLOCK_PORTAL_TRAVEL, lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() * 0.4f + 0.8f));
                break;
            }
            case 1033: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_CHORUS_FLOWER_GROW, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1034: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1035: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1036: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1037: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                final int lllllllllllIIIlllIIlIIlllIIlllII = lllllllllllIIIlllIIlIIllIllIlIlI % 3 - 1;
                final int lllllllllllIIIlllIIlIIlllIIllIll = lllllllllllIIIlllIIlIIllIllIlIlI / 3 % 3 - 1;
                final double lllllllllllIIIlllIIlIIlllIIllIlI = lllllllllllIIIlllIIlIIlllIIlllll.getX() + lllllllllllIIIlllIIlIIlllIIlllII * 0.6 + 0.5;
                final double lllllllllllIIIlllIIlIIlllIIllIIl = lllllllllllIIIlllIIlIIlllIIlllll.getY() + 0.5;
                final double lllllllllllIIIlllIIlIIlllIIllIII = lllllllllllIIIlllIIlIIlllIIlllll.getZ() + lllllllllllIIIlllIIlIIlllIIllIll * 0.6 + 0.5;
                for (int lllllllllllIIIlllIIlIIlllIIlIlll = 0; lllllllllllIIIlllIIlIIlllIIlIlll < 10; ++lllllllllllIIIlllIIlIIlllIIlIlll) {
                    final double lllllllllllIIIlllIIlIIlllIIlIllI = lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 0.2 + 0.01;
                    final double lllllllllllIIIlllIIlIIlllIIlIlIl = lllllllllllIIIlllIIlIIlllIIllIlI + lllllllllllIIIlllIIlIIlllIIlllII * 0.01 + (lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() - 0.5) * lllllllllllIIIlllIIlIIlllIIllIll * 0.5;
                    final double lllllllllllIIIlllIIlIIlllIIlIlII = lllllllllllIIIlllIIlIIlllIIllIIl + (lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() - 0.5) * 0.5;
                    final double lllllllllllIIIlllIIlIIlllIIlIIll = lllllllllllIIIlllIIlIIlllIIllIII + lllllllllllIIIlllIIlIIlllIIllIll * 0.01 + (lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() - 0.5) * lllllllllllIIIlllIIlIIlllIIlllII * 0.5;
                    final double lllllllllllIIIlllIIlIIlllIIlIIlI = lllllllllllIIIlllIIlIIlllIIlllII * lllllllllllIIIlllIIlIIlllIIlIllI + lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.01;
                    final double lllllllllllIIIlllIIlIIlllIIlIIIl = -0.03 + lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.01;
                    final double lllllllllllIIIlllIIlIIlllIIlIIII = lllllllllllIIIlllIIlIIlllIIllIll * lllllllllllIIIlllIIlIIlllIIlIllI + lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.01;
                    this.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllIIIlllIIlIIlllIIlIlIl, lllllllllllIIIlllIIlIIlllIIlIlII, lllllllllllIIIlllIIlIIlllIIlIIll, lllllllllllIIIlllIIlIIlllIIlIIlI, lllllllllllIIIlllIIlIIlllIIlIIIl, lllllllllllIIIlllIIlIIlllIIlIIII, new int[0]);
                }
            }
            case 2001: {
                final Block lllllllllllIIIlllIIlIIlllIIIllll = Block.getBlockById(lllllllllllIIIlllIIlIIllIllIlIlI & 0xFFF);
                if (lllllllllllIIIlllIIlIIlllIIIllll.getDefaultState().getMaterial() != Material.AIR) {
                    SoundType lllllllllllIIIlllIIlIIlllIIIlllI = lllllllllllIIIlllIIlIIlllIIIllll.getSoundType();
                    if (Reflector.ForgeBlock_getSoundType.exists()) {
                        lllllllllllIIIlllIIlIIlllIIIlllI = (SoundType)Reflector.call((Object)lllllllllllIIIlllIIlIIlllIIIllll, Reflector.ForgeBlock_getSoundType, new Object[] { Block.getStateById(lllllllllllIIIlllIIlIIllIllIlIlI), this.theWorld, lllllllllllIIIlllIIlIIlllIIlllll, null });
                    }
                    this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, lllllllllllIIIlllIIlIIlllIIIlllI.getBreakSound(), SoundCategory.BLOCKS, (lllllllllllIIIlllIIlIIlllIIIlllI.getVolume() + 1.0f) / 2.0f, lllllllllllIIIlllIIlIIlllIIIlllI.getPitch() * 0.8f, false);
                }
                this.mc.effectRenderer.addBlockDestroyEffects(lllllllllllIIIlllIIlIIlllIIlllll, lllllllllllIIIlllIIlIIlllIIIllll.getStateFromMeta(lllllllllllIIIlllIIlIIllIllIlIlI >> 12 & 0xFF));
                break;
            }
            case 2002:
            case 2007: {
                final double lllllllllllIIIlllIIlIIlllIIIllIl = lllllllllllIIIlllIIlIIlllIIlllll.getX();
                final double lllllllllllIIIlllIIlIIlllIIIllII = lllllllllllIIIlllIIlIIlllIIlllll.getY();
                final double lllllllllllIIIlllIIlIIlllIIIlIll = lllllllllllIIIlllIIlIIlllIIlllll.getZ();
                for (int lllllllllllIIIlllIIlIIlllIIIlIlI = 0; lllllllllllIIIlllIIlIIlllIIIlIlI < 8; ++lllllllllllIIIlllIIlIIlllIIIlIlI) {
                    this.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllIIIlllIIlIIlllIIIllIl, lllllllllllIIIlllIIlIIlllIIIllII, lllllllllllIIIlllIIlIIlllIIIlIll, lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.15, lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 0.2, lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.15, Item.getIdFromItem(Items.SPLASH_POTION));
                }
                final float lllllllllllIIIlllIIlIIlllIIIlIIl = (lllllllllllIIIlllIIlIIllIllIlIlI >> 16 & 0xFF) / 255.0f;
                final float lllllllllllIIIlllIIlIIlllIIIlIII = (lllllllllllIIIlllIIlIIllIllIlIlI >> 8 & 0xFF) / 255.0f;
                final float lllllllllllIIIlllIIlIIlllIIIIlll = (lllllllllllIIIlllIIlIIllIllIlIlI >> 0 & 0xFF) / 255.0f;
                final EnumParticleTypes lllllllllllIIIlllIIlIIlllIIIIllI = (lllllllllllIIIlllIIlIIllIllIllII == 2007) ? EnumParticleTypes.SPELL_INSTANT : EnumParticleTypes.SPELL;
                for (int lllllllllllIIIlllIIlIIlllIIIIlIl = 0; lllllllllllIIIlllIIlIIlllIIIIlIl < 100; ++lllllllllllIIIlllIIlIIlllIIIIlIl) {
                    final double lllllllllllIIIlllIIlIIlllIIIIlII = lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 4.0;
                    final double lllllllllllIIIlllIIlIIlllIIIIIll = lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 3.141592653589793 * 2.0;
                    final double lllllllllllIIIlllIIlIIlllIIIIIlI = Math.cos(lllllllllllIIIlllIIlIIlllIIIIIll) * lllllllllllIIIlllIIlIIlllIIIIlII;
                    final double lllllllllllIIIlllIIlIIlllIIIIIIl = 0.01 + lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 0.5;
                    final double lllllllllllIIIlllIIlIIlllIIIIIII = Math.sin(lllllllllllIIIlllIIlIIlllIIIIIll) * lllllllllllIIIlllIIlIIlllIIIIlII;
                    final Particle lllllllllllIIIlllIIlIIllIlllllll = this.spawnEntityFX(lllllllllllIIIlllIIlIIlllIIIIllI.getParticleID(), lllllllllllIIIlllIIlIIlllIIIIllI.getShouldIgnoreRange(), lllllllllllIIIlllIIlIIlllIIIllIl + lllllllllllIIIlllIIlIIlllIIIIIlI * 0.1, lllllllllllIIIlllIIlIIlllIIIllII + 0.3, lllllllllllIIIlllIIlIIlllIIIlIll + lllllllllllIIIlllIIlIIlllIIIIIII * 0.1, lllllllllllIIIlllIIlIIlllIIIIIlI, lllllllllllIIIlllIIlIIlllIIIIIIl, lllllllllllIIIlllIIlIIlllIIIIIII, new int[0]);
                    if (lllllllllllIIIlllIIlIIllIlllllll != null) {
                        final float lllllllllllIIIlllIIlIIllIllllllI = 0.75f + lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() * 0.25f;
                        lllllllllllIIIlllIIlIIllIlllllll.setRBGColorF(lllllllllllIIIlllIIlIIlllIIIlIIl * lllllllllllIIIlllIIlIIllIllllllI, lllllllllllIIIlllIIlIIlllIIIlIII * lllllllllllIIIlllIIlIIllIllllllI, lllllllllllIIIlllIIlIIlllIIIIlll * lllllllllllIIIlllIIlIIllIllllllI);
                        lllllllllllIIIlllIIlIIllIlllllll.multiplyVelocity((float)lllllllllllIIIlllIIlIIlllIIIIlII);
                    }
                }
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.NEUTRAL, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                final double lllllllllllIIIlllIIlIIllIlllllIl = lllllllllllIIIlllIIlIIlllIIlllll.getX() + 0.5;
                final double lllllllllllIIIlllIIlIIllIlllllII = lllllllllllIIIlllIIlIIlllIIlllll.getY();
                final double lllllllllllIIIlllIIlIIllIllllIll = lllllllllllIIIlllIIlIIlllIIlllll.getZ() + 0.5;
                for (int lllllllllllIIIlllIIlIIllIllllIlI = 0; lllllllllllIIIlllIIlIIllIllllIlI < 8; ++lllllllllllIIIlllIIlIIllIllllIlI) {
                    this.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllIIIlllIIlIIllIlllllIl, lllllllllllIIIlllIIlIIllIlllllII, lllllllllllIIIlllIIlIIllIllllIll, lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.15, lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 0.2, lllllllllllIIIlllIIlIIlllIIlllIl.nextGaussian() * 0.15, Item.getIdFromItem(Items.ENDER_EYE));
                }
                for (double lllllllllllIIIlllIIlIIllIllllIIl = 0.0; lllllllllllIIIlllIIlIIllIllllIIl < 6.283185307179586; lllllllllllIIIlllIIlIIllIllllIIl += 0.15707963267948966) {
                    this.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllIIIlllIIlIIllIlllllIl + Math.cos(lllllllllllIIIlllIIlIIllIllllIIl) * 5.0, lllllllllllIIIlllIIlIIllIlllllII - 0.4, lllllllllllIIIlllIIlIIllIllllIll + Math.sin(lllllllllllIIIlllIIlIIllIllllIIl) * 5.0, Math.cos(lllllllllllIIIlllIIlIIllIllllIIl) * -5.0, 0.0, Math.sin(lllllllllllIIIlllIIlIIllIllllIIl) * -5.0, new int[0]);
                    this.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllIIIlllIIlIIllIlllllIl + Math.cos(lllllllllllIIIlllIIlIIllIllllIIl) * 5.0, lllllllllllIIIlllIIlIIllIlllllII - 0.4, lllllllllllIIIlllIIlIIllIllllIll + Math.sin(lllllllllllIIIlllIIlIIllIllllIIl) * 5.0, Math.cos(lllllllllllIIIlllIIlIIllIllllIIl) * -7.0, 0.0, Math.sin(lllllllllllIIIlllIIlIIllIllllIIl) * -7.0, new int[0]);
                }
            }
            case 2004: {
                for (int lllllllllllIIIlllIIlIIllIllllIII = 0; lllllllllllIIIlllIIlIIllIllllIII < 20; ++lllllllllllIIIlllIIlIIllIllllIII) {
                    final double lllllllllllIIIlllIIlIIllIlllIlll = lllllllllllIIIlllIIlIIlllIIlllll.getX() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double lllllllllllIIIlllIIlIIllIlllIllI = lllllllllllIIIlllIIlIIlllIIlllll.getY() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double lllllllllllIIIlllIIlIIllIlllIlIl = lllllllllllIIIlllIIlIIlllIIlllll.getZ() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    this.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllIIIlllIIlIIllIlllIlll, lllllllllllIIIlllIIlIIllIlllIllI, lllllllllllIIIlllIIlIIllIlllIlIl, 0.0, 0.0, 0.0, new int[0]);
                    this.theWorld.spawnParticle(EnumParticleTypes.FLAME, lllllllllllIIIlllIIlIIllIlllIlll, lllllllllllIIIlllIIlIIllIlllIllI, lllllllllllIIIlllIIlIIllIlllIlIl, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            case 2005: {
                ItemDye.spawnBonemealParticles(this.theWorld, lllllllllllIIIlllIIlIIlllIIlllll, lllllllllllIIIlllIIlIIllIllIlIlI);
                break;
            }
            case 2006: {
                for (int lllllllllllIIIlllIIlIIllIlllIlII = 0; lllllllllllIIIlllIIlIIllIlllIlII < 200; ++lllllllllllIIIlllIIlIIllIlllIlII) {
                    final float lllllllllllIIIlllIIlIIllIlllIIll = lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() * 4.0f;
                    final float lllllllllllIIIlllIIlIIllIlllIIlI = lllllllllllIIIlllIIlIIlllIIlllIl.nextFloat() * 6.2831855f;
                    final double lllllllllllIIIlllIIlIIllIlllIIIl = MathHelper.cos(lllllllllllIIIlllIIlIIllIlllIIlI) * lllllllllllIIIlllIIlIIllIlllIIll;
                    final double lllllllllllIIIlllIIlIIllIlllIIII = 0.01 + lllllllllllIIIlllIIlIIlllIIlllIl.nextDouble() * 0.5;
                    final double lllllllllllIIIlllIIlIIllIllIllll = MathHelper.sin(lllllllllllIIIlllIIlIIllIlllIIlI) * lllllllllllIIIlllIIlIIllIlllIIll;
                    final Particle lllllllllllIIIlllIIlIIllIllIlllI = this.spawnEntityFX(EnumParticleTypes.DRAGON_BREATH.getParticleID(), false, lllllllllllIIIlllIIlIIlllIIlllll.getX() + lllllllllllIIIlllIIlIIllIlllIIIl * 0.1, lllllllllllIIIlllIIlIIlllIIlllll.getY() + 0.3, lllllllllllIIIlllIIlIIlllIIlllll.getZ() + lllllllllllIIIlllIIlIIllIllIllll * 0.1, lllllllllllIIIlllIIlIIllIlllIIIl, lllllllllllIIIlllIIlIIllIlllIIII, lllllllllllIIIlllIIlIIllIllIllll, new int[0]);
                    if (lllllllllllIIIlllIIlIIllIllIlllI != null) {
                        lllllllllllIIIlllIIlIIllIllIlllI.multiplyVelocity(lllllllllllIIIlllIIlIIllIlllIIll);
                    }
                }
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ENDERDRAGON_FIREBALL_EPLD, SoundCategory.HOSTILE, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 3000: {
                this.theWorld.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, true, lllllllllllIIIlllIIlIIlllIIlllll.getX() + 0.5, lllllllllllIIIlllIIlIIlllIIlllll.getY() + 0.5, lllllllllllIIIlllIIlIIlllIIlllll.getZ() + 0.5, 0.0, 0.0, 0.0, new int[0]);
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.BLOCK_END_GATEWAY_SPAWN, SoundCategory.BLOCKS, 10.0f, (1.0f + (this.theWorld.rand.nextFloat() - this.theWorld.rand.nextFloat()) * 0.2f) * 0.7f, false);
                break;
            }
            case 3001: {
                this.theWorld.playSound(lllllllllllIIIlllIIlIIlllIIlllll, SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.HOSTILE, 64.0f, 0.8f + this.theWorld.rand.nextFloat() * 0.3f, false);
                break;
            }
        }
    }
    
    public void setupTerrain(final Entity lllllllllllIIIlllIIllIIIlIllllll, final double lllllllllllIIIlllIIllIIIlIlllllI, ICamera lllllllllllIIIlllIIllIIIlIllllIl, final int lllllllllllIIIlllIIllIIIlllIlllI, final boolean lllllllllllIIIlllIIllIIIlIlllIll) {
        if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks) {
            this.loadRenderers();
        }
        this.theWorld.theProfiler.startSection("camera");
        final double lllllllllllIIIlllIIllIIIlllIllII = lllllllllllIIIlllIIllIIIlIllllll.posX - this.frustumUpdatePosX;
        final double lllllllllllIIIlllIIllIIIlllIlIll = lllllllllllIIIlllIIllIIIlIllllll.posY - this.frustumUpdatePosY;
        final double lllllllllllIIIlllIIllIIIlllIlIlI = lllllllllllIIIlllIIllIIIlIllllll.posZ - this.frustumUpdatePosZ;
        if (this.frustumUpdatePosChunkX != lllllllllllIIIlllIIllIIIlIllllll.chunkCoordX || this.frustumUpdatePosChunkY != lllllllllllIIIlllIIllIIIlIllllll.chunkCoordY || this.frustumUpdatePosChunkZ != lllllllllllIIIlllIIllIIIlIllllll.chunkCoordZ || lllllllllllIIIlllIIllIIIlllIllII * lllllllllllIIIlllIIllIIIlllIllII + lllllllllllIIIlllIIllIIIlllIlIll * lllllllllllIIIlllIIllIIIlllIlIll + lllllllllllIIIlllIIllIIIlllIlIlI * lllllllllllIIIlllIIllIIIlllIlIlI > 16.0) {
            this.frustumUpdatePosX = lllllllllllIIIlllIIllIIIlIllllll.posX;
            this.frustumUpdatePosY = lllllllllllIIIlllIIllIIIlIllllll.posY;
            this.frustumUpdatePosZ = lllllllllllIIIlllIIllIIIlIllllll.posZ;
            this.frustumUpdatePosChunkX = lllllllllllIIIlllIIllIIIlIllllll.chunkCoordX;
            this.frustumUpdatePosChunkY = lllllllllllIIIlllIIllIIIlIllllll.chunkCoordY;
            this.frustumUpdatePosChunkZ = lllllllllllIIIlllIIllIIIlIllllll.chunkCoordZ;
            this.viewFrustum.updateChunkPositions(lllllllllllIIIlllIIllIIIlIllllll.posX, lllllllllllIIIlllIIllIIIlIllllll.posZ);
        }
        if (Config.isDynamicLights()) {
            DynamicLights.update(this);
        }
        this.theWorld.theProfiler.endStartSection("renderlistcamera");
        final double lllllllllllIIIlllIIllIIIlllIlIIl = lllllllllllIIIlllIIllIIIlIllllll.lastTickPosX + (lllllllllllIIIlllIIllIIIlIllllll.posX - lllllllllllIIIlllIIllIIIlIllllll.lastTickPosX) * lllllllllllIIIlllIIllIIIlIlllllI;
        final double lllllllllllIIIlllIIllIIIlllIlIII = lllllllllllIIIlllIIllIIIlIllllll.lastTickPosY + (lllllllllllIIIlllIIllIIIlIllllll.posY - lllllllllllIIIlllIIllIIIlIllllll.lastTickPosY) * lllllllllllIIIlllIIllIIIlIlllllI;
        final double lllllllllllIIIlllIIllIIIlllIIlll = lllllllllllIIIlllIIllIIIlIllllll.lastTickPosZ + (lllllllllllIIIlllIIllIIIlIllllll.posZ - lllllllllllIIIlllIIllIIIlIllllll.lastTickPosZ) * lllllllllllIIIlllIIllIIIlIlllllI;
        this.renderContainer.initialize(lllllllllllIIIlllIIllIIIlllIlIIl, lllllllllllIIIlllIIllIIIlllIlIII, lllllllllllIIIlllIIllIIIlllIIlll);
        this.theWorld.theProfiler.endStartSection("cull");
        if (this.debugFixedClippingHelper != null) {
            final Frustum lllllllllllIIIlllIIllIIIlllIIllI = new Frustum(this.debugFixedClippingHelper);
            lllllllllllIIIlllIIllIIIlllIIllI.setPosition(this.debugTerrainFrustumPosition.x, this.debugTerrainFrustumPosition.y, this.debugTerrainFrustumPosition.z);
            lllllllllllIIIlllIIllIIIlIllllIl = lllllllllllIIIlllIIllIIIlllIIllI;
        }
        this.mc.mcProfiler.endStartSection("culling");
        final BlockPos lllllllllllIIIlllIIllIIIlllIIlIl = new BlockPos(lllllllllllIIIlllIIllIIIlllIlIIl, lllllllllllIIIlllIIllIIIlllIlIII + lllllllllllIIIlllIIllIIIlIllllll.getEyeHeight(), lllllllllllIIIlllIIllIIIlllIIlll);
        final RenderChunk lllllllllllIIIlllIIllIIIlllIIlII = this.viewFrustum.getRenderChunk(lllllllllllIIIlllIIllIIIlllIIlIl);
        new BlockPos(MathHelper.floor(lllllllllllIIIlllIIllIIIlllIlIIl / 16.0) * 16, MathHelper.floor(lllllllllllIIIlllIIllIIIlllIlIII / 16.0) * 16, MathHelper.floor(lllllllllllIIIlllIIllIIIlllIIlll / 16.0) * 16);
        this.displayListEntitiesDirty = (this.displayListEntitiesDirty || !this.chunksToUpdate.isEmpty() || lllllllllllIIIlllIIllIIIlIllllll.posX != this.lastViewEntityX || lllllllllllIIIlllIIllIIIlIllllll.posY != this.lastViewEntityY || lllllllllllIIIlllIIllIIIlIllllll.posZ != this.lastViewEntityZ || lllllllllllIIIlllIIllIIIlIllllll.rotationPitch != this.lastViewEntityPitch || lllllllllllIIIlllIIllIIIlIllllll.rotationYaw != this.lastViewEntityYaw);
        this.lastViewEntityX = lllllllllllIIIlllIIllIIIlIllllll.posX;
        this.lastViewEntityY = lllllllllllIIIlllIIllIIIlIllllll.posY;
        this.lastViewEntityZ = lllllllllllIIIlllIIllIIIlIllllll.posZ;
        this.lastViewEntityPitch = lllllllllllIIIlllIIllIIIlIllllll.rotationPitch;
        this.lastViewEntityYaw = lllllllllllIIIlllIIllIIIlIllllll.rotationYaw;
        final boolean lllllllllllIIIlllIIllIIIlllIIIll = this.debugFixedClippingHelper != null;
        this.mc.mcProfiler.endStartSection("update");
        Lagometer.timerVisibility.start();
        final int lllllllllllIIIlllIIllIIIlllIIIlI = this.getCountLoadedChunks();
        if (lllllllllllIIIlllIIllIIIlllIIIlI != this.countLoadedChunksPrev) {
            this.countLoadedChunksPrev = lllllllllllIIIlllIIllIIIlllIIIlI;
            this.displayListEntitiesDirty = true;
        }
        if (Shaders.isShadowPass) {
            this.renderInfos = (List<ContainerLocalRenderInformation>)this.renderInfosShadow;
            this.renderInfosEntities = this.renderInfosEntitiesShadow;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesShadow;
            if (!lllllllllllIIIlllIIllIIIlllIIIll && this.displayListEntitiesDirty) {
                this.renderInfos.clear();
                this.renderInfosEntities.clear();
                this.renderInfosTileEntities.clear();
                final RenderInfoLazy lllllllllllIIIlllIIllIIIlllIIIIl = new RenderInfoLazy();
                final Iterator<RenderChunk> lllllllllllIIIlllIIllIIIlllIIIII = (Iterator<RenderChunk>)ShadowUtils.makeShadowChunkIterator(this.theWorld, lllllllllllIIIlllIIllIIIlIlllllI, lllllllllllIIIlllIIllIIIlIllllll, this.renderDistanceChunks, this.viewFrustum);
                while (lllllllllllIIIlllIIllIIIlllIIIII.hasNext()) {
                    final RenderChunk lllllllllllIIIlllIIllIIIllIlllll = lllllllllllIIIlllIIllIIIlllIIIII.next();
                    if (lllllllllllIIIlllIIllIIIllIlllll != null) {
                        lllllllllllIIIlllIIllIIIlllIIIIl.setRenderChunk(lllllllllllIIIlllIIllIIIllIlllll);
                        if (!lllllllllllIIIlllIIllIIIllIlllll.compiledChunk.isEmpty() || lllllllllllIIIlllIIllIIIllIlllll.isNeedsUpdate()) {
                            this.renderInfos.add(lllllllllllIIIlllIIllIIIlllIIIIl.getRenderInfo());
                        }
                        final BlockPos lllllllllllIIIlllIIllIIIllIllllI = lllllllllllIIIlllIIllIIIllIlllll.getPosition();
                        if (ChunkUtils.hasEntities(this.theWorld.getChunkFromBlockCoords(lllllllllllIIIlllIIllIIIllIllllI))) {
                            this.renderInfosEntities.add(lllllllllllIIIlllIIllIIIlllIIIIl.getRenderInfo());
                        }
                        if (lllllllllllIIIlllIIllIIIllIlllll.getCompiledChunk().getTileEntities().size() <= 0) {
                            continue;
                        }
                        this.renderInfosTileEntities.add(lllllllllllIIIlllIIllIIIlllIIIIl.getRenderInfo());
                    }
                }
            }
        }
        else {
            this.renderInfos = (List<ContainerLocalRenderInformation>)this.renderInfosNormal;
            this.renderInfosEntities = this.renderInfosEntitiesNormal;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesNormal;
        }
        if (!lllllllllllIIIlllIIllIIIlllIIIll && this.displayListEntitiesDirty && !Shaders.isShadowPass) {
            this.displayListEntitiesDirty = false;
            for (final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIllIlllIl : this.renderInfos) {
                this.freeRenderInformation(lllllllllllIIIlllIIllIIIllIlllIl);
            }
            this.renderInfos.clear();
            this.renderInfosEntities.clear();
            this.renderInfosTileEntities.clear();
            this.visibilityDeque.clear();
            final Deque lllllllllllIIIlllIIllIIIllIlllII = this.visibilityDeque;
            Entity.setRenderDistanceWeight(MathHelper.clamp(this.mc.gameSettings.renderDistanceChunks / 8.0, 1.0, 2.5));
            boolean lllllllllllIIIlllIIllIIIllIllIll = this.mc.renderChunksMany;
            if (lllllllllllIIIlllIIllIIIlllIIlII != null) {
                boolean lllllllllllIIIlllIIllIIIllIllIlI = false;
                final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIllIllIIl = new ContainerLocalRenderInformation(lllllllllllIIIlllIIllIIIlllIIlII, null, 0);
                final Set lllllllllllIIIlllIIllIIIllIllIII = RenderGlobal.SET_ALL_FACINGS;
                if (lllllllllllIIIlllIIllIIIllIllIII.size() == 1) {
                    final Vector3f lllllllllllIIIlllIIllIIIllIlIlll = this.getViewVector(lllllllllllIIIlllIIllIIIlIllllll, lllllllllllIIIlllIIllIIIlIlllllI);
                    final EnumFacing lllllllllllIIIlllIIllIIIllIlIllI = EnumFacing.getFacingFromVector(lllllllllllIIIlllIIllIIIllIlIlll.x, lllllllllllIIIlllIIllIIIllIlIlll.y, lllllllllllIIIlllIIllIIIllIlIlll.z).getOpposite();
                    lllllllllllIIIlllIIllIIIllIllIII.remove(lllllllllllIIIlllIIllIIIllIlIllI);
                }
                if (lllllllllllIIIlllIIllIIIllIllIII.isEmpty()) {
                    lllllllllllIIIlllIIllIIIllIllIlI = true;
                }
                if (lllllllllllIIIlllIIllIIIllIllIlI && !lllllllllllIIIlllIIllIIIlIlllIll) {
                    this.renderInfos.add(lllllllllllIIIlllIIllIIIllIllIIl);
                }
                else {
                    if (lllllllllllIIIlllIIllIIIlIlllIll && this.theWorld.getBlockState(lllllllllllIIIlllIIllIIIlllIIlIl).isOpaqueCube()) {
                        lllllllllllIIIlllIIllIIIllIllIll = false;
                    }
                    lllllllllllIIIlllIIllIIIlllIIlII.setFrameIndex(lllllllllllIIIlllIIllIIIlllIlllI);
                    lllllllllllIIIlllIIllIIIllIlllII.add(lllllllllllIIIlllIIllIIIllIllIIl);
                }
            }
            else {
                final int lllllllllllIIIlllIIllIIIllIlIlIl = (lllllllllllIIIlllIIllIIIlllIIlIl.getY() > 0) ? 248 : 8;
                for (int lllllllllllIIIlllIIllIIIllIlIlII = -this.renderDistanceChunks; lllllllllllIIIlllIIllIIIllIlIlII <= this.renderDistanceChunks; ++lllllllllllIIIlllIIllIIIllIlIlII) {
                    for (int lllllllllllIIIlllIIllIIIllIlIIll = -this.renderDistanceChunks; lllllllllllIIIlllIIllIIIllIlIIll <= this.renderDistanceChunks; ++lllllllllllIIIlllIIllIIIllIlIIll) {
                        final RenderChunk lllllllllllIIIlllIIllIIIllIlIIlI = this.viewFrustum.getRenderChunk(new BlockPos((lllllllllllIIIlllIIllIIIllIlIlII << 4) + 8, lllllllllllIIIlllIIllIIIllIlIlIl, (lllllllllllIIIlllIIllIIIllIlIIll << 4) + 8));
                        if (lllllllllllIIIlllIIllIIIllIlIIlI != null && lllllllllllIIIlllIIllIIIlIllllIl.isBoundingBoxInFrustum(lllllllllllIIIlllIIllIIIllIlIIlI.boundingBox)) {
                            lllllllllllIIIlllIIllIIIllIlIIlI.setFrameIndex(lllllllllllIIIlllIIllIIIlllIlllI);
                            lllllllllllIIIlllIIllIIIllIlllII.add(new ContainerLocalRenderInformation(lllllllllllIIIlllIIllIIIllIlIIlI, null, 0));
                        }
                    }
                }
            }
            this.mc.mcProfiler.startSection("iteration");
            final EnumFacing[] lllllllllllIIIlllIIllIIIllIlIIIl = EnumFacing.VALUES;
            final int lllllllllllIIIlllIIllIIIllIlIIII = lllllllllllIIIlllIIllIIIllIlIIIl.length;
            while (!lllllllllllIIIlllIIllIIIllIlllII.isEmpty()) {
                final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIllIIllll = lllllllllllIIIlllIIllIIIllIlllII.poll();
                final RenderChunk lllllllllllIIIlllIIllIIIllIIlllI = lllllllllllIIIlllIIllIIIllIIllll.renderChunk;
                final EnumFacing lllllllllllIIIlllIIllIIIllIIllIl = lllllllllllIIIlllIIllIIIllIIllll.facing;
                boolean lllllllllllIIIlllIIllIIIllIIllII = false;
                final CompiledChunk lllllllllllIIIlllIIllIIIllIIlIll = lllllllllllIIIlllIIllIIIllIIlllI.compiledChunk;
                if (!lllllllllllIIIlllIIllIIIllIIlIll.isEmpty() || lllllllllllIIIlllIIllIIIllIIlllI.isNeedsUpdate()) {
                    this.renderInfos.add(lllllllllllIIIlllIIllIIIllIIllll);
                    lllllllllllIIIlllIIllIIIllIIllII = true;
                }
                if (ChunkUtils.hasEntities(lllllllllllIIIlllIIllIIIllIIlllI.getChunk(this.theWorld))) {
                    this.renderInfosEntities.add(lllllllllllIIIlllIIllIIIllIIllll);
                    lllllllllllIIIlllIIllIIIllIIllII = true;
                }
                if (lllllllllllIIIlllIIllIIIllIIlIll.getTileEntities().size() > 0) {
                    this.renderInfosTileEntities.add(lllllllllllIIIlllIIllIIIllIIllll);
                    lllllllllllIIIlllIIllIIIllIIllII = true;
                }
                for (final EnumFacing lllllllllllIIIlllIIllIIIllIIlIIl : lllllllllllIIIlllIIllIIIllIlIIIl) {
                    if ((!lllllllllllIIIlllIIllIIIllIllIll || !lllllllllllIIIlllIIllIIIllIIllll.hasDirection(lllllllllllIIIlllIIllIIIllIIlIIl.getOpposite())) && (!lllllllllllIIIlllIIllIIIllIllIll || lllllllllllIIIlllIIllIIIllIIllIl == null || lllllllllllIIIlllIIllIIIllIIlIll.isVisible(lllllllllllIIIlllIIllIIIllIIllIl.getOpposite(), lllllllllllIIIlllIIllIIIllIIlIIl))) {
                        final RenderChunk lllllllllllIIIlllIIllIIIllIIlIII = this.getRenderChunkOffset(lllllllllllIIIlllIIllIIIlllIIlIl, lllllllllllIIIlllIIllIIIllIIlllI, lllllllllllIIIlllIIllIIIllIIlIIl);
                        if (lllllllllllIIIlllIIllIIIllIIlIII != null && lllllllllllIIIlllIIllIIIllIIlIII.setFrameIndex(lllllllllllIIIlllIIllIIIlllIlllI) && lllllllllllIIIlllIIllIIIlIllllIl.isBoundingBoxInFrustum(lllllllllllIIIlllIIllIIIllIIlIII.boundingBox)) {
                            final int lllllllllllIIIlllIIllIIIllIIIlll = lllllllllllIIIlllIIllIIIllIIllll.setFacing | 1 << lllllllllllIIIlllIIllIIIllIIlIIl.ordinal();
                            final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIllIIIllI = this.allocateRenderInformation(lllllllllllIIIlllIIllIIIllIIlIII, lllllllllllIIIlllIIllIIIllIIlIIl, lllllllllllIIIlllIIllIIIllIIIlll);
                            lllllllllllIIIlllIIllIIIllIlllII.add(lllllllllllIIIlllIIllIIIllIIIllI);
                        }
                    }
                }
                if (!lllllllllllIIIlllIIllIIIllIIllII) {
                    this.freeRenderInformation(lllllllllllIIIlllIIllIIIllIIllll);
                }
            }
            this.mc.mcProfiler.endSection();
        }
        this.mc.mcProfiler.endStartSection("captureFrustum");
        if (this.debugFixTerrainFrustum) {
            this.fixTerrainFrustum(lllllllllllIIIlllIIllIIIlllIlIIl, lllllllllllIIIlllIIllIIIlllIlIII, lllllllllllIIIlllIIllIIIlllIIlll);
            this.debugFixTerrainFrustum = false;
        }
        Lagometer.timerVisibility.end();
        if (Shaders.isShadowPass) {
            Shaders.mcProfilerEndSection();
        }
        else {
            this.mc.mcProfiler.endStartSection("rebuildNear");
            final Set<RenderChunk> lllllllllllIIIlllIIllIIIllIIIlIl = this.chunksToUpdate;
            this.chunksToUpdate = (Set<RenderChunk>)Sets.newLinkedHashSet();
            Lagometer.timerChunkUpdate.start();
            for (final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIllIIIlII : this.renderInfos) {
                final RenderChunk lllllllllllIIIlllIIllIIIllIIIIll = lllllllllllIIIlllIIllIIIllIIIlII.renderChunk;
                if (lllllllllllIIIlllIIllIIIllIIIIll.isNeedsUpdate() || lllllllllllIIIlllIIllIIIllIIIlIl.contains(lllllllllllIIIlllIIllIIIllIIIIll)) {
                    this.displayListEntitiesDirty = true;
                    final BlockPos lllllllllllIIIlllIIllIIIllIIIIlI = lllllllllllIIIlllIIllIIIllIIIIll.getPosition();
                    final boolean lllllllllllIIIlllIIllIIIllIIIIIl = lllllllllllIIIlllIIllIIIlllIIlIl.distanceSq(lllllllllllIIIlllIIllIIIllIIIIlI.getX() + 8, lllllllllllIIIlllIIllIIIllIIIIlI.getY() + 8, lllllllllllIIIlllIIllIIIllIIIIlI.getZ() + 8) < 768.0;
                    if (!lllllllllllIIIlllIIllIIIllIIIIIl) {
                        this.chunksToUpdate.add(lllllllllllIIIlllIIllIIIllIIIIll);
                    }
                    else if (!lllllllllllIIIlllIIllIIIllIIIIll.isPlayerUpdate()) {
                        this.chunksToUpdateForced.add(lllllllllllIIIlllIIllIIIllIIIIll);
                    }
                    else {
                        this.mc.mcProfiler.startSection("build near");
                        this.renderDispatcher.updateChunkNow(lllllllllllIIIlllIIllIIIllIIIIll);
                        lllllllllllIIIlllIIllIIIllIIIIll.clearNeedsUpdate();
                        this.mc.mcProfiler.endSection();
                    }
                }
            }
            Lagometer.timerChunkUpdate.end();
            this.chunksToUpdate.addAll(lllllllllllIIIlllIIllIIIllIIIlIl);
            this.mc.mcProfiler.endSection();
        }
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer lllllllllllIIIlllIIlIlIIlIllIlll, final SoundEvent lllllllllllIIIlllIIlIlIIlIllIllI, final SoundCategory lllllllllllIIIlllIIlIlIIlIllIlIl, final double lllllllllllIIIlllIIlIlIIlIllIlII, final double lllllllllllIIIlllIIlIlIIlIllIIll, final double lllllllllllIIIlllIIlIlIIlIllIIlI, final float lllllllllllIIIlllIIlIlIIlIllIIIl, final float lllllllllllIIIlllIIlIlIIlIllIIII) {
    }
    
    public boolean hasCloudFog(final double lllllllllllIIIlllIIlIlllIIlIlllI, final double lllllllllllIIIlllIIlIlllIIlIllIl, final double lllllllllllIIIlllIIlIlllIIlIllII, final float lllllllllllIIIlllIIlIlllIIlIlIll) {
        return false;
    }
    
    @Override
    public void notifyBlockUpdate(final World lllllllllllIIIlllIIlIlIlIIIIIIlI, final BlockPos lllllllllllIIIlllIIlIlIlIIIIIIIl, final IBlockState lllllllllllIIIlllIIlIlIlIIIIIIII, final IBlockState lllllllllllIIIlllIIlIlIIllllllll, final int lllllllllllIIIlllIIlIlIIlllllllI) {
        final int lllllllllllIIIlllIIlIlIIllllllIl = lllllllllllIIIlllIIlIlIlIIIIIIIl.getX();
        final int lllllllllllIIIlllIIlIlIIllllllII = lllllllllllIIIlllIIlIlIlIIIIIIIl.getY();
        final int lllllllllllIIIlllIIlIlIIlllllIll = lllllllllllIIIlllIIlIlIlIIIIIIIl.getZ();
        this.markBlocksForUpdate(lllllllllllIIIlllIIlIlIIllllllIl - 1, lllllllllllIIIlllIIlIlIIllllllII - 1, lllllllllllIIIlllIIlIlIIlllllIll - 1, lllllllllllIIIlllIIlIlIIllllllIl + 1, lllllllllllIIIlllIIlIlIIllllllII + 1, lllllllllllIIIlllIIlIlIIlllllIll + 1, (lllllllllllIIIlllIIlIlIIlllllllI & 0x8) != 0x0);
    }
    
    private Set<EnumFacing> getVisibleFacings(final BlockPos lllllllllllIIIlllIIllIIIlIIllIlI) {
        final VisGraph lllllllllllIIIlllIIllIIIlIIllIIl = new VisGraph();
        final BlockPos lllllllllllIIIlllIIllIIIlIIllIII = new BlockPos(lllllllllllIIIlllIIllIIIlIIllIlI.getX() >> 4 << 4, lllllllllllIIIlllIIllIIIlIIllIlI.getY() >> 4 << 4, lllllllllllIIIlllIIllIIIlIIllIlI.getZ() >> 4 << 4);
        final Chunk lllllllllllIIIlllIIllIIIlIIlIlll = this.theWorld.getChunkFromBlockCoords(lllllllllllIIIlllIIllIIIlIIllIII);
        for (final BlockPos.MutableBlockPos lllllllllllIIIlllIIllIIIlIIlIllI : BlockPos.getAllInBoxMutable(lllllllllllIIIlllIIllIIIlIIllIII, lllllllllllIIIlllIIllIIIlIIllIII.add(15, 15, 15))) {
            if (lllllllllllIIIlllIIllIIIlIIlIlll.getBlockState(lllllllllllIIIlllIIllIIIlIIlIllI).isOpaqueCube()) {
                lllllllllllIIIlllIIllIIIlIIllIIl.setOpaqueCube(lllllllllllIIIlllIIllIIIlIIlIllI);
            }
        }
        return lllllllllllIIIlllIIllIIIlIIllIIl.getVisibleFacings(lllllllllllIIIlllIIllIIIlIIllIlI);
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int lllllllllllIIIlllIIlIlIIlllIIllI, final int lllllllllllIIIlllIIlIlIIllIllllI, final int lllllllllllIIIlllIIlIlIIlllIIlII, final int lllllllllllIIIlllIIlIlIIlllIIIll, final int lllllllllllIIIlllIIlIlIIllIllIll, final int lllllllllllIIIlllIIlIlIIllIllIlI) {
        this.markBlocksForUpdate(lllllllllllIIIlllIIlIlIIlllIIllI - 1, lllllllllllIIIlllIIlIlIIllIllllI - 1, lllllllllllIIIlllIIlIlIIlllIIlII - 1, lllllllllllIIIlllIIlIlIIlllIIIll + 1, lllllllllllIIIlllIIlIlIIllIllIll + 1, lllllllllllIIIlllIIlIlIIllIllIlI + 1, false);
    }
    
    public static void renderFilledBox(final AxisAlignedBB lllllllllllIIIlllIIlIlIlIlllIIII, final float lllllllllllIIIlllIIlIlIlIllIllll, final float lllllllllllIIIlllIIlIlIlIllIlllI, final float lllllllllllIIIlllIIlIlIlIllIlIII, final float lllllllllllIIIlllIIlIlIlIllIllII) {
        renderFilledBox(lllllllllllIIIlllIIlIlIlIlllIIII.minX, lllllllllllIIIlllIIlIlIlIlllIIII.minY, lllllllllllIIIlllIIlIlIlIlllIIII.minZ, lllllllllllIIIlllIIlIlIlIlllIIII.maxX, lllllllllllIIIlllIIlIlIlIlllIIII.maxY, lllllllllllIIIlllIIlIlIlIlllIIII.maxZ, lllllllllllIIIlllIIlIlIlIllIllll, lllllllllllIIIlllIIlIlIlIllIlllI, lllllllllllIIIlllIIlIlIlIllIlIII, lllllllllllIIIlllIIlIlIlIllIllII);
    }
    
    private void renderStars(final BufferBuilder lllllllllllIIIlllIIllIlIIIIIIIII) {
        final Random lllllllllllIIIlllIIllIIlllllllll = new Random(10842L);
        lllllllllllIIIlllIIllIlIIIIIIIII.begin(7, DefaultVertexFormats.POSITION);
        for (int lllllllllllIIIlllIIllIIllllllllI = 0; lllllllllllIIIlllIIllIIllllllllI < 1500; ++lllllllllllIIIlllIIllIIllllllllI) {
            double lllllllllllIIIlllIIllIIlllllllIl = lllllllllllIIIlllIIllIIlllllllll.nextFloat() * 2.0f - 1.0f;
            double lllllllllllIIIlllIIllIIlllllllII = lllllllllllIIIlllIIllIIlllllllll.nextFloat() * 2.0f - 1.0f;
            double lllllllllllIIIlllIIllIIllllllIll = lllllllllllIIIlllIIllIIlllllllll.nextFloat() * 2.0f - 1.0f;
            final double lllllllllllIIIlllIIllIIllllllIlI = 0.15f + lllllllllllIIIlllIIllIIlllllllll.nextFloat() * 0.1f;
            double lllllllllllIIIlllIIllIIllllllIIl = lllllllllllIIIlllIIllIIlllllllIl * lllllllllllIIIlllIIllIIlllllllIl + lllllllllllIIIlllIIllIIlllllllII * lllllllllllIIIlllIIllIIlllllllII + lllllllllllIIIlllIIllIIllllllIll * lllllllllllIIIlllIIllIIllllllIll;
            if (lllllllllllIIIlllIIllIIllllllIIl < 1.0 && lllllllllllIIIlllIIllIIllllllIIl > 0.01) {
                lllllllllllIIIlllIIllIIllllllIIl = 1.0 / Math.sqrt(lllllllllllIIIlllIIllIIllllllIIl);
                lllllllllllIIIlllIIllIIlllllllIl *= lllllllllllIIIlllIIllIIllllllIIl;
                lllllllllllIIIlllIIllIIlllllllII *= lllllllllllIIIlllIIllIIllllllIIl;
                lllllllllllIIIlllIIllIIllllllIll *= lllllllllllIIIlllIIllIIllllllIIl;
                final double lllllllllllIIIlllIIllIIllllllIII = lllllllllllIIIlllIIllIIlllllllIl * 100.0;
                final double lllllllllllIIIlllIIllIIlllllIlll = lllllllllllIIIlllIIllIIlllllllII * 100.0;
                final double lllllllllllIIIlllIIllIIlllllIllI = lllllllllllIIIlllIIllIIllllllIll * 100.0;
                final double lllllllllllIIIlllIIllIIlllllIlIl = Math.atan2(lllllllllllIIIlllIIllIIlllllllIl, lllllllllllIIIlllIIllIIllllllIll);
                final double lllllllllllIIIlllIIllIIlllllIlII = Math.sin(lllllllllllIIIlllIIllIIlllllIlIl);
                final double lllllllllllIIIlllIIllIIlllllIIll = Math.cos(lllllllllllIIIlllIIllIIlllllIlIl);
                final double lllllllllllIIIlllIIllIIlllllIIlI = Math.atan2(Math.sqrt(lllllllllllIIIlllIIllIIlllllllIl * lllllllllllIIIlllIIllIIlllllllIl + lllllllllllIIIlllIIllIIllllllIll * lllllllllllIIIlllIIllIIllllllIll), lllllllllllIIIlllIIllIIlllllllII);
                final double lllllllllllIIIlllIIllIIlllllIIIl = Math.sin(lllllllllllIIIlllIIllIIlllllIIlI);
                final double lllllllllllIIIlllIIllIIlllllIIII = Math.cos(lllllllllllIIIlllIIllIIlllllIIlI);
                final double lllllllllllIIIlllIIllIIllllIllll = lllllllllllIIIlllIIllIIlllllllll.nextDouble() * 3.141592653589793 * 2.0;
                final double lllllllllllIIIlllIIllIIllllIlllI = Math.sin(lllllllllllIIIlllIIllIIllllIllll);
                final double lllllllllllIIIlllIIllIIllllIllIl = Math.cos(lllllllllllIIIlllIIllIIllllIllll);
                for (int lllllllllllIIIlllIIllIIllllIllII = 0; lllllllllllIIIlllIIllIIllllIllII < 4; ++lllllllllllIIIlllIIllIIllllIllII) {
                    final double lllllllllllIIIlllIIllIIllllIlIll = 0.0;
                    final double lllllllllllIIIlllIIllIIllllIlIlI = ((lllllllllllIIIlllIIllIIllllIllII & 0x2) - 1) * lllllllllllIIIlllIIllIIllllllIlI;
                    final double lllllllllllIIIlllIIllIIllllIlIIl = ((lllllllllllIIIlllIIllIIllllIllII + 1 & 0x2) - 1) * lllllllllllIIIlllIIllIIllllllIlI;
                    final double lllllllllllIIIlllIIllIIllllIlIII = 0.0;
                    final double lllllllllllIIIlllIIllIIllllIIlll = lllllllllllIIIlllIIllIIllllIlIlI * lllllllllllIIIlllIIllIIllllIllIl - lllllllllllIIIlllIIllIIllllIlIIl * lllllllllllIIIlllIIllIIllllIlllI;
                    final double lllllllllllIIIlllIIllIIllllIIllI = lllllllllllIIIlllIIllIIllllIlIIl * lllllllllllIIIlllIIllIIllllIllIl + lllllllllllIIIlllIIllIIllllIlIlI * lllllllllllIIIlllIIllIIllllIlllI;
                    final double lllllllllllIIIlllIIllIIllllIIlIl = lllllllllllIIIlllIIllIIllllIIlll * lllllllllllIIIlllIIllIIlllllIIIl + 0.0 * lllllllllllIIIlllIIllIIlllllIIII;
                    final double lllllllllllIIIlllIIllIIllllIIlII = 0.0 * lllllllllllIIIlllIIllIIlllllIIIl - lllllllllllIIIlllIIllIIllllIIlll * lllllllllllIIIlllIIllIIlllllIIII;
                    final double lllllllllllIIIlllIIllIIllllIIIll = lllllllllllIIIlllIIllIIllllIIlII * lllllllllllIIIlllIIllIIlllllIlII - lllllllllllIIIlllIIllIIllllIIllI * lllllllllllIIIlllIIllIIlllllIIll;
                    final double lllllllllllIIIlllIIllIIllllIIIlI = lllllllllllIIIlllIIllIIllllIIllI * lllllllllllIIIlllIIllIIlllllIlII + lllllllllllIIIlllIIllIIllllIIlII * lllllllllllIIIlllIIllIIlllllIIll;
                    lllllllllllIIIlllIIllIlIIIIIIIII.pos(lllllllllllIIIlllIIllIIllllllIII + lllllllllllIIIlllIIllIIllllIIIll, lllllllllllIIIlllIIllIIlllllIlll + lllllllllllIIIlllIIllIIllllIIlIl, lllllllllllIIIlllIIllIIlllllIllI + lllllllllllIIIlllIIllIIllllIIIlI).endVertex();
                }
            }
        }
    }
    
    public int getCountLoadedChunks() {
        if (this.theWorld == null) {
            return 0;
        }
        final IChunkProvider lllllllllllIIIlllIIlIIllIIlIIllI = this.theWorld.getChunkProvider();
        if (lllllllllllIIIlllIIlIIllIIlIIllI == null) {
            return 0;
        }
        if (lllllllllllIIIlllIIlIIllIIlIIllI != this.worldChunkProvider) {
            this.worldChunkProvider = lllllllllllIIIlllIIlIIllIIlIIllI;
            this.worldChunkProviderMap = (Long2ObjectMap<Chunk>)Reflector.getFieldValue((Object)lllllllllllIIIlllIIlIIllIIlIIllI, Reflector.ChunkProviderClient_chunkMapping);
        }
        return (this.worldChunkProviderMap == null) ? 0 : this.worldChunkProviderMap.size();
    }
    
    public int renderBlockLayer(final BlockRenderLayer lllllllllllIIIlllIIllIIIIIlllIII, final double lllllllllllIIIlllIIllIIIIIllIlll, final int lllllllllllIIIlllIIllIIIIIllIllI, final Entity lllllllllllIIIlllIIllIIIIIllIlIl) {
        RenderHelper.disableStandardItemLighting();
        if (lllllllllllIIIlllIIllIIIIIlllIII == BlockRenderLayer.TRANSLUCENT) {
            this.mc.mcProfiler.startSection("translucent_sort");
            final double lllllllllllIIIlllIIllIIIIIllIlII = lllllllllllIIIlllIIllIIIIIllIlIl.posX - this.prevRenderSortX;
            final double lllllllllllIIIlllIIllIIIIIllIIll = lllllllllllIIIlllIIllIIIIIllIlIl.posY - this.prevRenderSortY;
            final double lllllllllllIIIlllIIllIIIIIllIIlI = lllllllllllIIIlllIIllIIIIIllIlIl.posZ - this.prevRenderSortZ;
            if (lllllllllllIIIlllIIllIIIIIllIlII * lllllllllllIIIlllIIllIIIIIllIlII + lllllllllllIIIlllIIllIIIIIllIIll * lllllllllllIIIlllIIllIIIIIllIIll + lllllllllllIIIlllIIllIIIIIllIIlI * lllllllllllIIIlllIIllIIIIIllIIlI > 1.0) {
                this.prevRenderSortX = lllllllllllIIIlllIIllIIIIIllIlIl.posX;
                this.prevRenderSortY = lllllllllllIIIlllIIllIIIIIllIlIl.posY;
                this.prevRenderSortZ = lllllllllllIIIlllIIllIIIIIllIlIl.posZ;
                int lllllllllllIIIlllIIllIIIIIllIIIl = 0;
                this.chunksToResortTransparency.clear();
                for (final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIIIIllIIII : this.renderInfos) {
                    if (lllllllllllIIIlllIIllIIIIIllIIII.renderChunk.compiledChunk.isLayerStarted(lllllllllllIIIlllIIllIIIIIlllIII) && lllllllllllIIIlllIIllIIIIIllIIIl++ < 15) {
                        this.chunksToResortTransparency.add(lllllllllllIIIlllIIllIIIIIllIIII.renderChunk);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
        this.mc.mcProfiler.startSection("filterempty");
        int lllllllllllIIIlllIIllIIIIIlIllll = 0;
        final boolean lllllllllllIIIlllIIllIIIIIlIlllI = lllllllllllIIIlllIIllIIIIIlllIII == BlockRenderLayer.TRANSLUCENT;
        final int lllllllllllIIIlllIIllIIIIIlIllIl = lllllllllllIIIlllIIllIIIIIlIlllI ? (this.renderInfos.size() - 1) : 0;
        for (int lllllllllllIIIlllIIllIIIIIlIllII = lllllllllllIIIlllIIllIIIIIlIlllI ? -1 : this.renderInfos.size(), lllllllllllIIIlllIIllIIIIIlIlIll = lllllllllllIIIlllIIllIIIIIlIlllI ? -1 : 1, lllllllllllIIIlllIIllIIIIIlIlIlI = lllllllllllIIIlllIIllIIIIIlIllIl; lllllllllllIIIlllIIllIIIIIlIlIlI != lllllllllllIIIlllIIllIIIIIlIllII; lllllllllllIIIlllIIllIIIIIlIlIlI += lllllllllllIIIlllIIllIIIIIlIlIll) {
            final RenderChunk lllllllllllIIIlllIIllIIIIIlIlIIl = this.renderInfos.get(lllllllllllIIIlllIIllIIIIIlIlIlI).renderChunk;
            if (!lllllllllllIIIlllIIllIIIIIlIlIIl.getCompiledChunk().isLayerEmpty(lllllllllllIIIlllIIllIIIIIlllIII)) {
                ++lllllllllllIIIlllIIllIIIIIlIllll;
                this.renderContainer.addRenderChunk(lllllllllllIIIlllIIllIIIIIlIlIIl, lllllllllllIIIlllIIllIIIIIlllIII);
            }
        }
        if (lllllllllllIIIlllIIllIIIIIlIllll == 0) {
            this.mc.mcProfiler.endSection();
            return lllllllllllIIIlllIIllIIIIIlIllll;
        }
        if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
            GlStateManager.disableFog();
        }
        this.mc.mcProfiler.endStartSection("render_" + lllllllllllIIIlllIIllIIIIIlllIII);
        this.renderBlockLayer(lllllllllllIIIlllIIllIIIIIlllIII);
        this.mc.mcProfiler.endSection();
        return lllllllllllIIIlllIIllIIIIIlIllll;
    }
    
    private ContainerLocalRenderInformation allocateRenderInformation(final RenderChunk lllllllllllIIIlllIIlIIllIIIIIIlI, final EnumFacing lllllllllllIIIlllIIlIIllIIIIIIIl, final int lllllllllllIIIlllIIlIIllIIIIIlIl) {
        ContainerLocalRenderInformation lllllllllllIIIlllIIlIIllIIIIIIll = null;
        if (RenderGlobal.renderInfoCache.isEmpty()) {
            final ContainerLocalRenderInformation lllllllllllIIIlllIIlIIllIIIIIlII = new ContainerLocalRenderInformation(lllllllllllIIIlllIIlIIllIIIIIIlI, lllllllllllIIIlllIIlIIllIIIIIIIl, lllllllllllIIIlllIIlIIllIIIIIlIl);
        }
        else {
            lllllllllllIIIlllIIlIIllIIIIIIll = RenderGlobal.renderInfoCache.pollLast();
            lllllllllllIIIlllIIlIIllIIIIIIll.initialize(lllllllllllIIIlllIIlIIllIIIIIIlI, lllllllllllIIIlllIIlIIllIIIIIIIl, lllllllllllIIIlllIIlIIllIIIIIlIl);
        }
        lllllllllllIIIlllIIlIIllIIIIIIll.cacheable = true;
        return lllllllllllIIIlllIIlIIllIIIIIIll;
    }
    
    public void drawBlockDamageTexture(final Tessellator lllllllllllIIIlllIIlIlIllllllIlI, final BufferBuilder lllllllllllIIIlllIIlIllIIIIlIIII, final Entity lllllllllllIIIlllIIlIllIIIIIllll, final float lllllllllllIIIlllIIlIlIlllllIlll) {
        final double lllllllllllIIIlllIIlIllIIIIIllIl = lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosX + (lllllllllllIIIlllIIlIllIIIIIllll.posX - lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosX) * lllllllllllIIIlllIIlIlIlllllIlll;
        final double lllllllllllIIIlllIIlIllIIIIIllII = lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosY + (lllllllllllIIIlllIIlIllIIIIIllll.posY - lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosY) * lllllllllllIIIlllIIlIlIlllllIlll;
        final double lllllllllllIIIlllIIlIllIIIIIlIll = lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosZ + (lllllllllllIIIlllIIlIllIIIIIllll.posZ - lllllllllllIIIlllIIlIllIIIIIllll.lastTickPosZ) * lllllllllllIIIlllIIlIlIlllllIlll;
        if (!this.damagedBlocks.isEmpty()) {
            this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.preRenderDamagedBlocks();
            lllllllllllIIIlllIIlIllIIIIlIIII.begin(7, DefaultVertexFormats.BLOCK);
            lllllllllllIIIlllIIlIllIIIIlIIII.setTranslation(-lllllllllllIIIlllIIlIllIIIIIllIl, -lllllllllllIIIlllIIlIllIIIIIllII, -lllllllllllIIIlllIIlIllIIIIIlIll);
            lllllllllllIIIlllIIlIllIIIIlIIII.noColor();
            final Iterator<DestroyBlockProgress> lllllllllllIIIlllIIlIllIIIIIlIlI = this.damagedBlocks.values().iterator();
            while (lllllllllllIIIlllIIlIllIIIIIlIlI.hasNext()) {
                final DestroyBlockProgress lllllllllllIIIlllIIlIllIIIIIlIIl = lllllllllllIIIlllIIlIllIIIIIlIlI.next();
                final BlockPos lllllllllllIIIlllIIlIllIIIIIlIII = lllllllllllIIIlllIIlIllIIIIIlIIl.getPosition();
                final double lllllllllllIIIlllIIlIllIIIIIIlll = lllllllllllIIIlllIIlIllIIIIIlIII.getX() - lllllllllllIIIlllIIlIllIIIIIllIl;
                final double lllllllllllIIIlllIIlIllIIIIIIllI = lllllllllllIIIlllIIlIllIIIIIlIII.getY() - lllllllllllIIIlllIIlIllIIIIIllII;
                final double lllllllllllIIIlllIIlIllIIIIIIlIl = lllllllllllIIIlllIIlIllIIIIIlIII.getZ() - lllllllllllIIIlllIIlIllIIIIIlIll;
                final Block lllllllllllIIIlllIIlIllIIIIIIlII = this.theWorld.getBlockState(lllllllllllIIIlllIIlIllIIIIIlIII).getBlock();
                boolean lllllllllllIIIlllIIlIllIIIIIIIlI = false;
                if (Reflector.ForgeTileEntity_canRenderBreaking.exists()) {
                    boolean lllllllllllIIIlllIIlIllIIIIIIIIl = lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockChest || lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockEnderChest || lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockSign || lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockSkull;
                    if (!lllllllllllIIIlllIIlIllIIIIIIIIl) {
                        final TileEntity lllllllllllIIIlllIIlIllIIIIIIIII = this.theWorld.getTileEntity(lllllllllllIIIlllIIlIllIIIIIlIII);
                        if (lllllllllllIIIlllIIlIllIIIIIIIII != null) {
                            lllllllllllIIIlllIIlIllIIIIIIIIl = Reflector.callBoolean((Object)lllllllllllIIIlllIIlIllIIIIIIIII, Reflector.ForgeTileEntity_canRenderBreaking, new Object[0]);
                        }
                    }
                    final boolean lllllllllllIIIlllIIlIllIIIIIIIll = !lllllllllllIIIlllIIlIllIIIIIIIIl;
                }
                else {
                    lllllllllllIIIlllIIlIllIIIIIIIlI = (!(lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockChest) && !(lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockEnderChest) && !(lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockSign) && !(lllllllllllIIIlllIIlIllIIIIIIlII instanceof BlockSkull));
                }
                if (lllllllllllIIIlllIIlIllIIIIIIIlI) {
                    if (lllllllllllIIIlllIIlIllIIIIIIlll * lllllllllllIIIlllIIlIllIIIIIIlll + lllllllllllIIIlllIIlIllIIIIIIllI * lllllllllllIIIlllIIlIllIIIIIIllI + lllllllllllIIIlllIIlIllIIIIIIlIl * lllllllllllIIIlllIIlIllIIIIIIlIl > 1024.0) {
                        lllllllllllIIIlllIIlIllIIIIIlIlI.remove();
                    }
                    else {
                        final IBlockState lllllllllllIIIlllIIlIlIlllllllll = this.theWorld.getBlockState(lllllllllllIIIlllIIlIllIIIIIlIII);
                        if (lllllllllllIIIlllIIlIlIlllllllll.getMaterial() == Material.AIR) {
                            continue;
                        }
                        final int lllllllllllIIIlllIIlIlIllllllllI = lllllllllllIIIlllIIlIllIIIIIlIIl.getPartialBlockDamage();
                        final TextureAtlasSprite lllllllllllIIIlllIIlIlIlllllllIl = this.destroyBlockIcons[lllllllllllIIIlllIIlIlIllllllllI];
                        final BlockRendererDispatcher lllllllllllIIIlllIIlIlIlllllllII = this.mc.getBlockRendererDispatcher();
                        lllllllllllIIIlllIIlIlIlllllllII.renderBlockDamage(lllllllllllIIIlllIIlIlIlllllllll, lllllllllllIIIlllIIlIllIIIIIlIII, lllllllllllIIIlllIIlIlIlllllllIl, this.theWorld);
                    }
                }
            }
            lllllllllllIIIlllIIlIlIllllllIlI.draw();
            lllllllllllIIIlllIIlIllIIIIlIIII.setTranslation(0.0, 0.0, 0.0);
            this.postRenderDamagedBlocks();
        }
    }
    
    private void cleanupDamagedBlocks(final Iterator<DestroyBlockProgress> lllllllllllIIIlllIIllIIIIIIIIllI) {
        while (lllllllllllIIIlllIIllIIIIIIIIllI.hasNext()) {
            final DestroyBlockProgress lllllllllllIIIlllIIllIIIIIIIIlIl = lllllllllllIIIlllIIllIIIIIIIIllI.next();
            final int lllllllllllIIIlllIIllIIIIIIIIlII = lllllllllllIIIlllIIllIIIIIIIIlIl.getCreationCloudUpdateTick();
            if (this.cloudTickCounter - lllllllllllIIIlllIIllIIIIIIIIlII > 400) {
                lllllllllllIIIlllIIllIIIIIIIIllI.remove();
            }
        }
    }
    
    private void spawnParticle(final EnumParticleTypes lllllllllllIIIlllIIlIlIIIlIlllIl, final double lllllllllllIIIlllIIlIlIIIlIlllII, final double lllllllllllIIIlllIIlIlIIIlIllIll, final double lllllllllllIIIlllIIlIlIIIlIllIlI, final double lllllllllllIIIlllIIlIlIIIlIllIIl, final double lllllllllllIIIlllIIlIlIIIlIIllll, final double lllllllllllIIIlllIIlIlIIIlIlIlll, final int... lllllllllllIIIlllIIlIlIIIlIlIllI) {
        this.spawnParticle(lllllllllllIIIlllIIlIlIIIlIlllIl.getParticleID(), lllllllllllIIIlllIIlIlIIIlIlllIl.getShouldIgnoreRange(), lllllllllllIIIlllIIlIlIIIlIlllII, lllllllllllIIIlllIIlIlIIIlIllIll, lllllllllllIIIlllIIlIlIIIlIllIlI, lllllllllllIIIlllIIlIlIIIlIllIIl, lllllllllllIIIlllIIlIlIIIlIIllll, lllllllllllIIIlllIIlIlIIIlIlIlll, lllllllllllIIIlllIIlIlIIIlIlIllI);
    }
    
    private void generateSky() {
        final Tessellator lllllllllllIIIlllIIllIlIIlIIlIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIllIlIIlIIlIIl = lllllllllllIIIlllIIllIlIIlIIlIlI.getBuffer();
        if (this.skyVBO != null) {
            this.skyVBO.deleteGlBuffers();
        }
        if (this.glSkyList >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList);
            this.glSkyList = -1;
        }
        if (this.vboEnabled) {
            this.skyVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(lllllllllllIIIlllIIllIlIIlIIlIIl, 16.0f, false);
            lllllllllllIIIlllIIllIlIIlIIlIIl.finishDrawing();
            lllllllllllIIIlllIIllIlIIlIIlIIl.reset();
            this.skyVBO.bufferData(lllllllllllIIIlllIIllIlIIlIIlIIl.getByteBuffer());
        }
        else {
            this.glSkyList = GLAllocation.generateDisplayLists(1);
            GlStateManager.glNewList(this.glSkyList, 4864);
            this.renderSky(lllllllllllIIIlllIIllIlIIlIIlIIl, 16.0f, false);
            lllllllllllIIIlllIIllIlIIlIIlIlI.draw();
            GlStateManager.glEndList();
        }
    }
    
    public void renderEntityOutlineFramebuffer() {
        if (this.isRenderEntityOutlines()) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            this.entityOutlineFramebuffer.framebufferRenderExt(this.mc.displayWidth, this.mc.displayHeight, false);
            GlStateManager.disableBlend();
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllIIIlllIIllIlIIlllIIlI) {
        this.updateDestroyBlockIcons();
    }
    
    public int getCountEntitiesRendered() {
        return this.countEntitiesRendered;
    }
    
    public boolean hasNoChunkUpdates() {
        return this.chunksToUpdate.isEmpty() && this.renderDispatcher.hasChunkUpdates();
    }
    
    @Nullable
    private RenderChunk getRenderChunkOffset(final BlockPos lllllllllllIIIlllIIllIIIlIIIIlIl, final RenderChunk lllllllllllIIIlllIIllIIIIlllllII, final EnumFacing lllllllllllIIIlllIIllIIIlIIIIIll) {
        final BlockPos lllllllllllIIIlllIIllIIIlIIIIIlI = lllllllllllIIIlllIIllIIIIlllllII.getBlockPosOffset16(lllllllllllIIIlllIIllIIIlIIIIIll);
        if (lllllllllllIIIlllIIllIIIlIIIIIlI.getY() >= 0 && lllllllllllIIIlllIIllIIIlIIIIIlI.getY() < 256) {
            final int lllllllllllIIIlllIIllIIIlIIIIIIl = lllllllllllIIIlllIIllIIIlIIIIlIl.getX() - lllllllllllIIIlllIIllIIIlIIIIIlI.getX();
            final int lllllllllllIIIlllIIllIIIlIIIIIII = lllllllllllIIIlllIIllIIIlIIIIlIl.getZ() - lllllllllllIIIlllIIllIIIlIIIIIlI.getZ();
            if (Config.isFogOff()) {
                if (Math.abs(lllllllllllIIIlllIIllIIIlIIIIIIl) > this.renderDistance || Math.abs(lllllllllllIIIlllIIllIIIlIIIIIII) > this.renderDistance) {
                    return null;
                }
            }
            else {
                final int lllllllllllIIIlllIIllIIIIlllllll = lllllllllllIIIlllIIllIIIlIIIIIIl * lllllllllllIIIlllIIllIIIlIIIIIIl + lllllllllllIIIlllIIllIIIlIIIIIII * lllllllllllIIIlllIIllIIIlIIIIIII;
                if (lllllllllllIIIlllIIllIIIIlllllll > this.renderDistanceSq) {
                    return null;
                }
            }
            return lllllllllllIIIlllIIllIIIIlllllII.getRenderChunkOffset16(this.viewFrustum, lllllllllllIIIlllIIllIIIlIIIIIll);
        }
        return null;
    }
    
    @Override
    public void onEntityRemoved(final Entity lllllllllllIIIlllIIlIIlllllIIllI) {
        if (Config.isDynamicLights()) {
            DynamicLights.entityRemoved(lllllllllllIIIlllIIlIIlllllIIllI, this);
        }
    }
    
    public String getDebugInfoRenders() {
        final int lllllllllllIIIlllIIllIIlIIlIIllI = this.viewFrustum.renderChunks.length;
        final int lllllllllllIIIlllIIllIIlIIlIIlIl = this.getRenderedChunks();
        return String.format("C: %d/%d %sD: %d, L: %d, %s", lllllllllllIIIlllIIllIIlIIlIIlIl, lllllllllllIIIlllIIllIIlIIlIIllI, this.mc.renderChunksMany ? "(s) " : "", this.renderDistanceChunks, this.setLightUpdates.size(), (this.renderDispatcher == null) ? "null" : this.renderDispatcher.getDebugInfo());
    }
    
    public void deleteAllDisplayLists() {
    }
    
    private void renderCloudsFancy(final float lllllllllllIIIlllIIlIllIllllllII, final int lllllllllllIIIlllIIlIllIllIIIlll, final double lllllllllllIIIlllIIlIllIlllllIlI, final double lllllllllllIIIlllIIlIllIllIIIlIl, final double lllllllllllIIIlllIIlIllIlllllIII) {
        final float lllllllllllIIIlllIIlIllIllllIlll = 0.0f;
        GlStateManager.disableCull();
        final Tessellator lllllllllllIIIlllIIlIllIllllIllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIlIllIllllIlIl = lllllllllllIIIlllIIlIllIllllIllI.getBuffer();
        final float lllllllllllIIIlllIIlIllIllllIlII = 12.0f;
        final float lllllllllllIIIlllIIlIllIllllIIll = 4.0f;
        final double lllllllllllIIIlllIIlIllIllllIIlI = this.cloudTickCounter + lllllllllllIIIlllIIlIllIllllIlll;
        double lllllllllllIIIlllIIlIllIllllIIIl = (lllllllllllIIIlllIIlIllIlllllIlI + lllllllllllIIIlllIIlIllIllllIIlI * 0.029999999329447746) / 12.0;
        double lllllllllllIIIlllIIlIllIllllIIII = lllllllllllIIIlllIIlIllIlllllIII / 12.0 + 0.33000001311302185;
        float lllllllllllIIIlllIIlIllIlllIllll = this.theWorld.provider.getCloudHeight() - (float)lllllllllllIIIlllIIlIllIllIIIlIl + 0.33f;
        lllllllllllIIIlllIIlIllIlllIllll += this.mc.gameSettings.ofCloudsHeight * 128.0f;
        final int lllllllllllIIIlllIIlIllIlllIlllI = MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIIl / 2048.0);
        final int lllllllllllIIIlllIIlIllIlllIllIl = MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIII / 2048.0);
        lllllllllllIIIlllIIlIllIllllIIIl -= lllllllllllIIIlllIIlIllIlllIlllI * 2048;
        lllllllllllIIIlllIIlIllIllllIIII -= lllllllllllIIIlllIIlIllIlllIllIl * 2048;
        this.renderEngine.bindTexture(RenderGlobal.CLOUDS_TEXTURES);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final Vec3d lllllllllllIIIlllIIlIllIlllIllII = this.theWorld.getCloudColour(lllllllllllIIIlllIIlIllIllllIlll);
        float lllllllllllIIIlllIIlIllIlllIlIll = (float)lllllllllllIIIlllIIlIllIlllIllII.xCoord;
        float lllllllllllIIIlllIIlIllIlllIlIlI = (float)lllllllllllIIIlllIIlIllIlllIllII.yCoord;
        float lllllllllllIIIlllIIlIllIlllIlIIl = (float)lllllllllllIIIlllIIlIllIlllIllII.zCoord;
        this.cloudRenderer.prepareToRender(true, this.cloudTickCounter, lllllllllllIIIlllIIlIllIllllllII, lllllllllllIIIlllIIlIllIlllIllII);
        if (lllllllllllIIIlllIIlIllIllIIIlll != 2) {
            final float lllllllllllIIIlllIIlIllIlllIlIII = (lllllllllllIIIlllIIlIllIlllIlIll * 30.0f + lllllllllllIIIlllIIlIllIlllIlIlI * 59.0f + lllllllllllIIIlllIIlIllIlllIlIIl * 11.0f) / 100.0f;
            final float lllllllllllIIIlllIIlIllIlllIIlll = (lllllllllllIIIlllIIlIllIlllIlIll * 30.0f + lllllllllllIIIlllIIlIllIlllIlIlI * 70.0f) / 100.0f;
            final float lllllllllllIIIlllIIlIllIlllIIllI = (lllllllllllIIIlllIIlIllIlllIlIll * 30.0f + lllllllllllIIIlllIIlIllIlllIlIIl * 70.0f) / 100.0f;
            lllllllllllIIIlllIIlIllIlllIlIll = lllllllllllIIIlllIIlIllIlllIlIII;
            lllllllllllIIIlllIIlIllIlllIlIlI = lllllllllllIIIlllIIlIllIlllIIlll;
            lllllllllllIIIlllIIlIllIlllIlIIl = lllllllllllIIIlllIIlIllIlllIIllI;
        }
        final float lllllllllllIIIlllIIlIllIlllIIlIl = lllllllllllIIIlllIIlIllIlllIlIll * 0.9f;
        final float lllllllllllIIIlllIIlIllIlllIIlII = lllllllllllIIIlllIIlIllIlllIlIlI * 0.9f;
        final float lllllllllllIIIlllIIlIllIlllIIIll = lllllllllllIIIlllIIlIllIlllIlIIl * 0.9f;
        final float lllllllllllIIIlllIIlIllIlllIIIlI = lllllllllllIIIlllIIlIllIlllIlIll * 0.7f;
        final float lllllllllllIIIlllIIlIllIlllIIIIl = lllllllllllIIIlllIIlIllIlllIlIlI * 0.7f;
        final float lllllllllllIIIlllIIlIllIlllIIIII = lllllllllllIIIlllIIlIllIlllIlIIl * 0.7f;
        final float lllllllllllIIIlllIIlIllIllIlllll = lllllllllllIIIlllIIlIllIlllIlIll * 0.8f;
        final float lllllllllllIIIlllIIlIllIllIllllI = lllllllllllIIIlllIIlIllIlllIlIlI * 0.8f;
        final float lllllllllllIIIlllIIlIllIllIlllIl = lllllllllllIIIlllIIlIllIlllIlIIl * 0.8f;
        final float lllllllllllIIIlllIIlIllIllIlllII = 0.00390625f;
        final float lllllllllllIIIlllIIlIllIllIllIll = MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIIl) * 0.00390625f;
        final float lllllllllllIIIlllIIlIllIllIllIlI = MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIII) * 0.00390625f;
        final float lllllllllllIIIlllIIlIllIllIllIIl = (float)(lllllllllllIIIlllIIlIllIllllIIIl - MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIIl));
        final float lllllllllllIIIlllIIlIllIllIllIII = (float)(lllllllllllIIIlllIIlIllIllllIIII - MathHelper.floor(lllllllllllIIIlllIIlIllIllllIIII));
        final int lllllllllllIIIlllIIlIllIllIlIlll = 8;
        final int lllllllllllIIIlllIIlIllIllIlIllI = 4;
        final float lllllllllllIIIlllIIlIllIllIlIlIl = 9.765625E-4f;
        GlStateManager.scale(12.0f, 1.0f, 12.0f);
        for (int lllllllllllIIIlllIIlIllIllIlIlII = 0; lllllllllllIIIlllIIlIllIllIlIlII < 2; ++lllllllllllIIIlllIIlIllIllIlIlII) {
            if (lllllllllllIIIlllIIlIllIllIlIlII == 0) {
                GlStateManager.colorMask(false, false, false, false);
            }
            else {
                switch (lllllllllllIIIlllIIlIllIllIIIlll) {
                    case 0: {
                        GlStateManager.colorMask(false, true, true, true);
                        break;
                    }
                    case 1: {
                        GlStateManager.colorMask(true, false, false, true);
                        break;
                    }
                    case 2: {
                        GlStateManager.colorMask(true, true, true, true);
                        break;
                    }
                }
            }
            this.cloudRenderer.renderGlList();
        }
        if (this.cloudRenderer.shouldUpdateGlList()) {
            this.cloudRenderer.startUpdateGlList();
            for (int lllllllllllIIIlllIIlIllIllIlIIll = -3; lllllllllllIIIlllIIlIllIllIlIIll <= 4; ++lllllllllllIIIlllIIlIllIllIlIIll) {
                for (int lllllllllllIIIlllIIlIllIllIlIIlI = -3; lllllllllllIIIlllIIlIllIllIlIIlI <= 4; ++lllllllllllIIIlllIIlIllIllIlIIlI) {
                    lllllllllllIIIlllIIlIllIllllIlIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
                    final float lllllllllllIIIlllIIlIllIllIlIIIl = (float)(lllllllllllIIIlllIIlIllIllIlIIll * 8);
                    final float lllllllllllIIIlllIIlIllIllIlIIII = (float)(lllllllllllIIIlllIIlIllIllIlIIlI * 8);
                    final float lllllllllllIIIlllIIlIllIllIIllll = lllllllllllIIIlllIIlIllIllIlIIIl - lllllllllllIIIlllIIlIllIllIllIIl;
                    final float lllllllllllIIIlllIIlIllIllIIlllI = lllllllllllIIIlllIIlIllIllIlIIII - lllllllllllIIIlllIIlIllIllIllIII;
                    if (lllllllllllIIIlllIIlIllIlllIllll > -5.0f) {
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIIlI, lllllllllllIIIlllIIlIllIlllIIIIl, lllllllllllIIIlllIIlIllIlllIIIII, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIIlI, lllllllllllIIIlllIIlIllIlllIIIIl, lllllllllllIIIlllIIlIllIlllIIIII, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIIlI, lllllllllllIIIlllIIlIllIlllIIIIl, lllllllllllIIIlllIIlIllIlllIIIII, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIIlI, lllllllllllIIIlllIIlIllIlllIIIIl, lllllllllllIIIlllIIlIllIlllIIIII, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                    }
                    if (lllllllllllIIIlllIIlIllIlllIllll <= 5.0f) {
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIlIll, lllllllllllIIIlllIIlIllIlllIlIlI, lllllllllllIIIlllIIlIllIlllIlIIl, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIlIll, lllllllllllIIIlllIIlIllIlllIlIlI, lllllllllllIIIlllIIlIllIlllIlIIl, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIlIll, lllllllllllIIIlllIIlIllIlllIlIlI, lllllllllllIIIlllIIlIllIlllIlIIl, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIlIll, lllllllllllIIIlllIIlIllIlllIlIlI, lllllllllllIIIlllIIlIllIlllIlIIl, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                    }
                    if (lllllllllllIIIlllIIlIllIllIlIIll > -1) {
                        for (int lllllllllllIIIlllIIlIllIllIIllIl = 0; lllllllllllIIIlllIIlIllIllIIllIl < 8; ++lllllllllllIIIlllIIlIllIllIIllIl) {
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllIl + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllIl + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllIl + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllIl + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllIl + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllIl + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllIl + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllIl + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                        }
                    }
                    if (lllllllllllIIIlllIIlIllIllIlIIll <= 1) {
                        for (int lllllllllllIIIlllIIlIllIllIIllII = 0; lllllllllllIIIlllIIlIllIllIIllII < 8; ++lllllllllllIIIlllIIlIllIllIIllII) {
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllII + 1.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllII + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllII + 1.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + 8.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllII + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllII + 1.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllII + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + lllllllllllIIIlllIIlIllIllIIllII + 1.0f - 9.765625E-4f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + lllllllllllIIIlllIIlIllIllIIllII + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIlllIIlIl, lllllllllllIIIlllIIlIllIlllIIlII, lllllllllllIIIlllIIlIllIlllIIIll, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                        }
                    }
                    if (lllllllllllIIIlllIIlIllIllIlIIlI > -1) {
                        for (int lllllllllllIIIlllIIlIllIllIIlIll = 0; lllllllllllIIIlllIIlIllIllIIlIll < 8; ++lllllllllllIIIlllIIlIllIllIIlIll) {
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIll + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIll + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIll + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIll + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIll + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIll + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIll + 0.0f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIll + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                        }
                    }
                    if (lllllllllllIIIlllIIlIllIllIlIIlI <= 1) {
                        for (int lllllllllllIIIlllIIlIllIllIIlIlI = 0; lllllllllllIIIlllIIlIllIllIIlIlI < 8; ++lllllllllllIIIlllIIlIllIllIIlIlI) {
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIlI + 1.0f - 9.765625E-4f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIlI + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 4.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIlI + 1.0f - 9.765625E-4f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIlI + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 8.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIlI + 1.0f - 9.765625E-4f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 8.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIlI + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllIIIlllIIlIllIllllIlIl.pos(lllllllllllIIIlllIIlIllIllIIllll + 0.0f, lllllllllllIIIlllIIlIllIlllIllll + 0.0f, lllllllllllIIIlllIIlIllIllIIlllI + lllllllllllIIIlllIIlIllIllIIlIlI + 1.0f - 9.765625E-4f).tex((lllllllllllIIIlllIIlIllIllIlIIIl + 0.0f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIll, (lllllllllllIIIlllIIlIllIllIlIIII + lllllllllllIIIlllIIlIllIllIIlIlI + 0.5f) * 0.00390625f + lllllllllllIIIlllIIlIllIllIllIlI).color(lllllllllllIIIlllIIlIllIllIlllll, lllllllllllIIIlllIIlIllIllIllllI, lllllllllllIIIlllIIlIllIllIlllIl, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                        }
                    }
                    lllllllllllIIIlllIIlIllIllllIllI.draw();
                }
            }
            this.cloudRenderer.endUpdateGlList();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
    }
    
    @Override
    public void spawnParticle(final int lllllllllllIIIlllIIlIlIIlIIllIlI, final boolean lllllllllllIIIlllIIlIlIIlIlIIIll, final double lllllllllllIIIlllIIlIlIIlIlIIIlI, final double lllllllllllIIIlllIIlIlIIlIlIIIIl, final double lllllllllllIIIlllIIlIlIIlIlIIIII, final double lllllllllllIIIlllIIlIlIIlIIlllll, final double lllllllllllIIIlllIIlIlIIlIIlIlII, final double lllllllllllIIIlllIIlIlIIlIIlIIll, final int... lllllllllllIIIlllIIlIlIIlIIlllII) {
        this.func_190570_a(lllllllllllIIIlllIIlIlIIlIIllIlI, lllllllllllIIIlllIIlIlIIlIlIIIll, false, lllllllllllIIIlllIIlIlIIlIlIIIlI, lllllllllllIIIlllIIlIlIIlIlIIIIl, lllllllllllIIIlllIIlIlIIlIlIIIII, lllllllllllIIIlllIIlIlIIlIIlllll, lllllllllllIIIlllIIlIlIIlIIlIlII, lllllllllllIIIlllIIlIlIIlIIlIIll, lllllllllllIIIlllIIlIlIIlIIlllII);
    }
    
    private void preRenderDamagedBlocks() {
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        GlStateManager.doPolygonOffset(-3.0f, -3.0f);
        GlStateManager.enablePolygonOffset();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        if (Config.isShaders()) {
            ShadersRender.beginBlockDamage();
        }
    }
    
    @Override
    public void onEntityAdded(final Entity lllllllllllIIIlllIIlIIlllllIlllI) {
        RandomMobs.entityLoaded(lllllllllllIIIlllIIlIIlllllIlllI, (World)this.theWorld);
        if (Config.isDynamicLights()) {
            DynamicLights.entityAdded(lllllllllllIIIlllIIlIIlllllIlllI, this);
        }
    }
    
    private int func_190572_a(final boolean lllllllllllIIIlllIIlIIllllllIllI) {
        int lllllllllllIIIlllIIlIIllllllIlIl = this.mc.gameSettings.particleSetting;
        if (lllllllllllIIIlllIIlIIllllllIllI && lllllllllllIIIlllIIlIIllllllIlIl == 2 && this.theWorld.rand.nextInt(10) == 0) {
            lllllllllllIIIlllIIlIIllllllIlIl = 1;
        }
        if (lllllllllllIIIlllIIlIIllllllIlIl == 1 && this.theWorld.rand.nextInt(3) == 0) {
            lllllllllllIIIlllIIlIIllllllIlIl = 2;
        }
        return lllllllllllIIIlllIIlIIllllllIlIl;
    }
    
    protected Vector3f getViewVector(final Entity lllllllllllIIIlllIIllIIIIlIlIlIl, final double lllllllllllIIIlllIIllIIIIlIlIlII) {
        float lllllllllllIIIlllIIllIIIIlIlIIll = (float)(lllllllllllIIIlllIIllIIIIlIlIlIl.prevRotationPitch + (lllllllllllIIIlllIIllIIIIlIlIlIl.rotationPitch - lllllllllllIIIlllIIllIIIIlIlIlIl.prevRotationPitch) * lllllllllllIIIlllIIllIIIIlIlIlII);
        final float lllllllllllIIIlllIIllIIIIlIlIIlI = (float)(lllllllllllIIIlllIIllIIIIlIlIlIl.prevRotationYaw + (lllllllllllIIIlllIIllIIIIlIlIlIl.rotationYaw - lllllllllllIIIlllIIllIIIIlIlIlIl.prevRotationYaw) * lllllllllllIIIlllIIllIIIIlIlIlII);
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
            lllllllllllIIIlllIIllIIIIlIlIIll += 180.0f;
        }
        final float lllllllllllIIIlllIIllIIIIlIlIIIl = MathHelper.cos(-lllllllllllIIIlllIIllIIIIlIlIIlI * 0.017453292f - 3.1415927f);
        final float lllllllllllIIIlllIIllIIIIlIlIIII = MathHelper.sin(-lllllllllllIIIlllIIllIIIIlIlIIlI * 0.017453292f - 3.1415927f);
        final float lllllllllllIIIlllIIllIIIIlIIllll = -MathHelper.cos(-lllllllllllIIIlllIIllIIIIlIlIIll * 0.017453292f);
        final float lllllllllllIIIlllIIllIIIIlIIlllI = MathHelper.sin(-lllllllllllIIIlllIIllIIIIlIlIIll * 0.017453292f);
        return new Vector3f(lllllllllllIIIlllIIllIIIIlIlIIII * lllllllllllIIIlllIIllIIIIlIIllll, lllllllllllIIIlllIIllIIIIlIIlllI, lllllllllllIIIlllIIllIIIIlIlIIIl * lllllllllllIIIlllIIllIIIIlIIllll);
    }
    
    public void renderSky(final float lllllllllllIIIlllIIlIllllIIlIlll, final int lllllllllllIIIlllIIlIllllIllllll) {
        if (Reflector.ForgeWorldProvider_getSkyRenderer.exists()) {
            final WorldProvider lllllllllllIIIlllIIlIllllIlllllI = this.mc.world.provider;
            final Object lllllllllllIIIlllIIlIllllIllllIl = Reflector.call((Object)lllllllllllIIIlllIIlIllllIlllllI, Reflector.ForgeWorldProvider_getSkyRenderer, new Object[0]);
            if (lllllllllllIIIlllIIlIllllIllllIl != null) {
                Reflector.callVoid(lllllllllllIIIlllIIlIllllIllllIl, Reflector.IRenderHandler_render, new Object[] { lllllllllllIIIlllIIlIllllIIlIlll, this.theWorld, this.mc });
                return;
            }
        }
        if (this.mc.world.provider.getDimensionType() == DimensionType.THE_END) {
            this.renderSkyEnd();
        }
        else if (this.mc.world.provider.isSurfaceWorld()) {
            GlStateManager.disableTexture2D();
            final boolean lllllllllllIIIlllIIlIllllIllllII = Config.isShaders();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.disableTexture2D();
            }
            Vec3d lllllllllllIIIlllIIlIllllIlllIll = this.theWorld.getSkyColor(this.mc.getRenderViewEntity(), lllllllllllIIIlllIIlIllllIIlIlll);
            lllllllllllIIIlllIIlIllllIlllIll = CustomColors.getSkyColor(lllllllllllIIIlllIIlIllllIlllIll, (IBlockAccess)this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.setSkyColor(lllllllllllIIIlllIIlIllllIlllIll);
            }
            float lllllllllllIIIlllIIlIllllIlllIlI = (float)lllllllllllIIIlllIIlIllllIlllIll.xCoord;
            float lllllllllllIIIlllIIlIllllIlllIIl = (float)lllllllllllIIIlllIIlIllllIlllIll.yCoord;
            float lllllllllllIIIlllIIlIllllIlllIII = (float)lllllllllllIIIlllIIlIllllIlllIll.zCoord;
            if (lllllllllllIIIlllIIlIllllIllllll != 2) {
                final float lllllllllllIIIlllIIlIllllIllIlll = (lllllllllllIIIlllIIlIllllIlllIlI * 30.0f + lllllllllllIIIlllIIlIllllIlllIIl * 59.0f + lllllllllllIIIlllIIlIllllIlllIII * 11.0f) / 100.0f;
                final float lllllllllllIIIlllIIlIllllIllIllI = (lllllllllllIIIlllIIlIllllIlllIlI * 30.0f + lllllllllllIIIlllIIlIllllIlllIIl * 70.0f) / 100.0f;
                final float lllllllllllIIIlllIIlIllllIllIlIl = (lllllllllllIIIlllIIlIllllIlllIlI * 30.0f + lllllllllllIIIlllIIlIllllIlllIII * 70.0f) / 100.0f;
                lllllllllllIIIlllIIlIllllIlllIlI = lllllllllllIIIlllIIlIllllIllIlll;
                lllllllllllIIIlllIIlIllllIlllIIl = lllllllllllIIIlllIIlIllllIllIllI;
                lllllllllllIIIlllIIlIllllIlllIII = lllllllllllIIIlllIIlIllllIllIlIl;
            }
            GlStateManager.color(lllllllllllIIIlllIIlIllllIlllIlI, lllllllllllIIIlllIIlIllllIlllIIl, lllllllllllIIIlllIIlIllllIlllIII);
            final Tessellator lllllllllllIIIlllIIlIllllIllIlII = Tessellator.getInstance();
            final BufferBuilder lllllllllllIIIlllIIlIllllIllIIll = lllllllllllIIIlllIIlIllllIllIlII.getBuffer();
            GlStateManager.depthMask(false);
            GlStateManager.enableFog();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.enableFog();
            }
            GlStateManager.color(lllllllllllIIIlllIIlIllllIlllIlI, lllllllllllIIIlllIIlIllllIlllIIl, lllllllllllIIIlllIIlIllllIlllIII);
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.preSkyList();
            }
            if (Config.isSkyEnabled()) {
                if (this.vboEnabled) {
                    this.skyVBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.skyVBO.drawArrays(7);
                    this.skyVBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList);
                }
            }
            GlStateManager.disableFog();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.disableFog();
            }
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.disableStandardItemLighting();
            final float[] lllllllllllIIIlllIIlIllllIllIIlI = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(lllllllllllIIIlllIIlIllllIIlIlll), lllllllllllIIIlllIIlIllllIIlIlll);
            if (lllllllllllIIIlllIIlIllllIllIIlI != null && Config.isSunMoonEnabled()) {
                GlStateManager.disableTexture2D();
                if (lllllllllllIIIlllIIlIllllIllllII) {
                    Shaders.disableTexture2D();
                }
                GlStateManager.shadeModel(7425);
                GlStateManager.pushMatrix();
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate((MathHelper.sin(this.theWorld.getCelestialAngleRadians(lllllllllllIIIlllIIlIllllIIlIlll)) < 0.0f) ? 180.0f : 0.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                float lllllllllllIIIlllIIlIllllIllIIIl = lllllllllllIIIlllIIlIllllIllIIlI[0];
                float lllllllllllIIIlllIIlIllllIllIIII = lllllllllllIIIlllIIlIllllIllIIlI[1];
                float lllllllllllIIIlllIIlIllllIlIllll = lllllllllllIIIlllIIlIllllIllIIlI[2];
                if (lllllllllllIIIlllIIlIllllIllllll != 2) {
                    final float lllllllllllIIIlllIIlIllllIlIlllI = (lllllllllllIIIlllIIlIllllIllIIIl * 30.0f + lllllllllllIIIlllIIlIllllIllIIII * 59.0f + lllllllllllIIIlllIIlIllllIlIllll * 11.0f) / 100.0f;
                    final float lllllllllllIIIlllIIlIllllIlIllIl = (lllllllllllIIIlllIIlIllllIllIIIl * 30.0f + lllllllllllIIIlllIIlIllllIllIIII * 70.0f) / 100.0f;
                    final float lllllllllllIIIlllIIlIllllIlIllII = (lllllllllllIIIlllIIlIllllIllIIIl * 30.0f + lllllllllllIIIlllIIlIllllIlIllll * 70.0f) / 100.0f;
                    lllllllllllIIIlllIIlIllllIllIIIl = lllllllllllIIIlllIIlIllllIlIlllI;
                    lllllllllllIIIlllIIlIllllIllIIII = lllllllllllIIIlllIIlIllllIlIllIl;
                    lllllllllllIIIlllIIlIllllIlIllll = lllllllllllIIIlllIIlIllllIlIllII;
                }
                lllllllllllIIIlllIIlIllllIllIIll.begin(6, DefaultVertexFormats.POSITION_COLOR);
                lllllllllllIIIlllIIlIllllIllIIll.pos(0.0, 100.0, 0.0).color(lllllllllllIIIlllIIlIllllIllIIIl, lllllllllllIIIlllIIlIllllIllIIII, lllllllllllIIIlllIIlIllllIlIllll, lllllllllllIIIlllIIlIllllIllIIlI[3]).endVertex();
                final int lllllllllllIIIlllIIlIllllIlIlIll = 16;
                for (int lllllllllllIIIlllIIlIllllIlIlIlI = 0; lllllllllllIIIlllIIlIllllIlIlIlI <= 16; ++lllllllllllIIIlllIIlIllllIlIlIlI) {
                    final float lllllllllllIIIlllIIlIllllIlIlIIl = lllllllllllIIIlllIIlIllllIlIlIlI * 6.2831855f / 16.0f;
                    final float lllllllllllIIIlllIIlIllllIlIlIII = MathHelper.sin(lllllllllllIIIlllIIlIllllIlIlIIl);
                    final float lllllllllllIIIlllIIlIllllIlIIlll = MathHelper.cos(lllllllllllIIIlllIIlIllllIlIlIIl);
                    lllllllllllIIIlllIIlIllllIllIIll.pos(lllllllllllIIIlllIIlIllllIlIlIII * 120.0f, lllllllllllIIIlllIIlIllllIlIIlll * 120.0f, -lllllllllllIIIlllIIlIllllIlIIlll * 40.0f * lllllllllllIIIlllIIlIllllIllIIlI[3]).color(lllllllllllIIIlllIIlIllllIllIIlI[0], lllllllllllIIIlllIIlIllllIllIIlI[1], lllllllllllIIIlllIIlIllllIllIIlI[2], 0.0f).endVertex();
                }
                lllllllllllIIIlllIIlIllllIllIlII.draw();
                GlStateManager.popMatrix();
                GlStateManager.shadeModel(7424);
            }
            GlStateManager.enableTexture2D();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.enableTexture2D();
            }
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            final float lllllllllllIIIlllIIlIllllIlIIllI = 1.0f - this.theWorld.getRainStrength(lllllllllllIIIlllIIlIllllIIlIlll);
            GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllIIIlllIIlIllllIlIIllI);
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            CustomSky.renderSky((World)this.theWorld, this.renderEngine, lllllllllllIIIlllIIlIllllIIlIlll);
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.preCelestialRotate();
            }
            GlStateManager.rotate(this.theWorld.getCelestialAngle(lllllllllllIIIlllIIlIllllIIlIlll) * 360.0f, 1.0f, 0.0f, 0.0f);
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.postCelestialRotate();
            }
            float lllllllllllIIIlllIIlIllllIlIIlIl = 30.0f;
            if (Config.isSunTexture()) {
                this.renderEngine.bindTexture(RenderGlobal.SUN_TEXTURES);
                lllllllllllIIIlllIIlIllllIllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
                lllllllllllIIIlllIIlIllllIllIIll.pos(-lllllllllllIIIlllIIlIllllIlIIlIl, 100.0, -lllllllllllIIIlllIIlIllllIlIIlIl).tex(0.0, 0.0).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(lllllllllllIIIlllIIlIllllIlIIlIl, 100.0, -lllllllllllIIIlllIIlIllllIlIIlIl).tex(1.0, 0.0).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(lllllllllllIIIlllIIlIllllIlIIlIl, 100.0, lllllllllllIIIlllIIlIllllIlIIlIl).tex(1.0, 1.0).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-lllllllllllIIIlllIIlIllllIlIIlIl, 100.0, lllllllllllIIIlllIIlIllllIlIIlIl).tex(0.0, 1.0).endVertex();
                lllllllllllIIIlllIIlIllllIllIlII.draw();
            }
            lllllllllllIIIlllIIlIllllIlIIlIl = 20.0f;
            if (Config.isMoonTexture()) {
                this.renderEngine.bindTexture(RenderGlobal.MOON_PHASES_TEXTURES);
                final int lllllllllllIIIlllIIlIllllIlIIlII = this.theWorld.getMoonPhase();
                final int lllllllllllIIIlllIIlIllllIlIIIll = lllllllllllIIIlllIIlIllllIlIIlII % 4;
                final int lllllllllllIIIlllIIlIllllIlIIIlI = lllllllllllIIIlllIIlIllllIlIIlII / 4 % 2;
                final float lllllllllllIIIlllIIlIllllIlIIIIl = (lllllllllllIIIlllIIlIllllIlIIIll + 0) / 4.0f;
                final float lllllllllllIIIlllIIlIllllIlIIIII = (lllllllllllIIIlllIIlIllllIlIIIlI + 0) / 2.0f;
                final float lllllllllllIIIlllIIlIllllIIlllll = (lllllllllllIIIlllIIlIllllIlIIIll + 1) / 4.0f;
                final float lllllllllllIIIlllIIlIllllIIllllI = (lllllllllllIIIlllIIlIllllIlIIIlI + 1) / 2.0f;
                lllllllllllIIIlllIIlIllllIllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
                lllllllllllIIIlllIIlIllllIllIIll.pos(-lllllllllllIIIlllIIlIllllIlIIlIl, -100.0, lllllllllllIIIlllIIlIllllIlIIlIl).tex(lllllllllllIIIlllIIlIllllIIlllll, lllllllllllIIIlllIIlIllllIIllllI).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(lllllllllllIIIlllIIlIllllIlIIlIl, -100.0, lllllllllllIIIlllIIlIllllIlIIlIl).tex(lllllllllllIIIlllIIlIllllIlIIIIl, lllllllllllIIIlllIIlIllllIIllllI).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(lllllllllllIIIlllIIlIllllIlIIlIl, -100.0, -lllllllllllIIIlllIIlIllllIlIIlIl).tex(lllllllllllIIIlllIIlIllllIlIIIIl, lllllllllllIIIlllIIlIllllIlIIIII).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-lllllllllllIIIlllIIlIllllIlIIlIl, -100.0, -lllllllllllIIIlllIIlIllllIlIIlIl).tex(lllllllllllIIIlllIIlIllllIIlllll, lllllllllllIIIlllIIlIllllIlIIIII).endVertex();
                lllllllllllIIIlllIIlIllllIllIlII.draw();
            }
            GlStateManager.disableTexture2D();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.disableTexture2D();
            }
            final float lllllllllllIIIlllIIlIllllIIlllIl = this.theWorld.getStarBrightness(lllllllllllIIIlllIIlIllllIIlIlll) * lllllllllllIIIlllIIlIllllIlIIllI;
            if (lllllllllllIIIlllIIlIllllIIlllIl > 0.0f && Config.isStarsEnabled() && !CustomSky.hasSkyLayers((World)this.theWorld)) {
                GlStateManager.color(lllllllllllIIIlllIIlIllllIIlllIl, lllllllllllIIIlllIIlIllllIIlllIl, lllllllllllIIIlllIIlIllllIIlllIl, lllllllllllIIIlllIIlIllllIIlllIl);
                if (this.vboEnabled) {
                    this.starVBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.starVBO.drawArrays(7);
                    this.starVBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.starGLCallList);
                }
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableFog();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.enableFog();
            }
            GlStateManager.popMatrix();
            GlStateManager.disableTexture2D();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.disableTexture2D();
            }
            GlStateManager.color(0.0f, 0.0f, 0.0f);
            final double lllllllllllIIIlllIIlIllllIIlllII = this.mc.player.getPositionEyes(lllllllllllIIIlllIIlIllllIIlIlll).yCoord - this.theWorld.getHorizon();
            if (lllllllllllIIIlllIIlIllllIIlllII < 0.0) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0f, 12.0f, 0.0f);
                if (this.vboEnabled) {
                    this.sky2VBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.sky2VBO.drawArrays(7);
                    this.sky2VBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList2);
                }
                GlStateManager.popMatrix();
                final float lllllllllllIIIlllIIlIllllIIllIll = 1.0f;
                final float lllllllllllIIIlllIIlIllllIIllIlI = -(float)(lllllllllllIIIlllIIlIllllIIlllII + 65.0);
                final float lllllllllllIIIlllIIlIllllIIllIIl = -1.0f;
                lllllllllllIIIlllIIlIllllIllIIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, lllllllllllIIIlllIIlIllllIIllIlI, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, lllllllllllIIIlllIIlIllllIIllIlI, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, lllllllllllIIIlllIIlIllllIIllIlI, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, lllllllllllIIIlllIIlIllllIIllIlI, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, lllllllllllIIIlllIIlIllllIIllIlI, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, lllllllllllIIIlllIIlIllllIIllIlI, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, lllllllllllIIIlllIIlIllllIIllIlI, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, lllllllllllIIIlllIIlIllllIIllIlI, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIIll.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllIIIlllIIlIllllIllIlII.draw();
            }
            if (this.theWorld.provider.isSkyColored()) {
                GlStateManager.color(lllllllllllIIIlllIIlIllllIlllIlI * 0.2f + 0.04f, lllllllllllIIIlllIIlIllllIlllIIl * 0.2f + 0.04f, lllllllllllIIIlllIIlIllllIlllIII * 0.6f + 0.1f);
            }
            else {
                GlStateManager.color(lllllllllllIIIlllIIlIllllIlllIlI, lllllllllllIIIlllIIlIllllIlllIIl, lllllllllllIIIlllIIlIllllIlllIII);
            }
            if (this.mc.gameSettings.renderDistanceChunks <= 4) {
                GlStateManager.color(this.mc.entityRenderer.fogColorRed, this.mc.entityRenderer.fogColorGreen, this.mc.entityRenderer.fogColorBlue);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -(float)(lllllllllllIIIlllIIlIllllIIlllII - 16.0), 0.0f);
            if (Config.isSkyEnabled()) {
                GlStateManager.callList(this.glSkyList2);
            }
            GlStateManager.popMatrix();
            GlStateManager.enableTexture2D();
            if (lllllllllllIIIlllIIlIllllIllllII) {
                Shaders.enableTexture2D();
            }
            GlStateManager.depthMask(true);
        }
    }
    
    private void generateStars() {
        final Tessellator lllllllllllIIIlllIIllIlIIIlIIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIllIlIIIlIIlII = lllllllllllIIIlllIIllIlIIIlIIlIl.getBuffer();
        if (this.starVBO != null) {
            this.starVBO.deleteGlBuffers();
        }
        if (this.starGLCallList >= 0) {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }
        if (this.vboEnabled) {
            this.starVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderStars(lllllllllllIIIlllIIllIlIIIlIIlII);
            lllllllllllIIIlllIIllIlIIIlIIlII.finishDrawing();
            lllllllllllIIIlllIIllIlIIIlIIlII.reset();
            this.starVBO.bufferData(lllllllllllIIIlllIIllIlIIIlIIlII.getByteBuffer());
        }
        else {
            this.starGLCallList = GLAllocation.generateDisplayLists(1);
            GlStateManager.pushMatrix();
            GlStateManager.glNewList(this.starGLCallList, 4864);
            this.renderStars(lllllllllllIIIlllIIllIlIIIlIIlII);
            lllllllllllIIIlllIIllIlIIIlIIlIl.draw();
            GlStateManager.glEndList();
            GlStateManager.popMatrix();
        }
    }
    
    public void loadRenderers() {
        if (this.theWorld != null) {
            if (this.renderDispatcher == null) {
                this.renderDispatcher = new ChunkRenderDispatcher();
            }
            this.displayListEntitiesDirty = true;
            Blocks.LEAVES.setGraphicsLevel(Config.isTreesFancy());
            Blocks.LEAVES2.setGraphicsLevel(Config.isTreesFancy());
            BlockModelRenderer.updateAoLightValue();
            RenderGlobal.renderInfoCache.clear();
            if (Config.isDynamicLights()) {
                DynamicLights.clear();
            }
            this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
            this.renderDistance = this.renderDistanceChunks * 16;
            this.renderDistanceSq = this.renderDistance * this.renderDistance;
            final boolean lllllllllllIIIlllIIllIIllIlllIII = this.vboEnabled;
            this.vboEnabled = OpenGlHelper.useVbo();
            if (lllllllllllIIIlllIIllIIllIlllIII && !this.vboEnabled) {
                this.renderContainer = new RenderList();
                this.renderChunkFactory = new ListChunkFactory();
            }
            else if (!lllllllllllIIIlllIIllIIllIlllIII && this.vboEnabled) {
                this.renderContainer = new VboRenderList();
                this.renderChunkFactory = new VboChunkFactory();
            }
            if (lllllllllllIIIlllIIllIIllIlllIII != this.vboEnabled) {
                this.generateStars();
                this.generateSky();
                this.generateSky2();
            }
            if (this.viewFrustum != null) {
                this.viewFrustum.deleteGlResources();
            }
            this.stopChunkUpdates();
            synchronized (this.setTileEntities) {
                this.setTileEntities.clear();
            }
            // monitorexit(this.setTileEntities)
            this.viewFrustum = new ViewFrustum(this.theWorld, this.mc.gameSettings.renderDistanceChunks, this, this.renderChunkFactory);
            if (this.theWorld != null) {
                final Entity lllllllllllIIIlllIIllIIllIllIlll = this.mc.getRenderViewEntity();
                if (lllllllllllIIIlllIIllIIllIllIlll != null) {
                    this.viewFrustum.updateChunkPositions(lllllllllllIIIlllIIllIIllIllIlll.posX, lllllllllllIIIlllIIllIIllIllIlll.posZ);
                }
            }
            this.renderEntitiesStartupCounter = 2;
        }
    }
    
    @Override
    public void notifyLightSet(final BlockPos lllllllllllIIIlllIIlIlIIllllIIIl) {
        this.setLightUpdates.add(lllllllllllIIIlllIIlIlIIllllIIIl.toImmutable());
    }
    
    @Override
    public void broadcastSound(final int lllllllllllIIIlllIIlIIllllIIllII, final BlockPos lllllllllllIIIlllIIlIIllllIlIlll, final int lllllllllllIIIlllIIlIIllllIlIllI) {
        switch (lllllllllllIIIlllIIlIIllllIIllII) {
            case 1023:
            case 1028:
            case 1038: {
                final Entity lllllllllllIIIlllIIlIIllllIlIlIl = this.mc.getRenderViewEntity();
                if (lllllllllllIIIlllIIlIIllllIlIlIl == null) {
                    break;
                }
                final double lllllllllllIIIlllIIlIIllllIlIlII = lllllllllllIIIlllIIlIIllllIlIlll.getX() - lllllllllllIIIlllIIlIIllllIlIlIl.posX;
                final double lllllllllllIIIlllIIlIIllllIlIIll = lllllllllllIIIlllIIlIIllllIlIlll.getY() - lllllllllllIIIlllIIlIIllllIlIlIl.posY;
                final double lllllllllllIIIlllIIlIIllllIlIIlI = lllllllllllIIIlllIIlIIllllIlIlll.getZ() - lllllllllllIIIlllIIlIIllllIlIlIl.posZ;
                final double lllllllllllIIIlllIIlIIllllIlIIIl = Math.sqrt(lllllllllllIIIlllIIlIIllllIlIlII * lllllllllllIIIlllIIlIIllllIlIlII + lllllllllllIIIlllIIlIIllllIlIIll * lllllllllllIIIlllIIlIIllllIlIIll + lllllllllllIIIlllIIlIIllllIlIIlI * lllllllllllIIIlllIIlIIllllIlIIlI);
                double lllllllllllIIIlllIIlIIllllIlIIII = lllllllllllIIIlllIIlIIllllIlIlIl.posX;
                double lllllllllllIIIlllIIlIIllllIIllll = lllllllllllIIIlllIIlIIllllIlIlIl.posY;
                double lllllllllllIIIlllIIlIIllllIIlllI = lllllllllllIIIlllIIlIIllllIlIlIl.posZ;
                if (lllllllllllIIIlllIIlIIllllIlIIIl > 0.0) {
                    lllllllllllIIIlllIIlIIllllIlIIII += lllllllllllIIIlllIIlIIllllIlIlII / lllllllllllIIIlllIIlIIllllIlIIIl * 2.0;
                    lllllllllllIIIlllIIlIIllllIIllll += lllllllllllIIIlllIIlIIllllIlIIll / lllllllllllIIIlllIIlIIllllIlIIIl * 2.0;
                    lllllllllllIIIlllIIlIIllllIIlllI += lllllllllllIIIlllIIlIIllllIlIIlI / lllllllllllIIIlllIIlIIllllIlIIIl * 2.0;
                }
                if (lllllllllllIIIlllIIlIIllllIIllII == 1023) {
                    this.theWorld.playSound(lllllllllllIIIlllIIlIIllllIlIIII, lllllllllllIIIlllIIlIIllllIIllll, lllllllllllIIIlllIIlIIllllIIlllI, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1.0f, 1.0f, false);
                    break;
                }
                if (lllllllllllIIIlllIIlIIllllIIllII == 1038) {
                    this.theWorld.playSound(lllllllllllIIIlllIIlIIllllIlIIII, lllllllllllIIIlllIIlIIllllIIllll, lllllllllllIIIlllIIlIIllllIIlllI, SoundEvents.field_193782_bq, SoundCategory.HOSTILE, 1.0f, 1.0f, false);
                    break;
                }
                this.theWorld.playSound(lllllllllllIIIlllIIlIIllllIlIIII, lllllllllllIIIlllIIlIIllllIIllll, lllllllllllIIIlllIIlIIllllIIlllI, SoundEvents.ENTITY_ENDERDRAGON_DEATH, SoundCategory.HOSTILE, 5.0f, 1.0f, false);
                break;
            }
        }
    }
    
    public RenderGlobal(final Minecraft lllllllllllIIIlllIIllIlIIlllIlIl) {
        this.chunksToUpdate = (Set<RenderChunk>)Sets.newLinkedHashSet();
        this.renderInfos = (List<ContainerLocalRenderInformation>)Lists.newArrayListWithCapacity(69696);
        this.setTileEntities = (Set<TileEntity>)Sets.newHashSet();
        this.starGLCallList = -1;
        this.glSkyList = -1;
        this.glSkyList2 = -1;
        this.damagedBlocks = (Map<Integer, DestroyBlockProgress>)Maps.newHashMap();
        this.mapSoundPositions = (Map<BlockPos, ISound>)Maps.newHashMap();
        this.destroyBlockIcons = new TextureAtlasSprite[10];
        this.frustumUpdatePosX = Double.MIN_VALUE;
        this.frustumUpdatePosY = Double.MIN_VALUE;
        this.frustumUpdatePosZ = Double.MIN_VALUE;
        this.frustumUpdatePosChunkX = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkY = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkZ = Integer.MIN_VALUE;
        this.lastViewEntityX = Double.MIN_VALUE;
        this.lastViewEntityY = Double.MIN_VALUE;
        this.lastViewEntityZ = Double.MIN_VALUE;
        this.lastViewEntityPitch = Double.MIN_VALUE;
        this.lastViewEntityYaw = Double.MIN_VALUE;
        this.renderDistanceChunks = -1;
        this.renderEntitiesStartupCounter = 2;
        this.debugTerrainMatrix = new Vector4f[8];
        this.debugTerrainFrustumPosition = new Vector3d();
        this.displayListEntitiesDirty = true;
        this.setLightUpdates = (Set<BlockPos>)Sets.newHashSet();
        this.chunksToResortTransparency = new LinkedHashSet();
        this.chunksToUpdateForced = new LinkedHashSet();
        this.visibilityDeque = new ArrayDeque();
        this.renderInfosEntities = new ArrayList(1024);
        this.renderInfosTileEntities = new ArrayList(1024);
        this.renderInfosNormal = new ArrayList(1024);
        this.renderInfosEntitiesNormal = new ArrayList(1024);
        this.renderInfosTileEntitiesNormal = new ArrayList(1024);
        this.renderInfosShadow = new ArrayList(1024);
        this.renderInfosEntitiesShadow = new ArrayList(1024);
        this.renderInfosTileEntitiesShadow = new ArrayList(1024);
        this.renderDistance = 0;
        this.renderDistanceSq = 0;
        this.worldChunkProvider = null;
        this.worldChunkProviderMap = null;
        this.countLoadedChunksPrev = 0;
        this.renderEnv = new RenderEnv((IBlockAccess)this.theWorld, Blocks.AIR.getDefaultState(), new BlockPos(0, 0, 0));
        this.renderOverlayDamaged = false;
        this.renderOverlayEyes = false;
        this.cloudRenderer = new CloudRenderer(lllllllllllIIIlllIIllIlIIlllIlIl);
        this.mc = lllllllllllIIIlllIIllIlIIlllIlIl;
        this.renderManager = lllllllllllIIIlllIIllIlIIlllIlIl.getRenderManager();
        this.renderEngine = lllllllllllIIIlllIIllIlIIlllIlIl.getTextureManager();
        this.renderEngine.bindTexture(RenderGlobal.FORCEFIELD_TEXTURES);
        GlStateManager.glTexParameteri(3553, 10242, 10497);
        GlStateManager.glTexParameteri(3553, 10243, 10497);
        GlStateManager.bindTexture(0);
        this.updateDestroyBlockIcons();
        this.vboEnabled = OpenGlHelper.useVbo();
        if (this.vboEnabled) {
            this.renderContainer = new VboRenderList();
            this.renderChunkFactory = new VboChunkFactory();
        }
        else {
            this.renderContainer = new RenderList();
            this.renderChunkFactory = new ListChunkFactory();
        }
        this.vertexBufferFormat = new VertexFormat();
        this.vertexBufferFormat.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        this.generateStars();
        this.generateSky();
        this.generateSky2();
    }
    
    public void makeEntityOutlineShader() {
        if (OpenGlHelper.shadersSupported) {
            if (ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
                ShaderLinkHelper.setNewStaticShaderLinkHelper();
            }
            final ResourceLocation lllllllllllIIIlllIIllIlIIllIIIll = new ResourceLocation("shaders/post/entity_outline.json");
            try {
                this.entityOutlineShader = new ShaderGroup(this.mc.getTextureManager(), this.mc.getResourceManager(), this.mc.getFramebuffer(), lllllllllllIIIlllIIllIlIIllIIIll);
                this.entityOutlineShader.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.entityOutlineFramebuffer = this.entityOutlineShader.getFramebufferRaw("final");
            }
            catch (IOException lllllllllllIIIlllIIllIlIIllIIIlI) {
                RenderGlobal.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllIIIlllIIllIlIIllIIIll, (Object)lllllllllllIIIlllIIllIlIIllIIIlI);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
            catch (JsonSyntaxException lllllllllllIIIlllIIllIlIIllIIIIl) {
                RenderGlobal.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllIIIlllIIllIlIIllIIIll, (Object)lllllllllllIIIlllIIllIlIIllIIIIl);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
        }
        else {
            this.entityOutlineShader = null;
            this.entityOutlineFramebuffer = null;
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = RenderGlobal.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final double lllllllllllIIIlllIIlIIlIlllllIIl = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIIIlllIIlIIlIlllllIIl[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return RenderGlobal.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)lllllllllllIIIlllIIlIIlIlllllIIl;
    }
    
    private void generateSky2() {
        final Tessellator lllllllllllIIIlllIIllIlIIlIlIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIllIlIIlIlIIlI = lllllllllllIIIlllIIllIlIIlIlIIll.getBuffer();
        if (this.sky2VBO != null) {
            this.sky2VBO.deleteGlBuffers();
        }
        if (this.glSkyList2 >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList2);
            this.glSkyList2 = -1;
        }
        if (this.vboEnabled) {
            this.sky2VBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(lllllllllllIIIlllIIllIlIIlIlIIlI, -16.0f, true);
            lllllllllllIIIlllIIllIlIIlIlIIlI.finishDrawing();
            lllllllllllIIIlllIIllIlIIlIlIIlI.reset();
            this.sky2VBO.bufferData(lllllllllllIIIlllIIllIlIIlIlIIlI.getByteBuffer());
        }
        else {
            this.glSkyList2 = GLAllocation.generateDisplayLists(1);
            GlStateManager.glNewList(this.glSkyList2, 4864);
            this.renderSky(lllllllllllIIIlllIIllIlIIlIlIIlI, -16.0f, true);
            lllllllllllIIIlllIIllIlIIlIlIIll.draw();
            GlStateManager.glEndList();
        }
    }
    
    public void updateTileEntities(final Collection<TileEntity> lllllllllllIIIlllIIlIIllIIIIllll, final Collection<TileEntity> lllllllllllIIIlllIIlIIllIIIlIIIl) {
        synchronized (this.setTileEntities) {
            this.setTileEntities.removeAll(lllllllllllIIIlllIIlIIllIIIIllll);
            this.setTileEntities.addAll(lllllllllllIIIlllIIlIIllIIIlIIIl);
        }
        // monitorexit(this.setTileEntities)
    }
    
    private void renderBlockLayer(final BlockRenderLayer lllllllllllIIIlllIIllIIIIIIlIlIl) {
        this.mc.entityRenderer.enableLightmap();
        if (OpenGlHelper.useVbo()) {
            GlStateManager.glEnableClientState(32884);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.glEnableClientState(32886);
        }
        if (Config.isShaders()) {
            ShadersRender.preRenderChunkLayer(lllllllllllIIIlllIIllIIIIIIlIlIl);
        }
        this.renderContainer.renderChunkLayer(lllllllllllIIIlllIIllIIIIIIlIlIl);
        if (Config.isShaders()) {
            ShadersRender.postRenderChunkLayer(lllllllllllIIIlllIIllIIIIIIlIlIl);
        }
        if (OpenGlHelper.useVbo()) {
            for (final VertexFormatElement lllllllllllIIIlllIIllIIIIIIlIlII : DefaultVertexFormats.BLOCK.getElements()) {
                final VertexFormatElement.EnumUsage lllllllllllIIIlllIIllIIIIIIlIIll = lllllllllllIIIlllIIllIIIIIIlIlII.getUsage();
                final int lllllllllllIIIlllIIllIIIIIIlIIlI = lllllllllllIIIlllIIllIIIIIIlIlII.getIndex();
                switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[lllllllllllIIIlllIIllIIIIIIlIIll.ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        GlStateManager.glDisableClientState(32884);
                        continue;
                    }
                    case 4: {
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + lllllllllllIIIlllIIllIIIIIIlIIlI);
                        GlStateManager.glDisableClientState(32888);
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        continue;
                    }
                    case 3: {
                        GlStateManager.glDisableClientState(32886);
                        GlStateManager.resetColor();
                        continue;
                    }
                }
            }
        }
        this.mc.entityRenderer.disableLightmap();
    }
    
    protected int getRenderedChunks() {
        int lllllllllllIIIlllIIllIIlIIIllIll = 0;
        for (final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIlIIIllIlI : this.renderInfos) {
            final CompiledChunk lllllllllllIIIlllIIllIIlIIIllIIl = lllllllllllIIIlllIIllIIlIIIllIlI.renderChunk.compiledChunk;
            if (lllllllllllIIIlllIIllIIlIIIllIIl != CompiledChunk.DUMMY && !lllllllllllIIIlllIIllIIlIIIllIIl.isEmpty()) {
                ++lllllllllllIIIlllIIllIIlIIIllIll;
            }
        }
        return lllllllllllIIIlllIIllIIlIIIllIll;
    }
    
    protected boolean isRenderEntityOutlines() {
        return !Config.isFastRender() && !Config.isShaders() && !Config.isAntialiasing() && (this.entityOutlineFramebuffer != null && this.entityOutlineShader != null && this.mc.player != null);
    }
    
    public void setWorldAndLoadRenderers(@Nullable final WorldClient lllllllllllIIIlllIIllIIllIllllIl) {
        if (this.theWorld != null) {
            this.theWorld.removeEventListener(this);
        }
        this.frustumUpdatePosX = Double.MIN_VALUE;
        this.frustumUpdatePosY = Double.MIN_VALUE;
        this.frustumUpdatePosZ = Double.MIN_VALUE;
        this.frustumUpdatePosChunkX = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkY = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkZ = Integer.MIN_VALUE;
        this.renderManager.set(lllllllllllIIIlllIIllIIllIllllIl);
        this.theWorld = lllllllllllIIIlllIIllIIllIllllIl;
        if (Config.isDynamicLights()) {
            DynamicLights.clear();
        }
        if (lllllllllllIIIlllIIllIIllIllllIl != null) {
            lllllllllllIIIlllIIllIIllIllllIl.addEventListener(this);
            this.loadRenderers();
        }
        else {
            this.chunksToUpdate.clear();
            this.renderInfos.clear();
            if (this.viewFrustum != null) {
                this.viewFrustum.deleteGlResources();
                this.viewFrustum = null;
            }
            if (this.renderDispatcher != null) {
                this.renderDispatcher.stopWorkerThreads();
            }
            this.renderDispatcher = null;
        }
    }
    
    private void freeRenderInformation(final ContainerLocalRenderInformation lllllllllllIIIlllIIlIIlIlllllIll) {
        if (lllllllllllIIIlllIIlIIlIlllllIll.cacheable) {
            RenderGlobal.renderInfoCache.add(lllllllllllIIIlllIIlIIlIlllllIll);
        }
    }
    
    public int getCountRenderers() {
        return this.viewFrustum.renderChunks.length;
    }
    
    @Nullable
    private Particle spawnEntityFX(final int lllllllllllIIIlllIIlIlIIIIllIlll, final boolean lllllllllllIIIlllIIlIlIIIIllIllI, final double lllllllllllIIIlllIIlIlIIIIllllll, final double lllllllllllIIIlllIIlIlIIIIllIlII, final double lllllllllllIIIlllIIlIlIIIIllllIl, final double lllllllllllIIIlllIIlIlIIIIllllII, final double lllllllllllIIIlllIIlIlIIIIlllIll, final double lllllllllllIIIlllIIlIlIIIIllIIII, final int... lllllllllllIIIlllIIlIlIIIIlllIIl) {
        return this.func_190571_b(lllllllllllIIIlllIIlIlIIIIllIlll, lllllllllllIIIlllIIlIlIIIIllIllI, false, lllllllllllIIIlllIIlIlIIIIllllll, lllllllllllIIIlllIIlIlIIIIllIlII, lllllllllllIIIlllIIlIlIIIIllllIl, lllllllllllIIIlllIIlIlIIIIllllII, lllllllllllIIIlllIIlIlIIIIlllIll, lllllllllllIIIlllIIlIlIIIIllIIII, lllllllllllIIIlllIIlIlIIIIlllIIl);
    }
    
    public int getCountTileEntitiesRendered() {
        return this.countTileEntitiesRendered;
    }
    
    @Override
    public void func_190570_a(final int lllllllllllIIIlllIIlIlIIlIIIIIlI, final boolean lllllllllllIIIlllIIlIlIIlIIIIIIl, final boolean lllllllllllIIIlllIIlIlIIlIIIIIII, final double lllllllllllIIIlllIIlIlIIIlllllll, final double lllllllllllIIIlllIIlIlIIIllllllI, final double lllllllllllIIIlllIIlIlIIIllIllll, final double lllllllllllIIIlllIIlIlIIIllIlllI, final double lllllllllllIIIlllIIlIlIIIllIllIl, final double lllllllllllIIIlllIIlIlIIIllIllII, final int... lllllllllllIIIlllIIlIlIIIllllIIl) {
        try {
            this.func_190571_b(lllllllllllIIIlllIIlIlIIlIIIIIlI, lllllllllllIIIlllIIlIlIIlIIIIIIl, lllllllllllIIIlllIIlIlIIlIIIIIII, lllllllllllIIIlllIIlIlIIIlllllll, lllllllllllIIIlllIIlIlIIIllllllI, lllllllllllIIIlllIIlIlIIIllIllll, lllllllllllIIIlllIIlIlIIIllIlllI, lllllllllllIIIlllIIlIlIIIllIllIl, lllllllllllIIIlllIIlIlIIIllIllII, lllllllllllIIIlllIIlIlIIIllllIIl);
        }
        catch (Throwable lllllllllllIIIlllIIlIlIIIllllIII) {
            final CrashReport lllllllllllIIIlllIIlIlIIIlllIlll = CrashReport.makeCrashReport(lllllllllllIIIlllIIlIlIIIllllIII, "Exception while adding particle");
            final CrashReportCategory lllllllllllIIIlllIIlIlIIIlllIllI = lllllllllllIIIlllIIlIlIIIlllIlll.makeCategory("Particle being added");
            lllllllllllIIIlllIIlIlIIIlllIllI.addCrashSection("ID", lllllllllllIIIlllIIlIlIIlIIIIIlI);
            if (lllllllllllIIIlllIIlIlIIIllllIIl != null) {
                lllllllllllIIIlllIIlIlIIIlllIllI.addCrashSection("Parameters", lllllllllllIIIlllIIlIlIIIllllIIl);
            }
            lllllllllllIIIlllIIlIlIIIlllIllI.setDetail("Position", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(lllllllllllIIIlllIIlIlIIIlllllll, lllllllllllIIIlllIIlIlIIIllllllI, lllllllllllIIIlllIIlIlIIIllIllll);
                }
            });
            throw new ReportedException(lllllllllllIIIlllIIlIlIIIlllIlll);
        }
    }
    
    public void resetClouds() {
        this.cloudRenderer.reset();
    }
    
    private void renderSkyEnd() {
        if (Config.isSkyEnabled()) {
            GlStateManager.disableFog();
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.depthMask(false);
            this.renderEngine.bindTexture(RenderGlobal.END_SKY_TEXTURES);
            final Tessellator lllllllllllIIIlllIIlIllllllIIlII = Tessellator.getInstance();
            final BufferBuilder lllllllllllIIIlllIIlIllllllIIIll = lllllllllllIIIlllIIlIllllllIIlII.getBuffer();
            for (int lllllllllllIIIlllIIlIllllllIIIlI = 0; lllllllllllIIIlllIIlIllllllIIIlI < 6; ++lllllllllllIIIlllIIlIllllllIIIlI) {
                GlStateManager.pushMatrix();
                if (lllllllllllIIIlllIIlIllllllIIIlI == 1) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllIIIlllIIlIllllllIIIlI == 2) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllIIIlllIIlIllllllIIIlI == 3) {
                    GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllIIIlllIIlIllllllIIIlI == 4) {
                    GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                }
                if (lllllllllllIIIlllIIlIllllllIIIlI == 5) {
                    GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                }
                lllllllllllIIIlllIIlIllllllIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                int lllllllllllIIIlllIIlIllllllIIIIl = 40;
                int lllllllllllIIIlllIIlIllllllIIIII = 40;
                int lllllllllllIIIlllIIlIlllllIlllll = 40;
                if (Config.isCustomColors()) {
                    Vec3d lllllllllllIIIlllIIlIlllllIllllI = new Vec3d(lllllllllllIIIlllIIlIllllllIIIIl / 255.0, lllllllllllIIIlllIIlIllllllIIIII / 255.0, lllllllllllIIIlllIIlIlllllIlllll / 255.0);
                    lllllllllllIIIlllIIlIlllllIllllI = CustomColors.getWorldSkyColor(lllllllllllIIIlllIIlIlllllIllllI, (World)this.theWorld, this.mc.getRenderViewEntity(), 0.0f);
                    lllllllllllIIIlllIIlIllllllIIIIl = (int)(lllllllllllIIIlllIIlIlllllIllllI.xCoord * 255.0);
                    lllllllllllIIIlllIIlIllllllIIIII = (int)(lllllllllllIIIlllIIlIlllllIllllI.yCoord * 255.0);
                    lllllllllllIIIlllIIlIlllllIlllll = (int)(lllllllllllIIIlllIIlIlllllIllllI.zCoord * 255.0);
                }
                lllllllllllIIIlllIIlIllllllIIIll.pos(-100.0, -100.0, -100.0).tex(0.0, 0.0).color(lllllllllllIIIlllIIlIllllllIIIIl, lllllllllllIIIlllIIlIllllllIIIII, lllllllllllIIIlllIIlIlllllIlllll, 255).endVertex();
                lllllllllllIIIlllIIlIllllllIIIll.pos(-100.0, -100.0, 100.0).tex(0.0, 16.0).color(lllllllllllIIIlllIIlIllllllIIIIl, lllllllllllIIIlllIIlIllllllIIIII, lllllllllllIIIlllIIlIlllllIlllll, 255).endVertex();
                lllllllllllIIIlllIIlIllllllIIIll.pos(100.0, -100.0, 100.0).tex(16.0, 16.0).color(lllllllllllIIIlllIIlIllllllIIIIl, lllllllllllIIIlllIIlIllllllIIIII, lllllllllllIIIlllIIlIlllllIlllll, 255).endVertex();
                lllllllllllIIIlllIIlIllllllIIIll.pos(100.0, -100.0, -100.0).tex(16.0, 0.0).color(lllllllllllIIIlllIIlIllllllIIIIl, lllllllllllIIIlllIIlIllllllIIIII, lllllllllllIIIlllIIlIlllllIlllll, 255).endVertex();
                lllllllllllIIIlllIIlIllllllIIlII.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    public void renderClouds(float lllllllllllIIIlllIIlIlllIlIIlIIl, final int lllllllllllIIIlllIIlIlllIllIIlll, final double lllllllllllIIIlllIIlIlllIlIIIlll, final double lllllllllllIIIlllIIlIlllIlIIIllI, final double lllllllllllIIIlllIIlIlllIlIIIlIl) {
        if (!Config.isCloudsOff()) {
            if (Reflector.ForgeWorldProvider_getCloudRenderer.exists()) {
                final WorldProvider lllllllllllIIIlllIIlIlllIllIIIll = this.mc.world.provider;
                final Object lllllllllllIIIlllIIlIlllIllIIIlI = Reflector.call((Object)lllllllllllIIIlllIIlIlllIllIIIll, Reflector.ForgeWorldProvider_getCloudRenderer, new Object[0]);
                if (lllllllllllIIIlllIIlIlllIllIIIlI != null) {
                    Reflector.callVoid(lllllllllllIIIlllIIlIlllIllIIIlI, Reflector.IRenderHandler_render, new Object[] { lllllllllllIIIlllIIlIlllIlIIlIIl, this.theWorld, this.mc });
                    return;
                }
            }
            if (this.mc.world.provider.isSurfaceWorld()) {
                if (Config.isShaders()) {
                    Shaders.beginClouds();
                }
                if (Config.isCloudsFancy()) {
                    this.renderCloudsFancy(lllllllllllIIIlllIIlIlllIlIIlIIl, lllllllllllIIIlllIIlIlllIllIIlll, lllllllllllIIIlllIIlIlllIlIIIlll, lllllllllllIIIlllIIlIlllIlIIIllI, lllllllllllIIIlllIIlIlllIlIIIlIl);
                }
                else {
                    final float lllllllllllIIIlllIIlIlllIllIIIIl = lllllllllllIIIlllIIlIlllIlIIlIIl;
                    lllllllllllIIIlllIIlIlllIlIIlIIl = 0.0f;
                    GlStateManager.disableCull();
                    final int lllllllllllIIIlllIIlIlllIllIIIII = 32;
                    final int lllllllllllIIIlllIIlIlllIlIlllll = 8;
                    final Tessellator lllllllllllIIIlllIIlIlllIlIllllI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllIIIlllIIlIlllIlIlllIl = lllllllllllIIIlllIIlIlllIlIllllI.getBuffer();
                    this.renderEngine.bindTexture(RenderGlobal.CLOUDS_TEXTURES);
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    final Vec3d lllllllllllIIIlllIIlIlllIlIlllII = this.theWorld.getCloudColour(lllllllllllIIIlllIIlIlllIlIIlIIl);
                    float lllllllllllIIIlllIIlIlllIlIllIll = (float)lllllllllllIIIlllIIlIlllIlIlllII.xCoord;
                    float lllllllllllIIIlllIIlIlllIlIllIlI = (float)lllllllllllIIIlllIIlIlllIlIlllII.yCoord;
                    float lllllllllllIIIlllIIlIlllIlIllIIl = (float)lllllllllllIIIlllIIlIlllIlIlllII.zCoord;
                    this.cloudRenderer.prepareToRender(false, this.cloudTickCounter, lllllllllllIIIlllIIlIlllIllIIIIl, lllllllllllIIIlllIIlIlllIlIlllII);
                    if (this.cloudRenderer.shouldUpdateGlList()) {
                        this.cloudRenderer.startUpdateGlList();
                        if (lllllllllllIIIlllIIlIlllIllIIlll != 2) {
                            final float lllllllllllIIIlllIIlIlllIlIllIII = (lllllllllllIIIlllIIlIlllIlIllIll * 30.0f + lllllllllllIIIlllIIlIlllIlIllIlI * 59.0f + lllllllllllIIIlllIIlIlllIlIllIIl * 11.0f) / 100.0f;
                            final float lllllllllllIIIlllIIlIlllIlIlIlll = (lllllllllllIIIlllIIlIlllIlIllIll * 30.0f + lllllllllllIIIlllIIlIlllIlIllIlI * 70.0f) / 100.0f;
                            final float lllllllllllIIIlllIIlIlllIlIlIllI = (lllllllllllIIIlllIIlIlllIlIllIll * 30.0f + lllllllllllIIIlllIIlIlllIlIllIIl * 70.0f) / 100.0f;
                            lllllllllllIIIlllIIlIlllIlIllIll = lllllllllllIIIlllIIlIlllIlIllIII;
                            lllllllllllIIIlllIIlIlllIlIllIlI = lllllllllllIIIlllIIlIlllIlIlIlll;
                            lllllllllllIIIlllIIlIlllIlIllIIl = lllllllllllIIIlllIIlIlllIlIlIllI;
                        }
                        final float lllllllllllIIIlllIIlIlllIlIlIlIl = 4.8828125E-4f;
                        final double lllllllllllIIIlllIIlIlllIlIlIlII = this.cloudTickCounter + lllllllllllIIIlllIIlIlllIlIIlIIl;
                        double lllllllllllIIIlllIIlIlllIlIlIIll = lllllllllllIIIlllIIlIlllIlIIIlll + lllllllllllIIIlllIIlIlllIlIlIlII * 0.029999999329447746;
                        final int lllllllllllIIIlllIIlIlllIlIlIIlI = MathHelper.floor(lllllllllllIIIlllIIlIlllIlIlIIll / 2048.0);
                        final int lllllllllllIIIlllIIlIlllIlIlIIIl = MathHelper.floor(lllllllllllIIIlllIIlIlllIlIIIlIl / 2048.0);
                        lllllllllllIIIlllIIlIlllIlIlIIll -= lllllllllllIIIlllIIlIlllIlIlIIlI * 2048;
                        final double lllllllllllIIIlllIIlIlllIlIlIIII = lllllllllllIIIlllIIlIlllIlIIIlIl - lllllllllllIIIlllIIlIlllIlIlIIIl * 2048;
                        float lllllllllllIIIlllIIlIlllIlIIllll = this.theWorld.provider.getCloudHeight() - (float)lllllllllllIIIlllIIlIlllIlIIIllI + 0.33f;
                        lllllllllllIIIlllIIlIlllIlIIllll += this.mc.gameSettings.ofCloudsHeight * 128.0f;
                        final float lllllllllllIIIlllIIlIlllIlIIlllI = (float)(lllllllllllIIIlllIIlIlllIlIlIIll * 4.8828125E-4);
                        final float lllllllllllIIIlllIIlIlllIlIIllIl = (float)(lllllllllllIIIlllIIlIlllIlIlIIII * 4.8828125E-4);
                        lllllllllllIIIlllIIlIlllIlIlllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                        for (int lllllllllllIIIlllIIlIlllIlIIllII = -256; lllllllllllIIIlllIIlIlllIlIIllII < 256; lllllllllllIIIlllIIlIlllIlIIllII += 32) {
                            for (int lllllllllllIIIlllIIlIlllIlIIlIll = -256; lllllllllllIIIlllIIlIlllIlIIlIll < 256; lllllllllllIIIlllIIlIlllIlIIlIll += 32) {
                                lllllllllllIIIlllIIlIlllIlIlllIl.pos(lllllllllllIIIlllIIlIlllIlIIllII + 0, lllllllllllIIIlllIIlIlllIlIIllll, lllllllllllIIIlllIIlIlllIlIIlIll + 32).tex((lllllllllllIIIlllIIlIlllIlIIllII + 0) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIlllI, (lllllllllllIIIlllIIlIlllIlIIlIll + 32) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIllIl).color(lllllllllllIIIlllIIlIlllIlIllIll, lllllllllllIIIlllIIlIlllIlIllIlI, lllllllllllIIIlllIIlIlllIlIllIIl, 0.8f).endVertex();
                                lllllllllllIIIlllIIlIlllIlIlllIl.pos(lllllllllllIIIlllIIlIlllIlIIllII + 32, lllllllllllIIIlllIIlIlllIlIIllll, lllllllllllIIIlllIIlIlllIlIIlIll + 32).tex((lllllllllllIIIlllIIlIlllIlIIllII + 32) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIlllI, (lllllllllllIIIlllIIlIlllIlIIlIll + 32) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIllIl).color(lllllllllllIIIlllIIlIlllIlIllIll, lllllllllllIIIlllIIlIlllIlIllIlI, lllllllllllIIIlllIIlIlllIlIllIIl, 0.8f).endVertex();
                                lllllllllllIIIlllIIlIlllIlIlllIl.pos(lllllllllllIIIlllIIlIlllIlIIllII + 32, lllllllllllIIIlllIIlIlllIlIIllll, lllllllllllIIIlllIIlIlllIlIIlIll + 0).tex((lllllllllllIIIlllIIlIlllIlIIllII + 32) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIlllI, (lllllllllllIIIlllIIlIlllIlIIlIll + 0) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIllIl).color(lllllllllllIIIlllIIlIlllIlIllIll, lllllllllllIIIlllIIlIlllIlIllIlI, lllllllllllIIIlllIIlIlllIlIllIIl, 0.8f).endVertex();
                                lllllllllllIIIlllIIlIlllIlIlllIl.pos(lllllllllllIIIlllIIlIlllIlIIllII + 0, lllllllllllIIIlllIIlIlllIlIIllll, lllllllllllIIIlllIIlIlllIlIIlIll + 0).tex((lllllllllllIIIlllIIlIlllIlIIllII + 0) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIlllI, (lllllllllllIIIlllIIlIlllIlIIlIll + 0) * 4.8828125E-4f + lllllllllllIIIlllIIlIlllIlIIllIl).color(lllllllllllIIIlllIIlIlllIlIllIll, lllllllllllIIIlllIIlIlllIlIllIlI, lllllllllllIIIlllIIlIlllIlIllIIl, 0.8f).endVertex();
                            }
                        }
                        lllllllllllIIIlllIIlIlllIlIllllI.draw();
                        this.cloudRenderer.endUpdateGlList();
                    }
                    this.cloudRenderer.renderGlList();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.disableBlend();
                    GlStateManager.enableCull();
                }
                if (Config.isShaders()) {
                    Shaders.endClouds();
                }
            }
        }
    }
    
    public static void renderFilledBox(final double lllllllllllIIIlllIIlIlIlIlIllIlI, final double lllllllllllIIIlllIIlIlIlIlIIlIll, final double lllllllllllIIIlllIIlIlIlIlIllIII, final double lllllllllllIIIlllIIlIlIlIlIIlIIl, final double lllllllllllIIIlllIIlIlIlIlIlIllI, final double lllllllllllIIIlllIIlIlIlIlIIIlll, final float lllllllllllIIIlllIIlIlIlIlIIIllI, final float lllllllllllIIIlllIIlIlIlIlIIIlIl, final float lllllllllllIIIlllIIlIlIlIlIIIlII, final float lllllllllllIIIlllIIlIlIlIlIlIIIl) {
        final Tessellator lllllllllllIIIlllIIlIlIlIlIlIIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIlIlIlIlIIllll = lllllllllllIIIlllIIlIlIlIlIlIIII.getBuffer();
        lllllllllllIIIlllIIlIlIlIlIIllll.begin(5, DefaultVertexFormats.POSITION_COLOR);
        addChainedFilledBoxVertices(lllllllllllIIIlllIIlIlIlIlIIllll, lllllllllllIIIlllIIlIlIlIlIllIlI, lllllllllllIIIlllIIlIlIlIlIIlIll, lllllllllllIIIlllIIlIlIlIlIllIII, lllllllllllIIIlllIIlIlIlIlIIlIIl, lllllllllllIIIlllIIlIlIlIlIlIllI, lllllllllllIIIlllIIlIlIlIlIIIlll, lllllllllllIIIlllIIlIlIlIlIIIllI, lllllllllllIIIlllIIlIlIlIlIIIlIl, lllllllllllIIIlllIIlIlIlIlIIIlII, lllllllllllIIIlllIIlIlIlIlIlIIIl);
        lllllllllllIIIlllIIlIlIlIlIlIIII.draw();
    }
    
    protected void stopChunkUpdates() {
        this.chunksToUpdate.clear();
        this.renderDispatcher.stopChunkUpdates();
    }
    
    public void renderEntities(final Entity lllllllllllIIIlllIIllIIllIIIlIII, final ICamera lllllllllllIIIlllIIllIIllIIIIlll, final float lllllllllllIIIlllIIllIIllIIIIllI) {
        int lllllllllllIIIlllIIllIIllIIIIlIl = 0;
        if (Reflector.MinecraftForgeClient_getRenderPass.exists()) {
            lllllllllllIIIlllIIllIIllIIIIlIl = Reflector.callInt(Reflector.MinecraftForgeClient_getRenderPass, new Object[0]);
        }
        if (this.renderEntitiesStartupCounter > 0) {
            if (lllllllllllIIIlllIIllIIllIIIIlIl > 0) {
                return;
            }
            --this.renderEntitiesStartupCounter;
        }
        else {
            final double lllllllllllIIIlllIIllIIllIIIIlII = lllllllllllIIIlllIIllIIllIIIlIII.prevPosX + (lllllllllllIIIlllIIllIIllIIIlIII.posX - lllllllllllIIIlllIIllIIllIIIlIII.prevPosX) * lllllllllllIIIlllIIllIIllIIIIllI;
            final double lllllllllllIIIlllIIllIIllIIIIIll = lllllllllllIIIlllIIllIIllIIIlIII.prevPosY + (lllllllllllIIIlllIIllIIllIIIlIII.posY - lllllllllllIIIlllIIllIIllIIIlIII.prevPosY) * lllllllllllIIIlllIIllIIllIIIIllI;
            final double lllllllllllIIIlllIIllIIllIIIIIlI = lllllllllllIIIlllIIllIIllIIIlIII.prevPosZ + (lllllllllllIIIlllIIllIIllIIIlIII.posZ - lllllllllllIIIlllIIllIIllIIIlIII.prevPosZ) * lllllllllllIIIlllIIllIIllIIIIllI;
            this.theWorld.theProfiler.startSection("prepare");
            TileEntityRendererDispatcher.instance.prepare(this.theWorld, this.mc.getTextureManager(), Minecraft.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.objectMouseOver, lllllllllllIIIlllIIllIIllIIIIllI);
            this.renderManager.cacheActiveRenderInfo(this.theWorld, Minecraft.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.pointedEntity, this.mc.gameSettings, lllllllllllIIIlllIIllIIllIIIIllI);
            if (lllllllllllIIIlllIIllIIllIIIIlIl == 0) {
                this.countEntitiesTotal = 0;
                this.countEntitiesRendered = 0;
                this.countEntitiesHidden = 0;
                this.countTileEntitiesRendered = 0;
            }
            final Entity lllllllllllIIIlllIIllIIllIIIIIIl = this.mc.getRenderViewEntity();
            final double lllllllllllIIIlllIIllIIllIIIIIII = lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosX + (lllllllllllIIIlllIIllIIllIIIIIIl.posX - lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosX) * lllllllllllIIIlllIIllIIllIIIIllI;
            final double lllllllllllIIIlllIIllIIlIlllllll = lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosY + (lllllllllllIIIlllIIllIIllIIIIIIl.posY - lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosY) * lllllllllllIIIlllIIllIIllIIIIllI;
            final double lllllllllllIIIlllIIllIIlIllllllI = lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosZ + (lllllllllllIIIlllIIllIIllIIIIIIl.posZ - lllllllllllIIIlllIIllIIllIIIIIIl.lastTickPosZ) * lllllllllllIIIlllIIllIIllIIIIllI;
            TileEntityRendererDispatcher.staticPlayerX = lllllllllllIIIlllIIllIIllIIIIIII;
            TileEntityRendererDispatcher.staticPlayerY = lllllllllllIIIlllIIllIIlIlllllll;
            TileEntityRendererDispatcher.staticPlayerZ = lllllllllllIIIlllIIllIIlIllllllI;
            this.renderManager.setRenderPosition(lllllllllllIIIlllIIllIIllIIIIIII, lllllllllllIIIlllIIllIIlIlllllll, lllllllllllIIIlllIIllIIlIllllllI);
            this.mc.entityRenderer.enableLightmap();
            this.theWorld.theProfiler.endStartSection("global");
            final List<Entity> lllllllllllIIIlllIIllIIlIlllllIl = this.theWorld.getLoadedEntityList();
            if (lllllllllllIIIlllIIllIIllIIIIlIl == 0) {
                this.countEntitiesTotal = lllllllllllIIIlllIIllIIlIlllllIl.size();
            }
            if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
                GlStateManager.disableFog();
            }
            final boolean lllllllllllIIIlllIIllIIlIlllllII = Reflector.ForgeEntity_shouldRenderInPass.exists();
            final boolean lllllllllllIIIlllIIllIIlIllllIll = Reflector.ForgeTileEntity_shouldRenderInPass.exists();
            for (int lllllllllllIIIlllIIllIIlIllllIlI = 0; lllllllllllIIIlllIIllIIlIllllIlI < this.theWorld.weatherEffects.size(); ++lllllllllllIIIlllIIllIIlIllllIlI) {
                final Entity lllllllllllIIIlllIIllIIlIllllIIl = this.theWorld.weatherEffects.get(lllllllllllIIIlllIIllIIlIllllIlI);
                if (!lllllllllllIIIlllIIllIIlIlllllII || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllllIIl, Reflector.ForgeEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                    ++this.countEntitiesRendered;
                    if (lllllllllllIIIlllIIllIIlIllllIIl.isInRangeToRender3d(lllllllllllIIIlllIIllIIllIIIIlII, lllllllllllIIIlllIIllIIllIIIIIll, lllllllllllIIIlllIIllIIllIIIIIlI)) {
                        this.renderManager.renderEntityStatic(lllllllllllIIIlllIIllIIlIllllIIl, lllllllllllIIIlllIIllIIllIIIIllI, false);
                    }
                }
            }
            this.theWorld.theProfiler.endStartSection("entities");
            final boolean lllllllllllIIIlllIIllIIlIllllIII = Config.isShaders();
            if (lllllllllllIIIlllIIllIIlIllllIII) {
                Shaders.beginEntities();
            }
            final boolean lllllllllllIIIlllIIllIIlIlllIlll = this.mc.gameSettings.fancyGraphics;
            this.mc.gameSettings.fancyGraphics = Config.isDroppedItemsFancy();
            final List<Entity> lllllllllllIIIlllIIllIIlIlllIllI = (List<Entity>)Lists.newArrayList();
            final List<Entity> lllllllllllIIIlllIIllIIlIlllIlIl = (List<Entity>)Lists.newArrayList();
            final BlockPos.PooledMutableBlockPos lllllllllllIIIlllIIllIIlIlllIlII = BlockPos.PooledMutableBlockPos.retain();
            for (final Object lllllllllllIIIlllIIllIIlIlllIIll : this.renderInfosEntities) {
                final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIlIlllIIlI = (ContainerLocalRenderInformation)lllllllllllIIIlllIIllIIlIlllIIll;
                final Chunk lllllllllllIIIlllIIllIIlIlllIIIl = lllllllllllIIIlllIIllIIlIlllIIlI.renderChunk.getChunk(this.theWorld);
                final ClassInheritanceMultiMap<Entity> lllllllllllIIIlllIIllIIlIlllIIII = lllllllllllIIIlllIIllIIlIlllIIIl.getEntityLists()[lllllllllllIIIlllIIllIIlIlllIIlI.renderChunk.getPosition().getY() / 16];
                if (!lllllllllllIIIlllIIllIIlIlllIIII.isEmpty()) {
                    for (final Entity lllllllllllIIIlllIIllIIlIllIllll : lllllllllllIIIlllIIllIIlIlllIIII) {
                        if (!lllllllllllIIIlllIIllIIlIlllllII || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllIllll, Reflector.ForgeEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                            final boolean lllllllllllIIIlllIIllIIlIllIlllI = this.renderManager.shouldRender(lllllllllllIIIlllIIllIIlIllIllll, lllllllllllIIIlllIIllIIllIIIIlll, lllllllllllIIIlllIIllIIllIIIIlII, lllllllllllIIIlllIIllIIllIIIIIll, lllllllllllIIIlllIIllIIllIIIIIlI) || lllllllllllIIIlllIIllIIlIllIllll.isRidingOrBeingRiddenBy(this.mc.player);
                            if (!lllllllllllIIIlllIIllIIlIllIlllI) {
                                continue;
                            }
                            final boolean lllllllllllIIIlllIIllIIlIllIllIl = this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping();
                            if ((lllllllllllIIIlllIIllIIlIllIllll == this.mc.getRenderViewEntity() && this.mc.gameSettings.thirdPersonView == 0 && !lllllllllllIIIlllIIllIIlIllIllIl) || (lllllllllllIIIlllIIllIIlIllIllll.posY >= 0.0 && lllllllllllIIIlllIIllIIlIllIllll.posY < 256.0 && !this.theWorld.isBlockLoaded(lllllllllllIIIlllIIllIIlIlllIlII.setPos(lllllllllllIIIlllIIllIIlIllIllll)))) {
                                continue;
                            }
                            ++this.countEntitiesRendered;
                            this.renderedEntity = lllllllllllIIIlllIIllIIlIllIllll;
                            if (lllllllllllIIIlllIIllIIlIllllIII) {
                                Shaders.nextEntity(lllllllllllIIIlllIIllIIlIllIllll);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllIIIlllIIllIIlIllIllll, lllllllllllIIIlllIIllIIllIIIIllI, false);
                            this.renderedEntity = null;
                            if (this.isOutlineActive(lllllllllllIIIlllIIllIIlIllIllll, lllllllllllIIIlllIIllIIllIIIIIIl, lllllllllllIIIlllIIllIIllIIIIlll)) {
                                lllllllllllIIIlllIIllIIlIlllIllI.add(lllllllllllIIIlllIIllIIlIllIllll);
                            }
                            if (!this.renderManager.isRenderMultipass(lllllllllllIIIlllIIllIIlIllIllll)) {
                                continue;
                            }
                            lllllllllllIIIlllIIllIIlIlllIlIl.add(lllllllllllIIIlllIIllIIlIllIllll);
                        }
                    }
                }
            }
            lllllllllllIIIlllIIllIIlIlllIlII.release();
            if (!lllllllllllIIIlllIIllIIlIlllIlIl.isEmpty()) {
                for (final Entity lllllllllllIIIlllIIllIIlIllIllII : lllllllllllIIIlllIIllIIlIlllIlIl) {
                    if (!lllllllllllIIIlllIIllIIlIlllllII || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllIllII, Reflector.ForgeEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                        if (lllllllllllIIIlllIIllIIlIllllIII) {
                            Shaders.nextEntity(lllllllllllIIIlllIIllIIlIllIllII);
                        }
                        this.renderManager.renderMultipass(lllllllllllIIIlllIIllIIlIllIllII, lllllllllllIIIlllIIllIIllIIIIllI);
                    }
                }
            }
            if (lllllllllllIIIlllIIllIIllIIIIlIl == 0 && this.isRenderEntityOutlines() && (!lllllllllllIIIlllIIllIIlIlllIllI.isEmpty() || this.entityOutlinesRendered)) {
                this.theWorld.theProfiler.endStartSection("entityOutlines");
                this.entityOutlineFramebuffer.framebufferClear();
                this.entityOutlinesRendered = !lllllllllllIIIlllIIllIIlIlllIllI.isEmpty();
                if (!lllllllllllIIIlllIIllIIlIlllIllI.isEmpty()) {
                    GlStateManager.depthFunc(519);
                    GlStateManager.disableFog();
                    this.entityOutlineFramebuffer.bindFramebuffer(false);
                    RenderHelper.disableStandardItemLighting();
                    this.renderManager.setRenderOutlines(true);
                    for (int lllllllllllIIIlllIIllIIlIllIlIll = 0; lllllllllllIIIlllIIllIIlIllIlIll < lllllllllllIIIlllIIllIIlIlllIllI.size(); ++lllllllllllIIIlllIIllIIlIllIlIll) {
                        final Entity lllllllllllIIIlllIIllIIlIllIlIlI = lllllllllllIIIlllIIllIIlIlllIllI.get(lllllllllllIIIlllIIllIIlIllIlIll);
                        if (!lllllllllllIIIlllIIllIIlIlllllII || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllIlIlI, Reflector.ForgeEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                            if (lllllllllllIIIlllIIllIIlIllllIII) {
                                Shaders.nextEntity(lllllllllllIIIlllIIllIIlIllIlIlI);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllIIIlllIIllIIlIllIlIlI, lllllllllllIIIlllIIllIIllIIIIllI, false);
                        }
                    }
                    this.renderManager.setRenderOutlines(false);
                    RenderHelper.enableStandardItemLighting();
                    GlStateManager.depthMask(false);
                    this.entityOutlineShader.loadShaderGroup(lllllllllllIIIlllIIllIIllIIIIllI);
                    GlStateManager.enableLighting();
                    GlStateManager.depthMask(true);
                    GlStateManager.enableFog();
                    GlStateManager.enableBlend();
                    GlStateManager.enableColorMaterial();
                    GlStateManager.depthFunc(515);
                    GlStateManager.enableDepth();
                    GlStateManager.enableAlpha();
                }
                this.mc.getFramebuffer().bindFramebuffer(false);
            }
            if (!this.isRenderEntityOutlines() && (!lllllllllllIIIlllIIllIIlIlllIllI.isEmpty() || this.entityOutlinesRendered)) {
                this.theWorld.theProfiler.endStartSection("entityOutlines");
                this.entityOutlinesRendered = !lllllllllllIIIlllIIllIIlIlllIllI.isEmpty();
                if (!lllllllllllIIIlllIIllIIlIlllIllI.isEmpty()) {
                    GlStateManager.disableFog();
                    GlStateManager.disableDepth();
                    this.mc.entityRenderer.disableLightmap();
                    RenderHelper.disableStandardItemLighting();
                    this.renderManager.setRenderOutlines(true);
                    for (int lllllllllllIIIlllIIllIIlIllIlIIl = 0; lllllllllllIIIlllIIllIIlIllIlIIl < lllllllllllIIIlllIIllIIlIlllIllI.size(); ++lllllllllllIIIlllIIllIIlIllIlIIl) {
                        final Entity lllllllllllIIIlllIIllIIlIllIlIII = lllllllllllIIIlllIIllIIlIlllIllI.get(lllllllllllIIIlllIIllIIlIllIlIIl);
                        if (!lllllllllllIIIlllIIllIIlIlllllII || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllIlIII, Reflector.ForgeEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                            if (lllllllllllIIIlllIIllIIlIllllIII) {
                                Shaders.nextEntity(lllllllllllIIIlllIIllIIlIllIlIII);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllIIIlllIIllIIlIllIlIII, lllllllllllIIIlllIIllIIllIIIIllI, false);
                        }
                    }
                    this.renderManager.setRenderOutlines(false);
                    RenderHelper.enableStandardItemLighting();
                    this.mc.entityRenderer.enableLightmap();
                    GlStateManager.enableDepth();
                    GlStateManager.enableFog();
                }
            }
            this.mc.gameSettings.fancyGraphics = lllllllllllIIIlllIIllIIlIlllIlll;
            final FontRenderer lllllllllllIIIlllIIllIIlIllIIlll = TileEntityRendererDispatcher.instance.getFontRenderer();
            if (lllllllllllIIIlllIIllIIlIllllIII) {
                Shaders.endEntities();
                Shaders.beginBlockEntities();
            }
            this.theWorld.theProfiler.endStartSection("blockentities");
            RenderHelper.enableStandardItemLighting();
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                TileEntityRendererDispatcher.instance.preDrawBatch();
            }
            for (final Object lllllllllllIIIlllIIllIIlIllIIllI : this.renderInfosTileEntities) {
                final ContainerLocalRenderInformation lllllllllllIIIlllIIllIIlIllIIlIl = (ContainerLocalRenderInformation)lllllllllllIIIlllIIllIIlIllIIllI;
                final List<TileEntity> lllllllllllIIIlllIIllIIlIllIIlII = lllllllllllIIIlllIIllIIlIllIIlIl.renderChunk.getCompiledChunk().getTileEntities();
                if (!lllllllllllIIIlllIIllIIlIllIIlII.isEmpty()) {
                    for (final TileEntity lllllllllllIIIlllIIllIIlIllIIIlI : lllllllllllIIIlllIIllIIlIllIIlII) {
                        if (lllllllllllIIIlllIIllIIlIllllIll) {
                            if (!Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIllIIIlI, Reflector.ForgeTileEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                                continue;
                            }
                            final AxisAlignedBB lllllllllllIIIlllIIllIIlIllIIIIl = (AxisAlignedBB)Reflector.call((Object)lllllllllllIIIlllIIllIIlIllIIIlI, Reflector.ForgeTileEntity_getRenderBoundingBox, new Object[0]);
                            if (lllllllllllIIIlllIIllIIlIllIIIIl != null && !lllllllllllIIIlllIIllIIllIIIIlll.isBoundingBoxInFrustum(lllllllllllIIIlllIIllIIlIllIIIIl)) {
                                continue;
                            }
                        }
                        final Class lllllllllllIIIlllIIllIIlIllIIIII = lllllllllllIIIlllIIllIIlIllIIIlI.getClass();
                        if (lllllllllllIIIlllIIllIIlIllIIIII == TileEntitySign.class && !Config.zoomMode) {
                            final EntityPlayer lllllllllllIIIlllIIllIIlIlIlllll = this.mc.player;
                            final double lllllllllllIIIlllIIllIIlIlIllllI = lllllllllllIIIlllIIllIIlIllIIIlI.getDistanceSq(lllllllllllIIIlllIIllIIlIlIlllll.posX, lllllllllllIIIlllIIllIIlIlIlllll.posY, lllllllllllIIIlllIIllIIlIlIlllll.posZ);
                            if (lllllllllllIIIlllIIllIIlIlIllllI > 256.0) {
                                lllllllllllIIIlllIIllIIlIllIIlll.enabled = false;
                            }
                        }
                        if (lllllllllllIIIlllIIllIIlIllllIII) {
                            Shaders.nextBlockEntity(lllllllllllIIIlllIIllIIlIllIIIlI);
                        }
                        TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllIIIlllIIllIIlIllIIIlI, lllllllllllIIIlllIIllIIllIIIIllI, -1);
                        ++this.countTileEntitiesRendered;
                        lllllllllllIIIlllIIllIIlIllIIlll.enabled = true;
                    }
                }
            }
            synchronized (this.setTileEntities) {
                for (final TileEntity lllllllllllIIIlllIIllIIlIlIlllIl : this.setTileEntities) {
                    if (!lllllllllllIIIlllIIllIIlIllllIll || Reflector.callBoolean((Object)lllllllllllIIIlllIIllIIlIlIlllIl, Reflector.ForgeTileEntity_shouldRenderInPass, new Object[] { lllllllllllIIIlllIIllIIllIIIIlIl })) {
                        if (lllllllllllIIIlllIIllIIlIllllIII) {
                            Shaders.nextBlockEntity(lllllllllllIIIlllIIllIIlIlIlllIl);
                        }
                        TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllIIIlllIIllIIlIlIlllIl, lllllllllllIIIlllIIllIIllIIIIllI, -1);
                    }
                }
            }
            // monitorexit(this.setTileEntities)
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                TileEntityRendererDispatcher.instance.drawBatch(lllllllllllIIIlllIIllIIllIIIIlIl);
            }
            this.renderOverlayDamaged = true;
            this.preRenderDamagedBlocks();
            for (final DestroyBlockProgress lllllllllllIIIlllIIllIIlIlIlllII : this.damagedBlocks.values()) {
                BlockPos lllllllllllIIIlllIIllIIlIlIllIll = lllllllllllIIIlllIIllIIlIlIlllII.getPosition();
                if (this.theWorld.getBlockState(lllllllllllIIIlllIIllIIlIlIllIll).getBlock().hasTileEntity()) {
                    TileEntity lllllllllllIIIlllIIllIIlIlIllIlI = this.theWorld.getTileEntity(lllllllllllIIIlllIIllIIlIlIllIll);
                    if (lllllllllllIIIlllIIllIIlIlIllIlI instanceof TileEntityChest) {
                        final TileEntityChest lllllllllllIIIlllIIllIIlIlIllIIl = (TileEntityChest)lllllllllllIIIlllIIllIIlIlIllIlI;
                        if (lllllllllllIIIlllIIllIIlIlIllIIl.adjacentChestXNeg != null) {
                            lllllllllllIIIlllIIllIIlIlIllIll = lllllllllllIIIlllIIllIIlIlIllIll.offset(EnumFacing.WEST);
                            lllllllllllIIIlllIIllIIlIlIllIlI = this.theWorld.getTileEntity(lllllllllllIIIlllIIllIIlIlIllIll);
                        }
                        else if (lllllllllllIIIlllIIllIIlIlIllIIl.adjacentChestZNeg != null) {
                            lllllllllllIIIlllIIllIIlIlIllIll = lllllllllllIIIlllIIllIIlIlIllIll.offset(EnumFacing.NORTH);
                            lllllllllllIIIlllIIllIIlIlIllIlI = this.theWorld.getTileEntity(lllllllllllIIIlllIIllIIlIlIllIll);
                        }
                    }
                    final IBlockState lllllllllllIIIlllIIllIIlIlIllIII = this.theWorld.getBlockState(lllllllllllIIIlllIIllIIlIlIllIll);
                    if (lllllllllllIIIlllIIllIIlIlIllIlI == null || !lllllllllllIIIlllIIllIIlIlIllIII.func_191057_i()) {
                        continue;
                    }
                    if (lllllllllllIIIlllIIllIIlIllllIII) {
                        Shaders.nextBlockEntity(lllllllllllIIIlllIIllIIlIlIllIlI);
                    }
                    TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllIIIlllIIllIIlIlIllIlI, lllllllllllIIIlllIIllIIllIIIIllI, lllllllllllIIIlllIIllIIlIlIlllII.getPartialBlockDamage());
                }
            }
            this.postRenderDamagedBlocks();
            this.renderOverlayDamaged = false;
            this.mc.entityRenderer.disableLightmap();
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void drawSelectionBox(final EntityPlayer lllllllllllIIIlllIIlIlIlllIlllII, final RayTraceResult lllllllllllIIIlllIIlIlIlllIllIll, final int lllllllllllIIIlllIIlIlIlllIlIIII, final float lllllllllllIIIlllIIlIlIlllIIllll) {
        if (lllllllllllIIIlllIIlIlIlllIlIIII == 0 && lllllllllllIIIlllIIlIlIlllIllIll.typeOfHit == RayTraceResult.Type.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0f);
            GlStateManager.disableTexture2D();
            if (Config.isShaders()) {
                Shaders.disableTexture2D();
            }
            GlStateManager.depthMask(false);
            final BlockPos lllllllllllIIIlllIIlIlIlllIllIII = lllllllllllIIIlllIIlIlIlllIllIll.getBlockPos();
            final IBlockState lllllllllllIIIlllIIlIlIlllIlIlll = this.theWorld.getBlockState(lllllllllllIIIlllIIlIlIlllIllIII);
            if (lllllllllllIIIlllIIlIlIlllIlIlll.getMaterial() != Material.AIR && this.theWorld.getWorldBorder().contains(lllllllllllIIIlllIIlIlIlllIllIII)) {
                final double lllllllllllIIIlllIIlIlIlllIlIllI = lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosX + (lllllllllllIIIlllIIlIlIlllIlllII.posX - lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosX) * lllllllllllIIIlllIIlIlIlllIIllll;
                final double lllllllllllIIIlllIIlIlIlllIlIlIl = lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosY + (lllllllllllIIIlllIIlIlIlllIlllII.posY - lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosY) * lllllllllllIIIlllIIlIlIlllIIllll;
                final double lllllllllllIIIlllIIlIlIlllIlIlII = lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosZ + (lllllllllllIIIlllIIlIlIlllIlllII.posZ - lllllllllllIIIlllIIlIlIlllIlllII.lastTickPosZ) * lllllllllllIIIlllIIlIlIlllIIllll;
                drawSelectionBoundingBox(lllllllllllIIIlllIIlIlIlllIlIlll.getSelectedBoundingBox(this.theWorld, lllllllllllIIIlllIIlIlIlllIllIII).expandXyz(0.0020000000949949026).offset(-lllllllllllIIIlllIIlIlIlllIlIllI, -lllllllllllIIIlllIIlIlIlllIlIlIl, -lllllllllllIIIlllIIlIlIlllIlIlII), 0.0f, 0.0f, 0.0f, 0.4f);
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            if (Config.isShaders()) {
                Shaders.enableTexture2D();
            }
            GlStateManager.disableBlend();
        }
    }
    
    public int getCountActiveRenderers() {
        return this.renderInfos.size();
    }
    
    public WorldClient getWorld() {
        return this.theWorld;
    }
    
    private void updateDestroyBlockIcons() {
        final TextureMap lllllllllllIIIlllIIllIlIIllIllII = this.mc.getTextureMapBlocks();
        for (int lllllllllllIIIlllIIllIlIIllIlIll = 0; lllllllllllIIIlllIIllIlIIllIlIll < this.destroyBlockIcons.length; ++lllllllllllIIIlllIIllIlIIllIlIll) {
            this.destroyBlockIcons[lllllllllllIIIlllIIllIlIIllIlIll] = lllllllllllIIIlllIIllIlIIllIllII.getAtlasSprite("minecraft:blocks/destroy_stage_" + lllllllllllIIIlllIIllIlIIllIlIll);
        }
    }
    
    private void fixTerrainFrustum(final double lllllllllllIIIlllIIllIIIIllIllIl, final double lllllllllllIIIlllIIllIIIIllIIlII, final double lllllllllllIIIlllIIllIIIIllIIIll) {
        this.debugFixedClippingHelper = new ClippingHelperImpl();
        ((ClippingHelperImpl)this.debugFixedClippingHelper).init();
        final Matrix4f lllllllllllIIIlllIIllIIIIllIlIlI = new Matrix4f(this.debugFixedClippingHelper.modelviewMatrix);
        lllllllllllIIIlllIIllIIIIllIlIlI.transpose();
        final Matrix4f lllllllllllIIIlllIIllIIIIllIlIIl = new Matrix4f(this.debugFixedClippingHelper.projectionMatrix);
        lllllllllllIIIlllIIllIIIIllIlIIl.transpose();
        final Matrix4f lllllllllllIIIlllIIllIIIIllIlIII = new Matrix4f();
        Matrix4f.mul((org.lwjgl.util.vector.Matrix4f)lllllllllllIIIlllIIllIIIIllIlIIl, (org.lwjgl.util.vector.Matrix4f)lllllllllllIIIlllIIllIIIIllIlIlI, (org.lwjgl.util.vector.Matrix4f)lllllllllllIIIlllIIllIIIIllIlIII);
        lllllllllllIIIlllIIllIIIIllIlIII.invert();
        this.debugTerrainFrustumPosition.x = lllllllllllIIIlllIIllIIIIllIllIl;
        this.debugTerrainFrustumPosition.y = lllllllllllIIIlllIIllIIIIllIIlII;
        this.debugTerrainFrustumPosition.z = lllllllllllIIIlllIIllIIIIllIIIll;
        this.debugTerrainMatrix[0] = new Vector4f(-1.0f, -1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[1] = new Vector4f(1.0f, -1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[2] = new Vector4f(1.0f, 1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[3] = new Vector4f(-1.0f, 1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[4] = new Vector4f(-1.0f, -1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[5] = new Vector4f(1.0f, -1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[6] = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[7] = new Vector4f(-1.0f, 1.0f, 1.0f, 1.0f);
        for (int lllllllllllIIIlllIIllIIIIllIIlll = 0; lllllllllllIIIlllIIllIIIIllIIlll < 8; ++lllllllllllIIIlllIIllIIIIllIIlll) {
            Matrix4f.transform((org.lwjgl.util.vector.Matrix4f)lllllllllllIIIlllIIllIIIIllIlIII, this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll], this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll]);
            final Vector4f vector4f = this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll];
            vector4f.x /= this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll].w;
            final Vector4f vector4f2 = this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll];
            vector4f2.y /= this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll].w;
            final Vector4f vector4f3 = this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll];
            vector4f3.z /= this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll].w;
            this.debugTerrainMatrix[lllllllllllIIIlllIIllIIIIllIIlll].w = 1.0f;
        }
    }
    
    private void markBlocksForUpdate(final int lllllllllllIIIlllIIlIlIlIIIllIII, final int lllllllllllIIIlllIIlIlIlIIIlIlll, final int lllllllllllIIIlllIIlIlIlIIIlIllI, final int lllllllllllIIIlllIIlIlIlIIIlIlIl, final int lllllllllllIIIlllIIlIlIlIIIIllII, final int lllllllllllIIIlllIIlIlIlIIIlIIll, final boolean lllllllllllIIIlllIIlIlIlIIIIlIlI) {
        this.viewFrustum.markBlocksForUpdate(lllllllllllIIIlllIIlIlIlIIIllIII, lllllllllllIIIlllIIlIlIlIIIlIlll, lllllllllllIIIlllIIlIlIlIIIlIllI, lllllllllllIIIlllIIlIlIlIIIlIlIl, lllllllllllIIIlllIIlIlIlIIIIllII, lllllllllllIIIlllIIlIlIlIIIlIIll, lllllllllllIIIlllIIlIlIlIIIIlIlI);
    }
    
    @Nullable
    private Particle func_190571_b(final int lllllllllllIIIlllIIlIlIIIIIlllII, final boolean lllllllllllIIIlllIIlIlIIIIIIlIIl, final boolean lllllllllllIIIlllIIlIlIIIIIIlIII, final double lllllllllllIIIlllIIlIlIIIIIIIlll, final double lllllllllllIIIlllIIlIlIIIIIIIllI, final double lllllllllllIIIlllIIlIlIIIIIIIlIl, final double lllllllllllIIIlllIIlIlIIIIIlIllI, final double lllllllllllIIIlllIIlIlIIIIIIIIll, final double lllllllllllIIIlllIIlIlIIIIIIIIlI, final int... lllllllllllIIIlllIIlIlIIIIIIIIIl) {
        final Entity lllllllllllIIIlllIIlIlIIIIIlIIlI = this.mc.getRenderViewEntity();
        if (this.mc == null || lllllllllllIIIlllIIlIlIIIIIlIIlI == null || this.mc.effectRenderer == null) {
            return null;
        }
        final int lllllllllllIIIlllIIlIlIIIIIlIIIl = this.func_190572_a(lllllllllllIIIlllIIlIlIIIIIIlIII);
        final double lllllllllllIIIlllIIlIlIIIIIlIIII = lllllllllllIIIlllIIlIlIIIIIlIIlI.posX - lllllllllllIIIlllIIlIlIIIIIIIlll;
        final double lllllllllllIIIlllIIlIlIIIIIIllll = lllllllllllIIIlllIIlIlIIIIIlIIlI.posY - lllllllllllIIIlllIIlIlIIIIIIIllI;
        final double lllllllllllIIIlllIIlIlIIIIIIlllI = lllllllllllIIIlllIIlIlIIIIIlIIlI.posZ - lllllllllllIIIlllIIlIlIIIIIIIlIl;
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.EXPLOSION_HUGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.EXPLOSION_LARGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.EXPLOSION_NORMAL.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SUSPENDED.getParticleID() && !Config.isWaterParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SUSPENDED_DEPTH.getParticleID() && !Config.isVoidParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SMOKE_NORMAL.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SMOKE_LARGE.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SPELL_MOB.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SPELL.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SPELL_INSTANT.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.SPELL_WITCH.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.PORTAL.getParticleID() && !Config.isAnimatedPortal()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.FLAME.getParticleID() && !Config.isAnimatedFlame()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.REDSTONE.getParticleID() && !Config.isAnimatedRedstone()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.DRIP_WATER.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.DRIP_LAVA.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.FIREWORKS_SPARK.getParticleID() && !Config.isFireworkParticles()) {
            return null;
        }
        if (!lllllllllllIIIlllIIlIlIIIIIIlIIl) {
            double lllllllllllIIIlllIIlIlIIIIIIllIl = 1024.0;
            if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.CRIT.getParticleID()) {
                lllllllllllIIIlllIIlIlIIIIIIllIl = 38416.0;
            }
            if (lllllllllllIIIlllIIlIlIIIIIlIIII * lllllllllllIIIlllIIlIlIIIIIlIIII + lllllllllllIIIlllIIlIlIIIIIIllll * lllllllllllIIIlllIIlIlIIIIIIllll + lllllllllllIIIlllIIlIlIIIIIIlllI * lllllllllllIIIlllIIlIlIIIIIIlllI > lllllllllllIIIlllIIlIlIIIIIIllIl) {
                return null;
            }
            if (lllllllllllIIIlllIIlIlIIIIIlIIIl > 1) {
                return null;
            }
        }
        final Particle lllllllllllIIIlllIIlIlIIIIIIllII = this.mc.effectRenderer.spawnEffectParticle(lllllllllllIIIlllIIlIlIIIIIlllII, lllllllllllIIIlllIIlIlIIIIIIIlll, lllllllllllIIIlllIIlIlIIIIIIIllI, lllllllllllIIIlllIIlIlIIIIIIIlIl, lllllllllllIIIlllIIlIlIIIIIlIllI, lllllllllllIIIlllIIlIlIIIIIIIIll, lllllllllllIIIlllIIlIlIIIIIIIIlI, lllllllllllIIIlllIIlIlIIIIIIIIIl);
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.WATER_BUBBLE.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllIIIlllIIlIlIIIIIIllII, (IBlockAccess)this.theWorld, lllllllllllIIIlllIIlIlIIIIIIIlll, lllllllllllIIIlllIIlIlIIIIIIIllI, lllllllllllIIIlllIIlIlIIIIIIIlIl, this.renderEnv);
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.WATER_SPLASH.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllIIIlllIIlIlIIIIIIllII, (IBlockAccess)this.theWorld, lllllllllllIIIlllIIlIlIIIIIIIlll, lllllllllllIIIlllIIlIlIIIIIIIllI, lllllllllllIIIlllIIlIlIIIIIIIlIl, this.renderEnv);
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.WATER_DROP.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllIIIlllIIlIlIIIIIIllII, (IBlockAccess)this.theWorld, lllllllllllIIIlllIIlIlIIIIIIIlll, lllllllllllIIIlllIIlIlIIIIIIIllI, lllllllllllIIIlllIIlIlIIIIIIIlIl, this.renderEnv);
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.TOWN_AURA.getParticleID()) {
            CustomColors.updateMyceliumFX(lllllllllllIIIlllIIlIlIIIIIIllII);
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.PORTAL.getParticleID()) {
            CustomColors.updatePortalFX(lllllllllllIIIlllIIlIlIIIIIIllII);
        }
        if (lllllllllllIIIlllIIlIlIIIIIlllII == EnumParticleTypes.REDSTONE.getParticleID()) {
            CustomColors.updateReddustFX(lllllllllllIIIlllIIlIlIIIIIIllII, (IBlockAccess)this.theWorld, lllllllllllIIIlllIIlIlIIIIIIIlll, lllllllllllIIIlllIIlIlIIIIIIIllI, lllllllllllIIIlllIIlIlIIIIIIIlIl);
        }
        return lllllllllllIIIlllIIlIlIIIIIIllII;
    }
    
    private void func_193054_a(final World lllllllllllIIIlllIIlIlIIlIllllIl, final BlockPos lllllllllllIIIlllIIlIlIIllIIIIII, final boolean lllllllllllIIIlllIIlIlIIlIllllll) {
        for (final EntityLivingBase lllllllllllIIIlllIIlIlIIlIlllllI : lllllllllllIIIlllIIlIlIIlIllllIl.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, new AxisAlignedBB(lllllllllllIIIlllIIlIlIIllIIIIII).expandXyz(3.0))) {
            lllllllllllIIIlllIIlIlIIlIlllllI.func_191987_a(lllllllllllIIIlllIIlIlIIllIIIIII, lllllllllllIIIlllIIlIlIIlIllllll);
        }
    }
    
    public String getDebugInfoEntities() {
        return "E: " + this.countEntitiesRendered + "/" + this.countEntitiesTotal + ", B: " + this.countEntitiesHidden + ", " + Config.getVersionDebug();
    }
    
    public int getCountChunksToUpdate() {
        return this.chunksToUpdate.size();
    }
    
    public static void drawSelectionBoundingBox(final AxisAlignedBB lllllllllllIIIlllIIlIlIlllIIIlII, final float lllllllllllIIIlllIIlIlIlllIIIIll, final float lllllllllllIIIlllIIlIlIllIllllIl, final float lllllllllllIIIlllIIlIlIlllIIIIIl, final float lllllllllllIIIlllIIlIlIllIlllIll) {
        drawBoundingBox(lllllllllllIIIlllIIlIlIlllIIIlII.minX, lllllllllllIIIlllIIlIlIlllIIIlII.minY, lllllllllllIIIlllIIlIlIlllIIIlII.minZ, lllllllllllIIIlllIIlIlIlllIIIlII.maxX, lllllllllllIIIlllIIlIlIlllIIIlII.maxY, lllllllllllIIIlllIIlIlIlllIIIlII.maxZ, lllllllllllIIIlllIIlIlIlllIIIIll, lllllllllllIIIlllIIlIlIllIllllIl, lllllllllllIIIlllIIlIlIlllIIIIIl, lllllllllllIIIlllIIlIlIllIlllIll);
    }
    
    public static void drawBoundingBox(final BufferBuilder lllllllllllIIIlllIIlIlIllIIIIIII, final double lllllllllllIIIlllIIlIlIllIIIlIlI, final double lllllllllllIIIlllIIlIlIllIIIlIIl, final double lllllllllllIIIlllIIlIlIllIIIlIII, final double lllllllllllIIIlllIIlIlIllIIIIlll, final double lllllllllllIIIlllIIlIlIlIllllIlI, final double lllllllllllIIIlllIIlIlIlIllllIIl, final float lllllllllllIIIlllIIlIlIllIIIIlII, final float lllllllllllIIIlllIIlIlIlIlllIlll, final float lllllllllllIIIlllIIlIlIlIlllIllI, final float lllllllllllIIIlllIIlIlIllIIIIIIl) {
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, 0.0f).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIlIlI, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, 0.0f).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIlIllllIIl).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIlIllllIlI, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, 0.0f).endVertex();
        lllllllllllIIIlllIIlIlIllIIIIIII.pos(lllllllllllIIIlllIIlIlIllIIIIlll, lllllllllllIIIlllIIlIlIllIIIlIIl, lllllllllllIIIlllIIlIlIllIIIlIII).color(lllllllllllIIIlllIIlIlIllIIIIlII, lllllllllllIIIlllIIlIlIlIlllIlll, lllllllllllIIIlllIIlIlIlIlllIllI, lllllllllllIIIlllIIlIlIllIIIIIIl).endVertex();
    }
    
    public void renderWorldBorder(final Entity lllllllllllIIIlllIIlIllIIllIIlIl, final float lllllllllllIIIlllIIlIllIIllIIlII) {
        final Tessellator lllllllllllIIIlllIIlIllIIllIIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlllIIlIllIIllIIIlI = lllllllllllIIIlllIIlIllIIllIIIll.getBuffer();
        final WorldBorder lllllllllllIIIlllIIlIllIIllIIIIl = this.theWorld.getWorldBorder();
        final double lllllllllllIIIlllIIlIllIIllIIIII = this.mc.gameSettings.renderDistanceChunks * 16;
        if (lllllllllllIIIlllIIlIllIIllIIlIl.posX >= lllllllllllIIIlllIIlIllIIllIIIIl.maxX() - lllllllllllIIIlllIIlIllIIllIIIII || lllllllllllIIIlllIIlIllIIllIIlIl.posX <= lllllllllllIIIlllIIlIllIIllIIIIl.minX() + lllllllllllIIIlllIIlIllIIllIIIII || lllllllllllIIIlllIIlIllIIllIIlIl.posZ >= lllllllllllIIIlllIIlIllIIllIIIIl.maxZ() - lllllllllllIIIlllIIlIllIIllIIIII || lllllllllllIIIlllIIlIllIIllIIlIl.posZ <= lllllllllllIIIlllIIlIllIIllIIIIl.minZ() + lllllllllllIIIlllIIlIllIIllIIIII) {
            double lllllllllllIIIlllIIlIllIIlIlllll = 1.0 - lllllllllllIIIlllIIlIllIIllIIIIl.getClosestDistance(lllllllllllIIIlllIIlIllIIllIIlIl) / lllllllllllIIIlllIIlIllIIllIIIII;
            lllllllllllIIIlllIIlIllIIlIlllll = Math.pow(lllllllllllIIIlllIIlIllIIlIlllll, 4.0);
            final double lllllllllllIIIlllIIlIllIIlIllllI = lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosX + (lllllllllllIIIlllIIlIllIIllIIlIl.posX - lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosX) * lllllllllllIIIlllIIlIllIIllIIlII;
            final double lllllllllllIIIlllIIlIllIIlIlllIl = lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosY + (lllllllllllIIIlllIIlIllIIllIIlIl.posY - lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosY) * lllllllllllIIIlllIIlIllIIllIIlII;
            final double lllllllllllIIIlllIIlIllIIlIlllII = lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosZ + (lllllllllllIIIlllIIlIllIIllIIlIl.posZ - lllllllllllIIIlllIIlIllIIllIIlIl.lastTickPosZ) * lllllllllllIIIlllIIlIllIIllIIlII;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.renderEngine.bindTexture(RenderGlobal.FORCEFIELD_TEXTURES);
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            final int lllllllllllIIIlllIIlIllIIlIllIll = lllllllllllIIIlllIIlIllIIllIIIIl.getStatus().getID();
            final float lllllllllllIIIlllIIlIllIIlIllIlI = (lllllllllllIIIlllIIlIllIIlIllIll >> 16 & 0xFF) / 255.0f;
            final float lllllllllllIIIlllIIlIllIIlIllIIl = (lllllllllllIIIlllIIlIllIIlIllIll >> 8 & 0xFF) / 255.0f;
            final float lllllllllllIIIlllIIlIllIIlIllIII = (lllllllllllIIIlllIIlIllIIlIllIll & 0xFF) / 255.0f;
            GlStateManager.color(lllllllllllIIIlllIIlIllIIlIllIlI, lllllllllllIIIlllIIlIllIIlIllIIl, lllllllllllIIIlllIIlIllIIlIllIII, (float)lllllllllllIIIlllIIlIllIIlIlllll);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.enableAlpha();
            GlStateManager.disableCull();
            final float lllllllllllIIIlllIIlIllIIlIlIlll = Minecraft.getSystemTime() % 3000L / 3000.0f;
            final float lllllllllllIIIlllIIlIllIIlIlIllI = 0.0f;
            final float lllllllllllIIIlllIIlIllIIlIlIlIl = 0.0f;
            final float lllllllllllIIIlllIIlIllIIlIlIlII = 128.0f;
            lllllllllllIIIlllIIlIllIIllIIIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIIIlllIIlIllIIllIIIlI.setTranslation(-lllllllllllIIIlllIIlIllIIlIllllI, -lllllllllllIIIlllIIlIllIIlIlllIl, -lllllllllllIIIlllIIlIllIIlIlllII);
            double lllllllllllIIIlllIIlIllIIlIlIIll = Math.max(MathHelper.floor(lllllllllllIIIlllIIlIllIIlIlllII - lllllllllllIIIlllIIlIllIIllIIIII), lllllllllllIIIlllIIlIllIIllIIIIl.minZ());
            double lllllllllllIIIlllIIlIllIIlIlIIlI = Math.min(MathHelper.ceil(lllllllllllIIIlllIIlIllIIlIlllII + lllllllllllIIIlllIIlIllIIllIIIII), lllllllllllIIIlllIIlIllIIllIIIIl.maxZ());
            if (lllllllllllIIIlllIIlIllIIlIllllI > lllllllllllIIIlllIIlIllIIllIIIIl.maxX() - lllllllllllIIIlllIIlIllIIllIIIII) {
                float lllllllllllIIIlllIIlIllIIlIlIIIl = 0.0f;
                for (double lllllllllllIIIlllIIlIllIIlIlIIII = lllllllllllIIIlllIIlIllIIlIlIIll; lllllllllllIIIlllIIlIllIIlIlIIII < lllllllllllIIIlllIIlIllIIlIlIIlI; ++lllllllllllIIIlllIIlIllIIlIlIIII, lllllllllllIIIlllIIlIllIIlIlIIIl += 0.5f) {
                    final double lllllllllllIIIlllIIlIllIIlIIllll = Math.min(1.0, lllllllllllIIIlllIIlIllIIlIlIIlI - lllllllllllIIIlllIIlIllIIlIlIIII);
                    final float lllllllllllIIIlllIIlIllIIlIIlllI = (float)lllllllllllIIIlllIIlIllIIlIIllll * 0.5f;
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.maxX(), 256.0, lllllllllllIIIlllIIlIllIIlIlIIII).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIlIIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.maxX(), 256.0, lllllllllllIIIlllIIlIllIIlIlIIII + lllllllllllIIIlllIIlIllIIlIIllll).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlllI + lllllllllllIIIlllIIlIllIIlIlIIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.maxX(), 0.0, lllllllllllIIIlllIIlIllIIlIlIIII + lllllllllllIIIlllIIlIllIIlIIllll).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlllI + lllllllllllIIIlllIIlIllIIlIlIIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.maxX(), 0.0, lllllllllllIIIlllIIlIllIIlIlIIII).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIlIIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                }
            }
            if (lllllllllllIIIlllIIlIllIIlIllllI < lllllllllllIIIlllIIlIllIIllIIIIl.minX() + lllllllllllIIIlllIIlIllIIllIIIII) {
                float lllllllllllIIIlllIIlIllIIlIIllIl = 0.0f;
                for (double lllllllllllIIIlllIIlIllIIlIIllII = lllllllllllIIIlllIIlIllIIlIlIIll; lllllllllllIIIlllIIlIllIIlIIllII < lllllllllllIIIlllIIlIllIIlIlIIlI; ++lllllllllllIIIlllIIlIllIIlIIllII, lllllllllllIIIlllIIlIllIIlIIllIl += 0.5f) {
                    final double lllllllllllIIIlllIIlIllIIlIIlIll = Math.min(1.0, lllllllllllIIIlllIIlIllIIlIlIIlI - lllllllllllIIIlllIIlIllIIlIIllII);
                    final float lllllllllllIIIlllIIlIllIIlIIlIlI = (float)lllllllllllIIIlllIIlIllIIlIIlIll * 0.5f;
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.minX(), 256.0, lllllllllllIIIlllIIlIllIIlIIllII).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIllIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.minX(), 256.0, lllllllllllIIIlllIIlIllIIlIIllII + lllllllllllIIIlllIIlIllIIlIIlIll).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlIlI + lllllllllllIIIlllIIlIllIIlIIllIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.minX(), 0.0, lllllllllllIIIlllIIlIllIIlIIllII + lllllllllllIIIlllIIlIllIIlIIlIll).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlIlI + lllllllllllIIIlllIIlIllIIlIIllIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIllIIIIl.minX(), 0.0, lllllllllllIIIlllIIlIllIIlIIllII).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIllIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                }
            }
            lllllllllllIIIlllIIlIllIIlIlIIll = Math.max(MathHelper.floor(lllllllllllIIIlllIIlIllIIlIllllI - lllllllllllIIIlllIIlIllIIllIIIII), lllllllllllIIIlllIIlIllIIllIIIIl.minX());
            lllllllllllIIIlllIIlIllIIlIlIIlI = Math.min(MathHelper.ceil(lllllllllllIIIlllIIlIllIIlIllllI + lllllllllllIIIlllIIlIllIIllIIIII), lllllllllllIIIlllIIlIllIIllIIIIl.maxX());
            if (lllllllllllIIIlllIIlIllIIlIlllII > lllllllllllIIIlllIIlIllIIllIIIIl.maxZ() - lllllllllllIIIlllIIlIllIIllIIIII) {
                float lllllllllllIIIlllIIlIllIIlIIlIIl = 0.0f;
                for (double lllllllllllIIIlllIIlIllIIlIIlIII = lllllllllllIIIlllIIlIllIIlIlIIll; lllllllllllIIIlllIIlIllIIlIIlIII < lllllllllllIIIlllIIlIllIIlIlIIlI; ++lllllllllllIIIlllIIlIllIIlIIlIII, lllllllllllIIIlllIIlIllIIlIIlIIl += 0.5f) {
                    final double lllllllllllIIIlllIIlIllIIlIIIlll = Math.min(1.0, lllllllllllIIIlllIIlIllIIlIlIIlI - lllllllllllIIIlllIIlIllIIlIIlIII);
                    final float lllllllllllIIIlllIIlIllIIlIIIllI = (float)lllllllllllIIIlllIIlIllIIlIIIlll * 0.5f;
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIlIII, 256.0, lllllllllllIIIlllIIlIllIIllIIIIl.maxZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIlIII + lllllllllllIIIlllIIlIllIIlIIIlll, 256.0, lllllllllllIIIlllIIlIllIIllIIIIl.maxZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIllI + lllllllllllIIIlllIIlIllIIlIIlIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIlIII + lllllllllllIIIlllIIlIllIIlIIIlll, 0.0, lllllllllllIIIlllIIlIllIIllIIIIl.maxZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIllI + lllllllllllIIIlllIIlIllIIlIIlIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIlIII, 0.0, lllllllllllIIIlllIIlIllIIllIIIIl.maxZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIlIIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                }
            }
            if (lllllllllllIIIlllIIlIllIIlIlllII < lllllllllllIIIlllIIlIllIIllIIIIl.minZ() + lllllllllllIIIlllIIlIllIIllIIIII) {
                float lllllllllllIIIlllIIlIllIIlIIIlIl = 0.0f;
                for (double lllllllllllIIIlllIIlIllIIlIIIlII = lllllllllllIIIlllIIlIllIIlIlIIll; lllllllllllIIIlllIIlIllIIlIIIlII < lllllllllllIIIlllIIlIllIIlIlIIlI; ++lllllllllllIIIlllIIlIllIIlIIIlII, lllllllllllIIIlllIIlIllIIlIIIlIl += 0.5f) {
                    final double lllllllllllIIIlllIIlIllIIlIIIIll = Math.min(1.0, lllllllllllIIIlllIIlIllIIlIlIIlI - lllllllllllIIIlllIIlIllIIlIIIlII);
                    final float lllllllllllIIIlllIIlIllIIlIIIIlI = (float)lllllllllllIIIlllIIlIllIIlIIIIll * 0.5f;
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIIlII, 256.0, lllllllllllIIIlllIIlIllIIllIIIIl.minZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIlIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIIlII + lllllllllllIIIlllIIlIllIIlIIIIll, 256.0, lllllllllllIIIlllIIlIllIIllIIIIl.minZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIIlI + lllllllllllIIIlllIIlIllIIlIIIlIl, lllllllllllIIIlllIIlIllIIlIlIlll + 0.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIIlII + lllllllllllIIIlllIIlIllIIlIIIIll, 0.0, lllllllllllIIIlllIIlIllIIllIIIIl.minZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIIlI + lllllllllllIIIlllIIlIllIIlIIIlIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                    lllllllllllIIIlllIIlIllIIllIIIlI.pos(lllllllllllIIIlllIIlIllIIlIIIlII, 0.0, lllllllllllIIIlllIIlIllIIllIIIIl.minZ()).tex(lllllllllllIIIlllIIlIllIIlIlIlll + lllllllllllIIIlllIIlIllIIlIIIlIl, lllllllllllIIIlllIIlIllIIlIlIlll + 128.0f).endVertex();
                }
            }
            lllllllllllIIIlllIIlIllIIllIIIll.draw();
            lllllllllllIIIlllIIlIllIIllIIIlI.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableAlpha();
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.enableAlpha();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
        }
    }
    
    @Override
    public void sendBlockBreakProgress(final int lllllllllllIIIlllIIlIIllIlIIIIlI, final BlockPos lllllllllllIIIlllIIlIIllIlIIIIIl, final int lllllllllllIIIlllIIlIIllIlIIIlIl) {
        if (lllllllllllIIIlllIIlIIllIlIIIlIl >= 0 && lllllllllllIIIlllIIlIIllIlIIIlIl < 10) {
            DestroyBlockProgress lllllllllllIIIlllIIlIIllIlIIIlII = this.damagedBlocks.get(lllllllllllIIIlllIIlIIllIlIIIIlI);
            if (lllllllllllIIIlllIIlIIllIlIIIlII == null || lllllllllllIIIlllIIlIIllIlIIIlII.getPosition().getX() != lllllllllllIIIlllIIlIIllIlIIIIIl.getX() || lllllllllllIIIlllIIlIIllIlIIIlII.getPosition().getY() != lllllllllllIIIlllIIlIIllIlIIIIIl.getY() || lllllllllllIIIlllIIlIIllIlIIIlII.getPosition().getZ() != lllllllllllIIIlllIIlIIllIlIIIIIl.getZ()) {
                lllllllllllIIIlllIIlIIllIlIIIlII = new DestroyBlockProgress(lllllllllllIIIlllIIlIIllIlIIIIlI, lllllllllllIIIlllIIlIIllIlIIIIIl);
                this.damagedBlocks.put(lllllllllllIIIlllIIlIIllIlIIIIlI, lllllllllllIIIlllIIlIIllIlIIIlII);
            }
            lllllllllllIIIlllIIlIIllIlIIIlII.setPartialBlockDamage(lllllllllllIIIlllIIlIIllIlIIIlIl);
            lllllllllllIIIlllIIlIIllIlIIIlII.setCloudUpdateTick(this.cloudTickCounter);
        }
        else {
            this.damagedBlocks.remove(lllllllllllIIIlllIIlIIllIlIIIIlI);
        }
    }
    
    public void updateChunks(long lllllllllllIIIlllIIlIllIlIIIIllI) {
        lllllllllllIIIlllIIlIllIlIIIIllI = ((long)((lllllllllllIIIlllIIlIllIlIIIIllI ? 1 : 0) + 1.0E8) != 0L);
        this.displayListEntitiesDirty |= this.renderDispatcher.runChunkUploads(lllllllllllIIIlllIIlIllIlIIIIllI ? 1 : 0);
        if (this.chunksToUpdateForced.size() > 0) {
            final Iterator lllllllllllIIIlllIIlIllIlIIlIIlI = this.chunksToUpdateForced.iterator();
            while (lllllllllllIIIlllIIlIllIlIIlIIlI.hasNext()) {
                final RenderChunk lllllllllllIIIlllIIlIllIlIIlIIIl = lllllllllllIIIlllIIlIllIlIIlIIlI.next();
                if (!this.renderDispatcher.updateChunkLater(lllllllllllIIIlllIIlIllIlIIlIIIl)) {
                    break;
                }
                lllllllllllIIIlllIIlIllIlIIlIIIl.clearNeedsUpdate();
                lllllllllllIIIlllIIlIllIlIIlIIlI.remove();
                this.chunksToUpdate.remove(lllllllllllIIIlllIIlIllIlIIlIIIl);
                this.chunksToResortTransparency.remove(lllllllllllIIIlllIIlIllIlIIlIIIl);
            }
        }
        if (this.chunksToResortTransparency.size() > 0) {
            final Iterator lllllllllllIIIlllIIlIllIlIIlIIII = this.chunksToResortTransparency.iterator();
            if (lllllllllllIIIlllIIlIllIlIIlIIII.hasNext()) {
                final RenderChunk lllllllllllIIIlllIIlIllIlIIIllll = lllllllllllIIIlllIIlIllIlIIlIIII.next();
                if (this.renderDispatcher.updateTransparencyLater(lllllllllllIIIlllIIlIllIlIIIllll)) {
                    lllllllllllIIIlllIIlIllIlIIlIIII.remove();
                }
            }
        }
        int lllllllllllIIIlllIIlIllIlIIIlllI = 0;
        int lllllllllllIIIlllIIlIllIlIIIllIl = Config.getUpdatesPerFrame();
        final int lllllllllllIIIlllIIlIllIlIIIllII = lllllllllllIIIlllIIlIllIlIIIllIl * 2;
        if (!this.chunksToUpdate.isEmpty()) {
            final Iterator<RenderChunk> lllllllllllIIIlllIIlIllIlIIIlIll = this.chunksToUpdate.iterator();
            while (lllllllllllIIIlllIIlIllIlIIIlIll.hasNext()) {
                final RenderChunk lllllllllllIIIlllIIlIllIlIIIlIlI = lllllllllllIIIlllIIlIllIlIIIlIll.next();
                boolean lllllllllllIIIlllIIlIllIlIIIlIII = false;
                if (lllllllllllIIIlllIIlIllIlIIIlIlI.isNeedsUpdateCustom()) {
                    final boolean lllllllllllIIIlllIIlIllIlIIIlIIl = this.renderDispatcher.updateChunkNow(lllllllllllIIIlllIIlIllIlIIIlIlI);
                }
                else {
                    lllllllllllIIIlllIIlIllIlIIIlIII = this.renderDispatcher.updateChunkLater(lllllllllllIIIlllIIlIllIlIIIlIlI);
                }
                if (!lllllllllllIIIlllIIlIllIlIIIlIII) {
                    break;
                }
                lllllllllllIIIlllIIlIllIlIIIlIlI.clearNeedsUpdate();
                lllllllllllIIIlllIIlIllIlIIIlIll.remove();
                if (lllllllllllIIIlllIIlIllIlIIIlIlI.getCompiledChunk().isEmpty() && lllllllllllIIIlllIIlIllIlIIIllIl < lllllllllllIIIlllIIlIllIlIIIllII) {
                    ++lllllllllllIIIlllIIlIllIlIIIllIl;
                }
                if (++lllllllllllIIIlllIIlIllIlIIIlllI >= lllllllllllIIIlllIIlIllIlIIIllIl) {
                    break;
                }
            }
        }
    }
    
    public static class ContainerLocalRenderInformation
    {
        /* synthetic */ EnumFacing facing;
        /* synthetic */ boolean cacheable;
        /* synthetic */ RenderChunk renderChunk;
        /* synthetic */ int setFacing;
        
        public ContainerLocalRenderInformation(final RenderChunk llllllllllllIllIIIlIIllIIIlIIIIl, final EnumFacing llllllllllllIllIIIlIIllIIIIlllII, final int llllllllllllIllIIIlIIllIIIIllIll) {
            this.cacheable = false;
            this.renderChunk = llllllllllllIllIIIlIIllIIIlIIIIl;
            this.facing = llllllllllllIllIIIlIIllIIIIlllII;
            this.setFacing = llllllllllllIllIIIlIIllIIIIllIll;
        }
        
        public void setDirection(final byte llllllllllllIllIIIlIIllIIIIlIIll, final EnumFacing llllllllllllIllIIIlIIllIIIIlIlIl) {
            this.setFacing = (this.setFacing | llllllllllllIllIIIlIIllIIIIlIIll | 1 << llllllllllllIllIIIlIIllIIIIlIlIl.ordinal());
        }
        
        private void initialize(final RenderChunk llllllllllllIllIIIlIIllIIIIIIllI, final EnumFacing llllllllllllIllIIIlIIllIIIIIIIIl, final int llllllllllllIllIIIlIIllIIIIIIIII) {
            this.renderChunk = llllllllllllIllIIIlIIllIIIIIIllI;
            this.facing = llllllllllllIllIIIlIIllIIIIIIIIl;
            this.setFacing = llllllllllllIllIIIlIIllIIIIIIIII;
        }
        
        public boolean hasDirection(final EnumFacing llllllllllllIllIIIlIIllIIIIIllII) {
            return (this.setFacing & 1 << llllllllllllIllIIIlIIllIIIIIllII.ordinal()) > 0;
        }
    }
}
