// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelBook extends ModelBase
{
    public /* synthetic */ ModelRenderer coverLeft;
    public /* synthetic */ ModelRenderer coverRight;
    public /* synthetic */ ModelRenderer bookSpine;
    public /* synthetic */ ModelRenderer flippingPageLeft;
    public /* synthetic */ ModelRenderer pagesLeft;
    public /* synthetic */ ModelRenderer flippingPageRight;
    public /* synthetic */ ModelRenderer pagesRight;
    
    @Override
    public void render(final Entity llllllllllllIIIllIIlllllIlllIllI, final float llllllllllllIIIllIIlllllIlllllIl, final float llllllllllllIIIllIIlllllIlllIlII, final float llllllllllllIIIllIIlllllIllllIll, final float llllllllllllIIIllIIlllllIllllIlI, final float llllllllllllIIIllIIlllllIlllIIIl, final float llllllllllllIIIllIIlllllIllllIII) {
        this.setRotationAngles(llllllllllllIIIllIIlllllIlllllIl, llllllllllllIIIllIIlllllIlllIlII, llllllllllllIIIllIIlllllIllllIll, llllllllllllIIIllIIlllllIllllIlI, llllllllllllIIIllIIlllllIlllIIIl, llllllllllllIIIllIIlllllIllllIII, llllllllllllIIIllIIlllllIlllIllI);
        this.coverRight.render(llllllllllllIIIllIIlllllIllllIII);
        this.coverLeft.render(llllllllllllIIIllIIlllllIllllIII);
        this.bookSpine.render(llllllllllllIIIllIIlllllIllllIII);
        this.pagesRight.render(llllllllllllIIIllIIlllllIllllIII);
        this.pagesLeft.render(llllllllllllIIIllIIlllllIllllIII);
        this.flippingPageRight.render(llllllllllllIIIllIIlllllIllllIII);
        this.flippingPageLeft.render(llllllllllllIIIllIIlllllIllllIII);
    }
    
    public ModelBook() {
        this.coverRight = new ModelRenderer(this).setTextureOffset(0, 0).addBox(-6.0f, -5.0f, 0.0f, 6, 10, 0);
        this.coverLeft = new ModelRenderer(this).setTextureOffset(16, 0).addBox(0.0f, -5.0f, 0.0f, 6, 10, 0);
        this.pagesRight = new ModelRenderer(this).setTextureOffset(0, 10).addBox(0.0f, -4.0f, -0.99f, 5, 8, 1);
        this.pagesLeft = new ModelRenderer(this).setTextureOffset(12, 10).addBox(0.0f, -4.0f, -0.01f, 5, 8, 1);
        this.flippingPageRight = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.flippingPageLeft = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.bookSpine = new ModelRenderer(this).setTextureOffset(12, 0).addBox(-1.0f, -5.0f, 0.0f, 2, 10, 0);
        this.coverRight.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.coverLeft.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.bookSpine.rotateAngleY = 1.5707964f;
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIIIllIIlllllIllIlIII, final float llllllllllllIIIllIIlllllIllIIlll, final float llllllllllllIIIllIIlllllIllIIllI, final float llllllllllllIIIllIIlllllIllIIlIl, final float llllllllllllIIIllIIlllllIllIIlII, final float llllllllllllIIIllIIlllllIllIIIll, final Entity llllllllllllIIIllIIlllllIllIIIlI) {
        final float llllllllllllIIIllIIlllllIllIIIIl = (MathHelper.sin(llllllllllllIIIllIIlllllIllIlIII * 0.02f) * 0.1f + 1.25f) * llllllllllllIIIllIIlllllIllIIlIl;
        this.coverRight.rotateAngleY = 3.1415927f + llllllllllllIIIllIIlllllIllIIIIl;
        this.coverLeft.rotateAngleY = -llllllllllllIIIllIIlllllIllIIIIl;
        this.pagesRight.rotateAngleY = llllllllllllIIIllIIlllllIllIIIIl;
        this.pagesLeft.rotateAngleY = -llllllllllllIIIllIIlllllIllIIIIl;
        this.flippingPageRight.rotateAngleY = llllllllllllIIIllIIlllllIllIIIIl - llllllllllllIIIllIIlllllIllIIIIl * 2.0f * llllllllllllIIIllIIlllllIllIIlll;
        this.flippingPageLeft.rotateAngleY = llllllllllllIIIllIIlllllIllIIIIl - llllllllllllIIIllIIlllllIllIIIIl * 2.0f * llllllllllllIIIllIIlllllIllIIllI;
        this.pagesRight.rotationPointX = MathHelper.sin(llllllllllllIIIllIIlllllIllIIIIl);
        this.pagesLeft.rotationPointX = MathHelper.sin(llllllllllllIIIllIIlllllIllIIIIl);
        this.flippingPageRight.rotationPointX = MathHelper.sin(llllllllllllIIIllIIlllllIllIIIIl);
        this.flippingPageLeft.rotationPointX = MathHelper.sin(llllllllllllIIIllIIlllllIllIIIIl);
    }
}
