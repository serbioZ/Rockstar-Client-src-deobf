// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ChunkCache;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;

public abstract class PathNavigate
{
    private final /* synthetic */ PathFinder pathFinder;
    private /* synthetic */ Vec3d timeoutCachedNode;
    protected /* synthetic */ boolean tryUpdatePath;
    protected /* synthetic */ double speed;
    private /* synthetic */ long lastTimeoutCheck;
    protected /* synthetic */ int totalTicks;
    private /* synthetic */ int ticksAtLastPos;
    private /* synthetic */ long timeoutTimer;
    @Nullable
    protected /* synthetic */ Path currentPath;
    protected /* synthetic */ float maxDistanceToWaypoint;
    private /* synthetic */ long lastTimeUpdated;
    protected /* synthetic */ NodeProcessor nodeProcessor;
    private /* synthetic */ BlockPos targetPos;
    private /* synthetic */ double timeoutLimit;
    private /* synthetic */ Vec3d lastPosCheck;
    private final /* synthetic */ IAttributeInstance pathSearchRange;
    protected /* synthetic */ EntityLiving theEntity;
    protected /* synthetic */ World worldObj;
    
    @Nullable
    public final Path getPathToXYZ(final double llllllllllIlllIIlIIlIIlllIIlIllI, final double llllllllllIlllIIlIIlIIlllIIlIlIl, final double llllllllllIlllIIlIIlIIlllIIlIIII) {
        return this.getPathToPos(new BlockPos(llllllllllIlllIIlIIlIIlllIIlIllI, llllllllllIlllIIlIIlIIlllIIlIlIl, llllllllllIlllIIlIIlIIlllIIlIIII));
    }
    
    protected void checkForStuck(final Vec3d llllllllllIlllIIlIIlIIllIIIIIlll) {
        if (this.totalTicks - this.ticksAtLastPos > 100) {
            if (llllllllllIlllIIlIIlIIllIIIIIlll.squareDistanceTo(this.lastPosCheck) < 2.25) {
                this.clearPathEntity();
            }
            this.ticksAtLastPos = this.totalTicks;
            this.lastPosCheck = llllllllllIlllIIlIIlIIllIIIIIlll;
        }
        if (this.currentPath != null && !this.currentPath.isFinished()) {
            final Vec3d llllllllllIlllIIlIIlIIllIIIIlIlI = this.currentPath.getCurrentPos();
            if (llllllllllIlllIIlIIlIIllIIIIlIlI.equals(this.timeoutCachedNode)) {
                this.timeoutTimer += System.currentTimeMillis() - this.lastTimeoutCheck;
            }
            else {
                this.timeoutCachedNode = llllllllllIlllIIlIIlIIllIIIIlIlI;
                final double llllllllllIlllIIlIIlIIllIIIIlIIl = llllllllllIlllIIlIIlIIllIIIIIlll.distanceTo(this.timeoutCachedNode);
                this.timeoutLimit = ((this.theEntity.getAIMoveSpeed() > 0.0f) ? (llllllllllIlllIIlIIlIIllIIIIlIIl / this.theEntity.getAIMoveSpeed() * 1000.0) : 0.0);
            }
            if (this.timeoutLimit > 0.0 && this.timeoutTimer > this.timeoutLimit * 3.0) {
                this.timeoutCachedNode = Vec3d.ZERO;
                this.timeoutTimer = 0L;
                this.timeoutLimit = 0.0;
                this.clearPathEntity();
            }
            this.lastTimeoutCheck = System.currentTimeMillis();
        }
    }
    
    protected abstract Vec3d getEntityPosition();
    
    public boolean canUpdatePathOnTimeout() {
        return this.tryUpdatePath;
    }
    
    public boolean tryMoveToEntityLiving(final Entity llllllllllIlllIIlIIlIIllIlIIlllI, final double llllllllllIlllIIlIIlIIllIlIIllIl) {
        final Path llllllllllIlllIIlIIlIIllIlIIllII = this.getPathToEntityLiving(llllllllllIlllIIlIIlIIllIlIIlllI);
        return llllllllllIlllIIlIIlIIllIlIIllII != null && this.setPath(llllllllllIlllIIlIIlIIllIlIIllII, llllllllllIlllIIlIIlIIllIlIIllIl);
    }
    
