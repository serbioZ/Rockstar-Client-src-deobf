// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.border;

import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import com.google.common.collect.Lists;
import net.minecraft.util.math.ChunkPos;
import java.util.List;

public class WorldBorder
{
    private /* synthetic */ double damageBuffer;
    private /* synthetic */ double centerZ;
    private /* synthetic */ double centerX;
    private /* synthetic */ int warningTime;
    private /* synthetic */ double endDiameter;
    private /* synthetic */ int warningDistance;
    private final /* synthetic */ List<IBorderListener> listeners;
    private /* synthetic */ long startTime;
    private /* synthetic */ double startDiameter;
    private /* synthetic */ long endTime;
    private /* synthetic */ double damageAmount;
    private /* synthetic */ int worldSize;
    
    public int getWarningDistance() {
        return this.warningDistance;
    }
    
    public boolean contains(final ChunkPos lllllllllllIllllIIlIlIIIlIIIIllI) {
        return lllllllllllIllllIIlIlIIIlIIIIllI.getXEnd() > this.minX() && lllllllllllIllllIIlIlIIIlIIIIllI.getXStart() < this.maxX() && lllllllllllIllllIIlIlIIIlIIIIllI.getZEnd() > this.minZ() && lllllllllllIllllIIlIlIIIlIIIIllI.getZStart() < this.maxZ();
    }
    
    public void setTransition(final double lllllllllllIllllIIlIlIIIIIIIllll, final double lllllllllllIllllIIlIlIIIIIIIlllI, final long lllllllllllIllllIIlIlIIIIIIlIIlI) {
        this.startDiameter = lllllllllllIllllIIlIlIIIIIIIllll;
        this.endDiameter = lllllllllllIllllIIlIlIIIIIIIlllI;
        this.startTime = System.currentTimeMillis();
        this.endTime = this.startTime + lllllllllllIllllIIlIlIIIIIIlIIlI;
        for (final IBorderListener lllllllllllIllllIIlIlIIIIIIlIIIl : this.getListeners()) {
            lllllllllllIllllIIlIlIIIIIIlIIIl.onTransitionStarted(this, lllllllllllIllllIIlIlIIIIIIIllll, lllllllllllIllllIIlIlIIIIIIIlllI, lllllllllllIllllIIlIlIIIIIIlIIlI);
        }
    }
    
    public void setSize(final int lllllllllllIllllIIlIIllllllllllI) {
        this.worldSize = lllllllllllIllllIIlIIllllllllllI;
    }
    
    public WorldBorder() {
        this.listeners = (List<IBorderListener>)Lists.newArrayList();
        this.startDiameter = 6.0E7;
        this.endDiameter = this.startDiameter;
        this.worldSize = 29999984;
        this.damageAmount = 0.2;
        this.damageBuffer = 5.0;
        this.warningTime = 15;
        this.warningDistance = 5;
    }
    
    public void setTransition(final double lllllllllllIllllIIlIlIIIIIIllllI) {
        this.startDiameter = lllllllllllIllllIIlIlIIIIIIllllI;
        this.endDiameter = lllllllllllIllllIIlIlIIIIIIllllI;
        this.endTime = System.currentTimeMillis();
        this.startTime = this.endTime;
        for (final IBorderListener lllllllllllIllllIIlIlIIIIIlIIIII : this.getListeners()) {
            lllllllllllIllllIIlIlIIIIIlIIIII.onSizeChanged(this, lllllllllllIllllIIlIlIIIIIIllllI);
        }
    }
    
    public double getTargetSize() {
        return this.endDiameter;
    }
    
    public double maxZ() {
        double lllllllllllIllllIIlIlIIIIlIIlIIl = this.getCenterZ() + this.getDiameter() / 2.0;
        if (lllllllllllIllllIIlIlIIIIlIIlIIl > this.worldSize) {
            lllllllllllIllllIIlIlIIIIlIIlIIl = this.worldSize;
        }
        return lllllllllllIllllIIlIlIIIIlIIlIIl;
    }
    
