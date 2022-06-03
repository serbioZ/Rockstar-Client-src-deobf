// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;

public class NBTTagShort extends NBTPrimitive
{
    private /* synthetic */ short data;
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    public NBTTagShort(final short llllllllllIlllIllIIllIlllIIlIlIl) {
        this.data = llllllllllIlllIllIIllIlllIIlIlIl;
    }
    
    public NBTTagShort() {
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    void read(final DataInput llllllllllIlllIllIIllIlllIIIlIlI, final int llllllllllIlllIllIIllIlllIIIlIIl, final NBTSizeTracker llllllllllIlllIllIIllIlllIIIlIII) throws IOException {
        llllllllllIlllIllIIllIlllIIIlIII.read(80L);
        this.data = llllllllllIlllIllIIllIlllIIIlIlI.readShort();
    }
    
    @Override
    public byte getId() {
        return 2;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public NBTTagShort copy() {
        return new NBTTagShort(this.data);
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    @Override
    public boolean equals(final Object llllllllllIlllIllIIllIllIllllIII) {
        return super.equals(llllllllllIlllIllIIllIllIllllIII) && this.data == ((NBTTagShort)llllllllllIlllIllIIllIllIllllIII).data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data) + "s";
    }
    
    @Override
    void write(final DataOutput llllllllllIlllIllIIllIlllIIIllll) throws IOException {
        llllllllllIlllIllIIllIlllIIIllll.writeShort(this.data);
    }
}
