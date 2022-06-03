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

public class SPacketSignEditorOpen implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ BlockPos signPosition;
    
    public SPacketSignEditorOpen() {
    }
    
    public BlockPos getSignPosition() {
        return this.signPosition;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIlllIlIlIlIIIIIIlIllIl) {
        llllllllllIlllIlIlIlIIIIIIlIllIl.handleSignEditorOpen(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllIlIlIlIIIIIIlIlIIl) throws IOException {
        this.signPosition = llllllllllIlllIlIlIlIIIIIIlIlIIl.readBlockPos();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllIlIlIlIIIIIIlIIIIl) throws IOException {
        llllllllllIlllIlIlIlIIIIIIlIIIIl.writeBlockPos(this.signPosition);
    }
    
    public SPacketSignEditorOpen(final BlockPos llllllllllIlllIlIlIlIIIIIIllIIll) {
        this.signPosition = llllllllllIlllIlIlIlIIIIIIllIIll;
    }
}
