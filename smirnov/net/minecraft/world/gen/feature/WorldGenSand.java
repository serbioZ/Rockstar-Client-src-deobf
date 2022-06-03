// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenSand extends WorldGenerator
{
    private final /* synthetic */ Block block;
    private final /* synthetic */ int radius;
    
    @Override
    public boolean generate(final World lllllllllllIIIIllIllllIllIlIIlll, final Random lllllllllllIIIIllIllllIllIlIIllI, final BlockPos lllllllllllIIIIllIllllIllIlIIlIl) {
        if (lllllllllllIIIIllIllllIllIlIIlll.getBlockState(lllllllllllIIIIllIllllIllIlIIlIl).getMaterial() != Material.WATER) {
            return false;
        }
        final int lllllllllllIIIIllIllllIllIllIIIl = lllllllllllIIIIllIllllIllIlIIllI.nextInt(this.radius - 2) + 2;
        final int lllllllllllIIIIllIllllIllIllIIII = 2;
        for (int lllllllllllIIIIllIllllIllIlIllll = lllllllllllIIIIllIllllIllIlIIlIl.getX() - lllllllllllIIIIllIllllIllIllIIIl; lllllllllllIIIIllIllllIllIlIllll <= lllllllllllIIIIllIllllIllIlIIlIl.getX() + lllllllllllIIIIllIllllIllIllIIIl; ++lllllllllllIIIIllIllllIllIlIllll) {
            for (int lllllllllllIIIIllIllllIllIlIlllI = lllllllllllIIIIllIllllIllIlIIlIl.getZ() - lllllllllllIIIIllIllllIllIllIIIl; lllllllllllIIIIllIllllIllIlIlllI <= lllllllllllIIIIllIllllIllIlIIlIl.getZ() + lllllllllllIIIIllIllllIllIllIIIl; ++lllllllllllIIIIllIllllIllIlIlllI) {
                final int lllllllllllIIIIllIllllIllIlIllIl = lllllllllllIIIIllIllllIllIlIllll - lllllllllllIIIIllIllllIllIlIIlIl.getX();
                final int lllllllllllIIIIllIllllIllIlIllII = lllllllllllIIIIllIllllIllIlIlllI - lllllllllllIIIIllIllllIllIlIIlIl.getZ();
                if (lllllllllllIIIIllIllllIllIlIllIl * lllllllllllIIIIllIllllIllIlIllIl + lllllllllllIIIIllIllllIllIlIllII * lllllllllllIIIIllIllllIllIlIllII <= lllllllllllIIIIllIllllIllIllIIIl * lllllllllllIIIIllIllllIllIllIIIl) {
                    for (int lllllllllllIIIIllIllllIllIlIlIll = lllllllllllIIIIllIllllIllIlIIlIl.getY() - 2; lllllllllllIIIIllIllllIllIlIlIll <= lllllllllllIIIIllIllllIllIlIIlIl.getY() + 2; ++lllllllllllIIIIllIllllIllIlIlIll) {
                        final BlockPos lllllllllllIIIIllIllllIllIlIlIlI = new BlockPos(lllllllllllIIIIllIllllIllIlIllll, lllllllllllIIIIllIllllIllIlIlIll, lllllllllllIIIIllIllllIllIlIlllI);
                        final Block lllllllllllIIIIllIllllIllIlIlIIl = lllllllllllIIIIllIllllIllIlIIlll.getBlockState(lllllllllllIIIIllIllllIllIlIlIlI).getBlock();
                        if (lllllllllllIIIIllIllllIllIlIlIIl == Blocks.DIRT || lllllllllllIIIIllIllllIllIlIlIIl == Blocks.GRASS) {
                            lllllllllllIIIIllIllllIllIlIIlll.setBlockState(lllllllllllIIIIllIllllIllIlIlIlI, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenSand(final Block lllllllllllIIIIllIllllIlllIIIlll, final int lllllllllllIIIIllIllllIlllIIIIll) {
        this.block = lllllllllllIIIIllIllllIlllIIIlll;
        this.radius = lllllllllllIIIIllIllllIlllIIIIll;
    }
}
