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

public class SPacketBlockBreakAnim implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int progress;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ int breakerId;
    
    public int getBreakerId() {
        return this.breakerId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllllllIIIIlIlllllII) {
        lllllllllllllllllllIIIIlIlllllII.handleBlockBreakAnim(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIIIIllIIIlIlI) throws IOException {
        this.breakerId = lllllllllllllllllllIIIIllIIIlIlI.readVarIntFromBuffer();
        this.position = lllllllllllllllllllIIIIllIIIlIlI.readBlockPos();
        this.progress = lllllllllllllllllllIIIIllIIIlIlI.readUnsignedByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIIIIllIIIIIlI) throws IOException {
        lllllllllllllllllllIIIIllIIIIIlI.writeVarIntToBuffer(this.breakerId);
        lllllllllllllllllllIIIIllIIIIIlI.writeBlockPos(this.position);
        lllllllllllllllllllIIIIllIIIIIlI.writeByte(this.progress);
    }
    
    public int getProgress() {
        return this.progress;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public SPacketBlockBreakAnim() {
    }
    
    public SPacketBlockBreakAnim(final int lllllllllllllllllllIIIIllIIlIIII, final BlockPos lllllllllllllllllllIIIIllIIIllll, final int lllllllllllllllllllIIIIllIIlIIlI) {
        this.breakerId = lllllllllllllllllllIIIIllIIlIIII;
        this.position = lllllllllllllllllllIIIIllIIIllll;
        this.progress = lllllllllllllllllllIIIIllIIlIIlI;
    }
}
