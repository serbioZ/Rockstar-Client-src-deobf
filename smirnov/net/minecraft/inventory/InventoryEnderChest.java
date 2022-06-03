// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityEnderChest;

public class InventoryEnderChest extends InventoryBasic
{
    private /* synthetic */ TileEntityEnderChest associatedChest;
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllIIlIlIIIlllIIIIIllIII) {
        return (this.associatedChest == null || this.associatedChest.canBeUsed(lllllllllllIIlIlIIIlllIIIIIllIII)) && super.isUsableByPlayer(lllllllllllIIlIlIIIlllIIIIIllIII);
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllIIlIlIIIlllIIIIIIllII) {
        if (this.associatedChest != null) {
            this.associatedChest.closeChest();
        }
        super.closeInventory(lllllllllllIIlIlIIIlllIIIIIIllII);
        this.associatedChest = null;
    }
    
    public void setChestTileEntity(final TileEntityEnderChest lllllllllllIIlIlIIIlllIIIIllllIl) {
        this.associatedChest = lllllllllllIIlIlIIIlllIIIIllllIl;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllIIlIlIIIlllIIIIIlIIlI) {
        if (this.associatedChest != null) {
            this.associatedChest.openChest();
        }
        super.openInventory(lllllllllllIIlIlIIIlllIIIIIlIIlI);
    }
    
    public void loadInventoryFromNBT(final NBTTagList lllllllllllIIlIlIIIlllIIIIllIllI) {
        for (int lllllllllllIIlIlIIIlllIIIIllIlIl = 0; lllllllllllIIlIlIIIlllIIIIllIlIl < this.getSizeInventory(); ++lllllllllllIIlIlIIIlllIIIIllIlIl) {
            this.setInventorySlotContents(lllllllllllIIlIlIIIlllIIIIllIlIl, ItemStack.field_190927_a);
        }
        for (int lllllllllllIIlIlIIIlllIIIIllIlII = 0; lllllllllllIIlIlIIIlllIIIIllIlII < lllllllllllIIlIlIIIlllIIIIllIllI.tagCount(); ++lllllllllllIIlIlIIIlllIIIIllIlII) {
            final NBTTagCompound lllllllllllIIlIlIIIlllIIIIllIIll = lllllllllllIIlIlIIIlllIIIIllIllI.getCompoundTagAt(lllllllllllIIlIlIIIlllIIIIllIlII);
            final int lllllllllllIIlIlIIIlllIIIIllIIlI = lllllllllllIIlIlIIIlllIIIIllIIll.getByte("Slot") & 0xFF;
            if (lllllllllllIIlIlIIIlllIIIIllIIlI >= 0 && lllllllllllIIlIlIIIlllIIIIllIIlI < this.getSizeInventory()) {
                this.setInventorySlotContents(lllllllllllIIlIlIIIlllIIIIllIIlI, new ItemStack(lllllllllllIIlIlIIIlllIIIIllIIll));
            }
        }
    }
    
    public InventoryEnderChest() {
        super("container.enderchest", false, 27);
    }
    
    public NBTTagList saveInventoryToNBT() {
        final NBTTagList lllllllllllIIlIlIIIlllIIIIlIIllI = new NBTTagList();
        for (int lllllllllllIIlIlIIIlllIIIIlIIlIl = 0; lllllllllllIIlIlIIIlllIIIIlIIlIl < this.getSizeInventory(); ++lllllllllllIIlIlIIIlllIIIIlIIlIl) {
            final ItemStack lllllllllllIIlIlIIIlllIIIIlIIlII = this.getStackInSlot(lllllllllllIIlIlIIIlllIIIIlIIlIl);
            if (!lllllllllllIIlIlIIIlllIIIIlIIlII.func_190926_b()) {
                final NBTTagCompound lllllllllllIIlIlIIIlllIIIIlIIIll = new NBTTagCompound();
                lllllllllllIIlIlIIIlllIIIIlIIIll.setByte("Slot", (byte)lllllllllllIIlIlIIIlllIIIIlIIlIl);
                lllllllllllIIlIlIIIlllIIIIlIIlII.writeToNBT(lllllllllllIIlIlIIIlllIIIIlIIIll);
                lllllllllllIIlIlIIIlllIIIIlIIllI.appendTag(lllllllllllIIlIlIIIlllIIIIlIIIll);
            }
        }
        return lllllllllllIIlIlIIIlllIIIIlIIllI;
    }
}
