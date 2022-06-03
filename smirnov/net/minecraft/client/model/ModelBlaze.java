// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelBlaze extends ModelBase
{
    private final /* synthetic */ ModelRenderer blazeHead;
    private final /* synthetic */ ModelRenderer[] blazeSticks;
    
    @Override
    public void render(final Entity llllllllllllIIllIIlIllIlIlIIlIlI, final float llllllllllllIIllIIlIllIlIlIIlIIl, final float llllllllllllIIllIIlIllIlIlIIlIII, final float llllllllllllIIllIIlIllIlIlIIIlll, final float llllllllllllIIllIIlIllIlIlIIIllI, final float llllllllllllIIllIIlIllIlIlIIIlIl, final float llllllllllllIIllIIlIllIlIlIIllIl) {
        this.setRotationAngles(llllllllllllIIllIIlIllIlIlIIlIIl, llllllllllllIIllIIlIllIlIlIIlIII, llllllllllllIIllIIlIllIlIlIIIlll, llllllllllllIIllIIlIllIlIlIIIllI, llllllllllllIIllIIlIllIlIlIIIlIl, llllllllllllIIllIIlIllIlIlIIllIl, llllllllllllIIllIIlIllIlIlIIlIlI);
        this.blazeHead.render(llllllllllllIIllIIlIllIlIlIIllIl);
        char llllllllllllIIllIIlIllIlIlIIIIII;
        for (String llllllllllllIIllIIlIllIlIlIIIIIl = (String)((ModelRenderer[])(Object)(llllllllllllIIllIIlIllIlIlIIIIII = (char)(Object)this.blazeSticks)).length, llllllllllllIIllIIlIllIlIlIIIIlI = (String)0; llllllllllllIIllIIlIllIlIlIIIIlI < llllllllllllIIllIIlIllIlIlIIIIIl; ++llllllllllllIIllIIlIllIlIlIIIIlI) {
            final ModelRenderer llllllllllllIIllIIlIllIlIlIIllII = llllllllllllIIllIIlIllIlIlIIIIII[llllllllllllIIllIIlIllIlIlIIIIlI];
            llllllllllllIIllIIlIllIlIlIIllII.render(llllllllllllIIllIIlIllIlIlIIllIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIIllIIlIllIlIIlllIII, final float llllllllllllIIllIIlIllIlIIllIlll, final float llllllllllllIIllIIlIllIlIIllIllI, final float llllllllllllIIllIIlIllIlIIlIlIll, final float llllllllllllIIllIIlIllIlIIllIlII, final float llllllllllllIIllIIlIllIlIIllIIll, final Entity llllllllllllIIllIIlIllIlIIllIIlI) {
        float llllllllllllIIllIIlIllIlIIllIIIl = llllllllllllIIllIIlIllIlIIllIllI * 3.1415927f * -0.1f;
        for (int llllllllllllIIllIIlIllIlIIllIIII = 0; llllllllllllIIllIIlIllIlIIllIIII < 4; ++llllllllllllIIllIIlIllIlIIllIIII) {
            this.blazeSticks[llllllllllllIIllIIlIllIlIIllIIII].rotationPointY = -2.0f + MathHelper.cos((llllllllllllIIllIIlIllIlIIllIIII * 2 + llllllllllllIIllIIlIllIlIIllIllI) * 0.25f);
            this.blazeSticks[llllllllllllIIllIIlIllIlIIllIIII].rotationPointX = MathHelper.cos(llllllllllllIIllIIlIllIlIIllIIIl) * 9.0f;
            this.blazeSticks[llllllllllllIIllIIlIllIlIIllIIII].rotationPointZ = MathHelper.sin(llllllllllllIIllIIlIllIlIIllIIIl) * 9.0f;
            ++llllllllllllIIllIIlIllIlIIllIIIl;
        }
        llllllllllllIIllIIlIllIlIIllIIIl = 0.7853982f + llllllllllllIIllIIlIllIlIIllIllI * 3.1415927f * 0.03f;
        for (int llllllllllllIIllIIlIllIlIIlIllll = 4; llllllllllllIIllIIlIllIlIIlIllll < 8; ++llllllllllllIIllIIlIllIlIIlIllll) {
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIllll].rotationPointY = 2.0f + MathHelper.cos((llllllllllllIIllIIlIllIlIIlIllll * 2 + llllllllllllIIllIIlIllIlIIllIllI) * 0.25f);
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIllll].rotationPointX = MathHelper.cos(llllllllllllIIllIIlIllIlIIllIIIl) * 7.0f;
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIllll].rotationPointZ = MathHelper.sin(llllllllllllIIllIIlIllIlIIllIIIl) * 7.0f;
            ++llllllllllllIIllIIlIllIlIIllIIIl;
        }
        llllllllllllIIllIIlIllIlIIllIIIl = 0.47123894f + llllllllllllIIllIIlIllIlIIllIllI * 3.1415927f * -0.05f;
        for (int llllllllllllIIllIIlIllIlIIlIlllI = 8; llllllllllllIIllIIlIllIlIIlIlllI < 12; ++llllllllllllIIllIIlIllIlIIlIlllI) {
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIlllI].rotationPointY = 11.0f + MathHelper.cos((llllllllllllIIllIIlIllIlIIlIlllI * 1.5f + llllllllllllIIllIIlIllIlIIllIllI) * 0.5f);
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIlllI].rotationPointX = MathHelper.cos(llllllllllllIIllIIlIllIlIIllIIIl) * 5.0f;
            this.blazeSticks[llllllllllllIIllIIlIllIlIIlIlllI].rotationPointZ = MathHelper.sin(llllllllllllIIllIIlIllIlIIllIIIl) * 5.0f;
            ++llllllllllllIIllIIlIllIlIIllIIIl;
        }
        this.blazeHead.rotateAngleY = llllllllllllIIllIIlIllIlIIlIlIll * 0.017453292f;
        this.blazeHead.rotateAngleX = llllllllllllIIllIIlIllIlIIllIlII * 0.017453292f;
    }
    
    public ModelBlaze() {
        this.blazeSticks = new ModelRenderer[12];
        for (int llllllllllllIIllIIlIllIlIllIIIll = 0; llllllllllllIIllIIlIllIlIllIIIll < this.blazeSticks.length; ++llllllllllllIIllIIlIllIlIllIIIll) {
            (this.blazeSticks[llllllllllllIIllIIlIllIlIllIIIll] = new ModelRenderer(this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.blazeHead = new ModelRenderer(this, 0, 0);
        this.blazeHead.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }
}
