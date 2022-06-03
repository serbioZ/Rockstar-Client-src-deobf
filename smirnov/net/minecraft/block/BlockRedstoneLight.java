// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

public class BlockRedstoneLight extends Block
{
    private final /* synthetic */ boolean isOn;
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llIIIIlllIIllll) {
        return new ItemStack(Blocks.REDSTONE_LAMP);
    }
    
    @Override
    public void neighborChanged(final IBlockState llIIIIllllIlIll, final World llIIIIllllIIlIl, final BlockPos llIIIIllllIIlII, final Block llIIIIllllIlIII, final BlockPos llIIIIllllIIlll) {
        if (!llIIIIllllIIlIl.isRemote) {
            if (this.isOn && !llIIIIllllIIlIl.isBlockPowered(llIIIIllllIIlII)) {
                llIIIIllllIIlIl.scheduleUpdate(llIIIIllllIIlII, this, 4);
            }
            else if (!this.isOn && llIIIIllllIIlIl.isBlockPowered(llIIIIllllIIlII)) {
                llIIIIllllIIlIl.setBlockState(llIIIIllllIIlII, Blocks.LIT_REDSTONE_LAMP.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public void updateTick(final World llIIIIlllIllIlI, final BlockPos llIIIIlllIllllI, final IBlockState llIIIIlllIlllIl, final Random llIIIIlllIlllII) {
        if (!llIIIIlllIllIlI.isRemote && this.isOn && !llIIIIlllIllIlI.isBlockPowered(llIIIIlllIllllI)) {
            llIIIIlllIllIlI.setBlockState(llIIIIlllIllllI, Blocks.REDSTONE_LAMP.getDefaultState(), 2);
        }
    }
    
    @Override
    public ItemStack getItem(final World llIIIIlllIlIIll, final BlockPos llIIIIlllIlIIlI, final IBlockState llIIIIlllIlIIIl) {
        return new ItemStack(Blocks.REDSTONE_LAMP);
    }
    
    public BlockRedstoneLight(final boolean llIIIIlllllllII) {
        super(Material.REDSTONE_LIGHT);
        this.isOn = llIIIIlllllllII;
        if (llIIIIlllllllII) {
            this.setLightLevel(1.0f);
        }
    }
    
    @Override
    public void onBlockAdded(final World llIIIIlllllIlIl, final BlockPos llIIIIlllllIIII, final IBlockState llIIIIlllllIIll) {
        if (!llIIIIlllllIlIl.isRemote) {
            if (this.isOn && !llIIIIlllllIlIl.isBlockPowered(llIIIIlllllIIII)) {
                llIIIIlllllIlIl.setBlockState(llIIIIlllllIIII, Blocks.REDSTONE_LAMP.getDefaultState(), 2);
            }
            else if (!this.isOn && llIIIIlllllIlIl.isBlockPowered(llIIIIlllllIIII)) {
                llIIIIlllllIlIl.setBlockState(llIIIIlllllIIII, Blocks.LIT_REDSTONE_LAMP.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIIIIlllIlIlll, final Random llIIIIlllIlIllI, final int llIIIIlllIlIlIl) {
        return Item.getItemFromBlock(Blocks.REDSTONE_LAMP);
    }
}
