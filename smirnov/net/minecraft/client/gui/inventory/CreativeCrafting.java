// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IContainerListener;

public class CreativeCrafting implements IContainerListener
{
    private final /* synthetic */ Minecraft mc;
    
    public CreativeCrafting(final Minecraft lllllllllllIIlIIlIIllIIllIlIIIlI) {
        this.mc = lllllllllllIIlIIlIIllIIllIlIIIlI;
    }
    
    @Override
    public void sendAllWindowProperties(final Container lllllllllllIIlIIlIIllIIllIIIllll, final IInventory lllllllllllIIlIIlIIllIIllIIIlllI) {
    }
    
    @Override
    public void sendSlotContents(final Container lllllllllllIIlIIlIIllIIllIIllIlI, final int lllllllllllIIlIIlIIllIIllIIlIllI, final ItemStack lllllllllllIIlIIlIIllIIllIIllIII) {
        this.mc.playerController.sendSlotPacket(lllllllllllIIlIIlIIllIIllIIllIII, lllllllllllIIlIIlIIllIIllIIlIllI);
    }
    
    @Override
    public void updateCraftingInventory(final Container lllllllllllIIlIIlIIllIIllIlIIIII, final NonNullList<ItemStack> lllllllllllIIlIIlIIllIIllIIlllll) {
    }
    
    @Override
    public void sendProgressBarUpdate(final Container lllllllllllIIlIIlIIllIIllIIlIIll, final int lllllllllllIIlIIlIIllIIllIIlIIlI, final int lllllllllllIIlIIlIIllIIllIIlIIIl) {
    }
}
