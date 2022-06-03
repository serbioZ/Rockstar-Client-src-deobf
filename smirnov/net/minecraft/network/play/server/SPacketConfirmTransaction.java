// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketConfirmTransaction implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ boolean accepted;
    private /* synthetic */ short actionNumber;
    private /* synthetic */ int windowId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlIIllIlIIlllIIllIIl) {
        llllllllllllIlIIllIlIIlllIIllIIl.handleConfirmTransaction(this);
    }
    
    public boolean wasAccepted() {
        return this.accepted;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIIllIlIIlllIIlIIIl) throws IOException {
        this.windowId = llllllllllllIlIIllIlIIlllIIlIIIl.readUnsignedByte();
        this.actionNumber = llllllllllllIlIIllIlIIlllIIlIIIl.readShort();
        this.accepted = llllllllllllIlIIllIlIIlllIIlIIIl.readBoolean();
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public SPacketConfirmTransaction() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIIllIlIIlllIIIlIll) throws IOException {
        llllllllllllIlIIllIlIIlllIIIlIll.writeByte(this.windowId);
        llllllllllllIlIIllIlIIlllIIIlIll.writeShort(this.actionNumber);
        llllllllllllIlIIllIlIIlllIIIlIll.writeBoolean(this.accepted);
    }
    
    public short getActionNumber() {
        return this.actionNumber;
    }
    
    public SPacketConfirmTransaction(final int llllllllllllIlIIllIlIIlllIIlllll, final short llllllllllllIlIIllIlIIlllIIllllI, final boolean llllllllllllIlIIllIlIIlllIIlllIl) {
        this.windowId = llllllllllllIlIIllIlIIlllIIlllll;
        this.actionNumber = llllllllllllIlIIllIlIIlllIIllllI;
        this.accepted = llllllllllllIlIIllIlIIlllIIlllIl;
    }
}