    public void clearPathEntity() {
        this.currentPath = null;
    }
    
    @Nullable
    public Path getPathToPos(final BlockPos llllllllllIlllIIlIIlIIlllIIIIlll) {
        if (!this.canNavigate()) {
            return null;
        }
        if (this.currentPath != null && !this.currentPath.isFinished() && llllllllllIlllIIlIIlIIlllIIIIlll.equals(this.targetPos)) {
            return this.currentPath;
        }
        this.targetPos = llllllllllIlllIIlIIlIIlllIIIIlll;
        final float llllllllllIlllIIlIIlIIlllIIIIllI = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos llllllllllIlllIIlIIlIIlllIIIIlIl = new BlockPos(this.theEntity);
        final int llllllllllIlllIIlIIlIIlllIIIIlII = (int)(llllllllllIlllIIlIIlIIlllIIIIllI + 8.0f);
        final ChunkCache llllllllllIlllIIlIIlIIlllIIIIIll = new ChunkCache(this.worldObj, llllllllllIlllIIlIIlIIlllIIIIlIl.add(-llllllllllIlllIIlIIlIIlllIIIIlII, -llllllllllIlllIIlIIlIIlllIIIIlII, -llllllllllIlllIIlIIlIIlllIIIIlII), llllllllllIlllIIlIIlIIlllIIIIlIl.add(llllllllllIlllIIlIIlIIlllIIIIlII, llllllllllIlllIIlIIlIIlllIIIIlII, llllllllllIlllIIlIIlIIlllIIIIlII), 0);
        final Path llllllllllIlllIIlIIlIIlllIIIIIlI = this.pathFinder.findPath(llllllllllIlllIIlIIlIIlllIIIIIll, this.theEntity, this.targetPos, llllllllllIlllIIlIIlIIlllIIIIllI);
        this.worldObj.theProfiler.endSection();
        return llllllllllIlllIIlIIlIIlllIIIIIlI;
    }
    
    public void updatePath() {
        if (this.worldObj.getTotalWorldTime() - this.lastTimeUpdated > 20L) {
            if (this.targetPos != null) {
                this.currentPath = null;
                this.currentPath = this.getPathToPos(this.targetPos);
                this.lastTimeUpdated = this.worldObj.getTotalWorldTime();
                this.tryUpdatePath = false;
            }
        }
        else {
            this.tryUpdatePath = true;
        }
    }
    
    @Nullable
    public Path getPath() {
        return this.currentPath;
    }
    
    public float getPathSearchRange() {
        return (float)this.pathSearchRange.getAttributeValue();
    }
    
    public boolean setPath(@Nullable final Path llllllllllIlllIIlIIlIIllIlIIIIlI, final double llllllllllIlllIIlIIlIIllIIllllIl) {
        if (llllllllllIlllIIlIIlIIllIlIIIIlI == null) {
            this.currentPath = null;
            return false;
        }
        if (!llllllllllIlllIIlIIlIIllIlIIIIlI.isSamePath(this.currentPath)) {
            this.currentPath = llllllllllIlllIIlIIlIIllIlIIIIlI;
        }
        this.removeSunnyPath();
        if (this.currentPath.getCurrentPathLength() <= 0) {
            return false;
        }
        this.speed = llllllllllIlllIIlIIlIIllIIllllIl;
        final Vec3d llllllllllIlllIIlIIlIIllIlIIIIII = this.getEntityPosition();
        this.ticksAtLastPos = this.totalTicks;
        this.lastPosCheck = llllllllllIlllIIlIIlIIllIlIIIIII;
        return true;
    }
    
