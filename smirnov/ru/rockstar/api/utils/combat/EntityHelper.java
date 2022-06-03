// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.combat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.api.utils.Helper;

public class EntityHelper implements Helper
{
    public static boolean isTeamWithYou(final EntityLivingBase llllllllllllIIIIlIIlIIIIIIIIIlll) {
        if (EntityHelper.mc.player == null || llllllllllllIIIIlIIlIIIIIIIIIlll == null || EntityHelper.mc.player.getDisplayName() == null || llllllllllllIIIIlIIlIIIIIIIIIlll.getDisplayName() == null) {
            return false;
        }
        if (EntityHelper.mc.player.getTeam() != null && llllllllllllIIIIlIIlIIIIIIIIIlll.getTeam() != null && EntityHelper.mc.player.getTeam().isSameTeam(llllllllllllIIIIlIIlIIIIIIIIIlll.getTeam())) {
            return true;
        }
        final String llllllllllllIIIIlIIlIIIIIIIIIllI = llllllllllllIIIIlIIlIIIIIIIIIlll.getDisplayName().getFormattedText().replace("§r", "");
        final String llllllllllllIIIIlIIlIIIIIIIIIlIl = EntityHelper.mc.player.getDisplayName().getFormattedText().replace("§r", "");
        return llllllllllllIIIIlIIlIIIIIIIIIllI.startsWith("§" + llllllllllllIIIIlIIlIIIIIIIIIlIl.charAt(1));
    }
    
    public static boolean checkArmor(final Entity llllllllllllIIIIlIIlIIIIIIIIIIII) {
        return ((EntityLivingBase)llllllllllllIIIIlIIlIIIIIIIIIIII).getTotalArmorValue() < 6;
    }
    
    public static double getDistance(final double llllllllllllIIIIlIIlIIIIIlIlIIIl, final double llllllllllllIIIIlIIlIIIIIlIIIllI, final double llllllllllllIIIIlIIlIIIIIlIIllll, final double llllllllllllIIIIlIIlIIIIIlIIlllI, final double llllllllllllIIIIlIIlIIIIIlIIIIll, final double llllllllllllIIIIlIIlIIIIIlIIIIlI) {
        final double llllllllllllIIIIlIIlIIIIIlIIlIll = llllllllllllIIIIlIIlIIIIIlIlIIIl - llllllllllllIIIIlIIlIIIIIlIIlllI;
        final double llllllllllllIIIIlIIlIIIIIlIIlIlI = llllllllllllIIIIlIIlIIIIIlIIIllI - llllllllllllIIIIlIIlIIIIIlIIIIll;
        final double llllllllllllIIIIlIIlIIIIIlIIlIIl = llllllllllllIIIIlIIlIIIIIlIIllll - llllllllllllIIIIlIIlIIIIIlIIIIlI;
        return Math.sqrt(llllllllllllIIIIlIIlIIIIIlIIlIll * llllllllllllIIIIlIIlIIIIIlIIlIll + llllllllllllIIIIlIIlIIIIIlIIlIlI * llllllllllllIIIIlIIlIIIIIlIIlIlI + llllllllllllIIIIlIIlIIIIIlIIlIIl * llllllllllllIIIIlIIlIIIIIlIIlIIl);
    }
    
