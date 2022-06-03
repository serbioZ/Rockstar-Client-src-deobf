// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.IBlockAccess;
import com.google.common.collect.Sets;
import java.util.Set;

public class PathFinder
{
    private final /* synthetic */ NodeProcessor nodeProcessor;
    private final /* synthetic */ PathPoint[] pathOptions;
    private final /* synthetic */ Set<PathPoint> closedSet;
    private final /* synthetic */ PathHeap path;
    
    public PathFinder(final NodeProcessor llllllllllllllllIllIlIlIlIlIIlll) {
        this.path = new PathHeap();
        this.closedSet = (Set<PathPoint>)Sets.newHashSet();
        this.pathOptions = new PathPoint[32];
        this.nodeProcessor = llllllllllllllllIllIlIlIlIlIIlll;
    }
    
    @Nullable
    public Path findPath(final IBlockAccess llllllllllllllllIllIlIlIlIIIlIlI, final EntityLiving llllllllllllllllIllIlIlIlIIIlIIl, final BlockPos llllllllllllllllIllIlIlIlIIIlIII, final float llllllllllllllllIllIlIlIlIIIIlll) {
        return this.findPath(llllllllllllllllIllIlIlIlIIIlIlI, llllllllllllllllIllIlIlIlIIIlIIl, llllllllllllllllIllIlIlIlIIIlIII.getX() + 0.5f, llllllllllllllllIllIlIlIlIIIlIII.getY() + 0.5f, llllllllllllllllIllIlIlIlIIIlIII.getZ() + 0.5f, llllllllllllllllIllIlIlIlIIIIlll);
    }
    
    private Path createEntityPath(final PathPoint llllllllllllllllIllIlIlIIIlllllI, final PathPoint llllllllllllllllIllIlIlIIIlllIII) {
        int llllllllllllllllIllIlIlIIIllllII = 1;
        for (PathPoint llllllllllllllllIllIlIlIIIlllIll = llllllllllllllllIllIlIlIIIlllIII; llllllllllllllllIllIlIlIIIlllIll.previous != null; llllllllllllllllIllIlIlIIIlllIll = llllllllllllllllIllIlIlIIIlllIll.previous) {
            ++llllllllllllllllIllIlIlIIIllllII;
        }
        final PathPoint[] llllllllllllllllIllIlIlIIIlllIlI = new PathPoint[llllllllllllllllIllIlIlIIIllllII];
        PathPoint llllllllllllllllIllIlIlIIIlllIIl = llllllllllllllllIllIlIlIIIlllIII;
        --llllllllllllllllIllIlIlIIIllllII;
        llllllllllllllllIllIlIlIIIlllIlI[llllllllllllllllIllIlIlIIIllllII] = llllllllllllllllIllIlIlIIIlllIII;
        while (llllllllllllllllIllIlIlIIIlllIIl.previous != null) {
            llllllllllllllllIllIlIlIIIlllIIl = llllllllllllllllIllIlIlIIIlllIIl.previous;
            --llllllllllllllllIllIlIlIIIllllII;
            llllllllllllllllIllIlIlIIIlllIlI[llllllllllllllllIllIlIlIIIllllII] = llllllllllllllllIllIlIlIIIlllIIl;
        }
        return new Path(llllllllllllllllIllIlIlIIIlllIlI);
    }
    
