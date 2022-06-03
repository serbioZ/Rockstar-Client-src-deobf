// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;

public class WorldGenMinable extends WorldGenerator
{
    private final /* synthetic */ IBlockState oreBlock;
    private final /* synthetic */ Predicate<IBlockState> predicate;
    private final /* synthetic */ int numberOfBlocks;
    
    public WorldGenMinable(final IBlockState lllllllllllllllllIIIlIllIllIllIl, final int lllllllllllllllllIIIlIllIllIllll) {
        this(lllllllllllllllllIIIlIllIllIllIl, lllllllllllllllllIIIlIllIllIllll, (Predicate<IBlockState>)new StonePredicate(null));
    }
    
    @Override
    public boolean generate(final World lllllllllllllllllIIIlIllIIIllllI, final Random lllllllllllllllllIIIlIllIIIlllIl, final BlockPos lllllllllllllllllIIIlIllIIIlllII) {
        final float lllllllllllllllllIIIlIllIIlllIll = lllllllllllllllllIIIlIllIIIlllIl.nextFloat() * 3.1415927f;
        final double lllllllllllllllllIIIlIllIIlllIlI = lllllllllllllllllIIIlIllIIIlllII.getX() + 8 + MathHelper.sin(lllllllllllllllllIIIlIllIIlllIll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllllIIIlIllIIlllIIl = lllllllllllllllllIIIlIllIIIlllII.getX() + 8 - MathHelper.sin(lllllllllllllllllIIIlIllIIlllIll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllllIIIlIllIIlllIII = lllllllllllllllllIIIlIllIIIlllII.getZ() + 8 + MathHelper.cos(lllllllllllllllllIIIlIllIIlllIll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllllIIIlIllIIllIlll = lllllllllllllllllIIIlIllIIIlllII.getZ() + 8 - MathHelper.cos(lllllllllllllllllIIIlIllIIlllIll) * this.numberOfBlocks / 8.0f;
        final double lllllllllllllllllIIIlIllIIllIllI = lllllllllllllllllIIIlIllIIIlllII.getY() + lllllllllllllllllIIIlIllIIIlllIl.nextInt(3) - 2;
        final double lllllllllllllllllIIIlIllIIllIlIl = lllllllllllllllllIIIlIllIIIlllII.getY() + lllllllllllllllllIIIlIllIIIlllIl.nextInt(3) - 2;
        for (int lllllllllllllllllIIIlIllIIllIlII = 0; lllllllllllllllllIIIlIllIIllIlII < this.numberOfBlocks; ++lllllllllllllllllIIIlIllIIllIlII) {
            final float lllllllllllllllllIIIlIllIIllIIll = lllllllllllllllllIIIlIllIIllIlII / (float)this.numberOfBlocks;
            final double lllllllllllllllllIIIlIllIIllIIlI = lllllllllllllllllIIIlIllIIlllIlI + (lllllllllllllllllIIIlIllIIlllIIl - lllllllllllllllllIIIlIllIIlllIlI) * lllllllllllllllllIIIlIllIIllIIll;
            final double lllllllllllllllllIIIlIllIIllIIIl = lllllllllllllllllIIIlIllIIllIllI + (lllllllllllllllllIIIlIllIIllIlIl - lllllllllllllllllIIIlIllIIllIllI) * lllllllllllllllllIIIlIllIIllIIll;
            final double lllllllllllllllllIIIlIllIIllIIII = lllllllllllllllllIIIlIllIIlllIII + (lllllllllllllllllIIIlIllIIllIlll - lllllllllllllllllIIIlIllIIlllIII) * lllllllllllllllllIIIlIllIIllIIll;
            final double lllllllllllllllllIIIlIllIIlIllll = lllllllllllllllllIIIlIllIIIlllIl.nextDouble() * this.numberOfBlocks / 16.0;
            final double lllllllllllllllllIIIlIllIIlIlllI = (MathHelper.sin(3.1415927f * lllllllllllllllllIIIlIllIIllIIll) + 1.0f) * lllllllllllllllllIIIlIllIIlIllll + 1.0;
            final double lllllllllllllllllIIIlIllIIlIllIl = (MathHelper.sin(3.1415927f * lllllllllllllllllIIIlIllIIllIIll) + 1.0f) * lllllllllllllllllIIIlIllIIlIllll + 1.0;
            final int lllllllllllllllllIIIlIllIIlIllII = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIlI - lllllllllllllllllIIIlIllIIlIlllI / 2.0);
            final int lllllllllllllllllIIIlIllIIlIlIll = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIIl - lllllllllllllllllIIIlIllIIlIllIl / 2.0);
            final int lllllllllllllllllIIIlIllIIlIlIlI = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIII - lllllllllllllllllIIIlIllIIlIlllI / 2.0);
            final int lllllllllllllllllIIIlIllIIlIlIIl = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIlI + lllllllllllllllllIIIlIllIIlIlllI / 2.0);
            final int lllllllllllllllllIIIlIllIIlIlIII = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIIl + lllllllllllllllllIIIlIllIIlIllIl / 2.0);
            final int lllllllllllllllllIIIlIllIIlIIlll = MathHelper.floor(lllllllllllllllllIIIlIllIIllIIII + lllllllllllllllllIIIlIllIIlIlllI / 2.0);
            for (int lllllllllllllllllIIIlIllIIlIIllI = lllllllllllllllllIIIlIllIIlIllII; lllllllllllllllllIIIlIllIIlIIllI <= lllllllllllllllllIIIlIllIIlIlIIl; ++lllllllllllllllllIIIlIllIIlIIllI) {
                final double lllllllllllllllllIIIlIllIIlIIlIl = (lllllllllllllllllIIIlIllIIlIIllI + 0.5 - lllllllllllllllllIIIlIllIIllIIlI) / (lllllllllllllllllIIIlIllIIlIlllI / 2.0);
                if (lllllllllllllllllIIIlIllIIlIIlIl * lllllllllllllllllIIIlIllIIlIIlIl < 1.0) {
                    for (int lllllllllllllllllIIIlIllIIlIIlII = lllllllllllllllllIIIlIllIIlIlIll; lllllllllllllllllIIIlIllIIlIIlII <= lllllllllllllllllIIIlIllIIlIlIII; ++lllllllllllllllllIIIlIllIIlIIlII) {
                        final double lllllllllllllllllIIIlIllIIlIIIll = (lllllllllllllllllIIIlIllIIlIIlII + 0.5 - lllllllllllllllllIIIlIllIIllIIIl) / (lllllllllllllllllIIIlIllIIlIllIl / 2.0);
                        if (lllllllllllllllllIIIlIllIIlIIlIl * lllllllllllllllllIIIlIllIIlIIlIl + lllllllllllllllllIIIlIllIIlIIIll * lllllllllllllllllIIIlIllIIlIIIll < 1.0) {
                            for (int lllllllllllllllllIIIlIllIIlIIIlI = lllllllllllllllllIIIlIllIIlIlIlI; lllllllllllllllllIIIlIllIIlIIIlI <= lllllllllllllllllIIIlIllIIlIIlll; ++lllllllllllllllllIIIlIllIIlIIIlI) {
                                final double lllllllllllllllllIIIlIllIIlIIIIl = (lllllllllllllllllIIIlIllIIlIIIlI + 0.5 - lllllllllllllllllIIIlIllIIllIIII) / (lllllllllllllllllIIIlIllIIlIlllI / 2.0);
                                if (lllllllllllllllllIIIlIllIIlIIlIl * lllllllllllllllllIIIlIllIIlIIlIl + lllllllllllllllllIIIlIllIIlIIIll * lllllllllllllllllIIIlIllIIlIIIll + lllllllllllllllllIIIlIllIIlIIIIl * lllllllllllllllllIIIlIllIIlIIIIl < 1.0) {
                                    final BlockPos lllllllllllllllllIIIlIllIIlIIIII = new BlockPos(lllllllllllllllllIIIlIllIIlIIllI, lllllllllllllllllIIIlIllIIlIIlII, lllllllllllllllllIIIlIllIIlIIIlI);
                                    if (this.predicate.apply((Object)lllllllllllllllllIIIlIllIIIllllI.getBlockState(lllllllllllllllllIIIlIllIIlIIIII))) {
                                        lllllllllllllllllIIIlIllIIIllllI.setBlockState(lllllllllllllllllIIIlIllIIlIIIII, this.oreBlock, 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenMinable(final IBlockState lllllllllllllllllIIIlIllIllIIllI, final int lllllllllllllllllIIIlIllIllIIIIl, final Predicate<IBlockState> lllllllllllllllllIIIlIllIllIIIII) {
        this.oreBlock = lllllllllllllllllIIIlIllIllIIllI;
        this.numberOfBlocks = lllllllllllllllllIIIlIllIllIIIIl;
        this.predicate = lllllllllllllllllIIIlIllIllIIIII;
    }
    
    static class StonePredicate implements Predicate<IBlockState>
    {
        private StonePredicate() {
        }
        
        public boolean apply(final IBlockState llllllllllllIllIlIIlIllIIIIIIIlI) {
            if (llllllllllllIllIlIIlIllIIIIIIIlI != null && llllllllllllIllIlIIlIllIIIIIIIlI.getBlock() == Blocks.STONE) {
                final BlockStone.EnumType llllllllllllIllIlIIlIllIIIIIIIll = llllllllllllIllIlIIlIllIIIIIIIlI.getValue(BlockStone.VARIANT);
                return llllllllllllIllIlIIlIllIIIIIIIll.func_190912_e();
            }
            return false;
        }
    }
}
