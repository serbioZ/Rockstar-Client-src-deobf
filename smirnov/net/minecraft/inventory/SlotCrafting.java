// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.NonNullList;
import net.minecraft.item.crafting.CraftingManager;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class SlotCrafting extends Slot
{
    private final /* synthetic */ InventoryCrafting craftMatrix;
    private /* synthetic */ int amountCrafted;
    private final /* synthetic */ EntityPlayer thePlayer;
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIlllIIIllIllIIIIlI) {
        if (this.getHasStack()) {
            this.amountCrafted += Math.min(lllllllllllllIIlllIIIllIllIIIIlI, this.getStack().func_190916_E());
        }
        return super.decrStackSize(lllllllllllllIIlllIIIllIllIIIIlI);
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIIlllIIIllIlIlIIlll) {
        if (this.amountCrafted > 0) {
            lllllllllllllIIlllIIIllIlIlIIlll.onCrafting(this.thePlayer.world, this.thePlayer, this.amountCrafted);
        }
        this.amountCrafted = 0;
        final InventoryCraftResult lllllllllllllIIlllIIIllIlIlIlIlI = (InventoryCraftResult)this.inventory;
        final IRecipe lllllllllllllIIlllIIIllIlIlIlIIl = lllllllllllllIIlllIIIllIlIlIlIlI.func_193055_i();
        if (lllllllllllllIIlllIIIllIlIlIlIIl != null && !lllllllllllllIIlllIIIllIlIlIlIIl.func_192399_d()) {
            this.thePlayer.func_192021_a(Lists.newArrayList((Object[])new IRecipe[] { lllllllllllllIIlllIIIllIlIlIlIIl }));
            lllllllllllllIIlllIIIllIlIlIlIlI.func_193056_a(null);
        }
    }
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer lllllllllllllIIlllIIIllIlIIlIlIl, final ItemStack lllllllllllllIIlllIIIllIlIIlIlII) {
        this.onCrafting(lllllllllllllIIlllIIIllIlIIlIlII);
        final NonNullList<ItemStack> lllllllllllllIIlllIIIllIlIIllIlI = CraftingManager.getRemainingItems(this.craftMatrix, lllllllllllllIIlllIIIllIlIIlIlIl.world);
        for (int lllllllllllllIIlllIIIllIlIIllIIl = 0; lllllllllllllIIlllIIIllIlIIllIIl < lllllllllllllIIlllIIIllIlIIllIlI.size(); ++lllllllllllllIIlllIIIllIlIIllIIl) {
            ItemStack lllllllllllllIIlllIIIllIlIIllIII = this.craftMatrix.getStackInSlot(lllllllllllllIIlllIIIllIlIIllIIl);
            final ItemStack lllllllllllllIIlllIIIllIlIIlIlll = lllllllllllllIIlllIIIllIlIIllIlI.get(lllllllllllllIIlllIIIllIlIIllIIl);
            if (!lllllllllllllIIlllIIIllIlIIllIII.func_190926_b()) {
                this.craftMatrix.decrStackSize(lllllllllllllIIlllIIIllIlIIllIIl, 1);
                lllllllllllllIIlllIIIllIlIIllIII = this.craftMatrix.getStackInSlot(lllllllllllllIIlllIIIllIlIIllIIl);
            }
            if (!lllllllllllllIIlllIIIllIlIIlIlll.func_190926_b()) {
                if (lllllllllllllIIlllIIIllIlIIllIII.func_190926_b()) {
                    this.craftMatrix.setInventorySlotContents(lllllllllllllIIlllIIIllIlIIllIIl, lllllllllllllIIlllIIIllIlIIlIlll);
                }
                else if (ItemStack.areItemsEqual(lllllllllllllIIlllIIIllIlIIllIII, lllllllllllllIIlllIIIllIlIIlIlll) && ItemStack.areItemStackTagsEqual(lllllllllllllIIlllIIIllIlIIllIII, lllllllllllllIIlllIIIllIlIIlIlll)) {
                    lllllllllllllIIlllIIIllIlIIlIlll.func_190917_f(lllllllllllllIIlllIIIllIlIIllIII.func_190916_E());
                    this.craftMatrix.setInventorySlotContents(lllllllllllllIIlllIIIllIlIIllIIl, lllllllllllllIIlllIIIllIlIIlIlll);
                }
                else if (!this.thePlayer.inventory.addItemStackToInventory(lllllllllllllIIlllIIIllIlIIlIlll)) {
                    this.thePlayer.dropItem(lllllllllllllIIlllIIIllIlIIlIlll, false);
                }
            }
        }
        return lllllllllllllIIlllIIIllIlIIlIlII;
    }
    
    @Override
    protected void func_190900_b(final int lllllllllllllIIlllIIIllIlIllIIll) {
        this.amountCrafted += lllllllllllllIIlllIIIllIlIllIIll;
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIIlllIIIllIlIlllIII, final int lllllllllllllIIlllIIIllIlIllIlll) {
        this.amountCrafted += lllllllllllllIIlllIIIllIlIllIlll;
        this.onCrafting(lllllllllllllIIlllIIIllIlIlllIII);
    }
    
    @Override
    public boolean isItemValid(final ItemStack lllllllllllllIIlllIIIllIllIIIllI) {
        return false;
    }
    
    public SlotCrafting(final EntityPlayer lllllllllllllIIlllIIIllIllIlIlII, final InventoryCrafting lllllllllllllIIlllIIIllIllIIllII, final IInventory lllllllllllllIIlllIIIllIllIIlIll, final int lllllllllllllIIlllIIIllIllIlIIIl, final int lllllllllllllIIlllIIIllIllIIlIIl, final int lllllllllllllIIlllIIIllIllIIlIII) {
        super(lllllllllllllIIlllIIIllIllIIlIll, lllllllllllllIIlllIIIllIllIlIIIl, lllllllllllllIIlllIIIllIllIIlIIl, lllllllllllllIIlllIIIllIllIIlIII);
        this.thePlayer = lllllllllllllIIlllIIIllIllIlIlII;
        this.craftMatrix = lllllllllllllIIlllIIIllIllIIllII;
    }
}
