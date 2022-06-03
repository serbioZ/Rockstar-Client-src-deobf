// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelSnowMan extends ModelBase
{
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer bottomBody;
    public /* synthetic */ ModelRenderer rightHand;
    public /* synthetic */ ModelRenderer leftHand;
    
    public ModelSnowMan() {
        final float lllllllllllIIllIllIIIIlIIIIIlIll = 4.0f;
        final float lllllllllllIIllIllIIIIlIIIIIlIlI = 0.0f;
        this.head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, -0.5f);
        this.head.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.rightHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.rightHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.rightHand.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.leftHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.leftHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.leftHand.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body = new ModelRenderer(this, 0, 16).setTextureSize(64, 64);
        this.body.addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10, -0.5f);
        this.body.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.bottomBody = new ModelRenderer(this, 0, 36).setTextureSize(64, 64);
        this.bottomBody.addBox(-6.0f, -12.0f, -6.0f, 12, 12, 12, -0.5f);
        this.bottomBody.setRotationPoint(0.0f, 24.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIllIllIIIIIllllllIll, final float lllllllllllIIllIllIIIIIllllllIlI, final float lllllllllllIIllIllIIIIIllllIllll, final float lllllllllllIIllIllIIIIIllllIlllI, final float lllllllllllIIllIllIIIIIlllllIlll, final float lllllllllllIIllIllIIIIIlllllIllI, final Entity lllllllllllIIllIllIIIIIllllIlIll) {
        super.setRotationAngles(lllllllllllIIllIllIIIIIllllllIll, lllllllllllIIllIllIIIIIllllllIlI, lllllllllllIIllIllIIIIIllllIllll, lllllllllllIIllIllIIIIIllllIlllI, lllllllllllIIllIllIIIIIlllllIlll, lllllllllllIIllIllIIIIIlllllIllI, lllllllllllIIllIllIIIIIllllIlIll);
        this.head.rotateAngleY = lllllllllllIIllIllIIIIIllllIlllI * 0.017453292f;
        this.head.rotateAngleX = lllllllllllIIllIllIIIIIlllllIlll * 0.017453292f;
        this.body.rotateAngleY = lllllllllllIIllIllIIIIIllllIlllI * 0.017453292f * 0.25f;
        final float lllllllllllIIllIllIIIIIlllllIlII = MathHelper.sin(this.body.rotateAngleY);
        final float lllllllllllIIllIllIIIIIlllllIIll = MathHelper.cos(this.body.rotateAngleY);
        this.rightHand.rotateAngleZ = 1.0f;
        this.leftHand.rotateAngleZ = -1.0f;
        this.rightHand.rotateAngleY = 0.0f + this.body.rotateAngleY;
        this.leftHand.rotateAngleY = 3.1415927f + this.body.rotateAngleY;
        this.rightHand.rotationPointX = lllllllllllIIllIllIIIIIlllllIIll * 5.0f;
        this.rightHand.rotationPointZ = -lllllllllllIIllIllIIIIIlllllIlII * 5.0f;
        this.leftHand.rotationPointX = -lllllllllllIIllIllIIIIIlllllIIll * 5.0f;
        this.leftHand.rotationPointZ = lllllllllllIIllIllIIIIIlllllIlII * 5.0f;
    }
    
    @Override
    public void render(final Entity lllllllllllIIllIllIIIIIlllIlllll, final float lllllllllllIIllIllIIIIIlllIllllI, final float lllllllllllIIllIllIIIIIlllIlIlIl, final float lllllllllllIIllIllIIIIIlllIlllII, final float lllllllllllIIllIllIIIIIlllIlIIll, final float lllllllllllIIllIllIIIIIlllIllIlI, final float lllllllllllIIllIllIIIIIlllIllIIl) {
        this.setRotationAngles(lllllllllllIIllIllIIIIIlllIllllI, lllllllllllIIllIllIIIIIlllIlIlIl, lllllllllllIIllIllIIIIIlllIlllII, lllllllllllIIllIllIIIIIlllIlIIll, lllllllllllIIllIllIIIIIlllIllIlI, lllllllllllIIllIllIIIIIlllIllIIl, lllllllllllIIllIllIIIIIlllIlllll);
        this.body.render(lllllllllllIIllIllIIIIIlllIllIIl);
        this.bottomBody.render(lllllllllllIIllIllIIIIIlllIllIIl);
        this.head.render(lllllllllllIIllIllIIIIIlllIllIIl);
        this.rightHand.render(lllllllllllIIllIllIIIIIlllIllIIl);
        this.leftHand.render(lllllllllllIIllIllIIIIIlllIllIIl);
    }
}
