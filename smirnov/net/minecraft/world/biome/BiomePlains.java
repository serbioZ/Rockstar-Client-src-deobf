// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.block.BlockFlower;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityHorse;

public class BiomePlains extends Biome
{
    protected /* synthetic */ boolean sunflowers;
    
    protected BiomePlains(final boolean llllllllllllIlIIIIllIlIllIIIllII, final BiomeProperties llllllllllllIlIIIIllIlIllIIIlIll) {
        super(llllllllllllIlIIIIllIlIllIIIlIll);
        this.sunflowers = llllllllllllIlIIIIllIlIllIIIllII;
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDonkey.class, 1, 1, 3));
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.extraTreeChance = 0.05f;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }
    
    @Override
    public void decorate(final World llllllllllllIlIIIIllIlIlIlllIIlI, final Random llllllllllllIlIIIIllIlIlIlllIIIl, final BlockPos llllllllllllIlIIIIllIlIlIlllIIII) {
        final double llllllllllllIlIIIIllIlIlIllIllll = BiomePlains.GRASS_COLOR_NOISE.getValue((llllllllllllIlIIIIllIlIlIlllIIII.getX() + 8) / 200.0, (llllllllllllIlIIIIllIlIlIlllIIII.getZ() + 8) / 200.0);
        if (llllllllllllIlIIIIllIlIlIllIllll < -0.8) {
            this.theBiomeDecorator.flowersPerChunk = 15;
            this.theBiomeDecorator.grassPerChunk = 5;
        }
        else {
            this.theBiomeDecorator.flowersPerChunk = 4;
            this.theBiomeDecorator.grassPerChunk = 10;
            BiomePlains.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);
            for (int llllllllllllIlIIIIllIlIlIllIlllI = 0; llllllllllllIlIIIIllIlIlIllIlllI < 7; ++llllllllllllIlIIIIllIlIlIllIlllI) {
                final int llllllllllllIlIIIIllIlIlIllIllIl = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(16) + 8;
                final int llllllllllllIlIIIIllIlIlIllIllII = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(16) + 8;
                final int llllllllllllIlIIIIllIlIlIllIlIll = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(llllllllllllIlIIIIllIlIlIlllIIlI.getHeight(llllllllllllIlIIIIllIlIlIlllIIII.add(llllllllllllIlIIIIllIlIlIllIllIl, 0, llllllllllllIlIIIIllIlIlIllIllII)).getY() + 32);
                BiomePlains.DOUBLE_PLANT_GENERATOR.generate(llllllllllllIlIIIIllIlIlIlllIIlI, llllllllllllIlIIIIllIlIlIlllIIIl, llllllllllllIlIIIIllIlIlIlllIIII.add(llllllllllllIlIIIIllIlIlIllIllIl, llllllllllllIlIIIIllIlIlIllIlIll, llllllllllllIlIIIIllIlIlIllIllII));
            }
        }
        if (this.sunflowers) {
            BiomePlains.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SUNFLOWER);
            for (int llllllllllllIlIIIIllIlIlIllIlIlI = 0; llllllllllllIlIIIIllIlIlIllIlIlI < 10; ++llllllllllllIlIIIIllIlIlIllIlIlI) {
                final int llllllllllllIlIIIIllIlIlIllIlIIl = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(16) + 8;
                final int llllllllllllIlIIIIllIlIlIllIlIII = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(16) + 8;
                final int llllllllllllIlIIIIllIlIlIllIIlll = llllllllllllIlIIIIllIlIlIlllIIIl.nextInt(llllllllllllIlIIIIllIlIlIlllIIlI.getHeight(llllllllllllIlIIIIllIlIlIlllIIII.add(llllllllllllIlIIIIllIlIlIllIlIIl, 0, llllllllllllIlIIIIllIlIlIllIlIII)).getY() + 32);
                BiomePlains.DOUBLE_PLANT_GENERATOR.generate(llllllllllllIlIIIIllIlIlIlllIIlI, llllllllllllIlIIIIllIlIlIlllIIIl, llllllllllllIlIIIIllIlIlIlllIIII.add(llllllllllllIlIIIIllIlIlIllIlIIl, llllllllllllIlIIIIllIlIlIllIIlll, llllllllllllIlIIIIllIlIlIllIlIII));
            }
        }
        super.decorate(llllllllllllIlIIIIllIlIlIlllIIlI, llllllllllllIlIIIIllIlIlIlllIIIl, llllllllllllIlIIIIllIlIlIlllIIII);
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllIlIIIIllIlIlIlIllIll) {
        return (llllllllllllIlIIIIllIlIlIlIllIll.nextInt(3) == 0) ? BiomePlains.BIG_TREE_FEATURE : BiomePlains.TREE_FEATURE;
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllIlIIIIllIlIllIIIIlIl, final BlockPos llllllllllllIlIIIIllIlIlIlllllll) {
        final double llllllllllllIlIIIIllIlIllIIIIIll = BiomePlains.GRASS_COLOR_NOISE.getValue(llllllllllllIlIIIIllIlIlIlllllll.getX() / 200.0, llllllllllllIlIIIIllIlIlIlllllll.getZ() / 200.0);
        if (llllllllllllIlIIIIllIlIllIIIIIll < -0.8) {
            final int llllllllllllIlIIIIllIlIllIIIIIlI = llllllllllllIlIIIIllIlIllIIIIlIl.nextInt(4);
            switch (llllllllllllIlIIIIllIlIllIIIIIlI) {
                case 0: {
                    return BlockFlower.EnumFlowerType.ORANGE_TULIP;
                }
                case 1: {
                    return BlockFlower.EnumFlowerType.RED_TULIP;
                }
                case 2: {
                    return BlockFlower.EnumFlowerType.PINK_TULIP;
                }
                default: {
                    return BlockFlower.EnumFlowerType.WHITE_TULIP;
                }
            }
        }
        else {
            if (llllllllllllIlIIIIllIlIllIIIIlIl.nextInt(3) <= 0) {
                return BlockFlower.EnumFlowerType.DANDELION;
            }
            final int llllllllllllIlIIIIllIlIllIIIIIIl = llllllllllllIlIIIIllIlIllIIIIlIl.nextInt(3);
            if (llllllllllllIlIIIIllIlIllIIIIIIl == 0) {
                return BlockFlower.EnumFlowerType.POPPY;
            }
            return (llllllllllllIlIIIIllIlIllIIIIIIl == 1) ? BlockFlower.EnumFlowerType.HOUSTONIA : BlockFlower.EnumFlowerType.OXEYE_DAISY;
        }
    }
}
