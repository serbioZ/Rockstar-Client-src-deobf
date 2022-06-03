// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.network.PacketBuffer;
import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;

public class Path
{
    private /* synthetic */ PathPoint[] closedSet;
    private /* synthetic */ int pathLength;
    private /* synthetic */ int currentPathIndex;
    private /* synthetic */ PathPoint[] openSet;
    private final /* synthetic */ PathPoint[] points;
    private /* synthetic */ PathPoint target;
    
    public void incrementPathIndex() {
        ++this.currentPathIndex;
    }
    
    public int getCurrentPathIndex() {
        return this.currentPathIndex;
    }
    
    public Vec3d getPosition(final Entity llllllllllllIlllIIIIIIlIIIIIlIIl) {
        return this.getVectorFromIndex(llllllllllllIlllIIIIIIlIIIIIlIIl, this.currentPathIndex);
    }
    
    public PathPoint getTarget() {
        return this.target;
    }
    
    public PathPoint getPathPointFromIndex(final int llllllllllllIlllIIIIIIlIIIllllII) {
        return this.points[llllllllllllIlllIIIIIIlIIIllllII];
    }
    
    public void setCurrentPathLength(final int llllllllllllIlllIIIIIIlIIIlIlIII) {
        this.pathLength = llllllllllllIlllIIIIIIlIIIlIlIII;
    }
    
    public Path(final PathPoint[] llllllllllllIlllIIIIIIlIIlIIlIIl) {
        this.openSet = new PathPoint[0];
        this.closedSet = new PathPoint[0];
        this.points = llllllllllllIlllIIIIIIlIIlIIlIIl;
        this.pathLength = llllllllllllIlllIIIIIIlIIlIIlIIl.length;
    }
    
    @Nullable
    public PathPoint getFinalPathPoint() {
        return (this.pathLength > 0) ? this.points[this.pathLength - 1] : null;
    }
    
    public static Path read(final PacketBuffer llllllllllllIlllIIIIIIIllllIIlll) {
        final int llllllllllllIlllIIIIIIIllllIIllI = llllllllllllIlllIIIIIIIllllIIlll.readInt();
        final PathPoint llllllllllllIlllIIIIIIIllllIIlIl = PathPoint.createFromBuffer(llllllllllllIlllIIIIIIIllllIIlll);
        final PathPoint[] llllllllllllIlllIIIIIIIllllIIlII = new PathPoint[llllllllllllIlllIIIIIIIllllIIlll.readInt()];
        for (int llllllllllllIlllIIIIIIIllllIIIll = 0; llllllllllllIlllIIIIIIIllllIIIll < llllllllllllIlllIIIIIIIllllIIlII.length; ++llllllllllllIlllIIIIIIIllllIIIll) {
            llllllllllllIlllIIIIIIIllllIIlII[llllllllllllIlllIIIIIIIllllIIIll] = PathPoint.createFromBuffer(llllllllllllIlllIIIIIIIllllIIlll);
        }
        final PathPoint[] llllllllllllIlllIIIIIIIllllIIIlI = new PathPoint[llllllllllllIlllIIIIIIIllllIIlll.readInt()];
        for (int llllllllllllIlllIIIIIIIllllIIIIl = 0; llllllllllllIlllIIIIIIIllllIIIIl < llllllllllllIlllIIIIIIIllllIIIlI.length; ++llllllllllllIlllIIIIIIIllllIIIIl) {
            llllllllllllIlllIIIIIIIllllIIIlI[llllllllllllIlllIIIIIIIllllIIIIl] = PathPoint.createFromBuffer(llllllllllllIlllIIIIIIIllllIIlll);
        }
        final PathPoint[] llllllllllllIlllIIIIIIIllllIIIII = new PathPoint[llllllllllllIlllIIIIIIIllllIIlll.readInt()];
        for (int llllllllllllIlllIIIIIIIlllIlllll = 0; llllllllllllIlllIIIIIIIlllIlllll < llllllllllllIlllIIIIIIIllllIIIII.length; ++llllllllllllIlllIIIIIIIlllIlllll) {
            llllllllllllIlllIIIIIIIllllIIIII[llllllllllllIlllIIIIIIIlllIlllll] = PathPoint.createFromBuffer(llllllllllllIlllIIIIIIIllllIIlll);
        }
        final Path llllllllllllIlllIIIIIIIlllIllllI = new Path(llllllllllllIlllIIIIIIIllllIIlII);
        llllllllllllIlllIIIIIIIlllIllllI.openSet = llllllllllllIlllIIIIIIIllllIIIlI;
        llllllllllllIlllIIIIIIIlllIllllI.closedSet = llllllllllllIlllIIIIIIIllllIIIII;
        llllllllllllIlllIIIIIIIlllIllllI.target = llllllllllllIlllIIIIIIIllllIIlIl;
        llllllllllllIlllIIIIIIIlllIllllI.currentPathIndex = llllllllllllIlllIIIIIIIllllIIllI;
        return llllllllllllIlllIIIIIIIlllIllllI;
    }
    
