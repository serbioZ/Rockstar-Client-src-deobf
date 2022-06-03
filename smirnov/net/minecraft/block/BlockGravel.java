// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;

public class BlockGravel extends BlockFalling
{
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIlIlIllIlIllIIll, final IBlockAccess llllllllllllllIlIlIlIllIlIllIIlI, final BlockPos llllllllllllllIlIlIlIllIlIllIIIl) {
        return MapColor.STONE;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlIlIllIlIllIlll, final Random llllllllllllllIlIlIlIllIlIllIllI, int llllllllllllllIlIlIlIllIlIllIlIl) {
        if (llllllllllllllIlIlIlIllIlIllIlIl > 3) {
            llllllllllllllIlIlIlIllIlIllIlIl = 3;
        }
        return (llllllllllllllIlIlIlIllIlIllIllI.nextInt((int)(10 - llllllllllllllIlIlIlIllIlIllIlIl * 3)) == 0) ? Items.FLINT : super.getItemDropped(llllllllllllllIlIlIlIllIlIllIlll, llllllllllllllIlIlIlIllIlIllIllI, (int)llllllllllllllIlIlIlIllIlIllIlIl);
    }
    
    @Override
    public int getDustColor(final IBlockState llllllllllllllIlIlIlIllIlIlIllll) {
        return -8356741;
    }
}
