// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelEvokerFangs extends ModelBase
{
    private final /* synthetic */ ModelRenderer field_191215_c;
    private final /* synthetic */ ModelRenderer field_191214_b;
    private final /* synthetic */ ModelRenderer field_191213_a;
    
    public ModelEvokerFangs() {
        this.field_191213_a = new ModelRenderer(this, 0, 0);
        this.field_191213_a.setRotationPoint(-5.0f, 22.0f, -5.0f);
        this.field_191213_a.addBox(0.0f, 0.0f, 0.0f, 10, 12, 10);
        this.field_191214_b = new ModelRenderer(this, 40, 0);
        this.field_191214_b.setRotationPoint(1.5f, 22.0f, -4.0f);
        this.field_191214_b.addBox(0.0f, 0.0f, 0.0f, 4, 14, 8);
        this.field_191215_c = new ModelRenderer(this, 40, 0);
        this.field_191215_c.setRotationPoint(-1.5f, 22.0f, 4.0f);
        this.field_191215_c.addBox(0.0f, 0.0f, 0.0f, 4, 14, 8);
    }
    
    @Override
    public void render(final Entity lllllllllllllllllIlIIlIIlIlIIIlI, final float lllllllllllllllllIlIIlIIlIIllIII, final float lllllllllllllllllIlIIlIIlIlIIIII, final float lllllllllllllllllIlIIlIIlIIlllll, final float lllllllllllllllllIlIIlIIlIIllllI, final float lllllllllllllllllIlIIlIIlIIlllIl, final float lllllllllllllllllIlIIlIIlIIlIlll) {
        float lllllllllllllllllIlIIlIIlIIllIll = lllllllllllllllllIlIIlIIlIIllIII * 2.0f;
        if (lllllllllllllllllIlIIlIIlIIllIll > 1.0f) {
            lllllllllllllllllIlIIlIIlIIllIll = 1.0f;
        }
        lllllllllllllllllIlIIlIIlIIllIll = 1.0f - lllllllllllllllllIlIIlIIlIIllIll * lllllllllllllllllIlIIlIIlIIllIll * lllllllllllllllllIlIIlIIlIIllIll;
        this.field_191214_b.rotateAngleZ = 3.1415927f - lllllllllllllllllIlIIlIIlIIllIll * 0.35f * 3.1415927f;
        this.field_191215_c.rotateAngleZ = 3.1415927f + lllllllllllllllllIlIIlIIlIIllIll * 0.35f * 3.1415927f;
        this.field_191215_c.rotateAngleY = 3.1415927f;
        final float lllllllllllllllllIlIIlIIlIIllIlI = (lllllllllllllllllIlIIlIIlIIllIII + MathHelper.sin(lllllllllllllllllIlIIlIIlIIllIII * 2.7f)) * 0.6f * 12.0f;
        this.field_191214_b.rotationPointY = 24.0f - lllllllllllllllllIlIIlIIlIIllIlI;
        this.field_191215_c.rotationPointY = this.field_191214_b.rotationPointY;
        this.field_191213_a.rotationPointY = this.field_191214_b.rotationPointY;
        this.field_191213_a.render(lllllllllllllllllIlIIlIIlIIlIlll);
        this.field_191214_b.render(lllllllllllllllllIlIIlIIlIIlIlll);
        this.field_191215_c.render(lllllllllllllllllIlIIlIIlIIlIlll);
    }
}
