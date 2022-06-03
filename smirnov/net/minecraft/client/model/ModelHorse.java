// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;

public class ModelHorse extends ModelBase
{
    private final /* synthetic */ ModelRenderer backLeftLeg;
    private final /* synthetic */ ModelRenderer frontRightShin;
    private final /* synthetic */ ModelRenderer lowerMouth;
    private final /* synthetic */ ModelRenderer backRightLeg;
    private final /* synthetic */ ModelRenderer horseLeftSaddleRope;
    private final /* synthetic */ ModelRenderer horseSaddleBack;
    private final /* synthetic */ ModelRenderer tailTip;
    private final /* synthetic */ ModelRenderer horseLeftRein;
    private final /* synthetic */ ModelRenderer frontRightLeg;
    private final /* synthetic */ ModelRenderer backRightHoof;
    private final /* synthetic */ ModelRenderer body;
    private final /* synthetic */ ModelRenderer backLeftShin;
    private final /* synthetic */ ModelRenderer horseRightFaceMetal;
    private final /* synthetic */ ModelRenderer backRightShin;
    private final /* synthetic */ ModelRenderer horseSaddleFront;
    private final /* synthetic */ ModelRenderer horseRightSaddleRope;
    private final /* synthetic */ ModelRenderer muleLeftChest;
    private final /* synthetic */ ModelRenderer neck;
    private final /* synthetic */ ModelRenderer upperMouth;
    private final /* synthetic */ ModelRenderer backLeftHoof;
    private final /* synthetic */ ModelRenderer horseLeftEar;
    private final /* synthetic */ ModelRenderer head;
    private final /* synthetic */ ModelRenderer muleRightEar;
    private final /* synthetic */ ModelRenderer horseRightEar;
    private final /* synthetic */ ModelRenderer frontLeftShin;
    private final /* synthetic */ ModelRenderer tailMiddle;
    private final /* synthetic */ ModelRenderer frontLeftHoof;
    private final /* synthetic */ ModelRenderer horseLeftSaddleMetal;
    private final /* synthetic */ ModelRenderer tailBase;
    private final /* synthetic */ ModelRenderer mane;
    private final /* synthetic */ ModelRenderer horseLeftFaceMetal;
    private final /* synthetic */ ModelRenderer muleLeftEar;
    private final /* synthetic */ ModelRenderer frontRightHoof;
    private final /* synthetic */ ModelRenderer horseRightRein;
    private final /* synthetic */ ModelRenderer muleRightChest;
    private final /* synthetic */ ModelRenderer horseRightSaddleMetal;
    private final /* synthetic */ ModelRenderer horseFaceRopes;
    private final /* synthetic */ ModelRenderer frontLeftLeg;
    private final /* synthetic */ ModelRenderer horseSaddleBottom;
    
