// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import com.google.common.primitives.Doubles;
import net.minecraft.client.renderer.GlStateManager;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Queues;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.Futures;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.Minecraft;
import com.google.common.util.concurrent.ListenableFuture;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.BlockRenderLayer;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.Queue;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.VertexBufferUploader;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import java.util.concurrent.BlockingQueue;
import java.util.List;

public class ChunkRenderDispatcher
{
    private final /* synthetic */ int countRenderBuilders;
    private final /* synthetic */ List<Thread> listWorkerThreads;
    private final /* synthetic */ BlockingQueue<RegionRenderCacheBuilder> queueFreeRenderBuilders;
    private final /* synthetic */ ChunkRenderWorker renderWorker;
    private final /* synthetic */ VertexBufferUploader vertexUploader;
    private final /* synthetic */ WorldVertexBufferUploader worldVertexUploader;
    private static final /* synthetic */ ThreadFactory THREAD_FACTORY;
    private final /* synthetic */ PriorityBlockingQueue<ChunkCompileTaskGenerator> queueChunkUpdates;
    private final /* synthetic */ List<ChunkRenderWorker> listThreadedWorkers;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Queue<PendingUpload> queueChunkUploads;
    
    public void freeRenderBuilder(final RegionRenderCacheBuilder lllllllllllIIIIIllIllIIIlIlIIIII) {
        this.queueFreeRenderBuilders.add(lllllllllllIIIIIllIllIIIlIlIIIII);
    }
    
    public void stopChunkUpdates() {
        this.clearChunkUpdates();
        final List<RegionRenderCacheBuilder> lllllllllllIIIIIllIllIIIlIlIlIIl = (List<RegionRenderCacheBuilder>)Lists.newArrayList();
        while (lllllllllllIIIIIllIllIIIlIlIlIIl.size() != this.countRenderBuilders) {
            this.runChunkUploads(Long.MAX_VALUE);
            try {
                lllllllllllIIIIIllIllIIIlIlIlIIl.add(this.allocateRenderBuilder());
            }
            catch (InterruptedException ex) {}
        }
        this.queueFreeRenderBuilders.addAll((Collection<?>)lllllllllllIIIIIllIllIIIlIlIlIIl);
    }
    
    public String getDebugInfo() {
        return this.listWorkerThreads.isEmpty() ? String.format("pC: %03d, single-threaded", this.queueChunkUpdates.size()) : String.format("pC: %03d, pU: %1d, aB: %1d", this.queueChunkUpdates.size(), this.queueChunkUploads.size(), this.queueFreeRenderBuilders.size());
    }
    
    public void clearChunkUpdates() {
        while (!this.queueChunkUpdates.isEmpty()) {
            final ChunkCompileTaskGenerator lllllllllllIIIIIllIllIIIIlIlIlIl = this.queueChunkUpdates.poll();
            if (lllllllllllIIIIIllIllIIIIlIlIlIl != null) {
                lllllllllllIIIIIllIllIIIIlIlIlIl.finish();
            }
        }
    }
    
