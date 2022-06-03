// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;

public class BlockRedstoneOre extends Block
{
    private final /* synthetic */ boolean isOn;
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllIllllIIIlllIlIIIlIll, final Random llllllllllllIllllIIIlllIlIIIIlll) {
        return this.quantityDropped(llllllllllllIllllIIIlllIlIIIIlll) + llllllllllllIllllIIIlllIlIIIIlll.nextInt(llllllllllllIllllIIIlllIlIIIlIll + 1);
    }
    
    private void spawnParticles(final World llllllllllllIllllIIIlllIIlIlIIIl, final BlockPos llllllllllllIllllIIIlllIIlIllIII) {
        final Random llllllllllllIllllIIIlllIIlIlIlll = llllllllllllIllllIIIlllIIlIlIIIl.rand;
        final double llllllllllllIllllIIIlllIIlIlIllI = 0.0625;
        for (int llllllllllllIllllIIIlllIIlIlIlIl = 0; llllllllllllIllllIIIlllIIlIlIlIl < 6; ++llllllllllllIllllIIIlllIIlIlIlIl) {
            double llllllllllllIllllIIIlllIIlIlIlII = llllllllllllIllllIIIlllIIlIllIII.getX() + llllllllllllIllllIIIlllIIlIlIlll.nextFloat();
            double llllllllllllIllllIIIlllIIlIlIIll = llllllllllllIllllIIIlllIIlIllIII.getY() + llllllllllllIllllIIIlllIIlIlIlll.nextFloat();
            double llllllllllllIllllIIIlllIIlIlIIlI = llllllllllllIllllIIIlllIIlIllIII.getZ() + llllllllllllIllllIIIlllIIlIlIlll.nextFloat();
            if (llllllllllllIllllIIIlllIIlIlIlIl == 0 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.up()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIIll = llllllllllllIllllIIIlllIIlIllIII.getY() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllIIIlllIIlIlIlIl == 1 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.down()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIIll = llllllllllllIllllIIIlllIIlIllIII.getY() - 0.0625;
            }
            if (llllllllllllIllllIIIlllIIlIlIlIl == 2 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.south()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIIlI = llllllllllllIllllIIIlllIIlIllIII.getZ() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllIIIlllIIlIlIlIl == 3 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.north()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIIlI = llllllllllllIllllIIIlllIIlIllIII.getZ() - 0.0625;
            }
            if (llllllllllllIllllIIIlllIIlIlIlIl == 4 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.east()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIlII = llllllllllllIllllIIIlllIIlIllIII.getX() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllIIIlllIIlIlIlIl == 5 && !llllllllllllIllllIIIlllIIlIlIIIl.getBlockState(llllllllllllIllllIIIlllIIlIllIII.west()).isOpaqueCube()) {
                llllllllllllIllllIIIlllIIlIlIlII = llllllllllllIllllIIIlllIIlIllIII.getX() - 0.0625;
            }
            if (llllllllllllIllllIIIlllIIlIlIlII < llllllllllllIllllIIIlllIIlIllIII.getX() || llllllllllllIllllIIIlllIIlIlIlII > llllllllllllIllllIIIlllIIlIllIII.getX() + 1 || llllllllllllIllllIIIlllIIlIlIIll < 0.0 || llllllllllllIllllIIIlllIIlIlIIll > llllllllllllIllllIIIlllIIlIllIII.getY() + 1 || llllllllllllIllllIIIlllIIlIlIIlI < llllllllllllIllllIIIlllIIlIllIII.getZ() || llllllllllllIllllIIIlllIIlIlIIlI > llllllllllllIllllIIIlllIIlIllIII.getZ() + 1) {
                llllllllllllIllllIIIlllIIlIlIIIl.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllllIllllIIIlllIIlIlIlII, llllllllllllIllllIIIlllIIlIlIIll, llllllllllllIllllIIIlllIIlIlIIlI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllIllllIIIlllIlIIlIlIl, final BlockPos llllllllllllIllllIIIlllIlIIllIIl, final IBlockState llllllllllllIllllIIIlllIlIIllIII, final Random llllllllllllIllllIIIlllIlIIlIlll) {
        if (this == Blocks.LIT_REDSTONE_ORE) {
            llllllllllllIllllIIIlllIlIIlIlIl.setBlockState(llllllllllllIllllIIIlllIlIIllIIl, Blocks.REDSTONE_ORE.getDefaultState());
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllIllllIIIlllIIllIlIIl, final World llllllllllllIllllIIIlllIIllIlIII, final BlockPos llllllllllllIllllIIIlllIIllIIIll, final Random llllllllllllIllllIIIlllIIllIIllI) {
        if (this.isOn) {
            this.spawnParticles(llllllllllllIllllIIIlllIIllIlIII, llllllllllllIllllIIIlllIIllIIIll);
        }
    }
    
    @Override
    public int tickRate(final World llllllllllllIllllIIIlllIllIllllI) {
        return 30;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIllllIIIlllIlIIlIIlI, final Random llllllllllllIllllIIIlllIlIIlIIIl, final int llllllllllllIllllIIIlllIlIIlIIII) {
        return Items.REDSTONE;
    }
    
    public BlockRedstoneOre(final boolean llllllllllllIllllIIIlllIlllIIIlI) {
        super(Material.ROCK);
        if (llllllllllllIllllIIIlllIlllIIIlI) {
            this.setTickRandomly(true);
        }
        this.isOn = llllllllllllIllllIIIlllIlllIIIlI;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIllllIIIlllIlIllIIII, final BlockPos llllllllllllIllllIIIlllIlIlIllll, final IBlockState llllllllllllIllllIIIlllIlIlIlllI, final EntityPlayer llllllllllllIllllIIIlllIlIllIlll, final EnumHand llllllllllllIllllIIIlllIlIlIllII, final EnumFacing llllllllllllIllllIIIlllIlIlIlIll, final float llllllllllllIllllIIIlllIlIllIlII, final float llllllllllllIllllIIIlllIlIlIlIIl, final float llllllllllllIllllIIIlllIlIlIlIII) {
        this.activate(llllllllllllIllllIIIlllIlIllIIII, llllllllllllIllllIIIlllIlIlIllll);
        return super.onBlockActivated(llllllllllllIllllIIIlllIlIllIIII, llllllllllllIllllIIIlllIlIlIllll, llllllllllllIllllIIIlllIlIlIlllI, llllllllllllIllllIIIlllIlIllIlll, llllllllllllIllllIIIlllIlIlIllII, llllllllllllIllllIIIlllIlIlIlIll, llllllllllllIllllIIIlllIlIllIlII, llllllllllllIllllIIIlllIlIlIlIIl, llllllllllllIllllIIIlllIlIlIlIII);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIllllIIIlllIlIIIIIll) {
        return 4 + llllllllllllIllllIIIlllIlIIIIIll.nextInt(2);
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllIllllIIIlllIllIlIlII, final BlockPos llllllllllllIllllIIIlllIllIlIIll, final EntityPlayer llllllllllllIllllIIIlllIllIlIIlI) {
        this.activate(llllllllllllIllllIIIlllIllIlIlII, llllllllllllIllllIIIlllIllIlIIll);
        super.onBlockClicked(llllllllllllIllllIIIlllIllIlIlII, llllllllllllIllllIIIlllIllIlIIll, llllllllllllIllllIIIlllIllIlIIlI);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIllllIIIlllIIlIIIlII, final BlockPos llllllllllllIllllIIIlllIIlIIIIll, final IBlockState llllllllllllIllllIIIlllIIlIIIIII) {
        return new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_ORE), 1, this.damageDropped(llllllllllllIllllIIIlllIIlIIIIII));
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllIllllIIIlllIIllllIlI, final BlockPos llllllllllllIllllIIIlllIIlllIIlI, final IBlockState llllllllllllIllllIIIlllIIllllIII, final float llllllllllllIllllIIIlllIIlllIlll, final int llllllllllllIllllIIIlllIIlllIllI) {
        super.dropBlockAsItemWithChance(llllllllllllIllllIIIlllIIllllIlI, llllllllllllIllllIIIlllIIlllIIlI, llllllllllllIllllIIIlllIIllllIII, llllllllllllIllllIIIlllIIlllIlll, llllllllllllIllllIIIlllIIlllIllI);
        if (this.getItemDropped(llllllllllllIllllIIIlllIIllllIII, llllllllllllIllllIIIlllIIllllIlI.rand, llllllllllllIllllIIIlllIIlllIllI) != Item.getItemFromBlock(this)) {
            final int llllllllllllIllllIIIlllIIlllIlIl = 1 + llllllllllllIllllIIIlllIIllllIlI.rand.nextInt(5);
            this.dropXpOnBlockBreak(llllllllllllIllllIIIlllIIllllIlI, llllllllllllIllllIIIlllIIlllIIlI, llllllllllllIllllIIIlllIIlllIlIl);
        }
    }
    
    private void activate(final World llllllllllllIllllIIIlllIlIlIIIII, final BlockPos llllllllllllIllllIIIlllIlIlIIIlI) {
        this.spawnParticles(llllllllllllIllllIIIlllIlIlIIIII, llllllllllllIllllIIIlllIlIlIIIlI);
        if (this == Blocks.REDSTONE_ORE) {
            llllllllllllIllllIIIlllIlIlIIIII.setBlockState(llllllllllllIllllIIIlllIlIlIIIlI, Blocks.LIT_REDSTONE_ORE.getDefaultState());
        }
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllIllllIIIlllIIlIIlIII) {
        return new ItemStack(Blocks.REDSTONE_ORE);
    }
    
    @Override
    public void onEntityWalk(final World llllllllllllIllllIIIlllIllIIllII, final BlockPos llllllllllllIllllIIIlllIllIIlIll, final Entity llllllllllllIllllIIIlllIllIIIllI) {
        this.activate(llllllllllllIllllIIIlllIllIIllII, llllllllllllIllllIIIlllIllIIlIll);
        super.onEntityWalk(llllllllllllIllllIIIlllIllIIllII, llllllllllllIllllIIIlllIllIIlIll, llllllllllllIllllIIIlllIllIIIllI);
    }
}