    public boolean contains(final AxisAlignedBB lllllllllllIllllIIlIlIIIlIIIIIlI) {
        return lllllllllllIllllIIlIlIIIlIIIIIlI.maxX > this.minX() && lllllllllllIllllIIlIlIIIlIIIIIlI.minX < this.maxX() && lllllllllllIllllIIlIlIIIlIIIIIlI.maxZ > this.minZ() && lllllllllllIllllIIlIlIIIlIIIIIlI.minZ < this.maxZ();
    }
    
    public double minZ() {
        double lllllllllllIllllIIlIlIIIIlIlIlIl = this.getCenterZ() - this.getDiameter() / 2.0;
        if (lllllllllllIllllIIlIlIIIIlIlIlIl < -this.worldSize) {
            lllllllllllIllllIIlIlIIIIlIlIlIl = -this.worldSize;
        }
        return lllllllllllIllllIIlIlIIIIlIlIlIl;
    }
    
    protected List<IBorderListener> getListeners() {
        return (List<IBorderListener>)Lists.newArrayList((Iterable)this.listeners);
    }
    
    public void setWarningDistance(final int lllllllllllIllllIIlIIlllllIIIIII) {
        this.warningDistance = lllllllllllIllllIIlIIlllllIIIIII;
        for (final IBorderListener lllllllllllIllllIIlIIlllllIIIIlI : this.getListeners()) {
            lllllllllllIllllIIlIIlllllIIIIlI.onWarningDistanceChanged(this, lllllllllllIllllIIlIIlllllIIIIII);
        }
    }
    
    public double getClosestDistance(final Entity lllllllllllIllllIIlIlIIIIlllllII) {
        return this.getClosestDistance(lllllllllllIllllIIlIlIIIIlllllII.posX, lllllllllllIllllIIlIlIIIIlllllII.posZ);
    }
    
    public double getCenterX() {
        return this.centerX;
    }
    
    public double getDiameter() {
        if (this.getStatus() != EnumBorderStatus.STATIONARY) {
            final double lllllllllllIllllIIlIlIIIIIlIllll = (System.currentTimeMillis() - this.startTime) / (float)(this.endTime - this.startTime);
            if (lllllllllllIllllIIlIlIIIIIlIllll < 1.0) {
                return this.startDiameter + (this.endDiameter - this.startDiameter) * lllllllllllIllllIIlIlIIIIIlIllll;
            }
            this.setTransition(this.endDiameter);
        }
        return this.startDiameter;
    }
    
    public void setDamageAmount(final double lllllllllllIllllIIlIIllllllIIIlI) {
        this.damageAmount = lllllllllllIllllIIlIIllllllIIIlI;
        for (final IBorderListener lllllllllllIllllIIlIIllllllIIIIl : this.getListeners()) {
            lllllllllllIllllIIlIIllllllIIIIl.onDamageAmountChanged(this, lllllllllllIllllIIlIIllllllIIIlI);
        }
    }
    
    public EnumBorderStatus getStatus() {
        if (this.endDiameter < this.startDiameter) {
            return EnumBorderStatus.SHRINKING;
        }
        return (this.endDiameter > this.startDiameter) ? EnumBorderStatus.GROWING : EnumBorderStatus.STATIONARY;
    }
    
    public double maxX() {
        double lllllllllllIllllIIlIlIIIIlIIllll = this.getCenterX() + this.getDiameter() / 2.0;
        if (lllllllllllIllllIIlIlIIIIlIIllll > this.worldSize) {
            lllllllllllIllllIIlIlIIIIlIIllll = this.worldSize;
        }
        return lllllllllllIllllIIlIlIIIIlIIllll;
    }
    
    public double minX() {
        double lllllllllllIllllIIlIlIIIIlIllIll = this.getCenterX() - this.getDiameter() / 2.0;
        if (lllllllllllIllllIIlIlIIIIlIllIll < -this.worldSize) {
            lllllllllllIllllIIlIlIIIIlIllIll = -this.worldSize;
        }
        return lllllllllllIllllIIlIlIIIIlIllIll;
    }
    
    public void addListener(final IBorderListener lllllllllllIllllIIlIlIIIIIIIIIlI) {
        this.listeners.add(lllllllllllIllllIIlIlIIIIIIIIIlI);
    }
    
