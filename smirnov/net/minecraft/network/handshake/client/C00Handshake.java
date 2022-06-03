// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.handshake.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;
import net.minecraft.network.Packet;

public class C00Handshake implements Packet<INetHandlerHandshakeServer>
{
    private /* synthetic */ String ip;
    private /* synthetic */ EnumConnectionState requestedState;
    private /* synthetic */ int protocolVersion;
    private /* synthetic */ int port;
    
    @Override
    public void processPacket(final INetHandlerHandshakeServer lllllllllllIllIlIIlIlIlIllIIIIII) {
        lllllllllllIllIlIIlIlIlIllIIIIII.processHandshake(this);
    }
    
    public EnumConnectionState getRequestedState() {
        return this.requestedState;
    }
    
    public int getProtocolVersion() {
        return this.protocolVersion;
    }
    
    public C00Handshake() {
    }
    
    public C00Handshake(final String lllllllllllIllIlIIlIlIlIllIlIlII, final int lllllllllllIllIlIIlIlIlIllIlIIll, final EnumConnectionState lllllllllllIllIlIIlIlIlIllIlIllI) {
        this.protocolVersion = 340;
        this.ip = lllllllllllIllIlIIlIlIlIllIlIlII;
        this.port = lllllllllllIllIlIIlIlIlIllIlIIll;
        this.requestedState = lllllllllllIllIlIIlIlIlIllIlIllI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIlIIlIlIlIllIIIllI) throws IOException {
        lllllllllllIllIlIIlIlIlIllIIIllI.writeVarIntToBuffer(this.protocolVersion);
        lllllllllllIllIlIIlIlIlIllIIIllI.writeString(this.ip);
        lllllllllllIllIlIIlIlIlIllIIIllI.writeShort(this.port);
        lllllllllllIllIlIIlIlIlIllIIIllI.writeVarIntToBuffer(this.requestedState.getId());
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIlIIlIlIlIllIIlllI) throws IOException {
        this.protocolVersion = lllllllllllIllIlIIlIlIlIllIIlllI.readVarIntFromBuffer();
        this.ip = lllllllllllIllIlIIlIlIlIllIIlllI.readStringFromBuffer(255);
        this.port = lllllllllllIllIlIIlIlIlIllIIlllI.readUnsignedShort();
        this.requestedState = EnumConnectionState.getById(lllllllllllIllIlIIlIlIlIllIIlllI.readVarIntFromBuffer());
    }
}
