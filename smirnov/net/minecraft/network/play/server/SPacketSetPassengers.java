// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSetPassengers implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int[] passengerIds;
    private /* synthetic */ int entityId;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIlllIIlIlIIlIIlIll) throws IOException {
        this.entityId = llllllllllllIIIlllIIlIlIIlIIlIll.readVarIntFromBuffer();
        this.passengerIds = llllllllllllIIIlllIIlIlIIlIIlIll.readVarIntArray();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIlllIIlIlIIlIIIlIl) throws IOException {
        llllllllllllIIIlllIIlIlIIlIIIlIl.writeVarIntToBuffer(this.entityId);
        llllllllllllIIIlllIIlIlIIlIIIlIl.writeVarIntArray(this.passengerIds);
    }
    
    public SPacketSetPassengers() {
    }
    
    public SPacketSetPassengers(final Entity llllllllllllIIIlllIIlIlIIlIlIIll) {
        this.entityId = llllllllllllIIIlllIIlIlIIlIlIIll.getEntityId();
        final List<Entity> llllllllllllIIIlllIIlIlIIlIlIllI = llllllllllllIIIlllIIlIlIIlIlIIll.getPassengers();
        this.passengerIds = new int[llllllllllllIIIlllIIlIlIIlIlIllI.size()];
        for (int llllllllllllIIIlllIIlIlIIlIlIlIl = 0; llllllllllllIIIlllIIlIlIIlIlIlIl < llllllllllllIIIlllIIlIlIIlIlIllI.size(); ++llllllllllllIIIlllIIlIlIIlIlIlIl) {
            this.passengerIds[llllllllllllIIIlllIIlIlIIlIlIlIl] = llllllllllllIIIlllIIlIlIIlIlIllI.get(llllllllllllIIIlllIIlIlIIlIlIlIl).getEntityId();
        }
    }
    
    public int[] getPassengerIds() {
        return this.passengerIds;
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIIlllIIlIlIIIllllll) {
        llllllllllllIIIlllIIlIlIIIllllll.handleSetPassengers(this);
    }
}
