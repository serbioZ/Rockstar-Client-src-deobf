// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import com.google.common.primitives.Doubles;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;

public class ChunkCompileTaskGenerator implements Comparable<ChunkCompileTaskGenerator>
{
    private final /* synthetic */ double distanceSq;
    private /* synthetic */ CompiledChunk compiledChunk;
    private /* synthetic */ RegionRenderCacheBuilder regionRenderCacheBuilder;
    private /* synthetic */ Status status;
    private /* synthetic */ boolean finished;
    private final /* synthetic */ RenderChunk renderChunk;
    private final /* synthetic */ ReentrantLock lock;
    private final /* synthetic */ Type type;
    private final /* synthetic */ List<Runnable> listFinishRunnables;
    
    public RenderChunk getRenderChunk() {
        return this.renderChunk;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setCompiledChunk(final CompiledChunk llllllllllllIIIIlIIIlIlllIIIllIl) {
        this.compiledChunk = llllllllllllIIIIlIIIlIlllIIIllIl;
    }
    
    public ChunkCompileTaskGenerator(final RenderChunk llllllllllllIIIIlIIIlIlllIIlllII, final Type llllllllllllIIIIlIIIlIlllIIllIll, final double llllllllllllIIIIlIIIlIlllIIllllI) {
        this.lock = new ReentrantLock();
        this.listFinishRunnables = (List<Runnable>)Lists.newArrayList();
        this.status = Status.PENDING;
        this.renderChunk = llllllllllllIIIIlIIIlIlllIIlllII;
        this.type = llllllllllllIIIIlIIIlIlllIIllIll;
        this.distanceSq = llllllllllllIIIIlIIIlIlllIIllllI;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public void finish() {
        this.lock.lock();
        try {
            if (this.type == Type.REBUILD_CHUNK && this.status != Status.DONE) {
                this.renderChunk.setNeedsUpdate(false);
            }
            this.finished = true;
            this.status = Status.DONE;
            for (final Runnable llllllllllllIIIIlIIIlIllIlllIlII : this.listFinishRunnables) {
                llllllllllllIIIIlIIIlIllIlllIlII.run();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    @Override
    public int compareTo(final ChunkCompileTaskGenerator llllllllllllIIIIlIIIlIllIlIllIll) {
        return Doubles.compare(this.distanceSq, llllllllllllIIIIlIIIlIllIlIllIll.distanceSq);
    }
    
    public void setStatus(final Status llllllllllllIIIIlIIIlIllIllllIll) {
        this.lock.lock();
        try {
            this.status = llllllllllllIIIIlIIIlIllIllllIll;
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public boolean isFinished() {
        return this.finished;
    }
    
    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }
    
    public ReentrantLock getLock() {
        return this.lock;
    }
    
    public void addFinishRunnable(final Runnable llllllllllllIIIIlIIIlIllIllIlIll) {
        this.lock.lock();
        try {
            this.listFinishRunnables.add(llllllllllllIIIIlIIIlIllIllIlIll);
            if (this.finished) {
                llllllllllllIIIIlIIIlIllIllIlIll.run();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public double getDistanceSq() {
        return this.distanceSq;
    }
    
    public RegionRenderCacheBuilder getRegionRenderCacheBuilder() {
        return this.regionRenderCacheBuilder;
    }
    
    public void setRegionRenderCacheBuilder(final RegionRenderCacheBuilder llllllllllllIIIIlIIIlIlllIIIIlII) {
        this.regionRenderCacheBuilder = llllllllllllIIIIlIIIlIlllIIIIlII;
    }
    
    public enum Status
    {
        COMPILING("COMPILING", 1), 
        DONE("DONE", 3), 
        UPLOADING("UPLOADING", 2), 
        PENDING("PENDING", 0);
        
        private Status(final String lllllllllllIllIIIlIllIIIllIlIlIl, final int lllllllllllIllIIIlIllIIIllIlIlII) {
        }
    }
    
    public enum Type
    {
        REBUILD_CHUNK("REBUILD_CHUNK", 0), 
        RESORT_TRANSPARENCY("RESORT_TRANSPARENCY", 1);
        
        private Type(final String lllllllllllIllllIlIlIIllIllllllI, final int lllllllllllIllllIlIlIIllIlllllIl) {
        }
    }
}
