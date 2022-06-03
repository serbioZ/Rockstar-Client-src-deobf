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

public class WorldGenHellLava extends WorldGenerator
{
    private final /* synthetic */ boolean insideRock;
    private final /* synthetic */ Block block;
    
    public WorldGenHellLava(final Block lllllllllllIllIIlIIIlllllIIlIllI, final boolean lllllllllllIllIIlIIIlllllIIlIIlI) {
        this.block = lllllllllllIllIIlIIIlllllIIlIllI;
        this.insideRock = lllllllllllIllIIlIIIlllllIIlIIlI;
    }
    
    @Override
    public boolean generate(final World lllllllllllIllIIlIIIlllllIIIIIlI, final Random lllllllllllIllIIlIIIlllllIIIIIIl, final BlockPos lllllllllllIllIIlIIIlllllIIIIIII) {
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII).getMaterial() != Material.AIR && lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        int lllllllllllIllIIlIIIlllllIIIIllI = 0;
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.west()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllIllIIlIIIlllllIIIIllI;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.east()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllIllIIlIIIlllllIIIIllI;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.north()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllIllIIlIIIlllllIIIIllI;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.south()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllIllIIlIIIlllllIIIIllI;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.getBlockState(lllllllllllIllIIlIIIlllllIIIIIII.down()).getBlock() == Blocks.NETHERRACK) {
            ++lllllllllllIllIIlIIIlllllIIIIllI;
        }
        int lllllllllllIllIIlIIIlllllIIIIlIl = 0;
        if (lllllllllllIllIIlIIIlllllIIIIIlI.isAirBlock(lllllllllllIllIIlIIIlllllIIIIIII.west())) {
            ++lllllllllllIllIIlIIIlllllIIIIlIl;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.isAirBlock(lllllllllllIllIIlIIIlllllIIIIIII.east())) {
            ++lllllllllllIllIIlIIIlllllIIIIlIl;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.isAirBlock(lllllllllllIllIIlIIIlllllIIIIIII.north())) {
            ++lllllllllllIllIIlIIIlllllIIIIlIl;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.isAirBlock(lllllllllllIllIIlIIIlllllIIIIIII.south())) {
            ++lllllllllllIllIIlIIIlllllIIIIlIl;
        }
        if (lllllllllllIllIIlIIIlllllIIIIIlI.isAirBlock(lllllllllllIllIIlIIIlllllIIIIIII.down())) {
            ++lllllllllllIllIIlIIIlllllIIIIlIl;
        }
        if ((!this.insideRock && lllllllllllIllIIlIIIlllllIIIIllI == 4 && lllllllllllIllIIlIIIlllllIIIIlIl == 1) || lllllllllllIllIIlIIIlllllIIIIllI == 5) {
            final IBlockState lllllllllllIllIIlIIIlllllIIIIlII = this.block.getDefaultState();
            lllllllllllIllIIlIIIlllllIIIIIlI.setBlockState(lllllllllllIllIIlIIIlllllIIIIIII, lllllllllllIllIIlIIIlllllIIIIlII, 2);
            lllllllllllIllIIlIIIlllllIIIIIlI.immediateBlockTick(lllllllllllIllIIlIIIlllllIIIIIII, lllllllllllIllIIlIIIlllllIIIIlII, lllllllllllIllIIlIIIlllllIIIIIIl);
        }
        return true;
    }
}
