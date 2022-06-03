// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.Entity;

public class ModelBat extends ModelBase
{
    private final /* synthetic */ ModelRenderer batRightWing;
    private final /* synthetic */ ModelRenderer batOuterRightWing;
    private final /* synthetic */ ModelRenderer batBody;
    private final /* synthetic */ ModelRenderer batLeftWing;
    private final /* synthetic */ ModelRenderer batOuterLeftWing;
    private final /* synthetic */ ModelRenderer batHead;
    
    @Override
    public void render(final Entity llllllllllIlllIlIlllIIIIIIIIIIII, final float llllllllllIlllIlIllIllllllllIlll, final float llllllllllIlllIlIllIlllllllllllI, final float llllllllllIlllIlIllIllllllllIlIl, final float llllllllllIlllIlIllIllllllllIlII, final float llllllllllIlllIlIllIlllllllllIll, final float llllllllllIlllIlIllIllllllllIIlI) {
        this.setRotationAngles(llllllllllIlllIlIllIllllllllIlll, llllllllllIlllIlIllIlllllllllllI, llllllllllIlllIlIllIllllllllIlIl, llllllllllIlllIlIllIllllllllIlII, llllllllllIlllIlIllIlllllllllIll, llllllllllIlllIlIllIllllllllIIlI, llllllllllIlllIlIlllIIIIIIIIIIII);
        this.batHead.render(llllllllllIlllIlIllIllllllllIIlI);
        this.batBody.render(llllllllllIlllIlIllIllllllllIIlI);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllIlllIlIllIlllllllIlIll, final float llllllllllIlllIlIllIlllllllIlIlI, final float llllllllllIlllIlIllIlllllllIlIIl, final float llllllllllIlllIlIllIlllllllIlIII, final float llllllllllIlllIlIllIlllllllIIIIl, final float llllllllllIlllIlIllIlllllllIIllI, final Entity llllllllllIlllIlIllIlllllllIIIII) {
        if (((EntityBat)llllllllllIlllIlIllIlllllllIIIII).getIsBatHanging()) {
            this.batHead.rotateAngleX = llllllllllIlllIlIllIlllllllIIIIl * 0.017453292f;
            this.batHead.rotateAngleY = 3.1415927f - llllllllllIlllIlIllIlllllllIlIII * 0.017453292f;
            this.batHead.rotateAngleZ = 3.1415927f;
            this.batHead.setRotationPoint(0.0f, -2.0f, 0.0f);
            this.batRightWing.setRotationPoint(-3.0f, 0.0f, 3.0f);
            this.batLeftWing.setRotationPoint(3.0f, 0.0f, 3.0f);
            this.batBody.rotateAngleX = 3.1415927f;
            this.batRightWing.rotateAngleX = -0.15707964f;
            this.batRightWing.rotateAngleY = -1.2566371f;
            this.batOuterRightWing.rotateAngleY = -1.7278761f;
            this.batLeftWing.rotateAngleX = this.batRightWing.rotateAngleX;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterLeftWing.rotateAngleY = -this.batOuterRightWing.rotateAngleY;
        }
        else {
            this.batHead.rotateAngleX = llllllllllIlllIlIllIlllllllIIIIl * 0.017453292f;
            this.batHead.rotateAngleY = llllllllllIlllIlIllIlllllllIlIII * 0.017453292f;
            this.batHead.rotateAngleZ = 0.0f;
            this.batHead.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batRightWing.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batLeftWing.setRotationPoint(0.0f, 0.0f, 0.0f);
            this.batBody.rotateAngleX = 0.7853982f + MathHelper.cos(llllllllllIlllIlIllIlllllllIlIIl * 0.1f) * 0.15f;
            this.batBody.rotateAngleY = 0.0f;
            this.batRightWing.rotateAngleY = MathHelper.cos(llllllllllIlllIlIllIlllllllIlIIl * 1.3f) * 3.1415927f * 0.25f;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5f;
            this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5f;
        }
    }
    
    public ModelBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        final ModelRenderer llllllllllIlllIlIlllIIIIIIIIlllI = new ModelRenderer(this, 24, 0);
        llllllllllIlllIlIlllIIIIIIIIlllI.addBox(-4.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(llllllllllIlllIlIlllIIIIIIIIlllI);
        final ModelRenderer llllllllllIlllIlIlllIIIIIIIIllIl = new ModelRenderer(this, 24, 0);
        llllllllllIlllIlIlllIIIIIIIIllIl.mirror = true;
        llllllllllIlllIlIlllIIIIIIIIllIl.addBox(1.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(llllllllllIlllIlIlllIIIIIIIIllIl);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3.0f, 4.0f, -3.0f, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0f, 16.0f, 0.0f, 10, 6, 1);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12.0f, 1.0f, 1.5f, 10, 16, 1);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setRotationPoint(-12.0f, 1.0f, 1.5f);
        this.batOuterRightWing.addBox(-8.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0f, 1.0f, 1.5f, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12.0f, 1.0f, 1.5f);
        this.batOuterLeftWing.addBox(0.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }
}
