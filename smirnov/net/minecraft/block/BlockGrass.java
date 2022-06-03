// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;

public class BlockGrass extends Block implements IGrowable
{
    public static final /* synthetic */ PropertyBool SNOWY;
    
    protected BlockGrass() {
        super(Material.GRASS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockGrass.SNOWY, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIIlIlIlIllIllllIllll, final IBlockAccess lllllllllllIIIlIlIlIllIllllIlIlI, final BlockPos lllllllllllIIIlIlIlIllIllllIllIl) {
        final Block lllllllllllIIIlIlIlIllIllllIllII = lllllllllllIIIlIlIlIllIllllIlIlI.getBlockState(lllllllllllIIIlIlIlIllIllllIllIl.up()).getBlock();
        return lllllllllllIIIlIlIlIllIllllIllll.withProperty((IProperty<Comparable>)BlockGrass.SNOWY, lllllllllllIIIlIlIlIllIllllIllII == Blocks.SNOW || lllllllllllIIIlIlIlIllIllllIllII == Blocks.SNOW_LAYER);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public void updateTick(final World lllllllllllIIIlIlIlIllIlllIlIlll, final BlockPos lllllllllllIIIlIlIlIllIlllIllllI, final IBlockState lllllllllllIIIlIlIlIllIlllIlllIl, final Random lllllllllllIIIlIlIlIllIlllIlllII) {
        if (!lllllllllllIIIlIlIlIllIlllIlIlll.isRemote) {
            if (lllllllllllIIIlIlIlIllIlllIlIlll.getLightFromNeighbors(lllllllllllIIIlIlIlIllIlllIllllI.up()) < 4 && lllllllllllIIIlIlIlIllIlllIlIlll.getBlockState(lllllllllllIIIlIlIlIllIlllIllllI.up()).getLightOpacity() > 2) {
                lllllllllllIIIlIlIlIllIlllIlIlll.setBlockState(lllllllllllIIIlIlIlIllIlllIllllI, Blocks.DIRT.getDefaultState());
            }
            else if (lllllllllllIIIlIlIlIllIlllIlIlll.getLightFromNeighbors(lllllllllllIIIlIlIlIllIlllIllllI.up()) >= 9) {
                for (int lllllllllllIIIlIlIlIllIlllIllIll = 0; lllllllllllIIIlIlIlIllIlllIllIll < 4; ++lllllllllllIIIlIlIlIllIlllIllIll) {
                    final BlockPos lllllllllllIIIlIlIlIllIlllIllIlI = lllllllllllIIIlIlIlIllIlllIllllI.add(lllllllllllIIIlIlIlIllIlllIlllII.nextInt(3) - 1, lllllllllllIIIlIlIlIllIlllIlllII.nextInt(5) - 3, lllllllllllIIIlIlIlIllIlllIlllII.nextInt(3) - 1);
                    if (lllllllllllIIIlIlIlIllIlllIllIlI.getY() >= 0 && lllllllllllIIIlIlIlIllIlllIllIlI.getY() < 256 && !lllllllllllIIIlIlIlIllIlllIlIlll.isBlockLoaded(lllllllllllIIIlIlIlIllIlllIllIlI)) {
                        return;
                    }
                    final IBlockState lllllllllllIIIlIlIlIllIlllIllIIl = lllllllllllIIIlIlIlIllIlllIlIlll.getBlockState(lllllllllllIIIlIlIlIllIlllIllIlI.up());
                    final IBlockState lllllllllllIIIlIlIlIllIlllIllIII = lllllllllllIIIlIlIlIllIlllIlIlll.getBlockState(lllllllllllIIIlIlIlIllIlllIllIlI);
                    if (lllllllllllIIIlIlIlIllIlllIllIII.getBlock() == Blocks.DIRT && lllllllllllIIIlIlIlIllIlllIllIII.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && lllllllllllIIIlIlIlIllIlllIlIlll.getLightFromNeighbors(lllllllllllIIIlIlIlIllIlllIllIlI.up()) >= 4 && lllllllllllIIIlIlIlIllIlllIllIIl.getLightOpacity() <= 2) {
                        lllllllllllIIIlIlIlIllIlllIlIlll.setBlockState(lllllllllllIIIlIlIlIllIlllIllIlI, Blocks.GRASS.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public boolean canGrow(final World lllllllllllIIIlIlIlIllIlllIIIlll, final BlockPos lllllllllllIIIlIlIlIllIlllIIIllI, final IBlockState lllllllllllIIIlIlIlIllIlllIIIlIl, final boolean lllllllllllIIIlIlIlIllIlllIIIlII) {
        return true;
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllIIIlIlIlIllIlllIIIIlI, final Random lllllllllllIIIlIlIlIllIlllIIIIIl, final BlockPos lllllllllllIIIlIlIlIllIlllIIIIII, final IBlockState lllllllllllIIIlIlIlIllIllIllllll) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockGrass.SNOWY });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIlIlIllIllIIllIll) {
        return 0;
    }
    
    static {
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public void grow(final World lllllllllllIIIlIlIlIllIllIllIIll, final Random lllllllllllIIIlIlIlIllIllIlIIllI, final BlockPos lllllllllllIIIlIlIlIllIllIlIIlIl, final IBlockState lllllllllllIIIlIlIlIllIllIllIIII) {
        final BlockPos lllllllllllIIIlIlIlIllIllIlIllll = lllllllllllIIIlIlIlIllIllIlIIlIl.up();
        int lllllllllllIIIlIlIlIllIllIlIlllI = 0;
    Label_0252_Outer:
        while (lllllllllllIIIlIlIlIllIllIlIlllI < 128) {
            BlockPos lllllllllllIIIlIlIlIllIllIlIllIl = lllllllllllIIIlIlIlIllIllIlIllll;
            int lllllllllllIIIlIlIlIllIllIlIllII = 0;
            while (true) {
                while (lllllllllllIIIlIlIlIllIllIlIllII < lllllllllllIIIlIlIlIllIllIlIlllI / 16) {
                    lllllllllllIIIlIlIlIllIllIlIllIl = lllllllllllIIIlIlIlIllIllIlIllIl.add(lllllllllllIIIlIlIlIllIllIlIIllI.nextInt(3) - 1, (lllllllllllIIIlIlIlIllIllIlIIllI.nextInt(3) - 1) * lllllllllllIIIlIlIlIllIllIlIIllI.nextInt(3) / 2, lllllllllllIIIlIlIlIllIllIlIIllI.nextInt(3) - 1);
                    if (lllllllllllIIIlIlIlIllIllIllIIll.getBlockState(lllllllllllIIIlIlIlIllIllIlIllIl.down()).getBlock() == Blocks.GRASS) {
                        if (!lllllllllllIIIlIlIlIllIllIllIIll.getBlockState(lllllllllllIIIlIlIlIllIllIlIllIl).isNormalCube()) {
                            ++lllllllllllIIIlIlIlIllIllIlIllII;
                            continue Label_0252_Outer;
                        }
                    }
                    ++lllllllllllIIIlIlIlIllIllIlIlllI;
                    continue Label_0252_Outer;
                }
                if (lllllllllllIIIlIlIlIllIllIllIIll.getBlockState(lllllllllllIIIlIlIlIllIllIlIllIl).getBlock().blockMaterial != Material.AIR) {
                    continue;
                }
                if (lllllllllllIIIlIlIlIllIllIlIIllI.nextInt(8) == 0) {
                    final BlockFlower.EnumFlowerType lllllllllllIIIlIlIlIllIllIlIlIll = lllllllllllIIIlIlIlIllIllIllIIll.getBiome(lllllllllllIIIlIlIlIllIllIlIllIl).pickRandomFlower(lllllllllllIIIlIlIlIllIllIlIIllI, lllllllllllIIIlIlIlIllIllIlIllIl);
                    final BlockFlower lllllllllllIIIlIlIlIllIllIlIlIlI = lllllllllllIIIlIlIlIllIllIlIlIll.getBlockType().getBlock();
                    final IBlockState lllllllllllIIIlIlIlIllIllIlIlIIl = lllllllllllIIIlIlIlIllIllIlIlIlI.getDefaultState().withProperty(lllllllllllIIIlIlIlIllIllIlIlIlI.getTypeProperty(), lllllllllllIIIlIlIlIllIllIlIlIll);
                    if (lllllllllllIIIlIlIlIllIllIlIlIlI.canBlockStay(lllllllllllIIIlIlIlIllIllIllIIll, lllllllllllIIIlIlIlIllIllIlIllIl, lllllllllllIIIlIlIlIllIllIlIlIIl)) {
                        lllllllllllIIIlIlIlIllIllIllIIll.setBlockState(lllllllllllIIIlIlIlIllIllIlIllIl, lllllllllllIIIlIlIlIllIllIlIlIIl, 3);
                    }
                    continue;
                }
                else {
                    final IBlockState lllllllllllIIIlIlIlIllIllIlIlIII = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
                    if (Blocks.TALLGRASS.canBlockStay(lllllllllllIIIlIlIlIllIllIllIIll, lllllllllllIIIlIlIlIllIllIlIllIl, lllllllllllIIIlIlIlIllIllIlIlIII)) {
                        lllllllllllIIIlIlIlIllIllIllIIll.setBlockState(lllllllllllIIIlIlIlIllIllIlIllIl, lllllllllllIIIlIlIlIllIllIlIlIII, 3);
                    }
                    continue;
                }
                break;
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIlIlIlIllIlllIIllIl, final Random lllllllllllIIIlIlIlIllIlllIIllII, final int lllllllllllIIIlIlIlIllIlllIIlIll) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllIIIlIlIlIllIlllIIllII, lllllllllllIIIlIlIlIllIlllIIlIll);
    }
}
