// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.network.Packet;
import ru.rockstar.api.event.Event;

public class EventReceivePacket extends Event
{
    private /* synthetic */ Packet<?> packet;
    private /* synthetic */ boolean pre;
    private /* synthetic */ boolean outgoing;
    
    public boolean isOutgoing() {
        return this.outgoing;
    }
    
    public boolean isPost() {
        return !this.pre;
    }
    
    public void setPacket(final Packet lllllllllllIIIlllllIIIllIIllllll) {
        this.packet = (Packet<?>)lllllllllllIIIlllllIIIllIIllllll;
    }
    
    public boolean isPre() {
        return this.pre;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public EventReceivePacket(final Packet<?> lllllllllllIIIlllllIIIllIlIIllII) {
        this.packet = lllllllllllIIIlllllIIIllIlIIllII;
        this.pre = false;
    }
    
    public boolean isIncoming() {
        return !this.outgoing;
    }
    
    public EventReceivePacket(final Packet<?> lllllllllllIIIlllllIIIllIlIlIllI, final boolean lllllllllllIIIlllllIIIllIlIlIIlI) {
        this.packet = lllllllllllIIIlllllIIIllIlIlIllI;
        this.outgoing = lllllllllllIIIlllllIIIllIlIlIIlI;
        this.pre = true;
    }
}