    public double getClosestDistance(final double lllllllllllIllllIIlIlIIIIllIlIII, final double lllllllllllIllllIIlIlIIIIllIllll) {
        final double lllllllllllIllllIIlIlIIIIllIlllI = lllllllllllIllllIIlIlIIIIllIllll - this.minZ();
        final double lllllllllllIllllIIlIlIIIIllIllIl = this.maxZ() - lllllllllllIllllIIlIlIIIIllIllll;
        final double lllllllllllIllllIIlIlIIIIllIllII = lllllllllllIllllIIlIlIIIIllIlIII - this.minX();
        final double lllllllllllIllllIIlIlIIIIllIlIll = this.maxX() - lllllllllllIllllIIlIlIIIIllIlIII;
        double lllllllllllIllllIIlIlIIIIllIlIlI = Math.min(lllllllllllIllllIIlIlIIIIllIllII, lllllllllllIllllIIlIlIIIIllIlIll);
        lllllllllllIllllIIlIlIIIIllIlIlI = Math.min(lllllllllllIllllIIlIlIIIIllIlIlI, lllllllllllIllllIIlIlIIIIllIlllI);
        return Math.min(lllllllllllIllllIIlIlIIIIllIlIlI, lllllllllllIllllIIlIlIIIIllIllIl);
    }
    
    public void setDamageBuffer(final double lllllllllllIllllIIlIIllllllIllIl) {
        this.damageBuffer = lllllllllllIllllIIlIIllllllIllIl;
        for (final IBorderListener lllllllllllIllllIIlIIllllllIllll : this.getListeners()) {
            lllllllllllIllllIIlIIllllllIllll.onDamageBufferChanged(this, lllllllllllIllllIIlIIllllllIllIl);
        }
    }
    
    public void setCenter(final double lllllllllllIllllIIlIlIIIIIlllIlI, final double lllllllllllIllllIIlIlIIIIIlllIIl) {
        this.centerX = lllllllllllIllllIIlIlIIIIIlllIlI;
        this.centerZ = lllllllllllIllllIIlIlIIIIIlllIIl;
        for (final IBorderListener lllllllllllIllllIIlIlIIIIIlllIII : this.getListeners()) {
            lllllllllllIllllIIlIlIIIIIlllIII.onCenterChanged(this, lllllllllllIllllIIlIlIIIIIlllIlI, lllllllllllIllllIIlIlIIIIIlllIIl);
        }
    }
    
    public double getResizeSpeed() {
        return (this.endTime == this.startTime) ? 0.0 : (Math.abs(this.startDiameter - this.endDiameter) / (this.endTime - this.startTime));
    }
    
    public void setWarningTime(final int lllllllllllIllllIIlIIlllllIlIIIl) {
        this.warningTime = lllllllllllIllllIIlIIlllllIlIIIl;
        for (final IBorderListener lllllllllllIllllIIlIIlllllIlIIII : this.getListeners()) {
            lllllllllllIllllIIlIIlllllIlIIII.onWarningTimeChanged(this, lllllllllllIllllIIlIIlllllIlIIIl);
        }
    }
    
    public boolean contains(final BlockPos lllllllllllIllllIIlIlIIIlIIIlllI) {
        return lllllllllllIllllIIlIlIIIlIIIlllI.getX() + 1 > this.minX() && lllllllllllIllllIIlIlIIIlIIIlllI.getX() < this.maxX() && lllllllllllIllllIIlIlIIIlIIIlllI.getZ() + 1 > this.minZ() && lllllllllllIllllIIlIlIIIlIIIlllI.getZ() < this.maxZ();
    }
    
    public long getTimeUntilTarget() {
        return (this.getStatus() == EnumBorderStatus.STATIONARY) ? 0L : (this.endTime - System.currentTimeMillis());
    }
    
    public int getSize() {
        return this.worldSize;
    }
    
    public double getDamageBuffer() {
        return this.damageBuffer;
    }
    
    public double getCenterZ() {
        return this.centerZ;
    }
    
    public double getDamageAmount() {
        return this.damageAmount;
    }
    
    public int getWarningTime() {
        return this.warningTime;
    }
}
