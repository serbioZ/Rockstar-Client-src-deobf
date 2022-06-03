// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.culling;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GLAllocation;
import java.nio.FloatBuffer;

public class ClippingHelperImpl extends ClippingHelper
{
    private final /* synthetic */ FloatBuffer floatBuffer16;
    private final /* synthetic */ FloatBuffer projectionMatrixBuffer;
    private final /* synthetic */ FloatBuffer modelviewMatrixBuffer;
    private static final /* synthetic */ ClippingHelperImpl instance;
    
    static {
        instance = new ClippingHelperImpl();
    }
    
    public static ClippingHelper getInstance() {
        ClippingHelperImpl.instance.init();
        return ClippingHelperImpl.instance;
    }
    
    public ClippingHelperImpl() {
        this.projectionMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.modelviewMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.floatBuffer16 = GLAllocation.createDirectFloatBuffer(16);
    }
    
    private void normalize(final float[] llllllllllllIlIlllllIllIllllIIIl) {
        final float llllllllllllIlIlllllIllIllllIIlI = MathHelper.sqrt(llllllllllllIlIlllllIllIllllIIIl[0] * llllllllllllIlIlllllIllIllllIIIl[0] + llllllllllllIlIlllllIllIllllIIIl[1] * llllllllllllIlIlllllIllIllllIIIl[1] + llllllllllllIlIlllllIllIllllIIIl[2] * llllllllllllIlIlllllIllIllllIIIl[2]);
        final int n = 0;
        llllllllllllIlIlllllIllIllllIIIl[n] /= llllllllllllIlIlllllIllIllllIIlI;
        final int n2 = 1;
        llllllllllllIlIlllllIllIllllIIIl[n2] /= llllllllllllIlIlllllIllIllllIIlI;
        final int n3 = 2;
        llllllllllllIlIlllllIllIllllIIIl[n3] /= llllllllllllIlIlllllIllIllllIIlI;
        final int n4 = 3;
        llllllllllllIlIlllllIllIllllIIIl[n4] /= llllllllllllIlIlllllIllIllllIIlI;
    }
    
