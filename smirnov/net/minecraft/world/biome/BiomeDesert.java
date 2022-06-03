// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;

public class BiomeDesert extends Biome
{
    public BiomeDesert(final BiomeProperties lllllllllllIlIIlllllIlIlllIIlIII) {
        super(lllllllllllIlIIlllllIlIlllIIlIII);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        final Iterator<SpawnListEntry> lllllllllllIlIIlllllIlIlllIIlIll = this.spawnableMonsterList.iterator();
        while (lllllllllllIlIIlllllIlIlllIIlIll.hasNext()) {
            final SpawnListEntry lllllllllllIlIIlllllIlIlllIIlIlI = lllllllllllIlIIlllllIlIlllIIlIll.next();
            if (lllllllllllIlIIlllllIlIlllIIlIlI.entityClass == EntityZombie.class || lllllllllllIlIIlllllIlIlllIIlIlI.entityClass == EntityZombieVillager.class) {
                lllllllllllIlIIlllllIlIlllIIlIll.remove();
            }
        }
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }
    
    @Override
    public void decorate(final World lllllllllllIlIIlllllIlIllIllllIl, final Random lllllllllllIlIIlllllIlIllIllIlIl, final BlockPos lllllllllllIlIIlllllIlIllIllIlII) {
        super.decorate(lllllllllllIlIIlllllIlIllIllllIl, lllllllllllIlIIlllllIlIllIllIlIl, lllllllllllIlIIlllllIlIllIllIlII);
        if (lllllllllllIlIIlllllIlIllIllIlIl.nextInt(1000) == 0) {
            final int lllllllllllIlIIlllllIlIllIlllIlI = lllllllllllIlIIlllllIlIllIllIlIl.nextInt(16) + 8;
            final int lllllllllllIlIIlllllIlIllIlllIIl = lllllllllllIlIIlllllIlIllIllIlIl.nextInt(16) + 8;
            final BlockPos lllllllllllIlIIlllllIlIllIlllIII = lllllllllllIlIIlllllIlIllIllllIl.getHeight(lllllllllllIlIIlllllIlIllIllIlII.add(lllllllllllIlIIlllllIlIllIlllIlI, 0, lllllllllllIlIIlllllIlIllIlllIIl)).up();
            new WorldGenDesertWells().generate(lllllllllllIlIIlllllIlIllIllllIl, lllllllllllIlIIlllllIlIllIllIlIl, lllllllllllIlIIlllllIlIllIlllIII);
        }
        if (lllllllllllIlIIlllllIlIllIllIlIl.nextInt(64) == 0) {
            new WorldGenFossils().generate(lllllllllllIlIIlllllIlIllIllllIl, lllllllllllIlIIlllllIlIllIllIlIl, lllllllllllIlIIlllllIlIllIllIlII);
        }
    }
}
