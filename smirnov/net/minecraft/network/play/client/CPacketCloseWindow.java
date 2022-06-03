// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketCloseWindow implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int windowId;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIlIlIIlllIIIIIIl) throws IOException {
        this.windowId = lllllllllllllllIIlIlIIlllIIIIIIl.readByte();
    }
    
    public CPacketCloseWindow(final int lllllllllllllllIIlIlIIlllIIIlIll) {
        this.windowId = lllllllllllllllIIlIlIIlllIIIlIll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllIIlIlIIlllIIIIlIl) {
        lllllllllllllllIIlIlIIlllIIIIlIl.processCloseWindow(this);
    }
    
    public CPacketCloseWindow() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIlIlIIllIllllIIl) throws IOException {
        lllllllllllllllIIlIlIIllIllllIIl.writeByte(this.windowId);
    }
}
