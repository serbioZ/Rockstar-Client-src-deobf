// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockDaylightDetector extends BlockContainer
{
    public static final /* synthetic */ PropertyInteger POWER;
    private final /* synthetic */ boolean inverted;
    protected static final /* synthetic */ AxisAlignedBB DAYLIGHT_DETECTOR_AABB;
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIlIllIlllIIIIlIIIII) {
        return false;
    }
    
    public BlockDaylightDetector(final boolean lllllllllllIIIlIllIlllIIIllIllII) {
        super(Material.WOOD);
        this.inverted = lllllllllllIIIlIllIlllIIIllIllII;
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, 0));
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHardness(0.2f);
        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName("daylightDetector");
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIIlIllIlllIIIIlIlIlI, final Random lllllllllllIIIlIllIlllIIIIlIlIIl, final int lllllllllllIIIlIllIlllIIIIlIlIII) {
        return Item.getItemFromBlock(Blocks.DAYLIGHT_DETECTOR);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIIlIllIlllIIIIIIIlII, final NonNullList<ItemStack> lllllllllllIIIlIllIlllIIIIIIIllI) {
        if (!this.inverted) {
            super.getSubBlocks(lllllllllllIIIlIllIlllIIIIIIIlII, lllllllllllIIIlIllIlllIIIIIIIllI);
        }
    }
    
    public void updatePower(final World lllllllllllIIIlIllIlllIIIlIlIllI, final BlockPos lllllllllllIIIlIllIlllIIIlIlIlIl) {
        if (lllllllllllIIIlIllIlllIIIlIlIllI.provider.func_191066_m()) {
            final IBlockState lllllllllllIIIlIllIlllIIIlIlIlII = lllllllllllIIIlIllIlllIIIlIlIllI.getBlockState(lllllllllllIIIlIllIlllIIIlIlIlIl);
            int lllllllllllIIIlIllIlllIIIlIlIIll = lllllllllllIIIlIllIlllIIIlIlIllI.getLightFor(EnumSkyBlock.SKY, lllllllllllIIIlIllIlllIIIlIlIlIl) - lllllllllllIIIlIllIlllIIIlIlIllI.getSkylightSubtracted();
            float lllllllllllIIIlIllIlllIIIlIlIIlI = lllllllllllIIIlIllIlllIIIlIlIllI.getCelestialAngleRadians(1.0f);
            if (this.inverted) {
                lllllllllllIIIlIllIlllIIIlIlIIll = 15 - lllllllllllIIIlIllIlllIIIlIlIIll;
            }
            if (lllllllllllIIIlIllIlllIIIlIlIIll > 0 && !this.inverted) {
                final float lllllllllllIIIlIllIlllIIIlIlIIIl = (lllllllllllIIIlIllIlllIIIlIlIIlI < 3.1415927f) ? 0.0f : 6.2831855f;
                lllllllllllIIIlIllIlllIIIlIlIIlI += (lllllllllllIIIlIllIlllIIIlIlIIIl - lllllllllllIIIlIllIlllIIIlIlIIlI) * 0.2f;
                lllllllllllIIIlIllIlllIIIlIlIIll = Math.round(lllllllllllIIIlIllIlllIIIlIlIIll * MathHelper.cos(lllllllllllIIIlIllIlllIIIlIlIIlI));
            }
            lllllllllllIIIlIllIlllIIIlIlIIll = MathHelper.clamp(lllllllllllIIIlIllIlllIIIlIlIIll, 0, 15);
            if (lllllllllllIIIlIllIlllIIIlIlIlII.getValue((IProperty<Integer>)BlockDaylightDetector.POWER) != lllllllllllIIIlIllIlllIIIlIlIIll) {
                lllllllllllIIIlIllIlllIIIlIlIllI.setBlockState(lllllllllllIIIlIllIlllIIIlIlIlIl, lllllllllllIIIlIllIlllIIIlIlIlII.withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, lllllllllllIIIlIllIlllIIIlIlIIll), 3);
            }
        }
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIlIllIlllIIIIllIlII, final BlockPos lllllllllllIIIlIllIlllIIIIllllIl, final IBlockState lllllllllllIIIlIllIlllIIIIllllII, final EntityPlayer lllllllllllIIIlIllIlllIIIIllIIIl, final EnumHand lllllllllllIIIlIllIlllIIIIllIIII, final EnumFacing lllllllllllIIIlIllIlllIIIIlIllll, final float lllllllllllIIIlIllIlllIIIIlIlllI, final float lllllllllllIIIlIllIlllIIIIlIllIl, final float lllllllllllIIIlIllIlllIIIIllIllI) {
        if (!lllllllllllIIIlIllIlllIIIIllIIIl.isAllowEdit()) {
            return super.onBlockActivated(lllllllllllIIIlIllIlllIIIIllIlII, lllllllllllIIIlIllIlllIIIIllllIl, lllllllllllIIIlIllIlllIIIIllllII, lllllllllllIIIlIllIlllIIIIllIIIl, lllllllllllIIIlIllIlllIIIIllIIII, lllllllllllIIIlIllIlllIIIIlIllll, lllllllllllIIIlIllIlllIIIIlIlllI, lllllllllllIIIlIllIlllIIIIlIllIl, lllllllllllIIIlIllIlllIIIIllIllI);
        }
        if (lllllllllllIIIlIllIlllIIIIllIlII.isRemote) {
            return true;
        }
        if (this.inverted) {
            lllllllllllIIIlIllIlllIIIIllIlII.setBlockState(lllllllllllIIIlIllIlllIIIIllllIl, Blocks.DAYLIGHT_DETECTOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, (Integer)lllllllllllIIIlIllIlllIIIIllllII.getValue((IProperty<V>)BlockDaylightDetector.POWER)), 4);
            Blocks.DAYLIGHT_DETECTOR.updatePower(lllllllllllIIIlIllIlllIIIIllIlII, lllllllllllIIIlIllIlllIIIIllllIl);
        }
        else {
            lllllllllllIIIlIllIlllIIIIllIlII.setBlockState(lllllllllllIIIlIllIlllIIIIllllIl, Blocks.DAYLIGHT_DETECTOR_INVERTED.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, (Integer)lllllllllllIIIlIllIlllIIIIllllII.getValue((IProperty<V>)BlockDaylightDetector.POWER)), 4);
            Blocks.DAYLIGHT_DETECTOR_INVERTED.updatePower(lllllllllllIIIlIllIlllIIIIllIlII, lllllllllllIIIlIllIlllIIIIllllIl);
        }
        return true;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllIIIlIllIlllIIIlIlllll, final IBlockAccess lllllllllllIIIlIllIlllIIIllIIIlI, final BlockPos lllllllllllIIIlIllIlllIIIllIIIIl, final EnumFacing lllllllllllIIIlIllIlllIIIllIIIII) {
        return lllllllllllIIIlIllIlllIIIlIlllll.getValue((IProperty<Integer>)BlockDaylightDetector.POWER);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIlIllIlllIIIIlIIIlI) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDaylightDetector.POWER });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIlIllIlllIIIIIlIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, lllllllllllIIIlIllIlllIIIIIlIIll);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIlIllIlllIIIllIlIII, final IBlockAccess lllllllllllIIIlIllIlllIIIllIIlll, final BlockPos lllllllllllIIIlIllIlllIIIllIIllI) {
        return BlockDaylightDetector.DAYLIGHT_DETECTOR_AABB;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllIIIlIllIlllIIIIIlllII) {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIlIllIlllIIIIIIIIII, final IBlockState lllllllllllIIIlIllIllIllllllllll, final BlockPos lllllllllllIIIlIllIllIlllllllllI, final EnumFacing lllllllllllIIIlIllIllIllllllllII) {
        return (lllllllllllIIIlIllIllIllllllllII == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIIIlIllIlllIIIIIllIlI, final int lllllllllllIIIlIllIlllIIIIIllIIl) {
        return new TileEntityDaylightDetector();
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIIIlIllIlllIIIIIllllI) {
        return EnumBlockRenderType.MODEL;
    }
    
    static {
        POWER = PropertyInteger.create("power", 0, 15);
        DAYLIGHT_DETECTOR_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIIlIllIlllIIIIlIIllI, final BlockPos lllllllllllIIIlIllIlllIIIIlIIlIl, final IBlockState lllllllllllIIIlIllIlllIIIIlIIlII) {
        return new ItemStack(Blocks.DAYLIGHT_DETECTOR);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIllIlllIIIIIIllll) {
        return lllllllllllIIIlIllIlllIIIIIIllll.getValue((IProperty<Integer>)BlockDaylightDetector.POWER);
    }
}
