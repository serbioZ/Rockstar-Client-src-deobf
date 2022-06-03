// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockDoublePlant;

public class WorldGenDoublePlant extends WorldGenerator
{
    private /* synthetic */ BlockDoublePlant.EnumPlantType plantType;
    
    public void setPlantType(final BlockDoublePlant.EnumPlantType lllllllllllIIIIIlIIlIIllIIIlIlll) {
        this.plantType = lllllllllllIIIIIlIIlIIllIIIlIlll;
    }
    
    @Override
    public boolean generate(final World lllllllllllIIIIIlIIlIIllIIIIlllI, final Random lllllllllllIIIIIlIIlIIllIIIIllIl, final BlockPos lllllllllllIIIIIlIIlIIllIIIIllII) {
        boolean lllllllllllIIIIIlIIlIIllIIIIlIll = false;
        for (int lllllllllllIIIIIlIIlIIllIIIIlIlI = 0; lllllllllllIIIIIlIIlIIllIIIIlIlI < 64; ++lllllllllllIIIIIlIIlIIllIIIIlIlI) {
            final BlockPos lllllllllllIIIIIlIIlIIllIIIIlIIl = lllllllllllIIIIIlIIlIIllIIIIllII.add(lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(8) - lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(8), lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(4) - lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(4), lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(8) - lllllllllllIIIIIlIIlIIllIIIIllIl.nextInt(8));
            if (lllllllllllIIIIIlIIlIIllIIIIlllI.isAirBlock(lllllllllllIIIIIlIIlIIllIIIIlIIl) && (!lllllllllllIIIIIlIIlIIllIIIIlllI.provider.getHasNoSky() || lllllllllllIIIIIlIIlIIllIIIIlIIl.getY() < 254) && Blocks.DOUBLE_PLANT.canPlaceBlockAt(lllllllllllIIIIIlIIlIIllIIIIlllI, lllllllllllIIIIIlIIlIIllIIIIlIIl)) {
                Blocks.DOUBLE_PLANT.placeAt(lllllllllllIIIIIlIIlIIllIIIIlllI, lllllllllllIIIIIlIIlIIllIIIIlIIl, this.plantType, 2);
                lllllllllllIIIIIlIIlIIllIIIIlIll = true;
            }
        }
        return lllllllllllIIIIIlIIlIIllIIIIlIll;
    }
}
