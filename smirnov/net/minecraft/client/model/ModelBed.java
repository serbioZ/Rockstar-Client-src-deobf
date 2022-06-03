// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

public class ModelBed extends ModelBase
{
    public /* synthetic */ ModelRenderer[] field_193774_c;
    public /* synthetic */ ModelRenderer field_193773_b;
    public /* synthetic */ ModelRenderer field_193772_a;
    
    public int func_193770_a() {
        return 51;
    }
    
    public ModelBed() {
        this.field_193774_c = new ModelRenderer[4];
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_193772_a = new ModelRenderer(this, 0, 0);
        this.field_193772_a.addBox(0.0f, 0.0f, 0.0f, 16, 16, 6, 0.0f);
        this.field_193773_b = new ModelRenderer(this, 0, 22);
        this.field_193773_b.addBox(0.0f, 0.0f, 0.0f, 16, 16, 6, 0.0f);
        this.field_193774_c[0] = new ModelRenderer(this, 50, 0);
        this.field_193774_c[1] = new ModelRenderer(this, 50, 6);
        this.field_193774_c[2] = new ModelRenderer(this, 50, 12);
        this.field_193774_c[3] = new ModelRenderer(this, 50, 18);
        this.field_193774_c[0].addBox(0.0f, 6.0f, -16.0f, 3, 3, 3);
        this.field_193774_c[1].addBox(0.0f, 6.0f, 0.0f, 3, 3, 3);
        this.field_193774_c[2].addBox(-16.0f, 6.0f, -16.0f, 3, 3, 3);
        this.field_193774_c[3].addBox(-16.0f, 6.0f, 0.0f, 3, 3, 3);
        this.field_193774_c[0].rotateAngleX = 1.5707964f;
        this.field_193774_c[1].rotateAngleX = 1.5707964f;
        this.field_193774_c[2].rotateAngleX = 1.5707964f;
        this.field_193774_c[3].rotateAngleX = 1.5707964f;
        this.field_193774_c[0].rotateAngleZ = 0.0f;
        this.field_193774_c[1].rotateAngleZ = 1.5707964f;
        this.field_193774_c[2].rotateAngleZ = 4.712389f;
        this.field_193774_c[3].rotateAngleZ = 3.1415927f;
    }
    
    public void func_193769_a(final boolean lllllllllllllIlllllIllIlIIIIIlIl) {
        this.field_193772_a.showModel = lllllllllllllIlllllIllIlIIIIIlIl;
        this.field_193773_b.showModel = !lllllllllllllIlllllIllIlIIIIIlIl;
        this.field_193774_c[0].showModel = !lllllllllllllIlllllIllIlIIIIIlIl;
        this.field_193774_c[1].showModel = lllllllllllllIlllllIllIlIIIIIlIl;
        this.field_193774_c[2].showModel = !lllllllllllllIlllllIllIlIIIIIlIl;
        this.field_193774_c[3].showModel = lllllllllllllIlllllIllIlIIIIIlIl;
    }
    
    public void func_193771_b() {
        this.field_193772_a.render(0.0625f);
        this.field_193773_b.render(0.0625f);
        this.field_193774_c[0].render(0.0625f);
        this.field_193774_c[1].render(0.0625f);
        this.field_193774_c[2].render(0.0625f);
        this.field_193774_c[3].render(0.0625f);
    }
}
