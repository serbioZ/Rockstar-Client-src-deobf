// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityEnderman;

public class BiomeEnd extends Biome
{
    public BiomeEnd(final BiomeProperties lllllllllllIlIIIIlIIlllllIlIIlIl) {
        super(lllllllllllIlIIIIlIIlllllIlIIlIl);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = Blocks.DIRT.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.theBiomeDecorator = new BiomeEndDecorator();
    }
    
    @Override
    public int getSkyColorByTemp(final float lllllllllllIlIIIIlIIlllllIlIIIIl) {
        return 0;
    }
}
