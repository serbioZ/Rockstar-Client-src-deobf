// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.math.MathHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.IBlockAccess;

public class SwimNodeProcessor extends NodeProcessor
{
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess lllllllllllIlIlIIIllIlIIlIlllIll, final int lllllllllllIlIlIIIllIlIIlIlllIlI, final int lllllllllllIlIlIIIllIlIIlIlllIIl, final int lllllllllllIlIlIIIllIlIIlIlllIII, final EntityLiving lllllllllllIlIlIIIllIlIIlIllIlll, final int lllllllllllIlIlIIIllIlIIlIllIllI, final int lllllllllllIlIlIIIllIlIIlIllIlIl, final int lllllllllllIlIlIIIllIlIIlIllIlII, final boolean lllllllllllIlIlIIIllIlIIlIllIIll, final boolean lllllllllllIlIlIIIllIlIIlIllIIlI) {
        return PathNodeType.WATER;
    }
    
    @Override
    public int findPathOptions(final PathPoint[] lllllllllllIlIlIIIllIlIIllIIlllI, final PathPoint lllllllllllIlIlIIIllIlIIllIIIlIl, final PathPoint lllllllllllIlIlIIIllIlIIllIIllII, final float lllllllllllIlIlIIIllIlIIllIIIIll) {
        int lllllllllllIlIlIIIllIlIIllIIlIlI = 0;
        final double lllllllllllIlIlIIIllIlIIlIlllllI;
        final boolean lllllllllllIlIlIIIllIlIIlIllllll = ((EnumFacing[])(Object)(lllllllllllIlIlIIIllIlIIlIlllllI = (double)(Object)EnumFacing.values())).length != 0;
        for (Exception lllllllllllIlIlIIIllIlIIllIIIIII = (Exception)0; lllllllllllIlIlIIIllIlIIllIIIIII < lllllllllllIlIlIIIllIlIIlIllllll; ++lllllllllllIlIlIIIllIlIIllIIIIII) {
            final EnumFacing lllllllllllIlIlIIIllIlIIllIIlIIl = lllllllllllIlIlIIIllIlIIlIlllllI[lllllllllllIlIlIIIllIlIIllIIIIII];
            final PathPoint lllllllllllIlIlIIIllIlIIllIIlIII = this.getWaterNode(lllllllllllIlIlIIIllIlIIllIIIlIl.xCoord + lllllllllllIlIlIIIllIlIIllIIlIIl.getFrontOffsetX(), lllllllllllIlIlIIIllIlIIllIIIlIl.yCoord + lllllllllllIlIlIIIllIlIIllIIlIIl.getFrontOffsetY(), lllllllllllIlIlIIIllIlIIllIIIlIl.zCoord + lllllllllllIlIlIIIllIlIIllIIlIIl.getFrontOffsetZ());
            if (lllllllllllIlIlIIIllIlIIllIIlIII != null && !lllllllllllIlIlIIIllIlIIllIIlIII.visited && lllllllllllIlIlIIIllIlIIllIIlIII.distanceTo(lllllllllllIlIlIIIllIlIIllIIllII) < lllllllllllIlIlIIIllIlIIllIIIIll) {
                lllllllllllIlIlIIIllIlIIllIIlllI[lllllllllllIlIlIIIllIlIIllIIlIlI++] = lllllllllllIlIlIIIllIlIIllIIlIII;
            }
        }
        return lllllllllllIlIlIIIllIlIIllIIlIlI;
    }
    
    @Nullable
    private PathPoint getWaterNode(final int lllllllllllIlIlIIIllIlIIlIlIIllI, final int lllllllllllIlIlIIIllIlIIlIlIIIII, final int lllllllllllIlIlIIIllIlIIlIlIIlII) {
        final PathNodeType lllllllllllIlIlIIIllIlIIlIlIIIll = this.isFree(lllllllllllIlIlIIIllIlIIlIlIIllI, lllllllllllIlIlIIIllIlIIlIlIIIII, lllllllllllIlIlIIIllIlIIlIlIIlII);
        return (lllllllllllIlIlIIIllIlIIlIlIIIll == PathNodeType.WATER) ? this.openPoint(lllllllllllIlIlIIIllIlIIlIlIIllI, lllllllllllIlIlIIIllIlIIlIlIIIII, lllllllllllIlIlIIIllIlIIlIlIIlII) : null;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess lllllllllllIlIlIIIllIlIIlIllIIII, final int lllllllllllIlIlIIIllIlIIlIlIllll, final int lllllllllllIlIlIIIllIlIIlIlIlllI, final int lllllllllllIlIlIIIllIlIIlIlIllIl) {
        return PathNodeType.WATER;
    }
    
    private PathNodeType isFree(final int lllllllllllIlIlIIIllIlIIlIIIlIlI, final int lllllllllllIlIlIIIllIlIIlIIlIIlI, final int lllllllllllIlIlIIIllIlIIlIIlIIIl) {
        final BlockPos.MutableBlockPos lllllllllllIlIlIIIllIlIIlIIlIIII = new BlockPos.MutableBlockPos();
        for (int lllllllllllIlIlIIIllIlIIlIIIllll = lllllllllllIlIlIIIllIlIIlIIIlIlI; lllllllllllIlIlIIIllIlIIlIIIllll < lllllllllllIlIlIIIllIlIIlIIIlIlI + this.entitySizeX; ++lllllllllllIlIlIIIllIlIIlIIIllll) {
            for (int lllllllllllIlIlIIIllIlIIlIIIlllI = lllllllllllIlIlIIIllIlIIlIIlIIlI; lllllllllllIlIlIIIllIlIIlIIIlllI < lllllllllllIlIlIIIllIlIIlIIlIIlI + this.entitySizeY; ++lllllllllllIlIlIIIllIlIIlIIIlllI) {
                for (int lllllllllllIlIlIIIllIlIIlIIIllIl = lllllllllllIlIlIIIllIlIIlIIlIIIl; lllllllllllIlIlIIIllIlIIlIIIllIl < lllllllllllIlIlIIIllIlIIlIIlIIIl + this.entitySizeZ; ++lllllllllllIlIlIIIllIlIIlIIIllIl) {
                    final IBlockState lllllllllllIlIlIIIllIlIIlIIIllII = this.blockaccess.getBlockState(lllllllllllIlIlIIIllIlIIlIIlIIII.setPos(lllllllllllIlIlIIIllIlIIlIIIllll, lllllllllllIlIlIIIllIlIIlIIIlllI, lllllllllllIlIlIIIllIlIIlIIIllIl));
                    if (lllllllllllIlIlIIIllIlIIlIIIllII.getMaterial() != Material.WATER) {
                        return PathNodeType.BLOCKED;
                    }
                }
            }
        }
        return PathNodeType.WATER;
    }
    
    @Override
    public PathPoint getPathPointToCoords(final double lllllllllllIlIlIIIllIlIIlllIIIIl, final double lllllllllllIlIlIIIllIlIIlllIIIII, final double lllllllllllIlIlIIIllIlIIllIllIll) {
        return this.openPoint(MathHelper.floor(lllllllllllIlIlIIIllIlIIlllIIIIl - this.entity.width / 2.0f), MathHelper.floor(lllllllllllIlIlIIIllIlIIlllIIIII + 0.5), MathHelper.floor(lllllllllllIlIlIIIllIlIIllIllIll - this.entity.width / 2.0f));
    }
    
    @Override
    public PathPoint getStart() {
        return this.openPoint(MathHelper.floor(this.entity.getEntityBoundingBox().minX), MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5), MathHelper.floor(this.entity.getEntityBoundingBox().minZ));
    }
}
