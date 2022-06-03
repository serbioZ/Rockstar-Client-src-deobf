// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.ChunkCache;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.multiplayer.WorldClient;
import optifine.RenderEnv;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import optifine.ChunkCacheOF;
import java.util.HashSet;
import java.util.Collection;
import shadersmod.client.SVertexBuilder;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import optifine.ReflectorForge;
import optifine.BlockPosM;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.OpenGlHelper;
import optifine.Reflector;
import optifine.Config;
import net.minecraft.client.renderer.GLAllocation;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.GlStateManager;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.tileentity.TileEntity;
import java.util.Set;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.RenderGlobal;
import java.nio.FloatBuffer;

public class RenderChunk
{
    private final /* synthetic */ FloatBuffer modelviewMatrix;
    private /* synthetic */ boolean playerUpdate;
    private final /* synthetic */ RenderGlobal renderGlobal;
    private /* synthetic */ boolean needsUpdateCustom;
    public /* synthetic */ CompiledChunk compiledChunk;
    private final /* synthetic */ BlockPos.MutableBlockPos[] mapEnumFacing;
    private /* synthetic */ World world;
    private final /* synthetic */ BlockPos.MutableBlockPos position;
    private final /* synthetic */ int index;
    private /* synthetic */ ChunkCompileTaskGenerator compileTask;
    private final /* synthetic */ VertexBuffer[] vertexBuffers;
    private final /* synthetic */ Set<TileEntity> setTileEntities;
    private /* synthetic */ Chunk chunk;
    private static /* synthetic */ BlockRenderLayer[] ENUM_WORLD_BLOCK_LAYERS;
    private /* synthetic */ int frameIndex;
    public /* synthetic */ AxisAlignedBB boundingBox;
    private /* synthetic */ boolean fixBlockLayer;
    private final /* synthetic */ ReentrantLock lockCompileTask;
    private /* synthetic */ BlockRenderLayer[] blockLayersSingle;
    private /* synthetic */ RenderChunk[] renderChunksOfset16;
    public static /* synthetic */ int renderChunksUpdated;
    private final /* synthetic */ ReentrantLock lockCompiledChunk;
    private /* synthetic */ boolean needsUpdate;
    private /* synthetic */ boolean isMipmaps;
    
    static {
        RenderChunk.ENUM_WORLD_BLOCK_LAYERS = BlockRenderLayer.values();
    }
    
    public VertexBuffer getVertexBufferByLayer(final int llllllllllllIllIIlIIlIIlIllllIll) {
        return this.vertexBuffers[llllllllllllIllIIlIIlIIlIllllIll];
    }
    
    public Chunk getChunk(final World llllllllllllIllIIlIIlIIIIIlIIlII) {
        if (this.chunk != null && this.chunk.isLoaded()) {
            return this.chunk;
        }
        this.chunk = llllllllllllIllIIlIIlIIIIIlIIlII.getChunkFromBlockCoords(this.getPosition());
        return this.chunk;
    }
    
    private void initModelviewMatrix() {
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final float llllllllllllIllIIlIIlIIIlIlIIlll = 1.000001f;
        GlStateManager.translate(-8.0f, -8.0f, -8.0f);
        GlStateManager.scale(1.000001f, 1.000001f, 1.000001f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.getFloat(2982, this.modelviewMatrix);
        GlStateManager.popMatrix();
    }
    
    public BlockPos getBlockPosOffset16(final EnumFacing llllllllllllIllIIlIIlIIIIllllIII) {
        return this.mapEnumFacing[llllllllllllIllIIlIIlIIIIllllIII.ordinal()];
    }
    
    private void postRenderOverlays(final RegionRenderCacheBuilder llllllllllllIllIIlIIlIIIIlIlIlll, final CompiledChunk llllllllllllIllIIlIIlIIIIlIlIllI, final boolean[] llllllllllllIllIIlIIlIIIIlIlIlIl) {
        this.postRenderOverlay(BlockRenderLayer.CUTOUT, llllllllllllIllIIlIIlIIIIlIlIlll, llllllllllllIllIIlIIlIIIIlIlIllI, llllllllllllIllIIlIIlIIIIlIlIlIl);
        this.postRenderOverlay(BlockRenderLayer.CUTOUT_MIPPED, llllllllllllIllIIlIIlIIIIlIlIlll, llllllllllllIllIIlIIlIIIIlIlIllI, llllllllllllIllIIlIIlIIIIlIlIlIl);
        this.postRenderOverlay(BlockRenderLayer.TRANSLUCENT, llllllllllllIllIIlIIlIIIIlIlIlll, llllllllllllIllIIlIIlIIIIlIlIllI, llllllllllllIllIIlIIlIIIIlIlIlIl);
    }
    
    protected void finishCompileTask() {
        this.lockCompileTask.lock();
        try {
            if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
                this.compileTask.finish();
                this.compileTask = null;
            }
        }
        finally {
            this.lockCompileTask.unlock();
        }
        this.lockCompileTask.unlock();
    }
    
