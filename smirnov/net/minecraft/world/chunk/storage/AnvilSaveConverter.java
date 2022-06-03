// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.text.translation.I18n;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import net.minecraft.world.storage.WorldSummary;
import java.util.List;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataOutput;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.storage.ISaveHandler;
import java.util.Collections;
import java.io.FilenameFilter;
import java.util.Collection;
import java.io.File;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.storage.SaveFormatOld;

public class AnvilSaveConverter extends SaveFormatOld
{
    private static final /* synthetic */ Logger LOGGER;
    
    private void addRegionFilesToCollection(final File lllllllllllIlIIlIIlIIlIlIllIIlIl, final Collection<File> lllllllllllIlIIlIIlIIlIlIllIIlII) {
        final File lllllllllllIlIIlIIlIIlIlIllIlIII = new File(lllllllllllIlIIlIIlIIlIlIllIIlIl, "region");
        final File[] lllllllllllIlIIlIIlIIlIlIllIIlll = lllllllllllIlIIlIIlIIlIlIllIlIII.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File lllllllllllIllIIIIIIllIlIIIlIllI, final String lllllllllllIllIIIIIIllIlIIIlIlII) {
                return lllllllllllIllIIIIIIllIlIIIlIlII.endsWith(".mcr");
            }
        });
        if (lllllllllllIlIIlIIlIIlIlIllIIlll != null) {
            Collections.addAll(lllllllllllIlIIlIIlIIlIlIllIIlII, lllllllllllIlIIlIIlIIlIlIllIIlll);
        }
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String lllllllllllIlIIlIIlIIllIIIIlIIlI, final boolean lllllllllllIlIIlIIlIIllIIIIlIIIl) {
        return new AnvilSaveHandler(this.savesDirectory, lllllllllllIlIIlIIlIIllIIIIlIIlI, lllllllllllIlIIlIIlIIllIIIIlIIIl, this.dataFixer);
    }
    
    protected int getSaveVersion() {
        return 19133;
    }
    
    private void createFile(final String lllllllllllIlIIlIIlIIlIlllIlIIII) {
        final File lllllllllllIlIIlIIlIIlIlllIIllll = new File(this.savesDirectory, lllllllllllIlIIlIIlIIlIlllIlIIII);
        if (!lllllllllllIlIIlIIlIIlIlllIIllll.exists()) {
            AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
        }
        else {
            final File lllllllllllIlIIlIIlIIlIlllIIlllI = new File(lllllllllllIlIIlIIlIIlIlllIIllll, "level.dat");
            if (!lllllllllllIlIIlIIlIIlIlllIIlllI.exists()) {
                AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
            }
            else {
                final File lllllllllllIlIIlIIlIIlIlllIIllIl = new File(lllllllllllIlIIlIIlIIlIlllIIllll, "level.dat_mcr");
                if (!lllllllllllIlIIlIIlIIlIlllIIlllI.renameTo(lllllllllllIlIIlIIlIIlIlllIIllIl)) {
                    AnvilSaveConverter.LOGGER.warn("Unable to create level.dat_mcr backup");
                }
            }
        }
    }
    
    private void convertChunks(final File lllllllllllIlIIlIIlIIlIllIIlIlll, final File lllllllllllIlIIlIIlIIlIllIIlIllI, final BiomeProvider lllllllllllIlIIlIIlIIlIllIIIIIII, final int lllllllllllIlIIlIIlIIlIllIIlIlII, final int lllllllllllIlIIlIIlIIlIllIIlIIll, final IProgressUpdate lllllllllllIlIIlIIlIIlIllIIlIIlI) {
        try {
            final String lllllllllllIlIIlIIlIIlIllIIlIIIl = lllllllllllIlIIlIIlIIlIllIIlIllI.getName();
            final RegionFile lllllllllllIlIIlIIlIIlIllIIlIIII = new RegionFile(lllllllllllIlIIlIIlIIlIllIIlIllI);
            final RegionFile lllllllllllIlIIlIIlIIlIllIIIllll = new RegionFile(new File(lllllllllllIlIIlIIlIIlIllIIlIlll, String.valueOf(lllllllllllIlIIlIIlIIlIllIIlIIIl.substring(0, lllllllllllIlIIlIIlIIlIllIIlIIIl.length() - ".mcr".length())) + ".mca"));
            for (int lllllllllllIlIIlIIlIIlIllIIIlllI = 0; lllllllllllIlIIlIIlIIlIllIIIlllI < 32; ++lllllllllllIlIIlIIlIIlIllIIIlllI) {
                for (int lllllllllllIlIIlIIlIIlIllIIIllIl = 0; lllllllllllIlIIlIIlIIlIllIIIllIl < 32; ++lllllllllllIlIIlIIlIIlIllIIIllIl) {
                    if (lllllllllllIlIIlIIlIIlIllIIlIIII.isChunkSaved(lllllllllllIlIIlIIlIIlIllIIIlllI, lllllllllllIlIIlIIlIIlIllIIIllIl) && !lllllllllllIlIIlIIlIIlIllIIIllll.isChunkSaved(lllllllllllIlIIlIIlIIlIllIIIlllI, lllllllllllIlIIlIIlIIlIllIIIllIl)) {
                        final DataInputStream lllllllllllIlIIlIIlIIlIllIIIllII = lllllllllllIlIIlIIlIIlIllIIlIIII.getChunkDataInputStream(lllllllllllIlIIlIIlIIlIllIIIlllI, lllllllllllIlIIlIIlIIlIllIIIllIl);
                        if (lllllllllllIlIIlIIlIIlIllIIIllII == null) {
                            AnvilSaveConverter.LOGGER.warn("Failed to fetch input stream");
                        }
                        else {
                            final NBTTagCompound lllllllllllIlIIlIIlIIlIllIIIlIll = CompressedStreamTools.read(lllllllllllIlIIlIIlIIlIllIIIllII);
                            lllllllllllIlIIlIIlIIlIllIIIllII.close();
                            final NBTTagCompound lllllllllllIlIIlIIlIIlIllIIIlIlI = lllllllllllIlIIlIIlIIlIllIIIlIll.getCompoundTag("Level");
                            final ChunkLoader.AnvilConverterData lllllllllllIlIIlIIlIIlIllIIIlIIl = ChunkLoader.load(lllllllllllIlIIlIIlIIlIllIIIlIlI);
                            final NBTTagCompound lllllllllllIlIIlIIlIIlIllIIIlIII = new NBTTagCompound();
                            final NBTTagCompound lllllllllllIlIIlIIlIIlIllIIIIlll = new NBTTagCompound();
                            lllllllllllIlIIlIIlIIlIllIIIlIII.setTag("Level", lllllllllllIlIIlIIlIIlIllIIIIlll);
                            ChunkLoader.convertToAnvilFormat(lllllllllllIlIIlIIlIIlIllIIIlIIl, lllllllllllIlIIlIIlIIlIllIIIIlll, lllllllllllIlIIlIIlIIlIllIIIIIII);
                            final DataOutputStream lllllllllllIlIIlIIlIIlIllIIIIllI = lllllllllllIlIIlIIlIIlIllIIIllll.getChunkDataOutputStream(lllllllllllIlIIlIIlIIlIllIIIlllI, lllllllllllIlIIlIIlIIlIllIIIllIl);
                            CompressedStreamTools.write(lllllllllllIlIIlIIlIIlIllIIIlIII, lllllllllllIlIIlIIlIIlIllIIIIllI);
                            lllllllllllIlIIlIIlIIlIllIIIIllI.close();
                        }
                    }
                }
                final int lllllllllllIlIIlIIlIIlIllIIIIlIl = (int)Math.round(100.0 * (lllllllllllIlIIlIIlIIlIllIIlIlII * 1024) / (lllllllllllIlIIlIIlIIlIllIIlIIll * 1024));
                final int lllllllllllIlIIlIIlIIlIllIIIIlII = (int)Math.round(100.0 * ((lllllllllllIlIIlIIlIIlIllIIIlllI + 1) * 32 + lllllllllllIlIIlIIlIIlIllIIlIlII * 1024) / (lllllllllllIlIIlIIlIIlIllIIlIIll * 1024));
                if (lllllllllllIlIIlIIlIIlIllIIIIlII > lllllllllllIlIIlIIlIIlIllIIIIlIl) {
                    lllllllllllIlIIlIIlIIlIllIIlIIlI.setLoadingProgress(lllllllllllIlIIlIIlIIlIllIIIIlII);
                }
            }
            lllllllllllIlIIlIIlIIlIllIIlIIII.close();
            lllllllllllIlIIlIIlIIlIllIIIllll.close();
        }
        catch (IOException lllllllllllIlIIlIIlIIlIllIIIIIll) {
            lllllllllllIlIIlIIlIIlIllIIIIIll.printStackTrace();
        }
    }
    
    @Override
    public List<WorldSummary> getSaveList() throws AnvilConverterException {
        if (this.savesDirectory != null && this.savesDirectory.exists() && this.savesDirectory.isDirectory()) {
            final List<WorldSummary> lllllllllllIlIIlIIlIIllIIIlIllll = (List<WorldSummary>)Lists.newArrayList();
            final File[] lllllllllllIlIIlIIlIIllIIIlIlllI = this.savesDirectory.listFiles();
            final int lllllllllllIlIIlIIlIIllIIIlIIIIl;
            final long lllllllllllIlIIlIIlIIllIIIlIIIlI = ((File[])(Object)(lllllllllllIlIIlIIlIIllIIIlIIIIl = (int)(Object)lllllllllllIlIIlIIlIIllIIIlIlllI)).length;
            for (char lllllllllllIlIIlIIlIIllIIIlIIIll = '\0'; lllllllllllIlIIlIIlIIllIIIlIIIll < lllllllllllIlIIlIIlIIllIIIlIIIlI; ++lllllllllllIlIIlIIlIIllIIIlIIIll) {
                final File lllllllllllIlIIlIIlIIllIIIlIllIl = lllllllllllIlIIlIIlIIllIIIlIIIIl[lllllllllllIlIIlIIlIIllIIIlIIIll];
                if (lllllllllllIlIIlIIlIIllIIIlIllIl.isDirectory()) {
                    final String lllllllllllIlIIlIIlIIllIIIlIllII = lllllllllllIlIIlIIlIIllIIIlIllIl.getName();
                    final WorldInfo lllllllllllIlIIlIIlIIllIIIlIlIll = this.getWorldInfo(lllllllllllIlIIlIIlIIllIIIlIllII);
                    if (lllllllllllIlIIlIIlIIllIIIlIlIll != null && (lllllllllllIlIIlIIlIIllIIIlIlIll.getSaveVersion() == 19132 || lllllllllllIlIIlIIlIIllIIIlIlIll.getSaveVersion() == 19133)) {
                        final boolean lllllllllllIlIIlIIlIIllIIIlIlIlI = lllllllllllIlIIlIIlIIllIIIlIlIll.getSaveVersion() != this.getSaveVersion();
                        String lllllllllllIlIIlIIlIIllIIIlIlIIl = lllllllllllIlIIlIIlIIllIIIlIlIll.getWorldName();
                        if (StringUtils.isEmpty((CharSequence)lllllllllllIlIIlIIlIIllIIIlIlIIl)) {
                            lllllllllllIlIIlIIlIIllIIIlIlIIl = lllllllllllIlIIlIIlIIllIIIlIllII;
                        }
                        final long lllllllllllIlIIlIIlIIllIIIlIlIII = 0L;
                        lllllllllllIlIIlIIlIIllIIIlIllll.add(new WorldSummary(lllllllllllIlIIlIIlIIllIIIlIlIll, lllllllllllIlIIlIIlIIllIIIlIllII, lllllllllllIlIIlIIlIIllIIIlIlIIl, 0L, lllllllllllIlIIlIIlIIllIIIlIlIlI));
                    }
                }
            }
            return lllllllllllIlIIlIIlIIllIIIlIllll;
        }
        throw new AnvilConverterException(I18n.translateToLocal("selectWorld.load_folder_access"));
    }
    
    @Override
    public void flushCache() {
        RegionFileCache.clearRegionFileReferences();
    }
    
    @Override
    public boolean isConvertible(final String lllllllllllIlIIlIIlIIllIIIIIllII) {
        final WorldInfo lllllllllllIlIIlIIlIIllIIIIIlIll = this.getWorldInfo(lllllllllllIlIIlIIlIIllIIIIIllII);
        return lllllllllllIlIIlIIlIIllIIIIIlIll != null && lllllllllllIlIIlIIlIIllIIIIIlIll.getSaveVersion() == 19132;
    }
    
    public AnvilSaveConverter(final File lllllllllllIlIIlIIlIIllIIIllllll, final DataFixer lllllllllllIlIIlIIlIIllIIIlllllI) {
        super(lllllllllllIlIIlIIlIIllIIIllllll, lllllllllllIlIIlIIlIIllIIIlllllI);
    }
    
    @Override
    public String getName() {
        return "Anvil";
    }
    
    @Override
    public boolean isOldMapFormat(final String lllllllllllIlIIlIIlIIllIIIIIIIII) {
        final WorldInfo lllllllllllIlIIlIIlIIllIIIIIIIlI = this.getWorldInfo(lllllllllllIlIIlIIlIIllIIIIIIIII);
        return lllllllllllIlIIlIIlIIllIIIIIIIlI != null && lllllllllllIlIIlIIlIIllIIIIIIIlI.getSaveVersion() != this.getSaveVersion();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private void convertFile(final File lllllllllllIlIIlIIlIIlIllIllllII, final Iterable<File> lllllllllllIlIIlIIlIIlIllIllIIlI, final BiomeProvider lllllllllllIlIIlIIlIIlIllIllIIIl, int lllllllllllIlIIlIIlIIlIllIllIIII, final int lllllllllllIlIIlIIlIIlIllIlllIII, final IProgressUpdate lllllllllllIlIIlIIlIIlIllIllIlll) {
        for (final File lllllllllllIlIIlIIlIIlIllIllIllI : lllllllllllIlIIlIIlIIlIllIllIIlI) {
            this.convertChunks(lllllllllllIlIIlIIlIIlIllIllllII, lllllllllllIlIIlIIlIIlIllIllIllI, lllllllllllIlIIlIIlIIlIllIllIIIl, lllllllllllIlIIlIIlIIlIllIllIIII, lllllllllllIlIIlIIlIIlIllIlllIII, lllllllllllIlIIlIIlIIlIllIllIlll);
            ++lllllllllllIlIIlIIlIIlIllIllIIII;
            final int lllllllllllIlIIlIIlIIlIllIllIlIl = (int)Math.round(100.0 * lllllllllllIlIIlIIlIIlIllIllIIII / lllllllllllIlIIlIIlIIlIllIlllIII);
            lllllllllllIlIIlIIlIIlIllIllIlll.setLoadingProgress(lllllllllllIlIIlIIlIIlIllIllIlIl);
        }
    }
    
    @Override
    public boolean convertMapFormat(final String lllllllllllIlIIlIIlIIlIllllIIIlI, final IProgressUpdate lllllllllllIlIIlIIlIIlIllllIIIIl) {
        lllllllllllIlIIlIIlIIlIllllIIIIl.setLoadingProgress(0);
        final List<File> lllllllllllIlIIlIIlIIlIllllIlllI = (List<File>)Lists.newArrayList();
        final List<File> lllllllllllIlIIlIIlIIlIllllIllIl = (List<File>)Lists.newArrayList();
        final List<File> lllllllllllIlIIlIIlIIlIllllIllII = (List<File>)Lists.newArrayList();
        final File lllllllllllIlIIlIIlIIlIllllIlIll = new File(this.savesDirectory, lllllllllllIlIIlIIlIIlIllllIIIlI);
        final File lllllllllllIlIIlIIlIIlIllllIlIlI = new File(lllllllllllIlIIlIIlIIlIllllIlIll, "DIM-1");
        final File lllllllllllIlIIlIIlIIlIllllIlIIl = new File(lllllllllllIlIIlIIlIIlIllllIlIll, "DIM1");
        AnvilSaveConverter.LOGGER.info("Scanning folders...");
        this.addRegionFilesToCollection(lllllllllllIlIIlIIlIIlIllllIlIll, lllllllllllIlIIlIIlIIlIllllIlllI);
        if (lllllllllllIlIIlIIlIIlIllllIlIlI.exists()) {
            this.addRegionFilesToCollection(lllllllllllIlIIlIIlIIlIllllIlIlI, lllllllllllIlIIlIIlIIlIllllIllIl);
        }
        if (lllllllllllIlIIlIIlIIlIllllIlIIl.exists()) {
            this.addRegionFilesToCollection(lllllllllllIlIIlIIlIIlIllllIlIIl, lllllllllllIlIIlIIlIIlIllllIllII);
        }
        final int lllllllllllIlIIlIIlIIlIllllIlIII = lllllllllllIlIIlIIlIIlIllllIlllI.size() + lllllllllllIlIIlIIlIIlIllllIllIl.size() + lllllllllllIlIIlIIlIIlIllllIllII.size();
        AnvilSaveConverter.LOGGER.info("Total conversion count is {}", (Object)lllllllllllIlIIlIIlIIlIllllIlIII);
        final WorldInfo lllllllllllIlIIlIIlIIlIllllIIlll = this.getWorldInfo(lllllllllllIlIIlIIlIIlIllllIIIlI);
        BiomeProvider lllllllllllIlIIlIIlIIlIllllIIlIl = null;
        if (lllllllllllIlIIlIIlIIlIllllIIlll != null && lllllllllllIlIIlIIlIIlIllllIIlll.getTerrainType() == WorldType.FLAT) {
            final BiomeProvider lllllllllllIlIIlIIlIIlIllllIIllI = new BiomeProviderSingle(Biomes.PLAINS);
        }
        else {
            lllllllllllIlIIlIIlIIlIllllIIlIl = new BiomeProvider(lllllllllllIlIIlIIlIIlIllllIIlll);
        }
        this.convertFile(new File(lllllllllllIlIIlIIlIIlIllllIlIll, "region"), lllllllllllIlIIlIIlIIlIllllIlllI, lllllllllllIlIIlIIlIIlIllllIIlIl, 0, lllllllllllIlIIlIIlIIlIllllIlIII, lllllllllllIlIIlIIlIIlIllllIIIIl);
        this.convertFile(new File(lllllllllllIlIIlIIlIIlIllllIlIlI, "region"), lllllllllllIlIIlIIlIIlIllllIllIl, new BiomeProviderSingle(Biomes.HELL), lllllllllllIlIIlIIlIIlIllllIlllI.size(), lllllllllllIlIIlIIlIIlIllllIlIII, lllllllllllIlIIlIIlIIlIllllIIIIl);
        this.convertFile(new File(lllllllllllIlIIlIIlIIlIllllIlIIl, "region"), lllllllllllIlIIlIIlIIlIllllIllII, new BiomeProviderSingle(Biomes.SKY), lllllllllllIlIIlIIlIIlIllllIlllI.size() + lllllllllllIlIIlIIlIIlIllllIllIl.size(), lllllllllllIlIIlIIlIIlIllllIlIII, lllllllllllIlIIlIIlIIlIllllIIIIl);
        lllllllllllIlIIlIIlIIlIllllIIlll.setSaveVersion(19133);
        if (lllllllllllIlIIlIIlIIlIllllIIlll.getTerrainType() == WorldType.DEFAULT_1_1) {
            lllllllllllIlIIlIIlIIlIllllIIlll.setTerrainType(WorldType.DEFAULT);
        }
        this.createFile(lllllllllllIlIIlIIlIIlIllllIIIlI);
        final ISaveHandler lllllllllllIlIIlIIlIIlIllllIIlII = this.getSaveLoader(lllllllllllIlIIlIIlIIlIllllIIIlI, false);
        lllllllllllIlIIlIIlIIlIllllIIlII.saveWorldInfo(lllllllllllIlIIlIIlIIlIllllIIlll);
        return true;
    }
}
