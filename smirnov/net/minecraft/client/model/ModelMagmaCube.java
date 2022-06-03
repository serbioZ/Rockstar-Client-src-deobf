// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

public class ModelMagmaCube extends ModelBase
{
    /* synthetic */ ModelRenderer core;
    /* synthetic */ ModelRenderer[] segments;
    
    @Override
    public void render(final Entity llllllllllllIIIlIIlIIlIIIlllIIIl, final float llllllllllllIIIlIIlIIlIIIllIIlll, final float llllllllllllIIIlIIlIIlIIIllIllll, final float llllllllllllIIIlIIlIIlIIIllIlllI, final float llllllllllllIIIlIIlIIlIIIllIIlII, final float llllllllllllIIIlIIlIIlIIIllIIIll, final float llllllllllllIIIlIIlIIlIIIllIIIlI) {
        this.setRotationAngles(llllllllllllIIIlIIlIIlIIIllIIlll, llllllllllllIIIlIIlIIlIIIllIllll, llllllllllllIIIlIIlIIlIIIllIlllI, llllllllllllIIIlIIlIIlIIIllIIlII, llllllllllllIIIlIIlIIlIIIllIIIll, llllllllllllIIIlIIlIIlIIIllIIIlI, llllllllllllIIIlIIlIIlIIIlllIIIl);
        this.core.render(llllllllllllIIIlIIlIIlIIIllIIIlI);
        final float llllllllllllIIIlIIlIIlIIIlIllllI;
        final short llllllllllllIIIlIIlIIlIIIlIlllll = (short)((ModelRenderer[])(Object)(llllllllllllIIIlIIlIIlIIIlIllllI = (float)(Object)this.segments)).length;
        for (Exception llllllllllllIIIlIIlIIlIIIllIIIII = (Exception)0; llllllllllllIIIlIIlIIlIIIllIIIII < llllllllllllIIIlIIlIIlIIIlIlllll; ++llllllllllllIIIlIIlIIlIIIllIIIII) {
            final ModelRenderer llllllllllllIIIlIIlIIlIIIllIlIlI = llllllllllllIIIlIIlIIlIIIlIllllI[llllllllllllIIIlIIlIIlIIIllIIIII];
            llllllllllllIIIlIIlIIlIIIllIlIlI.render(llllllllllllIIIlIIlIIlIIIllIIIlI);
        }
    }
    
    public ModelMagmaCube() {
        this.segments = new ModelRenderer[8];
        for (int llllllllllllIIIlIIlIIlIIlIIllIIl = 0; llllllllllllIIIlIIlIIlIIlIIllIIl < this.segments.length; ++llllllllllllIIIlIIlIIlIIlIIllIIl) {
            int llllllllllllIIIlIIlIIlIIlIIllIII = 0;
            int llllllllllllIIIlIIlIIlIIlIIlIlll;
            if ((llllllllllllIIIlIIlIIlIIlIIlIlll = llllllllllllIIIlIIlIIlIIlIIllIIl) == 2) {
                llllllllllllIIIlIIlIIlIIlIIllIII = 24;
                llllllllllllIIIlIIlIIlIIlIIlIlll = 10;
            }
            else if (llllllllllllIIIlIIlIIlIIlIIllIIl == 3) {
                llllllllllllIIIlIIlIIlIIlIIllIII = 24;
                llllllllllllIIIlIIlIIlIIlIIlIlll = 19;
            }
            (this.segments[llllllllllllIIIlIIlIIlIIlIIllIIl] = new ModelRenderer(this, llllllllllllIIIlIIlIIlIIlIIllIII, llllllllllllIIIlIIlIIlIIlIIlIlll)).addBox(-4.0f, (float)(16 + llllllllllllIIIlIIlIIlIIlIIllIIl), -4.0f, 8, 1, 8);
        }
        this.core = new ModelRenderer(this, 0, 16);
        this.core.addBox(-2.0f, 18.0f, -2.0f, 4, 4, 4);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllIIIlIIlIIlIIlIIIlIll, final float llllllllllllIIIlIIlIIlIIlIIIlIlI, final float llllllllllllIIIlIIlIIlIIlIIIlIIl, final float llllllllllllIIIlIIlIIlIIlIIIIIlI) {
        final EntityMagmaCube llllllllllllIIIlIIlIIlIIlIIIIlll = (EntityMagmaCube)llllllllllllIIIlIIlIIlIIlIIIlIll;
        float llllllllllllIIIlIIlIIlIIlIIIIllI = llllllllllllIIIlIIlIIlIIlIIIIlll.prevSquishFactor + (llllllllllllIIIlIIlIIlIIlIIIIlll.squishFactor - llllllllllllIIIlIIlIIlIIlIIIIlll.prevSquishFactor) * llllllllllllIIIlIIlIIlIIlIIIIIlI;
        if (llllllllllllIIIlIIlIIlIIlIIIIllI < 0.0f) {
            llllllllllllIIIlIIlIIlIIlIIIIllI = 0.0f;
        }
        for (int llllllllllllIIIlIIlIIlIIlIIIIlIl = 0; llllllllllllIIIlIIlIIlIIlIIIIlIl < this.segments.length; ++llllllllllllIIIlIIlIIlIIlIIIIlIl) {
            this.segments[llllllllllllIIIlIIlIIlIIlIIIIlIl].rotationPointY = -(4 - llllllllllllIIIlIIlIIlIIlIIIIlIl) * llllllllllllIIIlIIlIIlIIlIIIIllI * 1.7f;
        }
    }
}
