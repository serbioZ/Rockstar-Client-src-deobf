// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketResourcePackSend implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String url;
    private /* synthetic */ String hash;
    
    public SPacketResourcePackSend(final String lllllllllllIIIIIllIlIIlllIIIllIl, final String lllllllllllIIIIIllIlIIlllIIIllII) {
        this.url = lllllllllllIIIIIllIlIIlllIIIllIl;
        this.hash = lllllllllllIIIIIllIlIIlllIIIllII;
        if (lllllllllllIIIIIllIlIIlllIIIllII.length() > 40) {
            throw new IllegalArgumentException("Hash is too long (max 40, was " + lllllllllllIIIIIllIlIIlllIIIllII.length() + ")");
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIIIllIlIIllIlllIlll) {
        lllllllllllIIIIIllIlIIllIlllIlll.handleResourcePack(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIIIllIlIIllIlllllIl) throws IOException {
        lllllllllllIIIIIllIlIIllIlllllIl.writeString(this.url);
        lllllllllllIIIIIllIlIIllIlllllIl.writeString(this.hash);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIIIllIlIIlllIIIIlIl) throws IOException {
        this.url = lllllllllllIIIIIllIlIIlllIIIIlIl.readStringFromBuffer(32767);
        this.hash = lllllllllllIIIIIllIlIIlllIIIIlIl.readStringFromBuffer(40);
    }
    
    public String getHash() {
        return this.hash;
    }
    
    public String getURL() {
        return this.url;
    }
    
    public SPacketResourcePackSend() {
    }
}
