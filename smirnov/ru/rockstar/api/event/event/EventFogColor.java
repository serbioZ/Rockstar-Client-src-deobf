// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import ru.rockstar.api.event.Event;

public class EventFogColor extends Event
{
    public /* synthetic */ int alpha;
    public /* synthetic */ float green;
    public /* synthetic */ float blue;
    public /* synthetic */ float red;
    
    public int getAlpha() {
        return this.alpha;
    }
    
    public float getRed() {
        return this.red;
    }
    
    public void setBlue(final float llllllllllllIIIlIIlIIlIIIIlIIIII) {
        this.blue = llllllllllllIIIlIIlIIlIIIIlIIIII;
    }
    
    public void setGreen(final float llllllllllllIIIlIIlIIlIIIIlIlIIl) {
        this.green = llllllllllllIIIlIIlIIlIIIIlIlIIl;
    }
    
    public void setRed(final float llllllllllllIIIlIIlIIlIIIIllIIlI) {
        this.red = llllllllllllIIIlIIlIIlIIIIllIIlI;
    }
    
    public void setAlpha(final int llllllllllllIIIlIIlIIlIIIIIlIlll) {
        this.alpha = llllllllllllIIIlIIlIIlIIIIIlIlll;
    }
    
    public EventFogColor(final float llllllllllllIIIlIIlIIlIIIIlllllI, final float llllllllllllIIIlIIlIIlIIIIllllIl, final float llllllllllllIIIlIIlIIlIIIIllllII, final int llllllllllllIIIlIIlIIlIIIIlllIll) {
        this.red = llllllllllllIIIlIIlIIlIIIIlllllI;
        this.green = llllllllllllIIIlIIlIIlIIIIllllIl;
        this.blue = llllllllllllIIIlIIlIIlIIIIllllII;
        this.alpha = llllllllllllIIIlIIlIIlIIIIlllIll;
    }
    
    public float getGreen() {
        return this.green;
    }
    
    public float getBlue() {
        return this.blue;
    }
}
