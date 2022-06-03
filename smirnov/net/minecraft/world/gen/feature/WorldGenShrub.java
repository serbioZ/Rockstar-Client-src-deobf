// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class WorldGenShrub extends WorldGenTrees
{
    private final /* synthetic */ IBlockState leavesMetadata;
    private final /* synthetic */ IBlockState woodMetadata;
    
    @Override
    public boolean generate(final World llllllllllllIllIIIIIlIlllllIllII, final Random llllllllllllIllIIIIIlIlllllIlIll, BlockPos llllllllllllIllIIIIIlIlllllIlIlI) {
        for (IBlockState llllllllllllIllIIIIIlIlllllllIII = llllllllllllIllIIIIIlIlllllIllII.getBlockState(llllllllllllIllIIIIIlIlllllIlIlI); (llllllllllllIllIIIIIlIlllllllIII.getMaterial() == Material.AIR || llllllllllllIllIIIIIlIlllllllIII.getMaterial() == Material.LEAVES) && llllllllllllIllIIIIIlIlllllIlIlI.getY() > 0; llllllllllllIllIIIIIlIlllllIlIlI = llllllllllllIllIIIIIlIlllllIlIlI.down(), llllllllllllIllIIIIIlIlllllllIII = llllllllllllIllIIIIIlIlllllIllII.getBlockState(llllllllllllIllIIIIIlIlllllIlIlI)) {}
        final Block llllllllllllIllIIIIIlIllllllIlll = llllllllllllIllIIIIIlIlllllIllII.getBlockState(llllllllllllIllIIIIIlIlllllIlIlI).getBlock();
        if (llllllllllllIllIIIIIlIllllllIlll == Blocks.DIRT || llllllllllllIllIIIIIlIllllllIlll == Blocks.GRASS) {
            llllllllllllIllIIIIIlIlllllIlIlI = llllllllllllIllIIIIIlIlllllIlIlI.up();
            this.setBlockAndNotifyAdequately(llllllllllllIllIIIIIlIlllllIllII, llllllllllllIllIIIIIlIlllllIlIlI, this.woodMetadata);
            for (int llllllllllllIllIIIIIlIllllllIllI = llllllllllllIllIIIIIlIlllllIlIlI.getY(); llllllllllllIllIIIIIlIllllllIllI <= llllllllllllIllIIIIIlIlllllIlIlI.getY() + 2; ++llllllllllllIllIIIIIlIllllllIllI) {
                final int llllllllllllIllIIIIIlIllllllIlIl = llllllllllllIllIIIIIlIllllllIllI - llllllllllllIllIIIIIlIlllllIlIlI.getY();
                for (int llllllllllllIllIIIIIlIllllllIlII = 2 - llllllllllllIllIIIIIlIllllllIlIl, llllllllllllIllIIIIIlIllllllIIll = llllllllllllIllIIIIIlIlllllIlIlI.getX() - llllllllllllIllIIIIIlIllllllIlII; llllllllllllIllIIIIIlIllllllIIll <= llllllllllllIllIIIIIlIlllllIlIlI.getX() + llllllllllllIllIIIIIlIllllllIlII; ++llllllllllllIllIIIIIlIllllllIIll) {
                    final int llllllllllllIllIIIIIlIllllllIIlI = llllllllllllIllIIIIIlIllllllIIll - llllllllllllIllIIIIIlIlllllIlIlI.getX();
                    for (int llllllllllllIllIIIIIlIllllllIIIl = llllllllllllIllIIIIIlIlllllIlIlI.getZ() - llllllllllllIllIIIIIlIllllllIlII; llllllllllllIllIIIIIlIllllllIIIl <= llllllllllllIllIIIIIlIlllllIlIlI.getZ() + llllllllllllIllIIIIIlIllllllIlII; ++llllllllllllIllIIIIIlIllllllIIIl) {
                        final int llllllllllllIllIIIIIlIllllllIIII = llllllllllllIllIIIIIlIllllllIIIl - llllllllllllIllIIIIIlIlllllIlIlI.getZ();
                        if (Math.abs(llllllllllllIllIIIIIlIllllllIIlI) != llllllllllllIllIIIIIlIllllllIlII || Math.abs(llllllllllllIllIIIIIlIllllllIIII) != llllllllllllIllIIIIIlIllllllIlII || llllllllllllIllIIIIIlIlllllIlIll.nextInt(2) != 0) {
                            final BlockPos llllllllllllIllIIIIIlIlllllIllll = new BlockPos(llllllllllllIllIIIIIlIllllllIIll, llllllllllllIllIIIIIlIllllllIllI, llllllllllllIllIIIIIlIllllllIIIl);
                            final Material llllllllllllIllIIIIIlIlllllIlllI = llllllllllllIllIIIIIlIlllllIllII.getBlockState(llllllllllllIllIIIIIlIlllllIllll).getMaterial();
                            if (llllllllllllIllIIIIIlIlllllIlllI == Material.AIR || llllllllllllIllIIIIIlIlllllIlllI == Material.LEAVES) {
                                this.setBlockAndNotifyAdequately(llllllllllllIllIIIIIlIlllllIllII, llllllllllllIllIIIIIlIlllllIllll, this.leavesMetadata);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenShrub(final IBlockState llllllllllllIllIIIIIllIIIIIIllII, final IBlockState llllllllllllIllIIIIIllIIIIIIlIll) {
        super(false);
        this.woodMetadata = llllllllllllIllIIIIIllIIIIIIllII;
        this.leavesMetadata = llllllllllllIllIIIIIllIIIIIIlIll;
    }
}
