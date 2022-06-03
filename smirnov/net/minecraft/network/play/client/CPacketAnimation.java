// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketAnimation implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumHand hand;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIIIIIIllIIlIIlIIII) throws IOException {
        lllllllllllIllIIIIIIllIIlIIlIIII.writeEnumValue(this.hand);
    }
    
    public CPacketAnimation(final EnumHand lllllllllllIllIIIIIIllIIlIIlllII) {
        this.hand = lllllllllllIllIIIIIIllIIlIIlllII;
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIIIIIIllIIlIIlIllI) throws IOException {
        this.hand = lllllllllllIllIIIIIIllIIlIIlIllI.readEnumValue(EnumHand.class);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIllIIIIIIllIIlIIIlIlI) {
        lllllllllllIllIIIIIIllIIlIIIlIlI.handleAnimation(this);
    }
    
    public CPacketAnimation() {
    }
}