    public boolean isSamePath(final Path llllllllllllIlllIIIIIIIlllllllII) {
        if (llllllllllllIlllIIIIIIIlllllllII == null) {
            return false;
        }
        if (llllllllllllIlllIIIIIIIlllllllII.points.length != this.points.length) {
            return false;
        }
        for (int llllllllllllIlllIIIIIIIllllllIll = 0; llllllllllllIlllIIIIIIIllllllIll < this.points.length; ++llllllllllllIlllIIIIIIIllllllIll) {
            if (this.points[llllllllllllIlllIIIIIIIllllllIll].xCoord != llllllllllllIlllIIIIIIIlllllllII.points[llllllllllllIlllIIIIIIIllllllIll].xCoord || this.points[llllllllllllIlllIIIIIIIllllllIll].yCoord != llllllllllllIlllIIIIIIIlllllllII.points[llllllllllllIlllIIIIIIIllllllIll].yCoord || this.points[llllllllllllIlllIIIIIIIllllllIll].zCoord != llllllllllllIlllIIIIIIIlllllllII.points[llllllllllllIlllIIIIIIIllllllIll].zCoord) {
                return false;
            }
        }
        return true;
    }
    
    public void setCurrentPathIndex(final int llllllllllllIlllIIIIIIlIIIlIIIIl) {
        this.currentPathIndex = llllllllllllIlllIIIIIIlIIIlIIIIl;
    }
    
    public int getCurrentPathLength() {
        return this.pathLength;
    }
    
    public Vec3d getCurrentPos() {
        final PathPoint llllllllllllIlllIIIIIIlIIIIIIIll = this.points[this.currentPathIndex];
        return new Vec3d(llllllllllllIlllIIIIIIlIIIIIIIll.xCoord, llllllllllllIlllIIIIIIlIIIIIIIll.yCoord, llllllllllllIlllIIIIIIlIIIIIIIll.zCoord);
    }
    
    public void setPoint(final int llllllllllllIlllIIIIIIlIIIllIIlI, final PathPoint llllllllllllIlllIIIIIIlIIIllIlII) {
        this.points[llllllllllllIlllIIIIIIlIIIllIIlI] = llllllllllllIlllIIIIIIlIIIllIlII;
    }
    
    public PathPoint[] getClosedSet() {
        return this.closedSet;
    }
    
    public PathPoint[] getOpenSet() {
        return this.openSet;
    }
    
    public boolean isFinished() {
        return this.currentPathIndex >= this.pathLength;
    }
    
    public Vec3d getVectorFromIndex(final Entity llllllllllllIlllIIIIIIlIIIIlIlll, final int llllllllllllIlllIIIIIIlIIIIlIllI) {
        final double llllllllllllIlllIIIIIIlIIIIlIlIl = this.points[llllllllllllIlllIIIIIIlIIIIlIllI].xCoord + (int)(llllllllllllIlllIIIIIIlIIIIlIlll.width + 1.0f) * 0.5;
        final double llllllllllllIlllIIIIIIlIIIIlIlII = this.points[llllllllllllIlllIIIIIIlIIIIlIllI].yCoord;
        final double llllllllllllIlllIIIIIIlIIIIlIIll = this.points[llllllllllllIlllIIIIIIlIIIIlIllI].zCoord + (int)(llllllllllllIlllIIIIIIlIIIIlIlll.width + 1.0f) * 0.5;
        return new Vec3d(llllllllllllIlllIIIIIIlIIIIlIlIl, llllllllllllIlllIIIIIIlIIIIlIlII, llllllllllllIlllIIIIIIlIIIIlIIll);
    }
}
