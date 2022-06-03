// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import optifine.Reflector;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Iterator;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import java.util.List;
import java.util.Collection;
import com.google.common.collect.Lists;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ActiveRenderInfo;
import optifine.Config;
import javax.annotation.Nullable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;
import java.util.Queue;
import net.minecraft.world.World;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import java.util.ArrayDeque;
import net.minecraft.client.renderer.texture.TextureManager;

public class ParticleManager
{
    private final /* synthetic */ TextureManager renderer;
    private final /* synthetic */ ArrayDeque<Particle>[][] fxLayers;
    private static final /* synthetic */ ResourceLocation PARTICLE_TEXTURES;
    private final /* synthetic */ Random rand;
    private final /* synthetic */ Map<Integer, IParticleFactory> particleTypes;
    protected /* synthetic */ World worldObj;
    private final /* synthetic */ Queue<ParticleEmitter> particleEmitters;
    private final /* synthetic */ Queue<Particle> queueEntityFX;
    
    public void emitParticleAtEntity(final Entity llllllllllllIlIllIlIIIIIllIIllII, final EnumParticleTypes llllllllllllIlIllIlIIIIIllIIlllI) {
        this.particleEmitters.add(new ParticleEmitter(this.worldObj, llllllllllllIlIllIlIIIIIllIIllII, llllllllllllIlIllIlIIIIIllIIlllI));
    }
    
    static {
        PARTICLE_TEXTURES = new ResourceLocation("textures/particle/particles.png");
    }
    
    private void updateEffectLayer(final int llllllllllllIlIllIlIIIIIlIIIIIIl) {
        this.worldObj.theProfiler.startSection(String.valueOf(llllllllllllIlIllIlIIIIIlIIIIIIl));
        for (int llllllllllllIlIllIlIIIIIlIIIIIll = 0; llllllllllllIlIllIlIIIIIlIIIIIll < 2; ++llllllllllllIlIllIlIIIIIlIIIIIll) {
            this.worldObj.theProfiler.startSection(String.valueOf(llllllllllllIlIllIlIIIIIlIIIIIll));
            this.tickParticleList(this.fxLayers[llllllllllllIlIllIlIIIIIlIIIIIIl][llllllllllllIlIllIlIIIIIlIIIIIll]);
            this.worldObj.theProfiler.endSection();
        }
        this.worldObj.theProfiler.endSection();
    }
    
    @Nullable
    public Particle spawnEffectParticle(final int llllllllllllIlIllIlIIIIIlIlIIllI, final double llllllllllllIlIllIlIIIIIlIllIIIl, final double llllllllllllIlIllIlIIIIIlIllIIII, final double llllllllllllIlIllIlIIIIIlIlIllll, final double llllllllllllIlIllIlIIIIIlIlIlllI, final double llllllllllllIlIllIlIIIIIlIlIllIl, final double llllllllllllIlIllIlIIIIIlIlIllII, final int... llllllllllllIlIllIlIIIIIlIlIlIll) {
        final IParticleFactory llllllllllllIlIllIlIIIIIlIlIlIlI = this.particleTypes.get(llllllllllllIlIllIlIIIIIlIlIIllI);
        if (llllllllllllIlIllIlIIIIIlIlIlIlI != null) {
            final Particle llllllllllllIlIllIlIIIIIlIlIlIIl = llllllllllllIlIllIlIIIIIlIlIlIlI.createParticle(llllllllllllIlIllIlIIIIIlIlIIllI, this.worldObj, llllllllllllIlIllIlIIIIIlIllIIIl, llllllllllllIlIllIlIIIIIlIllIIII, llllllllllllIlIllIlIIIIIlIlIllll, llllllllllllIlIllIlIIIIIlIlIlllI, llllllllllllIlIllIlIIIIIlIlIllIl, llllllllllllIlIllIlIIIIIlIlIllII, llllllllllllIlIllIlIIIIIlIlIlIll);
            if (llllllllllllIlIllIlIIIIIlIlIlIIl != null) {
                this.addEffect(llllllllllllIlIllIlIIIIIlIlIlIIl);
                return llllllllllllIlIllIlIIIIIlIlIlIIl;
            }
        }
        return null;
    }
    
    public void addEffect(final Particle llllllllllllIlIllIlIIIIIlIIllIII) {
        if (llllllllllllIlIllIlIIIIIlIIllIII != null && (!(llllllllllllIlIllIlIIIIIlIIllIII instanceof ParticleFirework.Spark) || Config.isFireworkParticles())) {
            this.queueEntityFX.add(llllllllllllIlIllIlIIIIIlIIllIII);
        }
    }
    
