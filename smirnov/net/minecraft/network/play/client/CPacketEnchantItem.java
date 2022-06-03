// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketEnchantItem implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ int windowId;
    private /* synthetic */ int button;
    
    public CPacketEnchantItem(final int llllllllllllIIlllIlIlIlllIlllIII, final int llllllllllllIIlllIlIlIlllIllIlII) {
        this.windowId = llllllllllllIIlllIlIlIlllIlllIII;
        this.button = llllllllllllIIlllIlIlIlllIllIlII;
    }
    
    public CPacketEnchantItem() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlllIlIlIlllIlIlIII) throws IOException {
        this.windowId = llllllllllllIIlllIlIlIlllIlIlIII.readByte();
        this.button = llllllllllllIIlllIlIlIlllIlIlIII.readByte();
    }
    
    public int getButton() {
        return this.button;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIlllIlIlIlllIllIIII) {
        llllllllllllIIlllIlIlIlllIllIIII.processEnchantItem(this);
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlllIlIlIlllIlIIlII) throws IOException {
        llllllllllllIIlllIlIlIlllIlIIlII.writeByte(this.windowId);
        llllllllllllIIlllIlIlIlllIlIIlII.writeByte(this.button);
    }
}
