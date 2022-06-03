// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockVine;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGenMegaJungle extends WorldGenHugeTrees
{
    private void placeVine(final World llllllllllllllIlIIlIlIlIIlIlIIlI, final Random llllllllllllllIlIIlIlIlIIlIlIIIl, final BlockPos llllllllllllllIlIIlIlIlIIlIlIIII, final PropertyBool llllllllllllllIlIIlIlIlIIlIIllll) {
        if (llllllllllllllIlIIlIlIlIIlIlIIIl.nextInt(3) > 0 && llllllllllllllIlIIlIlIlIIlIlIIlI.isAirBlock(llllllllllllllIlIIlIlIlIIlIlIIII)) {
            this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIlIlIIlI, llllllllllllllIlIIlIlIlIIlIlIIII, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)llllllllllllllIlIIlIlIlIIlIIllll, true));
        }
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIlIlIlIIllIIlII, final Random llllllllllllllIlIIlIlIlIIllIIIll, final BlockPos llllllllllllllIlIIlIlIlIIlllIlIl) {
        final int llllllllllllllIlIIlIlIlIIlllIlII = this.getHeight(llllllllllllllIlIIlIlIlIIllIIIll);
        if (!this.ensureGrowable(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIlllIlIl, llllllllllllllIlIIlIlIlIIlllIlII)) {
            return false;
        }
        this.createCrown(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIlllIlIl.up(llllllllllllllIlIIlIlIlIIlllIlII), 2);
        for (int llllllllllllllIlIIlIlIlIIlllIIll = llllllllllllllIlIIlIlIlIIlllIlIl.getY() + llllllllllllllIlIIlIlIlIIlllIlII - 2 - llllllllllllllIlIIlIlIlIIllIIIll.nextInt(4); llllllllllllllIlIIlIlIlIIlllIIll > llllllllllllllIlIIlIlIlIIlllIlIl.getY() + llllllllllllllIlIIlIlIlIIlllIlII / 2; llllllllllllllIlIIlIlIlIIlllIIll -= 2 + llllllllllllllIlIIlIlIlIIllIIIll.nextInt(4)) {
            final float llllllllllllllIlIIlIlIlIIlllIIlI = llllllllllllllIlIIlIlIlIIllIIIll.nextFloat() * 6.2831855f;
            int llllllllllllllIlIIlIlIlIIlllIIIl = llllllllllllllIlIIlIlIlIIlllIlIl.getX() + (int)(0.5f + MathHelper.cos(llllllllllllllIlIIlIlIlIIlllIIlI) * 4.0f);
            int llllllllllllllIlIIlIlIlIIlllIIII = llllllllllllllIlIIlIlIlIIlllIlIl.getZ() + (int)(0.5f + MathHelper.sin(llllllllllllllIlIIlIlIlIIlllIIlI) * 4.0f);
            for (int llllllllllllllIlIIlIlIlIIllIllll = 0; llllllllllllllIlIIlIlIlIIllIllll < 5; ++llllllllllllllIlIIlIlIlIIllIllll) {
                llllllllllllllIlIIlIlIlIIlllIIIl = llllllllllllllIlIIlIlIlIIlllIlIl.getX() + (int)(1.5f + MathHelper.cos(llllllllllllllIlIIlIlIlIIlllIIlI) * llllllllllllllIlIIlIlIlIIllIllll);
                llllllllllllllIlIIlIlIlIIlllIIII = llllllllllllllIlIIlIlIlIIlllIlIl.getZ() + (int)(1.5f + MathHelper.sin(llllllllllllllIlIIlIlIlIIlllIIlI) * llllllllllllllIlIIlIlIlIIllIllll);
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIllIIlII, new BlockPos(llllllllllllllIlIIlIlIlIIlllIIIl, llllllllllllllIlIIlIlIlIIlllIIll - 3 + llllllllllllllIlIIlIlIlIIllIllll / 2, llllllllllllllIlIIlIlIlIIlllIIII), this.woodMetadata);
            }
            final int llllllllllllllIlIIlIlIlIIllIlllI = 1 + llllllllllllllIlIIlIlIlIIllIIIll.nextInt(2);
            for (int llllllllllllllIlIIlIlIlIIllIllIl = llllllllllllllIlIIlIlIlIIlllIIll, llllllllllllllIlIIlIlIlIIllIllII = llllllllllllllIlIIlIlIlIIlllIIll - llllllllllllllIlIIlIlIlIIllIlllI; llllllllllllllIlIIlIlIlIIllIllII <= llllllllllllllIlIIlIlIlIIllIllIl; ++llllllllllllllIlIIlIlIlIIllIllII) {
                final int llllllllllllllIlIIlIlIlIIllIlIll = llllllllllllllIlIIlIlIlIIllIllII - llllllllllllllIlIIlIlIlIIllIllIl;
                this.growLeavesLayer(llllllllllllllIlIIlIlIlIIllIIlII, new BlockPos(llllllllllllllIlIIlIlIlIIlllIIIl, llllllllllllllIlIIlIlIlIIllIllII, llllllllllllllIlIIlIlIlIIlllIIII), 1 - llllllllllllllIlIIlIlIlIIllIlIll);
            }
        }
        for (int llllllllllllllIlIIlIlIlIIllIlIlI = 0; llllllllllllllIlIIlIlIlIIllIlIlI < llllllllllllllIlIIlIlIlIIlllIlII; ++llllllllllllllIlIIlIlIlIIllIlIlI) {
            final BlockPos llllllllllllllIlIIlIlIlIIllIlIIl = llllllllllllllIlIIlIlIlIIlllIlIl.up(llllllllllllllIlIIlIlIlIIllIlIlI);
            if (this.canGrowInto(llllllllllllllIlIIlIlIlIIllIIlII.getBlockState(llllllllllllllIlIIlIlIlIIllIlIIl).getBlock())) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIlIIl, this.woodMetadata);
                if (llllllllllllllIlIIlIlIlIIllIlIlI > 0) {
                    this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIlIIl.west(), BlockVine.EAST);
                    this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIlIIl.north(), BlockVine.SOUTH);
                }
            }
            if (llllllllllllllIlIIlIlIlIIllIlIlI < llllllllllllllIlIIlIlIlIIlllIlII - 1) {
                final BlockPos llllllllllllllIlIIlIlIlIIllIlIII = llllllllllllllIlIIlIlIlIIllIlIIl.east();
                if (this.canGrowInto(llllllllllllllIlIIlIlIlIIllIIlII.getBlockState(llllllllllllllIlIIlIlIlIIllIlIII).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIlIII, this.woodMetadata);
                    if (llllllllllllllIlIIlIlIlIIllIlIlI > 0) {
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIlIII.east(), BlockVine.WEST);
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIlIII.north(), BlockVine.SOUTH);
                    }
                }
                final BlockPos llllllllllllllIlIIlIlIlIIllIIlll = llllllllllllllIlIIlIlIlIIllIlIIl.south().east();
                if (this.canGrowInto(llllllllllllllIlIIlIlIlIIllIIlII.getBlockState(llllllllllllllIlIIlIlIlIIllIIlll).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIlll, this.woodMetadata);
                    if (llllllllllllllIlIIlIlIlIIllIlIlI > 0) {
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIIlll.east(), BlockVine.WEST);
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIIlll.south(), BlockVine.NORTH);
                    }
                }
                final BlockPos llllllllllllllIlIIlIlIlIIllIIllI = llllllllllllllIlIIlIlIlIIllIlIIl.south();
                if (this.canGrowInto(llllllllllllllIlIIlIlIlIIllIIlII.getBlockState(llllllllllllllIlIIlIlIlIIllIIllI).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIllI, this.woodMetadata);
                    if (llllllllllllllIlIIlIlIlIIllIlIlI > 0) {
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIIllI.west(), BlockVine.EAST);
                        this.placeVine(llllllllllllllIlIIlIlIlIIllIIlII, llllllllllllllIlIIlIlIlIIllIIIll, llllllllllllllIlIIlIlIlIIllIIllI.south(), BlockVine.NORTH);
                    }
                }
            }
        }
        return true;
    }
    
    private void createCrown(final World llllllllllllllIlIIlIlIlIIIllllII, final BlockPos llllllllllllllIlIIlIlIlIIIlllIll, final int llllllllllllllIlIIlIlIlIIIlllIlI) {
        final int llllllllllllllIlIIlIlIlIIIllllll = 2;
        for (int llllllllllllllIlIIlIlIlIIIlllllI = -2; llllllllllllllIlIIlIlIlIIIlllllI <= 0; ++llllllllllllllIlIIlIlIlIIIlllllI) {
            this.growLeavesLayerStrict(llllllllllllllIlIIlIlIlIIIllllII, llllllllllllllIlIIlIlIlIIIlllIll.up(llllllllllllllIlIIlIlIlIIIlllllI), llllllllllllllIlIIlIlIlIIIlllIlI + 1 - llllllllllllllIlIIlIlIlIIIlllllI);
        }
    }
    
    public WorldGenMegaJungle(final boolean llllllllllllllIlIIlIlIlIlIIlIIII, final int llllllllllllllIlIIlIlIlIlIIIllll, final int llllllllllllllIlIIlIlIlIlIIIlIII, final IBlockState llllllllllllllIlIIlIlIlIlIIIllIl, final IBlockState llllllllllllllIlIIlIlIlIlIIIIllI) {
        super(llllllllllllllIlIIlIlIlIlIIlIIII, llllllllllllllIlIIlIlIlIlIIIllll, llllllllllllllIlIIlIlIlIlIIIlIII, llllllllllllllIlIIlIlIlIlIIIllIl, llllllllllllllIlIIlIlIlIlIIIIllI);
    }
}
