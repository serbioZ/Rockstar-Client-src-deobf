// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.texture;

import java.util.Iterator;
import java.awt.image.BufferedImage;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.IResource;
import shadersmod.client.Shaders;
import optifine.Config;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import com.google.common.collect.ImmutableList;
import optifine.TextureUtils;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.ArrayList;
import java.io.IOException;
import java.util.function.Function;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import java.util.List;

public class TextureAtlasSprite
{
    public /* synthetic */ TextureAtlasSprite spriteSpecular;
    public /* synthetic */ int mipmapLevels;
    private /* synthetic */ float maxU;
    protected /* synthetic */ List<int[][]> framesTextureData;
    protected /* synthetic */ int[][] interpolatedFrameData;
    protected /* synthetic */ int originY;
    public /* synthetic */ int sheetWidth;
    public /* synthetic */ float baseU;
    private /* synthetic */ int indexInMap;
    protected /* synthetic */ int frameCounter;
    private final /* synthetic */ String iconName;
    public /* synthetic */ int glSpriteTextureId;
    protected /* synthetic */ int originX;
    public /* synthetic */ float baseV;
    public /* synthetic */ boolean isShadersSprite;
    public /* synthetic */ boolean isSpriteSingle;
    public /* synthetic */ TextureAtlasSprite spriteSingle;
    protected /* synthetic */ boolean rotated;
    protected /* synthetic */ int tickCounter;
    protected /* synthetic */ int width;
    private /* synthetic */ float minV;
    private /* synthetic */ float maxV;
    private /* synthetic */ AnimationMetadataSection animationMetadata;
    public /* synthetic */ boolean isDependencyParent;
    private /* synthetic */ float minU;
    protected /* synthetic */ int height;
    public /* synthetic */ int sheetHeight;
    public /* synthetic */ TextureAtlasSprite spriteNormal;
    
    public int getFrameCount() {
        return this.framesTextureData.size();
    }
    
    public void setFramesTextureData(final List<int[][]> llllllllllllIlIIIllIIlIIIllIlIIl) {
        this.framesTextureData = llllllllllllIlIIIllIIlIIIllIlIIl;
        if (this.spriteSingle != null) {
            this.spriteSingle.setFramesTextureData(llllllllllllIlIIIllIIlIIIllIlIIl);
        }
    }
    
    public float getMaxU() {
        return this.maxU;
    }
    
    public int getIconWidth() {
        return this.width;
    }
    
    public float getUnInterpolatedV(final float llllllllllllIlIIIllIIlIlIIlllIlI) {
        final float llllllllllllIlIIIllIIlIlIIlllIIl = this.maxV - this.minV;
        return (llllllllllllIlIIIllIIlIlIIlllIlI - this.minV) / llllllllllllIlIIIllIIlIlIIlllIIl * 16.0f;
    }
    
    public void initSprite(final int llllllllllllIlIIIllIIlIllIIIIllI, final int llllllllllllIlIIIllIIlIllIIIIlIl, final int llllllllllllIlIIIllIIlIlIlllllII, final int llllllllllllIlIIIllIIlIllIIIIIll, final boolean llllllllllllIlIIIllIIlIllIIIIIlI) {
        this.originX = llllllllllllIlIIIllIIlIlIlllllII;
        this.originY = llllllllllllIlIIIllIIlIllIIIIIll;
        this.rotated = llllllllllllIlIIIllIIlIllIIIIIlI;
        final float llllllllllllIlIIIllIIlIllIIIIIIl = (float)(0.009999999776482582 / llllllllllllIlIIIllIIlIllIIIIllI);
        final float llllllllllllIlIIIllIIlIllIIIIIII = (float)(0.009999999776482582 / llllllllllllIlIIIllIIlIllIIIIlIl);
        this.minU = llllllllllllIlIIIllIIlIlIlllllII / (float)llllllllllllIlIIIllIIlIllIIIIllI + llllllllllllIlIIIllIIlIllIIIIIIl;
        this.maxU = (llllllllllllIlIIIllIIlIlIlllllII + this.width) / (float)llllllllllllIlIIIllIIlIllIIIIllI - llllllllllllIlIIIllIIlIllIIIIIIl;
        this.minV = llllllllllllIlIIIllIIlIllIIIIIll / (float)llllllllllllIlIIIllIIlIllIIIIlIl + llllllllllllIlIIIllIIlIllIIIIIII;
        this.maxV = (llllllllllllIlIIIllIIlIllIIIIIll + this.height) / (float)llllllllllllIlIIIllIIlIllIIIIlIl - llllllllllllIlIIIllIIlIllIIIIIII;
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public void updateAnimation() {
        if (this.animationMetadata != null) {
            ++this.tickCounter;
            if (this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter)) {
                final int llllllllllllIlIIIllIIlIlIIlIlIll = this.animationMetadata.getFrameIndex(this.frameCounter);
                final int llllllllllllIlIIIllIIlIlIIlIlIlI = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
                this.frameCounter = (this.frameCounter + 1) % llllllllllllIlIIIllIIlIlIIlIlIlI;
                this.tickCounter = 0;
                final int llllllllllllIlIIIllIIlIlIIlIlIIl = this.animationMetadata.getFrameIndex(this.frameCounter);
                final boolean llllllllllllIlIIIllIIlIlIIlIlIII = false;
                final boolean llllllllllllIlIIIllIIlIlIIlIIlll = this.isSpriteSingle;
                if (llllllllllllIlIIIllIIlIlIIlIlIll != llllllllllllIlIIIllIIlIlIIlIlIIl && llllllllllllIlIIIllIIlIlIIlIlIIl >= 0 && llllllllllllIlIIIllIIlIlIIlIlIIl < this.framesTextureData.size()) {
                    TextureUtil.uploadTextureMipmap(this.framesTextureData.get(llllllllllllIlIIIllIIlIlIIlIlIIl), this.width, this.height, this.originX, this.originY, llllllllllllIlIIIllIIlIlIIlIlIII, llllllllllllIlIIIllIIlIlIIlIIlll);
                }
            }
            else if (this.animationMetadata.isInterpolate()) {
                this.updateAnimationInterpolated();
            }
        }
    }
    
