// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import java.util.List;

public class StructureNetherBridgePieces
{
    private static final /* synthetic */ PieceWeight[] PRIMARY_COMPONENTS;
    private static final /* synthetic */ PieceWeight[] SECONDARY_COMPONENTS;
    
    static {
        PRIMARY_COMPONENTS = new PieceWeight[] { new PieceWeight(Straight.class, 30, 0, true), new PieceWeight(Crossing3.class, 10, 4), new PieceWeight(Crossing.class, 10, 4), new PieceWeight(Stairs.class, 10, 3), new PieceWeight(Throne.class, 5, 2), new PieceWeight(Entrance.class, 5, 1) };
        SECONDARY_COMPONENTS = new PieceWeight[] { new PieceWeight(Corridor5.class, 25, 0, true), new PieceWeight(Crossing2.class, 15, 5), new PieceWeight(Corridor2.class, 5, 10), new PieceWeight(Corridor.class, 5, 10), new PieceWeight(Corridor3.class, 10, 3, true), new PieceWeight(Corridor4.class, 7, 2), new PieceWeight(NetherStalkRoom.class, 5, 2) };
    }
    
    public static void registerNetherFortressPieces() {
        MapGenStructureIO.registerStructureComponent(Crossing3.class, "NeBCr");
        MapGenStructureIO.registerStructureComponent(End.class, "NeBEF");
        MapGenStructureIO.registerStructureComponent(Straight.class, "NeBS");
        MapGenStructureIO.registerStructureComponent(Corridor3.class, "NeCCS");
        MapGenStructureIO.registerStructureComponent(Corridor4.class, "NeCTB");
        MapGenStructureIO.registerStructureComponent(Entrance.class, "NeCE");
        MapGenStructureIO.registerStructureComponent(Crossing2.class, "NeSCSC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "NeSCLT");
        MapGenStructureIO.registerStructureComponent(Corridor5.class, "NeSC");
        MapGenStructureIO.registerStructureComponent(Corridor2.class, "NeSCRT");
        MapGenStructureIO.registerStructureComponent(NetherStalkRoom.class, "NeCSR");
        MapGenStructureIO.registerStructureComponent(Throne.class, "NeMT");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "NeRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "NeSR");
        MapGenStructureIO.registerStructureComponent(Start.class, "NeStart");
    }
    
    private static Piece findAndCreateBridgePieceFactory(final PieceWeight lllllllllllIllIIlIllIIIlIlIIIIII, final List<StructureComponent> lllllllllllIllIIlIllIIIlIIllllll, final Random lllllllllllIllIIlIllIIIlIIlllllI, final int lllllllllllIllIIlIllIIIlIIllIIll, final int lllllllllllIllIIlIllIIIlIIllIIlI, final int lllllllllllIllIIlIllIIIlIIlllIll, final EnumFacing lllllllllllIllIIlIllIIIlIIllIIII, final int lllllllllllIllIIlIllIIIlIIlIllll) {
        final Class<? extends Piece> lllllllllllIllIIlIllIIIlIIlllIII = lllllllllllIllIIlIllIIIlIlIIIIII.weightClass;
        Piece lllllllllllIllIIlIllIIIlIIllIlll = null;
        if (lllllllllllIllIIlIllIIIlIIlllIII == Straight.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Straight.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Crossing3.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Crossing3.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Crossing.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Crossing.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Stairs.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Stairs.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIlIllll, lllllllllllIllIIlIllIIIlIIllIIII);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Throne.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Throne.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIlIllll, lllllllllllIllIIlIllIIIlIIllIIII);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Entrance.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Entrance.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Corridor5.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Corridor5.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Corridor2.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Corridor2.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Corridor.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Corridor.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Corridor3.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Corridor3.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Corridor4.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Corridor4.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == Crossing2.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = Crossing2.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        else if (lllllllllllIllIIlIllIIIlIIlllIII == NetherStalkRoom.class) {
            lllllllllllIllIIlIllIIIlIIllIlll = NetherStalkRoom.createPiece(lllllllllllIllIIlIllIIIlIIllllll, lllllllllllIllIIlIllIIIlIIlllllI, lllllllllllIllIIlIllIIIlIIllIIll, lllllllllllIllIIlIllIIIlIIllIIlI, lllllllllllIllIIlIllIIIlIIlllIll, lllllllllllIllIIlIllIIIlIIllIIII, lllllllllllIllIIlIllIIIlIIlIllll);
        }
        return lllllllllllIllIIlIllIIIlIIllIlll;
    }
    
