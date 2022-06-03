// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockFalling;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;

public class ParticleFallingDust extends Particle
{
    final /* synthetic */ float rotSpeed;
    /* synthetic */ float oSize;
    
    protected ParticleFallingDust(final World llllllllllllIIIIIllllIIlIIIIlIII, final double llllllllllllIIIIIllllIIIlllllllI, final double llllllllllllIIIIIllllIIIllllllIl, final double llllllllllllIIIIIllllIIlIIIIIlIl, final float llllllllllllIIIIIllllIIIlllllIll, final float llllllllllllIIIIIllllIIIlllllIlI, final float llllllllllllIIIIIllllIIlIIIIIIlI) {
        super(llllllllllllIIIIIllllIIlIIIIlIII, llllllllllllIIIIIllllIIIlllllllI, llllllllllllIIIIIllllIIIllllllIl, llllllllllllIIIIIllllIIlIIIIIlIl, 0.0, 0.0, 0.0);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleRed = llllllllllllIIIIIllllIIIlllllIll;
        this.particleGreen = llllllllllllIIIIIllllIIIlllllIlI;
        this.particleBlue = llllllllllllIIIIIllllIIlIIIIIIlI;
        final float llllllllllllIIIIIllllIIlIIIIIIIl = 0.9f;
        this.particleScale *= 0.75f;
        this.particleScale *= 0.9f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)0.9f;
        this.rotSpeed = ((float)Math.random() - 0.5f) * 0.1f;
        this.particleAngle = (float)Math.random() * 6.2831855f;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.prevParticleAngle = this.particleAngle;
        this.particleAngle += 3.1415927f * this.rotSpeed * 2.0f;
        if (this.isCollided) {
            final float n = 0.0f;
            this.particleAngle = n;
            this.prevParticleAngle = n;
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionY -= 0.003000000026077032;
        this.motionY = Math.max(this.motionY, -0.14000000059604645);
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIIIIIllllIIIlllIllII, final Entity llllllllllllIIIIIllllIIIlllIIIIl, final float llllllllllllIIIIIllllIIIlllIlIlI, final float llllllllllllIIIIIllllIIIlllIlIIl, final float llllllllllllIIIIIllllIIIllIllllI, final float llllllllllllIIIIIllllIIIllIlllIl, final float llllllllllllIIIIIllllIIIllIlllII, final float llllllllllllIIIIIllllIIIllIllIll) {
        float llllllllllllIIIIIllllIIIlllIIlII = (this.particleAge + llllllllllllIIIIIllllIIIlllIlIlI) / this.particleMaxAge * 32.0f;
        llllllllllllIIIIIllllIIIlllIIlII = MathHelper.clamp(llllllllllllIIIIIllllIIIlllIIlII, 0.0f, 1.0f);
        this.particleScale = this.oSize * llllllllllllIIIIIllllIIIlllIIlII;
        super.renderParticle(llllllllllllIIIIIllllIIIlllIllII, llllllllllllIIIIIllllIIIlllIIIIl, llllllllllllIIIIIllllIIIlllIlIlI, llllllllllllIIIIIllllIIIlllIlIIl, llllllllllllIIIIIllllIIIllIllllI, llllllllllllIIIIIllllIIIllIlllIl, llllllllllllIIIIIllllIIIllIlllII, llllllllllllIIIIIllllIIIllIllIll);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Nullable
        @Override
        public Particle createParticle(final int llllllllllllIllIlIlllIIIlIlllIIl, final World llllllllllllIllIlIlllIIIlIlllIII, final double llllllllllllIllIlIlllIIIlIlIIlll, final double llllllllllllIllIlIlllIIIlIllIllI, final double llllllllllllIllIlIlllIIIlIlIIIll, final double llllllllllllIllIlIlllIIIlIllIlII, final double llllllllllllIllIlIlllIIIlIllIIll, final double llllllllllllIllIlIlllIIIlIllIIlI, final int... llllllllllllIllIlIlllIIIlIlIIIlI) {
            final IBlockState llllllllllllIllIlIlllIIIlIllIIII = Block.getStateById(llllllllllllIllIlIlllIIIlIlIIIlI[0]);
            if (llllllllllllIllIlIlllIIIlIllIIII.getBlock() != Blocks.AIR && llllllllllllIllIlIlllIIIlIllIIII.getRenderType() == EnumBlockRenderType.INVISIBLE) {
                return null;
            }
            int llllllllllllIllIlIlllIIIlIlIllll = Minecraft.getMinecraft().getBlockColors().getColor(llllllllllllIllIlIlllIIIlIllIIII, llllllllllllIllIlIlllIIIlIlllIII, new BlockPos(llllllllllllIllIlIlllIIIlIlIIlll, llllllllllllIllIlIlllIIIlIllIllI, llllllllllllIllIlIlllIIIlIlIIIll));
            if (llllllllllllIllIlIlllIIIlIllIIII.getBlock() instanceof BlockFalling) {
                llllllllllllIllIlIlllIIIlIlIllll = ((BlockFalling)llllllllllllIllIlIlllIIIlIllIIII.getBlock()).getDustColor(llllllllllllIllIlIlllIIIlIllIIII);
            }
            final float llllllllllllIllIlIlllIIIlIlIlllI = (llllllllllllIllIlIlllIIIlIlIllll >> 16 & 0xFF) / 255.0f;
            final float llllllllllllIllIlIlllIIIlIlIllIl = (llllllllllllIllIlIlllIIIlIlIllll >> 8 & 0xFF) / 255.0f;
            final float llllllllllllIllIlIlllIIIlIlIllII = (llllllllllllIllIlIlllIIIlIlIllll & 0xFF) / 255.0f;
            return new ParticleFallingDust(llllllllllllIllIlIlllIIIlIlllIII, llllllllllllIllIlIlllIIIlIlIIlll, llllllllllllIllIlIlllIIIlIllIllI, llllllllllllIllIlIlllIIIlIlIIIll, llllllllllllIllIlIlllIIIlIlIlllI, llllllllllllIllIlIlllIIIlIlIllIl, llllllllllllIllIlIlllIIIlIlIllII);
        }
    }
}
