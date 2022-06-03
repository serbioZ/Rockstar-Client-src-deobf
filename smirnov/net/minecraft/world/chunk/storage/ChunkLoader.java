// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTBase;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.nbt.NBTTagCompound;

public class ChunkLoader
{
    public static AnvilConverterData load(final NBTTagCompound lllllllllllllIllllIllIIIlIlIllII) {
        final int lllllllllllllIllllIllIIIlIllIIII = lllllllllllllIllllIllIIIlIlIllII.getInteger("xPos");
        final int lllllllllllllIllllIllIIIlIlIllll = lllllllllllllIllllIllIIIlIlIllII.getInteger("zPos");
        final AnvilConverterData lllllllllllllIllllIllIIIlIlIlllI = new AnvilConverterData(lllllllllllllIllllIllIIIlIllIIII, lllllllllllllIllllIllIIIlIlIllll);
        lllllllllllllIllllIllIIIlIlIlllI.blocks = lllllllllllllIllllIllIIIlIlIllII.getByteArray("Blocks");
        lllllllllllllIllllIllIIIlIlIlllI.data = new NibbleArrayReader(lllllllllllllIllllIllIIIlIlIllII.getByteArray("Data"), 7);
        lllllllllllllIllllIllIIIlIlIlllI.skyLight = new NibbleArrayReader(lllllllllllllIllllIllIIIlIlIllII.getByteArray("SkyLight"), 7);
        lllllllllllllIllllIllIIIlIlIlllI.blockLight = new NibbleArrayReader(lllllllllllllIllllIllIIIlIlIllII.getByteArray("BlockLight"), 7);
        lllllllllllllIllllIllIIIlIlIlllI.heightmap = lllllllllllllIllllIllIIIlIlIllII.getByteArray("HeightMap");
        lllllllllllllIllllIllIIIlIlIlllI.terrainPopulated = lllllllllllllIllllIllIIIlIlIllII.getBoolean("TerrainPopulated");
        lllllllllllllIllllIllIIIlIlIlllI.entities = lllllllllllllIllllIllIIIlIlIllII.getTagList("Entities", 10);
        lllllllllllllIllllIllIIIlIlIlllI.tileEntities = lllllllllllllIllllIllIIIlIlIllII.getTagList("TileEntities", 10);
        lllllllllllllIllllIllIIIlIlIlllI.tileTicks = lllllllllllllIllllIllIIIlIlIllII.getTagList("TileTicks", 10);
        try {
            lllllllllllllIllllIllIIIlIlIlllI.lastUpdated = lllllllllllllIllllIllIIIlIlIllII.getLong("LastUpdate");
        }
        catch (ClassCastException lllllllllllllIllllIllIIIlIlIllIl) {
            lllllllllllllIllllIllIIIlIlIlllI.lastUpdated = lllllllllllllIllllIllIIIlIlIllII.getInteger("LastUpdate");
        }
        return lllllllllllllIllllIllIIIlIlIlllI;
    }
    
