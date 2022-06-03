// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelCreeper extends ModelBase
{
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer creeperArmor;
    public /* synthetic */ ModelRenderer leg1;
    public /* synthetic */ ModelRenderer leg3;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer leg2;
    
    public ModelCreeper() {
        this(0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllIIlIlIlIIllIIIIIllllI, final float lllllllllllIIlIlIlIIllIIIIlIIlIl, final float lllllllllllIIlIlIlIIllIIIIlIIlII, final float lllllllllllIIlIlIlIIllIIIIlIIIll, final float lllllllllllIIlIlIlIIllIIIIlIIIlI, final float lllllllllllIIlIlIlIIllIIIIIllIIl, final float lllllllllllIIlIlIlIIllIIIIlIIIII) {
        this.setRotationAngles(lllllllllllIIlIlIlIIllIIIIlIIlIl, lllllllllllIIlIlIlIIllIIIIlIIlII, lllllllllllIIlIlIlIIllIIIIlIIIll, lllllllllllIIlIlIlIIllIIIIlIIIlI, lllllllllllIIlIlIlIIllIIIIIllIIl, lllllllllllIIlIlIlIIllIIIIlIIIII, lllllllllllIIlIlIlIIllIIIIIllllI);
        this.head.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
        this.body.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
        this.leg1.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
        this.leg2.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
        this.leg3.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
        this.leg4.render(lllllllllllIIlIlIlIIllIIIIlIIIII);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIlIlIlIIllIIIIIIlIIl, final float lllllllllllIIlIlIlIIllIIIIIlIIII, final float lllllllllllIIlIlIlIIllIIIIIIllll, final float lllllllllllIIlIlIlIIllIIIIIIIlll, final float lllllllllllIIlIlIlIIllIIIIIIllIl, final float lllllllllllIIlIlIlIIllIIIIIIllII, final Entity lllllllllllIIlIlIlIIllIIIIIIlIll) {
        this.head.rotateAngleY = lllllllllllIIlIlIlIIllIIIIIIIlll * 0.017453292f;
        this.head.rotateAngleX = lllllllllllIIlIlIlIIllIIIIIIllIl * 0.017453292f;
        this.leg1.rotateAngleX = MathHelper.cos(lllllllllllIIlIlIlIIllIIIIIIlIIl * 0.6662f) * 1.4f * lllllllllllIIlIlIlIIllIIIIIlIIII;
        this.leg2.rotateAngleX = MathHelper.cos(lllllllllllIIlIlIlIIllIIIIIIlIIl * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIIlIlIlIIllIIIIIlIIII;
        this.leg3.rotateAngleX = MathHelper.cos(lllllllllllIIlIlIlIIllIIIIIIlIIl * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIIlIlIlIIllIIIIIlIIII;
        this.leg4.rotateAngleX = MathHelper.cos(lllllllllllIIlIlIlIIllIIIIIIlIIl * 0.6662f) * 1.4f * lllllllllllIIlIlIlIIllIIIIIlIIII;
    }
    
    public ModelCreeper(final float lllllllllllIIlIlIlIIllIIIIllIIIl) {
        final int lllllllllllIIlIlIlIIllIIIIllIIll = 6;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.head.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.creeperArmor = new ModelRenderer(this, 32, 0);
        this.creeperArmor.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, lllllllllllIIlIlIlIIllIIIIllIIIl + 0.5f);
        this.creeperArmor.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.body.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.leg1.setRotationPoint(-2.0f, 18.0f, 4.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.leg2.setRotationPoint(2.0f, 18.0f, 4.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.leg3.setRotationPoint(-2.0f, 18.0f, -4.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, lllllllllllIIlIlIlIIllIIIIllIIIl);
        this.leg4.setRotationPoint(2.0f, 18.0f, -4.0f);
    }
}
