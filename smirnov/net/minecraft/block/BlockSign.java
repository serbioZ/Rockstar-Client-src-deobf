// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockSign extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB SIGN_AABB;
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIllIllIllIIIllllIll) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIllIllIllIIlIIIlIlI, final IBlockAccess lllllllllllllIllIllIllIIlIIIlIIl, final BlockPos lllllllllllllIllIllIllIIlIIIlIII) {
        return BlockSign.SIGN_AABB;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllIllIllIIIlllIIIl, final BlockPos lllllllllllllIllIllIllIIIlllIIII, final IBlockState lllllllllllllIllIllIllIIIllIllll) {
        return new ItemStack(Items.SIGN);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllIllIllIllIIIllllllI, final BlockPos lllllllllllllIllIllIllIIIlllllIl) {
        return true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllIllIllIIlIIIIIlI) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIllIllIllIIIllIlIIl, final BlockPos lllllllllllllIllIllIllIIIllIlIII, final IBlockState lllllllllllllIllIllIllIIIllIIlll, final EntityPlayer lllllllllllllIllIllIllIIIlIlllIl, final EnumHand lllllllllllllIllIllIllIIIllIIlIl, final EnumFacing lllllllllllllIllIllIllIIIllIIlII, final float lllllllllllllIllIllIllIIIllIIIll, final float lllllllllllllIllIllIllIIIllIIIlI, final float lllllllllllllIllIllIllIIIllIIIIl) {
        if (lllllllllllllIllIllIllIIIllIlIIl.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllIllIllIllIIIllIIIII = lllllllllllllIllIllIllIIIllIlIIl.getTileEntity(lllllllllllllIllIllIllIIIllIlIII);
        return lllllllllllllIllIllIllIIIllIIIII instanceof TileEntitySign && ((TileEntitySign)lllllllllllllIllIllIllIIIllIIIII).executeCommand(lllllllllllllIllIllIllIIIlIlllIl);
    }
    
    protected BlockSign() {
        super(Material.WOOD);
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIllIllIllIIlIIIIIII) {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllIllIllIIIlIlIIIl, final IBlockState lllllllllllllIllIllIllIIIlIlIIII, final BlockPos lllllllllllllIllIllIllIIIlIIllll, final EnumFacing lllllllllllllIllIllIllIIIlIIlllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIllIllIllIIIlllIlIl, final Random lllllllllllllIllIllIllIIIlllIlII, final int lllllllllllllIllIllIllIIIlllIIll) {
        return Items.SIGN;
    }
    
    static {
        SIGN_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
    }
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIllIllIllIIIllllIII, final int lllllllllllllIllIllIllIIIlllIlll) {
        return new TileEntitySign();
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIllIllIllIIlIIIIllI, final IBlockAccess lllllllllllllIllIllIllIIlIIIIlIl, final BlockPos lllllllllllllIllIllIllIIlIIIIlII) {
        return BlockSign.NULL_AABB;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIllIllIllIIIlIlIlII, final BlockPos lllllllllllllIllIllIllIIIlIlIllI) {
        return !this.hasInvalidNeighbor(lllllllllllllIllIllIllIIIlIlIlII, lllllllllllllIllIllIllIIIlIlIllI) && super.canPlaceBlockAt(lllllllllllllIllIllIllIIIlIlIlII, lllllllllllllIllIllIllIIIlIlIllI);
    }
}
