// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReport;
import optifine.Reflector;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.client.model.ModelShulker;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntitySign;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import javax.annotation.Nullable;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import java.util.Map;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.Tessellator;

public class TileEntityRendererDispatcher
{
    public /* synthetic */ float entityYaw;
    public /* synthetic */ double entityZ;
    private /* synthetic */ Tessellator batchBuffer;
    public /* synthetic */ Entity entity;
    public static /* synthetic */ TileEntityRendererDispatcher instance;
    public static /* synthetic */ double staticPlayerZ;
    public /* synthetic */ float entityPitch;
    public /* synthetic */ TileEntity tileEntityRendered;
    public final /* synthetic */ Map<Class, TileEntitySpecialRenderer> mapSpecialRenderers;
    public /* synthetic */ double entityY;
    public static /* synthetic */ double staticPlayerX;
    public static /* synthetic */ double staticPlayerY;
    public /* synthetic */ World worldObj;
    public /* synthetic */ RayTraceResult cameraHitResult;
    private /* synthetic */ boolean drawingBatch;
    public /* synthetic */ double entityX;
    public /* synthetic */ TextureManager renderEngine;
    public /* synthetic */ FontRenderer fontRenderer;
    
    @Nullable
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRenderer(@Nullable final TileEntity lllllllllllIlllIllIlllIIllIlIIII) {
        return (lllllllllllIlllIllIlllIIllIlIIII == null) ? null : this.getSpecialRendererByClass(lllllllllllIlllIllIlllIIllIlIIII.getClass());
    }
    
    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
    
    public void preDrawBatch() {
        this.batchBuffer.getBuffer().begin(7, DefaultVertexFormats.BLOCK);
        this.drawingBatch = true;
    }
    
    private TileEntityRendererDispatcher() {
        this.mapSpecialRenderers = (Map<Class, TileEntitySpecialRenderer>)Maps.newHashMap();
        this.batchBuffer = new Tessellator(2097152);
        this.drawingBatch = false;
        this.mapSpecialRenderers.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.mapSpecialRenderers.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        this.mapSpecialRenderers.put(TileEntityPiston.class, new TileEntityPistonRenderer());
        this.mapSpecialRenderers.put(TileEntityChest.class, new TileEntityChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnchantmentTable.class, new TileEntityEnchantmentTableRenderer());
        this.mapSpecialRenderers.put(TileEntityEndPortal.class, new TileEntityEndPortalRenderer());
        this.mapSpecialRenderers.put(TileEntityEndGateway.class, new TileEntityEndGatewayRenderer());
        this.mapSpecialRenderers.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
        this.mapSpecialRenderers.put(TileEntitySkull.class, new TileEntitySkullRenderer());
        this.mapSpecialRenderers.put(TileEntityBanner.class, new TileEntityBannerRenderer());
        this.mapSpecialRenderers.put(TileEntityStructure.class, new TileEntityStructureRenderer());
        this.mapSpecialRenderers.put(TileEntityShulkerBox.class, new TileEntityShulkerBoxRenderer(new ModelShulker()));
        this.mapSpecialRenderers.put(TileEntityBed.class, new TileEntityBedRenderer());
        for (final TileEntitySpecialRenderer<?> lllllllllllIlllIllIlllIIlllIIIII : this.mapSpecialRenderers.values()) {
            lllllllllllIlllIllIlllIIlllIIIII.setRendererDispatcher(this);
        }
    }
    