    private void registerVanillaParticles() {
        this.registerParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleID(), new ParticleExplosion.Factory());
        this.registerParticle(EnumParticleTypes.SPIT.getParticleID(), new ParticleSpit.Factory());
        this.registerParticle(EnumParticleTypes.WATER_BUBBLE.getParticleID(), new ParticleBubble.Factory());
        this.registerParticle(EnumParticleTypes.WATER_SPLASH.getParticleID(), new ParticleSplash.Factory());
        this.registerParticle(EnumParticleTypes.WATER_WAKE.getParticleID(), new ParticleWaterWake.Factory());
        this.registerParticle(EnumParticleTypes.WATER_DROP.getParticleID(), new ParticleRain.Factory());
        this.registerParticle(EnumParticleTypes.SUSPENDED.getParticleID(), new ParticleSuspend.Factory());
        this.registerParticle(EnumParticleTypes.SUSPENDED_DEPTH.getParticleID(), new ParticleSuspendedTown.Factory());
        this.registerParticle(EnumParticleTypes.CRIT.getParticleID(), new ParticleCrit.Factory());
        this.registerParticle(EnumParticleTypes.CRIT_MAGIC.getParticleID(), new ParticleCrit.MagicFactory());
        this.registerParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleID(), new ParticleSmokeNormal.Factory());
        this.registerParticle(EnumParticleTypes.SMOKE_LARGE.getParticleID(), new ParticleSmokeLarge.Factory());
        this.registerParticle(EnumParticleTypes.SPELL.getParticleID(), new ParticleSpell.Factory());
        this.registerParticle(EnumParticleTypes.SPELL_INSTANT.getParticleID(), new ParticleSpell.InstantFactory());
        this.registerParticle(EnumParticleTypes.SPELL_MOB.getParticleID(), new ParticleSpell.MobFactory());
        this.registerParticle(EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID(), new ParticleSpell.AmbientMobFactory());
        this.registerParticle(EnumParticleTypes.SPELL_WITCH.getParticleID(), new ParticleSpell.WitchFactory());
        this.registerParticle(EnumParticleTypes.DRIP_WATER.getParticleID(), new ParticleDrip.WaterFactory());
        this.registerParticle(EnumParticleTypes.DRIP_LAVA.getParticleID(), new ParticleDrip.LavaFactory());
        this.registerParticle(EnumParticleTypes.VILLAGER_ANGRY.getParticleID(), new ParticleHeart.AngryVillagerFactory());
        this.registerParticle(EnumParticleTypes.VILLAGER_HAPPY.getParticleID(), new ParticleSuspendedTown.HappyVillagerFactory());
        this.registerParticle(EnumParticleTypes.TOWN_AURA.getParticleID(), new ParticleSuspendedTown.Factory());
        this.registerParticle(EnumParticleTypes.NOTE.getParticleID(), new ParticleNote.Factory());
        this.registerParticle(EnumParticleTypes.PORTAL.getParticleID(), new ParticlePortal.Factory());
        this.registerParticle(EnumParticleTypes.ENCHANTMENT_TABLE.getParticleID(), new ParticleEnchantmentTable.EnchantmentTable());
        this.registerParticle(EnumParticleTypes.FLAME.getParticleID(), new ParticleFlame.Factory());
        this.registerParticle(EnumParticleTypes.LAVA.getParticleID(), new ParticleLava.Factory());
        this.registerParticle(EnumParticleTypes.FOOTSTEP.getParticleID(), new ParticleFootStep.Factory());
        this.registerParticle(EnumParticleTypes.CLOUD.getParticleID(), new ParticleCloud.Factory());
        this.registerParticle(EnumParticleTypes.REDSTONE.getParticleID(), new ParticleRedstone.Factory());
        this.registerParticle(EnumParticleTypes.FALLING_DUST.getParticleID(), new ParticleFallingDust.Factory());
        this.registerParticle(EnumParticleTypes.SNOWBALL.getParticleID(), new ParticleBreaking.SnowballFactory());
        this.registerParticle(EnumParticleTypes.SNOW_SHOVEL.getParticleID(), new ParticleSnowShovel.Factory());
        this.registerParticle(EnumParticleTypes.SLIME.getParticleID(), new ParticleBreaking.SlimeFactory());
        this.registerParticle(EnumParticleTypes.HEART.getParticleID(), new ParticleHeart.Factory());
        this.registerParticle(EnumParticleTypes.BARRIER.getParticleID(), new Barrier.Factory());
        this.registerParticle(EnumParticleTypes.ITEM_CRACK.getParticleID(), new ParticleBreaking.Factory());
        this.registerParticle(EnumParticleTypes.BLOCK_CRACK.getParticleID(), new ParticleDigging.Factory());
        this.registerParticle(EnumParticleTypes.BLOCK_DUST.getParticleID(), new ParticleBlockDust.Factory());
        this.registerParticle(EnumParticleTypes.EXPLOSION_HUGE.getParticleID(), new ParticleExplosionHuge.Factory());
        this.registerParticle(EnumParticleTypes.EXPLOSION_LARGE.getParticleID(), new ParticleExplosionLarge.Factory());
        this.registerParticle(EnumParticleTypes.FIREWORKS_SPARK.getParticleID(), new ParticleFirework.Factory());
        this.registerParticle(EnumParticleTypes.MOB_APPEARANCE.getParticleID(), new ParticleMobAppearance.Factory());
        this.registerParticle(EnumParticleTypes.DRAGON_BREATH.getParticleID(), new ParticleDragonBreath.Factory());
        this.registerParticle(EnumParticleTypes.END_ROD.getParticleID(), new ParticleEndRod.Factory());
        this.registerParticle(EnumParticleTypes.DAMAGE_INDICATOR.getParticleID(), new ParticleCrit.DamageIndicatorFactory());
        this.registerParticle(EnumParticleTypes.SWEEP_ATTACK.getParticleID(), new ParticleSweepAttack.Factory());
        this.registerParticle(EnumParticleTypes.TOTEM.getParticleID(), new ParticleTotem.Factory());
    }
    
    public void renderParticles(final Entity llllllllllllIlIllIlIIIIIIIllllIl, final float llllllllllllIlIllIlIIIIIIlIIllIl) {
        final float llllllllllllIlIllIlIIIIIIlIIllII = ActiveRenderInfo.getRotationX();
        final float llllllllllllIlIllIlIIIIIIlIIlIll = ActiveRenderInfo.getRotationZ();
        final float llllllllllllIlIllIlIIIIIIlIIlIlI = ActiveRenderInfo.getRotationYZ();
        final float llllllllllllIlIllIlIIIIIIlIIlIIl = ActiveRenderInfo.getRotationXY();
        final float llllllllllllIlIllIlIIIIIIlIIlIII = ActiveRenderInfo.getRotationXZ();
        Particle.interpPosX = llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosX + (llllllllllllIlIllIlIIIIIIIllllIl.posX - llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosX) * llllllllllllIlIllIlIIIIIIlIIllIl;
        Particle.interpPosY = llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosY + (llllllllllllIlIllIlIIIIIIIllllIl.posY - llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosY) * llllllllllllIlIllIlIIIIIIlIIllIl;
        Particle.interpPosZ = llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosZ + (llllllllllllIlIllIlIIIIIIIllllIl.posZ - llllllllllllIlIllIlIIIIIIIllllIl.lastTickPosZ) * llllllllllllIlIllIlIIIIIIlIIllIl;
        Particle.cameraViewDir = llllllllllllIlIllIlIIIIIIIllllIl.getLook(llllllllllllIlIllIlIIIIIIlIIllIl);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.alphaFunc(516, 0.003921569f);
        for (int llllllllllllIlIllIlIIIIIIlIIIlll = 0; llllllllllllIlIllIlIIIIIIlIIIlll < 3; ++llllllllllllIlIllIlIIIIIIlIIIlll) {
            final int llllllllllllIlIllIlIIIIIIlIIIllI = llllllllllllIlIllIlIIIIIIlIIIlll;
            for (int llllllllllllIlIllIlIIIIIIlIIIlIl = 0; llllllllllllIlIllIlIIIIIIlIIIlIl < 2; ++llllllllllllIlIllIlIIIIIIlIIIlIl) {
                if (!this.fxLayers[llllllllllllIlIllIlIIIIIIlIIIllI][llllllllllllIlIllIlIIIIIIlIIIlIl].isEmpty()) {
                    switch (llllllllllllIlIllIlIIIIIIlIIIlIl) {
                        case 0: {
                            GlStateManager.depthMask(false);
                            break;
                        }
                        case 1: {
                            GlStateManager.depthMask(true);
                            break;
                        }
                    }
                    switch (llllllllllllIlIllIlIIIIIIlIIIllI) {
                        default: {
                            this.renderer.bindTexture(ParticleManager.PARTICLE_TEXTURES);
                            break;
                        }
                        case 1: {
                            this.renderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                            break;
                        }
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    final Tessellator llllllllllllIlIllIlIIIIIIlIIIlII = Tessellator.getInstance();
                    final BufferBuilder llllllllllllIlIllIlIIIIIIlIIIIll = llllllllllllIlIllIlIIIIIIlIIIlII.getBuffer();
                    llllllllllllIlIllIlIIIIIIlIIIIll.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                    for (final Particle llllllllllllIlIllIlIIIIIIlIIIIlI : this.fxLayers[llllllllllllIlIllIlIIIIIIlIIIllI][llllllllllllIlIllIlIIIIIIlIIIlIl]) {
                        try {
                            llllllllllllIlIllIlIIIIIIlIIIIlI.renderParticle(llllllllllllIlIllIlIIIIIIlIIIIll, llllllllllllIlIllIlIIIIIIIllllIl, llllllllllllIlIllIlIIIIIIlIIllIl, llllllllllllIlIllIlIIIIIIlIIllII, llllllllllllIlIllIlIIIIIIlIIlIII, llllllllllllIlIllIlIIIIIIlIIlIll, llllllllllllIlIllIlIIIIIIlIIlIlI, llllllllllllIlIllIlIIIIIIlIIlIIl);
                        }
                        catch (Throwable llllllllllllIlIllIlIIIIIIlIIIIIl) {
                            final CrashReport llllllllllllIlIllIlIIIIIIlIIIIII = CrashReport.makeCrashReport(llllllllllllIlIllIlIIIIIIlIIIIIl, "Rendering Particle");
                            final CrashReportCategory llllllllllllIlIllIlIIIIIIIllllll = llllllllllllIlIllIlIIIIIIlIIIIII.makeCategory("Particle being rendered");
                            llllllllllllIlIllIlIIIIIIIllllll.setDetail("Particle", new ICrashReportDetail<String>() {
                                @Override
                                public String call() throws Exception {
                                    return llllllllllllIlIllIlIIIIIIlIIIIlI.toString();
                                }
                            });
                            llllllllllllIlIllIlIIIIIIIllllll.setDetail("Particle Type", new ICrashReportDetail<String>() {
                                @Override
                                public String call() throws Exception {
                                    if (llllllllllllIlIllIlIIIIIIlIIIllI == 0) {
                                        return "MISC_TEXTURE";
                                    }
                                    if (llllllllllllIlIllIlIIIIIIlIIIllI == 1) {
                                        return "TERRAIN_TEXTURE";
                                    }
                                    return (llllllllllllIlIllIlIIIIIIlIIIllI == 3) ? "ENTITY_PARTICLE_TEXTURE" : ("Unknown - " + llllllllllllIlIllIlIIIIIIlIIIllI);
                                }
                            });
                            throw new ReportedException(llllllllllllIlIllIlIIIIIIlIIIIII);
                        }
                    }
                    llllllllllllIlIllIlIIIIIIlIIIlII.draw();
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc(516, 0.1f);
    }
    
    public String getStatistics() {
        int llllllllllllIlIllIIllllllIlIlIII = 0;
        for (int llllllllllllIlIllIIllllllIlIIlll = 0; llllllllllllIlIllIIllllllIlIIlll < 4; ++llllllllllllIlIllIIllllllIlIIlll) {
            for (int llllllllllllIlIllIIllllllIlIIllI = 0; llllllllllllIlIllIIllllllIlIIllI < 2; ++llllllllllllIlIllIIllllllIlIIllI) {
                llllllllllllIlIllIIllllllIlIlIII += this.fxLayers[llllllllllllIlIllIIllllllIlIIlll][llllllllllllIlIllIIllllllIlIIllI].size();
            }
        }
        return new StringBuilder().append(llllllllllllIlIllIIllllllIlIlIII).toString();
    }
    
    public void updateEffects() {
        for (int llllllllllllIlIllIlIIIIIlIIlIIlI = 0; llllllllllllIlIllIlIIIIIlIIlIIlI < 4; ++llllllllllllIlIllIlIIIIIlIIlIIlI) {
            this.updateEffectLayer(llllllllllllIlIllIlIIIIIlIIlIIlI);
        }
        if (!this.particleEmitters.isEmpty()) {
            final List<ParticleEmitter> llllllllllllIlIllIlIIIIIlIIlIIIl = (List<ParticleEmitter>)Lists.newArrayList();
            for (final ParticleEmitter llllllllllllIlIllIlIIIIIlIIlIIII : this.particleEmitters) {
                llllllllllllIlIllIlIIIIIlIIlIIII.onUpdate();
                if (!llllllllllllIlIllIlIIIIIlIIlIIII.isAlive()) {
                    llllllllllllIlIllIlIIIIIlIIlIIIl.add(llllllllllllIlIllIlIIIIIlIIlIIII);
                }
            }
            this.particleEmitters.removeAll(llllllllllllIlIllIlIIIIIlIIlIIIl);
        }
        if (!this.queueEntityFX.isEmpty()) {
            for (Particle llllllllllllIlIllIlIIIIIlIIIllll = this.queueEntityFX.poll(); llllllllllllIlIllIlIIIIIlIIIllll != null; llllllllllllIlIllIlIIIIIlIIIllll = this.queueEntityFX.poll()) {
                final int llllllllllllIlIllIlIIIIIlIIIlllI = llllllllllllIlIllIlIIIIIlIIIllll.getFXLayer();
                final int llllllllllllIlIllIlIIIIIlIIIllIl = llllllllllllIlIllIlIIIIIlIIIllll.isTransparent() ? 0 : 1;
                if (this.fxLayers[llllllllllllIlIllIlIIIIIlIIIlllI][llllllllllllIlIllIlIIIIIlIIIllIl].size() >= 16384) {
                    this.fxLayers[llllllllllllIlIllIlIIIIIlIIIlllI][llllllllllllIlIllIlIIIIIlIIIllIl].removeFirst();
                }
                if (!(llllllllllllIlIllIlIIIIIlIIIllll instanceof Barrier) || !this.reuseBarrierParticle(llllllllllllIlIllIlIIIIIlIIIllll, this.fxLayers[llllllllllllIlIllIlIIIIIlIIIlllI][llllllllllllIlIllIlIIIIIlIIIllIl])) {
                    this.fxLayers[llllllllllllIlIllIlIIIIIlIIIlllI][llllllllllllIlIllIlIIIIIlIIIllIl].add(llllllllllllIlIllIlIIIIIlIIIllll);
                }
            }
        }
    }
    
    private boolean reuseBarrierParticle(final Particle llllllllllllIlIllIIllllllIIlllII, final ArrayDeque<Particle> llllllllllllIlIllIIllllllIIllIII) {
        for (final Particle llllllllllllIlIllIIllllllIIllIlI : llllllllllllIlIllIIllllllIIllIII) {
            if (llllllllllllIlIllIIllllllIIllIlI instanceof Barrier && llllllllllllIlIllIIllllllIIlllII.prevPosX == llllllllllllIlIllIIllllllIIllIlI.prevPosX && llllllllllllIlIllIIllllllIIlllII.prevPosY == llllllllllllIlIllIIllllllIIllIlI.prevPosY && llllllllllllIlIllIIllllllIIlllII.prevPosZ == llllllllllllIlIllIIllllllIIllIlI.prevPosZ) {
                llllllllllllIlIllIIllllllIIllIlI.particleAge = 0;
                return true;
            }
        }
        return false;
    }
    
    public void clearEffects(@Nullable final World llllllllllllIlIllIIllllllllllIll) {
        this.worldObj = llllllllllllIlIllIIllllllllllIll;
        for (int llllllllllllIlIllIIllllllllllIlI = 0; llllllllllllIlIllIIllllllllllIlI < 4; ++llllllllllllIlIllIIllllllllllIlI) {
            for (int llllllllllllIlIllIIllllllllllIIl = 0; llllllllllllIlIllIIllllllllllIIl < 2; ++llllllllllllIlIllIIllllllllllIIl) {
                this.fxLayers[llllllllllllIlIllIIllllllllllIlI][llllllllllllIlIllIIllllllllllIIl].clear();
            }
        }
        this.particleEmitters.clear();
    }
    
    public void renderLitParticles(final Entity llllllllllllIlIllIlIIIIIIIIlllII, final float llllllllllllIlIllIlIIIIIIIIllIll) {
        final float llllllllllllIlIllIlIIIIIIIIllIlI = 0.017453292f;
        final float llllllllllllIlIllIlIIIIIIIIllIIl = MathHelper.cos(llllllllllllIlIllIlIIIIIIIIlllII.rotationYaw * 0.017453292f);
        final float llllllllllllIlIllIlIIIIIIIIllIII = MathHelper.sin(llllllllllllIlIllIlIIIIIIIIlllII.rotationYaw * 0.017453292f);
        final float llllllllllllIlIllIlIIIIIIIIlIlll = -llllllllllllIlIllIlIIIIIIIIllIII * MathHelper.sin(llllllllllllIlIllIlIIIIIIIIlllII.rotationPitch * 0.017453292f);
        final float llllllllllllIlIllIlIIIIIIIIlIllI = llllllllllllIlIllIlIIIIIIIIllIIl * MathHelper.sin(llllllllllllIlIllIlIIIIIIIIlllII.rotationPitch * 0.017453292f);
        final float llllllllllllIlIllIlIIIIIIIIlIlIl = MathHelper.cos(llllllllllllIlIllIlIIIIIIIIlllII.rotationPitch * 0.017453292f);
        for (int llllllllllllIlIllIlIIIIIIIIlIlII = 0; llllllllllllIlIllIlIIIIIIIIlIlII < 2; ++llllllllllllIlIllIlIIIIIIIIlIlII) {
            final Queue<Particle> llllllllllllIlIllIlIIIIIIIIlIIll = this.fxLayers[3][llllllllllllIlIllIlIIIIIIIIlIlII];
            if (!llllllllllllIlIllIlIIIIIIIIlIIll.isEmpty()) {
                final Tessellator llllllllllllIlIllIlIIIIIIIIlIIlI = Tessellator.getInstance();
                final BufferBuilder llllllllllllIlIllIlIIIIIIIIlIIIl = llllllllllllIlIllIlIIIIIIIIlIIlI.getBuffer();
                for (final Particle llllllllllllIlIllIlIIIIIIIIlIIII : llllllllllllIlIllIlIIIIIIIIlIIll) {
                    llllllllllllIlIllIlIIIIIIIIlIIII.renderParticle(llllllllllllIlIllIlIIIIIIIIlIIIl, llllllllllllIlIllIlIIIIIIIIlllII, llllllllllllIlIllIlIIIIIIIIllIll, llllllllllllIlIllIlIIIIIIIIllIIl, llllllllllllIlIllIlIIIIIIIIlIlIl, llllllllllllIlIllIlIIIIIIIIllIII, llllllllllllIlIllIlIIIIIIIIlIlll, llllllllllllIlIllIlIIIIIIIIlIllI);
                }
            }
        }
    }
    
    public void registerParticle(final int llllllllllllIlIllIlIIIIIllIllIII, final IParticleFactory llllllllllllIlIllIlIIIIIllIlIlll) {
        this.particleTypes.put(llllllllllllIlIllIlIIIIIllIllIII, llllllllllllIlIllIlIIIIIllIlIlll);
    }
    
    public void addBlockHitEffects(final BlockPos llllllllllllIlIllIIlllllllIIIlII, final EnumFacing llllllllllllIlIllIIllllllIllIlll) {
        final IBlockState llllllllllllIlIllIIlllllllIIIIlI = this.worldObj.getBlockState(llllllllllllIlIllIIlllllllIIIlII);
        if (llllllllllllIlIllIIlllllllIIIIlI.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            final int llllllllllllIlIllIIlllllllIIIIIl = llllllllllllIlIllIIlllllllIIIlII.getX();
            final int llllllllllllIlIllIIlllllllIIIIII = llllllllllllIlIllIIlllllllIIIlII.getY();
            final int llllllllllllIlIllIIllllllIllllll = llllllllllllIlIllIIlllllllIIIlII.getZ();
            final float llllllllllllIlIllIIllllllIlllllI = 0.1f;
            final AxisAlignedBB llllllllllllIlIllIIllllllIllllIl = llllllllllllIlIllIIlllllllIIIIlI.getBoundingBox(this.worldObj, llllllllllllIlIllIIlllllllIIIlII);
            double llllllllllllIlIllIIllllllIllllII = llllllllllllIlIllIIlllllllIIIIIl + this.rand.nextDouble() * (llllllllllllIlIllIIllllllIllllIl.maxX - llllllllllllIlIllIIllllllIllllIl.minX - 0.20000000298023224) + 0.10000000149011612 + llllllllllllIlIllIIllllllIllllIl.minX;
            double llllllllllllIlIllIIllllllIlllIll = llllllllllllIlIllIIlllllllIIIIII + this.rand.nextDouble() * (llllllllllllIlIllIIllllllIllllIl.maxY - llllllllllllIlIllIIllllllIllllIl.minY - 0.20000000298023224) + 0.10000000149011612 + llllllllllllIlIllIIllllllIllllIl.minY;
            double llllllllllllIlIllIIllllllIlllIlI = llllllllllllIlIllIIllllllIllllll + this.rand.nextDouble() * (llllllllllllIlIllIIllllllIllllIl.maxZ - llllllllllllIlIllIIllllllIllllIl.minZ - 0.20000000298023224) + 0.10000000149011612 + llllllllllllIlIllIIllllllIllllIl.minZ;
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.DOWN) {
                llllllllllllIlIllIIllllllIlllIll = llllllllllllIlIllIIlllllllIIIIII + llllllllllllIlIllIIllllllIllllIl.minY - 0.10000000149011612;
            }
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.UP) {
                llllllllllllIlIllIIllllllIlllIll = llllllllllllIlIllIIlllllllIIIIII + llllllllllllIlIllIIllllllIllllIl.maxY + 0.10000000149011612;
            }
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.NORTH) {
                llllllllllllIlIllIIllllllIlllIlI = llllllllllllIlIllIIllllllIllllll + llllllllllllIlIllIIllllllIllllIl.minZ - 0.10000000149011612;
            }
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.SOUTH) {
                llllllllllllIlIllIIllllllIlllIlI = llllllllllllIlIllIIllllllIllllll + llllllllllllIlIllIIllllllIllllIl.maxZ + 0.10000000149011612;
            }
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.WEST) {
                llllllllllllIlIllIIllllllIllllII = llllllllllllIlIllIIlllllllIIIIIl + llllllllllllIlIllIIllllllIllllIl.minX - 0.10000000149011612;
            }
            if (llllllllllllIlIllIIllllllIllIlll == EnumFacing.EAST) {
                llllllllllllIlIllIIllllllIllllII = llllllllllllIlIllIIlllllllIIIIIl + llllllllllllIlIllIIllllllIllllIl.maxX + 0.10000000149011612;
            }
            this.addEffect(new ParticleDigging(this.worldObj, llllllllllllIlIllIIllllllIllllII, llllllllllllIlIllIIllllllIlllIll, llllllllllllIlIllIIllllllIlllIlI, 0.0, 0.0, 0.0, llllllllllllIlIllIIlllllllIIIIlI).setBlockPos(llllllllllllIlIllIIlllllllIIIlII).multiplyVelocity(0.2f).multipleParticleScaleBy(0.6f));
        }
    }
    
    private void tickParticleList(final Queue<Particle> llllllllllllIlIllIlIIIIIIlllIllI) {
        if (!llllllllllllIlIllIlIIIIIIlllIllI.isEmpty()) {
            final Iterator<Particle> llllllllllllIlIllIlIIIIIIllllIIl = llllllllllllIlIllIlIIIIIIlllIllI.iterator();
            while (llllllllllllIlIllIlIIIIIIllllIIl.hasNext()) {
                final Particle llllllllllllIlIllIlIIIIIIllllIII = llllllllllllIlIllIlIIIIIIllllIIl.next();
                this.tickParticle(llllllllllllIlIllIlIIIIIIllllIII);
                if (!llllllllllllIlIllIlIIIIIIllllIII.isAlive()) {
                    llllllllllllIlIllIlIIIIIIllllIIl.remove();
                }
            }
        }
    }
    
    public ParticleManager(final World llllllllllllIlIllIlIIIIIlllIIIll, final TextureManager llllllllllllIlIllIlIIIIIlllIIIlI) {
        this.fxLayers = (ArrayDeque<Particle>[][])new ArrayDeque[4][];
        this.particleEmitters = (Queue<ParticleEmitter>)Queues.newArrayDeque();
        this.rand = new Random();
        this.particleTypes = (Map<Integer, IParticleFactory>)Maps.newHashMap();
        this.queueEntityFX = (Queue<Particle>)Queues.newArrayDeque();
        this.worldObj = llllllllllllIlIllIlIIIIIlllIIIll;
        this.renderer = llllllllllllIlIllIlIIIIIlllIIIlI;
        for (int llllllllllllIlIllIlIIIIIlllIIllI = 0; llllllllllllIlIllIlIIIIIlllIIllI < 4; ++llllllllllllIlIllIlIIIIIlllIIllI) {
            this.fxLayers[llllllllllllIlIllIlIIIIIlllIIllI] = (ArrayDeque<Particle>[])new ArrayDeque[2];
            for (int llllllllllllIlIllIlIIIIIlllIIlIl = 0; llllllllllllIlIllIlIIIIIlllIIlIl < 2; ++llllllllllllIlIllIlIIIIIlllIIlIl) {
                this.fxLayers[llllllllllllIlIllIlIIIIIlllIIllI][llllllllllllIlIllIlIIIIIlllIIlIl] = (ArrayDeque<Particle>)Queues.newArrayDeque();
            }
        }
        this.registerVanillaParticles();
    }
    
    private void tickParticle(final Particle llllllllllllIlIllIlIIIIIIllIIllI) {
        try {
            llllllllllllIlIllIlIIIIIIllIIllI.onUpdate();
        }
        catch (Throwable llllllllllllIlIllIlIIIIIIllIlIll) {
            final CrashReport llllllllllllIlIllIlIIIIIIllIlIlI = CrashReport.makeCrashReport(llllllllllllIlIllIlIIIIIIllIlIll, "Ticking Particle");
            final CrashReportCategory llllllllllllIlIllIlIIIIIIllIlIIl = llllllllllllIlIllIlIIIIIIllIlIlI.makeCategory("Particle being ticked");
            final int llllllllllllIlIllIlIIIIIIllIlIII = llllllllllllIlIllIlIIIIIIllIIllI.getFXLayer();
            llllllllllllIlIllIlIIIIIIllIlIIl.setDetail("Particle", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return llllllllllllIlIllIlIIIIIIllIIllI.toString();
                }
            });
            llllllllllllIlIllIlIIIIIIllIlIIl.setDetail("Particle Type", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    if (llllllllllllIlIllIlIIIIIIllIlIII == 0) {
                        return "MISC_TEXTURE";
                    }
                    if (llllllllllllIlIllIlIIIIIIllIlIII == 1) {
                        return "TERRAIN_TEXTURE";
                    }
                    return (llllllllllllIlIllIlIIIIIIllIlIII == 3) ? "ENTITY_PARTICLE_TEXTURE" : ("Unknown - " + llllllllllllIlIllIlIIIIIIllIlIII);
                }
            });
            throw new ReportedException(llllllllllllIlIllIlIIIIIIllIlIlI);
        }
    }
    
    public void addBlockDestroyEffects(final BlockPos llllllllllllIlIllIIlllllllIllIll, IBlockState llllllllllllIlIllIIllllllllIIlll) {
        boolean llllllllllllIlIllIIllllllllIIlIl = false;
        if (Reflector.ForgeBlock_addDestroyEffects.exists() && Reflector.ForgeBlock_isAir.exists()) {
            final Block llllllllllllIlIllIIllllllllIIlII = llllllllllllIlIllIIllllllllIIlll.getBlock();
            final boolean llllllllllllIlIllIIllllllllIIllI = !Reflector.callBoolean((Object)llllllllllllIlIllIIllllllllIIlII, Reflector.ForgeBlock_isAir, new Object[] { llllllllllllIlIllIIllllllllIIlll, this.worldObj, llllllllllllIlIllIIlllllllIllIll }) && !Reflector.callBoolean((Object)llllllllllllIlIllIIllllllllIIlII, Reflector.ForgeBlock_addDestroyEffects, new Object[] { this.worldObj, llllllllllllIlIllIIlllllllIllIll, this });
        }
        else {
            llllllllllllIlIllIIllllllllIIlIl = (llllllllllllIlIllIIllllllllIIlll.getMaterial() != Material.AIR);
        }
        if (llllllllllllIlIllIIllllllllIIlIl) {
            llllllllllllIlIllIIllllllllIIlll = llllllllllllIlIllIIllllllllIIlll.getActualState(this.worldObj, llllllllllllIlIllIIlllllllIllIll);
            final int llllllllllllIlIllIIllllllllIIIll = 4;
            for (int llllllllllllIlIllIIllllllllIIIlI = 0; llllllllllllIlIllIIllllllllIIIlI < 4; ++llllllllllllIlIllIIllllllllIIIlI) {
                for (int llllllllllllIlIllIIllllllllIIIIl = 0; llllllllllllIlIllIIllllllllIIIIl < 4; ++llllllllllllIlIllIIllllllllIIIIl) {
                    for (int llllllllllllIlIllIIllllllllIIIII = 0; llllllllllllIlIllIIllllllllIIIII < 4; ++llllllllllllIlIllIIllllllllIIIII) {
                        final double llllllllllllIlIllIIlllllllIlllll = (llllllllllllIlIllIIllllllllIIIlI + 0.5) / 4.0;
                        final double llllllllllllIlIllIIlllllllIllllI = (llllllllllllIlIllIIllllllllIIIIl + 0.5) / 4.0;
                        final double llllllllllllIlIllIIlllllllIlllIl = (llllllllllllIlIllIIllllllllIIIII + 0.5) / 4.0;
                        this.addEffect(new ParticleDigging(this.worldObj, llllllllllllIlIllIIlllllllIllIll.getX() + llllllllllllIlIllIIlllllllIlllll, llllllllllllIlIllIIlllllllIllIll.getY() + llllllllllllIlIllIIlllllllIllllI, llllllllllllIlIllIIlllllllIllIll.getZ() + llllllllllllIlIllIIlllllllIlllIl, llllllllllllIlIllIIlllllllIlllll - 0.5, llllllllllllIlIllIIlllllllIllllI - 0.5, llllllllllllIlIllIIlllllllIlllIl - 0.5, llllllllllllIlIllIIllllllllIIlll).setBlockPos(llllllllllllIlIllIIlllllllIllIll));
                    }
                }
            }
        }
    }
    
    public void func_191271_a(final Entity llllllllllllIlIllIlIIIIIllIIIIIl, final EnumParticleTypes llllllllllllIlIllIlIIIIIllIIIlII, final int llllllllllllIlIllIlIIIIIllIIIIll) {
        this.particleEmitters.add(new ParticleEmitter(this.worldObj, llllllllllllIlIllIlIIIIIllIIIIIl, llllllllllllIlIllIlIIIIIllIIIlII, llllllllllllIlIllIlIIIIIllIIIIll));
    }
    
    public void addBlockHitEffects(final BlockPos llllllllllllIlIllIIllllllIIIlIlI, final RayTraceResult llllllllllllIlIllIIllllllIIIlllI) {
        final IBlockState llllllllllllIlIllIIllllllIIIllIl = this.worldObj.getBlockState(llllllllllllIlIllIIllllllIIIlIlI);
        if (llllllllllllIlIllIIllllllIIIllIl != null) {
            final boolean llllllllllllIlIllIIllllllIIIllII = Reflector.callBoolean((Object)llllllllllllIlIllIIllllllIIIllIl.getBlock(), Reflector.ForgeBlock_addHitEffects, new Object[] { llllllllllllIlIllIIllllllIIIllIl, this.worldObj, llllllllllllIlIllIIllllllIIIlllI, this });
            if (llllllllllllIlIllIIllllllIIIllIl != null && !llllllllllllIlIllIIllllllIIIllII) {
                this.addBlockHitEffects(llllllllllllIlIllIIllllllIIIlIlI, llllllllllllIlIllIIllllllIIIlllI.sideHit);
            }
        }
    }
}
