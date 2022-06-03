// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.PropertyInteger;

public class BlockChorusFlower extends Block
{
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChorusFlower.AGE });
    }
    
    public boolean canSurvive(final World llllllllllIllllIIIllllIIIllIlIll, final BlockPos llllllllllIllllIIIllllIIIllIlIlI) {
        final IBlockState llllllllllIllllIIIllllIIIllIlIIl = llllllllllIllllIIIllllIIIllIlIll.getBlockState(llllllllllIllllIIIllllIIIllIlIlI.down());
        final Block llllllllllIllllIIIllllIIIllIlIII = llllllllllIllllIIIllllIIIllIlIIl.getBlock();
        if (llllllllllIllllIIIllllIIIllIlIII == Blocks.CHORUS_PLANT || llllllllllIllllIIIllllIIIllIlIII == Blocks.END_STONE) {
            return true;
        }
        if (llllllllllIllllIIIllllIIIllIlIIl.getMaterial() == Material.AIR) {
            int llllllllllIllllIIIllllIIIllIIlll = 0;
            for (final EnumFacing llllllllllIllllIIIllllIIIllIIllI : EnumFacing.Plane.HORIZONTAL) {
                final IBlockState llllllllllIllllIIIllllIIIllIIlIl = llllllllllIllllIIIllllIIIllIlIll.getBlockState(llllllllllIllllIIIllllIIIllIlIlI.offset(llllllllllIllllIIIllllIIIllIIllI));
                final Block llllllllllIllllIIIllllIIIllIIlII = llllllllllIllllIIIllllIIIllIIlIl.getBlock();
                if (llllllllllIllllIIIllllIIIllIIlII == Blocks.CHORUS_PLANT) {
                    ++llllllllllIllllIIIllllIIIllIIlll;
                }
                else {
                    if (llllllllllIllllIIIllllIIIllIIlIl.getMaterial() != Material.AIR) {
                        return false;
                    }
                    continue;
                }
            }
            return llllllllllIllllIIIllllIIIllIIlll == 1;
        }
        return false;
    }
    
    private static void growTreeRecursive(final World llllllllllIllllIIIllllIIIIIIllll, final BlockPos llllllllllIllllIIIllllIIIIIIlllI, final Random llllllllllIllllIIIllllIIIIIllIll, final BlockPos llllllllllIllllIIIllllIIIIIIllII, final int llllllllllIllllIIIllllIIIIIllIIl, final int llllllllllIllllIIIllllIIIIIIlIlI) {
        int llllllllllIllllIIIllllIIIIIlIlll = llllllllllIllllIIIllllIIIIIllIll.nextInt(4) + 1;
        if (llllllllllIllllIIIllllIIIIIIlIlI == 0) {
            ++llllllllllIllllIIIllllIIIIIlIlll;
        }
        for (int llllllllllIllllIIIllllIIIIIlIllI = 0; llllllllllIllllIIIllllIIIIIlIllI < llllllllllIllllIIIllllIIIIIlIlll; ++llllllllllIllllIIIllllIIIIIlIllI) {
            final BlockPos llllllllllIllllIIIllllIIIIIlIlIl = llllllllllIllllIIIllllIIIIIIlllI.up(llllllllllIllllIIIllllIIIIIlIllI + 1);
            if (!areAllNeighborsEmpty(llllllllllIllllIIIllllIIIIIIllll, llllllllllIllllIIIllllIIIIIlIlIl, null)) {
                return;
            }
            llllllllllIllllIIIllllIIIIIIllll.setBlockState(llllllllllIllllIIIllllIIIIIlIlIl, Blocks.CHORUS_PLANT.getDefaultState(), 2);
        }
        boolean llllllllllIllllIIIllllIIIIIlIlII = false;
        if (llllllllllIllllIIIllllIIIIIIlIlI < 4) {
            int llllllllllIllllIIIllllIIIIIlIIll = llllllllllIllllIIIllllIIIIIllIll.nextInt(4);
            if (llllllllllIllllIIIllllIIIIIIlIlI == 0) {
                ++llllllllllIllllIIIllllIIIIIlIIll;
            }
            for (int llllllllllIllllIIIllllIIIIIlIIlI = 0; llllllllllIllllIIIllllIIIIIlIIlI < llllllllllIllllIIIllllIIIIIlIIll; ++llllllllllIllllIIIllllIIIIIlIIlI) {
                final EnumFacing llllllllllIllllIIIllllIIIIIlIIIl = EnumFacing.Plane.HORIZONTAL.random(llllllllllIllllIIIllllIIIIIllIll);
                final BlockPos llllllllllIllllIIIllllIIIIIlIIII = llllllllllIllllIIIllllIIIIIIlllI.up(llllllllllIllllIIIllllIIIIIlIlll).offset(llllllllllIllllIIIllllIIIIIlIIIl);
                if (Math.abs(llllllllllIllllIIIllllIIIIIlIIII.getX() - llllllllllIllllIIIllllIIIIIIllII.getX()) < llllllllllIllllIIIllllIIIIIllIIl && Math.abs(llllllllllIllllIIIllllIIIIIlIIII.getZ() - llllllllllIllllIIIllllIIIIIIllII.getZ()) < llllllllllIllllIIIllllIIIIIllIIl && llllllllllIllllIIIllllIIIIIIllll.isAirBlock(llllllllllIllllIIIllllIIIIIlIIII) && llllllllllIllllIIIllllIIIIIIllll.isAirBlock(llllllllllIllllIIIllllIIIIIlIIII.down()) && areAllNeighborsEmpty(llllllllllIllllIIIllllIIIIIIllll, llllllllllIllllIIIllllIIIIIlIIII, llllllllllIllllIIIllllIIIIIlIIIl.getOpposite())) {
                    llllllllllIllllIIIllllIIIIIlIlII = true;
                    llllllllllIllllIIIllllIIIIIIllll.setBlockState(llllllllllIllllIIIllllIIIIIlIIII, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                    growTreeRecursive(llllllllllIllllIIIllllIIIIIIllll, llllllllllIllllIIIllllIIIIIlIIII, llllllllllIllllIIIllllIIIIIllIll, llllllllllIllllIIIllllIIIIIIllII, llllllllllIllllIIIllllIIIIIllIIl, llllllllllIllllIIIllllIIIIIIlIlI + 1);
                }
            }
        }
        if (!llllllllllIllllIIIllllIIIIIlIlII) {
            llllllllllIllllIIIllllIIIIIIllll.setBlockState(llllllllllIllllIIIllllIIIIIIlllI.up(llllllllllIllllIIIllllIIIIIlIlll), Blocks.CHORUS_FLOWER.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 5), 2);
        }
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllIllllIIIllllIIIlIIIlII) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIllllIIIllllIIlllIlIII, final Random llllllllllIllllIIIllllIIlllIIlll, final int llllllllllIllllIIIllllIIlllIIllI) {
        return Items.field_190931_a;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllIllllIIIllllIIIIIIIIlI, final IBlockState llllllllllIllllIIIllllIIIIIIIIIl, final BlockPos llllllllllIllllIIIllllIIIIIIIIII, final EnumFacing llllllllllIllllIIIlllIllllllllll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void updateTick(final World llllllllllIllllIIIllllIIllIIIIII, final BlockPos llllllllllIllllIIIllllIIlIllllll, final IBlockState llllllllllIllllIIIllllIIlIlllllI, final Random llllllllllIllllIIIllllIIlIllllIl) {
        if (!this.canSurvive(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIlIllllll)) {
            llllllllllIllllIIIllllIIllIIIIII.destroyBlock(llllllllllIllllIIIllllIIlIllllll, true);
        }
        else {
            final BlockPos llllllllllIllllIIIllllIIllIlIIII = llllllllllIllllIIIllllIIlIllllll.up();
            if (llllllllllIllllIIIllllIIllIIIIII.isAirBlock(llllllllllIllllIIIllllIIllIlIIII) && llllllllllIllllIIIllllIIllIlIIII.getY() < 256) {
                final int llllllllllIllllIIIllllIIllIIllll = llllllllllIllllIIIllllIIlIlllllI.getValue((IProperty<Integer>)BlockChorusFlower.AGE);
                if (llllllllllIllllIIIllllIIllIIllll < 5 && llllllllllIllllIIIllllIIlIllllIl.nextInt(1) == 0) {
                    boolean llllllllllIllllIIIllllIIllIIlllI = false;
                    boolean llllllllllIllllIIIllllIIllIIllIl = false;
                    final IBlockState llllllllllIllllIIIllllIIllIIllII = llllllllllIllllIIIllllIIllIIIIII.getBlockState(llllllllllIllllIIIllllIIlIllllll.down());
                    final Block llllllllllIllllIIIllllIIllIIlIll = llllllllllIllllIIIllllIIllIIllII.getBlock();
                    if (llllllllllIllllIIIllllIIllIIlIll == Blocks.END_STONE) {
                        llllllllllIllllIIIllllIIllIIlllI = true;
                    }
                    else if (llllllllllIllllIIIllllIIllIIlIll == Blocks.CHORUS_PLANT) {
                        int llllllllllIllllIIIllllIIllIIlIlI = 1;
                        int llllllllllIllllIIIllllIIllIIlIIl = 0;
                        while (llllllllllIllllIIIllllIIllIIlIIl < 4) {
                            final Block llllllllllIllllIIIllllIIllIIlIII = llllllllllIllllIIIllllIIllIIIIII.getBlockState(llllllllllIllllIIIllllIIlIllllll.down(llllllllllIllllIIIllllIIllIIlIlI + 1)).getBlock();
                            if (llllllllllIllllIIIllllIIllIIlIII != Blocks.CHORUS_PLANT) {
                                if (llllllllllIllllIIIllllIIllIIlIII == Blocks.END_STONE) {
                                    llllllllllIllllIIIllllIIllIIllIl = true;
                                    break;
                                }
                                break;
                            }
                            else {
                                ++llllllllllIllllIIIllllIIllIIlIlI;
                                ++llllllllllIllllIIIllllIIllIIlIIl;
                            }
                        }
                        int llllllllllIllllIIIllllIIllIIIlll = 4;
                        if (llllllllllIllllIIIllllIIllIIllIl) {
                            ++llllllllllIllllIIIllllIIllIIIlll;
                        }
                        if (llllllllllIllllIIIllllIIllIIlIlI < 2 || llllllllllIllllIIIllllIIlIllllIl.nextInt(llllllllllIllllIIIllllIIllIIIlll) >= llllllllllIllllIIIllllIIllIIlIlI) {
                            llllllllllIllllIIIllllIIllIIlllI = true;
                        }
                    }
                    else if (llllllllllIllllIIIllllIIllIIllII.getMaterial() == Material.AIR) {
                        llllllllllIllllIIIllllIIllIIlllI = true;
                    }
                    if (llllllllllIllllIIIllllIIllIIlllI && areAllNeighborsEmpty(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIllIlIIII, null) && llllllllllIllllIIIllllIIllIIIIII.isAirBlock(llllllllllIllllIIIllllIIlIllllll.up(2))) {
                        llllllllllIllllIIIllllIIllIIIIII.setBlockState(llllllllllIllllIIIllllIIlIllllll, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                        this.placeGrownFlower(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIllIlIIII, llllllllllIllllIIIllllIIllIIllll);
                    }
                    else if (llllllllllIllllIIIllllIIllIIllll < 4) {
                        int llllllllllIllllIIIllllIIllIIIllI = llllllllllIllllIIIllllIIlIllllIl.nextInt(4);
                        boolean llllllllllIllllIIIllllIIllIIIlIl = false;
                        if (llllllllllIllllIIIllllIIllIIllIl) {
                            ++llllllllllIllllIIIllllIIllIIIllI;
                        }
                        for (int llllllllllIllllIIIllllIIllIIIlII = 0; llllllllllIllllIIIllllIIllIIIlII < llllllllllIllllIIIllllIIllIIIllI; ++llllllllllIllllIIIllllIIllIIIlII) {
                            final EnumFacing llllllllllIllllIIIllllIIllIIIIll = EnumFacing.Plane.HORIZONTAL.random(llllllllllIllllIIIllllIIlIllllIl);
                            final BlockPos llllllllllIllllIIIllllIIllIIIIlI = llllllllllIllllIIIllllIIlIllllll.offset(llllllllllIllllIIIllllIIllIIIIll);
                            if (llllllllllIllllIIIllllIIllIIIIII.isAirBlock(llllllllllIllllIIIllllIIllIIIIlI) && llllllllllIllllIIIllllIIllIIIIII.isAirBlock(llllllllllIllllIIIllllIIllIIIIlI.down()) && areAllNeighborsEmpty(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIllIIIIlI, llllllllllIllllIIIllllIIllIIIIll.getOpposite())) {
                                this.placeGrownFlower(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIllIIIIlI, llllllllllIllllIIIllllIIllIIllll + 1);
                                llllllllllIllllIIIllllIIllIIIlIl = true;
                            }
                        }
                        if (llllllllllIllllIIIllllIIllIIIlIl) {
                            llllllllllIllllIIIllllIIllIIIIII.setBlockState(llllllllllIllllIIIllllIIlIllllll, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                        }
                        else {
                            this.placeDeadFlower(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIlIllllll);
                        }
                    }
                    else if (llllllllllIllllIIIllllIIllIIllll == 4) {
                        this.placeDeadFlower(llllllllllIllllIIIllllIIllIIIIII, llllllllllIllllIIIllllIIlIllllll);
                    }
                }
            }
        }
    }
    
    private void placeDeadFlower(final World llllllllllIllllIIIllllIIlIlIIIIl, final BlockPos llllllllllIllllIIIllllIIlIIlllIl) {
        llllllllllIllllIIIllllIIlIlIIIIl.setBlockState(llllllllllIllllIIIllllIIlIIlllIl, this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 5), 2);
        llllllllllIllllIIIllllIIlIlIIIIl.playEvent(1034, llllllllllIllllIIIllllIIlIIlllIl, 0);
    }
    
    public static void generatePlant(final World llllllllllIllllIIIllllIIIIllIIIl, final BlockPos llllllllllIllllIIIllllIIIIlIllII, final Random llllllllllIllllIIIllllIIIIlIlIll, final int llllllllllIllllIIIllllIIIIlIlIlI) {
        llllllllllIllllIIIllllIIIIllIIIl.setBlockState(llllllllllIllllIIIllllIIIIlIllII, Blocks.CHORUS_PLANT.getDefaultState(), 2);
        growTreeRecursive(llllllllllIllllIIIllllIIIIllIIIl, llllllllllIllllIIIllllIIIIlIllII, llllllllllIllllIIIllllIIIIlIlIll, llllllllllIllllIIIllllIIIIlIllII, llllllllllIllllIIIllllIIIIlIlIlI, 0);
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 5);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllIllllIIIllllIIlIIIllIl) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIllllIIIllllIIIIlllIIl) {
        return llllllllllIllllIIIllllIIIIlllIIl.getValue((IProperty<Integer>)BlockChorusFlower.AGE);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllIllllIIIllllIIlIIIIllI, final BlockPos llllllllllIllllIIIllllIIlIIIIlIl) {
        return super.canPlaceBlockAt(llllllllllIllllIIIllllIIlIIIIllI, llllllllllIllllIIIllllIIlIIIIlIl) && this.canSurvive(llllllllllIllllIIIllllIIlIIIIllI, llllllllllIllllIIIllllIIlIIIIlIl);
    }
    
    private void placeGrownFlower(final World llllllllllIllllIIIllllIIlIlIllII, final BlockPos llllllllllIllllIIIllllIIlIlIlIll, final int llllllllllIllllIIIllllIIlIlIlIlI) {
        llllllllllIllllIIIllllIIlIlIllII.setBlockState(llllllllllIllllIIIllllIIlIlIlIll, this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, llllllllllIllllIIIllllIIlIlIlIlI), 2);
        llllllllllIllllIIIllllIIlIlIllII.playEvent(1033, llllllllllIllllIIIllllIIlIlIlIll, 0);
    }
    
    @Override
    public void harvestBlock(final World llllllllllIllllIIIllllIIIlIlIIlI, final EntityPlayer llllllllllIllllIIIllllIIIlIIlIlI, final BlockPos llllllllllIllllIIIllllIIIlIlIIII, final IBlockState llllllllllIllllIIIllllIIIlIIlIII, @Nullable final TileEntity llllllllllIllllIIIllllIIIlIIIlll, final ItemStack llllllllllIllllIIIllllIIIlIIllIl) {
        super.harvestBlock(llllllllllIllllIIIllllIIIlIlIIlI, llllllllllIllllIIIllllIIIlIIlIlI, llllllllllIllllIIIllllIIIlIlIIII, llllllllllIllllIIIllllIIIlIIlIII, llllllllllIllllIIIllllIIIlIIIlll, llllllllllIllllIIIllllIIIlIIllIl);
        Block.spawnAsEntity(llllllllllIllllIIIllllIIIlIlIIlI, llllllllllIllllIIIllllIIIlIlIIII, new ItemStack(Item.getItemFromBlock(this)));
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllIllllIIIllllIIIlllllIl, final World llllllllllIllllIIIllllIIIlllllII, final BlockPos llllllllllIllllIIIllllIIIllllIll, final Block llllllllllIllllIIIllllIIIllllIlI, final BlockPos llllllllllIllllIIIllllIIIllllIIl) {
        if (!this.canSurvive(llllllllllIllllIIIllllIIIlllllII, llllllllllIllllIIIllllIIIllllIll)) {
            llllllllllIllllIIIllllIIIlllllII.scheduleUpdate(llllllllllIllllIIIllllIIIllllIll, this, 1);
        }
    }
    
    protected BlockChorusFlower() {
        super(Material.PLANTS, MapColor.PURPLE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 0));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setTickRandomly(true);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllIllllIIIllllIIlIIIlIll) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIllllIIIllllIIIIllllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, llllllllllIllllIIIllllIIIIllllll);
    }
    
    private static boolean areAllNeighborsEmpty(final World llllllllllIllllIIIllllIIlIIlIlll, final BlockPos llllllllllIllllIIIllllIIlIIlIIlI, final EnumFacing llllllllllIllllIIIllllIIlIIlIIIl) {
        for (final EnumFacing llllllllllIllllIIIllllIIlIIlIlII : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllIllllIIIllllIIlIIlIlII != llllllllllIllllIIIllllIIlIIlIIIl && !llllllllllIllllIIIllllIIlIIlIlll.isAirBlock(llllllllllIllllIIIllllIIlIIlIIlI.offset(llllllllllIllllIIIllllIIlIIlIlII))) {
                return false;
            }
        }
        return true;
    }
}
