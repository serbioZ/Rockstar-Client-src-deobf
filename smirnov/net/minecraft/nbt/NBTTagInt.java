// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

public class NBTTagInt extends NBTPrimitive
{
    private /* synthetic */ int data;
    
    public NBTTagInt(final int lllllllllllIllllllIllllIIIIIlIIl) {
        this.data = lllllllllllIllllllIllllIIIIIlIIl;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIllllllIlllIllllIllII) {
        return super.equals(lllllllllllIllllllIlllIllllIllII) && this.data == ((NBTTagInt)lllllllllllIllllllIlllIllllIllII).data;
    }
    
    @Override
    public NBTTagInt copy() {
        return new NBTTagInt(this.data);
    }
    
    NBTTagInt() {
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFF);
    }
    
    @Override
    void write(final DataOutput lllllllllllIllllllIllllIIIIIIIIl) throws IOException {
        lllllllllllIllllllIllllIIIIIIIIl.writeInt(this.data);
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    void read(final DataInput lllllllllllIllllllIlllIlllllllII, final int lllllllllllIllllllIlllIllllllIll, final NBTSizeTracker lllllllllllIllllllIlllIllllllIlI) throws IOException {
        lllllllllllIllllllIlllIllllllIlI.read(96L);
        this.data = lllllllllllIllllllIlllIlllllllII.readInt();
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
    
    @Override
    public byte getId() {
        return 3;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
}
