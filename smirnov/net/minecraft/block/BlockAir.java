// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import java.util.IdentityHashMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import java.util.Map;

public class BlockAir extends Block
{
    private static /* synthetic */ Map mapOriginalOpacity;
    
    public static void setLightOpacity(final Block lllllllllllIlllIIlIlIIIIllIllIll, final int lllllllllllIlllIIlIlIIIIllIllIlI) {
        if (!BlockAir.mapOriginalOpacity.containsKey(lllllllllllIlllIIlIlIIIIllIllIll)) {
            BlockAir.mapOriginalOpacity.put(lllllllllllIlllIIlIlIIIIllIllIll, lllllllllllIlllIIlIlIIIIllIllIll.lightOpacity);
        }
        lllllllllllIlllIIlIlIIIIllIllIll.lightOpacity = lllllllllllIlllIIlIlIIIIllIllIlI;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllIlllIIlIlIIIIlllIIIIl, final BlockPos lllllllllllIlllIIlIlIIIIlllIIIII) {
        return true;
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lllllllllllIlllIIlIlIIIIlllIlIlI, final boolean lllllllllllIlllIIlIlIIIIlllIlIIl) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlllIIlIlIIIIllIllllI) {
        return false;
    }
    
    static {
        BlockAir.mapOriginalOpacity = new IdentityHashMap();
    }
    
    protected BlockAir() {
        super(Material.AIR);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIlllIIlIlIIIIlllIIlll, final BlockPos lllllllllllIlllIIlIlIIIIlllIIllI, final IBlockState lllllllllllIlllIIlIlIIIIlllIIlIl, final float lllllllllllIlllIIlIlIIIIlllIIlII, final int lllllllllllIlllIIlIlIIIIlllIIIll) {
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIlllIIlIlIIIIllllIIlI) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    public static void restoreLightOpacity(final Block lllllllllllIlllIIlIlIIIIllIlIIll) {
        if (BlockAir.mapOriginalOpacity.containsKey(lllllllllllIlllIIlIlIIIIllIlIIll)) {
            final int lllllllllllIlllIIlIlIIIIllIlIlII = BlockAir.mapOriginalOpacity.get(lllllllllllIlllIIlIlIIIIllIlIIll);
            setLightOpacity(lllllllllllIlllIIlIlIIIIllIlIIll, lllllllllllIlllIIlIlIIIIllIlIlII);
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIlllIIlIlIIIIllllIIII, final IBlockAccess lllllllllllIlllIIlIlIIIIlllIllll, final BlockPos lllllllllllIlllIIlIlIIIIlllIlllI) {
        return BlockAir.NULL_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlllIIlIlIIIIllIlIIII, final IBlockState lllllllllllIlllIIlIlIIIIllIIllll, final BlockPos lllllllllllIlllIIlIlIIIIllIIlllI, final EnumFacing lllllllllllIlllIIlIlIIIIllIIllIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllIIlIlIIIIlllIllII) {
        return false;
    }
}
