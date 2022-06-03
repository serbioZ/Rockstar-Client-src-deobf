// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUnloadChunk implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int x;
    private /* synthetic */ int z;
    
    public SPacketUnloadChunk() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllIIIlIlIlIllIllIIII) {
        lllllllllllIllIIIlIlIlIllIllIIII.processChunkUnload(this);
    }
    
    public SPacketUnloadChunk(final int lllllllllllIllIIIlIlIlIlllIIIllI, final int lllllllllllIllIIIlIlIlIlllIIIlIl) {
        this.x = lllllllllllIllIIIlIlIlIlllIIIllI;
        this.z = lllllllllllIllIIIlIlIlIlllIIIlIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIIIlIlIlIllIllllII) throws IOException {
        this.x = lllllllllllIllIIIlIlIlIllIllllII.readInt();
        this.z = lllllllllllIllIIIlIlIlIllIllllII.readInt();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIIIlIlIlIllIlllIII) throws IOException {
        lllllllllllIllIIIlIlIlIllIlllIII.writeInt(this.x);
        lllllllllllIllIIIlIlIlIllIlllIII.writeInt(this.z);
    }
    
    public int getZ() {
        return this.z;
    }
    
    public int getX() {
        return this.x;
    }
}
