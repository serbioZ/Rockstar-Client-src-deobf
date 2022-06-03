// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSpawnPosition implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockPos spawnBlockPos;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIllIIlIIlIIIlIII) throws IOException {
        llllllllllllIlllIllIIlIIlIIIlIII.writeBlockPos(this.spawnBlockPos);
    }
    
    public SPacketSpawnPosition() {
    }
    
    public SPacketSpawnPosition(final BlockPos llllllllllllIlllIllIIlIIlIIlIlII) {
        this.spawnBlockPos = llllllllllllIlllIllIIlIIlIIlIlII;
    }
    
    public BlockPos getSpawnPos() {
        return this.spawnBlockPos;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIllIIlIIlIIlIIII) throws IOException {
        this.spawnBlockPos = llllllllllllIlllIllIIlIIlIIlIIII.readBlockPos();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIlllIllIIlIIlIIIIlII) {
        llllllllllllIlllIllIIlIIlIIIIlII.handleSpawnPosition(this);
    }
}
