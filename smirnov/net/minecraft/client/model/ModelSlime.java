// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelSlime extends ModelBase
{
    /* synthetic */ ModelRenderer slimeLeftEye;
    /* synthetic */ ModelRenderer slimeMouth;
    /* synthetic */ ModelRenderer slimeBodies;
    /* synthetic */ ModelRenderer slimeRightEye;
    
    public ModelSlime(final int lllIIllllIlI) {
        if (lllIIllllIlI > 0) {
            this.slimeBodies = new ModelRenderer(this, 0, lllIIllllIlI);
            this.slimeBodies.addBox(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.addBox(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.addBox(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.addBox(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
        else {
            this.slimeBodies = new ModelRenderer(this, 0, lllIIllllIlI);
            this.slimeBodies.addBox(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        }
    }
    
    @Override
    public void render(final Entity lllIIlllIIII, final float lllIIllIllll, final float lllIIllIlllI, final float lllIIllIllIl, final float lllIIllIllII, final float lllIIllIlIll, final float lllIIllIlIlI) {
        this.setRotationAngles(lllIIllIllll, lllIIllIlllI, lllIIllIllIl, lllIIllIllII, lllIIllIlIll, lllIIllIlIlI, lllIIlllIIII);
        GlStateManager.translate(0.0f, 0.001f, 0.0f);
        this.slimeBodies.render(lllIIllIlIlI);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.render(lllIIllIlIlI);
            this.slimeLeftEye.render(lllIIllIlIlI);
            this.slimeMouth.render(lllIIllIlIlI);
        }
    }
}
