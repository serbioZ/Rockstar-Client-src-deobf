// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

public class NibbleArrayReader
{
    private final /* synthetic */ int depthBitsPlusFour;
    private final /* synthetic */ int depthBits;
    public final /* synthetic */ byte[] data;
    
    public int get(final int llllllllllllIIIIlIlIlllllIlIIIll, final int llllllllllllIIIIlIlIlllllIlIlIIl, final int llllllllllllIIIIlIlIlllllIlIlIII) {
        final int llllllllllllIIIIlIlIlllllIlIIlll = llllllllllllIIIIlIlIlllllIlIIIll << this.depthBitsPlusFour | llllllllllllIIIIlIlIlllllIlIlIII << this.depthBits | llllllllllllIIIIlIlIlllllIlIlIIl;
        final int llllllllllllIIIIlIlIlllllIlIIllI = llllllllllllIIIIlIlIlllllIlIIlll >> 1;
        final int llllllllllllIIIIlIlIlllllIlIIlIl = llllllllllllIIIIlIlIlllllIlIIlll & 0x1;
        return (llllllllllllIIIIlIlIlllllIlIIlIl == 0) ? (this.data[llllllllllllIIIIlIlIlllllIlIIllI] & 0xF) : (this.data[llllllllllllIIIIlIlIlllllIlIIllI] >> 4 & 0xF);
    }
    
    public NibbleArrayReader(final byte[] llllllllllllIIIIlIlIlllllIllIlll, final int llllllllllllIIIIlIlIlllllIllIllI) {
        this.data = llllllllllllIIIIlIlIlllllIllIlll;
        this.depthBits = llllllllllllIIIIlIlIlllllIllIllI;
        this.depthBitsPlusFour = llllllllllllIIIIlIlIlllllIllIllI + 4;
    }
}
