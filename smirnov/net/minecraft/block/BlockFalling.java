// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class BlockFalling extends Block
{
    public static /* synthetic */ boolean fallInstantly;
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlIIlIIIlIllIIIlIlIll, final World lllllllllllIlIIlIIIlIllIIIlIlIlI, final BlockPos lllllllllllIlIIlIIIlIllIIIlIlIIl, final Block lllllllllllIlIIlIIIlIllIIIlIlIII, final BlockPos lllllllllllIlIIlIIIlIllIIIlIIlll) {
        lllllllllllIlIIlIIIlIllIIIlIlIlI.scheduleUpdate(lllllllllllIlIIlIIIlIllIIIlIlIIl, this, this.tickRate(lllllllllllIlIIlIIIlIllIIIlIlIlI));
    }
    
    @Override
    public void updateTick(final World lllllllllllIlIIlIIIlIllIIIIllIlI, final BlockPos lllllllllllIlIIlIIIlIllIIIIllllI, final IBlockState lllllllllllIlIIlIIIlIllIIIIlllIl, final Random lllllllllllIlIIlIIIlIllIIIIlllII) {
        if (!lllllllllllIlIIlIIIlIllIIIIllIlI.isRemote) {
            this.checkFallable(lllllllllllIlIIlIIIlIllIIIIllIlI, lllllllllllIlIIlIIIlIllIIIIllllI);
        }
    }
    
    public int getDustColor(final IBlockState lllllllllllIlIIlIIIlIlIlllIllIIl) {
        return -16777216;
    }
    
    public void onEndFalling(final World lllllllllllIlIIlIIIlIlIllllllIlI, final BlockPos lllllllllllIlIIlIIIlIlIllllllIIl, final IBlockState lllllllllllIlIIlIIIlIlIllllllIII, final IBlockState lllllllllllIlIIlIIIlIlIlllllIlll) {
    }
    
    @Override
    public int tickRate(final World lllllllllllIlIIlIIIlIllIIIIIIlIl) {
        return 2;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlIIlIIIlIllIIIllIlIl, final BlockPos lllllllllllIlIIlIIIlIllIIIllIlII, final IBlockState lllllllllllIlIIlIIIlIllIIIllIIll) {
        lllllllllllIlIIlIIIlIllIIIllIlIl.scheduleUpdate(lllllllllllIlIIlIIIlIllIIIllIlII, this, this.tickRate(lllllllllllIlIIlIIIlIllIIIllIlIl));
    }
    
    public BlockFalling() {
        super(Material.SAND);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public BlockFalling(final Material lllllllllllIlIIlIIIlIllIIIlllIlI) {
        super(lllllllllllIlIIlIIIlIllIIIlllIlI);
    }
    
    private void checkFallable(final World lllllllllllIlIIlIIIlIllIIIIIllII, final BlockPos lllllllllllIlIIlIIIlIllIIIIIlIll) {
        if (canFallThrough(lllllllllllIlIIlIIIlIllIIIIIllII.getBlockState(lllllllllllIlIIlIIIlIllIIIIIlIll.down())) && lllllllllllIlIIlIIIlIllIIIIIlIll.getY() >= 0) {
            final int lllllllllllIlIIlIIIlIllIIIIlIIII = 32;
            if (!BlockFalling.fallInstantly && lllllllllllIlIIlIIIlIllIIIIIllII.isAreaLoaded(lllllllllllIlIIlIIIlIllIIIIIlIll.add(-32, -32, -32), lllllllllllIlIIlIIIlIllIIIIIlIll.add(32, 32, 32))) {
                if (!lllllllllllIlIIlIIIlIllIIIIIllII.isRemote) {
                    final EntityFallingBlock lllllllllllIlIIlIIIlIllIIIIIllll = new EntityFallingBlock(lllllllllllIlIIlIIIlIllIIIIIllII, lllllllllllIlIIlIIIlIllIIIIIlIll.getX() + 0.5, lllllllllllIlIIlIIIlIllIIIIIlIll.getY(), lllllllllllIlIIlIIIlIllIIIIIlIll.getZ() + 0.5, lllllllllllIlIIlIIIlIllIIIIIllII.getBlockState(lllllllllllIlIIlIIIlIllIIIIIlIll));
                    this.onStartFalling(lllllllllllIlIIlIIIlIllIIIIIllll);
                    lllllllllllIlIIlIIIlIllIIIIIllII.spawnEntityInWorld(lllllllllllIlIIlIIIlIllIIIIIllll);
                }
            }
            else {
                lllllllllllIlIIlIIIlIllIIIIIllII.setBlockToAir(lllllllllllIlIIlIIIlIllIIIIIlIll);
                BlockPos lllllllllllIlIIlIIIlIllIIIIIlllI;
                for (lllllllllllIlIIlIIIlIllIIIIIlllI = lllllllllllIlIIlIIIlIllIIIIIlIll.down(); canFallThrough(lllllllllllIlIIlIIIlIllIIIIIllII.getBlockState(lllllllllllIlIIlIIIlIllIIIIIlllI)) && lllllllllllIlIIlIIIlIllIIIIIlllI.getY() > 0; lllllllllllIlIIlIIIlIllIIIIIlllI = lllllllllllIlIIlIIIlIllIIIIIlllI.down()) {}
                if (lllllllllllIlIIlIIIlIllIIIIIlllI.getY() > 0) {
                    lllllllllllIlIIlIIIlIllIIIIIllII.setBlockState(lllllllllllIlIIlIIIlIllIIIIIlllI.up(), this.getDefaultState());
                }
            }
        }
    }
    
    protected void onStartFalling(final EntityFallingBlock lllllllllllIlIIlIIIlIllIIIIIIlll) {
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIIlIIIlIlIllllIlIlI, final World lllllllllllIlIIlIIIlIlIllllIlIIl, final BlockPos lllllllllllIlIIlIIIlIlIllllIlIII, final Random lllllllllllIlIIlIIIlIlIllllIIlll) {
        if (lllllllllllIlIIlIIIlIlIllllIIlll.nextInt(16) == 0) {
            final BlockPos lllllllllllIlIIlIIIlIlIllllIIllI = lllllllllllIlIIlIIIlIlIllllIlIII.down();
            if (canFallThrough(lllllllllllIlIIlIIIlIlIllllIlIIl.getBlockState(lllllllllllIlIIlIIIlIlIllllIIllI))) {
                final double lllllllllllIlIIlIIIlIlIllllIIlIl = lllllllllllIlIIlIIIlIlIllllIlIII.getX() + lllllllllllIlIIlIIIlIlIllllIIlll.nextFloat();
                final double lllllllllllIlIIlIIIlIlIllllIIlII = lllllllllllIlIIlIIIlIlIllllIlIII.getY() - 0.05;
                final double lllllllllllIlIIlIIIlIlIllllIIIll = lllllllllllIlIIlIIIlIlIllllIlIII.getZ() + lllllllllllIlIIlIIIlIlIllllIIlll.nextFloat();
                lllllllllllIlIIlIIIlIlIllllIlIIl.spawnParticle(EnumParticleTypes.FALLING_DUST, lllllllllllIlIIlIIIlIlIllllIIlIl, lllllllllllIlIIlIIIlIlIllllIIlII, lllllllllllIlIIlIIIlIlIllllIIIll, 0.0, 0.0, 0.0, Block.getStateId(lllllllllllIlIIlIIIlIlIllllIlIlI));
            }
        }
    }
    
    public void func_190974_b(final World lllllllllllIlIIlIIIlIlIlllllIlIl, final BlockPos lllllllllllIlIIlIIIlIlIlllllIlII) {
    }
    
    public static boolean canFallThrough(final IBlockState lllllllllllIlIIlIIIlIlIllllllllI) {
        final Block lllllllllllIlIIlIIIlIllIIIIIIIII = lllllllllllIlIIlIIIlIlIllllllllI.getBlock();
        final Material lllllllllllIlIIlIIIlIlIlllllllll = lllllllllllIlIIlIIIlIlIllllllllI.getMaterial();
        return lllllllllllIlIIlIIIlIllIIIIIIIII == Blocks.FIRE || lllllllllllIlIIlIIIlIlIlllllllll == Material.AIR || lllllllllllIlIIlIIIlIlIlllllllll == Material.WATER || lllllllllllIlIIlIIIlIlIlllllllll == Material.LAVA;
    }
}
