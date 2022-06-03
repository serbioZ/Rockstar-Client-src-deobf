// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;

public class PathNavigateGround extends PathNavigate
{
    private /* synthetic */ boolean shouldAvoidSun;
    
    public void setCanSwim(final boolean llllllllllIlllllIIllllIlIlIIIIII) {
        this.nodeProcessor.setCanSwim(llllllllllIlllllIIllllIlIlIIIIII);
    }
    
    @Override
    public Path getPathToPos(BlockPos llllllllllIlllllIIlllllIIIIlIIll) {
        if (this.worldObj.getBlockState((BlockPos)llllllllllIlllllIIlllllIIIIlIIll).getMaterial() == Material.AIR) {
            BlockPos llllllllllIlllllIIlllllIIIIlIllI;
            for (llllllllllIlllllIIlllllIIIIlIllI = ((BlockPos)llllllllllIlllllIIlllllIIIIlIIll).down(); llllllllllIlllllIIlllllIIIIlIllI.getY() > 0 && this.worldObj.getBlockState(llllllllllIlllllIIlllllIIIIlIllI).getMaterial() == Material.AIR; llllllllllIlllllIIlllllIIIIlIllI = llllllllllIlllllIIlllllIIIIlIllI.down()) {}
            if (llllllllllIlllllIIlllllIIIIlIllI.getY() > 0) {
                return super.getPathToPos(llllllllllIlllllIIlllllIIIIlIllI.up());
            }
            while (llllllllllIlllllIIlllllIIIIlIllI.getY() < this.worldObj.getHeight() && this.worldObj.getBlockState(llllllllllIlllllIIlllllIIIIlIllI).getMaterial() == Material.AIR) {
                llllllllllIlllllIIlllllIIIIlIllI = llllllllllIlllllIIlllllIIIIlIllI.up();
            }
            llllllllllIlllllIIlllllIIIIlIIll = llllllllllIlllllIIlllllIIIIlIllI;
        }
        if (!this.worldObj.getBlockState((BlockPos)llllllllllIlllllIIlllllIIIIlIIll).getMaterial().isSolid()) {
            return super.getPathToPos((BlockPos)llllllllllIlllllIIlllllIIIIlIIll);
        }
        BlockPos llllllllllIlllllIIlllllIIIIlIlIl;
        for (llllllllllIlllllIIlllllIIIIlIlIl = ((BlockPos)llllllllllIlllllIIlllllIIIIlIIll).up(); llllllllllIlllllIIlllllIIIIlIlIl.getY() < this.worldObj.getHeight() && this.worldObj.getBlockState(llllllllllIlllllIIlllllIIIIlIlIl).getMaterial().isSolid(); llllllllllIlllllIIlllllIIIIlIlIl = llllllllllIlllllIIlllllIIIIlIlIl.up()) {}
        return super.getPathToPos(llllllllllIlllllIIlllllIIIIlIlIl);
    }
    
