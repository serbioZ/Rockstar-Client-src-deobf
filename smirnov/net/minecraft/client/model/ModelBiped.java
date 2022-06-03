// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelBiped extends ModelBase
{
    public /* synthetic */ ModelRenderer bipedHeadwear;
    public /* synthetic */ ModelRenderer bipedRightLeg;
    public /* synthetic */ ArmPose rightArmPose;
    public /* synthetic */ ModelRenderer bipedRightArm;
    public /* synthetic */ ArmPose leftArmPose;
    public /* synthetic */ ModelRenderer bipedLeftArm;
    public /* synthetic */ boolean isSneak;
    public /* synthetic */ ModelRenderer bipedBody;
    public /* synthetic */ ModelRenderer bipedLeftLeg;
    public /* synthetic */ ModelRenderer bipedHead;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
    
    @Override
    public void setRotationAngles(final float llllllllllIlllIIlIllIlIlIIlIllll, final float llllllllllIlllIIlIllIlIlIIllllIl, final float llllllllllIlllIIlIllIlIlIIlIllIl, final float llllllllllIlllIIlIllIlIlIIlllIll, final float llllllllllIlllIIlIllIlIlIIlllIlI, final float llllllllllIlllIIlIllIlIlIIlllIIl, final Entity llllllllllIlllIIlIllIlIlIIlIlIlI) {
        final boolean llllllllllIlllIIlIllIlIlIIllIlll = llllllllllIlllIIlIllIlIlIIlIlIlI instanceof EntityLivingBase && ((EntityLivingBase)llllllllllIlllIIlIllIlIlIIlIlIlI).getTicksElytraFlying() > 4;
        this.bipedHead.rotateAngleY = llllllllllIlllIIlIllIlIlIIlllIll * 0.017453292f;
        if (llllllllllIlllIIlIllIlIlIIllIlll) {
            this.bipedHead.rotateAngleX = -0.7853982f;
        }
        else {
            this.bipedHead.rotateAngleX = llllllllllIlllIIlIllIlIlIIlllIlI * 0.017453292f;
        }
        this.bipedBody.rotateAngleY = 0.0f;
        this.bipedRightArm.rotationPointZ = 0.0f;
        this.bipedRightArm.rotationPointX = -5.0f;
        this.bipedLeftArm.rotationPointZ = 0.0f;
        this.bipedLeftArm.rotationPointX = 5.0f;
        float llllllllllIlllIIlIllIlIlIIllIllI = 1.0f;
        if (llllllllllIlllIIlIllIlIlIIllIlll) {
            llllllllllIlllIIlIllIlIlIIllIllI = (float)(llllllllllIlllIIlIllIlIlIIlIlIlI.motionX * llllllllllIlllIIlIllIlIlIIlIlIlI.motionX + llllllllllIlllIIlIllIlIlIIlIlIlI.motionY * llllllllllIlllIIlIllIlIlIIlIlIlI.motionY + llllllllllIlllIIlIllIlIlIIlIlIlI.motionZ * llllllllllIlllIIlIllIlIlIIlIlIlI.motionZ);
            llllllllllIlllIIlIllIlIlIIllIllI /= 0.2f;
            llllllllllIlllIIlIllIlIlIIllIllI *= llllllllllIlllIIlIllIlIlIIllIllI * llllllllllIlllIIlIllIlIlIIllIllI;
        }
        if (llllllllllIlllIIlIllIlIlIIllIllI < 1.0f) {
            llllllllllIlllIIlIllIlIlIIllIllI = 1.0f;
        }
        this.bipedRightArm.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllll * 0.6662f + 3.1415927f) * 2.0f * llllllllllIlllIIlIllIlIlIIllllIl * 0.5f / llllllllllIlllIIlIllIlIlIIllIllI;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllll * 0.6662f) * 2.0f * llllllllllIlllIIlIllIlIlIIllllIl * 0.5f / llllllllllIlllIIlIllIlIlIIllIllI;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllll * 0.6662f) * 1.4f * llllllllllIlllIIlIllIlIlIIllllIl / llllllllllIlllIIlIllIlIlIIllIllI;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllll * 0.6662f + 3.1415927f) * 1.4f * llllllllllIlllIIlIllIlIlIIllllIl / llllllllllIlllIIlIllIlIlIIllIllI;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        this.bipedRightLeg.rotateAngleZ = 0.0f;
        this.bipedLeftLeg.rotateAngleZ = 0.0f;
        if (this.isRiding) {
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= 0.62831855f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= 0.62831855f;
            this.bipedRightLeg.rotateAngleX = -1.4137167f;
            this.bipedRightLeg.rotateAngleY = 0.31415927f;
            this.bipedRightLeg.rotateAngleZ = 0.07853982f;
            this.bipedLeftLeg.rotateAngleX = -1.4137167f;
            this.bipedLeftLeg.rotateAngleY = -0.31415927f;
            this.bipedLeftLeg.rotateAngleZ = -0.07853982f;
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        switch ($SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose()[this.leftArmPose.ordinal()]) {
            case 1: {
                this.bipedLeftArm.rotateAngleY = 0.0f;
                break;
            }
            case 3: {
                this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.9424779f;
                this.bipedLeftArm.rotateAngleY = 0.5235988f;
                break;
            }
            case 2: {
                this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.31415927f;
                this.bipedLeftArm.rotateAngleY = 0.0f;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose()[this.rightArmPose.ordinal()]) {
            case 1: {
                this.bipedRightArm.rotateAngleY = 0.0f;
                break;
            }
            case 3: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.9424779f;
                this.bipedRightArm.rotateAngleY = -0.5235988f;
                break;
            }
            case 2: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.31415927f;
                this.bipedRightArm.rotateAngleY = 0.0f;
                break;
            }
        }
        if (this.swingProgress > 0.0f) {
            final EnumHandSide llllllllllIlllIIlIllIlIlIIllIlIl = this.getMainHand(llllllllllIlllIIlIllIlIlIIlIlIlI);
            final ModelRenderer llllllllllIlllIIlIllIlIlIIllIlII = this.getArmForSide(llllllllllIlllIIlIllIlIlIIllIlIl);
            float llllllllllIlllIIlIllIlIlIIllIIll = this.swingProgress;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(llllllllllIlllIIlIllIlIlIIllIIll) * 6.2831855f) * 0.2f;
            if (llllllllllIlllIIlIllIlIlIIllIlIl == EnumHandSide.LEFT) {
                final ModelRenderer bipedBody = this.bipedBody;
                bipedBody.rotateAngleY *= -1.0f;
            }
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX += this.bipedBody.rotateAngleY;
            llllllllllIlllIIlIllIlIlIIllIIll = 1.0f - this.swingProgress;
            llllllllllIlllIIlIllIlIlIIllIIll *= llllllllllIlllIIlIllIlIlIIllIIll;
            llllllllllIlllIIlIllIlIlIIllIIll *= llllllllllIlllIIlIllIlIlIIllIIll;
            llllllllllIlllIIlIllIlIlIIllIIll = 1.0f - llllllllllIlllIIlIllIlIlIIllIIll;
            final float llllllllllIlllIIlIllIlIlIIllIIlI = MathHelper.sin(llllllllllIlllIIlIllIlIlIIllIIll * 3.1415927f);
            final float llllllllllIlllIIlIllIlIlIIllIIIl = MathHelper.sin(this.swingProgress * 3.1415927f) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            llllllllllIlllIIlIllIlIlIIllIlII.rotateAngleX -= (float)(llllllllllIlllIIlIllIlIlIIllIIlI * 1.2 + llllllllllIlllIIlIllIlIlIIllIIIl);
            final ModelRenderer modelRenderer = llllllllllIlllIIlIllIlIlIIllIlII;
            modelRenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0f;
            final ModelRenderer modelRenderer2 = llllllllllIlllIIlIllIlIlIIllIlII;
            modelRenderer2.rotateAngleZ += MathHelper.sin(this.swingProgress * 3.1415927f) * -0.4f;
        }
        if (this.isSneak) {
            this.bipedBody.rotateAngleX = 0.5f;
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleX += 0.4f;
            final ModelRenderer bipedLeftArm4 = this.bipedLeftArm;
            bipedLeftArm4.rotateAngleX += 0.4f;
            this.bipedRightLeg.rotationPointZ = 4.0f;
            this.bipedLeftLeg.rotationPointZ = 4.0f;
            this.bipedRightLeg.rotationPointY = 9.0f;
            this.bipedLeftLeg.rotationPointY = 9.0f;
            this.bipedHead.rotationPointY = 1.0f;
        }
        else {
            this.bipedBody.rotateAngleX = 0.0f;
            this.bipedRightLeg.rotationPointZ = 0.1f;
            this.bipedLeftLeg.rotationPointZ = 0.1f;
            this.bipedRightLeg.rotationPointY = 12.0f;
            this.bipedLeftLeg.rotationPointY = 12.0f;
            this.bipedHead.rotationPointY = 0.0f;
        }
        final ModelRenderer bipedRightArm4 = this.bipedRightArm;
        bipedRightArm4.rotateAngleZ += MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllIl * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm5 = this.bipedLeftArm;
        bipedLeftArm5.rotateAngleZ -= MathHelper.cos(llllllllllIlllIIlIllIlIlIIlIllIl * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm5 = this.bipedRightArm;
        bipedRightArm5.rotateAngleX += MathHelper.sin(llllllllllIlllIIlIllIlIlIIlIllIl * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm6 = this.bipedLeftArm;
        bipedLeftArm6.rotateAngleX -= MathHelper.sin(llllllllllIlllIIlIllIlIlIIlIllIl * 0.067f) * 0.05f;
        if (this.rightArmPose == ArmPose.BOW_AND_ARROW) {
            this.bipedRightArm.rotateAngleY = -0.1f + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1f + this.bipedHead.rotateAngleY + 0.4f;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
        }
        else if (this.leftArmPose == ArmPose.BOW_AND_ARROW) {
            this.bipedRightArm.rotateAngleY = -0.1f + this.bipedHead.rotateAngleY - 0.4f;
            this.bipedLeftArm.rotateAngleY = 0.1f + this.bipedHead.rotateAngleY;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
        }
        ModelBase.copyModelAngles(this.bipedHead, this.bipedHeadwear);
    }
    
    public ModelBiped(final float llllllllllIlllIIlIllIlIlIlllIIIl, final float llllllllllIlllIIlIllIlIlIlllIIII, final int llllllllllIlllIIlIllIlIlIllIllll, final int llllllllllIlllIIlIllIlIlIllIlIIl) {
        this.leftArmPose = ArmPose.EMPTY;
        this.rightArmPose = ArmPose.EMPTY;
        this.textureWidth = llllllllllIlllIIlIllIlIlIllIllll;
        this.textureHeight = llllllllllIlllIIlIllIlIlIllIlIIl;
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedHead.setRotationPoint(0.0f, 0.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllIlllIIlIllIlIlIlllIIIl + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllIlllIIlIllIlIlIlllIIIl);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f + llllllllllIlllIIlIllIlIlIlllIIII, 0.0f);
    }
    
    @Override
    public void setModelAttributes(final ModelBase llllllllllIlllIIlIllIlIlIIIllIll) {
        super.setModelAttributes(llllllllllIlllIIlIllIlIlIIIllIll);
        if (llllllllllIlllIIlIllIlIlIIIllIll instanceof ModelBiped) {
            final ModelBiped llllllllllIlllIIlIllIlIlIIIlllIl = (ModelBiped)llllllllllIlllIIlIllIlIlIIIllIll;
            this.leftArmPose = llllllllllIlllIIlIllIlIlIIIlllIl.leftArmPose;
            this.rightArmPose = llllllllllIlllIIlIllIlIlIIIlllIl.rightArmPose;
            this.isSneak = llllllllllIlllIIlIllIlIlIIIlllIl.isSneak;
        }
    }
    
    public void setInvisible(final boolean llllllllllIlllIIlIllIlIlIIIlIllI) {
        this.bipedHead.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedHeadwear.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedBody.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedRightArm.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedLeftArm.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedRightLeg.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
        this.bipedLeftLeg.showModel = llllllllllIlllIIlIllIlIlIIIlIllI;
    }
    
    protected EnumHandSide getMainHand(final Entity llllllllllIlllIIlIllIlIIllllllIl) {
        if (llllllllllIlllIIlIllIlIIllllllIl instanceof EntityLivingBase) {
            final EntityLivingBase llllllllllIlllIIlIllIlIIllllllll = (EntityLivingBase)llllllllllIlllIIlIllIlIIllllllIl;
            final EnumHandSide llllllllllIlllIIlIllIlIIlllllllI = llllllllllIlllIIlIllIlIIllllllll.getPrimaryHand();
            return (llllllllllIlllIIlIllIlIIllllllll.swingingHand == EnumHand.MAIN_HAND) ? llllllllllIlllIIlIllIlIIlllllllI : llllllllllIlllIIlIllIlIIlllllllI.opposite();
        }
        return EnumHandSide.RIGHT;
    }
    
    @Override
    public void render(final Entity llllllllllIlllIIlIllIlIlIlIllllI, final float llllllllllIlllIIlIllIlIlIlIlllIl, final float llllllllllIlllIIlIllIlIlIlIlllII, final float llllllllllIlllIIlIllIlIlIlIllIll, final float llllllllllIlllIIlIllIlIlIlIlIIIl, final float llllllllllIlllIIlIllIlIlIlIllIIl, final float llllllllllIlllIIlIllIlIlIlIIllll) {
        this.setRotationAngles(llllllllllIlllIIlIllIlIlIlIlllIl, llllllllllIlllIIlIllIlIlIlIlllII, llllllllllIlllIIlIllIlIlIlIllIll, llllllllllIlllIIlIllIlIlIlIlIIIl, llllllllllIlllIIlIllIlIlIlIllIIl, llllllllllIlllIIlIllIlIlIlIIllll, llllllllllIlllIIlIllIlIlIlIllllI);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float llllllllllIlllIIlIllIlIlIlIlIlll = 2.0f;
            GlStateManager.scale(0.75f, 0.75f, 0.75f);
            GlStateManager.translate(0.0f, 16.0f * llllllllllIlllIIlIllIlIlIlIIllll, 0.0f);
            this.bipedHead.render(llllllllllIlllIIlIllIlIlIlIIllll);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllIlllIIlIllIlIlIlIIllll, 0.0f);
            this.bipedBody.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedRightArm.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedLeftArm.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedRightLeg.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedLeftLeg.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedHeadwear.render(llllllllllIlllIIlIllIlIlIlIIllll);
        }
        else {
            if (llllllllllIlllIIlIllIlIlIlIllllI.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.bipedHead.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedBody.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedRightArm.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedLeftArm.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedRightLeg.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedLeftLeg.render(llllllllllIlllIIlIllIlIlIlIIllll);
            this.bipedHeadwear.render(llllllllllIlllIIlIllIlIlIlIIllll);
        }
        GlStateManager.popMatrix();
    }
    
    public void postRenderArm(final float llllllllllIlllIIlIllIlIlIIIIllII, final EnumHandSide llllllllllIlllIIlIllIlIlIIIIlIll) {
        this.getArmForSide(llllllllllIlllIIlIllIlIlIIIIlIll).postRender(llllllllllIlllIIlIllIlIlIIIIllII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose() {
        final int[] $switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose = ModelBiped.$SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
        if ($switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose != null) {
            return $switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
        }
        final long llllllllllIlllIIlIllIlIIlllllIIl = (Object)new int[ArmPose.values().length];
        try {
            llllllllllIlllIIlIllIlIIlllllIIl[ArmPose.BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIlIllIlIIlllllIIl[ArmPose.BOW_AND_ARROW.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIlIllIlIIlllllIIl[ArmPose.EMPTY.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIIlIllIlIIlllllIIl[ArmPose.ITEM.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ModelBiped.$SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose = (int[])(Object)llllllllllIlllIIlIllIlIIlllllIIl;
    }
    
    protected ModelRenderer getArmForSide(final EnumHandSide llllllllllIlllIIlIllIlIlIIIIIlIl) {
        return (llllllllllIlllIIlIllIlIlIIIIIlIl == EnumHandSide.LEFT) ? this.bipedLeftArm : this.bipedRightArm;
    }
    
    public ModelBiped() {
        this(0.0f);
    }
    
    public ModelBiped(final float llllllllllIlllIIlIllIlIlIllllIII) {
        this(llllllllllIlllIIlIllIlIlIllllIII, 0.0f, 64, 32);
    }
    
    public enum ArmPose
    {
        ITEM("ITEM", 1), 
        BOW_AND_ARROW("BOW_AND_ARROW", 3), 
        BLOCK("BLOCK", 2), 
        EMPTY("EMPTY", 0);
        
        private ArmPose(final String lllllllllllIlIlIIIlIIIIIIIIlIllI, final int lllllllllllIlIlIIIlIIIIIIIIlIlIl) {
        }
    }
}
