// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerWorkbench extends Container
{
    private final /* synthetic */ EntityPlayer field_192390_i;
    private final /* synthetic */ BlockPos pos;
    public /* synthetic */ InventoryCraftResult craftResult;
    private final /* synthetic */ World worldObj;
    public /* synthetic */ InventoryCrafting craftMatrix;
    
    public ContainerWorkbench(final InventoryPlayer lllllllllllIIlIIIIllIlIllIIlIIII, final World lllllllllllIIlIIIIllIlIllIIIIllI, final BlockPos lllllllllllIIlIIIIllIlIllIIIlllI) {
        this.craftMatrix = new InventoryCrafting(this, 3, 3);
        this.craftResult = new InventoryCraftResult();
        this.worldObj = lllllllllllIIlIIIIllIlIllIIIIllI;
        this.pos = lllllllllllIIlIIIIllIlIllIIIlllI;
        this.field_192390_i = lllllllllllIIlIIIIllIlIllIIlIIII.player;
        this.addSlotToContainer(new SlotCrafting(lllllllllllIIlIIIIllIlIllIIlIIII.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int lllllllllllIIlIIIIllIlIllIIIllIl = 0; lllllllllllIIlIIIIllIlIllIIIllIl < 3; ++lllllllllllIIlIIIIllIlIllIIIllIl) {
            for (int lllllllllllIIlIIIIllIlIllIIIllII = 0; lllllllllllIIlIIIIllIlIllIIIllII < 3; ++lllllllllllIIlIIIIllIlIllIIIllII) {
                this.addSlotToContainer(new Slot(this.craftMatrix, lllllllllllIIlIIIIllIlIllIIIllII + lllllllllllIIlIIIIllIlIllIIIllIl * 3, 30 + lllllllllllIIlIIIIllIlIllIIIllII * 18, 17 + lllllllllllIIlIIIIllIlIllIIIllIl * 18));
            }
        }
        for (int lllllllllllIIlIIIIllIlIllIIIlIll = 0; lllllllllllIIlIIIIllIlIllIIIlIll < 3; ++lllllllllllIIlIIIIllIlIllIIIlIll) {
            for (int lllllllllllIIlIIIIllIlIllIIIlIlI = 0; lllllllllllIIlIIIIllIlIllIIIlIlI < 9; ++lllllllllllIIlIIIIllIlIllIIIlIlI) {
                this.addSlotToContainer(new Slot(lllllllllllIIlIIIIllIlIllIIlIIII, lllllllllllIIlIIIIllIlIllIIIlIlI + lllllllllllIIlIIIIllIlIllIIIlIll * 9 + 9, 8 + lllllllllllIIlIIIIllIlIllIIIlIlI * 18, 84 + lllllllllllIIlIIIIllIlIllIIIlIll * 18));
            }
        }
        for (int lllllllllllIIlIIIIllIlIllIIIlIIl = 0; lllllllllllIIlIIIIllIlIllIIIlIIl < 9; ++lllllllllllIIlIIIIllIlIllIIIlIIl) {
            this.addSlotToContainer(new Slot(lllllllllllIIlIIIIllIlIllIIlIIII, lllllllllllIIlIIIIllIlIllIIIlIIl, 8 + lllllllllllIIlIIIIllIlIllIIIlIIl * 18, 142));
        }
    }
    
    @Override
    public boolean canMergeSlot(final ItemStack lllllllllllIIlIIIIllIlIlIlIlIllI, final Slot lllllllllllIIlIIIIllIlIlIlIllIII) {
        return lllllllllllIIlIIIIllIlIlIlIllIII.inventory != this.craftResult && super.canMergeSlot(lllllllllllIIlIIIIllIlIlIlIlIllI, lllllllllllIIlIIIIllIlIlIlIllIII);
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllIIlIIIIllIlIllIIIIIII) {
        this.func_192389_a(this.worldObj, this.field_192390_i, this.craftMatrix, this.craftResult);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIIlIIIIllIlIlIllIIIll, final int lllllllllllIIlIIIIllIlIlIllIlIIl) {
        ItemStack lllllllllllIIlIIIIllIlIlIllIlIII = ItemStack.field_190927_a;
        final Slot lllllllllllIIlIIIIllIlIlIllIIlll = this.inventorySlots.get(lllllllllllIIlIIIIllIlIlIllIlIIl);
        if (lllllllllllIIlIIIIllIlIlIllIIlll != null && lllllllllllIIlIIIIllIlIlIllIIlll.getHasStack()) {
            final ItemStack lllllllllllIIlIIIIllIlIlIllIIllI = lllllllllllIIlIIIIllIlIlIllIIlll.getStack();
            lllllllllllIIlIIIIllIlIlIllIlIII = lllllllllllIIlIIIIllIlIlIllIIllI.copy();
            if (lllllllllllIIlIIIIllIlIlIllIlIIl == 0) {
                lllllllllllIIlIIIIllIlIlIllIIllI.getItem().onCreated(lllllllllllIIlIIIIllIlIlIllIIllI, this.worldObj, lllllllllllIIlIIIIllIlIlIllIIIll);
                if (!this.mergeItemStack(lllllllllllIIlIIIIllIlIlIllIIllI, 10, 46, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIIlIIIIllIlIlIllIIlll.onSlotChange(lllllllllllIIlIIIIllIlIlIllIIllI, lllllllllllIIlIIIIllIlIlIllIlIII);
            }
            else if (lllllllllllIIlIIIIllIlIlIllIlIIl >= 10 && lllllllllllIIlIIIIllIlIlIllIlIIl < 37) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIllIlIlIllIIllI, 37, 46, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIllIlIlIllIlIIl >= 37 && lllllllllllIIlIIIIllIlIlIllIlIIl < 46) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIllIlIlIllIIllI, 10, 37, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIIlIIIIllIlIlIllIIllI, 10, 46, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIIlIIIIllIlIlIllIIllI.func_190926_b()) {
                lllllllllllIIlIIIIllIlIlIllIIlll.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIIlIIIIllIlIlIllIIlll.onSlotChanged();
            }
            if (lllllllllllIIlIIIIllIlIlIllIIllI.func_190916_E() == lllllllllllIIlIIIIllIlIlIllIlIII.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            final ItemStack lllllllllllIIlIIIIllIlIlIllIIlIl = lllllllllllIIlIIIIllIlIlIllIIlll.func_190901_a(lllllllllllIIlIIIIllIlIlIllIIIll, lllllllllllIIlIIIIllIlIlIllIIllI);
            if (lllllllllllIIlIIIIllIlIlIllIlIIl == 0) {
                lllllllllllIIlIIIIllIlIlIllIIIll.dropItem(lllllllllllIIlIIIIllIlIlIllIIlIl, false);
            }
        }
        return lllllllllllIIlIIIIllIlIlIllIlIII;
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIIlIIIIllIlIlIlllIIll) {
        return this.worldObj.getBlockState(this.pos).getBlock() == Blocks.CRAFTING_TABLE && lllllllllllIIlIIIIllIlIlIlllIIll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIIlIIIIllIlIlIllllIIl) {
        super.onContainerClosed(lllllllllllIIlIIIIllIlIlIllllIIl);
        if (!this.worldObj.isRemote) {
            this.func_193327_a(lllllllllllIIlIIIIllIlIlIllllIIl, this.worldObj, this.craftMatrix);
        }
    }
}
