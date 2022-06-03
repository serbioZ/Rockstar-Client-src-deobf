// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockCrops extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyInteger AGE;
    private static final /* synthetic */ AxisAlignedBB[] CROPS_AABB;
    
    @Override
    protected boolean canSustainBush(final IBlockState lllIlIllIIllIII) {
        return lllIlIllIIllIII.getBlock() == Blocks.FARMLAND;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllIlIlIIIIIIIl, final Random lllIlIlIIIIIlII, final int lllIlIlIIIIIIll) {
        return this.isMaxAge(lllIlIlIIIIIIIl) ? this.getCrop() : this.getSeed();
    }
    
    @Override
    public void grow(final World lllIlIIlllIIlll, final Random lllIlIIlllIIllI, final BlockPos lllIlIIlllIIIIl, final IBlockState lllIlIIlllIIlII) {
        this.grow(lllIlIIlllIIlll, lllIlIIlllIIIIl, lllIlIIlllIIlII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllIlIIllIllIlI) {
        return this.withAge(lllIlIIllIllIlI);
    }
    
    public boolean isMaxAge(final IBlockState lllIlIllIIIIIll) {
        return lllIlIllIIIIIll.getValue((IProperty<Integer>)this.getAgeProperty()) >= this.getMaxAge();
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 7);
        CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    public int getMaxAge() {
        return 7;
    }
    
    @Override
    public boolean canGrow(final World lllIlIIllllIlll, final BlockPos lllIlIIllllIllI, final IBlockState lllIlIIllllIIlI, final boolean lllIlIIllllIlII) {
        return !this.isMaxAge(lllIlIIllllIIlI);
    }
    
    protected int getBonemealAgeIncrease(final World lllIlIlIlIllIIl) {
        return MathHelper.getInt(lllIlIlIlIllIIl.rand, 2, 5);
    }
    
    public IBlockState withAge(final int lllIlIllIIIlIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)this.getAgeProperty(), lllIlIllIIIlIIl);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCrops.AGE });
    }
    
    protected Item getCrop() {
        return Items.WHEAT;
    }
    
    protected int getAge(final IBlockState lllIlIllIIIllll) {
        return lllIlIllIIIllll.getValue((IProperty<Integer>)this.getAgeProperty());
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllIlIlIIIlIIII, final BlockPos lllIlIlIIIIllll, final IBlockState lllIlIlIIIIlllI, final float lllIlIlIIIIllIl, final int lllIlIlIIIIllII) {
        super.dropBlockAsItemWithChance(lllIlIlIIIlIIII, lllIlIlIIIIllll, lllIlIlIIIIlllI, lllIlIlIIIIllIl, 0);
        if (!lllIlIlIIIlIIII.isRemote) {
            final int lllIlIlIIIlIlII = this.getAge(lllIlIlIIIIlllI);
            if (lllIlIlIIIlIlII >= this.getMaxAge()) {
                for (int lllIlIlIIIlIIll = 3 + lllIlIlIIIIllII, lllIlIlIIIlIIlI = 0; lllIlIlIIIlIIlI < lllIlIlIIIlIIll; ++lllIlIlIIIlIIlI) {
                    if (lllIlIlIIIlIIII.rand.nextInt(2 * this.getMaxAge()) <= lllIlIlIIIlIlII) {
                        Block.spawnAsEntity(lllIlIlIIIlIIII, lllIlIlIIIIllll, new ItemStack(this.getSeed()));
                    }
                }
            }
        }
    }
    
    public void grow(final World lllIlIlIllIIIII, final BlockPos lllIlIlIllIIlIl, final IBlockState lllIlIlIlIllllI) {
        int lllIlIlIllIIIll = this.getAge(lllIlIlIlIllllI) + this.getBonemealAgeIncrease(lllIlIlIllIIIII);
        final int lllIlIlIllIIIlI = this.getMaxAge();
        if (lllIlIlIllIIIll > lllIlIlIllIIIlI) {
            lllIlIlIllIIIll = lllIlIlIllIIIlI;
        }
        lllIlIlIllIIIII.setBlockState(lllIlIlIllIIlIl, this.withAge(lllIlIlIllIIIll), 2);
    }
    
    @Override
    public void updateTick(final World lllIlIlIllllIlI, final BlockPos lllIlIlIlllIIlI, final IBlockState lllIlIlIlllIIIl, final Random lllIlIlIlllIIII) {
        super.updateTick(lllIlIlIllllIlI, lllIlIlIlllIIlI, lllIlIlIlllIIIl, lllIlIlIlllIIII);
        if (lllIlIlIllllIlI.getLightFromNeighbors(lllIlIlIlllIIlI.up()) >= 9) {
            final int lllIlIlIlllIllI = this.getAge(lllIlIlIlllIIIl);
            if (lllIlIlIlllIllI < this.getMaxAge()) {
                final float lllIlIlIlllIlIl = getGrowthChance(this, lllIlIlIllllIlI, lllIlIlIlllIIlI);
                if (lllIlIlIlllIIII.nextInt((int)(25.0f / lllIlIlIlllIlIl) + 1) == 0) {
                    lllIlIlIllllIlI.setBlockState(lllIlIlIlllIIlI, this.withAge(lllIlIlIlllIllI + 1), 2);
                }
            }
        }
    }
    
    @Override
    public boolean canBlockStay(final World lllIlIlIIlIlIll, final BlockPos lllIlIlIIlIIllI, final IBlockState lllIlIlIIlIlIIl) {
        return (lllIlIlIIlIlIll.getLight(lllIlIlIIlIIllI) >= 8 || lllIlIlIIlIlIll.canSeeSky(lllIlIlIIlIIllI)) && this.canSustainBush(lllIlIlIIlIlIll.getBlockState(lllIlIlIIlIIllI.down()));
    }
    
    @Override
    public boolean canUseBonemeal(final World lllIlIIllllIIII, final Random lllIlIIlllIllll, final BlockPos lllIlIIlllIlllI, final IBlockState lllIlIIlllIllIl) {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIlIIllIlIllI) {
        return this.getAge(lllIlIIllIlIllI);
    }
    
    protected PropertyInteger getAgeProperty() {
        return BlockCrops.AGE;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllIlIllIIllIll, final IBlockAccess lllIlIllIIllllI, final BlockPos lllIlIllIIlllIl) {
        return BlockCrops.CROPS_AABB[lllIlIllIIllIll.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    protected Item getSeed() {
        return Items.WHEAT_SEEDS;
    }
    
    protected BlockCrops() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)this.getAgeProperty(), 0));
        this.setTickRandomly(true);
        this.setCreativeTab(null);
        this.setHardness(0.0f);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
    }
    
    protected static float getGrowthChance(final Block lllIlIlIlIIlIll, final World lllIlIlIlIIlIlI, final BlockPos lllIlIlIlIIlIIl) {
        float lllIlIlIlIIlIII = 1.0f;
        final BlockPos lllIlIlIlIIIlll = lllIlIlIlIIlIIl.down();
        for (int lllIlIlIlIIIllI = -1; lllIlIlIlIIIllI <= 1; ++lllIlIlIlIIIllI) {
            for (int lllIlIlIlIIIlIl = -1; lllIlIlIlIIIlIl <= 1; ++lllIlIlIlIIIlIl) {
                float lllIlIlIlIIIlII = 0.0f;
                final IBlockState lllIlIlIlIIIIll = lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIlll.add(lllIlIlIlIIIllI, 0, lllIlIlIlIIIlIl));
                if (lllIlIlIlIIIIll.getBlock() == Blocks.FARMLAND) {
                    lllIlIlIlIIIlII = 1.0f;
                    if (lllIlIlIlIIIIll.getValue((IProperty<Integer>)BlockFarmland.MOISTURE) > 0) {
                        lllIlIlIlIIIlII = 3.0f;
                    }
                }
                if (lllIlIlIlIIIllI != 0 || lllIlIlIlIIIlIl != 0) {
                    lllIlIlIlIIIlII /= 4.0f;
                }
                lllIlIlIlIIlIII += lllIlIlIlIIIlII;
            }
        }
        final BlockPos lllIlIlIlIIIIlI = lllIlIlIlIIlIIl.north();
        final BlockPos lllIlIlIlIIIIIl = lllIlIlIlIIlIIl.south();
        final BlockPos lllIlIlIlIIIIII = lllIlIlIlIIlIIl.west();
        final BlockPos lllIlIlIIllllll = lllIlIlIlIIlIIl.east();
        final boolean lllIlIlIIlllllI = lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIIII).getBlock() || lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIIllllll).getBlock();
        final boolean lllIlIlIIllllIl = lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIIlI).getBlock() || lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIIIl).getBlock();
        if (lllIlIlIIlllllI && lllIlIlIIllllIl) {
            lllIlIlIlIIlIII /= 2.0f;
        }
        else {
            final boolean lllIlIlIIllllII = lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIIII.north()).getBlock() || lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIIllllll.north()).getBlock() || lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIIllllll.south()).getBlock() || lllIlIlIlIIlIll == lllIlIlIlIIlIlI.getBlockState(lllIlIlIlIIIIII.south()).getBlock();
            if (lllIlIlIIllllII) {
                lllIlIlIlIIlIII /= 2.0f;
            }
        }
        return lllIlIlIlIIlIII;
    }
    
    @Override
    public ItemStack getItem(final World lllIlIIlllllllI, final BlockPos lllIlIIllllllIl, final IBlockState lllIlIIllllllII) {
        return new ItemStack(this.getSeed());
    }
}
