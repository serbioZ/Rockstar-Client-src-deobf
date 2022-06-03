// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketSteerBoat implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ boolean right;
    private /* synthetic */ boolean left;
    
    public CPacketSteerBoat() {
    }
    
    public boolean getRight() {
        return this.right;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlIlIllIIIllIIlllIl) throws IOException {
        llllllllllllIIlIlIllIIIllIIlllIl.writeBoolean(this.left);
        llllllllllllIIlIlIllIIIllIIlllIl.writeBoolean(this.right);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlIlIllIIIllIlIIIll) throws IOException {
        this.left = llllllllllllIIlIlIllIIIllIlIIIll.readBoolean();
        this.right = llllllllllllIIlIlIllIIIllIlIIIll.readBoolean();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIlIlIllIIIllIIlIlll) {
        llllllllllllIIlIlIllIIIllIIlIlll.processSteerBoat(this);
    }
    
    public boolean getLeft() {
        return this.left;
    }
    
    public CPacketSteerBoat(final boolean llllllllllllIIlIlIllIIIllIlIlIlI, final boolean llllllllllllIIlIlIllIIIllIlIlIIl) {
        this.left = llllllllllllIIlIlIllIIIllIlIlIlI;
        this.right = llllllllllllIIlIlIllIIIllIlIlIIl;
    }
}
