// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import net.minecraft.util.math.MathHelper;
import java.io.DataInput;
import java.io.IOException;
import java.io.DataOutput;

public class NBTTagFloat extends NBTPrimitive
{
    private /* synthetic */ float data;
    
    @Override
    public NBTTagFloat copy() {
        return new NBTTagFloat(this.data);
    }
    
    @Override
    void write(final DataOutput lllllllllllIIIIllIIlllIIIllllIIl) throws IOException {
        lllllllllllIIIIllIIlllIIIllllIIl.writeFloat(this.data);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data) + "f";
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }
    
    NBTTagFloat() {
    }
    
    @Override
    public long getLong() {
        return (long)this.data;
    }
    
    @Override
    void read(final DataInput lllllllllllIIIIllIIlllIIIllIlllI, final int lllllllllllIIIIllIIlllIIIlllIIIl, final NBTSizeTracker lllllllllllIIIIllIIlllIIIlllIIII) throws IOException {
        lllllllllllIIIIllIIlllIIIlllIIII.read(96L);
        this.data = lllllllllllIIIIllIIlllIIIllIlllI.readFloat();
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor(this.data) & 0xFF);
    }
    
    @Override
    public byte getId() {
        return 5;
    }
    
    public NBTTagFloat(final float lllllllllllIIIIllIIlllIIIlllllll) {
        this.data = lllllllllllIIIIllIIlllIIIlllllll;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public int getInt() {
        return MathHelper.floor(this.data);
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor(this.data) & 0xFFFF);
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIIIllIIlllIIIllIIIlI) {
        return super.equals(lllllllllllIIIIllIIlllIIIllIIIlI) && this.data == ((NBTTagFloat)lllllllllllIIIIllIIlllIIIllIIIlI).data;
    }
}
