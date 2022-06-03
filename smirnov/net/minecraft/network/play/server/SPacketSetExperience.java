// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSetExperience implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int level;
    private /* synthetic */ float experienceBar;
    private /* synthetic */ int totalExperience;
    
    public SPacketSetExperience() {
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public SPacketSetExperience(final float llllllllllllIlllIlIlIlIlIlIIIIll, final int llllllllllllIlllIlIlIlIlIIlllllI, final int llllllllllllIlllIlIlIlIlIIllllIl) {
        this.experienceBar = llllllllllllIlllIlIlIlIlIlIIIIll;
        this.totalExperience = llllllllllllIlllIlIlIlIlIIlllllI;
        this.level = llllllllllllIlllIlIlIlIlIIllllIl;
    }
    
    public float getExperienceBar() {
        return this.experienceBar;
    }
    
    public int getTotalExperience() {
        return this.totalExperience;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlllIlIlIlIlIIlIlIll) {
        llllllllllllIlllIlIlIlIlIIlIlIll.handleSetExperience(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIlIlIlIlIIlllIIl) throws IOException {
        this.experienceBar = llllllllllllIlllIlIlIlIlIIlllIIl.readFloat();
        this.level = llllllllllllIlllIlIlIlIlIIlllIIl.readVarIntFromBuffer();
        this.totalExperience = llllllllllllIlllIlIlIlIlIIlllIIl.readVarIntFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIlIlIlIlIIllIIll) throws IOException {
        llllllllllllIlllIlIlIlIlIIllIIll.writeFloat(this.experienceBar);
        llllllllllllIlllIlIlIlIlIIllIIll.writeVarIntToBuffer(this.level);
        llllllllllllIlllIlIlIlIlIIllIIll.writeVarIntToBuffer(this.totalExperience);
    }
}
