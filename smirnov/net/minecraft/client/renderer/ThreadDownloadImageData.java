// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import optifine.Config;
import java.net.URL;
import java.net.HttpURLConnection;
import net.minecraft.util.ResourceLocation;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;
import org.apache.logging.log4j.LogManager;
import java.net.Proxy;
import optifine.HttpResponse;
import optifine.HttpRequest;
import net.minecraft.client.renderer.texture.TextureUtil;
import javax.imageio.ImageIO;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import java.io.ByteArrayInputStream;
import optifine.HttpPipeline;
import net.minecraft.client.Minecraft;
import optifine.CapeImageBuffer;
import java.io.File;
import java.awt.image.BufferedImage;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.texture.SimpleTexture;

public class ThreadDownloadImageData extends SimpleTexture
{
    @Nullable
    private final /* synthetic */ IImageBuffer imageBuffer;
    private /* synthetic */ boolean textureUploaded;
    private static final /* synthetic */ AtomicInteger TEXTURE_DOWNLOADER_THREAD_ID;
    public /* synthetic */ Boolean imageFound;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ String imageUrl;
    @Nullable
    private /* synthetic */ BufferedImage bufferedImage;
    public /* synthetic */ boolean pipeline;
    @Nullable
    private /* synthetic */ Thread imageThread;
    @Nullable
    private final /* synthetic */ File cacheFile;
    
    private void loadingFinished() {
        this.imageFound = (this.bufferedImage != null);
        if (this.imageBuffer instanceof CapeImageBuffer) {
            final CapeImageBuffer lllllllllllllIIlIlIlIlIIllllIlII = (CapeImageBuffer)this.imageBuffer;
            lllllllllllllIIlIlIlIlIIllllIlII.cleanup();
        }
    }
    
    public void setBufferedImage(final BufferedImage lllllllllllllIIlIlIlIlIlIIlIIIlI) {
        this.bufferedImage = lllllllllllllIIlIlIlIlIlIIlIIIlI;
        if (this.imageBuffer != null) {
            this.imageBuffer.skinAvailable();
        }
        this.imageFound = (this.bufferedImage != null);
    }
    
    private void loadPipelined() {
        try {
            final HttpRequest lllllllllllllIIlIlIlIlIlIIIIIlIl = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            final HttpResponse lllllllllllllIIlIlIlIlIlIIIIIlII = HttpPipeline.executeRequest(lllllllllllllIIlIlIlIlIlIIIIIlIl);
            if (lllllllllllllIIlIlIlIlIlIIIIIlII.getStatus() / 100 != 2) {
                return;
            }
            final byte[] lllllllllllllIIlIlIlIlIlIIIIIIll = lllllllllllllIIlIlIlIlIlIIIIIlII.getBody();
            final ByteArrayInputStream lllllllllllllIIlIlIlIlIlIIIIIIlI = new ByteArrayInputStream(lllllllllllllIIlIlIlIlIlIIIIIIll);
            BufferedImage lllllllllllllIIlIlIlIlIlIIIIIIII = null;
            if (this.cacheFile != null) {
                FileUtils.copyInputStreamToFile((InputStream)lllllllllllllIIlIlIlIlIlIIIIIIlI, this.cacheFile);
                final BufferedImage lllllllllllllIIlIlIlIlIlIIIIIIIl = ImageIO.read(this.cacheFile);
            }
            else {
                lllllllllllllIIlIlIlIlIlIIIIIIII = TextureUtil.readBufferedImage(lllllllllllllIIlIlIlIlIlIIIIIIlI);
            }
            if (this.imageBuffer != null) {
                lllllllllllllIIlIlIlIlIlIIIIIIII = this.imageBuffer.parseUserSkin(lllllllllllllIIlIlIlIlIlIIIIIIII);
            }
            this.setBufferedImage(lllllllllllllIIlIlIlIlIlIIIIIIII);
        }
        catch (Exception lllllllllllllIIlIlIlIlIIllllllll) {
            ThreadDownloadImageData.LOGGER.error("Couldn't download http texture: " + lllllllllllllIIlIlIlIlIIllllllll.getClass().getName() + ": " + lllllllllllllIIlIlIlIlIIllllllll.getMessage());
            return;
        }
        finally {
            this.loadingFinished();
        }
        this.loadingFinished();
    }
    
    @Override
    public int getGlTextureId() {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }
    
    private boolean shouldPipeline() {
        if (!this.pipeline) {
            return false;
        }
        final Proxy lllllllllllllIIlIlIlIlIlIIIlIIII = Minecraft.getMinecraft().getProxy();
        return (lllllllllllllIIlIlIlIlIlIIIlIIII.type() == Proxy.Type.DIRECT || lllllllllllllIIlIlIlIlIlIIIlIIII.type() == Proxy.Type.SOCKS) && this.imageUrl.startsWith("http://");
    }
    