    private boolean isSafeToStandAt(final int llllllllllIlllllIIllllIllIlIIIIl, final int llllllllllIlllllIIllllIllIIIlllI, final int llllllllllIlllllIIllllIllIIlllll, final int llllllllllIlllllIIllllIllIIIllII, final int llllllllllIlllllIIllllIllIIlllIl, final int llllllllllIlllllIIllllIllIIlllII, final Vec3d llllllllllIlllllIIllllIllIIIlIIl, final double llllllllllIlllllIIllllIllIIllIlI, final double llllllllllIlllllIIllllIllIIIIlll) {
        final int llllllllllIlllllIIllllIllIIllIII = llllllllllIlllllIIllllIllIlIIIIl - llllllllllIlllllIIllllIllIIIllII / 2;
        final int llllllllllIlllllIIllllIllIIlIlll = llllllllllIlllllIIllllIllIIlllll - llllllllllIlllllIIllllIllIIlllII / 2;
        if (!this.isPositionClear(llllllllllIlllllIIllllIllIIllIII, llllllllllIlllllIIllllIllIIIlllI, llllllllllIlllllIIllllIllIIlIlll, llllllllllIlllllIIllllIllIIIllII, llllllllllIlllllIIllllIllIIlllIl, llllllllllIlllllIIllllIllIIlllII, llllllllllIlllllIIllllIllIIIlIIl, llllllllllIlllllIIllllIllIIllIlI, llllllllllIlllllIIllllIllIIIIlll)) {
            return false;
        }
        for (int llllllllllIlllllIIllllIllIIlIllI = llllllllllIlllllIIllllIllIIllIII; llllllllllIlllllIIllllIllIIlIllI < llllllllllIlllllIIllllIllIIllIII + llllllllllIlllllIIllllIllIIIllII; ++llllllllllIlllllIIllllIllIIlIllI) {
            for (int llllllllllIlllllIIllllIllIIlIlIl = llllllllllIlllllIIllllIllIIlIlll; llllllllllIlllllIIllllIllIIlIlIl < llllllllllIlllllIIllllIllIIlIlll + llllllllllIlllllIIllllIllIIlllII; ++llllllllllIlllllIIllllIllIIlIlIl) {
                final double llllllllllIlllllIIllllIllIIlIlII = llllllllllIlllllIIllllIllIIlIllI + 0.5 - llllllllllIlllllIIllllIllIIIlIIl.xCoord;
                final double llllllllllIlllllIIllllIllIIlIIll = llllllllllIlllllIIllllIllIIlIlIl + 0.5 - llllllllllIlllllIIllllIllIIIlIIl.zCoord;
                if (llllllllllIlllllIIllllIllIIlIlII * llllllllllIlllllIIllllIllIIllIlI + llllllllllIlllllIIllllIllIIlIIll * llllllllllIlllllIIllllIllIIIIlll >= 0.0) {
                    PathNodeType llllllllllIlllllIIllllIllIIlIIlI = this.nodeProcessor.getPathNodeType(this.worldObj, llllllllllIlllllIIllllIllIIlIllI, llllllllllIlllllIIllllIllIIIlllI - 1, llllllllllIlllllIIllllIllIIlIlIl, this.theEntity, llllllllllIlllllIIllllIllIIIllII, llllllllllIlllllIIllllIllIIlllIl, llllllllllIlllllIIllllIllIIlllII, true, true);
                    if (llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.WATER) {
                        return false;
                    }
                    if (llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.LAVA) {
                        return false;
                    }
                    if (llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.OPEN) {
                        return false;
                    }
                    llllllllllIlllllIIllllIllIIlIIlI = this.nodeProcessor.getPathNodeType(this.worldObj, llllllllllIlllllIIllllIllIIlIllI, llllllllllIlllllIIllllIllIIIlllI, llllllllllIlllllIIllllIllIIlIlIl, this.theEntity, llllllllllIlllllIIllllIllIIIllII, llllllllllIlllllIIllllIllIIlllIl, llllllllllIlllllIIllllIllIIlllII, true, true);
                    final float llllllllllIlllllIIllllIllIIlIIIl = this.theEntity.getPathPriority(llllllllllIlllllIIllllIllIIlIIlI);
                    if (llllllllllIlllllIIllllIllIIlIIIl < 0.0f || llllllllllIlllllIIllllIllIIlIIIl >= 8.0f) {
                        return false;
                    }
                    if (llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.DAMAGE_FIRE || llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.DANGER_FIRE || llllllllllIlllllIIllllIllIIlIIlI == PathNodeType.DAMAGE_OTHER) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    protected PathFinder getPathFinder() {
        this.nodeProcessor = new WalkNodeProcessor();
        this.nodeProcessor.setCanEnterDoors(true);
        return new PathFinder(this.nodeProcessor);
    }
    
    public void setEnterDoors(final boolean llllllllllIlllllIIllllIlIlIIlIIl) {
        this.nodeProcessor.setCanEnterDoors(llllllllllIlllllIIllllIlIlIIlIIl);
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity llllllllllIlllllIIlllllIIIIIlllI) {
        return this.getPathToPos(new BlockPos(llllllllllIlllllIIlllllIIIIIlllI));
    }
    
    public void setAvoidSun(final boolean llllllllllIlllllIIllllIlIIllIlll) {
        this.shouldAvoidSun = llllllllllIlllllIIllllIlIIllIlll;
    }
    
    public boolean getEnterDoors() {
        return this.nodeProcessor.getCanEnterDoors();
    }
    
    public boolean getCanSwim() {
        return this.nodeProcessor.getCanSwim();
    }
    
    private boolean isPositionClear(final int llllllllllIlllllIIllllIlIllIlllI, final int llllllllllIlllllIIllllIlIllIllIl, final int llllllllllIlllllIIllllIlIllIllII, final int llllllllllIlllllIIllllIlIlIlllIl, final int llllllllllIlllllIIllllIlIllIlIlI, final int llllllllllIlllllIIllllIlIllIlIIl, final Vec3d llllllllllIlllllIIllllIlIlIllIlI, final double llllllllllIlllllIIllllIlIlIllIIl, final double llllllllllIlllllIIllllIlIllIIllI) {
        for (final BlockPos llllllllllIlllllIIllllIlIllIIlIl : BlockPos.getAllInBox(new BlockPos(llllllllllIlllllIIllllIlIllIlllI, llllllllllIlllllIIllllIlIllIllIl, llllllllllIlllllIIllllIlIllIllII), new BlockPos(llllllllllIlllllIIllllIlIllIlllI + llllllllllIlllllIIllllIlIlIlllIl - 1, llllllllllIlllllIIllllIlIllIllIl + llllllllllIlllllIIllllIlIllIlIlI - 1, llllllllllIlllllIIllllIlIllIllII + llllllllllIlllllIIllllIlIllIlIIl - 1))) {
            final double llllllllllIlllllIIllllIlIllIIlII = llllllllllIlllllIIllllIlIllIIlIl.getX() + 0.5 - llllllllllIlllllIIllllIlIlIllIlI.xCoord;
            final double llllllllllIlllllIIllllIlIllIIIll = llllllllllIlllllIIllllIlIllIIlIl.getZ() + 0.5 - llllllllllIlllllIIllllIlIlIllIlI.zCoord;
            if (llllllllllIlllllIIllllIlIllIIlII * llllllllllIlllllIIllllIlIlIllIIl + llllllllllIlllllIIllllIlIllIIIll * llllllllllIlllllIIllllIlIllIIllI >= 0.0) {
                final Block llllllllllIlllllIIllllIlIllIIIlI = this.worldObj.getBlockState(llllllllllIlllllIIllllIlIllIIlIl).getBlock();
                if (!llllllllllIlllllIIllllIlIllIIIlI.isPassable(this.worldObj, llllllllllIlllllIIllllIlIllIIlIl)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    public void setBreakDoors(final boolean llllllllllIlllllIIllllIlIlIIllll) {
        this.nodeProcessor.setCanBreakDoors(llllllllllIlllllIIllllIlIlIIllll);
    }
    
    @Override
    protected void removeSunnyPath() {
        super.removeSunnyPath();
        if (this.shouldAvoidSun) {
            if (this.worldObj.canSeeSky(new BlockPos(MathHelper.floor(this.theEntity.posX), (int)(this.theEntity.getEntityBoundingBox().minY + 0.5), MathHelper.floor(this.theEntity.posZ)))) {
                return;
            }
            for (int llllllllllIlllllIIllllIllllllIll = 0; llllllllllIlllllIIllllIllllllIll < this.currentPath.getCurrentPathLength(); ++llllllllllIlllllIIllllIllllllIll) {
                final PathPoint llllllllllIlllllIIllllIllllllIlI = this.currentPath.getPathPointFromIndex(llllllllllIlllllIIllllIllllllIll);
                if (this.worldObj.canSeeSky(new BlockPos(llllllllllIlllllIIllllIllllllIlI.xCoord, llllllllllIlllllIIllllIllllllIlI.yCoord, llllllllllIlllllIIllllIllllllIlI.zCoord))) {
                    this.currentPath.setCurrentPathLength(llllllllllIlllllIIllllIllllllIll - 1);
                    return;
                }
            }
        }
    }
    
    @Override
    protected boolean canNavigate() {
        return this.theEntity.onGround || (this.getCanSwim() && this.isInLiquid()) || this.theEntity.isRiding();
    }
    
    private int getPathablePosY() {
        if (this.theEntity.isInWater() && this.getCanSwim()) {
            int llllllllllIlllllIIlllllIIIIIIllI = (int)this.theEntity.getEntityBoundingBox().minY;
            Block llllllllllIlllllIIlllllIIIIIIlIl = this.worldObj.getBlockState(new BlockPos(MathHelper.floor(this.theEntity.posX), llllllllllIlllllIIlllllIIIIIIllI, MathHelper.floor(this.theEntity.posZ))).getBlock();
            int llllllllllIlllllIIlllllIIIIIIlII = 0;
            while (llllllllllIlllllIIlllllIIIIIIlIl == Blocks.FLOWING_WATER || llllllllllIlllllIIlllllIIIIIIlIl == Blocks.WATER) {
                ++llllllllllIlllllIIlllllIIIIIIllI;
                llllllllllIlllllIIlllllIIIIIIlIl = this.worldObj.getBlockState(new BlockPos(MathHelper.floor(this.theEntity.posX), llllllllllIlllllIIlllllIIIIIIllI, MathHelper.floor(this.theEntity.posZ))).getBlock();
                if (++llllllllllIlllllIIlllllIIIIIIlII > 16) {
                    return (int)this.theEntity.getEntityBoundingBox().minY;
                }
            }
            return llllllllllIlllllIIlllllIIIIIIllI;
        }
        return (int)(this.theEntity.getEntityBoundingBox().minY + 0.5);
    }
    
    public PathNavigateGround(final EntityLiving llllllllllIlllllIIlllllIIIlIIllI, final World llllllllllIlllllIIlllllIIIlIlIII) {
        super(llllllllllIlllllIIlllllIIIlIIllI, llllllllllIlllllIIlllllIIIlIlIII);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d llllllllllIlllllIIllllIlllIlllll, final Vec3d llllllllllIlllllIIllllIlllIIlIII, int llllllllllIlllllIIllllIlllIlllIl, final int llllllllllIlllllIIllllIlllIlllII, int llllllllllIlllllIIllllIlllIllIll) {
        int llllllllllIlllllIIllllIlllIllIlI = MathHelper.floor(llllllllllIlllllIIllllIlllIlllll.xCoord);
        int llllllllllIlllllIIllllIlllIllIIl = MathHelper.floor(llllllllllIlllllIIllllIlllIlllll.zCoord);
        double llllllllllIlllllIIllllIlllIllIII = llllllllllIlllllIIllllIlllIIlIII.xCoord - llllllllllIlllllIIllllIlllIlllll.xCoord;
        double llllllllllIlllllIIllllIlllIlIlll = llllllllllIlllllIIllllIlllIIlIII.zCoord - llllllllllIlllllIIllllIlllIlllll.zCoord;
        final double llllllllllIlllllIIllllIlllIlIllI = llllllllllIlllllIIllllIlllIllIII * llllllllllIlllllIIllllIlllIllIII + llllllllllIlllllIIllllIlllIlIlll * llllllllllIlllllIIllllIlllIlIlll;
        if (llllllllllIlllllIIllllIlllIlIllI < 1.0E-8) {
            return false;
        }
        final double llllllllllIlllllIIllllIlllIlIlIl = 1.0 / Math.sqrt(llllllllllIlllllIIllllIlllIlIllI);
        llllllllllIlllllIIllllIlllIllIII *= llllllllllIlllllIIllllIlllIlIlIl;
        llllllllllIlllllIIllllIlllIlIlll *= llllllllllIlllllIIllllIlllIlIlIl;
        llllllllllIlllllIIllllIlllIlllIl += 2;
        llllllllllIlllllIIllllIlllIllIll += 2;
        if (!this.isSafeToStandAt(llllllllllIlllllIIllllIlllIllIlI, (int)llllllllllIlllllIIllllIlllIlllll.yCoord, llllllllllIlllllIIllllIlllIllIIl, llllllllllIlllllIIllllIlllIlllIl, llllllllllIlllllIIllllIlllIlllII, llllllllllIlllllIIllllIlllIllIll, llllllllllIlllllIIllllIlllIlllll, llllllllllIlllllIIllllIlllIllIII, llllllllllIlllllIIllllIlllIlIlll)) {
            return false;
        }
        llllllllllIlllllIIllllIlllIlllIl -= 2;
        llllllllllIlllllIIllllIlllIllIll -= 2;
        final double llllllllllIlllllIIllllIlllIlIlII = 1.0 / Math.abs(llllllllllIlllllIIllllIlllIllIII);
        final double llllllllllIlllllIIllllIlllIlIIll = 1.0 / Math.abs(llllllllllIlllllIIllllIlllIlIlll);
        double llllllllllIlllllIIllllIlllIlIIlI = llllllllllIlllllIIllllIlllIllIlI - llllllllllIlllllIIllllIlllIlllll.xCoord;
        double llllllllllIlllllIIllllIlllIlIIIl = llllllllllIlllllIIllllIlllIllIIl - llllllllllIlllllIIllllIlllIlllll.zCoord;
        if (llllllllllIlllllIIllllIlllIllIII >= 0.0) {
            ++llllllllllIlllllIIllllIlllIlIIlI;
        }
        if (llllllllllIlllllIIllllIlllIlIlll >= 0.0) {
            ++llllllllllIlllllIIllllIlllIlIIIl;
        }
        llllllllllIlllllIIllllIlllIlIIlI /= llllllllllIlllllIIllllIlllIllIII;
        llllllllllIlllllIIllllIlllIlIIIl /= llllllllllIlllllIIllllIlllIlIlll;
        final int llllllllllIlllllIIllllIlllIlIIII = (llllllllllIlllllIIllllIlllIllIII < 0.0) ? -1 : 1;
        final int llllllllllIlllllIIllllIlllIIllll = (llllllllllIlllllIIllllIlllIlIlll < 0.0) ? -1 : 1;
        final int llllllllllIlllllIIllllIlllIIlllI = MathHelper.floor(llllllllllIlllllIIllllIlllIIlIII.xCoord);
        final int llllllllllIlllllIIllllIlllIIllIl = MathHelper.floor(llllllllllIlllllIIllllIlllIIlIII.zCoord);
        int llllllllllIlllllIIllllIlllIIllII = llllllllllIlllllIIllllIlllIIlllI - llllllllllIlllllIIllllIlllIllIlI;
        int llllllllllIlllllIIllllIlllIIlIll = llllllllllIlllllIIllllIlllIIllIl - llllllllllIlllllIIllllIlllIllIIl;
        while (llllllllllIlllllIIllllIlllIIllII * llllllllllIlllllIIllllIlllIlIIII > 0 || llllllllllIlllllIIllllIlllIIlIll * llllllllllIlllllIIllllIlllIIllll > 0) {
            if (llllllllllIlllllIIllllIlllIlIIlI < llllllllllIlllllIIllllIlllIlIIIl) {
                llllllllllIlllllIIllllIlllIlIIlI += llllllllllIlllllIIllllIlllIlIlII;
                llllllllllIlllllIIllllIlllIllIlI += llllllllllIlllllIIllllIlllIlIIII;
                llllllllllIlllllIIllllIlllIIllII = llllllllllIlllllIIllllIlllIIlllI - llllllllllIlllllIIllllIlllIllIlI;
            }
            else {
                llllllllllIlllllIIllllIlllIlIIIl += llllllllllIlllllIIllllIlllIlIIll;
                llllllllllIlllllIIllllIlllIllIIl += llllllllllIlllllIIllllIlllIIllll;
                llllllllllIlllllIIllllIlllIIlIll = llllllllllIlllllIIllllIlllIIllIl - llllllllllIlllllIIllllIlllIllIIl;
            }
            if (!this.isSafeToStandAt(llllllllllIlllllIIllllIlllIllIlI, (int)llllllllllIlllllIIllllIlllIlllll.yCoord, llllllllllIlllllIIllllIlllIllIIl, llllllllllIlllllIIllllIlllIlllIl, llllllllllIlllllIIllllIlllIlllII, llllllllllIlllllIIllllIlllIllIll, llllllllllIlllllIIllllIlllIlllll, llllllllllIlllllIIllllIlllIllIII, llllllllllIlllllIIllllIlllIlIlll)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.getPathablePosY(), this.theEntity.posZ);
    }
}
