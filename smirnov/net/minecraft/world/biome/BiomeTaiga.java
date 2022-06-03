// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;

public class BiomeTaiga extends Biome
{
    private final /* synthetic */ Type type;
    private static final /* synthetic */ WorldGenBlockBlob FOREST_ROCK_GENERATOR;
    private static final /* synthetic */ WorldGenTaiga2 SPRUCE_GENERATOR;
    private static final /* synthetic */ WorldGenMegaPineTree MEGA_PINE_GENERATOR;
    private static final /* synthetic */ WorldGenMegaPineTree MEGA_SPRUCE_GENERATOR;
    private static final /* synthetic */ WorldGenTaiga1 PINE_GENERATOR;
    
    @Override
    public void genTerrainBlocks(final World llllllllllIllllIllIIIlllllIIIIll, final Random llllllllllIllllIllIIIlllllIIIIlI, final ChunkPrimer llllllllllIllllIllIIIlllllIIlIII, final int llllllllllIllllIllIIIlllllIIIIII, final int llllllllllIllllIllIIIlllllIIIllI, final double llllllllllIllllIllIIIllllIlllllI) {
        if (this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();
            if (llllllllllIllllIllIIIllllIlllllI > 1.75) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            }
            else if (llllllllllIllllIllIIIllllIlllllI > -0.95) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }
        }
        this.generateBiomeTerrain(llllllllllIllllIllIIIlllllIIIIll, llllllllllIllllIllIIIlllllIIIIlI, llllllllllIllllIllIIIlllllIIlIII, llllllllllIllllIllIIIlllllIIIIII, llllllllllIllllIllIIIlllllIIIllI, llllllllllIllllIllIIIllllIlllllI);
    }
    
    static {
        PINE_GENERATOR = new WorldGenTaiga1();
        SPRUCE_GENERATOR = new WorldGenTaiga2(false);
        MEGA_PINE_GENERATOR = new WorldGenMegaPineTree(false, false);
        MEGA_SPRUCE_GENERATOR = new WorldGenMegaPineTree(false, true);
        FOREST_ROCK_GENERATOR = new WorldGenBlockBlob(Blocks.MOSSY_COBBLESTONE, 0);
    }
    
    @Override
    public WorldGenerator getRandomWorldGenForGrass(final Random llllllllllIllllIllIIIlllllllIIlI) {
        return (llllllllllIllllIllIIIlllllllIIlI.nextInt(5) > 0) ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllIllllIllIIIllllllllIII) {
        if ((this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) && llllllllllIllllIllIIIllllllllIII.nextInt(3) == 0) {
            return (this.type != Type.MEGA_SPRUCE && llllllllllIllllIllIIIllllllllIII.nextInt(13) != 0) ? BiomeTaiga.MEGA_PINE_GENERATOR : BiomeTaiga.MEGA_SPRUCE_GENERATOR;
        }
        return (llllllllllIllllIllIIIllllllllIII.nextInt(3) == 0) ? BiomeTaiga.PINE_GENERATOR : BiomeTaiga.SPRUCE_GENERATOR;
    }
    
    @Override
    public void decorate(final World llllllllllIllllIllIIIlllllIllIlI, final Random llllllllllIllllIllIIIllllllIIllI, final BlockPos llllllllllIllllIllIIIllllllIIlIl) {
        if (this.type == Type.MEGA || this.type == Type.MEGA_SPRUCE) {
            for (int llllllllllIllllIllIIIllllllIIlII = llllllllllIllllIllIIIllllllIIllI.nextInt(3), llllllllllIllllIllIIIllllllIIIll = 0; llllllllllIllllIllIIIllllllIIIll < llllllllllIllllIllIIIllllllIIlII; ++llllllllllIllllIllIIIllllllIIIll) {
                final int llllllllllIllllIllIIIllllllIIIlI = llllllllllIllllIllIIIllllllIIllI.nextInt(16) + 8;
                final int llllllllllIllllIllIIIllllllIIIIl = llllllllllIllllIllIIIllllllIIllI.nextInt(16) + 8;
                final BlockPos llllllllllIllllIllIIIllllllIIIII = llllllllllIllllIllIIIlllllIllIlI.getHeight(llllllllllIllllIllIIIllllllIIlIl.add(llllllllllIllllIllIIIllllllIIIlI, 0, llllllllllIllllIllIIIllllllIIIIl));
                BiomeTaiga.FOREST_ROCK_GENERATOR.generate(llllllllllIllllIllIIIlllllIllIlI, llllllllllIllllIllIIIllllllIIllI, llllllllllIllllIllIIIllllllIIIII);
            }
        }
        BiomeTaiga.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);
        for (int llllllllllIllllIllIIIlllllIlllll = 0; llllllllllIllllIllIIIlllllIlllll < 7; ++llllllllllIllllIllIIIlllllIlllll) {
            final int llllllllllIllllIllIIIlllllIllllI = llllllllllIllllIllIIIllllllIIllI.nextInt(16) + 8;
            final int llllllllllIllllIllIIIlllllIlllIl = llllllllllIllllIllIIIllllllIIllI.nextInt(16) + 8;
            final int llllllllllIllllIllIIIlllllIlllII = llllllllllIllllIllIIIllllllIIllI.nextInt(llllllllllIllllIllIIIlllllIllIlI.getHeight(llllllllllIllllIllIIIllllllIIlIl.add(llllllllllIllllIllIIIlllllIllllI, 0, llllllllllIllllIllIIIlllllIlllIl)).getY() + 32);
            BiomeTaiga.DOUBLE_PLANT_GENERATOR.generate(llllllllllIllllIllIIIlllllIllIlI, llllllllllIllllIllIIIllllllIIllI, llllllllllIllllIllIIIllllllIIlIl.add(llllllllllIllllIllIIIlllllIllllI, llllllllllIllllIllIIIlllllIlllII, llllllllllIllllIllIIIlllllIlllIl));
        }
        super.decorate(llllllllllIllllIllIIIlllllIllIlI, llllllllllIllllIllIIIllllllIIllI, llllllllllIllllIllIIIllllllIIlIl);
    }
    
    public BiomeTaiga(final Type llllllllllIllllIllIIlIIIIIIIIIII, final BiomeProperties llllllllllIllllIllIIIlllllllllll) {
        super(llllllllllIllllIllIIIlllllllllll);
        this.type = llllllllllIllllIllIIlIIIIIIIIIII;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.theBiomeDecorator.treesPerChunk = 10;
        if (llllllllllIllllIllIIlIIIIIIIIIII != Type.MEGA && llllllllllIllllIllIIlIIIIIIIIIII != Type.MEGA_SPRUCE) {
            this.theBiomeDecorator.grassPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 1;
        }
        else {
            this.theBiomeDecorator.grassPerChunk = 7;
            this.theBiomeDecorator.deadBushPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 3;
        }
    }
    
    public enum Type
    {
        MEGA_SPRUCE("MEGA_SPRUCE", 2), 
        MEGA("MEGA", 1), 
        NORMAL("NORMAL", 0);
        
        private Type(final String llllllllllllllIIIllllIllIlIlIlll, final int llllllllllllllIIIllllIllIlIlIllI) {
        }
    }
}