    static {
        LOGGER = LogManager.getLogger();
        TEXTURE_DOWNLOADER_THREAD_ID = new AtomicInteger(0);
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIIlIlIlIlIlIIIllIll) throws IOException {
        if (this.bufferedImage == null && this.textureLocation != null) {
            super.loadTexture(lllllllllllllIIlIlIlIlIlIIIllIll);
        }
        if (this.imageThread == null) {
            if (this.cacheFile != null && this.cacheFile.isFile()) {
                ThreadDownloadImageData.LOGGER.debug("Loading http texture from local cache ({})", (Object)this.cacheFile);
                try {
                    this.bufferedImage = ImageIO.read(this.cacheFile);
                    if (this.imageBuffer != null) {
                        this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
                    }
                    this.loadingFinished();
                }
                catch (IOException lllllllllllllIIlIlIlIlIlIIIllIlI) {
                    ThreadDownloadImageData.LOGGER.error("Couldn't load skin {}", (Object)this.cacheFile, (Object)lllllllllllllIIlIlIlIlIlIIIllIlI);
                    this.loadTextureFromServer();
                }
            }
            else {
                this.loadTextureFromServer();
            }
        }
    }
    
    public ThreadDownloadImageData(@Nullable final File lllllllllllllIIlIlIlIlIlIIlIllll, final String lllllllllllllIIlIlIlIlIlIIllIIll, final ResourceLocation lllllllllllllIIlIlIlIlIlIIlIllIl, @Nullable final IImageBuffer lllllllllllllIIlIlIlIlIlIIlIllII) {
        super(lllllllllllllIIlIlIlIlIlIIlIllIl);
        this.imageFound = null;
        this.pipeline = false;
        this.cacheFile = lllllllllllllIIlIlIlIlIlIIlIllll;
        this.imageUrl = lllllllllllllIIlIlIlIlIlIIllIIll;
        this.imageBuffer = lllllllllllllIIlIlIlIlIlIIlIllII;
    }
    
    private void checkTextureUploaded() {
        if (!this.textureUploaded && this.bufferedImage != null) {
            this.textureUploaded = true;
            if (this.textureLocation != null) {
                this.deleteGlTexture();
            }
            TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
        }
    }
    
    protected void loadTextureFromServer() {
        this.imageThread = new Thread("Texture Downloader #" + ThreadDownloadImageData.TEXTURE_DOWNLOADER_THREAD_ID.incrementAndGet()) {
            @Override
            public void run() {
                HttpURLConnection llllllllllllIlIIIIIIIlIIlllllIll = null;
                ThreadDownloadImageData.LOGGER.debug("Downloading http texture from {} to {}", (Object)ThreadDownloadImageData.this.imageUrl, (Object)ThreadDownloadImageData.this.cacheFile);
                if (ThreadDownloadImageData.this.shouldPipeline()) {
                    ThreadDownloadImageData.this.loadPipelined();
                }
                else {
                    try {
                        llllllllllllIlIIIIIIIlIIlllllIll = (HttpURLConnection)new URL(ThreadDownloadImageData.this.imageUrl).openConnection(Minecraft.getMinecraft().getProxy());
                        llllllllllllIlIIIIIIIlIIlllllIll.setDoInput(true);
                        llllllllllllIlIIIIIIIlIIlllllIll.setDoOutput(false);
                        llllllllllllIlIIIIIIIlIIlllllIll.connect();
                        if (llllllllllllIlIIIIIIIlIIlllllIll.getResponseCode() / 100 != 2) {
                            if (llllllllllllIlIIIIIIIlIIlllllIll.getErrorStream() != null) {
                                Config.readAll(llllllllllllIlIIIIIIIlIIlllllIll.getErrorStream());
                            }
                            return;
                        }
                        BufferedImage llllllllllllIlIIIIIIIlIIlllllIIl = null;
                        if (ThreadDownloadImageData.this.cacheFile != null) {
                            FileUtils.copyInputStreamToFile(llllllllllllIlIIIIIIIlIIlllllIll.getInputStream(), ThreadDownloadImageData.this.cacheFile);
                            final BufferedImage llllllllllllIlIIIIIIIlIIlllllIlI = ImageIO.read(ThreadDownloadImageData.this.cacheFile);
                        }
                        else {
                            llllllllllllIlIIIIIIIlIIlllllIIl = TextureUtil.readBufferedImage(llllllllllllIlIIIIIIIlIIlllllIll.getInputStream());
                        }
                        if (ThreadDownloadImageData.this.imageBuffer != null) {
                            llllllllllllIlIIIIIIIlIIlllllIIl = ThreadDownloadImageData.this.imageBuffer.parseUserSkin(llllllllllllIlIIIIIIIlIIlllllIIl);
                        }
                        ThreadDownloadImageData.this.setBufferedImage(llllllllllllIlIIIIIIIlIIlllllIIl);
                    }
                    catch (Exception llllllllllllIlIIIIIIIlIIlllllIII) {
                        ThreadDownloadImageData.LOGGER.error("Couldn't download http texture: " + llllllllllllIlIIIIIIIlIIlllllIII.getMessage());
                        return;
                    }
                    finally {
                        if (llllllllllllIlIIIIIIIlIIlllllIll != null) {
                            llllllllllllIlIIIIIIIlIIlllllIll.disconnect();
                        }
                        ThreadDownloadImageData.this.loadingFinished();
                    }
                    if (llllllllllllIlIIIIIIIlIIlllllIll != null) {
                        llllllllllllIlIIIIIIIlIIlllllIll.disconnect();
                    }
                    ThreadDownloadImageData.this.loadingFinished();
                }
            }
        };
        this.imageThread.setDaemon(true);
        this.imageThread.start();
    }
}
