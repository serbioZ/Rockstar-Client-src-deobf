// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import java.util.Collection;
import com.google.common.collect.Lists;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.util.Rotation;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import java.util.Arrays;
import net.minecraft.init.Biomes;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.biome.Biome;
import java.util.List;

public class WoodlandMansion extends MapGenStructure
{
    public static final /* synthetic */ List<Biome> field_191072_a;
    private final /* synthetic */ ChunkGeneratorOverworld field_191075_h;
    
    static {
        field_191072_a = Arrays.asList(Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(final int lllllllllllIlllIIIIIIlIlllllIIlI, final int lllllllllllIlllIIIIIIlIlllllIIIl) {
        int lllllllllllIlllIIIIIIlIllllllIIl = lllllllllllIlllIIIIIIlIlllllIIlI;
        int lllllllllllIlllIIIIIIlIllllllIII = lllllllllllIlllIIIIIIlIlllllIIIl;
        if (lllllllllllIlllIIIIIIlIlllllIIlI < 0) {
            lllllllllllIlllIIIIIIlIllllllIIl = lllllllllllIlllIIIIIIlIlllllIIlI - 79;
        }
        if (lllllllllllIlllIIIIIIlIlllllIIIl < 0) {
            lllllllllllIlllIIIIIIlIllllllIII = lllllllllllIlllIIIIIIlIlllllIIIl - 79;
        }
        int lllllllllllIlllIIIIIIlIlllllIlll = lllllllllllIlllIIIIIIlIllllllIIl / 80;
        int lllllllllllIlllIIIIIIlIlllllIllI = lllllllllllIlllIIIIIIlIllllllIII / 80;
        final Random lllllllllllIlllIIIIIIlIlllllIlIl = this.worldObj.setRandomSeed(lllllllllllIlllIIIIIIlIlllllIlll, lllllllllllIlllIIIIIIlIlllllIllI, 10387319);
        lllllllllllIlllIIIIIIlIlllllIlll *= 80;
        lllllllllllIlllIIIIIIlIlllllIllI *= 80;
        lllllllllllIlllIIIIIIlIlllllIlll += (lllllllllllIlllIIIIIIlIlllllIlIl.nextInt(60) + lllllllllllIlllIIIIIIlIlllllIlIl.nextInt(60)) / 2;
        lllllllllllIlllIIIIIIlIlllllIllI += (lllllllllllIlllIIIIIIlIlllllIlIl.nextInt(60) + lllllllllllIlllIIIIIIlIlllllIlIl.nextInt(60)) / 2;
        if (lllllllllllIlllIIIIIIlIlllllIIlI == lllllllllllIlllIIIIIIlIlllllIlll && lllllllllllIlllIIIIIIlIlllllIIIl == lllllllllllIlllIIIIIIlIlllllIllI) {
            final boolean lllllllllllIlllIIIIIIlIlllllIlII = this.worldObj.getBiomeProvider().areBiomesViable(lllllllllllIlllIIIIIIlIlllllIIlI * 16 + 8, lllllllllllIlllIIIIIIlIlllllIIIl * 16 + 8, 32, WoodlandMansion.field_191072_a);
            if (lllllllllllIlllIIIIIIlIlllllIlII) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllIlllIIIIIIlIlllIlllll, final BlockPos lllllllllllIlllIIIIIIlIlllIllllI, final boolean lllllllllllIlllIIIIIIlIlllIlllIl) {
        this.worldObj = lllllllllllIlllIIIIIIlIlllIlllll;
        final BiomeProvider lllllllllllIlllIIIIIIlIllllIIIIl = lllllllllllIlllIIIIIIlIlllIlllll.getBiomeProvider();
        return (lllllllllllIlllIIIIIIlIllllIIIIl.func_190944_c() && lllllllllllIlllIIIIIIlIllllIIIIl.func_190943_d() != Biomes.ROOFED_FOREST) ? null : MapGenStructure.func_191069_a(lllllllllllIlllIIIIIIlIlllIlllll, this, lllllllllllIlllIIIIIIlIlllIllllI, 80, 20, 10387319, true, 100, lllllllllllIlllIIIIIIlIlllIlllIl);
    }
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllIlllIIIIIIlIlllIlIlII, final int lllllllllllIlllIIIIIIlIlllIlIllI) {
        return new Start(this.worldObj, this.field_191075_h, this.rand, lllllllllllIlllIIIIIIlIlllIlIlII, lllllllllllIlllIIIIIIlIlllIlIllI);
    }
    
    @Override
    public String getStructureName() {
        return "Mansion";
    }
    
    public WoodlandMansion(final ChunkGeneratorOverworld lllllllllllIlllIIIIIIllIIIIIlIIl) {
        this.field_191075_h = lllllllllllIlllIIIIIIllIIIIIlIIl;
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean field_191093_c;
        
        @Override
        public void generateStructure(final World lllllllllllllIIIIlllllIlIIlIIlll, final Random lllllllllllllIIIIlllllIlIIlIIllI, final StructureBoundingBox lllllllllllllIIIIlllllIlIIllIIIl) {
            super.generateStructure(lllllllllllllIIIIlllllIlIIlIIlll, lllllllllllllIIIIlllllIlIIlIIllI, lllllllllllllIIIIlllllIlIIllIIIl);
            final int lllllllllllllIIIIlllllIlIIllIIII = this.boundingBox.minY;
            for (int lllllllllllllIIIIlllllIlIIlIllll = lllllllllllllIIIIlllllIlIIllIIIl.minX; lllllllllllllIIIIlllllIlIIlIllll <= lllllllllllllIIIIlllllIlIIllIIIl.maxX; ++lllllllllllllIIIIlllllIlIIlIllll) {
                for (int lllllllllllllIIIIlllllIlIIlIlllI = lllllllllllllIIIIlllllIlIIllIIIl.minZ; lllllllllllllIIIIlllllIlIIlIlllI <= lllllllllllllIIIIlllllIlIIllIIIl.maxZ; ++lllllllllllllIIIIlllllIlIIlIlllI) {
                    final BlockPos lllllllllllllIIIIlllllIlIIlIllIl = new BlockPos(lllllllllllllIIIIlllllIlIIlIllll, lllllllllllllIIIIlllllIlIIllIIII, lllllllllllllIIIIlllllIlIIlIlllI);
                    if (!lllllllllllllIIIIlllllIlIIlIIlll.isAirBlock(lllllllllllllIIIIlllllIlIIlIllIl) && this.boundingBox.isVecInside(lllllllllllllIIIIlllllIlIIlIllIl)) {
                        boolean lllllllllllllIIIIlllllIlIIlIllII = false;
                        for (final StructureComponent lllllllllllllIIIIlllllIlIIlIlIll : this.components) {
                            if (lllllllllllllIIIIlllllIlIIlIlIll.boundingBox.isVecInside(lllllllllllllIIIIlllllIlIIlIllIl)) {
                                lllllllllllllIIIIlllllIlIIlIllII = true;
                                break;
                            }
                        }
                        if (lllllllllllllIIIIlllllIlIIlIllII) {
                            for (int lllllllllllllIIIIlllllIlIIlIlIlI = lllllllllllllIIIIlllllIlIIllIIII - 1; lllllllllllllIIIIlllllIlIIlIlIlI > 1; --lllllllllllllIIIIlllllIlIIlIlIlI) {
                                final BlockPos lllllllllllllIIIIlllllIlIIlIlIIl = new BlockPos(lllllllllllllIIIIlllllIlIIlIllll, lllllllllllllIIIIlllllIlIIlIlIlI, lllllllllllllIIIIlllllIlIIlIlllI);
                                if (!lllllllllllllIIIIlllllIlIIlIIlll.isAirBlock(lllllllllllllIIIIlllllIlIIlIlIIl) && !lllllllllllllIIIIlllllIlIIlIIlll.getBlockState(lllllllllllllIIIIlllllIlIIlIlIIl).getMaterial().isLiquid()) {
                                    break;
                                }
                                lllllllllllllIIIIlllllIlIIlIIlll.setBlockState(lllllllllllllIIIIlllllIlIIlIlIIl, Blocks.COBBLESTONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        
        public Start(final World lllllllllllllIIIIlllllIlIlllllIl, final ChunkGeneratorOverworld lllllllllllllIIIIlllllIlIlllllII, final Random lllllllllllllIIIIlllllIlIlllIlIl, final int lllllllllllllIIIIlllllIlIllllIlI, final int lllllllllllllIIIIlllllIlIlllIIll) {
            super(lllllllllllllIIIIlllllIlIllllIlI, lllllllllllllIIIIlllllIlIlllIIll);
            this.func_191092_a(lllllllllllllIIIIlllllIlIlllllIl, lllllllllllllIIIIlllllIlIlllllII, lllllllllllllIIIIlllllIlIlllIlIl, lllllllllllllIIIIlllllIlIllllIlI, lllllllllllllIIIIlllllIlIlllIIll);
        }
        
        private void func_191092_a(final World lllllllllllllIIIIlllllIlIlIIllll, final ChunkGeneratorOverworld lllllllllllllIIIIlllllIlIlIlllll, final Random lllllllllllllIIIIlllllIlIlIllllI, final int lllllllllllllIIIIlllllIlIlIlllIl, final int lllllllllllllIIIIlllllIlIlIIlIll) {
            final Rotation lllllllllllllIIIIlllllIlIlIllIll = Rotation.values()[lllllllllllllIIIIlllllIlIlIllllI.nextInt(Rotation.values().length)];
            final ChunkPrimer lllllllllllllIIIIlllllIlIlIllIlI = new ChunkPrimer();
            lllllllllllllIIIIlllllIlIlIlllll.setBlocksInChunk(lllllllllllllIIIIlllllIlIlIlllIl, lllllllllllllIIIIlllllIlIlIIlIll, lllllllllllllIIIIlllllIlIlIllIlI);
            int lllllllllllllIIIIlllllIlIlIllIIl = 5;
            int lllllllllllllIIIIlllllIlIlIllIII = 5;
            if (lllllllllllllIIIIlllllIlIlIllIll == Rotation.CLOCKWISE_90) {
                lllllllllllllIIIIlllllIlIlIllIIl = -5;
            }
            else if (lllllllllllllIIIIlllllIlIlIllIll == Rotation.CLOCKWISE_180) {
                lllllllllllllIIIIlllllIlIlIllIIl = -5;
                lllllllllllllIIIIlllllIlIlIllIII = -5;
            }
            else if (lllllllllllllIIIIlllllIlIlIllIll == Rotation.COUNTERCLOCKWISE_90) {
                lllllllllllllIIIIlllllIlIlIllIII = -5;
            }
            final int lllllllllllllIIIIlllllIlIlIlIlll = lllllllllllllIIIIlllllIlIlIllIlI.findGroundBlockIdx(7, 7);
            final int lllllllllllllIIIIlllllIlIlIlIllI = lllllllllllllIIIIlllllIlIlIllIlI.findGroundBlockIdx(7, 7 + lllllllllllllIIIIlllllIlIlIllIII);
            final int lllllllllllllIIIIlllllIlIlIlIlIl = lllllllllllllIIIIlllllIlIlIllIlI.findGroundBlockIdx(7 + lllllllllllllIIIIlllllIlIlIllIIl, 7);
            final int lllllllllllllIIIIlllllIlIlIlIlII = lllllllllllllIIIIlllllIlIlIllIlI.findGroundBlockIdx(7 + lllllllllllllIIIIlllllIlIlIllIIl, 7 + lllllllllllllIIIIlllllIlIlIllIII);
            final int lllllllllllllIIIIlllllIlIlIlIIll = Math.min(Math.min(lllllllllllllIIIIlllllIlIlIlIlll, lllllllllllllIIIIlllllIlIlIlIllI), Math.min(lllllllllllllIIIIlllllIlIlIlIlIl, lllllllllllllIIIIlllllIlIlIlIlII));
            if (lllllllllllllIIIIlllllIlIlIlIIll < 60) {
                this.field_191093_c = false;
            }
            else {
                final BlockPos lllllllllllllIIIIlllllIlIlIlIIlI = new BlockPos(lllllllllllllIIIIlllllIlIlIlllIl * 16 + 8, lllllllllllllIIIIlllllIlIlIlIIll + 1, lllllllllllllIIIIlllllIlIlIIlIll * 16 + 8);
                final List<WoodlandMansionPieces.MansionTemplate> lllllllllllllIIIIlllllIlIlIlIIIl = (List<WoodlandMansionPieces.MansionTemplate>)Lists.newLinkedList();
                WoodlandMansionPieces.func_191152_a(lllllllllllllIIIIlllllIlIlIIllll.getSaveHandler().getStructureTemplateManager(), lllllllllllllIIIIlllllIlIlIlIIlI, lllllllllllllIIIIlllllIlIlIllIll, lllllllllllllIIIIlllllIlIlIlIIIl, lllllllllllllIIIIlllllIlIlIllllI);
                this.components.addAll(lllllllllllllIIIIlllllIlIlIlIIIl);
                this.updateBoundingBox();
                this.field_191093_c = true;
            }
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.field_191093_c;
        }
        
        public Start() {
        }
    }
}
