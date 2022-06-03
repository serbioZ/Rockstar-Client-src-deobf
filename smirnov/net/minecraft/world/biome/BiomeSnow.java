// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenIcePath;
import net.minecraft.world.gen.feature.WorldGenIceSpike;

public class BiomeSnow extends Biome
{
    private final /* synthetic */ boolean superIcy;
    private final /* synthetic */ WorldGenIceSpike iceSpike;
    private final /* synthetic */ WorldGenIcePath icePatch;
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIllllIllIIIIIIIIIlI) {
        return new WorldGenTaiga2(false);
    }
    
    public BiomeSnow(final boolean lllllllllllllIllllIllIIIIIlIIIII, final BiomeProperties lllllllllllllIllllIllIIIIIlIIlII) {
        super(lllllllllllllIllllIllIIIIIlIIlII);
        this.iceSpike = new WorldGenIceSpike();
        this.icePatch = new WorldGenIcePath(4);
        this.superIcy = lllllllllllllIllllIllIIIIIlIIIII;
        if (lllllllllllllIllllIllIIIIIlIIIII) {
            this.topBlock = Blocks.SNOW.getDefaultState();
        }
        this.spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 10, 2, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 1, 1, 2));
        final Iterator<SpawnListEntry> lllllllllllllIllllIllIIIIIlIIIll = this.spawnableMonsterList.iterator();
        while (lllllllllllllIllllIllIIIIIlIIIll.hasNext()) {
            final SpawnListEntry lllllllllllllIllllIllIIIIIlIIIlI = lllllllllllllIllllIllIIIIIlIIIll.next();
            if (lllllllllllllIllllIllIIIIIlIIIlI.entityClass == EntitySkeleton.class) {
                lllllllllllllIllllIllIIIIIlIIIll.remove();
            }
        }
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 20, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 80, 4, 4));
    }
    
    @Override
    public float getSpawningChance() {
        return 0.07f;
    }
    
    @Override
    public void decorate(final World lllllllllllllIllllIllIIIIIIIlIIl, final Random lllllllllllllIllllIllIIIIIIlIIlI, final BlockPos lllllllllllllIllllIllIIIIIIlIIIl) {
        if (this.superIcy) {
            for (int lllllllllllllIllllIllIIIIIIlIIII = 0; lllllllllllllIllllIllIIIIIIlIIII < 3; ++lllllllllllllIllllIllIIIIIIlIIII) {
                final int lllllllllllllIllllIllIIIIIIIllll = lllllllllllllIllllIllIIIIIIlIIlI.nextInt(16) + 8;
                final int lllllllllllllIllllIllIIIIIIIlllI = lllllllllllllIllllIllIIIIIIlIIlI.nextInt(16) + 8;
                this.iceSpike.generate(lllllllllllllIllllIllIIIIIIIlIIl, lllllllllllllIllllIllIIIIIIlIIlI, lllllllllllllIllllIllIIIIIIIlIIl.getHeight(lllllllllllllIllllIllIIIIIIlIIIl.add(lllllllllllllIllllIllIIIIIIIllll, 0, lllllllllllllIllllIllIIIIIIIlllI)));
            }
            for (int lllllllllllllIllllIllIIIIIIIllIl = 0; lllllllllllllIllllIllIIIIIIIllIl < 2; ++lllllllllllllIllllIllIIIIIIIllIl) {
                final int lllllllllllllIllllIllIIIIIIIllII = lllllllllllllIllllIllIIIIIIlIIlI.nextInt(16) + 8;
                final int lllllllllllllIllllIllIIIIIIIlIll = lllllllllllllIllllIllIIIIIIlIIlI.nextInt(16) + 8;
                this.icePatch.generate(lllllllllllllIllllIllIIIIIIIlIIl, lllllllllllllIllllIllIIIIIIlIIlI, lllllllllllllIllllIllIIIIIIIlIIl.getHeight(lllllllllllllIllllIllIIIIIIlIIIl.add(lllllllllllllIllllIllIIIIIIIllII, 0, lllllllllllllIllllIllIIIIIIIlIll)));
            }
        }
        super.decorate(lllllllllllllIllllIllIIIIIIIlIIl, lllllllllllllIllllIllIIIIIIlIIlI, lllllllllllllIllllIllIIIIIIlIIIl);
    }
}
