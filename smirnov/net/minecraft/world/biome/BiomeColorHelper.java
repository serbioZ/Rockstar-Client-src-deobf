// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BiomeColorHelper
{
    private static final /* synthetic */ ColorResolver WATER_COLOR;
    private static final /* synthetic */ ColorResolver GRASS_COLOR;
    private static final /* synthetic */ ColorResolver FOLIAGE_COLOR;
    
    public static int getWaterColorAtPos(final IBlockAccess lllllllllllllllIIIlIIIIIIlIIIlll, final BlockPos lllllllllllllllIIIlIIIIIIlIIlIII) {
        return getColorAtPos(lllllllllllllllIIIlIIIIIIlIIIlll, lllllllllllllllIIIlIIIIIIlIIlIII, BiomeColorHelper.WATER_COLOR);
    }
    
    public static int getFoliageColorAtPos(final IBlockAccess lllllllllllllllIIIlIIIIIIlIIllIl, final BlockPos lllllllllllllllIIIlIIIIIIlIIlllI) {
        return getColorAtPos(lllllllllllllllIIIlIIIIIIlIIllIl, lllllllllllllllIIIlIIIIIIlIIlllI, BiomeColorHelper.FOLIAGE_COLOR);
    }
    
    static {
        GRASS_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome llllllllllllIIlIIlIlllllllllIlll, final BlockPos llllllllllllIIlIIlIlllllllllIllI) {
                return llllllllllllIIlIIlIlllllllllIlll.getGrassColorAtPos(llllllllllllIIlIIlIlllllllllIllI);
            }
        };
        FOLIAGE_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome lllllllllllIIIIlIlIllIlIIIIIIIIl, final BlockPos lllllllllllIIIIlIlIllIlIIIIIIIlI) {
                return lllllllllllIIIIlIlIllIlIIIIIIIIl.getFoliageColorAtPos(lllllllllllIIIIlIlIllIlIIIIIIIlI);
            }
        };
        WATER_COLOR = new ColorResolver() {
            @Override
            public int getColorAtPos(final Biome llllllllllllIlIIlIlIIlIllllIIIlI, final BlockPos llllllllllllIlIIlIlIIlIllllIIIIl) {
                return llllllllllllIlIIlIlIIlIllllIIIlI.getWaterColor();
            }
        };
    }
    
    public static int getGrassColorAtPos(final IBlockAccess lllllllllllllllIIIlIIIIIIlIlIlIl, final BlockPos lllllllllllllllIIIlIIIIIIlIlIIlI) {
        return getColorAtPos(lllllllllllllllIIIlIIIIIIlIlIlIl, lllllllllllllllIIIlIIIIIIlIlIIlI, BiomeColorHelper.GRASS_COLOR);
    }
    
    private static int getColorAtPos(final IBlockAccess lllllllllllllllIIIlIIIIIIllIIIII, final BlockPos lllllllllllllllIIIlIIIIIIllIIlll, final ColorResolver lllllllllllllllIIIlIIIIIIllIIllI) {
        int lllllllllllllllIIIlIIIIIIllIIlIl = 0;
        int lllllllllllllllIIIlIIIIIIllIIlII = 0;
        int lllllllllllllllIIIlIIIIIIllIIIll = 0;
        for (final BlockPos.MutableBlockPos lllllllllllllllIIIlIIIIIIllIIIlI : BlockPos.getAllInBoxMutable(lllllllllllllllIIIlIIIIIIllIIlll.add(-1, 0, -1), lllllllllllllllIIIlIIIIIIllIIlll.add(1, 0, 1))) {
            final int lllllllllllllllIIIlIIIIIIllIIIIl = lllllllllllllllIIIlIIIIIIllIIllI.getColorAtPos(lllllllllllllllIIIlIIIIIIllIIIII.getBiome(lllllllllllllllIIIlIIIIIIllIIIlI), lllllllllllllllIIIlIIIIIIllIIIlI);
            lllllllllllllllIIIlIIIIIIllIIlIl += (lllllllllllllllIIIlIIIIIIllIIIIl & 0xFF0000) >> 16;
            lllllllllllllllIIIlIIIIIIllIIlII += (lllllllllllllllIIIlIIIIIIllIIIIl & 0xFF00) >> 8;
            lllllllllllllllIIIlIIIIIIllIIIll += (lllllllllllllllIIIlIIIIIIllIIIIl & 0xFF);
        }
        return (lllllllllllllllIIIlIIIIIIllIIlIl / 9 & 0xFF) << 16 | (lllllllllllllllIIIlIIIIIIllIIlII / 9 & 0xFF) << 8 | (lllllllllllllllIIIlIIIIIIllIIIll / 9 & 0xFF);
    }
    
    interface ColorResolver
    {
        int getColorAtPos(final Biome p0, final BlockPos p1);
    }
}
