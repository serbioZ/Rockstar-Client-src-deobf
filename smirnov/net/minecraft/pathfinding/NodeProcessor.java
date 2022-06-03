// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.IntHashMap;
import net.minecraft.entity.EntityLiving;

public abstract class NodeProcessor
{
    protected /* synthetic */ boolean canBreakDoors;
    protected /* synthetic */ EntityLiving entity;
    protected /* synthetic */ boolean canEnterDoors;
    protected /* synthetic */ int entitySizeZ;
    protected /* synthetic */ boolean canSwim;
    protected final /* synthetic */ IntHashMap<PathPoint> pointMap;
    protected /* synthetic */ int entitySizeY;
    protected /* synthetic */ IBlockAccess blockaccess;
    protected /* synthetic */ int entitySizeX;
    
    public abstract PathPoint getStart();
    
    public void setCanSwim(final boolean lllllllllllIlIllIIlIllIIIIlIllIl) {
        this.canSwim = lllllllllllIlIllIIlIllIIIIlIllIl;
    }
    
    public NodeProcessor() {
        this.pointMap = new IntHashMap<PathPoint>();
    }
    
    public abstract PathPoint getPathPointToCoords(final double p0, final double p1, final double p2);
    
    public boolean getCanSwim() {
        return this.canSwim;
    }
    
    public boolean getCanEnterDoors() {
        return this.canEnterDoors;
    }
    
    public void setCanEnterDoors(final boolean lllllllllllIlIllIIlIllIIIIlllIIl) {
        this.canEnterDoors = lllllllllllIlIllIIlIllIIIIlllIIl;
    }
    
    public void setCanBreakDoors(final boolean lllllllllllIlIllIIlIllIIIIllIIIl) {
        this.canBreakDoors = lllllllllllIlIllIIlIllIIIIllIIIl;
    }
    
    public abstract int findPathOptions(final PathPoint[] p0, final PathPoint p1, final PathPoint p2, final float p3);
    
    public abstract PathNodeType getPathNodeType(final IBlockAccess p0, final int p1, final int p2, final int p3, final EntityLiving p4, final int p5, final int p6, final int p7, final boolean p8, final boolean p9);
    
    protected PathPoint openPoint(final int lllllllllllIlIllIIlIllIIIlIIIIIl, final int lllllllllllIlIllIIlIllIIIlIIIIII, final int lllllllllllIlIllIIlIllIIIlIIIlIl) {
        final int lllllllllllIlIllIIlIllIIIlIIIlII = PathPoint.makeHash(lllllllllllIlIllIIlIllIIIlIIIIIl, lllllllllllIlIllIIlIllIIIlIIIIII, lllllllllllIlIllIIlIllIIIlIIIlIl);
        PathPoint lllllllllllIlIllIIlIllIIIlIIIIll = this.pointMap.lookup(lllllllllllIlIllIIlIllIIIlIIIlII);
        if (lllllllllllIlIllIIlIllIIIlIIIIll == null) {
            lllllllllllIlIllIIlIllIIIlIIIIll = new PathPoint(lllllllllllIlIllIIlIllIIIlIIIIIl, lllllllllllIlIllIIlIllIIIlIIIIII, lllllllllllIlIllIIlIllIIIlIIIlIl);
            this.pointMap.addKey(lllllllllllIlIllIIlIllIIIlIIIlII, lllllllllllIlIllIIlIllIIIlIIIIll);
        }
        return lllllllllllIlIllIIlIllIIIlIIIIll;
    }
    
    public void initProcessor(final IBlockAccess lllllllllllIlIllIIlIllIIIlIlIllI, final EntityLiving lllllllllllIlIllIIlIllIIIlIlIlIl) {
        this.blockaccess = lllllllllllIlIllIIlIllIIIlIlIllI;
        this.entity = lllllllllllIlIllIIlIllIIIlIlIlIl;
        this.pointMap.clearMap();
        this.entitySizeX = MathHelper.floor(lllllllllllIlIllIIlIllIIIlIlIlIl.width + 1.0f);
        this.entitySizeY = MathHelper.floor(lllllllllllIlIllIIlIllIIIlIlIlIl.height + 1.0f);
        this.entitySizeZ = MathHelper.floor(lllllllllllIlIllIIlIllIIIlIlIlIl.width + 1.0f);
    }
    
    public boolean getCanBreakDoors() {
        return this.canBreakDoors;
    }
    
    public abstract PathNodeType getPathNodeType(final IBlockAccess p0, final int p1, final int p2, final int p3);
    
    public void postProcess() {
        this.blockaccess = null;
        this.entity = null;
    }
}
