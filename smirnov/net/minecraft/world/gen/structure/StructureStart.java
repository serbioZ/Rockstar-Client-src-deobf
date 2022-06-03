// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.ChunkPos;
import com.google.common.collect.Lists;
import java.util.List;

public abstract class StructureStart
{
    protected /* synthetic */ StructureBoundingBox boundingBox;
    private /* synthetic */ int chunkPosZ;
    protected /* synthetic */ List<StructureComponent> components;
    private /* synthetic */ int chunkPosX;
    
    public StructureStart() {
        this.components = (List<StructureComponent>)Lists.newLinkedList();
    }
    
    public boolean isValidForPostProcess(final ChunkPos lllllllllllIIlllIlllllllIIIIIllI) {
        return true;
    }
    
    public NBTTagCompound writeStructureComponentsToNBT(final int lllllllllllIIlllIlllllllIlIlllIl, final int lllllllllllIIlllIlllllllIlIlllII) {
        final NBTTagCompound lllllllllllIIlllIlllllllIlIllIll = new NBTTagCompound();
        lllllllllllIIlllIlllllllIlIllIll.setString("id", MapGenStructureIO.getStructureStartName(this));
        lllllllllllIIlllIlllllllIlIllIll.setInteger("ChunkX", lllllllllllIIlllIlllllllIlIlllIl);
        lllllllllllIIlllIlllllllIlIllIll.setInteger("ChunkZ", lllllllllllIIlllIlllllllIlIlllII);
        lllllllllllIIlllIlllllllIlIllIll.setTag("BB", this.boundingBox.toNBTTagIntArray());
        final NBTTagList lllllllllllIIlllIlllllllIlIllIlI = new NBTTagList();
        for (final StructureComponent lllllllllllIIlllIlllllllIlIllIIl : this.components) {
            lllllllllllIIlllIlllllllIlIllIlI.appendTag(lllllllllllIIlllIlllllllIlIllIIl.createStructureBaseNBT());
        }
        lllllllllllIIlllIlllllllIlIllIll.setTag("Children", lllllllllllIIlllIlllllllIlIllIlI);
        this.writeToNBT(lllllllllllIIlllIlllllllIlIllIll);
        return lllllllllllIIlllIlllllllIlIllIll;
    }
    
    public void readStructureComponentsFromNBT(final World lllllllllllIIlllIlllllllIlIIIlII, final NBTTagCompound lllllllllllIIlllIlllllllIlIIIIll) {
        this.chunkPosX = lllllllllllIIlllIlllllllIlIIIIll.getInteger("ChunkX");
        this.chunkPosZ = lllllllllllIIlllIlllllllIlIIIIll.getInteger("ChunkZ");
        if (lllllllllllIIlllIlllllllIlIIIIll.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(lllllllllllIIlllIlllllllIlIIIIll.getIntArray("BB"));
        }
        final NBTTagList lllllllllllIIlllIlllllllIlIIIlll = lllllllllllIIlllIlllllllIlIIIIll.getTagList("Children", 10);
        for (int lllllllllllIIlllIlllllllIlIIIllI = 0; lllllllllllIIlllIlllllllIlIIIllI < lllllllllllIIlllIlllllllIlIIIlll.tagCount(); ++lllllllllllIIlllIlllllllIlIIIllI) {
            this.components.add(MapGenStructureIO.getStructureComponent(lllllllllllIIlllIlllllllIlIIIlll.getCompoundTagAt(lllllllllllIIlllIlllllllIlIIIllI), lllllllllllIIlllIlllllllIlIIIlII));
        }
        this.readFromNBT(lllllllllllIIlllIlllllllIlIIIIll);
    }
    
    public void generateStructure(final World lllllllllllIIlllIlllllllIllllIII, final Random lllllllllllIIlllIlllllllIlllIIIl, final StructureBoundingBox lllllllllllIIlllIlllllllIlllIIII) {
        final Iterator<StructureComponent> lllllllllllIIlllIlllllllIlllIlIl = this.components.iterator();
        while (lllllllllllIIlllIlllllllIlllIlIl.hasNext()) {
            final StructureComponent lllllllllllIIlllIlllllllIlllIlII = lllllllllllIIlllIlllllllIlllIlIl.next();
            if (lllllllllllIIlllIlllllllIlllIlII.getBoundingBox().intersectsWith(lllllllllllIIlllIlllllllIlllIIII) && !lllllllllllIIlllIlllllllIlllIlII.addComponentParts(lllllllllllIIlllIlllllllIllllIII, lllllllllllIIlllIlllllllIlllIIIl, lllllllllllIIlllIlllllllIlllIIII)) {
                lllllllllllIIlllIlllllllIlllIlIl.remove();
            }
        }
    }
    
