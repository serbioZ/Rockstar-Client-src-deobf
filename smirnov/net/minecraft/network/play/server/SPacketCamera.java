// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCamera implements Packet<INetHandlerPlayClient>
{
    public /* synthetic */ int entityId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIllllIIlIllIlllllII) {
        lllllllllllIlIllllIIlIllIlllllII.handleCamera(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIllllIIlIlllIIIIllI) throws IOException {
        this.entityId = lllllllllllIlIllllIIlIlllIIIIllI.readVarIntFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIllllIIlIlllIIIIIII) throws IOException {
        lllllllllllIlIllllIIlIlllIIIIIII.writeVarIntToBuffer(this.entityId);
    }
    
    public SPacketCamera(final Entity lllllllllllIlIllllIIlIlllIIIllII) {
        this.entityId = lllllllllllIlIllllIIlIlllIIIllII.getEntityId();
    }
    
    public SPacketCamera() {
    }
    
    @Nullable
    public Entity getEntity(final World lllllllllllIlIllllIIlIllIlllIllI) {
        return lllllllllllIlIllllIIlIllIlllIllI.getEntityByID(this.entityId);
    }
}
