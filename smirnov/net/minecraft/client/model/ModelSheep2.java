// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.EntityLivingBase;

public class ModelSheep2 extends ModelQuadruped
{
    private /* synthetic */ float headRotationAngleX;
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllIIlllIIlIIIlIIllIllII, final float lllllllllllIIlllIIlIIIlIIllIIllI, final float lllllllllllIIlllIIlIIIlIIllIlIlI, final float lllllllllllIIlllIIlIIIlIIllIIlII) {
        super.setLivingAnimations(lllllllllllIIlllIIlIIIlIIllIllII, lllllllllllIIlllIIlIIIlIIllIIllI, lllllllllllIIlllIIlIIIlIIllIlIlI, lllllllllllIIlllIIlIIIlIIllIIlII);
        this.head.rotationPointY = 6.0f + ((EntitySheep)lllllllllllIIlllIIlIIIlIIllIllII).getHeadRotationPointY(lllllllllllIIlllIIlIIIlIIllIIlII) * 9.0f;
        this.headRotationAngleX = ((EntitySheep)lllllllllllIIlllIIlIIIlIIllIllII).getHeadRotationAngleX(lllllllllllIIlllIIlIIIlIIllIIlII);
    }
    
    public ModelSheep2() {
        super(12, 0.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.head.setRotationPoint(0.0f, 6.0f, -8.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIlllIIlIIIlIIlIlIIlI, final float lllllllllllIIlllIIlIIIlIIlIllIIl, final float lllllllllllIIlllIIlIIIlIIlIlIIII, final float lllllllllllIIlllIIlIIIlIIlIlIlll, final float lllllllllllIIlllIIlIIIlIIlIlIllI, final float lllllllllllIIlllIIlIIIlIIlIIllIl, final Entity lllllllllllIIlllIIlIIIlIIlIlIlII) {
        super.setRotationAngles(lllllllllllIIlllIIlIIIlIIlIlIIlI, lllllllllllIIlllIIlIIIlIIlIllIIl, lllllllllllIIlllIIlIIIlIIlIlIIII, lllllllllllIIlllIIlIIIlIIlIlIlll, lllllllllllIIlllIIlIIIlIIlIlIllI, lllllllllllIIlllIIlIIIlIIlIIllIl, lllllllllllIIlllIIlIIIlIIlIlIlII);
        this.head.rotateAngleX = this.headRotationAngleX;
    }
}
