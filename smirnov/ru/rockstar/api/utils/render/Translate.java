// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

import net.minecraft.client.Minecraft;

public class Translate
{
    private /* synthetic */ long lastMS;
    private /* synthetic */ float y;
    private /* synthetic */ float x;
    
    public float getY() {
        return this.y;
    }
    
    public void interpolate(final float llllllllllIllllllIIllllIllllllll, final float llllllllllIllllllIIllllIlllllllI, final int llllllllllIllllllIIllllIllllllIl, final int llllllllllIllllllIIllllIllllllII) {
        final long llllllllllIllllllIIllllIlllllIll = System.currentTimeMillis();
        final long llllllllllIllllllIIllllIlllllIlI = llllllllllIllllllIIllllIlllllIll - this.lastMS;
        this.lastMS = llllllllllIllllllIIllllIlllllIll;
        final int llllllllllIllllllIIllllIlllllIIl = (int)(Math.abs(llllllllllIllllllIIllllIllllllll - this.x) * 0.51f);
        final int llllllllllIllllllIIllllIlllllIII = (int)(Math.abs(llllllllllIllllllIIllllIlllllllI - this.y) * 0.51f);
        this.x = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIllllllll, this.x, llllllllllIllllllIIllllIlllllIlI, llllllllllIllllllIIllllIlllllIIl);
        this.y = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIlllllllI, this.y, llllllllllIllllllIIllllIlllllIlI, llllllllllIllllllIIllllIlllllIII);
    }
    
    public void arrayListAnim(final float llllllllllIllllllIIllllIlIlllIlI, final float llllllllllIllllllIIllllIlIlllIIl, final float llllllllllIllllllIIllllIlIlllIII, final float llllllllllIllllllIIllllIlIllIlll) {
        final int llllllllllIllllllIIllllIlIllllIl = (int)(Math.abs(llllllllllIllllllIIllllIlIlllIlI - this.x) * llllllllllIllllllIIllllIlIlllIII);
        final int llllllllllIllllllIIllllIlIllllII = (int)(Math.abs(llllllllllIllllllIIllllIlIlllIIl - this.y) * llllllllllIllllllIIllllIlIllIlll);
        this.x = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIlIlllIlI, this.x, (long)Minecraft.frameTime, llllllllllIllllllIIllllIlIllllIl);
        this.y = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIlIlllIIl, this.y, (long)Minecraft.frameTime, llllllllllIllllllIIllllIlIllllII);
    }
    
    public void setX(final float llllllllllIllllllIIllllIlIlIllII) {
        this.x = llllllllllIllllllIIllllIlIlIllII;
    }
    
    public Translate(final float llllllllllIllllllIIlllllIIIIllII, final float llllllllllIllllllIIlllllIIIIlIll) {
        this.x = llllllllllIllllllIIlllllIIIIllII;
        this.y = llllllllllIllllllIIlllllIIIIlIll;
        this.lastMS = System.currentTimeMillis();
    }
    
    public final void interpolate(final float llllllllllIllllllIIllllIlllIIlll, final float llllllllllIllllllIIllllIlllIIllI, final float llllllllllIllllllIIllllIlllIlIIl) {
        this.x = (float)AnimationHelper.animate(llllllllllIllllllIIllllIlllIIlll, this.x, llllllllllIllllllIIllllIlllIlIIl);
        this.y = (float)AnimationHelper.animate(llllllllllIllllllIIllllIlllIIllI, this.y, llllllllllIllllllIIllllIlllIlIIl);
    }
    
    public void interpolate(final float llllllllllIllllllIIllllIllIlIIIl, final float llllllllllIllllllIIllllIllIlIIII, final double llllllllllIllllllIIllllIllIllIII, final double llllllllllIllllllIIllllIllIlIlll) {
        final long llllllllllIllllllIIllllIllIlIllI = System.currentTimeMillis();
        final long llllllllllIllllllIIllllIllIlIlIl = llllllllllIllllllIIllllIllIlIllI - this.lastMS;
        this.lastMS = llllllllllIllllllIIllllIllIlIllI;
        double llllllllllIllllllIIllllIllIlIlII = 0.0;
        double llllllllllIllllllIIllllIllIlIIll = 0.0;
        if (llllllllllIllllllIIllllIllIllIII != 0.0 || llllllllllIllllllIIllllIllIlIlll != 0.0) {
            llllllllllIllllllIIllllIllIlIlII = Math.abs(llllllllllIllllllIIllllIllIlIIIl - this.x) * 0.35f / (10.0 / llllllllllIllllllIIllllIllIllIII);
            llllllllllIllllllIIllllIllIlIIll = Math.abs(llllllllllIllllllIIllllIllIlIIII - this.y) * 0.35f / (10.0 / llllllllllIllllllIIllllIllIlIlll);
        }
        this.x = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIllIlIIIl, this.x, llllllllllIllllllIIllllIllIlIlIl, llllllllllIllllllIIllllIllIlIlII);
        this.y = AnimationHelper.calculateCompensation(llllllllllIllllllIIllllIllIlIIII, this.y, llllllllllIllllllIIllllIllIlIlIl, llllllllllIllllllIIllllIllIlIIll);
    }
    
    public void setY(final float llllllllllIllllllIIllllIlIlIIlIl) {
        this.y = llllllllllIllllllIIllllIlIlIIlIl;
    }
    
    public float getX() {
        return this.x;
    }
}
