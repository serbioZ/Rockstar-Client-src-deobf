// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeHills extends Biome
{
    private final /* synthetic */ WorldGenerator theWorldGenerator;
    private final /* synthetic */ Type type;
    private final /* synthetic */ WorldGenTaiga2 spruceGenerator;
    
    @Override
    public void decorate(final World lllllllllllIllIlIIIIIllllllllIll, final Random lllllllllllIllIlIIIIIllllllIllII, final BlockPos lllllllllllIllIlIIIIIllllllIlIll) {
        super.decorate(lllllllllllIllIlIIIIIllllllllIll, lllllllllllIllIlIIIIIllllllIllII, lllllllllllIllIlIIIIIllllllIlIll);
        for (int lllllllllllIllIlIIIIIllllllllIII = 3 + lllllllllllIllIlIIIIIllllllIllII.nextInt(6), lllllllllllIllIlIIIIIlllllllIlll = 0; lllllllllllIllIlIIIIIlllllllIlll < lllllllllllIllIlIIIIIllllllllIII; ++lllllllllllIllIlIIIIIlllllllIlll) {
            final int lllllllllllIllIlIIIIIlllllllIllI = lllllllllllIllIlIIIIIllllllIllII.nextInt(16);
            final int lllllllllllIllIlIIIIIlllllllIlIl = lllllllllllIllIlIIIIIllllllIllII.nextInt(28) + 4;
            final int lllllllllllIllIlIIIIIlllllllIlII = lllllllllllIllIlIIIIIllllllIllII.nextInt(16);
            final BlockPos lllllllllllIllIlIIIIIlllllllIIll = lllllllllllIllIlIIIIIllllllIlIll.add(lllllllllllIllIlIIIIIlllllllIllI, lllllllllllIllIlIIIIIlllllllIlIl, lllllllllllIllIlIIIIIlllllllIlII);
            if (lllllllllllIllIlIIIIIllllllllIll.getBlockState(lllllllllllIllIlIIIIIlllllllIIll).getBlock() == Blocks.STONE) {
                lllllllllllIllIlIIIIIllllllllIll.setBlockState(lllllllllllIllIlIIIIIlllllllIIll, Blocks.EMERALD_ORE.getDefaultState(), 2);
            }
        }
        for (int lllllllllllIllIlIIIIIlllllllIIlI = 0; lllllllllllIllIlIIIIIlllllllIIlI < 7; ++lllllllllllIllIlIIIIIlllllllIIlI) {
            final int lllllllllllIllIlIIIIIlllllllIIIl = lllllllllllIllIlIIIIIllllllIllII.nextInt(16);
            final int lllllllllllIllIlIIIIIlllllllIIII = lllllllllllIllIlIIIIIllllllIllII.nextInt(64);
            final int lllllllllllIllIlIIIIIllllllIllll = lllllllllllIllIlIIIIIllllllIllII.nextInt(16);
            this.theWorldGenerator.generate(lllllllllllIllIlIIIIIllllllllIll, lllllllllllIllIlIIIIIllllllIllII, lllllllllllIllIlIIIIIllllllIlIll.add(lllllllllllIllIlIIIIIlllllllIIIl, lllllllllllIllIlIIIIIlllllllIIII, lllllllllllIllIlIIIIIllllllIllll));
        }
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllIllIlIIIIlIIIIIIIIlll) {
        return (lllllllllllIllIlIIIIlIIIIIIIIlll.nextInt(3) > 0) ? this.spruceGenerator : super.genBigTreeChance(lllllllllllIllIlIIIIlIIIIIIIIlll);
    }
    
    protected BiomeHills(final Type lllllllllllIllIlIIIIlIIIIIIlIIIl, final BiomeProperties lllllllllllIllIlIIIIlIIIIIIlIIII) {
        super(lllllllllllIllIlIIIIlIIIIIIlIIII);
        this.theWorldGenerator = new WorldGenMinable(Blocks.MONSTER_EGG.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.STONE), 9);
        this.spruceGenerator = new WorldGenTaiga2(false);
        if (lllllllllllIllIlIIIIlIIIIIIlIIIl == Type.EXTRA_TREES) {
            this.theBiomeDecorator.treesPerChunk = 3;
        }
        this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 5, 4, 6));
        this.type = lllllllllllIllIlIIIIlIIIIIIlIIIl;
    }
    
    @Override
    public void genTerrainBlocks(final World lllllllllllIllIlIIIIIlllllIlIlIl, final Random lllllllllllIllIlIIIIIlllllIlIlII, final ChunkPrimer lllllllllllIllIlIIIIIlllllIlIIll, final int lllllllllllIllIlIIIIIlllllIlIIlI, final int lllllllllllIllIlIIIIIlllllIlIIIl, final double lllllllllllIllIlIIIIIlllllIlIlll) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        if ((lllllllllllIllIlIIIIIlllllIlIlll < -1.0 || lllllllllllIllIlIIIIIlllllIlIlll > 2.0) && this.type == Type.MUTATED) {
            this.topBlock = Blocks.GRAVEL.getDefaultState();
            this.fillerBlock = Blocks.GRAVEL.getDefaultState();
        }
        else if (lllllllllllIllIlIIIIIlllllIlIlll > 1.0 && this.type != Type.EXTRA_TREES) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }
        this.generateBiomeTerrain(lllllllllllIllIlIIIIIlllllIlIlIl, lllllllllllIllIlIIIIIlllllIlIlII, lllllllllllIllIlIIIIIlllllIlIIll, lllllllllllIllIlIIIIIlllllIlIIlI, lllllllllllIllIlIIIIIlllllIlIIIl, lllllllllllIllIlIIIIIlllllIlIlll);
    }
    
    public enum Type
    {
        MUTATED("MUTATED", 2), 
        EXTRA_TREES("EXTRA_TREES", 1), 
        NORMAL("NORMAL", 0);
        
        private Type(final String llllllllllllIIlIlIlIlIIIlIIlIlII, final int llllllllllllIIlIlIlIlIIIlIIlIIll) {
        }
    }
}
