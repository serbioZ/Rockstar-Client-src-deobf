// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockSandStone;
import javax.annotation.Nullable;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import java.util.List;

public class StructureVillagePieces
{
    private static StructureComponent generateAndAddComponent(final Start lllllllllllIlIlIIIllIllllIlIlIlI, final List<StructureComponent> lllllllllllIlIlIIIllIllllIlIlIIl, final Random lllllllllllIlIlIIIllIllllIlIlIII, final int lllllllllllIlIlIIIllIllllIlIIlll, final int lllllllllllIlIlIIIllIllllIlIIllI, final int lllllllllllIlIlIIIllIllllIlIIlIl, final EnumFacing lllllllllllIlIlIIIllIllllIIllIll, final int lllllllllllIlIlIIIllIllllIIllIlI) {
        if (lllllllllllIlIlIIIllIllllIIllIlI > 50) {
            return null;
        }
        if (Math.abs(lllllllllllIlIlIIIllIllllIlIIlll - lllllllllllIlIlIIIllIllllIlIlIlI.getBoundingBox().minX) > 112 || Math.abs(lllllllllllIlIlIIIllIllllIlIIlIl - lllllllllllIlIlIIIllIllllIlIlIlI.getBoundingBox().minZ) > 112) {
            return null;
        }
        final StructureComponent lllllllllllIlIlIIIllIllllIlIIIlI = generateComponent(lllllllllllIlIlIIIllIllllIlIlIlI, lllllllllllIlIlIIIllIllllIlIlIIl, lllllllllllIlIlIIIllIllllIlIlIII, lllllllllllIlIlIIIllIllllIlIIlll, lllllllllllIlIlIIIllIllllIlIIllI, lllllllllllIlIlIIIllIllllIlIIlIl, lllllllllllIlIlIIIllIllllIIllIll, lllllllllllIlIlIIIllIllllIIllIlI + 1);
        if (lllllllllllIlIlIIIllIllllIlIIIlI != null) {
            lllllllllllIlIlIIIllIllllIlIlIIl.add(lllllllllllIlIlIIIllIllllIlIIIlI);
            lllllllllllIlIlIIIllIllllIlIlIlI.pendingHouses.add(lllllllllllIlIlIIIllIllllIlIIIlI);
            return lllllllllllIlIlIIIllIllllIlIIIlI;
        }
        return null;
    }
    
