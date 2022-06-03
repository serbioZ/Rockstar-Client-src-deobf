// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRail;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import com.google.common.collect.Lists;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import java.util.List;

public class StructureMineshaftPieces
{
    private static Peice func_189938_b(final StructureComponent lllllllllllllIlllIIIlllIIlIIIlIl, final List<StructureComponent> lllllllllllllIlllIIIlllIIIlllIlI, final Random lllllllllllllIlllIIIlllIIIlllIIl, final int lllllllllllllIlllIIIlllIIIlllIII, final int lllllllllllllIlllIIIlllIIIllIlll, final int lllllllllllllIlllIIIlllIIlIIIIII, final EnumFacing lllllllllllllIlllIIIlllIIIllllll, final int lllllllllllllIlllIIIlllIIIlllllI) {
        if (lllllllllllllIlllIIIlllIIIlllllI > 8) {
            return null;
        }
        if (Math.abs(lllllllllllllIlllIIIlllIIIlllIII - lllllllllllllIlllIIIlllIIlIIIlIl.getBoundingBox().minX) <= 80 && Math.abs(lllllllllllllIlllIIIlllIIlIIIIII - lllllllllllllIlllIIIlllIIlIIIlIl.getBoundingBox().minZ) <= 80) {
            final MapGenMineshaft.Type lllllllllllllIlllIIIlllIIIllllIl = ((Peice)lllllllllllllIlllIIIlllIIlIIIlIl).mineShaftType;
            final Peice lllllllllllllIlllIIIlllIIIllllII = func_189940_a(lllllllllllllIlllIIIlllIIIlllIlI, lllllllllllllIlllIIIlllIIIlllIIl, lllllllllllllIlllIIIlllIIIlllIII, lllllllllllllIlllIIIlllIIIllIlll, lllllllllllllIlllIIIlllIIlIIIIII, lllllllllllllIlllIIIlllIIIllllll, lllllllllllllIlllIIIlllIIIlllllI + 1, lllllllllllllIlllIIIlllIIIllllIl);
            if (lllllllllllllIlllIIIlllIIIllllII != null) {
                lllllllllllllIlllIIIlllIIIlllIlI.add(lllllllllllllIlllIIIlllIIIllllII);
                lllllllllllllIlllIIIlllIIIllllII.buildComponent(lllllllllllllIlllIIIlllIIlIIIlIl, lllllllllllllIlllIIIlllIIIlllIlI, lllllllllllllIlllIIIlllIIIlllIIl);
            }
            return lllllllllllllIlllIIIlllIIIllllII;
        }
        return null;
    }
    
    private static Peice func_189940_a(final List<StructureComponent> lllllllllllllIlllIIIlllIIlIllIIl, final Random lllllllllllllIlllIIIlllIIllIIlII, final int lllllllllllllIlllIIIlllIIlIlIlll, final int lllllllllllllIlllIIIlllIIlIlIllI, final int lllllllllllllIlllIIIlllIIlIlIlIl, @Nullable final EnumFacing lllllllllllllIlllIIIlllIIlIlIlII, final int lllllllllllllIlllIIIlllIIlIlllll, final MapGenMineshaft.Type lllllllllllllIlllIIIlllIIlIlIIlI) {
        final int lllllllllllllIlllIIIlllIIlIlllIl = lllllllllllllIlllIIIlllIIllIIlII.nextInt(100);
        if (lllllllllllllIlllIIIlllIIlIlllIl >= 80) {
            final StructureBoundingBox lllllllllllllIlllIIIlllIIlIlllII = Cross.findCrossing(lllllllllllllIlllIIIlllIIlIllIIl, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIlIlll, lllllllllllllIlllIIIlllIIlIlIllI, lllllllllllllIlllIIIlllIIlIlIlIl, lllllllllllllIlllIIIlllIIlIlIlII);
            if (lllllllllllllIlllIIIlllIIlIlllII != null) {
                return new Cross(lllllllllllllIlllIIIlllIIlIlllll, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIlllII, lllllllllllllIlllIIIlllIIlIlIlII, lllllllllllllIlllIIIlllIIlIlIIlI);
            }
        }
        else if (lllllllllllllIlllIIIlllIIlIlllIl >= 70) {
            final StructureBoundingBox lllllllllllllIlllIIIlllIIlIllIll = Stairs.findStairs(lllllllllllllIlllIIIlllIIlIllIIl, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIlIlll, lllllllllllllIlllIIIlllIIlIlIllI, lllllllllllllIlllIIIlllIIlIlIlIl, lllllllllllllIlllIIIlllIIlIlIlII);
            if (lllllllllllllIlllIIIlllIIlIllIll != null) {
                return new Stairs(lllllllllllllIlllIIIlllIIlIlllll, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIllIll, lllllllllllllIlllIIIlllIIlIlIlII, lllllllllllllIlllIIIlllIIlIlIIlI);
            }
        }
        else {
            final StructureBoundingBox lllllllllllllIlllIIIlllIIlIllIlI = Corridor.findCorridorSize(lllllllllllllIlllIIIlllIIlIllIIl, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIlIlll, lllllllllllllIlllIIIlllIIlIlIllI, lllllllllllllIlllIIIlllIIlIlIlIl, lllllllllllllIlllIIIlllIIlIlIlII);
            if (lllllllllllllIlllIIIlllIIlIllIlI != null) {
                return new Corridor(lllllllllllllIlllIIIlllIIlIlllll, lllllllllllllIlllIIIlllIIllIIlII, lllllllllllllIlllIIIlllIIlIllIlI, lllllllllllllIlllIIIlllIIlIlIlII, lllllllllllllIlllIIIlllIIlIlIIlI);
            }
        }
        return null;
    }
    
