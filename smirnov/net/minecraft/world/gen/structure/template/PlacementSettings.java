// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure.template;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.Rotation;
import net.minecraft.block.Block;
import java.util.Random;
import javax.annotation.Nullable;

public class PlacementSettings
{
    @Nullable
    private /* synthetic */ Long setSeed;
    private /* synthetic */ float integrity;
    private /* synthetic */ boolean ignoreEntities;
    @Nullable
    private /* synthetic */ Random random;
    @Nullable
    private /* synthetic */ Block replacedBlock;
    private /* synthetic */ Rotation rotation;
    private /* synthetic */ boolean ignoreStructureBlock;
    @Nullable
    private /* synthetic */ StructureBoundingBox boundingBox;
    @Nullable
    private /* synthetic */ ChunkPos chunk;
    private /* synthetic */ Mirror mirror;
    
    public PlacementSettings copy() {
        final PlacementSettings lllllllllllIIIIlIlIlIIlIIlllIIll = new PlacementSettings();
        lllllllllllIIIIlIlIlIIlIIlllIIll.mirror = this.mirror;
        lllllllllllIIIIlIlIlIIlIIlllIIll.rotation = this.rotation;
        lllllllllllIIIIlIlIlIIlIIlllIIll.ignoreEntities = this.ignoreEntities;
        lllllllllllIIIIlIlIlIIlIIlllIIll.replacedBlock = this.replacedBlock;
        lllllllllllIIIIlIlIlIIlIIlllIIll.chunk = this.chunk;
        lllllllllllIIIIlIlIlIIlIIlllIIll.boundingBox = this.boundingBox;
        lllllllllllIIIIlIlIlIIlIIlllIIll.ignoreStructureBlock = this.ignoreStructureBlock;
        lllllllllllIIIIlIlIlIIlIIlllIIll.integrity = this.integrity;
        lllllllllllIIIIlIlIlIIlIIlllIIll.random = this.random;
        lllllllllllIIIIlIlIlIIlIIlllIIll.setSeed = this.setSeed;
        return lllllllllllIIIIlIlIlIIlIIlllIIll;
    }
    
    @Nullable
    public StructureBoundingBox getBoundingBox() {
        if (this.boundingBox == null && this.chunk != null) {
            this.setBoundingBoxFromChunk();
        }
        return this.boundingBox;
    }
    
    @Nullable
    private StructureBoundingBox getBoundingBoxFromChunk(@Nullable final ChunkPos lllllllllllIIIIlIlIlIIlIIIIIlIIl) {
        if (lllllllllllIIIIlIlIlIIlIIIIIlIIl == null) {
            return null;
        }
        final int lllllllllllIIIIlIlIlIIlIIIIIlIll = lllllllllllIIIIlIlIlIIlIIIIIlIIl.chunkXPos * 16;
        final int lllllllllllIIIIlIlIlIIlIIIIIlIlI = lllllllllllIIIIlIlIlIIlIIIIIlIIl.chunkZPos * 16;
        return new StructureBoundingBox(lllllllllllIIIIlIlIlIIlIIIIIlIll, 0, lllllllllllIIIIlIlIlIIlIIIIIlIlI, lllllllllllIIIIlIlIlIIlIIIIIlIll + 16 - 1, 255, lllllllllllIIIIlIlIlIIlIIIIIlIlI + 16 - 1);
    }
    
    public PlacementSettings setRandom(@Nullable final Random lllllllllllIIIIlIlIlIIlIIlIIIIIl) {
        this.random = lllllllllllIIIIlIlIlIIlIIlIIIIIl;
        return this;
    }
    
    public boolean getIgnoreEntities() {
        return this.ignoreEntities;
    }
    
    public PlacementSettings setReplacedBlock(final Block lllllllllllIIIIlIlIlIIlIIlIllIIl) {
        this.replacedBlock = lllllllllllIIIIlIlIlIIlIIlIllIIl;
        return this;
    }
    
