// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.text.TextFormatting;
import org.apache.commons.io.IOUtils;
import java.io.Closeable;
import com.google.common.util.concurrent.FutureCallback;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.HttpUtil;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Future;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenWorking;
import java.util.Iterator;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.resources.data.PackMetadataSection;
import org.apache.logging.log4j.LogManager;
import java.util.Locale;
import java.io.InputStream;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.FileInputStream;
import com.google.common.util.concurrent.Futures;
import java.util.Comparator;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import com.google.common.collect.Maps;
import java.util.Map;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;
import com.google.common.collect.Lists;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import com.google.common.util.concurrent.ListenableFuture;
import net.minecraft.client.resources.data.MetadataSerializer;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import java.util.regex.Pattern;
import java.io.FileFilter;
import java.io.File;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.locks.ReentrantLock;

public class ResourcePackRepository
{
    private final /* synthetic */ ReentrantLock lock;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ File dirResourcepacks;
    private final /* synthetic */ File dirServerResourcepacks;
    public final /* synthetic */ IResourcePack rprDefaultResourcePack;
    private static final /* synthetic */ FileFilter RESOURCE_PACK_FILTER;
    private static final /* synthetic */ Pattern SHA1;
    private /* synthetic */ IResourcePack resourcePackInstance;
    private static final /* synthetic */ ResourceLocation field_191400_f;
    public final /* synthetic */ List<Entry> repositoryEntries;
    public final /* synthetic */ MetadataSerializer rprMetadataSerializer;
    private /* synthetic */ List<Entry> repositoryEntriesAll;
    private /* synthetic */ ListenableFuture<Object> downloadingPacks;
    
