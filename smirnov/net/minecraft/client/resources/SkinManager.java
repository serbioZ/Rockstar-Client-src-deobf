// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import com.google.common.collect.Multimap;
import com.mojang.authlib.minecraft.InsecureTextureException;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import javax.annotation.Nullable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import com.google.common.cache.CacheLoader;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.CacheBuilder;
import net.minecraft.util.ResourceLocation;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import java.util.concurrent.ExecutorService;
import java.io.File;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import java.util.Map;
import com.mojang.authlib.GameProfile;
import com.google.common.cache.LoadingCache;
import net.minecraft.client.renderer.texture.TextureManager;

public class SkinManager
{
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ LoadingCache<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>> skinCacheLoader;
    private final /* synthetic */ File skinCacheDir;
    private static final /* synthetic */ ExecutorService THREAD_POOL;
    private final /* synthetic */ MinecraftSessionService sessionService;
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture llllllllllIlllIIllIlIlllIIIIIlIl, final MinecraftProfileTexture.Type llllllllllIlllIIllIlIlllIIIIIlll) {
        return this.loadSkin(llllllllllIlllIIllIlIlllIIIIIlIl, llllllllllIlllIIllIlIlllIIIIIlll, null);
    }
    
    public SkinManager(final TextureManager llllllllllIlllIIllIlIlllIIIIllll, final File llllllllllIlllIIllIlIlllIIIIlllI, final MinecraftSessionService llllllllllIlllIIllIlIlllIIIlIIIl) {
        this.textureManager = llllllllllIlllIIllIlIlllIIIIllll;
        this.skinCacheDir = llllllllllIlllIIllIlIlllIIIIlllI;
        this.sessionService = llllllllllIlllIIllIlIlllIIIlIIIl;
        this.skinCacheLoader = (LoadingCache<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>>)CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build((CacheLoader)new CacheLoader<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>>() {
            public Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> load(final GameProfile lllllllllllllIIIllllllllllIlIIIl) throws Exception {
                try {
                    return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Minecraft.getMinecraft().getSessionService().getTextures(lllllllllllllIIIllllllllllIlIIIl, false);
                }
                catch (Throwable lllllllllllllIIIllllllllllIlIIII) {
                    return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Maps.newHashMap();
                }
            }
        });
    }
    
    static {
        THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture llllllllllIlllIIllIlIllIlllllIII, final MinecraftProfileTexture.Type llllllllllIlllIIllIlIllIllllIlll, @Nullable final SkinAvailableCallback llllllllllIlllIIllIlIllIllllIllI) {
        final ResourceLocation llllllllllIlllIIllIlIllIllllIlIl = new ResourceLocation("skins/" + llllllllllIlllIIllIlIllIlllllIII.getHash());
        final ITextureObject llllllllllIlllIIllIlIllIllllIlII = this.textureManager.getTexture(llllllllllIlllIIllIlIllIllllIlIl);
        if (llllllllllIlllIIllIlIllIllllIlII != null) {
            if (llllllllllIlllIIllIlIllIllllIllI != null) {
                llllllllllIlllIIllIlIllIllllIllI.skinAvailable(llllllllllIlllIIllIlIllIllllIlll, llllllllllIlllIIllIlIllIllllIlIl, llllllllllIlllIIllIlIllIlllllIII);
            }
        }
        else {
            final File llllllllllIlllIIllIlIllIllllIIll = new File(this.skinCacheDir, (llllllllllIlllIIllIlIllIlllllIII.getHash().length() > 2) ? llllllllllIlllIIllIlIllIlllllIII.getHash().substring(0, 2) : "xx");
            final File llllllllllIlllIIllIlIllIllllIIlI = new File(llllllllllIlllIIllIlIllIllllIIll, llllllllllIlllIIllIlIllIlllllIII.getHash());
            final IImageBuffer llllllllllIlllIIllIlIllIllllIIIl = (llllllllllIlllIIllIlIllIllllIlll == MinecraftProfileTexture.Type.SKIN) ? new ImageBufferDownload() : null;
            final ThreadDownloadImageData llllllllllIlllIIllIlIllIllllIIII = new ThreadDownloadImageData(llllllllllIlllIIllIlIllIllllIIlI, llllllllllIlllIIllIlIllIlllllIII.getUrl(), DefaultPlayerSkin.getDefaultSkinLegacy(), new IImageBuffer() {
                @Override
                public BufferedImage parseUserSkin(BufferedImage lllllllllllllIIlIIlIlIlIlIlllllI) {
                    if (llllllllllIlllIIllIlIllIllllIIIl != null) {
                        lllllllllllllIIlIIlIlIlIlIlllllI = llllllllllIlllIIllIlIllIllllIIIl.parseUserSkin(lllllllllllllIIlIIlIlIlIlIlllllI);
                    }
                    return lllllllllllllIIlIIlIlIlIlIlllllI;
                }
                
                @Override
                public void skinAvailable() {
                    if (llllllllllIlllIIllIlIllIllllIIIl != null) {
                        llllllllllIlllIIllIlIllIllllIIIl.skinAvailable();
                    }
                    if (llllllllllIlllIIllIlIllIllllIllI != null) {
                        llllllllllIlllIIllIlIllIllllIllI.skinAvailable(llllllllllIlllIIllIlIllIllllIlll, llllllllllIlllIIllIlIllIllllIlIl, llllllllllIlllIIllIlIllIlllllIII);
                    }
                }
            });
            this.textureManager.loadTexture(llllllllllIlllIIllIlIllIllllIlIl, llllllllllIlllIIllIlIllIllllIIII);
        }
        return llllllllllIlllIIllIlIllIllllIlIl;
    }
    
    public void loadProfileTextures(final GameProfile llllllllllIlllIIllIlIllIllIlllII, final SkinAvailableCallback llllllllllIlllIIllIlIllIllIlllll, final boolean llllllllllIlllIIllIlIllIllIllIlI) {
        SkinManager.THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                final Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> lllllllllllllIlIIlIIIIIlIlIlIlII = (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Maps.newHashMap();
                try {
                    lllllllllllllIlIIlIIIIIlIlIlIlII.putAll(SkinManager.this.sessionService.getTextures(llllllllllIlllIIllIlIllIllIlllII, llllllllllIlllIIllIlIllIllIllIlI));
                }
                catch (InsecureTextureException ex) {}
                if (lllllllllllllIlIIlIIIIIlIlIlIlII.isEmpty() && llllllllllIlllIIllIlIllIllIlllII.getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
                    llllllllllIlllIIllIlIllIllIlllII.getProperties().clear();
                    llllllllllIlllIIllIlIllIllIlllII.getProperties().putAll((Multimap)Minecraft.getMinecraft().getProfileProperties());
                    lllllllllllllIlIIlIIIIIlIlIlIlII.putAll(SkinManager.this.sessionService.getTextures(llllllllllIlllIIllIlIllIllIlllII, false));
                }
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        if (lllllllllllllIlIIlIIIIIlIlIlIlII.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            SkinManager.this.loadSkin(lllllllllllllIlIIlIIIIIlIlIlIlII.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN, llllllllllIlllIIllIlIllIllIlllll);
                        }
                        if (lllllllllllllIlIIlIIIIIlIlIlIlII.containsKey(MinecraftProfileTexture.Type.CAPE)) {
                            SkinManager.this.loadSkin(lllllllllllllIlIIlIIIIIlIlIlIlII.get(MinecraftProfileTexture.Type.CAPE), MinecraftProfileTexture.Type.CAPE, llllllllllIlllIIllIlIllIllIlllll);
                        }
                    }
                });
            }
        });
    }
    
    public Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> loadSkinFromCache(final GameProfile llllllllllIlllIIllIlIllIllIlIlII) {
        return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)this.skinCacheLoader.getUnchecked((Object)llllllllllIlllIIllIlIllIllIlIlII);
    }
    
    public interface SkinAvailableCallback
    {
        void skinAvailable(final MinecraftProfileTexture.Type p0, final ResourceLocation p1, final MinecraftProfileTexture p2);
    }
}
