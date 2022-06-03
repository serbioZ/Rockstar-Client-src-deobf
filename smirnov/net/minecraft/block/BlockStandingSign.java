// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyInteger;

public class BlockStandingSign extends BlockSign
{
    public static final /* synthetic */ PropertyInteger ROTATION;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIIIIlIllllIIIIlIIIl) {
        return lllllllllllIIIIIIlIllllIIIIlIIIl.getValue((IProperty<Integer>)BlockStandingSign.ROTATION);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStandingSign.ROTATION });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIIIIlIllllIIIIlIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllIIIIIIlIllllIIIIlIlIl);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIIIIIlIllllIIIIIIllI, final Mirror lllllllllllIIIIIIlIllllIIIIIIlIl) {
        return lllllllllllIIIIIIlIllllIIIIIIllI.withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllIIIIIIlIllllIIIIIIlIl.mirrorRotation(lllllllllllIIIIIIlIllllIIIIIIllI.getValue((IProperty<Integer>)BlockStandingSign.ROTATION), 16));
    }
    
    public BlockStandingSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, 0));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIIIIIlIllllIIIIIlIll, final Rotation lllllllllllIIIIIIlIllllIIIIIlIlI) {
        return lllllllllllIIIIIIlIllllIIIIIlIll.withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllIIIIIIlIllllIIIIIlIlI.rotate(lllllllllllIIIIIIlIllllIIIIIlIll.getValue((IProperty<Integer>)BlockStandingSign.ROTATION), 16));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIIIIIlIllllIIIIlllll, final World lllllllllllIIIIIIlIllllIIIIllllI, final BlockPos lllllllllllIIIIIIlIllllIIIIlllIl, final Block lllllllllllIIIIIIlIllllIIIIlllII, final BlockPos lllllllllllIIIIIIlIllllIIIIllIll) {
        if (!lllllllllllIIIIIIlIllllIIIIllllI.getBlockState(lllllllllllIIIIIIlIllllIIIIlllIl.down()).getMaterial().isSolid()) {
            this.dropBlockAsItem(lllllllllllIIIIIIlIllllIIIIllllI, lllllllllllIIIIIIlIllllIIIIlllIl, lllllllllllIIIIIIlIllllIIIIlllll, 0);
            lllllllllllIIIIIIlIllllIIIIllllI.setBlockToAir(lllllllllllIIIIIIlIllllIIIIlllIl);
        }
        super.neighborChanged(lllllllllllIIIIIIlIllllIIIIlllll, lllllllllllIIIIIIlIllllIIIIllllI, lllllllllllIIIIIIlIllllIIIIlllIl, lllllllllllIIIIIIlIllllIIIIlllII, lllllllllllIIIIIIlIllllIIIIllIll);
    }
    
    static {
        ROTATION = PropertyInteger.create("rotation", 0, 15);
    }
}
