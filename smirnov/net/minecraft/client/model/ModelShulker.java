// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.Entity;

public class ModelShulker extends ModelBase
{
    public final /* synthetic */ ModelRenderer base;
    public final /* synthetic */ ModelRenderer lid;
    public /* synthetic */ ModelRenderer head;
    
    public ModelShulker() {
        this.textureHeight = 64;
        this.textureWidth = 64;
        this.lid = new ModelRenderer(this);
        this.base = new ModelRenderer(this);
        this.head = new ModelRenderer(this);
        this.lid.setTextureOffset(0, 0).addBox(-8.0f, -16.0f, -8.0f, 16, 12, 16);
        this.lid.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.base.setTextureOffset(0, 28).addBox(-8.0f, -8.0f, -8.0f, 16, 8, 16);
        this.base.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.head.setTextureOffset(0, 52).addBox(-3.0f, 0.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, 12.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIIIIIIIlIlIllIIIllll, final float lllllllllllIIIIIIIIlIlIllIIIlllI, final float lllllllllllIIIIIIIIlIlIllIIIllIl, final float lllllllllllIIIIIIIIlIlIllIIIllII, final float lllllllllllIIIIIIIIlIlIllIIIlIll, final float lllllllllllIIIIIIIIlIlIllIIIlIlI, final Entity lllllllllllIIIIIIIIlIlIlIlllllll) {
        final EntityShulker lllllllllllIIIIIIIIlIlIllIIIlIII = (EntityShulker)lllllllllllIIIIIIIIlIlIlIlllllll;
        final float lllllllllllIIIIIIIIlIlIllIIIIlll = lllllllllllIIIIIIIIlIlIllIIIllIl - lllllllllllIIIIIIIIlIlIllIIIlIII.ticksExisted;
        final float lllllllllllIIIIIIIIlIlIllIIIIllI = (0.5f + lllllllllllIIIIIIIIlIlIllIIIlIII.getClientPeekAmount(lllllllllllIIIIIIIIlIlIllIIIIlll)) * 3.1415927f;
        final float lllllllllllIIIIIIIIlIlIllIIIIlIl = -1.0f + MathHelper.sin(lllllllllllIIIIIIIIlIlIllIIIIllI);
        float lllllllllllIIIIIIIIlIlIllIIIIlII = 0.0f;
        if (lllllllllllIIIIIIIIlIlIllIIIIllI > 3.1415927f) {
            lllllllllllIIIIIIIIlIlIllIIIIlII = MathHelper.sin(lllllllllllIIIIIIIIlIlIllIIIllIl * 0.1f) * 0.7f;
        }
        this.lid.setRotationPoint(0.0f, 16.0f + MathHelper.sin(lllllllllllIIIIIIIIlIlIllIIIIllI) * 8.0f + lllllllllllIIIIIIIIlIlIllIIIIlII, 0.0f);
        if (lllllllllllIIIIIIIIlIlIllIIIlIII.getClientPeekAmount(lllllllllllIIIIIIIIlIlIllIIIIlll) > 0.3f) {
            this.lid.rotateAngleY = lllllllllllIIIIIIIIlIlIllIIIIlIl * lllllllllllIIIIIIIIlIlIllIIIIlIl * lllllllllllIIIIIIIIlIlIllIIIIlIl * lllllllllllIIIIIIIIlIlIllIIIIlIl * 3.1415927f * 0.125f;
        }
        else {
            this.lid.rotateAngleY = 0.0f;
        }
        this.head.rotateAngleX = lllllllllllIIIIIIIIlIlIllIIIlIll * 0.017453292f;
        this.head.rotateAngleY = lllllllllllIIIIIIIIlIlIllIIIllII * 0.017453292f;
    }
    
    @Override
    public void render(final Entity lllllllllllIIIIIIIIlIlIlIlllIllI, final float lllllllllllIIIIIIIIlIlIlIlllIlIl, final float lllllllllllIIIIIIIIlIlIlIlllIlII, final float lllllllllllIIIIIIIIlIlIlIlllIIll, final float lllllllllllIIIIIIIIlIlIlIlllIIlI, final float lllllllllllIIIIIIIIlIlIlIlllIIIl, final float lllllllllllIIIIIIIIlIlIlIlllIIII) {
        this.base.render(lllllllllllIIIIIIIIlIlIlIlllIIII);
        this.lid.render(lllllllllllIIIIIIIIlIlIlIlllIIII);
    }
}