    public RenderChunk(final World llllllllllllIllIIlIIlIIllIIIlllI, final RenderGlobal llllllllllllIllIIlIIlIIllIIIllIl, final int llllllllllllIllIIlIIlIIllIIIllII) {
        this.compiledChunk = CompiledChunk.DUMMY;
        this.lockCompileTask = new ReentrantLock();
        this.lockCompiledChunk = new ReentrantLock();
        this.setTileEntities = (Set<TileEntity>)Sets.newHashSet();
        this.modelviewMatrix = GLAllocation.createDirectFloatBuffer(16);
        this.vertexBuffers = new VertexBuffer[BlockRenderLayer.values().length];
        this.frameIndex = -1;
        this.needsUpdate = true;
        this.position = new BlockPos.MutableBlockPos(-1, -1, -1);
        this.mapEnumFacing = new BlockPos.MutableBlockPos[6];
        this.blockLayersSingle = new BlockRenderLayer[1];
        this.isMipmaps = Config.isMipmaps();
        this.fixBlockLayer = !Reflector.BetterFoliageClient.exists();
        this.playerUpdate = false;
        this.renderChunksOfset16 = new RenderChunk[6];
        for (int llllllllllllIllIIlIIlIIllIIIlIll = 0; llllllllllllIllIIlIIlIIllIIIlIll < this.mapEnumFacing.length; ++llllllllllllIllIIlIIlIIllIIIlIll) {
            this.mapEnumFacing[llllllllllllIllIIlIIlIIllIIIlIll] = new BlockPos.MutableBlockPos();
        }
        this.world = llllllllllllIllIIlIIlIIllIIIlllI;
        this.renderGlobal = llllllllllllIllIIlIIlIIllIIIllIl;
        this.index = llllllllllllIllIIlIIlIIllIIIllII;
        if (OpenGlHelper.useVbo()) {
            for (int llllllllllllIllIIlIIlIIllIIIlIlI = 0; llllllllllllIllIIlIIlIIllIIIlIlI < BlockRenderLayer.values().length; ++llllllllllllIllIIlIIlIIllIIIlIlI) {
                this.vertexBuffers[llllllllllllIllIIlIIlIIllIIIlIlI] = new VertexBuffer(DefaultVertexFormats.BLOCK);
            }
        }
    }
    
    public void resortTransparency(final float llllllllllllIllIIlIIlIIlIlIlIlII, final float llllllllllllIllIIlIIlIIlIlIlIIll, final float llllllllllllIllIIlIIlIIlIlIllIIl, final ChunkCompileTaskGenerator llllllllllllIllIIlIIlIIlIlIllIII) {
        final CompiledChunk llllllllllllIllIIlIIlIIlIlIlIlll = llllllllllllIllIIlIIlIIlIlIllIII.getCompiledChunk();
        if (llllllllllllIllIIlIIlIIlIlIlIlll.getState() != null && !llllllllllllIllIIlIIlIIlIlIlIlll.isLayerEmpty(BlockRenderLayer.TRANSLUCENT)) {
            final BufferBuilder llllllllllllIllIIlIIlIIlIlIlIllI = llllllllllllIllIIlIIlIIlIlIllIII.getRegionRenderCacheBuilder().getWorldRendererByLayer(BlockRenderLayer.TRANSLUCENT);
            this.preRenderBlocks(llllllllllllIllIIlIIlIIlIlIlIllI, this.position);
            llllllllllllIllIIlIIlIIlIlIlIllI.setVertexState(llllllllllllIllIIlIIlIIlIlIlIlll.getState());
            this.postRenderBlocks(BlockRenderLayer.TRANSLUCENT, llllllllllllIllIIlIIlIIlIlIlIlII, llllllllllllIllIIlIIlIIlIlIlIIll, llllllllllllIllIIlIIlIIlIlIllIIl, llllllllllllIllIIlIIlIIlIlIlIllI, llllllllllllIllIIlIIlIIlIlIlIlll);
        }
    }
    
