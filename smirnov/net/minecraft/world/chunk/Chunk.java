// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.block.material.Material;
import net.minecraft.network.PacketBuffer;
import java.util.Iterator;
import java.util.Arrays;
import com.google.common.collect.Queues;
import com.google.common.collect.Maps;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.gen.ChunkGeneratorDebug;
import net.minecraft.init.Blocks;
import net.minecraft.world.WorldType;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.IChunkGenerator;
import java.util.Random;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import java.util.Collection;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.World;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.tileentity.TileEntity;
import java.util.Map;
import net.minecraft.util.math.BlockPos;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.entity.Entity;
import net.minecraft.util.ClassInheritanceMultiMap;

public class Chunk
{
    private final /* synthetic */ ClassInheritanceMultiMap<Entity>[] entityLists;
    private /* synthetic */ boolean isModified;
    private /* synthetic */ long inhabitedTime;
    private final /* synthetic */ byte[] blockBiomeArray;
    private final /* synthetic */ int[] precipitationHeightMap;
    private /* synthetic */ boolean chunkTicked;
    private final /* synthetic */ ConcurrentLinkedQueue<BlockPos> tileEntityPosQueue;
    private /* synthetic */ int heightMapMinimum;
    private final /* synthetic */ Map<BlockPos, TileEntity> chunkTileEntityMap;
    private final /* synthetic */ ExtendedBlockStorage[] storageArrays;
    private /* synthetic */ long lastSaveTime;
    private /* synthetic */ boolean hasEntities;
    private /* synthetic */ int queuedLightChecks;
    private /* synthetic */ boolean isTerrainPopulated;
    public final /* synthetic */ int zPosition;
    private final /* synthetic */ World worldObj;
    public final /* synthetic */ int xPosition;
    public static final /* synthetic */ ExtendedBlockStorage NULL_BLOCK_STORAGE;
    private /* synthetic */ boolean isLightPopulated;
    private final /* synthetic */ int[] heightMap;
    private final /* synthetic */ boolean[] updateSkylightColumns;
    private /* synthetic */ boolean isChunkLoaded;
    private /* synthetic */ boolean isGapLightingUpdated;
    private static final /* synthetic */ Logger LOGGER;
    
    public void setChunkLoaded(final boolean llllllllllllIIIlIIlIIlIlIlIIIllI) {
        this.isChunkLoaded = llllllllllllIIIlIIlIIlIlIlIIIllI;
    }
    
    public int getLowestHeight() {
        return this.heightMapMinimum;
    }
    
    public void onChunkUnload() {
        this.isChunkLoaded = false;
        for (final TileEntity llllllllllllIIIlIIlIIllIlIlIllIl : this.chunkTileEntityMap.values()) {
            this.worldObj.markTileEntityForRemoval(llllllllllllIIIlIIlIIllIlIlIllIl);
        }
        final char llllllllllllIIIlIIlIIllIlIlIIlll;
        final long llllllllllllIIIlIIlIIllIlIlIlIII = ((ClassInheritanceMultiMap<Entity>[])(Object)(llllllllllllIIIlIIlIIllIlIlIIlll = (char)(Object)this.entityLists)).length;
        for (boolean llllllllllllIIIlIIlIIllIlIlIlIIl = false; (llllllllllllIIIlIIlIIllIlIlIlIIl ? 1 : 0) < llllllllllllIIIlIIlIIllIlIlIlIII; ++llllllllllllIIIlIIlIIllIlIlIlIIl) {
            final ClassInheritanceMultiMap<Entity> llllllllllllIIIlIIlIIllIlIlIllII = llllllllllllIIIlIIlIIllIlIlIIlll[llllllllllllIIIlIIlIIllIlIlIlIIl];
            this.worldObj.unloadEntities(llllllllllllIIIlIIlIIllIlIlIllII);
        }
    }
    
    public byte[] getBiomeArray() {
        return this.blockBiomeArray;
    }
    
    public boolean isLoaded() {
        return this.isChunkLoaded;
    }
    
    public void setLastSaveTime(final long llllllllllllIIIlIIlIIlIlIIIlIIII) {
        this.lastSaveTime = llllllllllllIIIlIIlIIlIlIIIlIIII;
    }
    
    public void setHasEntities(final boolean llllllllllllIIIlIIlIIlIlIIIlIlII) {
        this.hasEntities = llllllllllllIIIlIIlIIlIlIIIlIlII;
    }
    
