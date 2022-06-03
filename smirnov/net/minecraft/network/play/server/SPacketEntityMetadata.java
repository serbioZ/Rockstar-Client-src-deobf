// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.datasync.EntityDataManager;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityMetadata implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ List<EntityDataManager.DataEntry<?>> dataManagerEntries;
    private /* synthetic */ int entityId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllIlIIlIIIIIIIIllll) {
        llllllllllIllllIlIIlIIIIIIIIllll.handleEntityMetadata(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIlIIlIIIIIIIllIll) throws IOException {
        this.entityId = llllllllllIllllIlIIlIIIIIIIllIll.readVarIntFromBuffer();
        this.dataManagerEntries = EntityDataManager.readEntries(llllllllllIllllIlIIlIIIIIIIllIll);
    }
    
    public SPacketEntityMetadata() {
    }
    
    public SPacketEntityMetadata(final int llllllllllIllllIlIIlIIIIIIlIIIIl, final EntityDataManager llllllllllIllllIlIIlIIIIIIlIIIII, final boolean llllllllllIllllIlIIlIIIIIIlIIIll) {
        this.entityId = llllllllllIllllIlIIlIIIIIIlIIIIl;
        if (llllllllllIllllIlIIlIIIIIIlIIIll) {
            this.dataManagerEntries = llllllllllIllllIlIIlIIIIIIlIIIII.getAll();
            llllllllllIllllIlIIlIIIIIIlIIIII.setClean();
        }
        else {
            this.dataManagerEntries = llllllllllIllllIlIIlIIIIIIlIIIII.getDirty();
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIlIIlIIIIIIIlIlIl) throws IOException {
        llllllllllIllllIlIIlIIIIIIIlIlIl.writeVarIntToBuffer(this.entityId);
        EntityDataManager.writeEntries(this.dataManagerEntries, llllllllllIllllIlIIlIIIIIIIlIlIl);
    }
    
    public List<EntityDataManager.DataEntry<?>> getDataManagerEntries() {
        return this.dataManagerEntries;
    }
    
    public int getEntityId() {
        return this.entityId;
    }
}
