// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.Packet;

public class SPacketDisconnect implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ ITextComponent reason;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIlllIIlllIIIII) throws IOException {
        this.reason = ITextComponent.Serializer.fromJsonLenient(llllllllllllllIlIlIlllIIlllIIIII.readStringFromBuffer(32767));
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIlllIIllIlllII) throws IOException {
        llllllllllllllIlIlIlllIIllIlllII.writeTextComponent(this.reason);
    }
    
    public SPacketDisconnect() {
    }
    
    public SPacketDisconnect(final ITextComponent llllllllllllllIlIlIlllIIlllIIllI) {
        this.reason = llllllllllllllIlIlIlllIIlllIIllI;
    }
    
    public ITextComponent getReason() {
        return this.reason;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient llllllllllllllIlIlIlllIIllIlIllI) {
        llllllllllllllIlIlIlllIIllIlIllI.handleDisconnect(this);
    }
}
