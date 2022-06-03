// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.utils.friend.FriendManager;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.impl.visuals.CustomModel;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.Chams;
import ru.rockstar.Main;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.item.EnumAction;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerEntityOnShoulder;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.renderer.entity.layers.LayerDeadmau5Head;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.entity.AbstractClientPlayer;

public class RenderPlayer extends RenderLivingBase<AbstractClientPlayer>
{
    private final /* synthetic */ boolean smallArms;
    
    @Override
    protected void renderLivingAt(final AbstractClientPlayer lllllllllllllIlIllIlllIllllllIlI, final double lllllllllllllIlIllIlllIllllllIIl, final double lllllllllllllIlIllIlllIllllllIII, final double lllllllllllllIlIllIlllIlllllIIlI) {
        if (lllllllllllllIlIllIlllIllllllIlI.isEntityAlive() && lllllllllllllIlIllIlllIllllllIlI.isPlayerSleeping()) {
            super.renderLivingAt(lllllllllllllIlIllIlllIllllllIlI, lllllllllllllIlIllIlllIllllllIIl + lllllllllllllIlIllIlllIllllllIlI.renderOffsetX, lllllllllllllIlIllIlllIllllllIII + lllllllllllllIlIllIlllIllllllIlI.renderOffsetY, lllllllllllllIlIllIlllIlllllIIlI + lllllllllllllIlIllIlllIllllllIlI.renderOffsetZ);
        }
        else {
            super.renderLivingAt(lllllllllllllIlIllIlllIllllllIlI, lllllllllllllIlIllIlllIllllllIIl, lllllllllllllIlIllIlllIllllllIII, lllllllllllllIlIllIlllIlllllIIlI);
        }
    }
    
