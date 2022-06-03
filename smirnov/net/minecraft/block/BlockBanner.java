// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.init.Items;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyDirection;

public class BlockBanner extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB STANDING_AABB;
    public static final /* synthetic */ PropertyInteger ROTATION;
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIlIlIIIIIllIIIIllIIlI, final BlockPos lllllllllllIlIlIIIIIllIIIIllIIIl) {
        return true;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIlIlIIIIIllIIIIlllIII, final IBlockAccess lllllllllllIlIlIIIIIllIIIIllIlll, final BlockPos lllllllllllIlIlIIIIIllIIIIllIllI) {
        return BlockBanner.NULL_AABB;
    }
    
    private ItemStack getTileDataItemStack(final World lllllllllllIlIlIIIIIllIIIIIlllll, final BlockPos lllllllllllIlIlIIIIIllIIIIlIIIIl) {
        final TileEntity lllllllllllIlIlIIIIIllIIIIlIIIII = lllllllllllIlIlIIIIIllIIIIIlllll.getTileEntity(lllllllllllIlIlIIIIIllIIIIlIIIIl);
        return (lllllllllllIlIlIIIIIllIIIIlIIIII instanceof TileEntityBanner) ? ((TileEntityBanner)lllllllllllIlIlIIIIIllIIIIlIIIII).func_190615_l() : ItemStack.field_190927_a;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIlIIIIIllIIIIllIlII) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIlIlIIIIIllIIIIlIllII, final int lllllllllllIlIlIIIIIllIIIIlIlIll) {
        return new TileEntityBanner();
    }
    
    protected BlockBanner() {
        super(Material.WOOD);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIlIIIIIllIIIIlIllll) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIlIIIIIllIIIIIlIlll, final BlockPos lllllllllllIlIlIIIIIllIIIIIlIIIl, final IBlockState lllllllllllIlIlIIIIIllIIIIIlIlIl) {
        final ItemStack lllllllllllIlIlIIIIIllIIIIIlIlII = this.getTileDataItemStack(lllllllllllIlIlIIIIIllIIIIIlIlll, lllllllllllIlIlIIIIIllIIIIIlIIIl);
        return lllllllllllIlIlIIIIIllIIIIIlIlII.func_190926_b() ? new ItemStack(Items.BANNER) : lllllllllllIlIlIIIIIllIIIIIlIlII;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIlIlIIIIIllIIIIIIIlll, final BlockPos lllllllllllIlIlIIIIIllIIIIIIIllI, final IBlockState lllllllllllIlIlIIIIIllIIIIIIIlIl, final float lllllllllllIlIlIIIIIlIllllllllIl, final int lllllllllllIlIlIIIIIllIIIIIIIIll) {
        final ItemStack lllllllllllIlIlIIIIIllIIIIIIIIlI = this.getTileDataItemStack(lllllllllllIlIlIIIIIllIIIIIIIlll, lllllllllllIlIlIIIIIllIIIIIIIllI);
        if (lllllllllllIlIlIIIIIllIIIIIIIIlI.func_190926_b()) {
            super.dropBlockAsItemWithChance(lllllllllllIlIlIIIIIllIIIIIIIlll, lllllllllllIlIlIIIIIllIIIIIIIllI, lllllllllllIlIlIIIIIllIIIIIIIlIl, lllllllllllIlIlIIIIIlIllllllllIl, lllllllllllIlIlIIIIIllIIIIIIIIll);
        }
        else {
            Block.spawnAsEntity(lllllllllllIlIlIIIIIllIIIIIIIlll, lllllllllllIlIlIIIIIllIIIIIIIllI, lllllllllllIlIlIIIIIllIIIIIIIIlI);
        }
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.banner.white.name");
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIlIIIIIlIllllIlIlIl, final IBlockState lllllllllllIlIlIIIIIlIllllIlIlII, final BlockPos lllllllllllIlIlIIIIIlIllllIlIIll, final EnumFacing lllllllllllIlIlIIIIIlIllllIlIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIlIlIIIIIlIllllIllllI, final EntityPlayer lllllllllllIlIlIIIIIlIllllIlllIl, final BlockPos lllllllllllIlIlIIIIIlIllllIlllII, final IBlockState lllllllllllIlIlIIIIIlIlllllIIlII, @Nullable final TileEntity lllllllllllIlIlIIIIIlIlllllIIIll, final ItemStack lllllllllllIlIlIIIIIlIlllllIIIlI) {
        if (lllllllllllIlIlIIIIIlIlllllIIIll instanceof TileEntityBanner) {
            final TileEntityBanner lllllllllllIlIlIIIIIlIlllllIIIIl = (TileEntityBanner)lllllllllllIlIlIIIIIlIlllllIIIll;
            final ItemStack lllllllllllIlIlIIIIIlIlllllIIIII = lllllllllllIlIlIIIIIlIlllllIIIIl.func_190615_l();
            Block.spawnAsEntity(lllllllllllIlIlIIIIIlIllllIllllI, lllllllllllIlIlIIIIIlIllllIlllII, lllllllllllIlIlIIIIIlIlllllIIIII);
        }
        else {
            super.harvestBlock(lllllllllllIlIlIIIIIlIllllIllllI, lllllllllllIlIlIIIIIlIllllIlllIl, lllllllllllIlIlIIIIIlIllllIlllII, lllllllllllIlIlIIIIIlIlllllIIlII, null, lllllllllllIlIlIIIIIlIlllllIIIlI);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlIlIIIIIllIIIIlIlIIl, final Random lllllllllllIlIlIIIIIllIIIIlIlIII, final int lllllllllllIlIlIIIIIllIIIIlIIlll) {
        return Items.BANNER;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIlIlIIIIIlIllllllIIll, final BlockPos lllllllllllIlIlIIIIIlIllllllIlIl) {
        return !this.hasInvalidNeighbor(lllllllllllIlIlIIIIIlIllllllIIll, lllllllllllIlIlIIIIIlIllllllIlIl) && super.canPlaceBlockAt(lllllllllllIlIlIIIIIlIllllllIIll, lllllllllllIlIlIIIIIlIllllllIlIl);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        ROTATION = PropertyInteger.create("rotation", 0, 15);
        STANDING_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
    }
    
    public static class BlockBannerHanging extends BlockBanner
    {
        protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
        protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
        protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
        protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        @Override
        public void neighborChanged(final IBlockState llllllllllIlllllIIIIIlIIllIlIIlI, final World llllllllllIlllllIIIIIlIIllIlIIIl, final BlockPos llllllllllIlllllIIIIIlIIllIIlIIl, final Block llllllllllIlllllIIIIIlIIllIIlIII, final BlockPos llllllllllIlllllIIIIIlIIllIIlllI) {
            final EnumFacing llllllllllIlllllIIIIIlIIllIIllIl = llllllllllIlllllIIIIIlIIllIlIIlI.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING);
            if (!llllllllllIlllllIIIIIlIIllIlIIIl.getBlockState(llllllllllIlllllIIIIIlIIllIIlIIl.offset(llllllllllIlllllIIIIIlIIllIIllIl.getOpposite())).getMaterial().isSolid()) {
                this.dropBlockAsItem(llllllllllIlllllIIIIIlIIllIlIIIl, llllllllllIlllllIIIIIlIIllIIlIIl, llllllllllIlllllIIIIIlIIllIlIIlI, 0);
                llllllllllIlllllIIIIIlIIllIlIIIl.setBlockToAir(llllllllllIlllllIIIIIlIIllIIlIIl);
            }
            super.neighborChanged(llllllllllIlllllIIIIIlIIllIlIIlI, llllllllllIlllllIIIIIlIIllIlIIIl, llllllllllIlllllIIIIIlIIllIIlIIl, llllllllllIlllllIIIIIlIIllIIlIII, llllllllllIlllllIIIIIlIIllIIlllI);
        }
        
        static {
            NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 0.78125, 1.0);
            SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.78125, 0.125);
            WEST_AABB = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 0.78125, 1.0);
            EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 0.78125, 1.0);
        }
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockState llllllllllIlllllIIIIIlIIllIllllI, final IBlockAccess llllllllllIlllllIIIIIlIIllIlllIl, final BlockPos llllllllllIlllllIIIIIlIIllIlllII) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllIlllllIIIIIlIIllIllllI.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING).ordinal()]) {
                default: {
                    return BlockBannerHanging.NORTH_AABB;
                }
                case 4: {
                    return BlockBannerHanging.SOUTH_AABB;
                }
                case 5: {
                    return BlockBannerHanging.WEST_AABB;
                }
                case 6: {
                    return BlockBannerHanging.EAST_AABB;
                }
            }
        }
        
        @Override
        protected BlockStateContainer createBlockState() {
            return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBannerHanging.FACING });
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockBannerHanging.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final float llllllllllIlllllIIIIIlIIlIllIlII = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllIlllllIIIIIlIIlIllIlII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return BlockBannerHanging.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllIlllllIIIIIlIIlIllIlII;
        }
        
        @Override
        public IBlockState withMirror(final IBlockState llllllllllIlllllIIIIIlIIlllIIlII, final Mirror llllllllllIlllllIIIIIlIIlllIIIll) {
            return llllllllllIlllllIIIIIlIIlllIIlII.withRotation(llllllllllIlllllIIIIIlIIlllIIIll.toRotation(llllllllllIlllllIIIIIlIIlllIIlII.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING)));
        }
        
        @Override
        public IBlockState withRotation(final IBlockState llllllllllIlllllIIIIIlIIlllIlIll, final Rotation llllllllllIlllllIIIIIlIIlllIlIII) {
            return llllllllllIlllllIIIIIlIIlllIlIll.withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, llllllllllIlllllIIIIIlIIlllIlIII.rotate(llllllllllIlllllIIIIIlIIlllIlIll.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING)));
        }
        
        @Override
        public int getMetaFromState(final IBlockState llllllllllIlllllIIIIIlIIlIlllIlI) {
            return llllllllllIlllllIIIIIlIIlIlllIlI.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING).getIndex();
        }
        
        @Override
        public IBlockState getStateFromMeta(final int llllllllllIlllllIIIIIlIIllIIIIIl) {
            EnumFacing llllllllllIlllllIIIIIlIIllIIIIII = EnumFacing.getFront(llllllllllIlllllIIIIIlIIllIIIIIl);
            if (llllllllllIlllllIIIIIlIIllIIIIII.getAxis() == EnumFacing.Axis.Y) {
                llllllllllIlllllIIIIIlIIllIIIIII = EnumFacing.NORTH;
            }
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, llllllllllIlllllIIIIIlIIllIIIIII);
        }
        
        public BlockBannerHanging() {
            this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, EnumFacing.NORTH));
        }
    }
    
    public static class BlockBannerStanding extends BlockBanner
    {
        @Override
        public void neighborChanged(final IBlockState lllllllllllllIIIlllIIlIlIlIIIlII, final World lllllllllllllIIIlllIIlIlIlIIIIll, final BlockPos lllllllllllllIIIlllIIlIlIIllllII, final Block lllllllllllllIIIlllIIlIlIlIIIIIl, final BlockPos lllllllllllllIIIlllIIlIlIIlllIlI) {
            if (!lllllllllllllIIIlllIIlIlIlIIIIll.getBlockState(lllllllllllllIIIlllIIlIlIIllllII.down()).getMaterial().isSolid()) {
                this.dropBlockAsItem(lllllllllllllIIIlllIIlIlIlIIIIll, lllllllllllllIIIlllIIlIlIIllllII, lllllllllllllIIIlllIIlIlIlIIIlII, 0);
                lllllllllllllIIIlllIIlIlIlIIIIll.setBlockToAir(lllllllllllllIIIlllIIlIlIIllllII);
            }
            super.neighborChanged(lllllllllllllIIIlllIIlIlIlIIIlII, lllllllllllllIIIlllIIlIlIlIIIIll, lllllllllllllIIIlllIIlIlIIllllII, lllllllllllllIIIlllIIlIlIlIIIIIl, lllllllllllllIIIlllIIlIlIIlllIlI);
        }
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIlllIIlIlIlIlllII, final IBlockAccess lllllllllllllIIIlllIIlIlIlIllIll, final BlockPos lllllllllllllIIIlllIIlIlIlIllIlI) {
            return BlockBannerStanding.STANDING_AABB;
        }
        
        public BlockBannerStanding() {
            this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, 0));
        }
        
        @Override
        public IBlockState withMirror(final IBlockState lllllllllllllIIIlllIIlIlIlIIllll, final Mirror lllllllllllllIIIlllIIlIlIlIIlllI) {
            return lllllllllllllIIIlllIIlIlIlIIllll.withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIIlllIIlIlIlIIlllI.mirrorRotation(lllllllllllllIIIlllIIlIlIlIIllll.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION), 16));
        }
        
        @Override
        public int getMetaFromState(final IBlockState lllllllllllllIIIlllIIlIlIIllIIIl) {
            return lllllllllllllIIIlllIIlIlIIllIIIl.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION);
        }
        
        @Override
        public IBlockState getStateFromMeta(final int lllllllllllllIIIlllIIlIlIIllIlII) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIIlllIIlIlIIllIlII);
        }
        
        @Override
        protected BlockStateContainer createBlockState() {
            return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBannerStanding.ROTATION });
        }
        
        @Override
        public IBlockState withRotation(final IBlockState lllllllllllllIIIlllIIlIlIlIlIlII, final Rotation lllllllllllllIIIlllIIlIlIlIlIIll) {
            return lllllllllllllIIIlllIIlIlIlIlIlII.withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIIlllIIlIlIlIlIIll.rotate(lllllllllllllIIIlllIIlIlIlIlIlII.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION), 16));
        }
    }
}
