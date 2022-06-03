// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockStructureVoid extends Block
{
    private static final /* synthetic */ AxisAlignedBB STRUCTURE_VOID_AABB;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIlIIIllIIlllIIIl, final IBlockAccess lllllllllllllllIIlIIIllIIlllIIII, final BlockPos lllllllllllllllIIlIIIllIIllIllll) {
        return BlockStructureVoid.STRUCTURE_VOID_AABB;
    }
    
    protected BlockStructureVoid() {
        super(Material.STRUCTURE_VOID);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIIlIIIllIIlllIlll) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public float getAmbientOcclusionLightValue(final IBlockState lllllllllllllllIIlIIIllIIllIlIIl) {
        return 1.0f;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllllIIlIIIllIIllIIIIl) {
        return EnumPushReaction.DESTROY;
    }
    
    static {
        STRUCTURE_VOID_AABB = new AxisAlignedBB(0.3, 0.3, 0.3, 0.7, 0.7, 0.7);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIlIIIllIIllIllIl) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIlIIIllIIllIlIll) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIIlIIIllIIlllIlIl, final IBlockAccess lllllllllllllllIIlIIIllIIlllIlII, final BlockPos lllllllllllllllIIlIIIllIIlllIIll) {
        return BlockStructureVoid.NULL_AABB;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIIlIIIllIIllIIlll, final BlockPos lllllllllllllllIIlIIIllIIllIIllI, final IBlockState lllllllllllllllIIlIIIllIIllIIlIl, final float lllllllllllllllIIlIIIllIIllIIlII, final int lllllllllllllllIIlIIIllIIllIIIll) {
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIlIIIllIIlIlllll, final IBlockState lllllllllllllllIIlIIIllIIlIllllI, final BlockPos lllllllllllllllIIlIIIllIIlIlllIl, final EnumFacing lllllllllllllllIIlIIIllIIlIlllII) {
        return BlockFaceShape.UNDEFINED;
    }
}
