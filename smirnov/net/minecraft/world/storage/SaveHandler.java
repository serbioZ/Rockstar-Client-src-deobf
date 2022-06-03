// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.WorldProvider;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import javax.annotation.Nullable;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import java.io.IOException;
import net.minecraft.world.MinecraftException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.util.datafix.DataFixer;
import java.io.File;

public class SaveHandler implements ISaveHandler, IPlayerFileData
{
    private final /* synthetic */ long initializationTime;
    private final /* synthetic */ File mapDataDir;
    protected final /* synthetic */ DataFixer dataFixer;
    private final /* synthetic */ File worldDirectory;
    private final /* synthetic */ File playersDirectory;
    private final /* synthetic */ TemplateManager structureTemplateManager;
    private final /* synthetic */ String saveDirectoryName;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void checkSessionLock() throws MinecraftException {
        try {
            final File llllllllllIlllIlIlIlIIlIllIIlIII = new File(this.worldDirectory, "session.lock");
            final DataInputStream llllllllllIlllIlIlIlIIlIllIIIlll = new DataInputStream(new FileInputStream(llllllllllIlllIlIlIlIIlIllIIlIII));
            try {
                if (llllllllllIlllIlIlIlIIlIllIIIlll.readLong() != this.initializationTime) {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally {
                llllllllllIlllIlIlIlIIlIllIIIlll.close();
            }
            llllllllllIlllIlIlIlIIlIllIIIlll.close();
        }
        catch (IOException llllllllllIlllIlIlIlIIlIllIIIllI) {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }
    
    @Override
    public String[] getAvailablePlayerDat() {
        String[] llllllllllIlllIlIlIlIIlIIlllIIll = this.playersDirectory.list();
        if (llllllllllIlllIlIlIlIIlIIlllIIll == null) {
            llllllllllIlllIlIlIlIIlIIlllIIll = new String[0];
        }
        for (int llllllllllIlllIlIlIlIIlIIlllIIlI = 0; llllllllllIlllIlIlIlIIlIIlllIIlI < llllllllllIlllIlIlIlIIlIIlllIIll.length; ++llllllllllIlllIlIlIlIIlIIlllIIlI) {
            if (llllllllllIlllIlIlIlIIlIIlllIIll[llllllllllIlllIlIlIlIIlIIlllIIlI].endsWith(".dat")) {
                llllllllllIlllIlIlIlIIlIIlllIIll[llllllllllIlllIlIlIlIIlIIlllIIlI] = llllllllllIlllIlIlIlIIlIIlllIIll[llllllllllIlllIlIlIlIIlIIlllIIlI].substring(0, llllllllllIlllIlIlIlIIlIIlllIIll[llllllllllIlllIlIlIlIIlIIlllIIlI].length() - 4);
            }
        }
        return llllllllllIlllIlIlIlIIlIIlllIIll;
    }
    
    @Nullable
    @Override
    public NBTTagCompound readPlayerData(final EntityPlayer llllllllllIlllIlIlIlIIlIIlllllIl) {
        NBTTagCompound llllllllllIlllIlIlIlIIlIlIIIIIIl = null;
        try {
            final File llllllllllIlllIlIlIlIIlIlIIIIIII = new File(this.playersDirectory, String.valueOf(llllllllllIlllIlIlIlIIlIIlllllIl.getCachedUniqueIdString()) + ".dat");
            if (llllllllllIlllIlIlIlIIlIlIIIIIII.exists() && llllllllllIlllIlIlIlIIlIlIIIIIII.isFile()) {
                llllllllllIlllIlIlIlIIlIlIIIIIIl = CompressedStreamTools.readCompressed(new FileInputStream(llllllllllIlllIlIlIlIIlIlIIIIIII));
            }
        }
        catch (Exception llllllllllIlllIlIlIlIIlIIlllllll) {
            SaveHandler.LOGGER.warn("Failed to load player data for {}", (Object)llllllllllIlllIlIlIlIIlIIlllllIl.getName());
        }
        if (llllllllllIlllIlIlIlIIlIlIIIIIIl != null) {
            llllllllllIlllIlIlIlIIlIIlllllIl.readFromNBT(this.dataFixer.process(FixTypes.PLAYER, llllllllllIlllIlIlIlIIlIlIIIIIIl));
        }
        return llllllllllIlllIlIlIlIIlIlIIIIIIl;
    }
    
    @Override
    public TemplateManager getStructureTemplateManager() {
        return this.structureTemplateManager;
    }
    
    private void setSessionLock() {
        try {
            final File llllllllllIlllIlIlIlIIlIllIlIlll = new File(this.worldDirectory, "session.lock");
            final DataOutputStream llllllllllIlllIlIlIlIIlIllIlIllI = new DataOutputStream(new FileOutputStream(llllllllllIlllIlIlIlIIlIllIlIlll));
            try {
                llllllllllIlllIlIlIlIIlIllIlIllI.writeLong(this.initializationTime);
            }
            finally {
                llllllllllIlllIlIlIlIIlIllIlIllI.close();
            }
            llllllllllIlllIlIlIlIIlIllIlIllI.close();
        }
        catch (IOException llllllllllIlllIlIlIlIIlIllIlIlIl) {
            llllllllllIlllIlIlIlIIlIllIlIlIl.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }
    
    @Nullable
    @Override
    public WorldInfo loadWorldInfo() {
        File llllllllllIlllIlIlIlIIlIlIlllIll = new File(this.worldDirectory, "level.dat");
        if (llllllllllIlllIlIlIlIIlIlIlllIll.exists()) {
            final WorldInfo llllllllllIlllIlIlIlIIlIlIlllIlI = SaveFormatOld.getWorldData(llllllllllIlllIlIlIlIIlIlIlllIll, this.dataFixer);
            if (llllllllllIlllIlIlIlIIlIlIlllIlI != null) {
                return llllllllllIlllIlIlIlIIlIlIlllIlI;
            }
        }
        llllllllllIlllIlIlIlIIlIlIlllIll = new File(this.worldDirectory, "level.dat_old");
        return llllllllllIlllIlIlIlIIlIlIlllIll.exists() ? SaveFormatOld.getWorldData(llllllllllIlllIlIlIlIIlIlIlllIll, this.dataFixer) : null;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider llllllllllIlllIlIlIlIIlIllIIIIII) {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo llllllllllIlllIlIlIlIIlIlIIllIII) {
        this.saveWorldInfoWithPlayer(llllllllllIlllIlIlIlIIlIlIIllIII, null);
    }
    
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return this;
    }
    
    @Override
    public File getMapFileFromName(final String llllllllllIlllIlIlIlIIlIIllIlIII) {
        return new File(this.mapDataDir, String.valueOf(llllllllllIlllIlIlIlIIlIIllIlIII) + ".dat");
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo llllllllllIlllIlIlIlIIlIlIlIllIl, @Nullable final NBTTagCompound llllllllllIlllIlIlIlIIlIlIlIllII) {
        final NBTTagCompound llllllllllIlllIlIlIlIIlIlIlIlIll = llllllllllIlllIlIlIlIIlIlIlIllIl.cloneNBTCompound(llllllllllIlllIlIlIlIIlIlIlIllII);
        final NBTTagCompound llllllllllIlllIlIlIlIIlIlIlIlIlI = new NBTTagCompound();
        llllllllllIlllIlIlIlIIlIlIlIlIlI.setTag("Data", llllllllllIlllIlIlIlIIlIlIlIlIll);
        try {
            final File llllllllllIlllIlIlIlIIlIlIlIlIIl = new File(this.worldDirectory, "level.dat_new");
            final File llllllllllIlllIlIlIlIIlIlIlIlIII = new File(this.worldDirectory, "level.dat_old");
            final File llllllllllIlllIlIlIlIIlIlIlIIlll = new File(this.worldDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(llllllllllIlllIlIlIlIIlIlIlIlIlI, new FileOutputStream(llllllllllIlllIlIlIlIIlIlIlIlIIl));
            if (llllllllllIlllIlIlIlIIlIlIlIlIII.exists()) {
                llllllllllIlllIlIlIlIIlIlIlIlIII.delete();
            }
            llllllllllIlllIlIlIlIIlIlIlIIlll.renameTo(llllllllllIlllIlIlIlIIlIlIlIlIII);
            if (llllllllllIlllIlIlIlIIlIlIlIIlll.exists()) {
                llllllllllIlllIlIlIlIIlIlIlIIlll.delete();
            }
            llllllllllIlllIlIlIlIIlIlIlIlIIl.renameTo(llllllllllIlllIlIlIlIIlIlIlIIlll);
            if (llllllllllIlllIlIlIlIIlIlIlIlIIl.exists()) {
                llllllllllIlllIlIlIlIIlIlIlIlIIl.delete();
            }
        }
        catch (Exception llllllllllIlllIlIlIlIIlIlIlIIllI) {
            llllllllllIlllIlIlIlIIlIlIlIIllI.printStackTrace();
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public SaveHandler(final File llllllllllIlllIlIlIlIIlIlllIIIII, final String llllllllllIlllIlIlIlIIlIllIlllll, final boolean llllllllllIlllIlIlIlIIlIlllIIIll, final DataFixer llllllllllIlllIlIlIlIIlIllIlllIl) {
        this.initializationTime = MinecraftServer.getCurrentTimeMillis();
        this.dataFixer = llllllllllIlllIlIlIlIIlIllIlllIl;
        this.worldDirectory = new File(llllllllllIlllIlIlIlIIlIlllIIIII, llllllllllIlllIlIlIlIIlIllIlllll);
        this.worldDirectory.mkdirs();
        this.playersDirectory = new File(this.worldDirectory, "playerdata");
        this.mapDataDir = new File(this.worldDirectory, "data");
        this.mapDataDir.mkdirs();
        this.saveDirectoryName = llllllllllIlllIlIlIlIIlIllIlllll;
        if (llllllllllIlllIlIlIlIIlIlllIIIll) {
            this.playersDirectory.mkdirs();
            this.structureTemplateManager = new TemplateManager(new File(this.worldDirectory, "structures").toString(), llllllllllIlllIlIlIlIIlIllIlllIl);
        }
        else {
            this.structureTemplateManager = null;
        }
        this.setSessionLock();
    }
    
    @Override
    public File getWorldDirectory() {
        return this.worldDirectory;
    }
    
    @Override
    public void writePlayerData(final EntityPlayer llllllllllIlllIlIlIlIIlIlIIIlIll) {
        try {
            final NBTTagCompound llllllllllIlllIlIlIlIIlIlIIlIIII = llllllllllIlllIlIlIlIIlIlIIIlIll.writeToNBT(new NBTTagCompound());
            final File llllllllllIlllIlIlIlIIlIlIIIllll = new File(this.playersDirectory, String.valueOf(llllllllllIlllIlIlIlIIlIlIIIlIll.getCachedUniqueIdString()) + ".dat.tmp");
            final File llllllllllIlllIlIlIlIIlIlIIIlllI = new File(this.playersDirectory, String.valueOf(llllllllllIlllIlIlIlIIlIlIIIlIll.getCachedUniqueIdString()) + ".dat");
            CompressedStreamTools.writeCompressed(llllllllllIlllIlIlIlIIlIlIIlIIII, new FileOutputStream(llllllllllIlllIlIlIlIIlIlIIIllll));
            if (llllllllllIlllIlIlIlIIlIlIIIlllI.exists()) {
                llllllllllIlllIlIlIlIIlIlIIIlllI.delete();
            }
            llllllllllIlllIlIlIlIIlIlIIIllll.renameTo(llllllllllIlllIlIlIlIIlIlIIIlllI);
        }
        catch (Exception llllllllllIlllIlIlIlIIlIlIIIllIl) {
            SaveHandler.LOGGER.warn("Failed to save player data for {}", (Object)llllllllllIlllIlIlIlIIlIlIIIlIll.getName());
        }
    }
}