    public static class End extends Piece
    {
        private /* synthetic */ int fillSeed;
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIIllIllIllIIIIIllI, final Random llllllllllIlllIIllIllIllIIIIIlIl, final StructureBoundingBox llllllllllIlllIIllIllIllIIIIIlII) {
            final Random llllllllllIlllIIllIllIllIIIIIIll = new Random(this.fillSeed);
            for (int llllllllllIlllIIllIllIllIIIIIIlI = 0; llllllllllIlllIIllIllIllIIIIIIlI <= 4; ++llllllllllIlllIIllIllIllIIIIIIlI) {
                for (int llllllllllIlllIIllIllIllIIIIIIIl = 3; llllllllllIlllIIllIllIllIIIIIIIl <= 4; ++llllllllllIlllIIllIllIllIIIIIIIl) {
                    final int llllllllllIlllIIllIllIllIIIIIIII = llllllllllIlllIIllIllIllIIIIIIll.nextInt(8);
                    this.fillWithBlocks(llllllllllIlllIIllIllIllIIIIIllI, llllllllllIlllIIllIllIllIIIIIlII, llllllllllIlllIIllIllIllIIIIIIlI, llllllllllIlllIIllIllIllIIIIIIIl, 0, llllllllllIlllIIllIllIllIIIIIIlI, llllllllllIlllIIllIllIllIIIIIIIl, llllllllllIlllIIllIllIllIIIIIIII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
            }
            int llllllllllIlllIIllIllIlIllllllll = llllllllllIlllIIllIllIllIIIIIIll.nextInt(8);
            this.fillWithBlocks(llllllllllIlllIIllIllIllIIIIIllI, llllllllllIlllIIllIllIllIIIIIlII, 0, 5, 0, 0, 5, llllllllllIlllIIllIllIlIllllllll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            llllllllllIlllIIllIllIlIllllllll = llllllllllIlllIIllIllIllIIIIIIll.nextInt(8);
            this.fillWithBlocks(llllllllllIlllIIllIllIllIIIIIllI, llllllllllIlllIIllIllIllIIIIIlII, 4, 5, 0, 4, 5, llllllllllIlllIIllIllIlIllllllll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllIlllIIllIllIlIlllllllI = 0; llllllllllIlllIIllIllIlIlllllllI <= 4; ++llllllllllIlllIIllIllIlIlllllllI) {
                final int llllllllllIlllIIllIllIlIllllllIl = llllllllllIlllIIllIllIllIIIIIIll.nextInt(5);
                this.fillWithBlocks(llllllllllIlllIIllIllIllIIIIIllI, llllllllllIlllIIllIllIllIIIIIlII, llllllllllIlllIIllIllIlIlllllllI, 2, 0, llllllllllIlllIIllIllIlIlllllllI, 2, llllllllllIlllIIllIllIlIllllllIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            }
            for (int llllllllllIlllIIllIllIlIllllllII = 0; llllllllllIlllIIllIllIlIllllllII <= 4; ++llllllllllIlllIIllIllIlIllllllII) {
                for (int llllllllllIlllIIllIllIlIlllllIll = 0; llllllllllIlllIIllIllIlIlllllIll <= 1; ++llllllllllIlllIIllIllIlIlllllIll) {
                    final int llllllllllIlllIIllIllIlIlllllIlI = llllllllllIlllIIllIllIllIIIIIIll.nextInt(3);
                    this.fillWithBlocks(llllllllllIlllIIllIllIllIIIIIllI, llllllllllIlllIIllIllIllIIIIIlII, llllllllllIlllIIllIllIlIllllllII, llllllllllIlllIIllIllIlIlllllIll, 0, llllllllllIlllIIllIllIlIllllllII, llllllllllIlllIIllIllIlIlllllIll, llllllllllIlllIIllIllIlIlllllIlI, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
            }
            return true;
        }
        
        public End(final int llllllllllIlllIIllIllIllIIllllll, final Random llllllllllIlllIIllIllIllIIlllllI, final StructureBoundingBox llllllllllIlllIIllIllIllIIlllIII, final EnumFacing llllllllllIlllIIllIllIllIIllIlll) {
            super(llllllllllIlllIIllIllIllIIllllll);
            this.setCoordBaseMode(llllllllllIlllIIllIllIllIIllIlll);
            this.boundingBox = llllllllllIlllIIllIllIllIIlllIII;
            this.fillSeed = llllllllllIlllIIllIllIllIIlllllI.nextInt();
        }
        
        public static End createPiece(final List<StructureComponent> llllllllllIlllIIllIllIllIIlIlllI, final Random llllllllllIlllIIllIllIllIIlIIlIl, final int llllllllllIlllIIllIllIllIIlIIlII, final int llllllllllIlllIIllIllIllIIlIIIll, final int llllllllllIlllIIllIllIllIIlIlIlI, final EnumFacing llllllllllIlllIIllIllIllIIlIlIIl, final int llllllllllIlllIIllIllIllIIlIlIII) {
            final StructureBoundingBox llllllllllIlllIIllIllIllIIlIIlll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllIlllIIllIllIllIIlIIlII, llllllllllIlllIIllIllIllIIlIIIll, llllllllllIlllIIllIllIllIIlIlIlI, -1, -3, 0, 5, 10, 8, llllllllllIlllIIllIllIllIIlIlIIl);
            return (Piece.isAboveGround(llllllllllIlllIIllIllIllIIlIIlll) && StructureComponent.findIntersecting(llllllllllIlllIIllIllIllIIlIlllI, llllllllllIlllIIllIllIllIIlIIlll) == null) ? new End(llllllllllIlllIIllIllIllIIlIlIII, llllllllllIlllIIllIllIllIIlIIlIl, llllllllllIlllIIllIllIllIIlIIlll, llllllllllIlllIIllIllIllIIlIlIIl) : null;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllIlllIIllIllIllIIIlIIlI) {
            super.writeStructureToNBT(llllllllllIlllIIllIllIllIIIlIIlI);
            llllllllllIlllIIllIllIllIIIlIIlI.setInteger("Seed", this.fillSeed);
        }
        
        public End() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllIlllIIllIllIllIIIllIlI, final TemplateManager llllllllllIlllIIllIllIllIIIllIIl) {
            super.readStructureFromNBT(llllllllllIlllIIllIllIllIIIllIlI, llllllllllIlllIIllIllIllIIIllIIl);
            this.fillSeed = llllllllllIlllIIllIllIllIIIllIlI.getInteger("Seed");
        }
    }
    
    abstract static class Piece extends StructureComponent
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIlIIIIIlIIlIIIIlllIl, final TemplateManager lllllllllllIIlIIIIIlIIlIIIIlllII) {
        }
        
        public Piece() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIlIIIIIlIIlIIIIllIlI) {
        }
        
        @Nullable
        protected StructureComponent getNextComponentNormal(final Start lllllllllllIIlIIIIIlIIIllIlIIIll, final List<StructureComponent> lllllllllllIIlIIIIIlIIIllIlIlIlI, final Random lllllllllllIIlIIIIIlIIIllIlIlIIl, final int lllllllllllIIlIIIIIlIIIllIlIlIII, final int lllllllllllIIlIIIIIlIIIllIlIIlll, final boolean lllllllllllIIlIIIIIlIIIllIIllllI) {
            final EnumFacing lllllllllllIIlIIIIIlIIIllIlIIlIl = this.getCoordBaseMode();
            if (lllllllllllIIlIIIIIlIIIllIlIIlIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIIIIlIIIllIlIIlIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIlIIIll, lllllllllllIIlIIIIIlIIIllIlIlIlI, lllllllllllIIlIIIIIlIIIllIlIlIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIllIlIlIII, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIlIIlll, this.boundingBox.minZ - 1, lllllllllllIIlIIIIIlIIIllIlIIlIl, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIllllI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIlIIIll, lllllllllllIIlIIIIIlIIIllIlIlIlI, lllllllllllIIlIIIIIlIIIllIlIlIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIllIlIlIII, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIlIIlll, this.boundingBox.maxZ + 1, lllllllllllIIlIIIIIlIIIllIlIIlIl, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIllllI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIlIIIll, lllllllllllIIlIIIIIlIIIllIlIlIlI, lllllllllllIIlIIIIIlIIIllIlIlIIl, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIlIIlll, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIllIlIlIII, lllllllllllIIlIIIIIlIIIllIlIIlIl, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIllllI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIlIIIll, lllllllllllIIlIIIIIlIIIllIlIlIlI, lllllllllllIIlIIIIIlIIIllIlIlIIl, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIlIIlll, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIllIlIlIII, lllllllllllIIlIIIIIlIIIllIlIIlIl, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIllllI);
                    }
                }
            }
            return null;
        }
        
        private Piece generatePiece(final Start lllllllllllIIlIIIIIlIIIllllllIII, final List<PieceWeight> lllllllllllIIlIIIIIlIIIlllllIlll, final List<StructureComponent> lllllllllllIIlIIIIIlIIIllllIIllI, final Random lllllllllllIIlIIIIIlIIIllllIIlIl, final int lllllllllllIIlIIIIIlIIIllllIIlII, final int lllllllllllIIlIIIIIlIIIllllIIIll, final int lllllllllllIIlIIIIIlIIIllllIIIlI, final EnumFacing lllllllllllIIlIIIIIlIIIlllllIIIl, final int lllllllllllIIlIIIIIlIIIlllllIIII) {
            final int lllllllllllIIlIIIIIlIIIllllIllll = this.getTotalWeight(lllllllllllIIlIIIIIlIIIlllllIlll);
            final boolean lllllllllllIIlIIIIIlIIIllllIlllI = lllllllllllIIlIIIIIlIIIllllIllll > 0 && lllllllllllIIlIIIIIlIIIlllllIIII <= 30;
            int lllllllllllIIlIIIIIlIIIllllIllIl = 0;
            while (lllllllllllIIlIIIIIlIIIllllIllIl < 5 && lllllllllllIIlIIIIIlIIIllllIlllI) {
                ++lllllllllllIIlIIIIIlIIIllllIllIl;
                int lllllllllllIIlIIIIIlIIIllllIllII = lllllllllllIIlIIIIIlIIIllllIIlIl.nextInt(lllllllllllIIlIIIIIlIIIllllIllll);
                for (final PieceWeight lllllllllllIIlIIIIIlIIIllllIlIll : lllllllllllIIlIIIIIlIIIlllllIlll) {
                    lllllllllllIIlIIIIIlIIIllllIllII -= lllllllllllIIlIIIIIlIIIllllIlIll.weight;
                    if (lllllllllllIIlIIIIIlIIIllllIllII < 0) {
                        if (!lllllllllllIIlIIIIIlIIIllllIlIll.doPlace(lllllllllllIIlIIIIIlIIIlllllIIII)) {
                            break;
                        }
                        if (lllllllllllIIlIIIIIlIIIllllIlIll == lllllllllllIIlIIIIIlIIIllllllIII.theNetherBridgePieceWeight && !lllllllllllIIlIIIIIlIIIllllIlIll.allowInRow) {
                            break;
                        }
                        final Piece lllllllllllIIlIIIIIlIIIllllIlIlI = findAndCreateBridgePieceFactory(lllllllllllIIlIIIIIlIIIllllIlIll, lllllllllllIIlIIIIIlIIIllllIIllI, lllllllllllIIlIIIIIlIIIllllIIlIl, lllllllllllIIlIIIIIlIIIllllIIlII, lllllllllllIIlIIIIIlIIIllllIIIll, lllllllllllIIlIIIIIlIIIllllIIIlI, lllllllllllIIlIIIIIlIIIlllllIIIl, lllllllllllIIlIIIIIlIIIlllllIIII);
                        if (lllllllllllIIlIIIIIlIIIllllIlIlI != null) {
                            final PieceWeight pieceWeight = lllllllllllIIlIIIIIlIIIllllIlIll;
                            ++pieceWeight.placeCount;
                            lllllllllllIIlIIIIIlIIIllllllIII.theNetherBridgePieceWeight = lllllllllllIIlIIIIIlIIIllllIlIll;
                            if (!lllllllllllIIlIIIIIlIIIllllIlIll.isValid()) {
                                lllllllllllIIlIIIIIlIIIlllllIlll.remove(lllllllllllIIlIIIIIlIIIllllIlIll);
                            }
                            return lllllllllllIIlIIIIIlIIIllllIlIlI;
                        }
                        continue;
                    }
                }
            }
            return End.createPiece(lllllllllllIIlIIIIIlIIIllllIIllI, lllllllllllIIlIIIIIlIIIllllIIlIl, lllllllllllIIlIIIIIlIIIllllIIlII, lllllllllllIIlIIIIIlIIIllllIIIll, lllllllllllIIlIIIIIlIIIllllIIIlI, lllllllllllIIlIIIIIlIIIlllllIIIl, lllllllllllIIlIIIIIlIIIlllllIIII);
        }
        
        @Nullable
        protected StructureComponent getNextComponentZ(final Start lllllllllllIIlIIIIIlIIIlIllllIll, final List<StructureComponent> lllllllllllIIlIIIIIlIIIlIlllIIlI, final Random lllllllllllIIlIIIIIlIIIlIlllIIIl, final int lllllllllllIIlIIIIIlIIIlIllllIII, final int lllllllllllIIlIIIIIlIIIlIlllIlll, final boolean lllllllllllIIlIIIIIlIIIlIlllIllI) {
            final EnumFacing lllllllllllIIlIIIIIlIIIlIlllIlIl = this.getCoordBaseMode();
            if (lllllllllllIIlIIIIIlIIIlIlllIlIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIIIIlIIIlIlllIlIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIlIllllIll, lllllllllllIIlIIIIIlIIIlIlllIIlI, lllllllllllIIlIIIIIlIIIlIlllIIIl, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIlIllllIII, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIlIlllIlll, EnumFacing.EAST, this.getComponentType(), lllllllllllIIlIIIIIlIIIlIlllIllI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIlIllllIll, lllllllllllIIlIIIIIlIIIlIlllIIlI, lllllllllllIIlIIIIIlIIIlIlllIIIl, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIlIllllIII, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIlIlllIlll, EnumFacing.EAST, this.getComponentType(), lllllllllllIIlIIIIIlIIIlIlllIllI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIlIllllIll, lllllllllllIIlIIIIIlIIIlIlllIIlI, lllllllllllIIlIIIIIlIIIlIlllIIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIlIlllIlll, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIlIllllIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), lllllllllllIIlIIIIIlIIIlIlllIllI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIlIllllIll, lllllllllllIIlIIIIIlIIIlIlllIIlI, lllllllllllIIlIIIIIlIIIlIlllIIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIlIlllIlll, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIlIllllIII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), lllllllllllIIlIIIIIlIIIlIlllIllI);
                    }
                }
            }
            return null;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final boolean lllllllllllIIlIIIIIlIIIlIllIlIII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllIIlIIIIIlIIIlIllIlIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIIlIIIIIlIIIlIllIlIII;
        }
        
        private int getTotalWeight(final List<PieceWeight> lllllllllllIIlIIIIIlIIlIIIIlIIll) {
            boolean lllllllllllIIlIIIIIlIIlIIIIlIIlI = false;
            int lllllllllllIIlIIIIIlIIlIIIIlIIIl = 0;
            for (final PieceWeight lllllllllllIIlIIIIIlIIlIIIIlIIII : lllllllllllIIlIIIIIlIIlIIIIlIIll) {
                if (lllllllllllIIlIIIIIlIIlIIIIlIIII.maxPlaceCount > 0 && lllllllllllIIlIIIIIlIIlIIIIlIIII.placeCount < lllllllllllIIlIIIIIlIIlIIIIlIIII.maxPlaceCount) {
                    lllllllllllIIlIIIIIlIIlIIIIlIIlI = true;
                }
                lllllllllllIIlIIIIIlIIlIIIIlIIIl += lllllllllllIIlIIIIIlIIlIIIIlIIII.weight;
            }
            return lllllllllllIIlIIIIIlIIlIIIIlIIlI ? lllllllllllIIlIIIIIlIIlIIIIlIIIl : -1;
        }
        
        protected Piece(final int lllllllllllIIlIIIIIlIIlIIIIlllll) {
            super(lllllllllllIIlIIIIIlIIlIIIIlllll);
        }
        
        protected static boolean isAboveGround(final StructureBoundingBox lllllllllllIIlIIIIIlIIIlIllIlIlI) {
            return lllllllllllIIlIIIIIlIIIlIllIlIlI != null && lllllllllllIIlIIIIIlIIIlIllIlIlI.minY > 10;
        }
        
        @Nullable
        protected StructureComponent getNextComponentX(final Start lllllllllllIIlIIIIIlIIIllIIlIIll, final List<StructureComponent> lllllllllllIIlIIIIIlIIIllIIIlIlI, final Random lllllllllllIIlIIIIIlIIIllIIIlIIl, final int lllllllllllIIlIIIIIlIIIllIIlIIII, final int lllllllllllIIlIIIIIlIIIllIIIllll, final boolean lllllllllllIIlIIIIIlIIIllIIIlllI) {
            final EnumFacing lllllllllllIIlIIIIIlIIIllIIIllIl = this.getCoordBaseMode();
            if (lllllllllllIIlIIIIIlIIIllIIIllIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIIlIIIIIlIIIllIIIllIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIIlIIll, lllllllllllIIlIIIIIlIIIllIIIlIlI, lllllllllllIIlIIIIIlIIIllIIIlIIl, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIIlIIII, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIllIIIllll, EnumFacing.WEST, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIIlllI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIIlIIll, lllllllllllIIlIIIIIlIIIllIIIlIlI, lllllllllllIIlIIIIIlIIIllIIIlIIl, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIIlIIII, this.boundingBox.minZ + lllllllllllIIlIIIIIlIIIllIIIllll, EnumFacing.WEST, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIIlllI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIIlIIll, lllllllllllIIlIIIIIlIIIllIIIlIlI, lllllllllllIIlIIIIIlIIIllIIIlIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIllIIIllll, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIIlIIII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIIlllI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(lllllllllllIIlIIIIIlIIIllIIlIIll, lllllllllllIIlIIIIIlIIIllIIIlIlI, lllllllllllIIlIIIIIlIIIllIIIlIIl, this.boundingBox.minX + lllllllllllIIlIIIIIlIIIllIIIllll, this.boundingBox.minY + lllllllllllIIlIIIIIlIIIllIIlIIII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), lllllllllllIIlIIIIIlIIIllIIIlllI);
                    }
                }
            }
            return null;
        }
        
        private StructureComponent generateAndAddPiece(final Start lllllllllllIIlIIIIIlIIIlllIIlIll, final List<StructureComponent> lllllllllllIIlIIIIIlIIIllIlllllI, final Random lllllllllllIIlIIIIIlIIIlllIIlIIl, final int lllllllllllIIlIIIIIlIIIllIllllII, final int lllllllllllIIlIIIIIlIIIllIlllIll, final int lllllllllllIIlIIIIIlIIIllIlllIlI, @Nullable final EnumFacing lllllllllllIIlIIIIIlIIIlllIIIlIl, final int lllllllllllIIlIIIIIlIIIllIlllIII, final boolean lllllllllllIIlIIIIIlIIIllIllIlll) {
            if (Math.abs(lllllllllllIIlIIIIIlIIIllIllllII - lllllllllllIIlIIIIIlIIIlllIIlIll.getBoundingBox().minX) <= 112 && Math.abs(lllllllllllIIlIIIIIlIIIllIlllIlI - lllllllllllIIlIIIIIlIIIlllIIlIll.getBoundingBox().minZ) <= 112) {
                List<PieceWeight> lllllllllllIIlIIIIIlIIIlllIIIIlI = lllllllllllIIlIIIIIlIIIlllIIlIll.primaryWeights;
                if (lllllllllllIIlIIIIIlIIIllIllIlll) {
                    lllllllllllIIlIIIIIlIIIlllIIIIlI = lllllllllllIIlIIIIIlIIIlllIIlIll.secondaryWeights;
                }
                final StructureComponent lllllllllllIIlIIIIIlIIIlllIIIIIl = this.generatePiece(lllllllllllIIlIIIIIlIIIlllIIlIll, lllllllllllIIlIIIIIlIIIlllIIIIlI, lllllllllllIIlIIIIIlIIIllIlllllI, lllllllllllIIlIIIIIlIIIlllIIlIIl, lllllllllllIIlIIIIIlIIIllIllllII, lllllllllllIIlIIIIIlIIIllIlllIll, lllllllllllIIlIIIIIlIIIllIlllIlI, lllllllllllIIlIIIIIlIIIlllIIIlIl, lllllllllllIIlIIIIIlIIIllIlllIII + 1);
                if (lllllllllllIIlIIIIIlIIIlllIIIIIl != null) {
                    lllllllllllIIlIIIIIlIIIllIlllllI.add(lllllllllllIIlIIIIIlIIIlllIIIIIl);
                    lllllllllllIIlIIIIIlIIIlllIIlIll.pendingChildren.add(lllllllllllIIlIIIIIlIIIlllIIIIIl);
                }
                return lllllllllllIIlIIIIIlIIIlllIIIIIl;
            }
            return End.createPiece(lllllllllllIIlIIIIIlIIIllIlllllI, lllllllllllIIlIIIIIlIIIlllIIlIIl, lllllllllllIIlIIIIIlIIIllIllllII, lllllllllllIIlIIIIIlIIIllIlllIll, lllllllllllIIlIIIIIlIIIllIlllIlI, lllllllllllIIlIIIIIlIIIlllIIIlIl, lllllllllllIIlIIIIIlIIIllIlllIII);
        }
    }
    
    static class PieceWeight
    {
        public /* synthetic */ boolean allowInRow;
        public /* synthetic */ Class<? extends Piece> weightClass;
        public final /* synthetic */ int weight;
        public /* synthetic */ int placeCount;
        public /* synthetic */ int maxPlaceCount;
        
        public PieceWeight(final Class<? extends Piece> llllllllllllIlllIllIIIlIIlIIIIll, final int llllllllllllIlllIllIIIlIIlIIIIlI, final int llllllllllllIlllIllIIIlIIIllllIl) {
            this(llllllllllllIlllIllIIIlIIlIIIIll, llllllllllllIlllIllIIIlIIlIIIIlI, llllllllllllIlllIllIIIlIIIllllIl, false);
        }
        
        public boolean doPlace(final int llllllllllllIlllIllIIIlIIIlllIlI) {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
        
        public PieceWeight(final Class<? extends Piece> llllllllllllIlllIllIIIlIIlIIllII, final int llllllllllllIlllIllIIIlIIlIlIIII, final int llllllllllllIlllIllIIIlIIlIIlIlI, final boolean llllllllllllIlllIllIIIlIIlIIlIIl) {
            this.weightClass = llllllllllllIlllIllIIIlIIlIIllII;
            this.weight = llllllllllllIlllIllIIIlIIlIlIIII;
            this.maxPlaceCount = llllllllllllIlllIllIIIlIIlIIlIlI;
            this.allowInRow = llllllllllllIlllIllIIIlIIlIIlIIl;
        }
        
        public boolean isValid() {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
    }
    
    public static class Start extends Crossing3
    {
        public /* synthetic */ List<StructureComponent> pendingChildren;
        public /* synthetic */ PieceWeight theNetherBridgePieceWeight;
        public /* synthetic */ List<PieceWeight> primaryWeights;
        public /* synthetic */ List<PieceWeight> secondaryWeights;
        
        public Start() {
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Start(final Random llllllllllllllllIIlIllIIIIlllIII, final int llllllllllllllllIIlIllIIIIllIlll, final int llllllllllllllllIIlIllIIIIllIllI) {
            super(llllllllllllllllIIlIllIIIIlllIII, llllllllllllllllIIlIllIIIIllIlll, llllllllllllllllIIlIllIIIIllIllI);
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
            this.primaryWeights = (List<PieceWeight>)Lists.newArrayList();
            short llllllllllllllllIIlIllIIIIllIIlI;
            short llllllllllllllllIIlIllIIIIllIIll = (short)((PieceWeight[])(Object)(llllllllllllllllIIlIllIIIIllIIlI = (short)(Object)StructureNetherBridgePieces.PRIMARY_COMPONENTS)).length;
            for (byte llllllllllllllllIIlIllIIIIllIlII = 0; llllllllllllllllIIlIllIIIIllIlII < llllllllllllllllIIlIllIIIIllIIll; ++llllllllllllllllIIlIllIIIIllIlII) {
                final PieceWeight llllllllllllllllIIlIllIIIIlllIll = llllllllllllllllIIlIllIIIIllIIlI[llllllllllllllllIIlIllIIIIllIlII];
                llllllllllllllllIIlIllIIIIlllIll.placeCount = 0;
                this.primaryWeights.add(llllllllllllllllIIlIllIIIIlllIll);
            }
            this.secondaryWeights = (List<PieceWeight>)Lists.newArrayList();
            llllllllllllllllIIlIllIIIIllIIll = (short)((PieceWeight[])(Object)(llllllllllllllllIIlIllIIIIllIIlI = (short)(Object)StructureNetherBridgePieces.SECONDARY_COMPONENTS)).length;
            for (byte llllllllllllllllIIlIllIIIIllIlII = 0; llllllllllllllllIIlIllIIIIllIlII < llllllllllllllllIIlIllIIIIllIIll; ++llllllllllllllllIIlIllIIIIllIlII) {
                final PieceWeight llllllllllllllllIIlIllIIIIlllIlI = llllllllllllllllIIlIllIIIIllIIlI[llllllllllllllllIIlIllIIIIllIlII];
                llllllllllllllllIIlIllIIIIlllIlI.placeCount = 0;
                this.secondaryWeights.add(llllllllllllllllIIlIllIIIIlllIlI);
            }
        }
    }
    
    public static class Crossing3 extends Piece
    {
        protected Crossing3(final Random llllllllllllllIlIlIIlIllllIIlllI, final int llllllllllllllIlIlIIlIllllIlIIIl, final int llllllllllllllIlIlIIlIllllIIllII) {
            super(0);
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIlIlIIlIllllIIlllI));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(llllllllllllllIlIlIIlIllllIlIIIl, 64, llllllllllllllIlIlIIlIllllIIllII, llllllllllllllIlIlIIlIllllIlIIIl + 19 - 1, 73, llllllllllllllIlIlIIlIllllIIllII + 19 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(llllllllllllllIlIlIIlIllllIlIIIl, 64, llllllllllllllIlIlIIlIllllIIllII, llllllllllllllIlIlIIlIllllIlIIIl + 19 - 1, 73, llllllllllllllIlIlIIlIllllIIllII + 19 - 1);
            }
        }
        
        public static Crossing3 createPiece(final List<StructureComponent> llllllllllllllIlIlIIlIlllIllIlll, final Random llllllllllllllIlIlIIlIlllIllIllI, final int llllllllllllllIlIlIIlIlllIllIlIl, final int llllllllllllllIlIlIIlIlllIlIllII, final int llllllllllllllIlIlIIlIlllIlIlIll, final EnumFacing llllllllllllllIlIlIIlIlllIllIIlI, final int llllllllllllllIlIlIIlIlllIllIIIl) {
            final StructureBoundingBox llllllllllllllIlIlIIlIlllIllIIII = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIlIlIIlIlllIllIlIl, llllllllllllllIlIlIIlIlllIlIllII, llllllllllllllIlIlIIlIlllIlIlIll, -8, -3, 0, 19, 10, 19, llllllllllllllIlIlIIlIlllIllIIlI);
            return (Piece.isAboveGround(llllllllllllllIlIlIIlIlllIllIIII) && StructureComponent.findIntersecting(llllllllllllllIlIlIIlIlllIllIlll, llllllllllllllIlIlIIlIlllIllIIII) == null) ? new Crossing3(llllllllllllllIlIlIIlIlllIllIIIl, llllllllllllllIlIlIIlIlllIllIllI, llllllllllllllIlIlIIlIlllIllIIII, llllllllllllllIlIlIIlIlllIllIIlI) : null;
        }
        
        public Crossing3() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIIlIllllIIIllI, final List<StructureComponent> llllllllllllllIlIlIIlIllllIIIIIl, final Random llllllllllllllIlIlIIlIllllIIIlII) {
            this.getNextComponentNormal((Start)llllllllllllllIlIlIIlIllllIIIllI, llllllllllllllIlIlIIlIllllIIIIIl, llllllllllllllIlIlIIlIllllIIIlII, 8, 3, false);
            this.getNextComponentX((Start)llllllllllllllIlIlIIlIllllIIIllI, llllllllllllllIlIlIIlIllllIIIIIl, llllllllllllllIlIlIIlIllllIIIlII, 3, 8, false);
            this.getNextComponentZ((Start)llllllllllllllIlIlIIlIllllIIIllI, llllllllllllllIlIlIIlIllllIIIIIl, llllllllllllllIlIlIIlIllllIIIlII, 3, 8, false);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIIlIlllIIllIIl, final Random llllllllllllllIlIlIIlIlllIlIIIII, final StructureBoundingBox llllllllllllllIlIlIIlIlllIIlllll) {
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 8, 5, 0, 10, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 5, 8, 18, 7, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIlIlllIIllllI = 7; llllllllllllllIlIlIIlIlllIIllllI <= 11; ++llllllllllllllIlIlIIlIlllIIllllI) {
                for (int llllllllllllllIlIlIIlIlllIIlllIl = 0; llllllllllllllIlIlIIlIlllIIlllIl <= 2; ++llllllllllllllIlIlIIlIlllIIlllIl) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlIlllIIllIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIlIlllIIllllI, -1, llllllllllllllIlIlIIlIlllIIlllIl, llllllllllllllIlIlIIlIlllIIlllll);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlIlllIIllIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIlIlllIIllllI, -1, 18 - llllllllllllllIlIlIIlIlllIIlllIl, llllllllllllllIlIlIIlIlllIIlllll);
                }
            }
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIlllIIllIIl, llllllllllllllIlIlIIlIlllIIlllll, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIlIlllIIlllII = 0; llllllllllllllIlIlIIlIlllIIlllII <= 2; ++llllllllllllllIlIlIIlIlllIIlllII) {
                for (int llllllllllllllIlIlIIlIlllIIllIll = 7; llllllllllllllIlIlIIlIlllIIllIll <= 11; ++llllllllllllllIlIlIIlIlllIIllIll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlIlllIIllIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIlIlllIIlllII, -1, llllllllllllllIlIlIIlIlllIIllIll, llllllllllllllIlIlIIlIlllIIlllll);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlIlllIIllIIl, Blocks.NETHER_BRICK.getDefaultState(), 18 - llllllllllllllIlIlIIlIlllIIlllII, -1, llllllllllllllIlIlIIlIlllIIllIll, llllllllllllllIlIlIIlIlllIIlllll);
                }
            }
            return true;
        }
        
        public Crossing3(final int llllllllllllllIlIlIIlIllllIlllll, final Random llllllllllllllIlIlIIlIllllIllllI, final StructureBoundingBox llllllllllllllIlIlIIlIllllIlllIl, final EnumFacing llllllllllllllIlIlIIlIllllIlllII) {
            super(llllllllllllllIlIlIIlIllllIlllll);
            this.setCoordBaseMode(llllllllllllllIlIlIIlIllllIlllII);
            this.boundingBox = llllllllllllllIlIlIIlIllllIlllIl;
        }
    }
    
    public static class Corridor extends Piece
    {
        private /* synthetic */ boolean chest;
        
        public static Corridor createPiece(final List<StructureComponent> lllllllllllIlllIlllIIlIIllllIllI, final Random lllllllllllIlllIlllIIlIIllllIlIl, final int lllllllllllIlllIlllIIlIIllllllII, final int lllllllllllIlllIlllIIlIIllllIIll, final int lllllllllllIlllIlllIIlIIlllllIlI, final EnumFacing lllllllllllIlllIlllIIlIIllllIIIl, final int lllllllllllIlllIlllIIlIIlllllIII) {
            final StructureBoundingBox lllllllllllIlllIlllIIlIIllllIlll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIlllIlllIIlIIllllllII, lllllllllllIlllIlllIIlIIllllIIll, lllllllllllIlllIlllIIlIIlllllIlI, -1, 0, 0, 5, 7, 5, lllllllllllIlllIlllIIlIIllllIIIl);
            return (Piece.isAboveGround(lllllllllllIlllIlllIIlIIllllIlll) && StructureComponent.findIntersecting(lllllllllllIlllIlllIIlIIllllIllI, lllllllllllIlllIlllIIlIIllllIlll) == null) ? new Corridor(lllllllllllIlllIlllIIlIIlllllIII, lllllllllllIlllIlllIIlIIllllIlIl, lllllllllllIlllIlllIIlIIllllIlll, lllllllllllIlllIlllIIlIIllllIIIl) : null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIlllIlllIIlIlIIIllIlI, final TemplateManager lllllllllllIlllIlllIIlIlIIIlllII) {
            super.readStructureFromNBT(lllllllllllIlllIlllIIlIlIIIllIlI, lllllllllllIlllIlllIIlIlIIIlllII);
            this.chest = lllllllllllIlllIlllIIlIlIIIllIlI.getBoolean("Chest");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIlllIlllIIlIlIIIlIIll) {
            super.writeStructureToNBT(lllllllllllIlllIlllIIlIlIIIlIIll);
            lllllllllllIlllIlllIIlIlIIIlIIll.setBoolean("Chest", this.chest);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIlllIlllIIlIlIIIIlIIl, final List<StructureComponent> lllllllllllIlllIlllIIlIlIIIIlIII, final Random lllllllllllIlllIlllIIlIlIIIIIlll) {
            this.getNextComponentX((Start)lllllllllllIlllIlllIIlIlIIIIlIIl, lllllllllllIlllIlllIIlIlIIIIlIII, lllllllllllIlllIlllIIlIlIIIIIlll, 0, 1, true);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIlllIlllIIlIIlllIIlll, final Random lllllllllllIlllIlllIIlIIlllIIllI, final StructureBoundingBox lllllllllllIlllIlllIIlIIlllIIlIl) {
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            if (this.chest && lllllllllllIlllIlllIIlIIlllIIlIl.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.chest = false;
                this.generateChest(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, lllllllllllIlllIlllIIlIIlllIIllI, 3, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }
            this.fillWithBlocks(lllllllllllIlllIlllIIlIIlllIIlll, lllllllllllIlllIlllIIlIIlllIIlIl, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllIlllIlllIIlIIlllIIlII = 0; lllllllllllIlllIlllIIlIIlllIIlII <= 4; ++lllllllllllIlllIlllIIlIIlllIIlII) {
                for (int lllllllllllIlllIlllIIlIIlllIIIll = 0; lllllllllllIlllIlllIIlIIlllIIIll <= 4; ++lllllllllllIlllIlllIIlIIlllIIIll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllIlllIlllIIlIIlllIIlll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIlllIlllIIlIIlllIIlII, -1, lllllllllllIlllIlllIIlIIlllIIIll, lllllllllllIlllIlllIIlIIlllIIlIl);
                }
            }
            return true;
        }
        
        public Corridor(final int lllllllllllIlllIlllIIlIlIIlIlIlI, final Random lllllllllllIlllIlllIIlIlIIlIIlII, final StructureBoundingBox lllllllllllIlllIlllIIlIlIIlIlIII, final EnumFacing lllllllllllIlllIlllIIlIlIIlIIlll) {
            super(lllllllllllIlllIlllIIlIlIIlIlIlI);
            this.setCoordBaseMode(lllllllllllIlllIlllIIlIlIIlIIlll);
            this.boundingBox = lllllllllllIlllIlllIIlIlIIlIlIII;
            this.chest = (lllllllllllIlllIlllIIlIlIIlIIlII.nextInt(3) == 0);
        }
        
        public Corridor() {
        }
    }
    
    public static class Entrance extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllIIIIIllllIIIlIIIlIIl, final Random llllllllllllIIIIIllllIIIlIIIlIII, final StructureBoundingBox llllllllllllIIIIIllllIIIlIIIIlll) {
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int llllllllllllIIIIIllllIIIlIIlIIlI = 1; llllllllllllIIIIIllllIIIlIIlIIlI <= 11; llllllllllllIIIIIllllIIIlIIlIIlI += 2) {
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, llllllllllllIIIIIllllIIIlIIlIIlI, 10, 0, llllllllllllIIIIIllllIIIlIIlIIlI, 11, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, llllllllllllIIIIIllllIIIlIIlIIlI, 10, 12, llllllllllllIIIIIllllIIIlIIlIIlI, 11, 12, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 10, llllllllllllIIIIIllllIIIlIIlIIlI, 0, 11, llllllllllllIIIIIllllIIIlIIlIIlI, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 12, 10, llllllllllllIIIIIllllIIIlIIlIIlI, 12, 11, llllllllllllIIIIIllllIIIlIIlIIlI, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIlI, 13, 0, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIlI, 13, 12, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), 0, 13, llllllllllllIIIIIllllIIIlIIlIIlI, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), 12, 13, llllllllllllIIIIIllllIIIlIIlIIlI, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIlI + 1, 13, 0, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIlI + 1, 13, 12, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, llllllllllllIIIIIllllIIIlIIlIIlI + 1, llllllllllllIIIIIllllIIIlIIIIlll);
                this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, llllllllllllIIIIIllllIIIlIIlIIlI + 1, llllllllllllIIIIIllllIIIlIIIIlll);
            }
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, llllllllllllIIIIIllllIIIlIIIIlll);
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, llllllllllllIIIIIllllIIIlIIIIlll);
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, llllllllllllIIIIIllllIIIlIIIIlll);
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, llllllllllllIIIIIllllIIIlIIIIlll);
            for (int llllllllllllIIIIIllllIIIlIIlIIIl = 3; llllllllllllIIIIIllllIIIlIIlIIIl <= 9; llllllllllllIIIIIllllIIIlIIlIIIl += 2) {
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 1, 7, llllllllllllIIIIIllllIIIlIIlIIIl, 1, 8, llllllllllllIIIIIllllIIIlIIlIIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 11, 7, llllllllllllIIIIIllllIIIlIIlIIIl, 11, 8, llllllllllllIIIIIllllIIIlIIlIIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            }
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllIIIIIllllIIIlIIlIIII = 4; llllllllllllIIIIIllllIIIlIIlIIII <= 8; ++llllllllllllIIIIIllllIIIlIIlIIII) {
                for (int llllllllllllIIIIIllllIIIlIIIllll = 0; llllllllllllIIIIIllllIIIlIIIllll <= 2; ++llllllllllllIIIIIllllIIIlIIIllll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIII, -1, llllllllllllIIIIIllllIIIlIIIllll, llllllllllllIIIIIllllIIIlIIIIlll);
                    this.replaceAirAndLiquidDownwards(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIIIIIllllIIIlIIlIIII, -1, 12 - llllllllllllIIIIIllllIIIlIIIllll, llllllllllllIIIIIllllIIIlIIIIlll);
                }
            }
            for (int llllllllllllIIIIIllllIIIlIIIlllI = 0; llllllllllllIIIIIllllIIIlIIIlllI <= 2; ++llllllllllllIIIIIllllIIIlIIIlllI) {
                for (int llllllllllllIIIIIllllIIIlIIIllIl = 4; llllllllllllIIIIIllllIIIlIIIllIl <= 8; ++llllllllllllIIIIIllllIIIlIIIllIl) {
                    this.replaceAirAndLiquidDownwards(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIIIIIllllIIIlIIIlllI, -1, llllllllllllIIIIIllllIIIlIIIllIl, llllllllllllIIIIIllllIIIlIIIIlll);
                    this.replaceAirAndLiquidDownwards(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), 12 - llllllllllllIIIIIllllIIIlIIIlllI, -1, llllllllllllIIIIIllllIIIlIIIllIl, llllllllllllIIIIIllllIIIlIIIIlll);
                }
            }
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIIlll, 6, 1, 6, 6, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, Blocks.NETHER_BRICK.getDefaultState(), 6, 0, 6, llllllllllllIIIIIllllIIIlIIIIlll);
            final IBlockState llllllllllllIIIIIllllIIIlIIIllII = Blocks.FLOWING_LAVA.getDefaultState();
            this.setBlockState(llllllllllllIIIIIllllIIIlIIIlIIl, llllllllllllIIIIIllllIIIlIIIllII, 6, 5, 6, llllllllllllIIIIIllllIIIlIIIIlll);
            final BlockPos llllllllllllIIIIIllllIIIlIIIlIll = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));
            if (llllllllllllIIIIIllllIIIlIIIIlll.isVecInside(llllllllllllIIIIIllllIIIlIIIlIll)) {
                llllllllllllIIIIIllllIIIlIIIlIIl.immediateBlockTick(llllllllllllIIIIIllllIIIlIIIlIll, llllllllllllIIIIIllllIIIlIIIllII, llllllllllllIIIIIllllIIIlIIIlIII);
            }
            return true;
        }
        
        public Entrance() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllIIIIIllllIIIlIlllIll, final List<StructureComponent> llllllllllllIIIIIllllIIIlIllIllI, final Random llllllllllllIIIIIllllIIIlIllIlIl) {
            this.getNextComponentNormal((Start)llllllllllllIIIIIllllIIIlIlllIll, llllllllllllIIIIIllllIIIlIllIllI, llllllllllllIIIIIllllIIIlIllIlIl, 5, 3, true);
        }
        
        public static Entrance createPiece(final List<StructureComponent> llllllllllllIIIIIllllIIIlIlIllII, final Random llllllllllllIIIIIllllIIIlIlIlIll, final int llllllllllllIIIIIllllIIIlIlIIIlI, final int llllllllllllIIIIIllllIIIlIlIIIIl, final int llllllllllllIIIIIllllIIIlIlIIIII, final EnumFacing llllllllllllIIIIIllllIIIlIlIIlll, final int llllllllllllIIIIIllllIIIlIlIIllI) {
            final StructureBoundingBox llllllllllllIIIIIllllIIIlIlIIlIl = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllIIIIIllllIIIlIlIIIlI, llllllllllllIIIIIllllIIIlIlIIIIl, llllllllllllIIIIIllllIIIlIlIIIII, -5, -3, 0, 13, 14, 13, llllllllllllIIIIIllllIIIlIlIIlll);
            return (Piece.isAboveGround(llllllllllllIIIIIllllIIIlIlIIlIl) && StructureComponent.findIntersecting(llllllllllllIIIIIllllIIIlIlIllII, llllllllllllIIIIIllllIIIlIlIIlIl) == null) ? new Entrance(llllllllllllIIIIIllllIIIlIlIIllI, llllllllllllIIIIIllllIIIlIlIlIll, llllllllllllIIIIIllllIIIlIlIIlIl, llllllllllllIIIIIllllIIIlIlIIlll) : null;
        }
        
        public Entrance(final int llllllllllllIIIIIllllIIIllIIlIII, final Random llllllllllllIIIIIllllIIIllIIIlll, final StructureBoundingBox llllllllllllIIIIIllllIIIllIIIIlI, final EnumFacing llllllllllllIIIIIllllIIIllIIIIIl) {
            super(llllllllllllIIIIIllllIIIllIIlIII);
            this.setCoordBaseMode(llllllllllllIIIIIllllIIIllIIIIIl);
            this.boundingBox = llllllllllllIIIIIllllIIIllIIIIlI;
        }
    }
    
    public static class NetherStalkRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllIllIlIlIIIIIlllIlII, final Random lllllllllllllIllIlIlIIIIIlllIIll, final StructureBoundingBox lllllllllllllIllIlIlIIIIIllIIIlI) {
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIllIlIlIIIIIlllIIIl = 1; lllllllllllllIllIlIlIIIIIlllIIIl <= 11; lllllllllllllIllIlIlIIIIIlllIIIl += 2) {
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, lllllllllllllIllIlIlIIIIIlllIIIl, 10, 0, lllllllllllllIllIlIlIIIIIlllIIIl, 11, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, lllllllllllllIllIlIlIIIIIlllIIIl, 10, 12, lllllllllllllIllIlIlIIIIIlllIIIl, 11, 12, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 10, lllllllllllllIllIlIlIIIIIlllIIIl, 0, 11, lllllllllllllIllIlIlIIIIIlllIIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 12, 10, lllllllllllllIllIlIlIIIIIlllIIIl, 12, 11, lllllllllllllIllIlIlIIIIIlllIIIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIlIIIIIlllIIIl, 13, 0, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIlIIIIIlllIIIl, 13, 12, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), 0, 13, lllllllllllllIllIlIlIIIIIlllIIIl, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), 12, 13, lllllllllllllIllIlIlIIIIIlllIIIl, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIllIlIlIIIIIlllIIIl + 1, 13, 0, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIllIlIlIIIIIlllIIIl + 1, 13, 12, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, lllllllllllllIllIlIlIIIIIlllIIIl + 1, lllllllllllllIllIlIlIIIIIllIIIlI);
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, lllllllllllllIllIlIlIIIIIlllIIIl + 1, lllllllllllllIllIlIlIIIIIllIIIlI);
            }
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, lllllllllllllIllIlIlIIIIIllIIIlI);
            for (int lllllllllllllIllIlIlIIIIIlllIIII = 3; lllllllllllllIllIlIlIIIIIlllIIII <= 9; lllllllllllllIllIlIlIIIIIlllIIII += 2) {
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 1, 7, lllllllllllllIllIlIlIIIIIlllIIII, 1, 8, lllllllllllllIllIlIlIIIIIlllIIII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 11, 7, lllllllllllllIllIlIlIIIIIlllIIII, 11, 8, lllllllllllllIllIlIlIIIIIlllIIII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            }
            final IBlockState lllllllllllllIllIlIlIIIIIllIllll = Blocks.NETHER_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            for (int lllllllllllllIllIlIlIIIIIllIlllI = 0; lllllllllllllIllIlIlIIIIIllIlllI <= 6; ++lllllllllllllIllIlIlIIIIIllIlllI) {
                final int lllllllllllllIllIlIlIIIIIllIllIl = lllllllllllllIllIlIlIIIIIllIlllI + 4;
                for (int lllllllllllllIllIlIlIIIIIllIllII = 5; lllllllllllllIllIlIlIIIIIllIllII <= 7; ++lllllllllllllIllIlIlIIIIIllIllII) {
                    this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIllII, 5 + lllllllllllllIllIlIlIIIIIllIlllI, lllllllllllllIllIlIlIIIIIllIllIl, lllllllllllllIllIlIlIIIIIllIIIlI);
                }
                if (lllllllllllllIllIlIlIIIIIllIllIl >= 5 && lllllllllllllIllIlIlIIIIIllIllIl <= 8) {
                    this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 5, lllllllllllllIllIlIlIIIIIllIllIl, 7, lllllllllllllIllIlIlIIIIIllIlllI + 4, lllllllllllllIllIlIlIIIIIllIllIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
                else if (lllllllllllllIllIlIlIIIIIllIllIl >= 9 && lllllllllllllIllIlIlIIIIIllIllIl <= 10) {
                    this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 8, lllllllllllllIllIlIlIIIIIllIllIl, 7, lllllllllllllIllIlIlIIIIIllIlllI + 4, lllllllllllllIllIlIlIIIIIllIllIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
                if (lllllllllllllIllIlIlIIIIIllIlllI >= 1) {
                    this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 6 + lllllllllllllIllIlIlIIIIIllIlllI, lllllllllllllIllIlIlIIIIIllIllIl, 7, 9 + lllllllllllllIllIlIlIIIIIllIlllI, lllllllllllllIllIlIlIIIIIllIllIl, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                }
            }
            for (int lllllllllllllIllIlIlIIIIIllIlIll = 5; lllllllllllllIllIlIlIIIIIllIlIll <= 7; ++lllllllllllllIllIlIlIIIIIllIlIll) {
                this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlIll, 12, 11, lllllllllllllIllIlIlIIIIIllIIIlI);
            }
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 6, 7, 5, 7, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 7, 6, 7, 7, 7, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            final IBlockState lllllllllllllIllIlIlIIIIIllIlIlI = lllllllllllllIllIlIlIIIIIllIllll.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllIllIlIlIIIIIllIlIIl = lllllllllllllIllIlIlIIIIIllIllll.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIIl, 4, 5, 2, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIIl, 4, 5, 3, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIIl, 4, 5, 9, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIIl, 4, 5, 10, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIlI, 8, 5, 2, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIlI, 8, 5, 3, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIlI, 8, 5, 9, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.setBlockState(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIlIlI, 8, 5, 10, lllllllllllllIllIlIlIIIIIllIIIlI);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.getDefaultState(), Blocks.NETHER_WART.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 8, 5, 4, 9, 5, 8, Blocks.NETHER_WART.getDefaultState(), Blocks.NETHER_WART.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIlIIIIIlllIlII, lllllllllllllIllIlIlIIIIIllIIIlI, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIllIlIlIIIIIllIlIII = 4; lllllllllllllIllIlIlIIIIIllIlIII <= 8; ++lllllllllllllIllIlIlIIIIIllIlIII) {
                for (int lllllllllllllIllIlIlIIIIIllIIlll = 0; lllllllllllllIllIlIlIIIIIllIIlll <= 2; ++lllllllllllllIllIlIlIIIIIllIIlll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIlIIIIIllIlIII, -1, lllllllllllllIllIlIlIIIIIllIIlll, lllllllllllllIllIlIlIIIIIllIIIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIlIIIIIllIlIII, -1, 12 - lllllllllllllIllIlIlIIIIIllIIlll, lllllllllllllIllIlIlIIIIIllIIIlI);
                }
            }
            for (int lllllllllllllIllIlIlIIIIIllIIllI = 0; lllllllllllllIllIlIlIIIIIllIIllI <= 2; ++lllllllllllllIllIlIlIIIIIllIIllI) {
                for (int lllllllllllllIllIlIlIIIIIllIIlIl = 4; lllllllllllllIllIlIlIIIIIllIIlIl <= 8; ++lllllllllllllIllIlIlIIIIIllIIlIl) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIlIIIIIllIIllI, -1, lllllllllllllIllIlIlIIIIIllIIlIl, lllllllllllllIllIlIlIIIIIllIIIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIlIIIIIlllIlII, Blocks.NETHER_BRICK.getDefaultState(), 12 - lllllllllllllIllIlIlIIIIIllIIllI, -1, lllllllllllllIllIlIlIIIIIllIIlIl, lllllllllllllIllIlIlIIIIIllIIIlI);
                }
            }
            return true;
        }
        
        public static NetherStalkRoom createPiece(final List<StructureComponent> lllllllllllllIllIlIlIIIIlIIIllIl, final Random lllllllllllllIllIlIlIIIIlIIIIlII, final int lllllllllllllIllIlIlIIIIlIIIlIll, final int lllllllllllllIllIlIlIIIIlIIIlIlI, final int lllllllllllllIllIlIlIIIIlIIIIIIl, final EnumFacing lllllllllllllIllIlIlIIIIlIIIlIII, final int lllllllllllllIllIlIlIIIIIlllllll) {
            final StructureBoundingBox lllllllllllllIllIlIlIIIIlIIIIllI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIllIlIlIIIIlIIIlIll, lllllllllllllIllIlIlIIIIlIIIlIlI, lllllllllllllIllIlIlIIIIlIIIIIIl, -5, -3, 0, 13, 14, 13, lllllllllllllIllIlIlIIIIlIIIlIII);
            return (Piece.isAboveGround(lllllllllllllIllIlIlIIIIlIIIIllI) && StructureComponent.findIntersecting(lllllllllllllIllIlIlIIIIlIIIllIl, lllllllllllllIllIlIlIIIIlIIIIllI) == null) ? new NetherStalkRoom(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIlIIIIlII, lllllllllllllIllIlIlIIIIlIIIIllI, lllllllllllllIllIlIlIIIIlIIIlIII) : null;
        }
        
        public NetherStalkRoom(final int lllllllllllllIllIlIlIIIIlIlIIlII, final Random lllllllllllllIllIlIlIIIIlIlIlIII, final StructureBoundingBox lllllllllllllIllIlIlIIIIlIlIIlll, final EnumFacing lllllllllllllIllIlIlIIIIlIlIIllI) {
            super(lllllllllllllIllIlIlIIIIlIlIIlII);
            this.setCoordBaseMode(lllllllllllllIllIlIlIIIIlIlIIllI);
            this.boundingBox = lllllllllllllIllIlIlIIIIlIlIIlll;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIllIlIlIIIIlIIlllII, final List<StructureComponent> lllllllllllllIllIlIlIIIIlIIllIll, final Random lllllllllllllIllIlIlIIIIlIIllIlI) {
            this.getNextComponentNormal((Start)lllllllllllllIllIlIlIIIIlIIlllII, lllllllllllllIllIlIlIIIIlIIllIll, lllllllllllllIllIlIlIIIIlIIllIlI, 5, 3, true);
            this.getNextComponentNormal((Start)lllllllllllllIllIlIlIIIIlIIlllII, lllllllllllllIllIlIlIIIIlIIllIll, lllllllllllllIllIlIlIIIIlIIllIlI, 5, 11, true);
        }
        
        public NetherStalkRoom() {
        }
    }
    
    public static class Straight extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIIIIlllllllIIlIlIIII, final List<StructureComponent> lllllllllllIIIIIlllllllIIlIIllll, final Random lllllllllllIIIIIlllllllIIlIlIIlI) {
            this.getNextComponentNormal((Start)lllllllllllIIIIIlllllllIIlIlIIII, lllllllllllIIIIIlllllllIIlIIllll, lllllllllllIIIIIlllllllIIlIlIIlI, 1, 3, false);
        }
        
        public Straight() {
        }
        
        public Straight(final int lllllllllllIIIIIlllllllIIlIlllII, final Random lllllllllllIIIIIlllllllIIllIIIII, final StructureBoundingBox lllllllllllIIIIIlllllllIIlIllIll, final EnumFacing lllllllllllIIIIIlllllllIIlIllIlI) {
            super(lllllllllllIIIIIlllllllIIlIlllII);
            this.setCoordBaseMode(lllllllllllIIIIIlllllllIIlIllIlI);
            this.boundingBox = lllllllllllIIIIIlllllllIIlIllIll;
        }
        
        public static Straight createPiece(final List<StructureComponent> lllllllllllIIIIIlllllllIIIllllIl, final Random lllllllllllIIIIIlllllllIIIllllII, final int lllllllllllIIIIIlllllllIIlIIIIll, final int lllllllllllIIIIIlllllllIIIlllIlI, final int lllllllllllIIIIIlllllllIIIlllIIl, final EnumFacing lllllllllllIIIIIlllllllIIlIIIIII, final int lllllllllllIIIIIlllllllIIIllllll) {
            final StructureBoundingBox lllllllllllIIIIIlllllllIIIlllllI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIIIIlllllllIIlIIIIll, lllllllllllIIIIIlllllllIIIlllIlI, lllllllllllIIIIIlllllllIIIlllIIl, -1, -3, 0, 5, 10, 19, lllllllllllIIIIIlllllllIIlIIIIII);
            return (Piece.isAboveGround(lllllllllllIIIIIlllllllIIIlllllI) && StructureComponent.findIntersecting(lllllllllllIIIIIlllllllIIIllllIl, lllllllllllIIIIIlllllllIIIlllllI) == null) ? new Straight(lllllllllllIIIIIlllllllIIIllllll, lllllllllllIIIIIlllllllIIIllllII, lllllllllllIIIIIlllllllIIIlllllI, lllllllllllIIIIIlllllllIIlIIIIII) : null;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIIIIlllllllIIIlIllll, final Random lllllllllllIIIIIlllllllIIIlIlllI, final StructureBoundingBox lllllllllllIIIIIlllllllIIIlIllIl) {
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 1, 5, 0, 3, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllIIIIIlllllllIIIlIllII = 0; lllllllllllIIIIIlllllllIIIlIllII <= 4; ++lllllllllllIIIIIlllllllIIIlIllII) {
                for (int lllllllllllIIIIIlllllllIIIlIlIll = 0; lllllllllllIIIIIlllllllIIIlIlIll <= 2; ++lllllllllllIIIIIlllllllIIIlIlIll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllIIIIIlllllllIIIlIllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIIIIIlllllllIIIlIllII, -1, lllllllllllIIIIIlllllllIIIlIlIll, lllllllllllIIIIIlllllllIIIlIllIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllIIIIIlllllllIIIlIllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIIIIIlllllllIIIlIllII, -1, 18 - lllllllllllIIIIIlllllllIIIlIlIll, lllllllllllIIIIIlllllllIIIlIllIl);
                }
            }
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 1, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 3, 4, 0, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 3, 14, 0, 4, 14, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 0, 1, 17, 0, 4, 17, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 4, 1, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 4, 3, 4, 4, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 4, 3, 14, 4, 4, 14, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIIIIlllllllIIIlIllll, lllllllllllIIIIIlllllllIIIlIllIl, 4, 1, 17, 4, 4, 17, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            return true;
        }
    }
    
    public static class Stairs extends Piece
    {
        public static Stairs createPiece(final List<StructureComponent> lllllllllllllIIllllIIllIllIIIIlI, final Random lllllllllllllIIllllIIllIllIIIIIl, final int lllllllllllllIIllllIIllIllIIIIII, final int lllllllllllllIIllllIIllIlIllllll, final int lllllllllllllIIllllIIllIlIllIllI, final int lllllllllllllIIllllIIllIlIllllIl, final EnumFacing lllllllllllllIIllllIIllIlIllIlII) {
            final StructureBoundingBox lllllllllllllIIllllIIllIlIlllIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIllllIIllIllIIIIII, lllllllllllllIIllllIIllIlIllllll, lllllllllllllIIllllIIllIlIllIllI, -2, 0, 0, 7, 11, 7, lllllllllllllIIllllIIllIlIllIlII);
            return (Piece.isAboveGround(lllllllllllllIIllllIIllIlIlllIll) && StructureComponent.findIntersecting(lllllllllllllIIllllIIllIllIIIIlI, lllllllllllllIIllllIIllIlIlllIll) == null) ? new Stairs(lllllllllllllIIllllIIllIlIllllIl, lllllllllllllIIllllIIllIllIIIIIl, lllllllllllllIIllllIIllIlIlllIll, lllllllllllllIIllllIIllIlIllIlII) : null;
        }
        
        public Stairs() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIllllIIllIllIlIIIl, final List<StructureComponent> lllllllllllllIIllllIIllIllIIllII, final Random lllllllllllllIIllllIIllIllIIlIll) {
            this.getNextComponentZ((Start)lllllllllllllIIllllIIllIllIlIIIl, lllllllllllllIIllllIIllIllIIllII, lllllllllllllIIllllIIllIllIIlIll, 6, 2, false);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIllllIIllIlIlIllII, final Random lllllllllllllIIllllIIllIlIlIlIll, final StructureBoundingBox lllllllllllllIIllllIIllIlIlIIlIl) {
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 0, 2, 0, 6, 10, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 0, 3, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 6, 3, 2, 6, 5, 2, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 6, 3, 4, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIllllIIllIlIlIllII, Blocks.NETHER_BRICK.getDefaultState(), 5, 2, 5, lllllllllllllIIllllIIllIlIlIIlIl);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 6, 8, 2, 6, 8, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIllllIIllIlIlIllII, lllllllllllllIIllllIIllIlIlIIlIl, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int lllllllllllllIIllllIIllIlIlIlIIl = 0; lllllllllllllIIllllIIllIlIlIlIIl <= 6; ++lllllllllllllIIllllIIllIlIlIlIIl) {
                for (int lllllllllllllIIllllIIllIlIlIlIII = 0; lllllllllllllIIllllIIllIlIlIlIII <= 6; ++lllllllllllllIIllllIIllIlIlIlIII) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIllllIIllIlIlIllII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIllllIIllIlIlIlIIl, -1, lllllllllllllIIllllIIllIlIlIlIII, lllllllllllllIIllllIIllIlIlIIlIl);
                }
            }
            return true;
        }
        
        public Stairs(final int lllllllllllllIIllllIIllIllIllllI, final Random lllllllllllllIIllllIIllIllIlllIl, final StructureBoundingBox lllllllllllllIIllllIIllIllIllIII, final EnumFacing lllllllllllllIIllllIIllIllIllIll) {
            super(lllllllllllllIIllllIIllIllIllllI);
            this.setCoordBaseMode(lllllllllllllIIllllIIllIllIllIll);
            this.boundingBox = lllllllllllllIIllllIIllIllIllIII;
        }
    }
    
    public static class Crossing extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIllIllIlIlIlIlIIlIII, final List<StructureComponent> lllllllllllIIllIllIlIlIlIlIIIlll, final Random lllllllllllIIllIllIlIlIlIlIIIllI) {
            this.getNextComponentNormal((Start)lllllllllllIIllIllIlIlIlIlIIlIII, lllllllllllIIllIllIlIlIlIlIIIlll, lllllllllllIIllIllIlIlIlIlIIIllI, 2, 0, false);
            this.getNextComponentX((Start)lllllllllllIIllIllIlIlIlIlIIlIII, lllllllllllIIllIllIlIlIlIlIIIlll, lllllllllllIIllIllIlIlIlIlIIIllI, 0, 2, false);
            this.getNextComponentZ((Start)lllllllllllIIllIllIlIlIlIlIIlIII, lllllllllllIIllIllIlIlIlIlIIIlll, lllllllllllIIllIllIlIlIlIlIIIllI, 0, 2, false);
        }
        
        public Crossing() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIllIllIlIlIlIIIlllIl, final Random lllllllllllIIllIllIlIlIlIIlIIIlI, final StructureBoundingBox lllllllllllIIllIllIlIlIlIIIlllII) {
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 2, 5, 6, 4, 5, 6, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 0, 5, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIIllIllIlIlIlIIIlllIl, lllllllllllIIllIllIlIlIlIIIlllII, 6, 5, 2, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int lllllllllllIIllIllIlIlIlIIlIIIII = 0; lllllllllllIIllIllIlIlIlIIlIIIII <= 6; ++lllllllllllIIllIllIlIlIlIIlIIIII) {
                for (int lllllllllllIIllIllIlIlIlIIIlllll = 0; lllllllllllIIllIllIlIlIlIIIlllll <= 6; ++lllllllllllIIllIllIlIlIlIIIlllll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllIIllIllIlIlIlIIIlllIl, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIIllIllIlIlIlIIlIIIII, -1, lllllllllllIIllIllIlIlIlIIIlllll, lllllllllllIIllIllIlIlIlIIIlllII);
                }
            }
            return true;
        }
        
        public Crossing(final int lllllllllllIIllIllIlIlIlIlIlIlIl, final Random lllllllllllIIllIllIlIlIlIlIlIlII, final StructureBoundingBox lllllllllllIIllIllIlIlIlIlIIllll, final EnumFacing lllllllllllIIllIllIlIlIlIlIlIIlI) {
            super(lllllllllllIIllIllIlIlIlIlIlIlIl);
            this.setCoordBaseMode(lllllllllllIIllIllIlIlIlIlIlIIlI);
            this.boundingBox = lllllllllllIIllIllIlIlIlIlIIllll;
        }
        
        public static Crossing createPiece(final List<StructureComponent> lllllllllllIIllIllIlIlIlIIlllIIl, final Random lllllllllllIIllIllIlIlIlIIlllIII, final int lllllllllllIIllIllIlIlIlIIllIlll, final int lllllllllllIIllIllIlIlIlIIllIllI, final int lllllllllllIIllIllIlIlIlIIlIllIl, final EnumFacing lllllllllllIIllIllIlIlIlIIlIllII, final int lllllllllllIIllIllIlIlIlIIllIIll) {
            final StructureBoundingBox lllllllllllIIllIllIlIlIlIIllIIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIllIllIlIlIlIIllIlll, lllllllllllIIllIllIlIlIlIIllIllI, lllllllllllIIllIllIlIlIlIIlIllIl, -2, 0, 0, 7, 9, 7, lllllllllllIIllIllIlIlIlIIlIllII);
            return (Piece.isAboveGround(lllllllllllIIllIllIlIlIlIIllIIlI) && StructureComponent.findIntersecting(lllllllllllIIllIllIlIlIlIIlllIIl, lllllllllllIIllIllIlIlIlIIllIIlI) == null) ? new Crossing(lllllllllllIIllIllIlIlIlIIllIIll, lllllllllllIIllIllIlIlIlIIlllIII, lllllllllllIIllIllIlIlIlIIllIIlI, lllllllllllIIllIllIlIlIlIIlIllII) : null;
        }
    }
    
    public static class Corridor2 extends Piece
    {
        private /* synthetic */ boolean chest;
        
        public Corridor2(final int lllllllllllIlllllIlllllIlIllIIII, final Random lllllllllllIlllllIlllllIlIlIllll, final StructureBoundingBox lllllllllllIlllllIlllllIlIllIIll, final EnumFacing lllllllllllIlllllIlllllIlIlIllIl) {
            super(lllllllllllIlllllIlllllIlIllIIII);
            this.setCoordBaseMode(lllllllllllIlllllIlllllIlIlIllIl);
            this.boundingBox = lllllllllllIlllllIlllllIlIllIIll;
            this.chest = (lllllllllllIlllllIlllllIlIlIllll.nextInt(3) == 0);
        }
        
        public Corridor2() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIlllllIlllllIlIlIIlIl, final TemplateManager lllllllllllIlllllIlllllIlIlIIlII) {
            super.readStructureFromNBT(lllllllllllIlllllIlllllIlIlIIlIl, lllllllllllIlllllIlllllIlIlIIlII);
            this.chest = lllllllllllIlllllIlllllIlIlIIlIl.getBoolean("Chest");
        }
        
        public static Corridor2 createPiece(final List<StructureComponent> lllllllllllIlllllIlllllIlIIIlIIl, final Random lllllllllllIlllllIlllllIlIIIIIII, final int lllllllllllIlllllIlllllIIlllllll, final int lllllllllllIlllllIlllllIIllllllI, final int lllllllllllIlllllIlllllIlIIIIlIl, final EnumFacing lllllllllllIlllllIlllllIIlllllII, final int lllllllllllIlllllIlllllIlIIIIIll) {
            final StructureBoundingBox lllllllllllIlllllIlllllIlIIIIIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIlllllIlllllIIlllllll, lllllllllllIlllllIlllllIIllllllI, lllllllllllIlllllIlllllIlIIIIlIl, -1, 0, 0, 5, 7, 5, lllllllllllIlllllIlllllIIlllllII);
            return (Piece.isAboveGround(lllllllllllIlllllIlllllIlIIIIIlI) && StructureComponent.findIntersecting(lllllllllllIlllllIlllllIlIIIlIIl, lllllllllllIlllllIlllllIlIIIIIlI) == null) ? new Corridor2(lllllllllllIlllllIlllllIlIIIIIll, lllllllllllIlllllIlllllIlIIIIIII, lllllllllllIlllllIlllllIlIIIIIlI, lllllllllllIlllllIlllllIIlllllII) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIlllllIlllllIlIIlIlII, final List<StructureComponent> lllllllllllIlllllIlllllIlIIlIlll, final Random lllllllllllIlllllIlllllIlIIlIllI) {
            this.getNextComponentZ((Start)lllllllllllIlllllIlllllIlIIlIlII, lllllllllllIlllllIlllllIlIIlIlll, lllllllllllIlllllIlllllIlIIlIllI, 0, 1, true);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIlllllIlllllIIlllIIlI, final Random lllllllllllIlllllIlllllIIllIlIll, final StructureBoundingBox lllllllllllIlllllIlllllIIllIlIlI) {
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            if (this.chest && lllllllllllIlllllIlllllIIllIlIlI.isVecInside(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3)))) {
                this.chest = false;
                this.generateChest(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, lllllllllllIlllllIlllllIIllIlIll, 1, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }
            this.fillWithBlocks(lllllllllllIlllllIlllllIIlllIIlI, lllllllllllIlllllIlllllIIllIlIlI, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllIlllllIlllllIIllIllll = 0; lllllllllllIlllllIlllllIIllIllll <= 4; ++lllllllllllIlllllIlllllIIllIllll) {
                for (int lllllllllllIlllllIlllllIIllIlllI = 0; lllllllllllIlllllIlllllIIllIlllI <= 4; ++lllllllllllIlllllIlllllIIllIlllI) {
                    this.replaceAirAndLiquidDownwards(lllllllllllIlllllIlllllIIlllIIlI, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIlllllIlllllIIllIllll, -1, lllllllllllIlllllIlllllIIllIlllI, lllllllllllIlllllIlllllIIllIlIlI);
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIlllllIlllllIlIlIIIII) {
            super.writeStructureToNBT(lllllllllllIlllllIlllllIlIlIIIII);
            lllllllllllIlllllIlllllIlIlIIIII.setBoolean("Chest", this.chest);
        }
    }
    
    public static class Corridor3 extends Piece
    {
        public Corridor3(final int lllllllllllIIlIIlIIllIIIIllIIIIl, final Random lllllllllllIIlIIlIIllIIIIllIIlIl, final StructureBoundingBox lllllllllllIIlIIlIIllIIIIllIIlII, final EnumFacing lllllllllllIIlIIlIIllIIIIllIIIll) {
            super(lllllllllllIIlIIlIIllIIIIllIIIIl);
            this.setCoordBaseMode(lllllllllllIIlIIlIIllIIIIllIIIll);
            this.boundingBox = lllllllllllIIlIIlIIllIIIIllIIlII;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIlIIllIIIIIllIIII, final Random lllllllllllIIlIIlIIllIIIIIlIllll, final StructureBoundingBox lllllllllllIIlIIlIIllIIIIIlIlllI) {
            final IBlockState lllllllllllIIlIIlIIllIIIIIlIllIl = Blocks.NETHER_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            for (int lllllllllllIIlIIlIIllIIIIIlIllII = 0; lllllllllllIIlIIlIIllIIIIIlIllII <= 9; ++lllllllllllIIlIIlIIllIIIIIlIllII) {
                final int lllllllllllIIlIIlIIllIIIIIlIlIll = Math.max(1, 7 - lllllllllllIIlIIlIIllIIIIIlIllII);
                final int lllllllllllIIlIIlIIllIIIIIlIlIlI = Math.min(Math.max(lllllllllllIIlIIlIIllIIIIIlIlIll + 5, 14 - lllllllllllIIlIIlIIllIIIIIlIllII), 13);
                final int lllllllllllIIlIIlIIllIIIIIlIlIIl = lllllllllllIIlIIlIIllIIIIIlIllII;
                this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 0, 0, lllllllllllIIlIIlIIllIIIIIlIllII, 4, lllllllllllIIlIIlIIllIIIIIlIlIll, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 1, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, 3, lllllllllllIIlIIlIIllIIIIIlIlIlI - 1, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                if (lllllllllllIIlIIlIIllIIIIIlIllII <= 6) {
                    this.setBlockState(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIllIl, 1, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, lllllllllllIIlIIlIIllIIIIIlIlllI);
                    this.setBlockState(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIllIl, 2, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, lllllllllllIIlIIlIIllIIIIIlIlllI);
                    this.setBlockState(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIllIl, 3, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, lllllllllllIIlIIlIIllIIIIIlIlllI);
                }
                this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 0, lllllllllllIIlIIlIIllIIIIIlIlIlI, lllllllllllIIlIIlIIllIIIIIlIllII, 4, lllllllllllIIlIIlIIllIIIIIlIlIlI, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 0, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, 0, lllllllllllIIlIIlIIllIIIIIlIlIlI - 1, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 4, lllllllllllIIlIIlIIllIIIIIlIlIll + 1, lllllllllllIIlIIlIIllIIIIIlIllII, 4, lllllllllllIIlIIlIIllIIIIIlIlIlI - 1, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                if ((lllllllllllIIlIIlIIllIIIIIlIllII & 0x1) == 0x0) {
                    this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 0, lllllllllllIIlIIlIIllIIIIIlIlIll + 2, lllllllllllIIlIIlIIllIIIIIlIllII, 0, lllllllllllIIlIIlIIllIIIIIlIlIll + 3, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                    this.fillWithBlocks(lllllllllllIIlIIlIIllIIIIIllIIII, lllllllllllIIlIIlIIllIIIIIlIlllI, 4, lllllllllllIIlIIlIIllIIIIIlIlIll + 2, lllllllllllIIlIIlIIllIIIIIlIllII, 4, lllllllllllIIlIIlIIllIIIIIlIlIll + 3, lllllllllllIIlIIlIIllIIIIIlIllII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                }
                for (int lllllllllllIIlIIlIIllIIIIIlIlIII = 0; lllllllllllIIlIIlIIllIIIIIlIlIII <= 4; ++lllllllllllIIlIIlIIllIIIIIlIlIII) {
                    this.replaceAirAndLiquidDownwards(lllllllllllIIlIIlIIllIIIIIllIIII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllIIlIIlIIllIIIIIlIlIII, -1, lllllllllllIIlIIlIIllIIIIIlIlIIl, lllllllllllIIlIIlIIllIIIIIlIlllI);
                }
            }
            return true;
        }
        
        public static Corridor3 createPiece(final List<StructureComponent> lllllllllllIIlIIlIIllIIIIlIIlIlI, final Random lllllllllllIIlIIlIIllIIIIlIIlIIl, final int lllllllllllIIlIIlIIllIIIIlIIIIII, final int lllllllllllIIlIIlIIllIIIIlIIIlll, final int lllllllllllIIlIIlIIllIIIIIlllllI, final EnumFacing lllllllllllIIlIIlIIllIIIIIllllIl, final int lllllllllllIIlIIlIIllIIIIlIIIlII) {
            final StructureBoundingBox lllllllllllIIlIIlIIllIIIIlIIIIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllIIlIIlIIllIIIIlIIIIII, lllllllllllIIlIIlIIllIIIIlIIIlll, lllllllllllIIlIIlIIllIIIIIlllllI, -1, -7, 0, 5, 14, 10, lllllllllllIIlIIlIIllIIIIIllllIl);
            return (Piece.isAboveGround(lllllllllllIIlIIlIIllIIIIlIIIIll) && StructureComponent.findIntersecting(lllllllllllIIlIIlIIllIIIIlIIlIlI, lllllllllllIIlIIlIIllIIIIlIIIIll) == null) ? new Corridor3(lllllllllllIIlIIlIIllIIIIlIIIlII, lllllllllllIIlIIlIIllIIIIlIIlIIl, lllllllllllIIlIIlIIllIIIIlIIIIll, lllllllllllIIlIIlIIllIIIIIllllIl) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIIlIIlIIllIIIIlIlIlIl, final List<StructureComponent> lllllllllllIIlIIlIIllIIIIlIlIlII, final Random lllllllllllIIlIIlIIllIIIIlIlIIll) {
            this.getNextComponentNormal((Start)lllllllllllIIlIIlIIllIIIIlIlIlIl, lllllllllllIIlIIlIIllIIIIlIlIlII, lllllllllllIIlIIlIIllIIIIlIlIIll, 1, 0, true);
        }
        
        public Corridor3() {
        }
    }
    
    public static class Throne extends Piece
    {
        private /* synthetic */ boolean hasSpawner;
        
        public Throne() {
        }
        
        public static Throne createPiece(final List<StructureComponent> llllllllllllllIIlIIlllIIIlIIIlIl, final Random llllllllllllllIIlIIlllIIIlIIIlII, final int llllllllllllllIIlIIlllIIIIlllIll, final int llllllllllllllIIlIIlllIIIlIIIIlI, final int llllllllllllllIIlIIlllIIIIlllIIl, final int llllllllllllllIIlIIlllIIIIlllIII, final EnumFacing llllllllllllllIIlIIlllIIIIllIlll) {
            final StructureBoundingBox llllllllllllllIIlIIlllIIIIlllllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIlllIIIIlllIll, llllllllllllllIIlIIlllIIIlIIIIlI, llllllllllllllIIlIIlllIIIIlllIIl, -2, 0, 0, 7, 8, 9, llllllllllllllIIlIIlllIIIIllIlll);
            return (Piece.isAboveGround(llllllllllllllIIlIIlllIIIIlllllI) && StructureComponent.findIntersecting(llllllllllllllIIlIIlllIIIlIIIlIl, llllllllllllllIIlIIlllIIIIlllllI) == null) ? new Throne(llllllllllllllIIlIIlllIIIIlllIII, llllllllllllllIIlIIlllIIIlIIIlII, llllllllllllllIIlIIlllIIIIlllllI, llllllllllllllIIlIIlllIIIIllIlll) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlllIIIIlIIlll, final Random llllllllllllllIIlIIlllIIIIlIlllI, final StructureBoundingBox llllllllllllllIIlIIlllIIIIlIllIl) {
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 0, 2, 0, 6, 7, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.setBlockState(llllllllllllllIIlIIlllIIIIlIIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 1, 6, 3, llllllllllllllIIlIIlllIIIIlIllIl);
            this.setBlockState(llllllllllllllIIlIIlllIIIIlIIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 5, 6, 3, llllllllllllllIIlIIlllIIIIlIllIl);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 0, 6, 3, 0, 6, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 6, 6, 3, 6, 6, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 1, 6, 8, 5, 7, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlllIIIIlIIlll, llllllllllllllIIlIIlllIIIIlIllIl, 2, 8, 8, 4, 8, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            if (!this.hasSpawner) {
                final BlockPos llllllllllllllIIlIIlllIIIIlIllII = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));
                if (llllllllllllllIIlIIlllIIIIlIllIl.isVecInside(llllllllllllllIIlIIlllIIIIlIllII)) {
                    this.hasSpawner = true;
                    llllllllllllllIIlIIlllIIIIlIIlll.setBlockState(llllllllllllllIIlIIlllIIIIlIllII, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                    final TileEntity llllllllllllllIIlIIlllIIIIlIlIll = llllllllllllllIIlIIlllIIIIlIIlll.getTileEntity(llllllllllllllIIlIIlllIIIIlIllII);
                    if (llllllllllllllIIlIIlllIIIIlIlIll instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)llllllllllllllIIlIIlllIIIIlIlIll).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntityBlaze.class));
                    }
                }
            }
            for (int llllllllllllllIIlIIlllIIIIlIlIlI = 0; llllllllllllllIIlIIlllIIIIlIlIlI <= 6; ++llllllllllllllIIlIIlllIIIIlIlIlI) {
                for (int llllllllllllllIIlIIlllIIIIlIlIIl = 0; llllllllllllllIIlIIlllIIIIlIlIIl <= 6; ++llllllllllllllIIlIIlllIIIIlIlIIl) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIIlllIIIIlIIlll, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIIlIIlllIIIIlIlIlI, -1, llllllllllllllIIlIIlllIIIIlIlIIl, llllllllllllllIIlIIlllIIIIlIllIl);
                }
            }
            return true;
        }
        
        public Throne(final int llllllllllllllIIlIIlllIIIllIIlII, final Random llllllllllllllIIlIIlllIIIllIIIll, final StructureBoundingBox llllllllllllllIIlIIlllIIIlIllllI, final EnumFacing llllllllllllllIIlIIlllIIIllIIIIl) {
            super(llllllllllllllIIlIIlllIIIllIIlII);
            this.setCoordBaseMode(llllllllllllllIIlIIlllIIIllIIIIl);
            this.boundingBox = llllllllllllllIIlIIlllIIIlIllllI;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIIlllIIIlIllIII, final TemplateManager llllllllllllllIIlIIlllIIIlIlIlll) {
            super.readStructureFromNBT(llllllllllllllIIlIIlllIIIlIllIII, llllllllllllllIIlIIlllIIIlIlIlll);
            this.hasSpawner = llllllllllllllIIlIIlllIIIlIllIII.getBoolean("Mob");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIIlllIIIlIIlllI) {
            super.writeStructureToNBT(llllllllllllllIIlIIlllIIIlIIlllI);
            llllllllllllllIIlIIlllIIIlIIlllI.setBoolean("Mob", this.hasSpawner);
        }
    }
    
    public static class Crossing2 extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIIlllllIlIlIIl, final Random llllllllllllllIlIlIIlllllIlIlllI, final StructureBoundingBox llllllllllllllIlIlIIlllllIlIllIl) {
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlllllIlIlIIl, llllllllllllllIlIlIIlllllIlIllIl, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIlllllIlIllII = 0; llllllllllllllIlIlIIlllllIlIllII <= 4; ++llllllllllllllIlIlIIlllllIlIllII) {
                for (int llllllllllllllIlIlIIlllllIlIlIll = 0; llllllllllllllIlIlIIlllllIlIlIll <= 4; ++llllllllllllllIlIlIIlllllIlIlIll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlllllIlIlIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIlllllIlIllII, -1, llllllllllllllIlIlIIlllllIlIlIll, llllllllllllllIlIlIIlllllIlIllIl);
                }
            }
            return true;
        }
        
        public static Crossing2 createPiece(final List<StructureComponent> llllllllllllllIlIlIIlllllIllllIl, final Random llllllllllllllIlIlIIllllllIIIlII, final int llllllllllllllIlIlIIlllllIlllIll, final int llllllllllllllIlIlIIlllllIlllIlI, final int llllllllllllllIlIlIIlllllIlllIIl, final EnumFacing llllllllllllllIlIlIIllllllIIIIII, final int llllllllllllllIlIlIIlllllIllllll) {
            final StructureBoundingBox llllllllllllllIlIlIIlllllIlllllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIlIlIIlllllIlllIll, llllllllllllllIlIlIIlllllIlllIlI, llllllllllllllIlIlIIlllllIlllIIl, -1, 0, 0, 5, 7, 5, llllllllllllllIlIlIIllllllIIIIII);
            return (Piece.isAboveGround(llllllllllllllIlIlIIlllllIlllllI) && StructureComponent.findIntersecting(llllllllllllllIlIlIIlllllIllllIl, llllllllllllllIlIlIIlllllIlllllI) == null) ? new Crossing2(llllllllllllllIlIlIIlllllIllllll, llllllllllllllIlIlIIllllllIIIlII, llllllllllllllIlIlIIlllllIlllllI, llllllllllllllIlIlIIllllllIIIIII) : null;
        }
        
        public Crossing2(final int llllllllllllllIlIlIIllllllIlllII, final Random llllllllllllllIlIlIIlllllllIIIII, final StructureBoundingBox llllllllllllllIlIlIIllllllIllIll, final EnumFacing llllllllllllllIlIlIIllllllIllIlI) {
            super(llllllllllllllIlIlIIllllllIlllII);
            this.setCoordBaseMode(llllllllllllllIlIlIIllllllIllIlI);
            this.boundingBox = llllllllllllllIlIlIIllllllIllIll;
        }
        
        public Crossing2() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIIllllllIlIIII, final List<StructureComponent> llllllllllllllIlIlIIllllllIlIIll, final Random llllllllllllllIlIlIIllllllIIlllI) {
            this.getNextComponentNormal((Start)llllllllllllllIlIlIIllllllIlIIII, llllllllllllllIlIlIIllllllIlIIll, llllllllllllllIlIlIIllllllIIlllI, 1, 0, true);
            this.getNextComponentX((Start)llllllllllllllIlIlIIllllllIlIIII, llllllllllllllIlIlIIllllllIlIIll, llllllllllllllIlIlIIllllllIIlllI, 0, 1, true);
            this.getNextComponentZ((Start)llllllllllllllIlIlIIllllllIlIIII, llllllllllllllIlIlIIllllllIlIIll, llllllllllllllIlIlIIllllllIIlllI, 0, 1, true);
        }
    }
    
    public static class Corridor5 extends Piece
    {
        public Corridor5() {
        }
        
        public static Corridor5 createPiece(final List<StructureComponent> lllllllllllllIIIIlIIIIIIlIIllllI, final Random lllllllllllllIIIIlIIIIIIlIIlIlIl, final int lllllllllllllIIIIlIIIIIIlIIlIlII, final int lllllllllllllIIIIlIIIIIIlIIlIIll, final int lllllllllllllIIIIlIIIIIIlIIlIIlI, final EnumFacing lllllllllllllIIIIlIIIIIIlIIlIIIl, final int lllllllllllllIIIIlIIIIIIlIIllIII) {
            final StructureBoundingBox lllllllllllllIIIIlIIIIIIlIIlIlll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIIlIIIIIIlIIlIlII, lllllllllllllIIIIlIIIIIIlIIlIIll, lllllllllllllIIIIlIIIIIIlIIlIIlI, -1, 0, 0, 5, 7, 5, lllllllllllllIIIIlIIIIIIlIIlIIIl);
            return (Piece.isAboveGround(lllllllllllllIIIIlIIIIIIlIIlIlll) && StructureComponent.findIntersecting(lllllllllllllIIIIlIIIIIIlIIllllI, lllllllllllllIIIIlIIIIIIlIIlIlll) == null) ? new Corridor5(lllllllllllllIIIIlIIIIIIlIIllIII, lllllllllllllIIIIlIIIIIIlIIlIlIl, lllllllllllllIIIIlIIIIIIlIIlIlll, lllllllllllllIIIIlIIIIIIlIIlIIIl) : null;
        }
        
        public Corridor5(final int lllllllllllllIIIIlIIIIIIlIlllIlI, final Random lllllllllllllIIIIlIIIIIIlIlllIIl, final StructureBoundingBox lllllllllllllIIIIlIIIIIIlIllIlII, final EnumFacing lllllllllllllIIIIlIIIIIIlIllIlll) {
            super(lllllllllllllIIIIlIIIIIIlIlllIlI);
            this.setCoordBaseMode(lllllllllllllIIIIlIIIIIIlIllIlll);
            this.boundingBox = lllllllllllllIIIIlIIIIIIlIllIlII;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIlIIIIIIlIIIlIII, final Random lllllllllllllIIIIlIIIIIIlIIIIlll, final StructureBoundingBox lllllllllllllIIIIlIIIIIIlIIIIIIl) {
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIIlIIIlIII, lllllllllllllIIIIlIIIIIIlIIIIIIl, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIIIlIIIIIIlIIIIlIl = 0; lllllllllllllIIIIlIIIIIIlIIIIlIl <= 4; ++lllllllllllllIIIIlIIIIIIlIIIIlIl) {
                for (int lllllllllllllIIIIlIIIIIIlIIIIlII = 0; lllllllllllllIIIIlIIIIIIlIIIIlII <= 4; ++lllllllllllllIIIIlIIIIIIlIIIIlII) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIIIlIIIIIIlIIIlIII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIIIlIIIIIIlIIIIlIl, -1, lllllllllllllIIIIlIIIIIIlIIIIlII, lllllllllllllIIIIlIIIIIIlIIIIIIl);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIIIlIIIIIIlIlIllIl, final List<StructureComponent> lllllllllllllIIIIlIIIIIIlIlIlIII, final Random lllllllllllllIIIIlIIIIIIlIlIIlll) {
            this.getNextComponentNormal((Start)lllllllllllllIIIIlIIIIIIlIlIllIl, lllllllllllllIIIIlIIIIIIlIlIlIII, lllllllllllllIIIIlIIIIIIlIlIIlll, 1, 0, true);
        }
    }
    
    public static class Corridor4 extends Piece
    {
        public static Corridor4 createPiece(final List<StructureComponent> llllllllllllIlllIIIlIlIIIIllIlII, final Random llllllllllllIlllIIIlIlIIIIlllIll, final int llllllllllllIlllIIIlIlIIIIlllIlI, final int llllllllllllIlllIIIlIlIIIIllIIIl, final int llllllllllllIlllIIIlIlIIIIlllIII, final EnumFacing llllllllllllIlllIIIlIlIIIIllIlll, final int llllllllllllIlllIIIlIlIIIIlIlllI) {
            final StructureBoundingBox llllllllllllIlllIIIlIlIIIIllIlIl = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllIlllIIIlIlIIIIlllIlI, llllllllllllIlllIIIlIlIIIIllIIIl, llllllllllllIlllIIIlIlIIIIlllIII, -3, 0, 0, 9, 7, 9, llllllllllllIlllIIIlIlIIIIllIlll);
            return (Piece.isAboveGround(llllllllllllIlllIIIlIlIIIIllIlIl) && StructureComponent.findIntersecting(llllllllllllIlllIIIlIlIIIIllIlII, llllllllllllIlllIIIlIlIIIIllIlIl) == null) ? new Corridor4(llllllllllllIlllIIIlIlIIIIlIlllI, llllllllllllIlllIIIlIlIIIIlllIll, llllllllllllIlllIIIlIlIIIIllIlIl, llllllllllllIlllIIIlIlIIIIllIlll) : null;
        }
        
        public Corridor4() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIlllIIIlIlIIIIlIIIII, final Random llllllllllllIlllIIIlIlIIIIlIIlIl, final StructureBoundingBox llllllllllllIlllIIIlIlIIIIlIIlII) {
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 2, 0, 8, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 1, 3, 0, 1, 4, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 7, 3, 0, 7, 4, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 1, 1, 4, 2, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 6, 1, 4, 7, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 3, 8, 8, 3, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 3, 6, 0, 3, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 8, 3, 6, 8, 3, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 1, 4, 5, 1, 5, 5, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllIIIlIlIIIIlIIIII, llllllllllllIlllIIIlIlIIIIlIIlII, 7, 4, 5, 7, 5, 5, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int llllllllllllIlllIIIlIlIIIIlIIIll = 0; llllllllllllIlllIIIlIlIIIIlIIIll <= 5; ++llllllllllllIlllIIIlIlIIIIlIIIll) {
                for (int llllllllllllIlllIIIlIlIIIIlIIIlI = 0; llllllllllllIlllIIIlIlIIIIlIIIlI <= 8; ++llllllllllllIlllIIIlIlIIIIlIIIlI) {
                    this.replaceAirAndLiquidDownwards(llllllllllllIlllIIIlIlIIIIlIIIII, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllIlllIIIlIlIIIIlIIIlI, -1, llllllllllllIlllIIIlIlIIIIlIIIll, llllllllllllIlllIIIlIlIIIIlIIlII);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllIlllIIIlIlIIIlIIllll, final List<StructureComponent> llllllllllllIlllIIIlIlIIIlIIlllI, final Random llllllllllllIlllIIIlIlIIIlIIIlll) {
            int llllllllllllIlllIIIlIlIIIlIIllII = 1;
            final EnumFacing llllllllllllIlllIIIlIlIIIlIIlIll = this.getCoordBaseMode();
            if (llllllllllllIlllIIIlIlIIIlIIlIll == EnumFacing.WEST || llllllllllllIlllIIIlIlIIIlIIlIll == EnumFacing.NORTH) {
                llllllllllllIlllIIIlIlIIIlIIllII = 5;
            }
            this.getNextComponentX((Start)llllllllllllIlllIIIlIlIIIlIIllll, llllllllllllIlllIIIlIlIIIlIIlllI, llllllllllllIlllIIIlIlIIIlIIIlll, 0, llllllllllllIlllIIIlIlIIIlIIllII, llllllllllllIlllIIIlIlIIIlIIIlll.nextInt(8) > 0);
            this.getNextComponentZ((Start)llllllllllllIlllIIIlIlIIIlIIllll, llllllllllllIlllIIIlIlIIIlIIlllI, llllllllllllIlllIIIlIlIIIlIIIlll, 0, llllllllllllIlllIIIlIlIIIlIIllII, llllllllllllIlllIIIlIlIIIlIIIlll.nextInt(8) > 0);
        }
        
        public Corridor4(final int llllllllllllIlllIIIlIlIIIlIllllI, final Random llllllllllllIlllIIIlIlIIIlIlllIl, final StructureBoundingBox llllllllllllIlllIIIlIlIIIlIlllII, final EnumFacing llllllllllllIlllIIIlIlIIIlIlIlll) {
            super(llllllllllllIlllIIIlIlIIIlIllllI);
            this.setCoordBaseMode(llllllllllllIlllIIIlIlIIIlIlIlll);
            this.boundingBox = llllllllllllIlllIIIlIlIIIlIlllII;
        }
    }
}
