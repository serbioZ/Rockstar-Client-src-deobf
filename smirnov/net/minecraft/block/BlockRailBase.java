// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.IStringSerializable;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class BlockRailBase extends Block
{
    protected final /* synthetic */ boolean isPowered;
    protected static final /* synthetic */ AxisAlignedBB field_190959_b;
    protected static final /* synthetic */ AxisAlignedBB FLAT_AABB;
    
    protected IBlockState updateDir(final World lllllllllllIIlIlIIIIlIIIIIIIlIII, final BlockPos lllllllllllIIlIlIIIIlIIIIIIIIlll, final IBlockState lllllllllllIIlIlIIIIlIIIIIIIlIll, final boolean lllllllllllIIlIlIIIIlIIIIIIIIlIl) {
        return lllllllllllIIlIlIIIIlIIIIIIIlIII.isRemote ? lllllllllllIIlIlIIIIlIIIIIIIlIll : new Rail(lllllllllllIIlIlIIIIlIIIIIIIlIII, lllllllllllIIlIlIIIIlIIIIIIIIlll, lllllllllllIIlIlIIIIlIIIIIIIlIll).place(lllllllllllIIlIlIIIIlIIIIIIIlIII.isBlockPowered(lllllllllllIIlIlIIIIlIIIIIIIIlll), lllllllllllIIlIlIIIIlIIIIIIIIlIl).getBlockState();
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIIlIlIIIIlIIIIlIllIII, final IBlockAccess lllllllllllIIlIlIIIIlIIIIlIlIlll, final BlockPos lllllllllllIIlIlIIIIlIIIIlIlIllI) {
        return BlockRailBase.NULL_AABB;
    }
    
    protected void updateState(final IBlockState lllllllllllIIlIlIIIIlIIIIIIlIlll, final World lllllllllllIIlIlIIIIlIIIIIIlIllI, final BlockPos lllllllllllIIlIlIIIIlIIIIIIlIlIl, final Block lllllllllllIIlIlIIIIlIIIIIIlIlII) {
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIIlIlIIIIlIIIIIllIlIl, final BlockPos lllllllllllIIlIlIIIIlIIIIIllIlII, IBlockState lllllllllllIIlIlIIIIlIIIIIlIllll) {
        if (!lllllllllllIIlIlIIIIlIIIIIllIlIl.isRemote) {
            lllllllllllIIlIlIIIIlIIIIIlIllll = this.updateDir(lllllllllllIIlIlIIIIlIIIIIllIlIl, lllllllllllIIlIlIIIIlIIIIIllIlII, lllllllllllIIlIlIIIIlIIIIIlIllll, true);
            if (this.isPowered) {
                lllllllllllIIlIlIIIIlIIIIIlIllll.neighborChanged(lllllllllllIIlIlIIIIlIIIIIllIlIl, lllllllllllIIlIlIIIIlIIIIIllIlII, this, lllllllllllIIlIlIIIIlIIIIIllIlII);
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIlIIIIlIIIIlIIIIlI) {
        return false;
    }
    
    protected BlockRailBase(final boolean lllllllllllIIlIlIIIIlIIIIlIlllII) {
        super(Material.CIRCUITS);
        this.isPowered = lllllllllllIIlIlIIIIlIIIIlIlllII;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIlIIIIlIIIIlIIIlll, final IBlockState lllllllllllIIlIlIIIIlIIIIlIIIllI, final BlockPos lllllllllllIIlIlIIIIlIIIIlIIIlIl, final EnumFacing lllllllllllIIlIlIIIIlIIIIlIIIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllIIlIlIIIIlIIIIIIIIIll) {
        return EnumPushReaction.NORMAL;
    }
    
    static {
        FLAT_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
        field_190959_b = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIlIlIIIIlIIIIIlllllI, final BlockPos lllllllllllIIlIlIIIIlIIIIIlllIll) {
        return lllllllllllIIlIlIIIIlIIIIIlllllI.getBlockState(lllllllllllIIlIlIIIIlIIIIIlllIll.down()).isFullyOpaque();
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIlIlIIIIlIIIIIlIIllI, final World lllllllllllIIlIlIIIIlIIIIIlIIlIl, final BlockPos lllllllllllIIlIlIIIIlIIIIIlIIlII, final Block lllllllllllIIlIlIIIIlIIIIIIllIll, final BlockPos lllllllllllIIlIlIIIIlIIIIIlIIIlI) {
        if (!lllllllllllIIlIlIIIIlIIIIIlIIlIl.isRemote) {
            final EnumRailDirection lllllllllllIIlIlIIIIlIIIIIlIIIIl = lllllllllllIIlIlIIIIlIIIIIlIIllI.getValue(this.getShapeProperty());
            boolean lllllllllllIIlIlIIIIlIIIIIlIIIII = false;
            if (!lllllllllllIIlIlIIIIlIIIIIlIIlIl.getBlockState(lllllllllllIIlIlIIIIlIIIIIlIIlII.down()).isFullyOpaque()) {
                lllllllllllIIlIlIIIIlIIIIIlIIIII = true;
            }
            if (lllllllllllIIlIlIIIIlIIIIIlIIIIl == EnumRailDirection.ASCENDING_EAST && !lllllllllllIIlIlIIIIlIIIIIlIIlIl.getBlockState(lllllllllllIIlIlIIIIlIIIIIlIIlII.east()).isFullyOpaque()) {
                lllllllllllIIlIlIIIIlIIIIIlIIIII = true;
            }
            else if (lllllllllllIIlIlIIIIlIIIIIlIIIIl == EnumRailDirection.ASCENDING_WEST && !lllllllllllIIlIlIIIIlIIIIIlIIlIl.getBlockState(lllllllllllIIlIlIIIIlIIIIIlIIlII.west()).isFullyOpaque()) {
                lllllllllllIIlIlIIIIlIIIIIlIIIII = true;
            }
            else if (lllllllllllIIlIlIIIIlIIIIIlIIIIl == EnumRailDirection.ASCENDING_NORTH && !lllllllllllIIlIlIIIIlIIIIIlIIlIl.getBlockState(lllllllllllIIlIlIIIIlIIIIIlIIlII.north()).isFullyOpaque()) {
                lllllllllllIIlIlIIIIlIIIIIlIIIII = true;
            }
            else if (lllllllllllIIlIlIIIIlIIIIIlIIIIl == EnumRailDirection.ASCENDING_SOUTH && !lllllllllllIIlIlIIIIlIIIIIlIIlIl.getBlockState(lllllllllllIIlIlIIIIlIIIIIlIIlII.south()).isFullyOpaque()) {
                lllllllllllIIlIlIIIIlIIIIIlIIIII = true;
            }
            if (lllllllllllIIlIlIIIIlIIIIIlIIIII && !lllllllllllIIlIlIIIIlIIIIIlIIlIl.isAirBlock(lllllllllllIIlIlIIIIlIIIIIlIIlII)) {
                this.dropBlockAsItem(lllllllllllIIlIlIIIIlIIIIIlIIlIl, lllllllllllIIlIlIIIIlIIIIIlIIlII, lllllllllllIIlIlIIIIlIIIIIlIIllI, 0);
                lllllllllllIIlIlIIIIlIIIIIlIIlIl.setBlockToAir(lllllllllllIIlIlIIIIlIIIIIlIIlII);
            }
            else {
                this.updateState(lllllllllllIIlIlIIIIlIIIIIlIIllI, lllllllllllIIlIlIIIIlIIIIIlIIlIl, lllllllllllIIlIlIIIIlIIIIIlIIlII, lllllllllllIIlIlIIIIlIIIIIIllIll);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIlIIIIlIIIIlIIllll, final IBlockAccess lllllllllllIIlIlIIIIlIIIIlIIlllI, final BlockPos lllllllllllIIlIlIIIIlIIIIlIIllIl) {
        final EnumRailDirection lllllllllllIIlIlIIIIlIIIIlIIllII = (lllllllllllIIlIlIIIIlIIIIlIIllll.getBlock() == this) ? lllllllllllIIlIlIIIIlIIIIlIIllll.getValue(this.getShapeProperty()) : null;
        return (lllllllllllIIlIlIIIIlIIIIlIIllII != null && lllllllllllIIlIlIIIIlIIIIlIIllII.isAscending()) ? BlockRailBase.field_190959_b : BlockRailBase.FLAT_AABB;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIlIlIIIIIlllllllllII, final BlockPos lllllllllllIIlIlIIIIIlllllllIlll, final IBlockState lllllllllllIIlIlIIIIIllllllllIlI) {
        super.breakBlock(lllllllllllIIlIlIIIIIlllllllllII, lllllllllllIIlIlIIIIIlllllllIlll, lllllllllllIIlIlIIIIIllllllllIlI);
        if (lllllllllllIIlIlIIIIIllllllllIlI.getValue(this.getShapeProperty()).isAscending()) {
            lllllllllllIIlIlIIIIIlllllllllII.notifyNeighborsOfStateChange(lllllllllllIIlIlIIIIIlllllllIlll.up(), this, false);
        }
        if (this.isPowered) {
            lllllllllllIIlIlIIIIIlllllllllII.notifyNeighborsOfStateChange(lllllllllllIIlIlIIIIIlllllllIlll, this, false);
            lllllllllllIIlIlIIIIIlllllllllII.notifyNeighborsOfStateChange(lllllllllllIIlIlIIIIIlllllllIlll.down(), this, false);
        }
    }
    
    public abstract IProperty<EnumRailDirection> getShapeProperty();
    
    public static boolean isRailBlock(final World lllllllllllIIlIlIIIIlIIIIllIIlll, final BlockPos lllllllllllIIlIlIIIIlIIIIllIlIII) {
        return isRailBlock(lllllllllllIIlIlIIIIlIIIIllIIlll.getBlockState(lllllllllllIIlIlIIIIlIIIIllIlIII));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIlIIIIlIIIIlIlIlII) {
        return false;
    }
    
    public static boolean isRailBlock(final IBlockState lllllllllllIIlIlIIIIlIIIIllIIIll) {
        final Block lllllllllllIIlIlIIIIlIIIIllIIIlI = lllllllllllIIlIlIIIIlIIIIllIIIll.getBlock();
        return lllllllllllIIlIlIIIIlIIIIllIIIlI == Blocks.RAIL || lllllllllllIIlIlIIIIlIIIIllIIIlI == Blocks.GOLDEN_RAIL || lllllllllllIIlIlIIIIlIIIIllIIIlI == Blocks.DETECTOR_RAIL || lllllllllllIIlIlIIIIlIIIIllIIIlI == Blocks.ACTIVATOR_RAIL;
    }
    
    public enum EnumRailDirection implements IStringSerializable
    {
        NORTH_EAST("NORTH_EAST", 9, 9, "north_east"), 
        NORTH_WEST("NORTH_WEST", 8, 8, "north_west");
        
        private final /* synthetic */ String name;
        
        ASCENDING_EAST("ASCENDING_EAST", 2, 2, "ascending_east");
        
        private static final /* synthetic */ EnumRailDirection[] META_LOOKUP;
        
        ASCENDING_WEST("ASCENDING_WEST", 3, 3, "ascending_west"), 
        ASCENDING_NORTH("ASCENDING_NORTH", 4, 4, "ascending_north"), 
        SOUTH_EAST("SOUTH_EAST", 6, 6, "south_east"), 
        EAST_WEST("EAST_WEST", 1, 1, "east_west");
        
        private final /* synthetic */ int meta;
        
        NORTH_SOUTH("NORTH_SOUTH", 0, 0, "north_south"), 
        SOUTH_WEST("SOUTH_WEST", 7, 7, "south_west"), 
        ASCENDING_SOUTH("ASCENDING_SOUTH", 5, 5, "ascending_south");
        
        static {
            META_LOOKUP = new EnumRailDirection[values().length];
            final double llllllllllllIllIIlIlIllllIlllIll;
            final short llllllllllllIllIIlIlIllllIllllII = (short)((EnumRailDirection[])(Object)(llllllllllllIllIIlIlIllllIlllIll = (double)(Object)values())).length;
            for (long llllllllllllIllIIlIlIllllIllllIl = 0; llllllllllllIllIIlIlIllllIllllIl < llllllllllllIllIIlIlIllllIllllII; ++llllllllllllIllIIlIlIllllIllllIl) {
                final EnumRailDirection llllllllllllIllIIlIlIllllIllllll = llllllllllllIllIIlIlIllllIlllIll[llllllllllllIllIIlIlIllllIllllIl];
                EnumRailDirection.META_LOOKUP[llllllllllllIllIIlIlIllllIllllll.getMetadata()] = llllllllllllIllIIlIlIllllIllllll;
            }
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public static EnumRailDirection byMetadata(int llllllllllllIllIIlIlIllllIlIIIlI) {
            if (llllllllllllIllIIlIlIllllIlIIIlI < 0 || llllllllllllIllIIlIlIllllIlIIIlI >= EnumRailDirection.META_LOOKUP.length) {
                llllllllllllIllIIlIlIllllIlIIIlI = 0;
            }
            return EnumRailDirection.META_LOOKUP[llllllllllllIllIIlIlIllllIlIIIlI];
        }
        
        private EnumRailDirection(final String llllllllllllIllIIlIlIllllIllIIIl, final int llllllllllllIllIIlIlIllllIllIIII, final int llllllllllllIllIIlIlIllllIlIllll, final String llllllllllllIllIIlIlIllllIlIlllI) {
            this.meta = llllllllllllIllIIlIlIllllIlIllll;
            this.name = llllllllllllIllIIlIlIllllIlIlllI;
        }
        
        public boolean isAscending() {
            return this == EnumRailDirection.ASCENDING_NORTH || this == EnumRailDirection.ASCENDING_EAST || this == EnumRailDirection.ASCENDING_SOUTH || this == EnumRailDirection.ASCENDING_WEST;
        }
    }
    
    public class Rail
    {
        private final /* synthetic */ BlockPos pos;
        private final /* synthetic */ World world;
        private final /* synthetic */ BlockRailBase block;
        private final /* synthetic */ boolean isPowered;
        private final /* synthetic */ List<BlockPos> connectedRails;
        private /* synthetic */ IBlockState state;
        
        private boolean hasRailAt(final BlockPos lllllllllllIIllIllllIIlllllIIlIl) {
            return BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllllIIlIl) || BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllllIIlIl.up()) || BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllllIIlIl.down());
        }
        
        private boolean hasNeighborRail(final BlockPos lllllllllllIIllIllllIIlllIIIlllI) {
            final Rail lllllllllllIIllIllllIIlllIIIllIl = this.findRailAt(lllllllllllIIllIllllIIlllIIIlllI);
            if (lllllllllllIIllIllllIIlllIIIllIl == null) {
                return false;
            }
            lllllllllllIIllIllllIIlllIIIllIl.removeSoftConnections();
            return lllllllllllIIllIllllIIlllIIIllIl.canConnectTo(this);
        }
        
        private boolean isConnectedToRail(final Rail lllllllllllIIllIllllIIllllIlIIll) {
            return this.isConnectedTo(lllllllllllIIllIllllIIllllIlIIll.pos);
        }
        
        public List<BlockPos> getConnectedRails() {
            return this.connectedRails;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
            final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = Rail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
            if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
                return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
            }
            final boolean lllllllllllIIllIllllIIllIlIllIll = (Object)new int[EnumRailDirection.values().length];
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.EAST_WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                lllllllllllIIllIllllIIllIlIllIll[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            return Rail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)lllllllllllIIllIllllIIllIlIllIll;
        }
        
        protected int countAdjacentRails() {
            int lllllllllllIIllIllllIIlllIllllll = 0;
            for (final EnumFacing lllllllllllIIllIllllIIlllIlllllI : EnumFacing.Plane.HORIZONTAL) {
                if (this.hasRailAt(this.pos.offset(lllllllllllIIllIllllIIlllIlllllI))) {
                    ++lllllllllllIIllIllllIIlllIllllll;
                }
            }
            return lllllllllllIIllIllllIIlllIllllll;
        }
        
        public Rail place(final boolean lllllllllllIIllIllllIIllIllllIlI, final boolean lllllllllllIIllIllllIIllIllllIIl) {
            final BlockPos lllllllllllIIllIllllIIllIllllIII = this.pos.north();
            final BlockPos lllllllllllIIllIllllIIllIlllIlll = this.pos.south();
            final BlockPos lllllllllllIIllIllllIIllIlllIllI = this.pos.west();
            final BlockPos lllllllllllIIllIllllIIllIlllIlIl = this.pos.east();
            final boolean lllllllllllIIllIllllIIllIlllIlII = this.hasNeighborRail(lllllllllllIIllIllllIIllIllllIII);
            final boolean lllllllllllIIllIllllIIllIlllIIll = this.hasNeighborRail(lllllllllllIIllIllllIIllIlllIlll);
            final boolean lllllllllllIIllIllllIIllIlllIIlI = this.hasNeighborRail(lllllllllllIIllIllllIIllIlllIllI);
            final boolean lllllllllllIIllIllllIIllIlllIIIl = this.hasNeighborRail(lllllllllllIIllIllllIIllIlllIlIl);
            EnumRailDirection lllllllllllIIllIllllIIllIlllIIII = null;
            if ((lllllllllllIIllIllllIIllIlllIlII || lllllllllllIIllIllllIIllIlllIIll) && !lllllllllllIIllIllllIIllIlllIIlI && !lllllllllllIIllIllllIIllIlllIIIl) {
                lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_SOUTH;
            }
            if ((lllllllllllIIllIllllIIllIlllIIlI || lllllllllllIIllIllllIIllIlllIIIl) && !lllllllllllIIllIllllIIllIlllIlII && !lllllllllllIIllIllllIIllIlllIIll) {
                lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (lllllllllllIIllIllllIIllIlllIIll && lllllllllllIIllIllllIIllIlllIIIl && !lllllllllllIIllIllllIIllIlllIlII && !lllllllllllIIllIllllIIllIlllIIlI) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllIIllIllllIIllIlllIIll && lllllllllllIIllIllllIIllIlllIIlI && !lllllllllllIIllIllllIIllIlllIlII && !lllllllllllIIllIllllIIllIlllIIIl) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllIIllIllllIIllIlllIlII && lllllllllllIIllIllllIIllIlllIIlI && !lllllllllllIIllIllllIIllIlllIIll && !lllllllllllIIllIllllIIllIlllIIIl) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllIIllIllllIIllIlllIlII && lllllllllllIIllIllllIIllIlllIIIl && !lllllllllllIIllIllllIIllIlllIIll && !lllllllllllIIllIllllIIllIlllIIlI) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllIIllIllllIIllIlllIIII == null) {
                if (lllllllllllIIllIllllIIllIlllIlII || lllllllllllIIllIllllIIllIlllIIll) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_SOUTH;
                }
                if (lllllllllllIIllIllllIIllIlllIIlI || lllllllllllIIllIllllIIllIlllIIIl) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.EAST_WEST;
                }
                if (!this.isPowered) {
                    if (lllllllllllIIllIllllIIllIllllIlI) {
                        if (lllllllllllIIllIllllIIllIlllIIll && lllllllllllIIllIllllIIllIlllIIIl) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_EAST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIIlI && lllllllllllIIllIllllIIllIlllIIll) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIIIl && lllllllllllIIllIllllIIllIlllIlII) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIlII && lllllllllllIIllIllllIIllIlllIIlI) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_WEST;
                        }
                    }
                    else {
                        if (lllllllllllIIllIllllIIllIlllIlII && lllllllllllIIllIllllIIllIlllIIlI) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_WEST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIIIl && lllllllllllIIllIllllIIllIlllIlII) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIIlI && lllllllllllIIllIllllIIllIlllIIll) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllIIllIllllIIllIlllIIll && lllllllllllIIllIllllIIllIlllIIIl) {
                            lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.SOUTH_EAST;
                        }
                    }
                }
            }
            if (lllllllllllIIllIllllIIllIlllIIII == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIllIllllIII.up())) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIllIlllIlll.up())) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllIIllIllllIIllIlllIIII == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIllIlllIlIl.up())) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIllIlllIllI.up())) {
                    lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllIIllIllllIIllIlllIIII == null) {
                lllllllllllIIllIllllIIllIlllIIII = EnumRailDirection.NORTH_SOUTH;
            }
            this.updateConnectedRails(lllllllllllIIllIllllIIllIlllIIII);
            this.state = this.state.withProperty(this.block.getShapeProperty(), lllllllllllIIllIllllIIllIlllIIII);
            if (lllllllllllIIllIllllIIllIllllIIl || this.world.getBlockState(this.pos) != this.state) {
                this.world.setBlockState(this.pos, this.state, 3);
                for (int lllllllllllIIllIllllIIllIllIllll = 0; lllllllllllIIllIllllIIllIllIllll < this.connectedRails.size(); ++lllllllllllIIllIllllIIllIllIllll) {
                    final Rail lllllllllllIIllIllllIIllIllIlllI = this.findRailAt(this.connectedRails.get(lllllllllllIIllIllllIIllIllIllll));
                    if (lllllllllllIIllIllllIIllIllIlllI != null) {
                        lllllllllllIIllIllllIIllIllIlllI.removeSoftConnections();
                        if (lllllllllllIIllIllllIIllIllIlllI.canConnectTo(this)) {
                            lllllllllllIIllIllllIIllIllIlllI.connectTo(this);
                        }
                    }
                }
            }
            return this;
        }
        
        private boolean canConnectTo(final Rail lllllllllllIIllIllllIIlllIllIlII) {
            return this.isConnectedToRail(lllllllllllIIllIllllIIlllIllIlII) || this.connectedRails.size() != 2;
        }
        
        private boolean isConnectedTo(final BlockPos lllllllllllIIllIllllIIllllIIIlll) {
            for (int lllllllllllIIllIllllIIllllIIlIlI = 0; lllllllllllIIllIllllIIllllIIlIlI < this.connectedRails.size(); ++lllllllllllIIllIllllIIllllIIlIlI) {
                final BlockPos lllllllllllIIllIllllIIllllIIlIIl = this.connectedRails.get(lllllllllllIIllIllllIIllllIIlIlI);
                if (lllllllllllIIllIllllIIllllIIlIIl.getX() == lllllllllllIIllIllllIIllllIIIlll.getX() && lllllllllllIIllIllllIIllllIIlIIl.getZ() == lllllllllllIIllIllllIIllllIIIlll.getZ()) {
                    return true;
                }
            }
            return false;
        }
        
        public IBlockState getBlockState() {
            return this.state;
        }
        
        private void removeSoftConnections() {
            for (int lllllllllllIIllIllllIIlllllIllIl = 0; lllllllllllIIllIllllIIlllllIllIl < this.connectedRails.size(); ++lllllllllllIIllIllllIIlllllIllIl) {
                final Rail lllllllllllIIllIllllIIlllllIllII = this.findRailAt(this.connectedRails.get(lllllllllllIIllIllllIIlllllIllIl));
                if (lllllllllllIIllIllllIIlllllIllII != null && lllllllllllIIllIllllIIlllllIllII.isConnectedToRail(this)) {
                    this.connectedRails.set(lllllllllllIIllIllllIIlllllIllIl, lllllllllllIIllIllllIIlllllIllII.pos);
                }
                else {
                    this.connectedRails.remove(lllllllllllIIllIllllIIlllllIllIl--);
                }
            }
        }
        
        public Rail(final World lllllllllllIIllIllllIlIIIIIIIlII, final BlockPos lllllllllllIIllIllllIIllllllllIl, final IBlockState lllllllllllIIllIllllIIllllllllII) {
            this.connectedRails = (List<BlockPos>)Lists.newArrayList();
            this.world = lllllllllllIIllIllllIlIIIIIIIlII;
            this.pos = lllllllllllIIllIllllIIllllllllIl;
            this.state = lllllllllllIIllIllllIIllllllllII;
            this.block = (BlockRailBase)lllllllllllIIllIllllIIllllllllII.getBlock();
            final EnumRailDirection lllllllllllIIllIllllIlIIIIIIIIIl = lllllllllllIIllIllllIIllllllllII.getValue(this.block.getShapeProperty());
            this.isPowered = this.block.isPowered;
            this.updateConnectedRails(lllllllllllIIllIllllIlIIIIIIIIIl);
        }
        
        @Nullable
        private Rail findRailAt(final BlockPos lllllllllllIIllIllllIIllllIllIIl) {
            IBlockState lllllllllllIIllIllllIIllllIlllII = this.world.getBlockState(lllllllllllIIllIllllIIllllIllIIl);
            if (BlockRailBase.isRailBlock(lllllllllllIIllIllllIIllllIlllII)) {
                return new Rail(this.world, lllllllllllIIllIllllIIllllIllIIl, lllllllllllIIllIllllIIllllIlllII);
            }
            BlockPos lllllllllllIIllIllllIIllllIllIll = lllllllllllIIllIllllIIllllIllIIl.up();
            lllllllllllIIllIllllIIllllIlllII = this.world.getBlockState(lllllllllllIIllIllllIIllllIllIll);
            if (BlockRailBase.isRailBlock(lllllllllllIIllIllllIIllllIlllII)) {
                return new Rail(this.world, lllllllllllIIllIllllIIllllIllIll, lllllllllllIIllIllllIIllllIlllII);
            }
            lllllllllllIIllIllllIIllllIllIll = lllllllllllIIllIllllIIllllIllIIl.down();
            lllllllllllIIllIllllIIllllIlllII = this.world.getBlockState(lllllllllllIIllIllllIIllllIllIll);
            return BlockRailBase.isRailBlock(lllllllllllIIllIllllIIllllIlllII) ? new Rail(this.world, lllllllllllIIllIllllIIllllIllIll, lllllllllllIIllIllllIIllllIlllII) : null;
        }
        
        private void updateConnectedRails(final EnumRailDirection lllllllllllIIllIllllIIllllllIIlI) {
            this.connectedRails.clear();
            switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllIIllIllllIIllllllIIlI.ordinal()]) {
                case 1: {
                    this.connectedRails.add(this.pos.north());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 2: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.east());
                    break;
                }
                case 3: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.east().up());
                    break;
                }
                case 4: {
                    this.connectedRails.add(this.pos.west().up());
                    this.connectedRails.add(this.pos.east());
                    break;
                }
                case 5: {
                    this.connectedRails.add(this.pos.north().up());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 6: {
                    this.connectedRails.add(this.pos.north());
                    this.connectedRails.add(this.pos.south().up());
                    break;
                }
                case 7: {
                    this.connectedRails.add(this.pos.east());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 8: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 9: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.north());
                    break;
                }
                case 10: {
                    this.connectedRails.add(this.pos.east());
                    this.connectedRails.add(this.pos.north());
                    break;
                }
            }
        }
        
        private void connectTo(final Rail lllllllllllIIllIllllIIlllIlIIlll) {
            this.connectedRails.add(lllllllllllIIllIllllIIlllIlIIlll.pos);
            final BlockPos lllllllllllIIllIllllIIlllIlIIllI = this.pos.north();
            final BlockPos lllllllllllIIllIllllIIlllIlIIlIl = this.pos.south();
            final BlockPos lllllllllllIIllIllllIIlllIlIIlII = this.pos.west();
            final BlockPos lllllllllllIIllIllllIIlllIlIIIll = this.pos.east();
            final boolean lllllllllllIIllIllllIIlllIlIIIlI = this.isConnectedTo(lllllllllllIIllIllllIIlllIlIIllI);
            final boolean lllllllllllIIllIllllIIlllIlIIIIl = this.isConnectedTo(lllllllllllIIllIllllIIlllIlIIlIl);
            final boolean lllllllllllIIllIllllIIlllIlIIIII = this.isConnectedTo(lllllllllllIIllIllllIIlllIlIIlII);
            final boolean lllllllllllIIllIllllIIlllIIlllll = this.isConnectedTo(lllllllllllIIllIllllIIlllIlIIIll);
            EnumRailDirection lllllllllllIIllIllllIIlllIIllllI = null;
            if (lllllllllllIIllIllllIIlllIlIIIlI || lllllllllllIIllIllllIIlllIlIIIIl) {
                lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.NORTH_SOUTH;
            }
            if (lllllllllllIIllIllllIIlllIlIIIII || lllllllllllIIllIllllIIlllIIlllll) {
                lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (lllllllllllIIllIllllIIlllIlIIIIl && lllllllllllIIllIllllIIlllIIlllll && !lllllllllllIIllIllllIIlllIlIIIlI && !lllllllllllIIllIllllIIlllIlIIIII) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllIIllIllllIIlllIlIIIIl && lllllllllllIIllIllllIIlllIlIIIII && !lllllllllllIIllIllllIIlllIlIIIlI && !lllllllllllIIllIllllIIlllIIlllll) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllIIllIllllIIlllIlIIIlI && lllllllllllIIllIllllIIlllIlIIIII && !lllllllllllIIllIllllIIlllIlIIIIl && !lllllllllllIIllIllllIIlllIIlllll) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllIIllIllllIIlllIlIIIlI && lllllllllllIIllIllllIIlllIIlllll && !lllllllllllIIllIllllIIlllIlIIIIl && !lllllllllllIIllIllllIIlllIlIIIII) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllIIllIllllIIlllIIllllI == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllIlIIllI.up())) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllIlIIlIl.up())) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllIIllIllllIIlllIIllllI == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllIlIIIll.up())) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllIIllIllllIIlllIlIIlII.up())) {
                    lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllIIllIllllIIlllIIllllI == null) {
                lllllllllllIIllIllllIIlllIIllllI = EnumRailDirection.NORTH_SOUTH;
            }
            this.state = this.state.withProperty(this.block.getShapeProperty(), lllllllllllIIllIllllIIlllIIllllI);
            this.world.setBlockState(this.pos, this.state, 3);
        }
    }
}
