// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockCompressedPowered extends Block
{
    public BlockCompressedPowered(final Material lllllllllllIlllIIlllllIIIlllIIll, final MapColor lllllllllllIlllIIlllllIIIllIllll) {
        super(lllllllllllIlllIIlllllIIIlllIIll, lllllllllllIlllIIlllllIIIllIllll);
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIlllIIlllllIIIllIlIll, final IBlockAccess lllllllllllIlllIIlllllIIIllIlIlI, final BlockPos lllllllllllIlllIIlllllIIIllIlIIl, final EnumFacing lllllllllllIlllIIlllllIIIllIlIII) {
        return 15;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIlllIIlllllIIIllIllIl) {
        return true;
    }
}
