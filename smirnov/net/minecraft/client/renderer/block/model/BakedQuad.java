// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraftforge.client.model.pipeline.IVertexConsumer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import optifine.Reflector;
import net.minecraft.client.Minecraft;
import optifine.Config;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import optifine.QuadBounds;
import net.minecraftforge.client.model.pipeline.IVertexProducer;

public class BakedQuad implements IVertexProducer
{
    protected final /* synthetic */ int tintIndex;
    protected /* synthetic */ boolean applyDiffuseLighting;
    private /* synthetic */ QuadBounds quadBounds;
    private /* synthetic */ int[] vertexDataSingle;
    protected /* synthetic */ VertexFormat format;
    protected /* synthetic */ TextureAtlasSprite sprite;
    protected /* synthetic */ int[] vertexData;
    protected /* synthetic */ EnumFacing face;
    
    @Override
    public String toString() {
        return "vertex: " + this.vertexData.length / 7 + ", tint: " + this.tintIndex + ", facing: " + this.face + ", sprite: " + this.sprite;
    }
    
    private static int[] expandVertexData(final int[] lllllllllllIIIIIIlIIlIlIlllIIlII) {
        final int lllllllllllIIIIIIlIIlIlIlllIIIll = lllllllllllIIIIIIlIIlIlIlllIIlII.length / 4;
        final int lllllllllllIIIIIIlIIlIlIlllIIIlI = lllllllllllIIIIIIlIIlIlIlllIIIll * 2;
        final int[] lllllllllllIIIIIIlIIlIlIlllIIIIl = new int[lllllllllllIIIIIIlIIlIlIlllIIIlI * 4];
        for (int lllllllllllIIIIIIlIIlIlIlllIIIII = 0; lllllllllllIIIIIIlIIlIlIlllIIIII < 4; ++lllllllllllIIIIIIlIIlIlIlllIIIII) {
            System.arraycopy(lllllllllllIIIIIIlIIlIlIlllIIlII, lllllllllllIIIIIIlIIlIlIlllIIIII * lllllllllllIIIIIIlIIlIlIlllIIIll, lllllllllllIIIIIIlIIlIlIlllIIIIl, lllllllllllIIIIIIlIIlIlIlllIIIII * lllllllllllIIIIIIlIIlIlIlllIIIlI, lllllllllllIIIIIIlIIlIlIlllIIIll);
        }
        return lllllllllllIIIIIIlIIlIlIlllIIIIl;
    }
    
    public VertexFormat getFormat() {
        return this.format;
    }
    
    public QuadBounds getQuadBounds() {
        if (this.quadBounds == null) {
            this.quadBounds = new QuadBounds(this.getVertexData());
        }
        return this.quadBounds;
    }
    
    public boolean shouldApplyDiffuseLighting() {
        return this.applyDiffuseLighting;
    }
    
    public int[] getVertexDataSingle() {
        if (this.vertexDataSingle == null) {
            this.vertexDataSingle = makeVertexDataSingle(this.getVertexData(), this.getSprite());
        }
        return this.vertexDataSingle;
    }
    
    protected void fixVertexData() {
        if (Config.isShaders()) {
            if (this.vertexData.length == 28) {
                this.vertexData = expandVertexData(this.vertexData);
            }
        }
        else if (this.vertexData.length == 56) {
            this.vertexData = compactVertexData(this.vertexData);
        }
    }
    
    public double getMidY() {
        final QuadBounds lllllllllllIIIIIIlIIlIlIlIllllll = this.getQuadBounds();
        return (lllllllllllIIIIIIlIIlIlIlIllllll.getMaxY() + lllllllllllIIIIIIlIIlIlIlIllllll.getMinY()) / 2.0f;
    }
    
    public int getTintIndex() {
        return this.tintIndex;
    }
    
    public EnumFacing getFace() {
        if (this.face == null) {
            this.face = FaceBakery.getFacingFromVertexData(this.getVertexData());
        }
        return this.face;
    }
    
