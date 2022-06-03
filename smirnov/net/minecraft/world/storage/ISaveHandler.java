// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.Nullable;
import java.io.File;

public interface ISaveHandler
{
    void saveWorldInfo(final WorldInfo p0);
    
    File getMapFileFromName(final String p0);
    
    IPlayerFileData getPlayerNBTManager();
    
    @Nullable
    WorldInfo loadWorldInfo();
    
    void saveWorldInfoWithPlayer(final WorldInfo p0, final NBTTagCompound p1);
    
    void flush();
    
    TemplateManager getStructureTemplateManager();
    
    void checkSessionLock() throws MinecraftException;
    
    File getWorldDirectory();
    
    IChunkLoader getChunkLoader(final WorldProvider p0);
}
