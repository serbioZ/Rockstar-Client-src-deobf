// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketDestroyEntities implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int[] entityIDs;
    
    public int[] getEntityIDs() {
        return this.entityIDs;
    }
    
    public SPacketDestroyEntities(final int... lllllllllllllIIllIllIlIIlIIlllll) {
        this.entityIDs = lllllllllllllIIllIllIlIIlIIlllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIllIlIIlIIllIlI) throws IOException {
        this.entityIDs = new int[lllllllllllllIIllIllIlIIlIIllIlI.readVarIntFromBuffer()];
        for (int lllllllllllllIIllIllIlIIlIIllIIl = 0; lllllllllllllIIllIllIlIIlIIllIIl < this.entityIDs.length; ++lllllllllllllIIllIllIlIIlIIllIIl) {
            this.entityIDs[lllllllllllllIIllIllIlIIlIIllIIl] = lllllllllllllIIllIllIlIIlIIllIlI.readVarIntFromBuffer();
        }
    }
    
    public SPacketDestroyEntities() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIllIlIIlIIIlllI) throws IOException {
        lllllllllllllIIllIllIlIIlIIIlllI.writeVarIntToBuffer(this.entityIDs.length);
        final short lllllllllllllIIllIllIlIIlIIIIlll;
        final long lllllllllllllIIllIllIlIIlIIIlIII = ((int[])(Object)(lllllllllllllIIllIllIlIIlIIIIlll = (short)(Object)this.entityIDs)).length;
        for (byte lllllllllllllIIllIllIlIIlIIIlIIl = 0; lllllllllllllIIllIllIlIIlIIIlIIl < lllllllllllllIIllIllIlIIlIIIlIII; ++lllllllllllllIIllIllIlIIlIIIlIIl) {
            final int lllllllllllllIIllIllIlIIlIIIllIl = lllllllllllllIIllIllIlIIlIIIIlll[lllllllllllllIIllIllIlIIlIIIlIIl];
            lllllllllllllIIllIllIlIIlIIIlllI.writeVarIntToBuffer(lllllllllllllIIllIllIlIIlIIIllIl);
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllIllIlIIlIIIIIll) {
        lllllllllllllIIllIllIlIIlIIIIIll.handleDestroyEntities(this);
    }
}
