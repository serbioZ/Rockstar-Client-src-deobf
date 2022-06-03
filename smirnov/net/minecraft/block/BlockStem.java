// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockStem extends BlockBush implements IGrowable
{
    protected static final /* synthetic */ AxisAlignedBB[] STEM_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyInteger AGE;
    private final /* synthetic */ Block crop;
    
    @Override
    public void updateTick(final World lllllllllllIIIllIIllllIIIIIllIlI, BlockPos lllllllllllIIIllIIllllIIIIIllIIl, IBlockState lllllllllllIIIllIIllllIIIIIllIII, final Random lllllllllllIIIllIIllllIIIIlIIIII) {
        super.updateTick(lllllllllllIIIllIIllllIIIIIllIlI, lllllllllllIIIllIIllllIIIIIllIIl, lllllllllllIIIllIIllllIIIIIllIII, lllllllllllIIIllIIllllIIIIlIIIII);
        if (lllllllllllIIIllIIllllIIIIIllIlI.getLightFromNeighbors(lllllllllllIIIllIIllllIIIIIllIIl.up()) >= 9) {
            final float lllllllllllIIIllIIllllIIIIIlllll = BlockCrops.getGrowthChance(this, lllllllllllIIIllIIllllIIIIIllIlI, lllllllllllIIIllIIllllIIIIIllIIl);
            if (lllllllllllIIIllIIllllIIIIlIIIII.nextInt((int)(25.0f / lllllllllllIIIllIIllllIIIIIlllll) + 1) == 0) {
                final int lllllllllllIIIllIIllllIIIIIllllI = lllllllllllIIIllIIllllIIIIIllIII.getValue((IProperty<Integer>)BlockStem.AGE);
                if (lllllllllllIIIllIIllllIIIIIllllI < 7) {
                    lllllllllllIIIllIIllllIIIIIllIII = lllllllllllIIIllIIllllIIIIIllIII.withProperty((IProperty<Comparable>)BlockStem.AGE, lllllllllllIIIllIIllllIIIIIllllI + 1);
                    lllllllllllIIIllIIllllIIIIIllIlI.setBlockState(lllllllllllIIIllIIllllIIIIIllIIl, lllllllllllIIIllIIllllIIIIIllIII, 2);
                }
                else {
                    for (final EnumFacing lllllllllllIIIllIIllllIIIIIlllIl : EnumFacing.Plane.HORIZONTAL) {
                        if (lllllllllllIIIllIIllllIIIIIllIlI.getBlockState(lllllllllllIIIllIIllllIIIIIllIIl.offset(lllllllllllIIIllIIllllIIIIIlllIl)).getBlock() == this.crop) {
                            return;
                        }
                    }
                    lllllllllllIIIllIIllllIIIIIllIIl = lllllllllllIIIllIIllllIIIIIllIIl.offset(EnumFacing.Plane.HORIZONTAL.random(lllllllllllIIIllIIllllIIIIlIIIII));
                    final Block lllllllllllIIIllIIllllIIIIIlllII = lllllllllllIIIllIIllllIIIIIllIlI.getBlockState(lllllllllllIIIllIIllllIIIIIllIIl.down()).getBlock();
                    if (lllllllllllIIIllIIllllIIIIIllIlI.getBlockState(lllllllllllIIIllIIllllIIIIIllIIl).getBlock().blockMaterial == Material.AIR && (lllllllllllIIIllIIllllIIIIIlllII == Blocks.FARMLAND || lllllllllllIIIllIIllllIIIIIlllII == Blocks.DIRT || lllllllllllIIIllIIllllIIIIIlllII == Blocks.GRASS)) {
                        lllllllllllIIIllIIllllIIIIIllIlI.setBlockState(lllllllllllIIIllIIllllIIIIIllIIl, this.crop.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStem.AGE, BlockStem.FACING });
    }
    
    @Override
    public void grow(final World lllllllllllIIIllIIlllIllllIIIlII, final Random lllllllllllIIIllIIlllIllllIIlIII, final BlockPos lllllllllllIIIllIIlllIllllIIIlll, final IBlockState lllllllllllIIIllIIlllIllllIIIIlI) {
        this.growStem(lllllllllllIIIllIIlllIllllIIIlII, lllllllllllIIIllIIlllIllllIIIlll, lllllllllllIIIllIIlllIllllIIIIlI);
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllIIIllIIllllIIIIllllIl, final IBlockAccess lllllllllllIIIllIIllllIIIIllllII, final BlockPos lllllllllllIIIllIIllllIIIIllIlIl) {
        final int lllllllllllIIIllIIllllIIIIlllIlI = lllllllllllIIIllIIllllIIIIllllIl.getValue((IProperty<Integer>)BlockStem.AGE);
        lllllllllllIIIllIIllllIIIIllllIl = lllllllllllIIIllIIllllIIIIllllIl.withProperty((IProperty<Comparable>)BlockStem.FACING, EnumFacing.UP);
        for (final EnumFacing lllllllllllIIIllIIllllIIIIlllIIl : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllIIIllIIllllIIIIllllII.getBlockState(lllllllllllIIIllIIllllIIIIllIlIl.offset(lllllllllllIIIllIIllllIIIIlllIIl)).getBlock() == this.crop && lllllllllllIIIllIIllllIIIIlllIlI == 7) {
                lllllllllllIIIllIIllllIIIIllllIl = lllllllllllIIIllIIllllIIIIllllIl.withProperty((IProperty<Comparable>)BlockStem.FACING, lllllllllllIIIllIIllllIIIIlllIIl);
                break;
            }
        }
        return lllllllllllIIIllIIllllIIIIllllIl;
    }
    
    public void growStem(final World lllllllllllIIIllIIllllIIIIIIlIIl, final BlockPos lllllllllllIIIllIIllllIIIIIIllII, final IBlockState lllllllllllIIIllIIllllIIIIIIIlll) {
        final int lllllllllllIIIllIIllllIIIIIIlIlI = lllllllllllIIIllIIllllIIIIIIIlll.getValue((IProperty<Integer>)BlockStem.AGE) + MathHelper.getInt(lllllllllllIIIllIIllllIIIIIIlIIl.rand, 2, 5);
        lllllllllllIIIllIIllllIIIIIIlIIl.setBlockState(lllllllllllIIIllIIllllIIIIIIllII, lllllllllllIIIllIIllllIIIIIIIlll.withProperty((IProperty<Comparable>)BlockStem.AGE, Math.min(7, lllllllllllIIIllIIllllIIIIIIlIlI)), 2);
    }
    
    @Nullable
    protected Item getSeedItem() {
        if (this.crop == Blocks.PUMPKIN) {
            return Items.PUMPKIN_SEEDS;
        }
        return (this.crop == Blocks.MELON_BLOCK) ? Items.MELON_SEEDS : null;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIIIllIIlllIllllllIIlI, final BlockPos lllllllllllIIIllIIlllIllllllIIIl, final IBlockState lllllllllllIIIllIIlllIlllllllIIl, final float lllllllllllIIIllIIlllIlllllllIII, final int lllllllllllIIIllIIlllIllllllIlll) {
        super.dropBlockAsItemWithChance(lllllllllllIIIllIIlllIllllllIIlI, lllllllllllIIIllIIlllIllllllIIIl, lllllllllllIIIllIIlllIlllllllIIl, lllllllllllIIIllIIlllIlllllllIII, lllllllllllIIIllIIlllIllllllIlll);
        if (!lllllllllllIIIllIIlllIllllllIIlI.isRemote) {
            final Item lllllllllllIIIllIIlllIllllllIllI = this.getSeedItem();
            if (lllllllllllIIIllIIlllIllllllIllI != null) {
                final int lllllllllllIIIllIIlllIllllllIlIl = lllllllllllIIIllIIlllIlllllllIIl.getValue((IProperty<Integer>)BlockStem.AGE);
                for (int lllllllllllIIIllIIlllIllllllIlII = 0; lllllllllllIIIllIIlllIllllllIlII < 3; ++lllllllllllIIIllIIlllIllllllIlII) {
                    if (lllllllllllIIIllIIlllIllllllIIlI.rand.nextInt(15) <= lllllllllllIIIllIIlllIllllllIlIl) {
                        Block.spawnAsEntity(lllllllllllIIIllIIlllIllllllIIlI, lllllllllllIIIllIIlllIllllllIIIl, new ItemStack(lllllllllllIIIllIIlllIllllllIllI));
                    }
                }
            }
        }
    }
    
    @Override
    public boolean canGrow(final World lllllllllllIIIllIIlllIllllIllIII, final BlockPos lllllllllllIIIllIIlllIllllIlIlll, final IBlockState lllllllllllIIIllIIlllIllllIlIlII, final boolean lllllllllllIIIllIIlllIllllIlIlIl) {
        return lllllllllllIIIllIIlllIllllIlIlII.getValue((IProperty<Integer>)BlockStem.AGE) != 7;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 7);
        FACING = BlockTorch.FACING;
        STEM_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.125, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.25, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.375, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.5, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.625, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.75, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.875, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625) };
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIllIIlllIlllIlllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockStem.AGE, lllllllllllIIIllIIlllIlllIlllllI);
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllIIIllIIlllIllllIlIIlI, final Random lllllllllllIIIllIIlllIllllIlIIIl, final BlockPos lllllllllllIIIllIIlllIllllIlIIII, final IBlockState lllllllllllIIIllIIlllIllllIIllll) {
        return true;
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllIIIllIIllllIIIIlIllll) {
        return lllllllllllIIIllIIllllIIIIlIllll.getBlock() == Blocks.FARMLAND;
    }
    
    protected BlockStem(final Block lllllllllllIIIllIIllllIIIlIIlllI) {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStem.AGE, 0).withProperty((IProperty<Comparable>)BlockStem.FACING, EnumFacing.UP));
        this.crop = lllllllllllIIIllIIllllIIIlIIlllI;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIllIIllllIIIlIIlIIl, final IBlockAccess lllllllllllIIIllIIllllIIIlIIlIII, final BlockPos lllllllllllIIIllIIllllIIIlIIIlll) {
        return BlockStem.STEM_AABB[lllllllllllIIIllIIllllIIIlIIlIIl.getValue((IProperty<Integer>)BlockStem.AGE)];
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIIllIIlllIlllllIIIII, final BlockPos lllllllllllIIIllIIlllIllllIlllll, final IBlockState lllllllllllIIIllIIlllIllllIllllI) {
        final Item lllllllllllIIIllIIlllIllllIlllIl = this.getSeedItem();
        return (lllllllllllIIIllIIlllIllllIlllIl == null) ? ItemStack.field_190927_a : new ItemStack(lllllllllllIIIllIIlllIllllIlllIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIllIIlllIlllIlllIII) {
        return lllllllllllIIIllIIlllIlllIlllIII.getValue((IProperty<Integer>)BlockStem.AGE);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIllIIlllIlllllIIllI, final Random lllllllllllIIIllIIlllIlllllIIlIl, final int lllllllllllIIIllIIlllIlllllIIlII) {
        return Items.field_190931_a;
    }
}