    public static void convertToAnvilFormat(final AnvilConverterData lllllllllllllIllllIllIIIIlllllII, final NBTTagCompound lllllllllllllIllllIllIIIIllllIll, final BiomeProvider lllllllllllllIllllIllIIIlIIlIlIl) {
        lllllllllllllIllllIllIIIIllllIll.setInteger("xPos", lllllllllllllIllllIllIIIIlllllII.x);
        lllllllllllllIllllIllIIIIllllIll.setInteger("zPos", lllllllllllllIllllIllIIIIlllllII.z);
        lllllllllllllIllllIllIIIIllllIll.setLong("LastUpdate", lllllllllllllIllllIllIIIIlllllII.lastUpdated);
        final int[] lllllllllllllIllllIllIIIlIIlIlII = new int[lllllllllllllIllllIllIIIIlllllII.heightmap.length];
        for (int lllllllllllllIllllIllIIIlIIlIIll = 0; lllllllllllllIllllIllIIIlIIlIIll < lllllllllllllIllllIllIIIIlllllII.heightmap.length; ++lllllllllllllIllllIllIIIlIIlIIll) {
            lllllllllllllIllllIllIIIlIIlIlII[lllllllllllllIllllIllIIIlIIlIIll] = lllllllllllllIllllIllIIIIlllllII.heightmap[lllllllllllllIllllIllIIIlIIlIIll];
        }
        lllllllllllllIllllIllIIIIllllIll.setIntArray("HeightMap", lllllllllllllIllllIllIIIlIIlIlII);
        lllllllllllllIllllIllIIIIllllIll.setBoolean("TerrainPopulated", lllllllllllllIllllIllIIIIlllllII.terrainPopulated);
        final NBTTagList lllllllllllllIllllIllIIIlIIlIIlI = new NBTTagList();
        for (int lllllllllllllIllllIllIIIlIIlIIIl = 0; lllllllllllllIllllIllIIIlIIlIIIl < 8; ++lllllllllllllIllllIllIIIlIIlIIIl) {
            boolean lllllllllllllIllllIllIIIlIIlIIII = true;
            for (int lllllllllllllIllllIllIIIlIIIllll = 0; lllllllllllllIllllIllIIIlIIIllll < 16 && lllllllllllllIllllIllIIIlIIlIIII; ++lllllllllllllIllllIllIIIlIIIllll) {
                for (int lllllllllllllIllllIllIIIlIIIlllI = 0; lllllllllllllIllllIllIIIlIIIlllI < 16 && lllllllllllllIllllIllIIIlIIlIIII; ++lllllllllllllIllllIllIIIlIIIlllI) {
                    for (int lllllllllllllIllllIllIIIlIIIllIl = 0; lllllllllllllIllllIllIIIlIIIllIl < 16; ++lllllllllllllIllllIllIIIlIIIllIl) {
                        final int lllllllllllllIllllIllIIIlIIIllII = lllllllllllllIllllIllIIIlIIIllll << 11 | lllllllllllllIllllIllIIIlIIIllIl << 7 | lllllllllllllIllllIllIIIlIIIlllI + (lllllllllllllIllllIllIIIlIIlIIIl << 4);
                        final int lllllllllllllIllllIllIIIlIIIlIll = lllllllllllllIllllIllIIIIlllllII.blocks[lllllllllllllIllllIllIIIlIIIllII];
                        if (lllllllllllllIllllIllIIIlIIIlIll != 0) {
                            lllllllllllllIllllIllIIIlIIlIIII = false;
                            break;
                        }
                    }
                }
            }
            if (!lllllllllllllIllllIllIIIlIIlIIII) {
                final byte[] lllllllllllllIllllIllIIIlIIIlIlI = new byte[4096];
                final NibbleArray lllllllllllllIllllIllIIIlIIIlIIl = new NibbleArray();
                final NibbleArray lllllllllllllIllllIllIIIlIIIlIII = new NibbleArray();
                final NibbleArray lllllllllllllIllllIllIIIlIIIIlll = new NibbleArray();
                for (int lllllllllllllIllllIllIIIlIIIIllI = 0; lllllllllllllIllllIllIIIlIIIIllI < 16; ++lllllllllllllIllllIllIIIlIIIIllI) {
                    for (int lllllllllllllIllllIllIIIlIIIIlIl = 0; lllllllllllllIllllIllIIIlIIIIlIl < 16; ++lllllllllllllIllllIllIIIlIIIIlIl) {
                        for (int lllllllllllllIllllIllIIIlIIIIlII = 0; lllllllllllllIllllIllIIIlIIIIlII < 16; ++lllllllllllllIllllIllIIIlIIIIlII) {
                            final int lllllllllllllIllllIllIIIlIIIIIll = lllllllllllllIllllIllIIIlIIIIllI << 11 | lllllllllllllIllllIllIIIlIIIIlII << 7 | lllllllllllllIllllIllIIIlIIIIlIl + (lllllllllllllIllllIllIIIlIIlIIIl << 4);
                            final int lllllllllllllIllllIllIIIlIIIIIlI = lllllllllllllIllllIllIIIIlllllII.blocks[lllllllllllllIllllIllIIIlIIIIIll];
                            lllllllllllllIllllIllIIIlIIIlIlI[lllllllllllllIllllIllIIIlIIIIlIl << 8 | lllllllllllllIllllIllIIIlIIIIlII << 4 | lllllllllllllIllllIllIIIlIIIIllI] = (byte)(lllllllllllllIllllIllIIIlIIIIIlI & 0xFF);
                            lllllllllllllIllllIllIIIlIIIlIIl.set(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl, lllllllllllllIllllIllIIIlIIIIlII, lllllllllllllIllllIllIIIIlllllII.data.get(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl + (lllllllllllllIllllIllIIIlIIlIIIl << 4), lllllllllllllIllllIllIIIlIIIIlII));
                            lllllllllllllIllllIllIIIlIIIlIII.set(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl, lllllllllllllIllllIllIIIlIIIIlII, lllllllllllllIllllIllIIIIlllllII.skyLight.get(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl + (lllllllllllllIllllIllIIIlIIlIIIl << 4), lllllllllllllIllllIllIIIlIIIIlII));
                            lllllllllllllIllllIllIIIlIIIIlll.set(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl, lllllllllllllIllllIllIIIlIIIIlII, lllllllllllllIllllIllIIIIlllllII.blockLight.get(lllllllllllllIllllIllIIIlIIIIllI, lllllllllllllIllllIllIIIlIIIIlIl + (lllllllllllllIllllIllIIIlIIlIIIl << 4), lllllllllllllIllllIllIIIlIIIIlII));
                        }
                    }
                }
                final NBTTagCompound lllllllllllllIllllIllIIIlIIIIIIl = new NBTTagCompound();
                lllllllllllllIllllIllIIIlIIIIIIl.setByte("Y", (byte)(lllllllllllllIllllIllIIIlIIlIIIl & 0xFF));
                lllllllllllllIllllIllIIIlIIIIIIl.setByteArray("Blocks", lllllllllllllIllllIllIIIlIIIlIlI);
                lllllllllllllIllllIllIIIlIIIIIIl.setByteArray("Data", lllllllllllllIllllIllIIIlIIIlIIl.getData());
                lllllllllllllIllllIllIIIlIIIIIIl.setByteArray("SkyLight", lllllllllllllIllllIllIIIlIIIlIII.getData());
                lllllllllllllIllllIllIIIlIIIIIIl.setByteArray("BlockLight", lllllllllllllIllllIllIIIlIIIIlll.getData());
                lllllllllllllIllllIllIIIlIIlIIlI.appendTag(lllllllllllllIllllIllIIIlIIIIIIl);
            }
        }
        lllllllllllllIllllIllIIIIllllIll.setTag("Sections", lllllllllllllIllllIllIIIlIIlIIlI);
        final byte[] lllllllllllllIllllIllIIIlIIIIIII = new byte[256];
        final BlockPos.MutableBlockPos lllllllllllllIllllIllIIIIlllllll = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIllllIllIIIIllllllI = 0; lllllllllllllIllllIllIIIIllllllI < 16; ++lllllllllllllIllllIllIIIIllllllI) {
            for (int lllllllllllllIllllIllIIIIlllllIl = 0; lllllllllllllIllllIllIIIIlllllIl < 16; ++lllllllllllllIllllIllIIIIlllllIl) {
                lllllllllllllIllllIllIIIIlllllll.setPos(lllllllllllllIllllIllIIIIlllllII.x << 4 | lllllllllllllIllllIllIIIIllllllI, 0, lllllllllllllIllllIllIIIIlllllII.z << 4 | lllllllllllllIllllIllIIIIlllllIl);
                lllllllllllllIllllIllIIIlIIIIIII[lllllllllllllIllllIllIIIIlllllIl << 4 | lllllllllllllIllllIllIIIIllllllI] = (byte)(Biome.getIdForBiome(lllllllllllllIllllIllIIIlIIlIlIl.getBiome(lllllllllllllIllllIllIIIIlllllll, Biomes.DEFAULT)) & 0xFF);
            }
        }
        lllllllllllllIllllIllIIIIllllIll.setByteArray("Biomes", lllllllllllllIllllIllIIIlIIIIIII);
        lllllllllllllIllllIllIIIIllllIll.setTag("Entities", lllllllllllllIllllIllIIIIlllllII.entities);
        lllllllllllllIllllIllIIIIllllIll.setTag("TileEntities", lllllllllllllIllllIllIIIIlllllII.tileEntities);
        if (lllllllllllllIllllIllIIIIlllllII.tileTicks != null) {
            lllllllllllllIllllIllIIIIllllIll.setTag("TileTicks", lllllllllllllIllllIllIIIIlllllII.tileTicks);
        }
    }
    
    public static class AnvilConverterData
    {
        public /* synthetic */ boolean terrainPopulated;
        public /* synthetic */ NBTTagList tileTicks;
        public /* synthetic */ NBTTagList tileEntities;
        public /* synthetic */ NibbleArrayReader skyLight;
        public final /* synthetic */ int x;
        public /* synthetic */ byte[] heightmap;
        public /* synthetic */ NBTTagList entities;
        public /* synthetic */ NibbleArrayReader data;
        public /* synthetic */ byte[] blocks;
        public final /* synthetic */ int z;
        public /* synthetic */ NibbleArrayReader blockLight;
        public /* synthetic */ long lastUpdated;
        
        public AnvilConverterData(final int lIlIlIIIlllllll, final int lIlIlIIIllllllI) {
            this.x = lIlIlIIIlllllll;
            this.z = lIlIlIIIllllllI;
        }
    }
}
