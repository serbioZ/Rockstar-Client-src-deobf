// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.border;

public enum EnumBorderStatus
{
    private final /* synthetic */ int id;
    
    GROWING("GROWING", 0, 4259712), 
    SHRINKING("SHRINKING", 1, 16724016), 
    STATIONARY("STATIONARY", 2, 2138367);
    
    private EnumBorderStatus(final String lllllllllllIllllllllllIIlIlIIlIl, final int lllllllllllIllllllllllIIlIlIIlII, final int lllllllllllIllllllllllIIlIlIIlll) {
        this.id = lllllllllllIllllllllllIIlIlIIlll;
    }
    
    public int getID() {
        return this.id;
    }
}
