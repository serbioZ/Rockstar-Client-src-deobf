// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketClientStatus implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ State status;
    
    public CPacketClientStatus() {
    }
    
    public State getStatus() {
        return this.status;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIlIllIlIlIlllIl) throws IOException {
        this.status = lllllllllllllIllIIlIllIlIlIlllIl.readEnumValue(State.class);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllIIlIllIlIlIlIIIl) {
        lllllllllllllIllIIlIllIlIlIlIIIl.processClientStatus(this);
    }
    
    public CPacketClientStatus(final State lllllllllllllIllIIlIllIlIllIIIll) {
        this.status = lllllllllllllIllIIlIllIlIllIIIll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIlIllIlIlIllIIl) throws IOException {
        lllllllllllllIllIIlIllIlIlIllIIl.writeEnumValue(this.status);
    }
    
    public enum State
    {
        PERFORM_RESPAWN("PERFORM_RESPAWN", 0), 
        REQUEST_STATS("REQUEST_STATS", 1);
        
        private State(final String lllllllllllIIIIIllIlIllIIlIlIIIl, final int lllllllllllIIIIIllIlIllIIlIlIIII) {
        }
    }
}
