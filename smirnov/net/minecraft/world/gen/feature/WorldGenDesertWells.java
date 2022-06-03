// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.BlockSand;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.IBlockState;

public class WorldGenDesertWells extends WorldGenerator
{
    private final /* synthetic */ IBlockState water;
    private final /* synthetic */ IBlockState sandSlab;
    private final /* synthetic */ IBlockState sandstone;
    private static final /* synthetic */ BlockStateMatcher IS_SAND;
    
    public WorldGenDesertWells() {
        this.sandSlab = Blocks.STONE_SLAB.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SAND).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        this.sandstone = Blocks.SANDSTONE.getDefaultState();
        this.water = Blocks.FLOWING_WATER.getDefaultState();
    }
    
    @Override
    public boolean generate(final World lllllllllllIllllllIlIIllIIIllllI, final Random lllllllllllIllllllIlIIllIIlIllII, BlockPos lllllllllllIllllllIlIIllIIIlllIl) {
        while (lllllllllllIllllllIlIIllIIIllllI.isAirBlock(lllllllllllIllllllIlIIllIIIlllIl) && lllllllllllIllllllIlIIllIIIlllIl.getY() > 2) {
            lllllllllllIllllllIlIIllIIIlllIl = lllllllllllIllllllIlIIllIIIlllIl.down();
        }
        if (!WorldGenDesertWells.IS_SAND.apply(lllllllllllIllllllIlIIllIIIllllI.getBlockState(lllllllllllIllllllIlIIllIIIlllIl))) {
            return false;
        }
        for (int lllllllllllIllllllIlIIllIIlIlIlI = -2; lllllllllllIllllllIlIIllIIlIlIlI <= 2; ++lllllllllllIllllllIlIIllIIlIlIlI) {
            for (int lllllllllllIllllllIlIIllIIlIlIIl = -2; lllllllllllIllllllIlIIllIIlIlIIl <= 2; ++lllllllllllIllllllIlIIllIIlIlIIl) {
                if (lllllllllllIllllllIlIIllIIIllllI.isAirBlock(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIlIlI, -1, lllllllllllIllllllIlIIllIIlIlIIl)) && lllllllllllIllllllIlIIllIIIllllI.isAirBlock(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIlIlI, -2, lllllllllllIllllllIlIIllIIlIlIIl))) {
                    return false;
                }
            }
        }
        for (int lllllllllllIllllllIlIIllIIlIlIII = -1; lllllllllllIllllllIlIIllIIlIlIII <= 0; ++lllllllllllIllllllIlIIllIIlIlIII) {
            for (int lllllllllllIllllllIlIIllIIlIIlll = -2; lllllllllllIllllllIlIIllIIlIIlll <= 2; ++lllllllllllIllllllIlIIllIIlIIlll) {
                for (int lllllllllllIllllllIlIIllIIlIIllI = -2; lllllllllllIllllllIlIIllIIlIIllI <= 2; ++lllllllllllIllllllIlIIllIIlIIllI) {
                    lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIIlll, lllllllllllIllllllIlIIllIIlIlIII, lllllllllllIllllllIlIIllIIlIIllI), this.sandstone, 2);
                }
            }
        }
        lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl, this.water, 2);
        for (final EnumFacing lllllllllllIllllllIlIIllIIlIIlIl : EnumFacing.Plane.HORIZONTAL) {
            lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.offset(lllllllllllIllllllIlIIllIIlIIlIl), this.water, 2);
        }
        for (int lllllllllllIllllllIlIIllIIlIIlII = -2; lllllllllllIllllllIlIIllIIlIIlII <= 2; ++lllllllllllIllllllIlIIllIIlIIlII) {
            for (int lllllllllllIllllllIlIIllIIlIIIll = -2; lllllllllllIllllllIlIIllIIlIIIll <= 2; ++lllllllllllIllllllIlIIllIIlIIIll) {
                if (lllllllllllIllllllIlIIllIIlIIlII == -2 || lllllllllllIllllllIlIIllIIlIIlII == 2 || lllllllllllIllllllIlIIllIIlIIIll == -2 || lllllllllllIllllllIlIIllIIlIIIll == 2) {
                    lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIIlII, 1, lllllllllllIllllllIlIIllIIlIIIll), this.sandstone, 2);
                }
            }
        }
        lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(2, 1, 0), this.sandSlab, 2);
        lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(-2, 1, 0), this.sandSlab, 2);
        lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(0, 1, 2), this.sandSlab, 2);
        lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(0, 1, -2), this.sandSlab, 2);
        for (int lllllllllllIllllllIlIIllIIlIIIlI = -1; lllllllllllIllllllIlIIllIIlIIIlI <= 1; ++lllllllllllIllllllIlIIllIIlIIIlI) {
            for (int lllllllllllIllllllIlIIllIIlIIIIl = -1; lllllllllllIllllllIlIIllIIlIIIIl <= 1; ++lllllllllllIllllllIlIIllIIlIIIIl) {
                if (lllllllllllIllllllIlIIllIIlIIIlI == 0 && lllllllllllIllllllIlIIllIIlIIIIl == 0) {
                    lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIIIlI, 4, lllllllllllIllllllIlIIllIIlIIIIl), this.sandstone, 2);
                }
                else {
                    lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(lllllllllllIllllllIlIIllIIlIIIlI, 4, lllllllllllIllllllIlIIllIIlIIIIl), this.sandSlab, 2);
                }
            }
        }
        for (int lllllllllllIllllllIlIIllIIlIIIII = 1; lllllllllllIllllllIlIIllIIlIIIII <= 3; ++lllllllllllIllllllIlIIllIIlIIIII) {
            lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(-1, lllllllllllIllllllIlIIllIIlIIIII, -1), this.sandstone, 2);
            lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(-1, lllllllllllIllllllIlIIllIIlIIIII, 1), this.sandstone, 2);
            lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(1, lllllllllllIllllllIlIIllIIlIIIII, -1), this.sandstone, 2);
            lllllllllllIllllllIlIIllIIIllllI.setBlockState(lllllllllllIllllllIlIIllIIIlllIl.add(1, lllllllllllIllllllIlIIllIIlIIIII, 1), this.sandstone, 2);
        }
        return true;
    }
    
    static {
        IS_SAND = BlockStateMatcher.forBlock(Blocks.SAND).where(BlockSand.VARIANT, (com.google.common.base.Predicate<? extends BlockSand.EnumType>)Predicates.equalTo((Object)BlockSand.EnumType.SAND));
    }
}
