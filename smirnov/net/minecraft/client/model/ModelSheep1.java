// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelSheep1 extends ModelQuadruped
{
    private /* synthetic */ float headRotationAngleX;
    
    public ModelSheep1() {
        super(12, 0.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0f, -4.0f, -4.0f, 6, 6, 6, 0.6f);
        this.head.setRotationPoint(0.0f, 6.0f, -8.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 1.75f);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
        final float lllllllllllIIlIllllIlIlIIIllIllI = 0.5f;
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f);
        this.leg1.setRotationPoint(-3.0f, 12.0f, 7.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f);
        this.leg2.setRotationPoint(3.0f, 12.0f, 7.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f);
        this.leg3.setRotationPoint(-3.0f, 12.0f, -5.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.5f);
        this.leg4.setRotationPoint(3.0f, 12.0f, -5.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIlIllllIlIlIIIIlIIll, final float lllllllllllIIlIllllIlIlIIIIllIlI, final float lllllllllllIIlIllllIlIlIIIIlIIIl, final float lllllllllllIIlIllllIlIlIIIIllIII, final float lllllllllllIIlIllllIlIlIIIIlIlll, final float lllllllllllIIlIllllIlIlIIIIIlllI, final Entity lllllllllllIIlIllllIlIlIIIIIllIl) {
        super.setRotationAngles(lllllllllllIIlIllllIlIlIIIIlIIll, lllllllllllIIlIllllIlIlIIIIllIlI, lllllllllllIIlIllllIlIlIIIIlIIIl, lllllllllllIIlIllllIlIlIIIIllIII, lllllllllllIIlIllllIlIlIIIIlIlll, lllllllllllIIlIllllIlIlIIIIIlllI, lllllllllllIIlIllllIlIlIIIIIllIl);
        this.head.rotateAngleX = this.headRotationAngleX;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllIIlIllllIlIlIIIlIllIl, final float lllllllllllIIlIllllIlIlIIIlIIlll, final float lllllllllllIIlIllllIlIlIIIlIlIll, final float lllllllllllIIlIllllIlIlIIIlIIlIl) {
        super.setLivingAnimations(lllllllllllIIlIllllIlIlIIIlIllIl, lllllllllllIIlIllllIlIlIIIlIIlll, lllllllllllIIlIllllIlIlIIIlIlIll, lllllllllllIIlIllllIlIlIIIlIIlIl);
        this.head.rotationPointY = 6.0f + ((EntitySheep)lllllllllllIIlIllllIlIlIIIlIllIl).getHeadRotationPointY(lllllllllllIIlIllllIlIlIIIlIIlIl) * 9.0f;
        this.headRotationAngleX = ((EntitySheep)lllllllllllIIlIllllIlIlIIIlIllIl).getHeadRotationAngleX(lllllllllllIIlIllllIlIlIIIlIIlIl);
    }
}
