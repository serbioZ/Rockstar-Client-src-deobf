// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.world.storage.MapData;
import net.minecraft.world.World;
import optifine.ReflectorForge;
import ru.rockstar.client.features.impl.combat.KillAura;
import net.minecraft.item.ItemMap;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.Block;
import optifine.DynamicLights;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import ru.rockstar.client.features.impl.visuals.ViewModel;
import ru.rockstar.api.event.event.EventTransformSideFirstPerson;
import net.minecraft.item.EnumAction;
import net.minecraft.client.entity.EntityPlayerSP;
import shadersmod.client.Shaders;
import optifine.Config;
import java.util.Objects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import ru.rockstar.client.features.impl.visuals.NoRender;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.client.features.impl.visuals.SwingAnimations;
import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.entity.AbstractClientPlayer;
import optifine.Reflector;
import net.minecraft.init.Items;
import com.google.common.base.MoreObjects;
import net.minecraft.util.EnumHand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemRenderer
{
    private static final /* synthetic */ ResourceLocation RES_UNDERWATER_OVERLAY;
    private /* synthetic */ ItemStack itemStackOffHand;
    private final /* synthetic */ RenderManager renderManager;
    private /* synthetic */ float equippedProgressMainHand;
    private /* synthetic */ float prevEquippedProgressOffHand;
    private /* synthetic */ ItemStack itemStackMainHand;
    private /* synthetic */ float equippedProgressOffHand;
    private final /* synthetic */ RenderItem itemRenderer;
    private /* synthetic */ float prevEquippedProgressMainHand;
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ResourceLocation RES_MAP_BACKGROUND;
    private /* synthetic */ float spin;
    
    public void renderItemInFirstPerson(final float lllllllllllIIlIllIIIlIllIIlIlIII) {
        final AbstractClientPlayer lllllllllllIIlIllIIIlIllIIlIIlll = this.mc.player;
        final float lllllllllllIIlIllIIIlIllIIlIIllI = lllllllllllIIlIllIIIlIllIIlIIlll.getSwingProgress(lllllllllllIIlIllIIIlIllIIlIlIII);
        final EnumHand lllllllllllIIlIllIIIlIllIIlIIlIl = (EnumHand)MoreObjects.firstNonNull((Object)lllllllllllIIlIllIIIlIllIIlIIlll.swingingHand, (Object)EnumHand.MAIN_HAND);
        final float lllllllllllIIlIllIIIlIllIIlIIlII = lllllllllllIIlIllIIIlIllIIlIIlll.prevRotationPitch + (lllllllllllIIlIllIIIlIllIIlIIlll.rotationPitch - lllllllllllIIlIllIIIlIllIIlIIlll.prevRotationPitch) * lllllllllllIIlIllIIIlIllIIlIlIII;
        final float lllllllllllIIlIllIIIlIllIIlIIIll = lllllllllllIIlIllIIIlIllIIlIIlll.prevRotationYaw + (lllllllllllIIlIllIIIlIllIIlIIlll.rotationYaw - lllllllllllIIlIllIIIlIllIIlIIlll.prevRotationYaw) * lllllllllllIIlIllIIIlIllIIlIlIII;
        boolean lllllllllllIIlIllIIIlIllIIlIIIlI = true;
        boolean lllllllllllIIlIllIIIlIllIIlIIIIl = true;
        if (lllllllllllIIlIllIIIlIllIIlIIlll.isHandActive()) {
            final ItemStack lllllllllllIIlIllIIIlIllIIlIIIII = lllllllllllIIlIllIIIlIllIIlIIlll.getActiveItemStack();
            if (!lllllllllllIIlIllIIIlIllIIlIIIII.func_190926_b() && lllllllllllIIlIllIIIlIllIIlIIIII.getItem() == Items.BOW) {
                final EnumHand lllllllllllIIlIllIIIlIllIIIlllll = lllllllllllIIlIllIIIlIllIIlIIlll.getActiveHand();
                lllllllllllIIlIllIIIlIllIIlIIIlI = (lllllllllllIIlIllIIIlIllIIIlllll == EnumHand.MAIN_HAND);
                lllllllllllIIlIllIIIlIllIIlIIIIl = !lllllllllllIIlIllIIIlIllIIlIIIlI;
            }
        }
        this.rotateArroundXAndY(lllllllllllIIlIllIIIlIllIIlIIlII, lllllllllllIIlIllIIIlIllIIlIIIll);
        this.setLightmap();
        this.rotateArm(lllllllllllIIlIllIIIlIllIIlIlIII);
        GlStateManager.enableRescaleNormal();
        if (lllllllllllIIlIllIIIlIllIIlIIIlI) {
            final float lllllllllllIIlIllIIIlIllIIIllllI = (lllllllllllIIlIllIIIlIllIIlIIlIl == EnumHand.MAIN_HAND) ? lllllllllllIIlIllIIIlIllIIlIIllI : 0.0f;
            final float lllllllllllIIlIllIIIlIllIIIlllIl = 1.0f - (this.prevEquippedProgressMainHand + (this.equippedProgressMainHand - this.prevEquippedProgressMainHand) * lllllllllllIIlIllIIIlIllIIlIlIII);
            if (!Reflector.ForgeHooksClient_renderSpecificFirstPersonHand.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_renderSpecificFirstPersonHand, new Object[] { EnumHand.MAIN_HAND, lllllllllllIIlIllIIIlIllIIlIlIII, lllllllllllIIlIllIIIlIllIIlIIlII, lllllllllllIIlIllIIIlIllIIIllllI, lllllllllllIIlIllIIIlIllIIIlllIl, this.itemStackMainHand })) {
                this.renderItemInFirstPerson(lllllllllllIIlIllIIIlIllIIlIIlll, lllllllllllIIlIllIIIlIllIIlIlIII, lllllllllllIIlIllIIIlIllIIlIIlII, EnumHand.MAIN_HAND, lllllllllllIIlIllIIIlIllIIIllllI, this.itemStackMainHand, lllllllllllIIlIllIIIlIllIIIlllIl);
            }
        }
        if (lllllllllllIIlIllIIIlIllIIlIIIIl) {
            final float lllllllllllIIlIllIIIlIllIIIlllII = (lllllllllllIIlIllIIIlIllIIlIIlIl == EnumHand.OFF_HAND) ? lllllllllllIIlIllIIIlIllIIlIIllI : 0.0f;
            final float lllllllllllIIlIllIIIlIllIIIllIll = 1.0f - (this.prevEquippedProgressOffHand + (this.equippedProgressOffHand - this.prevEquippedProgressOffHand) * lllllllllllIIlIllIIIlIllIIlIlIII);
            if (!Reflector.ForgeHooksClient_renderSpecificFirstPersonHand.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_renderSpecificFirstPersonHand, new Object[] { EnumHand.OFF_HAND, lllllllllllIIlIllIIIlIllIIlIlIII, lllllllllllIIlIllIIIlIllIIlIIlII, lllllllllllIIlIllIIIlIllIIIlllII, lllllllllllIIlIllIIIlIllIIIllIll, this.itemStackOffHand })) {
                this.renderItemInFirstPerson(lllllllllllIIlIllIIIlIllIIlIIlll, lllllllllllIIlIllIIIlIllIIlIlIII, lllllllllllIIlIllIIIlIllIIlIIlII, EnumHand.OFF_HAND, lllllllllllIIlIllIIIlIllIIIlllII, this.itemStackOffHand, lllllllllllIIlIllIIIlIllIIIllIll);
            }
        }
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }
    
    private void renderFireInFirstPerson() {
        final Tessellator lllllllllllIIlIllIIIlIlIIlIIIIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIlIllIIIlIlIIIllllll = lllllllllllIIlIllIIIlIlIIlIIIIII.getBuffer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final float lllllllllllIIlIllIIIlIlIIIlllllI = 1.0f;
        for (int lllllllllllIIlIllIIIlIlIIIllllIl = 0; lllllllllllIIlIllIIIlIlIIIllllIl < 2; ++lllllllllllIIlIllIIIlIlIIIllllIl) {
            GlStateManager.pushMatrix();
            final TextureAtlasSprite lllllllllllIIlIllIIIlIlIIIllllII = this.mc.getTextureMapBlocks().getAtlasSprite("minecraft:blocks/fire_layer_1");
            this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            final float lllllllllllIIlIllIIIlIlIIIlllIll = lllllllllllIIlIllIIIlIlIIIllllII.getMinU();
            final float lllllllllllIIlIllIIIlIlIIIlllIlI = lllllllllllIIlIllIIIlIlIIIllllII.getMaxU();
            final float lllllllllllIIlIllIIIlIlIIIlllIIl = lllllllllllIIlIllIIIlIlIIIllllII.getMinV();
            final float lllllllllllIIlIllIIIlIlIIIlllIII = lllllllllllIIlIllIIIlIlIIIllllII.getMaxV();
            final float lllllllllllIIlIllIIIlIlIIIllIlll = -0.5f;
            final float lllllllllllIIlIllIIIlIlIIIllIllI = 0.5f;
            final float lllllllllllIIlIllIIIlIlIIIllIlIl = -0.5f;
            final float lllllllllllIIlIllIIIlIlIIIllIlII = 0.5f;
            final float lllllllllllIIlIllIIIlIlIIIllIIll = -0.5f;
            GlStateManager.translate(-(lllllllllllIIlIllIIIlIlIIIllllIl * 2 - 1) * 0.24f, -0.3f, 0.0f);
            GlStateManager.rotate((lllllllllllIIlIllIIIlIlIIIllllIl * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            lllllllllllIIlIllIIIlIlIIIllllll.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIIlIllIIIlIlIIIllllll.pos(-0.5, -0.5, -0.5).tex(lllllllllllIIlIllIIIlIlIIIlllIlI, lllllllllllIIlIllIIIlIlIIIlllIII).endVertex();
            lllllllllllIIlIllIIIlIlIIIllllll.pos(0.5, -0.5, -0.5).tex(lllllllllllIIlIllIIIlIlIIIlllIll, lllllllllllIIlIllIIIlIlIIIlllIII).endVertex();
            lllllllllllIIlIllIIIlIlIIIllllll.pos(0.5, 0.5, -0.5).tex(lllllllllllIIlIllIIIlIlIIIlllIll, lllllllllllIIlIllIIIlIlIIIlllIIl).endVertex();
            lllllllllllIIlIllIIIlIlIIIllllll.pos(-0.5, 0.5, -0.5).tex(lllllllllllIIlIllIIIlIlIIIlllIlI, lllllllllllIIlIllIIIlIlIIIlllIIl).endVertex();
            lllllllllllIIlIllIIIlIlIIlIIIIII.draw();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
    }
    
    private void transformFirstPerson(final EnumHandSide lllllllllllIIlIllIIIlIllIlIllIlI, final float lllllllllllIIlIllIIIlIllIlIllIIl) {
        final float lllllllllllIIlIllIIIlIllIlIllIII = (float)(System.currentTimeMillis() / (int)SwingAnimations.item360Speed.getNumberValue() % 360L);
        final int lllllllllllIIlIllIIIlIllIlIlIlll = (lllllllllllIIlIllIIIlIllIlIllIlI == EnumHandSide.RIGHT) ? 1 : -1;
        final float lllllllllllIIlIllIIIlIllIlIlIllI = MathHelper.sin(lllllllllllIIlIllIIIlIllIlIllIIl * lllllllllllIIlIllIIIlIllIlIllIIl * 3.1415927f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlIlIlll * (45.0f + lllllllllllIIlIllIIIlIllIlIlIllI * -20.0f), 0.0f, 1.0f, 0.0f);
        final float lllllllllllIIlIllIIIlIllIlIlIlIl = MathHelper.sin(MathHelper.sqrt(lllllllllllIIlIllIIIlIllIlIllIIl) * 3.1415927f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlIlIlll * lllllllllllIIlIllIIIlIllIlIlIlIl * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlIlIlIl * -80.0f, 1.0f, 0.0f, 0.0f);
        if (Main.featureDirector.getFeatureByClass(SwingAnimations.class).isToggled() && SwingAnimations.item360.getBoolValue()) {
            if ((SwingAnimations.item360Hand.currentMode.equals("Left") && lllllllllllIIlIllIIIlIllIlIllIlI != EnumHandSide.LEFT) || (SwingAnimations.item360Hand.currentMode.equals("Right") && lllllllllllIIlIllIIIlIllIlIllIlI != EnumHandSide.RIGHT && !SwingAnimations.item360Hand.currentMode.equals("All"))) {
                return;
            }
            GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlIllIII, 0.0f, SwingAnimations.item360Mode.currentMode.equals("Horizontal") ? 1.0f : 0.0f, SwingAnimations.item360Mode.currentMode.equals("Vertical") ? lllllllllllIIlIllIIIlIllIlIllIII : 0.0f);
        }
        else {
            GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlIlIlll * -45.0f, 0.0f, 1.0f, 0.0f);
        }
        GlStateManager.translate(0.0f, 0.02f, 0.0f);
    }
    
    public void renderOverlays(final float lllllllllllIIlIllIIIlIlIlIlIlIIl) {
        GlStateManager.disableAlpha();
        if (this.mc.player.isEntityInsideOpaqueBlock()) {
            IBlockState lllllllllllIIlIllIIIlIlIlIllIlII = this.mc.world.getBlockState(new BlockPos(this.mc.player));
            BlockPos lllllllllllIIlIllIIIlIlIlIllIIll = new BlockPos(this.mc.player);
            final EntityPlayer lllllllllllIIlIllIIIlIlIlIllIIlI = this.mc.player;
            for (int lllllllllllIIlIllIIIlIlIlIllIIIl = 0; lllllllllllIIlIllIIIlIlIlIllIIIl < 8; ++lllllllllllIIlIllIIIlIlIlIllIIIl) {
                final double lllllllllllIIlIllIIIlIlIlIllIIII = lllllllllllIIlIllIIIlIlIlIllIIlI.posX + ((lllllllllllIIlIllIIIlIlIlIllIIIl >> 0) % 2 - 0.5f) * lllllllllllIIlIllIIIlIlIlIllIIlI.width * 0.8f;
                final double lllllllllllIIlIllIIIlIlIlIlIllll = lllllllllllIIlIllIIIlIlIlIllIIlI.posY + ((lllllllllllIIlIllIIIlIlIlIllIIIl >> 1) % 2 - 0.5f) * 0.1f;
                final double lllllllllllIIlIllIIIlIlIlIlIlllI = lllllllllllIIlIllIIIlIlIlIllIIlI.posZ + ((lllllllllllIIlIllIIIlIlIlIllIIIl >> 2) % 2 - 0.5f) * lllllllllllIIlIllIIIlIlIlIllIIlI.width * 0.8f;
                final BlockPos lllllllllllIIlIllIIIlIlIlIlIllIl = new BlockPos(lllllllllllIIlIllIIIlIlIlIllIIII, lllllllllllIIlIllIIIlIlIlIlIllll + lllllllllllIIlIllIIIlIlIlIllIIlI.getEyeHeight(), lllllllllllIIlIllIIIlIlIlIlIlllI);
                final IBlockState lllllllllllIIlIllIIIlIlIlIlIllII = this.mc.world.getBlockState(lllllllllllIIlIllIIIlIlIlIlIllIl);
                if (lllllllllllIIlIllIIIlIlIlIlIllII.func_191058_s()) {
                    lllllllllllIIlIllIIIlIlIlIllIlII = lllllllllllIIlIllIIIlIlIlIlIllII;
                    lllllllllllIIlIllIIIlIlIlIllIIll = lllllllllllIIlIllIIIlIlIlIlIllIl;
                }
            }
            if (lllllllllllIIlIllIIIlIlIlIllIlII.getRenderType() != EnumBlockRenderType.INVISIBLE) {
                final Object lllllllllllIIlIllIIIlIlIlIlIlIll = Reflector.getFieldValue(Reflector.RenderBlockOverlayEvent_OverlayType_BLOCK);
                if (!Reflector.callBoolean(Reflector.ForgeEventFactory_renderBlockOverlay, new Object[] { this.mc.player, lllllllllllIIlIllIIIlIlIlIlIlIIl, lllllllllllIIlIllIIIlIlIlIlIlIll, lllllllllllIIlIllIIIlIlIlIllIlII, lllllllllllIIlIllIIIlIlIlIllIIll })) {
                    this.renderBlockInHand(this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(lllllllllllIIlIllIIIlIlIlIllIlII));
                }
            }
        }
        if (!this.mc.player.isSpectator()) {
            if (this.mc.player.isInsideOfMaterial(Material.WATER) && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderWaterOverlay, new Object[] { this.mc.player, lllllllllllIIlIllIIIlIlIlIlIlIIl })) {
                this.renderWaterOverlayTexture(lllllllllllIIlIllIIIlIlIlIlIlIIl);
            }
            if (this.mc.player.isBurning() && !NoRender.noFire.getBoolValue() && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderFireOverlay, new Object[] { this.mc.player, lllllllllllIIlIllIIIlIlIlIlIlIIl })) {
                this.renderFireInFirstPerson();
            }
        }
        GlStateManager.enableAlpha();
    }
    
    public void updateEquippedItem() {
        this.prevEquippedProgressMainHand = this.equippedProgressMainHand;
        this.prevEquippedProgressOffHand = this.equippedProgressOffHand;
        final EntityPlayerSP lllllllllllIIlIllIIIlIlIIIIllIll = this.mc.player;
        final ItemStack lllllllllllIIlIllIIIlIlIIIIllIlI = lllllllllllIIlIllIIIlIlIIIIllIll.getHeldItemMainhand();
        final ItemStack lllllllllllIIlIllIIIlIlIIIIllIIl = lllllllllllIIlIllIIIlIlIIIIllIll.getHeldItemOffhand();
        if (lllllllllllIIlIllIIIlIlIIIIllIll.isRowingBoat()) {
            this.equippedProgressMainHand = MathHelper.clamp(this.equippedProgressMainHand - 0.4f, 0.0f, 1.0f);
            this.equippedProgressOffHand = MathHelper.clamp(this.equippedProgressOffHand - 0.4f, 0.0f, 1.0f);
        }
        else {
            final float lllllllllllIIlIllIIIlIlIIIIllIII = lllllllllllIIlIllIIIlIlIIIIllIll.getCooledAttackStrength(1.0f);
            if (Reflector.ForgeHooksClient_shouldCauseReequipAnimation.exists()) {
                final boolean lllllllllllIIlIllIIIlIlIIIIlIlll = Reflector.callBoolean(Reflector.ForgeHooksClient_shouldCauseReequipAnimation, new Object[] { this.itemStackMainHand, lllllllllllIIlIllIIIlIlIIIIllIlI, lllllllllllIIlIllIIIlIlIIIIllIll.inventory.currentItem });
                final boolean lllllllllllIIlIllIIIlIlIIIIlIllI = Reflector.callBoolean(Reflector.ForgeHooksClient_shouldCauseReequipAnimation, new Object[] { this.itemStackOffHand, lllllllllllIIlIllIIIlIlIIIIllIIl, -1 });
                if (!lllllllllllIIlIllIIIlIlIIIIlIlll && !Objects.equals(this.itemStackMainHand, lllllllllllIIlIllIIIlIlIIIIllIlI)) {
                    this.itemStackMainHand = lllllllllllIIlIllIIIlIlIIIIllIlI;
                }
                if (!lllllllllllIIlIllIIIlIlIIIIlIlll && !Objects.equals(this.itemStackOffHand, lllllllllllIIlIllIIIlIlIIIIllIIl)) {
                    this.itemStackOffHand = lllllllllllIIlIllIIIlIlIIIIllIIl;
                }
                this.equippedProgressMainHand += MathHelper.clamp((lllllllllllIIlIllIIIlIlIIIIlIlll ? 0.0f : (lllllllllllIIlIllIIIlIlIIIIllIII * lllllllllllIIlIllIIIlIlIIIIllIII * lllllllllllIIlIllIIIlIlIIIIllIII)) - this.equippedProgressMainHand, -0.4f, 0.4f);
                this.equippedProgressOffHand += MathHelper.clamp((float)(lllllllllllIIlIllIIIlIlIIIIlIllI ? 0 : 1) - this.equippedProgressOffHand, -0.4f, 0.4f);
            }
            else {
                this.equippedProgressMainHand += MathHelper.clamp((Objects.equals(this.itemStackMainHand, lllllllllllIIlIllIIIlIlIIIIllIlI) ? (lllllllllllIIlIllIIIlIlIIIIllIII * lllllllllllIIlIllIIIlIlIIIIllIII * lllllllllllIIlIllIIIlIlIIIIllIII) : 0.0f) - this.equippedProgressMainHand, -0.4f, 0.4f);
                this.equippedProgressOffHand += MathHelper.clamp((float)(Objects.equals(this.itemStackOffHand, lllllllllllIIlIllIIIlIlIIIIllIIl) ? 1 : 0) - this.equippedProgressOffHand, -0.4f, 0.4f);
            }
        }
        if (this.equippedProgressMainHand < 0.1f) {
            this.itemStackMainHand = lllllllllllIIlIllIIIlIlIIIIllIlI;
            if (Config.isShaders()) {
                Shaders.setItemToRenderMain(this.itemStackMainHand);
            }
        }
        if (this.equippedProgressOffHand < 0.1f) {
            this.itemStackOffHand = lllllllllllIIlIllIIIlIlIIIIllIIl;
            if (Config.isShaders()) {
                Shaders.setItemToRenderOff(this.itemStackOffHand);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumAction() {
        final int[] $switch_TABLE$net$minecraft$item$EnumAction = ItemRenderer.$SWITCH_TABLE$net$minecraft$item$EnumAction;
        if ($switch_TABLE$net$minecraft$item$EnumAction != null) {
            return $switch_TABLE$net$minecraft$item$EnumAction;
        }
        final String lllllllllllIIlIllIIIlIlIIIIIIlll = (Object)new int[EnumAction.values().length];
        try {
            lllllllllllIIlIllIIIlIlIIIIIIlll[EnumAction.BLOCK.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlIllIIIlIlIIIIIIlll[EnumAction.BOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlIllIIIlIlIIIIIIlll[EnumAction.DRINK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIlIllIIIlIlIIIIIIlll[EnumAction.EAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIlIllIIIlIlIIIIIIlll[EnumAction.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return ItemRenderer.$SWITCH_TABLE$net$minecraft$item$EnumAction = (int[])(Object)lllllllllllIIlIllIIIlIlIIIIIIlll;
    }
    
    private void transformEatFirstPerson(final float lllllllllllIIlIllIIIlIllIlllIllI, final EnumHandSide lllllllllllIIlIllIIIlIllIlllIlIl, final ItemStack lllllllllllIIlIllIIIlIllIlllIlII) {
        final EventTransformSideFirstPerson lllllllllllIIlIllIIIlIllIlllIIlI = new EventTransformSideFirstPerson(lllllllllllIIlIllIIIlIllIlllIlIl);
        lllllllllllIIlIllIIIlIllIlllIIlI.call();
        final float lllllllllllIIlIllIIIlIllIlllIIIl = this.mc.player.getItemInUseCount() - lllllllllllIIlIllIIIlIllIlllIllI + 1.0f;
        final float lllllllllllIIlIllIIIlIllIlllIIII = lllllllllllIIlIllIIIlIllIlllIIIl / lllllllllllIIlIllIIIlIllIlllIlII.getMaxItemUseDuration();
        final float lllllllllllIIlIllIIIlIllIllIllll = 1.0f - (float)Math.pow(lllllllllllIIlIllIIIlIllIlllIIII, 27.0);
        final int lllllllllllIIlIllIIIlIllIllIlllI;
        final int lllllllllllIIlIllIIIlIllIlllIIll = lllllllllllIIlIllIIIlIllIllIlllI = ((lllllllllllIIlIllIIIlIllIlllIlIl == EnumHandSide.RIGHT) ? 1 : -1);
        if (lllllllllllIIlIllIIIlIllIlllIIII < 0.8f) {
            final float lllllllllllIIlIllIIIlIllIllIllIl = MathHelper.abs(MathHelper.cos(lllllllllllIIlIllIIIlIllIlllIIIl / 4.0f * 3.1415927f) * 0.1f);
            GlStateManager.translate(0.0f, lllllllllllIIlIllIIIlIllIllIllIl, 0.0f);
        }
        GlStateManager.translate(lllllllllllIIlIllIIIlIllIllIllll * 0.6f * lllllllllllIIlIllIIIlIllIlllIIll, lllllllllllIIlIllIIIlIllIllIllll * -0.5f, lllllllllllIIlIllIIIlIllIllIllll * 0.0f);
        if (Main.featureDirector.getFeatureByClass(ViewModel.class).isToggled()) {
            GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlllIIll * lllllllllllIIlIllIIIlIllIllIllll * 20.0f, 0.0f, 1.0f, 0.0f);
        }
        else {
            GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlllIIll * lllllllllllIIlIllIIIlIllIllIllll * 90.0f, 0.0f, 1.0f, 0.0f);
        }
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIllIllll * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIlllIIll * lllllllllllIIlIllIIIlIllIllIllll * 30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    public ItemRenderer(final Minecraft lllllllllllIIlIllIIIllIIIlIlllll) {
        this.itemStackMainHand = ItemStack.field_190927_a;
        this.itemStackOffHand = ItemStack.field_190927_a;
        this.mc = lllllllllllIIlIllIIIllIIIlIlllll;
        this.renderManager = lllllllllllIIlIllIIIllIIIlIlllll.getRenderManager();
        this.itemRenderer = lllllllllllIIlIllIIIllIIIlIlllll.getRenderItem();
    }
    
    private void rotateArm(final float lllllllllllIIlIllIIIllIIIIIlllII) {
        final EntityPlayerSP lllllllllllIIlIllIIIllIIIIIllIll = this.mc.player;
        final float lllllllllllIIlIllIIIllIIIIIllIlI = lllllllllllIIlIllIIIllIIIIIllIll.prevRenderArmPitch + (lllllllllllIIlIllIIIllIIIIIllIll.renderArmPitch - lllllllllllIIlIllIIIllIIIIIllIll.prevRenderArmPitch) * lllllllllllIIlIllIIIllIIIIIlllII;
        final float lllllllllllIIlIllIIIllIIIIIllIIl = lllllllllllIIlIllIIIllIIIIIllIll.prevRenderArmYaw + (lllllllllllIIlIllIIIllIIIIIllIll.renderArmYaw - lllllllllllIIlIllIIIllIIIIIllIll.prevRenderArmYaw) * lllllllllllIIlIllIIIllIIIIIlllII;
        GlStateManager.rotate((lllllllllllIIlIllIIIllIIIIIllIll.rotationPitch - lllllllllllIIlIllIIIllIIIIIllIlI) * 0.1f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate((lllllllllllIIlIllIIIllIIIIIllIll.rotationYaw - lllllllllllIIlIllIIIllIIIIIllIIl) * 0.1f, 0.0f, 1.0f, 0.0f);
    }
    
    private void renderArmFirstPerson(final float lllllllllllIIlIllIIIlIlllIIlIIII, final float lllllllllllIIlIllIIIlIlllIIllllI, final EnumHandSide lllllllllllIIlIllIIIlIlllIIlllIl) {
        final EventTransformSideFirstPerson lllllllllllIIlIllIIIlIlllIIlllII = new EventTransformSideFirstPerson(lllllllllllIIlIllIIIlIlllIIlllIl);
        lllllllllllIIlIllIIIlIlllIIlllII.call();
        final boolean lllllllllllIIlIllIIIlIlllIIllIll = lllllllllllIIlIllIIIlIlllIIlllIl != EnumHandSide.LEFT;
        final float lllllllllllIIlIllIIIlIlllIIllIlI = lllllllllllIIlIllIIIlIlllIIllIll ? 1.0f : -1.0f;
        final float lllllllllllIIlIllIIIlIlllIIllIIl = MathHelper.sqrt(lllllllllllIIlIllIIIlIlllIIllllI);
        final float lllllllllllIIlIllIIIlIlllIIllIII = -0.3f * MathHelper.sin(lllllllllllIIlIllIIIlIlllIIllIIl * 3.1415927f);
        final float lllllllllllIIlIllIIIlIlllIIlIlll = 0.4f * MathHelper.sin(lllllllllllIIlIllIIIlIlllIIllIIl * 6.2831855f);
        final float lllllllllllIIlIllIIIlIlllIIlIllI = -0.4f * MathHelper.sin(lllllllllllIIlIllIIIlIlllIIllllI * 3.1415927f);
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllIIllIlI * (lllllllllllIIlIllIIIlIlllIIllIII + 0.64000005f), lllllllllllIIlIllIIIlIlllIIlIlll - 0.6f + lllllllllllIIlIllIIIlIlllIIlIIII * -0.6f, lllllllllllIIlIllIIIlIlllIIlIllI - 0.71999997f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllIIllIlI * 45.0f, 0.0f, 1.0f, 0.0f);
        final float lllllllllllIIlIllIIIlIlllIIlIlIl = MathHelper.sin(lllllllllllIIlIllIIIlIlllIIllllI * lllllllllllIIlIllIIIlIlllIIllllI * 3.1415927f);
        final float lllllllllllIIlIllIIIlIlllIIlIlII = MathHelper.sin(lllllllllllIIlIllIIIlIlllIIllIIl * 3.1415927f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllIIllIlI * lllllllllllIIlIllIIIlIlllIIlIlII * 70.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllIIllIlI * lllllllllllIIlIllIIIlIlllIIlIlIl * -20.0f, 0.0f, 0.0f, 1.0f);
        final AbstractClientPlayer lllllllllllIIlIllIIIlIlllIIlIIll = this.mc.player;
        this.mc.getTextureManager().bindTexture(lllllllllllIIlIllIIIlIlllIIlIIll.getLocationSkin());
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllIIllIlI * -1.0f, 3.6f, 3.5f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllIIllIlI * 120.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(200.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllIIllIlI * -135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllIIllIlI * 5.6f, 0.0f, 0.0f);
        final RenderPlayer lllllllllllIIlIllIIIlIlllIIlIIlI = (RenderPlayer)this.renderManager.getEntityRenderObject(lllllllllllIIlIllIIIlIlllIIlIIll);
        GlStateManager.disableCull();
        if (lllllllllllIIlIllIIIlIlllIIllIll) {
            lllllllllllIIlIllIIIlIlllIIlIIlI.renderRightArm(lllllllllllIIlIllIIIlIlllIIlIIll);
        }
        else {
            lllllllllllIIlIllIIIlIlllIIlIIlI.renderLeftArm(lllllllllllIIlIllIIIlIlllIIlIIll);
        }
        GlStateManager.enableCull();
    }
    
    private void transformSideFirstPerson(final EnumHandSide lllllllllllIIlIllIIIlIllIlIIIlIl, final float lllllllllllIIlIllIIIlIllIlIIIlII) {
        final EventTransformSideFirstPerson lllllllllllIIlIllIIIlIllIlIIIlll = new EventTransformSideFirstPerson(lllllllllllIIlIllIIIlIllIlIIIlIl);
        lllllllllllIIlIllIIIlIllIlIIIlll.call();
        final int lllllllllllIIlIllIIIlIllIlIIIllI = (lllllllllllIIlIllIIIlIllIlIIIlIl == EnumHandSide.RIGHT) ? 1 : -1;
        GlStateManager.translate(lllllllllllIIlIllIIIlIllIlIIIllI * 0.56f, -0.52f + lllllllllllIIlIllIIIlIllIlIIIlII * -0.6f, -0.72f);
    }
    
    public void resetEquippedProgress(final EnumHand lllllllllllIIlIllIIIlIlIIIIIlIll) {
        if (lllllllllllIIlIllIIIlIlIIIIIlIll == EnumHand.MAIN_HAND) {
            this.equippedProgressMainHand = 0.0f;
        }
        else {
            this.equippedProgressOffHand = 0.0f;
        }
    }
    
    private void renderArm(final EnumHandSide lllllllllllIIlIllIIIllIIIIIIIIll) {
        this.mc.getTextureManager().bindTexture(this.mc.player.getLocationSkin());
        final Render<AbstractClientPlayer> lllllllllllIIlIllIIIllIIIIIIIIlI = this.renderManager.getEntityRenderObject(this.mc.player);
        final RenderPlayer lllllllllllIIlIllIIIllIIIIIIIIIl = (RenderPlayer)lllllllllllIIlIllIIIllIIIIIIIIlI;
        GlStateManager.pushMatrix();
        final float lllllllllllIIlIllIIIllIIIIIIIIII = (lllllllllllIIlIllIIIllIIIIIIIIll == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        GlStateManager.rotate(92.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIllIIIIIIIIII * -41.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(lllllllllllIIlIllIIIllIIIIIIIIII * 0.3f, -1.1f, 0.45f);
        if (lllllllllllIIlIllIIIllIIIIIIIIll == EnumHandSide.RIGHT) {
            lllllllllllIIlIllIIIllIIIIIIIIIl.renderRightArm(this.mc.player);
        }
        else {
            lllllllllllIIlIllIIIllIIIIIIIIIl.renderLeftArm(this.mc.player);
        }
        GlStateManager.popMatrix();
    }
    
    private void renderArms() {
        if (!this.mc.player.isInvisible()) {
            GlStateManager.disableCull();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
            this.renderArm(EnumHandSide.RIGHT);
            this.renderArm(EnumHandSide.LEFT);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
        }
    }
    
    public void renderItem(final EntityLivingBase lllllllllllIIlIllIIIllIIIlIlIlll, final ItemStack lllllllllllIIlIllIIIllIIIlIlIllI, final ItemCameraTransforms.TransformType lllllllllllIIlIllIIIllIIIlIlIlIl) {
        this.renderItemSide(lllllllllllIIlIllIIIllIIIlIlIlll, lllllllllllIIlIllIIIllIIIlIlIllI, lllllllllllIIlIllIIIllIIIlIlIlIl, false);
    }
    
    private float getMapAngleFromPitch(final float lllllllllllIIlIllIIIllIIIIIIlllI) {
        float lllllllllllIIlIllIIIllIIIIIIllll = 1.0f - lllllllllllIIlIllIIIllIIIIIIlllI / 45.0f + 0.1f;
        lllllllllllIIlIllIIIllIIIIIIllll = MathHelper.clamp(lllllllllllIIlIllIIIllIIIIIIllll, 0.0f, 1.0f);
        lllllllllllIIlIllIIIllIIIIIIllll = -MathHelper.cos(lllllllllllIIlIllIIIllIIIIIIllll * 3.1415927f) * 0.5f + 0.5f;
        return lllllllllllIIlIllIIIllIIIIIIllll;
    }
    
    private void rotateArroundXAndY(final float lllllllllllIIlIllIIIllIIIIllIlIl, final float lllllllllllIIlIllIIIllIIIIllIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(lllllllllllIIlIllIIIllIIIIllIlIl, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIllIIIIllIlII, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    private void transformFirstPersonItem(final float lllllllllllIIlIllIIIlIllIIlllIII, final float lllllllllllIIlIllIIIlIllIIlllIll) {
        GlStateManager.translate(0.56f, -0.44f, -0.71999997f);
        GlStateManager.translate(0.0f, lllllllllllIIlIllIIIlIllIIlllIII * -0.6f, 0.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        final float lllllllllllIIlIllIIIlIllIIlllIlI = MathHelper.sin(lllllllllllIIlIllIIIlIllIIlllIll * lllllllllllIIlIllIIIlIllIIlllIll * 3.1415927f);
        final float lllllllllllIIlIllIIIlIllIIlllIIl = MathHelper.sin(MathHelper.sqrt(lllllllllllIIlIllIIIlIllIIlllIll) * 3.1415927f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIIlllIlI * -20.0f, 0.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIIlllIIl * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllIIlllIIl * -80.0f, 0.01f, 0.0f, 0.0f);
        GlStateManager.translate(0.4f, 0.2f, 0.2f);
    }
    
    private void renderMapFirstPersonSide(final float lllllllllllIIlIllIIIlIlllllIIIll, final EnumHandSide lllllllllllIIlIllIIIlIlllllIllIl, final float lllllllllllIIlIllIIIlIlllllIllII, final ItemStack lllllllllllIIlIllIIIlIlllllIlIll) {
        final float lllllllllllIIlIllIIIlIlllllIlIlI = (lllllllllllIIlIllIIIlIlllllIllIl == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllllIlIlI * 0.125f, -0.125f, 0.0f);
        if (!this.mc.player.isInvisible()) {
            GlStateManager.pushMatrix();
            GlStateManager.rotate(lllllllllllIIlIllIIIlIlllllIlIlI * 10.0f, 0.0f, 0.0f, 1.0f);
            this.renderArmFirstPerson(lllllllllllIIlIllIIIlIlllllIIIll, lllllllllllIIlIllIIIlIlllllIllII, lllllllllllIIlIllIIIlIlllllIllIl);
            GlStateManager.popMatrix();
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllllIlIlI * 0.51f, -0.08f + lllllllllllIIlIllIIIlIlllllIIIll * -1.2f, -0.75f);
        final float lllllllllllIIlIllIIIlIlllllIlIIl = MathHelper.sqrt(lllllllllllIIlIllIIIlIlllllIllII);
        final float lllllllllllIIlIllIIIlIlllllIlIII = MathHelper.sin(lllllllllllIIlIllIIIlIlllllIlIIl * 3.1415927f);
        final float lllllllllllIIlIllIIIlIlllllIIlll = -0.5f * lllllllllllIIlIllIIIlIlllllIlIII;
        final float lllllllllllIIlIllIIIlIlllllIIllI = 0.4f * MathHelper.sin(lllllllllllIIlIllIIIlIlllllIlIIl * 6.2831855f);
        final float lllllllllllIIlIllIIIlIlllllIIlIl = -0.3f * MathHelper.sin(lllllllllllIIlIllIIIlIlllllIllII * 3.1415927f);
        GlStateManager.translate(lllllllllllIIlIllIIIlIlllllIlIlI * lllllllllllIIlIllIIIlIlllllIIlll, lllllllllllIIlIllIIIlIlllllIIllI - 0.3f * lllllllllllIIlIllIIIlIlllllIlIII, lllllllllllIIlIllIIIlIlllllIIlIl);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllllIlIII * -45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIlllllIlIlI * lllllllllllIIlIllIIIlIlllllIlIII * -30.0f, 0.0f, 1.0f, 0.0f);
        this.renderMapFirstPerson(lllllllllllIIlIllIIIlIlllllIlIll);
        GlStateManager.popMatrix();
    }
    
    private void translate() {
        GlStateManager.translate(-0.5f, 0.08f, 0.0f);
        GlStateManager.rotate(20.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(20.0f, 0.0f, 1.0f, 0.0f);
    }
    
    private void setLightmap() {
        final AbstractClientPlayer lllllllllllIIlIllIIIllIIIIlIlIll = this.mc.player;
        int lllllllllllIIlIllIIIllIIIIlIlIlI = this.mc.world.getCombinedLight(new BlockPos(lllllllllllIIlIllIIIllIIIIlIlIll.posX, lllllllllllIIlIllIIIllIIIIlIlIll.posY + lllllllllllIIlIllIIIllIIIIlIlIll.getEyeHeight(), lllllllllllIIlIllIIIllIIIIlIlIll.posZ), 0);
        if (Config.isDynamicLights()) {
            lllllllllllIIlIllIIIllIIIIlIlIlI = DynamicLights.getCombinedLight(this.mc.getRenderViewEntity(), lllllllllllIIlIllIIIllIIIIlIlIlI);
        }
        final float lllllllllllIIlIllIIIllIIIIlIlIIl = (float)(lllllllllllIIlIllIIIllIIIIlIlIlI & 0xFFFF);
        final float lllllllllllIIlIllIIIllIIIIlIlIII = (float)(lllllllllllIIlIllIIIllIIIIlIlIlI >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllIIlIllIIIllIIIIlIlIIl, lllllllllllIIlIllIIIllIIIIlIlIII);
    }
    
    public void renderItemSide(final EntityLivingBase lllllllllllIIlIllIIIllIIIIllllll, final ItemStack lllllllllllIIlIllIIIllIIIIlllllI, final ItemCameraTransforms.TransformType lllllllllllIIlIllIIIllIIIlIIIlIl, final boolean lllllllllllIIlIllIIIllIIIlIIIlII) {
        if (!lllllllllllIIlIllIIIllIIIIlllllI.func_190926_b()) {
            final Item lllllllllllIIlIllIIIllIIIlIIIIll = lllllllllllIIlIllIIIllIIIIlllllI.getItem();
            final Block lllllllllllIIlIllIIIllIIIlIIIIlI = Block.getBlockFromItem(lllllllllllIIlIllIIIllIIIlIIIIll);
            GlStateManager.pushMatrix();
            final boolean lllllllllllIIlIllIIIllIIIlIIIIIl = this.itemRenderer.shouldRenderItemIn3D(lllllllllllIIlIllIIIllIIIIlllllI) && lllllllllllIIlIllIIIllIIIlIIIIlI.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;
            if (lllllllllllIIlIllIIIllIIIlIIIIIl && (!Config.isShaders() || !Shaders.renderItemKeepDepthMask)) {
                GlStateManager.depthMask(false);
            }
            this.itemRenderer.renderItem(lllllllllllIIlIllIIIllIIIIlllllI, lllllllllllIIlIllIIIllIIIIllllll, lllllllllllIIlIllIIIllIIIlIIIlIl, lllllllllllIIlIllIIIllIIIlIIIlII);
            if (lllllllllllIIlIllIIIllIIIlIIIIIl) {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }
    
    static {
        RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
        RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    }
    
    public void renderItemInFirstPerson(final AbstractClientPlayer lllllllllllIIlIllIIIlIlIllIlIlll, final float lllllllllllIIlIllIIIlIlIllIlIllI, final float lllllllllllIIlIllIIIlIlIllIlIlIl, final EnumHand lllllllllllIIlIllIIIlIlIllllIIll, final float lllllllllllIIlIllIIIlIlIllIlIIll, final ItemStack lllllllllllIIlIllIIIlIlIllllIIIl, final float lllllllllllIIlIllIIIlIlIllIlIIIl) {
        if (!Config.isShaders() || !Shaders.isSkipRenderHand(lllllllllllIIlIllIIIlIlIllllIIll)) {
            final boolean lllllllllllIIlIllIIIlIlIlllIllll = lllllllllllIIlIllIIIlIlIllllIIll == EnumHand.MAIN_HAND;
            final EnumHandSide lllllllllllIIlIllIIIlIlIlllIlllI = lllllllllllIIlIllIIIlIlIlllIllll ? lllllllllllIIlIllIIIlIlIllIlIlll.getPrimaryHand() : lllllllllllIIlIllIIIlIlIllIlIlll.getPrimaryHand().opposite();
            GlStateManager.pushMatrix();
            if (lllllllllllIIlIllIIIlIlIllllIIIl.func_190926_b()) {
                if (lllllllllllIIlIllIIIlIlIlllIllll && !lllllllllllIIlIllIIIlIlIllIlIlll.isInvisible()) {
                    this.renderArmFirstPerson(lllllllllllIIlIllIIIlIlIllIlIIIl, lllllllllllIIlIllIIIlIlIllIlIIll, lllllllllllIIlIllIIIlIlIlllIlllI);
                }
            }
            else if (lllllllllllIIlIllIIIlIlIllllIIIl.getItem() instanceof ItemMap) {
                if (lllllllllllIIlIllIIIlIlIlllIllll && this.itemStackOffHand.func_190926_b()) {
                    this.renderMapFirstPerson(lllllllllllIIlIllIIIlIlIllIlIlIl, lllllllllllIIlIllIIIlIlIllIlIIIl, lllllllllllIIlIllIIIlIlIllIlIIll);
                }
                else {
                    this.renderMapFirstPersonSide(lllllllllllIIlIllIIIlIlIllIlIIIl, lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIll, lllllllllllIIlIllIIIlIlIllllIIIl);
                }
            }
            else {
                final boolean lllllllllllIIlIllIIIlIlIlllIllIl = lllllllllllIIlIllIIIlIlIlllIlllI == EnumHandSide.RIGHT;
                if (lllllllllllIIlIllIIIlIlIllIlIlll.isHandActive() && lllllllllllIIlIllIIIlIlIllIlIlll.getItemInUseCount() > 0 && lllllllllllIIlIllIIIlIlIllIlIlll.getActiveHand() == lllllllllllIIlIllIIIlIlIllllIIll) {
                    final int lllllllllllIIlIllIIIlIlIlllIllII = lllllllllllIIlIllIIIlIlIlllIllIl ? 1 : -1;
                    switch ($SWITCH_TABLE$net$minecraft$item$EnumAction()[lllllllllllIIlIllIIIlIlIllllIIIl.getItemUseAction().ordinal()]) {
                        case 1: {
                            this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                            break;
                        }
                        case 2:
                        case 3: {
                            this.transformEatFirstPerson(lllllllllllIIlIllIIIlIlIllIlIllI, lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllllIIIl);
                            this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                            break;
                        }
                        case 4: {
                            this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                            break;
                        }
                        case 5: {
                            this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                            GlStateManager.translate(lllllllllllIIlIllIIIlIlIlllIllII * -0.2785682f, 0.18344387f, 0.15731531f);
                            GlStateManager.rotate(-13.935f, 1.0f, 0.0f, 0.0f);
                            GlStateManager.rotate(lllllllllllIIlIllIIIlIlIlllIllII * 35.3f, 0.0f, 1.0f, 0.0f);
                            GlStateManager.rotate(lllllllllllIIlIllIIIlIlIlllIllII * -9.785f, 0.0f, 0.0f, 1.0f);
                            final float lllllllllllIIlIllIIIlIlIlllIlIll = lllllllllllIIlIllIIIlIlIllllIIIl.getMaxItemUseDuration() - (this.mc.player.getItemInUseCount() - lllllllllllIIlIllIIIlIlIllIlIllI + 1.0f);
                            float lllllllllllIIlIllIIIlIlIlllIlIlI = lllllllllllIIlIllIIIlIlIlllIlIll / 20.0f;
                            lllllllllllIIlIllIIIlIlIlllIlIlI = (lllllllllllIIlIllIIIlIlIlllIlIlI * lllllllllllIIlIllIIIlIlIlllIlIlI + lllllllllllIIlIllIIIlIlIlllIlIlI * 2.0f) / 3.0f;
                            if (lllllllllllIIlIllIIIlIlIlllIlIlI > 1.0f) {
                                lllllllllllIIlIllIIIlIlIlllIlIlI = 1.0f;
                            }
                            if (lllllllllllIIlIllIIIlIlIlllIlIlI > 0.1f) {
                                final float lllllllllllIIlIllIIIlIlIlllIlIIl = MathHelper.sin((lllllllllllIIlIllIIIlIlIlllIlIll - 0.1f) * 1.3f);
                                final float lllllllllllIIlIllIIIlIlIlllIlIII = lllllllllllIIlIllIIIlIlIlllIlIlI - 0.1f;
                                final float lllllllllllIIlIllIIIlIlIlllIIlll = lllllllllllIIlIllIIIlIlIlllIlIIl * lllllllllllIIlIllIIIlIlIlllIlIII;
                                GlStateManager.translate(lllllllllllIIlIllIIIlIlIlllIIlll * 0.0f, lllllllllllIIlIllIIIlIlIlllIIlll * 0.004f, lllllllllllIIlIllIIIlIlIlllIIlll * 0.0f);
                            }
                            GlStateManager.translate(lllllllllllIIlIllIIIlIlIlllIlIlI * 0.0f, lllllllllllIIlIllIIIlIlIlllIlIlI * 0.0f, lllllllllllIIlIllIIIlIlIlllIlIlI * 0.04f);
                            GlStateManager.scale(1.0f, 1.0f, 1.0f + lllllllllllIIlIllIIIlIlIlllIlIlI * 0.2f);
                            GlStateManager.rotate(lllllllllllIIlIllIIIlIlIlllIllII * 45.0f, 0.0f, -1.0f, 0.0f);
                            break;
                        }
                    }
                }
                else {
                    final float lllllllllllIIlIllIIIlIlIlllIIllI = -0.4f * MathHelper.sin(MathHelper.sqrt(lllllllllllIIlIllIIIlIlIllIlIIll) * 3.1415927f);
                    final float lllllllllllIIlIllIIIlIlIlllIIlIl = 0.2f * MathHelper.sin(MathHelper.sqrt(lllllllllllIIlIllIIIlIlIllIlIIll) * 6.2831855f);
                    final float lllllllllllIIlIllIIIlIlIlllIIlII = -0.2f * MathHelper.sin(lllllllllllIIlIllIIIlIlIllIlIIll * 3.1415927f);
                    final int lllllllllllIIlIllIIIlIlIlllIIIll = lllllllllllIIlIllIIIlIlIlllIllIl ? 1 : -1;
                    final float lllllllllllIIlIllIIIlIlIlllIIIlI = 1.0f - (this.prevEquippedProgressMainHand + (this.equippedProgressMainHand - this.prevEquippedProgressMainHand) * lllllllllllIIlIllIIIlIlIllIlIllI);
                    final float lllllllllllIIlIllIIIlIlIlllIIIIl = this.mc.player.getSwingProgress(lllllllllllIIlIllIIIlIlIllIlIllI);
                    final String lllllllllllIIlIllIIIlIlIlllIIIII = SwingAnimations.swordAnim.getCurrentMode();
                    if (Main.featureDirector.getFeatureByClass(SwingAnimations.class).isToggled() && ((this.mc.gameSettings.keyBindAttack.pressed && !SwingAnimations.auraOnly.getBoolValue()) || (Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && KillAura.target != null))) {
                        if (Main.featureDirector.getFeatureByClass(SwingAnimations.class).isToggled() && ((this.mc.gameSettings.keyBindAttack.pressed && !SwingAnimations.auraOnly.getBoolValue()) || (Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && KillAura.target != null))) {
                            if (lllllllllllIIlIllIIIlIlIlllIlllI != (this.mc.gameSettings.mainHand.equals(EnumHandSide.LEFT) ? EnumHandSide.RIGHT : EnumHandSide.LEFT)) {
                                final float lllllllllllIIlIllIIIlIlIllIlllll = lllllllllllIIlIllIIIlIlIlllIIIIl * 0.8f - lllllllllllIIlIllIIIlIlIlllIIIIl * lllllllllllIIlIllIIIlIlIlllIIIIl * 0.8f;
                                if (lllllllllllIIlIllIIIlIlIlllIIIII.equalsIgnoreCase("Rockstar")) {
                                    this.transformFirstPersonItem(lllllllllllIIlIllIIIlIlIlllIIIlI / 3.0f, lllllllllllIIlIllIIIlIlIlllIIIIl);
                                    this.translate();
                                }
                                else if (lllllllllllIIlIllIIIlIlIlllIIIII.equalsIgnoreCase("Spin")) {
                                    this.transformFirstPersonItem(0.0f, 0.0f);
                                    this.translate();
                                    GlStateManager.rotate(this.spin * SwingAnimations.spinSpeed.getNumberValue(), this.spin, 0.0f, this.spin);
                                    ++this.spin;
                                }
                                else if (lllllllllllIIlIllIIIlIlIlllIIIII.equalsIgnoreCase("Fap")) {
                                    GlStateManager.translate(0.96f, -0.02f, -0.71999997f);
                                    GlStateManager.translate(0.0f, -0.0f, 0.0f);
                                    GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
                                    final float lllllllllllIIlIllIIIlIlIllIllllI = MathHelper.sin(0.0f);
                                    final float lllllllllllIIlIllIIIlIlIllIlllIl = MathHelper.sin(MathHelper.sqrt(0.0f) * 3.1415927f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIllllI * -20.0f, 0.0f, 1.0f, 0.0f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIlllIl * -20.0f, 0.0f, 0.0f, 1.0f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIlllIl * -80.0f, 1.0f, 0.0f, 0.0f);
                                    GlStateManager.translate(-0.5f, 0.2f, 0.0f);
                                    GlStateManager.rotate(30.0f, 0.0f, 1.0f, 0.0f);
                                    GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
                                    GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
                                    final int lllllllllllIIlIllIIIlIlIllIlllII = (int)Math.min(255L, ((System.currentTimeMillis() % 255L > 127L) ? Math.abs(Math.abs(System.currentTimeMillis()) % 255L - 255L) : (System.currentTimeMillis() % 255L)) * 2L);
                                    final float lllllllllllIIlIllIIIlIlIllIllIll = (lllllllllllIIlIllIIIlIlIlllIIlIl > 0.5) ? (1.0f - lllllllllllIIlIllIIIlIlIlllIIlIl) : lllllllllllIIlIllIIIlIlIlllIIlIl;
                                    GlStateManager.translate(0.3f, -0.0f, 0.4f);
                                    GlStateManager.rotate(0.0f, 0.0f, 0.0f, 1.0f);
                                    GlStateManager.translate(0.0f, 0.5f, 0.0f);
                                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, -1.0f);
                                    GlStateManager.translate(0.6f, 0.5f, 0.0f);
                                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, -1.0f);
                                    GlStateManager.rotate(-10.0f, 1.0f, 0.0f, -1.0f);
                                    GlStateManager.rotate(-lllllllllllIIlIllIIIlIlIllIllIll * 10.0f, 10.0f, 10.0f, -9.0f);
                                    GlStateManager.rotate(10.0f, -1.0f, 0.0f, 0.0f);
                                    GlStateManager.translate(0.0, 0.0, -0.5);
                                    GlStateManager.rotate(this.mc.player.isSwingInProgress ? (-lllllllllllIIlIllIIIlIlIllIlllII / SwingAnimations.fapSmooth.getNumberValue()) : 1.0f, 1.0f, -0.0f, 1.0f);
                                    GlStateManager.translate(0.0, 0.0, 0.5);
                                }
                                else if (lllllllllllIIlIllIIIlIlIlllIIIII.equalsIgnoreCase("Astolfo")) {
                                    GlStateManager.rotate((float)(System.currentTimeMillis() / 16L * (int)SwingAnimations.spinSpeed.getNumberValue() % 360L), 0.0f, 0.0f, -0.1f);
                                    this.transformFirstPersonItem(0.0f, 0.0f);
                                    this.translate();
                                }
                                else if (lllllllllllIIlIllIIIlIlIlllIIIII.equalsIgnoreCase("Big")) {
                                    GlStateManager.translate(0.56f, -0.52f, -0.71999997f);
                                    GlStateManager.translate(0.0f, 0.0f, 0.0f);
                                    GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
                                    final float lllllllllllIIlIllIIIlIlIllIllIlI = MathHelper.sin(lllllllllllIIlIllIIIlIlIlllIIIIl * lllllllllllIIlIllIIIlIlIlllIIIIl * 3.1415927f);
                                    final float lllllllllllIIlIllIIIlIlIllIllIIl = MathHelper.sin(MathHelper.sqrt(lllllllllllIIlIllIIIlIlIlllIIIIl) * 3.1415927f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIllIlI * -20.0f, 0.0f, 1.0f, 0.0f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIllIIl * -20.0f, 0.0f, 0.0f, 1.0f);
                                    GlStateManager.rotate(lllllllllllIIlIllIIIlIlIllIllIIl * -40.0f, 1.0f, 0.0f, 0.0f);
                                    GlStateManager.scale(0.8f, 0.8f, 0.8f);
                                    GlStateManager.translate(-0.5f, 0.2f, 0.0f);
                                    GlStateManager.rotate(30.0f, 0.0f, 1.0f, 0.0f);
                                    GlStateManager.rotate(-80.0f, 1.0f, 0.0f, 0.0f);
                                    GlStateManager.rotate(60.0f, 0.0f, 1.0f, 0.0f);
                                }
                            }
                            else {
                                GlStateManager.translate(lllllllllllIIlIllIIIlIlIlllIIIll * lllllllllllIIlIllIIIlIlIlllIIllI, lllllllllllIIlIllIIIlIlIlllIIlIl, lllllllllllIIlIllIIIlIlIlllIIlII);
                                this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                                this.transformFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIll);
                            }
                        }
                        else {
                            this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                            this.transformFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIll);
                        }
                    }
                    else {
                        GlStateManager.translate(lllllllllllIIlIllIIIlIlIlllIIIll * lllllllllllIIlIllIIIlIlIlllIIllI, lllllllllllIIlIllIIIlIlIlllIIlIl, lllllllllllIIlIllIIIlIlIlllIIlII);
                        this.transformSideFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIIl);
                        this.transformFirstPerson(lllllllllllIIlIllIIIlIlIlllIlllI, lllllllllllIIlIllIIIlIlIllIlIIll);
                    }
                }
                this.renderItemSide(lllllllllllIIlIllIIIlIlIllIlIlll, lllllllllllIIlIllIIIlIlIllllIIIl, lllllllllllIIlIllIIIlIlIlllIllIl ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !lllllllllllIIlIllIIIlIlIlllIllIl);
            }
            GlStateManager.popMatrix();
        }
    }
    
    private void renderWaterOverlayTexture(final float lllllllllllIIlIllIIIlIlIIllIlIII) {
        if (!Config.isShaders() || Shaders.isUnderwaterOverlay()) {
            this.mc.getTextureManager().bindTexture(ItemRenderer.RES_UNDERWATER_OVERLAY);
            final Tessellator lllllllllllIIlIllIIIlIlIIllIIlll = Tessellator.getInstance();
            final BufferBuilder lllllllllllIIlIllIIIlIlIIllIIllI = lllllllllllIIlIllIIIlIlIIllIIlll.getBuffer();
            final float lllllllllllIIlIllIIIlIlIIllIIlIl = this.mc.player.getBrightness();
            GlStateManager.color(lllllllllllIIlIllIIIlIlIIllIIlIl, lllllllllllIIlIllIIIlIlIIllIIlIl, lllllllllllIIlIllIIIlIlIIllIIlIl, 0.5f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            final float lllllllllllIIlIllIIIlIlIIllIIlII = 4.0f;
            final float lllllllllllIIlIllIIIlIlIIllIIIll = -1.0f;
            final float lllllllllllIIlIllIIIlIlIIllIIIlI = 1.0f;
            final float lllllllllllIIlIllIIIlIlIIllIIIIl = -1.0f;
            final float lllllllllllIIlIllIIIlIlIIllIIIII = 1.0f;
            final float lllllllllllIIlIllIIIlIlIIlIlllll = -0.5f;
            final float lllllllllllIIlIllIIIlIlIIlIllllI = -this.mc.player.rotationYaw / 64.0f;
            final float lllllllllllIIlIllIIIlIlIIlIlllIl = this.mc.player.rotationPitch / 64.0f;
            lllllllllllIIlIllIIIlIlIIllIIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIIlIllIIIlIlIIllIIllI.pos(-1.0, -1.0, -0.5).tex(4.0f + lllllllllllIIlIllIIIlIlIIlIllllI, 4.0f + lllllllllllIIlIllIIIlIlIIlIlllIl).endVertex();
            lllllllllllIIlIllIIIlIlIIllIIllI.pos(1.0, -1.0, -0.5).tex(0.0f + lllllllllllIIlIllIIIlIlIIlIllllI, 4.0f + lllllllllllIIlIllIIIlIlIIlIlllIl).endVertex();
            lllllllllllIIlIllIIIlIlIIllIIllI.pos(1.0, 1.0, -0.5).tex(0.0f + lllllllllllIIlIllIIIlIlIIlIllllI, 0.0f + lllllllllllIIlIllIIIlIlIIlIlllIl).endVertex();
            lllllllllllIIlIllIIIlIlIIllIIllI.pos(-1.0, 1.0, -0.5).tex(4.0f + lllllllllllIIlIllIIIlIlIIlIllllI, 0.0f + lllllllllllIIlIllIIIlIlIIlIlllIl).endVertex();
            lllllllllllIIlIllIIIlIlIIllIIlll.draw();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
        }
    }
    
    private void renderBlockInHand(final TextureAtlasSprite lllllllllllIIlIllIIIlIlIlIIIIIlI) {
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final Tessellator lllllllllllIIlIllIIIlIlIlIIIllll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIlIllIIIlIlIlIIIlllI = lllllllllllIIlIllIIIlIlIlIIIllll.getBuffer();
        final float lllllllllllIIlIllIIIlIlIlIIIllIl = 0.1f;
        GlStateManager.color(0.1f, 0.1f, 0.1f, 0.5f);
        GlStateManager.pushMatrix();
        final float lllllllllllIIlIllIIIlIlIlIIIllII = -1.0f;
        final float lllllllllllIIlIllIIIlIlIlIIIlIll = 1.0f;
        final float lllllllllllIIlIllIIIlIlIlIIIlIlI = -1.0f;
        final float lllllllllllIIlIllIIIlIlIlIIIlIIl = 1.0f;
        final float lllllllllllIIlIllIIIlIlIlIIIlIII = -0.5f;
        final float lllllllllllIIlIllIIIlIlIlIIIIlll = lllllllllllIIlIllIIIlIlIlIIIIIlI.getMinU();
        final float lllllllllllIIlIllIIIlIlIlIIIIllI = lllllllllllIIlIllIIIlIlIlIIIIIlI.getMaxU();
        final float lllllllllllIIlIllIIIlIlIlIIIIlIl = lllllllllllIIlIllIIIlIlIlIIIIIlI.getMinV();
        final float lllllllllllIIlIllIIIlIlIlIIIIlII = lllllllllllIIlIllIIIlIlIlIIIIIlI.getMaxV();
        lllllllllllIIlIllIIIlIlIlIIIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIlIllIIIlIlIlIIIlllI.pos(-1.0, -1.0, -0.5).tex(lllllllllllIIlIllIIIlIlIlIIIIllI, lllllllllllIIlIllIIIlIlIlIIIIlII).endVertex();
        lllllllllllIIlIllIIIlIlIlIIIlllI.pos(1.0, -1.0, -0.5).tex(lllllllllllIIlIllIIIlIlIlIIIIlll, lllllllllllIIlIllIIIlIlIlIIIIlII).endVertex();
        lllllllllllIIlIllIIIlIlIlIIIlllI.pos(1.0, 1.0, -0.5).tex(lllllllllllIIlIllIIIlIlIlIIIIlll, lllllllllllIIlIllIIIlIlIlIIIIlIl).endVertex();
        lllllllllllIIlIllIIIlIlIlIIIlllI.pos(-1.0, 1.0, -0.5).tex(lllllllllllIIlIllIIIlIlIlIIIIllI, lllllllllllIIlIllIIIlIlIlIIIIlIl).endVertex();
        lllllllllllIIlIllIIIlIlIlIIIllll.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private void renderMapFirstPerson(final ItemStack lllllllllllIIlIllIIIlIlllIlllIII) {
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.scale(0.38f, 0.38f, 0.38f);
        GlStateManager.disableLighting();
        this.mc.getTextureManager().bindTexture(ItemRenderer.RES_MAP_BACKGROUND);
        final Tessellator lllllllllllIIlIllIIIlIlllIllIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIlIllIIIlIlllIllIllI = lllllllllllIIlIllIIIlIlllIllIlll.getBuffer();
        GlStateManager.translate(-0.5f, -0.5f, 0.0f);
        GlStateManager.scale(0.0078125f, 0.0078125f, 0.0078125f);
        lllllllllllIIlIllIIIlIlllIllIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIlIllIIIlIlllIllIllI.pos(-7.0, 135.0, 0.0).tex(0.0, 1.0).endVertex();
        lllllllllllIIlIllIIIlIlllIllIllI.pos(135.0, 135.0, 0.0).tex(1.0, 1.0).endVertex();
        lllllllllllIIlIllIIIlIlllIllIllI.pos(135.0, -7.0, 0.0).tex(1.0, 0.0).endVertex();
        lllllllllllIIlIllIIIlIlllIllIllI.pos(-7.0, -7.0, 0.0).tex(0.0, 0.0).endVertex();
        lllllllllllIIlIllIIIlIlllIllIlll.draw();
        final MapData lllllllllllIIlIllIIIlIlllIllIlIl = ReflectorForge.getMapData(Items.FILLED_MAP, lllllllllllIIlIllIIIlIlllIlllIII, (World)this.mc.world);
        if (lllllllllllIIlIllIIIlIlllIllIlIl != null) {
            this.mc.entityRenderer.getMapItemRenderer().renderMap(lllllllllllIIlIllIIIlIlllIllIlIl, false);
        }
        GlStateManager.enableLighting();
    }
    
    private void renderMapFirstPerson(final float lllllllllllIIlIllIIIlIllllIIIllI, final float lllllllllllIIlIllIIIlIllllIIIlIl, final float lllllllllllIIlIllIIIlIllllIIllIl) {
        final float lllllllllllIIlIllIIIlIllllIIllII = MathHelper.sqrt(lllllllllllIIlIllIIIlIllllIIllIl);
        final float lllllllllllIIlIllIIIlIllllIIlIll = -0.2f * MathHelper.sin(lllllllllllIIlIllIIIlIllllIIllIl * 3.1415927f);
        final float lllllllllllIIlIllIIIlIllllIIlIlI = -0.4f * MathHelper.sin(lllllllllllIIlIllIIIlIllllIIllII * 3.1415927f);
        GlStateManager.translate(0.0f, -lllllllllllIIlIllIIIlIllllIIlIll / 2.0f, lllllllllllIIlIllIIIlIllllIIlIlI);
        final float lllllllllllIIlIllIIIlIllllIIlIIl = this.getMapAngleFromPitch(lllllllllllIIlIllIIIlIllllIIIllI);
        GlStateManager.translate(0.0f, 0.04f + lllllllllllIIlIllIIIlIllllIIIlIl * -1.2f + lllllllllllIIlIllIIIlIllllIIlIIl * -0.5f, -0.72f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllllIIlIIl * -85.0f, 1.0f, 0.0f, 0.0f);
        this.renderArms();
        final float lllllllllllIIlIllIIIlIllllIIlIII = MathHelper.sin(lllllllllllIIlIllIIIlIllllIIllII * 3.1415927f);
        GlStateManager.rotate(lllllllllllIIlIllIIIlIllllIIlIII * 20.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        this.renderMapFirstPerson(this.itemStackMainHand);
    }
}
