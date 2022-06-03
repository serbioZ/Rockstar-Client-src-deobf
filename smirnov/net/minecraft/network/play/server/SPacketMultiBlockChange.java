// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.INetHandler;
import net.minecraft.world.chunk.Chunk;
import java.io.IOException;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketMultiBlockChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ChunkPos chunkPos;
    private /* synthetic */ BlockUpdateData[] changedBlocks;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIlIlllIIllIIIIIlIIl) throws IOException {
        this.chunkPos = new ChunkPos(lllllllllllIlIlIlllIIllIIIIIlIIl.readInt(), lllllllllllIlIlIlllIIllIIIIIlIIl.readInt());
        this.changedBlocks = new BlockUpdateData[lllllllllllIlIlIlllIIllIIIIIlIIl.readVarIntFromBuffer()];
        for (int lllllllllllIlIlIlllIIllIIIIIlIII = 0; lllllllllllIlIlIlllIIllIIIIIlIII < this.changedBlocks.length; ++lllllllllllIlIlIlllIIllIIIIIlIII) {
            this.changedBlocks[lllllllllllIlIlIlllIIllIIIIIlIII] = new BlockUpdateData(lllllllllllIlIlIlllIIllIIIIIlIIl.readShort(), Block.BLOCK_STATE_IDS.getByValue(lllllllllllIlIlIlllIIllIIIIIlIIl.readVarIntFromBuffer()));
        }
    }
    
    public SPacketMultiBlockChange(final int lllllllllllIlIlIlllIIllIIIIlIIIl, final short[] lllllllllllIlIlIlllIIllIIIIlIlIl, final Chunk lllllllllllIlIlIlllIIllIIIIlIlII) {
        this.chunkPos = new ChunkPos(lllllllllllIlIlIlllIIllIIIIlIlII.xPosition, lllllllllllIlIlIlllIIllIIIIlIlII.zPosition);
        this.changedBlocks = new BlockUpdateData[lllllllllllIlIlIlllIIllIIIIlIIIl];
        for (int lllllllllllIlIlIlllIIllIIIIlIIll = 0; lllllllllllIlIlIlllIIllIIIIlIIll < this.changedBlocks.length; ++lllllllllllIlIlIlllIIllIIIIlIIll) {
            this.changedBlocks[lllllllllllIlIlIlllIIllIIIIlIIll] = new BlockUpdateData(lllllllllllIlIlIlllIIllIIIIlIlIl[lllllllllllIlIlIlllIIllIIIIlIIll], lllllllllllIlIlIlllIIllIIIIlIlII);
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlIlIlllIIlIlllllIIlI) {
        lllllllllllIlIlIlllIIlIlllllIIlI.handleMultiBlockChange(this);
    }
    
    public BlockUpdateData[] getChangedBlocks() {
        return this.changedBlocks;
    }
    
    public SPacketMultiBlockChange() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIlIlllIIlIllllllIlI) throws IOException {
        lllllllllllIlIlIlllIIlIllllllIlI.writeInt(this.chunkPos.chunkXPos);
        lllllllllllIlIlIlllIIlIllllllIlI.writeInt(this.chunkPos.chunkZPos);
        lllllllllllIlIlIlllIIlIllllllIlI.writeVarIntToBuffer(this.changedBlocks.length);
        final int lllllllllllIlIlIlllIIlIlllllIllI;
        final boolean lllllllllllIlIlIlllIIlIlllllIlll = ((BlockUpdateData[])(Object)(lllllllllllIlIlIlllIIlIlllllIllI = (int)(Object)this.changedBlocks)).length != 0;
        for (String lllllllllllIlIlIlllIIlIllllllIII = (String)0; lllllllllllIlIlIlllIIlIllllllIII < lllllllllllIlIlIlllIIlIlllllIlll; ++lllllllllllIlIlIlllIIlIllllllIII) {
            final BlockUpdateData lllllllllllIlIlIlllIIlIlllllllII = lllllllllllIlIlIlllIIlIlllllIllI[lllllllllllIlIlIlllIIlIllllllIII];
            lllllllllllIlIlIlllIIlIllllllIlI.writeShort(lllllllllllIlIlIlllIIlIlllllllII.getOffset());
            lllllllllllIlIlIlllIIlIllllllIlI.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(lllllllllllIlIlIlllIIlIlllllllII.getBlockState()));
        }
    }
    
    public class BlockUpdateData
    {
        private final /* synthetic */ short offset;
        private final /* synthetic */ IBlockState blockState;
        
        public BlockUpdateData(final short lllllllllllIIlIlIlIIIlIlIllllIlI, final IBlockState lllllllllllIIlIlIlIIIlIlIlllIlIl) {
            this.offset = lllllllllllIIlIlIlIIIlIlIllllIlI;
            this.blockState = lllllllllllIIlIlIlIIIlIlIlllIlIl;
        }
        
        public IBlockState getBlockState() {
            return this.blockState;
        }
        
        public BlockPos getPos() {
            return new BlockPos(SPacketMultiBlockChange.this.chunkPos.getBlock(this.offset >> 12 & 0xF, this.offset & 0xFF, this.offset >> 8 & 0xF));
        }
        
        public short getOffset() {
            return this.offset;
        }
        
        public BlockUpdateData(final short lllllllllllIIlIlIlIIIlIlIllIllll, final Chunk lllllllllllIIlIlIlIIIlIlIllIlllI) {
            this.offset = lllllllllllIIlIlIlIIIlIlIllIllll;
            this.blockState = lllllllllllIIlIlIlIIIlIlIllIlllI.getBlockState(this.getPos());
        }
    }
}
