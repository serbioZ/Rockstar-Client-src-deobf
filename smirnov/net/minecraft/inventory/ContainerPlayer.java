// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import javax.annotation.Nullable;
import net.minecraft.item.ItemArmor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerPlayer extends Container
{
    public /* synthetic */ boolean isLocalWorld;
    public /* synthetic */ InventoryCrafting craftMatrix;
    public /* synthetic */ InventoryCraftResult craftResult;
    private static final /* synthetic */ EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS;
    private final /* synthetic */ EntityPlayer thePlayer;
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIIlIIIIIlllllllIlIIlI) {
        return true;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllIIlIIIIIlllllllIllIll) {
        this.func_192389_a(this.thePlayer.world, this.thePlayer, this.craftMatrix, this.craftResult);
    }
    
    @Override
    public boolean canMergeSlot(final ItemStack lllllllllllIIlIIIIIllllllIllIlII, final Slot lllllllllllIIlIIIIIllllllIllIIll) {
        return lllllllllllIIlIIIIIllllllIllIIll.inventory != this.craftResult && super.canMergeSlot(lllllllllllIIlIIIIIllllllIllIlII, lllllllllllIIlIIIIIllllllIllIIll);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIIlIIIIIllllllIllllll, final int lllllllllllIIlIIIIIlllllllIIIlll) {
        ItemStack lllllllllllIIlIIIIIlllllllIIIllI = ItemStack.field_190927_a;
        final Slot lllllllllllIIlIIIIIlllllllIIIlIl = this.inventorySlots.get(lllllllllllIIlIIIIIlllllllIIIlll);
        if (lllllllllllIIlIIIIIlllllllIIIlIl != null && lllllllllllIIlIIIIIlllllllIIIlIl.getHasStack()) {
            final ItemStack lllllllllllIIlIIIIIlllllllIIIlII = lllllllllllIIlIIIIIlllllllIIIlIl.getStack();
            lllllllllllIIlIIIIIlllllllIIIllI = lllllllllllIIlIIIIIlllllllIIIlII.copy();
            final EntityEquipmentSlot lllllllllllIIlIIIIIlllllllIIIIll = EntityLiving.getSlotForItemStack(lllllllllllIIlIIIIIlllllllIIIllI);
            if (lllllllllllIIlIIIIIlllllllIIIlll == 0) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 9, 45, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIIlIIIIIlllllllIIIlIl.onSlotChange(lllllllllllIIlIIIIIlllllllIIIlII, lllllllllllIIlIIIIIlllllllIIIllI);
            }
            else if (lllllllllllIIlIIIIIlllllllIIIlll >= 1 && lllllllllllIIlIIIIIlllllllIIIlll < 5) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 9, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIIlllllllIIIlll >= 5 && lllllllllllIIlIIIIIlllllllIIIlll < 9) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 9, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIIlllllllIIIIll.getSlotType() == EntityEquipmentSlot.Type.ARMOR && !this.inventorySlots.get(8 - lllllllllllIIlIIIIIlllllllIIIIll.getIndex()).getHasStack()) {
                final int lllllllllllIIlIIIIIlllllllIIIIlI = 8 - lllllllllllIIlIIIIIlllllllIIIIll.getIndex();
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, lllllllllllIIlIIIIIlllllllIIIIlI, lllllllllllIIlIIIIIlllllllIIIIlI + 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIIlllllllIIIIll == EntityEquipmentSlot.OFFHAND && !this.inventorySlots.get(45).getHasStack()) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 45, 46, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIIlllllllIIIlll >= 9 && lllllllllllIIlIIIIIlllllllIIIlll < 36) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 36, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllIIlIIIIIlllllllIIIlll >= 36 && lllllllllllIIlIIIIIlllllllIIIlll < 45) {
                if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 9, 36, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIIlIIIIIlllllllIIIlII, 9, 45, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIIlIIIIIlllllllIIIlII.func_190926_b()) {
                lllllllllllIIlIIIIIlllllllIIIlIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIIlIIIIIlllllllIIIlIl.onSlotChanged();
            }
            if (lllllllllllIIlIIIIIlllllllIIIlII.func_190916_E() == lllllllllllIIlIIIIIlllllllIIIllI.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            final ItemStack lllllllllllIIlIIIIIlllllllIIIIIl = lllllllllllIIlIIIIIlllllllIIIlIl.func_190901_a(lllllllllllIIlIIIIIllllllIllllll, lllllllllllIIlIIIIIlllllllIIIlII);
            if (lllllllllllIIlIIIIIlllllllIIIlll == 0) {
                lllllllllllIIlIIIIIllllllIllllll.dropItem(lllllllllllIIlIIIIIlllllllIIIIIl, false);
            }
        }
        return lllllllllllIIlIIIIIlllllllIIIllI;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIIlIIIIIlllllllIlIllI) {
        super.onContainerClosed(lllllllllllIIlIIIIIlllllllIlIllI);
        this.craftResult.clear();
        if (!lllllllllllIIlIIIIIlllllllIlIllI.world.isRemote) {
            this.func_193327_a(lllllllllllIIlIIIIIlllllllIlIllI, lllllllllllIIlIIIIIlllllllIlIllI.world, this.craftMatrix);
        }
    }
    
    static {
        VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };
    }
    
    public ContainerPlayer(final InventoryPlayer lllllllllllIIlIIIIIllllllllIllIl, final boolean lllllllllllIIlIIIIIllllllllIIIIl, final EntityPlayer lllllllllllIIlIIIIIllllllllIlIll) {
        this.craftMatrix = new InventoryCrafting(this, 2, 2);
        this.craftResult = new InventoryCraftResult();
        this.isLocalWorld = lllllllllllIIlIIIIIllllllllIIIIl;
        this.thePlayer = lllllllllllIIlIIIIIllllllllIlIll;
        this.addSlotToContainer(new SlotCrafting(lllllllllllIIlIIIIIllllllllIllIl.player, this.craftMatrix, this.craftResult, 0, 154, 28));
        for (int lllllllllllIIlIIIIIllllllllIlIlI = 0; lllllllllllIIlIIIIIllllllllIlIlI < 2; ++lllllllllllIIlIIIIIllllllllIlIlI) {
            for (int lllllllllllIIlIIIIIllllllllIlIIl = 0; lllllllllllIIlIIIIIllllllllIlIIl < 2; ++lllllllllllIIlIIIIIllllllllIlIIl) {
                this.addSlotToContainer(new Slot(this.craftMatrix, lllllllllllIIlIIIIIllllllllIlIIl + lllllllllllIIlIIIIIllllllllIlIlI * 2, 98 + lllllllllllIIlIIIIIllllllllIlIIl * 18, 18 + lllllllllllIIlIIIIIllllllllIlIlI * 18));
            }
        }
        for (int lllllllllllIIlIIIIIllllllllIlIII = 0; lllllllllllIIlIIIIIllllllllIlIII < 4; ++lllllllllllIIlIIIIIllllllllIlIII) {
            final EntityEquipmentSlot lllllllllllIIlIIIIIllllllllIIlll = ContainerPlayer.VALID_EQUIPMENT_SLOTS[lllllllllllIIlIIIIIllllllllIlIII];
            this.addSlotToContainer(new Slot(lllllllllllIIlIIIIIllllllllIllIl, 36 + (3 - lllllllllllIIlIIIIIllllllllIlIII), 8, 8 + lllllllllllIIlIIIIIllllllllIlIII * 18) {
                @Override
                public boolean isItemValid(final ItemStack lllllllllllIIlIlIIIlIlIIIIIlIlII) {
                    return lllllllllllIIlIIIIIllllllllIIlll == EntityLiving.getSlotForItemStack(lllllllllllIIlIlIIIlIlIIIIIlIlII);
                }
                
                @Override
                public boolean canTakeStack(final EntityPlayer lllllllllllIIlIlIIIlIlIIIIIIllII) {
                    final ItemStack lllllllllllIIlIlIIIlIlIIIIIIlllI = this.getStack();
                    return (lllllllllllIIlIlIIIlIlIIIIIIlllI.func_190926_b() || lllllllllllIIlIlIIIlIlIIIIIIllII.isCreative() || !EnchantmentHelper.func_190938_b(lllllllllllIIlIlIIIlIlIIIIIIlllI)) && super.canTakeStack(lllllllllllIIlIlIIIlIlIIIIIIllII);
                }
                
                @Nullable
                @Override
                public String getSlotTexture() {
                    return ItemArmor.EMPTY_SLOT_NAMES[lllllllllllIIlIIIIIllllllllIIlll.getIndex()];
                }
                
                @Override
                public int getSlotStackLimit() {
                    return 1;
                }
            });
        }
        for (int lllllllllllIIlIIIIIllllllllIIllI = 0; lllllllllllIIlIIIIIllllllllIIllI < 3; ++lllllllllllIIlIIIIIllllllllIIllI) {
            for (int lllllllllllIIlIIIIIllllllllIIlIl = 0; lllllllllllIIlIIIIIllllllllIIlIl < 9; ++lllllllllllIIlIIIIIllllllllIIlIl) {
                this.addSlotToContainer(new Slot(lllllllllllIIlIIIIIllllllllIllIl, lllllllllllIIlIIIIIllllllllIIlIl + (lllllllllllIIlIIIIIllllllllIIllI + 1) * 9, 8 + lllllllllllIIlIIIIIllllllllIIlIl * 18, 84 + lllllllllllIIlIIIIIllllllllIIllI * 18));
            }
        }
        for (int lllllllllllIIlIIIIIllllllllIIlII = 0; lllllllllllIIlIIIIIllllllllIIlII < 9; ++lllllllllllIIlIIIIIllllllllIIlII) {
            this.addSlotToContainer(new Slot(lllllllllllIIlIIIIIllllllllIllIl, lllllllllllIIlIIIIIllllllllIIlII, 8 + lllllllllllIIlIIIIIllllllllIIlII * 18, 142));
        }
        this.addSlotToContainer(new Slot(lllllllllllIIlIIIIIllllllllIllIl, 40, 77, 62) {
            @Nullable
            @Override
            public String getSlotTexture() {
                return "minecraft:items/empty_armor_slot_shield";
            }
        });
    }
}
