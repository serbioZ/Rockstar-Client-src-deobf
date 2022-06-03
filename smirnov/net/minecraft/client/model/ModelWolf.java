// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelWolf extends ModelBase
{
    /* synthetic */ ModelRenderer wolfMane;
    public /* synthetic */ ModelRenderer wolfLeg1;
    public /* synthetic */ ModelRenderer wolfHeadMain;
    public /* synthetic */ ModelRenderer wolfLeg2;
    /* synthetic */ ModelRenderer wolfTail;
    public /* synthetic */ ModelRenderer wolfBody;
    public /* synthetic */ ModelRenderer wolfLeg3;
    public /* synthetic */ ModelRenderer wolfLeg4;
    
    @Override
    public void render(final Entity llllllllllIlllIIlIlIllllIIIIllll, final float llllllllllIlllIIlIlIllllIIIIIlIl, final float llllllllllIlllIIlIlIllllIIIIIlII, final float llllllllllIlllIIlIlIllllIIIIllII, final float llllllllllIlllIIlIlIllllIIIIIIlI, final float llllllllllIlllIIlIlIllllIIIIIIIl, final float llllllllllIlllIIlIlIllllIIIIlIIl) {
        super.render(llllllllllIlllIIlIlIllllIIIIllll, llllllllllIlllIIlIlIllllIIIIIlIl, llllllllllIlllIIlIlIllllIIIIIlII, llllllllllIlllIIlIlIllllIIIIllII, llllllllllIlllIIlIlIllllIIIIIIlI, llllllllllIlllIIlIlIllllIIIIIIIl, llllllllllIlllIIlIlIllllIIIIlIIl);
        this.setRotationAngles(llllllllllIlllIIlIlIllllIIIIIlIl, llllllllllIlllIIlIlIllllIIIIIlII, llllllllllIlllIIlIlIllllIIIIllII, llllllllllIlllIIlIlIllllIIIIIIlI, llllllllllIlllIIlIlIllllIIIIIIIl, llllllllllIlllIIlIlIllllIIIIlIIl, llllllllllIlllIIlIlIllllIIIIllll);
        if (this.isChild) {
            final float llllllllllIlllIIlIlIllllIIIIlIII = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllIlllIIlIlIllllIIIIlIIl, 2.0f * llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfHeadMain.renderWithRotation(llllllllllIlllIIlIlIllllIIIIlIIl);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllIlllIIlIlIllllIIIIlIIl, 0.0f);
            this.wolfBody.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg1.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg2.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg3.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg4.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfTail.renderWithRotation(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfMane.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            GlStateManager.popMatrix();
        }
        else {
            this.wolfHeadMain.renderWithRotation(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfBody.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg1.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg2.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg3.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfLeg4.render(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfTail.renderWithRotation(llllllllllIlllIIlIlIllllIIIIlIIl);
            this.wolfMane.render(llllllllllIlllIIlIlIllllIIIIlIIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllIlllIIlIlIlllIllIllIll, final float llllllllllIlllIIlIlIlllIllIllIlI, final float llllllllllIlllIIlIlIlllIllIllIIl, final float llllllllllIlllIIlIlIlllIlllIIIII, final float llllllllllIlllIIlIlIlllIllIlllll, final float llllllllllIlllIIlIlIlllIllIlIllI, final Entity llllllllllIlllIIlIlIlllIllIlIlIl) {
        super.setRotationAngles(llllllllllIlllIIlIlIlllIllIllIll, llllllllllIlllIIlIlIlllIllIllIlI, llllllllllIlllIIlIlIlllIllIllIIl, llllllllllIlllIIlIlIlllIlllIIIII, llllllllllIlllIIlIlIlllIllIlllll, llllllllllIlllIIlIlIlllIllIlIllI, llllllllllIlllIIlIlIlllIllIlIlIl);
        this.wolfHeadMain.rotateAngleX = llllllllllIlllIIlIlIlllIllIlllll * 0.017453292f;
        this.wolfHeadMain.rotateAngleY = llllllllllIlllIIlIlIlllIlllIIIII * 0.017453292f;
        this.wolfTail.rotateAngleX = llllllllllIlllIIlIlIlllIllIllIIl;
    }
    
    public ModelWolf() {
        final float llllllllllIlllIIlIlIllllIIIllllI = 0.0f;
        final float llllllllllIlllIIlIlIllllIIIlllIl = 13.5f;
        this.wolfHeadMain = new ModelRenderer(this, 0, 0);
        this.wolfHeadMain.addBox(-2.0f, -3.0f, -2.0f, 6, 6, 4, 0.0f);
        this.wolfHeadMain.setRotationPoint(-1.0f, 13.5f, -7.0f);
        this.wolfBody = new ModelRenderer(this, 18, 14);
        this.wolfBody.addBox(-3.0f, -2.0f, -3.0f, 6, 9, 6, 0.0f);
        this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
        this.wolfMane = new ModelRenderer(this, 21, 0);
        this.wolfMane.addBox(-3.0f, -3.0f, -3.0f, 8, 6, 7, 0.0f);
        this.wolfMane.setRotationPoint(-1.0f, 14.0f, 2.0f);
        this.wolfLeg1 = new ModelRenderer(this, 0, 18);
        this.wolfLeg1.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
        this.wolfLeg2 = new ModelRenderer(this, 0, 18);
        this.wolfLeg2.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
        this.wolfLeg3 = new ModelRenderer(this, 0, 18);
        this.wolfLeg3.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
        this.wolfLeg4 = new ModelRenderer(this, 0, 18);
        this.wolfLeg4.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
        this.wolfTail = new ModelRenderer(this, 9, 18);
        this.wolfTail.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(-2.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(2.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f);
        this.wolfHeadMain.setTextureOffset(0, 10).addBox(-0.5f, 0.0f, -5.0f, 3, 3, 4, 0.0f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllIlllIIlIlIlllIllllIIIl, final float llllllllllIlllIIlIlIlllIllllIIII, final float llllllllllIlllIIlIlIlllIlllIllll, final float llllllllllIlllIIlIlIlllIllllIlII) {
        final EntityWolf llllllllllIlllIIlIlIlllIllllIIll = (EntityWolf)llllllllllIlllIIlIlIlllIllllIIIl;
        if (llllllllllIlllIIlIlIlllIllllIIll.isAngry()) {
            this.wolfTail.rotateAngleY = 0.0f;
        }
        else {
            this.wolfTail.rotateAngleY = MathHelper.cos(llllllllllIlllIIlIlIlllIllllIIII * 0.6662f) * 1.4f * llllllllllIlllIIlIlIlllIlllIllll;
        }
        if (llllllllllIlllIIlIlIlllIllllIIll.isSitting()) {
            this.wolfMane.setRotationPoint(-1.0f, 16.0f, -3.0f);
            this.wolfMane.rotateAngleX = 1.2566371f;
            this.wolfMane.rotateAngleY = 0.0f;
            this.wolfBody.setRotationPoint(0.0f, 18.0f, 0.0f);
            this.wolfBody.rotateAngleX = 0.7853982f;
            this.wolfTail.setRotationPoint(-1.0f, 21.0f, 6.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 22.0f, 2.0f);
            this.wolfLeg1.rotateAngleX = 4.712389f;
            this.wolfLeg2.setRotationPoint(0.5f, 22.0f, 2.0f);
            this.wolfLeg2.rotateAngleX = 4.712389f;
            this.wolfLeg3.rotateAngleX = 5.811947f;
            this.wolfLeg3.setRotationPoint(-2.49f, 17.0f, -4.0f);
            this.wolfLeg4.rotateAngleX = 5.811947f;
            this.wolfLeg4.setRotationPoint(0.51f, 17.0f, -4.0f);
        }
        else {
            this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
            this.wolfBody.rotateAngleX = 1.5707964f;
            this.wolfMane.setRotationPoint(-1.0f, 14.0f, -3.0f);
            this.wolfMane.rotateAngleX = this.wolfBody.rotateAngleX;
            this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
            this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
            this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
            this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
            this.wolfLeg1.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIlIlllIllllIIII * 0.6662f) * 1.4f * llllllllllIlllIIlIlIlllIlllIllll;
            this.wolfLeg2.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIlIlllIllllIIII * 0.6662f + 3.1415927f) * 1.4f * llllllllllIlllIIlIlIlllIlllIllll;
            this.wolfLeg3.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIlIlllIllllIIII * 0.6662f + 3.1415927f) * 1.4f * llllllllllIlllIIlIlIlllIlllIllll;
            this.wolfLeg4.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIlIlllIllllIIII * 0.6662f) * 1.4f * llllllllllIlllIIlIlIlllIlllIllll;
        }
        this.wolfHeadMain.rotateAngleZ = llllllllllIlllIIlIlIlllIllllIIll.getInterestedAngle(llllllllllIlllIIlIlIlllIllllIlII) + llllllllllIlllIIlIlIlllIllllIIll.getShakeAngle(llllllllllIlllIIlIlIlllIllllIlII, 0.0f);
        this.wolfMane.rotateAngleZ = llllllllllIlllIIlIlIlllIllllIIll.getShakeAngle(llllllllllIlllIIlIlIlllIllllIlII, -0.08f);
        this.wolfBody.rotateAngleZ = llllllllllIlllIIlIlIlllIllllIIll.getShakeAngle(llllllllllIlllIIlIlIlllIllllIlII, -0.16f);
        this.wolfTail.rotateAngleZ = llllllllllIlllIIlIlIlllIllllIIll.getShakeAngle(llllllllllIlllIIlIlIlllIllllIlII, -0.2f);
    }
}
