// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import net.minecraft.entity.EntityList;
import java.io.DataInputStream;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.IDataFixer;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.world.MinecraftException;
import org.apache.logging.log4j.LogManager;
import java.io.DataOutputStream;
import java.io.DataOutput;
import net.minecraft.nbt.CompressedStreamTools;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.nbt.NBTBase;
import java.util.Collections;
import com.google.common.collect.Maps;
import java.io.IOException;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.datafix.DataFixer;
import java.io.File;
import net.minecraft.util.math.ChunkPos;
import java.util.Set;
import net.minecraft.world.storage.IThreadedFileIO;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO
{
    private final /* synthetic */ Set<ChunkPos> field_193415_c;
    private final /* synthetic */ File chunkSaveLocation;
    private final /* synthetic */ DataFixer field_193416_e;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean savingExtraData;
    private final /* synthetic */ Map<ChunkPos, NBTTagCompound> chunksToRemove;
    
    private Chunk readChunkFromNBT(final World llllllllllllllIlIlllIlllIIlllllI, final NBTTagCompound llllllllllllllIlIlllIlllIIlIIIIl) {
        final int llllllllllllllIlIlllIlllIIllllII = llllllllllllllIlIlllIlllIIlIIIIl.getInteger("xPos");
        final int llllllllllllllIlIlllIlllIIlllIll = llllllllllllllIlIlllIlllIIlIIIIl.getInteger("zPos");
        final Chunk llllllllllllllIlIlllIlllIIlllIlI = new Chunk(llllllllllllllIlIlllIlllIIlllllI, llllllllllllllIlIlllIlllIIllllII, llllllllllllllIlIlllIlllIIlllIll);
        llllllllllllllIlIlllIlllIIlllIlI.setHeightMap(llllllllllllllIlIlllIlllIIlIIIIl.getIntArray("HeightMap"));
        llllllllllllllIlIlllIlllIIlllIlI.setTerrainPopulated(llllllllllllllIlIlllIlllIIlIIIIl.getBoolean("TerrainPopulated"));
        llllllllllllllIlIlllIlllIIlllIlI.setLightPopulated(llllllllllllllIlIlllIlllIIlIIIIl.getBoolean("LightPopulated"));
        llllllllllllllIlIlllIlllIIlllIlI.setInhabitedTime(llllllllllllllIlIlllIlllIIlIIIIl.getLong("InhabitedTime"));
        final NBTTagList llllllllllllllIlIlllIlllIIlllIIl = llllllllllllllIlIlllIlllIIlIIIIl.getTagList("Sections", 10);
        final int llllllllllllllIlIlllIlllIIlllIII = 16;
        final ExtendedBlockStorage[] llllllllllllllIlIlllIlllIIllIlll = new ExtendedBlockStorage[16];
        final boolean llllllllllllllIlIlllIlllIIllIllI = llllllllllllllIlIlllIlllIIlllllI.provider.func_191066_m();
        for (int llllllllllllllIlIlllIlllIIllIlIl = 0; llllllllllllllIlIlllIlllIIllIlIl < llllllllllllllIlIlllIlllIIlllIIl.tagCount(); ++llllllllllllllIlIlllIlllIIllIlIl) {
            final NBTTagCompound llllllllllllllIlIlllIlllIIllIlII = llllllllllllllIlIlllIlllIIlllIIl.getCompoundTagAt(llllllllllllllIlIlllIlllIIllIlIl);
            final int llllllllllllllIlIlllIlllIIllIIll = llllllllllllllIlIlllIlllIIllIlII.getByte("Y");
            final ExtendedBlockStorage llllllllllllllIlIlllIlllIIllIIlI = new ExtendedBlockStorage(llllllllllllllIlIlllIlllIIllIIll << 4, llllllllllllllIlIlllIlllIIllIllI);
            final byte[] llllllllllllllIlIlllIlllIIllIIIl = llllllllllllllIlIlllIlllIIllIlII.getByteArray("Blocks");
            final NibbleArray llllllllllllllIlIlllIlllIIllIIII = new NibbleArray(llllllllllllllIlIlllIlllIIllIlII.getByteArray("Data"));
            final NibbleArray llllllllllllllIlIlllIlllIIlIllll = llllllllllllllIlIlllIlllIIllIlII.hasKey("Add", 7) ? new NibbleArray(llllllllllllllIlIlllIlllIIllIlII.getByteArray("Add")) : null;
            llllllllllllllIlIlllIlllIIllIIlI.getData().setDataFromNBT(llllllllllllllIlIlllIlllIIllIIIl, llllllllllllllIlIlllIlllIIllIIII, llllllllllllllIlIlllIlllIIlIllll);
            llllllllllllllIlIlllIlllIIllIIlI.setBlocklightArray(new NibbleArray(llllllllllllllIlIlllIlllIIllIlII.getByteArray("BlockLight")));
            if (llllllllllllllIlIlllIlllIIllIllI) {
                llllllllllllllIlIlllIlllIIllIIlI.setSkylightArray(new NibbleArray(llllllllllllllIlIlllIlllIIllIlII.getByteArray("SkyLight")));
            }
            llllllllllllllIlIlllIlllIIllIIlI.removeInvalidBlocks();
            llllllllllllllIlIlllIlllIIllIlll[llllllllllllllIlIlllIlllIIllIIll] = llllllllllllllIlIlllIlllIIllIIlI;
        }
        llllllllllllllIlIlllIlllIIlllIlI.setStorageArrays(llllllllllllllIlIlllIlllIIllIlll);
        if (llllllllllllllIlIlllIlllIIlIIIIl.hasKey("Biomes", 7)) {
            llllllllllllllIlIlllIlllIIlllIlI.setBiomeArray(llllllllllllllIlIlllIlllIIlIIIIl.getByteArray("Biomes"));
        }
        final NBTTagList llllllllllllllIlIlllIlllIIlIlllI = llllllllllllllIlIlllIlllIIlIIIIl.getTagList("Entities", 10);
        for (int llllllllllllllIlIlllIlllIIlIllIl = 0; llllllllllllllIlIlllIlllIIlIllIl < llllllllllllllIlIlllIlllIIlIlllI.tagCount(); ++llllllllllllllIlIlllIlllIIlIllIl) {
            final NBTTagCompound llllllllllllllIlIlllIlllIIlIllII = llllllllllllllIlIlllIlllIIlIlllI.getCompoundTagAt(llllllllllllllIlIlllIlllIIlIllIl);
            readChunkEntity(llllllllllllllIlIlllIlllIIlIllII, llllllllllllllIlIlllIlllIIlllllI, llllllllllllllIlIlllIlllIIlllIlI);
            llllllllllllllIlIlllIlllIIlllIlI.setHasEntities(true);
        }
        final NBTTagList llllllllllllllIlIlllIlllIIlIlIll = llllllllllllllIlIlllIlllIIlIIIIl.getTagList("TileEntities", 10);
        for (int llllllllllllllIlIlllIlllIIlIlIlI = 0; llllllllllllllIlIlllIlllIIlIlIlI < llllllllllllllIlIlllIlllIIlIlIll.tagCount(); ++llllllllllllllIlIlllIlllIIlIlIlI) {
            final NBTTagCompound llllllllllllllIlIlllIlllIIlIlIIl = llllllllllllllIlIlllIlllIIlIlIll.getCompoundTagAt(llllllllllllllIlIlllIlllIIlIlIlI);
            final TileEntity llllllllllllllIlIlllIlllIIlIlIII = TileEntity.create(llllllllllllllIlIlllIlllIIlllllI, llllllllllllllIlIlllIlllIIlIlIIl);
            if (llllllllllllllIlIlllIlllIIlIlIII != null) {
                llllllllllllllIlIlllIlllIIlllIlI.addTileEntity(llllllllllllllIlIlllIlllIIlIlIII);
            }
        }
        if (llllllllllllllIlIlllIlllIIlIIIIl.hasKey("TileTicks", 9)) {
            final NBTTagList llllllllllllllIlIlllIlllIIlIIlll = llllllllllllllIlIlllIlllIIlIIIIl.getTagList("TileTicks", 10);
            for (int llllllllllllllIlIlllIlllIIlIIllI = 0; llllllllllllllIlIlllIlllIIlIIllI < llllllllllllllIlIlllIlllIIlIIlll.tagCount(); ++llllllllllllllIlIlllIlllIIlIIllI) {
                final NBTTagCompound llllllllllllllIlIlllIlllIIlIIlIl = llllllllllllllIlIlllIlllIIlIIlll.getCompoundTagAt(llllllllllllllIlIlllIlllIIlIIllI);
                Block llllllllllllllIlIlllIlllIIlIIIll = null;
                if (llllllllllllllIlIlllIlllIIlIIlIl.hasKey("i", 8)) {
                    final Block llllllllllllllIlIlllIlllIIlIIlII = Block.getBlockFromName(llllllllllllllIlIlllIlllIIlIIlIl.getString("i"));
                }
                else {
                    llllllllllllllIlIlllIlllIIlIIIll = Block.getBlockById(llllllllllllllIlIlllIlllIIlIIlIl.getInteger("i"));
                }
                llllllllllllllIlIlllIlllIIlllllI.scheduleBlockUpdate(new BlockPos(llllllllllllllIlIlllIlllIIlIIlIl.getInteger("x"), llllllllllllllIlIlllIlllIIlIIlIl.getInteger("y"), llllllllllllllIlIlllIlllIIlIIlIl.getInteger("z")), llllllllllllllIlIlllIlllIIlIIIll, llllllllllllllIlIlllIlllIIlIIlIl.getInteger("t"), llllllllllllllIlIlllIlllIIlIIlIl.getInteger("p"));
            }
        }
        return llllllllllllllIlIlllIlllIIlllIlI;
    }
    
    public static void spawnEntity(final Entity llllllllllllllIlIlllIllIllIIllll, final World llllllllllllllIlIlllIllIllIIlllI) {
        if (llllllllllllllIlIlllIllIllIIlllI.spawnEntityInWorld(llllllllllllllIlIlllIllIllIIllll) && llllllllllllllIlIlllIllIllIIllll.isBeingRidden()) {
            for (final Entity llllllllllllllIlIlllIllIllIlIIII : llllllllllllllIlIlllIllIllIIllll.getPassengers()) {
                spawnEntity(llllllllllllllIlIlllIllIllIlIIII, llllllllllllllIlIlllIllIllIIlllI);
            }
        }
    }
    
    @Nullable
    public static Entity readChunkEntity(final NBTTagCompound llllllllllllllIlIlllIlllIIIIIlII, final World llllllllllllllIlIlllIlllIIIIlIlI, final Chunk llllllllllllllIlIlllIlllIIIIIIlI) {
        final Entity llllllllllllllIlIlllIlllIIIIlIII = createEntityFromNBT(llllllllllllllIlIlllIlllIIIIIlII, llllllllllllllIlIlllIlllIIIIlIlI);
        if (llllllllllllllIlIlllIlllIIIIlIII == null) {
            return null;
        }
        llllllllllllllIlIlllIlllIIIIIIlI.addEntity(llllllllllllllIlIlllIlllIIIIlIII);
        if (llllllllllllllIlIlllIlllIIIIIlII.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIlllIlllIIIIIlll = llllllllllllllIlIlllIlllIIIIIlII.getTagList("Passengers", 10);
            for (int llllllllllllllIlIlllIlllIIIIIllI = 0; llllllllllllllIlIlllIlllIIIIIllI < llllllllllllllIlIlllIlllIIIIIlll.tagCount(); ++llllllllllllllIlIlllIlllIIIIIllI) {
                final Entity llllllllllllllIlIlllIlllIIIIIlIl = readChunkEntity(llllllllllllllIlIlllIlllIIIIIlll.getCompoundTagAt(llllllllllllllIlIlllIlllIIIIIllI), llllllllllllllIlIlllIlllIIIIlIlI, llllllllllllllIlIlllIlllIIIIIIlI);
                if (llllllllllllllIlIlllIlllIIIIIlIl != null) {
                    llllllllllllllIlIlllIlllIIIIIlIl.startRiding(llllllllllllllIlIlllIlllIIIIlIII, true);
                }
            }
        }
        return llllllllllllllIlIlllIlllIIIIlIII;
    }
    
    @Override
    public void saveExtraChunkData(final World llllllllllllllIlIlllIllllIIlIIll, final Chunk llllllllllllllIlIlllIllllIIlIIlI) throws IOException {
    }
    
    @Nullable
    public static Entity readWorldEntityPos(final NBTTagCompound llllllllllllllIlIlllIllIlllIlIIl, final World llllllllllllllIlIlllIllIllllIIlI, final double llllllllllllllIlIlllIllIlllIIlll, final double llllllllllllllIlIlllIllIllllIIII, final double llllllllllllllIlIlllIllIlllIIlIl, final boolean llllllllllllllIlIlllIllIlllIIlII) {
        final Entity llllllllllllllIlIlllIllIlllIllIl = createEntityFromNBT(llllllllllllllIlIlllIllIlllIlIIl, llllllllllllllIlIlllIllIllllIIlI);
        if (llllllllllllllIlIlllIllIlllIllIl == null) {
            return null;
        }
        llllllllllllllIlIlllIllIlllIllIl.setLocationAndAngles(llllllllllllllIlIlllIllIlllIIlll, llllllllllllllIlIlllIllIllllIIII, llllllllllllllIlIlllIllIlllIIlIl, llllllllllllllIlIlllIllIlllIllIl.rotationYaw, llllllllllllllIlIlllIllIlllIllIl.rotationPitch);
        if (llllllllllllllIlIlllIllIlllIIlII && !llllllllllllllIlIlllIllIllllIIlI.spawnEntityInWorld(llllllllllllllIlIlllIllIlllIllIl)) {
            return null;
        }
        if (llllllllllllllIlIlllIllIlllIlIIl.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIlllIllIlllIllII = llllllllllllllIlIlllIllIlllIlIIl.getTagList("Passengers", 10);
            for (int llllllllllllllIlIlllIllIlllIlIll = 0; llllllllllllllIlIlllIllIlllIlIll < llllllllllllllIlIlllIllIlllIllII.tagCount(); ++llllllllllllllIlIlllIllIlllIlIll) {
                final Entity llllllllllllllIlIlllIllIlllIlIlI = readWorldEntityPos(llllllllllllllIlIlllIllIlllIllII.getCompoundTagAt(llllllllllllllIlIlllIllIlllIlIll), llllllllllllllIlIlllIllIllllIIlI, llllllllllllllIlIlllIllIlllIIlll, llllllllllllllIlIlllIllIllllIIII, llllllllllllllIlIlllIllIlllIIlIl, llllllllllllllIlIlllIllIlllIIlII);
                if (llllllllllllllIlIlllIllIlllIlIlI != null) {
                    llllllllllllllIlIlllIllIlllIlIlI.startRiding(llllllllllllllIlIlllIllIlllIllIl, true);
                }
            }
        }
        return llllllllllllllIlIlllIllIlllIllIl;
    }
    
    public AnvilChunkLoader(final File llllllllllllllIlIllllIIIIIIIIllI, final DataFixer llllllllllllllIlIllllIIIIIIIIlIl) {
        this.chunksToRemove = (Map<ChunkPos, NBTTagCompound>)Maps.newConcurrentMap();
        this.field_193415_c = Collections.newSetFromMap((Map<ChunkPos, Boolean>)Maps.newConcurrentMap());
        this.chunkSaveLocation = llllllllllllllIlIllllIIIIIIIIllI;
        this.field_193416_e = llllllllllllllIlIllllIIIIIIIIlIl;
    }
    
    private void writeChunkToNBT(final Chunk llllllllllllllIlIlllIlllIlIlllll, final World llllllllllllllIlIlllIlllIlllIllI, final NBTTagCompound llllllllllllllIlIlllIlllIlIlllIl) {
        llllllllllllllIlIlllIlllIlIlllIl.setInteger("xPos", llllllllllllllIlIlllIlllIlIlllll.xPosition);
        llllllllllllllIlIlllIlllIlIlllIl.setInteger("zPos", llllllllllllllIlIlllIlllIlIlllll.zPosition);
        llllllllllllllIlIlllIlllIlIlllIl.setLong("LastUpdate", llllllllllllllIlIlllIlllIlllIllI.getTotalWorldTime());
        llllllllllllllIlIlllIlllIlIlllIl.setIntArray("HeightMap", llllllllllllllIlIlllIlllIlIlllll.getHeightMap());
        llllllllllllllIlIlllIlllIlIlllIl.setBoolean("TerrainPopulated", llllllllllllllIlIlllIlllIlIlllll.isTerrainPopulated());
        llllllllllllllIlIlllIlllIlIlllIl.setBoolean("LightPopulated", llllllllllllllIlIlllIlllIlIlllll.isLightPopulated());
        llllllllllllllIlIlllIlllIlIlllIl.setLong("InhabitedTime", llllllllllllllIlIlllIlllIlIlllll.getInhabitedTime());
        final ExtendedBlockStorage[] llllllllllllllIlIlllIlllIlllIlII = llllllllllllllIlIlllIlllIlIlllll.getBlockStorageArray();
        final NBTTagList llllllllllllllIlIlllIlllIlllIIll = new NBTTagList();
        final boolean llllllllllllllIlIlllIlllIlllIIlI = llllllllllllllIlIlllIlllIlllIllI.provider.func_191066_m();
        boolean llllllllllllllIlIlllIlllIlIlIllI;
        final long llllllllllllllIlIlllIlllIlIlIlll = ((ExtendedBlockStorage[])(Object)(llllllllllllllIlIlllIlllIlIlIllI = (boolean)(Object)llllllllllllllIlIlllIlllIlllIlII)).length;
        for (final ExtendedBlockStorage llllllllllllllIlIlllIlllIlllIIIl : llllllllllllllIlIlllIlllIlIlIllI) {
            if (llllllllllllllIlIlllIlllIlllIIIl != Chunk.NULL_BLOCK_STORAGE) {
                final NBTTagCompound llllllllllllllIlIlllIlllIlllIIII = new NBTTagCompound();
                llllllllllllllIlIlllIlllIlllIIII.setByte("Y", (byte)(llllllllllllllIlIlllIlllIlllIIIl.getYLocation() >> 4 & 0xFF));
                final byte[] llllllllllllllIlIlllIlllIllIllll = new byte[4096];
                final NibbleArray llllllllllllllIlIlllIlllIllIlllI = new NibbleArray();
                final NibbleArray llllllllllllllIlIlllIlllIllIllIl = llllllllllllllIlIlllIlllIlllIIIl.getData().getDataForNBT(llllllllllllllIlIlllIlllIllIllll, llllllllllllllIlIlllIlllIllIlllI);
                llllllllllllllIlIlllIlllIlllIIII.setByteArray("Blocks", llllllllllllllIlIlllIlllIllIllll);
                llllllllllllllIlIlllIlllIlllIIII.setByteArray("Data", llllllllllllllIlIlllIlllIllIlllI.getData());
                if (llllllllllllllIlIlllIlllIllIllIl != null) {
                    llllllllllllllIlIlllIlllIlllIIII.setByteArray("Add", llllllllllllllIlIlllIlllIllIllIl.getData());
                }
                llllllllllllllIlIlllIlllIlllIIII.setByteArray("BlockLight", llllllllllllllIlIlllIlllIlllIIIl.getBlocklightArray().getData());
                if (llllllllllllllIlIlllIlllIlllIIlI) {
                    llllllllllllllIlIlllIlllIlllIIII.setByteArray("SkyLight", llllllllllllllIlIlllIlllIlllIIIl.getSkylightArray().getData());
                }
                else {
                    llllllllllllllIlIlllIlllIlllIIII.setByteArray("SkyLight", new byte[llllllllllllllIlIlllIlllIlllIIIl.getBlocklightArray().getData().length]);
                }
                llllllllllllllIlIlllIlllIlllIIll.appendTag(llllllllllllllIlIlllIlllIlllIIII);
            }
        }
        llllllllllllllIlIlllIlllIlIlllIl.setTag("Sections", llllllllllllllIlIlllIlllIlllIIll);
        llllllllllllllIlIlllIlllIlIlllIl.setByteArray("Biomes", llllllllllllllIlIlllIlllIlIlllll.getBiomeArray());
        llllllllllllllIlIlllIlllIlIlllll.setHasEntities(false);
        final NBTTagList llllllllllllllIlIlllIlllIllIllII = new NBTTagList();
        for (int llllllllllllllIlIlllIlllIllIlIll = 0; llllllllllllllIlIlllIlllIllIlIll < llllllllllllllIlIlllIlllIlIlllll.getEntityLists().length; ++llllllllllllllIlIlllIlllIllIlIll) {
            llllllllllllllIlIlllIlllIlIlIllI = (boolean)llllllllllllllIlIlllIlllIlIlllll.getEntityLists()[llllllllllllllIlIlllIlllIllIlIll].iterator();
            while (((Iterator)llllllllllllllIlIlllIlllIlIlIllI).hasNext()) {
                final Entity llllllllllllllIlIlllIlllIllIlIlI = ((Iterator<Entity>)llllllllllllllIlIlllIlllIlIlIllI).next();
                final NBTTagCompound llllllllllllllIlIlllIlllIllIlIIl = new NBTTagCompound();
                if (llllllllllllllIlIlllIlllIllIlIlI.writeToNBTOptional(llllllllllllllIlIlllIlllIllIlIIl)) {
                    llllllllllllllIlIlllIlllIlIlllll.setHasEntities(true);
                    llllllllllllllIlIlllIlllIllIllII.appendTag(llllllllllllllIlIlllIlllIllIlIIl);
                }
            }
        }
        llllllllllllllIlIlllIlllIlIlllIl.setTag("Entities", llllllllllllllIlIlllIlllIllIllII);
        final NBTTagList llllllllllllllIlIlllIlllIllIlIII = new NBTTagList();
        llllllllllllllIlIlllIlllIlIlIllI = (boolean)llllllllllllllIlIlllIlllIlIlllll.getTileEntityMap().values().iterator();
        while (((Iterator)llllllllllllllIlIlllIlllIlIlIllI).hasNext()) {
            final TileEntity llllllllllllllIlIlllIlllIllIIlll = ((Iterator<TileEntity>)llllllllllllllIlIlllIlllIlIlIllI).next();
            final NBTTagCompound llllllllllllllIlIlllIlllIllIIllI = llllllllllllllIlIlllIlllIllIIlll.writeToNBT(new NBTTagCompound());
            llllllllllllllIlIlllIlllIllIlIII.appendTag(llllllllllllllIlIlllIlllIllIIllI);
        }
        llllllllllllllIlIlllIlllIlIlllIl.setTag("TileEntities", llllllllllllllIlIlllIlllIllIlIII);
        final List<NextTickListEntry> llllllllllllllIlIlllIlllIllIIlIl = llllllllllllllIlIlllIlllIlllIllI.getPendingBlockUpdates(llllllllllllllIlIlllIlllIlIlllll, false);
        if (llllllllllllllIlIlllIlllIllIIlIl != null) {
            final long llllllllllllllIlIlllIlllIllIIlII = llllllllllllllIlIlllIlllIlllIllI.getTotalWorldTime();
            final NBTTagList llllllllllllllIlIlllIlllIllIIIll = new NBTTagList();
            for (final NextTickListEntry llllllllllllllIlIlllIlllIllIIIlI : llllllllllllllIlIlllIlllIllIIlIl) {
                final NBTTagCompound llllllllllllllIlIlllIlllIllIIIIl = new NBTTagCompound();
                final ResourceLocation llllllllllllllIlIlllIlllIllIIIII = Block.REGISTRY.getNameForObject(llllllllllllllIlIlllIlllIllIIIlI.getBlock());
                llllllllllllllIlIlllIlllIllIIIIl.setString("i", (llllllllllllllIlIlllIlllIllIIIII == null) ? "" : llllllllllllllIlIlllIlllIllIIIII.toString());
                llllllllllllllIlIlllIlllIllIIIIl.setInteger("x", llllllllllllllIlIlllIlllIllIIIlI.position.getX());
                llllllllllllllIlIlllIlllIllIIIIl.setInteger("y", llllllllllllllIlIlllIlllIllIIIlI.position.getY());
                llllllllllllllIlIlllIlllIllIIIIl.setInteger("z", llllllllllllllIlIlllIlllIllIIIlI.position.getZ());
                llllllllllllllIlIlllIlllIllIIIIl.setInteger("t", (int)(llllllllllllllIlIlllIlllIllIIIlI.scheduledTime - llllllllllllllIlIlllIlllIllIIlII));
                llllllllllllllIlIlllIlllIllIIIIl.setInteger("p", llllllllllllllIlIlllIlllIllIIIlI.priority);
                llllllllllllllIlIlllIlllIllIIIll.appendTag(llllllllllllllIlIlllIlllIllIIIIl);
            }
            llllllllllllllIlIlllIlllIlIlllIl.setTag("TileTicks", llllllllllllllIlIlllIlllIllIIIll);
        }
    }
    
    private void writeChunkData(final ChunkPos llllllllllllllIlIlllIllllIIlIlll, final NBTTagCompound llllllllllllllIlIlllIllllIIllIlI) throws IOException {
        final DataOutputStream llllllllllllllIlIlllIllllIIllIIl = RegionFileCache.getChunkOutputStream(this.chunkSaveLocation, llllllllllllllIlIlllIllllIIlIlll.chunkXPos, llllllllllllllIlIlllIllllIIlIlll.chunkZPos);
        CompressedStreamTools.write(llllllllllllllIlIlllIllllIIllIlI, llllllllllllllIlIlllIllllIIllIIl);
        llllllllllllllIlIlllIllllIIllIIl.close();
    }
    
    @Nullable
    protected Chunk checkedReadChunkFromNBT(final World llllllllllllllIlIlllIlllllIlIIIl, final int llllllllllllllIlIlllIlllllIlIIII, final int llllllllllllllIlIlllIlllllIIllll, final NBTTagCompound llllllllllllllIlIlllIlllllIIlllI) {
        if (!llllllllllllllIlIlllIlllllIIlllI.hasKey("Level", 10)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is missing level data, skipping", (Object)llllllllllllllIlIlllIlllllIlIIII, (Object)llllllllllllllIlIlllIlllllIIllll);
            return null;
        }
        final NBTTagCompound llllllllllllllIlIlllIlllllIlIlII = llllllllllllllIlIlllIlllllIIlllI.getCompoundTag("Level");
        if (!llllllllllllllIlIlllIlllllIlIlII.hasKey("Sections", 9)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is missing block data, skipping", (Object)llllllllllllllIlIlllIlllllIlIIII, (Object)llllllllllllllIlIlllIlllllIIllll);
            return null;
        }
        Chunk llllllllllllllIlIlllIlllllIlIIll = this.readChunkFromNBT(llllllllllllllIlIlllIlllllIlIIIl, llllllllllllllIlIlllIlllllIlIlII);
        if (!llllllllllllllIlIlllIlllllIlIIll.isAtLocation(llllllllllllllIlIlllIlllllIlIIII, llllllllllllllIlIlllIlllllIIllll)) {
            AnvilChunkLoader.LOGGER.error("Chunk file at {},{} is in the wrong location; relocating. (Expected {}, {}, got {}, {})", (Object)llllllllllllllIlIlllIlllllIlIIII, (Object)llllllllllllllIlIlllIlllllIIllll, (Object)llllllllllllllIlIlllIlllllIlIIII, (Object)llllllllllllllIlIlllIlllllIIllll, (Object)llllllllllllllIlIlllIlllllIlIIll.xPosition, (Object)llllllllllllllIlIlllIlllllIlIIll.zPosition);
            llllllllllllllIlIlllIlllllIlIlII.setInteger("xPos", llllllllllllllIlIlllIlllllIlIIII);
            llllllllllllllIlIlllIlllllIlIlII.setInteger("zPos", llllllllllllllIlIlllIlllllIIllll);
            llllllllllllllIlIlllIlllllIlIIll = this.readChunkFromNBT(llllllllllllllIlIlllIlllllIlIIIl, llllllllllllllIlIlllIlllllIlIlII);
        }
        return llllllllllllllIlIlllIlllllIlIIll;
    }
    
    @Nullable
    public static Entity readWorldEntity(final NBTTagCompound llllllllllllllIlIlllIllIllIIIlII, final World llllllllllllllIlIlllIllIlIllllII, final boolean llllllllllllllIlIlllIllIlIlllIll) {
        final Entity llllllllllllllIlIlllIllIllIIIIIl = createEntityFromNBT(llllllllllllllIlIlllIllIllIIIlII, llllllllllllllIlIlllIllIlIllllII);
        if (llllllllllllllIlIlllIllIllIIIIIl == null) {
            return null;
        }
        if (llllllllllllllIlIlllIllIlIlllIll && !llllllllllllllIlIlllIllIlIllllII.spawnEntityInWorld(llllllllllllllIlIlllIllIllIIIIIl)) {
            return null;
        }
        if (llllllllllllllIlIlllIllIllIIIlII.hasKey("Passengers", 9)) {
            final NBTTagList llllllllllllllIlIlllIllIllIIIIII = llllllllllllllIlIlllIllIllIIIlII.getTagList("Passengers", 10);
            for (int llllllllllllllIlIlllIllIlIllllll = 0; llllllllllllllIlIlllIllIlIllllll < llllllllllllllIlIlllIllIllIIIIII.tagCount(); ++llllllllllllllIlIlllIllIlIllllll) {
                final Entity llllllllllllllIlIlllIllIlIlllllI = readWorldEntity(llllllllllllllIlIlllIllIllIIIIII.getCompoundTagAt(llllllllllllllIlIlllIllIlIllllll), llllllllllllllIlIlllIllIlIllllII, llllllllllllllIlIlllIllIlIlllIll);
                if (llllllllllllllIlIlllIllIlIlllllI != null) {
                    llllllllllllllIlIlllIllIlIlllllI.startRiding(llllllllllllllIlIlllIllIllIIIIIl, true);
                }
            }
        }
        return llllllllllllllIlIlllIllIllIIIIIl;
    }
    
    @Override
    public boolean writeNextIO() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //     4: invokeinterface java/util/Map.isEmpty:()Z
        //     9: ifeq            39
        //    12: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    13: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.savingExtraData:Z
        //    16: ifeq            37
        //    19: getstatic       net/minecraft/world/chunk/storage/AnvilChunkLoader.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    22: ldc_w           "ThreadedAnvilChunkStorage ({}): All chunks are saved"
        //    25: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    26: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunkSaveLocation:Ljava/io/File;
        //    29: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //    32: invokeinterface org/apache/logging/log4j/Logger.info:(Ljava/lang/String;Ljava/lang/Object;)V
        //    37: iconst_0       
        //    38: ireturn        
        //    39: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    40: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //    43: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    48: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    53: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    58: checkcast       Lnet/minecraft/util/math/ChunkPos;
        //    61: astore_1        /* llllllllllllllIlIlllIllllIlIIlIl */
        //    62: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    63: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //    66: aload_1         /* llllllllllllllIlIlllIllllIlIlIll */
        //    67: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //    72: pop            
        //    73: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    74: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.chunksToRemove:Ljava/util/Map;
        //    77: aload_1         /* llllllllllllllIlIlllIllllIlIlIll */
        //    78: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    83: checkcast       Lnet/minecraft/nbt/NBTTagCompound;
        //    86: astore_3        /* llllllllllllllIlIlllIllllIlIlIII */
        //    87: aload_3         /* llllllllllllllIlIlllIllllIlIlIII */
        //    88: ifnull          115
        //    91: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //    92: aload_1         /* llllllllllllllIlIlllIllllIlIlIll */
        //    93: aload_3         /* llllllllllllllIlIlllIllllIlIlIII */
        //    94: invokespecial   net/minecraft/world/chunk/storage/AnvilChunkLoader.writeChunkData:(Lnet/minecraft/util/math/ChunkPos;Lnet/minecraft/nbt/NBTTagCompound;)V
        //    97: goto            115
        //   100: astore          llllllllllllllIlIlllIllllIlIIlll
        //   102: getstatic       net/minecraft/world/chunk/storage/AnvilChunkLoader.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   105: ldc_w           "Failed to save chunk"
        //   108: aload           llllllllllllllIlIlllIllllIlIIlll
        //   110: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   115: iconst_1       
        //   116: istore_2        /* llllllllllllllIlIlllIllllIlIIlII */
        //   117: goto            136
        //   120: astore          llllllllllllllIlIlllIllllIlIIIIl
        //   122: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //   123: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //   126: aload_1         /* llllllllllllllIlIlllIllllIlIlIll */
        //   127: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //   132: pop            
        //   133: aload           llllllllllllllIlIlllIllllIlIIIIl
        //   135: athrow         
        //   136: aload_0         /* llllllllllllllIlIlllIllllIlIllII */
        //   137: getfield        net/minecraft/world/chunk/storage/AnvilChunkLoader.field_193415_c:Ljava/util/Set;
        //   140: aload_1         /* llllllllllllllIlIlllIllllIlIlIll */
        //   141: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //   146: pop            
        //   147: iload_2         /* llllllllllllllIlIlllIllllIlIlIIl */
        //   148: ireturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  91     97     100    115    Ljava/lang/Exception;
        //  62     120    120    136    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void saveChunk(final World llllllllllllllIlIlllIlllllIIIlIl, final Chunk llllllllllllllIlIlllIlllllIIIlII) throws MinecraftException, IOException {
        llllllllllllllIlIlllIlllllIIIlIl.checkSessionLock();
        try {
            final NBTTagCompound llllllllllllllIlIlllIlllllIIIIll = new NBTTagCompound();
            final NBTTagCompound llllllllllllllIlIlllIlllllIIIIlI = new NBTTagCompound();
            llllllllllllllIlIlllIlllllIIIIll.setTag("Level", llllllllllllllIlIlllIlllllIIIIlI);
            llllllllllllllIlIlllIlllllIIIIll.setInteger("DataVersion", 1343);
            this.writeChunkToNBT(llllllllllllllIlIlllIlllllIIIlII, llllllllllllllIlIlllIlllllIIIlIl, llllllllllllllIlIlllIlllllIIIIlI);
            this.addChunkToPending(llllllllllllllIlIlllIlllllIIIlII.getChunkCoordIntPair(), llllllllllllllIlIlllIlllllIIIIll);
        }
        catch (Exception llllllllllllllIlIlllIlllllIIIIIl) {
            AnvilChunkLoader.LOGGER.error("Failed to save chunk", (Throwable)llllllllllllllIlIlllIlllllIIIIIl);
        }
    }
    
    @Override
    public boolean func_191063_a(final int llllllllllllllIlIlllIllllllIIlII, final int llllllllllllllIlIlllIllllllIIIll) {
        final ChunkPos llllllllllllllIlIlllIllllllIIlll = new ChunkPos(llllllllllllllIlIlllIllllllIIlII, llllllllllllllIlIlllIllllllIIIll);
        final NBTTagCompound llllllllllllllIlIlllIllllllIIllI = this.chunksToRemove.get(llllllllllllllIlIlllIllllllIIlll);
        return llllllllllllllIlIlllIllllllIIllI != null || RegionFileCache.func_191064_f(this.chunkSaveLocation, llllllllllllllIlIlllIllllllIIlII, llllllllllllllIlIlllIllllllIIIll);
    }
    
    public static void registerFixes(final DataFixer llllllllllllllIlIlllIllllIIIlIlI) {
        llllllllllllllIlIlllIllllIIIlIlI.registerWalker(FixTypes.CHUNK, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llllllllllllIlllIIIllIIIIIllIlll, final NBTTagCompound llllllllllllIlllIIIllIIIIIllIllI, final int llllllllllllIlllIIIllIIIIIllIlIl) {
                if (llllllllllllIlllIIIllIIIIIllIllI.hasKey("Level", 10)) {
                    final NBTTagCompound llllllllllllIlllIIIllIIIIIllIlII = llllllllllllIlllIIIllIIIIIllIllI.getCompoundTag("Level");
                    if (llllllllllllIlllIIIllIIIIIllIlII.hasKey("Entities", 9)) {
                        final NBTTagList llllllllllllIlllIIIllIIIIIllIIll = llllllllllllIlllIIIllIIIIIllIlII.getTagList("Entities", 10);
                        for (int llllllllllllIlllIIIllIIIIIllIIlI = 0; llllllllllllIlllIIIllIIIIIllIIlI < llllllllllllIlllIIIllIIIIIllIIll.tagCount(); ++llllllllllllIlllIIIllIIIIIllIIlI) {
                            llllllllllllIlllIIIllIIIIIllIIll.set(llllllllllllIlllIIIllIIIIIllIIlI, llllllllllllIlllIIIllIIIIIllIlll.process(FixTypes.ENTITY, (NBTTagCompound)llllllllllllIlllIIIllIIIIIllIIll.get(llllllllllllIlllIIIllIIIIIllIIlI), llllllllllllIlllIIIllIIIIIllIlIl));
                        }
                    }
                    if (llllllllllllIlllIIIllIIIIIllIlII.hasKey("TileEntities", 9)) {
                        final NBTTagList llllllllllllIlllIIIllIIIIIllIIIl = llllllllllllIlllIIIllIIIIIllIlII.getTagList("TileEntities", 10);
                        for (int llllllllllllIlllIIIllIIIIIllIIII = 0; llllllllllllIlllIIIllIIIIIllIIII < llllllllllllIlllIIIllIIIIIllIIIl.tagCount(); ++llllllllllllIlllIIIllIIIIIllIIII) {
                            llllllllllllIlllIIIllIIIIIllIIIl.set(llllllllllllIlllIIIllIIIIIllIIII, llllllllllllIlllIIIllIIIIIllIlll.process(FixTypes.BLOCK_ENTITY, (NBTTagCompound)llllllllllllIlllIIIllIIIIIllIIIl.get(llllllllllllIlllIIIllIIIIIllIIII), llllllllllllIlllIIIllIIIIIllIlIl));
                        }
                    }
                }
                return llllllllllllIlllIIIllIIIIIllIllI;
            }
        });
    }
    
    protected void addChunkToPending(final ChunkPos llllllllllllllIlIlllIllllIllIlll, final NBTTagCompound llllllllllllllIlIlllIllllIllIIll) {
        if (!this.field_193415_c.contains(llllllllllllllIlIlllIllllIllIlll)) {
            this.chunksToRemove.put(llllllllllllllIlIlllIllllIllIlll, llllllllllllllIlIlllIllllIllIIll);
        }
        ThreadedFileIOBase.getThreadedIOInstance().queueIO(this);
    }
    
    @Nullable
    @Override
    public Chunk loadChunk(final World llllllllllllllIlIlllIlllllllIlIl, final int llllllllllllllIlIlllIllllllllIll, final int llllllllllllllIlIlllIllllllllIlI) throws IOException {
        final ChunkPos llllllllllllllIlIlllIllllllllIIl = new ChunkPos(llllllllllllllIlIlllIllllllllIll, llllllllllllllIlIlllIllllllllIlI);
        NBTTagCompound llllllllllllllIlIlllIllllllllIII = this.chunksToRemove.get(llllllllllllllIlIlllIllllllllIIl);
        if (llllllllllllllIlIlllIllllllllIII == null) {
            final DataInputStream llllllllllllllIlIlllIlllllllIlll = RegionFileCache.getChunkInputStream(this.chunkSaveLocation, llllllllllllllIlIlllIllllllllIll, llllllllllllllIlIlllIllllllllIlI);
            if (llllllllllllllIlIlllIlllllllIlll == null) {
                return null;
            }
            llllllllllllllIlIlllIllllllllIII = this.field_193416_e.process(FixTypes.CHUNK, CompressedStreamTools.read(llllllllllllllIlIlllIlllllllIlll));
        }
        return this.checkedReadChunkFromNBT(llllllllllllllIlIlllIlllllllIlIl, llllllllllllllIlIlllIllllllllIll, llllllllllllllIlIlllIllllllllIlI, llllllllllllllIlIlllIllllllllIII);
    }
    
    @Nullable
    protected static Entity createEntityFromNBT(final NBTTagCompound llllllllllllllIlIlllIllIllIllIIl, final World llllllllllllllIlIlllIllIllIllIll) {
        try {
            return EntityList.createEntityFromNBT(llllllllllllllIlIlllIllIllIllIIl, llllllllllllllIlIlllIllIllIllIll);
        }
        catch (RuntimeException llllllllllllllIlIlllIllIllIllIlI) {
            return null;
        }
    }
    
    @Override
    public void chunkTick() {
    }
    
    @Override
    public void saveExtraData() {
        try {
            this.savingExtraData = true;
            while (this.writeNextIO()) {}
        }
        finally {
            this.savingExtraData = false;
        }
        this.savingExtraData = false;
    }
}
