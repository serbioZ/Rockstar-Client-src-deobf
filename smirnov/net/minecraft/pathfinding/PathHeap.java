// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

public class PathHeap
{
    private /* synthetic */ PathPoint[] pathPoints;
    private /* synthetic */ int count;
    
    public PathHeap() {
        this.pathPoints = new PathPoint[128];
    }
    
    private void sortForward(int llllllllllIlllIIIllIlllIIlIllIIl) {
        final PathPoint llllllllllIlllIIIllIlllIIllIIlII = this.pathPoints[llllllllllIlllIIIllIlllIIlIllIIl];
        final float llllllllllIlllIIIllIlllIIllIIIll = llllllllllIlllIIIllIlllIIllIIlII.distanceToTarget;
        while (true) {
            final int llllllllllIlllIIIllIlllIIllIIIlI = (int)(1 + (llllllllllIlllIIIllIlllIIlIllIIl << 1));
            final int llllllllllIlllIIIllIlllIIllIIIIl = llllllllllIlllIIIllIlllIIllIIIlI + 1;
            if (llllllllllIlllIIIllIlllIIllIIIlI >= this.count) {
                break;
            }
            final PathPoint llllllllllIlllIIIllIlllIIllIIIII = this.pathPoints[llllllllllIlllIIIllIlllIIllIIIlI];
            final float llllllllllIlllIIIllIlllIIlIlllll = llllllllllIlllIIIllIlllIIllIIIII.distanceToTarget;
            PathPoint llllllllllIlllIIIllIlllIIlIlllIl = null;
            float llllllllllIlllIIIllIlllIIlIllIll = 0.0f;
            if (llllllllllIlllIIIllIlllIIllIIIIl >= this.count) {
                final PathPoint llllllllllIlllIIIllIlllIIlIllllI = null;
                final float llllllllllIlllIIIllIlllIIlIlllII = Float.POSITIVE_INFINITY;
            }
            else {
                llllllllllIlllIIIllIlllIIlIlllIl = this.pathPoints[llllllllllIlllIIIllIlllIIllIIIIl];
                llllllllllIlllIIIllIlllIIlIllIll = llllllllllIlllIIIllIlllIIlIlllIl.distanceToTarget;
            }
            if (llllllllllIlllIIIllIlllIIlIlllll < llllllllllIlllIIIllIlllIIlIllIll) {
                if (llllllllllIlllIIIllIlllIIlIlllll >= llllllllllIlllIIIllIlllIIllIIIll) {
                    break;
                }
                this.pathPoints[llllllllllIlllIIIllIlllIIlIllIIl] = llllllllllIlllIIIllIlllIIllIIIII;
                llllllllllIlllIIIllIlllIIllIIIII.index = (int)llllllllllIlllIIIllIlllIIlIllIIl;
                llllllllllIlllIIIllIlllIIlIllIIl = llllllllllIlllIIIllIlllIIllIIIlI;
            }
            else {
                if (llllllllllIlllIIIllIlllIIlIllIll >= llllllllllIlllIIIllIlllIIllIIIll) {
                    break;
                }
                this.pathPoints[llllllllllIlllIIIllIlllIIlIllIIl] = llllllllllIlllIIIllIlllIIlIlllIl;
                llllllllllIlllIIIllIlllIIlIlllIl.index = (int)llllllllllIlllIIIllIlllIIlIllIIl;
                llllllllllIlllIIIllIlllIIlIllIIl = llllllllllIlllIIIllIlllIIllIIIIl;
            }
        }
        this.pathPoints[llllllllllIlllIIIllIlllIIlIllIIl] = llllllllllIlllIIIllIlllIIllIIlII;
        llllllllllIlllIIIllIlllIIllIIlII.index = (int)llllllllllIlllIIIllIlllIIlIllIIl;
    }
    
    public boolean isPathEmpty() {
        return this.count == 0;
    }
    
