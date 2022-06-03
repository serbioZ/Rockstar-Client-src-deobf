// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.world.storage.MapData;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.RenderHelper;
import optifine.ReflectorForge;
import net.minecraft.init.Items;
import optifine.Reflector;
import net.minecraft.item.ItemMap;
import net.minecraft.client.renderer.GlStateManager;
import optifine.Config;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.item.EntityItemFrame;

public class RenderItemFrame extends Render<EntityItemFrame>
{
    private final /* synthetic */ RenderItem itemRenderer;
    private final /* synthetic */ ModelResourceLocation mapModel;
    private static final /* synthetic */ ResourceLocation MAP_BACKGROUND_TEXTURES;
    private final /* synthetic */ ModelResourceLocation itemFrameModel;
    private final /* synthetic */ Minecraft mc;
    
    static {
        MAP_BACKGROUND_TEXTURES = new ResourceLocation("textures/map/map_background.png");
    }
    
    private void renderItem(final EntityItemFrame lllllllllllllIlIIllllIlIlIllIIll) {
        final ItemStack lllllllllllllIlIIllllIlIlIlllIll = lllllllllllllIlIIllllIlIlIllIIll.getDisplayedItem();
        if (!lllllllllllllIlIIllllIlIlIlllIll.func_190926_b()) {
            if (!Config.zoomMode) {
                final Entity lllllllllllllIlIIllllIlIlIlllIlI = this.mc.player;
                final double lllllllllllllIlIIllllIlIlIlllIIl = lllllllllllllIlIIllllIlIlIllIIll.getDistanceSq(lllllllllllllIlIIllllIlIlIlllIlI.posX, lllllllllllllIlIIllllIlIlIlllIlI.posY, lllllllllllllIlIIllllIlIlIlllIlI.posZ);
                if (lllllllllllllIlIIllllIlIlIlllIIl > 4096.0) {
                    return;
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            final boolean lllllllllllllIlIIllllIlIlIlllIII = lllllllllllllIlIIllllIlIlIlllIll.getItem() instanceof ItemMap;
            final int lllllllllllllIlIIllllIlIlIllIlll = lllllllllllllIlIIllllIlIlIlllIII ? (lllllllllllllIlIIllllIlIlIllIIll.getRotation() % 4 * 2) : lllllllllllllIlIIllllIlIlIllIIll.getRotation();
            GlStateManager.rotate(lllllllllllllIlIIllllIlIlIllIlll * 360.0f / 8.0f, 0.0f, 0.0f, 1.0f);
            if (!Reflector.postForgeBusEvent(Reflector.RenderItemInFrameEvent_Constructor, new Object[] { lllllllllllllIlIIllllIlIlIllIIll, this })) {
                if (lllllllllllllIlIIllllIlIlIlllIII) {
                    this.renderManager.renderEngine.bindTexture(RenderItemFrame.MAP_BACKGROUND_TEXTURES);
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    final float lllllllllllllIlIIllllIlIlIllIllI = 0.0078125f;
                    GlStateManager.scale(0.0078125f, 0.0078125f, 0.0078125f);
                    GlStateManager.translate(-64.0f, -64.0f, 0.0f);
                    final MapData lllllllllllllIlIIllllIlIlIllIlIl = ReflectorForge.getMapData(Items.FILLED_MAP, lllllllllllllIlIIllllIlIlIlllIll, lllllllllllllIlIIllllIlIlIllIIll.world);
                    GlStateManager.translate(0.0f, 0.0f, -1.0f);
                    if (lllllllllllllIlIIllllIlIlIllIlIl != null) {
                        this.mc.entityRenderer.getMapItemRenderer().renderMap(lllllllllllllIlIIllllIlIlIllIlIl, true);
                    }
                }
                else {
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                    GlStateManager.pushAttrib();
                    RenderHelper.enableStandardItemLighting();
                    this.itemRenderer.renderItem(lllllllllllllIlIIllllIlIlIlllIll, ItemCameraTransforms.TransformType.FIXED);
                    RenderHelper.disableStandardItemLighting();
                    GlStateManager.popAttrib();
                }
            }
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void doRender(final EntityItemFrame lllllllllllllIlIIllllIlIllIlIIIl, final double lllllllllllllIlIIllllIlIllIlllll, final double lllllllllllllIlIIllllIlIllIllllI, final double lllllllllllllIlIIllllIlIllIlllIl, final float lllllllllllllIlIIllllIlIllIlllII, final float lllllllllllllIlIIllllIlIllIllIll) {
        GlStateManager.pushMatrix();
        final BlockPos lllllllllllllIlIIllllIlIllIllIlI = lllllllllllllIlIIllllIlIllIlIIIl.getHangingPosition();
        final double lllllllllllllIlIIllllIlIllIllIIl = lllllllllllllIlIIllllIlIllIllIlI.getX() - lllllllllllllIlIIllllIlIllIlIIIl.posX + lllllllllllllIlIIllllIlIllIlllll;
        final double lllllllllllllIlIIllllIlIllIllIII = lllllllllllllIlIIllllIlIllIllIlI.getY() - lllllllllllllIlIIllllIlIllIlIIIl.posY + lllllllllllllIlIIllllIlIllIllllI;
        final double lllllllllllllIlIIllllIlIllIlIlll = lllllllllllllIlIIllllIlIllIllIlI.getZ() - lllllllllllllIlIIllllIlIllIlIIIl.posZ + lllllllllllllIlIIllllIlIllIlllIl;
        GlStateManager.translate(lllllllllllllIlIIllllIlIllIllIIl + 0.5, lllllllllllllIlIIllllIlIllIllIII + 0.5, lllllllllllllIlIIllllIlIllIlIlll + 0.5);
        GlStateManager.rotate(180.0f - lllllllllllllIlIIllllIlIllIlIIIl.rotationYaw, 0.0f, 1.0f, 0.0f);
        this.renderManager.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final BlockRendererDispatcher lllllllllllllIlIIllllIlIllIlIllI = this.mc.getBlockRendererDispatcher();
        final ModelManager lllllllllllllIlIIllllIlIllIlIlIl = lllllllllllllIlIIllllIlIllIlIllI.getBlockModelShapes().getModelManager();
        IBakedModel lllllllllllllIlIIllllIlIllIlIIll = null;
        if (lllllllllllllIlIIllllIlIllIlIIIl.getDisplayedItem().getItem() instanceof ItemMap) {
            final IBakedModel lllllllllllllIlIIllllIlIllIlIlII = lllllllllllllIlIIllllIlIllIlIlIl.getModel(this.mapModel);
        }
        else {
            lllllllllllllIlIIllllIlIllIlIIll = lllllllllllllIlIIllllIlIllIlIlIl.getModel(this.itemFrameModel);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIlIIllllIlIllIlIIIl));
        }
        lllllllllllllIlIIllllIlIllIlIllI.getBlockModelRenderer().renderModelBrightnessColor(lllllllllllllIlIIllllIlIllIlIIll, 1.0f, 1.0f, 1.0f, 1.0f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.4375f);
        this.renderItem(lllllllllllllIlIIllllIlIllIlIIIl);
        GlStateManager.popMatrix();
        this.renderName(lllllllllllllIlIIllllIlIllIlIIIl, lllllllllllllIlIIllllIlIllIlllll + lllllllllllllIlIIllllIlIllIlIIIl.facingDirection.getFrontOffsetX() * 0.3f, lllllllllllllIlIIllllIlIllIllllI - 0.25, lllllllllllllIlIIllllIlIllIlllIl + lllllllllllllIlIIllllIlIllIlIIIl.facingDirection.getFrontOffsetZ() * 0.3f);
    }
    
    public RenderItemFrame(final RenderManager lllllllllllllIlIIllllIlIlllIllll, final RenderItem lllllllllllllIlIIllllIlIllllIIIl) {
        super(lllllllllllllIlIIllllIlIlllIllll);
        this.mc = Minecraft.getMinecraft();
        this.itemFrameModel = new ModelResourceLocation("item_frame", "normal");
        this.mapModel = new ModelResourceLocation("item_frame", "map");
        this.itemRenderer = lllllllllllllIlIIllllIlIllllIIIl;
    }
    
    @Override
    protected void renderName(final EntityItemFrame lllllllllllllIlIIllllIlIlIlIIlII, final double lllllllllllllIlIIllllIlIlIIllIll, final double lllllllllllllIlIIllllIlIlIIllIlI, final double lllllllllllllIlIIllllIlIlIIllIIl) {
        if (Minecraft.isGuiEnabled() && !lllllllllllllIlIIllllIlIlIlIIlII.getDisplayedItem().func_190926_b() && lllllllllllllIlIIllllIlIlIlIIlII.getDisplayedItem().hasDisplayName() && this.renderManager.pointedEntity == lllllllllllllIlIIllllIlIlIlIIlII) {
            final double lllllllllllllIlIIllllIlIlIlIIIII = lllllllllllllIlIIllllIlIlIlIIlII.getDistanceSqToEntity(this.renderManager.renderViewEntity);
            final float lllllllllllllIlIIllllIlIlIIlllll = lllllllllllllIlIIllllIlIlIlIIlII.isSneaking() ? 32.0f : 64.0f;
            if (lllllllllllllIlIIllllIlIlIlIIIII < lllllllllllllIlIIllllIlIlIIlllll * lllllllllllllIlIIllllIlIlIIlllll) {
                final String lllllllllllllIlIIllllIlIlIIllllI = lllllllllllllIlIIllllIlIlIlIIlII.getDisplayedItem().getDisplayName();
                this.renderLivingLabel(lllllllllllllIlIIllllIlIlIlIIlII, lllllllllllllIlIIllllIlIlIIllllI, lllllllllllllIlIIllllIlIlIIllIll, lllllllllllllIlIIllllIlIlIIllIlI, lllllllllllllIlIIllllIlIlIIllIIl, 64);
            }
        }
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final EntityItemFrame lllllllllllllIlIIllllIlIllIIIlIl) {
        return null;
    }
}