    public ListenableFuture<Object> uploadChunk(final BlockRenderLayer lllllllllllIIIIIllIllIIIIllllIll, final BufferBuilder lllllllllllIIIIIllIllIIIIllllIlI, final RenderChunk lllllllllllIIIIIllIllIIIIlllIIlI, final CompiledChunk lllllllllllIIIIIllIllIIIIlllIIIl, final double lllllllllllIIIIIllIllIIIIlllIIII) {
        if (Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
            if (OpenGlHelper.useVbo()) {
                this.uploadVertexBuffer(lllllllllllIIIIIllIllIIIIllllIlI, lllllllllllIIIIIllIllIIIIlllIIlI.getVertexBufferByLayer(lllllllllllIIIIIllIllIIIIllllIll.ordinal()));
            }
            else {
                this.uploadDisplayList(lllllllllllIIIIIllIllIIIIllllIlI, ((ListedRenderChunk)lllllllllllIIIIIllIllIIIIlllIIlI).getDisplayList(lllllllllllIIIIIllIllIIIIllllIll, lllllllllllIIIIIllIllIIIIlllIIIl), lllllllllllIIIIIllIllIIIIlllIIlI);
            }
            lllllllllllIIIIIllIllIIIIllllIlI.setTranslation(0.0, 0.0, 0.0);
            return (ListenableFuture<Object>)Futures.immediateFuture((Object)null);
        }
        final ListenableFutureTask<Object> lllllllllllIIIIIllIllIIIIlllIllI = (ListenableFutureTask<Object>)ListenableFutureTask.create((Runnable)new Runnable() {
            @Override
            public void run() {
                ChunkRenderDispatcher.this.uploadChunk(lllllllllllIIIIIllIllIIIIllllIll, lllllllllllIIIIIllIllIIIIllllIlI, lllllllllllIIIIIllIllIIIIlllIIlI, lllllllllllIIIIIllIllIIIIlllIIIl, lllllllllllIIIIIllIllIIIIlllIIII);
            }
        }, (Object)null);
        synchronized (this.queueChunkUploads) {
            this.queueChunkUploads.add(new PendingUpload(lllllllllllIIIIIllIllIIIIlllIllI, lllllllllllIIIIIllIllIIIIlllIIII));
            final ListenableFutureTask<Object> listenableFutureTask = lllllllllllIIIIIllIllIIIIlllIllI;
            // monitorexit(this.queueChunkUploads)
            return (ListenableFuture<Object>)listenableFutureTask;
        }
    }
    
    private void uploadVertexBuffer(final BufferBuilder lllllllllllIIIIIllIllIIIIlIlllIl, final VertexBuffer lllllllllllIIIIIllIllIIIIlIlllII) {
        this.vertexUploader.setVertexBuffer(lllllllllllIIIIIllIllIIIIlIlllII);
        this.vertexUploader.draw(lllllllllllIIIIIllIllIIIIlIlllIl);
    }
    
    public RegionRenderCacheBuilder allocateRenderBuilder() throws InterruptedException {
        return this.queueFreeRenderBuilders.take();
    }
    
    public ChunkRenderDispatcher(final int lllllllllllIIIIIllIllIIIllllIIll) {
        this.listWorkerThreads = (List<Thread>)Lists.newArrayList();
        this.listThreadedWorkers = (List<ChunkRenderWorker>)Lists.newArrayList();
        this.queueChunkUpdates = (PriorityBlockingQueue<ChunkCompileTaskGenerator>)Queues.newPriorityBlockingQueue();
        this.worldVertexUploader = new WorldVertexBufferUploader();
        this.vertexUploader = new VertexBufferUploader();
        this.queueChunkUploads = (Queue<PendingUpload>)Queues.newPriorityQueue();
        final int lllllllllllIIIIIllIllIIIllllIIlI = Math.max(1, (int)(Runtime.getRuntime().maxMemory() * 0.3) / 10485760);
        final int lllllllllllIIIIIllIllIIIllllIIIl = Math.max(1, MathHelper.clamp(Runtime.getRuntime().availableProcessors(), 1, lllllllllllIIIIIllIllIIIllllIIlI / 5));
        if (lllllllllllIIIIIllIllIIIllllIIll < 0) {
            this.countRenderBuilders = MathHelper.clamp(lllllllllllIIIIIllIllIIIllllIIIl, 1, lllllllllllIIIIIllIllIIIllllIIlI);
        }
        else {
            this.countRenderBuilders = lllllllllllIIIIIllIllIIIllllIIll;
        }
        if (lllllllllllIIIIIllIllIIIllllIIIl > 1) {
            for (int lllllllllllIIIIIllIllIIIllllIIII = 0; lllllllllllIIIIIllIllIIIllllIIII < lllllllllllIIIIIllIllIIIllllIIIl; ++lllllllllllIIIIIllIllIIIllllIIII) {
                final ChunkRenderWorker lllllllllllIIIIIllIllIIIlllIllll = new ChunkRenderWorker(this);
                final Thread lllllllllllIIIIIllIllIIIlllIlllI = ChunkRenderDispatcher.THREAD_FACTORY.newThread(lllllllllllIIIIIllIllIIIlllIllll);
                lllllllllllIIIIIllIllIIIlllIlllI.start();
                this.listThreadedWorkers.add(lllllllllllIIIIIllIllIIIlllIllll);
                this.listWorkerThreads.add(lllllllllllIIIIIllIllIIIlllIlllI);
            }
        }
        this.queueFreeRenderBuilders = (BlockingQueue<RegionRenderCacheBuilder>)Queues.newArrayBlockingQueue(this.countRenderBuilders);
        for (int lllllllllllIIIIIllIllIIIlllIllIl = 0; lllllllllllIIIIIllIllIIIlllIllIl < this.countRenderBuilders; ++lllllllllllIIIIIllIllIIIlllIllIl) {
            this.queueFreeRenderBuilders.add(new RegionRenderCacheBuilder());
        }
        this.renderWorker = new ChunkRenderWorker(this, new RegionRenderCacheBuilder());
    }
    
