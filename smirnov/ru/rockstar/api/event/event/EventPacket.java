// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.network.Packet;
import ru.rockstar.api.event.Event;

public class EventPacket extends Event
{
    private /* synthetic */ boolean outgoing;
    private /* synthetic */ boolean pre;
    private /* synthetic */ Packet<?> packet;
    
    public EventPacket(final Packet<?> llllllllllllIlIIllIIIlIIIllIIIII, final boolean llllllllllllIlIIllIIIlIIIlIlllll) {
        this.packet = llllllllllllIlIIllIIIlIIIllIIIII;
        this.outgoing = llllllllllllIlIIllIIIlIIIlIlllll;
        this.pre = true;
    }
    
    public boolean isOutgoing() {
        return this.outgoing;
    }
    
    public void setPacket(final Packet llllllllllllIlIIllIIIlIIIlIIlIlI) {
        this.packet = (Packet<?>)llllllllllllIlIIllIIIlIIIlIIlIlI;
    }
    
    public boolean isPre() {
        return this.pre;
    }
    
    public EventPacket(final Packet<?> llllllllllllIlIIllIIIlIIIlIllIIl) {
        this.packet = llllllllllllIlIIllIIIlIIIlIllIIl;
        this.pre = false;
    }
    
    public boolean isPost() {
        return !this.pre;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public boolean isIncoming() {
        return !this.outgoing;
    }
}
