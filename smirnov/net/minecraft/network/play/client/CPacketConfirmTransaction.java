// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketConfirmTransaction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ short uid;
    private /* synthetic */ boolean accepted;
    private /* synthetic */ int windowId;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIllIIlIllIlIllllIlI) throws IOException {
        this.windowId = lllllllllllIlIllIIlIllIlIllllIlI.readByte();
        this.uid = lllllllllllIlIllIIlIllIlIllllIlI.readShort();
        this.accepted = (lllllllllllIlIllIIlIllIlIllllIlI.readByte() != 0);
    }
    
    public short getUid() {
        return this.uid;
    }
    
    public CPacketConfirmTransaction(final int lllllllllllIlIllIIlIllIllIIIllII, final short lllllllllllIlIllIIlIllIllIIIlIll, final boolean lllllllllllIlIllIIlIllIllIIIlIlI) {
        this.windowId = lllllllllllIlIllIIlIllIllIIIllII;
        this.uid = lllllllllllIlIllIIlIllIllIIIlIll;
        this.accepted = lllllllllllIlIllIIlIllIllIIIlIlI;
    }
    
    public boolean isAccepted() {
        return this.accepted;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIllIIlIllIlIlllIllI) throws IOException {
        lllllllllllIlIllIIlIllIlIlllIllI.writeByte(this.windowId);
        lllllllllllIlIllIIlIllIlIlllIllI.writeShort(this.uid);
        lllllllllllIlIllIIlIllIlIlllIllI.writeByte(this.accepted ? 1 : 0);
    }
    
    public CPacketConfirmTransaction() {
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIlIllIIlIllIllIIIIIlI) {
        lllllllllllIlIllIIlIllIllIIIIIlI.processConfirmTransaction(this);
    }
}