    public static Entity rayCast(final Entity llllllllllllIIIIlIIlIIIIIIIlIllI, double llllllllllllIIIIlIIlIIIIIIIlIlIl) {
        final Vec3d llllllllllllIIIIlIIlIIIIIIIlllll = llllllllllllIIIIlIIlIIIIIIIlIllI.getPositionVector().add(new Vec3d(0.0, llllllllllllIIIIlIIlIIIIIIIlIllI.getEyeHeight(), 0.0));
        final Vec3d llllllllllllIIIIlIIlIIIIIIIllllI = EntityHelper.mc.player.getPositionVector().add(new Vec3d(0.0, EntityHelper.mc.player.getEyeHeight(), 0.0));
        final AxisAlignedBB llllllllllllIIIIlIIlIIIIIIIlllIl = EntityHelper.mc.player.getEntityBoundingBox().addCoord(llllllllllllIIIIlIIlIIIIIIIlllll.xCoord - llllllllllllIIIIlIIlIIIIIIIllllI.xCoord, llllllllllllIIIIlIIlIIIIIIIlllll.yCoord - llllllllllllIIIIlIIlIIIIIIIllllI.yCoord, llllllllllllIIIIlIIlIIIIIIIlllll.zCoord - llllllllllllIIIIlIIlIIIIIIIllllI.zCoord).expand(1.0, 1.0, 1.0);
        Entity llllllllllllIIIIlIIlIIIIIIIlllII = null;
        for (final Entity llllllllllllIIIIlIIlIIIIIIIllIll : EntityHelper.mc.world.getEntitiesWithinAABBExcludingEntity(EntityHelper.mc.player, llllllllllllIIIIlIIlIIIIIIIlllIl)) {
            if (llllllllllllIIIIlIIlIIIIIIIllIll.canBeCollidedWith() && llllllllllllIIIIlIIlIIIIIIIllIll instanceof EntityLivingBase) {
                final float llllllllllllIIIIlIIlIIIIIIIllIlI = llllllllllllIIIIlIIlIIIIIIIllIll.getCollisionBorderSize();
                final AxisAlignedBB llllllllllllIIIIlIIlIIIIIIIllIIl = llllllllllllIIIIlIIlIIIIIIIllIll.getEntityBoundingBox().expand(llllllllllllIIIIlIIlIIIIIIIllIlI, llllllllllllIIIIlIIlIIIIIIIllIlI, llllllllllllIIIIlIIlIIIIIIIllIlI);
                final RayTraceResult llllllllllllIIIIlIIlIIIIIIIllIII = llllllllllllIIIIlIIlIIIIIIIllIIl.calculateIntercept(llllllllllllIIIIlIIlIIIIIIIllllI, llllllllllllIIIIlIIlIIIIIIIlllll);
                if (llllllllllllIIIIlIIlIIIIIIIllIIl.isVecInside(llllllllllllIIIIlIIlIIIIIIIllllI)) {
                    if (llllllllllllIIIIlIIlIIIIIIIlIlIl < 0.0) {
                        continue;
                    }
                    llllllllllllIIIIlIIlIIIIIIIlllII = llllllllllllIIIIlIIlIIIIIIIllIll;
                    llllllllllllIIIIlIIlIIIIIIIlIlIl = 0.0;
                }
                else {
                    if (llllllllllllIIIIlIIlIIIIIIIllIII == null) {
                        continue;
                    }
                    final double llllllllllllIIIIlIIlIIIIIIIlIlll = llllllllllllIIIIlIIlIIIIIIIllllI.distanceTo(llllllllllllIIIIlIIlIIIIIIIllIII.hitVec);
                    if (llllllllllllIIIIlIIlIIIIIIIlIlIl != 0.0 && llllllllllllIIIIlIIlIIIIIIIlIlll >= llllllllllllIIIIlIIlIIIIIIIlIlIl) {
                        continue;
                    }
                    llllllllllllIIIIlIIlIIIIIIIlllII = llllllllllllIIIIlIIlIIIIIIIllIll;
                    llllllllllllIIIIlIIlIIIIIIIlIlIl = llllllllllllIIIIlIIlIIIIIIIlIlll;
                }
            }
        }
        return llllllllllllIIIIlIIlIIIIIIIlllII;
    }
    
    public static double getDistanceOfEntityToBlock(final Entity llllllllllllIIIIlIIIllllllllIlll, final BlockPos llllllllllllIIIIlIIIlllllllllIII) {
        return getDistance(llllllllllllIIIIlIIIllllllllIlll.posX, llllllllllllIIIIlIIIllllllllIlll.posY, llllllllllllIIIIlIIIllllllllIlll.posZ, llllllllllllIIIIlIIIlllllllllIII.getX(), llllllllllllIIIIlIIIlllllllllIII.getY(), llllllllllllIIIIlIIIlllllllllIII.getZ());
    }
    
    public static double getDistance(final double llllllllllllIIIIlIIlIIIIIIllIIll, final double llllllllllllIIIIlIIlIIIIIIllIIlI, final double llllllllllllIIIIlIIlIIIIIIllIlll, final double llllllllllllIIIIlIIlIIIIIIllIIII) {
        final double llllllllllllIIIIlIIlIIIIIIllIlIl = llllllllllllIIIIlIIlIIIIIIllIIll - llllllllllllIIIIlIIlIIIIIIllIlll;
        final double llllllllllllIIIIlIIlIIIIIIllIlII = llllllllllllIIIIlIIlIIIIIIllIIlI - llllllllllllIIIIlIIlIIIIIIllIIII;
        return Math.hypot(llllllllllllIIIIlIIlIIIIIIllIlIl, llllllllllllIIIIlIIlIIIIIIllIlII);
    }
    
    public static int getPing(final EntityPlayer llllllllllllIIIIlIIIllllllllllII) {
        return EntityHelper.mc.player.connection.getPlayerInfo(llllllllllllIIIIlIIIllllllllllII.getUniqueID()).getResponseTime();
    }
}
