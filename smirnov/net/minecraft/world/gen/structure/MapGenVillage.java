// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import java.util.Map;
import java.util.Arrays;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import java.util.List;

public class MapGenVillage extends MapGenStructure
{
    private /* synthetic */ int distance;
    public static final /* synthetic */ List<Biome> VILLAGE_SPAWN_BIOMES;
    private final /* synthetic */ int minTownSeparation;
    private /* synthetic */ int size;
    
    static {
        VILLAGE_SPAWN_BIOMES = Arrays.asList(Biomes.PLAINS, Biomes.DESERT, Biomes.SAVANNA, Biomes.TAIGA);
    }
    
    public MapGenVillage() {
        this.distance = 32;
        this.minTownSeparation = 8;
    }
    
    @Override
    public String getStructureName() {
        return "Village";
    }
    
    public MapGenVillage(final Map<String, String> llllllllllllIIlllIIllIIIllllIIlI) {
        this();
        for (final Map.Entry<String, String> llllllllllllIIlllIIllIIIllllIIIl : llllllllllllIIlllIIllIIIllllIIlI.entrySet()) {
            if (llllllllllllIIlllIIllIIIllllIIIl.getKey().equals("size")) {
                this.size = MathHelper.getInt(llllllllllllIIlllIIllIIIllllIIIl.getValue(), this.size, 0);
            }
            else {
                if (!llllllllllllIIlllIIllIIIllllIIIl.getKey().equals("distance")) {
                    continue;
                }
                this.distance = MathHelper.getInt(llllllllllllIIlllIIllIIIllllIIIl.getValue(), this.distance, 9);
            }
        }
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World llllllllllllIIlllIIllIIIllIIlIll, final BlockPos llllllllllllIIlllIIllIIIllIIlIlI, final boolean llllllllllllIIlllIIllIIIllIIlIIl) {
        this.worldObj = llllllllllllIIlllIIllIIIllIIlIll;
        return MapGenStructure.func_191069_a(llllllllllllIIlllIIllIIIllIIlIll, this, llllllllllllIIlllIIllIIIllIIlIlI, this.distance, 8, 10387312, false, 100, llllllllllllIIlllIIllIIIllIIlIIl);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llllllllllllIIlllIIllIIIllIllIII, int llllllllllllIIlllIIllIIIllIlIlll) {
        final int llllllllllllIIlllIIllIIIllIlllll = llllllllllllIIlllIIllIIIllIllIII;
        final int llllllllllllIIlllIIllIIIllIllllI = llllllllllllIIlllIIllIIIllIlIlll;
        if (llllllllllllIIlllIIllIIIllIllIII < 0) {
            llllllllllllIIlllIIllIIIllIllIII -= this.distance - 1;
        }
        if (llllllllllllIIlllIIllIIIllIlIlll < 0) {
            llllllllllllIIlllIIllIIIllIlIlll -= this.distance - 1;
        }
        int llllllllllllIIlllIIllIIIllIlllIl = llllllllllllIIlllIIllIIIllIllIII / this.distance;
        int llllllllllllIIlllIIllIIIllIlllII = llllllllllllIIlllIIllIIIllIlIlll / this.distance;
        final Random llllllllllllIIlllIIllIIIllIllIll = this.worldObj.setRandomSeed(llllllllllllIIlllIIllIIIllIlllIl, llllllllllllIIlllIIllIIIllIlllII, 10387312);
        llllllllllllIIlllIIllIIIllIlllIl *= this.distance;
        llllllllllllIIlllIIllIIIllIlllII *= this.distance;
        llllllllllllIIlllIIllIIIllIlllIl += llllllllllllIIlllIIllIIIllIllIll.nextInt(this.distance - 8);
        llllllllllllIIlllIIllIIIllIlllII += llllllllllllIIlllIIllIIIllIllIll.nextInt(this.distance - 8);
        if (llllllllllllIIlllIIllIIIllIlllll == llllllllllllIIlllIIllIIIllIlllIl && llllllllllllIIlllIIllIIIllIllllI == llllllllllllIIlllIIllIIIllIlllII) {
            final boolean llllllllllllIIlllIIllIIIllIllIlI = this.worldObj.getBiomeProvider().areBiomesViable(llllllllllllIIlllIIllIIIllIlllll * 16 + 8, llllllllllllIIlllIIllIIIllIllllI * 16 + 8, 0, MapGenVillage.VILLAGE_SPAWN_BIOMES);
            if (llllllllllllIIlllIIllIIIllIllIlI) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllIIlllIIllIIIlIllllIl, final int llllllllllllIIlllIIllIIIlIllllII) {
        return new Start(this.worldObj, this.rand, llllllllllllIIlllIIllIIIlIllllIl, llllllllllllIIlllIIllIIIlIllllII, this.size);
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean hasMoreThanTwoComponents;
        
        public Start() {
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound lllllllllllllIlIIllIIlllllIIIIlI) {
            super.readFromNBT(lllllllllllllIlIIllIIlllllIIIIlI);
            this.hasMoreThanTwoComponents = lllllllllllllIlIIllIIlllllIIIIlI.getBoolean("Valid");
        }
        
        @Override
        public void writeToNBT(final NBTTagCompound lllllllllllllIlIIllIIlllllIIlIlI) {
            super.writeToNBT(lllllllllllllIlIIllIIlllllIIlIlI);
            lllllllllllllIlIIllIIlllllIIlIlI.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }
        
        public Start(final World lllllllllllllIlIIllIIlllllIlllII, final Random lllllllllllllIlIIllIIllllllIlIll, final int lllllllllllllIlIIllIIlllllIllIlI, final int lllllllllllllIlIIllIIlllllIllIIl, final int lllllllllllllIlIIllIIllllllIlIII) {
            super(lllllllllllllIlIIllIIlllllIllIlI, lllllllllllllIlIIllIIlllllIllIIl);
            final List<StructureVillagePieces.PieceWeight> lllllllllllllIlIIllIIllllllIIlll = StructureVillagePieces.getStructureVillageWeightedPieceList(lllllllllllllIlIIllIIllllllIlIll, lllllllllllllIlIIllIIllllllIlIII);
            final StructureVillagePieces.Start lllllllllllllIlIIllIIllllllIIllI = new StructureVillagePieces.Start(lllllllllllllIlIIllIIlllllIlllII.getBiomeProvider(), 0, lllllllllllllIlIIllIIllllllIlIll, (lllllllllllllIlIIllIIlllllIllIlI << 4) + 2, (lllllllllllllIlIIllIIlllllIllIIl << 4) + 2, lllllllllllllIlIIllIIllllllIIlll, lllllllllllllIlIIllIIllllllIlIII);
            this.components.add(lllllllllllllIlIIllIIllllllIIllI);
            lllllllllllllIlIIllIIllllllIIllI.buildComponent(lllllllllllllIlIIllIIllllllIIllI, this.components, lllllllllllllIlIIllIIllllllIlIll);
            final List<StructureComponent> lllllllllllllIlIIllIIllllllIIlIl = lllllllllllllIlIIllIIllllllIIllI.pendingRoads;
            final List<StructureComponent> lllllllllllllIlIIllIIllllllIIlII = lllllllllllllIlIIllIIllllllIIllI.pendingHouses;
            while (!lllllllllllllIlIIllIIllllllIIlIl.isEmpty() || !lllllllllllllIlIIllIIllllllIIlII.isEmpty()) {
                if (lllllllllllllIlIIllIIllllllIIlIl.isEmpty()) {
                    final int lllllllllllllIlIIllIIllllllIIIll = lllllllllllllIlIIllIIllllllIlIll.nextInt(lllllllllllllIlIIllIIllllllIIlII.size());
                    final StructureComponent lllllllllllllIlIIllIIllllllIIIlI = lllllllllllllIlIIllIIllllllIIlII.remove(lllllllllllllIlIIllIIllllllIIIll);
                    lllllllllllllIlIIllIIllllllIIIlI.buildComponent(lllllllllllllIlIIllIIllllllIIllI, this.components, lllllllllllllIlIIllIIllllllIlIll);
                }
                else {
                    final int lllllllllllllIlIIllIIllllllIIIIl = lllllllllllllIlIIllIIllllllIlIll.nextInt(lllllllllllllIlIIllIIllllllIIlIl.size());
                    final StructureComponent lllllllllllllIlIIllIIllllllIIIII = lllllllllllllIlIIllIIllllllIIlIl.remove(lllllllllllllIlIIllIIllllllIIIIl);
                    lllllllllllllIlIIllIIllllllIIIII.buildComponent(lllllllllllllIlIIllIIllllllIIllI, this.components, lllllllllllllIlIIllIIllllllIlIll);
                }
            }
            this.updateBoundingBox();
            int lllllllllllllIlIIllIIlllllIlllll = 0;
            for (final StructureComponent lllllllllllllIlIIllIIlllllIllllI : this.components) {
                if (!(lllllllllllllIlIIllIIlllllIllllI instanceof StructureVillagePieces.Road)) {
                    ++lllllllllllllIlIIllIIlllllIlllll;
                }
            }
            this.hasMoreThanTwoComponents = (lllllllllllllIlIIllIIlllllIlllll > 2);
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.hasMoreThanTwoComponents;
        }
    }
}