    public Rotation getRotation() {
        return this.rotation;
    }
    
    public PlacementSettings setIgnoreStructureBlock(final boolean lllllllllllIIIIlIlIlIIlIIIllIIlI) {
        this.ignoreStructureBlock = lllllllllllIIIIlIlIlIIlIIIllIIlI;
        return this;
    }
    
    public float getIntegrity() {
        return this.integrity;
    }
    
    public boolean getIgnoreStructureBlock() {
        return this.ignoreStructureBlock;
    }
    
    @Nullable
    public Block getReplacedBlock() {
        return this.replacedBlock;
    }
    
    void setBoundingBoxFromChunk() {
        this.boundingBox = this.getBoundingBoxFromChunk(this.chunk);
    }
    
    public Random getRandom(@Nullable final BlockPos lllllllllllIIIIlIlIlIIlIIIlIIlIl) {
        if (this.random != null) {
            return this.random;
        }
        if (this.setSeed != null) {
            return (this.setSeed == 0L) ? new Random(System.currentTimeMillis()) : new Random(this.setSeed);
        }
        if (lllllllllllIIIIlIlIlIIlIIIlIIlIl == null) {
            return new Random(System.currentTimeMillis());
        }
        final int lllllllllllIIIIlIlIlIIlIIIlIlIII = lllllllllllIIIIlIlIlIIlIIIlIIlIl.getX();
        final int lllllllllllIIIIlIlIlIIlIIIlIIlll = lllllllllllIIIIlIlIlIIlIIIlIIlIl.getZ();
        return new Random(lllllllllllIIIIlIlIlIIlIIIlIlIII * lllllllllllIIIIlIlIlIIlIIIlIlIII * 4987142 + lllllllllllIIIIlIlIlIIlIIIlIlIII * 5947611 + lllllllllllIIIIlIlIlIIlIIIlIIlll * lllllllllllIIIIlIlIlIIlIIIlIIlll * 4392871L + lllllllllllIIIIlIlIlIIlIIIlIIlll * 389711 ^ 0x3AD8025FL);
    }
    
    public PlacementSettings setChunk(final ChunkPos lllllllllllIIIIlIlIlIIlIIlIlIlIl) {
        this.chunk = lllllllllllIIIIlIlIlIIlIIlIlIlIl;
        return this;
    }
    
    public Mirror getMirror() {
        return this.mirror;
    }
    
    public PlacementSettings setMirror(final Mirror lllllllllllIIIIlIlIlIIlIIllIlIll) {
        this.mirror = lllllllllllIIIIlIlIlIIlIIllIlIll;
        return this;
    }
    
    public PlacementSettings setIgnoreEntities(final boolean lllllllllllIIIIlIlIlIIlIIlIlllll) {
        this.ignoreEntities = lllllllllllIIIIlIlIlIIlIIlIlllll;
        return this;
    }
    
    public PlacementSettings setRotation(final Rotation lllllllllllIIIIlIlIlIIlIIllIIlIl) {
        this.rotation = lllllllllllIIIIlIlIlIIlIIllIIlIl;
        return this;
    }
    
    public PlacementSettings() {
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.ignoreStructureBlock = true;
        this.integrity = 1.0f;
    }
    
    public PlacementSettings setIntegrity(final float lllllllllllIIIIlIlIlIIlIIIlllIll) {
        this.integrity = lllllllllllIIIIlIlIlIIlIIIlllIll;
        return this;
    }
    
    public PlacementSettings setSeed(@Nullable final Long lllllllllllIIIIlIlIlIIlIIlIIIlll) {
        this.setSeed = lllllllllllIIIIlIlIlIIlIIlIIIlll;
        return this;
    }
    
    public PlacementSettings setBoundingBox(final StructureBoundingBox lllllllllllIIIIlIlIlIIlIIlIIllIl) {
        this.boundingBox = lllllllllllIIIIlIlIlIIlIIlIIllIl;
        return this;
    }
}
