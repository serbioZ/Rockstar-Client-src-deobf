// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.storage.MapDecoration;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.world.storage.MapData;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.client.renderer.texture.TextureManager;

public class MapItemRenderer
{
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ Map<String, Instance> loadedMaps;
    private static final /* synthetic */ ResourceLocation TEXTURE_MAP_ICONS;
    
    @Nullable
    public Instance func_191205_a(final String lllllllllllIIllIIlIlllllllIlIIlI) {
        return this.loadedMaps.get(lllllllllllIIllIIlIlllllllIlIIlI);
    }
    
    public MapItemRenderer(final TextureManager lllllllllllIIllIIlIllllllllIlllI) {
        this.loadedMaps = (Map<String, Instance>)Maps.newHashMap();
        this.textureManager = lllllllllllIIllIIlIllllllllIlllI;
    }
    
    private Instance getMapRendererInstance(final MapData lllllllllllIIllIIlIlllllllIlIlll) {
        Instance lllllllllllIIllIIlIlllllllIllIIl = this.loadedMaps.get(lllllllllllIIllIIlIlllllllIlIlll.mapName);
        if (lllllllllllIIllIIlIlllllllIllIIl == null) {
            lllllllllllIIllIIlIlllllllIllIIl = new Instance(lllllllllllIIllIIlIlllllllIlIlll, (Instance)null);
            this.loadedMaps.put(lllllllllllIIllIIlIlllllllIlIlll.mapName, lllllllllllIIllIIlIlllllllIllIIl);
        }
        return lllllllllllIIllIIlIlllllllIllIIl;
    }
    
    @Nullable
    public MapData func_191207_a(@Nullable final Instance lllllllllllIIllIIlIlllllllIIIlIl) {
        return (lllllllllllIIllIIlIlllllllIIIlIl != null) ? lllllllllllIIllIIlIlllllllIIIlIl.mapData : null;
    }
    
    public void updateMapTexture(final MapData lllllllllllIIllIIlIllllllllIlIlI) {
        this.getMapRendererInstance(lllllllllllIIllIIlIllllllllIlIlI).updateMapTexture();
    }
    
    public void clearLoadedMaps() {
        for (final Instance lllllllllllIIllIIlIlllllllIIlIll : this.loadedMaps.values()) {
            this.textureManager.deleteTexture(lllllllllllIIllIIlIlllllllIIlIll.location);
        }
        this.loadedMaps.clear();
    }
    
    public void renderMap(final MapData lllllllllllIIllIIlIllllllllIIIll, final boolean lllllllllllIIllIIlIlllllllIlllll) {
        this.getMapRendererInstance(lllllllllllIIllIIlIllllllllIIIll).render(lllllllllllIIllIIlIlllllllIlllll);
    }
    
    static {
        TEXTURE_MAP_ICONS = new ResourceLocation("textures/map/map_icons.png");
    }
    
    class Instance
    {
        private final /* synthetic */ MapData mapData;
        private final /* synthetic */ ResourceLocation location;
        private final /* synthetic */ int[] mapTextureData;
        private final /* synthetic */ DynamicTexture mapTexture;
        
