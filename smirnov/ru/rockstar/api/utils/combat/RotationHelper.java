// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.client.CPacketAnimation;
import ru.rockstar.api.event.event.EventSendPacket;
import net.minecraft.util.math.RayTraceResult;
import ru.rockstar.api.utils.math.RandomHelper;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.client.features.impl.combat.KillAura;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.utils.math.MathematicHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

public class RotationHelper
{
    private static /* synthetic */ Minecraft mc;
    
    public static float getAngleEntity(final Entity lllllllllllIIIIIIlIIllllllllIIIl) {
        return getYawBetween(RotationHelper.mc.player.rotationYaw, RotationHelper.mc.player.posX, RotationHelper.mc.player.posZ, lllllllllllIIIIIIlIIllllllllIIIl.posX, lllllllllllIIIIIIlIIllllllllIIIl.posZ);
    }
    
    public static double angleDifference(final double lllllllllllIIIIIIlIIlllIIIlIlIIl, final double lllllllllllIIIIIIlIIlllIIIlIlIII) {
        float lllllllllllIIIIIIlIIlllIIIlIlIlI = (float)(Math.abs(lllllllllllIIIIIIlIIlllIIIlIlIIl - lllllllllllIIIIIIlIIlllIIIlIlIII) % 360.0);
        if (lllllllllllIIIIIIlIIlllIIIlIlIlI > 180.0f) {
            lllllllllllIIIIIIlIIlllIIIlIlIlI = 360.0f - lllllllllllIIIIIIlIIlllIIIlIlIlI;
        }
        return lllllllllllIIIIIIlIIlllIIIlIlIlI;
    }
    
