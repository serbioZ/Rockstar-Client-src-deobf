// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.math.MathHelper;
import net.minecraft.network.PacketBuffer;

public class PathPoint
{
    public /* synthetic */ PathNodeType nodeType;
    public final /* synthetic */ int zCoord;
    public /* synthetic */ float distanceFromOrigin;
    public final /* synthetic */ int yCoord;
    private final /* synthetic */ int hash;
    public /* synthetic */ float totalPathDistance;
    public /* synthetic */ float distanceToNext;
    public /* synthetic */ PathPoint previous;
    public final /* synthetic */ int xCoord;
    public /* synthetic */ float distanceToTarget;
    public /* synthetic */ float cost;
    public /* synthetic */ int index;
    public /* synthetic */ float costMalus;
    public /* synthetic */ boolean visited;
    
    public static int makeHash(final int lllllllllllIlIIlIIlIIlIIIIIlllIl, final int lllllllllllIlIIlIIlIIlIIIIIlllII, final int lllllllllllIlIIlIIlIIlIIIIIllllI) {
        return (lllllllllllIlIIlIIlIIlIIIIIlllII & 0xFF) | (lllllllllllIlIIlIIlIIlIIIIIlllIl & 0x7FFF) << 8 | (lllllllllllIlIIlIIlIIlIIIIIllllI & 0x7FFF) << 24 | ((lllllllllllIlIIlIIlIIlIIIIIlllIl < 0) ? Integer.MIN_VALUE : 0) | ((lllllllllllIlIIlIIlIIlIIIIIllllI < 0) ? 32768 : 0);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.xCoord) + ", " + this.yCoord + ", " + this.zCoord;
    }
    
    public boolean isAssigned() {
        return this.index >= 0;
    }
    
    @Override
    public int hashCode() {
        return this.hash;
    }
    
    public float distanceManhattan(final PathPoint lllllllllllIlIIlIIlIIIllllllIllI) {
        final float lllllllllllIlIIlIIlIIIllllllIlIl = (float)Math.abs(lllllllllllIlIIlIIlIIIllllllIllI.xCoord - this.xCoord);
        final float lllllllllllIlIIlIIlIIIllllllIlII = (float)Math.abs(lllllllllllIlIIlIIlIIIllllllIllI.yCoord - this.yCoord);
        final float lllllllllllIlIIlIIlIIIllllllIIll = (float)Math.abs(lllllllllllIlIIlIIlIIIllllllIllI.zCoord - this.zCoord);
        return lllllllllllIlIIlIIlIIIllllllIlIl + lllllllllllIlIIlIIlIIIllllllIlII + lllllllllllIlIIlIIlIIIllllllIIll;
    }
    
    public static PathPoint createFromBuffer(final PacketBuffer lllllllllllIlIIlIIlIIIllllIllIIl) {
        final PathPoint lllllllllllIlIIlIIlIIIllllIllIII = new PathPoint(lllllllllllIlIIlIIlIIIllllIllIIl.readInt(), lllllllllllIlIIlIIlIIIllllIllIIl.readInt(), lllllllllllIlIIlIIlIIIllllIllIIl.readInt());
        lllllllllllIlIIlIIlIIIllllIllIII.distanceFromOrigin = lllllllllllIlIIlIIlIIIllllIllIIl.readFloat();
        lllllllllllIlIIlIIlIIIllllIllIII.cost = lllllllllllIlIIlIIlIIIllllIllIIl.readFloat();
        lllllllllllIlIIlIIlIIIllllIllIII.costMalus = lllllllllllIlIIlIIlIIIllllIllIIl.readFloat();
        lllllllllllIlIIlIIlIIIllllIllIII.visited = lllllllllllIlIIlIIlIIIllllIllIIl.readBoolean();
        lllllllllllIlIIlIIlIIIllllIllIII.nodeType = PathNodeType.values()[lllllllllllIlIIlIIlIIIllllIllIIl.readInt()];
        lllllllllllIlIIlIIlIIIllllIllIII.distanceToTarget = lllllllllllIlIIlIIlIIIllllIllIIl.readFloat();
        return lllllllllllIlIIlIIlIIIllllIllIII;
    }
    
    public float distanceTo(final PathPoint lllllllllllIlIIlIIlIIlIIIIIlIlII) {
        final float lllllllllllIlIIlIIlIIlIIIIIlIIll = (float)(lllllllllllIlIIlIIlIIlIIIIIlIlII.xCoord - this.xCoord);
        final float lllllllllllIlIIlIIlIIlIIIIIlIIlI = (float)(lllllllllllIlIIlIIlIIlIIIIIlIlII.yCoord - this.yCoord);
        final float lllllllllllIlIIlIIlIIlIIIIIlIIIl = (float)(lllllllllllIlIIlIIlIIlIIIIIlIlII.zCoord - this.zCoord);
        return MathHelper.sqrt(lllllllllllIlIIlIIlIIlIIIIIlIIll * lllllllllllIlIIlIIlIIlIIIIIlIIll + lllllllllllIlIIlIIlIIlIIIIIlIIlI * lllllllllllIlIIlIIlIIlIIIIIlIIlI + lllllllllllIlIIlIIlIIlIIIIIlIIIl * lllllllllllIlIIlIIlIIlIIIIIlIIIl);
    }
    
    public PathPoint(final int lllllllllllIlIIlIIlIIlIIIIlllIIl, final int lllllllllllIlIIlIIlIIlIIIIlllIII, final int lllllllllllIlIIlIIlIIlIIIIllIlll) {
        this.index = -1;
        this.nodeType = PathNodeType.BLOCKED;
        this.xCoord = lllllllllllIlIIlIIlIIlIIIIlllIIl;
        this.yCoord = lllllllllllIlIIlIIlIIlIIIIlllIII;
        this.zCoord = lllllllllllIlIIlIIlIIlIIIIllIlll;
        this.hash = makeHash(lllllllllllIlIIlIIlIIlIIIIlllIIl, lllllllllllIlIIlIIlIIlIIIIlllIII, lllllllllllIlIIlIIlIIlIIIIllIlll);
    }
    
    public PathPoint cloneMove(final int lllllllllllIlIIlIIlIIlIIIIlIIlll, final int lllllllllllIlIIlIIlIIlIIIIlIlIll, final int lllllllllllIlIIlIIlIIlIIIIlIIlIl) {
        final PathPoint lllllllllllIlIIlIIlIIlIIIIlIlIIl = new PathPoint(lllllllllllIlIIlIIlIIlIIIIlIIlll, lllllllllllIlIIlIIlIIlIIIIlIlIll, lllllllllllIlIIlIIlIIlIIIIlIIlIl);
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.index = this.index;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.totalPathDistance = this.totalPathDistance;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.distanceToNext = this.distanceToNext;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.distanceToTarget = this.distanceToTarget;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.previous = this.previous;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.visited = this.visited;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.distanceFromOrigin = this.distanceFromOrigin;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.cost = this.cost;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.costMalus = this.costMalus;
        lllllllllllIlIIlIIlIIlIIIIlIlIIl.nodeType = this.nodeType;
        return lllllllllllIlIIlIIlIIlIIIIlIlIIl;
    }
    
    public float distanceToSquared(final PathPoint lllllllllllIlIIlIIlIIlIIIIIIIlIl) {
        final float lllllllllllIlIIlIIlIIlIIIIIIIlII = (float)(lllllllllllIlIIlIIlIIlIIIIIIIlIl.xCoord - this.xCoord);
        final float lllllllllllIlIIlIIlIIlIIIIIIIIll = (float)(lllllllllllIlIIlIIlIIlIIIIIIIlIl.yCoord - this.yCoord);
        final float lllllllllllIlIIlIIlIIlIIIIIIIIlI = (float)(lllllllllllIlIIlIIlIIlIIIIIIIlIl.zCoord - this.zCoord);
        return lllllllllllIlIIlIIlIIlIIIIIIIlII * lllllllllllIlIIlIIlIIlIIIIIIIlII + lllllllllllIlIIlIIlIIlIIIIIIIIll * lllllllllllIlIIlIIlIIlIIIIIIIIll + lllllllllllIlIIlIIlIIlIIIIIIIIlI * lllllllllllIlIIlIIlIIlIIIIIIIIlI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIlIIlIIlIIIlllllIlIIl) {
        if (!(lllllllllllIlIIlIIlIIIlllllIlIIl instanceof PathPoint)) {
            return false;
        }
        final PathPoint lllllllllllIlIIlIIlIIIlllllIlIII = (PathPoint)lllllllllllIlIIlIIlIIIlllllIlIIl;
        return this.hash == lllllllllllIlIIlIIlIIIlllllIlIII.hash && this.xCoord == lllllllllllIlIIlIIlIIIlllllIlIII.xCoord && this.yCoord == lllllllllllIlIIlIIlIIIlllllIlIII.yCoord && this.zCoord == lllllllllllIlIIlIIlIIIlllllIlIII.zCoord;
    }
}
