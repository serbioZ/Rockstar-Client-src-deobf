// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketTabComplete implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String[] matches;
    
    public String[] getMatches() {
        return this.matches;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllIIlIIIlIlllIlIlIIl) {
        lllllllllllIllIIlIIIlIlllIlIlIIl.handleTabComplete(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIIlIIIlIlllIllllll) throws IOException {
        this.matches = new String[lllllllllllIllIIlIIIlIlllIllllll.readVarIntFromBuffer()];
        for (int lllllllllllIllIIlIIIlIllllIIIIIl = 0; lllllllllllIllIIlIIIlIllllIIIIIl < this.matches.length; ++lllllllllllIllIIlIIIlIllllIIIIIl) {
            this.matches[lllllllllllIllIIlIIIlIllllIIIIIl] = lllllllllllIllIIlIIIlIlllIllllll.readStringFromBuffer(32767);
        }
    }
    
    public SPacketTabComplete(final String[] lllllllllllIllIIlIIIlIllllIIIlll) {
        this.matches = lllllllllllIllIIlIIIlIllllIIIlll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIIlIIIlIlllIllIIll) throws IOException {
        lllllllllllIllIIlIIIlIlllIllIIll.writeVarIntToBuffer(this.matches.length);
        final short lllllllllllIllIIlIIIlIlllIlIllll;
        final short lllllllllllIllIIlIIIlIlllIllIIII = (short)((String[])(Object)(lllllllllllIllIIlIIIlIlllIlIllll = (short)(Object)this.matches)).length;
        for (float lllllllllllIllIIlIIIlIlllIllIIIl = 0; lllllllllllIllIIlIIIlIlllIllIIIl < lllllllllllIllIIlIIIlIlllIllIIII; ++lllllllllllIllIIlIIIlIlllIllIIIl) {
            final String lllllllllllIllIIlIIIlIlllIllIlIl = lllllllllllIllIIlIIIlIlllIlIllll[lllllllllllIllIIlIIIlIlllIllIIIl];
            lllllllllllIllIIlIIIlIlllIllIIll.writeString(lllllllllllIllIIlIIIlIlllIllIlIl);
        }
    }
    
    public SPacketTabComplete() {
    }
}
