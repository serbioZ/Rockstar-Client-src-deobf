// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

public class AnimationFrame
{
    private final /* synthetic */ int frameTime;
    private final /* synthetic */ int frameIndex;
    
    public AnimationFrame(final int llllllllllllllIllllIIllIlIllIIlI, final int llllllllllllllIllllIIllIlIllIlII) {
        this.frameIndex = llllllllllllllIllllIIllIlIllIIlI;
        this.frameTime = llllllllllllllIllllIIllIlIllIlII;
    }
    
    public boolean hasNoTime() {
        return this.frameTime == -1;
    }
    
    public AnimationFrame(final int llllllllllllllIllllIIllIlIllllII) {
        this(llllllllllllllIllllIIllIlIllllII, -1);
    }
    
    public int getFrameIndex() {
        return this.frameIndex;
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
}
