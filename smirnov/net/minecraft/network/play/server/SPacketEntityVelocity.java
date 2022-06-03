// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityVelocity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityID;
    public /* synthetic */ int motionZ;
    public /* synthetic */ int motionY;
    public /* synthetic */ int motionX;
    
    public SPacketEntityVelocity() {
    }
    
    public int getMotionY() {
        return this.motionY;
    }
    
    public int getMotionZ() {
        return this.motionZ;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlIllIIllllIIlllllIl) throws IOException {
        this.entityID = llllllllllllIlIllIIllllIIlllllIl.readVarIntFromBuffer();
        this.motionX = llllllllllllIlIllIIllllIIlllllIl.readShort();
        this.motionY = llllllllllllIlIllIIllllIIlllllIl.readShort();
        this.motionZ = llllllllllllIlIllIIllllIIlllllIl.readShort();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlIllIIllllIIllIllll) {
        llllllllllllIlIllIIllllIIllIllll.handleEntityVelocity(this);
    }
    
    public SPacketEntityVelocity(final int llllllllllllIlIllIIllllIlIIIIlIl, double llllllllllllIlIllIIllllIlIIIIlII, double llllllllllllIlIllIIllllIlIIIlIIl, double llllllllllllIlIllIIllllIlIIIIIlI) {
        this.entityID = llllllllllllIlIllIIllllIlIIIIlIl;
        final double llllllllllllIlIllIIllllIlIIIIlll = 3.9;
        if (llllllllllllIlIllIIllllIlIIIIlII < -3.9) {
            llllllllllllIlIllIIllllIlIIIIlII = -3.9;
        }
        if (llllllllllllIlIllIIllllIlIIIlIIl < -3.9) {
            llllllllllllIlIllIIllllIlIIIlIIl = -3.9;
        }
        if (llllllllllllIlIllIIllllIlIIIIIlI < -3.9) {
            llllllllllllIlIllIIllllIlIIIIIlI = -3.9;
        }
        if (llllllllllllIlIllIIllllIlIIIIlII > 3.9) {
            llllllllllllIlIllIIllllIlIIIIlII = 3.9;
        }
        if (llllllllllllIlIllIIllllIlIIIlIIl > 3.9) {
            llllllllllllIlIllIIllllIlIIIlIIl = 3.9;
        }
        if (llllllllllllIlIllIIllllIlIIIIIlI > 3.9) {
            llllllllllllIlIllIIllllIlIIIIIlI = 3.9;
        }
        this.motionX = (int)(llllllllllllIlIllIIllllIlIIIIlII * 8000.0);
        this.motionY = (int)(llllllllllllIlIllIIllllIlIIIlIIl * 8000.0);
        this.motionZ = (int)(llllllllllllIlIllIIllllIlIIIIIlI * 8000.0);
    }
    
    public int getEntityID() {
        return this.entityID;
    }
    
    public int getMotionX() {
        return this.motionX;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlIllIIllllIIlllIlIl) throws IOException {
        llllllllllllIlIllIIllllIIlllIlIl.writeVarIntToBuffer(this.entityID);
        llllllllllllIlIllIIllllIIlllIlIl.writeShort(this.motionX);
        llllllllllllIlIllIIllllIIlllIlIl.writeShort(this.motionY);
        llllllllllllIlIllIIllllIIlllIlIl.writeShort(this.motionZ);
    }
    
    public SPacketEntityVelocity(final Entity llllllllllllIlIllIIllllIlIIlIlIl) {
        this(llllllllllllIlIllIIllllIlIIlIlIl.getEntityId(), llllllllllllIlIllIIllllIlIIlIlIl.motionX, llllllllllllIlIllIIllllIlIIlIlIl.motionY, llllllllllllIlIllIIllllIlIIlIlIl.motionZ);
    }
}