    public boolean load(final IResourceManager llllllllllllIlIIIllIIlIIIlIllllI, final ResourceLocation llllllllllllIlIIIllIIlIIIlIlllIl, final Function<ResourceLocation, TextureAtlasSprite> llllllllllllIlIIIllIIlIIIlIlllII) {
        return true;
    }
    
    public void loadSprite(final PngSizeInfo llllllllllllIlIIIllIIlIIllIlIIll, final boolean llllllllllllIlIIIllIIlIIllIlIIlI) throws IOException {
        this.resetSprite();
        this.width = llllllllllllIlIIIllIIlIIllIlIIll.pngWidth;
        this.height = llllllllllllIlIIIllIIlIIllIlIIll.pngHeight;
        if (llllllllllllIlIIIllIIlIIllIlIIlI) {
            this.height = this.width;
        }
        else if (llllllllllllIlIIIllIIlIIllIlIIll.pngHeight != llllllllllllIlIIIllIIlIIllIlIIll.pngWidth) {
            throw new RuntimeException("broken aspect ratio and not an animation");
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.width = this.width;
            this.spriteSingle.height = this.height;
        }
    }
    
    public List<int[][]> getFramesTextureData() {
        final List<int[][]> llllllllllllIlIIIllIIIlllllllIIl = new ArrayList<int[][]>();
        llllllllllllIlIIIllIIIlllllllIIl.addAll(this.framesTextureData);
        return llllllllllllIlIIIllIIIlllllllIIl;
    }
    
    public int getOriginX() {
        return this.originX;
    }
    
    private TextureAtlasSprite(final TextureAtlasSprite llllllllllllIlIIIllIIlIllIIllIll) {
        this.framesTextureData = (List<int[][]>)Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.spriteNormal = null;
        this.spriteSpecular = null;
        this.isShadersSprite = false;
        this.isDependencyParent = false;
        this.iconName = llllllllllllIlIIIllIIlIllIIllIll.iconName;
        this.isSpriteSingle = true;
    }
    
    public float getMinV() {
        return this.minV;
    }
    
    private void resetSprite() {
        this.animationMetadata = null;
        this.setFramesTextureData(Lists.newArrayList());
        this.frameCounter = 0;
        this.tickCounter = 0;
        if (this.spriteSingle != null) {
            this.spriteSingle.resetSprite();
        }
    }
    
    private static int[][] getFrameTextureData(final int[][] llllllllllllIlIIIllIIlIIIllllIll, final int llllllllllllIlIIIllIIlIIlIIIIIIl, final int llllllllllllIlIIIllIIlIIlIIIIIII, final int llllllllllllIlIIIllIIlIIIlllllll) {
        final int[][] llllllllllllIlIIIllIIlIIIllllllI = new int[llllllllllllIlIIIllIIlIIIllllIll.length][];
        for (int llllllllllllIlIIIllIIlIIIlllllIl = 0; llllllllllllIlIIIllIIlIIIlllllIl < llllllllllllIlIIIllIIlIIIllllIll.length; ++llllllllllllIlIIIllIIlIIIlllllIl) {
            final int[] llllllllllllIlIIIllIIlIIIlllllII = llllllllllllIlIIIllIIlIIIllllIll[llllllllllllIlIIIllIIlIIIlllllIl];
            if (llllllllllllIlIIIllIIlIIIlllllII != null) {
                llllllllllllIlIIIllIIlIIIllllllI[llllllllllllIlIIIllIIlIIIlllllIl] = new int[(llllllllllllIlIIIllIIlIIlIIIIIIl >> llllllllllllIlIIIllIIlIIIlllllIl) * (llllllllllllIlIIIllIIlIIlIIIIIII >> llllllllllllIlIIIllIIlIIIlllllIl)];
                System.arraycopy(llllllllllllIlIIIllIIlIIIlllllII, llllllllllllIlIIIllIIlIIIlllllll * llllllllllllIlIIIllIIlIIIllllllI[llllllllllllIlIIIllIIlIIIlllllIl].length, llllllllllllIlIIIllIIlIIIllllllI[llllllllllllIlIIIllIIlIIIlllllIl], 0, llllllllllllIlIIIllIIlIIIllllllI[llllllllllllIlIIIllIIlIIIlllllIl].length);
            }
        }
        return llllllllllllIlIIIllIIlIIIllllllI;
    }
    
