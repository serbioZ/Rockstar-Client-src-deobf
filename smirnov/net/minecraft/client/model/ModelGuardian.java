// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.Entity;

public class ModelGuardian extends ModelBase
{
    private final /* synthetic */ ModelRenderer[] guardianTail;
    private final /* synthetic */ ModelRenderer guardianEye;
    private final /* synthetic */ ModelRenderer guardianBody;
    private final /* synthetic */ ModelRenderer[] guardianSpines;
    
    @Override
    public void render(final Entity lllllllllllllllIIlIlIIIIIlllIIIl, final float lllllllllllllllIIlIlIIIIIllIlIII, final float lllllllllllllllIIlIlIIIIIllIIlll, final float lllllllllllllllIIlIlIIIIIllIIllI, final float lllllllllllllllIIlIlIIIIIllIllIl, final float lllllllllllllllIIlIlIIIIIllIIlII, final float lllllllllllllllIIlIlIIIIIllIIIll) {
        this.setRotationAngles(lllllllllllllllIIlIlIIIIIllIlIII, lllllllllllllllIIlIlIIIIIllIIlll, lllllllllllllllIIlIlIIIIIllIIllI, lllllllllllllllIIlIlIIIIIllIllIl, lllllllllllllllIIlIlIIIIIllIIlII, lllllllllllllllIIlIlIIIIIllIIIll, lllllllllllllllIIlIlIIIIIlllIIIl);
        this.guardianBody.render(lllllllllllllllIIlIlIIIIIllIIIll);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIlIlIIIIIlIIllII, final float lllllllllllllllIIlIlIIIIIlIIlIll, final float lllllllllllllllIIlIlIIIIIlIIlIlI, final float lllllllllllllllIIlIlIIIIIlIIlIIl, final float lllllllllllllllIIlIlIIIIIlIIlIII, final float lllllllllllllllIIlIlIIIIIlIIIlll, final Entity lllllllllllllllIIlIlIIIIIIlIllll) {
        final EntityGuardian lllllllllllllllIIlIlIIIIIlIIIlIl = (EntityGuardian)lllllllllllllllIIlIlIIIIIIlIllll;
        final float lllllllllllllllIIlIlIIIIIlIIIlII = lllllllllllllllIIlIlIIIIIlIIlIlI - lllllllllllllllIIlIlIIIIIlIIIlIl.ticksExisted;
        this.guardianBody.rotateAngleY = lllllllllllllllIIlIlIIIIIlIIlIIl * 0.017453292f;
        this.guardianBody.rotateAngleX = lllllllllllllllIIlIlIIIIIlIIlIII * 0.017453292f;
        final float[] lllllllllllllllIIlIlIIIIIlIIIIll = { 1.75f, 0.25f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 1.25f, 0.75f, 0.0f, 0.0f };
        final float[] lllllllllllllllIIlIlIIIIIlIIIIlI = { 0.0f, 0.0f, 0.0f, 0.0f, 0.25f, 1.75f, 1.25f, 0.75f, 0.0f, 0.0f, 0.0f, 0.0f };
        final float[] lllllllllllllllIIlIlIIIIIlIIIIIl = { 0.0f, 0.0f, 0.25f, 1.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.75f, 1.25f };
        final float[] lllllllllllllllIIlIlIIIIIlIIIIII = { 0.0f, 0.0f, 8.0f, -8.0f, -8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f, 8.0f, -8.0f };
        final float[] lllllllllllllllIIlIlIIIIIIllllll = { -8.0f, -8.0f, -8.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 8.0f, 8.0f, 8.0f };
        final float[] lllllllllllllllIIlIlIIIIIIlllllI = { 8.0f, -8.0f, 0.0f, 0.0f, -8.0f, -8.0f, 8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f };
        final float lllllllllllllllIIlIlIIIIIIllllIl = (1.0f - lllllllllllllllIIlIlIIIIIlIIIlIl.getSpikesAnimation(lllllllllllllllIIlIlIIIIIlIIIlII)) * 0.55f;
        for (int lllllllllllllllIIlIlIIIIIIllllII = 0; lllllllllllllllIIlIlIIIIIIllllII < 12; ++lllllllllllllllIIlIlIIIIIIllllII) {
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotateAngleX = 3.1415927f * lllllllllllllllIIlIlIIIIIlIIIIll[lllllllllllllllIIlIlIIIIIIllllII];
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotateAngleY = 3.1415927f * lllllllllllllllIIlIlIIIIIlIIIIlI[lllllllllllllllIIlIlIIIIIIllllII];
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotateAngleZ = 3.1415927f * lllllllllllllllIIlIlIIIIIlIIIIIl[lllllllllllllllIIlIlIIIIIIllllII];
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotationPointX = lllllllllllllllIIlIlIIIIIlIIIIII[lllllllllllllllIIlIlIIIIIIllllII] * (1.0f + MathHelper.cos(lllllllllllllllIIlIlIIIIIlIIlIlI * 1.5f + lllllllllllllllIIlIlIIIIIIllllII) * 0.01f - lllllllllllllllIIlIlIIIIIIllllIl);
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotationPointY = 16.0f + lllllllllllllllIIlIlIIIIIIllllll[lllllllllllllllIIlIlIIIIIIllllII] * (1.0f + MathHelper.cos(lllllllllllllllIIlIlIIIIIlIIlIlI * 1.5f + lllllllllllllllIIlIlIIIIIIllllII) * 0.01f - lllllllllllllllIIlIlIIIIIIllllIl);
            this.guardianSpines[lllllllllllllllIIlIlIIIIIIllllII].rotationPointZ = lllllllllllllllIIlIlIIIIIIlllllI[lllllllllllllllIIlIlIIIIIIllllII] * (1.0f + MathHelper.cos(lllllllllllllllIIlIlIIIIIlIIlIlI * 1.5f + lllllllllllllllIIlIlIIIIIIllllII) * 0.01f - lllllllllllllllIIlIlIIIIIIllllIl);
        }
        this.guardianEye.rotationPointZ = -8.25f;
        Entity lllllllllllllllIIlIlIIIIIIlllIll = Minecraft.getMinecraft().getRenderViewEntity();
        if (lllllllllllllllIIlIlIIIIIlIIIlIl.hasTargetedEntity()) {
            lllllllllllllllIIlIlIIIIIIlllIll = lllllllllllllllIIlIlIIIIIlIIIlIl.getTargetedEntity();
        }
        if (lllllllllllllllIIlIlIIIIIIlllIll != null) {
            final Vec3d lllllllllllllllIIlIlIIIIIIlllIlI = lllllllllllllllIIlIlIIIIIIlllIll.getPositionEyes(0.0f);
            final Vec3d lllllllllllllllIIlIlIIIIIIlllIIl = lllllllllllllllIIlIlIIIIIIlIllll.getPositionEyes(0.0f);
            final double lllllllllllllllIIlIlIIIIIIlllIII = lllllllllllllllIIlIlIIIIIIlllIlI.yCoord - lllllllllllllllIIlIlIIIIIIlllIIl.yCoord;
            if (lllllllllllllllIIlIlIIIIIIlllIII > 0.0) {
                this.guardianEye.rotationPointY = 0.0f;
            }
            else {
                this.guardianEye.rotationPointY = 1.0f;
            }
            Vec3d lllllllllllllllIIlIlIIIIIIllIlll = lllllllllllllllIIlIlIIIIIIlIllll.getLook(0.0f);
            lllllllllllllllIIlIlIIIIIIllIlll = new Vec3d(lllllllllllllllIIlIlIIIIIIllIlll.xCoord, 0.0, lllllllllllllllIIlIlIIIIIIllIlll.zCoord);
            final Vec3d lllllllllllllllIIlIlIIIIIIllIllI = new Vec3d(lllllllllllllllIIlIlIIIIIIlllIIl.xCoord - lllllllllllllllIIlIlIIIIIIlllIlI.xCoord, 0.0, lllllllllllllllIIlIlIIIIIIlllIIl.zCoord - lllllllllllllllIIlIlIIIIIIlllIlI.zCoord).normalize().rotateYaw(1.5707964f);
            final double lllllllllllllllIIlIlIIIIIIllIlIl = lllllllllllllllIIlIlIIIIIIllIlll.dotProduct(lllllllllllllllIIlIlIIIIIIllIllI);
            this.guardianEye.rotationPointX = MathHelper.sqrt((float)Math.abs(lllllllllllllllIIlIlIIIIIIllIlIl)) * 2.0f * (float)Math.signum(lllllllllllllllIIlIlIIIIIIllIlIl);
        }
        this.guardianEye.showModel = true;
        final float lllllllllllllllIIlIlIIIIIIllIlII = lllllllllllllllIIlIlIIIIIlIIIlIl.getTailAnimation(lllllllllllllllIIlIlIIIIIlIIIlII);
        this.guardianTail[0].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIlIIIIIIllIlII) * 3.1415927f * 0.05f;
        this.guardianTail[1].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIlIIIIIIllIlII) * 3.1415927f * 0.1f;
        this.guardianTail[1].rotationPointX = -1.5f;
        this.guardianTail[1].rotationPointY = 0.5f;
        this.guardianTail[1].rotationPointZ = 14.0f;
        this.guardianTail[2].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIlIIIIIIllIlII) * 3.1415927f * 0.15f;
        this.guardianTail[2].rotationPointX = 0.5f;
        this.guardianTail[2].rotationPointY = 0.5f;
        this.guardianTail[2].rotationPointZ = 6.0f;
    }
    
    public ModelGuardian() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.guardianSpines = new ModelRenderer[12];
        this.guardianBody = new ModelRenderer(this);
        this.guardianBody.setTextureOffset(0, 0).addBox(-6.0f, 10.0f, -8.0f, 12, 12, 16);
        this.guardianBody.setTextureOffset(0, 28).addBox(-8.0f, 10.0f, -6.0f, 2, 12, 12);
        this.guardianBody.setTextureOffset(0, 28).addBox(6.0f, 10.0f, -6.0f, 2, 12, 12, true);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 8.0f, -6.0f, 12, 2, 12);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 22.0f, -6.0f, 12, 2, 12);
        for (int lllllllllllllllIIlIlIIIIIlllllIl = 0; lllllllllllllllIIlIlIIIIIlllllIl < this.guardianSpines.length; ++lllllllllllllllIIlIlIIIIIlllllIl) {
            (this.guardianSpines[lllllllllllllllIIlIlIIIIIlllllIl] = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -4.5f, -1.0f, 2, 9, 2);
            this.guardianBody.addChild(this.guardianSpines[lllllllllllllllIIlIlIIIIIlllllIl]);
        }
        this.guardianEye = new ModelRenderer(this, 8, 0);
        this.guardianEye.addBox(-1.0f, 15.0f, 0.0f, 2, 2, 1);
        this.guardianBody.addChild(this.guardianEye);
        this.guardianTail = new ModelRenderer[3];
        (this.guardianTail[0] = new ModelRenderer(this, 40, 0)).addBox(-2.0f, 14.0f, 7.0f, 4, 4, 8);
        (this.guardianTail[1] = new ModelRenderer(this, 0, 54)).addBox(0.0f, 14.0f, 0.0f, 3, 3, 7);
        this.guardianTail[2] = new ModelRenderer(this);
        this.guardianTail[2].setTextureOffset(41, 32).addBox(0.0f, 14.0f, 0.0f, 2, 2, 6);
        this.guardianTail[2].setTextureOffset(25, 19).addBox(1.0f, 10.5f, 3.0f, 1, 9, 9);
        this.guardianBody.addChild(this.guardianTail[0]);
        this.guardianTail[0].addChild(this.guardianTail[1]);
        this.guardianTail[1].addChild(this.guardianTail[2]);
    }
}
