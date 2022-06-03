// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.Minecraft;

public class RotationSpoofer
{
    static /* synthetic */ Minecraft mc;
    
    public static boolean isFacingEntity(final EntityLivingBase lllllllllllIllIlllIllIIIIlIllIII) {
        float lllllllllllIllIlllIllIIIIlIlllIl = getNeededRotations(lllllllllllIllIlllIllIIIIlIllIII)[0];
        float lllllllllllIllIlllIllIIIIlIlllII = getNeededRotations(lllllllllllIllIlllIllIIIIlIllIII)[1];
        float lllllllllllIllIlllIllIIIIlIllIll = RotationSpoofer.mc.player.rotationYaw;
        float lllllllllllIllIlllIllIIIIlIllIlI = RotationSpoofer.mc.player.rotationPitch;
        final float lllllllllllIllIlllIllIIIIlIllIIl = 21.0f + lllllllllllIllIlllIllIIIIlIllIII.getCollisionBorderSize();
        if (lllllllllllIllIlllIllIIIIlIllIll < 0.0f) {
            lllllllllllIllIlllIllIIIIlIllIll += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIllIlI < 0.0f) {
            lllllllllllIllIlllIllIIIIlIllIlI += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIlllIl < 0.0f) {
            lllllllllllIllIlllIllIIIIlIlllIl += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIlllII < 0.0f) {
            lllllllllllIllIlllIllIIIIlIlllII += 360.0f;
        }
        return lllllllllllIllIlllIllIIIIlIllIll >= lllllllllllIllIlllIllIIIIlIlllIl - lllllllllllIllIlllIllIIIIlIllIIl && lllllllllllIllIlllIllIIIIlIllIll <= lllllllllllIllIlllIllIIIIlIlllIl + lllllllllllIllIlllIllIIIIlIllIIl && (lllllllllllIllIlllIllIIIIlIllIlI >= lllllllllllIllIlllIllIIIIlIlllII - lllllllllllIllIlllIllIIIIlIllIIl && lllllllllllIllIlllIllIIIIlIllIlI <= lllllllllllIllIlllIllIIIIlIlllII + lllllllllllIllIlllIllIIIIlIllIIl);
    }
    
    public static void lookAtPos(final Vec3d lllllllllllIllIlllIlIlllllIlIlll) {
        final Minecraft lllllllllllIllIlllIlIlllllIllIIl = Minecraft.getMinecraft();
        final Float[] lllllllllllIllIlllIlIlllllIllIII = getLookAngles(lllllllllllIllIlllIlIlllllIlIlll);
        lllllllllllIllIlllIlIlllllIllIIl.player.rotationYaw = lllllllllllIllIlllIlIlllllIllIII[0];
        lllllllllllIllIlllIlIlllllIllIIl.player.rotationPitch = lllllllllllIllIlllIlIlllllIllIII[1];
    }
    
    public static double getLookDiff(final Vec3d lllllllllllIllIlllIlIlllllIIlllI) {
        final Minecraft lllllllllllIllIlllIlIlllllIlIIII = Minecraft.getMinecraft();
        final Float[] lllllllllllIllIlllIlIlllllIIllll = getLookAngles(lllllllllllIllIlllIlIlllllIIlllI);
        return Math.sqrt((lllllllllllIllIlllIlIlllllIlIIII.player.rotationYaw - lllllllllllIllIlllIlIlllllIIllll[0]) * (lllllllllllIllIlllIlIlllllIlIIII.player.rotationYaw - lllllllllllIllIlllIlIlllllIIllll[0]) + (lllllllllllIllIlllIlIlllllIlIIII.player.rotationPitch - lllllllllllIllIlllIlIlllllIIllll[1]) * (lllllllllllIllIlllIlIlllllIlIIII.player.rotationPitch - lllllllllllIllIlllIlIlllllIIllll[1]));
    }
    
    public static boolean isLookingAtEntity1(final Entity lllllllllllIllIlllIllIIIIlIlIIII) {
        return isLookingAt21(lllllllllllIllIlllIllIIIIlIlIIII.getPositionEyes(Minecraft.getMinecraft().timer.renderPartialTicks));
    }
    