    private static Village generateComponent(final Start lllllllllllIlIlIIIllIlllllIIllll, final List<StructureComponent> lllllllllllIlIlIIIllIlllllIIlllI, final Random lllllllllllIlIlIIIllIlllllIIllIl, final int lllllllllllIlIlIIIllIlllllIIllII, final int lllllllllllIlIlIIIllIlllllIIlIll, final int lllllllllllIlIlIIIllIlllllIIlIlI, final EnumFacing lllllllllllIlIlIIIllIllllIlllIll, final int lllllllllllIlIlIIIllIllllIlllIlI) {
        final int lllllllllllIlIlIIIllIlllllIIIlll = updatePieceWeight(lllllllllllIlIlIIIllIlllllIIllll.structureVillageWeightedPieceList);
        if (lllllllllllIlIlIIIllIlllllIIIlll <= 0) {
            return null;
        }
        int lllllllllllIlIlIIIllIlllllIIIllI = 0;
        while (lllllllllllIlIlIIIllIlllllIIIllI < 5) {
            ++lllllllllllIlIlIIIllIlllllIIIllI;
            int lllllllllllIlIlIIIllIlllllIIIlIl = lllllllllllIlIlIIIllIlllllIIllIl.nextInt(lllllllllllIlIlIIIllIlllllIIIlll);
            for (final PieceWeight lllllllllllIlIlIIIllIlllllIIIlII : lllllllllllIlIlIIIllIlllllIIllll.structureVillageWeightedPieceList) {
                lllllllllllIlIlIIIllIlllllIIIlIl -= lllllllllllIlIlIIIllIlllllIIIlII.villagePieceWeight;
                if (lllllllllllIlIlIIIllIlllllIIIlIl < 0) {
                    if (!lllllllllllIlIlIIIllIlllllIIIlII.canSpawnMoreVillagePiecesOfType(lllllllllllIlIlIIIllIllllIlllIlI)) {
                        break;
                    }
                    if (lllllllllllIlIlIIIllIlllllIIIlII == lllllllllllIlIlIIIllIlllllIIllll.structVillagePieceWeight && lllllllllllIlIlIIIllIlllllIIllll.structureVillageWeightedPieceList.size() > 1) {
                        break;
                    }
                    final Village lllllllllllIlIlIIIllIlllllIIIIll = findAndCreateComponentFactory(lllllllllllIlIlIIIllIlllllIIllll, lllllllllllIlIlIIIllIlllllIIIlII, lllllllllllIlIlIIIllIlllllIIlllI, lllllllllllIlIlIIIllIlllllIIllIl, lllllllllllIlIlIIIllIlllllIIllII, lllllllllllIlIlIIIllIlllllIIlIll, lllllllllllIlIlIIIllIlllllIIlIlI, lllllllllllIlIlIIIllIllllIlllIll, lllllllllllIlIlIIIllIllllIlllIlI);
                    if (lllllllllllIlIlIIIllIlllllIIIIll != null) {
                        final PieceWeight pieceWeight = lllllllllllIlIlIIIllIlllllIIIlII;
                        ++pieceWeight.villagePiecesSpawned;
                        lllllllllllIlIlIIIllIlllllIIllll.structVillagePieceWeight = lllllllllllIlIlIIIllIlllllIIIlII;
                        if (!lllllllllllIlIlIIIllIlllllIIIlII.canSpawnMoreVillagePieces()) {
                            lllllllllllIlIlIIIllIlllllIIllll.structureVillageWeightedPieceList.remove(lllllllllllIlIlIIIllIlllllIIIlII);
                        }
                        return lllllllllllIlIlIIIllIlllllIIIIll;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox lllllllllllIlIlIIIllIlllllIIIIlI = Torch.findPieceBox(lllllllllllIlIlIIIllIlllllIIllll, lllllllllllIlIlIIIllIlllllIIlllI, lllllllllllIlIlIIIllIlllllIIllIl, lllllllllllIlIlIIIllIlllllIIllII, lllllllllllIlIlIIIllIlllllIIlIll, lllllllllllIlIlIIIllIlllllIIlIlI, lllllllllllIlIlIIIllIllllIlllIll);
        if (lllllllllllIlIlIIIllIlllllIIIIlI != null) {
            return new Torch(lllllllllllIlIlIIIllIlllllIIllll, lllllllllllIlIlIIIllIllllIlllIlI, lllllllllllIlIlIIIllIlllllIIllIl, lllllllllllIlIlIIIllIlllllIIIIlI, lllllllllllIlIlIIIllIllllIlllIll);
        }
        return null;
    }
    
    public static void registerVillagePieces() {
        MapGenStructureIO.registerStructureComponent(House1.class, "ViBH");
        MapGenStructureIO.registerStructureComponent(Field1.class, "ViDF");
        MapGenStructureIO.registerStructureComponent(Field2.class, "ViF");
        MapGenStructureIO.registerStructureComponent(Torch.class, "ViL");
        MapGenStructureIO.registerStructureComponent(Hall.class, "ViPH");
        MapGenStructureIO.registerStructureComponent(House4Garden.class, "ViSH");
        MapGenStructureIO.registerStructureComponent(WoodHut.class, "ViSmH");
        MapGenStructureIO.registerStructureComponent(Church.class, "ViST");
        MapGenStructureIO.registerStructureComponent(House2.class, "ViS");
        MapGenStructureIO.registerStructureComponent(Start.class, "ViStart");
        MapGenStructureIO.registerStructureComponent(Path.class, "ViSR");
        MapGenStructureIO.registerStructureComponent(House3.class, "ViTRH");
        MapGenStructureIO.registerStructureComponent(Well.class, "ViW");
    }
    
    private static int updatePieceWeight(final List<PieceWeight> lllllllllllIlIlIIIlllIIIIIIIIIll) {
        boolean lllllllllllIlIlIIIlllIIIIIIIIllI = false;
        int lllllllllllIlIlIIIlllIIIIIIIIlIl = 0;
        for (final PieceWeight lllllllllllIlIlIIIlllIIIIIIIIlII : lllllllllllIlIlIIIlllIIIIIIIIIll) {
            if (lllllllllllIlIlIIIlllIIIIIIIIlII.villagePiecesLimit > 0 && lllllllllllIlIlIIIlllIIIIIIIIlII.villagePiecesSpawned < lllllllllllIlIlIIIlllIIIIIIIIlII.villagePiecesLimit) {
                lllllllllllIlIlIIIlllIIIIIIIIllI = true;
            }
            lllllllllllIlIlIIIlllIIIIIIIIlIl += lllllllllllIlIlIIIlllIIIIIIIIlII.villagePieceWeight;
        }
        return lllllllllllIlIlIIIlllIIIIIIIIllI ? lllllllllllIlIlIIIlllIIIIIIIIlIl : -1;
    }
    
    private static StructureComponent generateAndAddRoadPiece(final Start lllllllllllIlIlIIIllIllllIIIIlII, final List<StructureComponent> lllllllllllIlIlIIIllIllllIIIllIl, final Random lllllllllllIlIlIIIllIllllIIIIIlI, final int lllllllllllIlIlIIIllIllllIIIIIIl, final int lllllllllllIlIlIIIllIllllIIIlIlI, final int lllllllllllIlIlIIIllIllllIIIlIIl, final EnumFacing lllllllllllIlIlIIIllIllllIIIlIII, final int lllllllllllIlIlIIIllIllllIIIIlll) {
        if (lllllllllllIlIlIIIllIllllIIIIlll > 3 + lllllllllllIlIlIIIllIllllIIIIlII.terrainType) {
            return null;
        }
        if (Math.abs(lllllllllllIlIlIIIllIllllIIIIIIl - lllllllllllIlIlIIIllIllllIIIIlII.getBoundingBox().minX) > 112 || Math.abs(lllllllllllIlIlIIIllIllllIIIlIIl - lllllllllllIlIlIIIllIllllIIIIlII.getBoundingBox().minZ) > 112) {
            return null;
        }
        final StructureBoundingBox lllllllllllIlIlIIIllIllllIIIIllI = Path.findPieceBox(lllllllllllIlIlIIIllIllllIIIIlII, lllllllllllIlIlIIIllIllllIIIllIl, lllllllllllIlIlIIIllIllllIIIIIlI, lllllllllllIlIlIIIllIllllIIIIIIl, lllllllllllIlIlIIIllIllllIIIlIlI, lllllllllllIlIlIIIllIllllIIIlIIl, lllllllllllIlIlIIIllIllllIIIlIII);
        if (lllllllllllIlIlIIIllIllllIIIIllI != null && lllllllllllIlIlIIIllIllllIIIIllI.minY > 10) {
            final StructureComponent lllllllllllIlIlIIIllIllllIIIIlIl = new Path(lllllllllllIlIlIIIllIllllIIIIlII, lllllllllllIlIlIIIllIllllIIIIlll, lllllllllllIlIlIIIllIllllIIIIIlI, lllllllllllIlIlIIIllIllllIIIIllI, lllllllllllIlIlIIIllIllllIIIlIII);
            lllllllllllIlIlIIIllIllllIIIllIl.add(lllllllllllIlIlIIIllIllllIIIIlIl);
            lllllllllllIlIlIIIllIllllIIIIlII.pendingRoads.add(lllllllllllIlIlIIIllIllllIIIIlIl);
            return lllllllllllIlIlIIIllIllllIIIIlIl;
        }
        return null;
    }
    
    private static Village findAndCreateComponentFactory(final Start lllllllllllIlIlIIIllIlllllllIIll, final PieceWeight lllllllllllIlIlIIIllIlllllllIIlI, final List<StructureComponent> lllllllllllIlIlIIIllIlllllllIIIl, final Random lllllllllllIlIlIIIllIlllllllIIII, final int lllllllllllIlIlIIIllIllllllIllll, final int lllllllllllIlIlIIIllIllllllIlllI, final int lllllllllllIlIlIIIllIllllllIIIlI, final EnumFacing lllllllllllIlIlIIIllIllllllIIIIl, final int lllllllllllIlIlIIIllIllllllIIIII) {
        final Class<? extends Village> lllllllllllIlIlIIIllIllllllIlIlI = lllllllllllIlIlIIIllIlllllllIIlI.villagePieceClass;
        Village lllllllllllIlIlIIIllIllllllIlIIl = null;
        if (lllllllllllIlIlIIIllIllllllIlIlI == House4Garden.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = House4Garden.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == Church.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = Church.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == House1.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = House1.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == WoodHut.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = WoodHut.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == Hall.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = Hall.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == Field1.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = Field1.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == Field2.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = Field2.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == House2.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = House2.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        else if (lllllllllllIlIlIIIllIllllllIlIlI == House3.class) {
            lllllllllllIlIlIIIllIllllllIlIIl = House3.createPiece(lllllllllllIlIlIIIllIlllllllIIll, lllllllllllIlIlIIIllIlllllllIIIl, lllllllllllIlIlIIIllIlllllllIIII, lllllllllllIlIlIIIllIllllllIllll, lllllllllllIlIlIIIllIllllllIlllI, lllllllllllIlIlIIIllIllllllIIIlI, lllllllllllIlIlIIIllIllllllIIIIl, lllllllllllIlIlIIIllIllllllIIIII);
        }
        return lllllllllllIlIlIIIllIllllllIlIIl;
    }
    
    public static List<PieceWeight> getStructureVillageWeightedPieceList(final Random lllllllllllIlIlIIIlllIIIIIIlIIII, final int lllllllllllIlIlIIIlllIIIIIIlIIll) {
        final List<PieceWeight> lllllllllllIlIlIIIlllIIIIIIlIIlI = (List<PieceWeight>)Lists.newArrayList();
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(House4Garden.class, 4, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 2 + lllllllllllIlIlIIIlllIIIIIIlIIll, 4 + lllllllllllIlIlIIIlllIIIIIIlIIll * 2)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(Church.class, 20, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 0 + lllllllllllIlIlIIIlllIIIIIIlIIll, 1 + lllllllllllIlIlIIIlllIIIIIIlIIll)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(House1.class, 20, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 0 + lllllllllllIlIlIIIlllIIIIIIlIIll, 2 + lllllllllllIlIlIIIlllIIIIIIlIIll)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(WoodHut.class, 3, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 2 + lllllllllllIlIlIIIlllIIIIIIlIIll, 5 + lllllllllllIlIlIIIlllIIIIIIlIIll * 3)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(Hall.class, 15, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 0 + lllllllllllIlIlIIIlllIIIIIIlIIll, 2 + lllllllllllIlIlIIIlllIIIIIIlIIll)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(Field1.class, 3, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 1 + lllllllllllIlIlIIIlllIIIIIIlIIll, 4 + lllllllllllIlIlIIIlllIIIIIIlIIll)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(Field2.class, 3, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 2 + lllllllllllIlIlIIIlllIIIIIIlIIll, 4 + lllllllllllIlIlIIIlllIIIIIIlIIll * 2)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(House2.class, 15, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 0, 1 + lllllllllllIlIlIIIlllIIIIIIlIIll)));
        lllllllllllIlIlIIIlllIIIIIIlIIlI.add(new PieceWeight(House3.class, 8, MathHelper.getInt(lllllllllllIlIlIIIlllIIIIIIlIIII, 0 + lllllllllllIlIlIIIlllIIIIIIlIIll, 3 + lllllllllllIlIlIIIlllIIIIIIlIIll * 2)));
        final Iterator<PieceWeight> lllllllllllIlIlIIIlllIIIIIIlIIIl = lllllllllllIlIlIIIlllIIIIIIlIIlI.iterator();
        while (lllllllllllIlIlIIIlllIIIIIIlIIIl.hasNext()) {
            if (lllllllllllIlIlIIIlllIIIIIIlIIIl.next().villagePiecesLimit == 0) {
                lllllllllllIlIlIIIlllIIIIIIlIIIl.remove();
            }
        }
        return lllllllllllIlIlIIIlllIIIIIIlIIlI;
    }
    
    public static class Church extends Village
    {
        @Override
        protected int chooseProfession(final int lllllllllllIIlIIlIlIIlllIlIlIlII, final int lllllllllllIIlIIlIlIIlllIlIlIIll) {
            return 2;
        }
        
        public Church() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIlIlIIlllIlIlllll, final Random lllllllllllIIlIIlIlIIlllIlIllllI, final StructureBoundingBox lllllllllllIIlIIlIlIIlllIlIlllIl) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 12 - 1, 0);
            }
            final IBlockState lllllllllllIIlIIlIlIIlllIllIlIII = Blocks.COBBLESTONE.getDefaultState();
            final IBlockState lllllllllllIIlIIlIlIIlllIllIIlll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIlIIlIlIIlllIllIIllI = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllIIlIIlIlIIlllIllIIlIl = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 1, 1, 3, 3, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 5, 1, 3, 9, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 0, 0, 3, 0, 8, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 1, 0, 3, 10, 0, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 0, 1, 1, 0, 10, 3, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 4, 1, 1, 4, 10, 3, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 0, 0, 4, 0, 4, 7, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 4, 0, 4, 4, 4, 7, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 1, 8, 3, 4, 8, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 5, 4, 3, 10, 4, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 1, 5, 5, 3, 5, 7, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 0, 9, 0, 4, 9, 4, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.fillWithBlocks(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 0, 4, 0, 4, 4, 4, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIlIII, false);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 0, 11, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 4, 11, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 2, 11, 0, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 2, 11, 4, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 1, 1, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 1, 1, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 2, 1, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 3, 1, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, 3, 1, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlll, 1, 1, 5, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlll, 2, 1, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlll, 3, 1, 5, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIllI, 1, 2, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlIl, 3, 2, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 0, 6, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 0, 7, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 4, 6, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 4, 7, 2, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 0, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 0, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 4, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 4, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GLASS_PANE.getDefaultState(), 2, 3, 8, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.func_189926_a(lllllllllllIIlIIlIlIIlllIlIlllll, EnumFacing.SOUTH, 2, 4, 7, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.func_189926_a(lllllllllllIIlIIlIlIIlllIlIlllll, EnumFacing.EAST, 1, 4, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.func_189926_a(lllllllllllIIlIIlIlIIlllIlIlllll, EnumFacing.WEST, 3, 4, 6, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.func_189926_a(lllllllllllIIlIIlIlIIlllIlIlllll, EnumFacing.NORTH, 2, 4, 5, lllllllllllIIlIIlIlIIlllIlIlllIl);
            final IBlockState lllllllllllIIlIIlIlIIlllIllIIlII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.WEST);
            for (int lllllllllllIIlIIlIlIIlllIllIIIll = 1; lllllllllllIIlIIlIlIIlllIllIIIll <= 9; ++lllllllllllIIlIIlIlIIlllIllIIIll) {
                this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlII, 3, lllllllllllIIlIIlIlIIlllIllIIIll, 3, lllllllllllIIlIIlIlIIlllIlIlllIl);
            }
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllIIlIIlIlIIlllIlIlllIl);
            this.func_189927_a(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, lllllllllllIIlIIlIlIIlllIlIllllI, 2, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllIIlIIlIlIIlllIlIlllll, 2, 0, -1, lllllllllllIIlIIlIlIIlllIlIlllIl).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllIIlIIlIlIIlllIlIlllll, 2, -1, -1, lllllllllllIIlIIlIlIIlllIlIlllIl).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIlll, 2, 0, -1, lllllllllllIIlIIlIlIIlllIlIlllIl);
                if (this.getBlockStateFromPos(lllllllllllIIlIIlIlIIlllIlIlllll, 2, -1, -1, lllllllllllIIlIIlIlIIlllIlIlllIl).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllIIlIIlIlIIlllIlIlllll, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllIIlIIlIlIIlllIlIlllIl);
                }
            }
            for (int lllllllllllIIlIIlIlIIlllIllIIIlI = 0; lllllllllllIIlIIlIlIIlllIllIIIlI < 9; ++lllllllllllIIlIIlIlIIlllIllIIIlI) {
                for (int lllllllllllIIlIIlIlIIlllIllIIIIl = 0; lllllllllllIIlIIlIlIIlllIllIIIIl < 5; ++lllllllllllIIlIIlIlIIlllIllIIIIl) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIIIIl, 12, lllllllllllIIlIIlIlIIlllIllIIIlI, lllllllllllIIlIIlIlIIlllIlIlllIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIllIlIII, lllllllllllIIlIIlIlIIlllIllIIIIl, -1, lllllllllllIIlIIlIlIIlllIllIIIlI, lllllllllllIIlIIlIlIIlllIlIlllIl);
                }
            }
            this.spawnVillagers(lllllllllllIIlIIlIlIIlllIlIlllll, lllllllllllIIlIIlIlIIlllIlIlllIl, 2, 1, 2, 1);
            return true;
        }
        
        public Church(final Start lllllllllllIIlIIlIlIIllllIIlIllI, final int lllllllllllIIlIIlIlIIllllIIllIll, final Random lllllllllllIIlIIlIlIIllllIIllIlI, final StructureBoundingBox lllllllllllIIlIIlIlIIllllIIlIlII, final EnumFacing lllllllllllIIlIIlIlIIllllIIlIIll) {
            super(lllllllllllIIlIIlIlIIllllIIlIllI, lllllllllllIIlIIlIlIIllllIIllIll);
            this.setCoordBaseMode(lllllllllllIIlIIlIlIIllllIIlIIll);
            this.boundingBox = lllllllllllIIlIIlIlIIllllIIlIlII;
        }
        
        public static Church createPiece(final Start lllllllllllIIlIIlIlIIllllIIIlIIl, final List<StructureComponent> lllllllllllIIlIIlIlIIlllIlllllll, final Random lllllllllllIIlIIlIlIIlllIllllllI, final int lllllllllllIIlIIlIlIIlllIlllllIl, final int lllllllllllIIlIIlIlIIllllIIIIlIl, final int lllllllllllIIlIIlIlIIllllIIIIlII, final EnumFacing lllllllllllIIlIIlIlIIllllIIIIIll, final int lllllllllllIIlIIlIlIIlllIllllIIl) {
            final StructureBoundingBox lllllllllllIIlIIlIlIIllllIIIIIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIlIlIIlllIlllllIl, lllllllllllIIlIIlIlIIllllIIIIlIl, lllllllllllIIlIIlIlIIllllIIIIlII, 0, 0, 0, 5, 12, 9, lllllllllllIIlIIlIlIIllllIIIIIll);
            return (Village.canVillageGoDeeper(lllllllllllIIlIIlIlIIllllIIIIIIl) && StructureComponent.findIntersecting(lllllllllllIIlIIlIlIIlllIlllllll, lllllllllllIIlIIlIlIIllllIIIIIIl) == null) ? new Church(lllllllllllIIlIIlIlIIllllIIIlIIl, lllllllllllIIlIIlIlIIlllIllllIIl, lllllllllllIIlIIlIlIIlllIllllllI, lllllllllllIIlIIlIlIIllllIIIIIIl, lllllllllllIIlIIlIlIIllllIIIIIll) : null;
        }
    }
    
    abstract static class Village extends StructureComponent
    {
        protected /* synthetic */ boolean isZombieInfested;
        protected /* synthetic */ int structureType;
        protected /* synthetic */ int averageGroundLvl;
        private /* synthetic */ int villagersSpawned;
        
        protected void func_189926_a(final World lllllllllllllIIllIIIIlIIlIIIIIlI, final EnumFacing lllllllllllllIIllIIIIlIIIllllIlI, final int lllllllllllllIIllIIIIlIIlIIIIIII, final int lllllllllllllIIllIIIIlIIIllllIII, final int lllllllllllllIIllIIIIlIIIlllIlll, final StructureBoundingBox lllllllllllllIIllIIIIlIIIlllllIl) {
            if (!this.isZombieInfested) {
                this.setBlockState(lllllllllllllIIllIIIIlIIlIIIIIlI, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, lllllllllllllIIllIIIIlIIIllllIlI), lllllllllllllIIllIIIIlIIlIIIIIII, lllllllllllllIIllIIIIlIIIllllIII, lllllllllllllIIllIIIIlIIIlllIlll, lllllllllllllIIllIIIIlIIIlllllIl);
            }
        }
        
        protected void func_189924_a(final int lllllllllllllIIllIIIIlIIIlIllIlI) {
            this.structureType = lllllllllllllIIllIIIIlIIIlIllIlI;
        }
        
        @Override
        protected void replaceAirAndLiquidDownwards(final World lllllllllllllIIllIIIIlIIIllIIlII, final IBlockState lllllllllllllIIllIIIIlIIIllIlIll, final int lllllllllllllIIllIIIIlIIIllIIIlI, final int lllllllllllllIIllIIIIlIIIllIlIIl, final int lllllllllllllIIllIIIIlIIIllIIIII, final StructureBoundingBox lllllllllllllIIllIIIIlIIIllIIlll) {
            final IBlockState lllllllllllllIIllIIIIlIIIllIIllI = this.getBiomeSpecificBlockState(lllllllllllllIIllIIIIlIIIllIlIll);
            super.replaceAirAndLiquidDownwards(lllllllllllllIIllIIIIlIIIllIIlII, lllllllllllllIIllIIIIlIIIllIIllI, lllllllllllllIIllIIIIlIIIllIIIlI, lllllllllllllIIllIIIIlIIIllIlIIl, lllllllllllllIIllIIIIlIIIllIIIII, lllllllllllllIIllIIIIlIIIllIIlll);
        }
        
        protected void func_189927_a(final World lllllllllllllIIllIIIIlIIlIIllIII, final StructureBoundingBox lllllllllllllIIllIIIIlIIlIIlIlll, final Random lllllllllllllIIllIIIIlIIlIIIlllI, final int lllllllllllllIIllIIIIlIIlIIIllIl, final int lllllllllllllIIllIIIIlIIlIIIllII, final int lllllllllllllIIllIIIIlIIlIIIlIll, final EnumFacing lllllllllllllIIllIIIIlIIlIIlIIlI) {
            if (!this.isZombieInfested) {
                this.func_189915_a(lllllllllllllIIllIIIIlIIlIIllIII, lllllllllllllIIllIIIIlIIlIIlIlll, lllllllllllllIIllIIIIlIIlIIIlllI, lllllllllllllIIllIIIIlIIlIIIllIl, lllllllllllllIIllIIIIlIIlIIIllII, lllllllllllllIIllIIIIlIIlIIIlIll, EnumFacing.NORTH, this.func_189925_i());
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Village.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final char lllllllllllllIIllIIIIlIIIlIlIllI = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIIllIIIIlIIIlIlIllI[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Village.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIllIIIIlIIIlIlIllI;
        }
        
        protected static boolean canVillageGoDeeper(final StructureBoundingBox lllllllllllllIIllIIIIlIIllIlIlII) {
            return lllllllllllllIIllIIIIlIIllIlIlII != null && lllllllllllllIIllIIIIlIIllIlIlII.minY > 10;
        }
        
        @Nullable
        protected StructureComponent getNextComponentNN(final Start lllllllllllllIIllIIIIlIlIIIlIIII, final List<StructureComponent> lllllllllllllIIllIIIIlIlIIIIlIII, final Random lllllllllllllIIllIIIIlIlIIIIIlll, final int lllllllllllllIIllIIIIlIlIIIIIllI, final int lllllllllllllIIllIIIIlIlIIIIIlIl) {
            final EnumFacing lllllllllllllIIllIIIIlIlIIIIlIll = this.getCoordBaseMode();
            if (lllllllllllllIIllIIIIlIlIIIIlIll == null) {
                return null;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIllIIIIlIlIIIIlIll.ordinal()]) {
                default: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIlIIIlIIII, lllllllllllllIIllIIIIlIlIIIIlIII, lllllllllllllIIllIIIIlIlIIIIIlll, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllIIllIIIIlIlIIIIIllI, this.boundingBox.minZ + lllllllllllllIIllIIIIlIlIIIIIlIl, EnumFacing.WEST, this.getComponentType());
                }
                case 4: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIlIIIlIIII, lllllllllllllIIllIIIIlIlIIIIlIII, lllllllllllllIIllIIIIlIlIIIIIlll, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllIIllIIIIlIlIIIIIllI, this.boundingBox.minZ + lllllllllllllIIllIIIIlIlIIIIIlIl, EnumFacing.WEST, this.getComponentType());
                }
                case 5: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIlIIIlIIII, lllllllllllllIIllIIIIlIlIIIIlIII, lllllllllllllIIllIIIIlIlIIIIIlll, this.boundingBox.minX + lllllllllllllIIllIIIIlIlIIIIIlIl, this.boundingBox.minY + lllllllllllllIIllIIIIlIlIIIIIllI, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
                case 6: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIlIIIlIIII, lllllllllllllIIllIIIIlIlIIIIlIII, lllllllllllllIIllIIIIlIlIIIIIlll, this.boundingBox.minX + lllllllllllllIIllIIIIlIlIIIIIlIl, this.boundingBox.minY + lllllllllllllIIllIIIIlIlIIIIIllI, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
            }
        }
        
        protected IBlockState getBiomeSpecificBlockState(final IBlockState lllllllllllllIIllIIIIlIIlIlIIlII) {
            if (this.structureType == 1) {
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG || lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG2) {
                    return Blocks.SANDSTONE.getDefaultState();
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.COBBLESTONE) {
                    return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata());
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.PLANKS) {
                    return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata());
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.STONE_STAIRS) {
                    return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.GRAVEL) {
                    return Blocks.SANDSTONE.getDefaultState();
                }
            }
            else if (this.structureType == 3) {
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG || lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG2) {
                    return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLog.LOG_AXIS, (BlockLog.EnumAxis)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockLog.LOG_AXIS));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.PLANKS) {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.OAK_FENCE) {
                    return Blocks.SPRUCE_FENCE.getDefaultState();
                }
            }
            else if (this.structureType == 2) {
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG || lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.LOG2) {
                    return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, (BlockLog.EnumAxis)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockLog.LOG_AXIS));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.PLANKS) {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.ACACIA_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIIIIlIIlIlIIlII.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.COBBLESTONE) {
                    return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y);
                }
                if (lllllllllllllIIllIIIIlIIlIlIIlII.getBlock() == Blocks.OAK_FENCE) {
                    return Blocks.ACACIA_FENCE.getDefaultState();
                }
            }
            return lllllllllllllIIllIIIIlIIlIlIIlII;
        }
        
        protected void spawnVillagers(final World lllllllllllllIIllIIIIlIIlIlllIIl, final StructureBoundingBox lllllllllllllIIllIIIIlIIlIlllIII, final int lllllllllllllIIllIIIIlIIlIllIlll, final int lllllllllllllIIllIIIIlIIllIIIIll, final int lllllllllllllIIllIIIIlIIllIIIIlI, final int lllllllllllllIIllIIIIlIIlIllIlII) {
            if (this.villagersSpawned < lllllllllllllIIllIIIIlIIlIllIlII) {
                for (int lllllllllllllIIllIIIIlIIllIIIIII = this.villagersSpawned; lllllllllllllIIllIIIIlIIllIIIIII < lllllllllllllIIllIIIIlIIlIllIlII; ++lllllllllllllIIllIIIIlIIllIIIIII) {
                    final int lllllllllllllIIllIIIIlIIlIllllll = this.getXWithOffset(lllllllllllllIIllIIIIlIIlIllIlll + lllllllllllllIIllIIIIlIIllIIIIII, lllllllllllllIIllIIIIlIIllIIIIlI);
                    final int lllllllllllllIIllIIIIlIIlIlllllI = this.getYWithOffset(lllllllllllllIIllIIIIlIIllIIIIll);
                    final int lllllllllllllIIllIIIIlIIlIllllIl = this.getZWithOffset(lllllllllllllIIllIIIIlIIlIllIlll + lllllllllllllIIllIIIIlIIllIIIIII, lllllllllllllIIllIIIIlIIllIIIIlI);
                    if (!lllllllllllllIIllIIIIlIIlIlllIII.isVecInside(new BlockPos(lllllllllllllIIllIIIIlIIlIllllll, lllllllllllllIIllIIIIlIIlIlllllI, lllllllllllllIIllIIIIlIIlIllllIl))) {
                        break;
                    }
                    ++this.villagersSpawned;
                    if (this.isZombieInfested) {
                        final EntityZombieVillager lllllllllllllIIllIIIIlIIlIllllII = new EntityZombieVillager(lllllllllllllIIllIIIIlIIlIlllIIl);
                        lllllllllllllIIllIIIIlIIlIllllII.setLocationAndAngles(lllllllllllllIIllIIIIlIIlIllllll + 0.5, lllllllllllllIIllIIIIlIIlIlllllI, lllllllllllllIIllIIIIlIIlIllllIl + 0.5, 0.0f, 0.0f);
                        lllllllllllllIIllIIIIlIIlIllllII.onInitialSpawn(lllllllllllllIIllIIIIlIIlIlllIIl.getDifficultyForLocation(new BlockPos(lllllllllllllIIllIIIIlIIlIllllII)), null);
                        lllllllllllllIIllIIIIlIIlIllllII.func_190733_a(this.chooseProfession(lllllllllllllIIllIIIIlIIllIIIIII, 0));
                        lllllllllllllIIllIIIIlIIlIllllII.enablePersistence();
                        lllllllllllllIIllIIIIlIIlIlllIIl.spawnEntityInWorld(lllllllllllllIIllIIIIlIIlIllllII);
                    }
                    else {
                        final EntityVillager lllllllllllllIIllIIIIlIIlIlllIll = new EntityVillager(lllllllllllllIIllIIIIlIIlIlllIIl);
                        lllllllllllllIIllIIIIlIIlIlllIll.setLocationAndAngles(lllllllllllllIIllIIIIlIIlIllllll + 0.5, lllllllllllllIIllIIIIlIIlIlllllI, lllllllllllllIIllIIIIlIIlIllllIl + 0.5, 0.0f, 0.0f);
                        lllllllllllllIIllIIIIlIIlIlllIll.setProfession(this.chooseProfession(lllllllllllllIIllIIIIlIIllIIIIII, lllllllllllllIIllIIIIlIIlIlllIIl.rand.nextInt(6)));
                        lllllllllllllIIllIIIIlIIlIlllIll.func_190672_a(lllllllllllllIIllIIIIlIIlIlllIIl.getDifficultyForLocation(new BlockPos(lllllllllllllIIllIIIIlIIlIlllIll)), null, false);
                        lllllllllllllIIllIIIIlIIlIlllIIl.spawnEntityInWorld(lllllllllllllIIllIIIIlIIlIlllIll);
                    }
                }
            }
        }
        
        @Nullable
        protected StructureComponent getNextComponentPP(final Start lllllllllllllIIllIIIIlIIlllllIll, final List<StructureComponent> lllllllllllllIIllIIIIlIIllllIIll, final Random lllllllllllllIIllIIIIlIIllllIIlI, final int lllllllllllllIIllIIIIlIIlllllIII, final int lllllllllllllIIllIIIIlIIllllIIII) {
            final EnumFacing lllllllllllllIIllIIIIlIIllllIllI = this.getCoordBaseMode();
            if (lllllllllllllIIllIIIIlIIllllIllI == null) {
                return null;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIllIIIIlIIllllIllI.ordinal()]) {
                default: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIIlllllIll, lllllllllllllIIllIIIIlIIllllIIll, lllllllllllllIIllIIIIlIIllllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllIIllIIIIlIIlllllIII, this.boundingBox.minZ + lllllllllllllIIllIIIIlIIllllIIII, EnumFacing.EAST, this.getComponentType());
                }
                case 4: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIIlllllIll, lllllllllllllIIllIIIIlIIllllIIll, lllllllllllllIIllIIIIlIIllllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllIIllIIIIlIIlllllIII, this.boundingBox.minZ + lllllllllllllIIllIIIIlIIllllIIII, EnumFacing.EAST, this.getComponentType());
                }
                case 5: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIIlllllIll, lllllllllllllIIllIIIIlIIllllIIll, lllllllllllllIIllIIIIlIIllllIIlI, this.boundingBox.minX + lllllllllllllIIllIIIIlIIllllIIII, this.boundingBox.minY + lllllllllllllIIllIIIIlIIlllllIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
                case 6: {
                    return generateAndAddComponent(lllllllllllllIIllIIIIlIIlllllIll, lllllllllllllIIllIIIIlIIllllIIll, lllllllllllllIIllIIIIlIIllllIIlI, this.boundingBox.minX + lllllllllllllIIllIIIIlIIllllIIII, this.boundingBox.minY + lllllllllllllIIllIIIIlIIlllllIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
            }
        }
        
        protected BlockDoor func_189925_i() {
            switch (this.structureType) {
                case 2: {
                    return Blocks.ACACIA_DOOR;
                }
                case 3: {
                    return Blocks.SPRUCE_DOOR;
                }
                default: {
                    return Blocks.OAK_DOOR;
                }
            }
        }
        
        protected Village(final Start lllllllllllllIIllIIIIlIlIIlIIlll, final int lllllllllllllIIllIIIIlIlIIlIlIIl) {
            super(lllllllllllllIIllIIIIlIlIIlIlIIl);
            this.averageGroundLvl = -1;
            if (lllllllllllllIIllIIIIlIlIIlIIlll != null) {
                this.structureType = lllllllllllllIIllIIIIlIlIIlIIlll.structureType;
                this.isZombieInfested = lllllllllllllIIllIIIIlIlIIlIIlll.isZombieInfested;
            }
        }
        
        protected int getAverageGroundLevel(final World lllllllllllllIIllIIIIlIIlllIIlIl, final StructureBoundingBox lllllllllllllIIllIIIIlIIlllIIlII) {
            int lllllllllllllIIllIIIIlIIlllIIIll = 0;
            int lllllllllllllIIllIIIIlIIlllIIIlI = 0;
            final BlockPos.MutableBlockPos lllllllllllllIIllIIIIlIIlllIIIIl = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIIllIIIIlIIlllIIIII = this.boundingBox.minZ; lllllllllllllIIllIIIIlIIlllIIIII <= this.boundingBox.maxZ; ++lllllllllllllIIllIIIIlIIlllIIIII) {
                for (int lllllllllllllIIllIIIIlIIllIlllll = this.boundingBox.minX; lllllllllllllIIllIIIIlIIllIlllll <= this.boundingBox.maxX; ++lllllllllllllIIllIIIIlIIllIlllll) {
                    lllllllllllllIIllIIIIlIIlllIIIIl.setPos(lllllllllllllIIllIIIIlIIllIlllll, 64, lllllllllllllIIllIIIIlIIlllIIIII);
                    if (lllllllllllllIIllIIIIlIIlllIIlII.isVecInside(lllllllllllllIIllIIIIlIIlllIIIIl)) {
                        lllllllllllllIIllIIIIlIIlllIIIll += Math.max(lllllllllllllIIllIIIIlIIlllIIlIl.getTopSolidOrLiquidBlock(lllllllllllllIIllIIIIlIIlllIIIIl).getY(), lllllllllllllIIllIIIIlIIlllIIlIl.provider.getAverageGroundLevel() - 1);
                        ++lllllllllllllIIllIIIIlIIlllIIIlI;
                    }
                }
            }
            if (lllllllllllllIIllIIIIlIIlllIIIlI == 0) {
                return -1;
            }
            return lllllllllllllIIllIIIIlIIlllIIIll / lllllllllllllIIllIIIIlIIlllIIIlI;
        }
        
        public Village() {
            this.averageGroundLvl = -1;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIllIIIIlIlIIlIIIlI) {
            lllllllllllllIIllIIIIlIlIIlIIIlI.setInteger("HPos", this.averageGroundLvl);
            lllllllllllllIIllIIIIlIlIIlIIIlI.setInteger("VCount", this.villagersSpawned);
            lllllllllllllIIllIIIIlIlIIlIIIlI.setByte("Type", (byte)this.structureType);
            lllllllllllllIIllIIIIlIlIIlIIIlI.setBoolean("Zombie", this.isZombieInfested);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIllIIIIlIlIIIlllII, final TemplateManager lllllllllllllIIllIIIIlIlIIIllIll) {
            this.averageGroundLvl = lllllllllllllIIllIIIIlIlIIIlllII.getInteger("HPos");
            this.villagersSpawned = lllllllllllllIIllIIIIlIlIIIlllII.getInteger("VCount");
            this.structureType = lllllllllllllIIllIIIIlIlIIIlllII.getByte("Type");
            if (lllllllllllllIIllIIIIlIlIIIlllII.getBoolean("Desert")) {
                this.structureType = 1;
            }
            this.isZombieInfested = lllllllllllllIIllIIIIlIlIIIlllII.getBoolean("Zombie");
        }
        
        protected int chooseProfession(final int lllllllllllllIIllIIIIlIIlIlIllII, final int lllllllllllllIIllIIIIlIIlIlIlIlI) {
            return lllllllllllllIIllIIIIlIIlIlIlIlI;
        }
    }
    
    public static class Start extends Well
    {
        public /* synthetic */ List<StructureComponent> pendingRoads;
        public /* synthetic */ PieceWeight structVillagePieceWeight;
        public /* synthetic */ List<StructureComponent> pendingHouses;
        public /* synthetic */ int terrainType;
        public /* synthetic */ List<PieceWeight> structureVillageWeightedPieceList;
        public /* synthetic */ BiomeProvider worldChunkMngr;
        
        public Start(final BiomeProvider lllllllllllIIllllllIllIIlIIlllII, final int lllllllllllIIllllllIllIIlIIllIll, final Random lllllllllllIIllllllIllIIlIIllIlI, final int lllllllllllIIllllllIllIIlIIllIIl, final int lllllllllllIIllllllIllIIlIIlIIII, final List<PieceWeight> lllllllllllIIllllllIllIIlIIlIlll, final int lllllllllllIIllllllIllIIlIIlIllI) {
            super(null, 0, lllllllllllIIllllllIllIIlIIllIlI, lllllllllllIIllllllIllIIlIIllIIl, lllllllllllIIllllllIllIIlIIlIIII);
            this.pendingHouses = (List<StructureComponent>)Lists.newArrayList();
            this.pendingRoads = (List<StructureComponent>)Lists.newArrayList();
            this.worldChunkMngr = lllllllllllIIllllllIllIIlIIlllII;
            this.structureVillageWeightedPieceList = lllllllllllIIllllllIllIIlIIlIlll;
            this.terrainType = lllllllllllIIllllllIllIIlIIlIllI;
            final Biome lllllllllllIIllllllIllIIlIIlIlIl = lllllllllllIIllllllIllIIlIIlllII.getBiome(new BlockPos(lllllllllllIIllllllIllIIlIIllIIl, 0, lllllllllllIIllllllIllIIlIIlIIII), Biomes.DEFAULT);
            if (lllllllllllIIllllllIllIIlIIlIlIl instanceof BiomeDesert) {
                this.structureType = 1;
            }
            else if (lllllllllllIIllllllIllIIlIIlIlIl instanceof BiomeSavanna) {
                this.structureType = 2;
            }
            else if (lllllllllllIIllllllIllIIlIIlIlIl instanceof BiomeTaiga) {
                this.structureType = 3;
            }
            this.func_189924_a(this.structureType);
            this.isZombieInfested = (lllllllllllIIllllllIllIIlIIllIlI.nextInt(50) == 0);
        }
        
        public Start() {
            this.pendingHouses = (List<StructureComponent>)Lists.newArrayList();
            this.pendingRoads = (List<StructureComponent>)Lists.newArrayList();
        }
    }
    
    public static class Well extends Village
    {
        public Well(final Start lllllllllllIlIllllIIllIlIlIIlIlI, final int lllllllllllIlIllllIIllIlIlIIIIll, final Random lllllllllllIlIllllIIllIlIlIIlIII, final int lllllllllllIlIllllIIllIlIlIIIIIl, final int lllllllllllIlIllllIIllIlIlIIIllI) {
            super(lllllllllllIlIllllIIllIlIlIIlIlI, lllllllllllIlIllllIIllIlIlIIIIll);
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(lllllllllllIlIllllIIllIlIlIIlIII));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllIlIllllIIllIlIlIIIIIl, 64, lllllllllllIlIllllIIllIlIlIIIllI, lllllllllllIlIllllIIllIlIlIIIIIl + 6 - 1, 78, lllllllllllIlIllllIIllIlIlIIIllI + 6 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllIlIllllIIllIlIlIIIIIl, 64, lllllllllllIlIllllIIllIlIlIIIllI, lllllllllllIlIllllIIllIlIlIIIIIl + 6 - 1, 78, lllllllllllIlIllllIIllIlIlIIIllI + 6 - 1);
            }
        }
        
        public Well() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIlIllllIIllIlIIlIlIll, final Random lllllllllllIlIllllIIllIlIIlIlIlI, final StructureBoundingBox lllllllllllIlIllllIIllIlIIlIIIlI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIIlI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 3, 0);
            }
            final IBlockState lllllllllllIlIllllIIllIlIIlIlIII = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllIlIllllIIllIlIIlIIlll = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIIlI, 1, 0, 1, 4, 12, 4, lllllllllllIlIllllIIllIlIIlIlIII, Blocks.FLOWING_WATER.getDefaultState(), false);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, Blocks.AIR.getDefaultState(), 2, 12, 2, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, Blocks.AIR.getDefaultState(), 3, 12, 2, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, Blocks.AIR.getDefaultState(), 2, 12, 3, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, Blocks.AIR.getDefaultState(), 3, 12, 3, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 1, 13, 1, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 1, 14, 1, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 4, 13, 1, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 4, 14, 1, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 1, 13, 4, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 1, 14, 4, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 4, 13, 4, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlll, 4, 14, 4, lllllllllllIlIllllIIllIlIIlIIIlI);
            this.fillWithBlocks(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIIlI, 1, 15, 1, 4, 15, 4, lllllllllllIlIllllIIllIlIIlIlIII, lllllllllllIlIllllIIllIlIIlIlIII, false);
            for (int lllllllllllIlIllllIIllIlIIlIIllI = 0; lllllllllllIlIllllIIllIlIIlIIllI <= 5; ++lllllllllllIlIllllIIllIlIIlIIllI) {
                for (int lllllllllllIlIllllIIllIlIIlIIlIl = 0; lllllllllllIlIllllIIllIlIIlIIlIl <= 5; ++lllllllllllIlIllllIIllIlIIlIIlIl) {
                    if (lllllllllllIlIllllIIllIlIIlIIlIl == 0 || lllllllllllIlIllllIIllIlIIlIIlIl == 5 || lllllllllllIlIllllIIllIlIIlIIllI == 0 || lllllllllllIlIllllIIllIlIIlIIllI == 5) {
                        this.setBlockState(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIlIII, lllllllllllIlIllllIIllIlIIlIIlIl, 11, lllllllllllIlIllllIIllIlIIlIIllI, lllllllllllIlIllllIIllIlIIlIIIlI);
                        this.clearCurrentPositionBlocksUpwards(lllllllllllIlIllllIIllIlIIlIlIll, lllllllllllIlIllllIIllIlIIlIIlIl, 12, lllllllllllIlIllllIIllIlIIlIIllI, lllllllllllIlIllllIIllIlIIlIIIlI);
                    }
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIlIllllIIllIlIIlllIlI, final List<StructureComponent> lllllllllllIlIllllIIllIlIIlllIIl, final Random lllllllllllIlIllllIIllIlIIlllIII) {
            generateAndAddRoadPiece((Start)lllllllllllIlIllllIIllIlIIlllIlI, lllllllllllIlIllllIIllIlIIlllIIl, lllllllllllIlIllllIIllIlIIlllIII, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.WEST, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllIlIllllIIllIlIIlllIlI, lllllllllllIlIllllIIllIlIIlllIIl, lllllllllllIlIllllIIllIlIIlllIII, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.EAST, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllIlIllllIIllIlIIlllIlI, lllllllllllIlIllllIIllIlIIlllIIl, lllllllllllIlIllllIIllIlIIlllIII, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllIlIllllIIllIlIIlllIlI, lllllllllllIlIllllIIllIlIIlllIIl, lllllllllllIlIllllIIllIlIIlllIII, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
        }
    }
    
    public static class PieceWeight
    {
        public /* synthetic */ int villagePiecesLimit;
        public final /* synthetic */ int villagePieceWeight;
        public /* synthetic */ int villagePiecesSpawned;
        public /* synthetic */ Class<? extends Village> villagePieceClass;
        
        public PieceWeight(final Class<? extends Village> lllllllllllIIIlllIIIIlIIlllIllIl, final int lllllllllllIIIlllIIIIlIIlllIlIII, final int lllllllllllIIIlllIIIIlIIlllIIlll) {
            this.villagePieceClass = lllllllllllIIIlllIIIIlIIlllIllIl;
            this.villagePieceWeight = lllllllllllIIIlllIIIIlIIlllIlIII;
            this.villagePiecesLimit = lllllllllllIIIlllIIIIlIIlllIIlll;
        }
        
        public boolean canSpawnMoreVillagePieces() {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
        
        public boolean canSpawnMoreVillagePiecesOfType(final int lllllllllllIIIlllIIIIlIIlllIIlII) {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
    }
    
    public static class House1 extends Village
    {
        public static House1 createPiece(final Start lllllllllllIIllIIllIIIllIIlIIlII, final List<StructureComponent> lllllllllllIIllIIllIIIllIIlIIIll, final Random lllllllllllIIllIIllIIIllIIlIlIll, final int lllllllllllIIllIIllIIIllIIlIIIIl, final int lllllllllllIIllIIllIIIllIIlIlIIl, final int lllllllllllIIllIIllIIIllIIlIlIII, final EnumFacing lllllllllllIIllIIllIIIllIIIllllI, final int lllllllllllIIllIIllIIIllIIIlllIl) {
            final StructureBoundingBox lllllllllllIIllIIllIIIllIIlIIlIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllIIllIIIllIIlIIIIl, lllllllllllIIllIIllIIIllIIlIlIIl, lllllllllllIIllIIllIIIllIIlIlIII, 0, 0, 0, 9, 9, 6, lllllllllllIIllIIllIIIllIIIllllI);
            return (Village.canVillageGoDeeper(lllllllllllIIllIIllIIIllIIlIIlIl) && StructureComponent.findIntersecting(lllllllllllIIllIIllIIIllIIlIIIll, lllllllllllIIllIIllIIIllIIlIIlIl) == null) ? new House1(lllllllllllIIllIIllIIIllIIlIIlII, lllllllllllIIllIIllIIIllIIIlllIl, lllllllllllIIllIIllIIIllIIlIlIll, lllllllllllIIllIIllIIIllIIlIIlIl, lllllllllllIIllIIllIIIllIIIllllI) : null;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllIIllIIIlIlllllllI, final Random lllllllllllIIllIIllIIIlIllllllIl, final StructureBoundingBox lllllllllllIIllIIllIIIllIIIIlIll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 9 - 1, 0);
            }
            final IBlockState lllllllllllIIllIIllIIIllIIIIlIlI = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllIIllIIllIIIllIIIIlIIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIllIIllIIIllIIIIlIII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllIIllIIllIIIllIIIIIlll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            final IBlockState lllllllllllIIllIIllIIIllIIIIIllI = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllIIllIIllIIIllIIIIIlIl = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIllIIllIIIllIIIIIlII = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 1, 1, 7, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 0, 0, 8, 0, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 5, 0, 8, 5, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 6, 1, 8, 6, 4, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 7, 2, 8, 7, 3, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            for (int lllllllllllIIllIIllIIIllIIIIIIll = -1; lllllllllllIIllIIllIIIllIIIIIIll <= 2; ++lllllllllllIIllIIllIIIllIIIIIIll) {
                for (int lllllllllllIIllIIllIIIllIIIIIIlI = 0; lllllllllllIIllIIllIIIllIIIIIIlI <= 8; ++lllllllllllIIllIIllIIIllIIIIIIlI) {
                    this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIIl, lllllllllllIIllIIllIIIllIIIIIIlI, 6 + lllllllllllIIllIIllIIIllIIIIIIll, lllllllllllIIllIIllIIIllIIIIIIll, lllllllllllIIllIIllIIIllIIIIlIll);
                    this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIII, lllllllllllIIllIIllIIIllIIIIIIlI, 6 + lllllllllllIIllIIllIIIllIIIIIIll, 5 - lllllllllllIIllIIllIIIllIIIIIIll, lllllllllllIIllIIllIIIllIIIIlIll);
                }
            }
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 1, 0, 0, 1, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 1, 5, 8, 1, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 8, 1, 0, 8, 1, 4, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 2, 1, 0, 7, 1, 0, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 2, 0, 0, 4, 0, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 2, 5, 0, 4, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 8, 2, 5, 8, 4, 5, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 8, 2, 0, 8, 4, 0, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIlIlI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 0, 2, 1, 0, 4, 4, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 2, 5, 7, 4, 5, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 8, 2, 1, 8, 4, 4, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 2, 0, 7, 4, 0, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 5, 3, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 6, 3, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 2, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 5, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, lllllllllllIIllIIllIIIllIIIIlIll);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 4, 1, 7, 4, 1, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 4, 4, 7, 4, 4, lllllllllllIIllIIllIIIllIIIIIllI, lllllllllllIIllIIllIIIllIIIIIllI, false);
            this.fillWithBlocks(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIllI, 7, 1, 4, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIlll, 7, 1, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIIl, 6, 1, 4, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIIl, 5, 1, 4, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIIl, 4, 1, 4, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIIl, 3, 1, 4, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIlII, 6, 1, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 6, 2, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIlII, 4, 1, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 4, 2, 3, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.CRAFTING_TABLE.getDefaultState(), 7, 1, 1, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.AIR.getDefaultState(), 1, 1, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.AIR.getDefaultState(), 1, 2, 0, lllllllllllIIllIIllIIIllIIIIlIll);
            this.func_189927_a(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, lllllllllllIIllIIllIIIlIllllllIl, 1, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllIIllIIllIIIlIlllllllI, 1, 0, -1, lllllllllllIIllIIllIIIllIIIIlIll).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllIIllIIllIIIlIlllllllI, 1, -1, -1, lllllllllllIIllIIllIIIllIIIIlIll).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIlIl, 1, 0, -1, lllllllllllIIllIIllIIIllIIIIlIll);
                if (this.getBlockStateFromPos(lllllllllllIIllIIllIIIlIlllllllI, 1, -1, -1, lllllllllllIIllIIllIIIllIIIIlIll).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllIIllIIllIIIlIlllllllI, Blocks.GRASS.getDefaultState(), 1, -1, -1, lllllllllllIIllIIllIIIllIIIIlIll);
                }
            }
            for (int lllllllllllIIllIIllIIIllIIIIIIIl = 0; lllllllllllIIllIIllIIIllIIIIIIIl < 6; ++lllllllllllIIllIIllIIIllIIIIIIIl) {
                for (int lllllllllllIIllIIllIIIllIIIIIIII = 0; lllllllllllIIllIIllIIIllIIIIIIII < 9; ++lllllllllllIIllIIllIIIllIIIIIIII) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIIIII, 9, lllllllllllIIllIIllIIIllIIIIIIIl, lllllllllllIIllIIllIIIllIIIIlIll);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIlI, lllllllllllIIllIIllIIIllIIIIIIII, -1, lllllllllllIIllIIllIIIllIIIIIIIl, lllllllllllIIllIIllIIIllIIIIlIll);
                }
            }
            this.spawnVillagers(lllllllllllIIllIIllIIIlIlllllllI, lllllllllllIIllIIllIIIllIIIIlIll, 2, 1, 2, 1);
            return true;
        }
        
        public House1() {
        }
        
        @Override
        protected int chooseProfession(final int lllllllllllIIllIIllIIIlIllllIIIl, final int lllllllllllIIllIIllIIIlIllllIIII) {
            return 1;
        }
        
        public House1(final Start lllllllllllIIllIIllIIIllIlIIIIII, final int lllllllllllIIllIIllIIIllIIlllIIl, final Random lllllllllllIIllIIllIIIllIIlllllI, final StructureBoundingBox lllllllllllIIllIIllIIIllIIllllIl, final EnumFacing lllllllllllIIllIIllIIIllIIllllII) {
            super(lllllllllllIIllIIllIIIllIlIIIIII, lllllllllllIIllIIllIIIllIIlllIIl);
            this.setCoordBaseMode(lllllllllllIIllIIllIIIllIIllllII);
            this.boundingBox = lllllllllllIIllIIllIIIllIIllllIl;
        }
    }
    
    public static class Torch extends Village
    {
        public static StructureBoundingBox findPieceBox(final Start llllllllllllIllllllIIlIIIlIlIlIl, final List<StructureComponent> llllllllllllIllllllIIlIIIlIlIlII, final Random llllllllllllIllllllIIlIIIlIlIIll, final int llllllllllllIllllllIIlIIIlIlIIlI, final int llllllllllllIllllllIIlIIIlIlIIIl, final int llllllllllllIllllllIIlIIIlIIlIlI, final EnumFacing llllllllllllIllllllIIlIIIlIIllll) {
            final StructureBoundingBox llllllllllllIllllllIIlIIIlIIlllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllIllllllIIlIIIlIlIIlI, llllllllllllIllllllIIlIIIlIlIIIl, llllllllllllIllllllIIlIIIlIIlIlI, 0, 0, 0, 3, 4, 2, llllllllllllIllllllIIlIIIlIIllll);
            return (StructureComponent.findIntersecting(llllllllllllIllllllIIlIIIlIlIlII, llllllllllllIllllllIIlIIIlIIlllI) != null) ? null : llllllllllllIllllllIIlIIIlIIlllI;
        }
        
        public Torch() {
        }
        
        public Torch(final Start llllllllllllIllllllIIlIIIllIIlIl, final int llllllllllllIllllllIIlIIIlIllllI, final Random llllllllllllIllllllIIlIIIllIIIll, final StructureBoundingBox llllllllllllIllllllIIlIIIlIlllIl, final EnumFacing llllllllllllIllllllIIlIIIlIlllII) {
            super(llllllllllllIllllllIIlIIIllIIlIl, llllllllllllIllllllIIlIIIlIllllI);
            this.setCoordBaseMode(llllllllllllIllllllIIlIIIlIlllII);
            this.boundingBox = llllllllllllIllllllIIlIIIlIlllIl;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIllllllIIlIIIIllllIl, final Random llllllllllllIllllllIIlIIIlIIIIIl, final StructureBoundingBox llllllllllllIllllllIIlIIIlIIIIII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(llllllllllllIllllllIIlIIIIllllIl, llllllllllllIllllllIIlIIIlIIIIII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState llllllllllllIllllllIIlIIIIllllll = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(llllllllllllIllllllIIlIIIIllllIl, llllllllllllIllllllIIlIIIlIIIIII, 0, 0, 0, 2, 3, 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(llllllllllllIllllllIIlIIIIllllIl, llllllllllllIllllllIIlIIIIllllll, 1, 0, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.setBlockState(llllllllllllIllllllIIlIIIIllllIl, llllllllllllIllllllIIlIIIIllllll, 1, 1, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.setBlockState(llllllllllllIllllllIIlIIIIllllIl, llllllllllllIllllllIIlIIIIllllll, 1, 2, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.setBlockState(llllllllllllIllllllIIlIIIIllllIl, Blocks.WOOL.getStateFromMeta(EnumDyeColor.WHITE.getDyeDamage()), 1, 3, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.func_189926_a(llllllllllllIllllllIIlIIIIllllIl, EnumFacing.EAST, 2, 3, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.func_189926_a(llllllllllllIllllllIIlIIIIllllIl, EnumFacing.NORTH, 1, 3, 1, llllllllllllIllllllIIlIIIlIIIIII);
            this.func_189926_a(llllllllllllIllllllIIlIIIIllllIl, EnumFacing.WEST, 0, 3, 0, llllllllllllIllllllIIlIIIlIIIIII);
            this.func_189926_a(llllllllllllIllllllIIlIIIIllllIl, EnumFacing.SOUTH, 1, 3, -1, llllllllllllIllllllIIlIIIlIIIIII);
            return true;
        }
    }
    
    public static class Field1 extends Village
    {
        private /* synthetic */ Block cropTypeC;
        private /* synthetic */ Block cropTypeB;
        private /* synthetic */ Block cropTypeD;
        private /* synthetic */ Block cropTypeA;
        
        public Field1() {
        }
        
        public Field1(final Start lllllllllllllIIlIlIIlIIIIlIlllII, final int lllllllllllllIIlIlIIlIIIIlIllIll, final Random lllllllllllllIIlIlIIlIIIIlIllIlI, final StructureBoundingBox lllllllllllllIIlIlIIlIIIIlIlllll, final EnumFacing lllllllllllllIIlIlIIlIIIIlIllllI) {
            super(lllllllllllllIIlIlIIlIIIIlIlllII, lllllllllllllIIlIlIIlIIIIlIllIll);
            this.setCoordBaseMode(lllllllllllllIIlIlIIlIIIIlIllllI);
            this.boundingBox = lllllllllllllIIlIlIIlIIIIlIlllll;
            this.cropTypeA = this.getRandomCropType(lllllllllllllIIlIlIIlIIIIlIllIlI);
            this.cropTypeB = this.getRandomCropType(lllllllllllllIIlIlIIlIIIIlIllIlI);
            this.cropTypeC = this.getRandomCropType(lllllllllllllIIlIlIIlIIIIlIllIlI);
            this.cropTypeD = this.getRandomCropType(lllllllllllllIIlIlIIlIIIIlIllIlI);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIlIIlIIIIIIllIlI, final Random lllllllllllllIIlIlIIlIIIIIIllIIl, final StructureBoundingBox lllllllllllllIIlIlIIlIIIIIIIlIII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState lllllllllllllIIlIlIIlIIIIIIlIlll = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 0, 1, 0, 12, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 0, 0, 0, 0, 0, 8, lllllllllllllIIlIlIIlIIIIIIlIlll, lllllllllllllIIlIlIIlIIIIIIlIlll, false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 6, 0, 0, 6, 0, 8, lllllllllllllIIlIlIIlIIIIIIlIlll, lllllllllllllIIlIlIIlIIIIIIlIlll, false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 12, 0, 0, 12, 0, 8, lllllllllllllIIlIlIIlIIIIIIlIlll, lllllllllllllIIlIlIIlIIIIIIlIlll, false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 1, 0, 0, 11, 0, 0, lllllllllllllIIlIlIIlIIIIIIlIlll, lllllllllllllIIlIlIIlIIIIIIlIlll, false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 1, 0, 8, 11, 0, 8, lllllllllllllIIlIlIIlIIIIIIlIlll, lllllllllllllIIlIlIIlIIIIIIlIlll, false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIlIII, 9, 0, 1, 9, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            for (int lllllllllllllIIlIlIIlIIIIIIlIllI = 1; lllllllllllllIIlIlIIlIIIIIIlIllI <= 7; ++lllllllllllllIIlIlIIlIIIIIIlIllI) {
                final int lllllllllllllIIlIlIIlIIIIIIlIlIl = ((BlockCrops)this.cropTypeA).getMaxAge();
                final int lllllllllllllIIlIlIIlIIIIIIlIlII = lllllllllllllIIlIlIIlIIIIIIlIlIl / 3;
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIlII, lllllllllllllIIlIlIIlIIIIIIlIlIl)), 1, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIlII, lllllllllllllIIlIlIIlIIIIIIlIlIl)), 2, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                final int lllllllllllllIIlIlIIlIIIIIIlIIll = ((BlockCrops)this.cropTypeB).getMaxAge();
                final int lllllllllllllIIlIlIIlIIIIIIlIIlI = lllllllllllllIIlIlIIlIIIIIIlIIll / 3;
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIIlI, lllllllllllllIIlIlIIlIIIIIIlIIll)), 4, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIIlI, lllllllllllllIIlIlIIlIIIIIIlIIll)), 5, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                final int lllllllllllllIIlIlIIlIIIIIIlIIIl = ((BlockCrops)this.cropTypeC).getMaxAge();
                final int lllllllllllllIIlIlIIlIIIIIIlIIII = lllllllllllllIIlIlIIlIIIIIIlIIIl / 3;
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeC.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIIII, lllllllllllllIIlIlIIlIIIIIIlIIIl)), 7, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeC.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIlIIII, lllllllllllllIIlIlIIlIIIIIIlIIIl)), 8, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                final int lllllllllllllIIlIlIIlIIIIIIIllll = ((BlockCrops)this.cropTypeD).getMaxAge();
                final int lllllllllllllIIlIlIIlIIIIIIIlllI = lllllllllllllIIlIlIIlIIIIIIIllll / 3;
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeD.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIIlllI, lllllllllllllIIlIlIIlIIIIIIIllll)), 10, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
                this.setBlockState(lllllllllllllIIlIlIIlIIIIIIllIlI, this.cropTypeD.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlIIlIIIIIIllIIl, lllllllllllllIIlIlIIlIIIIIIIlllI, lllllllllllllIIlIlIIlIIIIIIIllll)), 11, 1, lllllllllllllIIlIlIIlIIIIIIlIllI, lllllllllllllIIlIlIIlIIIIIIIlIII);
            }
            for (int lllllllllllllIIlIlIIlIIIIIIIllIl = 0; lllllllllllllIIlIlIIlIIIIIIIllIl < 9; ++lllllllllllllIIlIlIIlIIIIIIIllIl) {
                for (int lllllllllllllIIlIlIIlIIIIIIIllII = 0; lllllllllllllIIlIlIIlIIIIIIIllII < 13; ++lllllllllllllIIlIlIIlIIIIIIIllII) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllIIlIlIIlIIIIIIllIlI, lllllllllllllIIlIlIIlIIIIIIIllII, 4, lllllllllllllIIlIlIIlIIIIIIIllIl, lllllllllllllIIlIlIIlIIIIIIIlIII);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlIlIIlIIIIIIllIlI, Blocks.DIRT.getDefaultState(), lllllllllllllIIlIlIIlIIIIIIIllII, -1, lllllllllllllIIlIlIIlIIIIIIIllIl, lllllllllllllIIlIlIIlIIIIIIIlIII);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIlIIlIIIIlIIlIlI, final TemplateManager lllllllllllllIIlIlIIlIIIIlIIlIIl) {
            super.readStructureFromNBT(lllllllllllllIIlIlIIlIIIIlIIlIlI, lllllllllllllIIlIlIIlIIIIlIIlIIl);
            this.cropTypeA = Block.getBlockById(lllllllllllllIIlIlIIlIIIIlIIlIlI.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(lllllllllllllIIlIlIIlIIIIlIIlIlI.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(lllllllllllllIIlIlIIlIIIIlIIlIlI.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(lllllllllllllIIlIlIIlIIIIlIIlIlI.getInteger("CD"));
            if (!(this.cropTypeA instanceof BlockCrops)) {
                this.cropTypeA = Blocks.WHEAT;
            }
            if (!(this.cropTypeB instanceof BlockCrops)) {
                this.cropTypeB = Blocks.CARROTS;
            }
            if (!(this.cropTypeC instanceof BlockCrops)) {
                this.cropTypeC = Blocks.POTATOES;
            }
            if (!(this.cropTypeD instanceof BlockCrops)) {
                this.cropTypeD = Blocks.BEETROOTS;
            }
        }
        
        private Block getRandomCropType(final Random lllllllllllllIIlIlIIlIIIIlIIIllI) {
            switch (lllllllllllllIIlIlIIlIIIIlIIIllI.nextInt(10)) {
                case 0:
                case 1: {
                    return Blocks.CARROTS;
                }
                case 2:
                case 3: {
                    return Blocks.POTATOES;
                }
                case 4: {
                    return Blocks.BEETROOTS;
                }
                default: {
                    return Blocks.WHEAT;
                }
            }
        }
        
        public static Field1 createPiece(final Start lllllllllllllIIlIlIIlIIIIIllIIlI, final List<StructureComponent> lllllllllllllIIlIlIIlIIIIIlllIlI, final Random lllllllllllllIIlIlIIlIIIIIlllIIl, final int lllllllllllllIIlIlIIlIIIIIlIllll, final int lllllllllllllIIlIlIIlIIIIIlIlllI, final int lllllllllllllIIlIlIIlIIIIIlIllIl, final EnumFacing lllllllllllllIIlIlIIlIIIIIlIllII, final int lllllllllllllIIlIlIIlIIIIIllIlII) {
            final StructureBoundingBox lllllllllllllIIlIlIIlIIIIIllIIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIlIIlIIIIIlIllll, lllllllllllllIIlIlIIlIIIIIlIlllI, lllllllllllllIIlIlIIlIIIIIlIllIl, 0, 0, 0, 13, 4, 9, lllllllllllllIIlIlIIlIIIIIlIllII);
            return (Village.canVillageGoDeeper(lllllllllllllIIlIlIIlIIIIIllIIll) && StructureComponent.findIntersecting(lllllllllllllIIlIlIIlIIIIIlllIlI, lllllllllllllIIlIlIIlIIIIIllIIll) == null) ? new Field1(lllllllllllllIIlIlIIlIIIIIllIIlI, lllllllllllllIIlIlIIlIIIIIllIlII, lllllllllllllIIlIlIIlIIIIIlllIIl, lllllllllllllIIlIlIIlIIIIIllIIll, lllllllllllllIIlIlIIlIIIIIlIllII) : null;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIlIIlIIIIlIlIlII) {
            super.writeStructureToNBT(lllllllllllllIIlIlIIlIIIIlIlIlII);
            lllllllllllllIIlIlIIlIIIIlIlIlII.setInteger("CA", Block.REGISTRY.getIDForObject(this.cropTypeA));
            lllllllllllllIIlIlIIlIIIIlIlIlII.setInteger("CB", Block.REGISTRY.getIDForObject(this.cropTypeB));
            lllllllllllllIIlIlIIlIIIIlIlIlII.setInteger("CC", Block.REGISTRY.getIDForObject(this.cropTypeC));
            lllllllllllllIIlIlIIlIIIIlIlIlII.setInteger("CD", Block.REGISTRY.getIDForObject(this.cropTypeD));
        }
    }
    
    public abstract static class Road extends Village
    {
        protected Road(final Start lllllllllllllllIIIllIlllllIlllII, final int lllllllllllllllIIIllIlllllIllIII) {
            super(lllllllllllllllIIIllIlllllIlllII, lllllllllllllllIIIllIlllllIllIII);
        }
        
        public Road() {
        }
    }
    
    public static class House3 extends Village
    {
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIIlIIllIIlIlIllll, final Random lllllllllllIIlIIIlIIllIIlIIlIlIl, final StructureBoundingBox lllllllllllIIlIIIlIIllIIlIIlIlII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
            }
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIllII = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIlIll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIlIlI = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIlIIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIlIII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIlll = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIllI = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 1, 1, 7, 4, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 2, 1, 6, 8, 4, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 2, 0, 5, 8, 0, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 0, 1, 7, 0, 4, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 0, 0, 0, 0, 3, 5, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 8, 0, 0, 8, 3, 10, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 0, 0, 7, 2, 0, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 0, 5, 2, 1, 5, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 2, 0, 6, 2, 3, 10, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 3, 0, 10, 7, 3, 10, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 2, 0, 7, 3, 0, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 2, 5, 2, 3, 5, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 0, 4, 1, 8, 4, 1, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 0, 4, 4, 3, 4, 4, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 0, 5, 2, 8, 5, 3, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 0, 4, 2, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 0, 4, 3, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 8, 4, 2, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 8, 4, 3, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 8, 4, 4, lllllllllllIIlIIIlIIllIIlIIlIlII);
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIlIl = lllllllllllIIlIIIlIIllIIlIlIlIll;
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIlII = lllllllllllIIlIIIlIIllIIlIlIlIlI;
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIIll = lllllllllllIIlIIIlIIllIIlIlIlIII;
            final IBlockState lllllllllllIIlIIIlIIllIIlIlIIIlI = lllllllllllIIlIIIlIIllIIlIlIlIIl;
            for (int lllllllllllIIlIIIlIIllIIlIlIIIIl = -1; lllllllllllIIlIIIlIIllIIlIlIIIIl <= 2; ++lllllllllllIIlIIIlIIllIIlIlIIIIl) {
                for (int lllllllllllIIlIIIlIIllIIlIlIIIII = 0; lllllllllllIIlIIIlIIllIIlIlIIIII <= 8; ++lllllllllllIIlIIIlIIllIIlIlIIIII) {
                    this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlIl, lllllllllllIIlIIIlIIllIIlIlIIIII, 4 + lllllllllllIIlIIIlIIllIIlIlIIIIl, lllllllllllIIlIIIlIIllIIlIlIIIIl, lllllllllllIIlIIIlIIllIIlIIlIlII);
                    if ((lllllllllllIIlIIIlIIllIIlIlIIIIl > -1 || lllllllllllIIlIIIlIIllIIlIlIIIII <= 1) && (lllllllllllIIlIIIlIIllIIlIlIIIIl > 0 || lllllllllllIIlIIIlIIllIIlIlIIIII <= 3) && (lllllllllllIIlIIIlIIllIIlIlIIIIl > 1 || lllllllllllIIlIIIlIIllIIlIlIIIII <= 4 || lllllllllllIIlIIIlIIllIIlIlIIIII >= 6)) {
                        this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlII, lllllllllllIIlIIIlIIllIIlIlIIIII, 4 + lllllllllllIIlIIIlIIllIIlIlIIIIl, 5 - lllllllllllIIlIIIlIIllIIlIlIIIIl, lllllllllllIIlIIIlIIllIIlIIlIlII);
                    }
                }
            }
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 3, 4, 5, 3, 4, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 7, 4, 2, 7, 4, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 4, 5, 4, 4, 5, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 6, 5, 4, 6, 5, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 5, 6, 3, 5, 6, 10, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIlIIlll, false);
            for (int lllllllllllIIlIIIlIIllIIlIIlllll = 4; lllllllllllIIlIIIlIIllIIlIIlllll >= 1; --lllllllllllIIlIIIlIIllIIlIIlllll) {
                this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, lllllllllllIIlIIIlIIllIIlIIlllll, 2 + lllllllllllIIlIIIlIIllIIlIIlllll, 7 - lllllllllllIIlIIIlIIllIIlIIlllll, lllllllllllIIlIIIlIIllIIlIIlIlII);
                for (int lllllllllllIIlIIIlIIllIIlIIllllI = 8 - lllllllllllIIlIIIlIIllIIlIIlllll; lllllllllllIIlIIIlIIllIIlIIllllI <= 10; ++lllllllllllIIlIIIlIIllIIlIIllllI) {
                    this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIIlI, lllllllllllIIlIIIlIIllIIlIIlllll, 2 + lllllllllllIIlIIIlIIllIIlIIlllll, lllllllllllIIlIIIlIIllIIlIIllllI, lllllllllllIIlIIIlIIllIIlIIlIlII);
                }
            }
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 6, 6, 3, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 7, 5, 4, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIlIII, 6, 6, 4, lllllllllllIIlIIIlIIllIIlIIlIlII);
            for (int lllllllllllIIlIIIlIIllIIlIIlllIl = 6; lllllllllllIIlIIIlIIllIIlIIlllIl <= 8; ++lllllllllllIIlIIIlIIllIIlIIlllIl) {
                for (int lllllllllllIIlIIIlIIllIIlIIlllII = 5; lllllllllllIIlIIIlIIllIIlIIlllII <= 10; ++lllllllllllIIlIIIlIIllIIlIIlllII) {
                    this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIIll, lllllllllllIIlIIIlIIllIIlIIlllIl, 12 - lllllllllllIIlIIIlIIllIIlIIlllIl, lllllllllllIIlIIIlIIllIIlIIlllII, lllllllllllIIlIIIlIIllIIlIIlIlII);
                }
            }
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 0, 2, 1, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 0, 2, 4, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 4, 2, 0, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 6, 2, 0, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 8, 2, 1, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 8, 2, 4, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 8, 2, 5, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 8, 2, 6, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 7, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 8, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 8, 2, 9, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 2, 2, 6, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 7, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 8, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 2, 2, 9, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 4, 4, 10, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 5, 4, 10, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIllI, 6, 4, 10, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlll, 5, 5, 10, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.func_189926_a(lllllllllllIIlIIIlIIllIIlIlIllll, EnumFacing.NORTH, 2, 3, 1, lllllllllllIIlIIIlIIllIIlIIlIlII);
            this.func_189927_a(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, lllllllllllIIlIIIlIIllIIlIIlIlIl, 2, 1, 0, EnumFacing.NORTH);
            this.fillWithBlocks(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 1, 0, -1, 3, 2, -1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            if (this.getBlockStateFromPos(lllllllllllIIlIIIlIIllIIlIlIllll, 2, 0, -1, lllllllllllIIlIIIlIIllIIlIIlIlII).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllIIlIIIlIIllIIlIlIllll, 2, -1, -1, lllllllllllIIlIIIlIIllIIlIIlIlII).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIIlIl, 2, 0, -1, lllllllllllIIlIIIlIIllIIlIIlIlII);
                if (this.getBlockStateFromPos(lllllllllllIIlIIIlIIllIIlIlIllll, 2, -1, -1, lllllllllllIIlIIIlIIllIIlIIlIlII).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllIIlIIIlIIllIIlIlIllll, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllIIlIIIlIIllIIlIIlIlII);
                }
            }
            for (int lllllllllllIIlIIIlIIllIIlIIllIll = 0; lllllllllllIIlIIIlIIllIIlIIllIll < 5; ++lllllllllllIIlIIIlIIllIIlIIllIll) {
                for (int lllllllllllIIlIIIlIIllIIlIIllIlI = 0; lllllllllllIIlIIIlIIllIIlIIllIlI < 9; ++lllllllllllIIlIIIlIIllIIlIIllIlI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIllIlI, 7, lllllllllllIIlIIIlIIllIIlIIllIll, lllllllllllIIlIIIlIIllIIlIIlIlII);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIIllIlI, -1, lllllllllllIIlIIIlIIllIIlIIllIll, lllllllllllIIlIIIlIIllIIlIIlIlII);
                }
            }
            for (int lllllllllllIIlIIIlIIllIIlIIllIIl = 5; lllllllllllIIlIIIlIIllIIlIIllIIl < 11; ++lllllllllllIIlIIIlIIllIIlIIllIIl) {
                for (int lllllllllllIIlIIIlIIllIIlIIllIII = 2; lllllllllllIIlIIIlIIllIIlIIllIII < 9; ++lllllllllllIIlIIIlIIllIIlIIllIII) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIllIII, 7, lllllllllllIIlIIIlIIllIIlIIllIIl, lllllllllllIIlIIIlIIllIIlIIlIlII);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIlIllII, lllllllllllIIlIIIlIIllIIlIIllIII, -1, lllllllllllIIlIIIlIIllIIlIIllIIl, lllllllllllIIlIIIlIIllIIlIIlIlII);
                }
            }
            this.spawnVillagers(lllllllllllIIlIIIlIIllIIlIlIllll, lllllllllllIIlIIIlIIllIIlIIlIlII, 4, 1, 2, 2);
            return true;
        }
        
        public House3(final Start lllllllllllIIlIIIlIIllIIlllIIIII, final int lllllllllllIIlIIIlIIllIIllIlllll, final Random lllllllllllIIlIIIlIIllIIlllIIlII, final StructureBoundingBox lllllllllllIIlIIIlIIllIIlllIIIll, final EnumFacing lllllllllllIIlIIIlIIllIIlllIIIlI) {
            super(lllllllllllIIlIIIlIIllIIlllIIIII, lllllllllllIIlIIIlIIllIIllIlllll);
            this.setCoordBaseMode(lllllllllllIIlIIIlIIllIIlllIIIlI);
            this.boundingBox = lllllllllllIIlIIIlIIllIIlllIIIll;
        }
        
        public House3() {
        }
        
        public static House3 createPiece(final Start lllllllllllIIlIIIlIIllIIllIlIIll, final List<StructureComponent> lllllllllllIIlIIIlIIllIIllIIlIIl, final Random lllllllllllIIlIIIlIIllIIllIIlIII, final int lllllllllllIIlIIIlIIllIIllIlIIII, final int lllllllllllIIlIIIlIIllIIllIIIllI, final int lllllllllllIIlIIIlIIllIIllIIlllI, final EnumFacing lllllllllllIIlIIIlIIllIIllIIllIl, final int lllllllllllIIlIIIlIIllIIllIIIIll) {
            final StructureBoundingBox lllllllllllIIlIIIlIIllIIllIIlIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIIlIIllIIllIlIIII, lllllllllllIIlIIIlIIllIIllIIIllI, lllllllllllIIlIIIlIIllIIllIIlllI, 0, 0, 0, 9, 7, 12, lllllllllllIIlIIIlIIllIIllIIllIl);
            return (Village.canVillageGoDeeper(lllllllllllIIlIIIlIIllIIllIIlIll) && StructureComponent.findIntersecting(lllllllllllIIlIIIlIIllIIllIIlIIl, lllllllllllIIlIIIlIIllIIllIIlIll) == null) ? new House3(lllllllllllIIlIIIlIIllIIllIlIIll, lllllllllllIIlIIIlIIllIIllIIIIll, lllllllllllIIlIIIlIIllIIllIIlIII, lllllllllllIIlIIIlIIllIIllIIlIll, lllllllllllIIlIIIlIIllIIllIIllIl) : null;
        }
    }
    
    public static class Hall extends Village
    {
        public static Hall createPiece(final Start lllllllllllIIIlIllllIIIIllIlIIIl, final List<StructureComponent> lllllllllllIIIlIllllIIIIllIlIIII, final Random lllllllllllIIIlIllllIIIIllIIllll, final int lllllllllllIIIlIllllIIIIllIIlllI, final int lllllllllllIIIlIllllIIIIllIIllIl, final int lllllllllllIIIlIllllIIIIllIIllII, final EnumFacing lllllllllllIIIlIllllIIIIllIIlIll, final int lllllllllllIIIlIllllIIIIllIIIIIl) {
            final StructureBoundingBox lllllllllllIIIlIllllIIIIllIIlIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIIlIllllIIIIllIIlllI, lllllllllllIIIlIllllIIIIllIIllIl, lllllllllllIIIlIllllIIIIllIIllII, 0, 0, 0, 9, 7, 11, lllllllllllIIIlIllllIIIIllIIlIll);
            return (Village.canVillageGoDeeper(lllllllllllIIIlIllllIIIIllIIlIIl) && StructureComponent.findIntersecting(lllllllllllIIIlIllllIIIIllIlIIII, lllllllllllIIIlIllllIIIIllIIlIIl) == null) ? new Hall(lllllllllllIIIlIllllIIIIllIlIIIl, lllllllllllIIIlIllllIIIIllIIIIIl, lllllllllllIIIlIllllIIIIllIIllll, lllllllllllIIIlIllllIIIIllIIlIIl, lllllllllllIIIlIllllIIIIllIIlIll) : null;
        }
        
        @Override
        protected int chooseProfession(final int lllllllllllIIIlIllllIIIIlIIIlIIl, final int lllllllllllIIIlIllllIIIIlIIIlIII) {
            return (lllllllllllIIIlIllllIIIIlIIIlIIl == 0) ? 4 : super.chooseProfession(lllllllllllIIIlIllllIIIIlIIIlIIl, lllllllllllIIIlIllllIIIIlIIIlIII);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIIlIllllIIIIlIlIllll, final Random lllllllllllIIIlIllllIIIIlIIlllIl, final StructureBoundingBox lllllllllllIIIlIllllIIIIlIlIllIl) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
            }
            final IBlockState lllllllllllIIIlIllllIIIIlIlIllII = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllIIIlIllllIIIIlIlIlIll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIIlIllllIIIIlIlIlIlI = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllIIIlIllllIIIIlIlIlIIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllIIIlIllllIIIIlIlIlIII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllIIIlIllllIIIIlIlIIlll = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllIIIlIllllIIIIlIlIIllI = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 1, 1, 7, 4, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 2, 1, 6, 8, 4, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 2, 0, 6, 8, 0, 10, Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), false);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllII, 6, 0, 6, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 2, 1, 6, 2, 1, 10, lllllllllllIIIlIllllIIIIlIlIIllI, lllllllllllIIIlIllllIIIIlIlIIllI, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 8, 1, 6, 8, 1, 10, lllllllllllIIIlIllllIIIIlIlIIllI, lllllllllllIIIlIllllIIIIlIlIIllI, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 3, 1, 10, 7, 1, 10, lllllllllllIIIlIllllIIIIlIlIIllI, lllllllllllIIIlIllllIIIIlIlIIllI, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 0, 1, 7, 0, 4, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 0, 0, 0, 0, 3, 5, lllllllllllIIIlIllllIIIIlIlIllII, lllllllllllIIIlIllllIIIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 8, 0, 0, 8, 3, 5, lllllllllllIIIlIllllIIIIlIlIllII, lllllllllllIIIlIllllIIIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 0, 0, 7, 1, 0, lllllllllllIIIlIllllIIIIlIlIllII, lllllllllllIIIlIllllIIIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 0, 5, 7, 1, 5, lllllllllllIIIlIllllIIIIlIlIllII, lllllllllllIIIlIllllIIIIlIlIllII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 2, 0, 7, 3, 0, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 1, 2, 5, 7, 3, 5, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 0, 4, 1, 8, 4, 1, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 0, 4, 4, 8, 4, 4, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 0, 5, 2, 8, 5, 3, lllllllllllIIIlIllllIIIIlIlIlIII, lllllllllllIIIlIllllIIIIlIlIlIII, false);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIII, 0, 4, 2, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIII, 0, 4, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIII, 8, 4, 2, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIII, 8, 4, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            final IBlockState lllllllllllIIIlIllllIIIIlIlIIlIl = lllllllllllIIIlIllllIIIIlIlIlIll;
            final IBlockState lllllllllllIIIlIllllIIIIlIlIIlII = lllllllllllIIIlIllllIIIIlIlIlIlI;
            for (int lllllllllllIIIlIllllIIIIlIlIIIll = -1; lllllllllllIIIlIllllIIIIlIlIIIll <= 2; ++lllllllllllIIIlIllllIIIIlIlIIIll) {
                for (int lllllllllllIIIlIllllIIIIlIlIIIlI = 0; lllllllllllIIIlIllllIIIIlIlIIIlI <= 8; ++lllllllllllIIIlIllllIIIIlIlIIIlI) {
                    this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlIl, lllllllllllIIIlIllllIIIIlIlIIIlI, 4 + lllllllllllIIIlIllllIIIIlIlIIIll, lllllllllllIIIlIllllIIIIlIlIIIll, lllllllllllIIIlIllllIIIIlIlIllIl);
                    this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlII, lllllllllllIIIlIllllIIIIlIlIIIlI, 4 + lllllllllllIIIlIllllIIIIlIlIIIll, 5 - lllllllllllIIIlIllllIIIIlIlIIIll, lllllllllllIIIlIllllIIIIlIlIllIl);
                }
            }
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlll, 0, 2, 1, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlll, 0, 2, 4, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlll, 8, 2, 1, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlll, 8, 2, 4, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIllI, 2, 1, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 2, 2, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIII, 1, 1, 4, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlIl, 2, 1, 4, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIlIIl, 1, 1, 3, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.fillWithBlocks(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), Blocks.DOUBLE_STONE_SLAB.getDefaultState(), false);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 1, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 2, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.func_189926_a(lllllllllllIIIlIllllIIIIlIlIllll, EnumFacing.NORTH, 2, 3, 1, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.func_189927_a(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, lllllllllllIIIlIllllIIIIlIIlllIl, 2, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllIIIlIllllIIIIlIlIllll, 2, 0, -1, lllllllllllIIIlIllllIIIIlIlIllIl).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllIIIlIllllIIIIlIlIllll, 2, -1, -1, lllllllllllIIIlIllllIIIIlIlIllIl).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIlIl, 2, 0, -1, lllllllllllIIIlIllllIIIIlIlIllIl);
                if (this.getBlockStateFromPos(lllllllllllIIIlIllllIIIIlIlIllll, 2, -1, -1, lllllllllllIIIlIllllIIIIlIlIllIl).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllIIIlIllllIIIIlIlIllIl);
                }
            }
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.AIR.getDefaultState(), 6, 1, 5, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.setBlockState(lllllllllllIIIlIllllIIIIlIlIllll, Blocks.AIR.getDefaultState(), 6, 2, 5, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.func_189926_a(lllllllllllIIIlIllllIIIIlIlIllll, EnumFacing.SOUTH, 6, 3, 4, lllllllllllIIIlIllllIIIIlIlIllIl);
            this.func_189927_a(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, lllllllllllIIIlIllllIIIIlIIlllIl, 6, 1, 5, EnumFacing.SOUTH);
            for (int lllllllllllIIIlIllllIIIIlIlIIIIl = 0; lllllllllllIIIlIllllIIIIlIlIIIIl < 5; ++lllllllllllIIIlIllllIIIIlIlIIIIl) {
                for (int lllllllllllIIIlIllllIIIIlIlIIIII = 0; lllllllllllIIIlIllllIIIIlIlIIIII < 9; ++lllllllllllIIIlIllllIIIIlIlIIIII) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIIIII, 7, lllllllllllIIIlIllllIIIIlIlIIIIl, lllllllllllIIIlIllllIIIIlIlIllIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllII, lllllllllllIIIlIllllIIIIlIlIIIII, -1, lllllllllllIIIlIllllIIIIlIlIIIIl, lllllllllllIIIlIllllIIIIlIlIllIl);
                }
            }
            this.spawnVillagers(lllllllllllIIIlIllllIIIIlIlIllll, lllllllllllIIIlIllllIIIIlIlIllIl, 4, 1, 2, 2);
            return true;
        }
        
        public Hall(final Start lllllllllllIIIlIllllIIIIllIllllI, final int lllllllllllIIIlIllllIIIIlllIIIll, final Random lllllllllllIIIlIllllIIIIlllIIIlI, final StructureBoundingBox lllllllllllIIIlIllllIIIIllIlllII, final EnumFacing lllllllllllIIIlIllllIIIIlllIIIII) {
            super(lllllllllllIIIlIllllIIIIllIllllI, lllllllllllIIIlIllllIIIIlllIIIll);
            this.setCoordBaseMode(lllllllllllIIIlIllllIIIIlllIIIII);
            this.boundingBox = lllllllllllIIIlIllllIIIIllIlllII;
        }
        
        public Hall() {
        }
    }
    
    public static class House4Garden extends Village
    {
        private /* synthetic */ boolean isRoofAccessible;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlIlIlIlllIIlllII) {
            super.writeStructureToNBT(lllllllllllllllIlIlIlIlllIIlllII);
            lllllllllllllllIlIlIlIlllIIlllII.setBoolean("Terrace", this.isRoofAccessible);
        }
        
        public House4Garden(final Start lllllllllllllllIlIlIlIlllIlIllII, final int lllllllllllllllIlIlIlIlllIlIlIll, final Random lllllllllllllllIlIlIlIlllIlIlIlI, final StructureBoundingBox lllllllllllllllIlIlIlIlllIlIIIll, final EnumFacing lllllllllllllllIlIlIlIlllIlIlIII) {
            super(lllllllllllllllIlIlIlIlllIlIllII, lllllllllllllllIlIlIlIlllIlIlIll);
            this.setCoordBaseMode(lllllllllllllllIlIlIlIlllIlIlIII);
            this.boundingBox = lllllllllllllllIlIlIlIlllIlIIIll;
            this.isRoofAccessible = lllllllllllllllIlIlIlIlllIlIlIlI.nextBoolean();
        }
        
        public House4Garden() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlIlIlIlllIIlIlll, final TemplateManager lllllllllllllllIlIlIlIlllIIlIllI) {
            super.readStructureFromNBT(lllllllllllllllIlIlIlIlllIIlIlll, lllllllllllllllIlIlIlIlllIIlIllI);
            this.isRoofAccessible = lllllllllllllllIlIlIlIlllIIlIlll.getBoolean("Terrace");
        }
        
        public static House4Garden createPiece(final Start lllllllllllllllIlIlIlIlllIIIIIII, final List<StructureComponent> lllllllllllllllIlIlIlIllIlllllll, final Random lllllllllllllllIlIlIlIlllIIIIlll, final int lllllllllllllllIlIlIlIllIlllllIl, final int lllllllllllllllIlIlIlIllIlllllII, final int lllllllllllllllIlIlIlIlllIIIIlII, final EnumFacing lllllllllllllllIlIlIlIllIllllIlI, final int lllllllllllllllIlIlIlIllIllllIIl) {
            final StructureBoundingBox lllllllllllllllIlIlIlIlllIIIIIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllIlIlIlIllIlllllIl, lllllllllllllllIlIlIlIllIlllllII, lllllllllllllllIlIlIlIlllIIIIlII, 0, 0, 0, 5, 6, 5, lllllllllllllllIlIlIlIllIllllIlI);
            return (StructureComponent.findIntersecting(lllllllllllllllIlIlIlIllIlllllll, lllllllllllllllIlIlIlIlllIIIIIIl) != null) ? null : new House4Garden(lllllllllllllllIlIlIlIlllIIIIIII, lllllllllllllllIlIlIlIllIllllIIl, lllllllllllllllIlIlIlIlllIIIIlll, lllllllllllllllIlIlIlIlllIIIIIIl, lllllllllllllllIlIlIlIllIllllIlI);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlIlIlIllIllIllII, final Random lllllllllllllllIlIlIlIllIllIlIll, final StructureBoundingBox lllllllllllllllIlIlIlIllIlIlllll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState lllllllllllllllIlIlIlIllIllIlIIl = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllllIlIlIlIllIllIlIII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllllIlIlIlIllIllIIlll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllllIlIlIlIllIllIIllI = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllllllIlIlIlIllIllIIlIl = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 0, 0, 0, 4, 0, 4, lllllllllllllllIlIlIlIllIllIlIIl, lllllllllllllllIlIlIlIllIllIlIIl, false);
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 0, 4, 0, 4, 4, 4, lllllllllllllllIlIlIlIllIllIIllI, lllllllllllllllIlIlIlIllIllIIllI, false);
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 1, 4, 1, 3, 4, 3, lllllllllllllllIlIlIlIllIllIlIII, lllllllllllllllIlIlIlIllIllIlIII, false);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 1, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 2, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 3, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 1, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 2, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 3, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 1, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 2, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 0, 3, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 1, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 2, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, 4, 3, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 0, 1, 1, 0, 3, 3, lllllllllllllllIlIlIlIllIllIlIII, lllllllllllllllIlIlIlIllIllIlIII, false);
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 4, 1, 1, 4, 3, 3, lllllllllllllllIlIlIlIllIllIlIII, lllllllllllllllIlIlIlIllIllIlIII, false);
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 1, 1, 4, 3, 3, 4, lllllllllllllllIlIlIlIllIllIlIII, lllllllllllllllIlIlIlIllIllIlIII, false);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 4, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 2, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 1, 1, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 1, 2, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 1, 3, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 2, 3, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 3, 3, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 3, 2, 0, lllllllllllllllIlIlIlIllIlIlllll);
            this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIII, 3, 1, 0, lllllllllllllllIlIlIlIllIlIlllll);
            if (this.getBlockStateFromPos(lllllllllllllllIlIlIlIllIllIllII, 2, 0, -1, lllllllllllllllIlIlIlIllIlIlllll).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllllIlIlIlIllIllIllII, 2, -1, -1, lllllllllllllllIlIlIlIllIlIlllll).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlll, 2, 0, -1, lllllllllllllllIlIlIlIllIlIlllll);
                if (this.getBlockStateFromPos(lllllllllllllllIlIlIlIllIllIllII, 2, -1, -1, lllllllllllllllIlIlIlIllIlIlllll).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllllllIlIlIlIllIlIlllll);
                }
            }
            this.fillWithBlocks(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 1, 1, 1, 3, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            if (this.isRoofAccessible) {
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 0, 5, 0, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 1, 5, 0, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 2, 5, 0, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 3, 5, 0, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 4, 5, 0, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 0, 5, 4, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 1, 5, 4, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 2, 5, 4, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 3, 5, 4, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 4, 5, 4, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 4, 5, 1, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 4, 5, 2, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 4, 5, 3, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 0, 5, 1, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 0, 5, 2, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlIl, 0, 5, 3, lllllllllllllllIlIlIlIllIlIlllll);
            }
            if (this.isRoofAccessible) {
                final IBlockState lllllllllllllllIlIlIlIllIllIIlII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.SOUTH);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlII, 3, 1, 3, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlII, 3, 2, 3, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlII, 3, 3, 3, lllllllllllllllIlIlIlIllIlIlllll);
                this.setBlockState(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIlII, 3, 4, 3, lllllllllllllllIlIlIlIllIlIlllll);
            }
            this.func_189926_a(lllllllllllllllIlIlIlIllIllIllII, EnumFacing.NORTH, 2, 3, 1, lllllllllllllllIlIlIlIllIlIlllll);
            for (int lllllllllllllllIlIlIlIllIllIIIll = 0; lllllllllllllllIlIlIlIllIllIIIll < 5; ++lllllllllllllllIlIlIlIllIllIIIll) {
                for (int lllllllllllllllIlIlIlIllIllIIIlI = 0; lllllllllllllllIlIlIlIllIllIIIlI < 5; ++lllllllllllllllIlIlIlIllIllIIIlI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIIIlI, 6, lllllllllllllllIlIlIlIllIllIIIll, lllllllllllllllIlIlIlIllIlIlllll);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIllIlIIl, lllllllllllllllIlIlIlIllIllIIIlI, -1, lllllllllllllllIlIlIlIllIllIIIll, lllllllllllllllIlIlIlIllIlIlllll);
                }
            }
            this.spawnVillagers(lllllllllllllllIlIlIlIllIllIllII, lllllllllllllllIlIlIlIllIlIlllll, 1, 1, 2, 1);
            return true;
        }
    }
    
    public static class WoodHut extends Village
    {
        private /* synthetic */ int tablePosition;
        private /* synthetic */ boolean isTallHouse;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIlIIIIIIlIIIIll) {
            super.writeStructureToNBT(llllllllllllllIIlIlIIIIIIlIIIIll);
            llllllllllllllIIlIlIIIIIIlIIIIll.setInteger("T", this.tablePosition);
            llllllllllllllIIlIlIIIIIIlIIIIll.setBoolean("C", this.isTallHouse);
        }
        
        public WoodHut() {
        }
        
        public static WoodHut createPiece(final Start llllllllllllllIIlIlIIIIIIIlIIlll, final List<StructureComponent> llllllllllllllIIlIlIIIIIIIlIllll, final Random llllllllllllllIIlIlIIIIIIIlIlllI, final int llllllllllllllIIlIlIIIIIIIlIllIl, final int llllllllllllllIIlIlIIIIIIIlIIIll, final int llllllllllllllIIlIlIIIIIIIlIlIll, final EnumFacing llllllllllllllIIlIlIIIIIIIlIIIIl, final int llllllllllllllIIlIlIIIIIIIlIlIIl) {
            final StructureBoundingBox llllllllllllllIIlIlIIIIIIIlIlIII = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIlIIIIIIIlIllIl, llllllllllllllIIlIlIIIIIIIlIIIll, llllllllllllllIIlIlIIIIIIIlIlIll, 0, 0, 0, 4, 6, 5, llllllllllllllIIlIlIIIIIIIlIIIIl);
            return (Village.canVillageGoDeeper(llllllllllllllIIlIlIIIIIIIlIlIII) && StructureComponent.findIntersecting(llllllllllllllIIlIlIIIIIIIlIllll, llllllllllllllIIlIlIIIIIIIlIlIII) == null) ? new WoodHut(llllllllllllllIIlIlIIIIIIIlIIlll, llllllllllllllIIlIlIIIIIIIlIlIIl, llllllllllllllIIlIlIIIIIIIlIlllI, llllllllllllllIIlIlIIIIIIIlIlIII, llllllllllllllIIlIlIIIIIIIlIIIIl) : null;
        }
        
        public WoodHut(final Start llllllllllllllIIlIlIIIIIIlIlIIll, final int llllllllllllllIIlIlIIIIIIlIlIIlI, final Random llllllllllllllIIlIlIIIIIIlIIlIll, final StructureBoundingBox llllllllllllllIIlIlIIIIIIlIIlIlI, final EnumFacing llllllllllllllIIlIlIIIIIIlIIlIIl) {
            super(llllllllllllllIIlIlIIIIIIlIlIIll, llllllllllllllIIlIlIIIIIIlIlIIlI);
            this.setCoordBaseMode(llllllllllllllIIlIlIIIIIIlIIlIIl);
            this.boundingBox = llllllllllllllIIlIlIIIIIIlIIlIlI;
            this.isTallHouse = llllllllllllllIIlIlIIIIIIlIIlIll.nextBoolean();
            this.tablePosition = llllllllllllllIIlIlIIIIIIlIIlIll.nextInt(3);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIlIIIIIIIIlIIlI, final Random llllllllllllllIIlIlIIIIIIIIIIllI, final StructureBoundingBox llllllllllllllIIlIlIIIIIIIIlIIII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState llllllllllllllIIlIlIIIIIIIIIllll = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState llllllllllllllIIlIlIIIIIIIIIlllI = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState llllllllllllllIIlIlIIIIIIIIIllIl = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState llllllllllllllIIlIlIIIIIIIIIllII = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState llllllllllllllIIlIlIIIIIIIIIlIll = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 1, 1, 3, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 0, 0, 0, 3, 0, 4, llllllllllllllIIlIlIIIIIIIIIllll, llllllllllllllIIlIlIIIIIIIIIllll, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 0, 1, 2, 0, 3, Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), false);
            if (this.isTallHouse) {
                this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 4, 1, 2, 4, 3, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            }
            else {
                this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 5, 1, 2, 5, 3, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            }
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 1, 4, 0, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 2, 4, 0, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 1, 4, 4, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 2, 4, 4, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 0, 4, 1, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 0, 4, 2, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 0, 4, 3, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 3, 4, 1, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 3, 4, 2, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllII, 3, 4, 3, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 0, 1, 0, 0, 3, 0, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 3, 1, 0, 3, 3, 0, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 0, 1, 4, 0, 3, 4, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 3, 1, 4, 3, 3, 4, llllllllllllllIIlIlIIIIIIIIIllII, llllllllllllllIIlIlIIIIIIIIIllII, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 0, 1, 1, 0, 3, 3, llllllllllllllIIlIlIIIIIIIIIlllI, llllllllllllllIIlIlIIIIIIIIIlllI, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 3, 1, 1, 3, 3, 3, llllllllllllllIIlIlIIIIIIIIIlllI, llllllllllllllIIlIlIIIIIIIIIlllI, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 1, 0, 2, 3, 0, llllllllllllllIIlIlIIIIIIIIIlllI, llllllllllllllIIlIlIIIIIIIIIlllI, false);
            this.fillWithBlocks(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 1, 4, 2, 3, 4, llllllllllllllIIlIlIIIIIIIIIlllI, llllllllllllllIIlIlIIIIIIIIIlllI, false);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 2, llllllllllllllIIlIlIIIIIIIIlIIII);
            if (this.tablePosition > 0) {
                this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIlIll, this.tablePosition, 1, 3, llllllllllllllIIlIlIIIIIIIIlIIII);
                this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), this.tablePosition, 2, 3, llllllllllllllIIlIlIIIIIIIIlIIII);
            }
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.AIR.getDefaultState(), 1, 1, 0, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.AIR.getDefaultState(), 1, 2, 0, llllllllllllllIIlIlIIIIIIIIlIIII);
            this.func_189927_a(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, llllllllllllllIIlIlIIIIIIIIIIllI, 1, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(llllllllllllllIIlIlIIIIIIIIlIIlI, 1, 0, -1, llllllllllllllIIlIlIIIIIIIIlIIII).getMaterial() == Material.AIR && this.getBlockStateFromPos(llllllllllllllIIlIlIIIIIIIIlIIlI, 1, -1, -1, llllllllllllllIIlIlIIIIIIIIlIIII).getMaterial() != Material.AIR) {
                this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllIl, 1, 0, -1, llllllllllllllIIlIlIIIIIIIIlIIII);
                if (this.getBlockStateFromPos(llllllllllllllIIlIlIIIIIIIIlIIlI, 1, -1, -1, llllllllllllllIIlIlIIIIIIIIlIIII).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(llllllllllllllIIlIlIIIIIIIIlIIlI, Blocks.GRASS.getDefaultState(), 1, -1, -1, llllllllllllllIIlIlIIIIIIIIlIIII);
                }
            }
            for (int llllllllllllllIIlIlIIIIIIIIIlIlI = 0; llllllllllllllIIlIlIIIIIIIIIlIlI < 5; ++llllllllllllllIIlIlIIIIIIIIIlIlI) {
                for (int llllllllllllllIIlIlIIIIIIIIIlIIl = 0; llllllllllllllIIlIlIIIIIIIIIlIIl < 4; ++llllllllllllllIIlIlIIIIIIIIIlIIl) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIlIIl, 6, llllllllllllllIIlIlIIIIIIIIIlIlI, llllllllllllllIIlIlIIIIIIIIlIIII);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIIllll, llllllllllllllIIlIlIIIIIIIIIlIIl, -1, llllllllllllllIIlIlIIIIIIIIIlIlI, llllllllllllllIIlIlIIIIIIIIlIIII);
                }
            }
            this.spawnVillagers(llllllllllllllIIlIlIIIIIIIIlIIlI, llllllllllllllIIlIlIIIIIIIIlIIII, 1, 1, 2, 1);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIlIIIIIIIlllllI, final TemplateManager llllllllllllllIIlIlIIIIIIIlllIlI) {
            super.readStructureFromNBT(llllllllllllllIIlIlIIIIIIIlllllI, llllllllllllllIIlIlIIIIIIIlllIlI);
            this.tablePosition = llllllllllllllIIlIlIIIIIIIlllllI.getInteger("T");
            this.isTallHouse = llllllllllllllIIlIlIIIIIIIlllllI.getBoolean("C");
        }
    }
    
    public static class Field2 extends Village
    {
        private /* synthetic */ Block cropTypeB;
        private /* synthetic */ Block cropTypeA;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIllIIIIllIlIIllIllII) {
            super.writeStructureToNBT(llllllllllllIllIIIIllIlIIllIllII);
            llllllllllllIllIIIIllIlIIllIllII.setInteger("CA", Block.REGISTRY.getIDForObject(this.cropTypeA));
            llllllllllllIllIIIIllIlIIllIllII.setInteger("CB", Block.REGISTRY.getIDForObject(this.cropTypeB));
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIllIIIIllIlIIIllIllI, final Random llllllllllllIllIIIIllIlIIIlIlIIl, final StructureBoundingBox llllllllllllIllIIIIllIlIIIlIlIII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState llllllllllllIllIIIIllIlIIIllIIll = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 0, 1, 0, 6, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 0, 0, 0, 0, 0, 8, llllllllllllIllIIIIllIlIIIllIIll, llllllllllllIllIIIIllIlIIIllIIll, false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 6, 0, 0, 6, 0, 8, llllllllllllIllIIIIllIlIIIllIIll, llllllllllllIllIIIIllIlIIIllIIll, false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 1, 0, 0, 5, 0, 0, llllllllllllIllIIIIllIlIIIllIIll, llllllllllllIllIIIIllIlIIIllIIll, false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 1, 0, 8, 5, 0, 8, llllllllllllIllIIIIllIlIIIllIIll, llllllllllllIllIIIIllIlIIIllIIll, false);
            this.fillWithBlocks(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIlIII, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            for (int llllllllllllIllIIIIllIlIIIllIIlI = 1; llllllllllllIllIIIIllIlIIIllIIlI <= 7; ++llllllllllllIllIIIIllIlIIIllIIlI) {
                final int llllllllllllIllIIIIllIlIIIllIIIl = ((BlockCrops)this.cropTypeA).getMaxAge();
                final int llllllllllllIllIIIIllIlIIIllIIII = llllllllllllIllIIIIllIlIIIllIIIl / 3;
                this.setBlockState(llllllllllllIllIIIIllIlIIIllIllI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(llllllllllllIllIIIIllIlIIIlIlIIl, llllllllllllIllIIIIllIlIIIllIIII, llllllllllllIllIIIIllIlIIIllIIIl)), 1, 1, llllllllllllIllIIIIllIlIIIllIIlI, llllllllllllIllIIIIllIlIIIlIlIII);
                this.setBlockState(llllllllllllIllIIIIllIlIIIllIllI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(llllllllllllIllIIIIllIlIIIlIlIIl, llllllllllllIllIIIIllIlIIIllIIII, llllllllllllIllIIIIllIlIIIllIIIl)), 2, 1, llllllllllllIllIIIIllIlIIIllIIlI, llllllllllllIllIIIIllIlIIIlIlIII);
                final int llllllllllllIllIIIIllIlIIIlIllll = ((BlockCrops)this.cropTypeB).getMaxAge();
                final int llllllllllllIllIIIIllIlIIIlIlllI = llllllllllllIllIIIIllIlIIIlIllll / 3;
                this.setBlockState(llllllllllllIllIIIIllIlIIIllIllI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(llllllllllllIllIIIIllIlIIIlIlIIl, llllllllllllIllIIIIllIlIIIlIlllI, llllllllllllIllIIIIllIlIIIlIllll)), 4, 1, llllllllllllIllIIIIllIlIIIllIIlI, llllllllllllIllIIIIllIlIIIlIlIII);
                this.setBlockState(llllllllllllIllIIIIllIlIIIllIllI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(llllllllllllIllIIIIllIlIIIlIlIIl, llllllllllllIllIIIIllIlIIIlIlllI, llllllllllllIllIIIIllIlIIIlIllll)), 5, 1, llllllllllllIllIIIIllIlIIIllIIlI, llllllllllllIllIIIIllIlIIIlIlIII);
            }
            for (int llllllllllllIllIIIIllIlIIIlIllIl = 0; llllllllllllIllIIIIllIlIIIlIllIl < 9; ++llllllllllllIllIIIIllIlIIIlIllIl) {
                for (int llllllllllllIllIIIIllIlIIIlIllII = 0; llllllllllllIllIIIIllIlIIIlIllII < 7; ++llllllllllllIllIIIIllIlIIIlIllII) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllIllIIIIllIlIIIllIllI, llllllllllllIllIIIIllIlIIIlIllII, 4, llllllllllllIllIIIIllIlIIIlIllIl, llllllllllllIllIIIIllIlIIIlIlIII);
                    this.replaceAirAndLiquidDownwards(llllllllllllIllIIIIllIlIIIllIllI, Blocks.DIRT.getDefaultState(), llllllllllllIllIIIIllIlIIIlIllII, -1, llllllllllllIllIIIIllIlIIIlIllIl, llllllllllllIllIIIIllIlIIIlIlIII);
                }
            }
            return true;
        }
        
        public Field2() {
        }
        
        private Block getRandomCropType(final Random llllllllllllIllIIIIllIlIIlIlllIl) {
            switch (llllllllllllIllIIIIllIlIIlIlllIl.nextInt(10)) {
                case 0:
                case 1: {
                    return Blocks.CARROTS;
                }
                case 2:
                case 3: {
                    return Blocks.POTATOES;
                }
                case 4: {
                    return Blocks.BEETROOTS;
                }
                default: {
                    return Blocks.WHEAT;
                }
            }
        }
        
        public static Field2 createPiece(final Start llllllllllllIllIIIIllIlIIlIIlIlI, final List<StructureComponent> llllllllllllIllIIIIllIlIIlIIlIIl, final Random llllllllllllIllIIIIllIlIIlIIlIII, final int llllllllllllIllIIIIllIlIIlIlIIII, final int llllllllllllIllIIIIllIlIIlIIIllI, final int llllllllllllIllIIIIllIlIIlIIIlIl, final EnumFacing llllllllllllIllIIIIllIlIIlIIIlII, final int llllllllllllIllIIIIllIlIIlIIIIll) {
            final StructureBoundingBox llllllllllllIllIIIIllIlIIlIIlIll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllIllIIIIllIlIIlIlIIII, llllllllllllIllIIIIllIlIIlIIIllI, llllllllllllIllIIIIllIlIIlIIIlIl, 0, 0, 0, 7, 4, 9, llllllllllllIllIIIIllIlIIlIIIlII);
            return (Village.canVillageGoDeeper(llllllllllllIllIIIIllIlIIlIIlIll) && StructureComponent.findIntersecting(llllllllllllIllIIIIllIlIIlIIlIIl, llllllllllllIllIIIIllIlIIlIIlIll) == null) ? new Field2(llllllllllllIllIIIIllIlIIlIIlIlI, llllllllllllIllIIIIllIlIIlIIIIll, llllllllllllIllIIIIllIlIIlIIlIII, llllllllllllIllIIIIllIlIIlIIlIll, llllllllllllIllIIIIllIlIIlIIIlII) : null;
        }
        
        public Field2(final Start llllllllllllIllIIIIllIlIIllllIlI, final int llllllllllllIllIIIIllIlIIlllIIll, final Random llllllllllllIllIIIIllIlIIllllIII, final StructureBoundingBox llllllllllllIllIIIIllIlIIlllIlll, final EnumFacing llllllllllllIllIIIIllIlIIlllIIII) {
            super(llllllllllllIllIIIIllIlIIllllIlI, llllllllllllIllIIIIllIlIIlllIIll);
            this.setCoordBaseMode(llllllllllllIllIIIIllIlIIlllIIII);
            this.boundingBox = llllllllllllIllIIIIllIlIIlllIlll;
            this.cropTypeA = this.getRandomCropType(llllllllllllIllIIIIllIlIIllllIII);
            this.cropTypeB = this.getRandomCropType(llllllllllllIllIIIIllIlIIllllIII);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIllIIIIllIlIIllIIlIl, final TemplateManager llllllllllllIllIIIIllIlIIllIIlII) {
            super.readStructureFromNBT(llllllllllllIllIIIIllIlIIllIIlIl, llllllllllllIllIIIIllIlIIllIIlII);
            this.cropTypeA = Block.getBlockById(llllllllllllIllIIIIllIlIIllIIlIl.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(llllllllllllIllIIIIllIlIIllIIlIl.getInteger("CB"));
        }
    }
    
    public static class House2 extends Village
    {
        private /* synthetic */ boolean hasMadeChest;
        
        public House2() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIllIlIlIlIIlIIIIllII, final TemplateManager lllllllllllIIllIlIlIlIIlIIIIlIll) {
            super.readStructureFromNBT(lllllllllllIIllIlIlIlIIlIIIIllII, lllllllllllIIllIlIlIlIIlIIIIlIll);
            this.hasMadeChest = lllllllllllIIllIlIlIlIIlIIIIllII.getBoolean("Chest");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllIlIlIlIIIlllllIIl, final Random lllllllllllIIllIlIlIlIIIlllIlIlI, final StructureBoundingBox lllllllllllIIllIlIlIlIIIllllIlll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState lllllllllllIIllIlIlIlIIIllllIllI = Blocks.COBBLESTONE.getDefaultState();
            final IBlockState lllllllllllIIllIlIlIlIIIllllIlIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIllIlIlIlIIIllllIlII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllIIllIlIlIlIIIllllIIll = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllIIllIlIlIlIIIllllIIlI = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllIIllIlIlIlIIIllllIIIl = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllIIllIlIlIlIIIllllIIII = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 1, 0, 9, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 0, 0, 9, 0, 6, lllllllllllIIllIlIlIlIIIllllIllI, lllllllllllIIllIlIlIlIIIllllIllI, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 4, 0, 9, 4, 6, lllllllllllIIllIlIlIlIIIllllIllI, lllllllllllIIllIlIlIlIIIllllIllI, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 5, 0, 9, 5, 6, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 1, 5, 1, 8, 5, 5, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 1, 1, 0, 2, 3, 0, lllllllllllIIllIlIlIlIIIllllIIll, lllllllllllIIllIlIlIlIIIllllIIll, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 1, 0, 0, 4, 0, lllllllllllIIllIlIlIlIIIllllIIIl, lllllllllllIIllIlIlIlIIIllllIIIl, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 3, 1, 0, 3, 4, 0, lllllllllllIIllIlIlIlIIIllllIIIl, lllllllllllIIllIlIlIlIIIllllIIIl, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 1, 6, 0, 4, 6, lllllllllllIIllIlIlIlIIIllllIIIl, lllllllllllIIllIlIlIlIIIllllIIIl, false);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIIll, 3, 3, 1, lllllllllllIIllIlIlIlIIIllllIlll);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 3, 1, 2, 3, 3, 2, lllllllllllIIllIlIlIlIIIllllIIll, lllllllllllIIllIlIlIlIIIllllIIll, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 4, 1, 3, 5, 3, 3, lllllllllllIIllIlIlIlIIIllllIIll, lllllllllllIIllIlIlIlIIIllllIIll, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 0, 1, 1, 0, 3, 5, lllllllllllIIllIlIlIlIIIllllIIll, lllllllllllIIllIlIlIlIIIllllIIll, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 1, 1, 6, 5, 3, 6, lllllllllllIIllIlIlIlIIIllllIIll, lllllllllllIIllIlIlIlIIIllllIIll, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 5, 1, 0, 5, 3, 0, lllllllllllIIllIlIlIlIIIllllIIII, lllllllllllIIllIlIlIlIIIllllIIII, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 9, 1, 0, 9, 3, 0, lllllllllllIIllIlIlIlIIIllllIIII, lllllllllllIIllIlIlIlIIIllllIIII, false);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 6, 1, 4, 9, 4, 6, lllllllllllIIllIlIlIlIIIllllIllI, lllllllllllIIllIlIlIlIIIllllIllI, false);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.FLOWING_LAVA.getDefaultState(), 7, 1, 5, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.FLOWING_LAVA.getDefaultState(), 8, 1, 5, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), 9, 2, 5, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), 9, 2, 4, lllllllllllIIllIlIlIlIIIllllIlll);
            this.fillWithBlocks(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 7, 2, 4, 8, 2, 5, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIllI, 6, 1, 3, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.FURNACE.getDefaultState(), 6, 2, 3, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.FURNACE.getDefaultState(), 6, 3, 3, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 8, 1, 1, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 4, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 6, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 6, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIIII, 2, 1, 4, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 2, 2, 4, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIIll, 1, 1, 5, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlIl, 2, 1, 5, lllllllllllIIllIlIlIlIIIllllIlll);
            this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlII, 1, 1, 4, lllllllllllIIllIlIlIlIIIllllIlll);
            if (!this.hasMadeChest && lllllllllllIIllIlIlIlIIIllllIlll.isVecInside(new BlockPos(this.getXWithOffset(5, 5), this.getYWithOffset(1), this.getZWithOffset(5, 5)))) {
                this.hasMadeChest = true;
                this.generateChest(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, lllllllllllIIllIlIlIlIIIlllIlIlI, 5, 1, 5, LootTableList.CHESTS_VILLAGE_BLACKSMITH);
            }
            for (int lllllllllllIIllIlIlIlIIIlllIllll = 6; lllllllllllIIllIlIlIlIIIlllIllll <= 8; ++lllllllllllIIllIlIlIlIIIlllIllll) {
                if (this.getBlockStateFromPos(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIlllIllll, 0, -1, lllllllllllIIllIlIlIlIIIllllIlll).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIlllIllll, -1, -1, lllllllllllIIllIlIlIlIIIllllIlll).getMaterial() != Material.AIR) {
                    this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIIlI, lllllllllllIIllIlIlIlIIIlllIllll, 0, -1, lllllllllllIIllIlIlIlIIIllllIlll);
                    if (this.getBlockStateFromPos(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIlllIllll, -1, -1, lllllllllllIIllIlIlIlIIIllllIlll).getBlock() == Blocks.GRASS_PATH) {
                        this.setBlockState(lllllllllllIIllIlIlIlIIIlllllIIl, Blocks.GRASS.getDefaultState(), lllllllllllIIllIlIlIlIIIlllIllll, -1, -1, lllllllllllIIllIlIlIlIIIllllIlll);
                    }
                }
            }
            for (int lllllllllllIIllIlIlIlIIIlllIlllI = 0; lllllllllllIIllIlIlIlIIIlllIlllI < 7; ++lllllllllllIIllIlIlIlIIIlllIlllI) {
                for (int lllllllllllIIllIlIlIlIIIlllIllIl = 0; lllllllllllIIllIlIlIlIIIlllIllIl < 10; ++lllllllllllIIllIlIlIlIIIlllIllIl) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIlllIllIl, 6, lllllllllllIIllIlIlIlIIIlllIlllI, lllllllllllIIllIlIlIlIIIllllIlll);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIllI, lllllllllllIIllIlIlIlIIIlllIllIl, -1, lllllllllllIIllIlIlIlIIIlllIlllI, lllllllllllIIllIlIlIlIIIllllIlll);
                }
            }
            this.spawnVillagers(lllllllllllIIllIlIlIlIIIlllllIIl, lllllllllllIIllIlIlIlIIIllllIlll, 7, 1, 1, 1);
            return true;
        }
        
        public House2(final Start lllllllllllIIllIlIlIlIIlIIlllIll, final int lllllllllllIIllIlIlIlIIlIIllIlII, final Random lllllllllllIIllIlIlIlIIlIIlllIIl, final StructureBoundingBox lllllllllllIIllIlIlIlIIlIIllIIll, final EnumFacing lllllllllllIIllIlIlIlIIlIIllIIlI) {
            super(lllllllllllIIllIlIlIlIIlIIlllIll, lllllllllllIIllIlIlIlIIlIIllIlII);
            this.setCoordBaseMode(lllllllllllIIllIlIlIlIIlIIllIIlI);
            this.boundingBox = lllllllllllIIllIlIlIlIIlIIllIIll;
        }
        
        @Override
        protected int chooseProfession(final int lllllllllllIIllIlIlIlIIIllIllllI, final int lllllllllllIIllIlIlIlIIIllIlllIl) {
            return 3;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIllIlIlIlIIlIIIlIIll) {
            super.writeStructureToNBT(lllllllllllIIllIlIlIlIIlIIIlIIll);
            lllllllllllIIllIlIlIlIIlIIIlIIll.setBoolean("Chest", this.hasMadeChest);
        }
        
        public static House2 createPiece(final Start lllllllllllIIllIlIlIlIIlIIIlllll, final List<StructureComponent> lllllllllllIIllIlIlIlIIlIIlIIlll, final Random lllllllllllIIllIlIlIlIIlIIIlllIl, final int lllllllllllIIllIlIlIlIIlIIIlllII, final int lllllllllllIIllIlIlIlIIlIIIllIll, final int lllllllllllIIllIlIlIlIIlIIlIIIll, final EnumFacing lllllllllllIIllIlIlIlIIlIIIllIIl, final int lllllllllllIIllIlIlIlIIlIIIllIII) {
            final StructureBoundingBox lllllllllllIIllIlIlIlIIlIIlIIIII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllIlIlIlIIlIIIlllII, lllllllllllIIllIlIlIlIIlIIIllIll, lllllllllllIIllIlIlIlIIlIIlIIIll, 0, 0, 0, 10, 6, 7, lllllllllllIIllIlIlIlIIlIIIllIIl);
            return (Village.canVillageGoDeeper(lllllllllllIIllIlIlIlIIlIIlIIIII) && StructureComponent.findIntersecting(lllllllllllIIllIlIlIlIIlIIlIIlll, lllllllllllIIllIlIlIlIIlIIlIIIII) == null) ? new House2(lllllllllllIIllIlIlIlIIlIIIlllll, lllllllllllIIllIlIlIlIIlIIIllIII, lllllllllllIIllIlIlIlIIlIIIlllIl, lllllllllllIIllIlIlIlIIlIIlIIIII, lllllllllllIIllIlIlIlIIlIIIllIIl) : null;
        }
    }
    
    public static class Path extends Road
    {
        private /* synthetic */ int length;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        public Path() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIllllIIIlIlIIllIl, final Random lllllllllllIIlIIllllIIIlIlIIllII, final StructureBoundingBox lllllllllllIIlIIllllIIIlIlIIIIII) {
            final IBlockState lllllllllllIIlIIllllIIIlIlIIlIlI = this.getBiomeSpecificBlockState(Blocks.GRASS_PATH.getDefaultState());
            final IBlockState lllllllllllIIlIIllllIIIlIlIIlIIl = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllIIlIIllllIIIlIlIIlIII = this.getBiomeSpecificBlockState(Blocks.GRAVEL.getDefaultState());
            final IBlockState lllllllllllIIlIIllllIIIlIlIIIlll = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            for (int lllllllllllIIlIIllllIIIlIlIIIllI = this.boundingBox.minX; lllllllllllIIlIIllllIIIlIlIIIllI <= this.boundingBox.maxX; ++lllllllllllIIlIIllllIIIlIlIIIllI) {
                for (int lllllllllllIIlIIllllIIIlIlIIIlIl = this.boundingBox.minZ; lllllllllllIIlIIllllIIIlIlIIIlIl <= this.boundingBox.maxZ; ++lllllllllllIIlIIllllIIIlIlIIIlIl) {
                    BlockPos lllllllllllIIlIIllllIIIlIlIIIlII = new BlockPos(lllllllllllIIlIIllllIIIlIlIIIllI, 64, lllllllllllIIlIIllllIIIlIlIIIlIl);
                    if (lllllllllllIIlIIllllIIIlIlIIIIII.isVecInside(lllllllllllIIlIIllllIIIlIlIIIlII)) {
                        lllllllllllIIlIIllllIIIlIlIIIlII = lllllllllllIIlIIllllIIIlIlIIllIl.getTopSolidOrLiquidBlock(lllllllllllIIlIIllllIIIlIlIIIlII).down();
                        if (lllllllllllIIlIIllllIIIlIlIIIlII.getY() < lllllllllllIIlIIllllIIIlIlIIllIl.getSeaLevel()) {
                            lllllllllllIIlIIllllIIIlIlIIIlII = new BlockPos(lllllllllllIIlIIllllIIIlIlIIIlII.getX(), lllllllllllIIlIIllllIIIlIlIIllIl.getSeaLevel() - 1, lllllllllllIIlIIllllIIIlIlIIIlII.getZ());
                        }
                        while (lllllllllllIIlIIllllIIIlIlIIIlII.getY() >= lllllllllllIIlIIllllIIIlIlIIllIl.getSeaLevel() - 1) {
                            final IBlockState lllllllllllIIlIIllllIIIlIlIIIIll = lllllllllllIIlIIllllIIIlIlIIllIl.getBlockState(lllllllllllIIlIIllllIIIlIlIIIlII);
                            if (lllllllllllIIlIIllllIIIlIlIIIIll.getBlock() == Blocks.GRASS && lllllllllllIIlIIllllIIIlIlIIllIl.isAirBlock(lllllllllllIIlIIllllIIIlIlIIIlII.up())) {
                                lllllllllllIIlIIllllIIIlIlIIllIl.setBlockState(lllllllllllIIlIIllllIIIlIlIIIlII, lllllllllllIIlIIllllIIIlIlIIlIlI, 2);
                                break;
                            }
                            if (lllllllllllIIlIIllllIIIlIlIIIIll.getMaterial().isLiquid()) {
                                lllllllllllIIlIIllllIIIlIlIIllIl.setBlockState(lllllllllllIIlIIllllIIIlIlIIIlII, lllllllllllIIlIIllllIIIlIlIIlIIl, 2);
                                break;
                            }
                            if (lllllllllllIIlIIllllIIIlIlIIIIll.getBlock() == Blocks.SAND || lllllllllllIIlIIllllIIIlIlIIIIll.getBlock() == Blocks.SANDSTONE || lllllllllllIIlIIllllIIIlIlIIIIll.getBlock() == Blocks.RED_SANDSTONE) {
                                lllllllllllIIlIIllllIIIlIlIIllIl.setBlockState(lllllllllllIIlIIllllIIIlIlIIIlII, lllllllllllIIlIIllllIIIlIlIIlIII, 2);
                                lllllllllllIIlIIllllIIIlIlIIllIl.setBlockState(lllllllllllIIlIIllllIIIlIlIIIlII.down(), lllllllllllIIlIIllllIIIlIlIIIlll, 2);
                                break;
                            }
                            lllllllllllIIlIIllllIIIlIlIIIlII = lllllllllllIIlIIllllIIIlIlIIIlII.down();
                        }
                    }
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIlIIllllIIIllIIIllll, final TemplateManager lllllllllllIIlIIllllIIIllIIIlIll) {
            super.readStructureFromNBT(lllllllllllIIlIIllllIIIllIIIllll, lllllllllllIIlIIllllIIIllIIIlIll);
            this.length = lllllllllllIIlIIllllIIIllIIIllll.getInteger("Length");
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIlIIllllIIIllIIIIIlI, final List<StructureComponent> lllllllllllIIlIIllllIIIlIlllIlll, final Random lllllllllllIIlIIllllIIIlIlllIllI) {
            boolean lllllllllllIIlIIllllIIIlIlllllll = false;
            for (int lllllllllllIIlIIllllIIIlIllllllI = lllllllllllIIlIIllllIIIlIlllIllI.nextInt(5); lllllllllllIIlIIllllIIIlIllllllI < this.length - 8; lllllllllllIIlIIllllIIIlIllllllI += 2 + lllllllllllIIlIIllllIIIlIlllIllI.nextInt(5)) {
                final StructureComponent lllllllllllIIlIIllllIIIlIlllllIl = this.getNextComponentNN((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, 0, lllllllllllIIlIIllllIIIlIllllllI);
                if (lllllllllllIIlIIllllIIIlIlllllIl != null) {
                    lllllllllllIIlIIllllIIIlIllllllI += Math.max(lllllllllllIIlIIllllIIIlIlllllIl.boundingBox.getXSize(), lllllllllllIIlIIllllIIIlIlllllIl.boundingBox.getZSize());
                    lllllllllllIIlIIllllIIIlIlllllll = true;
                }
            }
            for (int lllllllllllIIlIIllllIIIlIlllllII = lllllllllllIIlIIllllIIIlIlllIllI.nextInt(5); lllllllllllIIlIIllllIIIlIlllllII < this.length - 8; lllllllllllIIlIIllllIIIlIlllllII += 2 + lllllllllllIIlIIllllIIIlIlllIllI.nextInt(5)) {
                final StructureComponent lllllllllllIIlIIllllIIIlIllllIll = this.getNextComponentPP((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, 0, lllllllllllIIlIIllllIIIlIlllllII);
                if (lllllllllllIIlIIllllIIIlIllllIll != null) {
                    lllllllllllIIlIIllllIIIlIlllllII += Math.max(lllllllllllIIlIIllllIIIlIllllIll.boundingBox.getXSize(), lllllllllllIIlIIllllIIIlIllllIll.boundingBox.getZSize());
                    lllllllllllIIlIIllllIIIlIlllllll = true;
                }
            }
            final EnumFacing lllllllllllIIlIIllllIIIlIllllIlI = this.getCoordBaseMode();
            if (lllllllllllIIlIIllllIIIlIlllllll && lllllllllllIIlIIllllIIIlIlllIllI.nextInt(3) > 0 && lllllllllllIIlIIllllIIIlIllllIlI != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIllllIIIlIllllIlI.ordinal()]) {
                    default: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 4: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 5: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                    case 6: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                }
            }
            if (lllllllllllIIlIIllllIIIlIlllllll && lllllllllllIIlIIllllIIIlIlllIllI.nextInt(3) > 0 && lllllllllllIIlIIllllIIIlIllllIlI != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIllllIIIlIllllIlI.ordinal()]) {
                    default: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 4: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 5: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                    case 6: {
                        generateAndAddRoadPiece((Start)lllllllllllIIlIIllllIIIllIIIIIlI, lllllllllllIIlIIllllIIIlIlllIlll, lllllllllllIIlIIllllIIIlIlllIllI, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                }
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Path.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final byte lllllllllllIIlIIllllIIIlIIllIllI = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllIIlIIllllIIIlIIllIllI[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Path.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIIlIIllllIIIlIIllIllI;
        }
        
        public Path(final Start lllllllllllIIlIIllllIIIllIlIIIll, final int lllllllllllIIlIIllllIIIllIIlllII, final Random lllllllllllIIlIIllllIIIllIlIIIIl, final StructureBoundingBox lllllllllllIIlIIllllIIIllIIllIll, final EnumFacing lllllllllllIIlIIllllIIIllIIllIlI) {
            super(lllllllllllIIlIIllllIIIllIlIIIll, lllllllllllIIlIIllllIIIllIIlllII);
            this.setCoordBaseMode(lllllllllllIIlIIllllIIIllIIllIlI);
            this.boundingBox = lllllllllllIIlIIllllIIIllIIllIll;
            this.length = Math.max(lllllllllllIIlIIllllIIIllIIllIll.getXSize(), lllllllllllIIlIIllllIIIllIIllIll.getZSize());
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIlIIllllIIIllIIlIllI) {
            super.writeStructureToNBT(lllllllllllIIlIIllllIIIllIIlIllI);
            lllllllllllIIlIIllllIIIllIIlIllI.setInteger("Length", this.length);
        }
        
        public static StructureBoundingBox findPieceBox(final Start lllllllllllIIlIIllllIIIlIllIlIlI, final List<StructureComponent> lllllllllllIIlIIllllIIIlIllIIIIl, final Random lllllllllllIIlIIllllIIIlIllIIIII, final int lllllllllllIIlIIllllIIIlIllIIlll, final int lllllllllllIIlIIllllIIIlIllIIllI, final int lllllllllllIIlIIllllIIIlIllIIlIl, final EnumFacing lllllllllllIIlIIllllIIIlIlIlllII) {
            for (int lllllllllllIIlIIllllIIIlIllIIIll = 7 * MathHelper.getInt(lllllllllllIIlIIllllIIIlIllIIIII, 3, 5); lllllllllllIIlIIllllIIIlIllIIIll >= 7; lllllllllllIIlIIllllIIIlIllIIIll -= 7) {
                final StructureBoundingBox lllllllllllIIlIIllllIIIlIllIIIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIllllIIIlIllIIlll, lllllllllllIIlIIllllIIIlIllIIllI, lllllllllllIIlIIllllIIIlIllIIlIl, 0, 0, 0, 3, 3, lllllllllllIIlIIllllIIIlIllIIIll, lllllllllllIIlIIllllIIIlIlIlllII);
                if (StructureComponent.findIntersecting(lllllllllllIIlIIllllIIIlIllIIIIl, lllllllllllIIlIIllllIIIlIllIIIlI) == null) {
                    return lllllllllllIIlIIllllIIIlIllIIIlI;
                }
            }
            return null;
        }
    }
}
