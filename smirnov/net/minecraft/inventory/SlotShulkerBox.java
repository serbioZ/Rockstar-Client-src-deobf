// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.item.ItemStack;

public class SlotShulkerBox extends Slot
{
    @Override
    public boolean isItemValid(final ItemStack lllllllllllIlIIIlIIlIIIlIIlIllIl) {
        return !(Block.getBlockFromItem(lllllllllllIlIIIlIIlIIIlIIlIllIl.getItem()) instanceof BlockShulkerBox);
    }
    
    public SlotShulkerBox(final IInventory lllllllllllIlIIIlIIlIIIlIIlllIII, final int lllllllllllIlIIIlIIlIIIlIIllIIlI, final int lllllllllllIlIIIlIIlIIIlIIllIIIl, final int lllllllllllIlIIIlIIlIIIlIIllIlIl) {
        super(lllllllllllIlIIIlIIlIIIlIIlllIII, lllllllllllIlIIIlIIlIIIlIIllIIlI, lllllllllllIlIIIlIIlIIIlIIllIIIl, lllllllllllIlIIIlIIlIIIlIIllIlIl);
    }
}
