// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.ItemLead;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.util.Mirror;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockFence extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ AxisAlignedBB PILLAR_AABB;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] BOUNDING_BOXES;
    public static final /* synthetic */ AxisAlignedBB WEST_AABB;
    public static final /* synthetic */ PropertyBool NORTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ AxisAlignedBB EAST_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    public static final /* synthetic */ PropertyBool WEST;
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIlIIlIllIlIlllIlllI) {
        return false;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIIIlIIlIllIlIlllIlIlI, final BlockPos lllllllllllIIIlIIlIllIlIlllIlIIl) {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIIIlIIlIllIlIllIIllII, final IBlockAccess lllllllllllIIIlIIlIllIlIllIIlIll, final BlockPos lllllllllllIIIlIIlIllIlIllIIlIlI, final EnumFacing lllllllllllIIIlIIlIllIlIllIIlIIl) {
        return true;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIIlIIlIllIlIlIlIIIlI, final Rotation lllllllllllIIIlIIlIllIlIlIlIIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIIIlIIlIllIlIlIlIIIIl.ordinal()]) {
            case 3: {
                return lllllllllllIIIlIIlIllIlIlIlIIIlI.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.NORTH)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.EAST));
            }
            case 4: {
                return lllllllllllIIIlIIlIllIlIlIlIIIlI.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.EAST)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.NORTH));
            }
            case 2: {
                return lllllllllllIIIlIIlIllIlIlIlIIIlI.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.NORTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.EAST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)lllllllllllIIIlIIlIllIlIlIlIIIlI.getValue((IProperty<V>)BlockFence.SOUTH));
            }
            default: {
                return lllllllllllIIIlIIlIllIlIlIlIIIlI;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockFence.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllIIIlIIlIllIlIlIIIlIlI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockFence.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIIIlIIlIllIlIlIIIlIlI;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIIlIIlIllIlIlIIllIlI, final Mirror lllllllllllIIIlIIlIllIlIlIIllIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllIIIlIIlIllIlIlIIllIIl.ordinal()]) {
            case 2: {
                return lllllllllllIIIlIIlIllIlIlIIllIlI.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)lllllllllllIIIlIIlIllIlIlIIllIlI.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)lllllllllllIIIlIIlIllIlIlIIllIlI.getValue((IProperty<V>)BlockFence.NORTH));
            }
            case 3: {
                return lllllllllllIIIlIIlIllIlIlIIllIlI.withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)lllllllllllIIIlIIlIllIlIlIIllIlI.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)lllllllllllIIIlIIlIllIlIlIIllIlI.getValue((IProperty<V>)BlockFence.EAST));
            }
            default: {
                return super.withMirror(lllllllllllIIIlIIlIllIlIlIIllIlI, lllllllllllIIIlIIlIllIlIlIIllIIl);
            }
        }
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllllllllllIIIlIIlIllIllIIIIIlll, final World lllllllllllIIIlIIlIllIllIIIIllIl, final BlockPos lllllllllllIIIlIIlIllIllIIIIllII, final AxisAlignedBB lllllllllllIIIlIIlIllIllIIIIlIll, final List<AxisAlignedBB> lllllllllllIIIlIIlIllIllIIIIlIlI, @Nullable final Entity lllllllllllIIIlIIlIllIllIIIIlIIl, final boolean lllllllllllIIIlIIlIllIllIIIIlIII) {
        if (!lllllllllllIIIlIIlIllIllIIIIlIII) {
            lllllllllllIIIlIIlIllIllIIIIIlll = lllllllllllIIIlIIlIllIllIIIIIlll.getActualState(lllllllllllIIIlIIlIllIllIIIIllIl, lllllllllllIIIlIIlIllIllIIIIllII);
        }
        Block.addCollisionBoxToList(lllllllllllIIIlIIlIllIllIIIIllII, lllllllllllIIIlIIlIllIllIIIIlIll, lllllllllllIIIlIIlIllIllIIIIlIlI, BlockFence.PILLAR_AABB);
        if (lllllllllllIIIlIIlIllIllIIIIIlll.getValue((IProperty<Boolean>)BlockFence.NORTH)) {
            Block.addCollisionBoxToList(lllllllllllIIIlIIlIllIllIIIIllII, lllllllllllIIIlIIlIllIllIIIIlIll, lllllllllllIIIlIIlIllIllIIIIlIlI, BlockFence.NORTH_AABB);
        }
        if (lllllllllllIIIlIIlIllIllIIIIIlll.getValue((IProperty<Boolean>)BlockFence.EAST)) {
            Block.addCollisionBoxToList(lllllllllllIIIlIIlIllIllIIIIllII, lllllllllllIIIlIIlIllIllIIIIlIll, lllllllllllIIIlIIlIllIllIIIIlIlI, BlockFence.EAST_AABB);
        }
        if (lllllllllllIIIlIIlIllIllIIIIIlll.getValue((IProperty<Boolean>)BlockFence.SOUTH)) {
            Block.addCollisionBoxToList(lllllllllllIIIlIIlIllIllIIIIllII, lllllllllllIIIlIIlIllIllIIIIlIll, lllllllllllIIIlIIlIllIllIIIIlIlI, BlockFence.SOUTH_AABB);
        }
        if (lllllllllllIIIlIIlIllIllIIIIIlll.getValue((IProperty<Boolean>)BlockFence.WEST)) {
            Block.addCollisionBoxToList(lllllllllllIIIlIIlIllIllIIIIllII, lllllllllllIIIlIIlIllIllIIIIlIll, lllllllllllIIIlIIlIllIllIIIIlIlI, BlockFence.WEST_AABB);
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllIIIlIIlIllIlIlllllIII, final IBlockAccess lllllllllllIIIlIIlIllIlIllllIlll, final BlockPos lllllllllllIIIlIIlIllIlIllllIllI) {
        lllllllllllIIIlIIlIllIlIlllllIII = (int)this.getActualState((IBlockState)lllllllllllIIIlIIlIllIlIlllllIII, lllllllllllIIIlIIlIllIlIllllIlll, lllllllllllIIIlIIlIllIlIllllIllI);
        return BlockFence.BOUNDING_BOXES[getBoundingBoxIdx((IBlockState)lllllllllllIIIlIIlIllIlIlllllIII)];
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIIlIIlIllIlIlIlIlIII, final IBlockAccess lllllllllllIIIlIIlIllIlIlIlIlIll, final BlockPos lllllllllllIIIlIIlIllIlIlIlIlIlI) {
        return lllllllllllIIIlIIlIllIlIlIlIlIII.withProperty((IProperty<Comparable>)BlockFence.NORTH, this.canConnectTo(lllllllllllIIIlIIlIllIlIlIlIlIll, lllllllllllIIIlIIlIllIlIlIlIlIlI.north(), EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.EAST, this.canConnectTo(lllllllllllIIIlIIlIllIlIlIlIlIll, lllllllllllIIIlIIlIllIlIlIlIlIlI.east(), EnumFacing.WEST)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, this.canConnectTo(lllllllllllIIIlIIlIllIlIlIlIlIll, lllllllllllIIIlIIlIllIlIlIlIlIlI.south(), EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockFence.WEST, this.canConnectTo(lllllllllllIIIlIIlIllIlIlIlIlIll, lllllllllllIIIlIIlIllIlIlIlIlIlI.west(), EnumFacing.EAST));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFence.NORTH, BlockFence.EAST, BlockFence.WEST, BlockFence.SOUTH });
    }
    
    public boolean canConnectTo(final IBlockAccess lllllllllllIIIlIIlIllIlIllIlIlll, final BlockPos lllllllllllIIIlIIlIllIlIllIlIllI, final EnumFacing lllllllllllIIIlIIlIllIlIllIlIlIl) {
        final IBlockState lllllllllllIIIlIIlIllIlIllIlllII = lllllllllllIIIlIIlIllIlIllIlIlll.getBlockState(lllllllllllIIIlIIlIllIlIllIlIllI);
        final BlockFaceShape lllllllllllIIIlIIlIllIlIllIllIll = lllllllllllIIIlIIlIllIlIllIlllII.func_193401_d(lllllllllllIIIlIIlIllIlIllIlIlll, lllllllllllIIIlIIlIllIlIllIlIllI, lllllllllllIIIlIIlIllIlIllIlIlIl);
        final Block lllllllllllIIIlIIlIllIlIllIllIlI = lllllllllllIIIlIIlIllIlIllIlllII.getBlock();
        final boolean lllllllllllIIIlIIlIllIlIllIllIIl = lllllllllllIIIlIIlIllIlIllIllIll == BlockFaceShape.MIDDLE_POLE && (lllllllllllIIIlIIlIllIlIllIlllII.getMaterial() == this.blockMaterial || lllllllllllIIIlIIlIllIlIllIllIlI instanceof BlockFenceGate);
        return (!func_194142_e(lllllllllllIIIlIIlIllIlIllIllIlI) && lllllllllllIIIlIIlIllIlIllIllIll == BlockFaceShape.SOLID) || lllllllllllIIIlIIlIllIlIllIllIIl;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIlIIlIllIlIlIIlIIII, final IBlockState lllllllllllIIIlIIlIllIlIlIIIllll, final BlockPos lllllllllllIIIlIIlIllIlIlIIIlllI, final EnumFacing lllllllllllIIIlIIlIllIlIlIIIllIl) {
        return (lllllllllllIIIlIIlIllIlIlIIIllIl != EnumFacing.UP && lllllllllllIIIlIIlIllIlIlIIIllIl != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE : BlockFaceShape.CENTER;
    }
    
    private static int getBoundingBoxIdx(final IBlockState lllllllllllIIIlIIlIllIlIllllIIll) {
        int lllllllllllIIIlIIlIllIlIllllIIlI = 0;
        if (lllllllllllIIIlIIlIllIlIllllIIll.getValue((IProperty<Boolean>)BlockFence.NORTH)) {
            lllllllllllIIIlIIlIllIlIllllIIlI |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (lllllllllllIIIlIIlIllIlIllllIIll.getValue((IProperty<Boolean>)BlockFence.EAST)) {
            lllllllllllIIIlIIlIllIlIllllIIlI |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (lllllllllllIIIlIIlIllIlIllllIIll.getValue((IProperty<Boolean>)BlockFence.SOUTH)) {
            lllllllllllIIIlIIlIllIlIllllIIlI |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (lllllllllllIIIlIIlIllIlIllllIIll.getValue((IProperty<Boolean>)BlockFence.WEST)) {
            lllllllllllIIIlIIlIllIlIllllIIlI |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return lllllllllllIIIlIIlIllIlIllllIIlI;
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        BOUNDING_BOXES = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.375, 0.625, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.375, 0.625, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.625, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.0, 0.625, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.375, 1.0, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.0, 1.0, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
        PILLAR_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.5, 0.625);
        SOUTH_AABB = new AxisAlignedBB(0.375, 0.0, 0.625, 0.625, 1.5, 1.0);
        WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.375, 0.375, 1.5, 0.625);
        NORTH_AABB = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.5, 0.375);
        EAST_AABB = new AxisAlignedBB(0.625, 0.0, 0.375, 1.0, 1.5, 0.625);
    }
    
    public BlockFence(final Material lllllllllllIIIlIIlIllIllIIIllIlI, final MapColor lllllllllllIIIlIIlIllIllIIIlIllI) {
        super(lllllllllllIIIlIIlIllIllIIIllIlI, lllllllllllIIIlIIlIllIllIIIlIllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFence.NORTH, false).withProperty((IProperty<Comparable>)BlockFence.EAST, false).withProperty((IProperty<Comparable>)BlockFence.SOUTH, false).withProperty((IProperty<Comparable>)BlockFence.WEST, false));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIIlIllIlIlIllIIlI) {
        return 0;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIlIIlIllIlIllIIIIlI, final BlockPos lllllllllllIIIlIIlIllIlIlIllIlll, final IBlockState lllllllllllIIIlIIlIllIlIllIIIIII, final EntityPlayer lllllllllllIIIlIIlIllIlIlIllllll, final EnumHand lllllllllllIIIlIIlIllIlIlIllIlIl, final EnumFacing lllllllllllIIIlIIlIllIlIlIllllIl, final float lllllllllllIIIlIIlIllIlIlIllllII, final float lllllllllllIIIlIIlIllIlIlIlllIll, final float lllllllllllIIIlIIlIllIlIlIlllIlI) {
        if (!lllllllllllIIIlIIlIllIlIllIIIIlI.isRemote) {
            return ItemLead.attachToFence(lllllllllllIIIlIIlIllIlIlIllllll, lllllllllllIIIlIIlIllIlIllIIIIlI, lllllllllllIIIlIIlIllIlIlIllIlll);
        }
        final ItemStack lllllllllllIIIlIIlIllIlIlIlllIIl = lllllllllllIIIlIIlIllIlIlIllllll.getHeldItem(lllllllllllIIIlIIlIllIlIlIllIlIl);
        return lllllllllllIIIlIIlIllIlIlIlllIIl.getItem() == Items.LEAD || lllllllllllIIIlIIlIllIlIlIlllIIl.func_190926_b();
    }
    
    protected static boolean func_194142_e(final Block lllllllllllIIIlIIlIllIlIllIIlllI) {
        return Block.func_193382_c(lllllllllllIIIlIIlIllIlIllIIlllI) || lllllllllllIIIlIIlIllIlIllIIlllI == Blocks.BARRIER || lllllllllllIIIlIIlIllIlIllIIlllI == Blocks.MELON_BLOCK || lllllllllllIIIlIIlIllIlIllIIlllI == Blocks.PUMPKIN || lllllllllllIIIlIIlIllIlIllIIlllI == Blocks.LIT_PUMPKIN;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockFence.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception lllllllllllIIIlIIlIllIlIlIIIlIII = (Object)new int[Mirror.values().length];
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIlIIlIllIlIlIIIlIII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockFence.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIIIlIIlIllIlIlIIIlIII;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIlIIlIllIlIlllIllII) {
        return false;
    }
}
