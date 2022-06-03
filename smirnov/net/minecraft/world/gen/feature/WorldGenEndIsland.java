// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenEndIsland extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllIIIIllIlIlIlIlIlIlllI, final Random lllllllllllIIIIllIlIlIlIlIllIlIl, final BlockPos lllllllllllIIIIllIlIlIlIlIllIlII) {
        float lllllllllllIIIIllIlIlIlIlIllIIll = (float)(lllllllllllIIIIllIlIlIlIlIllIlIl.nextInt(3) + 4);
        for (int lllllllllllIIIIllIlIlIlIlIllIIlI = 0; lllllllllllIIIIllIlIlIlIlIllIIll > 0.5f; lllllllllllIIIIllIlIlIlIlIllIIll -= (float)(lllllllllllIIIIllIlIlIlIlIllIlIl.nextInt(2) + 0.5), --lllllllllllIIIIllIlIlIlIlIllIIlI) {
            for (int lllllllllllIIIIllIlIlIlIlIllIIIl = MathHelper.floor(-lllllllllllIIIIllIlIlIlIlIllIIll); lllllllllllIIIIllIlIlIlIlIllIIIl <= MathHelper.ceil(lllllllllllIIIIllIlIlIlIlIllIIll); ++lllllllllllIIIIllIlIlIlIlIllIIIl) {
                for (int lllllllllllIIIIllIlIlIlIlIllIIII = MathHelper.floor(-lllllllllllIIIIllIlIlIlIlIllIIll); lllllllllllIIIIllIlIlIlIlIllIIII <= MathHelper.ceil(lllllllllllIIIIllIlIlIlIlIllIIll); ++lllllllllllIIIIllIlIlIlIlIllIIII) {
                    if (lllllllllllIIIIllIlIlIlIlIllIIIl * lllllllllllIIIIllIlIlIlIlIllIIIl + lllllllllllIIIIllIlIlIlIlIllIIII * lllllllllllIIIIllIlIlIlIlIllIIII <= (lllllllllllIIIIllIlIlIlIlIllIIll + 1.0f) * (lllllllllllIIIIllIlIlIlIlIllIIll + 1.0f)) {
                        this.setBlockAndNotifyAdequately(lllllllllllIIIIllIlIlIlIlIlIlllI, lllllllllllIIIIllIlIlIlIlIllIlII.add(lllllllllllIIIIllIlIlIlIlIllIIIl, lllllllllllIIIIllIlIlIlIlIllIIlI, lllllllllllIIIIllIlIlIlIlIllIIII), Blocks.END_STONE.getDefaultState());
                    }
                }
            }
        }
        return true;
    }
}
