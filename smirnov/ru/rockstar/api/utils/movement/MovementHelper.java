// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.movement;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.event.event.EventStrafe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.MovementInput;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.api.event.event.MoveEvent;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

public class MovementHelper
{
    public static /* synthetic */ double WALK_SPEED;
    public static /* synthetic */ Minecraft mc;
    
    public static float getSpeed() {
        return (float)Math.sqrt(MovementHelper.mc.player.motionX * MovementHelper.mc.player.motionX + MovementHelper.mc.player.motionZ * MovementHelper.mc.player.motionZ);
    }
    
    public static boolean isBlockAbove() {
        for (double lllllllllllIllIIlIIIlIlIIIlIllIl = 0.0; lllllllllllIllIIlIIIlIlIIIlIllIl <= 1.0; lllllllllllIllIIlIIIlIlIIIlIllIl += 0.5) {
            final List<AxisAlignedBB> lllllllllllIllIIlIIIlIlIIIlIllII = MovementHelper.mc.world.getCollisionBoxes(MovementHelper.mc.player, MovementHelper.mc.player.getEntityBoundingBox().offset(0.0, lllllllllllIllIIlIIIlIlIIIlIllIl, 0.0));
            if (!lllllllllllIllIIlIIIlIlIIIlIllII.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    public static double getBaseMoveSpeed() {
        double lllllllllllIllIIlIIIlIIlIlllIIII = 0.2873;
        if (MovementHelper.mc.player.isPotionActive(Potion.getPotionById(1))) {
            final int lllllllllllIllIIlIIIlIIlIllIllll = MovementHelper.mc.player.getActivePotionEffect(Potion.getPotionById(1)).getAmplifier();
            lllllllllllIllIIlIIIlIIlIlllIIII *= 1.0 + 0.2 * (lllllllllllIllIIlIIIlIIlIllIllll + 1);
        }
        return lllllllllllIllIIlIIIlIIlIlllIIII;
    }
    
    public static boolean isBlockAboveHead() {
        final AxisAlignedBB lllllllllllIllIIlIIIlIIllIIIllll = new AxisAlignedBB(MovementHelper.mc.player.posX - 0.3, MovementHelper.mc.player.posY + MovementHelper.mc.player.getEyeHeight(), MovementHelper.mc.player.posZ + 0.3, MovementHelper.mc.player.posX + 0.3, MovementHelper.mc.player.posY + 2.5, MovementHelper.mc.player.posZ - 0.3);
        return !MovementHelper.mc.world.getCollisionBoxes(MovementHelper.mc.player, lllllllllllIllIIlIIIlIIllIIIllll).isEmpty();
    }
    
    public static void setSpeedAt(final MoveEvent lllllllllllIllIIlIIIlIlIIIIIIIII, final float lllllllllllIllIIlIIIlIIlllllllll, final double lllllllllllIllIIlIIIlIIllllllllI) {
        final Minecraft lllllllllllIllIIlIIIlIlIIIIIIIIl = Minecraft.getMinecraft();
        if (!lllllllllllIllIIlIIIlIlIIIIIIIIl.gameSettings.keyBindJump.isKeyDown() && lllllllllllIllIIlIIIlIlIIIIIIIIl.player.onGround && lllllllllllIllIIlIIIlIlIIIIIIIIl.player.getDistanceToEntity(KillAura.target) > 1.0f) {
            lllllllllllIllIIlIIIlIlIIIIIIIII.setX(getXDirAt(lllllllllllIllIIlIIIlIIlllllllll) * lllllllllllIllIIlIIIlIIllllllllI);
            lllllllllllIllIIlIIIlIlIIIIIIIII.setZ(getZDirAt(lllllllllllIllIIlIIIlIIlllllllll) * lllllllllllIllIIlIIIlIIllllllllI);
        }
    }
    
    public static void setMotionEvent(final MoveEvent lllllllllllIllIIlIIIlIIllIIIlIII, final double lllllllllllIllIIlIIIlIIllIIIIlll) {
        double lllllllllllIllIIlIIIlIIllIIIIllI = MovementInput.moveForward;
        double lllllllllllIllIIlIIIlIIllIIIIlIl = MovementInput.moveStrafe;
        float lllllllllllIllIIlIIIlIIllIIIIlII = MovementHelper.mc.player.rotationYaw;
        if (lllllllllllIllIIlIIIlIIllIIIIllI == 0.0 && lllllllllllIllIIlIIIlIIllIIIIlIl == 0.0) {
            lllllllllllIllIIlIIIlIIllIIIlIII.setX(0.0);
            lllllllllllIllIIlIIIlIIllIIIlIII.setZ(0.0);
        }
        else {
            if (lllllllllllIllIIlIIIlIIllIIIIllI != 0.0) {
                if (lllllllllllIllIIlIIIlIIllIIIIlIl > 0.0) {
                    lllllllllllIllIIlIIIlIIllIIIIlII += ((lllllllllllIllIIlIIIlIIllIIIIllI > 0.0) ? -45 : 45);
                }
                else if (lllllllllllIllIIlIIIlIIllIIIIlIl < 0.0) {
                    lllllllllllIllIIlIIIlIIllIIIIlII += ((lllllllllllIllIIlIIIlIIllIIIIllI > 0.0) ? 45 : -45);
                }
                lllllllllllIllIIlIIIlIIllIIIIlIl = 0.0;
                if (lllllllllllIllIIlIIIlIIllIIIIllI > 0.0) {
                    lllllllllllIllIIlIIIlIIllIIIIllI = 1.0;
                }
                else if (lllllllllllIllIIlIIIlIIllIIIIllI < 0.0) {
                    lllllllllllIllIIlIIIlIIllIIIIllI = -1.0;
                }
            }
            lllllllllllIllIIlIIIlIIllIIIlIII.setX(lllllllllllIllIIlIIIlIIllIIIIllI * lllllllllllIllIIlIIIlIIllIIIIlll * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIllIIIIlII + 90.0f)) + lllllllllllIllIIlIIIlIIllIIIIlIl * lllllllllllIllIIlIIIlIIllIIIIlll * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIllIIIIlII + 90.0f)));
            lllllllllllIllIIlIIIlIIllIIIlIII.setZ(lllllllllllIllIIlIIIlIIllIIIIllI * lllllllllllIllIIlIIIlIIllIIIIlll * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIllIIIIlII + 90.0f)) - lllllllllllIllIIlIIIlIIllIIIIlIl * lllllllllllIllIIlIIIlIIllIIIIlll * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIllIIIIlII + 90.0f)));
        }
    }
    
    public static float getDirection2() {
        final Minecraft lllllllllllIllIIlIIIlIlIIIlIIIII = Minecraft.getMinecraft();
        float lllllllllllIllIIlIIIlIlIIIIlllll = lllllllllllIllIIlIIIlIlIIIlIIIII.player.rotationYaw;
        if (lllllllllllIllIIlIIIlIlIIIlIIIII.player.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIIIlllll += 180.0f;
        }
        float lllllllllllIllIIlIIIlIlIIIIllllI = 1.0f;
        if (lllllllllllIllIIlIIIlIlIIIlIIIII.player.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIIIllllI = -50.5f;
        }
        else if (lllllllllllIllIIlIIIlIlIIIlIIIII.player.moveForward > 0.0f) {
            lllllllllllIllIIlIIIlIlIIIIllllI = 50.5f;
        }
        if (lllllllllllIllIIlIIIlIlIIIlIIIII.player.moveStrafing > 0.0f) {
            lllllllllllIllIIlIIIlIlIIIIlllll -= 22.0f * lllllllllllIllIIlIIIlIlIIIIllllI;
        }
        if (lllllllllllIllIIlIIIlIlIIIlIIIII.player.moveStrafing < 0.0f) {
            lllllllllllIllIIlIIIlIlIIIIlllll += 22.0f * lllllllllllIllIIlIIIlIlIIIIllllI;
        }
        return lllllllllllIllIIlIIIlIlIIIIlllll *= 0.017453292f;
    }
    
    public static boolean hasMotion() {
        return MovementHelper.mc.player.motionX != 0.0 && MovementHelper.mc.player.motionZ != 0.0 && MovementHelper.mc.player.motionY != 0.0;
    }
    
    public static double[] forward(final double lllllllllllIllIIlIIIlIlIIllIIlll) {
        final MovementInput movementInput = MovementHelper.mc.player.movementInput;
        float lllllllllllIllIIlIIIlIlIIllIlllI = MovementInput.moveForward;
        final MovementInput movementInput2 = MovementHelper.mc.player.movementInput;
        float lllllllllllIllIIlIIIlIlIIllIllIl = MovementInput.moveStrafe;
        float lllllllllllIllIIlIIIlIlIIllIllII = MovementHelper.mc.player.prevRotationYaw + (MovementHelper.mc.player.rotationYaw - MovementHelper.mc.player.prevRotationYaw) * MovementHelper.mc.getRenderPartialTicks();
        if (lllllllllllIllIIlIIIlIlIIllIlllI != 0.0f) {
            if (lllllllllllIllIIlIIIlIlIIllIllIl > 0.0f) {
                lllllllllllIllIIlIIIlIlIIllIllII += ((lllllllllllIllIIlIIIlIlIIllIlllI > 0.0f) ? -45 : 45);
            }
            else if (lllllllllllIllIIlIIIlIlIIllIllIl < 0.0f) {
                lllllllllllIllIIlIIIlIlIIllIllII += ((lllllllllllIllIIlIIIlIlIIllIlllI > 0.0f) ? 45 : -45);
            }
            lllllllllllIllIIlIIIlIlIIllIllIl = 0.0f;
            if (lllllllllllIllIIlIIIlIlIIllIlllI > 0.0f) {
                lllllllllllIllIIlIIIlIlIIllIlllI = 1.0f;
            }
            else if (lllllllllllIllIIlIIIlIlIIllIlllI < 0.0f) {
                lllllllllllIllIIlIIIlIlIIllIlllI = -1.0f;
            }
        }
        final double lllllllllllIllIIlIIIlIlIIllIlIll = Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIlIIllIllII + 90.0f));
        final double lllllllllllIllIIlIIIlIlIIllIlIlI = Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIlIIllIllII + 90.0f));
        final double lllllllllllIllIIlIIIlIlIIllIlIIl = lllllllllllIllIIlIIIlIlIIllIlllI * lllllllllllIllIIlIIIlIlIIllIIlll * lllllllllllIllIIlIIIlIlIIllIlIlI + lllllllllllIllIIlIIIlIlIIllIllIl * lllllllllllIllIIlIIIlIlIIllIIlll * lllllllllllIllIIlIIIlIlIIllIlIll;
        final double lllllllllllIllIIlIIIlIlIIllIlIII = lllllllllllIllIIlIIIlIlIIllIlllI * lllllllllllIllIIlIIIlIlIIllIIlll * lllllllllllIllIIlIIIlIlIIllIlIll - lllllllllllIllIIlIIIlIlIIllIllIl * lllllllllllIllIIlIIIlIlIIllIIlll * lllllllllllIllIIlIIIlIlIIllIlIlI;
        return new double[] { lllllllllllIllIIlIIIlIlIIllIlIIl, lllllllllllIllIIlIIIlIlIIllIlIII };
    }
    
    public static double getPressedMoveDir() {
        final Minecraft lllllllllllIllIIlIIIlIIllIlIIIII = Minecraft.getMinecraft();
        double lllllllllllIllIIlIIIlIIllIIlllll = Math.atan2(lllllllllllIllIIlIIIlIIllIlIIIII.player.moveForward, lllllllllllIllIIlIIIlIIllIlIIIII.player.moveStrafing) / 3.141592653589793 * 180.0;
        if (lllllllllllIllIIlIIIlIIllIIlllll == 0.0 && lllllllllllIllIIlIIIlIIllIlIIIII.player.moveStrafing == 0.0f) {
            lllllllllllIllIIlIIIlIIllIIlllll = 90.0;
        }
        return (lllllllllllIllIIlIIIlIIllIIlllll += lllllllllllIllIIlIIIlIIllIlIIIII.player.rotationYaw) - 90.0;
    }
    
    public static double getMoveSpeed(final MoveEvent lllllllllllIllIIlIIIlIIllIlIllIl) {
        final Minecraft lllllllllllIllIIlIIIlIIllIlIllII = Minecraft.getMinecraft();
        final double lllllllllllIllIIlIIIlIIllIlIlIll = lllllllllllIllIIlIIIlIIllIlIllIl.getX();
        final double lllllllllllIllIIlIIIlIIllIlIlIlI = lllllllllllIllIIlIIIlIIllIlIllIl.getZ();
        return Math.sqrt(lllllllllllIllIIlIIIlIIllIlIlIll * lllllllllllIllIIlIIIlIIllIlIlIll + lllllllllllIllIIlIIIlIIllIlIlIlI * lllllllllllIllIIlIIIlIIllIlIlIlI);
    }
    
    public static void startFakePos() {
        Minecraft.getMinecraft();
        Minecraft.getMinecraft();
        Minecraft.getMinecraft();
        Minecraft.getMinecraft();
        MovementHelper.mc.player.setPosition(MovementHelper.mc.player.posX, MovementHelper.mc.player.posY + 0.3, MovementHelper.mc.player.posZ);
        Minecraft.getMinecraft();
        final double lllllllllllIllIIlIIIlIIlIllllIlI = MovementHelper.mc.player.posX;
        Minecraft.getMinecraft();
        final double lllllllllllIllIIlIIIlIIlIllllIIl = MovementHelper.mc.player.posY;
        Minecraft.getMinecraft();
        final double lllllllllllIllIIlIIIlIIlIllllIII = MovementHelper.mc.player.posZ;
        for (int lllllllllllIllIIlIIIlIIlIlllIlll = 0; lllllllllllIllIIlIIIlIIlIlllIlll < 3000; ++lllllllllllIllIIlIIIlIIlIlllIlll) {
            Minecraft.getMinecraft().getConnection().sendPacket(new CPacketPlayer.Position(lllllllllllIllIIlIIIlIIlIllllIlI, lllllllllllIllIIlIIIlIIlIllllIIl + 0.09999999999999, lllllllllllIllIIlIIIlIIlIllllIII, false));
            Minecraft.getMinecraft().getConnection().sendPacket(new CPacketPlayer.Position(lllllllllllIllIIlIIIlIIlIllllIlI, lllllllllllIllIIlIIIlIIlIllllIIl, lllllllllllIllIIlIIIlIIlIllllIII, true));
        }
        Minecraft.getMinecraft();
        MovementHelper.mc.player.motionY = 0.0;
    }
    
    public static void setSpeed(final double lllllllllllIllIIlIIIlIIlllIlIlIl, final float lllllllllllIllIIlIIIlIIlllIlIlII, final double lllllllllllIllIIlIIIlIIlllIlIIll, final double lllllllllllIllIIlIIIlIIlllIIlIIl) {
        double lllllllllllIllIIlIIIlIIlllIlIIIl = lllllllllllIllIIlIIIlIIlllIIlIIl;
        double lllllllllllIllIIlIIIlIIlllIlIIII = lllllllllllIllIIlIIIlIIlllIlIIll;
        float lllllllllllIllIIlIIIlIIlllIIllll = lllllllllllIllIIlIIIlIIlllIlIlII;
        if (lllllllllllIllIIlIIIlIIlllIlIIIl == 0.0 && lllllllllllIllIIlIIIlIIlllIlIIII == 0.0) {
            MovementHelper.mc.player.motionZ = 0.0;
            MovementHelper.mc.player.motionX = 0.0;
        }
        else {
            if (lllllllllllIllIIlIIIlIIlllIlIIIl != 0.0) {
                if (lllllllllllIllIIlIIIlIIlllIlIIII > 0.0) {
                    lllllllllllIllIIlIIIlIIlllIIllll += ((lllllllllllIllIIlIIIlIIlllIlIIIl > 0.0) ? -45 : 45);
                }
                else if (lllllllllllIllIIlIIIlIIlllIlIIII < 0.0) {
                    lllllllllllIllIIlIIIlIIlllIIllll += ((lllllllllllIllIIlIIIlIIlllIlIIIl > 0.0) ? 45 : -45);
                }
                lllllllllllIllIIlIIIlIIlllIlIIII = 0.0;
                if (lllllllllllIllIIlIIIlIIlllIlIIIl > 0.0) {
                    lllllllllllIllIIlIIIlIIlllIlIIIl = 1.0;
                }
                else if (lllllllllllIllIIlIIIlIIlllIlIIIl < 0.0) {
                    lllllllllllIllIIlIIIlIIlllIlIIIl = -1.0;
                }
            }
            final double lllllllllllIllIIlIIIlIIlllIIlllI = Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIlllIIllll + 90.0f));
            final double lllllllllllIllIIlIIIlIIlllIIllIl = Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIlllIIllll + 90.0f));
            MovementHelper.mc.player.motionX = lllllllllllIllIIlIIIlIIlllIlIIIl * lllllllllllIllIIlIIIlIIlllIlIlIl * lllllllllllIllIIlIIIlIIlllIIlllI + lllllllllllIllIIlIIIlIIlllIlIIII * lllllllllllIllIIlIIIlIIlllIlIlIl * lllllllllllIllIIlIIIlIIlllIIllIl;
            MovementHelper.mc.player.motionZ = lllllllllllIllIIlIIIlIIlllIlIIIl * lllllllllllIllIIlIIIlIIlllIlIlIl * lllllllllllIllIIlIIIlIIlllIIllIl - lllllllllllIllIIlIIIlIIlllIlIIII * lllllllllllIllIIlIIIlIIlllIlIlIl * lllllllllllIllIIlIIIlIIlllIIlllI;
        }
    }
    
    static {
        MovementHelper.WALK_SPEED = 0.221;
        MovementHelper.mc = Minecraft.getMinecraft();
    }
    
    public static void strafe() {
        if (MovementHelper.mc.gameSettings.keyBindBack.isKeyDown()) {
            return;
        }
        strafe(getSpeed());
    }
    
    public static float getEntityDirection(final EntityLivingBase lllllllllllIllIIlIIIlIlIIlIlIIll) {
        float lllllllllllIllIIlIIIlIlIIlIlIlIl = lllllllllllIllIIlIIIlIlIIlIlIIll.rotationYaw;
        if (lllllllllllIllIIlIIIlIlIIlIlIIll.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlIlIl += 180.0f;
        }
        float lllllllllllIllIIlIIIlIlIIlIlIlII = 1.0f;
        if (lllllllllllIllIIlIIIlIlIIlIlIIll.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlIlII = -0.5f;
        }
        else if (lllllllllllIllIIlIIIlIlIIlIlIIll.moveForward > 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlIlII = 0.5f;
        }
        if (lllllllllllIllIIlIIIlIlIIlIlIIll.moveStrafing > 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlIlIl -= 90.0f * lllllllllllIllIIlIIIlIlIIlIlIlII;
        }
        if (lllllllllllIllIIlIIIlIlIIlIlIIll.moveStrafing < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlIlIl += 90.0f * lllllllllllIllIIlIIIlIlIIlIlIlII;
        }
        return (float)Math.toRadians(lllllllllllIllIIlIIIlIlIIlIlIlIl);
    }
    
    public static boolean isOnGround() {
        return MovementHelper.mc.player.onGround && MovementHelper.mc.player.isCollidedVertically;
    }
    
    public static float getDirection() {
        float lllllllllllIllIIlIIIlIlIIIlIIlll = MovementHelper.mc.player.rotationYaw;
        float lllllllllllIllIIlIIIlIlIIIlIIllI = 0.0f;
        final MovementInput movementInput = MovementHelper.mc.player.movementInput;
        if (MovementInput.moveForward > 0.0f) {
            lllllllllllIllIIlIIIlIlIIIlIIllI = 1.0f;
        }
        final MovementInput movementInput2 = MovementHelper.mc.player.movementInput;
        if (MovementInput.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIIlIIllI = -1.0f;
        }
        if (lllllllllllIllIIlIIIlIlIIIlIIllI == 0.0f) {
            final MovementInput movementInput3 = MovementHelper.mc.player.movementInput;
            if (MovementInput.moveStrafe > 0.0f) {
                lllllllllllIllIIlIIIlIlIIIlIIlll -= 90.0f;
            }
            final MovementInput movementInput4 = MovementHelper.mc.player.movementInput;
            if (MovementInput.moveStrafe < 0.0f) {
                lllllllllllIllIIlIIIlIlIIIlIIlll += 90.0f;
            }
        }
        else {
            final MovementInput movementInput5 = MovementHelper.mc.player.movementInput;
            if (MovementInput.moveStrafe > 0.0f) {
                lllllllllllIllIIlIIIlIlIIIlIIlll -= 45.0f * lllllllllllIllIIlIIIlIlIIIlIIllI;
            }
            final MovementInput movementInput6 = MovementHelper.mc.player.movementInput;
            if (MovementInput.moveStrafe < 0.0f) {
                lllllllllllIllIIlIIIlIlIIIlIIlll += 45.0f * lllllllllllIllIIlIIIlIlIIIlIIllI;
            }
        }
        if (lllllllllllIllIIlIIIlIlIIIlIIllI < 0.0f) {
            lllllllllllIllIIlIIIlIlIIIlIIlll -= 180.0f;
        }
        return (float)Math.toRadians(lllllllllllIllIIlIIIlIlIIIlIIlll);
    }
    
    public static boolean moveKeysDown() {
        final Minecraft lllllllllllIllIIlIIIlIIllIlIIlII = Minecraft.getMinecraft();
        return MovementInput.moveForward != 0.0f || MovementInput.moveStrafe != 0.0f;
    }
    
    public static void setMotion(final MoveEvent lllllllllllIllIIlIIIlIIlllllIIlI, final double lllllllllllIllIIlIIIlIIllllIIlll, final float lllllllllllIllIIlIIIlIIllllIIllI, final double lllllllllllIllIIlIIIlIIllllIllll, final double lllllllllllIllIIlIIIlIIllllIIlII) {
        double lllllllllllIllIIlIIIlIIllllIllIl = lllllllllllIllIIlIIIlIIllllIIlII;
        double lllllllllllIllIIlIIIlIIllllIllII = lllllllllllIllIIlIIIlIIllllIllll;
        float lllllllllllIllIIlIIIlIIllllIlIll = lllllllllllIllIIlIIIlIIllllIIllI;
        if (lllllllllllIllIIlIIIlIIllllIIlII != 0.0) {
            if (lllllllllllIllIIlIIIlIIllllIllll > 0.0) {
                lllllllllllIllIIlIIIlIIllllIlIll = lllllllllllIllIIlIIIlIIllllIIllI + ((lllllllllllIllIIlIIIlIIllllIIlII > 0.0) ? -45 : 45);
            }
            else if (lllllllllllIllIIlIIIlIIllllIllll < 0.0) {
                lllllllllllIllIIlIIIlIIllllIlIll = lllllllllllIllIIlIIIlIIllllIIllI + ((lllllllllllIllIIlIIIlIIllllIIlII > 0.0) ? 45 : -45);
            }
            lllllllllllIllIIlIIIlIIllllIllII = 0.0;
            if (lllllllllllIllIIlIIIlIIllllIIlII > 0.0) {
                lllllllllllIllIIlIIIlIIllllIllIl = 1.0;
            }
            else if (lllllllllllIllIIlIIIlIIllllIIlII < 0.0) {
                lllllllllllIllIIlIIIlIIllllIllIl = -1.0;
            }
        }
        if (lllllllllllIllIIlIIIlIIllllIllII > 0.0) {
            lllllllllllIllIIlIIIlIIllllIllII = 1.0;
        }
        else if (lllllllllllIllIIlIIIlIIllllIllII < 0.0) {
            lllllllllllIllIIlIIIlIIllllIllII = -1.0;
        }
        final double lllllllllllIllIIlIIIlIIllllIlIlI = Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIllllIlIll + 90.0f));
        final double lllllllllllIllIIlIIIlIIllllIlIIl = Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIllllIlIll + 90.0f));
        lllllllllllIllIIlIIIlIIlllllIIlI.setX(lllllllllllIllIIlIIIlIIllllIllIl * lllllllllllIllIIlIIIlIIllllIIlll * lllllllllllIllIIlIIIlIIllllIlIlI + lllllllllllIllIIlIIIlIIllllIllII * lllllllllllIllIIlIIIlIIllllIIlll * lllllllllllIllIIlIIIlIIllllIlIIl);
        lllllllllllIllIIlIIIlIIlllllIIlI.setZ(lllllllllllIllIIlIIIlIIllllIllIl * lllllllllllIllIIlIIIlIIllllIIlll * lllllllllllIllIIlIIIlIIllllIlIIl - lllllllllllIllIIlIIIlIIllllIllII * lllllllllllIllIIlIIIlIIllllIIlll * lllllllllllIllIIlIIIlIIllllIlIlI);
    }
    
    public static double getZDirAt(final float lllllllllllIllIIlIIIlIlIIIIIlIll) {
        final Minecraft lllllllllllIllIIlIIIlIlIIIIIllIl = Minecraft.getMinecraft();
        double lllllllllllIllIIlIIIlIlIIIIIllII = 90.0;
        return Math.sin((lllllllllllIllIIlIIIlIlIIIIIllII += lllllllllllIllIIlIIIlIlIIIIIlIll) * 3.141592653589793 / 180.0);
    }
    
    public static boolean isMoving() {
        return MovementHelper.mc.player != null && (MovementInput.moveForward != 0.0f || MovementInput.moveStrafe != 0.0f);
    }
    
    public static void calculateSilentMove(final EventStrafe lllllllllllIllIIlIIIlIlIIIlllIlI, final float lllllllllllIllIIlIIIlIlIIIlllIIl) {
        final float lllllllllllIllIIlIIIlIlIIlIIIIll = lllllllllllIllIIlIIIlIlIIIlllIlI.getStrafe();
        final float lllllllllllIllIIlIIIlIlIIlIIIIlI = lllllllllllIllIIlIIIlIlIIIlllIlI.getForward();
        final float lllllllllllIllIIlIIIlIlIIlIIIIIl = lllllllllllIllIIlIIIlIlIIIlllIlI.getFriction();
        final int lllllllllllIllIIlIIIlIlIIlIIIIII = (int)((MathHelper.wrapDegrees(MovementHelper.mc.player.rotationYaw - lllllllllllIllIIlIIIlIlIIIlllIIl - 23.5f - 135.0f) + 180.0f) / 45.0f);
        float lllllllllllIllIIlIIIlIlIIIllllll = 0.0f;
        float lllllllllllIllIIlIIIlIlIIIlllllI = 0.0f;
        switch (lllllllllllIllIIlIIIlIlIIlIIIIII) {
            case 0: {
                lllllllllllIllIIlIIIlIlIIIllllll = lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI = lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
            case 1: {
                lllllllllllIllIIlIIIlIlIIIllllll += lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI -= lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIllllll += lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI += lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
            case 2: {
                lllllllllllIllIIlIIIlIlIIIllllll = lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI = -lllllllllllIllIIlIIIlIlIIlIIIIlI;
                break;
            }
            case 3: {
                lllllllllllIllIIlIIIlIlIIIllllll -= lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI -= lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIllllll += lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI -= lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
            case 4: {
                lllllllllllIllIIlIIIlIlIIIllllll = -lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI = -lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
            case 5: {
                lllllllllllIllIIlIIIlIlIIIllllll -= lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI += lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIllllll -= lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI -= lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
            case 6: {
                lllllllllllIllIIlIIIlIlIIIllllll = -lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI = lllllllllllIllIIlIIIlIlIIlIIIIlI;
                break;
            }
            case 7: {
                lllllllllllIllIIlIIIlIlIIIllllll += lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIlllllI += lllllllllllIllIIlIIIlIlIIlIIIIlI;
                lllllllllllIllIIlIIIlIlIIIllllll -= lllllllllllIllIIlIIIlIlIIlIIIIll;
                lllllllllllIllIIlIIIlIlIIIlllllI += lllllllllllIllIIlIIIlIlIIlIIIIll;
                break;
            }
        }
        if (lllllllllllIllIIlIIIlIlIIIllllll > 1.0f || (lllllllllllIllIIlIIIlIlIIIllllll < 0.9f && lllllllllllIllIIlIIIlIlIIIllllll > 0.3f) || lllllllllllIllIIlIIIlIlIIIllllll < -1.0f || (lllllllllllIllIIlIIIlIlIIIllllll > -0.9f && lllllllllllIllIIlIIIlIlIIIllllll < -0.3f)) {
            lllllllllllIllIIlIIIlIlIIIllllll *= 0.5f;
        }
        if (lllllllllllIllIIlIIIlIlIIIlllllI > 1.0f || (lllllllllllIllIIlIIIlIlIIIlllllI < 0.9f && lllllllllllIllIIlIIIlIlIIIlllllI > 0.3f) || lllllllllllIllIIlIIIlIlIIIlllllI < -1.0f || (lllllllllllIllIIlIIIlIlIIIlllllI > -0.9f && lllllllllllIllIIlIIIlIlIIIlllllI < -0.3f)) {
            lllllllllllIllIIlIIIlIlIIIlllllI *= 0.5f;
        }
        float lllllllllllIllIIlIIIlIlIIIllllIl = lllllllllllIllIIlIIIlIlIIIlllllI * lllllllllllIllIIlIIIlIlIIIlllllI + lllllllllllIllIIlIIIlIlIIIllllll * lllllllllllIllIIlIIIlIlIIIllllll;
        if (lllllllllllIllIIlIIIlIlIIIllllIl >= 1.0E-4f) {
            lllllllllllIllIIlIIIlIlIIIllllIl = (float)(lllllllllllIllIIlIIIlIlIIlIIIIIl / Math.max(1.0, Math.sqrt(lllllllllllIllIIlIIIlIlIIIllllIl)));
            lllllllllllIllIIlIIIlIlIIIlllllI *= lllllllllllIllIIlIIIlIlIIIllllIl;
            lllllllllllIllIIlIIIlIlIIIllllll *= lllllllllllIllIIlIIIlIlIIIllllIl;
            final float lllllllllllIllIIlIIIlIlIIIllllII = MathHelper.sin((float)(lllllllllllIllIIlIIIlIlIIIlllIIl * 3.141592653589793 / 180.0));
            final float lllllllllllIllIIlIIIlIlIIIlllIll = MathHelper.cos((float)(lllllllllllIllIIlIIIlIlIIIlllIIl * 3.141592653589793 / 180.0));
            final EntityPlayerSP player = MovementHelper.mc.player;
            player.motionX += lllllllllllIllIIlIIIlIlIIIlllllI * lllllllllllIllIIlIIIlIlIIIlllIll - lllllllllllIllIIlIIIlIlIIIllllll * lllllllllllIllIIlIIIlIlIIIllllII;
            final EntityPlayerSP player2 = MovementHelper.mc.player;
            player2.motionZ += lllllllllllIllIIlIIIlIlIIIllllll * lllllllllllIllIIlIIIlIlIIIlllIll + lllllllllllIllIIlIIIlIlIIIlllllI * lllllllllllIllIIlIIIlIlIIIllllII;
        }
    }
    
    public static void setSpeed(final double lllllllllllIllIIlIIIlIIllIllllll) {
        double lllllllllllIllIIlIIIlIIllIlllllI = MovementInput.moveForward;
        double lllllllllllIllIIlIIIlIIllIllllIl = MovementInput.moveStrafe;
        float lllllllllllIllIIlIIIlIIllIllllII = MovementHelper.mc.player.rotationYaw;
        if (lllllllllllIllIIlIIIlIIllIlllllI == 0.0 && lllllllllllIllIIlIIIlIIllIllllIl == 0.0) {
            MovementHelper.mc.player.motionX = 0.0;
            MovementHelper.mc.player.motionZ = 0.0;
        }
        else {
            if (lllllllllllIllIIlIIIlIIllIlllllI != 0.0) {
                if (lllllllllllIllIIlIIIlIIllIllllIl > 0.0) {
                    lllllllllllIllIIlIIIlIIllIllllII += ((lllllllllllIllIIlIIIlIIllIlllllI > 0.0) ? -45 : 45);
                }
                else if (lllllllllllIllIIlIIIlIIllIllllIl < 0.0) {
                    lllllllllllIllIIlIIIlIIllIllllII += ((lllllllllllIllIIlIIIlIIllIlllllI > 0.0) ? 45 : -45);
                }
                lllllllllllIllIIlIIIlIIllIllllIl = 0.0;
                if (lllllllllllIllIIlIIIlIIllIlllllI > 0.0) {
                    lllllllllllIllIIlIIIlIIllIlllllI = 1.0;
                }
                else if (lllllllllllIllIIlIIIlIIllIlllllI < 0.0) {
                    lllllllllllIllIIlIIIlIIllIlllllI = -1.0;
                }
            }
            MovementHelper.mc.player.motionX = lllllllllllIllIIlIIIlIIllIlllllI * lllllllllllIllIIlIIIlIIllIllllll * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIllIllllII + 90.0f)) + lllllllllllIllIIlIIIlIIllIllllIl * lllllllllllIllIIlIIIlIIllIllllll * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIllIllllII + 90.0f));
            MovementHelper.mc.player.motionZ = lllllllllllIllIIlIIIlIIllIlllllI * lllllllllllIllIIlIIIlIIllIllllll * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIIllIllllII + 90.0f)) - lllllllllllIllIIlIIIlIIllIllllIl * lllllllllllIllIIlIIIlIIllIllllll * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIIllIllllII + 90.0f));
        }
    }
    
    public static void strafe(final float lllllllllllIllIIlIIIlIIllIllIIll) {
        if (!isMoving()) {
            return;
        }
        final double lllllllllllIllIIlIIIlIIllIllIlII = getDirection();
        MovementHelper.mc.player.motionX = -Math.sin(lllllllllllIllIIlIIIlIIllIllIlII) * lllllllllllIllIIlIIIlIIllIllIIll;
        MovementHelper.mc.player.motionZ = Math.cos(lllllllllllIllIIlIIIlIIllIllIlII) * lllllllllllIllIIlIIIlIIllIllIIll;
    }
    
    public static int getJumpBoostModifier() {
        final PotionEffect lllllllllllIllIIlIIIlIlIlIIIlIII = MovementHelper.mc.player.getActivePotionEffect(MobEffects.JUMP_BOOST);
        if (lllllllllllIllIIlIIIlIlIlIIIlIII != null) {
            return lllllllllllIllIIlIIIlIlIlIIIlIII.getAmplifier() + 1;
        }
        return 0;
    }
    
    public static float getPlayerDirection() {
        float lllllllllllIllIIlIIIlIlIIlIlllIl = MovementHelper.mc.player.rotationYaw;
        if (MovementHelper.mc.player.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlllIl += 180.0f;
        }
        float lllllllllllIllIIlIIIlIlIIlIlllII = 1.0f;
        if (MovementHelper.mc.player.moveForward < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlllII = -0.5f;
        }
        else if (MovementHelper.mc.player.moveForward > 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlllII = 0.5f;
        }
        if (MovementHelper.mc.player.moveStrafing > 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlllIl -= 90.0f * lllllllllllIllIIlIIIlIlIIlIlllII;
        }
        if (MovementHelper.mc.player.moveStrafing < 0.0f) {
            lllllllllllIllIIlIIIlIlIIlIlllIl += 90.0f * lllllllllllIllIIlIIIlIlIIlIlllII;
        }
        return (float)Math.toRadians(lllllllllllIllIIlIIIlIlIIlIlllIl);
    }
    
    public static double getPlayerMoveDir() {
        final Minecraft lllllllllllIllIIlIIIlIIllIIllIII = Minecraft.getMinecraft();
        final double lllllllllllIllIIlIIIlIIllIIlIlll = lllllllllllIllIIlIIIlIIllIIllIII.player.motionX;
        final double lllllllllllIllIIlIIIlIIllIIlIllI = lllllllllllIllIIlIIIlIIllIIllIII.player.motionZ;
        final double lllllllllllIllIIlIIIlIIllIIlIlIl = Math.atan2(lllllllllllIllIIlIIIlIIllIIlIlll, lllllllllllIllIIlIIIlIIllIIlIllI) / 3.141592653589793 * 180.0;
        return -lllllllllllIllIIlIIIlIIllIIlIlIl;
    }
    
    public static void setEventSpeed(final MoveEvent lllllllllllIllIIlIIIlIlIIlllllII, final double lllllllllllIllIIlIIIlIlIlIIIIIII) {
        final MovementInput movementInput = MovementHelper.mc.player.movementInput;
        double lllllllllllIllIIlIIIlIlIIlllllll = MovementInput.moveForward;
        final MovementInput movementInput2 = MovementHelper.mc.player.movementInput;
        double lllllllllllIllIIlIIIlIlIIllllllI = MovementInput.moveStrafe;
        float lllllllllllIllIIlIIIlIlIIlllllIl = MovementHelper.mc.player.rotationYaw;
        if (lllllllllllIllIIlIIIlIlIIlllllll == 0.0 && lllllllllllIllIIlIIIlIlIIllllllI == 0.0) {
            lllllllllllIllIIlIIIlIlIIlllllII.setX(0.0);
            lllllllllllIllIIlIIIlIlIIlllllII.setZ(0.0);
        }
        else {
            if (lllllllllllIllIIlIIIlIlIIlllllll != 0.0) {
                if (lllllllllllIllIIlIIIlIlIIllllllI > 0.0) {
                    lllllllllllIllIIlIIIlIlIIlllllIl += ((lllllllllllIllIIlIIIlIlIIlllllll > 0.0) ? -45 : 45);
                }
                else if (lllllllllllIllIIlIIIlIlIIllllllI < 0.0) {
                    lllllllllllIllIIlIIIlIlIIlllllIl += ((lllllllllllIllIIlIIIlIlIIlllllll > 0.0) ? 45 : -45);
                }
                lllllllllllIllIIlIIIlIlIIllllllI = 0.0;
                if (lllllllllllIllIIlIIIlIlIIlllllll > 0.0) {
                    lllllllllllIllIIlIIIlIlIIlllllll = 1.0;
                }
                else if (lllllllllllIllIIlIIIlIlIIlllllll < 0.0) {
                    lllllllllllIllIIlIIIlIlIIlllllll = -1.0;
                }
            }
            lllllllllllIllIIlIIIlIlIIlllllII.setX(lllllllllllIllIIlIIIlIlIIlllllll * lllllllllllIllIIlIIIlIlIlIIIIIII * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIlIIlllllIl + 90.0f)) + lllllllllllIllIIlIIIlIlIIllllllI * lllllllllllIllIIlIIIlIlIlIIIIIII * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIlIIlllllIl + 90.0f)));
            lllllllllllIllIIlIIIlIlIIlllllII.setZ(lllllllllllIllIIlIIIlIlIIlllllll * lllllllllllIllIIlIIIlIlIlIIIIIII * Math.sin(Math.toRadians(lllllllllllIllIIlIIIlIlIIlllllIl + 90.0f)) - lllllllllllIllIIlIIIlIlIIllllllI * lllllllllllIllIIlIIIlIlIlIIIIIII * Math.cos(Math.toRadians(lllllllllllIllIIlIIIlIlIIlllllIl + 90.0f)));
        }
    }
    
    public static double getXDirAt(final float lllllllllllIllIIlIIIlIlIIIIlIlll) {
        final Minecraft lllllllllllIllIIlIIIlIlIIIIlIllI = Minecraft.getMinecraft();
        double lllllllllllIllIIlIIIlIlIIIIlIlIl = 90.0;
        return Math.cos((lllllllllllIllIIlIIIlIlIIIIlIlIl += lllllllllllIllIIlIIIlIlIIIIlIlll) * 3.141592653589793 / 180.0);
    }
}
