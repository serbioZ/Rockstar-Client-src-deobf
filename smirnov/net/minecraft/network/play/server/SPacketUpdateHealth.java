// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUpdateHealth implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float saturationLevel;
    private /* synthetic */ float health;
    private /* synthetic */ int foodLevel;
    
    public SPacketUpdateHealth(final float lllllllllllIIIlIIlllIIIlllIlIllI, final int lllllllllllIIIlIIlllIIIlllIlIIIl, final float lllllllllllIIIlIIlllIIIlllIlIIII) {
        this.health = lllllllllllIIIlIIlllIIIlllIlIllI;
        this.foodLevel = lllllllllllIIIlIIlllIIIlllIlIIIl;
        this.saturationLevel = lllllllllllIIIlIIlllIIIlllIlIIII;
    }
    
    public float getHealth() {
        return this.health;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIlIIlllIIIlllIIIlII) throws IOException {
        lllllllllllIIIlIIlllIIIlllIIIlII.writeFloat(this.health);
        lllllllllllIIIlIIlllIIIlllIIIlII.writeVarIntToBuffer(this.foodLevel);
        lllllllllllIIIlIIlllIIIlllIIIlII.writeFloat(this.saturationLevel);
    }
    
    public SPacketUpdateHealth() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIlIIlllIIIlllIIlIlI) throws IOException {
        this.health = lllllllllllIIIlIIlllIIIlllIIlIlI.readFloat();
        this.foodLevel = lllllllllllIIIlIIlllIIIlllIIlIlI.readVarIntFromBuffer();
        this.saturationLevel = lllllllllllIIIlIIlllIIIlllIIlIlI.readFloat();
    }
    
    public float getSaturationLevel() {
        return this.saturationLevel;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIlIIlllIIIllIlllllI) {
        lllllllllllIIIlIIlllIIIllIlllllI.handleUpdateHealth(this);
    }
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
}
