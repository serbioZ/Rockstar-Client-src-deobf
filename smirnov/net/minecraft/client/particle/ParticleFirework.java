// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.util.SoundEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemDye;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;

public class ParticleFirework
{
    public static class Spark extends ParticleSimpleAnimated
    {
        private final /* synthetic */ ParticleManager effectRenderer;
        private /* synthetic */ boolean twinkle;
        private /* synthetic */ boolean trail;
        private /* synthetic */ float fadeColourRed;
        private /* synthetic */ float fadeColourBlue;
        private /* synthetic */ boolean hasFadeColour;
        private /* synthetic */ float fadeColourGreen;
        
        public void setTwinkle(final boolean lllllllllllllIlIlIllIlIlIllllIlI) {
            this.twinkle = lllllllllllllIlIlIllIlIlIllllIlI;
        }
        
        @Override
        public boolean isTransparent() {
            return true;
        }
        
        @Override
        public void renderParticle(final BufferBuilder lllllllllllllIlIlIllIlIlIllIlllI, final Entity lllllllllllllIlIlIllIlIlIllIllIl, final float lllllllllllllIlIlIllIlIlIllIllII, final float lllllllllllllIlIlIllIlIlIllIIIlI, final float lllllllllllllIlIlIllIlIlIllIlIlI, final float lllllllllllllIlIlIllIlIlIllIlIIl, final float lllllllllllllIlIlIllIlIlIlIlllll, final float lllllllllllllIlIlIllIlIlIlIllllI) {
            if (!this.twinkle || this.particleAge < this.particleMaxAge / 3 || (this.particleAge + this.particleMaxAge) / 3 % 2 == 0) {
                super.renderParticle(lllllllllllllIlIlIllIlIlIllIlllI, lllllllllllllIlIlIllIlIlIllIllIl, lllllllllllllIlIlIllIlIlIllIllII, lllllllllllllIlIlIllIlIlIllIIIlI, lllllllllllllIlIlIllIlIlIllIlIlI, lllllllllllllIlIlIllIlIlIllIlIIl, lllllllllllllIlIlIllIlIlIlIlllll, lllllllllllllIlIlIllIlIlIlIllllI);
            }
        }
        
        public void setTrail(final boolean lllllllllllllIlIlIllIlIllIIIIIII) {
            this.trail = lllllllllllllIlIlIllIlIllIIIIIII;
        }
        
        @Override
        public void onUpdate() {
            super.onUpdate();
            if (this.trail && this.particleAge < this.particleMaxAge / 2 && (this.particleAge + this.particleMaxAge) % 2 == 0) {
                final Spark lllllllllllllIlIlIllIlIlIlIllIlI = new Spark(this.worldObj, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, this.effectRenderer);
                lllllllllllllIlIlIllIlIlIlIllIlI.setAlphaF(0.99f);
                lllllllllllllIlIlIllIlIlIlIllIlI.setRBGColorF(this.particleRed, this.particleGreen, this.particleBlue);
                lllllllllllllIlIlIllIlIlIlIllIlI.particleAge = lllllllllllllIlIlIllIlIlIlIllIlI.particleMaxAge / 2;
                if (this.hasFadeColour) {
                    lllllllllllllIlIlIllIlIlIlIllIlI.hasFadeColour = true;
                    lllllllllllllIlIlIllIlIlIlIllIlI.fadeColourRed = this.fadeColourRed;
                    lllllllllllllIlIlIllIlIlIlIllIlI.fadeColourGreen = this.fadeColourGreen;
                    lllllllllllllIlIlIllIlIlIlIllIlI.fadeColourBlue = this.fadeColourBlue;
                }
                lllllllllllllIlIlIllIlIlIlIllIlI.twinkle = this.twinkle;
                this.effectRenderer.addEffect(lllllllllllllIlIlIllIlIlIlIllIlI);
            }
        }
        
        public Spark(final World lllllllllllllIlIlIllIlIllIIlIllI, final double lllllllllllllIlIlIllIlIllIIlIlIl, final double lllllllllllllIlIlIllIlIllIIlIlII, final double lllllllllllllIlIlIllIlIllIIIlIlI, final double lllllllllllllIlIlIllIlIllIIlIIlI, final double lllllllllllllIlIlIllIlIllIIlIIIl, final double lllllllllllllIlIlIllIlIllIIlIIII, final ParticleManager lllllllllllllIlIlIllIlIllIIIIllI) {
            super(lllllllllllllIlIlIllIlIllIIlIllI, lllllllllllllIlIlIllIlIllIIlIlIl, lllllllllllllIlIlIllIlIllIIlIlII, lllllllllllllIlIlIllIlIllIIIlIlI, 160, 8, -0.004f);
            this.motionX = lllllllllllllIlIlIllIlIllIIlIIlI;
            this.motionY = lllllllllllllIlIlIllIlIllIIlIIIl;
            this.motionZ = lllllllllllllIlIlIllIlIllIIlIIII;
            this.effectRenderer = lllllllllllllIlIlIllIlIllIIIIllI;
            this.particleScale *= 0.75f;
            this.particleMaxAge = 48 + this.rand.nextInt(12);
        }
    }
    
