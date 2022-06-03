// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenIcePath extends WorldGenerator
{
    private final /* synthetic */ int basePathWidth;
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World llllllllllllllllllIllIIllIlIIlIl, final Random llllllllllllllllllIllIIllIIlIlll, BlockPos llllllllllllllllllIllIIllIIlIllI) {
        while (llllllllllllllllllIllIIllIlIIlIl.isAirBlock(llllllllllllllllllIllIIllIIlIllI) && llllllllllllllllllIllIIllIIlIllI.getY() > 2) {
            llllllllllllllllllIllIIllIIlIllI = llllllllllllllllllIllIIllIIlIllI.down();
        }
        if (llllllllllllllllllIllIIllIlIIlIl.getBlockState(llllllllllllllllllIllIIllIIlIllI).getBlock() != Blocks.SNOW) {
            return false;
        }
        final int llllllllllllllllllIllIIllIlIIIlI = llllllllllllllllllIllIIllIIlIlll.nextInt(this.basePathWidth - 2) + 2;
        final int llllllllllllllllllIllIIllIlIIIIl = 1;
        for (int llllllllllllllllllIllIIllIlIIIII = llllllllllllllllllIllIIllIIlIllI.getX() - llllllllllllllllllIllIIllIlIIIlI; llllllllllllllllllIllIIllIlIIIII <= llllllllllllllllllIllIIllIIlIllI.getX() + llllllllllllllllllIllIIllIlIIIlI; ++llllllllllllllllllIllIIllIlIIIII) {
            for (int llllllllllllllllllIllIIllIIlllll = llllllllllllllllllIllIIllIIlIllI.getZ() - llllllllllllllllllIllIIllIlIIIlI; llllllllllllllllllIllIIllIIlllll <= llllllllllllllllllIllIIllIIlIllI.getZ() + llllllllllllllllllIllIIllIlIIIlI; ++llllllllllllllllllIllIIllIIlllll) {
                final int llllllllllllllllllIllIIllIIllllI = llllllllllllllllllIllIIllIlIIIII - llllllllllllllllllIllIIllIIlIllI.getX();
                final int llllllllllllllllllIllIIllIIlllIl = llllllllllllllllllIllIIllIIlllll - llllllllllllllllllIllIIllIIlIllI.getZ();
                if (llllllllllllllllllIllIIllIIllllI * llllllllllllllllllIllIIllIIllllI + llllllllllllllllllIllIIllIIlllIl * llllllllllllllllllIllIIllIIlllIl <= llllllllllllllllllIllIIllIlIIIlI * llllllllllllllllllIllIIllIlIIIlI) {
                    for (int llllllllllllllllllIllIIllIIlllII = llllllllllllllllllIllIIllIIlIllI.getY() - 1; llllllllllllllllllIllIIllIIlllII <= llllllllllllllllllIllIIllIIlIllI.getY() + 1; ++llllllllllllllllllIllIIllIIlllII) {
                        final BlockPos llllllllllllllllllIllIIllIIllIll = new BlockPos(llllllllllllllllllIllIIllIlIIIII, llllllllllllllllllIllIIllIIlllII, llllllllllllllllllIllIIllIIlllll);
                        final Block llllllllllllllllllIllIIllIIllIlI = llllllllllllllllllIllIIllIlIIlIl.getBlockState(llllllllllllllllllIllIIllIIllIll).getBlock();
                        if (llllllllllllllllllIllIIllIIllIlI == Blocks.DIRT || llllllllllllllllllIllIIllIIllIlI == Blocks.SNOW || llllllllllllllllllIllIIllIIllIlI == Blocks.ICE) {
                            llllllllllllllllllIllIIllIlIIlIl.setBlockState(llllllllllllllllllIllIIllIIllIll, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenIcePath(final int llllllllllllllllllIllIIllIllIlII) {
        this.block = Blocks.PACKED_ICE;
        this.basePathWidth = llllllllllllllllllIllIIllIllIlII;
    }
}