    public void init() {
        this.projectionMatrixBuffer.clear();
        this.modelviewMatrixBuffer.clear();
        this.floatBuffer16.clear();
        GlStateManager.getFloat(2983, this.projectionMatrixBuffer);
        GlStateManager.getFloat(2982, this.modelviewMatrixBuffer);
        final float[] llllllllllllIlIlllllIllIlllIIlIl = this.projectionMatrix;
        final float[] llllllllllllIlIlllllIllIlllIIlII = this.modelviewMatrix;
        this.projectionMatrixBuffer.flip().limit(16);
        this.projectionMatrixBuffer.get(llllllllllllIlIlllllIllIlllIIlIl);
        this.modelviewMatrixBuffer.flip().limit(16);
        this.modelviewMatrixBuffer.get(llllllllllllIlIlllllIllIlllIIlII);
        this.clippingMatrix[0] = llllllllllllIlIlllllIllIlllIIlII[0] * llllllllllllIlIlllllIllIlllIIlIl[0] + llllllllllllIlIlllllIllIlllIIlII[1] * llllllllllllIlIlllllIllIlllIIlIl[4] + llllllllllllIlIlllllIllIlllIIlII[2] * llllllllllllIlIlllllIllIlllIIlIl[8] + llllllllllllIlIlllllIllIlllIIlII[3] * llllllllllllIlIlllllIllIlllIIlIl[12];
        this.clippingMatrix[1] = llllllllllllIlIlllllIllIlllIIlII[0] * llllllllllllIlIlllllIllIlllIIlIl[1] + llllllllllllIlIlllllIllIlllIIlII[1] * llllllllllllIlIlllllIllIlllIIlIl[5] + llllllllllllIlIlllllIllIlllIIlII[2] * llllllllllllIlIlllllIllIlllIIlIl[9] + llllllllllllIlIlllllIllIlllIIlII[3] * llllllllllllIlIlllllIllIlllIIlIl[13];
        this.clippingMatrix[2] = llllllllllllIlIlllllIllIlllIIlII[0] * llllllllllllIlIlllllIllIlllIIlIl[2] + llllllllllllIlIlllllIllIlllIIlII[1] * llllllllllllIlIlllllIllIlllIIlIl[6] + llllllllllllIlIlllllIllIlllIIlII[2] * llllllllllllIlIlllllIllIlllIIlIl[10] + llllllllllllIlIlllllIllIlllIIlII[3] * llllllllllllIlIlllllIllIlllIIlIl[14];
        this.clippingMatrix[3] = llllllllllllIlIlllllIllIlllIIlII[0] * llllllllllllIlIlllllIllIlllIIlIl[3] + llllllllllllIlIlllllIllIlllIIlII[1] * llllllllllllIlIlllllIllIlllIIlIl[7] + llllllllllllIlIlllllIllIlllIIlII[2] * llllllllllllIlIlllllIllIlllIIlIl[11] + llllllllllllIlIlllllIllIlllIIlII[3] * llllllllllllIlIlllllIllIlllIIlIl[15];
        this.clippingMatrix[4] = llllllllllllIlIlllllIllIlllIIlII[4] * llllllllllllIlIlllllIllIlllIIlIl[0] + llllllllllllIlIlllllIllIlllIIlII[5] * llllllllllllIlIlllllIllIlllIIlIl[4] + llllllllllllIlIlllllIllIlllIIlII[6] * llllllllllllIlIlllllIllIlllIIlIl[8] + llllllllllllIlIlllllIllIlllIIlII[7] * llllllllllllIlIlllllIllIlllIIlIl[12];
        this.clippingMatrix[5] = llllllllllllIlIlllllIllIlllIIlII[4] * llllllllllllIlIlllllIllIlllIIlIl[1] + llllllllllllIlIlllllIllIlllIIlII[5] * llllllllllllIlIlllllIllIlllIIlIl[5] + llllllllllllIlIlllllIllIlllIIlII[6] * llllllllllllIlIlllllIllIlllIIlIl[9] + llllllllllllIlIlllllIllIlllIIlII[7] * llllllllllllIlIlllllIllIlllIIlIl[13];
        this.clippingMatrix[6] = llllllllllllIlIlllllIllIlllIIlII[4] * llllllllllllIlIlllllIllIlllIIlIl[2] + llllllllllllIlIlllllIllIlllIIlII[5] * llllllllllllIlIlllllIllIlllIIlIl[6] + llllllllllllIlIlllllIllIlllIIlII[6] * llllllllllllIlIlllllIllIlllIIlIl[10] + llllllllllllIlIlllllIllIlllIIlII[7] * llllllllllllIlIlllllIllIlllIIlIl[14];
        this.clippingMatrix[7] = llllllllllllIlIlllllIllIlllIIlII[4] * llllllllllllIlIlllllIllIlllIIlIl[3] + llllllllllllIlIlllllIllIlllIIlII[5] * llllllllllllIlIlllllIllIlllIIlIl[7] + llllllllllllIlIlllllIllIlllIIlII[6] * llllllllllllIlIlllllIllIlllIIlIl[11] + llllllllllllIlIlllllIllIlllIIlII[7] * llllllllllllIlIlllllIllIlllIIlIl[15];
        this.clippingMatrix[8] = llllllllllllIlIlllllIllIlllIIlII[8] * llllllllllllIlIlllllIllIlllIIlIl[0] + llllllllllllIlIlllllIllIlllIIlII[9] * llllllllllllIlIlllllIllIlllIIlIl[4] + llllllllllllIlIlllllIllIlllIIlII[10] * llllllllllllIlIlllllIllIlllIIlIl[8] + llllllllllllIlIlllllIllIlllIIlII[11] * llllllllllllIlIlllllIllIlllIIlIl[12];
        this.clippingMatrix[9] = llllllllllllIlIlllllIllIlllIIlII[8] * llllllllllllIlIlllllIllIlllIIlIl[1] + llllllllllllIlIlllllIllIlllIIlII[9] * llllllllllllIlIlllllIllIlllIIlIl[5] + llllllllllllIlIlllllIllIlllIIlII[10] * llllllllllllIlIlllllIllIlllIIlIl[9] + llllllllllllIlIlllllIllIlllIIlII[11] * llllllllllllIlIlllllIllIlllIIlIl[13];
        this.clippingMatrix[10] = llllllllllllIlIlllllIllIlllIIlII[8] * llllllllllllIlIlllllIllIlllIIlIl[2] + llllllllllllIlIlllllIllIlllIIlII[9] * llllllllllllIlIlllllIllIlllIIlIl[6] + llllllllllllIlIlllllIllIlllIIlII[10] * llllllllllllIlIlllllIllIlllIIlIl[10] + llllllllllllIlIlllllIllIlllIIlII[11] * llllllllllllIlIlllllIllIlllIIlIl[14];
        this.clippingMatrix[11] = llllllllllllIlIlllllIllIlllIIlII[8] * llllllllllllIlIlllllIllIlllIIlIl[3] + llllllllllllIlIlllllIllIlllIIlII[9] * llllllllllllIlIlllllIllIlllIIlIl[7] + llllllllllllIlIlllllIllIlllIIlII[10] * llllllllllllIlIlllllIllIlllIIlIl[11] + llllllllllllIlIlllllIllIlllIIlII[11] * llllllllllllIlIlllllIllIlllIIlIl[15];
        this.clippingMatrix[12] = llllllllllllIlIlllllIllIlllIIlII[12] * llllllllllllIlIlllllIllIlllIIlIl[0] + llllllllllllIlIlllllIllIlllIIlII[13] * llllllllllllIlIlllllIllIlllIIlIl[4] + llllllllllllIlIlllllIllIlllIIlII[14] * llllllllllllIlIlllllIllIlllIIlIl[8] + llllllllllllIlIlllllIllIlllIIlII[15] * llllllllllllIlIlllllIllIlllIIlIl[12];
        this.clippingMatrix[13] = llllllllllllIlIlllllIllIlllIIlII[12] * llllllllllllIlIlllllIllIlllIIlIl[1] + llllllllllllIlIlllllIllIlllIIlII[13] * llllllllllllIlIlllllIllIlllIIlIl[5] + llllllllllllIlIlllllIllIlllIIlII[14] * llllllllllllIlIlllllIllIlllIIlIl[9] + llllllllllllIlIlllllIllIlllIIlII[15] * llllllllllllIlIlllllIllIlllIIlIl[13];
        this.clippingMatrix[14] = llllllllllllIlIlllllIllIlllIIlII[12] * llllllllllllIlIlllllIllIlllIIlIl[2] + llllllllllllIlIlllllIllIlllIIlII[13] * llllllllllllIlIlllllIllIlllIIlIl[6] + llllllllllllIlIlllllIllIlllIIlII[14] * llllllllllllIlIlllllIllIlllIIlIl[10] + llllllllllllIlIlllllIllIlllIIlII[15] * llllllllllllIlIlllllIllIlllIIlIl[14];
        this.clippingMatrix[15] = llllllllllllIlIlllllIllIlllIIlII[12] * llllllllllllIlIlllllIllIlllIIlIl[3] + llllllllllllIlIlllllIllIlllIIlII[13] * llllllllllllIlIlllllIllIlllIIlIl[7] + llllllllllllIlIlllllIllIlllIIlII[14] * llllllllllllIlIlllllIllIlllIIlIl[11] + llllllllllllIlIlllllIllIlllIIlII[15] * llllllllllllIlIlllllIllIlllIIlIl[15];
        final float[] llllllllllllIlIlllllIllIlllIIIll = this.frustum[0];
        llllllllllllIlIlllllIllIlllIIIll[0] = this.clippingMatrix[3] - this.clippingMatrix[0];
        llllllllllllIlIlllllIllIlllIIIll[1] = this.clippingMatrix[7] - this.clippingMatrix[4];
        llllllllllllIlIlllllIllIlllIIIll[2] = this.clippingMatrix[11] - this.clippingMatrix[8];
        llllllllllllIlIlllllIllIlllIIIll[3] = this.clippingMatrix[15] - this.clippingMatrix[12];
        this.normalize(llllllllllllIlIlllllIllIlllIIIll);
        final float[] llllllllllllIlIlllllIllIlllIIIlI = this.frustum[1];
        llllllllllllIlIlllllIllIlllIIIlI[0] = this.clippingMatrix[3] + this.clippingMatrix[0];
        llllllllllllIlIlllllIllIlllIIIlI[1] = this.clippingMatrix[7] + this.clippingMatrix[4];
        llllllllllllIlIlllllIllIlllIIIlI[2] = this.clippingMatrix[11] + this.clippingMatrix[8];
        llllllllllllIlIlllllIllIlllIIIlI[3] = this.clippingMatrix[15] + this.clippingMatrix[12];
        this.normalize(llllllllllllIlIlllllIllIlllIIIlI);
        final float[] llllllllllllIlIlllllIllIlllIIIIl = this.frustum[2];
        llllllllllllIlIlllllIllIlllIIIIl[0] = this.clippingMatrix[3] + this.clippingMatrix[1];
        llllllllllllIlIlllllIllIlllIIIIl[1] = this.clippingMatrix[7] + this.clippingMatrix[5];
        llllllllllllIlIlllllIllIlllIIIIl[2] = this.clippingMatrix[11] + this.clippingMatrix[9];
        llllllllllllIlIlllllIllIlllIIIIl[3] = this.clippingMatrix[15] + this.clippingMatrix[13];
        this.normalize(llllllllllllIlIlllllIllIlllIIIIl);
        final float[] llllllllllllIlIlllllIllIlllIIIII = this.frustum[3];
        llllllllllllIlIlllllIllIlllIIIII[0] = this.clippingMatrix[3] - this.clippingMatrix[1];
        llllllllllllIlIlllllIllIlllIIIII[1] = this.clippingMatrix[7] - this.clippingMatrix[5];
        llllllllllllIlIlllllIllIlllIIIII[2] = this.clippingMatrix[11] - this.clippingMatrix[9];
        llllllllllllIlIlllllIllIlllIIIII[3] = this.clippingMatrix[15] - this.clippingMatrix[13];
        this.normalize(llllllllllllIlIlllllIllIlllIIIII);
        final float[] llllllllllllIlIlllllIllIllIlllll = this.frustum[4];
        llllllllllllIlIlllllIllIllIlllll[0] = this.clippingMatrix[3] - this.clippingMatrix[2];
        llllllllllllIlIlllllIllIllIlllll[1] = this.clippingMatrix[7] - this.clippingMatrix[6];
        llllllllllllIlIlllllIllIllIlllll[2] = this.clippingMatrix[11] - this.clippingMatrix[10];
        llllllllllllIlIlllllIllIllIlllll[3] = this.clippingMatrix[15] - this.clippingMatrix[14];
        this.normalize(llllllllllllIlIlllllIllIllIlllll);
        final float[] llllllllllllIlIlllllIllIllIllllI = this.frustum[5];
        llllllllllllIlIlllllIllIllIllllI[0] = this.clippingMatrix[3] + this.clippingMatrix[2];
        llllllllllllIlIlllllIllIllIllllI[1] = this.clippingMatrix[7] + this.clippingMatrix[6];
        llllllllllllIlIlllllIllIllIllllI[2] = this.clippingMatrix[11] + this.clippingMatrix[10];
        llllllllllllIlIlllllIllIllIllllI[3] = this.clippingMatrix[15] + this.clippingMatrix[14];
        this.normalize(llllllllllllIlIlllllIllIllIllllI);
    }
}
