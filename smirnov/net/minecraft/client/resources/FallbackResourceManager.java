// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import java.util.Collections;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.resources.data.MetadataSerializer;
import java.util.List;

public class FallbackResourceManager implements IResourceManager
{
    protected final /* synthetic */ List<IResourcePack> resourcePacks;
    private final /* synthetic */ MetadataSerializer frmMetadataSerializer;
    private static final /* synthetic */ Logger LOGGER;
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return Collections.emptySet();
    }
    
    static ResourceLocation getLocationMcmeta(final ResourceLocation lllllllllllIIIlIIllIlIllIllllllI) {
        return new ResourceLocation(lllllllllllIIIlIIllIlIllIllllllI.getResourceDomain(), String.valueOf(lllllllllllIIIlIIllIlIllIllllllI.getResourcePath()) + ".mcmeta");
    }
    
    @Override
    public List<IResource> getAllResources(final ResourceLocation lllllllllllIIIlIIllIlIlllIIIllII) throws IOException {
        this.checkResourcePath(lllllllllllIIIlIIllIlIlllIIIllII);
        final List<IResource> lllllllllllIIIlIIllIlIlllIIIlIll = (List<IResource>)Lists.newArrayList();
        final ResourceLocation lllllllllllIIIlIIllIlIlllIIIlIlI = getLocationMcmeta(lllllllllllIIIlIIllIlIlllIIIllII);
        for (final IResourcePack lllllllllllIIIlIIllIlIlllIIIlIIl : this.resourcePacks) {
            if (lllllllllllIIIlIIllIlIlllIIIlIIl.resourceExists(lllllllllllIIIlIIllIlIlllIIIllII)) {
                final InputStream lllllllllllIIIlIIllIlIlllIIIlIII = lllllllllllIIIlIIllIlIlllIIIlIIl.resourceExists(lllllllllllIIIlIIllIlIlllIIIlIlI) ? this.getInputStream(lllllllllllIIIlIIllIlIlllIIIlIlI, lllllllllllIIIlIIllIlIlllIIIlIIl) : null;
                lllllllllllIIIlIIllIlIlllIIIlIll.add(new SimpleResource(lllllllllllIIIlIIllIlIlllIIIlIIl.getPackName(), lllllllllllIIIlIIllIlIlllIIIllII, this.getInputStream(lllllllllllIIIlIIllIlIlllIIIllII, lllllllllllIIIlIIllIlIlllIIIlIIl), lllllllllllIIIlIIllIlIlllIIIlIII, this.frmMetadataSerializer));
            }
        }
        if (lllllllllllIIIlIIllIlIlllIIIlIll.isEmpty()) {
            throw new FileNotFoundException(lllllllllllIIIlIIllIlIlllIIIllII.toString());
        }
        return lllllllllllIIIlIIllIlIlllIIIlIll;
    }
    
    public void addResourcePack(final IResourcePack lllllllllllIIIlIIllIlIlllIlllIll) {
        this.resourcePacks.add(lllllllllllIIIlIIllIlIlllIlllIll);
    }
    
    protected InputStream getInputStream(final ResourceLocation lllllllllllIIIlIIllIlIlllIIllllI, final IResourcePack lllllllllllIIIlIIllIlIlllIIllIlI) throws IOException {
        final InputStream lllllllllllIIIlIIllIlIlllIIlllII = lllllllllllIIIlIIllIlIlllIIllIlI.getInputStream(lllllllllllIIIlIIllIlIlllIIllllI);
        return FallbackResourceManager.LOGGER.isDebugEnabled() ? new InputStreamLeakedResourceLogger(lllllllllllIIIlIIllIlIlllIIlllII, lllllllllllIIIlIIllIlIlllIIllllI, lllllllllllIIIlIIllIlIlllIIllIlI.getPackName()) : lllllllllllIIIlIIllIlIlllIIlllII;
    }
    
    private void checkResourcePath(final ResourceLocation lllllllllllIIIlIIllIlIlllIIlIllI) throws IOException {
        if (lllllllllllIIIlIIllIlIlllIIlIllI.getResourcePath().contains("..")) {
            throw new IOException("Invalid relative path to resource: " + lllllllllllIIIlIIllIlIlllIIlIllI);
        }
    }
    
    public FallbackResourceManager(final MetadataSerializer lllllllllllIIIlIIllIlIlllIllllll) {
        this.resourcePacks = (List<IResourcePack>)Lists.newArrayList();
        this.frmMetadataSerializer = lllllllllllIIIlIIllIlIlllIllllll;
    }
    
    @Override
    public IResource getResource(final ResourceLocation lllllllllllIIIlIIllIlIlllIlIlIII) throws IOException {
        this.checkResourcePath(lllllllllllIIIlIIllIlIlllIlIlIII);
        IResourcePack lllllllllllIIIlIIllIlIlllIlIlllI = null;
        final ResourceLocation lllllllllllIIIlIIllIlIlllIlIllIl = getLocationMcmeta(lllllllllllIIIlIIllIlIlllIlIlIII);
        for (int lllllllllllIIIlIIllIlIlllIlIllII = this.resourcePacks.size() - 1; lllllllllllIIIlIIllIlIlllIlIllII >= 0; --lllllllllllIIIlIIllIlIlllIlIllII) {
            final IResourcePack lllllllllllIIIlIIllIlIlllIlIlIll = this.resourcePacks.get(lllllllllllIIIlIIllIlIlllIlIllII);
            if (lllllllllllIIIlIIllIlIlllIlIlllI == null && lllllllllllIIIlIIllIlIlllIlIlIll.resourceExists(lllllllllllIIIlIIllIlIlllIlIllIl)) {
                lllllllllllIIIlIIllIlIlllIlIlllI = lllllllllllIIIlIIllIlIlllIlIlIll;
            }
            if (lllllllllllIIIlIIllIlIlllIlIlIll.resourceExists(lllllllllllIIIlIIllIlIlllIlIlIII)) {
                InputStream lllllllllllIIIlIIllIlIlllIlIlIlI = null;
                if (lllllllllllIIIlIIllIlIlllIlIlllI != null) {
                    lllllllllllIIIlIIllIlIlllIlIlIlI = this.getInputStream(lllllllllllIIIlIIllIlIlllIlIllIl, lllllllllllIIIlIIllIlIlllIlIlllI);
                }
                return new SimpleResource(lllllllllllIIIlIIllIlIlllIlIlIll.getPackName(), lllllllllllIIIlIIllIlIlllIlIlIII, this.getInputStream(lllllllllllIIIlIIllIlIlllIlIlIII, lllllllllllIIIlIIllIlIlllIlIlIll), lllllllllllIIIlIIllIlIlllIlIlIlI, this.frmMetadataSerializer);
            }
        }
        throw new FileNotFoundException(lllllllllllIIIlIIllIlIlllIlIlIII.toString());
    }
    
    static class InputStreamLeakedResourceLogger extends InputStream
    {
        private /* synthetic */ boolean isClosed;
        private final /* synthetic */ InputStream inputStream;
        private final /* synthetic */ String message;
        
        @Override
        public void close() throws IOException {
            this.inputStream.close();
            this.isClosed = true;
        }
        
        public InputStreamLeakedResourceLogger(final InputStream lllllllllllIllIlIIIIllIlIllIIllI, final ResourceLocation lllllllllllIllIlIIIIllIlIllIlIlI, final String lllllllllllIllIlIIIIllIlIllIIlII) {
            this.inputStream = lllllllllllIllIlIIIIllIlIllIIllI;
            final ByteArrayOutputStream lllllllllllIllIlIIIIllIlIllIlIII = new ByteArrayOutputStream();
            new Exception().printStackTrace(new PrintStream(lllllllllllIllIlIIIIllIlIllIlIII));
            this.message = "Leaked resource: '" + lllllllllllIllIlIIIIllIlIllIlIlI + "' loaded from pack: '" + lllllllllllIllIlIIIIllIlIllIIlII + "'\n" + lllllllllllIllIlIIIIllIlIllIlIII;
        }
        
        @Override
        protected void finalize() throws Throwable {
            if (!this.isClosed) {
                FallbackResourceManager.LOGGER.warn(this.message);
            }
            super.finalize();
        }
        
        @Override
        public int read() throws IOException {
            return this.inputStream.read();
        }
    }
}
