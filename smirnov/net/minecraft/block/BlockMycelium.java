// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;

public class BlockMycelium extends Block
{
    public static final /* synthetic */ PropertyBool SNOWY;
    
    static {
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIlIlIIIllIlIlllllIlIl, final IBlockAccess lllllllllllIlIlIIIllIlIlllllIlII, final BlockPos lllllllllllIlIlIIIllIlIllllIllll) {
        final Block lllllllllllIlIlIIIllIlIlllllIIlI = lllllllllllIlIlIIIllIlIlllllIlII.getBlockState(lllllllllllIlIlIIIllIlIllllIllll.up()).getBlock();
        return lllllllllllIlIlIIIllIlIlllllIlIl.withProperty((IProperty<Comparable>)BlockMycelium.SNOWY, lllllllllllIlIlIIIllIlIlllllIIlI == Blocks.SNOW || lllllllllllIlIlIIIllIlIlllllIIlI == Blocks.SNOW_LAYER);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIlIIIllIlIllIllllII) {
        return 0;
    }
    
    protected BlockMycelium() {
        super(Material.GRASS, MapColor.PURPLE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockMycelium.SNOWY, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void updateTick(final World lllllllllllIlIlIIIllIlIllllIIlII, final BlockPos lllllllllllIlIlIIIllIlIlllIllIlI, final IBlockState lllllllllllIlIlIIIllIlIllllIIIlI, final Random lllllllllllIlIlIIIllIlIlllIllIIl) {
        if (!lllllllllllIlIlIIIllIlIllllIIlII.isRemote) {
            if (lllllllllllIlIlIIIllIlIllllIIlII.getLightFromNeighbors(lllllllllllIlIlIIIllIlIlllIllIlI.up()) < 4 && lllllllllllIlIlIIIllIlIllllIIlII.getBlockState(lllllllllllIlIlIIIllIlIlllIllIlI.up()).getLightOpacity() > 2) {
                lllllllllllIlIlIIIllIlIllllIIlII.setBlockState(lllllllllllIlIlIIIllIlIlllIllIlI, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
            }
            else if (lllllllllllIlIlIIIllIlIllllIIlII.getLightFromNeighbors(lllllllllllIlIlIIIllIlIlllIllIlI.up()) >= 9) {
                for (int lllllllllllIlIlIIIllIlIllllIIIII = 0; lllllllllllIlIlIIIllIlIllllIIIII < 4; ++lllllllllllIlIlIIIllIlIllllIIIII) {
                    final BlockPos lllllllllllIlIlIIIllIlIlllIlllll = lllllllllllIlIlIIIllIlIlllIllIlI.add(lllllllllllIlIlIIIllIlIlllIllIIl.nextInt(3) - 1, lllllllllllIlIlIIIllIlIlllIllIIl.nextInt(5) - 3, lllllllllllIlIlIIIllIlIlllIllIIl.nextInt(3) - 1);
                    final IBlockState lllllllllllIlIlIIIllIlIlllIllllI = lllllllllllIlIlIIIllIlIllllIIlII.getBlockState(lllllllllllIlIlIIIllIlIlllIlllll);
                    final IBlockState lllllllllllIlIlIIIllIlIlllIlllIl = lllllllllllIlIlIIIllIlIllllIIlII.getBlockState(lllllllllllIlIlIIIllIlIlllIlllll.up());
                    if (lllllllllllIlIlIIIllIlIlllIllllI.getBlock() == Blocks.DIRT && lllllllllllIlIlIIIllIlIlllIllllI.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && lllllllllllIlIlIIIllIlIllllIIlII.getLightFromNeighbors(lllllllllllIlIlIIIllIlIlllIlllll.up()) >= 4 && lllllllllllIlIlIIIllIlIlllIlllIl.getLightOpacity() <= 2) {
                        lllllllllllIlIlIIIllIlIllllIIlII.setBlockState(lllllllllllIlIlIIIllIlIlllIlllll, this.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlIlIIIllIlIlllIIIIlI, final Random lllllllllllIlIlIIIllIlIllIllllll, final int lllllllllllIlIlIIIllIlIlllIIIIII) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllIlIlIIIllIlIllIllllll, lllllllllllIlIlIIIllIlIlllIIIIII);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockMycelium.SNOWY });
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIlIIIllIlIlllIIlIIl, final World lllllllllllIlIlIIIllIlIlllIIlIII, final BlockPos lllllllllllIlIlIIIllIlIlllIIllII, final Random lllllllllllIlIlIIIllIlIlllIIIllI) {
        super.randomDisplayTick(lllllllllllIlIlIIIllIlIlllIIlIIl, lllllllllllIlIlIIIllIlIlllIIlIII, lllllllllllIlIlIIIllIlIlllIIllII, lllllllllllIlIlIIIllIlIlllIIIllI);
        if (lllllllllllIlIlIIIllIlIlllIIIllI.nextInt(10) == 0) {
            lllllllllllIlIlIIIllIlIlllIIlIII.spawnParticle(EnumParticleTypes.TOWN_AURA, lllllllllllIlIlIIIllIlIlllIIllII.getX() + lllllllllllIlIlIIIllIlIlllIIIllI.nextFloat(), lllllllllllIlIlIIIllIlIlllIIllII.getY() + 1.1f, lllllllllllIlIlIIIllIlIlllIIllII.getZ() + lllllllllllIlIlIIIllIlIlllIIIllI.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
}
