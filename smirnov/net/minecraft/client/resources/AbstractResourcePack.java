// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import java.io.File;
import org.apache.logging.log4j.Logger;

public abstract class AbstractResourcePack implements IResourcePack
{
    private static final /* synthetic */ Logger LOGGER;
    public final /* synthetic */ File resourcePackFile;
    
    public AbstractResourcePack(final File lllllllllllllIlIlIIlIIIllIIlIIlI) {
        this.resourcePackFile = lllllllllllllIlIlIIlIIIllIIlIIlI;
    }
    
    protected static String getRelativeName(final File lllllllllllllIlIlIIlIIIllIIIlIlI, final File lllllllllllllIlIlIIlIIIllIIIlIll) {
        return lllllllllllllIlIlIIlIIIllIIIlIlI.toURI().relativize(lllllllllllllIlIlIIlIIIllIIIlIll.toURI()).getPath();
    }
    
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllllIlIlIIlIIIlIlllIIlI, final String lllllllllllllIlIlIIlIIIlIllIlllI) throws IOException {
        return readMetadata(lllllllllllllIlIlIIlIIIlIlllIIlI, this.getInputStreamByName("pack.mcmeta"), lllllllllllllIlIlIIlIIIlIllIlllI);
    }
    
    protected abstract InputStream getInputStreamByName(final String p0) throws IOException;
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
    }
    
    protected abstract boolean hasResourceName(final String p0);
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllllIlIlIIlIIIllIIIIlIl) throws IOException {
        return this.getInputStreamByName(locationToName(lllllllllllllIlIlIIlIIIllIIIIlIl));
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllllIlIlIIlIIIlIlllllIl) {
        return this.hasResourceName(locationToName(lllllllllllllIlIlIIlIIIlIlllllIl));
    }
    
    protected void logNameNotLowercase(final String lllllllllllllIlIlIIlIIIlIlllIlll) {
        AbstractResourcePack.LOGGER.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", (Object)lllllllllllllIlIlIIlIIIlIlllIlll, (Object)this.resourcePackFile);
    }
    
    static <T extends IMetadataSection> T readMetadata(final MetadataSerializer lllllllllllllIlIlIIlIIIlIllIIIII, final InputStream lllllllllllllIlIlIIlIIIlIllIIlIl, final String lllllllllllllIlIlIIlIIIlIllIIlII) {
        JsonObject lllllllllllllIlIlIIlIIIlIllIIIll = null;
        BufferedReader lllllllllllllIlIlIIlIIIlIllIIIlI = null;
        try {
            lllllllllllllIlIlIIlIIIlIllIIIlI = new BufferedReader(new InputStreamReader(lllllllllllllIlIlIIlIIIlIllIIlIl, StandardCharsets.UTF_8));
            lllllllllllllIlIlIIlIIIlIllIIIll = new JsonParser().parse((Reader)lllllllllllllIlIlIIlIIIlIllIIIlI).getAsJsonObject();
        }
        catch (RuntimeException lllllllllllllIlIlIIlIIIlIllIIIIl) {
            throw new JsonParseException((Throwable)lllllllllllllIlIlIIlIIIlIllIIIIl);
        }
        finally {
            IOUtils.closeQuietly((Reader)lllllllllllllIlIlIIlIIIlIllIIIlI);
        }
        IOUtils.closeQuietly((Reader)lllllllllllllIlIlIIlIIIlIllIIIlI);
        return lllllllllllllIlIlIIlIIIlIllIIIII.parseMetadataSection(lllllllllllllIlIlIIlIIIlIllIIlII, lllllllllllllIlIlIIlIIIlIllIIIll);
    }
    
    private static String locationToName(final ResourceLocation lllllllllllllIlIlIIlIIIllIIlIIII) {
        return String.format("%s/%s/%s", "assets", lllllllllllllIlIlIIlIIIllIIlIIII.getResourceDomain(), lllllllllllllIlIlIIlIIIllIIlIIII.getResourcePath());
    }
    
    @Override
    public String getPackName() {
        return this.resourcePackFile.getName();
    }
}
