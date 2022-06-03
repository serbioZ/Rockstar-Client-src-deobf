// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.util.EnumFacing;

public class StructureOceanMonumentPieces
{
    public static void registerOceanMonumentPieces() {
        MapGenStructureIO.registerStructureComponent(MonumentBuilding.class, "OMB");
        MapGenStructureIO.registerStructureComponent(MonumentCoreRoom.class, "OMCR");
        MapGenStructureIO.registerStructureComponent(DoubleXRoom.class, "OMDXR");
        MapGenStructureIO.registerStructureComponent(DoubleXYRoom.class, "OMDXYR");
        MapGenStructureIO.registerStructureComponent(DoubleYRoom.class, "OMDYR");
        MapGenStructureIO.registerStructureComponent(DoubleYZRoom.class, "OMDYZR");
        MapGenStructureIO.registerStructureComponent(DoubleZRoom.class, "OMDZR");
        MapGenStructureIO.registerStructureComponent(EntryRoom.class, "OMEntry");
        MapGenStructureIO.registerStructureComponent(Penthouse.class, "OMPenthouse");
        MapGenStructureIO.registerStructureComponent(SimpleRoom.class, "OMSimple");
        MapGenStructureIO.registerStructureComponent(SimpleTopRoom.class, "OMSimpleT");
    }
    
