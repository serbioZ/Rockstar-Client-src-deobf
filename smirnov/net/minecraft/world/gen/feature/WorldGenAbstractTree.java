// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public abstract class WorldGenAbstractTree extends WorldGenerator
{
    public void generateSaplings(final World lllllllllllIIlIlIlIIllllllIIIlII, final Random lllllllllllIIlIlIlIIllllllIIIIll, final BlockPos lllllllllllIIlIlIlIIllllllIIIIlI) {
    }
    
    public WorldGenAbstractTree(final boolean lllllllllllIIlIlIlIIllllllIIllIl) {
        super(lllllllllllIIlIlIlIIllllllIIllIl);
    }
    
    protected void setDirtAt(final World lllllllllllIIlIlIlIIlllllIlllIlI, final BlockPos lllllllllllIIlIlIlIIlllllIllllII) {
        if (lllllllllllIIlIlIlIIlllllIlllIlI.getBlockState(lllllllllllIIlIlIlIIlllllIllllII).getBlock() != Blocks.DIRT) {
            this.setBlockAndNotifyAdequately(lllllllllllIIlIlIlIIlllllIlllIlI, lllllllllllIIlIlIlIIlllllIllllII, Blocks.DIRT.getDefaultState());
        }
    }
    
    protected boolean canGrowInto(final Block lllllllllllIIlIlIlIIllllllIIlIIl) {
        final Material lllllllllllIIlIlIlIIllllllIIlIII = lllllllllllIIlIlIlIIllllllIIlIIl.getDefaultState().getMaterial();
        return lllllllllllIIlIlIlIIllllllIIlIII == Material.AIR || lllllllllllIIlIlIlIIllllllIIlIII == Material.LEAVES || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.GRASS || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.DIRT || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.LOG || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.LOG2 || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.SAPLING || lllllllllllIIlIlIlIIllllllIIlIIl == Blocks.VINE;
    }
}
