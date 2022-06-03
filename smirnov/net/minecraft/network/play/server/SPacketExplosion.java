// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import com.google.common.collect.Lists;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.INetHandler;
import net.minecraft.util.math.BlockPos;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketExplosion implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ double posY;
    private /* synthetic */ double posX;
    private /* synthetic */ float strength;
    public /* synthetic */ float motionZ;
    public /* synthetic */ float motionY;
    public /* synthetic */ float motionX;
    private /* synthetic */ List<BlockPos> affectedBlockPositions;
    private /* synthetic */ double posZ;
    
    public float getMotionX() {
        return this.motionX;
    }
    
    public float getStrength() {
        return this.strength;
    }
    
    public SPacketExplosion(final double llllllllllllIIIlIlllIlIIlIlllIll, final double llllllllllllIIIlIlllIlIIlIlllIlI, final double llllllllllllIIIlIlllIlIIlIlllIIl, final float llllllllllllIIIlIlllIlIIlIlllIII, final List<BlockPos> llllllllllllIIIlIlllIlIIlIllIlll, final Vec3d llllllllllllIIIlIlllIlIIlIllIllI) {
        this.posX = llllllllllllIIIlIlllIlIIlIlllIll;
        this.posY = llllllllllllIIIlIlllIlIIlIlllIlI;
        this.posZ = llllllllllllIIIlIlllIlIIlIlllIIl;
        this.strength = llllllllllllIIIlIlllIlIIlIlllIII;
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayList((Iterable)llllllllllllIIIlIlllIlIIlIllIlll);
        if (llllllllllllIIIlIlllIlIIlIllIllI != null) {
            this.motionX = (float)llllllllllllIIIlIlllIlIIlIllIllI.xCoord;
            this.motionY = (float)llllllllllllIIIlIlllIlIIlIllIllI.yCoord;
            this.motionZ = (float)llllllllllllIIIlIlllIlIIlIllIllI.zCoord;
        }
    }
    
    public float getMotionZ() {
        return this.motionZ;
    }
    
    public SPacketExplosion() {
    }
    
    public double getY() {
        return this.posY;
    }
    
    public float getMotionY() {
        return this.motionY;
    }
    
    public List<BlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIIlIlllIlIIIllIlllI) {
        llllllllllllIIIlIlllIlIIIllIlllI.handleExplosion(this);
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    public double getX() {
        return this.posX;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIlIlllIlIIlIIllIIl) throws IOException {
        this.posX = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        this.posY = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        this.posZ = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        this.strength = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        final int llllllllllllIIIlIlllIlIIlIlIIIlI = llllllllllllIIIlIlllIlIIlIIllIIl.readInt();
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayListWithCapacity(llllllllllllIIIlIlllIlIIlIlIIIlI);
        final int llllllllllllIIIlIlllIlIIlIlIIIIl = (int)this.posX;
        final int llllllllllllIIIlIlllIlIIlIlIIIII = (int)this.posY;
        final int llllllllllllIIIlIlllIlIIlIIlllll = (int)this.posZ;
        for (int llllllllllllIIIlIlllIlIIlIIllllI = 0; llllllllllllIIIlIlllIlIIlIIllllI < llllllllllllIIIlIlllIlIIlIlIIIlI; ++llllllllllllIIIlIlllIlIIlIIllllI) {
            final int llllllllllllIIIlIlllIlIIlIIlllIl = llllllllllllIIIlIlllIlIIlIIllIIl.readByte() + llllllllllllIIIlIlllIlIIlIlIIIIl;
            final int llllllllllllIIIlIlllIlIIlIIlllII = llllllllllllIIIlIlllIlIIlIIllIIl.readByte() + llllllllllllIIIlIlllIlIIlIlIIIII;
            final int llllllllllllIIIlIlllIlIIlIIllIll = llllllllllllIIIlIlllIlIIlIIllIIl.readByte() + llllllllllllIIIlIlllIlIIlIIlllll;
            this.affectedBlockPositions.add(new BlockPos(llllllllllllIIIlIlllIlIIlIIlllIl, llllllllllllIIIlIlllIlIIlIIlllII, llllllllllllIIIlIlllIlIIlIIllIll));
        }
        this.motionX = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        this.motionY = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
        this.motionZ = llllllllllllIIIlIlllIlIIlIIllIIl.readFloat();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIlIlllIlIIlIIIIlIl) throws IOException {
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat((float)this.posX);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat((float)this.posY);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat((float)this.posZ);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat(this.strength);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeInt(this.affectedBlockPositions.size());
        final int llllllllllllIIIlIlllIlIIlIIIIlII = (int)this.posX;
        final int llllllllllllIIIlIlllIlIIlIIIIIll = (int)this.posY;
        final int llllllllllllIIIlIlllIlIIlIIIIIlI = (int)this.posZ;
        for (final BlockPos llllllllllllIIIlIlllIlIIlIIIIIIl : this.affectedBlockPositions) {
            final int llllllllllllIIIlIlllIlIIlIIIIIII = llllllllllllIIIlIlllIlIIlIIIIIIl.getX() - llllllllllllIIIlIlllIlIIlIIIIlII;
            final int llllllllllllIIIlIlllIlIIIlllllll = llllllllllllIIIlIlllIlIIlIIIIIIl.getY() - llllllllllllIIIlIlllIlIIlIIIIIll;
            final int llllllllllllIIIlIlllIlIIIllllllI = llllllllllllIIIlIlllIlIIlIIIIIIl.getZ() - llllllllllllIIIlIlllIlIIlIIIIIlI;
            llllllllllllIIIlIlllIlIIlIIIIlIl.writeByte(llllllllllllIIIlIlllIlIIlIIIIIII);
            llllllllllllIIIlIlllIlIIlIIIIlIl.writeByte(llllllllllllIIIlIlllIlIIIlllllll);
            llllllllllllIIIlIlllIlIIlIIIIlIl.writeByte(llllllllllllIIIlIlllIlIIIllllllI);
        }
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat(this.motionX);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat(this.motionY);
        llllllllllllIIIlIlllIlIIlIIIIlIl.writeFloat(this.motionZ);
    }
}
