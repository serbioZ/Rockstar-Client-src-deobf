// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

public class NBTTagLong extends NBTPrimitive
{
    private /* synthetic */ long data;
    
    @Override
    public String toString() {
        return String.valueOf(this.data) + "L";
    }
    
    @Override
    public boolean equals(final Object llllllllllIllllIIIlllllllIllIIII) {
        return super.equals(llllllllllIllllIIIlllllllIllIIII) && this.data == ((NBTTagLong)llllllllllIllllIIIlllllllIllIIII).data;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public double getDouble() {
        return (double)this.data;
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    void write(final DataOutput llllllllllIllllIIIllllllllIIIlll) throws IOException {
        llllllllllIllllIIIllllllllIIIlll.writeLong(this.data);
    }
    
    @Override
    public int getInt() {
        return (int)(this.data & -1L);
    }
    
    public NBTTagLong(final long llllllllllIllllIIIllllllllIIlIll) {
        this.data = llllllllllIllllIIIllllllllIIlIll;
    }
    
    @Override
    public NBTTagLong copy() {
        return new NBTTagLong(this.data);
    }
    
    @Override
    void read(final DataInput llllllllllIllllIIIllllllllIIIIII, final int llllllllllIllllIIIlllllllIllllll, final NBTSizeTracker llllllllllIllllIIIlllllllIlllIll) throws IOException {
        llllllllllIllllIIIlllllllIlllIll.read(128L);
        this.data = llllllllllIllllIIIllllllllIIIIII.readLong();
    }
    
    @Override
    public byte getId() {
        return 4;
    }
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFFL);
    }
    
    NBTTagLong() {
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFFL);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this.data ^ this.data >>> 32);
    }
}
