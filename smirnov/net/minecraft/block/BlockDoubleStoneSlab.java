// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;

public class BlockDoubleStoneSlab extends BlockStoneSlab
{
    @Override
    public boolean isDouble() {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIIlllIIIlllIIIlI, final IBlockState llllllllllllllIIIIlllIIIlllIIIIl, final BlockPos llllllllllllllIIIIlllIIIlllIIIII, final EnumFacing llllllllllllllIIIIlllIIIllIlllll) {
        return BlockFaceShape.SOLID;
    }
}
