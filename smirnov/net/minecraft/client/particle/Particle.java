// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Particle
{
    protected /* synthetic */ float particleGravity;
    protected /* synthetic */ double prevPosZ;
    protected /* synthetic */ int particleMaxAge;
    protected /* synthetic */ double posY;
    protected /* synthetic */ TextureAtlasSprite particleTexture;
    protected /* synthetic */ Random rand;
    protected /* synthetic */ float particleTextureJitterY;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ int particleAge;
    public static /* synthetic */ double interpPosZ;
    protected /* synthetic */ double posZ;
    protected /* synthetic */ int particleTextureIndexX;
    public static /* synthetic */ double interpPosY;
    private static final /* synthetic */ AxisAlignedBB EMPTY_AABB;
    protected /* synthetic */ double motionZ;
    protected /* synthetic */ float width;
    protected /* synthetic */ float particleAlpha;
    protected /* synthetic */ float particleBlue;
    protected /* synthetic */ boolean isCollided;
    protected /* synthetic */ double prevPosX;
    protected /* synthetic */ double motionY;
    protected /* synthetic */ float particleRed;
    protected /* synthetic */ boolean canCollide;
    protected /* synthetic */ float particleAngle;
    protected /* synthetic */ float particleScale;
    public static /* synthetic */ Vec3d cameraViewDir;
    protected /* synthetic */ double motionX;
    protected /* synthetic */ boolean isExpired;
    protected /* synthetic */ float prevParticleAngle;
    protected /* synthetic */ double posX;
    protected /* synthetic */ float height;
    private /* synthetic */ AxisAlignedBB boundingBox;
    protected /* synthetic */ float particleTextureJitterX;
    protected /* synthetic */ float particleGreen;
    public static /* synthetic */ double interpPosX;
    protected /* synthetic */ double prevPosY;
    protected /* synthetic */ int particleTextureIndexY;
    
    public Particle multipleParticleScaleBy(final float lllllllllllIlIIIlIIIIlllIllIIlIl) {
        this.setSize(0.2f * lllllllllllIlIIIlIIIIlllIllIIlIl, 0.2f * lllllllllllIlIIIlIIIIlllIllIIlIl);
        this.particleScale *= lllllllllllIlIIIlIIIIlllIllIIlIl;
        return this;
    }
    
    public void nextTextureIndexX() {
        ++this.particleTextureIndexX;
    }
    
    public void setParticleTexture(final TextureAtlasSprite lllllllllllIlIIIlIIIIllIlllIIlIl) {
        final int lllllllllllIlIIIlIIIIllIlllIIlll = this.getFXLayer();
        if (lllllllllllIlIIIlIIIIllIlllIIlll == 1) {
            this.particleTexture = lllllllllllIlIIIlIIIIllIlllIIlIl;
            return;
        }
        throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
    }
    
    public void setEntityBoundingBox(final AxisAlignedBB lllllllllllIlIIIlIIIIllIlIIIIlIl) {
        this.boundingBox = lllllllllllIlIIIlIIIIllIlIIIIlIl;
    }
    
    public float getGreenColorF() {
        return this.particleGreen;
    }
    
    protected void setSize(final float lllllllllllIlIIIlIIIIllIllIIllll, final float lllllllllllIlIIIlIIIIllIllIIlllI) {
        if (lllllllllllIlIIIlIIIIllIllIIllll != this.width || lllllllllllIlIIIlIIIIllIllIIlllI != this.height) {
            this.width = lllllllllllIlIIIlIIIIllIllIIllll;
            this.height = lllllllllllIlIIIlIIIIllIllIIlllI;
            final AxisAlignedBB lllllllllllIlIIIlIIIIllIllIIllIl = this.getEntityBoundingBox();
            this.setEntityBoundingBox(new AxisAlignedBB(lllllllllllIlIIIlIIIIllIllIIllIl.minX, lllllllllllIlIIIlIIIIllIllIIllIl.minY, lllllllllllIlIIIlIIIIllIllIIllIl.minZ, lllllllllllIlIIIlIIIIllIllIIllIl.minX + this.width, lllllllllllIlIIIlIIIIllIllIIllIl.minY + this.height, lllllllllllIlIIIlIIIIllIllIIllIl.minZ + this.width));
        }
    }
    
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.motionY -= 0.04 * this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getClass().getSimpleName()) + ", Pos (" + this.posX + "," + this.posY + "," + this.posZ + "), RGBA (" + this.particleRed + "," + this.particleGreen + "," + this.particleBlue + "," + this.particleAlpha + "), Age " + this.particleAge;
    }
    
    public void setRBGColorF(final float lllllllllllIlIIIlIIIIlllIlIllIll, final float lllllllllllIlIIIlIIIIlllIlIllIlI, final float lllllllllllIlIIIlIIIIlllIlIlllIl) {
        this.particleRed = lllllllllllIlIIIlIIIIlllIlIllIll;
        this.particleGreen = lllllllllllIlIIIlIIIIlllIlIllIlI;
        this.particleBlue = lllllllllllIlIIIlIIIIlllIlIlllIl;
    }
    
    public void setPosition(final double lllllllllllIlIIIlIIIIllIllIIIIIl, final double lllllllllllIlIIIlIIIIllIlIlllIlI, final double lllllllllllIlIIIlIIIIllIlIllllll) {
        this.posX = lllllllllllIlIIIlIIIIllIllIIIIIl;
        this.posY = lllllllllllIlIIIlIIIIllIlIlllIlI;
        this.posZ = lllllllllllIlIIIlIIIIllIlIllllll;
        final float lllllllllllIlIIIlIIIIllIlIlllllI = this.width / 2.0f;
        final float lllllllllllIlIIIlIIIIllIlIllllIl = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(lllllllllllIlIIIlIIIIllIllIIIIIl - lllllllllllIlIIIlIIIIllIlIlllllI, lllllllllllIlIIIlIIIIllIlIlllIlI, lllllllllllIlIIIlIIIIllIlIllllll - lllllllllllIlIIIlIIIIllIlIlllllI, lllllllllllIlIIIlIIIIllIllIIIIIl + lllllllllllIlIIIlIIIIllIlIlllllI, lllllllllllIlIIIlIIIIllIlIlllIlI + lllllllllllIlIIIlIIIIllIlIllllIl, lllllllllllIlIIIlIIIIllIlIllllll + lllllllllllIlIIIlIIIIllIlIlllllI));
    }
    
    public void renderParticle(final BufferBuilder lllllllllllIlIIIlIIIIlllIIIIIlll, final Entity lllllllllllIlIIIlIIIIlllIIlIIIlI, final float lllllllllllIlIIIlIIIIlllIIlIIIIl, final float lllllllllllIlIIIlIIIIlllIIIIIlIl, final float lllllllllllIlIIIlIIIIlllIIIlllll, final float lllllllllllIlIIIlIIIIlllIIIIIIll, final float lllllllllllIlIIIlIIIIlllIIIIIIlI, final float lllllllllllIlIIIlIIIIlllIIIlllII) {
        float lllllllllllIlIIIlIIIIlllIIIllIll = this.particleTextureIndexX / 16.0f;
        float lllllllllllIlIIIlIIIIlllIIIllIlI = lllllllllllIlIIIlIIIIlllIIIllIll + 0.0624375f;
        float lllllllllllIlIIIlIIIIlllIIIllIIl = this.particleTextureIndexY / 16.0f;
        float lllllllllllIlIIIlIIIIlllIIIllIII = lllllllllllIlIIIlIIIIlllIIIllIIl + 0.0624375f;
        final float lllllllllllIlIIIlIIIIlllIIIlIlll = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllIlIIIlIIIIlllIIIllIll = this.particleTexture.getMinU();
            lllllllllllIlIIIlIIIIlllIIIllIlI = this.particleTexture.getMaxU();
            lllllllllllIlIIIlIIIIlllIIIllIIl = this.particleTexture.getMinV();
            lllllllllllIlIIIlIIIIlllIIIllIII = this.particleTexture.getMaxV();
        }
        final float lllllllllllIlIIIlIIIIlllIIIlIllI = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllIlIIIlIIIIlllIIlIIIIl - Particle.interpPosX);
        final float lllllllllllIlIIIlIIIIlllIIIlIlIl = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllIlIIIlIIIIlllIIlIIIIl - Particle.interpPosY);
        final float lllllllllllIlIIIlIIIIlllIIIlIlII = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllIlIIIlIIIIlllIIlIIIIl - Particle.interpPosZ);
        final int lllllllllllIlIIIlIIIIlllIIIlIIll = this.getBrightnessForRender(lllllllllllIlIIIlIIIIlllIIlIIIIl);
        final int lllllllllllIlIIIlIIIIlllIIIlIIlI = lllllllllllIlIIIlIIIIlllIIIlIIll >> 16 & 0xFFFF;
        final int lllllllllllIlIIIlIIIIlllIIIlIIIl = lllllllllllIlIIIlIIIIlllIIIlIIll & 0xFFFF;
        final Vec3d[] lllllllllllIlIIIlIIIIlllIIIlIIII = { new Vec3d(-lllllllllllIlIIIlIIIIlllIIIIIlIl * lllllllllllIlIIIlIIIIlllIIIlIlll - lllllllllllIlIIIlIIIIlllIIIIIIlI * lllllllllllIlIIIlIIIIlllIIIlIlll, -lllllllllllIlIIIlIIIIlllIIIlllll * lllllllllllIlIIIlIIIIlllIIIlIlll, -lllllllllllIlIIIlIIIIlllIIIIIIll * lllllllllllIlIIIlIIIIlllIIIlIlll - lllllllllllIlIIIlIIIIlllIIIlllII * lllllllllllIlIIIlIIIIlllIIIlIlll), new Vec3d(-lllllllllllIlIIIlIIIIlllIIIIIlIl * lllllllllllIlIIIlIIIIlllIIIlIlll + lllllllllllIlIIIlIIIIlllIIIIIIlI * lllllllllllIlIIIlIIIIlllIIIlIlll, lllllllllllIlIIIlIIIIlllIIIlllll * lllllllllllIlIIIlIIIIlllIIIlIlll, -lllllllllllIlIIIlIIIIlllIIIIIIll * lllllllllllIlIIIlIIIIlllIIIlIlll + lllllllllllIlIIIlIIIIlllIIIlllII * lllllllllllIlIIIlIIIIlllIIIlIlll), new Vec3d(lllllllllllIlIIIlIIIIlllIIIIIlIl * lllllllllllIlIIIlIIIIlllIIIlIlll + lllllllllllIlIIIlIIIIlllIIIIIIlI * lllllllllllIlIIIlIIIIlllIIIlIlll, lllllllllllIlIIIlIIIIlllIIIlllll * lllllllllllIlIIIlIIIIlllIIIlIlll, lllllllllllIlIIIlIIIIlllIIIIIIll * lllllllllllIlIIIlIIIIlllIIIlIlll + lllllllllllIlIIIlIIIIlllIIIlllII * lllllllllllIlIIIlIIIIlllIIIlIlll), new Vec3d(lllllllllllIlIIIlIIIIlllIIIIIlIl * lllllllllllIlIIIlIIIIlllIIIlIlll - lllllllllllIlIIIlIIIIlllIIIIIIlI * lllllllllllIlIIIlIIIIlllIIIlIlll, -lllllllllllIlIIIlIIIIlllIIIlllll * lllllllllllIlIIIlIIIIlllIIIlIlll, lllllllllllIlIIIlIIIIlllIIIIIIll * lllllllllllIlIIIlIIIIlllIIIlIlll - lllllllllllIlIIIlIIIIlllIIIlllII * lllllllllllIlIIIlIIIIlllIIIlIlll) };
        if (this.particleAngle != 0.0f) {
            final float lllllllllllIlIIIlIIIIlllIIIIllll = this.particleAngle + (this.particleAngle - this.prevParticleAngle) * lllllllllllIlIIIlIIIIlllIIlIIIIl;
            final float lllllllllllIlIIIlIIIIlllIIIIlllI = MathHelper.cos(lllllllllllIlIIIlIIIIlllIIIIllll * 0.5f);
            final float lllllllllllIlIIIlIIIIlllIIIIllIl = MathHelper.sin(lllllllllllIlIIIlIIIIlllIIIIllll * 0.5f) * (float)Particle.cameraViewDir.xCoord;
            final float lllllllllllIlIIIlIIIIlllIIIIllII = MathHelper.sin(lllllllllllIlIIIlIIIIlllIIIIllll * 0.5f) * (float)Particle.cameraViewDir.yCoord;
            final float lllllllllllIlIIIlIIIIlllIIIIlIll = MathHelper.sin(lllllllllllIlIIIlIIIIlllIIIIllll * 0.5f) * (float)Particle.cameraViewDir.zCoord;
            final Vec3d lllllllllllIlIIIlIIIIlllIIIIlIlI = new Vec3d(lllllllllllIlIIIlIIIIlllIIIIllIl, lllllllllllIlIIIlIIIIlllIIIIllII, lllllllllllIlIIIlIIIIlllIIIIlIll);
            for (int lllllllllllIlIIIlIIIIlllIIIIlIIl = 0; lllllllllllIlIIIlIIIIlllIIIIlIIl < 4; ++lllllllllllIlIIIlIIIIlllIIIIlIIl) {
                lllllllllllIlIIIlIIIIlllIIIlIIII[lllllllllllIlIIIlIIIIlllIIIIlIIl] = lllllllllllIlIIIlIIIIlllIIIIlIlI.scale(2.0 * lllllllllllIlIIIlIIIIlllIIIlIIII[lllllllllllIlIIIlIIIIlllIIIIlIIl].dotProduct(lllllllllllIlIIIlIIIIlllIIIIlIlI)).add(lllllllllllIlIIIlIIIIlllIIIlIIII[lllllllllllIlIIIlIIIIlllIIIIlIIl].scale(lllllllllllIlIIIlIIIIlllIIIIlllI * lllllllllllIlIIIlIIIIlllIIIIlllI - lllllllllllIlIIIlIIIIlllIIIIlIlI.dotProduct(lllllllllllIlIIIlIIIIlllIIIIlIlI))).add(lllllllllllIlIIIlIIIIlllIIIIlIlI.crossProduct(lllllllllllIlIIIlIIIIlllIIIlIIII[lllllllllllIlIIIlIIIIlllIIIIlIIl]).scale(2.0f * lllllllllllIlIIIlIIIIlllIIIIlllI));
            }
        }
        lllllllllllIlIIIlIIIIlllIIIIIlll.pos(lllllllllllIlIIIlIIIIlllIIIlIllI + lllllllllllIlIIIlIIIIlllIIIlIIII[0].xCoord, lllllllllllIlIIIlIIIIlllIIIlIlIl + lllllllllllIlIIIlIIIIlllIIIlIIII[0].yCoord, lllllllllllIlIIIlIIIIlllIIIlIlII + lllllllllllIlIIIlIIIIlllIIIlIIII[0].zCoord).tex(lllllllllllIlIIIlIIIIlllIIIllIlI, lllllllllllIlIIIlIIIIlllIIIllIII).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIlIIIlIIIIlllIIIlIIlI, lllllllllllIlIIIlIIIIlllIIIlIIIl).endVertex();
        lllllllllllIlIIIlIIIIlllIIIIIlll.pos(lllllllllllIlIIIlIIIIlllIIIlIllI + lllllllllllIlIIIlIIIIlllIIIlIIII[1].xCoord, lllllllllllIlIIIlIIIIlllIIIlIlIl + lllllllllllIlIIIlIIIIlllIIIlIIII[1].yCoord, lllllllllllIlIIIlIIIIlllIIIlIlII + lllllllllllIlIIIlIIIIlllIIIlIIII[1].zCoord).tex(lllllllllllIlIIIlIIIIlllIIIllIlI, lllllllllllIlIIIlIIIIlllIIIllIIl).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIlIIIlIIIIlllIIIlIIlI, lllllllllllIlIIIlIIIIlllIIIlIIIl).endVertex();
        lllllllllllIlIIIlIIIIlllIIIIIlll.pos(lllllllllllIlIIIlIIIIlllIIIlIllI + lllllllllllIlIIIlIIIIlllIIIlIIII[2].xCoord, lllllllllllIlIIIlIIIIlllIIIlIlIl + lllllllllllIlIIIlIIIIlllIIIlIIII[2].yCoord, lllllllllllIlIIIlIIIIlllIIIlIlII + lllllllllllIlIIIlIIIIlllIIIlIIII[2].zCoord).tex(lllllllllllIlIIIlIIIIlllIIIllIll, lllllllllllIlIIIlIIIIlllIIIllIIl).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIlIIIlIIIIlllIIIlIIlI, lllllllllllIlIIIlIIIIlllIIIlIIIl).endVertex();
        lllllllllllIlIIIlIIIIlllIIIIIlll.pos(lllllllllllIlIIIlIIIIlllIIIlIllI + lllllllllllIlIIIlIIIIlllIIIlIIII[3].xCoord, lllllllllllIlIIIlIIIIlllIIIlIlIl + lllllllllllIlIIIlIIIIlllIIIlIIII[3].yCoord, lllllllllllIlIIIlIIIIlllIIIlIlII + lllllllllllIlIIIlIIIIlllIIIlIIII[3].zCoord).tex(lllllllllllIlIIIlIIIIlllIIIllIll, lllllllllllIlIIIlIIIIlllIIIllIII).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIlIIIlIIIIlllIIIlIIlI, lllllllllllIlIIIlIIIIlllIIIlIIIl).endVertex();
    }
    
    public AxisAlignedBB getEntityBoundingBox() {
        return this.boundingBox;
    }
    
    public int getFXLayer() {
        return 0;
    }
    
    public boolean isAlive() {
        return !this.isExpired;
    }
    
    public void setParticleTextureIndex(final int lllllllllllIlIIIlIIIIllIlllIIIII) {
        if (this.getFXLayer() != 0) {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        this.particleTextureIndexX = lllllllllllIlIIIlIIIIllIlllIIIII % 16;
        this.particleTextureIndexY = lllllllllllIlIIIlIIIIllIlllIIIII / 16;
    }
    
    static {
        EMPTY_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    
    public int getBrightnessForRender(final float lllllllllllIlIIIlIIIIllIlIIlIlII) {
        final BlockPos lllllllllllIlIIIlIIIIllIlIIlIIll = new BlockPos(this.posX, this.posY, this.posZ);
        return this.worldObj.isBlockLoaded(lllllllllllIlIIIlIIIIllIlIIlIIll) ? this.worldObj.getCombinedLight(lllllllllllIlIIIlIIIIllIlIIlIIll, 0) : 0;
    }
    
    public boolean isTransparent() {
        return false;
    }
    
    public Particle multiplyVelocity(final float lllllllllllIlIIIlIIIIlllIllIlIll) {
        this.motionX *= lllllllllllIlIIIlIIIIlllIllIlIll;
        this.motionY = (this.motionY - 0.10000000149011612) * lllllllllllIlIIIlIIIIlllIllIlIll + 0.10000000149011612;
        this.motionZ *= lllllllllllIlIIIlIIIIlllIllIlIll;
        return this;
    }
    
    protected void resetPositionToBB() {
        final AxisAlignedBB lllllllllllIlIIIlIIIIllIlIIllIlI = this.getEntityBoundingBox();
        this.posX = (lllllllllllIlIIIlIIIIllIlIIllIlI.minX + lllllllllllIlIIIlIIIIllIlIIllIlI.maxX) / 2.0;
        this.posY = lllllllllllIlIIIlIIIIllIlIIllIlI.minY;
        this.posZ = (lllllllllllIlIIIlIIIIllIlIIllIlI.minZ + lllllllllllIlIIIlIIIIllIlIIllIlI.maxZ) / 2.0;
    }
    
    public void setExpired() {
        this.isExpired = true;
    }
    
    public void setAlphaF(final float lllllllllllIlIIIlIIIIlllIlIlIIll) {
        this.particleAlpha = lllllllllllIlIIIlIIIIlllIlIlIIll;
    }
    
    protected Particle(final World lllllllllllIlIIIlIIIIllllIIlIIlI, final double lllllllllllIlIIIlIIIIllllIIlIllI, final double lllllllllllIlIIIlIIIIllllIIlIIII, final double lllllllllllIlIIIlIIIIllllIIIllll) {
        this.boundingBox = Particle.EMPTY_AABB;
        this.width = 0.6f;
        this.height = 1.8f;
        this.rand = new Random();
        this.particleAlpha = 1.0f;
        this.worldObj = lllllllllllIlIIIlIIIIllllIIlIIlI;
        this.setSize(0.2f, 0.2f);
        this.setPosition(lllllllllllIlIIIlIIIIllllIIlIllI, lllllllllllIlIIIlIIIIllllIIlIIII, lllllllllllIlIIIlIIIIllllIIIllll);
        this.prevPosX = lllllllllllIlIIIlIIIIllllIIlIllI;
        this.prevPosY = lllllllllllIlIIIlIIIIllllIIlIIII;
        this.prevPosZ = lllllllllllIlIIIlIIIIllllIIIllll;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleTextureJitterX = this.rand.nextFloat() * 3.0f;
        this.particleTextureJitterY = this.rand.nextFloat() * 3.0f;
        this.particleScale = (this.rand.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.particleMaxAge = (int)(4.0f / (this.rand.nextFloat() * 0.9f + 0.1f));
        this.particleAge = 0;
        this.canCollide = true;
    }
    
    public float getRedColorF() {
        return this.particleRed;
    }
    
    public void moveEntity(double lllllllllllIlIIIlIIIIllIlIlIIlII, double lllllllllllIlIIIlIIIIllIlIlIIIll, double lllllllllllIlIIIlIIIIllIlIlIIIlI) {
        final double lllllllllllIlIIIlIIIIllIlIlIlIlI = (double)lllllllllllIlIIIlIIIIllIlIlIIIll;
        if (this.canCollide) {
            final List<AxisAlignedBB> lllllllllllIlIIIlIIIIllIlIlIlIIl = this.worldObj.getCollisionBoxes(null, this.getEntityBoundingBox().addCoord(lllllllllllIlIIIlIIIIllIlIlIIlII, (double)lllllllllllIlIIIlIIIIllIlIlIIIll, lllllllllllIlIIIlIIIIllIlIlIIIlI));
            for (final AxisAlignedBB lllllllllllIlIIIlIIIIllIlIlIlIII : lllllllllllIlIIIlIIIIllIlIlIlIIl) {
                lllllllllllIlIIIlIIIIllIlIlIIIll = lllllllllllIlIIIlIIIIllIlIlIlIII.calculateYOffset(this.getEntityBoundingBox(), (double)lllllllllllIlIIIlIIIIllIlIlIIIll);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, (double)lllllllllllIlIIIlIIIIllIlIlIIIll, 0.0));
            for (final AxisAlignedBB lllllllllllIlIIIlIIIIllIlIlIIlll : lllllllllllIlIIIlIIIIllIlIlIlIIl) {
                lllllllllllIlIIIlIIIIllIlIlIIlII = lllllllllllIlIIIlIIIIllIlIlIIlll.calculateXOffset(this.getEntityBoundingBox(), lllllllllllIlIIIlIIIIllIlIlIIlII);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllIlIIIlIIIIllIlIlIIlII, 0.0, 0.0));
            for (final AxisAlignedBB lllllllllllIlIIIlIIIIllIlIlIIllI : lllllllllllIlIIIlIIIIllIlIlIlIIl) {
                lllllllllllIlIIIlIIIIllIlIlIIIlI = lllllllllllIlIIIlIIIIllIlIlIIllI.calculateZOffset(this.getEntityBoundingBox(), lllllllllllIlIIIlIIIIllIlIlIIIlI);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, 0.0, lllllllllllIlIIIlIIIIllIlIlIIIlI));
        }
        else {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllIlIIIlIIIIllIlIlIIlII, (double)lllllllllllIlIIIlIIIIllIlIlIIIll, lllllllllllIlIIIlIIIIllIlIlIIIlI));
        }
        this.resetPositionToBB();
        this.isCollided = (lllllllllllIlIIIlIIIIllIlIlIIIll != lllllllllllIlIIIlIIIIllIlIlIIIll && lllllllllllIlIIIlIIIIllIlIlIlIlI < 0.0);
        if (lllllllllllIlIIIlIIIIllIlIlIIlII != lllllllllllIlIIIlIIIIllIlIlIIlII) {
            this.motionX = 0.0;
        }
        if (lllllllllllIlIIIlIIIIllIlIlIIIlI != lllllllllllIlIIIlIIIIllIlIlIIIlI) {
            this.motionZ = 0.0;
        }
    }
    
    public void setMaxAge(final int lllllllllllIlIIIlIIIIlllIlIIIIll) {
        this.particleMaxAge = lllllllllllIlIIIlIIIIlllIlIIIIll;
    }
    
    public Particle(final World lllllllllllIlIIIlIIIIlllIllllIIl, final double lllllllllllIlIIIlIIIIlllIllllIII, final double lllllllllllIlIIIlIIIIlllIlllIlll, final double lllllllllllIlIIIlIIIIlllIlllIllI, final double lllllllllllIlIIIlIIIIlllIlllIlIl, final double lllllllllllIlIIIlIIIIlllIllllllI, final double lllllllllllIlIIIlIIIIlllIlllllIl) {
        this(lllllllllllIlIIIlIIIIlllIllllIIl, lllllllllllIlIIIlIIIIlllIllllIII, lllllllllllIlIIIlIIIIlllIlllIlll, lllllllllllIlIIIlIIIIlllIlllIllI);
        this.motionX = lllllllllllIlIIIlIIIIlllIlllIlIl + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionY = lllllllllllIlIIIlIIIIlllIllllllI + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        this.motionZ = lllllllllllIlIIIlIIIIlllIlllllIl + (Math.random() * 2.0 - 1.0) * 0.4000000059604645;
        final float lllllllllllIlIIIlIIIIlllIlllllII = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        final float lllllllllllIlIIIlIIIIlllIllllIll = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / lllllllllllIlIIIlIIIIlllIllllIll * lllllllllllIlIIIlIIIIlllIlllllII * 0.4000000059604645;
        this.motionY = this.motionY / lllllllllllIlIIIlIIIIlllIllllIll * lllllllllllIlIIIlIIIIlllIlllllII * 0.4000000059604645 + 0.10000000149011612;
        this.motionZ = this.motionZ / lllllllllllIlIIIlIIIIlllIllllIll * lllllllllllIlIIIlIIIIlllIlllllII * 0.4000000059604645;
    }
    
    public float getBlueColorF() {
        return this.particleBlue;
    }
}
