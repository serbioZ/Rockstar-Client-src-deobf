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

public class WorldGenClay extends WorldGenerator
{
    private final /* synthetic */ Block block;
    private final /* synthetic */ int numberOfBlocks;
    
    @Override
    public boolean generate(final World llllllllllllIlIIllllllIIlllIIlII, final Random llllllllllllIlIIllllllIIllllIIII, final BlockPos llllllllllllIlIIllllllIIlllIIIlI) {
        if (llllllllllllIlIIllllllIIlllIIlII.getBlockState(llllllllllllIlIIllllllIIlllIIIlI).getMaterial() != Material.WATER) {
            return false;
        }
        final int llllllllllllIlIIllllllIIlllIlllI = llllllllllllIlIIllllllIIllllIIII.nextInt(this.numberOfBlocks - 2) + 2;
        final int llllllllllllIlIIllllllIIlllIllIl = 1;
        for (int llllllllllllIlIIllllllIIlllIllII = llllllllllllIlIIllllllIIlllIIIlI.getX() - llllllllllllIlIIllllllIIlllIlllI; llllllllllllIlIIllllllIIlllIllII <= llllllllllllIlIIllllllIIlllIIIlI.getX() + llllllllllllIlIIllllllIIlllIlllI; ++llllllllllllIlIIllllllIIlllIllII) {
            for (int llllllllllllIlIIllllllIIlllIlIll = llllllllllllIlIIllllllIIlllIIIlI.getZ() - llllllllllllIlIIllllllIIlllIlllI; llllllllllllIlIIllllllIIlllIlIll <= llllllllllllIlIIllllllIIlllIIIlI.getZ() + llllllllllllIlIIllllllIIlllIlllI; ++llllllllllllIlIIllllllIIlllIlIll) {
                final int llllllllllllIlIIllllllIIlllIlIlI = llllllllllllIlIIllllllIIlllIllII - llllllllllllIlIIllllllIIlllIIIlI.getX();
                final int llllllllllllIlIIllllllIIlllIlIIl = llllllllllllIlIIllllllIIlllIlIll - llllllllllllIlIIllllllIIlllIIIlI.getZ();
                if (llllllllllllIlIIllllllIIlllIlIlI * llllllllllllIlIIllllllIIlllIlIlI + llllllllllllIlIIllllllIIlllIlIIl * llllllllllllIlIIllllllIIlllIlIIl <= llllllllllllIlIIllllllIIlllIlllI * llllllllllllIlIIllllllIIlllIlllI) {
                    for (int llllllllllllIlIIllllllIIlllIlIII = llllllllllllIlIIllllllIIlllIIIlI.getY() - 1; llllllllllllIlIIllllllIIlllIlIII <= llllllllllllIlIIllllllIIlllIIIlI.getY() + 1; ++llllllllllllIlIIllllllIIlllIlIII) {
                        final BlockPos llllllllllllIlIIllllllIIlllIIlll = new BlockPos(llllllllllllIlIIllllllIIlllIllII, llllllllllllIlIIllllllIIlllIlIII, llllllllllllIlIIllllllIIlllIlIll);
                        final Block llllllllllllIlIIllllllIIlllIIllI = llllllllllllIlIIllllllIIlllIIlII.getBlockState(llllllllllllIlIIllllllIIlllIIlll).getBlock();
                        if (llllllllllllIlIIllllllIIlllIIllI == Blocks.DIRT || llllllllllllIlIIllllllIIlllIIllI == Blocks.CLAY) {
                            llllllllllllIlIIllllllIIlllIIlII.setBlockState(llllllllllllIlIIllllllIIlllIIlll, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenClay(final int llllllllllllIlIIllllllIlIIIIIIlI) {
        this.block = Blocks.CLAY;
        this.numberOfBlocks = llllllllllllIlIIllllllIlIIIIIIlI;
    }
}
