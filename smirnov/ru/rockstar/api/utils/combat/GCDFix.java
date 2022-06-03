// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import net.minecraft.client.Minecraft;

public class GCDFix
{
    private /* synthetic */ float pitch;
    private /* synthetic */ float yaw;
    static /* synthetic */ Minecraft mc;
    
    public final void setYaw(final float llllllllllllIIlllIIlIIIllllIlIll) {
        this.yaw = llllllllllllIIlllIIlIIIllllIlIll;
    }
    
    @Override
    public int hashCode() {
        return Float.hashCode(this.yaw) * 31 + Float.hashCode(this.pitch);
    }
    
    public final float getYaw() {
        return this.yaw;
    }
    
    public GCDFix(final float llllllllllllIIlllIIlIIlIIIIIIIIl, final float llllllllllllIIlllIIlIIIlllllllIl) {
        this.yaw = llllllllllllIIlllIIlIIlIIIIIIIIl;
        this.pitch = llllllllllllIIlllIIlIIIlllllllIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIIlllIIlIIIlllIlIlII) {
        if (this == llllllllllllIIlllIIlIIIlllIlIlII) {
            return true;
        }
        if (llllllllllllIIlllIIlIIIlllIlIlII instanceof GCDFix) {
            final GCDFix llllllllllllIIlllIIlIIIlllIlIllI = (GCDFix)llllllllllllIIlllIIlIIIlllIlIlII;
            return Float.compare(this.yaw, llllllllllllIIlllIIlIIIlllIlIllI.yaw) == 0 && Float.compare(this.pitch, llllllllllllIIlllIIlIIIlllIlIllI.pitch) == 0;
        }
        return false;
    }
    
    public static float getGCD() {
        final float llllllllllllIIlllIIlIIIllllllIII;
        return (llllllllllllIIlllIIlIIIllllllIII = (float)(GCDFix.mc.gameSettings.mouseSensitivity * 0.6 + 0.2)) * llllllllllllIIlllIIlIIIllllllIII * llllllllllllIIlllIIlIIIllllllIII * 8.0f;
    }
    
    public final void setPitch(final float llllllllllllIIlllIIlIIIllllIIIlI) {
        this.pitch = llllllllllllIIlllIIlIIIllllIIIlI;
    }
    
    public static float getDeltaMouse(final float llllllllllllIIlllIIlIIIlllllIlII) {
        return (float)Math.round(llllllllllllIIlllIIlIIIlllllIlII / getGCDValue());
    }
    
    public final float getPitch() {
        return this.pitch;
    }
    
    @Override
    public String toString() {
        return "Rotation(yaw=" + this.yaw + ", pitch=" + this.pitch + ")";
    }
    
    public static float getGCDValue() {
        return (float)(getGCD() * 0.15);
    }
    
    static {
        GCDFix.mc = Minecraft.getMinecraft();
    }
    
    public static float getFixedRotation(final float llllllllllllIIlllIIlIIIllllllIlI) {
        return getDeltaMouse(llllllllllllIIlllIIlIIIllllllIlI) * getGCDValue();
    }
}