    public float toSingleU(float llllllllllllIlIIIllIIlIIIIIIIlll) {
        llllllllllllIlIIIllIIlIIIIIIIlll -= this.baseU;
        final float llllllllllllIlIIIllIIlIIIIIIlIIl = this.sheetWidth / (float)this.width;
        llllllllllllIlIIIllIIlIIIIIIIlll *= llllllllllllIlIIIllIIlIIIIIIlIIl;
        return llllllllllllIlIIIllIIlIIIIIIIlll;
    }
    
    private void fixTransparentColor(final int[] llllllllllllIlIIIllIIlIIIIllIIIl) {
        if (llllllllllllIlIIIllIIlIIIIllIIIl != null) {
            long llllllllllllIlIIIllIIlIIIlIIIIll = 0L;
            long llllllllllllIlIIIllIIlIIIlIIIIlI = 0L;
            long llllllllllllIlIIIllIIlIIIlIIIIIl = 0L;
            long llllllllllllIlIIIllIIlIIIlIIIIII = 0L;
            for (int llllllllllllIlIIIllIIlIIIIllllll = 0; llllllllllllIlIIIllIIlIIIIllllll < llllllllllllIlIIIllIIlIIIIllIIIl.length; ++llllllllllllIlIIIllIIlIIIIllllll) {
                final int llllllllllllIlIIIllIIlIIIIlllllI = llllllllllllIlIIIllIIlIIIIllIIIl[llllllllllllIlIIIllIIlIIIIllllll];
                final int llllllllllllIlIIIllIIlIIIIllllIl = llllllllllllIlIIIllIIlIIIIlllllI >> 24 & 0xFF;
                if (llllllllllllIlIIIllIIlIIIIllllIl >= 16) {
                    final int llllllllllllIlIIIllIIlIIIIllllII = llllllllllllIlIIIllIIlIIIIlllllI >> 16 & 0xFF;
                    final int llllllllllllIlIIIllIIlIIIIlllIll = llllllllllllIlIIIllIIlIIIIlllllI >> 8 & 0xFF;
                    final int llllllllllllIlIIIllIIlIIIIlllIlI = llllllllllllIlIIIllIIlIIIIlllllI & 0xFF;
                    llllllllllllIlIIIllIIlIIIlIIIIll += llllllllllllIlIIIllIIlIIIIllllII;
                    llllllllllllIlIIIllIIlIIIlIIIIlI += llllllllllllIlIIIllIIlIIIIlllIll;
                    llllllllllllIlIIIllIIlIIIlIIIIIl += llllllllllllIlIIIllIIlIIIIlllIlI;
                    ++llllllllllllIlIIIllIIlIIIlIIIIII;
                }
            }
            if (llllllllllllIlIIIllIIlIIIlIIIIII > 0L) {
                final int llllllllllllIlIIIllIIlIIIIlllIIl = (int)(llllllllllllIlIIIllIIlIIIlIIIIll / llllllllllllIlIIIllIIlIIIlIIIIII);
                final int llllllllllllIlIIIllIIlIIIIlllIII = (int)(llllllllllllIlIIIllIIlIIIlIIIIlI / llllllllllllIlIIIllIIlIIIlIIIIII);
                final int llllllllllllIlIIIllIIlIIIIllIlll = (int)(llllllllllllIlIIIllIIlIIIlIIIIIl / llllllllllllIlIIIllIIlIIIlIIIIII);
                final int llllllllllllIlIIIllIIlIIIIllIllI = llllllllllllIlIIIllIIlIIIIlllIIl << 16 | llllllllllllIlIIIllIIlIIIIlllIII << 8 | llllllllllllIlIIIllIIlIIIIllIlll;
                for (int llllllllllllIlIIIllIIlIIIIllIlIl = 0; llllllllllllIlIIIllIIlIIIIllIlIl < llllllllllllIlIIIllIIlIIIIllIIIl.length; ++llllllllllllIlIIIllIIlIIIIllIlIl) {
                    final int llllllllllllIlIIIllIIlIIIIllIlII = llllllllllllIlIIIllIIlIIIIllIIIl[llllllllllllIlIIIllIIlIIIIllIlIl];
                    final int llllllllllllIlIIIllIIlIIIIllIIll = llllllllllllIlIIIllIIlIIIIllIlII >> 24 & 0xFF;
                    if (llllllllllllIlIIIllIIlIIIIllIIll <= 16) {
                        llllllllllllIlIIIllIIlIIIIllIIIl[llllllllllllIlIIIllIIlIIIIllIlIl] = llllllllllllIlIIIllIIlIIIIllIllI;
                    }
                }
            }
        }
    }
    
