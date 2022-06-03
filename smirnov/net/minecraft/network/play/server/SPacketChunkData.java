// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.INetHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import java.util.Map;
import com.google.common.collect.Lists;
import net.minecraft.world.chunk.Chunk;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.NBTTagCompound;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketChunkData implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte[] buffer;
    private /* synthetic */ List<NBTTagCompound> tileEntityTags;
    private /* synthetic */ int chunkX;
    private /* synthetic */ int chunkZ;
    private /* synthetic */ int availableSections;
    private /* synthetic */ boolean loadChunk;
    
    public PacketBuffer getReadBuffer() {
        return new PacketBuffer(Unpooled.wrappedBuffer(this.buffer));
    }
    
    public SPacketChunkData(final Chunk lllllllllllIllIlIIllIllIlIllIIll, final int lllllllllllIllIlIIllIllIlIllIIlI) {
        this.chunkX = lllllllllllIllIlIIllIllIlIllIIll.xPosition;
        this.chunkZ = lllllllllllIllIlIIllIllIlIllIIll.zPosition;
        this.loadChunk = (lllllllllllIllIlIIllIllIlIllIIlI == 65535);
        final boolean lllllllllllIllIlIIllIllIlIllIIIl = lllllllllllIllIlIIllIllIlIllIIll.getWorld().provider.func_191066_m();
        this.buffer = new byte[this.calculateChunkSize(lllllllllllIllIlIIllIllIlIllIIll, lllllllllllIllIlIIllIllIlIllIIIl, lllllllllllIllIlIIllIllIlIllIIlI)];
        this.availableSections = this.extractChunkData(new PacketBuffer(this.getWriteBuffer()), lllllllllllIllIlIIllIllIlIllIIll, lllllllllllIllIlIIllIllIlIllIIIl, lllllllllllIllIlIIllIllIlIllIIlI);
        this.tileEntityTags = (List<NBTTagCompound>)Lists.newArrayList();
        for (final Map.Entry<BlockPos, TileEntity> lllllllllllIllIlIIllIllIlIllIIII : lllllllllllIllIlIIllIllIlIllIIll.getTileEntityMap().entrySet()) {
            final BlockPos lllllllllllIllIlIIllIllIlIlIllll = lllllllllllIllIlIIllIllIlIllIIII.getKey();
            final TileEntity lllllllllllIllIlIIllIllIlIlIlllI = lllllllllllIllIlIIllIllIlIllIIII.getValue();
            final int lllllllllllIllIlIIllIllIlIlIllIl = lllllllllllIllIlIIllIllIlIlIllll.getY() >> 4;
            if (this.doChunkLoad() || (lllllllllllIllIlIIllIllIlIllIIlI & 1 << lllllllllllIllIlIIllIllIlIlIllIl) != 0x0) {
                final NBTTagCompound lllllllllllIllIlIIllIllIlIlIllII = lllllllllllIllIlIIllIllIlIlIlllI.getUpdateTag();
                this.tileEntityTags.add(lllllllllllIllIlIIllIllIlIlIllII);
            }
        }
    }
    
    public boolean doChunkLoad() {
        return this.loadChunk;
    }
    
    private ByteBuf getWriteBuffer() {
        final ByteBuf lllllllllllIllIlIIllIllIIllllIll = Unpooled.wrappedBuffer(this.buffer);
        lllllllllllIllIlIIllIllIIllllIll.writerIndex(0);
        return lllllllllllIllIlIIllIllIIllllIll;
    }
    
    public int extractChunkData(final PacketBuffer lllllllllllIllIlIIllIllIIllIIIll, final Chunk lllllllllllIllIlIIllIllIIllIIIlI, final boolean lllllllllllIllIlIIllIllIIllIlIll, final int lllllllllllIllIlIIllIllIIllIIIII) {
        int lllllllllllIllIlIIllIllIIllIlIIl = 0;
        final ExtendedBlockStorage[] lllllllllllIllIlIIllIllIIllIlIII = lllllllllllIllIlIIllIllIIllIIIlI.getBlockStorageArray();
        for (int lllllllllllIllIlIIllIllIIllIIlll = 0, lllllllllllIllIlIIllIllIIllIIllI = lllllllllllIllIlIIllIllIIllIlIII.length; lllllllllllIllIlIIllIllIIllIIlll < lllllllllllIllIlIIllIllIIllIIllI; ++lllllllllllIllIlIIllIllIIllIIlll) {
            final ExtendedBlockStorage lllllllllllIllIlIIllIllIIllIIlIl = lllllllllllIllIlIIllIllIIllIlIII[lllllllllllIllIlIIllIllIIllIIlll];
            if (lllllllllllIllIlIIllIllIIllIIlIl != Chunk.NULL_BLOCK_STORAGE && (!this.doChunkLoad() || !lllllllllllIllIlIIllIllIIllIIlIl.isEmpty()) && (lllllllllllIllIlIIllIllIIllIIIII & 1 << lllllllllllIllIlIIllIllIIllIIlll) != 0x0) {
                lllllllllllIllIlIIllIllIIllIlIIl |= 1 << lllllllllllIllIlIIllIllIIllIIlll;
                lllllllllllIllIlIIllIllIIllIIlIl.getData().write(lllllllllllIllIlIIllIllIIllIIIll);
                lllllllllllIllIlIIllIllIIllIIIll.writeBytes(lllllllllllIllIlIIllIllIIllIIlIl.getBlocklightArray().getData());
                if (lllllllllllIllIlIIllIllIIllIlIll) {
                    lllllllllllIllIlIIllIllIIllIIIll.writeBytes(lllllllllllIllIlIIllIllIIllIIlIl.getSkylightArray().getData());
                }
            }
        }
        if (this.doChunkLoad()) {
            lllllllllllIllIlIIllIllIIllIIIll.writeBytes(lllllllllllIllIlIIllIllIIllIIIlI.getBiomeArray());
        }
        return lllllllllllIllIlIIllIllIIllIlIIl;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllIlIIllIllIlIIIIIlI) {
        lllllllllllIllIlIIllIllIlIIIIIlI.handleChunkData(this);
    }
    
    public List<NBTTagCompound> getTileEntityTags() {
        return this.tileEntityTags;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIlIIllIllIlIIllIll) throws IOException {
        this.chunkX = lllllllllllIllIlIIllIllIlIIllIll.readInt();
        this.chunkZ = lllllllllllIllIlIIllIllIlIIllIll.readInt();
        this.loadChunk = lllllllllllIllIlIIllIllIlIIllIll.readBoolean();
        this.availableSections = lllllllllllIllIlIIllIllIlIIllIll.readVarIntFromBuffer();
        final int lllllllllllIllIlIIllIllIlIIllIlI = lllllllllllIllIlIIllIllIlIIllIll.readVarIntFromBuffer();
        if (lllllllllllIllIlIIllIllIlIIllIlI > 2097152) {
            throw new RuntimeException("Chunk Packet trying to allocate too much memory on read.");
        }
        this.buffer = new byte[lllllllllllIllIlIIllIllIlIIllIlI];
        lllllllllllIllIlIIllIllIlIIllIll.readBytes(this.buffer);
        final int lllllllllllIllIlIIllIllIlIIllIIl = lllllllllllIllIlIIllIllIlIIllIll.readVarIntFromBuffer();
        this.tileEntityTags = (List<NBTTagCompound>)Lists.newArrayList();
        for (int lllllllllllIllIlIIllIllIlIIllIII = 0; lllllllllllIllIlIIllIllIlIIllIII < lllllllllllIllIlIIllIllIlIIllIIl; ++lllllllllllIllIlIIllIllIlIIllIII) {
            this.tileEntityTags.add(lllllllllllIllIlIIllIllIlIIllIll.readNBTTagCompoundFromBuffer());
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIlIIllIllIlIIIllIl) throws IOException {
        lllllllllllIllIlIIllIllIlIIIllIl.writeInt(this.chunkX);
        lllllllllllIllIlIIllIllIlIIIllIl.writeInt(this.chunkZ);
        lllllllllllIllIlIIllIllIlIIIllIl.writeBoolean(this.loadChunk);
        lllllllllllIllIlIIllIllIlIIIllIl.writeVarIntToBuffer(this.availableSections);
        lllllllllllIllIlIIllIllIlIIIllIl.writeVarIntToBuffer(this.buffer.length);
        lllllllllllIllIlIIllIllIlIIIllIl.writeBytes(this.buffer);
        lllllllllllIllIlIIllIllIlIIIllIl.writeVarIntToBuffer(this.tileEntityTags.size());
        for (final NBTTagCompound lllllllllllIllIlIIllIllIlIIIllII : this.tileEntityTags) {
            lllllllllllIllIlIIllIllIlIIIllIl.writeNBTTagCompoundToBuffer(lllllllllllIllIlIIllIllIlIIIllII);
        }
    }
    
    public int getChunkX() {
        return this.chunkX;
    }
    
    public int getChunkZ() {
        return this.chunkZ;
    }
    
    public int getExtractedSize() {
        return this.availableSections;
    }
    
    protected int calculateChunkSize(final Chunk lllllllllllIllIlIIllIllIIlIlIIII, final boolean lllllllllllIllIlIIllIllIIlIIllll, final int lllllllllllIllIlIIllIllIIlIIlllI) {
        int lllllllllllIllIlIIllIllIIlIIllIl = 0;
        final ExtendedBlockStorage[] lllllllllllIllIlIIllIllIIlIIllII = lllllllllllIllIlIIllIllIIlIlIIII.getBlockStorageArray();
        for (int lllllllllllIllIlIIllIllIIlIIlIll = 0, lllllllllllIllIlIIllIllIIlIIlIlI = lllllllllllIllIlIIllIllIIlIIllII.length; lllllllllllIllIlIIllIllIIlIIlIll < lllllllllllIllIlIIllIllIIlIIlIlI; ++lllllllllllIllIlIIllIllIIlIIlIll) {
            final ExtendedBlockStorage lllllllllllIllIlIIllIllIIlIIlIIl = lllllllllllIllIlIIllIllIIlIIllII[lllllllllllIllIlIIllIllIIlIIlIll];
            if (lllllllllllIllIlIIllIllIIlIIlIIl != Chunk.NULL_BLOCK_STORAGE && (!this.doChunkLoad() || !lllllllllllIllIlIIllIllIIlIIlIIl.isEmpty()) && (lllllllllllIllIlIIllIllIIlIIlllI & 1 << lllllllllllIllIlIIllIllIIlIIlIll) != 0x0) {
                lllllllllllIllIlIIllIllIIlIIllIl += lllllllllllIllIlIIllIllIIlIIlIIl.getData().getSerializedSize();
                lllllllllllIllIlIIllIllIIlIIllIl += lllllllllllIllIlIIllIllIIlIIlIIl.getBlocklightArray().getData().length;
                if (lllllllllllIllIlIIllIllIIlIIllll) {
                    lllllllllllIllIlIIllIllIIlIIllIl += lllllllllllIllIlIIllIllIIlIIlIIl.getSkylightArray().getData().length;
                }
            }
        }
        if (this.doChunkLoad()) {
            lllllllllllIllIlIIllIllIIlIIllIl += lllllllllllIllIlIIllIllIIlIlIIII.getBiomeArray().length;
        }
        return lllllllllllIllIlIIllIllIIlIIllIl;
    }
    
    public SPacketChunkData() {
    }
}
