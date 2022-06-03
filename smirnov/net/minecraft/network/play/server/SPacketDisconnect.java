// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketDisconnect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ITextComponent reason;
    
    public SPacketDisconnect(final ITextComponent llllllllllllIlIlIlIIlIlllllIIlll) {
        this.reason = llllllllllllIlIlIlIIlIlllllIIlll;
    }
    
    public ITextComponent getReason() {
        return this.reason;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlIlIlIIlIllllIlIIll) {
        llllllllllllIlIlIlIIlIllllIlIIll.handleDisconnect(this);
    }
    
    public SPacketDisconnect() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIlIlIIlIllllIlllll) throws IOException {
        this.reason = llllllllllllIlIlIlIIlIllllIlllll.readTextComponent();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIlIlIIlIllllIllIll) throws IOException {
        llllllllllllIlIlIlIIlIllllIllIll.writeTextComponent(this.reason);
    }
}
