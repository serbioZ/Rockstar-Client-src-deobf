// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.stats.StatList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockSnow extends Block
{
    public static final /* synthetic */ PropertyInteger LAYERS;
    protected static final /* synthetic */ AxisAlignedBB[] SNOW_AABB;
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIllIIIlllllIIlIlIIllI, final IBlockAccess lllllllllllIllIIIlllllIIlIIlllll, final BlockPos lllllllllllIllIIIlllllIIlIIllllI, final EnumFacing lllllllllllIllIIIlllllIIlIlIIIll) {
        if (lllllllllllIllIIIlllllIIlIlIIIll == EnumFacing.UP) {
            return true;
        }
        final IBlockState lllllllllllIllIIIlllllIIlIlIIIlI = lllllllllllIllIIIlllllIIlIIlllll.getBlockState(lllllllllllIllIIIlllllIIlIIllllI.offset(lllllllllllIllIIIlllllIIlIlIIIll));
        return (lllllllllllIllIIIlllllIIlIlIIIlI.getBlock() != this || lllllllllllIllIIIlllllIIlIlIIIlI.getValue((IProperty<Integer>)BlockSnow.LAYERS) < lllllllllllIllIIIlllllIIlIlIIllI.getValue((IProperty<Integer>)BlockSnow.LAYERS)) && super.shouldSideBeRendered(lllllllllllIllIIIlllllIIlIlIIllI, lllllllllllIllIIIlllllIIlIIlllll, lllllllllllIllIIIlllllIIlIIllllI, lllllllllllIllIIIlllllIIlIlIIIll);
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllIllIIIlllllIIlIIlIIlI, final BlockPos lllllllllllIllIIIlllllIIlIIlIIIl) {
        return lllllllllllIllIIIlllllIIlIIlIIlI.getBlockState(lllllllllllIllIIIlllllIIlIIlIIIl).getValue((IProperty<Integer>)BlockSnow.LAYERS) == 1;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSnow.LAYERS });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIllIIIlllllIIlIIIlIll) {
        return lllllllllllIllIIIlllllIIlIIIlIll.getValue((IProperty<Integer>)BlockSnow.LAYERS) - 1;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIllIIIlllllIlIIIllIlI) {
        return lllllllllllIllIIIlllllIlIIIllIlI.getValue((IProperty<Integer>)BlockSnow.LAYERS) == 8;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIllIIIlllllIlIIlIlIII, final IBlockAccess lllllllllllIllIIIlllllIlIIlIIlll, final BlockPos lllllllllllIllIIIlllllIlIIlIIllI) {
        return BlockSnow.SNOW_AABB[lllllllllllIllIIIlllllIlIIlIlIII.getValue((IProperty<Integer>)BlockSnow.LAYERS)];
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllIIIlllllIIlllIIlII, final World lllllllllllIllIIIlllllIIllIlllIl, final BlockPos lllllllllllIllIIIlllllIIllIlllII, final Block lllllllllllIllIIIlllllIIlllIIIIl, final BlockPos lllllllllllIllIIIlllllIIlllIIIII) {
        this.checkAndDropBlock(lllllllllllIllIIIlllllIIllIlllIl, lllllllllllIllIIIlllllIIllIlllII, lllllllllllIllIIIlllllIIlllIIlII);
    }
    
    static {
        LAYERS = PropertyInteger.create("layers", 1, 8);
        SNOW_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIllIIIlllllIlIIlIIIIl, final BlockPos lllllllllllIllIIIlllllIlIIlIIIII) {
        return lllllllllllIllIIIlllllIlIIlIIIIl.getBlockState(lllllllllllIllIIIlllllIlIIlIIIII).getValue((IProperty<Integer>)BlockSnow.LAYERS) < 5;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllIllIIIlllllIIllIIIIlI, final EntityPlayer lllllllllllIllIIIlllllIIllIIlIII, final BlockPos lllllllllllIllIIIlllllIIllIIIIII, final IBlockState lllllllllllIllIIIlllllIIlIllllll, @Nullable final TileEntity lllllllllllIllIIIlllllIIllIIIlIl, final ItemStack lllllllllllIllIIIlllllIIllIIIlII) {
        Block.spawnAsEntity(lllllllllllIllIIIlllllIIllIIIIlI, lllllllllllIllIIIlllllIIllIIIIII, new ItemStack(Items.SNOWBALL, lllllllllllIllIIIlllllIIlIllllll.getValue((IProperty<Integer>)BlockSnow.LAYERS) + 1, 0));
        lllllllllllIllIIIlllllIIllIIIIlI.setBlockToAir(lllllllllllIllIIIlllllIIllIIIIII);
        lllllllllllIllIIIlllllIIllIIlIII.addStat(StatList.getBlockStats(this));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIIIlllllIlIIIlIlll, final IBlockState lllllllllllIllIIIlllllIlIIIlIllI, final BlockPos lllllllllllIllIIIlllllIlIIIlIlIl, final EnumFacing lllllllllllIllIIIlllllIlIIIlIIll) {
        return (lllllllllllIllIIIlllllIlIIIlIIll == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIllIIIlllllIIlIIllIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSnow.LAYERS, (lllllllllllIllIIIlllllIIlIIllIII & 0x7) + 1);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIIIlllllIIllllllII) {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIllIIIlllllIIlIlllIIl) {
        return 0;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIIIlllllIIlllllllI) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIllIIIlllllIlIIIIlIll, final IBlockAccess lllllllllllIllIIIlllllIlIIIIlIlI, final BlockPos lllllllllllIllIIIlllllIlIIIIlIIl) {
        final int lllllllllllIllIIIlllllIlIIIIlIII = lllllllllllIllIIIlllllIlIIIIlIll.getValue((IProperty<Integer>)BlockSnow.LAYERS) - 1;
        final float lllllllllllIllIIIlllllIlIIIIIlll = 0.125f;
        final AxisAlignedBB lllllllllllIllIIIlllllIlIIIIIllI = lllllllllllIllIIIlllllIlIIIIlIll.getBoundingBox(lllllllllllIllIIIlllllIlIIIIlIlI, lllllllllllIllIIIlllllIlIIIIlIIl);
        return new AxisAlignedBB(lllllllllllIllIIIlllllIlIIIIIllI.minX, lllllllllllIllIIIlllllIlIIIIIllI.minY, lllllllllllIllIIIlllllIlIIIIIllI.minZ, lllllllllllIllIIIlllllIlIIIIIllI.maxX, lllllllllllIllIIIlllllIlIIIIlIII * 0.125f, lllllllllllIllIIIlllllIlIIIIIllI.maxZ);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIllIIIlllllIIlllIlllI, final BlockPos lllllllllllIllIIIlllllIIllllIIll) {
        final IBlockState lllllllllllIllIIIlllllIIllllIIlI = lllllllllllIllIIIlllllIIlllIlllI.getBlockState(lllllllllllIllIIIlllllIIllllIIll.down());
        final Block lllllllllllIllIIIlllllIIllllIIIl = lllllllllllIllIIIlllllIIllllIIlI.getBlock();
        if (lllllllllllIllIIIlllllIIllllIIIl != Blocks.ICE && lllllllllllIllIIIlllllIIllllIIIl != Blocks.PACKED_ICE && lllllllllllIllIIIlllllIIllllIIIl != Blocks.BARRIER) {
            final BlockFaceShape lllllllllllIllIIIlllllIIllllIIII = lllllllllllIllIIIlllllIIllllIIlI.func_193401_d(lllllllllllIllIIIlllllIIlllIlllI, lllllllllllIllIIIlllllIIllllIIll.down(), EnumFacing.UP);
            return lllllllllllIllIIIlllllIIllllIIII == BlockFaceShape.SOLID || lllllllllllIllIIIlllllIIllllIIlI.getMaterial() == Material.LEAVES || (lllllllllllIllIIIlllllIIllllIIIl == this && lllllllllllIllIIIlllllIIllllIIlI.getValue((IProperty<Integer>)BlockSnow.LAYERS) == 8);
        }
        return false;
    }
    
    private boolean checkAndDropBlock(final World lllllllllllIllIIIlllllIIllIlIllI, final BlockPos lllllllllllIllIIIlllllIIllIlIlIl, final IBlockState lllllllllllIllIIIlllllIIllIlIIII) {
        if (!this.canPlaceBlockAt(lllllllllllIllIIIlllllIIllIlIllI, lllllllllllIllIIIlllllIIllIlIlIl)) {
            this.dropBlockAsItem(lllllllllllIllIIIlllllIIllIlIllI, lllllllllllIllIIIlllllIIllIlIlIl, lllllllllllIllIIIlllllIIllIlIIII, 0);
            lllllllllllIllIIIlllllIIllIlIllI.setBlockToAir(lllllllllllIllIIIlllllIIllIlIlIl);
            return false;
        }
        return true;
    }
    
    protected BlockSnow() {
        super(Material.SNOW);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSnow.LAYERS, 1));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void updateTick(final World lllllllllllIllIIIlllllIIlIlIllll, final BlockPos lllllllllllIllIIIlllllIIlIllIIll, final IBlockState lllllllllllIllIIIlllllIIlIllIIlI, final Random lllllllllllIllIIIlllllIIlIllIIIl) {
        if (lllllllllllIllIIIlllllIIlIlIllll.getLightFor(EnumSkyBlock.BLOCK, lllllllllllIllIIIlllllIIlIllIIll) > 11) {
            this.dropBlockAsItem(lllllllllllIllIIIlllllIIlIlIllll, lllllllllllIllIIIlllllIIlIllIIll, lllllllllllIllIIIlllllIIlIlIllll.getBlockState(lllllllllllIllIIIlllllIIlIllIIll), 0);
            lllllllllllIllIIIlllllIIlIlIllll.setBlockToAir(lllllllllllIllIIIlllllIIlIllIIll);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIllIIIlllllIIlIllllIl, final Random lllllllllllIllIIIlllllIIlIllllII, final int lllllllllllIllIIIlllllIIlIlllIll) {
        return Items.SNOWBALL;
    }
}
