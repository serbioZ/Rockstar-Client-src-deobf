// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.Mirror;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockPane extends Block
{
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool NORTH;
    protected static final /* synthetic */ AxisAlignedBB[] AABB_BY_INDEX;
    private final /* synthetic */ boolean canDrop;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool SOUTH;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockPane.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float llllllllllllIllIllIIIlIIlIlllIII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllIllIllIIIlIIlIlllIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllIllIIIlIIlIlllIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllIllIIIlIIlIlllIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllIllIIIlIIlIlllIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockPane.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllIllIllIIIlIIlIlllIII;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIllIllIIIlIIllllllll) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPane.NORTH, BlockPane.EAST, BlockPane.WEST, BlockPane.SOUTH });
    }
    
    protected static boolean func_193394_e(final Block llllllllllllIllIllIIIlIIllIllIIl) {
        return llllllllllllIllIllIIIlIIllIllIIl instanceof BlockShulkerBox || llllllllllllIllIllIIIlIIllIllIIl instanceof BlockLeaves || llllllllllllIllIllIIIlIIllIllIIl == Blocks.BEACON || llllllllllllIllIllIIIlIIllIllIIl == Blocks.CAULDRON || llllllllllllIllIllIIIlIIllIllIIl == Blocks.GLOWSTONE || llllllllllllIllIllIIIlIIllIllIIl == Blocks.ICE || llllllllllllIllIllIIIlIIllIllIIl == Blocks.SEA_LANTERN || llllllllllllIllIllIIIlIIllIllIIl == Blocks.PISTON || llllllllllllIllIllIIIlIIllIllIIl == Blocks.STICKY_PISTON || llllllllllllIllIllIIIlIIllIllIIl == Blocks.PISTON_HEAD || llllllllllllIllIllIIIlIIllIllIIl == Blocks.MELON_BLOCK || llllllllllllIllIllIIIlIIllIllIIl == Blocks.PUMPKIN || llllllllllllIllIllIIIlIIllIllIIl == Blocks.LIT_PUMPKIN || llllllllllllIllIllIIIlIIllIllIIl == Blocks.BARRIER;
    }
    
    private static int getBoundingBoxIndex(final EnumFacing llllllllllllIllIllIIIlIlIIlIllII) {
        return 1 << llllllllllllIllIllIIIlIlIIlIllII.getHorizontalIndex();
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        AABB_BY_INDEX = new AxisAlignedBB[] { new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.4375, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.4375, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.0, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.0, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.4375, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.4375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.4375, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.4375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.0, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    protected BlockPane(final Material llllllllllllIllIllIIIlIlIlIIlIII, final boolean llllllllllllIllIllIIIlIlIlIIIlll) {
        super(llllllllllllIllIllIIIlIlIlIIlIII);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPane.NORTH, false).withProperty((IProperty<Comparable>)BlockPane.EAST, false).withProperty((IProperty<Comparable>)BlockPane.SOUTH, false).withProperty((IProperty<Comparable>)BlockPane.WEST, false));
        this.canDrop = llllllllllllIllIllIIIlIlIlIIIlll;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIllIllIIIlIIllIlIIII, final Rotation llllllllllllIllIllIIIlIIllIIllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIllIllIIIlIIllIIllll.ordinal()]) {
            case 3: {
                return llllllllllllIllIllIIIlIIllIlIIII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.NORTH)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.EAST));
            }
            case 4: {
                return llllllllllllIllIllIIIlIIllIlIIII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.EAST)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.NORTH));
            }
            case 2: {
                return llllllllllllIllIllIIIlIIllIlIIII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.NORTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.EAST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)llllllllllllIllIllIIIlIIllIlIIII.getValue((IProperty<V>)BlockPane.SOUTH));
            }
            default: {
                return llllllllllllIllIllIIIlIIllIlIIII;
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIllIllIIIlIIllIlIlII) {
        return 0;
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState llllllllllllIllIllIIIlIlIIllIIll, final World llllllllllllIllIllIIIlIlIIllIIlI, final BlockPos llllllllllllIllIllIIIlIlIIlllIIl, final AxisAlignedBB llllllllllllIllIllIIIlIlIIllIIII, final List<AxisAlignedBB> llllllllllllIllIllIIIlIlIIlIllll, @Nullable final Entity llllllllllllIllIllIIIlIlIIllIllI, final boolean llllllllllllIllIllIIIlIlIIllIlIl) {
        if (!llllllllllllIllIllIIIlIlIIllIlIl) {
            llllllllllllIllIllIIIlIlIIllIIll = this.getActualState(llllllllllllIllIllIIIlIlIIllIIll, llllllllllllIllIllIIIlIlIIllIIlI, llllllllllllIllIllIIIlIlIIlllIIl);
        }
        Block.addCollisionBoxToList(llllllllllllIllIllIIIlIlIIlllIIl, llllllllllllIllIllIIIlIlIIllIIII, llllllllllllIllIllIIIlIlIIlIllll, BlockPane.AABB_BY_INDEX[0]);
        if (llllllllllllIllIllIIIlIlIIllIIll.getValue((IProperty<Boolean>)BlockPane.NORTH)) {
            Block.addCollisionBoxToList(llllllllllllIllIllIIIlIlIIlllIIl, llllllllllllIllIllIIIlIlIIllIIII, llllllllllllIllIllIIIlIlIIlIllll, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.NORTH)]);
        }
        if (llllllllllllIllIllIIIlIlIIllIIll.getValue((IProperty<Boolean>)BlockPane.SOUTH)) {
            Block.addCollisionBoxToList(llllllllllllIllIllIIIlIlIIlllIIl, llllllllllllIllIllIIIlIlIIllIIII, llllllllllllIllIllIIIlIlIIlIllll, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.SOUTH)]);
        }
        if (llllllllllllIllIllIIIlIlIIllIIll.getValue((IProperty<Boolean>)BlockPane.EAST)) {
            Block.addCollisionBoxToList(llllllllllllIllIllIIIlIlIIlllIIl, llllllllllllIllIllIIIlIlIIllIIII, llllllllllllIllIllIIIlIlIIlIllll, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.EAST)]);
        }
        if (llllllllllllIllIllIIIlIlIIllIIll.getValue((IProperty<Boolean>)BlockPane.WEST)) {
            Block.addCollisionBoxToList(llllllllllllIllIllIIIlIlIIlllIIl, llllllllllllIllIllIIIlIlIIllIIII, llllllllllllIllIllIIIlIlIIlIllll, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.WEST)]);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockPane.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final int llllllllllllIllIllIIIlIIlIllIllI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllIllIllIIIlIIlIllIllI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllIllIIIlIIlIllIllI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllIllIIIlIIlIllIllI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockPane.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllIllIllIIIlIIlIllIllI;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIllIllIIIlIIllllllIl) {
        return false;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllIllIllIIIlIlIIIIllll, final IBlockAccess llllllllllllIllIllIIIlIlIIIIlllI, final BlockPos llllllllllllIllIllIIIlIlIIIIllIl) {
        return llllllllllllIllIllIIIlIlIIIIllll.withProperty((IProperty<Comparable>)BlockPane.NORTH, this.func_193393_b(llllllllllllIllIllIIIlIlIIIIlllI, llllllllllllIllIllIIIlIlIIIIlllI.getBlockState(llllllllllllIllIllIIIlIlIIIIllIl.north()), llllllllllllIllIllIIIlIlIIIIllIl.north(), EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, this.func_193393_b(llllllllllllIllIllIIIlIlIIIIlllI, llllllllllllIllIllIIIlIlIIIIlllI.getBlockState(llllllllllllIllIllIIIlIlIIIIllIl.south()), llllllllllllIllIllIIIlIlIIIIllIl.south(), EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockPane.WEST, this.func_193393_b(llllllllllllIllIllIIIlIlIIIIlllI, llllllllllllIllIllIIIlIlIIIIlllI.getBlockState(llllllllllllIllIllIIIlIlIIIIllIl.west()), llllllllllllIllIllIIIlIlIIIIllIl.west(), EnumFacing.EAST)).withProperty((IProperty<Comparable>)BlockPane.EAST, this.func_193393_b(llllllllllllIllIllIIIlIlIIIIlllI, llllllllllllIllIllIIIlIlIIIIlllI.getBlockState(llllllllllllIllIllIIIlIlIIIIllIl.east()), llllllllllllIllIllIIIlIlIIIIllIl.east(), EnumFacing.WEST));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIllIllIIIlIIlIlllllI, final IBlockState llllllllllllIllIllIIIlIIlIllllIl, final BlockPos llllllllllllIllIllIIIlIIlIllllII, final EnumFacing llllllllllllIllIllIIIlIIlIlllIll) {
        return (llllllllllllIllIllIIIlIIlIlllIll != EnumFacing.UP && llllllllllllIllIllIIIlIIlIlllIll != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THIN : BlockFaceShape.CENTER_SMALL;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIllIllIIIlIlIIIIIIll, final Random llllllllllllIllIllIIIlIlIIIIIllI, final int llllllllllllIllIllIIIlIlIIIIIIIl) {
        return this.canDrop ? super.getItemDropped(llllllllllllIllIllIIIlIlIIIIIIll, llllllllllllIllIllIIIlIlIIIIIllI, llllllllllllIllIllIIIlIlIIIIIIIl) : Items.field_190931_a;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIllIllIIIlIIllIIIlIl, final Mirror llllllllllllIllIllIIIlIIllIIIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIllIllIIIlIIllIIIlII.ordinal()]) {
            case 2: {
                return llllllllllllIllIllIIIlIIllIIIlIl.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)llllllllllllIllIllIIIlIIllIIIlIl.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)llllllllllllIllIllIIIlIIllIIIlIl.getValue((IProperty<V>)BlockPane.NORTH));
            }
            case 3: {
                return llllllllllllIllIllIIIlIIllIIIlIl.withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)llllllllllllIllIllIIIlIIllIIIlIl.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)llllllllllllIllIllIIIlIIllIIIlIl.getValue((IProperty<V>)BlockPane.EAST));
            }
            default: {
                return super.withMirror(llllllllllllIllIllIIIlIIllIIIlIl, llllllllllllIllIllIIIlIIllIIIlII);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState llllllllllllIllIllIIIlIlIIlIIIIl, final IBlockAccess llllllllllllIllIllIIIlIlIIlIIlII, final BlockPos llllllllllllIllIllIIIlIlIIIlllll) {
        llllllllllllIllIllIIIlIlIIlIIIIl = (char)this.getActualState((IBlockState)llllllllllllIllIllIIIlIlIIlIIIIl, llllllllllllIllIllIIIlIlIIlIIlII, llllllllllllIllIllIIIlIlIIIlllll);
        return BlockPane.AABB_BY_INDEX[getBoundingBoxIndex((IBlockState)llllllllllllIllIllIIIlIlIIlIIIIl)];
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIllIllIIIlIIllllIIIl, final IBlockAccess llllllllllllIllIllIIIlIIllllIlIl, final BlockPos llllllllllllIllIllIIIlIIllllIlII, final EnumFacing llllllllllllIllIllIIIlIIlllIlllI) {
        return llllllllllllIllIllIIIlIIllllIlIl.getBlockState(llllllllllllIllIllIIIlIIllllIlII.offset(llllllllllllIllIllIIIlIIlllIlllI)).getBlock() != this && super.shouldSideBeRendered(llllllllllllIllIllIIIlIIllllIIIl, llllllllllllIllIllIIIlIIllllIlIl, llllllllllllIllIllIIIlIIllllIlII, llllllllllllIllIllIIIlIIlllIlllI);
    }
    
    public final boolean func_193393_b(final IBlockAccess llllllllllllIllIllIIIlIIlllIIllI, final IBlockState llllllllllllIllIllIIIlIIllIlllll, final BlockPos llllllllllllIllIllIIIlIIlllIIlII, final EnumFacing llllllllllllIllIllIIIlIIlllIIIll) {
        final Block llllllllllllIllIllIIIlIIlllIIIlI = llllllllllllIllIllIIIlIIllIlllll.getBlock();
        final BlockFaceShape llllllllllllIllIllIIIlIIlllIIIIl = llllllllllllIllIllIIIlIIllIlllll.func_193401_d(llllllllllllIllIllIIIlIIlllIIllI, llllllllllllIllIllIIIlIIlllIIlII, llllllllllllIllIllIIIlIIlllIIIll);
        return (!func_193394_e(llllllllllllIllIllIIIlIIlllIIIlI) && llllllllllllIllIllIIIlIIlllIIIIl == BlockFaceShape.SOLID) || llllllllllllIllIllIIIlIIlllIIIIl == BlockFaceShape.MIDDLE_POLE_THIN;
    }
    
    private static int getBoundingBoxIndex(final IBlockState llllllllllllIllIllIIIlIlIIIlllII) {
        int llllllllllllIllIllIIIlIlIIIllIll = 0;
        if (llllllllllllIllIllIIIlIlIIIlllII.getValue((IProperty<Boolean>)BlockPane.NORTH)) {
            llllllllllllIllIllIIIlIlIIIllIll |= getBoundingBoxIndex(EnumFacing.NORTH);
        }
        if (llllllllllllIllIllIIIlIlIIIlllII.getValue((IProperty<Boolean>)BlockPane.EAST)) {
            llllllllllllIllIllIIIlIlIIIllIll |= getBoundingBoxIndex(EnumFacing.EAST);
        }
        if (llllllllllllIllIllIIIlIlIIIlllII.getValue((IProperty<Boolean>)BlockPane.SOUTH)) {
            llllllllllllIllIllIIIlIlIIIllIll |= getBoundingBoxIndex(EnumFacing.SOUTH);
        }
        if (llllllllllllIllIllIIIlIlIIIlllII.getValue((IProperty<Boolean>)BlockPane.WEST)) {
            llllllllllllIllIllIIIlIlIIIllIll |= getBoundingBoxIndex(EnumFacing.WEST);
        }
        return llllllllllllIllIllIIIlIlIIIllIll;
    }
}
