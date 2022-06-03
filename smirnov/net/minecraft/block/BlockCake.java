// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumHand;
import net.minecraft.stats.StatList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockCake extends Block
{
    public static final /* synthetic */ PropertyInteger BITES;
    protected static final /* synthetic */ AxisAlignedBB[] CAKE_AABB;
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIIlIlIIIIIlllllIlII, final Random llllllllllllIIIlIlIIIIIlllllIIll, final int llllllllllllIIIlIlIIIIIlllllIIlI) {
        return Items.field_190931_a;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllllIIIlIlIIIIIlllIllIII) {
        return true;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIIIlIlIIIIlIIIIIllII, final BlockPos llllllllllllIIIlIlIIIIlIIIIIlllI) {
        return super.canPlaceBlockAt(llllllllllllIIIlIlIIIIlIIIIIllII, llllllllllllIIIlIlIIIIlIIIIIlllI) && this.canBlockStay(llllllllllllIIIlIlIIIIlIIIIIllII, llllllllllllIIIlIlIIIIlIIIIIlllI);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIIIlIlIIIIlIIIIIIllI, final World llllllllllllIIIlIlIIIIlIIIIIIIII, final BlockPos llllllllllllIIIlIlIIIIIlllllllll, final Block llllllllllllIIIlIlIIIIlIIIIIIIll, final BlockPos llllllllllllIIIlIlIIIIlIIIIIIIlI) {
        if (!this.canBlockStay(llllllllllllIIIlIlIIIIlIIIIIIIII, llllllllllllIIIlIlIIIIIlllllllll)) {
            llllllllllllIIIlIlIIIIlIIIIIIIII.setBlockToAir(llllllllllllIIIlIlIIIIIlllllllll);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIIlIlIIIIlIIIllllIl) {
        return false;
    }
    
    private boolean canBlockStay(final World llllllllllllIIIlIlIIIIIllllllIIl, final BlockPos llllllllllllIIIlIlIIIIIllllllIlI) {
        return llllllllllllIIIlIlIIIIIllllllIIl.getBlockState(llllllllllllIIIlIlIIIIIllllllIlI.down()).getMaterial().isSolid();
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIIlIlIIIIIlllllIIII, final BlockPos llllllllllllIIIlIlIIIIIllllIllll, final IBlockState llllllllllllIIIlIlIIIIIllllIlllI) {
        return new ItemStack(Items.CAKE);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIIIlIlIIIIlIIIllllll) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIIIlIlIIIIIlllIlIllI, final IBlockState llllllllllllIIIlIlIIIIIlllIlIlIl, final BlockPos llllllllllllIIIlIlIIIIIlllIlIlII, final EnumFacing llllllllllllIIIlIlIIIIIlllIlIIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCake.BITES });
    }
    
    static {
        BITES = PropertyInteger.create("bites", 0, 6);
        CAKE_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.1875, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.3125, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.4375, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.5625, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.6875, 0.0, 0.0625, 0.9375, 0.5, 0.9375), new AxisAlignedBB(0.8125, 0.0, 0.0625, 0.9375, 0.5, 0.9375) };
    }
    
    protected BlockCake() {
        super(Material.CAKE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCake.BITES, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIIlIlIIIIIllllIIIll) {
        return llllllllllllIIIlIlIIIIIllllIIIll.getValue((IProperty<Integer>)BlockCake.BITES);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIIIlIlIIIIIlllllIllI) {
        return 0;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIIIlIlIIIIlIIlIIIIIl, final IBlockAccess llllllllllllIIIlIlIIIIlIIlIIIIll, final BlockPos llllllllllllIIIlIlIIIIlIIlIIIIlI) {
        return BlockCake.CAKE_AABB[llllllllllllIIIlIlIIIIlIIlIIIIIl.getValue((IProperty<Integer>)BlockCake.BITES)];
    }
    
    private boolean eatCake(final World llllllllllllIIIlIlIIIIlIIIIllIII, final BlockPos llllllllllllIIIlIlIIIIlIIIIlllII, final IBlockState llllllllllllIIIlIlIIIIlIIIIllIll, final EntityPlayer llllllllllllIIIlIlIIIIlIIIIlIlIl) {
        if (!llllllllllllIIIlIlIIIIlIIIIlIlIl.canEat(false)) {
            return false;
        }
        llllllllllllIIIlIlIIIIlIIIIlIlIl.addStat(StatList.CAKE_SLICES_EATEN);
        llllllllllllIIIlIlIIIIlIIIIlIlIl.getFoodStats().addStats(2, 0.1f);
        final int llllllllllllIIIlIlIIIIlIIIIllIIl = llllllllllllIIIlIlIIIIlIIIIllIll.getValue((IProperty<Integer>)BlockCake.BITES);
        if (llllllllllllIIIlIlIIIIlIIIIllIIl < 6) {
            llllllllllllIIIlIlIIIIlIIIIllIII.setBlockState(llllllllllllIIIlIlIIIIlIIIIlllII, llllllllllllIIIlIlIIIIlIIIIllIll.withProperty((IProperty<Comparable>)BlockCake.BITES, llllllllllllIIIlIlIIIIlIIIIllIIl + 1), 3);
        }
        else {
            llllllllllllIIIlIlIIIIlIIIIllIII.setBlockToAir(llllllllllllIIIlIlIIIIlIIIIlllII);
        }
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIIIlIlIIIIlIIIllIlII, final BlockPos llllllllllllIIIlIlIIIIlIIIlIlIII, final IBlockState llllllllllllIIIlIlIIIIlIIIlIIlll, final EntityPlayer llllllllllllIIIlIlIIIIlIIIllIIIl, final EnumHand llllllllllllIIIlIlIIIIlIIIlIIlIl, final EnumFacing llllllllllllIIIlIlIIIIlIIIlIllll, final float llllllllllllIIIlIlIIIIlIIIlIlllI, final float llllllllllllIIIlIlIIIIlIIIlIllIl, final float llllllllllllIIIlIlIIIIlIIIlIllII) {
        if (!llllllllllllIIIlIlIIIIlIIIllIlII.isRemote) {
            return this.eatCake(llllllllllllIIIlIlIIIIlIIIllIlII, llllllllllllIIIlIlIIIIlIIIlIlIII, llllllllllllIIIlIlIIIIlIIIlIIlll, llllllllllllIIIlIlIIIIlIIIllIIIl);
        }
        final ItemStack llllllllllllIIIlIlIIIIlIIIlIlIll = llllllllllllIIIlIlIIIIlIIIllIIIl.getHeldItem(llllllllllllIIIlIlIIIIlIIIlIIlIl);
        return this.eatCake(llllllllllllIIIlIlIIIIlIIIllIlII, llllllllllllIIIlIlIIIIlIIIlIlIII, llllllllllllIIIlIlIIIIlIIIlIIlll, llllllllllllIIIlIlIIIIlIIIllIIIl) || llllllllllllIIIlIlIIIIlIIIlIlIll.func_190926_b();
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllllIIIlIlIIIIIlllIllIlI, final World llllllllllllIIIlIlIIIIIlllIlllII, final BlockPos llllllllllllIIIlIlIIIIIlllIllIll) {
        return (7 - llllllllllllIIIlIlIIIIIlllIllIlI.getValue((IProperty<Integer>)BlockCake.BITES)) * 2;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIIlIlIIIIIllllIIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCake.BITES, llllllllllllIIIlIlIIIIIllllIIlll);
    }
}
