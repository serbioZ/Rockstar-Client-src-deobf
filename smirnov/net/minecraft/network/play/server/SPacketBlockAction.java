// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketBlockAction implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Block block;
    private /* synthetic */ int pitch;
    private /* synthetic */ BlockPos blockPosition;
    private /* synthetic */ int instrument;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIlIlIIIlllIIIlIIlII) {
        llllllllllllIIlIlIIIlllIIIlIIlII.handleBlockAction(this);
    }
    
    public Block getBlockType() {
        return this.block;
    }
    
    public int getData1() {
        return this.instrument;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlIlIIIlllIIIllIIII) throws IOException {
        this.blockPosition = llllllllllllIIlIlIIIlllIIIllIIII.readBlockPos();
        this.instrument = llllllllllllIIlIlIIIlllIIIllIIII.readUnsignedByte();
        this.pitch = llllllllllllIIlIlIIIlllIIIllIIII.readUnsignedByte();
        this.block = Block.getBlockById(llllllllllllIIlIlIIIlllIIIllIIII.readVarIntFromBuffer() & 0xFFF);
    }
    
    public SPacketBlockAction() {
    }
    
    public SPacketBlockAction(final BlockPos llllllllllllIIlIlIIIlllIIIlllllI, final Block llllllllllllIIlIlIIIlllIIIllllIl, final int llllllllllllIIlIlIIIlllIIIllllII, final int llllllllllllIIlIlIIIlllIIIlllIll) {
        this.blockPosition = llllllllllllIIlIlIIIlllIIIlllllI;
        this.instrument = llllllllllllIIlIlIIIlllIIIllllII;
        this.pitch = llllllllllllIIlIlIIIlllIIIlllIll;
        this.block = llllllllllllIIlIlIIIlllIIIllllIl;
    }
    
    public BlockPos getBlockPosition() {
        return this.blockPosition;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlIlIIIlllIIIlIllII) throws IOException {
        llllllllllllIIlIlIIIlllIIIlIllII.writeBlockPos(this.blockPosition);
        llllllllllllIIlIlIIIlllIIIlIllII.writeByte(this.instrument);
        llllllllllllIIlIlIIIlllIIIlIllII.writeByte(this.pitch);
        llllllllllllIIlIlIIIlllIIIlIllII.writeVarIntToBuffer(Block.getIdFromBlock(this.block) & 0xFFF);
    }
    
    public int getData2() {
        return this.pitch;
    }
}
