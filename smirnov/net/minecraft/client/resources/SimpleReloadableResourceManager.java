// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import com.google.common.collect.Sets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import java.io.FileNotFoundException;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Set;
import com.google.common.base.Joiner;
import java.util.Map;
import net.minecraft.client.resources.data.MetadataSerializer;

public class SimpleReloadableResourceManager implements IReloadableResourceManager
{
    private final /* synthetic */ MetadataSerializer rmMetadataSerializer;
    private final /* synthetic */ Map<String, FallbackResourceManager> domainResourceManagers;
    private static final /* synthetic */ Joiner JOINER_RESOURCE_PACKS;
    private final /* synthetic */ Set<String> setResourceDomains;
    private final /* synthetic */ List<IResourceManagerReloadListener> reloadListeners;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public List<IResource> getAllResources(final ResourceLocation lllllllllllllIIIlIIIIlIlIlllIlll) throws IOException {
        final IResourceManager lllllllllllllIIIlIIIIlIlIlllIllI = this.domainResourceManagers.get(lllllllllllllIIIlIIIIlIlIlllIlll.getResourceDomain());
        if (lllllllllllllIIIlIIIIlIlIlllIllI != null) {
            return lllllllllllllIIIlIIIIlIlIlllIllI.getAllResources(lllllllllllllIIIlIIIIlIlIlllIlll);
        }
        throw new FileNotFoundException(lllllllllllllIIIlIIIIlIlIlllIlll.toString());
    }
    
    static {
        LOGGER = LogManager.getLogger();
        JOINER_RESOURCE_PACKS = Joiner.on(", ");
    }
    
    private void clearResources() {
        this.domainResourceManagers.clear();
        this.setResourceDomains.clear();
    }
    
    @Override
    public void registerReloadListener(final IResourceManagerReloadListener lllllllllllllIIIlIIIIlIlIlIlllll) {
        this.reloadListeners.add(lllllllllllllIIIlIIIIlIlIlIlllll);
        lllllllllllllIIIlIIIIlIlIlIlllll.onResourceManagerReload(this);
    }
    
    @Override
    public void reloadResources(final List<IResourcePack> lllllllllllllIIIlIIIIlIlIllIlIlI) {
        this.clearResources();
        SimpleReloadableResourceManager.LOGGER.info("Reloading ResourceManager: {}", (Object)SimpleReloadableResourceManager.JOINER_RESOURCE_PACKS.join(Iterables.transform((Iterable)lllllllllllllIIIlIIIIlIlIllIlIlI, (Function)new Function<IResourcePack, String>() {
            public String apply(@Nullable final IResourcePack lllllllllllIIIlIllIlllIlllIIllIl) {
                return (lllllllllllIIIlIllIlllIlllIIllIl == null) ? "<NULL>" : lllllllllllIIIlIllIlllIlllIIllIl.getPackName();
            }
        })));
        for (final IResourcePack lllllllllllllIIIlIIIIlIlIllIlIIl : lllllllllllllIIIlIIIIlIlIllIlIlI) {
            this.reloadResourcePack(lllllllllllllIIIlIIIIlIlIllIlIIl);
        }
        this.notifyReloadListeners();
    }
    
    private void notifyReloadListeners() {
        for (final IResourceManagerReloadListener lllllllllllllIIIlIIIIlIlIlIllIlI : this.reloadListeners) {
            lllllllllllllIIIlIIIIlIlIlIllIlI.onResourceManagerReload(this);
        }
    }
    
    public void reloadResourcePack(final IResourcePack lllllllllllllIIIlIIIIlIllIIIlIll) {
        for (final String lllllllllllllIIIlIIIIlIllIIIlllI : lllllllllllllIIIlIIIIlIllIIIlIll.getResourceDomains()) {
            this.setResourceDomains.add(lllllllllllllIIIlIIIIlIllIIIlllI);
            FallbackResourceManager lllllllllllllIIIlIIIIlIllIIIllIl = this.domainResourceManagers.get(lllllllllllllIIIlIIIIlIllIIIlllI);
            if (lllllllllllllIIIlIIIIlIllIIIllIl == null) {
                lllllllllllllIIIlIIIIlIllIIIllIl = new FallbackResourceManager(this.rmMetadataSerializer);
                this.domainResourceManagers.put(lllllllllllllIIIlIIIIlIllIIIlllI, lllllllllllllIIIlIIIIlIllIIIllIl);
            }
            lllllllllllllIIIlIIIIlIllIIIllIl.addResourcePack(lllllllllllllIIIlIIIIlIllIIIlIll);
        }
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return this.setResourceDomains;
    }
    
    @Override
    public IResource getResource(final ResourceLocation lllllllllllllIIIlIIIIlIlIlllllIl) throws IOException {
        final IResourceManager lllllllllllllIIIlIIIIlIlIlllllll = this.domainResourceManagers.get(lllllllllllllIIIlIIIIlIlIlllllIl.getResourceDomain());
        if (lllllllllllllIIIlIIIIlIlIlllllll != null) {
            return lllllllllllllIIIlIIIIlIlIlllllll.getResource(lllllllllllllIIIlIIIIlIlIlllllIl);
        }
        throw new FileNotFoundException(lllllllllllllIIIlIIIIlIlIlllllIl.toString());
    }
    
    public SimpleReloadableResourceManager(final MetadataSerializer lllllllllllllIIIlIIIIlIllIIlIllI) {
        this.domainResourceManagers = (Map<String, FallbackResourceManager>)Maps.newHashMap();
        this.reloadListeners = (List<IResourceManagerReloadListener>)Lists.newArrayList();
        this.setResourceDomains = (Set<String>)Sets.newLinkedHashSet();
        this.rmMetadataSerializer = lllllllllllllIIIlIIIIlIllIIlIllI;
    }
}
