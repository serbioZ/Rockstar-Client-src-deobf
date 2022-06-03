// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenCactus extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllIlllIIIlllllllIllIIlII, final Random llllllllllIlllIIIlllllllIllIIIll, final BlockPos llllllllllIlllIIIlllllllIllIlIIl) {
        for (int llllllllllIlllIIIlllllllIllIlIII = 0; llllllllllIlllIIIlllllllIllIlIII < 10; ++llllllllllIlllIIIlllllllIllIlIII) {
            final BlockPos llllllllllIlllIIIlllllllIllIIlll = llllllllllIlllIIIlllllllIllIlIIl.add(llllllllllIlllIIIlllllllIllIIIll.nextInt(8) - llllllllllIlllIIIlllllllIllIIIll.nextInt(8), llllllllllIlllIIIlllllllIllIIIll.nextInt(4) - llllllllllIlllIIIlllllllIllIIIll.nextInt(4), llllllllllIlllIIIlllllllIllIIIll.nextInt(8) - llllllllllIlllIIIlllllllIllIIIll.nextInt(8));
            if (llllllllllIlllIIIlllllllIllIIlII.isAirBlock(llllllllllIlllIIIlllllllIllIIlll)) {
                for (int llllllllllIlllIIIlllllllIllIIllI = 1 + llllllllllIlllIIIlllllllIllIIIll.nextInt(llllllllllIlllIIIlllllllIllIIIll.nextInt(3) + 1), llllllllllIlllIIIlllllllIllIIlIl = 0; llllllllllIlllIIIlllllllIllIIlIl < llllllllllIlllIIIlllllllIllIIllI; ++llllllllllIlllIIIlllllllIllIIlIl) {
                    if (Blocks.CACTUS.canBlockStay(llllllllllIlllIIIlllllllIllIIlII, llllllllllIlllIIIlllllllIllIIlll)) {
                        llllllllllIlllIIIlllllllIllIIlII.setBlockState(llllllllllIlllIIIlllllllIllIIlll.up(llllllllllIlllIIIlllllllIllIIlIl), Blocks.CACTUS.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
