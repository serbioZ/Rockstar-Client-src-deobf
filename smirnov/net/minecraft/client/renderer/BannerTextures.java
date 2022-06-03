// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.util.Iterator;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.LayeredColorMaskTexture;
import net.minecraft.client.Minecraft;
import com.google.common.collect.Lists;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.BannerPattern;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class BannerTextures
{
    public static final /* synthetic */ ResourceLocation BANNER_BASE_TEXTURE;
    
    static {
        BANNER_DESIGNS = new Cache("B", new ResourceLocation("textures/entity/banner_base.png"), "textures/entity/banner/");
        SHIELD_DESIGNS = new Cache("S", new ResourceLocation("textures/entity/shield_base.png"), "textures/entity/shield/");
        SHIELD_BASE_TEXTURE = new ResourceLocation("textures/entity/shield_base_nopattern.png");
        BANNER_BASE_TEXTURE = new ResourceLocation("textures/entity/banner/base.png");
    }
    
    public static class Cache
    {
        private final /* synthetic */ ResourceLocation cacheResourceLocation;
        private final /* synthetic */ String cacheId;
        private final /* synthetic */ String cacheResourceBase;
        private final /* synthetic */ Map<String, CacheEntry> cacheMap;
        
        @Nullable
        public ResourceLocation getResourceLocation(String llllllllllIllllllIIlIIllIIIIIIll, final List<BannerPattern> llllllllllIllllllIIlIIllIIIIlIIl, final List<EnumDyeColor> llllllllllIllllllIIlIIllIIIIIIIl) {
            if (llllllllllIllllllIIlIIllIIIIIIll.isEmpty()) {
                return null;
            }
            llllllllllIllllllIIlIIllIIIIIIll = String.valueOf(this.cacheId) + llllllllllIllllllIIlIIllIIIIIIll;
            CacheEntry llllllllllIllllllIIlIIllIIIIIlll = this.cacheMap.get(llllllllllIllllllIIlIIllIIIIIIll);
            if (llllllllllIllllllIIlIIllIIIIIlll == null) {
                if (this.cacheMap.size() >= 256 && !this.freeCacheSlot()) {
                    return BannerTextures.BANNER_BASE_TEXTURE;
                }
                final List<String> llllllllllIllllllIIlIIllIIIIIllI = (List<String>)Lists.newArrayList();
                for (final BannerPattern llllllllllIllllllIIlIIllIIIIIlIl : llllllllllIllllllIIlIIllIIIIlIIl) {
                    llllllllllIllllllIIlIIllIIIIIllI.add(String.valueOf(this.cacheResourceBase) + llllllllllIllllllIIlIIllIIIIIlIl.func_190997_a() + ".png");
                }
                llllllllllIllllllIIlIIllIIIIIlll = new CacheEntry(null);
                llllllllllIllllllIIlIIllIIIIIlll.textureLocation = new ResourceLocation(llllllllllIllllllIIlIIllIIIIIIll);
                Minecraft.getMinecraft().getTextureManager().loadTexture(llllllllllIllllllIIlIIllIIIIIlll.textureLocation, new LayeredColorMaskTexture(this.cacheResourceLocation, llllllllllIllllllIIlIIllIIIIIllI, llllllllllIllllllIIlIIllIIIIIIIl));
                this.cacheMap.put(llllllllllIllllllIIlIIllIIIIIIll, llllllllllIllllllIIlIIllIIIIIlll);
            }
            llllllllllIllllllIIlIIllIIIIIlll.lastUseMillis = System.currentTimeMillis();
            return llllllllllIllllllIIlIIllIIIIIlll.textureLocation;
        }
        
        public Cache(final String llllllllllIllllllIIlIIllIIIllIlI, final ResourceLocation llllllllllIllllllIIlIIllIIIlIlIl, final String llllllllllIllllllIIlIIllIIIlIlII) {
            this.cacheMap = (Map<String, CacheEntry>)Maps.newLinkedHashMap();
            this.cacheId = llllllllllIllllllIIlIIllIIIllIlI;
            this.cacheResourceLocation = llllllllllIllllllIIlIIllIIIlIlIl;
            this.cacheResourceBase = llllllllllIllllllIIlIIllIIIlIlII;
        }
        
        private boolean freeCacheSlot() {
            final long llllllllllIllllllIIlIIlIllllIllI = System.currentTimeMillis();
            final Iterator<String> llllllllllIllllllIIlIIlIllllIlIl = this.cacheMap.keySet().iterator();
            while (llllllllllIllllllIIlIIlIllllIlIl.hasNext()) {
                final String llllllllllIllllllIIlIIlIllllIlII = llllllllllIllllllIIlIIlIllllIlIl.next();
                final CacheEntry llllllllllIllllllIIlIIlIllllIIll = this.cacheMap.get(llllllllllIllllllIIlIIlIllllIlII);
                if (llllllllllIllllllIIlIIlIllllIllI - llllllllllIllllllIIlIIlIllllIIll.lastUseMillis > 5000L) {
                    Minecraft.getMinecraft().getTextureManager().deleteTexture(llllllllllIllllllIIlIIlIllllIIll.textureLocation);
                    llllllllllIllllllIIlIIlIllllIlIl.remove();
                    return true;
                }
            }
            return this.cacheMap.size() < 256;
        }
    }
    
    static class CacheEntry
    {
        public /* synthetic */ long lastUseMillis;
        public /* synthetic */ ResourceLocation textureLocation;
        
        private CacheEntry() {
        }
    }
}
