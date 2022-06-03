// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;

public class PathNavigateClimber extends PathNavigateGround
{
    private /* synthetic */ BlockPos targetPosition;
    
    public PathNavigateClimber(final EntityLiving lllllllllllIlIIllllllIlllIllIIII, final World lllllllllllIlIIllllllIlllIlIllll) {
        super(lllllllllllIlIIllllllIlllIllIIII, lllllllllllIlIIllllllIlllIlIllll);
    }
    
    @Override
    public Path getPathToPos(final BlockPos lllllllllllIlIIllllllIlllIlIIllI) {
        this.targetPosition = lllllllllllIlIIllllllIlllIlIIllI;
        return super.getPathToPos(lllllllllllIlIIllllllIlllIlIIllI);
    }
    
    @Override
    public boolean tryMoveToEntityLiving(final Entity lllllllllllIlIIllllllIlllIIllIlI, final double lllllllllllIlIIllllllIlllIIlIlIl) {
        final Path lllllllllllIlIIllllllIlllIIllIII = this.getPathToEntityLiving(lllllllllllIlIIllllllIlllIIllIlI);
        if (lllllllllllIlIIllllllIlllIIllIII != null) {
            return this.setPath(lllllllllllIlIIllllllIlllIIllIII, lllllllllllIlIIllllllIlllIIlIlIl);
        }
        this.targetPosition = new BlockPos(lllllllllllIlIIllllllIlllIIllIlI);
        this.speed = lllllllllllIlIIllllllIlllIIlIlIl;
        return true;
    }
    
    @Override
    public void onUpdateNavigation() {
        if (!this.noPath()) {
            super.onUpdateNavigation();
        }
        else if (this.targetPosition != null) {
            final double lllllllllllIlIIllllllIlllIIlIIII = this.theEntity.width * this.theEntity.width;
            if (this.theEntity.getDistanceSqToCenter(this.targetPosition) >= lllllllllllIlIIllllllIlllIIlIIII && (this.theEntity.posY <= this.targetPosition.getY() || this.theEntity.getDistanceSqToCenter(new BlockPos(this.targetPosition.getX(), MathHelper.floor(this.theEntity.posY), this.targetPosition.getZ())) >= lllllllllllIlIIllllllIlllIIlIIII)) {
                this.theEntity.getMoveHelper().setMoveTo(this.targetPosition.getX(), this.targetPosition.getY(), this.targetPosition.getZ(), this.speed);
            }
            else {
                this.targetPosition = null;
            }
        }
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity lllllllllllIlIIllllllIlllIlIIIlI) {
        this.targetPosition = new BlockPos(lllllllllllIlIIllllllIlllIlIIIlI);
        return super.getPathToEntityLiving(lllllllllllIlIIllllllIlllIlIIIlI);
    }
}