    static {
        LOGGER = LogManager.getLogger();
        THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("Chunk Batcher %d").setDaemon(true).build();
    }
    
    public ChunkRenderDispatcher() {
        this(-1);
    }
    
    public boolean hasChunkUpdates() {
        return this.queueChunkUpdates.isEmpty() && this.queueChunkUploads.isEmpty();
    }
    
    public boolean runChunkUploads(final long lllllllllllIIIIIllIllIIIllIllIll) {
        boolean lllllllllllIIIIIllIllIIIllIllIlI = false;
        boolean lllllllllllIIIIIllIllIIIllIllIIl;
        do {
            lllllllllllIIIIIllIllIIIllIllIIl = false;
            if (this.listWorkerThreads.isEmpty()) {
                final ChunkCompileTaskGenerator lllllllllllIIIIIllIllIIIllIllIII = this.queueChunkUpdates.poll();
                if (lllllllllllIIIIIllIllIIIllIllIII != null) {
                    try {
                        this.renderWorker.processTask(lllllllllllIIIIIllIllIIIllIllIII);
                        lllllllllllIIIIIllIllIIIllIllIIl = true;
                    }
                    catch (InterruptedException lllllllllllIIIIIllIllIIIllIlIlll) {
                        ChunkRenderDispatcher.LOGGER.warn("Skipped task due to interrupt");
                    }
                }
            }
            synchronized (this.queueChunkUploads) {
                if (!this.queueChunkUploads.isEmpty()) {
                    this.queueChunkUploads.poll().uploadTask.run();
                    lllllllllllIIIIIllIllIIIllIllIIl = true;
                    lllllllllllIIIIIllIllIIIllIllIlI = true;
                }
            }
            // monitorexit(this.queueChunkUploads)
        } while (lllllllllllIIIIIllIllIIIllIllIll != 0L && lllllllllllIIIIIllIllIIIllIllIIl && lllllllllllIIIIIllIllIIIllIllIll >= System.nanoTime());
        return lllllllllllIIIIIllIllIIIllIllIlI;
    }
    
    public boolean hasNoFreeRenderBuilders() {
        return this.queueFreeRenderBuilders.isEmpty();
    }
    
    public boolean updateChunkNow(final RenderChunk lllllllllllIIIIIllIllIIIlIllIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* lllllllllllIIIIIllIllIIIlIllIIlI */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskChunk:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* lllllllllllIIIIIllIllIIIlIllIIII */
        //    12: aload_0         /* lllllllllllIIIIIllIllIIIlIllIIll */
        //    13: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.renderWorker:Lnet/minecraft/client/renderer/chunk/ChunkRenderWorker;
        //    16: aload_3         /* lllllllllllIIIIIllIllIIIlIllIlII */
        //    17: invokevirtual   net/minecraft/client/renderer/chunk/ChunkRenderWorker.processTask:(Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    20: goto            25
        //    23: astore          lllllllllllIIIIIllIllIIIlIlIllll
        //    25: iconst_1       
        //    26: istore_2        /* lllllllllllIIIIIllIllIIIlIllIIIl */
        //    27: goto            42
        //    30: astore          lllllllllllIIIIIllIllIIIlIlIlllI
        //    32: aload_1         /* lllllllllllIIIIIllIllIIIlIllIIlI */
        //    33: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           lllllllllllIIIIIllIllIIIlIlIlllI
        //    41: athrow         
        //    42: aload_1         /* lllllllllllIIIIIllIllIIIlIllIIlI */
        //    43: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    46: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    49: iload_2         /* lllllllllllIIIIIllIllIIIlIllIlIl */
        //    50: ireturn        
        //    StackMapTable: 00 04 FF 00 17 00 04 07 00 02 07 00 B8 00 07 00 96 00 01 07 00 42 01 FF 00 04 00 02 07 00 02 07 00 B8 00 01 07 00 FF FD 00 0B 01 07 00 96
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  12     20     23     25     Ljava/lang/InterruptedException;
        //  7      30     30     42     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void stopWorkerThreads() {
        this.clearChunkUpdates();
        for (final ChunkRenderWorker lllllllllllIIIIIllIllIIIIlIIlIlI : this.listThreadedWorkers) {
            lllllllllllIIIIIllIllIIIIlIIlIlI.notifyToStop();
        }
        for (final Thread lllllllllllIIIIIllIllIIIIlIIlIIl : this.listWorkerThreads) {
            try {
                lllllllllllIIIIIllIllIIIIlIIlIIl.interrupt();
                lllllllllllIIIIIllIllIIIIlIIlIIl.join();
            }
            catch (InterruptedException lllllllllllIIIIIllIllIIIIlIIlIII) {
                ChunkRenderDispatcher.LOGGER.warn("Interrupted whilst waiting for worker to die", (Throwable)lllllllllllIIIIIllIllIIIIlIIlIII);
            }
        }
        this.queueFreeRenderBuilders.clear();
    }
    
