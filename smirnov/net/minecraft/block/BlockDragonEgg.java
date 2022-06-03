// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockDragonEgg extends Block
{
    protected static final /* synthetic */ AxisAlignedBB DRAGON_EGG_AABB;
    
    public BlockDragonEgg() {
        super(Material.DRAGON_EGG, MapColor.BLACK);
    }
    
    private void checkFall(final World lllllllllllIIIllllIIllllIllIllll, final BlockPos lllllllllllIIIllllIIllllIllIlllI) {
        if (BlockFalling.canFallThrough(lllllllllllIIIllllIIllllIllIllll.getBlockState(lllllllllllIIIllllIIllllIllIlllI.down())) && lllllllllllIIIllllIIllllIllIlllI.getY() >= 0) {
            final int lllllllllllIIIllllIIllllIllIllIl = 32;
            if (!BlockFalling.fallInstantly && lllllllllllIIIllllIIllllIllIllll.isAreaLoaded(lllllllllllIIIllllIIllllIllIlllI.add(-32, -32, -32), lllllllllllIIIllllIIllllIllIlllI.add(32, 32, 32))) {
                lllllllllllIIIllllIIllllIllIllll.spawnEntityInWorld(new EntityFallingBlock(lllllllllllIIIllllIIllllIllIllll, lllllllllllIIIllllIIllllIllIlllI.getX() + 0.5f, lllllllllllIIIllllIIllllIllIlllI.getY(), lllllllllllIIIllllIIllllIllIlllI.getZ() + 0.5f, this.getDefaultState()));
            }
            else {
                lllllllllllIIIllllIIllllIllIllll.setBlockToAir(lllllllllllIIIllllIIllllIllIlllI);
                BlockPos lllllllllllIIIllllIIllllIllIllII;
                for (lllllllllllIIIllllIIllllIllIllII = lllllllllllIIIllllIIllllIllIlllI; BlockFalling.canFallThrough(lllllllllllIIIllllIIllllIllIllll.getBlockState(lllllllllllIIIllllIIllllIllIllII)) && lllllllllllIIIllllIIllllIllIllII.getY() > 0; lllllllllllIIIllllIIllllIllIllII = lllllllllllIIIllllIIllllIllIllII.down()) {}
                if (lllllllllllIIIllllIIllllIllIllII.getY() > 0) {
                    lllllllllllIIIllllIIllllIllIllll.setBlockState(lllllllllllIIIllllIIllllIllIllII, this.getDefaultState(), 2);
                }
            }
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIIIllllIIlllllIIIlllI, final BlockPos lllllllllllIIIllllIIlllllIIlIIIl, final IBlockState lllllllllllIIIllllIIlllllIIlIIII) {
        lllllllllllIIIllllIIlllllIIIlllI.scheduleUpdate(lllllllllllIIIllllIIlllllIIlIIIl, this, this.tickRate(lllllllllllIIIllllIIlllllIIIlllI));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIIllllIIllllIllIIIlI, final BlockPos lllllllllllIIIllllIIllllIllIIIIl, final IBlockState lllllllllllIIIllllIIllllIllIIIII, final EntityPlayer lllllllllllIIIllllIIllllIlIlllll, final EnumHand lllllllllllIIIllllIIllllIlIllllI, final EnumFacing lllllllllllIIIllllIIllllIlIlllIl, final float lllllllllllIIIllllIIllllIlIlllII, final float lllllllllllIIIllllIIllllIlIllIll, final float lllllllllllIIIllllIIllllIlIllIlI) {
        this.teleport(lllllllllllIIIllllIIllllIllIIIlI, lllllllllllIIIllllIIllllIllIIIIl);
        return true;
    }
    
    @Override
    public int tickRate(final World lllllllllllIIIllllIIllllIIlIIIIl) {
        return 5;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIllllIIllllIIIlllIl) {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIIIllllIIllllIIIllIll, final IBlockAccess lllllllllllIIIllllIIllllIIIllIlI, final BlockPos lllllllllllIIIllllIIllllIIIllIIl, final EnumFacing lllllllllllIIIllllIIllllIIIllIII) {
        return true;
    }
    
    @Override
    public void onBlockClicked(final World lllllllllllIIIllllIIllllIlIIlllI, final BlockPos lllllllllllIIIllllIIllllIlIlIIIl, final EntityPlayer lllllllllllIIIllllIIllllIlIlIIII) {
        this.teleport(lllllllllllIIIllllIIllllIlIIlllI, lllllllllllIIIllllIIllllIlIlIIIl);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIIllllIIlllllIIIlIII, final World lllllllllllIIIllllIIlllllIIIIlll, final BlockPos lllllllllllIIIllllIIlllllIIIIllI, final Block lllllllllllIIIllllIIlllllIIIIlIl, final BlockPos lllllllllllIIIllllIIlllllIIIIlII) {
        lllllllllllIIIllllIIlllllIIIIlll.scheduleUpdate(lllllllllllIIIllllIIlllllIIIIllI, this, this.tickRate(lllllllllllIIIllllIIlllllIIIIlll));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIllllIIllllIIIlllll) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIllllIIlllllIIllIIl, final IBlockAccess lllllllllllIIIllllIIlllllIIllIII, final BlockPos lllllllllllIIIllllIIlllllIIlIlll) {
        return BlockDragonEgg.DRAGON_EGG_AABB;
    }
    
    private void teleport(final World lllllllllllIIIllllIIllllIIllllIl, final BlockPos lllllllllllIIIllllIIllllIIlIlllI) {
        final IBlockState lllllllllllIIIllllIIllllIIlllIll = lllllllllllIIIllllIIllllIIllllIl.getBlockState(lllllllllllIIIllllIIllllIIlIlllI);
        if (lllllllllllIIIllllIIllllIIlllIll.getBlock() == this) {
            for (int lllllllllllIIIllllIIllllIIlllIlI = 0; lllllllllllIIIllllIIllllIIlllIlI < 1000; ++lllllllllllIIIllllIIllllIIlllIlI) {
                final BlockPos lllllllllllIIIllllIIllllIIlllIIl = lllllllllllIIIllllIIllllIIlIlllI.add(lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(16) - lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(16), lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(8) - lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(8), lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(16) - lllllllllllIIIllllIIllllIIllllIl.rand.nextInt(16));
                if (lllllllllllIIIllllIIllllIIllllIl.getBlockState(lllllllllllIIIllllIIllllIIlllIIl).getBlock().blockMaterial == Material.AIR) {
                    if (lllllllllllIIIllllIIllllIIllllIl.isRemote) {
                        for (int lllllllllllIIIllllIIllllIIlllIII = 0; lllllllllllIIIllllIIllllIIlllIII < 128; ++lllllllllllIIIllllIIllllIIlllIII) {
                            final double lllllllllllIIIllllIIllllIIllIlll = lllllllllllIIIllllIIllllIIllllIl.rand.nextDouble();
                            final float lllllllllllIIIllllIIllllIIllIllI = (lllllllllllIIIllllIIllllIIllllIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final float lllllllllllIIIllllIIllllIIllIlIl = (lllllllllllIIIllllIIllllIIllllIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final float lllllllllllIIIllllIIllllIIllIlII = (lllllllllllIIIllllIIllllIIllllIl.rand.nextFloat() - 0.5f) * 0.2f;
                            final double lllllllllllIIIllllIIllllIIllIIll = lllllllllllIIIllllIIllllIIlllIIl.getX() + (lllllllllllIIIllllIIllllIIlIlllI.getX() - lllllllllllIIIllllIIllllIIlllIIl.getX()) * lllllllllllIIIllllIIllllIIllIlll + (lllllllllllIIIllllIIllllIIllllIl.rand.nextDouble() - 0.5) + 0.5;
                            final double lllllllllllIIIllllIIllllIIllIIlI = lllllllllllIIIllllIIllllIIlllIIl.getY() + (lllllllllllIIIllllIIllllIIlIlllI.getY() - lllllllllllIIIllllIIllllIIlllIIl.getY()) * lllllllllllIIIllllIIllllIIllIlll + lllllllllllIIIllllIIllllIIllllIl.rand.nextDouble() - 0.5;
                            final double lllllllllllIIIllllIIllllIIllIIIl = lllllllllllIIIllllIIllllIIlllIIl.getZ() + (lllllllllllIIIllllIIllllIIlIlllI.getZ() - lllllllllllIIIllllIIllllIIlllIIl.getZ()) * lllllllllllIIIllllIIllllIIllIlll + (lllllllllllIIIllllIIllllIIllllIl.rand.nextDouble() - 0.5) + 0.5;
                            lllllllllllIIIllllIIllllIIllllIl.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllIIIllllIIllllIIllIIll, lllllllllllIIIllllIIllllIIllIIlI, lllllllllllIIIllllIIllllIIllIIIl, lllllllllllIIIllllIIllllIIllIllI, lllllllllllIIIllllIIllllIIllIlIl, lllllllllllIIIllllIIllllIIllIlII, new int[0]);
                        }
                    }
                    else {
                        lllllllllllIIIllllIIllllIIllllIl.setBlockState(lllllllllllIIIllllIIllllIIlllIIl, lllllllllllIIIllllIIllllIIlllIll, 2);
                        lllllllllllIIIllllIIllllIIllllIl.setBlockToAir(lllllllllllIIIllllIIllllIIlIlllI);
                    }
                    return;
                }
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIllllIIllllIIIlIllI, final IBlockState lllllllllllIIIllllIIllllIIIlIlIl, final BlockPos lllllllllllIIIllllIIllllIIIlIlII, final EnumFacing lllllllllllIIIllllIIllllIIIlIIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void updateTick(final World lllllllllllIIIllllIIllllIlllllII, final BlockPos lllllllllllIIIllllIIllllIlllIllI, final IBlockState lllllllllllIIIllllIIllllIllllIlI, final Random lllllllllllIIIllllIIllllIllllIIl) {
        this.checkFall(lllllllllllIIIllllIIllllIlllllII, lllllllllllIIIllllIIllllIlllIllI);
    }
    
    static {
        DRAGON_EGG_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
    }
}
