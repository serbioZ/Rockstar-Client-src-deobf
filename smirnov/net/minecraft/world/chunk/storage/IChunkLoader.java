// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import javax.annotation.Nullable;
import java.io.IOException;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;

public interface IChunkLoader
{
    void saveChunk(final World p0, final Chunk p1) throws MinecraftException, IOException;
    
    boolean func_191063_a(final int p0, final int p1);
    
    void saveExtraChunkData(final World p0, final Chunk p1) throws IOException;
    
    void chunkTick();
    
    void saveExtraData();
    
    @Nullable
    Chunk loadChunk(final World p0, final int p1, final int p2) throws IOException;
}
