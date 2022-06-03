// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import java.util.Collection;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import com.google.common.collect.Lists;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.block.state.IBlockState;
import java.util.List;
import net.minecraft.world.World;

public class ChunkGeneratorDebug implements IChunkGenerator
{
    private final /* synthetic */ World world;
    private static final /* synthetic */ List<IBlockState> ALL_VALID_STATES;
    private static final /* synthetic */ int GRID_HEIGHT;
    protected static final /* synthetic */ IBlockState BARRIER;
    private static final /* synthetic */ int GRID_WIDTH;
    protected static final /* synthetic */ IBlockState AIR;
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllllllIllIIIIIIIIIIIl, final int lllllllllllllllllIllIIIIIIIIIIII, final int lllllllllllllllllIlIllllllllllll) {
    }
    
    static {
        ALL_VALID_STATES = Lists.newArrayList();
        AIR = Blocks.AIR.getDefaultState();
        BARRIER = Blocks.BARRIER.getDefaultState();
        for (final Block lllllllllllllllllIllIIIIIlIlIIlI : Block.REGISTRY) {
            ChunkGeneratorDebug.ALL_VALID_STATES.addAll((Collection<? extends IBlockState>)lllllllllllllllllIllIIIIIlIlIIlI.getBlockState().getValidStates());
        }
        GRID_WIDTH = MathHelper.ceil(MathHelper.sqrt((float)ChunkGeneratorDebug.ALL_VALID_STATES.size()));
        GRID_HEIGHT = MathHelper.ceil(ChunkGeneratorDebug.ALL_VALID_STATES.size() / (float)ChunkGeneratorDebug.GRID_WIDTH);
    }
    
    public ChunkGeneratorDebug(final World lllllllllllllllllIllIIIIIlIIlIlI) {
        this.world = lllllllllllllllllIllIIIIIlIIlIlI;
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllllllIllIIIIIIIIlIlI, final String lllllllllllllllllIllIIIIIIIIlIIl, final BlockPos lllllllllllllllllIllIIIIIIIIlIII, final boolean lllllllllllllllllIllIIIIIIIIIlll) {
        return null;
    }
    
    @Override
    public void populate(final int lllllllllllllllllIllIIIIIIIlllIl, final int lllllllllllllllllIllIIIIIIIlllII) {
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllllIllIIIIIIllllll, final int lllllllllllllllllIllIIIIIIlllllI) {
        final ChunkPrimer lllllllllllllllllIllIIIIIIllllIl = new ChunkPrimer();
        for (int lllllllllllllllllIllIIIIIIllllII = 0; lllllllllllllllllIllIIIIIIllllII < 16; ++lllllllllllllllllIllIIIIIIllllII) {
            for (int lllllllllllllllllIllIIIIIIlllIll = 0; lllllllllllllllllIllIIIIIIlllIll < 16; ++lllllllllllllllllIllIIIIIIlllIll) {
                final int lllllllllllllllllIllIIIIIIlllIlI = lllllllllllllllllIllIIIIIIllllll * 16 + lllllllllllllllllIllIIIIIIllllII;
                final int lllllllllllllllllIllIIIIIIlllIIl = lllllllllllllllllIllIIIIIIlllllI * 16 + lllllllllllllllllIllIIIIIIlllIll;
                lllllllllllllllllIllIIIIIIllllIl.setBlockState(lllllllllllllllllIllIIIIIIllllII, 60, lllllllllllllllllIllIIIIIIlllIll, ChunkGeneratorDebug.BARRIER);
                final IBlockState lllllllllllllllllIllIIIIIIlllIII = getBlockStateFor(lllllllllllllllllIllIIIIIIlllIlI, lllllllllllllllllIllIIIIIIlllIIl);
                if (lllllllllllllllllIllIIIIIIlllIII != null) {
                    lllllllllllllllllIllIIIIIIllllIl.setBlockState(lllllllllllllllllIllIIIIIIllllII, 70, lllllllllllllllllIllIIIIIIlllIll, lllllllllllllllllIllIIIIIIlllIII);
                }
            }
        }
        final Chunk lllllllllllllllllIllIIIIIIllIlll = new Chunk(this.world, lllllllllllllllllIllIIIIIIllllIl, lllllllllllllllllIllIIIIIIllllll, lllllllllllllllllIllIIIIIIlllllI);
        lllllllllllllllllIllIIIIIIllIlll.generateSkylightMap();
        final Biome[] lllllllllllllllllIllIIIIIIllIllI = this.world.getBiomeProvider().getBiomes(null, lllllllllllllllllIllIIIIIIllllll * 16, lllllllllllllllllIllIIIIIIlllllI * 16, 16, 16);
        final byte[] lllllllllllllllllIllIIIIIIllIlIl = lllllllllllllllllIllIIIIIIllIlll.getBiomeArray();
        for (int lllllllllllllllllIllIIIIIIllIlII = 0; lllllllllllllllllIllIIIIIIllIlII < lllllllllllllllllIllIIIIIIllIlIl.length; ++lllllllllllllllllIllIIIIIIllIlII) {
            lllllllllllllllllIllIIIIIIllIlIl[lllllllllllllllllIllIIIIIIllIlII] = (byte)Biome.getIdForBiome(lllllllllllllllllIllIIIIIIllIllI[lllllllllllllllllIllIIIIIIllIlII]);
        }
        lllllllllllllllllIllIIIIIIllIlll.generateSkylightMap();
        return lllllllllllllllllIllIIIIIIllIlll;
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllllllIllIIIIIIIIlllI, final BlockPos lllllllllllllllllIllIIIIIIIlIIIl) {
        final Biome lllllllllllllllllIllIIIIIIIlIIII = this.world.getBiome(lllllllllllllllllIllIIIIIIIlIIIl);
        return lllllllllllllllllIllIIIIIIIlIIII.getSpawnableList(lllllllllllllllllIllIIIIIIIIlllI);
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllllllIllIIIIIIIllIlI, final int lllllllllllllllllIllIIIIIIIllIIl, final int lllllllllllllllllIllIIIIIIIllIII) {
        return false;
    }
    
    @Override
    public boolean func_193414_a(final World lllllllllllllllllIllIIIIIIIIIlIl, final String lllllllllllllllllIllIIIIIIIIIlII, final BlockPos lllllllllllllllllIllIIIIIIIIIIll) {
        return false;
    }
    
    public static IBlockState getBlockStateFor(int lllllllllllllllllIllIIIIIIlIIllI, int lllllllllllllllllIllIIIIIIlIIlIl) {
        IBlockState lllllllllllllllllIllIIIIIIlIIlII = ChunkGeneratorDebug.AIR;
        if (lllllllllllllllllIllIIIIIIlIIllI > 0 && lllllllllllllllllIllIIIIIIlIIlIl > 0 && lllllllllllllllllIllIIIIIIlIIllI % 2 != 0 && lllllllllllllllllIllIIIIIIlIIlIl % 2 != 0) {
            lllllllllllllllllIllIIIIIIlIIllI /= 2;
            lllllllllllllllllIllIIIIIIlIIlIl /= 2;
            if (lllllllllllllllllIllIIIIIIlIIllI <= ChunkGeneratorDebug.GRID_WIDTH && lllllllllllllllllIllIIIIIIlIIlIl <= ChunkGeneratorDebug.GRID_HEIGHT) {
                final int lllllllllllllllllIllIIIIIIlIIIll = MathHelper.abs(lllllllllllllllllIllIIIIIIlIIllI * ChunkGeneratorDebug.GRID_WIDTH + lllllllllllllllllIllIIIIIIlIIlIl);
                if (lllllllllllllllllIllIIIIIIlIIIll < ChunkGeneratorDebug.ALL_VALID_STATES.size()) {
                    lllllllllllllllllIllIIIIIIlIIlII = ChunkGeneratorDebug.ALL_VALID_STATES.get(lllllllllllllllllIllIIIIIIlIIIll);
                }
            }
        }
        return lllllllllllllllllIllIIIIIIlIIlII;
    }
}
