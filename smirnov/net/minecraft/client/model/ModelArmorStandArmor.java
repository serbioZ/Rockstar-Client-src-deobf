// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.Entity;

public class ModelArmorStandArmor extends ModelBiped
{
    @Override
    public void setRotationAngles(final float lllllllllllllIllllIIlIIIIIIlllll, final float lllllllllllllIllllIIlIIIIIIllllI, final float lllllllllllllIllllIIlIIIIIIlllIl, final float lllllllllllllIllllIIlIIIIIIlllII, final float lllllllllllllIllllIIlIIIIIIllIll, final float lllllllllllllIllllIIlIIIIIIllIlI, final Entity lllllllllllllIllllIIlIIIIIIlIllI) {
        if (lllllllllllllIllllIIlIIIIIIlIllI instanceof EntityArmorStand) {
            final EntityArmorStand lllllllllllllIllllIIlIIIIIIllIII = (EntityArmorStand)lllllllllllllIllllIIlIIIIIIlIllI;
            this.bipedHead.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getHeadRotation().getX();
            this.bipedHead.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getHeadRotation().getY();
            this.bipedHead.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getHeadRotation().getZ();
            this.bipedHead.setRotationPoint(0.0f, 1.0f, 0.0f);
            this.bipedBody.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getBodyRotation().getX();
            this.bipedBody.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getBodyRotation().getY();
            this.bipedBody.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getBodyRotation().getZ();
            this.bipedLeftArm.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftArmRotation().getX();
            this.bipedLeftArm.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftArmRotation().getY();
            this.bipedLeftArm.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftArmRotation().getZ();
            this.bipedRightArm.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightArmRotation().getX();
            this.bipedRightArm.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightArmRotation().getY();
            this.bipedRightArm.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightArmRotation().getZ();
            this.bipedLeftLeg.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftLegRotation().getX();
            this.bipedLeftLeg.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftLegRotation().getY();
            this.bipedLeftLeg.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getLeftLegRotation().getZ();
            this.bipedLeftLeg.setRotationPoint(1.9f, 11.0f, 0.0f);
            this.bipedRightLeg.rotateAngleX = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightLegRotation().getX();
            this.bipedRightLeg.rotateAngleY = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightLegRotation().getY();
            this.bipedRightLeg.rotateAngleZ = 0.017453292f * lllllllllllllIllllIIlIIIIIIllIII.getRightLegRotation().getZ();
            this.bipedRightLeg.setRotationPoint(-1.9f, 11.0f, 0.0f);
            ModelBase.copyModelAngles(this.bipedHead, this.bipedHeadwear);
        }
    }
    
    public ModelArmorStandArmor(final float lllllllllllllIllllIIlIIIIIllIIlI) {
        this(lllllllllllllIllllIIlIIIIIllIIlI, 64, 32);
    }
    
    public ModelArmorStandArmor() {
        this(0.0f);
    }
    
    protected ModelArmorStandArmor(final float lllllllllllllIllllIIlIIIIIlIIllI, final int lllllllllllllIllllIIlIIIIIlIIlIl, final int lllllllllllllIllllIIlIIIIIlIIlII) {
        super(lllllllllllllIllllIIlIIIIIlIIllI, 0.0f, lllllllllllllIllllIIlIIIIIlIIlIl, lllllllllllllIllllIIlIIIIIlIIlII);
    }
}
