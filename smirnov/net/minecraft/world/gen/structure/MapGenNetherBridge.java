// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityBlaze;
import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import java.util.List;

public class MapGenNetherBridge extends MapGenStructure
{
    private final /* synthetic */ List<Biome.SpawnListEntry> spawnList;
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllIIIIlIlIIIlIlIIlllIII, final BlockPos lllllllllllIIIIlIlIIIlIlIIllIlll, final boolean lllllllllllIIIIlIlIIIlIlIIllIllI) {
        final int lllllllllllIIIIlIlIIIlIlIlIIIIll = 1000;
        final int lllllllllllIIIIlIlIIIlIlIlIIIIlI = lllllllllllIIIIlIlIIIlIlIIllIlll.getX() >> 4;
        final int lllllllllllIIIIlIlIIIlIlIlIIIIIl = lllllllllllIIIIlIlIIIlIlIIllIlll.getZ() >> 4;
        for (int lllllllllllIIIIlIlIIIlIlIlIIIIII = 0; lllllllllllIIIIlIlIIIlIlIlIIIIII <= 1000; ++lllllllllllIIIIlIlIIIlIlIlIIIIII) {
            for (int lllllllllllIIIIlIlIIIlIlIIllllll = -lllllllllllIIIIlIlIIIlIlIlIIIIII; lllllllllllIIIIlIlIIIlIlIIllllll <= lllllllllllIIIIlIlIIIlIlIlIIIIII; ++lllllllllllIIIIlIlIIIlIlIIllllll) {
                final boolean lllllllllllIIIIlIlIIIlIlIIlllllI = lllllllllllIIIIlIlIIIlIlIIllllll == -lllllllllllIIIIlIlIIIlIlIlIIIIII || lllllllllllIIIIlIlIIIlIlIIllllll == lllllllllllIIIIlIlIIIlIlIlIIIIII;
                for (int lllllllllllIIIIlIlIIIlIlIIllllIl = -lllllllllllIIIIlIlIIIlIlIlIIIIII; lllllllllllIIIIlIlIIIlIlIIllllIl <= lllllllllllIIIIlIlIIIlIlIlIIIIII; ++lllllllllllIIIIlIlIIIlIlIIllllIl) {
                    final boolean lllllllllllIIIIlIlIIIlIlIIllllII = lllllllllllIIIIlIlIIIlIlIIllllIl == -lllllllllllIIIIlIlIIIlIlIlIIIIII || lllllllllllIIIIlIlIIIlIlIIllllIl == lllllllllllIIIIlIlIIIlIlIlIIIIII;
                    if (lllllllllllIIIIlIlIIIlIlIIlllllI || lllllllllllIIIIlIlIIIlIlIIllllII) {
                        final int lllllllllllIIIIlIlIIIlIlIIlllIll = lllllllllllIIIIlIlIIIlIlIlIIIIlI + lllllllllllIIIIlIlIIIlIlIIllllll;
                        final int lllllllllllIIIIlIlIIIlIlIIlllIlI = lllllllllllIIIIlIlIIIlIlIlIIIIIl + lllllllllllIIIIlIlIIIlIlIIllllIl;
                        if (this.canSpawnStructureAtCoords(lllllllllllIIIIlIlIIIlIlIIlllIll, lllllllllllIIIIlIlIIIlIlIIlllIlI) && (!lllllllllllIIIIlIlIIIlIlIIllIllI || !lllllllllllIIIIlIlIIIlIlIIlllIII.func_190526_b(lllllllllllIIIIlIlIIIlIlIIlllIll, lllllllllllIIIIlIlIIIlIlIIlllIlI))) {
                            return new BlockPos((lllllllllllIIIIlIlIIIlIlIIlllIll << 4) + 8, 64, (lllllllllllIIIIlIlIIIlIlIIlllIlI << 4) + 8);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllIIIIlIlIIIlIlIlIlIlll, final int lllllllllllIIIIlIlIIIlIlIlIlIllI) {
        return new Start(this.worldObj, this.rand, lllllllllllIIIIlIlIIIlIlIlIlIlll, lllllllllllIIIIlIlIIIlIlIlIlIllI);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllIIIIlIlIIIlIlIllIIlll, final int lllllllllllIIIIlIlIIIlIlIllIIllI) {
        final int lllllllllllIIIIlIlIIIlIlIllIIlIl = lllllllllllIIIIlIlIIIlIlIllIIlll >> 4;
        final int lllllllllllIIIIlIlIIIlIlIllIIlII = lllllllllllIIIIlIlIIIlIlIllIIllI >> 4;
        this.rand.setSeed((long)(lllllllllllIIIIlIlIIIlIlIllIIlIl ^ lllllllllllIIIIlIlIIIlIlIllIIlII << 4) ^ this.worldObj.getSeed());
        this.rand.nextInt();
        return this.rand.nextInt(3) == 0 && lllllllllllIIIIlIlIIIlIlIllIIlll == (lllllllllllIIIIlIlIIIlIlIllIIlIl << 4) + 4 + this.rand.nextInt(8) && lllllllllllIIIIlIlIIIlIlIllIIllI == (lllllllllllIIIIlIlIIIlIlIllIIlII << 4) + 4 + this.rand.nextInt(8);
    }
    
    public MapGenNetherBridge() {
        this.spawnList = (List<Biome.SpawnListEntry>)Lists.newArrayList();
        this.spawnList.add(new Biome.SpawnListEntry(EntityBlaze.class, 10, 2, 3));
        this.spawnList.add(new Biome.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
        this.spawnList.add(new Biome.SpawnListEntry(EntityWitherSkeleton.class, 8, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 2, 5, 5));
        this.spawnList.add(new Biome.SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
    }
    
    public List<Biome.SpawnListEntry> getSpawnList() {
        return this.spawnList;
    }
    
    @Override
    public String getStructureName() {
        return "Fortress";
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        public Start(final World llllllllllllIllllllIllIlIlIlIIlI, final Random llllllllllllIllllllIllIlIlIIlIII, final int llllllllllllIllllllIllIlIlIIIlll, final int llllllllllllIllllllIllIlIlIIllll) {
            super(llllllllllllIllllllIllIlIlIIIlll, llllllllllllIllllllIllIlIlIIllll);
            final StructureNetherBridgePieces.Start llllllllllllIllllllIllIlIlIIlllI = new StructureNetherBridgePieces.Start(llllllllllllIllllllIllIlIlIIlIII, (llllllllllllIllllllIllIlIlIIIlll << 4) + 2, (llllllllllllIllllllIllIlIlIIllll << 4) + 2);
            this.components.add(llllllllllllIllllllIllIlIlIIlllI);
            llllllllllllIllllllIllIlIlIIlllI.buildComponent(llllllllllllIllllllIllIlIlIIlllI, this.components, llllllllllllIllllllIllIlIlIIlIII);
            final List<StructureComponent> llllllllllllIllllllIllIlIlIIllIl = llllllllllllIllllllIllIlIlIIlllI.pendingChildren;
            while (!llllllllllllIllllllIllIlIlIIllIl.isEmpty()) {
                final int llllllllllllIllllllIllIlIlIIllII = llllllllllllIllllllIllIlIlIIlIII.nextInt(llllllllllllIllllllIllIlIlIIllIl.size());
                final StructureComponent llllllllllllIllllllIllIlIlIIlIll = llllllllllllIllllllIllIlIlIIllIl.remove(llllllllllllIllllllIllIlIlIIllII);
                llllllllllllIllllllIllIlIlIIlIll.buildComponent(llllllllllllIllllllIllIlIlIIlllI, this.components, llllllllllllIllllllIllIlIlIIlIII);
            }
            this.updateBoundingBox();
            this.setRandomHeight(llllllllllllIllllllIllIlIlIlIIlI, llllllllllllIllllllIllIlIlIIlIII, 48, 70);
        }
    }
}
