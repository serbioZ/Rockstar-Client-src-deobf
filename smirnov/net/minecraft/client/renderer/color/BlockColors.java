// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.color;

import net.minecraft.block.material.MapColor;
import net.minecraft.world.World;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ObjectIntIdentityMap;

public class BlockColors
{
    private final /* synthetic */ ObjectIntIdentityMap<IBlockColor> mapBlockColors;
    
    public BlockColors() {
        this.mapBlockColors = new ObjectIntIdentityMap<IBlockColor>(32);
    }
    
    public static BlockColors init() {
        final BlockColors lllllllllllllllIIllIIlIllIlIlIll = new BlockColors();
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllllIllIlllIllIlllIIIlII, @Nullable final IBlockAccess llllllllllllIllIlllIllIllIlllllI, @Nullable final BlockPos llllllllllllIllIlllIllIlllIIIIlI, final int llllllllllllIllIlllIllIlllIIIIIl) {
                final BlockDoublePlant.EnumPlantType llllllllllllIllIlllIllIlllIIIIII = llllllllllllIllIlllIllIlllIIIlII.getValue(BlockDoublePlant.VARIANT);
                return (llllllllllllIllIlllIllIllIlllllI != null && llllllllllllIllIlllIllIlllIIIIlI != null && (llllllllllllIllIlllIllIlllIIIIII == BlockDoublePlant.EnumPlantType.GRASS || llllllllllllIllIlllIllIlllIIIIII == BlockDoublePlant.EnumPlantType.FERN)) ? BiomeColorHelper.getGrassColorAtPos(llllllllllllIllIlllIllIllIlllllI, (llllllllllllIllIlllIllIlllIIIlII.getValue(BlockDoublePlant.HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) ? llllllllllllIllIlllIllIlllIIIIlI.down() : llllllllllllIllIlllIllIlllIIIIlI) : -1;
            }
        }, Blocks.DOUBLE_PLANT);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIIlIIllIIIIllIlllIlII, @Nullable final IBlockAccess lllllllllllIIlIIllIIIIllIllIllII, @Nullable final BlockPos lllllllllllIIlIIllIIIIllIllIlIll, final int lllllllllllIIlIIllIIIIllIlllIIIl) {
                if (lllllllllllIIlIIllIIIIllIllIllII == null || lllllllllllIIlIIllIIIIllIllIlIll == null) {
                    return -1;
                }
                final TileEntity lllllllllllIIlIIllIIIIllIlllIIII = lllllllllllIIlIIllIIIIllIllIllII.getTileEntity(lllllllllllIIlIIllIIIIllIllIlIll);
                if (lllllllllllIIlIIllIIIIllIlllIIII instanceof TileEntityFlowerPot) {
                    final Item lllllllllllIIlIIllIIIIllIllIllll = ((TileEntityFlowerPot)lllllllllllIIlIIllIIIIllIlllIIII).getFlowerPotItem();
                    final IBlockState lllllllllllIIlIIllIIIIllIllIlllI = Block.getBlockFromItem(lllllllllllIIlIIllIIIIllIllIllll).getDefaultState();
                    return lllllllllllllllIIllIIlIllIlIlIll.colorMultiplier(lllllllllllIIlIIllIIIIllIllIlllI, lllllllllllIIlIIllIIIIllIllIllII, lllllllllllIIlIIllIIIIllIllIlIll, lllllllllllIIlIIllIIIIllIlllIIIl);
                }
                return -1;
            }
        }, Blocks.FLOWER_POT);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIllllIIIIlllIIIIIllll, @Nullable final IBlockAccess lllllllllllIllllIIIIlllIIIIIlllI, @Nullable final BlockPos lllllllllllIllllIIIIlllIIIIIlIlI, final int lllllllllllIllllIIIIlllIIIIIllII) {
                return (lllllllllllIllllIIIIlllIIIIIlllI != null && lllllllllllIllllIIIIlllIIIIIlIlI != null) ? BiomeColorHelper.getGrassColorAtPos(lllllllllllIllllIIIIlllIIIIIlllI, lllllllllllIllllIIIIlllIIIIIlIlI) : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.GRASS);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIIIlIlIIIIIlIIIlIllll, @Nullable final IBlockAccess lllllllllllIIIlIlIIIIIlIIIllIIll, @Nullable final BlockPos lllllllllllIIIlIlIIIIIlIIIllIIlI, final int lllllllllllIIIlIlIIIIIlIIIllIIIl) {
                final BlockPlanks.EnumType lllllllllllIIIlIlIIIIIlIIIllIIII = lllllllllllIIIlIlIIIIIlIIIlIllll.getValue(BlockOldLeaf.VARIANT);
                if (lllllllllllIIIlIlIIIIIlIIIllIIII == BlockPlanks.EnumType.SPRUCE) {
                    return ColorizerFoliage.getFoliageColorPine();
                }
                if (lllllllllllIIIlIlIIIIIlIIIllIIII == BlockPlanks.EnumType.BIRCH) {
                    return ColorizerFoliage.getFoliageColorBirch();
                }
                return (lllllllllllIIIlIlIIIIIlIIIllIIll != null && lllllllllllIIIlIlIIIIIlIIIllIIlI != null) ? BiomeColorHelper.getFoliageColorAtPos(lllllllllllIIIlIlIIIIIlIIIllIIll, lllllllllllIIIlIlIIIIIlIIIllIIlI) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.LEAVES);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllllIIlllIllIIIlllIIlIII, @Nullable final IBlockAccess llllllllllllIIlllIllIIIlllIIIlII, @Nullable final BlockPos llllllllllllIIlllIllIIIlllIIIllI, final int llllllllllllIIlllIllIIIlllIIIlIl) {
                return (llllllllllllIIlllIllIIIlllIIIlII != null && llllllllllllIIlllIllIIIlllIIIllI != null) ? BiomeColorHelper.getFoliageColorAtPos(llllllllllllIIlllIllIIIlllIIIlII, llllllllllllIIlllIllIIIlllIIIllI) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.LEAVES2);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIIllllIlllIIlIIIllIll, @Nullable final IBlockAccess lllllllllllIIllllIlllIIlIIIllIlI, @Nullable final BlockPos lllllllllllIIllllIlllIIlIIIllIIl, final int lllllllllllIIllllIlllIIlIIIllIII) {
                return (lllllllllllIIllllIlllIIlIIIllIlI != null && lllllllllllIIllllIlllIIlIIIllIIl != null) ? BiomeColorHelper.getWaterColorAtPos(lllllllllllIIllllIlllIIlIIIllIlI, lllllllllllIIllllIlllIIlIIIllIIl) : -1;
            }
        }, Blocks.WATER, Blocks.FLOWING_WATER);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIIlIllIIllIlllIIlllIl, @Nullable final IBlockAccess lllllllllllIIlIllIIllIlllIIlllII, @Nullable final BlockPos lllllllllllIIlIllIIllIlllIIllIll, final int lllllllllllIIlIllIIllIlllIIllIlI) {
                return BlockRedstoneWire.colorMultiplier(lllllllllllIIlIllIIllIlllIIlllIl.getValue((IProperty<Integer>)BlockRedstoneWire.POWER));
            }
        }, Blocks.REDSTONE_WIRE);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIlIIIIIllIllIIllllIll, @Nullable final IBlockAccess lllllllllllIlIIIIIllIllIIlllIlll, @Nullable final BlockPos lllllllllllIlIIIIIllIllIIlllIllI, final int lllllllllllIlIIIIIllIllIIllllIII) {
                return (lllllllllllIlIIIIIllIllIIlllIlll != null && lllllllllllIlIIIIIllIllIIlllIllI != null) ? BiomeColorHelper.getGrassColorAtPos(lllllllllllIlIIIIIllIllIIlllIlll, lllllllllllIlIIIIIllIllIIlllIllI) : -1;
            }
        }, Blocks.REEDS);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIlIlllIIIllllllIIllIl, @Nullable final IBlockAccess lllllllllllIlIlllIIIllllllIlIlII, @Nullable final BlockPos lllllllllllIlIlllIIIllllllIlIIll, final int lllllllllllIlIlllIIIllllllIlIIlI) {
                final int lllllllllllIlIlllIIIllllllIlIIIl = lllllllllllIlIlllIIIllllllIIllIl.getValue((IProperty<Integer>)BlockStem.AGE);
                final int lllllllllllIlIlllIIIllllllIlIIII = lllllllllllIlIlllIIIllllllIlIIIl * 32;
                final int lllllllllllIlIlllIIIllllllIIllll = 255 - lllllllllllIlIlllIIIllllllIlIIIl * 8;
                final int lllllllllllIlIlllIIIllllllIIlllI = lllllllllllIlIlllIIIllllllIlIIIl * 4;
                return lllllllllllIlIlllIIIllllllIlIIII << 16 | lllllllllllIlIlllIIIllllllIIllll << 8 | lllllllllllIlIlllIIIllllllIIlllI;
            }
        }, Blocks.MELON_STEM, Blocks.PUMPKIN_STEM);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllIlllllIlIIlIIlIlllIIl, @Nullable final IBlockAccess lllllllllllIlllllIlIIlIIlIllllII, @Nullable final BlockPos lllllllllllIlllllIlIIlIIlIllIlll, final int lllllllllllIlllllIlIIlIIlIlllIlI) {
                if (lllllllllllIlllllIlIIlIIlIllllII != null && lllllllllllIlllllIlIIlIIlIllIlll != null) {
                    return BiomeColorHelper.getGrassColorAtPos(lllllllllllIlllllIlIIlIIlIllllII, lllllllllllIlllllIlIIlIIlIllIlll);
                }
                return (lllllllllllIlllllIlIIlIIlIlllIIl.getValue(BlockTallGrass.TYPE) == BlockTallGrass.EnumType.DEAD_BUSH) ? 16777215 : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.TALLGRASS);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllIlllIlIlllIlIllIIllIIl, @Nullable final IBlockAccess llllllllllIlllIlIlllIlIllIIlIlIl, @Nullable final BlockPos llllllllllIlllIlIlllIlIllIIlIlll, final int llllllllllIlllIlIlllIlIllIIlIllI) {
                return (llllllllllIlllIlIlllIlIllIIlIlIl != null && llllllllllIlllIlIlllIlIllIIlIlll != null) ? BiomeColorHelper.getFoliageColorAtPos(llllllllllIlllIlIlllIlIllIIlIlIl, llllllllllIlllIlIlllIlIllIIlIlll) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.VINE);
        lllllllllllllllIIllIIlIllIlIlIll.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllllIIIlllllIlIIllIIlIlI, @Nullable final IBlockAccess llllllllllllIIIlllllIlIIllIIIllI, @Nullable final BlockPos llllllllllllIIIlllllIlIIllIIlIII, final int llllllllllllIIIlllllIlIIllIIIlll) {
                return (llllllllllllIIIlllllIlIIllIIIllI != null && llllllllllllIIIlllllIlIIllIIlIII != null) ? 2129968 : 7455580;
            }
        }, Blocks.WATERLILY);
        return lllllllllllllllIIllIIlIllIlIlIll;
    }
    
    public int colorMultiplier(final IBlockState lllllllllllllllIIllIIlIllIIIlIlI, @Nullable final IBlockAccess lllllllllllllllIIllIIlIllIIIlIIl, @Nullable final BlockPos lllllllllllllllIIllIIlIllIIIlllI, final int lllllllllllllllIIllIIlIllIIIIlll) {
        final IBlockColor lllllllllllllllIIllIIlIllIIIllII = this.mapBlockColors.getByValue(Block.getIdFromBlock(lllllllllllllllIIllIIlIllIIIlIlI.getBlock()));
        return (lllllllllllllllIIllIIlIllIIIllII == null) ? -1 : lllllllllllllllIIllIIlIllIIIllII.colorMultiplier(lllllllllllllllIIllIIlIllIIIlIlI, lllllllllllllllIIllIIlIllIIIlIIl, lllllllllllllllIIllIIlIllIIIlllI, lllllllllllllllIIllIIlIllIIIIlll);
    }
    
    public void registerBlockColorHandler(final IBlockColor lllllllllllllllIIllIIlIlIllllIIl, final Block... lllllllllllllllIIllIIlIlIllllIII) {
        final double lllllllllllllllIIllIIlIlIlllIlII = (Object)lllllllllllllllIIllIIlIlIllllIII;
        final boolean lllllllllllllllIIllIIlIlIlllIlIl = lllllllllllllllIIllIIlIlIllllIII.length != 0;
        for (byte lllllllllllllllIIllIIlIlIlllIllI = 0; lllllllllllllllIIllIIlIlIlllIllI < (lllllllllllllllIIllIIlIlIlllIlIl ? 1 : 0); ++lllllllllllllllIIllIIlIlIlllIllI) {
            final Block lllllllllllllllIIllIIlIlIllllIll = lllllllllllllllIIllIIlIlIlllIlII[lllllllllllllllIIllIIlIlIlllIllI];
            this.mapBlockColors.put(lllllllllllllllIIllIIlIlIllllIIl, Block.getIdFromBlock(lllllllllllllllIIllIIlIlIllllIll));
        }
    }
    
    public int getColor(final IBlockState lllllllllllllllIIllIIlIllIlIIIlI, final World lllllllllllllllIIllIIlIllIIllIll, final BlockPos lllllllllllllllIIllIIlIllIlIIIII) {
        final IBlockColor lllllllllllllllIIllIIlIllIIlllll = this.mapBlockColors.getByValue(Block.getIdFromBlock(lllllllllllllllIIllIIlIllIlIIIlI.getBlock()));
        if (lllllllllllllllIIllIIlIllIIlllll != null) {
            return lllllllllllllllIIllIIlIllIIlllll.colorMultiplier(lllllllllllllllIIllIIlIllIlIIIlI, null, null, 0);
        }
        final MapColor lllllllllllllllIIllIIlIllIIllllI = lllllllllllllllIIllIIlIllIlIIIlI.getMapColor(lllllllllllllllIIllIIlIllIIllIll, lllllllllllllllIIllIIlIllIlIIIII);
        return (lllllllllllllllIIllIIlIllIIllllI != null) ? lllllllllllllllIIllIIlIllIIllllI.colorValue : -1;
    }
}
