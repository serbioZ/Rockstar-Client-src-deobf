// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.network.Packet;
import ru.rockstar.api.event.Event;

public class EventSendPacket extends Event
{
    private /* synthetic */ Packet packet;
    private /* synthetic */ boolean sending;
    
    public EventSendPacket(final Packet lllllllllllllIIlllllIllllIIIIlII, final boolean lllllllllllllIIlllllIllllIIIIIll) {
        this.packet = lllllllllllllIIlllllIllllIIIIlII;
        this.sending = lllllllllllllIIlllllIllllIIIIIll;
    }
    
    public boolean isRecieving() {
        return !this.sending;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public boolean isSending() {
        return this.sending;
    }
}
