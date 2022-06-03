// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Items;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.stats.StatList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.PropertyEnum;

public class BlockDoublePlant extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum<EnumFacing> FACING;
    public static final /* synthetic */ PropertyEnum<EnumBlockHalf> HALF;
    public static final /* synthetic */ PropertyEnum<EnumPlantType> VARIANT;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIllIIIllIllllIIIlI) {
        return (lllllllllllIIlIllIIIllIllllIIIlI.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) ? (0x8 | lllllllllllIIlIllIIIllIllllIIIlI.getValue(BlockDoublePlant.FACING).getHorizontalIndex()) : lllllllllllIIlIllIIIllIllllIIIlI.getValue(BlockDoublePlant.VARIANT).getMeta();
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    private boolean onHarvest(final World lllllllllllIIlIllIIIlllIIIllllIl, final BlockPos lllllllllllIIlIllIIIlllIIIllllII, final IBlockState lllllllllllIIlIllIIIlllIIlIIIIlI, final EntityPlayer lllllllllllIIlIllIIIlllIIIlllIlI) {
        final EnumPlantType lllllllllllIIlIllIIIlllIIlIIIIII = lllllllllllIIlIllIIIlllIIlIIIIlI.getValue(BlockDoublePlant.VARIANT);
        if (lllllllllllIIlIllIIIlllIIlIIIIII != EnumPlantType.FERN && lllllllllllIIlIllIIIlllIIlIIIIII != EnumPlantType.GRASS) {
            return false;
        }
        lllllllllllIIlIllIIIlllIIIlllIlI.addStat(StatList.getBlockStats(this));
        final int lllllllllllIIlIllIIIlllIIIllllll = ((lllllllllllIIlIllIIIlllIIlIIIIII == EnumPlantType.GRASS) ? BlockTallGrass.EnumType.GRASS : BlockTallGrass.EnumType.FERN).getMeta();
        Block.spawnAsEntity(lllllllllllIIlIllIIIlllIIIllllIl, lllllllllllIIlIllIIIlllIIIllllII, new ItemStack(Blocks.TALLGRASS, 2, lllllllllllIIlIllIIIlllIIIllllll));
        return true;
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllIIlIllIIIlllIlIlIlIII, final BlockPos lllllllllllIIlIllIIIlllIlIlIllII, final IBlockState lllllllllllIIlIllIIIlllIlIlIlIll) {
        if (lllllllllllIIlIllIIIlllIlIlIlIll.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            return lllllllllllIIlIllIIIlllIlIlIlIII.getBlockState(lllllllllllIIlIllIIIlllIlIlIllII.down()).getBlock() == this;
        }
        final IBlockState lllllllllllIIlIllIIIlllIlIlIlIlI = lllllllllllIIlIllIIIlllIlIlIlIII.getBlockState(lllllllllllIIlIllIIIlllIlIlIllII.up());
        return lllllllllllIIlIllIIIlllIlIlIlIlI.getBlock() == this && super.canBlockStay(lllllllllllIIlIllIIIlllIlIlIlIII, lllllllllllIIlIllIIIlllIlIlIllII, lllllllllllIIlIllIIIlllIlIlIlIlI);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIlIllIIIlllIllIlllll, final BlockPos lllllllllllIIlIllIIIlllIllIllllI) {
        return super.canPlaceBlockAt(lllllllllllIIlIllIIIlllIllIlllll, lllllllllllIIlIllIIIlllIllIllllI) && lllllllllllIIlIllIIIlllIllIlllll.isAirBlock(lllllllllllIIlIllIIIlllIllIllllI.up());
    }
    
    @Override
    protected void checkAndDropBlock(final World lllllllllllIIlIllIIIlllIllIIIlII, final BlockPos lllllllllllIIlIllIIIlllIllIIIIll, final IBlockState lllllllllllIIlIllIIIlllIlIlllIIl) {
        if (!this.canBlockStay(lllllllllllIIlIllIIIlllIllIIIlII, lllllllllllIIlIllIIIlllIllIIIIll, lllllllllllIIlIllIIIlllIlIlllIIl)) {
            final boolean lllllllllllIIlIllIIIlllIllIIIIIl = lllllllllllIIlIllIIIlllIlIlllIIl.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER;
            final BlockPos lllllllllllIIlIllIIIlllIllIIIIII = lllllllllllIIlIllIIIlllIllIIIIIl ? lllllllllllIIlIllIIIlllIllIIIIll : lllllllllllIIlIllIIIlllIllIIIIll.up();
            final BlockPos lllllllllllIIlIllIIIlllIlIllllll = lllllllllllIIlIllIIIlllIllIIIIIl ? lllllllllllIIlIllIIIlllIllIIIIll.down() : lllllllllllIIlIllIIIlllIllIIIIll;
            final Block lllllllllllIIlIllIIIlllIlIlllllI = lllllllllllIIlIllIIIlllIllIIIIIl ? this : lllllllllllIIlIllIIIlllIllIIIlII.getBlockState(lllllllllllIIlIllIIIlllIllIIIIII).getBlock();
            final Block lllllllllllIIlIllIIIlllIlIllllIl = lllllllllllIIlIllIIIlllIllIIIIIl ? lllllllllllIIlIllIIIlllIllIIIlII.getBlockState(lllllllllllIIlIllIIIlllIlIllllll).getBlock() : this;
            if (lllllllllllIIlIllIIIlllIlIlllllI == this) {
                lllllllllllIIlIllIIIlllIllIIIlII.setBlockState(lllllllllllIIlIllIIIlllIllIIIIII, Blocks.AIR.getDefaultState(), 2);
            }
            if (lllllllllllIIlIllIIIlllIlIllllIl == this) {
                lllllllllllIIlIllIIIlllIllIIIlII.setBlockState(lllllllllllIIlIllIIIlllIlIllllll, Blocks.AIR.getDefaultState(), 3);
                if (!lllllllllllIIlIllIIIlllIllIIIIIl) {
                    this.dropBlockAsItem(lllllllllllIIlIllIIIlllIllIIIlII, lllllllllllIIlIllIIIlllIlIllllll, lllllllllllIIlIllIIIlllIlIlllIIl, 0);
                }
            }
        }
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIIlIllIIIlllIIllIlllI, final EntityPlayer lllllllllllIIlIllIIIlllIIllIIllI, final BlockPos lllllllllllIIlIllIIIlllIIllIIlIl, final IBlockState lllllllllllIIlIllIIIlllIIllIlIll, @Nullable final TileEntity lllllllllllIIlIllIIIlllIIllIlIlI, final ItemStack lllllllllllIIlIllIIIlllIIllIlIIl) {
        if (lllllllllllIIlIllIIIlllIIllIlllI.isRemote || lllllllllllIIlIllIIIlllIIllIlIIl.getItem() != Items.SHEARS || lllllllllllIIlIllIIIlllIIllIlIll.getValue(BlockDoublePlant.HALF) != EnumBlockHalf.LOWER || !this.onHarvest(lllllllllllIIlIllIIIlllIIllIlllI, lllllllllllIIlIllIIIlllIIllIIlIl, lllllllllllIIlIllIIIlllIIllIlIll, lllllllllllIIlIllIIIlllIIllIIllI)) {
            super.harvestBlock(lllllllllllIIlIllIIIlllIIllIlllI, lllllllllllIIlIllIIIlllIIllIIllI, lllllllllllIIlIllIIIlllIIllIIlIl, lllllllllllIIlIllIIIlllIIllIlIll, lllllllllllIIlIllIIIlllIIllIlIlI, lllllllllllIIlIllIIIlllIIllIlIIl);
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumPlantType.class);
        HALF = PropertyEnum.create("half", EnumBlockHalf.class);
        FACING = BlockHorizontal.FACING;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIIlIllIIIlllIlIIlIIlI) {
        return (lllllllllllIIlIllIIIlllIlIIlIIlI.getValue(BlockDoublePlant.HALF) != EnumBlockHalf.UPPER && lllllllllllIIlIllIIIlllIlIIlIIlI.getValue(BlockDoublePlant.VARIANT) != EnumPlantType.GRASS) ? lllllllllllIIlIllIIIlllIlIIlIIlI.getValue(BlockDoublePlant.VARIANT).getMeta() : 0;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllIIlIllIIIlllIIlIllIIl, final BlockPos lllllllllllIIlIllIIIlllIIlIlIIIl, final IBlockState lllllllllllIIlIllIIIlllIIlIlIIII, final EntityPlayer lllllllllllIIlIllIIIlllIIlIlIllI) {
        if (lllllllllllIIlIllIIIlllIIlIlIIII.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            if (lllllllllllIIlIllIIIlllIIlIllIIl.getBlockState(lllllllllllIIlIllIIIlllIIlIlIIIl.down()).getBlock() == this) {
                if (lllllllllllIIlIllIIIlllIIlIlIllI.capabilities.isCreativeMode) {
                    lllllllllllIIlIllIIIlllIIlIllIIl.setBlockToAir(lllllllllllIIlIllIIIlllIIlIlIIIl.down());
                }
                else {
                    final IBlockState lllllllllllIIlIllIIIlllIIlIlIlIl = lllllllllllIIlIllIIIlllIIlIllIIl.getBlockState(lllllllllllIIlIllIIIlllIIlIlIIIl.down());
                    final EnumPlantType lllllllllllIIlIllIIIlllIIlIlIlII = lllllllllllIIlIllIIIlllIIlIlIlIl.getValue(BlockDoublePlant.VARIANT);
                    if (lllllllllllIIlIllIIIlllIIlIlIlII != EnumPlantType.FERN && lllllllllllIIlIllIIIlllIIlIlIlII != EnumPlantType.GRASS) {
                        lllllllllllIIlIllIIIlllIIlIllIIl.destroyBlock(lllllllllllIIlIllIIIlllIIlIlIIIl.down(), true);
                    }
                    else if (lllllllllllIIlIllIIIlllIIlIllIIl.isRemote) {
                        lllllllllllIIlIllIIIlllIIlIllIIl.setBlockToAir(lllllllllllIIlIllIIIlllIIlIlIIIl.down());
                    }
                    else if (!lllllllllllIIlIllIIIlllIIlIlIllI.getHeldItemMainhand().func_190926_b() && lllllllllllIIlIllIIIlllIIlIlIllI.getHeldItemMainhand().getItem() == Items.SHEARS) {
                        this.onHarvest(lllllllllllIIlIllIIIlllIIlIllIIl, lllllllllllIIlIllIIIlllIIlIlIIIl, lllllllllllIIlIllIIIlllIIlIlIlIl, lllllllllllIIlIllIIIlllIIlIlIllI);
                        lllllllllllIIlIllIIIlllIIlIllIIl.setBlockToAir(lllllllllllIIlIllIIIlllIIlIlIIIl.down());
                    }
                    else {
                        lllllllllllIIlIllIIIlllIIlIllIIl.destroyBlock(lllllllllllIIlIllIIIlllIIlIlIIIl.down(), true);
                    }
                }
            }
        }
        else if (lllllllllllIIlIllIIIlllIIlIllIIl.getBlockState(lllllllllllIIlIllIIIlllIIlIlIIIl.up()).getBlock() == this) {
            lllllllllllIIlIllIIIlllIIlIllIIl.setBlockState(lllllllllllIIlIllIIIlllIIlIlIIIl.up(), Blocks.AIR.getDefaultState(), 2);
        }
        super.onBlockHarvested(lllllllllllIIlIllIIIlllIIlIllIIl, lllllllllllIIlIllIIIlllIIlIlIIIl, lllllllllllIIlIllIIIlllIIlIlIIII, lllllllllllIIlIllIIIlllIIlIlIllI);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIllIIIlllIllllIlIl, final IBlockAccess lllllllllllIIlIllIIIlllIllllIlII, final BlockPos lllllllllllIIlIllIIIlllIllllIIll) {
        return BlockDoublePlant.FULL_BLOCK_AABB;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIlIllIIIlllIIIIllllI, final BlockPos lllllllllllIIlIllIIIlllIIIlIIIIl, final IBlockState lllllllllllIIlIllIIIlllIIIlIIIII) {
        return new ItemStack(this, 1, this.getType(lllllllllllIIlIllIIIlllIIIIllllI, lllllllllllIIlIllIIIlllIIIlIIIIl, lllllllllllIIlIllIIIlllIIIlIIIII).getMeta());
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllIIlIllIIIllIllllIlIII, final IBlockAccess lllllllllllIIlIllIIIllIllllIllII, final BlockPos lllllllllllIIlIllIIIllIllllIIllI) {
        if (((IBlockState)lllllllllllIIlIllIIIllIllllIlIII).getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            final IBlockState lllllllllllIIlIllIIIllIllllIlIlI = lllllllllllIIlIllIIIllIllllIllII.getBlockState(lllllllllllIIlIllIIIllIllllIIllI.down());
            if (lllllllllllIIlIllIIIllIllllIlIlI.getBlock() == this) {
                lllllllllllIIlIllIIIllIllllIlIII = ((IBlockState)lllllllllllIIlIllIIIllIllllIlIII).withProperty(BlockDoublePlant.VARIANT, (EnumPlantType)lllllllllllIIlIllIIIllIllllIlIlI.getValue((IProperty<V>)BlockDoublePlant.VARIANT));
            }
        }
        return (IBlockState)lllllllllllIIlIllIIIllIllllIlIII;
    }
    
    private EnumPlantType getType(final IBlockAccess lllllllllllIIlIllIIIlllIlllIlIIl, final BlockPos lllllllllllIIlIllIIIlllIlllIlIII, IBlockState lllllllllllIIlIllIIIlllIlllIlIll) {
        if (lllllllllllIIlIllIIIlllIlllIlIll.getBlock() == this) {
            lllllllllllIIlIllIIIlllIlllIlIll = lllllllllllIIlIllIIIlllIlllIlIll.getActualState(lllllllllllIIlIllIIIlllIlllIlIIl, lllllllllllIIlIllIIIlllIlllIlIII);
            return lllllllllllIIlIllIIIlllIlllIlIll.getValue(BlockDoublePlant.VARIANT);
        }
        return EnumPlantType.FERN;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlIllIIIlllIlIIllIIl, final Random lllllllllllIIlIllIIIlllIlIIllIII, final int lllllllllllIIlIllIIIlllIlIIlIlll) {
        if (lllllllllllIIlIllIIIlllIlIIllIIl.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            return Items.field_190931_a;
        }
        final EnumPlantType lllllllllllIIlIllIIIlllIlIIllIll = lllllllllllIIlIllIIIlllIlIIllIIl.getValue(BlockDoublePlant.VARIANT);
        if (lllllllllllIIlIllIIIlllIlIIllIll == EnumPlantType.FERN) {
            return Items.field_190931_a;
        }
        if (lllllllllllIIlIllIIIlllIlIIllIll == EnumPlantType.GRASS) {
            return (lllllllllllIIlIllIIIlllIlIIllIII.nextInt(8) == 0) ? Items.WHEAT_SEEDS : Items.field_190931_a;
        }
        return super.getItemDropped(lllllllllllIIlIllIIIlllIlIIllIIl, lllllllllllIIlIllIIIlllIlIIllIII, lllllllllllIIlIllIIIlllIlIIlIlll);
    }
    
    public BlockDoublePlant() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDoublePlant.VARIANT, EnumPlantType.SUNFLOWER).withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.FACING, EnumFacing.NORTH));
        this.setHardness(0.0f);
        this.setSoundType(SoundType.PLANT);
        this.setUnlocalizedName("doublePlant");
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIllIIIllIlllllIllI) {
        return ((lllllllllllIIlIllIIIllIlllllIllI & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT, EnumPlantType.byMetadata(lllllllllllIIlIllIIIllIlllllIllI & 0x7));
    }
    
    public void placeAt(final World lllllllllllIIlIllIIIlllIlIIIIllI, final BlockPos lllllllllllIIlIllIIIlllIlIIIIlIl, final EnumPlantType lllllllllllIIlIllIIIlllIlIIIIlII, final int lllllllllllIIlIllIIIlllIlIIIlIII) {
        lllllllllllIIlIllIIIlllIlIIIIllI.setBlockState(lllllllllllIIlIllIIIlllIlIIIIlIl, this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT, lllllllllllIIlIllIIIlllIlIIIIlII), lllllllllllIIlIllIIIlllIlIIIlIII);
        lllllllllllIIlIllIIIlllIlIIIIllI.setBlockState(lllllllllllIIlIllIIIlllIlIIIIlIl.up(), this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER), lllllllllllIIlIllIIIlllIlIIIlIII);
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIIlIllIIIlllIIllllllI, final BlockPos lllllllllllIIlIllIIIlllIIlllllIl, final IBlockState lllllllllllIIlIllIIIlllIIlllllII, final EntityLivingBase lllllllllllIIlIllIIIlllIIllllIll, final ItemStack lllllllllllIIlIllIIIlllIIllllIlI) {
        lllllllllllIIlIllIIIlllIIllllllI.setBlockState(lllllllllllIIlIllIIIlllIIlllllIl.up(), this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER), 2);
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllIIlIllIIIlllIllIlIIlI, final BlockPos lllllllllllIIlIllIIIlllIllIlIIIl) {
        final IBlockState lllllllllllIIlIllIIIlllIllIlIlIl = lllllllllllIIlIllIIIlllIllIlIIlI.getBlockState(lllllllllllIIlIllIIIlllIllIlIIIl);
        if (lllllllllllIIlIllIIIlllIllIlIlIl.getBlock() != this) {
            return true;
        }
        final EnumPlantType lllllllllllIIlIllIIIlllIllIlIlII = lllllllllllIIlIllIIIlllIllIlIlIl.getActualState(lllllllllllIIlIllIIIlllIllIlIIlI, lllllllllllIIlIllIIIlllIllIlIIIl).getValue(BlockDoublePlant.VARIANT);
        return lllllllllllIIlIllIIIlllIllIlIlII == EnumPlantType.FERN || lllllllllllIIlIllIIIlllIllIlIlII == EnumPlantType.GRASS;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDoublePlant.HALF, BlockDoublePlant.VARIANT, BlockDoublePlant.FACING });
    }
    
    @Override
    public boolean canGrow(final World lllllllllllIIlIllIIIlllIIIIlIlIl, final BlockPos lllllllllllIIlIllIIIlllIIIIlIlII, final IBlockState lllllllllllIIlIllIIIlllIIIIIllIl, final boolean lllllllllllIIlIllIIIlllIIIIlIIlI) {
        final EnumPlantType lllllllllllIIlIllIIIlllIIIIlIIIl = this.getType(lllllllllllIIlIllIIIlllIIIIlIlIl, lllllllllllIIlIllIIIlllIIIIlIlII, lllllllllllIIlIllIIIlllIIIIIllIl);
        return lllllllllllIIlIllIIIlllIIIIlIIIl != EnumPlantType.GRASS && lllllllllllIIlIllIIIlllIIIIlIIIl != EnumPlantType.FERN;
    }
    
    @Override
    public void grow(final World lllllllllllIIlIllIIIllIlllllllII, final Random lllllllllllIIlIllIIIlllIIIIIIIII, final BlockPos lllllllllllIIlIllIIIllIllllllIll, final IBlockState lllllllllllIIlIllIIIllIllllllllI) {
        Block.spawnAsEntity(lllllllllllIIlIllIIIllIlllllllII, lllllllllllIIlIllIIIllIllllllIll, new ItemStack(this, 1, this.getType(lllllllllllIIlIllIIIllIlllllllII, lllllllllllIIlIllIIIllIllllllIll, lllllllllllIIlIllIIIllIllllllllI).getMeta()));
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllIIlIllIIIlllIIIIIlIlI, final Random lllllllllllIIlIllIIIlllIIIIIlIIl, final BlockPos lllllllllllIIlIllIIIlllIIIIIlIII, final IBlockState lllllllllllIIlIllIIIlllIIIIIIlll) {
        return true;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIlIllIIIlllIIIllIIII, final NonNullList<ItemStack> lllllllllllIIlIllIIIlllIIIlIllll) {
        final float lllllllllllIIlIllIIIlllIIIlIlIII;
        final short lllllllllllIIlIllIIIlllIIIlIlIIl = (short)((EnumPlantType[])(Object)(lllllllllllIIlIllIIIlllIIIlIlIII = (float)(Object)EnumPlantType.values())).length;
        for (long lllllllllllIIlIllIIIlllIIIlIlIlI = 0; lllllllllllIIlIllIIIlllIIIlIlIlI < lllllllllllIIlIllIIIlllIIIlIlIIl; ++lllllllllllIIlIllIIIlllIIIlIlIlI) {
            final EnumPlantType lllllllllllIIlIllIIIlllIIIlIlllI = lllllllllllIIlIllIIIlllIIIlIlIII[lllllllllllIIlIllIIIlllIIIlIlIlI];
            lllllllllllIIlIllIIIlllIIIlIllll.add(new ItemStack(this, 1, lllllllllllIIlIllIIIlllIIIlIlllI.getMeta()));
        }
    }
    
    public enum EnumPlantType implements IStringSerializable
    {
        PAEONIA("PAEONIA", 5, 5, "paeonia"), 
        GRASS("GRASS", 2, 2, "double_grass", "grass");
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumPlantType[] META_LOOKUP;
        private final /* synthetic */ String unlocalizedName;
        
        ROSE("ROSE", 4, 4, "double_rose", "rose"), 
        SUNFLOWER("SUNFLOWER", 0, 0, "sunflower"), 
        SYRINGA("SYRINGA", 1, 1, "syringa");
        
        private final /* synthetic */ int meta;
        
        FERN("FERN", 3, 3, "double_fern", "fern");
        
        static {
            META_LOOKUP = new EnumPlantType[values().length];
            final short llllllllllllIIllllIIIIIllIllIlIl;
            final long llllllllllllIIllllIIIIIllIllIllI = ((EnumPlantType[])(Object)(llllllllllllIIllllIIIIIllIllIlIl = (short)(Object)values())).length;
            for (float llllllllllllIIllllIIIIIllIllIlll = 0; llllllllllllIIllllIIIIIllIllIlll < llllllllllllIIllllIIIIIllIllIllI; ++llllllllllllIIllllIIIIIllIllIlll) {
                final EnumPlantType llllllllllllIIllllIIIIIllIlllIIl = llllllllllllIIllllIIIIIllIllIlIl[llllllllllllIIllllIIIIIllIllIlll];
                EnumPlantType.META_LOOKUP[llllllllllllIIllllIIIIIllIlllIIl.getMeta()] = llllllllllllIIllllIIIIIllIlllIIl;
            }
        }
        
        public static EnumPlantType byMetadata(int llllllllllllIIllllIIIIIllIIIllll) {
            if (llllllllllllIIllllIIIIIllIIIllll < 0 || llllllllllllIIllllIIIIIllIIIllll >= EnumPlantType.META_LOOKUP.length) {
                llllllllllllIIllllIIIIIllIIIllll = 0;
            }
            return EnumPlantType.META_LOOKUP[llllllllllllIIllllIIIIIllIIIllll];
        }
        
        private EnumPlantType(final String llllllllllllIIllllIIIIIllIlIlIll, final int llllllllllllIIllllIIIIIllIlIlIlI, final int llllllllllllIIllllIIIIIllIlIlllI, final String llllllllllllIIllllIIIIIllIlIlIII) {
            this(llllllllllllIIllllIIIIIllIlIlIll, llllllllllllIIllllIIIIIllIlIlIlI, llllllllllllIIllllIIIIIllIlIlllI, llllllllllllIIllllIIIIIllIlIlIII, llllllllllllIIllllIIIIIllIlIlIII);
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public int getMeta() {
            return this.meta;
        }
        
        private EnumPlantType(final String llllllllllllIIllllIIIIIllIIlllII, final int llllllllllllIIllllIIIIIllIIllIll, final int llllllllllllIIllllIIIIIllIlIIIII, final String llllllllllllIIllllIIIIIllIIllIIl, final String llllllllllllIIllllIIIIIllIIllllI) {
            this.meta = llllllllllllIIllllIIIIIllIlIIIII;
            this.name = llllllllllllIIllllIIIIIllIIllIIl;
            this.unlocalizedName = llllllllllllIIllllIIIIIllIIllllI;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
    
    public enum EnumBlockHalf implements IStringSerializable
    {
        LOWER("LOWER", 1), 
        UPPER("UPPER", 0);
        
        private EnumBlockHalf(final String lllllllllllIlIlIllIIIlllIlIlIIII, final int lllllllllllIlIlIllIIIlllIlIIllll) {
        }
        
        @Override
        public String getName() {
            return (this == EnumBlockHalf.UPPER) ? "upper" : "lower";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
