// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.util.Objects;
import java.io.DataOutput;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import com.google.common.collect.Lists;
import java.io.DataInput;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class NBTTagList extends NBTBase
{
    private /* synthetic */ List<NBTBase> tagList;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ byte tagType;
    
    public int tagCount() {
        return this.tagList.size();
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagList.hashCode();
    }
    
    public float getFloatAt(final int llllllllllllIIlIIIIIIIlIllIlllll) {
        if (llllllllllllIIlIIIIIIIlIllIlllll >= 0 && llllllllllllIIlIIIIIIIlIllIlllll < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIlIllIllllI = this.tagList.get(llllllllllllIIlIIIIIIIlIllIlllll);
            if (llllllllllllIIlIIIIIIIlIllIllllI.getId() == 5) {
                return ((NBTTagFloat)llllllllllllIIlIIIIIIIlIllIllllI).getFloat();
            }
        }
        return 0.0f;
    }
    
    @Override
    void read(final DataInput llllllllllllIIlIIIIIIIllIIllIllI, final int llllllllllllIIlIIIIIIIllIIlIlllI, final NBTSizeTracker llllllllllllIIlIIIIIIIllIIlIllIl) throws IOException {
        llllllllllllIIlIIIIIIIllIIlIllIl.read(296L);
        if (llllllllllllIIlIIIIIIIllIIlIlllI > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.tagType = llllllllllllIIlIIIIIIIllIIllIllI.readByte();
        final int llllllllllllIIlIIIIIIIllIIllIIll = llllllllllllIIlIIIIIIIllIIllIllI.readInt();
        if (this.tagType == 0 && llllllllllllIIlIIIIIIIllIIllIIll > 0) {
            throw new RuntimeException("Missing type on ListTag");
        }
        llllllllllllIIlIIIIIIIllIIlIllIl.read(32L * llllllllllllIIlIIIIIIIllIIllIIll);
        this.tagList = (List<NBTBase>)Lists.newArrayListWithCapacity(llllllllllllIIlIIIIIIIllIIllIIll);
        for (int llllllllllllIIlIIIIIIIllIIllIIlI = 0; llllllllllllIIlIIIIIIIllIIllIIlI < llllllllllllIIlIIIIIIIllIIllIIll; ++llllllllllllIIlIIIIIIIllIIllIIlI) {
            final NBTBase llllllllllllIIlIIIIIIIllIIllIIIl = NBTBase.createNewByType(this.tagType);
            llllllllllllIIlIIIIIIIllIIllIIIl.read(llllllllllllIIlIIIIIIIllIIllIllI, llllllllllllIIlIIIIIIIllIIlIlllI + 1, llllllllllllIIlIIIIIIIllIIlIllIl);
            this.tagList.add(llllllllllllIIlIIIIIIIllIIllIIIl);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagList.isEmpty();
    }
    
    @Override
    void write(final DataOutput llllllllllllIIlIIIIIIIllIlIIIIll) throws IOException {
        if (this.tagList.isEmpty()) {
            this.tagType = 0;
        }
        else {
            this.tagType = this.tagList.get(0).getId();
        }
        llllllllllllIIlIIIIIIIllIlIIIIll.writeByte(this.tagType);
        llllllllllllIIlIIIIIIIllIlIIIIll.writeInt(this.tagList.size());
        for (int llllllllllllIIlIIIIIIIllIlIIIIlI = 0; llllllllllllIIlIIIIIIIllIlIIIIlI < this.tagList.size(); ++llllllllllllIIlIIIIIIIllIlIIIIlI) {
            this.tagList.get(llllllllllllIIlIIIIIIIllIlIIIIlI).write(llllllllllllIIlIIIIIIIllIlIIIIll);
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllIIlIIIIIIIllIIlIIlII = new StringBuilder("[");
        for (int llllllllllllIIlIIIIIIIllIIlIIIll = 0; llllllllllllIIlIIIIIIIllIIlIIIll < this.tagList.size(); ++llllllllllllIIlIIIIIIIllIIlIIIll) {
            if (llllllllllllIIlIIIIIIIllIIlIIIll != 0) {
                llllllllllllIIlIIIIIIIllIIlIIlII.append(',');
            }
            llllllllllllIIlIIIIIIIllIIlIIlII.append(this.tagList.get(llllllllllllIIlIIIIIIIllIIlIIIll));
        }
        return llllllllllllIIlIIIIIIIllIIlIIlII.append(']').toString();
    }
    
    public double getDoubleAt(final int llllllllllllIIlIIIIIIIlIlllIlIII) {
        if (llllllllllllIIlIIIIIIIlIlllIlIII >= 0 && llllllllllllIIlIIIIIIIlIlllIlIII < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIlIlllIIlll = this.tagList.get(llllllllllllIIlIIIIIIIlIlllIlIII);
            if (llllllllllllIIlIIIIIIIlIlllIIlll.getId() == 6) {
                return ((NBTTagDouble)llllllllllllIIlIIIIIIIlIlllIIlll).getDouble();
            }
        }
        return 0.0;
    }
    
    public int getIntAt(final int llllllllllllIIlIIIIIIIlIlllllIlI) {
        if (llllllllllllIIlIIIIIIIlIlllllIlI >= 0 && llllllllllllIIlIIIIIIIlIlllllIlI < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIlIlllllIIl = this.tagList.get(llllllllllllIIlIIIIIIIlIlllllIlI);
            if (llllllllllllIIlIIIIIIIlIlllllIIl.getId() == 3) {
                return ((NBTTagInt)llllllllllllIIlIIIIIIIlIlllllIIl).getInt();
            }
        }
        return 0;
    }
    
    public NBTTagCompound getCompoundTagAt(final int llllllllllllIIlIIIIIIIllIIIIIIll) {
        if (llllllllllllIIlIIIIIIIllIIIIIIll >= 0 && llllllllllllIIlIIIIIIIllIIIIIIll < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIllIIIIIIlI = this.tagList.get(llllllllllllIIlIIIIIIIllIIIIIIll);
            if (llllllllllllIIlIIIIIIIllIIIIIIlI.getId() == 10) {
                return (NBTTagCompound)llllllllllllIIlIIIIIIIllIIIIIIlI;
            }
        }
        return new NBTTagCompound();
    }
    
    public NBTTagList() {
        this.tagList = (List<NBTBase>)Lists.newArrayList();
        this.tagType = 0;
    }
    
    @Override
    public NBTTagList copy() {
        final NBTTagList llllllllllllIIlIIIIIIIlIllIIIIlI = new NBTTagList();
        llllllllllllIIlIIIIIIIlIllIIIIlI.tagType = this.tagType;
        for (final NBTBase llllllllllllIIlIIIIIIIlIllIIIIIl : this.tagList) {
            final NBTBase llllllllllllIIlIIIIIIIlIllIIIIII = llllllllllllIIlIIIIIIIlIllIIIIIl.copy();
            llllllllllllIIlIIIIIIIlIllIIIIlI.tagList.add(llllllllllllIIlIIIIIIIlIllIIIIII);
        }
        return llllllllllllIIlIIIIIIIlIllIIIIlI;
    }
    
    public NBTBase removeTag(final int llllllllllllIIlIIIIIIIllIIIIlIll) {
        return this.tagList.remove(llllllllllllIIlIIIIIIIllIIIIlIll);
    }
    
    public void appendTag(final NBTBase llllllllllllIIlIIIIIIIllIIIllIlI) {
        if (llllllllllllIIlIIIIIIIllIIIllIlI.getId() == 0) {
            NBTTagList.LOGGER.warn("Invalid TagEnd added to ListTag");
        }
        else {
            if (this.tagType == 0) {
                this.tagType = llllllllllllIIlIIIIIIIllIIIllIlI.getId();
            }
            else if (this.tagType != llllllllllllIIlIIIIIIIllIIIllIlI.getId()) {
                NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.add(llllllllllllIIlIIIIIIIllIIIllIlI);
        }
    }
    
    public String getStringTagAt(final int llllllllllllIIlIIIIIIIlIllIlIIll) {
        if (llllllllllllIIlIIIIIIIlIllIlIIll >= 0 && llllllllllllIIlIIIIIIIlIllIlIIll < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIlIllIlIlIl = this.tagList.get(llllllllllllIIlIIIIIIIlIllIlIIll);
            return (llllllllllllIIlIIIIIIIlIllIlIlIl.getId() == 8) ? llllllllllllIIlIIIIIIIlIllIlIlIl.getString() : llllllllllllIIlIIIIIIIlIllIlIlIl.toString();
        }
        return "";
    }
    
    public NBTBase get(final int llllllllllllIIlIIIIIIIlIllIIllII) {
        return (llllllllllllIIlIIIIIIIlIllIIllII >= 0 && llllllllllllIIlIIIIIIIlIllIIllII < this.tagList.size()) ? this.tagList.get(llllllllllllIIlIIIIIIIlIllIIllII) : new NBTTagEnd();
    }
    
    public void set(final int llllllllllllIIlIIIIIIIllIIIlIIlI, final NBTBase llllllllllllIIlIIIIIIIllIIIlIlII) {
        if (llllllllllllIIlIIIIIIIllIIIlIlII.getId() == 0) {
            NBTTagList.LOGGER.warn("Invalid TagEnd added to ListTag");
        }
        else if (llllllllllllIIlIIIIIIIllIIIlIIlI >= 0 && llllllllllllIIlIIIIIIIllIIIlIIlI < this.tagList.size()) {
            if (this.tagType == 0) {
                this.tagType = llllllllllllIIlIIIIIIIllIIIlIlII.getId();
            }
            else if (this.tagType != llllllllllllIIlIIIIIIIllIIIlIlII.getId()) {
                NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.set(llllllllllllIIlIIIIIIIllIIIlIIlI, llllllllllllIIlIIIIIIIllIIIlIlII);
        }
        else {
            NBTTagList.LOGGER.warn("index out of bounds to set tag in tag list");
        }
    }
    
    public int getTagType() {
        return this.tagType;
    }
    
    @Override
    public byte getId() {
        return 9;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIIlIIIIIIIlIlIllIIll) {
        if (!super.equals(llllllllllllIIlIIIIIIIlIlIllIIll)) {
            return false;
        }
        final NBTTagList llllllllllllIIlIIIIIIIlIlIllIlIl = (NBTTagList)llllllllllllIIlIIIIIIIlIlIllIIll;
        return this.tagType == llllllllllllIIlIIIIIIIlIlIllIlIl.tagType && Objects.equals(this.tagList, llllllllllllIIlIIIIIIIlIlIllIlIl.tagList);
    }
    
    public int[] getIntArrayAt(final int llllllllllllIIlIIIIIIIlIllllIIIl) {
        if (llllllllllllIIlIIIIIIIlIllllIIIl >= 0 && llllllllllllIIlIIIIIIIlIllllIIIl < this.tagList.size()) {
            final NBTBase llllllllllllIIlIIIIIIIlIllllIIII = this.tagList.get(llllllllllllIIlIIIIIIIlIllllIIIl);
            if (llllllllllllIIlIIIIIIIlIllllIIII.getId() == 11) {
                return ((NBTTagIntArray)llllllllllllIIlIIIIIIIlIllllIIII).getIntArray();
            }
        }
        return new int[0];
    }
}
