// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.stats.StatList;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.IMerchant;

public class SlotMerchantResult extends Slot
{
    private final /* synthetic */ InventoryMerchant theMerchantInventory;
    private final /* synthetic */ IMerchant theMerchant;
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int removeCount;
    
    private boolean doTrade(final MerchantRecipe llllllllllllIIlIlllIlllIIIllIlII, final ItemStack llllllllllllIIlIlllIlllIIIllIIll, final ItemStack llllllllllllIIlIlllIlllIIIllIlll) {
        final ItemStack llllllllllllIIlIlllIlllIIIllIllI = llllllllllllIIlIlllIlllIIIllIlII.getItemToBuy();
        final ItemStack llllllllllllIIlIlllIlllIIIllIlIl = llllllllllllIIlIlllIlllIIIllIlII.getSecondItemToBuy();
        if (llllllllllllIIlIlllIlllIIIllIIll.getItem() == llllllllllllIIlIlllIlllIIIllIllI.getItem() && llllllllllllIIlIlllIlllIIIllIIll.func_190916_E() >= llllllllllllIIlIlllIlllIIIllIllI.func_190916_E()) {
            if (!llllllllllllIIlIlllIlllIIIllIlIl.func_190926_b() && !llllllllllllIIlIlllIlllIIIllIlll.func_190926_b() && llllllllllllIIlIlllIlllIIIllIlIl.getItem() == llllllllllllIIlIlllIlllIIIllIlll.getItem() && llllllllllllIIlIlllIlllIIIllIlll.func_190916_E() >= llllllllllllIIlIlllIlllIIIllIlIl.func_190916_E()) {
                llllllllllllIIlIlllIlllIIIllIIll.func_190918_g(llllllllllllIIlIlllIlllIIIllIllI.func_190916_E());
                llllllllllllIIlIlllIlllIIIllIlll.func_190918_g(llllllllllllIIlIlllIlllIIIllIlIl.func_190916_E());
                return true;
            }
            if (llllllllllllIIlIlllIlllIIIllIlIl.func_190926_b() && llllllllllllIIlIlllIlllIIIllIlll.func_190926_b()) {
                llllllllllllIIlIlllIlllIIIllIIll.func_190918_g(llllllllllllIIlIlllIlllIIIllIllI.func_190916_E());
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllIIlIlllIlllIIlIlIIlI) {
        llllllllllllIIlIlllIlllIIlIlIIlI.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);
        this.removeCount = 0;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIIlIlllIlllIIllIIIIl) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(llllllllllllIIlIlllIlllIIllIIIIl, this.getStack().func_190916_E());
        }
        return super.decrStackSize(llllllllllllIIlIlllIlllIIllIIIIl);
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllIIlIlllIlllIIlIlllII, final int llllllllllllIIlIlllIlllIIlIllIll) {
        this.removeCount += llllllllllllIIlIlllIlllIIlIllIll;
        this.onCrafting(llllllllllllIIlIlllIlllIIlIlllII);
    }
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer llllllllllllIIlIlllIlllIIlIIIlII, final ItemStack llllllllllllIIlIlllIlllIIlIIIIll) {
        this.onCrafting(llllllllllllIIlIlllIlllIIlIIIIll);
        final MerchantRecipe llllllllllllIIlIlllIlllIIlIIlIII = this.theMerchantInventory.getCurrentRecipe();
        if (llllllllllllIIlIlllIlllIIlIIlIII != null) {
            final ItemStack llllllllllllIIlIlllIlllIIlIIIlll = this.theMerchantInventory.getStackInSlot(0);
            final ItemStack llllllllllllIIlIlllIlllIIlIIIllI = this.theMerchantInventory.getStackInSlot(1);
            if (this.doTrade(llllllllllllIIlIlllIlllIIlIIlIII, llllllllllllIIlIlllIlllIIlIIIlll, llllllllllllIIlIlllIlllIIlIIIllI) || this.doTrade(llllllllllllIIlIlllIlllIIlIIlIII, llllllllllllIIlIlllIlllIIlIIIllI, llllllllllllIIlIlllIlllIIlIIIlll)) {
                this.theMerchant.useRecipe(llllllllllllIIlIlllIlllIIlIIlIII);
                llllllllllllIIlIlllIlllIIlIIIlII.addStat(StatList.TRADED_WITH_VILLAGER);
                this.theMerchantInventory.setInventorySlotContents(0, llllllllllllIIlIlllIlllIIlIIIlll);
                this.theMerchantInventory.setInventorySlotContents(1, llllllllllllIIlIlllIlllIIlIIIllI);
            }
        }
        return llllllllllllIIlIlllIlllIIlIIIIll;
    }
    
    public SlotMerchantResult(final EntityPlayer llllllllllllIIlIlllIlllIIlllIlIl, final IMerchant llllllllllllIIlIlllIlllIIlllIlII, final InventoryMerchant llllllllllllIIlIlllIlllIIllIllII, final int llllllllllllIIlIlllIlllIIlllIIlI, final int llllllllllllIIlIlllIlllIIlllIIIl, final int llllllllllllIIlIlllIlllIIlllIIII) {
        super(llllllllllllIIlIlllIlllIIllIllII, llllllllllllIIlIlllIlllIIlllIIlI, llllllllllllIIlIlllIlllIIlllIIIl, llllllllllllIIlIlllIlllIIlllIIII);
        this.thePlayer = llllllllllllIIlIlllIlllIIlllIlIl;
        this.theMerchant = llllllllllllIIlIlllIlllIIlllIlII;
        this.theMerchantInventory = llllllllllllIIlIlllIlllIIllIllII;
    }
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllllIIlIlllIlllIIllIIlll) {
        return false;
    }
}
