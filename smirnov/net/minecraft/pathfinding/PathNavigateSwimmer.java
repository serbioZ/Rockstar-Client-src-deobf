// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;

public class PathNavigateSwimmer extends PathNavigate
{
    @Override
    public boolean canEntityStandOnPos(final BlockPos lllllllllllllIllllIlIllIIIIIlIIl) {
        return !this.worldObj.getBlockState(lllllllllllllIllllIlIllIIIIIlIIl).isFullBlock();
    }
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.theEntity.posY + this.theEntity.height * 0.5, this.theEntity.posZ);
    }
    
    public PathNavigateSwimmer(final EntityLiving lllllllllllllIllllIlIllIIIlllIll, final World lllllllllllllIllllIlIllIIIlllIlI) {
        super(lllllllllllllIllllIlIllIIIlllIll, lllllllllllllIllllIlIllIIIlllIlI);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d lllllllllllllIllllIlIllIIIIllIII, final Vec3d lllllllllllllIllllIlIllIIIIlIlll, final int lllllllllllllIllllIlIllIIIIlIllI, final int lllllllllllllIllllIlIllIIIIlIlIl, final int lllllllllllllIllllIlIllIIIIlIlII) {
        final RayTraceResult lllllllllllllIllllIlIllIIIIlIIll = this.worldObj.rayTraceBlocks(lllllllllllllIllllIlIllIIIIllIII, new Vec3d(lllllllllllllIllllIlIllIIIIlIlll.xCoord, lllllllllllllIllllIlIllIIIIlIlll.yCoord + this.theEntity.height * 0.5, lllllllllllllIllllIlIllIIIIlIlll.zCoord), false, true, false);
        return lllllllllllllIllllIlIllIIIIlIIll == null || lllllllllllllIllllIlIllIIIIlIIll.typeOfHit == RayTraceResult.Type.MISS;
    }
    
    @Override
    protected void pathFollow() {
        final Vec3d lllllllllllllIllllIlIllIIIlIlIII = this.getEntityPosition();
        final float lllllllllllllIllllIlIllIIIlIIlll = this.theEntity.width * this.theEntity.width;
        final int lllllllllllllIllllIlIllIIIlIIllI = 6;
        if (lllllllllllllIllllIlIllIIIlIlIII.squareDistanceTo(this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex())) < lllllllllllllIllllIlIllIIIlIIlll) {
            this.currentPath.incrementPathIndex();
        }
        for (int lllllllllllllIllllIlIllIIIlIIlIl = Math.min(this.currentPath.getCurrentPathIndex() + 6, this.currentPath.getCurrentPathLength() - 1); lllllllllllllIllllIlIllIIIlIIlIl > this.currentPath.getCurrentPathIndex(); --lllllllllllllIllllIlIllIIIlIIlIl) {
            final Vec3d lllllllllllllIllllIlIllIIIlIIlII = this.currentPath.getVectorFromIndex(this.theEntity, lllllllllllllIllllIlIllIIIlIIlIl);
            if (lllllllllllllIllllIlIllIIIlIIlII.squareDistanceTo(lllllllllllllIllllIlIllIIIlIlIII) <= 36.0 && this.isDirectPathBetweenPoints(lllllllllllllIllllIlIllIIIlIlIII, lllllllllllllIllllIlIllIIIlIIlII, 0, 0, 0)) {
                this.currentPath.setCurrentPathIndex(lllllllllllllIllllIlIllIIIlIIlIl);
                break;
            }
        }
        this.checkForStuck(lllllllllllllIllllIlIllIIIlIlIII);
    }
    
    @Override
    protected PathFinder getPathFinder() {
        return new PathFinder(new SwimNodeProcessor());
    }
    
    @Override
    protected boolean canNavigate() {
        return this.isInLiquid();
    }
}