    public void changeDistance(final PathPoint llllllllllIlllIIIllIlllIlIIIlIIl, final float llllllllllIlllIIIllIlllIlIIIlIII) {
        final float llllllllllIlllIIIllIlllIlIIIIlll = llllllllllIlllIIIllIlllIlIIIlIIl.distanceToTarget;
        llllllllllIlllIIIllIlllIlIIIlIIl.distanceToTarget = llllllllllIlllIIIllIlllIlIIIlIII;
        if (llllllllllIlllIIIllIlllIlIIIlIII < llllllllllIlllIIIllIlllIlIIIIlll) {
            this.sortBack(llllllllllIlllIIIllIlllIlIIIlIIl.index);
        }
        else {
            this.sortForward(llllllllllIlllIIIllIlllIlIIIlIIl.index);
        }
    }
    
    private void sortBack(int llllllllllIlllIIIllIlllIIlllIlIl) {
        final PathPoint llllllllllIlllIIIllIlllIIllllIlI = this.pathPoints[llllllllllIlllIIIllIlllIIlllIlIl];
        final float llllllllllIlllIIIllIlllIIllllIII = llllllllllIlllIIIllIlllIIllllIlI.distanceToTarget;
        while (llllllllllIlllIIIllIlllIIlllIlIl > 0) {
            final int llllllllllIlllIIIllIlllIIllllIIl = llllllllllIlllIIIllIlllIIlllIlIl - 1 >> 1;
            final PathPoint llllllllllIlllIIIllIlllIIlllIlll = this.pathPoints[llllllllllIlllIIIllIlllIIllllIIl];
            if (llllllllllIlllIIIllIlllIIllllIII >= llllllllllIlllIIIllIlllIIlllIlll.distanceToTarget) {
                break;
            }
            this.pathPoints[llllllllllIlllIIIllIlllIIlllIlIl] = llllllllllIlllIIIllIlllIIlllIlll;
            llllllllllIlllIIIllIlllIIlllIlll.index = llllllllllIlllIIIllIlllIIlllIlIl;
            llllllllllIlllIIIllIlllIIlllIlIl = llllllllllIlllIIIllIlllIIllllIIl;
        }
        this.pathPoints[llllllllllIlllIIIllIlllIIlllIlIl] = llllllllllIlllIIIllIlllIIllllIlI;
        llllllllllIlllIIIllIlllIIllllIlI.index = llllllllllIlllIIIllIlllIIlllIlIl;
    }
    
    public void clearPath() {
        this.count = 0;
    }
    
    public PathPoint addPoint(final PathPoint llllllllllIlllIIIllIlllIlIIllIIl) {
        if (llllllllllIlllIIIllIlllIlIIllIIl.index >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.count == this.pathPoints.length) {
            final PathPoint[] llllllllllIlllIIIllIlllIlIIllIll = new PathPoint[this.count << 1];
            System.arraycopy(this.pathPoints, 0, llllllllllIlllIIIllIlllIlIIllIll, 0, this.count);
            this.pathPoints = llllllllllIlllIIIllIlllIlIIllIll;
        }
        this.pathPoints[this.count] = llllllllllIlllIIIllIlllIlIIllIIl;
        llllllllllIlllIIIllIlllIlIIllIIl.index = this.count;
        this.sortBack(this.count++);
        return llllllllllIlllIIIllIlllIlIIllIIl;
    }
    
    public PathPoint dequeue() {
        final PathPoint llllllllllIlllIIIllIlllIlIIlIIIl = this.pathPoints[0];
        final PathPoint[] pathPoints = this.pathPoints;
        final int n = 0;
        final PathPoint[] pathPoints2 = this.pathPoints;
        final int count = this.count - 1;
        this.count = count;
        pathPoints[n] = pathPoints2[count];
        this.pathPoints[this.count] = null;
        if (this.count > 0) {
            this.sortForward(0);
        }
        llllllllllIlllIIIllIlllIlIIlIIIl.index = -1;
        return llllllllllIlllIIIllIlllIlIIlIIIl;
    }
}
