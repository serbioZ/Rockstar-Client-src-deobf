// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataInput;
import java.util.List;
import java.io.IOException;
import java.io.DataOutput;
import java.util.Arrays;

public class NBTTagIntArray extends NBTBase
{
    private /* synthetic */ int[] intArray;
    
    @Override
    public byte getId() {
        return 11;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllIllllIllllIIllII) {
        return super.equals(llllllllllllIlllIllllIllllIIllII) && Arrays.equals(this.intArray, ((NBTTagIntArray)llllllllllllIlllIllllIllllIIllII).intArray);
    }
    
    @Override
    void write(final DataOutput llllllllllllIlllIllllIllllllIlll) throws IOException {
        llllllllllllIlllIllllIllllllIlll.writeInt(this.intArray.length);
        final String llllllllllllIlllIllllIllllllIIII;
        final String llllllllllllIlllIllllIllllllIIIl = (String)((int[])(Object)(llllllllllllIlllIllllIllllllIIII = (String)(Object)this.intArray)).length;
        for (Exception llllllllllllIlllIllllIllllllIIlI = (Exception)0; llllllllllllIlllIllllIllllllIIlI < llllllllllllIlllIllllIllllllIIIl; ++llllllllllllIlllIllllIllllllIIlI) {
            final int llllllllllllIlllIllllIllllllIllI = llllllllllllIlllIllllIllllllIIII[llllllllllllIlllIllllIllllllIIlI];
            llllllllllllIlllIllllIllllllIlll.writeInt(llllllllllllIlllIllllIllllllIllI);
        }
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.intArray);
    }
    
    public NBTTagIntArray(final int[] llllllllllllIlllIlllllIIIIIlIIIl) {
        this.intArray = llllllllllllIlllIlllllIIIIIlIIIl;
    }
    
    @Override
    public NBTTagIntArray copy() {
        final int[] llllllllllllIlllIllllIllllIlIIlI = new int[this.intArray.length];
        System.arraycopy(this.intArray, 0, llllllllllllIlllIllllIllllIlIIlI, 0, this.intArray.length);
        return new NBTTagIntArray(llllllllllllIlllIllllIllllIlIIlI);
    }
    
    private static int[] func_193584_a(final List<Integer> llllllllllllIlllIlllllIIIIIIIllI) {
        final int[] llllllllllllIlllIlllllIIIIIIIlIl = new int[llllllllllllIlllIlllllIIIIIIIllI.size()];
        for (int llllllllllllIlllIlllllIIIIIIIlII = 0; llllllllllllIlllIlllllIIIIIIIlII < llllllllllllIlllIlllllIIIIIIIllI.size(); ++llllllllllllIlllIlllllIIIIIIIlII) {
            final Integer llllllllllllIlllIlllllIIIIIIIIll = llllllllllllIlllIlllllIIIIIIIllI.get(llllllllllllIlllIlllllIIIIIIIlII);
            llllllllllllIlllIlllllIIIIIIIlIl[llllllllllllIlllIlllllIIIIIIIlII] = ((llllllllllllIlllIlllllIIIIIIIIll == null) ? 0 : llllllllllllIlllIlllllIIIIIIIIll);
        }
        return llllllllllllIlllIlllllIIIIIIIlIl;
    }
    
    NBTTagIntArray() {
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllIlllIllllIllllIllIlI = new StringBuilder("[I;");
        for (int llllllllllllIlllIllllIllllIllIIl = 0; llllllllllllIlllIllllIllllIllIIl < this.intArray.length; ++llllllllllllIlllIllllIllllIllIIl) {
            if (llllllllllllIlllIllllIllllIllIIl != 0) {
                llllllllllllIlllIllllIllllIllIlI.append(',');
            }
            llllllllllllIlllIllllIllllIllIlI.append(this.intArray[llllllllllllIlllIllllIllllIllIIl]);
        }
        return llllllllllllIlllIllllIllllIllIlI.append(']').toString();
    }
    
    public NBTTagIntArray(final List<Integer> llllllllllllIlllIlllllIIIIIIllIl) {
        this(func_193584_a(llllllllllllIlllIlllllIIIIIIllIl));
    }
    
    @Override
    void read(final DataInput llllllllllllIlllIllllIlllllIIIll, final int llllllllllllIlllIllllIlllllIlIII, final NBTSizeTracker llllllllllllIlllIllllIlllllIIlll) throws IOException {
        llllllllllllIlllIllllIlllllIIlll.read(192L);
        final int llllllllllllIlllIllllIlllllIIllI = llllllllllllIlllIllllIlllllIIIll.readInt();
        llllllllllllIlllIllllIlllllIIlll.read(32 * llllllllllllIlllIllllIlllllIIllI);
        this.intArray = new int[llllllllllllIlllIllllIlllllIIllI];
        for (int llllllllllllIlllIllllIlllllIIlIl = 0; llllllllllllIlllIllllIlllllIIlIl < llllllllllllIlllIllllIlllllIIllI; ++llllllllllllIlllIllllIlllllIIlIl) {
            this.intArray[llllllllllllIlllIllllIlllllIIlIl] = llllllllllllIlllIllllIlllllIIIll.readInt();
        }
    }
    
    public int[] getIntArray() {
        return this.intArray;
    }
}
