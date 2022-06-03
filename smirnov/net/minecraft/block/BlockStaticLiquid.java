// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class BlockStaticLiquid extends BlockLiquid
{
    @Override
    public void neighborChanged(final IBlockState lllllllllllIllllIlIIlIlllIlllllI, final World lllllllllllIllllIlIIlIlllIllllIl, final BlockPos lllllllllllIllllIlIIlIllllIIIIlI, final Block lllllllllllIllllIlIIlIllllIIIIIl, final BlockPos lllllllllllIllllIlIIlIllllIIIIII) {
        if (!this.checkForMixing(lllllllllllIllllIlIIlIlllIllllIl, lllllllllllIllllIlIIlIllllIIIIlI, lllllllllllIllllIlIIlIlllIlllllI)) {
            this.updateLiquid(lllllllllllIllllIlIIlIlllIllllIl, lllllllllllIllllIlIIlIllllIIIIlI, lllllllllllIllllIlIIlIlllIlllllI);
        }
    }
    
    private void updateLiquid(final World lllllllllllIllllIlIIlIlllIllIlIl, final BlockPos lllllllllllIllllIlIIlIlllIlIllll, final IBlockState lllllllllllIllllIlIIlIlllIllIIll) {
        final BlockDynamicLiquid lllllllllllIllllIlIIlIlllIllIIlI = BlockLiquid.getFlowingBlock(this.blockMaterial);
        lllllllllllIllllIlIIlIlllIllIlIl.setBlockState(lllllllllllIllllIlIIlIlllIlIllll, lllllllllllIllllIlIIlIlllIllIIlI.getDefaultState().withProperty((IProperty<Comparable>)BlockStaticLiquid.LEVEL, (Integer)lllllllllllIllllIlIIlIlllIllIIll.getValue((IProperty<V>)BlockStaticLiquid.LEVEL)), 2);
        lllllllllllIllllIlIIlIlllIllIlIl.scheduleUpdate(lllllllllllIllllIlIIlIlllIlIllll, lllllllllllIllllIlIIlIlllIllIIlI, this.tickRate(lllllllllllIllllIlIIlIlllIllIlIl));
    }
    
    private boolean getCanBlockBurn(final World lllllllllllIllllIlIIlIllIllllIlI, final BlockPos lllllllllllIllllIlIIlIllIllllIll) {
        return (lllllllllllIllllIlIIlIllIllllIll.getY() < 0 || lllllllllllIllllIlIIlIllIllllIll.getY() >= 256 || lllllllllllIllllIlIIlIllIllllIlI.isBlockLoaded(lllllllllllIllllIlIIlIllIllllIll)) && lllllllllllIllllIlIIlIllIllllIlI.getBlockState(lllllllllllIllllIlIIlIllIllllIll).getMaterial().getCanBurn();
    }
    
    @Override
    public void updateTick(final World lllllllllllIllllIlIIlIlllIIllIII, final BlockPos lllllllllllIllllIlIIlIlllIlIIIlI, final IBlockState lllllllllllIllllIlIIlIlllIlIIIIl, final Random lllllllllllIllllIlIIlIlllIIlIllI) {
        if (this.blockMaterial == Material.LAVA && lllllllllllIllllIlIIlIlllIIllIII.getGameRules().getBoolean("doFireTick")) {
            final int lllllllllllIllllIlIIlIlllIIlllll = lllllllllllIllllIlIIlIlllIIlIllI.nextInt(3);
            if (lllllllllllIllllIlIIlIlllIIlllll > 0) {
                BlockPos lllllllllllIllllIlIIlIlllIIllllI = lllllllllllIllllIlIIlIlllIlIIIlI;
                for (int lllllllllllIllllIlIIlIlllIIlllIl = 0; lllllllllllIllllIlIIlIlllIIlllIl < lllllllllllIllllIlIIlIlllIIlllll; ++lllllllllllIllllIlIIlIlllIIlllIl) {
                    lllllllllllIllllIlIIlIlllIIllllI = lllllllllllIllllIlIIlIlllIIllllI.add(lllllllllllIllllIlIIlIlllIIlIllI.nextInt(3) - 1, 1, lllllllllllIllllIlIIlIlllIIlIllI.nextInt(3) - 1);
                    if (lllllllllllIllllIlIIlIlllIIllllI.getY() >= 0 && lllllllllllIllllIlIIlIlllIIllllI.getY() < 256 && !lllllllllllIllllIlIIlIlllIIllIII.isBlockLoaded(lllllllllllIllllIlIIlIlllIIllllI)) {
                        return;
                    }
                    final Block lllllllllllIllllIlIIlIlllIIlllII = lllllllllllIllllIlIIlIlllIIllIII.getBlockState(lllllllllllIllllIlIIlIlllIIllllI).getBlock();
                    if (lllllllllllIllllIlIIlIlllIIlllII.blockMaterial == Material.AIR) {
                        if (this.isSurroundingBlockFlammable(lllllllllllIllllIlIIlIlllIIllIII, lllllllllllIllllIlIIlIlllIIllllI)) {
                            lllllllllllIllllIlIIlIlllIIllIII.setBlockState(lllllllllllIllllIlIIlIlllIIllllI, Blocks.FIRE.getDefaultState());
                            return;
                        }
                    }
                    else if (lllllllllllIllllIlIIlIlllIIlllII.blockMaterial.blocksMovement()) {
                        return;
                    }
                }
            }
            else {
                for (int lllllllllllIllllIlIIlIlllIIllIll = 0; lllllllllllIllllIlIIlIlllIIllIll < 3; ++lllllllllllIllllIlIIlIlllIIllIll) {
                    final BlockPos lllllllllllIllllIlIIlIlllIIllIlI = lllllllllllIllllIlIIlIlllIlIIIlI.add(lllllllllllIllllIlIIlIlllIIlIllI.nextInt(3) - 1, 0, lllllllllllIllllIlIIlIlllIIlIllI.nextInt(3) - 1);
                    if (lllllllllllIllllIlIIlIlllIIllIlI.getY() >= 0 && lllllllllllIllllIlIIlIlllIIllIlI.getY() < 256 && !lllllllllllIllllIlIIlIlllIIllIII.isBlockLoaded(lllllllllllIllllIlIIlIlllIIllIlI)) {
                        return;
                    }
                    if (lllllllllllIllllIlIIlIlllIIllIII.isAirBlock(lllllllllllIllllIlIIlIlllIIllIlI.up()) && this.getCanBlockBurn(lllllllllllIllllIlIIlIlllIIllIII, lllllllllllIllllIlIIlIlllIIllIlI)) {
                        lllllllllllIllllIlIIlIlllIIllIII.setBlockState(lllllllllllIllllIlIIlIlllIIllIlI.up(), Blocks.FIRE.getDefaultState());
                    }
                }
            }
        }
    }
    
    protected BlockStaticLiquid(final Material lllllllllllIllllIlIIlIllllIIlIlI) {
        super(lllllllllllIllllIlIIlIllllIIlIlI);
        this.setTickRandomly(false);
        if (lllllllllllIllllIlIIlIllllIIlIlI == Material.LAVA) {
            this.setTickRandomly(true);
        }
    }
    
    protected boolean isSurroundingBlockFlammable(final World lllllllllllIllllIlIIlIlllIIIlIIl, final BlockPos lllllllllllIllllIlIIlIlllIIIIlII) {
        final byte lllllllllllIllllIlIIlIlllIIIIIII;
        final long lllllllllllIllllIlIIlIlllIIIIIIl = ((EnumFacing[])(Object)(lllllllllllIllllIlIIlIlllIIIIIII = (byte)(Object)EnumFacing.values())).length;
        for (String lllllllllllIllllIlIIlIlllIIIIIlI = (String)0; lllllllllllIllllIlIIlIlllIIIIIlI < lllllllllllIllllIlIIlIlllIIIIIIl; ++lllllllllllIllllIlIIlIlllIIIIIlI) {
            final EnumFacing lllllllllllIllllIlIIlIlllIIIIlll = lllllllllllIllllIlIIlIlllIIIIIII[lllllllllllIllllIlIIlIlllIIIIIlI];
            if (this.getCanBlockBurn(lllllllllllIllllIlIIlIlllIIIlIIl, lllllllllllIllllIlIIlIlllIIIIlII.offset(lllllllllllIllllIlIIlIlllIIIIlll))) {
                return true;
            }
        }
        return false;
    }
}
