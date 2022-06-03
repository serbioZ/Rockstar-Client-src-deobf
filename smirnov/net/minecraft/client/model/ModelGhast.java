// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import java.util.Random;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelGhast extends ModelBase
{
    /* synthetic */ ModelRenderer body;
    /* synthetic */ ModelRenderer[] tentacles;
    
    @Override
    public void render(final Entity lllllllllllIIIlIllIIIIIlllllIIll, final float lllllllllllIIIlIllIIIIIlllllIIlI, final float lllllllllllIIIlIllIIIIIllllllIlI, final float lllllllllllIIIlIllIIIIIllllllIIl, final float lllllllllllIIIlIllIIIIIllllllIII, final float lllllllllllIIIlIllIIIIIlllllIlll, final float lllllllllllIIIlIllIIIIIlllllIllI) {
        this.setRotationAngles(lllllllllllIIIlIllIIIIIlllllIIlI, lllllllllllIIIlIllIIIIIllllllIlI, lllllllllllIIIlIllIIIIIllllllIIl, lllllllllllIIIlIllIIIIIllllllIII, lllllllllllIIIlIllIIIIIlllllIlll, lllllllllllIIIlIllIIIIIlllllIllI, lllllllllllIIIlIllIIIIIlllllIIll);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.6f, 0.0f);
        this.body.render(lllllllllllIIIlIllIIIIIlllllIllI);
        final short lllllllllllIIIlIllIIIIIllllIlIIl;
        final char lllllllllllIIIlIllIIIIIllllIlIlI = (char)((ModelRenderer[])(Object)(lllllllllllIIIlIllIIIIIllllIlIIl = (short)(Object)this.tentacles)).length;
        for (double lllllllllllIIIlIllIIIIIllllIlIll = 0; lllllllllllIIIlIllIIIIIllllIlIll < lllllllllllIIIlIllIIIIIllllIlIlI; ++lllllllllllIIIlIllIIIIIllllIlIll) {
            final ModelRenderer lllllllllllIIIlIllIIIIIlllllIlIl = lllllllllllIIIlIllIIIIIllllIlIIl[lllllllllllIIIlIllIIIIIllllIlIll];
            lllllllllllIIIlIllIIIIIlllllIlIl.render(lllllllllllIIIlIllIIIIIlllllIllI);
        }
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIIlIllIIIIlIIIIlIlII, final float lllllllllllIIIlIllIIIIlIIIIlIIll, final float lllllllllllIIIlIllIIIIlIIIIlIIlI, final float lllllllllllIIIlIllIIIIlIIIIlIIIl, final float lllllllllllIIIlIllIIIIlIIIIlIIII, final float lllllllllllIIIlIllIIIIlIIIIIllll, final Entity lllllllllllIIIlIllIIIIlIIIIIlllI) {
        for (int lllllllllllIIIlIllIIIIlIIIIIllIl = 0; lllllllllllIIIlIllIIIIlIIIIIllIl < this.tentacles.length; ++lllllllllllIIIlIllIIIIlIIIIIllIl) {
            this.tentacles[lllllllllllIIIlIllIIIIlIIIIIllIl].rotateAngleX = 0.2f * MathHelper.sin(lllllllllllIIIlIllIIIIlIIIIlIIlI * 0.3f + lllllllllllIIIlIllIIIIlIIIIIllIl) + 0.4f;
        }
    }
    
    public ModelGhast() {
        this.tentacles = new ModelRenderer[9];
        final int lllllllllllIIIlIllIIIIlIIIlIIlIl = -16;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        final ModelRenderer body = this.body;
        body.rotationPointY += 8.0f;
        final Random lllllllllllIIIlIllIIIIlIIIlIIlII = new Random(1660L);
        for (int lllllllllllIIIlIllIIIIlIIIlIIIll = 0; lllllllllllIIIlIllIIIIlIIIlIIIll < this.tentacles.length; ++lllllllllllIIIlIllIIIIlIIIlIIIll) {
            this.tentacles[lllllllllllIIIlIllIIIIlIIIlIIIll] = new ModelRenderer(this, 0, 0);
            final float lllllllllllIIIlIllIIIIlIIIlIIIlI = ((lllllllllllIIIlIllIIIIlIIIlIIIll % 3 - lllllllllllIIIlIllIIIIlIIIlIIIll / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
            final float lllllllllllIIIlIllIIIIlIIIlIIIIl = (lllllllllllIIIlIllIIIIlIIIlIIIll / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
            final int lllllllllllIIIlIllIIIIlIIIlIIIII = lllllllllllIIIlIllIIIIlIIIlIIlII.nextInt(7) + 8;
            this.tentacles[lllllllllllIIIlIllIIIIlIIIlIIIll].addBox(-1.0f, 0.0f, -1.0f, 2, lllllllllllIIIlIllIIIIlIIIlIIIII, 2);
            this.tentacles[lllllllllllIIIlIllIIIIlIIIlIIIll].rotationPointX = lllllllllllIIIlIllIIIIlIIIlIIIlI;
            this.tentacles[lllllllllllIIIlIllIIIIlIIIlIIIll].rotationPointZ = lllllllllllIIIlIllIIIIlIIIlIIIIl;
            this.tentacles[lllllllllllIIIlIllIIIIlIIIlIIIll].rotationPointY = 15.0f;
        }
    }
}
