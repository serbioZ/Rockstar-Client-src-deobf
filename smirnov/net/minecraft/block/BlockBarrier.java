// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.IBlockState;

public class BlockBarrier extends Block
{
    @Override
    public float getAmbientOcclusionLightValue(final IBlockState lllllllllllIlllIllllIIIllIllllll) {
        return 1.0f;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIlllIllllIIIlllIIIIll) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIlllIllllIIIllIllllIl, final BlockPos lllllllllllIlllIllllIIIllIllllII, final IBlockState lllllllllllIlllIllllIIIllIlllIll, final float lllllllllllIlllIllllIIIllIlllIlI, final int lllllllllllIlllIllllIIIllIlllIIl) {
    }
    
    protected BlockBarrier() {
        super(Material.BARRIER);
        this.setBlockUnbreakable();
        this.setResistance(6000001.0f);
        this.disableStats();
        this.translucent = true;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllIllllIIIlllIIIIIl) {
        return false;
    }
}
