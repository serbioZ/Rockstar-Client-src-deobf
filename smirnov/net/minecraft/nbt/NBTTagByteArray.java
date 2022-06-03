// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;
import java.util.List;
import java.util.Arrays;

public class NBTTagByteArray extends NBTBase
{
    private /* synthetic */ byte[] data;
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.data);
    }
    
    NBTTagByteArray() {
    }
    
    private static byte[] func_193589_a(final List<Byte> lllllllllllIIlllllIIIIlIlIlllllI) {
        final byte[] lllllllllllIIlllllIIIIlIlIllllIl = new byte[lllllllllllIIlllllIIIIlIlIlllllI.size()];
        for (int lllllllllllIIlllllIIIIlIlIllllII = 0; lllllllllllIIlllllIIIIlIlIllllII < lllllllllllIIlllllIIIIlIlIlllllI.size(); ++lllllllllllIIlllllIIIIlIlIllllII) {
            final Byte lllllllllllIIlllllIIIIlIlIlllIll = lllllllllllIIlllllIIIIlIlIlllllI.get(lllllllllllIIlllllIIIIlIlIllllII);
            lllllllllllIIlllllIIIIlIlIllllIl[lllllllllllIIlllllIIIIlIlIllllII] = (byte)((lllllllllllIIlllllIIIIlIlIlllIll == null) ? 0 : ((byte)lllllllllllIIlllllIIIIlIlIlllIll));
        }
        return lllllllllllIIlllllIIIIlIlIllllIl;
    }
    
    public NBTTagByteArray(final byte[] lllllllllllIIlllllIIIIlIllIIlIll) {
        this.data = lllllllllllIIlllllIIIIlIllIIlIll;
    }
    
    @Override
    void read(final DataInput lllllllllllIIlllllIIIIlIlIlIIllI, final int lllllllllllIIlllllIIIIlIlIlIlIlI, final NBTSizeTracker lllllllllllIIlllllIIIIlIlIlIlIIl) throws IOException {
        lllllllllllIIlllllIIIIlIlIlIlIIl.read(192L);
        final int lllllllllllIIlllllIIIIlIlIlIlIII = lllllllllllIIlllllIIIIlIlIlIIllI.readInt();
        lllllllllllIIlllllIIIIlIlIlIlIIl.read(8 * lllllllllllIIlllllIIIIlIlIlIlIII);
        this.data = new byte[lllllllllllIIlllllIIIIlIlIlIlIII];
        lllllllllllIIlllllIIIIlIlIlIIllI.readFully(this.data);
    }
    
    @Override
    void write(final DataOutput lllllllllllIIlllllIIIIlIlIllIIll) throws IOException {
        lllllllllllIIlllllIIIIlIlIllIIll.writeInt(this.data.length);
        lllllllllllIIlllllIIIIlIlIllIIll.write(this.data);
    }
    
    @Override
    public byte getId() {
        return 7;
    }
    
    public NBTTagByteArray(final List<Byte> lllllllllllIIlllllIIIIlIllIIIIll) {
        this(func_193589_a(lllllllllllIIlllllIIIIlIllIIIIll));
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllIIlllllIIIIlIlIIllllI = new StringBuilder("[B;");
        for (int lllllllllllIIlllllIIIIlIlIIlllIl = 0; lllllllllllIIlllllIIIIlIlIIlllIl < this.data.length; ++lllllllllllIIlllllIIIIlIlIIlllIl) {
            if (lllllllllllIIlllllIIIIlIlIIlllIl != 0) {
                lllllllllllIIlllllIIIIlIlIIllllI.append(',');
            }
            lllllllllllIIlllllIIIIlIlIIllllI.append(this.data[lllllllllllIIlllllIIIIlIlIIlllIl]).append('B');
        }
        return lllllllllllIIlllllIIIIlIlIIllllI.append(']').toString();
    }
    
    @Override
    public NBTBase copy() {
        final byte[] lllllllllllIIlllllIIIIlIlIIlIllI = new byte[this.data.length];
        System.arraycopy(this.data, 0, lllllllllllIIlllllIIIIlIlIIlIllI, 0, this.data.length);
        return new NBTTagByteArray(lllllllllllIIlllllIIIIlIlIIlIllI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIlllllIIIIlIlIIIlllI) {
        return super.equals(lllllllllllIIlllllIIIIlIlIIIlllI) && Arrays.equals(this.data, ((NBTTagByteArray)lllllllllllIIlllllIIIIlIlIIIlllI).data);
    }
    
    public byte[] getByteArray() {
        return this.data;
    }
}
