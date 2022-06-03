// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

public class WorldSavedDataCallableSave implements Runnable
{
    private final /* synthetic */ WorldSavedData data;
    
    @Override
    public void run() {
        this.data.markDirty();
    }
    
    public WorldSavedDataCallableSave(final WorldSavedData llllllllllIlllllIIIIIIlIIlllIIIl) {
        this.data = llllllllllIlllllIIIIIIlIIlllIIIl;
    }
}