    private void uploadDisplayList(final BufferBuilder lllllllllllIIIIIllIllIIIIllIlIII, final int lllllllllllIIIIIllIllIIIIllIIlll, final RenderChunk lllllllllllIIIIIllIllIIIIllIIllI) {
        GlStateManager.glNewList(lllllllllllIIIIIllIllIIIIllIIlll, 4864);
        GlStateManager.pushMatrix();
        lllllllllllIIIIIllIllIIIIllIIllI.multModelviewMatrix();
        this.worldVertexUploader.draw(lllllllllllIIIIIllIllIIIIllIlIII);
        GlStateManager.popMatrix();
        GlStateManager.glEndList();
    }
    
    public boolean updateChunkLater(final RenderChunk lllllllllllIIIIIllIllIIIllIIIIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* lllllllllllIIIIIllIllIIIllIIlIIl */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskChunk:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* lllllllllllIIIIIllIllIIIllIIIIIl */
        //    12: aload_3         /* lllllllllllIIIIIllIllIIIllIIIllI */
        //    13: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1;
        //    16: dup            
        //    17: aload_0         /* lllllllllllIIIIIllIllIIIllIIlIlI */
        //    18: aload_3         /* lllllllllllIIIIIllIllIIIllIIIllI */
        //    19: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$1.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    22: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.addFinishRunnable:(Ljava/lang/Runnable;)V
        //    25: aload_0         /* lllllllllllIIIIIllIllIIIllIIlIlI */
        //    26: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.queueChunkUpdates:Ljava/util/concurrent/PriorityBlockingQueue;
        //    29: aload_3         /* lllllllllllIIIIIllIllIIIllIIIllI */
        //    30: invokevirtual   java/util/concurrent/PriorityBlockingQueue.offer:(Ljava/lang/Object;)Z
        //    33: istore          lllllllllllIIIIIllIllIIIllIIIlIl
        //    35: iload           lllllllllllIIIIIllIllIIIllIIIlIl
        //    37: ifne            44
        //    40: aload_3         /* lllllllllllIIIIIllIllIIIllIIIllI */
        //    41: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.finish:()V
        //    44: iload           lllllllllllIIIIIllIllIIIllIIIlIl
        //    46: istore_2        /* lllllllllllIIIIIllIllIIIllIIlIII */
        //    47: goto            62
        //    50: astore          lllllllllllIIIIIllIllIIIlIllllll
        //    52: aload_1         /* lllllllllllIIIIIllIllIIIllIIlIIl */
        //    53: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    56: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    59: aload           lllllllllllIIIIIllIllIIIlIllllll
        //    61: athrow         
        //    62: aload_1         /* lllllllllllIIIIIllIllIIIllIIlIIl */
        //    63: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    66: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    69: iload_2         /* lllllllllllIIIIIllIllIIIllIIIlll */
        //    70: ireturn        
        //    StackMapTable: 00 03 FE 00 2C 00 07 00 96 01 FF 00 05 00 02 07 00 02 07 00 B8 00 01 07 00 FF FE 00 0B 01 07 00 96 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      50     50     62     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public ChunkCompileTaskGenerator getNextChunkUpdate() throws InterruptedException {
        return this.queueChunkUpdates.take();
    }
    
