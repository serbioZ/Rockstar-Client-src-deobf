// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;

public class BiomeForest extends Biome
{
    protected static final /* synthetic */ WorldGenCanopyTree ROOF_TREE;
    private final /* synthetic */ Type type;
    protected static final /* synthetic */ WorldGenBirchTree BIRCH_TREE;
    
    protected void addMushrooms(final World llllllllllllIIlIIIllIIIlIllIIIll, final Random llllllllllllIIlIIIllIIIlIllIllIl, final BlockPos llllllllllllIIlIIIllIIIlIllIllII) {
        for (int llllllllllllIIlIIIllIIIlIllIlIll = 0; llllllllllllIIlIIIllIIIlIllIlIll < 4; ++llllllllllllIIlIIIllIIIlIllIlIll) {
            for (int llllllllllllIIlIIIllIIIlIllIlIlI = 0; llllllllllllIIlIIIllIIIlIllIlIlI < 4; ++llllllllllllIIlIIIllIIIlIllIlIlI) {
                final int llllllllllllIIlIIIllIIIlIllIlIIl = llllllllllllIIlIIIllIIIlIllIlIll * 4 + 1 + 8 + llllllllllllIIlIIIllIIIlIllIllIl.nextInt(3);
                final int llllllllllllIIlIIIllIIIlIllIlIII = llllllllllllIIlIIIllIIIlIllIlIlI * 4 + 1 + 8 + llllllllllllIIlIIIllIIIlIllIllIl.nextInt(3);
                final BlockPos llllllllllllIIlIIIllIIIlIllIIlll = llllllllllllIIlIIIllIIIlIllIIIll.getHeight(llllllllllllIIlIIIllIIIlIllIllII.add(llllllllllllIIlIIIllIIIlIllIlIIl, 0, llllllllllllIIlIIIllIIIlIllIlIII));
                if (llllllllllllIIlIIIllIIIlIllIllIl.nextInt(20) == 0) {
                    final WorldGenBigMushroom llllllllllllIIlIIIllIIIlIllIIllI = new WorldGenBigMushroom();
                    llllllllllllIIlIIIllIIIlIllIIllI.generate(llllllllllllIIlIIIllIIIlIllIIIll, llllllllllllIIlIIIllIIIlIllIllIl, llllllllllllIIlIIIllIIIlIllIIlll);
                }
                else {
                    final WorldGenAbstractTree llllllllllllIIlIIIllIIIlIllIIlIl = this.genBigTreeChance(llllllllllllIIlIIIllIIIlIllIllIl);
                    llllllllllllIIlIIIllIIIlIllIIlIl.setDecorationDefaults();
                    if (llllllllllllIIlIIIllIIIlIllIIlIl.generate(llllllllllllIIlIIIllIIIlIllIIIll, llllllllllllIIlIIIllIIIlIllIllIl, llllllllllllIIlIIIllIIIlIllIIlll)) {
                        llllllllllllIIlIIIllIIIlIllIIlIl.generateSaplings(llllllllllllIIlIIIllIIIlIllIIIll, llllllllllllIIlIIIllIIIlIllIllIl, llllllllllllIIlIIIllIIIlIllIIlll);
                    }
                }
            }
        }
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllIIlIIIllIIIllIIllIlI) {
        if (this.type == Type.ROOFED && llllllllllllIIlIIIllIIIllIIllIlI.nextInt(3) > 0) {
            return BiomeForest.ROOF_TREE;
        }
        if (this.type != Type.BIRCH && llllllllllllIIlIIIllIIIllIIllIlI.nextInt(5) != 0) {
            return (llllllllllllIIlIIIllIIIllIIllIlI.nextInt(10) == 0) ? BiomeForest.BIG_TREE_FEATURE : BiomeForest.TREE_FEATURE;
        }
        return BiomeForest.BIRCH_TREE;
    }
    
    public BiomeForest(final Type llllllllllllIIlIIIllIIIllIIlllll, final BiomeProperties llllllllllllIIlIIIllIIIllIlIIIIl) {
        super(llllllllllllIIlIIIllIIIllIlIIIIl);
        this.type = llllllllllllIIlIIIllIIIllIIlllll;
        this.theBiomeDecorator.treesPerChunk = 10;
        this.theBiomeDecorator.grassPerChunk = 2;
        if (this.type == Type.FLOWER) {
            this.theBiomeDecorator.treesPerChunk = 6;
            this.theBiomeDecorator.flowersPerChunk = 100;
            this.theBiomeDecorator.grassPerChunk = 1;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        }
        if (this.type == Type.NORMAL) {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        }
        if (this.type == Type.ROOFED) {
            this.theBiomeDecorator.treesPerChunk = -999;
        }
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllIIlIIIllIIIllIIlIIIl, final BlockPos llllllllllllIIlIIIllIIIllIIlIIII) {
        if (this.type == Type.FLOWER) {
            final double llllllllllllIIlIIIllIIIllIIIllll = MathHelper.clamp((1.0 + BiomeForest.GRASS_COLOR_NOISE.getValue(llllllllllllIIlIIIllIIIllIIlIIII.getX() / 48.0, llllllllllllIIlIIIllIIIllIIlIIII.getZ() / 48.0)) / 2.0, 0.0, 0.9999);
            final BlockFlower.EnumFlowerType llllllllllllIIlIIIllIIIllIIIlllI = BlockFlower.EnumFlowerType.values()[(int)(llllllllllllIIlIIIllIIIllIIIllll * BlockFlower.EnumFlowerType.values().length)];
            return (llllllllllllIIlIIIllIIIllIIIlllI == BlockFlower.EnumFlowerType.BLUE_ORCHID) ? BlockFlower.EnumFlowerType.POPPY : llllllllllllIIlIIIllIIIllIIIlllI;
        }
        return super.pickRandomFlower(llllllllllllIIlIIIllIIIllIIlIIIl, llllllllllllIIlIIIllIIIllIIlIIII);
    }
    
