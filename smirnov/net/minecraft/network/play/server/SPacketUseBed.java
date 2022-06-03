// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.world.World;
import net.minecraft.network.INetHandler;
import net.minecraft.entity.player.EntityPlayer;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUseBed implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int playerID;
    private /* synthetic */ BlockPos bedPos;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIllIlIlIllIllIII) throws IOException {
        llllllllllllllIlIllIlIlIllIllIII.writeVarIntToBuffer(this.playerID);
        llllllllllllllIlIllIlIlIllIllIII.writeBlockPos(this.bedPos);
    }
    
    public SPacketUseBed(final EntityPlayer llllllllllllllIlIllIlIlIlllIIlIl, final BlockPos llllllllllllllIlIllIlIlIlllIIlll) {
        this.playerID = llllllllllllllIlIllIlIlIlllIIlIl.getEntityId();
        this.bedPos = llllllllllllllIlIllIlIlIlllIIlll;
    }
    
    public SPacketUseBed() {
    }
    
    public EntityPlayer getPlayer(final World llllllllllllllIlIllIlIlIllIIllII) {
        return (EntityPlayer)llllllllllllllIlIllIlIlIllIIllII.getEntityByID(this.playerID);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIllIlIlIllIllllI) throws IOException {
        this.playerID = llllllllllllllIlIllIlIlIllIllllI.readVarIntFromBuffer();
        this.bedPos = llllllllllllllIlIllIlIlIllIllllI.readBlockPos();
    }
    
    public BlockPos getBedPosition() {
        return this.bedPos;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIllIlIlIllIlIIlI) {
        llllllllllllllIlIllIlIlIllIlIIlI.handleUseBed(this);
    }
}
