// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import javax.annotation.Nullable;

public interface IChunkProvider
{
    boolean func_191062_e(final int p0, final int p1);
    
    @Nullable
    Chunk getLoadedChunk(final int p0, final int p1);
    
    String makeString();
    
    Chunk provideChunk(final int p0, final int p1);
    
    boolean unloadQueuedChunks();
}
