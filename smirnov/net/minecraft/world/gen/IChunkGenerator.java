// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.world.chunk.Chunk;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EnumCreatureType;

public interface IChunkGenerator
{
    List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType p0, final BlockPos p1);
    
    void populate(final int p0, final int p1);
    
    @Nullable
    BlockPos getStrongholdGen(final World p0, final String p1, final BlockPos p2, final boolean p3);
    
    void recreateStructures(final Chunk p0, final int p1, final int p2);
    
    Chunk provideChunk(final int p0, final int p1);
    
    boolean generateStructures(final Chunk p0, final int p1, final int p2);
    
    boolean func_193414_a(final World p0, final String p1, final BlockPos p2);
}
