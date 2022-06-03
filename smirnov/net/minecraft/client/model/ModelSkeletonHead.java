// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelSkeletonHead extends ModelBase
{
    public /* synthetic */ ModelRenderer skeletonHead;
    
    public ModelSkeletonHead() {
        this(0, 35, 64, 64);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIIllIIIlIllIIIl, final float lllllllllllllIlIIIIllIIIlIlllIII, final float lllllllllllllIlIIIIllIIIlIlIllll, final float lllllllllllllIlIIIIllIIIlIlIlllI, final float lllllllllllllIlIIIIllIIIlIllIlIl, final float lllllllllllllIlIIIIllIIIlIllIlII, final Entity lllllllllllllIlIIIIllIIIlIllIIll) {
        super.setRotationAngles(lllllllllllllIlIIIIllIIIlIllIIIl, lllllllllllllIlIIIIllIIIlIlllIII, lllllllllllllIlIIIIllIIIlIlIllll, lllllllllllllIlIIIIllIIIlIlIlllI, lllllllllllllIlIIIIllIIIlIllIlIl, lllllllllllllIlIIIIllIIIlIllIlII, lllllllllllllIlIIIIllIIIlIllIIll);
        this.skeletonHead.rotateAngleY = lllllllllllllIlIIIIllIIIlIlIlllI * 0.017453292f;
        this.skeletonHead.rotateAngleX = lllllllllllllIlIIIIllIIIlIllIlIl * 0.017453292f;
    }
    
    public ModelSkeletonHead(final int lllllllllllllIlIIIIllIIIllIllllI, final int lllllllllllllIlIIIIllIIIlllIIIlI, final int lllllllllllllIlIIIIllIIIllIlllII, final int lllllllllllllIlIIIIllIIIlllIIIII) {
        this.textureWidth = lllllllllllllIlIIIIllIIIllIlllII;
        this.textureHeight = lllllllllllllIlIIIIllIIIlllIIIII;
        this.skeletonHead = new ModelRenderer(this, lllllllllllllIlIIIIllIIIllIllllI, lllllllllllllIlIIIIllIIIlllIIIlI);
        this.skeletonHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.skeletonHead.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIIIllIIIllIlIIIl, final float lllllllllllllIlIIIIllIIIllIlIIII, final float lllllllllllllIlIIIIllIIIllIIIlll, final float lllllllllllllIlIIIIllIIIllIIIllI, final float lllllllllllllIlIIIIllIIIllIIllIl, final float lllllllllllllIlIIIIllIIIllIIllII, final float lllllllllllllIlIIIIllIIIllIIlIll) {
        this.setRotationAngles(lllllllllllllIlIIIIllIIIllIlIIII, lllllllllllllIlIIIIllIIIllIIIlll, lllllllllllllIlIIIIllIIIllIIIllI, lllllllllllllIlIIIIllIIIllIIllIl, lllllllllllllIlIIIIllIIIllIIllII, lllllllllllllIlIIIIllIIIllIIlIll, lllllllllllllIlIIIIllIIIllIlIIIl);
        this.skeletonHead.render(lllllllllllllIlIIIIllIIIllIIlIll);
    }
}
