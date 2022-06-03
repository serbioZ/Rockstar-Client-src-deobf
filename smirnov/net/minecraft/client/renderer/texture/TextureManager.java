// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.util.Iterator;
import shadersmod.client.ShadersTex;
import optifine.CustomGuis;
import optifine.RandomMobs;
import optifine.Config;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public class TextureManager implements ITickable, IResourceManagerReloadListener
{
    private final /* synthetic */ IResourceManager theResourceManager;
    public static final /* synthetic */ ResourceLocation field_194008_a;
    private final /* synthetic */ Map<String, Integer> mapTextureCounters;
    private final /* synthetic */ Map<ResourceLocation, ITextureObject> mapTextureObjects;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<ITickable> listTickables;
    
    public boolean loadTickableTexture(final ResourceLocation llllllllllllIIIlllIIIIllIlIIlIII, final ITickableTextureObject llllllllllllIIIlllIIIIllIlIIIlII) {
        if (this.loadTexture(llllllllllllIIIlllIIIIllIlIIlIII, llllllllllllIIIlllIIIIllIlIIIlII)) {
            this.listTickables.add(llllllllllllIIIlllIIIIllIlIIIlII);
            return true;
        }
        return false;
    }
    
    public TextureManager(final IResourceManager llllllllllllIIIlllIIIIllIlIlIllI) {
        this.mapTextureObjects = (Map<ResourceLocation, ITextureObject>)Maps.newHashMap();
        this.listTickables = (List<ITickable>)Lists.newArrayList();
        this.mapTextureCounters = (Map<String, Integer>)Maps.newHashMap();
        this.theResourceManager = llllllllllllIIIlllIIIIllIlIlIllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        field_194008_a = new ResourceLocation("");
    }
    
    public boolean loadTexture(final ResourceLocation llllllllllllIIIlllIIIIllIIlllIlI, ITextureObject llllllllllllIIIlllIIIIllIIllIIII) {
        boolean llllllllllllIIIlllIIIIllIIlllIII = true;
        try {
            ((ITextureObject)llllllllllllIIIlllIIIIllIIllIIII).loadTexture(this.theResourceManager);
        }
        catch (IOException llllllllllllIIIlllIIIIllIIllIlll) {
            if (llllllllllllIIIlllIIIIllIIlllIlI != TextureManager.field_194008_a) {
                TextureManager.LOGGER.warn("Failed to load texture: {}", (Object)llllllllllllIIIlllIIIIllIIlllIlI, (Object)llllllllllllIIIlllIIIIllIIllIlll);
            }
            llllllllllllIIIlllIIIIllIIllIIII = TextureUtil.MISSING_TEXTURE;
            this.mapTextureObjects.put(llllllllllllIIIlllIIIIllIIlllIlI, (ITextureObject)llllllllllllIIIlllIIIIllIIllIIII);
            llllllllllllIIIlllIIIIllIIlllIII = false;
        }
        catch (Throwable llllllllllllIIIlllIIIIllIIllIllI) {
            final ITextureObject llllllllllllIIIlllIIIIllIIllIlIl = (ITextureObject)llllllllllllIIIlllIIIIllIIllIIII;
            final CrashReport llllllllllllIIIlllIIIIllIIllIlII = CrashReport.makeCrashReport(llllllllllllIIIlllIIIIllIIllIllI, "Registering texture");
            final CrashReportCategory llllllllllllIIIlllIIIIllIIllIIll = llllllllllllIIIlllIIIIllIIllIlII.makeCategory("Resource location being registered");
            llllllllllllIIIlllIIIIllIIllIIll.addCrashSection("Resource location", llllllllllllIIIlllIIIIllIIlllIlI);
            llllllllllllIIIlllIIIIllIIllIIll.setDetail("Texture object class", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return llllllllllllIIIlllIIIIllIIllIlIl.getClass().getName();
                }
            });
            throw new ReportedException(llllllllllllIIIlllIIIIllIIllIlII);
        }
        this.mapTextureObjects.put(llllllllllllIIIlllIIIIllIIlllIlI, (ITextureObject)llllllllllllIIIlllIIIIllIIllIIII);
        return llllllllllllIIIlllIIIIllIIlllIII;
    }
    
    public void deleteTexture(final ResourceLocation llllllllllllIIIlllIIIIllIIIIlIIl) {
        final ITextureObject llllllllllllIIIlllIIIIllIIIIlIII = this.getTexture(llllllllllllIIIlllIIIIllIIIIlIIl);
        if (llllllllllllIIIlllIIIIllIIIIlIII != null) {
            this.mapTextureObjects.remove(llllllllllllIIIlllIIIIllIIIIlIIl);
            TextureUtil.deleteTexture(llllllllllllIIIlllIIIIllIIIIlIII.getGlTextureId());
        }
    }
    
    public void reloadBannerTextures() {
        for (final Map.Entry<ResourceLocation, ITextureObject> llllllllllllIIIlllIIIIlIlllIlIII : this.mapTextureObjects.entrySet()) {
            final ResourceLocation llllllllllllIIIlllIIIIlIlllIIlll = llllllllllllIIIlllIIIIlIlllIlIII.getKey();
            final ITextureObject llllllllllllIIIlllIIIIlIlllIIllI = llllllllllllIIIlllIIIIlIlllIlIII.getValue();
            if (llllllllllllIIIlllIIIIlIlllIIllI instanceof LayeredColorMaskTexture) {
                this.loadTexture(llllllllllllIIIlllIIIIlIlllIIlll, llllllllllllIIIlllIIIIlIlllIIllI);
            }
        }
    }
    
    public ITextureObject getTexture(final ResourceLocation llllllllllllIIIlllIIIIllIIlIIlIl) {
        return this.mapTextureObjects.get(llllllllllllIIIlllIIIIllIIlIIlIl);
    }
    
    @Override
    public void tick() {
        for (final ITickable llllllllllllIIIlllIIIIllIIIlIIIl : this.listTickables) {
            llllllllllllIIIlllIIIIllIIIlIIIl.tick();
        }
    }
    
    public void bindTexture(ResourceLocation llllllllllllIIIlllIIIIllIlIIlllI) {
        if (Config.isRandomMobs()) {
            llllllllllllIIIlllIIIIllIlIIlllI = RandomMobs.getTextureLocation((ResourceLocation)llllllllllllIIIlllIIIIllIlIIlllI);
        }
        if (Config.isCustomGuis()) {
            llllllllllllIIIlllIIIIllIlIIlllI = CustomGuis.getTextureLocation((ResourceLocation)llllllllllllIIIlllIIIIllIlIIlllI);
        }
        ITextureObject llllllllllllIIIlllIIIIllIlIlIIII = this.mapTextureObjects.get(llllllllllllIIIlllIIIIllIlIIlllI);
        if (llllllllllllIIIlllIIIIllIlIlIIII == null) {
            llllllllllllIIIlllIIIIllIlIlIIII = new SimpleTexture((ResourceLocation)llllllllllllIIIlllIIIIllIlIIlllI);
            this.loadTexture((ResourceLocation)llllllllllllIIIlllIIIIllIlIIlllI, llllllllllllIIIlllIIIIllIlIlIIII);
        }
        if (Config.isShaders()) {
            ShadersTex.bindTexture(llllllllllllIIIlllIIIIllIlIlIIII);
        }
        else {
            TextureUtil.bindTexture(llllllllllllIIIlllIIIIllIlIlIIII.getGlTextureId());
        }
    }
    
    public ResourceLocation getDynamicTextureLocation(final String llllllllllllIIIlllIIIIllIIIllllI, DynamicTexture llllllllllllIIIlllIIIIllIIIllIII) {
        if (llllllllllllIIIlllIIIIllIIIllllI.equals("logo")) {
            llllllllllllIIIlllIIIIllIIIllIII = Config.getMojangLogoTexture(llllllllllllIIIlllIIIIllIIIllIII);
        }
        Integer llllllllllllIIIlllIIIIllIIIlllII = this.mapTextureCounters.get(llllllllllllIIIlllIIIIllIIIllllI);
        if (llllllllllllIIIlllIIIIllIIIlllII == null) {
            llllllllllllIIIlllIIIIllIIIlllII = 1;
        }
        else {
            ++llllllllllllIIIlllIIIIllIIIlllII;
        }
        this.mapTextureCounters.put(llllllllllllIIIlllIIIIllIIIllllI, llllllllllllIIIlllIIIIllIIIlllII);
        final ResourceLocation llllllllllllIIIlllIIIIllIIIllIll = new ResourceLocation(String.format("dynamic/%s_%d", llllllllllllIIIlllIIIIllIIIllllI, llllllllllllIIIlllIIIIllIIIlllII));
        this.loadTexture(llllllllllllIIIlllIIIIllIIIllIll, llllllllllllIIIlllIIIIllIIIllIII);
        return llllllllllllIIIlllIIIIllIIIllIll;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllIIIlllIIIIlIllllllIl) {
        Config.dbg("*** Reloading textures ***");
        Config.log("Resource packs: " + Config.getResourcePackNames());
        final Iterator llllllllllllIIIlllIIIIlIllllllII = this.mapTextureObjects.keySet().iterator();
        while (llllllllllllIIIlllIIIIlIllllllII.hasNext()) {
            final ResourceLocation llllllllllllIIIlllIIIIlIlllllIll = llllllllllllIIIlllIIIIlIllllllII.next();
            final String llllllllllllIIIlllIIIIlIlllllIlI = llllllllllllIIIlllIIIIlIlllllIll.getResourcePath();
            if (llllllllllllIIIlllIIIIlIlllllIlI.startsWith("mcpatcher/") || llllllllllllIIIlllIIIIlIlllllIlI.startsWith("optifine/")) {
                final ITextureObject llllllllllllIIIlllIIIIlIlllllIIl = this.mapTextureObjects.get(llllllllllllIIIlllIIIIlIlllllIll);
                if (llllllllllllIIIlllIIIIlIlllllIIl instanceof AbstractTexture) {
                    final AbstractTexture llllllllllllIIIlllIIIIlIlllllIII = (AbstractTexture)llllllllllllIIIlllIIIIlIlllllIIl;
                    llllllllllllIIIlllIIIIlIlllllIII.deleteGlTexture();
                }
                llllllllllllIIIlllIIIIlIllllllII.remove();
            }
        }
        final Iterator<Map.Entry<ResourceLocation, ITextureObject>> llllllllllllIIIlllIIIIlIllllIlll = this.mapTextureObjects.entrySet().iterator();
        while (llllllllllllIIIlllIIIIlIllllIlll.hasNext()) {
            final Map.Entry<ResourceLocation, ITextureObject> llllllllllllIIIlllIIIIlIllllIllI = llllllllllllIIIlllIIIIlIllllIlll.next();
            final ITextureObject llllllllllllIIIlllIIIIlIllllIlIl = llllllllllllIIIlllIIIIlIllllIllI.getValue();
            if (llllllllllllIIIlllIIIIlIllllIlIl == TextureUtil.MISSING_TEXTURE) {
                llllllllllllIIIlllIIIIlIllllIlll.remove();
            }
            else {
                this.loadTexture(llllllllllllIIIlllIIIIlIllllIllI.getKey(), llllllllllllIIIlllIIIIlIllllIlIl);
            }
        }
    }
}
