// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

public class BlockSnowBlock extends Block
{
    protected BlockSnowBlock() {
        super(Material.CRAFTED_SNOW);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIllllIlIIIIIIIIIIllll) {
        return 4;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIllllIlIIIIIIIIIlIIll, final Random lllllllllllIllllIlIIIIIIIIIlIIlI, final int lllllllllllIllllIlIIIIIIIIIlIIIl) {
        return Items.SNOWBALL;
    }
    
    @Override
    public void updateTick(final World lllllllllllIllllIlIIIIIIIIIIIlIl, final BlockPos lllllllllllIllllIlIIIIIIIIIIlIIl, final IBlockState lllllllllllIllllIlIIIIIIIIIIlIII, final Random lllllllllllIllllIlIIIIIIIIIIIlll) {
        if (lllllllllllIllllIlIIIIIIIIIIIlIl.getLightFor(EnumSkyBlock.BLOCK, lllllllllllIllllIlIIIIIIIIIIlIIl) > 11) {
            this.dropBlockAsItem(lllllllllllIllllIlIIIIIIIIIIIlIl, lllllllllllIllllIlIIIIIIIIIIlIIl, lllllllllllIllllIlIIIIIIIIIIIlIl.getBlockState(lllllllllllIllllIlIIIIIIIIIIlIIl), 0);
            lllllllllllIllllIlIIIIIIIIIIIlIl.setBlockToAir(lllllllllllIllllIlIIIIIIIIIIlIIl);
        }
    }
}
