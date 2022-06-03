// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.event.Event;

public class EventRender2D extends Event
{
    private /* synthetic */ float partialticks;
    private /* synthetic */ ScaledResolution resolution;
    
    public float getPartialTicks() {
        return this.partialticks;
    }
    
    public ScaledResolution getResolution() {
        return this.resolution;
    }
    
    public EventRender2D(final ScaledResolution llllllllllllIIIllIlIlIlIIIIlIllI, final float llllllllllllIIIllIlIlIlIIIIlIIlI) {
        this.resolution = llllllllllllIIIllIlIlIlIIIIlIllI;
        this.partialticks = llllllllllllIIIllIlIlIlIIIIlIIlI;
    }
}
