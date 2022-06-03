// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.material.Material;

public class ParticleDrip extends Particle
{
    private /* synthetic */ int bobTimer;
    private final /* synthetic */ Material materialType;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.materialType == Material.WATER) {
            this.particleRed = 0.2f;
            this.particleGreen = 0.3f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 16.0f / (40 - this.bobTimer + 16);
            this.particleBlue = 4.0f / (40 - this.bobTimer + 8);
        }
        this.motionY -= this.particleGravity;
        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02;
            this.motionY *= 0.02;
            this.motionZ *= 0.02;
            this.setParticleTextureIndex(113);
        }
        else {
            this.setParticleTextureIndex(112);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
        if (this.isCollided) {
            if (this.materialType == Material.WATER) {
                this.setExpired();
                this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            }
            else {
                this.setParticleTextureIndex(114);
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos llllllllllllIllIIIlllllIllIlllII = new BlockPos(this.posX, this.posY, this.posZ);
        final IBlockState llllllllllllIllIIIlllllIllIllIll = this.worldObj.getBlockState(llllllllllllIllIIIlllllIllIlllII);
        final Material llllllllllllIllIIIlllllIllIllIlI = llllllllllllIllIIIlllllIllIllIll.getMaterial();
        if (llllllllllllIllIIIlllllIllIllIlI.isLiquid() || llllllllllllIllIIIlllllIllIllIlI.isSolid()) {
            double llllllllllllIllIIIlllllIllIllIIl = 0.0;
            if (llllllllllllIllIIIlllllIllIllIll.getBlock() instanceof BlockLiquid) {
                llllllllllllIllIIIlllllIllIllIIl = BlockLiquid.getLiquidHeightPercent(llllllllllllIllIIIlllllIllIllIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
            }
            final double llllllllllllIllIIIlllllIllIllIII = MathHelper.floor(this.posY) + 1 - llllllllllllIllIIIlllllIllIllIIl;
            if (this.posY < llllllllllllIllIIIlllllIllIllIII) {
                this.setExpired();
            }
        }
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllIllIIIlllllIlllIIlII) {
        return (this.materialType == Material.WATER) ? super.getBrightnessForRender(llllllllllllIllIIIlllllIlllIIlII) : 257;
    }
    
    protected ParticleDrip(final World llllllllllllIllIIIlllllIlllIlllI, final double llllllllllllIllIIIlllllIllllIIll, final double llllllllllllIllIIIlllllIlllIllII, final double llllllllllllIllIIIlllllIlllIlIll, final Material llllllllllllIllIIIlllllIllllIIII) {
        super(llllllllllllIllIIIlllllIlllIlllI, llllllllllllIllIIIlllllIllllIIll, llllllllllllIllIIIlllllIlllIllII, llllllllllllIllIIIlllllIlllIlIll, 0.0, 0.0, 0.0);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        if (llllllllllllIllIIIlllllIllllIIII == Material.WATER) {
            this.particleRed = 0.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 0.0f;
        }
        this.setParticleTextureIndex(113);
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.materialType = llllllllllllIllIIIlllllIllllIIII;
        this.bobTimer = 40;
        this.particleMaxAge = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
    }
    
    public static class WaterFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIIlIIIIlIIlIIIIIlllI, final World lllllllllllIIIlIIIIlIIlIIIIIllIl, final double lllllllllllIIIlIIIIlIIlIIIIIIlII, final double lllllllllllIIIlIIIIlIIlIIIIIIIll, final double lllllllllllIIIlIIIIlIIlIIIIIlIlI, final double lllllllllllIIIlIIIIlIIlIIIIIlIIl, final double lllllllllllIIIlIIIIlIIlIIIIIlIII, final double lllllllllllIIIlIIIIlIIlIIIIIIlll, final int... lllllllllllIIIlIIIIlIIlIIIIIIllI) {
            return new ParticleDrip(lllllllllllIIIlIIIIlIIlIIIIIllIl, lllllllllllIIIlIIIIlIIlIIIIIIlII, lllllllllllIIIlIIIIlIIlIIIIIIIll, lllllllllllIIIlIIIIlIIlIIIIIlIlI, Material.WATER);
        }
    }
    
    public static class LavaFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlllllIlIllIllIIIIII, final World lllllllllllIIlllllIlIllIlIllllll, final double lllllllllllIIlllllIlIllIlIlllllI, final double lllllllllllIIlllllIlIllIlIllllIl, final double lllllllllllIIlllllIlIllIlIllIlII, final double lllllllllllIIlllllIlIllIlIlllIll, final double lllllllllllIIlllllIlIllIlIlllIlI, final double lllllllllllIIlllllIlIllIlIlllIIl, final int... lllllllllllIIlllllIlIllIlIlllIII) {
            return new ParticleDrip(lllllllllllIIlllllIlIllIlIllllll, lllllllllllIIlllllIlIllIlIlllllI, lllllllllllIIlllllIlIllIlIllllIl, lllllllllllIIlllllIlIllIlIllIlII, Material.LAVA);
        }
    }
}