    public static void registerStructurePieces() {
        MapGenStructureIO.registerStructureComponent(Corridor.class, "MSCorridor");
        MapGenStructureIO.registerStructureComponent(Cross.class, "MSCrossing");
        MapGenStructureIO.registerStructureComponent(Room.class, "MSRoom");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "MSStairs");
    }
    
    public static class Room extends Peice
    {
        private final /* synthetic */ List<StructureBoundingBox> roomsLinkedToTheRoom;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllIIlIIIIII) {
            super.writeStructureToNBT(llllIIlIIIIII);
            final NBTTagList llllIIlIIIIll = new NBTTagList();
            for (final StructureBoundingBox llllIIlIIIIlI : this.roomsLinkedToTheRoom) {
                llllIIlIIIIll.appendTag(llllIIlIIIIlI.toNBTTagIntArray());
            }
            llllIIlIIIIII.setTag("Entrances", llllIIlIIIIll);
        }
        
        @Override
        public void buildComponent(final StructureComponent llllIIlllIIlI, final List<StructureComponent> llllIIlllIIIl, final Random llllIIlllIIII) {
            final int llllIIllllllI = this.getComponentType();
            int llllIIlllllIl = this.boundingBox.getYSize() - 3 - 1;
            if (llllIIlllllIl <= 0) {
                llllIIlllllIl = 1;
            }
            for (int llllIIlllllII = 0; llllIIlllllII < this.boundingBox.getXSize(); llllIIlllllII += 4) {
                llllIIlllllII += llllIIlllIIII.nextInt(this.boundingBox.getXSize());
                if (llllIIlllllII + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final Peice llllIIllllIll = func_189938_b(llllIIlllIIlI, llllIIlllIIIl, llllIIlllIIII, this.boundingBox.minX + llllIIlllllII, this.boundingBox.minY + llllIIlllIIII.nextInt(llllIIlllllIl) + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllIIllllllI);
                if (llllIIllllIll != null) {
                    final StructureBoundingBox llllIIllllIlI = llllIIllllIll.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llllIIllllIlI.minX, llllIIllllIlI.minY, this.boundingBox.minZ, llllIIllllIlI.maxX, llllIIllllIlI.maxY, this.boundingBox.minZ + 1));
                }
            }
            for (int llllIIlllllII = 0; llllIIlllllII < this.boundingBox.getXSize(); llllIIlllllII += 4) {
                llllIIlllllII += llllIIlllIIII.nextInt(this.boundingBox.getXSize());
                if (llllIIlllllII + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final Peice llllIIllllIIl = func_189938_b(llllIIlllIIlI, llllIIlllIIIl, llllIIlllIIII, this.boundingBox.minX + llllIIlllllII, this.boundingBox.minY + llllIIlllIIII.nextInt(llllIIlllllIl) + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllIIllllllI);
                if (llllIIllllIIl != null) {
                    final StructureBoundingBox llllIIllllIII = llllIIllllIIl.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llllIIllllIII.minX, llllIIllllIII.minY, this.boundingBox.maxZ - 1, llllIIllllIII.maxX, llllIIllllIII.maxY, this.boundingBox.maxZ));
                }
            }
            for (int llllIIlllllII = 0; llllIIlllllII < this.boundingBox.getZSize(); llllIIlllllII += 4) {
                llllIIlllllII += llllIIlllIIII.nextInt(this.boundingBox.getZSize());
                if (llllIIlllllII + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final Peice llllIIlllIlll = func_189938_b(llllIIlllIIlI, llllIIlllIIIl, llllIIlllIIII, this.boundingBox.minX - 1, this.boundingBox.minY + llllIIlllIIII.nextInt(llllIIlllllIl) + 1, this.boundingBox.minZ + llllIIlllllII, EnumFacing.WEST, llllIIllllllI);
                if (llllIIlllIlll != null) {
                    final StructureBoundingBox llllIIlllIllI = llllIIlllIlll.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, llllIIlllIllI.minY, llllIIlllIllI.minZ, this.boundingBox.minX + 1, llllIIlllIllI.maxY, llllIIlllIllI.maxZ));
                }
            }
            for (int llllIIlllllII = 0; llllIIlllllII < this.boundingBox.getZSize(); llllIIlllllII += 4) {
                llllIIlllllII += llllIIlllIIII.nextInt(this.boundingBox.getZSize());
                if (llllIIlllllII + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final StructureComponent llllIIlllIlIl = func_189938_b(llllIIlllIIlI, llllIIlllIIIl, llllIIlllIIII, this.boundingBox.maxX + 1, this.boundingBox.minY + llllIIlllIIII.nextInt(llllIIlllllIl) + 1, this.boundingBox.minZ + llllIIlllllII, EnumFacing.EAST, llllIIllllllI);
                if (llllIIlllIlIl != null) {
                    final StructureBoundingBox llllIIlllIlII = llllIIlllIlIl.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, llllIIlllIlII.minY, llllIIlllIlII.minZ, this.boundingBox.maxX, llllIIlllIlII.maxY, llllIIlllIlII.maxZ));
                }
            }
        }
        
        public Room() {
            this.roomsLinkedToTheRoom = (List<StructureBoundingBox>)Lists.newLinkedList();
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllIIIllIIIl, final TemplateManager llllIIIllIlIl) {
            super.readStructureFromNBT(llllIIIllIIIl, llllIIIllIlIl);
            final NBTTagList llllIIIllIlII = llllIIIllIIIl.getTagList("Entrances", 11);
            for (int llllIIIllIIll = 0; llllIIIllIIll < llllIIIllIlII.tagCount(); ++llllIIIllIIll) {
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llllIIIllIlII.getIntArrayAt(llllIIIllIIll)));
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllIIllIIlII, final Random llllIIllIIIll, final StructureBoundingBox llllIIllIIIlI) {
            if (this.isLiquidInStructureBoundingBox(llllIIllIIlII, llllIIllIIIlI)) {
                return false;
            }
            this.fillWithBlocks(llllIIllIIlII, llllIIllIIIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.DIRT.getDefaultState(), Blocks.AIR.getDefaultState(), true);
            this.fillWithBlocks(llllIIllIIlII, llllIIllIIIlI, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (final StructureBoundingBox llllIIllIIIIl : this.roomsLinkedToTheRoom) {
                this.fillWithBlocks(llllIIllIIlII, llllIIllIIIlI, llllIIllIIIIl.minX, llllIIllIIIIl.maxY - 2, llllIIllIIIIl.minZ, llllIIllIIIIl.maxX, llllIIllIIIIl.maxY, llllIIllIIIIl.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.randomlyRareFillWithBlocks(llllIIllIIlII, llllIIllIIIlI, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), false);
            return true;
        }
        
        public Room(final int llllIlIIlIIII, final Random llllIlIIIllll, final int llllIlIIlIlII, final int llllIlIIlIIll, final MapGenMineshaft.Type llllIlIIIllII) {
            super(llllIlIIlIIII, llllIlIIIllII);
            this.roomsLinkedToTheRoom = (List<StructureBoundingBox>)Lists.newLinkedList();
            this.mineShaftType = llllIlIIIllII;
            this.boundingBox = new StructureBoundingBox(llllIlIIlIlII, 50, llllIlIIlIIll, llllIlIIlIlII + 7 + llllIlIIIllll.nextInt(6), 54 + llllIlIIIllll.nextInt(6), llllIlIIlIIll + 7 + llllIlIIIllll.nextInt(6));
        }
        
        @Override
        public void offset(final int llllIIlIIllll, final int llllIIlIlIIll, final int llllIIlIIllIl) {
            super.offset(llllIIlIIllll, llllIIlIlIIll, llllIIlIIllIl);
            for (final StructureBoundingBox llllIIlIlIIIl : this.roomsLinkedToTheRoom) {
                llllIIlIlIIIl.offset(llllIIlIIllll, llllIIlIlIIll, llllIIlIIllIl);
            }
        }
    }
    
    abstract static class Peice extends StructureComponent
    {
        protected /* synthetic */ MapGenMineshaft.Type mineShaftType;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type;
        
        public Peice() {
        }
        
        protected IBlockState func_189919_b() {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type()[this.mineShaftType.ordinal()]) {
                default: {
                    return Blocks.OAK_FENCE.getDefaultState();
                }
                case 2: {
                    return Blocks.DARK_OAK_FENCE.getDefaultState();
                }
            }
        }
        
        protected boolean func_189918_a(final World llllllllllllllIllIIllIIlIllllIll, final StructureBoundingBox llllllllllllllIllIIllIIlIllllIlI, final int llllllllllllllIllIIllIIlIllllIIl, final int llllllllllllllIllIIllIIllIIIIIII, final int llllllllllllllIllIIllIIlIlllIlll, final int llllllllllllllIllIIllIIlIlllIllI) {
            for (int llllllllllllllIllIIllIIlIlllllIl = llllllllllllllIllIIllIIlIllllIIl; llllllllllllllIllIIllIIlIlllllIl <= llllllllllllllIllIIllIIllIIIIIII; ++llllllllllllllIllIIllIIlIlllllIl) {
                if (this.getBlockStateFromPos(llllllllllllllIllIIllIIlIllllIll, llllllllllllllIllIIllIIlIlllllIl, llllllllllllllIllIIllIIlIlllIlll + 1, llllllllllllllIllIIllIIlIlllIllI, llllllllllllllIllIIllIIlIllllIlI).getMaterial() == Material.AIR) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIllIIllIIllIIlllII) {
            llllllllllllllIllIIllIIllIIlllII.setInteger("MST", this.mineShaftType.ordinal());
        }
        
        protected IBlockState func_189917_F_() {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type()[this.mineShaftType.ordinal()]) {
                default: {
                    return Blocks.PLANKS.getDefaultState();
                }
                case 2: {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
                }
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type() {
            final int[] $switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type = Peice.$SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type;
            if ($switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type != null) {
                return $switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type;
            }
            final Exception llllllllllllllIllIIllIIlIlllIIll = (Object)new int[MapGenMineshaft.Type.values().length];
            try {
                llllllllllllllIllIIllIIlIlllIIll[MapGenMineshaft.Type.MESA.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIllIIllIIlIlllIIll[MapGenMineshaft.Type.NORMAL.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            return Peice.$SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type = (int[])(Object)llllllllllllllIllIIllIIlIlllIIll;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIllIIllIIllIIlIIll, final TemplateManager llllllllllllllIllIIllIIllIIlIlIl) {
            this.mineShaftType = MapGenMineshaft.Type.byId(llllllllllllllIllIIllIIllIIlIIll.getInteger("MST"));
        }
        
        public Peice(final int llllllllllllllIllIIllIIllIlIIlII, final MapGenMineshaft.Type llllllllllllllIllIIllIIllIlIIIll) {
            super(llllllllllllllIllIIllIIllIlIIlII);
            this.mineShaftType = llllllllllllllIllIIllIIllIlIIIll;
        }
    }
    
    public static class Corridor extends Peice
    {
        private /* synthetic */ boolean hasSpiders;
        private /* synthetic */ int sectionCount;
        private /* synthetic */ boolean hasRails;
        private /* synthetic */ boolean spawnerPlaced;
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Corridor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final float lllllllllllllIllIIIIlllllllIIIII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIllIIIIlllllllIIIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Corridor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIllIIIIlllllllIIIII;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIllIIIlIIIIllIlIIIl) {
            super.writeStructureToNBT(lllllllllllllIllIIIlIIIIllIlIIIl);
            lllllllllllllIllIIIlIIIIllIlIIIl.setBoolean("hr", this.hasRails);
            lllllllllllllIllIIIlIIIIllIlIIIl.setBoolean("sc", this.hasSpiders);
            lllllllllllllIllIIIlIIIIllIlIIIl.setBoolean("hps", this.spawnerPlaced);
            lllllllllllllIllIIIlIIIIllIlIIIl.setInteger("Num", this.sectionCount);
        }
        
        private void func_189922_a(final World lllllllllllllIllIIIIlllllllIlIII, final StructureBoundingBox lllllllllllllIllIIIIlllllllIIlll, final Random lllllllllllllIllIIIIlllllllIIllI, final float lllllllllllllIllIIIIlllllllIllIl, final int lllllllllllllIllIIIIlllllllIllII, final int lllllllllllllIllIIIIlllllllIIIll, final int lllllllllllllIllIIIIlllllllIlIlI) {
            if (this.func_189916_b(lllllllllllllIllIIIIlllllllIlIII, lllllllllllllIllIIIIlllllllIllII, lllllllllllllIllIIIIlllllllIIIll, lllllllllllllIllIIIIlllllllIlIlI, lllllllllllllIllIIIIlllllllIIlll) < 8) {
                this.randomlyPlaceBlock(lllllllllllllIllIIIIlllllllIlIII, lllllllllllllIllIIIIlllllllIIlll, lllllllllllllIllIIIIlllllllIIllI, lllllllllllllIllIIIIlllllllIllIl, lllllllllllllIllIIIIlllllllIllII, lllllllllllllIllIIIIlllllllIIIll, lllllllllllllIllIIIIlllllllIlIlI, Blocks.WEB.getDefaultState());
            }
        }
        
        private void func_189921_a(final World lllllllllllllIllIIIlIIIIIIIIIlII, final StructureBoundingBox lllllllllllllIllIIIlIIIIIIIIIIll, final int lllllllllllllIllIIIlIIIIIIIIlllI, final int lllllllllllllIllIIIlIIIIIIIIllIl, final int lllllllllllllIllIIIlIIIIIIIIllII, final int lllllllllllllIllIIIlIIIIIIIIlIll, final int lllllllllllllIllIIIlIIIIIIIIlIlI, final Random lllllllllllllIllIIIIllllllllllIl) {
            if (this.func_189918_a(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII)) {
                final IBlockState lllllllllllllIllIIIlIIIIIIIIlIII = this.func_189917_F_();
                final IBlockState lllllllllllllIllIIIlIIIIIIIIIlll = this.func_189919_b();
                final IBlockState lllllllllllllIllIIIlIIIIIIIIIllI = Blocks.AIR.getDefaultState();
                this.fillWithBlocks(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIllIl, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIlIll - 1, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIIlll, lllllllllllllIllIIIlIIIIIIIIIllI, false);
                this.fillWithBlocks(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIllIl, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIlIll - 1, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIIlll, lllllllllllllIllIIIlIIIIIIIIIllI, false);
                if (lllllllllllllIllIIIIllllllllllIl.nextInt(4) == 0) {
                    this.fillWithBlocks(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIII, lllllllllllllIllIIIlIIIIIIIIIllI, false);
                    this.fillWithBlocks(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIII, lllllllllllllIllIIIlIIIIIIIIIllI, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIlIIIIIIIIlllI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIlI, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII, lllllllllllllIllIIIlIIIIIIIIlIII, lllllllllllllIllIIIlIIIIIIIIIllI, false);
                    this.randomlyPlaceBlock(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIIllllllllllIl, 0.05f, lllllllllllllIllIIIlIIIIIIIIlllI + 1, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII - 1, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH));
                    this.randomlyPlaceBlock(lllllllllllllIllIIIlIIIIIIIIIlII, lllllllllllllIllIIIlIIIIIIIIIIll, lllllllllllllIllIIIIllllllllllIl, 0.05f, lllllllllllllIllIIIlIIIIIIIIlllI + 1, lllllllllllllIllIIIlIIIIIIIIlIll, lllllllllllllIllIIIlIIIIIIIIllII + 1, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH));
                }
            }
        }
        
        public static StructureBoundingBox findCorridorSize(final List<StructureComponent> lllllllllllllIllIIIlIIIIlIlIIIll, final Random lllllllllllllIllIIIlIIIIlIlIlIll, final int lllllllllllllIllIIIlIIIIlIlIIIIl, final int lllllllllllllIllIIIlIIIIlIlIIIII, final int lllllllllllllIllIIIlIIIIlIlIlIII, final EnumFacing lllllllllllllIllIIIlIIIIlIIllllI) {
            final StructureBoundingBox lllllllllllllIllIIIlIIIIlIlIIllI = new StructureBoundingBox(lllllllllllllIllIIIlIIIIlIlIIIIl, lllllllllllllIllIIIlIIIIlIlIIIII, lllllllllllllIllIIIlIIIIlIlIlIII, lllllllllllllIllIIIlIIIIlIlIIIIl, lllllllllllllIllIIIlIIIIlIlIIIII + 2, lllllllllllllIllIIIlIIIIlIlIlIII);
            int lllllllllllllIllIIIlIIIIlIlIIlIl;
            for (lllllllllllllIllIIIlIIIIlIlIIlIl = lllllllllllllIllIIIlIIIIlIlIlIll.nextInt(3) + 2; lllllllllllllIllIIIlIIIIlIlIIlIl > 0; --lllllllllllllIllIIIlIIIIlIlIIlIl) {
                final int lllllllllllllIllIIIlIIIIlIlIIlII = lllllllllllllIllIIIlIIIIlIlIIlIl * 5;
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllIIIlIIIIlIIllllI.ordinal()]) {
                    default: {
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxX = lllllllllllllIllIIIlIIIIlIlIIIIl + 2;
                        lllllllllllllIllIIIlIIIIlIlIIllI.minZ = lllllllllllllIllIIIlIIIIlIlIlIII - (lllllllllllllIllIIIlIIIIlIlIIlII - 1);
                        break;
                    }
                    case 4: {
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxX = lllllllllllllIllIIIlIIIIlIlIIIIl + 2;
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxZ = lllllllllllllIllIIIlIIIIlIlIlIII + (lllllllllllllIllIIIlIIIIlIlIIlII - 1);
                        break;
                    }
                    case 5: {
                        lllllllllllllIllIIIlIIIIlIlIIllI.minX = lllllllllllllIllIIIlIIIIlIlIIIIl - (lllllllllllllIllIIIlIIIIlIlIIlII - 1);
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxZ = lllllllllllllIllIIIlIIIIlIlIlIII + 2;
                        break;
                    }
                    case 6: {
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxX = lllllllllllllIllIIIlIIIIlIlIIIIl + (lllllllllllllIllIIIlIIIIlIlIIlII - 1);
                        lllllllllllllIllIIIlIIIIlIlIIllI.maxZ = lllllllllllllIllIIIlIIIIlIlIlIII + 2;
                        break;
                    }
                }
                if (StructureComponent.findIntersecting(lllllllllllllIllIIIlIIIIlIlIIIll, lllllllllllllIllIIIlIIIIlIlIIllI) == null) {
                    break;
                }
            }
            return (lllllllllllllIllIIIlIIIIlIlIIlIl > 0) ? lllllllllllllIllIIIlIIIIlIlIIllI : null;
        }
        
        public Corridor() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIllIIIlIIIIllIIllII, final TemplateManager lllllllllllllIllIIIlIIIIllIIlIII) {
            super.readStructureFromNBT(lllllllllllllIllIIIlIIIIllIIllII, lllllllllllllIllIIIlIIIIllIIlIII);
            this.hasRails = lllllllllllllIllIIIlIIIIllIIllII.getBoolean("hr");
            this.hasSpiders = lllllllllllllIllIIIlIIIIllIIllII.getBoolean("sc");
            this.spawnerPlaced = lllllllllllllIllIIIlIIIIllIIllII.getBoolean("hps");
            this.sectionCount = lllllllllllllIllIIIlIIIIllIIllII.getInteger("Num");
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIllIIIlIIIIlIIlIIII, final List<StructureComponent> lllllllllllllIllIIIlIIIIlIIIllll, final Random lllllllllllllIllIIIlIIIIlIIIIIll) {
            final int lllllllllllllIllIIIlIIIIlIIIllIl = this.getComponentType();
            final int lllllllllllllIllIIIlIIIIlIIIllII = lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(4);
            final EnumFacing lllllllllllllIllIIIlIIIIlIIIlIll = this.getCoordBaseMode();
            if (lllllllllllllIllIIIlIIIIlIIIlIll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllIIIlIIIIlIIIlIll.ordinal()]) {
                    default: {
                        if (lllllllllllllIllIIIlIIIIlIIIllII <= 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ - 1, lllllllllllllIllIIIlIIIIlIIIlIll, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        if (lllllllllllllIllIIIlIIIIlIIIllII == 2) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ, EnumFacing.WEST, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ, EnumFacing.EAST, lllllllllllllIllIIIlIIIIlIIIllIl);
                        break;
                    }
                    case 4: {
                        if (lllllllllllllIllIIIlIIIIlIIIllII <= 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.maxZ + 1, lllllllllllllIllIIIlIIIIlIIIlIll, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        if (lllllllllllllIllIIIlIIIIlIIIllII == 2) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.WEST, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.EAST, lllllllllllllIllIIIlIIIIlIIIllIl);
                        break;
                    }
                    case 5: {
                        if (lllllllllllllIllIIIlIIIIlIIIllII <= 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ, lllllllllllllIllIIIlIIIIlIIIlIll, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        if (lllllllllllllIllIIIlIIIIlIIIllII == 2) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIllIIIlIIIIlIIIllIl);
                        break;
                    }
                    case 6: {
                        if (lllllllllllllIllIIIlIIIIlIIIllII <= 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ, lllllllllllllIllIIIlIIIIlIIIlIll, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        if (lllllllllllllIllIIIlIIIIlIIIllII == 2) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIllIIIlIIIIlIIIllIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIllIIIlIIIIlIIIllIl);
                        break;
                    }
                }
            }
            if (lllllllllllllIllIIIlIIIIlIIIllIl < 8) {
                if (lllllllllllllIllIIIlIIIIlIIIlIll != EnumFacing.NORTH && lllllllllllllIllIIIlIIIIlIIIlIll != EnumFacing.SOUTH) {
                    for (int lllllllllllllIllIIIlIIIIlIIIlIlI = this.boundingBox.minX + 3; lllllllllllllIllIIIlIIIIlIIIlIlI + 3 <= this.boundingBox.maxX; lllllllllllllIllIIIlIIIIlIIIlIlI += 5) {
                        final int lllllllllllllIllIIIlIIIIlIIIlIIl = lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(5);
                        if (lllllllllllllIllIIIlIIIIlIIIlIIl == 0) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, lllllllllllllIllIIIlIIIIlIIIlIlI, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIllIIIlIIIIlIIIllIl + 1);
                        }
                        else if (lllllllllllllIllIIIlIIIIlIIIlIIl == 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, lllllllllllllIllIIIlIIIIlIIIlIlI, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIllIIIlIIIIlIIIllIl + 1);
                        }
                    }
                }
                else {
                    for (int lllllllllllllIllIIIlIIIIlIIIlIII = this.boundingBox.minZ + 3; lllllllllllllIllIIIlIIIIlIIIlIII + 3 <= this.boundingBox.maxZ; lllllllllllllIllIIIlIIIIlIIIlIII += 5) {
                        final int lllllllllllllIllIIIlIIIIlIIIIlll = lllllllllllllIllIIIlIIIIlIIIIIll.nextInt(5);
                        if (lllllllllllllIllIIIlIIIIlIIIIlll == 0) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.minX - 1, this.boundingBox.minY, lllllllllllllIllIIIlIIIIlIIIlIII, EnumFacing.WEST, lllllllllllllIllIIIlIIIIlIIIllIl + 1);
                        }
                        else if (lllllllllllllIllIIIlIIIIlIIIIlll == 1) {
                            func_189938_b(lllllllllllllIllIIIlIIIIlIIlIIII, lllllllllllllIllIIIlIIIIlIIIllll, lllllllllllllIllIIIlIIIIlIIIIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, lllllllllllllIllIIIlIIIIlIIIlIII, EnumFacing.EAST, lllllllllllllIllIIIlIIIIlIIIllIl + 1);
                        }
                    }
                }
            }
        }
        
        @Override
        protected boolean generateChest(final World lllllllllllllIllIIIlIIIIIllIIllI, final StructureBoundingBox lllllllllllllIllIIIlIIIIIlllIIII, final Random lllllllllllllIllIIIlIIIIIllIllll, final int lllllllllllllIllIIIlIIIIIllIlllI, final int lllllllllllllIllIIIlIIIIIllIIIlI, final int lllllllllllllIllIIIlIIIIIllIllII, final ResourceLocation lllllllllllllIllIIIlIIIIIllIlIll) {
            final BlockPos lllllllllllllIllIIIlIIIIIllIlIlI = new BlockPos(this.getXWithOffset(lllllllllllllIllIIIlIIIIIllIlllI, lllllllllllllIllIIIlIIIIIllIllII), this.getYWithOffset(lllllllllllllIllIIIlIIIIIllIIIlI), this.getZWithOffset(lllllllllllllIllIIIlIIIIIllIlllI, lllllllllllllIllIIIlIIIIIllIllII));
            if (lllllllllllllIllIIIlIIIIIlllIIII.isVecInside(lllllllllllllIllIIIlIIIIIllIlIlI) && lllllllllllllIllIIIlIIIIIllIIllI.getBlockState(lllllllllllllIllIIIlIIIIIllIlIlI).getMaterial() == Material.AIR && lllllllllllllIllIIIlIIIIIllIIllI.getBlockState(lllllllllllllIllIIIlIIIIIllIlIlI.down()).getMaterial() != Material.AIR) {
                final IBlockState lllllllllllllIllIIIlIIIIIllIlIIl = Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, lllllllllllllIllIIIlIIIIIllIllll.nextBoolean() ? BlockRailBase.EnumRailDirection.NORTH_SOUTH : BlockRailBase.EnumRailDirection.EAST_WEST);
                this.setBlockState(lllllllllllllIllIIIlIIIIIllIIllI, lllllllllllllIllIIIlIIIIIllIlIIl, lllllllllllllIllIIIlIIIIIllIlllI, lllllllllllllIllIIIlIIIIIllIIIlI, lllllllllllllIllIIIlIIIIIllIllII, lllllllllllllIllIIIlIIIIIlllIIII);
                final EntityMinecartChest lllllllllllllIllIIIlIIIIIllIlIII = new EntityMinecartChest(lllllllllllllIllIIIlIIIIIllIIllI, lllllllllllllIllIIIlIIIIIllIlIlI.getX() + 0.5f, lllllllllllllIllIIIlIIIIIllIlIlI.getY() + 0.5f, lllllllllllllIllIIIlIIIIIllIlIlI.getZ() + 0.5f);
                lllllllllllllIllIIIlIIIIIllIlIII.setLootTable(lllllllllllllIllIIIlIIIIIllIlIll, lllllllllllllIllIIIlIIIIIllIllll.nextLong());
                lllllllllllllIllIIIlIIIIIllIIllI.spawnEntityInWorld(lllllllllllllIllIIIlIIIIIllIlIII);
                return true;
            }
            return false;
        }
        
        public Corridor(final int lllllllllllllIllIIIlIIIIllIIIIII, final Random lllllllllllllIllIIIlIIIIlIlllIIl, final StructureBoundingBox lllllllllllllIllIIIlIIIIlIlllllI, final EnumFacing lllllllllllllIllIIIlIIIIlIllIlll, final MapGenMineshaft.Type lllllllllllllIllIIIlIIIIlIllIllI) {
            super(lllllllllllllIllIIIlIIIIllIIIIII, lllllllllllllIllIIIlIIIIlIllIllI);
            this.setCoordBaseMode(lllllllllllllIllIIIlIIIIlIllIlll);
            this.boundingBox = lllllllllllllIllIIIlIIIIlIlllllI;
            this.hasRails = (lllllllllllllIllIIIlIIIIlIlllIIl.nextInt(3) == 0);
            this.hasSpiders = (!this.hasRails && lllllllllllllIllIIIlIIIIlIlllIIl.nextInt(23) == 0);
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.sectionCount = lllllllllllllIllIIIlIIIIlIlllllI.getZSize() / 5;
            }
            else {
                this.sectionCount = lllllllllllllIllIIIlIIIIlIlllllI.getXSize() / 5;
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIllIIIlIIIIIlIIlIIl, final Random lllllllllllllIllIIIlIIIIIIlIllIl, final StructureBoundingBox lllllllllllllIllIIIlIIIIIIlIllII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII)) {
                return false;
            }
            final int lllllllllllllIllIIIlIIIIIlIIIllI = 0;
            final int lllllllllllllIllIIIlIIIIIlIIIlIl = 2;
            final int lllllllllllllIllIIIlIIIIIlIIIlII = 0;
            final int lllllllllllllIllIIIlIIIIIlIIIIll = 2;
            final int lllllllllllllIllIIIlIIIIIlIIIIlI = this.sectionCount * 5 - 1;
            final IBlockState lllllllllllllIllIIIlIIIIIlIIIIIl = this.func_189917_F_();
            this.fillWithBlocks(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, 0, 0, 0, 2, 1, lllllllllllllIllIIIlIIIIIlIIIIlI, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.func_189914_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.8f, 0, 2, 0, 2, 2, lllllllllllllIllIIIlIIIIIlIIIIlI, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false, 0);
            if (this.hasSpiders) {
                this.func_189914_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.6f, 0, 0, 0, 2, 1, lllllllllllllIllIIIlIIIIIlIIIIlI, Blocks.WEB.getDefaultState(), Blocks.AIR.getDefaultState(), false, 8);
            }
            for (int lllllllllllllIllIIIlIIIIIlIIIIII = 0; lllllllllllllIllIIIlIIIIIlIIIIII < this.sectionCount; ++lllllllllllllIllIIIlIIIIIlIIIIII) {
                final int lllllllllllllIllIIIlIIIIIIllllll = 2 + lllllllllllllIllIIIlIIIIIlIIIIII * 5;
                this.func_189921_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, 0, 0, lllllllllllllIllIIIlIIIIIIllllll, 2, 2, lllllllllllllIllIIIlIIIIIIlIllIl);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.1f, 0, 2, lllllllllllllIllIIIlIIIIIIllllll - 1);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.1f, 2, 2, lllllllllllllIllIIIlIIIIIIllllll - 1);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.1f, 0, 2, lllllllllllllIllIIIlIIIIIIllllll + 1);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.1f, 2, 2, lllllllllllllIllIIIlIIIIIIllllll + 1);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.05f, 0, 2, lllllllllllllIllIIIlIIIIIIllllll - 2);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.05f, 2, 2, lllllllllllllIllIIIlIIIIIIllllll - 2);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.05f, 0, 2, lllllllllllllIllIIIlIIIIIIllllll + 2);
                this.func_189922_a(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0.05f, 2, 2, lllllllllllllIllIIIlIIIIIIllllll + 2);
                if (lllllllllllllIllIIIlIIIIIIlIllIl.nextInt(100) == 0) {
                    this.generateChest(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 2, 0, lllllllllllllIllIIIlIIIIIIllllll - 1, LootTableList.CHESTS_ABANDONED_MINESHAFT);
                }
                if (lllllllllllllIllIIIlIIIIIIlIllIl.nextInt(100) == 0) {
                    this.generateChest(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, 0, 0, lllllllllllllIllIIIlIIIIIIllllll + 1, LootTableList.CHESTS_ABANDONED_MINESHAFT);
                }
                if (this.hasSpiders && !this.spawnerPlaced) {
                    final int lllllllllllllIllIIIlIIIIIIlllllI = this.getYWithOffset(0);
                    final int lllllllllllllIllIIIlIIIIIIllllIl = lllllllllllllIllIIIlIIIIIIllllll - 1 + lllllllllllllIllIIIlIIIIIIlIllIl.nextInt(3);
                    final int lllllllllllllIllIIIlIIIIIIllllII = this.getXWithOffset(1, lllllllllllllIllIIIlIIIIIIllllIl);
                    final int lllllllllllllIllIIIlIIIIIIlllIll = this.getZWithOffset(1, lllllllllllllIllIIIlIIIIIIllllIl);
                    final BlockPos lllllllllllllIllIIIlIIIIIIlllIlI = new BlockPos(lllllllllllllIllIIIlIIIIIIllllII, lllllllllllllIllIIIlIIIIIIlllllI, lllllllllllllIllIIIlIIIIIIlllIll);
                    if (lllllllllllllIllIIIlIIIIIIlIllII.isVecInside(lllllllllllllIllIIIlIIIIIIlllIlI) && this.func_189916_b(lllllllllllllIllIIIlIIIIIlIIlIIl, 1, 0, lllllllllllllIllIIIlIIIIIIllllIl, lllllllllllllIllIIIlIIIIIIlIllII) < 8) {
                        this.spawnerPlaced = true;
                        lllllllllllllIllIIIlIIIIIlIIlIIl.setBlockState(lllllllllllllIllIIIlIIIIIIlllIlI, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                        final TileEntity lllllllllllllIllIIIlIIIIIIlllIIl = lllllllllllllIllIIIlIIIIIlIIlIIl.getTileEntity(lllllllllllllIllIIIlIIIIIIlllIlI);
                        if (lllllllllllllIllIIIlIIIIIIlllIIl instanceof TileEntityMobSpawner) {
                            ((TileEntityMobSpawner)lllllllllllllIllIIIlIIIIIIlllIIl).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntityCaveSpider.class));
                        }
                    }
                }
            }
            for (int lllllllllllllIllIIIlIIIIIIlllIII = 0; lllllllllllllIllIIIlIIIIIIlllIII <= 2; ++lllllllllllllIllIIIlIIIIIIlllIII) {
                for (int lllllllllllllIllIIIlIIIIIIllIlll = 0; lllllllllllllIllIIIlIIIIIIllIlll <= lllllllllllllIllIIIlIIIIIlIIIIlI; ++lllllllllllllIllIIIlIIIIIIllIlll) {
                    final int lllllllllllllIllIIIlIIIIIIllIllI = -1;
                    final IBlockState lllllllllllllIllIIIlIIIIIIllIlIl = this.getBlockStateFromPos(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlllIII, -1, lllllllllllllIllIIIlIIIIIIllIlll, lllllllllllllIllIIIlIIIIIIlIllII);
                    if (lllllllllllllIllIIIlIIIIIIllIlIl.getMaterial() == Material.AIR && this.func_189916_b(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlllIII, -1, lllllllllllllIllIIIlIIIIIIllIlll, lllllllllllllIllIIIlIIIIIIlIllII) < 8) {
                        final int lllllllllllllIllIIIlIIIIIIllIlII = -1;
                        this.setBlockState(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIlIIIIIl, lllllllllllllIllIIIlIIIIIIlllIII, -1, lllllllllllllIllIIIlIIIIIIllIlll, lllllllllllllIllIIIlIIIIIIlIllII);
                    }
                }
            }
            if (this.hasRails) {
                final IBlockState lllllllllllllIllIIIlIIIIIIllIIll = Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, BlockRailBase.EnumRailDirection.NORTH_SOUTH);
                for (int lllllllllllllIllIIIlIIIIIIllIIlI = 0; lllllllllllllIllIIIlIIIIIIllIIlI <= lllllllllllllIllIIIlIIIIIlIIIIlI; ++lllllllllllllIllIIIlIIIIIIllIIlI) {
                    final IBlockState lllllllllllllIllIIIlIIIIIIllIIIl = this.getBlockStateFromPos(lllllllllllllIllIIIlIIIIIlIIlIIl, 1, -1, lllllllllllllIllIIIlIIIIIIllIIlI, lllllllllllllIllIIIlIIIIIIlIllII);
                    if (lllllllllllllIllIIIlIIIIIIllIIIl.getMaterial() != Material.AIR && lllllllllllllIllIIIlIIIIIIllIIIl.isFullBlock()) {
                        final float lllllllllllllIllIIIlIIIIIIllIIII = (this.func_189916_b(lllllllllllllIllIIIlIIIIIlIIlIIl, 1, 0, lllllllllllllIllIIIlIIIIIIllIIlI, lllllllllllllIllIIIlIIIIIIlIllII) > 8) ? 0.9f : 0.7f;
                        this.randomlyPlaceBlock(lllllllllllllIllIIIlIIIIIlIIlIIl, lllllllllllllIllIIIlIIIIIIlIllII, lllllllllllllIllIIIlIIIIIIlIllIl, lllllllllllllIllIIIlIIIIIIllIIII, 1, 0, lllllllllllllIllIIIlIIIIIIllIIlI, lllllllllllllIllIIIlIIIIIIllIIll);
                    }
                }
            }
            return true;
        }
    }
    
    public static class Stairs extends Peice
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllIlIlIlIIlllIIlllIIlll, final List<StructureComponent> lllllllllllIlIlIlIIlllIIlllIIllI, final Random lllllllllllIlIlIlIIlllIIlllIIlIl) {
            final int lllllllllllIlIlIlIIlllIIlllIIlII = this.getComponentType();
            final EnumFacing lllllllllllIlIlIlIIlllIIlllIIIll = this.getCoordBaseMode();
            if (lllllllllllIlIlIlIIlllIIlllIIIll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIlIlIIlllIIlllIIIll.ordinal()]) {
                    default: {
                        func_189938_b(lllllllllllIlIlIlIIlllIIlllIIlll, lllllllllllIlIlIlIIlllIIlllIIllI, lllllllllllIlIlIlIIlllIIlllIIlIl, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllIlIlIlIIlllIIlllIIlII);
                        break;
                    }
                    case 4: {
                        func_189938_b(lllllllllllIlIlIlIIlllIIlllIIlll, lllllllllllIlIlIlIIlllIIlllIIllI, lllllllllllIlIlIlIIlllIIlllIIlIl, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllIlIlIlIIlllIIlllIIlII);
                        break;
                    }
                    case 5: {
                        func_189938_b(lllllllllllIlIlIlIIlllIIlllIIlll, lllllllllllIlIlIlIIlllIIlllIIllI, lllllllllllIlIlIlIIlllIIlllIIlIl, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, lllllllllllIlIlIlIIlllIIlllIIlII);
                        break;
                    }
                    case 6: {
                        func_189938_b(lllllllllllIlIlIlIIlllIIlllIIlll, lllllllllllIlIlIlIIlllIIlllIIllI, lllllllllllIlIlIlIIlllIIlllIIlIl, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, lllllllllllIlIlIlIIlllIIlllIIlII);
                        break;
                    }
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIlIlIlIIlllIIllIlIIlI, final Random lllllllllllIlIlIlIIlllIIllIlIllI, final StructureBoundingBox lllllllllllIlIlIlIIlllIIllIlIIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllIlIlIlIIlllIIllIlIIlI, lllllllllllIlIlIlIIlllIIllIlIIIl)) {
                return false;
            }
            this.fillWithBlocks(lllllllllllIlIlIlIIlllIIllIlIIlI, lllllllllllIlIlIlIIlllIIllIlIIIl, 0, 5, 0, 2, 7, 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlIlIlIIlllIIllIlIIlI, lllllllllllIlIlIlIIlllIIllIlIIIl, 0, 0, 7, 2, 2, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (int lllllllllllIlIlIlIIlllIIllIlIlII = 0; lllllllllllIlIlIlIIlllIIllIlIlII < 5; ++lllllllllllIlIlIlIIlllIIllIlIlII) {
                this.fillWithBlocks(lllllllllllIlIlIlIIlllIIllIlIIlI, lllllllllllIlIlIlIIlllIIllIlIIIl, 0, 5 - lllllllllllIlIlIlIIlllIIllIlIlII - ((lllllllllllIlIlIlIIlllIIllIlIlII < 4) ? 1 : 0), 2 + lllllllllllIlIlIlIIlllIIllIlIlII, 2, 7 - lllllllllllIlIlIlIIlllIIllIlIlII, 2 + lllllllllllIlIlIlIIlllIIllIlIlII, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        public static StructureBoundingBox findStairs(final List<StructureComponent> lllllllllllIlIlIlIIlllIIllllIlII, final Random lllllllllllIlIlIlIIlllIIlllllIlI, final int lllllllllllIlIlIlIIlllIIlllllIIl, final int lllllllllllIlIlIlIIlllIIllllIIlI, final int lllllllllllIlIlIlIIlllIIllllIIIl, final EnumFacing lllllllllllIlIlIlIIlllIIllllIIII) {
            final StructureBoundingBox lllllllllllIlIlIlIIlllIIllllIlIl = new StructureBoundingBox(lllllllllllIlIlIlIIlllIIlllllIIl, lllllllllllIlIlIlIIlllIIllllIIlI - 5, lllllllllllIlIlIlIIlllIIllllIIIl, lllllllllllIlIlIlIIlllIIlllllIIl, lllllllllllIlIlIlIIlllIIllllIIlI + 2, lllllllllllIlIlIlIIlllIIllllIIIl);
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIlIlIIlllIIllllIIII.ordinal()]) {
                default: {
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxX = lllllllllllIlIlIlIIlllIIlllllIIl + 2;
                    lllllllllllIlIlIlIIlllIIllllIlIl.minZ = lllllllllllIlIlIlIIlllIIllllIIIl - 8;
                    break;
                }
                case 4: {
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxX = lllllllllllIlIlIlIIlllIIlllllIIl + 2;
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxZ = lllllllllllIlIlIlIIlllIIllllIIIl + 8;
                    break;
                }
                case 5: {
                    lllllllllllIlIlIlIIlllIIllllIlIl.minX = lllllllllllIlIlIlIIlllIIlllllIIl - 8;
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxZ = lllllllllllIlIlIlIIlllIIllllIIIl + 2;
                    break;
                }
                case 6: {
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxX = lllllllllllIlIlIlIIlllIIlllllIIl + 8;
                    lllllllllllIlIlIlIIlllIIllllIlIl.maxZ = lllllllllllIlIlIlIIlllIIllllIIIl + 2;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(lllllllllllIlIlIlIIlllIIllllIlII, lllllllllllIlIlIlIIlllIIllllIlIl) != null) ? null : lllllllllllIlIlIlIIlllIIllllIlIl;
        }
        
        public Stairs(final int lllllllllllIlIlIlIIlllIlIIIIIlIl, final Random lllllllllllIlIlIlIIlllIlIIIIlIlI, final StructureBoundingBox lllllllllllIlIlIlIIlllIlIIIIlIIl, final EnumFacing lllllllllllIlIlIlIIlllIlIIIIIIll, final MapGenMineshaft.Type lllllllllllIlIlIlIIlllIlIIIIIlll) {
            super(lllllllllllIlIlIlIIlllIlIIIIIlIl, lllllllllllIlIlIlIIlllIlIIIIIlll);
            this.setCoordBaseMode(lllllllllllIlIlIlIIlllIlIIIIIIll);
            this.boundingBox = lllllllllllIlIlIlIIlllIlIIIIlIIl;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Stairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final String lllllllllllIlIlIlIIlllIIllIIlllI = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllIlIlIlIIlllIIllIIlllI[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Stairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIlIlIIlllIIllIIlllI;
        }
        
        public Stairs() {
        }
    }
    
    public static class Cross extends Peice
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        private /* synthetic */ boolean isMultipleFloors;
        private /* synthetic */ EnumFacing corridorDirection;
        
        public static StructureBoundingBox findCrossing(final List<StructureComponent> llllllllllllIIllllllIlIlllIIllIl, final Random llllllllllllIIllllllIlIlllIlIIll, final int llllllllllllIIllllllIlIlllIIlIll, final int llllllllllllIIllllllIlIlllIIlIlI, final int llllllllllllIIllllllIlIlllIlIIII, final EnumFacing llllllllllllIIllllllIlIlllIIlIII) {
            final StructureBoundingBox llllllllllllIIllllllIlIlllIIlllI = new StructureBoundingBox(llllllllllllIIllllllIlIlllIIlIll, llllllllllllIIllllllIlIlllIIlIlI, llllllllllllIIllllllIlIlllIlIIII, llllllllllllIIllllllIlIlllIIlIll, llllllllllllIIllllllIlIlllIIlIlI + 2, llllllllllllIIllllllIlIlllIlIIII);
            if (llllllllllllIIllllllIlIlllIlIIll.nextInt(4) == 0) {
                final StructureBoundingBox structureBoundingBox = llllllllllllIIllllllIlIlllIIlllI;
                structureBoundingBox.maxY += 4;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIllllllIlIlllIIlIII.ordinal()]) {
                default: {
                    llllllllllllIIllllllIlIlllIIlllI.minX = llllllllllllIIllllllIlIlllIIlIll - 1;
                    llllllllllllIIllllllIlIlllIIlllI.maxX = llllllllllllIIllllllIlIlllIIlIll + 3;
                    llllllllllllIIllllllIlIlllIIlllI.minZ = llllllllllllIIllllllIlIlllIlIIII - 4;
                    break;
                }
                case 4: {
                    llllllllllllIIllllllIlIlllIIlllI.minX = llllllllllllIIllllllIlIlllIIlIll - 1;
                    llllllllllllIIllllllIlIlllIIlllI.maxX = llllllllllllIIllllllIlIlllIIlIll + 3;
                    llllllllllllIIllllllIlIlllIIlllI.maxZ = llllllllllllIIllllllIlIlllIlIIII + 3 + 1;
                    break;
                }
                case 5: {
                    llllllllllllIIllllllIlIlllIIlllI.minX = llllllllllllIIllllllIlIlllIIlIll - 4;
                    llllllllllllIIllllllIlIlllIIlllI.minZ = llllllllllllIIllllllIlIlllIlIIII - 1;
                    llllllllllllIIllllllIlIlllIIlllI.maxZ = llllllllllllIIllllllIlIlllIlIIII + 3;
                    break;
                }
                case 6: {
                    llllllllllllIIllllllIlIlllIIlllI.maxX = llllllllllllIIllllllIlIlllIIlIll + 3 + 1;
                    llllllllllllIIllllllIlIlllIIlllI.minZ = llllllllllllIIllllllIlIlllIlIIII - 1;
                    llllllllllllIIllllllIlIlllIIlllI.maxZ = llllllllllllIIllllllIlIlllIlIIII + 3;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(llllllllllllIIllllllIlIlllIIllIl, llllllllllllIIllllllIlIlllIIlllI) != null) ? null : llllllllllllIIllllllIlIlllIIlllI;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllIIllllllIlIllIllIIII, final Random llllllllllllIIllllllIlIllIlIllll, final StructureBoundingBox llllllllllllIIllllllIlIllIlIlllI) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI)) {
                return false;
            }
            final IBlockState llllllllllllIIllllllIlIllIlIllIl = this.func_189917_F_();
            if (this.isMultipleFloors) {
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.func_189923_b(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIlllI, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);
            for (int llllllllllllIIllllllIlIllIlIllII = this.boundingBox.minX; llllllllllllIIllllllIlIllIlIllII <= this.boundingBox.maxX; ++llllllllllllIIllllllIlIllIlIllII) {
                for (int llllllllllllIIllllllIlIllIlIlIll = this.boundingBox.minZ; llllllllllllIIllllllIlIllIlIlIll <= this.boundingBox.maxZ; ++llllllllllllIIllllllIlIllIlIlIll) {
                    if (this.getBlockStateFromPos(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIllII, this.boundingBox.minY - 1, llllllllllllIIllllllIlIllIlIlIll, llllllllllllIIllllllIlIllIlIlllI).getMaterial() == Material.AIR && this.func_189916_b(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIllII, this.boundingBox.minY - 1, llllllllllllIIllllllIlIllIlIlIll, llllllllllllIIllllllIlIllIlIlllI) < 8) {
                        this.setBlockState(llllllllllllIIllllllIlIllIllIIII, llllllllllllIIllllllIlIllIlIllIl, llllllllllllIIllllllIlIllIlIllII, this.boundingBox.minY - 1, llllllllllllIIllllllIlIllIlIlIll, llllllllllllIIllllllIlIllIlIlllI);
                    }
                }
            }
            return true;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Cross.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final byte llllllllllllIIllllllIlIllIIIlllI = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllIIllllllIlIllIIIlllI[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Cross.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIIllllllIlIllIIIlllI;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllIIllllllIlIlllIIIIII, final List<StructureComponent> llllllllllllIIllllllIlIllIlllIlI, final Random llllllllllllIIllllllIlIllIlllllI) {
            final int llllllllllllIIllllllIlIllIllllIl = this.getComponentType();
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.corridorDirection.ordinal()]) {
                default: {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllIIllllllIlIllIllllIl);
                    break;
                }
                case 4: {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllIIllllllIlIllIllllIl);
                    break;
                }
                case 5: {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllIIllllllIlIllIllllIl);
                    break;
                }
                case 6: {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllIIllllllIlIllIllllIl);
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllIIllllllIlIllIllllIl);
                    break;
                }
            }
            if (this.isMultipleFloors) {
                if (llllllllllllIIllllllIlIllIlllllI.nextBoolean()) {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllIIllllllIlIllIllllIl);
                }
                if (llllllllllllIIllllllIlIllIlllllI.nextBoolean()) {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllIIllllllIlIllIllllIl);
                }
                if (llllllllllllIIllllllIlIllIlllllI.nextBoolean()) {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllIIllllllIlIllIllllIl);
                }
                if (llllllllllllIIllllllIlIllIlllllI.nextBoolean()) {
                    func_189938_b(llllllllllllIIllllllIlIlllIIIIII, llllllllllllIIllllllIlIllIlllIlI, llllllllllllIIllllllIlIllIlllllI, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllIIllllllIlIllIllllIl);
                }
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIIllllllIlIllllIllIl, final TemplateManager llllllllllllIIllllllIlIllllIllll) {
            super.readStructureFromNBT(llllllllllllIIllllllIlIllllIllIl, llllllllllllIIllllllIlIllllIllll);
            this.isMultipleFloors = llllllllllllIIllllllIlIllllIllIl.getBoolean("tf");
            this.corridorDirection = EnumFacing.getHorizontal(llllllllllllIIllllllIlIllllIllIl.getInteger("D"));
        }
        
        private void func_189923_b(final World llllllllllllIIllllllIlIllIIlIlIl, final StructureBoundingBox llllllllllllIIllllllIlIllIIlIlII, final int llllllllllllIIllllllIlIllIIlIIll, final int llllllllllllIIllllllIlIllIIllIIl, final int llllllllllllIIllllllIlIllIIllIII, final int llllllllllllIIllllllIlIllIIlIIII) {
            if (this.getBlockStateFromPos(llllllllllllIIllllllIlIllIIlIlIl, llllllllllllIIllllllIlIllIIlIIll, llllllllllllIIllllllIlIllIIlIIII + 1, llllllllllllIIllllllIlIllIIllIII, llllllllllllIIllllllIlIllIIlIlII).getMaterial() != Material.AIR) {
                this.fillWithBlocks(llllllllllllIIllllllIlIllIIlIlIl, llllllllllllIIllllllIlIllIIlIlII, llllllllllllIIllllllIlIllIIlIIll, llllllllllllIIllllllIlIllIIllIIl, llllllllllllIIllllllIlIllIIllIII, llllllllllllIIllllllIlIllIIlIIll, llllllllllllIIllllllIlIllIIlIIII, llllllllllllIIllllllIlIllIIllIII, this.func_189917_F_(), Blocks.AIR.getDefaultState(), false);
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIIllllllIlIlllllIlIl) {
            super.writeStructureToNBT(llllllllllllIIllllllIlIlllllIlIl);
            llllllllllllIIllllllIlIlllllIlIl.setBoolean("tf", this.isMultipleFloors);
            llllllllllllIIllllllIlIlllllIlIl.setInteger("D", this.corridorDirection.getHorizontalIndex());
        }
        
        public Cross(final int llllllllllllIIllllllIlIlllIlllll, final Random llllllllllllIIllllllIlIllllIIlII, final StructureBoundingBox llllllllllllIIllllllIlIllllIIIll, @Nullable final EnumFacing llllllllllllIIllllllIlIllllIIIlI, final MapGenMineshaft.Type llllllllllllIIllllllIlIllllIIIIl) {
            super(llllllllllllIIllllllIlIlllIlllll, llllllllllllIIllllllIlIllllIIIIl);
            this.corridorDirection = llllllllllllIIllllllIlIllllIIIlI;
            this.boundingBox = llllllllllllIIllllllIlIllllIIIll;
            this.isMultipleFloors = (llllllllllllIIllllllIlIllllIIIll.getYSize() > 3);
        }
        
        public Cross() {
        }
    }
}
