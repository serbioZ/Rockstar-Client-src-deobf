// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelShulkerBullet extends ModelBase
{
    public /* synthetic */ ModelRenderer renderer;
    
    public ModelShulkerBullet() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.renderer = new ModelRenderer(this);
        this.renderer.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -1.0f, 8, 8, 2, 0.0f);
        this.renderer.setTextureOffset(0, 10).addBox(-1.0f, -4.0f, -4.0f, 2, 8, 8, 0.0f);
        this.renderer.setTextureOffset(20, 0).addBox(-4.0f, -1.0f, -4.0f, 8, 2, 8, 0.0f);
        this.renderer.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllIIIIlIIIIlIllIIIlllIl, final float lllllllllllIIIIlIIIIlIllIIIlllII, final float lllllllllllIIIIlIIIIlIllIIIllIll, final float lllllllllllIIIIlIIIIlIllIIlIIIlI, final float lllllllllllIIIIlIIIIlIllIIIllIIl, final float lllllllllllIIIIlIIIIlIllIIlIIIII, final float lllllllllllIIIIlIIIIlIllIIIlllll) {
        this.setRotationAngles(lllllllllllIIIIlIIIIlIllIIIlllII, lllllllllllIIIIlIIIIlIllIIIllIll, lllllllllllIIIIlIIIIlIllIIlIIIlI, lllllllllllIIIIlIIIIlIllIIIllIIl, lllllllllllIIIIlIIIIlIllIIlIIIII, lllllllllllIIIIlIIIIlIllIIIlllll, lllllllllllIIIIlIIIIlIllIIIlllIl);
        this.renderer.render(lllllllllllIIIIlIIIIlIllIIIlllll);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIIIlIIIIlIllIIIIllIl, final float lllllllllllIIIIlIIIIlIllIIIIllII, final float lllllllllllIIIIlIIIIlIllIIIIIIll, final float lllllllllllIIIIlIIIIlIllIIIIIIlI, final float lllllllllllIIIIlIIIIlIllIIIIlIIl, final float lllllllllllIIIIlIIIIlIllIIIIIIII, final Entity lllllllllllIIIIlIIIIlIllIIIIIlll) {
        super.setRotationAngles(lllllllllllIIIIlIIIIlIllIIIIllIl, lllllllllllIIIIlIIIIlIllIIIIllII, lllllllllllIIIIlIIIIlIllIIIIIIll, lllllllllllIIIIlIIIIlIllIIIIIIlI, lllllllllllIIIIlIIIIlIllIIIIlIIl, lllllllllllIIIIlIIIIlIllIIIIIIII, lllllllllllIIIIlIIIIlIllIIIIIlll);
        this.renderer.rotateAngleY = lllllllllllIIIIlIIIIlIllIIIIIIlI * 0.017453292f;
        this.renderer.rotateAngleX = lllllllllllIIIIlIIIIlIllIIIIlIIl * 0.017453292f;
    }
}
