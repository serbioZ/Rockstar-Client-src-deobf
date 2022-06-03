// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ byte effectId;
    private /* synthetic */ byte amplifier;
    private /* synthetic */ byte flags;
    private /* synthetic */ int duration;
    
    public int getDuration() {
        return this.duration;
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public SPacketEntityEffect() {
    }
    
    public boolean doesShowParticles() {
        return (this.flags & 0x2) == 0x2;
    }
    
    public byte getAmplifier() {
        return this.amplifier;
    }
    
    public SPacketEntityEffect(final int llllllllllIllllIlIlIllIIlIlIlIlI, final PotionEffect llllllllllIllllIlIlIllIIlIlIllII) {
        this.entityId = llllllllllIllllIlIlIllIIlIlIlIlI;
        this.effectId = (byte)(Potion.getIdFromPotion(llllllllllIllllIlIlIllIIlIlIllII.getPotion()) & 0xFF);
        this.amplifier = (byte)(llllllllllIllllIlIlIllIIlIlIllII.getAmplifier() & 0xFF);
        if (llllllllllIllllIlIlIllIIlIlIllII.getDuration() > 32767) {
            this.duration = 32767;
        }
        else {
            this.duration = llllllllllIllllIlIlIllIIlIlIllII.getDuration();
        }
        this.flags = 0;
        if (llllllllllIllllIlIlIllIIlIlIllII.getIsAmbient()) {
            this.flags |= 0x1;
        }
        if (llllllllllIllllIlIlIllIIlIlIllII.doesShowParticles()) {
            this.flags |= 0x2;
        }
    }
    
    public byte getEffectId() {
        return this.effectId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIlIlIllIIlIlIIlIl) throws IOException {
        this.entityId = llllllllllIllllIlIlIllIIlIlIIlIl.readVarIntFromBuffer();
        this.effectId = llllllllllIllllIlIlIllIIlIlIIlIl.readByte();
        this.amplifier = llllllllllIllllIlIlIllIIlIlIIlIl.readByte();
        this.duration = llllllllllIllllIlIlIllIIlIlIIlIl.readVarIntFromBuffer();
        this.flags = llllllllllIllllIlIlIllIIlIlIIlIl.readByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIlIlIllIIlIIlllll) throws IOException {
        llllllllllIllllIlIlIllIIlIIlllll.writeVarIntToBuffer(this.entityId);
        llllllllllIllllIlIlIllIIlIIlllll.writeByte(this.effectId);
        llllllllllIllllIlIlIllIIlIIlllll.writeByte(this.amplifier);
        llllllllllIllllIlIlIllIIlIIlllll.writeVarIntToBuffer(this.duration);
        llllllllllIllllIlIlIllIIlIIlllll.writeByte(this.flags);
    }
    
    public boolean getIsAmbient() {
        return (this.flags & 0x1) == 0x1;
    }
    
    public boolean isMaxDuration() {
        return this.duration == 32767;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllIlIlIllIIlIIlIllI) {
        llllllllllIllllIlIlIllIIlIIlIllI.handleEntityEffect(this);
    }
}
