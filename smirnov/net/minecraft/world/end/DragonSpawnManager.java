// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.end;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityEnderCrystal;
import java.util.List;
import net.minecraft.world.WorldServer;

public enum DragonSpawnManager
{
    START(0) {
        @Override
        public void process(final WorldServer lllllllllllIIIIllIIllllIIllllIIl, final DragonFightManager lllllllllllIIIIllIIllllIIllllIII, final List<EntityEnderCrystal> lllllllllllIIIIllIIllllIIlllIlll, final int lllllllllllIIIIllIIllllIIlllIllI, final BlockPos lllllllllllIIIIllIIllllIIlllIlIl) {
            final BlockPos lllllllllllIIIIllIIllllIIlllIlII = new BlockPos(0, 128, 0);
            for (final EntityEnderCrystal lllllllllllIIIIllIIllllIIlllIIll : lllllllllllIIIIllIIllllIIlllIlll) {
                lllllllllllIIIIllIIllllIIlllIIll.setBeamTarget(lllllllllllIIIIllIIllllIIlllIlII);
            }
            lllllllllllIIIIllIIllllIIllllIII.setRespawnState(DragonSpawnManager$1.PREPARING_TO_SUMMON_PILLARS);
        }
    }, 
    END(4) {
        @Override
        public void process(final WorldServer llllllllllIlllllIIllIlIIlIIIlIll, final DragonFightManager llllllllllIlllllIIllIlIIlIIIlIlI, final List<EntityEnderCrystal> llllllllllIlllllIIllIlIIlIIIlIIl, final int llllllllllIlllllIIllIlIIlIIIlIII, final BlockPos llllllllllIlllllIIllIlIIlIIIIlll) {
        }
    }, 
    PREPARING_TO_SUMMON_PILLARS(1) {
        @Override
        public void process(final WorldServer llllllllllllIlIIIlllIIlIIIllIlll, final DragonFightManager llllllllllllIlIIIlllIIlIIIllIIIl, final List<EntityEnderCrystal> llllllllllllIlIIIlllIIlIIIllIlIl, final int llllllllllllIlIIIlllIIlIIIllIIII, final BlockPos llllllllllllIlIIIlllIIlIIIllIIll) {
            if (llllllllllllIlIIIlllIIlIIIllIIII < 100) {
                if (llllllllllllIlIIIlllIIlIIIllIIII == 0 || llllllllllllIlIIIlllIIlIIIllIIII == 50 || llllllllllllIlIIIlllIIlIIIllIIII == 51 || llllllllllllIlIIIlllIIlIIIllIIII == 52 || llllllllllllIlIIIlllIIlIIIllIIII >= 95) {
                    llllllllllllIlIIIlllIIlIIIllIlll.playEvent(3001, new BlockPos(0, 128, 0), 0);
                }
            }
            else {
                llllllllllllIlIIIlllIIlIIIllIIIl.setRespawnState(DragonSpawnManager$2.SUMMONING_PILLARS);
            }
        }
    }, 
    SUMMONING_PILLARS(2) {
        @Override
        public void process(final WorldServer llllllllllIlllllIlllIlIllllIlIII, final DragonFightManager llllllllllIlllllIlllIlIllllIIlll, final List<EntityEnderCrystal> llllllllllIlllllIlllIlIllllIIllI, final int llllllllllIlllllIlllIlIlllIlIllI, final BlockPos llllllllllIlllllIlllIlIllllIIlII) {
            final int llllllllllIlllllIlllIlIllllIIIll = 40;
            final boolean llllllllllIlllllIlllIlIllllIIIlI = llllllllllIlllllIlllIlIlllIlIllI % 40 == 0;
            final boolean llllllllllIlllllIlllIlIllllIIIIl = llllllllllIlllllIlllIlIlllIlIllI % 40 == 39;
            if (llllllllllIlllllIlllIlIllllIIIlI || llllllllllIlllllIlllIlIllllIIIIl) {
                final WorldGenSpikes.EndSpike[] llllllllllIlllllIlllIlIllllIIIII = BiomeEndDecorator.getSpikesForWorld(llllllllllIlllllIlllIlIllllIlIII);
                final int llllllllllIlllllIlllIlIlllIlllll = llllllllllIlllllIlllIlIlllIlIllI / 40;
                if (llllllllllIlllllIlllIlIlllIlllll < llllllllllIlllllIlllIlIllllIIIII.length) {
                    final WorldGenSpikes.EndSpike llllllllllIlllllIlllIlIlllIllllI = llllllllllIlllllIlllIlIllllIIIII[llllllllllIlllllIlllIlIlllIlllll];
                    if (llllllllllIlllllIlllIlIllllIIIlI) {
                        for (final EntityEnderCrystal llllllllllIlllllIlllIlIlllIlllIl : llllllllllIlllllIlllIlIllllIIllI) {
                            llllllllllIlllllIlllIlIlllIlllIl.setBeamTarget(new BlockPos(llllllllllIlllllIlllIlIlllIllllI.getCenterX(), llllllllllIlllllIlllIlIlllIllllI.getHeight() + 1, llllllllllIlllllIlllIlIlllIllllI.getCenterZ()));
                        }
                    }
                    else {
                        final int llllllllllIlllllIlllIlIlllIlllII = 10;
                        for (final BlockPos.MutableBlockPos llllllllllIlllllIlllIlIlllIllIll : BlockPos.getAllInBoxMutable(new BlockPos(llllllllllIlllllIlllIlIlllIllllI.getCenterX() - 10, llllllllllIlllllIlllIlIlllIllllI.getHeight() - 10, llllllllllIlllllIlllIlIlllIllllI.getCenterZ() - 10), new BlockPos(llllllllllIlllllIlllIlIlllIllllI.getCenterX() + 10, llllllllllIlllllIlllIlIlllIllllI.getHeight() + 10, llllllllllIlllllIlllIlIlllIllllI.getCenterZ() + 10))) {
                            llllllllllIlllllIlllIlIllllIlIII.setBlockToAir(llllllllllIlllllIlllIlIlllIllIll);
                        }
                        llllllllllIlllllIlllIlIllllIlIII.createExplosion(null, llllllllllIlllllIlllIlIlllIllllI.getCenterX() + 0.5f, llllllllllIlllllIlllIlIlllIllllI.getHeight(), llllllllllIlllllIlllIlIlllIllllI.getCenterZ() + 0.5f, 5.0f, true);
                        final WorldGenSpikes llllllllllIlllllIlllIlIlllIllIlI = new WorldGenSpikes();
                        llllllllllIlllllIlllIlIlllIllIlI.setSpike(llllllllllIlllllIlllIlIlllIllllI);
                        llllllllllIlllllIlllIlIlllIllIlI.setCrystalInvulnerable(true);
                        llllllllllIlllllIlllIlIlllIllIlI.setBeamTarget(new BlockPos(0, 128, 0));
                        llllllllllIlllllIlllIlIlllIllIlI.generate(llllllllllIlllllIlllIlIllllIlIII, new Random(), new BlockPos(llllllllllIlllllIlllIlIlllIllllI.getCenterX(), 45, llllllllllIlllllIlllIlIlllIllllI.getCenterZ()));
                    }
                }
                else if (llllllllllIlllllIlllIlIllllIIIlI) {
                    llllllllllIlllllIlllIlIllllIIlll.setRespawnState(DragonSpawnManager$3.SUMMONING_DRAGON);
                }
            }
        }
    }, 
    SUMMONING_DRAGON(3) {
        @Override
        public void process(final WorldServer llllllllllllIIlIllIIIIlllIIIIlII, final DragonFightManager llllllllllllIIlIllIIIIlllIIIIIll, final List<EntityEnderCrystal> llllllllllllIIlIllIIIIlllIIIIIlI, final int llllllllllllIIlIllIIIIlllIIIIIIl, final BlockPos llllllllllllIIlIllIIIIlllIIIIlll) {
            if (llllllllllllIIlIllIIIIlllIIIIIIl >= 100) {
                llllllllllllIIlIllIIIIlllIIIIIll.setRespawnState(DragonSpawnManager$4.END);
                llllllllllllIIlIllIIIIlllIIIIIll.resetSpikeCrystals();
                for (final EntityEnderCrystal llllllllllllIIlIllIIIIlllIIIIllI : llllllllllllIIlIllIIIIlllIIIIIlI) {
                    llllllllllllIIlIllIIIIlllIIIIllI.setBeamTarget(null);
                    llllllllllllIIlIllIIIIlllIIIIlII.createExplosion(llllllllllllIIlIllIIIIlllIIIIllI, llllllllllllIIlIllIIIIlllIIIIllI.posX, llllllllllllIIlIllIIIIlllIIIIllI.posY, llllllllllllIIlIllIIIIlllIIIIllI.posZ, 6.0f, false);
                    llllllllllllIIlIllIIIIlllIIIIllI.setDead();
                }
            }
            else if (llllllllllllIIlIllIIIIlllIIIIIIl >= 80) {
                llllllllllllIIlIllIIIIlllIIIIlII.playEvent(3001, new BlockPos(0, 128, 0), 0);
            }
            else if (llllllllllllIIlIllIIIIlllIIIIIIl == 0) {
                for (final EntityEnderCrystal llllllllllllIIlIllIIIIlllIIIIlIl : llllllllllllIIlIllIIIIlllIIIIIlI) {
                    llllllllllllIIlIllIIIIlllIIIIlIl.setBeamTarget(new BlockPos(0, 128, 0));
                }
            }
            else if (llllllllllllIIlIllIIIIlllIIIIIIl < 5) {
                llllllllllllIIlIllIIIIlllIIIIlII.playEvent(3001, new BlockPos(0, 128, 0), 0);
            }
        }
    };
    
    public abstract void process(final WorldServer p0, final DragonFightManager p1, final List<EntityEnderCrystal> p2, final int p3, final BlockPos p4);
    
    private DragonSpawnManager(final String lllllllllllIIIIIIlIllIlIlIIIIlIl, final int lllllllllllIIIIIIlIllIlIlIIIIlII) {
    }
}
