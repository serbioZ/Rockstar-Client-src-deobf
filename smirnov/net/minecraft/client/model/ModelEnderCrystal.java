// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelEnderCrystal extends ModelBase
{
    private final /* synthetic */ ModelRenderer cube;
    private /* synthetic */ ModelRenderer base;
    private final /* synthetic */ ModelRenderer glass;
    
    public ModelEnderCrystal(final float llllllllllllllIlllIIIIIIlllIIIll, final boolean llllllllllllllIlllIIIIIIlllIIIlI) {
        this.glass = new ModelRenderer(this, "glass");
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        if (llllllllllllllIlllIIIIIIlllIIIlI) {
            this.base = new ModelRenderer(this, "base");
            this.base.setTextureOffset(0, 16).addBox(-6.0f, 0.0f, -6.0f, 12, 4, 12);
        }
    }
    
    @Override
    public void render(final Entity llllllllllllllIlllIIIIIIllIllIIl, final float llllllllllllllIlllIIIIIIllIllIII, final float llllllllllllllIlllIIIIIIllIlIlll, final float llllllllllllllIlllIIIIIIllIlIllI, final float llllllllllllllIlllIIIIIIllIlIlIl, final float llllllllllllllIlllIIIIIIllIlIlII, final float llllllllllllllIlllIIIIIIllIIlllI) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GlStateManager.translate(0.0f, -0.5f, 0.0f);
        if (this.base != null) {
            this.base.render(llllllllllllllIlllIIIIIIllIIlllI);
        }
        GlStateManager.rotate(llllllllllllllIlllIIIIIIllIlIlll, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.8f + llllllllllllllIlllIIIIIIllIlIllI, 0.0f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.glass.render(llllllllllllllIlllIIIIIIllIIlllI);
        final float llllllllllllllIlllIIIIIIllIlIIlI = 0.875f;
        GlStateManager.scale(0.875f, 0.875f, 0.875f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(llllllllllllllIlllIIIIIIllIlIlll, 0.0f, 1.0f, 0.0f);
        this.glass.render(llllllllllllllIlllIIIIIIllIIlllI);
        GlStateManager.scale(0.875f, 0.875f, 0.875f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(llllllllllllllIlllIIIIIIllIlIlll, 0.0f, 1.0f, 0.0f);
        this.cube.render(llllllllllllllIlllIIIIIIllIIlllI);
        GlStateManager.popMatrix();
    }
}
