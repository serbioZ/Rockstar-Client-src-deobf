// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockTorch extends Block
{
    protected static final /* synthetic */ AxisAlignedBB TORCH_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB STANDING_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB TORCH_WEST_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIlIIlIlllIlIllIlIlll, final Rotation llllllllllllIlIIlIlllIlIllIlIlII) {
        return llllllllllllIlIIlIlllIlIllIlIlll.withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllIlIIlIlllIlIllIlIlII.rotate(llllllllllllIlIIlIlllIlIllIlIlll.getValue((IProperty<EnumFacing>)BlockTorch.FACING)));
    }
    
    protected BlockTorch() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    static {
        FACING = PropertyDirection.create("facing", (Predicate<EnumFacing>)new Predicate<EnumFacing>() {
            public boolean apply(@Nullable final EnumFacing llllllllllIlllIIlllIIIllllIIIllI) {
                return llllllllllIlllIIlllIIIllllIIIllI != EnumFacing.DOWN;
            }
        });
        STANDING_AABB = new AxisAlignedBB(0.4000000059604645, 0.0, 0.4000000059604645, 0.6000000238418579, 0.6000000238418579, 0.6000000238418579);
        TORCH_NORTH_AABB = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.699999988079071, 0.6499999761581421, 0.800000011920929, 1.0);
        TORCH_SOUTH_AABB = new AxisAlignedBB(0.3499999940395355, 0.20000000298023224, 0.0, 0.6499999761581421, 0.800000011920929, 0.30000001192092896);
        TORCH_WEST_AABB = new AxisAlignedBB(0.699999988079071, 0.20000000298023224, 0.3499999940395355, 1.0, 0.800000011920929, 0.6499999761581421);
        TORCH_EAST_AABB = new AxisAlignedBB(0.0, 0.20000000298023224, 0.3499999940395355, 0.30000001192092896, 0.800000011920929, 0.6499999761581421);
    }
    
    protected boolean onNeighborChangeInternal(final World llllllllllllIlIIlIlllIllIIlIlIII, final BlockPos llllllllllllIlIIlIlllIllIIlIIlll, final IBlockState llllllllllllIlIIlIlllIllIIIlllIl) {
        if (!this.checkForDrop(llllllllllllIlIIlIlllIllIIlIlIII, llllllllllllIlIIlIlllIllIIlIIlll, llllllllllllIlIIlIlllIllIIIlllIl)) {
            return true;
        }
        final EnumFacing llllllllllllIlIIlIlllIllIIlIIlIl = llllllllllllIlIIlIlllIllIIIlllIl.getValue((IProperty<EnumFacing>)BlockTorch.FACING);
        final EnumFacing.Axis llllllllllllIlIIlIlllIllIIlIIlII = llllllllllllIlIIlIlllIllIIlIIlIl.getAxis();
        final EnumFacing llllllllllllIlIIlIlllIllIIlIIIll = llllllllllllIlIIlIlllIllIIlIIlIl.getOpposite();
        final BlockPos llllllllllllIlIIlIlllIllIIlIIIlI = llllllllllllIlIIlIlllIllIIlIIlll.offset(llllllllllllIlIIlIlllIllIIlIIIll);
        boolean llllllllllllIlIIlIlllIllIIlIIIIl = false;
        if (llllllllllllIlIIlIlllIllIIlIIlII.isHorizontal() && llllllllllllIlIIlIlllIllIIlIlIII.getBlockState(llllllllllllIlIIlIlllIllIIlIIIlI).func_193401_d(llllllllllllIlIIlIlllIllIIlIlIII, llllllllllllIlIIlIlllIllIIlIIIlI, llllllllllllIlIIlIlllIllIIlIIlIl) != BlockFaceShape.SOLID) {
            llllllllllllIlIIlIlllIllIIlIIIIl = true;
        }
        else if (llllllllllllIlIIlIlllIllIIlIIlII.isVertical() && !this.canPlaceOn(llllllllllllIlIIlIlllIllIIlIlIII, llllllllllllIlIIlIlllIllIIlIIIlI)) {
            llllllllllllIlIIlIlllIllIIlIIIIl = true;
        }
        if (llllllllllllIlIIlIlllIllIIlIIIIl) {
            this.dropBlockAsItem(llllllllllllIlIIlIlllIllIIlIlIII, llllllllllllIlIIlIlllIllIIlIIlll, llllllllllllIlIIlIlllIllIIIlllIl, 0);
            llllllllllllIlIIlIlllIllIIlIlIII.setBlockToAir(llllllllllllIlIIlIlllIllIIlIIlll);
            return true;
        }
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTorch.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float llllllllllllIlIIlIlllIlIllIIIIll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIlIIlIlllIlIllIIIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTorch.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIlIIlIlllIlIllIIIIll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIIlIlllIlIllIllllI) {
        int llllllllllllIlIIlIlllIlIllIlllIl = 0;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIlIIlIlllIlIllIllllI.getValue((IProperty<EnumFacing>)BlockTorch.FACING).ordinal()]) {
            case 6: {
                llllllllllllIlIIlIlllIlIllIlllIl |= 0x1;
                break;
            }
            case 5: {
                llllllllllllIlIIlIlllIlIllIlllIl |= 0x2;
                break;
            }
            case 4: {
                llllllllllllIlIIlIlllIlIllIlllIl |= 0x3;
                break;
            }
            case 3: {
                llllllllllllIlIIlIlllIlIllIlllIl |= 0x4;
                break;
            }
            default: {
                llllllllllllIlIIlIlllIlIllIlllIl |= 0x5;
                break;
            }
        }
        return llllllllllllIlIIlIlllIlIllIlllIl;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIlIIlIlllIlIllIIlllI, final Mirror llllllllllllIlIIlIlllIlIllIIllll) {
        return llllllllllllIlIIlIlllIlIllIIlllI.withRotation(llllllllllllIlIIlIlllIlIllIIllll.toRotation(llllllllllllIlIIlIlllIlIllIIlllI.getValue((IProperty<EnumFacing>)BlockTorch.FACING)));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIlIIlIlllIllIlIIIlll, final BlockPos llllllllllllIlIIlIlllIllIlIIIllI, final IBlockState llllllllllllIlIIlIlllIllIlIIIIIl) {
        this.checkForDrop(llllllllllllIlIIlIlllIllIlIIIlll, llllllllllllIlIIlIlllIllIlIIIllI, llllllllllllIlIIlIlllIllIlIIIIIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIIlIlllIlIlllIIllI) {
        IBlockState llllllllllllIlIIlIlllIlIlllIIlIl = this.getDefaultState();
        switch (llllllllllllIlIIlIlllIlIlllIIllI) {
            case 1: {
                llllllllllllIlIIlIlllIlIlllIIlIl = llllllllllllIlIIlIlllIlIlllIIlIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST);
                break;
            }
            case 2: {
                llllllllllllIlIIlIlllIlIlllIIlIl = llllllllllllIlIIlIlllIlIlllIIlIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST);
                break;
            }
            case 3: {
                llllllllllllIlIIlIlllIlIlllIIlIl = llllllllllllIlIIlIlllIlIlllIIlIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH);
                break;
            }
            case 4: {
                llllllllllllIlIIlIlllIlIlllIIlIl = llllllllllllIlIIlIlllIlIlllIIlIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH);
                break;
            }
            default: {
                llllllllllllIlIIlIlllIlIlllIIlIl = llllllllllllIlIIlIlllIlIlllIIlIl.withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP);
                break;
            }
        }
        return llllllllllllIlIIlIlllIlIlllIIlIl;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllIlIIlIlllIllIIIIIIII, final World llllllllllllIlIIlIlllIlIllllIIll, final BlockPos llllllllllllIlIIlIlllIlIllllIIlI, final Random llllllllllllIlIIlIlllIlIllllllIl) {
        final EnumFacing llllllllllllIlIIlIlllIlIllllllII = llllllllllllIlIIlIlllIllIIIIIIII.getValue((IProperty<EnumFacing>)BlockTorch.FACING);
        final double llllllllllllIlIIlIlllIlIlllllIll = llllllllllllIlIIlIlllIlIllllIIlI.getX() + 0.5;
        final double llllllllllllIlIIlIlllIlIlllllIlI = llllllllllllIlIIlIlllIlIllllIIlI.getY() + 0.7;
        final double llllllllllllIlIIlIlllIlIlllllIIl = llllllllllllIlIIlIlllIlIllllIIlI.getZ() + 0.5;
        final double llllllllllllIlIIlIlllIlIlllllIII = 0.22;
        final double llllllllllllIlIIlIlllIlIllllIlll = 0.27;
        if (llllllllllllIlIIlIlllIlIllllllII.getAxis().isHorizontal()) {
            final EnumFacing llllllllllllIlIIlIlllIlIllllIllI = llllllllllllIlIIlIlllIlIllllllII.getOpposite();
            llllllllllllIlIIlIlllIlIllllIIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllIlIIlIlllIlIlllllIll + 0.27 * llllllllllllIlIIlIlllIlIllllIllI.getFrontOffsetX(), llllllllllllIlIIlIlllIlIlllllIlI + 0.22, llllllllllllIlIIlIlllIlIlllllIIl + 0.27 * llllllllllllIlIIlIlllIlIllllIllI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
            llllllllllllIlIIlIlllIlIllllIIll.spawnParticle(EnumParticleTypes.FLAME, llllllllllllIlIIlIlllIlIlllllIll + 0.27 * llllllllllllIlIIlIlllIlIllllIllI.getFrontOffsetX(), llllllllllllIlIIlIlllIlIlllllIlI + 0.22, llllllllllllIlIIlIlllIlIlllllIIl + 0.27 * llllllllllllIlIIlIlllIlIllllIllI.getFrontOffsetZ(), 0.0, 0.0, 0.0, new int[0]);
        }
        else {
            llllllllllllIlIIlIlllIlIllllIIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllIlIIlIlllIlIlllllIll, llllllllllllIlIIlIlllIlIlllllIlI, llllllllllllIlIIlIlllIlIlllllIIl, 0.0, 0.0, 0.0, new int[0]);
            llllllllllllIlIIlIlllIlIllllIIll.spawnParticle(EnumParticleTypes.FLAME, llllllllllllIlIIlIlllIlIlllllIll, llllllllllllIlIIlIlllIlIlllllIlI, llllllllllllIlIIlIlllIlIlllllIIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlIIlIlllIlllIIllIll) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTorch.FACING });
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIlIIlIlllIllIlIllIll, final BlockPos llllllllllllIlIIlIlllIllIlIllIlI, final EnumFacing llllllllllllIlIIlIlllIllIlIllIIl, final float llllllllllllIlIIlIlllIllIlIllIII, final float llllllllllllIlIIlIlllIllIlIlIlll, final float llllllllllllIlIIlIlllIllIlIlIllI, final int llllllllllllIlIIlIlllIllIlIlIlIl, final EntityLivingBase llllllllllllIlIIlIlllIllIlIlIlII) {
        if (this.canPlaceAt(llllllllllllIlIIlIlllIllIlIllIll, llllllllllllIlIIlIlllIllIlIllIlI, llllllllllllIlIIlIlllIllIlIllIIl)) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllIlIIlIlllIllIlIllIIl);
        }
        for (final EnumFacing llllllllllllIlIIlIlllIllIlIlIIll : EnumFacing.Plane.HORIZONTAL) {
            if (this.canPlaceAt(llllllllllllIlIIlIlllIllIlIllIll, llllllllllllIlIIlIlllIllIlIllIlI, llllllllllllIlIIlIlllIllIlIlIIll)) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, llllllllllllIlIIlIlllIllIlIlIIll);
            }
        }
        return this.getDefaultState();
    }
    
    protected boolean checkForDrop(final World llllllllllllIlIIlIlllIllIIIlIIlI, final BlockPos llllllllllllIlIIlIlllIllIIIIllIl, final IBlockState llllllllllllIlIIlIlllIllIIIIllII) {
        if (llllllllllllIlIIlIlllIllIIIIllII.getBlock() == this && this.canPlaceAt(llllllllllllIlIIlIlllIllIIIlIIlI, llllllllllllIlIIlIlllIllIIIIllIl, llllllllllllIlIIlIlllIllIIIIllII.getValue((IProperty<EnumFacing>)BlockTorch.FACING))) {
            return true;
        }
        if (llllllllllllIlIIlIlllIllIIIlIIlI.getBlockState(llllllllllllIlIIlIlllIllIIIIllIl).getBlock() == this) {
            this.dropBlockAsItem(llllllllllllIlIIlIlllIllIIIlIIlI, llllllllllllIlIIlIlllIllIIIIllIl, llllllllllllIlIIlIlllIllIIIIllII, 0);
            llllllllllllIlIIlIlllIllIIIlIIlI.setBlockToAir(llllllllllllIlIIlIlllIllIIIIllIl);
        }
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlIIlIlllIllIIlllIll, final World llllllllllllIlIIlIlllIllIIlllIlI, final BlockPos llllllllllllIlIIlIlllIllIIlllIIl, final Block llllllllllllIlIIlIlllIllIIlllIII, final BlockPos llllllllllllIlIIlIlllIllIIllIlll) {
        this.onNeighborChangeInternal(llllllllllllIlIIlIlllIllIIlllIlI, llllllllllllIlIIlIlllIllIIlllIIl, llllllllllllIlIIlIlllIllIIlllIll);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    private boolean canPlaceOn(final World llllllllllllIlIIlIlllIlllIIlIIlI, final BlockPos llllllllllllIlIIlIlllIlllIIIllII) {
        final Block llllllllllllIlIIlIlllIlllIIlIIII = llllllllllllIlIIlIlllIlllIIlIIlI.getBlockState(llllllllllllIlIIlIlllIlllIIIllII).getBlock();
        final boolean llllllllllllIlIIlIlllIlllIIIllll = llllllllllllIlIIlIlllIlllIIlIIII == Blocks.END_GATEWAY || llllllllllllIlIIlIlllIlllIIlIIII == Blocks.LIT_PUMPKIN;
        if (llllllllllllIlIIlIlllIlllIIlIIlI.getBlockState(llllllllllllIlIIlIlllIlllIIIllII).isFullyOpaque()) {
            return !llllllllllllIlIIlIlllIlllIIIllll;
        }
        final boolean llllllllllllIlIIlIlllIlllIIIlllI = llllllllllllIlIIlIlllIlllIIlIIII instanceof BlockFence || llllllllllllIlIIlIlllIlllIIlIIII == Blocks.GLASS || llllllllllllIlIIlIlllIlllIIlIIII == Blocks.COBBLESTONE_WALL || llllllllllllIlIIlIlllIlllIIlIIII == Blocks.STAINED_GLASS;
        return llllllllllllIlIIlIlllIlllIIIlllI && !llllllllllllIlIIlIlllIlllIIIllll;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlIIlIlllIlIllIIlIII, final IBlockState llllllllllllIlIIlIlllIlIllIIIlll, final BlockPos llllllllllllIlIIlIlllIlIllIIIllI, final EnumFacing llllllllllllIlIIlIlllIlIllIIIlIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIlIIlIlllIlllIlIIlII, final IBlockAccess llllllllllllIlIIlIlllIlllIlIIIll, final BlockPos llllllllllllIlIIlIlllIlllIlIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIlIIlIlllIlllIlIIlII.getValue((IProperty<EnumFacing>)BlockTorch.FACING).ordinal()]) {
            case 6: {
                return BlockTorch.TORCH_EAST_AABB;
            }
            case 5: {
                return BlockTorch.TORCH_WEST_AABB;
            }
            case 4: {
                return BlockTorch.TORCH_SOUTH_AABB;
            }
            case 3: {
                return BlockTorch.TORCH_NORTH_AABB;
            }
            default: {
                return BlockTorch.STANDING_AABB;
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlIIlIlllIlllIIIIIlI, final BlockPos llllllllllllIlIIlIlllIllIlllllIl) {
        for (final EnumFacing llllllllllllIlIIlIlllIlllIIIIIII : BlockTorch.FACING.getAllowedValues()) {
            if (this.canPlaceAt(llllllllllllIlIIlIlllIlllIIIIIlI, llllllllllllIlIIlIlllIllIlllllIl, llllllllllllIlIIlIlllIlllIIIIIII)) {
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIlIIlIlllIlllIIlllll, final IBlockAccess llllllllllllIlIIlIlllIlllIIllllI, final BlockPos llllllllllllIlIIlIlllIlllIIlllIl) {
        return BlockTorch.NULL_AABB;
    }
    
    private boolean canPlaceAt(final World llllllllllllIlIIlIlllIllIlllIIIl, final BlockPos llllllllllllIlIIlIlllIllIllIlIII, final EnumFacing llllllllllllIlIIlIlllIllIllIllll) {
        final BlockPos llllllllllllIlIIlIlllIllIllIlllI = llllllllllllIlIIlIlllIllIllIlIII.offset(llllllllllllIlIIlIlllIllIllIllll.getOpposite());
        final IBlockState llllllllllllIlIIlIlllIllIllIllIl = llllllllllllIlIIlIlllIllIlllIIIl.getBlockState(llllllllllllIlIIlIlllIllIllIlllI);
        final Block llllllllllllIlIIlIlllIllIllIllII = llllllllllllIlIIlIlllIllIllIllIl.getBlock();
        final BlockFaceShape llllllllllllIlIIlIlllIllIllIlIll = llllllllllllIlIIlIlllIllIllIllIl.func_193401_d(llllllllllllIlIIlIlllIllIlllIIIl, llllllllllllIlIIlIlllIllIllIlllI, llllllllllllIlIIlIlllIllIllIllll);
        return (llllllllllllIlIIlIlllIllIllIllll.equals(EnumFacing.UP) && this.canPlaceOn(llllllllllllIlIIlIlllIllIlllIIIl, llllllllllllIlIIlIlllIllIllIlllI)) || (llllllllllllIlIIlIlllIllIllIllll != EnumFacing.UP && llllllllllllIlIIlIlllIllIllIllll != EnumFacing.DOWN && (!Block.func_193382_c(llllllllllllIlIIlIlllIllIllIllII) && llllllllllllIlIIlIlllIllIllIlIll == BlockFaceShape.SOLID));
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlIIlIlllIlllIIllIIl) {
        return false;
    }
}
