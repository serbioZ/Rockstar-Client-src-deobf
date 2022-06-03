// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.Vec3i;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;

public class WorldGeneratorBonusChest extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllIlllIIIlIlIlIIlIIIIlII, final Random llllllllllIlllIIIlIlIlIIlIIIIIll, BlockPos llllllllllIlllIIIlIlIlIIlIIIIIlI) {
        for (IBlockState llllllllllIlllIIIlIlIlIIlIIIllII = llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState((BlockPos)llllllllllIlllIIIlIlIlIIlIIIIIlI); (llllllllllIlllIIIlIlIlIIlIIIllII.getMaterial() == Material.AIR || llllllllllIlllIIIlIlIlIIlIIIllII.getMaterial() == Material.LEAVES) && ((Vec3i)llllllllllIlllIIIlIlIlIIlIIIIIlI).getY() > 1; llllllllllIlllIIIlIlIlIIlIIIIIlI = ((BlockPos)llllllllllIlllIIIlIlIlIIlIIIIIlI).down(), llllllllllIlllIIIlIlIlIIlIIIllII = llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState((BlockPos)llllllllllIlllIIIlIlIlIIlIIIIIlI)) {}
        if (((Vec3i)llllllllllIlllIIIlIlIlIIlIIIIIlI).getY() < 1) {
            return false;
        }
        llllllllllIlllIIIlIlIlIIlIIIIIlI = ((BlockPos)llllllllllIlllIIIlIlIlIIlIIIIIlI).up();
        for (int llllllllllIlllIIIlIlIlIIlIIIlIll = 0; llllllllllIlllIIIlIlIlIIlIIIlIll < 4; ++llllllllllIlllIIIlIlIlIIlIIIlIll) {
            final BlockPos llllllllllIlllIIIlIlIlIIlIIIlIlI = ((BlockPos)llllllllllIlllIIIlIlIlIIlIIIIIlI).add(llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(4) - llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(4), llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(3) - llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(3), llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(4) - llllllllllIlllIIIlIlIlIIlIIIIIll.nextInt(4));
            if (llllllllllIlllIIIlIlIlIIlIIIIlII.isAirBlock(llllllllllIlllIIIlIlIlIIlIIIlIlI) && llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState(llllllllllIlllIIIlIlIlIIlIIIlIlI.down()).isFullyOpaque()) {
                llllllllllIlllIIIlIlIlIIlIIIIlII.setBlockState(llllllllllIlllIIIlIlIlIIlIIIlIlI, Blocks.CHEST.getDefaultState(), 2);
                final TileEntity llllllllllIlllIIIlIlIlIIlIIIlIIl = llllllllllIlllIIIlIlIlIIlIIIIlII.getTileEntity(llllllllllIlllIIIlIlIlIIlIIIlIlI);
                if (llllllllllIlllIIIlIlIlIIlIIIlIIl instanceof TileEntityChest) {
                    ((TileEntityChest)llllllllllIlllIIIlIlIlIIlIIIlIIl).setLootTable(LootTableList.CHESTS_SPAWN_BONUS_CHEST, llllllllllIlllIIIlIlIlIIlIIIIIll.nextLong());
                }
                final BlockPos llllllllllIlllIIIlIlIlIIlIIIlIII = llllllllllIlllIIIlIlIlIIlIIIlIlI.east();
                final BlockPos llllllllllIlllIIIlIlIlIIlIIIIlll = llllllllllIlllIIIlIlIlIIlIIIlIlI.west();
                final BlockPos llllllllllIlllIIIlIlIlIIlIIIIllI = llllllllllIlllIIIlIlIlIIlIIIlIlI.north();
                final BlockPos llllllllllIlllIIIlIlIlIIlIIIIlIl = llllllllllIlllIIIlIlIlIIlIIIlIlI.south();
                if (llllllllllIlllIIIlIlIlIIlIIIIlII.isAirBlock(llllllllllIlllIIIlIlIlIIlIIIIlll) && llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState(llllllllllIlllIIIlIlIlIIlIIIIlll.down()).isFullyOpaque()) {
                    llllllllllIlllIIIlIlIlIIlIIIIlII.setBlockState(llllllllllIlllIIIlIlIlIIlIIIIlll, Blocks.TORCH.getDefaultState(), 2);
                }
                if (llllllllllIlllIIIlIlIlIIlIIIIlII.isAirBlock(llllllllllIlllIIIlIlIlIIlIIIlIII) && llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState(llllllllllIlllIIIlIlIlIIlIIIlIII.down()).isFullyOpaque()) {
                    llllllllllIlllIIIlIlIlIIlIIIIlII.setBlockState(llllllllllIlllIIIlIlIlIIlIIIlIII, Blocks.TORCH.getDefaultState(), 2);
                }
                if (llllllllllIlllIIIlIlIlIIlIIIIlII.isAirBlock(llllllllllIlllIIIlIlIlIIlIIIIllI) && llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState(llllllllllIlllIIIlIlIlIIlIIIIllI.down()).isFullyOpaque()) {
                    llllllllllIlllIIIlIlIlIIlIIIIlII.setBlockState(llllllllllIlllIIIlIlIlIIlIIIIllI, Blocks.TORCH.getDefaultState(), 2);
                }
                if (llllllllllIlllIIIlIlIlIIlIIIIlII.isAirBlock(llllllllllIlllIIIlIlIlIIlIIIIlIl) && llllllllllIlllIIIlIlIlIIlIIIIlII.getBlockState(llllllllllIlllIIIlIlIlIIlIIIIlIl.down()).isFullyOpaque()) {
                    llllllllllIlllIIIlIlIlIIlIIIIlII.setBlockState(llllllllllIlllIIIlIlIlIIlIIIIlIl, Blocks.TORCH.getDefaultState(), 2);
                }
                return true;
            }
        }
        return false;
    }
}
