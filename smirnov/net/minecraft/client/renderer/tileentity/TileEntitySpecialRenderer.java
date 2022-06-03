// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.util.ResourceLocation;
import net.optifine.entity.model.IEntityRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntitySpecialRenderer<T extends TileEntity> implements IEntityRenderer
{
    private /* synthetic */ Class tileEntityClass;
    private /* synthetic */ ResourceLocation locationTextureCustom;
    protected /* synthetic */ TileEntityRendererDispatcher rendererDispatcher;
    
    static {
        DESTROY_STAGES = new ResourceLocation[] { new ResourceLocation("textures/blocks/destroy_stage_0.png"), new ResourceLocation("textures/blocks/destroy_stage_1.png"), new ResourceLocation("textures/blocks/destroy_stage_2.png"), new ResourceLocation("textures/blocks/destroy_stage_3.png"), new ResourceLocation("textures/blocks/destroy_stage_4.png"), new ResourceLocation("textures/blocks/destroy_stage_5.png"), new ResourceLocation("textures/blocks/destroy_stage_6.png"), new ResourceLocation("textures/blocks/destroy_stage_7.png"), new ResourceLocation("textures/blocks/destroy_stage_8.png"), new ResourceLocation("textures/blocks/destroy_stage_9.png") };
    }
    
    public void renderTileEntityFast(final T lllllllllllIIIllIlIIIllIlIlIIllI, final double lllllllllllIIIllIlIIIllIlIlIIlIl, final double lllllllllllIIIllIlIIIllIlIlIIlII, final double lllllllllllIIIllIlIIIllIlIlIIIll, final float lllllllllllIIIllIlIIIllIlIlIIIlI, final int lllllllllllIIIllIlIIIllIlIlIIIIl, final float lllllllllllIIIllIlIIIllIlIlIIIII, final BufferBuilder lllllllllllIIIllIlIIIllIlIIlllll) {
    }
    
    protected void drawNameplate(final T lllllllllllIIIllIlIIIllIlIllIIlI, final String lllllllllllIIIllIlIIIllIlIllllIl, final double lllllllllllIIIllIlIIIllIlIllllII, final double lllllllllllIIIllIlIIIllIlIlIllll, final double lllllllllllIIIllIlIIIllIlIlllIlI, final int lllllllllllIIIllIlIIIllIlIlIllIl) {
        final Entity lllllllllllIIIllIlIIIllIlIlllIII = this.rendererDispatcher.entity;
        final double lllllllllllIIIllIlIIIllIlIllIlll = lllllllllllIIIllIlIIIllIlIllIIlI.getDistanceSq(lllllllllllIIIllIlIIIllIlIlllIII.posX, lllllllllllIIIllIlIIIllIlIlllIII.posY, lllllllllllIIIllIlIIIllIlIlllIII.posZ);
        if (lllllllllllIIIllIlIIIllIlIllIlll <= lllllllllllIIIllIlIIIllIlIlIllIl * lllllllllllIIIllIlIIIllIlIlIllIl) {
            final float lllllllllllIIIllIlIIIllIlIllIllI = this.rendererDispatcher.entityYaw;
            final float lllllllllllIIIllIlIIIllIlIllIlIl = this.rendererDispatcher.entityPitch;
            final boolean lllllllllllIIIllIlIIIllIlIllIlII = false;
            EntityRenderer.drawNameplate(this.getFontRenderer(), lllllllllllIIIllIlIIIllIlIllllIl, (float)lllllllllllIIIllIlIIIllIlIllllII + 0.5f, (float)lllllllllllIIIllIlIIIllIlIlIllll + 1.5f, (float)lllllllllllIIIllIlIIIllIlIlllIlI + 0.5f, 0, lllllllllllIIIllIlIIIllIlIllIllI, lllllllllllIIIllIlIIIllIlIllIlIl, false, false);
        }
    }
    
    protected void setLightmapDisabled(final boolean lllllllllllIIIllIlIIIllIlllIIIll) {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        if (lllllllllllIIIllIlIIIllIlllIIIll) {
            GlStateManager.disableTexture2D();
        }
        else {
            GlStateManager.enableTexture2D();
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    public void func_192841_a(final T lllllllllllIIIllIlIIIllIllllIlII, final double lllllllllllIIIllIlIIIllIllllIIll, final double lllllllllllIIIllIlIIIllIlllIlIIl, final double lllllllllllIIIllIlIIIllIlllIlIII, final float lllllllllllIIIllIlIIIllIllllIIII, final int lllllllllllIIIllIlIIIllIlllIllll, final float lllllllllllIIIllIlIIIllIlllIlllI) {
        final ITextComponent lllllllllllIIIllIlIIIllIlllIllIl = lllllllllllIIIllIlIIIllIllllIlII.getDisplayName();
        if (lllllllllllIIIllIlIIIllIlllIllIl != null && this.rendererDispatcher.cameraHitResult != null && lllllllllllIIIllIlIIIllIllllIlII.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos())) {
            this.setLightmapDisabled(true);
            this.drawNameplate(lllllllllllIIIllIlIIIllIllllIlII, lllllllllllIIIllIlIIIllIlllIllIl.getFormattedText(), lllllllllllIIIllIlIIIllIllllIIll, lllllllllllIIIllIlIIIllIlllIlIIl, lllllllllllIIIllIlIIIllIlllIlIII, 12);
            this.setLightmapDisabled(false);
        }
    }
    
    @Override
    public void setLocationTextureCustom(final ResourceLocation lllllllllllIIIllIlIIIllIlIIIllIl) {
        this.locationTextureCustom = lllllllllllIIIllIlIIIllIlIIIllIl;
    }
    
    @Override
    public Class getEntityClass() {
        return this.tileEntityClass;
    }
    
    public boolean isGlobalRenderer(final T lllllllllllIIIllIlIIIllIllIIllII) {
        return false;
    }
    
    @Override
    public void setEntityClass(final Class lllllllllllIIIllIlIIIllIlIIllIII) {
        this.tileEntityClass = lllllllllllIIIllIlIIIllIlIIllIII;
    }
    
    protected void bindTexture(final ResourceLocation lllllllllllIIIllIlIIIllIllIllllI) {
        final TextureManager lllllllllllIIIllIlIIIllIllIlllIl = this.rendererDispatcher.renderEngine;
        if (lllllllllllIIIllIlIIIllIllIlllIl != null) {
            lllllllllllIIIllIlIIIllIllIlllIl.bindTexture(lllllllllllIIIllIlIIIllIllIllllI);
        }
    }
    
    @Override
    public ResourceLocation getLocationTextureCustom() {
        return this.locationTextureCustom;
    }
    
    public TileEntitySpecialRenderer() {
        this.tileEntityClass = null;
        this.locationTextureCustom = null;
    }
    
    protected World getWorld() {
        return this.rendererDispatcher.worldObj;
    }
    
    public FontRenderer getFontRenderer() {
        return this.rendererDispatcher.getFontRenderer();
    }
    
    public void setRendererDispatcher(final TileEntityRendererDispatcher lllllllllllIIIllIlIIIllIllIlIIll) {
        this.rendererDispatcher = lllllllllllIIIllIlIIIllIllIlIIll;
    }
}
