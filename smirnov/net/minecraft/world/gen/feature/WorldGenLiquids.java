// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenLiquids extends WorldGenerator
{
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World llllllllllllIlIIlIIIIIlIIlllIIll, final Random llllllllllllIlIIlIIIIIlIIllllIlI, final BlockPos llllllllllllIlIIlIIIIIlIIlllIIIl) {
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.up()).getBlock() != Blocks.STONE) {
            return false;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.down()).getBlock() != Blocks.STONE) {
            return false;
        }
        final IBlockState llllllllllllIlIIlIIIIIlIIllllIII = llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl);
        if (llllllllllllIlIIlIIIIIlIIllllIII.getMaterial() != Material.AIR && llllllllllllIlIIlIIIIIlIIllllIII.getBlock() != Blocks.STONE) {
            return false;
        }
        int llllllllllllIlIIlIIIIIlIIlllIlll = 0;
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.west()).getBlock() == Blocks.STONE) {
            ++llllllllllllIlIIlIIIIIlIIlllIlll;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.east()).getBlock() == Blocks.STONE) {
            ++llllllllllllIlIIlIIIIIlIIlllIlll;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.north()).getBlock() == Blocks.STONE) {
            ++llllllllllllIlIIlIIIIIlIIlllIlll;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.getBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl.south()).getBlock() == Blocks.STONE) {
            ++llllllllllllIlIIlIIIIIlIIlllIlll;
        }
        int llllllllllllIlIIlIIIIIlIIlllIllI = 0;
        if (llllllllllllIlIIlIIIIIlIIlllIIll.isAirBlock(llllllllllllIlIIlIIIIIlIIlllIIIl.west())) {
            ++llllllllllllIlIIlIIIIIlIIlllIllI;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.isAirBlock(llllllllllllIlIIlIIIIIlIIlllIIIl.east())) {
            ++llllllllllllIlIIlIIIIIlIIlllIllI;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.isAirBlock(llllllllllllIlIIlIIIIIlIIlllIIIl.north())) {
            ++llllllllllllIlIIlIIIIIlIIlllIllI;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIIll.isAirBlock(llllllllllllIlIIlIIIIIlIIlllIIIl.south())) {
            ++llllllllllllIlIIlIIIIIlIIlllIllI;
        }
        if (llllllllllllIlIIlIIIIIlIIlllIlll == 3 && llllllllllllIlIIlIIIIIlIIlllIllI == 1) {
            final IBlockState llllllllllllIlIIlIIIIIlIIlllIlIl = this.block.getDefaultState();
            llllllllllllIlIIlIIIIIlIIlllIIll.setBlockState(llllllllllllIlIIlIIIIIlIIlllIIIl, llllllllllllIlIIlIIIIIlIIlllIlIl, 2);
            llllllllllllIlIIlIIIIIlIIlllIIll.immediateBlockTick(llllllllllllIlIIlIIIIIlIIlllIIIl, llllllllllllIlIIlIIIIIlIIlllIlIl, llllllllllllIlIIlIIIIIlIIllllIlI);
        }
        return true;
    }
    
    public WorldGenLiquids(final Block llllllllllllIlIIlIIIIIlIlIIIIlIl) {
        this.block = llllllllllllIlIIlIIIIIlIlIIIIlIl;
    }
}
