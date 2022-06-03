// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import org.apache.commons.lang3.Validate;
import net.minecraft.util.SoundCategory;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCustomSound implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float pitch;
    private /* synthetic */ SoundCategory category;
    private /* synthetic */ int z;
    private /* synthetic */ int y;
    private /* synthetic */ float volume;
    private /* synthetic */ int x;
    private /* synthetic */ String soundName;
    
    public SPacketCustomSound(final String lllllllllllIIIIlIIlIIllIllIIIlII, final SoundCategory lllllllllllIIIIlIIlIIllIllIIIIll, final double lllllllllllIIIIlIIlIIllIllIIlIlI, final double lllllllllllIIIIlIIlIIllIllIIlIIl, final double lllllllllllIIIIlIIlIIllIllIIIIII, final float lllllllllllIIIIlIIlIIllIllIIIlll, final float lllllllllllIIIIlIIlIIllIlIlllllI) {
        this.y = Integer.MAX_VALUE;
        Validate.notNull((Object)lllllllllllIIIIlIIlIIllIllIIIlII, "name", new Object[0]);
        this.soundName = lllllllllllIIIIlIIlIIllIllIIIlII;
        this.category = lllllllllllIIIIlIIlIIllIllIIIIll;
        this.x = (int)(lllllllllllIIIIlIIlIIllIllIIlIlI * 8.0);
        this.y = (int)(lllllllllllIIIIlIIlIIllIllIIlIIl * 8.0);
        this.z = (int)(lllllllllllIIIIlIIlIIllIllIIIIII * 8.0);
        this.volume = lllllllllllIIIIlIIlIIllIllIIIlll;
        this.pitch = lllllllllllIIIIlIIlIIllIlIlllllI;
    }
    
    public SoundCategory getCategory() {
        return this.category;
    }
    
    public double getX() {
        return this.x / 8.0f;
    }
    
    public double getZ() {
        return this.z / 8.0f;
    }
    
    public SPacketCustomSound() {
        this.y = Integer.MAX_VALUE;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    public String getSoundName() {
        return this.soundName;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIIlIIlIIllIlIllIlII) throws IOException {
        lllllllllllIIIIlIIlIIllIlIllIlII.writeString(this.soundName);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeEnumValue(this.category);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeInt(this.x);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeInt(this.y);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeInt(this.z);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeFloat(this.volume);
        lllllllllllIIIIlIIlIIllIlIllIlII.writeFloat(this.pitch);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIIlIIlIIllIlIIlIlll) {
        lllllllllllIIIIlIIlIIllIlIIlIlll.handleCustomSound(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIIlIIlIIllIlIlllIlI) throws IOException {
        this.soundName = lllllllllllIIIIlIIlIIllIlIlllIlI.readStringFromBuffer(256);
        this.category = lllllllllllIIIIlIIlIIllIlIlllIlI.readEnumValue(SoundCategory.class);
        this.x = lllllllllllIIIIlIIlIIllIlIlllIlI.readInt();
        this.y = lllllllllllIIIIlIIlIIllIlIlllIlI.readInt();
        this.z = lllllllllllIIIIlIIlIIllIlIlllIlI.readInt();
        this.volume = lllllllllllIIIIlIIlIIllIlIlllIlI.readFloat();
        this.pitch = lllllllllllIIIIlIIlIIllIlIlllIlI.readFloat();
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public double getY() {
        return this.y / 8.0f;
    }
}
