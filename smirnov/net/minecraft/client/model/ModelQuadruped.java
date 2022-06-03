// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelQuadruped extends ModelBase
{
    public /* synthetic */ ModelRenderer leg2;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leg1;
    public /* synthetic */ ModelRenderer head;
    protected /* synthetic */ float childZOffset;
    protected /* synthetic */ float childYOffset;
    public /* synthetic */ ModelRenderer leg3;
    
    @Override
    public void setRotationAngles(final float lllllllllllIIIIlIIIIIIIIIlIlIlll, final float lllllllllllIIIIlIIIIIIIIIlIlIllI, final float lllllllllllIIIIlIIIIIIIIIlIlIlIl, final float lllllllllllIIIIlIIIIIIIIIlIIllIl, final float lllllllllllIIIIlIIIIIIIIIlIIllII, final float lllllllllllIIIIlIIIIIIIIIlIlIIlI, final Entity lllllllllllIIIIlIIIIIIIIIlIlIIIl) {
        this.head.rotateAngleX = lllllllllllIIIIlIIIIIIIIIlIIllII * 0.017453292f;
        this.head.rotateAngleY = lllllllllllIIIIlIIIIIIIIIlIIllIl * 0.017453292f;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = MathHelper.cos(lllllllllllIIIIlIIIIIIIIIlIlIlll * 0.6662f) * 1.4f * lllllllllllIIIIlIIIIIIIIIlIlIllI;
        this.leg2.rotateAngleX = MathHelper.cos(lllllllllllIIIIlIIIIIIIIIlIlIlll * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIIIIlIIIIIIIIIlIlIllI;
        this.leg3.rotateAngleX = MathHelper.cos(lllllllllllIIIIlIIIIIIIIIlIlIlll * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIIIIlIIIIIIIIIlIlIllI;
        this.leg4.rotateAngleX = MathHelper.cos(lllllllllllIIIIlIIIIIIIIIlIlIlll * 0.6662f) * 1.4f * lllllllllllIIIIlIIIIIIIIIlIlIllI;
    }
    
    @Override
    public void render(final Entity lllllllllllIIIIlIIIIIIIIIllIlllI, final float lllllllllllIIIIlIIIIIIIIIllIIlII, final float lllllllllllIIIIlIIIIIIIIIllIIIll, final float lllllllllllIIIIlIIIIIIIIIllIlIll, final float lllllllllllIIIIlIIIIIIIIIllIlIlI, final float lllllllllllIIIIlIIIIIIIIIllIlIIl, final float lllllllllllIIIIlIIIIIIIIIlIlllll) {
        this.setRotationAngles(lllllllllllIIIIlIIIIIIIIIllIIlII, lllllllllllIIIIlIIIIIIIIIllIIIll, lllllllllllIIIIlIIIIIIIIIllIlIll, lllllllllllIIIIlIIIIIIIIIllIlIlI, lllllllllllIIIIlIIIIIIIIIllIlIIl, lllllllllllIIIIlIIIIIIIIIlIlllll, lllllllllllIIIIlIIIIIIIIIllIlllI);
        if (this.isChild) {
            final float lllllllllllIIIIlIIIIIIIIIllIIlll = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, this.childYOffset * lllllllllllIIIIlIIIIIIIIIlIlllll, this.childZOffset * lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.head.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllIIIIlIIIIIIIIIlIlllll, 0.0f);
            this.body.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg1.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg2.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg3.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg4.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.body.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg1.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg2.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg3.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
            this.leg4.render(lllllllllllIIIIlIIIIIIIIIlIlllll);
        }
    }
    
    public ModelQuadruped(final int lllllllllllIIIIlIIIIIIIIIlllllIl, final float lllllllllllIIIIlIIIIIIIIIlllllII) {
        this.head = new ModelRenderer(this, 0, 0);
        this.childYOffset = 8.0f;
        this.childZOffset = 4.0f;
        this.head.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.head.setRotationPoint(0.0f, (float)(18 - lllllllllllIIIIlIIIIIIIIIlllllIl), -6.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0f, -10.0f, -7.0f, 10, 16, 8, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.body.setRotationPoint(0.0f, (float)(17 - lllllllllllIIIIlIIIIIIIIIlllllIl), 2.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, lllllllllllIIIIlIIIIIIIIIlllllIl, 4, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.leg1.setRotationPoint(-3.0f, (float)(24 - lllllllllllIIIIlIIIIIIIIIlllllIl), 7.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, lllllllllllIIIIlIIIIIIIIIlllllIl, 4, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.leg2.setRotationPoint(3.0f, (float)(24 - lllllllllllIIIIlIIIIIIIIIlllllIl), 7.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, lllllllllllIIIIlIIIIIIIIIlllllIl, 4, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.leg3.setRotationPoint(-3.0f, (float)(24 - lllllllllllIIIIlIIIIIIIIIlllllIl), -5.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, lllllllllllIIIIlIIIIIIIIIlllllIl, 4, lllllllllllIIIIlIIIIIIIIIlllllII);
        this.leg4.setRotationPoint(3.0f, (float)(24 - lllllllllllIIIIlIIIIIIIIIlllllIl), -5.0f);
    }
}
