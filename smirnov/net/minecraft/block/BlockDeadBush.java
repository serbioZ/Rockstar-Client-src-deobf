// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.stats.StatList;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.material.MapColor;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockDeadBush extends BlockBush
{
    protected static final /* synthetic */ AxisAlignedBB DEAD_BUSH_AABB;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIlIlllIllIIIIlllII, final IBlockAccess lllllllllllIIlIlIlllIllIIIIllIll, final BlockPos lllllllllllIIlIlIlllIllIIIIllIlI) {
        return BlockDeadBush.DEAD_BUSH_AABB;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIlIlIlllIllIIIIIllII) {
        return lllllllllllIIlIlIlllIllIIIIIllII.nextInt(3);
    }
    
    protected BlockDeadBush() {
        super(Material.VINE);
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllIIlIlIlllIllIIIIlIIlI) {
        return lllllllllllIIlIlIlllIllIIIIlIIlI.getBlock() == Blocks.SAND || lllllllllllIIlIlIlllIllIIIIlIIlI.getBlock() == Blocks.HARDENED_CLAY || lllllllllllIIlIlIlllIllIIIIlIIlI.getBlock() == Blocks.STAINED_HARDENED_CLAY || lllllllllllIIlIlIlllIllIIIIlIIlI.getBlock() == Blocks.DIRT;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlIlIlllIllIIIIIlIIl, final Random lllllllllllIIlIlIlllIllIIIIIlIII, final int lllllllllllIIlIlIlllIllIIIIIIlll) {
        return Items.STICK;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIIlIlIlllIllIIIIllIII, final IBlockAccess lllllllllllIIlIlIlllIllIIIIlIlll, final BlockPos lllllllllllIIlIlIlllIllIIIIlIllI) {
        return MapColor.WOOD;
    }
    
    static {
        DEAD_BUSH_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIIlIlIlllIlIllllllllI, final EntityPlayer lllllllllllIIlIlIlllIlIlllllllIl, final BlockPos lllllllllllIIlIlIlllIlIlllllllII, final IBlockState lllllllllllIIlIlIlllIlIlllllIlII, @Nullable final TileEntity lllllllllllIIlIlIlllIlIlllllIIll, final ItemStack lllllllllllIIlIlIlllIlIlllllIIlI) {
        if (!lllllllllllIIlIlIlllIlIllllllllI.isRemote && lllllllllllIIlIlIlllIlIlllllIIlI.getItem() == Items.SHEARS) {
            lllllllllllIIlIlIlllIlIlllllllIl.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lllllllllllIIlIlIlllIlIllllllllI, lllllllllllIIlIlIlllIlIlllllllII, new ItemStack(Blocks.DEADBUSH, 1, 0));
        }
        else {
            super.harvestBlock(lllllllllllIIlIlIlllIlIllllllllI, lllllllllllIIlIlIlllIlIlllllllIl, lllllllllllIIlIlIlllIlIlllllllII, lllllllllllIIlIlIlllIlIlllllIlII, lllllllllllIIlIlIlllIlIlllllIIll, lllllllllllIIlIlIlllIlIlllllIIlI);
        }
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllIIlIlIlllIllIIIIlIIII, final BlockPos lllllllllllIIlIlIlllIllIIIIIllll) {
        return true;
    }
}
