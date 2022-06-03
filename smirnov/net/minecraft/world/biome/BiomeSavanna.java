// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;

public class BiomeSavanna extends Biome
{
    private static final /* synthetic */ WorldGenSavannaTree SAVANNA_TREE;
    
    static {
        SAVANNA_TREE = new WorldGenSavannaTree(false);
    }
    
    @Override
    public void decorate(final World llllllllllIllllIIIIlIllIlIIIIIll, final Random llllllllllIllllIIIIlIllIlIIIIIlI, final BlockPos llllllllllIllllIIIIlIllIlIIIIIIl) {
        BiomeSavanna.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);
        for (int llllllllllIllllIIIIlIllIlIIIlIII = 0; llllllllllIllllIIIIlIllIlIIIlIII < 7; ++llllllllllIllllIIIIlIllIlIIIlIII) {
            final int llllllllllIllllIIIIlIllIlIIIIlll = llllllllllIllllIIIIlIllIlIIIIIlI.nextInt(16) + 8;
            final int llllllllllIllllIIIIlIllIlIIIIllI = llllllllllIllllIIIIlIllIlIIIIIlI.nextInt(16) + 8;
            final int llllllllllIllllIIIIlIllIlIIIIlIl = llllllllllIllllIIIIlIllIlIIIIIlI.nextInt(llllllllllIllllIIIIlIllIlIIIIIll.getHeight(llllllllllIllllIIIIlIllIlIIIIIIl.add(llllllllllIllllIIIIlIllIlIIIIlll, 0, llllllllllIllllIIIIlIllIlIIIIllI)).getY() + 32);
            BiomeSavanna.DOUBLE_PLANT_GENERATOR.generate(llllllllllIllllIIIIlIllIlIIIIIll, llllllllllIllllIIIIlIllIlIIIIIlI, llllllllllIllllIIIIlIllIlIIIIIIl.add(llllllllllIllllIIIIlIllIlIIIIlll, llllllllllIllllIIIIlIllIlIIIIlIl, llllllllllIllllIIIIlIllIlIIIIllI));
        }
        super.decorate(llllllllllIllllIIIIlIllIlIIIIIll, llllllllllIllllIIIIlIllIlIIIIIlI, llllllllllIllllIIIIlIllIlIIIIIIl);
    }
    
    @Override
    public Class<? extends Biome> getBiomeClass() {
        return BiomeSavanna.class;
    }
    
    protected BiomeSavanna(final BiomeProperties llllllllllIllllIIIIlIllIlIIllIIl) {
        super(llllllllllIllllIIIIlIllIlIIllIIl);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 1, 2, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDonkey.class, 1, 1, 1));
        if (this.getBaseHeight() > 1.1f) {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 8, 4, 4));
        }
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 20;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllIllllIIIIlIllIlIIlIlIl) {
        return (llllllllllIllllIIIIlIllIlIIlIlIl.nextInt(5) > 0) ? BiomeSavanna.SAVANNA_TREE : BiomeSavanna.TREE_FEATURE;
    }
}
