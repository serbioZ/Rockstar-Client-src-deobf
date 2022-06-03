// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import com.mojang.authlib.GameProfile;
import net.minecraft.world.World;

public class EntityOtherPlayerMP extends AbstractClientPlayer
{
    private /* synthetic */ double otherPlayerMPY;
    private /* synthetic */ double otherPlayerMPZ;
    private /* synthetic */ double otherPlayerMPYaw;
    private /* synthetic */ double otherPlayerMPX;
    private /* synthetic */ double otherPlayerMPPitch;
    private /* synthetic */ int otherPlayerMPPosRotationIncrements;
    
    public EntityOtherPlayerMP(final World lllllllllllIllllllIllIIlIllllIIl, final GameProfile lllllllllllIllllllIllIIlIllllIII) {
        super(lllllllllllIllllllIllIIlIllllIIl, lllllllllllIllllllIllIIlIllllIII);
        this.stepHeight = 1.0f;
        this.noClip = true;
        this.renderOffsetY = 0.25f;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            final double lllllllllllIllllllIllIIlIlIIIIlI = this.posX + (this.otherPlayerMPX - this.posX) / this.otherPlayerMPPosRotationIncrements;
            final double lllllllllllIllllllIllIIlIlIIIIIl = this.posY + (this.otherPlayerMPY - this.posY) / this.otherPlayerMPPosRotationIncrements;
            final double lllllllllllIllllllIllIIlIlIIIIII = this.posZ + (this.otherPlayerMPZ - this.posZ) / this.otherPlayerMPPosRotationIncrements;
            double lllllllllllIllllllIllIIlIIllllll;
            for (lllllllllllIllllllIllIIlIIllllll = this.otherPlayerMPYaw - this.rotationYaw; lllllllllllIllllllIllIIlIIllllll < -180.0; lllllllllllIllllllIllIIlIIllllll += 360.0) {}
            while (lllllllllllIllllllIllIIlIIllllll >= 180.0) {
                lllllllllllIllllllIllIIlIIllllll -= 360.0;
            }
            this.rotationYaw += (float)(lllllllllllIllllllIllIIlIIllllll / this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch += (float)((this.otherPlayerMPPitch - this.rotationPitch) / this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(lllllllllllIllllllIllIIlIlIIIIlI, lllllllllllIllllllIllIIlIlIIIIIl, lllllllllllIllllllIllIIlIlIIIIII);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float lllllllllllIllllllIllIIlIIlllllI = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float lllllllllllIllllllIllIIlIIllllIl = (float)Math.atan(-this.motionY * 0.20000000298023224) * 15.0f;
        if (lllllllllllIllllllIllIIlIIlllllI > 0.1f) {
            lllllllllllIllllllIllIIlIIlllllI = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllIllllllIllIIlIIlllllI = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllIllllllIllIIlIIllllIl = 0.0f;
        }
        this.cameraYaw += (lllllllllllIllllllIllIIlIIlllllI - this.cameraYaw) * 0.4f;
        this.cameraPitch += (lllllllllllIllllllIllIIlIIllllIl - this.cameraPitch) * 0.8f;
        this.world.theProfiler.startSection("push");
        this.collideWithNearbyEntities();
        this.world.theProfiler.endSection();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllIllllllIllIIlIllIllIl, final float lllllllllllIllllllIllIIlIllIllII) {
        return true;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllIllllllIllIIlIIllIIIl, final String lllllllllllIllllllIllIIlIIllIIII) {
        return false;
    }
    
    @Override
    public void onUpdate() {
        this.renderOffsetY = 0.0f;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lllllllllllIllllllIllIIlIlIlIIII = this.posX - this.prevPosX;
        final double lllllllllllIllllllIllIIlIlIIllll = this.posZ - this.prevPosZ;
        float lllllllllllIllllllIllIIlIlIIlllI = MathHelper.sqrt(lllllllllllIllllllIllIIlIlIlIIII * lllllllllllIllllllIllIIlIlIlIIII + lllllllllllIllllllIllIIlIlIIllll * lllllllllllIllllllIllIIlIlIIllll) * 4.0f;
        if (lllllllllllIllllllIllIIlIlIIlllI > 1.0f) {
            lllllllllllIllllllIllIIlIlIIlllI = 1.0f;
        }
        this.limbSwingAmount += (lllllllllllIllllllIllIIlIlIIlllI - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllIllllllIllIIlIlllIIll) {
        double lllllllllllIllllllIllIIlIlllIIlI = this.getEntityBoundingBox().getAverageEdgeLength() * 10.0;
        if (Double.isNaN(lllllllllllIllllllIllIIlIlllIIlI)) {
            lllllllllllIllllllIllIIlIlllIIlI = 1.0;
        }
        lllllllllllIllllllIllIIlIlllIIlI = lllllllllllIllllllIllIIlIlllIIlI * 64.0 * getRenderDistanceWeight();
        return lllllllllllIllllllIllIIlIlllIIll < lllllllllllIllllllIllIIlIlllIIlI * lllllllllllIllllllIllIIlIlllIIlI;
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    @Override
    public void setPositionAndRotationDirect(final double lllllllllllIllllllIllIIlIllIIIll, final double lllllllllllIllllllIllIIlIlIllIlI, final double lllllllllllIllllllIllIIlIlIllIIl, final float lllllllllllIllllllIllIIlIllIIIII, final float lllllllllllIllllllIllIIlIlIlllll, final int lllllllllllIllllllIllIIlIlIllllI, final boolean lllllllllllIllllllIllIIlIlIlllIl) {
        this.otherPlayerMPX = lllllllllllIllllllIllIIlIllIIIll;
        this.otherPlayerMPY = lllllllllllIllllllIllIIlIlIllIlI;
        this.otherPlayerMPZ = lllllllllllIllllllIllIIlIlIllIIl;
        this.otherPlayerMPYaw = lllllllllllIllllllIllIIlIllIIIII;
        this.otherPlayerMPPitch = lllllllllllIllllllIllIIlIlIlllll;
        this.otherPlayerMPPosRotationIncrements = lllllllllllIllllllIllIIlIlIllllI;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllIllllllIllIIlIIllIlII) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(lllllllllllIllllllIllIIlIIllIlII);
    }
}
