// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Random;
import net.minecraft.util.math.MathHelper;
import java.util.Map;
import net.minecraft.world.biome.Biome;
import java.util.List;
import net.minecraft.util.math.ChunkPos;

public class MapGenStronghold extends MapGenStructure
{
    private /* synthetic */ double distance;
    private /* synthetic */ boolean ranBiomeCheck;
    private /* synthetic */ int spread;
    private /* synthetic */ ChunkPos[] structureCoords;
    private final /* synthetic */ List<Biome> allowedBiomes;
    
    public MapGenStronghold(final Map<String, String> lllllllllllIllllIIIIIlIIIIllIlIl) {
        this();
        for (final Map.Entry<String, String> lllllllllllIllllIIIIIlIIIIllIlII : lllllllllllIllllIIIIIlIIIIllIlIl.entrySet()) {
            if (lllllllllllIllllIIIIIlIIIIllIlII.getKey().equals("distance")) {
                this.distance = MathHelper.getDouble(lllllllllllIllllIIIIIlIIIIllIlII.getValue(), this.distance, 1.0);
            }
            else if (lllllllllllIllllIIIIIlIIIIllIlII.getKey().equals("count")) {
                this.structureCoords = new ChunkPos[MathHelper.getInt(lllllllllllIllllIIIIIlIIIIllIlII.getValue(), this.structureCoords.length, 1)];
            }
            else {
                if (!lllllllllllIllllIIIIIlIIIIllIlII.getKey().equals("spread")) {
                    continue;
                }
                this.spread = MathHelper.getInt(lllllllllllIllllIIIIIlIIIIllIlII.getValue(), this.spread, 1);
            }
        }
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllIllllIIIIIIllllIIlllI, final int lllllllllllIllllIIIIIIllllIIllIl) {
        Start lllllllllllIllllIIIIIIllllIlIIII;
        for (lllllllllllIllllIIIIIIllllIlIIII = new Start(this.worldObj, this.rand, lllllllllllIllllIIIIIIllllIIlllI, lllllllllllIllllIIIIIIllllIIllIl); lllllllllllIllllIIIIIIllllIlIIII.getComponents().isEmpty() || lllllllllllIllllIIIIIIllllIlIIII.getComponents().get(0).strongholdPortalRoom == null; lllllllllllIllllIIIIIIllllIlIIII = new Start(this.worldObj, this.rand, lllllllllllIllllIIIIIIllllIIlllI, lllllllllllIllllIIIIIIllllIIllIl)) {}
        return lllllllllllIllllIIIIIIllllIlIIII;
    }
    
    @Override
    public String getStructureName() {
        return "Stronghold";
    }
    
