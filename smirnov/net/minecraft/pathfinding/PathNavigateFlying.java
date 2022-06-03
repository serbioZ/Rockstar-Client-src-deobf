// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class PathNavigateFlying extends PathNavigate
{
    @Override
    protected PathFinder getPathFinder() {
        this.nodeProcessor = new FlyingNodeProcessor();
        this.nodeProcessor.setCanEnterDoors(true);
        return new PathFinder(this.nodeProcessor);
    }
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.theEntity.posY, this.theEntity.posZ);
    }
    
    @Override
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
                final Vec3d llllllllllllIllIIIIlIIIlllIllIIl = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (MathHelper.floor(this.theEntity.posX) == MathHelper.floor(llllllllllllIllIIIIlIIIlllIllIIl.xCoord) && MathHelper.floor(this.theEntity.posY) == MathHelper.floor(llllllllllllIllIIIIlIIIlllIllIIl.yCoord) && MathHelper.floor(this.theEntity.posZ) == MathHelper.floor(llllllllllllIllIIIIlIIIlllIllIIl.zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            this.func_192876_m();
            if (!this.noPath()) {
                final Vec3d llllllllllllIllIIIIlIIIlllIllIII = this.currentPath.getPosition(this.theEntity);
                this.theEntity.getMoveHelper().setMoveTo(llllllllllllIllIIIIlIIIlllIllIII.xCoord, llllllllllllIllIIIIlIIIlllIllIII.yCoord, llllllllllllIllIIIIlIIIlllIllIII.zCoord, this.speed);
            }
        }
    }
    
    public PathNavigateFlying(final EntityLiving llllllllllllIllIIIIlIIIlllllIIII, final World llllllllllllIllIIIIlIIIllllIllll) {
        super(llllllllllllIllIIIIlIIIlllllIIII, llllllllllllIllIIIIlIIIllllIllll);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d llllllllllllIllIIIIlIIIllIlllIll, final Vec3d llllllllllllIllIIIIlIIIllIlllIlI, final int llllllllllllIllIIIIlIIIllIlllIIl, final int llllllllllllIllIIIIlIIIllIlllIII, final int llllllllllllIllIIIIlIIIllIllIlll) {
        int llllllllllllIllIIIIlIIIllIllIllI = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIll.xCoord);
        int llllllllllllIllIIIIlIIIllIllIlIl = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIll.yCoord);
        int llllllllllllIllIIIIlIIIllIllIlII = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIll.zCoord);
        double llllllllllllIllIIIIlIIIllIllIIll = llllllllllllIllIIIIlIIIllIlllIlI.xCoord - llllllllllllIllIIIIlIIIllIlllIll.xCoord;
        double llllllllllllIllIIIIlIIIllIllIIlI = llllllllllllIllIIIIlIIIllIlllIlI.yCoord - llllllllllllIllIIIIlIIIllIlllIll.yCoord;
        double llllllllllllIllIIIIlIIIllIllIIIl = llllllllllllIllIIIIlIIIllIlllIlI.zCoord - llllllllllllIllIIIIlIIIllIlllIll.zCoord;
        final double llllllllllllIllIIIIlIIIllIllIIII = llllllllllllIllIIIIlIIIllIllIIll * llllllllllllIllIIIIlIIIllIllIIll + llllllllllllIllIIIIlIIIllIllIIlI * llllllllllllIllIIIIlIIIllIllIIlI + llllllllllllIllIIIIlIIIllIllIIIl * llllllllllllIllIIIIlIIIllIllIIIl;
        if (llllllllllllIllIIIIlIIIllIllIIII < 1.0E-8) {
            return false;
        }
        final double llllllllllllIllIIIIlIIIllIlIllll = 1.0 / Math.sqrt(llllllllllllIllIIIIlIIIllIllIIII);
        llllllllllllIllIIIIlIIIllIllIIll *= llllllllllllIllIIIIlIIIllIlIllll;
        llllllllllllIllIIIIlIIIllIllIIlI *= llllllllllllIllIIIIlIIIllIlIllll;
        llllllllllllIllIIIIlIIIllIllIIIl *= llllllllllllIllIIIIlIIIllIlIllll;
        final double llllllllllllIllIIIIlIIIllIlIlllI = 1.0 / Math.abs(llllllllllllIllIIIIlIIIllIllIIll);
        final double llllllllllllIllIIIIlIIIllIlIllIl = 1.0 / Math.abs(llllllllllllIllIIIIlIIIllIllIIlI);
        final double llllllllllllIllIIIIlIIIllIlIllII = 1.0 / Math.abs(llllllllllllIllIIIIlIIIllIllIIIl);
        double llllllllllllIllIIIIlIIIllIlIlIll = llllllllllllIllIIIIlIIIllIllIllI - llllllllllllIllIIIIlIIIllIlllIll.xCoord;
        double llllllllllllIllIIIIlIIIllIlIlIlI = llllllllllllIllIIIIlIIIllIllIlIl - llllllllllllIllIIIIlIIIllIlllIll.yCoord;
        double llllllllllllIllIIIIlIIIllIlIlIIl = llllllllllllIllIIIIlIIIllIllIlII - llllllllllllIllIIIIlIIIllIlllIll.zCoord;
        if (llllllllllllIllIIIIlIIIllIllIIll >= 0.0) {
            ++llllllllllllIllIIIIlIIIllIlIlIll;
        }
        if (llllllllllllIllIIIIlIIIllIllIIlI >= 0.0) {
            ++llllllllllllIllIIIIlIIIllIlIlIlI;
        }
        if (llllllllllllIllIIIIlIIIllIllIIIl >= 0.0) {
            ++llllllllllllIllIIIIlIIIllIlIlIIl;
        }
        llllllllllllIllIIIIlIIIllIlIlIll /= llllllllllllIllIIIIlIIIllIllIIll;
        llllllllllllIllIIIIlIIIllIlIlIlI /= llllllllllllIllIIIIlIIIllIllIIlI;
        llllllllllllIllIIIIlIIIllIlIlIIl /= llllllllllllIllIIIIlIIIllIllIIIl;
        final int llllllllllllIllIIIIlIIIllIlIlIII = (llllllllllllIllIIIIlIIIllIllIIll < 0.0) ? -1 : 1;
        final int llllllllllllIllIIIIlIIIllIlIIlll = (llllllllllllIllIIIIlIIIllIllIIlI < 0.0) ? -1 : 1;
        final int llllllllllllIllIIIIlIIIllIlIIllI = (llllllllllllIllIIIIlIIIllIllIIIl < 0.0) ? -1 : 1;
        final int llllllllllllIllIIIIlIIIllIlIIlIl = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIlI.xCoord);
        final int llllllllllllIllIIIIlIIIllIlIIlII = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIlI.yCoord);
        final int llllllllllllIllIIIIlIIIllIlIIIll = MathHelper.floor(llllllllllllIllIIIIlIIIllIlllIlI.zCoord);
        int llllllllllllIllIIIIlIIIllIlIIIlI = llllllllllllIllIIIIlIIIllIlIIlIl - llllllllllllIllIIIIlIIIllIllIllI;
        int llllllllllllIllIIIIlIIIllIlIIIIl = llllllllllllIllIIIIlIIIllIlIIlII - llllllllllllIllIIIIlIIIllIllIlIl;
        int llllllllllllIllIIIIlIIIllIlIIIII = llllllllllllIllIIIIlIIIllIlIIIll - llllllllllllIllIIIIlIIIllIllIlII;
        while (llllllllllllIllIIIIlIIIllIlIIIlI * llllllllllllIllIIIIlIIIllIlIlIII > 0 || llllllllllllIllIIIIlIIIllIlIIIIl * llllllllllllIllIIIIlIIIllIlIIlll > 0 || llllllllllllIllIIIIlIIIllIlIIIII * llllllllllllIllIIIIlIIIllIlIIllI > 0) {
            if (llllllllllllIllIIIIlIIIllIlIlIll < llllllllllllIllIIIIlIIIllIlIlIIl && llllllllllllIllIIIIlIIIllIlIlIll <= llllllllllllIllIIIIlIIIllIlIlIlI) {
                llllllllllllIllIIIIlIIIllIlIlIll += llllllllllllIllIIIIlIIIllIlIlllI;
                llllllllllllIllIIIIlIIIllIllIllI += llllllllllllIllIIIIlIIIllIlIlIII;
                llllllllllllIllIIIIlIIIllIlIIIlI = llllllllllllIllIIIIlIIIllIlIIlIl - llllllllllllIllIIIIlIIIllIllIllI;
            }
            else if (llllllllllllIllIIIIlIIIllIlIlIlI < llllllllllllIllIIIIlIIIllIlIlIll && llllllllllllIllIIIIlIIIllIlIlIlI <= llllllllllllIllIIIIlIIIllIlIlIIl) {
                llllllllllllIllIIIIlIIIllIlIlIlI += llllllllllllIllIIIIlIIIllIlIllIl;
                llllllllllllIllIIIIlIIIllIllIlIl += llllllllllllIllIIIIlIIIllIlIIlll;
                llllllllllllIllIIIIlIIIllIlIIIIl = llllllllllllIllIIIIlIIIllIlIIlII - llllllllllllIllIIIIlIIIllIllIlIl;
            }
            else {
                llllllllllllIllIIIIlIIIllIlIlIIl += llllllllllllIllIIIIlIIIllIlIllII;
                llllllllllllIllIIIIlIIIllIllIlII += llllllllllllIllIIIIlIIIllIlIIllI;
                llllllllllllIllIIIIlIIIllIlIIIII = llllllllllllIllIIIIlIIIllIlIIIll - llllllllllllIllIIIIlIIIllIllIlII;
            }
        }
        return true;
    }
    
    @Override
    public boolean canEntityStandOnPos(final BlockPos llllllllllllIllIIIIlIIIlIllIllII) {
        return this.worldObj.getBlockState(llllllllllllIllIIIIlIIIlIllIllII).isFullyOpaque();
    }
    
    public void func_192878_b(final boolean llllllllllllIllIIIIlIIIlIlllllIl) {
        this.nodeProcessor.setCanEnterDoors(llllllllllllIllIIIIlIIIlIlllllIl);
    }
    
    public void func_192877_c(final boolean llllllllllllIllIIIIlIIIlIlllIlIl) {
        this.nodeProcessor.setCanSwim(llllllllllllIllIIIIlIIIlIlllIlIl);
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity llllllllllllIllIIIIlIIIlllIlllIl) {
        return this.getPathToPos(new BlockPos(llllllllllllIllIIIIlIIIlllIlllIl));
    }
    
    @Override
    protected boolean canNavigate() {
        return (this.func_192880_g() && this.isInLiquid()) || !this.theEntity.isRiding();
    }
    
    public void func_192879_a(final boolean llllllllllllIllIIIIlIIIllIIIIIll) {
        this.nodeProcessor.setCanBreakDoors(llllllllllllIllIIIIlIIIllIIIIIll);
    }
    
    public boolean func_192880_g() {
        return this.nodeProcessor.getCanSwim();
    }
}