    public TextureAtlasSprite getSprite() {
        if (this.sprite == null) {
            this.sprite = getSpriteByUv(this.getVertexData());
        }
        return this.sprite;
    }
    
    private static int[] makeVertexDataSingle(final int[] lllllllllllIIIIIIlIIlIllIIlIIlIl, final TextureAtlasSprite lllllllllllIIIIIIlIIlIllIIlIIlII) {
        final int[] lllllllllllIIIIIIlIIlIllIIlIllll = lllllllllllIIIIIIlIIlIllIIlIIlIl.clone();
        final int lllllllllllIIIIIIlIIlIllIIlIlllI = lllllllllllIIIIIIlIIlIllIIlIIlII.sheetWidth / lllllllllllIIIIIIlIIlIllIIlIIlII.getIconWidth();
        final int lllllllllllIIIIIIlIIlIllIIlIllIl = lllllllllllIIIIIIlIIlIllIIlIIlII.sheetHeight / lllllllllllIIIIIIlIIlIllIIlIIlII.getIconHeight();
        final int lllllllllllIIIIIIlIIlIllIIlIllII = lllllllllllIIIIIIlIIlIllIIlIllll.length / 4;
        for (int lllllllllllIIIIIIlIIlIllIIlIlIll = 0; lllllllllllIIIIIIlIIlIllIIlIlIll < 4; ++lllllllllllIIIIIIlIIlIllIIlIlIll) {
            final int lllllllllllIIIIIIlIIlIllIIlIlIlI = lllllllllllIIIIIIlIIlIllIIlIlIll * lllllllllllIIIIIIlIIlIllIIlIllII;
            final float lllllllllllIIIIIIlIIlIllIIlIlIIl = Float.intBitsToFloat(lllllllllllIIIIIIlIIlIllIIlIllll[lllllllllllIIIIIIlIIlIllIIlIlIlI + 4]);
            final float lllllllllllIIIIIIlIIlIllIIlIlIII = Float.intBitsToFloat(lllllllllllIIIIIIlIIlIllIIlIllll[lllllllllllIIIIIIlIIlIllIIlIlIlI + 4 + 1]);
            final float lllllllllllIIIIIIlIIlIllIIlIIlll = lllllllllllIIIIIIlIIlIllIIlIIlII.toSingleU(lllllllllllIIIIIIlIIlIllIIlIlIIl);
            final float lllllllllllIIIIIIlIIlIllIIlIIllI = lllllllllllIIIIIIlIIlIllIIlIIlII.toSingleV(lllllllllllIIIIIIlIIlIllIIlIlIII);
            lllllllllllIIIIIIlIIlIllIIlIllll[lllllllllllIIIIIIlIIlIllIIlIlIlI + 4] = Float.floatToRawIntBits(lllllllllllIIIIIIlIIlIllIIlIIlll);
            lllllllllllIIIIIIlIIlIllIIlIllll[lllllllllllIIIIIIlIIlIllIIlIlIlI + 4 + 1] = Float.floatToRawIntBits(lllllllllllIIIIIIlIIlIllIIlIIllI);
        }
        return lllllllllllIIIIIIlIIlIllIIlIllll;
    }
    
    public float getMidX() {
        final QuadBounds lllllllllllIIIIIIlIIlIlIllIIIlIl = this.getQuadBounds();
        return (lllllllllllIIIIIIlIIlIlIllIIIlIl.getMaxX() + lllllllllllIIIIIIlIIlIlIllIIIlIl.getMinX()) / 2.0f;
    }
    
