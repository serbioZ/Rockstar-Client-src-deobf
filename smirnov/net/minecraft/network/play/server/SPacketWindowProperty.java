// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketWindowProperty implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ int property;
    private /* synthetic */ int value;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIIlllIIIllIIIlll) {
        lllllllllllllllIIIlllIIIllIIIlll.handleWindowProperty(this);
    }
    
    public SPacketWindowProperty(final int lllllllllllllllIIIlllIIIllIIllll, final int lllllllllllllllIIIlllIIIllIIlllI, final int lllllllllllllllIIIlllIIIllIlIIIl) {
        this.windowId = lllllllllllllllIIIlllIIIllIIllll;
        this.property = lllllllllllllllIIIlllIIIllIIlllI;
        this.value = lllllllllllllllIIIlllIIIllIlIIIl;
    }
    
    public SPacketWindowProperty() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIlllIIIlIlllIll) throws IOException {
        lllllllllllllllIIIlllIIIlIlllIll.writeByte(this.windowId);
        lllllllllllllllIIIlllIIIlIlllIll.writeShort(this.property);
        lllllllllllllllIIIlllIIIlIlllIll.writeShort(this.value);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIlllIIIllIIIIIl) throws IOException {
        this.windowId = lllllllllllllllIIIlllIIIllIIIIIl.readUnsignedByte();
        this.property = lllllllllllllllIIIlllIIIllIIIIIl.readShort();
        this.value = lllllllllllllllIIIlllIIIllIIIIIl.readShort();
    }
    
    public int getValue() {
        return this.value;
    }
    
    public int getProperty() {
        return this.property;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
}
