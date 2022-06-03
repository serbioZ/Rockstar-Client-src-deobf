// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagShort;
import java.io.DataInputStream;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import java.io.File;
import java.io.InputStream;
import net.minecraft.nbt.CompressedStreamTools;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class MapStorage
{
    protected /* synthetic */ Map<String, WorldSavedData> loadedDataMap;
    private final /* synthetic */ Map<String, Short> idCounts;
    private final /* synthetic */ List<WorldSavedData> loadedDataList;
    private final /* synthetic */ ISaveHandler saveHandler;
    
    @Nullable
    public WorldSavedData getOrLoadData(final Class<? extends WorldSavedData> llllllllllllIllIIllllIIIlIllIIII, final String llllllllllllIllIIllllIIIlIlIIllI) {
        WorldSavedData llllllllllllIllIIllllIIIlIlIlllI = this.loadedDataMap.get(llllllllllllIllIIllllIIIlIlIIllI);
        if (llllllllllllIllIIllllIIIlIlIlllI != null) {
            return llllllllllllIllIIllllIIIlIlIlllI;
        }
        if (this.saveHandler != null) {
            try {
                final File llllllllllllIllIIllllIIIlIlIllIl = this.saveHandler.getMapFileFromName(llllllllllllIllIIllllIIIlIlIIllI);
                if (llllllllllllIllIIllllIIIlIlIllIl != null && llllllllllllIllIIllllIIIlIlIllIl.exists()) {
                    try {
                        llllllllllllIllIIllllIIIlIlIlllI = (WorldSavedData)llllllllllllIllIIllllIIIlIllIIII.getConstructor(String.class).newInstance(llllllllllllIllIIllllIIIlIlIIllI);
                    }
                    catch (Exception llllllllllllIllIIllllIIIlIlIllII) {
                        throw new RuntimeException("Failed to instantiate " + llllllllllllIllIIllllIIIlIllIIII, llllllllllllIllIIllllIIIlIlIllII);
                    }
                    final FileInputStream llllllllllllIllIIllllIIIlIlIlIll = new FileInputStream(llllllllllllIllIIllllIIIlIlIllIl);
                    final NBTTagCompound llllllllllllIllIIllllIIIlIlIlIlI = CompressedStreamTools.readCompressed(llllllllllllIllIIllllIIIlIlIlIll);
                    llllllllllllIllIIllllIIIlIlIlIll.close();
                    llllllllllllIllIIllllIIIlIlIlllI.readFromNBT(llllllllllllIllIIllllIIIlIlIlIlI.getCompoundTag("data"));
                }
            }
            catch (Exception llllllllllllIllIIllllIIIlIlIlIIl) {
                llllllllllllIllIIllllIIIlIlIlIIl.printStackTrace();
            }
        }
        if (llllllllllllIllIIllllIIIlIlIlllI != null) {
            this.loadedDataMap.put(llllllllllllIllIIllllIIIlIlIIllI, llllllllllllIllIIllllIIIlIlIlllI);
            this.loadedDataList.add(llllllllllllIllIIllllIIIlIlIlllI);
        }
        return llllllllllllIllIIllllIIIlIlIlllI;
    }
    
    public MapStorage(final ISaveHandler llllllllllllIllIIllllIIIlIlllIll) {
        this.loadedDataMap = (Map<String, WorldSavedData>)Maps.newHashMap();
        this.loadedDataList = (List<WorldSavedData>)Lists.newArrayList();
        this.idCounts = (Map<String, Short>)Maps.newHashMap();
        this.saveHandler = llllllllllllIllIIllllIIIlIlllIll;
        this.loadIdCounts();
    }
    
    private void loadIdCounts() {
        try {
            this.idCounts.clear();
            if (this.saveHandler == null) {
                return;
            }
            final File llllllllllllIllIIllllIIIIlllIlIl = this.saveHandler.getMapFileFromName("idcounts");
            if (llllllllllllIllIIllllIIIIlllIlIl != null && llllllllllllIllIIllllIIIIlllIlIl.exists()) {
                final DataInputStream llllllllllllIllIIllllIIIIlllIlII = new DataInputStream(new FileInputStream(llllllllllllIllIIllllIIIIlllIlIl));
                final NBTTagCompound llllllllllllIllIIllllIIIIlllIIll = CompressedStreamTools.read(llllllllllllIllIIllllIIIIlllIlII);
                llllllllllllIllIIllllIIIIlllIlII.close();
                for (final String llllllllllllIllIIllllIIIIlllIIlI : llllllllllllIllIIllllIIIIlllIIll.getKeySet()) {
                    final NBTBase llllllllllllIllIIllllIIIIlllIIIl = llllllllllllIllIIllllIIIIlllIIll.getTag(llllllllllllIllIIllllIIIIlllIIlI);
                    if (llllllllllllIllIIllllIIIIlllIIIl instanceof NBTTagShort) {
                        final NBTTagShort llllllllllllIllIIllllIIIIlllIIII = (NBTTagShort)llllllllllllIllIIllllIIIIlllIIIl;
                        final short llllllllllllIllIIllllIIIIllIllll = llllllllllllIllIIllllIIIIlllIIII.getShort();
                        this.idCounts.put(llllllllllllIllIIllllIIIIlllIIlI, llllllllllllIllIIllllIIIIllIllll);
                    }
                }
            }
        }
        catch (Exception llllllllllllIllIIllllIIIIllIlllI) {
            llllllllllllIllIIllllIIIIllIlllI.printStackTrace();
        }
    }
    
    private void saveData(final WorldSavedData llllllllllllIllIIllllIIIlIIIIIll) {
        if (this.saveHandler != null) {
            try {
                final File llllllllllllIllIIllllIIIlIIIlIII = this.saveHandler.getMapFileFromName(llllllllllllIllIIllllIIIlIIIIIll.mapName);
                if (llllllllllllIllIIllllIIIlIIIlIII != null) {
                    final NBTTagCompound llllllllllllIllIIllllIIIlIIIIlll = new NBTTagCompound();
                    llllllllllllIllIIllllIIIlIIIIlll.setTag("data", llllllllllllIllIIllllIIIlIIIIIll.writeToNBT(new NBTTagCompound()));
                    final FileOutputStream llllllllllllIllIIllllIIIlIIIIllI = new FileOutputStream(llllllllllllIllIIllllIIIlIIIlIII);
                    CompressedStreamTools.writeCompressed(llllllllllllIllIIllllIIIlIIIIlll, llllllllllllIllIIllllIIIlIIIIllI);
                    llllllllllllIllIIllllIIIlIIIIllI.close();
                }
            }
            catch (Exception llllllllllllIllIIllllIIIlIIIIlIl) {
                llllllllllllIllIIllllIIIlIIIIlIl.printStackTrace();
            }
        }
    }
    
    public void saveAllData() {
        for (int llllllllllllIllIIllllIIIlIIlIlII = 0; llllllllllllIllIIllllIIIlIIlIlII < this.loadedDataList.size(); ++llllllllllllIllIIllllIIIlIIlIlII) {
            final WorldSavedData llllllllllllIllIIllllIIIlIIlIIll = this.loadedDataList.get(llllllllllllIllIIllllIIIlIIlIlII);
            if (llllllllllllIllIIllllIIIlIIlIIll.isDirty()) {
                this.saveData(llllllllllllIllIIllllIIIlIIlIIll);
                llllllllllllIllIIllllIIIlIIlIIll.setDirty(false);
            }
        }
    }
    
    public int getUniqueDataId(final String llllllllllllIllIIllllIIIIlIlIlII) {
        Short llllllllllllIllIIllllIIIIlIllIll = this.idCounts.get(llllllllllllIllIIllllIIIIlIlIlII);
        if (llllllllllllIllIIllllIIIIlIllIll == null) {
            llllllllllllIllIIllllIIIIlIllIll = 0;
        }
        else {
            llllllllllllIllIIllllIIIIlIllIll = (short)(llllllllllllIllIIllllIIIIlIllIll + 1);
        }
        this.idCounts.put(llllllllllllIllIIllllIIIIlIlIlII, llllllllllllIllIIllllIIIIlIllIll);
        if (this.saveHandler == null) {
            return llllllllllllIllIIllllIIIIlIllIll;
        }
        try {
            final File llllllllllllIllIIllllIIIIlIllIlI = this.saveHandler.getMapFileFromName("idcounts");
            if (llllllllllllIllIIllllIIIIlIllIlI != null) {
                final NBTTagCompound llllllllllllIllIIllllIIIIlIllIIl = new NBTTagCompound();
                for (final String llllllllllllIllIIllllIIIIlIllIII : this.idCounts.keySet()) {
                    llllllllllllIllIIllllIIIIlIllIIl.setShort(llllllllllllIllIIllllIIIIlIllIII, this.idCounts.get(llllllllllllIllIIllllIIIIlIllIII));
                }
                final DataOutputStream llllllllllllIllIIllllIIIIlIlIlll = new DataOutputStream(new FileOutputStream(llllllllllllIllIIllllIIIIlIllIlI));
                CompressedStreamTools.write(llllllllllllIllIIllllIIIIlIllIIl, llllllllllllIllIIllllIIIIlIlIlll);
                llllllllllllIllIIllllIIIIlIlIlll.close();
            }
        }
        catch (Exception llllllllllllIllIIllllIIIIlIlIllI) {
            llllllllllllIllIIllllIIIIlIlIllI.printStackTrace();
        }
        return llllllllllllIllIIllllIIIIlIllIll;
    }
    
    public void setData(final String llllllllllllIllIIllllIIIlIIlllIl, final WorldSavedData llllllllllllIllIIllllIIIlIIllIIl) {
        if (this.loadedDataMap.containsKey(llllllllllllIllIIllllIIIlIIlllIl)) {
            this.loadedDataList.remove(this.loadedDataMap.remove(llllllllllllIllIIllllIIIlIIlllIl));
        }
        this.loadedDataMap.put(llllllllllllIllIIllllIIIlIIlllIl, llllllllllllIllIIllllIIIlIIllIIl);
        this.loadedDataList.add(llllllllllllIllIIllllIIIlIIllIIl);
    }
}
