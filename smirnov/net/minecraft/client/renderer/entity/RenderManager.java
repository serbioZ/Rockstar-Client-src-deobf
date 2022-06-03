// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.RenderGlobal;
import optifine.PlayerItemsLayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityCaveSpider;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockBed;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import optifine.Reflector;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReport;
import net.optifine.entity.model.CustomEntityModels;
import net.minecraft.client.renderer.culling.ICamera;
import java.util.Collections;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import java.util.Map;
import net.minecraft.client.gui.FontRenderer;

public class RenderManager
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    public /* synthetic */ double viewerPosY;
    private /* synthetic */ FontRenderer textRenderer;
    private final /* synthetic */ Map<String, RenderPlayer> skinMap;
    private /* synthetic */ boolean debugBoundingBox;
    public /* synthetic */ Entity pointedEntity;
    public static /* synthetic */ float playerViewY;
    public /* synthetic */ GameSettings options;
    private /* synthetic */ boolean renderShadow;
    public /* synthetic */ double viewerPosX;
    public /* synthetic */ double viewerPosZ;
    public static /* synthetic */ double renderPosZ;
    public /* synthetic */ TextureManager renderEngine;
    public /* synthetic */ Entity renderEntity;
    public static /* synthetic */ double renderPosX;
    public /* synthetic */ Render renderRender;
    private /* synthetic */ boolean renderOutlines;
    public /* synthetic */ World worldObj;
    private final /* synthetic */ Map<Class, Render> entityRenderMap;
    public static /* synthetic */ double renderPosY;
    public static /* synthetic */ float playerViewX;
    public /* synthetic */ Entity renderViewEntity;
    
    public void setRenderPosition(final double lllllllllllIllllIlIlllIlIlIIIllI, final double lllllllllllIllllIlIlllIlIlIIIlIl, final double lllllllllllIllllIlIlllIlIlIIIlII) {
        RenderManager.renderPosX = lllllllllllIllllIlIlllIlIlIIIllI;
        RenderManager.renderPosY = lllllllllllIllllIlIlllIlIlIIIlIl;
        RenderManager.renderPosZ = lllllllllllIllllIlIlllIlIlIIIlII;
    }
    
    public boolean isRenderMultipass(final Entity lllllllllllIllllIlIlllIIllllIIll) {
        return this.getEntityRenderObject(lllllllllllIllllIlIlllIIllllIIll).isMultipass();
    }
    
    public void renderEntityStatic(final Entity lllllllllllIllllIlIlllIIllIIIlII, final float lllllllllllIllllIlIlllIIllIIlllI, final boolean lllllllllllIllllIlIlllIIllIIllIl) {
        if (lllllllllllIllllIlIlllIIllIIIlII.ticksExisted == 0) {
            lllllllllllIllllIlIlllIIllIIIlII.lastTickPosX = lllllllllllIllllIlIlllIIllIIIlII.posX;
            lllllllllllIllllIlIlllIIllIIIlII.lastTickPosY = lllllllllllIllllIlIlllIIllIIIlII.posY;
            lllllllllllIllllIlIlllIIllIIIlII.lastTickPosZ = lllllllllllIllllIlIlllIIllIIIlII.posZ;
        }
        final double lllllllllllIllllIlIlllIIllIIllII = lllllllllllIllllIlIlllIIllIIIlII.lastTickPosX + (lllllllllllIllllIlIlllIIllIIIlII.posX - lllllllllllIllllIlIlllIIllIIIlII.lastTickPosX) * lllllllllllIllllIlIlllIIllIIlllI;
        final double lllllllllllIllllIlIlllIIllIIlIll = lllllllllllIllllIlIlllIIllIIIlII.lastTickPosY + (lllllllllllIllllIlIlllIIllIIIlII.posY - lllllllllllIllllIlIlllIIllIIIlII.lastTickPosY) * lllllllllllIllllIlIlllIIllIIlllI;
        final double lllllllllllIllllIlIlllIIllIIlIlI = lllllllllllIllllIlIlllIIllIIIlII.lastTickPosZ + (lllllllllllIllllIlIlllIIllIIIlII.posZ - lllllllllllIllllIlIlllIIllIIIlII.lastTickPosZ) * lllllllllllIllllIlIlllIIllIIlllI;
        final float lllllllllllIllllIlIlllIIllIIlIIl = lllllllllllIllllIlIlllIIllIIIlII.prevRotationYaw + (lllllllllllIllllIlIlllIIllIIIlII.rotationYaw - lllllllllllIllllIlIlllIIllIIIlII.prevRotationYaw) * lllllllllllIllllIlIlllIIllIIlllI;
        int lllllllllllIllllIlIlllIIllIIlIII = lllllllllllIllllIlIlllIIllIIIlII.getBrightnessForRender();
        if (lllllllllllIllllIlIlllIIllIIIlII.isBurning()) {
            lllllllllllIllllIlIlllIIllIIlIII = 15728880;
        }
        final int lllllllllllIllllIlIlllIIllIIIlll = lllllllllllIllllIlIlllIIllIIlIII % 65536;
        final int lllllllllllIllllIlIlllIIllIIIllI = lllllllllllIllllIlIlllIIllIIlIII / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIllllIlIlllIIllIIIlll, (float)lllllllllllIllllIlIlllIIllIIIllI);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.doRenderEntity(lllllllllllIllllIlIlllIIllIIIlII, lllllllllllIllllIlIlllIIllIIllII - RenderManager.renderPosX, lllllllllllIllllIlIlllIIllIIlIll - RenderManager.renderPosY, lllllllllllIllllIlIlllIIllIIlIlI - RenderManager.renderPosZ, lllllllllllIllllIlIlllIIllIIlIIl, lllllllllllIllllIlIlllIIllIIlllI, lllllllllllIllllIlIlllIIllIIllIl);
    }
    
    public void setRenderOutlines(final boolean lllllllllllIllllIlIlllIIIIIllIIl) {
        this.renderOutlines = lllllllllllIllllIlIlllIIIIIllIIl;
    }
    
    public void setDebugBoundingBox(final boolean lllllllllllIllllIlIlllIIllllllII) {
        this.debugBoundingBox = lllllllllllIllllIlIlllIIllllllII;
    }
    
    public FontRenderer getFontRenderer() {
        return this.textRenderer;
    }
    
    public double getDistanceToCamera(final double lllllllllllIllllIlIlllIIIIlIlllI, final double lllllllllllIllllIlIlllIIIIlIIllI, final double lllllllllllIllllIlIlllIIIIlIIlIl) {
        final double lllllllllllIllllIlIlllIIIIlIlIll = lllllllllllIllllIlIlllIIIIlIlllI - this.viewerPosX;
        final double lllllllllllIllllIlIlllIIIIlIlIlI = lllllllllllIllllIlIlllIIIIlIIllI - this.viewerPosY;
        final double lllllllllllIllllIlIlllIIIIlIlIIl = lllllllllllIllllIlIlllIIIIlIIlIl - this.viewerPosZ;
        return lllllllllllIllllIlIlllIIIIlIlIll * lllllllllllIllllIlIlllIIIIlIlIll + lllllllllllIllllIlIlllIIIIlIlIlI * lllllllllllIllllIlIlllIIIIlIlIlI + lllllllllllIllllIlIlllIIIIlIlIIl * lllllllllllIllllIlIlllIIIIlIlIIl;
    }
    
    public boolean isDebugBoundingBox() {
        return this.debugBoundingBox;
    }
    
    public void renderMultipass(final Entity lllllllllllIllllIlIlllIIIllllIIl, final float lllllllllllIllllIlIlllIIIllllIII) {
        if (lllllllllllIllllIlIlllIIIllllIIl.ticksExisted == 0) {
            lllllllllllIllllIlIlllIIIllllIIl.lastTickPosX = lllllllllllIllllIlIlllIIIllllIIl.posX;
            lllllllllllIllllIlIlllIIIllllIIl.lastTickPosY = lllllllllllIllllIlIlllIIIllllIIl.posY;
            lllllllllllIllllIlIlllIIIllllIIl.lastTickPosZ = lllllllllllIllllIlIlllIIIllllIIl.posZ;
        }
        final double lllllllllllIllllIlIlllIIlIIIIIlI = lllllllllllIllllIlIlllIIIllllIIl.lastTickPosX + (lllllllllllIllllIlIlllIIIllllIIl.posX - lllllllllllIllllIlIlllIIIllllIIl.lastTickPosX) * lllllllllllIllllIlIlllIIIllllIII;
        final double lllllllllllIllllIlIlllIIlIIIIIIl = lllllllllllIllllIlIlllIIIllllIIl.lastTickPosY + (lllllllllllIllllIlIlllIIIllllIIl.posY - lllllllllllIllllIlIlllIIIllllIIl.lastTickPosY) * lllllllllllIllllIlIlllIIIllllIII;
        final double lllllllllllIllllIlIlllIIlIIIIIII = lllllllllllIllllIlIlllIIIllllIIl.lastTickPosZ + (lllllllllllIllllIlIlllIIIllllIIl.posZ - lllllllllllIllllIlIlllIIIllllIIl.lastTickPosZ) * lllllllllllIllllIlIlllIIIllllIII;
        final float lllllllllllIllllIlIlllIIIlllllll = lllllllllllIllllIlIlllIIIllllIIl.prevRotationYaw + (lllllllllllIllllIlIlllIIIllllIIl.rotationYaw - lllllllllllIllllIlIlllIIIllllIIl.prevRotationYaw) * lllllllllllIllllIlIlllIIIllllIII;
        int lllllllllllIllllIlIlllIIIllllllI = lllllllllllIllllIlIlllIIIllllIIl.getBrightnessForRender();
        if (lllllllllllIllllIlIlllIIIllllIIl.isBurning()) {
            lllllllllllIllllIlIlllIIIllllllI = 15728880;
        }
        final int lllllllllllIllllIlIlllIIIlllllIl = lllllllllllIllllIlIlllIIIllllllI % 65536;
        final int lllllllllllIllllIlIlllIIIlllllII = lllllllllllIllllIlIlllIIIllllllI / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIllllIlIlllIIIlllllIl, (float)lllllllllllIllllIlIlllIIIlllllII);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final Render<Entity> lllllllllllIllllIlIlllIIIllllIll = this.getEntityRenderObject(lllllllllllIllllIlIlllIIIllllIIl);
        if (lllllllllllIllllIlIlllIIIllllIll != null && this.renderEngine != null) {
            lllllllllllIllllIlIlllIIIllllIll.renderMultipass(lllllllllllIllllIlIlllIIIllllIIl, lllllllllllIllllIlIlllIIlIIIIIlI - RenderManager.renderPosX, lllllllllllIllllIlIlllIIlIIIIIIl - RenderManager.renderPosY, lllllllllllIllllIlIlllIIlIIIIIII - RenderManager.renderPosZ, lllllllllllIllllIlIlllIIIlllllll, lllllllllllIllllIlIlllIIIllllIII);
        }
    }
    
    public Map<String, RenderPlayer> getSkinMap() {
        return Collections.unmodifiableMap((Map<? extends String, ? extends RenderPlayer>)this.skinMap);
    }
    
    public Map<Class, Render> getEntityRenderMap() {
        return this.entityRenderMap;
    }
    
    public boolean shouldRender(final Entity lllllllllllIllllIlIlllIIlllIIIIl, final ICamera lllllllllllIllllIlIlllIIlllIIlll, final double lllllllllllIllllIlIlllIIllIlllll, final double lllllllllllIllllIlIlllIIlllIIlIl, final double lllllllllllIllllIlIlllIIllIlllIl) {
        final Render<Entity> lllllllllllIllllIlIlllIIlllIIIll = this.getEntityRenderObject(lllllllllllIllllIlIlllIIlllIIIIl);
        return lllllllllllIllllIlIlllIIlllIIIll != null && lllllllllllIllllIlIlllIIlllIIIll.shouldRender(lllllllllllIllllIlIlllIIlllIIIIl, lllllllllllIllllIlIlllIIlllIIlll, lllllllllllIllllIlIlllIIllIlllll, lllllllllllIllllIlIlllIIlllIIlIl, lllllllllllIllllIlIlllIIllIlllIl);
    }
    
    public void setRenderShadow(final boolean lllllllllllIllllIlIlllIlIIIIIIII) {
        this.renderShadow = lllllllllllIllllIlIlllIlIIIIIIII;
    }
    
    public void setPlayerViewY(final float lllllllllllIllllIlIlllIlIIIIlIlI) {
        RenderManager.playerViewY = lllllllllllIllllIlIlllIlIIIIlIlI;
    }
    
    public <T extends Entity> Render<T> getEntityClassRenderObject(final Class<? extends Entity> lllllllllllIllllIlIlllIlIIllllII) {
        Render<T> lllllllllllIllllIlIlllIlIIlllllI = this.entityRenderMap.get(lllllllllllIllllIlIlllIlIIllllII);
        if (lllllllllllIllllIlIlllIlIIlllllI == null && lllllllllllIllllIlIlllIlIIllllII != Entity.class) {
            lllllllllllIllllIlIlllIlIIlllllI = (Render<T>)this.getEntityClassRenderObject((Class<? extends Entity>)lllllllllllIllllIlIlllIlIIllllII.getSuperclass());
            this.entityRenderMap.put(lllllllllllIllllIlIlllIlIIllllII, lllllllllllIllllIlIlllIlIIlllllI);
        }
        return lllllllllllIllllIlIlllIlIIlllllI;
    }
    
    public boolean isRenderShadow() {
        return this.renderShadow;
    }
    
    public void doRenderEntity(final Entity lllllllllllIllllIlIlllIIlIlIllII, final double lllllllllllIllllIlIlllIIlIIllIll, final double lllllllllllIllllIlIlllIIlIlIlIlI, final double lllllllllllIllllIlIlllIIlIIllIIl, final float lllllllllllIllllIlIlllIIlIIllIII, final float lllllllllllIllllIlIlllIIlIlIIlll, final boolean lllllllllllIllllIlIlllIIlIIlIllI) {
        Render<Entity> lllllllllllIllllIlIlllIIlIlIIlIl = null;
        try {
            lllllllllllIllllIlIlllIIlIlIIlIl = this.getEntityRenderObject(lllllllllllIllllIlIlllIIlIlIllII);
            if (lllllllllllIllllIlIlllIIlIlIIlIl != null && this.renderEngine != null) {
                try {
                    lllllllllllIllllIlIlllIIlIlIIlIl.setRenderOutlines(this.renderOutlines);
                    if (CustomEntityModels.isActive()) {
                        this.renderEntity = lllllllllllIllllIlIlllIIlIlIllII;
                        this.renderRender = lllllllllllIllllIlIlllIIlIlIIlIl;
                    }
                    lllllllllllIllllIlIlllIIlIlIIlIl.doRender(lllllllllllIllllIlIlllIIlIlIllII, lllllllllllIllllIlIlllIIlIIllIll, lllllllllllIllllIlIlllIIlIlIlIlI, lllllllllllIllllIlIlllIIlIIllIIl, lllllllllllIllllIlIlllIIlIIllIII, lllllllllllIllllIlIlllIIlIlIIlll);
                }
                catch (Throwable lllllllllllIllllIlIlllIIlIlIIlII) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllIllllIlIlllIIlIlIIlII, "Rendering entity in world"));
                }
                try {
                    if (!this.renderOutlines) {
                        lllllllllllIllllIlIlllIIlIlIIlIl.doRenderShadowAndFire(lllllllllllIllllIlIlllIIlIlIllII, lllllllllllIllllIlIlllIIlIIllIll, lllllllllllIllllIlIlllIIlIlIlIlI, lllllllllllIllllIlIlllIIlIIllIIl, lllllllllllIllllIlIlllIIlIIllIII, lllllllllllIllllIlIlllIIlIlIIlll);
                    }
                }
                catch (Throwable lllllllllllIllllIlIlllIIlIlIIIll) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllIllllIlIlllIIlIlIIIll, "Post-rendering entity in world"));
                }
                if (this.debugBoundingBox && !lllllllllllIllllIlIlllIIlIlIllII.isInvisible() && !lllllllllllIllllIlIlllIIlIIlIllI && !Minecraft.getMinecraft().isReducedDebug()) {
                    try {
                        this.renderDebugBoundingBox(lllllllllllIllllIlIlllIIlIlIllII, lllllllllllIllllIlIlllIIlIIllIll, lllllllllllIllllIlIlllIIlIlIlIlI, lllllllllllIllllIlIlllIIlIIllIIl, lllllllllllIllllIlIlllIIlIIllIII, lllllllllllIllllIlIlllIIlIlIIlll);
                    }
                    catch (Throwable lllllllllllIllllIlIlllIIlIlIIIlI) {
                        throw new ReportedException(CrashReport.makeCrashReport(lllllllllllIllllIlIlllIIlIlIIIlI, "Rendering entity hitbox in world"));
                    }
                }
            }
        }
        catch (Throwable lllllllllllIllllIlIlllIIlIlIIIIl) {
            final CrashReport lllllllllllIllllIlIlllIIlIlIIIII = CrashReport.makeCrashReport(lllllllllllIllllIlIlllIIlIlIIIIl, "Rendering entity in world");
            final CrashReportCategory lllllllllllIllllIlIlllIIlIIlllll = lllllllllllIllllIlIlllIIlIlIIIII.makeCategory("Entity being rendered");
            lllllllllllIllllIlIlllIIlIlIllII.addEntityCrashInfo(lllllllllllIllllIlIlllIIlIIlllll);
            final CrashReportCategory lllllllllllIllllIlIlllIIlIIllllI = lllllllllllIllllIlIlllIIlIlIIIII.makeCategory("Renderer details");
            lllllllllllIllllIlIlllIIlIIllllI.addCrashSection("Assigned renderer", lllllllllllIllllIlIlllIIlIlIIlIl);
            lllllllllllIllllIlIlllIIlIIllllI.addCrashSection("Location", CrashReportCategory.getCoordinateInfo(lllllllllllIllllIlIlllIIlIIllIll, lllllllllllIllllIlIlllIIlIlIlIlI, lllllllllllIllllIlIlllIIlIIllIIl));
            lllllllllllIllllIlIlllIIlIIllllI.addCrashSection("Rotation", lllllllllllIllllIlIlllIIlIIllIII);
            lllllllllllIllllIlIlllIIlIIllllI.addCrashSection("Delta", lllllllllllIllllIlIlllIIlIlIIlll);
            throw new ReportedException(lllllllllllIllllIlIlllIIlIlIIIII);
        }
    }
    
    @Nullable
    public <T extends Entity> Render<T> getEntityRenderObject(final Entity lllllllllllIllllIlIlllIlIIllIlIl) {
        if (lllllllllllIllllIlIlllIlIIllIlIl instanceof AbstractClientPlayer) {
            final String lllllllllllIllllIlIlllIlIIllIlII = ((AbstractClientPlayer)lllllllllllIllllIlIlllIlIIllIlIl).getSkinType();
            final RenderPlayer lllllllllllIllllIlIlllIlIIllIIll = this.skinMap.get(lllllllllllIllllIlIlllIlIIllIlII);
            return (Render<T>)((lllllllllllIllllIlIlllIlIIllIIll != null) ? lllllllllllIllllIlIlllIlIIllIIll : this.playerRenderer);
        }
        return this.getEntityClassRenderObject(lllllllllllIllllIlIlllIlIIllIlIl.getClass());
    }
    
    public void cacheActiveRenderInfo(final World lllllllllllIllllIlIlllIlIIIlIllI, final FontRenderer lllllllllllIllllIlIlllIlIIlIIIIl, final Entity lllllllllllIllllIlIlllIlIIIlIlII, final Entity lllllllllllIllllIlIlllIlIIIlIIll, final GameSettings lllllllllllIllllIlIlllIlIIIllllI, final float lllllllllllIllllIlIlllIlIIIlIIIl) {
        this.worldObj = lllllllllllIllllIlIlllIlIIIlIllI;
        this.options = lllllllllllIllllIlIlllIlIIIllllI;
        this.renderViewEntity = lllllllllllIllllIlIlllIlIIIlIlII;
        this.pointedEntity = lllllllllllIllllIlIlllIlIIIlIIll;
        this.textRenderer = lllllllllllIllllIlIlllIlIIlIIIIl;
        if (lllllllllllIllllIlIlllIlIIIlIlII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllIllllIlIlllIlIIIlIlII).isPlayerSleeping()) {
            final IBlockState lllllllllllIllllIlIlllIlIIIlllII = lllllllllllIllllIlIlllIlIIIlIllI.getBlockState(new BlockPos(lllllllllllIllllIlIlllIlIIIlIlII));
            final Block lllllllllllIllllIlIlllIlIIIllIll = lllllllllllIllllIlIlllIlIIIlllII.getBlock();
            if (Reflector.callBoolean((Object)lllllllllllIllllIlIlllIlIIIllIll, Reflector.ForgeBlock_isBed, new Object[] { lllllllllllIllllIlIlllIlIIIlllII, lllllllllllIllllIlIlllIlIIIlIllI, new BlockPos(lllllllllllIllllIlIlllIlIIIlIlII), (EntityLivingBase)lllllllllllIllllIlIlllIlIIIlIlII })) {
                final EnumFacing lllllllllllIllllIlIlllIlIIIllIlI = (EnumFacing)Reflector.call((Object)lllllllllllIllllIlIlllIlIIIllIll, Reflector.ForgeBlock_getBedDirection, new Object[] { lllllllllllIllllIlIlllIlIIIlllII, lllllllllllIllllIlIlllIlIIIlIllI, new BlockPos(lllllllllllIllllIlIlllIlIIIlIlII) });
                final int lllllllllllIllllIlIlllIlIIIllIIl = lllllllllllIllllIlIlllIlIIIllIlI.getHorizontalIndex();
                RenderManager.playerViewY = (float)(lllllllllllIllllIlIlllIlIIIllIIl * 90 + 180);
                RenderManager.playerViewX = 0.0f;
            }
            else if (lllllllllllIllllIlIlllIlIIIllIll == Blocks.BED) {
                final int lllllllllllIllllIlIlllIlIIIllIII = lllllllllllIllllIlIlllIlIIIlllII.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
                RenderManager.playerViewY = (float)(lllllllllllIllllIlIlllIlIIIllIII * 90 + 180);
                RenderManager.playerViewX = 0.0f;
            }
        }
        else {
            RenderManager.playerViewY = lllllllllllIllllIlIlllIlIIIlIlII.prevRotationYaw + (lllllllllllIllllIlIlllIlIIIlIlII.rotationYaw - lllllllllllIllllIlIlllIlIIIlIlII.prevRotationYaw) * lllllllllllIllllIlIlllIlIIIlIIIl;
            RenderManager.playerViewX = lllllllllllIllllIlIlllIlIIIlIlII.prevRotationPitch + (lllllllllllIllllIlIlllIlIIIlIlII.rotationPitch - lllllllllllIllllIlIlllIlIIIlIlII.prevRotationPitch) * lllllllllllIllllIlIlllIlIIIlIIIl;
        }
        if (lllllllllllIllllIlIlllIlIIIllllI.thirdPersonView == 2) {
            RenderManager.playerViewY += 180.0f;
        }
        this.viewerPosX = lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosX + (lllllllllllIllllIlIlllIlIIIlIlII.posX - lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosX) * lllllllllllIllllIlIlllIlIIIlIIIl;
        this.viewerPosY = lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosY + (lllllllllllIllllIlIlllIlIIIlIlII.posY - lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosY) * lllllllllllIllllIlIlllIlIIIlIIIl;
        this.viewerPosZ = lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosZ + (lllllllllllIllllIlIlllIlIIIlIlII.posZ - lllllllllllIllllIlIlllIlIIIlIlII.lastTickPosZ) * lllllllllllIllllIlIlllIlIIIlIIIl;
    }
    
    public RenderManager(final TextureManager lllllllllllIllllIlIlllIlIlIIllll, final RenderItem lllllllllllIllllIlIlllIlIlIIlllI) {
        this.entityRenderMap = (Map<Class, Render>)Maps.newHashMap();
        this.skinMap = (Map<String, RenderPlayer>)Maps.newHashMap();
        this.renderShadow = true;
        this.renderEntity = null;
        this.renderRender = null;
        this.renderEngine = lllllllllllIllllIlIlllIlIlIIllll;
        this.entityRenderMap.put(EntityCaveSpider.class, new RenderCaveSpider(this));
        this.entityRenderMap.put(EntitySpider.class, new RenderSpider(this));
        this.entityRenderMap.put(EntityPig.class, new RenderPig(this));
        this.entityRenderMap.put(EntitySheep.class, new RenderSheep(this));
        this.entityRenderMap.put(EntityCow.class, new RenderCow(this));
        this.entityRenderMap.put(EntityMooshroom.class, new RenderMooshroom(this));
        this.entityRenderMap.put(EntityWolf.class, new RenderWolf(this));
        this.entityRenderMap.put(EntityChicken.class, new RenderChicken(this));
        this.entityRenderMap.put(EntityOcelot.class, new RenderOcelot(this));
        this.entityRenderMap.put(EntityRabbit.class, new RenderRabbit(this));
        this.entityRenderMap.put(EntityParrot.class, new RenderParrot(this));
        this.entityRenderMap.put(EntitySilverfish.class, new RenderSilverfish(this));
        this.entityRenderMap.put(EntityEndermite.class, new RenderEndermite(this));
        this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper(this));
        this.entityRenderMap.put(EntityEnderman.class, new RenderEnderman(this));
        this.entityRenderMap.put(EntitySnowman.class, new RenderSnowMan(this));
        this.entityRenderMap.put(EntitySkeleton.class, new RenderSkeleton(this));
        this.entityRenderMap.put(EntityWitherSkeleton.class, new RenderWitherSkeleton(this));
        this.entityRenderMap.put(EntityStray.class, new RenderStray(this));
        this.entityRenderMap.put(EntityWitch.class, new RenderWitch(this));
        this.entityRenderMap.put(EntityBlaze.class, new RenderBlaze(this));
        this.entityRenderMap.put(EntityPigZombie.class, new RenderPigZombie(this));
        this.entityRenderMap.put(EntityZombie.class, new RenderZombie(this));
        this.entityRenderMap.put(EntityZombieVillager.class, new RenderZombieVillager(this));
        this.entityRenderMap.put(EntityHusk.class, new RenderHusk(this));
        this.entityRenderMap.put(EntitySlime.class, new RenderSlime(this));
        this.entityRenderMap.put(EntityMagmaCube.class, new RenderMagmaCube(this));
        this.entityRenderMap.put(EntityGiantZombie.class, new RenderGiantZombie(this, 6.0f));
        this.entityRenderMap.put(EntityGhast.class, new RenderGhast(this));
        this.entityRenderMap.put(EntitySquid.class, new RenderSquid(this));
        this.entityRenderMap.put(EntityVillager.class, new RenderVillager(this));
        this.entityRenderMap.put(EntityIronGolem.class, new RenderIronGolem(this));
        this.entityRenderMap.put(EntityBat.class, new RenderBat(this));
        this.entityRenderMap.put(EntityGuardian.class, new RenderGuardian(this));
        this.entityRenderMap.put(EntityElderGuardian.class, new RenderElderGuardian(this));
        this.entityRenderMap.put(EntityShulker.class, new RenderShulker(this));
        this.entityRenderMap.put(EntityPolarBear.class, new RenderPolarBear(this));
        this.entityRenderMap.put(EntityEvoker.class, new RenderEvoker(this));
        this.entityRenderMap.put(EntityVindicator.class, new RenderVindicator(this));
        this.entityRenderMap.put(EntityVex.class, new RenderVex(this));
        this.entityRenderMap.put(EntityIllusionIllager.class, new RenderIllusionIllager(this));
        this.entityRenderMap.put(EntityDragon.class, new RenderDragon(this));
        this.entityRenderMap.put(EntityEnderCrystal.class, new RenderEnderCrystal(this));
        this.entityRenderMap.put(EntityWither.class, new RenderWither(this));
        this.entityRenderMap.put(Entity.class, new RenderEntity(this));
        this.entityRenderMap.put(EntityPainting.class, new RenderPainting(this));
        this.entityRenderMap.put(EntityItemFrame.class, new RenderItemFrame(this, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityLeashKnot.class, new RenderLeashKnot(this));
        this.entityRenderMap.put(EntityTippedArrow.class, new RenderTippedArrow(this));
        this.entityRenderMap.put(EntitySpectralArrow.class, new RenderSpectralArrow(this));
        this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(this, Items.SNOWBALL, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityEnderPearl.class, new RenderSnowball(this, Items.ENDER_PEARL, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityEnderEye.class, new RenderSnowball(this, Items.ENDER_EYE, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityEgg.class, new RenderSnowball(this, Items.EGG, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityPotion.class, new RenderPotion(this, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityExpBottle.class, new RenderSnowball(this, Items.EXPERIENCE_BOTTLE, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityFireworkRocket.class, new RenderSnowball(this, Items.FIREWORKS, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityLargeFireball.class, new RenderFireball(this, 2.0f));
        this.entityRenderMap.put(EntitySmallFireball.class, new RenderFireball(this, 0.5f));
        this.entityRenderMap.put(EntityDragonFireball.class, new RenderDragonFireball(this));
        this.entityRenderMap.put(EntityWitherSkull.class, new RenderWitherSkull(this));
        this.entityRenderMap.put(EntityShulkerBullet.class, new RenderShulkerBullet(this));
        this.entityRenderMap.put(EntityItem.class, new RenderEntityItem(this, lllllllllllIllllIlIlllIlIlIIlllI));
        this.entityRenderMap.put(EntityXPOrb.class, new RenderXPOrb(this));
        this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed(this));
        this.entityRenderMap.put(EntityFallingBlock.class, new RenderFallingBlock(this));
        this.entityRenderMap.put(EntityArmorStand.class, new RenderArmorStand(this));
        this.entityRenderMap.put(EntityEvokerFangs.class, new RenderEvokerFangs(this));
        this.entityRenderMap.put(EntityMinecartTNT.class, new RenderTntMinecart(this));
        this.entityRenderMap.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner(this));
        this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart(this));
        this.entityRenderMap.put(EntityBoat.class, new RenderBoat(this));
        this.entityRenderMap.put(EntityFishHook.class, new RenderFish(this));
        this.entityRenderMap.put(EntityAreaEffectCloud.class, new RenderAreaEffectCloud(this));
        this.entityRenderMap.put(EntityHorse.class, new RenderHorse(this));
        this.entityRenderMap.put(EntitySkeletonHorse.class, new RenderAbstractHorse(this));
        this.entityRenderMap.put(EntityZombieHorse.class, new RenderAbstractHorse(this));
        this.entityRenderMap.put(EntityMule.class, new RenderAbstractHorse(this, 0.92f));
        this.entityRenderMap.put(EntityDonkey.class, new RenderAbstractHorse(this, 0.87f));
        this.entityRenderMap.put(EntityLlama.class, new RenderLlama(this));
        this.entityRenderMap.put(EntityLlamaSpit.class, new RenderLlamaSpit(this));
        this.entityRenderMap.put(EntityLightningBolt.class, new RenderLightningBolt(this));
        this.playerRenderer = new RenderPlayer(this);
        this.skinMap.put("default", this.playerRenderer);
        this.skinMap.put("slim", new RenderPlayer(this, true));
        PlayerItemsLayer.register((Map)this.skinMap);
        if (Reflector.RenderingRegistry_loadEntityRenderers.exists()) {
            Reflector.call(Reflector.RenderingRegistry_loadEntityRenderers, new Object[] { this, this.entityRenderMap });
        }
    }
    
    public void set(@Nullable final World lllllllllllIllllIlIlllIIIIlllIIl) {
        this.worldObj = lllllllllllIllllIlIlllIIIIlllIIl;
        if (lllllllllllIllllIlIlllIIIIlllIIl == null) {
            this.renderViewEntity = null;
        }
    }
    
    private void renderDebugBoundingBox(final Entity lllllllllllIllllIlIlllIIIlIIllII, final double lllllllllllIllllIlIlllIIIlIlllIl, final double lllllllllllIllllIlIlllIIIlIlllII, final double lllllllllllIllllIlIlllIIIlIIlIIl, final float lllllllllllIllllIlIlllIIIlIllIlI, final float lllllllllllIllllIlIlllIIIlIllIIl) {
        GlStateManager.depthMask(false);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        final float lllllllllllIllllIlIlllIIIlIllIII = lllllllllllIllllIlIlllIIIlIIllII.width / 2.0f;
        final AxisAlignedBB lllllllllllIllllIlIlllIIIlIlIlll = lllllllllllIllllIlIlllIIIlIIllII.getEntityBoundingBox();
        RenderGlobal.drawBoundingBox(lllllllllllIllllIlIlllIIIlIlIlll.minX - lllllllllllIllllIlIlllIIIlIIllII.posX + lllllllllllIllllIlIlllIIIlIlllIl, lllllllllllIllllIlIlllIIIlIlIlll.minY - lllllllllllIllllIlIlllIIIlIIllII.posY + lllllllllllIllllIlIlllIIIlIlllII, lllllllllllIllllIlIlllIIIlIlIlll.minZ - lllllllllllIllllIlIlllIIIlIIllII.posZ + lllllllllllIllllIlIlllIIIlIIlIIl, lllllllllllIllllIlIlllIIIlIlIlll.maxX - lllllllllllIllllIlIlllIIIlIIllII.posX + lllllllllllIllllIlIlllIIIlIlllIl, lllllllllllIllllIlIlllIIIlIlIlll.maxY - lllllllllllIllllIlIlllIIIlIIllII.posY + lllllllllllIllllIlIlllIIIlIlllII, lllllllllllIllllIlIlllIIIlIlIlll.maxZ - lllllllllllIllllIlIlllIIIlIIllII.posZ + lllllllllllIllllIlIlllIIIlIIlIIl, 1.0f, 1.0f, 1.0f, 1.0f);
        final Entity[] lllllllllllIllllIlIlllIIIlIlIllI = lllllllllllIllllIlIlllIIIlIIllII.getParts();
        if (lllllllllllIllllIlIlllIIIlIlIllI != null) {
            final double lllllllllllIllllIlIlllIIIlIIIIIl;
            final int length = (lllllllllllIllllIlIlllIIIlIIIIIl = (double)(Object)lllllllllllIllllIlIlllIIIlIlIllI).length;
            for (boolean lllllllllllIllllIlIlllIIIlIIIIll = false; (lllllllllllIllllIlIlllIIIlIIIIll ? 1 : 0) < length; ++lllllllllllIllllIlIlllIIIlIIIIll) {
                final Entity lllllllllllIllllIlIlllIIIlIlIlIl = lllllllllllIllllIlIlllIIIlIIIIIl[lllllllllllIllllIlIlllIIIlIIIIll];
                final double lllllllllllIllllIlIlllIIIlIlIlII = (lllllllllllIllllIlIlllIIIlIlIlIl.posX - lllllllllllIllllIlIlllIIIlIlIlIl.prevPosX) * lllllllllllIllllIlIlllIIIlIllIIl;
                final double lllllllllllIllllIlIlllIIIlIlIIll = (lllllllllllIllllIlIlllIIIlIlIlIl.posY - lllllllllllIllllIlIlllIIIlIlIlIl.prevPosY) * lllllllllllIllllIlIlllIIIlIllIIl;
                final double lllllllllllIllllIlIlllIIIlIlIIlI = (lllllllllllIllllIlIlllIIIlIlIlIl.posZ - lllllllllllIllllIlIlllIIIlIlIlIl.prevPosZ) * lllllllllllIllllIlIlllIIIlIllIIl;
                final AxisAlignedBB lllllllllllIllllIlIlllIIIlIlIIIl = lllllllllllIllllIlIlllIIIlIlIlIl.getEntityBoundingBox();
                RenderGlobal.drawBoundingBox(lllllllllllIllllIlIlllIIIlIlIIIl.minX - RenderManager.renderPosX + lllllllllllIllllIlIlllIIIlIlIlII, lllllllllllIllllIlIlllIIIlIlIIIl.minY - RenderManager.renderPosY + lllllllllllIllllIlIlllIIIlIlIIll, lllllllllllIllllIlIlllIIIlIlIIIl.minZ - RenderManager.renderPosZ + lllllllllllIllllIlIlllIIIlIlIIlI, lllllllllllIllllIlIlllIIIlIlIIIl.maxX - RenderManager.renderPosX + lllllllllllIllllIlIlllIIIlIlIlII, lllllllllllIllllIlIlllIIIlIlIIIl.maxY - RenderManager.renderPosY + lllllllllllIllllIlIlllIIIlIlIIll, lllllllllllIllllIlIlllIIIlIlIIIl.maxZ - RenderManager.renderPosZ + lllllllllllIllllIlIlllIIIlIlIIlI, 0.25f, 1.0f, 0.0f, 1.0f);
            }
        }
        if (lllllllllllIllllIlIlllIIIlIIllII instanceof EntityLivingBase) {
            final float lllllllllllIllllIlIlllIIIlIlIIII = 0.01f;
            RenderGlobal.drawBoundingBox(lllllllllllIllllIlIlllIIIlIlllIl - lllllllllllIllllIlIlllIIIlIllIII, lllllllllllIllllIlIlllIIIlIlllII + lllllllllllIllllIlIlllIIIlIIllII.getEyeHeight() - 0.009999999776482582, lllllllllllIllllIlIlllIIIlIIlIIl - lllllllllllIllllIlIlllIIIlIllIII, lllllllllllIllllIlIlllIIIlIlllIl + lllllllllllIllllIlIlllIIIlIllIII, lllllllllllIllllIlIlllIIIlIlllII + lllllllllllIllllIlIlllIIIlIIllII.getEyeHeight() + 0.009999999776482582, lllllllllllIllllIlIlllIIIlIIlIIl + lllllllllllIllllIlIlllIIIlIllIII, 1.0f, 0.0f, 0.0f, 1.0f);
        }
        final Tessellator lllllllllllIllllIlIlllIIIlIIllll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIllllIlIlllIIIlIIlllI = lllllllllllIllllIlIlllIIIlIIllll.getBuffer();
        final Vec3d lllllllllllIllllIlIlllIIIlIIllIl = lllllllllllIllllIlIlllIIIlIIllII.getLook(lllllllllllIllllIlIlllIIIlIllIIl);
        lllllllllllIllllIlIlllIIIlIIlllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllIllllIlIlllIIIlIIlllI.pos(lllllllllllIllllIlIlllIIIlIlllIl, lllllllllllIllllIlIlllIIIlIlllII + lllllllllllIllllIlIlllIIIlIIllII.getEyeHeight(), lllllllllllIllllIlIlllIIIlIIlIIl).color(0, 0, 255, 255).endVertex();
        lllllllllllIllllIlIlllIIIlIIlllI.pos(lllllllllllIllllIlIlllIIIlIlllIl + lllllllllllIllllIlIlllIIIlIIllIl.xCoord * 2.0, lllllllllllIllllIlIlllIIIlIlllII + lllllllllllIllllIlIlllIIIlIIllII.getEyeHeight() + lllllllllllIllllIlIlllIIIlIIllIl.yCoord * 2.0, lllllllllllIllllIlIlllIIIlIIlIIl + lllllllllllIllllIlIlllIIIlIIllIl.zCoord * 2.0).color(0, 0, 255, 255).endVertex();
        lllllllllllIllllIlIlllIIIlIIllll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
    }
}
