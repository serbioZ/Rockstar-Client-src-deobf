// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.dispenser;

public class PositionImpl implements IPosition
{
    protected final /* synthetic */ double y;
    protected final /* synthetic */ double x;
    protected final /* synthetic */ double z;
    
    @Override
    public double getY() {
        return this.y;
    }
    
    @Override
    public double getZ() {
        return this.z;
    }
    
    @Override
    public double getX() {
        return this.x;
    }
    
    public PositionImpl(final double lllllllllllllIlIlIIIIllIllIIlIIl, final double lllllllllllllIlIlIIIIllIllIIlIII, final double lllllllllllllIlIlIIIIllIllIIIIll) {
        this.x = lllllllllllllIlIlIIIIllIllIIlIIl;
        this.y = lllllllllllllIlIlIIIIllIllIIlIII;
        this.z = lllllllllllllIlIlIIIIllIllIIIIll;
    }
}
