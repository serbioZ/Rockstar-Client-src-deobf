// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

public class NBTSizeTracker
{
    private /* synthetic */ long read;
    private final /* synthetic */ long max;
    
    static {
        INFINITE = new NBTSizeTracker() {
            @Override
            public void read(final long llllllllllllllIlIlIlIlllIlIIlIlI) {
            }
        };
    }
    
    public void read(final long lllllllllllIIllllIIlllIlIllIIIlI) {
        this.read += lllllllllllIIllllIIlllIlIllIIIlI / 8L;
        if (this.read > this.max) {
            throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.read + "bytes where max allowed: " + this.max);
        }
    }
    
    public NBTSizeTracker(final long lllllllllllIIllllIIlllIlIllIIllI) {
        this.max = lllllllllllIIllllIIlllIlIllIIllI;
    }
}
