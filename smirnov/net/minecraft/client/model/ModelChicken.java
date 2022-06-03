// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelChicken extends ModelBase
{
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer rightLeg;
    public /* synthetic */ ModelRenderer bill;
    public /* synthetic */ ModelRenderer rightWing;
    public /* synthetic */ ModelRenderer chin;
    public /* synthetic */ ModelRenderer leftLeg;
    public /* synthetic */ ModelRenderer leftWing;
    public /* synthetic */ ModelRenderer head;
    
    @Override
    public void render(final Entity llllllllllIlllIIIIlIIIIlllIIIIII, final float llllllllllIlllIIIIlIIIIllIllIllI, final float llllllllllIlllIIIIlIIIIllIlllllI, final float llllllllllIlllIIIIlIIIIllIllllIl, final float llllllllllIlllIIIIlIIIIllIllIIll, final float llllllllllIlllIIIIlIIIIllIllIIlI, final float llllllllllIlllIIIIlIIIIllIlllIlI) {
        this.setRotationAngles(llllllllllIlllIIIIlIIIIllIllIllI, llllllllllIlllIIIIlIIIIllIlllllI, llllllllllIlllIIIIlIIIIllIllllIl, llllllllllIlllIIIIlIIIIllIllIIll, llllllllllIlllIIIIlIIIIllIllIIlI, llllllllllIlllIIIIlIIIIllIlllIlI, llllllllllIlllIIIIlIIIIlllIIIIII);
        if (this.isChild) {
            final float llllllllllIlllIIIIlIIIIllIlllIIl = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllIlllIIIIlIIIIllIlllIlI, 2.0f * llllllllllIlllIIIIlIIIIllIlllIlI);
            this.head.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.bill.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.chin.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllIlllIIIIlIIIIllIlllIlI, 0.0f);
            this.body.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.rightLeg.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.leftLeg.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.rightWing.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.leftWing.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.bill.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.chin.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.body.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.rightLeg.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.leftLeg.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.rightWing.render(llllllllllIlllIIIIlIIIIllIlllIlI);
            this.leftWing.render(llllllllllIlllIIIIlIIIIllIlllIlI);
        }
    }
    
    public ModelChicken() {
        final int llllllllllIlllIIIIlIIIIlllIIllIl = 16;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.head.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.bill = new ModelRenderer(this, 14, 0);
        this.bill.addBox(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.bill.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.chin = new ModelRenderer(this, 14, 4);
        this.chin.addBox(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.chin.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.body = new ModelRenderer(this, 0, 9);
        this.body.addBox(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.rightLeg = new ModelRenderer(this, 26, 0);
        this.rightLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.rightLeg.setRotationPoint(-2.0f, 19.0f, 1.0f);
        this.leftLeg = new ModelRenderer(this, 26, 0);
        this.leftLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.leftLeg.setRotationPoint(1.0f, 19.0f, 1.0f);
        this.rightWing = new ModelRenderer(this, 24, 13);
        this.rightWing.addBox(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.rightWing.setRotationPoint(-4.0f, 13.0f, 0.0f);
        this.leftWing = new ModelRenderer(this, 24, 13);
        this.leftWing.addBox(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.leftWing.setRotationPoint(4.0f, 13.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllIlllIIIIlIIIIllIlIlIII, final float llllllllllIlllIIIIlIIIIllIIlllll, final float llllllllllIlllIIIIlIIIIllIlIIllI, final float llllllllllIlllIIIIlIIIIllIlIIlIl, final float llllllllllIlllIIIIlIIIIllIIlllII, final float llllllllllIlllIIIIlIIIIllIlIIIll, final Entity llllllllllIlllIIIIlIIIIllIlIIIlI) {
        this.head.rotateAngleX = llllllllllIlllIIIIlIIIIllIIlllII * 0.017453292f;
        this.head.rotateAngleY = llllllllllIlllIIIIlIIIIllIlIIlIl * 0.017453292f;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = 1.5707964f;
        this.rightLeg.rotateAngleX = MathHelper.cos(llllllllllIlllIIIIlIIIIllIlIlIII * 0.6662f) * 1.4f * llllllllllIlllIIIIlIIIIllIIlllll;
        this.leftLeg.rotateAngleX = MathHelper.cos(llllllllllIlllIIIIlIIIIllIlIlIII * 0.6662f + 3.1415927f) * 1.4f * llllllllllIlllIIIIlIIIIllIIlllll;
        this.rightWing.rotateAngleZ = llllllllllIlllIIIIlIIIIllIlIIllI;
        this.leftWing.rotateAngleZ = -llllllllllIlllIIIIlIIIIllIlIIllI;
    }
}
