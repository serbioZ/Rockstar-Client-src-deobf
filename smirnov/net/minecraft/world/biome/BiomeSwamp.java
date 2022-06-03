// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.block.BlockFlower;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.block.state.IBlockState;

public class BiomeSwamp extends Biome
{
    protected static final /* synthetic */ IBlockState WATER_LILY;
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllIIlIllIIIllIIllIIIll) {
        return BiomeSwamp.SWAMP_FEATURE;
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllIIlIllIIIllIIlIIlIlI, final Random llllllllllllIIlIllIIIllIIIlllllI, final ChunkPrimer llllllllllllIIlIllIIIllIIIllllIl, final int llllllllllllIIlIllIIIllIIlIIIlll, final int llllllllllllIIlIllIIIllIIIlllIll, final double llllllllllllIIlIllIIIllIIlIIIlIl) {
        final double llllllllllllIIlIllIIIllIIlIIIlII = BiomeSwamp.GRASS_COLOR_NOISE.getValue(llllllllllllIIlIllIIIllIIlIIIlll * 0.25, llllllllllllIIlIllIIIllIIIlllIll * 0.25);
        if (llllllllllllIIlIllIIIllIIlIIIlII > 0.0) {
            final int llllllllllllIIlIllIIIllIIlIIIIll = llllllllllllIIlIllIIIllIIlIIIlll & 0xF;
            final int llllllllllllIIlIllIIIllIIlIIIIlI = llllllllllllIIlIllIIIllIIIlllIll & 0xF;
            int llllllllllllIIlIllIIIllIIlIIIIIl = 255;
            while (llllllllllllIIlIllIIIllIIlIIIIIl >= 0) {
                if (llllllllllllIIlIllIIIllIIIllllIl.getBlockState(llllllllllllIIlIllIIIllIIlIIIIlI, llllllllllllIIlIllIIIllIIlIIIIIl, llllllllllllIIlIllIIIllIIlIIIIll).getMaterial() != Material.AIR) {
                    if (llllllllllllIIlIllIIIllIIlIIIIIl != 62 || llllllllllllIIlIllIIIllIIIllllIl.getBlockState(llllllllllllIIlIllIIIllIIlIIIIlI, llllllllllllIIlIllIIIllIIlIIIIIl, llllllllllllIIlIllIIIllIIlIIIIll).getBlock() == Blocks.WATER) {
                        break;
                    }
                    llllllllllllIIlIllIIIllIIIllllIl.setBlockState(llllllllllllIIlIllIIIllIIlIIIIlI, llllllllllllIIlIllIIIllIIlIIIIIl, llllllllllllIIlIllIIIllIIlIIIIll, BiomeSwamp.WATER);
                    if (llllllllllllIIlIllIIIllIIlIIIlII < 0.12) {
                        llllllllllllIIlIllIIIllIIIllllIl.setBlockState(llllllllllllIIlIllIIIllIIlIIIIlI, llllllllllllIIlIllIIIllIIlIIIIIl + 1, llllllllllllIIlIllIIIllIIlIIIIll, BiomeSwamp.WATER_LILY);
                        break;
                    }
                    break;
                }
                else {
                    --llllllllllllIIlIllIIIllIIlIIIIIl;
                }
            }
        }
        this.generateBiomeTerrain(llllllllllllIIlIllIIIllIIlIIlIlI, llllllllllllIIlIllIIIllIIIlllllI, llllllllllllIIlIllIIIllIIIllllIl, llllllllllllIIlIllIIIllIIlIIIlll, llllllllllllIIlIllIIIllIIIlllIll, llllllllllllIIlIllIIIllIIlIIIlIl);
    }
    
    @Override
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random llllllllllllIIlIllIIIllIIlIllIII, final BlockPos llllllllllllIIlIllIIIllIIlIlIlll) {
        return BlockFlower.EnumFlowerType.BLUE_ORCHID;
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos llllllllllllIIlIllIIIllIIlIlllIl) {
        final double llllllllllllIIlIllIIIllIIlIllllI = BiomeSwamp.GRASS_COLOR_NOISE.getValue(llllllllllllIIlIllIIIllIIlIlllIl.getX() * 0.0225, llllllllllllIIlIllIIIllIIlIlllIl.getZ() * 0.0225);
        return (llllllllllllIIlIllIIIllIIlIllllI < -0.1) ? 5011004 : 6975545;
    }
    
    @Override
    public int getFoliageColorAtPos(final BlockPos llllllllllllIIlIllIIIllIIlIllIlI) {
        return 6975545;
    }
    
    static {
        WATER_LILY = Blocks.WATERLILY.getDefaultState();
    }
    
    protected BiomeSwamp(final BiomeProperties llllllllllllIIlIllIIIllIIllIIlll) {
        super(llllllllllllIIlIllIIIllIIllIIlll);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 4;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
    }
    
    @Override
    public void decorate(final World llllllllllllIIlIllIIIllIIIllIIII, final Random llllllllllllIIlIllIIIllIIIlIlIll, final BlockPos llllllllllllIIlIllIIIllIIIlIlllI) {
        super.decorate(llllllllllllIIlIllIIIllIIIllIIII, llllllllllllIIlIllIIIllIIIlIlIll, llllllllllllIIlIllIIIllIIIlIlllI);
        if (llllllllllllIIlIllIIIllIIIlIlIll.nextInt(64) == 0) {
            new WorldGenFossils().generate(llllllllllllIIlIllIIIllIIIllIIII, llllllllllllIIlIllIIIllIIIlIlIll, llllllllllllIIlIllIIIllIIIlIlllI);
        }
    }
}
