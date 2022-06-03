// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelPolarBear extends ModelQuadruped
{
    public ModelPolarBear() {
        super(12, 0.0f);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.5f, -3.0f, -3.0f, 7, 7, 7, 0.0f);
        this.head.setRotationPoint(0.0f, 10.0f, -16.0f);
        this.head.setTextureOffset(0, 44).addBox(-2.5f, 1.0f, -6.0f, 5, 3, 3, 0.0f);
        this.head.setTextureOffset(26, 0).addBox(-4.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        final ModelRenderer llllllllllllllllIIIllllllllllIlI = this.head.setTextureOffset(26, 0);
        llllllllllllllllIIIllllllllllIlI.mirror = true;
        llllllllllllllllIIIllllllllllIlI.addBox(2.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        this.body = new ModelRenderer(this);
        this.body.setTextureOffset(0, 19).addBox(-5.0f, -13.0f, -7.0f, 14, 14, 11, 0.0f);
        this.body.setTextureOffset(39, 0).addBox(-4.0f, -25.0f, -7.0f, 12, 12, 10, 0.0f);
        this.body.setRotationPoint(-2.0f, 9.0f, 12.0f);
        final int llllllllllllllllIIIllllllllllIIl = 10;
        this.leg1 = new ModelRenderer(this, 50, 22);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.leg1.setRotationPoint(-3.5f, 14.0f, 6.0f);
        this.leg2 = new ModelRenderer(this, 50, 22);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.leg2.setRotationPoint(3.5f, 14.0f, 6.0f);
        this.leg3 = new ModelRenderer(this, 50, 40);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.leg3.setRotationPoint(-2.5f, 14.0f, -7.0f);
        this.leg4 = new ModelRenderer(this, 50, 40);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.leg4.setRotationPoint(2.5f, 14.0f, -7.0f);
        final ModelRenderer leg1 = this.leg1;
        --leg1.rotationPointX;
        final ModelRenderer leg2 = this.leg2;
        ++leg2.rotationPointX;
        final ModelRenderer leg3 = this.leg1;
        leg3.rotationPointZ += 0.0f;
        final ModelRenderer leg4 = this.leg2;
        leg4.rotationPointZ += 0.0f;
        final ModelRenderer leg5 = this.leg3;
        --leg5.rotationPointX;
        final ModelRenderer leg6 = this.leg4;
        ++leg6.rotationPointX;
        final ModelRenderer leg7 = this.leg3;
        --leg7.rotationPointZ;
        final ModelRenderer leg8 = this.leg4;
        --leg8.rotationPointZ;
        this.childZOffset += 2.0f;
    }
    
    @Override
    public void render(final Entity llllllllllllllllIIIllllllllIlIll, final float llllllllllllllllIIIllllllllIlIlI, final float llllllllllllllllIIIllllllllIlIIl, final float llllllllllllllllIIIllllllllIlIII, final float llllllllllllllllIIIlllllllIllllI, final float llllllllllllllllIIIllllllllIIllI, final float llllllllllllllllIIIllllllllIIlIl) {
        this.setRotationAngles(llllllllllllllllIIIllllllllIlIlI, llllllllllllllllIIIllllllllIlIIl, llllllllllllllllIIIllllllllIlIII, llllllllllllllllIIIlllllllIllllI, llllllllllllllllIIIllllllllIIllI, llllllllllllllllIIIllllllllIIlIl, llllllllllllllllIIIllllllllIlIll);
        if (this.isChild) {
            final float llllllllllllllllIIIllllllllIIlII = 2.0f;
            this.childYOffset = 16.0f;
            this.childZOffset = 4.0f;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.6666667f, 0.6666667f, 0.6666667f);
            GlStateManager.translate(0.0f, this.childYOffset * llllllllllllllllIIIllllllllIIlIl, this.childZOffset * llllllllllllllllIIIllllllllIIlIl);
            this.head.render(llllllllllllllllIIIllllllllIIlIl);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllllIIIllllllllIIlIl, 0.0f);
            this.body.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg1.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg2.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg3.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg4.render(llllllllllllllllIIIllllllllIIlIl);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllllIIIllllllllIIlIl);
            this.body.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg1.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg2.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg3.render(llllllllllllllllIIIllllllllIIlIl);
            this.leg4.render(llllllllllllllllIIIllllllllIIlIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllllIIIlllllllIIIIll, final float llllllllllllllllIIIlllllllIIIIlI, final float llllllllllllllllIIIlllllllIIIIIl, final float llllllllllllllllIIIlllllllIIIIII, final float llllllllllllllllIIIllllllIllllll, final float llllllllllllllllIIIlllllllIIlIIl, final Entity llllllllllllllllIIIllllllIllllIl) {
        super.setRotationAngles(llllllllllllllllIIIlllllllIIIIll, llllllllllllllllIIIlllllllIIIIlI, llllllllllllllllIIIlllllllIIIIIl, llllllllllllllllIIIlllllllIIIIII, llllllllllllllllIIIllllllIllllll, llllllllllllllllIIIlllllllIIlIIl, llllllllllllllllIIIllllllIllllIl);
        final float llllllllllllllllIIIlllllllIIIlll = llllllllllllllllIIIlllllllIIIIIl - llllllllllllllllIIIllllllIllllIl.ticksExisted;
        float llllllllllllllllIIIlllllllIIIllI = ((EntityPolarBear)llllllllllllllllIIIllllllIllllIl).getStandingAnimationScale(llllllllllllllllIIIlllllllIIIlll);
        llllllllllllllllIIIlllllllIIIllI *= llllllllllllllllIIIlllllllIIIllI;
        final float llllllllllllllllIIIlllllllIIIlIl = 1.0f - llllllllllllllllIIIlllllllIIIllI;
        this.body.rotateAngleX = 1.5707964f - llllllllllllllllIIIlllllllIIIllI * 3.1415927f * 0.35f;
        this.body.rotationPointY = 9.0f * llllllllllllllllIIIlllllllIIIlIl + 11.0f * llllllllllllllllIIIlllllllIIIllI;
        this.leg3.rotationPointY = 14.0f * llllllllllllllllIIIlllllllIIIlIl + -6.0f * llllllllllllllllIIIlllllllIIIllI;
        this.leg3.rotationPointZ = -8.0f * llllllllllllllllIIIlllllllIIIlIl + -4.0f * llllllllllllllllIIIlllllllIIIllI;
        final ModelRenderer leg3 = this.leg3;
        leg3.rotateAngleX -= llllllllllllllllIIIlllllllIIIllI * 3.1415927f * 0.45f;
        this.leg4.rotationPointY = this.leg3.rotationPointY;
        this.leg4.rotationPointZ = this.leg3.rotationPointZ;
        final ModelRenderer leg4 = this.leg4;
        leg4.rotateAngleX -= llllllllllllllllIIIlllllllIIIllI * 3.1415927f * 0.45f;
        this.head.rotationPointY = 10.0f * llllllllllllllllIIIlllllllIIIlIl + -12.0f * llllllllllllllllIIIlllllllIIIllI;
        this.head.rotationPointZ = -16.0f * llllllllllllllllIIIlllllllIIIlIl + -3.0f * llllllllllllllllIIIlllllllIIIllI;
        final ModelRenderer head = this.head;
        head.rotateAngleX += llllllllllllllllIIIlllllllIIIllI * 3.1415927f * 0.15f;
    }
}
