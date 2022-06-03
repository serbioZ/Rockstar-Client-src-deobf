// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import javax.annotation.Nullable;

public class SaveDataMemoryStorage extends MapStorage
{
    @Override
    public void saveAllData() {
    }
    
    @Override
    public void setData(final String lllllllllllllIIlIIIllIlIIlIllIll, final WorldSavedData lllllllllllllIIlIIIllIlIIlIllIlI) {
        this.loadedDataMap.put(lllllllllllllIIlIIIllIlIIlIllIll, lllllllllllllIIlIIIllIlIIlIllIlI);
    }
    
    @Override
    public int getUniqueDataId(final String lllllllllllllIIlIIIllIlIIlIlIlll) {
        return 0;
    }
    
    @Nullable
    @Override
    public WorldSavedData getOrLoadData(final Class<? extends WorldSavedData> lllllllllllllIIlIIIllIlIIllIIllI, final String lllllllllllllIIlIIIllIlIIllIIIll) {
        return this.loadedDataMap.get(lllllllllllllIIlIIIllIlIIllIIIll);
    }
    
    public SaveDataMemoryStorage() {
        super(null);
    }
}
