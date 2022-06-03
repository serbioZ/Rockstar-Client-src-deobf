// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockPlanks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.tileentity.TileEntityChest;
import java.util.Map;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockTripWireHook;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockSandStone;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentScatteredFeaturePieces
{
    public static void registerScatteredFeaturePieces() {
        MapGenStructureIO.registerStructureComponent(DesertPyramid.class, "TeDP");
        MapGenStructureIO.registerStructureComponent(JunglePyramid.class, "TeJP");
        MapGenStructureIO.registerStructureComponent(SwampHut.class, "TeSH");
        MapGenStructureIO.registerStructureComponent(Igloo.class, "Iglu");
    }
    
    public static class DesertPyramid extends Feature
    {
        private final /* synthetic */ boolean[] hasPlacedChest;
        
        public DesertPyramid() {
            this.hasPlacedChest = new boolean[4];
        }
        
        public DesertPyramid(final Random lllllllllllIlllIllIllIlIlIIIIIIl, final int lllllllllllIlllIllIllIlIlIIIIlII, final int lllllllllllIlllIllIllIlIIlllllll) {
            super(lllllllllllIlllIllIllIlIlIIIIIIl, lllllllllllIlllIllIllIlIlIIIIlII, 64, lllllllllllIlllIllIllIlIIlllllll, 21, 15, 21);
            this.hasPlacedChest = new boolean[4];
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllIlllIllIllIlIIlIIllII, final Random lllllllllllIlllIllIllIlIIlIIlIll, final StructureBoundingBox lllllllllllIlllIllIllIlIIlIIlIlI) {
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            for (int lllllllllllIlllIllIllIlIIlIlllIl = 1; lllllllllllIlllIllIllIlIIlIlllIl <= 9; ++lllllllllllIlllIllIllIlIIlIlllIl) {
                this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, lllllllllllIlllIllIllIlIIlIlllIl, lllllllllllIlllIllIllIlIIlIlllIl, lllllllllllIlllIllIllIlIIlIlllIl, this.scatteredFeatureSizeX - 1 - lllllllllllIlllIllIllIlIIlIlllIl, lllllllllllIlllIllIllIlIIlIlllIl, this.scatteredFeatureSizeZ - 1 - lllllllllllIlllIllIllIlIIlIlllIl, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, lllllllllllIlllIllIllIlIIlIlllIl + 1, lllllllllllIlllIllIllIlIIlIlllIl, lllllllllllIlllIllIllIlIIlIlllIl + 1, this.scatteredFeatureSizeX - 2 - lllllllllllIlllIllIllIlIIlIlllIl, lllllllllllIlllIllIllIlIIlIlllIl, this.scatteredFeatureSizeZ - 2 - lllllllllllIlllIllIllIlIIlIlllIl, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            for (int lllllllllllIlllIllIllIlIIlIlllII = 0; lllllllllllIlllIllIllIlIIlIlllII < this.scatteredFeatureSizeX; ++lllllllllllIlllIllIllIlIIlIlllII) {
                for (int lllllllllllIlllIllIllIlIIlIllIll = 0; lllllllllllIlllIllIllIlIIlIllIll < this.scatteredFeatureSizeZ; ++lllllllllllIlllIllIllIlIIlIllIll) {
                    final int lllllllllllIlllIllIllIlIIlIllIlI = -5;
                    this.replaceAirAndLiquidDownwards(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getDefaultState(), lllllllllllIlllIllIllIlIIlIlllII, -5, lllllllllllIlllIllIllIlIIlIllIll, lllllllllllIlllIllIllIlIIlIIlIlI);
                }
            }
            final IBlockState lllllllllllIlllIllIllIlIIlIllIIl = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            final IBlockState lllllllllllIlllIllIllIlIIlIllIII = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            final IBlockState lllllllllllIlllIllIllIlIIlIlIlll = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllIlllIllIllIlIIlIlIllI = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final int lllllllllllIlllIllIllIlIIlIlIlIl = ~EnumDyeColor.ORANGE.getDyeDamage() & 0xF;
            final int lllllllllllIlllIllIllIlIIlIlIlII = ~EnumDyeColor.BLUE.getDyeDamage() & 0xF;
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, 2, 10, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIII, 2, 10, 4, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIlll, 0, 10, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIllI, 4, 10, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 5, 0, 0, this.scatteredFeatureSizeX - 1, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 4, 10, 1, this.scatteredFeatureSizeX - 2, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, this.scatteredFeatureSizeX - 3, 10, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIII, this.scatteredFeatureSizeX - 3, 10, 4, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIlll, this.scatteredFeatureSizeX - 5, 10, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIllI, this.scatteredFeatureSizeX - 1, 10, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 9, 1, 0, 11, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 1, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 2, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 3, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, 3, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 3, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 2, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 1, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 4, 1, 2, 8, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 12, 1, 2, 16, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 5, 4, 5, this.scatteredFeatureSizeX - 6, 4, this.scatteredFeatureSizeZ - 6, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 9, 4, 9, 11, 4, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, 1, 8, 8, 3, 8, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 12, 1, 8, 12, 3, 8, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, 1, 12, 8, 3, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 12, 1, 12, 12, 3, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 5, 1, 5, this.scatteredFeatureSizeX - 2, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 7, 7, 9, this.scatteredFeatureSizeX - 7, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 5, 5, 9, 5, 7, 11, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 6, 5, 9, this.scatteredFeatureSizeX - 6, 7, 11, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 5, 5, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 5, 6, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 6, 6, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 6, 5, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 6, 6, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 7, 6, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 2, 4, 4, 2, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 3, 4, 4, this.scatteredFeatureSizeX - 3, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, 2, 4, 5, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, 2, 3, 4, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, this.scatteredFeatureSizeX - 3, 4, 5, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIllIIl, this.scatteredFeatureSizeX - 3, 3, 4, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 3, 1, 3, this.scatteredFeatureSizeX - 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getDefaultState(), 1, 1, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getDefaultState(), this.scatteredFeatureSizeX - 2, 1, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), 1, 2, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), this.scatteredFeatureSizeX - 2, 2, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIllI, 2, 1, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIlIlll, this.scatteredFeatureSizeX - 3, 1, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 4, 3, 5, 4, 3, 18, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 5, 3, 5, this.scatteredFeatureSizeX - 5, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 3, 1, 5, 4, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, this.scatteredFeatureSizeX - 6, 1, 5, this.scatteredFeatureSizeX - 5, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (int lllllllllllIlllIllIllIlIIlIlIIll = 5; lllllllllllIlllIllIllIlIIlIlIIll <= 17; lllllllllllIlllIllIllIlIIlIlIIll += 2) {
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 4, 1, lllllllllllIlllIllIllIlIIlIlIIll, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 4, 2, lllllllllllIlllIllIllIlIIlIlIIll, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), this.scatteredFeatureSizeX - 5, 1, lllllllllllIlllIllIllIlIIlIlIIll, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), this.scatteredFeatureSizeX - 5, 2, lllllllllllIlllIllIllIlIIlIlIIll, lllllllllllIlllIllIllIlIIlIIlIlI);
            }
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 10, 0, 7, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 10, 0, 8, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 9, 0, 9, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 11, 0, 9, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 8, 0, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 12, 0, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 7, 0, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 13, 0, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 9, 0, 11, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 11, 0, 11, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 10, 0, 12, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 10, 0, 13, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlII), 10, 0, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            for (int lllllllllllIlllIllIllIlIIlIlIIlI = 0; lllllllllllIlllIllIllIlIIlIlIIlI <= this.scatteredFeatureSizeX - 1; lllllllllllIlllIllIllIlIIlIlIIlI += this.scatteredFeatureSizeX - 1) {
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 2, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 2, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 2, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 3, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 3, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 3, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 4, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 4, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 4, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 5, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 5, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 5, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 6, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 6, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 6, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 7, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 7, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIlI, 7, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 8, 1, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 8, 2, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIlI, 8, 3, lllllllllllIlllIllIllIlIIlIIlIlI);
            }
            for (int lllllllllllIlllIllIllIlIIlIlIIIl = 2; lllllllllllIlllIllIllIlIIlIlIIIl <= this.scatteredFeatureSizeX - 3; lllllllllllIlllIllIllIlIIlIlIIIl += this.scatteredFeatureSizeX - 3 - 2) {
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 2, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl, 2, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 2, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 3, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl, 3, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 3, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 4, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl, 4, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 4, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 6, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl, 6, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 6, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 7, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl, 7, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 7, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl - 1, 8, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl, 8, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
                this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllIlllIllIllIlIIlIlIIIl + 1, 8, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            }
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, 4, 0, 12, 6, 0, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 8, 6, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 12, 6, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 9, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllIlllIllIllIlIIlIlIlIl), 11, 5, 0, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, -14, 8, 12, -11, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, -10, 8, 12, -10, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, -9, 8, 12, -9, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 9, -11, 9, 11, -1, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.STONE_PRESSURE_PLATE.getDefaultState(), 10, -11, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.fillWithBlocks(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, 9, -13, 9, 11, -13, 11, Blocks.TNT.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 8, -11, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 8, -10, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 7, -10, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 7, -11, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 12, -11, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 12, -10, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 13, -10, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 13, -11, 10, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 10, -11, 8, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 10, -10, 8, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 7, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 7, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 10, -11, 12, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.AIR.getDefaultState(), 10, -10, 12, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 13, lllllllllllIlllIllIllIlIIlIIlIlI);
            this.setBlockState(lllllllllllIlllIllIllIlIIlIIllII, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 13, lllllllllllIlllIllIllIlIIlIIlIlI);
            for (final EnumFacing lllllllllllIlllIllIllIlIIlIlIIII : EnumFacing.Plane.HORIZONTAL) {
                if (!this.hasPlacedChest[lllllllllllIlllIllIllIlIIlIlIIII.getHorizontalIndex()]) {
                    final int lllllllllllIlllIllIllIlIIlIIllll = lllllllllllIlllIllIllIlIIlIlIIII.getFrontOffsetX() * 2;
                    final int lllllllllllIlllIllIllIlIIlIIlllI = lllllllllllIlllIllIllIlIIlIlIIII.getFrontOffsetZ() * 2;
                    this.hasPlacedChest[lllllllllllIlllIllIllIlIIlIlIIII.getHorizontalIndex()] = this.generateChest(lllllllllllIlllIllIllIlIIlIIllII, lllllllllllIlllIllIllIlIIlIIlIlI, lllllllllllIlllIllIllIlIIlIIlIll, 10 + lllllllllllIlllIllIllIlIIlIIllll, -11, 10 + lllllllllllIlllIllIllIlIIlIIlllI, LootTableList.CHESTS_DESERT_PYRAMID);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIlllIllIllIlIIlllIIIl, final TemplateManager lllllllllllIlllIllIllIlIIlllIIll) {
            super.readStructureFromNBT(lllllllllllIlllIllIllIlIIlllIIIl, lllllllllllIlllIllIllIlIIlllIIll);
            this.hasPlacedChest[0] = lllllllllllIlllIllIllIlIIlllIIIl.getBoolean("hasPlacedChest0");
            this.hasPlacedChest[1] = lllllllllllIlllIllIllIlIIlllIIIl.getBoolean("hasPlacedChest1");
            this.hasPlacedChest[2] = lllllllllllIlllIllIllIlIIlllIIIl.getBoolean("hasPlacedChest2");
            this.hasPlacedChest[3] = lllllllllllIlllIllIllIlIIlllIIIl.getBoolean("hasPlacedChest3");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIlllIllIllIlIIllllIll) {
            super.writeStructureToNBT(lllllllllllIlllIllIllIlIIllllIll);
            lllllllllllIlllIllIllIlIIllllIll.setBoolean("hasPlacedChest0", this.hasPlacedChest[0]);
            lllllllllllIlllIllIllIlIIllllIll.setBoolean("hasPlacedChest1", this.hasPlacedChest[1]);
            lllllllllllIlllIllIllIlIIllllIll.setBoolean("hasPlacedChest2", this.hasPlacedChest[2]);
            lllllllllllIlllIllIllIlIIllllIll.setBoolean("hasPlacedChest3", this.hasPlacedChest[3]);
        }
    }
    
    abstract static class Feature extends StructureComponent
    {
        protected /* synthetic */ int scatteredFeatureSizeX;
        protected /* synthetic */ int scatteredFeatureSizeY;
        protected /* synthetic */ int horizontalPos;
        protected /* synthetic */ int scatteredFeatureSizeZ;
        
        public Feature() {
            this.horizontalPos = -1;
        }
        
        protected Feature(final Random lllllllllllIIIllllIlIllIIIIIIlll, final int lllllllllllIIIllllIlIllIIIIIlllI, final int lllllllllllIIIllllIlIllIIIIIIlIl, final int lllllllllllIIIllllIlIllIIIIIIlII, final int lllllllllllIIIllllIlIllIIIIIlIll, final int lllllllllllIIIllllIlIllIIIIIIIlI, final int lllllllllllIIIllllIlIllIIIIIlIIl) {
            super(0);
            this.horizontalPos = -1;
            this.scatteredFeatureSizeX = lllllllllllIIIllllIlIllIIIIIlIll;
            this.scatteredFeatureSizeY = lllllllllllIIIllllIlIllIIIIIIIlI;
            this.scatteredFeatureSizeZ = lllllllllllIIIllllIlIllIIIIIlIIl;
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIIllllIlIllIIIIIIlll));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllIIIllllIlIllIIIIIlllI, lllllllllllIIIllllIlIllIIIIIIlIl, lllllllllllIIIllllIlIllIIIIIIlII, lllllllllllIIIllllIlIllIIIIIlllI + lllllllllllIIIllllIlIllIIIIIlIll - 1, lllllllllllIIIllllIlIllIIIIIIlIl + lllllllllllIIIllllIlIllIIIIIIIlI - 1, lllllllllllIIIllllIlIllIIIIIIlII + lllllllllllIIIllllIlIllIIIIIlIIl - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllIIIllllIlIllIIIIIlllI, lllllllllllIIIllllIlIllIIIIIIlIl, lllllllllllIIIllllIlIllIIIIIIlII, lllllllllllIIIllllIlIllIIIIIlllI + lllllllllllIIIllllIlIllIIIIIlIIl - 1, lllllllllllIIIllllIlIllIIIIIIlIl + lllllllllllIIIllllIlIllIIIIIIIlI - 1, lllllllllllIIIllllIlIllIIIIIIlII + lllllllllllIIIllllIlIllIIIIIlIll - 1);
            }
        }
        
        protected boolean offsetToAverageGroundLevel(final World lllllllllllIIIllllIlIlIllllIlIIl, final StructureBoundingBox lllllllllllIIIllllIlIlIlllIlllll, final int lllllllllllIIIllllIlIlIllllIIlll) {
            if (this.horizontalPos >= 0) {
                return true;
            }
            int lllllllllllIIIllllIlIlIllllIIllI = 0;
            int lllllllllllIIIllllIlIlIllllIIlIl = 0;
            final BlockPos.MutableBlockPos lllllllllllIIIllllIlIlIllllIIlII = new BlockPos.MutableBlockPos();
            for (int lllllllllllIIIllllIlIlIllllIIIll = this.boundingBox.minZ; lllllllllllIIIllllIlIlIllllIIIll <= this.boundingBox.maxZ; ++lllllllllllIIIllllIlIlIllllIIIll) {
                for (int lllllllllllIIIllllIlIlIllllIIIlI = this.boundingBox.minX; lllllllllllIIIllllIlIlIllllIIIlI <= this.boundingBox.maxX; ++lllllllllllIIIllllIlIlIllllIIIlI) {
                    lllllllllllIIIllllIlIlIllllIIlII.setPos(lllllllllllIIIllllIlIlIllllIIIlI, 64, lllllllllllIIIllllIlIlIllllIIIll);
                    if (lllllllllllIIIllllIlIlIlllIlllll.isVecInside(lllllllllllIIIllllIlIlIllllIIlII)) {
                        lllllllllllIIIllllIlIlIllllIIllI += Math.max(lllllllllllIIIllllIlIlIllllIlIIl.getTopSolidOrLiquidBlock(lllllllllllIIIllllIlIlIllllIIlII).getY(), lllllllllllIIIllllIlIlIllllIlIIl.provider.getAverageGroundLevel());
                        ++lllllllllllIIIllllIlIlIllllIIlIl;
                    }
                }
            }
            if (lllllllllllIIIllllIlIlIllllIIlIl == 0) {
                return false;
            }
            this.horizontalPos = lllllllllllIIIllllIlIlIllllIIllI / lllllllllllIIIllllIlIlIllllIIlIl;
            this.boundingBox.offset(0, this.horizontalPos - this.boundingBox.minY + lllllllllllIIIllllIlIlIllllIIlll, 0);
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllIIIllllIlIlIlllllllIl) {
            lllllllllllIIIllllIlIlIlllllllIl.setInteger("Width", this.scatteredFeatureSizeX);
            lllllllllllIIIllllIlIlIlllllllIl.setInteger("Height", this.scatteredFeatureSizeY);
            lllllllllllIIIllllIlIlIlllllllIl.setInteger("Depth", this.scatteredFeatureSizeZ);
            lllllllllllIIIllllIlIlIlllllllIl.setInteger("HPos", this.horizontalPos);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllIIIllllIlIlIlllllIlII, final TemplateManager lllllllllllIIIllllIlIlIlllllIllI) {
            this.scatteredFeatureSizeX = lllllllllllIIIllllIlIlIlllllIlII.getInteger("Width");
            this.scatteredFeatureSizeY = lllllllllllIIIllllIlIlIlllllIlII.getInteger("Height");
            this.scatteredFeatureSizeZ = lllllllllllIIIllllIlIlIlllllIlII.getInteger("Depth");
            this.horizontalPos = lllllllllllIIIllllIlIlIlllllIlII.getInteger("HPos");
        }
    }
    
    public static class JunglePyramid extends Feature
    {
        private /* synthetic */ boolean placedTrap1;
        private /* synthetic */ boolean placedHiddenChest;
        private /* synthetic */ boolean placedMainChest;
        private /* synthetic */ boolean placedTrap2;
        private static final /* synthetic */ Stones junglePyramidsRandomScatteredStones;
        
        public JunglePyramid(final Random llllllllllIlllIlllIIIllIlllIllII, final int llllllllllIlllIlllIIIllIlllIllll, final int llllllllllIlllIlllIIIllIlllIlllI) {
            super(llllllllllIlllIlllIIIllIlllIllII, llllllllllIlllIlllIIIllIlllIllll, 64, llllllllllIlllIlllIIIllIlllIlllI, 12, 10, 15);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIlllIIIllIllIlIIII, final Random llllllllllIlllIlllIIIllIllIIIIII, final StructureBoundingBox llllllllllIlllIlllIIIllIllIIlllI) {
            if (!this.offsetToAverageGroundLevel(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 0)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 1, 2, 9, 2, 2, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 1, 12, 9, 2, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 1, 3, 2, 2, 11, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 9, 1, 3, 9, 2, 11, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, 3, 1, 10, 6, 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, 3, 13, 10, 6, 13, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, 3, 2, 1, 6, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 10, 3, 2, 10, 6, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 3, 2, 9, 3, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 6, 2, 9, 6, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 3, 7, 3, 8, 7, 11, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 8, 4, 7, 8, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 3, 1, 3, 8, 2, 11);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 3, 6, 7, 3, 9);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 4, 2, 9, 5, 12);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 6, 5, 7, 6, 9);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 7, 6, 6, 7, 8);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 1, 2, 6, 2, 2);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 2, 12, 6, 2, 12);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 5, 1, 6, 5, 1);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 5, 13, 6, 5, 13);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.AIR.getDefaultState(), 1, 5, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.AIR.getDefaultState(), 10, 5, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.AIR.getDefaultState(), 1, 5, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.AIR.getDefaultState(), 10, 5, 9, llllllllllIlllIlllIIIllIllIIlllI);
            for (int llllllllllIlllIlllIIIllIllIIllIl = 0; llllllllllIlllIlllIIIllIllIIllIl <= 14; llllllllllIlllIlllIIIllIllIIllIl += 14) {
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 4, llllllllllIlllIlllIIIllIllIIllIl, 2, 5, llllllllllIlllIlllIIIllIllIIllIl, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 4, llllllllllIlllIlllIIIllIllIIllIl, 4, 5, llllllllllIlllIlllIIIllIllIIllIl, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 7, 4, llllllllllIlllIlllIIIllIllIIllIl, 7, 5, llllllllllIlllIlllIIIllIllIIllIl, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 9, 4, llllllllllIlllIlllIIIllIllIIllIl, 9, 5, llllllllllIlllIlllIIIllIllIIllIl, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 6, 0, 6, 6, 0, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            for (int llllllllllIlllIlllIIIllIllIIllII = 0; llllllllllIlllIlllIIIllIllIIllII <= 11; llllllllllIlllIlllIIIllIllIIllII += 11) {
                for (int llllllllllIlllIlllIIIllIllIIlIll = 2; llllllllllIlllIlllIIIllIllIIlIll <= 12; llllllllllIlllIlllIIIllIllIIlIll += 2) {
                    this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIllII, 4, llllllllllIlllIlllIIIllIllIIlIll, llllllllllIlllIlllIIIllIllIIllII, 5, llllllllllIlllIlllIIIllIllIIlIll, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
                }
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIllII, 6, 5, llllllllllIlllIlllIIIllIllIIllII, 6, 5, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIllII, 6, 9, llllllllllIlllIlllIIIllIllIIllII, 6, 9, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 7, 2, 2, 9, 2, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 9, 7, 2, 9, 9, 2, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, 7, 12, 2, 9, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 9, 7, 12, 9, 9, 12, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 9, 4, 4, 9, 4, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 7, 9, 4, 7, 9, 4, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 9, 10, 4, 9, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 7, 9, 10, 7, 9, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 9, 7, 6, 9, 7, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            final IBlockState llllllllllIlllIlllIIIllIllIIlIlI = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState llllllllllIlllIlllIIIllIllIIlIIl = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final IBlockState llllllllllIlllIlllIIIllIllIIlIII = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            final IBlockState llllllllllIlllIlllIIIllIllIIIlll = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 5, 9, 6, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 6, 9, 6, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIII, 5, 9, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIII, 6, 9, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 4, 0, 0, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 5, 0, 0, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 6, 0, 0, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 7, 0, 0, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 4, 1, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 4, 2, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 4, 3, 10, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 7, 1, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 7, 2, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIlll, 7, 3, 10, llllllllllIlllIlllIIIllIllIIlllI);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 1, 9, 4, 1, 9, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 7, 1, 9, 7, 1, 9, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 4, 1, 10, 7, 2, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 4, 5, 6, 4, 5, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIlI, 4, 4, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIIl, 7, 4, 5, llllllllllIlllIlllIIIllIllIIlllI);
            for (int llllllllllIlllIlllIIIllIllIIIllI = 0; llllllllllIlllIlllIIIllIllIIIllI < 4; ++llllllllllIlllIlllIIIllIllIIIllI) {
                this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIII, 5, 0 - llllllllllIlllIlllIIIllIllIIIllI, 6 + llllllllllIlllIlllIIIllIllIIIllI, llllllllllIlllIlllIIIllIllIIlllI);
                this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlIII, 6, 0 - llllllllllIlllIlllIIIllIllIIIllI, 6 + llllllllllIlllIlllIIIllIllIIIllI, llllllllllIlllIlllIIIllIllIIlllI);
                this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 5, 0 - llllllllllIlllIlllIIIllIllIIIllI, 7 + llllllllllIlllIlllIIIllIllIIIllI, 6, 0 - llllllllllIlllIlllIIIllIllIIIllI, 9 + llllllllllIlllIlllIIIllIllIIIllI);
            }
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, -3, 12, 10, -1, 13);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, -3, 1, 3, -1, 13);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, -3, 1, 9, -1, 5);
            for (int llllllllllIlllIlllIIIllIllIIIlIl = 1; llllllllllIlllIlllIIIllIllIIIlIl <= 13; llllllllllIlllIlllIIIllIllIIIlIl += 2) {
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, -3, llllllllllIlllIlllIIIllIllIIIlIl, 1, -2, llllllllllIlllIlllIIIllIllIIIlIl, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            for (int llllllllllIlllIlllIIIllIllIIIlII = 2; llllllllllIlllIlllIIIllIllIIIlII <= 12; llllllllllIlllIlllIIIllIllIIIlII += 2) {
                this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 1, -1, llllllllllIlllIlllIIIllIllIIIlII, 3, -1, llllllllllIlllIlllIIIllIllIIIlII, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 2, -2, 1, 5, -2, 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 7, -2, 1, 9, -2, 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 6, -3, 1, 6, -3, 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 6, -1, 1, 6, -1, 1, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.EAST).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 1, -3, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.WEST).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 4, -3, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 2, -3, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 3, -3, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 7, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 6, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 4, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 3, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 2, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 1, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 4, -3, 1, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3, -3, 1, llllllllllIlllIlllIIIllIllIIlllI);
            if (!this.placedTrap1) {
                this.placedTrap1 = this.createDispenser(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIIIII, 3, -2, 1, EnumFacing.NORTH, LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER);
            }
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.SOUTH, true), 3, -2, 2, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 7, -3, 1, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 7, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 2, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 3, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 4, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -3, 6, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -3, 6, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 4, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -2, 4, llllllllllIlllIlllIIIllIllIIlllI);
            if (!this.placedTrap2) {
                this.placedTrap2 = this.createDispenser(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIIIII, 9, -2, 3, EnumFacing.WEST, LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER);
            }
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.EAST, true), 8, -1, 3, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.EAST, true), 8, -2, 3, llllllllllIlllIlllIIIllIllIIlllI);
            if (!this.placedMainChest) {
                this.placedMainChest = this.generateChest(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIIIII, 8, -3, 3, LootTableList.CHESTS_JUNGLE_TEMPLE);
            }
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 2, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 1, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 4, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -2, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -1, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 6, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -2, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -1, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 5, llllllllllIlllIlllIIIllIllIIlllI);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 9, -1, 1, 9, -1, 5, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 8, -3, 8, 10, -1, 10);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 8, -2, 11, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 9, -2, 11, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 10, -2, 11, llllllllllIlllIlllIIIllIllIIlllI);
            final IBlockState llllllllllIlllIlllIIIllIllIIIIll = Blocks.LEVER.getDefaultState().withProperty(BlockLever.FACING, BlockLever.EnumOrientation.NORTH);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIIll, 8, -2, 12, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIIll, 9, -2, 12, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIIIll, 10, -2, 12, llllllllllIlllIlllIIIllIllIIlllI);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 8, -3, 8, 8, -3, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, 10, -3, 8, 10, -3, 10, false, llllllllllIlllIlllIIIllIllIIIIII, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 10, -2, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -2, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -2, 10, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.REDSTONE_WIRE.getDefaultState(), 10, -1, 9, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.UP), 9, -2, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.WEST), 10, -2, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.WEST), 10, -1, 8, llllllllllIlllIlllIIIllIllIIlllI);
            this.setBlockState(llllllllllIlllIlllIIIllIllIlIIII, Blocks.UNPOWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.NORTH), 10, -2, 10, llllllllllIlllIlllIIIllIllIIlllI);
            if (!this.placedHiddenChest) {
                this.placedHiddenChest = this.generateChest(llllllllllIlllIlllIIIllIllIlIIII, llllllllllIlllIlllIIIllIllIIlllI, llllllllllIlllIlllIIIllIllIIIIII, 9, -3, 10, LootTableList.CHESTS_JUNGLE_TEMPLE);
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllIlllIlllIIIllIlllIIllI) {
            super.writeStructureToNBT(llllllllllIlllIlllIIIllIlllIIllI);
            llllllllllIlllIlllIIIllIlllIIllI.setBoolean("placedMainChest", this.placedMainChest);
            llllllllllIlllIlllIIIllIlllIIllI.setBoolean("placedHiddenChest", this.placedHiddenChest);
            llllllllllIlllIlllIIIllIlllIIllI.setBoolean("placedTrap1", this.placedTrap1);
            llllllllllIlllIlllIIIllIlllIIllI.setBoolean("placedTrap2", this.placedTrap2);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllIlllIlllIIIllIllIlllII, final TemplateManager llllllllllIlllIlllIIIllIllIllllI) {
            super.readStructureFromNBT(llllllllllIlllIlllIIIllIllIlllII, llllllllllIlllIlllIIIllIllIllllI);
            this.placedMainChest = llllllllllIlllIlllIIIllIllIlllII.getBoolean("placedMainChest");
            this.placedHiddenChest = llllllllllIlllIlllIIIllIllIlllII.getBoolean("placedHiddenChest");
            this.placedTrap1 = llllllllllIlllIlllIIIllIllIlllII.getBoolean("placedTrap1");
            this.placedTrap2 = llllllllllIlllIlllIIIllIllIlllII.getBoolean("placedTrap2");
        }
        
        static {
            junglePyramidsRandomScatteredStones = new Stones(null);
        }
        
        public JunglePyramid() {
        }
        
        static class Stones extends BlockSelector
        {
            @Override
            public void selectBlocks(final Random llllllllllIllllIIlIIlIIIllIllllI, final int llllllllllIllllIIlIIlIIIllIlllIl, final int llllllllllIllllIIlIIlIIIllIlllII, final int llllllllllIllllIIlIIlIIIllIllIll, final boolean llllllllllIllllIIlIIlIIIllIllIlI) {
                if (llllllllllIllllIIlIIlIIIllIllllI.nextFloat() < 0.4f) {
                    this.blockstate = Blocks.COBBLESTONE.getDefaultState();
                }
                else {
                    this.blockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                }
            }
            
            private Stones() {
            }
        }
    }
    
    public static class Igloo extends Feature
    {
        private static final /* synthetic */ ResourceLocation IGLOO_MIDDLE_ID;
        private static final /* synthetic */ ResourceLocation IGLOO_TOP_ID;
        private static final /* synthetic */ ResourceLocation IGLOO_BOTTOM_ID;
        
        @Override
        public boolean addComponentParts(final World lllllllllllIIlIlllIllIIllllllIII, final Random lllllllllllIIlIlllIllIIlllllIlll, final StructureBoundingBox lllllllllllIIlIlllIllIIllllIIIII) {
            if (!this.offsetToAverageGroundLevel(lllllllllllIIlIlllIllIIllllllIII, lllllllllllIIlIlllIllIIllllIIIII, -1)) {
                return false;
            }
            final StructureBoundingBox lllllllllllIIlIlllIllIIlllllIlIl = this.getBoundingBox();
            final BlockPos lllllllllllIIlIlllIllIIlllllIlII = new BlockPos(lllllllllllIIlIlllIllIIlllllIlIl.minX, lllllllllllIIlIlllIllIIlllllIlIl.minY, lllllllllllIIlIlllIllIIlllllIlIl.minZ);
            final Rotation[] lllllllllllIIlIlllIllIIlllllIIll = Rotation.values();
            final MinecraftServer lllllllllllIIlIlllIllIIlllllIIlI = lllllllllllIIlIlllIllIIllllllIII.getMinecraftServer();
            final TemplateManager lllllllllllIIlIlllIllIIlllllIIIl = lllllllllllIIlIlllIllIIllllllIII.getSaveHandler().getStructureTemplateManager();
            final PlacementSettings lllllllllllIIlIlllIllIIlllllIIII = new PlacementSettings().setRotation(lllllllllllIIlIlllIllIIlllllIIll[lllllllllllIIlIlllIllIIlllllIlll.nextInt(lllllllllllIIlIlllIllIIlllllIIll.length)]).setReplacedBlock(Blocks.STRUCTURE_VOID).setBoundingBox(lllllllllllIIlIlllIllIIlllllIlIl);
            final Template lllllllllllIIlIlllIllIIllllIllll = lllllllllllIIlIlllIllIIlllllIIIl.getTemplate(lllllllllllIIlIlllIllIIlllllIIlI, Igloo.IGLOO_TOP_ID);
            lllllllllllIIlIlllIllIIllllIllll.addBlocksToWorldChunk(lllllllllllIIlIlllIllIIllllllIII, lllllllllllIIlIlllIllIIlllllIlII, lllllllllllIIlIlllIllIIlllllIIII);
            if (lllllllllllIIlIlllIllIIlllllIlll.nextDouble() < 0.5) {
                final Template lllllllllllIIlIlllIllIIllllIlllI = lllllllllllIIlIlllIllIIlllllIIIl.getTemplate(lllllllllllIIlIlllIllIIlllllIIlI, Igloo.IGLOO_MIDDLE_ID);
                final Template lllllllllllIIlIlllIllIIllllIllIl = lllllllllllIIlIlllIllIIlllllIIIl.getTemplate(lllllllllllIIlIlllIllIIlllllIIlI, Igloo.IGLOO_BOTTOM_ID);
                final int lllllllllllIIlIlllIllIIllllIllII = lllllllllllIIlIlllIllIIlllllIlll.nextInt(8) + 4;
                for (int lllllllllllIIlIlllIllIIllllIlIll = 0; lllllllllllIIlIlllIllIIllllIlIll < lllllllllllIIlIlllIllIIllllIllII; ++lllllllllllIIlIlllIllIIllllIlIll) {
                    final BlockPos lllllllllllIIlIlllIllIIllllIlIlI = lllllllllllIIlIlllIllIIllllIllll.calculateConnectedPos(lllllllllllIIlIlllIllIIlllllIIII, new BlockPos(3, -1 - lllllllllllIIlIlllIllIIllllIlIll * 3, 5), lllllllllllIIlIlllIllIIlllllIIII, new BlockPos(1, 2, 1));
                    lllllllllllIIlIlllIllIIllllIlllI.addBlocksToWorldChunk(lllllllllllIIlIlllIllIIllllllIII, lllllllllllIIlIlllIllIIlllllIlII.add(lllllllllllIIlIlllIllIIllllIlIlI), lllllllllllIIlIlllIllIIlllllIIII);
                }
                final BlockPos lllllllllllIIlIlllIllIIllllIlIIl = lllllllllllIIlIlllIllIIlllllIlII.add(lllllllllllIIlIlllIllIIllllIllll.calculateConnectedPos(lllllllllllIIlIlllIllIIlllllIIII, new BlockPos(3, -1 - lllllllllllIIlIlllIllIIllllIllII * 3, 5), lllllllllllIIlIlllIllIIlllllIIII, new BlockPos(3, 5, 7)));
                lllllllllllIIlIlllIllIIllllIllIl.addBlocksToWorldChunk(lllllllllllIIlIlllIllIIllllllIII, lllllllllllIIlIlllIllIIllllIlIIl, lllllllllllIIlIlllIllIIlllllIIII);
                final Map<BlockPos, String> lllllllllllIIlIlllIllIIllllIlIII = lllllllllllIIlIlllIllIIllllIllIl.getDataBlocks(lllllllllllIIlIlllIllIIllllIlIIl, lllllllllllIIlIlllIllIIlllllIIII);
                for (final Map.Entry<BlockPos, String> lllllllllllIIlIlllIllIIllllIIlll : lllllllllllIIlIlllIllIIllllIlIII.entrySet()) {
                    if ("chest".equals(lllllllllllIIlIlllIllIIllllIIlll.getValue())) {
                        final BlockPos lllllllllllIIlIlllIllIIllllIIllI = lllllllllllIIlIlllIllIIllllIIlll.getKey();
                        lllllllllllIIlIlllIllIIllllllIII.setBlockState(lllllllllllIIlIlllIllIIllllIIllI, Blocks.AIR.getDefaultState(), 3);
                        final TileEntity lllllllllllIIlIlllIllIIllllIIlIl = lllllllllllIIlIlllIllIIllllllIII.getTileEntity(lllllllllllIIlIlllIllIIllllIIllI.down());
                        if (!(lllllllllllIIlIlllIllIIllllIIlIl instanceof TileEntityChest)) {
                            continue;
                        }
                        ((TileEntityChest)lllllllllllIIlIlllIllIIllllIIlIl).setLootTable(LootTableList.CHESTS_IGLOO_CHEST, lllllllllllIIlIlllIllIIlllllIlll.nextLong());
                    }
                }
            }
            else {
                final BlockPos lllllllllllIIlIlllIllIIllllIIlII = Template.transformedBlockPos(lllllllllllIIlIlllIllIIlllllIIII, new BlockPos(3, 0, 5));
                lllllllllllIIlIlllIllIIllllllIII.setBlockState(lllllllllllIIlIlllIllIIlllllIlII.add(lllllllllllIIlIlllIllIIllllIIlII), Blocks.SNOW.getDefaultState(), 3);
            }
            return true;
        }
        
        public Igloo() {
        }
        
        static {
            IGLOO_TOP_ID = new ResourceLocation("igloo/igloo_top");
            IGLOO_MIDDLE_ID = new ResourceLocation("igloo/igloo_middle");
            IGLOO_BOTTOM_ID = new ResourceLocation("igloo/igloo_bottom");
        }
        
        public Igloo(final Random lllllllllllIIlIlllIllIlIIIIlIIII, final int lllllllllllIIlIlllIllIlIIIIlIIll, final int lllllllllllIIlIlllIllIlIIIIlIIlI) {
            super(lllllllllllIIlIlllIllIlIIIIlIIII, lllllllllllIIlIlllIllIlIIIIlIIll, 64, lllllllllllIIlIlllIllIlIIIIlIIlI, 7, 5, 8);
        }
    }
    
    public static class SwampHut extends Feature
    {
        private /* synthetic */ boolean hasWitch;
        
        public SwampHut() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllIlllIIIIlllIlIIIlllIlI) {
            super.writeStructureToNBT(llllllllllIlllIIIIlllIlIIIlllIlI);
            llllllllllIlllIIIIlllIlIIIlllIlI.setBoolean("Witch", this.hasWitch);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllIlllIIIIlllIlIIIllIIll, final TemplateManager llllllllllIlllIIIIlllIlIIIllIIlI) {
            super.readStructureFromNBT(llllllllllIlllIIIIlllIlIIIllIIll, llllllllllIlllIIIIlllIlIIIllIIlI);
            this.hasWitch = llllllllllIlllIIIIlllIlIIIllIIll.getBoolean("Witch");
        }
        
        public SwampHut(final Random llllllllllIlllIIIIlllIlIIlIIIlII, final int llllllllllIlllIIIIlllIlIIIllllll, final int llllllllllIlllIIIIlllIlIIlIIIIlI) {
            super(llllllllllIlllIIIIlllIlIIlIIIlII, llllllllllIlllIIIIlllIlIIIllllll, 64, llllllllllIlllIIIIlllIlIIlIIIIlI, 7, 7, 9);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllIlllIIIIlllIlIIIlIIIlI, final Random llllllllllIlllIIIIlllIlIIIlIIIIl, final StructureBoundingBox llllllllllIlllIIIIlllIlIIIlIIIII) {
            if (!this.offsetToAverageGroundLevel(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 0)) {
                return false;
            }
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 1, 1, 1, 5, 1, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 1, 4, 2, 5, 4, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 2, 1, 0, 4, 1, 0, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 2, 2, 2, 3, 3, 2, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 1, 2, 3, 1, 3, 6, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 5, 2, 3, 5, 3, 6, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 2, 2, 7, 4, 3, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 1, 0, 2, 1, 3, 2, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 5, 0, 2, 5, 3, 2, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 1, 0, 7, 1, 3, 7, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 5, 0, 7, 5, 3, 7, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.OAK_FENCE.getDefaultState(), 2, 3, 2, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.OAK_FENCE.getDefaultState(), 3, 3, 7, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.AIR.getDefaultState(), 1, 3, 4, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.AIR.getDefaultState(), 5, 3, 4, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.AIR.getDefaultState(), 5, 3, 5, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.FLOWER_POT.getDefaultState().withProperty(BlockFlowerPot.CONTENTS, BlockFlowerPot.EnumFlowerType.MUSHROOM_RED), 1, 3, 5, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.CRAFTING_TABLE.getDefaultState(), 3, 2, 6, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.CAULDRON.getDefaultState(), 4, 2, 6, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.OAK_FENCE.getDefaultState(), 1, 2, 1, llllllllllIlllIIIIlllIlIIIlIIIII);
            this.setBlockState(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.OAK_FENCE.getDefaultState(), 5, 2, 1, llllllllllIlllIIIIlllIlIIIlIIIII);
            final IBlockState llllllllllIlllIIIIlllIlIIIIlllll = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            final IBlockState llllllllllIlllIIIIlllIlIIIIllllI = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState llllllllllIlllIIIIlllIlIIIIlllIl = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final IBlockState llllllllllIlllIIIIlllIlIIIIlllII = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 0, 4, 1, 6, 4, 1, llllllllllIlllIIIIlllIlIIIIlllll, llllllllllIlllIIIIlllIlIIIIlllll, false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 0, 4, 2, 0, 4, 7, llllllllllIlllIIIIlllIlIIIIllllI, llllllllllIlllIIIIlllIlIIIIllllI, false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 6, 4, 2, 6, 4, 7, llllllllllIlllIIIIlllIlIIIIlllIl, llllllllllIlllIIIIlllIlIIIIlllIl, false);
            this.fillWithBlocks(llllllllllIlllIIIIlllIlIIIlIIIlI, llllllllllIlllIIIIlllIlIIIlIIIII, 0, 4, 8, 6, 4, 8, llllllllllIlllIIIIlllIlIIIIlllII, llllllllllIlllIIIIlllIlIIIIlllII, false);
            for (int llllllllllIlllIIIIlllIlIIIIllIll = 2; llllllllllIlllIIIIlllIlIIIIllIll <= 7; llllllllllIlllIIIIlllIlIIIIllIll += 5) {
                for (int llllllllllIlllIIIIlllIlIIIIllIlI = 1; llllllllllIlllIIIIlllIlIIIIllIlI <= 5; llllllllllIlllIIIIlllIlIIIIllIlI += 4) {
                    this.replaceAirAndLiquidDownwards(llllllllllIlllIIIIlllIlIIIlIIIlI, Blocks.LOG.getDefaultState(), llllllllllIlllIIIIlllIlIIIIllIlI, -1, llllllllllIlllIIIIlllIlIIIIllIll, llllllllllIlllIIIIlllIlIIIlIIIII);
                }
            }
            if (!this.hasWitch) {
                final int llllllllllIlllIIIIlllIlIIIIllIIl = this.getXWithOffset(2, 5);
                final int llllllllllIlllIIIIlllIlIIIIllIII = this.getYWithOffset(2);
                final int llllllllllIlllIIIIlllIlIIIIlIlll = this.getZWithOffset(2, 5);
                if (llllllllllIlllIIIIlllIlIIIlIIIII.isVecInside(new BlockPos(llllllllllIlllIIIIlllIlIIIIllIIl, llllllllllIlllIIIIlllIlIIIIllIII, llllllllllIlllIIIIlllIlIIIIlIlll))) {
                    this.hasWitch = true;
                    final EntityWitch llllllllllIlllIIIIlllIlIIIIlIllI = new EntityWitch(llllllllllIlllIIIIlllIlIIIlIIIlI);
                    llllllllllIlllIIIIlllIlIIIIlIllI.enablePersistence();
                    llllllllllIlllIIIIlllIlIIIIlIllI.setLocationAndAngles(llllllllllIlllIIIIlllIlIIIIllIIl + 0.5, llllllllllIlllIIIIlllIlIIIIllIII, llllllllllIlllIIIIlllIlIIIIlIlll + 0.5, 0.0f, 0.0f);
                    llllllllllIlllIIIIlllIlIIIIlIllI.onInitialSpawn(llllllllllIlllIIIIlllIlIIIlIIIlI.getDifficultyForLocation(new BlockPos(llllllllllIlllIIIIlllIlIIIIllIIl, llllllllllIlllIIIIlllIlIIIIllIII, llllllllllIlllIIIIlllIlIIIIlIlll)), null);
                    llllllllllIlllIIIIlllIlIIIlIIIlI.spawnEntityInWorld(llllllllllIlllIIIIlllIlIIIIlIllI);
                }
            }
            return true;
        }
    }
}
