// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.crash.CrashReport;
import java.util.concurrent.CancellationException;
import java.util.List;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Futures;
import net.minecraft.util.BlockRenderLayer;
import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3i;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import org.apache.logging.log4j.Logger;

public class ChunkRenderWorker implements Runnable
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ RegionRenderCacheBuilder regionRenderCacheBuilder;
    private /* synthetic */ boolean shouldRun;
    private final /* synthetic */ ChunkRenderDispatcher chunkRenderDispatcher;
    
    protected void processTask(final ChunkCompileTaskGenerator llllllllllllIlIIIIIIlllllIIlIllI) throws InterruptedException {
        llllllllllllIlIIIIIIlllllIIlIllI.getLock().lock();
        try {
            if (llllllllllllIlIIIIIIlllllIIlIllI.getStatus() != ChunkCompileTaskGenerator.Status.PENDING) {
                if (!llllllllllllIlIIIIIIlllllIIlIllI.isFinished()) {
                    ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be pending; ignoring task", (Object)llllllllllllIlIIIIIIlllllIIlIllI.getStatus());
                }
                return;
            }
            final BlockPos llllllllllllIlIIIIIIlllllIIlIlIl = new BlockPos(Minecraft.getMinecraft().player);
            final BlockPos llllllllllllIlIIIIIIlllllIIlIlII = llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk().getPosition();
            final int llllllllllllIlIIIIIIlllllIIlIIll = 16;
            final int llllllllllllIlIIIIIIlllllIIlIIlI = 8;
            final int llllllllllllIlIIIIIIlllllIIlIIIl = 24;
            if (llllllllllllIlIIIIIIlllllIIlIlII.add(8, 8, 8).distanceSq(llllllllllllIlIIIIIIlllllIIlIlIl) > 576.0) {
                final World llllllllllllIlIIIIIIlllllIIlIIII = llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk().getWorld();
                final BlockPos.MutableBlockPos llllllllllllIlIIIIIIlllllIIIllll = new BlockPos.MutableBlockPos(llllllllllllIlIIIIIIlllllIIlIlII);
                if (!this.isChunkExisting(llllllllllllIlIIIIIIlllllIIIllll.setPos(llllllllllllIlIIIIIIlllllIIlIlII).move(EnumFacing.WEST, 16), llllllllllllIlIIIIIIlllllIIlIIII) || !this.isChunkExisting(llllllllllllIlIIIIIIlllllIIIllll.setPos(llllllllllllIlIIIIIIlllllIIlIlII).move(EnumFacing.NORTH, 16), llllllllllllIlIIIIIIlllllIIlIIII) || !this.isChunkExisting(llllllllllllIlIIIIIIlllllIIIllll.setPos(llllllllllllIlIIIIIIlllllIIlIlII).move(EnumFacing.EAST, 16), llllllllllllIlIIIIIIlllllIIlIIII) || !this.isChunkExisting(llllllllllllIlIIIIIIlllllIIIllll.setPos(llllllllllllIlIIIIIIlllllIIlIlII).move(EnumFacing.SOUTH, 16), llllllllllllIlIIIIIIlllllIIlIIII)) {
                    return;
                }
            }
            llllllllllllIlIIIIIIlllllIIlIllI.setStatus(ChunkCompileTaskGenerator.Status.COMPILING);
        }
        finally {
            llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
        }
        llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
        final Entity llllllllllllIlIIIIIIlllllIIIlllI = Minecraft.getMinecraft().getRenderViewEntity();
        if (llllllllllllIlIIIIIIlllllIIIlllI == null) {
            llllllllllllIlIIIIIIlllllIIlIllI.finish();
        }
        else {
            llllllllllllIlIIIIIIlllllIIlIllI.setRegionRenderCacheBuilder(this.getRegionRenderCacheBuilder());
            final float llllllllllllIlIIIIIIlllllIIIllIl = (float)llllllllllllIlIIIIIIlllllIIIlllI.posX;
            final float llllllllllllIlIIIIIIlllllIIIllII = (float)llllllllllllIlIIIIIIlllllIIIlllI.posY + llllllllllllIlIIIIIIlllllIIIlllI.getEyeHeight();
            final float llllllllllllIlIIIIIIlllllIIIlIll = (float)llllllllllllIlIIIIIIlllllIIIlllI.posZ;
            final ChunkCompileTaskGenerator.Type llllllllllllIlIIIIIIlllllIIIlIlI = llllllllllllIlIIIIIIlllllIIlIllI.getType();
            if (llllllllllllIlIIIIIIlllllIIIlIlI == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk().rebuildChunk(llllllllllllIlIIIIIIlllllIIIllIl, llllllllllllIlIIIIIIlllllIIIllII, llllllllllllIlIIIIIIlllllIIIlIll, llllllllllllIlIIIIIIlllllIIlIllI);
            }
            else if (llllllllllllIlIIIIIIlllllIIIlIlI == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk().resortTransparency(llllllllllllIlIIIIIIlllllIIIllIl, llllllllllllIlIIIIIIlllllIIIllII, llllllllllllIlIIIIIIlllllIIIlIll, llllllllllllIlIIIIIIlllllIIlIllI);
            }
            llllllllllllIlIIIIIIlllllIIlIllI.getLock().lock();
            try {
                if (llllllllllllIlIIIIIIlllllIIlIllI.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                    if (!llllllllllllIlIIIIIIlllllIIlIllI.isFinished()) {
                        ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be compiling; aborting task", (Object)llllllllllllIlIIIIIIlllllIIlIllI.getStatus());
                    }
                    this.freeRenderBuilder(llllllllllllIlIIIIIIlllllIIlIllI);
                    return;
                }
                llllllllllllIlIIIIIIlllllIIlIllI.setStatus(ChunkCompileTaskGenerator.Status.UPLOADING);
            }
            finally {
                llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
            }
            llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
            final CompiledChunk llllllllllllIlIIIIIIlllllIIIlIIl = llllllllllllIlIIIIIIlllllIIlIllI.getCompiledChunk();
            final ArrayList llllllllllllIlIIIIIIlllllIIIlIII = Lists.newArrayList();
            if (llllllllllllIlIIIIIIlllllIIIlIlI == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                final short llllllllllllIlIIIIIIllllIllllIIl;
                final long llllllllllllIlIIIIIIllllIllllIlI = ((BlockRenderLayer[])(Object)(llllllllllllIlIIIIIIllllIllllIIl = (short)(Object)BlockRenderLayer.values())).length;
                for (String llllllllllllIlIIIIIIllllIllllIll = (String)0; llllllllllllIlIIIIIIllllIllllIll < llllllllllllIlIIIIIIllllIllllIlI; ++llllllllllllIlIIIIIIllllIllllIll) {
                    final BlockRenderLayer llllllllllllIlIIIIIIlllllIIIIlll = llllllllllllIlIIIIIIllllIllllIIl[llllllllllllIlIIIIIIllllIllllIll];
                    if (llllllllllllIlIIIIIIlllllIIIlIIl.isLayerStarted(llllllllllllIlIIIIIIlllllIIIIlll)) {
                        llllllllllllIlIIIIIIlllllIIIlIII.add(this.chunkRenderDispatcher.uploadChunk(llllllllllllIlIIIIIIlllllIIIIlll, llllllllllllIlIIIIIIlllllIIlIllI.getRegionRenderCacheBuilder().getWorldRendererByLayer(llllllllllllIlIIIIIIlllllIIIIlll), llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk(), llllllllllllIlIIIIIIlllllIIIlIIl, llllllllllllIlIIIIIIlllllIIlIllI.getDistanceSq()));
                    }
                }
            }
            else if (llllllllllllIlIIIIIIlllllIIIlIlI == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                llllllllllllIlIIIIIIlllllIIIlIII.add(this.chunkRenderDispatcher.uploadChunk(BlockRenderLayer.TRANSLUCENT, llllllllllllIlIIIIIIlllllIIlIllI.getRegionRenderCacheBuilder().getWorldRendererByLayer(BlockRenderLayer.TRANSLUCENT), llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk(), llllllllllllIlIIIIIIlllllIIIlIIl, llllllllllllIlIIIIIIlllllIIlIllI.getDistanceSq()));
            }
            final ListenableFuture<List<Object>> llllllllllllIlIIIIIIlllllIIIIllI = (ListenableFuture<List<Object>>)Futures.allAsList((Iterable)llllllllllllIlIIIIIIlllllIIIlIII);
            llllllllllllIlIIIIIIlllllIIlIllI.addFinishRunnable(new Runnable() {
                @Override
                public void run() {
                    llllllllllllIlIIIIIIlllllIIIIllI.cancel(false);
                }
            });
            Futures.addCallback((ListenableFuture)llllllllllllIlIIIIIIlllllIIIIllI, (FutureCallback)new FutureCallback<List<Object>>() {
                public void onFailure(final Throwable llllllllllllIIIIIllIlIIllllIIlIl) {
                    ChunkRenderWorker.this.freeRenderBuilder(llllllllllllIlIIIIIIlllllIIlIllI);
                    if (!(llllllllllllIIIIIllIlIIllllIIlIl instanceof CancellationException) && !(llllllllllllIIIIIllIlIIllllIIlIl instanceof InterruptedException)) {
                        Minecraft.getMinecraft().crashed(CrashReport.makeCrashReport(llllllllllllIIIIIllIlIIllllIIlIl, "Rendering chunk"));
                    }
                }
                
                public void onSuccess(@Nullable final List<Object> llllllllllllIIIIIllIlIIllllIlIll) {
                    ChunkRenderWorker.this.freeRenderBuilder(llllllllllllIlIIIIIIlllllIIlIllI);
                    llllllllllllIlIIIIIIlllllIIlIllI.getLock().lock();
                    try {
                        if (llllllllllllIlIIIIIIlllllIIlIllI.getStatus() != ChunkCompileTaskGenerator.Status.UPLOADING) {
                            if (!llllllllllllIlIIIIIIlllllIIlIllI.isFinished()) {
                                ChunkRenderWorker.LOGGER.warn("Chunk render task was {} when I expected it to be uploading; aborting task", (Object)llllllllllllIlIIIIIIlllllIIlIllI.getStatus());
                            }
                            return;
                        }
                        llllllllllllIlIIIIIIlllllIIlIllI.setStatus(ChunkCompileTaskGenerator.Status.DONE);
                    }
                    finally {
                        llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
                    }
                    llllllllllllIlIIIIIIlllllIIlIllI.getLock().unlock();
                    llllllllllllIlIIIIIIlllllIIlIllI.getRenderChunk().setCompiledChunk(llllllllllllIlIIIIIIlllllIIIlIIl);
                }
            });
        }
    }
    
    private void freeRenderBuilder(final ChunkCompileTaskGenerator llllllllllllIlIIIIIIllllIllIlIIl) {
        if (this.regionRenderCacheBuilder == null) {
            this.chunkRenderDispatcher.freeRenderBuilder(llllllllllllIlIIIIIIllllIllIlIIl.getRegionRenderCacheBuilder());
        }
    }
    
    public ChunkRenderWorker(final ChunkRenderDispatcher llllllllllllIlIIIIIIlllllIllIIII, @Nullable final RegionRenderCacheBuilder llllllllllllIlIIIIIIlllllIlIllll) {
        this.shouldRun = true;
        this.chunkRenderDispatcher = llllllllllllIlIIIIIIlllllIllIIII;
        this.regionRenderCacheBuilder = llllllllllllIlIIIIIIlllllIlIllll;
    }
    
    public ChunkRenderWorker(final ChunkRenderDispatcher llllllllllllIlIIIIIIlllllIlllIII) {
        this(llllllllllllIlIIIIIIlllllIlllIII, null);
    }
    
    private boolean isChunkExisting(final BlockPos llllllllllllIlIIIIIIllllIlllIlIl, final World llllllllllllIlIIIIIIllllIlllIlII) {
        return llllllllllllIlIIIIIIllllIlllIlII != null && !llllllllllllIlIIIIIIllllIlllIlII.getChunkFromChunkCoords(llllllllllllIlIIIIIIllllIlllIlIl.getX() >> 4, llllllllllllIlIIIIIIllllIlllIlIl.getZ() >> 4).isEmpty();
    }
    
    @Override
    public void run() {
        while (this.shouldRun) {
            try {
                this.processTask(this.chunkRenderDispatcher.getNextChunkUpdate());
            }
            catch (InterruptedException llllllllllllIlIIIIIIlllllIlIlIlI) {
                ChunkRenderWorker.LOGGER.debug("Stopping chunk worker due to interrupt");
            }
            catch (Throwable llllllllllllIlIIIIIIlllllIlIlIIl) {
                final CrashReport llllllllllllIlIIIIIIlllllIlIlIII = CrashReport.makeCrashReport(llllllllllllIlIIIIIIlllllIlIlIIl, "Batching chunks");
                Minecraft.getMinecraft().crashed(Minecraft.getMinecraft().addGraphicsAndWorldToCrashReport(llllllllllllIlIIIIIIlllllIlIlIII));
            }
        }
    }
    
    public void notifyToStop() {
        this.shouldRun = false;
    }
    
    private RegionRenderCacheBuilder getRegionRenderCacheBuilder() throws InterruptedException {
        return (this.regionRenderCacheBuilder != null) ? this.regionRenderCacheBuilder : this.chunkRenderDispatcher.allocateRenderBuilder();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
