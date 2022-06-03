// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class ParticleDigging extends Particle
{
    private /* synthetic */ BlockPos sourcePos;
    private final /* synthetic */ IBlockState sourceState;
    
    @Override
    public int getBrightnessForRender(final float lllllllllllIIllIIIIlIIIIllIIlIlI) {
        final int lllllllllllIIllIIIIlIIIIllIIllIl = super.getBrightnessForRender(lllllllllllIIllIIIIlIIIIllIIlIlI);
        int lllllllllllIIllIIIIlIIIIllIIllII = 0;
        if (this.worldObj.isBlockLoaded(this.sourcePos)) {
            lllllllllllIIllIIIIlIIIIllIIllII = this.worldObj.getCombinedLight(this.sourcePos, 0);
        }
        return (lllllllllllIIllIIIIlIIIIllIIllIl == 0) ? lllllllllllIIllIIIIlIIIIllIIllII : lllllllllllIIllIIIIlIIIIllIIllIl;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllIIllIIIIlIIIIlllllIIl, final Entity lllllllllllIIllIIIIlIIIIlllllIII, final float lllllllllllIIllIIIIlIIIIlllIIlII, final float lllllllllllIIllIIIIlIIIIllllIllI, final float lllllllllllIIllIIIIlIIIIlllIIIlI, final float lllllllllllIIllIIIIlIIIIlllIIIIl, final float lllllllllllIIllIIIIlIIIIlllIIIII, final float lllllllllllIIllIIIIlIIIIllIlllll) {
        float lllllllllllIIllIIIIlIIIIllllIIIl = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float lllllllllllIIllIIIIlIIIIllllIIII = lllllllllllIIllIIIIlIIIIllllIIIl + 0.015609375f;
        float lllllllllllIIllIIIIlIIIIlllIllll = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float lllllllllllIIllIIIIlIIIIlllIlllI = lllllllllllIIllIIIIlIIIIlllIllll + 0.015609375f;
        final float lllllllllllIIllIIIIlIIIIlllIllIl = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllIIllIIIIlIIIIllllIIIl = this.particleTexture.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            lllllllllllIIllIIIIlIIIIllllIIII = this.particleTexture.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            lllllllllllIIllIIIIlIIIIlllIllll = this.particleTexture.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            lllllllllllIIllIIIIlIIIIlllIlllI = this.particleTexture.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float lllllllllllIIllIIIIlIIIIlllIllII = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllIIllIIIIlIIIIlllIIlII - ParticleDigging.interpPosX);
        final float lllllllllllIIllIIIIlIIIIlllIlIll = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllIIllIIIIlIIIIlllIIlII - ParticleDigging.interpPosY);
        final float lllllllllllIIllIIIIlIIIIlllIlIlI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllIIllIIIIlIIIIlllIIlII - ParticleDigging.interpPosZ);
        final int lllllllllllIIllIIIIlIIIIlllIlIIl = this.getBrightnessForRender(lllllllllllIIllIIIIlIIIIlllIIlII);
        final int lllllllllllIIllIIIIlIIIIlllIlIII = lllllllllllIIllIIIIlIIIIlllIlIIl >> 16 & 0xFFFF;
        final int lllllllllllIIllIIIIlIIIIlllIIlll = lllllllllllIIllIIIIlIIIIlllIlIIl & 0xFFFF;
        lllllllllllIIllIIIIlIIIIlllllIIl.pos(lllllllllllIIllIIIIlIIIIlllIllII - lllllllllllIIllIIIIlIIIIllllIllI * lllllllllllIIllIIIIlIIIIlllIllIl - lllllllllllIIllIIIIlIIIIlllIIIII * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIll - lllllllllllIIllIIIIlIIIIlllIIIlI * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIlI - lllllllllllIIllIIIIlIIIIlllIIIIl * lllllllllllIIllIIIIlIIIIlllIllIl - lllllllllllIIllIIIIlIIIIllIlllll * lllllllllllIIllIIIIlIIIIlllIllIl).tex(lllllllllllIIllIIIIlIIIIllllIIIl, lllllllllllIIllIIIIlIIIIlllIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIllIIIIlIIIIlllIlIII, lllllllllllIIllIIIIlIIIIlllIIlll).endVertex();
        lllllllllllIIllIIIIlIIIIlllllIIl.pos(lllllllllllIIllIIIIlIIIIlllIllII - lllllllllllIIllIIIIlIIIIllllIllI * lllllllllllIIllIIIIlIIIIlllIllIl + lllllllllllIIllIIIIlIIIIlllIIIII * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIll + lllllllllllIIllIIIIlIIIIlllIIIlI * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIlI - lllllllllllIIllIIIIlIIIIlllIIIIl * lllllllllllIIllIIIIlIIIIlllIllIl + lllllllllllIIllIIIIlIIIIllIlllll * lllllllllllIIllIIIIlIIIIlllIllIl).tex(lllllllllllIIllIIIIlIIIIllllIIIl, lllllllllllIIllIIIIlIIIIlllIllll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIllIIIIlIIIIlllIlIII, lllllllllllIIllIIIIlIIIIlllIIlll).endVertex();
        lllllllllllIIllIIIIlIIIIlllllIIl.pos(lllllllllllIIllIIIIlIIIIlllIllII + lllllllllllIIllIIIIlIIIIllllIllI * lllllllllllIIllIIIIlIIIIlllIllIl + lllllllllllIIllIIIIlIIIIlllIIIII * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIll + lllllllllllIIllIIIIlIIIIlllIIIlI * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIlI + lllllllllllIIllIIIIlIIIIlllIIIIl * lllllllllllIIllIIIIlIIIIlllIllIl + lllllllllllIIllIIIIlIIIIllIlllll * lllllllllllIIllIIIIlIIIIlllIllIl).tex(lllllllllllIIllIIIIlIIIIllllIIII, lllllllllllIIllIIIIlIIIIlllIllll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIllIIIIlIIIIlllIlIII, lllllllllllIIllIIIIlIIIIlllIIlll).endVertex();
        lllllllllllIIllIIIIlIIIIlllllIIl.pos(lllllllllllIIllIIIIlIIIIlllIllII + lllllllllllIIllIIIIlIIIIllllIllI * lllllllllllIIllIIIIlIIIIlllIllIl - lllllllllllIIllIIIIlIIIIlllIIIII * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIll - lllllllllllIIllIIIIlIIIIlllIIIlI * lllllllllllIIllIIIIlIIIIlllIllIl, lllllllllllIIllIIIIlIIIIlllIlIlI + lllllllllllIIllIIIIlIIIIlllIIIIl * lllllllllllIIllIIIIlIIIIlllIllIl - lllllllllllIIllIIIIlIIIIllIlllll * lllllllllllIIllIIIIlIIIIlllIllIl).tex(lllllllllllIIllIIIIlIIIIllllIIII, lllllllllllIIllIIIIlIIIIlllIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllIIllIIIIlIIIIlllIlIII, lllllllllllIIllIIIIlIIIIlllIIlll).endVertex();
    }
    
    public ParticleDigging setBlockPos(final BlockPos lllllllllllIIllIIIIlIIIlIIlIIIII) {
        this.sourcePos = lllllllllllIIllIIIIlIIIlIIlIIIII;
        if (this.sourceState.getBlock() == Blocks.GRASS) {
            return this;
        }
        this.multiplyColor(lllllllllllIIllIIIIlIIIlIIlIIIII);
        return this;
    }
    
    protected ParticleDigging(final World lllllllllllIIllIIIIlIIIlIIllIlII, final double lllllllllllIIllIIIIlIIIlIIllIIll, final double lllllllllllIIllIIIIlIIIlIIllIIlI, final double lllllllllllIIllIIIIlIIIlIIlIlIII, final double lllllllllllIIllIIIIlIIIlIIllIIII, final double lllllllllllIIllIIIIlIIIlIIlIIllI, final double lllllllllllIIllIIIIlIIIlIIlIIlIl, final IBlockState lllllllllllIIllIIIIlIIIlIIlIIlII) {
        super(lllllllllllIIllIIIIlIIIlIIllIlII, lllllllllllIIllIIIIlIIIlIIllIIll, lllllllllllIIllIIIIlIIIlIIllIIlI, lllllllllllIIllIIIIlIIIlIIlIlIII, lllllllllllIIllIIIIlIIIlIIllIIII, lllllllllllIIllIIIIlIIIlIIlIIllI, lllllllllllIIllIIIIlIIIlIIlIIlIl);
        this.sourceState = lllllllllllIIllIIIIlIIIlIIlIIlII;
        this.setParticleTexture(Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(lllllllllllIIllIIIIlIIIlIIlIIlII));
        this.particleGravity = lllllllllllIIllIIIIlIIIlIIlIIlII.getBlock().blockParticleGravity;
        this.particleRed = 0.6f;
        this.particleGreen = 0.6f;
        this.particleBlue = 0.6f;
        this.particleScale /= 2.0f;
    }
    
    protected void multiplyColor(@Nullable final BlockPos lllllllllllIIllIIIIlIIIlIIIlIIII) {
        final int lllllllllllIIllIIIIlIIIlIIIlIIlI = Minecraft.getMinecraft().getBlockColors().colorMultiplier(this.sourceState, this.worldObj, lllllllllllIIllIIIIlIIIlIIIlIIII, 0);
        this.particleRed *= (lllllllllllIIllIIIIlIIIlIIIlIIlI >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (lllllllllllIIllIIIIlIIIlIIIlIIlI >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (lllllllllllIIllIIIIlIIIlIIIlIIlI & 0xFF) / 255.0f;
    }
    
    public ParticleDigging init() {
        this.sourcePos = new BlockPos(this.posX, this.posY, this.posZ);
        final Block lllllllllllIIllIIIIlIIIlIIIllIlI = this.sourceState.getBlock();
        if (lllllllllllIIllIIIIlIIIlIIIllIlI == Blocks.GRASS) {
            return this;
        }
        this.multiplyColor(this.sourcePos);
        return this;
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlllIlIlIIIlIIIII, final World llllllllllllllIIlllIlIlIIIIlllll, final double llllllllllllllIIlllIlIlIIIIlIllI, final double llllllllllllllIIlllIlIlIIIIlIlIl, final double llllllllllllllIIlllIlIlIIIIlIlII, final double llllllllllllllIIlllIlIlIIIIlIIll, final double llllllllllllllIIlllIlIlIIIIllIlI, final double llllllllllllllIIlllIlIlIIIIlIIIl, final int... llllllllllllllIIlllIlIlIIIIllIII) {
            return new ParticleDigging(llllllllllllllIIlllIlIlIIIIlllll, llllllllllllllIIlllIlIlIIIIlIllI, llllllllllllllIIlllIlIlIIIIlIlIl, llllllllllllllIIlllIlIlIIIIlIlII, llllllllllllllIIlllIlIlIIIIlIIll, llllllllllllllIIlllIlIlIIIIllIlI, llllllllllllllIIlllIlIlIIIIlIIIl, Block.getStateById(llllllllllllllIIlllIlIlIIIIllIII[0])).init();
        }
    }
}
