// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelEnderMite extends ModelBase
{
    private static final /* synthetic */ int[][] BODY_SIZES;
    private final /* synthetic */ ModelRenderer[] bodyParts;
    private static final /* synthetic */ int BODY_COUNT;
    private static final /* synthetic */ int[][] BODY_TEXS;
    
    public ModelEnderMite() {
        this.bodyParts = new ModelRenderer[ModelEnderMite.BODY_COUNT];
        float llllllllllllIllllIIIlllIIIlIIIIl = -3.5f;
        for (int llllllllllllIllllIIIlllIIIlIIIII = 0; llllllllllllIllllIIIlllIIIlIIIII < this.bodyParts.length; ++llllllllllllIllllIIIlllIIIlIIIII) {
            (this.bodyParts[llllllllllllIllllIIIlllIIIlIIIII] = new ModelRenderer(this, ModelEnderMite.BODY_TEXS[llllllllllllIllllIIIlllIIIlIIIII][0], ModelEnderMite.BODY_TEXS[llllllllllllIllllIIIlllIIIlIIIII][1])).addBox(ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][0] * -0.5f, 0.0f, ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][2] * -0.5f, ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][0], ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][1], ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][2]);
            this.bodyParts[llllllllllllIllllIIIlllIIIlIIIII].setRotationPoint(0.0f, (float)(24 - ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][1]), llllllllllllIllllIIIlllIIIlIIIIl);
            if (llllllllllllIllllIIIlllIIIlIIIII < this.bodyParts.length - 1) {
                llllllllllllIllllIIIlllIIIlIIIIl += (ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII][2] + ModelEnderMite.BODY_SIZES[llllllllllllIllllIIIlllIIIlIIIII + 1][2]) * 0.5f;
            }
        }
    }
    
    @Override
    public void render(final Entity llllllllllllIllllIIIlllIIIIIllll, final float llllllllllllIllllIIIlllIIIIIIlIl, final float llllllllllllIllllIIIlllIIIIIllIl, final float llllllllllllIllllIIIlllIIIIIIIll, final float llllllllllllIllllIIIlllIIIIIlIll, final float llllllllllllIllllIIIlllIIIIIIIIl, final float llllllllllllIllllIIIlllIIIIIIIII) {
        this.setRotationAngles(llllllllllllIllllIIIlllIIIIIIlIl, llllllllllllIllllIIIlllIIIIIllIl, llllllllllllIllllIIIlllIIIIIIIll, llllllllllllIllllIIIlllIIIIIlIll, llllllllllllIllllIIIlllIIIIIIIIl, llllllllllllIllllIIIlllIIIIIIIII, llllllllllllIllllIIIlllIIIIIllll);
        final boolean llllllllllllIllllIIIllIlllllllII;
        final long llllllllllllIllllIIIllIlllllllIl = ((ModelRenderer[])(Object)(llllllllllllIllllIIIllIlllllllII = (boolean)(Object)this.bodyParts)).length;
        for (final ModelRenderer llllllllllllIllllIIIlllIIIIIlIII : llllllllllllIllllIIIllIlllllllII) {
            llllllllllllIllllIIIlllIIIIIlIII.render(llllllllllllIllllIIIlllIIIIIIIII);
        }
    }
    
    static {
        BODY_SIZES = new int[][] { { 4, 3, 2 }, { 6, 4, 5 }, { 3, 3, 1 }, { 1, 2, 1 } };
        BODY_TEXS = new int[][] { new int[2], { 0, 5 }, { 0, 14 }, { 0, 18 } };
        BODY_COUNT = ModelEnderMite.BODY_SIZES.length;
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIllllIIIllIlllllIlll, final float llllllllllllIllllIIIllIlllllIllI, final float llllllllllllIllllIIIllIlllllIlIl, final float llllllllllllIllllIIIllIlllllIlII, final float llllllllllllIllllIIIllIlllllIIll, final float llllllllllllIllllIIIllIlllllIIlI, final Entity llllllllllllIllllIIIllIlllllIIIl) {
        for (int llllllllllllIllllIIIllIlllllIIII = 0; llllllllllllIllllIIIllIlllllIIII < this.bodyParts.length; ++llllllllllllIllllIIIllIlllllIIII) {
            this.bodyParts[llllllllllllIllllIIIllIlllllIIII].rotateAngleY = MathHelper.cos(llllllllllllIllllIIIllIlllllIlIl * 0.9f + llllllllllllIllllIIIllIlllllIIII * 0.15f * 3.1415927f) * 3.1415927f * 0.01f * (1 + Math.abs(llllllllllllIllllIIIllIlllllIIII - 2));
            this.bodyParts[llllllllllllIllllIIIllIlllllIIII].rotationPointX = MathHelper.sin(llllllllllllIllllIIIllIlllllIlIl * 0.9f + llllllllllllIllllIIIllIlllllIIII * 0.15f * 3.1415927f) * 3.1415927f * 0.1f * Math.abs(llllllllllllIllllIIIllIlllllIIII - 2);
        }
    }
}
