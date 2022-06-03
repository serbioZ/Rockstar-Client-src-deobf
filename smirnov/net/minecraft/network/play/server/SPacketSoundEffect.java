// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import org.apache.commons.lang3.Validate;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundCategory;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSoundEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float soundVolume;
    private /* synthetic */ int posZ;
    private /* synthetic */ SoundCategory category;
    private /* synthetic */ float soundPitch;
    private /* synthetic */ int posX;
    private /* synthetic */ SoundEvent sound;
    private /* synthetic */ int posY;
    
    public float getPitch() {
        return this.soundPitch;
    }
    
    public double getY() {
        return this.posY / 8.0f;
    }
    
    public SoundEvent getSound() {
        return this.sound;
    }
    
    public float getVolume() {
        return this.soundVolume;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIIIlllIlIlIlIllllIl) throws IOException {
        this.sound = SoundEvent.REGISTRY.getObjectById(lllllllllllIlIIIlllIlIlIlIllllIl.readVarIntFromBuffer());
        this.category = lllllllllllIlIIIlllIlIlIlIllllIl.readEnumValue(SoundCategory.class);
        this.posX = lllllllllllIlIIIlllIlIlIlIllllIl.readInt();
        this.posY = lllllllllllIlIIIlllIlIlIlIllllIl.readInt();
        this.posZ = lllllllllllIlIIIlllIlIlIlIllllIl.readInt();
        this.soundVolume = lllllllllllIlIIIlllIlIlIlIllllIl.readFloat();
        this.soundPitch = lllllllllllIlIIIlllIlIlIlIllllIl.readFloat();
    }
    
    public double getX() {
        return this.posX / 8.0f;
    }
    
    public SPacketSoundEffect(final SoundEvent lllllllllllIlIIIlllIlIlIllIIllll, final SoundCategory lllllllllllIlIIIlllIlIlIllIIIllI, final double lllllllllllIlIIIlllIlIlIllIIllIl, final double lllllllllllIlIIIlllIlIlIllIIIlII, final double lllllllllllIlIIIlllIlIlIllIIIIll, final float lllllllllllIlIIIlllIlIlIllIIIIlI, final float lllllllllllIlIIIlllIlIlIllIIIIIl) {
        Validate.notNull((Object)lllllllllllIlIIIlllIlIlIllIIllll, "sound", new Object[0]);
        this.sound = lllllllllllIlIIIlllIlIlIllIIllll;
        this.category = lllllllllllIlIIIlllIlIlIllIIIllI;
        this.posX = (int)(lllllllllllIlIIIlllIlIlIllIIllIl * 8.0);
        this.posY = (int)(lllllllllllIlIIIlllIlIlIllIIIlII * 8.0);
        this.posZ = (int)(lllllllllllIlIIIlllIlIlIllIIIIll * 8.0);
        this.soundVolume = lllllllllllIlIIIlllIlIlIllIIIIlI;
        this.soundPitch = lllllllllllIlIIIlllIlIlIllIIIIIl;
    }
    
    public double getZ() {
        return this.posZ / 8.0f;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIIIlllIlIlIlIllIlIl) throws IOException {
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeVarIntToBuffer(SoundEvent.REGISTRY.getIDForObject(this.sound));
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeEnumValue(this.category);
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeInt(this.posX);
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeInt(this.posY);
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeInt(this.posZ);
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeFloat(this.soundVolume);
        lllllllllllIlIIIlllIlIlIlIllIlIl.writeFloat(this.soundPitch);
    }
    
    public SoundCategory getCategory() {
        return this.category;
    }
    
    public SPacketSoundEffect() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIIIlllIlIlIlIIllIlI) {
        lllllllllllIlIIIlllIlIlIlIIllIlI.handleSoundEffect(this);
    }
}
