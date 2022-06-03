// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.gen.ChunkGeneratorEnd;

public class MapGenEndCity extends MapGenStructure
{
    private final /* synthetic */ ChunkGeneratorEnd endProvider;
    
    public MapGenEndCity(final ChunkGeneratorEnd llllllllllllIlllIllIIlllIIIIIlll) {
        this.endProvider = llllllllllllIlllIllIIlllIIIIIlll;
    }
    
    private static int func_191070_b(final int llllllllllllIlllIllIIllIllIIlIII, final int llllllllllllIlllIllIIllIllIIIlll, final ChunkGeneratorEnd llllllllllllIlllIllIIllIlIlllIIl) {
        final Random llllllllllllIlllIllIIllIllIIIlIl = new Random(llllllllllllIlllIllIIllIllIIlIII + llllllllllllIlllIllIIllIllIIIlll * 10387313);
        final Rotation llllllllllllIlllIllIIllIllIIIlII = Rotation.values()[llllllllllllIlllIllIIllIllIIIlIl.nextInt(Rotation.values().length)];
        final ChunkPrimer llllllllllllIlllIllIIllIllIIIIll = new ChunkPrimer();
        llllllllllllIlllIllIIllIlIlllIIl.setBlocksInChunk(llllllllllllIlllIllIIllIllIIlIII, llllllllllllIlllIllIIllIllIIIlll, llllllllllllIlllIllIIllIllIIIIll);
        int llllllllllllIlllIllIIllIllIIIIlI = 5;
        int llllllllllllIlllIllIIllIllIIIIIl = 5;
        if (llllllllllllIlllIllIIllIllIIIlII == Rotation.CLOCKWISE_90) {
            llllllllllllIlllIllIIllIllIIIIlI = -5;
        }
        else if (llllllllllllIlllIllIIllIllIIIlII == Rotation.CLOCKWISE_180) {
            llllllllllllIlllIllIIllIllIIIIlI = -5;
            llllllllllllIlllIllIIllIllIIIIIl = -5;
        }
        else if (llllllllllllIlllIllIIllIllIIIlII == Rotation.COUNTERCLOCKWISE_90) {
            llllllllllllIlllIllIIllIllIIIIIl = -5;
        }
        final int llllllllllllIlllIllIIllIllIIIIII = llllllllllllIlllIllIIllIllIIIIll.findGroundBlockIdx(7, 7);
        final int llllllllllllIlllIllIIllIlIllllll = llllllllllllIlllIllIIllIllIIIIll.findGroundBlockIdx(7, 7 + llllllllllllIlllIllIIllIllIIIIIl);
        final int llllllllllllIlllIllIIllIlIlllllI = llllllllllllIlllIllIIllIllIIIIll.findGroundBlockIdx(7 + llllllllllllIlllIllIIllIllIIIIlI, 7);
        final int llllllllllllIlllIllIIllIlIllllIl = llllllllllllIlllIllIIllIllIIIIll.findGroundBlockIdx(7 + llllllllllllIlllIllIIllIllIIIIlI, 7 + llllllllllllIlllIllIIllIllIIIIIl);
        final int llllllllllllIlllIllIIllIlIllllII = Math.min(Math.min(llllllllllllIlllIllIIllIllIIIIII, llllllllllllIlllIllIIllIlIllllll), Math.min(llllllllllllIlllIllIIllIlIlllllI, llllllllllllIlllIllIIllIlIllllIl));
        return llllllllllllIlllIllIIllIlIllllII;
    }
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllIlllIllIIllIlllIIIll, final int llllllllllllIlllIllIIllIlllIIIlI) {
        return new Start(this.worldObj, this.endProvider, this.rand, llllllllllllIlllIllIIllIlllIIIll, llllllllllllIlllIllIIllIlllIIIlI);
    }
    
    @Override
    public String getStructureName() {
        return "EndCity";
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World llllllllllllIlllIllIIllIllIllIII, final BlockPos llllllllllllIlllIllIIllIllIlIlll, final boolean llllllllllllIlllIllIIllIllIllIlI) {
        this.worldObj = llllllllllllIlllIllIIllIllIllIII;
        return MapGenStructure.func_191069_a(llllllllllllIlllIllIIllIllIllIII, this, llllllllllllIlllIllIIllIllIlIlll, 20, 11, 10387313, true, 100, llllllllllllIlllIllIIllIllIllIlI);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llllllllllllIlllIllIIllIllllIIlI, int llllllllllllIlllIllIIllIllllIIIl) {
        final int llllllllllllIlllIllIIllIlllllIIl = llllllllllllIlllIllIIllIllllIIlI;
        final int llllllllllllIlllIllIIllIlllllIII = llllllllllllIlllIllIIllIllllIIIl;
        if (llllllllllllIlllIllIIllIllllIIlI < 0) {
            llllllllllllIlllIllIIllIllllIIlI -= 19;
        }
        if (llllllllllllIlllIllIIllIllllIIIl < 0) {
            llllllllllllIlllIllIIllIllllIIIl -= 19;
        }
        int llllllllllllIlllIllIIllIllllIlll = llllllllllllIlllIllIIllIllllIIlI / 20;
        int llllllllllllIlllIllIIllIllllIllI = llllllllllllIlllIllIIllIllllIIIl / 20;
        final Random llllllllllllIlllIllIIllIllllIlIl = this.worldObj.setRandomSeed(llllllllllllIlllIllIIllIllllIlll, llllllllllllIlllIllIIllIllllIllI, 10387313);
        llllllllllllIlllIllIIllIllllIlll *= 20;
        llllllllllllIlllIllIIllIllllIllI *= 20;
        llllllllllllIlllIllIIllIllllIlll += (llllllllllllIlllIllIIllIllllIlIl.nextInt(9) + llllllllllllIlllIllIIllIllllIlIl.nextInt(9)) / 2;
        llllllllllllIlllIllIIllIllllIllI += (llllllllllllIlllIllIIllIllllIlIl.nextInt(9) + llllllllllllIlllIllIIllIllllIlIl.nextInt(9)) / 2;
        if (llllllllllllIlllIllIIllIlllllIIl == llllllllllllIlllIllIIllIllllIlll && llllllllllllIlllIllIIllIlllllIII == llllllllllllIlllIllIIllIllllIllI && this.endProvider.isIslandChunk(llllllllllllIlllIllIIllIlllllIIl, llllllllllllIlllIllIIllIlllllIII)) {
            final int llllllllllllIlllIllIIllIllllIlII = func_191070_b(llllllllllllIlllIllIIllIlllllIIl, llllllllllllIlllIllIIllIlllllIII, this.endProvider);
            return llllllllllllIlllIllIIllIllllIlII >= 60;
        }
        return false;
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean isSizeable;
        
        public Start(final World llllllllllllIllllIllIIlIIIIllllI, final ChunkGeneratorEnd llllllllllllIllllIllIIlIIIIlllIl, final Random llllllllllllIllllIllIIlIIIIlllII, final int llllllllllllIllllIllIIlIIIlIIIIl, final int llllllllllllIllllIllIIlIIIIllIlI) {
            super(llllllllllllIllllIllIIlIIIlIIIIl, llllllllllllIllllIllIIlIIIIllIlI);
            this.create(llllllllllllIllllIllIIlIIIIllllI, llllllllllllIllllIllIIlIIIIlllIl, llllllllllllIllllIllIIlIIIIlllII, llllllllllllIllllIllIIlIIIlIIIIl, llllllllllllIllllIllIIlIIIIllIlI);
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.isSizeable;
        }
        
        private void create(final World llllllllllllIllllIllIIlIIIIIIlII, final ChunkGeneratorEnd llllllllllllIllllIllIIlIIIIIIIll, final Random llllllllllllIllllIllIIlIIIIIIIlI, final int llllllllllllIllllIllIIlIIIIIIIIl, final int llllllllllllIllllIllIIlIIIIIlIlI) {
            final Random llllllllllllIllllIllIIlIIIIIlIIl = new Random(llllllllllllIllllIllIIlIIIIIIIIl + llllllllllllIllllIllIIlIIIIIlIlI * 10387313);
            final Rotation llllllllllllIllllIllIIlIIIIIlIII = Rotation.values()[llllllllllllIllllIllIIlIIIIIlIIl.nextInt(Rotation.values().length)];
            final int llllllllllllIllllIllIIlIIIIIIlll = func_191070_b(llllllllllllIllllIllIIlIIIIIIIIl, llllllllllllIllllIllIIlIIIIIlIlI, llllllllllllIllllIllIIlIIIIIIIll);
            if (llllllllllllIllllIllIIlIIIIIIlll < 60) {
                this.isSizeable = false;
            }
            else {
                final BlockPos llllllllllllIllllIllIIlIIIIIIllI = new BlockPos(llllllllllllIllllIllIIlIIIIIIIIl * 16 + 8, llllllllllllIllllIllIIlIIIIIIlll, llllllllllllIllllIllIIlIIIIIlIlI * 16 + 8);
                StructureEndCityPieces.func_191087_a(llllllllllllIllllIllIIlIIIIIIlII.getSaveHandler().getStructureTemplateManager(), llllllllllllIllllIllIIlIIIIIIllI, llllllllllllIllllIllIIlIIIIIlIII, this.components, llllllllllllIllllIllIIlIIIIIIIlI);
                this.updateBoundingBox();
                this.isSizeable = true;
            }
        }
        
        public Start() {
        }
    }
}