    public float toSingleV(float llllllllllllIlIIIllIIIlllllllllI) {
        llllllllllllIlIIIllIIIlllllllllI -= this.baseV;
        final float llllllllllllIlIIIllIIlIIIIIIIIII = this.sheetHeight / (float)this.height;
        llllllllllllIlIIIllIIIlllllllllI *= llllllllllllIlIIIllIIlIIIIIIIIII;
        return llllllllllllIlIIIllIIIlllllllllI;
    }
    
    public void bindSpriteTexture() {
        if (this.glSpriteTextureId < 0) {
            this.glSpriteTextureId = TextureUtil.glGenTextures();
            TextureUtil.allocateTextureImpl(this.glSpriteTextureId, this.mipmapLevels, this.width, this.height);
            TextureUtils.applyAnisotropicLevel();
        }
        TextureUtils.bindTexture(this.glSpriteTextureId);
    }
    
    public Collection<ResourceLocation> getDependencies() {
        return (Collection<ResourceLocation>)ImmutableList.of();
    }
    
    public void setAnimationMetadata(final AnimationMetadataSection llllllllllllIlIIIllIIIlllllIlllI) {
        this.animationMetadata = llllllllllllIlIIIllIIIlllllIlllI;
    }
    
    public float getInterpolatedV(final double llllllllllllIlIIIllIIlIlIlIIIIll) {
        final float llllllllllllIlIIIllIIlIlIlIIIIlI = this.maxV - this.minV;
        return this.minV + llllllllllllIlIIIllIIlIlIlIIIIlI * (float)llllllllllllIlIIIllIIlIlIlIIIIll / 16.0f;
    }
    
    public int getOriginY() {
        return this.originY;
    }
    
