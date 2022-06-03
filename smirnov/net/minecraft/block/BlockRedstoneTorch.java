// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import java.util.List;
import net.minecraft.world.World;
import java.util.Map;

public class BlockRedstoneTorch extends BlockTorch
{
    private final /* synthetic */ boolean isOn;
    private static final /* synthetic */ Map<World, List<Toggle>> toggles;
    
    @Override
    public int getStrongPower(final IBlockState llllllllllIllllllllllllIIllIIIlI, final IBlockAccess llllllllllIllllllllllllIIlIlllIl, final BlockPos llllllllllIllllllllllllIIllIIIII, final EnumFacing llllllllllIllllllllllllIIlIllIll) {
        return (llllllllllIllllllllllllIIlIllIll == EnumFacing.DOWN) ? llllllllllIllllllllllllIIllIIIlI.getWeakPower(llllllllllIllllllllllllIIlIlllIl, llllllllllIllllllllllllIIllIIIII, llllllllllIllllllllllllIIlIllIll) : 0;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllIllllllllllllIllIlIIIl, final BlockPos llllllllllIllllllllllllIllIlIIII, final IBlockState llllllllllIllllllllllllIllIIllll) {
        if (this.isOn) {
            final String llllllllllIllllllllllllIllIIIlll;
            final boolean llllllllllIllllllllllllIllIIlIII = ((EnumFacing[])(Object)(llllllllllIllllllllllllIllIIIlll = (String)(Object)EnumFacing.values())).length != 0;
            for (final EnumFacing llllllllllIllllllllllllIllIIlllI : llllllllllIllllllllllllIllIIIlll) {
                llllllllllIllllllllllllIllIlIIIl.notifyNeighborsOfStateChange(llllllllllIllllllllllllIllIlIIII.offset(llllllllllIllllllllllllIllIIlllI), this, false);
            }
        }
    }
    
