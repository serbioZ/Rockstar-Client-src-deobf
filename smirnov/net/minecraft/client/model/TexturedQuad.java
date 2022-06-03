// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import shadersmod.client.SVertexFormat;
import optifine.Config;
import net.minecraft.client.renderer.BufferBuilder;

public class TexturedQuad
{
    private /* synthetic */ boolean invertNormal;
    public /* synthetic */ int nVertices;
    public /* synthetic */ PositionTextureVertex[] vertexPositions;
    
    public TexturedQuad(final PositionTextureVertex[] lllllllllllllllIlIllllllIIllIIll) {
        this.vertexPositions = lllllllllllllllIlIllllllIIllIIll;
        this.nVertices = lllllllllllllllIlIllllllIIllIIll.length;
    }
    
    public void flipFace() {
        final PositionTextureVertex[] lllllllllllllllIlIllllllIIIlIIII = new PositionTextureVertex[this.vertexPositions.length];
        for (int lllllllllllllllIlIllllllIIIIllll = 0; lllllllllllllllIlIllllllIIIIllll < this.vertexPositions.length; ++lllllllllllllllIlIllllllIIIIllll) {
            lllllllllllllllIlIllllllIIIlIIII[lllllllllllllllIlIllllllIIIIllll] = this.vertexPositions[this.vertexPositions.length - lllllllllllllllIlIllllllIIIIllll - 1];
        }
        this.vertexPositions = lllllllllllllllIlIllllllIIIlIIII;
    }
    
    public void draw(final BufferBuilder lllllllllllllllIlIlllllIllllIlII, final float lllllllllllllllIlIlllllIlllllllI) {
        final Vec3d lllllllllllllllIlIlllllIllllllIl = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[0].vector3D);
        final Vec3d lllllllllllllllIlIlllllIllllllII = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[2].vector3D);
        final Vec3d lllllllllllllllIlIlllllIlllllIll = lllllllllllllllIlIlllllIllllllII.crossProduct(lllllllllllllllIlIlllllIllllllIl).normalize();
        float lllllllllllllllIlIlllllIlllllIlI = (float)lllllllllllllllIlIlllllIlllllIll.xCoord;
        float lllllllllllllllIlIlllllIlllllIIl = (float)lllllllllllllllIlIlllllIlllllIll.yCoord;
        float lllllllllllllllIlIlllllIlllllIII = (float)lllllllllllllllIlIlllllIlllllIll.zCoord;
        if (this.invertNormal) {
            lllllllllllllllIlIlllllIlllllIlI = -lllllllllllllllIlIlllllIlllllIlI;
            lllllllllllllllIlIlllllIlllllIIl = -lllllllllllllllIlIlllllIlllllIIl;
            lllllllllllllllIlIlllllIlllllIII = -lllllllllllllllIlIlllllIlllllIII;
        }
        if (Config.isShaders()) {
            lllllllllllllllIlIlllllIllllIlII.begin(7, SVertexFormat.defVertexFormatTextured);
        }
        else {
            lllllllllllllllIlIlllllIllllIlII.begin(7, DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);
        }
        for (int lllllllllllllllIlIlllllIllllIlll = 0; lllllllllllllllIlIlllllIllllIlll < 4; ++lllllllllllllllIlIlllllIllllIlll) {
            final PositionTextureVertex lllllllllllllllIlIlllllIllllIllI = this.vertexPositions[lllllllllllllllIlIlllllIllllIlll];
            lllllllllllllllIlIlllllIllllIlII.pos(lllllllllllllllIlIlllllIllllIllI.vector3D.xCoord * lllllllllllllllIlIlllllIlllllllI, lllllllllllllllIlIlllllIllllIllI.vector3D.yCoord * lllllllllllllllIlIlllllIlllllllI, lllllllllllllllIlIlllllIllllIllI.vector3D.zCoord * lllllllllllllllIlIlllllIlllllllI).tex(lllllllllllllllIlIlllllIllllIllI.texturePositionX, lllllllllllllllIlIlllllIllllIllI.texturePositionY).normal(lllllllllllllllIlIlllllIlllllIlI, lllllllllllllllIlIlllllIlllllIIl, lllllllllllllllIlIlllllIlllllIII).endVertex();
        }
        Tessellator.getInstance().draw();
    }
    
    public TexturedQuad(final PositionTextureVertex[] lllllllllllllllIlIllllllIIlIIlll, final int lllllllllllllllIlIllllllIIlIIllI, final int lllllllllllllllIlIllllllIIlIIlIl, final int lllllllllllllllIlIllllllIIlIIlII, final int lllllllllllllllIlIllllllIIlIIIll, final float lllllllllllllllIlIllllllIIlIIIlI, final float lllllllllllllllIlIllllllIIIlIlll) {
        this(lllllllllllllllIlIllllllIIlIIlll);
        final float lllllllllllllllIlIllllllIIlIIIII = 0.0f / lllllllllllllllIlIllllllIIlIIIlI;
        final float lllllllllllllllIlIllllllIIIlllll = 0.0f / lllllllllllllllIlIllllllIIIlIlll;
        lllllllllllllllIlIllllllIIlIIlll[0] = lllllllllllllllIlIllllllIIlIIlll[0].setTexturePosition(lllllllllllllllIlIllllllIIlIIlII / lllllllllllllllIlIllllllIIlIIIlI - lllllllllllllllIlIllllllIIlIIIII, lllllllllllllllIlIllllllIIlIIlIl / lllllllllllllllIlIllllllIIIlIlll + lllllllllllllllIlIllllllIIIlllll);
        lllllllllllllllIlIllllllIIlIIlll[1] = lllllllllllllllIlIllllllIIlIIlll[1].setTexturePosition(lllllllllllllllIlIllllllIIlIIllI / lllllllllllllllIlIllllllIIlIIIlI + lllllllllllllllIlIllllllIIlIIIII, lllllllllllllllIlIllllllIIlIIlIl / lllllllllllllllIlIllllllIIIlIlll + lllllllllllllllIlIllllllIIIlllll);
        lllllllllllllllIlIllllllIIlIIlll[2] = lllllllllllllllIlIllllllIIlIIlll[2].setTexturePosition(lllllllllllllllIlIllllllIIlIIllI / lllllllllllllllIlIllllllIIlIIIlI + lllllllllllllllIlIllllllIIlIIIII, lllllllllllllllIlIllllllIIlIIIll / lllllllllllllllIlIllllllIIIlIlll - lllllllllllllllIlIllllllIIIlllll);
        lllllllllllllllIlIllllllIIlIIlll[3] = lllllllllllllllIlIllllllIIlIIlll[3].setTexturePosition(lllllllllllllllIlIllllllIIlIIlII / lllllllllllllllIlIllllllIIlIIIlI - lllllllllllllllIlIllllllIIlIIIII, lllllllllllllllIlIllllllIIlIIIll / lllllllllllllllIlIllllllIIIlIlll - lllllllllllllllIlIllllllIIIlllll);
    }
}