    static {
        SUPER_BIRCH_TREE = new WorldGenBirchTree(false, true);
        BIRCH_TREE = new WorldGenBirchTree(false, false);
        ROOF_TREE = new WorldGenCanopyTree(false);
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos llllllllllllIIlIIIllIIIlIIllIllI) {
        final int llllllllllllIIlIIIllIIIlIIllIlIl = super.getGrassColorAtPos(llllllllllllIIlIIIllIIIlIIllIllI);
        return (this.type == Type.ROOFED) ? ((llllllllllllIIlIIIllIIIlIIllIlIl & 0xFEFEFE) + 2634762 >> 1) : llllllllllllIIlIIIllIIIlIIllIlIl;
    }
    
    @Override
    public Class<? extends Biome> getBiomeClass() {
        return BiomeForest.class;
    }
    
    protected void addDoublePlants(final World llllllllllllIIlIIIllIIIlIlIIllll, final Random llllllllllllIIlIIIllIIIlIlIIlllI, final BlockPos llllllllllllIIlIIIllIIIlIlIIIIll, final int llllllllllllIIlIIIllIIIlIlIIIIlI) {
        for (int llllllllllllIIlIIIllIIIlIlIIlIll = 0; llllllllllllIIlIIIllIIIlIlIIlIll < llllllllllllIIlIIIllIIIlIlIIIIlI; ++llllllllllllIIlIIIllIIIlIlIIlIll) {
            final int llllllllllllIIlIIIllIIIlIlIIlIlI = llllllllllllIIlIIIllIIIlIlIIlllI.nextInt(3);
            if (llllllllllllIIlIIIllIIIlIlIIlIlI == 0) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
            }
            else if (llllllllllllIIlIIIllIIIlIlIIlIlI == 1) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
            }
            else if (llllllllllllIIlIIIllIIIlIlIIlIlI == 2) {
                BiomeForest.DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
            }
            for (int llllllllllllIIlIIIllIIIlIlIIlIIl = 0; llllllllllllIIlIIIllIIIlIlIIlIIl < 5; ++llllllllllllIIlIIIllIIIlIlIIlIIl) {
                final int llllllllllllIIlIIIllIIIlIlIIlIII = llllllllllllIIlIIIllIIIlIlIIlllI.nextInt(16) + 8;
                final int llllllllllllIIlIIIllIIIlIlIIIlll = llllllllllllIIlIIIllIIIlIlIIlllI.nextInt(16) + 8;
                final int llllllllllllIIlIIIllIIIlIlIIIllI = llllllllllllIIlIIIllIIIlIlIIlllI.nextInt(llllllllllllIIlIIIllIIIlIlIIllll.getHeight(llllllllllllIIlIIIllIIIlIlIIIIll.add(llllllllllllIIlIIIllIIIlIlIIlIII, 0, llllllllllllIIlIIIllIIIlIlIIIlll)).getY() + 32);
                if (BiomeForest.DOUBLE_PLANT_GENERATOR.generate(llllllllllllIIlIIIllIIIlIlIIllll, llllllllllllIIlIIIllIIIlIlIIlllI, new BlockPos(llllllllllllIIlIIIllIIIlIlIIIIll.getX() + llllllllllllIIlIIIllIIIlIlIIlIII, llllllllllllIIlIIIllIIIlIlIIIllI, llllllllllllIIlIIIllIIIlIlIIIIll.getZ() + llllllllllllIIlIIIllIIIlIlIIIlll))) {
                    break;
                }
            }
        }
    }
    
    @Override
    public void decorate(final World llllllllllllIIlIIIllIIIllIIIIIlI, final Random llllllllllllIIlIIIllIIIllIIIIIIl, final BlockPos llllllllllllIIlIIIllIIIllIIIIIII) {
        if (this.type == Type.ROOFED) {
            this.addMushrooms(llllllllllllIIlIIIllIIIllIIIIIlI, llllllllllllIIlIIIllIIIllIIIIIIl, llllllllllllIIlIIIllIIIllIIIIIII);
        }
        int llllllllllllIIlIIIllIIIlIlllllll = llllllllllllIIlIIIllIIIllIIIIIIl.nextInt(5) - 3;
        if (this.type == Type.FLOWER) {
            llllllllllllIIlIIIllIIIlIlllllll += 2;
        }
        this.addDoublePlants(llllllllllllIIlIIIllIIIllIIIIIlI, llllllllllllIIlIIIllIIIllIIIIIIl, llllllllllllIIlIIIllIIIllIIIIIII, llllllllllllIIlIIIllIIIlIlllllll);
        super.decorate(llllllllllllIIlIIIllIIIllIIIIIlI, llllllllllllIIlIIIllIIIllIIIIIIl, llllllllllllIIlIIIllIIIllIIIIIII);
    }
    
    public enum Type
    {
        ROOFED("ROOFED", 3), 
        NORMAL("NORMAL", 0), 
        BIRCH("BIRCH", 2), 
        FLOWER("FLOWER", 1);
        
        private Type(final String lllllllllllIIIIlIIIIlIlIlllllIIl, final int lllllllllllIIIIlIIIIlIlIlllllIII) {
        }
    }
}
