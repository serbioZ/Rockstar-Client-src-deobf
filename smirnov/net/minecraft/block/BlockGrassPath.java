// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockGrassPath extends Block
{
    protected static final /* synthetic */ AxisAlignedBB GRASS_PATH_AABB;
    
    static {
        GRASS_PATH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIlIllllllIIIIlIIllI, final IBlockAccess lllllllllllIlIlIllllllIIIIlIIlIl, final BlockPos lllllllllllIlIlIllllllIIIIlIIlII) {
        return BlockGrassPath.GRASS_PATH_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIlIllllllIIIIlIIIlI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIlIlllllIllllllllIl, final IBlockState lllllllllllIlIlIlllllIllllllllII, final BlockPos lllllllllllIlIlIlllllIlllllllIll, final EnumFacing lllllllllllIlIlIlllllIlllllllIlI) {
        return (lllllllllllIlIlIlllllIlllllllIlI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIlIllllllIIIIlIIIII) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIlIllllllIIIIIlIlIl, final BlockPos lllllllllllIlIlIllllllIIIIIlIlII, final IBlockState lllllllllllIlIlIllllllIIIIIlIIll) {
        return new ItemStack(this);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockGrassPath.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char lllllllllllIlIlIlllllIllllllIlll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlIlIlllllIllllllIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockGrassPath.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlIlIlllllIllllllIlll;
    }
    
    protected BlockGrassPath() {
        super(Material.GROUND);
        this.setLightOpacity(255);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlIlIllllllIIIlIIIlll, final IBlockAccess lllllllllllIlIlIllllllIIIIllllll, final BlockPos lllllllllllIlIlIllllllIIIlIIIlIl, final EnumFacing lllllllllllIlIlIllllllIIIlIIIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlIlIllllllIIIlIIIlII.ordinal()]) {
            case 2: {
                return true;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                final IBlockState lllllllllllIlIlIllllllIIIlIIIIll = lllllllllllIlIlIllllllIIIIllllll.getBlockState(lllllllllllIlIlIllllllIIIlIIIlIl.offset(lllllllllllIlIlIllllllIIIlIIIlII));
                final Block lllllllllllIlIlIllllllIIIlIIIIlI = lllllllllllIlIlIllllllIIIlIIIIll.getBlock();
                return !lllllllllllIlIlIllllllIIIlIIIIll.isOpaqueCube() && lllllllllllIlIlIllllllIIIlIIIIlI != Blocks.FARMLAND && lllllllllllIlIlIllllllIIIlIIIIlI != Blocks.GRASS_PATH;
            }
            default: {
                return super.shouldSideBeRendered(lllllllllllIlIlIllllllIIIlIIIlll, lllllllllllIlIlIllllllIIIIllllll, lllllllllllIlIlIllllllIIIlIIIlIl, lllllllllllIlIlIllllllIIIlIIIlII);
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlIlIllllllIIIIIlllII, final Random lllllllllllIlIlIllllllIIIIIllIIl, final int lllllllllllIlIlIllllllIIIIIllIlI) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllIlIlIllllllIIIIIllIIl, lllllllllllIlIlIllllllIIIIIllIlI);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlIlIllllllIIIIllIIIl, final BlockPos lllllllllllIlIlIllllllIIIIllIIII, final IBlockState lllllllllllIlIlIllllllIIIIlIllll) {
        super.onBlockAdded(lllllllllllIlIlIllllllIIIIllIIIl, lllllllllllIlIlIllllllIIIIllIIII, lllllllllllIlIlIllllllIIIIlIllll);
        this.func_190971_b(lllllllllllIlIlIllllllIIIIllIIIl, lllllllllllIlIlIllllllIIIIllIIII);
    }
    
    private void func_190971_b(final World lllllllllllIlIlIllllllIIIIlIlIll, final BlockPos lllllllllllIlIlIllllllIIIIlIlIII) {
        if (lllllllllllIlIlIllllllIIIIlIlIll.getBlockState(lllllllllllIlIlIllllllIIIIlIlIII.up()).getMaterial().isSolid()) {
            BlockFarmland.func_190970_b(lllllllllllIlIlIllllllIIIIlIlIll, lllllllllllIlIlIllllllIIIIlIlIII);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlIlIllllllIIIIIIlIlI, final World lllllllllllIlIlIllllllIIIIIIlIIl, final BlockPos lllllllllllIlIlIllllllIIIIIIIIlI, final Block lllllllllllIlIlIllllllIIIIIIIlll, final BlockPos lllllllllllIlIlIllllllIIIIIIIllI) {
        super.neighborChanged(lllllllllllIlIlIllllllIIIIIIlIlI, lllllllllllIlIlIllllllIIIIIIlIIl, lllllllllllIlIlIllllllIIIIIIIIlI, lllllllllllIlIlIllllllIIIIIIIlll, lllllllllllIlIlIllllllIIIIIIIllI);
        this.func_190971_b(lllllllllllIlIlIllllllIIIIIIlIIl, lllllllllllIlIlIllllllIIIIIIIIlI);
    }
}
