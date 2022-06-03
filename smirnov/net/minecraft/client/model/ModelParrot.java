// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.EntityLivingBase;

public class ModelParrot extends ModelBase
{
    /* synthetic */ ModelRenderer field_192764_a;
    /* synthetic */ ModelRenderer field_192766_c;
    /* synthetic */ ModelRenderer field_192770_g;
    /* synthetic */ ModelRenderer field_192769_f;
    private /* synthetic */ State field_192775_l;
    /* synthetic */ ModelRenderer field_192773_j;
    /* synthetic */ ModelRenderer field_192772_i;
    /* synthetic */ ModelRenderer field_192771_h;
    /* synthetic */ ModelRenderer field_192768_e;
    /* synthetic */ ModelRenderer field_192774_k;
    /* synthetic */ ModelRenderer field_192765_b;
    /* synthetic */ ModelRenderer field_192767_d;
    
    public ModelParrot() {
        this.field_192775_l = State.STANDING;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.field_192764_a = new ModelRenderer(this, 2, 8);
        this.field_192764_a.addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.field_192764_a.setRotationPoint(0.0f, 16.5f, -3.0f);
        this.field_192765_b = new ModelRenderer(this, 22, 1);
        this.field_192765_b.addBox(-1.5f, -1.0f, -1.0f, 3, 4, 1);
        this.field_192765_b.setRotationPoint(0.0f, 21.07f, 1.16f);
        this.field_192766_c = new ModelRenderer(this, 19, 8);
        this.field_192766_c.addBox(-0.5f, 0.0f, -1.5f, 1, 5, 3);
        this.field_192766_c.setRotationPoint(1.5f, 16.94f, -2.76f);
        this.field_192767_d = new ModelRenderer(this, 19, 8);
        this.field_192767_d.addBox(-0.5f, 0.0f, -1.5f, 1, 5, 3);
        this.field_192767_d.setRotationPoint(-1.5f, 16.94f, -2.76f);
        this.field_192768_e = new ModelRenderer(this, 2, 2);
        this.field_192768_e.addBox(-1.0f, -1.5f, -1.0f, 2, 3, 2);
        this.field_192768_e.setRotationPoint(0.0f, 15.69f, -2.76f);
        this.field_192769_f = new ModelRenderer(this, 10, 0);
        this.field_192769_f.addBox(-1.0f, -0.5f, -2.0f, 2, 1, 4);
        this.field_192769_f.setRotationPoint(0.0f, -2.0f, -1.0f);
        this.field_192768_e.addChild(this.field_192769_f);
        this.field_192770_g = new ModelRenderer(this, 11, 7);
        this.field_192770_g.addBox(-0.5f, -1.0f, -0.5f, 1, 2, 1);
        this.field_192770_g.setRotationPoint(0.0f, -0.5f, -1.5f);
        this.field_192768_e.addChild(this.field_192770_g);
        this.field_192771_h = new ModelRenderer(this, 16, 7);
        this.field_192771_h.addBox(-0.5f, 0.0f, -0.5f, 1, 2, 1);
        this.field_192771_h.setRotationPoint(0.0f, -1.75f, -2.45f);
        this.field_192768_e.addChild(this.field_192771_h);
        this.field_192772_i = new ModelRenderer(this, 2, 18);
        this.field_192772_i.addBox(0.0f, -4.0f, -2.0f, 0, 5, 4);
        this.field_192772_i.setRotationPoint(0.0f, -2.15f, 0.15f);
        this.field_192768_e.addChild(this.field_192772_i);
        this.field_192773_j = new ModelRenderer(this, 14, 18);
        this.field_192773_j.addBox(-0.5f, 0.0f, -0.5f, 1, 2, 1);
        this.field_192773_j.setRotationPoint(1.0f, 22.0f, -1.05f);
        this.field_192774_k = new ModelRenderer(this, 14, 18);
        this.field_192774_k.addBox(-0.5f, 0.0f, -0.5f, 1, 2, 1);
        this.field_192774_k.setRotationPoint(-1.0f, 22.0f, -1.05f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllIIllIllllIlllIIIllll, final float llllllllllllIIllIllllIlllIIlIlIl, final float llllllllllllIIllIllllIlllIIlIlII, final float llllllllllllIIllIllllIlllIIlIIll) {
        this.field_192772_i.rotateAngleX = -0.2214f;
        this.field_192764_a.rotateAngleX = 0.4937f;
        this.field_192766_c.rotateAngleX = -0.69813174f;
        this.field_192766_c.rotateAngleY = -3.1415927f;
        this.field_192767_d.rotateAngleX = -0.69813174f;
        this.field_192767_d.rotateAngleY = -3.1415927f;
        this.field_192773_j.rotateAngleX = -0.0299f;
        this.field_192774_k.rotateAngleX = -0.0299f;
        this.field_192773_j.rotationPointY = 22.0f;
        this.field_192774_k.rotationPointY = 22.0f;
        if (llllllllllllIIllIllllIlllIIIllll instanceof EntityParrot) {
            final EntityParrot llllllllllllIIllIllllIlllIIlIIlI = (EntityParrot)llllllllllllIIllIllllIlllIIIllll;
            if (llllllllllllIIllIllllIlllIIlIIlI.func_192004_dr()) {
                this.field_192773_j.rotateAngleZ = -0.34906584f;
                this.field_192774_k.rotateAngleZ = 0.34906584f;
                this.field_192775_l = State.PARTY;
                return;
            }
            if (llllllllllllIIllIllllIlllIIlIIlI.isSitting()) {
                final float llllllllllllIIllIllllIlllIIlIIIl = 1.9f;
                this.field_192768_e.rotationPointY = 17.59f;
                this.field_192765_b.rotateAngleX = 1.5388988f;
                this.field_192765_b.rotationPointY = 22.97f;
                this.field_192764_a.rotationPointY = 18.4f;
                this.field_192766_c.rotateAngleZ = -0.0873f;
                this.field_192766_c.rotationPointY = 18.84f;
                this.field_192767_d.rotateAngleZ = 0.0873f;
                this.field_192767_d.rotationPointY = 18.84f;
                final ModelRenderer field_192773_j = this.field_192773_j;
                ++field_192773_j.rotationPointY;
                final ModelRenderer field_192774_k = this.field_192774_k;
                ++field_192774_k.rotationPointY;
                final ModelRenderer field_192773_j2 = this.field_192773_j;
                ++field_192773_j2.rotateAngleX;
                final ModelRenderer field_192774_k2 = this.field_192774_k;
                ++field_192774_k2.rotateAngleX;
                this.field_192775_l = State.SITTING;
            }
            else if (llllllllllllIIllIllllIlllIIlIIlI.func_192002_a()) {
                final ModelRenderer field_192773_j3 = this.field_192773_j;
                field_192773_j3.rotateAngleX += 0.69813174f;
                final ModelRenderer field_192774_k3 = this.field_192774_k;
                field_192774_k3.rotateAngleX += 0.69813174f;
                this.field_192775_l = State.FLYING;
            }
            else {
                this.field_192775_l = State.STANDING;
            }
            this.field_192773_j.rotateAngleZ = 0.0f;
            this.field_192774_k.rotateAngleZ = 0.0f;
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIIllIllllIlllIlIIlII, final float llllllllllllIIllIllllIlllIlIIIll, final float llllllllllllIIllIllllIlllIlIIIlI, final float llllllllllllIIllIllllIlllIlIIIIl, final float llllllllllllIIllIllllIlllIlIlIll, final float llllllllllllIIllIllllIlllIlIlIlI, final Entity llllllllllllIIllIllllIlllIIlllll) {
        final float llllllllllllIIllIllllIlllIlIlIII = llllllllllllIIllIllllIlllIlIIIlI * 0.3f;
        this.field_192768_e.rotateAngleX = llllllllllllIIllIllllIlllIlIlIll * 0.017453292f;
        this.field_192768_e.rotateAngleY = llllllllllllIIllIllllIlllIlIIIIl * 0.017453292f;
        this.field_192768_e.rotateAngleZ = 0.0f;
        this.field_192768_e.rotationPointX = 0.0f;
        this.field_192764_a.rotationPointX = 0.0f;
        this.field_192765_b.rotationPointX = 0.0f;
        this.field_192767_d.rotationPointX = -1.5f;
        this.field_192766_c.rotationPointX = 1.5f;
        if (this.field_192775_l != State.FLYING) {
            if (this.field_192775_l == State.SITTING) {
                return;
            }
            if (this.field_192775_l == State.PARTY) {
                final float llllllllllllIIllIllllIlllIlIIlll = MathHelper.cos((float)llllllllllllIIllIllllIlllIIlllll.ticksExisted);
                final float llllllllllllIIllIllllIlllIlIIllI = MathHelper.sin((float)llllllllllllIIllIllllIlllIIlllll.ticksExisted);
                this.field_192768_e.rotationPointX = llllllllllllIIllIllllIlllIlIIlll;
                this.field_192768_e.rotationPointY = 15.69f + llllllllllllIIllIllllIlllIlIIllI;
                this.field_192768_e.rotateAngleX = 0.0f;
                this.field_192768_e.rotateAngleY = 0.0f;
                this.field_192768_e.rotateAngleZ = MathHelper.sin((float)llllllllllllIIllIllllIlllIIlllll.ticksExisted) * 0.4f;
                this.field_192764_a.rotationPointX = llllllllllllIIllIllllIlllIlIIlll;
                this.field_192764_a.rotationPointY = 16.5f + llllllllllllIIllIllllIlllIlIIllI;
                this.field_192766_c.rotateAngleZ = -0.0873f - llllllllllllIIllIllllIlllIlIIIlI;
                this.field_192766_c.rotationPointX = 1.5f + llllllllllllIIllIllllIlllIlIIlll;
                this.field_192766_c.rotationPointY = 16.94f + llllllllllllIIllIllllIlllIlIIllI;
                this.field_192767_d.rotateAngleZ = 0.0873f + llllllllllllIIllIllllIlllIlIIIlI;
                this.field_192767_d.rotationPointX = -1.5f + llllllllllllIIllIllllIlllIlIIlll;
                this.field_192767_d.rotationPointY = 16.94f + llllllllllllIIllIllllIlllIlIIllI;
                this.field_192765_b.rotationPointX = llllllllllllIIllIllllIlllIlIIlll;
                this.field_192765_b.rotationPointY = 21.07f + llllllllllllIIllIllllIlllIlIIllI;
                return;
            }
            final ModelRenderer field_192773_j = this.field_192773_j;
            field_192773_j.rotateAngleX += MathHelper.cos(llllllllllllIIllIllllIlllIlIIlII * 0.6662f) * 1.4f * llllllllllllIIllIllllIlllIlIIIll;
            final ModelRenderer field_192774_k = this.field_192774_k;
            field_192774_k.rotateAngleX += MathHelper.cos(llllllllllllIIllIllllIlllIlIIlII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllIIllIllllIlllIlIIIll;
        }
        this.field_192768_e.rotationPointY = 15.69f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192765_b.rotateAngleX = 1.015f + MathHelper.cos(llllllllllllIIllIllllIlllIlIIlII * 0.6662f) * 0.3f * llllllllllllIIllIllllIlllIlIIIll;
        this.field_192765_b.rotationPointY = 21.07f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192764_a.rotationPointY = 16.5f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192766_c.rotateAngleZ = -0.0873f - llllllllllllIIllIllllIlllIlIIIlI;
        this.field_192766_c.rotationPointY = 16.94f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192767_d.rotateAngleZ = 0.0873f + llllllllllllIIllIllllIlllIlIIIlI;
        this.field_192767_d.rotationPointY = 16.94f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192773_j.rotationPointY = 22.0f + llllllllllllIIllIllllIlllIlIlIII;
        this.field_192774_k.rotationPointY = 22.0f + llllllllllllIIllIllllIlllIlIlIII;
    }
    
    @Override
    public void render(final Entity llllllllllllIIllIllllIllllIIIIll, final float llllllllllllIIllIllllIllllIIIIlI, final float llllllllllllIIllIllllIllllIIIIIl, final float llllllllllllIIllIllllIllllIIIIII, final float llllllllllllIIllIllllIlllIllllll, final float llllllllllllIIllIllllIlllIlllllI, final float llllllllllllIIllIllllIlllIlllIll) {
        this.field_192764_a.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192766_c.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192767_d.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192765_b.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192768_e.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192773_j.render(llllllllllllIIllIllllIlllIlllIll);
        this.field_192774_k.render(llllllllllllIIllIllllIlllIlllIll);
    }
    
    enum State
    {
        STANDING("STANDING", 1), 
        PARTY("PARTY", 3), 
        SITTING("SITTING", 2), 
        FLYING("FLYING", 0);
        
        private State(final String lllllllllllIlllIlllIIIllIllIllll, final int lllllllllllIlllIlllIIIllIllIlllI) {
        }
    }
}
