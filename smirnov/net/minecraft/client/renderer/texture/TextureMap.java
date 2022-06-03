// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.GlStateManager;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.StitcherException;
import optifine.ReflectorForge;
import optifine.SpriteDependencies;
import java.util.ArrayList;
import optifine.BetterGrass;
import optifine.CustomItems;
import optifine.ConnectedTextures;
import java.util.Set;
import java.awt.Dimension;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Collection;
import java.util.TreeSet;
import net.minecraft.util.math.MathHelper;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nullable;
import optifine.Reflector;
import shadersmod.client.ShadersTex;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;
import optifine.Config;
import optifine.TextureUtils;
import org.apache.logging.log4j.Logger;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public class TextureMap extends AbstractTexture implements ITickableTextureObject
{
    private final /* synthetic */ ITextureMapPopulator iconCreator;
    private final /* synthetic */ String basePath;
    private final /* synthetic */ Map<String, TextureAtlasSprite> mapRegisteredSprites;
    private /* synthetic */ int mipmapLevels;
    private /* synthetic */ int counterIndexInMap;
    public static final /* synthetic */ ResourceLocation LOCATION_BLOCKS_TEXTURE;
    private /* synthetic */ int iconGridSize;
    private /* synthetic */ TextureAtlasSprite[] iconGrid;
    private /* synthetic */ int iconGridCountX;
    public /* synthetic */ int atlasHeight;
    private final /* synthetic */ List<TextureAtlasSprite> listAnimatedSprites;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<String, TextureAtlasSprite> mapUploadedSprites;
    private final /* synthetic */ TextureAtlasSprite missingImage;
    private /* synthetic */ double iconGridSizeV;
    private /* synthetic */ double iconGridSizeU;
    public /* synthetic */ int atlasWidth;
    private /* synthetic */ int iconGridCountY;
    
    private int getMinSpriteSize() {
        int lllllllllllIIllIIllIlIIlllIlIIlI = 1 << this.mipmapLevels;
        if (lllllllllllIIllIIllIlIIlllIlIIlI < 8) {
            lllllllllllIIllIIllIlIIlllIlIIlI = 8;
        }
        return lllllllllllIIllIIllIlIIlllIlIIlI;
    }
    
    private boolean isTerrainAnimationActive(final TextureAtlasSprite lllllllllllIIllIIllIlIlIIIlIIIll) {
        if (lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconWaterStill || lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconWaterFlow) {
            return Config.isAnimatedWater();
        }
        if (lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconLavaStill || lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconLavaFlow) {
            return Config.isAnimatedLava();
        }
        if (lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconFireLayer0 || lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconFireLayer1) {
            return Config.isAnimatedFire();
        }
        if (lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconPortal) {
            return Config.isAnimatedPortal();
        }
        return lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconClock || lllllllllllIIllIIllIlIlIIIlIIIll == TextureUtils.iconCompass || Config.isAnimatedTerrain();
    }
    
    public String getBasePath() {
        return this.basePath;
    }
    
    public boolean generateMipmaps(final IResourceManager lllllllllllIIllIIllIlIlIlIlIIlII, final TextureAtlasSprite lllllllllllIIllIIllIlIlIlIlIIIll) {
        final ResourceLocation lllllllllllIIllIIllIlIlIlIllIIII = this.getResourceLocation(lllllllllllIIllIIllIlIlIlIlIIIll);
        IResource lllllllllllIIllIIllIlIlIlIlIllll = null;
        if (!lllllllllllIIllIIllIlIlIlIlIIIll.hasCustomLoader(lllllllllllIIllIIllIlIlIlIlIIlII, lllllllllllIIllIIllIlIlIlIllIIII)) {
            try {
                lllllllllllIIllIIllIlIlIlIlIllll = lllllllllllIIllIIllIlIlIlIlIIlII.getResource(lllllllllllIIllIIllIlIlIlIllIIII);
                lllllllllllIIllIIllIlIlIlIlIIIll.loadSpriteFrames(lllllllllllIIllIIllIlIlIlIlIllll, this.mipmapLevels + 1);
            }
            catch (RuntimeException lllllllllllIIllIIllIlIlIlIlIlIll) {
                TextureMap.LOGGER.error("Unable to parse metadata from {}", (Object)lllllllllllIIllIIllIlIlIlIllIIII, (Object)lllllllllllIIllIIllIlIlIlIlIlIll);
                final boolean lllllllllllIIllIIllIlIlIlIlIlllI = false;
            }
            catch (IOException lllllllllllIIllIIllIlIlIlIlIlIlI) {
                TextureMap.LOGGER.error("Using missing texture, unable to load {}", (Object)lllllllllllIIllIIllIlIlIlIllIIII, (Object)lllllllllllIIllIIllIlIlIlIlIlIlI);
                final boolean lllllllllllIIllIIllIlIlIlIlIllIl = false;
                final byte lllllllllllIIllIIllIlIlIlIIlllII;
                final boolean lllllllllllIIllIIllIlIlIlIlIlIIl = (lllllllllllIIllIIllIlIlIlIIlllII = (byte)(lllllllllllIIllIIllIlIlIlIlIllIl ? 1 : 0)) != 0;
                return lllllllllllIIllIIllIlIlIlIIlllII != 0;
            }
            finally {
                IOUtils.closeQuietly((Closeable)lllllllllllIIllIIllIlIlIlIlIllll);
            }
            final boolean lllllllllllIIllIIllIlIlIlIlIllII;
            return lllllllllllIIllIIllIlIlIlIlIllII;
        }
        TextureUtils.generateCustomMipmaps(lllllllllllIIllIIllIlIlIlIlIIIll, this.mipmapLevels);
        try {
            lllllllllllIIllIIllIlIlIlIlIIIll.generateMipmaps(this.mipmapLevels);
            return true;
        }
        catch (Throwable lllllllllllIIllIIllIlIlIlIlIlIII) {
            final CrashReport lllllllllllIIllIIllIlIlIlIlIIlll = CrashReport.makeCrashReport(lllllllllllIIllIIllIlIlIlIlIlIII, "Applying mipmap");
            final CrashReportCategory lllllllllllIIllIIllIlIlIlIlIIllI = lllllllllllIIllIIllIlIlIlIlIIlll.makeCategory("Sprite being mipmapped");
            lllllllllllIIllIIllIlIlIlIlIIllI.setDetail("Sprite name", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return lllllllllllIIllIIllIlIlIlIlIIIll.getIconName();
                }
            });
            lllllllllllIIllIIllIlIlIlIlIIllI.setDetail("Sprite size", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return String.valueOf(lllllllllllIIllIIllIlIlIlIlIIIll.getIconWidth()) + " x " + lllllllllllIIllIIllIlIlIlIlIIIll.getIconHeight();
                }
            });
            lllllllllllIIllIIllIlIlIlIlIIllI.setDetail("Sprite frames", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return String.valueOf(lllllllllllIIllIIllIlIlIlIlIIIll.getFrameCount()) + " frames";
                }
            });
            lllllllllllIIllIIllIlIlIlIlIIllI.addCrashSection("Mipmap levels", this.mipmapLevels);
            throw new ReportedException(lllllllllllIIllIIllIlIlIlIlIIlll);
        }
    }
    
    public TextureMap(final String lllllllllllIIllIIllIlIllIIlIllII, final ITextureMapPopulator lllllllllllIIllIIllIlIllIIlIIlll, final boolean lllllllllllIIllIIllIlIllIIlIlIlI) {
        this.iconGrid = null;
        this.iconGridSize = -1;
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGridSizeU = -1.0;
        this.iconGridSizeV = -1.0;
        this.counterIndexInMap = 0;
        this.atlasWidth = 0;
        this.atlasHeight = 0;
        this.listAnimatedSprites = (List<TextureAtlasSprite>)Lists.newArrayList();
        this.mapRegisteredSprites = (Map<String, TextureAtlasSprite>)Maps.newHashMap();
        this.mapUploadedSprites = (Map<String, TextureAtlasSprite>)Maps.newHashMap();
        this.missingImage = new TextureAtlasSprite("missingno");
        this.basePath = lllllllllllIIllIIllIlIllIIlIllII;
        this.iconCreator = lllllllllllIIllIIllIlIllIIlIIlll;
    }
    
    public int getCountRegisteredSprites() {
        return this.counterIndexInMap;
    }
    
    public void setMipmapLevels(final int lllllllllllIIllIIllIlIlIIlIllllI) {
        this.mipmapLevels = lllllllllllIIllIIllIlIlIIlIllllI;
    }
    
    @Override
    public void tick() {
        this.updateAnimations();
    }
    
    private void initMissingImage() {
        final int lllllllllllIIllIIllIlIllIIlIIIIl = this.getMinSpriteSize();
        final int[] lllllllllllIIllIIllIlIllIIlIIIII = this.getMissingImageData(lllllllllllIIllIIllIlIllIIlIIIIl);
        this.missingImage.setIconWidth(lllllllllllIIllIIllIlIllIIlIIIIl);
        this.missingImage.setIconHeight(lllllllllllIIllIIllIlIllIIlIIIIl);
        final int[][] lllllllllllIIllIIllIlIllIIIlllll = new int[this.mipmapLevels + 1][];
        lllllllllllIIllIIllIlIllIIIlllll[0] = lllllllllllIIllIIllIlIllIIlIIIII;
        this.missingImage.setFramesTextureData(Lists.newArrayList((Object[])new int[][][] { lllllllllllIIllIIllIlIllIIIlllll }));
        this.missingImage.setIndexInMap(this.counterIndexInMap++);
    }
    
    public TextureAtlasSprite getMissingSprite() {
        return this.missingImage;
    }
    
    public void updateAnimations() {
        if (Config.isShaders()) {
            ShadersTex.updatingTex = this.getMultiTexID();
        }
        boolean lllllllllllIIllIIllIlIlIIlllllII = false;
        boolean lllllllllllIIllIIllIlIlIIllllIll = false;
        TextureUtil.bindTexture(this.getGlTextureId());
        for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIIllllIlI : this.listAnimatedSprites) {
            if (this.isTerrainAnimationActive(lllllllllllIIllIIllIlIlIIllllIlI)) {
                lllllllllllIIllIIllIlIlIIllllIlI.updateAnimation();
                if (lllllllllllIIllIIllIlIlIIllllIlI.spriteNormal != null) {
                    lllllllllllIIllIIllIlIlIIlllllII = true;
                }
                if (lllllllllllIIllIIllIlIlIIllllIlI.spriteSpecular == null) {
                    continue;
                }
                lllllllllllIIllIIllIlIlIIllllIll = true;
            }
        }
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIIllllIIl : this.listAnimatedSprites) {
                if (this.isTerrainAnimationActive(lllllllllllIIllIIllIlIlIIllllIIl)) {
                    final TextureAtlasSprite lllllllllllIIllIIllIlIlIIllllIII = lllllllllllIIllIIllIlIlIIllllIIl.spriteSingle;
                    if (lllllllllllIIllIIllIlIlIIllllIII == null) {
                        continue;
                    }
                    if (lllllllllllIIllIIllIlIlIIllllIIl == TextureUtils.iconClock || lllllllllllIIllIIllIlIlIIllllIIl == TextureUtils.iconCompass) {
                        lllllllllllIIllIIllIlIlIIllllIII.frameCounter = lllllllllllIIllIIllIlIlIIllllIIl.frameCounter;
                    }
                    lllllllllllIIllIIllIlIlIIllllIIl.bindSpriteTexture();
                    lllllllllllIIllIIllIlIlIIllllIII.updateAnimation();
                }
            }
            TextureUtil.bindTexture(this.getGlTextureId());
        }
        if (Config.isShaders()) {
            if (lllllllllllIIllIIllIlIlIIlllllII) {
                TextureUtil.bindTexture(this.getMultiTexID().norm);
                for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIIlllIlll : this.listAnimatedSprites) {
                    if (lllllllllllIIllIIllIlIlIIlllIlll.spriteNormal != null && this.isTerrainAnimationActive(lllllllllllIIllIIllIlIlIIlllIlll)) {
                        if (lllllllllllIIllIIllIlIlIIlllIlll == TextureUtils.iconClock || lllllllllllIIllIIllIlIlIIlllIlll == TextureUtils.iconCompass) {
                            lllllllllllIIllIIllIlIlIIlllIlll.spriteNormal.frameCounter = lllllllllllIIllIIllIlIlIIlllIlll.frameCounter;
                        }
                        lllllllllllIIllIIllIlIlIIlllIlll.spriteNormal.updateAnimation();
                    }
                }
            }
            if (lllllllllllIIllIIllIlIlIIllllIll) {
                TextureUtil.bindTexture(this.getMultiTexID().spec);
                for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIIlllIllI : this.listAnimatedSprites) {
                    if (lllllllllllIIllIIllIlIlIIlllIllI.spriteSpecular != null && this.isTerrainAnimationActive(lllllllllllIIllIIllIlIlIIlllIllI)) {
                        if (lllllllllllIIllIIllIlIlIIlllIllI == TextureUtils.iconClock || lllllllllllIIllIIllIlIlIIlllIllI == TextureUtils.iconCompass) {
                            lllllllllllIIllIIllIlIlIIlllIllI.spriteNormal.frameCounter = lllllllllllIIllIIllIlIlIIlllIllI.frameCounter;
                        }
                        lllllllllllIIllIIllIlIlIIlllIllI.spriteSpecular.updateAnimation();
                    }
                }
            }
            if (lllllllllllIIllIIllIlIlIIlllllII || lllllllllllIIllIIllIlIlIIllllIll) {
                TextureUtil.bindTexture(this.getGlTextureId());
            }
        }
        if (Config.isShaders()) {
            ShadersTex.updatingTex = null;
        }
    }
    
    public void loadSprites(final IResourceManager lllllllllllIIllIIllIlIllIIIlIIII, final ITextureMapPopulator lllllllllllIIllIIllIlIllIIIIllII) {
        this.mapRegisteredSprites.clear();
        this.counterIndexInMap = 0;
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPre, new Object[] { this });
        lllllllllllIIllIIllIlIllIIIIllII.registerSprites(this);
        if (this.mipmapLevels >= 4) {
            this.mipmapLevels = this.detectMaxMipmapLevel(this.mapRegisteredSprites, lllllllllllIIllIIllIlIllIIIlIIII);
            Config.log("Mipmap levels: " + this.mipmapLevels);
        }
        this.initMissingImage();
        this.deleteGlTexture();
        this.loadTextureAtlas(lllllllllllIIllIIllIlIllIIIlIIII);
    }
    
    public TextureAtlasSprite getAtlasSprite(final String lllllllllllIIllIIllIlIlIlIIIlIII) {
        TextureAtlasSprite lllllllllllIIllIIllIlIlIlIIIIlll = this.mapUploadedSprites.get(lllllllllllIIllIIllIlIlIlIIIlIII);
        if (lllllllllllIIllIIllIlIlIlIIIIlll == null) {
            lllllllllllIIllIIllIlIlIlIIIIlll = this.missingImage;
        }
        return lllllllllllIIllIIllIlIlIlIIIIlll;
    }
    
    public TextureMap(final String lllllllllllIIllIIllIlIllIlIIIlIl) {
        this(lllllllllllIIllIIllIlIllIlIIIlIl, null);
    }
    
    @Nullable
    public TextureAtlasSprite getTextureExtry(final String lllllllllllIIllIIllIlIlIIlIlIlIl) {
        return this.mapRegisteredSprites.get(lllllllllllIIllIIllIlIlIIlIlIlIl);
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllIIllIIllIlIllIIIlIlIl) throws IOException {
        ShadersTex.resManager = lllllllllllIIllIIllIlIllIIIlIlIl;
        if (this.iconCreator != null) {
            this.loadSprites(lllllllllllIIllIIllIlIllIIIlIlIl, this.iconCreator);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LOCATION_MISSING_TEXTURE = new ResourceLocation("missingno");
        LOCATION_BLOCKS_TEXTURE = new ResourceLocation("textures/atlas/blocks.png");
    }
    
    private int detectMinimumSpriteSize(final Map lllllllllllIIllIIllIlIIllllIIlII, final IResourceManager lllllllllllIIllIIllIlIIllllIIIll, final int lllllllllllIIllIIllIlIIlllllllIl) {
        final Map lllllllllllIIllIIllIlIIlllllllII = new HashMap();
        for (final Object lllllllllllIIllIIllIlIIllllllIll : lllllllllllIIllIIllIlIIllllIIlII.entrySet()) {
            final TextureAtlasSprite lllllllllllIIllIIllIlIIllllllIlI = ((Map.Entry)lllllllllllIIllIIllIlIIllllllIll).getValue();
            final ResourceLocation lllllllllllIIllIIllIlIIllllllIIl = new ResourceLocation(lllllllllllIIllIIllIlIIllllllIlI.getIconName());
            final ResourceLocation lllllllllllIIllIIllIlIIllllllIII = this.completeResourceLocation(lllllllllllIIllIIllIlIIllllllIIl);
            if (!lllllllllllIIllIIllIlIIllllllIlI.hasCustomLoader(lllllllllllIIllIIllIlIIllllIIIll, lllllllllllIIllIIllIlIIllllllIIl)) {
                try {
                    final IResource lllllllllllIIllIIllIlIIlllllIlll = lllllllllllIIllIIllIlIIllllIIIll.getResource(lllllllllllIIllIIllIlIIllllllIII);
                    if (lllllllllllIIllIIllIlIIlllllIlll == null) {
                        continue;
                    }
                    final InputStream lllllllllllIIllIIllIlIIlllllIllI = lllllllllllIIllIIllIlIIlllllIlll.getInputStream();
                    if (lllllllllllIIllIIllIlIIlllllIllI == null) {
                        continue;
                    }
                    final Dimension lllllllllllIIllIIllIlIIlllllIlIl = TextureUtils.getImageSize(lllllllllllIIllIIllIlIIlllllIllI, "png");
                    if (lllllllllllIIllIIllIlIIlllllIlIl == null) {
                        continue;
                    }
                    final int lllllllllllIIllIIllIlIIlllllIlII = lllllllllllIIllIIllIlIIlllllIlIl.width;
                    final int lllllllllllIIllIIllIlIIlllllIIll = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllIIllIIllIlIIlllllIlII);
                    if (!lllllllllllIIllIIllIlIIlllllllII.containsKey(lllllllllllIIllIIllIlIIlllllIIll)) {
                        lllllllllllIIllIIllIlIIlllllllII.put(lllllllllllIIllIIllIlIIlllllIIll, 1);
                    }
                    else {
                        final int lllllllllllIIllIIllIlIIlllllIIlI = lllllllllllIIllIIllIlIIlllllllII.get(lllllllllllIIllIIllIlIIlllllIIll);
                        lllllllllllIIllIIllIlIIlllllllII.put(lllllllllllIIllIIllIlIIlllllIIll, lllllllllllIIllIIllIlIIlllllIIlI + 1);
                    }
                }
                catch (Exception ex) {}
            }
        }
        int lllllllllllIIllIIllIlIIlllllIIIl = 0;
        final Set lllllllllllIIllIIllIlIIlllllIIII = lllllllllllIIllIIllIlIIlllllllII.keySet();
        final Set lllllllllllIIllIIllIlIIllllIllll = new TreeSet(lllllllllllIIllIIllIlIIlllllIIII);
        for (final int lllllllllllIIllIIllIlIIllllIlIll : lllllllllllIIllIIllIlIIllllIllll) {
            final int lllllllllllIIllIIllIlIIllllIlllI = lllllllllllIIllIIllIlIIlllllllII.get(lllllllllllIIllIIllIlIIllllIlIll);
            lllllllllllIIllIIllIlIIlllllIIIl += lllllllllllIIllIIllIlIIllllIlllI;
        }
        int lllllllllllIIllIIllIlIIllllIlIlI = 16;
        int lllllllllllIIllIIllIlIIllllIlIIl = 0;
        final int lllllllllllIIllIIllIlIIllllIllIl = lllllllllllIIllIIllIlIIlllllIIIl * lllllllllllIIllIIllIlIIlllllllIl / 100;
        for (final int lllllllllllIIllIIllIlIIllllIIlll : lllllllllllIIllIIllIlIIllllIllll) {
            final int lllllllllllIIllIIllIlIIllllIIllI = lllllllllllIIllIIllIlIIlllllllII.get(lllllllllllIIllIIllIlIIllllIIlll);
            lllllllllllIIllIIllIlIIllllIlIIl += lllllllllllIIllIIllIlIIllllIIllI;
            if (lllllllllllIIllIIllIlIIllllIIlll > lllllllllllIIllIIllIlIIllllIlIlI) {
                lllllllllllIIllIIllIlIIllllIlIlI = lllllllllllIIllIIllIlIIllllIIlll;
            }
            if (lllllllllllIIllIIllIlIIllllIlIIl > lllllllllllIIllIIllIlIIllllIllIl) {
                return lllllllllllIIllIIllIlIIllllIlIlI;
            }
        }
        return lllllllllllIIllIIllIlIIllllIlIlI;
    }
    
    public void loadTextureAtlas(final IResourceManager lllllllllllIIllIIllIlIlIllIIllll) {
        ShadersTex.resManager = lllllllllllIIllIIllIlIlIllIIllll;
        Config.dbg("Multitexture: " + Config.isMultiTexture());
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIllllIllI : this.mapUploadedSprites.values()) {
                lllllllllllIIllIIllIlIlIllllIllI.deleteSpriteTexture();
            }
        }
        ConnectedTextures.updateIcons(this);
        CustomItems.updateIcons(this);
        BetterGrass.updateIcons(this);
        final int lllllllllllIIllIIllIlIlIllllIlIl = TextureUtils.getGLMaximumTextureSize();
        final Stitcher lllllllllllIIllIIllIlIlIllllIlII = new Stitcher(lllllllllllIIllIIllIlIlIllllIlIl, lllllllllllIIllIIllIlIlIllllIlIl, 0, this.mipmapLevels);
        this.mapUploadedSprites.clear();
        this.listAnimatedSprites.clear();
        int lllllllllllIIllIIllIlIlIllllIIll = Integer.MAX_VALUE;
        final int lllllllllllIIllIIllIlIlIllllIIlI = this.getMinSpriteSize();
        this.iconGridSize = lllllllllllIIllIIllIlIlIllllIIlI;
        int lllllllllllIIllIIllIlIlIllllIIIl = 1 << this.mipmapLevels;
        final List<TextureAtlasSprite> lllllllllllIIllIIllIlIlIllllIIII = new ArrayList<TextureAtlasSprite>(this.mapRegisteredSprites.values());
        for (int lllllllllllIIllIIllIlIlIlllIllll = 0; lllllllllllIIllIIllIlIlIlllIllll < lllllllllllIIllIIllIlIlIllllIIII.size(); ++lllllllllllIIllIIllIlIlIlllIllll) {
            final TextureAtlasSprite lllllllllllIIllIIllIlIlIlllIlllI = SpriteDependencies.resolveDependencies((List)lllllllllllIIllIIllIlIlIllllIIII, lllllllllllIIllIIllIlIlIlllIllll, this);
            final ResourceLocation lllllllllllIIllIIllIlIlIlllIllIl = this.getResourceLocation(lllllllllllIIllIIllIlIlIlllIlllI);
            IResource lllllllllllIIllIIllIlIlIlllIllII = null;
            if (lllllllllllIIllIIllIlIlIlllIlllI.getIndexInMap() < 0) {
                lllllllllllIIllIIllIlIlIlllIlllI.setIndexInMap(this.counterIndexInMap++);
            }
            if (lllllllllllIIllIIllIlIlIlllIlllI.hasCustomLoader(lllllllllllIIllIIllIlIlIllIIllll, lllllllllllIIllIIllIlIlIlllIllIl)) {
                if (lllllllllllIIllIIllIlIlIlllIlllI.load(lllllllllllIIllIIllIlIlIllIIllll, lllllllllllIIllIIllIlIlIlllIllIl, lllllllllllIIllIIllIlIIlIllIllIl -> this.mapRegisteredSprites.get(lllllllllllIIllIIllIlIIlIllIllIl.toString()))) {
                    Config.dbg("Custom loader (skipped): " + lllllllllllIIllIIllIlIlIlllIlllI);
                    continue;
                }
                Config.dbg("Custom loader: " + lllllllllllIIllIIllIlIlIlllIlllI);
            }
            else {
                try {
                    final PngSizeInfo lllllllllllIIllIIllIlIlIlllIlIll = PngSizeInfo.makeFromResource(lllllllllllIIllIIllIlIlIllIIllll.getResource(lllllllllllIIllIIllIlIlIlllIllIl));
                    if (Config.isShaders()) {
                        lllllllllllIIllIIllIlIlIlllIllII = ShadersTex.loadResource(lllllllllllIIllIIllIlIlIllIIllll, lllllllllllIIllIIllIlIlIlllIllIl);
                    }
                    else {
                        lllllllllllIIllIIllIlIlIlllIllII = lllllllllllIIllIIllIlIlIllIIllll.getResource(lllllllllllIIllIIllIlIlIlllIllIl);
                    }
                    final boolean lllllllllllIIllIIllIlIlIlllIlIlI = lllllllllllIIllIIllIlIlIlllIllII.getMetadata("animation") != null;
                    lllllllllllIIllIIllIlIlIlllIlllI.loadSprite(lllllllllllIIllIIllIlIlIlllIlIll, lllllllllllIIllIIllIlIlIlllIlIlI);
                }
                catch (RuntimeException lllllllllllIIllIIllIlIlIlllIlIIl) {
                    TextureMap.LOGGER.error("Unable to parse metadata from {}", (Object)lllllllllllIIllIIllIlIlIlllIllIl, (Object)lllllllllllIIllIIllIlIlIlllIlIIl);
                    ReflectorForge.FMLClientHandler_trackBrokenTexture(lllllllllllIIllIIllIlIlIlllIllIl, lllllllllllIIllIIllIlIlIlllIlIIl.getMessage());
                }
                catch (IOException lllllllllllIIllIIllIlIlIlllIlIII) {
                    TextureMap.LOGGER.error("Using missing texture, unable to load " + lllllllllllIIllIIllIlIlIlllIllIl + ", " + lllllllllllIIllIIllIlIlIlllIlIII.getClass().getName());
                    ReflectorForge.FMLClientHandler_trackMissingTexture(lllllllllllIIllIIllIlIlIlllIllIl);
                }
                finally {
                    IOUtils.closeQuietly((Closeable)lllllllllllIIllIIllIlIlIlllIllII);
                }
                IOUtils.closeQuietly((Closeable)lllllllllllIIllIIllIlIlIlllIllII);
            }
            final int lllllllllllIIllIIllIlIlIlllIIlll = lllllllllllIIllIIllIlIlIlllIlllI.getIconWidth();
            final int lllllllllllIIllIIllIlIlIlllIIllI = lllllllllllIIllIIllIlIlIlllIlllI.getIconHeight();
            if (lllllllllllIIllIIllIlIlIlllIIlll >= 1 && lllllllllllIIllIIllIlIlIlllIIllI >= 1) {
                if (lllllllllllIIllIIllIlIlIlllIIlll < lllllllllllIIllIIllIlIlIllllIIlI || this.mipmapLevels > 0) {
                    final int lllllllllllIIllIIllIlIlIlllIIlIl = (this.mipmapLevels > 0) ? TextureUtils.scaleToPowerOfTwo(lllllllllllIIllIIllIlIlIlllIIlll, lllllllllllIIllIIllIlIlIllllIIlI) : TextureUtils.scaleMinTo(lllllllllllIIllIIllIlIlIlllIIlll, lllllllllllIIllIIllIlIlIllllIIlI);
                    if (lllllllllllIIllIIllIlIlIlllIIlIl != lllllllllllIIllIIllIlIlIlllIIlll) {
                        if (!TextureUtils.isPowerOfTwo(lllllllllllIIllIIllIlIlIlllIIlll)) {
                            Config.log("Scaled non power of 2: " + lllllllllllIIllIIllIlIlIlllIlllI.getIconName() + ", " + lllllllllllIIllIIllIlIlIlllIIlll + " -> " + lllllllllllIIllIIllIlIlIlllIIlIl);
                        }
                        else {
                            Config.log("Scaled too small texture: " + lllllllllllIIllIIllIlIlIlllIlllI.getIconName() + ", " + lllllllllllIIllIIllIlIlIlllIIlll + " -> " + lllllllllllIIllIIllIlIlIlllIIlIl);
                        }
                        final int lllllllllllIIllIIllIlIlIlllIIlII = lllllllllllIIllIIllIlIlIlllIIllI * lllllllllllIIllIIllIlIlIlllIIlIl / lllllllllllIIllIIllIlIlIlllIIlll;
                        lllllllllllIIllIIllIlIlIlllIlllI.setIconWidth(lllllllllllIIllIIllIlIlIlllIIlIl);
                        lllllllllllIIllIIllIlIlIlllIlllI.setIconHeight(lllllllllllIIllIIllIlIlIlllIIlII);
                    }
                }
                lllllllllllIIllIIllIlIlIllllIIll = Math.min(lllllllllllIIllIIllIlIlIllllIIll, Math.min(lllllllllllIIllIIllIlIlIlllIlllI.getIconWidth(), lllllllllllIIllIIllIlIlIlllIlllI.getIconHeight()));
                final int lllllllllllIIllIIllIlIlIlllIIIll = Math.min(Integer.lowestOneBit(lllllllllllIIllIIllIlIlIlllIlllI.getIconWidth()), Integer.lowestOneBit(lllllllllllIIllIIllIlIlIlllIlllI.getIconHeight()));
                if (lllllllllllIIllIIllIlIlIlllIIIll < lllllllllllIIllIIllIlIlIllllIIIl) {
                    TextureMap.LOGGER.warn("Texture {} with size {}x{} limits mip level from {} to {}", (Object)lllllllllllIIllIIllIlIlIlllIllIl, (Object)lllllllllllIIllIIllIlIlIlllIlllI.getIconWidth(), (Object)lllllllllllIIllIIllIlIlIlllIlllI.getIconHeight(), (Object)MathHelper.log2(lllllllllllIIllIIllIlIlIllllIIIl), (Object)MathHelper.log2(lllllllllllIIllIIllIlIlIlllIIIll));
                    lllllllllllIIllIIllIlIlIllllIIIl = lllllllllllIIllIIllIlIlIlllIIIll;
                }
                if (this.generateMipmaps(lllllllllllIIllIIllIlIlIllIIllll, lllllllllllIIllIIllIlIlIlllIlllI)) {
                    lllllllllllIIllIIllIlIlIllllIlII.addSprite(lllllllllllIIllIIllIlIlIlllIlllI);
                }
            }
            else {
                Config.warn("Invalid sprite size: " + lllllllllllIIllIIllIlIlIlllIlllI);
            }
        }
        final int lllllllllllIIllIIllIlIlIlllIIIlI = Math.min(lllllllllllIIllIIllIlIlIllllIIll, lllllllllllIIllIIllIlIlIllllIIIl);
        int lllllllllllIIllIIllIlIlIlllIIIIl = MathHelper.log2(lllllllllllIIllIIllIlIlIlllIIIlI);
        if (lllllllllllIIllIIllIlIlIlllIIIIl < 0) {
            lllllllllllIIllIIllIlIlIlllIIIIl = 0;
        }
        if (lllllllllllIIllIIllIlIlIlllIIIIl < this.mipmapLevels) {
            TextureMap.LOGGER.warn("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", (Object)this.basePath, (Object)this.mipmapLevels, (Object)lllllllllllIIllIIllIlIlIlllIIIIl, (Object)lllllllllllIIllIIllIlIlIlllIIIlI);
            this.mipmapLevels = lllllllllllIIllIIllIlIlIlllIIIIl;
        }
        this.missingImage.generateMipmaps(this.mipmapLevels);
        lllllllllllIIllIIllIlIlIllllIlII.addSprite(this.missingImage);
        try {
            lllllllllllIIllIIllIlIlIllllIlII.doStitch();
        }
        catch (StitcherException lllllllllllIIllIIllIlIlIlllIIIII) {
            throw lllllllllllIIllIIllIlIlIlllIIIII;
        }
        TextureMap.LOGGER.info("Created: {}x{} {}-atlas", (Object)lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth(), (Object)lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight(), (Object)this.basePath);
        if (Config.isShaders()) {
            ShadersTex.allocateTextureMap(this.getGlTextureId(), this.mipmapLevels, lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth(), lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight(), lllllllllllIIllIIllIlIlIllllIlII, this);
        }
        else {
            TextureUtil.allocateTextureImpl(this.getGlTextureId(), this.mipmapLevels, lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth(), lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight());
        }
        final Map<String, TextureAtlasSprite> lllllllllllIIllIIllIlIlIllIlllll = (Map<String, TextureAtlasSprite>)Maps.newHashMap((Map)this.mapRegisteredSprites);
        for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIllIllllI : lllllllllllIIllIIllIlIlIllllIlII.getStichSlots()) {
            if (Config.isShaders()) {
                ShadersTex.setIconName(ShadersTex.setSprite(lllllllllllIIllIIllIlIlIllIllllI).getIconName());
            }
            final String lllllllllllIIllIIllIlIlIllIlllIl = lllllllllllIIllIIllIlIlIllIllllI.getIconName();
            lllllllllllIIllIIllIlIlIllIlllll.remove(lllllllllllIIllIIllIlIlIllIlllIl);
            this.mapUploadedSprites.put(lllllllllllIIllIIllIlIlIllIlllIl, lllllllllllIIllIIllIlIlIllIllllI);
            try {
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSubForLoadAtlas(lllllllllllIIllIIllIlIlIllIllllI.getFrameTextureData(0), lllllllllllIIllIIllIlIlIllIllllI.getIconWidth(), lllllllllllIIllIIllIlIlIllIllllI.getIconHeight(), lllllllllllIIllIIllIlIlIllIllllI.getOriginX(), lllllllllllIIllIIllIlIlIllIllllI.getOriginY(), false, false);
                }
                else {
                    TextureUtil.uploadTextureMipmap(lllllllllllIIllIIllIlIlIllIllllI.getFrameTextureData(0), lllllllllllIIllIIllIlIlIllIllllI.getIconWidth(), lllllllllllIIllIIllIlIlIllIllllI.getIconHeight(), lllllllllllIIllIIllIlIlIllIllllI.getOriginX(), lllllllllllIIllIIllIlIlIllIllllI.getOriginY(), false, false);
                }
            }
            catch (Throwable lllllllllllIIllIIllIlIlIllIlllII) {
                final CrashReport lllllllllllIIllIIllIlIlIllIllIll = CrashReport.makeCrashReport(lllllllllllIIllIIllIlIlIllIlllII, "Stitching texture atlas");
                final CrashReportCategory lllllllllllIIllIIllIlIlIllIllIlI = lllllllllllIIllIIllIlIlIllIllIll.makeCategory("Texture being stitched together");
                lllllllllllIIllIIllIlIlIllIllIlI.addCrashSection("Atlas path", this.basePath);
                lllllllllllIIllIIllIlIlIllIllIlI.addCrashSection("Sprite", lllllllllllIIllIIllIlIlIllIllllI);
                throw new ReportedException(lllllllllllIIllIIllIlIlIllIllIll);
            }
            if (lllllllllllIIllIIllIlIlIllIllllI.hasAnimationMetadata()) {
                this.listAnimatedSprites.add(lllllllllllIIllIIllIlIlIllIllllI);
            }
        }
        for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIllIllIIl : lllllllllllIIllIIllIlIlIllIlllll.values()) {
            lllllllllllIIllIIllIlIlIllIllIIl.copyFrom(this.missingImage);
        }
        if (Config.isMultiTexture()) {
            final int lllllllllllIIllIIllIlIlIllIllIII = lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth();
            final int lllllllllllIIllIIllIlIlIllIlIlll = lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight();
            for (final TextureAtlasSprite lllllllllllIIllIIllIlIlIllIlIllI : lllllllllllIIllIIllIlIlIllllIlII.getStichSlots()) {
                lllllllllllIIllIIllIlIlIllIlIllI.sheetWidth = lllllllllllIIllIIllIlIlIllIllIII;
                lllllllllllIIllIIllIlIlIllIlIllI.sheetHeight = lllllllllllIIllIIllIlIlIllIlIlll;
                lllllllllllIIllIIllIlIlIllIlIllI.mipmapLevels = this.mipmapLevels;
                final TextureAtlasSprite lllllllllllIIllIIllIlIlIllIlIlIl = lllllllllllIIllIIllIlIlIllIlIllI.spriteSingle;
                if (lllllllllllIIllIIllIlIlIllIlIlIl != null) {
                    if (lllllllllllIIllIIllIlIlIllIlIlIl.getIconWidth() <= 0) {
                        lllllllllllIIllIIllIlIlIllIlIlIl.setIconWidth(lllllllllllIIllIIllIlIlIllIlIllI.getIconWidth());
                        lllllllllllIIllIIllIlIlIllIlIlIl.setIconHeight(lllllllllllIIllIIllIlIlIllIlIllI.getIconHeight());
                        lllllllllllIIllIIllIlIlIllIlIlIl.initSprite(lllllllllllIIllIIllIlIlIllIlIllI.getIconWidth(), lllllllllllIIllIIllIlIlIllIlIllI.getIconHeight(), 0, 0, false);
                        lllllllllllIIllIIllIlIlIllIlIlIl.clearFramesTextureData();
                        final List<int[][]> lllllllllllIIllIIllIlIlIllIlIlII = lllllllllllIIllIIllIlIlIllIlIllI.getFramesTextureData();
                        lllllllllllIIllIIllIlIlIllIlIlIl.setFramesTextureData(lllllllllllIIllIIllIlIlIllIlIlII);
                        lllllllllllIIllIIllIlIlIllIlIlIl.setAnimationMetadata(lllllllllllIIllIIllIlIlIllIlIllI.getAnimationMetadata());
                    }
                    lllllllllllIIllIIllIlIlIllIlIlIl.sheetWidth = lllllllllllIIllIIllIlIlIllIllIII;
                    lllllllllllIIllIIllIlIlIllIlIlIl.sheetHeight = lllllllllllIIllIIllIlIlIllIlIlll;
                    lllllllllllIIllIIllIlIlIllIlIlIl.mipmapLevels = this.mipmapLevels;
                    lllllllllllIIllIIllIlIlIllIlIllI.bindSpriteTexture();
                    final boolean lllllllllllIIllIIllIlIlIllIlIIll = false;
                    final boolean lllllllllllIIllIIllIlIlIllIlIIlI = true;
                    try {
                        TextureUtil.uploadTextureMipmap(lllllllllllIIllIIllIlIlIllIlIlIl.getFrameTextureData(0), lllllllllllIIllIIllIlIlIllIlIlIl.getIconWidth(), lllllllllllIIllIIllIlIlIllIlIlIl.getIconHeight(), lllllllllllIIllIIllIlIlIllIlIlIl.getOriginX(), lllllllllllIIllIIllIlIlIllIlIlIl.getOriginY(), lllllllllllIIllIIllIlIlIllIlIIll, lllllllllllIIllIIllIlIlIllIlIIlI);
                    }
                    catch (Exception lllllllllllIIllIIllIlIlIllIlIIIl) {
                        Config.dbg("Error uploading sprite single: " + lllllllllllIIllIIllIlIlIllIlIlIl + ", parent: " + lllllllllllIIllIIllIlIlIllIlIllI);
                        lllllllllllIIllIIllIlIlIllIlIIIl.printStackTrace();
                    }
                }
            }
            Config.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        }
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPost, new Object[] { this });
        this.updateIconGrid(lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth(), lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight());
        if (Config.equals((Object)System.getProperty("saveTextureMap"), (Object)"true")) {
            Config.dbg("Exporting texture map: " + this.basePath);
            TextureUtils.saveGlTexture("debug/" + this.basePath.replaceAll("/", "_"), this.getGlTextureId(), this.mipmapLevels, lllllllllllIIllIIllIlIlIllllIlII.getCurrentWidth(), lllllllllllIIllIIllIlIlIllllIlII.getCurrentHeight());
        }
    }
    
    private boolean isAbsoluteLocation(final ResourceLocation lllllllllllIIllIIllIlIlIIlIIIIIl) {
        final String lllllllllllIIllIIllIlIlIIlIIIIII = lllllllllllIIllIIllIlIlIIlIIIIIl.getResourcePath();
        return this.isAbsoluteLocationPath(lllllllllllIIllIIllIlIlIIlIIIIII);
    }
    
    public ResourceLocation completeResourceLocation(final ResourceLocation lllllllllllIIllIIllIlIlIlIIIllll) {
        return this.isAbsoluteLocation(lllllllllllIIllIIllIlIlIlIIIllll) ? new ResourceLocation(lllllllllllIIllIIllIlIlIlIIIllll.getResourceDomain(), String.valueOf(lllllllllllIIllIIllIlIlIlIIIllll.getResourcePath()) + ".png") : new ResourceLocation(lllllllllllIIllIIllIlIlIlIIIllll.getResourceDomain(), String.format("%s/%s%s", this.basePath, lllllllllllIIllIIllIlIlIlIIIllll.getResourcePath(), ".png"));
    }
    
    private int detectMaxMipmapLevel(final Map lllllllllllIIllIIllIlIlIIIIllIIl, final IResourceManager lllllllllllIIllIIllIlIlIIIIllIII) {
        int lllllllllllIIllIIllIlIlIIIIlIlll = this.detectMinimumSpriteSize(lllllllllllIIllIIllIlIlIIIIllIIl, lllllllllllIIllIIllIlIlIIIIllIII, 20);
        if (lllllllllllIIllIIllIlIlIIIIlIlll < 16) {
            lllllllllllIIllIIllIlIlIIIIlIlll = 16;
        }
        lllllllllllIIllIIllIlIlIIIIlIlll = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllIIllIIllIlIlIIIIlIlll);
        if (lllllllllllIIllIIllIlIlIIIIlIlll > 16) {
            Config.log("Sprite size: " + lllllllllllIIllIIllIlIlIIIIlIlll);
        }
        int lllllllllllIIllIIllIlIlIIIIlIllI = MathHelper.log2(lllllllllllIIllIIllIlIlIIIIlIlll);
        if (lllllllllllIIllIIllIlIlIIIIlIllI < 4) {
            lllllllllllIIllIIllIlIlIIIIlIllI = 4;
        }
        return lllllllllllIIllIIllIlIlIIIIlIllI;
    }
    
    private int[] getMissingImageData(final int lllllllllllIIllIIllIlIIlllIIlIlI) {
        final BufferedImage lllllllllllIIllIIllIlIIlllIIlIIl = new BufferedImage(16, 16, 2);
        lllllllllllIIllIIllIlIIlllIIlIIl.setRGB(0, 0, 16, 16, TextureUtil.MISSING_TEXTURE_DATA, 0, 16);
        final BufferedImage lllllllllllIIllIIllIlIIlllIIlIII = TextureUtils.scaleToPowerOfTwo(lllllllllllIIllIIllIlIIlllIIlIIl, lllllllllllIIllIIllIlIIlllIIlIlI);
        final int[] lllllllllllIIllIIllIlIIlllIIIlll = new int[lllllllllllIIllIIllIlIIlllIIlIlI * lllllllllllIIllIIllIlIIlllIIlIlI];
        lllllllllllIIllIIllIlIIlllIIlIII.getRGB(0, 0, lllllllllllIIllIIllIlIIlllIIlIlI, lllllllllllIIllIIllIlIIlllIIlIlI, lllllllllllIIllIIllIlIIlllIIIlll, 0, lllllllllllIIllIIllIlIIlllIIlIlI);
        return lllllllllllIIllIIllIlIIlllIIIlll;
    }
    
    public boolean setTextureEntry(final TextureAtlasSprite lllllllllllIIllIIllIlIlIIlIlIIII) {
        final String lllllllllllIIllIIllIlIlIIlIIllll = lllllllllllIIllIIllIlIlIIlIlIIII.getIconName();
        if (!this.mapRegisteredSprites.containsKey(lllllllllllIIllIIllIlIlIIlIIllll)) {
            this.mapRegisteredSprites.put(lllllllllllIIllIIllIlIlIIlIIllll, lllllllllllIIllIIllIlIlIIlIlIIII);
            if (lllllllllllIIllIIllIlIlIIlIlIIII.getIndexInMap() < 0) {
                lllllllllllIIllIIllIlIlIIlIlIIII.setIndexInMap(this.counterIndexInMap++);
            }
            return true;
        }
        return false;
    }
    
    public TextureAtlasSprite getSpriteSafe(final String lllllllllllIIllIIllIlIlIIIllIIIl) {
        final ResourceLocation lllllllllllIIllIIllIlIlIIIllIIII = new ResourceLocation(lllllllllllIIllIIllIlIlIIIllIIIl);
        return this.mapRegisteredSprites.get(lllllllllllIIllIIllIlIlIIIllIIII.toString());
    }
    
    public int getMipmapLevels() {
        return this.mipmapLevels;
    }
    
    public boolean isTextureBound() {
        final int lllllllllllIIllIIllIlIIllIlllllI = GlStateManager.getBoundTexture();
        final int lllllllllllIIllIIllIlIIllIllllIl = this.getGlTextureId();
        return lllllllllllIIllIIllIlIIllIlllllI == lllllllllllIIllIIllIlIIllIllllIl;
    }
    
    public TextureMap(final String lllllllllllIIllIIllIlIllIIlllllI, final boolean lllllllllllIIllIIllIlIllIIllllIl) {
        this(lllllllllllIIllIIllIlIllIIlllllI, null, lllllllllllIIllIIllIlIllIIllllIl);
    }
    
    public TextureMap(final String lllllllllllIIllIIllIlIllIIllIlIl, @Nullable final ITextureMapPopulator lllllllllllIIllIIllIlIllIIllIlII) {
        this(lllllllllllIIllIIllIlIllIIllIlIl, lllllllllllIIllIIllIlIllIIllIlII, false);
    }
    
    private boolean isAbsoluteLocationPath(final String lllllllllllIIllIIllIlIlIIIllIlll) {
        final String lllllllllllIIllIIllIlIlIIIlllIII = lllllllllllIIllIIllIlIlIIIllIlll.toLowerCase();
        return lllllllllllIIllIIllIlIlIIIlllIII.startsWith("mcpatcher/") || lllllllllllIIllIIllIlIlIIIlllIII.startsWith("optifine/");
    }
    
    public TextureAtlasSprite registerSprite(final ResourceLocation lllllllllllIIllIIllIlIlIIllIlIll) {
        if (lllllllllllIIllIIllIlIlIIllIlIll == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        TextureAtlasSprite lllllllllllIIllIIllIlIlIIllIlIlI = this.mapRegisteredSprites.get(lllllllllllIIllIIllIlIlIIllIlIll.toString());
        if (lllllllllllIIllIIllIlIlIIllIlIlI == null) {
            lllllllllllIIllIIllIlIlIIllIlIlI = TextureAtlasSprite.makeAtlasSprite(lllllllllllIIllIIllIlIlIIllIlIll);
            this.mapRegisteredSprites.put(lllllllllllIIllIIllIlIlIIllIlIll.toString(), lllllllllllIIllIIllIlIlIIllIlIlI);
            if (lllllllllllIIllIIllIlIlIIllIlIlI.getIndexInMap() < 0) {
                lllllllllllIIllIIllIlIlIIllIlIlI.setIndexInMap(this.counterIndexInMap++);
            }
        }
        return lllllllllllIIllIIllIlIlIIllIlIlI;
    }
    
    public ResourceLocation getResourceLocation(final TextureAtlasSprite lllllllllllIIllIIllIlIlIlIIlIlll) {
        final ResourceLocation lllllllllllIIllIIllIlIlIlIIlIllI = new ResourceLocation(lllllllllllIIllIIllIlIlIlIIlIlll.getIconName());
        return this.completeResourceLocation(lllllllllllIIllIIllIlIlIlIIlIllI);
    }
    
    public TextureAtlasSprite getRegisteredSprite(final ResourceLocation lllllllllllIIllIIllIlIlIIIlIlIIl) {
        return this.mapRegisteredSprites.get(lllllllllllIIllIIllIlIlIIIlIlIIl.toString());
    }
    
    private void updateIconGrid(final int lllllllllllIIllIIllIlIIllIlIIllI, final int lllllllllllIIllIIllIlIIllIlIIlIl) {
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGrid = null;
        if (this.iconGridSize > 0) {
            this.iconGridCountX = lllllllllllIIllIIllIlIIllIlIIllI / this.iconGridSize;
            this.iconGridCountY = lllllllllllIIllIIllIlIIllIlIIlIl / this.iconGridSize;
            this.iconGrid = new TextureAtlasSprite[this.iconGridCountX * this.iconGridCountY];
            this.iconGridSizeU = 1.0 / this.iconGridCountX;
            this.iconGridSizeV = 1.0 / this.iconGridCountY;
            for (final TextureAtlasSprite lllllllllllIIllIIllIlIIllIlIIlII : this.mapUploadedSprites.values()) {
                final double lllllllllllIIllIIllIlIIllIlIIIll = 0.5 / lllllllllllIIllIIllIlIIllIlIIllI;
                final double lllllllllllIIllIIllIlIIllIlIIIlI = 0.5 / lllllllllllIIllIIllIlIIllIlIIlIl;
                final double lllllllllllIIllIIllIlIIllIlIIIIl = Math.min(lllllllllllIIllIIllIlIIllIlIIlII.getMinU(), lllllllllllIIllIIllIlIIllIlIIlII.getMaxU()) + lllllllllllIIllIIllIlIIllIlIIIll;
                final double lllllllllllIIllIIllIlIIllIlIIIII = Math.min(lllllllllllIIllIIllIlIIllIlIIlII.getMinV(), lllllllllllIIllIIllIlIIllIlIIlII.getMaxV()) + lllllllllllIIllIIllIlIIllIlIIIlI;
                final double lllllllllllIIllIIllIlIIllIIlllll = Math.max(lllllllllllIIllIIllIlIIllIlIIlII.getMinU(), lllllllllllIIllIIllIlIIllIlIIlII.getMaxU()) - lllllllllllIIllIIllIlIIllIlIIIll;
                final double lllllllllllIIllIIllIlIIllIIllllI = Math.max(lllllllllllIIllIIllIlIIllIlIIlII.getMinV(), lllllllllllIIllIIllIlIIllIlIIlII.getMaxV()) - lllllllllllIIllIIllIlIIllIlIIIlI;
                final int lllllllllllIIllIIllIlIIllIIlllIl = (int)(lllllllllllIIllIIllIlIIllIlIIIIl / this.iconGridSizeU);
                final int lllllllllllIIllIIllIlIIllIIlllII = (int)(lllllllllllIIllIIllIlIIllIlIIIII / this.iconGridSizeV);
                final int lllllllllllIIllIIllIlIIllIIllIll = (int)(lllllllllllIIllIIllIlIIllIIlllll / this.iconGridSizeU);
                final int lllllllllllIIllIIllIlIIllIIllIlI = (int)(lllllllllllIIllIIllIlIIllIIllllI / this.iconGridSizeV);
                for (int lllllllllllIIllIIllIlIIllIIllIIl = lllllllllllIIllIIllIlIIllIIlllIl; lllllllllllIIllIIllIlIIllIIllIIl <= lllllllllllIIllIIllIlIIllIIllIll; ++lllllllllllIIllIIllIlIIllIIllIIl) {
                    if (lllllllllllIIllIIllIlIIllIIllIIl >= 0 && lllllllllllIIllIIllIlIIllIIllIIl < this.iconGridCountX) {
                        for (int lllllllllllIIllIIllIlIIllIIllIII = lllllllllllIIllIIllIlIIllIIlllII; lllllllllllIIllIIllIlIIllIIllIII <= lllllllllllIIllIIllIlIIllIIllIlI; ++lllllllllllIIllIIllIlIIllIIllIII) {
                            if (lllllllllllIIllIIllIlIIllIIllIII >= 0 && lllllllllllIIllIIllIlIIllIIllIII < this.iconGridCountX) {
                                final int lllllllllllIIllIIllIlIIllIIlIlll = lllllllllllIIllIIllIlIIllIIllIII * this.iconGridCountX + lllllllllllIIllIIllIlIIllIIllIIl;
                                this.iconGrid[lllllllllllIIllIIllIlIIllIIlIlll] = lllllllllllIIllIIllIlIIllIlIIlII;
                            }
                            else {
                                Config.warn("Invalid grid V: " + lllllllllllIIllIIllIlIIllIIllIII + ", icon: " + lllllllllllIIllIIllIlIIllIlIIlII.getIconName());
                            }
                        }
                    }
                    else {
                        Config.warn("Invalid grid U: " + lllllllllllIIllIIllIlIIllIIllIIl + ", icon: " + lllllllllllIIllIIllIlIIllIlIIlII.getIconName());
                    }
                }
            }
        }
    }
    
    public TextureAtlasSprite getIconByUV(final double lllllllllllIIllIIllIlIIlIlllIlll, final double lllllllllllIIllIIllIlIIlIlllllII) {
        if (this.iconGrid == null) {
            return null;
        }
        final int lllllllllllIIllIIllIlIIlIllllIll = (int)(lllllllllllIIllIIllIlIIlIlllIlll / this.iconGridSizeU);
        final int lllllllllllIIllIIllIlIIlIllllIlI = (int)(lllllllllllIIllIIllIlIIlIlllllII / this.iconGridSizeV);
        final int lllllllllllIIllIIllIlIIlIllllIIl = lllllllllllIIllIIllIlIIlIllllIlI * this.iconGridCountX + lllllllllllIIllIIllIlIIlIllllIll;
        return (lllllllllllIIllIIllIlIIlIllllIIl >= 0 && lllllllllllIIllIIllIlIIlIllllIIl <= this.iconGrid.length) ? this.iconGrid[lllllllllllIIllIIllIlIIlIllllIIl] : null;
    }
}
