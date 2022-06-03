// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import org.apache.logging.log4j.LogManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;

public class WorldGenDungeons extends WorldGenerator
{
    private static final /* synthetic */ ResourceLocation[] SPAWNERTYPES;
    private static final /* synthetic */ Logger LOGGER;
    
    private ResourceLocation pickMobSpawner(final Random lllllllllllIIllIllIlllIlIllIlIIl) {
        return WorldGenDungeons.SPAWNERTYPES[lllllllllllIIllIllIlllIlIllIlIIl.nextInt(WorldGenDungeons.SPAWNERTYPES.length)];
    }
    
    @Override
    public boolean generate(final World lllllllllllIIllIllIlllIllIIIIIIl, final Random lllllllllllIIllIllIlllIllIIIIIII, final BlockPos lllllllllllIIllIllIlllIlIlllllll) {
        final int lllllllllllIIllIllIlllIllIlIIIII = 3;
        final int lllllllllllIIllIllIlllIllIIlllll = lllllllllllIIllIllIlllIllIIIIIII.nextInt(2) + 2;
        final int lllllllllllIIllIllIlllIllIIllllI = -lllllllllllIIllIllIlllIllIIlllll - 1;
        final int lllllllllllIIllIllIlllIllIIlllIl = lllllllllllIIllIllIlllIllIIlllll + 1;
        final int lllllllllllIIllIllIlllIllIIlllII = -1;
        final int lllllllllllIIllIllIlllIllIIllIll = 4;
        final int lllllllllllIIllIllIlllIllIIllIlI = lllllllllllIIllIllIlllIllIIIIIII.nextInt(2) + 2;
        final int lllllllllllIIllIllIlllIllIIllIIl = -lllllllllllIIllIllIlllIllIIllIlI - 1;
        final int lllllllllllIIllIllIlllIllIIllIII = lllllllllllIIllIllIlllIllIIllIlI + 1;
        int lllllllllllIIllIllIlllIllIIlIlll = 0;
        for (int lllllllllllIIllIllIlllIllIIlIllI = lllllllllllIIllIllIlllIllIIllllI; lllllllllllIIllIllIlllIllIIlIllI <= lllllllllllIIllIllIlllIllIIlllIl; ++lllllllllllIIllIllIlllIllIIlIllI) {
            for (int lllllllllllIIllIllIlllIllIIlIlIl = -1; lllllllllllIIllIllIlllIllIIlIlIl <= 4; ++lllllllllllIIllIllIlllIllIIlIlIl) {
                for (int lllllllllllIIllIllIlllIllIIlIlII = lllllllllllIIllIllIlllIllIIllIIl; lllllllllllIIllIllIlllIllIIlIlII <= lllllllllllIIllIllIlllIllIIllIII; ++lllllllllllIIllIllIlllIllIIlIlII) {
                    final BlockPos lllllllllllIIllIllIlllIllIIlIIll = lllllllllllIIllIllIlllIlIlllllll.add(lllllllllllIIllIllIlllIllIIlIllI, lllllllllllIIllIllIlllIllIIlIlIl, lllllllllllIIllIllIlllIllIIlIlII);
                    final Material lllllllllllIIllIllIlllIllIIlIIlI = lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIlIIll).getMaterial();
                    final boolean lllllllllllIIllIllIlllIllIIlIIIl = lllllllllllIIllIllIlllIllIIlIIlI.isSolid();
                    if (lllllllllllIIllIllIlllIllIIlIlIl == -1 && !lllllllllllIIllIllIlllIllIIlIIIl) {
                        return false;
                    }
                    if (lllllllllllIIllIllIlllIllIIlIlIl == 4 && !lllllllllllIIllIllIlllIllIIlIIIl) {
                        return false;
                    }
                    if ((lllllllllllIIllIllIlllIllIIlIllI == lllllllllllIIllIllIlllIllIIllllI || lllllllllllIIllIllIlllIllIIlIllI == lllllllllllIIllIllIlllIllIIlllIl || lllllllllllIIllIllIlllIllIIlIlII == lllllllllllIIllIllIlllIllIIllIIl || lllllllllllIIllIllIlllIllIIlIlII == lllllllllllIIllIllIlllIllIIllIII) && lllllllllllIIllIllIlllIllIIlIlIl == 0 && lllllllllllIIllIllIlllIllIIIIIIl.isAirBlock(lllllllllllIIllIllIlllIllIIlIIll) && lllllllllllIIllIllIlllIllIIIIIIl.isAirBlock(lllllllllllIIllIllIlllIllIIlIIll.up())) {
                        ++lllllllllllIIllIllIlllIllIIlIlll;
                    }
                }
            }
        }
        if (lllllllllllIIllIllIlllIllIIlIlll >= 1 && lllllllllllIIllIllIlllIllIIlIlll <= 5) {
            for (int lllllllllllIIllIllIlllIllIIlIIII = lllllllllllIIllIllIlllIllIIllllI; lllllllllllIIllIllIlllIllIIlIIII <= lllllllllllIIllIllIlllIllIIlllIl; ++lllllllllllIIllIllIlllIllIIlIIII) {
                for (int lllllllllllIIllIllIlllIllIIIllll = 3; lllllllllllIIllIllIlllIllIIIllll >= -1; --lllllllllllIIllIllIlllIllIIIllll) {
                    for (int lllllllllllIIllIllIlllIllIIIlllI = lllllllllllIIllIllIlllIllIIllIIl; lllllllllllIIllIllIlllIllIIIlllI <= lllllllllllIIllIllIlllIllIIllIII; ++lllllllllllIIllIllIlllIllIIIlllI) {
                        final BlockPos lllllllllllIIllIllIlllIllIIIllIl = lllllllllllIIllIllIlllIlIlllllll.add(lllllllllllIIllIllIlllIllIIlIIII, lllllllllllIIllIllIlllIllIIIllll, lllllllllllIIllIllIlllIllIIIlllI);
                        if (lllllllllllIIllIllIlllIllIIlIIII != lllllllllllIIllIllIlllIllIIllllI && lllllllllllIIllIllIlllIllIIIllll != -1 && lllllllllllIIllIllIlllIllIIIlllI != lllllllllllIIllIllIlllIllIIllIIl && lllllllllllIIllIllIlllIllIIlIIII != lllllllllllIIllIllIlllIllIIlllIl && lllllllllllIIllIllIlllIllIIIllll != 4 && lllllllllllIIllIllIlllIllIIIlllI != lllllllllllIIllIllIlllIllIIllIII) {
                            if (lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIIllIl).getBlock() != Blocks.CHEST) {
                                lllllllllllIIllIllIlllIllIIIIIIl.setBlockToAir(lllllllllllIIllIllIlllIllIIIllIl);
                            }
                        }
                        else if (lllllllllllIIllIllIlllIllIIIllIl.getY() >= 0 && !lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIIllIl.down()).getMaterial().isSolid()) {
                            lllllllllllIIllIllIlllIllIIIIIIl.setBlockToAir(lllllllllllIIllIllIlllIllIIIllIl);
                        }
                        else if (lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIIllIl).getMaterial().isSolid() && lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIIllIl).getBlock() != Blocks.CHEST) {
                            if (lllllllllllIIllIllIlllIllIIIllll == -1 && lllllllllllIIllIllIlllIllIIIIIII.nextInt(4) != 0) {
                                lllllllllllIIllIllIlllIllIIIIIIl.setBlockState(lllllllllllIIllIllIlllIllIIIllIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 2);
                            }
                            else {
                                lllllllllllIIllIllIlllIllIIIIIIl.setBlockState(lllllllllllIIllIllIlllIllIIIllIl, Blocks.COBBLESTONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllIIllIllIlllIllIIIllII = 0; lllllllllllIIllIllIlllIllIIIllII < 2; ++lllllllllllIIllIllIlllIllIIIllII) {
                for (int lllllllllllIIllIllIlllIllIIIlIll = 0; lllllllllllIIllIllIlllIllIIIlIll < 3; ++lllllllllllIIllIllIlllIllIIIlIll) {
                    final int lllllllllllIIllIllIlllIllIIIlIlI = lllllllllllIIllIllIlllIlIlllllll.getX() + lllllllllllIIllIllIlllIllIIIIIII.nextInt(lllllllllllIIllIllIlllIllIIlllll * 2 + 1) - lllllllllllIIllIllIlllIllIIlllll;
                    final int lllllllllllIIllIllIlllIllIIIlIIl = lllllllllllIIllIllIlllIlIlllllll.getY();
                    final int lllllllllllIIllIllIlllIllIIIlIII = lllllllllllIIllIllIlllIlIlllllll.getZ() + lllllllllllIIllIllIlllIllIIIIIII.nextInt(lllllllllllIIllIllIlllIllIIllIlI * 2 + 1) - lllllllllllIIllIllIlllIllIIllIlI;
                    final BlockPos lllllllllllIIllIllIlllIllIIIIlll = new BlockPos(lllllllllllIIllIllIlllIllIIIlIlI, lllllllllllIIllIllIlllIllIIIlIIl, lllllllllllIIllIllIlllIllIIIlIII);
                    if (lllllllllllIIllIllIlllIllIIIIIIl.isAirBlock(lllllllllllIIllIllIlllIllIIIIlll)) {
                        int lllllllllllIIllIllIlllIllIIIIllI = 0;
                        for (final EnumFacing lllllllllllIIllIllIlllIllIIIIlIl : EnumFacing.Plane.HORIZONTAL) {
                            if (lllllllllllIIllIllIlllIllIIIIIIl.getBlockState(lllllllllllIIllIllIlllIllIIIIlll.offset(lllllllllllIIllIllIlllIllIIIIlIl)).getMaterial().isSolid()) {
                                ++lllllllllllIIllIllIlllIllIIIIllI;
                            }
                        }
                        if (lllllllllllIIllIllIlllIllIIIIllI == 1) {
                            lllllllllllIIllIllIlllIllIIIIIIl.setBlockState(lllllllllllIIllIllIlllIllIIIIlll, Blocks.CHEST.correctFacing(lllllllllllIIllIllIlllIllIIIIIIl, lllllllllllIIllIllIlllIllIIIIlll, Blocks.CHEST.getDefaultState()), 2);
                            final TileEntity lllllllllllIIllIllIlllIllIIIIlII = lllllllllllIIllIllIlllIllIIIIIIl.getTileEntity(lllllllllllIIllIllIlllIllIIIIlll);
                            if (lllllllllllIIllIllIlllIllIIIIlII instanceof TileEntityChest) {
                                ((TileEntityChest)lllllllllllIIllIllIlllIllIIIIlII).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, lllllllllllIIllIllIlllIllIIIIIII.nextLong());
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            lllllllllllIIllIllIlllIllIIIIIIl.setBlockState(lllllllllllIIllIllIlllIlIlllllll, Blocks.MOB_SPAWNER.getDefaultState(), 2);
            final TileEntity lllllllllllIIllIllIlllIllIIIIIll = lllllllllllIIllIllIlllIllIIIIIIl.getTileEntity(lllllllllllIIllIllIlllIlIlllllll);
            if (lllllllllllIIllIllIlllIllIIIIIll instanceof TileEntityMobSpawner) {
                ((TileEntityMobSpawner)lllllllllllIIllIllIlllIllIIIIIll).getSpawnerBaseLogic().func_190894_a(this.pickMobSpawner(lllllllllllIIllIllIlllIllIIIIIII));
            }
            else {
                WorldGenDungeons.LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", (Object)lllllllllllIIllIllIlllIlIlllllll.getX(), (Object)lllllllllllIIllIllIlllIlIlllllll.getY(), (Object)lllllllllllIIllIllIlllIlIlllllll.getZ());
            }
            return true;
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SPAWNERTYPES = new ResourceLocation[] { EntityList.func_191306_a(EntitySkeleton.class), EntityList.func_191306_a(EntityZombie.class), EntityList.func_191306_a(EntityZombie.class), EntityList.func_191306_a(EntitySpider.class) };
    }
}
