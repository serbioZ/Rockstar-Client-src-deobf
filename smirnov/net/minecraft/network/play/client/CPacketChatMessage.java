// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketChatMessage implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String message;
    
    public CPacketChatMessage(String llllllllllllllIlIllIIlIIllIIIIll) {
        if (((String)llllllllllllllIlIllIIlIIllIIIIll).length() > 256) {
            llllllllllllllIlIllIIlIIllIIIIll = ((String)llllllllllllllIlIllIIlIIllIIIIll).substring(0, 256);
        }
        this.message = (String)llllllllllllllIlIllIIlIIllIIIIll;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIllIIlIIlIllIlll) throws IOException {
        llllllllllllllIlIllIIlIIlIllIlll.writeString(this.message);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIlIllIIlIIlIllIIll) {
        llllllllllllllIlIllIIlIIlIllIIll.processChatMessage(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIllIIlIIlIllllll) throws IOException {
        this.message = llllllllllllllIlIllIIlIIlIllllll.readStringFromBuffer(256);
    }
    
    public CPacketChatMessage() {
    }
}
