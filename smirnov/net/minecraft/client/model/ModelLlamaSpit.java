// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelLlamaSpit extends ModelBase
{
    private final /* synthetic */ ModelRenderer field_191225_a;
    
    public ModelLlamaSpit(final float lllllllllllIIIllIlIIlIIIlIlIlIlI) {
        this.field_191225_a = new ModelRenderer(this);
        final int lllllllllllIIIllIlIIlIIIlIlIllII = 2;
        this.field_191225_a.setTextureOffset(0, 0).addBox(-4.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, -4.0f, 0.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, -4.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(2.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 2.0f, 0.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, 2.0f, 2, 2, 2, lllllllllllIIIllIlIIlIIIlIlIlIlI);
        this.field_191225_a.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    public ModelLlamaSpit() {
        this(0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllIIIllIlIIlIIIlIIlIlll, final float lllllllllllIIIllIlIIlIIIlIIlIllI, final float lllllllllllIIIllIlIIlIIIlIIlIlIl, final float lllllllllllIIIllIlIIlIIIlIIlllII, final float lllllllllllIIIllIlIIlIIIlIIllIll, final float lllllllllllIIIllIlIIlIIIlIIllIlI, final float lllllllllllIIIllIlIIlIIIlIIlIIIl) {
        this.setRotationAngles(lllllllllllIIIllIlIIlIIIlIIlIllI, lllllllllllIIIllIlIIlIIIlIIlIlIl, lllllllllllIIIllIlIIlIIIlIIlllII, lllllllllllIIIllIlIIlIIIlIIllIll, lllllllllllIIIllIlIIlIIIlIIllIlI, lllllllllllIIIllIlIIlIIIlIIlIIIl, lllllllllllIIIllIlIIlIIIlIIlIlll);
        this.field_191225_a.render(lllllllllllIIIllIlIIlIIIlIIlIIIl);
    }
}
