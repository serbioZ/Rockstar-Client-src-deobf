// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumHandSide;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.Entity;

public class ModelVex extends ModelBiped
{
    protected /* synthetic */ ModelRenderer field_191230_b;
    protected /* synthetic */ ModelRenderer field_191229_a;
    
    public int func_191228_a() {
        return 23;
    }
    
    @Override
    public void render(final Entity lllllllllllIllIIlIIIIIIlIIlIllIl, final float lllllllllllIllIIlIIIIIIlIIlIllII, final float lllllllllllIllIIlIIIIIIlIIllIIll, final float lllllllllllIllIIlIIIIIIlIIlIlIlI, final float lllllllllllIllIIlIIIIIIlIIllIIIl, final float lllllllllllIllIIlIIIIIIlIIllIIII, final float lllllllllllIllIIlIIIIIIlIIlIllll) {
        super.render(lllllllllllIllIIlIIIIIIlIIlIllIl, lllllllllllIllIIlIIIIIIlIIlIllII, lllllllllllIllIIlIIIIIIlIIllIIll, lllllllllllIllIIlIIIIIIlIIlIlIlI, lllllllllllIllIIlIIIIIIlIIllIIIl, lllllllllllIllIIlIIIIIIlIIllIIII, lllllllllllIllIIlIIIIIIlIIlIllll);
        this.field_191230_b.render(lllllllllllIllIIlIIIIIIlIIlIllll);
        this.field_191229_a.render(lllllllllllIllIIlIIIIIIlIIlIllll);
    }
    
    public ModelVex(final float lllllllllllIllIIlIIIIIIlIlIIIIIl) {
        super(lllllllllllIllIIlIIIIIIlIlIIIIIl, 0.0f, 64, 64);
        this.bipedLeftLeg.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg = new ModelRenderer(this, 32, 0);
        this.bipedRightLeg.addBox(-1.0f, -1.0f, -2.0f, 6, 10, 4, 0.0f);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.field_191230_b = new ModelRenderer(this, 0, 32);
        this.field_191230_b.addBox(-20.0f, 0.0f, 0.0f, 20, 12, 1);
        this.field_191229_a = new ModelRenderer(this, 0, 32);
        this.field_191229_a.mirror = true;
        this.field_191229_a.addBox(0.0f, 0.0f, 0.0f, 20, 12, 1);
    }
    
    public ModelVex() {
        this(0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIllIIlIIIIIIlIIIlIIll, final float lllllllllllIllIIlIIIIIIlIIIlIIlI, final float lllllllllllIllIIlIIIIIIlIIIllIlI, final float lllllllllllIllIIlIIIIIIlIIIllIIl, final float lllllllllllIllIIlIIIIIIlIIIllIII, final float lllllllllllIllIIlIIIIIIlIIIIlllI, final Entity lllllllllllIllIIlIIIIIIlIIIIllIl) {
        super.setRotationAngles(lllllllllllIllIIlIIIIIIlIIIlIIll, lllllllllllIllIIlIIIIIIlIIIlIIlI, lllllllllllIllIIlIIIIIIlIIIllIlI, lllllllllllIllIIlIIIIIIlIIIllIIl, lllllllllllIllIIlIIIIIIlIIIllIII, lllllllllllIllIIlIIIIIIlIIIIlllI, lllllllllllIllIIlIIIIIIlIIIIllIl);
        final EntityVex lllllllllllIllIIlIIIIIIlIIIlIlIl = (EntityVex)lllllllllllIllIIlIIIIIIlIIIIllIl;
        if (lllllllllllIllIIlIIIIIIlIIIlIlIl.func_190647_dj()) {
            if (lllllllllllIllIIlIIIIIIlIIIlIlIl.getPrimaryHand() == EnumHandSide.RIGHT) {
                this.bipedRightArm.rotateAngleX = 3.7699115f;
            }
            else {
                this.bipedLeftArm.rotateAngleX = 3.7699115f;
            }
        }
        final ModelRenderer bipedRightLeg = this.bipedRightLeg;
        bipedRightLeg.rotateAngleX += 0.62831855f;
        this.field_191230_b.rotationPointZ = 2.0f;
        this.field_191229_a.rotationPointZ = 2.0f;
        this.field_191230_b.rotationPointY = 1.0f;
        this.field_191229_a.rotationPointY = 1.0f;
        this.field_191230_b.rotateAngleY = 0.47123894f + MathHelper.cos(lllllllllllIllIIlIIIIIIlIIIllIlI * 0.8f) * 3.1415927f * 0.05f;
        this.field_191229_a.rotateAngleY = -this.field_191230_b.rotateAngleY;
        this.field_191229_a.rotateAngleZ = -0.47123894f;
        this.field_191229_a.rotateAngleX = 0.47123894f;
        this.field_191230_b.rotateAngleX = 0.47123894f;
        this.field_191230_b.rotateAngleZ = 0.47123894f;
    }
}
