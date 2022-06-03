// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerBrewingStand extends Container
{
    private /* synthetic */ int prevBrewTime;
    private /* synthetic */ int prevFuel;
    private final /* synthetic */ Slot theSlot;
    private final /* synthetic */ IInventory tileBrewingStand;
    
    @Override
    public void updateProgressBar(final int lllllllllllIllIllIIllllIIIIIIIII, final int lllllllllllIllIllIIlllIlllllllll) {
        this.tileBrewingStand.setField(lllllllllllIllIllIIllllIIIIIIIII, lllllllllllIllIllIIlllIlllllllll);
    }
    
    @Override
    public void addListener(final IContainerListener lllllllllllIllIllIIllllIIIIlIIll) {
        super.addListener(lllllllllllIllIllIIllllIIIIlIIll);
        lllllllllllIllIllIIllllIIIIlIIll.sendAllWindowProperties(this, this.tileBrewingStand);
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllIllIllIIllllIIIIIllII = 0; lllllllllllIllIllIIllllIIIIIllII < this.listeners.size(); ++lllllllllllIllIllIIllllIIIIIllII) {
            final IContainerListener lllllllllllIllIllIIllllIIIIIlIll = this.listeners.get(lllllllllllIllIllIIllllIIIIIllII);
            if (this.prevBrewTime != this.tileBrewingStand.getField(0)) {
                lllllllllllIllIllIIllllIIIIIlIll.sendProgressBarUpdate(this, 0, this.tileBrewingStand.getField(0));
            }
            if (this.prevFuel != this.tileBrewingStand.getField(1)) {
                lllllllllllIllIllIIllllIIIIIlIll.sendProgressBarUpdate(this, 1, this.tileBrewingStand.getField(1));
            }
        }
        this.prevBrewTime = this.tileBrewingStand.getField(0);
        this.prevFuel = this.tileBrewingStand.getField(1);
    }
    
    public ContainerBrewingStand(final InventoryPlayer lllllllllllIllIllIIllllIIIIllIlI, final IInventory lllllllllllIllIllIIllllIIIIllIIl) {
        this.tileBrewingStand = lllllllllllIllIllIIllllIIIIllIIl;
        this.addSlotToContainer(new Potion(lllllllllllIllIllIIllllIIIIllIIl, 0, 56, 51));
        this.addSlotToContainer(new Potion(lllllllllllIllIllIIllllIIIIllIIl, 1, 79, 58));
        this.addSlotToContainer(new Potion(lllllllllllIllIllIIllllIIIIllIIl, 2, 102, 51));
        this.theSlot = this.addSlotToContainer(new Ingredient(lllllllllllIllIllIIllllIIIIllIIl, 3, 79, 17));
        this.addSlotToContainer(new Fuel(lllllllllllIllIllIIllllIIIIllIIl, 4, 17, 17));
        for (int lllllllllllIllIllIIllllIIIIllllI = 0; lllllllllllIllIllIIllllIIIIllllI < 3; ++lllllllllllIllIllIIllllIIIIllllI) {
            for (int lllllllllllIllIllIIllllIIIIlllIl = 0; lllllllllllIllIllIIllllIIIIlllIl < 9; ++lllllllllllIllIllIIllllIIIIlllIl) {
                this.addSlotToContainer(new Slot(lllllllllllIllIllIIllllIIIIllIlI, lllllllllllIllIllIIllllIIIIlllIl + lllllllllllIllIllIIllllIIIIllllI * 9 + 9, 8 + lllllllllllIllIllIIllllIIIIlllIl * 18, 84 + lllllllllllIllIllIIllllIIIIllllI * 18));
            }
        }
        for (int lllllllllllIllIllIIllllIIIIlllII = 0; lllllllllllIllIllIIllllIIIIlllII < 9; ++lllllllllllIllIllIIllllIIIIlllII) {
            this.addSlotToContainer(new Slot(lllllllllllIllIllIIllllIIIIllIlI, lllllllllllIllIllIIllllIIIIlllII, 8 + lllllllllllIllIllIIllllIIIIlllII * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIllIllIIlllIlllllIIIl, final int lllllllllllIllIllIIlllIllllIlIlI) {
        ItemStack lllllllllllIllIllIIlllIllllIllll = ItemStack.field_190927_a;
        final Slot lllllllllllIllIllIIlllIllllIlllI = this.inventorySlots.get(lllllllllllIllIllIIlllIllllIlIlI);
        if (lllllllllllIllIllIIlllIllllIlllI != null && lllllllllllIllIllIIlllIllllIlllI.getHasStack()) {
            final ItemStack lllllllllllIllIllIIlllIllllIllIl = lllllllllllIllIllIIlllIllllIlllI.getStack();
            lllllllllllIllIllIIlllIllllIllll = lllllllllllIllIllIIlllIllllIllIl.copy();
            if ((lllllllllllIllIllIIlllIllllIlIlI < 0 || lllllllllllIllIllIIlllIllllIlIlI > 2) && lllllllllllIllIllIIlllIllllIlIlI != 3 && lllllllllllIllIllIIlllIllllIlIlI != 4) {
                if (this.theSlot.isItemValid(lllllllllllIllIllIIlllIllllIllIl)) {
                    if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 3, 4, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (Potion.canHoldPotion(lllllllllllIllIllIIlllIllllIllll) && lllllllllllIllIllIIlllIllllIllll.func_190916_E() == 1) {
                    if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 0, 3, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (Fuel.isValidBrewingFuel(lllllllllllIllIllIIlllIllllIllll)) {
                    if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 4, 5, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllIllIllIIlllIllllIlIlI >= 5 && lllllllllllIllIllIIlllIllllIlIlI < 32) {
                    if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 32, 41, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllIllIllIIlllIllllIlIlI >= 32 && lllllllllllIllIllIIlllIllllIlIlI < 41) {
                    if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 5, 32, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 5, 41, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else {
                if (!this.mergeItemStack(lllllllllllIllIllIIlllIllllIllIl, 5, 41, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIllIllIIlllIllllIlllI.onSlotChange(lllllllllllIllIllIIlllIllllIllIl, lllllllllllIllIllIIlllIllllIllll);
            }
            if (lllllllllllIllIllIIlllIllllIllIl.func_190926_b()) {
                lllllllllllIllIllIIlllIllllIlllI.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIllIllIIlllIllllIlllI.onSlotChanged();
            }
            if (lllllllllllIllIllIIlllIllllIllIl.func_190916_E() == lllllllllllIllIllIIlllIllllIllll.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllIllIllIIlllIllllIlllI.func_190901_a(lllllllllllIllIllIIlllIlllllIIIl, lllllllllllIllIllIIlllIllllIllIl);
        }
        return lllllllllllIllIllIIlllIllllIllll;
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIllIllIIlllIllllllIll) {
        return this.tileBrewingStand.isUsableByPlayer(lllllllllllIllIllIIlllIllllllIll);
    }
    
    static class Potion extends Slot
    {
        public static boolean canHoldPotion(final ItemStack lllllllllllIlllllIlIlIIIIIIlIIlI) {
            final Item lllllllllllIlllllIlIlIIIIIIlIIIl = lllllllllllIlllllIlIlIIIIIIlIIlI.getItem();
            return lllllllllllIlllllIlIlIIIIIIlIIIl == Items.POTIONITEM || lllllllllllIlllllIlIlIIIIIIlIIIl == Items.SPLASH_POTION || lllllllllllIlllllIlIlIIIIIIlIIIl == Items.LINGERING_POTION || lllllllllllIlllllIlIlIIIIIIlIIIl == Items.GLASS_BOTTLE;
        }
        
        @Override
        public ItemStack func_190901_a(final EntityPlayer lllllllllllIlllllIlIlIIIIIIlIlll, final ItemStack lllllllllllIlllllIlIlIIIIIIlIllI) {
            final PotionType lllllllllllIlllllIlIlIIIIIIllIIl = PotionUtils.getPotionFromItem(lllllllllllIlllllIlIlIIIIIIlIllI);
            if (lllllllllllIlllllIlIlIIIIIIlIlll instanceof EntityPlayerMP) {
                CriteriaTriggers.field_192130_j.func_192173_a((EntityPlayerMP)lllllllllllIlllllIlIlIIIIIIlIlll, lllllllllllIlllllIlIlIIIIIIllIIl);
            }
            super.func_190901_a(lllllllllllIlllllIlIlIIIIIIlIlll, lllllllllllIlllllIlIlIIIIIIlIllI);
            return lllllllllllIlllllIlIlIIIIIIlIllI;
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllIlllllIlIlIIIIIlIIIlI) {
            return canHoldPotion(lllllllllllIlllllIlIlIIIIIlIIIlI);
        }
        
        public Potion(final IInventory lllllllllllIlllllIlIlIIIIIlIlIIl, final int lllllllllllIlllllIlIlIIIIIlIllIl, final int lllllllllllIlllllIlIlIIIIIlIIlll, final int lllllllllllIlllllIlIlIIIIIlIlIll) {
            super(lllllllllllIlllllIlIlIIIIIlIlIIl, lllllllllllIlllllIlIlIIIIIlIllIl, lllllllllllIlllllIlIlIIIIIlIIlll, lllllllllllIlllllIlIlIIIIIlIlIll);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
    }
    
    static class Fuel extends Slot
    {
        public static boolean isValidBrewingFuel(final ItemStack llllllllllIllllllIllIIlllIIIIIIl) {
            return llllllllllIllllllIllIIlllIIIIIIl.getItem() == Items.BLAZE_POWDER;
        }
        
        public Fuel(final IInventory llllllllllIllllllIllIIlllIIIlIlI, final int llllllllllIllllllIllIIlllIIIlllI, final int llllllllllIllllllIllIIlllIIIlIII, final int llllllllllIllllllIllIIlllIIIllII) {
            super(llllllllllIllllllIllIIlllIIIlIlI, llllllllllIllllllIllIIlllIIIlllI, llllllllllIllllllIllIIlllIIIlIII, llllllllllIllllllIllIIlllIIIllII);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
        
        @Override
        public boolean isItemValid(final ItemStack llllllllllIllllllIllIIlllIIIIIll) {
            return isValidBrewingFuel(llllllllllIllllllIllIIlllIIIIIll);
        }
    }
    
    static class Ingredient extends Slot
    {
        @Override
        public boolean isItemValid(final ItemStack lllllllllllIIIIlllIllIlIIllllIlI) {
            return PotionHelper.isReagent(lllllllllllIIIIlllIllIlIIllllIlI);
        }
        
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
        
        public Ingredient(final IInventory lllllllllllIIIIlllIllIlIlIIIIlIl, final int lllllllllllIIIIlllIllIlIIlllllll, final int lllllllllllIIIIlllIllIlIIllllllI, final int lllllllllllIIIIlllIllIlIIlllllIl) {
            super(lllllllllllIIIIlllIllIlIlIIIIlIl, lllllllllllIIIIlllIllIlIIlllllll, lllllllllllIIIIlllIllIlIIllllllI, lllllllllllIIIIlllIllIlIIlllllIl);
        }
    }
}
