// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.util.EnumSet;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.util.Set;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketPlayerPosLook implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Set<EnumFlags> flags;
    private /* synthetic */ int teleportId;
    private /* synthetic */ double y;
    public /* synthetic */ float yaw;
    private /* synthetic */ double x;
    public /* synthetic */ float pitch;
    private /* synthetic */ double z;
    
    public SPacketPlayerPosLook(final double llllllllllllllIlIIllllIlIlIIIIII, final double llllllllllllllIlIIllllIlIIllIlll, final double llllllllllllllIlIIllllIlIIllIllI, final float llllllllllllllIlIIllllIlIIllllIl, final float llllllllllllllIlIIllllIlIIllllII, final Set<EnumFlags> llllllllllllllIlIIllllIlIIlllIll, final int llllllllllllllIlIIllllIlIIllIIlI) {
        this.x = llllllllllllllIlIIllllIlIlIIIIII;
        this.y = llllllllllllllIlIIllllIlIIllIlll;
        this.z = llllllllllllllIlIIllllIlIIllIllI;
        this.yaw = llllllllllllllIlIIllllIlIIllllIl;
        this.pitch = llllllllllllllIlIIllllIlIIllllII;
        this.flags = llllllllllllllIlIIllllIlIIlllIll;
        this.teleportId = llllllllllllllIlIIllllIlIIllIIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIllllIlIIlIlllI) throws IOException {
        this.x = llllllllllllllIlIIllllIlIIlIlllI.readDouble();
        this.y = llllllllllllllIlIIllllIlIIlIlllI.readDouble();
        this.z = llllllllllllllIlIIllllIlIIlIlllI.readDouble();
        this.yaw = llllllllllllllIlIIllllIlIIlIlllI.readFloat();
        this.pitch = llllllllllllllIlIIllllIlIIlIlllI.readFloat();
        this.flags = EnumFlags.unpack(llllllllllllllIlIIllllIlIIlIlllI.readUnsignedByte());
        this.teleportId = llllllllllllllIlIIllllIlIIlIlllI.readVarIntFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIllllIlIIlIIIII) {
        llllllllllllllIlIIllllIlIIlIIIII.handlePlayerPosLook(this);
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public Set<EnumFlags> getFlags() {
        return this.flags;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIllllIlIIlIIllI) throws IOException {
        llllllllllllllIlIIllllIlIIlIIllI.writeDouble(this.x);
        llllllllllllllIlIIllllIlIIlIIllI.writeDouble(this.y);
        llllllllllllllIlIIllllIlIIlIIllI.writeDouble(this.z);
        llllllllllllllIlIIllllIlIIlIIllI.writeFloat(this.yaw);
        llllllllllllllIlIIllllIlIIlIIllI.writeFloat(this.pitch);
        llllllllllllllIlIIllllIlIIlIIllI.writeByte(EnumFlags.pack(this.flags));
        llllllllllllllIlIIllllIlIIlIIllI.writeVarIntToBuffer(this.teleportId);
    }
    
    public int getTeleportId() {
        return this.teleportId;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public SPacketPlayerPosLook() {
    }
    
    public double getZ() {
        return this.z;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public enum EnumFlags
    {
        private final /* synthetic */ int bit;
        
        X("X", 0, 0), 
        Z("Z", 2, 2), 
        X_ROT("X_ROT", 4, 4), 
        Y_ROT("Y_ROT", 3, 3), 
        Y("Y", 1, 1);
        
        private EnumFlags(final String llllllllllllIIIlIlIlIIlIlIllIIIl, final int llllllllllllIIIlIlIlIIlIlIllIIII, final int llllllllllllIIIlIlIlIIlIlIllIIll) {
            this.bit = llllllllllllIIIlIlIlIIlIlIllIIll;
        }
        
        private int getMask() {
            return 1 << this.bit;
        }
        
        public static Set<EnumFlags> unpack(final int llllllllllllIIIlIlIlIIlIlIIlllII) {
            final Set<EnumFlags> llllllllllllIIIlIlIlIIlIlIIllllI = EnumSet.noneOf(EnumFlags.class);
            final int llllllllllllIIIlIlIlIIlIlIIlIlll;
            final char llllllllllllIIIlIlIlIIlIlIIllIII = (char)((EnumFlags[])(Object)(llllllllllllIIIlIlIlIIlIlIIlIlll = (int)(Object)values())).length;
            for (boolean llllllllllllIIIlIlIlIIlIlIIllIIl = false; (llllllllllllIIIlIlIlIIlIlIIllIIl ? 1 : 0) < llllllllllllIIIlIlIlIIlIlIIllIII; ++llllllllllllIIIlIlIlIIlIlIIllIIl) {
                final EnumFlags llllllllllllIIIlIlIlIIlIlIIlllIl = llllllllllllIIIlIlIlIIlIlIIlIlll[llllllllllllIIIlIlIlIIlIlIIllIIl];
                if (llllllllllllIIIlIlIlIIlIlIIlllIl.isSet(llllllllllllIIIlIlIlIIlIlIIlllII)) {
                    llllllllllllIIIlIlIlIIlIlIIllllI.add(llllllllllllIIIlIlIlIIlIlIIlllIl);
                }
            }
            return llllllllllllIIIlIlIlIIlIlIIllllI;
        }
        
        private boolean isSet(final int llllllllllllIIIlIlIlIIlIlIlIIllI) {
            return (llllllllllllIIIlIlIlIIlIlIlIIllI & this.getMask()) == this.getMask();
        }
        
        public static int pack(final Set<EnumFlags> llllllllllllIIIlIlIlIIlIlIIlIIlI) {
            int llllllllllllIIIlIlIlIIlIlIIlIIIl = 0;
            for (final EnumFlags llllllllllllIIIlIlIlIIlIlIIlIIII : llllllllllllIIIlIlIlIIlIlIIlIIlI) {
                llllllllllllIIIlIlIlIIlIlIIlIIIl |= llllllllllllIIIlIlIlIIlIlIIlIIII.getMask();
            }
            return llllllllllllIIIlIlIlIIlIlIIlIIIl;
        }
    }
}
