// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketParticles implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float particleSpeed;
    private /* synthetic */ float xCoord;
    private /* synthetic */ int[] particleArguments;
    private /* synthetic */ boolean longDistance;
    private /* synthetic */ int particleCount;
    private /* synthetic */ float yOffset;
    private /* synthetic */ float zCoord;
    private /* synthetic */ EnumParticleTypes particleType;
    private /* synthetic */ float zOffset;
    private /* synthetic */ float yCoord;
    private /* synthetic */ float xOffset;
    
    public EnumParticleTypes getParticleType() {
        return this.particleType;
    }
    
    public int[] getParticleArgs() {
        return this.particleArguments;
    }
    
    public float getZOffset() {
        return this.zOffset;
    }
    
    public float getXOffset() {
        return this.xOffset;
    }
    
    public double getXCoordinate() {
        return this.xCoord;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIlllllIIllIlllIIlllI) throws IOException {
        lllllllllllIIlllllIIllIlllIIlllI.writeInt(this.particleType.getParticleID());
        lllllllllllIIlllllIIllIlllIIlllI.writeBoolean(this.longDistance);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.xCoord);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.yCoord);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.zCoord);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.xOffset);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.yOffset);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.zOffset);
        lllllllllllIIlllllIIllIlllIIlllI.writeFloat(this.particleSpeed);
        lllllllllllIIlllllIIllIlllIIlllI.writeInt(this.particleCount);
        for (int lllllllllllIIlllllIIllIlllIIllIl = this.particleType.getArgumentCount(), lllllllllllIIlllllIIllIlllIIllII = 0; lllllllllllIIlllllIIllIlllIIllII < lllllllllllIIlllllIIllIlllIIllIl; ++lllllllllllIIlllllIIllIlllIIllII) {
            lllllllllllIIlllllIIllIlllIIlllI.writeVarIntToBuffer(this.particleArguments[lllllllllllIIlllllIIllIlllIIllII]);
        }
    }
    
    public SPacketParticles() {
    }
    
    public int getParticleCount() {
        return this.particleCount;
    }
    
    public float getParticleSpeed() {
        return this.particleSpeed;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIlllllIIllIllIlIIIll) {
        lllllllllllIIlllllIIllIllIlIIIll.handleParticles(this);
    }
    
    public SPacketParticles(final EnumParticleTypes lllllllllllIIlllllIIllIllllIlIlI, final boolean lllllllllllIIlllllIIllIlllllIlIl, final float lllllllllllIIlllllIIllIllllIlIII, final float lllllllllllIIlllllIIllIlllllIIll, final float lllllllllllIIlllllIIllIllllIIllI, final float lllllllllllIIlllllIIllIllllIIlIl, final float lllllllllllIIlllllIIllIlllllIIII, final float lllllllllllIIlllllIIllIllllIllll, final float lllllllllllIIlllllIIllIllllIIIlI, final int lllllllllllIIlllllIIllIllllIIIIl, final int... lllllllllllIIlllllIIllIllllIIIII) {
        this.particleType = lllllllllllIIlllllIIllIllllIlIlI;
        this.longDistance = lllllllllllIIlllllIIllIlllllIlIl;
        this.xCoord = lllllllllllIIlllllIIllIllllIlIII;
        this.yCoord = lllllllllllIIlllllIIllIlllllIIll;
        this.zCoord = lllllllllllIIlllllIIllIllllIIllI;
        this.xOffset = lllllllllllIIlllllIIllIllllIIlIl;
        this.yOffset = lllllllllllIIlllllIIllIlllllIIII;
        this.zOffset = lllllllllllIIlllllIIllIllllIllll;
        this.particleSpeed = lllllllllllIIlllllIIllIllllIIIlI;
        this.particleCount = lllllllllllIIlllllIIllIllllIIIIl;
        this.particleArguments = lllllllllllIIlllllIIllIllllIIIII;
    }
    
    public boolean isLongDistance() {
        return this.longDistance;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIlllllIIllIlllIllIlI) throws IOException {
        this.particleType = EnumParticleTypes.getParticleFromId(lllllllllllIIlllllIIllIlllIllIlI.readInt());
        if (this.particleType == null) {
            this.particleType = EnumParticleTypes.BARRIER;
        }
        this.longDistance = lllllllllllIIlllllIIllIlllIllIlI.readBoolean();
        this.xCoord = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.yCoord = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.zCoord = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.xOffset = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.yOffset = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.zOffset = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.particleSpeed = lllllllllllIIlllllIIllIlllIllIlI.readFloat();
        this.particleCount = lllllllllllIIlllllIIllIlllIllIlI.readInt();
        final int lllllllllllIIlllllIIllIlllIllIIl = this.particleType.getArgumentCount();
        this.particleArguments = new int[lllllllllllIIlllllIIllIlllIllIIl];
        for (int lllllllllllIIlllllIIllIlllIllIII = 0; lllllllllllIIlllllIIllIlllIllIII < lllllllllllIIlllllIIllIlllIllIIl; ++lllllllllllIIlllllIIllIlllIllIII) {
            this.particleArguments[lllllllllllIIlllllIIllIlllIllIII] = lllllllllllIIlllllIIllIlllIllIlI.readVarIntFromBuffer();
        }
    }
    
    public float getYOffset() {
        return this.yOffset;
    }
    
    public double getZCoordinate() {
        return this.zCoord;
    }
    
    public double getYCoordinate() {
        return this.yCoord;
    }
}
