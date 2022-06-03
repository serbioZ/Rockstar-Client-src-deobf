// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockBush;

public class WorldGenBush extends WorldGenerator
{
    private final /* synthetic */ BlockBush block;
    
    public WorldGenBush(final BlockBush lllllllllllIlIlIlIllllIIIIlIIllI) {
        this.block = lllllllllllIlIlIlIllllIIIIlIIllI;
    }
    
    @Override
    public boolean generate(final World lllllllllllIlIlIlIllllIIIIIlllII, final Random lllllllllllIlIlIlIllllIIIIIlIlIl, final BlockPos lllllllllllIlIlIlIllllIIIIIllIlI) {
        for (int lllllllllllIlIlIlIllllIIIIIllIIl = 0; lllllllllllIlIlIlIllllIIIIIllIIl < 64; ++lllllllllllIlIlIlIllllIIIIIllIIl) {
            final BlockPos lllllllllllIlIlIlIllllIIIIIllIII = lllllllllllIlIlIlIllllIIIIIllIlI.add(lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(8) - lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(8), lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(4) - lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(4), lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(8) - lllllllllllIlIlIlIllllIIIIIlIlIl.nextInt(8));
            if (lllllllllllIlIlIlIllllIIIIIlllII.isAirBlock(lllllllllllIlIlIlIllllIIIIIllIII) && (!lllllllllllIlIlIlIllllIIIIIlllII.provider.getHasNoSky() || lllllllllllIlIlIlIllllIIIIIllIII.getY() < 255) && this.block.canBlockStay(lllllllllllIlIlIlIllllIIIIIlllII, lllllllllllIlIlIlIllllIIIIIllIII, this.block.getDefaultState())) {
                lllllllllllIlIlIlIllllIIIIIlllII.setBlockState(lllllllllllIlIlIlIllllIIIIIllIII, this.block.getDefaultState(), 2);
            }
        }
        return true;
    }
}
