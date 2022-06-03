// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelBoat extends ModelBase implements IMultipassModel
{
    public /* synthetic */ ModelRenderer noWater;
    public /* synthetic */ ModelRenderer[] boatSides;
    private final /* synthetic */ int patchList;
    public /* synthetic */ ModelRenderer[] paddles;
    
    @Override
    public void render(final Entity lllllllllllIlIlIlllIlIlIIlIlIIII, final float lllllllllllIlIlIlllIlIlIIlIIIlIl, final float lllllllllllIlIlIlllIlIlIIlIIlllI, final float lllllllllllIlIlIlllIlIlIIlIIIIll, final float lllllllllllIlIlIlllIlIlIIlIIIIlI, final float lllllllllllIlIlIlllIlIlIIlIIlIll, final float lllllllllllIlIlIlllIlIlIIlIIlIlI) {
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        final EntityBoat lllllllllllIlIlIlllIlIlIIlIIlIIl = (EntityBoat)lllllllllllIlIlIlllIlIlIIlIlIIII;
        this.setRotationAngles(lllllllllllIlIlIlllIlIlIIlIIIlIl, lllllllllllIlIlIlllIlIlIIlIIlllI, lllllllllllIlIlIlllIlIlIIlIIIIll, lllllllllllIlIlIlllIlIlIIlIIIIlI, lllllllllllIlIlIlllIlIlIIlIIlIll, lllllllllllIlIlIlllIlIlIIlIIlIlI, lllllllllllIlIlIlllIlIlIIlIlIIII);
        for (int lllllllllllIlIlIlllIlIlIIlIIlIII = 0; lllllllllllIlIlIlllIlIlIIlIIlIII < 5; ++lllllllllllIlIlIlllIlIlIIlIIlIII) {
            this.boatSides[lllllllllllIlIlIlllIlIlIIlIIlIII].render(lllllllllllIlIlIlllIlIlIIlIIlIlI);
        }
        this.renderPaddle(lllllllllllIlIlIlllIlIlIIlIIlIIl, 0, lllllllllllIlIlIlllIlIlIIlIIlIlI, lllllllllllIlIlIlllIlIlIIlIIIlIl);
        this.renderPaddle(lllllllllllIlIlIlllIlIlIIlIIlIIl, 1, lllllllllllIlIlIlllIlIlIIlIIlIlI, lllllllllllIlIlIlllIlIlIIlIIIlIl);
    }
    
    protected ModelRenderer makePaddle(final boolean lllllllllllIlIlIlllIlIlIIIlIIIlI) {
        final ModelRenderer lllllllllllIlIlIlllIlIlIIIlIlIII = new ModelRenderer(this, 62, lllllllllllIlIlIlllIlIlIIIlIIIlI ? 0 : 20).setTextureSize(128, 64);
        final int lllllllllllIlIlIlllIlIlIIIlIIlll = 20;
        final int lllllllllllIlIlIlllIlIlIIIlIIllI = 7;
        final int lllllllllllIlIlIlllIlIlIIIlIIlIl = 6;
        final float lllllllllllIlIlIlllIlIlIIIlIIlII = -5.0f;
        lllllllllllIlIlIlllIlIlIIIlIlIII.addBox(-1.0f, 0.0f, -5.0f, 2, 2, 18);
        lllllllllllIlIlIlllIlIlIIIlIlIII.addBox(lllllllllllIlIlIlllIlIlIIIlIIIlI ? -1.001f : 0.001f, -3.0f, 8.0f, 1, 6, 7);
        return lllllllllllIlIlIlllIlIlIIIlIlIII;
    }
    
    protected void renderPaddle(final EntityBoat lllllllllllIlIlIlllIlIlIIIIlIlII, final int lllllllllllIlIlIlllIlIlIIIIIllII, final float lllllllllllIlIlIlllIlIlIIIIIlIll, final float lllllllllllIlIlIlllIlIlIIIIIlIlI) {
        final float lllllllllllIlIlIlllIlIlIIIIlIIII = lllllllllllIlIlIlllIlIlIIIIlIlII.getRowingTime(lllllllllllIlIlIlllIlIlIIIIIllII, lllllllllllIlIlIlllIlIlIIIIIlIlI);
        final ModelRenderer lllllllllllIlIlIlllIlIlIIIIIllll = this.paddles[lllllllllllIlIlIlllIlIlIIIIIllII];
        lllllllllllIlIlIlllIlIlIIIIIllll.rotateAngleX = (float)MathHelper.clampedLerp(-1.0471975803375244, -0.2617993950843811, (MathHelper.sin(-lllllllllllIlIlIlllIlIlIIIIlIIII) + 1.0f) / 2.0f);
        lllllllllllIlIlIlllIlIlIIIIIllll.rotateAngleY = (float)MathHelper.clampedLerp(-0.7853981633974483, 0.7853981633974483, (MathHelper.sin(-lllllllllllIlIlIlllIlIlIIIIlIIII + 1.0f) + 1.0f) / 2.0f);
        if (lllllllllllIlIlIlllIlIlIIIIIllII == 1) {
            lllllllllllIlIlIlllIlIlIIIIIllll.rotateAngleY = 3.1415927f - lllllllllllIlIlIlllIlIlIIIIIllll.rotateAngleY;
        }
        lllllllllllIlIlIlllIlIlIIIIIllll.render(lllllllllllIlIlIlllIlIlIIIIIlIll);
    }
    
    @Override
    public void renderMultipass(final Entity lllllllllllIlIlIlllIlIlIIIlllIlI, final float lllllllllllIlIlIlllIlIlIIIlllIIl, final float lllllllllllIlIlIlllIlIlIIIlllIII, final float lllllllllllIlIlIlllIlIlIIIllIlll, final float lllllllllllIlIlIlllIlIlIIIllIllI, final float lllllllllllIlIlIlllIlIlIIIllIlIl, final float lllllllllllIlIlIlllIlIlIIIllIlII) {
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.colorMask(false, false, false, false);
        this.noWater.render(lllllllllllIlIlIlllIlIlIIIllIlII);
        GlStateManager.colorMask(true, true, true, true);
    }
    
    public ModelBoat() {
        this.boatSides = new ModelRenderer[5];
        this.paddles = new ModelRenderer[2];
        this.patchList = GLAllocation.generateDisplayLists(1);
        this.boatSides[0] = new ModelRenderer(this, 0, 0).setTextureSize(128, 64);
        this.boatSides[1] = new ModelRenderer(this, 0, 19).setTextureSize(128, 64);
        this.boatSides[2] = new ModelRenderer(this, 0, 27).setTextureSize(128, 64);
        this.boatSides[3] = new ModelRenderer(this, 0, 35).setTextureSize(128, 64);
        this.boatSides[4] = new ModelRenderer(this, 0, 43).setTextureSize(128, 64);
        final int lllllllllllIlIlIlllIlIlIIllIIllI = 32;
        final int lllllllllllIlIlIlllIlIlIIllIIlIl = 6;
        final int lllllllllllIlIlIlllIlIlIIllIIlII = 20;
        final int lllllllllllIlIlIlllIlIlIIllIIIll = 4;
        final int lllllllllllIlIlIlllIlIlIIllIIIlI = 28;
        this.boatSides[0].addBox(-14.0f, -9.0f, -3.0f, 28, 16, 3, 0.0f);
        this.boatSides[0].setRotationPoint(0.0f, 3.0f, 1.0f);
        this.boatSides[1].addBox(-13.0f, -7.0f, -1.0f, 18, 6, 2, 0.0f);
        this.boatSides[1].setRotationPoint(-15.0f, 4.0f, 4.0f);
        this.boatSides[2].addBox(-8.0f, -7.0f, -1.0f, 16, 6, 2, 0.0f);
        this.boatSides[2].setRotationPoint(15.0f, 4.0f, 0.0f);
        this.boatSides[3].addBox(-14.0f, -7.0f, -1.0f, 28, 6, 2, 0.0f);
        this.boatSides[3].setRotationPoint(0.0f, 4.0f, -9.0f);
        this.boatSides[4].addBox(-14.0f, -7.0f, -1.0f, 28, 6, 2, 0.0f);
        this.boatSides[4].setRotationPoint(0.0f, 4.0f, 9.0f);
        this.boatSides[0].rotateAngleX = 1.5707964f;
        this.boatSides[1].rotateAngleY = 4.712389f;
        this.boatSides[2].rotateAngleY = 1.5707964f;
        this.boatSides[3].rotateAngleY = 3.1415927f;
        (this.paddles[0] = this.makePaddle(true)).setRotationPoint(3.0f, -5.0f, 9.0f);
        (this.paddles[1] = this.makePaddle(false)).setRotationPoint(3.0f, -5.0f, -9.0f);
        this.paddles[1].rotateAngleY = 3.1415927f;
        this.paddles[0].rotateAngleZ = 0.19634955f;
        this.paddles[1].rotateAngleZ = 0.19634955f;
        this.noWater = new ModelRenderer(this, 0, 0).setTextureSize(128, 64);
        this.noWater.addBox(-14.0f, -9.0f, -3.0f, 28, 16, 3, 0.0f);
        this.noWater.setRotationPoint(0.0f, -3.0f, 1.0f);
        this.noWater.rotateAngleX = 1.5707964f;
    }
}