    static class FitSimpleRoomHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lllllllllllllIllllIIIllIlIllIllI, final RoomDefinition lllllllllllllIllllIIIllIlIllIlIl, final Random lllllllllllllIllllIIIllIlIllIlll) {
            lllllllllllllIllllIIIllIlIllIlIl.claimed = true;
            return new SimpleRoom(lllllllllllllIllllIIIllIlIllIllI, lllllllllllllIllllIIIllIlIllIlIl, lllllllllllllIllllIIIllIlIllIlll);
        }
        
        private FitSimpleRoomHelper() {
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIllllIIIllIlIlllllI) {
            return true;
        }
    }
    
    public static class SimpleRoom extends Piece
    {
        private /* synthetic */ int mainDesign;
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIIIIIIlIIIlIIIllll, final Random lllllllllllIIlIIIIIIlIIIlIIIlIIl, final StructureBoundingBox lllllllllllIIlIIIIIIlIIIlIIIlIII) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (this.roomDefinition.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 4, 1, 6, 4, 6, SimpleRoom.ROUGH_PRISMARINE);
            }
            final boolean lllllllllllIIlIIIIIIlIIIlIIIllII = this.mainDesign != 0 && lllllllllllIIlIIIIIIlIIIlIIIlIIl.nextBoolean() && !this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()] && !this.roomDefinition.hasOpening[EnumFacing.UP.getIndex()] && this.roomDefinition.countOpenings() > 1;
            if (this.mainDesign == 0) {
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 0, 2, 1, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 0, 2, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 2, 0, 0, 2, 2, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 0, 2, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 1, 2, 1, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 1, 0, 7, 1, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 3, 0, 7, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 2, 0, 7, 2, 2, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 2, 0, 6, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 6, 2, 1, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 5, 2, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 5, 2, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 2, 5, 0, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 7, 2, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 1, 2, 6, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 1, 5, 7, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 3, 5, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 2, 5, 7, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 2, 7, 6, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 6, 2, 6, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 3, 0, 4, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 3, 0, 4, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 2, 0, 4, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 0, 4, 1, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 3, 7, 4, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 3, 6, 4, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 2, 7, 4, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 6, 4, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 3, 0, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 3, 1, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 2, 3, 0, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 3, 1, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 3, 3, 7, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 6, 3, 3, 7, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 2, 3, 7, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 6, 1, 3, 7, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
            }
            else if (this.mainDesign == 1) {
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 2, 1, 2, 2, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 2, 1, 5, 2, 3, 5, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 1, 5, 5, 3, 5, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 5, 1, 2, 5, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 2, 2, 2, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 2, 2, 5, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 5, 2, 5, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.SEA_LANTERN, 5, 2, 2, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 0, 1, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 1, 0, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 7, 1, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 6, 0, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 6, 1, 7, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 6, 7, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 6, 1, 0, 7, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 1, 7, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 1, 2, 0, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 0, 2, 1, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 1, 2, 7, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 0, 2, 6, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 6, 2, 7, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 7, 2, 6, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 6, 2, 0, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                this.setBlockState(lllllllllllIIlIIIIIIlIIIlIIIllll, SimpleRoom.ROUGH_PRISMARINE, 7, 2, 1, lllllllllllIIlIIIIIIlIIIlIIIlIII);
                if (!this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 3, 0, 6, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 0, 6, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 1, 0, 6, 1, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 3, 7, 6, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 7, 6, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 1, 7, 6, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 1, 0, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 2, 1, 0, 2, 6, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 1, 0, 1, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 3, 1, 7, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 2, 1, 7, 2, 6, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 1, 7, 1, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
            }
            else if (this.mainDesign == 2) {
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 0, 0, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 0, 7, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 1, 0, 6, 1, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 1, 7, 6, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 2, 0, 0, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 2, 0, 7, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 0, 6, 2, 0, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 2, 7, 6, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 3, 0, 0, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 3, 0, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 3, 0, 6, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 1, 3, 7, 6, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 3, 0, 2, 4, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 3, 7, 2, 4, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 0, 4, 2, 0, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 7, 4, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.generateWaterBox(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 0, 4, 2, 0, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.generateWaterBox(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 7, 4, 2, 7, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.generateWaterBox(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 0, 1, 3, 0, 2, 4, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.generateWaterBox(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 7, 1, 3, 7, 2, 4, false);
                }
            }
            if (lllllllllllIIlIIIIIIlIIIlIIIllII) {
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 1, 3, 4, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 2, 3, 4, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlIIIIIIlIIIlIIIllll, lllllllllllIIlIIIIIIlIIIlIIIlIII, 3, 3, 3, 4, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
            }
            return true;
        }
        
        public SimpleRoom(final EnumFacing lllllllllllIIlIIIIIIlIIIlIIllIII, final RoomDefinition lllllllllllIIlIIIIIIlIIIlIIlIlll, final Random lllllllllllIIlIIIIIIlIIIlIIllIlI) {
            super(1, lllllllllllIIlIIIIIIlIIIlIIllIII, lllllllllllIIlIIIIIIlIIIlIIlIlll, 1, 1, 1);
            this.mainDesign = lllllllllllIIlIIIIIIlIIIlIIllIlI.nextInt(3);
        }
        
        public SimpleRoom() {
        }
    }
    
    public abstract static class Piece extends StructureComponent
    {
        protected static final /* synthetic */ int GRIDROOM_TOP_CONNECT_INDEX;
        protected static final /* synthetic */ int GRIDROOM_LEFTWING_CONNECT_INDEX;
        protected static final /* synthetic */ IBlockState ROUGH_PRISMARINE;
        protected static final /* synthetic */ IBlockState DOT_DECO_DATA;
        protected static final /* synthetic */ IBlockState SEA_LANTERN;
        protected /* synthetic */ RoomDefinition roomDefinition;
        protected static final /* synthetic */ int GRIDROOM_SOURCE_INDEX;
        protected static final /* synthetic */ IBlockState DARK_PRISMARINE;
        protected static final /* synthetic */ IBlockState WATER;
        protected static final /* synthetic */ int GRIDROOM_RIGHTWING_CONNECT_INDEX;
        protected static final /* synthetic */ IBlockState BRICKS_PRISMARINE;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIIlllIlIIlIlIIllIlll, final TemplateManager llllllllllllIIlllIlIIlIlIIllIllI) {
        }
        
        protected boolean spawnElder(final World llllllllllllIIlllIlIIlIIlIlIIIlI, final StructureBoundingBox llllllllllllIIlllIlIIlIIlIlIlIll, final int llllllllllllIIlllIlIIlIIlIlIlIlI, final int llllllllllllIIlllIlIIlIIlIIlllll, final int llllllllllllIIlllIlIIlIIlIIllllI) {
            final int llllllllllllIIlllIlIIlIIlIlIIlll = this.getXWithOffset(llllllllllllIIlllIlIIlIIlIlIlIlI, llllllllllllIIlllIlIIlIIlIIllllI);
            final int llllllllllllIIlllIlIIlIIlIlIIllI = this.getYWithOffset(llllllllllllIIlllIlIIlIIlIIlllll);
            final int llllllllllllIIlllIlIIlIIlIlIIlIl = this.getZWithOffset(llllllllllllIIlllIlIIlIIlIlIlIlI, llllllllllllIIlllIlIIlIIlIIllllI);
            if (llllllllllllIIlllIlIIlIIlIlIlIll.isVecInside(new BlockPos(llllllllllllIIlllIlIIlIIlIlIIlll, llllllllllllIIlllIlIIlIIlIlIIllI, llllllllllllIIlllIlIIlIIlIlIIlIl))) {
                final EntityElderGuardian llllllllllllIIlllIlIIlIIlIlIIlII = new EntityElderGuardian(llllllllllllIIlllIlIIlIIlIlIIIlI);
                llllllllllllIIlllIlIIlIIlIlIIlII.heal(llllllllllllIIlllIlIIlIIlIlIIlII.getMaxHealth());
                llllllllllllIIlllIlIIlIIlIlIIlII.setLocationAndAngles(llllllllllllIIlllIlIIlIIlIlIIlll + 0.5, llllllllllllIIlllIlIIlIIlIlIIllI, llllllllllllIIlllIlIIlIIlIlIIlIl + 0.5, 0.0f, 0.0f);
                llllllllllllIIlllIlIIlIIlIlIIlII.onInitialSpawn(llllllllllllIIlllIlIIlIIlIlIIIlI.getDifficultyForLocation(new BlockPos(llllllllllllIIlllIlIIlIIlIlIIlII)), null);
                llllllllllllIIlllIlIIlIIlIlIIIlI.spawnEntityInWorld(llllllllllllIIlllIlIIlIIlIlIIlII);
                return true;
            }
            return false;
        }
        
        protected void generateWaterBox(final World llllllllllllIIlllIlIIlIlIIlIIlll, final StructureBoundingBox llllllllllllIIlllIlIIlIlIIlIIllI, final int llllllllllllIIlllIlIIlIlIIIllIII, final int llllllllllllIIlllIlIIlIlIIlIIlII, final int llllllllllllIIlllIlIIlIlIIIlIllI, final int llllllllllllIIlllIlIIlIlIIIlIlIl, final int llllllllllllIIlllIlIIlIlIIlIIIIl, final int llllllllllllIIlllIlIIlIlIIlIIIII, final boolean llllllllllllIIlllIlIIlIlIIIlllll) {
            for (int llllllllllllIIlllIlIIlIlIIIllllI = llllllllllllIIlllIlIIlIlIIlIIlII; llllllllllllIIlllIlIIlIlIIIllllI <= llllllllllllIIlllIlIIlIlIIlIIIIl; ++llllllllllllIIlllIlIIlIlIIIllllI) {
                for (int llllllllllllIIlllIlIIlIlIIIlllIl = llllllllllllIIlllIlIIlIlIIIllIII; llllllllllllIIlllIlIIlIlIIIlllIl <= llllllllllllIIlllIlIIlIlIIIlIlIl; ++llllllllllllIIlllIlIIlIlIIIlllIl) {
                    for (int llllllllllllIIlllIlIIlIlIIIlllII = llllllllllllIIlllIlIIlIlIIIlIllI; llllllllllllIIlllIlIIlIlIIIlllII <= llllllllllllIIlllIlIIlIlIIlIIIII; ++llllllllllllIIlllIlIIlIlIIIlllII) {
                        if (!llllllllllllIIlllIlIIlIlIIIlllll || this.getBlockStateFromPos(llllllllllllIIlllIlIIlIlIIlIIlll, llllllllllllIIlllIlIIlIlIIIlllIl, llllllllllllIIlllIlIIlIlIIIllllI, llllllllllllIIlllIlIIlIlIIIlllII, llllllllllllIIlllIlIIlIlIIlIIllI).getMaterial() != Material.AIR) {
                            if (this.getYWithOffset(llllllllllllIIlllIlIIlIlIIIllllI) >= llllllllllllIIlllIlIIlIlIIlIIlll.getSeaLevel()) {
                                this.setBlockState(llllllllllllIIlllIlIIlIlIIlIIlll, Blocks.AIR.getDefaultState(), llllllllllllIIlllIlIIlIlIIIlllIl, llllllllllllIIlllIlIIlIlIIIllllI, llllllllllllIIlllIlIIlIlIIIlllII, llllllllllllIIlllIlIIlIlIIlIIllI);
                            }
                            else {
                                this.setBlockState(llllllllllllIIlllIlIIlIlIIlIIlll, Piece.WATER, llllllllllllIIlllIlIIlIlIIIlllIl, llllllllllllIIlllIlIIlIlIIIllllI, llllllllllllIIlllIlIIlIlIIIlllII, llllllllllllIIlllIlIIlIlIIlIIllI);
                            }
                        }
                    }
                }
            }
        }
        
        protected void generateDefaultFloor(final World llllllllllllIIlllIlIIlIlIIIIIlll, final StructureBoundingBox llllllllllllIIlllIlIIlIlIIIIIllI, final int llllllllllllIIlllIlIIlIlIIIIIlIl, final int llllllllllllIIlllIlIIlIIlllllllI, final boolean llllllllllllIIlllIlIIlIIllllllIl) {
            if (llllllllllllIIlllIlIIlIIllllllIl) {
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 0, 0, llllllllllllIIlllIlIIlIIlllllllI + 0, llllllllllllIIlllIlIIlIlIIIIIlIl + 2, 0, llllllllllllIIlllIlIIlIIlllllllI + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 5, 0, llllllllllllIIlllIlIIlIIlllllllI + 0, llllllllllllIIlllIlIIlIlIIIIIlIl + 8 - 1, 0, llllllllllllIIlllIlIIlIIlllllllI + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 3, 0, llllllllllllIIlllIlIIlIIlllllllI + 0, llllllllllllIIlllIlIIlIlIIIIIlIl + 4, 0, llllllllllllIIlllIlIIlIIlllllllI + 2, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 3, 0, llllllllllllIIlllIlIIlIIlllllllI + 5, llllllllllllIIlllIlIIlIlIIIIIlIl + 4, 0, llllllllllllIIlllIlIIlIIlllllllI + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 3, 0, llllllllllllIIlllIlIIlIIlllllllI + 2, llllllllllllIIlllIlIIlIlIIIIIlIl + 4, 0, llllllllllllIIlllIlIIlIIlllllllI + 2, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 3, 0, llllllllllllIIlllIlIIlIIlllllllI + 5, llllllllllllIIlllIlIIlIlIIIIIlIl + 4, 0, llllllllllllIIlllIlIIlIIlllllllI + 5, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 2, 0, llllllllllllIIlllIlIIlIIlllllllI + 3, llllllllllllIIlllIlIIlIlIIIIIlIl + 2, 0, llllllllllllIIlllIlIIlIIlllllllI + 4, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 5, 0, llllllllllllIIlllIlIIlIIlllllllI + 3, llllllllllllIIlllIlIIlIlIIIIIlIl + 5, 0, llllllllllllIIlllIlIIlIIlllllllI + 4, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
            }
            else {
                this.fillWithBlocks(llllllllllllIIlllIlIIlIlIIIIIlll, llllllllllllIIlllIlIIlIlIIIIIllI, llllllllllllIIlllIlIIlIlIIIIIlIl + 0, 0, llllllllllllIIlllIlIIlIIlllllllI + 0, llllllllllllIIlllIlIIlIlIIIIIlIl + 8 - 1, 0, llllllllllllIIlllIlIIlIIlllllllI + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
            }
        }
        
        protected void generateBoxOnFillOnly(final World llllllllllllIIlllIlIIlIIlllIIIIl, final StructureBoundingBox llllllllllllIIlllIlIIlIIlllIIIII, final int llllllllllllIIlllIlIIlIIllIlllll, final int llllllllllllIIlllIlIIlIIllIllllI, final int llllllllllllIIlllIlIIlIIllIlllIl, final int llllllllllllIIlllIlIIlIIlllIlIIl, final int llllllllllllIIlllIlIIlIIlllIlIII, final int llllllllllllIIlllIlIIlIIlllIIlll, final IBlockState llllllllllllIIlllIlIIlIIlllIIllI) {
            for (int llllllllllllIIlllIlIIlIIlllIIlIl = llllllllllllIIlllIlIIlIIllIllllI; llllllllllllIIlllIlIIlIIlllIIlIl <= llllllllllllIIlllIlIIlIIlllIlIII; ++llllllllllllIIlllIlIIlIIlllIIlIl) {
                for (int llllllllllllIIlllIlIIlIIlllIIlII = llllllllllllIIlllIlIIlIIllIlllll; llllllllllllIIlllIlIIlIIlllIIlII <= llllllllllllIIlllIlIIlIIlllIlIIl; ++llllllllllllIIlllIlIIlIIlllIIlII) {
                    for (int llllllllllllIIlllIlIIlIIlllIIIll = llllllllllllIIlllIlIIlIIllIlllIl; llllllllllllIIlllIlIIlIIlllIIIll <= llllllllllllIIlllIlIIlIIlllIIlll; ++llllllllllllIIlllIlIIlIIlllIIIll) {
                        if (this.getBlockStateFromPos(llllllllllllIIlllIlIIlIIlllIIIIl, llllllllllllIIlllIlIIlIIlllIIlII, llllllllllllIIlllIlIIlIIlllIIlIl, llllllllllllIIlllIlIIlIIlllIIIll, llllllllllllIIlllIlIIlIIlllIIIII) == Piece.WATER) {
                            this.setBlockState(llllllllllllIIlllIlIIlIIlllIIIIl, llllllllllllIIlllIlIIlIIlllIIllI, llllllllllllIIlllIlIIlIIlllIIlII, llllllllllllIIlllIlIIlIIlllIIlIl, llllllllllllIIlllIlIIlIIlllIIIll, llllllllllllIIlllIlIIlIIlllIIIII);
                        }
                    }
                }
            }
        }
        
        protected static final int getRoomIndex(final int llllllllllllIIlllIlIIlIlIlllIIII, final int llllllllllllIIlllIlIIlIlIllIllll, final int llllllllllllIIlllIlIIlIlIlllIIIl) {
            return llllllllllllIIlllIlIIlIlIllIllll * 25 + llllllllllllIIlllIlIIlIlIlllIIIl * 5 + llllllllllllIIlllIlIIlIlIlllIIII;
        }
        
        public Piece(final EnumFacing llllllllllllIIlllIlIIlIlIllIIIII, final StructureBoundingBox llllllllllllIIlllIlIIlIlIlIlllII) {
            super(1);
            this.setCoordBaseMode(llllllllllllIIlllIlIIlIlIllIIIII);
            this.boundingBox = llllllllllllIIlllIlIIlIlIlIlllII;
        }
        
        static {
            ROUGH_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.ROUGH_META);
            BRICKS_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.BRICKS_META);
            DARK_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.DARK_META);
            DOT_DECO_DATA = Piece.BRICKS_PRISMARINE;
            SEA_LANTERN = Blocks.SEA_LANTERN.getDefaultState();
            WATER = Blocks.WATER.getDefaultState();
            GRIDROOM_SOURCE_INDEX = getRoomIndex(2, 0, 0);
            GRIDROOM_TOP_CONNECT_INDEX = getRoomIndex(2, 2, 0);
            GRIDROOM_LEFTWING_CONNECT_INDEX = getRoomIndex(0, 1, 0);
            GRIDROOM_RIGHTWING_CONNECT_INDEX = getRoomIndex(4, 1, 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIIlllIlIIlIlIIlllIIl) {
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final short llllllllllllIIlllIlIIlIIlIIllIII = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllIIlllIlIIlIIlIIllIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIIlllIlIIlIIlIIllIII;
        }
        
        protected Piece(final int llllllllllllIIlllIlIIlIlIlIIllll, final EnumFacing llllllllllllIIlllIlIIlIlIlIIIIll, final RoomDefinition llllllllllllIIlllIlIIlIlIlIIIIlI, final int llllllllllllIIlllIlIIlIlIlIIIIIl, final int llllllllllllIIlllIlIIlIlIlIIIIII, final int llllllllllllIIlllIlIIlIlIIllllll) {
            super(llllllllllllIIlllIlIIlIlIlIIllll);
            this.setCoordBaseMode(llllllllllllIIlllIlIIlIlIlIIIIll);
            this.roomDefinition = llllllllllllIIlllIlIIlIlIlIIIIlI;
            final int llllllllllllIIlllIlIIlIlIlIIlIIl = llllllllllllIIlllIlIIlIlIlIIIIlI.index;
            final int llllllllllllIIlllIlIIlIlIlIIlIII = llllllllllllIIlllIlIIlIlIlIIlIIl % 5;
            final int llllllllllllIIlllIlIIlIlIlIIIlll = llllllllllllIIlllIlIIlIlIlIIlIIl / 5 % 5;
            final int llllllllllllIIlllIlIIlIlIlIIIllI = llllllllllllIIlllIlIIlIlIlIIlIIl / 25;
            if (llllllllllllIIlllIlIIlIlIlIIIIll != EnumFacing.NORTH && llllllllllllIIlllIlIIlIlIlIIIIll != EnumFacing.SOUTH) {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllIIlllIlIIlIlIIllllll * 8 - 1, llllllllllllIIlllIlIIlIlIlIIIIII * 4 - 1, llllllllllllIIlllIlIIlIlIlIIIIIl * 8 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllIIlllIlIIlIlIlIIIIIl * 8 - 1, llllllllllllIIlllIlIIlIlIlIIIIII * 4 - 1, llllllllllllIIlllIlIIlIlIIllllll * 8 - 1);
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIlllIlIIlIlIlIIIIll.ordinal()]) {
                case 3: {
                    this.boundingBox.offset(llllllllllllIIlllIlIIlIlIlIIlIII * 8, llllllllllllIIlllIlIIlIlIlIIIllI * 4, -(llllllllllllIIlllIlIIlIlIlIIIlll + llllllllllllIIlllIlIIlIlIIllllll) * 8 + 1);
                    break;
                }
                case 4: {
                    this.boundingBox.offset(llllllllllllIIlllIlIIlIlIlIIlIII * 8, llllllllllllIIlllIlIIlIlIlIIIllI * 4, llllllllllllIIlllIlIIlIlIlIIIlll * 8);
                    break;
                }
                case 5: {
                    this.boundingBox.offset(-(llllllllllllIIlllIlIIlIlIlIIIlll + llllllllllllIIlllIlIIlIlIIllllll) * 8 + 1, llllllllllllIIlllIlIIlIlIlIIIllI * 4, llllllllllllIIlllIlIIlIlIlIIlIII * 8);
                    break;
                }
                default: {
                    this.boundingBox.offset(llllllllllllIIlllIlIIlIlIlIIIlll * 8, llllllllllllIIlllIlIIlIlIlIIIllI * 4, llllllllllllIIlllIlIIlIlIlIIlIII * 8);
                    break;
                }
            }
        }
        
        public Piece() {
            super(0);
        }
        
        protected boolean doesChunkIntersect(final StructureBoundingBox llllllllllllIIlllIlIIlIIllIIlIlI, final int llllllllllllIIlllIlIIlIIlIllllll, final int llllllllllllIIlllIlIIlIIllIIlIII, final int llllllllllllIIlllIlIIlIIllIIIlll, final int llllllllllllIIlllIlIIlIIllIIIllI) {
            final int llllllllllllIIlllIlIIlIIllIIIlIl = this.getXWithOffset(llllllllllllIIlllIlIIlIIlIllllll, llllllllllllIIlllIlIIlIIllIIlIII);
            final int llllllllllllIIlllIlIIlIIllIIIlII = this.getZWithOffset(llllllllllllIIlllIlIIlIIlIllllll, llllllllllllIIlllIlIIlIIllIIlIII);
            final int llllllllllllIIlllIlIIlIIllIIIIll = this.getXWithOffset(llllllllllllIIlllIlIIlIIllIIIlll, llllllllllllIIlllIlIIlIIllIIIllI);
            final int llllllllllllIIlllIlIIlIIllIIIIlI = this.getZWithOffset(llllllllllllIIlllIlIIlIIllIIIlll, llllllllllllIIlllIlIIlIIllIIIllI);
            return llllllllllllIIlllIlIIlIIllIIlIlI.intersectsWith(Math.min(llllllllllllIIlllIlIIlIIllIIIlIl, llllllllllllIIlllIlIIlIIllIIIIll), Math.min(llllllllllllIIlllIlIIlIIllIIIlII, llllllllllllIIlllIlIIlIIllIIIIlI), Math.max(llllllllllllIIlllIlIIlIIllIIIlIl, llllllllllllIIlllIlIIlIIllIIIIll), Math.max(llllllllllllIIlllIlIIlIIllIIIlII, llllllllllllIIlllIlIIlIIllIIIIlI));
        }
        
        public Piece(final int llllllllllllIIlllIlIIlIlIllIIlll) {
            super(llllllllllllIIlllIlIIlIlIllIIlll);
        }
    }
    
    static class RoomDefinition
    {
        /* synthetic */ boolean isSource;
        /* synthetic */ boolean claimed;
        /* synthetic */ int scanIndex;
        /* synthetic */ boolean[] hasOpening;
        /* synthetic */ RoomDefinition[] connections;
        /* synthetic */ int index;
        
        public int countOpenings() {
            int lllllllllllllllIllIlllIIlllIlIlI = 0;
            for (int lllllllllllllllIllIlllIIlllIlIIl = 0; lllllllllllllllIllIlllIIlllIlIIl < 6; ++lllllllllllllllIllIlllIIlllIlIIl) {
                if (this.hasOpening[lllllllllllllllIllIlllIIlllIlIIl]) {
                    ++lllllllllllllllIllIlllIIlllIlIlI;
                }
            }
            return lllllllllllllllIllIlllIIlllIlIlI;
        }
        
        public boolean findSource(final int lllllllllllllllIllIlllIIllllIllI) {
            if (this.isSource) {
                return true;
            }
            this.scanIndex = lllllllllllllllIllIlllIIllllIllI;
            for (int lllllllllllllllIllIlllIIllllIlIl = 0; lllllllllllllllIllIlllIIllllIlIl < 6; ++lllllllllllllllIllIlllIIllllIlIl) {
                if (this.connections[lllllllllllllllIllIlllIIllllIlIl] != null && this.hasOpening[lllllllllllllllIllIlllIIllllIlIl] && this.connections[lllllllllllllllIllIlllIIllllIlIl].scanIndex != lllllllllllllllIllIlllIIllllIllI && this.connections[lllllllllllllllIllIlllIIllllIlIl].findSource(lllllllllllllllIllIlllIIllllIllI)) {
                    return true;
                }
            }
            return false;
        }
        
        public RoomDefinition(final int lllllllllllllllIllIlllIlIIIIlIlI) {
            this.connections = new RoomDefinition[6];
            this.hasOpening = new boolean[6];
            this.index = lllllllllllllllIllIlllIlIIIIlIlI;
        }
        
        public boolean isSpecial() {
            return this.index >= 75;
        }
        
        public void updateOpenings() {
            for (int lllllllllllllllIllIlllIIllllllIl = 0; lllllllllllllllIllIlllIIllllllIl < 6; ++lllllllllllllllIllIlllIIllllllIl) {
                this.hasOpening[lllllllllllllllIllIlllIIllllllIl] = (this.connections[lllllllllllllllIllIlllIIllllllIl] != null);
            }
        }
        
        public void setConnection(final EnumFacing lllllllllllllllIllIlllIlIIIIIlIl, final RoomDefinition lllllllllllllllIllIlllIlIIIIIIIl) {
            this.connections[lllllllllllllllIllIlllIlIIIIIlIl.getIndex()] = lllllllllllllllIllIlllIlIIIIIIIl;
            lllllllllllllllIllIlllIlIIIIIIIl.connections[lllllllllllllllIllIlllIlIIIIIlIl.getOpposite().getIndex()] = this;
        }
    }
    
    interface MonumentRoomFitHelper
    {
        Piece create(final EnumFacing p0, final RoomDefinition p1, final Random p2);
        
        boolean fits(final RoomDefinition p0);
    }
    
    public static class DoubleYZRoom extends Piece
    {
        public DoubleYZRoom() {
        }
        
        public DoubleYZRoom(final EnumFacing lllllllllllIIIllIlIIIllIIlIIlIII, final RoomDefinition lllllllllllIIIllIlIIIllIIlIIIlll, final Random lllllllllllIIIllIlIIIllIIlIIIllI) {
            super(1, lllllllllllIIIllIlIIIllIIlIIlIII, lllllllllllIIIllIlIIIllIIlIIIlll, 1, 2, 2);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIIllIlIIIllIIIlllIII, final Random lllllllllllIIIllIlIIIllIIIllIlll, final StructureBoundingBox lllllllllllIIIllIlIIIllIIIlIlIll) {
            final RoomDefinition lllllllllllIIIllIlIIIllIIIllIlIl = this.roomDefinition.connections[EnumFacing.NORTH.getIndex()];
            final RoomDefinition lllllllllllIIIllIlIIIllIIIllIlII = this.roomDefinition;
            final RoomDefinition lllllllllllIIIllIlIIIllIIIllIIll = lllllllllllIIIllIlIIIllIIIllIlIl.connections[EnumFacing.UP.getIndex()];
            final RoomDefinition lllllllllllIIIllIlIIIllIIIllIIlI = lllllllllllIIIllIlIIIllIIIllIlII.connections[EnumFacing.UP.getIndex()];
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 8, lllllllllllIIIllIlIIIllIIIllIlIl.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 0, lllllllllllIIIllIlIIIllIIIllIlII.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIlI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 8, 1, 6, 8, 7, DoubleYZRoom.ROUGH_PRISMARINE);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 8, 8, 6, 8, 14, DoubleYZRoom.ROUGH_PRISMARINE);
            }
            for (int lllllllllllIIIllIlIIIllIIIllIIIl = 1; lllllllllllIIIllIlIIIllIIIllIIIl <= 7; ++lllllllllllIIIllIlIIIllIIIllIIIl) {
                IBlockState lllllllllllIIIllIlIIIllIIIllIIII = DoubleYZRoom.BRICKS_PRISMARINE;
                if (lllllllllllIIIllIlIIIllIIIllIIIl == 2 || lllllllllllIIIllIlIIIllIIIllIIIl == 6) {
                    lllllllllllIIIllIlIIIllIIIllIIII = DoubleYZRoom.ROUGH_PRISMARINE;
                }
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, lllllllllllIIIllIlIIIllIIIllIIIl, 0, 0, lllllllllllIIIllIlIIIllIIIllIIIl, 15, lllllllllllIIIllIlIIIllIIIllIIII, lllllllllllIIIllIlIIIllIIIllIIII, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 7, lllllllllllIIIllIlIIIllIIIllIIIl, 0, 7, lllllllllllIIIllIlIIIllIIIllIIIl, 15, lllllllllllIIIllIlIIIllIIIllIIII, lllllllllllIIIllIlIIIllIIIllIIII, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, lllllllllllIIIllIlIIIllIIIllIIIl, 0, 6, lllllllllllIIIllIlIIIllIIIllIIIl, 0, lllllllllllIIIllIlIIIllIIIllIIII, lllllllllllIIIllIlIIIllIIIllIIII, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, lllllllllllIIIllIlIIIllIIIllIIIl, 15, 6, lllllllllllIIIllIlIIIllIIIllIIIl, 15, lllllllllllIIIllIlIIIllIIIllIIII, lllllllllllIIIllIlIIIllIIIllIIII, false);
            }
            for (int lllllllllllIIIllIlIIIllIIIlIllll = 1; lllllllllllIIIllIlIIIllIIIlIllll <= 7; ++lllllllllllIIIllIlIIIllIIIlIllll) {
                IBlockState lllllllllllIIIllIlIIIllIIIlIlllI = DoubleYZRoom.DARK_PRISMARINE;
                if (lllllllllllIIIllIlIIIllIIIlIllll == 2 || lllllllllllIIIllIlIIIllIIIlIllll == 6) {
                    lllllllllllIIIllIlIIIllIIIlIlllI = DoubleYZRoom.SEA_LANTERN;
                }
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 3, lllllllllllIIIllIlIIIllIIIlIllll, 7, 4, lllllllllllIIIllIlIIIllIIIlIllll, 8, lllllllllllIIIllIlIIIllIIIlIlllI, lllllllllllIIIllIlIIIllIIIlIlllI, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 3, 1, 0, 4, 2, 0, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 7, 1, 3, 7, 2, 4, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlII.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 1, 3, 0, 2, 4, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 3, 1, 15, 4, 2, 15, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlIl.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 1, 11, 0, 2, 12, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIlIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 7, 1, 11, 7, 2, 12, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIlI.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 3, 5, 0, 4, 6, 0, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIlI.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 7, 5, 3, 7, 6, 4, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 5, 4, 2, 6, 4, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 6, 1, 2, 6, 3, 2, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 6, 1, 5, 6, 3, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIlI.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 5, 3, 0, 6, 4, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 4, 2, 2, 4, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 1, 2, 1, 3, 2, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 1, 5, 1, 3, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 3, 5, 15, 4, 6, 15, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 0, 5, 11, 0, 6, 12, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 4, 10, 2, 4, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 1, 10, 1, 3, 10, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 1, 1, 13, 1, 3, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllIIIllIlIIIllIIIllIIll.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 7, 5, 11, 7, 6, 12, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 5, 4, 10, 6, 4, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 6, 1, 10, 6, 3, 10, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIIllIlIIIllIIIlllIII, lllllllllllIIIllIlIIIllIIIlIlIll, 6, 1, 13, 6, 3, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            return true;
        }
    }
    
    public static class SimpleTopRoom extends Piece
    {
        public SimpleTopRoom() {
        }
        
        public SimpleTopRoom(final EnumFacing lllllllllllIllIlIlIlllIlllllllIl, final RoomDefinition lllllllllllIllIlIlIlllIlllllllII, final Random lllllllllllIllIlIlIlllIllllllIll) {
            super(1, lllllllllllIllIlIlIlllIlllllllIl, lllllllllllIllIlIlIlllIlllllllII, 1, 1, 1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIllIlIlIlllIllllIlIII, final Random lllllllllllIllIlIlIlllIllllIlllI, final StructureBoundingBox lllllllllllIllIlIlIlllIllllIllIl) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (this.roomDefinition.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 4, 1, 6, 4, 6, SimpleTopRoom.ROUGH_PRISMARINE);
            }
            for (int lllllllllllIllIlIlIlllIllllIllII = 1; lllllllllllIllIlIlIlllIllllIllII <= 6; ++lllllllllllIllIlIlIlllIllllIllII) {
                for (int lllllllllllIllIlIlIlllIllllIlIll = 1; lllllllllllIllIlIlIlllIllllIlIll <= 6; ++lllllllllllIllIlIlIlllIllllIlIll) {
                    if (lllllllllllIllIlIlIlllIllllIlllI.nextInt(3) != 0) {
                        final int lllllllllllIllIlIlIlllIllllIlIlI = 2 + ((lllllllllllIllIlIlIlllIllllIlllI.nextInt(4) != 0) ? 1 : 0);
                        this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, lllllllllllIllIlIlIlllIllllIllII, lllllllllllIllIlIlIlllIllllIlIlI, lllllllllllIllIlIlIlllIllllIlIll, lllllllllllIllIlIlIlllIllllIllII, 3, lllllllllllIllIlIlIlllIllllIlIll, Blocks.SPONGE.getStateFromMeta(1), Blocks.SPONGE.getStateFromMeta(1), false);
                    }
                }
            }
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 0, 1, 0, 0, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 7, 1, 0, 7, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 1, 0, 6, 1, 0, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 1, 7, 6, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 0, 2, 0, 0, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 7, 2, 0, 7, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 2, 0, 6, 2, 0, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 2, 7, 6, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 0, 3, 0, 0, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 7, 3, 0, 7, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 3, 0, 6, 3, 0, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 1, 3, 7, 6, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 0, 1, 3, 0, 2, 4, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 7, 1, 3, 7, 2, 4, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 3, 1, 0, 4, 2, 0, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 3, 1, 7, 4, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIlIlllIllllIlIII, lllllllllllIllIlIlIlllIllllIllIl, 3, 1, 0, 4, 2, 0, false);
            }
            return true;
        }
    }
    
    public static class Penthouse extends Piece
    {
        public Penthouse(final EnumFacing llllllllllllIIlIIIIlIIlllIIIlllI, final StructureBoundingBox llllllllllllIIlIIIIlIIlllIIlIIII) {
            super(llllllllllllIIlIIIIlIIlllIIIlllI, llllllllllllIIlIIIIlIIlllIIlIIII);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIIlIIIIlIIllIlllllIl, final Random llllllllllllIIlIIIIlIIlllIIIIlII, final StructureBoundingBox llllllllllllIIlIIIIlIIllIlllllII) {
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 2, -1, 2, 11, -1, 11, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 0, -1, 0, 1, -1, 11, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 12, -1, 0, 13, -1, 11, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 2, -1, 0, 11, -1, 1, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 2, -1, 12, 11, -1, 13, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 0, 0, 0, 0, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 13, 0, 0, 13, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 1, 0, 0, 12, 0, 0, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 1, 0, 13, 12, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            for (int llllllllllllIIlIIIIlIIlllIIIIIlI = 2; llllllllllllIIlIIIIlIIlllIIIIIlI <= 11; llllllllllllIIlIIIIlIIlllIIIIIlI += 3) {
                this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.SEA_LANTERN, 0, 0, llllllllllllIIlIIIIlIIlllIIIIIlI, llllllllllllIIlIIIIlIIllIlllllII);
                this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.SEA_LANTERN, 13, 0, llllllllllllIIlIIIIlIIlllIIIIIlI, llllllllllllIIlIIIIlIIllIlllllII);
                this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.SEA_LANTERN, llllllllllllIIlIIIIlIIlllIIIIIlI, 0, 0, llllllllllllIIlIIIIlIIllIlllllII);
            }
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 2, 0, 3, 4, 0, 9, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 9, 0, 3, 11, 0, 9, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 4, 0, 9, 9, 0, 11, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.BRICKS_PRISMARINE, 5, 0, 8, llllllllllllIIlIIIIlIIllIlllllII);
            this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.BRICKS_PRISMARINE, 8, 0, 8, llllllllllllIIlIIIIlIIllIlllllII);
            this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.BRICKS_PRISMARINE, 10, 0, 10, llllllllllllIIlIIIIlIIllIlllllII);
            this.setBlockState(llllllllllllIIlIIIIlIIllIlllllIl, Penthouse.BRICKS_PRISMARINE, 3, 0, 10, llllllllllllIIlIIIIlIIllIlllllII);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 3, 0, 3, 3, 0, 7, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 10, 0, 3, 10, 0, 7, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 6, 0, 10, 7, 0, 10, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            int llllllllllllIIlIIIIlIIlllIIIIIIl = 3;
            for (int llllllllllllIIlIIIIlIIlllIIIIIII = 0; llllllllllllIIlIIIIlIIlllIIIIIII < 2; ++llllllllllllIIlIIIIlIIlllIIIIIII) {
                for (int llllllllllllIIlIIIIlIIllIlllllll = 2; llllllllllllIIlIIIIlIIllIlllllll <= 8; llllllllllllIIlIIIIlIIllIlllllll += 3) {
                    this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, llllllllllllIIlIIIIlIIlllIIIIIIl, 0, llllllllllllIIlIIIIlIIllIlllllll, llllllllllllIIlIIIIlIIlllIIIIIIl, 2, llllllllllllIIlIIIIlIIllIlllllll, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
                }
                llllllllllllIIlIIIIlIIlllIIIIIIl = 10;
            }
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 5, 0, 10, 5, 2, 10, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 8, 0, 10, 8, 2, 10, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 6, -1, 7, 7, -1, 8, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.generateWaterBox(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 6, -1, 3, 7, -1, 4, false);
            this.spawnElder(llllllllllllIIlIIIIlIIllIlllllIl, llllllllllllIIlIIIIlIIllIlllllII, 6, 1, 6);
            return true;
        }
        
        public Penthouse() {
        }
    }
    
    public static class EntryRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIlIlIIlllllIllll, final Random lllllllllllllIIIIlIlIIllllllIIlI, final StructureBoundingBox lllllllllllllIIIIlIlIIllllllIIIl) {
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 0, 3, 0, 2, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 5, 3, 0, 7, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 0, 2, 0, 1, 2, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 6, 2, 0, 7, 2, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 0, 1, 0, 0, 1, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 7, 1, 0, 7, 1, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 0, 1, 7, 7, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 1, 1, 0, 2, 3, 0, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 5, 1, 0, 6, 3, 0, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 3, 1, 7, 4, 2, 7, false);
            }
            if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 0, 1, 3, 1, 2, 4, false);
            }
            if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIIlIlIIlllllIllll, lllllllllllllIIIIlIlIIllllllIIIl, 6, 1, 3, 7, 2, 4, false);
            }
            return true;
        }
        
        public EntryRoom() {
        }
        
        public EntryRoom(final EnumFacing lllllllllllllIIIIlIlIIlllllllIIl, final RoomDefinition lllllllllllllIIIIlIlIIlllllllIll) {
            super(1, lllllllllllllIIIIlIlIIlllllllIIl, lllllllllllllIIIIlIlIIlllllllIll, 1, 1, 1);
        }
    }
    
    public static class WingRoom extends Piece
    {
        private /* synthetic */ int mainDesign;
        
        public WingRoom() {
        }
        
        public WingRoom(final EnumFacing lllllllllllIIlllIllllIIIIIlIlIII, final StructureBoundingBox lllllllllllIIlllIllllIIIIIlIlIll, final int lllllllllllIIlllIllllIIIIIlIlIlI) {
            super(lllllllllllIIlllIllllIIIIIlIlIII, lllllllllllIIlllIllllIIIIIlIlIll);
            this.mainDesign = (lllllllllllIIlllIllllIIIIIlIlIlI & 0x1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlllIllllIIIIIIlllIl, final Random lllllllllllIIlllIllllIIIIIIlllII, final StructureBoundingBox lllllllllllIIlllIllllIIIIIIllIll) {
            if (this.mainDesign == 0) {
                for (int lllllllllllIIlllIllllIIIIIIllIlI = 0; lllllllllllIIlllIllllIIIIIIllIlI < 4; ++lllllllllllIIlllIllllIIIIIIllIlI) {
                    this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 10 - lllllllllllIIlllIllllIIIIIIllIlI, 3 - lllllllllllIIlllIllllIIIIIIllIlI, 20 - lllllllllllIIlllIllllIIIIIIllIlI, 12 + lllllllllllIIlllIllllIIIIIIllIlI, 3 - lllllllllllIIlllIllllIIIIIIllIlI, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 7, 0, 6, 15, 0, 16, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 6, 0, 6, 6, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 16, 0, 6, 16, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 7, 1, 7, 7, 1, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 15, 1, 7, 15, 1, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 7, 1, 6, 9, 3, 6, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 13, 1, 6, 15, 3, 6, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 8, 1, 7, 9, 1, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 13, 1, 7, 14, 1, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 9, 0, 5, 13, 0, 5, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 10, 0, 7, 12, 0, 7, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 8, 0, 10, 8, 0, 12, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 14, 0, 10, 14, 0, 12, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                for (int lllllllllllIIlllIllllIIIIIIllIIl = 18; lllllllllllIIlllIllllIIIIIIllIIl >= 7; lllllllllllIIlllIllllIIIIIIllIIl -= 3) {
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 6, 3, lllllllllllIIlllIllllIIIIIIllIIl, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 16, 3, lllllllllllIIlllIllllIIIIIIllIIl, lllllllllllIIlllIllllIIIIIIllIll);
                }
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 10, 0, 10, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 12, 0, 10, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 10, 0, 12, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 12, 0, 12, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 8, 3, 6, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 14, 3, 6, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 4, 2, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 4, 1, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 4, 0, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 18, 2, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 18, 1, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 18, 0, 4, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 4, 2, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 4, 1, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 4, 0, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 18, 2, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, 18, 1, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 18, 0, 18, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 9, 7, 20, lllllllllllIIlllIllllIIIIIIllIll);
                this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, 13, 7, 20, lllllllllllIIlllIllllIIIIIIllIll);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 6, 0, 21, 7, 4, 21, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 15, 0, 21, 16, 4, 21, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.spawnElder(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 11, 2, 16);
            }
            else if (this.mainDesign == 1) {
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 9, 3, 18, 13, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 9, 0, 18, 9, 2, 18, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 13, 0, 18, 13, 2, 18, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                int lllllllllllIIlllIllllIIIIIIllIII = 9;
                final int lllllllllllIIlllIllllIIIIIIlIlll = 20;
                final int lllllllllllIIlllIllllIIIIIIlIllI = 5;
                for (int lllllllllllIIlllIllllIIIIIIlIlIl = 0; lllllllllllIIlllIllllIIIIIIlIlIl < 2; ++lllllllllllIIlllIllllIIIIIIlIlIl) {
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, lllllllllllIIlllIllllIIIIIIllIII, 6, 20, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, lllllllllllIIlllIllllIIIIIIllIII, 5, 20, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.BRICKS_PRISMARINE, lllllllllllIIlllIllllIIIIIIllIII, 4, 20, lllllllllllIIlllIllllIIIIIIllIll);
                    lllllllllllIIlllIllllIIIIIIllIII = 13;
                }
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 7, 3, 7, 15, 3, 14, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                lllllllllllIIlllIllllIIIIIIllIII = 10;
                for (int lllllllllllIIlllIllllIIIIIIlIlII = 0; lllllllllllIIlllIllllIIIIIIlIlII < 2; ++lllllllllllIIlllIllllIIIIIIlIlII) {
                    this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, lllllllllllIIlllIllllIIIIIIllIII, 0, 10, lllllllllllIIlllIllllIIIIIIllIII, 6, 10, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, lllllllllllIIlllIllllIIIIIIllIII, 0, 12, lllllllllllIIlllIllllIIIIIIllIII, 6, 12, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, lllllllllllIIlllIllllIIIIIIllIII, 0, 10, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, lllllllllllIIlllIllllIIIIIIllIII, 0, 12, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, lllllllllllIIlllIllllIIIIIIllIII, 4, 10, lllllllllllIIlllIllllIIIIIIllIll);
                    this.setBlockState(lllllllllllIIlllIllllIIIIIIlllIl, WingRoom.SEA_LANTERN, lllllllllllIIlllIllllIIIIIIllIII, 4, 12, lllllllllllIIlllIllllIIIIIIllIll);
                    lllllllllllIIlllIllllIIIIIIllIII = 12;
                }
                lllllllllllIIlllIllllIIIIIIllIII = 8;
                for (int lllllllllllIIlllIllllIIIIIIlIIll = 0; lllllllllllIIlllIllllIIIIIIlIIll < 2; ++lllllllllllIIlllIllllIIIIIIlIIll) {
                    this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, lllllllllllIIlllIllllIIIIIIllIII, 0, 7, lllllllllllIIlllIllllIIIIIIllIII, 2, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, lllllllllllIIlllIllllIIIIIIllIII, 0, 14, lllllllllllIIlllIllllIIIIIIllIII, 2, 14, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    lllllllllllIIlllIllllIIIIIIllIII = 14;
                }
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 8, 3, 8, 8, 3, 13, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 14, 3, 8, 14, 3, 13, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.spawnElder(lllllllllllIIlllIllllIIIIIIlllIl, lllllllllllIIlllIllllIIIIIIllIll, 11, 5, 13);
            }
            return true;
        }
    }
    
    public static class DoubleYRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllIIIlIllIIIIIIlIIIIIl, final Random llllllllllllIIIlIllIIIIIIlIIIIII, final StructureBoundingBox llllllllllllIIIlIllIIIIIIIllIlll) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            final RoomDefinition llllllllllllIIIlIllIIIIIIIlllllI = this.roomDefinition.connections[EnumFacing.UP.getIndex()];
            if (llllllllllllIIIlIllIIIIIIIlllllI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 1, 8, 1, 6, 8, 6, DoubleYRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, 4, 0, 0, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 7, 4, 0, 7, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 1, 4, 0, 6, 4, 0, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 1, 4, 7, 6, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 2, 4, 1, 2, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 1, 4, 2, 1, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 5, 4, 1, 5, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 6, 4, 2, 6, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 2, 4, 5, 2, 4, 6, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 1, 4, 5, 1, 4, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 5, 4, 5, 5, 4, 6, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 6, 4, 5, 6, 4, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            RoomDefinition llllllllllllIIIlIllIIIIIIIllllIl = this.roomDefinition;
            for (int llllllllllllIIIlIllIIIIIIIllllII = 1; llllllllllllIIIlIllIIIIIIIllllII <= 5; llllllllllllIIIlIllIIIIIIIllllII += 4) {
                int llllllllllllIIIlIllIIIIIIIlllIll = 0;
                if (llllllllllllIIIlIllIIIIIIIllllIl.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 2, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 2, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 5, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 5, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 3, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, 4, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 7, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, llllllllllllIIIlIllIIIIIIIllllII + 1, llllllllllllIIIlIllIIIIIIIlllIll, 7, llllllllllllIIIlIllIIIIIIIllllII + 1, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                llllllllllllIIIlIllIIIIIIIlllIll = 7;
                if (llllllllllllIIIlIllIIIIIIIllllIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 2, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 2, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 5, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 5, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 3, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, 4, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, llllllllllllIIIlIllIIIIIIIllllII, llllllllllllIIIlIllIIIIIIIlllIll, 7, llllllllllllIIIlIllIIIIIIIllllII + 2, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, 0, llllllllllllIIIlIllIIIIIIIllllII + 1, llllllllllllIIIlIllIIIIIIIlllIll, 7, llllllllllllIIIlIllIIIIIIIllllII + 1, llllllllllllIIIlIllIIIIIIIlllIll, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                int llllllllllllIIIlIllIIIIIIIlllIlI = 0;
                if (llllllllllllIIIlIllIIIIIIIllllIl.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 2, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 5, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 3, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 4, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 0, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 1, 0, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 1, 7, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                llllllllllllIIIlIllIIIIIIIlllIlI = 7;
                if (llllllllllllIIIlIllIIIIIIIllllIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 2, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 5, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 3, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 4, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII, 0, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 2, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllIIIlIllIIIIIIlIIIIIl, llllllllllllIIIlIllIIIIIIIllIlll, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 1, 0, llllllllllllIIIlIllIIIIIIIlllIlI, llllllllllllIIIlIllIIIIIIIllllII + 1, 7, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                llllllllllllIIIlIllIIIIIIIllllIl = llllllllllllIIIlIllIIIIIIIlllllI;
            }
            return true;
        }
        
        public DoubleYRoom() {
        }
        
        public DoubleYRoom(final EnumFacing llllllllllllIIIlIllIIIIIIlIlIIII, final RoomDefinition llllllllllllIIIlIllIIIIIIlIIllll, final Random llllllllllllIIIlIllIIIIIIlIIlllI) {
            super(1, llllllllllllIIIlIllIIIIIIlIlIIII, llllllllllllIIIlIllIIIIIIlIIllll, 1, 2, 1);
        }
    }
    
    static class XDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lllllllllllIIIIIllIlIllIlIIlIlIl, final RoomDefinition lllllllllllIIIIIllIlIllIlIIlIlll, final Random lllllllllllIIIIIllIlIllIlIIlIIll) {
            lllllllllllIIIIIllIlIllIlIIlIlll.claimed = true;
            lllllllllllIIIIIllIlIllIlIIlIlll.connections[EnumFacing.EAST.getIndex()].claimed = true;
            return new DoubleXRoom(lllllllllllIIIIIllIlIllIlIIlIlIl, lllllllllllIIIIIllIlIllIlIIlIlll, lllllllllllIIIIIllIlIllIlIIlIIll);
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllIIIIIllIlIllIlIIlllIl) {
            return lllllllllllIIIIIllIlIllIlIIlllIl.hasOpening[EnumFacing.EAST.getIndex()] && !lllllllllllIIIIIllIlIllIlIIlllIl.connections[EnumFacing.EAST.getIndex()].claimed;
        }
        
        private XDoubleRoomFitHelper() {
        }
    }
    
    public static class DoubleXRoom extends Piece
    {
        public DoubleXRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIllIIIlIIlIlIIlIIlll, final Random llllllllllllIllIIIlIIlIlIIlIIllI, final StructureBoundingBox llllllllllllIllIIIlIIlIlIIlIIIII) {
            final RoomDefinition llllllllllllIllIIIlIIlIlIIlIIlII = this.roomDefinition.connections[EnumFacing.EAST.getIndex()];
            final RoomDefinition llllllllllllIllIIIlIIlIlIIlIIIll = this.roomDefinition;
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 8, 0, llllllllllllIllIIIlIIlIlIIlIIlII.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 0, 0, llllllllllllIllIIIlIIlIlIIlIIIll.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIIll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 4, 1, 7, 4, 6, DoubleXRoom.ROUGH_PRISMARINE);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIlII.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 8, 4, 1, 14, 4, 6, DoubleXRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 0, 3, 0, 0, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 15, 3, 0, 15, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 3, 0, 15, 3, 0, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 3, 7, 14, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 0, 2, 0, 0, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 15, 2, 0, 15, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 2, 0, 15, 2, 0, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 2, 7, 14, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 0, 1, 0, 0, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 15, 1, 0, 15, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 1, 0, 15, 1, 0, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 1, 1, 7, 14, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 5, 1, 0, 10, 1, 4, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 6, 2, 0, 9, 2, 3, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 5, 3, 0, 10, 3, 4, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(llllllllllllIllIIIlIIlIlIIlIIlll, DoubleXRoom.SEA_LANTERN, 6, 2, 3, llllllllllllIllIIIlIIlIlIIlIIIII);
            this.setBlockState(llllllllllllIllIIIlIIlIlIIlIIlll, DoubleXRoom.SEA_LANTERN, 9, 2, 3, llllllllllllIllIIIlIIlIlIIlIIIII);
            if (llllllllllllIllIIIlIIlIlIIlIIIll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 3, 1, 0, 4, 2, 0, false);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 3, 1, 7, 4, 2, 7, false);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIIll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 0, 1, 3, 0, 2, 4, false);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIlII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 11, 1, 0, 12, 2, 0, false);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIlII.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 11, 1, 7, 12, 2, 7, false);
            }
            if (llllllllllllIllIIIlIIlIlIIlIIlII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(llllllllllllIllIIIlIIlIlIIlIIlll, llllllllllllIllIIIlIIlIlIIlIIIII, 15, 1, 3, 15, 2, 4, false);
            }
            return true;
        }
        
        public DoubleXRoom(final EnumFacing llllllllllllIllIIIlIIlIlIIllIIll, final RoomDefinition llllllllllllIllIIIlIIlIlIIlIlllI, final Random llllllllllllIllIIIlIIlIlIIllIIIl) {
            super(1, llllllllllllIllIIIlIIlIlIIllIIll, llllllllllllIllIIIlIIlIlIIlIlllI, 2, 1, 1);
        }
    }
    
    static class YZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lIlIIlIllIlIlI, final RoomDefinition lIlIIlIllIlIIl, final Random lIlIIlIllIlIII) {
            lIlIIlIllIlIIl.claimed = true;
            lIlIIlIllIlIIl.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            lIlIIlIllIlIIl.connections[EnumFacing.UP.getIndex()].claimed = true;
            lIlIIlIllIlIIl.connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleYZRoom(lIlIIlIllIlIlI, lIlIIlIllIlIIl, lIlIIlIllIlIII);
        }
        
        @Override
        public boolean fits(final RoomDefinition lIlIIlIlllIIlI) {
            if (lIlIIlIlllIIlI.hasOpening[EnumFacing.NORTH.getIndex()] && !lIlIIlIlllIIlI.connections[EnumFacing.NORTH.getIndex()].claimed && lIlIIlIlllIIlI.hasOpening[EnumFacing.UP.getIndex()] && !lIlIIlIlllIIlI.connections[EnumFacing.UP.getIndex()].claimed) {
                final RoomDefinition lIlIIlIlllIIIl = lIlIIlIlllIIlI.connections[EnumFacing.NORTH.getIndex()];
                return lIlIIlIlllIIIl.hasOpening[EnumFacing.UP.getIndex()] && !lIlIIlIlllIIIl.connections[EnumFacing.UP.getIndex()].claimed;
            }
            return false;
        }
        
        private YZDoubleRoomFitHelper() {
        }
    }
    
    public static class MonumentBuilding extends Piece
    {
        private /* synthetic */ RoomDefinition coreRoom;
        private /* synthetic */ RoomDefinition sourceRoom;
        private final /* synthetic */ List<Piece> childPieces;
        
        private void generateEntranceWall(final World llllllllllIlllIlIlllllIIlIIIIIII, final Random llllllllllIlllIlIlllllIIIlllllll, final StructureBoundingBox llllllllllIlllIlIlllllIIIllllIII) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIllllIII, 15, 20, 42, 21)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 15, 0, 21, 42, 0, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 26, 1, 21, 31, 3, 21, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 21, 12, 21, 36, 12, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 17, 11, 21, 40, 11, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 16, 10, 21, 41, 10, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 15, 7, 21, 42, 9, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 16, 6, 21, 41, 6, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 17, 5, 21, 40, 5, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 21, 4, 21, 36, 4, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 22, 3, 21, 26, 3, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 31, 3, 21, 35, 3, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 23, 2, 21, 25, 2, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 32, 2, 21, 34, 2, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 28, 4, 20, 29, 4, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 27, 3, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 30, 3, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 26, 2, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 31, 2, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 25, 1, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.BRICKS_PRISMARINE, 32, 1, 21, llllllllllIlllIlIlllllIIIllllIII);
                for (int llllllllllIlllIlIlllllIIIlllllIl = 0; llllllllllIlllIlIlllllIIIlllllIl < 7; ++llllllllllIlllIlIlllllIIIlllllIl) {
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 28 - llllllllllIlllIlIlllllIIIlllllIl, 6 + llllllllllIlllIlIlllllIIIlllllIl, 21, llllllllllIlllIlIlllllIIIllllIII);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 29 + llllllllllIlllIlIlllllIIIlllllIl, 6 + llllllllllIlllIlIlllllIIIlllllIl, 21, llllllllllIlllIlIlllllIIIllllIII);
                }
                for (int llllllllllIlllIlIlllllIIIlllllII = 0; llllllllllIlllIlIlllllIIIlllllII < 4; ++llllllllllIlllIlIlllllIIIlllllII) {
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 28 - llllllllllIlllIlIlllllIIIlllllII, 9 + llllllllllIlllIlIlllllIIIlllllII, 21, llllllllllIlllIlIlllllIIIllllIII);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 29 + llllllllllIlllIlIlllllIIIlllllII, 9 + llllllllllIlllIlIlllllIIIlllllII, 21, llllllllllIlllIlIlllllIIIllllIII);
                }
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 28, 12, 21, llllllllllIlllIlIlllllIIIllllIII);
                this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 29, 12, 21, llllllllllIlllIlIlllllIIIllllIII);
                for (int llllllllllIlllIlIlllllIIIllllIll = 0; llllllllllIlllIlIlllllIIIllllIll < 3; ++llllllllllIlllIlIlllllIIIllllIll) {
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 22 - llllllllllIlllIlIlllllIIIllllIll * 2, 8, 21, llllllllllIlllIlIlllllIIIllllIII);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 22 - llllllllllIlllIlIlllllIIIllllIll * 2, 9, 21, llllllllllIlllIlIlllllIIIllllIII);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 35 + llllllllllIlllIlIlllllIIIllllIll * 2, 8, 21, llllllllllIlllIlIlllllIIIllllIII);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIIIII, MonumentBuilding.DARK_PRISMARINE, 35 + llllllllllIlllIlIlllllIIIllllIll * 2, 9, 21, llllllllllIlllIlIlllllIIIllllIII);
                }
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 15, 13, 21, 42, 15, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 15, 1, 21, 15, 6, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 16, 1, 21, 16, 5, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 17, 1, 21, 20, 4, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 21, 1, 21, 21, 3, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 22, 1, 21, 22, 2, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 23, 1, 21, 24, 1, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 42, 1, 21, 42, 6, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 41, 1, 21, 41, 5, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 37, 1, 21, 40, 4, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 36, 1, 21, 36, 3, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 33, 1, 21, 34, 1, 21, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIIIII, llllllllllIlllIlIlllllIIIllllIII, 35, 1, 21, 35, 2, 21, false);
            }
        }
        
        private List<RoomDefinition> generateRoomGraph(final Random llllllllllIlllIlIlllllIIlllIIlIl) {
            final RoomDefinition[] llllllllllIlllIlIlllllIlIIIIIlll = new RoomDefinition[75];
            for (int llllllllllIlllIlIlllllIlIIIIIllI = 0; llllllllllIlllIlIlllllIlIIIIIllI < 5; ++llllllllllIlllIlIlllllIlIIIIIllI) {
                for (int llllllllllIlllIlIlllllIlIIIIIlIl = 0; llllllllllIlllIlIlllllIlIIIIIlIl < 4; ++llllllllllIlllIlIlllllIlIIIIIlIl) {
                    final int llllllllllIlllIlIlllllIlIIIIIlII = 0;
                    final int llllllllllIlllIlIlllllIlIIIIIIll = Piece.getRoomIndex(llllllllllIlllIlIlllllIlIIIIIllI, 0, llllllllllIlllIlIlllllIlIIIIIlIl);
                    llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIlIIIIIIll] = new RoomDefinition(llllllllllIlllIlIlllllIlIIIIIIll);
                }
            }
            for (int llllllllllIlllIlIlllllIlIIIIIIlI = 0; llllllllllIlllIlIlllllIlIIIIIIlI < 5; ++llllllllllIlllIlIlllllIlIIIIIIlI) {
                for (int llllllllllIlllIlIlllllIlIIIIIIIl = 0; llllllllllIlllIlIlllllIlIIIIIIIl < 4; ++llllllllllIlllIlIlllllIlIIIIIIIl) {
                    final int llllllllllIlllIlIlllllIlIIIIIIII = 1;
                    final int llllllllllIlllIlIlllllIIllllllll = Piece.getRoomIndex(llllllllllIlllIlIlllllIlIIIIIIlI, 1, llllllllllIlllIlIlllllIlIIIIIIIl);
                    llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllllll] = new RoomDefinition(llllllllllIlllIlIlllllIIllllllll);
                }
            }
            for (int llllllllllIlllIlIlllllIIlllllllI = 1; llllllllllIlllIlIlllllIIlllllllI < 4; ++llllllllllIlllIlIlllllIIlllllllI) {
                for (int llllllllllIlllIlIlllllIIllllllIl = 0; llllllllllIlllIlIlllllIIllllllIl < 2; ++llllllllllIlllIlIlllllIIllllllIl) {
                    final int llllllllllIlllIlIlllllIIllllllII = 2;
                    final int llllllllllIlllIlIlllllIIlllllIll = Piece.getRoomIndex(llllllllllIlllIlIlllllIIlllllllI, 2, llllllllllIlllIlIlllllIIllllllIl);
                    llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIlllllIll] = new RoomDefinition(llllllllllIlllIlIlllllIIlllllIll);
                }
            }
            this.sourceRoom = llllllllllIlllIlIlllllIlIIIIIlll[MonumentBuilding.GRIDROOM_SOURCE_INDEX];
            for (int llllllllllIlllIlIlllllIIlllllIlI = 0; llllllllllIlllIlIlllllIIlllllIlI < 5; ++llllllllllIlllIlIlllllIIlllllIlI) {
                for (int llllllllllIlllIlIlllllIIlllllIIl = 0; llllllllllIlllIlIlllllIIlllllIIl < 5; ++llllllllllIlllIlIlllllIIlllllIIl) {
                    for (int llllllllllIlllIlIlllllIIlllllIII = 0; llllllllllIlllIlIlllllIIlllllIII < 3; ++llllllllllIlllIlIlllllIIlllllIII) {
                        final int llllllllllIlllIlIlllllIIllllIlll = Piece.getRoomIndex(llllllllllIlllIlIlllllIIlllllIlI, llllllllllIlllIlIlllllIIlllllIII, llllllllllIlllIlIlllllIIlllllIIl);
                        if (llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIlll] != null) {
                            final EnumFacing[] values;
                            final String llllllllllIlllIlIlllllIIllIlllIl = (String)(values = EnumFacing.values()).length;
                            for (final EnumFacing llllllllllIlllIlIlllllIIllllIllI : values) {
                                final int llllllllllIlllIlIlllllIIllllIlIl = llllllllllIlllIlIlllllIIlllllIlI + llllllllllIlllIlIlllllIIllllIllI.getFrontOffsetX();
                                final int llllllllllIlllIlIlllllIIllllIlII = llllllllllIlllIlIlllllIIlllllIII + llllllllllIlllIlIlllllIIllllIllI.getFrontOffsetY();
                                final int llllllllllIlllIlIlllllIIllllIIll = llllllllllIlllIlIlllllIIlllllIIl + llllllllllIlllIlIlllllIIllllIllI.getFrontOffsetZ();
                                if (llllllllllIlllIlIlllllIIllllIlIl >= 0 && llllllllllIlllIlIlllllIIllllIlIl < 5 && llllllllllIlllIlIlllllIIllllIIll >= 0 && llllllllllIlllIlIlllllIIllllIIll < 5 && llllllllllIlllIlIlllllIIllllIlII >= 0 && llllllllllIlllIlIlllllIIllllIlII < 3) {
                                    final int llllllllllIlllIlIlllllIIllllIIlI = Piece.getRoomIndex(llllllllllIlllIlIlllllIIllllIlIl, llllllllllIlllIlIlllllIIllllIlII, llllllllllIlllIlIlllllIIllllIIll);
                                    if (llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIIlI] != null) {
                                        if (llllllllllIlllIlIlllllIIllllIIll == llllllllllIlllIlIlllllIIlllllIIl) {
                                            llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIlll].setConnection(llllllllllIlllIlIlllllIIllllIllI, llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIIlI]);
                                        }
                                        else {
                                            llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIlll].setConnection(llllllllllIlllIlIlllllIIllllIllI.getOpposite(), llllllllllIlllIlIlllllIlIIIIIlll[llllllllllIlllIlIlllllIIllllIIlI]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final RoomDefinition llllllllllIlllIlIlllllIIllllIIIl = new RoomDefinition(1003);
            final RoomDefinition llllllllllIlllIlIlllllIIllllIIII = new RoomDefinition(1001);
            final RoomDefinition llllllllllIlllIlIlllllIIlllIllll = new RoomDefinition(1002);
            llllllllllIlllIlIlllllIlIIIIIlll[MonumentBuilding.GRIDROOM_TOP_CONNECT_INDEX].setConnection(EnumFacing.UP, llllllllllIlllIlIlllllIIllllIIIl);
            llllllllllIlllIlIlllllIlIIIIIlll[MonumentBuilding.GRIDROOM_LEFTWING_CONNECT_INDEX].setConnection(EnumFacing.SOUTH, llllllllllIlllIlIlllllIIllllIIII);
            llllllllllIlllIlIlllllIlIIIIIlll[MonumentBuilding.GRIDROOM_RIGHTWING_CONNECT_INDEX].setConnection(EnumFacing.SOUTH, llllllllllIlllIlIlllllIIlllIllll);
            llllllllllIlllIlIlllllIIllllIIIl.claimed = true;
            llllllllllIlllIlIlllllIIllllIIII.claimed = true;
            llllllllllIlllIlIlllllIIlllIllll.claimed = true;
            this.sourceRoom.isSource = true;
            this.coreRoom = llllllllllIlllIlIlllllIlIIIIIlll[Piece.getRoomIndex(llllllllllIlllIlIlllllIIlllIIlIl.nextInt(4), 0, 2)];
            this.coreRoom.claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.NORTH.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            final List<RoomDefinition> llllllllllIlllIlIlllllIIlllIlllI = (List<RoomDefinition>)Lists.newArrayList();
            final RoomDefinition[] array;
            String llllllllllIlllIlIlllllIIllIlllIl = (String)(array = llllllllllIlllIlIlllllIlIIIIIlll).length;
            for (final RoomDefinition llllllllllIlllIlIlllllIIlllIllIl : array) {
                if (llllllllllIlllIlIlllllIIlllIllIl != null) {
                    llllllllllIlllIlIlllllIIlllIllIl.updateOpenings();
                    llllllllllIlllIlIlllllIIlllIlllI.add(llllllllllIlllIlIlllllIIlllIllIl);
                }
            }
            llllllllllIlllIlIlllllIIllllIIIl.updateOpenings();
            Collections.shuffle(llllllllllIlllIlIlllllIIlllIlllI, llllllllllIlllIlIlllllIIlllIIlIl);
            int llllllllllIlllIlIlllllIIlllIllII = 1;
            llllllllllIlllIlIlllllIIllIlllIl = (String)llllllllllIlllIlIlllllIIlllIlllI.iterator();
            while (((Iterator)llllllllllIlllIlIlllllIIllIlllIl).hasNext()) {
                final RoomDefinition llllllllllIlllIlIlllllIIlllIlIll = ((Iterator<RoomDefinition>)llllllllllIlllIlIlllllIIllIlllIl).next();
                int llllllllllIlllIlIlllllIIlllIlIlI = 0;
                int llllllllllIlllIlIlllllIIlllIlIIl = 0;
                while (llllllllllIlllIlIlllllIIlllIlIlI < 2 && llllllllllIlllIlIlllllIIlllIlIIl < 5) {
                    ++llllllllllIlllIlIlllllIIlllIlIIl;
                    final int llllllllllIlllIlIlllllIIlllIlIII = llllllllllIlllIlIlllllIIlllIIlIl.nextInt(6);
                    if (llllllllllIlllIlIlllllIIlllIlIll.hasOpening[llllllllllIlllIlIlllllIIlllIlIII]) {
                        final int llllllllllIlllIlIlllllIIlllIIlll = EnumFacing.getFront(llllllllllIlllIlIlllllIIlllIlIII).getOpposite().getIndex();
                        llllllllllIlllIlIlllllIIlllIlIll.hasOpening[llllllllllIlllIlIlllllIIlllIlIII] = false;
                        llllllllllIlllIlIlllllIIlllIlIll.connections[llllllllllIlllIlIlllllIIlllIlIII].hasOpening[llllllllllIlllIlIlllllIIlllIIlll] = false;
                        if (llllllllllIlllIlIlllllIIlllIlIll.findSource(llllllllllIlllIlIlllllIIlllIllII++) && llllllllllIlllIlIlllllIIlllIlIll.connections[llllllllllIlllIlIlllllIIlllIlIII].findSource(llllllllllIlllIlIlllllIIlllIllII++)) {
                            ++llllllllllIlllIlIlllllIIlllIlIlI;
                        }
                        else {
                            llllllllllIlllIlIlllllIIlllIlIll.hasOpening[llllllllllIlllIlIlllllIIlllIlIII] = true;
                            llllllllllIlllIlIlllllIIlllIlIll.connections[llllllllllIlllIlIlllllIIlllIlIII].hasOpening[llllllllllIlllIlIlllllIIlllIIlll] = true;
                        }
                    }
                }
            }
            llllllllllIlllIlIlllllIIlllIlllI.add(llllllllllIlllIlIlllllIIllllIIIl);
            llllllllllIlllIlIlllllIIlllIlllI.add(llllllllllIlllIlIlllllIIllllIIII);
            llllllllllIlllIlIlllllIIlllIlllI.add(llllllllllIlllIlIlllllIIlllIllll);
            return llllllllllIlllIlIlllllIIlllIlllI;
        }
        
        private void generateWing(final boolean llllllllllIlllIlIlllllIIlIlIlIIl, final int llllllllllIlllIlIlllllIIlIlIlIII, final World llllllllllIlllIlIlllllIIlIlIIlll, final Random llllllllllIlllIlIlllllIIlIlIIllI, final StructureBoundingBox llllllllllIlllIlIlllllIIlIlIIlIl) {
            final int llllllllllIlllIlIlllllIIlIlIIlII = 24;
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII, 0, llllllllllIlllIlIlllllIIlIlIlIII + 23, 20)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 0, 0, 0, llllllllllIlllIlIlllllIIlIlIlIII + 24, 0, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 0, 1, 0, llllllllllIlllIlIlllllIIlIlIlIII + 24, 10, 20, false);
                for (int llllllllllIlllIlIlllllIIlIlIIIll = 0; llllllllllIlllIlIlllllIIlIlIIIll < 4; ++llllllllllIlllIlIlllllIIlIlIIIll) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 1, llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 1, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll + 7, llllllllllIlllIlIlllllIIlIlIIIll + 5, llllllllllIlllIlIlllllIIlIlIIIll + 7, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll + 7, llllllllllIlllIlIlllllIIlIlIIIll + 5, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 17 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 5, llllllllllIlllIlIlllllIIlIlIIIll + 7, llllllllllIlllIlIlllllIIlIlIlIII + 17 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 5, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 24 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 1, llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIlIII + 24 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 1, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll + 1, llllllllllIlllIlIlllllIIlIlIIIll + 1, llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIlIII + 23 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 1, llllllllllIlllIlIlllllIIlIlIIIll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + llllllllllIlllIlIlllllIIlIlIIIll + 8, llllllllllIlllIlIlllllIIlIlIIIll + 5, llllllllllIlllIlIlllllIIlIlIIIll + 7, llllllllllIlllIlIlllllIIlIlIlIII + 16 - llllllllllIlllIlIlllllIIlIlIIIll, llllllllllIlllIlIlllllIIlIlIIIll + 5, llllllllllIlllIlIlllllIIlIlIIIll + 7, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 4, 4, 4, llllllllllIlllIlIlllllIIlIlIlIII + 6, 4, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 7, 4, 4, llllllllllIlllIlIlllllIIlIlIlIII + 17, 4, 6, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 18, 4, 4, llllllllllIlllIlIlllllIIlIlIlIII + 20, 4, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 11, 8, 11, llllllllllIlllIlIlllllIIlIlIlIII + 13, 8, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIlIII + 12, 9, 12, llllllllllIlllIlIlllllIIlIlIIlIl);
                this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIlIII + 12, 9, 15, llllllllllIlllIlIlllllIIlIlIIlIl);
                this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIlIII + 12, 9, 18, llllllllllIlllIlIlllllIIlIlIIlIl);
                final int llllllllllIlllIlIlllllIIlIlIIIlI = llllllllllIlllIlIlllllIIlIlIlIII + (llllllllllIlllIlIlllllIIlIlIlIIl ? 19 : 5);
                final int llllllllllIlllIlIlllllIIlIlIIIIl = llllllllllIlllIlIlllllIIlIlIlIII + (llllllllllIlllIlIlllllIIlIlIlIIl ? 5 : 19);
                for (int llllllllllIlllIlIlllllIIlIlIIIII = 20; llllllllllIlllIlIlllllIIlIlIIIII >= 5; llllllllllIlllIlIlllllIIlIlIIIII -= 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIIIlI, 5, llllllllllIlllIlIlllllIIlIlIIIII, llllllllllIlllIlIlllllIIlIlIIlIl);
                }
                for (int llllllllllIlllIlIlllllIIlIIlllll = 19; llllllllllIlllIlIlllllIIlIIlllll >= 7; llllllllllIlllIlIlllllIIlIIlllll -= 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIIIIl, 5, llllllllllIlllIlIlllllIIlIIlllll, llllllllllIlllIlIlllllIIlIlIIlIl);
                }
                for (int llllllllllIlllIlIlllllIIlIIllllI = 0; llllllllllIlllIlIlllllIIlIIllllI < 4; ++llllllllllIlllIlIlllllIIlIIllllI) {
                    final int llllllllllIlllIlIlllllIIlIIlllIl = llllllllllIlllIlIlllllIIlIlIlIIl ? (llllllllllIlllIlIlllllIIlIlIlIII + (24 - (17 - llllllllllIlllIlIlllllIIlIIllllI * 3))) : (llllllllllIlllIlIlllllIIlIlIlIII + 17 - llllllllllIlllIlIlllllIIlIIllllI * 3);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIIlllIl, 5, 5, llllllllllIlllIlIlllllIIlIlIIlIl);
                }
                this.setBlockState(llllllllllIlllIlIlllllIIlIlIIlll, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIlIlIIIIl, 5, 5, llllllllllIlllIlIlllllIIlIlIIlIl);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 11, 1, 12, llllllllllIlllIlIlllllIIlIlIlIII + 13, 7, 12, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIlIlIIlll, llllllllllIlllIlIlllllIIlIlIIlIl, llllllllllIlllIlIlllllIIlIlIlIII + 12, 1, 11, llllllllllIlllIlIlllllIIlIlIlIII + 12, 7, 13, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        private void generateUpperWall(final World llllllllllIlllIlIlllllIIIIllIllI, final Random llllllllllIlllIlIlllllIIIIllllll, final StructureBoundingBox llllllllllIlllIlIlllllIIIIllIlIl) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIIllIlIl, 14, 21, 20, 43)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 14, 0, 21, 20, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 14, 1, 22, 20, 14, 43, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 18, 12, 22, 20, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 18, 12, 21, 20, 12, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIIllllIl = 0; llllllllllIlllIlIlllllIIIIllllIl < 4; ++llllllllllIlllIlIlllllIIIIllllIl) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, llllllllllIlllIlIlllllIIIIllllIl + 14, llllllllllIlllIlIlllllIIIIllllIl + 9, 21, llllllllllIlllIlIlllllIIIIllllIl + 14, llllllllllIlllIlIlllllIIIIllllIl + 9, 43 - llllllllllIlllIlIlllllIIIIllllIl, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIIllllII = 23; llllllllllIlllIlIlllllIIIIllllII <= 39; llllllllllIlllIlIlllllIIIIllllII += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIIllIllI, MonumentBuilding.DOT_DECO_DATA, 19, 13, llllllllllIlllIlIlllllIIIIllllII, llllllllllIlllIlIlllllIIIIllIlIl);
                }
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIIllIlIl, 37, 21, 43, 43)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 37, 0, 21, 43, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 37, 1, 22, 43, 14, 43, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 37, 12, 22, 39, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 37, 12, 21, 39, 12, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIIlllIll = 0; llllllllllIlllIlIlllllIIIIlllIll < 4; ++llllllllllIlllIlIlllllIIIIlllIll) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 43 - llllllllllIlllIlIlllllIIIIlllIll, llllllllllIlllIlIlllllIIIIlllIll + 9, 21, 43 - llllllllllIlllIlIlllllIIIIlllIll, llllllllllIlllIlIlllllIIIIlllIll + 9, 43 - llllllllllIlllIlIlllllIIIIlllIll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIIlllIlI = 23; llllllllllIlllIlIlllllIIIIlllIlI <= 39; llllllllllIlllIlIlllllIIIIlllIlI += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIIllIllI, MonumentBuilding.DOT_DECO_DATA, 38, 13, llllllllllIlllIlIlllllIIIIlllIlI, llllllllllIlllIlIlllllIIIIllIlIl);
                }
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIIllIlIl, 15, 37, 42, 43)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 21, 0, 37, 36, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 21, 1, 37, 36, 14, 43, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 21, 12, 37, 36, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIIlllIIl = 0; llllllllllIlllIlIlllllIIIIlllIIl < 4; ++llllllllllIlllIlIlllllIIIIlllIIl) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIIllIllI, llllllllllIlllIlIlllllIIIIllIlIl, 15 + llllllllllIlllIlIlllllIIIIlllIIl, llllllllllIlllIlIlllllIIIIlllIIl + 9, 43 - llllllllllIlllIlIlllllIIIIlllIIl, 42 - llllllllllIlllIlIlllllIIIIlllIIl, llllllllllIlllIlIlllllIIIIlllIIl + 9, 43 - llllllllllIlllIlIlllllIIIIlllIIl, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIIlllIII = 21; llllllllllIlllIlIlllllIIIIlllIII <= 36; llllllllllIlllIlIlllllIIIIlllIII += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIIllIllI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIIlllIII, 13, 38, llllllllllIlllIlIlllllIIIIllIlIl);
                }
            }
        }
        
        private void generateMiddleWall(final World llllllllllIlllIlIlllllIIIlIlIIlI, final Random llllllllllIlllIlIlllllIIIlIlIIIl, final StructureBoundingBox llllllllllIlllIlIlllllIIIlIIIlll) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIlIIIlll, 7, 21, 13, 50)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 7, 0, 21, 13, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 7, 1, 21, 13, 10, 50, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 11, 8, 21, 13, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIlIIllll = 0; llllllllllIlllIlIlllllIIIlIIllll < 4; ++llllllllllIlllIlIlllllIIIlIIllll) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, llllllllllIlllIlIlllllIIIlIIllll + 7, llllllllllIlllIlIlllllIIIlIIllll + 5, 21, llllllllllIlllIlIlllllIIIlIIllll + 7, llllllllllIlllIlIlllllIIIlIIllll + 5, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIlIIlllI = 21; llllllllllIlllIlIlllllIIIlIIlllI <= 45; llllllllllIlllIlIlllllIIIlIIlllI += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, 12, 9, llllllllllIlllIlIlllllIIIlIIlllI, llllllllllIlllIlIlllllIIIlIIIlll);
                }
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIlIIIlll, 44, 21, 50, 54)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 44, 0, 21, 50, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 44, 1, 21, 50, 10, 50, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 44, 8, 21, 46, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIlIIllIl = 0; llllllllllIlllIlIlllllIIIlIIllIl < 4; ++llllllllllIlllIlIlllllIIIlIIllIl) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 50 - llllllllllIlllIlIlllllIIIlIIllIl, llllllllllIlllIlIlllllIIIlIIllIl + 5, 21, 50 - llllllllllIlllIlIlllllIIIlIIllIl, llllllllllIlllIlIlllllIIIlIIllIl + 5, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIlIIllII = 21; llllllllllIlllIlIlllllIIIlIIllII <= 45; llllllllllIlllIlIlllllIIIlIIllII += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, 45, 9, llllllllllIlllIlIlllllIIIlIIllII, llllllllllIlllIlIlllllIIIlIIIlll);
                }
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIlIIIlll, 8, 44, 49, 54)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 14, 0, 44, 43, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 14, 1, 44, 43, 10, 50, false);
                for (int llllllllllIlllIlIlllllIIIlIIlIll = 12; llllllllllIlllIlIlllllIIIlIIlIll <= 45; llllllllllIlllIlIlllllIIIlIIlIll += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 9, 45, llllllllllIlllIlIlllllIIIlIIIlll);
                    this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 9, 52, llllllllllIlllIlIlllllIIIlIIIlll);
                    if (llllllllllIlllIlIlllllIIIlIIlIll == 12 || llllllllllIlllIlIlllllIIIlIIlIll == 18 || llllllllllIlllIlIlllllIIIlIIlIll == 24 || llllllllllIlllIlIlllllIIIlIIlIll == 33 || llllllllllIlllIlIlllllIIIlIIlIll == 39 || llllllllllIlllIlIlllllIIIlIIlIll == 45) {
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 9, 47, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 9, 50, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 10, 45, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 10, 46, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 10, 51, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 10, 52, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 11, 47, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 11, 50, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 12, 48, llllllllllIlllIlIlllllIIIlIIIlll);
                        this.setBlockState(llllllllllIlllIlIlllllIIIlIlIIlI, MonumentBuilding.DOT_DECO_DATA, llllllllllIlllIlIlllllIIIlIIlIll, 12, 49, llllllllllIlllIlIlllllIIIlIIIlll);
                    }
                }
                for (int llllllllllIlllIlIlllllIIIlIIlIlI = 0; llllllllllIlllIlIlllllIIIlIIlIlI < 3; ++llllllllllIlllIlIlllllIIIlIIlIlI) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 8 + llllllllllIlllIlIlllllIIIlIIlIlI, 5 + llllllllllIlllIlIlllllIIIlIIlIlI, 54, 49 - llllllllllIlllIlIlllllIIIlIIlIlI, 5 + llllllllllIlllIlIlllllIIIlIIlIlI, 54, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                }
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 11, 8, 54, 46, 8, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIlIlIIlI, llllllllllIlllIlIlllllIIIlIIIlll, 14, 8, 44, 43, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        private void generateLowerWall(final World llllllllllIlllIlIlllllIIIllIIlII, final Random llllllllllIlllIlIlllllIIIllIIIll, final StructureBoundingBox llllllllllIlllIlIlllllIIIllIIIlI) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIllIIIlI, 0, 21, 6, 58)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 0, 0, 21, 6, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 0, 1, 21, 6, 7, 57, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 4, 4, 21, 6, 4, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIllIIIIl = 0; llllllllllIlllIlIlllllIIIllIIIIl < 4; ++llllllllllIlllIlIlllllIIIllIIIIl) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, llllllllllIlllIlIlllllIIIllIIIIl, llllllllllIlllIlIlllllIIIllIIIIl + 1, 21, llllllllllIlllIlIlllllIIIllIIIIl, llllllllllIlllIlIlllllIIIllIIIIl + 1, 57 - llllllllllIlllIlIlllllIIIllIIIIl, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIllIIIII = 23; llllllllllIlllIlIlllllIIIllIIIII < 53; llllllllllIlllIlIlllllIIIllIIIII += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIllIIlII, MonumentBuilding.DOT_DECO_DATA, 5, 5, llllllllllIlllIlIlllllIIIllIIIII, llllllllllIlllIlIlllllIIIllIIIlI);
                }
                this.setBlockState(llllllllllIlllIlIlllllIIIllIIlII, MonumentBuilding.DOT_DECO_DATA, 5, 5, 52, llllllllllIlllIlIlllllIIIllIIIlI);
                for (int llllllllllIlllIlIlllllIIIlIlllll = 0; llllllllllIlllIlIlllllIIIlIlllll < 4; ++llllllllllIlllIlIlllllIIIlIlllll) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, llllllllllIlllIlIlllllIIIlIlllll, llllllllllIlllIlIlllllIIIlIlllll + 1, 21, llllllllllIlllIlIlllllIIIlIlllll, llllllllllIlllIlIlllllIIIlIlllll + 1, 57 - llllllllllIlllIlIlllllIIIlIlllll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 4, 1, 52, 6, 3, 52, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 5, 1, 51, 5, 3, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIllIIIlI, 51, 21, 58, 58)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 51, 0, 21, 57, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 51, 1, 21, 57, 7, 57, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 51, 4, 21, 53, 4, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int llllllllllIlllIlIlllllIIIlIllllI = 0; llllllllllIlllIlIlllllIIIlIllllI < 4; ++llllllllllIlllIlIlllllIIIlIllllI) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 57 - llllllllllIlllIlIlllllIIIlIllllI, llllllllllIlllIlIlllllIIIlIllllI + 1, 21, 57 - llllllllllIlllIlIlllllIIIlIllllI, llllllllllIlllIlIlllllIIIlIllllI + 1, 57 - llllllllllIlllIlIlllllIIIlIllllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int llllllllllIlllIlIlllllIIIlIlllIl = 23; llllllllllIlllIlIlllllIIIlIlllIl < 53; llllllllllIlllIlIlllllIIIlIlllIl += 3) {
                    this.setBlockState(llllllllllIlllIlIlllllIIIllIIlII, MonumentBuilding.DOT_DECO_DATA, 52, 5, llllllllllIlllIlIlllllIIIlIlllIl, llllllllllIlllIlIlllllIIIllIIIlI);
                }
                this.setBlockState(llllllllllIlllIlIlllllIIIllIIlII, MonumentBuilding.DOT_DECO_DATA, 52, 5, 52, llllllllllIlllIlIlllllIIIllIIIlI);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 51, 1, 52, 53, 3, 52, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 52, 1, 51, 52, 3, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIllIIIlI, 0, 51, 57, 57)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 7, 0, 51, 50, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, 7, 1, 51, 50, 10, 57, false);
                for (int llllllllllIlllIlIlllllIIIlIlllII = 0; llllllllllIlllIlIlllllIIIlIlllII < 4; ++llllllllllIlllIlIlllllIIIlIlllII) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIIlII, llllllllllIlllIlIlllllIIIllIIIlI, llllllllllIlllIlIlllllIIIlIlllII + 1, llllllllllIlllIlIlllllIIIlIlllII + 1, 57 - llllllllllIlllIlIlllllIIIlIlllII, 56 - llllllllllIlllIlIlllllIIIlIlllII, llllllllllIlllIlIlllllIIIlIlllII + 1, 57 - llllllllllIlllIlIlllllIIIlIlllII, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
            }
        }
        
        public MonumentBuilding(final Random llllllllllIlllIlIlllllIlIIlIIllI, final int llllllllllIlllIlIlllllIlIIlIIlIl, final int llllllllllIlllIlIlllllIlIIlIIlII, final EnumFacing llllllllllIlllIlIlllllIlIIlIIIll) {
            super(0);
            this.childPieces = (List<Piece>)Lists.newArrayList();
            this.setCoordBaseMode(llllllllllIlllIlIlllllIlIIlIIIll);
            final EnumFacing llllllllllIlllIlIlllllIlIIllIlIl = this.getCoordBaseMode();
            if (llllllllllIlllIlIlllllIlIIllIlIl.getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(llllllllllIlllIlIlllllIlIIlIIlIl, 39, llllllllllIlllIlIlllllIlIIlIIlII, llllllllllIlllIlIlllllIlIIlIIlIl + 58 - 1, 61, llllllllllIlllIlIlllllIlIIlIIlII + 58 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(llllllllllIlllIlIlllllIlIIlIIlIl, 39, llllllllllIlllIlIlllllIlIIlIIlII, llllllllllIlllIlIlllllIlIIlIIlIl + 58 - 1, 61, llllllllllIlllIlIlllllIlIIlIIlII + 58 - 1);
            }
            final List<RoomDefinition> llllllllllIlllIlIlllllIlIIllIlII = this.generateRoomGraph(llllllllllIlllIlIlllllIlIIlIIllI);
            this.sourceRoom.claimed = true;
            this.childPieces.add(new EntryRoom(llllllllllIlllIlIlllllIlIIllIlIl, this.sourceRoom));
            this.childPieces.add(new MonumentCoreRoom(llllllllllIlllIlIlllllIlIIllIlIl, this.coreRoom, llllllllllIlllIlIlllllIlIIlIIllI));
            final List<MonumentRoomFitHelper> llllllllllIlllIlIlllllIlIIllIIll = (List<MonumentRoomFitHelper>)Lists.newArrayList();
            llllllllllIlllIlIlllllIlIIllIIll.add(new XYDoubleRoomFitHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new YZDoubleRoomFitHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new ZDoubleRoomFitHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new XDoubleRoomFitHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new YDoubleRoomFitHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new FitSimpleRoomTopHelper(null));
            llllllllllIlllIlIlllllIlIIllIIll.add(new FitSimpleRoomHelper(null));
            for (final RoomDefinition llllllllllIlllIlIlllllIlIIllIIlI : llllllllllIlllIlIlllllIlIIllIlII) {
                if (!llllllllllIlllIlIlllllIlIIllIIlI.claimed && !llllllllllIlllIlIlllllIlIIllIIlI.isSpecial()) {
                    for (final MonumentRoomFitHelper llllllllllIlllIlIlllllIlIIllIIII : llllllllllIlllIlIlllllIlIIllIIll) {
                        if (llllllllllIlllIlIlllllIlIIllIIII.fits(llllllllllIlllIlIlllllIlIIllIIlI)) {
                            this.childPieces.add(llllllllllIlllIlIlllllIlIIllIIII.create(llllllllllIlllIlIlllllIlIIllIlIl, llllllllllIlllIlIlllllIlIIllIIlI, llllllllllIlllIlIlllllIlIIlIIllI));
                            break;
                        }
                    }
                }
            }
            final int llllllllllIlllIlIlllllIlIIlIllll = this.boundingBox.minY;
            final int llllllllllIlllIlIlllllIlIIlIlllI = this.getXWithOffset(9, 22);
            final int llllllllllIlllIlIlllllIlIIlIllIl = this.getZWithOffset(9, 22);
            for (final Piece llllllllllIlllIlIlllllIlIIlIllII : this.childPieces) {
                llllllllllIlllIlIlllllIlIIlIllII.getBoundingBox().offset(llllllllllIlllIlIlllllIlIIlIlllI, llllllllllIlllIlIlllllIlIIlIllll, llllllllllIlllIlIlllllIlIIlIllIl);
            }
            final StructureBoundingBox llllllllllIlllIlIlllllIlIIlIlIll = StructureBoundingBox.createProper(this.getXWithOffset(1, 1), this.getYWithOffset(1), this.getZWithOffset(1, 1), this.getXWithOffset(23, 21), this.getYWithOffset(8), this.getZWithOffset(23, 21));
            final StructureBoundingBox llllllllllIlllIlIlllllIlIIlIlIlI = StructureBoundingBox.createProper(this.getXWithOffset(34, 1), this.getYWithOffset(1), this.getZWithOffset(34, 1), this.getXWithOffset(56, 21), this.getYWithOffset(8), this.getZWithOffset(56, 21));
            final StructureBoundingBox llllllllllIlllIlIlllllIlIIlIlIIl = StructureBoundingBox.createProper(this.getXWithOffset(22, 22), this.getYWithOffset(13), this.getZWithOffset(22, 22), this.getXWithOffset(35, 35), this.getYWithOffset(17), this.getZWithOffset(35, 35));
            int llllllllllIlllIlIlllllIlIIlIlIII = llllllllllIlllIlIlllllIlIIlIIllI.nextInt();
            this.childPieces.add(new WingRoom(llllllllllIlllIlIlllllIlIIllIlIl, llllllllllIlllIlIlllllIlIIlIlIll, llllllllllIlllIlIlllllIlIIlIlIII++));
            this.childPieces.add(new WingRoom(llllllllllIlllIlIlllllIlIIllIlIl, llllllllllIlllIlIlllllIlIIlIlIlI, llllllllllIlllIlIlllllIlIIlIlIII++));
            this.childPieces.add(new Penthouse(llllllllllIlllIlIlllllIlIIllIlIl, llllllllllIlllIlIlllllIlIIlIlIIl));
        }
        
        public MonumentBuilding() {
            this.childPieces = (List<Piece>)Lists.newArrayList();
        }
        
        private void generateRoofPiece(final World llllllllllIlllIlIlllllIIIllIllII, final Random llllllllllIlllIlIlllllIIIlllIIII, final StructureBoundingBox llllllllllIlllIlIlllllIIIllIlIll) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIIllIlIll, 21, 21, 36, 36)) {
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 21, 0, 22, 36, 0, 36, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 21, 1, 22, 36, 23, 36, false);
                for (int llllllllllIlllIlIlllllIIIllIlllI = 0; llllllllllIlllIlIlllllIIIllIlllI < 4; ++llllllllllIlllIlIlllllIIIllIlllI) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 21 + llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 21 + llllllllllIlllIlIlllllIIIllIlllI, 36 - llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 21 + llllllllllIlllIlIlllllIIIllIlllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 21 + llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 36 - llllllllllIlllIlIlllllIIIllIlllI, 36 - llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 36 - llllllllllIlllIlIlllllIIIllIlllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 21 + llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 22 + llllllllllIlllIlIlllllIIIllIlllI, 21 + llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 35 - llllllllllIlllIlIlllllIIIllIlllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 36 - llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 22 + llllllllllIlllIlIlllllIIIllIlllI, 36 - llllllllllIlllIlIlllllIIIllIlllI, 13 + llllllllllIlllIlIlllllIIIllIlllI, 35 - llllllllllIlllIlIlllllIIIllIlllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 25, 16, 25, 32, 16, 32, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 25, 17, 25, 25, 19, 25, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 32, 17, 25, 32, 19, 25, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 25, 17, 32, 25, 19, 32, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 32, 17, 32, 32, 19, 32, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 26, 20, 26, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 27, 21, 27, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.SEA_LANTERN, 27, 20, 27, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 26, 20, 31, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 27, 21, 30, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.SEA_LANTERN, 27, 20, 30, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 31, 20, 31, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 30, 21, 30, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.SEA_LANTERN, 30, 20, 30, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 31, 20, 26, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.BRICKS_PRISMARINE, 30, 21, 27, llllllllllIlllIlIlllllIIIllIlIll);
                this.setBlockState(llllllllllIlllIlIlllllIIIllIllII, MonumentBuilding.SEA_LANTERN, 30, 20, 27, llllllllllIlllIlIlllllIIIllIlIll);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 28, 21, 27, 29, 21, 27, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 27, 21, 28, 27, 21, 29, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 28, 21, 30, 29, 21, 30, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllIlllIlIlllllIIIllIllII, llllllllllIlllIlIlllllIIIllIlIll, 30, 21, 28, 30, 21, 29, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIlIlllllIIlIlllllI, final Random llllllllllIlllIlIlllllIIlIllllIl, final StructureBoundingBox llllllllllIlllIlIlllllIIlIllllII) {
            final int llllllllllIlllIlIlllllIIllIIlIII = Math.max(llllllllllIlllIlIlllllIIlIlllllI.getSeaLevel(), 64) - this.boundingBox.minY;
            this.generateWaterBox(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllII, 0, 0, 0, 58, llllllllllIlllIlIlllllIIllIIlIII, 58, false);
            this.generateWing(false, 0, llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateWing(true, 33, llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateEntranceArchs(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateEntranceWall(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateRoofPiece(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateLowerWall(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateMiddleWall(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            this.generateUpperWall(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
            for (int llllllllllIlllIlIlllllIIllIIIlll = 0; llllllllllIlllIlIlllllIIllIIIlll < 7; ++llllllllllIlllIlIlllllIIllIIIlll) {
                int llllllllllIlllIlIlllllIIllIIIllI = 0;
                while (llllllllllIlllIlIlllllIIllIIIllI < 7) {
                    if (llllllllllIlllIlIlllllIIllIIIllI == 0 && llllllllllIlllIlIlllllIIllIIIlll == 3) {
                        llllllllllIlllIlIlllllIIllIIIllI = 6;
                    }
                    final int llllllllllIlllIlIlllllIIllIIIlIl = llllllllllIlllIlIlllllIIllIIIlll * 9;
                    final int llllllllllIlllIlIlllllIIllIIIlII = llllllllllIlllIlIlllllIIllIIIllI * 9;
                    for (int llllllllllIlllIlIlllllIIllIIIIll = 0; llllllllllIlllIlIlllllIIllIIIIll < 4; ++llllllllllIlllIlIlllllIIllIIIIll) {
                        for (int llllllllllIlllIlIlllllIIllIIIIlI = 0; llllllllllIlllIlIlllllIIllIIIIlI < 4; ++llllllllllIlllIlIlllllIIllIIIIlI) {
                            this.setBlockState(llllllllllIlllIlIlllllIIlIlllllI, MonumentBuilding.BRICKS_PRISMARINE, llllllllllIlllIlIlllllIIllIIIlIl + llllllllllIlllIlIlllllIIllIIIIll, 0, llllllllllIlllIlIlllllIIllIIIlII + llllllllllIlllIlIlllllIIllIIIIlI, llllllllllIlllIlIlllllIIlIllllII);
                            this.replaceAirAndLiquidDownwards(llllllllllIlllIlIlllllIIlIlllllI, MonumentBuilding.BRICKS_PRISMARINE, llllllllllIlllIlIlllllIIllIIIlIl + llllllllllIlllIlIlllllIIllIIIIll, -1, llllllllllIlllIlIlllllIIllIIIlII + llllllllllIlllIlIlllllIIllIIIIlI, llllllllllIlllIlIlllllIIlIllllII);
                        }
                    }
                    if (llllllllllIlllIlIlllllIIllIIIlll != 0 && llllllllllIlllIlIlllllIIllIIIlll != 6) {
                        llllllllllIlllIlIlllllIIllIIIllI += 6;
                    }
                    else {
                        ++llllllllllIlllIlIlllllIIllIIIllI;
                    }
                }
            }
            for (int llllllllllIlllIlIlllllIIllIIIIIl = 0; llllllllllIlllIlIlllllIIllIIIIIl < 5; ++llllllllllIlllIlIlllllIIllIIIIIl) {
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllII, -1 - llllllllllIlllIlIlllllIIllIIIIIl, 0 + llllllllllIlllIlIlllllIIllIIIIIl * 2, -1 - llllllllllIlllIlIlllllIIllIIIIIl, -1 - llllllllllIlllIlIlllllIIllIIIIIl, 23, 58 + llllllllllIlllIlIlllllIIllIIIIIl, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllII, 58 + llllllllllIlllIlIlllllIIllIIIIIl, 0 + llllllllllIlllIlIlllllIIllIIIIIl * 2, -1 - llllllllllIlllIlIlllllIIllIIIIIl, 58 + llllllllllIlllIlIlllllIIllIIIIIl, 23, 58 + llllllllllIlllIlIlllllIIllIIIIIl, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllII, 0 - llllllllllIlllIlIlllllIIllIIIIIl, 0 + llllllllllIlllIlIlllllIIllIIIIIl * 2, -1 - llllllllllIlllIlIlllllIIllIIIIIl, 57 + llllllllllIlllIlIlllllIIllIIIIIl, 23, -1 - llllllllllIlllIlIlllllIIllIIIIIl, false);
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllII, 0 - llllllllllIlllIlIlllllIIllIIIIIl, 0 + llllllllllIlllIlIlllllIIllIIIIIl * 2, 58 + llllllllllIlllIlIlllllIIllIIIIIl, 57 + llllllllllIlllIlIlllllIIllIIIIIl, 23, 58 + llllllllllIlllIlIlllllIIllIIIIIl, false);
            }
            for (final Piece llllllllllIlllIlIlllllIIllIIIIII : this.childPieces) {
                if (llllllllllIlllIlIlllllIIllIIIIII.getBoundingBox().intersectsWith(llllllllllIlllIlIlllllIIlIllllII)) {
                    llllllllllIlllIlIlllllIIllIIIIII.addComponentParts(llllllllllIlllIlIlllllIIlIlllllI, llllllllllIlllIlIlllllIIlIllllIl, llllllllllIlllIlIlllllIIlIllllII);
                }
            }
            return true;
        }
        
        private void generateEntranceArchs(final World llllllllllIlllIlIlllllIIlIIIlIII, final Random llllllllllIlllIlIlllllIIlIIIllII, final StructureBoundingBox llllllllllIlllIlIlllllIIlIIIlIll) {
            if (this.doesChunkIntersect(llllllllllIlllIlIlllllIIlIIIlIll, 22, 5, 35, 17)) {
                this.generateWaterBox(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 25, 0, 0, 32, 8, 20, false);
                for (int llllllllllIlllIlIlllllIIlIIIlIlI = 0; llllllllllIlllIlIlllllIIlIIIlIlI < 4; ++llllllllllIlllIlIlllllIIlIIIlIlI) {
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 24, 2, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, 24, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 22, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, 23, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.BRICKS_PRISMARINE, 25, 5, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.BRICKS_PRISMARINE, 26, 6, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.SEA_LANTERN, 26, 5, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 33, 2, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, 33, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 34, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, 35, 4, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.BRICKS_PRISMARINE, 32, 5, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.BRICKS_PRISMARINE, 31, 6, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.setBlockState(llllllllllIlllIlIlllllIIlIIIlIII, MonumentBuilding.SEA_LANTERN, 31, 5, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, llllllllllIlllIlIlllllIIlIIIlIll);
                    this.fillWithBlocks(llllllllllIlllIlIlllllIIlIIIlIII, llllllllllIlllIlIlllllIIlIIIlIll, 27, 6, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, 30, 6, 5 + llllllllllIlllIlIlllllIIlIIIlIlI * 4, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                }
            }
        }
    }
    
    public static class MonumentCoreRoom extends Piece
    {
        public MonumentCoreRoom(final EnumFacing llllllllllllIlllllIlllIIlllIlIll, final RoomDefinition llllllllllllIlllllIlllIIlllIlllI, final Random llllllllllllIlllllIlllIIlllIllIl) {
            super(1, llllllllllllIlllllIlllIIlllIlIll, llllllllllllIlllllIlllIIlllIlllI, 2, 2, 2);
        }
        
        public MonumentCoreRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIlllllIlllIIlllIIIIl, final Random llllllllllllIlllllIlllIIlllIIIII, final StructureBoundingBox llllllllllllIlllllIlllIIllIlllll) {
            this.generateBoxOnFillOnly(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, 8, 0, 14, 8, 14, MonumentCoreRoom.ROUGH_PRISMARINE);
            final int llllllllllllIlllllIlllIIllIllllI = 7;
            IBlockState llllllllllllIlllllIlllIIllIlllIl = MonumentCoreRoom.BRICKS_PRISMARINE;
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 0, 7, 0, 0, 7, 15, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 15, 7, 0, 15, 7, 15, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, 7, 0, 15, 7, 0, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, 7, 15, 14, 7, 15, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
            for (int llllllllllllIlllllIlllIIllIlllII = 1; llllllllllllIlllllIlllIIllIlllII <= 6; ++llllllllllllIlllllIlllIIllIlllII) {
                llllllllllllIlllllIlllIIllIlllIl = MonumentCoreRoom.BRICKS_PRISMARINE;
                if (llllllllllllIlllllIlllIIllIlllII == 2 || llllllllllllIlllllIlllIIllIlllII == 6) {
                    llllllllllllIlllllIlllIIllIlllIl = MonumentCoreRoom.ROUGH_PRISMARINE;
                }
                for (int llllllllllllIlllllIlllIIllIllIll = 0; llllllllllllIlllllIlllIIllIllIll <= 15; llllllllllllIlllllIlllIIllIllIll += 15) {
                    this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 0, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 1, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                    this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 6, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 9, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                    this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 14, llllllllllllIlllllIlllIIllIllIll, llllllllllllIlllllIlllIIllIlllII, 15, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                }
                this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, llllllllllllIlllllIlllIIllIlllII, 0, 1, llllllllllllIlllllIlllIIllIlllII, 0, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 6, llllllllllllIlllllIlllIIllIlllII, 0, 9, llllllllllllIlllllIlllIIllIlllII, 0, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 14, llllllllllllIlllllIlllIIllIlllII, 0, 14, llllllllllllIlllllIlllIIllIlllII, 0, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
                this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, llllllllllllIlllllIlllIIllIlllII, 15, 14, llllllllllllIlllllIlllIIllIlllII, 15, llllllllllllIlllllIlllIIllIlllIl, llllllllllllIlllllIlllIIllIlllIl, false);
            }
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 6, 3, 6, 9, 6, 9, MonumentCoreRoom.DARK_PRISMARINE, MonumentCoreRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 7, 4, 7, 8, 5, 8, Blocks.GOLD_BLOCK.getDefaultState(), Blocks.GOLD_BLOCK.getDefaultState(), false);
            for (int llllllllllllIlllllIlllIIllIllIlI = 3; llllllllllllIlllllIlllIIllIllIlI <= 6; llllllllllllIlllllIlllIIllIllIlI += 3) {
                for (int llllllllllllIlllllIlllIIllIllIIl = 6; llllllllllllIlllllIlllIIllIllIIl <= 9; llllllllllllIlllllIlllIIllIllIIl += 3) {
                    this.setBlockState(llllllllllllIlllllIlllIIlllIIIIl, MonumentCoreRoom.SEA_LANTERN, llllllllllllIlllllIlllIIllIllIIl, llllllllllllIlllllIlllIIllIllIlI, 6, llllllllllllIlllllIlllIIllIlllll);
                    this.setBlockState(llllllllllllIlllllIlllIIlllIIIIl, MonumentCoreRoom.SEA_LANTERN, llllllllllllIlllllIlllIIllIllIIl, llllllllllllIlllllIlllIIllIllIlI, 9, llllllllllllIlllllIlllIIllIlllll);
                }
            }
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 1, 6, 5, 2, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 1, 9, 5, 2, 9, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 1, 6, 10, 2, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 1, 9, 10, 2, 9, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 6, 1, 5, 6, 2, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 9, 1, 5, 9, 2, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 6, 1, 10, 6, 2, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 9, 1, 10, 9, 2, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 2, 5, 5, 6, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 2, 10, 5, 6, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 2, 5, 10, 6, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 2, 10, 10, 6, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 7, 1, 5, 7, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 7, 1, 10, 7, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 5, 7, 9, 5, 7, 14, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 10, 7, 9, 10, 7, 14, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, 7, 5, 6, 7, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 1, 7, 10, 6, 7, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 9, 7, 5, 14, 7, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 9, 7, 10, 14, 7, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 2, 1, 2, 2, 1, 3, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 3, 1, 2, 3, 1, 2, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 13, 1, 2, 13, 1, 3, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 12, 1, 2, 12, 1, 2, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 2, 1, 12, 2, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 3, 1, 13, 3, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 13, 1, 12, 13, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllIlllllIlllIIlllIIIIl, llllllllllllIlllllIlllIIllIlllll, 12, 1, 13, 12, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            return true;
        }
    }
    
    static class ZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean fits(final RoomDefinition llllllllllllIIIIIllIIIlllllIIIIl) {
            return llllllllllllIIIIIllIIIlllllIIIIl.hasOpening[EnumFacing.NORTH.getIndex()] && !llllllllllllIIIIIllIIIlllllIIIIl.connections[EnumFacing.NORTH.getIndex()].claimed;
        }
        
        @Override
        public Piece create(final EnumFacing llllllllllllIIIIIllIIIllllIllIll, final RoomDefinition llllllllllllIIIIIllIIIllllIlIllI, final Random llllllllllllIIIIIllIIIllllIllIIl) {
            RoomDefinition llllllllllllIIIIIllIIIllllIllIII = llllllllllllIIIIIllIIIllllIlIllI;
            if (!llllllllllllIIIIIllIIIllllIlIllI.hasOpening[EnumFacing.NORTH.getIndex()] || llllllllllllIIIIIllIIIllllIlIllI.connections[EnumFacing.NORTH.getIndex()].claimed) {
                llllllllllllIIIIIllIIIllllIllIII = llllllllllllIIIIIllIIIllllIlIllI.connections[EnumFacing.SOUTH.getIndex()];
            }
            llllllllllllIIIIIllIIIllllIllIII.claimed = true;
            llllllllllllIIIIIllIIIllllIllIII.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            return new DoubleZRoom(llllllllllllIIIIIllIIIllllIllIll, llllllllllllIIIIIllIIIllllIllIII, llllllllllllIIIIIllIIIllllIllIIl);
        }
        
        private ZDoubleRoomFitHelper() {
        }
    }
    
    public static class DoubleZRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllIllIlIllIlIIllIIIIlII, final Random lllllllllllIllIlIllIlIIllIIIIIll, final StructureBoundingBox lllllllllllIllIlIllIlIIllIIIIIlI) {
            final RoomDefinition lllllllllllIllIlIllIlIIllIIIIIIl = this.roomDefinition.connections[EnumFacing.NORTH.getIndex()];
            final RoomDefinition lllllllllllIllIlIllIlIIllIIIIIII = this.roomDefinition;
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 8, lllllllllllIllIlIllIlIIllIIIIIIl.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 0, lllllllllllIllIlIllIlIIllIIIIIII.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIII.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 4, 1, 6, 4, 7, DoubleZRoom.ROUGH_PRISMARINE);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIIl.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 4, 8, 6, 4, 14, DoubleZRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 3, 0, 0, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 7, 3, 0, 7, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 3, 0, 7, 3, 0, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 3, 15, 6, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 2, 0, 0, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 7, 2, 0, 7, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 2, 0, 7, 2, 0, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 2, 15, 6, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 1, 0, 0, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 7, 1, 0, 7, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 1, 0, 7, 1, 0, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 1, 15, 6, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 1, 1, 1, 1, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 6, 1, 1, 6, 1, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 3, 1, 1, 3, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 6, 3, 1, 6, 3, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 1, 13, 1, 1, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 6, 1, 13, 6, 1, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 1, 3, 13, 1, 3, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 6, 3, 13, 6, 3, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 2, 1, 6, 2, 3, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 5, 1, 6, 5, 3, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 2, 1, 9, 2, 3, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 5, 1, 9, 5, 3, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 3, 2, 6, 4, 2, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 3, 2, 9, 4, 2, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 2, 2, 7, 2, 2, 8, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 5, 2, 7, 5, 2, 8, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.SEA_LANTERN, 2, 2, 5, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.SEA_LANTERN, 5, 2, 5, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.SEA_LANTERN, 2, 2, 10, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.SEA_LANTERN, 5, 2, 10, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.BRICKS_PRISMARINE, 2, 3, 5, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.BRICKS_PRISMARINE, 5, 3, 5, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.BRICKS_PRISMARINE, 2, 3, 10, lllllllllllIllIlIllIlIIllIIIIIlI);
            this.setBlockState(lllllllllllIllIlIllIlIIllIIIIlII, DoubleZRoom.BRICKS_PRISMARINE, 5, 3, 10, lllllllllllIllIlIllIlIIllIIIIIlI);
            if (lllllllllllIllIlIllIlIIllIIIIIII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 3, 1, 0, 4, 2, 0, false);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 7, 1, 3, 7, 2, 4, false);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIII.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 1, 3, 0, 2, 4, false);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 3, 1, 15, 4, 2, 15, false);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIIl.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 0, 1, 11, 0, 2, 12, false);
            }
            if (lllllllllllIllIlIllIlIIllIIIIIIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllIllIlIllIlIIllIIIIlII, lllllllllllIllIlIllIlIIllIIIIIlI, 7, 1, 11, 7, 2, 12, false);
            }
            return true;
        }
        
        public DoubleZRoom(final EnumFacing lllllllllllIllIlIllIlIIllIIIllII, final RoomDefinition lllllllllllIllIlIllIlIIllIIIllll, final Random lllllllllllIllIlIllIlIIllIIIlllI) {
            super(1, lllllllllllIllIlIllIlIIllIIIllII, lllllllllllIllIlIllIlIIllIIIllll, 1, 1, 2);
        }
        
        public DoubleZRoom() {
        }
    }
    
    static class XYDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        private XYDoubleRoomFitHelper() {
        }
        
        @Override
        public Piece create(final EnumFacing lllllllllllllIlIIlIIIlllIlIIIlll, final RoomDefinition lllllllllllllIlIIlIIIlllIlIIIllI, final Random lllllllllllllIlIIlIIIlllIlIIIIlI) {
            lllllllllllllIlIIlIIIlllIlIIIllI.claimed = true;
            lllllllllllllIlIIlIIIlllIlIIIllI.connections[EnumFacing.EAST.getIndex()].claimed = true;
            lllllllllllllIlIIlIIIlllIlIIIllI.connections[EnumFacing.UP.getIndex()].claimed = true;
            lllllllllllllIlIIlIIIlllIlIIIllI.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleXYRoom(lllllllllllllIlIIlIIIlllIlIIIlll, lllllllllllllIlIIlIIIlllIlIIIllI, lllllllllllllIlIIlIIIlllIlIIIIlI);
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIlIIlIIIlllIlIIllIl) {
            if (lllllllllllllIlIIlIIIlllIlIIllIl.hasOpening[EnumFacing.EAST.getIndex()] && !lllllllllllllIlIIlIIIlllIlIIllIl.connections[EnumFacing.EAST.getIndex()].claimed && lllllllllllllIlIIlIIIlllIlIIllIl.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllIlIIlIIIlllIlIIllIl.connections[EnumFacing.UP.getIndex()].claimed) {
                final RoomDefinition lllllllllllllIlIIlIIIlllIlIIlllI = lllllllllllllIlIIlIIIlllIlIIllIl.connections[EnumFacing.EAST.getIndex()];
                return lllllllllllllIlIIlIIIlllIlIIlllI.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllIlIIlIIIlllIlIIlllI.connections[EnumFacing.UP.getIndex()].claimed;
            }
            return false;
        }
    }
    
    public static class DoubleXYRoom extends Piece
    {
        public DoubleXYRoom() {
        }
        
        public DoubleXYRoom(final EnumFacing llllllllllIlllIlIIIlIIIIIIlIllII, final RoomDefinition llllllllllIlllIlIIIlIIIIIIlIllll, final Random llllllllllIlllIlIIIlIIIIIIlIlllI) {
            super(1, llllllllllIlllIlIIIlIIIIIIlIllII, llllllllllIlllIlIIIlIIIIIIlIllll, 2, 2, 1);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIlIIIlIIIIIIIlIllI, final Random llllllllllIlllIlIIIlIIIIIIIlllll, final StructureBoundingBox llllllllllIlllIlIIIlIIIIIIIlIlIl) {
            final RoomDefinition llllllllllIlllIlIIIlIIIIIIIlllIl = this.roomDefinition.connections[EnumFacing.EAST.getIndex()];
            final RoomDefinition llllllllllIlllIlIIIlIIIIIIIlllII = this.roomDefinition;
            final RoomDefinition llllllllllIlllIlIIIlIIIIIIIllIll = llllllllllIlllIlIIIlIIIIIIIlllII.connections[EnumFacing.UP.getIndex()];
            final RoomDefinition llllllllllIlllIlIIIlIIIIIIIllIlI = llllllllllIlllIlIIIlIIIIIIIlllIl.connections[EnumFacing.UP.getIndex()];
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 8, 0, llllllllllIlllIlIIIlIIIIIIIlllIl.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 0, 0, llllllllllIlllIlIIIlIIIIIIIlllII.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 1, 8, 1, 7, 8, 6, DoubleXYRoom.ROUGH_PRISMARINE);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIlI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 8, 8, 1, 14, 8, 6, DoubleXYRoom.ROUGH_PRISMARINE);
            }
            for (int llllllllllIlllIlIIIlIIIIIIIllIIl = 1; llllllllllIlllIlIIIlIIIIIIIllIIl <= 7; ++llllllllllIlllIlIIIlIIIIIIIllIIl) {
                IBlockState llllllllllIlllIlIIIlIIIIIIIllIII = DoubleXYRoom.BRICKS_PRISMARINE;
                if (llllllllllIlllIlIIIlIIIIIIIllIIl == 2 || llllllllllIlllIlIIIlIIIIIIIllIIl == 6) {
                    llllllllllIlllIlIIIlIIIIIIIllIII = DoubleXYRoom.ROUGH_PRISMARINE;
                }
                this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 0, llllllllllIlllIlIIIlIIIIIIIllIIl, 0, 0, llllllllllIlllIlIIIlIIIIIIIllIIl, 7, llllllllllIlllIlIIIlIIIIIIIllIII, llllllllllIlllIlIIIlIIIIIIIllIII, false);
                this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 15, llllllllllIlllIlIIIlIIIIIIIllIIl, 0, 15, llllllllllIlllIlIIIlIIIIIIIllIIl, 7, llllllllllIlllIlIIIlIIIIIIIllIII, llllllllllIlllIlIIIlIIIIIIIllIII, false);
                this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 1, llllllllllIlllIlIIIlIIIIIIIllIIl, 0, 15, llllllllllIlllIlIIIlIIIIIIIllIIl, 0, llllllllllIlllIlIIIlIIIIIIIllIII, llllllllllIlllIlIIIlIIIIIIIllIII, false);
                this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 1, llllllllllIlllIlIIIlIIIIIIIllIIl, 7, 14, llllllllllIlllIlIIIlIIIIIIIllIIl, 7, llllllllllIlllIlIIIlIIIIIIIllIII, llllllllllIlllIlIIIlIIIIIIIllIII, false);
            }
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 2, 1, 3, 2, 7, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 1, 2, 4, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 1, 5, 4, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 13, 1, 3, 13, 7, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 1, 2, 12, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 1, 5, 12, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 5, 1, 3, 5, 3, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 10, 1, 3, 10, 3, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 5, 7, 2, 10, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 5, 5, 2, 5, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 10, 5, 2, 10, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 5, 5, 5, 5, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 10, 5, 5, 10, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.BRICKS_PRISMARINE, 6, 6, 2, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.BRICKS_PRISMARINE, 9, 6, 2, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.BRICKS_PRISMARINE, 6, 6, 5, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.BRICKS_PRISMARINE, 9, 6, 5, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 5, 4, 3, 6, 4, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 9, 4, 3, 10, 4, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.SEA_LANTERN, 5, 4, 2, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.SEA_LANTERN, 5, 4, 5, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.SEA_LANTERN, 10, 4, 2, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            this.setBlockState(llllllllllIlllIlIIIlIIIIIIIlIllI, DoubleXYRoom.SEA_LANTERN, 10, 4, 5, llllllllllIlllIlIIIlIIIIIIIlIlIl);
            if (llllllllllIlllIlIIIlIIIIIIIlllII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 1, 0, 4, 2, 0, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIlllII.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 1, 7, 4, 2, 7, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIlllII.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 0, 1, 3, 0, 2, 4, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIlllIl.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 1, 0, 12, 2, 0, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIlllIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 1, 7, 12, 2, 7, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIlllIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 15, 1, 3, 15, 2, 4, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 5, 0, 4, 6, 0, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 3, 5, 7, 4, 6, 7, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 0, 5, 3, 0, 6, 4, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIlI.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 5, 0, 12, 6, 0, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIlI.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 11, 5, 7, 12, 6, 7, false);
            }
            if (llllllllllIlllIlIIIlIIIIIIIllIlI.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(llllllllllIlllIlIIIlIIIIIIIlIllI, llllllllllIlllIlIIIlIIIIIIIlIlIl, 15, 5, 3, 15, 6, 4, false);
            }
            return true;
        }
    }
    
    static class FitSimpleRoomTopHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean fits(final RoomDefinition lllllllllllIIllIIIlIlIllIlIlIIll) {
            return !lllllllllllIIllIIIlIlIllIlIlIIll.hasOpening[EnumFacing.WEST.getIndex()] && !lllllllllllIIllIIIlIlIllIlIlIIll.hasOpening[EnumFacing.EAST.getIndex()] && !lllllllllllIIllIIIlIlIllIlIlIIll.hasOpening[EnumFacing.NORTH.getIndex()] && !lllllllllllIIllIIIlIlIllIlIlIIll.hasOpening[EnumFacing.SOUTH.getIndex()] && !lllllllllllIIllIIIlIlIllIlIlIIll.hasOpening[EnumFacing.UP.getIndex()];
        }
        
        private FitSimpleRoomTopHelper() {
        }
        
        @Override
        public Piece create(final EnumFacing lllllllllllIIllIIIlIlIllIlIIlllI, final RoomDefinition lllllllllllIIllIIIlIlIllIlIIllIl, final Random lllllllllllIIllIIIlIlIllIlIIllII) {
            lllllllllllIIllIIIlIlIllIlIIllIl.claimed = true;
            return new SimpleTopRoom(lllllllllllIIllIIIlIlIllIlIIlllI, lllllllllllIIllIIIlIlIllIlIIllIl, lllllllllllIIllIIIlIlIllIlIIllII);
        }
    }
    
    static class YDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lllllllllllllllIIllIlIIIIIlIIIII, final RoomDefinition lllllllllllllllIIllIlIIIIIIlllII, final Random lllllllllllllllIIllIlIIIIIIllllI) {
            lllllllllllllllIIllIlIIIIIIlllII.claimed = true;
            lllllllllllllllIIllIlIIIIIIlllII.connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleYRoom(lllllllllllllllIIllIlIIIIIlIIIII, lllllllllllllllIIllIlIIIIIIlllII, lllllllllllllllIIllIlIIIIIIllllI);
        }
        
        private YDoubleRoomFitHelper() {
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllllIIllIlIIIIIlIIlIl) {
            return lllllllllllllllIIllIlIIIIIlIIlIl.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllllIIllIlIIIIIlIIlIl.connections[EnumFacing.UP.getIndex()].claimed;
        }
    }
}
