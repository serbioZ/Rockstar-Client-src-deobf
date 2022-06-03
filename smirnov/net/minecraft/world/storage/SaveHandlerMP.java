// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.world.MinecraftException;
import net.minecraft.world.gen.structure.template.TemplateManager;
import java.io.File;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.WorldProvider;
import net.minecraft.nbt.NBTTagCompound;

public class SaveHandlerMP implements ISaveHandler
{
    @Override
    public IPlayerFileData getPlayerNBTManager() {
        return null;
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo llllllllllllllIIlIllIlIllIIIIIIl, final NBTTagCompound llllllllllllllIIlIllIlIllIIIIIII) {
    }
    
    @Override
    public WorldInfo loadWorldInfo() {
        return null;
    }
    
    @Override
    public void saveWorldInfo(final WorldInfo llllllllllllllIIlIllIlIlIllllllI) {
    }
    
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider llllllllllllllIIlIllIlIllIIIIIll) {
        return null;
    }
    
    @Override
    public File getMapFileFromName(final String llllllllllllllIIlIllIlIlIllllIlI) {
        return null;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public TemplateManager getStructureTemplateManager() {
        return null;
    }
    
    @Override
    public File getWorldDirectory() {
        return null;
    }
    
    @Override
    public void checkSessionLock() throws MinecraftException {
    }
}
