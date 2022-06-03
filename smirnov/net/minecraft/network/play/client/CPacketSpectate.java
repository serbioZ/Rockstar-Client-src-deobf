// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.util.UUID;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketSpectate implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ UUID id;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIlIlIIlIllIlIIIlIlI) throws IOException {
        this.id = lllllllllllIlIlIlIIlIllIlIIIlIlI.readUuid();
    }
    
    public CPacketSpectate(final UUID lllllllllllIlIlIlIIlIllIlIIlIIII) {
        this.id = lllllllllllIlIlIlIIlIllIlIIlIIII;
    }
    
    @Nullable
    public Entity getEntity(final WorldServer lllllllllllIlIlIlIIlIllIIllllIII) {
        return lllllllllllIlIlIlIIlIllIIllllIII.getEntityFromUuid(this.id);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIlIlIlIIlIllIIlllllII) {
        lllllllllllIlIlIlIIlIllIIlllllII.handleSpectate(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIlIlIIlIllIlIIIIlII) throws IOException {
        lllllllllllIlIlIlIIlIllIlIIIIlII.writeUuid(this.id);
    }
    
    public CPacketSpectate() {
    }
}