    @Nullable
    public ChunkCompileTaskGenerator makeCompileTaskTransparency() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //     8: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: ifnull          42
        //    14: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    15: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    18: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.getStatus:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    21: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.PENDING:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    24: if_acmpne       42
        //    27: aconst_null    
        //    28: astore_2        /* llllllllllllIllIIlIIlIIIllIllIlI */
        //    29: aload_2         /* llllllllllllIllIIlIIlIIIllIllIlI */
        //    30: astore          llllllllllllIllIIlIIlIIIllIlIlII
        //    32: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    33: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           llllllllllllIllIIlIIlIIIllIlIlII
        //    41: areturn        
        //    42: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    43: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    46: ifnull          74
        //    49: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    50: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    53: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.getStatus:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    56: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.DONE:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    59: if_acmpeq       74
        //    62: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    63: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    66: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.finish:()V
        //    69: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    70: aconst_null    
        //    71: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    74: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    75: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    78: dup            
        //    79: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    80: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.RESORT_TRANSPARENCY:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    83: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    84: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getDistanceSq:()D
        //    87: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;D)V
        //    90: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    93: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    94: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    97: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //    98: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compiledChunk:Lnet/minecraft/client/renderer/chunk/CompiledChunk;
        //   101: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.setCompiledChunk:(Lnet/minecraft/client/renderer/chunk/CompiledChunk;)V
        //   104: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //   105: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //   108: astore_2        /* llllllllllllIllIIlIIlIIIllIllIIl */
        //   109: aload_2         /* llllllllllllIllIIlIIlIIIllIllIIl */
        //   110: astore_1        /* llllllllllllIllIIlIIlIIIllIlllII */
        //   111: goto            124
        //   114: astore_3        /* llllllllllllIllIIlIIlIIIllIlIlIl */
        //   115: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //   116: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //   119: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   122: aload_3         /* llllllllllllIllIIlIIlIIIllIlIlIl */
        //   123: athrow         
        //   124: aload_0         /* llllllllllllIllIIlIIlIIIllIllIII */
        //   125: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //   128: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   131: aload_1         /* llllllllllllIllIIlIIlIIIllIllIll */
        //   132: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 01 73 00 00
        //    StackMapTable: 00 04 2A 1F 67 07 00 DA FD 00 09 07 00 08 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      32     114    124    Any
        //  42     114    114    124    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isNeedsUpdateCustom() {
        return this.needsUpdate && this.needsUpdateCustom;
    }
    
    private void resetChunkCache() {
        final int llllllllllllIllIIlIIlIIIlllIIlII = 1;
    }
    
    public void rebuildChunk(final float llllllllllllIllIIlIIlIIlIIIlIIIl, final float llllllllllllIllIIlIIlIIlIIIlIIII, final float llllllllllllIllIIlIIlIIlIIIIllll, final ChunkCompileTaskGenerator llllllllllllIllIIlIIlIIlIIIIlllI) {
        final CompiledChunk llllllllllllIllIIlIIlIIlIIlIlllI = new CompiledChunk();
        final int llllllllllllIllIIlIIlIIlIIlIllIl = 1;
        final BlockPos llllllllllllIllIIlIIlIIlIIlIllII = this.position;
        final BlockPos llllllllllllIllIIlIIlIIlIIlIlIll = llllllllllllIllIIlIIlIIlIIlIllII.add(15, 15, 15);
        llllllllllllIllIIlIIlIIlIIIIlllI.getLock().lock();
        try {
            if (llllllllllllIllIIlIIlIIlIIIIlllI.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                return;
            }
            llllllllllllIllIIlIIlIIlIIIIlllI.setCompiledChunk(llllllllllllIllIIlIIlIIlIIlIlllI);
        }
        finally {
            llllllllllllIllIIlIIlIIlIIIIlllI.getLock().unlock();
        }
        llllllllllllIllIIlIIlIIlIIIIlllI.getLock().unlock();
        final VisGraph llllllllllllIllIIlIIlIIlIIlIlIlI = new VisGraph();
        final HashSet llllllllllllIllIIlIIlIIlIIlIlIIl = Sets.newHashSet();
        if (this.world != null) {
            final ChunkCacheOF llllllllllllIllIIlIIlIIlIIlIlIII = this.makeChunkCacheOF();
            if (!llllllllllllIllIIlIIlIIlIIlIlIII.isEmpty()) {
                ++RenderChunk.renderChunksUpdated;
                llllllllllllIllIIlIIlIIlIIlIlIII.renderStart();
                final boolean[] llllllllllllIllIIlIIlIIlIIlIIlll = new boolean[RenderChunk.ENUM_WORLD_BLOCK_LAYERS.length];
                final BlockRendererDispatcher llllllllllllIllIIlIIlIIlIIlIIllI = Minecraft.getMinecraft().getBlockRendererDispatcher();
                final boolean llllllllllllIllIIlIIlIIlIIlIIlIl = Reflector.ForgeBlock_canRenderInLayer.exists();
                final boolean llllllllllllIllIIlIIlIIlIIlIIlII = Reflector.ForgeHooksClient_setRenderLayer.exists();
                for (final Object llllllllllllIllIIlIIlIIlIIlIIIll : BlockPosM.getAllInBoxMutable(llllllllllllIllIIlIIlIIlIIlIllII, llllllllllllIllIIlIIlIIlIIlIlIll)) {
                    final BlockPosM llllllllllllIllIIlIIlIIlIIlIIIlI = (BlockPosM)llllllllllllIllIIlIIlIIlIIlIIIll;
                    final IBlockState llllllllllllIllIIlIIlIIlIIlIIIIl = llllllllllllIllIIlIIlIIlIIlIlIII.getBlockState((BlockPos)llllllllllllIllIIlIIlIIlIIlIIIlI);
                    final Block llllllllllllIllIIlIIlIIlIIlIIIII = llllllllllllIllIIlIIlIIlIIlIIIIl.getBlock();
                    if (llllllllllllIllIIlIIlIIlIIlIIIIl.isOpaqueCube()) {
                        llllllllllllIllIIlIIlIIlIIlIlIlI.setOpaqueCube((BlockPos)llllllllllllIllIIlIIlIIlIIlIIIlI);
                    }
                    if (ReflectorForge.blockHasTileEntity(llllllllllllIllIIlIIlIIlIIlIIIIl)) {
                        final TileEntity llllllllllllIllIIlIIlIIlIIIlllll = llllllllllllIllIIlIIlIIlIIlIlIII.getTileEntity((BlockPos)llllllllllllIllIIlIIlIIlIIlIIIlI, Chunk.EnumCreateEntityType.CHECK);
                        if (llllllllllllIllIIlIIlIIlIIIlllll != null) {
                            final TileEntitySpecialRenderer<TileEntity> llllllllllllIllIIlIIlIIlIIIllllI = TileEntityRendererDispatcher.instance.getSpecialRenderer(llllllllllllIllIIlIIlIIlIIIlllll);
                            if (llllllllllllIllIIlIIlIIlIIIllllI != null) {
                                if (llllllllllllIllIIlIIlIIlIIIllllI.isGlobalRenderer(llllllllllllIllIIlIIlIIlIIIlllll)) {
                                    llllllllllllIllIIlIIlIIlIIlIlIIl.add(llllllllllllIllIIlIIlIIlIIIlllll);
                                }
                                else {
                                    llllllllllllIllIIlIIlIIlIIlIlllI.addTileEntity(llllllllllllIllIIlIIlIIlIIIlllll);
                                }
                            }
                        }
                    }
                    BlockRenderLayer[] llllllllllllIllIIlIIlIIlIIIlllII = null;
                    if (llllllllllllIllIIlIIlIIlIIlIIlIl) {
                        final BlockRenderLayer[] llllllllllllIllIIlIIlIIlIIIlllIl = RenderChunk.ENUM_WORLD_BLOCK_LAYERS;
                    }
                    else {
                        llllllllllllIllIIlIIlIIlIIIlllII = this.blockLayersSingle;
                        llllllllllllIllIIlIIlIIlIIIlllII[0] = llllllllllllIllIIlIIlIIlIIlIIIII.getBlockLayer();
                    }
                    for (int llllllllllllIllIIlIIlIIlIIIllIll = 0; llllllllllllIllIIlIIlIIlIIIllIll < llllllllllllIllIIlIIlIIlIIIlllII.length; ++llllllllllllIllIIlIIlIIlIIIllIll) {
                        BlockRenderLayer llllllllllllIllIIlIIlIIlIIIllIlI = llllllllllllIllIIlIIlIIlIIIlllII[llllllllllllIllIIlIIlIIlIIIllIll];
                        if (llllllllllllIllIIlIIlIIlIIlIIlIl) {
                            final boolean llllllllllllIllIIlIIlIIlIIIllIIl = Reflector.callBoolean((Object)llllllllllllIllIIlIIlIIlIIlIIIII, Reflector.ForgeBlock_canRenderInLayer, new Object[] { llllllllllllIllIIlIIlIIlIIlIIIIl, llllllllllllIllIIlIIlIIlIIIllIlI });
                            if (!llllllllllllIllIIlIIlIIlIIIllIIl) {
                                continue;
                            }
                        }
                        if (llllllllllllIllIIlIIlIIlIIlIIlII) {
                            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, new Object[] { llllllllllllIllIIlIIlIIlIIIllIlI });
                        }
                        if (this.fixBlockLayer) {
                            llllllllllllIllIIlIIlIIlIIIllIlI = this.fixBlockLayer(llllllllllllIllIIlIIlIIlIIlIIIII, llllllllllllIllIIlIIlIIlIIIllIlI);
                        }
                        final int llllllllllllIllIIlIIlIIlIIIllIII = llllllllllllIllIIlIIlIIlIIIllIlI.ordinal();
                        if (llllllllllllIllIIlIIlIIlIIlIIIII.getDefaultState().getRenderType() != EnumBlockRenderType.INVISIBLE) {
                            final BufferBuilder llllllllllllIllIIlIIlIIlIIIlIlll = llllllllllllIllIIlIIlIIlIIIIlllI.getRegionRenderCacheBuilder().getWorldRendererByLayerId(llllllllllllIllIIlIIlIIlIIIllIII);
                            llllllllllllIllIIlIIlIIlIIIlIlll.setBlockLayer(llllllllllllIllIIlIIlIIlIIIllIlI);
                            final RenderEnv llllllllllllIllIIlIIlIIlIIIlIllI = llllllllllllIllIIlIIlIIlIIIlIlll.getRenderEnv((IBlockAccess)llllllllllllIllIIlIIlIIlIIlIlIII, llllllllllllIllIIlIIlIIlIIlIIIIl, (BlockPos)llllllllllllIllIIlIIlIIlIIlIIIlI);
                            llllllllllllIllIIlIIlIIlIIIlIllI.setRegionRenderCacheBuilder(llllllllllllIllIIlIIlIIlIIIIlllI.getRegionRenderCacheBuilder());
                            if (!llllllllllllIllIIlIIlIIlIIlIlllI.isLayerStarted(llllllllllllIllIIlIIlIIlIIIllIlI)) {
                                llllllllllllIllIIlIIlIIlIIlIlllI.setLayerStarted(llllllllllllIllIIlIIlIIlIIIllIlI);
                                this.preRenderBlocks(llllllllllllIllIIlIIlIIlIIIlIlll, llllllllllllIllIIlIIlIIlIIlIllII);
                            }
                            final boolean[] array = llllllllllllIllIIlIIlIIlIIlIIlll;
                            final int n = llllllllllllIllIIlIIlIIlIIIllIII;
                            array[n] |= llllllllllllIllIIlIIlIIlIIlIIllI.renderBlock(llllllllllllIllIIlIIlIIlIIlIIIIl, (BlockPos)llllllllllllIllIIlIIlIIlIIlIIIlI, (IBlockAccess)llllllllllllIllIIlIIlIIlIIlIlIII, llllllllllllIllIIlIIlIIlIIIlIlll);
                            if (llllllllllllIllIIlIIlIIlIIIlIllI.isOverlaysRendered()) {
                                this.postRenderOverlays(llllllllllllIllIIlIIlIIlIIIIlllI.getRegionRenderCacheBuilder(), llllllllllllIllIIlIIlIIlIIlIlllI, llllllllllllIllIIlIIlIIlIIlIIlll);
                                llllllllllllIllIIlIIlIIlIIIlIllI.setOverlaysRendered(false);
                            }
                        }
                    }
                    if (llllllllllllIllIIlIIlIIlIIlIIlII) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_setRenderLayer, (Object[])null);
                    }
                }
                final BlockRenderLayer[] enum_WORLD_BLOCK_LAYERS;
                final String llllllllllllIllIIlIIlIIlIIIIIIII = (String)(enum_WORLD_BLOCK_LAYERS = RenderChunk.ENUM_WORLD_BLOCK_LAYERS).length;
                for (char llllllllllllIllIIlIIlIIlIIIIIIIl = '\0'; llllllllllllIllIIlIIlIIlIIIIIIIl < llllllllllllIllIIlIIlIIlIIIIIIII; ++llllllllllllIllIIlIIlIIlIIIIIIIl) {
                    final BlockRenderLayer llllllllllllIllIIlIIlIIlIIIlIlIl = enum_WORLD_BLOCK_LAYERS[llllllllllllIllIIlIIlIIlIIIIIIIl];
                    if (llllllllllllIllIIlIIlIIlIIlIIlll[llllllllllllIllIIlIIlIIlIIIlIlIl.ordinal()]) {
                        llllllllllllIllIIlIIlIIlIIlIlllI.setLayerUsed(llllllllllllIllIIlIIlIIlIIIlIlIl);
                    }
                    if (llllllllllllIllIIlIIlIIlIIlIlllI.isLayerStarted(llllllllllllIllIIlIIlIIlIIIlIlIl)) {
                        if (Config.isShaders()) {
                            SVertexBuilder.calcNormalChunkLayer(llllllllllllIllIIlIIlIIlIIIIlllI.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllIllIIlIIlIIlIIIlIlIl));
                        }
                        this.postRenderBlocks(llllllllllllIllIIlIIlIIlIIIlIlIl, llllllllllllIllIIlIIlIIlIIIlIIIl, llllllllllllIllIIlIIlIIlIIIlIIII, llllllllllllIllIIlIIlIIlIIIIllll, llllllllllllIllIIlIIlIIlIIIIlllI.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllIllIIlIIlIIlIIIlIlIl), llllllllllllIllIIlIIlIIlIIlIlllI);
                    }
                }
                llllllllllllIllIIlIIlIIlIIlIlIII.renderFinish();
            }
            llllllllllllIllIIlIIlIIlIIlIlllI.setVisibility(llllllllllllIllIIlIIlIIlIIlIlIlI.computeVisibility());
            this.lockCompileTask.lock();
            try {
                final Set<TileEntity> llllllllllllIllIIlIIlIIlIIIlIlII = (Set<TileEntity>)Sets.newHashSet((Iterable)llllllllllllIllIIlIIlIIlIIlIlIIl);
                final Set<TileEntity> llllllllllllIllIIlIIlIIlIIIlIIll = (Set<TileEntity>)Sets.newHashSet((Iterable)this.setTileEntities);
                llllllllllllIllIIlIIlIIlIIIlIlII.removeAll(this.setTileEntities);
                llllllllllllIllIIlIIlIIlIIIlIIll.removeAll(llllllllllllIllIIlIIlIIlIIlIlIIl);
                this.setTileEntities.clear();
                this.setTileEntities.addAll(llllllllllllIllIIlIIlIIlIIlIlIIl);
                this.renderGlobal.updateTileEntities(llllllllllllIllIIlIIlIIlIIIlIIll, llllllllllllIllIIlIIlIIlIIIlIlII);
            }
            finally {
                this.lockCompileTask.unlock();
            }
            this.lockCompileTask.unlock();
        }
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }
    
    public ReentrantLock getLockCompileTask() {
        return this.lockCompileTask;
    }
    
    private boolean isWorldPlayerUpdate() {
        if (this.world instanceof WorldClient) {
            final WorldClient llllllllllllIllIIlIIlIIIIllIllll = (WorldClient)this.world;
            return llllllllllllIllIIlIIlIIIIllIllll.isPlayerUpdate();
        }
        return false;
    }
    
    public RenderChunk getRenderChunkOffset16(final ViewFrustum llllllllllllIllIIlIIlIIIIIllIIlI, final EnumFacing llllllllllllIllIIlIIlIIIIIllIIIl) {
        RenderChunk llllllllllllIllIIlIIlIIIIIllIIII = this.renderChunksOfset16[llllllllllllIllIIlIIlIIIIIllIIIl.ordinal()];
        if (llllllllllllIllIIlIIlIIIIIllIIII == null) {
            final BlockPos llllllllllllIllIIlIIlIIIIIlIllll = this.getBlockPosOffset16(llllllllllllIllIIlIIlIIIIIllIIIl);
            llllllllllllIllIIlIIlIIIIIllIIII = llllllllllllIllIIlIIlIIIIIllIIlI.getRenderChunk(llllllllllllIllIIlIIlIIIIIlIllll);
            this.renderChunksOfset16[llllllllllllIllIIlIIlIIIIIllIIIl.ordinal()] = llllllllllllIllIIlIIlIIIIIllIIII;
        }
        return llllllllllllIllIIlIIlIIIIIllIIII;
    }
    
    private void preRenderBlocks(final BufferBuilder llllllllllllIllIIlIIlIIIllIIIIIl, final BlockPos llllllllllllIllIIlIIlIIIllIIIIII) {
        llllllllllllIllIIlIIlIIIllIIIIIl.begin(7, DefaultVertexFormats.BLOCK);
        llllllllllllIllIIlIIlIIIllIIIIIl.setTranslation(-llllllllllllIllIIlIIlIIIllIIIIII.getX(), -llllllllllllIllIIlIIlIIIllIIIIII.getY(), -llllllllllllIllIIlIIlIIIllIIIIII.getZ());
    }
    
    public boolean setFrameIndex(final int llllllllllllIllIIlIIlIIllIIIIIIl) {
        if (this.frameIndex == llllllllllllIllIIlIIlIIllIIIIIIl) {
            return false;
        }
        this.frameIndex = llllllllllllIllIIlIIlIIllIIIIIIl;
        return true;
    }
    
    public void deleteGlResources() {
        this.stopCompileTask();
        this.world = null;
        for (int llllllllllllIllIIlIIlIIIlIIlIIII = 0; llllllllllllIllIIlIIlIIIlIIlIIII < BlockRenderLayer.values().length; ++llllllllllllIllIIlIIlIIIlIIlIIII) {
            if (this.vertexBuffers[llllllllllllIllIIlIIlIIIlIIlIIII] != null) {
                this.vertexBuffers[llllllllllllIllIIlIIlIIIlIIlIIII].deleteGlBuffers();
            }
        }
    }
    
    private void postRenderOverlay(final BlockRenderLayer llllllllllllIllIIlIIlIIIIlIIlllI, final RegionRenderCacheBuilder llllllllllllIllIIlIIlIIIIlIIllIl, final CompiledChunk llllllllllllIllIIlIIlIIIIlIIIlll, final boolean[] llllllllllllIllIIlIIlIIIIlIIIllI) {
        final BufferBuilder llllllllllllIllIIlIIlIIIIlIIlIlI = llllllllllllIllIIlIIlIIIIlIIllIl.getWorldRendererByLayer(llllllllllllIllIIlIIlIIIIlIIlllI);
        if (llllllllllllIllIIlIIlIIIIlIIlIlI.isDrawing()) {
            llllllllllllIllIIlIIlIIIIlIIIlll.setLayerStarted(llllllllllllIllIIlIIlIIIIlIIlllI);
            llllllllllllIllIIlIIlIIIIlIIIllI[llllllllllllIllIIlIIlIIIIlIIlllI.ordinal()] = true;
        }
    }
    
    private void postRenderBlocks(final BlockRenderLayer llllllllllllIllIIlIIlIIIlIllIIII, final float llllllllllllIllIIlIIlIIIlIlIllll, final float llllllllllllIllIIlIIlIIIlIllIlII, final float llllllllllllIllIIlIIlIIIlIllIIll, final BufferBuilder llllllllllllIllIIlIIlIIIlIlIllII, final CompiledChunk llllllllllllIllIIlIIlIIIlIllIIIl) {
        if (llllllllllllIllIIlIIlIIIlIllIIII == BlockRenderLayer.TRANSLUCENT && !llllllllllllIllIIlIIlIIIlIllIIIl.isLayerEmpty(llllllllllllIllIIlIIlIIIlIllIIII)) {
            llllllllllllIllIIlIIlIIIlIlIllII.sortVertexData(llllllllllllIllIIlIIlIIIlIlIllll, llllllllllllIllIIlIIlIIIlIllIlII, llllllllllllIllIIlIIlIIIlIllIIll);
            llllllllllllIllIIlIIlIIIlIllIIIl.setState(llllllllllllIllIIlIIlIIIlIlIllII.getVertexState());
        }
        llllllllllllIllIIlIIlIIIlIlIllII.finishDrawing();
    }
    
    protected ChunkCache createRegionRenderCache(final World llllllllllllIllIIlIIlIIIIIIllIlI, final BlockPos llllllllllllIllIIlIIlIIIIIIllIIl, final BlockPos llllllllllllIllIIlIIlIIIIIIlllII, final int llllllllllllIllIIlIIlIIIIIIllIll) {
        return new ChunkCache(llllllllllllIllIIlIIlIIIIIIllIlI, llllllllllllIllIIlIIlIIIIIIllIIl, llllllllllllIllIIlIIlIIIIIIlllII, llllllllllllIllIIlIIlIIIIIIllIll);
    }
    
    public void setNeedsUpdate(boolean llllllllllllIllIIlIIlIIIlIIIIlIl) {
        if (this.needsUpdate) {
            llllllllllllIllIIlIIlIIIlIIIIlIl |= (this.needsUpdateCustom ? 1 : 0);
        }
        this.needsUpdate = true;
        this.needsUpdateCustom = (llllllllllllIllIIlIIlIIIlIIIIlIl != 0);
        if (this.isWorldPlayerUpdate()) {
            this.playerUpdate = true;
        }
    }
    
    public void setPosition(final int llllllllllllIllIIlIIlIIlIllIllll, final int llllllllllllIllIIlIIlIIlIllIlIIl, final int llllllllllllIllIIlIIlIIlIllIllIl) {
        if (llllllllllllIllIIlIIlIIlIllIllll != this.position.getX() || llllllllllllIllIIlIIlIIlIllIlIIl != this.position.getY() || llllllllllllIllIIlIIlIIlIllIllIl != this.position.getZ()) {
            this.stopCompileTask();
            this.position.setPos(llllllllllllIllIIlIIlIIlIllIllll, llllllllllllIllIIlIIlIIlIllIlIIl, llllllllllllIllIIlIIlIIlIllIllIl);
            this.boundingBox = new AxisAlignedBB(llllllllllllIllIIlIIlIIlIllIllll, llllllllllllIllIIlIIlIIlIllIlIIl, llllllllllllIllIIlIIlIIlIllIllIl, llllllllllllIllIIlIIlIIlIllIllll + 16, llllllllllllIllIIlIIlIIlIllIlIIl + 16, llllllllllllIllIIlIIlIIlIllIllIl + 16);
            final Exception llllllllllllIllIIlIIlIIlIllIIlII;
            final byte llllllllllllIllIIlIIlIIlIllIIlIl = (byte)((EnumFacing[])(Object)(llllllllllllIllIIlIIlIIlIllIIlII = (Exception)(Object)EnumFacing.VALUES)).length;
            for (long llllllllllllIllIIlIIlIIlIllIIllI = 0; llllllllllllIllIIlIIlIIlIllIIllI < llllllllllllIllIIlIIlIIlIllIIlIl; ++llllllllllllIllIIlIIlIIlIllIIllI) {
                final EnumFacing llllllllllllIllIIlIIlIIlIllIllII = llllllllllllIllIIlIIlIIlIllIIlII[llllllllllllIllIIlIIlIIlIllIIllI];
                this.mapEnumFacing[llllllllllllIllIIlIIlIIlIllIllII.ordinal()].setPos(this.position).move(llllllllllllIllIIlIIlIIlIllIllII, 16);
                this.renderChunksOfset16[llllllllllllIllIIlIIlIIlIllIllII.ordinal()] = null;
            }
            this.chunk = null;
            this.initModelviewMatrix();
        }
    }
    
    public boolean isNeedsUpdate() {
        return this.needsUpdate;
    }
    
    private ChunkCacheOF makeChunkCacheOF() {
        final BlockPos llllllllllllIllIIlIIlIIIIIllllll = this.position.add(-1, -1, -1);
        final ChunkCache llllllllllllIllIIlIIlIIIIIlllllI = this.createRegionRenderCache(this.world, llllllllllllIllIIlIIlIIIIIllllll, this.position.add(16, 16, 16), 1);
        if (Reflector.MinecraftForgeClient_onRebuildChunk.exists()) {
            Reflector.call(Reflector.MinecraftForgeClient_onRebuildChunk, new Object[] { this.world, this.position, llllllllllllIllIIlIIlIIIIIlllllI });
        }
        final ChunkCacheOF llllllllllllIllIIlIIlIIIIIllllIl = new ChunkCacheOF(llllllllllllIllIIlIIlIIIIIlllllI, llllllllllllIllIIlIIlIIIIIllllll, 1);
        return llllllllllllIllIIlIIlIIIIIllllIl;
    }
    
    protected double getDistanceSq() {
        final EntityPlayerSP llllllllllllIllIIlIIlIIIllIIllIl = Minecraft.getMinecraft().player;
        final double llllllllllllIllIIlIIlIIIllIIllII = this.boundingBox.minX + 8.0 - llllllllllllIllIIlIIlIIIllIIllIl.posX;
        final double llllllllllllIllIIlIIlIIIllIIlIll = this.boundingBox.minY + 8.0 - llllllllllllIllIIlIIlIIIllIIllIl.posY;
        final double llllllllllllIllIIlIIlIIIllIIlIlI = this.boundingBox.minZ + 8.0 - llllllllllllIllIIlIIlIIIllIIllIl.posZ;
        return llllllllllllIllIIlIIlIIIllIIllII * llllllllllllIllIIlIIlIIIllIIllII + llllllllllllIllIIlIIlIIIllIIlIll * llllllllllllIllIIlIIlIIIllIIlIll + llllllllllllIllIIlIIlIIIllIIlIlI * llllllllllllIllIIlIIlIIIllIIlIlI;
    }
    
    private BlockRenderLayer fixBlockLayer(final Block llllllllllllIllIIlIIlIIIIllIIlIl, final BlockRenderLayer llllllllllllIllIIlIIlIIIIllIIIIl) {
        if (this.isMipmaps) {
            if (llllllllllllIllIIlIIlIIIIllIIIIl == BlockRenderLayer.CUTOUT) {
                if (llllllllllllIllIIlIIlIIIIllIIlIl instanceof BlockRedstoneWire) {
                    return llllllllllllIllIIlIIlIIIIllIIIIl;
                }
                if (llllllllllllIllIIlIIlIIIIllIIlIl instanceof BlockCactus) {
                    return llllllllllllIllIIlIIlIIIIllIIIIl;
                }
                return BlockRenderLayer.CUTOUT_MIPPED;
            }
        }
        else if (llllllllllllIllIIlIIlIIIIllIIIIl == BlockRenderLayer.CUTOUT_MIPPED) {
            return BlockRenderLayer.CUTOUT;
        }
        return llllllllllllIllIIlIIlIIIIllIIIIl;
    }
    
    public void clearNeedsUpdate() {
        this.needsUpdate = false;
        this.needsUpdateCustom = false;
        this.playerUpdate = false;
    }
    
    public World getWorld() {
        return this.world;
    }
    
    public void stopCompileTask() {
        this.finishCompileTask();
        this.compiledChunk = CompiledChunk.DUMMY;
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    public ChunkCompileTaskGenerator makeCompileTaskChunk() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.finishCompileTask:()V
        //    11: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    12: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    15: dup            
        //    16: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    17: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.REBUILD_CHUNK:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    20: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    21: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getDistanceSq:()D
        //    24: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;D)V
        //    27: putfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    30: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    31: invokespecial   net/minecraft/client/renderer/chunk/RenderChunk.resetChunkCache:()V
        //    34: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    35: getfield        net/minecraft/client/renderer/chunk/RenderChunk.compileTask:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    38: astore_1        /* llllllllllllIllIIlIIlIIIlllIlIll */
        //    39: goto            52
        //    42: astore_2        /* llllllllllllIllIIlIIlIIIlllIIlll */
        //    43: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    44: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    47: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    50: aload_2         /* llllllllllllIllIIlIIlIIIlllIIlll */
        //    51: athrow         
        //    52: aload_0         /* llllllllllllIllIIlIIlIIIlllIlIIl */
        //    53: getfield        net/minecraft/client/renderer/chunk/RenderChunk.lockCompileTask:Ljava/util/concurrent/locks/ReentrantLock;
        //    56: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    59: aload_1         /* llllllllllllIllIIlIIlIIIlllIlIlI */
        //    60: areturn        
        //    StackMapTable: 00 02 6A 07 00 DA FC 00 09 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      42     42     52     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void multModelviewMatrix() {
        GlStateManager.multMatrix(this.modelviewMatrix);
    }
    
    public void setCompiledChunk(final CompiledChunk llllllllllllIllIIlIIlIIIlIIllIII) {
        this.lockCompiledChunk.lock();
        try {
            this.compiledChunk = llllllllllllIllIIlIIlIIIlIIllIII;
        }
        finally {
            this.lockCompiledChunk.unlock();
        }
        this.lockCompiledChunk.unlock();
    }
}
