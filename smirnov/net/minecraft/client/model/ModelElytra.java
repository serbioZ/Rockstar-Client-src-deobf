// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelElytra extends ModelBase
{
    private final /* synthetic */ ModelRenderer rightWing;
    private final /* synthetic */ ModelRenderer leftWing;
    
    @Override
    public void setRotationAngles(final float lllllllllllIIllIIlIllIllIIIIIlIl, final float lllllllllllIIllIIlIllIllIIIIIlII, final float lllllllllllIIllIIlIllIllIIIIIIll, final float lllllllllllIIllIIlIllIllIIIIIIlI, final float lllllllllllIIllIIlIllIllIIIIIIIl, final float lllllllllllIIllIIlIllIllIIIIllll, final Entity lllllllllllIIllIIlIllIlIllllllll) {
        super.setRotationAngles(lllllllllllIIllIIlIllIllIIIIIlIl, lllllllllllIIllIIlIllIllIIIIIlII, lllllllllllIIllIIlIllIllIIIIIIll, lllllllllllIIllIIlIllIllIIIIIIlI, lllllllllllIIllIIlIllIllIIIIIIIl, lllllllllllIIllIIlIllIllIIIIllll, lllllllllllIIllIIlIllIlIllllllll);
        float lllllllllllIIllIIlIllIllIIIIllIl = 0.2617994f;
        float lllllllllllIIllIIlIllIllIIIIllII = -0.2617994f;
        float lllllllllllIIllIIlIllIllIIIIlIll = 0.0f;
        float lllllllllllIIllIIlIllIllIIIIlIlI = 0.0f;
        if (lllllllllllIIllIIlIllIlIllllllll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllIIllIIlIllIlIllllllll).isElytraFlying()) {
            float lllllllllllIIllIIlIllIllIIIIlIIl = 1.0f;
            if (lllllllllllIIllIIlIllIlIllllllll.motionY < 0.0) {
                final Vec3d lllllllllllIIllIIlIllIllIIIIlIII = new Vec3d(lllllllllllIIllIIlIllIlIllllllll.motionX, lllllllllllIIllIIlIllIlIllllllll.motionY, lllllllllllIIllIIlIllIlIllllllll.motionZ).normalize();
                lllllllllllIIllIIlIllIllIIIIlIIl = 1.0f - (float)Math.pow(-lllllllllllIIllIIlIllIllIIIIlIII.yCoord, 1.5);
            }
            lllllllllllIIllIIlIllIllIIIIllIl = lllllllllllIIllIIlIllIllIIIIlIIl * 0.34906584f + (1.0f - lllllllllllIIllIIlIllIllIIIIlIIl) * lllllllllllIIllIIlIllIllIIIIllIl;
            lllllllllllIIllIIlIllIllIIIIllII = lllllllllllIIllIIlIllIllIIIIlIIl * -1.5707964f + (1.0f - lllllllllllIIllIIlIllIllIIIIlIIl) * lllllllllllIIllIIlIllIllIIIIllII;
        }
        else if (lllllllllllIIllIIlIllIlIllllllll.isSneaking()) {
            lllllllllllIIllIIlIllIllIIIIllIl = 0.69813174f;
            lllllllllllIIllIIlIllIllIIIIllII = -0.7853982f;
            lllllllllllIIllIIlIllIllIIIIlIll = 3.0f;
            lllllllllllIIllIIlIllIllIIIIlIlI = 0.08726646f;
        }
        this.leftWing.rotationPointX = 5.0f;
        this.leftWing.rotationPointY = lllllllllllIIllIIlIllIllIIIIlIll;
        if (lllllllllllIIllIIlIllIlIllllllll instanceof AbstractClientPlayer) {
            final AbstractClientPlayer lllllllllllIIllIIlIllIllIIIIIlll = (AbstractClientPlayer)lllllllllllIIllIIlIllIlIllllllll;
            lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraX += (float)((lllllllllllIIllIIlIllIllIIIIllIl - lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraX) * 0.1);
            lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraY += (float)((lllllllllllIIllIIlIllIllIIIIlIlI - lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraY) * 0.1);
            lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraZ += (float)((lllllllllllIIllIIlIllIllIIIIllII - lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraZ) * 0.1);
            this.leftWing.rotateAngleX = lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraX;
            this.leftWing.rotateAngleY = lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraY;
            this.leftWing.rotateAngleZ = lllllllllllIIllIIlIllIllIIIIIlll.rotateElytraZ;
        }
        else {
            this.leftWing.rotateAngleX = lllllllllllIIllIIlIllIllIIIIllIl;
            this.leftWing.rotateAngleZ = lllllllllllIIllIIlIllIllIIIIllII;
            this.leftWing.rotateAngleY = lllllllllllIIllIIlIllIllIIIIlIlI;
        }
        this.rightWing.rotationPointX = -this.leftWing.rotationPointX;
        this.rightWing.rotateAngleY = -this.leftWing.rotateAngleY;
        this.rightWing.rotationPointY = this.leftWing.rotationPointY;
        this.rightWing.rotateAngleX = this.leftWing.rotateAngleX;
        this.rightWing.rotateAngleZ = -this.leftWing.rotateAngleZ;
    }
    
    public ModelElytra() {
        this.leftWing = new ModelRenderer(this, 22, 0);
        this.leftWing.addBox(-10.0f, 0.0f, 0.0f, 10, 20, 2, 1.0f);
        this.rightWing = new ModelRenderer(this, 22, 0);
        this.rightWing.mirror = true;
        this.rightWing.addBox(0.0f, 0.0f, 0.0f, 10, 20, 2, 1.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllIIllIIlIllIllIIlIllIl, final float lllllllllllIIllIIlIllIllIIlIllII, final float lllllllllllIIllIIlIllIllIIlIlIll, final float lllllllllllIIllIIlIllIllIIlIlIlI, final float lllllllllllIIllIIlIllIllIIlIlIIl, final float lllllllllllIIllIIlIllIllIIlIlIII, final float lllllllllllIIllIIlIllIllIIlIIlll) {
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableCull();
        if (lllllllllllIIllIIlIllIllIIlIllIl instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllIIllIIlIllIllIIlIllIl).isChild()) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 1.5f, -0.1f);
            this.leftWing.render(lllllllllllIIllIIlIllIllIIlIIlll);
            this.rightWing.render(lllllllllllIIllIIlIllIllIIlIIlll);
            GlStateManager.popMatrix();
        }
        else {
            this.leftWing.render(lllllllllllIIllIIlIllIllIIlIIlll);
            this.rightWing.render(lllllllllllIIllIIlIllIllIIlIIlll);
        }
    }
}
