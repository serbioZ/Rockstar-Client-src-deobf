// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCloseWindow implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int windowId;
    
    public SPacketCloseWindow() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIIlIllllllIlIIIllII) {
        lllllllllllIlIIlIllllllIlIIIllII.handleCloseWindow(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIIlIllllllIlIIIlIII) throws IOException {
        this.windowId = lllllllllllIlIIlIllllllIlIIIlIII.readUnsignedByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIIlIllllllIlIIIIIlI) throws IOException {
        lllllllllllIlIIlIllllllIlIIIIIlI.writeByte(this.windowId);
    }
    
    public SPacketCloseWindow(final int lllllllllllIlIIlIllllllIlIIlIIlI) {
        this.windowId = lllllllllllIlIIlIllllllIlIIlIIlI;
    }
}
