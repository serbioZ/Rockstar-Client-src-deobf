// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.client.AnvilConverterException;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.IProgressUpdate;
import javax.annotation.Nullable;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.nbt.NBTTagCompound;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import net.minecraft.nbt.CompressedStreamTools;
import java.io.FileInputStream;
import java.io.File;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.datafix.DataFixer;

public class SaveFormatOld implements ISaveFormat
{
    protected final /* synthetic */ DataFixer dataFixer;
    private static final /* synthetic */ Logger LOGGER;
    protected final /* synthetic */ File savesDirectory;
    
    @Override
    public boolean deleteWorldDirectory(final String llllllllllllllIlIIllllllIIIlIlIl) {
        final File llllllllllllllIlIIllllllIIIllIII = new File(this.savesDirectory, llllllllllllllIlIIllllllIIIlIlIl);
        if (!llllllllllllllIlIIllllllIIIllIII.exists()) {
            return true;
        }
        SaveFormatOld.LOGGER.info("Deleting level {}", (Object)llllllllllllllIlIIllllllIIIlIlIl);
        for (int llllllllllllllIlIIllllllIIIlIlll = 1; llllllllllllllIlIIllllllIIIlIlll <= 5; ++llllllllllllllIlIIllllllIIIlIlll) {
            SaveFormatOld.LOGGER.info("Attempt {}...", (Object)llllllllllllllIlIIllllllIIIlIlll);
            if (deleteFiles(llllllllllllllIlIIllllllIIIllIII.listFiles())) {
                break;
            }
            SaveFormatOld.LOGGER.warn("Unsuccessful in deleting contents.");
            if (llllllllllllllIlIIllllllIIIlIlll < 5) {
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException ex) {}
            }
        }
        return llllllllllllllIlIIllllllIIIllIII.delete();
    }
    
    @Override
    public void renameWorld(final String llllllllllllllIlIIllllllIIlllIIl, final String llllllllllllllIlIIllllllIIlllIII) {
        final File llllllllllllllIlIIllllllIIllIlll = new File(this.savesDirectory, llllllllllllllIlIIllllllIIlllIIl);
        if (llllllllllllllIlIIllllllIIllIlll.exists()) {
            final File llllllllllllllIlIIllllllIIllIllI = new File(llllllllllllllIlIIllllllIIllIlll, "level.dat");
            if (llllllllllllllIlIIllllllIIllIllI.exists()) {
                try {
                    final NBTTagCompound llllllllllllllIlIIllllllIIllIlIl = CompressedStreamTools.readCompressed(new FileInputStream(llllllllllllllIlIIllllllIIllIllI));
                    final NBTTagCompound llllllllllllllIlIIllllllIIllIlII = llllllllllllllIlIIllllllIIllIlIl.getCompoundTag("Data");
                    llllllllllllllIlIIllllllIIllIlII.setString("LevelName", llllllllllllllIlIIllllllIIlllIII);
                    CompressedStreamTools.writeCompressed(llllllllllllllIlIIllllllIIllIlIl, new FileOutputStream(llllllllllllllIlIIllllllIIllIllI));
                }
                catch (Exception llllllllllllllIlIIllllllIIllIIll) {
                    llllllllllllllIlIIllllllIIllIIll.printStackTrace();
                }
            }
        }
    }
    
    protected static boolean deleteFiles(final File[] llllllllllllllIlIIllllllIIIIlIlI) {
        final Exception llllllllllllllIlIIllllllIIIIIllI = (Object)llllllllllllllIlIIllllllIIIIlIlI;
        final String llllllllllllllIlIIllllllIIIIIlll = (String)llllllllllllllIlIIllllllIIIIlIlI.length;
        for (char llllllllllllllIlIIllllllIIIIlIII = '\0'; llllllllllllllIlIIllllllIIIIlIII < llllllllllllllIlIIllllllIIIIIlll; ++llllllllllllllIlIIllllllIIIIlIII) {
            final File llllllllllllllIlIIllllllIIIIlIll = llllllllllllllIlIIllllllIIIIIllI[llllllllllllllIlIIllllllIIIIlIII];
            SaveFormatOld.LOGGER.debug("Deleting {}", (Object)llllllllllllllIlIIllllllIIIIlIll);
            if (llllllllllllllIlIIllllllIIIIlIll.isDirectory() && !deleteFiles(llllllllllllllIlIIllllllIIIIlIll.listFiles())) {
                SaveFormatOld.LOGGER.warn("Couldn't delete directory {}", (Object)llllllllllllllIlIIllllllIIIIlIll);
                return false;
            }
            if (!llllllllllllllIlIIllllllIIIIlIll.delete()) {
                SaveFormatOld.LOGGER.warn("Couldn't delete file {}", (Object)llllllllllllllIlIIllllllIIIIlIll);
                return false;
            }
        }
        return true;
    }
    
    @Nullable
    public static WorldInfo getWorldData(final File llllllllllllllIlIIllllllIlIIlIlI, final DataFixer llllllllllllllIlIIllllllIlIIlIIl) {
        try {
            final NBTTagCompound llllllllllllllIlIIllllllIlIIlIII = CompressedStreamTools.readCompressed(new FileInputStream(llllllllllllllIlIIllllllIlIIlIlI));
            final NBTTagCompound llllllllllllllIlIIllllllIlIIIlll = llllllllllllllIlIIllllllIlIIlIII.getCompoundTag("Data");
            return new WorldInfo(llllllllllllllIlIIllllllIlIIlIIl.process(FixTypes.LEVEL, llllllllllllllIlIIllllllIlIIIlll));
        }
        catch (Exception llllllllllllllIlIIllllllIlIIIllI) {
            SaveFormatOld.LOGGER.error("Exception reading {}", (Object)llllllllllllllIlIIllllllIlIIlIlI, (Object)llllllllllllllIlIIllllllIlIIIllI);
            return null;
        }
    }
    
    @Override
    public boolean convertMapFormat(final String llllllllllllllIlIIlllllIllllIlll, final IProgressUpdate llllllllllllllIlIIlllllIllllIllI) {
        return false;
    }
    
    @Override
    public boolean isConvertible(final String llllllllllllllIlIIlllllIlllllIll) {
        return false;
    }
    
    @Override
    public boolean isNewLevelIdAcceptable(final String llllllllllllllIlIIllllllIIlIIllI) {
        final File llllllllllllllIlIIllllllIIlIIlIl = new File(this.savesDirectory, llllllllllllllIlIIllllllIIlIIllI);
        if (llllllllllllllIlIIllllllIIlIIlIl.exists()) {
            return false;
        }
        try {
            llllllllllllllIlIIllllllIIlIIlIl.mkdir();
            llllllllllllllIlIIllllllIIlIIlIl.delete();
            return true;
        }
        catch (Throwable llllllllllllllIlIIllllllIIlIIlII) {
            SaveFormatOld.LOGGER.warn("Couldn't make new level", llllllllllllllIlIIllllllIIlIIlII);
            return false;
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public ISaveHandler getSaveLoader(final String llllllllllllllIlIIllllllIIIIIIIl, final boolean llllllllllllllIlIIllllllIIIIIIII) {
        return new SaveHandler(this.savesDirectory, llllllllllllllIlIIllllllIIIIIIIl, llllllllllllllIlIIllllllIIIIIIII, this.dataFixer);
    }
    
    @Override
    public File getFile(final String llllllllllllllIlIIlllllIlllIlIII, final String llllllllllllllIlIIlllllIlllIIlll) {
        return new File(new File(this.savesDirectory, llllllllllllllIlIIlllllIlllIlIII), llllllllllllllIlIIlllllIlllIIlll);
    }
    
    @Override
    public List<WorldSummary> getSaveList() throws AnvilConverterException {
        final List<WorldSummary> llllllllllllllIlIIllllllIllIIlll = (List<WorldSummary>)Lists.newArrayList();
        for (int llllllllllllllIlIIllllllIllIIllI = 0; llllllllllllllIlIIllllllIllIIllI < 5; ++llllllllllllllIlIIllllllIllIIllI) {
            final String llllllllllllllIlIIllllllIllIIlIl = "World" + (llllllllllllllIlIIllllllIllIIllI + 1);
            final WorldInfo llllllllllllllIlIIllllllIllIIlII = this.getWorldInfo(llllllllllllllIlIIllllllIllIIlIl);
            if (llllllllllllllIlIIllllllIllIIlII != null) {
                llllllllllllllIlIIllllllIllIIlll.add(new WorldSummary(llllllllllllllIlIIllllllIllIIlII, llllllllllllllIlIIllllllIllIIlIl, "", llllllllllllllIlIIllllllIllIIlII.getSizeOnDisk(), false));
            }
        }
        return llllllllllllllIlIIllllllIllIIlll;
    }
    
    @Override
    public boolean canLoadWorld(final String llllllllllllllIlIIlllllIlllIlllI) {
        final File llllllllllllllIlIIlllllIllllIIII = new File(this.savesDirectory, llllllllllllllIlIIlllllIlllIlllI);
        return llllllllllllllIlIIlllllIllllIIII.isDirectory();
    }
    
    @Override
    public void flushCache() {
    }
    
    @Override
    public String getName() {
        return "Old Format";
    }
    
    public SaveFormatOld(final File llllllllllllllIlIIllllllIlllIIII, final DataFixer llllllllllllllIlIIllllllIllIllll) {
        this.dataFixer = llllllllllllllIlIIllllllIllIllll;
        if (!llllllllllllllIlIIllllllIlllIIII.exists()) {
            llllllllllllllIlIIllllllIlllIIII.mkdirs();
        }
        this.savesDirectory = llllllllllllllIlIIllllllIlllIIII;
    }
    
    @Nullable
    @Override
    public WorldInfo getWorldInfo(final String llllllllllllllIlIIllllllIlIlIIlI) {
        final File llllllllllllllIlIIllllllIlIlIllI = new File(this.savesDirectory, llllllllllllllIlIIllllllIlIlIIlI);
        if (!llllllllllllllIlIIllllllIlIlIllI.exists()) {
            return null;
        }
        File llllllllllllllIlIIllllllIlIlIlIl = new File(llllllllllllllIlIIllllllIlIlIllI, "level.dat");
        if (llllllllllllllIlIIllllllIlIlIlIl.exists()) {
            final WorldInfo llllllllllllllIlIIllllllIlIlIlII = getWorldData(llllllllllllllIlIIllllllIlIlIlIl, this.dataFixer);
            if (llllllllllllllIlIIllllllIlIlIlII != null) {
                return llllllllllllllIlIIllllllIlIlIlII;
            }
        }
        llllllllllllllIlIIllllllIlIlIlIl = new File(llllllllllllllIlIIllllllIlIlIllI, "level.dat_old");
        return llllllllllllllIlIIllllllIlIlIlIl.exists() ? getWorldData(llllllllllllllIlIIllllllIlIlIlIl, this.dataFixer) : null;
    }
    
    @Override
    public boolean isOldMapFormat(final String llllllllllllllIlIIlllllIlllllIIl) {
        return false;
    }
}
