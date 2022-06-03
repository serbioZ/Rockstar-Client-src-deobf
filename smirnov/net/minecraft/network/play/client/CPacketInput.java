// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketInput implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float field_192621_b;
    private /* synthetic */ boolean jumping;
    private /* synthetic */ float strafeSpeed;
    private /* synthetic */ boolean sneaking;
    
    public boolean isJumping() {
        return this.jumping;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIIIllIllIllIIIIlIlIIl) {
        lllllllllllIIIllIllIllIIIIlIlIIl.processInput(this);
    }
    
    public CPacketInput(final float lllllllllllIIIllIllIllIIIlIIlIIl, final float lllllllllllIIIllIllIllIIIlIIIIll, final boolean lllllllllllIIIllIllIllIIIlIIIIlI, final boolean lllllllllllIIIllIllIllIIIlIIIllI) {
        this.strafeSpeed = lllllllllllIIIllIllIllIIIlIIlIIl;
        this.field_192621_b = lllllllllllIIIllIllIllIIIlIIIIll;
        this.jumping = lllllllllllIIIllIllIllIIIlIIIIlI;
        this.sneaking = lllllllllllIIIllIllIllIIIlIIIllI;
    }
    
    public float func_192620_b() {
        return this.field_192621_b;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIllIllIllIIIIllIIII) throws IOException {
        lllllllllllIIIllIllIllIIIIllIIII.writeFloat(this.strafeSpeed);
        lllllllllllIIIllIllIllIIIIllIIII.writeFloat(this.field_192621_b);
        byte lllllllllllIIIllIllIllIIIIllIIlI = 0;
        if (this.jumping) {
            lllllllllllIIIllIllIllIIIIllIIlI |= 0x1;
        }
        if (this.sneaking) {
            lllllllllllIIIllIllIllIIIIllIIlI |= 0x2;
        }
        lllllllllllIIIllIllIllIIIIllIIII.writeByte(lllllllllllIIIllIllIllIIIIllIIlI);
    }
    
    public CPacketInput() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIllIllIllIIIIllllII) throws IOException {
        this.strafeSpeed = lllllllllllIIIllIllIllIIIIllllII.readFloat();
        this.field_192621_b = lllllllllllIIIllIllIllIIIIllllII.readFloat();
        final byte lllllllllllIIIllIllIllIIIIlllIll = lllllllllllIIIllIllIllIIIIllllII.readByte();
        this.jumping = ((lllllllllllIIIllIllIllIIIIlllIll & 0x1) > 0);
        this.sneaking = ((lllllllllllIIIllIllIllIIIIlllIll & 0x2) > 0);
    }
    
    public float getStrafeSpeed() {
        return this.strafeSpeed;
    }
    
    public boolean isSneaking() {
        return this.sneaking;
    }
}
