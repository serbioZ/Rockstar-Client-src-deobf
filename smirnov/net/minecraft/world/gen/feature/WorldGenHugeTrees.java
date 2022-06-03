// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public abstract class WorldGenHugeTrees extends WorldGenAbstractTree
{
    protected /* synthetic */ int extraRandomHeight;
    protected final /* synthetic */ IBlockState leavesMetadata;
    protected final /* synthetic */ int baseHeight;
    protected final /* synthetic */ IBlockState woodMetadata;
    
    protected void growLeavesLayerStrict(final World llllllllllIlllIlIIlIlIlllIIIIllI, final BlockPos llllllllllIlllIlIIlIlIllIllllIlI, final int llllllllllIlllIlIIlIlIllIllllIIl) {
        final int llllllllllIlllIlIIlIlIlllIIIIIll = llllllllllIlllIlIIlIlIllIllllIIl * llllllllllIlllIlIIlIlIllIllllIIl;
        for (int llllllllllIlllIlIIlIlIlllIIIIIlI = -llllllllllIlllIlIIlIlIllIllllIIl; llllllllllIlllIlIIlIlIlllIIIIIlI <= llllllllllIlllIlIIlIlIllIllllIIl + 1; ++llllllllllIlllIlIIlIlIlllIIIIIlI) {
            for (int llllllllllIlllIlIIlIlIlllIIIIIIl = -llllllllllIlllIlIIlIlIllIllllIIl; llllllllllIlllIlIIlIlIlllIIIIIIl <= llllllllllIlllIlIIlIlIllIllllIIl + 1; ++llllllllllIlllIlIIlIlIlllIIIIIIl) {
                final int llllllllllIlllIlIIlIlIlllIIIIIII = llllllllllIlllIlIIlIlIlllIIIIIlI - 1;
                final int llllllllllIlllIlIIlIlIllIlllllll = llllllllllIlllIlIIlIlIlllIIIIIIl - 1;
                if (llllllllllIlllIlIIlIlIlllIIIIIlI * llllllllllIlllIlIIlIlIlllIIIIIlI + llllllllllIlllIlIIlIlIlllIIIIIIl * llllllllllIlllIlIIlIlIlllIIIIIIl <= llllllllllIlllIlIIlIlIlllIIIIIll || llllllllllIlllIlIIlIlIlllIIIIIII * llllllllllIlllIlIIlIlIlllIIIIIII + llllllllllIlllIlIIlIlIllIlllllll * llllllllllIlllIlIIlIlIllIlllllll <= llllllllllIlllIlIIlIlIlllIIIIIll || llllllllllIlllIlIIlIlIlllIIIIIlI * llllllllllIlllIlIIlIlIlllIIIIIlI + llllllllllIlllIlIIlIlIllIlllllll * llllllllllIlllIlIIlIlIllIlllllll <= llllllllllIlllIlIIlIlIlllIIIIIll || llllllllllIlllIlIIlIlIlllIIIIIII * llllllllllIlllIlIIlIlIlllIIIIIII + llllllllllIlllIlIIlIlIlllIIIIIIl * llllllllllIlllIlIIlIlIlllIIIIIIl <= llllllllllIlllIlIIlIlIlllIIIIIll) {
                    final BlockPos llllllllllIlllIlIIlIlIllIllllllI = llllllllllIlllIlIIlIlIllIllllIlI.add(llllllllllIlllIlIIlIlIlllIIIIIlI, 0, llllllllllIlllIlIIlIlIlllIIIIIIl);
                    final Material llllllllllIlllIlIIlIlIllIlllllIl = llllllllllIlllIlIIlIlIlllIIIIllI.getBlockState(llllllllllIlllIlIIlIlIllIllllllI).getMaterial();
                    if (llllllllllIlllIlIIlIlIllIlllllIl == Material.AIR || llllllllllIlllIlIIlIlIllIlllllIl == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(llllllllllIlllIlIIlIlIlllIIIIllI, llllllllllIlllIlIIlIlIllIllllllI, this.leavesMetadata);
                    }
                }
            }
        }
    }
    
    private boolean isSpaceAt(final World llllllllllIlllIlIIlIlIlllIllIllI, final BlockPos llllllllllIlllIlIIlIlIlllIlllllI, final int llllllllllIlllIlIIlIlIlllIllIlII) {
        boolean llllllllllIlllIlIIlIlIlllIllllII = true;
        if (llllllllllIlllIlIIlIlIlllIlllllI.getY() >= 1 && llllllllllIlllIlIIlIlIlllIlllllI.getY() + llllllllllIlllIlIIlIlIlllIllIlII + 1 <= 256) {
            for (int llllllllllIlllIlIIlIlIlllIlllIll = 0; llllllllllIlllIlIIlIlIlllIlllIll <= 1 + llllllllllIlllIlIIlIlIlllIllIlII; ++llllllllllIlllIlIIlIlIlllIlllIll) {
                int llllllllllIlllIlIIlIlIlllIlllIlI = 2;
                if (llllllllllIlllIlIIlIlIlllIlllIll == 0) {
                    llllllllllIlllIlIIlIlIlllIlllIlI = 1;
                }
                else if (llllllllllIlllIlIIlIlIlllIlllIll >= 1 + llllllllllIlllIlIIlIlIlllIllIlII - 2) {
                    llllllllllIlllIlIIlIlIlllIlllIlI = 2;
                }
                for (int llllllllllIlllIlIIlIlIlllIlllIIl = -llllllllllIlllIlIIlIlIlllIlllIlI; llllllllllIlllIlIIlIlIlllIlllIIl <= llllllllllIlllIlIIlIlIlllIlllIlI && llllllllllIlllIlIIlIlIlllIllllII; ++llllllllllIlllIlIIlIlIlllIlllIIl) {
                    for (int llllllllllIlllIlIIlIlIlllIlllIII = -llllllllllIlllIlIIlIlIlllIlllIlI; llllllllllIlllIlIIlIlIlllIlllIII <= llllllllllIlllIlIIlIlIlllIlllIlI && llllllllllIlllIlIIlIlIlllIllllII; ++llllllllllIlllIlIIlIlIlllIlllIII) {
                        if (llllllllllIlllIlIIlIlIlllIlllllI.getY() + llllllllllIlllIlIIlIlIlllIlllIll < 0 || llllllllllIlllIlIIlIlIlllIlllllI.getY() + llllllllllIlllIlIIlIlIlllIlllIll >= 256 || !this.canGrowInto(llllllllllIlllIlIIlIlIlllIllIllI.getBlockState(llllllllllIlllIlIIlIlIlllIlllllI.add(llllllllllIlllIlIIlIlIlllIlllIIl, llllllllllIlllIlIIlIlIlllIlllIll, llllllllllIlllIlIIlIlIlllIlllIII)).getBlock())) {
                            llllllllllIlllIlIIlIlIlllIllllII = false;
                        }
                    }
                }
            }
            return llllllllllIlllIlIIlIlIlllIllllII;
        }
        return false;
    }
    
    protected void growLeavesLayer(final World llllllllllIlllIlIIlIlIllIlIllllI, final BlockPos llllllllllIlllIlIIlIlIllIlIlllIl, final int llllllllllIlllIlIIlIlIllIlIlllII) {
        final int llllllllllIlllIlIIlIlIllIllIIlII = llllllllllIlllIlIIlIlIllIlIlllII * llllllllllIlllIlIIlIlIllIlIlllII;
        for (int llllllllllIlllIlIIlIlIllIllIIIll = -llllllllllIlllIlIIlIlIllIlIlllII; llllllllllIlllIlIIlIlIllIllIIIll <= llllllllllIlllIlIIlIlIllIlIlllII; ++llllllllllIlllIlIIlIlIllIllIIIll) {
            for (int llllllllllIlllIlIIlIlIllIllIIIlI = -llllllllllIlllIlIIlIlIllIlIlllII; llllllllllIlllIlIIlIlIllIllIIIlI <= llllllllllIlllIlIIlIlIllIlIlllII; ++llllllllllIlllIlIIlIlIllIllIIIlI) {
                if (llllllllllIlllIlIIlIlIllIllIIIll * llllllllllIlllIlIIlIlIllIllIIIll + llllllllllIlllIlIIlIlIllIllIIIlI * llllllllllIlllIlIIlIlIllIllIIIlI <= llllllllllIlllIlIIlIlIllIllIIlII) {
                    final BlockPos llllllllllIlllIlIIlIlIllIllIIIIl = llllllllllIlllIlIIlIlIllIlIlllIl.add(llllllllllIlllIlIIlIlIllIllIIIll, 0, llllllllllIlllIlIIlIlIllIllIIIlI);
                    final Material llllllllllIlllIlIIlIlIllIllIIIII = llllllllllIlllIlIIlIlIllIlIllllI.getBlockState(llllllllllIlllIlIIlIlIllIllIIIIl).getMaterial();
                    if (llllllllllIlllIlIIlIlIllIllIIIII == Material.AIR || llllllllllIlllIlIIlIlIllIllIIIII == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(llllllllllIlllIlIIlIlIllIlIllllI, llllllllllIlllIlIIlIlIllIllIIIIl, this.leavesMetadata);
                    }
                }
            }
        }
    }
    
    public WorldGenHugeTrees(final boolean llllllllllIlllIlIIlIlIllllIlIlll, final int llllllllllIlllIlIIlIlIllllIlllII, final int llllllllllIlllIlIIlIlIllllIllIll, final IBlockState llllllllllIlllIlIIlIlIllllIllIlI, final IBlockState llllllllllIlllIlIIlIlIllllIllIIl) {
        super(llllllllllIlllIlIIlIlIllllIlIlll);
        this.baseHeight = llllllllllIlllIlIIlIlIllllIlllII;
        this.extraRandomHeight = llllllllllIlllIlIIlIlIllllIllIll;
        this.woodMetadata = llllllllllIlllIlIIlIlIllllIllIlI;
        this.leavesMetadata = llllllllllIlllIlIIlIlIllllIllIIl;
    }
    
    private boolean ensureDirtsUnderneath(final BlockPos llllllllllIlllIlIIlIlIlllIlIIIll, final World llllllllllIlllIlIIlIlIlllIlIIIlI) {
        final BlockPos llllllllllIlllIlIIlIlIlllIlIIllI = llllllllllIlllIlIIlIlIlllIlIIIll.down();
        final Block llllllllllIlllIlIIlIlIlllIlIIlIl = llllllllllIlllIlIIlIlIlllIlIIIlI.getBlockState(llllllllllIlllIlIIlIlIlllIlIIllI).getBlock();
        if ((llllllllllIlllIlIIlIlIlllIlIIlIl == Blocks.GRASS || llllllllllIlllIlIIlIlIlllIlIIlIl == Blocks.DIRT) && llllllllllIlllIlIIlIlIlllIlIIIll.getY() >= 2) {
            this.setDirtAt(llllllllllIlllIlIIlIlIlllIlIIIlI, llllllllllIlllIlIIlIlIlllIlIIllI);
            this.setDirtAt(llllllllllIlllIlIIlIlIlllIlIIIlI, llllllllllIlllIlIIlIlIlllIlIIllI.east());
            this.setDirtAt(llllllllllIlllIlIIlIlIlllIlIIIlI, llllllllllIlllIlIIlIlIlllIlIIllI.south());
            this.setDirtAt(llllllllllIlllIlIIlIlIlllIlIIIlI, llllllllllIlllIlIIlIlIlllIlIIllI.south().east());
            return true;
        }
        return false;
    }
    
    protected boolean ensureGrowable(final World llllllllllIlllIlIIlIlIlllIIlIlIl, final Random llllllllllIlllIlIIlIlIlllIIllIIl, final BlockPos llllllllllIlllIlIIlIlIlllIIlIlII, final int llllllllllIlllIlIIlIlIlllIIlIIll) {
        return this.isSpaceAt(llllllllllIlllIlIIlIlIlllIIlIlIl, llllllllllIlllIlIIlIlIlllIIlIlII, llllllllllIlllIlIIlIlIlllIIlIIll) && this.ensureDirtsUnderneath(llllllllllIlllIlIIlIlIlllIIlIlII, llllllllllIlllIlIIlIlIlllIIlIlIl);
    }
    
    protected int getHeight(final Random llllllllllIlllIlIIlIlIllllIIlIll) {
        int llllllllllIlllIlIIlIlIllllIIllIl = llllllllllIlllIlIIlIlIllllIIlIll.nextInt(3) + this.baseHeight;
        if (this.extraRandomHeight > 1) {
            llllllllllIlllIlIIlIlIllllIIllIl += llllllllllIlllIlIIlIlIllllIIlIll.nextInt(this.extraRandomHeight);
        }
        return llllllllllIlllIlIIlIlIllllIIllIl;
    }
}