    public boolean updateTransparencyLater(final RenderChunk lllllllllllIIIIIllIllIIIlIIIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_1         /* lllllllllllIIIIIllIllIIIlIIlIIIl */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.makeCompileTaskTransparency:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: astore_3        /* lllllllllllIIIIIllIllIIIlIIIlllI */
        //    12: aload_3         /* lllllllllllIIIIIllIllIIIlIIIlllI */
        //    13: ifnull          53
        //    16: aload_3         /* lllllllllllIIIIIllIllIIIlIIIlllI */
        //    17: new             Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2;
        //    20: dup            
        //    21: aload_0         /* lllllllllllIIIIIllIllIIIlIIlIIlI */
        //    22: aload_3         /* lllllllllllIIIIIllIllIIIlIIIlllI */
        //    23: invokespecial   net/minecraft/client/renderer/chunk/ChunkRenderDispatcher$2.<init>:(Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;)V
        //    26: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.addFinishRunnable:(Ljava/lang/Runnable;)V
        //    29: aload_0         /* lllllllllllIIIIIllIllIIIlIIlIIlI */
        //    30: getfield        net/minecraft/client/renderer/chunk/ChunkRenderDispatcher.queueChunkUpdates:Ljava/util/concurrent/PriorityBlockingQueue;
        //    33: aload_3         /* lllllllllllIIIIIllIllIIIlIIIlllI */
        //    34: invokevirtual   java/util/concurrent/PriorityBlockingQueue.offer:(Ljava/lang/Object;)Z
        //    37: istore          lllllllllllIIIIIllIllIIIlIIIllIl
        //    39: iload           lllllllllllIIIIIllIllIIIlIIIllIl
        //    41: istore          lllllllllllIIIIIllIllIIIlIIIIlIl
        //    43: aload_1         /* lllllllllllIIIIIllIllIIIlIIlIIIl */
        //    44: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    47: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    50: iload           lllllllllllIIIIIllIllIIIlIIIIlIl
        //    52: ireturn        
        //    53: iconst_1       
        //    54: istore          lllllllllllIIIIIllIllIIIlIIIllII
        //    56: iload           lllllllllllIIIIIllIllIIIlIIIllII
        //    58: istore_2        /* lllllllllllIIIIIllIllIIIlIIlIIII */
        //    59: goto            74
        //    62: astore          lllllllllllIIIIIllIllIIIlIIIIllI
        //    64: aload_1         /* lllllllllllIIIIIllIllIIIlIIlIIIl */
        //    65: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    68: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    71: aload           lllllllllllIIIIIllIllIIIlIIIIllI
        //    73: athrow         
        //    74: aload_1         /* lllllllllllIIIIIllIllIIIlIIlIIIl */
        //    75: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.getLockCompileTask:()Ljava/util/concurrent/locks/ReentrantLock;
        //    78: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    81: iload_2         /* lllllllllllIIIIIllIllIIIlIIIllll */
        //    82: ireturn        
        //    StackMapTable: 00 03 FD 00 35 00 07 00 96 FF 00 08 00 02 07 00 02 07 00 B8 00 01 07 00 FF FE 00 0B 01 07 00 96 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      43     62     74     Any
        //  53     62     62     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    class PendingUpload implements Comparable<PendingUpload>
    {
        private final /* synthetic */ double distanceSq;
        private final /* synthetic */ ListenableFutureTask<Object> uploadTask;
        
        @Override
        public int compareTo(final PendingUpload llllllllllllIlllIIlllIllllIllIIl) {
            return Doubles.compare(this.distanceSq, llllllllllllIlllIIlllIllllIllIIl.distanceSq);
        }
        
        public PendingUpload(final ListenableFutureTask<Object> llllllllllllIlllIIlllIlllllIIlII, final double llllllllllllIlllIIlllIllllIlllll) {
            this.uploadTask = llllllllllllIlllIIlllIlllllIIlII;
            this.distanceSq = llllllllllllIlllIIlllIllllIlllll;
        }
    }
}
