// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.Entity;

public class ModelZombie extends ModelBiped
{
    public ModelZombie() {
        this(0.0f, false);
    }
    
    public ModelZombie(final float lllllllllllllIlIIIlIllIlIlIIlIII, final boolean lllllllllllllIlIIIlIllIlIlIIIlll) {
        super(lllllllllllllIlIIIlIllIlIlIIlIII, 0.0f, 64, lllllllllllllIlIIIlIllIlIlIIIlll ? 32 : 64);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIlIllIlIIlIlIlI, final float lllllllllllllIlIIIlIllIlIIlIlIIl, final float lllllllllllllIlIIIlIllIlIIlIlIII, final float lllllllllllllIlIIIlIllIlIIllIIll, final float lllllllllllllIlIIIlIllIlIIlIIllI, final float lllllllllllllIlIIIlIllIlIIlIIlIl, final Entity lllllllllllllIlIIIlIllIlIIllIIII) {
        super.setRotationAngles(lllllllllllllIlIIIlIllIlIIlIlIlI, lllllllllllllIlIIIlIllIlIIlIlIIl, lllllllllllllIlIIIlIllIlIIlIlIII, lllllllllllllIlIIIlIllIlIIllIIll, lllllllllllllIlIIIlIllIlIIlIIllI, lllllllllllllIlIIIlIllIlIIlIIlIl, lllllllllllllIlIIIlIllIlIIllIIII);
        final boolean lllllllllllllIlIIIlIllIlIIlIllll = lllllllllllllIlIIIlIllIlIIllIIII instanceof EntityZombie && ((EntityZombie)lllllllllllllIlIIIlIllIlIIllIIII).isArmsRaised();
        final float lllllllllllllIlIIIlIllIlIIlIlllI = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float lllllllllllllIlIIIlIllIlIIlIllIl = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - lllllllllllllIlIIIlIllIlIIlIlllI * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - lllllllllllllIlIIIlIllIlIIlIlllI * 0.6f;
        final float lllllllllllllIlIIIlIllIlIIlIllII = -3.1415927f / (lllllllllllllIlIIIlIllIlIIlIllll ? 1.5f : 2.25f);
        this.bipedRightArm.rotateAngleX = lllllllllllllIlIIIlIllIlIIlIllII;
        this.bipedLeftArm.rotateAngleX = lllllllllllllIlIIIlIllIlIIlIllII;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX += lllllllllllllIlIIIlIllIlIIlIlllI * 1.2f - lllllllllllllIlIIIlIllIlIIlIllIl * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX += lllllllllllllIlIIIlIllIlIIlIlllI * 1.2f - lllllllllllllIlIIIlIllIlIIlIllIl * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(lllllllllllllIlIIIlIllIlIIlIlIII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(lllllllllllllIlIIIlIllIlIIlIlIII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(lllllllllllllIlIIIlIllIlIIlIlIII * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(lllllllllllllIlIIIlIllIlIIlIlIII * 0.067f) * 0.05f;
    }
}
