// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

public class ModelVillager extends ModelBase
{
    public /* synthetic */ ModelRenderer villagerHead;
    public /* synthetic */ ModelRenderer leftVillagerLeg;
    public /* synthetic */ ModelRenderer villagerArms;
    public /* synthetic */ ModelRenderer rightVillagerLeg;
    public /* synthetic */ ModelRenderer villagerBody;
    public /* synthetic */ ModelRenderer villagerNose;
    
    public ModelVillager(final float lllllllllllIlIIlllIIllIIllllIIll) {
        this(lllllllllllIlIIlllIIllIIllllIIll, 0.0f, 64, 64);
    }
    
    public ModelVillager(final float lllllllllllIlIIlllIIllIIlllIllII, final float lllllllllllIlIIlllIIllIIlllIIllI, final int lllllllllllIlIIlllIIllIIlllIIlIl, final int lllllllllllIlIIlllIIllIIlllIlIIl) {
        this.villagerHead = new ModelRenderer(this).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.villagerHead.setRotationPoint(0.0f, 0.0f + lllllllllllIlIIlllIIllIIlllIIllI, 0.0f);
        this.villagerHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, lllllllllllIlIIlllIIllIIlllIllII);
        this.villagerNose = new ModelRenderer(this).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.villagerNose.setRotationPoint(0.0f, lllllllllllIlIIlllIIllIIlllIIllI - 2.0f, 0.0f);
        this.villagerNose.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, lllllllllllIlIIlllIIllIIlllIllII);
        this.villagerHead.addChild(this.villagerNose);
        this.villagerBody = new ModelRenderer(this).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.villagerBody.setRotationPoint(0.0f, 0.0f + lllllllllllIlIIlllIIllIIlllIIllI, 0.0f);
        this.villagerBody.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, lllllllllllIlIIlllIIllIIlllIllII);
        this.villagerBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, lllllllllllIlIIlllIIllIIlllIllII + 0.5f);
        this.villagerArms = new ModelRenderer(this).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.villagerArms.setRotationPoint(0.0f, 0.0f + lllllllllllIlIIlllIIllIIlllIIllI + 2.0f, 0.0f);
        this.villagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllIlIIlllIIllIIlllIllII);
        this.villagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllIlIIlllIIllIIlllIllII);
        this.villagerArms.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, lllllllllllIlIIlllIIllIIlllIllII);
        this.rightVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.rightVillagerLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllIlIIlllIIllIIlllIIllI, 0.0f);
        this.rightVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllIlIIlllIIllIIlllIllII);
        this.leftVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllIlIIlllIIllIIlllIIlIl, lllllllllllIlIIlllIIllIIlllIlIIl);
        this.leftVillagerLeg.mirror = true;
        this.leftVillagerLeg.setRotationPoint(2.0f, 12.0f + lllllllllllIlIIlllIIllIIlllIIllI, 0.0f);
        this.leftVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllIlIIlllIIllIIlllIllII);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllIlIIlllIIllIIllIIIlIl, final float lllllllllllIlIIlllIIllIIllIIIlII, final float lllllllllllIlIIlllIIllIIllIIIIll, final float lllllllllllIlIIlllIIllIIlIlllIll, final float lllllllllllIlIIlllIIllIIllIIIIIl, final float lllllllllllIlIIlllIIllIIllIIIIII, final Entity lllllllllllIlIIlllIIllIIlIllllll) {
        this.villagerHead.rotateAngleY = lllllllllllIlIIlllIIllIIlIlllIll * 0.017453292f;
        this.villagerHead.rotateAngleX = lllllllllllIlIIlllIIllIIllIIIIIl * 0.017453292f;
        this.villagerArms.rotationPointY = 3.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        this.villagerArms.rotateAngleX = -0.75f;
        this.rightVillagerLeg.rotateAngleX = MathHelper.cos(lllllllllllIlIIlllIIllIIllIIIlIl * 0.6662f) * 1.4f * lllllllllllIlIIlllIIllIIllIIIlII * 0.5f;
        this.leftVillagerLeg.rotateAngleX = MathHelper.cos(lllllllllllIlIIlllIIllIIllIIIlIl * 0.6662f + 3.1415927f) * 1.4f * lllllllllllIlIIlllIIllIIllIIIlII * 0.5f;
        this.rightVillagerLeg.rotateAngleY = 0.0f;
        this.leftVillagerLeg.rotateAngleY = 0.0f;
    }
    
    @Override
    public void render(final Entity lllllllllllIlIIlllIIllIIllIllIlI, final float lllllllllllIlIIlllIIllIIllIllIIl, final float lllllllllllIlIIlllIIllIIllIlIIII, final float lllllllllllIlIIlllIIllIIllIlIlll, final float lllllllllllIlIIlllIIllIIllIIlllI, final float lllllllllllIlIIlllIIllIIllIlIlIl, final float lllllllllllIlIIlllIIllIIllIIllII) {
        this.setRotationAngles(lllllllllllIlIIlllIIllIIllIllIIl, lllllllllllIlIIlllIIllIIllIlIIII, lllllllllllIlIIlllIIllIIllIlIlll, lllllllllllIlIIlllIIllIIllIIlllI, lllllllllllIlIIlllIIllIIllIlIlIl, lllllllllllIlIIlllIIllIIllIIllII, lllllllllllIlIIlllIIllIIllIllIlI);
        this.villagerHead.render(lllllllllllIlIIlllIIllIIllIIllII);
        this.villagerBody.render(lllllllllllIlIIlllIIllIIllIIllII);
        this.rightVillagerLeg.render(lllllllllllIlIIlllIIllIIllIIllII);
        this.leftVillagerLeg.render(lllllllllllIlIIlllIIllIIllIIllII);
        this.villagerArms.render(lllllllllllIlIIlllIIllIIllIIllII);
    }
}
