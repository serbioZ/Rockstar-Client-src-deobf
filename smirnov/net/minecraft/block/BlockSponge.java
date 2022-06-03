// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Tuple;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public class BlockSponge extends Block
{
    public static final /* synthetic */ PropertyBool WET;
    
    @Override
    public void onBlockAdded(final World lllllllllllIlIlllIIlllllIIIlIIIl, final BlockPos lllllllllllIlIlllIIlllllIIIlIlII, final IBlockState lllllllllllIlIlllIIlllllIIIlIIll) {
        this.tryAbsorb(lllllllllllIlIlllIIlllllIIIlIIIl, lllllllllllIlIlllIIlllllIIIlIlII, lllllllllllIlIlllIIlllllIIIlIIll);
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + ".dry.name");
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIlIlllIIllllIllIIIlll, final NonNullList<ItemStack> lllllllllllIlIlllIIllllIllIIIlII) {
        lllllllllllIlIlllIIllllIllIIIlII.add(new ItemStack(this, 1, 0));
        lllllllllllIlIlllIIllllIllIIIlII.add(new ItemStack(this, 1, 1));
    }
    
    private boolean absorb(final World lllllllllllIlIlllIIllllIllIlIlll, final BlockPos lllllllllllIlIlllIIllllIllIlIllI) {
        final Queue<Tuple<BlockPos, Integer>> lllllllllllIlIlllIIllllIlllIIIII = (Queue<Tuple<BlockPos, Integer>>)Lists.newLinkedList();
        final List<BlockPos> lllllllllllIlIlllIIllllIllIlllll = (List<BlockPos>)Lists.newArrayList();
        lllllllllllIlIlllIIllllIlllIIIII.add(new Tuple<BlockPos, Integer>(lllllllllllIlIlllIIllllIllIlIllI, 0));
        int lllllllllllIlIlllIIllllIllIllllI = 0;
        while (!lllllllllllIlIlllIIllllIlllIIIII.isEmpty()) {
            final Tuple<BlockPos, Integer> lllllllllllIlIlllIIllllIllIlllIl = lllllllllllIlIlllIIllllIlllIIIII.poll();
            final BlockPos lllllllllllIlIlllIIllllIllIlllII = lllllllllllIlIlllIIllllIllIlllIl.getFirst();
            final int lllllllllllIlIlllIIllllIllIllIll = lllllllllllIlIlllIIllllIllIlllIl.getSecond();
            final char lllllllllllIlIlllIIllllIllIIllII;
            final boolean lllllllllllIlIlllIIllllIllIIllIl = ((EnumFacing[])(Object)(lllllllllllIlIlllIIllllIllIIllII = (char)(Object)EnumFacing.values())).length != 0;
            for (double lllllllllllIlIlllIIllllIllIIlllI = 0; lllllllllllIlIlllIIllllIllIIlllI < (lllllllllllIlIlllIIllllIllIIllIl ? 1 : 0); ++lllllllllllIlIlllIIllllIllIIlllI) {
                final EnumFacing lllllllllllIlIlllIIllllIllIllIlI = lllllllllllIlIlllIIllllIllIIllII[lllllllllllIlIlllIIllllIllIIlllI];
                final BlockPos lllllllllllIlIlllIIllllIllIllIIl = lllllllllllIlIlllIIllllIllIlllII.offset(lllllllllllIlIlllIIllllIllIllIlI);
                if (lllllllllllIlIlllIIllllIllIlIlll.getBlockState(lllllllllllIlIlllIIllllIllIllIIl).getMaterial() == Material.WATER) {
                    lllllllllllIlIlllIIllllIllIlIlll.setBlockState(lllllllllllIlIlllIIllllIllIllIIl, Blocks.AIR.getDefaultState(), 2);
                    lllllllllllIlIlllIIllllIllIlllll.add(lllllllllllIlIlllIIllllIllIllIIl);
                    ++lllllllllllIlIlllIIllllIllIllllI;
                    if (lllllllllllIlIlllIIllllIllIllIll < 6) {
                        lllllllllllIlIlllIIllllIlllIIIII.add(new Tuple<BlockPos, Integer>(lllllllllllIlIlllIIllllIllIllIIl, lllllllllllIlIlllIIllllIllIllIll + 1));
                    }
                }
            }
            if (lllllllllllIlIlllIIllllIllIllllI > 64) {
                break;
            }
        }
        for (final BlockPos lllllllllllIlIlllIIllllIllIllIII : lllllllllllIlIlllIIllllIllIlllll) {
            lllllllllllIlIlllIIllllIllIlIlll.notifyNeighborsOfStateChange(lllllllllllIlIlllIIllllIllIllIII, Blocks.AIR, false);
        }
        return lllllllllllIlIlllIIllllIllIllllI > 0;
    }
    
    protected void tryAbsorb(final World lllllllllllIlIlllIIllllIllllIlll, final BlockPos lllllllllllIlIlllIIllllIllllIIlI, final IBlockState lllllllllllIlIlllIIllllIllllIlIl) {
        if (!lllllllllllIlIlllIIllllIllllIlIl.getValue((IProperty<Boolean>)BlockSponge.WET) && this.absorb(lllllllllllIlIlllIIllllIllllIlll, lllllllllllIlIlllIIllllIllllIIlI)) {
            lllllllllllIlIlllIIllllIllllIlll.setBlockState(lllllllllllIlIlllIIllllIllllIIlI, lllllllllllIlIlllIIllllIllllIlIl.withProperty((IProperty<Comparable>)BlockSponge.WET, true), 2);
            lllllllllllIlIlllIIllllIllllIlll.playEvent(2001, lllllllllllIlIlllIIllllIllllIIlI, Block.getIdFromBlock(Blocks.WATER));
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSponge.WET });
    }
    
    protected BlockSponge() {
        super(Material.SPONGE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSponge.WET, false));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIlllIIllllIlIlIllIl, final World lllllllllllIlIlllIIllllIlIlIIlII, final BlockPos lllllllllllIlIlllIIllllIlIlIIIll, final Random lllllllllllIlIlllIIllllIlIlIlIlI) {
        if (lllllllllllIlIlllIIllllIlIlIllIl.getValue((IProperty<Boolean>)BlockSponge.WET)) {
            final EnumFacing lllllllllllIlIlllIIllllIlIlIlIIl = EnumFacing.random(lllllllllllIlIlllIIllllIlIlIlIlI);
            if (lllllllllllIlIlllIIllllIlIlIlIIl != EnumFacing.UP && !lllllllllllIlIlllIIllllIlIlIIlII.getBlockState(lllllllllllIlIlllIIllllIlIlIIIll.offset(lllllllllllIlIlllIIllllIlIlIlIIl)).isFullyOpaque()) {
                double lllllllllllIlIlllIIllllIlIlIlIII = lllllllllllIlIlllIIllllIlIlIIIll.getX();
                double lllllllllllIlIlllIIllllIlIlIIlll = lllllllllllIlIlllIIllllIlIlIIIll.getY();
                double lllllllllllIlIlllIIllllIlIlIIllI = lllllllllllIlIlllIIllllIlIlIIIll.getZ();
                if (lllllllllllIlIlllIIllllIlIlIlIIl == EnumFacing.DOWN) {
                    lllllllllllIlIlllIIllllIlIlIIlll -= 0.05;
                    lllllllllllIlIlllIIllllIlIlIlIII += lllllllllllIlIlllIIllllIlIlIlIlI.nextDouble();
                    lllllllllllIlIlllIIllllIlIlIIllI += lllllllllllIlIlllIIllllIlIlIlIlI.nextDouble();
                }
                else {
                    lllllllllllIlIlllIIllllIlIlIIlll += lllllllllllIlIlllIIllllIlIlIlIlI.nextDouble() * 0.8;
                    if (lllllllllllIlIlllIIllllIlIlIlIIl.getAxis() == EnumFacing.Axis.X) {
                        lllllllllllIlIlllIIllllIlIlIIllI += lllllllllllIlIlllIIllllIlIlIlIlI.nextDouble();
                        if (lllllllllllIlIlllIIllllIlIlIlIIl == EnumFacing.EAST) {
                            ++lllllllllllIlIlllIIllllIlIlIlIII;
                        }
                        else {
                            lllllllllllIlIlllIIllllIlIlIlIII += 0.05;
                        }
                    }
                    else {
                        lllllllllllIlIlllIIllllIlIlIlIII += lllllllllllIlIlllIIllllIlIlIlIlI.nextDouble();
                        if (lllllllllllIlIlllIIllllIlIlIlIIl == EnumFacing.SOUTH) {
                            ++lllllllllllIlIlllIIllllIlIlIIllI;
                        }
                        else {
                            lllllllllllIlIlllIIllllIlIlIIllI += 0.05;
                        }
                    }
                }
                lllllllllllIlIlllIIllllIlIlIIlII.spawnParticle(EnumParticleTypes.DRIP_WATER, lllllllllllIlIlllIIllllIlIlIlIII, lllllllllllIlIlllIIllllIlIlIIlll, lllllllllllIlIlllIIllllIlIlIIllI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlIlllIIlllllIIIIIIIl, final World lllllllllllIlIlllIIlllllIIIIIllI, final BlockPos lllllllllllIlIlllIIlllllIIIIIlIl, final Block lllllllllllIlIlllIIlllllIIIIIlII, final BlockPos lllllllllllIlIlllIIllllIllllllIl) {
        this.tryAbsorb(lllllllllllIlIlllIIlllllIIIIIllI, lllllllllllIlIlllIIlllllIIIIIlIl, lllllllllllIlIlllIIlllllIIIIIIIl);
        super.neighborChanged(lllllllllllIlIlllIIlllllIIIIIIIl, lllllllllllIlIlllIIlllllIIIIIllI, lllllllllllIlIlllIIlllllIIIIIlIl, lllllllllllIlIlllIIlllllIIIIIlII, lllllllllllIlIlllIIllllIllllllIl);
    }
    
    static {
        WET = PropertyBool.create("wet");
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIlIlllIIlllllIIIllIll) {
        return ((boolean)lllllllllllIlIlllIIlllllIIIllIll.getValue((IProperty<Boolean>)BlockSponge.WET)) ? 1 : 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlIlllIIllllIlIlllIll) {
        return ((boolean)lllllllllllIlIlllIIllllIlIlllIll.getValue((IProperty<Boolean>)BlockSponge.WET)) ? 1 : 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlIlllIIllllIlIlllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSponge.WET, (lllllllllllIlIlllIIllllIlIlllllI & 0x1) == 0x1);
    }
}
