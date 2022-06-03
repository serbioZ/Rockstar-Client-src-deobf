// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityAttach implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int vehicleEntityId;
    private /* synthetic */ int entityId;
    
    public int getVehicleEntityId() {
        return this.vehicleEntityId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlllIllIlIIIllllIIIlI) {
        lllllllllllIlllIllIlIIIllllIIIlI.handleEntityAttach(this);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlllIllIlIIIllllIlllI) throws IOException {
        this.entityId = lllllllllllIlllIllIlIIIllllIlllI.readInt();
        this.vehicleEntityId = lllllllllllIlllIllIlIIIllllIlllI.readInt();
    }
    
    public SPacketEntityAttach() {
    }
    
    public SPacketEntityAttach(final Entity lllllllllllIlllIllIlIIIlllllIlIl, @Nullable final Entity lllllllllllIlllIllIlIIIlllllIlll) {
        this.entityId = lllllllllllIlllIllIlIIIlllllIlIl.getEntityId();
        this.vehicleEntityId = ((lllllllllllIlllIllIlIIIlllllIlll != null) ? lllllllllllIlllIllIlIIIlllllIlll.getEntityId() : -1);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlllIllIlIIIllllIlIII) throws IOException {
        lllllllllllIlllIllIlIIIllllIlIII.writeInt(this.entityId);
        lllllllllllIlllIllIlIIIllllIlIII.writeInt(this.vehicleEntityId);
    }
}