    private static TextureAtlasSprite getSpriteByUv(final int[] lllllllllllIIIIIIlIIlIlIllllIllI) {
        float lllllllllllIIIIIIlIIlIllIIIIIIlI = 1.0f;
        float lllllllllllIIIIIIlIIlIllIIIIIIIl = 1.0f;
        float lllllllllllIIIIIIlIIlIllIIIIIIII = 0.0f;
        float lllllllllllIIIIIIlIIlIlIllllllll = 0.0f;
        final int lllllllllllIIIIIIlIIlIlIlllllllI = lllllllllllIIIIIIlIIlIlIllllIllI.length / 4;
        for (int lllllllllllIIIIIIlIIlIlIllllllIl = 0; lllllllllllIIIIIIlIIlIlIllllllIl < 4; ++lllllllllllIIIIIIlIIlIlIllllllIl) {
            final int lllllllllllIIIIIIlIIlIlIllllllII = lllllllllllIIIIIIlIIlIlIllllllIl * lllllllllllIIIIIIlIIlIlIlllllllI;
            final float lllllllllllIIIIIIlIIlIlIlllllIll = Float.intBitsToFloat(lllllllllllIIIIIIlIIlIlIllllIllI[lllllllllllIIIIIIlIIlIlIllllllII + 4]);
            final float lllllllllllIIIIIIlIIlIlIlllllIlI = Float.intBitsToFloat(lllllllllllIIIIIIlIIlIlIllllIllI[lllllllllllIIIIIIlIIlIlIllllllII + 4 + 1]);
            lllllllllllIIIIIIlIIlIllIIIIIIlI = Math.min(lllllllllllIIIIIIlIIlIllIIIIIIlI, lllllllllllIIIIIIlIIlIlIlllllIll);
            lllllllllllIIIIIIlIIlIllIIIIIIIl = Math.min(lllllllllllIIIIIIlIIlIllIIIIIIIl, lllllllllllIIIIIIlIIlIlIlllllIlI);
            lllllllllllIIIIIIlIIlIllIIIIIIII = Math.max(lllllllllllIIIIIIlIIlIllIIIIIIII, lllllllllllIIIIIIlIIlIlIlllllIll);
            lllllllllllIIIIIIlIIlIlIllllllll = Math.max(lllllllllllIIIIIIlIIlIlIllllllll, lllllllllllIIIIIIlIIlIlIlllllIlI);
        }
        final float lllllllllllIIIIIIlIIlIlIlllllIIl = (lllllllllllIIIIIIlIIlIllIIIIIIlI + lllllllllllIIIIIIlIIlIllIIIIIIII) / 2.0f;
        final float lllllllllllIIIIIIlIIlIlIlllllIII = (lllllllllllIIIIIIlIIlIllIIIIIIIl + lllllllllllIIIIIIlIIlIlIllllllll) / 2.0f;
        final TextureAtlasSprite lllllllllllIIIIIIlIIlIlIllllIlll = Minecraft.getMinecraft().getTextureMapBlocks().getIconByUV(lllllllllllIIIIIIlIIlIlIlllllIIl, lllllllllllIIIIIIlIIlIlIlllllIII);
        return lllllllllllIIIIIIlIIlIlIllllIlll;
    }
    
    public BakedQuad(final int[] lllllllllllIIIIIIlIIlIllIlIlIIll, final int lllllllllllIIIIIIlIIlIllIlIlIlll, final EnumFacing lllllllllllIIIIIIlIIlIllIlIlIllI, final TextureAtlasSprite lllllllllllIIIIIIlIIlIllIlIlIIII) {
        this.vertexDataSingle = null;
        this.applyDiffuseLighting = Reflector.ForgeHooksClient_fillNormal.exists();
        this.format = DefaultVertexFormats.ITEM;
        this.vertexData = lllllllllllIIIIIIlIIlIllIlIlIIll;
        this.tintIndex = lllllllllllIIIIIIlIIlIllIlIlIlll;
        this.face = lllllllllllIIIIIIlIIlIllIlIlIllI;
        this.sprite = lllllllllllIIIIIIlIIlIllIlIlIIII;
        this.fixVertexData();
    }
    
    @Override
    public void pipe(final IVertexConsumer lllllllllllIIIIIIlIIlIllIIIlIllI) {
        Reflector.callVoid(Reflector.LightUtil_putBakedQuad, new Object[] { lllllllllllIIIIIIlIIlIllIIIlIllI, this });
    }
    