    public void generateMipmaps(final int llllllllllllIlIIIllIIlIIlIIllIIl) {
        final List<int[][]> llllllllllllIlIIIllIIlIIlIlIIIII = (List<int[][]>)Lists.newArrayList();
        for (int llllllllllllIlIIIllIIlIIlIIlllll = 0; llllllllllllIlIIIllIIlIIlIIlllll < this.framesTextureData.size(); ++llllllllllllIlIIIllIIlIIlIIlllll) {
            final int[][] llllllllllllIlIIIllIIlIIlIIllllI = this.framesTextureData.get(llllllllllllIlIIIllIIlIIlIIlllll);
            if (llllllllllllIlIIIllIIlIIlIIllllI != null) {
                try {
                    llllllllllllIlIIIllIIlIIlIlIIIII.add(TextureUtil.generateMipmapData(llllllllllllIlIIIllIIlIIlIIllIIl, this.width, llllllllllllIlIIIllIIlIIlIIllllI));
                }
                catch (Throwable llllllllllllIlIIIllIIlIIlIIlllIl) {
                    final CrashReport llllllllllllIlIIIllIIlIIlIIlllII = CrashReport.makeCrashReport(llllllllllllIlIIIllIIlIIlIIlllIl, "Generating mipmaps for frame");
                    final CrashReportCategory llllllllllllIlIIIllIIlIIlIIllIll = llllllllllllIlIIIllIIlIIlIIlllII.makeCategory("Frame being iterated");
                    llllllllllllIlIIIllIIlIIlIIllIll.addCrashSection("Frame index", llllllllllllIlIIIllIIlIIlIIlllll);
                    llllllllllllIlIIIllIIlIIlIIllIll.setDetail("Frame sizes", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            final StringBuilder lllllllllllIIIlIIIlIIlIlIIIIlllI = new StringBuilder();
                            final Exception lllllllllllIIIlIIIlIIlIlIIIIIlll;
                            final double lllllllllllIIIlIIIlIIlIlIIIIlIII = ((int[][])(Object)(lllllllllllIIIlIIIlIIlIlIIIIIlll = (Exception)(Object)llllllllllllIlIIIllIIlIIlIIllllI)).length;
                            for (String lllllllllllIIIlIIIlIIlIlIIIIlIIl = (String)0; lllllllllllIIIlIIIlIIlIlIIIIlIIl < lllllllllllIIIlIIIlIIlIlIIIIlIII; ++lllllllllllIIIlIIIlIIlIlIIIIlIIl) {
                                final int[] lllllllllllIIIlIIIlIIlIlIIIIllIl = lllllllllllIIIlIIIlIIlIlIIIIIlll[lllllllllllIIIlIIIlIIlIlIIIIlIIl];
                                if (lllllllllllIIIlIIIlIIlIlIIIIlllI.length() > 0) {
                                    lllllllllllIIIlIIIlIIlIlIIIIlllI.append(", ");
                                }
                                lllllllllllIIIlIIIlIIlIlIIIIlllI.append((lllllllllllIIIlIIIlIIlIlIIIIllIl == null) ? "null" : Integer.valueOf(lllllllllllIIIlIIIlIIlIlIIIIllIl.length));
                            }
                            return lllllllllllIIIlIIIlIIlIlIIIIlllI.toString();
                        }
                    });
                    throw new ReportedException(llllllllllllIlIIIllIIlIIlIIlllII);
                }
            }
        }
        this.setFramesTextureData(llllllllllllIlIIIllIIlIIlIlIIIII);
        if (this.spriteSingle != null) {
            this.spriteSingle.generateMipmaps(llllllllllllIlIIIllIIlIIlIIllIIl);
        }
    }
    
    public AnimationMetadataSection getAnimationMetadata() {
        return this.animationMetadata;
    }
    
    private void updateAnimationInterpolated() {
        final double llllllllllllIlIIIllIIlIlIIIlIIIl = 1.0 - this.tickCounter / (double)this.animationMetadata.getFrameTimeSingle(this.frameCounter);
        final int llllllllllllIlIIIllIIlIlIIIlIIII = this.animationMetadata.getFrameIndex(this.frameCounter);
        final int llllllllllllIlIIIllIIlIlIIIIllll = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
        final int llllllllllllIlIIIllIIlIlIIIIlllI = this.animationMetadata.getFrameIndex((this.frameCounter + 1) % llllllllllllIlIIIllIIlIlIIIIllll);
        if (llllllllllllIlIIIllIIlIlIIIlIIII != llllllllllllIlIIIllIIlIlIIIIlllI && llllllllllllIlIIIllIIlIlIIIIlllI >= 0 && llllllllllllIlIIIllIIlIlIIIIlllI < this.framesTextureData.size()) {
            final int[][] llllllllllllIlIIIllIIlIlIIIIllIl = this.framesTextureData.get(llllllllllllIlIIIllIIlIlIIIlIIII);
            final int[][] llllllllllllIlIIIllIIlIlIIIIllII = this.framesTextureData.get(llllllllllllIlIIIllIIlIlIIIIlllI);
            if (this.interpolatedFrameData == null || this.interpolatedFrameData.length != llllllllllllIlIIIllIIlIlIIIIllIl.length) {
                this.interpolatedFrameData = new int[llllllllllllIlIIIllIIlIlIIIIllIl.length][];
            }
            for (int llllllllllllIlIIIllIIlIlIIIIlIll = 0; llllllllllllIlIIIllIIlIlIIIIlIll < llllllllllllIlIIIllIIlIlIIIIllIl.length; ++llllllllllllIlIIIllIIlIlIIIIlIll) {
                if (this.interpolatedFrameData[llllllllllllIlIIIllIIlIlIIIIlIll] == null) {
                    this.interpolatedFrameData[llllllllllllIlIIIllIIlIlIIIIlIll] = new int[llllllllllllIlIIIllIIlIlIIIIllIl[llllllllllllIlIIIllIIlIlIIIIlIll].length];
                }
                if (llllllllllllIlIIIllIIlIlIIIIlIll < llllllllllllIlIIIllIIlIlIIIIllII.length && llllllllllllIlIIIllIIlIlIIIIllII[llllllllllllIlIIIllIIlIlIIIIlIll].length == llllllllllllIlIIIllIIlIlIIIIllIl[llllllllllllIlIIIllIIlIlIIIIlIll].length) {
                    for (int llllllllllllIlIIIllIIlIlIIIIlIlI = 0; llllllllllllIlIIIllIIlIlIIIIlIlI < llllllllllllIlIIIllIIlIlIIIIllIl[llllllllllllIlIIIllIIlIlIIIIlIll].length; ++llllllllllllIlIIIllIIlIlIIIIlIlI) {
                        final int llllllllllllIlIIIllIIlIlIIIIlIIl = llllllllllllIlIIIllIIlIlIIIIllIl[llllllllllllIlIIIllIIlIlIIIIlIll][llllllllllllIlIIIllIIlIlIIIIlIlI];
                        final int llllllllllllIlIIIllIIlIlIIIIlIII = llllllllllllIlIIIllIIlIlIIIIllII[llllllllllllIlIIIllIIlIlIIIIlIll][llllllllllllIlIIIllIIlIlIIIIlIlI];
                        final int llllllllllllIlIIIllIIlIlIIIIIlll = this.interpolateColor(llllllllllllIlIIIllIIlIlIIIlIIIl, llllllllllllIlIIIllIIlIlIIIIlIIl >> 16 & 0xFF, llllllllllllIlIIIllIIlIlIIIIlIII >> 16 & 0xFF);
                        final int llllllllllllIlIIIllIIlIlIIIIIllI = this.interpolateColor(llllllllllllIlIIIllIIlIlIIIlIIIl, llllllllllllIlIIIllIIlIlIIIIlIIl >> 8 & 0xFF, llllllllllllIlIIIllIIlIlIIIIlIII >> 8 & 0xFF);
                        final int llllllllllllIlIIIllIIlIlIIIIIlIl = this.interpolateColor(llllllllllllIlIIIllIIlIlIIIlIIIl, llllllllllllIlIIIllIIlIlIIIIlIIl & 0xFF, llllllllllllIlIIIllIIlIlIIIIlIII & 0xFF);
                        this.interpolatedFrameData[llllllllllllIlIIIllIIlIlIIIIlIll][llllllllllllIlIIIllIIlIlIIIIlIlI] = ((llllllllllllIlIIIllIIlIlIIIIlIIl & 0xFF000000) | llllllllllllIlIIIllIIlIlIIIIIlll << 16 | llllllllllllIlIIIllIIlIlIIIIIllI << 8 | llllllllllllIlIIIllIIlIlIIIIIlIl);
                    }
                }
            }
            TextureUtil.uploadTextureMipmap(this.interpolatedFrameData, this.width, this.height, this.originX, this.originY, false, false);
        }
    }
    
    protected TextureAtlasSprite(final String llllllllllllIlIIIllIIlIllIIlIIll) {
        this.framesTextureData = (List<int[][]>)Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.spriteNormal = null;
        this.spriteSpecular = null;
        this.isShadersSprite = false;
        this.isDependencyParent = false;
        this.iconName = llllllllllllIlIIIllIIlIllIIlIIll;
        if (Config.isMultiTexture()) {
            this.spriteSingle = new TextureAtlasSprite(this);
        }
    }
    
    public float getUnInterpolatedU(final float llllllllllllIlIIIllIIlIlIlIIllll) {
        final float llllllllllllIlIIIllIIlIlIlIlIIIl = this.maxU - this.minU;
        return (llllllllllllIlIIIllIIlIlIlIIllll - this.minU) / llllllllllllIlIIIllIIlIlIlIlIIIl * 16.0f;
    }
    
    protected static TextureAtlasSprite makeAtlasSprite(final ResourceLocation llllllllllllIlIIIllIIlIllIIlIIII) {
        return new TextureAtlasSprite(llllllllllllIlIIIllIIlIllIIlIIII.toString());
    }
    
    public double getSpriteV16(final float llllllllllllIlIIIllIIlIIIIIlIllI) {
        final float llllllllllllIlIIIllIIlIIIIIllIII = this.maxV - this.minV;
        return (llllllllllllIlIIIllIIlIIIIIlIllI - this.minV) / llllllllllllIlIIIllIIlIIIIIllIII * 16.0f;
    }
    
    @Override
    public String toString() {
        return "TextureAtlasSprite{name='" + this.iconName + '\'' + ", frameCount=" + this.framesTextureData.size() + ", rotated=" + this.rotated + ", x=" + this.originX + ", y=" + this.originY + ", height=" + this.height + ", width=" + this.width + ", u0=" + this.minU + ", u1=" + this.maxU + ", v0=" + this.minV + ", v1=" + this.maxV + '}';
    }
    
    public void clearFramesTextureData() {
        this.framesTextureData.clear();
        if (this.spriteSingle != null) {
            this.spriteSingle.clearFramesTextureData();
        }
    }
    
    public boolean hasAnimationMetadata() {
        return this.animationMetadata != null;
    }
    
    public float getInterpolatedU(final double llllllllllllIlIIIllIIlIlIlIllIII) {
        final float llllllllllllIlIIIllIIlIlIlIllIlI = this.maxU - this.minU;
        return this.minU + llllllllllllIlIIIllIIlIlIlIllIlI * (float)llllllllllllIlIIIllIIlIlIlIllIII / 16.0f;
    }
    
    public String getIconName() {
        return this.iconName;
    }
    
    public float getMaxV() {
        return this.maxV;
    }
    
    private void allocateFrameTextureData(final int llllllllllllIlIIIllIIlIIlIIIlllI) {
        if (this.framesTextureData.size() <= llllllllllllIlIIIllIIlIIlIIIlllI) {
            for (int llllllllllllIlIIIllIIlIIlIIIllIl = this.framesTextureData.size(); llllllllllllIlIIIllIIlIIlIIIllIl <= llllllllllllIlIIIllIIlIIlIIIlllI; ++llllllllllllIlIIIllIIlIIlIIIllIl) {
                this.framesTextureData.add(null);
            }
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.allocateFrameTextureData(llllllllllllIlIIIllIIlIIlIIIlllI);
        }
    }
    
    public void deleteSpriteTexture() {
        if (this.glSpriteTextureId >= 0) {
            TextureUtil.deleteTexture(this.glSpriteTextureId);
            this.glSpriteTextureId = -1;
        }
    }
    
    private void loadShadersSprites() {
        if (Shaders.configNormalMap) {
            final String llllllllllllIlIIIllIIIlllllIlIIl = String.valueOf(this.iconName) + "_n";
            ResourceLocation llllllllllllIlIIIllIIIlllllIlIII = new ResourceLocation(llllllllllllIlIIIllIIIlllllIlIIl);
            llllllllllllIlIIIllIIIlllllIlIII = Config.getTextureMap().completeResourceLocation(llllllllllllIlIIIllIIIlllllIlIII);
            if (Config.hasResource(llllllllllllIlIIIllIIIlllllIlIII)) {
                this.spriteNormal = new TextureAtlasSprite(llllllllllllIlIIIllIIIlllllIlIIl);
                this.spriteNormal.isShadersSprite = true;
                this.spriteNormal.copyFrom(this);
                Config.getTextureMap().generateMipmaps(Config.getResourceManager(), this.spriteNormal);
            }
        }
        if (Shaders.configSpecularMap) {
            final String llllllllllllIlIIIllIIIlllllIIlll = String.valueOf(this.iconName) + "_s";
            ResourceLocation llllllllllllIlIIIllIIIlllllIIllI = new ResourceLocation(llllllllllllIlIIIllIIIlllllIIlll);
            llllllllllllIlIIIllIIIlllllIIllI = Config.getTextureMap().completeResourceLocation(llllllllllllIlIIIllIIIlllllIIllI);
            if (Config.hasResource(llllllllllllIlIIIllIIIlllllIIllI)) {
                this.spriteSpecular = new TextureAtlasSprite(llllllllllllIlIIIllIIIlllllIIlll);
                this.spriteSpecular.isShadersSprite = true;
                this.spriteSpecular.copyFrom(this);
                Config.getTextureMap().generateMipmaps(Config.getResourceManager(), this.spriteSpecular);
            }
        }
    }
    
    private int interpolateColor(final double llllllllllllIlIIIllIIlIIllllIIlI, final int llllllllllllIlIIIllIIlIIlllIlllI, final int llllllllllllIlIIIllIIlIIllllIIII) {
        return (int)(llllllllllllIlIIIllIIlIIllllIIlI * llllllllllllIlIIIllIIlIIlllIlllI + (1.0 - llllllllllllIlIIIllIIlIIllllIIlI) * llllllllllllIlIIIllIIlIIllllIIII);
    }
    
    public int getIndexInMap() {
        return this.indexInMap;
    }
    
    public void loadSpriteFrames(final IResource llllllllllllIlIIIllIIlIIllIIIIll, final int llllllllllllIlIIIllIIlIIlIllIIlI) throws IOException {
        BufferedImage llllllllllllIlIIIllIIlIIllIIIIIl = TextureUtil.readBufferedImage(llllllllllllIlIIIllIIlIIllIIIIll.getInputStream());
        if (this.width != llllllllllllIlIIIllIIlIIllIIIIIl.getWidth()) {
            llllllllllllIlIIIllIIlIIllIIIIIl = TextureUtils.scaleImage(llllllllllllIlIIIllIIlIIllIIIIIl, this.width);
        }
        final AnimationMetadataSection llllllllllllIlIIIllIIlIIllIIIIII = llllllllllllIlIIIllIIlIIllIIIIll.getMetadata("animation");
        final int[][] llllllllllllIlIIIllIIlIIlIllllll = new int[llllllllllllIlIIIllIIlIIlIllIIlI][];
        llllllllllllIlIIIllIIlIIlIllllll[0] = new int[llllllllllllIlIIIllIIlIIllIIIIIl.getWidth() * llllllllllllIlIIIllIIlIIllIIIIIl.getHeight()];
        llllllllllllIlIIIllIIlIIllIIIIIl.getRGB(0, 0, llllllllllllIlIIIllIIlIIllIIIIIl.getWidth(), llllllllllllIlIIIllIIlIIllIIIIIl.getHeight(), llllllllllllIlIIIllIIlIIlIllllll[0], 0, llllllllllllIlIIIllIIlIIllIIIIIl.getWidth());
        if (llllllllllllIlIIIllIIlIIllIIIIII == null) {
            this.framesTextureData.add(llllllllllllIlIIIllIIlIIlIllllll);
        }
        else {
            final int llllllllllllIlIIIllIIlIIlIlllllI = llllllllllllIlIIIllIIlIIllIIIIIl.getHeight() / this.width;
            if (llllllllllllIlIIIllIIlIIllIIIIII.getFrameCount() > 0) {
                for (final int llllllllllllIlIIIllIIlIIlIllllII : llllllllllllIlIIIllIIlIIllIIIIII.getFrameIndexSet()) {
                    if (llllllllllllIlIIIllIIlIIlIllllII >= llllllllllllIlIIIllIIlIIlIlllllI) {
                        throw new RuntimeException("invalid frameindex " + llllllllllllIlIIIllIIlIIlIllllII);
                    }
                    this.allocateFrameTextureData(llllllllllllIlIIIllIIlIIlIllllII);
                    this.framesTextureData.set(llllllllllllIlIIIllIIlIIlIllllII, getFrameTextureData(llllllllllllIlIIIllIIlIIlIllllll, this.width, this.width, llllllllllllIlIIIllIIlIIlIllllII));
                }
                this.animationMetadata = llllllllllllIlIIIllIIlIIllIIIIII;
            }
            else {
                final List<AnimationFrame> llllllllllllIlIIIllIIlIIlIlllIll = (List<AnimationFrame>)Lists.newArrayList();
                for (int llllllllllllIlIIIllIIlIIlIlllIlI = 0; llllllllllllIlIIIllIIlIIlIlllIlI < llllllllllllIlIIIllIIlIIlIlllllI; ++llllllllllllIlIIIllIIlIIlIlllIlI) {
                    this.framesTextureData.add(getFrameTextureData(llllllllllllIlIIIllIIlIIlIllllll, this.width, this.width, llllllllllllIlIIIllIIlIIlIlllIlI));
                    llllllllllllIlIIIllIIlIIlIlllIll.add(new AnimationFrame(llllllllllllIlIIIllIIlIIlIlllIlI, -1));
                }
                this.animationMetadata = new AnimationMetadataSection(llllllllllllIlIIIllIIlIIlIlllIll, this.width, this.height, llllllllllllIlIIIllIIlIIllIIIIII.getFrameTime(), llllllllllllIlIIIllIIlIIllIIIIII.isInterpolate());
            }
        }
        if (!this.isShadersSprite) {
            if (Config.isShaders()) {
                this.loadShadersSprites();
            }
            for (int llllllllllllIlIIIllIIlIIlIlllIIl = 0; llllllllllllIlIIIllIIlIIlIlllIIl < this.framesTextureData.size(); ++llllllllllllIlIIIllIIlIIlIlllIIl) {
                final int[][] llllllllllllIlIIIllIIlIIlIlllIII = this.framesTextureData.get(llllllllllllIlIIIllIIlIIlIlllIIl);
                if (llllllllllllIlIIIllIIlIIlIlllIII != null && !this.iconName.startsWith("minecraft:blocks/leaves_")) {
                    for (int llllllllllllIlIIIllIIlIIlIllIlll = 0; llllllllllllIlIIIllIIlIIlIllIlll < llllllllllllIlIIIllIIlIIlIlllIII.length; ++llllllllllllIlIIIllIIlIIlIllIlll) {
                        final int[] llllllllllllIlIIIllIIlIIlIllIllI = llllllllllllIlIIIllIIlIIlIlllIII[llllllllllllIlIIIllIIlIIlIllIlll];
                        this.fixTransparentColor(llllllllllllIlIIIllIIlIIlIllIllI);
                    }
                }
            }
            if (this.spriteSingle != null) {
                final IResource llllllllllllIlIIIllIIlIIlIllIlIl = Config.getResourceManager().getResource(llllllllllllIlIIIllIIlIIllIIIIll.getResourceLocation());
                this.spriteSingle.loadSpriteFrames(llllllllllllIlIIIllIIlIIlIllIlIl, llllllllllllIlIIIllIIlIIlIllIIlI);
            }
        }
    }
    
    public int getIconHeight() {
        return this.height;
    }
    
    public void setIconWidth(final int llllllllllllIlIIIllIIlIIllIllllI) {
        this.width = llllllllllllIlIIIllIIlIIllIllllI;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconWidth(this.width);
        }
    }
    
    public int[][] getFrameTextureData(final int llllllllllllIlIIIllIIlIIlllIIlll) {
        return this.framesTextureData.get(llllllllllllIlIIIllIIlIIlllIIlll);
    }
    
    public double getSpriteU16(final float llllllllllllIlIIIllIIlIIIIIlllll) {
        final float llllllllllllIlIIIllIIlIIIIlIIIIl = this.maxU - this.minU;
        return (llllllllllllIlIIIllIIlIIIIIlllll - this.minU) / llllllllllllIlIIIllIIlIIIIlIIIIl * 16.0f;
    }
    
    public float getMinU() {
        return this.minU;
    }
    
    public void setIconHeight(final int llllllllllllIlIIIllIIlIIllIllIII) {
        this.height = llllllllllllIlIIIllIIlIIllIllIII;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconHeight(this.height);
        }
    }
    
    public void setIndexInMap(final int llllllllllllIlIIIllIIlIIIlIlIIlI) {
        this.indexInMap = llllllllllllIlIIIllIIlIIIlIlIIlI;
    }
    
    public void copyFrom(final TextureAtlasSprite llllllllllllIlIIIllIIlIlIlllIIlI) {
        this.originX = llllllllllllIlIIIllIIlIlIlllIIlI.originX;
        this.originY = llllllllllllIlIIIllIIlIlIlllIIlI.originY;
        this.width = llllllllllllIlIIIllIIlIlIlllIIlI.width;
        this.height = llllllllllllIlIIIllIIlIlIlllIIlI.height;
        this.rotated = llllllllllllIlIIIllIIlIlIlllIIlI.rotated;
        this.minU = llllllllllllIlIIIllIIlIlIlllIIlI.minU;
        this.maxU = llllllllllllIlIIIllIIlIlIlllIIlI.maxU;
        this.minV = llllllllllllIlIIIllIIlIlIlllIIlI.minV;
        this.maxV = llllllllllllIlIIIllIIlIlIlllIIlI.maxV;
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public boolean hasCustomLoader(final IResourceManager llllllllllllIlIIIllIIlIIIllIIIIl, final ResourceLocation llllllllllllIlIIIllIIlIIIllIIIII) {
        return false;
    }
}
