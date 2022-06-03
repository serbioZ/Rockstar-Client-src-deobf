// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.Mirror;
import net.minecraft.block.material.Material;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import java.util.Random;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.PropertyDirection;

public class BlockFurnace extends BlockContainer
{
    private static /* synthetic */ boolean keepInventory;
    private final /* synthetic */ boolean isBurning;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFurnace.FACING });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIlIIIllIllIlIIIlI, final Rotation lllllllllllllllIlIIIllIllIlIIIIl) {
        return lllllllllllllllIlIIIllIllIlIIIlI.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIllIllIlIIIIl.rotate(lllllllllllllllIlIIIllIllIlIIIlI.getValue((IProperty<EnumFacing>)BlockFurnace.FACING)));
    }
    
    private void setDefaultFacing(final World lllllllllllllllIlIIIlllIIIllllll, final BlockPos lllllllllllllllIlIIIlllIIlIIIllI, final IBlockState lllllllllllllllIlIIIlllIIIllllIl) {
        if (!lllllllllllllllIlIIIlllIIIllllll.isRemote) {
            final IBlockState lllllllllllllllIlIIIlllIIlIIIlII = lllllllllllllllIlIIIlllIIIllllll.getBlockState(lllllllllllllllIlIIIlllIIlIIIllI.north());
            final IBlockState lllllllllllllllIlIIIlllIIlIIIIll = lllllllllllllllIlIIIlllIIIllllll.getBlockState(lllllllllllllllIlIIIlllIIlIIIllI.south());
            final IBlockState lllllllllllllllIlIIIlllIIlIIIIlI = lllllllllllllllIlIIIlllIIIllllll.getBlockState(lllllllllllllllIlIIIlllIIlIIIllI.west());
            final IBlockState lllllllllllllllIlIIIlllIIlIIIIIl = lllllllllllllllIlIIIlllIIIllllll.getBlockState(lllllllllllllllIlIIIlllIIlIIIllI.east());
            EnumFacing lllllllllllllllIlIIIlllIIlIIIIII = lllllllllllllllIlIIIlllIIIllllIl.getValue((IProperty<EnumFacing>)BlockFurnace.FACING);
            if (lllllllllllllllIlIIIlllIIlIIIIII == EnumFacing.NORTH && lllllllllllllllIlIIIlllIIlIIIlII.isFullBlock() && !lllllllllllllllIlIIIlllIIlIIIIll.isFullBlock()) {
                lllllllllllllllIlIIIlllIIlIIIIII = EnumFacing.SOUTH;
            }
            else if (lllllllllllllllIlIIIlllIIlIIIIII == EnumFacing.SOUTH && lllllllllllllllIlIIIlllIIlIIIIll.isFullBlock() && !lllllllllllllllIlIIIlllIIlIIIlII.isFullBlock()) {
                lllllllllllllllIlIIIlllIIlIIIIII = EnumFacing.NORTH;
            }
            else if (lllllllllllllllIlIIIlllIIlIIIIII == EnumFacing.WEST && lllllllllllllllIlIIIlllIIlIIIIlI.isFullBlock() && !lllllllllllllllIlIIIlllIIlIIIIIl.isFullBlock()) {
                lllllllllllllllIlIIIlllIIlIIIIII = EnumFacing.EAST;
            }
            else if (lllllllllllllllIlIIIlllIIlIIIIII == EnumFacing.EAST && lllllllllllllllIlIIIlllIIlIIIIIl.isFullBlock() && !lllllllllllllllIlIIIlllIIlIIIIlI.isFullBlock()) {
                lllllllllllllllIlIIIlllIIlIIIIII = EnumFacing.WEST;
            }
            lllllllllllllllIlIIIlllIIIllllll.setBlockState(lllllllllllllllIlIIIlllIIlIIIllI, lllllllllllllllIlIIIlllIIIllllIl.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIlllIIlIIIIII), 2);
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIlIIIllIllIllIlll, final BlockPos lllllllllllllllIlIIIllIllIllIllI, final IBlockState lllllllllllllllIlIIIllIllIllIlIl) {
        return new ItemStack(Blocks.FURNACE);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllllIlIIIllIlllIIIIIl) {
        return true;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIlIIIllIllllIlllI, final BlockPos lllllllllllllllIlIIIllIllllIllIl, final EnumFacing lllllllllllllllIlIIIllIllllIllII, final float lllllllllllllllIlIIIllIllllIlIll, final float lllllllllllllllIlIIIllIllllIlIlI, final float lllllllllllllllIlIIIllIllllIlIIl, final int lllllllllllllllIlIIIllIllllIlIII, final EntityLivingBase lllllllllllllllIlIIIllIllllIIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIllIllllIIlIl.getHorizontalFacing().getOpposite());
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIlIIIllIlllIIlIll, final BlockPos lllllllllllllllIlIIIllIlllIIlIlI, final IBlockState lllllllllllllllIlIIIllIlllIIIlII) {
        if (!BlockFurnace.keepInventory) {
            final TileEntity lllllllllllllllIlIIIllIlllIIlIII = lllllllllllllllIlIIIllIlllIIlIll.getTileEntity(lllllllllllllllIlIIIllIlllIIlIlI);
            if (lllllllllllllllIlIIIllIlllIIlIII instanceof TileEntityFurnace) {
                InventoryHelper.dropInventoryItems(lllllllllllllllIlIIIllIlllIIlIll, lllllllllllllllIlIIIllIlllIIlIlI, (IInventory)lllllllllllllllIlIIIllIlllIIlIII);
                lllllllllllllllIlIIIllIlllIIlIll.updateComparatorOutputLevel(lllllllllllllllIlIIIllIlllIIlIlI, this);
            }
        }
        super.breakBlock(lllllllllllllllIlIIIllIlllIIlIll, lllllllllllllllIlIIIllIlllIIlIlI, lllllllllllllllIlIIIllIlllIIIlII);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIlIIIllIlllllIIll, final int lllllllllllllllIlIIIllIlllllIIlI) {
        return new TileEntityFurnace();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockFurnace.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllllllllllllllIlIIIllIllIIlIIll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIlIIIllIllIIlIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFurnace.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIlIIIllIllIIlIIll;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllllIlIIIllIllIllllIl, final World lllllllllllllllIlIIIllIllIlllIlI, final BlockPos lllllllllllllllIlIIIllIllIlllIll) {
        return Container.calcRedstone(lllllllllllllllIlIIIllIllIlllIlI.getTileEntity(lllllllllllllllIlIIIllIllIlllIll));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIIllIllIlIlIll) {
        EnumFacing lllllllllllllllIlIIIllIllIlIllIl = EnumFacing.getFront(lllllllllllllllIlIIIllIllIlIlIll);
        if (lllllllllllllllIlIIIllIllIlIllIl.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllllIlIIIllIllIlIllIl = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIllIllIlIllIl);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllllIlIIIlllIIIlIIIII, final World lllllllllllllllIlIIIlllIIIIlllll, final BlockPos lllllllllllllllIlIIIlllIIIIllllI, final Random lllllllllllllllIlIIIlllIIIIlllIl) {
        if (this.isBurning) {
            final EnumFacing lllllllllllllllIlIIIlllIIIlIIlll = lllllllllllllllIlIIIlllIIIlIIIII.getValue((IProperty<EnumFacing>)BlockFurnace.FACING);
            final double lllllllllllllllIlIIIlllIIIlIIllI = lllllllllllllllIlIIIlllIIIIllllI.getX() + 0.5;
            final double lllllllllllllllIlIIIlllIIIlIIlIl = lllllllllllllllIlIIIlllIIIIllllI.getY() + lllllllllllllllIlIIIlllIIIIlllIl.nextDouble() * 6.0 / 16.0;
            final double lllllllllllllllIlIIIlllIIIlIIlII = lllllllllllllllIlIIIlllIIIIllllI.getZ() + 0.5;
            final double lllllllllllllllIlIIIlllIIIlIIIll = 0.52;
            final double lllllllllllllllIlIIIlllIIIlIIIlI = lllllllllllllllIlIIIlllIIIIlllIl.nextDouble() * 0.6 - 0.3;
            if (lllllllllllllllIlIIIlllIIIIlllIl.nextDouble() < 0.1) {
                lllllllllllllllIlIIIlllIIIIlllll.playSound(lllllllllllllllIlIIIlllIIIIllllI.getX() + 0.5, lllllllllllllllIlIIIlllIIIIllllI.getY(), lllllllllllllllIlIIIlllIIIIllllI.getZ() + 0.5, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIlIIIlllIIIlIIlll.ordinal()]) {
                case 5: {
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIlllIIIlIIllI - 0.52, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + lllllllllllllllIlIIIlllIIIlIIIlI, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIlllIIIlIIllI - 0.52, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + lllllllllllllllIlIIIlllIIIlIIIlI, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 6: {
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIlllIIIlIIllI + 0.52, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + lllllllllllllllIlIIIlllIIIlIIIlI, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIlllIIIlIIllI + 0.52, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + lllllllllllllllIlIIIlllIIIlIIIlI, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 3: {
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIlllIIIlIIllI + lllllllllllllllIlIIIlllIIIlIIIlI, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII - 0.52, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIlllIIIlIIllI + lllllllllllllllIlIIIlllIIIlIIIlI, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII - 0.52, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 4: {
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIlllIIIlIIllI + lllllllllllllllIlIIIlllIIIlIIIlI, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + 0.52, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIlllIIIIlllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIlllIIIlIIllI + lllllllllllllllIlIIIlllIIIlIIIlI, lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIlII + 0.52, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIIllIllIlIIlll) {
        return lllllllllllllllIlIIIllIllIlIIlll.getValue((IProperty<EnumFacing>)BlockFurnace.FACING).getIndex();
    }
    
    static {
        FACING = BlockHorizontal.FACING;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIIlllIIlIlllll, final Random lllllllllllllllIlIIIlllIIlIllllI, final int lllllllllllllllIlIIIlllIIlIlllIl) {
        return Item.getItemFromBlock(Blocks.FURNACE);
    }
    
    public static void setState(final boolean lllllllllllllllIlIIIllIllllllIIl, final World lllllllllllllllIlIIIllIllllllIII, final BlockPos lllllllllllllllIlIIIllIlllllIlll) {
        final IBlockState lllllllllllllllIlIIIllIllllllIll = lllllllllllllllIlIIIllIllllllIII.getBlockState(lllllllllllllllIlIIIllIlllllIlll);
        final TileEntity lllllllllllllllIlIIIllIllllllIlI = lllllllllllllllIlIIIllIllllllIII.getTileEntity(lllllllllllllllIlIIIllIlllllIlll);
        BlockFurnace.keepInventory = true;
        if (lllllllllllllllIlIIIllIllllllIIl) {
            lllllllllllllllIlIIIllIllllllIII.setBlockState(lllllllllllllllIlIIIllIlllllIlll, Blocks.LIT_FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIllIllllllIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
            lllllllllllllllIlIIIllIllllllIII.setBlockState(lllllllllllllllIlIIIllIlllllIlll, Blocks.LIT_FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIllIllllllIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
        }
        else {
            lllllllllllllllIlIIIllIllllllIII.setBlockState(lllllllllllllllIlIIIllIlllllIlll, Blocks.FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIllIllllllIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
            lllllllllllllllIlIIIllIllllllIII.setBlockState(lllllllllllllllIlIIIllIlllllIlll, Blocks.FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIllIllllllIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
        }
        BlockFurnace.keepInventory = false;
        if (lllllllllllllllIlIIIllIllllllIlI != null) {
            lllllllllllllllIlIIIllIllllllIlI.validate();
            lllllllllllllllIlIIIllIllllllIII.setTileEntity(lllllllllllllllIlIIIllIlllllIlll, lllllllllllllllIlIIIllIllllllIlI);
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIlIIIlllIIlIlIIll, final BlockPos lllllllllllllllIlIIIlllIIlIlIIlI, final IBlockState lllllllllllllllIlIIIlllIIlIlIIIl) {
        this.setDefaultFacing(lllllllllllllllIlIIIlllIIlIlIIll, lllllllllllllllIlIIIlllIIlIlIIlI, lllllllllllllllIlIIIlllIIlIlIIIl);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIlIIIlllIIIIlIIIl, final BlockPos lllllllllllllllIlIIIlllIIIIlIIII, final IBlockState lllllllllllllllIlIIIlllIIIIIllll, final EntityPlayer lllllllllllllllIlIIIlllIIIIIIlIl, final EnumHand lllllllllllllllIlIIIlllIIIIIllIl, final EnumFacing lllllllllllllllIlIIIlllIIIIIllII, final float lllllllllllllllIlIIIlllIIIIIlIll, final float lllllllllllllllIlIIIlllIIIIIlIlI, final float lllllllllllllllIlIIIlllIIIIIlIIl) {
        if (lllllllllllllllIlIIIlllIIIIlIIIl.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllllIlIIIlllIIIIIlIII = lllllllllllllllIlIIIlllIIIIlIIIl.getTileEntity(lllllllllllllllIlIIIlllIIIIlIIII);
        if (lllllllllllllllIlIIIlllIIIIIlIII instanceof TileEntityFurnace) {
            lllllllllllllllIlIIIlllIIIIIIlIl.displayGUIChest((IInventory)lllllllllllllllIlIIIlllIIIIIlIII);
            lllllllllllllllIlIIIlllIIIIIIlIl.addStat(StatList.FURNACE_INTERACTION);
        }
        return true;
    }
    
    protected BlockFurnace(final boolean lllllllllllllllIlIIIlllIIllIIIll) {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, EnumFacing.NORTH));
        this.isBurning = lllllllllllllllIlIIIlllIIllIIIll;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIlIIIllIllIIllIIl, final Mirror lllllllllllllllIlIIIllIllIIllIII) {
        return lllllllllllllllIlIIIllIllIIllIIl.withRotation(lllllllllllllllIlIIIllIllIIllIII.toRotation(lllllllllllllllIlIIIllIllIIllIIl.getValue((IProperty<EnumFacing>)BlockFurnace.FACING)));
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllIlIIIllIlllIlIlll, final BlockPos lllllllllllllllIlIIIllIlllIlIllI, final IBlockState lllllllllllllllIlIIIllIlllIlIlIl, final EntityLivingBase lllllllllllllllIlIIIllIlllIllIlI, final ItemStack lllllllllllllllIlIIIllIlllIlIIll) {
        lllllllllllllllIlIIIllIlllIlIlll.setBlockState(lllllllllllllllIlIIIllIlllIlIllI, lllllllllllllllIlIIIllIlllIlIlIl.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIllIlllIllIlI.getHorizontalFacing().getOpposite()), 2);
        if (lllllllllllllllIlIIIllIlllIlIIll.hasDisplayName()) {
            final TileEntity lllllllllllllllIlIIIllIlllIllIII = lllllllllllllllIlIIIllIlllIlIlll.getTileEntity(lllllllllllllllIlIIIllIlllIlIllI);
            if (lllllllllllllllIlIIIllIlllIllIII instanceof TileEntityFurnace) {
                ((TileEntityFurnace)lllllllllllllllIlIIIllIlllIllIII).setCustomInventoryName(lllllllllllllllIlIIIllIlllIlIIll.getDisplayName());
            }
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIlIIIllIllIllIIll) {
        return EnumBlockRenderType.MODEL;
    }
}