    protected BlockRedstoneTorch(final boolean llllllllllIllllllllllllIllIlllII) {
        this.isOn = llllllllllIllllllllllllIllIlllII;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    private boolean shouldBeOff(final World llllllllllIllllllllllllIlIlIIIll, final BlockPos llllllllllIllllllllllllIlIlIIIlI, final IBlockState llllllllllIllllllllllllIlIlIIIIl) {
        final EnumFacing llllllllllIllllllllllllIlIlIIIII = llllllllllIllllllllllllIlIlIIIIl.getValue((IProperty<EnumFacing>)BlockRedstoneTorch.FACING).getOpposite();
        return llllllllllIllllllllllllIlIlIIIll.isSidePowered(llllllllllIllllllllllllIlIlIIIlI.offset(llllllllllIllllllllllllIlIlIIIII), llllllllllIllllllllllllIlIlIIIII);
    }
    
    @Override
    public void randomTick(final World llllllllllIllllllllllllIlIIllIlI, final BlockPos llllllllllIllllllllllllIlIIllIIl, final IBlockState llllllllllIllllllllllllIlIIllIII, final Random llllllllllIllllllllllllIlIIlIlll) {
    }
    
    @Override
    public ItemStack getItem(final World llllllllllIllllllllllllIIIllIIlI, final BlockPos llllllllllIllllllllllllIIIllIIIl, final IBlockState llllllllllIllllllllllllIIIllIIII) {
        return new ItemStack(Blocks.REDSTONE_TORCH);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllIllllllllllllIIlllIIII, final World llllllllllIllllllllllllIIllIlIIl, final BlockPos llllllllllIllllllllllllIIllIlIII, final Block llllllllllIllllllllllllIIllIllIl, final BlockPos llllllllllIllllllllllllIIllIllII) {
        if (!this.onNeighborChangeInternal(llllllllllIllllllllllllIIllIlIIl, llllllllllIllllllllllllIIllIlIII, llllllllllIllllllllllllIIlllIIII) && this.isOn == this.shouldBeOff(llllllllllIllllllllllllIIllIlIIl, llllllllllIllllllllllllIIllIlIII, llllllllllIllllllllllllIIlllIIII)) {
            llllllllllIllllllllllllIIllIlIIl.scheduleUpdate(llllllllllIllllllllllllIIllIlIII, this, this.tickRate(llllllllllIllllllllllllIIllIlIIl));
        }
    }
    
    @Override
    public boolean isAssociatedBlock(final Block llllllllllIllllllllllllIIIlIllIl) {
        return llllllllllIllllllllllllIIIlIllIl == Blocks.UNLIT_REDSTONE_TORCH || llllllllllIllllllllllllIIIlIllIl == Blocks.REDSTONE_TORCH;
    }
    
    private boolean isBurnedOut(final World llllllllllIllllllllllllIlllIllll, final BlockPos llllllllllIllllllllllllIlllIlllI, final boolean llllllllllIllllllllllllIlllIIllI) {
        if (!BlockRedstoneTorch.toggles.containsKey(llllllllllIllllllllllllIlllIllll)) {
            BlockRedstoneTorch.toggles.put(llllllllllIllllllllllllIlllIllll, Lists.newArrayList());
        }
        final List<Toggle> llllllllllIllllllllllllIlllIllII = BlockRedstoneTorch.toggles.get(llllllllllIllllllllllllIlllIllll);
        if (llllllllllIllllllllllllIlllIIllI) {
            llllllllllIllllllllllllIlllIllII.add(new Toggle(llllllllllIllllllllllllIlllIlllI, llllllllllIllllllllllllIlllIllll.getTotalWorldTime()));
        }
        int llllllllllIllllllllllllIlllIlIll = 0;
        for (int llllllllllIllllllllllllIlllIlIlI = 0; llllllllllIllllllllllllIlllIlIlI < llllllllllIllllllllllllIlllIllII.size(); ++llllllllllIllllllllllllIlllIlIlI) {
            final Toggle llllllllllIllllllllllllIlllIlIIl = llllllllllIllllllllllllIlllIllII.get(llllllllllIllllllllllllIlllIlIlI);
            if (llllllllllIllllllllllllIlllIlIIl.pos.equals(llllllllllIllllllllllllIlllIlllI) && ++llllllllllIllllllllllllIlllIlIll >= 8) {
                return true;
            }
        }
        return false;
    }
    
    static {
        toggles = Maps.newHashMap();
    }
    
    @Override
    public void breakBlock(final World llllllllllIllllllllllllIlIlllllI, final BlockPos llllllllllIllllllllllllIlIllllIl, final IBlockState llllllllllIllllllllllllIlIllllII) {
        if (this.isOn) {
            final short llllllllllIllllllllllllIlIllIlII;
            final long llllllllllIllllllllllllIlIllIlIl = ((EnumFacing[])(Object)(llllllllllIllllllllllllIlIllIlII = (short)(Object)EnumFacing.values())).length;
            for (double llllllllllIllllllllllllIlIllIllI = 0; llllllllllIllllllllllllIlIllIllI < llllllllllIllllllllllllIlIllIlIl; ++llllllllllIllllllllllllIlIllIllI) {
                final EnumFacing llllllllllIllllllllllllIlIlllIll = llllllllllIllllllllllllIlIllIlII[llllllllllIllllllllllllIlIllIllI];
                llllllllllIllllllllllllIlIlllllI.notifyNeighborsOfStateChange(llllllllllIllllllllllllIlIllllIl.offset(llllllllllIllllllllllllIlIlllIll), this, false);
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllIllllllllllllIIIllllIl, final World llllllllllIllllllllllllIIIllllII, final BlockPos llllllllllIllllllllllllIIIlllIll, final Random llllllllllIllllllllllllIIIlllIlI) {
        if (this.isOn) {
            double llllllllllIllllllllllllIIlIIIlII = llllllllllIllllllllllllIIIlllIll.getX() + 0.5 + (llllllllllIllllllllllllIIIlllIlI.nextDouble() - 0.5) * 0.2;
            double llllllllllIllllllllllllIIlIIIIll = llllllllllIllllllllllllIIIlllIll.getY() + 0.7 + (llllllllllIllllllllllllIIIlllIlI.nextDouble() - 0.5) * 0.2;
            double llllllllllIllllllllllllIIlIIIIlI = llllllllllIllllllllllllIIIlllIll.getZ() + 0.5 + (llllllllllIllllllllllllIIIlllIlI.nextDouble() - 0.5) * 0.2;
            final EnumFacing llllllllllIllllllllllllIIlIIIIIl = llllllllllIllllllllllllIIIllllIl.getValue((IProperty<EnumFacing>)BlockRedstoneTorch.FACING);
            if (llllllllllIllllllllllllIIlIIIIIl.getAxis().isHorizontal()) {
                final EnumFacing llllllllllIllllllllllllIIlIIIIII = llllllllllIllllllllllllIIlIIIIIl.getOpposite();
                final double llllllllllIllllllllllllIIIllllll = 0.27;
                llllllllllIllllllllllllIIlIIIlII += 0.27 * llllllllllIllllllllllllIIlIIIIII.getFrontOffsetX();
                llllllllllIllllllllllllIIlIIIIll += 0.22;
                llllllllllIllllllllllllIIlIIIIlI += 0.27 * llllllllllIllllllllllllIIlIIIIII.getFrontOffsetZ();
            }
            llllllllllIllllllllllllIIIllllII.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllIllllllllllllIIlIIIlII, llllllllllIllllllllllllIIlIIIIll, llllllllllIllllllllllllIIlIIIIlI, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public boolean canProvidePower(final IBlockState llllllllllIllllllllllllIIlIlIlIl) {
        return true;
    }
    
    @Override
    public int tickRate(final World llllllllllIllllllllllllIllIllIlI) {
        return 2;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIllllllllllllIIlIllIIl, final Random llllllllllIllllllllllllIIlIllIII, final int llllllllllIllllllllllllIIlIlIlll) {
        return Item.getItemFromBlock(Blocks.REDSTONE_TORCH);
    }
    
    @Override
    public void updateTick(final World llllllllllIllllllllllllIIlllllll, final BlockPos llllllllllIllllllllllllIIllllllI, final IBlockState llllllllllIllllllllllllIIlllllIl, final Random llllllllllIllllllllllllIlIIIIlll) {
        final boolean llllllllllIllllllllllllIlIIIIllI = this.shouldBeOff(llllllllllIllllllllllllIIlllllll, llllllllllIllllllllllllIIllllllI, llllllllllIllllllllllllIIlllllIl);
        final List<Toggle> llllllllllIllllllllllllIlIIIIlIl = BlockRedstoneTorch.toggles.get(llllllllllIllllllllllllIIlllllll);
        while (llllllllllIllllllllllllIlIIIIlIl != null && !llllllllllIllllllllllllIlIIIIlIl.isEmpty() && llllllllllIllllllllllllIIlllllll.getTotalWorldTime() - llllllllllIllllllllllllIlIIIIlIl.get(0).time > 60L) {
            llllllllllIllllllllllllIlIIIIlIl.remove(0);
        }
        if (this.isOn) {
            if (llllllllllIllllllllllllIlIIIIllI) {
                llllllllllIllllllllllllIIlllllll.setBlockState(llllllllllIllllllllllllIIllllllI, Blocks.UNLIT_REDSTONE_TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneTorch.FACING, (EnumFacing)llllllllllIllllllllllllIIlllllIl.getValue((IProperty<V>)BlockRedstoneTorch.FACING)), 3);
                if (this.isBurnedOut(llllllllllIllllllllllllIIlllllll, llllllllllIllllllllllllIIllllllI, true)) {
                    llllllllllIllllllllllllIIlllllll.playSound(null, llllllllllIllllllllllllIIllllllI, SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, SoundCategory.BLOCKS, 0.5f, 2.6f + (llllllllllIllllllllllllIIlllllll.rand.nextFloat() - llllllllllIllllllllllllIIlllllll.rand.nextFloat()) * 0.8f);
                    for (int llllllllllIllllllllllllIlIIIIlII = 0; llllllllllIllllllllllllIlIIIIlII < 5; ++llllllllllIllllllllllllIlIIIIlII) {
                        final double llllllllllIllllllllllllIlIIIIIll = llllllllllIllllllllllllIIllllllI.getX() + llllllllllIllllllllllllIlIIIIlll.nextDouble() * 0.6 + 0.2;
                        final double llllllllllIllllllllllllIlIIIIIlI = llllllllllIllllllllllllIIllllllI.getY() + llllllllllIllllllllllllIlIIIIlll.nextDouble() * 0.6 + 0.2;
                        final double llllllllllIllllllllllllIlIIIIIIl = llllllllllIllllllllllllIIllllllI.getZ() + llllllllllIllllllllllllIlIIIIlll.nextDouble() * 0.6 + 0.2;
                        llllllllllIllllllllllllIIlllllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllIllllllllllllIlIIIIIll, llllllllllIllllllllllllIlIIIIIlI, llllllllllIllllllllllllIlIIIIIIl, 0.0, 0.0, 0.0, new int[0]);
                    }
                    llllllllllIllllllllllllIIlllllll.scheduleUpdate(llllllllllIllllllllllllIIllllllI, llllllllllIllllllllllllIIlllllll.getBlockState(llllllllllIllllllllllllIIllllllI).getBlock(), 160);
                }
            }
        }
        else if (!llllllllllIllllllllllllIlIIIIllI && !this.isBurnedOut(llllllllllIllllllllllllIIlllllll, llllllllllIllllllllllllIIllllllI, false)) {
            llllllllllIllllllllllllIIlllllll.setBlockState(llllllllllIllllllllllllIIllllllI, Blocks.REDSTONE_TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneTorch.FACING, (EnumFacing)llllllllllIllllllllllllIIlllllIl.getValue((IProperty<V>)BlockRedstoneTorch.FACING)), 3);
        }
    }
    
    @Override
    public int getWeakPower(final IBlockState llllllllllIllllllllllllIlIlIllll, final IBlockAccess llllllllllIllllllllllllIlIlIlllI, final BlockPos llllllllllIllllllllllllIlIlIllIl, final EnumFacing llllllllllIllllllllllllIlIlIllII) {
        return (this.isOn && llllllllllIllllllllllllIlIlIllll.getValue((IProperty<Comparable>)BlockRedstoneTorch.FACING) != llllllllllIllllllllllllIlIlIllII) ? 15 : 0;
    }
    
    static class Toggle
    {
        /* synthetic */ long time;
        /* synthetic */ BlockPos pos;
        
        public Toggle(final BlockPos lllllllllllIllIIlIIlIlIIIIIlIIlI, final long lllllllllllIllIIlIIlIlIIIIIIlllI) {
            this.pos = lllllllllllIllIIlIIlIlIIIIIlIIlI;
            this.time = lllllllllllIllIIlIIlIlIIIIIIlllI;
        }
    }
}
