// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.culling;

public class ClippingHelper
{
    public /* synthetic */ float[][] frustum;
    public /* synthetic */ float[] projectionMatrix;
    public /* synthetic */ float[] modelviewMatrix;
    public /* synthetic */ float[] clippingMatrix;
    
    private float dot(final float[] llllllllllIlllIIIIlIIlllIllIIlII, final float llllllllllIlllIIIIlIIlllIlIlllll, final float llllllllllIlllIIIIlIIlllIllIIIlI, final float llllllllllIlllIIIIlIIlllIllIIIIl) {
        return llllllllllIlllIIIIlIIlllIllIIlII[0] * llllllllllIlllIIIIlIIlllIlIlllll + llllllllllIlllIIIIlIIlllIllIIlII[1] * llllllllllIlllIIIIlIIlllIllIIIlI + llllllllllIlllIIIIlIIlllIllIIlII[2] * llllllllllIlllIIIIlIIlllIllIIIIl + llllllllllIlllIIIIlIIlllIllIIlII[3];
    }
    
    public ClippingHelper() {
        this.frustum = new float[6][4];
        this.projectionMatrix = new float[16];
        this.modelviewMatrix = new float[16];
        this.clippingMatrix = new float[16];
    }
    
    public boolean isBoxInFrustum(final double llllllllllIlllIIIIlIIlllIIllllIl, final double llllllllllIlllIIIIlIIlllIIllllII, final double llllllllllIlllIIIIlIIlllIIlllIll, final double llllllllllIlllIIIIlIIlllIIlllIlI, final double llllllllllIlllIIIIlIIlllIIlllIIl, final double llllllllllIlllIIIIlIIlllIlIIIlll) {
        final float llllllllllIlllIIIIlIIlllIlIIIllI = (float)llllllllllIlllIIIIlIIlllIIllllIl;
        final float llllllllllIlllIIIIlIIlllIlIIIlIl = (float)llllllllllIlllIIIIlIIlllIIllllII;
        final float llllllllllIlllIIIIlIIlllIlIIIlII = (float)llllllllllIlllIIIIlIIlllIIlllIll;
        final float llllllllllIlllIIIIlIIlllIlIIIIll = (float)llllllllllIlllIIIIlIIlllIIlllIlI;
        final float llllllllllIlllIIIIlIIlllIlIIIIlI = (float)llllllllllIlllIIIIlIIlllIIlllIIl;
        final float llllllllllIlllIIIIlIIlllIlIIIIIl = (float)llllllllllIlllIIIIlIIlllIlIIIlll;
        for (int llllllllllIlllIIIIlIIlllIlIIIIII = 0; llllllllllIlllIIIIlIIlllIlIIIIII < 6; ++llllllllllIlllIIIIlIIlllIlIIIIII) {
            final float[] llllllllllIlllIIIIlIIlllIIllllll = this.frustum[llllllllllIlllIIIIlIIlllIlIIIIII];
            if (this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIllI, llllllllllIlllIIIIlIIlllIlIIIlIl, llllllllllIlllIIIIlIIlllIlIIIlII) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIIll, llllllllllIlllIIIIlIIlllIlIIIlIl, llllllllllIlllIIIIlIIlllIlIIIlII) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIllI, llllllllllIlllIIIIlIIlllIlIIIIlI, llllllllllIlllIIIIlIIlllIlIIIlII) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIIll, llllllllllIlllIIIIlIIlllIlIIIIlI, llllllllllIlllIIIIlIIlllIlIIIlII) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIllI, llllllllllIlllIIIIlIIlllIlIIIlIl, llllllllllIlllIIIIlIIlllIlIIIIIl) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIIll, llllllllllIlllIIIIlIIlllIlIIIlIl, llllllllllIlllIIIIlIIlllIlIIIIIl) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIllI, llllllllllIlllIIIIlIIlllIlIIIIlI, llllllllllIlllIIIIlIIlllIlIIIIIl) <= 0.0f && this.dot(llllllllllIlllIIIIlIIlllIIllllll, llllllllllIlllIIIIlIIlllIlIIIIll, llllllllllIlllIIIIlIIlllIlIIIIlI, llllllllllIlllIIIIlIIlllIlIIIIIl) <= 0.0f) {
                return false;
            }
        }
        return true;
    }
}
