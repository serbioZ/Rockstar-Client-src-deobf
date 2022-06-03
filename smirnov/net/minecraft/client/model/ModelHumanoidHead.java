// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelHumanoidHead extends ModelSkeletonHead
{
    private final /* synthetic */ ModelRenderer head;
    
    @Override
    public void setRotationAngles(final float lllllllllllIIllIIlIIIIlllIlIIIlI, final float lllllllllllIIllIIlIIIIlllIlIIIIl, final float lllllllllllIIllIIlIIIIlllIlIlIII, final float lllllllllllIIllIIlIIIIlllIlIIlll, final float lllllllllllIIllIIlIIIIlllIlIIllI, final float lllllllllllIIllIIlIIIIlllIlIIlIl, final Entity lllllllllllIIllIIlIIIIlllIlIIlII) {
        super.setRotationAngles(lllllllllllIIllIIlIIIIlllIlIIIlI, lllllllllllIIllIIlIIIIlllIlIIIIl, lllllllllllIIllIIlIIIIlllIlIlIII, lllllllllllIIllIIlIIIIlllIlIIlll, lllllllllllIIllIIlIIIIlllIlIIllI, lllllllllllIIllIIlIIIIlllIlIIlIl, lllllllllllIIllIIlIIIIlllIlIIlII);
        this.head.rotateAngleY = this.skeletonHead.rotateAngleY;
        this.head.rotateAngleX = this.skeletonHead.rotateAngleX;
    }
    
    @Override
    public void render(final Entity lllllllllllIIllIIlIIIIlllIlllIlI, final float lllllllllllIIllIIlIIIIllllIIIIIl, final float lllllllllllIIllIIlIIIIlllIlllIII, final float lllllllllllIIllIIlIIIIlllIllllll, final float lllllllllllIIllIIlIIIIlllIllIllI, final float lllllllllllIIllIIlIIIIlllIllllIl, final float lllllllllllIIllIIlIIIIlllIllllII) {
        super.render(lllllllllllIIllIIlIIIIlllIlllIlI, lllllllllllIIllIIlIIIIllllIIIIIl, lllllllllllIIllIIlIIIIlllIlllIII, lllllllllllIIllIIlIIIIlllIllllll, lllllllllllIIllIIlIIIIlllIllIllI, lllllllllllIIllIIlIIIIlllIllllIl, lllllllllllIIllIIlIIIIlllIllllII);
        this.head.render(lllllllllllIIllIIlIIIIlllIllllII);
    }
    
    public ModelHumanoidHead() {
        super(0, 0, 64, 64);
        this.head = new ModelRenderer(this, 32, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.25f);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
}