    public boolean hasTintIndex() {
        return this.tintIndex != -1;
    }
    
    public double getMidZ() {
        final QuadBounds lllllllllllIIIIIIlIIlIlIlIlllIIl = this.getQuadBounds();
        return (lllllllllllIIIIIIlIIlIlIlIlllIIl.getMaxZ() + lllllllllllIIIIIIlIIlIlIlIlllIIl.getMinZ()) / 2.0f;
    }
    
    public boolean isFaceQuad() {
        final QuadBounds lllllllllllIIIIIIlIIlIlIlIllIIll = this.getQuadBounds();
        return lllllllllllIIIIIIlIIlIlIlIllIIll.isFaceQuad(this.face);
    }
    
    public int[] getVertexData() {
        this.fixVertexData();
        return this.vertexData;
    }
    
    public boolean isFullQuad() {
        final QuadBounds lllllllllllIIIIIIlIIlIlIlIlIllIl = this.getQuadBounds();
        return lllllllllllIIIIIIlIIlIlIlIlIllIl.isFullQuad(this.face);
    }
    
    public boolean isFullFaceQuad() {
        return this.isFullQuad() && this.isFaceQuad();
    }
    
    private static int[] compactVertexData(final int[] lllllllllllIIIIIIlIIlIlIllIlIIII) {
        final int lllllllllllIIIIIIlIIlIlIllIlIlII = lllllllllllIIIIIIlIIlIlIllIlIIII.length / 4;
        final int lllllllllllIIIIIIlIIlIlIllIlIIll = lllllllllllIIIIIIlIIlIlIllIlIlII / 2;
        final int[] lllllllllllIIIIIIlIIlIlIllIlIIlI = new int[lllllllllllIIIIIIlIIlIlIllIlIIll * 4];
        for (int lllllllllllIIIIIIlIIlIlIllIlIIIl = 0; lllllllllllIIIIIIlIIlIlIllIlIIIl < 4; ++lllllllllllIIIIIIlIIlIlIllIlIIIl) {
            System.arraycopy(lllllllllllIIIIIIlIIlIlIllIlIIII, lllllllllllIIIIIIlIIlIlIllIlIIIl * lllllllllllIIIIIIlIIlIlIllIlIlII, lllllllllllIIIIIIlIIlIlIllIlIIlI, lllllllllllIIIIIIlIIlIlIllIlIIIl * lllllllllllIIIIIIlIIlIlIllIlIIll, lllllllllllIIIIIIlIIlIlIllIlIIll);
        }
        return lllllllllllIIIIIIlIIlIlIllIlIIlI;
    }
    
    public BakedQuad(final int[] lllllllllllIIIIIIlIIlIllIllIlIll, final int lllllllllllIIIIIIlIIlIllIllIlIlI, final EnumFacing lllllllllllIIIIIIlIIlIllIllIIIlI, final TextureAtlasSprite lllllllllllIIIIIIlIIlIllIllIlIII, final boolean lllllllllllIIIIIIlIIlIllIllIIIII, final VertexFormat lllllllllllIIIIIIlIIlIllIlIlllll) {
        this.vertexDataSingle = null;
        this.applyDiffuseLighting = Reflector.ForgeHooksClient_fillNormal.exists();
        this.format = DefaultVertexFormats.ITEM;
        this.vertexData = lllllllllllIIIIIIlIIlIllIllIlIll;
        this.tintIndex = lllllllllllIIIIIIlIIlIllIllIlIlI;
        this.face = lllllllllllIIIIIIlIIlIllIllIIIlI;
        this.sprite = lllllllllllIIIIIIlIIlIllIllIlIII;
        this.applyDiffuseLighting = lllllllllllIIIIIIlIIlIllIllIIIII;
        this.format = lllllllllllIIIIIIlIIlIllIlIlllll;
        this.fixVertexData();
    }
}
