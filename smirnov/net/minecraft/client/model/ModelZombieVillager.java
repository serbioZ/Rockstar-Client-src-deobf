// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.Entity;

public class ModelZombieVillager extends ModelBiped
{
    public ModelZombieVillager() {
        this(0.0f, 0.0f, false);
    }
    
    public ModelZombieVillager(final float lllllllllllllIIlllIlIlIlIllllIlI, final float lllllllllllllIIlllIlIlIlIlllllIl, final boolean lllllllllllllIIlllIlIlIlIlllllII) {
        super(lllllllllllllIIlllIlIlIlIllllIlI, 0.0f, 64, lllllllllllllIIlllIlIlIlIlllllII ? 32 : 64);
        if (lllllllllllllIIlllIlIlIlIlllllII) {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.addBox(-4.0f, -10.0f, -4.0f, 8, 8, 8, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedBody = new ModelRenderer(this, 16, 16);
            this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI + 0.1f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI + 0.1f);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI + 0.1f);
        }
        else {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.setRotationPoint(0.0f, lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedHead.setTextureOffset(24, 0).addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedBody = new ModelRenderer(this, 16, 20);
            this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedBody.addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, lllllllllllllIIlllIlIlIlIllllIlI + 0.05f);
            this.bipedRightArm = new ModelRenderer(this, 44, 38);
            this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedLeftArm = new ModelRenderer(this, 44, 38);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 22);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 22);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + lllllllllllllIIlllIlIlIlIlllllIl, 0.0f);
            this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllIlIlIlIllllIlI);
        }
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIlllIlIlIlIlIllllI, final float lllllllllllllIIlllIlIlIlIllIlIIl, final float lllllllllllllIIlllIlIlIlIlIlllII, final float lllllllllllllIIlllIlIlIlIlIllIll, final float lllllllllllllIIlllIlIlIlIllIIllI, final float lllllllllllllIIlllIlIlIlIllIIlIl, final Entity lllllllllllllIIlllIlIlIlIllIIlII) {
        super.setRotationAngles(lllllllllllllIIlllIlIlIlIlIllllI, lllllllllllllIIlllIlIlIlIllIlIIl, lllllllllllllIIlllIlIlIlIlIlllII, lllllllllllllIIlllIlIlIlIlIllIll, lllllllllllllIIlllIlIlIlIllIIllI, lllllllllllllIIlllIlIlIlIllIIlIl, lllllllllllllIIlllIlIlIlIllIIlII);
        final EntityZombie lllllllllllllIIlllIlIlIlIllIIIll = (EntityZombie)lllllllllllllIIlllIlIlIlIllIIlII;
        final float lllllllllllllIIlllIlIlIlIllIIIlI = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float lllllllllllllIIlllIlIlIlIllIIIIl = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - lllllllllllllIIlllIlIlIlIllIIIlI * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - lllllllllllllIIlllIlIlIlIllIIIlI * 0.6f;
        final float lllllllllllllIIlllIlIlIlIllIIIII = -3.1415927f / (lllllllllllllIIlllIlIlIlIllIIIll.isArmsRaised() ? 1.5f : 2.25f);
        this.bipedRightArm.rotateAngleX = lllllllllllllIIlllIlIlIlIllIIIII;
        this.bipedLeftArm.rotateAngleX = lllllllllllllIIlllIlIlIlIllIIIII;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX += lllllllllllllIIlllIlIlIlIllIIIlI * 1.2f - lllllllllllllIIlllIlIlIlIllIIIIl * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX += lllllllllllllIIlllIlIlIlIllIIIlI * 1.2f - lllllllllllllIIlllIlIlIlIllIIIIl * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(lllllllllllllIIlllIlIlIlIlIlllII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(lllllllllllllIIlllIlIlIlIlIlllII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(lllllllllllllIIlllIlIlIlIlIlllII * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(lllllllllllllIIlllIlIlIlIlIlllII * 0.067f) * 0.05f;
    }
}
