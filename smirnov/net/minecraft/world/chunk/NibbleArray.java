// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

public class NibbleArray
{
    private final /* synthetic */ byte[] data;
    
    public void set(final int lllllllllllIlllllIIllIllIIIIlllI, final int lllllllllllIlllllIIllIllIIIIlIII, final int lllllllllllIlllllIIllIllIIIIIlll, final int lllllllllllIlllllIIllIllIIIIlIll) {
        this.setIndex(this.getCoordinateIndex(lllllllllllIlllllIIllIllIIIIlllI, lllllllllllIlllllIIllIllIIIIlIII, lllllllllllIlllllIIllIllIIIIIlll), lllllllllllIlllllIIllIllIIIIlIll);
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public NibbleArray() {
        this.data = new byte[2048];
    }
    
    public void setIndex(final int lllllllllllIlllllIIllIlIlllIlIIl, final int lllllllllllIlllllIIllIlIlllIlIII) {
        final int lllllllllllIlllllIIllIlIlllIlIll = this.getNibbleIndex(lllllllllllIlllllIIllIlIlllIlIIl);
        if (this.isLowerNibble(lllllllllllIlllllIIllIlIlllIlIIl)) {
            this.data[lllllllllllIlllllIIllIlIlllIlIll] = (byte)((this.data[lllllllllllIlllllIIllIlIlllIlIll] & 0xF0) | (lllllllllllIlllllIIllIlIlllIlIII & 0xF));
        }
        else {
            this.data[lllllllllllIlllllIIllIlIlllIlIll] = (byte)((this.data[lllllllllllIlllllIIllIlIlllIlIll] & 0xF) | (lllllllllllIlllllIIllIlIlllIlIII & 0xF) << 4);
        }
    }
    
    public int get(final int lllllllllllIlllllIIllIllIIIllIll, final int lllllllllllIlllllIIllIllIIIlIllI, final int lllllllllllIlllllIIllIllIIIlIlIl) {
        return this.getFromIndex(this.getCoordinateIndex(lllllllllllIlllllIIllIllIIIllIll, lllllllllllIlllllIIllIllIIIlIllI, lllllllllllIlllllIIllIllIIIlIlIl));
    }
    
    public NibbleArray(final byte[] lllllllllllIlllllIIllIllIIlIIIIl) {
        this.data = lllllllllllIlllllIIllIllIIlIIIIl;
        if (lllllllllllIlllllIIllIllIIlIIIIl.length != 2048) {
            throw new IllegalArgumentException("ChunkNibbleArrays should be 2048 bytes not: " + lllllllllllIlllllIIllIllIIlIIIIl.length);
        }
    }
    
    private int getCoordinateIndex(final int lllllllllllIlllllIIllIllIIIIIIIl, final int lllllllllllIlllllIIllIllIIIIIIII, final int lllllllllllIlllllIIllIlIllllllII) {
        return lllllllllllIlllllIIllIllIIIIIIII << 8 | lllllllllllIlllllIIllIlIllllllII << 4 | lllllllllllIlllllIIllIllIIIIIIIl;
    }
    
    private boolean isLowerNibble(final int lllllllllllIlllllIIllIlIlllIIIll) {
        return (lllllllllllIlllllIIllIlIlllIIIll & 0x1) == 0x0;
    }
    
    private int getNibbleIndex(final int lllllllllllIlllllIIllIlIllIlllll) {
        return lllllllllllIlllllIIllIlIllIlllll >> 1;
    }
    
    public int getFromIndex(final int lllllllllllIlllllIIllIlIllllIlll) {
        final int lllllllllllIlllllIIllIlIllllIllI = this.getNibbleIndex(lllllllllllIlllllIIllIlIllllIlll);
        return this.isLowerNibble(lllllllllllIlllllIIllIlIllllIlll) ? (this.data[lllllllllllIlllllIIllIlIllllIllI] & 0xF) : (this.data[lllllllllllIlllllIIllIlIllllIllI] >> 4 & 0xF);
    }
}
