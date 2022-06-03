// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketTimeUpdate implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ long totalWorldTime;
    private /* synthetic */ long worldTime;
    
    public long getWorldTime() {
        return this.worldTime;
    }
    
    public SPacketTimeUpdate() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllllIIlIIIlllIIllI) {
        lllllllllllllIllllIIlIIIlllIIllI.handleTimeUpdate(this);
    }
    
    public long getTotalWorldTime() {
        return this.totalWorldTime;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllllIIlIIIlllIllII) throws IOException {
        lllllllllllllIllllIIlIIIlllIllII.writeLong(this.totalWorldTime);
        lllllllllllllIllllIIlIIIlllIllII.writeLong(this.worldTime);
    }
    
    public SPacketTimeUpdate(final long lllllllllllllIllllIIlIIIllllllII, final long lllllllllllllIllllIIlIIIllllIlll, final boolean lllllllllllllIllllIIlIIIllllIllI) {
        this.totalWorldTime = lllllllllllllIllllIIlIIIllllllII;
        this.worldTime = lllllllllllllIllllIIlIIIllllIlll;
        if (!lllllllllllllIllllIIlIIIllllIllI) {
            this.worldTime = -this.worldTime;
            if (this.worldTime == 0L) {
                this.worldTime = -1L;
            }
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllllIIlIIIllllIIlI) throws IOException {
        this.totalWorldTime = lllllllllllllIllllIIlIIIllllIIlI.readLong();
        this.worldTime = lllllllllllllIllllIIlIIIllllIIlI.readLong();
    }
}
