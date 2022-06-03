// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.world;

import java.util.List;
import net.minecraft.block.Block;
import java.util.ArrayList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockDirt;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.utils.Helper;

public class BlockHelper implements Helper
{
    public static boolean IsValidBlockPos(final BlockPos lllllllllllIIllIIIIIIIIIIlIIlIlI) {
        final IBlockState lllllllllllIIllIIIIIIIIIIlIIlIIl = BlockHelper.mc.world.getBlockState(lllllllllllIIllIIIIIIIIIIlIIlIlI);
        return (lllllllllllIIllIIIIIIIIIIlIIlIIl.getBlock() instanceof BlockDirt || (lllllllllllIIllIIIIIIIIIIlIIlIIl.getBlock() instanceof BlockGrass && !(lllllllllllIIllIIIIIIIIIIlIIlIIl.getBlock() instanceof BlockFarmland))) && BlockHelper.mc.world.getBlockState(lllllllllllIIllIIIIIIIIIIlIIlIlI.up()).getBlock() == Blocks.AIR;
    }
    
    public static ArrayList<BlockPos> getBlocks(final int lllllllllllIIllIIIIIIIIIIIIlIlII, final int lllllllllllIIllIIIIIIIIIIIIlIIll, final int lllllllllllIIllIIIIIIIIIIIIIllIl) {
        final BlockPos lllllllllllIIllIIIIIIIIIIIIlIIIl = new BlockPos(BlockHelper.mc.player.posX - lllllllllllIIllIIIIIIIIIIIIlIlII, BlockHelper.mc.player.posY - lllllllllllIIllIIIIIIIIIIIIlIIll, BlockHelper.mc.player.posZ - lllllllllllIIllIIIIIIIIIIIIIllIl);
        final BlockPos lllllllllllIIllIIIIIIIIIIIIlIIII = new BlockPos(BlockHelper.mc.player.posX + lllllllllllIIllIIIIIIIIIIIIlIlII, BlockHelper.mc.player.posY + lllllllllllIIllIIIIIIIIIIIIlIIll, BlockHelper.mc.player.posZ + lllllllllllIIllIIIIIIIIIIIIIllIl);
        return getAllInBox(lllllllllllIIllIIIIIIIIIIIIlIIIl, lllllllllllIIllIIIIIIIIIIIIlIIII);
    }
    
