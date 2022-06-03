// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.IBlockProperties;
import net.minecraft.util.BlockRenderLayer;
import java.util.Iterator;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.stats.StatList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockVine extends Block
{
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB UP_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyBool[] ALL_FACES;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool UP;
    public static final /* synthetic */ PropertyBool WEST;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool EAST;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIllIllllIIIllIllIlIIl, final Rotation lllllllllllIllIllllIIIllIllIlIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllIllIllllIIIllIllIlIII.ordinal()]) {
            case 3: {
                return lllllllllllIllIllllIIIllIllIlIIl.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.NORTH)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.EAST));
            }
            case 4: {
                return lllllllllllIllIllllIIIllIllIlIIl.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.EAST)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.NORTH));
            }
            case 2: {
                return lllllllllllIllIllllIIIllIllIlIIl.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.NORTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.EAST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lllllllllllIllIllllIIIllIllIlIIl.getValue((IProperty<V>)BlockVine.SOUTH));
            }
            default: {
                return lllllllllllIllIllllIIIllIllIlIIl;
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllIllllIIIlllllllIIl, final World lllllllllllIllIllllIIIlllllllIII, final BlockPos lllllllllllIllIllllIIIllllllIlll, final Block lllllllllllIllIllllIIIllllllIllI, final BlockPos lllllllllllIllIllllIIIllllllIlIl) {
        if (!lllllllllllIllIllllIIIlllllllIII.isRemote && !this.recheckGrownSides(lllllllllllIllIllllIIIlllllllIII, lllllllllllIllIllllIIIllllllIlll, lllllllllllIllIllllIIIlllllllIIl)) {
            this.dropBlockAsItem(lllllllllllIllIllllIIIlllllllIII, lllllllllllIllIllllIIIllllllIlll, lllllllllllIllIllllIIIlllllllIIl, 0);
            lllllllllllIllIllllIIIlllllllIII.setBlockToAir(lllllllllllIllIllllIIIllllllIlll);
        }
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllIllIllllIIlIIIlIIIlIl, final BlockPos lllllllllllIllIllllIIlIIIlIIIlII) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockVine.UP, BlockVine.NORTH, BlockVine.EAST, BlockVine.SOUTH, BlockVine.WEST });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIllIllllIIIllIllIIIll, final Mirror lllllllllllIllIllllIIIllIllIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllIllIllllIIIllIllIIIlI.ordinal()]) {
            case 2: {
                return lllllllllllIllIllllIIIllIllIIIll.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lllllllllllIllIllllIIIllIllIIIll.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lllllllllllIllIllllIIIllIllIIIll.getValue((IProperty<V>)BlockVine.NORTH));
            }
            case 3: {
                return lllllllllllIllIllllIIIllIllIIIll.withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lllllllllllIllIllllIIIllIllIIIll.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lllllllllllIllIllllIIIllIllIIIll.getValue((IProperty<V>)BlockVine.EAST));
            }
            default: {
                return super.withMirror(lllllllllllIllIllllIIIllIllIIIll, lllllllllllIllIllllIIIllIllIIIlI);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockVine.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final int lllllllllllIllIllllIIIllIlIIIIlI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIllIllllIIIllIlIIIIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIllIllllIIIllIlIIIIlI;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIllIllllIIIlllIIIllII, final EntityPlayer lllllllllllIllIllllIIIlllIIIlIll, final BlockPos lllllllllllIllIllllIIIlllIIIIIll, final IBlockState lllllllllllIllIllllIIIlllIIIlIIl, @Nullable final TileEntity lllllllllllIllIllllIIIlllIIIlIII, final ItemStack lllllllllllIllIllllIIIlllIIIIlll) {
        if (!lllllllllllIllIllllIIIlllIIIllII.isRemote && lllllllllllIllIllllIIIlllIIIIlll.getItem() == Items.SHEARS) {
            lllllllllllIllIllllIIIlllIIIlIll.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lllllllllllIllIllllIIIlllIIIllII, lllllllllllIllIllllIIIlllIIIIIll, new ItemStack(Blocks.VINE, 1, 0));
        }
        else {
            super.harvestBlock(lllllllllllIllIllllIIIlllIIIllII, lllllllllllIllIllllIIIlllIIIlIll, lllllllllllIllIllllIIIlllIIIIIll, lllllllllllIllIllllIIIlllIIIlIIl, lllllllllllIllIllllIIIlllIIIlIII, lllllllllllIllIllllIIIlllIIIIlll);
        }
    }
    
    public boolean func_193395_a(final World lllllllllllIllIllllIIlIIIIlIllII, final BlockPos lllllllllllIllIllllIIlIIIIlIlIll, final EnumFacing lllllllllllIllIllllIIlIIIIlIllll) {
        final Block lllllllllllIllIllllIIlIIIIlIlllI = lllllllllllIllIllllIIlIIIIlIllII.getBlockState(lllllllllllIllIllllIIlIIIIlIlIll.up()).getBlock();
        return this.func_193396_c(lllllllllllIllIllllIIlIIIIlIllII, lllllllllllIllIllllIIlIIIIlIlIll.offset(lllllllllllIllIllllIIlIIIIlIllll.getOpposite()), lllllllllllIllIllllIIlIIIIlIllll) && (lllllllllllIllIllllIIlIIIIlIlllI == Blocks.AIR || lllllllllllIllIllllIIlIIIIlIlllI == Blocks.VINE || this.func_193396_c(lllllllllllIllIllllIIlIIIIlIllII, lllllllllllIllIllllIIlIIIIlIlIll.up(), EnumFacing.UP));
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIllIllllIIIlllIIllIIl, final Random lllllllllllIllIllllIIIlllIIllIII, final int lllllllllllIllIllllIIIlllIIlIlll) {
        return Items.field_190931_a;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllIllIllllIIlIIIIlllllI, final BlockPos lllllllllllIllIllllIIlIIIIlllIIl, final EnumFacing lllllllllllIllIllllIIlIIIIllllII) {
        return lllllllllllIllIllllIIlIIIIllllII != EnumFacing.DOWN && lllllllllllIllIllllIIlIIIIllllII != EnumFacing.UP && this.func_193395_a(lllllllllllIllIllllIIlIIIIlllllI, lllllllllllIllIllllIIlIIIIlllIIl, lllllllllllIllIllllIIlIIIIllllII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIllIllllIIIllIlllIlIl) {
        int lllllllllllIllIllllIIIllIlllIlII = 0;
        if (lllllllllllIllIllllIIIllIlllIlIl.getValue((IProperty<Boolean>)BlockVine.SOUTH)) {
            lllllllllllIllIllllIIIllIlllIlII |= 0x1;
        }
        if (lllllllllllIllIllllIIIllIlllIlIl.getValue((IProperty<Boolean>)BlockVine.WEST)) {
            lllllllllllIllIllllIIIllIlllIlII |= 0x2;
        }
        if (lllllllllllIllIllllIIIllIlllIlIl.getValue((IProperty<Boolean>)BlockVine.NORTH)) {
            lllllllllllIllIllllIIIllIlllIlII |= 0x4;
        }
        if (lllllllllllIllIllllIIIllIlllIlIl.getValue((IProperty<Boolean>)BlockVine.EAST)) {
            lllllllllllIllIllllIIIllIlllIlII |= 0x8;
        }
        return lllllllllllIllIllllIIIllIlllIlII;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIllIllllIIIlllIIlIlIl) {
        return 0;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIllllIIlIIIlIIlIIl) {
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIllIllllIIIlllIlIIllI, final BlockPos lllllllllllIllIllllIIIlllIlIIlIl, final EnumFacing lllllllllllIllIllllIIIlllIIlllII, final float lllllllllllIllIllllIIIlllIlIIIll, final float lllllllllllIllIllllIIIlllIlIIIlI, final float lllllllllllIllIllllIIIlllIlIIIIl, final int lllllllllllIllIllllIIIlllIlIIIII, final EntityLivingBase lllllllllllIllIllllIIIlllIIlllll) {
        final IBlockState lllllllllllIllIllllIIIlllIIllllI = this.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.UP, false).withProperty((IProperty<Comparable>)BlockVine.NORTH, false).withProperty((IProperty<Comparable>)BlockVine.EAST, false).withProperty((IProperty<Comparable>)BlockVine.SOUTH, false).withProperty((IProperty<Comparable>)BlockVine.WEST, false);
        return lllllllllllIllIllllIIIlllIIlllII.getAxis().isHorizontal() ? lllllllllllIllIllllIIIlllIIllllI.withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIlllIIlllII.getOpposite()), true) : lllllllllllIllIllllIIIlllIIllllI;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIllIllllIIlIIIllIlIlI, final IBlockAccess lllllllllllIllIllllIIlIIIllIlIIl, final BlockPos lllllllllllIllIllllIIlIIIllIlIII) {
        return BlockVine.NULL_AABB;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockVine.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception lllllllllllIllIllllIIIllIlIIIlII = (Object)new int[Mirror.values().length];
        try {
            lllllllllllIllIllllIIIllIlIIIlII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIllllIIIllIlIIIlII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIllllIIIllIlIIIlII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIllIllllIIIllIlIIIlII;
    }
    
    public static PropertyBool getPropertyFor(final EnumFacing lllllllllllIllIllllIIIllIlIlllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllIllllIIIllIlIlllII.ordinal()]) {
            case 2: {
                return BlockVine.UP;
            }
            case 3: {
                return BlockVine.NORTH;
            }
            case 4: {
                return BlockVine.SOUTH;
            }
            case 5: {
                return BlockVine.WEST;
            }
            case 6: {
                return BlockVine.EAST;
            }
            default: {
                throw new IllegalArgumentException(lllllllllllIllIllllIIIllIlIlllII + " is an invalid choice");
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllIllIllllIIlIIIlIlllII, final IBlockAccess lllllllllllIllIllllIIlIIIllIIIII, final BlockPos lllllllllllIllIllllIIlIIIlIlllll) {
        lllllllllllIllIllllIIlIIIlIlllII = (short)((IBlockProperties)lllllllllllIllIllllIIlIIIlIlllII).getActualState(lllllllllllIllIllllIIlIIIllIIIII, lllllllllllIllIllllIIlIIIlIlllll);
        int lllllllllllIllIllllIIlIIIlIllllI = 0;
        AxisAlignedBB lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.FULL_BLOCK_AABB;
        if (((IBlockState)lllllllllllIllIllllIIlIIIlIlllII).getValue((IProperty<Boolean>)BlockVine.UP)) {
            lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.UP_AABB;
            ++lllllllllllIllIllllIIlIIIlIllllI;
        }
        if (((IBlockState)lllllllllllIllIllllIIlIIIlIlllII).getValue((IProperty<Boolean>)BlockVine.NORTH)) {
            lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.NORTH_AABB;
            ++lllllllllllIllIllllIIlIIIlIllllI;
        }
        if (((IBlockState)lllllllllllIllIllllIIlIIIlIlllII).getValue((IProperty<Boolean>)BlockVine.EAST)) {
            lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.EAST_AABB;
            ++lllllllllllIllIllllIIlIIIlIllllI;
        }
        if (((IBlockState)lllllllllllIllIllllIIlIIIlIlllII).getValue((IProperty<Boolean>)BlockVine.SOUTH)) {
            lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.SOUTH_AABB;
            ++lllllllllllIllIllllIIlIIIlIllllI;
        }
        if (((IBlockState)lllllllllllIllIllllIIlIIIlIlllII).getValue((IProperty<Boolean>)BlockVine.WEST)) {
            lllllllllllIllIllllIIlIIIlIlllIl = BlockVine.WEST_AABB;
            ++lllllllllllIllIllllIIlIIIlIllllI;
        }
        return (lllllllllllIllIllllIIlIIIlIllllI == 1) ? lllllllllllIllIllllIIlIIIlIlllIl : BlockVine.FULL_BLOCK_AABB;
    }
    
    public static int getNumGrownFaces(final IBlockState lllllllllllIllIllllIIIllIlIlIIlI) {
        int lllllllllllIllIllllIIIllIlIlIlII = 0;
        final double lllllllllllIllIllllIIIllIlIIllIl;
        final byte lllllllllllIllIllllIIIllIlIIlllI = (byte)((PropertyBool[])(Object)(lllllllllllIllIllllIIIllIlIIllIl = (double)(Object)BlockVine.ALL_FACES)).length;
        for (short lllllllllllIllIllllIIIllIlIIllll = 0; lllllllllllIllIllllIIIllIlIIllll < lllllllllllIllIllllIIIllIlIIlllI; ++lllllllllllIllIllllIIIllIlIIllll) {
            final PropertyBool lllllllllllIllIllllIIIllIlIlIIll = lllllllllllIllIllllIIIllIlIIllIl[lllllllllllIllIllllIIIllIlIIllll];
            if (lllllllllllIllIllllIIIllIlIlIIlI.getValue((IProperty<Boolean>)lllllllllllIllIllllIIIllIlIlIIll)) {
                ++lllllllllllIllIllllIIIllIlIlIlII;
            }
        }
        return lllllllllllIllIllllIIIllIlIlIlII;
    }
    
    static {
        UP = PropertyBool.create("up");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        ALL_FACES = new PropertyBool[] { BlockVine.UP, BlockVine.NORTH, BlockVine.SOUTH, BlockVine.WEST, BlockVine.EAST };
        UP_AABB = new AxisAlignedBB(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0625, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.0625);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.9375, 1.0, 1.0, 1.0);
    }
    
    public BlockVine() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockVine.UP, false).withProperty((IProperty<Comparable>)BlockVine.NORTH, false).withProperty((IProperty<Comparable>)BlockVine.EAST, false).withProperty((IProperty<Comparable>)BlockVine.SOUTH, false).withProperty((IProperty<Comparable>)BlockVine.WEST, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void updateTick(final World lllllllllllIllIllllIIIlllIllllII, final BlockPos lllllllllllIllIllllIIIlllIlllIll, final IBlockState lllllllllllIllIllllIIIlllIlllIlI, final Random lllllllllllIllIllllIIIllllIllIIl) {
        if (!lllllllllllIllIllllIIIlllIllllII.isRemote && lllllllllllIllIllllIIIlllIllllII.rand.nextInt(4) == 0) {
            final int lllllllllllIllIllllIIIllllIllIII = 4;
            int lllllllllllIllIllllIIIllllIlIlll = 5;
            boolean lllllllllllIllIllllIIIllllIlIllI = false;
        Label_0111:
            for (int lllllllllllIllIllllIIIllllIlIlIl = -4; lllllllllllIllIllllIIIllllIlIlIl <= 4; ++lllllllllllIllIllllIIIllllIlIlIl) {
                for (int lllllllllllIllIllllIIIllllIlIlII = -4; lllllllllllIllIllllIIIllllIlIlII <= 4; ++lllllllllllIllIllllIIIllllIlIlII) {
                    for (int lllllllllllIllIllllIIIllllIlIIll = -1; lllllllllllIllIllllIIIllllIlIIll <= 1; ++lllllllllllIllIllllIIIllllIlIIll) {
                        if (lllllllllllIllIllllIIIlllIllllII.getBlockState(lllllllllllIllIllllIIIlllIlllIll.add(lllllllllllIllIllllIIIllllIlIlIl, lllllllllllIllIllllIIIllllIlIIll, lllllllllllIllIllllIIIllllIlIlII)).getBlock() == this && --lllllllllllIllIllllIIIllllIlIlll <= 0) {
                            lllllllllllIllIllllIIIllllIlIllI = true;
                            break Label_0111;
                        }
                    }
                }
            }
            final EnumFacing lllllllllllIllIllllIIIllllIlIIlI = EnumFacing.random(lllllllllllIllIllllIIIllllIllIIl);
            final BlockPos lllllllllllIllIllllIIIllllIlIIIl = lllllllllllIllIllllIIIlllIlllIll.up();
            if (lllllllllllIllIllllIIIllllIlIIlI == EnumFacing.UP && lllllllllllIllIllllIIIlllIlllIll.getY() < 255 && lllllllllllIllIllllIIIlllIllllII.isAirBlock(lllllllllllIllIllllIIIllllIlIIIl)) {
                IBlockState lllllllllllIllIllllIIIllllIlIIII = lllllllllllIllIllllIIIlllIlllIlI;
                for (final EnumFacing lllllllllllIllIllllIIIllllIIllll : EnumFacing.Plane.HORIZONTAL) {
                    if (lllllllllllIllIllllIIIllllIllIIl.nextBoolean() && this.func_193395_a(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIlIIIl, lllllllllllIllIllllIIIllllIIllll.getOpposite())) {
                        lllllllllllIllIllllIIIllllIlIIII = lllllllllllIllIllllIIIllllIlIIII.withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIIllll), true);
                    }
                    else {
                        lllllllllllIllIllllIIIllllIlIIII = lllllllllllIllIllllIIIllllIlIIII.withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIIllll), false);
                    }
                }
                if (lllllllllllIllIllllIIIllllIlIIII.getValue((IProperty<Boolean>)BlockVine.NORTH) || lllllllllllIllIllllIIIllllIlIIII.getValue((IProperty<Boolean>)BlockVine.EAST) || lllllllllllIllIllllIIIllllIlIIII.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lllllllllllIllIllllIIIllllIlIIII.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                    lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIlIIIl, lllllllllllIllIllllIIIllllIlIIII, 2);
                }
            }
            else if (lllllllllllIllIllllIIIllllIlIIlI.getAxis().isHorizontal() && !lllllllllllIllIllllIIIlllIlllIlI.getValue((IProperty<Boolean>)getPropertyFor(lllllllllllIllIllllIIIllllIlIIlI))) {
                if (!lllllllllllIllIllllIIIllllIlIllI) {
                    final BlockPos lllllllllllIllIllllIIIllllIIlllI = lllllllllllIllIllllIIIlllIlllIll.offset(lllllllllllIllIllllIIIllllIlIIlI);
                    final IBlockState lllllllllllIllIllllIIIllllIIllIl = lllllllllllIllIllllIIIlllIllllII.getBlockState(lllllllllllIllIllllIIIllllIIlllI);
                    final Block lllllllllllIllIllllIIIllllIIllII = lllllllllllIllIllllIIIllllIIllIl.getBlock();
                    if (lllllllllllIllIllllIIIllllIIllII.blockMaterial == Material.AIR) {
                        final EnumFacing lllllllllllIllIllllIIIllllIIlIll = lllllllllllIllIllllIIIllllIlIIlI.rotateY();
                        final EnumFacing lllllllllllIllIllllIIIllllIIlIlI = lllllllllllIllIllllIIIllllIlIIlI.rotateYCCW();
                        final boolean lllllllllllIllIllllIIIllllIIlIIl = lllllllllllIllIllllIIIlllIlllIlI.getValue((IProperty<Boolean>)getPropertyFor(lllllllllllIllIllllIIIllllIIlIll));
                        final boolean lllllllllllIllIllllIIIllllIIlIII = lllllllllllIllIllllIIIlllIlllIlI.getValue((IProperty<Boolean>)getPropertyFor(lllllllllllIllIllllIIIllllIIlIlI));
                        final BlockPos lllllllllllIllIllllIIIllllIIIlll = lllllllllllIllIllllIIIllllIIlllI.offset(lllllllllllIllIllllIIIllllIIlIll);
                        final BlockPos lllllllllllIllIllllIIIllllIIIllI = lllllllllllIllIllllIIIllllIIlllI.offset(lllllllllllIllIllllIIIllllIIlIlI);
                        if (lllllllllllIllIllllIIIllllIIlIIl && this.func_193395_a(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIIIlll.offset(lllllllllllIllIllllIIIllllIIlIll), lllllllllllIllIllllIIIllllIIlIll)) {
                            lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIlllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIIlIll), true), 2);
                        }
                        else if (lllllllllllIllIllllIIIllllIIlIII && this.func_193395_a(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIIIllI.offset(lllllllllllIllIllllIIIllllIIlIlI), lllllllllllIllIllllIIIllllIIlIlI)) {
                            lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIlllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIIlIlI), true), 2);
                        }
                        else if (lllllllllllIllIllllIIIllllIIlIIl && lllllllllllIllIllllIIIlllIllllII.isAirBlock(lllllllllllIllIllllIIIllllIIIlll) && this.func_193395_a(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIIIlll, lllllllllllIllIllllIIIllllIlIIlI)) {
                            lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIIlll, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIlIIlI.getOpposite()), true), 2);
                        }
                        else if (lllllllllllIllIllllIIIllllIIlIII && lllllllllllIllIllllIIIlllIllllII.isAirBlock(lllllllllllIllIllllIIIllllIIIllI) && this.func_193395_a(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIIIllI, lllllllllllIllIllllIIIllllIlIIlI)) {
                            lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIIllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIlIIlI.getOpposite()), true), 2);
                        }
                    }
                    else if (lllllllllllIllIllllIIIllllIIllIl.func_193401_d(lllllllllllIllIllllIIIlllIllllII, lllllllllllIllIllllIIIllllIIlllI, lllllllllllIllIllllIIIllllIlIIlI) == BlockFaceShape.SOLID) {
                        lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIlllIlllIll, lllllllllllIllIllllIIIlllIlllIlI.withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIlIIlI), true), 2);
                    }
                }
            }
            else if (lllllllllllIllIllllIIIlllIlllIll.getY() > 1) {
                final BlockPos lllllllllllIllIllllIIIllllIIIlIl = lllllllllllIllIllllIIIlllIlllIll.down();
                final IBlockState lllllllllllIllIllllIIIllllIIIlII = lllllllllllIllIllllIIIlllIllllII.getBlockState(lllllllllllIllIllllIIIllllIIIlIl);
                final Block lllllllllllIllIllllIIIllllIIIIll = lllllllllllIllIllllIIIllllIIIlII.getBlock();
                if (lllllllllllIllIllllIIIllllIIIIll.blockMaterial == Material.AIR) {
                    IBlockState lllllllllllIllIllllIIIllllIIIIlI = lllllllllllIllIllllIIIlllIlllIlI;
                    for (final EnumFacing lllllllllllIllIllllIIIllllIIIIIl : EnumFacing.Plane.HORIZONTAL) {
                        if (lllllllllllIllIllllIIIllllIllIIl.nextBoolean()) {
                            lllllllllllIllIllllIIIllllIIIIlI = lllllllllllIllIllllIIIllllIIIIlI.withProperty((IProperty<Comparable>)getPropertyFor(lllllllllllIllIllllIIIllllIIIIIl), false);
                        }
                    }
                    if (lllllllllllIllIllllIIIllllIIIIlI.getValue((IProperty<Boolean>)BlockVine.NORTH) || lllllllllllIllIllllIIIllllIIIIlI.getValue((IProperty<Boolean>)BlockVine.EAST) || lllllllllllIllIllllIIIllllIIIIlI.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lllllllllllIllIllllIIIllllIIIIlI.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                        lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIIlIl, lllllllllllIllIllllIIIllllIIIIlI, 2);
                    }
                }
                else if (lllllllllllIllIllllIIIllllIIIIll == this) {
                    IBlockState lllllllllllIllIllllIIIllllIIIIII = lllllllllllIllIllllIIIllllIIIlII;
                    for (final EnumFacing lllllllllllIllIllllIIIlllIllllll : EnumFacing.Plane.HORIZONTAL) {
                        final PropertyBool lllllllllllIllIllllIIIlllIlllllI = getPropertyFor(lllllllllllIllIllllIIIlllIllllll);
                        if (lllllllllllIllIllllIIIllllIllIIl.nextBoolean() && lllllllllllIllIllllIIIlllIlllIlI.getValue((IProperty<Boolean>)lllllllllllIllIllllIIIlllIlllllI)) {
                            lllllllllllIllIllllIIIllllIIIIII = lllllllllllIllIllllIIIllllIIIIII.withProperty((IProperty<Comparable>)lllllllllllIllIllllIIIlllIlllllI, true);
                        }
                    }
                    if (lllllllllllIllIllllIIIllllIIIIII.getValue((IProperty<Boolean>)BlockVine.NORTH) || lllllllllllIllIllllIIIllllIIIIII.getValue((IProperty<Boolean>)BlockVine.EAST) || lllllllllllIllIllllIIIllllIIIIII.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lllllllllllIllIllllIIIllllIIIIII.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                        lllllllllllIllIllllIIIlllIllllII.setBlockState(lllllllllllIllIllllIIIllllIIIlIl, lllllllllllIllIllllIIIllllIIIIII, 2);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIllllIIlIIIlIIIlll) {
        return false;
    }
    
    private boolean recheckGrownSides(final World lllllllllllIllIllllIIlIIIIIIIllI, final BlockPos lllllllllllIllIllllIIlIIIIIIIlIl, IBlockState lllllllllllIllIllllIIlIIIIIIIlII) {
        final IBlockState lllllllllllIllIllllIIlIIIIIIlIll = (IBlockState)lllllllllllIllIllllIIlIIIIIIIlII;
        for (final EnumFacing lllllllllllIllIllllIIlIIIIIIlIlI : EnumFacing.Plane.HORIZONTAL) {
            final PropertyBool lllllllllllIllIllllIIlIIIIIIlIIl = getPropertyFor(lllllllllllIllIllllIIlIIIIIIlIlI);
            if (((IBlockState)lllllllllllIllIllllIIlIIIIIIIlII).getValue((IProperty<Boolean>)lllllllllllIllIllllIIlIIIIIIlIIl) && !this.func_193395_a(lllllllllllIllIllllIIlIIIIIIIllI, lllllllllllIllIllllIIlIIIIIIIlIl, lllllllllllIllIllllIIlIIIIIIlIlI.getOpposite())) {
                final IBlockState lllllllllllIllIllllIIlIIIIIIlIII = lllllllllllIllIllllIIlIIIIIIIllI.getBlockState(lllllllllllIllIllllIIlIIIIIIIlIl.up());
                if (lllllllllllIllIllllIIlIIIIIIlIII.getBlock() == this && lllllllllllIllIllllIIlIIIIIIlIII.getValue((IProperty<Boolean>)lllllllllllIllIllllIIlIIIIIIlIIl)) {
                    continue;
                }
                lllllllllllIllIllllIIlIIIIIIIlII = ((IBlockState)lllllllllllIllIllllIIlIIIIIIIlII).withProperty((IProperty<Comparable>)lllllllllllIllIllllIIlIIIIIIlIIl, Boolean.valueOf(false));
            }
        }
        if (getNumGrownFaces((IBlockState)lllllllllllIllIllllIIlIIIIIIIlII) == 0) {
            return false;
        }
        if (lllllllllllIllIllllIIlIIIIIIlIll != lllllllllllIllIllllIIlIIIIIIIlII) {
            lllllllllllIllIllllIIlIIIIIIIllI.setBlockState(lllllllllllIllIllllIIlIIIIIIIlIl, (IBlockState)lllllllllllIllIllllIIlIIIIIIIlII, 2);
        }
        return true;
    }
    
    protected static boolean func_193397_e(final Block lllllllllllIllIllllIIlIIIIIllIlI) {
        return lllllllllllIllIllllIIlIIIIIllIlI instanceof BlockShulkerBox || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.BEACON || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.CAULDRON || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.GLASS || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.STAINED_GLASS || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.PISTON || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.STICKY_PISTON || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.PISTON_HEAD || lllllllllllIllIllllIIlIIIIIllIlI == Blocks.TRAPDOOR;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIllIllllIIlIIIlIlIIlI, final IBlockAccess lllllllllllIllIllllIIlIIIlIlIIIl, final BlockPos lllllllllllIllIllllIIlIIIlIIllII) {
        final BlockPos lllllllllllIllIllllIIlIIIlIIllll = lllllllllllIllIllllIIlIIIlIIllII.up();
        return lllllllllllIllIllllIIlIIIlIlIIlI.withProperty((IProperty<Comparable>)BlockVine.UP, lllllllllllIllIllllIIlIIIlIlIIIl.getBlockState(lllllllllllIllIllllIIlIIIlIIllll).func_193401_d(lllllllllllIllIllllIIlIIIlIlIIIl, lllllllllllIllIllllIIlIIIlIIllll, EnumFacing.DOWN) == BlockFaceShape.SOLID);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIllllIIIllIlIIlIll, final IBlockState lllllllllllIllIllllIIIllIlIIlIlI, final BlockPos lllllllllllIllIllllIIIllIlIIlIIl, final EnumFacing lllllllllllIllIllllIIIllIlIIlIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIllIllllIIIllIllllIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.SOUTH, (lllllllllllIllIllllIIIllIllllIll & 0x1) > 0).withProperty((IProperty<Comparable>)BlockVine.WEST, (lllllllllllIllIllllIIIllIllllIll & 0x2) > 0).withProperty((IProperty<Comparable>)BlockVine.NORTH, (lllllllllllIllIllllIIIllIllllIll & 0x4) > 0).withProperty((IProperty<Comparable>)BlockVine.EAST, (lllllllllllIllIllllIIIllIllllIll & 0x8) > 0);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockVine.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllIllIllllIIIllIlIIIllI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllIllIllllIIIllIlIIIllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIllllIIIllIlIIIllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIllllIIIllIlIIIllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllIllllIIIllIlIIIllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllIllIllllIIIllIlIIIllI;
    }
    
    private boolean func_193396_c(final World lllllllllllIllIllllIIlIIIIlIIIll, final BlockPos lllllllllllIllIllllIIlIIIIIllllI, final EnumFacing lllllllllllIllIllllIIlIIIIlIIIIl) {
        final IBlockState lllllllllllIllIllllIIlIIIIlIIIII = lllllllllllIllIllllIIlIIIIlIIIll.getBlockState(lllllllllllIllIllllIIlIIIIIllllI);
        return lllllllllllIllIllllIIlIIIIlIIIII.func_193401_d(lllllllllllIllIllllIIlIIIIlIIIll, lllllllllllIllIllllIIlIIIIIllllI, lllllllllllIllIllllIIlIIIIlIIIIl) == BlockFaceShape.SOLID && !func_193397_e(lllllllllllIllIllllIIlIIIIlIIIII.getBlock());
    }
}