    public void onUpdateNavigation() {
        ++this.totalTicks;
        if (this.tryUpdatePath) {
            this.updatePath();
        }
        if (!this.noPath()) {
            if (this.canNavigate()) {
                this.pathFollow();
            }
            else if (this.currentPath != null && this.currentPath.getCurrentPathIndex() < this.currentPath.getCurrentPathLength()) {
                final Vec3d llllllllllIlllIIlIIlIIllIIllIIll = this.getEntityPosition();
                final Vec3d llllllllllIlllIIlIIlIIllIIllIIlI = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (llllllllllIlllIIlIIlIIllIIllIIll.yCoord > llllllllllIlllIIlIIlIIllIIllIIlI.yCoord && !this.theEntity.onGround && MathHelper.floor(llllllllllIlllIIlIIlIIllIIllIIll.xCoord) == MathHelper.floor(llllllllllIlllIIlIIlIIllIIllIIlI.xCoord) && MathHelper.floor(llllllllllIlllIIlIIlIIllIIllIIll.zCoord) == MathHelper.floor(llllllllllIlllIIlIIlIIllIIllIIlI.zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            this.func_192876_m();
            if (!this.noPath()) {
                Vec3d llllllllllIlllIIlIIlIIllIIllIIIl = this.currentPath.getPosition(this.theEntity);
                final BlockPos llllllllllIlllIIlIIlIIllIIllIIII = new BlockPos(llllllllllIlllIIlIIlIIllIIllIIIl).down();
                final AxisAlignedBB llllllllllIlllIIlIIlIIllIIlIllll = this.worldObj.getBlockState(llllllllllIlllIIlIIlIIllIIllIIII).getBoundingBox(this.worldObj, llllllllllIlllIIlIIlIIllIIllIIII);
                llllllllllIlllIIlIIlIIllIIllIIIl = llllllllllIlllIIlIIlIIllIIllIIIl.subtract(0.0, 1.0 - llllllllllIlllIIlIIlIIllIIlIllll.maxY, 0.0);
                this.theEntity.getMoveHelper().setMoveTo(llllllllllIlllIIlIIlIIllIIllIIIl.xCoord, llllllllllIlllIIlIIlIIllIIllIIIl.yCoord, llllllllllIlllIIlIIlIIllIIllIIIl.zCoord, this.speed);
            }
        }
    }
    
    public NodeProcessor getNodeProcessor() {
        return this.nodeProcessor;
    }
    
    public boolean tryMoveToXYZ(final double llllllllllIlllIIlIIlIIllIlIlllII, final double llllllllllIlllIIlIIlIIllIlIlIllI, final double llllllllllIlllIIlIIlIIllIlIlIlIl, final double llllllllllIlllIIlIIlIIllIlIllIIl) {
        return this.setPath(this.getPathToXYZ(llllllllllIlllIIlIIlIIllIlIlllII, llllllllllIlllIIlIIlIIllIlIlIllI, llllllllllIlllIIlIIlIIllIlIlIlIl), llllllllllIlllIIlIIlIIllIlIllIIl);
    }
    
    public PathNavigate(final EntityLiving llllllllllIlllIIlIIlIIlllIlIllll, final World llllllllllIlllIIlIIlIIlllIlIlIll) {
        this.lastPosCheck = Vec3d.ZERO;
        this.timeoutCachedNode = Vec3d.ZERO;
        this.maxDistanceToWaypoint = 0.5f;
        this.theEntity = llllllllllIlllIIlIIlIIlllIlIllll;
        this.worldObj = llllllllllIlllIIlIIlIIlllIlIlIll;
        this.pathSearchRange = llllllllllIlllIIlIIlIIlllIlIllll.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        this.pathFinder = this.getPathFinder();
    }
    
    protected abstract boolean isDirectPathBetweenPoints(final Vec3d p0, final Vec3d p1, final int p2, final int p3, final int p4);
    
    protected void removeSunnyPath() {
        if (this.currentPath != null) {
            for (int llllllllllIlllIIlIIlIIlIllllIlII = 0; llllllllllIlllIIlIIlIIlIllllIlII < this.currentPath.getCurrentPathLength(); ++llllllllllIlllIIlIIlIIlIllllIlII) {
                final PathPoint llllllllllIlllIIlIIlIIlIllllIIll = this.currentPath.getPathPointFromIndex(llllllllllIlllIIlIIlIIlIllllIlII);
                final PathPoint llllllllllIlllIIlIIlIIlIllllIIlI = (llllllllllIlllIIlIIlIIlIllllIlII + 1 < this.currentPath.getCurrentPathLength()) ? this.currentPath.getPathPointFromIndex(llllllllllIlllIIlIIlIIlIllllIlII + 1) : null;
                final IBlockState llllllllllIlllIIlIIlIIlIllllIIIl = this.worldObj.getBlockState(new BlockPos(llllllllllIlllIIlIIlIIlIllllIIll.xCoord, llllllllllIlllIIlIIlIIlIllllIIll.yCoord, llllllllllIlllIIlIIlIIlIllllIIll.zCoord));
                final Block llllllllllIlllIIlIIlIIlIllllIIII = llllllllllIlllIIlIIlIIlIllllIIIl.getBlock();
                if (llllllllllIlllIIlIIlIIlIllllIIII == Blocks.CAULDRON) {
                    this.currentPath.setPoint(llllllllllIlllIIlIIlIIlIllllIlII, llllllllllIlllIIlIIlIIlIllllIIll.cloneMove(llllllllllIlllIIlIIlIIlIllllIIll.xCoord, llllllllllIlllIIlIIlIIlIllllIIll.yCoord + 1, llllllllllIlllIIlIIlIIlIllllIIll.zCoord));
                    if (llllllllllIlllIIlIIlIIlIllllIIlI != null && llllllllllIlllIIlIIlIIlIllllIIll.yCoord >= llllllllllIlllIIlIIlIIlIllllIIlI.yCoord) {
                        this.currentPath.setPoint(llllllllllIlllIIlIIlIIlIllllIlII + 1, llllllllllIlllIIlIIlIIlIllllIIlI.cloneMove(llllllllllIlllIIlIIlIIlIllllIIlI.xCoord, llllllllllIlllIIlIIlIIlIllllIIll.yCoord + 1, llllllllllIlllIIlIIlIIlIllllIIlI.zCoord));
                    }
                }
            }
        }
    }
    
    protected abstract PathFinder getPathFinder();
    
    protected abstract boolean canNavigate();
    
    protected boolean isInLiquid() {
        return this.theEntity.isInWater() || this.theEntity.isInLava();
    }
    
    public boolean canEntityStandOnPos(final BlockPos llllllllllIlllIIlIIlIIlIlllIIlII) {
        return this.worldObj.getBlockState(llllllllllIlllIIlIIlIIlIlllIIlII.down()).isFullBlock();
    }
    
    protected void pathFollow() {
        final Vec3d llllllllllIlllIIlIIlIIllIIlIIIII = this.getEntityPosition();
        int llllllllllIlllIIlIIlIIllIIIlllll = this.currentPath.getCurrentPathLength();
        for (int llllllllllIlllIIlIIlIIllIIIllllI = this.currentPath.getCurrentPathIndex(); llllllllllIlllIIlIIlIIllIIIllllI < this.currentPath.getCurrentPathLength(); ++llllllllllIlllIIlIIlIIllIIIllllI) {
            if (this.currentPath.getPathPointFromIndex(llllllllllIlllIIlIIlIIllIIIllllI).yCoord != Math.floor(llllllllllIlllIIlIIlIIllIIlIIIII.yCoord)) {
                llllllllllIlllIIlIIlIIllIIIlllll = llllllllllIlllIIlIIlIIllIIIllllI;
                break;
            }
        }
        this.maxDistanceToWaypoint = ((this.theEntity.width > 0.75f) ? (this.theEntity.width / 2.0f) : (0.75f - this.theEntity.width / 2.0f));
        final Vec3d llllllllllIlllIIlIIlIIllIIIlllIl = this.currentPath.getCurrentPos();
        if (MathHelper.abs((float)(this.theEntity.posX - (llllllllllIlllIIlIIlIIllIIIlllIl.xCoord + 0.5))) < this.maxDistanceToWaypoint && MathHelper.abs((float)(this.theEntity.posZ - (llllllllllIlllIIlIIlIIllIIIlllIl.zCoord + 0.5))) < this.maxDistanceToWaypoint && Math.abs(this.theEntity.posY - llllllllllIlllIIlIIlIIllIIIlllIl.yCoord) < 1.0) {
            this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
        }
        final int llllllllllIlllIIlIIlIIllIIIlllII = MathHelper.ceil(this.theEntity.width);
        final int llllllllllIlllIIlIIlIIllIIIllIll = MathHelper.ceil(this.theEntity.height);
        final int llllllllllIlllIIlIIlIIllIIIllIlI = llllllllllIlllIIlIIlIIllIIIlllII;
        for (int llllllllllIlllIIlIIlIIllIIIllIIl = llllllllllIlllIIlIIlIIllIIIlllll - 1; llllllllllIlllIIlIIlIIllIIIllIIl >= this.currentPath.getCurrentPathIndex(); --llllllllllIlllIIlIIlIIllIIIllIIl) {
            if (this.isDirectPathBetweenPoints(llllllllllIlllIIlIIlIIllIIlIIIII, this.currentPath.getVectorFromIndex(this.theEntity, llllllllllIlllIIlIIlIIllIIIllIIl), llllllllllIlllIIlIIlIIllIIIlllII, llllllllllIlllIIlIIlIIllIIIllIll, llllllllllIlllIIlIIlIIllIIIllIlI)) {
                this.currentPath.setCurrentPathIndex(llllllllllIlllIIlIIlIIllIIIllIIl);
                break;
            }
        }
        this.checkForStuck(llllllllllIlllIIlIIlIIllIIlIIIII);
    }
    
    public void setSpeed(final double llllllllllIlllIIlIIlIIlllIlIIlIl) {
        this.speed = llllllllllIlllIIlIIlIIlllIlIIlIl;
    }
    
    protected void func_192876_m() {
    }
    
    @Nullable
    public Path getPathToEntityLiving(final Entity llllllllllIlllIIlIIlIIllIlllIIIl) {
        if (!this.canNavigate()) {
            return null;
        }
        final BlockPos llllllllllIlllIIlIIlIIllIlllIIII = new BlockPos(llllllllllIlllIIlIIlIIllIlllIIIl);
        if (this.currentPath != null && !this.currentPath.isFinished() && llllllllllIlllIIlIIlIIllIlllIIII.equals(this.targetPos)) {
            return this.currentPath;
        }
        this.targetPos = llllllllllIlllIIlIIlIIllIlllIIII;
        final float llllllllllIlllIIlIIlIIllIllIllll = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos llllllllllIlllIIlIIlIIllIllIlllI = new BlockPos(this.theEntity).up();
        final int llllllllllIlllIIlIIlIIllIllIllIl = (int)(llllllllllIlllIIlIIlIIllIllIllll + 16.0f);
        final ChunkCache llllllllllIlllIIlIIlIIllIllIllII = new ChunkCache(this.worldObj, llllllllllIlllIIlIIlIIllIllIlllI.add(-llllllllllIlllIIlIIlIIllIllIllIl, -llllllllllIlllIIlIIlIIllIllIllIl, -llllllllllIlllIIlIIlIIllIllIllIl), llllllllllIlllIIlIIlIIllIllIlllI.add(llllllllllIlllIIlIIlIIllIllIllIl, llllllllllIlllIIlIIlIIllIllIllIl, llllllllllIlllIIlIIlIIllIllIllIl), 0);
        final Path llllllllllIlllIIlIIlIIllIllIlIll = this.pathFinder.findPath(llllllllllIlllIIlIIlIIllIllIllII, this.theEntity, llllllllllIlllIIlIIlIIllIlllIIIl, llllllllllIlllIIlIIlIIllIllIllll);
        this.worldObj.theProfiler.endSection();
        return llllllllllIlllIIlIIlIIllIllIlIll;
    }
    
    public boolean noPath() {
        return this.currentPath == null || this.currentPath.isFinished();
    }
}