    public static ArrayList<BlockPos> getAllInBox(final BlockPos lllllllllllIIllIIIIIIIIIIIIIIIlI, final BlockPos lllllllllllIIlIllllllllllllllIIl) {
        final ArrayList<BlockPos> lllllllllllIIllIIIIIIIIIIIIIIIII = new ArrayList<BlockPos>();
        final BlockPos lllllllllllIIlIlllllllllllllllll = new BlockPos(Math.min(lllllllllllIIllIIIIIIIIIIIIIIIlI.getX(), lllllllllllIIlIllllllllllllllIIl.getX()), Math.min(lllllllllllIIllIIIIIIIIIIIIIIIlI.getY(), lllllllllllIIlIllllllllllllllIIl.getY()), Math.min(lllllllllllIIllIIIIIIIIIIIIIIIlI.getZ(), lllllllllllIIlIllllllllllllllIIl.getZ()));
        final BlockPos lllllllllllIIlIllllllllllllllllI = new BlockPos(Math.max(lllllllllllIIllIIIIIIIIIIIIIIIlI.getX(), lllllllllllIIlIllllllllllllllIIl.getX()), Math.max(lllllllllllIIllIIIIIIIIIIIIIIIlI.getY(), lllllllllllIIlIllllllllllllllIIl.getY()), Math.max(lllllllllllIIllIIIIIIIIIIIIIIIlI.getZ(), lllllllllllIIlIllllllllllllllIIl.getZ()));
        for (int lllllllllllIIlIlllllllllllllllIl = lllllllllllIIlIlllllllllllllllll.getX(); lllllllllllIIlIlllllllllllllllIl <= lllllllllllIIlIllllllllllllllllI.getX(); ++lllllllllllIIlIlllllllllllllllIl) {
            for (int lllllllllllIIlIlllllllllllllllII = lllllllllllIIlIlllllllllllllllll.getY(); lllllllllllIIlIlllllllllllllllII <= lllllllllllIIlIllllllllllllllllI.getY(); ++lllllllllllIIlIlllllllllllllllII) {
                for (int lllllllllllIIlIllllllllllllllIll = lllllllllllIIlIlllllllllllllllll.getZ(); lllllllllllIIlIllllllllllllllIll <= lllllllllllIIlIllllllllllllllllI.getZ(); ++lllllllllllIIlIllllllllllllllIll) {
                    lllllllllllIIllIIIIIIIIIIIIIIIII.add(new BlockPos(lllllllllllIIlIlllllllllllllllIl, lllllllllllIIlIlllllllllllllllII, lllllllllllIIlIllllllllllllllIll));
                }
            }
        }
        return lllllllllllIIllIIIIIIIIIIIIIIIII;
    }
    
    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(BlockHelper.mc.player.posX), Math.floor(BlockHelper.mc.player.posY), Math.floor(BlockHelper.mc.player.posZ));
    }
    
    public static Block getBlock(final BlockPos lllllllllllIIllIIIIIIIIIIlIIllIl) {
        return BlockHelper.mc.world.getBlockState(lllllllllllIIllIIIIIIIIIIlIIllIl).getBlock();
    }
    
    public static List<BlockPos> getSphere(final BlockPos lllllllllllIIllIIIIIIIIIIIllIlll, final float lllllllllllIIllIIIIIIIIIIIlIIlll, final int lllllllllllIIllIIIIIIIIIIIlIIllI, final boolean lllllllllllIIllIIIIIIIIIIIlIIlIl, final boolean lllllllllllIIllIIIIIIIIIIIlIIlII) {
        final ArrayList<BlockPos> lllllllllllIIllIIIIIIIIIIIllIIlI = new ArrayList<BlockPos>();
        final int lllllllllllIIllIIIIIIIIIIIllIIIl = lllllllllllIIllIIIIIIIIIIIllIlll.getX();
        final int lllllllllllIIllIIIIIIIIIIIllIIII = lllllllllllIIllIIIIIIIIIIIllIlll.getY();
        final int lllllllllllIIllIIIIIIIIIIIlIllll = lllllllllllIIllIIIIIIIIIIIllIlll.getZ();
        for (float lllllllllllIIllIIIIIIIIIIIlIlllI = lllllllllllIIllIIIIIIIIIIIllIIIl - lllllllllllIIllIIIIIIIIIIIlIIlll; lllllllllllIIllIIIIIIIIIIIlIlllI <= lllllllllllIIllIIIIIIIIIIIllIIIl + lllllllllllIIllIIIIIIIIIIIlIIlll; ++lllllllllllIIllIIIIIIIIIIIlIlllI) {
            for (float lllllllllllIIllIIIIIIIIIIIlIllIl = lllllllllllIIllIIIIIIIIIIIlIllll - lllllllllllIIllIIIIIIIIIIIlIIlll; lllllllllllIIllIIIIIIIIIIIlIllIl <= lllllllllllIIllIIIIIIIIIIIlIllll + lllllllllllIIllIIIIIIIIIIIlIIlll; ++lllllllllllIIllIIIIIIIIIIIlIllIl) {
                float lllllllllllIIllIIIIIIIIIIIlIllII = lllllllllllIIllIIIIIIIIIIIlIIlII ? (lllllllllllIIllIIIIIIIIIIIllIIII - lllllllllllIIllIIIIIIIIIIIlIIlll) : ((float)lllllllllllIIllIIIIIIIIIIIllIIII);
                while (true) {
                    final float lllllllllllIIllIIIIIIIIIIIlIlIll = lllllllllllIIllIIIIIIIIIIIlIIlII ? (lllllllllllIIllIIIIIIIIIIIllIIII + lllllllllllIIllIIIIIIIIIIIlIIlll) : ((float)(lllllllllllIIllIIIIIIIIIIIllIIII + lllllllllllIIllIIIIIIIIIIIlIIllI));
                    if (lllllllllllIIllIIIIIIIIIIIlIllII >= lllllllllllIIllIIIIIIIIIIIlIlIll) {
                        break;
                    }
                    final float lllllllllllIIllIIIIIIIIIIIlIlIlI = (lllllllllllIIllIIIIIIIIIIIllIIIl - lllllllllllIIllIIIIIIIIIIIlIlllI) * (lllllllllllIIllIIIIIIIIIIIllIIIl - lllllllllllIIllIIIIIIIIIIIlIlllI) + (lllllllllllIIllIIIIIIIIIIIlIllll - lllllllllllIIllIIIIIIIIIIIlIllIl) * (lllllllllllIIllIIIIIIIIIIIlIllll - lllllllllllIIllIIIIIIIIIIIlIllIl) + (lllllllllllIIllIIIIIIIIIIIlIIlII ? ((lllllllllllIIllIIIIIIIIIIIllIIII - lllllllllllIIllIIIIIIIIIIIlIllII) * (lllllllllllIIllIIIIIIIIIIIllIIII - lllllllllllIIllIIIIIIIIIIIlIllII)) : 0.0f);
                    if (lllllllllllIIllIIIIIIIIIIIlIlIlI < lllllllllllIIllIIIIIIIIIIIlIIlll * lllllllllllIIllIIIIIIIIIIIlIIlll && (!lllllllllllIIllIIIIIIIIIIIlIIlIl || lllllllllllIIllIIIIIIIIIIIlIlIlI >= lllllllllllIIllIIIIIIIIIIIlIIlll - 1.0f * (lllllllllllIIllIIIIIIIIIIIlIIlll - 1.0f))) {
                        final BlockPos lllllllllllIIllIIIIIIIIIIIlIlIIl = new BlockPos(lllllllllllIIllIIIIIIIIIIIlIlllI, lllllllllllIIllIIIIIIIIIIIlIllII, lllllllllllIIllIIIIIIIIIIIlIllIl);
                        lllllllllllIIllIIIIIIIIIIIllIIlI.add(lllllllllllIIllIIIIIIIIIIIlIlIIl);
                    }
                    ++lllllllllllIIllIIIIIIIIIIIlIllII;
                }
            }
        }
        return lllllllllllIIllIIIIIIIIIIIllIIlI;
    }
}
