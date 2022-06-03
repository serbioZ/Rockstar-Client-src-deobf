// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelWitch extends ModelVillager
{
    public /* synthetic */ boolean holdingItem;
    private final /* synthetic */ ModelRenderer witchHat;
    private final /* synthetic */ ModelRenderer mole;
    
    @Override
    public void setRotationAngles(final float lllllllllllIlllIIllIIIlllllllIll, final float lllllllllllIlllIIllIIIlllllllIlI, final float lllllllllllIlllIIllIIIllllllIIII, final float lllllllllllIlllIIllIIIlllllllIII, final float lllllllllllIlllIIllIIIlllllIlllI, final float lllllllllllIlllIIllIIIllllllIllI, final Entity lllllllllllIlllIIllIIIlllllIllII) {
        super.setRotationAngles(lllllllllllIlllIIllIIIlllllllIll, lllllllllllIlllIIllIIIlllllllIlI, lllllllllllIlllIIllIIIllllllIIII, lllllllllllIlllIIllIIIlllllllIII, lllllllllllIlllIIllIIIlllllIlllI, lllllllllllIlllIIllIIIllllllIllI, lllllllllllIlllIIllIIIlllllIllII);
        this.villagerNose.offsetX = 0.0f;
        this.villagerNose.offsetY = 0.0f;
        this.villagerNose.offsetZ = 0.0f;
        final float lllllllllllIlllIIllIIIllllllIlII = 0.01f * (lllllllllllIlllIIllIIIlllllIllII.getEntityId() % 10);
        this.villagerNose.rotateAngleX = MathHelper.sin(lllllllllllIlllIIllIIIlllllIllII.ticksExisted * lllllllllllIlllIIllIIIllllllIlII) * 4.5f * 0.017453292f;
        this.villagerNose.rotateAngleY = 0.0f;
        this.villagerNose.rotateAngleZ = MathHelper.cos(lllllllllllIlllIIllIIIlllllIllII.ticksExisted * lllllllllllIlllIIllIIIllllllIlII) * 2.5f * 0.017453292f;
        if (this.holdingItem) {
            this.villagerNose.rotateAngleX = -0.9f;
            this.villagerNose.offsetZ = -0.09375f;
            this.villagerNose.offsetY = 0.1875f;
        }
    }
    
    public ModelWitch(final float lllllllllllIlllIIllIIlIIIIIIlIIl) {
        super(lllllllllllIlllIIllIIlIIIIIIlIIl, 0.0f, 64, 128);
        this.mole = new ModelRenderer(this).setTextureSize(64, 128);
        this.mole.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.mole.setTextureOffset(0, 0).addBox(0.0f, 3.0f, -6.75f, 1, 1, 1, -0.25f);
        this.villagerNose.addChild(this.mole);
        this.witchHat = new ModelRenderer(this).setTextureSize(64, 128);
        this.witchHat.setRotationPoint(-5.0f, -10.03125f, -5.0f);
        this.witchHat.setTextureOffset(0, 64).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.villagerHead.addChild(this.witchHat);
        final ModelRenderer lllllllllllIlllIIllIIlIIIIIIllIl = new ModelRenderer(this).setTextureSize(64, 128);
        lllllllllllIlllIIllIIlIIIIIIllIl.setRotationPoint(1.75f, -4.0f, 2.0f);
        lllllllllllIlllIIllIIlIIIIIIllIl.setTextureOffset(0, 76).addBox(0.0f, 0.0f, 0.0f, 7, 4, 7);
        lllllllllllIlllIIllIIlIIIIIIllIl.rotateAngleX = -0.05235988f;
        lllllllllllIlllIIllIIlIIIIIIllIl.rotateAngleZ = 0.02617994f;
        this.witchHat.addChild(lllllllllllIlllIIllIIlIIIIIIllIl);
        final ModelRenderer lllllllllllIlllIIllIIlIIIIIIllII = new ModelRenderer(this).setTextureSize(64, 128);
        lllllllllllIlllIIllIIlIIIIIIllII.setRotationPoint(1.75f, -4.0f, 2.0f);
        lllllllllllIlllIIllIIlIIIIIIllII.setTextureOffset(0, 87).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        lllllllllllIlllIIllIIlIIIIIIllII.rotateAngleX = -0.10471976f;
        lllllllllllIlllIIllIIlIIIIIIllII.rotateAngleZ = 0.05235988f;
        lllllllllllIlllIIllIIlIIIIIIllIl.addChild(lllllllllllIlllIIllIIlIIIIIIllII);
        final ModelRenderer lllllllllllIlllIIllIIlIIIIIIlIll = new ModelRenderer(this).setTextureSize(64, 128);
        lllllllllllIlllIIllIIlIIIIIIlIll.setRotationPoint(1.75f, -2.0f, 2.0f);
        lllllllllllIlllIIllIIlIIIIIIlIll.setTextureOffset(0, 95).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        lllllllllllIlllIIllIIlIIIIIIlIll.rotateAngleX = -0.20943952f;
        lllllllllllIlllIIllIIlIIIIIIlIll.rotateAngleZ = 0.10471976f;
        lllllllllllIlllIIllIIlIIIIIIllII.addChild(lllllllllllIlllIIllIIlIIIIIIlIll);
    }
}
