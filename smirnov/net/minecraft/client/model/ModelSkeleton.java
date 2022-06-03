// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.EntityLivingBase;

public class ModelSkeleton extends ModelBiped
{
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllIIlllIlIIIIlIllIllII, final float llllllllllllIIlllIlIIIIlIllIIlIl, final float llllllllllllIIlllIlIIIIlIllIIlII, final float llllllllllllIIlllIlIIIIlIllIIIll) {
        this.rightArmPose = ArmPose.EMPTY;
        this.leftArmPose = ArmPose.EMPTY;
        final ItemStack llllllllllllIIlllIlIIIIlIllIlIII = llllllllllllIIlllIlIIIIlIllIllII.getHeldItem(EnumHand.MAIN_HAND);
        if (llllllllllllIIlllIlIIIIlIllIlIII.getItem() == Items.BOW && ((AbstractSkeleton)llllllllllllIIlllIlIIIIlIllIllII).isSwingingArms()) {
            if (llllllllllllIIlllIlIIIIlIllIllII.getPrimaryHand() == EnumHandSide.RIGHT) {
                this.rightArmPose = ArmPose.BOW_AND_ARROW;
            }
            else {
                this.leftArmPose = ArmPose.BOW_AND_ARROW;
            }
        }
        super.setLivingAnimations(llllllllllllIIlllIlIIIIlIllIllII, llllllllllllIIlllIlIIIIlIllIIlIl, llllllllllllIIlllIlIIIIlIllIIlII, llllllllllllIIlllIlIIIIlIllIIIll);
    }
    
    public ModelSkeleton() {
        this(0.0f, false);
    }
    
    @Override
    public void postRenderArm(final float llllllllllllIIlllIlIIIIlIIllIIlI, final EnumHandSide llllllllllllIIlllIlIIIIlIIllIllI) {
        final float llllllllllllIIlllIlIIIIlIIllIlIl = (llllllllllllIIlllIlIIIIlIIllIllI == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        final ModelRenderer armForSide;
        final ModelRenderer llllllllllllIIlllIlIIIIlIIllIlII = armForSide = this.getArmForSide(llllllllllllIIlllIlIIIIlIIllIllI);
        armForSide.rotationPointX += llllllllllllIIlllIlIIIIlIIllIlIl;
        llllllllllllIIlllIlIIIIlIIllIlII.postRender(llllllllllllIIlllIlIIIIlIIllIIlI);
        final ModelRenderer modelRenderer = llllllllllllIIlllIlIIIIlIIllIlII;
        modelRenderer.rotationPointX -= llllllllllllIIlllIlIIIIlIIllIlIl;
    }
    
    public ModelSkeleton(final float llllllllllllIIlllIlIIIIlIllllIII, final boolean llllllllllllIIlllIlIIIIlIlllIlII) {
        super(llllllllllllIIlllIlIIIIlIllllIII, 0.0f, 64, 32);
        if (!llllllllllllIIlllIlIIIIlIlllIlII) {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllIIlllIlIIIIlIllllIII);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm = new ModelRenderer(this, 40, 16);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllIIlllIlIIIIlIllllIII);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllIIlllIlIIIIlIllllIII);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllIIlllIlIIIIlIllllIII);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIIlllIlIIIIlIlIIlIII, final float llllllllllllIIlllIlIIIIlIlIlIIll, final float llllllllllllIIlllIlIIIIlIlIIIllI, final float llllllllllllIIlllIlIIIIlIlIIIlIl, final float llllllllllllIIlllIlIIIIlIlIlIIII, final float llllllllllllIIlllIlIIIIlIlIIIIll, final Entity llllllllllllIIlllIlIIIIlIlIIlllI) {
        super.setRotationAngles(llllllllllllIIlllIlIIIIlIlIIlIII, llllllllllllIIlllIlIIIIlIlIlIIll, llllllllllllIIlllIlIIIIlIlIIIllI, llllllllllllIIlllIlIIIIlIlIIIlIl, llllllllllllIIlllIlIIIIlIlIlIIII, llllllllllllIIlllIlIIIIlIlIIIIll, llllllllllllIIlllIlIIIIlIlIIlllI);
        final ItemStack llllllllllllIIlllIlIIIIlIlIIllIl = ((EntityLivingBase)llllllllllllIIlllIlIIIIlIlIIlllI).getHeldItemMainhand();
        final AbstractSkeleton llllllllllllIIlllIlIIIIlIlIIllII = (AbstractSkeleton)llllllllllllIIlllIlIIIIlIlIIlllI;
        if (llllllllllllIIlllIlIIIIlIlIIllII.isSwingingArms() && (llllllllllllIIlllIlIIIIlIlIIllIl.func_190926_b() || llllllllllllIIlllIlIIIIlIlIIllIl.getItem() != Items.BOW)) {
            final float llllllllllllIIlllIlIIIIlIlIIlIll = MathHelper.sin(this.swingProgress * 3.1415927f);
            final float llllllllllllIIlllIlIIIIlIlIIlIlI = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - llllllllllllIIlllIlIIIIlIlIIlIll * 0.6f);
            this.bipedLeftArm.rotateAngleY = 0.1f - llllllllllllIIlllIlIIIIlIlIIlIll * 0.6f;
            this.bipedRightArm.rotateAngleX = -1.5707964f;
            this.bipedLeftArm.rotateAngleX = -1.5707964f;
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= llllllllllllIIlllIlIIIIlIlIIlIll * 1.2f - llllllllllllIIlllIlIIIIlIlIIlIlI * 0.4f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= llllllllllllIIlllIlIIIIlIlIIlIll * 1.2f - llllllllllllIIlllIlIIIIlIlIIlIlI * 0.4f;
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleZ += MathHelper.cos(llllllllllllIIlllIlIIIIlIlIIIllI * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleZ -= MathHelper.cos(llllllllllllIIlllIlIIIIlIlIIIllI * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleX += MathHelper.sin(llllllllllllIIlllIlIIIIlIlIIIllI * 0.067f) * 0.05f;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX -= MathHelper.sin(llllllllllllIIlllIlIIIIlIlIIIllI * 0.067f) * 0.05f;
        }
    }
}
