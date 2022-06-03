// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.block.BlockDirt;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockQuartz;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockDropper;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStone;
import net.minecraft.client.renderer.block.statemap.StateMap;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.block.state.IBlockState;
import java.util.Map;
import net.minecraft.client.renderer.block.model.ModelManager;

public class BlockModelShapes
{
    private final /* synthetic */ ModelManager modelManager;
    private final /* synthetic */ Map<IBlockState, IBakedModel> bakedModelStore;
    private final /* synthetic */ BlockStateMapper blockStateMapper;
    
    public void registerBuiltInBlocks(final Block... lllllllllllIIllIlllIIIlIIIIIlIIl) {
        this.blockStateMapper.registerBuiltInBlocks(lllllllllllIIllIlllIIIlIIIIIlIIl);
    }
    
    public BlockStateMapper getBlockStateMapper() {
        return this.blockStateMapper;
    }
    
    public TextureAtlasSprite getTexture(final IBlockState lllllllllllIIllIlllIIIlIIIlIlllI) {
        final Block lllllllllllIIllIlllIIIlIIIllIIIl = lllllllllllIIllIlllIIIlIIIlIlllI.getBlock();
        IBakedModel lllllllllllIIllIlllIIIlIIIllIIII = this.getModelForState(lllllllllllIIllIlllIIIlIIIlIlllI);
        if (lllllllllllIIllIlllIIIlIIIllIIII == null || lllllllllllIIllIlllIIIlIIIllIIII == this.modelManager.getMissingModel()) {
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.WALL_SIGN || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.STANDING_SIGN || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.CHEST || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.TRAPPED_CHEST || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.STANDING_BANNER || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.WALL_BANNER || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.BED) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/planks_oak");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.ENDER_CHEST) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/obsidian");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.FLOWING_LAVA || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.LAVA) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/lava_still");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.FLOWING_WATER || lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.WATER) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/water_still");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.SKULL) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/soul_sand");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.BARRIER) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:items/barrier");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.STRUCTURE_VOID) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:items/structure_void");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190977_dl) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_white");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190978_dm) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_orange");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190979_dn) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_magenta");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190980_do) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_light_blue");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190981_dp) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_yellow");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190982_dq) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_lime");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190983_dr) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_pink");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190984_ds) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_gray");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190985_dt) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_silver");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190986_du) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_cyan");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190987_dv) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_purple");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190988_dw) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_blue");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190989_dx) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_brown");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190990_dy) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_green");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190991_dz) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_red");
            }
            if (lllllllllllIIllIlllIIIlIIIllIIIl == Blocks.field_190975_dA) {
                return this.modelManager.getTextureMap().getAtlasSprite("minecraft:blocks/shulker_top_black");
            }
        }
        if (lllllllllllIIllIlllIIIlIIIllIIII == null) {
            lllllllllllIIllIlllIIIlIIIllIIII = this.modelManager.getMissingModel();
        }
        return lllllllllllIIllIlllIIIlIIIllIIII.getParticleTexture();
    }
    
    public void reloadModels() {
        this.bakedModelStore.clear();
        for (final Map.Entry<IBlockState, ModelResourceLocation> lllllllllllIIllIlllIIIlIIIIllIll : this.blockStateMapper.putAllStateModelLocations().entrySet()) {
            this.bakedModelStore.put(lllllllllllIIllIlllIIIlIIIIllIll.getKey(), this.modelManager.getModel(lllllllllllIIllIlllIIIlIIIIllIll.getValue()));
        }
    }
    
    public void registerBlockWithStateMapper(final Block lllllllllllIIllIlllIIIlIIIIlIIll, final IStateMapper lllllllllllIIllIlllIIIlIIIIIllll) {
        this.blockStateMapper.registerBlockStateMapper(lllllllllllIIllIlllIIIlIIIIlIIll, lllllllllllIIllIlllIIIlIIIIIllll);
    }
    
    public BlockModelShapes(final ModelManager lllllllllllIIllIlllIIIlIIIllllIl) {
        this.bakedModelStore = (Map<IBlockState, IBakedModel>)Maps.newIdentityHashMap();
        this.blockStateMapper = new BlockStateMapper();
        this.modelManager = lllllllllllIIllIlllIIIlIIIllllIl;
        this.registerAllBlocks();
    }
    
    private void registerAllBlocks() {
        this.registerBuiltInBlocks(Blocks.AIR, Blocks.FLOWING_WATER, Blocks.WATER, Blocks.FLOWING_LAVA, Blocks.LAVA, Blocks.PISTON_EXTENSION, Blocks.CHEST, Blocks.ENDER_CHEST, Blocks.TRAPPED_CHEST, Blocks.STANDING_SIGN, Blocks.SKULL, Blocks.END_PORTAL, Blocks.BARRIER, Blocks.WALL_SIGN, Blocks.WALL_BANNER, Blocks.STANDING_BANNER, Blocks.END_GATEWAY, Blocks.STRUCTURE_VOID, Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA, Blocks.BED);
        this.registerBlockWithStateMapper(Blocks.STONE, new StateMap.Builder().withName(BlockStone.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.PRISMARINE, new StateMap.Builder().withName(BlockPrismarine.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.LEAVES, new StateMap.Builder().withName(BlockOldLeaf.VARIANT).withSuffix("_leaves").ignore(BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE).build());
        this.registerBlockWithStateMapper(Blocks.LEAVES2, new StateMap.Builder().withName(BlockNewLeaf.VARIANT).withSuffix("_leaves").ignore(BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE).build());
        this.registerBlockWithStateMapper(Blocks.CACTUS, new StateMap.Builder().ignore(BlockCactus.AGE).build());
        this.registerBlockWithStateMapper(Blocks.REEDS, new StateMap.Builder().ignore(BlockReed.AGE).build());
        this.registerBlockWithStateMapper(Blocks.JUKEBOX, new StateMap.Builder().ignore(BlockJukebox.HAS_RECORD).build());
        this.registerBlockWithStateMapper(Blocks.COBBLESTONE_WALL, new StateMap.Builder().withName(BlockWall.VARIANT).withSuffix("_wall").build());
        this.registerBlockWithStateMapper(Blocks.DOUBLE_PLANT, new StateMap.Builder().withName(BlockDoublePlant.VARIANT).ignore(BlockDoublePlant.FACING).build());
        this.registerBlockWithStateMapper(Blocks.OAK_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.SPRUCE_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.BIRCH_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.JUNGLE_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DARK_OAK_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.ACACIA_FENCE_GATE, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.TRIPWIRE, new StateMap.Builder().ignore(BlockTripWire.DISARMED, BlockTripWire.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DOUBLE_WOODEN_SLAB, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_double_slab").build());
        this.registerBlockWithStateMapper(Blocks.WOODEN_SLAB, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.TNT, new StateMap.Builder().ignore(BlockTNT.EXPLODE).build());
        this.registerBlockWithStateMapper(Blocks.FIRE, new StateMap.Builder().ignore(BlockFire.AGE).build());
        this.registerBlockWithStateMapper(Blocks.REDSTONE_WIRE, new StateMap.Builder().ignore(BlockRedstoneWire.POWER).build());
        this.registerBlockWithStateMapper(Blocks.OAK_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.SPRUCE_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.BIRCH_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.JUNGLE_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.ACACIA_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.DARK_OAK_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.IRON_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        this.registerBlockWithStateMapper(Blocks.WOOL, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_wool").build());
        this.registerBlockWithStateMapper(Blocks.CARPET, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_carpet").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_HARDENED_CLAY, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_hardened_clay").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_GLASS_PANE, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_glass_pane").build());
        this.registerBlockWithStateMapper(Blocks.STAINED_GLASS, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_stained_glass").build());
        this.registerBlockWithStateMapper(Blocks.SANDSTONE, new StateMap.Builder().withName(BlockSandStone.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.RED_SANDSTONE, new StateMap.Builder().withName(BlockRedSandstone.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.TALLGRASS, new StateMap.Builder().withName(BlockTallGrass.TYPE).build());
        this.registerBlockWithStateMapper(Blocks.YELLOW_FLOWER, new StateMap.Builder().withName(Blocks.YELLOW_FLOWER.getTypeProperty()).build());
        this.registerBlockWithStateMapper(Blocks.RED_FLOWER, new StateMap.Builder().withName(Blocks.RED_FLOWER.getTypeProperty()).build());
        this.registerBlockWithStateMapper(Blocks.STONE_SLAB, new StateMap.Builder().withName(BlockStoneSlab.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.STONE_SLAB2, new StateMap.Builder().withName(BlockStoneSlabNew.VARIANT).withSuffix("_slab").build());
        this.registerBlockWithStateMapper(Blocks.MONSTER_EGG, new StateMap.Builder().withName(BlockSilverfish.VARIANT).withSuffix("_monster_egg").build());
        this.registerBlockWithStateMapper(Blocks.STONEBRICK, new StateMap.Builder().withName(BlockStoneBrick.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.DISPENSER, new StateMap.Builder().ignore(BlockDispenser.TRIGGERED).build());
        this.registerBlockWithStateMapper(Blocks.DROPPER, new StateMap.Builder().ignore(BlockDropper.TRIGGERED).build());
        this.registerBlockWithStateMapper(Blocks.LOG, new StateMap.Builder().withName(BlockOldLog.VARIANT).withSuffix("_log").build());
        this.registerBlockWithStateMapper(Blocks.LOG2, new StateMap.Builder().withName(BlockNewLog.VARIANT).withSuffix("_log").build());
        this.registerBlockWithStateMapper(Blocks.PLANKS, new StateMap.Builder().withName(BlockPlanks.VARIANT).withSuffix("_planks").build());
        this.registerBlockWithStateMapper(Blocks.SAPLING, new StateMap.Builder().withName(BlockSapling.TYPE).withSuffix("_sapling").build());
        this.registerBlockWithStateMapper(Blocks.SAND, new StateMap.Builder().withName(BlockSand.VARIANT).build());
        this.registerBlockWithStateMapper(Blocks.HOPPER, new StateMap.Builder().ignore(BlockHopper.ENABLED).build());
        this.registerBlockWithStateMapper(Blocks.FLOWER_POT, new StateMap.Builder().ignore(BlockFlowerPot.LEGACY_DATA).build());
        this.registerBlockWithStateMapper(Blocks.field_192443_dR, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_concrete").build());
        this.registerBlockWithStateMapper(Blocks.field_192444_dS, new StateMap.Builder().withName(BlockColored.COLOR).withSuffix("_concrete_powder").build());
        this.registerBlockWithStateMapper(Blocks.QUARTZ_BLOCK, new StateMapperBase() {
            private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
            
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState llllllllllllIIIIIIlllIIIllIllllI) {
                final BlockQuartz.EnumType llllllllllllIIIIIIlllIIIllIlllll = llllllllllllIIIIIIlllIIIllIllllI.getValue(BlockQuartz.VARIANT);
                switch ($SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType()[llllllllllllIIIIIIlllIIIllIlllll.ordinal()]) {
                    default: {
                        return new ModelResourceLocation("quartz_block", "normal");
                    }
                    case 2: {
                        return new ModelResourceLocation("chiseled_quartz_block", "normal");
                    }
                    case 3: {
                        return new ModelResourceLocation("quartz_column", "axis=y");
                    }
                    case 4: {
                        return new ModelResourceLocation("quartz_column", "axis=x");
                    }
                    case 5: {
                        return new ModelResourceLocation("quartz_column", "axis=z");
                    }
                }
            }
            
            static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType() {
                final int[] $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType = BlockModelShapes$1.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
                if ($switch_TABLE$net$minecraft$block$BlockQuartz$EnumType != null) {
                    return $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType;
                }
                final long llllllllllllIIIIIIlllIIIllIllIll = (Object)new int[BlockQuartz.EnumType.values().length];
                try {
                    llllllllllllIIIIIIlllIIIllIllIll[BlockQuartz.EnumType.CHISELED.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {}
                try {
                    llllllllllllIIIIIIlllIIIllIllIll[BlockQuartz.EnumType.DEFAULT.ordinal()] = true;
                }
                catch (NoSuchFieldError noSuchFieldError2) {}
                try {
                    llllllllllllIIIIIIlllIIIllIllIll[BlockQuartz.EnumType.LINES_X.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError3) {}
                try {
                    llllllllllllIIIIIIlllIIIllIllIll[BlockQuartz.EnumType.LINES_Y.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError4) {}
                try {
                    llllllllllllIIIIIIlllIIIllIllIll[BlockQuartz.EnumType.LINES_Z.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError5) {}
                return BlockModelShapes$1.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType = (int[])(Object)llllllllllllIIIIIIlllIIIllIllIll;
            }
        });
        this.registerBlockWithStateMapper(Blocks.DEADBUSH, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllIIIllIIIIllIllIIlIIlI) {
                return new ModelResourceLocation("dead_bush", "normal");
            }
        });
        this.registerBlockWithStateMapper(Blocks.PUMPKIN_STEM, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState llllllllllllIIllIIllIIIIllIIlIII) {
                final Map<IProperty<?>, Comparable<?>> llllllllllllIIllIIllIIIIllIIIlll = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)llllllllllllIIllIIllIIIIllIIlIII.getProperties());
                if (llllllllllllIIllIIllIIIIllIIlIII.getValue((IProperty<Comparable>)BlockStem.FACING) != EnumFacing.UP) {
                    llllllllllllIIllIIllIIIIllIIIlll.remove(BlockStem.AGE);
                }
                return new ModelResourceLocation(Block.REGISTRY.getNameForObject(llllllllllllIIllIIllIIIIllIIlIII.getBlock()), this.getPropertyString(llllllllllllIIllIIllIIIIllIIIlll));
            }
        });
        this.registerBlockWithStateMapper(Blocks.MELON_STEM, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllIIlIIllllllIlIllIlIll) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIlIIllllllIlIllIlIlI = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllIIlIIllllllIlIllIlIll.getProperties());
                if (lllllllllllIIlIIllllllIlIllIlIll.getValue((IProperty<Comparable>)BlockStem.FACING) != EnumFacing.UP) {
                    lllllllllllIIlIIllllllIlIllIlIlI.remove(BlockStem.AGE);
                }
                return new ModelResourceLocation(Block.REGISTRY.getNameForObject(lllllllllllIIlIIllllllIlIllIlIll.getBlock()), this.getPropertyString(lllllllllllIIlIIllllllIlIllIlIlI));
            }
        });
        this.registerBlockWithStateMapper(Blocks.DIRT, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllIIllIIIllIIlIllIIlIII) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIllIIIllIIlIllIIIlll = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllIIllIIIllIIlIllIIlIII.getProperties());
                final String lllllllllllIIllIIIllIIlIllIIIllI = BlockDirt.VARIANT.getName(lllllllllllIIllIIIllIIlIllIIIlll.remove(BlockDirt.VARIANT));
                if (BlockDirt.DirtType.PODZOL != lllllllllllIIllIIIllIIlIllIIlIII.getValue(BlockDirt.VARIANT)) {
                    lllllllllllIIllIIIllIIlIllIIIlll.remove(BlockDirt.SNOWY);
                }
                return new ModelResourceLocation(lllllllllllIIllIIIllIIlIllIIIllI, this.getPropertyString(lllllllllllIIllIIIllIIlIllIIIlll));
            }
        });
        this.registerBlockWithStateMapper(Blocks.DOUBLE_STONE_SLAB, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllIIllIlllIIllIIllIIIlI) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIllIlllIIllIIllIIlIl = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllIIllIlllIIllIIllIIIlI.getProperties());
                final String lllllllllllIIllIlllIIllIIllIIlII = BlockStoneSlab.VARIANT.getName(lllllllllllIIllIlllIIllIIllIIlIl.remove(BlockStoneSlab.VARIANT));
                lllllllllllIIllIlllIIllIIllIIlIl.remove(BlockStoneSlab.SEAMLESS);
                final String lllllllllllIIllIlllIIllIIllIIIll = lllllllllllIIllIlllIIllIIllIIIlI.getValue((IProperty<Boolean>)BlockStoneSlab.SEAMLESS) ? "all" : "normal";
                return new ModelResourceLocation(String.valueOf(lllllllllllIIllIlllIIllIIllIIlII) + "_double_slab", lllllllllllIIllIlllIIllIIllIIIll);
            }
        });
        this.registerBlockWithStateMapper(Blocks.DOUBLE_STONE_SLAB2, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllIIIIIlIlllIIlIllIIIII) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIIIIlIlllIIlIlIlllll = (Map<IProperty<?>, Comparable<?>>)Maps.newLinkedHashMap((Map)lllllllllllIIIIIlIlllIIlIllIIIII.getProperties());
                final String lllllllllllIIIIIlIlllIIlIlIllllI = BlockStoneSlabNew.VARIANT.getName(lllllllllllIIIIIlIlllIIlIlIlllll.remove(BlockStoneSlabNew.VARIANT));
                lllllllllllIIIIIlIlllIIlIlIlllll.remove(BlockStoneSlab.SEAMLESS);
                final String lllllllllllIIIIIlIlllIIlIlIlllIl = lllllllllllIIIIIlIlllIIlIllIIIII.getValue((IProperty<Boolean>)BlockStoneSlabNew.SEAMLESS) ? "all" : "normal";
                return new ModelResourceLocation(String.valueOf(lllllllllllIIIIIlIlllIIlIlIllllI) + "_double_slab", lllllllllllIIIIIlIlllIIlIlIlllIl);
            }
        });
    }
    
    public IBakedModel getModelForState(final IBlockState lllllllllllIIllIlllIIIlIIIlIIlII) {
        IBakedModel lllllllllllIIllIlllIIIlIIIlIIllI = this.bakedModelStore.get(lllllllllllIIllIlllIIIlIIIlIIlII);
        if (lllllllllllIIllIlllIIIlIIIlIIllI == null) {
            lllllllllllIIllIlllIIIlIIIlIIllI = this.modelManager.getMissingModel();
        }
        return lllllllllllIIllIlllIIIlIIIlIIllI;
    }
    
    public ModelManager getModelManager() {
        return this.modelManager;
    }
}