    public void func_192854_a(final TileEntity lllllllllllIlllIllIlllIIIllIlIll, final double lllllllllllIlllIllIlllIIIllIlIlI, final double lllllllllllIlllIllIlllIIIllIlIIl, final double lllllllllllIlllIllIlllIIIlIlllII, final float lllllllllllIlllIllIlllIIIlIllIll, final int lllllllllllIlllIllIlllIIIllIIllI, final float lllllllllllIlllIllIlllIIIllIIlIl) {
        final TileEntitySpecialRenderer<TileEntity> lllllllllllIlllIllIlllIIIllIIlII = this.getSpecialRenderer(lllllllllllIlllIllIlllIIIllIlIll);
        if (lllllllllllIlllIllIlllIIIllIIlII != null) {
            try {
                this.tileEntityRendered = lllllllllllIlllIllIlllIIIllIlIll;
                if (this.drawingBatch && Reflector.callBoolean((Object)lllllllllllIlllIllIlllIIIllIlIll, Reflector.ForgeTileEntity_hasFastRenderer, new Object[0])) {
                    lllllllllllIlllIllIlllIIIllIIlII.renderTileEntityFast(lllllllllllIlllIllIlllIIIllIlIll, lllllllllllIlllIllIlllIIIllIlIlI, lllllllllllIlllIllIlllIIIllIlIIl, lllllllllllIlllIllIlllIIIlIlllII, lllllllllllIlllIllIlllIIIlIllIll, lllllllllllIlllIllIlllIIIllIIllI, lllllllllllIlllIllIlllIIIllIIlIl, this.batchBuffer.getBuffer());
                }
                else {
                    lllllllllllIlllIllIlllIIIllIIlII.func_192841_a(lllllllllllIlllIllIlllIIIllIlIll, lllllllllllIlllIllIlllIIIllIlIlI, lllllllllllIlllIllIlllIIIllIlIIl, lllllllllllIlllIllIlllIIIlIlllII, lllllllllllIlllIllIlllIIIlIllIll, lllllllllllIlllIllIlllIIIllIIllI, lllllllllllIlllIllIlllIIIllIIlIl);
                }
                this.tileEntityRendered = null;
            }
            catch (Throwable lllllllllllIlllIllIlllIIIllIIIll) {
                final CrashReport lllllllllllIlllIllIlllIIIllIIIlI = CrashReport.makeCrashReport(lllllllllllIlllIllIlllIIIllIIIll, "Rendering Block Entity");
                final CrashReportCategory lllllllllllIlllIllIlllIIIllIIIIl = lllllllllllIlllIllIlllIIIllIIIlI.makeCategory("Block Entity Details");
                lllllllllllIlllIllIlllIIIllIlIll.addInfoToCrashReport(lllllllllllIlllIllIlllIIIllIIIIl);
                throw new ReportedException(lllllllllllIlllIllIlllIIIllIIIlI);
            }
        }
    }
    
    public void func_192855_a(final TileEntity lllllllllllIlllIllIlllIIlIIIIlIl, final double lllllllllllIlllIllIlllIIlIIIIlII, final double lllllllllllIlllIllIlllIIIlllllII, final double lllllllllllIlllIllIlllIIIllllIll, final float lllllllllllIlllIllIlllIIIllllIlI, final float lllllllllllIlllIllIlllIIlIIIIIII) {
        this.func_192854_a(lllllllllllIlllIllIlllIIlIIIIlIl, lllllllllllIlllIllIlllIIlIIIIlII, lllllllllllIlllIllIlllIIIlllllII, lllllllllllIlllIllIlllIIIllllIll, lllllllllllIlllIllIlllIIIllllIlI, -1, lllllllllllIlllIllIlllIIlIIIIIII);
    }
    
    static {
        TileEntityRendererDispatcher.instance = new TileEntityRendererDispatcher();
    }
    
    public void drawBatch(final int lllllllllllIlllIllIlllIIIlIIIIll) {
        this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
        if (Minecraft.isAmbientOcclusionEnabled()) {
            GlStateManager.shadeModel(7425);
        }
        else {
            GlStateManager.shadeModel(7424);
        }
        if (lllllllllllIlllIllIlllIIIlIIIIll > 0) {
            this.batchBuffer.getBuffer().sortVertexData(0.0f, 0.0f, 0.0f);
        }
        this.batchBuffer.draw();
        RenderHelper.enableStandardItemLighting();
        this.drawingBatch = false;
    }
    
    public void prepare(final World lllllllllllIlllIllIlllIIllIIIlIl, final TextureManager lllllllllllIlllIllIlllIIlIllllIl, final FontRenderer lllllllllllIlllIllIlllIIllIIIIll, final Entity lllllllllllIlllIllIlllIIllIIIIlI, final RayTraceResult lllllllllllIlllIllIlllIIllIIIIIl, final float lllllllllllIlllIllIlllIIlIlllIIl) {
        if (this.worldObj != lllllllllllIlllIllIlllIIllIIIlIl) {
            this.setWorld(lllllllllllIlllIllIlllIIllIIIlIl);
        }
        this.renderEngine = lllllllllllIlllIllIlllIIlIllllIl;
        this.entity = lllllllllllIlllIllIlllIIllIIIIlI;
        this.fontRenderer = lllllllllllIlllIllIlllIIllIIIIll;
        this.cameraHitResult = lllllllllllIlllIllIlllIIllIIIIIl;
        this.entityYaw = lllllllllllIlllIllIlllIIllIIIIlI.prevRotationYaw + (lllllllllllIlllIllIlllIIllIIIIlI.rotationYaw - lllllllllllIlllIllIlllIIllIIIIlI.prevRotationYaw) * lllllllllllIlllIllIlllIIlIlllIIl;
        this.entityPitch = lllllllllllIlllIllIlllIIllIIIIlI.prevRotationPitch + (lllllllllllIlllIllIlllIIllIIIIlI.rotationPitch - lllllllllllIlllIllIlllIIllIIIIlI.prevRotationPitch) * lllllllllllIlllIllIlllIIlIlllIIl;
        this.entityX = lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosX + (lllllllllllIlllIllIlllIIllIIIIlI.posX - lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosX) * lllllllllllIlllIllIlllIIlIlllIIl;
        this.entityY = lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosY + (lllllllllllIlllIllIlllIIllIIIIlI.posY - lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosY) * lllllllllllIlllIllIlllIIlIlllIIl;
        this.entityZ = lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosZ + (lllllllllllIlllIllIlllIIllIIIIlI.posZ - lllllllllllIlllIllIlllIIllIIIIlI.lastTickPosZ) * lllllllllllIlllIllIlllIIlIlllIIl;
    }
    
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRendererByClass(final Class<? extends TileEntity> lllllllllllIlllIllIlllIIllIlIlIl) {
        TileEntitySpecialRenderer<T> lllllllllllIlllIllIlllIIllIlIlll = this.mapSpecialRenderers.get(lllllllllllIlllIllIlllIIllIlIlIl);
        if (lllllllllllIlllIllIlllIIllIlIlll == null && lllllllllllIlllIllIlllIIllIlIlIl != TileEntity.class) {
            lllllllllllIlllIllIlllIIllIlIlll = (TileEntitySpecialRenderer<T>)this.getSpecialRendererByClass((Class<? extends TileEntity>)lllllllllllIlllIllIlllIIllIlIlIl.getSuperclass());
            this.mapSpecialRenderers.put(lllllllllllIlllIllIlllIIllIlIlIl, lllllllllllIlllIllIlllIIllIlIlll);
        }
        return lllllllllllIlllIllIlllIIllIlIlll;
    }
    