    public void clearResourcePack() {
        this.lock.lock();
        try {
            if (this.downloadingPacks != null) {
                this.downloadingPacks.cancel(true);
            }
            this.downloadingPacks = null;
            if (this.resourcePackInstance != null) {
                this.resourcePackInstance = null;
                Minecraft.getMinecraft().scheduleResourcesRefresh();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    public void setRepositories(final List<Entry> lllllllllllIIIlIlllIlIIIIllllIll) {
        this.repositoryEntries.clear();
        this.repositoryEntries.addAll(lllllllllllIIIlIlllIlIIIIllllIll);
    }
    
    public void updateRepositoryEntriesAll() {
        final List<Entry> lllllllllllIIIlIlllIlIIIlIIllIlI = (List<Entry>)Lists.newArrayList();
        for (final File lllllllllllIIIlIlllIlIIIlIIllIIl : this.getResourcePackFiles()) {
            final Entry lllllllllllIIIlIlllIlIIIlIIllIII = new Entry(lllllllllllIIIlIlllIlIIIlIIllIIl, (Entry)null);
            if (this.repositoryEntriesAll.contains(lllllllllllIIIlIlllIlIIIlIIllIII)) {
                final int lllllllllllIIIlIlllIlIIIlIIlIlll = this.repositoryEntriesAll.indexOf(lllllllllllIIIlIlllIlIIIlIIllIII);
                if (lllllllllllIIIlIlllIlIIIlIIlIlll <= -1 || lllllllllllIIIlIlllIlIIIlIIlIlll >= this.repositoryEntriesAll.size()) {
                    continue;
                }
                lllllllllllIIIlIlllIlIIIlIIllIlI.add(this.repositoryEntriesAll.get(lllllllllllIIIlIlllIlIIIlIIlIlll));
            }
            else {
                try {
                    lllllllllllIIIlIlllIlIIIlIIllIII.updateResourcePack();
                    lllllllllllIIIlIlllIlIIIlIIllIlI.add(lllllllllllIIIlIlllIlIIIlIIllIII);
                }
                catch (Exception lllllllllllIIIlIlllIlIIIlIIlIllI) {
                    lllllllllllIIIlIlllIlIIIlIIllIlI.remove(lllllllllllIIIlIlllIlIIIlIIllIII);
                }
            }
        }
        this.repositoryEntriesAll.removeAll(lllllllllllIIIlIlllIlIIIlIIllIlI);
        for (final Entry lllllllllllIIIlIlllIlIIIlIIlIlIl : this.repositoryEntriesAll) {
            lllllllllllIIIlIlllIlIIIlIIlIlIl.closeResourcePack();
        }
        this.repositoryEntriesAll = lllllllllllIIIlIlllIlIIIlIIllIlI;
    }
    
    private List<File> getResourcePackFiles() {
        return this.dirResourcepacks.isDirectory() ? Arrays.asList(this.dirResourcepacks.listFiles(ResourcePackRepository.RESOURCE_PACK_FILTER)) : Collections.emptyList();
    }
    
    @Nullable
    public Entry getResourcePackEntry() {
        if (this.resourcePackInstance != null) {
            final Entry lllllllllllIIIlIlllIlIIIlIIIlIlI = new Entry(this.resourcePackInstance, (Entry)null);
            try {
                lllllllllllIIIlIlllIlIIIlIIIlIlI.updateResourcePack();
                return lllllllllllIIIlIlllIlIIIlIIIlIlI;
            }
            catch (IOException ex) {}
        }
        return null;
    }
    
    public List<Entry> getRepositoryEntries() {
        return (List<Entry>)ImmutableList.copyOf((Collection)this.repositoryEntries);
    }
    
    public static Map<String, String> getDownloadHeaders() {
        final Map<String, String> lllllllllllIIIlIlllIlIIIlIllIllI = (Map<String, String>)Maps.newHashMap();
        lllllllllllIIIlIlllIlIIIlIllIllI.put("X-Minecraft-Username", Minecraft.getMinecraft().getSession().getUsername());
        lllllllllllIIIlIlllIlIIIlIllIllI.put("X-Minecraft-UUID", Minecraft.getMinecraft().getSession().getPlayerID());
        lllllllllllIIIlIlllIlIIIlIllIllI.put("X-Minecraft-Version", "1.12.2");
        return lllllllllllIIIlIlllIlIIIlIllIllI;
    }
    
    private void fixDirResourcepacks() {
        if (this.dirResourcepacks.exists()) {
            if (!this.dirResourcepacks.isDirectory() && (!this.dirResourcepacks.delete() || !this.dirResourcepacks.mkdirs())) {
                ResourcePackRepository.LOGGER.warn("Unable to recreate resourcepack folder, it exists but is not a directory: {}", (Object)this.dirResourcepacks);
            }
        }
        else if (!this.dirResourcepacks.mkdirs()) {
            ResourcePackRepository.LOGGER.warn("Unable to create resourcepack folder: {}", (Object)this.dirResourcepacks);
        }
    }
    
    private void deleteOldServerResourcesPacks() {
        try {
            final List<File> lllllllllllIIIlIlllIlIIIIIllIIII = (List<File>)Lists.newArrayList((Iterable)FileUtils.listFiles(this.dirServerResourcepacks, TrueFileFilter.TRUE, (IOFileFilter)null));
            Collections.sort(lllllllllllIIIlIlllIlIIIIIllIIII, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            int lllllllllllIIIlIlllIlIIIIIlIllll = 0;
            for (final File lllllllllllIIIlIlllIlIIIIIlIlllI : lllllllllllIIIlIlllIlIIIIIllIIII) {
                if (lllllllllllIIIlIlllIlIIIIIlIllll++ >= 10) {
                    ResourcePackRepository.LOGGER.info("Deleting old server resource pack {}", (Object)lllllllllllIIIlIlllIlIIIIIlIlllI.getName());
                    FileUtils.deleteQuietly(lllllllllllIIIlIlllIlIIIIIlIlllI);
                }
            }
        }
        catch (IllegalArgumentException lllllllllllIIIlIlllIlIIIIIlIllIl) {
            ResourcePackRepository.LOGGER.error("Error while deleting old server resource pack : {}", (Object)lllllllllllIIIlIlllIlIIIIIlIllIl.getMessage());
        }
    }
    
    public ListenableFuture<Object> setResourcePackInstance(final File lllllllllllIIIlIlllIlIIIIIlIIlII) {
        if (!this.validatePack(lllllllllllIIIlIlllIlIIIIIlIIlII)) {
            return (ListenableFuture<Object>)Futures.immediateFailedFuture((Throwable)new RuntimeException("Invalid resourcepack"));
        }
        this.resourcePackInstance = new FileResourcePack(lllllllllllIIIlIlllIlIIIIIlIIlII);
        return Minecraft.getMinecraft().scheduleResourcesRefresh();
    }
    
    private boolean validatePack(final File lllllllllllIIIlIlllIlIIIIIlllIIl) {
        final Entry lllllllllllIIIlIlllIlIIIIIllllII = new Entry(lllllllllllIIIlIlllIlIIIIIlllIIl, (Entry)null);
        try {
            lllllllllllIIIlIlllIlIIIIIllllII.updateResourcePack();
            return true;
        }
        catch (Exception lllllllllllIIIlIlllIlIIIIIlllIll) {
            ResourcePackRepository.LOGGER.warn("Server resourcepack is invalid, ignoring it", (Throwable)lllllllllllIIIlIlllIlIIIIIlllIll);
            return false;
        }
    }
    
    public List<Entry> getRepositoryEntriesAll() {
        return (List<Entry>)ImmutableList.copyOf((Collection)this.repositoryEntriesAll);
    }
    
    @Nullable
    public IResourcePack getResourcePackInstance() {
        return this.resourcePackInstance;
    }
    
    public File getDirResourcepacks() {
        return this.dirResourcepacks;
    }
    
    private boolean checkHash(final String lllllllllllIIIlIlllIlIIIIlIIIlIl, final File lllllllllllIIIlIlllIlIIIIlIIIlII) {
        try {
            final String lllllllllllIIIlIlllIlIIIIlIIIlll = DigestUtils.sha1Hex((InputStream)new FileInputStream(lllllllllllIIIlIlllIlIIIIlIIIlII));
            if (lllllllllllIIIlIlllIlIIIIlIIIlIl.isEmpty()) {
                ResourcePackRepository.LOGGER.info("Found file {} without verification hash", (Object)lllllllllllIIIlIlllIlIIIIlIIIlII);
                return true;
            }
            if (lllllllllllIIIlIlllIlIIIIlIIIlll.toLowerCase(Locale.ROOT).equals(lllllllllllIIIlIlllIlIIIIlIIIlIl.toLowerCase(Locale.ROOT))) {
                ResourcePackRepository.LOGGER.info("Found file {} matching requested hash {}", (Object)lllllllllllIIIlIlllIlIIIIlIIIlII, (Object)lllllllllllIIIlIlllIlIIIIlIIIlIl);
                return true;
            }
            ResourcePackRepository.LOGGER.warn("File {} had wrong hash (expected {}, found {}).", (Object)lllllllllllIIIlIlllIlIIIIlIIIlII, (Object)lllllllllllIIIlIlllIlIIIIlIIIlIl, (Object)lllllllllllIIIlIlllIlIIIIlIIIlll);
        }
        catch (IOException lllllllllllIIIlIlllIlIIIIlIIIllI) {
            ResourcePackRepository.LOGGER.warn("File {} couldn't be hashed.", (Object)lllllllllllIIIlIlllIlIIIIlIIIlII, (Object)lllllllllllIIIlIlllIlIIIIlIIIllI);
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RESOURCE_PACK_FILTER = new FileFilter() {
            @Override
            public boolean accept(final File lllllllllllIIllIllIlllIIllllllII) {
                final boolean lllllllllllIIllIllIlllIIlllllllI = lllllllllllIIllIllIlllIIllllllII.isFile() && lllllllllllIIllIllIlllIIllllllII.getName().endsWith(".zip");
                final boolean lllllllllllIIllIllIlllIIllllllIl = lllllllllllIIllIllIlllIIllllllII.isDirectory() && new File(lllllllllllIIllIllIlllIIllllllII, "pack.mcmeta").isFile();
                return lllllllllllIIllIllIlllIIlllllllI || lllllllllllIIllIllIlllIIllllllIl;
            }
        };
        SHA1 = Pattern.compile("^[a-fA-F0-9]{40}$");
        field_191400_f = new ResourceLocation("textures/misc/unknown_pack.png");
    }
    
    private IResourcePack func_191399_b(final File lllllllllllIIIlIlllIlIIIlIlIIlII) {
        IResourcePack lllllllllllIIIlIlllIlIIIlIlIIlll = null;
        if (lllllllllllIIIlIlllIlIIIlIlIIlII.isDirectory()) {
            final IResourcePack lllllllllllIIIlIlllIlIIIlIlIlIII = new FolderResourcePack(lllllllllllIIIlIlllIlIIIlIlIIlII);
        }
        else {
            lllllllllllIIIlIlllIlIIIlIlIIlll = new FileResourcePack(lllllllllllIIIlIlllIlIIIlIlIIlII);
        }
        try {
            final PackMetadataSection lllllllllllIIIlIlllIlIIIlIlIIllI = lllllllllllIIIlIlllIlIIIlIlIIlll.getPackMetadata(this.rprMetadataSerializer, "pack");
            if (lllllllllllIIIlIlllIlIIIlIlIIllI != null && lllllllllllIIIlIlllIlIIIlIlIIllI.getPackFormat() == 2) {
                return new LegacyV2Adapter(lllllllllllIIIlIlllIlIIIlIlIIlll);
            }
        }
        catch (Exception ex) {}
        return lllllllllllIIIlIlllIlIIIlIlIIlll;
    }
    
    public ResourcePackRepository(final File lllllllllllIIIlIlllIlIIIllIIIIII, final File lllllllllllIIIlIlllIlIIIlIllllll, final IResourcePack lllllllllllIIIlIlllIlIIIllIIIlll, final MetadataSerializer lllllllllllIIIlIlllIlIIIlIllllIl, final GameSettings lllllllllllIIIlIlllIlIIIllIIIlIl) {
        this.lock = new ReentrantLock();
        this.repositoryEntriesAll = (List<Entry>)Lists.newArrayList();
        this.repositoryEntries = (List<Entry>)Lists.newArrayList();
        this.dirResourcepacks = lllllllllllIIIlIlllIlIIIllIIIIII;
        this.dirServerResourcepacks = lllllllllllIIIlIlllIlIIIlIllllll;
        this.rprDefaultResourcePack = lllllllllllIIIlIlllIlIIIllIIIlll;
        this.rprMetadataSerializer = lllllllllllIIIlIlllIlIIIlIllllIl;
        this.fixDirResourcepacks();
        this.updateRepositoryEntriesAll();
        final Iterator<String> lllllllllllIIIlIlllIlIIIllIIIlII = lllllllllllIIIlIlllIlIIIllIIIlIl.resourcePacks.iterator();
        while (lllllllllllIIIlIlllIlIIIllIIIlII.hasNext()) {
            final String lllllllllllIIIlIlllIlIIIllIIIIll = lllllllllllIIIlIlllIlIIIllIIIlII.next();
            for (final Entry lllllllllllIIIlIlllIlIIIllIIIIlI : this.repositoryEntriesAll) {
                if (lllllllllllIIIlIlllIlIIIllIIIIlI.getResourcePackName().equals(lllllllllllIIIlIlllIlIIIllIIIIll)) {
                    if (lllllllllllIIIlIlllIlIIIllIIIIlI.getPackFormat() == 3 || lllllllllllIIIlIlllIlIIIllIIIlIl.incompatibleResourcePacks.contains(lllllllllllIIIlIlllIlIIIllIIIIlI.getResourcePackName())) {
                        this.repositoryEntries.add(lllllllllllIIIlIlllIlIIIllIIIIlI);
                        break;
                    }
                    lllllllllllIIIlIlllIlIIIllIIIlII.remove();
                    ResourcePackRepository.LOGGER.warn("Removed selected resource pack {} because it's no longer compatible", (Object)lllllllllllIIIlIlllIlIIIllIIIIlI.getResourcePackName());
                }
            }
        }
    }
    
    public ListenableFuture<Object> downloadResourcePack(final String lllllllllllIIIlIlllIlIIIIllIlIII, final String lllllllllllIIIlIlllIlIIIIlIllIIl) {
        final String lllllllllllIIIlIlllIlIIIIllIIllI = DigestUtils.sha1Hex(lllllllllllIIIlIlllIlIIIIllIlIII);
        final String lllllllllllIIIlIlllIlIIIIllIIlIl = ResourcePackRepository.SHA1.matcher(lllllllllllIIIlIlllIlIIIIlIllIIl).matches() ? lllllllllllIIIlIlllIlIIIIlIllIIl : "";
        final File lllllllllllIIIlIlllIlIIIIllIIlII = new File(this.dirServerResourcepacks, lllllllllllIIIlIlllIlIIIIllIIllI);
        this.lock.lock();
        try {
            this.clearResourcePack();
            if (lllllllllllIIIlIlllIlIIIIllIIlII.exists()) {
                if (this.checkHash(lllllllllllIIIlIlllIlIIIIllIIlIl, lllllllllllIIIlIlllIlIIIIllIIlII)) {
                    final ListenableFuture lllllllllllIIIlIlllIlIIIIllIIIll = this.setResourcePackInstance(lllllllllllIIIlIlllIlIIIIllIIlII);
                    final float lllllllllllIIIlIlllIlIIIIlIIlllI;
                    final ListenableFuture lllllllllllIIIlIlllIlIIIIllIIIlI = (ListenableFuture)(lllllllllllIIIlIlllIlIIIIlIIlllI = (float)lllllllllllIIIlIlllIlIIIIllIIIll);
                    return (ListenableFuture<Object>)lllllllllllIIIlIlllIlIIIIlIIlllI;
                }
                ResourcePackRepository.LOGGER.warn("Deleting file {}", (Object)lllllllllllIIIlIlllIlIIIIllIIlII);
                FileUtils.deleteQuietly(lllllllllllIIIlIlllIlIIIIllIIlII);
            }
            this.deleteOldServerResourcesPacks();
            final GuiScreenWorking lllllllllllIIIlIlllIlIIIIllIIIIl = new GuiScreenWorking();
            final Map<String, String> lllllllllllIIIlIlllIlIIIIllIIIII = getDownloadHeaders();
            final Minecraft lllllllllllIIIlIlllIlIIIIlIlllll = Minecraft.getMinecraft();
            Futures.getUnchecked((Future)lllllllllllIIIlIlllIlIIIIlIlllll.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    lllllllllllIIIlIlllIlIIIIlIlllll.displayGuiScreen(lllllllllllIIIlIlllIlIIIIllIIIIl);
                }
            }));
            final SettableFuture<Object> lllllllllllIIIlIlllIlIIIIlIllllI = (SettableFuture<Object>)SettableFuture.create();
            this.downloadingPacks = HttpUtil.downloadResourcePack(lllllllllllIIIlIlllIlIIIIllIIlII, lllllllllllIIIlIlllIlIIIIllIlIII, lllllllllllIIIlIlllIlIIIIllIIIII, 52428800, lllllllllllIIIlIlllIlIIIIllIIIIl, lllllllllllIIIlIlllIlIIIIlIlllll.getProxy());
            Futures.addCallback((ListenableFuture)this.downloadingPacks, (FutureCallback)new FutureCallback<Object>() {
                public void onSuccess(@Nullable final Object llllllllllllIIlIIllllIIlllllllIl) {
                    if (ResourcePackRepository.this.checkHash(lllllllllllIIIlIlllIlIIIIllIIlIl, lllllllllllIIIlIlllIlIIIIllIIlII)) {
                        ResourcePackRepository.this.setResourcePackInstance(lllllllllllIIIlIlllIlIIIIllIIlII);
                        lllllllllllIIIlIlllIlIIIIlIllllI.set((Object)null);
                    }
                    else {
                        ResourcePackRepository.LOGGER.warn("Deleting file {}", (Object)lllllllllllIIIlIlllIlIIIIllIIlII);
                        FileUtils.deleteQuietly(lllllllllllIIIlIlllIlIIIIllIIlII);
                    }
                }
                
                public void onFailure(final Throwable llllllllllllIIlIIllllIIllllllIII) {
                    FileUtils.deleteQuietly(lllllllllllIIIlIlllIlIIIIllIIlII);
                    lllllllllllIIIlIlllIlIIIIlIllllI.setException(llllllllllllIIlIIllllIIllllllIII);
                }
            });
            final ListenableFuture lllllllllllIIIlIlllIlIIIIlIlllIl = this.downloadingPacks;
            float lllllllllllIIIlIlllIlIIIIlIIlllI;
            final ListenableFuture lllllllllllIIIlIlllIlIIIIlIlllII = (ListenableFuture)(lllllllllllIIIlIlllIlIIIIlIIlllI = (float)lllllllllllIIIlIlllIlIIIIlIlllIl);
            return (ListenableFuture<Object>)lllllllllllIIIlIlllIlIIIIlIIlllI;
        }
        finally {
            this.lock.unlock();
        }
    }
    
    public class Entry
    {
        private final /* synthetic */ IResourcePack reResourcePack;
        private /* synthetic */ ResourceLocation locationTexturePackIcon;
        private /* synthetic */ PackMetadataSection rePackMetadataSection;
        
        public int getPackFormat() {
            return (this.rePackMetadataSection == null) ? 0 : this.rePackMetadataSection.getPackFormat();
        }
        
        private Entry(final IResourcePack llllllllllIlllIlIlIlIIllIlIIIlll) {
            this.reResourcePack = llllllllllIlllIlIlIlIIllIlIIIlll;
        }
        
        public String getResourcePackName() {
            return this.reResourcePack.getPackName();
        }
        
        public void closeResourcePack() {
            if (this.reResourcePack instanceof Closeable) {
                IOUtils.closeQuietly((Closeable)this.reResourcePack);
            }
        }
        
        @Override
        public String toString() {
            return String.format("%s:%s", this.reResourcePack.getPackName(), (this.reResourcePack instanceof FolderResourcePack) ? "folder" : "zip");
        }
        
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
        
        private Entry(final ResourcePackRepository llllllllllIlllIlIlIlIIllIlIIllIl, final File llllllllllIlllIlIlIlIIllIlIIllII) {
            this(llllllllllIlllIlIlIlIIllIlIIllIl, llllllllllIlllIlIlIlIIllIlIIllIl.func_191399_b(llllllllllIlllIlIlIlIIllIlIIllII));
        }
        
        public String getTexturePackDescription() {
            return (this.rePackMetadataSection == null) ? (TextFormatting.RED + "Invalid pack.mcmeta (or missing 'pack' section)") : this.rePackMetadataSection.getPackDescription().getFormattedText();
        }
        
        @Override
        public boolean equals(final Object llllllllllIlllIlIlIlIIllIIlIIIlI) {
            return this == llllllllllIlllIlIlIlIIllIIlIIIlI || (llllllllllIlllIlIlIlIIllIIlIIIlI instanceof Entry && this.toString().equals(llllllllllIlllIlIlIlIIllIIlIIIlI.toString()));
        }
        
        public void updateResourcePack() throws IOException {
            this.rePackMetadataSection = this.reResourcePack.getPackMetadata(ResourcePackRepository.this.rprMetadataSerializer, "pack");
            this.closeResourcePack();
        }
        
        public IResourcePack getResourcePack() {
            return this.reResourcePack;
        }
        
        public void bindTexturePackIcon(final TextureManager llllllllllIlllIlIlIlIIllIIllIlll) {
            BufferedImage llllllllllIlllIlIlIlIIllIIlllIlI = null;
            if (this.locationTexturePackIcon == null) {
                try {
                    llllllllllIlllIlIlIlIIllIIlllIlI = this.reResourcePack.getPackImage();
                }
                catch (IOException ex) {}
                if (llllllllllIlllIlIlIlIIllIIlllIlI == null) {
                    try {
                        llllllllllIlllIlIlIlIIllIIlllIlI = TextureUtil.readBufferedImage(Minecraft.getMinecraft().getResourceManager().getResource(ResourcePackRepository.field_191400_f).getInputStream());
                    }
                    catch (IOException llllllllllIlllIlIlIlIIllIIlllIIl) {
                        throw new Error("Couldn't bind resource pack icon", llllllllllIlllIlIlIlIIllIIlllIIl);
                    }
                }
            }
            if (this.locationTexturePackIcon == null) {
                this.locationTexturePackIcon = llllllllllIlllIlIlIlIIllIIllIlll.getDynamicTextureLocation("texturepackicon", new DynamicTexture(llllllllllIlllIlIlIlIIllIIlllIlI));
            }
            llllllllllIlllIlIlIlIIllIIllIlll.bindTexture(this.locationTexturePackIcon);
        }
    }
}
