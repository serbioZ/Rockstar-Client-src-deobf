// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.util.Objects;
import java.io.IOException;
import java.io.DataInput;

public class NBTTagString extends NBTBase
{
    private /* synthetic */ String data;
    
    public static String func_193588_a(final String llllllllllllllIllIllIIllIIIIlIIl) {
        final StringBuilder llllllllllllllIllIllIIllIIIIlIII = new StringBuilder("\"");
        for (int llllllllllllllIllIllIIllIIIIIlll = 0; llllllllllllllIllIllIIllIIIIIlll < llllllllllllllIllIllIIllIIIIlIIl.length(); ++llllllllllllllIllIllIIllIIIIIlll) {
            final char llllllllllllllIllIllIIllIIIIIllI = llllllllllllllIllIllIIllIIIIlIIl.charAt(llllllllllllllIllIllIIllIIIIIlll);
            if (llllllllllllllIllIllIIllIIIIIllI == '\\' || llllllllllllllIllIllIIllIIIIIllI == '\"') {
                llllllllllllllIllIllIIllIIIIlIII.append('\\');
            }
            llllllllllllllIllIllIIllIIIIlIII.append(llllllllllllllIllIllIIllIIIIIllI);
        }
        return llllllllllllllIllIllIIllIIIIlIII.append('\"').toString();
    }
    
    @Override
    void read(final DataInput llllllllllllllIllIllIIllIIlIllII, final int llllllllllllllIllIllIIllIIlIlIll, final NBTSizeTracker llllllllllllllIllIllIIllIIlIlIlI) throws IOException {
        llllllllllllllIllIllIIllIIlIlIlI.read(288L);
        this.data = llllllllllllllIllIllIIllIIlIllII.readUTF();
        llllllllllllllIllIllIIllIIlIlIlI.read(16 * this.data.length());
    }
    
    @Override
    public boolean hasNoTags() {
        return this.data.isEmpty();
    }
    
    @Override
    public String toString() {
        return func_193588_a(this.data);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data.hashCode();
    }
    
    @Override
    public byte getId() {
        return 8;
    }
    
    public String getString() {
        return this.data;
    }
    
    public NBTTagString() {
        this("");
    }
    
    public NBTTagString(final String llllllllllllllIllIllIIllIIlllIIl) {
        Objects.requireNonNull(llllllllllllllIllIllIIllIIlllIIl, "Null string not allowed");
        this.data = llllllllllllllIllIllIIllIIlllIIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIllIIllIIIlIlIl) {
        if (!super.equals(llllllllllllllIllIllIIllIIIlIlIl)) {
            return false;
        }
        final NBTTagString llllllllllllllIllIllIIllIIIlIlll = (NBTTagString)llllllllllllllIllIllIIllIIIlIlIl;
        return (this.data == null && llllllllllllllIllIllIIllIIIlIlll.data == null) || Objects.equals(this.data, llllllllllllllIllIllIIllIIIlIlll.data);
    }
    
    @Override
    void write(final DataOutput llllllllllllllIllIllIIllIIllIIIl) throws IOException {
        llllllllllllllIllIllIIllIIllIIIl.writeUTF(this.data);
    }
    
    @Override
    public NBTTagString copy() {
        return new NBTTagString(this.data);
    }
}
