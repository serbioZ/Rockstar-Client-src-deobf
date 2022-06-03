// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockReed extends Block
{
    protected static final /* synthetic */ AxisAlignedBB REED_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlIIIIlIIIllllIIIlII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlIIIIlIIIllllIIIIlI) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockReed.AGE });
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlIIIIlIIIllllllIlll, final BlockPos llllllllllllIlIIIIlIIIllllllllIl) {
        final Block llllllllllllIlIIIIlIIIllllllllII = llllllllllllIlIIIIlIIIllllllIlll.getBlockState(llllllllllllIlIIIIlIIIllllllllIl.down()).getBlock();
        if (llllllllllllIlIIIIlIIIllllllllII == this) {
            return true;
        }
        if (llllllllllllIlIIIIlIIIllllllllII != Blocks.GRASS && llllllllllllIlIIIIlIIIllllllllII != Blocks.DIRT && llllllllllllIlIIIIlIIIllllllllII != Blocks.SAND) {
            return false;
        }
        final BlockPos llllllllllllIlIIIIlIIIlllllllIll = llllllllllllIlIIIIlIIIllllllllIl.down();
        for (final EnumFacing llllllllllllIlIIIIlIIIlllllllIlI : EnumFacing.Plane.HORIZONTAL) {
            final IBlockState llllllllllllIlIIIIlIIIlllllllIIl = llllllllllllIlIIIIlIIIllllllIlll.getBlockState(llllllllllllIlIIIIlIIIlllllllIll.offset(llllllllllllIlIIIIlIIIlllllllIlI));
            if (llllllllllllIlIIIIlIIIlllllllIIl.getMaterial() == Material.WATER || llllllllllllIlIIIIlIIIlllllllIIl.getBlock() == Blocks.FROSTED_ICE) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canBlockStay(final World llllllllllllIlIIIIlIIIllllIlIIlI, final BlockPos llllllllllllIlIIIIlIIIllllIIlllI) {
        return this.canPlaceBlockAt(llllllllllllIlIIIIlIIIllllIlIIlI, llllllllllllIlIIIIlIIIllllIIlllI);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlIIIIlIIIlllIlIlllI, final IBlockState llllllllllllIlIIIIlIIIlllIlIllIl, final BlockPos llllllllllllIlIIIIlIIIlllIlIllII, final EnumFacing llllllllllllIlIIIIlIIIlllIlIlIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlIIIIlIIIllllIIIIII, final BlockPos llllllllllllIlIIIIlIIIlllIllllll, final IBlockState llllllllllllIlIIIIlIIIlllIlllllI) {
        return new ItemStack(Items.REEDS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIIIIlIIIlllIllIlII) {
        return llllllllllllIlIIIIlIIIlllIllIlII.getValue((IProperty<Integer>)BlockReed.AGE);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlIIIIlIIIllllIIlIII, final Random llllllllllllIlIIIIlIIIllllIIIlll, final int llllllllllllIlIIIIlIIIllllIIIllI) {
        return Items.REEDS;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIlIIIIlIIIllllIIllII, final IBlockAccess llllllllllllIlIIIIlIIIllllIIlIll, final BlockPos llllllllllllIlIIIIlIIIllllIIlIlI) {
        return BlockReed.NULL_AABB;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIIIIlIIIlllIllIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockReed.AGE, llllllllllllIlIIIIlIIIlllIllIlll);
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        REED_AABB = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 1.0, 0.875);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlIIIIlIIIlllllIIlIl, final World llllllllllllIlIIIIlIIIlllllIlIlI, final BlockPos llllllllllllIlIIIIlIIIlllllIlIIl, final Block llllllllllllIlIIIIlIIIlllllIlIII, final BlockPos llllllllllllIlIIIIlIIIlllllIIlll) {
        this.checkForDrop(llllllllllllIlIIIIlIIIlllllIlIlI, llllllllllllIlIIIIlIIIlllllIlIIl, llllllllllllIlIIIIlIIIlllllIIlIl);
    }
    
    protected final boolean checkForDrop(final World llllllllllllIlIIIIlIIIllllIlllIl, final BlockPos llllllllllllIlIIIIlIIIllllIlllII, final IBlockState llllllllllllIlIIIIlIIIllllIlIlll) {
        if (this.canBlockStay(llllllllllllIlIIIIlIIIllllIlllIl, llllllllllllIlIIIIlIIIllllIlllII)) {
            return true;
        }
        this.dropBlockAsItem(llllllllllllIlIIIIlIIIllllIlllIl, llllllllllllIlIIIIlIIIllllIlllII, llllllllllllIlIIIIlIIIllllIlIlll, 0);
        llllllllllllIlIIIIlIIIllllIlllIl.setBlockToAir(llllllllllllIlIIIIlIIIllllIlllII);
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIlIIIIlIIlIIIIIlllIl, final IBlockAccess llllllllllllIlIIIIlIIlIIIIIlllII, final BlockPos llllllllllllIlIIIIlIIlIIIIIllIll) {
        return BlockReed.REED_AABB;
    }
    
    @Override
    public void updateTick(final World llllllllllllIlIIIIlIIlIIIIIlIIll, final BlockPos llllllllllllIlIIIIlIIlIIIIIIlIll, final IBlockState llllllllllllIlIIIIlIIlIIIIIIlIlI, final Random llllllllllllIlIIIIlIIlIIIIIlIIII) {
        if ((llllllllllllIlIIIIlIIlIIIIIlIIll.getBlockState(llllllllllllIlIIIIlIIlIIIIIIlIll.down()).getBlock() == Blocks.REEDS || this.checkForDrop(llllllllllllIlIIIIlIIlIIIIIlIIll, llllllllllllIlIIIIlIIlIIIIIIlIll, llllllllllllIlIIIIlIIlIIIIIIlIlI)) && llllllllllllIlIIIIlIIlIIIIIlIIll.isAirBlock(llllllllllllIlIIIIlIIlIIIIIIlIll.up())) {
            int llllllllllllIlIIIIlIIlIIIIIIllll;
            for (llllllllllllIlIIIIlIIlIIIIIIllll = 1; llllllllllllIlIIIIlIIlIIIIIlIIll.getBlockState(llllllllllllIlIIIIlIIlIIIIIIlIll.down(llllllllllllIlIIIIlIIlIIIIIIllll)).getBlock() == this; ++llllllllllllIlIIIIlIIlIIIIIIllll) {}
            if (llllllllllllIlIIIIlIIlIIIIIIllll < 3) {
                final int llllllllllllIlIIIIlIIlIIIIIIlllI = llllllllllllIlIIIIlIIlIIIIIIlIlI.getValue((IProperty<Integer>)BlockReed.AGE);
                if (llllllllllllIlIIIIlIIlIIIIIIlllI == 15) {
                    llllllllllllIlIIIIlIIlIIIIIlIIll.setBlockState(llllllllllllIlIIIIlIIlIIIIIIlIll.up(), this.getDefaultState());
                    llllllllllllIlIIIIlIIlIIIIIlIIll.setBlockState(llllllllllllIlIIIIlIIlIIIIIIlIll, llllllllllllIlIIIIlIIlIIIIIIlIlI.withProperty((IProperty<Comparable>)BlockReed.AGE, 0), 4);
                }
                else {
                    llllllllllllIlIIIIlIIlIIIIIlIIll.setBlockState(llllllllllllIlIIIIlIIlIIIIIIlIll, llllllllllllIlIIIIlIIlIIIIIIlIlI.withProperty((IProperty<Comparable>)BlockReed.AGE, llllllllllllIlIIIIlIIlIIIIIIlllI + 1), 4);
                }
            }
        }
    }
    
    protected BlockReed() {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockReed.AGE, 0));
        this.setTickRandomly(true);
    }
}