    public void renderRightArm(final AbstractClientPlayer lllllllllllllIlIllIllllIIIIlIIll) {
        final float lllllllllllllIlIllIllllIIIIlIlll = 1.0f;
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final float lllllllllllllIlIllIllllIIIIlIllI = 0.0625f;
        final ModelPlayer lllllllllllllIlIllIllllIIIIlIlIl = this.getMainModel();
        this.setModelVisibilities(lllllllllllllIlIllIllllIIIIlIIll);
        GlStateManager.enableBlend();
        lllllllllllllIlIllIllllIIIIlIlIl.swingProgress = 0.0f;
        lllllllllllllIlIllIllllIIIIlIlIl.isSneak = false;
        lllllllllllllIlIllIllllIIIIlIlIl.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllIlIllIllllIIIIlIIll);
        lllllllllllllIlIllIllllIIIIlIlIl.bipedRightArm.rotateAngleX = 0.0f;
        lllllllllllllIlIllIllllIIIIlIlIl.bipedRightArm.render(0.0625f);
        lllllllllllllIlIllIllllIIIIlIlIl.bipedRightArmwear.rotateAngleX = 0.0f;
        lllllllllllllIlIllIllllIIIIlIlIl.bipedRightArmwear.render(0.0625f);
        GlStateManager.disableBlend();
    }
    
    public RenderPlayer(final RenderManager lllllllllllllIlIllIllllIlIIIIIII, final boolean lllllllllllllIlIllIllllIIlllllII) {
        super(lllllllllllllIlIllIllllIlIIIIIII, new ModelPlayer(0.0f, lllllllllllllIlIllIllllIIlllllII), 0.5f);
        this.smallArms = lllllllllllllIlIllIllllIIlllllII;
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerArrow(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerDeadmau5Head(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCape(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerElytra(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEntityOnShoulder(lllllllllllllIlIllIllllIlIIIIIII));
    }
    
    private void setModelVisibilities(final AbstractClientPlayer lllllllllllllIlIllIllllIIlIIlllI) {
        final ModelPlayer lllllllllllllIlIllIllllIIlIlIllI = this.getMainModel();
        if (lllllllllllllIlIllIllllIIlIIlllI.isSpectator()) {
            lllllllllllllIlIllIllllIIlIlIllI.setInvisible(false);
            lllllllllllllIlIllIllllIIlIlIllI.bipedHead.showModel = true;
            lllllllllllllIlIllIllllIIlIlIllI.bipedHeadwear.showModel = true;
        }
        else {
            final ItemStack lllllllllllllIlIllIllllIIlIlIlIl = lllllllllllllIlIllIllllIIlIIlllI.getHeldItemMainhand();
            final ItemStack lllllllllllllIlIllIllllIIlIlIlII = lllllllllllllIlIllIllllIIlIIlllI.getHeldItemOffhand();
            lllllllllllllIlIllIllllIIlIlIllI.setInvisible(true);
            lllllllllllllIlIllIllllIIlIlIllI.bipedHeadwear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.HAT);
            lllllllllllllIlIllIllllIIlIlIllI.bipedBodyWear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.JACKET);
            lllllllllllllIlIllIllllIIlIlIllI.bipedLeftLegwear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.LEFT_PANTS_LEG);
            lllllllllllllIlIllIllllIIlIlIllI.bipedRightLegwear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.RIGHT_PANTS_LEG);
            lllllllllllllIlIllIllllIIlIlIllI.bipedLeftArmwear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.LEFT_SLEEVE);
            lllllllllllllIlIllIllllIIlIlIllI.bipedRightArmwear.showModel = lllllllllllllIlIllIllllIIlIIlllI.isWearing(EnumPlayerModelParts.RIGHT_SLEEVE);
            lllllllllllllIlIllIllllIIlIlIllI.isSneak = lllllllllllllIlIllIllllIIlIIlllI.isSneaking();
            ModelBiped.ArmPose lllllllllllllIlIllIllllIIlIlIIll = ModelBiped.ArmPose.EMPTY;
            ModelBiped.ArmPose lllllllllllllIlIllIllllIIlIlIIlI = ModelBiped.ArmPose.EMPTY;
            if (!lllllllllllllIlIllIllllIIlIlIlIl.isEmpty()) {
                lllllllllllllIlIllIllllIIlIlIIll = ModelBiped.ArmPose.ITEM;
                if (lllllllllllllIlIllIllllIIlIIlllI.getItemInUseCount() > 0) {
                    final EnumAction lllllllllllllIlIllIllllIIlIlIIIl = lllllllllllllIlIllIllllIIlIlIlIl.getItemUseAction();
                    if (lllllllllllllIlIllIllllIIlIlIIIl == EnumAction.BLOCK) {
                        lllllllllllllIlIllIllllIIlIlIIll = ModelBiped.ArmPose.BLOCK;
                    }
                    else if (lllllllllllllIlIllIllllIIlIlIIIl == EnumAction.BOW) {
                        lllllllllllllIlIllIllllIIlIlIIll = ModelBiped.ArmPose.BOW_AND_ARROW;
                    }
                }
            }
            if (!lllllllllllllIlIllIllllIIlIlIlII.isEmpty()) {
                lllllllllllllIlIllIllllIIlIlIIlI = ModelBiped.ArmPose.ITEM;
                if (lllllllllllllIlIllIllllIIlIIlllI.getItemInUseCount() > 0) {
                    final EnumAction lllllllllllllIlIllIllllIIlIlIIII = lllllllllllllIlIllIllllIIlIlIlII.getItemUseAction();
                    if (lllllllllllllIlIllIllllIIlIlIIII == EnumAction.BLOCK) {
                        lllllllllllllIlIllIllllIIlIlIIlI = ModelBiped.ArmPose.BLOCK;
                    }
                }
            }
            if (lllllllllllllIlIllIllllIIlIIlllI.getPrimaryHand() == EnumHandSide.RIGHT) {
                lllllllllllllIlIllIllllIIlIlIllI.rightArmPose = lllllllllllllIlIllIllllIIlIlIIll;
                lllllllllllllIlIllIllllIIlIlIllI.leftArmPose = lllllllllllllIlIllIllllIIlIlIIlI;
            }
            else {
                lllllllllllllIlIllIllllIIlIlIllI.rightArmPose = lllllllllllllIlIllIllllIIlIlIIlI;
                lllllllllllllIlIllIllllIIlIlIllI.leftArmPose = lllllllllllllIlIllIllllIIlIlIIll;
            }
        }
    }
    
    @Override
    public void doRender(final AbstractClientPlayer lllllllllllllIlIllIllllIIllIIlll, final double lllllllllllllIlIllIllllIIllIlllI, final double lllllllllllllIlIllIllllIIllIIlIl, final double lllllllllllllIlIllIllllIIllIIlII, final float lllllllllllllIlIllIllllIIllIIIll, final float lllllllllllllIlIllIllllIIllIIIlI) {
        if (!lllllllllllllIlIllIllllIIllIIlll.isUser() || this.renderManager.renderViewEntity == lllllllllllllIlIllIllllIIllIIlll) {
            double lllllllllllllIlIllIllllIIllIlIIl = lllllllllllllIlIllIllllIIllIIlIl;
            if (lllllllllllllIlIllIllllIIllIIlll.isSneaking()) {
                lllllllllllllIlIllIllllIIllIlIIl = lllllllllllllIlIllIllllIIllIIlIl - 0.125;
            }
            this.setModelVisibilities(lllllllllllllIlIllIllllIIllIIlll);
            if (Main.featureDirector.getFeatureByClass(Chams.class).isToggled() && Chams.chamsMode.currentMode.equalsIgnoreCase("Walls")) {
                GL11.glEnable(32823);
                GlStateManager.enablePolygonOffset();
                GlStateManager.doPolygonOffset(1.0f, -1000000.0f);
                super.doRender(lllllllllllllIlIllIllllIIllIIlll, lllllllllllllIlIllIllllIIllIlllI, lllllllllllllIlIllIllllIIllIlIIl, lllllllllllllIlIllIllllIIllIIlII, lllllllllllllIlIllIllllIIllIIIll, lllllllllllllIlIllIllllIIllIIIlI);
                GL11.glDisable(32823);
                GlStateManager.doPolygonOffset(1.0f, 1000000.0f);
                GlStateManager.disablePolygonOffset();
            }
            else {
                GlStateManager.enableBlendProfile(GlStateManager.Profile.PLAYER_SKIN);
                super.doRender(lllllllllllllIlIllIllllIIllIIlll, lllllllllllllIlIllIllllIIllIlllI, lllllllllllllIlIllIllllIIllIlIIl, lllllllllllllIlIllIllllIIllIIlII, lllllllllllllIlIllIllllIIllIIIll, lllllllllllllIlIllIllllIIllIIIlI);
            }
        }
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    public RenderPlayer(final RenderManager lllllllllllllIlIllIllllIlIIIIlll) {
        this(lllllllllllllIlIllIllllIlIIIIlll, false);
    }
    
    public ResourceLocation getEntityTexture(final AbstractClientPlayer lllllllllllllIlIllIllllIIlIIIlIl) {
        if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled()) {
            if (CustomModel.onlyMe.getBoolValue() && lllllllllllllIlIllIllllIIlIIIlIl != Minecraft.getMinecraft().player) {
                final FriendManager friendManager = Main.instance.friendManager;
                if (!FriendManager.isFriend(lllllllllllllIlIllIllllIIlIIIlIl.getName()) || !CustomModel.friends.getBoolValue()) {
                    return lllllllllllllIlIllIllllIIlIIIlIl.getLocationSkin();
                }
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Amogus")) {
                return new ResourceLocation("amogus.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Jeff Killer")) {
                return new ResourceLocation("jeff.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Crab")) {
                return new ResourceLocation("crab.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Demon")) {
                return new ResourceLocation("demon.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Red Panda")) {
                return new ResourceLocation("redpanda.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Freddy Bear")) {
                return new ResourceLocation("freddy.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Chinchilla")) {
                return new ResourceLocation("chinchilla.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("CupHead")) {
                return new ResourceLocation("cuphead.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Sonic")) {
                return new ResourceLocation("sonic.png");
            }
            if (Main.featureDirector.getFeatureByClass(CustomModel.class).isToggled() && CustomModel.modelMode.currentMode.equals("Crazy Rabbit")) {
                return new ResourceLocation("rabbit.png");
            }
        }
        return lllllllllllllIlIllIllllIIlIIIlIl.getLocationSkin();
    }
    
    @Override
    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();
    }
    
    @Override
    protected void preRenderCallback(final AbstractClientPlayer lllllllllllllIlIllIllllIIlIIIIII, final float lllllllllllllIlIllIllllIIIllllll) {
        final float lllllllllllllIlIllIllllIIIlllllI = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    @Override
    protected void rotateCorpse(final AbstractClientPlayer lllllllllllllIlIllIlllIlllIllIII, final float lllllllllllllIlIllIlllIlllIlIlll, final float lllllllllllllIlIllIlllIlllIlIllI, final float lllllllllllllIlIllIlllIllllIIIIl) {
        if (lllllllllllllIlIllIlllIlllIllIII.isEntityAlive() && lllllllllllllIlIllIlllIlllIllIII.isPlayerSleeping()) {
            GlStateManager.rotate(lllllllllllllIlIllIlllIlllIllIII.getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.getDeathMaxRotation(lllllllllllllIlIllIlllIlllIllIII), 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(270.0f, 0.0f, 1.0f, 0.0f);
        }
        else if (lllllllllllllIlIllIlllIlllIllIII.isElytraFlying()) {
            super.rotateCorpse(lllllllllllllIlIllIlllIlllIllIII, lllllllllllllIlIllIlllIlllIlIlll, lllllllllllllIlIllIlllIlllIlIllI, lllllllllllllIlIllIlllIllllIIIIl);
            final float lllllllllllllIlIllIlllIllllIIIII = lllllllllllllIlIllIlllIlllIllIII.getTicksElytraFlying() + lllllllllllllIlIllIlllIllllIIIIl;
            final float lllllllllllllIlIllIlllIlllIlllll = MathHelper.clamp(lllllllllllllIlIllIlllIllllIIIII * lllllllllllllIlIllIlllIllllIIIII / 100.0f, 0.0f, 1.0f);
            GlStateManager.rotate(lllllllllllllIlIllIlllIlllIlllll * (-90.0f - lllllllllllllIlIllIlllIlllIllIII.rotationPitch), 1.0f, 0.0f, 0.0f);
            final Vec3d lllllllllllllIlIllIlllIlllIllllI = lllllllllllllIlIllIlllIlllIllIII.getLook(lllllllllllllIlIllIlllIllllIIIIl);
            final double lllllllllllllIlIllIlllIlllIlllIl = lllllllllllllIlIllIlllIlllIllIII.motionX * lllllllllllllIlIllIlllIlllIllIII.motionX + lllllllllllllIlIllIlllIlllIllIII.motionZ * lllllllllllllIlIllIlllIlllIllIII.motionZ;
            final double lllllllllllllIlIllIlllIlllIlllII = lllllllllllllIlIllIlllIlllIllllI.xCoord * lllllllllllllIlIllIlllIlllIllllI.xCoord + lllllllllllllIlIllIlllIlllIllllI.zCoord * lllllllllllllIlIllIlllIlllIllllI.zCoord;
            if (lllllllllllllIlIllIlllIlllIlllIl > 0.0 && lllllllllllllIlIllIlllIlllIlllII > 0.0) {
                final double lllllllllllllIlIllIlllIlllIllIll = (lllllllllllllIlIllIlllIlllIllIII.motionX * lllllllllllllIlIllIlllIlllIllllI.xCoord + lllllllllllllIlIllIlllIlllIllIII.motionZ * lllllllllllllIlIllIlllIlllIllllI.zCoord) / (Math.sqrt(lllllllllllllIlIllIlllIlllIlllIl) * Math.sqrt(lllllllllllllIlIllIlllIlllIlllII));
                final double lllllllllllllIlIllIlllIlllIllIlI = lllllllllllllIlIllIlllIlllIllIII.motionX * lllllllllllllIlIllIlllIlllIllllI.zCoord - lllllllllllllIlIllIlllIlllIllIII.motionZ * lllllllllllllIlIllIlllIlllIllllI.xCoord;
                GlStateManager.rotate((float)(Math.signum(lllllllllllllIlIllIlllIlllIllIlI) * Math.acos(lllllllllllllIlIllIlllIlllIllIll)) * 180.0f / 3.1415927f, 0.0f, 1.0f, 0.0f);
            }
        }
        else {
            super.rotateCorpse(lllllllllllllIlIllIlllIlllIllIII, lllllllllllllIlIllIlllIlllIlIlll, lllllllllllllIlIllIlllIlllIlIllI, lllllllllllllIlIllIlllIllllIIIIl);
        }
    }
    
    public void renderLeftArm(final AbstractClientPlayer lllllllllllllIlIllIllllIIIIIIlII) {
        final float lllllllllllllIlIllIllllIIIIIlIII = 1.0f;
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final float lllllllllllllIlIllIllllIIIIIIlll = 0.0625f;
        final ModelPlayer lllllllllllllIlIllIllllIIIIIIllI = this.getMainModel();
        this.setModelVisibilities(lllllllllllllIlIllIllllIIIIIIlII);
        GlStateManager.enableBlend();
        lllllllllllllIlIllIllllIIIIIIllI.isSneak = false;
        final ModelPlayer modelPlayer = lllllllllllllIlIllIllllIIIIIIllI;
        final ModelPlayer modelPlayer2 = lllllllllllllIlIllIllllIIIIIIllI;
        final float n = 0.0f;
        modelPlayer2.swingProgress = n;
        modelPlayer.setRotationAngles(n, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllIlIllIllllIIIIIIlII);
        lllllllllllllIlIllIllllIIIIIIllI.bipedLeftArm.rotateAngleX = 0.0f;
        lllllllllllllIlIllIllllIIIIIIllI.bipedLeftArm.render(0.0625f);
        lllllllllllllIlIllIllllIIIIIIllI.bipedLeftArmwear.rotateAngleX = 0.0f;
        lllllllllllllIlIllIllllIIIIIIllI.bipedLeftArmwear.render(0.0625f);
        GlStateManager.disableBlend();
    }
    
    @Override
    protected void renderEntityName(final AbstractClientPlayer lllllllllllllIlIllIllllIIIlIIlll, final double lllllllllllllIlIllIllllIIIllIIII, double lllllllllllllIlIllIllllIIIlIIlIl, final double lllllllllllllIlIllIllllIIIlIlllI, final String lllllllllllllIlIllIllllIIIlIIIll, final double lllllllllllllIlIllIllllIIIlIllII) {
        if (lllllllllllllIlIllIllllIIIlIllII < 100.0) {
            final Scoreboard lllllllllllllIlIllIllllIIIlIlIll = lllllllllllllIlIllIllllIIIlIIlll.getWorldScoreboard();
            final ScoreObjective lllllllllllllIlIllIllllIIIlIlIlI = lllllllllllllIlIllIllllIIIlIlIll.getObjectiveInDisplaySlot(2);
            if (lllllllllllllIlIllIllllIIIlIlIlI != null) {
                final Score lllllllllllllIlIllIllllIIIlIlIIl = lllllllllllllIlIllIllllIIIlIlIll.getOrCreateScore(lllllllllllllIlIllIllllIIIlIIlll.getName(), lllllllllllllIlIllIllllIIIlIlIlI);
                this.renderLivingLabel(lllllllllllllIlIllIllllIIIlIIlll, String.valueOf(lllllllllllllIlIllIllllIIIlIlIIl.getScorePoints()) + " " + lllllllllllllIlIllIllllIIIlIlIlI.getDisplayName(), lllllllllllllIlIllIllllIIIllIIII, lllllllllllllIlIllIllllIIIlIIlIl, lllllllllllllIlIllIllllIIIlIlllI, 64);
                lllllllllllllIlIllIllllIIIlIIlIl += this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15f * 0.025f;
            }
        }
        super.renderEntityName(lllllllllllllIlIllIllllIIIlIIlll, lllllllllllllIlIllIllllIIIllIIII, lllllllllllllIlIllIllllIIIlIIlIl, lllllllllllllIlIllIllllIIIlIlllI, lllllllllllllIlIllIllllIIIlIIIll, lllllllllllllIlIllIllllIIIlIllII);
    }
}
