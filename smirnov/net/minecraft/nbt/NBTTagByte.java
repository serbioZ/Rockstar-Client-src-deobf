// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

public class NBTTagByte extends NBTPrimitive
{
    private /* synthetic */ byte data;
    
    @Override
    void write(final DataOutput lllllllllllIIllIlIlIlIlllllllIII) throws IOException {
        lllllllllllIIllIlIlIlIlllllllIII.writeByte(this.data);
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public NBTTagByte copy() {
        return new NBTTagByte(this.data);
    }
    
    NBTTagByte() {
    }
    
    public NBTTagByte(final byte lllllllllllIIllIlIlIlIlllllllllI) {
        this.data = lllllllllllIIllIlIlIlIlllllllllI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIllIlIlIlIlllllIIIIl) {
        return super.equals(lllllllllllIIllIlIlIlIlllllIIIIl) && this.data == ((NBTTagByte)lllllllllllIIllIlIlIlIlllllIIIIl).data;
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public byte getByte() {
        return this.data;
    }
    
    @Override
    void read(final DataInput lllllllllllIIllIlIlIlIllllllIIll, final int lllllllllllIIllIlIlIlIllllllIIlI, final NBTSizeTracker lllllllllllIIllIlIlIlIlllllIlllI) throws IOException {
        lllllllllllIIllIlIlIlIlllllIlllI.read(72L);
        this.data = lllllllllllIIllIlIlIlIllllllIIll.readByte();
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data) + "b";
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
    public byte getId() {
        return 1;
    }
}
