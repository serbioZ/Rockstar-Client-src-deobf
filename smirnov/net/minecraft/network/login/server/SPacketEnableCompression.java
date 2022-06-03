// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.Packet;

public class SPacketEnableCompression implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ int compressionThreshold;
    
    public SPacketEnableCompression() {
    }
    
    public SPacketEnableCompression(final int lllllllllllllIIlIllIIIlIIllIlIII) {
        this.compressionThreshold = lllllllllllllIIlIllIIIlIIllIlIII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIlIllIIIlIIllIIlII) throws IOException {
        this.compressionThreshold = lllllllllllllIIlIllIIIlIIllIIlII.readVarIntFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIlIllIIIlIIlIlllII) throws IOException {
        lllllllllllllIIlIllIIIlIIlIlllII.writeVarIntToBuffer(this.compressionThreshold);
    }
    
    public int getCompressionThreshold() {
        return this.compressionThreshold;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient lllllllllllllIIlIllIIIlIIlIllIII) {
        lllllllllllllIIlIllIIIlIIlIllIII.handleEnableCompression(this);
    }
}
