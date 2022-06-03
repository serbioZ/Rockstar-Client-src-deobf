// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.status.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.status.INetHandlerStatusServer;
import net.minecraft.network.Packet;

public class CPacketServerQuery implements Packet<INetHandlerStatusServer>
{
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIIlIllIlllllllIll) throws IOException {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIIlIllIllllllllIl) throws IOException {
    }
    
    @Override
    public void processPacket(final INetHandlerStatusServer llllllllllIllllIIlIllIllllllIlIl) {
        llllllllllIllllIIlIllIllllllIlIl.processServerQuery(this);
    }
}
