// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import java.util.Arrays;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class BakedQuadRetextured extends BakedQuad
{
    private final /* synthetic */ TextureAtlasSprite spriteOld;
    private final /* synthetic */ TextureAtlasSprite texture;
    
    public BakedQuadRetextured(final BakedQuad lllllllllllIIIlIIllllllllllIllII, final TextureAtlasSprite lllllllllllIIIlIIllllllllllIlIll) {
        super(Arrays.copyOf(lllllllllllIIIlIIllllllllllIllII.getVertexData(), lllllllllllIIIlIIllllllllllIllII.getVertexData().length), lllllllllllIIIlIIllllllllllIllII.tintIndex, FaceBakery.getFacingFromVertexData(lllllllllllIIIlIIllllllllllIllII.getVertexData()), lllllllllllIIIlIIllllllllllIlIll);
        this.texture = lllllllllllIIIlIIllllllllllIlIll;
        this.format = lllllllllllIIIlIIllllllllllIllII.format;
        this.applyDiffuseLighting = lllllllllllIIIlIIllllllllllIllII.applyDiffuseLighting;
        this.spriteOld = lllllllllllIIIlIIllllllllllIllII.getSprite();
        this.remapQuad();
        this.fixVertexData();
    }
    
    private void remapQuad() {
        for (int lllllllllllIIIlIIllllllllllIIIlI = 0; lllllllllllIIIlIIllllllllllIIIlI < 4; ++lllllllllllIIIlIIllllllllllIIIlI) {
            final int lllllllllllIIIlIIllllllllllIIIIl = this.format.getIntegerSize() * lllllllllllIIIlIIllllllllllIIIlI;
            final int lllllllllllIIIlIIllllllllllIIIII = this.format.getUvOffsetById(0) / 4;
            this.vertexData[lllllllllllIIIlIIllllllllllIIIIl + lllllllllllIIIlIIllllllllllIIIII] = Float.floatToRawIntBits(this.texture.getInterpolatedU(this.spriteOld.getUnInterpolatedU(Float.intBitsToFloat(this.vertexData[lllllllllllIIIlIIllllllllllIIIIl + lllllllllllIIIlIIllllllllllIIIII]))));
            this.vertexData[lllllllllllIIIlIIllllllllllIIIIl + lllllllllllIIIlIIllllllllllIIIII + 1] = Float.floatToRawIntBits(this.texture.getInterpolatedV(this.spriteOld.getUnInterpolatedV(Float.intBitsToFloat(this.vertexData[lllllllllllIIIlIIllllllllllIIIIl + lllllllllllIIIlIIllllllllllIIIII + 1]))));
        }
    }
}
