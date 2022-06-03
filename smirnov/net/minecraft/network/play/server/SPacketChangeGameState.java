// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketChangeGameState implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int state;
    private /* synthetic */ float value;
    
    public SPacketChangeGameState(final int lllllllllllIlIllIlIIIIlllllllllI, final float lllllllllllIlIllIlIIIlIIIIIIIIII) {
        this.state = lllllllllllIlIllIlIIIIlllllllllI;
        this.value = lllllllllllIlIllIlIIIlIIIIIIIIII;
    }
    
    public SPacketChangeGameState() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIllIlIIIIlllllIlIll) {
        lllllllllllIlIllIlIIIIlllllIlIll.handleChangeGameState(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIllIlIIIIllllllIlll) throws IOException {
        this.state = lllllllllllIlIllIlIIIIllllllIlll.readUnsignedByte();
        this.value = lllllllllllIlIllIlIIIIllllllIlll.readFloat();
    }
    
    public float getValue() {
        return this.value;
    }
    
    public int getGameState() {
        return this.state;
    }
    
    static {
        MESSAGE_NAMES = new String[] { "tile.bed.notValid" };
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIllIlIIIIllllllIIll) throws IOException {
        lllllllllllIlIllIlIIIIllllllIIll.writeByte(this.state);
        lllllllllllIlIllIlIIIIllllllIIll.writeFloat(this.value);
    }
}
