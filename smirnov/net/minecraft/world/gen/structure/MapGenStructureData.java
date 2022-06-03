// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;

public class MapGenStructureData extends WorldSavedData
{
    private /* synthetic */ NBTTagCompound tagCompound;
    
    public void writeInstance(final NBTTagCompound llllllllllllIIllIllIlIIlllIllIlI, final int llllllllllllIIllIllIlIIlllIlllIl, final int llllllllllllIIllIllIlIIlllIllIII) {
        this.tagCompound.setTag(formatChunkCoords(llllllllllllIIllIllIlIIlllIlllIl, llllllllllllIIllIllIlIIlllIllIII), llllllllllllIIllIllIlIIlllIllIlI);
    }
    
    public static String formatChunkCoords(final int llllllllllllIIllIllIlIIlllIlIlIl, final int llllllllllllIIllIllIlIIlllIlIlII) {
        return "[" + llllllllllllIIllIllIlIIlllIlIlIl + "," + llllllllllllIIllIllIlIIlllIlIlII + "]";
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIIllIllIlIIllllIllII) {
        this.tagCompound = llllllllllllIIllIllIlIIllllIllII.getCompoundTag("Features");
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIIllIllIlIIllllIIllI) {
        llllllllllllIIllIllIlIIllllIIllI.setTag("Features", this.tagCompound);
        return llllllllllllIIllIllIlIIllllIIllI;
    }
    
    public MapGenStructureData(final String llllllllllllIIllIllIlIIlllllIIII) {
        super(llllllllllllIIllIllIlIIlllllIIII);
        this.tagCompound = new NBTTagCompound();
    }
    
    public NBTTagCompound getTagCompound() {
        return this.tagCompound;
    }
}