    protected void markAvailableHeight(final World lllllllllllIIlllIlllllllIIlIllII, final Random lllllllllllIIlllIlllllllIIlIlIll, final int lllllllllllIIlllIlllllllIIllIIlI) {
        final int lllllllllllIIlllIlllllllIIllIIIl = lllllllllllIIlllIlllllllIIlIllII.getSeaLevel() - lllllllllllIIlllIlllllllIIllIIlI;
        int lllllllllllIIlllIlllllllIIllIIII = this.boundingBox.getYSize() + 1;
        if (lllllllllllIIlllIlllllllIIllIIII < lllllllllllIIlllIlllllllIIllIIIl) {
            lllllllllllIIlllIlllllllIIllIIII += lllllllllllIIlllIlllllllIIlIlIll.nextInt(lllllllllllIIlllIlllllllIIllIIIl - lllllllllllIIlllIlllllllIIllIIII);
        }
        final int lllllllllllIIlllIlllllllIIlIllll = lllllllllllIIlllIlllllllIIllIIII - this.boundingBox.maxY;
        this.boundingBox.offset(0, lllllllllllIIlllIlllllllIIlIllll, 0);
        for (final StructureComponent lllllllllllIIlllIlllllllIIlIlllI : this.components) {
            lllllllllllIIlllIlllllllIIlIlllI.offset(0, lllllllllllIIlllIlllllllIIlIllll, 0);
        }
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllIIlllIlllllllIIllllll) {
    }
    
    public boolean isSizeableStructure() {
        return true;
    }
    
    public int getChunkPosZ() {
        return this.chunkPosZ;
    }
    
    public int getChunkPosX() {
        return this.chunkPosX;
    }
    
    protected void setRandomHeight(final World lllllllllllIIlllIlllllllIIIllIlI, final Random lllllllllllIIlllIlllllllIIIllIIl, final int lllllllllllIIlllIlllllllIIIllIII, final int lllllllllllIIlllIlllllllIIIlIlll) {
        final int lllllllllllIIlllIlllllllIIIlIllI = lllllllllllIIlllIlllllllIIIlIlll - lllllllllllIIlllIlllllllIIIllIII + 1 - this.boundingBox.getYSize();
        int lllllllllllIIlllIlllllllIIIlIlII = 0;
        if (lllllllllllIIlllIlllllllIIIlIllI > 1) {
            final int lllllllllllIIlllIlllllllIIIlIlIl = lllllllllllIIlllIlllllllIIIllIII + lllllllllllIIlllIlllllllIIIllIIl.nextInt(lllllllllllIIlllIlllllllIIIlIllI);
        }
        else {
            lllllllllllIIlllIlllllllIIIlIlII = lllllllllllIIlllIlllllllIIIllIII;
        }
        final int lllllllllllIIlllIlllllllIIIlIIll = lllllllllllIIlllIlllllllIIIlIlII - this.boundingBox.minY;
        this.boundingBox.offset(0, lllllllllllIIlllIlllllllIIIlIIll, 0);
        for (final StructureComponent lllllllllllIIlllIlllllllIIIlIIlI : this.components) {
            lllllllllllIIlllIlllllllIIIlIIlI.offset(0, lllllllllllIIlllIlllllllIIIlIIll, 0);
        }
    }
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    public StructureStart(final int lllllllllllIIlllIllllllllIIIIlll, final int lllllllllllIIlllIllllllllIIIIllI) {
        this.components = (List<StructureComponent>)Lists.newLinkedList();
        this.chunkPosX = lllllllllllIIlllIllllllllIIIIlll;
        this.chunkPosZ = lllllllllllIIlllIllllllllIIIIllI;
    }
    
    public List<StructureComponent> getComponents() {
        return this.components;
    }
    
    public void notifyPostProcessAt(final ChunkPos lllllllllllIIlllIlllllllIIIIIlII) {
    }
    
    protected void updateBoundingBox() {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        for (final StructureComponent lllllllllllIIlllIlllllllIllIlIIl : this.components) {
            this.boundingBox.expandTo(lllllllllllIIlllIlllllllIllIlIIl.getBoundingBox());
        }
    }
    
    public void writeToNBT(final NBTTagCompound lllllllllllIIlllIlllllllIlIlIIII) {
    }
}