    @Nullable
    private Path findPath(final PathPoint llllllllllllllllIllIlIlIIlIIlllI, final PathPoint llllllllllllllllIllIlIlIIlIIllIl, final float llllllllllllllllIllIlIlIIlIIllII) {
        llllllllllllllllIllIlIlIIlIIlllI.totalPathDistance = 0.0f;
        llllllllllllllllIllIlIlIIlIIlllI.distanceToNext = llllllllllllllllIllIlIlIIlIIlllI.distanceManhattan(llllllllllllllllIllIlIlIIlIIllIl);
        llllllllllllllllIllIlIlIIlIIlllI.distanceToTarget = llllllllllllllllIllIlIlIIlIIlllI.distanceToNext;
        this.path.clearPath();
        this.closedSet.clear();
        this.path.addPoint(llllllllllllllllIllIlIlIIlIIlllI);
        PathPoint llllllllllllllllIllIlIlIIlIllIII = llllllllllllllllIllIlIlIIlIIlllI;
        int llllllllllllllllIllIlIlIIlIlIlll = 0;
        while (!this.path.isPathEmpty()) {
            if (++llllllllllllllllIllIlIlIIlIlIlll >= 200) {
                break;
            }
            final PathPoint llllllllllllllllIllIlIlIIlIlIllI = this.path.dequeue();
            if (llllllllllllllllIllIlIlIIlIlIllI.equals(llllllllllllllllIllIlIlIIlIIllIl)) {
                llllllllllllllllIllIlIlIIlIllIII = llllllllllllllllIllIlIlIIlIIllIl;
                break;
            }
            if (llllllllllllllllIllIlIlIIlIlIllI.distanceManhattan(llllllllllllllllIllIlIlIIlIIllIl) < llllllllllllllllIllIlIlIIlIllIII.distanceManhattan(llllllllllllllllIllIlIlIIlIIllIl)) {
                llllllllllllllllIllIlIlIIlIllIII = llllllllllllllllIllIlIlIIlIlIllI;
            }
            llllllllllllllllIllIlIlIIlIlIllI.visited = true;
            for (int llllllllllllllllIllIlIlIIlIlIlIl = this.nodeProcessor.findPathOptions(this.pathOptions, llllllllllllllllIllIlIlIIlIlIllI, llllllllllllllllIllIlIlIIlIIllIl, llllllllllllllllIllIlIlIIlIIllII), llllllllllllllllIllIlIlIIlIlIlII = 0; llllllllllllllllIllIlIlIIlIlIlII < llllllllllllllllIllIlIlIIlIlIlIl; ++llllllllllllllllIllIlIlIIlIlIlII) {
                final PathPoint llllllllllllllllIllIlIlIIlIlIIll = this.pathOptions[llllllllllllllllIllIlIlIIlIlIlII];
                final float llllllllllllllllIllIlIlIIlIlIIlI = llllllllllllllllIllIlIlIIlIlIllI.distanceManhattan(llllllllllllllllIllIlIlIIlIlIIll);
                llllllllllllllllIllIlIlIIlIlIIll.distanceFromOrigin = llllllllllllllllIllIlIlIIlIlIllI.distanceFromOrigin + llllllllllllllllIllIlIlIIlIlIIlI;
                llllllllllllllllIllIlIlIIlIlIIll.cost = llllllllllllllllIllIlIlIIlIlIIlI + llllllllllllllllIllIlIlIIlIlIIll.costMalus;
                final float llllllllllllllllIllIlIlIIlIlIIIl = llllllllllllllllIllIlIlIIlIlIllI.totalPathDistance + llllllllllllllllIllIlIlIIlIlIIll.cost;
                if (llllllllllllllllIllIlIlIIlIlIIll.distanceFromOrigin < llllllllllllllllIllIlIlIIlIIllII && (!llllllllllllllllIllIlIlIIlIlIIll.isAssigned() || llllllllllllllllIllIlIlIIlIlIIIl < llllllllllllllllIllIlIlIIlIlIIll.totalPathDistance)) {
                    llllllllllllllllIllIlIlIIlIlIIll.previous = llllllllllllllllIllIlIlIIlIlIllI;
                    llllllllllllllllIllIlIlIIlIlIIll.totalPathDistance = llllllllllllllllIllIlIlIIlIlIIIl;
                    llllllllllllllllIllIlIlIIlIlIIll.distanceToNext = llllllllllllllllIllIlIlIIlIlIIll.distanceManhattan(llllllllllllllllIllIlIlIIlIIllIl) + llllllllllllllllIllIlIlIIlIlIIll.costMalus;
                    if (llllllllllllllllIllIlIlIIlIlIIll.isAssigned()) {
                        this.path.changeDistance(llllllllllllllllIllIlIlIIlIlIIll, llllllllllllllllIllIlIlIIlIlIIll.totalPathDistance + llllllllllllllllIllIlIlIIlIlIIll.distanceToNext);
                    }
                    else {
                        llllllllllllllllIllIlIlIIlIlIIll.distanceToTarget = llllllllllllllllIllIlIlIIlIlIIll.totalPathDistance + llllllllllllllllIllIlIlIIlIlIIll.distanceToNext;
                        this.path.addPoint(llllllllllllllllIllIlIlIIlIlIIll);
                    }
                }
            }
        }
        if (llllllllllllllllIllIlIlIIlIllIII == llllllllllllllllIllIlIlIIlIIlllI) {
            return null;
        }
        final Path llllllllllllllllIllIlIlIIlIlIIII = this.createEntityPath(llllllllllllllllIllIlIlIIlIIlllI, llllllllllllllllIllIlIlIIlIllIII);
        return llllllllllllllllIllIlIlIIlIlIIII;
    }
    
    @Nullable
    public Path findPath(final IBlockAccess llllllllllllllllIllIlIlIlIIllIIl, final EntityLiving llllllllllllllllIllIlIlIlIIlllIl, final Entity llllllllllllllllIllIlIlIlIIlllII, final float llllllllllllllllIllIlIlIlIIlIllI) {
        return this.findPath(llllllllllllllllIllIlIlIlIIllIIl, llllllllllllllllIllIlIlIlIIlllIl, llllllllllllllllIllIlIlIlIIlllII.posX, llllllllllllllllIllIlIlIlIIlllII.getEntityBoundingBox().minY, llllllllllllllllIllIlIlIlIIlllII.posZ, llllllllllllllllIllIlIlIlIIlIllI);
    }
    
    @Nullable
    private Path findPath(final IBlockAccess llllllllllllllllIllIlIlIIllllIll, final EntityLiving llllllllllllllllIllIlIlIIllllIlI, final double llllllllllllllllIllIlIlIIllIllll, final double llllllllllllllllIllIlIlIIllIlllI, final double llllllllllllllllIllIlIlIIllIllIl, final float llllllllllllllllIllIlIlIIllIllII) {
        this.path.clearPath();
        this.nodeProcessor.initProcessor(llllllllllllllllIllIlIlIIllllIll, llllllllllllllllIllIlIlIIllllIlI);
        final PathPoint llllllllllllllllIllIlIlIIlllIlIl = this.nodeProcessor.getStart();
        final PathPoint llllllllllllllllIllIlIlIIlllIlII = this.nodeProcessor.getPathPointToCoords(llllllllllllllllIllIlIlIIllIllll, llllllllllllllllIllIlIlIIllIlllI, llllllllllllllllIllIlIlIIllIllIl);
        final Path llllllllllllllllIllIlIlIIlllIIll = this.findPath(llllllllllllllllIllIlIlIIlllIlIl, llllllllllllllllIllIlIlIIlllIlII, llllllllllllllllIllIlIlIIllIllII);
        this.nodeProcessor.postProcess();
        return llllllllllllllllIllIlIlIIlllIIll;
    }
}
