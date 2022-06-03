// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelLeashKnot extends ModelBase
{
    public /* synthetic */ ModelRenderer knotRenderer;
    
    public ModelLeashKnot(final int lllllllllllIlIllllIlIIlllllllIll, final int lllllllllllIlIllllIlIIllllllllll, final int lllllllllllIlIllllIlIIlllllllIIl, final int lllllllllllIlIllllIlIIlllllllIII) {
        this.textureWidth = lllllllllllIlIllllIlIIlllllllIIl;
        this.textureHeight = lllllllllllIlIllllIlIIlllllllIII;
        this.knotRenderer = new ModelRenderer(this, lllllllllllIlIllllIlIIlllllllIll, lllllllllllIlIllllIlIIllllllllll);
        this.knotRenderer.addBox(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.knotRenderer.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIlIllllIlIIllllIIlllI, final float lllllllllllIlIllllIlIIllllIlIlIl, final float lllllllllllIlIllllIlIIllllIIllII, final float lllllllllllIlIllllIlIIllllIIlIll, final float lllllllllllIlIllllIlIIllllIIlIlI, final float lllllllllllIlIllllIlIIllllIlIIIl, final Entity lllllllllllIlIllllIlIIllllIlIIII) {
        super.setRotationAngles(lllllllllllIlIllllIlIIllllIIlllI, lllllllllllIlIllllIlIIllllIlIlIl, lllllllllllIlIllllIlIIllllIIllII, lllllllllllIlIllllIlIIllllIIlIll, lllllllllllIlIllllIlIIllllIIlIlI, lllllllllllIlIllllIlIIllllIlIIIl, lllllllllllIlIllllIlIIllllIlIIII);
        this.knotRenderer.rotateAngleY = lllllllllllIlIllllIlIIllllIIlIll * 0.017453292f;
        this.knotRenderer.rotateAngleX = lllllllllllIlIllllIlIIllllIIlIlI * 0.017453292f;
    }
    
    @Override
    public void render(final Entity lllllllllllIlIllllIlIIlllllIlllI, final float lllllllllllIlIllllIlIIlllllIIlIl, final float lllllllllllIlIllllIlIIlllllIIlII, final float lllllllllllIlIllllIlIIlllllIIIll, final float lllllllllllIlIllllIlIIlllllIlIlI, final float lllllllllllIlIllllIlIIlllllIIIIl, final float lllllllllllIlIllllIlIIlllllIlIII) {
        this.setRotationAngles(lllllllllllIlIllllIlIIlllllIIlIl, lllllllllllIlIllllIlIIlllllIIlII, lllllllllllIlIllllIlIIlllllIIIll, lllllllllllIlIllllIlIIlllllIlIlI, lllllllllllIlIllllIlIIlllllIIIIl, lllllllllllIlIllllIlIIlllllIlIII, lllllllllllIlIllllIlIIlllllIlllI);
        this.knotRenderer.render(lllllllllllIlIllllIlIIlllllIlIII);
    }
    
    public ModelLeashKnot() {
        this(0, 0, 32, 32);
    }
}