    public void renderTileEntity(final TileEntity lllllllllllIlllIllIlllIIlIlIIllI, final float lllllllllllIlllIllIlllIIlIlIIlIl, final int lllllllllllIlllIllIlllIIlIlIllIl) {
        if (lllllllllllIlllIllIlllIIlIlIIllI.getDistanceSq(this.entityX, this.entityY, this.entityZ) < lllllllllllIlllIllIlllIIlIlIIllI.getMaxRenderDistanceSquared()) {
            RenderHelper.enableStandardItemLighting();
            boolean lllllllllllIlllIllIlllIIlIlIllII = true;
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                lllllllllllIlllIllIlllIIlIlIllII = (!this.drawingBatch || !Reflector.callBoolean((Object)lllllllllllIlllIllIlllIIlIlIIllI, Reflector.ForgeTileEntity_hasFastRenderer, new Object[0]));
            }
            if (lllllllllllIlllIllIlllIIlIlIllII) {
                final int lllllllllllIlllIllIlllIIlIlIlIll = this.worldObj.getCombinedLight(lllllllllllIlllIllIlllIIlIlIIllI.getPos(), 0);
                final int lllllllllllIlllIllIlllIIlIlIlIlI = lllllllllllIlllIllIlllIIlIlIlIll % 65536;
                final int lllllllllllIlllIllIlllIIlIlIlIIl = lllllllllllIlllIllIlllIIlIlIlIll / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllIlllIllIlllIIlIlIlIlI, (float)lllllllllllIlllIllIlllIIlIlIlIIl);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            }
            final BlockPos lllllllllllIlllIllIlllIIlIlIlIII = lllllllllllIlllIllIlllIIlIlIIllI.getPos();
            this.func_192854_a(lllllllllllIlllIllIlllIIlIlIIllI, lllllllllllIlllIllIlllIIlIlIlIII.getX() - TileEntityRendererDispatcher.staticPlayerX, lllllllllllIlllIllIlllIIlIlIlIII.getY() - TileEntityRendererDispatcher.staticPlayerY, lllllllllllIlllIllIlllIIlIlIlIII.getZ() - TileEntityRendererDispatcher.staticPlayerZ, lllllllllllIlllIllIlllIIlIlIIlIl, lllllllllllIlllIllIlllIIlIlIllIl, 1.0f);
        }
    }
    
    public void setWorld(@Nullable final World lllllllllllIlllIllIlllIIIlIlIIIl) {
        this.worldObj = lllllllllllIlllIllIlllIIIlIlIIIl;
        if (lllllllllllIlllIllIlllIIIlIlIIIl == null) {
            this.entity = null;
        }
    }
    
    public void renderTileEntityAt(final TileEntity lllllllllllIlllIllIlllIIlIIllIII, final double lllllllllllIlllIllIlllIIlIIlIIIl, final double lllllllllllIlllIllIlllIIlIIlIIII, final double lllllllllllIlllIllIlllIIlIIIllll, final float lllllllllllIlllIllIlllIIlIIlIlII) {
        this.func_192855_a(lllllllllllIlllIllIlllIIlIIllIII, lllllllllllIlllIllIlllIIlIIlIIIl, lllllllllllIlllIllIlllIIlIIlIIII, lllllllllllIlllIllIlllIIlIIIllll, lllllllllllIlllIllIlllIIlIIlIlII, 1.0f);
    }
}
