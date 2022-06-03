// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.Entity;

public class ModelSquid extends ModelBase
{
    /* synthetic */ ModelRenderer[] squidTentacles;
    /* synthetic */ ModelRenderer squidBody;
    
    @Override
    public void render(final Entity lllllllllllIIlllllIlIllIIlIlIIIl, final float lllllllllllIIlllllIlIllIIlIIIlll, final float lllllllllllIIlllllIlIllIIlIIllll, final float lllllllllllIIlllllIlIllIIlIIlllI, final float lllllllllllIIlllllIlIllIIlIIllIl, final float lllllllllllIIlllllIlIllIIlIIllII, final float lllllllllllIIlllllIlIllIIlIIlIll) {
        this.setRotationAngles(lllllllllllIIlllllIlIllIIlIIIlll, lllllllllllIIlllllIlIllIIlIIllll, lllllllllllIIlllllIlIllIIlIIlllI, lllllllllllIIlllllIlIllIIlIIllIl, lllllllllllIIlllllIlIllIIlIIllII, lllllllllllIIlllllIlIllIIlIIlIll, lllllllllllIIlllllIlIllIIlIlIIIl);
        this.squidBody.render(lllllllllllIIlllllIlIllIIlIIlIll);
        final long lllllllllllIIlllllIlIllIIIlllllI;
        final byte lllllllllllIIlllllIlIllIIIllllll = (byte)((ModelRenderer[])(Object)(lllllllllllIIlllllIlIllIIIlllllI = (long)(Object)this.squidTentacles)).length;
        for (Exception lllllllllllIIlllllIlIllIIlIIIIII = (Exception)0; lllllllllllIIlllllIlIllIIlIIIIII < lllllllllllIIlllllIlIllIIIllllll; ++lllllllllllIIlllllIlIllIIlIIIIII) {
            final ModelRenderer lllllllllllIIlllllIlIllIIlIIlIlI = lllllllllllIIlllllIlIllIIIlllllI[lllllllllllIIlllllIlIllIIlIIIIII];
            lllllllllllIIlllllIlIllIIlIIlIlI.render(lllllllllllIIlllllIlIllIIlIIlIll);
        }
    }
    
    public ModelSquid() {
        this.squidTentacles = new ModelRenderer[8];
        final int lllllllllllIIlllllIlIllIIllllllI = -16;
        this.squidBody = new ModelRenderer(this, 0, 0);
        this.squidBody.addBox(-6.0f, -8.0f, -6.0f, 12, 16, 12);
        final ModelRenderer squidBody = this.squidBody;
        squidBody.rotationPointY += 8.0f;
        for (int lllllllllllIIlllllIlIllIIlllllIl = 0; lllllllllllIIlllllIlIllIIlllllIl < this.squidTentacles.length; ++lllllllllllIIlllllIlIllIIlllllIl) {
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl] = new ModelRenderer(this, 48, 0);
            double lllllllllllIIlllllIlIllIIlllllII = lllllllllllIIlllllIlIllIIlllllIl * 3.141592653589793 * 2.0 / this.squidTentacles.length;
            final float lllllllllllIIlllllIlIllIIllllIll = (float)Math.cos(lllllllllllIIlllllIlIllIIlllllII) * 5.0f;
            final float lllllllllllIIlllllIlIllIIllllIlI = (float)Math.sin(lllllllllllIIlllllIlIllIIlllllII) * 5.0f;
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl].addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl].rotationPointX = lllllllllllIIlllllIlIllIIllllIll;
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl].rotationPointZ = lllllllllllIIlllllIlIllIIllllIlI;
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl].rotationPointY = 15.0f;
            lllllllllllIIlllllIlIllIIlllllII = lllllllllllIIlllllIlIllIIlllllIl * 3.141592653589793 * -2.0 / this.squidTentacles.length + 1.5707963267948966;
            this.squidTentacles[lllllllllllIIlllllIlIllIIlllllIl].rotateAngleY = (float)lllllllllllIIlllllIlIllIIlllllII;
        }
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIIlllllIlIllIIllIllII, final float lllllllllllIIlllllIlIllIIllIlIll, final float lllllllllllIIlllllIlIllIIllIlIlI, final float lllllllllllIIlllllIlIllIIllIlIIl, final float lllllllllllIIlllllIlIllIIllIlIII, final float lllllllllllIIlllllIlIllIIllIIlll, final Entity lllllllllllIIlllllIlIllIIllIIllI) {
        final float lllllllllllIIlllllIlIllIIlIlllll;
        final boolean lllllllllllIIlllllIlIllIIllIIIII = ((ModelRenderer[])(Object)(lllllllllllIIlllllIlIllIIlIlllll = (float)(Object)this.squidTentacles)).length != 0;
        for (final ModelRenderer lllllllllllIIlllllIlIllIIllIIlIl : lllllllllllIIlllllIlIllIIlIlllll) {
            lllllllllllIIlllllIlIllIIllIIlIl.rotateAngleX = lllllllllllIIlllllIlIllIIllIlIlI;
        }
    }
}
