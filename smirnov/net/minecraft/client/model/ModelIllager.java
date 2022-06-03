// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.EnumHandSide;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelIllager extends ModelBase
{
    public /* synthetic */ ModelRenderer field_191221_e;
    public /* synthetic */ ModelRenderer field_191224_h;
    public /* synthetic */ ModelRenderer field_191219_c;
    public /* synthetic */ ModelRenderer field_191220_d;
    public /* synthetic */ ModelRenderer field_193775_b;
    public /* synthetic */ ModelRenderer field_191223_g;
    public /* synthetic */ ModelRenderer field_191217_a;
    public /* synthetic */ ModelRenderer field_191222_f;
    public /* synthetic */ ModelRenderer field_191218_b;
    
    @Override
    public void setRotationAngles(final float lllllllllllIIlllllIIIIIIIIIllIll, final float lllllllllllIIlllllIIIIIIIIIllIlI, final float lllllllllllIIlllllIIIIIIIIIllIIl, final float lllllllllllIIlllllIIIIIIIIlIIIll, final float lllllllllllIIlllllIIIIIIIIIlIlll, final float lllllllllllIIlllllIIIIIIIIlIIIIl, final Entity lllllllllllIIlllllIIIIIIIIIlIllI) {
        this.field_191217_a.rotateAngleY = lllllllllllIIlllllIIIIIIIIlIIIll * 0.017453292f;
        this.field_191217_a.rotateAngleX = lllllllllllIIlllllIIIIIIIIIlIlll * 0.017453292f;
        this.field_191219_c.rotationPointY = 3.0f;
        this.field_191219_c.rotationPointZ = -1.0f;
        this.field_191219_c.rotateAngleX = -0.75f;
        this.field_191220_d.rotateAngleX = MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIll * 0.6662f) * 1.4f * lllllllllllIIlllllIIIIIIIIIllIlI * 0.5f;
        this.field_191221_e.rotateAngleX = MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIll * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIIlllllIIIIIIIIIllIlI * 0.5f;
        this.field_191220_d.rotateAngleY = 0.0f;
        this.field_191221_e.rotateAngleY = 0.0f;
        final AbstractIllager.IllagerArmPose lllllllllllIIlllllIIIIIIIIIlllll = ((AbstractIllager)lllllllllllIIlllllIIIIIIIIIlIllI).func_193077_p();
        if (lllllllllllIIlllllIIIIIIIIIlllll == AbstractIllager.IllagerArmPose.ATTACKING) {
            final float lllllllllllIIlllllIIIIIIIIIllllI = MathHelper.sin(this.swingProgress * 3.1415927f);
            final float lllllllllllIIlllllIIIIIIIIIlllIl = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
            this.field_191223_g.rotateAngleZ = 0.0f;
            this.field_191224_h.rotateAngleZ = 0.0f;
            this.field_191223_g.rotateAngleY = 0.15707964f;
            this.field_191224_h.rotateAngleY = -0.15707964f;
            if (((EntityLivingBase)lllllllllllIIlllllIIIIIIIIIlIllI).getPrimaryHand() == EnumHandSide.RIGHT) {
                this.field_191223_g.rotateAngleX = -1.8849558f + MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.09f) * 0.15f;
                this.field_191224_h.rotateAngleX = -0.0f + MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.19f) * 0.5f;
                final ModelRenderer field_191223_g = this.field_191223_g;
                field_191223_g.rotateAngleX += lllllllllllIIlllllIIIIIIIIIllllI * 2.2f - lllllllllllIIlllllIIIIIIIIIlllIl * 0.4f;
                final ModelRenderer field_191224_h = this.field_191224_h;
                field_191224_h.rotateAngleX += lllllllllllIIlllllIIIIIIIIIllllI * 1.2f - lllllllllllIIlllllIIIIIIIIIlllIl * 0.4f;
            }
            else {
                this.field_191223_g.rotateAngleX = -0.0f + MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.19f) * 0.5f;
                this.field_191224_h.rotateAngleX = -1.8849558f + MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.09f) * 0.15f;
                final ModelRenderer field_191223_g2 = this.field_191223_g;
                field_191223_g2.rotateAngleX += lllllllllllIIlllllIIIIIIIIIllllI * 1.2f - lllllllllllIIlllllIIIIIIIIIlllIl * 0.4f;
                final ModelRenderer field_191224_h2 = this.field_191224_h;
                field_191224_h2.rotateAngleX += lllllllllllIIlllllIIIIIIIIIllllI * 2.2f - lllllllllllIIlllllIIIIIIIIIlllIl * 0.4f;
            }
            final ModelRenderer field_191223_g3 = this.field_191223_g;
            field_191223_g3.rotateAngleZ += MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_191224_h3 = this.field_191224_h;
            field_191224_h3.rotateAngleZ -= MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_191223_g4 = this.field_191223_g;
            field_191223_g4.rotateAngleX += MathHelper.sin(lllllllllllIIlllllIIIIIIIIIllIIl * 0.067f) * 0.05f;
            final ModelRenderer field_191224_h4 = this.field_191224_h;
            field_191224_h4.rotateAngleX -= MathHelper.sin(lllllllllllIIlllllIIIIIIIIIllIIl * 0.067f) * 0.05f;
        }
        else if (lllllllllllIIlllllIIIIIIIIIlllll == AbstractIllager.IllagerArmPose.SPELLCASTING) {
            this.field_191223_g.rotationPointZ = 0.0f;
            this.field_191223_g.rotationPointX = -5.0f;
            this.field_191224_h.rotationPointZ = 0.0f;
            this.field_191224_h.rotationPointX = 5.0f;
            this.field_191223_g.rotateAngleX = MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.6662f) * 0.25f;
            this.field_191224_h.rotateAngleX = MathHelper.cos(lllllllllllIIlllllIIIIIIIIIllIIl * 0.6662f) * 0.25f;
            this.field_191223_g.rotateAngleZ = 2.3561945f;
            this.field_191224_h.rotateAngleZ = -2.3561945f;
            this.field_191223_g.rotateAngleY = 0.0f;
            this.field_191224_h.rotateAngleY = 0.0f;
        }
        else if (lllllllllllIIlllllIIIIIIIIIlllll == AbstractIllager.IllagerArmPose.BOW_AND_ARROW) {
            this.field_191223_g.rotateAngleY = -0.1f + this.field_191217_a.rotateAngleY;
            this.field_191223_g.rotateAngleX = -1.5707964f + this.field_191217_a.rotateAngleX;
            this.field_191224_h.rotateAngleX = -0.9424779f + this.field_191217_a.rotateAngleX;
            this.field_191224_h.rotateAngleY = this.field_191217_a.rotateAngleY - 0.4f;
            this.field_191224_h.rotateAngleZ = 1.5707964f;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllIIlllllIIIIIIIlIIIIlI, final float lllllllllllIIlllllIIIIIIIIlllIII, final float lllllllllllIIlllllIIIIIIIIllIlll, final float lllllllllllIIlllllIIIIIIIIllllll, final float lllllllllllIIlllllIIIIIIIIllIlIl, final float lllllllllllIIlllllIIIIIIIIllllIl, final float lllllllllllIIlllllIIIIIIIIllIIll) {
        this.setRotationAngles(lllllllllllIIlllllIIIIIIIIlllIII, lllllllllllIIlllllIIIIIIIIllIlll, lllllllllllIIlllllIIIIIIIIllllll, lllllllllllIIlllllIIIIIIIIllIlIl, lllllllllllIIlllllIIIIIIIIllllIl, lllllllllllIIlllllIIIIIIIIllIIll, lllllllllllIIlllllIIIIIIIlIIIIlI);
        this.field_191217_a.render(lllllllllllIIlllllIIIIIIIIllIIll);
        this.field_191218_b.render(lllllllllllIIlllllIIIIIIIIllIIll);
        this.field_191220_d.render(lllllllllllIIlllllIIIIIIIIllIIll);
        this.field_191221_e.render(lllllllllllIIlllllIIIIIIIIllIIll);
        final AbstractIllager lllllllllllIIlllllIIIIIIIIlllIll = (AbstractIllager)lllllllllllIIlllllIIIIIIIlIIIIlI;
        if (lllllllllllIIlllllIIIIIIIIlllIll.func_193077_p() == AbstractIllager.IllagerArmPose.CROSSED) {
            this.field_191219_c.render(lllllllllllIIlllllIIIIIIIIllIIll);
        }
        else {
            this.field_191223_g.render(lllllllllllIIlllllIIIIIIIIllIIll);
            this.field_191224_h.render(lllllllllllIIlllllIIIIIIIIllIIll);
        }
    }
    
    public ModelRenderer func_191216_a(final EnumHandSide lllllllllllIIlllllIIIIIIIIIIllIl) {
        return (lllllllllllIIlllllIIIIIIIIIIllIl == EnumHandSide.LEFT) ? this.field_191224_h : this.field_191223_g;
    }
    
    public ModelIllager(final float lllllllllllIIlllllIIIIIIIlIlIlll, final float lllllllllllIIlllllIIIIIIIlIlIIII, final int lllllllllllIIlllllIIIIIIIlIIllll, final int lllllllllllIIlllllIIIIIIIlIIlllI) {
        this.field_191217_a = new ModelRenderer(this).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191217_a.setRotationPoint(0.0f, 0.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
        this.field_191217_a.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_193775_b = new ModelRenderer(this, 32, 0).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_193775_b.addBox(-4.0f, -10.0f, -4.0f, 8, 12, 8, lllllllllllIIlllllIIIIIIIlIlIlll + 0.45f);
        this.field_191217_a.addChild(this.field_193775_b);
        this.field_193775_b.showModel = false;
        this.field_191222_f = new ModelRenderer(this).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191222_f.setRotationPoint(0.0f, lllllllllllIIlllllIIIIIIIlIlIIII - 2.0f, 0.0f);
        this.field_191222_f.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191217_a.addChild(this.field_191222_f);
        this.field_191218_b = new ModelRenderer(this).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191218_b.setRotationPoint(0.0f, 0.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
        this.field_191218_b.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191218_b.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, lllllllllllIIlllllIIIIIIIlIlIlll + 0.5f);
        this.field_191219_c = new ModelRenderer(this).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191219_c.setRotationPoint(0.0f, 0.0f + lllllllllllIIlllllIIIIIIIlIlIIII + 2.0f, 0.0f);
        this.field_191219_c.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        final ModelRenderer lllllllllllIIlllllIIIIIIIlIlIIll = new ModelRenderer(this, 44, 22).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        lllllllllllIIlllllIIIIIIIlIlIIll.mirror = true;
        lllllllllllIIlllllIIIIIIIlIlIIll.addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191219_c.addChild(lllllllllllIIlllllIIIIIIIlIlIIll);
        this.field_191219_c.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191220_d = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191220_d.setRotationPoint(-2.0f, 12.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
        this.field_191220_d.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191221_e = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191221_e.mirror = true;
        this.field_191221_e.setRotationPoint(2.0f, 12.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
        this.field_191221_e.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191223_g = new ModelRenderer(this, 40, 46).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191223_g.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191223_g.setRotationPoint(-5.0f, 2.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
        this.field_191224_h = new ModelRenderer(this, 40, 46).setTextureSize(lllllllllllIIlllllIIIIIIIlIIllll, lllllllllllIIlllllIIIIIIIlIIlllI);
        this.field_191224_h.mirror = true;
        this.field_191224_h.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllIIlllllIIIIIIIlIlIlll);
        this.field_191224_h.setRotationPoint(5.0f, 2.0f + lllllllllllIIlllllIIIIIIIlIlIIII, 0.0f);
    }
}
