// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.BufferBuilder;

public class ModelBox
{
    private final /* synthetic */ TexturedQuad[] quadList;
    private final /* synthetic */ PositionTextureVertex[] vertexPositions;
    public final /* synthetic */ float posZ2;
    public final /* synthetic */ float posY2;
    public final /* synthetic */ float posX1;
    public /* synthetic */ String boxName;
    public final /* synthetic */ float posZ1;
    public final /* synthetic */ float posX2;
    public final /* synthetic */ float posY1;
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIlIIIllllIIlI, final int llllllllllllllIllllIlIIIllllIIIl, final int llllllllllllllIllllIlIIIlllIIlIl, final float llllllllllllllIllllIlIIIlllIllll, final float llllllllllllllIllllIlIIIlllIlllI, final float llllllllllllllIllllIlIIIlllIllIl, final int llllllllllllllIllllIlIIIlllIllII, final int llllllllllllllIllllIlIIIlllIlIll, final int llllllllllllllIllllIlIIIlllIlIlI, final float llllllllllllllIllllIlIIIllIllllI) {
        this(llllllllllllllIllllIlIIIllllIIlI, llllllllllllllIllllIlIIIllllIIIl, llllllllllllllIllllIlIIIlllIIlIl, llllllllllllllIllllIlIIIlllIllll, llllllllllllllIllllIlIIIlllIlllI, llllllllllllllIllllIlIIIlllIllIl, llllllllllllllIllllIlIIIlllIllII, llllllllllllllIllllIlIIIlllIlIll, llllllllllllllIllllIlIIIlllIlIlI, llllllllllllllIllllIlIIIllIllllI, llllllllllllllIllllIlIIIllllIIlI.mirror);
    }
    
    private TexturedQuad makeTexturedQuad(final PositionTextureVertex[] llllllllllllllIllllIlIIIlIIIlIll, final int[] llllllllllllllIllllIlIIIlIIIIlIl, final boolean llllllllllllllIllllIlIIIlIIIIlII, final float llllllllllllllIllllIlIIIlIIIIIll, final float llllllllllllllIllllIlIIIlIIIIlll) {
        if (llllllllllllllIllllIlIIIlIIIIlIl == null) {
            return null;
        }
        return llllllllllllllIllllIlIIIlIIIIlII ? new TexturedQuad(llllllllllllllIllllIlIIIlIIIlIll, llllllllllllllIllllIlIIIlIIIIlIl[2], llllllllllllllIllllIlIIIlIIIIlIl[3], llllllllllllllIllllIlIIIlIIIIlIl[0], llllllllllllllIllllIlIIIlIIIIlIl[1], llllllllllllllIllllIlIIIlIIIIIll, llllllllllllllIllllIlIIIlIIIIlll) : new TexturedQuad(llllllllllllllIllllIlIIIlIIIlIll, llllllllllllllIllllIlIIIlIIIIlIl[0], llllllllllllllIllllIlIIIlIIIIlIl[1], llllllllllllllIllllIlIIIlIIIIlIl[2], llllllllllllllIllllIlIIIlIIIIlIl[3], llllllllllllllIllllIlIIIlIIIIIll, llllllllllllllIllllIlIIIlIIIIlll);
    }
    
    public void render(final BufferBuilder llllllllllllllIllllIlIIIIIlIlIlI, final float llllllllllllllIllllIlIIIIIlIlIIl) {
        final double llllllllllllllIllllIlIIIIIlIIIIl;
        final boolean llllllllllllllIllllIlIIIIIlIIIlI = ((TexturedQuad[])(Object)(llllllllllllllIllllIlIIIIIlIIIIl = (double)(Object)this.quadList)).length != 0;
        for (final TexturedQuad llllllllllllllIllllIlIIIIIlIlIII : llllllllllllllIllllIlIIIIIlIIIIl) {
            if (llllllllllllllIllllIlIIIIIlIlIII != null) {
                llllllllllllllIllllIlIIIIIlIlIII.draw(llllllllllllllIllllIlIIIIIlIlIlI, llllllllllllllIllllIlIIIIIlIlIIl);
            }
        }
    }
    
    public ModelBox setBoxName(final String llllllllllllllIllllIlIIIIIIllIll) {
        this.boxName = llllllllllllllIllllIlIIIIIIllIll;
        return this;
    }
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIlIIIlIlIlIlI, final int[][] llllllllllllllIllllIlIIIllIIIIIl, float llllllllllllllIllllIlIIIlIlIlIII, float llllllllllllllIllllIlIIIlIllllll, float llllllllllllllIllllIlIIIlIlllllI, final float llllllllllllllIllllIlIIIlIllllIl, final float llllllllllllllIllllIlIIIlIllllII, final float llllllllllllllIllllIlIIIlIlllIll, final float llllllllllllllIllllIlIIIlIlllIlI, final boolean llllllllllllllIllllIlIIIlIlIIIIl) {
        this.posX1 = llllllllllllllIllllIlIIIlIlIlIII;
        this.posY1 = llllllllllllllIllllIlIIIlIllllll;
        this.posZ1 = llllllllllllllIllllIlIIIlIlllllI;
        this.posX2 = llllllllllllllIllllIlIIIlIlIlIII + llllllllllllllIllllIlIIIlIllllIl;
        this.posY2 = llllllllllllllIllllIlIIIlIllllll + llllllllllllllIllllIlIIIlIllllII;
        this.posZ2 = llllllllllllllIllllIlIIIlIlllllI + llllllllllllllIllllIlIIIlIlllIll;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float llllllllllllllIllllIlIIIlIlllIII = llllllllllllllIllllIlIIIlIlIlIII + llllllllllllllIllllIlIIIlIllllIl;
        float llllllllllllllIllllIlIIIlIllIlll = llllllllllllllIllllIlIIIlIllllll + llllllllllllllIllllIlIIIlIllllII;
        float llllllllllllllIllllIlIIIlIllIllI = llllllllllllllIllllIlIIIlIlllllI + llllllllllllllIllllIlIIIlIlllIll;
        llllllllllllllIllllIlIIIlIlIlIII -= llllllllllllllIllllIlIIIlIlllIlI;
        llllllllllllllIllllIlIIIlIllllll -= llllllllllllllIllllIlIIIlIlllIlI;
        llllllllllllllIllllIlIIIlIlllllI -= llllllllllllllIllllIlIIIlIlllIlI;
        llllllllllllllIllllIlIIIlIlllIII += llllllllllllllIllllIlIIIlIlllIlI;
        llllllllllllllIllllIlIIIlIllIlll += llllllllllllllIllllIlIIIlIlllIlI;
        llllllllllllllIllllIlIIIlIllIllI += llllllllllllllIllllIlIIIlIlllIlI;
        if (llllllllllllllIllllIlIIIlIlIIIIl) {
            final float llllllllllllllIllllIlIIIlIllIlIl = llllllllllllllIllllIlIIIlIlllIII;
            llllllllllllllIllllIlIIIlIlllIII = llllllllllllllIllllIlIIIlIlIlIII;
            llllllllllllllIllllIlIIIlIlIlIII = llllllllllllllIllllIlIIIlIllIlIl;
        }
        final PositionTextureVertex llllllllllllllIllllIlIIIlIllIlII = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlIlIII, llllllllllllllIllllIlIIIlIllllll, llllllllllllllIllllIlIIIlIlllllI, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIllIIll = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlllIII, llllllllllllllIllllIlIIIlIllllll, llllllllllllllIllllIlIIIlIlllllI, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIllIIlI = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlllIII, llllllllllllllIllllIlIIIlIllIlll, llllllllllllllIllllIlIIIlIlllllI, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIllIIIl = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlIlIII, llllllllllllllIllllIlIIIlIllIlll, llllllllllllllIllllIlIIIlIlllllI, 8.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIllIIII = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlIlIII, llllllllllllllIllllIlIIIlIllllll, llllllllllllllIllllIlIIIlIllIllI, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIlIllll = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlllIII, llllllllllllllIllllIlIIIlIllllll, llllllllllllllIllllIlIIIlIllIllI, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIlIlllI = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlllIII, llllllllllllllIllllIlIIIlIllIlll, llllllllllllllIllllIlIIIlIllIllI, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIlIlIllIl = new PositionTextureVertex(llllllllllllllIllllIlIIIlIlIlIII, llllllllllllllIllllIlIIIlIllIlll, llllllllllllllIllllIlIIIlIllIllI, 8.0f, 0.0f);
        this.vertexPositions[0] = llllllllllllllIllllIlIIIlIllIlII;
        this.vertexPositions[1] = llllllllllllllIllllIlIIIlIllIIll;
        this.vertexPositions[2] = llllllllllllllIllllIlIIIlIllIIlI;
        this.vertexPositions[3] = llllllllllllllIllllIlIIIlIllIIIl;
        this.vertexPositions[4] = llllllllllllllIllllIlIIIlIllIIII;
        this.vertexPositions[5] = llllllllllllllIllllIlIIIlIlIllll;
        this.vertexPositions[6] = llllllllllllllIllllIlIIIlIlIlllI;
        this.vertexPositions[7] = llllllllllllllIllllIlIIIlIlIllIl;
        this.quadList[0] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIlIllll, llllllllllllllIllllIlIIIlIllIIll, llllllllllllllIllllIlIIIlIllIIlI, llllllllllllllIllllIlIIIlIlIlllI }, llllllllllllllIllllIlIIIllIIIIIl[4], false, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        this.quadList[1] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIllIlII, llllllllllllllIllllIlIIIlIllIIII, llllllllllllllIllllIlIIIlIlIllIl, llllllllllllllIllllIlIIIlIllIIIl }, llllllllllllllIllllIlIIIllIIIIIl[5], false, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        this.quadList[2] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIlIllll, llllllllllllllIllllIlIIIlIllIIII, llllllllllllllIllllIlIIIlIllIlII, llllllllllllllIllllIlIIIlIllIIll }, llllllllllllllIllllIlIIIllIIIIIl[1], true, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        this.quadList[3] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIllIIlI, llllllllllllllIllllIlIIIlIllIIIl, llllllllllllllIllllIlIIIlIlIllIl, llllllllllllllIllllIlIIIlIlIlllI }, llllllllllllllIllllIlIIIllIIIIIl[0], true, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        this.quadList[4] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIllIIll, llllllllllllllIllllIlIIIlIllIlII, llllllllllllllIllllIlIIIlIllIIIl, llllllllllllllIllllIlIIIlIllIIlI }, llllllllllllllIllllIlIIIllIIIIIl[2], false, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        this.quadList[5] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIlIllIIII, llllllllllllllIllllIlIIIlIlIllll, llllllllllllllIllllIlIIIlIlIlllI, llllllllllllllIllllIlIIIlIlIllIl }, llllllllllllllIllllIlIIIllIIIIIl[3], false, llllllllllllllIllllIlIIIlIlIlIlI.textureWidth, llllllllllllllIllllIlIIIlIlIlIlI.textureHeight);
        if (llllllllllllllIllllIlIIIlIlIIIIl) {
            final boolean llllllllllllllIllllIlIIIlIIlIIlI;
            final String llllllllllllllIllllIlIIIlIIlIIll = (String)((TexturedQuad[])(Object)(llllllllllllllIllllIlIIIlIIlIIlI = (boolean)(Object)this.quadList)).length;
            for (byte llllllllllllllIllllIlIIIlIIlIlII = 0; llllllllllllllIllllIlIIIlIIlIlII < llllllllllllllIllllIlIIIlIIlIIll; ++llllllllllllllIllllIlIIIlIIlIlII) {
                final TexturedQuad llllllllllllllIllllIlIIIlIlIllII = llllllllllllllIllllIlIIIlIIlIIlI[llllllllllllllIllllIlIIIlIIlIlII];
                llllllllllllllIllllIlIIIlIlIllII.flipFace();
            }
        }
    }
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIlIIIIllIIlIl, final int llllllllllllllIllllIlIIIIllIIlII, final int llllllllllllllIllllIlIIIIlIIlIlI, float llllllllllllllIllllIlIIIIlIIlIIl, float llllllllllllllIllllIlIIIIlIIlIII, float llllllllllllllIllllIlIIIIllIIIII, final int llllllllllllllIllllIlIIIIlIlllll, final int llllllllllllllIllllIlIIIIlIIIlIl, final int llllllllllllllIllllIlIIIIlIlllIl, final float llllllllllllllIllllIlIIIIlIlllII, final boolean llllllllllllllIllllIlIIIIlIllIll) {
        this.posX1 = llllllllllllllIllllIlIIIIlIIlIIl;
        this.posY1 = llllllllllllllIllllIlIIIIlIIlIII;
        this.posZ1 = llllllllllllllIllllIlIIIIllIIIII;
        this.posX2 = llllllllllllllIllllIlIIIIlIIlIIl + llllllllllllllIllllIlIIIIlIlllll;
        this.posY2 = llllllllllllllIllllIlIIIIlIIlIII + llllllllllllllIllllIlIIIIlIIIlIl;
        this.posZ2 = llllllllllllllIllllIlIIIIllIIIII + llllllllllllllIllllIlIIIIlIlllIl;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float llllllllllllllIllllIlIIIIlIllIlI = llllllllllllllIllllIlIIIIlIIlIIl + llllllllllllllIllllIlIIIIlIlllll;
        float llllllllllllllIllllIlIIIIlIllIIl = llllllllllllllIllllIlIIIIlIIlIII + llllllllllllllIllllIlIIIIlIIIlIl;
        float llllllllllllllIllllIlIIIIlIllIII = llllllllllllllIllllIlIIIIllIIIII + llllllllllllllIllllIlIIIIlIlllIl;
        llllllllllllllIllllIlIIIIlIIlIIl -= llllllllllllllIllllIlIIIIlIlllII;
        llllllllllllllIllllIlIIIIlIIlIII -= llllllllllllllIllllIlIIIIlIlllII;
        llllllllllllllIllllIlIIIIllIIIII -= llllllllllllllIllllIlIIIIlIlllII;
        llllllllllllllIllllIlIIIIlIllIlI += llllllllllllllIllllIlIIIIlIlllII;
        llllllllllllllIllllIlIIIIlIllIIl += llllllllllllllIllllIlIIIIlIlllII;
        llllllllllllllIllllIlIIIIlIllIII += llllllllllllllIllllIlIIIIlIlllII;
        if (llllllllllllllIllllIlIIIIlIllIll) {
            final float llllllllllllllIllllIlIIIIlIlIlll = llllllllllllllIllllIlIIIIlIllIlI;
            llllllllllllllIllllIlIIIIlIllIlI = llllllllllllllIllllIlIIIIlIIlIIl;
            llllllllllllllIllllIlIIIIlIIlIIl = llllllllllllllIllllIlIIIIlIlIlll;
        }
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIllI = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIIlIIl, llllllllllllllIllllIlIIIIlIIlIII, llllllllllllllIllllIlIIIIllIIIII, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIlIl = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIllIlI, llllllllllllllIllllIlIIIIlIIlIII, llllllllllllllIllllIlIIIIllIIIII, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIlII = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIllIlI, llllllllllllllIllllIlIIIIlIllIIl, llllllllllllllIllllIlIIIIllIIIII, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIIll = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIIlIIl, llllllllllllllIllllIlIIIIlIllIIl, llllllllllllllIllllIlIIIIllIIIII, 8.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIIlI = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIIlIIl, llllllllllllllIllllIlIIIIlIIlIII, llllllllllllllIllllIlIIIIlIllIII, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIIIl = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIllIlI, llllllllllllllIllllIlIIIIlIIlIII, llllllllllllllIllllIlIIIIlIllIII, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIlIIII = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIllIlI, llllllllllllllIllllIlIIIIlIllIIl, llllllllllllllIllllIlIIIIlIllIII, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIlIIIIlIIllll = new PositionTextureVertex(llllllllllllllIllllIlIIIIlIIlIIl, llllllllllllllIllllIlIIIIlIllIIl, llllllllllllllIllllIlIIIIlIllIII, 8.0f, 0.0f);
        this.vertexPositions[0] = llllllllllllllIllllIlIIIIlIlIllI;
        this.vertexPositions[1] = llllllllllllllIllllIlIIIIlIlIlIl;
        this.vertexPositions[2] = llllllllllllllIllllIlIIIIlIlIlII;
        this.vertexPositions[3] = llllllllllllllIllllIlIIIIlIlIIll;
        this.vertexPositions[4] = llllllllllllllIllllIlIIIIlIlIIlI;
        this.vertexPositions[5] = llllllllllllllIllllIlIIIIlIlIIIl;
        this.vertexPositions[6] = llllllllllllllIllllIlIIIIlIlIIII;
        this.vertexPositions[7] = llllllllllllllIllllIlIIIIlIIllll;
        this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIIIl, llllllllllllllIllllIlIIIIlIlIlIl, llllllllllllllIllllIlIIIIlIlIlII, llllllllllllllIllllIlIIIIlIlIIII }, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIIIlIl, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIllI, llllllllllllllIllllIlIIIIlIlIIlI, llllllllllllllIllllIlIIIIlIIllll, llllllllllllllIllllIlIIIIlIlIIll }, llllllllllllllIllllIlIIIIllIIlII, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIIIlIl, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIIIl, llllllllllllllIllllIlIIIIlIlIIlI, llllllllllllllIllllIlIIIIlIlIllI, llllllllllllllIllllIlIIIIlIlIlIl }, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIlIIlIlI, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIlII, llllllllllllllIllllIlIIIIlIlIIll, llllllllllllllIllllIlIIIIlIIllll, llllllllllllllIllllIlIIIIlIlIIII }, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIlIl, llllllllllllllIllllIlIIIIlIlIllI, llllllllllllllIllllIlIIIIlIlIIll, llllllllllllllIllllIlIIIIlIlIlII }, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIIIlIl, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIlIIIIlIlIIlI, llllllllllllllIllllIlIIIIlIlIIIl, llllllllllllllIllllIlIIIIlIlIIII, llllllllllllllIllllIlIIIIlIIllll }, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl, llllllllllllllIllllIlIIIIllIIlII + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIlllll, llllllllllllllIllllIlIIIIlIIlIlI + llllllllllllllIllllIlIIIIlIlllIl + llllllllllllllIllllIlIIIIlIIIlIl, llllllllllllllIllllIlIIIIllIIlIl.textureWidth, llllllllllllllIllllIlIIIIllIIlIl.textureHeight);
        if (llllllllllllllIllllIlIIIIlIllIll) {
            final int llllllllllllllIllllIlIIIIIllIIll;
            final int llllllllllllllIllllIlIIIIIllIlII = ((TexturedQuad[])(Object)(llllllllllllllIllllIlIIIIIllIIll = (int)(Object)this.quadList)).length;
            for (Exception llllllllllllllIllllIlIIIIIllIlIl = (Exception)0; llllllllllllllIllllIlIIIIIllIlIl < llllllllllllllIllllIlIIIIIllIlII; ++llllllllllllllIllllIlIIIIIllIlIl) {
                final TexturedQuad llllllllllllllIllllIlIIIIlIIlllI = llllllllllllllIllllIlIIIIIllIIll[llllllllllllllIllllIlIIIIIllIlIl];
                llllllllllllllIllllIlIIIIlIIlllI.flipFace();
            }
        }
    }
}
