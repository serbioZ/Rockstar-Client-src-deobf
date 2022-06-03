// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import java.util.Random;
import net.minecraft.world.World;

public class BiomeSavannaMutated extends BiomeSavanna
{
    public BiomeSavannaMutated(final BiomeProperties llllllllllllllIIlIIlIlIIIlllIlIl) {
        super(llllllllllllllIIlIIlIlIIIlllIlIl);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 2;
        this.theBiomeDecorator.grassPerChunk = 5;
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIIlIIlIlIIIllIIlIl, final Random llllllllllllllIIlIIlIlIIIllIIlII, final ChunkPrimer llllllllllllllIIlIIlIlIIIllIlIlI, final int llllllllllllllIIlIIlIlIIIllIlIIl, final int llllllllllllllIIlIIlIlIIIllIIIIl, final double llllllllllllllIIlIIlIlIIIllIIlll) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        if (llllllllllllllIIlIIlIlIIIllIIlll > 1.75) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }
        else if (llllllllllllllIIlIIlIlIIIllIIlll > -0.5) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        }
        this.generateBiomeTerrain(llllllllllllllIIlIIlIlIIIllIIlIl, llllllllllllllIIlIIlIlIIIllIIlII, llllllllllllllIIlIIlIlIIIllIlIlI, llllllllllllllIIlIIlIlIIIllIlIIl, llllllllllllllIIlIIlIlIIIllIIIIl, llllllllllllllIIlIIlIlIIIllIIlll);
    }
    
    @Override
    public void decorate(final World llllllllllllllIIlIIlIlIIIlIllIlI, final Random llllllllllllllIIlIIlIlIIIlIllIIl, final BlockPos llllllllllllllIIlIIlIlIIIlIllIII) {
        this.theBiomeDecorator.decorate(llllllllllllllIIlIIlIlIIIlIllIlI, llllllllllllllIIlIIlIlIIIlIllIIl, this, llllllllllllllIIlIIlIlIIIlIllIII);
    }
}
