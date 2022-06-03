// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.event.Event;

public class Event2D extends Event
{
    private /* synthetic */ ScaledResolution resolution;
    private /* synthetic */ float height;
    private /* synthetic */ float width;
    
    public float getWidth() {
        return this.width;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public ScaledResolution getResolution() {
        return this.resolution;
    }
    
    public Event2D(final float lllllllllllllIIIllIlIllIllIlIIII, final float lllllllllllllIIIllIlIllIllIlIIlI) {
        this.width = lllllllllllllIIIllIlIllIllIlIIII;
        this.height = lllllllllllllIIIllIlIllIllIlIIlI;
    }
}