    private void generatePositions() {
        this.initializeStructureData(this.worldObj);
        int lllllllllllIllllIIIIIIllllllIIIl = 0;
        for (final StructureStart lllllllllllIllllIIIIIIlllllIllll : this.structureMap.values()) {
            if (lllllllllllIllllIIIIIIllllllIIIl < this.structureCoords.length) {
                this.structureCoords[lllllllllllIllllIIIIIIllllllIIIl++] = new ChunkPos(lllllllllllIllllIIIIIIlllllIllll.getChunkPosX(), lllllllllllIllllIIIIIIlllllIllll.getChunkPosZ());
            }
        }
        final Random lllllllllllIllllIIIIIIlllllIlllI = new Random();
        lllllllllllIllllIIIIIIlllllIlllI.setSeed(this.worldObj.getSeed());
        double lllllllllllIllllIIIIIIlllllIllIl = lllllllllllIllllIIIIIIlllllIlllI.nextDouble() * 3.141592653589793 * 2.0;
        int lllllllllllIllllIIIIIIlllllIllII = 0;
        int lllllllllllIllllIIIIIIlllllIlIll = 0;
        final int lllllllllllIllllIIIIIIlllllIlIlI = this.structureMap.size();
        if (lllllllllllIllllIIIIIIlllllIlIlI < this.structureCoords.length) {
            for (int lllllllllllIllllIIIIIIlllllIlIIl = 0; lllllllllllIllllIIIIIIlllllIlIIl < this.structureCoords.length; ++lllllllllllIllllIIIIIIlllllIlIIl) {
                final double lllllllllllIllllIIIIIIlllllIlIII = 4.0 * this.distance + this.distance * lllllllllllIllllIIIIIIlllllIllII * 6.0 + (lllllllllllIllllIIIIIIlllllIlllI.nextDouble() - 0.5) * this.distance * 2.5;
                int lllllllllllIllllIIIIIIlllllIIlll = (int)Math.round(Math.cos(lllllllllllIllllIIIIIIlllllIllIl) * lllllllllllIllllIIIIIIlllllIlIII);
                int lllllllllllIllllIIIIIIlllllIIllI = (int)Math.round(Math.sin(lllllllllllIllllIIIIIIlllllIllIl) * lllllllllllIllllIIIIIIlllllIlIII);
                final BlockPos lllllllllllIllllIIIIIIlllllIIlIl = this.worldObj.getBiomeProvider().findBiomePosition((lllllllllllIllllIIIIIIlllllIIlll << 4) + 8, (lllllllllllIllllIIIIIIlllllIIllI << 4) + 8, 112, this.allowedBiomes, lllllllllllIllllIIIIIIlllllIlllI);
                if (lllllllllllIllllIIIIIIlllllIIlIl != null) {
                    lllllllllllIllllIIIIIIlllllIIlll = lllllllllllIllllIIIIIIlllllIIlIl.getX() >> 4;
                    lllllllllllIllllIIIIIIlllllIIllI = lllllllllllIllllIIIIIIlllllIIlIl.getZ() >> 4;
                }
                if (lllllllllllIllllIIIIIIlllllIlIIl >= lllllllllllIllllIIIIIIlllllIlIlI) {
                    this.structureCoords[lllllllllllIllllIIIIIIlllllIlIIl] = new ChunkPos(lllllllllllIllllIIIIIIlllllIIlll, lllllllllllIllllIIIIIIlllllIIllI);
                }
                lllllllllllIllllIIIIIIlllllIllIl += 6.283185307179586 / this.spread;
                if (++lllllllllllIllllIIIIIIlllllIlIll == this.spread) {
                    ++lllllllllllIllllIIIIIIlllllIllII;
                    lllllllllllIllllIIIIIIlllllIlIll = 0;
                    this.spread += 2 * this.spread / (lllllllllllIllllIIIIIIlllllIllII + 1);
                    this.spread = Math.min(this.spread, this.structureCoords.length - lllllllllllIllllIIIIIIlllllIlIIl);
                    lllllllllllIllllIIIIIIlllllIllIl += lllllllllllIllllIIIIIIlllllIlllI.nextDouble() * 3.141592653589793 * 2.0;
                }
            }
        }
    }
    
