// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;
import java.util.List;
import java.util.Arrays;

public class NBTTagLongArray extends NBTBase
{
    private /* synthetic */ long[] field_193587_b;
    
    @Override
    public byte getId() {
        return 12;
    }
    
    public NBTTagLongArray(final long[] llllllllllllIllllIlIIllIIllIlllI) {
        this.field_193587_b = llllllllllllIllllIlIIllIIllIlllI;
    }
    
    NBTTagLongArray() {
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.field_193587_b);
    }
    
    private static long[] func_193586_a(final List<Long> llllllllllllIllllIlIIllIIllIIIIl) {
        final long[] llllllllllllIllllIlIIllIIllIIIII = new long[llllllllllllIllllIlIIllIIllIIIIl.size()];
        for (int llllllllllllIllllIlIIllIIlIlllll = 0; llllllllllllIllllIlIIllIIlIlllll < llllllllllllIllllIlIIllIIllIIIIl.size(); ++llllllllllllIllllIlIIllIIlIlllll) {
            final Long llllllllllllIllllIlIIllIIlIllllI = llllllllllllIllllIlIIllIIllIIIIl.get(llllllllllllIllllIlIIllIIlIlllll);
            llllllllllllIllllIlIIllIIllIIIII[llllllllllllIllllIlIIllIIlIlllll] = ((llllllllllllIllllIlIIllIIlIllllI == null) ? 0L : llllllllllllIllllIlIIllIIlIllllI);
        }
        return llllllllllllIllllIlIIllIIllIIIII;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIllllIlIIllIIIlIIlll) {
        return super.equals(llllllllllllIllllIlIIllIIIlIIlll) && Arrays.equals(this.field_193587_b, ((NBTTagLongArray)llllllllllllIllllIlIIllIIIlIIlll).field_193587_b);
    }
    
    public NBTTagLongArray(final List<Long> llllllllllllIllllIlIIllIIllIlIII) {
        this(func_193586_a(llllllllllllIllllIlIIllIIllIlIII));
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllIllllIlIIllIIIllIlIl = new StringBuilder("[L;");
        for (int llllllllllllIllllIlIIllIIIllIlII = 0; llllllllllllIllllIlIIllIIIllIlII < this.field_193587_b.length; ++llllllllllllIllllIlIIllIIIllIlII) {
            if (llllllllllllIllllIlIIllIIIllIlII != 0) {
                llllllllllllIllllIlIIllIIIllIlIl.append(',');
            }
            llllllllllllIllllIlIIllIIIllIlIl.append(this.field_193587_b[llllllllllllIllllIlIIllIIIllIlII]).append('L');
        }
        return llllllllllllIllllIlIIllIIIllIlIl.append(']').toString();
    }
    
    @Override
    void read(final DataInput llllllllllllIllllIlIIllIIIlllllI, final int llllllllllllIllllIlIIllIIlIIIIll, final NBTSizeTracker llllllllllllIllllIlIIllIIlIIIIlI) throws IOException {
        llllllllllllIllllIlIIllIIlIIIIlI.read(192L);
        final int llllllllllllIllllIlIIllIIlIIIIIl = llllllllllllIllllIlIIllIIIlllllI.readInt();
        llllllllllllIllllIlIIllIIlIIIIlI.read(64 * llllllllllllIllllIlIIllIIlIIIIIl);
        this.field_193587_b = new long[llllllllllllIllllIlIIllIIlIIIIIl];
        for (int llllllllllllIllllIlIIllIIlIIIIII = 0; llllllllllllIllllIlIIllIIlIIIIII < llllllllllllIllllIlIIllIIlIIIIIl; ++llllllllllllIllllIlIIllIIlIIIIII) {
            this.field_193587_b[llllllllllllIllllIlIIllIIlIIIIII] = llllllllllllIllllIlIIllIIIlllllI.readLong();
        }
    }
    
    @Override
    void write(final DataOutput llllllllllllIllllIlIIllIIlIlIIlI) throws IOException {
        llllllllllllIllllIlIIllIIlIlIIlI.writeInt(this.field_193587_b.length);
        final short llllllllllllIllllIlIIllIIlIIlIll;
        final float llllllllllllIllllIlIIllIIlIIllII = ((long[])(Object)(llllllllllllIllllIlIIllIIlIIlIll = (short)(Object)this.field_193587_b)).length;
        for (final long llllllllllllIllllIlIIllIIlIlIIIl : llllllllllllIllllIlIIllIIlIIlIll) {
            llllllllllllIllllIlIIllIIlIlIIlI.writeLong(llllllllllllIllllIlIIllIIlIlIIIl);
        }
    }
    
    @Override
    public NBTTagLongArray copy() {
        final long[] llllllllllllIllllIlIIllIIIlIllIl = new long[this.field_193587_b.length];
        System.arraycopy(this.field_193587_b, 0, llllllllllllIllllIlIIllIIIlIllIl, 0, this.field_193587_b.length);
        return new NBTTagLongArray(llllllllllllIllllIlIIllIIIlIllIl);
    }
}