    public static class Overlay extends Particle
    {
        protected Overlay(final World lllllllllllIIIlllIIIIlllIlIllIll, final double lllllllllllIIIlllIIIIlllIlIlIlIl, final double lllllllllllIIIlllIIIIlllIlIlIlII, final double lllllllllllIIIlllIIIIlllIlIllIII) {
            super(lllllllllllIIIlllIIIIlllIlIllIll, lllllllllllIIIlllIIIIlllIlIlIlIl, lllllllllllIIIlllIIIIlllIlIlIlII, lllllllllllIIIlllIIIIlllIlIllIII);
            this.particleMaxAge = 4;
        }
        
        @Override
        public void renderParticle(final BufferBuilder lllllllllllIIIlllIIIIlllIIlllllI, final Entity lllllllllllIIIlllIIIIlllIIllllIl, final float lllllllllllIIIlllIIIIlllIIllllII, final float lllllllllllIIIlllIIIIlllIIlIlIII, final float lllllllllllIIIlllIIIIlllIIlllIlI, final float lllllllllllIIIlllIIIIlllIIlIIllI, final float lllllllllllIIIlllIIIIlllIIlllIII, final float lllllllllllIIIlllIIIIlllIIlIIlII) {
            final float lllllllllllIIIlllIIIIlllIIllIllI = 0.25f;
            final float lllllllllllIIIlllIIIIlllIIllIlIl = 0.5f;
            final float lllllllllllIIIlllIIIIlllIIllIlII = 0.125f;
            final float lllllllllllIIIlllIIIIlllIIllIIll = 0.375f;
            final float lllllllllllIIIlllIIIIlllIIllIIlI = 7.1f * MathHelper.sin((this.particleAge + lllllllllllIIIlllIIIIlllIIllllII - 1.0f) * 0.25f * 3.1415927f);
            this.setAlphaF(0.6f - (this.particleAge + lllllllllllIIIlllIIIIlllIIllllII - 1.0f) * 0.25f * 0.5f);
            final float lllllllllllIIIlllIIIIlllIIllIIIl = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllIIIlllIIIIlllIIllllII - Overlay.interpPosX);
            final float lllllllllllIIIlllIIIIlllIIllIIII = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllIIIlllIIIIlllIIllllII - Overlay.interpPosY);
            final float lllllllllllIIIlllIIIIlllIIlIllll = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllIIIlllIIIIlllIIllllII - Overlay.interpPosZ);
            final int lllllllllllIIIlllIIIIlllIIlIlllI = this.getBrightnessForRender(lllllllllllIIIlllIIIIlllIIllllII);
            final int lllllllllllIIIlllIIIIlllIIlIllIl = lllllllllllIIIlllIIIIlllIIlIlllI >> 16 & 0xFFFF;
            final int lllllllllllIIIlllIIIIlllIIlIllII = lllllllllllIIIlllIIIIlllIIlIlllI & 0xFFFF;
            lllllllllllIIIlllIIIIlllIIlllllI.pos(lllllllllllIIIlllIIIIlllIIllIIIl - lllllllllllIIIlllIIIIlllIIlIlIII * lllllllllllIIIlllIIIIlllIIllIIlI - lllllllllllIIIlllIIIIlllIIlllIII * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIllIIII - lllllllllllIIIlllIIIIlllIIlllIlI * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIlIllll - lllllllllllIIIlllIIIIlllIIlIIllI * lllllllllllIIIlllIIIIlllIIllIIlI - lllllllllllIIIlllIIIIlllIIlIIlII * lllllllllllIIIlllIIIIlllIIllIIlI).tex(0.5, 0.375).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIIIlllIIIIlllIIlIllIl, lllllllllllIIIlllIIIIlllIIlIllII).endVertex();
            lllllllllllIIIlllIIIIlllIIlllllI.pos(lllllllllllIIIlllIIIIlllIIllIIIl - lllllllllllIIIlllIIIIlllIIlIlIII * lllllllllllIIIlllIIIIlllIIllIIlI + lllllllllllIIIlllIIIIlllIIlllIII * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIllIIII + lllllllllllIIIlllIIIIlllIIlllIlI * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIlIllll - lllllllllllIIIlllIIIIlllIIlIIllI * lllllllllllIIIlllIIIIlllIIllIIlI + lllllllllllIIIlllIIIIlllIIlIIlII * lllllllllllIIIlllIIIIlllIIllIIlI).tex(0.5, 0.125).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIIIlllIIIIlllIIlIllIl, lllllllllllIIIlllIIIIlllIIlIllII).endVertex();
            lllllllllllIIIlllIIIIlllIIlllllI.pos(lllllllllllIIIlllIIIIlllIIllIIIl + lllllllllllIIIlllIIIIlllIIlIlIII * lllllllllllIIIlllIIIIlllIIllIIlI + lllllllllllIIIlllIIIIlllIIlllIII * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIllIIII + lllllllllllIIIlllIIIIlllIIlllIlI * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIlIllll + lllllllllllIIIlllIIIIlllIIlIIllI * lllllllllllIIIlllIIIIlllIIllIIlI + lllllllllllIIIlllIIIIlllIIlIIlII * lllllllllllIIIlllIIIIlllIIllIIlI).tex(0.25, 0.125).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIIIlllIIIIlllIIlIllIl, lllllllllllIIIlllIIIIlllIIlIllII).endVertex();
            lllllllllllIIIlllIIIIlllIIlllllI.pos(lllllllllllIIIlllIIIIlllIIllIIIl + lllllllllllIIIlllIIIIlllIIlIlIII * lllllllllllIIIlllIIIIlllIIllIIlI - lllllllllllIIIlllIIIIlllIIlllIII * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIllIIII - lllllllllllIIIlllIIIIlllIIlllIlI * lllllllllllIIIlllIIIIlllIIllIIlI, lllllllllllIIIlllIIIIlllIIlIllll + lllllllllllIIIlllIIIIlllIIlIIllI * lllllllllllIIIlllIIIIlllIIllIIlI - lllllllllllIIIlllIIIIlllIIlIIlII * lllllllllllIIIlllIIIIlllIIllIIlI).tex(0.25, 0.375).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(lllllllllllIIIlllIIIIlllIIlIllIl, lllllllllllIIIlllIIIIlllIIlIllII).endVertex();
        }
    }
    
    public static class Starter extends Particle
    {
        /* synthetic */ boolean twinkle;
        private /* synthetic */ int fireworkAge;
        private /* synthetic */ NBTTagList fireworkExplosions;
        private final /* synthetic */ ParticleManager theEffectRenderer;
        
        @Override
        public void onUpdate() {
            if (this.fireworkAge == 0 && this.fireworkExplosions != null) {
                final boolean llllllllllllIlIlIIIlIIlllIllIlll = this.isFarFromCamera();
                boolean llllllllllllIlIlIIIlIIlllIllIllI = false;
                if (this.fireworkExplosions.tagCount() >= 3) {
                    llllllllllllIlIlIIIlIIlllIllIllI = true;
                }
                else {
                    for (int llllllllllllIlIlIIIlIIlllIllIlIl = 0; llllllllllllIlIlIIIlIIlllIllIlIl < this.fireworkExplosions.tagCount(); ++llllllllllllIlIlIIIlIIlllIllIlIl) {
                        final NBTTagCompound llllllllllllIlIlIIIlIIlllIllIlII = this.fireworkExplosions.getCompoundTagAt(llllllllllllIlIlIIIlIIlllIllIlIl);
                        if (llllllllllllIlIlIIIlIIlllIllIlII.getByte("Type") == 1) {
                            llllllllllllIlIlIIIlIIlllIllIllI = true;
                            break;
                        }
                    }
                }
                SoundEvent llllllllllllIlIlIIIlIIlllIllIIlI = null;
                if (llllllllllllIlIlIIIlIIlllIllIllI) {
                    final SoundEvent llllllllllllIlIlIIIlIIlllIllIIll = llllllllllllIlIlIIIlIIlllIllIlll ? SoundEvents.ENTITY_FIREWORK_LARGE_BLAST_FAR : SoundEvents.ENTITY_FIREWORK_LARGE_BLAST;
                }
                else {
                    llllllllllllIlIlIIIlIIlllIllIIlI = (llllllllllllIlIlIIIlIIlllIllIlll ? SoundEvents.ENTITY_FIREWORK_BLAST_FAR : SoundEvents.ENTITY_FIREWORK_BLAST);
                }
                this.worldObj.playSound(this.posX, this.posY, this.posZ, llllllllllllIlIlIIIlIIlllIllIIlI, SoundCategory.AMBIENT, 20.0f, 0.95f + this.rand.nextFloat() * 0.1f, true);
            }
            if (this.fireworkAge % 2 == 0 && this.fireworkExplosions != null && this.fireworkAge / 2 < this.fireworkExplosions.tagCount()) {
                final int llllllllllllIlIlIIIlIIlllIllIIIl = this.fireworkAge / 2;
                final NBTTagCompound llllllllllllIlIlIIIlIIlllIllIIII = this.fireworkExplosions.getCompoundTagAt(llllllllllllIlIlIIIlIIlllIllIIIl);
                final int llllllllllllIlIlIIIlIIlllIlIllll = llllllllllllIlIlIIIlIIlllIllIIII.getByte("Type");
                final boolean llllllllllllIlIlIIIlIIlllIlIlllI = llllllllllllIlIlIIIlIIlllIllIIII.getBoolean("Trail");
                final boolean llllllllllllIlIlIIIlIIlllIlIllIl = llllllllllllIlIlIIIlIIlllIllIIII.getBoolean("Flicker");
                int[] llllllllllllIlIlIIIlIIlllIlIllII = llllllllllllIlIlIIIlIIlllIllIIII.getIntArray("Colors");
                final int[] llllllllllllIlIlIIIlIIlllIlIlIll = llllllllllllIlIlIIIlIIlllIllIIII.getIntArray("FadeColors");
                if (llllllllllllIlIlIIIlIIlllIlIllII.length == 0) {
                    llllllllllllIlIlIIIlIIlllIlIllII = new int[] { ItemDye.DYE_COLORS[0] };
                }
                if (llllllllllllIlIlIIIlIIlllIlIllll == 1) {
                    this.createBall(0.5, 4, llllllllllllIlIlIIIlIIlllIlIllII, llllllllllllIlIlIIIlIIlllIlIlIll, llllllllllllIlIlIIIlIIlllIlIlllI, llllllllllllIlIlIIIlIIlllIlIllIl);
                }
                else if (llllllllllllIlIlIIIlIIlllIlIllll == 2) {
                    this.createShaped(0.5, new double[][] { { 0.0, 1.0 }, { 0.3455, 0.309 }, { 0.9511, 0.309 }, { 0.3795918367346939, -0.12653061224489795 }, { 0.6122448979591837, -0.8040816326530612 }, { 0.0, -0.35918367346938773 } }, llllllllllllIlIlIIIlIIlllIlIllII, llllllllllllIlIlIIIlIIlllIlIlIll, llllllllllllIlIlIIIlIIlllIlIlllI, llllllllllllIlIlIIIlIIlllIlIllIl, false);
                }
                else if (llllllllllllIlIlIIIlIIlllIlIllll == 3) {
                    this.createShaped(0.5, new double[][] { { 0.0, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.6 }, { 0.6, 0.6 }, { 0.6, 0.2 }, { 0.2, 0.2 }, { 0.2, 0.0 }, { 0.4, 0.0 }, { 0.4, -0.6 }, { 0.2, -0.6 }, { 0.2, -0.4 }, { 0.0, -0.4 } }, llllllllllllIlIlIIIlIIlllIlIllII, llllllllllllIlIlIIIlIIlllIlIlIll, llllllllllllIlIlIIIlIIlllIlIlllI, llllllllllllIlIlIIIlIIlllIlIllIl, true);
                }
                else if (llllllllllllIlIlIIIlIIlllIlIllll == 4) {
                    this.createBurst(llllllllllllIlIlIIIlIIlllIlIllII, llllllllllllIlIlIIIlIIlllIlIlIll, llllllllllllIlIlIIIlIIlllIlIlllI, llllllllllllIlIlIIIlIIlllIlIllIl);
                }
                else {
                    this.createBall(0.25, 2, llllllllllllIlIlIIIlIIlllIlIllII, llllllllllllIlIlIIIlIIlllIlIlIll, llllllllllllIlIlIIIlIIlllIlIlllI, llllllllllllIlIlIIIlIIlllIlIllIl);
                }
                final int llllllllllllIlIlIIIlIIlllIlIlIlI = llllllllllllIlIlIIIlIIlllIlIllII[0];
                final float llllllllllllIlIlIIIlIIlllIlIlIIl = ((llllllllllllIlIlIIIlIIlllIlIlIlI & 0xFF0000) >> 16) / 255.0f;
                final float llllllllllllIlIlIIIlIIlllIlIlIII = ((llllllllllllIlIlIIIlIIlllIlIlIlI & 0xFF00) >> 8) / 255.0f;
                final float llllllllllllIlIlIIIlIIlllIlIIlll = ((llllllllllllIlIlIIIlIIlllIlIlIlI & 0xFF) >> 0) / 255.0f;
                final Overlay llllllllllllIlIlIIIlIIlllIlIIllI = new Overlay(this.worldObj, this.posX, this.posY, this.posZ);
                llllllllllllIlIlIIIlIIlllIlIIllI.setRBGColorF(llllllllllllIlIlIIIlIIlllIlIlIIl, llllllllllllIlIlIIIlIIlllIlIlIII, llllllllllllIlIlIIIlIIlllIlIIlll);
                this.theEffectRenderer.addEffect(llllllllllllIlIlIIIlIIlllIlIIllI);
            }
            ++this.fireworkAge;
            if (this.fireworkAge > this.particleMaxAge) {
                if (this.twinkle) {
                    final boolean llllllllllllIlIlIIIlIIlllIlIIlIl = this.isFarFromCamera();
                    final SoundEvent llllllllllllIlIlIIIlIIlllIlIIlII = llllllllllllIlIlIIIlIIlllIlIIlIl ? SoundEvents.ENTITY_FIREWORK_TWINKLE_FAR : SoundEvents.ENTITY_FIREWORK_TWINKLE;
                    this.worldObj.playSound(this.posX, this.posY, this.posZ, llllllllllllIlIlIIIlIIlllIlIIlII, SoundCategory.AMBIENT, 20.0f, 0.9f + this.rand.nextFloat() * 0.15f, true);
                }
                this.setExpired();
            }
        }
        
        private boolean isFarFromCamera() {
            final Minecraft llllllllllllIlIlIIIlIIlllIIlIIll = Minecraft.getMinecraft();
            return llllllllllllIlIlIIIlIIlllIIlIIll == null || llllllllllllIlIlIIIlIIlllIIlIIll.getRenderViewEntity() == null || llllllllllllIlIlIIIlIIlllIIlIIll.getRenderViewEntity().getDistanceSq(this.posX, this.posY, this.posZ) >= 256.0;
        }
        
        private void createBall(final double llllllllllllIlIlIIIlIIllIlIlIlll, final int llllllllllllIlIlIIIlIIllIlIlIllI, final int[] llllllllllllIlIlIIIlIIllIlIlIlIl, final int[] llllllllllllIlIlIIIlIIllIlIIIIll, final boolean llllllllllllIlIlIIIlIIllIlIlIIll, final boolean llllllllllllIlIlIIIlIIllIlIIIIIl) {
            final double llllllllllllIlIlIIIlIIllIlIlIIIl = this.posX;
            final double llllllllllllIlIlIIIlIIllIlIlIIII = this.posY;
            final double llllllllllllIlIlIIIlIIllIlIIllll = this.posZ;
            for (int llllllllllllIlIlIIIlIIllIlIIlllI = -llllllllllllIlIlIIIlIIllIlIlIllI; llllllllllllIlIlIIIlIIllIlIIlllI <= llllllllllllIlIlIIIlIIllIlIlIllI; ++llllllllllllIlIlIIIlIIllIlIIlllI) {
                for (int llllllllllllIlIlIIIlIIllIlIIllIl = -llllllllllllIlIlIIIlIIllIlIlIllI; llllllllllllIlIlIIIlIIllIlIIllIl <= llllllllllllIlIlIIIlIIllIlIlIllI; ++llllllllllllIlIlIIIlIIllIlIIllIl) {
                    for (int llllllllllllIlIlIIIlIIllIlIIllII = -llllllllllllIlIlIIIlIIllIlIlIllI; llllllllllllIlIlIIIlIIllIlIIllII <= llllllllllllIlIlIIIlIIllIlIlIllI; ++llllllllllllIlIlIIIlIIllIlIIllII) {
                        final double llllllllllllIlIlIIIlIIllIlIIlIll = llllllllllllIlIlIIIlIIllIlIIllIl + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double llllllllllllIlIlIIIlIIllIlIIlIlI = llllllllllllIlIlIIIlIIllIlIIlllI + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double llllllllllllIlIlIIIlIIllIlIIlIIl = llllllllllllIlIlIIIlIIllIlIIllII + (this.rand.nextDouble() - this.rand.nextDouble()) * 0.5;
                        final double llllllllllllIlIlIIIlIIllIlIIlIII = MathHelper.sqrt(llllllllllllIlIlIIIlIIllIlIIlIll * llllllllllllIlIlIIIlIIllIlIIlIll + llllllllllllIlIlIIIlIIllIlIIlIlI * llllllllllllIlIlIIIlIIllIlIIlIlI + llllllllllllIlIlIIIlIIllIlIIlIIl * llllllllllllIlIlIIIlIIllIlIIlIIl) / llllllllllllIlIlIIIlIIllIlIlIlll + this.rand.nextGaussian() * 0.05;
                        this.createParticle(llllllllllllIlIlIIIlIIllIlIlIIIl, llllllllllllIlIlIIIlIIllIlIlIIII, llllllllllllIlIlIIIlIIllIlIIllll, llllllllllllIlIlIIIlIIllIlIIlIll / llllllllllllIlIlIIIlIIllIlIIlIII, llllllllllllIlIlIIIlIIllIlIIlIlI / llllllllllllIlIlIIIlIIllIlIIlIII, llllllllllllIlIlIIIlIIllIlIIlIIl / llllllllllllIlIlIIIlIIllIlIIlIII, llllllllllllIlIlIIIlIIllIlIlIlIl, llllllllllllIlIlIIIlIIllIlIIIIll, llllllllllllIlIlIIIlIIllIlIlIIll, llllllllllllIlIlIIIlIIllIlIIIIIl);
                        if (llllllllllllIlIlIIIlIIllIlIIlllI != -llllllllllllIlIlIIIlIIllIlIlIllI && llllllllllllIlIlIIIlIIllIlIIlllI != llllllllllllIlIlIIIlIIllIlIlIllI && llllllllllllIlIlIIIlIIllIlIIllIl != -llllllllllllIlIlIIIlIIllIlIlIllI && llllllllllllIlIlIIIlIIllIlIIllIl != llllllllllllIlIlIIIlIIllIlIlIllI) {
                            llllllllllllIlIlIIIlIIllIlIIllII += llllllllllllIlIlIIIlIIllIlIlIllI * 2 - 1;
                        }
                    }
                }
            }
        }
        
        @Override
        public void renderParticle(final BufferBuilder llllllllllllIlIlIIIlIIllllIIllIl, final Entity llllllllllllIlIlIIIlIIllllIIllII, final float llllllllllllIlIlIIIlIIllllIIlIll, final float llllllllllllIlIlIIIlIIllllIIlIlI, final float llllllllllllIlIlIIIlIIllllIIlIIl, final float llllllllllllIlIlIIIlIIllllIIlIII, final float llllllllllllIlIlIIIlIIllllIIIlll, final float llllllllllllIlIlIIIlIIllllIIIllI) {
        }
        
        @Override
        public int getFXLayer() {
            return 0;
        }
        
        private void createParticle(final double llllllllllllIlIlIIIlIIlllIIIIIlI, final double llllllllllllIlIlIIIlIIllIlllIlII, final double llllllllllllIlIlIIIlIIlllIIIIIII, final double llllllllllllIlIlIIIlIIllIlllllll, final double llllllllllllIlIlIIIlIIllIlllIIIl, final double llllllllllllIlIlIIIlIIllIlllIIII, final int[] llllllllllllIlIlIIIlIIllIlllllII, final int[] llllllllllllIlIlIIIlIIllIllIlllI, final boolean llllllllllllIlIlIIIlIIllIllIllIl, final boolean llllllllllllIlIlIIIlIIllIllIllII) {
            final Spark llllllllllllIlIlIIIlIIllIllllIII = new Spark(this.worldObj, llllllllllllIlIlIIIlIIlllIIIIIlI, llllllllllllIlIlIIIlIIllIlllIlII, llllllllllllIlIlIIIlIIlllIIIIIII, llllllllllllIlIlIIIlIIllIlllllll, llllllllllllIlIlIIIlIIllIlllIIIl, llllllllllllIlIlIIIlIIllIlllIIII, this.theEffectRenderer);
            llllllllllllIlIlIIIlIIllIllllIII.setAlphaF(0.99f);
            llllllllllllIlIlIIIlIIllIllllIII.setTrail(llllllllllllIlIlIIIlIIllIllIllIl);
            llllllllllllIlIlIIIlIIllIllllIII.setTwinkle(llllllllllllIlIlIIIlIIllIllIllII);
            final int llllllllllllIlIlIIIlIIllIlllIlll = this.rand.nextInt(llllllllllllIlIlIIIlIIllIlllllII.length);
            llllllllllllIlIlIIIlIIllIllllIII.setColor(llllllllllllIlIlIIIlIIllIlllllII[llllllllllllIlIlIIIlIIllIlllIlll]);
            if (llllllllllllIlIlIIIlIIllIllIlllI != null && llllllllllllIlIlIIIlIIllIllIlllI.length > 0) {
                llllllllllllIlIlIIIlIIllIllllIII.setColorFade(llllllllllllIlIlIIIlIIllIllIlllI[this.rand.nextInt(llllllllllllIlIlIIIlIIllIllIlllI.length)]);
            }
            this.theEffectRenderer.addEffect(llllllllllllIlIlIIIlIIllIllllIII);
        }
        
        private void createBurst(final int[] llllllllllllIlIlIIIlIIlIllIlIlll, final int[] llllllllllllIlIlIIIlIIlIllIlIllI, final boolean llllllllllllIlIlIIIlIIlIlllIIIII, final boolean llllllllllllIlIlIIIlIIlIllIlllll) {
            final double llllllllllllIlIlIIIlIIlIllIllllI = this.rand.nextGaussian() * 0.05;
            final double llllllllllllIlIlIIIlIIlIllIlllIl = this.rand.nextGaussian() * 0.05;
            for (int llllllllllllIlIlIIIlIIlIllIlllII = 0; llllllllllllIlIlIIIlIIlIllIlllII < 70; ++llllllllllllIlIlIIIlIIlIllIlllII) {
                final double llllllllllllIlIlIIIlIIlIllIllIll = this.motionX * 0.5 + this.rand.nextGaussian() * 0.15 + llllllllllllIlIlIIIlIIlIllIllllI;
                final double llllllllllllIlIlIIIlIIlIllIllIlI = this.motionZ * 0.5 + this.rand.nextGaussian() * 0.15 + llllllllllllIlIlIIIlIIlIllIlllIl;
                final double llllllllllllIlIlIIIlIIlIllIllIIl = this.motionY * 0.5 + this.rand.nextDouble() * 0.5;
                this.createParticle(this.posX, this.posY, this.posZ, llllllllllllIlIlIIIlIIlIllIllIll, llllllllllllIlIlIIIlIIlIllIllIIl, llllllllllllIlIlIIIlIIlIllIllIlI, llllllllllllIlIlIIIlIIlIllIlIlll, llllllllllllIlIlIIIlIIlIllIlIllI, llllllllllllIlIlIIIlIIlIlllIIIII, llllllllllllIlIlIIIlIIlIllIlllll);
            }
        }
        
        private void createShaped(final double llllllllllllIlIlIIIlIIllIIIIIlII, final double[][] llllllllllllIlIlIIIlIIllIIIIIIlI, final int[] llllllllllllIlIlIIIlIIllIIIIIIIl, final int[] llllllllllllIlIlIIIlIIlIllllllll, final boolean llllllllllllIlIlIIIlIIllIIIllIIl, final boolean llllllllllllIlIlIIIlIIlIllllllIl, final boolean llllllllllllIlIlIIIlIIllIIIlIlll) {
            final double llllllllllllIlIlIIIlIIllIIIlIllI = llllllllllllIlIlIIIlIIllIIIIIIlI[0][0];
            final double llllllllllllIlIlIIIlIIllIIIlIlIl = llllllllllllIlIlIIIlIIllIIIIIIlI[0][1];
            this.createParticle(this.posX, this.posY, this.posZ, llllllllllllIlIlIIIlIIllIIIlIllI * llllllllllllIlIlIIIlIIllIIIIIlII, llllllllllllIlIlIIIlIIllIIIlIlIl * llllllllllllIlIlIIIlIIllIIIIIlII, 0.0, llllllllllllIlIlIIIlIIllIIIIIIIl, llllllllllllIlIlIIIlIIlIllllllll, llllllllllllIlIlIIIlIIllIIIllIIl, llllllllllllIlIlIIIlIIlIllllllIl);
            final float llllllllllllIlIlIIIlIIllIIIlIlII = this.rand.nextFloat() * 3.1415927f;
            final double llllllllllllIlIlIIIlIIllIIIlIIll = llllllllllllIlIlIIIlIIllIIIlIlll ? 0.034 : 0.34;
            for (int llllllllllllIlIlIIIlIIllIIIlIIlI = 0; llllllllllllIlIlIIIlIIllIIIlIIlI < 3; ++llllllllllllIlIlIIIlIIllIIIlIIlI) {
                final double llllllllllllIlIlIIIlIIllIIIlIIIl = llllllllllllIlIlIIIlIIllIIIlIlII + llllllllllllIlIlIIIlIIllIIIlIIlI * 3.1415927f * llllllllllllIlIlIIIlIIllIIIlIIll;
                double llllllllllllIlIlIIIlIIllIIIlIIII = llllllllllllIlIlIIIlIIllIIIlIllI;
                double llllllllllllIlIlIIIlIIllIIIIllll = llllllllllllIlIlIIIlIIllIIIlIlIl;
                for (int llllllllllllIlIlIIIlIIllIIIIlllI = 1; llllllllllllIlIlIIIlIIllIIIIlllI < llllllllllllIlIlIIIlIIllIIIIIIlI.length; ++llllllllllllIlIlIIIlIIllIIIIlllI) {
                    final double llllllllllllIlIlIIIlIIllIIIIllIl = llllllllllllIlIlIIIlIIllIIIIIIlI[llllllllllllIlIlIIIlIIllIIIIlllI][0];
                    final double llllllllllllIlIlIIIlIIllIIIIllII = llllllllllllIlIlIIIlIIllIIIIIIlI[llllllllllllIlIlIIIlIIllIIIIlllI][1];
                    for (double llllllllllllIlIlIIIlIIllIIIIlIll = 0.25; llllllllllllIlIlIIIlIIllIIIIlIll <= 1.0; llllllllllllIlIlIIIlIIllIIIIlIll += 0.25) {
                        double llllllllllllIlIlIIIlIIllIIIIlIlI = (llllllllllllIlIlIIIlIIllIIIlIIII + (llllllllllllIlIlIIIlIIllIIIIllIl - llllllllllllIlIlIIIlIIllIIIlIIII) * llllllllllllIlIlIIIlIIllIIIIlIll) * llllllllllllIlIlIIIlIIllIIIIIlII;
                        final double llllllllllllIlIlIIIlIIllIIIIlIIl = (llllllllllllIlIlIIIlIIllIIIIllll + (llllllllllllIlIlIIIlIIllIIIIllII - llllllllllllIlIlIIIlIIllIIIIllll) * llllllllllllIlIlIIIlIIllIIIIlIll) * llllllllllllIlIlIIIlIIllIIIIIlII;
                        final double llllllllllllIlIlIIIlIIllIIIIlIII = llllllllllllIlIlIIIlIIllIIIIlIlI * Math.sin(llllllllllllIlIlIIIlIIllIIIlIIIl);
                        llllllllllllIlIlIIIlIIllIIIIlIlI *= Math.cos(llllllllllllIlIlIIIlIIllIIIlIIIl);
                        for (double llllllllllllIlIlIIIlIIllIIIIIlll = -1.0; llllllllllllIlIlIIIlIIllIIIIIlll <= 1.0; llllllllllllIlIlIIIlIIllIIIIIlll += 2.0) {
                            this.createParticle(this.posX, this.posY, this.posZ, llllllllllllIlIlIIIlIIllIIIIlIlI * llllllllllllIlIlIIIlIIllIIIIIlll, llllllllllllIlIlIIIlIIllIIIIlIIl, llllllllllllIlIlIIIlIIllIIIIlIII * llllllllllllIlIlIIIlIIllIIIIIlll, llllllllllllIlIlIIIlIIllIIIIIIIl, llllllllllllIlIlIIIlIIlIllllllll, llllllllllllIlIlIIIlIIllIIIllIIl, llllllllllllIlIlIIIlIIlIllllllIl);
                        }
                    }
                    llllllllllllIlIlIIIlIIllIIIlIIII = llllllllllllIlIlIIIlIIllIIIIllIl;
                    llllllllllllIlIlIIIlIIllIIIIllll = llllllllllllIlIlIIIlIIllIIIIllII;
                }
            }
        }
        
        public Starter(final World llllllllllllIlIlIIIlIIlllllIIlIl, final double llllllllllllIlIlIIIlIIllllIlIllI, final double llllllllllllIlIlIIIlIIlllllIIIll, final double llllllllllllIlIlIIIlIIlllllIIIlI, final double llllllllllllIlIlIIIlIIllllIlIIll, final double llllllllllllIlIlIIIlIIlllllIIIII, final double llllllllllllIlIlIIIlIIllllIlllll, final ParticleManager llllllllllllIlIlIIIlIIllllIllllI, @Nullable final NBTTagCompound llllllllllllIlIlIIIlIIllllIIllll) {
            super(llllllllllllIlIlIIIlIIlllllIIlIl, llllllllllllIlIlIIIlIIllllIlIllI, llllllllllllIlIlIIIlIIlllllIIIll, llllllllllllIlIlIIIlIIlllllIIIlI, 0.0, 0.0, 0.0);
            this.motionX = llllllllllllIlIlIIIlIIllllIlIIll;
            this.motionY = llllllllllllIlIlIIIlIIlllllIIIII;
            this.motionZ = llllllllllllIlIlIIIlIIllllIlllll;
            this.theEffectRenderer = llllllllllllIlIlIIIlIIllllIllllI;
            this.particleMaxAge = 8;
            if (llllllllllllIlIlIIIlIIllllIIllll != null) {
                this.fireworkExplosions = llllllllllllIlIlIIIlIIllllIIllll.getTagList("Explosions", 10);
                if (this.fireworkExplosions.hasNoTags()) {
                    this.fireworkExplosions = null;
                }
                else {
                    this.particleMaxAge = this.fireworkExplosions.tagCount() * 2 - 1;
                    for (int llllllllllllIlIlIIIlIIllllIlllII = 0; llllllllllllIlIlIIIlIIllllIlllII < this.fireworkExplosions.tagCount(); ++llllllllllllIlIlIIIlIIllllIlllII) {
                        final NBTTagCompound llllllllllllIlIlIIIlIIllllIllIll = this.fireworkExplosions.getCompoundTagAt(llllllllllllIlIlIIIlIIllllIlllII);
                        if (llllllllllllIlIlIIIlIIllllIllIll.getBoolean("Flicker")) {
                            this.twinkle = true;
                            this.particleMaxAge += 15;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllIIlIlIllIIllIIIlIlIII, final World lllllllllllIIlIlIllIIllIIIlIIlll, final double lllllllllllIIlIlIllIIllIIIIlllII, final double lllllllllllIIlIlIllIIllIIIlIIlIl, final double lllllllllllIIlIlIllIIllIIIIllIlI, final double lllllllllllIIlIlIllIIllIIIlIIIll, final double lllllllllllIIlIlIllIIllIIIlIIIlI, final double lllllllllllIIlIlIllIIllIIIIlIlll, final int... lllllllllllIIlIlIllIIllIIIlIIIII) {
            final Spark lllllllllllIIlIlIllIIllIIIIlllll = new Spark(lllllllllllIIlIlIllIIllIIIlIIlll, lllllllllllIIlIlIllIIllIIIIlllII, lllllllllllIIlIlIllIIllIIIlIIlIl, lllllllllllIIlIlIllIIllIIIIllIlI, lllllllllllIIlIlIllIIllIIIlIIIll, lllllllllllIIlIlIllIIllIIIlIIIlI, lllllllllllIIlIlIllIIllIIIIlIlll, Minecraft.getMinecraft().effectRenderer);
            lllllllllllIIlIlIllIIllIIIIlllll.setAlphaF(0.99f);
            return lllllllllllIIlIlIllIIllIIIIlllll;
        }
    }
}
