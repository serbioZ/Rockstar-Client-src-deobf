// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nullable;
import net.minecraft.util.Mirror;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IBlockProperties
{
    boolean shouldSideBeRendered(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    boolean isFullyOpaque();
    
    IBlockState withRotation(final Rotation p0);
    
    RayTraceResult collisionRayTrace(final World p0, final BlockPos p1, final Vec3d p2, final Vec3d p3);
    
    EnumPushReaction getMobilityFlag();
    
    BlockFaceShape func_193401_d(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    void addCollisionBoxToList(final World p0, final BlockPos p1, final AxisAlignedBB p2, final List<AxisAlignedBB> p3, final Entity p4, final boolean p5);
    
    Vec3d func_191059_e(final IBlockAccess p0, final BlockPos p1);
    
    EnumBlockRenderType getRenderType();
    
    boolean isFullCube();
    
    int getWeakPower(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    boolean isFullBlock();
    
    boolean isTranslucent();
    
    boolean func_191057_i();
    
    AxisAlignedBB getBoundingBox(final IBlockAccess p0, final BlockPos p1);
    
    float getBlockHardness(final World p0, final BlockPos p1);
    
    boolean isBlockNormalCube();
    
    boolean useNeighborBrightness();
    
    IBlockState getActualState(final IBlockAccess p0, final BlockPos p1);
    
    int getStrongPower(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    boolean func_191058_s();
    
    boolean isNormalCube();
    
    AxisAlignedBB getSelectedBoundingBox(final World p0, final BlockPos p1);
    
    Material getMaterial();
    
    MapColor getMapColor(final IBlockAccess p0, final BlockPos p1);
    
    IBlockState withMirror(final Mirror p0);
    
    int getLightOpacity();
    
    @Nullable
    AxisAlignedBB getCollisionBoundingBox(final IBlockAccess p0, final BlockPos p1);
    
    int getPackedLightmapCoords(final IBlockAccess p0, final BlockPos p1);
    
    boolean hasComparatorInputOverride();
    
    int getComparatorInputOverride(final World p0, final BlockPos p1);
    
    boolean canEntitySpawn(final Entity p0);
    
    boolean canProvidePower();
    
    float getPlayerRelativeBlockHardness(final EntityPlayer p0, final World p1, final BlockPos p2);
    
    int getLightValue();
    
    float getAmbientOcclusionLightValue();
    
    boolean isOpaqueCube();
}