    private float updateHorseRotation(final float lllllllllllIlIIlllllIIlIIlllllII, final float lllllllllllIlIIlllllIIlIIllllIll, final float lllllllllllIlIIlllllIIlIIllllllI) {
        float lllllllllllIlIIlllllIIlIIlllllIl;
        for (lllllllllllIlIIlllllIIlIIlllllIl = lllllllllllIlIIlllllIIlIIllllIll - lllllllllllIlIIlllllIIlIIlllllII; lllllllllllIlIIlllllIIlIIlllllIl < -180.0f; lllllllllllIlIIlllllIIlIIlllllIl += 360.0f) {}
        while (lllllllllllIlIIlllllIIlIIlllllIl >= 180.0f) {
            lllllllllllIlIIlllllIIlIIlllllIl -= 360.0f;
        }
        return lllllllllllIlIIlllllIIlIIlllllII + lllllllllllIlIIlllllIIlIIllllllI * lllllllllllIlIIlllllIIlIIlllllIl;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllIlIIlllllIIlIIlIIIlIl, final float lllllllllllIlIIlllllIIlIIlIIIlII, final float lllllllllllIlIIlllllIIlIIlIIIIll, final float lllllllllllIlIIlllllIIlIIlIllIll) {
        super.setLivingAnimations(lllllllllllIlIIlllllIIlIIlIIIlIl, lllllllllllIlIIlllllIIlIIlIIIlII, lllllllllllIlIIlllllIIlIIlIIIIll, lllllllllllIlIIlllllIIlIIlIllIll);
        final float lllllllllllIlIIlllllIIlIIlIllIlI = this.updateHorseRotation(lllllllllllIlIIlllllIIlIIlIIIlIl.prevRenderYawOffset, lllllllllllIlIIlllllIIlIIlIIIlIl.renderYawOffset, lllllllllllIlIIlllllIIlIIlIllIll);
        final float lllllllllllIlIIlllllIIlIIlIllIIl = this.updateHorseRotation(lllllllllllIlIIlllllIIlIIlIIIlIl.prevRotationYawHead, lllllllllllIlIIlllllIIlIIlIIIlIl.rotationYawHead, lllllllllllIlIIlllllIIlIIlIllIll);
        final float lllllllllllIlIIlllllIIlIIlIllIII = lllllllllllIlIIlllllIIlIIlIIIlIl.prevRotationPitch + (lllllllllllIlIIlllllIIlIIlIIIlIl.rotationPitch - lllllllllllIlIIlllllIIlIIlIIIlIl.prevRotationPitch) * lllllllllllIlIIlllllIIlIIlIllIll;
        float lllllllllllIlIIlllllIIlIIlIlIlll = lllllllllllIlIIlllllIIlIIlIllIIl - lllllllllllIlIIlllllIIlIIlIllIlI;
        float lllllllllllIlIIlllllIIlIIlIlIllI = lllllllllllIlIIlllllIIlIIlIllIII * 0.017453292f;
        if (lllllllllllIlIIlllllIIlIIlIlIlll > 20.0f) {
            lllllllllllIlIIlllllIIlIIlIlIlll = 20.0f;
        }
        if (lllllllllllIlIIlllllIIlIIlIlIlll < -20.0f) {
            lllllllllllIlIIlllllIIlIIlIlIlll = -20.0f;
        }
        if (lllllllllllIlIIlllllIIlIIlIIIIll > 0.2f) {
            lllllllllllIlIIlllllIIlIIlIlIllI += MathHelper.cos(lllllllllllIlIIlllllIIlIIlIIIlII * 0.4f) * 0.15f * lllllllllllIlIIlllllIIlIIlIIIIll;
        }
        final AbstractHorse lllllllllllIlIIlllllIIlIIlIlIlIl = (AbstractHorse)lllllllllllIlIIlllllIIlIIlIIIlIl;
        final float lllllllllllIlIIlllllIIlIIlIlIlII = lllllllllllIlIIlllllIIlIIlIlIlIl.getGrassEatingAmount(lllllllllllIlIIlllllIIlIIlIllIll);
        final float lllllllllllIlIIlllllIIlIIlIlIIll = lllllllllllIlIIlllllIIlIIlIlIlIl.getRearingAmount(lllllllllllIlIIlllllIIlIIlIllIll);
        final float lllllllllllIlIIlllllIIlIIlIlIIlI = 1.0f - lllllllllllIlIIlllllIIlIIlIlIIll;
        final float lllllllllllIlIIlllllIIlIIlIlIIIl = lllllllllllIlIIlllllIIlIIlIlIlIl.getMouthOpennessAngle(lllllllllllIlIIlllllIIlIIlIllIll);
        final boolean lllllllllllIlIIlllllIIlIIlIlIIII = lllllllllllIlIIlllllIIlIIlIlIlIl.tailCounter != 0;
        final boolean lllllllllllIlIIlllllIIlIIlIIllll = lllllllllllIlIIlllllIIlIIlIlIlIl.isHorseSaddled();
        final boolean lllllllllllIlIIlllllIIlIIlIIlllI = lllllllllllIlIIlllllIIlIIlIlIlIl.isBeingRidden();
        final float lllllllllllIlIIlllllIIlIIlIIllIl = lllllllllllIlIIlllllIIlIIlIIIlIl.ticksExisted + lllllllllllIlIIlllllIIlIIlIllIll;
        final float lllllllllllIlIIlllllIIlIIlIIllII = MathHelper.cos(lllllllllllIlIIlllllIIlIIlIIIlII * 0.6662f + 3.1415927f);
        final float lllllllllllIlIIlllllIIlIIlIIlIll = lllllllllllIlIIlllllIIlIIlIIllII * 0.8f * lllllllllllIlIIlllllIIlIIlIIIIll;
        this.head.rotationPointY = 4.0f;
        this.head.rotationPointZ = -10.0f;
        this.tailBase.rotationPointY = 3.0f;
        this.tailMiddle.rotationPointZ = 14.0f;
        this.muleRightChest.rotationPointY = 3.0f;
        this.muleRightChest.rotationPointZ = 10.0f;
        this.body.rotateAngleX = 0.0f;
        this.head.rotateAngleX = 0.5235988f + lllllllllllIlIIlllllIIlIIlIlIllI;
        this.head.rotateAngleY = lllllllllllIlIIlllllIIlIIlIlIlll * 0.017453292f;
        this.head.rotateAngleX = lllllllllllIlIIlllllIIlIIlIlIIll * (0.2617994f + lllllllllllIlIIlllllIIlIIlIlIllI) + lllllllllllIlIIlllllIIlIIlIlIlII * 2.1816616f + (1.0f - Math.max(lllllllllllIlIIlllllIIlIIlIlIIll, lllllllllllIlIIlllllIIlIIlIlIlII)) * this.head.rotateAngleX;
        this.head.rotateAngleY = lllllllllllIlIIlllllIIlIIlIlIIll * lllllllllllIlIIlllllIIlIIlIlIlll * 0.017453292f + (1.0f - Math.max(lllllllllllIlIIlllllIIlIIlIlIIll, lllllllllllIlIIlllllIIlIIlIlIlII)) * this.head.rotateAngleY;
        this.head.rotationPointY = lllllllllllIlIIlllllIIlIIlIlIIll * -6.0f + lllllllllllIlIIlllllIIlIIlIlIlII * 11.0f + (1.0f - Math.max(lllllllllllIlIIlllllIIlIIlIlIIll, lllllllllllIlIIlllllIIlIIlIlIlII)) * this.head.rotationPointY;
        this.head.rotationPointZ = lllllllllllIlIIlllllIIlIIlIlIIll * -1.0f + lllllllllllIlIIlllllIIlIIlIlIlII * -10.0f + (1.0f - Math.max(lllllllllllIlIIlllllIIlIIlIlIIll, lllllllllllIlIIlllllIIlIIlIlIlII)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = lllllllllllIlIIlllllIIlIIlIlIIll * 9.0f + lllllllllllIlIIlllllIIlIIlIlIIlI * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = lllllllllllIlIIlllllIIlIIlIlIIll * 18.0f + lllllllllllIlIIlllllIIlIIlIlIIlI * this.tailMiddle.rotationPointZ;
        this.muleRightChest.rotationPointY = lllllllllllIlIIlllllIIlIIlIlIIll * 5.5f + lllllllllllIlIIlllllIIlIIlIlIIlI * this.muleRightChest.rotationPointY;
        this.muleRightChest.rotationPointZ = lllllllllllIlIIlllllIIlIIlIlIIll * 15.0f + lllllllllllIlIIlllllIIlIIlIlIIlI * this.muleRightChest.rotationPointZ;
        this.body.rotateAngleX = lllllllllllIlIIlllllIIlIIlIlIIll * -0.7853982f + lllllllllllIlIIlllllIIlIIlIlIIlI * this.body.rotateAngleX;
        this.horseLeftEar.rotationPointY = this.head.rotationPointY;
        this.horseRightEar.rotationPointY = this.head.rotationPointY;
        this.muleLeftEar.rotationPointY = this.head.rotationPointY;
        this.muleRightEar.rotationPointY = this.head.rotationPointY;
        this.neck.rotationPointY = this.head.rotationPointY;
        this.upperMouth.rotationPointY = 0.02f;
        this.lowerMouth.rotationPointY = 0.0f;
        this.mane.rotationPointY = this.head.rotationPointY;
        this.horseLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.horseRightEar.rotationPointZ = this.head.rotationPointZ;
        this.muleLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.muleRightEar.rotationPointZ = this.head.rotationPointZ;
        this.neck.rotationPointZ = this.head.rotationPointZ;
        this.upperMouth.rotationPointZ = 0.02f - lllllllllllIlIIlllllIIlIIlIlIIIl;
        this.lowerMouth.rotationPointZ = lllllllllllIlIIlllllIIlIIlIlIIIl;
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.horseLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.horseRightEar.rotateAngleX = this.head.rotateAngleX;
        this.muleLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.muleRightEar.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.upperMouth.rotateAngleX = -0.09424778f * lllllllllllIlIIlllllIIlIIlIlIIIl;
        this.lowerMouth.rotateAngleX = 0.15707964f * lllllllllllIlIIlllllIIlIIlIlIIIl;
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.horseLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.horseRightEar.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.muleRightEar.rotateAngleY = this.head.rotateAngleY;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.upperMouth.rotateAngleY = 0.0f;
        this.lowerMouth.rotateAngleY = 0.0f;
        this.mane.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftChest.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
        this.muleRightChest.rotateAngleX = -lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
        float lllllllllllIlIIlllllIIlIIlIIlIlI = 0.2617994f * lllllllllllIlIIlllllIIlIIlIlIIll;
        final float lllllllllllIlIIlllllIIlIIlIIlIIl = MathHelper.cos(lllllllllllIlIIlllllIIlIIlIIllIl * 0.6f + 3.1415927f);
        this.frontLeftLeg.rotationPointY = -2.0f * lllllllllllIlIIlllllIIlIIlIlIIll + 9.0f * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.frontLeftLeg.rotationPointZ = -2.0f * lllllllllllIlIIlllllIIlIIlIlIIll + -8.0f * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIlI + lllllllllllIlIIlllllIIlIIlIlIIlI * -lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll) * 7.0f;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + MathHelper.cos(-1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIlI + lllllllllllIlIIlllllIIlIIlIlIIlI * -lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll) * 7.0f;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + MathHelper.sin(1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIlI + lllllllllllIlIIlllllIIlIIlIlIIlI * lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll) * 7.0f;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + MathHelper.cos(-1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIlI + lllllllllllIlIIlllllIIlIIlIlIIlI * lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll) * 7.0f;
        final float lllllllllllIlIIlllllIIlIIlIIlIII = (-1.0471976f + lllllllllllIlIIlllllIIlIIlIIlIIl) * lllllllllllIlIIlllllIIlIIlIlIIll + lllllllllllIlIIlllllIIlIIlIIlIll * lllllllllllIlIIlllllIIlIIlIlIIlI;
        final float lllllllllllIlIIlllllIIlIIlIIIlll = (-1.0471976f - lllllllllllIlIIlllllIIlIIlIIlIIl) * lllllllllllIlIIlllllIIlIIlIlIIll + -lllllllllllIlIIlllllIIlIIlIIlIll * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.frontLeftShin.rotationPointY = this.frontLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIII) * 7.0f;
        this.frontLeftShin.rotationPointZ = this.frontLeftLeg.rotationPointZ + MathHelper.cos(-1.5707964f + lllllllllllIlIIlllllIIlIIlIIlIII) * 7.0f;
        this.frontRightShin.rotationPointY = this.frontRightLeg.rotationPointY + MathHelper.sin(1.5707964f + lllllllllllIlIIlllllIIlIIlIIIlll) * 7.0f;
        this.frontRightShin.rotationPointZ = this.frontRightLeg.rotationPointZ + MathHelper.cos(-1.5707964f + lllllllllllIlIIlllllIIlIIlIIIlll) * 7.0f;
        this.backLeftLeg.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIlI + -lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.backLeftShin.rotateAngleX = -0.08726646f * lllllllllllIlIIlllllIIlIIlIlIIll + (-lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll - Math.max(0.0f, lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll)) * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX;
        this.backRightLeg.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIlI + lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.backRightShin.rotateAngleX = -0.08726646f * lllllllllllIlIIlllllIIlIIlIlIIll + (lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll - Math.max(0.0f, -lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll)) * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX;
        this.frontLeftLeg.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIII;
        this.frontLeftShin.rotateAngleX = (this.frontLeftLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f + lllllllllllIlIIlllllIIlIIlIIlIIl * 0.2f)) * lllllllllllIlIIlllllIIlIIlIlIIll + (lllllllllllIlIIlllllIIlIIlIIlIll + Math.max(0.0f, lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll)) * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX;
        this.frontRightLeg.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIIlll;
        this.frontRightShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f - lllllllllllIlIIlllllIIlIIlIIlIIl * 0.2f)) * lllllllllllIlIIlllllIIlIIlIlIIll + (-lllllllllllIlIIlllllIIlIIlIIlIll + Math.max(0.0f, -lllllllllllIlIIlllllIIlIIlIIllII * 0.5f * lllllllllllIlIIlllllIIlIIlIIIIll)) * lllllllllllIlIIlllllIIlIIlIlIIlI;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;
        if (lllllllllllIlIIlllllIIlIIlIIllll) {
            this.horseSaddleBottom.rotationPointY = lllllllllllIlIIlllllIIlIIlIlIIll * 0.5f + lllllllllllIlIIlllllIIlIIlIlIIlI * 2.0f;
            this.horseSaddleBottom.rotationPointZ = lllllllllllIlIIlllllIIlIIlIlIIll * 11.0f + lllllllllllIlIIlllllIIlIIlIlIIlI * 2.0f;
            this.horseSaddleFront.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseSaddleBack.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.muleLeftChest.rotationPointY = this.muleRightChest.rotationPointY;
            this.horseSaddleFront.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseSaddleBack.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.muleLeftChest.rotationPointZ = this.muleRightChest.rotationPointZ;
            this.horseSaddleBottom.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleFront.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleBack.rotateAngleX = this.body.rotateAngleX;
            this.horseLeftRein.rotationPointY = this.head.rotationPointY;
            this.horseRightRein.rotationPointY = this.head.rotationPointY;
            this.horseFaceRopes.rotationPointY = this.head.rotationPointY;
            this.horseLeftFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseRightFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseLeftRein.rotationPointZ = this.head.rotationPointZ;
            this.horseRightRein.rotationPointZ = this.head.rotationPointZ;
            this.horseFaceRopes.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseRightFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftRein.rotateAngleX = lllllllllllIlIIlllllIIlIIlIlIllI;
            this.horseRightRein.rotateAngleX = lllllllllllIlIIlllllIIlIIlIlIllI;
            this.horseFaceRopes.rotateAngleX = this.head.rotateAngleX;
            this.horseLeftFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseRightFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseFaceRopes.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftRein.rotateAngleY = this.head.rotateAngleY;
            this.horseRightFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseRightRein.rotateAngleY = this.head.rotateAngleY;
            if (lllllllllllIlIIlllllIIlIIlIIlllI) {
                this.horseLeftSaddleRope.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseRightSaddleRope.rotateAngleX = -1.0471976f;
                this.horseRightSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleRope.rotateAngleZ = 0.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = 0.0f;
                this.horseRightSaddleRope.rotateAngleZ = 0.0f;
                this.horseRightSaddleMetal.rotateAngleZ = 0.0f;
            }
            else {
                this.horseLeftSaddleRope.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIll / 3.0f;
                this.horseLeftSaddleMetal.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIll / 3.0f;
                this.horseRightSaddleRope.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIll / 3.0f;
                this.horseRightSaddleMetal.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIll / 3.0f;
                this.horseLeftSaddleRope.rotateAngleZ = lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
                this.horseRightSaddleRope.rotateAngleZ = -lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
                this.horseRightSaddleMetal.rotateAngleZ = -lllllllllllIlIIlllllIIlIIlIIlIll / 5.0f;
            }
        }
        lllllllllllIlIIlllllIIlIIlIIlIlI = -1.3089969f + lllllllllllIlIIlllllIIlIIlIIIIll * 1.5f;
        if (lllllllllllIlIIlllllIIlIIlIIlIlI > 0.0f) {
            lllllllllllIlIIlllllIIlIIlIIlIlI = 0.0f;
        }
        if (lllllllllllIlIIlllllIIlIIlIlIIII) {
            this.tailBase.rotateAngleY = MathHelper.cos(lllllllllllIlIIlllllIIlIIlIIllIl * 0.7f);
            lllllllllllIlIIlllllIIlIIlIIlIlI = 0.0f;
        }
        else {
            this.tailBase.rotateAngleY = 0.0f;
        }
        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIlI;
        this.tailMiddle.rotateAngleX = lllllllllllIlIIlllllIIlIIlIIlIlI;
        this.tailTip.rotateAngleX = -0.2617994f + lllllllllllIlIIlllllIIlIIlIIlIlI;
    }
    
    public ModelHorse() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.body.setRotationPoint(0.0f, 11.0f, 9.0f);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailBase.rotateAngleX = -1.134464f;
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailMiddle.rotateAngleX = -1.134464f;
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailTip.rotateAngleX = -1.3962634f;
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0f, 9.0f, 11.0f);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0f, 9.0f, 11.0f);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.frontLeftLeg = new ModelRenderer(this, 44, 29);
        this.frontLeftLeg.addBox(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.frontLeftLeg.setRotationPoint(4.0f, 9.0f, -8.0f);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontRightLeg = new ModelRenderer(this, 60, 29);
        this.frontRightLeg.addBox(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(-4.0f, 9.0f, -8.0f);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.head.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.head.rotateAngleX = 0.5235988f;
        this.upperMouth = new ModelRenderer(this, 24, 18);
        this.upperMouth.addBox(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.upperMouth.setRotationPoint(0.0f, 3.95f, -10.0f);
        this.upperMouth.rotateAngleX = 0.5235988f;
        this.lowerMouth = new ModelRenderer(this, 24, 27);
        this.lowerMouth.addBox(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.lowerMouth.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.lowerMouth.rotateAngleX = 0.5235988f;
        this.head.addChild(this.upperMouth);
        this.head.addChild(this.lowerMouth);
        this.horseLeftEar = new ModelRenderer(this, 0, 0);
        this.horseLeftEar.addBox(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseLeftEar.rotateAngleX = 0.5235988f;
        this.horseRightEar = new ModelRenderer(this, 0, 0);
        this.horseRightEar.addBox(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightEar.rotateAngleX = 0.5235988f;
        this.muleLeftEar = new ModelRenderer(this, 0, 12);
        this.muleLeftEar.addBox(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.muleLeftEar.rotateAngleX = 0.5235988f;
        this.muleLeftEar.rotateAngleZ = 0.2617994f;
        this.muleRightEar = new ModelRenderer(this, 0, 12);
        this.muleRightEar.addBox(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.muleRightEar.rotateAngleX = 0.5235988f;
        this.muleRightEar.rotateAngleZ = -0.2617994f;
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.neck.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.neck.rotateAngleX = 0.5235988f;
        this.muleLeftChest = new ModelRenderer(this, 0, 34);
        this.muleLeftChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleLeftChest.setRotationPoint(-7.5f, 3.0f, 10.0f);
        this.muleLeftChest.rotateAngleY = 1.5707964f;
        this.muleRightChest = new ModelRenderer(this, 0, 47);
        this.muleRightChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleRightChest.setRotationPoint(4.5f, 3.0f, 10.0f);
        this.muleRightChest.rotateAngleY = 1.5707964f;
        this.horseSaddleBottom = new ModelRenderer(this, 80, 0);
        this.horseSaddleBottom.addBox(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.horseSaddleBottom.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleFront = new ModelRenderer(this, 106, 9);
        this.horseSaddleFront.addBox(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.horseSaddleFront.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleBack = new ModelRenderer(this, 80, 9);
        this.horseSaddleBack.addBox(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.horseSaddleBack.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseLeftSaddleMetal = new ModelRenderer(this, 74, 0);
        this.horseLeftSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseLeftSaddleMetal.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseLeftSaddleRope = new ModelRenderer(this, 70, 0);
        this.horseLeftSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseLeftSaddleRope.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseRightSaddleMetal = new ModelRenderer(this, 74, 4);
        this.horseRightSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseRightSaddleMetal.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseRightSaddleRope = new ModelRenderer(this, 80, 0);
        this.horseRightSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseRightSaddleRope.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseLeftFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseLeftFaceMetal.addBox(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseLeftFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseLeftFaceMetal.rotateAngleX = 0.5235988f;
        this.horseRightFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseRightFaceMetal.addBox(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseRightFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightFaceMetal.rotateAngleX = 0.5235988f;
        this.horseLeftRein = new ModelRenderer(this, 44, 10);
        this.horseLeftRein.addBox(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseLeftRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightRein = new ModelRenderer(this, 44, 5);
        this.horseRightRein.addBox(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseRightRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.mane.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane.rotateAngleX = 0.5235988f;
        this.horseFaceRopes = new ModelRenderer(this, 80, 12);
        this.horseFaceRopes.addBox(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.horseFaceRopes.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseFaceRopes.rotateAngleX = 0.5235988f;
    }
    
    @Override
    public void render(final Entity lllllllllllIlIIlllllIIlIlIlIIIIl, final float lllllllllllIlIIlllllIIlIlIlIIIII, final float lllllllllllIlIIlllllIIlIlIIlllll, final float lllllllllllIlIIlllllIIlIlIIllllI, final float lllllllllllIlIIlllllIIlIlIIlllIl, final float lllllllllllIlIIlllllIIlIlIIlllII, final float lllllllllllIlIIlllllIIlIlIIllIll) {
        final AbstractHorse lllllllllllIlIIlllllIIlIlIIllIlI = (AbstractHorse)lllllllllllIlIIlllllIIlIlIlIIIIl;
        final float lllllllllllIlIIlllllIIlIlIIllIIl = lllllllllllIlIIlllllIIlIlIIllIlI.getGrassEatingAmount(0.0f);
        final boolean lllllllllllIlIIlllllIIlIlIIllIII = lllllllllllIlIIlllllIIlIlIIllIlI.isChild();
        final boolean lllllllllllIlIIlllllIIlIlIIlIlll = !lllllllllllIlIIlllllIIlIlIIllIII && lllllllllllIlIIlllllIIlIlIIllIlI.isHorseSaddled();
        final boolean lllllllllllIlIIlllllIIlIlIIlIllI = lllllllllllIlIIlllllIIlIlIIllIlI instanceof AbstractChestHorse;
        final boolean lllllllllllIlIIlllllIIlIlIIlIlIl = !lllllllllllIlIIlllllIIlIlIIllIII && lllllllllllIlIIlllllIIlIlIIlIllI && ((AbstractChestHorse)lllllllllllIlIIlllllIIlIlIIllIlI).func_190695_dh();
        final float lllllllllllIlIIlllllIIlIlIIlIlII = lllllllllllIlIIlllllIIlIlIIllIlI.getHorseSize();
        final boolean lllllllllllIlIIlllllIIlIlIIlIIll = lllllllllllIlIIlllllIIlIlIIllIlI.isBeingRidden();
        if (lllllllllllIlIIlllllIIlIlIIlIlll) {
            this.horseFaceRopes.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseSaddleBottom.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseSaddleFront.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseSaddleBack.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseLeftSaddleRope.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseLeftSaddleMetal.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseRightSaddleRope.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseRightSaddleMetal.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseLeftFaceMetal.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseRightFaceMetal.render(lllllllllllIlIIlllllIIlIlIIllIll);
            if (lllllllllllIlIIlllllIIlIlIIlIIll) {
                this.horseLeftRein.render(lllllllllllIlIIlllllIIlIlIIllIll);
                this.horseRightRein.render(lllllllllllIlIIlllllIIlIlIIllIll);
            }
        }
        if (lllllllllllIlIIlllllIIlIlIIllIII) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(lllllllllllIlIIlllllIIlIlIIlIlII, 0.5f + lllllllllllIlIIlllllIIlIlIIlIlII * 0.5f, lllllllllllIlIIlllllIIlIlIIlIlII);
            GlStateManager.translate(0.0f, 0.95f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII), 0.0f);
        }
        this.backLeftLeg.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.backLeftShin.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.backLeftHoof.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.backRightLeg.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.backRightShin.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.backRightHoof.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontLeftLeg.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontLeftShin.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontLeftHoof.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontRightLeg.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontRightShin.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.frontRightHoof.render(lllllllllllIlIIlllllIIlIlIIllIll);
        if (lllllllllllIlIIlllllIIlIlIIllIII) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(lllllllllllIlIIlllllIIlIlIIlIlII, lllllllllllIlIIlllllIIlIlIIlIlII, lllllllllllIlIIlllllIIlIlIIlIlII);
            GlStateManager.translate(0.0f, 1.35f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII), 0.0f);
        }
        this.body.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.tailBase.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.tailMiddle.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.tailTip.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.neck.render(lllllllllllIlIIlllllIIlIlIIllIll);
        this.mane.render(lllllllllllIlIIlllllIIlIlIIllIll);
        if (lllllllllllIlIIlllllIIlIlIIllIII) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            final float lllllllllllIlIIlllllIIlIlIIlIIlI = 0.5f + lllllllllllIlIIlllllIIlIlIIlIlII * lllllllllllIlIIlllllIIlIlIIlIlII * 0.5f;
            GlStateManager.scale(lllllllllllIlIIlllllIIlIlIIlIIlI, lllllllllllIlIIlllllIIlIlIIlIIlI, lllllllllllIlIIlllllIIlIlIIlIIlI);
            if (lllllllllllIlIIlllllIIlIlIIllIIl <= 0.0f) {
                GlStateManager.translate(0.0f, 1.35f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII), 0.0f);
            }
            else {
                GlStateManager.translate(0.0f, 0.9f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII) * lllllllllllIlIIlllllIIlIlIIllIIl + 1.35f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII) * (1.0f - lllllllllllIlIIlllllIIlIlIIllIIl), 0.15f * (1.0f - lllllllllllIlIIlllllIIlIlIIlIlII) * lllllllllllIlIIlllllIIlIlIIllIIl);
            }
        }
        if (lllllllllllIlIIlllllIIlIlIIlIllI) {
            this.muleLeftEar.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.muleRightEar.render(lllllllllllIlIIlllllIIlIlIIllIll);
        }
        else {
            this.horseLeftEar.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.horseRightEar.render(lllllllllllIlIIlllllIIlIlIIllIll);
        }
        this.head.render(lllllllllllIlIIlllllIIlIlIIllIll);
        if (lllllllllllIlIIlllllIIlIlIIllIII) {
            GlStateManager.popMatrix();
        }
        if (lllllllllllIlIIlllllIIlIlIIlIlIl) {
            this.muleLeftChest.render(lllllllllllIlIIlllllIIlIlIIllIll);
            this.muleRightChest.render(lllllllllllIlIIlllllIIlIlIIllIll);
        }
    }
}
