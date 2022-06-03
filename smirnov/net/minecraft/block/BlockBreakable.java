// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;

public class BlockBreakable extends Block
{
    private final /* synthetic */ boolean ignoreSimilarity;
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIllIIlllllllIIIlllIIl, final IBlockAccess lllllllllllIllIIlllllllIIIlllIII, final BlockPos lllllllllllIllIIlllllllIIIllIlll, final EnumFacing lllllllllllIllIIlllllllIIIllllIl) {
        final IBlockState lllllllllllIllIIlllllllIIIllllII = lllllllllllIllIIlllllllIIIlllIII.getBlockState(lllllllllllIllIIlllllllIIIllIlll.offset(lllllllllllIllIIlllllllIIIllllIl));
        final Block lllllllllllIllIIlllllllIIIlllIll = lllllllllllIllIIlllllllIIIllllII.getBlock();
        if (this == Blocks.GLASS || this == Blocks.STAINED_GLASS) {
            if (lllllllllllIllIIlllllllIIIlllIIl != lllllllllllIllIIlllllllIIIllllII) {
                return true;
            }
            if (lllllllllllIllIIlllllllIIIlllIll == this) {
                return false;
            }
        }
        return (this.ignoreSimilarity || lllllllllllIllIIlllllllIIIlllIll != this) && super.shouldSideBeRendered(lllllllllllIllIIlllllllIIIlllIIl, lllllllllllIllIIlllllllIIIlllIII, lllllllllllIllIIlllllllIIIllIlll, lllllllllllIllIIlllllllIIIllllIl);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIIlllllllIIlIIlIIl) {
        return false;
    }
    
    protected BlockBreakable(final Material lllllllllllIllIIlllllllIIlIllIII, final boolean lllllllllllIllIIlllllllIIlIllIlI) {
        this(lllllllllllIllIIlllllllIIlIllIII, lllllllllllIllIIlllllllIIlIllIlI, lllllllllllIllIIlllllllIIlIllIII.getMaterialMapColor());
    }
    
    protected BlockBreakable(final Material lllllllllllIllIIlllllllIIlIlIIIl, final boolean lllllllllllIllIIlllllllIIlIlIIII, final MapColor lllllllllllIllIIlllllllIIlIIllll) {
        super(lllllllllllIllIIlllllllIIlIlIIIl, lllllllllllIllIIlllllllIIlIIllll);
        this.ignoreSimilarity = lllllllllllIllIIlllllllIIlIlIIII;
    }
}
