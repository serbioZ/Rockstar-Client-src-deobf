// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.DamageSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

public class BlockMagma extends Block
{
    public BlockMagma() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setLightLevel(0.2f);
        this.setTickRandomly(true);
    }
    
    @Override
    public int getPackedLightmapCoords(final IBlockState lllllllllllIllllIIIIIIIlllIIIIIl, final IBlockAccess lllllllllllIllllIIIIIIIlllIIIIII, final BlockPos lllllllllllIllllIIIIIIIllIllllll) {
        return 15728880;
    }
    
    @Override
    public boolean canEntitySpawn(final IBlockState lllllllllllIllllIIIIIIIllIlIllIl, final Entity lllllllllllIllllIIIIIIIllIlIllII) {
        return lllllllllllIllllIIIIIIIllIlIllII.isImmuneToFire();
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllIllllIIIIIIIlllIIlIIl, final BlockPos lllllllllllIllllIIIIIIIlllIIlIII, final Entity lllllllllllIllllIIIIIIIlllIIIlll) {
        if (!lllllllllllIllllIIIIIIIlllIIIlll.isImmuneToFire() && lllllllllllIllllIIIIIIIlllIIIlll instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)lllllllllllIllllIIIIIIIlllIIIlll)) {
            lllllllllllIllllIIIIIIIlllIIIlll.attackEntityFrom(DamageSource.hotFloor, 1.0f);
        }
        super.onEntityWalk(lllllllllllIllllIIIIIIIlllIIlIIl, lllllllllllIllllIIIIIIIlllIIlIII, lllllllllllIllllIIIIIIIlllIIIlll);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIllllIIIIIIIlllIlIIIl, final IBlockAccess lllllllllllIllllIIIIIIIlllIlIIII, final BlockPos lllllllllllIllllIIIIIIIlllIIllll) {
        return MapColor.NETHERRACK;
    }
    
    @Override
    public void updateTick(final World lllllllllllIllllIIIIIIIllIlllIIl, final BlockPos lllllllllllIllllIIIIIIIllIllIIlI, final IBlockState lllllllllllIllllIIIIIIIllIllIlll, final Random lllllllllllIllllIIIIIIIllIllIllI) {
        final BlockPos lllllllllllIllllIIIIIIIllIllIlIl = lllllllllllIllllIIIIIIIllIllIIlI.up();
        final IBlockState lllllllllllIllllIIIIIIIllIllIlII = lllllllllllIllllIIIIIIIllIlllIIl.getBlockState(lllllllllllIllllIIIIIIIllIllIlIl);
        if (lllllllllllIllllIIIIIIIllIllIlII.getBlock() == Blocks.WATER || lllllllllllIllllIIIIIIIllIllIlII.getBlock() == Blocks.FLOWING_WATER) {
            lllllllllllIllllIIIIIIIllIlllIIl.setBlockToAir(lllllllllllIllllIIIIIIIllIllIlIl);
            lllllllllllIllllIIIIIIIllIlllIIl.playSound(null, lllllllllllIllllIIIIIIIllIllIIlI, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllIllllIIIIIIIllIlllIIl.rand.nextFloat() - lllllllllllIllllIIIIIIIllIlllIIl.rand.nextFloat()) * 0.8f);
            if (lllllllllllIllllIIIIIIIllIlllIIl instanceof WorldServer) {
                ((WorldServer)lllllllllllIllllIIIIIIIllIlllIIl).spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIllllIIIIIIIllIllIlIl.getX() + 0.5, lllllllllllIllllIIIIIIIllIllIlIl.getY() + 0.25, lllllllllllIllllIIIIIIIllIllIlIl.getZ() + 0.5, 8, 0.5, 0.25, 0.5, 0.0, new int[0]);
            }
        }
    }
}
