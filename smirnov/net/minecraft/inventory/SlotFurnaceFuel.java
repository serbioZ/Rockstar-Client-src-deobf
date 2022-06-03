// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SlotFurnaceFuel extends Slot
{
    public static boolean isBucket(final ItemStack lllllllllllIIlllIIIlllllllIIIIIl) {
        return lllllllllllIIlllIIIlllllllIIIIIl.getItem() == Items.BUCKET;
    }
    
    @Override
    public int getItemStackLimit(final ItemStack lllllllllllIIlllIIIlllllllIIIIll) {
        return isBucket(lllllllllllIIlllIIIlllllllIIIIll) ? 1 : super.getItemStackLimit(lllllllllllIIlllIIIlllllllIIIIll);
    }
    
    @Override
    public boolean isItemValid(final ItemStack lllllllllllIIlllIIIlllllllIIlIIl) {
        return TileEntityFurnace.isItemFuel(lllllllllllIIlllIIIlllllllIIlIIl) || isBucket(lllllllllllIIlllIIIlllllllIIlIIl);
    }
    
    public SlotFurnaceFuel(final IInventory lllllllllllIIlllIIIlllllllIlIlIl, final int lllllllllllIIlllIIIlllllllIIllll, final int lllllllllllIIlllIIIlllllllIlIIll, final int lllllllllllIIlllIIIlllllllIIllIl) {
        super(lllllllllllIIlllIIIlllllllIlIlIl, lllllllllllIIlllIIIlllllllIIllll, lllllllllllIIlllIIIlllllllIlIIll, lllllllllllIIlllIIIlllllllIIllIl);
    }
}
