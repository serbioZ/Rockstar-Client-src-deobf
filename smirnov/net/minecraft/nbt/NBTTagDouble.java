// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;
import net.minecraft.util.math.MathHelper;

public class NBTTagDouble extends NBTPrimitive
{
    private /* synthetic */ double data;
    
    @Override
    public byte getId() {
        return 6;
    }
    
    NBTTagDouble() {
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIllllIIIIllIllI) {
        return super.equals(lllllllllllllllllIllllIIIIllIllI) && this.data == ((NBTTagDouble)lllllllllllllllllIllllIIIIllIllI).data;
    }
    
    public NBTTagDouble(final double lllllllllllllllllIllllIIIlIlIIll) {
        this.data = lllllllllllllllllIllllIIIlIlIIll;
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor(this.data) & 0xFFFF);
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor(this.data) & 0xFF);
    }
    
    @Override
    void read(final DataInput lllllllllllllllllIllllIIIlIIIlII, final int lllllllllllllllllIllllIIIlIIIlll, final NBTSizeTracker lllllllllllllllllIllllIIIlIIIIll) throws IOException {
        lllllllllllllllllIllllIIIlIIIIll.read(128L);
        this.data = lllllllllllllllllIllllIIIlIIIlII.readDouble();
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data) + "d";
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    public int getInt() {
        return MathHelper.floor(this.data);
    }
    
    @Override
    void write(final DataOutput lllllllllllllllllIllllIIIlIIllIl) throws IOException {
        lllllllllllllllllIllllIIIlIIllIl.writeDouble(this.data);
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public long getLong() {
        return (long)Math.floor(this.data);
    }
    
    @Override
    public int hashCode() {
        final long lllllllllllllllllIllllIIIIllIIlI = Double.doubleToLongBits(this.data);
        return super.hashCode() ^ (int)(lllllllllllllllllIllllIIIIllIIlI ^ lllllllllllllllllIllllIIIIllIIlI >>> 32);
    }
    
    @Override
    public NBTTagDouble copy() {
        return new NBTTagDouble(this.data);
    }
}
