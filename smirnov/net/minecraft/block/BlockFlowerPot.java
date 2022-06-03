// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.ChunkCache;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.material.Material;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import javax.annotation.Nullable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockFlowerPot extends BlockContainer
{
    public static final /* synthetic */ PropertyInteger LEGACY_DATA;
    protected static final /* synthetic */ AxisAlignedBB FLOWER_POT_AABB;
    public static final /* synthetic */ PropertyEnum<EnumFlowerType> CONTENTS;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIIIlIlIIllIIllIIlI, final IBlockAccess lllllllllllIIlIIIlIlIIllIIllIIIl, final BlockPos lllllllllllIIlIIIlIlIIllIIllIIII) {
        return BlockFlowerPot.FLOWER_POT_AABB;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIlIIIlIlIIlIllIlIIll, final BlockPos lllllllllllIIlIIIlIlIIlIllIlIIlI, final IBlockState lllllllllllIIlIIIlIlIIlIllIIllII) {
        final TileEntityFlowerPot lllllllllllIIlIIIlIlIIlIllIlIIII = this.getTileEntity(lllllllllllIIlIIIlIlIIlIllIlIIll, lllllllllllIIlIIIlIlIIlIllIlIIlI);
        if (lllllllllllIIlIIIlIlIIlIllIlIIII != null && lllllllllllIIlIIIlIlIIlIllIlIIII.getFlowerPotItem() != null) {
            Block.spawnAsEntity(lllllllllllIIlIIIlIlIIlIllIlIIll, lllllllllllIIlIIIlIlIIlIllIlIIlI, new ItemStack(lllllllllllIIlIIIlIlIIlIllIlIIII.getFlowerPotItem(), 1, lllllllllllIIlIIIlIlIIlIllIlIIII.getFlowerPotData()));
        }
        super.breakBlock(lllllllllllIIlIIIlIlIIlIllIlIIll, lllllllllllIIlIIIlIlIIlIllIlIIlI, lllllllllllIIlIIIlIlIIlIllIIllII);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlIIIlIlIIlIlIllIlll, final Random lllllllllllIIlIIIlIlIIlIlIllIllI, final int lllllllllllIIlIIIlIlIIlIlIllIlIl) {
        return Items.FLOWER_POT;
    }
    
    static {
        LEGACY_DATA = PropertyInteger.create("legacy_data", 0, 15);
        CONTENTS = PropertyEnum.create("contents", EnumFlowerType.class);
        FLOWER_POT_AABB = new AxisAlignedBB(0.3125, 0.0, 0.3125, 0.6875, 0.375, 0.6875);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType = BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType;
        if ($switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType != null) {
            return $switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType;
        }
        final long lllllllllllIIlIIIlIlIIlIIlllIIll = (Object)new int[BlockFlower.EnumFlowerType.values().length];
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.ALLIUM.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.DANDELION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.HOUSTONIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.PINK_TULIP.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.POPPY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.RED_TULIP.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIIll[BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType = (int[])(Object)lllllllllllIIlIIIlIlIIlIIlllIIll;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIIIlIlIIlIIllllIlI, final IBlockState lllllllllllIIlIIIlIlIIlIIllllIIl, final BlockPos lllllllllllIIlIIIlIlIIlIIllllIII, final EnumFacing lllllllllllIIlIIIlIlIIlIIlllIlll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIIlIIIlIlIIllIIlIllII) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIIlIIIlIlIIlIlIlIIllI, final int lllllllllllIIlIIIlIlIIlIlIlIIlIl) {
        Block lllllllllllIIlIIIlIlIIlIlIlIIlII = null;
        int lllllllllllIIlIIIlIlIIlIlIlIIIll = 0;
        switch (lllllllllllIIlIIIlIlIIlIlIlIIlIl) {
            case 1: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.RED_FLOWER;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockFlower.EnumFlowerType.POPPY.getMeta();
                break;
            }
            case 2: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.YELLOW_FLOWER;
                break;
            }
            case 3: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.OAK.getMetadata();
                break;
            }
            case 4: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.SPRUCE.getMetadata();
                break;
            }
            case 5: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.BIRCH.getMetadata();
                break;
            }
            case 6: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.JUNGLE.getMetadata();
                break;
            }
            case 7: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.RED_MUSHROOM;
                break;
            }
            case 8: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.BROWN_MUSHROOM;
                break;
            }
            case 9: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.CACTUS;
                break;
            }
            case 10: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.DEADBUSH;
                break;
            }
            case 11: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.TALLGRASS;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockTallGrass.EnumType.FERN.getMeta();
                break;
            }
            case 12: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.ACACIA.getMetadata();
                break;
            }
            case 13: {
                lllllllllllIIlIIIlIlIIlIlIlIIlII = Blocks.SAPLING;
                lllllllllllIIlIIIlIlIIlIlIlIIIll = BlockPlanks.EnumType.DARK_OAK.getMetadata();
                break;
            }
        }
        return new TileEntityFlowerPot(Item.getItemFromBlock(lllllllllllIIlIIIlIlIIlIlIlIIlII), lllllllllllIIlIIIlIlIIlIlIlIIIll);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIIIlIlIIllIIlIlIlI) {
        return false;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllIIlIIIlIlIIlIlIllllIl, final BlockPos lllllllllllIIlIIIlIlIIlIllIIIIlI, final IBlockState lllllllllllIIlIIIlIlIIlIllIIIIIl, final EntityPlayer lllllllllllIIlIIIlIlIIlIlIlllIlI) {
        super.onBlockHarvested(lllllllllllIIlIIIlIlIIlIlIllllIl, lllllllllllIIlIIIlIlIIlIllIIIIlI, lllllllllllIIlIIIlIlIIlIllIIIIIl, lllllllllllIIlIIIlIlIIlIlIlllIlI);
        if (lllllllllllIIlIIIlIlIIlIlIlllIlI.capabilities.isCreativeMode) {
            final TileEntityFlowerPot lllllllllllIIlIIIlIlIIlIlIllllll = this.getTileEntity(lllllllllllIIlIIIlIlIIlIlIllllIl, lllllllllllIIlIIIlIlIIlIllIIIIlI);
            if (lllllllllllIIlIIIlIlIIlIlIllllll != null) {
                lllllllllllIIlIIIlIlIIlIlIllllll.func_190614_a(ItemStack.field_190927_a);
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFlowerPot.CONTENTS, BlockFlowerPot.LEGACY_DATA });
    }
    
    @Nullable
    private TileEntityFlowerPot getTileEntity(final World lllllllllllIIlIIIlIlIIlIlIlIllIl, final BlockPos lllllllllllIIlIIIlIlIIlIlIlIllII) {
        final TileEntity lllllllllllIIlIIIlIlIIlIlIlIlllI = lllllllllllIIlIIIlIlIIlIlIlIllIl.getTileEntity(lllllllllllIIlIIIlIlIIlIlIlIllII);
        return (lllllllllllIIlIIIlIlIIlIlIlIlllI instanceof TileEntityFlowerPot) ? ((TileEntityFlowerPot)lllllllllllIIlIIIlIlIIlIlIlIlllI) : null;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIlIIIlIlIIllIIIlllll, final BlockPos lllllllllllIIlIIIlIlIIllIIIllllI, final IBlockState lllllllllllIIlIIIlIlIIllIIIlIIII, final EntityPlayer lllllllllllIIlIIIlIlIIllIIIIllll, final EnumHand lllllllllllIIlIIIlIlIIllIIIIlllI, final EnumFacing lllllllllllIIlIIIlIlIIllIIIllIlI, final float lllllllllllIIlIIIlIlIIllIIIllIIl, final float lllllllllllIIlIIIlIlIIllIIIllIII, final float lllllllllllIIlIIIlIlIIllIIIlIlll) {
        final ItemStack lllllllllllIIlIIIlIlIIllIIIlIllI = lllllllllllIIlIIIlIlIIllIIIIllll.getHeldItem(lllllllllllIIlIIIlIlIIllIIIIlllI);
        final TileEntityFlowerPot lllllllllllIIlIIIlIlIIllIIIlIlIl = this.getTileEntity(lllllllllllIIlIIIlIlIIllIIIlllll, lllllllllllIIlIIIlIlIIllIIIllllI);
        if (lllllllllllIIlIIIlIlIIllIIIlIlIl == null) {
            return false;
        }
        final ItemStack lllllllllllIIlIIIlIlIIllIIIlIlII = lllllllllllIIlIIIlIlIIllIIIlIlIl.getFlowerItemStack();
        if (lllllllllllIIlIIIlIlIIllIIIlIlII.func_190926_b()) {
            if (!this.func_190951_a(lllllllllllIIlIIIlIlIIllIIIlIllI)) {
                return false;
            }
            lllllllllllIIlIIIlIlIIllIIIlIlIl.func_190614_a(lllllllllllIIlIIIlIlIIllIIIlIllI);
            lllllllllllIIlIIIlIlIIllIIIIllll.addStat(StatList.FLOWER_POTTED);
            if (!lllllllllllIIlIIIlIlIIllIIIIllll.capabilities.isCreativeMode) {
                lllllllllllIIlIIIlIlIIllIIIlIllI.func_190918_g(1);
            }
        }
        else {
            if (lllllllllllIIlIIIlIlIIllIIIlIllI.func_190926_b()) {
                lllllllllllIIlIIIlIlIIllIIIIllll.setHeldItem(lllllllllllIIlIIIlIlIIllIIIIlllI, lllllllllllIIlIIIlIlIIllIIIlIlII);
            }
            else if (!lllllllllllIIlIIIlIlIIllIIIIllll.func_191521_c(lllllllllllIIlIIIlIlIIllIIIlIlII)) {
                lllllllllllIIlIIIlIlIIllIIIIllll.dropItem(lllllllllllIIlIIIlIlIIllIIIlIlII, false);
            }
            lllllllllllIIlIIIlIlIIllIIIlIlIl.func_190614_a(ItemStack.field_190927_a);
        }
        lllllllllllIIlIIIlIlIIllIIIlIlIl.markDirty();
        lllllllllllIIlIIIlIlIIllIIIlllll.notifyBlockUpdate(lllllllllllIIlIIIlIlIIllIIIllllI, lllllllllllIIlIIIlIlIIllIIIlIIII, lllllllllllIIlIIIlIlIIllIIIlIIII, 3);
        return true;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIlIIIlIlIIlIllllIlII, final BlockPos lllllllllllIIlIIIlIlIIlIlllllIIl, final IBlockState lllllllllllIIlIIIlIlIIlIlllllIII) {
        final TileEntityFlowerPot lllllllllllIIlIIIlIlIIlIllllIlll = this.getTileEntity(lllllllllllIIlIIIlIlIIlIllllIlII, lllllllllllIIlIIIlIlIIlIlllllIIl);
        if (lllllllllllIIlIIIlIlIIlIllllIlll != null) {
            final ItemStack lllllllllllIIlIIIlIlIIlIllllIllI = lllllllllllIIlIIIlIlIIlIllllIlll.getFlowerItemStack();
            if (!lllllllllllIIlIIIlIlIIlIllllIllI.func_190926_b()) {
                return lllllllllllIIlIIIlIlIIlIllllIllI;
            }
        }
        return new ItemStack(Items.FLOWER_POT);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIlIIIlIlIIlIlllIlIIl, final BlockPos lllllllllllIIlIIIlIlIIlIlllIlIll) {
        return super.canPlaceBlockAt(lllllllllllIIlIIIlIlIIlIlllIlIIl, lllllllllllIIlIIIlIlIIlIlllIlIll) && lllllllllllIIlIIIlIlIIlIlllIlIIl.getBlockState(lllllllllllIIlIIIlIlIIlIlllIlIll.down()).isFullyOpaque();
    }
    
    public BlockFlowerPot() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFlowerPot.CONTENTS, EnumFlowerType.EMPTY).withProperty((IProperty<Comparable>)BlockFlowerPot.LEGACY_DATA, 0));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIIIlIlIIllIIlIlllI) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIlIIIlIlIIlIllIlllII, final World lllllllllllIIlIIIlIlIIlIllIllIll, final BlockPos lllllllllllIIlIIIlIlIIlIlllIIIII, final Block lllllllllllIIlIIIlIlIIlIllIlllll, final BlockPos lllllllllllIIlIIIlIlIIlIllIllllI) {
        if (!lllllllllllIIlIIIlIlIIlIllIllIll.getBlockState(lllllllllllIIlIIIlIlIIlIlllIIIII.down()).isFullyOpaque()) {
            this.dropBlockAsItem(lllllllllllIIlIIIlIlIIlIllIllIll, lllllllllllIIlIIIlIlIIlIlllIIIII, lllllllllllIIlIIIlIlIIlIllIlllII, 0);
            lllllllllllIIlIIIlIlIIlIllIllIll.setBlockToAir(lllllllllllIIlIIIlIlIIlIlllIIIII);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIIIlIlIIlIlIIllIIl) {
        return lllllllllllIIlIIIlIlIIlIlIIllIIl.getValue((IProperty<Integer>)BlockFlowerPot.LEGACY_DATA);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    private boolean func_190951_a(final ItemStack lllllllllllIIlIIIlIlIIllIIIIIIll) {
        final Block lllllllllllIIlIIIlIlIIllIIIIIlIl = Block.getBlockFromItem(lllllllllllIIlIIIlIlIIllIIIIIIll.getItem());
        if (lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.YELLOW_FLOWER && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.RED_FLOWER && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.CACTUS && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.BROWN_MUSHROOM && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.RED_MUSHROOM && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.SAPLING && lllllllllllIIlIIIlIlIIllIIIIIlIl != Blocks.DEADBUSH) {
            final int lllllllllllIIlIIIlIlIIllIIIIIlII = lllllllllllIIlIIIlIlIIllIIIIIIll.getMetadata();
            return lllllllllllIIlIIIlIlIIllIIIIIlIl == Blocks.TALLGRASS && lllllllllllIIlIIIlIlIIllIIIIIlII == BlockTallGrass.EnumType.FERN.getMeta();
        }
        return true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final float lllllllllllIIlIIIlIlIIlIIlllIlIl = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIlIIIlIlIIlIIlllIlIl[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)lllllllllllIIlIIIlIlIIlIIlllIlIl;
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.flowerPot.name");
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIlIIIlIlIIlIlIIIlllI, final IBlockAccess lllllllllllIIlIIIlIlIIlIlIIIIlII, final BlockPos lllllllllllIIlIIIlIlIIlIlIIIllII) {
        EnumFlowerType lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.EMPTY;
        final TileEntity lllllllllllIIlIIIlIlIIlIlIIIlIlI = (lllllllllllIIlIIIlIlIIlIlIIIIlII instanceof ChunkCache) ? ((ChunkCache)lllllllllllIIlIIIlIlIIlIlIIIIlII).getTileEntity(lllllllllllIIlIIIlIlIIlIlIIIllII, Chunk.EnumCreateEntityType.CHECK) : lllllllllllIIlIIIlIlIIlIlIIIIlII.getTileEntity(lllllllllllIIlIIIlIlIIlIlIIIllII);
        if (lllllllllllIIlIIIlIlIIlIlIIIlIlI instanceof TileEntityFlowerPot) {
            final TileEntityFlowerPot lllllllllllIIlIIIlIlIIlIlIIIlIIl = (TileEntityFlowerPot)lllllllllllIIlIIIlIlIIlIlIIIlIlI;
            final Item lllllllllllIIlIIIlIlIIlIlIIIlIII = lllllllllllIIlIIIlIlIIlIlIIIlIIl.getFlowerPotItem();
            if (lllllllllllIIlIIIlIlIIlIlIIIlIII instanceof ItemBlock) {
                final int lllllllllllIIlIIIlIlIIlIlIIIIlll = lllllllllllIIlIIIlIlIIlIlIIIlIIl.getFlowerPotData();
                final Block lllllllllllIIlIIIlIlIIlIlIIIIllI = Block.getBlockFromItem(lllllllllllIIlIIIlIlIIlIlIIIlIII);
                if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.SAPLING) {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[BlockPlanks.EnumType.byMetadata(lllllllllllIIlIIIlIlIIlIlIIIIlll).ordinal()]) {
                        case 1: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.OAK_SAPLING;
                            break;
                        }
                        case 2: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.SPRUCE_SAPLING;
                            break;
                        }
                        case 3: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.BIRCH_SAPLING;
                            break;
                        }
                        case 4: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.JUNGLE_SAPLING;
                            break;
                        }
                        case 5: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.ACACIA_SAPLING;
                            break;
                        }
                        case 6: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.DARK_OAK_SAPLING;
                            break;
                        }
                        default: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.TALLGRASS) {
                    switch (lllllllllllIIlIIIlIlIIlIlIIIIlll) {
                        case 0: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.DEAD_BUSH;
                            break;
                        }
                        case 2: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.FERN;
                            break;
                        }
                        default: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.YELLOW_FLOWER) {
                    lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.DANDELION;
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.RED_FLOWER) {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType()[BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, lllllllllllIIlIIIlIlIIlIlIIIIlll).ordinal()]) {
                        case 2: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.POPPY;
                            break;
                        }
                        case 3: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.BLUE_ORCHID;
                            break;
                        }
                        case 4: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.ALLIUM;
                            break;
                        }
                        case 5: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.HOUSTONIA;
                            break;
                        }
                        case 6: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.RED_TULIP;
                            break;
                        }
                        case 7: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.ORANGE_TULIP;
                            break;
                        }
                        case 8: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.WHITE_TULIP;
                            break;
                        }
                        case 9: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.PINK_TULIP;
                            break;
                        }
                        case 10: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.OXEYE_DAISY;
                            break;
                        }
                        default: {
                            lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.RED_MUSHROOM) {
                    lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.MUSHROOM_RED;
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.BROWN_MUSHROOM) {
                    lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.MUSHROOM_BROWN;
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.DEADBUSH) {
                    lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.DEAD_BUSH;
                }
                else if (lllllllllllIIlIIIlIlIIlIlIIIIllI == Blocks.CACTUS) {
                    lllllllllllIIlIIIlIlIIlIlIIIlIll = EnumFlowerType.CACTUS;
                }
            }
        }
        return lllllllllllIIlIIIlIlIIlIlIIIlllI.withProperty(BlockFlowerPot.CONTENTS, lllllllllllIIlIIIlIlIIlIlIIIlIll);
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        JUNGLE_SAPLING("JUNGLE_SAPLING", 14, "jungle_sapling"), 
        SPRUCE_SAPLING("SPRUCE_SAPLING", 12, "spruce_sapling"), 
        ALLIUM("ALLIUM", 3, "allium"), 
        OAK_SAPLING("OAK_SAPLING", 11, "oak_sapling"), 
        MUSHROOM_RED("MUSHROOM_RED", 17, "mushroom_red"), 
        EMPTY("EMPTY", 0, "empty"), 
        DEAD_BUSH("DEAD_BUSH", 19, "dead_bush"), 
        MUSHROOM_BROWN("MUSHROOM_BROWN", 18, "mushroom_brown");
        
        private final /* synthetic */ String name;
        
        ORANGE_TULIP("ORANGE_TULIP", 6, "orange_tulip"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, "blue_orchid"), 
        DARK_OAK_SAPLING("DARK_OAK_SAPLING", 16, "dark_oak_sapling"), 
        PINK_TULIP("PINK_TULIP", 8, "pink_tulip"), 
        ACACIA_SAPLING("ACACIA_SAPLING", 15, "acacia_sapling"), 
        BIRCH_SAPLING("BIRCH_SAPLING", 13, "birch_sapling"), 
        POPPY("POPPY", 1, "rose"), 
        CACTUS("CACTUS", 21, "cactus"), 
        OXEYE_DAISY("OXEYE_DAISY", 9, "oxeye_daisy"), 
        FERN("FERN", 20, "fern"), 
        DANDELION("DANDELION", 10, "dandelion"), 
        HOUSTONIA("HOUSTONIA", 4, "houstonia"), 
        WHITE_TULIP("WHITE_TULIP", 7, "white_tulip"), 
        RED_TULIP("RED_TULIP", 5, "red_tulip");
        
        private EnumFlowerType(final String lllllllllllIlIIIllIIllIlIIlIIIll, final int lllllllllllIlIIIllIIllIlIIlIIIlI, final String lllllllllllIlIIIllIIllIlIIlIIIIl) {
            this.name = lllllllllllIlIIIllIIllIlIIlIIIIl;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
