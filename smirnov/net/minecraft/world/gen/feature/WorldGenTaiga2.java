// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;

public class WorldGenTaiga2 extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    public WorldGenTaiga2(final boolean llllllllllllIllIlIIlllIIIIlllIlI) {
        super(llllllllllllIllIlIIlllIIIIlllIlI);
    }
    
    @Override
    public boolean generate(final World llllllllllllIllIlIIlllIIIIIIIllI, final Random llllllllllllIllIlIIlllIIIIIIIlIl, final BlockPos llllllllllllIllIlIIlllIIIIIIIlII) {
        final int llllllllllllIllIlIIlllIIIIlIIIIl = llllllllllllIllIlIIlllIIIIIIIlIl.nextInt(4) + 6;
        final int llllllllllllIllIlIIlllIIIIlIIIII = 1 + llllllllllllIllIlIIlllIIIIIIIlIl.nextInt(2);
        final int llllllllllllIllIlIIlllIIIIIlllll = llllllllllllIllIlIIlllIIIIlIIIIl - llllllllllllIllIlIIlllIIIIlIIIII;
        final int llllllllllllIllIlIIlllIIIIIllllI = 2 + llllllllllllIllIlIIlllIIIIIIIlIl.nextInt(2);
        boolean llllllllllllIllIlIIlllIIIIIlllIl = true;
        if (llllllllllllIllIlIIlllIIIIIIIlII.getY() < 1 || llllllllllllIllIlIIlllIIIIIIIlII.getY() + llllllllllllIllIlIIlllIIIIlIIIIl + 1 > 256) {
            return false;
        }
        for (int llllllllllllIllIlIIlllIIIIIlllII = llllllllllllIllIlIIlllIIIIIIIlII.getY(); llllllllllllIllIlIIlllIIIIIlllII <= llllllllllllIllIlIIlllIIIIIIIlII.getY() + 1 + llllllllllllIllIlIIlllIIIIlIIIIl && llllllllllllIllIlIIlllIIIIIlllIl; ++llllllllllllIllIlIIlllIIIIIlllII) {
            int llllllllllllIllIlIIlllIIIIIllIlI = 0;
            if (llllllllllllIllIlIIlllIIIIIlllII - llllllllllllIllIlIIlllIIIIIIIlII.getY() < llllllllllllIllIlIIlllIIIIlIIIII) {
                final int llllllllllllIllIlIIlllIIIIIllIll = 0;
            }
            else {
                llllllllllllIllIlIIlllIIIIIllIlI = llllllllllllIllIlIIlllIIIIIllllI;
            }
            final BlockPos.MutableBlockPos llllllllllllIllIlIIlllIIIIIllIIl = new BlockPos.MutableBlockPos();
            for (int llllllllllllIllIlIIlllIIIIIllIII = llllllllllllIllIlIIlllIIIIIIIlII.getX() - llllllllllllIllIlIIlllIIIIIllIlI; llllllllllllIllIlIIlllIIIIIllIII <= llllllllllllIllIlIIlllIIIIIIIlII.getX() + llllllllllllIllIlIIlllIIIIIllIlI && llllllllllllIllIlIIlllIIIIIlllIl; ++llllllllllllIllIlIIlllIIIIIllIII) {
                for (int llllllllllllIllIlIIlllIIIIIlIlll = llllllllllllIllIlIIlllIIIIIIIlII.getZ() - llllllllllllIllIlIIlllIIIIIllIlI; llllllllllllIllIlIIlllIIIIIlIlll <= llllllllllllIllIlIIlllIIIIIIIlII.getZ() + llllllllllllIllIlIIlllIIIIIllIlI && llllllllllllIllIlIIlllIIIIIlllIl; ++llllllllllllIllIlIIlllIIIIIlIlll) {
                    if (llllllllllllIllIlIIlllIIIIIlllII >= 0 && llllllllllllIllIlIIlllIIIIIlllII < 256) {
                        final Material llllllllllllIllIlIIlllIIIIIlIllI = llllllllllllIllIlIIlllIIIIIIIllI.getBlockState(llllllllllllIllIlIIlllIIIIIllIIl.setPos(llllllllllllIllIlIIlllIIIIIllIII, llllllllllllIllIlIIlllIIIIIlllII, llllllllllllIllIlIIlllIIIIIlIlll)).getMaterial();
                        if (llllllllllllIllIlIIlllIIIIIlIllI != Material.AIR && llllllllllllIllIlIIlllIIIIIlIllI != Material.LEAVES) {
                            llllllllllllIllIlIIlllIIIIIlllIl = false;
                        }
                    }
                    else {
                        llllllllllllIllIlIIlllIIIIIlllIl = false;
                    }
                }
            }
        }
        if (!llllllllllllIllIlIIlllIIIIIlllIl) {
            return false;
        }
        final Block llllllllllllIllIlIIlllIIIIIlIlIl = llllllllllllIllIlIIlllIIIIIIIllI.getBlockState(llllllllllllIllIlIIlllIIIIIIIlII.down()).getBlock();
        if ((llllllllllllIllIlIIlllIIIIIlIlIl == Blocks.GRASS || llllllllllllIllIlIIlllIIIIIlIlIl == Blocks.DIRT || llllllllllllIllIlIIlllIIIIIlIlIl == Blocks.FARMLAND) && llllllllllllIllIlIIlllIIIIIIIlII.getY() < 256 - llllllllllllIllIlIIlllIIIIlIIIIl - 1) {
            this.setDirtAt(llllllllllllIllIlIIlllIIIIIIIllI, llllllllllllIllIlIIlllIIIIIIIlII.down());
            int llllllllllllIllIlIIlllIIIIIlIlII = llllllllllllIllIlIIlllIIIIIIIlIl.nextInt(2);
            int llllllllllllIllIlIIlllIIIIIlIIll = 1;
            int llllllllllllIllIlIIlllIIIIIlIIlI = 0;
            for (int llllllllllllIllIlIIlllIIIIIlIIIl = 0; llllllllllllIllIlIIlllIIIIIlIIIl <= llllllllllllIllIlIIlllIIIIIlllll; ++llllllllllllIllIlIIlllIIIIIlIIIl) {
                final int llllllllllllIllIlIIlllIIIIIlIIII = llllllllllllIllIlIIlllIIIIIIIlII.getY() + llllllllllllIllIlIIlllIIIIlIIIIl - llllllllllllIllIlIIlllIIIIIlIIIl;
                for (int llllllllllllIllIlIIlllIIIIIIllll = llllllllllllIllIlIIlllIIIIIIIlII.getX() - llllllllllllIllIlIIlllIIIIIlIlII; llllllllllllIllIlIIlllIIIIIIllll <= llllllllllllIllIlIIlllIIIIIIIlII.getX() + llllllllllllIllIlIIlllIIIIIlIlII; ++llllllllllllIllIlIIlllIIIIIIllll) {
                    final int llllllllllllIllIlIIlllIIIIIIlllI = llllllllllllIllIlIIlllIIIIIIllll - llllllllllllIllIlIIlllIIIIIIIlII.getX();
                    for (int llllllllllllIllIlIIlllIIIIIIllIl = llllllllllllIllIlIIlllIIIIIIIlII.getZ() - llllllllllllIllIlIIlllIIIIIlIlII; llllllllllllIllIlIIlllIIIIIIllIl <= llllllllllllIllIlIIlllIIIIIIIlII.getZ() + llllllllllllIllIlIIlllIIIIIlIlII; ++llllllllllllIllIlIIlllIIIIIIllIl) {
                        final int llllllllllllIllIlIIlllIIIIIIllII = llllllllllllIllIlIIlllIIIIIIllIl - llllllllllllIllIlIIlllIIIIIIIlII.getZ();
                        if (Math.abs(llllllllllllIllIlIIlllIIIIIIlllI) != llllllllllllIllIlIIlllIIIIIlIlII || Math.abs(llllllllllllIllIlIIlllIIIIIIllII) != llllllllllllIllIlIIlllIIIIIlIlII || llllllllllllIllIlIIlllIIIIIlIlII <= 0) {
                            final BlockPos llllllllllllIllIlIIlllIIIIIIlIll = new BlockPos(llllllllllllIllIlIIlllIIIIIIllll, llllllllllllIllIlIIlllIIIIIlIIII, llllllllllllIllIlIIlllIIIIIIllIl);
                            if (!llllllllllllIllIlIIlllIIIIIIIllI.getBlockState(llllllllllllIllIlIIlllIIIIIIlIll).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(llllllllllllIllIlIIlllIIIIIIIllI, llllllllllllIllIlIIlllIIIIIIlIll, WorldGenTaiga2.LEAF);
                            }
                        }
                    }
                }
                if (llllllllllllIllIlIIlllIIIIIlIlII >= llllllllllllIllIlIIlllIIIIIlIIll) {
                    llllllllllllIllIlIIlllIIIIIlIlII = llllllllllllIllIlIIlllIIIIIlIIlI;
                    llllllllllllIllIlIIlllIIIIIlIIlI = 1;
                    if (++llllllllllllIllIlIIlllIIIIIlIIll > llllllllllllIllIlIIlllIIIIIllllI) {
                        llllllllllllIllIlIIlllIIIIIlIIll = llllllllllllIllIlIIlllIIIIIllllI;
                    }
                }
                else {
                    ++llllllllllllIllIlIIlllIIIIIlIlII;
                }
            }
            for (int llllllllllllIllIlIIlllIIIIIIlIlI = llllllllllllIllIlIIlllIIIIIIIlIl.nextInt(3), llllllllllllIllIlIIlllIIIIIIlIIl = 0; llllllllllllIllIlIIlllIIIIIIlIIl < llllllllllllIllIlIIlllIIIIlIIIIl - llllllllllllIllIlIIlllIIIIIIlIlI; ++llllllllllllIllIlIIlllIIIIIIlIIl) {
                final Material llllllllllllIllIlIIlllIIIIIIlIII = llllllllllllIllIlIIlllIIIIIIIllI.getBlockState(llllllllllllIllIlIIlllIIIIIIIlII.up(llllllllllllIllIlIIlllIIIIIIlIIl)).getMaterial();
                if (llllllllllllIllIlIIlllIIIIIIlIII == Material.AIR || llllllllllllIllIlIIlllIIIIIIlIII == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(llllllllllllIllIlIIlllIIIIIIIllI, llllllllllllIllIlIIlllIIIIIIIlII.up(llllllllllllIllIlIIlllIIIIIIlIIl), WorldGenTaiga2.TRUNK);
                }
            }
            return true;
        }
        return false;
    }
}