    public static float clampF(final float lllllllllllIllIlllIlIlllllIIIIll, final float lllllllllllIllIlllIlIlllllIIIIlI, final float lllllllllllIllIlllIlIlllllIIIIIl) {
        float lllllllllllIllIlllIlIlllllIIIlII = MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIlIlllllIIIIll - lllllllllllIllIlllIlIlllllIIIIlI);
        if (lllllllllllIllIlllIlIlllllIIIlII > lllllllllllIllIlllIlIlllllIIIIIl) {
            lllllllllllIllIlllIlIlllllIIIlII = lllllllllllIllIlllIlIlllllIIIIIl;
        }
        else if (lllllllllllIllIlllIlIlllllIIIlII < -lllllllllllIllIlllIlIlllllIIIIIl) {
            lllllllllllIllIlllIlIlllllIIIlII = -lllllllllllIllIlllIlIlllllIIIIIl;
        }
        return MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIlIlllllIIIIlI + lllllllllllIllIlllIlIlllllIIIlII);
    }
    
    public static float getAngleChange(final EntityLivingBase lllllllllllIllIlllIllIIIIlIIlIII) {
        float lllllllllllIllIlllIllIIIIlIIIlll = getNeededRotations(lllllllllllIllIlllIllIIIIlIIlIII)[0];
        float lllllllllllIllIlllIllIIIIlIIIllI = getNeededRotations(lllllllllllIllIlllIllIIIIlIIlIII)[1];
        float lllllllllllIllIlllIllIIIIlIIIlIl = RotationSpoofer.mc.player.rotationYaw;
        float lllllllllllIllIlllIllIIIIlIIIlII = RotationSpoofer.mc.player.rotationPitch;
        if (lllllllllllIllIlllIllIIIIlIIIlIl < 0.0f) {
            lllllllllllIllIlllIllIIIIlIIIlIl += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIIIlII < 0.0f) {
            lllllllllllIllIlllIllIIIIlIIIlII += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIIIlll < 0.0f) {
            lllllllllllIllIlllIllIIIIlIIIlll += 360.0f;
        }
        if (lllllllllllIllIlllIllIIIIlIIIllI < 0.0f) {
            lllllllllllIllIlllIllIIIIlIIIllI += 360.0f;
        }
        final float lllllllllllIllIlllIllIIIIlIIIIll = Math.max(lllllllllllIllIlllIllIIIIlIIIlIl, lllllllllllIllIlllIllIIIIlIIIlll) - Math.min(lllllllllllIllIlllIllIIIIlIIIlIl, lllllllllllIllIlllIllIIIIlIIIlll);
        final float lllllllllllIllIlllIllIIIIlIIIIlI = Math.max(lllllllllllIllIlllIllIIIIlIIIlII, lllllllllllIllIlllIllIIIIlIIIllI) - Math.min(lllllllllllIllIlllIllIIIIlIIIlII, lllllllllllIllIlllIllIIIIlIIIllI);
        return lllllllllllIllIlllIllIIIIlIIIIll + lllllllllllIllIlllIllIIIIlIIIIlI;
    }
    
    static {
        RotationSpoofer.mc = Minecraft.getMinecraft();
    }
    
    public static Float[] getLookAngles(final Vec3d lllllllllllIllIlllIllIIIIllIlIIl) {
        final Float[] lllllllllllIllIlllIllIIIIllIllIl = new Float[2];
        final Minecraft lllllllllllIllIlllIllIIIIllIllII = Minecraft.getMinecraft();
        lllllllllllIllIlllIllIIIIllIllIl[0] = (float)(Math.atan2(lllllllllllIllIlllIllIIIIllIllII.player.posZ - lllllllllllIllIlllIllIIIIllIlIIl.zCoord, lllllllllllIllIlllIllIIIIllIllII.player.posX - lllllllllllIllIlllIllIIIIllIlIIl.xCoord) / 3.141592653589793 * 180.0) + 90.0f;
        final float lllllllllllIllIlllIllIIIIllIlIll = (float)(lllllllllllIllIlllIllIIIIllIllII.player.posY + lllllllllllIllIlllIllIIIIllIllII.player.getEyeHeight() - lllllllllllIllIlllIllIIIIllIlIIl.yCoord);
        final float lllllllllllIllIlllIllIIIIllIlIlI = (float)Math.sqrt((lllllllllllIllIlllIllIIIIllIllII.player.posZ - lllllllllllIllIlllIllIIIIllIlIIl.zCoord) * (lllllllllllIllIlllIllIIIIllIllII.player.posZ - lllllllllllIllIlllIllIIIIllIlIIl.zCoord) + (lllllllllllIllIlllIllIIIIllIllII.player.posX - lllllllllllIllIlllIllIIIIllIlIIl.xCoord) * (lllllllllllIllIlllIllIIIIllIllII.player.posX - lllllllllllIllIlllIllIIIIllIlIIl.xCoord));
        lllllllllllIllIlllIllIIIIllIllIl[1] = (float)(Math.atan2(lllllllllllIllIlllIllIIIIllIlIll, lllllllllllIllIlllIllIIIIllIlIlI) / 3.141592653589793 * 180.0);
        return lllllllllllIllIlllIllIIIIllIllIl;
    }
    
    public static boolean isLookingAt21(final Vec3d lllllllllllIllIlllIlIllllllIllll) {
        Float[] lllllllllllIllIlllIlIlllllllIIIl = getLookAngles(lllllllllllIllIlllIlIllllllIllll);
        lllllllllllIllIlllIlIlllllllIIIl = getLookAngles(lllllllllllIllIlllIlIllllllIllll);
        final float lllllllllllIllIlllIlIlllllllIIII = Math.abs(MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIlIlllllllIIIl[0] - RotationSpoofer.mc.player.rotationYaw)) / 0.7f;
        return lllllllllllIllIlllIlIlllllllIIII < 20.0f;
    }
    
    public static boolean isLookingAtTarget(final float lllllllllllIllIlllIllIIIIIIIIlIl, final float lllllllllllIllIlllIlIlllllllllII, final Entity lllllllllllIllIlllIllIIIIIIIIIll, final double lllllllllllIllIlllIllIIIIIIIIIlI) {
        final Vec3d lllllllllllIllIlllIllIIIIIIIIIIl = RotationSpoofer.mc.player.getPositionEyes(1.0f);
        final Vec3d lllllllllllIllIlllIllIIIIIIIIIII = Entity.getVectorForRotation(lllllllllllIllIlllIlIlllllllllII, lllllllllllIllIlllIllIIIIIIIIlIl);
        final Vec3d lllllllllllIllIlllIlIlllllllllll = lllllllllllIllIlllIllIIIIIIIIIIl.addVector(lllllllllllIllIlllIllIIIIIIIIIII.xCoord * lllllllllllIllIlllIllIIIIIIIIIlI, lllllllllllIllIlllIllIIIIIIIIIII.yCoord * lllllllllllIllIlllIllIIIIIIIIIlI, lllllllllllIllIlllIllIIIIIIIIIII.zCoord * lllllllllllIllIlllIllIIIIIIIIIlI);
        final RayTraceResult lllllllllllIllIlllIlIllllllllllI = RotationSpoofer.mc.world.rayTraceBlocks(lllllllllllIllIlllIllIIIIIIIIIIl, lllllllllllIllIlllIlIlllllllllll, false, false, true);
        return lllllllllllIllIlllIlIllllllllllI == null || lllllllllllIllIlllIllIIIIIIIIIll.getEntityBoundingBox().expand(0.06, 0.06, 0.06).calculateIntercept(lllllllllllIllIlllIllIIIIIIIIIIl, lllllllllllIllIlllIlIlllllllllll) == null;
    }
    
    public static void lookAtPosSmooth(final Vec3d lllllllllllIllIlllIlIllllllIIIlI, final float lllllllllllIllIlllIlIllllllIIIIl, final float lllllllllllIllIlllIlIllllllIIlIl) {
        final Minecraft lllllllllllIllIlllIlIllllllIIlII = Minecraft.getMinecraft();
        final Float[] lllllllllllIllIlllIlIllllllIIIll = getLookAngles(lllllllllllIllIlllIlIllllllIIIlI);
        lllllllllllIllIlllIlIllllllIIlII.player.rotationYaw = clampF(lllllllllllIllIlllIlIllllllIIIll[0], lllllllllllIllIlllIlIllllllIIlII.player.rotationYaw, lllllllllllIllIlllIlIllllllIIIIl);
        lllllllllllIllIlllIlIllllllIIlII.player.rotationPitch = clampF(lllllllllllIllIlllIlIllllllIIIll[1], lllllllllllIllIlllIlIllllllIIlII.player.rotationPitch, lllllllllllIllIlllIlIllllllIIlIl);
    }
    
    public static float clampFPercentage(final float lllllllllllIllIlllIlIllllIllIlll, final float lllllllllllIllIlllIlIllllIllIllI, final float lllllllllllIllIlllIlIllllIlllIIl) {
        final float lllllllllllIllIlllIlIllllIlllIII = MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIlIllllIllIlll - lllllllllllIllIlllIlIllllIllIllI);
        return MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIlIllllIllIllI + lllllllllllIllIlllIlIllllIlllIII * lllllllllllIllIlllIlIllllIlllIIl);
    }
    
    public static float[] getRotations(final EntityLivingBase lllllllllllIllIlllIllIIIIIlIIIIl, final float lllllllllllIllIlllIllIIIIIlIIIII) {
        final float lllllllllllIllIlllIllIIIIIIlllll = updateRotation(RotationSpoofer.mc.player.rotationYaw, getNeededRotations(lllllllllllIllIlllIllIIIIIlIIIIl)[0], lllllllllllIllIlllIllIIIIIlIIIII);
        final float lllllllllllIllIlllIllIIIIIIllllI = updateRotation(RotationSpoofer.mc.player.rotationPitch, getNeededRotations(lllllllllllIllIlllIllIIIIIlIIIIl)[1], lllllllllllIllIlllIllIIIIIlIIIII);
        return new float[] { lllllllllllIllIlllIllIIIIIIlllll, lllllllllllIllIlllIllIIIIIIllllI };
    }
    
    public static float[] getNeededRotations(final EntityLivingBase lllllllllllIllIlllIllIIIIIlIllII) {
        final double lllllllllllIllIlllIllIIIIIllIIlI = lllllllllllIllIlllIllIIIIIlIllII.posX - RotationSpoofer.mc.player.posX;
        final double lllllllllllIllIlllIllIIIIIllIIIl = lllllllllllIllIlllIllIIIIIlIllII.posZ - RotationSpoofer.mc.player.posZ;
        final double lllllllllllIllIlllIllIIIIIllIIII = lllllllllllIllIlllIllIIIIIlIllII.posY + lllllllllllIllIlllIllIIIIIlIllII.getEyeHeight() - (RotationSpoofer.mc.player.getEntityBoundingBox().minY + RotationSpoofer.mc.player.getEyeHeight());
        final double lllllllllllIllIlllIllIIIIIlIllll = MathHelper.sqrt(lllllllllllIllIlllIllIIIIIllIIlI * lllllllllllIllIlllIllIIIIIllIIlI + lllllllllllIllIlllIllIIIIIllIIIl * lllllllllllIllIlllIllIIIIIllIIIl);
        final float lllllllllllIllIlllIllIIIIIlIlllI = (float)(MathHelper.atan2(lllllllllllIllIlllIllIIIIIllIIIl, lllllllllllIllIlllIllIIIIIllIIlI) * 180.0 / 3.141592653589793) - 90.0f;
        final float lllllllllllIllIlllIllIIIIIlIllIl = (float)(-(MathHelper.atan2(lllllllllllIllIlllIllIIIIIllIIII, lllllllllllIllIlllIllIIIIIlIllll) * 180.0 / 3.141592653589793));
        return new float[] { lllllllllllIllIlllIllIIIIIlIlllI, lllllllllllIllIlllIllIIIIIlIllIl };
    }
    
    public static float updateRotation(final float lllllllllllIllIlllIllIIIIIIlIIIl, final float lllllllllllIllIlllIllIIIIIIlIlII, final float lllllllllllIllIlllIllIIIIIIIllll) {
        float lllllllllllIllIlllIllIIIIIIlIIlI = MathHelper.wrapAngleTo180_float(lllllllllllIllIlllIllIIIIIIlIlII - lllllllllllIllIlllIllIIIIIIlIIIl);
        if (lllllllllllIllIlllIllIIIIIIlIIlI > lllllllllllIllIlllIllIIIIIIIllll) {
            lllllllllllIllIlllIllIIIIIIlIIlI = lllllllllllIllIlllIllIIIIIIIllll;
        }
        if (lllllllllllIllIlllIllIIIIIIlIIlI < -lllllllllllIllIlllIllIIIIIIIllll) {
            lllllllllllIllIlllIllIIIIIIlIIlI = -lllllllllllIllIlllIllIIIIIIIllll;
        }
        return lllllllllllIllIlllIllIIIIIIlIIIl + lllllllllllIllIlllIllIIIIIIlIIlI;
    }
}