    protected void generateHeightMap() {
        final int llllllllllllIIIlIIlIlIIIIlIllIll = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int llllllllllllIIIlIIlIlIIIIlIllIlI = 0; llllllllllllIIIlIIlIlIIIIlIllIlI < 16; ++llllllllllllIIIlIIlIlIIIIlIllIlI) {
            for (int llllllllllllIIIlIIlIlIIIIlIllIIl = 0; llllllllllllIIIlIIlIlIIIIlIllIIl < 16; ++llllllllllllIIIlIIlIlIIIIlIllIIl) {
                this.precipitationHeightMap[llllllllllllIIIlIIlIlIIIIlIllIlI + (llllllllllllIIIlIIlIlIIIIlIllIIl << 4)] = -999;
                int llllllllllllIIIlIIlIlIIIIlIllIII = llllllllllllIIIlIIlIlIIIIlIllIll + 16;
                while (llllllllllllIIIlIIlIlIIIIlIllIII > 0) {
                    final IBlockState llllllllllllIIIlIIlIlIIIIlIlIlll = this.getBlockState(llllllllllllIIIlIIlIlIIIIlIllIlI, llllllllllllIIIlIIlIlIIIIlIllIII - 1, llllllllllllIIIlIIlIlIIIIlIllIIl);
                    if (llllllllllllIIIlIIlIlIIIIlIlIlll.getLightOpacity() != 0) {
                        if ((this.heightMap[llllllllllllIIIlIIlIlIIIIlIllIIl << 4 | llllllllllllIIIlIIlIlIIIIlIllIlI] = llllllllllllIIIlIIlIlIIIIlIllIII) < this.heightMapMinimum) {
                            this.heightMapMinimum = llllllllllllIIIlIIlIlIIIIlIllIII;
                            break;
                        }
                        break;
                    }
                    else {
                        --llllllllllllIIIlIIlIlIIIIlIllIII;
                    }
                }
            }
        }
        this.isModified = true;
    }
    
    public boolean isPopulated() {
        return this.chunkTicked && this.isTerrainPopulated && this.isLightPopulated;
    }
    
    @Nullable
    private TileEntity createNewTileEntity(final BlockPos llllllllllllIIIlIIlIIllIlllIlIlI) {
        final IBlockState llllllllllllIIIlIIlIIllIlllIlIIl = this.getBlockState(llllllllllllIIIlIIlIIllIlllIlIlI);
        final Block llllllllllllIIIlIIlIIllIlllIlIII = llllllllllllIIIlIIlIIllIlllIlIIl.getBlock();
        return llllllllllllIIIlIIlIIllIlllIlIII.hasTileEntity() ? ((ITileEntityProvider)llllllllllllIIIlIIlIIllIlllIlIII).createNewTileEntity(this.worldObj, llllllllllllIIIlIIlIIllIlllIlIIl.getBlock().getMetaFromState(llllllllllllIIIlIIlIIllIlllIlIIl)) : null;
    }
    
    public void onChunkLoad() {
        this.isChunkLoaded = true;
        this.worldObj.addTileEntities(this.chunkTileEntityMap.values());
        final boolean llllllllllllIIIlIIlIIllIlIllIlII;
        final int llllllllllllIIIlIIlIIllIlIllIlIl = ((ClassInheritanceMultiMap<Entity>[])(Object)(llllllllllllIIIlIIlIIllIlIllIlII = (boolean)(Object)this.entityLists)).length;
        for (byte llllllllllllIIIlIIlIIllIlIllIllI = 0; llllllllllllIIIlIIlIIllIlIllIllI < llllllllllllIIIlIIlIIllIlIllIlIl; ++llllllllllllIIIlIIlIIllIlIllIllI) {
            final ClassInheritanceMultiMap<Entity> llllllllllllIIIlIIlIIllIlIlllIIl = llllllllllllIIIlIIlIIllIlIllIlII[llllllllllllIIIlIIlIIllIlIllIllI];
            this.worldObj.loadEntities(llllllllllllIIIlIIlIIllIlIlllIIl);
        }
    }
    
    public long getInhabitedTime() {
        return this.inhabitedTime;
    }
    
    private boolean checkLight(final int llllllllllllIIIlIIlIIlIlIlIllllI, final int llllllllllllIIIlIIlIIlIlIlIlllIl) {
        final int llllllllllllIIIlIIlIIlIlIlIlllII = this.getTopFilledSegment();
        boolean llllllllllllIIIlIIlIIlIlIlIllIll = false;
        boolean llllllllllllIIIlIIlIIlIlIlIllIlI = false;
        final BlockPos.MutableBlockPos llllllllllllIIIlIIlIIlIlIlIllIIl = new BlockPos.MutableBlockPos((this.xPosition << 4) + llllllllllllIIIlIIlIIlIlIlIllllI, 0, (this.zPosition << 4) + llllllllllllIIIlIIlIIlIlIlIlllIl);
        for (int llllllllllllIIIlIIlIIlIlIlIllIII = llllllllllllIIIlIIlIIlIlIlIlllII + 16 - 1; llllllllllllIIIlIIlIIlIlIlIllIII > this.worldObj.getSeaLevel() || (llllllllllllIIIlIIlIIlIlIlIllIII > 0 && !llllllllllllIIIlIIlIIlIlIlIllIlI); --llllllllllllIIIlIIlIIlIlIlIllIII) {
            llllllllllllIIIlIIlIIlIlIlIllIIl.setPos(llllllllllllIIIlIIlIIlIlIlIllIIl.getX(), llllllllllllIIIlIIlIIlIlIlIllIII, llllllllllllIIIlIIlIIlIlIlIllIIl.getZ());
            final int llllllllllllIIIlIIlIIlIlIlIlIlll = this.getBlockLightOpacity(llllllllllllIIIlIIlIIlIlIlIllIIl);
            if (llllllllllllIIIlIIlIIlIlIlIlIlll == 255 && llllllllllllIIIlIIlIIlIlIlIllIIl.getY() < this.worldObj.getSeaLevel()) {
                llllllllllllIIIlIIlIIlIlIlIllIlI = true;
            }
            if (!llllllllllllIIIlIIlIIlIlIlIllIll && llllllllllllIIIlIIlIIlIlIlIlIlll > 0) {
                llllllllllllIIIlIIlIIlIlIlIllIll = true;
            }
            else if (llllllllllllIIIlIIlIIlIlIlIllIll && llllllllllllIIIlIIlIIlIlIlIlIlll == 0 && !this.worldObj.checkLight(llllllllllllIIIlIIlIIlIlIlIllIIl)) {
                return false;
            }
        }
        for (int llllllllllllIIIlIIlIIlIlIlIlIllI = llllllllllllIIIlIIlIIlIlIlIllIIl.getY(); llllllllllllIIIlIIlIIlIlIlIlIllI > 0; --llllllllllllIIIlIIlIIlIlIlIlIllI) {
            llllllllllllIIIlIIlIIlIlIlIllIIl.setPos(llllllllllllIIIlIIlIIlIlIlIllIIl.getX(), llllllllllllIIIlIIlIIlIlIlIlIllI, llllllllllllIIIlIIlIIlIlIlIllIIl.getZ());
            if (this.getBlockState(llllllllllllIIIlIIlIIlIlIlIllIIl).getLightValue() > 0) {
                this.worldObj.checkLight(llllllllllllIIIlIIlIIlIlIlIllIIl);
            }
        }
        return true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NULL_BLOCK_STORAGE = null;
    }
    
    public void generateSkylightMap() {
        final int llllllllllllIIIlIIlIlIIIIlIIIlll = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int llllllllllllIIIlIIlIlIIIIlIIIllI = 0; llllllllllllIIIlIIlIlIIIIlIIIllI < 16; ++llllllllllllIIIlIIlIlIIIIlIIIllI) {
            for (int llllllllllllIIIlIIlIlIIIIlIIIlIl = 0; llllllllllllIIIlIIlIlIIIIlIIIlIl < 16; ++llllllllllllIIIlIIlIlIIIIlIIIlIl) {
                this.precipitationHeightMap[llllllllllllIIIlIIlIlIIIIlIIIllI + (llllllllllllIIIlIIlIlIIIIlIIIlIl << 4)] = -999;
                int llllllllllllIIIlIIlIlIIIIlIIIlII = llllllllllllIIIlIIlIlIIIIlIIIlll + 16;
                while (llllllllllllIIIlIIlIlIIIIlIIIlII > 0) {
                    if (this.getBlockLightOpacity(llllllllllllIIIlIIlIlIIIIlIIIllI, llllllllllllIIIlIIlIlIIIIlIIIlII - 1, llllllllllllIIIlIIlIlIIIIlIIIlIl) != 0) {
                        if ((this.heightMap[llllllllllllIIIlIIlIlIIIIlIIIlIl << 4 | llllllllllllIIIlIIlIlIIIIlIIIllI] = llllllllllllIIIlIIlIlIIIIlIIIlII) < this.heightMapMinimum) {
                            this.heightMapMinimum = llllllllllllIIIlIIlIlIIIIlIIIlII;
                            break;
                        }
                        break;
                    }
                    else {
                        --llllllllllllIIIlIIlIlIIIIlIIIlII;
                    }
                }
                if (this.worldObj.provider.func_191066_m()) {
                    int llllllllllllIIIlIIlIlIIIIlIIIIll = 15;
                    int llllllllllllIIIlIIlIlIIIIlIIIIlI = llllllllllllIIIlIIlIlIIIIlIIIlll + 16 - 1;
                    do {
                        int llllllllllllIIIlIIlIlIIIIlIIIIIl = this.getBlockLightOpacity(llllllllllllIIIlIIlIlIIIIlIIIllI, llllllllllllIIIlIIlIlIIIIlIIIIlI, llllllllllllIIIlIIlIlIIIIlIIIlIl);
                        if (llllllllllllIIIlIIlIlIIIIlIIIIIl == 0 && llllllllllllIIIlIIlIlIIIIlIIIIll != 15) {
                            llllllllllllIIIlIIlIlIIIIlIIIIIl = 1;
                        }
                        llllllllllllIIIlIIlIlIIIIlIIIIll -= llllllllllllIIIlIIlIlIIIIlIIIIIl;
                        if (llllllllllllIIIlIIlIlIIIIlIIIIll > 0) {
                            final ExtendedBlockStorage llllllllllllIIIlIIlIlIIIIlIIIIII = this.storageArrays[llllllllllllIIIlIIlIlIIIIlIIIIlI >> 4];
                            if (llllllllllllIIIlIIlIlIIIIlIIIIII == Chunk.NULL_BLOCK_STORAGE) {
                                continue;
                            }
                            llllllllllllIIIlIIlIlIIIIlIIIIII.setExtSkylightValue(llllllllllllIIIlIIlIlIIIIlIIIllI, llllllllllllIIIlIIlIlIIIIlIIIIlI & 0xF, llllllllllllIIIlIIlIlIIIIlIIIlIl, llllllllllllIIIlIIlIlIIIIlIIIIll);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllIIIlIIlIlIIIIlIIIllI, llllllllllllIIIlIIlIlIIIIlIIIIlI, (this.zPosition << 4) + llllllllllllIIIlIIlIlIIIIlIIIlIl));
                        }
                    } while (--llllllllllllIIIlIIlIlIIIIlIIIIlI > 0 && llllllllllllIIIlIIlIlIIIIlIIIIll > 0);
                }
            }
        }
        this.isModified = true;
    }
    
    public void removeEntity(final Entity llllllllllllIIIlIIlIIlllIIIIlIII) {
        this.removeEntityAtIndex(llllllllllllIIIlIIlIIlllIIIIlIII, llllllllllllIIIlIIlIIlllIIIIlIII.chunkCoordY);
    }
    
    public void getEntitiesWithinAABBForEntity(@Nullable final Entity llllllllllllIIIlIIlIIllIlIIlIIll, final AxisAlignedBB llllllllllllIIIlIIlIIllIlIIIIlll, final List<Entity> llllllllllllIIIlIIlIIllIlIIlIIIl, final Predicate<? super Entity> llllllllllllIIIlIIlIIllIlIIlIIII) {
        int llllllllllllIIIlIIlIIllIlIIIllll = MathHelper.floor((llllllllllllIIIlIIlIIllIlIIIIlll.minY - 2.0) / 16.0);
        int llllllllllllIIIlIIlIIllIlIIIlllI = MathHelper.floor((llllllllllllIIIlIIlIIllIlIIIIlll.maxY + 2.0) / 16.0);
        llllllllllllIIIlIIlIIllIlIIIllll = MathHelper.clamp(llllllllllllIIIlIIlIIllIlIIIllll, 0, this.entityLists.length - 1);
        llllllllllllIIIlIIlIIllIlIIIlllI = MathHelper.clamp(llllllllllllIIIlIIlIIllIlIIIlllI, 0, this.entityLists.length - 1);
        for (int llllllllllllIIIlIIlIIllIlIIIllIl = llllllllllllIIIlIIlIIllIlIIIllll; llllllllllllIIIlIIlIIllIlIIIllIl <= llllllllllllIIIlIIlIIllIlIIIlllI; ++llllllllllllIIIlIIlIIllIlIIIllIl) {
            if (!this.entityLists[llllllllllllIIIlIIlIIllIlIIIllIl].isEmpty()) {
                for (final Entity llllllllllllIIIlIIlIIllIlIIIllII : this.entityLists[llllllllllllIIIlIIlIIllIlIIIllIl]) {
                    if (llllllllllllIIIlIIlIIllIlIIIllII.getEntityBoundingBox().intersectsWith(llllllllllllIIIlIIlIIllIlIIIIlll) && llllllllllllIIIlIIlIIllIlIIIllII != llllllllllllIIIlIIlIIllIlIIlIIll) {
                        if (llllllllllllIIIlIIlIIllIlIIlIIII == null || llllllllllllIIIlIIlIIllIlIIlIIII.apply((Object)llllllllllllIIIlIIlIIllIlIIIllII)) {
                            llllllllllllIIIlIIlIIllIlIIlIIIl.add(llllllllllllIIIlIIlIIllIlIIIllII);
                        }
                        final Entity[] llllllllllllIIIlIIlIIllIlIIIlIll = llllllllllllIIIlIIlIIllIlIIIllII.getParts();
                        if (llllllllllllIIIlIIlIIllIlIIIlIll == null) {
                            continue;
                        }
                        final float llllllllllllIIIlIIlIIllIIllllIll;
                        final Exception llllllllllllIIIlIIlIIllIIlllllII = (Exception)((Entity[])(Object)(llllllllllllIIIlIIlIIllIIllllIll = (float)(Object)llllllllllllIIIlIIlIIllIlIIIlIll)).length;
                        for (char llllllllllllIIIlIIlIIllIIlllllIl = '\0'; llllllllllllIIIlIIlIIllIIlllllIl < llllllllllllIIIlIIlIIllIIlllllII; ++llllllllllllIIIlIIlIIllIIlllllIl) {
                            final Entity llllllllllllIIIlIIlIIllIlIIIlIlI = llllllllllllIIIlIIlIIllIIllllIll[llllllllllllIIIlIIlIIllIIlllllIl];
                            if (llllllllllllIIIlIIlIIllIlIIIlIlI != llllllllllllIIIlIIlIIllIlIIlIIll && llllllllllllIIIlIIlIIllIlIIIlIlI.getEntityBoundingBox().intersectsWith(llllllllllllIIIlIIlIIllIlIIIIlll) && (llllllllllllIIIlIIlIIllIlIIlIIII == null || llllllllllllIIIlIIlIIllIlIIlIIII.apply((Object)llllllllllllIIIlIIlIIllIlIIIlIlI))) {
                                llllllllllllIIIlIIlIIllIlIIlIIIl.add(llllllllllllIIIlIIlIIllIlIIIlIlI);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public ChunkPos getChunkCoordIntPair() {
        return new ChunkPos(this.xPosition, this.zPosition);
    }
    
    public boolean isLightPopulated() {
        return this.isLightPopulated;
    }
    
    public Random getRandomWithSeed(final long llllllllllllIIIlIIlIIllIIlIlIlII) {
        return new Random(this.worldObj.getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ llllllllllllIIIlIIlIIllIIlIlIlII);
    }
    
    public void setBiomeArray(final byte[] llllllllllllIIIlIIlIIlIllIllIlll) {
        if (this.blockBiomeArray.length != llllllllllllIIIlIIlIIlIllIllIlll.length) {
            Chunk.LOGGER.warn("Could not set level chunk biomes, array length is {} instead of {}", (Object)llllllllllllIIIlIIlIIlIllIllIlll.length, (Object)this.blockBiomeArray.length);
        }
        else {
            System.arraycopy(llllllllllllIIIlIIlIIlIllIllIlll, 0, this.blockBiomeArray, 0, this.blockBiomeArray.length);
        }
    }
    
    public void addTileEntity(final BlockPos llllllllllllIIIlIIlIIllIllIIllIl, final TileEntity llllllllllllIIIlIIlIIllIllIIllII) {
        llllllllllllIIIlIIlIIllIllIIllII.setWorldObj(this.worldObj);
        llllllllllllIIIlIIlIIllIllIIllII.setPos(llllllllllllIIIlIIlIIllIllIIllIl);
        if (this.getBlockState(llllllllllllIIIlIIlIIllIllIIllIl).getBlock() instanceof ITileEntityProvider) {
            if (this.chunkTileEntityMap.containsKey(llllllllllllIIIlIIlIIllIllIIllIl)) {
                this.chunkTileEntityMap.get(llllllllllllIIIlIIlIIllIllIIllIl).invalidate();
            }
            llllllllllllIIIlIIlIIllIllIIllII.validate();
            this.chunkTileEntityMap.put(llllllllllllIIIlIIlIIllIllIIllIl, llllllllllllIIIlIIlIIllIllIIllII);
        }
    }
    
    private int getBlockLightOpacity(final int llllllllllllIIIlIIlIIllllIllIlll, final int llllllllllllIIIlIIlIIllllIllIllI, final int llllllllllllIIIlIIlIIllllIllIlIl) {
        return this.getBlockState(llllllllllllIIIlIIlIIllllIllIlll, llllllllllllIIIlIIlIIllllIllIllI, llllllllllllIIIlIIlIIllllIllIlIl).getLightOpacity();
    }
    
    public boolean canSeeSky(final BlockPos llllllllllllIIIlIIlIIllIllllIIll) {
        final int llllllllllllIIIlIIlIIllIllllIlll = llllllllllllIIIlIIlIIllIllllIIll.getX() & 0xF;
        final int llllllllllllIIIlIIlIIllIllllIllI = llllllllllllIIIlIIlIIllIllllIIll.getY();
        final int llllllllllllIIIlIIlIIllIllllIlIl = llllllllllllIIIlIIlIIllIllllIIll.getZ() & 0xF;
        return llllllllllllIIIlIIlIIllIllllIllI >= this.heightMap[llllllllllllIIIlIIlIIllIllllIlIl << 4 | llllllllllllIIIlIIlIIllIllllIlll];
    }
    
    protected void populateChunk(final IChunkGenerator llllllllllllIIIlIIlIIllIIIllIlIl) {
        if (this.isTerrainPopulated()) {
            if (llllllllllllIIIlIIlIIllIIIllIlIl.generateStructures(this, this.xPosition, this.zPosition)) {
                this.setChunkModified();
            }
        }
        else {
            this.checkLight();
            llllllllllllIIIlIIlIIllIIIllIlIl.populate(this.xPosition, this.zPosition);
            this.setChunkModified();
        }
    }
    
    public void setModified(final boolean llllllllllllIIIlIIlIIlIlIIIlllII) {
        this.isModified = llllllllllllIIIlIIlIIlIlIIIlllII;
    }
    
    public int getHeight(final BlockPos llllllllllllIIIlIIlIlIIIIlllllIl) {
        return this.getHeightValue(llllllllllllIIIlIIlIlIIIIlllllIl.getX() & 0xF, llllllllllllIIIlIIlIlIIIIlllllIl.getZ() & 0xF);
    }
    
    public void addEntity(final Entity llllllllllllIIIlIIlIIlllIIIlIllI) {
        this.hasEntities = true;
        final int llllllllllllIIIlIIlIIlllIIIlIlIl = MathHelper.floor(llllllllllllIIIlIIlIIlllIIIlIllI.posX / 16.0);
        final int llllllllllllIIIlIIlIIlllIIIlIlII = MathHelper.floor(llllllllllllIIIlIIlIIlllIIIlIllI.posZ / 16.0);
        if (llllllllllllIIIlIIlIIlllIIIlIlIl != this.xPosition || llllllllllllIIIlIIlIIlllIIIlIlII != this.zPosition) {
            Chunk.LOGGER.warn("Wrong location! ({}, {}) should be ({}, {}), {}", (Object)llllllllllllIIIlIIlIIlllIIIlIlIl, (Object)llllllllllllIIIlIIlIIlllIIIlIlII, (Object)this.xPosition, (Object)this.zPosition, (Object)llllllllllllIIIlIIlIIlllIIIlIllI);
            llllllllllllIIIlIIlIIlllIIIlIllI.setDead();
        }
        int llllllllllllIIIlIIlIIlllIIIlIIll = MathHelper.floor(llllllllllllIIIlIIlIIlllIIIlIllI.posY / 16.0);
        if (llllllllllllIIIlIIlIIlllIIIlIIll < 0) {
            llllllllllllIIIlIIlIIlllIIIlIIll = 0;
        }
        if (llllllllllllIIIlIIlIIlllIIIlIIll >= this.entityLists.length) {
            llllllllllllIIIlIIlIIlllIIIlIIll = this.entityLists.length - 1;
        }
        llllllllllllIIIlIIlIIlllIIIlIllI.addedToChunk = true;
        llllllllllllIIIlIIlIIlllIIIlIllI.chunkCoordX = this.xPosition;
        llllllllllllIIIlIIlIIlllIIIlIllI.chunkCoordY = llllllllllllIIIlIIlIIlllIIIlIIll;
        llllllllllllIIIlIIlIIlllIIIlIllI.chunkCoordZ = this.zPosition;
        this.entityLists[llllllllllllIIIlIIlIIlllIIIlIIll].add(llllllllllllIIIlIIlIIlllIIIlIllI);
    }
    
    public void populateChunk(final IChunkProvider llllllllllllIIIlIIlIIllIIIllllll, final IChunkGenerator llllllllllllIIIlIIlIIllIIlIIIllI) {
        final Chunk llllllllllllIIIlIIlIIllIIlIIIlIl = llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition, this.zPosition - 1);
        final Chunk llllllllllllIIIlIIlIIllIIlIIIlII = llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition + 1, this.zPosition);
        final Chunk llllllllllllIIIlIIlIIllIIlIIIIll = llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition, this.zPosition + 1);
        final Chunk llllllllllllIIIlIIlIIllIIlIIIIlI = llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition - 1, this.zPosition);
        if (llllllllllllIIIlIIlIIllIIlIIIlII != null && llllllllllllIIIlIIlIIllIIlIIIIll != null && llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition + 1, this.zPosition + 1) != null) {
            this.populateChunk(llllllllllllIIIlIIlIIllIIlIIIllI);
        }
        if (llllllllllllIIIlIIlIIllIIlIIIIlI != null && llllllllllllIIIlIIlIIllIIlIIIIll != null && llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition - 1, this.zPosition + 1) != null) {
            llllllllllllIIIlIIlIIllIIlIIIIlI.populateChunk(llllllllllllIIIlIIlIIllIIlIIIllI);
        }
        if (llllllllllllIIIlIIlIIllIIlIIIlIl != null && llllllllllllIIIlIIlIIllIIlIIIlII != null && llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition + 1, this.zPosition - 1) != null) {
            llllllllllllIIIlIIlIIllIIlIIIlIl.populateChunk(llllllllllllIIIlIIlIIllIIlIIIllI);
        }
        if (llllllllllllIIIlIIlIIllIIlIIIlIl != null && llllllllllllIIIlIIlIIllIIlIIIIlI != null) {
            final Chunk llllllllllllIIIlIIlIIllIIlIIIIIl = llllllllllllIIIlIIlIIllIIIllllll.getLoadedChunk(this.xPosition - 1, this.zPosition - 1);
            if (llllllllllllIIIlIIlIIllIIlIIIIIl != null) {
                llllllllllllIIIlIIlIIllIIlIIIIIl.populateChunk(llllllllllllIIIlIIlIIllIIlIIIllI);
            }
        }
    }
    
    private void checkLightSide(final EnumFacing llllllllllllIIIlIIlIIlIlIlllIIII) {
        if (this.isTerrainPopulated) {
            if (llllllllllllIIIlIIlIIlIlIlllIIII == EnumFacing.EAST) {
                for (int llllllllllllIIIlIIlIIlIlIllIllll = 0; llllllllllllIIIlIIlIIlIlIllIllll < 16; ++llllllllllllIIIlIIlIIlIlIllIllll) {
                    this.checkLight(15, llllllllllllIIIlIIlIIlIlIllIllll);
                }
            }
            else if (llllllllllllIIIlIIlIIlIlIlllIIII == EnumFacing.WEST) {
                for (int llllllllllllIIIlIIlIIlIlIllIlllI = 0; llllllllllllIIIlIIlIIlIlIllIlllI < 16; ++llllllllllllIIIlIIlIIlIlIllIlllI) {
                    this.checkLight(0, llllllllllllIIIlIIlIIlIlIllIlllI);
                }
            }
            else if (llllllllllllIIIlIIlIIlIlIlllIIII == EnumFacing.SOUTH) {
                for (int llllllllllllIIIlIIlIIlIlIllIllIl = 0; llllllllllllIIIlIIlIIlIlIllIllIl < 16; ++llllllllllllIIIlIIlIIlIlIllIllIl) {
                    this.checkLight(llllllllllllIIIlIIlIIlIlIllIllIl, 15);
                }
            }
            else if (llllllllllllIIIlIIlIIlIlIlllIIII == EnumFacing.NORTH) {
                for (int llllllllllllIIIlIIlIIlIlIllIllII = 0; llllllllllllIIIlIIlIIlIlIllIllII < 16; ++llllllllllllIIIlIIlIIlIlIllIllII) {
                    this.checkLight(llllllllllllIIIlIIlIIlIlIllIllII, 0);
                }
            }
        }
    }
    
    private void checkSkylightNeighborHeight(final int llllllllllllIIIlIIlIlIIIIIIIIlIl, final int llllllllllllIIIlIIlIlIIIIIIIIlII, final int llllllllllllIIIlIIlIlIIIIIIIIIll) {
        final int llllllllllllIIIlIIlIlIIIIIIIIlll = this.worldObj.getHeight(new BlockPos(llllllllllllIIIlIIlIlIIIIIIIIlIl, 0, llllllllllllIIIlIIlIlIIIIIIIIlII)).getY();
        if (llllllllllllIIIlIIlIlIIIIIIIIlll > llllllllllllIIIlIIlIlIIIIIIIIIll) {
            this.updateSkylightNeighborHeight(llllllllllllIIIlIIlIlIIIIIIIIlIl, llllllllllllIIIlIIlIlIIIIIIIIlII, llllllllllllIIIlIIlIlIIIIIIIIIll, llllllllllllIIIlIIlIlIIIIIIIIlll + 1);
        }
        else if (llllllllllllIIIlIIlIlIIIIIIIIlll < llllllllllllIIIlIIlIlIIIIIIIIIll) {
            this.updateSkylightNeighborHeight(llllllllllllIIIlIIlIlIIIIIIIIlIl, llllllllllllIIIlIIlIlIIIIIIIIlII, llllllllllllIIIlIIlIlIIIIIIIIlll, llllllllllllIIIlIIlIlIIIIIIIIIll + 1);
        }
    }
    
    public int getBlockLightOpacity(final BlockPos llllllllllllIIIlIIlIIllllIllllIl) {
        return this.getBlockState(llllllllllllIIIlIIlIIllllIllllIl).getLightOpacity();
    }
    
    public IBlockState getBlockState(final int llllllllllllIIIlIIlIIllllIIllIIl, final int llllllllllllIIIlIIlIIllllIIllIII, final int llllllllllllIIIlIIlIIllllIIlIlll) {
        if (this.worldObj.getWorldType() == WorldType.DEBUG_WORLD) {
            IBlockState llllllllllllIIIlIIlIIllllIIlllll = null;
            if (llllllllllllIIIlIIlIIllllIIllIII == 60) {
                llllllllllllIIIlIIlIIllllIIlllll = Blocks.BARRIER.getDefaultState();
            }
            if (llllllllllllIIIlIIlIIllllIIllIII == 70) {
                llllllllllllIIIlIIlIIllllIIlllll = ChunkGeneratorDebug.getBlockStateFor(llllllllllllIIIlIIlIIllllIIllIIl, llllllllllllIIIlIIlIIllllIIlIlll);
            }
            return (llllllllllllIIIlIIlIIllllIIlllll == null) ? Blocks.AIR.getDefaultState() : llllllllllllIIIlIIlIIllllIIlllll;
        }
        try {
            if (llllllllllllIIIlIIlIIllllIIllIII >= 0 && llllllllllllIIIlIIlIIllllIIllIII >> 4 < this.storageArrays.length) {
                final ExtendedBlockStorage llllllllllllIIIlIIlIIllllIIllllI = this.storageArrays[llllllllllllIIIlIIlIIllllIIllIII >> 4];
                if (llllllllllllIIIlIIlIIllllIIllllI != Chunk.NULL_BLOCK_STORAGE) {
                    return llllllllllllIIIlIIlIIllllIIllllI.get(llllllllllllIIIlIIlIIllllIIllIIl & 0xF, llllllllllllIIIlIIlIIllllIIllIII & 0xF, llllllllllllIIIlIIlIIllllIIlIlll & 0xF);
                }
            }
            return Blocks.AIR.getDefaultState();
        }
        catch (Throwable llllllllllllIIIlIIlIIllllIIlllIl) {
            final CrashReport llllllllllllIIIlIIlIIllllIIlllII = CrashReport.makeCrashReport(llllllllllllIIIlIIlIIllllIIlllIl, "Getting block state");
            final CrashReportCategory llllllllllllIIIlIIlIIllllIIllIll = llllllllllllIIIlIIlIIllllIIlllII.makeCategory("Block being got");
            llllllllllllIIIlIIlIIllllIIllIll.setDetail("Location", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(llllllllllllIIIlIIlIIllllIIllIIl, llllllllllllIIIlIIlIIllllIIllIII, llllllllllllIIIlIIlIIllllIIlIlll);
                }
            });
            throw new ReportedException(llllllllllllIIIlIIlIIllllIIlllII);
        }
    }
    
    public Chunk(final World llllllllllllIIIlIIlIlIIIlIllIIIl, final int llllllllllllIIIlIIlIlIIIlIllIlIl, final int llllllllllllIIIlIIlIlIIIlIllIlII) {
        this.storageArrays = new ExtendedBlockStorage[16];
        this.blockBiomeArray = new byte[256];
        this.precipitationHeightMap = new int[256];
        this.updateSkylightColumns = new boolean[256];
        this.chunkTileEntityMap = (Map<BlockPos, TileEntity>)Maps.newHashMap();
        this.queuedLightChecks = 4096;
        this.tileEntityPosQueue = (ConcurrentLinkedQueue<BlockPos>)Queues.newConcurrentLinkedQueue();
        this.entityLists = (ClassInheritanceMultiMap<Entity>[])new ClassInheritanceMultiMap[16];
        this.worldObj = llllllllllllIIIlIIlIlIIIlIllIIIl;
        this.xPosition = llllllllllllIIIlIIlIlIIIlIllIlIl;
        this.zPosition = llllllllllllIIIlIIlIlIIIlIllIlII;
        this.heightMap = new int[256];
        for (int llllllllllllIIIlIIlIlIIIlIllIIll = 0; llllllllllllIIIlIIlIlIIIlIllIIll < this.entityLists.length; ++llllllllllllIIIlIIlIlIIIlIllIIll) {
            this.entityLists[llllllllllllIIIlIIlIlIIIlIllIIll] = new ClassInheritanceMultiMap<Entity>(Entity.class);
        }
        Arrays.fill(this.precipitationHeightMap, -999);
        Arrays.fill(this.blockBiomeArray, (byte)(-1));
    }
    
    public void checkLight() {
        this.isTerrainPopulated = true;
        this.isLightPopulated = true;
        final BlockPos llllllllllllIIIlIIlIIlIllIIIIlII = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        if (this.worldObj.provider.func_191066_m()) {
            if (this.worldObj.isAreaLoaded(llllllllllllIIIlIIlIIlIllIIIIlII.add(-1, 0, -1), llllllllllllIIIlIIlIIlIllIIIIlII.add(16, this.worldObj.getSeaLevel(), 16))) {
            Label_0121:
                for (int llllllllllllIIIlIIlIIlIllIIIIIll = 0; llllllllllllIIIlIIlIIlIllIIIIIll < 16; ++llllllllllllIIIlIIlIIlIllIIIIIll) {
                    for (int llllllllllllIIIlIIlIIlIllIIIIIlI = 0; llllllllllllIIIlIIlIIlIllIIIIIlI < 16; ++llllllllllllIIIlIIlIIlIllIIIIIlI) {
                        if (!this.checkLight(llllllllllllIIIlIIlIIlIllIIIIIll, llllllllllllIIIlIIlIIlIllIIIIIlI)) {
                            this.isLightPopulated = false;
                            break Label_0121;
                        }
                    }
                }
                if (this.isLightPopulated) {
                    for (final EnumFacing llllllllllllIIIlIIlIIlIllIIIIIIl : EnumFacing.Plane.HORIZONTAL) {
                        final int llllllllllllIIIlIIlIIlIllIIIIIII = (llllllllllllIIIlIIlIIlIllIIIIIIl.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? 16 : 1;
                        this.worldObj.getChunkFromBlockCoords(llllllllllllIIIlIIlIIlIllIIIIlII.offset(llllllllllllIIIlIIlIIlIllIIIIIIl, llllllllllllIIIlIIlIIlIllIIIIIII)).checkLightSide(llllllllllllIIIlIIlIIlIllIIIIIIl.getOpposite());
                    }
                    this.setSkylightUpdated();
                }
            }
            else {
                this.isLightPopulated = false;
            }
        }
    }
    
    public void onTick(final boolean llllllllllllIIIlIIlIIllIIIIIllll) {
        if (this.isGapLightingUpdated && this.worldObj.provider.func_191066_m() && !llllllllllllIIIlIIlIIllIIIIIllll) {
            this.recheckGaps(this.worldObj.isRemote);
        }
        this.chunkTicked = true;
        if (!this.isLightPopulated && this.isTerrainPopulated) {
            this.checkLight();
        }
        while (!this.tileEntityPosQueue.isEmpty()) {
            final BlockPos llllllllllllIIIlIIlIIllIIIIIlllI = this.tileEntityPosQueue.poll();
            if (this.getTileEntity(llllllllllllIIIlIIlIIllIIIIIlllI, EnumCreateEntityType.CHECK) == null && this.getBlockState(llllllllllllIIIlIIlIIllIIIIIlllI).getBlock().hasTileEntity()) {
                final TileEntity llllllllllllIIIlIIlIIllIIIIIllIl = this.createNewTileEntity(llllllllllllIIIlIIlIIllIIIIIlllI);
                this.worldObj.setTileEntity(llllllllllllIIIlIIlIIllIIIIIlllI, llllllllllllIIIlIIlIIllIIIIIllIl);
                this.worldObj.markBlockRangeForRenderUpdate(llllllllllllIIIlIIlIIllIIIIIlllI, llllllllllllIIIlIIlIIllIIIIIlllI);
            }
        }
    }
    
    public void fillChunk(final PacketBuffer llllllllllllIIIlIIlIIlIllllIIIlI, final int llllllllllllIIIlIIlIIlIlllIllIII, final boolean llllllllllllIIIlIIlIIlIllllIIIII) {
        final boolean llllllllllllIIIlIIlIIlIlllIlllll = this.worldObj.provider.func_191066_m();
        for (int llllllllllllIIIlIIlIIlIlllIllllI = 0; llllllllllllIIIlIIlIIlIlllIllllI < this.storageArrays.length; ++llllllllllllIIIlIIlIIlIlllIllllI) {
            ExtendedBlockStorage llllllllllllIIIlIIlIIlIlllIlllIl = this.storageArrays[llllllllllllIIIlIIlIIlIlllIllllI];
            if ((llllllllllllIIIlIIlIIlIlllIllIII & 1 << llllllllllllIIIlIIlIIlIlllIllllI) == 0x0) {
                if (llllllllllllIIIlIIlIIlIllllIIIII && llllllllllllIIIlIIlIIlIlllIlllIl != Chunk.NULL_BLOCK_STORAGE) {
                    this.storageArrays[llllllllllllIIIlIIlIIlIlllIllllI] = Chunk.NULL_BLOCK_STORAGE;
                }
            }
            else {
                if (llllllllllllIIIlIIlIIlIlllIlllIl == Chunk.NULL_BLOCK_STORAGE) {
                    llllllllllllIIIlIIlIIlIlllIlllIl = new ExtendedBlockStorage(llllllllllllIIIlIIlIIlIlllIllllI << 4, llllllllllllIIIlIIlIIlIlllIlllll);
                    this.storageArrays[llllllllllllIIIlIIlIIlIlllIllllI] = llllllllllllIIIlIIlIIlIlllIlllIl;
                }
                llllllllllllIIIlIIlIIlIlllIlllIl.getData().read(llllllllllllIIIlIIlIIlIllllIIIlI);
                llllllllllllIIIlIIlIIlIllllIIIlI.readBytes(llllllllllllIIIlIIlIIlIlllIlllIl.getBlocklightArray().getData());
                if (llllllllllllIIIlIIlIIlIlllIlllll) {
                    llllllllllllIIIlIIlIIlIllllIIIlI.readBytes(llllllllllllIIIlIIlIIlIlllIlllIl.getSkylightArray().getData());
                }
            }
        }
        if (llllllllllllIIIlIIlIIlIllllIIIII) {
            llllllllllllIIIlIIlIIlIllllIIIlI.readBytes(this.blockBiomeArray);
        }
        for (int llllllllllllIIIlIIlIIlIlllIlllII = 0; llllllllllllIIIlIIlIIlIlllIlllII < this.storageArrays.length; ++llllllllllllIIIlIIlIIlIlllIlllII) {
            if (this.storageArrays[llllllllllllIIIlIIlIIlIlllIlllII] != Chunk.NULL_BLOCK_STORAGE && (llllllllllllIIIlIIlIIlIlllIllIII & 1 << llllllllllllIIIlIIlIIlIlllIlllII) != 0x0) {
                this.storageArrays[llllllllllllIIIlIIlIIlIlllIlllII].removeInvalidBlocks();
            }
        }
        this.isLightPopulated = true;
        this.isTerrainPopulated = true;
        this.generateHeightMap();
        for (final TileEntity llllllllllllIIIlIIlIIlIlllIllIll : this.chunkTileEntityMap.values()) {
            llllllllllllIIIlIIlIIlIlllIllIll.updateContainingBlockInfo();
        }
    }
    
    public Map<BlockPos, TileEntity> getTileEntityMap() {
        return this.chunkTileEntityMap;
    }
    
    public IBlockState getBlockState(final BlockPos llllllllllllIIIlIIlIIllllIlIlIll) {
        return this.getBlockState(llllllllllllIIIlIIlIIllllIlIlIll.getX(), llllllllllllIIIlIIlIIllllIlIlIll.getY(), llllllllllllIIIlIIlIIllllIlIlIll.getZ());
    }
    
    public Chunk(final World llllllllllllIIIlIIlIlIIIlIIlIlII, final ChunkPrimer llllllllllllIIIlIIlIlIIIlIIlllll, final int llllllllllllIIIlIIlIlIIIlIIllllI, final int llllllllllllIIIlIIlIlIIIlIIlllIl) {
        this(llllllllllllIIIlIIlIlIIIlIIlIlII, llllllllllllIIIlIIlIlIIIlIIllllI, llllllllllllIIIlIIlIlIIIlIIlllIl);
        final int llllllllllllIIIlIIlIlIIIlIIlllII = 256;
        final boolean llllllllllllIIIlIIlIlIIIlIIllIll = llllllllllllIIIlIIlIlIIIlIIlIlII.provider.func_191066_m();
        for (int llllllllllllIIIlIIlIlIIIlIIllIlI = 0; llllllllllllIIIlIIlIlIIIlIIllIlI < 16; ++llllllllllllIIIlIIlIlIIIlIIllIlI) {
            for (int llllllllllllIIIlIIlIlIIIlIIllIIl = 0; llllllllllllIIIlIIlIlIIIlIIllIIl < 16; ++llllllllllllIIIlIIlIlIIIlIIllIIl) {
                for (int llllllllllllIIIlIIlIlIIIlIIllIII = 0; llllllllllllIIIlIIlIlIIIlIIllIII < 256; ++llllllllllllIIIlIIlIlIIIlIIllIII) {
                    final IBlockState llllllllllllIIIlIIlIlIIIlIIlIlll = llllllllllllIIIlIIlIlIIIlIIlllll.getBlockState(llllllllllllIIIlIIlIlIIIlIIllIlI, llllllllllllIIIlIIlIlIIIlIIllIII, llllllllllllIIIlIIlIlIIIlIIllIIl);
                    if (llllllllllllIIIlIIlIlIIIlIIlIlll.getMaterial() != Material.AIR) {
                        final int llllllllllllIIIlIIlIlIIIlIIlIllI = llllllllllllIIIlIIlIlIIIlIIllIII >> 4;
                        if (this.storageArrays[llllllllllllIIIlIIlIlIIIlIIlIllI] == Chunk.NULL_BLOCK_STORAGE) {
                            this.storageArrays[llllllllllllIIIlIIlIlIIIlIIlIllI] = new ExtendedBlockStorage(llllllllllllIIIlIIlIlIIIlIIlIllI << 4, llllllllllllIIIlIIlIlIIIlIIllIll);
                        }
                        this.storageArrays[llllllllllllIIIlIIlIlIIIlIIlIllI].set(llllllllllllIIIlIIlIlIIIlIIllIlI, llllllllllllIIIlIIlIlIIIlIIllIII & 0xF, llllllllllllIIIlIIlIlIIIlIIllIIl, llllllllllllIIIlIIlIlIIIlIIlIlll);
                    }
                }
            }
        }
    }
    
    private void propagateSkylightOcclusion(final int llllllllllllIIIlIIlIlIIIIIllIIll, final int llllllllllllIIIlIIlIlIIIIIllIIlI) {
        this.updateSkylightColumns[llllllllllllIIIlIIlIlIIIIIllIIll + llllllllllllIIIlIIlIlIIIIIllIIlI * 16] = true;
        this.isGapLightingUpdated = true;
    }
    
    public int getTopFilledSegment() {
        final ExtendedBlockStorage llllllllllllIIIlIIlIlIIIIllIlIII = this.getLastExtendedBlockStorage();
        return (llllllllllllIIIlIIlIlIIIIllIlIII == null) ? 0 : llllllllllllIIIlIIlIlIIIIllIlIII.getYLocation();
    }
    
    @Nullable
    public IBlockState setBlockState(final BlockPos llllllllllllIIIlIIlIIllllIIIIIll, final IBlockState llllllllllllIIIlIIlIIllllIIIIIlI) {
        final int llllllllllllIIIlIIlIIllllIIIIIIl = llllllllllllIIIlIIlIIllllIIIIIll.getX() & 0xF;
        final int llllllllllllIIIlIIlIIllllIIIIIII = llllllllllllIIIlIIlIIllllIIIIIll.getY();
        final int llllllllllllIIIlIIlIIlllIlllllll = llllllllllllIIIlIIlIIllllIIIIIll.getZ() & 0xF;
        final int llllllllllllIIIlIIlIIlllIllllllI = llllllllllllIIIlIIlIIlllIlllllll << 4 | llllllllllllIIIlIIlIIllllIIIIIIl;
        if (llllllllllllIIIlIIlIIllllIIIIIII >= this.precipitationHeightMap[llllllllllllIIIlIIlIIlllIllllllI] - 1) {
            this.precipitationHeightMap[llllllllllllIIIlIIlIIlllIllllllI] = -999;
        }
        final int llllllllllllIIIlIIlIIlllIlllllIl = this.heightMap[llllllllllllIIIlIIlIIlllIllllllI];
        final IBlockState llllllllllllIIIlIIlIIlllIlllllII = this.getBlockState(llllllllllllIIIlIIlIIllllIIIIIll);
        if (llllllllllllIIIlIIlIIlllIlllllII == llllllllllllIIIlIIlIIllllIIIIIlI) {
            return null;
        }
        final Block llllllllllllIIIlIIlIIlllIllllIll = llllllllllllIIIlIIlIIllllIIIIIlI.getBlock();
        final Block llllllllllllIIIlIIlIIlllIllllIlI = llllllllllllIIIlIIlIIlllIlllllII.getBlock();
        ExtendedBlockStorage llllllllllllIIIlIIlIIlllIllllIIl = this.storageArrays[llllllllllllIIIlIIlIIllllIIIIIII >> 4];
        boolean llllllllllllIIIlIIlIIlllIllllIII = false;
        if (llllllllllllIIIlIIlIIlllIllllIIl == Chunk.NULL_BLOCK_STORAGE) {
            if (llllllllllllIIIlIIlIIlllIllllIll == Blocks.AIR) {
                return null;
            }
            llllllllllllIIIlIIlIIlllIllllIIl = new ExtendedBlockStorage(llllllllllllIIIlIIlIIllllIIIIIII >> 4 << 4, this.worldObj.provider.func_191066_m());
            this.storageArrays[llllllllllllIIIlIIlIIllllIIIIIII >> 4] = llllllllllllIIIlIIlIIlllIllllIIl;
            llllllllllllIIIlIIlIIlllIllllIII = (llllllllllllIIIlIIlIIllllIIIIIII >= llllllllllllIIIlIIlIIlllIlllllIl);
        }
        llllllllllllIIIlIIlIIlllIllllIIl.set(llllllllllllIIIlIIlIIllllIIIIIIl, llllllllllllIIIlIIlIIllllIIIIIII & 0xF, llllllllllllIIIlIIlIIlllIlllllll, llllllllllllIIIlIIlIIllllIIIIIlI);
        if (llllllllllllIIIlIIlIIlllIllllIlI != llllllllllllIIIlIIlIIlllIllllIll) {
            if (!this.worldObj.isRemote) {
                llllllllllllIIIlIIlIIlllIllllIlI.breakBlock(this.worldObj, llllllllllllIIIlIIlIIllllIIIIIll, llllllllllllIIIlIIlIIlllIlllllII);
            }
            else if (llllllllllllIIIlIIlIIlllIllllIlI instanceof ITileEntityProvider) {
                this.worldObj.removeTileEntity(llllllllllllIIIlIIlIIllllIIIIIll);
            }
        }
        if (llllllllllllIIIlIIlIIlllIllllIIl.get(llllllllllllIIIlIIlIIllllIIIIIIl, llllllllllllIIIlIIlIIllllIIIIIII & 0xF, llllllllllllIIIlIIlIIlllIlllllll).getBlock() != llllllllllllIIIlIIlIIlllIllllIll) {
            return null;
        }
        if (llllllllllllIIIlIIlIIlllIllllIII) {
            this.generateSkylightMap();
        }
        else {
            final int llllllllllllIIIlIIlIIlllIlllIlll = llllllllllllIIIlIIlIIllllIIIIIlI.getLightOpacity();
            final int llllllllllllIIIlIIlIIlllIlllIllI = llllllllllllIIIlIIlIIlllIlllllII.getLightOpacity();
            if (llllllllllllIIIlIIlIIlllIlllIlll > 0) {
                if (llllllllllllIIIlIIlIIllllIIIIIII >= llllllllllllIIIlIIlIIlllIlllllIl) {
                    this.relightBlock(llllllllllllIIIlIIlIIllllIIIIIIl, llllllllllllIIIlIIlIIllllIIIIIII + 1, llllllllllllIIIlIIlIIlllIlllllll);
                }
            }
            else if (llllllllllllIIIlIIlIIllllIIIIIII == llllllllllllIIIlIIlIIlllIlllllIl - 1) {
                this.relightBlock(llllllllllllIIIlIIlIIllllIIIIIIl, llllllllllllIIIlIIlIIllllIIIIIII, llllllllllllIIIlIIlIIlllIlllllll);
            }
            if (llllllllllllIIIlIIlIIlllIlllIlll != llllllllllllIIIlIIlIIlllIlllIllI && (llllllllllllIIIlIIlIIlllIlllIlll < llllllllllllIIIlIIlIIlllIlllIllI || this.getLightFor(EnumSkyBlock.SKY, llllllllllllIIIlIIlIIllllIIIIIll) > 0 || this.getLightFor(EnumSkyBlock.BLOCK, llllllllllllIIIlIIlIIllllIIIIIll) > 0)) {
                this.propagateSkylightOcclusion(llllllllllllIIIlIIlIIllllIIIIIIl, llllllllllllIIIlIIlIIlllIlllllll);
            }
        }
        if (llllllllllllIIIlIIlIIlllIllllIlI instanceof ITileEntityProvider) {
            final TileEntity llllllllllllIIIlIIlIIlllIlllIlIl = this.getTileEntity(llllllllllllIIIlIIlIIllllIIIIIll, EnumCreateEntityType.CHECK);
            if (llllllllllllIIIlIIlIIlllIlllIlIl != null) {
                llllllllllllIIIlIIlIIlllIlllIlIl.updateContainingBlockInfo();
            }
        }
        if (!this.worldObj.isRemote && llllllllllllIIIlIIlIIlllIllllIlI != llllllllllllIIIlIIlIIlllIllllIll) {
            llllllllllllIIIlIIlIIlllIllllIll.onBlockAdded(this.worldObj, llllllllllllIIIlIIlIIllllIIIIIll, llllllllllllIIIlIIlIIllllIIIIIlI);
        }
        if (llllllllllllIIIlIIlIIlllIllllIll instanceof ITileEntityProvider) {
            TileEntity llllllllllllIIIlIIlIIlllIlllIlII = this.getTileEntity(llllllllllllIIIlIIlIIllllIIIIIll, EnumCreateEntityType.CHECK);
            if (llllllllllllIIIlIIlIIlllIlllIlII == null) {
                llllllllllllIIIlIIlIIlllIlllIlII = ((ITileEntityProvider)llllllllllllIIIlIIlIIlllIllllIll).createNewTileEntity(this.worldObj, llllllllllllIIIlIIlIIlllIllllIll.getMetaFromState(llllllllllllIIIlIIlIIllllIIIIIlI));
                this.worldObj.setTileEntity(llllllllllllIIIlIIlIIllllIIIIIll, llllllllllllIIIlIIlIIlllIlllIlII);
            }
            if (llllllllllllIIIlIIlIIlllIlllIlII != null) {
                llllllllllllIIIlIIlIIlllIlllIlII.updateContainingBlockInfo();
            }
        }
        this.isModified = true;
        return llllllllllllIIIlIIlIIlllIlllllII;
    }
    
    public boolean getAreLevelsEmpty(int llllllllllllIIIlIIlIIlIlllllIlII, int llllllllllllIIIlIIlIIlIlllllIIll) {
        if (llllllllllllIIIlIIlIIlIlllllIlII < 0) {
            llllllllllllIIIlIIlIIlIlllllIlII = 0;
        }
        if (llllllllllllIIIlIIlIIlIlllllIIll >= 256) {
            llllllllllllIIIlIIlIIlIlllllIIll = 255;
        }
        for (int llllllllllllIIIlIIlIIlIlllllIlll = (int)llllllllllllIIIlIIlIIlIlllllIlII; llllllllllllIIIlIIlIIlIlllllIlll <= llllllllllllIIIlIIlIIlIlllllIIll; llllllllllllIIIlIIlIIlIlllllIlll += 16) {
            final ExtendedBlockStorage llllllllllllIIIlIIlIIlIlllllIllI = this.storageArrays[llllllllllllIIIlIIlIIlIlllllIlll >> 4];
            if (llllllllllllIIIlIIlIIlIlllllIllI != Chunk.NULL_BLOCK_STORAGE && !llllllllllllIIIlIIlIIlIlllllIllI.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean needsSaving(final boolean llllllllllllIIIlIIlIIllIIlIllIlI) {
        if (llllllllllllIIIlIIlIIllIIlIllIlI) {
            if ((this.hasEntities && this.worldObj.getTotalWorldTime() != this.lastSaveTime) || this.isModified) {
                return true;
            }
        }
        else if (this.hasEntities && this.worldObj.getTotalWorldTime() >= this.lastSaveTime + 600L) {
            return true;
        }
        return this.isModified;
    }
    
    public void removeEntityAtIndex(final Entity llllllllllllIIIlIIlIIlllIIIIIIII, int llllllllllllIIIlIIlIIllIllllllll) {
        if (llllllllllllIIIlIIlIIllIllllllll < 0) {
            llllllllllllIIIlIIlIIllIllllllll = 0;
        }
        if (llllllllllllIIIlIIlIIllIllllllll >= this.entityLists.length) {
            llllllllllllIIIlIIlIIllIllllllll = this.entityLists.length - 1;
        }
        this.entityLists[llllllllllllIIIlIIlIIllIllllllll].remove(llllllllllllIIIlIIlIIlllIIIIIIII);
    }
    
    public void setChunkModified() {
        this.isModified = true;
    }
    
    public void setHeightMap(final int[] llllllllllllIIIlIIlIIlIlIIlllIII) {
        if (this.heightMap.length != llllllllllllIIIlIIlIIlIlIIlllIII.length) {
            Chunk.LOGGER.warn("Could not set level chunk heightmap, array length is {} instead of {}", (Object)llllllllllllIIIlIIlIIlIlIIlllIII.length, (Object)this.heightMap.length);
        }
        else {
            System.arraycopy(llllllllllllIIIlIIlIIlIlIIlllIII, 0, this.heightMap, 0, this.heightMap.length);
        }
    }
    
    private void relightBlock(final int llllllllllllIIIlIIlIIllllllIIIIl, final int llllllllllllIIIlIIlIIlllllIIllIl, final int llllllllllllIIIlIIlIIlllllIIllII) {
        int llllllllllllIIIlIIlIIlllllIlllIl;
        final int llllllllllllIIIlIIlIIlllllIllllI = llllllllllllIIIlIIlIIlllllIlllIl = (this.heightMap[llllllllllllIIIlIIlIIlllllIIllII << 4 | llllllllllllIIIlIIlIIllllllIIIIl] & 0xFF);
        if (llllllllllllIIIlIIlIIlllllIIllIl > llllllllllllIIIlIIlIIlllllIllllI) {
            llllllllllllIIIlIIlIIlllllIlllIl = llllllllllllIIIlIIlIIlllllIIllIl;
        }
        while (llllllllllllIIIlIIlIIlllllIlllIl > 0 && this.getBlockLightOpacity(llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIlllIl - 1, llllllllllllIIIlIIlIIlllllIIllII) == 0) {
            --llllllllllllIIIlIIlIIlllllIlllIl;
        }
        if (llllllllllllIIIlIIlIIlllllIlllIl != llllllllllllIIIlIIlIIlllllIllllI) {
            this.worldObj.markBlocksDirtyVertical(llllllllllllIIIlIIlIIllllllIIIIl + this.xPosition * 16, llllllllllllIIIlIIlIIlllllIIllII + this.zPosition * 16, llllllllllllIIIlIIlIIlllllIlllIl, llllllllllllIIIlIIlIIlllllIllllI);
            this.heightMap[llllllllllllIIIlIIlIIlllllIIllII << 4 | llllllllllllIIIlIIlIIllllllIIIIl] = llllllllllllIIIlIIlIIlllllIlllIl;
            final int llllllllllllIIIlIIlIIlllllIlllII = this.xPosition * 16 + llllllllllllIIIlIIlIIllllllIIIIl;
            final int llllllllllllIIIlIIlIIlllllIllIll = this.zPosition * 16 + llllllllllllIIIlIIlIIlllllIIllII;
            if (this.worldObj.provider.func_191066_m()) {
                if (llllllllllllIIIlIIlIIlllllIlllIl < llllllllllllIIIlIIlIIlllllIllllI) {
                    for (int llllllllllllIIIlIIlIIlllllIllIlI = llllllllllllIIIlIIlIIlllllIlllIl; llllllllllllIIIlIIlIIlllllIllIlI < llllllllllllIIIlIIlIIlllllIllllI; ++llllllllllllIIIlIIlIIlllllIllIlI) {
                        final ExtendedBlockStorage llllllllllllIIIlIIlIIlllllIllIIl = this.storageArrays[llllllllllllIIIlIIlIIlllllIllIlI >> 4];
                        if (llllllllllllIIIlIIlIIlllllIllIIl != Chunk.NULL_BLOCK_STORAGE) {
                            llllllllllllIIIlIIlIIlllllIllIIl.setExtSkylightValue(llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIllIlI & 0xF, llllllllllllIIIlIIlIIlllllIIllII, 15);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIllIlI, (this.zPosition << 4) + llllllllllllIIIlIIlIIlllllIIllII));
                        }
                    }
                }
                else {
                    for (int llllllllllllIIIlIIlIIlllllIllIII = llllllllllllIIIlIIlIIlllllIllllI; llllllllllllIIIlIIlIIlllllIllIII < llllllllllllIIIlIIlIIlllllIlllIl; ++llllllllllllIIIlIIlIIlllllIllIII) {
                        final ExtendedBlockStorage llllllllllllIIIlIIlIIlllllIlIlll = this.storageArrays[llllllllllllIIIlIIlIIlllllIllIII >> 4];
                        if (llllllllllllIIIlIIlIIlllllIlIlll != Chunk.NULL_BLOCK_STORAGE) {
                            llllllllllllIIIlIIlIIlllllIlIlll.setExtSkylightValue(llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIllIII & 0xF, llllllllllllIIIlIIlIIlllllIIllII, 0);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIllIII, (this.zPosition << 4) + llllllllllllIIIlIIlIIlllllIIllII));
                        }
                    }
                }
                int llllllllllllIIIlIIlIIlllllIlIllI = 15;
                while (llllllllllllIIIlIIlIIlllllIlllIl > 0 && llllllllllllIIIlIIlIIlllllIlIllI > 0) {
                    --llllllllllllIIIlIIlIIlllllIlllIl;
                    int llllllllllllIIIlIIlIIlllllIlIlIl = this.getBlockLightOpacity(llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIlllIl, llllllllllllIIIlIIlIIlllllIIllII);
                    if (llllllllllllIIIlIIlIIlllllIlIlIl == 0) {
                        llllllllllllIIIlIIlIIlllllIlIlIl = 1;
                    }
                    llllllllllllIIIlIIlIIlllllIlIllI -= llllllllllllIIIlIIlIIlllllIlIlIl;
                    if (llllllllllllIIIlIIlIIlllllIlIllI < 0) {
                        llllllllllllIIIlIIlIIlllllIlIllI = 0;
                    }
                    final ExtendedBlockStorage llllllllllllIIIlIIlIIlllllIlIlII = this.storageArrays[llllllllllllIIIlIIlIIlllllIlllIl >> 4];
                    if (llllllllllllIIIlIIlIIlllllIlIlII != Chunk.NULL_BLOCK_STORAGE) {
                        llllllllllllIIIlIIlIIlllllIlIlII.setExtSkylightValue(llllllllllllIIIlIIlIIllllllIIIIl, llllllllllllIIIlIIlIIlllllIlllIl & 0xF, llllllllllllIIIlIIlIIlllllIIllII, llllllllllllIIIlIIlIIlllllIlIllI);
                    }
                }
            }
            final int llllllllllllIIIlIIlIIlllllIlIIll = this.heightMap[llllllllllllIIIlIIlIIlllllIIllII << 4 | llllllllllllIIIlIIlIIllllllIIIIl];
            int llllllllllllIIIlIIlIIlllllIlIIIl;
            int llllllllllllIIIlIIlIIlllllIlIIlI;
            if ((llllllllllllIIIlIIlIIlllllIlIIIl = llllllllllllIIIlIIlIIlllllIlIIll) < (llllllllllllIIIlIIlIIlllllIlIIlI = llllllllllllIIIlIIlIIlllllIllllI)) {
                llllllllllllIIIlIIlIIlllllIlIIlI = llllllllllllIIIlIIlIIlllllIlIIll;
                llllllllllllIIIlIIlIIlllllIlIIIl = llllllllllllIIIlIIlIIlllllIllllI;
            }
            if (llllllllllllIIIlIIlIIlllllIlIIll < this.heightMapMinimum) {
                this.heightMapMinimum = llllllllllllIIIlIIlIIlllllIlIIll;
            }
            if (this.worldObj.provider.func_191066_m()) {
                for (final EnumFacing llllllllllllIIIlIIlIIlllllIlIIII : EnumFacing.Plane.HORIZONTAL) {
                    this.updateSkylightNeighborHeight(llllllllllllIIIlIIlIIlllllIlllII + llllllllllllIIIlIIlIIlllllIlIIII.getFrontOffsetX(), llllllllllllIIIlIIlIIlllllIllIll + llllllllllllIIIlIIlIIlllllIlIIII.getFrontOffsetZ(), llllllllllllIIIlIIlIIlllllIlIIlI, llllllllllllIIIlIIlIIlllllIlIIIl);
                }
                this.updateSkylightNeighborHeight(llllllllllllIIIlIIlIIlllllIlllII, llllllllllllIIIlIIlIIlllllIllIll, llllllllllllIIIlIIlIIlllllIlIIlI, llllllllllllIIIlIIlIIlllllIlIIIl);
            }
            this.isModified = true;
        }
    }
    
    public void setLightPopulated(final boolean llllllllllllIIIlIIlIIlIlIIlIIIII) {
        this.isLightPopulated = llllllllllllIIIlIIlIIlIlIIlIIIII;
    }
    
    public void setInhabitedTime(final long llllllllllllIIIlIIlIIlIlIIIIIIlI) {
        this.inhabitedTime = llllllllllllIIIlIIlIIlIlIIIIIIlI;
    }
    
    public int getHeightValue(final int llllllllllllIIIlIIlIlIIIIlllIllI, final int llllllllllllIIIlIIlIlIIIIlllIlIl) {
        return this.heightMap[llllllllllllIIIlIIlIlIIIIlllIlIl << 4 | llllllllllllIIIlIIlIlIIIIlllIllI];
    }
    
    public void setTerrainPopulated(final boolean llllllllllllIIIlIIlIIlIlIIlIlIll) {
        this.isTerrainPopulated = llllllllllllIIIlIIlIIlIlIIlIlIll;
    }
    
    public ClassInheritanceMultiMap<Entity>[] getEntityLists() {
        return this.entityLists;
    }
    
    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(final Class<? extends T> llllllllllllIIIlIIlIIllIIllIllll, final AxisAlignedBB llllllllllllIIIlIIlIIllIIllIlllI, final List<T> llllllllllllIIIlIIlIIllIIllIllIl, final Predicate<? super T> llllllllllllIIIlIIlIIllIIllIIIll) {
        int llllllllllllIIIlIIlIIllIIllIlIll = MathHelper.floor((llllllllllllIIIlIIlIIllIIllIlllI.minY - 2.0) / 16.0);
        int llllllllllllIIIlIIlIIllIIllIlIlI = MathHelper.floor((llllllllllllIIIlIIlIIllIIllIlllI.maxY + 2.0) / 16.0);
        llllllllllllIIIlIIlIIllIIllIlIll = MathHelper.clamp(llllllllllllIIIlIIlIIllIIllIlIll, 0, this.entityLists.length - 1);
        llllllllllllIIIlIIlIIllIIllIlIlI = MathHelper.clamp(llllllllllllIIIlIIlIIllIIllIlIlI, 0, this.entityLists.length - 1);
        for (int llllllllllllIIIlIIlIIllIIllIlIIl = llllllllllllIIIlIIlIIllIIllIlIll; llllllllllllIIIlIIlIIllIIllIlIIl <= llllllllllllIIIlIIlIIllIIllIlIlI; ++llllllllllllIIIlIIlIIllIIllIlIIl) {
            for (final T llllllllllllIIIlIIlIIllIIllIlIII : this.entityLists[llllllllllllIIIlIIlIIllIIllIlIIl].getByClass(llllllllllllIIIlIIlIIllIIllIllll)) {
                if (llllllllllllIIIlIIlIIllIIllIlIII.getEntityBoundingBox().intersectsWith(llllllllllllIIIlIIlIIllIIllIlllI) && (llllllllllllIIIlIIlIIllIIllIIIll == null || llllllllllllIIIlIIlIIllIIllIIIll.apply((Object)llllllllllllIIIlIIlIIllIIllIlIII))) {
                    llllllllllllIIIlIIlIIllIIllIllIl.add(llllllllllllIIIlIIlIIllIIllIlIII);
                }
            }
        }
    }
    
    public BlockPos getPrecipitationHeight(final BlockPos llllllllllllIIIlIIlIIllIIIIlllIl) {
        final int llllllllllllIIIlIIlIIllIIIlIIllI = llllllllllllIIIlIIlIIllIIIIlllIl.getX() & 0xF;
        final int llllllllllllIIIlIIlIIllIIIlIIlIl = llllllllllllIIIlIIlIIllIIIIlllIl.getZ() & 0xF;
        final int llllllllllllIIIlIIlIIllIIIlIIlII = llllllllllllIIIlIIlIIllIIIlIIllI | llllllllllllIIIlIIlIIllIIIlIIlIl << 4;
        BlockPos llllllllllllIIIlIIlIIllIIIlIIIll = new BlockPos(llllllllllllIIIlIIlIIllIIIIlllIl.getX(), this.precipitationHeightMap[llllllllllllIIIlIIlIIllIIIlIIlII], llllllllllllIIIlIIlIIllIIIIlllIl.getZ());
        if (llllllllllllIIIlIIlIIllIIIlIIIll.getY() == -999) {
            final int llllllllllllIIIlIIlIIllIIIlIIIlI = this.getTopFilledSegment() + 15;
            llllllllllllIIIlIIlIIllIIIlIIIll = new BlockPos(llllllllllllIIIlIIlIIllIIIIlllIl.getX(), llllllllllllIIIlIIlIIllIIIlIIIlI, llllllllllllIIIlIIlIIllIIIIlllIl.getZ());
            int llllllllllllIIIlIIlIIllIIIlIIIIl = -1;
            while (llllllllllllIIIlIIlIIllIIIlIIIll.getY() > 0 && llllllllllllIIIlIIlIIllIIIlIIIIl == -1) {
                final IBlockState llllllllllllIIIlIIlIIllIIIlIIIII = this.getBlockState(llllllllllllIIIlIIlIIllIIIlIIIll);
                final Material llllllllllllIIIlIIlIIllIIIIlllll = llllllllllllIIIlIIlIIllIIIlIIIII.getMaterial();
                if (!llllllllllllIIIlIIlIIllIIIIlllll.blocksMovement() && !llllllllllllIIIlIIlIIllIIIIlllll.isLiquid()) {
                    llllllllllllIIIlIIlIIllIIIlIIIll = llllllllllllIIIlIIlIIllIIIlIIIll.down();
                }
                else {
                    llllllllllllIIIlIIlIIllIIIlIIIIl = llllllllllllIIIlIIlIIllIIIlIIIll.getY() + 1;
                }
            }
            this.precipitationHeightMap[llllllllllllIIIlIIlIIllIIIlIIlII] = llllllllllllIIIlIIlIIllIIIlIIIIl;
        }
        return new BlockPos(llllllllllllIIIlIIlIIllIIIIlllIl.getX(), this.precipitationHeightMap[llllllllllllIIIlIIlIIllIIIlIIlII], llllllllllllIIIlIIlIIllIIIIlllIl.getZ());
    }
    
    public int[] getHeightMap() {
        return this.heightMap;
    }
    
    public Biome getBiome(final BlockPos llllllllllllIIIlIIlIIlIlllIIIIll, final BiomeProvider llllllllllllIIIlIIlIIlIlllIIlIlI) {
        final int llllllllllllIIIlIIlIIlIlllIIlIIl = llllllllllllIIIlIIlIIlIlllIIIIll.getX() & 0xF;
        final int llllllllllllIIIlIIlIIlIlllIIlIII = llllllllllllIIIlIIlIIlIlllIIIIll.getZ() & 0xF;
        int llllllllllllIIIlIIlIIlIlllIIIlll = this.blockBiomeArray[llllllllllllIIIlIIlIIlIlllIIlIII << 4 | llllllllllllIIIlIIlIIlIlllIIlIIl] & 0xFF;
        if (llllllllllllIIIlIIlIIlIlllIIIlll == 255) {
            final Biome llllllllllllIIIlIIlIIlIlllIIIllI = llllllllllllIIIlIIlIIlIlllIIlIlI.getBiome(llllllllllllIIIlIIlIIlIlllIIIIll, Biomes.PLAINS);
            llllllllllllIIIlIIlIIlIlllIIIlll = Biome.getIdForBiome(llllllllllllIIIlIIlIIlIlllIIIllI);
            this.blockBiomeArray[llllllllllllIIIlIIlIIlIlllIIlIII << 4 | llllllllllllIIIlIIlIIlIlllIIlIIl] = (byte)(llllllllllllIIIlIIlIIlIlllIIIlll & 0xFF);
        }
        final Biome llllllllllllIIIlIIlIIlIlllIIIlIl = Biome.getBiome(llllllllllllIIIlIIlIIlIlllIIIlll);
        return (llllllllllllIIIlIIlIIlIlllIIIlIl == null) ? Biomes.PLAINS : llllllllllllIIIlIIlIIlIlllIIIlIl;
    }
    
    private void updateSkylightNeighborHeight(final int llllllllllllIIIlIIlIIlllllllIlII, final int llllllllllllIIIlIIlIIllllllllIIl, final int llllllllllllIIIlIIlIIllllllllIII, final int llllllllllllIIIlIIlIIlllllllIlll) {
        if (llllllllllllIIIlIIlIIlllllllIlll > llllllllllllIIIlIIlIIllllllllIII && this.worldObj.isAreaLoaded(new BlockPos(llllllllllllIIIlIIlIIlllllllIlII, 0, llllllllllllIIIlIIlIIllllllllIIl), 16)) {
            for (int llllllllllllIIIlIIlIIlllllllIllI = llllllllllllIIIlIIlIIllllllllIII; llllllllllllIIIlIIlIIlllllllIllI < llllllllllllIIIlIIlIIlllllllIlll; ++llllllllllllIIIlIIlIIlllllllIllI) {
                this.worldObj.checkLightFor(EnumSkyBlock.SKY, new BlockPos(llllllllllllIIIlIIlIIlllllllIlII, llllllllllllIIIlIIlIIlllllllIllI, llllllllllllIIIlIIlIIllllllllIIl));
            }
            this.isModified = true;
        }
    }
    
    @Nullable
    public TileEntity getTileEntity(final BlockPos llllllllllllIIIlIIlIIllIllIllllI, final EnumCreateEntityType llllllllllllIIIlIIlIIllIllIlllIl) {
        TileEntity llllllllllllIIIlIIlIIllIllIlllII = this.chunkTileEntityMap.get(llllllllllllIIIlIIlIIllIllIllllI);
        if (llllllllllllIIIlIIlIIllIllIlllII == null) {
            if (llllllllllllIIIlIIlIIllIllIlllIl == EnumCreateEntityType.IMMEDIATE) {
                llllllllllllIIIlIIlIIllIllIlllII = this.createNewTileEntity(llllllllllllIIIlIIlIIllIllIllllI);
                this.worldObj.setTileEntity(llllllllllllIIIlIIlIIllIllIllllI, llllllllllllIIIlIIlIIllIllIlllII);
            }
            else if (llllllllllllIIIlIIlIIllIllIlllIl == EnumCreateEntityType.QUEUED) {
                this.tileEntityPosQueue.add(llllllllllllIIIlIIlIIllIllIllllI);
            }
        }
        else if (llllllllllllIIIlIIlIIllIllIlllII.isInvalid()) {
            this.chunkTileEntityMap.remove(llllllllllllIIIlIIlIIllIllIllllI);
            return null;
        }
        return llllllllllllIIIlIIlIIllIllIlllII;
    }
    
    public void removeTileEntity(final BlockPos llllllllllllIIIlIIlIIllIllIIIIIl) {
        if (this.isChunkLoaded) {
            final TileEntity llllllllllllIIIlIIlIIllIllIIIIll = this.chunkTileEntityMap.remove(llllllllllllIIIlIIlIIllIllIIIIIl);
            if (llllllllllllIIIlIIlIIllIllIIIIll != null) {
                llllllllllllIIIlIIlIIllIllIIIIll.invalidate();
            }
        }
    }
    
    public boolean isTerrainPopulated() {
        return this.isTerrainPopulated;
    }
    
    public void addTileEntity(final TileEntity llllllllllllIIIlIIlIIllIllIlIlII) {
        this.addTileEntity(llllllllllllIIIlIIlIIllIllIlIlII.getPos(), llllllllllllIIIlIIlIIllIllIlIlII);
        if (this.isChunkLoaded) {
            this.worldObj.addTileEntity(llllllllllllIIIlIIlIIllIllIlIlII);
        }
    }
    
    public int getLightSubtracted(final BlockPos llllllllllllIIIlIIlIIlllIIlIIlII, final int llllllllllllIIIlIIlIIlllIIlIIIll) {
        final int llllllllllllIIIlIIlIIlllIIlIlIll = llllllllllllIIIlIIlIIlllIIlIIlII.getX() & 0xF;
        final int llllllllllllIIIlIIlIIlllIIlIlIlI = llllllllllllIIIlIIlIIlllIIlIIlII.getY();
        final int llllllllllllIIIlIIlIIlllIIlIlIIl = llllllllllllIIIlIIlIIlllIIlIIlII.getZ() & 0xF;
        final ExtendedBlockStorage llllllllllllIIIlIIlIIlllIIlIlIII = this.storageArrays[llllllllllllIIIlIIlIIlllIIlIlIlI >> 4];
        if (llllllllllllIIIlIIlIIlllIIlIlIII == Chunk.NULL_BLOCK_STORAGE) {
            return (this.worldObj.provider.func_191066_m() && llllllllllllIIIlIIlIIlllIIlIIIll < EnumSkyBlock.SKY.defaultLightValue) ? (EnumSkyBlock.SKY.defaultLightValue - llllllllllllIIIlIIlIIlllIIlIIIll) : 0;
        }
        int llllllllllllIIIlIIlIIlllIIlIIlll = this.worldObj.provider.func_191066_m() ? llllllllllllIIIlIIlIIlllIIlIlIII.getExtSkylightValue(llllllllllllIIIlIIlIIlllIIlIlIll, llllllllllllIIIlIIlIIlllIIlIlIlI & 0xF, llllllllllllIIIlIIlIIlllIIlIlIIl) : 0;
        llllllllllllIIIlIIlIIlllIIlIIlll -= llllllllllllIIIlIIlIIlllIIlIIIll;
        final int llllllllllllIIIlIIlIIlllIIlIIllI = llllllllllllIIIlIIlIIlllIIlIlIII.getExtBlocklightValue(llllllllllllIIIlIIlIIlllIIlIlIll, llllllllllllIIIlIIlIIlllIIlIlIlI & 0xF, llllllllllllIIIlIIlIIlllIIlIlIIl);
        if (llllllllllllIIIlIIlIIlllIIlIIllI > llllllllllllIIIlIIlIIlllIIlIIlll) {
            llllllllllllIIIlIIlIIlllIIlIIlll = llllllllllllIIIlIIlIIlllIIlIIllI;
        }
        return llllllllllllIIIlIIlIIlllIIlIIlll;
    }
    
    public World getWorld() {
        return this.worldObj;
    }
    
    public void enqueueRelightChecks() {
        if (this.queuedLightChecks < 4096) {
            final BlockPos llllllllllllIIIlIIlIIlIllIlIIIlI = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
            for (int llllllllllllIIIlIIlIIlIllIlIIIIl = 0; llllllllllllIIIlIIlIIlIllIlIIIIl < 8; ++llllllllllllIIIlIIlIIlIllIlIIIIl) {
                if (this.queuedLightChecks >= 4096) {
                    return;
                }
                final int llllllllllllIIIlIIlIIlIllIlIIIII = this.queuedLightChecks % 16;
                final int llllllllllllIIIlIIlIIlIllIIlllll = this.queuedLightChecks / 16 % 16;
                final int llllllllllllIIIlIIlIIlIllIIllllI = this.queuedLightChecks / 256;
                ++this.queuedLightChecks;
                for (int llllllllllllIIIlIIlIIlIllIIlllIl = 0; llllllllllllIIIlIIlIIlIllIIlllIl < 16; ++llllllllllllIIIlIIlIIlIllIIlllIl) {
                    final BlockPos llllllllllllIIIlIIlIIlIllIIlllII = llllllllllllIIIlIIlIIlIllIlIIIlI.add(llllllllllllIIIlIIlIIlIllIIlllll, (llllllllllllIIIlIIlIIlIllIlIIIII << 4) + llllllllllllIIIlIIlIIlIllIIlllIl, llllllllllllIIIlIIlIIlIllIIllllI);
                    final boolean llllllllllllIIIlIIlIIlIllIIllIll = llllllllllllIIIlIIlIIlIllIIlllIl == 0 || llllllllllllIIIlIIlIIlIllIIlllIl == 15 || llllllllllllIIIlIIlIIlIllIIlllll == 0 || llllllllllllIIIlIIlIIlIllIIlllll == 15 || llllllllllllIIIlIIlIIlIllIIllllI == 0 || llllllllllllIIIlIIlIIlIllIIllllI == 15;
                    if ((this.storageArrays[llllllllllllIIIlIIlIIlIllIlIIIII] == Chunk.NULL_BLOCK_STORAGE && llllllllllllIIIlIIlIIlIllIIllIll) || (this.storageArrays[llllllllllllIIIlIIlIIlIllIlIIIII] != Chunk.NULL_BLOCK_STORAGE && this.storageArrays[llllllllllllIIIlIIlIIlIllIlIIIII].get(llllllllllllIIIlIIlIIlIllIIlllll, llllllllllllIIIlIIlIIlIllIIlllIl, llllllllllllIIIlIIlIIlIllIIllllI).getMaterial() == Material.AIR)) {
                        final long llllllllllllIIIlIIlIIlIllIIIllII;
                        final byte llllllllllllIIIlIIlIIlIllIIIllIl = (byte)((EnumFacing[])(Object)(llllllllllllIIIlIIlIIlIllIIIllII = (long)(Object)EnumFacing.values())).length;
                        for (String llllllllllllIIIlIIlIIlIllIIIlllI = (String)0; llllllllllllIIIlIIlIIlIllIIIlllI < llllllllllllIIIlIIlIIlIllIIIllIl; ++llllllllllllIIIlIIlIIlIllIIIlllI) {
                            final EnumFacing llllllllllllIIIlIIlIIlIllIIllIlI = llllllllllllIIIlIIlIIlIllIIIllII[llllllllllllIIIlIIlIIlIllIIIlllI];
                            final BlockPos llllllllllllIIIlIIlIIlIllIIllIIl = llllllllllllIIIlIIlIIlIllIIlllII.offset(llllllllllllIIIlIIlIIlIllIIllIlI);
                            if (this.worldObj.getBlockState(llllllllllllIIIlIIlIIlIllIIllIIl).getLightValue() > 0) {
                                this.worldObj.checkLight(llllllllllllIIIlIIlIIlIllIIllIIl);
                            }
                        }
                        this.worldObj.checkLight(llllllllllllIIIlIIlIIlIllIIlllII);
                    }
                }
            }
        }
    }
    
    private void recheckGaps(final boolean llllllllllllIIIlIIlIlIIIIIIllIIl) {
        this.worldObj.theProfiler.startSection("recheckGaps");
        if (this.worldObj.isAreaLoaded(new BlockPos(this.xPosition * 16 + 8, 0, this.zPosition * 16 + 8), 16)) {
            for (int llllllllllllIIIlIIlIlIIIIIlIIIlI = 0; llllllllllllIIIlIIlIlIIIIIlIIIlI < 16; ++llllllllllllIIIlIIlIlIIIIIlIIIlI) {
                for (int llllllllllllIIIlIIlIlIIIIIlIIIIl = 0; llllllllllllIIIlIIlIlIIIIIlIIIIl < 16; ++llllllllllllIIIlIIlIlIIIIIlIIIIl) {
                    if (this.updateSkylightColumns[llllllllllllIIIlIIlIlIIIIIlIIIlI + llllllllllllIIIlIIlIlIIIIIlIIIIl * 16]) {
                        this.updateSkylightColumns[llllllllllllIIIlIIlIlIIIIIlIIIlI + llllllllllllIIIlIIlIlIIIIIlIIIIl * 16] = false;
                        final int llllllllllllIIIlIIlIlIIIIIlIIIII = this.getHeightValue(llllllllllllIIIlIIlIlIIIIIlIIIlI, llllllllllllIIIlIIlIlIIIIIlIIIIl);
                        final int llllllllllllIIIlIIlIlIIIIIIlllll = this.xPosition * 16 + llllllllllllIIIlIIlIlIIIIIlIIIlI;
                        final int llllllllllllIIIlIIlIlIIIIIIllllI = this.zPosition * 16 + llllllllllllIIIlIIlIlIIIIIlIIIIl;
                        int llllllllllllIIIlIIlIlIIIIIIlllIl = Integer.MAX_VALUE;
                        for (final EnumFacing llllllllllllIIIlIIlIlIIIIIIlllII : EnumFacing.Plane.HORIZONTAL) {
                            llllllllllllIIIlIIlIlIIIIIIlllIl = Math.min(llllllllllllIIIlIIlIlIIIIIIlllIl, this.worldObj.getChunksLowestHorizon(llllllllllllIIIlIIlIlIIIIIIlllll + llllllllllllIIIlIIlIlIIIIIIlllII.getFrontOffsetX(), llllllllllllIIIlIIlIlIIIIIIllllI + llllllllllllIIIlIIlIlIIIIIIlllII.getFrontOffsetZ()));
                        }
                        this.checkSkylightNeighborHeight(llllllllllllIIIlIIlIlIIIIIIlllll, llllllllllllIIIlIIlIlIIIIIIllllI, llllllllllllIIIlIIlIlIIIIIIlllIl);
                        for (final EnumFacing llllllllllllIIIlIIlIlIIIIIIllIll : EnumFacing.Plane.HORIZONTAL) {
                            this.checkSkylightNeighborHeight(llllllllllllIIIlIIlIlIIIIIIlllll + llllllllllllIIIlIIlIlIIIIIIllIll.getFrontOffsetX(), llllllllllllIIIlIIlIlIIIIIIllllI + llllllllllllIIIlIIlIlIIIIIIllIll.getFrontOffsetZ(), llllllllllllIIIlIIlIlIIIIIlIIIII);
                        }
                        if (llllllllllllIIIlIIlIlIIIIIIllIIl) {
                            this.worldObj.theProfiler.endSection();
                            return;
                        }
                    }
                }
            }
            this.isGapLightingUpdated = false;
        }
        this.worldObj.theProfiler.endSection();
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public ExtendedBlockStorage[] getBlockStorageArray() {
        return this.storageArrays;
    }
    
    private void setSkylightUpdated() {
        for (int llllllllllllIIIlIIlIIlIlIlllIlll = 0; llllllllllllIIIlIIlIIlIlIlllIlll < this.updateSkylightColumns.length; ++llllllllllllIIIlIIlIIlIlIlllIlll) {
            this.updateSkylightColumns[llllllllllllIIIlIIlIIlIlIlllIlll] = true;
        }
        this.recheckGaps(false);
    }
    
    @Nullable
    private ExtendedBlockStorage getLastExtendedBlockStorage() {
        for (int llllllllllllIIIlIIlIlIIIIllIlllI = this.storageArrays.length - 1; llllllllllllIIIlIIlIlIIIIllIlllI >= 0; --llllllllllllIIIlIIlIlIIIIllIlllI) {
            if (this.storageArrays[llllllllllllIIIlIIlIlIIIIllIlllI] != Chunk.NULL_BLOCK_STORAGE) {
                return this.storageArrays[llllllllllllIIIlIIlIlIIIIllIlllI];
            }
        }
        return null;
    }
    
    public void setLightFor(final EnumSkyBlock llllllllllllIIIlIIlIIlllIIlllllI, final BlockPos llllllllllllIIIlIIlIIlllIIllllIl, final int llllllllllllIIIlIIlIIlllIIllllII) {
        final int llllllllllllIIIlIIlIIlllIlIIIIll = llllllllllllIIIlIIlIIlllIIllllIl.getX() & 0xF;
        final int llllllllllllIIIlIIlIIlllIlIIIIlI = llllllllllllIIIlIIlIIlllIIllllIl.getY();
        final int llllllllllllIIIlIIlIIlllIlIIIIIl = llllllllllllIIIlIIlIIlllIIllllIl.getZ() & 0xF;
        ExtendedBlockStorage llllllllllllIIIlIIlIIlllIlIIIIII = this.storageArrays[llllllllllllIIIlIIlIIlllIlIIIIlI >> 4];
        if (llllllllllllIIIlIIlIIlllIlIIIIII == Chunk.NULL_BLOCK_STORAGE) {
            llllllllllllIIIlIIlIIlllIlIIIIII = new ExtendedBlockStorage(llllllllllllIIIlIIlIIlllIlIIIIlI >> 4 << 4, this.worldObj.provider.func_191066_m());
            this.storageArrays[llllllllllllIIIlIIlIIlllIlIIIIlI >> 4] = llllllllllllIIIlIIlIIlllIlIIIIII;
            this.generateSkylightMap();
        }
        this.isModified = true;
        if (llllllllllllIIIlIIlIIlllIIlllllI == EnumSkyBlock.SKY) {
            if (this.worldObj.provider.func_191066_m()) {
                llllllllllllIIIlIIlIIlllIlIIIIII.setExtSkylightValue(llllllllllllIIIlIIlIIlllIlIIIIll, llllllllllllIIIlIIlIIlllIlIIIIlI & 0xF, llllllllllllIIIlIIlIIlllIlIIIIIl, llllllllllllIIIlIIlIIlllIIllllII);
            }
        }
        else if (llllllllllllIIIlIIlIIlllIIlllllI == EnumSkyBlock.BLOCK) {
            llllllllllllIIIlIIlIIlllIlIIIIII.setExtBlocklightValue(llllllllllllIIIlIIlIIlllIlIIIIll, llllllllllllIIIlIIlIIlllIlIIIIlI & 0xF, llllllllllllIIIlIIlIIlllIlIIIIIl, llllllllllllIIIlIIlIIlllIIllllII);
        }
    }
    
    public boolean isAtLocation(final int llllllllllllIIIlIIlIlIIIlIIIIlIl, final int llllllllllllIIIlIIlIlIIIlIIIIlII) {
        return llllllllllllIIIlIIlIlIIIlIIIIlIl == this.xPosition && llllllllllllIIIlIIlIlIIIlIIIIlII == this.zPosition;
    }
    
    public void setStorageArrays(final ExtendedBlockStorage[] llllllllllllIIIlIIlIIlIllllIlIll) {
        if (this.storageArrays.length != llllllllllllIIIlIIlIIlIllllIlIll.length) {
            Chunk.LOGGER.warn("Could not set level chunk sections, array length is {} instead of {}", (Object)llllllllllllIIIlIIlIIlIllllIlIll.length, (Object)this.storageArrays.length);
        }
        else {
            System.arraycopy(llllllllllllIIIlIIlIIlIllllIlIll, 0, this.storageArrays, 0, this.storageArrays.length);
        }
    }
    
    public void resetRelightChecks() {
        this.queuedLightChecks = 0;
    }
    
    public int getLightFor(final EnumSkyBlock llllllllllllIIIlIIlIIlllIlIlIlIl, final BlockPos llllllllllllIIIlIIlIIlllIlIllIll) {
        final int llllllllllllIIIlIIlIIlllIlIllIlI = llllllllllllIIIlIIlIIlllIlIllIll.getX() & 0xF;
        final int llllllllllllIIIlIIlIIlllIlIllIIl = llllllllllllIIIlIIlIIlllIlIllIll.getY();
        final int llllllllllllIIIlIIlIIlllIlIllIII = llllllllllllIIIlIIlIIlllIlIllIll.getZ() & 0xF;
        final ExtendedBlockStorage llllllllllllIIIlIIlIIlllIlIlIlll = this.storageArrays[llllllllllllIIIlIIlIIlllIlIllIIl >> 4];
        if (llllllllllllIIIlIIlIIlllIlIlIlll == Chunk.NULL_BLOCK_STORAGE) {
            return this.canSeeSky(llllllllllllIIIlIIlIIlllIlIllIll) ? llllllllllllIIIlIIlIIlllIlIlIlIl.defaultLightValue : 0;
        }
        if (llllllllllllIIIlIIlIIlllIlIlIlIl == EnumSkyBlock.SKY) {
            return this.worldObj.provider.func_191066_m() ? llllllllllllIIIlIIlIIlllIlIlIlll.getExtSkylightValue(llllllllllllIIIlIIlIIlllIlIllIlI, llllllllllllIIIlIIlIIlllIlIllIIl & 0xF, llllllllllllIIIlIIlIIlllIlIllIII) : 0;
        }
        return (llllllllllllIIIlIIlIIlllIlIlIlIl == EnumSkyBlock.BLOCK) ? llllllllllllIIIlIIlIIlllIlIlIlll.getExtBlocklightValue(llllllllllllIIIlIIlIIlllIlIllIlI, llllllllllllIIIlIIlIIlllIlIllIIl & 0xF, llllllllllllIIIlIIlIIlllIlIllIII) : llllllllllllIIIlIIlIIlllIlIlIlIl.defaultLightValue;
    }
    
    public boolean isChunkTicked() {
        return this.chunkTicked;
    }
    
    public enum EnumCreateEntityType
    {
        QUEUED("QUEUED", 1), 
        IMMEDIATE("IMMEDIATE", 0), 
        CHECK("CHECK", 2);
        
        private EnumCreateEntityType(final String lllllllllllIllIllllIIllllIIIllII, final int lllllllllllIllIllllIIllllIIIlIll) {
        }
    }
}
