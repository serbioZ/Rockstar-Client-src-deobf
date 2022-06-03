// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Rotation;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.material.Material;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import java.util.Random;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.init.Items;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockCocoa extends BlockHorizontal implements IGrowable
{
    public static final /* synthetic */ PropertyInteger AGE;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_NORTH_AABB;
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIIIIlIlIllIlIlllI) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIIIIIlIlIlIlllIIll, final World llllllllllllllIIIIIlIlIlIllIllII, final BlockPos llllllllllllllIIIIIlIlIlIllIlIll, final Block llllllllllllllIIIIIlIlIlIlllIIII, final BlockPos llllllllllllllIIIIIlIlIlIllIllll) {
        if (!this.canBlockStay(llllllllllllllIIIIIlIlIlIllIllII, llllllllllllllIIIIIlIlIlIllIlIll, llllllllllllllIIIIIlIlIlIlllIIll)) {
            this.dropBlock(llllllllllllllIIIIIlIlIlIllIllII, llllllllllllllIIIIIlIlIlIllIlIll, llllllllllllllIIIIIlIlIlIlllIIll);
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIIIlIlIlIlIlIlll, final BlockPos llllllllllllllIIIIIlIlIlIlIlIllI, final IBlockState llllllllllllllIIIIIlIlIlIlIlIlIl, final float llllllllllllllIIIIIlIlIlIlIlIlII, final int llllllllllllllIIIIIlIlIlIlIlIIll) {
        final int llllllllllllllIIIIIlIlIlIlIlIIlI = llllllllllllllIIIIIlIlIlIlIlIlIl.getValue((IProperty<Integer>)BlockCocoa.AGE);
        int llllllllllllllIIIIIlIlIlIlIlIIIl = 1;
        if (llllllllllllllIIIIIlIlIlIlIlIIlI >= 2) {
            llllllllllllllIIIIIlIlIlIlIlIIIl = 3;
        }
        for (int llllllllllllllIIIIIlIlIlIlIlIIII = 0; llllllllllllllIIIIIlIlIlIlIlIIII < llllllllllllllIIIIIlIlIlIlIlIIIl; ++llllllllllllllIIIIIlIlIlIlIlIIII) {
            Block.spawnAsEntity(llllllllllllllIIIIIlIlIlIlIlIlll, llllllllllllllIIIIIlIlIlIlIlIllI, new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()));
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockCocoa.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double llllllllllllllIIIIIlIlIlIIIlIlll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIIlIlIlIIIlIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockCocoa.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIIlIlIlIIIlIlll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCocoa.FACING, BlockCocoa.AGE });
    }
    
    @Override
    public void grow(final World llllllllllllllIIIIIlIlIlIIllIlIl, final Random llllllllllllllIIIIIlIlIlIIllIlII, final BlockPos llllllllllllllIIIIIlIlIlIIllIIII, final IBlockState llllllllllllllIIIIIlIlIlIIllIIlI) {
        llllllllllllllIIIIIlIlIlIIllIlIl.setBlockState(llllllllllllllIIIIIlIlIlIIllIIII, llllllllllllllIIIIIlIlIlIIllIIlI.withProperty((IProperty<Comparable>)BlockCocoa.AGE, llllllllllllllIIIIIlIlIlIIllIIlI.getValue((IProperty<Integer>)BlockCocoa.AGE) + 1), 2);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIIlIlIlIIlIlIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, EnumFacing.getHorizontal(llllllllllllllIIIIIlIlIlIIlIlIII)).withProperty((IProperty<Comparable>)BlockCocoa.AGE, (llllllllllllllIIIIIlIlIlIIlIlIII & 0xF) >> 2);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIIIIlIlIllIIIIIlI, final BlockPos llllllllllllllIIIIIlIlIllIIIIIIl, EnumFacing llllllllllllllIIIIIlIlIlIllllIIl, final float llllllllllllllIIIIIlIlIlIlllllll, final float llllllllllllllIIIIIlIlIlIllllllI, final float llllllllllllllIIIIIlIlIlIlllllIl, final int llllllllllllllIIIIIlIlIlIlllllII, final EntityLivingBase llllllllllllllIIIIIlIlIlIllllIll) {
        if (!((EnumFacing)llllllllllllllIIIIIlIlIlIllllIIl).getAxis().isHorizontal()) {
            llllllllllllllIIIIIlIlIlIllllIIl = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, ((EnumFacing)llllllllllllllIIIIIlIlIlIllllIIl).getOpposite()).withProperty((IProperty<Comparable>)BlockCocoa.AGE, 0);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIIIIIlIlIlIlIIlIII, final BlockPos llllllllllllllIIIIIlIlIlIlIIIlll, final IBlockState llllllllllllllIIIIIlIlIlIlIIIllI) {
        return new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage());
    }
    
    public boolean canBlockStay(final World llllllllllllllIIIIIlIlIllIllIlIl, BlockPos llllllllllllllIIIIIlIlIllIllIlII, final IBlockState llllllllllllllIIIIIlIlIllIllIlll) {
        llllllllllllllIIIIIlIlIllIllIlII = llllllllllllllIIIIIlIlIllIllIlII.offset(llllllllllllllIIIIIlIlIllIllIlll.getValue((IProperty<EnumFacing>)BlockCocoa.FACING));
        final IBlockState llllllllllllllIIIIIlIlIllIllIllI = llllllllllllllIIIIIlIlIllIllIlIl.getBlockState(llllllllllllllIIIIIlIlIllIllIlII);
        return llllllllllllllIIIIIlIlIllIllIllI.getBlock() == Blocks.LOG && llllllllllllllIIIIIlIlIllIllIllI.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.JUNGLE;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 2);
        COCOA_EAST_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.6875, 0.4375, 0.375, 0.9375, 0.75, 0.625), new AxisAlignedBB(0.5625, 0.3125, 0.3125, 0.9375, 0.75, 0.6875), new AxisAlignedBB(0.4375, 0.1875, 0.25, 0.9375, 0.75, 0.75) };
        COCOA_WEST_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0625, 0.4375, 0.375, 0.3125, 0.75, 0.625), new AxisAlignedBB(0.0625, 0.3125, 0.3125, 0.4375, 0.75, 0.6875), new AxisAlignedBB(0.0625, 0.1875, 0.25, 0.5625, 0.75, 0.75) };
        COCOA_NORTH_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.4375, 0.0625, 0.625, 0.75, 0.3125), new AxisAlignedBB(0.3125, 0.3125, 0.0625, 0.6875, 0.75, 0.4375), new AxisAlignedBB(0.25, 0.1875, 0.0625, 0.75, 0.75, 0.5625) };
        COCOA_SOUTH_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.4375, 0.6875, 0.625, 0.75, 0.9375), new AxisAlignedBB(0.3125, 0.3125, 0.5625, 0.6875, 0.75, 0.9375), new AxisAlignedBB(0.25, 0.1875, 0.4375, 0.75, 0.75, 0.9375) };
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIIlIlIlIIlIIlII) {
        int llllllllllllllIIIIIlIlIlIIlIIIll = 0;
        llllllllllllllIIIIIlIlIlIIlIIIll |= llllllllllllllIIIIIlIlIlIIlIIlII.getValue((IProperty<EnumFacing>)BlockCocoa.FACING).getHorizontalIndex();
        llllllllllllllIIIIIlIlIlIIlIIIll |= llllllllllllllIIIIIlIlIlIIlIIlII.getValue((IProperty<Integer>)BlockCocoa.AGE) << 2;
        return llllllllllllllIIIIIlIlIlIIlIIIll;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIIIlIlIlIIIlllII, final IBlockState llllllllllllllIIIIIlIlIlIIIllIll, final BlockPos llllllllllllllIIIIIlIlIlIIIllIlI, final EnumFacing llllllllllllllIIIIIlIlIlIIIllIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIIIIIlIlIllIIllIlI, final Mirror llllllllllllllIIIIIlIlIllIIllIIl) {
        return llllllllllllllIIIIIlIlIllIIllIlI.withRotation(llllllllllllllIIIIIlIlIllIIllIIl.toRotation(llllllllllllllIIIIIlIlIllIIllIlI.getValue((IProperty<EnumFacing>)BlockCocoa.FACING)));
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIIIIlIlIllIIIlIlI, final BlockPos llllllllllllllIIIIIlIlIllIIIlIIl, final IBlockState llllllllllllllIIIIIlIlIllIIIlIII, final EntityLivingBase llllllllllllllIIIIIlIlIllIIIIlll, final ItemStack llllllllllllllIIIIIlIlIllIIIllII) {
        final EnumFacing llllllllllllllIIIIIlIlIllIIIlIll = EnumFacing.fromAngle(llllllllllllllIIIIIlIlIllIIIIlll.rotationYaw);
        llllllllllllllIIIIIlIlIllIIIlIlI.setBlockState(llllllllllllllIIIIIlIlIllIIIlIIl, llllllllllllllIIIIIlIlIllIIIlIII.withProperty((IProperty<Comparable>)BlockCocoa.FACING, llllllllllllllIIIIIlIlIllIIIlIll), 2);
    }
    
    public BlockCocoa() {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockCocoa.AGE, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIIIIIlIlIllIllIIII) {
        return false;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIIIIIlIlIllIlIIIIl, final Rotation llllllllllllllIIIIIlIlIllIlIIIII) {
        return llllllllllllllIIIIIlIlIllIlIIIIl.withProperty((IProperty<Comparable>)BlockCocoa.FACING, llllllllllllllIIIIIlIlIllIlIIIII.rotate(llllllllllllllIIIIIlIlIllIlIIIIl.getValue((IProperty<EnumFacing>)BlockCocoa.FACING)));
    }
    
    @Override
    public boolean canGrow(final World llllllllllllllIIIIIlIlIlIlIIIIll, final BlockPos llllllllllllllIIIIIlIlIlIlIIIIlI, final IBlockState llllllllllllllIIIIIlIlIlIlIIIIIl, final boolean llllllllllllllIIIIIlIlIlIlIIIIII) {
        return llllllllllllllIIIIIlIlIlIlIIIIIl.getValue((IProperty<Integer>)BlockCocoa.AGE) < 2;
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIIIIlIlIlIIllllIl, final Random llllllllllllllIIIIIlIlIlIIllllII, final BlockPos llllllllllllllIIIIIlIlIlIIlllIll, final IBlockState llllllllllllllIIIIIlIlIlIIlllIlI) {
        return true;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIIIIIlIlIllIlIlIlI, final IBlockAccess llllllllllllllIIIIIlIlIllIlIlIIl, final BlockPos llllllllllllllIIIIIlIlIllIlIlIII) {
        final int llllllllllllllIIIIIlIlIllIlIIlll = llllllllllllllIIIIIlIlIllIlIlIlI.getValue((IProperty<Integer>)BlockCocoa.AGE);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIIlIlIllIlIlIlI.getValue((IProperty<EnumFacing>)BlockCocoa.FACING).ordinal()]) {
            case 4: {
                return BlockCocoa.COCOA_SOUTH_AABB[llllllllllllllIIIIIlIlIllIlIIlll];
            }
            default: {
                return BlockCocoa.COCOA_NORTH_AABB[llllllllllllllIIIIIlIlIllIlIIlll];
            }
            case 5: {
                return BlockCocoa.COCOA_WEST_AABB[llllllllllllllIIIIIlIlIllIlIIlll];
            }
            case 6: {
                return BlockCocoa.COCOA_EAST_AABB[llllllllllllllIIIIIlIlIllIlIIlll];
            }
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIIIlIlIlllIIlIII, final BlockPos llllllllllllllIIIIIlIlIlllIIIlll, final IBlockState llllllllllllllIIIIIlIlIlllIIIllI, final Random llllllllllllllIIIIIlIlIlllIIIlIl) {
        if (!this.canBlockStay(llllllllllllllIIIIIlIlIlllIIlIII, llllllllllllllIIIIIlIlIlllIIIlll, llllllllllllllIIIIIlIlIlllIIIllI)) {
            this.dropBlock(llllllllllllllIIIIIlIlIlllIIlIII, llllllllllllllIIIIIlIlIlllIIIlll, llllllllllllllIIIIIlIlIlllIIIllI);
        }
        else if (llllllllllllllIIIIIlIlIlllIIlIII.rand.nextInt(5) == 0) {
            final int llllllllllllllIIIIIlIlIlllIIIlII = llllllllllllllIIIIIlIlIlllIIIllI.getValue((IProperty<Integer>)BlockCocoa.AGE);
            if (llllllllllllllIIIIIlIlIlllIIIlII < 2) {
                llllllllllllllIIIIIlIlIlllIIlIII.setBlockState(llllllllllllllIIIIIlIlIlllIIIlll, llllllllllllllIIIIIlIlIlllIIIllI.withProperty((IProperty<Comparable>)BlockCocoa.AGE, llllllllllllllIIIIIlIlIlllIIIlII + 1), 2);
            }
        }
    }
    
    private void dropBlock(final World llllllllllllllIIIIIlIlIlIllIIlIl, final BlockPos llllllllllllllIIIIIlIlIlIllIIlII, final IBlockState llllllllllllllIIIIIlIlIlIllIIIll) {
        llllllllllllllIIIIIlIlIlIllIIlIl.setBlockState(llllllllllllllIIIIIlIlIlIllIIlII, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(llllllllllllllIIIIIlIlIlIllIIlIl, llllllllllllllIIIIIlIlIlIllIIlII, llllllllllllllIIIIIlIlIlIllIIIll, 0);
    }
}