    public static float[] getRotationVector(final Vec3d lllllllllllIIIIIIlIIllllllIIlIIl, final boolean lllllllllllIIIIIIlIIllllllIIlIII, final float lllllllllllIIIIIIlIIllllllIIIlll, final float lllllllllllIIIIIIlIIllllllIIIllI, final float lllllllllllIIIIIIlIIlllllIllIlll) {
        final Vec3d lllllllllllIIIIIIlIIllllllIIIlII = getEyesPos();
        final double lllllllllllIIIIIIlIIllllllIIIIll = lllllllllllIIIIIIlIIllllllIIlIIl.xCoord - lllllllllllIIIIIIlIIllllllIIIlII.xCoord;
        final double lllllllllllIIIIIIlIIllllllIIIIlI = lllllllllllIIIIIIlIIllllllIIlIIl.yCoord - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight() + 0.5);
        final double lllllllllllIIIIIIlIIllllllIIIIIl = lllllllllllIIIIIIlIIllllllIIlIIl.zCoord - lllllllllllIIIIIIlIIllllllIIIlII.zCoord;
        final double lllllllllllIIIIIIlIIllllllIIIIII = Math.sqrt(lllllllllllIIIIIIlIIllllllIIIIll * lllllllllllIIIIIIlIIllllllIIIIll + lllllllllllIIIIIIlIIllllllIIIIIl * lllllllllllIIIIIIlIIllllllIIIIIl);
        float lllllllllllIIIIIIlIIlllllIllllll = 0.0f;
        if (lllllllllllIIIIIIlIIllllllIIlIII) {
            lllllllllllIIIIIIlIIlllllIllllll = MathematicHelper.randomizeFloat(-lllllllllllIIIIIIlIIllllllIIIlll, lllllllllllIIIIIIlIIllllllIIIlll);
        }
        float lllllllllllIIIIIIlIIlllllIlllllI = 0.0f;
        if (lllllllllllIIIIIIlIIllllllIIlIII) {
            lllllllllllIIIIIIlIIlllllIlllllI = MathematicHelper.randomizeFloat(-lllllllllllIIIIIIlIIllllllIIIllI, lllllllllllIIIIIIlIIllllllIIIllI);
        }
        float lllllllllllIIIIIIlIIlllllIllllIl = (float)(Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIllllllIIIIIl, lllllllllllIIIIIIlIIllllllIIIIll)) - 90.0) + lllllllllllIIIIIIlIIlllllIllllll;
        float lllllllllllIIIIIIlIIlllllIllllII = (float)(-Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIllllllIIIIlI, lllllllllllIIIIIIlIIllllllIIIIII))) + lllllllllllIIIIIIlIIlllllIlllllI;
        lllllllllllIIIIIIlIIlllllIllllIl = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllllIllllIl - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIlllllIllllII = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllllIllllII - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIlllllIllllII = MathHelper.clamp(lllllllllllIIIIIIlIIlllllIllllII, -90.0f, 90.0f);
        lllllllllllIIIIIIlIIlllllIllllIl = updateRotation(RotationHelper.mc.player.rotationYaw, lllllllllllIIIIIIlIIlllllIllllIl, lllllllllllIIIIIIlIIlllllIllIlll);
        lllllllllllIIIIIIlIIlllllIllllII = updateRotation(RotationHelper.mc.player.rotationPitch, lllllllllllIIIIIIlIIlllllIllllII, lllllllllllIIIIIIlIIlllllIllIlll);
        return new float[] { lllllllllllIIIIIIlIIlllllIllllIl, lllllllllllIIIIIIlIIlllllIllllII };
    }
    
    public static float getYawToEntity(final Entity lllllllllllIIIIIIlIIlllIlIlIllIl, final Entity lllllllllllIIIIIIlIIlllIlIlIIIll) {
        final double lllllllllllIIIIIIlIIlllIlIlIlIll = lllllllllllIIIIIIlIIlllIlIlIllIl.posX;
        final double lllllllllllIIIIIIlIIlllIlIlIlIlI = lllllllllllIIIIIIlIIlllIlIlIllIl.posZ;
        final double lllllllllllIIIIIIlIIlllIlIlIlIIl = lllllllllllIIIIIIlIIlllIlIlIIIll.posX;
        final double lllllllllllIIIIIIlIIlllIlIlIlIII = lllllllllllIIIIIIlIIlllIlIlIIIll.posZ;
        final double lllllllllllIIIIIIlIIlllIlIlIIlll = lllllllllllIIIIIIlIIlllIlIlIlIll - lllllllllllIIIIIIlIIlllIlIlIlIIl;
        final double lllllllllllIIIIIIlIIlllIlIlIIllI = lllllllllllIIIIIIlIIlllIlIlIlIlI - lllllllllllIIIIIIlIIlllIlIlIlIII;
        final double lllllllllllIIIIIIlIIlllIlIlIIlIl = Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIlIlIIllI, lllllllllllIIIIIIlIIlllIlIlIIlll)) + 90.0;
        return (float)lllllllllllIIIIIIlIIlllIlIlIIlIl;
    }
    
    public static float updateRotation(final float lllllllllllIIIIIIlIIllllIIllIlII, final float lllllllllllIIIIIIlIIllllIIllIlll, final float lllllllllllIIIIIIlIIllllIIllIIlI) {
        float lllllllllllIIIIIIlIIllllIIllIlIl = MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIIllIlll - lllllllllllIIIIIIlIIllllIIllIlII);
        if (lllllllllllIIIIIIlIIllllIIllIlIl > lllllllllllIIIIIIlIIllllIIllIIlI) {
            lllllllllllIIIIIIlIIllllIIllIlIl = lllllllllllIIIIIIlIIllllIIllIIlI;
        }
        if (lllllllllllIIIIIIlIIllllIIllIlIl < -lllllllllllIIIIIIlIIllllIIllIIlI) {
            lllllllllllIIIIIIlIIllllIIllIlIl = -lllllllllllIIIIIIlIIllllIIllIIlI;
        }
        return lllllllllllIIIIIIlIIllllIIllIlII + lllllllllllIIIIIIlIIllllIIllIlIl;
    }
    
    public static float[] getAACRotation(final Entity lllllllllllIIIIIIlIIlllIIllIllIl, final boolean lllllllllllIIIIIIlIIlllIIllIllII, final float lllllllllllIIIIIIlIIlllIIllIlIll, final float lllllllllllIIIIIIlIIlllIIllllIII, final float lllllllllllIIIIIIlIIlllIIllIlIIl, final float lllllllllllIIIIIIlIIlllIIlllIllI) {
        final double lllllllllllIIIIIIlIIlllIIlllIlIl = lllllllllllIIIIIIlIIlllIIllIllIl.posX + (lllllllllllIIIIIIlIIlllIIllIllIl.posX - lllllllllllIIIIIIlIIlllIIllIllIl.prevPosX) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posX - RotationHelper.mc.player.motionX * KillAura.rotPredict.getNumberValue();
        final double lllllllllllIIIIIIlIIlllIIlllIlII = lllllllllllIIIIIIlIIlllIIllIllIl.posZ + (lllllllllllIIIIIIlIIlllIIllIllIl.posZ - lllllllllllIIIIIIlIIlllIIllIllIl.prevPosZ) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posZ - RotationHelper.mc.player.motionZ * KillAura.rotPredict.getNumberValue();
        final double lllllllllllIIIIIIlIIlllIIlllIIll = lllllllllllIIIIIIlIIlllIIllIllIl.posY + lllllllllllIIIIIIlIIlllIIllIllIl.getEyeHeight() - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight()) - 0.16 - ((KillAura.walls.getBoolValue() && !((EntityLivingBase)lllllllllllIIIIIIlIIlllIIllIllIl).canEntityBeSeen(RotationHelper.mc.player)) ? -0.38 : 0.0);
        float lllllllllllIIIIIIlIIlllIIlllIIlI = 0.0f;
        if (lllllllllllIIIIIIlIIlllIIllIllII) {
            lllllllllllIIIIIIlIIlllIIlllIIlI = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllIIllIlIIl, -lllllllllllIIIIIIlIIlllIIllIlIIl);
        }
        float lllllllllllIIIIIIlIIlllIIlllIIIl = 0.0f;
        if (lllllllllllIIIIIIlIIlllIIllIllII) {
            lllllllllllIIIIIIlIIlllIIlllIIIl = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllIIlllIllI, -lllllllllllIIIIIIlIIlllIIlllIllI);
        }
        final double lllllllllllIIIIIIlIIlllIIlllIIII = MathHelper.sqrt(lllllllllllIIIIIIlIIlllIIlllIlIl * lllllllllllIIIIIIlIIlllIIlllIlIl + lllllllllllIIIIIIlIIlllIIlllIlII * lllllllllllIIIIIIlIIlllIIlllIlII);
        float lllllllllllIIIIIIlIIlllIIllIllll = (float)(Math.atan2(lllllllllllIIIIIIlIIlllIIlllIlII, lllllllllllIIIIIIlIIlllIIlllIlIl) * 180.0 / 3.141592653589793 - 90.0) + lllllllllllIIIIIIlIIlllIIlllIIlI;
        float lllllllllllIIIIIIlIIlllIIllIlllI = (float)(-(Math.atan2(lllllllllllIIIIIIlIIlllIIlllIIll, lllllllllllIIIIIIlIIlllIIlllIIII) * 180.0 / 3.141592653589793)) + lllllllllllIIIIIIlIIlllIIlllIIIl;
        lllllllllllIIIIIIlIIlllIIllIllll = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllIIllIllll - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIlllIIllIlllI = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllIIllIlllI - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIlllIIllIlllI = MathHelper.clamp(lllllllllllIIIIIIlIIlllIIllIlllI, -90.0f, 90.0f);
        lllllllllllIIIIIIlIIlllIIllIllll = updateRotation(RotationHelper.mc.player.rotationYaw, lllllllllllIIIIIIlIIlllIIllIllll, MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllIIllllIII, lllllllllllIIIIIIlIIlllIIllIlIll));
        lllllllllllIIIIIIlIIlllIIllIlllI = updateRotation(RotationHelper.mc.player.rotationPitch, lllllllllllIIIIIIlIIlllIIllIlllI, MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllIIllllIII, lllllllllllIIIIIIlIIlllIIllIlIll));
        return new float[] { lllllllllllIIIIIIlIIlllIIllIllll, lllllllllllIIIIIIlIIlllIIllIlllI };
    }
    
    public static float[] getMatrixRotations(final Entity lllllllllllIIIIIIlIIllllIlllIllI, final boolean lllllllllllIIIIIIlIIllllIlllIlIl, final float lllllllllllIIIIIIlIIllllIllIIlll, final float lllllllllllIIIIIIlIIllllIlllIIll) {
        final double lllllllllllIIIIIIlIIllllIlllIIlI = lllllllllllIIIIIIlIIllllIlllIllI.posX + (lllllllllllIIIIIIlIIllllIlllIllI.posX - lllllllllllIIIIIIlIIllllIlllIllI.prevPosX) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posX - RotationHelper.mc.player.motionX * KillAura.rotPredict.getNumberValue();
        final double lllllllllllIIIIIIlIIllllIlllIIIl = lllllllllllIIIIIIlIIllllIlllIllI.posZ + (lllllllllllIIIIIIlIIllllIlllIllI.posZ - lllllllllllIIIIIIlIIllllIlllIllI.prevPosZ) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posZ - RotationHelper.mc.player.motionZ * KillAura.rotPredict.getNumberValue();
        double lllllllllllIIIIIIlIIllllIllIllll = 0.0;
        if (lllllllllllIIIIIIlIIllllIlllIllI instanceof EntityLivingBase) {
            final double lllllllllllIIIIIIlIIllllIlllIIII = lllllllllllIIIIIIlIIllllIlllIllI.posY + lllllllllllIIIIIIlIIllllIlllIllI.getEyeHeight() - 0.2 - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight()) - ((KillAura.walls.getBoolValue() && !((EntityLivingBase)lllllllllllIIIIIIlIIllllIlllIllI).canEntityBeSeen(RotationHelper.mc.player)) ? -0.38 : 0.0);
        }
        else {
            lllllllllllIIIIIIlIIllllIllIllll = (lllllllllllIIIIIIlIIllllIlllIllI.getEntityBoundingBox().minY + lllllllllllIIIIIIlIIllllIlllIllI.getEntityBoundingBox().maxY) / 2.0 - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight());
        }
        float lllllllllllIIIIIIlIIllllIllIlllI = 0.0f;
        if (lllllllllllIIIIIIlIIllllIlllIlIl) {
            lllllllllllIIIIIIlIIllllIllIlllI = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIllllIllIIlll, -lllllllllllIIIIIIlIIllllIllIIlll);
        }
        float lllllllllllIIIIIIlIIllllIllIllIl = 0.0f;
        if (lllllllllllIIIIIIlIIllllIlllIlIl) {
            lllllllllllIIIIIIlIIllllIllIllIl = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIllllIlllIIll, -lllllllllllIIIIIIlIIllllIlllIIll);
        }
        final double lllllllllllIIIIIIlIIllllIllIllII = MathHelper.sqrt(lllllllllllIIIIIIlIIllllIlllIIlI * lllllllllllIIIIIIlIIllllIlllIIlI + lllllllllllIIIIIIlIIllllIlllIIIl * lllllllllllIIIIIIlIIllllIlllIIIl);
        lllllllllllIIIIIIlIIllllIllIllll /= lllllllllllIIIIIIlIIllllIllIllII;
        float lllllllllllIIIIIIlIIllllIllIlIll = (float)(Math.atan2(lllllllllllIIIIIIlIIllllIlllIIIl, lllllllllllIIIIIIlIIllllIlllIIlI) * 180.0 / 3.141592653589793 - 90.0) + lllllllllllIIIIIIlIIllllIllIlllI;
        float lllllllllllIIIIIIlIIllllIllIlIlI = (float)(-(Math.atan2(lllllllllllIIIIIIlIIllllIllIllll, lllllllllllIIIIIIlIIllllIllIllII) * 180.0 / 3.141592653589793)) + lllllllllllIIIIIIlIIllllIllIllIl;
        lllllllllllIIIIIIlIIllllIllIlIll = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIllIlIll - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIllllIllIlIlI = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIllIlIlI - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIllllIllIlIlI = MathHelper.clamp(lllllllllllIIIIIIlIIllllIllIlIlI, -90.0f, 90.0f);
        return new float[] { lllllllllllIIIIIIlIIllllIllIlIll, lllllllllllIIIIIIlIIllllIllIlIlI };
    }
    
    static {
        RotationHelper.mc = Minecraft.getMinecraft();
    }
    
    public static float getYawBetween(final float lllllllllllIIIIIIlIIllllllIlllll, final double lllllllllllIIIIIIlIIllllllIllllI, final double lllllllllllIIIIIIlIIllllllIlllIl, final double lllllllllllIIIIIIlIIlllllllIIlII, final double lllllllllllIIIIIIlIIlllllllIIIll) {
        final double lllllllllllIIIIIIlIIlllllllIIIlI = lllllllllllIIIIIIlIIlllllllIIlII - lllllllllllIIIIIIlIIllllllIllllI;
        final double lllllllllllIIIIIIlIIlllllllIIIIl = lllllllllllIIIIIIlIIlllllllIIIll - lllllllllllIIIIIIlIIllllllIlllIl;
        final float lllllllllllIIIIIIlIIlllllllIIIII = (float)(Math.atan2(lllllllllllIIIIIIlIIlllllllIIIIl, lllllllllllIIIIIIlIIlllllllIIIlI) * 180.0 / 3.141592653589793 - 90.0);
        return lllllllllllIIIIIIlIIllllllIlllll + MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllllllIIIII - lllllllllllIIIIIIlIIllllllIlllll);
    }
    
    public static float[] getNewFaceRotating(final Entity lllllllllllIIIIIIlIIllllIIIlIlII) {
        final double lllllllllllIIIIIIlIIllllIIlIIIII = lllllllllllIIIIIIlIIllllIIIlIlII.posX - lllllllllllIIIIIIlIIllllIIIlIlII.lastTickPosX;
        final double lllllllllllIIIIIIlIIllllIIIlllll = lllllllllllIIIIIIlIIllllIIIlIlII.posZ - lllllllllllIIIIIIlIIllllIIIlIlII.lastTickPosZ;
        double lllllllllllIIIIIIlIIllllIIIllllI = 1.0;
        double lllllllllllIIIIIIlIIllllIIIlllIl = 1.0;
        final boolean lllllllllllIIIIIIlIIllllIIIlllII = lllllllllllIIIIIIlIIllllIIIlIlII.isSprinting();
        lllllllllllIIIIIIlIIllllIIIllllI = lllllllllllIIIIIIlIIllllIIlIIIII * (lllllllllllIIIIIIlIIllllIIIlllII ? 0.97 : 1.0);
        lllllllllllIIIIIIlIIllllIIIlllIl = lllllllllllIIIIIIlIIllllIIIlllll * (lllllllllllIIIIIIlIIllllIIIlllII ? 0.97 : 1.0);
        final double lllllllllllIIIIIIlIIllllIIIllIll = lllllllllllIIIIIIlIIllllIIIlIlII.posX + lllllllllllIIIIIIlIIllllIIIllllI - RotationHelper.mc.player.posX;
        final double lllllllllllIIIIIIlIIllllIIIllIlI = lllllllllllIIIIIIlIIllllIIIlIlII.posZ + lllllllllllIIIIIIlIIllllIIIlllIl - RotationHelper.mc.player.posZ;
        double lllllllllllIIIIIIlIIllllIIlIIIIl;
        if (lllllllllllIIIIIIlIIllllIIIlIlII instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllIIIIIIlIIllllIIIllIIl = (EntityLivingBase)lllllllllllIIIIIIlIIllllIIIlIlII;
            final float lllllllllllIIIIIIlIIllllIIIllIII = RandomHelper.nextFloat((float)(lllllllllllIIIIIIlIIllllIIIllIIl.posY + lllllllllllIIIIIIlIIllllIIIllIIl.getEyeHeight() / 1.5f), (float)(lllllllllllIIIIIIlIIllllIIIllIIl.posY + lllllllllllIIIIIIlIIllllIIIllIIl.getEyeHeight() - lllllllllllIIIIIIlIIllllIIIllIIl.getEyeHeight() / 3.0f));
            final double lllllllllllIIIIIIlIIllllIIlIIIlI = lllllllllllIIIIIIlIIllllIIIllIII - RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight();
        }
        else {
            lllllllllllIIIIIIlIIllllIIlIIIIl = RandomHelper.nextFloat((float)lllllllllllIIIIIIlIIllllIIIlIlII.getEntityBoundingBox().minY, (float)lllllllllllIIIIIIlIIllllIIIlIlII.getEntityBoundingBox().maxY) - RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight();
        }
        final double lllllllllllIIIIIIlIIllllIIIlIlll = RotationHelper.mc.player.getDistanceToEntity(lllllllllllIIIIIIlIIllllIIIlIlII);
        float lllllllllllIIIIIIlIIllllIIIlIllI = (float)(Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIllllIIIllIlI, lllllllllllIIIIIIlIIllllIIIllIll)) - 90.0) + RandomHelper.nextFloat(-1.0f, 2.0f);
        float lllllllllllIIIIIIlIIllllIIIlIlIl = (float)(Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIllllIIlIIIIl, lllllllllllIIIIIIlIIllllIIIlIlll)) + RandomHelper.nextFloat(-1.0f, 2.0f));
        lllllllllllIIIIIIlIIllllIIIlIllI = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIIIlIllI - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIllllIIIlIlIl = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIIIlIlIl - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIllllIIIlIlIl = MathHelper.clamp(lllllllllllIIIIIIlIIllllIIIlIlIl, -90.0f, 90.0f);
        return new float[] { lllllllllllIIIIIIlIIllllIIIlIllI, lllllllllllIIIIIIlIIllllIIIlIlIl };
    }
    
    public static float[] getSunriseRotations(final Entity lllllllllllIIIIIIlIIlllllIIlIIII, final boolean lllllllllllIIIIIIlIIlllllIIllllI, final float lllllllllllIIIIIIlIIlllllIIIlllI, final float lllllllllllIIIIIIlIIlllllIIlllII, final float lllllllllllIIIIIIlIIlllllIIllIll, final float lllllllllllIIIIIIlIIlllllIIllIlI) {
        final double lllllllllllIIIIIIlIIlllllIIllIIl = lllllllllllIIIIIIlIIlllllIIlIIII.posX + (lllllllllllIIIIIIlIIlllllIIlIIII.posX - lllllllllllIIIIIIlIIlllllIIlIIII.prevPosX) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posX - RotationHelper.mc.player.motionX * KillAura.rotPredict.getNumberValue();
        final double lllllllllllIIIIIIlIIlllllIIllIII = lllllllllllIIIIIIlIIlllllIIlIIII.posZ + (lllllllllllIIIIIIlIIlllllIIlIIII.posZ - lllllllllllIIIIIIlIIlllllIIlIIII.prevPosZ) * KillAura.rotPredict.getNumberValue() - RotationHelper.mc.player.posZ - RotationHelper.mc.player.motionZ * KillAura.rotPredict.getNumberValue();
        double lllllllllllIIIIIIlIIlllllIIlIllI = 0.0;
        if (lllllllllllIIIIIIlIIlllllIIlIIII instanceof EntityLivingBase) {
            final double lllllllllllIIIIIIlIIlllllIIlIlll = lllllllllllIIIIIIlIIlllllIIlIIII.posY + lllllllllllIIIIIIlIIlllllIIlIIII.getEyeHeight() - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight()) - 0.6 - ((KillAura.walls.getBoolValue() && !((EntityLivingBase)lllllllllllIIIIIIlIIlllllIIlIIII).canEntityBeSeen(RotationHelper.mc.player)) ? -0.38 : 0.0);
        }
        else {
            lllllllllllIIIIIIlIIlllllIIlIllI = (lllllllllllIIIIIIlIIlllllIIlIIII.getEntityBoundingBox().minY + lllllllllllIIIIIIlIIlllllIIlIIII.getEntityBoundingBox().maxY) / 2.0 - (RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight());
        }
        final double lllllllllllIIIIIIlIIlllllIIlIlIl = MathHelper.sqrt(lllllllllllIIIIIIlIIlllllIIllIIl * lllllllllllIIIIIIlIIlllllIIllIIl + lllllllllllIIIIIIlIIlllllIIllIII * lllllllllllIIIIIIlIIlllllIIllIII);
        lllllllllllIIIIIIlIIlllllIIlIllI /= lllllllllllIIIIIIlIIlllllIIlIlIl;
        float lllllllllllIIIIIIlIIlllllIIlIlII = 0.0f;
        if (lllllllllllIIIIIIlIIlllllIIllllI) {
            lllllllllllIIIIIIlIIlllllIIlIlII = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllllIIllIll, -lllllllllllIIIIIIlIIlllllIIllIll);
        }
        float lllllllllllIIIIIIlIIlllllIIlIIll = 0.0f;
        if (lllllllllllIIIIIIlIIlllllIIllllI) {
            lllllllllllIIIIIIlIIlllllIIlIIll = MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllllIIllIlI, -lllllllllllIIIIIIlIIlllllIIllIlI);
        }
        float lllllllllllIIIIIIlIIlllllIIlIIlI = (float)(Math.atan2(lllllllllllIIIIIIlIIlllllIIllIII, lllllllllllIIIIIIlIIlllllIIllIIl) * 180.0 / 3.141592653589793 - 90.0) + lllllllllllIIIIIIlIIlllllIIlIlII;
        float lllllllllllIIIIIIlIIlllllIIlIIIl = (float)(-(Math.atan2(lllllllllllIIIIIIlIIlllllIIlIllI, lllllllllllIIIIIIlIIlllllIIlIlIl) * 180.0 / 3.141592653589793)) + lllllllllllIIIIIIlIIlllllIIlIIll;
        lllllllllllIIIIIIlIIlllllIIlIIlI = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllllIIlIIlI - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIlllllIIlIIIl = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllllIIlIIIl - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIlllllIIlIIIl = MathHelper.clamp(lllllllllllIIIIIIlIIlllllIIlIIIl, -90.0f, 90.0f);
        lllllllllllIIIIIIlIIlllllIIlIIlI = updateRotation(RotationHelper.mc.player.rotationYaw, lllllllllllIIIIIIlIIlllllIIlIIlI, MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllllIIlllII, lllllllllllIIIIIIlIIlllllIIIlllI));
        lllllllllllIIIIIIlIIlllllIIlIIIl = updateRotation(RotationHelper.mc.player.rotationPitch, lllllllllllIIIIIIlIIlllllIIlIIIl, MathematicHelper.randomizeFloat(lllllllllllIIIIIIlIIlllllIIlllII, lllllllllllIIIIIIlIIlllllIIIlllI));
        return new float[] { lllllllllllIIIIIIlIIlllllIIlIIlI, lllllllllllIIIIIIlIIlllllIIlIIIl };
    }
    
    public static float[] getLookAngles(final Vec3d lllllllllllIIIIIIlIIlllIIIIIIllI) {
        final float[] lllllllllllIIIIIIlIIlllIIIIIlIIl = { (float)(Math.atan2(RotationHelper.mc.player.posZ - lllllllllllIIIIIIlIIlllIIIIIIllI.zCoord, RotationHelper.mc.player.posX - lllllllllllIIIIIIlIIlllIIIIIIllI.xCoord) / 3.141592653589793 * 180.0) + 90.0f, 0.0f };
        final float lllllllllllIIIIIIlIIlllIIIIIlIII = (float)(RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight() - lllllllllllIIIIIIlIIlllIIIIIIllI.yCoord);
        final float lllllllllllIIIIIIlIIlllIIIIIIlll = (float)Math.sqrt((RotationHelper.mc.player.posZ - lllllllllllIIIIIIlIIlllIIIIIIllI.zCoord) * (RotationHelper.mc.player.posZ - lllllllllllIIIIIIlIIlllIIIIIIllI.zCoord) + (RotationHelper.mc.player.posX - lllllllllllIIIIIIlIIlllIIIIIIllI.xCoord) * (RotationHelper.mc.player.posX - lllllllllllIIIIIIlIIlllIIIIIIllI.xCoord));
        lllllllllllIIIIIIlIIlllIIIIIlIIl[1] = (float)(Math.atan2(lllllllllllIIIIIIlIIlllIIIIIlIII, lllllllllllIIIIIIlIIlllIIIIIIlll) / 3.141592653589793 * 180.0);
        return lllllllllllIIIIIIlIIlllIIIIIlIIl;
    }
    
    public static Vec3d getEyesPos() {
        return new Vec3d(RotationHelper.mc.player.posX, RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight(), RotationHelper.mc.player.posZ);
    }
    
    public static float[] getRatations(final Entity lllllllllllIIIIIIlIIllllllllllII) {
        final Vec3d lllllllllllIIIIIIlIlIIIIIIIIIlIl = new Vec3d(RotationHelper.mc.player.posX + MathematicHelper.randomizeFloat(-1.0f, 2.0f) / 15.0f, RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight() - 0.6, RotationHelper.mc.player.posZ + MathematicHelper.randomizeFloat(-1.0f, 2.0f) / 15.0f);
        final double lllllllllllIIIIIIlIlIIIIIIIIIlII = lllllllllllIIIIIIlIIllllllllllII.getPositionVector().xCoord - lllllllllllIIIIIIlIlIIIIIIIIIlIl.xCoord;
        final double lllllllllllIIIIIIlIlIIIIIIIIIIll = lllllllllllIIIIIIlIIllllllllllII.getPositionVector().yCoord - lllllllllllIIIIIIlIlIIIIIIIIIlIl.yCoord;
        final double lllllllllllIIIIIIlIlIIIIIIIIIIlI = lllllllllllIIIIIIlIIllllllllllII.getPositionVector().zCoord - lllllllllllIIIIIIlIlIIIIIIIIIlIl.zCoord;
        final double lllllllllllIIIIIIlIlIIIIIIIIIIIl = Math.sqrt(lllllllllllIIIIIIlIlIIIIIIIIIlII * lllllllllllIIIIIIlIlIIIIIIIIIlII + lllllllllllIIIIIIlIlIIIIIIIIIIlI * lllllllllllIIIIIIlIlIIIIIIIIIIlI);
        float lllllllllllIIIIIIlIlIIIIIIIIIIII = MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIlIIIIIIIIIIlI, lllllllllllIIIIIIlIlIIIIIIIIIlII)) - 90.0f);
        float lllllllllllIIIIIIlIIllllllllllll = MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIlIIIIIIIIIIll, lllllllllllIIIIIIlIlIIIIIIIIIIIl))) - 10.0f);
        final float lllllllllllIIIIIIlIIlllllllllllI = RotationHelper.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
        final float lllllllllllIIIIIIlIIllllllllllIl = lllllllllllIIIIIIlIIlllllllllllI * lllllllllllIIIIIIlIIlllllllllllI * lllllllllllIIIIIIlIIlllllllllllI * 1.2f;
        lllllllllllIIIIIIlIlIIIIIIIIIIII -= lllllllllllIIIIIIlIlIIIIIIIIIIII % lllllllllllIIIIIIlIIllllllllllIl;
        lllllllllllIIIIIIlIIllllllllllll -= lllllllllllIIIIIIlIIllllllllllll % lllllllllllIIIIIIlIIllllllllllIl;
        return new float[] { lllllllllllIIIIIIlIlIIIIIIIIIIII, lllllllllllIIIIIIlIIllllllllllll };
    }
    
    public static float[] getNeededFacing(final Vec3d lllllllllllIIIIIIlIIlllIIIIlIllI) {
        final Vec3d lllllllllllIIIIIIlIIlllIIIIlllIl = getEyesPos();
        final double lllllllllllIIIIIIlIIlllIIIIlllII = lllllllllllIIIIIIlIIlllIIIIlIllI.xCoord - lllllllllllIIIIIIlIIlllIIIIlllIl.xCoord;
        final double lllllllllllIIIIIIlIIlllIIIIllIll = lllllllllllIIIIIIlIIlllIIIIlIllI.yCoord - RotationHelper.mc.player.posY + RotationHelper.mc.player.getEyeHeight() + 0.2;
        final double lllllllllllIIIIIIlIIlllIIIIllIlI = lllllllllllIIIIIIlIIlllIIIIlIllI.zCoord - lllllllllllIIIIIIlIIlllIIIIlllIl.zCoord;
        final double lllllllllllIIIIIIlIIlllIIIIllIIl = Math.sqrt(lllllllllllIIIIIIlIIlllIIIIlllII * lllllllllllIIIIIIlIIlllIIIIlllII + lllllllllllIIIIIIlIIlllIIIIllIlI * lllllllllllIIIIIIlIIlllIIIIllIlI);
        float lllllllllllIIIIIIlIIlllIIIIllIII = (float)Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIIIIllIlI, lllllllllllIIIIIIlIIlllIIIIlllII)) - 90.0f;
        float lllllllllllIIIIIIlIIlllIIIIlIlll = (float)(-Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIIIIllIll, lllllllllllIIIIIIlIIlllIIIIllIIl)));
        lllllllllllIIIIIIlIIlllIIIIllIII = RotationHelper.mc.player.rotationYaw + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllIIIIllIII - RotationHelper.mc.player.rotationYaw));
        lllllllllllIIIIIIlIIlllIIIIlIlll = RotationHelper.mc.player.rotationPitch + GCDFix.getFixedRotation(MathHelper.wrapDegrees(lllllllllllIIIIIIlIIlllIIIIlIlll - RotationHelper.mc.player.rotationPitch));
        lllllllllllIIIIIIlIIlllIIIIlIlll = MathHelper.clamp(lllllllllllIIIIIIlIIlllIIIIlIlll, -90.0f, 90.0f);
        return new float[] { lllllllllllIIIIIIlIIlllIIIIllIII, lllllllllllIIIIIIlIIlllIIIIlIlll };
    }
    
    public static boolean isLookingAtEntity(final float lllllllllllIIIIIIlIIllllIlIlIIlI, final float lllllllllllIIIIIIlIIllllIlIIIllI, final float lllllllllllIIIIIIlIIllllIlIlIIII, final float lllllllllllIIIIIIlIIllllIlIIllll, final float lllllllllllIIIIIIlIIllllIlIIlllI, final Entity lllllllllllIIIIIIlIIllllIlIIIIlI, final double lllllllllllIIIIIIlIIllllIlIIIIIl) {
        final Vec3d lllllllllllIIIIIIlIIllllIlIIlIll = RotationHelper.mc.player.getPositionEyes(1.0f);
        final Vec3d lllllllllllIIIIIIlIIllllIlIIlIlI = Entity.getVectorForRotation(lllllllllllIIIIIIlIIllllIlIIIllI, lllllllllllIIIIIIlIIllllIlIlIIlI);
        final Vec3d lllllllllllIIIIIIlIIllllIlIIlIIl = lllllllllllIIIIIIlIIllllIlIIlIll.addVector(lllllllllllIIIIIIlIIllllIlIIlIlI.xCoord * lllllllllllIIIIIIlIIllllIlIIIIIl, lllllllllllIIIIIIlIIllllIlIIlIlI.yCoord * lllllllllllIIIIIIlIIllllIlIIIIIl, lllllllllllIIIIIIlIIllllIlIIlIlI.zCoord * lllllllllllIIIIIIlIIllllIlIIIIIl);
        final RayTraceResult lllllllllllIIIIIIlIIllllIlIIlIII = RotationHelper.mc.world.rayTraceBlocks(lllllllllllIIIIIIlIIllllIlIIlIll, lllllllllllIIIIIIlIIllllIlIIlIIl, false, false, true);
        return lllllllllllIIIIIIlIIllllIlIIlIII != null && lllllllllllIIIIIIlIIllllIlIIIIlI.getEntityBoundingBox().expand(lllllllllllIIIIIIlIIllllIlIlIIII, lllllllllllIIIIIIlIIllllIlIIllll, lllllllllllIIIIIIlIIllllIlIIlllI).calculateIntercept(lllllllllllIIIIIIlIIllllIlIIlIll, lllllllllllIIIIIIlIIllllIlIIlIIl) != null;
    }
    
    public static boolean canSeeEntityAtFov(final Entity lllllllllllIIIIIIlIIlllIIIllllIl, final float lllllllllllIIIIIIlIIlllIIIllIlIl) {
        Minecraft.getMinecraft();
        final double lllllllllllIIIIIIlIIlllIIIlllIll = lllllllllllIIIIIIlIIlllIIIllllIl.posX - RotationHelper.mc.player.posX;
        Minecraft.getMinecraft();
        final double lllllllllllIIIIIIlIIlllIIIlllIlI = lllllllllllIIIIIIlIIlllIIIllllIl.posZ - RotationHelper.mc.player.posZ;
        final float lllllllllllIIIIIIlIIlllIIIlllIIl = (float)(Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIIIlllIlI, lllllllllllIIIIIIlIIlllIIIlllIll)) - 90.0);
        final double lllllllllllIIIIIIlIIlllIIIlllIII = lllllllllllIIIIIIlIIlllIIIlllIIl;
        Minecraft.getMinecraft();
        final double lllllllllllIIIIIIlIIlllIIIllIlll = angleDifference(lllllllllllIIIIIIlIIlllIIIlllIII, RotationHelper.mc.player.rotationYaw);
        return lllllllllllIIIIIIlIIlllIIIllIlll <= lllllllllllIIIIIIlIIlllIIIllIlIl;
    }
    
    public static float[] getRotations(final Entity lllllllllllIIIIIIlIIlllIlIIlIIIl) {
        final double lllllllllllIIIIIIlIIlllIlIIlIIII = lllllllllllIIIIIIlIIlllIlIIlIIIl.posX;
        final double lllllllllllIIIIIIlIIlllIlIIIllll = lllllllllllIIIIIIlIIlllIlIIlIIIl.posZ;
        final double lllllllllllIIIIIIlIIlllIlIIIlllI = lllllllllllIIIIIIlIIlllIlIIlIIIl.posY + lllllllllllIIIIIIlIIlllIlIIlIIIl.getEyeHeight() / 2.0f;
        return getRotationFromPosition(lllllllllllIIIIIIlIIlllIlIIlIIII, lllllllllllIIIIIIlIIlllIlIIIllll, lllllllllllIIIIIIlIIlllIlIIIlllI);
    }
    
    public static boolean isAimAtMe(final Entity lllllllllllIIIIIIlIIllllIIIIIIIl, final float lllllllllllIIIIIIlIIllllIIIIIIll) {
        final float lllllllllllIIIIIIlIIllllIIIIIIlI = MathHelper.wrapDegrees(lllllllllllIIIIIIlIIllllIIIIIIIl.rotationYaw);
        return Math.abs(MathHelper.wrapDegrees(getYawToEntity(lllllllllllIIIIIIlIIllllIIIIIIIl, Minecraft.getMinecraft().player)) - lllllllllllIIIIIIlIIllllIIIIIIlI) <= lllllllllllIIIIIIlIIllllIIIIIIll;
    }
    
    public static float getNormalizedYaw(final float lllllllllllIIIIIIlIIlllIlIIlIlll) {
        float lllllllllllIIIIIIlIIlllIlIIllIII = lllllllllllIIIIIIlIIlllIlIIlIlll % 360.0f;
        if (lllllllllllIIIIIIlIIlllIlIIllIII > 180.0f) {
            lllllllllllIIIIIIlIIlllIlIIllIII -= 360.0f;
            return lllllllllllIIIIIIlIIlllIlIIllIII;
        }
        if (lllllllllllIIIIIIlIIlllIlIIllIII < -180.0f) {
            lllllllllllIIIIIIlIIlllIlIIllIII += 360.0f;
            return lllllllllllIIIIIIlIIlllIlIIllIII;
        }
        return lllllllllllIIIIIIlIIlllIlIIllIII;
    }
    
    public static float[] getRotationFromPosition(final double lllllllllllIIIIIIlIIlllIIlIIllIl, final double lllllllllllIIIIIIlIIlllIIlIIllII, final double lllllllllllIIIIIIlIIlllIIlIlIlII) {
        final double lllllllllllIIIIIIlIIlllIIlIlIIll = lllllllllllIIIIIIlIIlllIIlIIllIl - Minecraft.getMinecraft().player.posX;
        final double lllllllllllIIIIIIlIIlllIIlIlIIlI = lllllllllllIIIIIIlIIlllIIlIIllII - Minecraft.getMinecraft().player.posZ;
        final double lllllllllllIIIIIIlIIlllIIlIlIIIl = lllllllllllIIIIIIlIIlllIIlIlIlII - Minecraft.getMinecraft().player.posY - 1.7;
        final double lllllllllllIIIIIIlIIlllIIlIlIIII = MathHelper.sqrt(lllllllllllIIIIIIlIIlllIIlIlIIll * lllllllllllIIIIIIlIIlllIIlIlIIll + lllllllllllIIIIIIlIIlllIIlIlIIlI * lllllllllllIIIIIIlIIlllIIlIlIIlI);
        final float lllllllllllIIIIIIlIIlllIIlIIllll = (float)(Math.atan2(lllllllllllIIIIIIlIIlllIIlIlIIlI, lllllllllllIIIIIIlIIlllIIlIlIIll) * 180.0 / 3.141592653589793) - 90.0f;
        final float lllllllllllIIIIIIlIIlllIIlIIlllI = (float)(-(Math.atan2(lllllllllllIIIIIIlIIlllIIlIlIIIl, lllllllllllIIIIIIlIIlllIIlIlIIII) * 180.0 / 3.141592653589793));
        return new float[] { lllllllllllIIIIIIlIIlllIIlIIllll, lllllllllllIIIIIIlIIlllIIlIIlllI };
    }
    
    public static boolean isAimAtMe(final Entity lllllllllllIIIIIIlIIlllIlllIIllI) {
        final float lllllllllllIIIIIIlIIlllIlllIIlIl = getNormalizedYaw(lllllllllllIIIIIIlIIlllIlllIIllI.rotationYaw);
        final float lllllllllllIIIIIIlIIlllIlllIIlII = lllllllllllIIIIIIlIIlllIlllIIllI.rotationPitch;
        final double lllllllllllIIIIIIlIIlllIlllIIIll = RotationHelper.mc.player.getEntityBoundingBox().minX;
        final double lllllllllllIIIIIIlIIlllIlllIIIlI = RotationHelper.mc.player.getEntityBoundingBox().maxX;
        final double lllllllllllIIIIIIlIIlllIlllIIIIl = RotationHelper.mc.player.posY + RotationHelper.mc.player.height;
        final double lllllllllllIIIIIIlIIlllIlllIIIII = RotationHelper.mc.player.getEntityBoundingBox().minY;
        final double lllllllllllIIIIIIlIIlllIllIlllll = RotationHelper.mc.player.getEntityBoundingBox().maxZ;
        final double lllllllllllIIIIIIlIIlllIllIllllI = RotationHelper.mc.player.getEntityBoundingBox().minZ;
        final double lllllllllllIIIIIIlIIlllIllIlllIl = lllllllllllIIIIIIlIIlllIlllIIllI.posX;
        final double lllllllllllIIIIIIlIIlllIllIlllII = lllllllllllIIIIIIlIIlllIlllIIllI.posY + lllllllllllIIIIIIlIIlllIlllIIllI.height;
        final double lllllllllllIIIIIIlIIlllIllIllIll = lllllllllllIIIIIIlIIlllIlllIIllI.posZ;
        final double lllllllllllIIIIIIlIIlllIllIllIlI = lllllllllllIIIIIIlIIlllIlllIIIlI - lllllllllllIIIIIIlIIlllIllIlllIl;
        final double lllllllllllIIIIIIlIIlllIllIllIIl = lllllllllllIIIIIIlIIlllIlllIIIIl - lllllllllllIIIIIIlIIlllIllIlllII;
        final double lllllllllllIIIIIIlIIlllIllIllIII = lllllllllllIIIIIIlIIlllIllIlllll - lllllllllllIIIIIIlIIlllIllIllIll;
        final double lllllllllllIIIIIIlIIlllIllIlIlll = lllllllllllIIIIIIlIIlllIlllIIIll - lllllllllllIIIIIIlIIlllIllIlllIl;
        final double lllllllllllIIIIIIlIIlllIllIlIllI = lllllllllllIIIIIIlIIlllIlllIIIII - lllllllllllIIIIIIlIIlllIllIlllII;
        final double lllllllllllIIIIIIlIIlllIllIlIlIl = lllllllllllIIIIIIlIIlllIllIllllI - lllllllllllIIIIIIlIIlllIllIllIll;
        final double lllllllllllIIIIIIlIIlllIllIlIlII = Math.sqrt(Math.pow(lllllllllllIIIIIIlIIlllIllIlIlll, 2.0) + Math.pow(lllllllllllIIIIIIlIIlllIllIlIlIl, 2.0));
        final double lllllllllllIIIIIIlIIlllIllIlIIll = Math.sqrt(Math.pow(lllllllllllIIIIIIlIIlllIllIllIlI, 2.0) + Math.pow(lllllllllllIIIIIIlIIlllIllIllIII, 2.0));
        final double lllllllllllIIIIIIlIIlllIllIlIIlI = 90.0 - Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIllIlIIll, lllllllllllIIIIIIlIIlllIllIllIIl));
        final double lllllllllllIIIIIIlIIlllIllIlIIIl = 90.0 - Math.toDegrees(Math.atan2(lllllllllllIIIIIIlIIlllIllIlIlII, lllllllllllIIIIIIlIIlllIllIlIllI));
        final boolean lllllllllllIIIIIIlIIlllIllIlIIII = Math.abs(getNormalizedYaw(getYawToEntity(lllllllllllIIIIIIlIIlllIlllIIllI, RotationHelper.mc.player)) - lllllllllllIIIIIIlIIlllIlllIIlIl) <= 16.0f - RotationHelper.mc.player.getDistanceToEntity(lllllllllllIIIIIIlIIlllIlllIIllI) / 2.0f;
        final boolean lllllllllllIIIIIIlIIlllIllIIllll = (lllllllllllIIIIIIlIIlllIllIlIIlI >= lllllllllllIIIIIIlIIlllIlllIIlII && lllllllllllIIIIIIlIIlllIlllIIlII >= lllllllllllIIIIIIlIIlllIllIlIIIl) || (lllllllllllIIIIIIlIIlllIllIlIIIl >= lllllllllllIIIIIIlIIlllIlllIIlII && lllllllllllIIIIIIlIIlllIlllIIlII >= lllllllllllIIIIIIlIIlllIllIlIIlI);
        return lllllllllllIIIIIIlIIlllIllIlIIII && lllllllllllIIIIIIlIIlllIllIIllll;
    }
    
    public static class Rotation
    {
        public static /* synthetic */ int rotationCounter;
        public static /* synthetic */ boolean isReady;
        public static /* synthetic */ boolean isAiming;
        
        public static double calcMove() {
            final double llllllllllIlllIIIlIllIlllllIlIIl = RotationHelper.mc.player.posX - RotationHelper.mc.player.prevPosX;
            final double llllllllllIlllIIIlIllIlllllIlIII = RotationHelper.mc.player.posZ - RotationHelper.mc.player.prevPosZ;
            return Math.hypot(llllllllllIlllIIIlIllIlllllIlIIl, llllllllllIlllIIIlIllIlllllIlIII);
        }
        
        static {
            Rotation.isReady = false;
        }
        
        public static boolean isAiming() {
            return !Rotation.isAiming;
        }
        
        @EventTarget
        public void onSendPacket(final EventSendPacket llllllllllIlllIIIlIllIlllllIIIlI) {
            if (llllllllllIlllIIIlIllIlllllIIIlI.getPacket() instanceof CPacketAnimation) {
                Rotation.rotationCounter = 10;
            }
        }
    }
}
