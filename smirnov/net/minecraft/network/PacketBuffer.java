// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import java.io.DataOutput;
import io.netty.buffer.ByteBufOutputStream;
import java.io.DataInput;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTSizeTracker;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufAllocator;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import java.nio.channels.ScatteringByteChannel;
import io.netty.handler.codec.EncoderException;
import net.minecraft.util.text.ITextComponent;
import java.util.Date;
import net.minecraft.util.math.BlockPos;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.ByteOrder;
import java.io.OutputStream;
import java.nio.channels.GatheringByteChannel;
import io.netty.handler.codec.DecoderException;
import java.util.UUID;
import io.netty.util.ByteProcessor;
import net.minecraft.nbt.NBTTagCompound;
import io.netty.util.ReferenceCounted;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.io.IOException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.nio.ByteBuffer;
import io.netty.buffer.ByteBuf;

public class PacketBuffer extends ByteBuf
{
    private final /* synthetic */ ByteBuf buf;
    
    public ByteBuf writeBytes(final ByteBuffer llllllllllllIllllIIlIIIIIllllIlI) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIIllllIlI);
    }
    
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }
    
    public int getUnsignedShortLE(final int llllllllllllIllllIIlIIllIllIIlll) {
        return this.buf.getUnsignedShortLE(llllllllllllIllllIIlIIllIllIIlll);
    }
    
    public long readUnsignedIntLE() {
        return this.buf.readUnsignedIntLE();
    }
    
    public ItemStack readItemStackFromBuffer() throws IOException {
        final int llllllllllllIllllIIlIlIIIIllllII = this.readShort();
        if (llllllllllllIllllIIlIlIIIIllllII < 0) {
            return ItemStack.field_190927_a;
        }
        final int llllllllllllIllllIIlIlIIIIlllIll = this.readByte();
        final int llllllllllllIllllIIlIlIIIIlllIlI = this.readShort();
        final ItemStack llllllllllllIllllIIlIlIIIIlllIIl = new ItemStack(Item.getItemById(llllllllllllIllllIIlIlIIIIllllII), llllllllllllIllllIIlIlIIIIlllIll, llllllllllllIllllIIlIlIIIIlllIlI);
        llllllllllllIllllIIlIlIIIIlllIIl.setTagCompound(this.readNBTTagCompoundFromBuffer());
        return llllllllllllIllllIIlIlIIIIlllIIl;
    }
    
    public byte[] array() {
        return this.buf.array();
    }
    
    public int writeBytes(final FileChannel llllllllllllIllllIIlIIIIIllIIIlI, final long llllllllllllIllllIIlIIIIIlIlllIl, final int llllllllllllIllllIIlIIIIIlIlllII) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIIllIIIlI, llllllllllllIllllIIlIIIIIlIlllIl, llllllllllllIllllIIlIIIIIlIlllII);
    }
    
    public ByteBuf setShortLE(final int llllllllllllIllllIIlIIlIIlllllll, final int llllllllllllIllllIIlIIlIIllllIll) {
        return this.buf.setShortLE(llllllllllllIllllIIlIIlIIlllllll, llllllllllllIllllIIlIIlIIllllIll);
    }
    
    public ByteBuf retain() {
        return this.buf.retain();
    }
    
    public int writeBytes(final InputStream llllllllllllIllllIIlIIIIIlllIIlI, final int llllllllllllIllllIIlIIIIIlllIlII) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIIlllIIlI, llllllllllllIllllIIlIIIIIlllIlII);
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIlIlllIIIll, final byte[] llllllllllllIllllIIlIIlIlllIIIlI, final int llllllllllllIllllIIlIIlIllIlllII, final int llllllllllllIllllIIlIIlIllIllIll) {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIlllIIIll, llllllllllllIllllIIlIIlIlllIIIlI, llllllllllllIllllIIlIIlIllIlllII, llllllllllllIllllIIlIIlIllIllIll);
    }
    
    public int refCnt() {
        return this.buf.refCnt();
    }
    
    public ByteBuf markReaderIndex() {
        return this.buf.markReaderIndex();
    }
    
    public ByteBuf writerIndex(final int llllllllllllIllllIIlIIllllIllIIl) {
        return this.buf.writerIndex(llllllllllllIllllIIlIIllllIllIIl);
    }
    
    public int getMediumLE(final int llllllllllllIllllIIlIIllIlIllIll) {
        return this.buf.getMediumLE(llllllllllllIllllIIlIIllIlIllIll);
    }
    
    public int bytesBefore(final byte llllllllllllIllllIIlIIIIIIlllIll) {
        return this.buf.bytesBefore(llllllllllllIllllIIlIIIIIIlllIll);
    }
    
    public ByteBuf writeChar(final int llllllllllllIllllIIlIIIIlIlllIIl) {
        return this.buf.writeChar(llllllllllllIllllIIlIIIIlIlllIIl);
    }
    
    public PacketBuffer writeVarIntToBuffer(int llllllllllllIllllIIlIlIIIllIIlll) {
        while ((llllllllllllIllllIIlIlIIIllIIlll & 0xFFFFFF80) != 0x0) {
            this.writeByte((llllllllllllIllllIIlIlIIIllIIlll & 0x7F) | 0x80);
            llllllllllllIllllIIlIlIIIllIIlll >>>= 7;
        }
        this.writeByte(llllllllllllIllllIIlIlIIIllIIlll);
        return this;
    }
    
    public ByteBuf touch(final Object llllllllllllIllllIIIllllIllIllll) {
        return this.buf.touch(llllllllllllIllllIIIllllIllIllll);
    }
    
    public PacketBuffer writeItemStackToBuffer(final ItemStack llllllllllllIllllIIlIlIIIlIIIlII) {
        if (llllllllllllIllllIIlIlIIIlIIIlII.func_190926_b()) {
            this.writeShort(-1);
        }
        else {
            this.writeShort(Item.getIdFromItem(llllllllllllIllllIIlIlIIIlIIIlII.getItem()));
            this.writeByte(llllllllllllIllllIIlIlIIIlIIIlII.func_190916_E());
            this.writeShort(llllllllllllIllllIIlIlIIIlIIIlII.getMetadata());
            NBTTagCompound llllllllllllIllllIIlIlIIIlIIIllI = null;
            if (llllllllllllIllllIIlIlIIIlIIIlII.getItem().isDamageable() || llllllllllllIllllIIlIlIIIlIIIlII.getItem().getShareTag()) {
                llllllllllllIllllIIlIlIIIlIIIllI = llllllllllllIllllIIlIlIIIlIIIlII.getTagCompound();
            }
            this.writeNBTTagCompoundToBuffer(llllllllllllIllllIIlIlIIIlIIIllI);
        }
        return this;
    }
    
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }
    
    public int forEachByteDesc(final ByteProcessor llllllllllllIllllIIlIIIIIIIlIIII) {
        return this.buf.forEachByteDesc(llllllllllllIllllIIlIIIIIIIlIIII);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllIIlIIIlIlIIIllI, final int llllllllllllIllllIIlIIIlIlIIIIIl, final int llllllllllllIllllIIlIIIlIlIIIlII) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIlIIIllI, llllllllllllIllllIIlIIIlIlIIIIIl, llllllllllllIllllIIlIIIlIlIIIlII);
    }
    
    public byte[] readByteArray() {
        return this.readByteArray(this.readableBytes());
    }
    
    public int hashCode() {
        return this.buf.hashCode();
    }
    
    public PacketBuffer writeUuid(final UUID llllllllllllIllllIIlIlIIIlllIIII) {
        this.writeLong(llllllllllllIllllIIlIlIIIlllIIII.getMostSignificantBits());
        this.writeLong(llllllllllllIllllIIlIlIIIlllIIII.getLeastSignificantBits());
        return this;
    }
    
    public UUID readUuid() {
        return new UUID(this.readLong(), this.readLong());
    }
    
    public byte[] readByteArray(final int llllllllllllIllllIIlIlIIllllIIll) {
        final int llllllllllllIllllIIlIlIIllllIllI = this.readVarIntFromBuffer();
        if (llllllllllllIllllIIlIlIIllllIllI > llllllllllllIllllIIlIlIIllllIIll) {
            throw new DecoderException("ByteArray with size " + llllllllllllIllllIIlIlIIllllIllI + " is bigger than allowed " + llllllllllllIllllIIlIlIIllllIIll);
        }
        final byte[] llllllllllllIllllIIlIlIIllllIlIl = new byte[llllllllllllIllllIIlIlIIllllIllI];
        this.readBytes(llllllllllllIllllIIlIlIIllllIlIl);
        return llllllllllllIllllIIlIlIIllllIlIl;
    }
    
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }
    
    public int getBytes(final int llllllllllllIllllIIlIIlIlIllllII, final GatheringByteChannel llllllllllllIllllIIlIIlIlIllllll, final int llllllllllllIllllIIlIIlIlIlllllI) throws IOException {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIlIllllII, llllllllllllIllllIIlIIlIlIllllll, llllllllllllIllllIIlIIlIlIlllllI);
    }
    
    public PacketBuffer writeEnumValue(final Enum<?> llllllllllllIllllIIlIlIIlIIlIIII) {
        return this.writeVarIntToBuffer(llllllllllllIllllIIlIlIIlIIlIIII.ordinal());
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIlIllIlIllI, final ByteBuffer llllllllllllIllllIIlIIlIllIlIIlI) {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIllIlIllI, llllllllllllIllllIIlIIlIllIlIIlI);
    }
    
    public ByteBuf writeFloat(final float llllllllllllIllllIIlIIIIlIllIlIl) {
        return this.buf.writeFloat(llllllllllllIllllIIlIIIIlIllIlIl);
    }
    
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }
    
    public ByteBuf resetWriterIndex() {
        return this.buf.resetWriterIndex();
    }
    
    public ByteBuf writeIntLE(final int llllllllllllIllllIIlIIIIllIIllIl) {
        return this.buf.writeIntLE(llllllllllllIllllIIlIIIIllIIllIl);
    }
    
    public ByteBuf setDouble(final int llllllllllllIllllIIlIIlIIIlIlllI, final double llllllllllllIllllIIlIIlIIIlIlIlI) {
        return this.buf.setDouble(llllllllllllIllllIIlIIlIIIlIlllI, llllllllllllIllllIIlIIlIIIlIlIlI);
    }
    
    public short getShort(final int llllllllllllIllllIIlIIllIlllIlll) {
        return this.buf.getShort(llllllllllllIllllIIlIIllIlllIlll);
    }
    
    public ByteBuf copy() {
        return this.buf.copy();
    }
    
    public ByteBuf writeMedium(final int llllllllllllIllllIIlIIIIllIlllIl) {
        return this.buf.writeMedium(llllllllllllIllllIIlIIIIllIlllIl);
    }
    
    public ByteBuf readSlice(final int llllllllllllIllllIIlIIIlIllIIIIl) {
        return this.buf.readSlice(llllllllllllIllllIIlIIIlIllIIIIl);
    }
    
    public ByteBuf markWriterIndex() {
        return this.buf.markWriterIndex();
    }
    
    public ByteBuf setChar(final int llllllllllllIllllIIlIIlIIIllllIl, final int llllllllllllIllllIIlIIlIIIllllII) {
        return this.buf.setChar(llllllllllllIllllIIlIIlIIIllllIl, llllllllllllIllllIIlIIlIIIllllII);
    }
    
    public int readUnsignedShortLE() {
        return this.buf.readUnsignedShortLE();
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIlIllIIllII, final OutputStream llllllllllllIllllIIlIIlIllIIIlll, final int llllllllllllIllllIIlIIlIllIIIllI) throws IOException {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIllIIllII, llllllllllllIllllIIlIIlIllIIIlll, llllllllllllIllllIIlIIlIllIIIllI);
    }
    
    public int ensureWritable(final int llllllllllllIllllIIlIIlllIIlIIll, final boolean llllllllllllIllllIIlIIlllIIlIIlI) {
        return this.buf.ensureWritable(llllllllllllIllllIIlIIlllIIlIIll, llllllllllllIllllIIlIIlllIIlIIlI);
    }
    
    public boolean equals(final Object llllllllllllIllllIIIlllllIIIlIlI) {
        return this.buf.equals(llllllllllllIllllIIIlllllIIIlIlI);
    }
    
    public double getDouble(final int llllllllllllIllllIIlIIllIIIllIIl) {
        return this.buf.getDouble(llllllllllllIllllIIlIIllIIIllIIl);
    }
    
    public ByteBuf writeMediumLE(final int llllllllllllIllllIIlIIIIllIlIlll) {
        return this.buf.writeMediumLE(llllllllllllIllllIIlIIIIllIlIlll);
    }
    
    public boolean release(final int llllllllllllIllllIIIllllIllIIIll) {
        return this.buf.release(llllllllllllIllllIIIllllIllIIIll);
    }
    
    public int getUnsignedMediumLE(final int llllllllllllIllllIIlIIllIlIIllIl) {
        return this.buf.getUnsignedMediumLE(llllllllllllIllllIIlIIllIlIIllIl);
    }
    
    public boolean isReadable(final int llllllllllllIllllIIlIIlllIlllllI) {
        return this.buf.isReadable(llllllllllllIllllIIlIIlllIlllllI);
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllIllllIIlIIIlIIllIIII, final int llllllllllllIllllIIlIIIlIIlIllll, final int llllllllllllIllllIIlIIIlIIlIlllI) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIllIIII, llllllllllllIllllIIlIIIlIIlIllll, llllllllllllIllllIIlIIIlIIlIlllI);
    }
    
    public long getUnsignedIntLE(final int llllllllllllIllllIIlIIllIIllIlll) {
        return this.buf.getUnsignedIntLE(llllllllllllIllllIIlIIllIIllIlll);
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIIlllllIIIl, final byte[] llllllllllllIllllIIlIIIlllllIlIl, final int llllllllllllIllllIIlIIIllllIllll, final int llllllllllllIllllIIlIIIllllIlllI) {
        return this.buf.setBytes(llllllllllllIllllIIlIIIlllllIIIl, llllllllllllIllllIIlIIIlllllIlIl, llllllllllllIllllIIlIIIllllIllll, llllllllllllIllllIIlIIIllllIlllI);
    }
    
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }
    
    public ByteBuf order(final ByteOrder llllllllllllIllllIIlIIllllllIlll) {
        return this.buf.order(llllllllllllIllllIIlIIllllllIlll);
    }
    
    public int getInt(final int llllllllllllIllllIIlIIllIlIIIlll) {
        return this.buf.getInt(llllllllllllIllllIIlIIllIlIIIlll);
    }
    
    public int[] readVarIntArray(final int llllllllllllIllllIIlIlIIllIlIIll) {
        final int llllllllllllIllllIIlIlIIllIlIlll = this.readVarIntFromBuffer();
        if (llllllllllllIllllIIlIlIIllIlIlll > llllllllllllIllllIIlIlIIllIlIIll) {
            throw new DecoderException("VarIntArray with size " + llllllllllllIllllIIlIlIIllIlIlll + " is bigger than allowed " + llllllllllllIllllIIlIlIIllIlIIll);
        }
        final int[] llllllllllllIllllIIlIlIIllIlIllI = new int[llllllllllllIllllIIlIlIIllIlIlll];
        for (int llllllllllllIllllIIlIlIIllIlIlIl = 0; llllllllllllIllllIIlIlIIllIlIlIl < llllllllllllIllllIIlIlIIllIlIllI.length; ++llllllllllllIllllIIlIlIIllIlIlIl) {
            llllllllllllIllllIIlIlIIllIlIllI[llllllllllllIllllIIlIlIIllIlIlIl] = this.readVarIntFromBuffer();
        }
        return llllllllllllIllllIIlIlIIllIlIllI;
    }
    
    public int getUnsignedMedium(final int llllllllllllIllllIIlIIllIlIlIlIl) {
        return this.buf.getUnsignedMedium(llllllllllllIllllIIlIIllIlIlIlIl);
    }
    
    public ByteBuf writeByte(final int llllllllllllIllllIIlIIIIlllIllll) {
        return this.buf.writeByte(llllllllllllIllllIIlIIIIlllIllll);
    }
    
    public ByteBuf setZero(final int llllllllllllIllllIIlIIIllIllIllI, final int llllllllllllIllllIIlIIIllIlllIII) {
        return this.buf.setZero(llllllllllllIllllIIlIIIllIllIllI, llllllllllllIllllIIlIIIllIlllIII);
    }
    
    public ByteBuf writeZero(final int llllllllllllIllllIIlIIIIIlIlIllI) {
        return this.buf.writeZero(llllllllllllIllllIIlIIIIIlIlIllI);
    }
    
    public ByteBuf setInt(final int llllllllllllIllllIIlIIlIIllIIlII, final int llllllllllllIllllIIlIIlIIllIIIll) {
        return this.buf.setInt(llllllllllllIllllIIlIIlIIllIIlII, llllllllllllIllllIIlIIlIIllIIIll);
    }
    
    public ByteBuf clear() {
        return this.buf.clear();
    }
    
    public int readIntLE() {
        return this.buf.readIntLE();
    }
    
    public int getIntLE(final int llllllllllllIllllIIlIIllIlIIIIll) {
        return this.buf.getIntLE(llllllllllllIllllIIlIIllIlIIIIll);
    }
    
    public int capacity() {
        return this.buf.capacity();
    }
    
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }
    
    public int readMedium() {
        return this.buf.readMedium();
    }
    
    public int readBytes(final GatheringByteChannel llllllllllllIllllIIlIIIlIIIlIlll, final int llllllllllllIllllIIlIIIlIIIlIllI) throws IOException {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIIlIlll, llllllllllllIllllIIlIIIlIIIlIllI);
    }
    
    public PacketBuffer writeLongArray(final long[] llllllllllllIllllIIlIlIIllIIIlIl) {
        this.writeVarIntToBuffer(llllllllllllIllllIIlIlIIllIIIlIl.length);
        final float llllllllllllIllllIIlIlIIllIIIIIl = (Object)llllllllllllIllllIIlIlIIllIIIlIl;
        for (Exception llllllllllllIllllIIlIlIIllIIIIlI = (Exception)llllllllllllIllllIIlIlIIllIIIlIl.length, llllllllllllIllllIIlIlIIllIIIIll = (Exception)0; llllllllllllIllllIIlIlIIllIIIIll < llllllllllllIllllIIlIlIIllIIIIlI; ++llllllllllllIllllIIlIlIIllIIIIll) {
            final long llllllllllllIllllIIlIlIIllIIIlll = llllllllllllIllllIIlIlIIllIIIIIl[llllllllllllIllllIIlIlIIllIIIIll];
            this.writeLong(llllllllllllIllllIIlIlIIllIIIlll);
        }
        return this;
    }
    
    public String toString(final Charset llllllllllllIllllIIIlllllIIlllll) {
        return this.buf.toString(llllllllllllIllllIIIlllllIIlllll);
    }
    
    public int forEachByte(final ByteProcessor llllllllllllIllllIIlIIIIIIlIIIII) {
        return this.buf.forEachByte(llllllllllllIllllIIlIIIIIIlIIIII);
    }
    
    public int getUnsignedShort(final int llllllllllllIllllIIlIIllIllIlIll) {
        return this.buf.getUnsignedShort(llllllllllllIllllIIlIIllIllIlIll);
    }
    
    public String readStringFromBuffer(final int llllllllllllIllllIIlIlIIIIlIlllI) {
        final int llllllllllllIllllIIlIlIIIIlIllIl = this.readVarIntFromBuffer();
        if (llllllllllllIllllIIlIlIIIIlIllIl > llllllllllllIllllIIlIlIIIIlIlllI * 4) {
            throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + llllllllllllIllllIIlIlIIIIlIllIl + " > " + llllllllllllIllllIIlIlIIIIlIlllI * 4 + ")");
        }
        if (llllllllllllIllllIIlIlIIIIlIllIl < 0) {
            throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        }
        final String llllllllllllIllllIIlIlIIIIlIllII = this.toString(this.readerIndex(), llllllllllllIllllIIlIlIIIIlIllIl, StandardCharsets.UTF_8);
        this.readerIndex(this.readerIndex() + llllllllllllIllllIIlIlIIIIlIllIl);
        if (llllllllllllIllllIIlIlIIIIlIllII.length() > llllllllllllIllllIIlIlIIIIlIlllI) {
            throw new DecoderException("The received string length is longer than maximum allowed (" + llllllllllllIllllIIlIlIIIIlIllIl + " > " + llllllllllllIllllIIlIlIIIIlIlllI + ")");
        }
        return llllllllllllIllllIIlIlIIIIlIllII;
    }
    
    public ByteBuf setMediumLE(final int llllllllllllIllllIIlIIlIIllIllIl, final int llllllllllllIllllIIlIIlIIllIllII) {
        return this.buf.setMediumLE(llllllllllllIllllIIlIIlIIllIllIl, llllllllllllIllllIIlIIlIIllIllII);
    }
    
    public float readFloat() {
        return this.buf.readFloat();
    }
    
    public ByteBuffer nioBuffer(final int llllllllllllIllllIIIllllllIIlIlI, final int llllllllllllIllllIIIllllllIIlIIl) {
        return this.buf.nioBuffer(llllllllllllIllllIIIllllllIIlIlI, llllllllllllIllllIIIllllllIIlIIl);
    }
    
    public ByteBuf readerIndex(final int llllllllllllIllllIIlIIlllllIIIlI) {
        return this.buf.readerIndex(llllllllllllIllllIIlIIlllllIIIlI);
    }
    
    public short getUnsignedByte(final int llllllllllllIllllIIlIIllIlllllIl) {
        return this.buf.getUnsignedByte(llllllllllllIllllIIlIIllIlllllIl);
    }
    
    public BlockPos readBlockPos() {
        return BlockPos.fromLong(this.readLong());
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIIllllIlIIl, final ByteBuffer llllllllllllIllllIIlIIIllllIIlIl) {
        return this.buf.setBytes(llllllllllllIllllIIlIIIllllIlIIl, llllllllllllIllllIIlIIIllllIIlIl);
    }
    
    public PacketBuffer func_192574_a(final Date llllllllllllIllllIIlIlIIIIIIllIl) {
        this.writeLong(llllllllllllIllllIIlIlIIIIIIllIl.getTime());
        return this;
    }
    
    public ByteBuf setMedium(final int llllllllllllIllllIIlIIlIIlllIIll, final int llllllllllllIllllIIlIIlIIlllIlIl) {
        return this.buf.setMedium(llllllllllllIllllIIlIIlIIlllIIll, llllllllllllIllllIIlIIlIIlllIlIl);
    }
    
    public static int getVarIntSize(final int llllllllllllIllllIIlIlIlIIIIIlll) {
        for (int llllllllllllIllllIIlIlIlIIIIlIII = 1; llllllllllllIllllIIlIlIlIIIIlIII < 5; ++llllllllllllIllllIIlIlIlIIIIlIII) {
            if ((llllllllllllIllllIIlIlIlIIIIIlll & -1 << llllllllllllIllllIIlIlIlIIIIlIII * 7) == 0x0) {
                return llllllllllllIllllIIlIlIlIIIIlIII;
            }
        }
        return 5;
    }
    
    public byte getByte(final int llllllllllllIllllIIlIIlllIIIIlIl) {
        return this.buf.getByte(llllllllllllIllllIIlIIlllIIIIlIl);
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIllIIIIllll, final ByteBuf llllllllllllIllllIIlIIllIIIlIIIl) {
        return this.buf.getBytes(llllllllllllIllllIIlIIllIIIIllll, llllllllllllIllllIIlIIllIIIlIIIl);
    }
    
    public PacketBuffer writeTextComponent(final ITextComponent llllllllllllIllllIIlIlIIlIIlllII) {
        return this.writeString(ITextComponent.Serializer.componentToJson(llllllllllllIllllIIlIlIIlIIlllII));
    }
    
    public int writerIndex() {
        return this.buf.writerIndex();
    }
    
    public boolean getBoolean(final int llllllllllllIllllIIlIIlllIIIlIll) {
        return this.buf.getBoolean(llllllllllllIllllIIlIIlllIIIlIll);
    }
    
    public PacketBuffer writeString(final String llllllllllllIllllIIlIlIIIIlIIIII) {
        final byte[] llllllllllllIllllIIlIlIIIIlIIIlI = llllllllllllIllllIIlIlIIIIlIIIII.getBytes(StandardCharsets.UTF_8);
        if (llllllllllllIllllIIlIlIIIIlIIIlI.length > 32767) {
            throw new EncoderException("String too big (was " + llllllllllllIllllIIlIlIIIIlIIIlI.length + " bytes encoded, max " + 32767 + ")");
        }
        this.writeVarIntToBuffer(llllllllllllIllllIIlIlIIIIlIIIlI.length);
        this.writeBytes(llllllllllllIllllIIlIlIIIIlIIIlI);
        return this;
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllIIlIIIIlIlIIlll) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIlIlIIlll);
    }
    
    public int writeBytes(final ScatteringByteChannel llllllllllllIllllIIlIIIIIllIllII, final int llllllllllllIllllIIlIIIIIllIlIll) throws IOException {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIIllIllII, llllllllllllIllllIIlIIIIIllIlIll);
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIlIlllIlllI, final byte[] llllllllllllIllllIIlIIlIlllIlIlI) {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIlllIlllI, llllllllllllIllllIIlIIlIlllIlIlI);
    }
    
    public PacketBuffer func_192572_a(final ResourceLocation llllllllllllIllllIIlIlIIIIIlIllI) {
        this.writeString(llllllllllllIllllIIlIlIIIIIlIllI.toString());
        return this;
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllIllllIIlIIIIlIIIIllI, final int llllllllllllIllllIIlIIIIlIIIIlIl, final int llllllllllllIllllIIlIIIIlIIIIlII) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIlIIIIllI, llllllllllllIllllIIlIIIIlIIIIlIl, llllllllllllIllllIIlIIIIlIIIIlII);
    }
    
    public long[] readLongArray(@Nullable final long[] llllllllllllIllllIIlIlIIlIlllIll) {
        return this.readLongArray(llllllllllllIllllIIlIlIIlIlllIll, this.readableBytes() / 8);
    }
    
    public long getLong(final int llllllllllllIllllIIlIIllIIllIIIl) {
        return this.buf.getLong(llllllllllllIllllIIlIIllIIllIIIl);
    }
    
    public ByteBuf touch() {
        return this.buf.touch();
    }
    
    public PacketBuffer writeByteArray(final byte[] llllllllllllIllllIIlIlIlIIIIIIII) {
        this.writeVarIntToBuffer(llllllllllllIllllIIlIlIlIIIIIIII.length);
        this.writeBytes(llllllllllllIllllIIlIlIlIIIIIIII);
        return this;
    }
    
    public byte readByte() {
        return this.buf.readByte();
    }
    
    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }
    
    public ByteBuf unwrap() {
        return this.buf.unwrap();
    }
    
    public ByteBuf copy(final int llllllllllllIllllIIIllllllllIlll, final int llllllllllllIllllIIIllllllllIllI) {
        return this.buf.copy(llllllllllllIllllIIIllllllllIlll, llllllllllllIllllIIIllllllllIllI);
    }
    
    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }
    
    public int readMediumLE() {
        return this.buf.readMediumLE();
    }
    
    public ByteBuf capacity(final int llllllllllllIllllIIlIlIIIIIIIllI) {
        return this.buf.capacity(llllllllllllIllllIIlIlIIIIIIIllI);
    }
    
    public ByteBuf slice(final int llllllllllllIllllIIIlllllllIlIII, final int llllllllllllIllllIIIlllllllIIlll) {
        return this.buf.slice(llllllllllllIllllIIIlllllllIlIII, llllllllllllIllllIIIlllllllIIlll);
    }
    
    public ByteBuffer[] nioBuffers(final int llllllllllllIllllIIIlllllIlllIII, final int llllllllllllIllllIIIlllllIllIlII) {
        return this.buf.nioBuffers(llllllllllllIllllIIIlllllIlllIII, llllllllllllIllllIIIlllllIllIlII);
    }
    
    public ByteBuf writeDouble(final double llllllllllllIllllIIlIIIIlIlIllll) {
        return this.buf.writeDouble(llllllllllllIllllIIlIIIIlIlIllll);
    }
    
    public ByteBuf readBytes(final OutputStream llllllllllllIllllIIlIIIlIIlIIIII, final int llllllllllllIllllIIlIIIlIIIlllll) throws IOException {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIlIIIII, llllllllllllIllllIIlIIIlIIIlllll);
    }
    
    public ByteBuf resetReaderIndex() {
        return this.buf.resetReaderIndex();
    }
    
    public boolean isDirect() {
        return this.buf.isDirect();
    }
    
    public int setBytes(final int llllllllllllIllllIIlIIIlllIlIIll, final ScatteringByteChannel llllllllllllIllllIIlIIIlllIIlllI, final int llllllllllllIllllIIlIIIlllIIllIl) throws IOException {
        return this.buf.setBytes(llllllllllllIllllIIlIIIlllIlIIll, llllllllllllIllllIIlIIIlllIIlllI, llllllllllllIllllIIlIIIlllIIllIl);
    }
    
    public ByteBuf readRetainedSlice(final int llllllllllllIllllIIlIIIlIlIllIll) {
        return this.buf.readRetainedSlice(llllllllllllIllllIIlIIIlIlIllIll);
    }
    
    public PacketBuffer writeVarLong(long llllllllllllIllllIIlIlIIIllIIIIl) {
        while ((llllllllllllIllllIIlIlIIIllIIIIl & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
            this.writeByte((int)(llllllllllllIllllIIlIlIIIllIIIIl & 0x7FL) | 0x80);
            llllllllllllIllllIIlIlIIIllIIIIl >>>= 7;
        }
        this.writeByte((int)llllllllllllIllllIIlIlIIIllIIIIl);
        return this;
    }
    
    public ByteBuf setBoolean(final int llllllllllllIllllIIlIIlIlIIllIlI, final boolean llllllllllllIllllIIlIIlIlIIlIllI) {
        return this.buf.setBoolean(llllllllllllIllllIIlIIlIlIIllIlI, llllllllllllIllllIIlIIlIlIIlIllI);
    }
    
    public ByteOrder order() {
        return this.buf.order();
    }
    
    public float getFloat(final int llllllllllllIllllIIlIIllIIIlllll) {
        return this.buf.getFloat(llllllllllllIllllIIlIIllIIIlllll);
    }
    
    public ByteBuf writeBytes(final byte[] llllllllllllIllllIIlIIIIlIIIllII) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIlIIIllII);
    }
    
    public long readLongLE() {
        return this.buf.readLongLE();
    }
    
    public ByteBuf writeInt(final int llllllllllllIllllIIlIIIIllIlIIIl) {
        return this.buf.writeInt(llllllllllllIllllIIlIIIIllIlIIIl);
    }
    
    public PacketBuffer(final ByteBuf llllllllllllIllllIIlIlIlIIIIlllI) {
        this.buf = llllllllllllIllllIIlIlIlIIIIlllI;
    }
    
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }
    
    public long getLongLE(final int llllllllllllIllllIIlIIllIIlIlIIl) {
        return this.buf.getLongLE(llllllllllllIllllIIlIIllIIlIlIIl);
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIllIIIIIlII, final ByteBuf llllllllllllIllllIIlIIllIIIIIIll, final int llllllllllllIllllIIlIIllIIIIIIlI) {
        return this.buf.getBytes(llllllllllllIllllIIlIIllIIIIIlII, llllllllllllIllllIIlIIllIIIIIIll, llllllllllllIllllIIlIIllIIIIIIlI);
    }
    
    public long getUnsignedInt(final int llllllllllllIllllIIlIIllIIllllIl) {
        return this.buf.getUnsignedInt(llllllllllllIllllIIlIIllIIllllIl);
    }
    
    public ByteBuf retainedSlice(final int llllllllllllIllllIIIllllllIlllll, final int llllllllllllIllllIIIllllllIllllI) {
        return this.buf.retainedSlice(llllllllllllIllllIIIllllllIlllll, llllllllllllIllllIIIllllllIllllI);
    }
    
    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }
    
    public ByteBuf readBytes(final int llllllllllllIllllIIlIIIlIllIlIIl) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIllIlIIl);
    }
    
    public ByteBuf writeLong(final long llllllllllllIllllIIlIIIIllIIIlll) {
        return this.buf.writeLong(llllllllllllIllllIIlIIIIllIIIlll);
    }
    
    public int compareTo(final ByteBuf llllllllllllIllllIIIlllllIIIIllI) {
        return this.buf.compareTo(llllllllllllIllllIIIlllllIIIIllI);
    }
    
    public int readerIndex() {
        return this.buf.readerIndex();
    }
    
    public int readableBytes() {
        return this.buf.readableBytes();
    }
    
    public Date func_192573_m() {
        return new Date(this.readLong());
    }
    
    public int setBytes(final int llllllllllllIllllIIlIIIlllIlllll, final InputStream llllllllllllIllllIIlIIIlllIllIlI, final int llllllllllllIllllIIlIIIlllIllIIl) throws IOException {
        return this.buf.setBytes(llllllllllllIllllIIlIIIlllIlllll, llllllllllllIllllIIlIIIlllIllIlI, llllllllllllIllllIIlIIIlllIllIIl);
    }
    
    public ByteBuf readBytes(final ByteBuffer llllllllllllIllllIIlIIIlIIlIlIII) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIlIlIII);
    }
    
    public ByteBuf discardSomeReadBytes() {
        return this.buf.discardSomeReadBytes();
    }
    
    public int readBytes(final FileChannel llllllllllllIllllIIlIIIlIIIIIlll, final long llllllllllllIllllIIlIIIlIIIIIIlI, final int llllllllllllIllllIIlIIIlIIIIIIIl) throws IOException {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIIIIlll, llllllllllllIllllIIlIIIlIIIIIIlI, llllllllllllIllllIIlIIIlIIIIIIIl);
    }
    
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }
    
    public ByteBuf ensureWritable(final int llllllllllllIllllIIlIIlllIIllIlI) {
        return this.buf.ensureWritable(llllllllllllIllllIIlIIlllIIllIlI);
    }
    
    public int getMedium(final int llllllllllllIllllIIlIIllIlIlllll) {
        return this.buf.getMedium(llllllllllllIllllIIlIIllIlIlllll);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllIIlIIIlIlIlIlll) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIlIlIlll);
    }
    
    public CharSequence readCharSequence(final int llllllllllllIllllIIlIIIlIIIIlllI, final Charset llllllllllllIllllIIlIIIlIIIIllIl) {
        return this.buf.readCharSequence(llllllllllllIllllIIlIIIlIIIIlllI, llllllllllllIllllIIlIIIlIIIIllIl);
    }
    
    public long memoryAddress() {
        return this.buf.memoryAddress();
    }
    
    public ByteBuf setByte(final int llllllllllllIllllIIlIIlIlIIIlllI, final int llllllllllllIllllIIlIIlIlIIIllIl) {
        return this.buf.setByte(llllllllllllIllllIIlIIlIlIIIlllI, llllllllllllIllllIIlIIlIlIIIllIl);
    }
    
    public ByteBuf setShort(final int llllllllllllIllllIIlIIlIlIIIlIII, final int llllllllllllIllllIIlIIlIlIIIIlII) {
        return this.buf.setShort(llllllllllllIllllIIlIIlIlIIIlIII, llllllllllllIllllIIlIIlIlIIIIlII);
    }
    
    public ByteBuf retain(final int llllllllllllIllllIIIllllIllllIll) {
        return this.buf.retain(llllllllllllIllllIIIllllIllllIll);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllIIlIIIIlIIlIlII, final int llllllllllllIllllIIlIIIIlIIlIlll, final int llllllllllllIllllIIlIIIIlIIlIIlI) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIlIIlIlII, llllllllllllIllllIIlIIIIlIIlIlll, llllllllllllIllllIIlIIIIlIIlIIlI);
    }
    
    public short getShortLE(final int llllllllllllIllllIIlIIllIlllIIIl) {
        return this.buf.getShortLE(llllllllllllIllllIIlIIllIlllIIIl);
    }
    
    public ByteBuf getBytes(final int llllllllllllIllllIIlIIlIlllllIll, final ByteBuf llllllllllllIllllIIlIIlIlllllIlI, final int llllllllllllIllllIIlIIlIlllllIIl, final int llllllllllllIllllIIlIIlIlllllIII) {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIlllllIll, llllllllllllIllllIIlIIlIlllllIlI, llllllllllllIllllIIlIIlIlllllIIl, llllllllllllIllllIIlIIlIlllllIII);
    }
    
    @Nullable
    public NBTTagCompound readNBTTagCompoundFromBuffer() throws IOException {
        final int llllllllllllIllllIIlIlIIIlIlIIlI = this.readerIndex();
        final byte llllllllllllIllllIIlIlIIIlIlIIIl = this.readByte();
        if (llllllllllllIllllIIlIlIIIlIlIIIl == 0) {
            return null;
        }
        this.readerIndex(llllllllllllIllllIIlIlIIIlIlIIlI);
        try {
            return CompressedStreamTools.read((DataInput)new ByteBufInputStream((ByteBuf)this), new NBTSizeTracker(2097152L));
        }
        catch (IOException llllllllllllIllllIIlIlIIIlIlIIII) {
            throw new EncoderException((Throwable)llllllllllllIllllIIlIlIIIlIlIIII);
        }
    }
    
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }
    
    public int readUnsignedMediumLE() {
        return this.buf.readUnsignedMediumLE();
    }
    
    public String toString() {
        return this.buf.toString();
    }
    
    public ByteBuf writeShortLE(final int llllllllllllIllllIIlIIIIlllIIIll) {
        return this.buf.writeShortLE(llllllllllllIllllIIlIIIIlllIIIll);
    }
    
    public int writableBytes() {
        return this.buf.writableBytes();
    }
    
    public ByteBuf setIndex(final int llllllllllllIllllIIlIIllllIlIIlI, final int llllllllllllIllllIIlIIllllIIlllI) {
        return this.buf.setIndex(llllllllllllIllllIIlIIllllIlIIlI, llllllllllllIllllIIlIIllllIIlllI);
    }
    
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }
    
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice();
    }
    
    public ByteBuf setLong(final int llllllllllllIllllIIlIIlIIlIIllll, final long llllllllllllIllllIIlIIlIIlIlIIIl) {
        return this.buf.setLong(llllllllllllIllllIIlIIlIIlIIllll, llllllllllllIllllIIlIIlIIlIlIIIl);
    }
    
    public short readShortLE() {
        return this.buf.readShortLE();
    }
    
    public PacketBuffer writeBlockPos(final BlockPos llllllllllllIllllIIlIlIIlIlIIIll) {
        this.writeLong(llllllllllllIllllIIlIlIIlIlIIIll.toLong());
        return this;
    }
    
    public ITextComponent readTextComponent() throws IOException {
        return ITextComponent.Serializer.jsonToComponent(this.readStringFromBuffer(32767));
    }
    
    public PacketBuffer writeNBTTagCompoundToBuffer(@Nullable final NBTTagCompound llllllllllllIllllIIlIlIIIlIllIIl) {
        if (llllllllllllIllllIIlIlIIIlIllIIl == null) {
            this.writeByte(0);
        }
        else {
            try {
                CompressedStreamTools.write(llllllllllllIllllIIlIlIIIlIllIIl, (DataOutput)new ByteBufOutputStream((ByteBuf)this));
            }
            catch (IOException llllllllllllIllllIIlIlIIIlIllIll) {
                throw new EncoderException((Throwable)llllllllllllIllllIIlIlIIIlIllIll);
            }
        }
        return this;
    }
    
    public short readShort() {
        return this.buf.readShort();
    }
    
    public int indexOf(final int llllllllllllIllllIIlIIIIIlIIIlll, final int llllllllllllIllllIIlIIIIIlIIIllI, final byte llllllllllllIllllIIlIIIIIlIIIIIl) {
        return this.buf.indexOf(llllllllllllIllllIIlIIIIIlIIIlll, llllllllllllIllllIIlIIIIIlIIIllI, llllllllllllIllllIIlIIIIIlIIIIIl);
    }
    
    public ByteBuf slice() {
        return this.buf.slice();
    }
    
    public <T extends Enum<T>> T readEnumValue(final Class<T> llllllllllllIllllIIlIlIIlIIlIllI) {
        return llllllllllllIllllIIlIlIIlIIlIllI.getEnumConstants()[this.readVarIntFromBuffer()];
    }
    
    public ByteBuf readBytes(final byte[] llllllllllllIllllIIlIIIlIIlllIlI) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIIlllIlI);
    }
    
    public ByteBuf setFloat(final int llllllllllllIllllIIlIIlIIIllIlII, final float llllllllllllIllllIIlIIlIIIllIllI) {
        return this.buf.setFloat(llllllllllllIllllIIlIIlIIIllIlII, llllllllllllIllllIIlIIlIIIllIllI);
    }
    
    public int forEachByteDesc(final int llllllllllllIllllIIlIIIIIIIIlIII, final int llllllllllllIllllIIlIIIIIIIIIlll, final ByteProcessor llllllllllllIllllIIlIIIIIIIIIIlI) {
        return this.buf.forEachByteDesc(llllllllllllIllllIIlIIIIIIIIlIII, llllllllllllIllllIIlIIIIIIIIIlll, llllllllllllIllllIIlIIIIIIIIIIlI);
    }
    
    public int writeCharSequence(final CharSequence llllllllllllIllllIIlIIIIIlIIlllI, final Charset llllllllllllIllllIIlIIIIIlIlIIII) {
        return this.buf.writeCharSequence(llllllllllllIllllIIlIIIIIlIIlllI, llllllllllllIllllIIlIIIIIlIlIIII);
    }
    
    public int readVarIntFromBuffer() {
        int llllllllllllIllllIIlIlIIlIIIlIII = 0;
        int llllllllllllIllllIIlIlIIlIIIIlll = 0;
        byte llllllllllllIllllIIlIlIIlIIIIllI;
        do {
            llllllllllllIllllIIlIlIIlIIIIllI = this.readByte();
            llllllllllllIllllIIlIlIIlIIIlIII |= (llllllllllllIllllIIlIlIIlIIIIllI & 0x7F) << llllllllllllIllllIIlIlIIlIIIIlll++ * 7;
            if (llllllllllllIllllIIlIlIIlIIIIlll > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((llllllllllllIllllIIlIlIIlIIIIllI & 0x80) == 0x80);
        return llllllllllllIllllIIlIlIIlIIIlIII;
    }
    
    public int getBytes(final int llllllllllllIllllIIlIIlIlIlIlllI, final FileChannel llllllllllllIllllIIlIIlIlIlIllIl, final long llllllllllllIllllIIlIIlIlIlIllII, final int llllllllllllIllllIIlIIlIlIllIIII) throws IOException {
        return this.buf.getBytes(llllllllllllIllllIIlIIlIlIlIlllI, llllllllllllIllllIIlIIlIlIlIllIl, llllllllllllIllllIIlIIlIlIlIllII, llllllllllllIllllIIlIIlIlIllIIII);
    }
    
    public int setCharSequence(final int llllllllllllIllllIIlIIIllIlIllll, final CharSequence llllllllllllIllllIIlIIIllIlIlllI, final Charset llllllllllllIllllIIlIIIllIlIllIl) {
        return this.buf.setCharSequence(llllllllllllIllllIIlIIIllIlIllll, llllllllllllIllllIIlIIIllIlIlllI, llllllllllllIllllIIlIIIllIlIllIl);
    }
    
    public ByteBuf discardReadBytes() {
        return this.buf.discardReadBytes();
    }
    
    public int bytesBefore(final int llllllllllllIllllIIlIIIIIIllIllI, final byte llllllllllllIllllIIlIIIIIIllIIlI) {
        return this.buf.bytesBefore(llllllllllllIllllIIlIIIIIIllIllI, llllllllllllIllllIIlIIIIIIllIIlI);
    }
    
    public int maxCapacity() {
        return this.buf.maxCapacity();
    }
    
    public int bytesBefore(final int llllllllllllIllllIIlIIIIIIlIlIII, final int llllllllllllIllllIIlIIIIIIlIlIll, final byte llllllllllllIllllIIlIIIIIIlIIllI) {
        return this.buf.bytesBefore(llllllllllllIllllIIlIIIIIIlIlIII, llllllllllllIllllIIlIIIIIIlIlIll, llllllllllllIllllIIlIIIIIIlIIllI);
    }
    
    public ByteBuf writeBytes(final ByteBuf llllllllllllIllllIIlIIIIlIIlllll, final int llllllllllllIllllIIlIIIIlIIllllI) {
        return this.buf.writeBytes(llllllllllllIllllIIlIIIIlIIlllll, llllllllllllIllllIIlIIIIlIIllllI);
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIlIIIIllIll, final ByteBuf llllllllllllIllllIIlIIlIIIIllIlI, final int llllllllllllIllllIIlIIlIIIIllIIl) {
        return this.buf.setBytes(llllllllllllIllllIIlIIlIIIIllIll, llllllllllllIllllIIlIIlIIIIllIlI, llllllllllllIllllIIlIIlIIIIllIIl);
    }
    
    public boolean isReadable() {
        return this.buf.isReadable();
    }
    
    public long readLong() {
        return this.buf.readLong();
    }
    
    public ByteBuffer internalNioBuffer(final int llllllllllllIllllIIIllllllIIIlII, final int llllllllllllIllllIIIllllllIIIIII) {
        return this.buf.internalNioBuffer(llllllllllllIllllIIIllllllIIIlII, llllllllllllIllllIIIllllllIIIIII);
    }
    
    public int forEachByte(final int llllllllllllIllllIIlIIIIIIIllIlI, final int llllllllllllIllllIIlIIIIIIIllIIl, final ByteProcessor llllllllllllIllllIIlIIIIIIIllIII) {
        return this.buf.forEachByte(llllllllllllIllllIIlIIIIIIIllIlI, llllllllllllIllllIIlIIIIIIIllIIl, llllllllllllIllllIIlIIIIIIIllIII);
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIlIIIIIlIIl, final ByteBuf llllllllllllIllllIIlIIlIIIIIllIl, final int llllllllllllIllllIIlIIlIIIIIIlll, final int llllllllllllIllllIIlIIlIIIIIIllI) {
        return this.buf.setBytes(llllllllllllIllllIIlIIlIIIIIlIIl, llllllllllllIllllIIlIIlIIIIIllIl, llllllllllllIllllIIlIIlIIIIIIlll, llllllllllllIllllIIlIIlIIIIIIllI);
    }
    
    public int setBytes(final int llllllllllllIllllIIlIIIlllIIIIIl, final FileChannel llllllllllllIllllIIlIIIlllIIIIII, final long llllllllllllIllllIIlIIIlllIIIlII, final int llllllllllllIllllIIlIIIllIlllllI) throws IOException {
        return this.buf.setBytes(llllllllllllIllllIIlIIIlllIIIIIl, llllllllllllIllllIIlIIIlllIIIIII, llllllllllllIllllIIlIIIlllIIIlII, llllllllllllIllllIIlIIIllIlllllI);
    }
    
    public long readVarLong() {
        long llllllllllllIllllIIlIlIIIlllllII = 0L;
        int llllllllllllIllllIIlIlIIIllllIll = 0;
        byte llllllllllllIllllIIlIlIIIllllIlI;
        do {
            llllllllllllIllllIIlIlIIIllllIlI = this.readByte();
            llllllllllllIllllIIlIlIIIlllllII |= (long)(llllllllllllIllllIIlIlIIIllllIlI & 0x7F) << llllllllllllIllllIIlIlIIIllllIll++ * 7;
            if (llllllllllllIllllIIlIlIIIllllIll > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((llllllllllllIllllIIlIlIIIllllIlI & 0x80) == 0x80);
        return llllllllllllIllllIIlIlIIIlllllII;
    }
    
    public ByteBuf setLongLE(final int llllllllllllIllllIIlIIlIIlIIIllI, final long llllllllllllIllllIIlIIlIIlIIIlIl) {
        return this.buf.setLongLE(llllllllllllIllllIIlIIlIIlIIIllI, llllllllllllIllllIIlIIlIIlIIIlIl);
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIlIIIlIIlIl, final ByteBuf llllllllllllIllllIIlIIlIIIlIIlII) {
        return this.buf.setBytes(llllllllllllIllllIIlIIlIIIlIIlIl, llllllllllllIllllIIlIIlIIIlIIlII);
    }
    
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate();
    }
    
    public double readDouble() {
        return this.buf.readDouble();
    }
    
    public boolean release() {
        return this.buf.release();
    }
    
    public boolean isWritable() {
        return this.buf.isWritable();
    }
    
    public ResourceLocation func_192575_l() {
        return new ResourceLocation(this.readStringFromBuffer(32767));
    }
    
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }
    
    public ByteBuf setIntLE(final int llllllllllllIllllIIlIIlIIlIllIII, final int llllllllllllIllllIIlIIlIIlIllIlI) {
        return this.buf.setIntLE(llllllllllllIllllIIlIIlIIlIllIII, llllllllllllIllllIIlIIlIIlIllIlI);
    }
    
    public int[] readVarIntArray() {
        return this.readVarIntArray(this.readableBytes());
    }
    
    public boolean isWritable(final int llllllllllllIllllIIlIIlllIllIlIl) {
        return this.buf.isWritable(llllllllllllIllllIIlIIlllIllIlIl);
    }
    
    public String toString(final int llllllllllllIllllIIIlllllIIlIlIl, final int llllllllllllIllllIIIlllllIIlIlII, final Charset llllllllllllIllllIIIlllllIIlIIll) {
        return this.buf.toString(llllllllllllIllllIIIlllllIIlIlIl, llllllllllllIllllIIIlllllIIlIlII, llllllllllllIllllIIIlllllIIlIIll);
    }
    
    public boolean hasArray() {
        return this.buf.hasArray();
    }
    
    public ByteBuf writeLongLE(final long llllllllllllIllllIIlIIIIllIIIIIl) {
        return this.buf.writeLongLE(llllllllllllIllllIIlIIIIllIIIIIl);
    }
    
    public ByteBuf writeBoolean(final boolean llllllllllllIllllIIlIIIIllllIlll) {
        return this.buf.writeBoolean(llllllllllllIllllIIlIIIIllllIlll);
    }
    
    public char readChar() {
        return this.buf.readChar();
    }
    
    public CharSequence getCharSequence(final int llllllllllllIllllIIlIIlIlIlIIIIl, final int llllllllllllIllllIIlIIlIlIlIIlII, final Charset llllllllllllIllllIIlIIlIlIIlllll) {
        return this.buf.getCharSequence(llllllllllllIllllIIlIIlIlIlIIIIl, llllllllllllIllllIIlIIlIlIlIIlII, llllllllllllIllllIIlIIlIlIIlllll);
    }
    
    public ByteBuf skipBytes(final int llllllllllllIllllIIlIIIIllllllIl) {
        return this.buf.skipBytes(llllllllllllIllllIIlIIIIllllllIl);
    }
    
    public ByteBuf asReadOnly() {
        return this.buf.asReadOnly();
    }
    
    public long[] readLongArray(@Nullable long[] llllllllllllIllllIIlIlIIlIlIllll, final int llllllllllllIllllIIlIlIIlIllIIll) {
        final int llllllllllllIllllIIlIlIIlIllIIlI = this.readVarIntFromBuffer();
        if (llllllllllllIllllIIlIlIIlIlIllll == null || llllllllllllIllllIIlIlIIlIlIllll.length != llllllllllllIllllIIlIlIIlIllIIlI) {
            if (llllllllllllIllllIIlIlIIlIllIIlI > llllllllllllIllllIIlIlIIlIllIIll) {
                throw new DecoderException("LongArray with size " + llllllllllllIllllIIlIlIIlIllIIlI + " is bigger than allowed " + llllllllllllIllllIIlIlIIlIllIIll);
            }
            llllllllllllIllllIIlIlIIlIlIllll = new long[llllllllllllIllllIIlIlIIlIllIIlI];
        }
        for (int llllllllllllIllllIIlIlIIlIllIIIl = 0; llllllllllllIllllIIlIlIIlIllIIIl < llllllllllllIllllIIlIlIIlIlIllll.length; ++llllllllllllIllllIIlIlIIlIllIIIl) {
            llllllllllllIllllIIlIlIIlIlIllll[llllllllllllIllllIIlIlIIlIllIIIl] = this.readLong();
        }
        return (long[])llllllllllllIllllIIlIlIIlIlIllll;
    }
    
    public char getChar(final int llllllllllllIllllIIlIIllIIlIIlIl) {
        return this.buf.getChar(llllllllllllIllllIIlIIllIIlIIlIl);
    }
    
    public ByteBuf readBytes(final ByteBuf llllllllllllIllllIIlIIIlIlIIllIl, final int llllllllllllIllllIIlIIIlIlIIllII) {
        return this.buf.readBytes(llllllllllllIllllIIlIIIlIlIIllIl, llllllllllllIllllIIlIIIlIlIIllII);
    }
    
    public ByteBuf writeShort(final int llllllllllllIllllIIlIIIIlllIlIll) {
        return this.buf.writeShort(llllllllllllIllllIIlIIIIlllIlIll);
    }
    
    public ByteBuf setBytes(final int llllllllllllIllllIIlIIlIIIIIIIIl, final byte[] llllllllllllIllllIIlIIlIIIIIIIII) {
        return this.buf.setBytes(llllllllllllIllllIIlIIlIIIIIIIIl, llllllllllllIllllIIlIIlIIIIIIIII);
    }
    
    public int readInt() {
        return this.buf.readInt();
    }
    
    public PacketBuffer writeVarIntArray(final int[] llllllllllllIllllIIlIlIIlllIlIIl) {
        this.writeVarIntToBuffer(llllllllllllIllllIIlIlIIlllIlIIl.length);
        final String llllllllllllIllllIIlIlIIlllIIIlI = (Object)llllllllllllIllllIIlIlIIlllIlIIl;
        final double llllllllllllIllllIIlIlIIlllIIIll = llllllllllllIllllIIlIlIIlllIlIIl.length;
        for (float llllllllllllIllllIIlIlIIlllIIlII = 0; llllllllllllIllllIIlIlIIlllIIlII < llllllllllllIllllIIlIlIIlllIIIll; ++llllllllllllIllllIIlIlIIlllIIlII) {
            final int llllllllllllIllllIIlIlIIlllIlIII = llllllllllllIllllIIlIlIIlllIIIlI[llllllllllllIllllIIlIlIIlllIIlII];
            this.writeVarIntToBuffer(llllllllllllIllllIIlIlIIlllIlIII);
        }
        return this;
    }
}
