// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.IBlockProperties;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;

public class BlockChorusPlant extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool DOWN;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool UP;
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllIlllIlIlIlllIIIlIllI, final IBlockAccess llllllllllllIlllIlIlIlllIIIlIlIl, final BlockPos llllllllllllIlllIlIlIlllIIIllllI) {
        final Block llllllllllllIlllIlIlIlllIIIlllIl = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.down()).getBlock();
        final Block llllllllllllIlllIlIlIlllIIIlllII = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.up()).getBlock();
        final Block llllllllllllIlllIlIlIlllIIIllIll = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.north()).getBlock();
        final Block llllllllllllIlllIlIlIlllIIIllIlI = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.east()).getBlock();
        final Block llllllllllllIlllIlIlIlllIIIllIIl = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.south()).getBlock();
        final Block llllllllllllIlllIlIlIlllIIIllIII = llllllllllllIlllIlIlIlllIIIlIlIl.getBlockState(llllllllllllIlllIlIlIlllIIIllllI.west()).getBlock();
        return llllllllllllIlllIlIlIlllIIIlIllI.withProperty((IProperty<Comparable>)BlockChorusPlant.DOWN, llllllllllllIlllIlIlIlllIIIlllIl == this || llllllllllllIlllIlIlIlllIIIlllIl == Blocks.CHORUS_FLOWER || llllllllllllIlllIlIlIlllIIIlllIl == Blocks.END_STONE).withProperty((IProperty<Comparable>)BlockChorusPlant.UP, llllllllllllIlllIlIlIlllIIIlllII == this || llllllllllllIlllIlIlIlllIIIlllII == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.NORTH, llllllllllllIlllIlIlIlllIIIllIll == this || llllllllllllIlllIlIlIlllIIIllIll == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.EAST, llllllllllllIlllIlIlIlllIIIllIlI == this || llllllllllllIlllIlIlIlllIIIllIlI == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.SOUTH, llllllllllllIlllIlIlIlllIIIllIIl == this || llllllllllllIlllIlIlIlllIIIllIIl == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.WEST, llllllllllllIlllIlIlIlllIIIllIII == this || llllllllllllIlllIlIlIlllIIIllIII == Blocks.CHORUS_FLOWER);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlllIlIlIllIlIllllII) {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlllIlIlIllIllIIIllI, final Random llllllllllllIlllIlIlIllIllIIIlIl, final int llllllllllllIlllIlIlIllIllIIIlII) {
        return Items.CHORUS_FRUIT;
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        UP = PropertyBool.create("up");
        DOWN = PropertyBool.create("down");
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIlllIlIlIllIllIIIIII) {
        return llllllllllllIlllIlIlIllIllIIIIII.nextInt(2);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlllIlIlIllIllIlIIll) {
        return 0;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlllIlIlIllIlIllIlll, final BlockPos llllllllllllIlllIlIlIllIlIllIIll) {
        return super.canPlaceBlockAt(llllllllllllIlllIlIlIllIlIllIlll, llllllllllllIlllIlIlIllIlIllIIll) && this.canSurviveAt(llllllllllllIlllIlIlIllIlIllIlll, llllllllllllIlllIlIlIllIlIllIIll);
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState llllllllllllIlllIlIlIllIllIlllII, final World llllllllllllIlllIlIlIllIlllIIlII, final BlockPos llllllllllllIlllIlIlIllIlllIIIll, final AxisAlignedBB llllllllllllIlllIlIlIllIllIllIIl, final List<AxisAlignedBB> llllllllllllIlllIlIlIllIlllIIIIl, @Nullable final Entity llllllllllllIlllIlIlIllIlllIIIII, final boolean llllllllllllIlllIlIlIllIllIlllll) {
        if (!llllllllllllIlllIlIlIllIllIlllll) {
            llllllllllllIlllIlIlIllIllIlllII = ((IBlockProperties)llllllllllllIlllIlIlIllIllIlllII).getActualState(llllllllllllIlllIlIlIllIlllIIlII, llllllllllllIlllIlIlIllIlllIIIll);
        }
        final float llllllllllllIlllIlIlIllIllIllllI = 0.1875f;
        final float llllllllllllIlllIlIlIllIllIlllIl = 0.8125f;
        Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.1875, 0.1875, 0.1875, 0.8125, 0.8125, 0.8125));
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.WEST)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.0, 0.1875, 0.1875, 0.1875, 0.8125, 0.8125));
        }
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.EAST)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.8125, 0.1875, 0.1875, 1.0, 0.8125, 0.8125));
        }
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.UP)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.1875, 0.8125, 0.1875, 0.8125, 1.0, 0.8125));
        }
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.DOWN)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.1875, 0.8125));
        }
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.NORTH)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.1875, 0.1875, 0.0, 0.8125, 0.8125, 0.1875));
        }
        if (((IBlockState)llllllllllllIlllIlIlIllIllIlllII).getValue((IProperty<Boolean>)BlockChorusPlant.SOUTH)) {
            Block.addCollisionBoxToList(llllllllllllIlllIlIlIllIlllIIIll, llllllllllllIlllIlIlIllIllIllIIl, llllllllllllIlllIlIlIllIlllIIIIl, new AxisAlignedBB(0.1875, 0.1875, 0.8125, 0.8125, 0.8125, 1.0));
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlllIlIlIllIlIlllllI) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlllIlIlIllIlIlIlllI, final World llllllllllllIlllIlIlIllIlIlIllIl, final BlockPos llllllllllllIlllIlIlIllIlIlIIlll, final Block llllllllllllIlllIlIlIllIlIlIlIll, final BlockPos llllllllllllIlllIlIlIllIlIlIlIlI) {
        if (!this.canSurviveAt(llllllllllllIlllIlIlIllIlIlIllIl, llllllllllllIlllIlIlIllIlIlIIlll)) {
            llllllllllllIlllIlIlIllIlIlIllIl.scheduleUpdate(llllllllllllIlllIlIlIllIlIlIIlll, this, 1);
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllIlllIlIlIllIllIIlIIl, final BlockPos llllllllllllIlllIlIlIllIllIIllIl, final IBlockState llllllllllllIlllIlIlIllIllIIllII, final Random llllllllllllIlllIlIlIllIllIIlIll) {
        if (!this.canSurviveAt(llllllllllllIlllIlIlIllIllIIlIIl, llllllllllllIlllIlIlIllIllIIllIl)) {
            llllllllllllIlllIlIlIllIllIIlIIl.destroyBlock(llllllllllllIlllIlIlIllIllIIllIl, true);
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlllIlIlIllIIlllIIII, final IBlockState llllllllllllIlllIlIlIllIIllIllll, final BlockPos llllllllllllIlllIlIlIllIIllIlllI, final EnumFacing llllllllllllIlllIlIlIllIIllIllIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIlllIlIlIllIlIIIIIIl, final IBlockAccess llllllllllllIlllIlIlIllIlIIIIIII, final BlockPos llllllllllllIlllIlIlIllIIlllllll, final EnumFacing llllllllllllIlllIlIlIllIIllllllI) {
        final Block llllllllllllIlllIlIlIllIIlllllIl = llllllllllllIlllIlIlIllIlIIIIIII.getBlockState(llllllllllllIlllIlIlIllIIlllllll.offset(llllllllllllIlllIlIlIllIIllllllI)).getBlock();
        return llllllllllllIlllIlIlIllIIlllllIl != this && llllllllllllIlllIlIlIllIIlllllIl != Blocks.CHORUS_FLOWER && (llllllllllllIlllIlIlIllIIllllllI != EnumFacing.DOWN || llllllllllllIlllIlIlIllIIlllllIl != Blocks.END_STONE);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState llllllllllllIlllIlIlIllIlllllIII, final IBlockAccess llllllllllllIlllIlIlIllIllllIlll, final BlockPos llllllllllllIlllIlIlIlllIIIIIIII) {
        llllllllllllIlllIlIlIllIlllllIII = (double)((IBlockProperties)llllllllllllIlllIlIlIllIlllllIII).getActualState(llllllllllllIlllIlIlIllIllllIlll, llllllllllllIlllIlIlIlllIIIIIIII);
        final float llllllllllllIlllIlIlIllIllllllll = 0.1875f;
        final float llllllllllllIlllIlIlIllIlllllllI = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.WEST) ? 0.0f : 0.1875f;
        final float llllllllllllIlllIlIlIllIllllllIl = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.DOWN) ? 0.0f : 0.1875f;
        final float llllllllllllIlllIlIlIllIllllllII = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.NORTH) ? 0.0f : 0.1875f;
        final float llllllllllllIlllIlIlIllIlllllIll = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.EAST) ? 1.0f : 0.8125f;
        final float llllllllllllIlllIlIlIllIlllllIlI = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.UP) ? 1.0f : 0.8125f;
        final float llllllllllllIlllIlIlIllIlllllIIl = ((IBlockState)llllllllllllIlllIlIlIllIlllllIII).getValue((IProperty<Boolean>)BlockChorusPlant.SOUTH) ? 1.0f : 0.8125f;
        return new AxisAlignedBB(llllllllllllIlllIlIlIllIlllllllI, llllllllllllIlllIlIlIllIllllllIl, llllllllllllIlllIlIlIllIllllllII, llllllllllllIlllIlIlIllIlllllIll, llllllllllllIlllIlIlIllIlllllIlI, llllllllllllIlllIlIlIllIlllllIIl);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllIlllIlIlIllIIlllIIll, final BlockPos llllllllllllIlllIlIlIllIIlllIIlI) {
        return false;
    }
    
    public boolean canSurviveAt(final World llllllllllllIlllIlIlIllIlIIlIIIl, final BlockPos llllllllllllIlllIlIlIllIlIIlIIII) {
        final boolean llllllllllllIlllIlIlIllIlIIllIIl = llllllllllllIlllIlIlIllIlIIlIIIl.isAirBlock(llllllllllllIlllIlIlIllIlIIlIIII.up());
        final boolean llllllllllllIlllIlIlIllIlIIllIII = llllllllllllIlllIlIlIllIlIIlIIIl.isAirBlock(llllllllllllIlllIlIlIllIlIIlIIII.down());
        for (final EnumFacing llllllllllllIlllIlIlIllIlIIlIlll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllIlllIlIlIllIlIIlIllI = llllllllllllIlllIlIlIllIlIIlIIII.offset(llllllllllllIlllIlIlIllIlIIlIlll);
            final Block llllllllllllIlllIlIlIllIlIIlIlIl = llllllllllllIlllIlIlIllIlIIlIIIl.getBlockState(llllllllllllIlllIlIlIllIlIIlIllI).getBlock();
            if (llllllllllllIlllIlIlIllIlIIlIlIl == this) {
                if (!llllllllllllIlllIlIlIllIlIIllIIl && !llllllllllllIlllIlIlIllIlIIllIII) {
                    return false;
                }
                final Block llllllllllllIlllIlIlIllIlIIlIlII = llllllllllllIlllIlIlIllIlIIlIIIl.getBlockState(llllllllllllIlllIlIlIllIlIIlIllI.down()).getBlock();
                if (llllllllllllIlllIlIlIllIlIIlIlII == this || llllllllllllIlllIlIlIllIlIIlIlII == Blocks.END_STONE) {
                    return true;
                }
                continue;
            }
        }
        final Block llllllllllllIlllIlIlIllIlIIlIIll = llllllllllllIlllIlIlIllIlIIlIIIl.getBlockState(llllllllllllIlllIlIlIllIlIIlIIII.down()).getBlock();
        return llllllllllllIlllIlIlIllIlIIlIIll == this || llllllllllllIlllIlIlIllIlIIlIIll == Blocks.END_STONE;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChorusPlant.NORTH, BlockChorusPlant.EAST, BlockChorusPlant.SOUTH, BlockChorusPlant.WEST, BlockChorusPlant.UP, BlockChorusPlant.DOWN });
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected BlockChorusPlant() {
        super(Material.PLANTS, MapColor.PURPLE);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChorusPlant.NORTH, false).withProperty((IProperty<Comparable>)BlockChorusPlant.EAST, false).withProperty((IProperty<Comparable>)BlockChorusPlant.SOUTH, false).withProperty((IProperty<Comparable>)BlockChorusPlant.WEST, false).withProperty((IProperty<Comparable>)BlockChorusPlant.UP, false).withProperty((IProperty<Comparable>)BlockChorusPlant.DOWN, false));
    }
}
