// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelWither extends ModelBase
{
    private final /* synthetic */ ModelRenderer[] upperBodyParts;
    private final /* synthetic */ ModelRenderer[] heads;
    
    @Override
    public void render(final Entity lllllllllllllIIlllIllllllIlIIlII, final float lllllllllllllIIlllIllllllIIllIIl, final float lllllllllllllIIlllIllllllIlIIIlI, final float lllllllllllllIIlllIllllllIlIIIIl, final float lllllllllllllIIlllIllllllIIlIllI, final float lllllllllllllIIlllIllllllIIlIlIl, final float lllllllllllllIIlllIllllllIIllllI) {
        this.setRotationAngles(lllllllllllllIIlllIllllllIIllIIl, lllllllllllllIIlllIllllllIlIIIlI, lllllllllllllIIlllIllllllIlIIIIl, lllllllllllllIIlllIllllllIIlIllI, lllllllllllllIIlllIllllllIIlIlIl, lllllllllllllIIlllIllllllIIllllI, lllllllllllllIIlllIllllllIlIIlII);
        String lllllllllllllIIlllIllllllIIlIIII;
        boolean lllllllllllllIIlllIllllllIIlIIIl = ((ModelRenderer[])(Object)(lllllllllllllIIlllIllllllIIlIIII = (String)(Object)this.heads)).length != 0;
        for (float lllllllllllllIIlllIllllllIIlIIlI = 0; lllllllllllllIIlllIllllllIIlIIlI < (lllllllllllllIIlllIllllllIIlIIIl ? 1 : 0); ++lllllllllllllIIlllIllllllIIlIIlI) {
            final ModelRenderer lllllllllllllIIlllIllllllIIlllIl = lllllllllllllIIlllIllllllIIlIIII[lllllllllllllIIlllIllllllIIlIIlI];
            lllllllllllllIIlllIllllllIIlllIl.render(lllllllllllllIIlllIllllllIIllllI);
        }
        lllllllllllllIIlllIllllllIIlIIIl = (((ModelRenderer[])(Object)(lllllllllllllIIlllIllllllIIlIIII = (String)(Object)this.upperBodyParts)).length != 0);
        for (float lllllllllllllIIlllIllllllIIlIIlI = 0; lllllllllllllIIlllIllllllIIlIIlI < (lllllllllllllIIlllIllllllIIlIIIl ? 1 : 0); ++lllllllllllllIIlllIllllllIIlIIlI) {
            final ModelRenderer lllllllllllllIIlllIllllllIIlllII = lllllllllllllIIlllIllllllIIlIIII[lllllllllllllIIlllIllllllIIlIIlI];
            lllllllllllllIIlllIllllllIIlllII.render(lllllllllllllIIlllIllllllIIllllI);
        }
    }
    
    public ModelWither(final float lllllllllllllIIlllIllllllIllIIlI) {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.upperBodyParts = new ModelRenderer[3];
        (this.upperBodyParts[0] = new ModelRenderer(this, 0, 16)).addBox(-10.0f, 3.9f, -0.5f, 20, 3, 3, lllllllllllllIIlllIllllllIllIIlI);
        (this.upperBodyParts[1] = new ModelRenderer(this).setTextureSize(this.textureWidth, this.textureHeight)).setRotationPoint(-2.0f, 6.9f, -0.5f);
        this.upperBodyParts[1].setTextureOffset(0, 22).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3, lllllllllllllIIlllIllllllIllIIlI);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 1.5f, 0.5f, 11, 2, 2, lllllllllllllIIlllIllllllIllIIlI);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 4.0f, 0.5f, 11, 2, 2, lllllllllllllIIlllIllllllIllIIlI);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 6.5f, 0.5f, 11, 2, 2, lllllllllllllIIlllIllllllIllIIlI);
        (this.upperBodyParts[2] = new ModelRenderer(this, 12, 22)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 3, lllllllllllllIIlllIllllllIllIIlI);
        this.heads = new ModelRenderer[3];
        (this.heads[0] = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, lllllllllllllIIlllIllllllIllIIlI);
        (this.heads[1] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, lllllllllllllIIlllIllllllIllIIlI);
        this.heads[1].rotationPointX = -8.0f;
        this.heads[1].rotationPointY = 4.0f;
        (this.heads[2] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, lllllllllllllIIlllIllllllIllIIlI);
        this.heads[2].rotationPointX = 10.0f;
        this.heads[2].rotationPointY = 4.0f;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIIlllIlllllIlllIIII, final float lllllllllllllIIlllIlllllIlllIllI, final float lllllllllllllIIlllIlllllIlllIlIl, final float lllllllllllllIIlllIlllllIlllIlII) {
        final EntityWither lllllllllllllIIlllIlllllIlllIIll = (EntityWither)lllllllllllllIIlllIlllllIlllIIII;
        for (int lllllllllllllIIlllIlllllIlllIIlI = 1; lllllllllllllIIlllIlllllIlllIIlI < 3; ++lllllllllllllIIlllIlllllIlllIIlI) {
            this.heads[lllllllllllllIIlllIlllllIlllIIlI].rotateAngleY = (lllllllllllllIIlllIlllllIlllIIll.getHeadYRotation(lllllllllllllIIlllIlllllIlllIIlI - 1) - lllllllllllllIIlllIlllllIlllIIII.renderYawOffset) * 0.017453292f;
            this.heads[lllllllllllllIIlllIlllllIlllIIlI].rotateAngleX = lllllllllllllIIlllIlllllIlllIIll.getHeadXRotation(lllllllllllllIIlllIlllllIlllIIlI - 1) * 0.017453292f;
        }
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIlllIllllllIIIlIIl, final float lllllllllllllIIlllIllllllIIIlIII, final float lllllllllllllIIlllIllllllIIIIlll, final float lllllllllllllIIlllIlllllIlllllll, final float lllllllllllllIIlllIlllllIllllllI, final float lllllllllllllIIlllIllllllIIIIlII, final Entity lllllllllllllIIlllIllllllIIIIIll) {
        final float lllllllllllllIIlllIllllllIIIIIlI = MathHelper.cos(lllllllllllllIIlllIllllllIIIIlll * 0.1f);
        this.upperBodyParts[1].rotateAngleX = (0.065f + 0.05f * lllllllllllllIIlllIllllllIIIIIlI) * 3.1415927f;
        this.upperBodyParts[2].setRotationPoint(-2.0f, 6.9f + MathHelper.cos(this.upperBodyParts[1].rotateAngleX) * 10.0f, -0.5f + MathHelper.sin(this.upperBodyParts[1].rotateAngleX) * 10.0f);
        this.upperBodyParts[2].rotateAngleX = (0.265f + 0.1f * lllllllllllllIIlllIllllllIIIIIlI) * 3.1415927f;
        this.heads[0].rotateAngleY = lllllllllllllIIlllIlllllIlllllll * 0.017453292f;
        this.heads[0].rotateAngleX = lllllllllllllIIlllIlllllIllllllI * 0.017453292f;
    }
}