    public MapGenStronghold() {
        this.structureCoords = new ChunkPos[128];
        this.distance = 32.0;
        this.spread = 3;
        this.allowedBiomes = (List<Biome>)Lists.newArrayList();
        for (final Biome lllllllllllIllllIIIIIlIIIIlllllI : Biome.REGISTRY) {
            if (lllllllllllIllllIIIIIlIIIIlllllI != null && lllllllllllIllllIIIIIlIIIIlllllI.getBaseHeight() > 0.0f) {
                this.allowedBiomes.add(lllllllllllIllllIIIIIlIIIIlllllI);
            }
        }
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllIllllIIIIIlIIIIlIIIll, final BlockPos lllllllllllIllllIIIIIlIIIIlIIIlI, final boolean lllllllllllIllllIIIIIlIIIIlIIIIl) {
        if (!this.ranBiomeCheck) {
            this.generatePositions();
            this.ranBiomeCheck = true;
        }
        BlockPos lllllllllllIllllIIIIIlIIIIlIIIII = null;
        final BlockPos.MutableBlockPos lllllllllllIllllIIIIIlIIIIIlllll = new BlockPos.MutableBlockPos(0, 0, 0);
        double lllllllllllIllllIIIIIlIIIIIllllI = Double.MAX_VALUE;
        final float lllllllllllIllllIIIIIlIIIIIlIIll;
        final Exception lllllllllllIllllIIIIIlIIIIIlIlII = (Exception)((ChunkPos[])(Object)(lllllllllllIllllIIIIIlIIIIIlIIll = (float)(Object)this.structureCoords)).length;
        for (double lllllllllllIllllIIIIIlIIIIIlIlIl = 0; lllllllllllIllllIIIIIlIIIIIlIlIl < lllllllllllIllllIIIIIlIIIIIlIlII; ++lllllllllllIllllIIIIIlIIIIIlIlIl) {
            final ChunkPos lllllllllllIllllIIIIIlIIIIIlllIl = lllllllllllIllllIIIIIlIIIIIlIIll[lllllllllllIllllIIIIIlIIIIIlIlIl];
            lllllllllllIllllIIIIIlIIIIIlllll.setPos((lllllllllllIllllIIIIIlIIIIIlllIl.chunkXPos << 4) + 8, 32, (lllllllllllIllllIIIIIlIIIIIlllIl.chunkZPos << 4) + 8);
            final double lllllllllllIllllIIIIIlIIIIIlllII = lllllllllllIllllIIIIIlIIIIIlllll.distanceSq(lllllllllllIllllIIIIIlIIIIlIIIlI);
            if (lllllllllllIllllIIIIIlIIIIlIIIII == null) {
                lllllllllllIllllIIIIIlIIIIlIIIII = new BlockPos(lllllllllllIllllIIIIIlIIIIIlllll);
                lllllllllllIllllIIIIIlIIIIIllllI = lllllllllllIllllIIIIIlIIIIIlllII;
            }
            else if (lllllllllllIllllIIIIIlIIIIIlllII < lllllllllllIllllIIIIIlIIIIIllllI) {
                lllllllllllIllllIIIIIlIIIIlIIIII = new BlockPos(lllllllllllIllllIIIIIlIIIIIlllll);
                lllllllllllIllllIIIIIlIIIIIllllI = lllllllllllIllllIIIIIlIIIIIlllII;
            }
        }
        return lllllllllllIllllIIIIIlIIIIlIIIII;
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllIllllIIIIIlIIIIIIlIIl, final int lllllllllllIllllIIIIIlIIIIIIIlII) {
        if (!this.ranBiomeCheck) {
            this.generatePositions();
            this.ranBiomeCheck = true;
        }
        final short lllllllllllIllllIIIIIlIIIIIIIIII;
        final boolean lllllllllllIllllIIIIIlIIIIIIIIIl = ((ChunkPos[])(Object)(lllllllllllIllllIIIIIlIIIIIIIIII = (short)(Object)this.structureCoords)).length != 0;
        for (long lllllllllllIllllIIIIIlIIIIIIIIlI = 0; lllllllllllIllllIIIIIlIIIIIIIIlI < (lllllllllllIllllIIIIIlIIIIIIIIIl ? 1 : 0); ++lllllllllllIllllIIIIIlIIIIIIIIlI) {
            final ChunkPos lllllllllllIllllIIIIIlIIIIIIIlll = lllllllllllIllllIIIIIlIIIIIIIIII[lllllllllllIllllIIIIIlIIIIIIIIlI];
            if (lllllllllllIllllIIIIIlIIIIIIlIIl == lllllllllllIllllIIIIIlIIIIIIIlll.chunkXPos && lllllllllllIllllIIIIIlIIIIIIIlII == lllllllllllIllllIIIIIlIIIIIIIlll.chunkZPos) {
                return true;
            }
        }
        return false;
    }
    
    public static class Start extends StructureStart
    {
        public Start() {
        }
        
        public Start(final World lllllllllllIIIIllIlllIIIIIIIIIlI, final Random lllllllllllIIIIllIllIllllllllIII, final int lllllllllllIIIIllIlllIIIIIIIIIII, final int lllllllllllIIIIllIllIlllllllllll) {
            super(lllllllllllIIIIllIlllIIIIIIIIIII, lllllllllllIIIIllIllIlllllllllll);
            StructureStrongholdPieces.prepareStructurePieces();
            final StructureStrongholdPieces.Stairs2 lllllllllllIIIIllIllIllllllllllI = new StructureStrongholdPieces.Stairs2(0, lllllllllllIIIIllIllIllllllllIII, (lllllllllllIIIIllIlllIIIIIIIIIII << 4) + 2, (lllllllllllIIIIllIllIlllllllllll << 4) + 2);
            this.components.add(lllllllllllIIIIllIllIllllllllllI);
            lllllllllllIIIIllIllIllllllllllI.buildComponent(lllllllllllIIIIllIllIllllllllllI, this.components, lllllllllllIIIIllIllIllllllllIII);
            final List<StructureComponent> lllllllllllIIIIllIllIlllllllllIl = lllllllllllIIIIllIllIllllllllllI.pendingChildren;
            while (!lllllllllllIIIIllIllIlllllllllIl.isEmpty()) {
                final int lllllllllllIIIIllIllIlllllllllII = lllllllllllIIIIllIllIllllllllIII.nextInt(lllllllllllIIIIllIllIlllllllllIl.size());
                final StructureComponent lllllllllllIIIIllIllIllllllllIll = lllllllllllIIIIllIllIlllllllllIl.remove(lllllllllllIIIIllIllIlllllllllII);
                lllllllllllIIIIllIllIllllllllIll.buildComponent(lllllllllllIIIIllIllIllllllllllI, this.components, lllllllllllIIIIllIllIllllllllIII);
            }
            this.updateBoundingBox();
            this.markAvailableHeight(lllllllllllIIIIllIlllIIIIIIIIIlI, lllllllllllIIIIllIllIllllllllIII, 10);
        }
    }
}