        private void render(final boolean lllllllllllIlllIIlllIlIIllllIlII) {
            final int lllllllllllIlllIIlllIlIIllllIIll = 0;
            final int lllllllllllIlllIIlllIlIIllllIIlI = 0;
            final Tessellator lllllllllllIlllIIlllIlIIllllIIIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllIlllIIlllIlIIllllIIII = lllllllllllIlllIIlllIlIIllllIIIl.getBuffer();
            final float lllllllllllIlllIIlllIlIIlllIllll = 0.0f;
            MapItemRenderer.this.textureManager.bindTexture(this.location);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            lllllllllllIlllIIlllIlIIllllIIII.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIlllIIlllIlIIllllIIII.pos(0.0, 128.0, -0.009999999776482582).tex(0.0, 1.0).endVertex();
            lllllllllllIlllIIlllIlIIllllIIII.pos(128.0, 128.0, -0.009999999776482582).tex(1.0, 1.0).endVertex();
            lllllllllllIlllIIlllIlIIllllIIII.pos(128.0, 0.0, -0.009999999776482582).tex(1.0, 0.0).endVertex();
            lllllllllllIlllIIlllIlIIllllIIII.pos(0.0, 0.0, -0.009999999776482582).tex(0.0, 0.0).endVertex();
            lllllllllllIlllIIlllIlIIllllIIIl.draw();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            MapItemRenderer.this.textureManager.bindTexture(MapItemRenderer.TEXTURE_MAP_ICONS);
            int lllllllllllIlllIIlllIlIIlllIlllI = 0;
            for (final MapDecoration lllllllllllIlllIIlllIlIIlllIllIl : this.mapData.mapDecorations.values()) {
                if (!lllllllllllIlllIIlllIlIIllllIlII || lllllllllllIlllIIlllIlIIlllIllIl.func_191180_f()) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(0.0f + lllllllllllIlllIIlllIlIIlllIllIl.getX() / 2.0f + 64.0f, 0.0f + lllllllllllIlllIIlllIlIIlllIllIl.getY() / 2.0f + 64.0f, -0.02f);
                    GlStateManager.rotate(lllllllllllIlllIIlllIlIIlllIllIl.getRotation() * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.scale(4.0f, 4.0f, 3.0f);
                    GlStateManager.translate(-0.125f, 0.125f, 0.0f);
                    final byte lllllllllllIlllIIlllIlIIlllIllII = lllllllllllIlllIIlllIlIIlllIllIl.getType();
                    final float lllllllllllIlllIIlllIlIIlllIlIll = (lllllllllllIlllIIlllIlIIlllIllII % 4 + 0) / 4.0f;
                    final float lllllllllllIlllIIlllIlIIlllIlIlI = (lllllllllllIlllIIlllIlIIlllIllII / 4 + 0) / 4.0f;
                    final float lllllllllllIlllIIlllIlIIlllIlIIl = (lllllllllllIlllIIlllIlIIlllIllII % 4 + 1) / 4.0f;
                    final float lllllllllllIlllIIlllIlIIlllIlIII = (lllllllllllIlllIIlllIlIIlllIllII / 4 + 1) / 4.0f;
                    lllllllllllIlllIIlllIlIIllllIIII.begin(7, DefaultVertexFormats.POSITION_TEX);
                    final float lllllllllllIlllIIlllIlIIlllIIlll = -0.001f;
                    lllllllllllIlllIIlllIlIIllllIIII.pos(-1.0, 1.0, lllllllllllIlllIIlllIlIIlllIlllI * -0.001f).tex(lllllllllllIlllIIlllIlIIlllIlIll, lllllllllllIlllIIlllIlIIlllIlIlI).endVertex();
                    lllllllllllIlllIIlllIlIIllllIIII.pos(1.0, 1.0, lllllllllllIlllIIlllIlIIlllIlllI * -0.001f).tex(lllllllllllIlllIIlllIlIIlllIlIIl, lllllllllllIlllIIlllIlIIlllIlIlI).endVertex();
                    lllllllllllIlllIIlllIlIIllllIIII.pos(1.0, -1.0, lllllllllllIlllIIlllIlIIlllIlllI * -0.001f).tex(lllllllllllIlllIIlllIlIIlllIlIIl, lllllllllllIlllIIlllIlIIlllIlIII).endVertex();
                    lllllllllllIlllIIlllIlIIllllIIII.pos(-1.0, -1.0, lllllllllllIlllIIlllIlIIlllIlllI * -0.001f).tex(lllllllllllIlllIIlllIlIIlllIlIll, lllllllllllIlllIIlllIlIIlllIlIII).endVertex();
                    lllllllllllIlllIIlllIlIIllllIIIl.draw();
                    GlStateManager.popMatrix();
                    ++lllllllllllIlllIIlllIlIIlllIlllI;
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, -0.04f);
            GlStateManager.scale(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
        
        private void updateMapTexture() {
            for (int lllllllllllIlllIIlllIlIlIIIIlIlI = 0; lllllllllllIlllIIlllIlIlIIIIlIlI < 16384; ++lllllllllllIlllIIlllIlIlIIIIlIlI) {
                final int lllllllllllIlllIIlllIlIlIIIIlIIl = this.mapData.colors[lllllllllllIlllIIlllIlIlIIIIlIlI] & 0xFF;
                if (lllllllllllIlllIIlllIlIlIIIIlIIl / 4 == 0) {
                    this.mapTextureData[lllllllllllIlllIIlllIlIlIIIIlIlI] = (lllllllllllIlllIIlllIlIlIIIIlIlI + lllllllllllIlllIIlllIlIlIIIIlIlI / 128 & 0x1) * 8 + 16 << 24;
                }
                else {
                    this.mapTextureData[lllllllllllIlllIIlllIlIlIIIIlIlI] = MapColor.COLORS[lllllllllllIlllIIlllIlIlIIIIlIIl / 4].getMapColor(lllllllllllIlllIIlllIlIlIIIIlIIl & 0x3);
                }
            }
            this.mapTexture.updateDynamicTexture();
        }
        
        private Instance(final MapData lllllllllllIlllIIlllIlIlIIIlIlII) {
            this.mapData = lllllllllllIlllIIlllIlIlIIIlIlII;
            this.mapTexture = new DynamicTexture(128, 128);
            this.mapTextureData = this.mapTexture.getTextureData();
            this.location = MapItemRenderer.this.textureManager.getDynamicTextureLocation("map/" + lllllllllllIlllIIlllIlIlIIIlIlII.mapName, this.mapTexture);
            for (int lllllllllllIlllIIlllIlIlIIIlIIll = 0; lllllllllllIlllIIlllIlIlIIIlIIll < this.mapTextureData.length; ++lllllllllllIlllIIlllIlIlIIIlIIll) {
                this.mapTextureData[lllllllllllIlllIIlllIlIlIIIlIIll] = 0;
            }
        }
    }
}
