// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.Vec3i;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenBlockBlob extends WorldGenerator
{
    private final /* synthetic */ int startRadius;
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World lllllllllllIlllllIlIIlllllIIIIIl, final Random lllllllllllIlllllIlIIlllllIIIIII, BlockPos lllllllllllIlllllIlIIllllIllllll) {
        while (((Vec3i)lllllllllllIlllllIlIIllllIllllll).getY() > 3) {
            if (!lllllllllllIlllllIlIIlllllIIIIIl.isAirBlock(((BlockPos)lllllllllllIlllllIlIIllllIllllll).down())) {
                final Block lllllllllllIlllllIlIIlllllIIlIlI = lllllllllllIlllllIlIIlllllIIIIIl.getBlockState(((BlockPos)lllllllllllIlllllIlIIllllIllllll).down()).getBlock();
                if (lllllllllllIlllllIlIIlllllIIlIlI == Blocks.GRASS || lllllllllllIlllllIlIIlllllIIlIlI == Blocks.DIRT || lllllllllllIlllllIlIIlllllIIlIlI == Blocks.STONE) {
                    break;
                }
            }
            lllllllllllIlllllIlIIllllIllllll = ((BlockPos)lllllllllllIlllllIlIIllllIllllll).down();
        }
        if (((Vec3i)lllllllllllIlllllIlIIllllIllllll).getY() <= 3) {
            return false;
        }
        for (int lllllllllllIlllllIlIIlllllIIlIIl = this.startRadius, lllllllllllIlllllIlIIlllllIIlIII = 0; lllllllllllIlllllIlIIlllllIIlIIl >= 0 && lllllllllllIlllllIlIIlllllIIlIII < 3; ++lllllllllllIlllllIlIIlllllIIlIII) {
            final int lllllllllllIlllllIlIIlllllIIIlll = lllllllllllIlllllIlIIlllllIIlIIl + lllllllllllIlllllIlIIlllllIIIIII.nextInt(2);
            final int lllllllllllIlllllIlIIlllllIIIllI = lllllllllllIlllllIlIIlllllIIlIIl + lllllllllllIlllllIlIIlllllIIIIII.nextInt(2);
            final int lllllllllllIlllllIlIIlllllIIIlIl = lllllllllllIlllllIlIIlllllIIlIIl + lllllllllllIlllllIlIIlllllIIIIII.nextInt(2);
            final float lllllllllllIlllllIlIIlllllIIIlII = (lllllllllllIlllllIlIIlllllIIIlll + lllllllllllIlllllIlIIlllllIIIllI + lllllllllllIlllllIlIIlllllIIIlIl) * 0.333f + 0.5f;
            for (final BlockPos lllllllllllIlllllIlIIlllllIIIIll : BlockPos.getAllInBox(((BlockPos)lllllllllllIlllllIlIIllllIllllll).add(-lllllllllllIlllllIlIIlllllIIIlll, -lllllllllllIlllllIlIIlllllIIIllI, -lllllllllllIlllllIlIIlllllIIIlIl), ((BlockPos)lllllllllllIlllllIlIIllllIllllll).add(lllllllllllIlllllIlIIlllllIIIlll, lllllllllllIlllllIlIIlllllIIIllI, lllllllllllIlllllIlIIlllllIIIlIl))) {
                if (lllllllllllIlllllIlIIlllllIIIIll.distanceSq((Vec3i)lllllllllllIlllllIlIIllllIllllll) <= lllllllllllIlllllIlIIlllllIIIlII * lllllllllllIlllllIlIIlllllIIIlII) {
                    lllllllllllIlllllIlIIlllllIIIIIl.setBlockState(lllllllllllIlllllIlIIlllllIIIIll, this.block.getDefaultState(), 4);
                }
            }
            lllllllllllIlllllIlIIllllIllllll = ((BlockPos)lllllllllllIlllllIlIIllllIllllll).add(-(lllllllllllIlllllIlIIlllllIIlIIl + 1) + lllllllllllIlllllIlIIlllllIIIIII.nextInt(2 + lllllllllllIlllllIlIIlllllIIlIIl * 2), 0 - lllllllllllIlllllIlIIlllllIIIIII.nextInt(2), -(lllllllllllIlllllIlIIlllllIIlIIl + 1) + lllllllllllIlllllIlIIlllllIIIIII.nextInt(2 + lllllllllllIlllllIlIIlllllIIlIIl * 2));
        }
        return true;
    }
    
    public WorldGenBlockBlob(final Block lllllllllllIlllllIlIIlllllIlllll, final int lllllllllllIlllllIlIIlllllIllllI) {
        super(false);
        this.block = lllllllllllIlllllIlIIlllllIlllll;
        this.startRadius = lllllllllllIlllllIlIIlllllIllllI;
    }
}
