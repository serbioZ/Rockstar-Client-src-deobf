// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.client.renderer.texture.TextureUtil;
import java.awt.image.BufferedImage;
import java.net.URL;
import optifine.ReflectorForge;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.Util;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import net.minecraft.util.ResourceLocation;
import java.util.Set;

public class DefaultResourcePack implements IResourcePack
{
    private final /* synthetic */ ResourceIndex resourceIndex;
    public static final /* synthetic */ Set<String> DEFAULT_RESOURCE_DOMAINS;
    private static final /* synthetic */ boolean ON_WINDOWS;
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllIIlIllIlIIlllIllIIIII) throws IOException {
        final InputStream lllllllllllIIlIllIlIIlllIlIlllll = this.getInputStreamAssets(lllllllllllIIlIllIlIIlllIllIIIII);
        if (lllllllllllIIlIllIlIIlllIlIlllll != null) {
            return lllllllllllIIlIllIlIIlllIlIlllll;
        }
        final InputStream lllllllllllIIlIllIlIIlllIlIllllI = this.getResourceStream(lllllllllllIIlIllIlIIlllIllIIIII);
        if (lllllllllllIIlIllIlIIlllIlIllllI != null) {
            return lllllllllllIIlIllIlIIlllIlIllllI;
        }
        throw new FileNotFoundException(lllllllllllIIlIllIlIIlllIllIIIII.getResourcePath());
    }
    
    @Nullable
    public InputStream getInputStreamAssets(final ResourceLocation lllllllllllIIlIllIlIIlllIlIlIIlI) throws FileNotFoundException, IOException {
        final File lllllllllllIIlIllIlIIlllIlIlIlII = this.resourceIndex.getFile(lllllllllllIIlIllIlIIlllIlIlIIlI);
        return (lllllllllllIIlIllIlIIlllIlIlIlII != null && lllllllllllIIlIllIlIIlllIlIlIlII.isFile()) ? new FileInputStream(lllllllllllIIlIllIlIIlllIlIlIlII) : null;
    }
    
    static {
        DEFAULT_RESOURCE_DOMAINS = (Set)ImmutableSet.of((Object)"minecraft", (Object)"realms");
        ON_WINDOWS = (Util.getOSType() == Util.EnumOS.WINDOWS);
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllIIlIllIlIIlllIIllllIl) {
        return this.getResourceStream(lllllllllllIIlIllIlIIlllIIllllIl) != null || this.resourceIndex.isFileExisting(lllllllllllIIlIllIlIIlllIIllllIl);
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllIIlIllIlIIlllIIlIlllI, final String lllllllllllIIlIllIlIIlllIIllIIll) throws IOException {
        try {
            final InputStream lllllllllllIIlIllIlIIlllIIllIIlI = new FileInputStream(this.resourceIndex.getPackMcmeta());
            return AbstractResourcePack.readMetadata(lllllllllllIIlIllIlIIlllIIlIlllI, lllllllllllIIlIllIlIIlllIIllIIlI, lllllllllllIIlIllIlIIlllIIllIIll);
        }
        catch (RuntimeException lllllllllllIIlIllIlIIlllIIllIIIl) {
            return null;
        }
        catch (FileNotFoundException lllllllllllIIlIllIlIIlllIIllIIII) {
            return null;
        }
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return DefaultResourcePack.DEFAULT_RESOURCE_DOMAINS;
    }
    
    @Override
    public String getPackName() {
        return "Default";
    }
    
    @Nullable
    private InputStream getResourceStream(final ResourceLocation lllllllllllIIlIllIlIIlllIlIIlIlI) {
        final String lllllllllllIIlIllIlIIlllIlIIlIIl = "/assets/" + lllllllllllIIlIllIlIIlllIlIIlIlI.getResourceDomain() + "/" + lllllllllllIIlIllIlIIlllIlIIlIlI.getResourcePath();
        final InputStream lllllllllllIIlIllIlIIlllIlIIlIII = ReflectorForge.getOptiFineResourceStream(lllllllllllIIlIllIlIIlllIlIIlIIl);
        if (lllllllllllIIlIllIlIIlllIlIIlIII != null) {
            return lllllllllllIIlIllIlIIlllIlIIlIII;
        }
        try {
            final URL lllllllllllIIlIllIlIIlllIlIIIlll = DefaultResourcePack.class.getResource(lllllllllllIIlIllIlIIlllIlIIlIIl);
            return (lllllllllllIIlIllIlIIlllIlIIIlll != null && this.validatePath(new File(lllllllllllIIlIllIlIIlllIlIIIlll.getFile()), lllllllllllIIlIllIlIIlllIlIIlIIl)) ? DefaultResourcePack.class.getResourceAsStream(lllllllllllIIlIllIlIIlllIlIIlIIl) : null;
        }
        catch (IOException lllllllllllIIlIllIlIIlllIlIIIllI) {
            return DefaultResourcePack.class.getResourceAsStream(lllllllllllIIlIllIlIIlllIlIIlIIl);
        }
    }
    
    public DefaultResourcePack(final ResourceIndex lllllllllllIIlIllIlIIlllIllIIllI) {
        this.resourceIndex = lllllllllllIIlIllIlIIlllIllIIllI;
    }
    
    private boolean validatePath(final File lllllllllllIIlIllIlIIlllIIlIIlIl, final String lllllllllllIIlIllIlIIlllIIlIIlII) throws IOException {
        String lllllllllllIIlIllIlIIlllIIlIIIll = lllllllllllIIlIllIlIIlllIIlIIlIl.getPath();
        if (lllllllllllIIlIllIlIIlllIIlIIIll.startsWith("file:")) {
            if (DefaultResourcePack.ON_WINDOWS) {
                lllllllllllIIlIllIlIIlllIIlIIIll = lllllllllllIIlIllIlIIlllIIlIIIll.replace("\\", "/");
            }
            return lllllllllllIIlIllIlIIlllIIlIIIll.endsWith(lllllllllllIIlIllIlIIlllIIlIIlII);
        }
        return FolderResourcePack.func_191384_a(lllllllllllIIlIllIlIIlllIIlIIlIl, lllllllllllIIlIllIlIIlllIIlIIlII);
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(DefaultResourcePack.class.getResourceAsStream("/" + new ResourceLocation("pack.png").getResourcePath()));
    }
}
