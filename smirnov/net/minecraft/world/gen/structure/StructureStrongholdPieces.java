// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.block.BlockLadder;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockDoor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import com.google.common.collect.Lists;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import java.util.List;

public class StructureStrongholdPieces
{
    private static final /* synthetic */ PieceWeight[] PIECE_WEIGHTS;
    private static /* synthetic */ List<PieceWeight> structurePieceList;
    static /* synthetic */ int totalWeight;
    private static final /* synthetic */ Stones STRONGHOLD_STONES;
    private static /* synthetic */ Class<? extends Stronghold> strongComponentType;
    
    static /* synthetic */ void access$2(final Class lllllllllllIlllIlIIIIllIlIIlllll) {
        StructureStrongholdPieces.strongComponentType = (Class<? extends Stronghold>)lllllllllllIlllIlIIIIllIlIIlllll;
    }
    
    static {
        PIECE_WEIGHTS = new PieceWeight[] { new PieceWeight(Straight.class, 40, 0), new PieceWeight(Prison.class, 5, 5), new PieceWeight(LeftTurn.class, 20, 0), new PieceWeight(RightTurn.class, 20, 0), new PieceWeight(RoomCrossing.class, 10, 6), new PieceWeight(StairsStraight.class, 5, 5), new PieceWeight(Stairs.class, 5, 5), new PieceWeight(Crossing.class, 5, 4), new PieceWeight(ChestCorridor.class, 5, 4), new PieceWeight(10, 2) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int lllllllllllIllllllllllIlllllllIl) {
                    return super.canSpawnMoreStructuresOfType(lllllllllllIllllllllllIlllllllIl) && lllllllllllIllllllllllIlllllllIl > 4;
                }
            }, new PieceWeight(20, 1) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int llllllllllIlllIIlIlIIIlIIlIIIIlI) {
                    return super.canSpawnMoreStructuresOfType(llllllllllIlllIIlIlIIIlIIlIIIIlI) && llllllllllIlllIIlIlIIIlIIlIIIIlI > 5;
                }
            } };
        STRONGHOLD_STONES = new Stones(null);
    }
    
    public static void registerStrongholdPieces() {
        MapGenStructureIO.registerStructureComponent(ChestCorridor.class, "SHCC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "SHFC");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "SH5C");
        MapGenStructureIO.registerStructureComponent(LeftTurn.class, "SHLT");
        MapGenStructureIO.registerStructureComponent(Library.class, "SHLi");
        MapGenStructureIO.registerStructureComponent(PortalRoom.class, "SHPR");
        MapGenStructureIO.registerStructureComponent(Prison.class, "SHPH");
        MapGenStructureIO.registerStructureComponent(RightTurn.class, "SHRT");
        MapGenStructureIO.registerStructureComponent(RoomCrossing.class, "SHRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "SHSD");
        MapGenStructureIO.registerStructureComponent(Stairs2.class, "SHStart");
        MapGenStructureIO.registerStructureComponent(Straight.class, "SHS");
        MapGenStructureIO.registerStructureComponent(StairsStraight.class, "SHSSD");
    }
    
    private static boolean canAddStructurePieces() {
        boolean lllllllllllIlllIlIIIIlllIIIIIIll = false;
        StructureStrongholdPieces.totalWeight = 0;
        for (final PieceWeight lllllllllllIlllIlIIIIlllIIIIIIlI : StructureStrongholdPieces.structurePieceList) {
            if (lllllllllllIlllIlIIIIlllIIIIIIlI.instancesLimit > 0 && lllllllllllIlllIlIIIIlllIIIIIIlI.instancesSpawned < lllllllllllIlllIlIIIIlllIIIIIIlI.instancesLimit) {
                lllllllllllIlllIlIIIIlllIIIIIIll = true;
            }
            StructureStrongholdPieces.totalWeight += lllllllllllIlllIlIIIIlllIIIIIIlI.pieceWeight;
        }
        return lllllllllllIlllIlIIIIlllIIIIIIll;
    }
    
    private static Stronghold generatePieceFromSmallDoor(final Stairs2 lllllllllllIlllIlIIIIllIllIIlIII, final List<StructureComponent> lllllllllllIlllIlIIIIllIllIIIlll, final Random lllllllllllIlllIlIIIIllIllIlIlII, final int lllllllllllIlllIlIIIIllIllIIIlIl, final int lllllllllllIlllIlIIIIllIllIIIlII, final int lllllllllllIlllIlIIIIllIllIlIIIl, final EnumFacing lllllllllllIlllIlIIIIllIllIlIIII, final int lllllllllllIlllIlIIIIllIllIIIIIl) {
        if (!canAddStructurePieces()) {
            return null;
        }
        if (StructureStrongholdPieces.strongComponentType != null) {
            final Stronghold lllllllllllIlllIlIIIIllIllIIlllI = findAndCreatePieceFactory(StructureStrongholdPieces.strongComponentType, lllllllllllIlllIlIIIIllIllIIIlll, lllllllllllIlllIlIIIIllIllIlIlII, lllllllllllIlllIlIIIIllIllIIIlIl, lllllllllllIlllIlIIIIllIllIIIlII, lllllllllllIlllIlIIIIllIllIlIIIl, lllllllllllIlllIlIIIIllIllIlIIII, lllllllllllIlllIlIIIIllIllIIIIIl);
            StructureStrongholdPieces.strongComponentType = null;
            if (lllllllllllIlllIlIIIIllIllIIlllI != null) {
                return lllllllllllIlllIlIIIIllIllIIlllI;
            }
        }
        int lllllllllllIlllIlIIIIllIllIIllIl = 0;
        while (lllllllllllIlllIlIIIIllIllIIllIl < 5) {
            ++lllllllllllIlllIlIIIIllIllIIllIl;
            int lllllllllllIlllIlIIIIllIllIIllII = lllllllllllIlllIlIIIIllIllIlIlII.nextInt(StructureStrongholdPieces.totalWeight);
            for (final PieceWeight lllllllllllIlllIlIIIIllIllIIlIll : StructureStrongholdPieces.structurePieceList) {
                lllllllllllIlllIlIIIIllIllIIllII -= lllllllllllIlllIlIIIIllIllIIlIll.pieceWeight;
                if (lllllllllllIlllIlIIIIllIllIIllII < 0) {
                    if (!lllllllllllIlllIlIIIIllIllIIlIll.canSpawnMoreStructuresOfType(lllllllllllIlllIlIIIIllIllIIIIIl)) {
                        break;
                    }
                    if (lllllllllllIlllIlIIIIllIllIIlIll == lllllllllllIlllIlIIIIllIllIIlIII.strongholdPieceWeight) {
                        break;
                    }
                    final Stronghold lllllllllllIlllIlIIIIllIllIIlIlI = findAndCreatePieceFactory(lllllllllllIlllIlIIIIllIllIIlIll.pieceClass, lllllllllllIlllIlIIIIllIllIIIlll, lllllllllllIlllIlIIIIllIllIlIlII, lllllllllllIlllIlIIIIllIllIIIlIl, lllllllllllIlllIlIIIIllIllIIIlII, lllllllllllIlllIlIIIIllIllIlIIIl, lllllllllllIlllIlIIIIllIllIlIIII, lllllllllllIlllIlIIIIllIllIIIIIl);
                    if (lllllllllllIlllIlIIIIllIllIIlIlI != null) {
                        final PieceWeight pieceWeight = lllllllllllIlllIlIIIIllIllIIlIll;
                        ++pieceWeight.instancesSpawned;
                        lllllllllllIlllIlIIIIllIllIIlIII.strongholdPieceWeight = lllllllllllIlllIlIIIIllIllIIlIll;
                        if (!lllllllllllIlllIlIIIIllIllIIlIll.canSpawnMoreStructures()) {
                            StructureStrongholdPieces.structurePieceList.remove(lllllllllllIlllIlIIIIllIllIIlIll);
                        }
                        return lllllllllllIlllIlIIIIllIllIIlIlI;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox lllllllllllIlllIlIIIIllIllIIlIIl = Corridor.findPieceBox(lllllllllllIlllIlIIIIllIllIIIlll, lllllllllllIlllIlIIIIllIllIlIlII, lllllllllllIlllIlIIIIllIllIIIlIl, lllllllllllIlllIlIIIIllIllIIIlII, lllllllllllIlllIlIIIIllIllIlIIIl, lllllllllllIlllIlIIIIllIllIlIIII);
        if (lllllllllllIlllIlIIIIllIllIIlIIl != null && lllllllllllIlllIlIIIIllIllIIlIIl.minY > 1) {
            return new Corridor(lllllllllllIlllIlIIIIllIllIIIIIl, lllllllllllIlllIlIIIIllIllIlIlII, lllllllllllIlllIlIIIIllIllIIlIIl, lllllllllllIlllIlIIIIllIllIlIIII);
        }
        return null;
    }
    
    public static void prepareStructurePieces() {
        StructureStrongholdPieces.structurePieceList = (List<PieceWeight>)Lists.newArrayList();
        final byte lllllllllllIlllIlIIIIlllIIIIIlll;
        final int lllllllllllIlllIlIIIIlllIIIIlIII = ((PieceWeight[])(Object)(lllllllllllIlllIlIIIIlllIIIIIlll = (byte)(Object)StructureStrongholdPieces.PIECE_WEIGHTS)).length;
        for (short lllllllllllIlllIlIIIIlllIIIIlIIl = 0; lllllllllllIlllIlIIIIlllIIIIlIIl < lllllllllllIlllIlIIIIlllIIIIlIII; ++lllllllllllIlllIlIIIIlllIIIIlIIl) {
            final PieceWeight lllllllllllIlllIlIIIIlllIIIIlIll = lllllllllllIlllIlIIIIlllIIIIIlll[lllllllllllIlllIlIIIIlllIIIIlIIl];
            lllllllllllIlllIlIIIIlllIIIIlIll.instancesSpawned = 0;
            StructureStrongholdPieces.structurePieceList.add(lllllllllllIlllIlIIIIlllIIIIlIll);
        }
        StructureStrongholdPieces.strongComponentType = null;
    }
    
    private static Stronghold findAndCreatePieceFactory(final Class<? extends Stronghold> lllllllllllIlllIlIIIIllIlllIllII, final List<StructureComponent> lllllllllllIlllIlIIIIllIllllIlII, final Random lllllllllllIlllIlIIIIllIlllIlIlI, final int lllllllllllIlllIlIIIIllIllllIIlI, final int lllllllllllIlllIlIIIIllIllllIIIl, final int lllllllllllIlllIlIIIIllIllllIIII, @Nullable final EnumFacing lllllllllllIlllIlIIIIllIlllIllll, final int lllllllllllIlllIlIIIIllIlllIIlIl) {
        Stronghold lllllllllllIlllIlIIIIllIlllIllIl = null;
        if (lllllllllllIlllIlIIIIllIlllIllII == Straight.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = Straight.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == Prison.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = Prison.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == LeftTurn.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = LeftTurn.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == RightTurn.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = LeftTurn.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == RoomCrossing.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = RoomCrossing.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == StairsStraight.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = StairsStraight.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == Stairs.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = Stairs.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == Crossing.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = Crossing.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == ChestCorridor.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = ChestCorridor.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == Library.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = Library.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        else if (lllllllllllIlllIlIIIIllIlllIllII == PortalRoom.class) {
            lllllllllllIlllIlIIIIllIlllIllIl = PortalRoom.createPiece(lllllllllllIlllIlIIIIllIllllIlII, lllllllllllIlllIlIIIIllIlllIlIlI, lllllllllllIlllIlIIIIllIllllIIlI, lllllllllllIlllIlIIIIllIllllIIIl, lllllllllllIlllIlIIIIllIllllIIII, lllllllllllIlllIlIIIIllIlllIllll, lllllllllllIlllIlIIIIllIlllIIlIl);
        }
        return lllllllllllIlllIlIIIIllIlllIllIl;
    }
    
    private static StructureComponent generateAndAddPiece(final Stairs2 lllllllllllIlllIlIIIIllIlIllIIlI, final List<StructureComponent> lllllllllllIlllIlIIIIllIlIlIlIII, final Random lllllllllllIlllIlIIIIllIlIllIIII, final int lllllllllllIlllIlIIIIllIlIlIllll, final int lllllllllllIlllIlIIIIllIlIlIlllI, final int lllllllllllIlllIlIIIIllIlIlIllIl, @Nullable final EnumFacing lllllllllllIlllIlIIIIllIlIlIllII, final int lllllllllllIlllIlIIIIllIlIlIIIlI) {
        if (lllllllllllIlllIlIIIIllIlIlIIIlI > 50) {
            return null;
        }
        if (Math.abs(lllllllllllIlllIlIIIIllIlIlIllll - lllllllllllIlllIlIIIIllIlIllIIlI.getBoundingBox().minX) <= 112 && Math.abs(lllllllllllIlllIlIIIIllIlIlIllIl - lllllllllllIlllIlIIIIllIlIllIIlI.getBoundingBox().minZ) <= 112) {
            final StructureComponent lllllllllllIlllIlIIIIllIlIlIlIlI = generatePieceFromSmallDoor(lllllllllllIlllIlIIIIllIlIllIIlI, lllllllllllIlllIlIIIIllIlIlIlIII, lllllllllllIlllIlIIIIllIlIllIIII, lllllllllllIlllIlIIIIllIlIlIllll, lllllllllllIlllIlIIIIllIlIlIlllI, lllllllllllIlllIlIIIIllIlIlIllIl, lllllllllllIlllIlIIIIllIlIlIllII, lllllllllllIlllIlIIIIllIlIlIIIlI + 1);
            if (lllllllllllIlllIlIIIIllIlIlIlIlI != null) {
                lllllllllllIlllIlIIIIllIlIlIlIII.add(lllllllllllIlllIlIIIIllIlIlIlIlI);
                lllllllllllIlllIlIIIIllIlIllIIlI.pendingChildren.add(lllllllllllIlllIlIIIIllIlIlIlIlI);
            }
            return lllllllllllIlllIlIIIIllIlIlIlIlI;
        }
        return null;
    }
    
    public static class Stairs extends Stronghold
    {
        private /* synthetic */ boolean source;
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIllIllIIIlIlIlllllll, final List<StructureComponent> lllllllllllIIllIllIIIlIlIllllllI, final Random lllllllllllIIllIllIIIlIlIllllIIl) {
            if (this.source) {
                StructureStrongholdPieces.access$2(Crossing.class);
            }
            this.getNextComponentNormal((Stairs2)lllllllllllIIllIllIIIlIlIlllllll, lllllllllllIIllIllIIIlIlIllllllI, lllllllllllIIllIllIIIlIlIllllIIl, 1, 1);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIllIllIIIlIllIIIlllI) {
            super.writeStructureToNBT(lllllllllllIIllIllIIIlIllIIIlllI);
            lllllllllllIIllIllIIIlIllIIIlllI.setBoolean("Source", this.source);
        }
        
        public Stairs(final int lllllllllllIIllIllIIIlIllIlIlIll, final Random lllllllllllIIllIllIIIlIllIlIIlIl, final int lllllllllllIIllIllIIIlIllIlIlIIl, final int lllllllllllIIllIllIIIlIllIlIlIII) {
            super(lllllllllllIIllIllIIIlIllIlIlIll);
            this.source = true;
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIllIllIIIlIllIlIIlIl));
            this.entryDoor = Door.OPENING;
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllIIllIllIIIlIllIlIlIIl, 64, lllllllllllIIllIllIIIlIllIlIlIII, lllllllllllIIllIllIIIlIllIlIlIIl + 5 - 1, 74, lllllllllllIIllIllIIIlIllIlIlIII + 5 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllIIllIllIIIlIllIlIlIIl, 64, lllllllllllIIllIllIIIlIllIlIlIII, lllllllllllIIllIllIIIlIllIlIlIIl + 5 - 1, 74, lllllllllllIIllIllIIIlIllIlIlIII + 5 - 1);
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIllIllIIIlIllIIIlIIl, final TemplateManager lllllllllllIIllIllIIIlIllIIIIlIl) {
            super.readStructureFromNBT(lllllllllllIIllIllIIIlIllIIIlIIl, lllllllllllIIllIllIIIlIllIIIIlIl);
            this.source = lllllllllllIIllIllIIIlIllIIIlIIl.getBoolean("Source");
        }
        
        public static Stairs createPiece(final List<StructureComponent> lllllllllllIIllIllIIIlIlIllIlIII, final Random lllllllllllIIllIllIIIlIlIllIllll, final int lllllllllllIIllIllIIIlIlIllIlllI, final int lllllllllllIIllIllIIIlIlIllIIlIl, final int lllllllllllIIllIllIIIlIlIllIIlII, final EnumFacing lllllllllllIIllIllIIIlIlIllIlIll, final int lllllllllllIIllIllIIIlIlIllIlIlI) {
            final StructureBoundingBox lllllllllllIIllIllIIIlIlIllIlIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllIllIIIlIlIllIlllI, lllllllllllIIllIllIIIlIlIllIIlIl, lllllllllllIIllIllIIIlIlIllIIlII, -1, -7, 0, 5, 11, 5, lllllllllllIIllIllIIIlIlIllIlIll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllIIllIllIIIlIlIllIlIIl) && StructureComponent.findIntersecting(lllllllllllIIllIllIIIlIlIllIlIII, lllllllllllIIllIllIIIlIlIllIlIIl) == null) ? new Stairs(lllllllllllIIllIllIIIlIlIllIlIlI, lllllllllllIIllIllIIIlIlIllIllll, lllllllllllIIllIllIIIlIlIllIlIIl, lllllllllllIIllIllIIIlIlIllIlIll) : null;
        }
        
        public Stairs(final int lllllllllllIIllIllIIIlIllIIlIlll, final Random lllllllllllIIllIllIIIlIllIIlIllI, final StructureBoundingBox lllllllllllIIllIllIIIlIllIIlIlIl, final EnumFacing lllllllllllIIllIllIIIlIllIIllIIl) {
            super(lllllllllllIIllIllIIIlIllIIlIlll);
            this.source = false;
            this.setCoordBaseMode(lllllllllllIIllIllIIIlIllIIllIIl);
            this.entryDoor = this.getRandomDoor(lllllllllllIIllIllIIIlIllIIlIllI);
            this.boundingBox = lllllllllllIIllIllIIIlIllIIlIlIl;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllIllIIIlIlIlIlIlll, final Random lllllllllllIIllIllIIIlIlIlIlIllI, final StructureBoundingBox lllllllllllIIllIllIIIlIlIlIllIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIIllIllIIIlIlIlIlIlll, lllllllllllIIllIllIIIlIlIlIllIIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllIIllIllIIIlIlIlIlIlll, lllllllllllIIllIllIIIlIlIlIllIIl, 0, 0, 0, 4, 10, 4, true, lllllllllllIIllIllIIIlIlIlIlIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllIIllIllIIIlIlIlIlIlll, lllllllllllIIllIllIIIlIlIlIlIllI, lllllllllllIIllIllIIIlIlIlIllIIl, this.entryDoor, 1, 7, 0);
            this.placeDoor(lllllllllllIIllIllIIIlIlIlIlIlll, lllllllllllIIllIllIIIlIlIlIlIllI, lllllllllllIIllIllIIIlIlIlIllIIl, Door.OPENING, 1, 1, 4);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 2, 6, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 1, 5, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 6, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 1, 5, 2, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 1, 4, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 5, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 2, 4, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 3, 3, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 4, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 3, 3, 2, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 3, 2, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 3, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 2, 2, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 1, 1, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 2, 1, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONEBRICK.getDefaultState(), 1, 1, 2, lllllllllllIIllIllIIIlIlIlIllIIl);
            this.setBlockState(lllllllllllIIllIllIIIlIlIlIlIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 1, 3, lllllllllllIIllIllIIIlIlIlIllIIl);
            return true;
        }
        
        public Stairs() {
        }
    }
    
    public static class Crossing extends Stronghold
    {
        private /* synthetic */ boolean rightHigh;
        private /* synthetic */ boolean leftHigh;
        private /* synthetic */ boolean rightLow;
        private /* synthetic */ boolean leftLow;
        
        public Crossing(final int llllllllllIlllIllIIIIIIIIIlIIlll, final Random llllllllllIlllIllIIIIIIIIIlIIllI, final StructureBoundingBox llllllllllIlllIllIIIIIIIIIlIIlIl, final EnumFacing llllllllllIlllIllIIIIIIIIIIlllll) {
            super(llllllllllIlllIllIIIIIIIIIlIIlll);
            this.setCoordBaseMode(llllllllllIlllIllIIIIIIIIIIlllll);
            this.entryDoor = this.getRandomDoor(llllllllllIlllIllIIIIIIIIIlIIllI);
            this.boundingBox = llllllllllIlllIllIIIIIIIIIlIIlIl;
            this.leftLow = llllllllllIlllIllIIIIIIIIIlIIllI.nextBoolean();
            this.leftHigh = llllllllllIlllIllIIIIIIIIIlIIllI.nextBoolean();
            this.rightLow = llllllllllIlllIllIIIIIIIIIlIIllI.nextBoolean();
            this.rightHigh = (llllllllllIlllIllIIIIIIIIIlIIllI.nextInt(3) > 0);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIlIlllllllllIlllIl, final Random llllllllllIlllIlIlllllllllIllIII, final StructureBoundingBox llllllllllIlllIlIlllllllllIllIll) {
            if (this.isLiquidInStructureBoundingBox(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 0, 0, 0, 9, 8, 10, true, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIII, llllllllllIlllIlIlllllllllIllIll, this.entryDoor, 4, 3, 0);
            if (this.leftLow) {
                this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 0, 3, 1, 0, 5, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.rightLow) {
                this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 9, 3, 1, 9, 5, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.leftHigh) {
                this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 0, 5, 7, 0, 7, 9, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.rightHigh) {
                this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 9, 5, 7, 9, 7, 9, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 5, 1, 10, 7, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 1, 2, 1, 8, 2, 6, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 4, 1, 5, 4, 4, 9, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 8, 1, 5, 8, 4, 9, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 1, 4, 7, 3, 4, 9, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 1, 3, 5, 3, 3, 6, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 1, 3, 4, 3, 3, 4, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 1, 4, 6, 3, 4, 6, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithRandomizedBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 5, 1, 7, 7, 1, 8, false, llllllllllIlllIlIlllllllllIllIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 5, 1, 9, 7, 1, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 5, 2, 7, 7, 2, 7, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 4, 5, 7, 4, 5, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 8, 5, 7, 8, 5, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIlIlllllllllIlllIl, llllllllllIlllIlIlllllllllIllIll, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), Blocks.DOUBLE_STONE_SLAB.getDefaultState(), false);
            this.setBlockState(llllllllllIlllIlIlllllllllIlllIl, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH), 6, 5, 6, llllllllllIlllIlIlllllllllIllIll);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllIlllIllIIIIIIIIIIlIlII, final TemplateManager llllllllllIlllIllIIIIIIIIIIlIIII) {
            super.readStructureFromNBT(llllllllllIlllIllIIIIIIIIIIlIlII, llllllllllIlllIllIIIIIIIIIIlIIII);
            this.leftLow = llllllllllIlllIllIIIIIIIIIIlIlII.getBoolean("leftLow");
            this.leftHigh = llllllllllIlllIllIIIIIIIIIIlIlII.getBoolean("leftHigh");
            this.rightLow = llllllllllIlllIllIIIIIIIIIIlIlII.getBoolean("rightLow");
            this.rightHigh = llllllllllIlllIllIIIIIIIIIIlIlII.getBoolean("rightHigh");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllIlllIllIIIIIIIIIIllIIl) {
            super.writeStructureToNBT(llllllllllIlllIllIIIIIIIIIIllIIl);
            llllllllllIlllIllIIIIIIIIIIllIIl.setBoolean("leftLow", this.leftLow);
            llllllllllIlllIllIIIIIIIIIIllIIl.setBoolean("leftHigh", this.leftHigh);
            llllllllllIlllIllIIIIIIIIIIllIIl.setBoolean("rightLow", this.rightLow);
            llllllllllIlllIllIIIIIIIIIIllIIl.setBoolean("rightHigh", this.rightHigh);
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllIlllIllIIIIIIIIIIIIlll, final List<StructureComponent> llllllllllIlllIlIlllllllllllllll, final Random llllllllllIlllIlIllllllllllllllI) {
            int llllllllllIlllIllIIIIIIIIIIIIlII = 3;
            int llllllllllIlllIllIIIIIIIIIIIIIll = 5;
            final EnumFacing llllllllllIlllIllIIIIIIIIIIIIIlI = this.getCoordBaseMode();
            if (llllllllllIlllIllIIIIIIIIIIIIIlI == EnumFacing.WEST || llllllllllIlllIllIIIIIIIIIIIIIlI == EnumFacing.NORTH) {
                llllllllllIlllIllIIIIIIIIIIIIlII = 8 - llllllllllIlllIllIIIIIIIIIIIIlII;
                llllllllllIlllIllIIIIIIIIIIIIIll = 8 - llllllllllIlllIllIIIIIIIIIIIIIll;
            }
            this.getNextComponentNormal((Stairs2)llllllllllIlllIllIIIIIIIIIIIIlll, llllllllllIlllIlIlllllllllllllll, llllllllllIlllIlIllllllllllllllI, 5, 1);
            if (this.leftLow) {
                this.getNextComponentX((Stairs2)llllllllllIlllIllIIIIIIIIIIIIlll, llllllllllIlllIlIlllllllllllllll, llllllllllIlllIlIllllllllllllllI, llllllllllIlllIllIIIIIIIIIIIIlII, 1);
            }
            if (this.leftHigh) {
                this.getNextComponentX((Stairs2)llllllllllIlllIllIIIIIIIIIIIIlll, llllllllllIlllIlIlllllllllllllll, llllllllllIlllIlIllllllllllllllI, llllllllllIlllIllIIIIIIIIIIIIIll, 7);
            }
            if (this.rightLow) {
                this.getNextComponentZ((Stairs2)llllllllllIlllIllIIIIIIIIIIIIlll, llllllllllIlllIlIlllllllllllllll, llllllllllIlllIlIllllllllllllllI, llllllllllIlllIllIIIIIIIIIIIIlII, 1);
            }
            if (this.rightHigh) {
                this.getNextComponentZ((Stairs2)llllllllllIlllIllIIIIIIIIIIIIlll, llllllllllIlllIlIlllllllllllllll, llllllllllIlllIlIllllllllllllllI, llllllllllIlllIllIIIIIIIIIIIIIll, 7);
            }
        }
        
        public static Crossing createPiece(final List<StructureComponent> llllllllllIlllIlIlllllllllllIIlI, final Random llllllllllIlllIlIllllllllllIlIIl, final int llllllllllIlllIlIllllllllllIlIII, final int llllllllllIlllIlIllllllllllIIlll, final int llllllllllIlllIlIllllllllllIIllI, final EnumFacing llllllllllIlllIlIllllllllllIIlIl, final int llllllllllIlllIlIllllllllllIIlII) {
            final StructureBoundingBox llllllllllIlllIlIllllllllllIlIll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllIlllIlIllllllllllIlIII, llllllllllIlllIlIllllllllllIIlll, llllllllllIlllIlIllllllllllIIllI, -4, -3, 0, 10, 9, 11, llllllllllIlllIlIllllllllllIIlIl);
            return (Stronghold.canStrongholdGoDeeper(llllllllllIlllIlIllllllllllIlIll) && StructureComponent.findIntersecting(llllllllllIlllIlIlllllllllllIIlI, llllllllllIlllIlIllllllllllIlIll) == null) ? new Crossing(llllllllllIlllIlIllllllllllIIlII, llllllllllIlllIlIllllllllllIlIIl, llllllllllIlllIlIllllllllllIlIll, llllllllllIlllIlIllllllllllIIlIl) : null;
        }
        
        public Crossing() {
        }
    }
    
    public static class Stairs2 extends Stairs
    {
        public /* synthetic */ PieceWeight strongholdPieceWeight;
        public /* synthetic */ List<StructureComponent> pendingChildren;
        public /* synthetic */ PortalRoom strongholdPortalRoom;
        
        public Stairs2(final int llllllllllllllIllllllIIllIlIlIll, final Random llllllllllllllIllllllIIllIlIlIlI, final int llllllllllllllIllllllIIllIlIlIIl, final int llllllllllllllIllllllIIllIlIlIII) {
            super(0, llllllllllllllIllllllIIllIlIlIlI, llllllllllllllIllllllIIllIlIlIIl, llllllllllllllIllllllIIllIlIlIII);
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Stairs2() {
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
    }
    
    public static class PortalRoom extends Stronghold
    {
        private /* synthetic */ boolean hasSpawner;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIllIlIIIIlIlIllllIll) {
            super.writeStructureToNBT(lllllllllllIIllIlIIIIlIlIllllIll);
            lllllllllllIIllIlIIIIlIlIllllIll.setBoolean("Mob", this.hasSpawner);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllIlIIIIlIlIlIIIIlI, final Random lllllllllllIIllIlIIIIlIlIlIIIIIl, final StructureBoundingBox lllllllllllIIllIlIIIIlIlIIlIllIl) {
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 0, 0, 0, 10, 7, 15, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIlIIIIIl, lllllllllllIIllIlIIIIlIlIIlIllIl, Door.GRATES, 4, 1, 0);
            int lllllllllllIIllIlIIIIlIlIIllllll = 6;
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 1, lllllllllllIIllIlIIIIlIlIIllllll, 1, 1, lllllllllllIIllIlIIIIlIlIIllllll, 14, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 9, lllllllllllIIllIlIIIIlIlIIllllll, 1, 9, lllllllllllIIllIlIIIIlIlIIllllll, 14, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 2, lllllllllllIIllIlIIIIlIlIIllllll, 1, 8, lllllllllllIIllIlIIIIlIlIIllllll, 2, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 2, lllllllllllIIllIlIIIIlIlIIllllll, 14, 8, lllllllllllIIllIlIIIIlIlIIllllll, 14, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 1, 1, 1, 2, 1, 4, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 8, 1, 1, 9, 1, 4, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 1, 1, 1, 1, 1, 3, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 9, 1, 1, 9, 1, 3, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 3, 1, 8, 7, 1, 12, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 4, 1, 9, 6, 1, 11, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            for (int lllllllllllIIllIlIIIIlIlIIlllllI = 3; lllllllllllIIllIlIIIIlIlIIlllllI < 14; lllllllllllIIllIlIIIIlIlIIlllllI += 2) {
                this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 0, 3, lllllllllllIIllIlIIIIlIlIIlllllI, 0, 4, lllllllllllIIllIlIIIIlIlIIlllllI, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 10, 3, lllllllllllIIllIlIIIIlIlIIlllllI, 10, 4, lllllllllllIIllIlIIIIlIlIIlllllI, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            }
            for (int lllllllllllIIllIlIIIIlIlIIllllIl = 2; lllllllllllIIllIlIIIIlIlIIllllIl < 9; lllllllllllIIllIlIIIIlIlIIllllIl += 2) {
                this.fillWithBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, lllllllllllIIllIlIIIIlIlIIllllIl, 3, 15, lllllllllllIIllIlIIIIlIlIIllllIl, 4, 15, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            }
            final IBlockState lllllllllllIIllIlIIIIlIlIIllllII = Blocks.STONE_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 4, 1, 5, 6, 1, 7, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 4, 2, 6, 6, 2, 7, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlIllIl, 4, 3, 7, 6, 3, 7, false, lllllllllllIIllIlIIIIlIlIlIIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            for (int lllllllllllIIllIlIIIIlIlIIlllIll = 4; lllllllllllIIllIlIIIIlIlIIlllIll <= 6; ++lllllllllllIIllIlIIIIlIlIIlllIll) {
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllllII, lllllllllllIIllIlIIIIlIlIIlllIll, 1, 4, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllllII, lllllllllllIIllIlIIIIlIlIIlllIll, 2, 5, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllllII, lllllllllllIIllIlIIIIlIlIIlllIll, 3, 6, lllllllllllIIllIlIIIIlIlIIlIllIl);
            }
            final IBlockState lllllllllllIIllIlIIIIlIlIIlllIlI = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.NORTH);
            final IBlockState lllllllllllIIllIlIIIIlIlIIlllIIl = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.SOUTH);
            final IBlockState lllllllllllIIllIlIIIIlIlIIlllIII = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllIIllIlIIIIlIlIIllIlll = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.WEST);
            boolean lllllllllllIIllIlIIIIlIlIIllIllI = true;
            final boolean[] lllllllllllIIllIlIIIIlIlIIllIlIl = new boolean[12];
            for (int lllllllllllIIllIlIIIIlIlIIllIlII = 0; lllllllllllIIllIlIIIIlIlIIllIlII < lllllllllllIIllIlIIIIlIlIIllIlIl.length; ++lllllllllllIIllIlIIIIlIlIIllIlII) {
                lllllllllllIIllIlIIIIlIlIIllIlIl[lllllllllllIIllIlIIIIlIlIIllIlII] = (lllllllllllIIllIlIIIIlIlIlIIIIIl.nextFloat() > 0.9f);
                lllllllllllIIllIlIIIIlIlIIllIllI &= lllllllllllIIllIlIIIIlIlIIllIlIl[lllllllllllIIllIlIIIIlIlIIllIlII];
            }
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[0]), 4, 3, 8, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[1]), 5, 3, 8, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[2]), 6, 3, 8, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[3]), 4, 3, 12, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[4]), 5, 3, 12, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[5]), 6, 3, 12, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[6]), 3, 3, 9, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[7]), 3, 3, 10, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIlllIII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[8]), 3, 3, 11, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIlll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[9]), 7, 3, 9, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIlll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[10]), 7, 3, 10, lllllllllllIIllIlIIIIlIlIIlIllIl);
            this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIlll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllIIllIlIIIIlIlIIllIlIl[11]), 7, 3, 11, lllllllllllIIllIlIIIIlIlIIlIllIl);
            if (lllllllllllIIllIlIIIIlIlIIllIllI) {
                final IBlockState lllllllllllIIllIlIIIIlIlIIllIIll = Blocks.END_PORTAL.getDefaultState();
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 4, 3, 9, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 5, 3, 9, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 6, 3, 9, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 4, 3, 10, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 5, 3, 10, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 6, 3, 10, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 4, 3, 11, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 5, 3, 11, lllllllllllIIllIlIIIIlIlIIlIllIl);
                this.setBlockState(lllllllllllIIllIlIIIIlIlIlIIIIlI, lllllllllllIIllIlIIIIlIlIIllIIll, 6, 3, 11, lllllllllllIIllIlIIIIlIlIIlIllIl);
            }
            if (!this.hasSpawner) {
                lllllllllllIIllIlIIIIlIlIIllllll = this.getYWithOffset(3);
                final BlockPos lllllllllllIIllIlIIIIlIlIIllIIlI = new BlockPos(this.getXWithOffset(5, 6), lllllllllllIIllIlIIIIlIlIIllllll, this.getZWithOffset(5, 6));
                if (lllllllllllIIllIlIIIIlIlIIlIllIl.isVecInside(lllllllllllIIllIlIIIIlIlIIllIIlI)) {
                    this.hasSpawner = true;
                    lllllllllllIIllIlIIIIlIlIlIIIIlI.setBlockState(lllllllllllIIllIlIIIIlIlIIllIIlI, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                    final TileEntity lllllllllllIIllIlIIIIlIlIIllIIIl = lllllllllllIIllIlIIIIlIlIlIIIIlI.getTileEntity(lllllllllllIIllIlIIIIlIlIIllIIlI);
                    if (lllllllllllIIllIlIIIIlIlIIllIIIl instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)lllllllllllIIllIlIIIIlIlIIllIIIl).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntitySilverfish.class));
                    }
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIllIlIIIIlIlIllIlIlI, final List<StructureComponent> lllllllllllIIllIlIIIIlIlIllIllIl, final Random lllllllllllIIllIlIIIIlIlIllIllII) {
            if (lllllllllllIIllIlIIIIlIlIllIlIlI != null) {
                ((Stairs2)lllllllllllIIllIlIIIIlIlIllIlIlI).strongholdPortalRoom = this;
            }
        }
        
        public static PortalRoom createPiece(final List<StructureComponent> lllllllllllIIllIlIIIIlIlIlIllIIl, final Random lllllllllllIIllIlIIIIlIlIllIIIII, final int lllllllllllIIllIlIIIIlIlIlIlllll, final int lllllllllllIIllIlIIIIlIlIlIllllI, final int lllllllllllIIllIlIIIIlIlIlIlllIl, final EnumFacing lllllllllllIIllIlIIIIlIlIlIlIlII, final int lllllllllllIIllIlIIIIlIlIlIllIll) {
            final StructureBoundingBox lllllllllllIIllIlIIIIlIlIlIllIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllIlIIIIlIlIlIlllll, lllllllllllIIllIlIIIIlIlIlIllllI, lllllllllllIIllIlIIIIlIlIlIlllIl, -4, -1, 0, 11, 8, 16, lllllllllllIIllIlIIIIlIlIlIlIlII);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllIIllIlIIIIlIlIlIllIlI) && StructureComponent.findIntersecting(lllllllllllIIllIlIIIIlIlIlIllIIl, lllllllllllIIllIlIIIIlIlIlIllIlI) == null) ? new PortalRoom(lllllllllllIIllIlIIIIlIlIlIllIll, lllllllllllIIllIlIIIIlIlIllIIIII, lllllllllllIIllIlIIIIlIlIlIllIlI, lllllllllllIIllIlIIIIlIlIlIlIlII) : null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIllIlIIIIlIlIlllIIll, final TemplateManager lllllllllllIIllIlIIIIlIlIlllIlIl) {
            super.readStructureFromNBT(lllllllllllIIllIlIIIIlIlIlllIIll, lllllllllllIIllIlIIIIlIlIlllIlIl);
            this.hasSpawner = lllllllllllIIllIlIIIIlIlIlllIIll.getBoolean("Mob");
        }
        
        public PortalRoom() {
        }
        
        public PortalRoom(final int lllllllllllIIllIlIIIIlIllIIIlIII, final Random lllllllllllIIllIlIIIIlIllIIIIlll, final StructureBoundingBox lllllllllllIIllIlIIIIlIllIIIIllI, final EnumFacing lllllllllllIIllIlIIIIlIllIIIIlIl) {
            super(lllllllllllIIllIlIIIIlIllIIIlIII);
            this.setCoordBaseMode(lllllllllllIIllIlIIIIlIllIIIIlIl);
            this.boundingBox = lllllllllllIIllIlIIIIlIllIIIIllI;
        }
    }
    
    abstract static class Stronghold extends StructureComponent
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        protected /* synthetic */ Door entryDoor;
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door() {
            final int[] $switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door = Stronghold.$SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door;
            if ($switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door != null) {
                return $switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door;
            }
            final boolean llllllllllllIllIIIlIIlIIlIlIIIIl = (Object)new int[Door.values().length];
            try {
                llllllllllllIllIIIlIIlIIlIlIIIIl[Door.GRATES.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllIllIIIlIIlIIlIlIIIIl[Door.IRON_DOOR.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllIllIIIlIIlIIlIlIIIIl[Door.OPENING.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllIllIIIlIIlIIlIlIIIIl[Door.WOOD_DOOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            return Stronghold.$SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door = (int[])(Object)llllllllllllIllIIIlIIlIIlIlIIIIl;
        }
        
        @Nullable
        protected StructureComponent getNextComponentX(final Stairs2 llllllllllllIllIIIlIIlIIllIIIIII, final List<StructureComponent> llllllllllllIllIIIlIIlIIllIIIllI, final Random llllllllllllIllIIIlIIlIIllIIIlIl, final int llllllllllllIllIIIlIIlIIlIllllIl, final int llllllllllllIllIIIlIIlIIllIIIIll) {
            final EnumFacing llllllllllllIllIIIlIIlIIllIIIIlI = this.getCoordBaseMode();
            if (llllllllllllIllIIIlIIlIIllIIIIlI != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllIIIlIIlIIllIIIIlI.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIIIIII, llllllllllllIllIIIlIIlIIllIIIllI, llllllllllllIllIIIlIIlIIllIIIlIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIllllIl, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIllIIIIll, EnumFacing.WEST, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIIIIII, llllllllllllIllIIIlIIlIIllIIIllI, llllllllllllIllIIIlIIlIIllIIIlIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIllllIl, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIllIIIIll, EnumFacing.WEST, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIIIIII, llllllllllllIllIIIlIIlIIllIIIllI, llllllllllllIllIIIlIIlIIllIIIlIl, this.boundingBox.minX + llllllllllllIllIIIlIIlIIllIIIIll, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIllllIl, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIIIIII, llllllllllllIllIIIlIIlIIllIIIllI, llllllllllllIllIIIlIIlIIllIIIlIl, this.boundingBox.minX + llllllllllllIllIIIlIIlIIllIIIIll, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIllllIl, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIllIIIlIIlIlIIIIlIIl) {
            llllllllllllIllIIIlIIlIlIIIIlIIl.setString("EntryDoor", this.entryDoor.name());
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIllIIIlIIlIlIIIIIlIl, final TemplateManager llllllllllllIllIIIlIIlIlIIIIIlII) {
            this.entryDoor = Door.valueOf(llllllllllllIllIIIlIIlIlIIIIIlIl.getString("EntryDoor"));
        }
        
        public Stronghold() {
            this.entryDoor = Door.OPENING;
        }
        
        protected void placeDoor(final World llllllllllllIllIIIlIIlIIlllllIIl, final Random llllllllllllIllIIIlIIlIIlllllIII, final StructureBoundingBox llllllllllllIllIIIlIIlIIllllIIII, final Door llllllllllllIllIIIlIIlIIllllIllI, final int llllllllllllIllIIIlIIlIIllllIlIl, final int llllllllllllIllIIIlIIlIIllllIlII, final int llllllllllllIllIIIlIIlIIllllIIll) {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door()[llllllllllllIllIIIlIIlIIllllIllI.ordinal()]) {
                case 1: {
                    this.fillWithBlocks(llllllllllllIllIIIlIIlIIlllllIIl, llllllllllllIllIIIlIIlIIllllIIII, llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIlIl + 3 - 1, llllllllllllIllIIIlIIlIIllllIlII + 3 - 1, llllllllllllIllIIIlIIlIIllllIIll, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                    break;
                }
                case 2: {
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.OAK_DOOR.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    break;
                }
                case 3: {
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.AIR.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.AIR.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_BARS.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    break;
                }
                case 4: {
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 2, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONEBRICK.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_DOOR.getDefaultState(), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.IRON_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), llllllllllllIllIIIlIIlIIllllIlIl + 1, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONE_BUTTON.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.NORTH), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll + 1, llllllllllllIllIIIlIIlIIllllIIII);
                    this.setBlockState(llllllllllllIllIIIlIIlIIlllllIIl, Blocks.STONE_BUTTON.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.SOUTH), llllllllllllIllIIIlIIlIIllllIlIl + 2, llllllllllllIllIIIlIIlIIllllIlII + 1, llllllllllllIllIIIlIIlIIllllIIll - 1, llllllllllllIllIIIlIIlIIllllIIII);
                    break;
                }
            }
        }
        
        protected Stronghold(final int llllllllllllIllIIIlIIlIlIIIIllll) {
            super(llllllllllllIllIIIlIIlIlIIIIllll);
            this.entryDoor = Door.OPENING;
        }
        
        protected Door getRandomDoor(final Random llllllllllllIllIIIlIIlIIlllIIllI) {
            final int llllllllllllIllIIIlIIlIIlllIIlll = llllllllllllIllIIIlIIlIIlllIIllI.nextInt(5);
            switch (llllllllllllIllIIIlIIlIIlllIIlll) {
                default: {
                    return Door.OPENING;
                }
                case 2: {
                    return Door.WOOD_DOOR;
                }
                case 3: {
                    return Door.GRATES;
                }
                case 4: {
                    return Door.IRON_DOOR;
                }
            }
        }
        
        @Nullable
        protected StructureComponent getNextComponentZ(final Stairs2 llllllllllllIllIIIlIIlIIlIllIIlI, final List<StructureComponent> llllllllllllIllIIIlIIlIIlIllIIIl, final Random llllllllllllIllIIIlIIlIIlIlIlIIl, final int llllllllllllIllIIIlIIlIIlIlIlIII, final int llllllllllllIllIIIlIIlIIlIlIIlll) {
            final EnumFacing llllllllllllIllIIIlIIlIIlIlIllIl = this.getCoordBaseMode();
            if (llllllllllllIllIIIlIIlIIlIlIllIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllIIIlIIlIIlIlIllIl.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIlIllIIlI, llllllllllllIllIIIlIIlIIlIllIIIl, llllllllllllIllIIIlIIlIIlIlIlIIl, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIlIlIII, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIlIlIIlll, EnumFacing.EAST, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIlIllIIlI, llllllllllllIllIIIlIIlIIlIllIIIl, llllllllllllIllIIIlIIlIIlIlIlIIl, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIlIlIII, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIlIlIIlll, EnumFacing.EAST, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIlIllIIlI, llllllllllllIllIIIlIIlIIlIllIIIl, llllllllllllIllIIIlIIlIIlIlIlIIl, this.boundingBox.minX + llllllllllllIllIIIlIIlIIlIlIIlll, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIlIlIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIlIllIIlI, llllllllllllIllIIIlIIlIIlIllIIIl, llllllllllllIllIIIlIIlIIlIlIlIIl, this.boundingBox.minX + llllllllllllIllIIIlIIlIIlIlIIlll, this.boundingBox.minY + llllllllllllIllIIIlIIlIIlIlIlIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Stronghold.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final byte llllllllllllIllIIIlIIlIIlIIlllll = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllIllIIIlIIlIIlIIlllll[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Stronghold.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllIIIlIIlIIlIIlllll;
        }
        
        protected static boolean canStrongholdGoDeeper(final StructureBoundingBox llllllllllllIllIIIlIIlIIlIlIIlII) {
            return llllllllllllIllIIIlIIlIIlIlIIlII != null && llllllllllllIllIIIlIIlIIlIlIIlII.minY > 10;
        }
        
        @Nullable
        protected StructureComponent getNextComponentNormal(final Stairs2 llllllllllllIllIIIlIIlIIllIlllII, final List<StructureComponent> llllllllllllIllIIIlIIlIIllIllIll, final Random llllllllllllIllIIIlIIlIIllIllIlI, final int llllllllllllIllIIIlIIlIIllIllIIl, final int llllllllllllIllIIIlIIlIIllIllIII) {
            final EnumFacing llllllllllllIllIIIlIIlIIllIlIlll = this.getCoordBaseMode();
            if (llllllllllllIllIIIlIIlIIllIlIlll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllIIIlIIlIIllIlIlll.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIlllII, llllllllllllIllIIIlIIlIIllIllIll, llllllllllllIllIIIlIIlIIllIllIlI, this.boundingBox.minX + llllllllllllIllIIIlIIlIIllIllIIl, this.boundingBox.minY + llllllllllllIllIIIlIIlIIllIllIII, this.boundingBox.minZ - 1, llllllllllllIllIIIlIIlIIllIlIlll, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIlllII, llllllllllllIllIIIlIIlIIllIllIll, llllllllllllIllIIIlIIlIIllIllIlI, this.boundingBox.minX + llllllllllllIllIIIlIIlIIllIllIIl, this.boundingBox.minY + llllllllllllIllIIIlIIlIIllIllIII, this.boundingBox.maxZ + 1, llllllllllllIllIIIlIIlIIllIlIlll, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIlllII, llllllllllllIllIIIlIIlIIllIllIll, llllllllllllIllIIIlIIlIIllIllIlI, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIllIllIII, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIllIllIIl, llllllllllllIllIIIlIIlIIllIlIlll, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllIllIIIlIIlIIllIlllII, llllllllllllIllIIIlIIlIIllIllIll, llllllllllllIllIIIlIIlIIllIllIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllIllIIIlIIlIIllIllIII, this.boundingBox.minZ + llllllllllllIllIIIlIIlIIllIllIIl, llllllllllllIllIIIlIIlIIllIlIlll, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        public enum Door
        {
            IRON_DOOR("IRON_DOOR", 3), 
            WOOD_DOOR("WOOD_DOOR", 1), 
            OPENING("OPENING", 0), 
            GRATES("GRATES", 2);
            
            private Door(final String lllllllllllIlllIIllIllIIIlIIllII, final int lllllllllllIlllIIllIllIIIlIIlIll) {
            }
        }
    }
    
    static class Stones extends StructureComponent.BlockSelector
    {
        private Stones() {
        }
        
        @Override
        public void selectBlocks(final Random lllllllllllIllIIllIllIIIlIlIIIll, final int lllllllllllIllIIllIllIIIlIlIlIIl, final int lllllllllllIllIIllIllIIIlIlIlIII, final int lllllllllllIllIIllIllIIIlIlIIlll, final boolean lllllllllllIllIIllIllIIIlIlIIIlI) {
            if (lllllllllllIllIIllIllIIIlIlIIIlI) {
                final float lllllllllllIllIIllIllIIIlIlIIlIl = lllllllllllIllIIllIllIIIlIlIIIll.nextFloat();
                if (lllllllllllIllIIllIllIIIlIlIIlIl < 0.2f) {
                    this.blockstate = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CRACKED_META);
                }
                else if (lllllllllllIllIIllIllIIIlIlIIlIl < 0.5f) {
                    this.blockstate = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.MOSSY_META);
                }
                else if (lllllllllllIllIIllIllIIIlIlIIlIl < 0.55f) {
                    this.blockstate = Blocks.MONSTER_EGG.getStateFromMeta(BlockSilverfish.EnumType.STONEBRICK.getMetadata());
                }
                else {
                    this.blockstate = Blocks.STONEBRICK.getDefaultState();
                }
            }
            else {
                this.blockstate = Blocks.AIR.getDefaultState();
            }
        }
    }
    
    static class PieceWeight
    {
        public /* synthetic */ int instancesLimit;
        public final /* synthetic */ int pieceWeight;
        public /* synthetic */ int instancesSpawned;
        public /* synthetic */ Class<? extends Stronghold> pieceClass;
        
        public boolean canSpawnMoreStructures() {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
        
        public boolean canSpawnMoreStructuresOfType(final int llllllllllllllllIlIlIIlIlIlIIllI) {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
        
        public PieceWeight(final Class<? extends Stronghold> llllllllllllllllIlIlIIlIlIlIlIll, final int llllllllllllllllIlIlIIlIlIlIlIlI, final int llllllllllllllllIlIlIIlIlIlIllIl) {
            this.pieceClass = llllllllllllllllIlIlIIlIlIlIlIll;
            this.pieceWeight = llllllllllllllllIlIlIIlIlIlIlIlI;
            this.instancesLimit = llllllllllllllllIlIlIIlIlIlIllIl;
        }
    }
    
    public static class Prison extends Stronghold
    {
        public Prison(final int llllllllllllIIlIlIIlIIllllIlIIIl, final Random llllllllllllIIlIlIIlIIllllIlIlIl, final StructureBoundingBox llllllllllllIIlIlIIlIIllllIIllll, final EnumFacing llllllllllllIIlIlIIlIIllllIIlllI) {
            super(llllllllllllIIlIlIIlIIllllIlIIIl);
            this.setCoordBaseMode(llllllllllllIIlIlIIlIIllllIIlllI);
            this.entryDoor = this.getRandomDoor(llllllllllllIIlIlIIlIIllllIlIlIl);
            this.boundingBox = llllllllllllIIlIlIIlIIllllIIllll;
        }
        
        public Prison() {
        }
        
        public static Prison createPiece(final List<StructureComponent> llllllllllllIIlIlIIlIIlllIllIIIl, final Random llllllllllllIIlIlIIlIIlllIlllIII, final int llllllllllllIIlIlIIlIIlllIlIllll, final int llllllllllllIIlIlIIlIIlllIllIllI, final int llllllllllllIIlIlIIlIIlllIllIlIl, final EnumFacing llllllllllllIIlIlIIlIIlllIllIlII, final int llllllllllllIIlIlIIlIIlllIlIlIll) {
            final StructureBoundingBox llllllllllllIIlIlIIlIIlllIllIIlI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllIIlIlIIlIIlllIlIllll, llllllllllllIIlIlIIlIIlllIllIllI, llllllllllllIIlIlIIlIIlllIllIlIl, -1, -1, 0, 9, 5, 11, llllllllllllIIlIlIIlIIlllIllIlII);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllIIlIlIIlIIlllIllIIlI) && StructureComponent.findIntersecting(llllllllllllIIlIlIIlIIlllIllIIIl, llllllllllllIIlIlIIlIIlllIllIIlI) == null) ? new Prison(llllllllllllIIlIlIIlIIlllIlIlIll, llllllllllllIIlIlIIlIIlllIlllIII, llllllllllllIIlIlIIlIIlllIllIIlI, llllllllllllIIlIlIIlIIlllIllIlII) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIIlIlIIlIIlllIIlllII, final Random llllllllllllIIlIlIIlIIlllIIllIll, final StructureBoundingBox llllllllllllIIlIlIIlIIlllIIllIlI) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 0, 0, 0, 8, 4, 10, true, llllllllllllIIlIlIIlIIlllIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIll, llllllllllllIIlIlIIlIIlllIIllIlI, this.entryDoor, 1, 1, 0);
            this.fillWithBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 1, 1, 10, 3, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithRandomizedBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 4, 1, 1, 4, 3, 1, false, llllllllllllIIlIlIIlIIlllIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 4, 1, 3, 4, 3, 3, false, llllllllllllIIlIlIIlIIlllIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 4, 1, 7, 4, 3, 7, false, llllllllllllIIlIlIIlIIlllIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 4, 1, 9, 4, 3, 9, false, llllllllllllIIlIlIIlIIlllIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 4, 1, 4, 4, 3, 6, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllIlI, 5, 1, 5, 7, 3, 5, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, Blocks.IRON_BARS.getDefaultState(), 4, 3, 2, llllllllllllIIlIlIIlIIlllIIllIlI);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, Blocks.IRON_BARS.getDefaultState(), 4, 3, 8, llllllllllllIIlIlIIlIIlllIIllIlI);
            final IBlockState llllllllllllIIlIlIIlIIlllIIlllll = Blocks.IRON_DOOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.WEST);
            final IBlockState llllllllllllIIlIlIIlIIlllIIllllI = Blocks.IRON_DOOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.WEST).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIlllll, 4, 1, 2, llllllllllllIIlIlIIlIIlllIIllIlI);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllllI, 4, 2, 2, llllllllllllIIlIlIIlIIlllIIllIlI);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIlllll, 4, 1, 8, llllllllllllIIlIlIIlIIlllIIllIlI);
            this.setBlockState(llllllllllllIIlIlIIlIIlllIIlllII, llllllllllllIIlIlIIlIIlllIIllllI, 4, 2, 8, llllllllllllIIlIlIIlIIlllIIllIlI);
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllIIlIlIIlIIllllIIIlII, final List<StructureComponent> llllllllllllIIlIlIIlIIllllIIIlll, final Random llllllllllllIIlIlIIlIIllllIIIllI) {
            this.getNextComponentNormal((Stairs2)llllllllllllIIlIlIIlIIllllIIIlII, llllllllllllIIlIlIIlIIllllIIIlll, llllllllllllIIlIlIIlIIllllIIIllI, 1, 1);
        }
    }
    
    public static class ChestCorridor extends Stronghold
    {
        private /* synthetic */ boolean hasMadeChest;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIllIlIlllIIlIlllllIlI, final TemplateManager lllllllllllIllIlIlllIIlIllllIllI) {
            super.readStructureFromNBT(lllllllllllIllIlIlllIIlIlllllIlI, lllllllllllIllIlIlllIIlIllllIllI);
            this.hasMadeChest = lllllllllllIllIlIlllIIlIlllllIlI.getBoolean("Chest");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIllIlIlllIIlIllIIlIll, final Random lllllllllllIllIlIlllIIlIllIIIlIl, final StructureBoundingBox lllllllllllIllIlIlllIIlIllIIlIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIlIIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIlIIl, 0, 0, 0, 4, 4, 6, true, lllllllllllIllIlIlllIIlIllIIIlIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIIlIl, lllllllllllIllIlIlllIIlIllIIlIIl, this.entryDoor, 1, 1, 0);
            this.placeDoor(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIIlIl, lllllllllllIllIlIlllIIlIllIIlIIl, Door.OPENING, 1, 1, 6);
            this.fillWithBlocks(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIlIIl, 3, 1, 2, 3, 1, 4, Blocks.STONEBRICK.getDefaultState(), Blocks.STONEBRICK.getDefaultState(), false);
            this.setBlockState(lllllllllllIllIlIlllIIlIllIIlIll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 1, lllllllllllIllIlIlllIIlIllIIlIIl);
            this.setBlockState(lllllllllllIllIlIlllIIlIllIIlIll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 5, lllllllllllIllIlIlllIIlIllIIlIIl);
            this.setBlockState(lllllllllllIllIlIlllIIlIllIIlIll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 2, lllllllllllIllIlIlllIIlIllIIlIIl);
            this.setBlockState(lllllllllllIllIlIlllIIlIllIIlIll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 4, lllllllllllIllIlIlllIIlIllIIlIIl);
            for (int lllllllllllIllIlIlllIIlIllIIlIII = 2; lllllllllllIllIlIlllIIlIllIIlIII <= 4; ++lllllllllllIllIlIlllIIlIllIIlIII) {
                this.setBlockState(lllllllllllIllIlIlllIIlIllIIlIll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 2, 1, lllllllllllIllIlIlllIIlIllIIlIII, lllllllllllIllIlIlllIIlIllIIlIIl);
            }
            if (!this.hasMadeChest && lllllllllllIllIlIlllIIlIllIIlIIl.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.hasMadeChest = true;
                this.generateChest(lllllllllllIllIlIlllIIlIllIIlIll, lllllllllllIllIlIlllIIlIllIIlIIl, lllllllllllIllIlIlllIIlIllIIIlIl, 3, 2, 3, LootTableList.CHESTS_STRONGHOLD_CORRIDOR);
            }
            return true;
        }
        
        public ChestCorridor() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIllIlIlllIIlIlllIllII, final List<StructureComponent> lllllllllllIllIlIlllIIlIlllIllll, final Random lllllllllllIllIlIlllIIlIlllIlllI) {
            this.getNextComponentNormal((Stairs2)lllllllllllIllIlIlllIIlIlllIllII, lllllllllllIllIlIlllIIlIlllIllll, lllllllllllIllIlIlllIIlIlllIlllI, 1, 1);
        }
        
        public ChestCorridor(final int lllllllllllIllIlIlllIIllIIIIlIII, final Random lllllllllllIllIlIlllIIllIIIIIlll, final StructureBoundingBox lllllllllllIllIlIlllIIllIIIIlIll, final EnumFacing lllllllllllIllIlIlllIIllIIIIIlIl) {
            super(lllllllllllIllIlIlllIIllIIIIlIII);
            this.setCoordBaseMode(lllllllllllIllIlIlllIIllIIIIIlIl);
            this.entryDoor = this.getRandomDoor(lllllllllllIllIlIlllIIllIIIIIlll);
            this.boundingBox = lllllllllllIllIlIlllIIllIIIIlIll;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIllIlIlllIIllIIIIIIIl) {
            super.writeStructureToNBT(lllllllllllIllIlIlllIIllIIIIIIIl);
            lllllllllllIllIlIlllIIllIIIIIIIl.setBoolean("Chest", this.hasMadeChest);
        }
        
        public static ChestCorridor createPiece(final List<StructureComponent> lllllllllllIllIlIlllIIlIlllIIIIl, final Random lllllllllllIllIlIlllIIlIlllIIIII, final int lllllllllllIllIlIlllIIlIllIlllll, final int lllllllllllIllIlIlllIIlIllIlIllI, final int lllllllllllIllIlIlllIIlIllIlllIl, final EnumFacing lllllllllllIllIlIlllIIlIllIlIlII, final int lllllllllllIllIlIlllIIlIllIlIIll) {
            final StructureBoundingBox lllllllllllIllIlIlllIIlIllIllIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIllIlIlllIIlIllIlllll, lllllllllllIllIlIlllIIlIllIlIllI, lllllllllllIllIlIlllIIlIllIlllIl, -1, -1, 0, 5, 5, 7, lllllllllllIllIlIlllIIlIllIlIlII);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllIllIlIlllIIlIllIllIlI) && StructureComponent.findIntersecting(lllllllllllIllIlIlllIIlIlllIIIIl, lllllllllllIllIlIlllIIlIllIllIlI) == null) ? new ChestCorridor(lllllllllllIllIlIlllIIlIllIlIIll, lllllllllllIllIlIlllIIlIlllIIIII, lllllllllllIllIlIlllIIlIllIllIlI, lllllllllllIllIlIlllIIlIllIlIlII) : null;
        }
    }
    
    public static class RoomCrossing extends Stronghold
    {
        protected /* synthetic */ int roomType;
        
        public RoomCrossing() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllIllIlIl, final List<StructureComponent> llllllllIllIIII, final Random llllllllIllIIll) {
            this.getNextComponentNormal((Stairs2)llllllllIllIlIl, llllllllIllIIII, llllllllIllIIll, 4, 1);
            this.getNextComponentX((Stairs2)llllllllIllIlIl, llllllllIllIIII, llllllllIllIIll, 1, 4);
            this.getNextComponentZ((Stairs2)llllllllIllIlIl, llllllllIllIIII, llllllllIllIIll, 1, 4);
        }
        
        public RoomCrossing(final int lllllllllIIllIl, final Random lllllllllIIllII, final StructureBoundingBox lllllllllIlIIII, final EnumFacing lllllllllIIllll) {
            super(lllllllllIIllIl);
            this.setCoordBaseMode(lllllllllIIllll);
            this.entryDoor = this.getRandomDoor(lllllllllIIllII);
            this.boundingBox = lllllllllIlIIII;
            this.roomType = lllllllllIIllII.nextInt(5);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllIllllll, final TemplateManager llllllllIlllllI) {
            super.readStructureFromNBT(llllllllIllllll, llllllllIlllllI);
            this.roomType = llllllllIllllll.getInteger("Type");
        }
        
        public static RoomCrossing createPiece(final List<StructureComponent> llllllllIlIIllI, final Random llllllllIlIIlIl, final int llllllllIIlllII, final int llllllllIlIIIll, final int llllllllIIllIlI, final EnumFacing llllllllIIllIIl, final int llllllllIlIIIII) {
            final StructureBoundingBox llllllllIIlllll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllIIlllII, llllllllIlIIIll, llllllllIIllIlI, -4, -1, 0, 11, 7, 11, llllllllIIllIIl);
            return (Stronghold.canStrongholdGoDeeper(llllllllIIlllll) && StructureComponent.findIntersecting(llllllllIlIIllI, llllllllIIlllll) == null) ? new RoomCrossing(llllllllIlIIIII, llllllllIlIIlIl, llllllllIIlllll, llllllllIIllIIl) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllIIIIllI, final Random llllllllIIIIlIl, final StructureBoundingBox llllllllIIIIlII) {
            if (this.isLiquidInStructureBoundingBox(llllllllIIIIllI, llllllllIIIIlII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllIIIIllI, llllllllIIIIlII, 0, 0, 0, 10, 6, 10, true, llllllllIIIIlIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllIIIIllI, llllllllIIIIlIl, llllllllIIIIlII, this.entryDoor, 4, 1, 0);
            this.fillWithBlocks(llllllllIIIIllI, llllllllIIIIlII, 4, 1, 10, 6, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllIIIIllI, llllllllIIIIlII, 0, 1, 4, 0, 3, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllIIIIllI, llllllllIIIIlII, 10, 1, 4, 10, 3, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            switch (this.roomType) {
                case 0: {
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 2, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 3, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST), 4, 3, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST), 6, 3, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH), 5, 3, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH), 5, 3, 6, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 6, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 6, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 5, 1, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONE_SLAB.getDefaultState(), 5, 1, 6, llllllllIIIIlII);
                    break;
                }
                case 1: {
                    for (int llllllllIIIllIl = 0; llllllllIIIllIl < 5; ++llllllllIIIllIl) {
                        this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 3, 1, 3 + llllllllIIIllIl, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 7, 1, 3 + llllllllIIIllIl, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 3 + llllllllIIIllIl, 1, 3, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 3 + llllllllIIIllIl, 1, 7, llllllllIIIIlII);
                    }
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 2, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.STONEBRICK.getDefaultState(), 5, 3, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.FLOWING_WATER.getDefaultState(), 5, 4, 5, llllllllIIIIlII);
                    break;
                }
                case 2: {
                    for (int llllllllIIIllII = 1; llllllllIIIllII <= 9; ++llllllllIIIllII) {
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 1, 3, llllllllIIIllII, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 9, 3, llllllllIIIllII, llllllllIIIIlII);
                    }
                    for (int llllllllIIIlIll = 1; llllllllIIIlIll <= 9; ++llllllllIIIlIll) {
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), llllllllIIIlIll, 3, 1, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), llllllllIIIlIll, 3, 9, llllllllIIIIlII);
                    }
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 5, 1, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 5, 1, 6, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 5, 3, 4, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 5, 3, 6, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 4, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 6, 1, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 4, 3, 5, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 6, 3, 5, llllllllIIIIlII);
                    for (int llllllllIIIlIlI = 1; llllllllIIIlIlI <= 3; ++llllllllIIIlIlI) {
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 4, llllllllIIIlIlI, 4, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 6, llllllllIIIlIlI, 4, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 4, llllllllIIIlIlI, 6, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.COBBLESTONE.getDefaultState(), 6, llllllllIIIlIlI, 6, llllllllIIIIlII);
                    }
                    this.setBlockState(llllllllIIIIllI, Blocks.TORCH.getDefaultState(), 5, 3, 5, llllllllIIIIlII);
                    for (int llllllllIIIlIIl = 2; llllllllIIIlIIl <= 8; ++llllllllIIIlIIl) {
                        this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 2, 3, llllllllIIIlIIl, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 3, 3, llllllllIIIlIIl, llllllllIIIIlII);
                        if (llllllllIIIlIIl <= 3 || llllllllIIIlIIl >= 7) {
                            this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 4, 3, llllllllIIIlIIl, llllllllIIIIlII);
                            this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 5, 3, llllllllIIIlIIl, llllllllIIIIlII);
                            this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 6, 3, llllllllIIIlIIl, llllllllIIIIlII);
                        }
                        this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 7, 3, llllllllIIIlIIl, llllllllIIIIlII);
                        this.setBlockState(llllllllIIIIllI, Blocks.PLANKS.getDefaultState(), 8, 3, llllllllIIIlIIl, llllllllIIIIlII);
                    }
                    final IBlockState llllllllIIIlIII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.WEST);
                    this.setBlockState(llllllllIIIIllI, llllllllIIIlIII, 9, 1, 3, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, llllllllIIIlIII, 9, 2, 3, llllllllIIIIlII);
                    this.setBlockState(llllllllIIIIllI, llllllllIIIlIII, 9, 3, 3, llllllllIIIIlII);
                    this.generateChest(llllllllIIIIllI, llllllllIIIIlII, llllllllIIIIlIl, 3, 4, 8, LootTableList.CHESTS_STRONGHOLD_CROSSING);
                    break;
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllIIIlII) {
            super.writeStructureToNBT(lllllllllIIIlII);
            lllllllllIIIlII.setInteger("Type", this.roomType);
        }
    }
    
    public static class Corridor extends Stronghold
    {
        private /* synthetic */ int steps;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIlIIIlIlllIllIIIlIll) {
            super.writeStructureToNBT(lllllllllllIIlIIIlIlllIllIIIlIll);
            lllllllllllIIlIIIlIlllIllIIIlIll.setInteger("Steps", this.steps);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIlIIIlIlllIllIIIIIll, final TemplateManager lllllllllllIIlIIIlIlllIllIIIIlIl) {
            super.readStructureFromNBT(lllllllllllIIlIIIlIlllIllIIIIIll, lllllllllllIIlIIIlIlllIllIIIIlIl);
            this.steps = lllllllllllIIlIIIlIlllIllIIIIIll.getInteger("Steps");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIIlIlllIlIlIllIIl, final Random lllllllllllIIlIIIlIlllIlIlIllllI, final StructureBoundingBox lllllllllllIIlIIIlIlllIlIlIlllIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIIlIIIlIlllIlIlIllIIl, lllllllllllIIlIIIlIlllIlIlIlllIl)) {
                return false;
            }
            for (int lllllllllllIIlIIIlIlllIlIlIlllII = 0; lllllllllllIIlIIIlIlllIlIlIlllII < this.steps; ++lllllllllllIIlIIIlIlllIlIlIlllII) {
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 0, 0, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 1, 0, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 2, 0, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 3, 0, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 4, 0, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                for (int lllllllllllIIlIIIlIlllIlIlIllIll = 1; lllllllllllIIlIIIlIlllIlIlIllIll <= 3; ++lllllllllllIIlIIIlIlllIlIlIllIll) {
                    this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 0, lllllllllllIIlIIIlIlllIlIlIllIll, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                    this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.AIR.getDefaultState(), 1, lllllllllllIIlIIIlIlllIlIlIllIll, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                    this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.AIR.getDefaultState(), 2, lllllllllllIIlIIIlIlllIlIlIllIll, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                    this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.AIR.getDefaultState(), 3, lllllllllllIIlIIIlIlllIlIlIllIll, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                    this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 4, lllllllllllIIlIIIlIlllIlIlIllIll, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                }
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 0, 4, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 1, 4, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 2, 4, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 3, 4, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
                this.setBlockState(lllllllllllIIlIIIlIlllIlIlIllIIl, Blocks.STONEBRICK.getDefaultState(), 4, 4, lllllllllllIIlIIIlIlllIlIlIlllII, lllllllllllIIlIIIlIlllIlIlIlllIl);
            }
            return true;
        }
        
        public Corridor(final int lllllllllllIIlIIIlIlllIllIIlIIll, final Random lllllllllllIIlIIIlIlllIllIIlIlll, final StructureBoundingBox lllllllllllIIlIIIlIlllIllIIlIllI, final EnumFacing lllllllllllIIlIIIlIlllIllIIlIlIl) {
            super(lllllllllllIIlIIIlIlllIllIIlIIll);
            this.setCoordBaseMode(lllllllllllIIlIIIlIlllIllIIlIlIl);
            this.boundingBox = lllllllllllIIlIIIlIlllIllIIlIllI;
            this.steps = ((lllllllllllIIlIIIlIlllIllIIlIlIl != EnumFacing.NORTH && lllllllllllIIlIIIlIlllIllIIlIlIl != EnumFacing.SOUTH) ? lllllllllllIIlIIIlIlllIllIIlIllI.getXSize() : lllllllllllIIlIIIlIlllIllIIlIllI.getZSize());
        }
        
        public Corridor() {
        }
        
        public static StructureBoundingBox findPieceBox(final List<StructureComponent> lllllllllllIIlIIIlIlllIlIllllIII, final Random lllllllllllIIlIIIlIlllIlIlllIlll, final int lllllllllllIIlIIIlIlllIlIllIllIl, final int lllllllllllIIlIIIlIlllIlIlllIlIl, final int lllllllllllIIlIIIlIlllIlIlllIlII, final EnumFacing lllllllllllIIlIIIlIlllIlIlllIIll) {
            final int lllllllllllIIlIIIlIlllIlIlllIIlI = 3;
            StructureBoundingBox lllllllllllIIlIIIlIlllIlIlllIIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIIlIlllIlIllIllIl, lllllllllllIIlIIIlIlllIlIlllIlIl, lllllllllllIIlIIIlIlllIlIlllIlII, -1, -1, 0, 5, 5, 4, lllllllllllIIlIIIlIlllIlIlllIIll);
            final StructureComponent lllllllllllIIlIIIlIlllIlIlllIIII = StructureComponent.findIntersecting(lllllllllllIIlIIIlIlllIlIllllIII, lllllllllllIIlIIIlIlllIlIlllIIIl);
            if (lllllllllllIIlIIIlIlllIlIlllIIII == null) {
                return null;
            }
            if (lllllllllllIIlIIIlIlllIlIlllIIII.getBoundingBox().minY == lllllllllllIIlIIIlIlllIlIlllIIIl.minY) {
                for (int lllllllllllIIlIIIlIlllIlIllIllll = 3; lllllllllllIIlIIIlIlllIlIllIllll >= 1; --lllllllllllIIlIIIlIlllIlIllIllll) {
                    lllllllllllIIlIIIlIlllIlIlllIIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIIlIlllIlIllIllIl, lllllllllllIIlIIIlIlllIlIlllIlIl, lllllllllllIIlIIIlIlllIlIlllIlII, -1, -1, 0, 5, 5, lllllllllllIIlIIIlIlllIlIllIllll - 1, lllllllllllIIlIIIlIlllIlIlllIIll);
                    if (!lllllllllllIIlIIIlIlllIlIlllIIII.getBoundingBox().intersectsWith(lllllllllllIIlIIIlIlllIlIlllIIIl)) {
                        return StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIIlIlllIlIllIllIl, lllllllllllIIlIIIlIlllIlIlllIlIl, lllllllllllIIlIIIlIlllIlIlllIlII, -1, -1, 0, 5, 5, lllllllllllIIlIIIlIlllIlIllIllll, lllllllllllIIlIIIlIlllIlIlllIIll);
                    }
                }
            }
            return null;
        }
    }
    
    public static class Straight extends Stronghold
    {
        private /* synthetic */ boolean expandsZ;
        private /* synthetic */ boolean expandsX;
        
        public Straight(final int lllllllllllIllIIllIlIIIIlIlIIlll, final Random lllllllllllIllIIllIlIIIIlIlIIllI, final StructureBoundingBox lllllllllllIllIIllIlIIIIlIlIlIlI, final EnumFacing lllllllllllIllIIllIlIIIIlIlIIlII) {
            super(lllllllllllIllIIllIlIIIIlIlIIlll);
            this.setCoordBaseMode(lllllllllllIllIIllIlIIIIlIlIIlII);
            this.entryDoor = this.getRandomDoor(lllllllllllIllIIllIlIIIIlIlIIllI);
            this.boundingBox = lllllllllllIllIIllIlIIIIlIlIlIlI;
            this.expandsX = (lllllllllllIllIIllIlIIIIlIlIIllI.nextInt(2) == 0);
            this.expandsZ = (lllllllllllIllIIllIlIIIIlIlIIllI.nextInt(2) == 0);
        }
        
        public static Straight createPiece(final List<StructureComponent> lllllllllllIllIIllIlIIIIIllllIII, final Random lllllllllllIllIIllIlIIIIIlllllll, final int lllllllllllIllIIllIlIIIIIllllllI, final int lllllllllllIllIIllIlIIIIIlllllIl, final int lllllllllllIllIIllIlIIIIIlllllII, final EnumFacing lllllllllllIllIIllIlIIIIIllllIll, final int lllllllllllIllIIllIlIIIIIlllIIlI) {
            final StructureBoundingBox lllllllllllIllIIllIlIIIIIllllIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIllIIllIlIIIIIllllllI, lllllllllllIllIIllIlIIIIIlllllIl, lllllllllllIllIIllIlIIIIIlllllII, -1, -1, 0, 5, 5, 7, lllllllllllIllIIllIlIIIIIllllIll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllIllIIllIlIIIIIllllIIl) && StructureComponent.findIntersecting(lllllllllllIllIIllIlIIIIIllllIII, lllllllllllIllIIllIlIIIIIllllIIl) == null) ? new Straight(lllllllllllIllIIllIlIIIIIlllIIlI, lllllllllllIllIIllIlIIIIIlllllll, lllllllllllIllIIllIlIIIIIllllIIl, lllllllllllIllIIllIlIIIIIllllIll) : null;
        }
        
        public Straight() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIllIIllIlIIIIlIIlIllI, final TemplateManager lllllllllllIllIIllIlIIIIlIIllIII) {
            super.readStructureFromNBT(lllllllllllIllIIllIlIIIIlIIlIllI, lllllllllllIllIIllIlIIIIlIIllIII);
            this.expandsX = lllllllllllIllIIllIlIIIIlIIlIllI.getBoolean("Left");
            this.expandsZ = lllllllllllIllIIllIlIIIIlIIlIllI.getBoolean("Right");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIllIIllIlIIIIlIIllllI) {
            super.writeStructureToNBT(lllllllllllIllIIllIlIIIIlIIllllI);
            lllllllllllIllIIllIlIIIIlIIllllI.setBoolean("Left", this.expandsX);
            lllllllllllIllIIllIlIIIIlIIllllI.setBoolean("Right", this.expandsZ);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIllIIllIlIIIIIllIIIll, final Random lllllllllllIllIIllIlIIIIIllIIIlI, final StructureBoundingBox lllllllllllIllIIllIlIIIIIllIIlll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, 0, 0, 0, 4, 4, 6, true, lllllllllllIllIIllIlIIIIIllIIIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIIlI, lllllllllllIllIIllIlIIIIIllIIlll, this.entryDoor, 1, 1, 0);
            this.placeDoor(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIIlI, lllllllllllIllIIllIlIIIIIllIIlll, Door.OPENING, 1, 1, 6);
            final IBlockState lllllllllllIllIIllIlIIIIIllIIllI = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllIllIIllIlIIIIIllIIlIl = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST);
            this.randomlyPlaceBlock(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, lllllllllllIllIIllIlIIIIIllIIIlI, 0.1f, 1, 2, 1, lllllllllllIllIIllIlIIIIIllIIllI);
            this.randomlyPlaceBlock(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, lllllllllllIllIIllIlIIIIIllIIIlI, 0.1f, 3, 2, 1, lllllllllllIllIIllIlIIIIIllIIlIl);
            this.randomlyPlaceBlock(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, lllllllllllIllIIllIlIIIIIllIIIlI, 0.1f, 1, 2, 5, lllllllllllIllIIllIlIIIIIllIIllI);
            this.randomlyPlaceBlock(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, lllllllllllIllIIllIlIIIIIllIIIlI, 0.1f, 3, 2, 5, lllllllllllIllIIllIlIIIIIllIIlIl);
            if (this.expandsX) {
                this.fillWithBlocks(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, 0, 1, 2, 0, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.expandsZ) {
                this.fillWithBlocks(lllllllllllIllIIllIlIIIIIllIIIll, lllllllllllIllIIllIlIIIIIllIIlll, 4, 1, 2, 4, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIllIIllIlIIIIlIIIllll, final List<StructureComponent> lllllllllllIllIIllIlIIIIlIIIlIlI, final Random lllllllllllIllIIllIlIIIIlIIIlIIl) {
            this.getNextComponentNormal((Stairs2)lllllllllllIllIIllIlIIIIlIIIllll, lllllllllllIllIIllIlIIIIlIIIlIlI, lllllllllllIllIIllIlIIIIlIIIlIIl, 1, 1);
            if (this.expandsX) {
                this.getNextComponentX((Stairs2)lllllllllllIllIIllIlIIIIlIIIllll, lllllllllllIllIIllIlIIIIlIIIlIlI, lllllllllllIllIIllIlIIIIlIIIlIIl, 1, 2);
            }
            if (this.expandsZ) {
                this.getNextComponentZ((Stairs2)lllllllllllIllIIllIlIIIIlIIIllll, lllllllllllIllIIllIlIIIIlIIIlIlI, lllllllllllIllIIllIlIIIIlIIIlIIl, 1, 2);
            }
        }
    }
    
    public static class RightTurn extends LeftTurn
    {
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIllllIIIlllIlIllII, final List<StructureComponent> lllllllllllllIIllllIIIlllIllIIII, final Random lllllllllllllIIllllIIIlllIlIlIlI) {
            final EnumFacing lllllllllllllIIllllIIIlllIlIlllI = this.getCoordBaseMode();
            if (lllllllllllllIIllllIIIlllIlIlllI != EnumFacing.NORTH && lllllllllllllIIllllIIIlllIlIlllI != EnumFacing.EAST) {
                this.getNextComponentX((Stairs2)lllllllllllllIIllllIIIlllIlIllII, lllllllllllllIIllllIIIlllIllIIII, lllllllllllllIIllllIIIlllIlIlIlI, 1, 1);
            }
            else {
                this.getNextComponentZ((Stairs2)lllllllllllllIIllllIIIlllIlIllII, lllllllllllllIIllllIIIlllIllIIII, lllllllllllllIIllllIIIlllIlIlIlI, 1, 1);
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIllllIIIlllIIlllIl, final Random lllllllllllllIIllllIIIlllIlIIIIl, final StructureBoundingBox lllllllllllllIIllllIIIlllIlIIIII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIIllllIIIlllIIlllIl, lllllllllllllIIllllIIIlllIlIIIII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIllllIIIlllIIlllIl, lllllllllllllIIllllIIIlllIlIIIII, 0, 0, 0, 4, 4, 4, true, lllllllllllllIIllllIIIlllIlIIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIIllllIIIlllIIlllIl, lllllllllllllIIllllIIIlllIlIIIIl, lllllllllllllIIllllIIIlllIlIIIII, this.entryDoor, 1, 1, 0);
            final EnumFacing lllllllllllllIIllllIIIlllIIlllll = this.getCoordBaseMode();
            if (lllllllllllllIIllllIIIlllIIlllll != EnumFacing.NORTH && lllllllllllllIIllllIIIlllIIlllll != EnumFacing.EAST) {
                this.fillWithBlocks(lllllllllllllIIllllIIIlllIIlllIl, lllllllllllllIIllllIIIlllIlIIIII, 0, 1, 1, 0, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(lllllllllllllIIllllIIIlllIIlllIl, lllllllllllllIIllllIIIlllIlIIIII, 4, 1, 1, 4, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
    }
    
    public static class LeftTurn extends Stronghold
    {
        public static LeftTurn createPiece(final List<StructureComponent> llllllllllIllllIIIlIIIIlIIllIlll, final Random llllllllllIllllIIIlIIIIlIIlIlllI, final int llllllllllIllllIIIlIIIIlIIllIlIl, final int llllllllllIllllIIIlIIIIlIIlIllII, final int llllllllllIllllIIIlIIIIlIIllIIll, final EnumFacing llllllllllIllllIIIlIIIIlIIlIlIlI, final int llllllllllIllllIIIlIIIIlIIllIIIl) {
            final StructureBoundingBox llllllllllIllllIIIlIIIIlIIllIIII = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllIllllIIIlIIIIlIIllIlIl, llllllllllIllllIIIlIIIIlIIlIllII, llllllllllIllllIIIlIIIIlIIllIIll, -1, -1, 0, 5, 5, 5, llllllllllIllllIIIlIIIIlIIlIlIlI);
            return (Stronghold.canStrongholdGoDeeper(llllllllllIllllIIIlIIIIlIIllIIII) && StructureComponent.findIntersecting(llllllllllIllllIIIlIIIIlIIllIlll, llllllllllIllllIIIlIIIIlIIllIIII) == null) ? new LeftTurn(llllllllllIllllIIIlIIIIlIIllIIIl, llllllllllIllllIIIlIIIIlIIlIlllI, llllllllllIllllIIIlIIIIlIIllIIII, llllllllllIllllIIIlIIIIlIIlIlIlI) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIllllIIIlIIIIlIIlIIIIl, final Random llllllllllIllllIIIlIIIIlIIIllIll, final StructureBoundingBox llllllllllIllllIIIlIIIIlIIIlllll) {
            if (this.isLiquidInStructureBoundingBox(llllllllllIllllIIIlIIIIlIIlIIIIl, llllllllllIllllIIIlIIIIlIIIlllll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllIllllIIIlIIIIlIIlIIIIl, llllllllllIllllIIIlIIIIlIIIlllll, 0, 0, 0, 4, 4, 4, true, llllllllllIllllIIIlIIIIlIIIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllllIllllIIIlIIIIlIIlIIIIl, llllllllllIllllIIIlIIIIlIIIllIll, llllllllllIllllIIIlIIIIlIIIlllll, this.entryDoor, 1, 1, 0);
            final EnumFacing llllllllllIllllIIIlIIIIlIIIllllI = this.getCoordBaseMode();
            if (llllllllllIllllIIIlIIIIlIIIllllI != EnumFacing.NORTH && llllllllllIllllIIIlIIIIlIIIllllI != EnumFacing.EAST) {
                this.fillWithBlocks(llllllllllIllllIIIlIIIIlIIlIIIIl, llllllllllIllllIIIlIIIIlIIIlllll, 4, 1, 1, 4, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(llllllllllIllllIIIlIIIIlIIlIIIIl, llllllllllIllllIIIlIIIIlIIIlllll, 0, 1, 1, 0, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        public LeftTurn() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllIllllIIIlIIIIlIlIIIIll, final List<StructureComponent> llllllllllIllllIIIlIIIIlIlIIIIlI, final Random llllllllllIllllIIIlIIIIlIlIIIIIl) {
            final EnumFacing llllllllllIllllIIIlIIIIlIlIIIlIl = this.getCoordBaseMode();
            if (llllllllllIllllIIIlIIIIlIlIIIlIl != EnumFacing.NORTH && llllllllllIllllIIIlIIIIlIlIIIlIl != EnumFacing.EAST) {
                this.getNextComponentZ((Stairs2)llllllllllIllllIIIlIIIIlIlIIIIll, llllllllllIllllIIIlIIIIlIlIIIIlI, llllllllllIllllIIIlIIIIlIlIIIIIl, 1, 1);
            }
            else {
                this.getNextComponentX((Stairs2)llllllllllIllllIIIlIIIIlIlIIIIll, llllllllllIllllIIIlIIIIlIlIIIIlI, llllllllllIllllIIIlIIIIlIlIIIIIl, 1, 1);
            }
        }
        
        public LeftTurn(final int llllllllllIllllIIIlIIIIlIlIlIIlI, final Random llllllllllIllllIIIlIIIIlIlIlIIIl, final StructureBoundingBox llllllllllIllllIIIlIIIIlIlIlIlIl, final EnumFacing llllllllllIllllIIIlIIIIlIlIlIlII) {
            super(llllllllllIllllIIIlIIIIlIlIlIIlI);
            this.setCoordBaseMode(llllllllllIllllIIIlIIIIlIlIlIlII);
            this.entryDoor = this.getRandomDoor(llllllllllIllllIIIlIIIIlIlIlIIIl);
            this.boundingBox = llllllllllIllllIIIlIIIIlIlIlIlIl;
        }
    }
    
    public static class StairsStraight extends Stronghold
    {
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIlIIllIlIlIIIlIII, final List<StructureComponent> llllllllllllllIIlIIllIlIlIIIIlll, final Random llllllllllllllIIlIIllIlIlIIIIllI) {
            this.getNextComponentNormal((Stairs2)llllllllllllllIIlIIllIlIlIIIlIII, llllllllllllllIIlIIllIlIlIIIIlll, llllllllllllllIIlIIllIlIlIIIIllI, 1, 1);
        }
        
        public StairsStraight(final int llllllllllllllIIlIIllIlIlIIlIllI, final Random llllllllllllllIIlIIllIlIlIIlIlIl, final StructureBoundingBox llllllllllllllIIlIIllIlIlIIlIlII, final EnumFacing llllllllllllllIIlIIllIlIlIIIlllI) {
            super(llllllllllllllIIlIIllIlIlIIlIllI);
            this.setCoordBaseMode(llllllllllllllIIlIIllIlIlIIIlllI);
            this.entryDoor = this.getRandomDoor(llllllllllllllIIlIIllIlIlIIlIlIl);
            this.boundingBox = llllllllllllllIIlIIllIlIlIIlIlII;
        }
        
        public static StairsStraight createPiece(final List<StructureComponent> llllllllllllllIIlIIllIlIIlllIIIl, final Random llllllllllllllIIlIIllIlIIlllIIII, final int llllllllllllllIIlIIllIlIIlllIlll, final int llllllllllllllIIlIIllIlIIllIlllI, final int llllllllllllllIIlIIllIlIIllIllIl, final EnumFacing llllllllllllllIIlIIllIlIIlllIlII, final int llllllllllllllIIlIIllIlIIlllIIll) {
            final StructureBoundingBox llllllllllllllIIlIIllIlIIlllIIlI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIllIlIIlllIlll, llllllllllllllIIlIIllIlIIllIlllI, llllllllllllllIIlIIllIlIIllIllIl, -1, -7, 0, 5, 11, 8, llllllllllllllIIlIIllIlIIlllIlII);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllllIIlIIllIlIIlllIIlI) && StructureComponent.findIntersecting(llllllllllllllIIlIIllIlIIlllIIIl, llllllllllllllIIlIIllIlIIlllIIlI) == null) ? new StairsStraight(llllllllllllllIIlIIllIlIIlllIIll, llllllllllllllIIlIIllIlIIlllIIII, llllllllllllllIIlIIllIlIIlllIIlI, llllllllllllllIIlIIllIlIIlllIlII) : null;
        }
        
        public StairsStraight() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIllIlIIlIlllII, final Random llllllllllllllIIlIIllIlIIlIllIll, final StructureBoundingBox llllllllllllllIIlIIllIlIIllIIIII) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIllIIIII)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIllIIIII, 0, 0, 0, 4, 10, 7, true, llllllllllllllIIlIIllIlIIlIllIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIlIllIll, llllllllllllllIIlIIllIlIIllIIIII, this.entryDoor, 1, 7, 0);
            this.placeDoor(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIlIllIll, llllllllllllllIIlIIllIlIIllIIIII, Door.OPENING, 1, 1, 7);
            final IBlockState llllllllllllllIIlIIllIlIIlIlllll = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            for (int llllllllllllllIIlIIllIlIIlIllllI = 0; llllllllllllllIIlIIllIlIIlIllllI < 6; ++llllllllllllllIIlIIllIlIIlIllllI) {
                this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIlIlllll, 1, 6 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIlIlllll, 2, 6 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, llllllllllllllIIlIIllIlIIlIlllll, 3, 6 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                if (llllllllllllllIIlIIllIlIIlIllllI < 5) {
                    this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, Blocks.STONEBRICK.getDefaultState(), 1, 5 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                    this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, Blocks.STONEBRICK.getDefaultState(), 2, 5 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                    this.setBlockState(llllllllllllllIIlIIllIlIIlIlllII, Blocks.STONEBRICK.getDefaultState(), 3, 5 - llllllllllllllIIlIIllIlIIlIllllI, 1 + llllllllllllllIIlIIllIlIIlIllllI, llllllllllllllIIlIIllIlIIllIIIII);
                }
            }
            return true;
        }
    }
    
    public static class Library extends Stronghold
    {
        private /* synthetic */ boolean isLargeRoom;
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllllIIIIllIIIIlIlll, final Random lllllllllllIIllllIIIIllIIIIlIllI, final StructureBoundingBox lllllllllllIIllllIIIIllIIIlIIIlI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI)) {
                return false;
            }
            int lllllllllllIIllllIIIIllIIIlIIIIl = 11;
            if (!this.isLargeRoom) {
                lllllllllllIIllllIIIIllIIIlIIIIl = 6;
            }
            this.fillWithRandomizedBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 0, 0, 0, 13, lllllllllllIIllllIIIIllIIIlIIIIl - 1, 14, true, lllllllllllIIllllIIIIllIIIIlIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlIllI, lllllllllllIIllllIIIIllIIIlIIIlI, this.entryDoor, 4, 1, 0);
            this.func_189914_a(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, lllllllllllIIllllIIIIllIIIIlIllI, 0.07f, 2, 1, 1, 11, 4, 13, Blocks.WEB.getDefaultState(), Blocks.WEB.getDefaultState(), false, 0);
            final int lllllllllllIIllllIIIIllIIIlIIIII = 1;
            final int lllllllllllIIllllIIIIllIIIIlllll = 12;
            for (int lllllllllllIIllllIIIIllIIIIllllI = 1; lllllllllllIIllllIIIIllIIIIllllI <= 13; ++lllllllllllIIllllIIIIllIIIIllllI) {
                if ((lllllllllllIIllllIIIIllIIIIllllI - 1) % 4 == 0) {
                    this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 1, 1, lllllllllllIIllllIIIIllIIIIllllI, 1, 4, lllllllllllIIllllIIIIllIIIIllllI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 12, 1, lllllllllllIIllllIIIIllIIIIllllI, 12, 4, lllllllllllIIllllIIIIllIIIIllllI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST), 2, 3, lllllllllllIIllllIIIIllIIIIllllI, lllllllllllIIllllIIIIllIIIlIIIlI);
                    this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST), 11, 3, lllllllllllIIllllIIIIllIIIIllllI, lllllllllllIIllllIIIIllIIIlIIIlI);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 1, 6, lllllllllllIIllllIIIIllIIIIllllI, 1, 9, lllllllllllIIllllIIIIllIIIIllllI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                        this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 12, 6, lllllllllllIIllllIIIIllIIIIllllI, 12, 9, lllllllllllIIllllIIIIllIIIIllllI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    }
                }
                else {
                    this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 1, 1, lllllllllllIIllllIIIIllIIIIllllI, 1, 4, lllllllllllIIllllIIIIllIIIIllllI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 12, 1, lllllllllllIIllllIIIIllIIIIllllI, 12, 4, lllllllllllIIllllIIIIllIIIIllllI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 1, 6, lllllllllllIIllllIIIIllIIIIllllI, 1, 9, lllllllllllIIllllIIIIllIIIIllllI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                        this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 12, 6, lllllllllllIIllllIIIIllIIIIllllI, 12, 9, lllllllllllIIllllIIIIllIIIIllllI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    }
                }
            }
            for (int lllllllllllIIllllIIIIllIIIIlllIl = 3; lllllllllllIIllllIIIIllIIIIlllIl < 12; lllllllllllIIllllIIIIllIIIIlllIl += 2) {
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 3, 1, lllllllllllIIllllIIIIllIIIIlllIl, 4, 3, lllllllllllIIllllIIIIllIIIIlllIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 6, 1, lllllllllllIIllllIIIIllIIIIlllIl, 7, 3, lllllllllllIIllllIIIIllIIIIlllIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 9, 1, lllllllllllIIllllIIIIllIIIIlllIl, 10, 3, lllllllllllIIllllIIIIllIIIIlllIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
            }
            if (this.isLargeRoom) {
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 1, 5, 1, 3, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 10, 5, 1, 12, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 4, 5, 1, 9, 5, 2, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 4, 5, 12, 9, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.PLANKS.getDefaultState(), 9, 5, 11, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.PLANKS.getDefaultState(), 8, 5, 11, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.PLANKS.getDefaultState(), 9, 5, 10, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 3, 6, 2, 3, 6, 12, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 10, 6, 2, 10, 6, 10, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 4, 6, 2, 9, 6, 2, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, 4, 6, 12, 8, 6, 12, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 9, 6, 11, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 8, 6, 11, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 9, 6, 10, lllllllllllIIllllIIIIllIIIlIIIlI);
                final IBlockState lllllllllllIIllllIIIIllIIIIlllII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.SOUTH);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 1, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 2, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 3, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 4, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 5, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 6, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIlllII, 10, 7, 13, lllllllllllIIllllIIIIllIIIlIIIlI);
                final int lllllllllllIIllllIIIIllIIIIllIll = 7;
                final int lllllllllllIIllllIIIIllIIIIllIlI = 7;
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 6, 9, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 7, 9, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 6, 8, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 7, 8, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 5, 7, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 8, 7, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 6, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 8, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 6, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 8, lllllllllllIIllllIIIIllIIIlIIIlI);
                final IBlockState lllllllllllIIllllIIIIllIIIIllIIl = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 5, 8, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 8, 8, 7, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 6, 8, 6, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 6, 8, 8, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 7, 8, 6, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIIllIIl, 7, 8, 8, lllllllllllIIllllIIIIllIIIlIIIlI);
            }
            this.generateChest(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, lllllllllllIIllllIIIIllIIIIlIllI, 3, 3, 5, LootTableList.CHESTS_STRONGHOLD_LIBRARY);
            if (this.isLargeRoom) {
                this.setBlockState(lllllllllllIIllllIIIIllIIIIlIlll, Blocks.AIR.getDefaultState(), 12, 9, 1, lllllllllllIIllllIIIIllIIIlIIIlI);
                this.generateChest(lllllllllllIIllllIIIIllIIIIlIlll, lllllllllllIIllllIIIIllIIIlIIIlI, lllllllllllIIllllIIIIllIIIIlIllI, 12, 8, 1, LootTableList.CHESTS_STRONGHOLD_LIBRARY);
            }
            return true;
        }
        
        public static Library createPiece(final List<StructureComponent> lllllllllllIIllllIIIIllIIIlllIII, final Random lllllllllllIIllllIIIIllIIIllIlll, final int lllllllllllIIllllIIIIllIIIlllllI, final int lllllllllllIIllllIIIIllIIIllIlIl, final int lllllllllllIIllllIIIIllIIIllllII, final EnumFacing lllllllllllIIllllIIIIllIIIlllIll, final int lllllllllllIIllllIIIIllIIIlllIlI) {
            StructureBoundingBox lllllllllllIIllllIIIIllIIIlllIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllllIIIIllIIIlllllI, lllllllllllIIllllIIIIllIIIllIlIl, lllllllllllIIllllIIIIllIIIllllII, -4, -1, 0, 14, 11, 15, lllllllllllIIllllIIIIllIIIlllIll);
            if (!Stronghold.canStrongholdGoDeeper(lllllllllllIIllllIIIIllIIIlllIIl) || StructureComponent.findIntersecting(lllllllllllIIllllIIIIllIIIlllIII, lllllllllllIIllllIIIIllIIIlllIIl) != null) {
                lllllllllllIIllllIIIIllIIIlllIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllllIIIIllIIIlllllI, lllllllllllIIllllIIIIllIIIllIlIl, lllllllllllIIllllIIIIllIIIllllII, -4, -1, 0, 14, 6, 15, lllllllllllIIllllIIIIllIIIlllIll);
                if (!Stronghold.canStrongholdGoDeeper(lllllllllllIIllllIIIIllIIIlllIIl) || StructureComponent.findIntersecting(lllllllllllIIllllIIIIllIIIlllIII, lllllllllllIIllllIIIIllIIIlllIIl) != null) {
                    return null;
                }
            }
            return new Library(lllllllllllIIllllIIIIllIIIlllIlI, lllllllllllIIllllIIIIllIIIllIlll, lllllllllllIIllllIIIIllIIIlllIIl, lllllllllllIIllllIIIIllIIIlllIll);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIllllIIIIllIIlIlIIlI) {
            super.writeStructureToNBT(lllllllllllIIllllIIIIllIIlIlIIlI);
            lllllllllllIIllllIIIIllIIlIlIIlI.setBoolean("Tall", this.isLargeRoom);
        }
        
        public Library(final int lllllllllllIIllllIIIIllIIlIllIll, final Random lllllllllllIIllllIIIIllIIlIlllll, final StructureBoundingBox lllllllllllIIllllIIIIllIIlIllIIl, final EnumFacing lllllllllllIIllllIIIIllIIlIlllIl) {
            super(lllllllllllIIllllIIIIllIIlIllIll);
            this.setCoordBaseMode(lllllllllllIIllllIIIIllIIlIlllIl);
            this.entryDoor = this.getRandomDoor(lllllllllllIIllllIIIIllIIlIlllll);
            this.boundingBox = lllllllllllIIllllIIIIllIIlIllIIl;
            this.isLargeRoom = (lllllllllllIIllllIIIIllIIlIllIIl.getYSize() > 6);
        }
        
        public Library() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIllllIIIIllIIlIIllIl, final TemplateManager lllllllllllIIllllIIIIllIIlIIllII) {
            super.readStructureFromNBT(lllllllllllIIllllIIIIllIIlIIllIl, lllllllllllIIllllIIIIllIIlIIllII);
            this.isLargeRoom = lllllllllllIIllllIIIIllIIlIIllIl.getBoolean("Tall");
        }
    }
}
