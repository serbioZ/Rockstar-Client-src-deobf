// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelIronGolem extends ModelBase
{
    public /* synthetic */ ModelRenderer ironGolemLeftArm;
    public /* synthetic */ ModelRenderer ironGolemLeftLeg;
    public /* synthetic */ ModelRenderer ironGolemRightLeg;
    public /* synthetic */ ModelRenderer ironGolemBody;
    public /* synthetic */ ModelRenderer ironGolemHead;
    public /* synthetic */ ModelRenderer ironGolemRightArm;
    
    public ModelIronGolem(final float lllllllllllIlIIlIIIllIlllIlIlIlI, final float lllllllllllIlIIlIIIllIlllIlIlIIl) {
        final int lllllllllllIlIIlIIIllIlllIlIllIl = 128;
        final int lllllllllllIlIIlIIIllIlllIlIllII = 128;
        this.ironGolemHead = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemHead.setRotationPoint(0.0f, 0.0f + lllllllllllIlIIlIIIllIlllIlIlIIl, -2.0f);
        this.ironGolemHead.setTextureOffset(0, 0).addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemHead.setTextureOffset(24, 0).addBox(-1.0f, -5.0f, -7.5f, 2, 4, 2, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemBody = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemBody.setRotationPoint(0.0f, 0.0f + lllllllllllIlIIlIIIllIlllIlIlIIl, 0.0f);
        this.ironGolemBody.setTextureOffset(0, 40).addBox(-9.0f, -2.0f, -6.0f, 18, 12, 11, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemBody.setTextureOffset(0, 70).addBox(-4.5f, 10.0f, -3.0f, 9, 5, 6, lllllllllllIlIIlIIIllIlllIlIlIlI + 0.5f);
        this.ironGolemRightArm = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemRightArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemRightArm.setTextureOffset(60, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemLeftArm = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemLeftArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemLeftArm.setTextureOffset(60, 58).addBox(9.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemLeftLeg = new ModelRenderer(this, 0, 22).setTextureSize(128, 128);
        this.ironGolemLeftLeg.setRotationPoint(-4.0f, 18.0f + lllllllllllIlIIlIIIllIlllIlIlIIl, 0.0f);
        this.ironGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllIlIIlIIIllIlllIlIlIlI);
        this.ironGolemRightLeg = new ModelRenderer(this, 0, 22).setTextureSize(128, 128);
        this.ironGolemRightLeg.mirror = true;
        this.ironGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0f, 18.0f + lllllllllllIlIIlIIIllIlllIlIlIIl, 0.0f);
        this.ironGolemRightLeg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllIlIIlIIIllIlllIlIlIlI);
    }
    
    public ModelIronGolem() {
        this(0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllIlIIlIIIllIlllIIlllIl, final float lllllllllllIlIIlIIIllIlllIIlllII, final float lllllllllllIlIIlIIIllIlllIIllIll, final float lllllllllllIlIIlIIIllIlllIIllIlI, final float lllllllllllIlIIlIIIllIlllIIlIIIl, final float lllllllllllIlIIlIIIllIlllIIlIIII, final float lllllllllllIlIIlIIIllIlllIIlIlll) {
        this.setRotationAngles(lllllllllllIlIIlIIIllIlllIIlllII, lllllllllllIlIIlIIIllIlllIIllIll, lllllllllllIlIIlIIIllIlllIIllIlI, lllllllllllIlIIlIIIllIlllIIlIIIl, lllllllllllIlIIlIIIllIlllIIlIIII, lllllllllllIlIIlIIIllIlllIIlIlll, lllllllllllIlIIlIIIllIlllIIlllIl);
        this.ironGolemHead.render(lllllllllllIlIIlIIIllIlllIIlIlll);
        this.ironGolemBody.render(lllllllllllIlIIlIIIllIlllIIlIlll);
        this.ironGolemLeftLeg.render(lllllllllllIlIIlIIIllIlllIIlIlll);
        this.ironGolemRightLeg.render(lllllllllllIlIIlIIIllIlllIIlIlll);
        this.ironGolemRightArm.render(lllllllllllIlIIlIIIllIlllIIlIlll);
        this.ironGolemLeftArm.render(lllllllllllIlIIlIIIllIlllIIlIlll);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIlIIlIIIllIlllIIIlIII, final float lllllllllllIlIIlIIIllIlllIIIIlll, final float lllllllllllIlIIlIIIllIlllIIIIllI, final float lllllllllllIlIIlIIIllIllIllllllI, final float lllllllllllIlIIlIIIllIllIlllllIl, final float lllllllllllIlIIlIIIllIlllIIIIIll, final Entity lllllllllllIlIIlIIIllIlllIIIIIlI) {
        this.ironGolemHead.rotateAngleY = lllllllllllIlIIlIIIllIllIllllllI * 0.017453292f;
        this.ironGolemHead.rotateAngleX = lllllllllllIlIIlIIIllIllIlllllIl * 0.017453292f;
        this.ironGolemLeftLeg.rotateAngleX = -1.5f * this.triangleWave(lllllllllllIlIIlIIIllIlllIIIlIII, 13.0f) * lllllllllllIlIIlIIIllIlllIIIIlll;
        this.ironGolemRightLeg.rotateAngleX = 1.5f * this.triangleWave(lllllllllllIlIIlIIIllIlllIIIlIII, 13.0f) * lllllllllllIlIIlIIIllIlllIIIIlll;
        this.ironGolemLeftLeg.rotateAngleY = 0.0f;
        this.ironGolemRightLeg.rotateAngleY = 0.0f;
    }
    
    private float triangleWave(final float lllllllllllIlIIlIIIllIllIlIlllll, final float lllllllllllIlIIlIIIllIllIllIIIII) {
        return (Math.abs(lllllllllllIlIIlIIIllIllIlIlllll % lllllllllllIlIIlIIIllIllIllIIIII - lllllllllllIlIIlIIIllIllIllIIIII * 0.5f) - lllllllllllIlIIlIIIllIllIllIIIII * 0.25f) / (lllllllllllIlIIlIIIllIllIllIIIII * 0.25f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllIlIIlIIIllIllIllIlIll, final float lllllllllllIlIIlIIIllIllIllIlIlI, final float lllllllllllIlIIlIIIllIllIllIlIIl, final float lllllllllllIlIIlIIIllIllIllIlIII) {
        final EntityIronGolem lllllllllllIlIIlIIIllIllIllIllll = (EntityIronGolem)lllllllllllIlIIlIIIllIllIllIlIll;
        final int lllllllllllIlIIlIIIllIllIllIlllI = lllllllllllIlIIlIIIllIllIllIllll.getAttackTimer();
        if (lllllllllllIlIIlIIIllIllIllIlllI > 0) {
            this.ironGolemRightArm.rotateAngleX = -2.0f + 1.5f * this.triangleWave(lllllllllllIlIIlIIIllIllIllIlllI - lllllllllllIlIIlIIIllIllIllIlIII, 10.0f);
            this.ironGolemLeftArm.rotateAngleX = -2.0f + 1.5f * this.triangleWave(lllllllllllIlIIlIIIllIllIllIlllI - lllllllllllIlIIlIIIllIllIllIlIII, 10.0f);
        }
        else {
            final int lllllllllllIlIIlIIIllIllIllIllIl = lllllllllllIlIIlIIIllIllIllIllll.getHoldRoseTick();
            if (lllllllllllIlIIlIIIllIllIllIllIl > 0) {
                this.ironGolemRightArm.rotateAngleX = -0.8f + 0.025f * this.triangleWave((float)lllllllllllIlIIlIIIllIllIllIllIl, 70.0f);
                this.ironGolemLeftArm.rotateAngleX = 0.0f;
            }
            else {
                this.ironGolemRightArm.rotateAngleX = (-0.2f + 1.5f * this.triangleWave(lllllllllllIlIIlIIIllIllIllIlIlI, 13.0f)) * lllllllllllIlIIlIIIllIllIllIlIIl;
                this.ironGolemLeftArm.rotateAngleX = (-0.2f - 1.5f * this.triangleWave(lllllllllllIlIIlIIIllIllIllIlIlI, 13.0f)) * lllllllllllIlIIlIIIllIllIllIlIIl;
            }
        }
    }
    
    public ModelIronGolem(final float lllllllllllIlIIlIIIllIlllIllIllI) {
        this(lllllllllllIlIIlIIIllIlllIllIllI, -7.0f);
    }
}
