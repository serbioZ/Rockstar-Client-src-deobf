// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

public class Matrix4f extends org.lwjgl.util.vector.Matrix4f
{
    public Matrix4f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }
    
    public Matrix4f(final float[] llllllllllllIllIIlIIIIIIlIlIIlII) {
        this.m00 = llllllllllllIllIIlIIIIIIlIlIIlII[0];
        this.m01 = llllllllllllIllIIlIIIIIIlIlIIlII[1];
        this.m02 = llllllllllllIllIIlIIIIIIlIlIIlII[2];
        this.m03 = llllllllllllIllIIlIIIIIIlIlIIlII[3];
        this.m10 = llllllllllllIllIIlIIIIIIlIlIIlII[4];
        this.m11 = llllllllllllIllIIlIIIIIIlIlIIlII[5];
        this.m12 = llllllllllllIllIIlIIIIIIlIlIIlII[6];
        this.m13 = llllllllllllIllIIlIIIIIIlIlIIlII[7];
        this.m20 = llllllllllllIllIIlIIIIIIlIlIIlII[8];
        this.m21 = llllllllllllIllIIlIIIIIIlIlIIlII[9];
        this.m22 = llllllllllllIllIIlIIIIIIlIlIIlII[10];
        this.m23 = llllllllllllIllIIlIIIIIIlIlIIlII[11];
        this.m30 = llllllllllllIllIIlIIIIIIlIlIIlII[12];
        this.m31 = llllllllllllIllIIlIIIIIIlIlIIlII[13];
        this.m32 = llllllllllllIllIIlIIIIIIlIlIIlII[14];
        this.m33 = llllllllllllIllIIlIIIIIIlIlIIlII[15];
    }
}
