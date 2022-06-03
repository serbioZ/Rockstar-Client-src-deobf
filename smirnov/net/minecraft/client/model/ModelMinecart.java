// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelMinecart extends ModelBase
{
    public /* synthetic */ ModelRenderer[] sideModels;
    
    @Override
    public void render(final Entity lllllllllllIIIIIlIllIIllIIIllIIl, final float lllllllllllIIIIIlIllIIllIIIllIII, final float lllllllllllIIIIIlIllIIllIIIlIlll, final float lllllllllllIIIIIlIllIIllIIIlIIII, final float lllllllllllIIIIIlIllIIllIIIlIlIl, final float lllllllllllIIIIIlIllIIllIIIlIlII, final float lllllllllllIIIIIlIllIIllIIIlIIll) {
        this.sideModels[5].rotationPointY = 4.0f - lllllllllllIIIIIlIllIIllIIIlIIII;
        for (int lllllllllllIIIIIlIllIIllIIIlIIlI = 0; lllllllllllIIIIIlIllIIllIIIlIIlI < 6; ++lllllllllllIIIIIlIllIIllIIIlIIlI) {
            this.sideModels[lllllllllllIIIIIlIllIIllIIIlIIlI].render(lllllllllllIIIIIlIllIIllIIIlIIll);
        }
    }
    
    public ModelMinecart() {
        this.sideModels = new ModelRenderer[7];
        this.sideModels[0] = new ModelRenderer(this, 0, 10);
        this.sideModels[1] = new ModelRenderer(this, 0, 0);
        this.sideModels[2] = new ModelRenderer(this, 0, 0);
        this.sideModels[3] = new ModelRenderer(this, 0, 0);
        this.sideModels[4] = new ModelRenderer(this, 0, 0);
        this.sideModels[5] = new ModelRenderer(this, 44, 10);
        final int lllllllllllIIIIIlIllIIllIIlIIlll = 20;
        final int lllllllllllIIIIIlIllIIllIIlIIllI = 8;
        final int lllllllllllIIIIIlIllIIllIIlIIlIl = 16;
        final int lllllllllllIIIIIlIllIIllIIlIIlII = 4;
        this.sideModels[0].addBox(-10.0f, -8.0f, -1.0f, 20, 16, 2, 0.0f);
        this.sideModels[0].setRotationPoint(0.0f, 4.0f, 0.0f);
        this.sideModels[5].addBox(-9.0f, -7.0f, -1.0f, 18, 14, 1, 0.0f);
        this.sideModels[5].setRotationPoint(0.0f, 4.0f, 0.0f);
        this.sideModels[1].addBox(-8.0f, -9.0f, -1.0f, 16, 8, 2, 0.0f);
        this.sideModels[1].setRotationPoint(-9.0f, 4.0f, 0.0f);
        this.sideModels[2].addBox(-8.0f, -9.0f, -1.0f, 16, 8, 2, 0.0f);
        this.sideModels[2].setRotationPoint(9.0f, 4.0f, 0.0f);
        this.sideModels[3].addBox(-8.0f, -9.0f, -1.0f, 16, 8, 2, 0.0f);
        this.sideModels[3].setRotationPoint(0.0f, 4.0f, -7.0f);
        this.sideModels[4].addBox(-8.0f, -9.0f, -1.0f, 16, 8, 2, 0.0f);
        this.sideModels[4].setRotationPoint(0.0f, 4.0f, 7.0f);
        this.sideModels[0].rotateAngleX = 1.5707964f;
        this.sideModels[1].rotateAngleY = 4.712389f;
        this.sideModels[2].rotateAngleY = 1.5707964f;
        this.sideModels[3].rotateAngleY = 3.1415927f;
        this.sideModels[5].rotateAngleX = -1.5707964f;
    }
}
