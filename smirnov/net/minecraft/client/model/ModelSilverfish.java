// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelSilverfish extends ModelBase
{
    private static final /* synthetic */ int[][] SILVERFISH_TEXTURE_POSITIONS;
    private final /* synthetic */ ModelRenderer[] silverfishBodyParts;
    private final /* synthetic */ ModelRenderer[] silverfishWings;
    private static final /* synthetic */ int[][] SILVERFISH_BOX_LENGTH;
    private final /* synthetic */ float[] zPlacement;
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIlIIIllIIIllIlI, final float llllllllllllllIIlIlIIIllIIIllIIl, final float llllllllllllllIIlIlIIIllIIIlIIIl, final float llllllllllllllIIlIlIIIllIIIlIlll, final float llllllllllllllIIlIlIIIllIIIlIllI, final float llllllllllllllIIlIlIIIllIIIlIlIl, final Entity llllllllllllllIIlIlIIIllIIIlIlII) {
        for (int llllllllllllllIIlIlIIIllIIIlIIll = 0; llllllllllllllIIlIlIIIllIIIlIIll < this.silverfishBodyParts.length; ++llllllllllllllIIlIlIIIllIIIlIIll) {
            this.silverfishBodyParts[llllllllllllllIIlIlIIIllIIIlIIll].rotateAngleY = MathHelper.cos(llllllllllllllIIlIlIIIllIIIlIIIl * 0.9f + llllllllllllllIIlIlIIIllIIIlIIll * 0.15f * 3.1415927f) * 3.1415927f * 0.05f * (1 + Math.abs(llllllllllllllIIlIlIIIllIIIlIIll - 2));
            this.silverfishBodyParts[llllllllllllllIIlIlIIIllIIIlIIll].rotationPointX = MathHelper.sin(llllllllllllllIIlIlIIIllIIIlIIIl * 0.9f + llllllllllllllIIlIlIIIllIIIlIIll * 0.15f * 3.1415927f) * 3.1415927f * 0.2f * Math.abs(llllllllllllllIIlIlIIIllIIIlIIll - 2);
        }
        this.silverfishWings[0].rotateAngleY = this.silverfishBodyParts[2].rotateAngleY;
        this.silverfishWings[1].rotateAngleY = this.silverfishBodyParts[4].rotateAngleY;
        this.silverfishWings[1].rotationPointX = this.silverfishBodyParts[4].rotationPointX;
        this.silverfishWings[2].rotateAngleY = this.silverfishBodyParts[1].rotateAngleY;
        this.silverfishWings[2].rotationPointX = this.silverfishBodyParts[1].rotationPointX;
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlIlIIIllIIllIIll, final float llllllllllllllIIlIlIIIllIIlIlIII, final float llllllllllllllIIlIlIIIllIIllIIIl, final float llllllllllllllIIlIlIIIllIIlIIllI, final float llllllllllllllIIlIlIIIllIIlIllll, final float llllllllllllllIIlIlIIIllIIlIIlII, final float llllllllllllllIIlIlIIIllIIlIllIl) {
        this.setRotationAngles(llllllllllllllIIlIlIIIllIIlIlIII, llllllllllllllIIlIlIIIllIIllIIIl, llllllllllllllIIlIlIIIllIIlIIllI, llllllllllllllIIlIlIIIllIIlIllll, llllllllllllllIIlIlIIIllIIlIIlII, llllllllllllllIIlIlIIIllIIlIllIl, llllllllllllllIIlIlIIIllIIllIIll);
        Exception llllllllllllllIIlIlIIIllIIIlllll;
        for (long llllllllllllllIIlIlIIIllIIlIIIII = ((ModelRenderer[])(Object)(llllllllllllllIIlIlIIIllIIIlllll = (Exception)(Object)this.silverfishBodyParts)).length, llllllllllllllIIlIlIIIllIIlIIIIl = 0; llllllllllllllIIlIlIIIllIIlIIIIl < llllllllllllllIIlIlIIIllIIlIIIII; ++llllllllllllllIIlIlIIIllIIlIIIIl) {
            final ModelRenderer llllllllllllllIIlIlIIIllIIlIllII = llllllllllllllIIlIlIIIllIIIlllll[llllllllllllllIIlIlIIIllIIlIIIIl];
            llllllllllllllIIlIlIIIllIIlIllII.render(llllllllllllllIIlIlIIIllIIlIllIl);
        }
        for (long llllllllllllllIIlIlIIIllIIlIIIII = ((ModelRenderer[])(Object)(llllllllllllllIIlIlIIIllIIIlllll = (Exception)(Object)this.silverfishWings)).length, llllllllllllllIIlIlIIIllIIlIIIIl = 0; llllllllllllllIIlIlIIIllIIlIIIIl < llllllllllllllIIlIlIIIllIIlIIIII; ++llllllllllllllIIlIlIIIllIIlIIIIl) {
            final ModelRenderer llllllllllllllIIlIlIIIllIIlIlIll = llllllllllllllIIlIlIIIllIIIlllll[llllllllllllllIIlIlIIIllIIlIIIIl];
            llllllllllllllIIlIlIIIllIIlIlIll.render(llllllllllllllIIlIlIIIllIIlIllIl);
        }
    }
    
    public ModelSilverfish() {
        this.silverfishBodyParts = new ModelRenderer[7];
        this.zPlacement = new float[7];
        float llllllllllllllIIlIlIIIllIlIIIlIl = -3.5f;
        for (int llllllllllllllIIlIlIIIllIlIIIlII = 0; llllllllllllllIIlIlIIIllIlIIIlII < this.silverfishBodyParts.length; ++llllllllllllllIIlIlIIIllIlIIIlII) {
            (this.silverfishBodyParts[llllllllllllllIIlIlIIIllIlIIIlII] = new ModelRenderer(this, ModelSilverfish.SILVERFISH_TEXTURE_POSITIONS[llllllllllllllIIlIlIIIllIlIIIlII][0], ModelSilverfish.SILVERFISH_TEXTURE_POSITIONS[llllllllllllllIIlIlIIIllIlIIIlII][1])).addBox(ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][0] * -0.5f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][2] * -0.5f, ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][0], ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][1], ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][2]);
            this.silverfishBodyParts[llllllllllllllIIlIlIIIllIlIIIlII].setRotationPoint(0.0f, (float)(24 - ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][1]), llllllllllllllIIlIlIIIllIlIIIlIl);
            this.zPlacement[llllllllllllllIIlIlIIIllIlIIIlII] = llllllllllllllIIlIlIIIllIlIIIlIl;
            if (llllllllllllllIIlIlIIIllIlIIIlII < this.silverfishBodyParts.length - 1) {
                llllllllllllllIIlIlIIIllIlIIIlIl += (ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII][2] + ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIlIIIllIlIIIlII + 1][2]) * 0.5f;
            }
        }
        this.silverfishWings = new ModelRenderer[3];
        (this.silverfishWings[0] = new ModelRenderer(this, 20, 0)).addBox(-5.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[2][2] * -0.5f, 10, 8, ModelSilverfish.SILVERFISH_BOX_LENGTH[2][2]);
        this.silverfishWings[0].setRotationPoint(0.0f, 16.0f, this.zPlacement[2]);
        (this.silverfishWings[1] = new ModelRenderer(this, 20, 11)).addBox(-3.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2] * -0.5f, 6, 4, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2]);
        this.silverfishWings[1].setRotationPoint(0.0f, 20.0f, this.zPlacement[4]);
        (this.silverfishWings[2] = new ModelRenderer(this, 20, 18)).addBox(-3.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2] * -0.5f, 6, 5, ModelSilverfish.SILVERFISH_BOX_LENGTH[1][2]);
        this.silverfishWings[2].setRotationPoint(0.0f, 19.0f, this.zPlacement[1]);
    }
    
    static {
        SILVERFISH_BOX_LENGTH = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
        SILVERFISH_TEXTURE_POSITIONS = new int[][] { new int[2], { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };
    }
}
