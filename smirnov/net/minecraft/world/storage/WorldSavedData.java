// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.nbt.NBTTagCompound;

public abstract class WorldSavedData
{
    public final /* synthetic */ String mapName;
    private /* synthetic */ boolean dirty;
    
    public void markDirty() {
        this.setDirty(true);
    }
    
    public abstract NBTTagCompound writeToNBT(final NBTTagCompound p0);
    
    public boolean isDirty() {
        return this.dirty;
    }
    
    public void setDirty(final boolean lllllllllllIIllIllIIllllIlllIIIl) {
        this.dirty = lllllllllllIIllIllIIllllIlllIIIl;
    }
    
    public WorldSavedData(final String lllllllllllIIllIllIIllllIllllIlI) {
        this.mapName = lllllllllllIIllIllIIllllIllllIlI;
    }
    
    public abstract void readFromNBT(final NBTTagCompound p0);
}
