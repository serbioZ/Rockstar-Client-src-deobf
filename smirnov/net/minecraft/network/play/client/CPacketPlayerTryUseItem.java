// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.util.EnumHand;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlayerTryUseItem implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumHand hand;
    
    public CPacketPlayerTryUseItem() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlIIIIIllIIIIIllIIlI) {
        llllllllllllIlIIIIIllIIIIIllIIlI.processPlayerBlockPlacement(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIIIIIllIIIIIlllllI) throws IOException {
        this.hand = llllllllllllIlIIIIIllIIIIIlllllI.readEnumValue(EnumHand.class);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIIIIIllIIIIIlllIII) throws IOException {
        llllllllllllIlIIIIIllIIIIIlllIII.writeEnumValue(this.hand);
    }
    
    public CPacketPlayerTryUseItem(final EnumHand llllllllllllIlIIIIIllIIIIlIIIIlI) {
        this.hand = llllllllllllIlIIIIIllIIIIlIIIIlI;
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
}
