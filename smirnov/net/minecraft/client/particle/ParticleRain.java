// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleRain extends Particle
{
    protected ParticleRain(final World lllllllllllIllIlllIIIlIlIIIIIlIl, final double lllllllllllIllIlllIIIlIlIIIIIlII, final double lllllllllllIllIlllIIIlIlIIIIIIll, final double lllllllllllIllIlllIIIlIlIIIIIlll) {
        super(lllllllllllIllIlllIIIlIlIIIIIlIl, lllllllllllIllIlllIIIlIlIIIIIlII, lllllllllllIllIlllIIIlIlIIIIIIll, lllllllllllIllIlllIIIlIlIIIIIlll, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19 + this.rand.nextInt(4));
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
        if (this.isCollided) {
            if (Math.random() < 0.5) {
                this.setExpired();
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos lllllllllllIllIlllIIIlIIlllllIlI = new BlockPos(this.posX, this.posY, this.posZ);
        final IBlockState lllllllllllIllIlllIIIlIIlllllIIl = this.worldObj.getBlockState(lllllllllllIllIlllIIIlIIlllllIlI);
        final Material lllllllllllIllIlllIIIlIIlllllIII = lllllllllllIllIlllIIIlIIlllllIIl.getMaterial();
        if (lllllllllllIllIlllIIIlIIlllllIII.isLiquid() || lllllllllllIllIlllIIIlIIlllllIII.isSolid()) {
            double lllllllllllIllIlllIIIlIIllllIllI = 0.0;
            if (lllllllllllIllIlllIIIlIIlllllIIl.getBlock() instanceof BlockLiquid) {
                final double lllllllllllIllIlllIIIlIIllllIlll = 1.0f - BlockLiquid.getLiquidHeightPercent(lllllllllllIllIlllIIIlIIlllllIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
            }
            else {
                lllllllllllIllIlllIIIlIIllllIllI = lllllllllllIllIlllIIIlIIlllllIIl.getBoundingBox(this.worldObj, lllllllllllIllIlllIIIlIIlllllIlI).maxY;
            }
            final double lllllllllllIllIlllIIIlIIllllIlIl = MathHelper.floor(this.posY) + lllllllllllIllIlllIIIlIIllllIllI;
            if (this.posY < lllllllllllIllIlllIIIlIIllllIlIl) {
                this.setExpired();
            }
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlIlIllIlllIlIIIlIIl, final World lllllllllllIIlIlIllIlllIlIIIlIII, final double lllllllllllIIlIlIllIlllIlIIIIlll, final double lllllllllllIIlIlIllIlllIlIIIIllI, final double lllllllllllIIlIlIllIlllIlIIIIlIl, final double lllllllllllIIlIlIllIlllIlIIIIlII, final double lllllllllllIIlIlIllIlllIlIIIIIll, final double lllllllllllIIlIlIllIlllIlIIIIIlI, final int... lllllllllllIIlIlIllIlllIlIIIIIIl) {
            return new ParticleRain(lllllllllllIIlIlIllIlllIlIIIlIII, lllllllllllIIlIlIllIlllIlIIIIlll, lllllllllllIIlIlIllIlllIlIIIIllI, lllllllllllIIlIlIllIlllIlIIIIlIl);
        }
    }
}
