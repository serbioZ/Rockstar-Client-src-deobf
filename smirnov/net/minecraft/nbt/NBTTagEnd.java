// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;

public class NBTTagEnd extends NBTBase
{
    @Override
    public String toString() {
        return "END";
    }
    
    @Override
    public byte getId() {
        return 0;
    }
    
    @Override
    void read(final DataInput llllllllllllIIlIIIIIIlllIlIllIlI, final int llllllllllllIIlIIIIIIlllIlIllIIl, final NBTSizeTracker llllllllllllIIlIIIIIIlllIlIlIlll) throws IOException {
        llllllllllllIIlIIIIIIlllIlIlIlll.read(64L);
    }
    
    @Override
    public NBTTagEnd copy() {
        return new NBTTagEnd();
    }
    
    @Override
    void write(final DataOutput llllllllllllIIlIIIIIIlllIlIlIlIl) throws IOException {
    }
}
