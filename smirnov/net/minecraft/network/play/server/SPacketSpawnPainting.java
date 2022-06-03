// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import java.util.UUID;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnPainting implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ EnumFacing facing;
    private /* synthetic */ int entityID;
    private /* synthetic */ String title;
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ BlockPos position;
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIIllIIlllllIIIIII) throws IOException {
        this.entityID = llllllllllIllllIIllIIlllllIIIIII.readVarIntFromBuffer();
        this.uniqueId = llllllllllIllllIIllIIlllllIIIIII.readUuid();
        this.title = llllllllllIllllIIllIIlllllIIIIII.readStringFromBuffer(EntityPainting.EnumArt.MAX_NAME_LENGTH);
        this.position = llllllllllIllllIIllIIlllllIIIIII.readBlockPos();
        this.facing = EnumFacing.getHorizontal(llllllllllIllllIIllIIlllllIIIIII.readUnsignedByte());
    }
    
    public String getTitle() {
        return this.title;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllIIllIIllllIllIlII) {
        llllllllllIllllIIllIIllllIllIlII.handleSpawnPainting(this);
    }
    
    public SPacketSpawnPainting(final EntityPainting llllllllllIllllIIllIIlllllIIIlII) {
        this.entityID = llllllllllIllllIIllIIlllllIIIlII.getEntityId();
        this.uniqueId = llllllllllIllllIIllIIlllllIIIlII.getUniqueID();
        this.position = llllllllllIllllIIllIIlllllIIIlII.getHangingPosition();
        this.facing = llllllllllIllllIIllIIlllllIIIlII.facingDirection;
        this.title = llllllllllIllllIIllIIlllllIIIlII.art.title;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public EnumFacing getFacing() {
        return this.facing;
    }
    
    public SPacketSpawnPainting() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIIllIIllllIlllIII) throws IOException {
        llllllllllIllllIIllIIllllIlllIII.writeVarIntToBuffer(this.entityID);
        llllllllllIllllIIllIIllllIlllIII.writeUuid(this.uniqueId);
        llllllllllIllllIIllIIllllIlllIII.writeString(this.title);
        llllllllllIllllIIllIIllllIlllIII.writeBlockPos(this.position);
        llllllllllIllllIIllIIllllIlllIII.writeByte(this.facing.getHorizontalIndex());
    }
    
    public int getEntityID() {
        return this.entityID;
    }
}
