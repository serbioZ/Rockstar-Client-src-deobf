// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.Entity;

public class ModelArmorStand extends ModelArmorStandArmor
{
    public /* synthetic */ ModelRenderer standBase;
    public /* synthetic */ ModelRenderer standRightSide;
    public /* synthetic */ ModelRenderer standLeftSide;
    public /* synthetic */ ModelRenderer standWaist;
    
    @Override
    public void setRotationAngles(final float lllllllllllIlIlIllIIIIllIIlIIlII, final float lllllllllllIlIlIllIIIIllIIlIllII, final float lllllllllllIlIlIllIIIIllIIlIIIlI, final float lllllllllllIlIlIllIIIIllIIlIIIIl, final float lllllllllllIlIlIllIIIIllIIlIlIIl, final float lllllllllllIlIlIllIIIIllIIIlllll, final Entity lllllllllllIlIlIllIIIIllIIlIIlll) {
        super.setRotationAngles(lllllllllllIlIlIllIIIIllIIlIIlII, lllllllllllIlIlIllIIIIllIIlIllII, lllllllllllIlIlIllIIIIllIIlIIIlI, lllllllllllIlIlIllIIIIllIIlIIIIl, lllllllllllIlIlIllIIIIllIIlIlIIl, lllllllllllIlIlIllIIIIllIIIlllll, lllllllllllIlIlIllIIIIllIIlIIlll);
        if (lllllllllllIlIlIllIIIIllIIlIIlll instanceof EntityArmorStand) {
            final EntityArmorStand lllllllllllIlIlIllIIIIllIIlIIllI = (EntityArmorStand)lllllllllllIlIlIllIIIIllIIlIIlll;
            this.bipedLeftArm.showModel = lllllllllllIlIlIllIIIIllIIlIIllI.getShowArms();
            this.bipedRightArm.showModel = lllllllllllIlIlIllIIIIllIIlIIllI.getShowArms();
            this.standBase.showModel = !lllllllllllIlIlIllIIIIllIIlIIllI.hasNoBasePlate();
            this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
            this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
            this.standRightSide.rotateAngleX = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getX();
            this.standRightSide.rotateAngleY = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getY();
            this.standRightSide.rotateAngleZ = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getZ();
            this.standLeftSide.rotateAngleX = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getX();
            this.standLeftSide.rotateAngleY = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getY();
            this.standLeftSide.rotateAngleZ = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getZ();
            this.standWaist.rotateAngleX = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getX();
            this.standWaist.rotateAngleY = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getY();
            this.standWaist.rotateAngleZ = 0.017453292f * lllllllllllIlIlIllIIIIllIIlIIllI.getBodyRotation().getZ();
            this.standBase.rotateAngleX = 0.0f;
            this.standBase.rotateAngleY = 0.017453292f * -lllllllllllIlIlIllIIIIllIIlIIlll.rotationYaw;
            this.standBase.rotateAngleZ = 0.0f;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllIlIlIllIIIIllIIIIlIIl, final float lllllllllllIlIlIllIIIIllIIIIlIII, final float lllllllllllIlIlIllIIIIllIIIIIlll, final float lllllllllllIlIlIllIIIIllIIIIllll, final float lllllllllllIlIlIllIIIIllIIIIIlIl, final float lllllllllllIlIlIllIIIIllIIIIIlII, final float lllllllllllIlIlIllIIIIllIIIIllII) {
        super.render(lllllllllllIlIlIllIIIIllIIIIlIIl, lllllllllllIlIlIllIIIIllIIIIlIII, lllllllllllIlIlIllIIIIllIIIIIlll, lllllllllllIlIlIllIIIIllIIIIllll, lllllllllllIlIlIllIIIIllIIIIIlIl, lllllllllllIlIlIllIIIIllIIIIIlII, lllllllllllIlIlIllIIIIllIIIIllII);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float lllllllllllIlIlIllIIIIllIIIIlIll = 2.0f;
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllIlIlIllIIIIllIIIIllII, 0.0f);
            this.standRightSide.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standLeftSide.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standWaist.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standBase.render(lllllllllllIlIlIllIIIIllIIIIllII);
        }
        else {
            if (lllllllllllIlIlIllIIIIllIIIIlIIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.standRightSide.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standLeftSide.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standWaist.render(lllllllllllIlIlIllIIIIllIIIIllII);
            this.standBase.render(lllllllllllIlIlIllIIIIllIIIIllII);
        }
        GlStateManager.popMatrix();
    }
    
    public ModelArmorStand() {
        this(0.0f);
    }
    
    @Override
    public void postRenderArm(final float lllllllllllIlIlIllIIIIlIllllIllI, final EnumHandSide lllllllllllIlIlIllIIIIlIllllIlIl) {
        final ModelRenderer lllllllllllIlIlIllIIIIlIlllllIIl = this.getArmForSide(lllllllllllIlIlIllIIIIlIllllIlIl);
        final boolean lllllllllllIlIlIllIIIIlIlllllIII = lllllllllllIlIlIllIIIIlIlllllIIl.showModel;
        lllllllllllIlIlIllIIIIlIlllllIIl.showModel = true;
        super.postRenderArm(lllllllllllIlIlIllIIIIlIllllIllI, lllllllllllIlIlIllIIIIlIllllIlIl);
        lllllllllllIlIlIllIIIIlIlllllIIl.showModel = lllllllllllIlIlIllIIIIlIlllllIII;
    }
    
    public ModelArmorStand(final float lllllllllllIlIlIllIIIIllIIlllIlI) {
        super(lllllllllllIlIlIllIIIIllIIlllIlI, 64, 64);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-1.0f, -7.0f, -1.0f, 2, 7, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody = new ModelRenderer(this, 0, 26);
        this.bipedBody.addBox(-6.0f, 0.0f, -1.5f, 12, 3, 3, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 24, 0);
        this.bipedRightArm.addBox(-2.0f, -2.0f, -1.0f, 2, 12, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 32, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(0.0f, -2.0f, -1.0f, 2, 12, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 8, 0);
        this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 40, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.standRightSide = new ModelRenderer(this, 16, 0);
        this.standRightSide.addBox(-3.0f, 3.0f, -1.0f, 2, 7, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.standRightSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standRightSide.showModel = true;
        this.standLeftSide = new ModelRenderer(this, 48, 16);
        this.standLeftSide.addBox(1.0f, 3.0f, -1.0f, 2, 7, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.standLeftSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standWaist = new ModelRenderer(this, 0, 48);
        this.standWaist.addBox(-4.0f, 10.0f, -1.0f, 8, 2, 2, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.standWaist.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standBase = new ModelRenderer(this, 0, 32);
        this.standBase.addBox(-6.0f, 11.0f, -6.0f, 12, 1, 12, lllllllllllIlIlIllIIIIllIIlllIlI);
        this.standBase.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.bipedHeadwear.showModel = false;
    }
}
