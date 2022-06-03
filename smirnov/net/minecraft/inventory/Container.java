// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.InventoryPlayer;
import com.google.common.collect.Sets;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import java.util.List;

public abstract class Container
{
    public /* synthetic */ List<Slot> inventorySlots;
    protected /* synthetic */ List<IContainerListener> listeners;
    public /* synthetic */ NonNullList<ItemStack> inventoryItemStacks;
    private final /* synthetic */ Set<Slot> dragSlots;
    public /* synthetic */ int windowId;
    private final /* synthetic */ Set<EntityPlayer> playerList;
    private /* synthetic */ short transactionID;
    private /* synthetic */ int dragEvent;
    private /* synthetic */ int dragMode;
    
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllIIlIIIIIIIIllllIlIlI, final int llllllllllllIIlIIIIIIIIllllIlIIl) {
        final Slot llllllllllllIIlIIIIIIIIllllIlIII = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllllIlIIl);
        return (llllllllllllIIlIIIIIIIIllllIlIII != null) ? llllllllllllIIlIIIIIIIIllllIlIII.getStack() : ItemStack.field_190927_a;
    }
    
    public void setCanCraft(final EntityPlayer llllllllllllIIlIIIIIIIIlIlIlIllI, final boolean llllllllllllIIlIIIIIIIIlIlIlIIlI) {
        if (llllllllllllIIlIIIIIIIIlIlIlIIlI) {
            this.playerList.remove(llllllllllllIIlIIIIIIIIlIlIlIllI);
        }
        else {
            this.playerList.add(llllllllllllIIlIIIIIIIIlIlIlIllI);
        }
    }
    
    public boolean canDragIntoSlot(final Slot llllllllllllIIlIIIIIIIIlIIIIIIll) {
        return true;
    }
    
    @Nullable
    public Slot getSlotFromInventory(final IInventory llllllllllllIIlIIIIIIIIllllllIII, final int llllllllllllIIlIIIIIIIIlllllIlll) {
        for (int llllllllllllIIlIIIIIIIIllllllIll = 0; llllllllllllIIlIIIIIIIIllllllIll < this.inventorySlots.size(); ++llllllllllllIIlIIIIIIIIllllllIll) {
            final Slot llllllllllllIIlIIIIIIIIllllllIlI = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllllllIll);
            if (llllllllllllIIlIIIIIIIIllllllIlI.isHere(llllllllllllIIlIIIIIIIIllllllIII, llllllllllllIIlIIIIIIIIlllllIlll)) {
                return llllllllllllIIlIIIIIIIIllllllIlI;
            }
        }
        return null;
    }
    
    public static int calcRedstoneFromInventory(@Nullable final IInventory llllllllllllIIlIIIIIIIIIllllIlIl) {
        if (llllllllllllIIlIIIIIIIIIllllIlIl == null) {
            return 0;
        }
        int llllllllllllIIlIIIIIIIIIlllllIIl = 0;
        float llllllllllllIIlIIIIIIIIIlllllIII = 0.0f;
        for (int llllllllllllIIlIIIIIIIIIllllIlll = 0; llllllllllllIIlIIIIIIIIIllllIlll < llllllllllllIIlIIIIIIIIIllllIlIl.getSizeInventory(); ++llllllllllllIIlIIIIIIIIIllllIlll) {
            final ItemStack llllllllllllIIlIIIIIIIIIllllIllI = llllllllllllIIlIIIIIIIIIllllIlIl.getStackInSlot(llllllllllllIIlIIIIIIIIIllllIlll);
            if (!llllllllllllIIlIIIIIIIIIllllIllI.func_190926_b()) {
                llllllllllllIIlIIIIIIIIIlllllIII += llllllllllllIIlIIIIIIIIIllllIllI.func_190916_E() / (float)Math.min(llllllllllllIIlIIIIIIIIIllllIlIl.getInventoryStackLimit(), llllllllllllIIlIIIIIIIIIllllIllI.getMaxStackSize());
                ++llllllllllllIIlIIIIIIIIIlllllIIl;
            }
        }
        llllllllllllIIlIIIIIIIIIlllllIII /= llllllllllllIIlIIIIIIIIIllllIlIl.getSizeInventory();
        return MathHelper.floor(llllllllllllIIlIIIIIIIIIlllllIII * 14.0f) + ((llllllllllllIIlIIIIIIIIIlllllIIl > 0) ? 1 : 0);
    }
    
    protected void func_193327_a(final EntityPlayer llllllllllllIIlIIIIIIIIllIIIIIIl, final World llllllllllllIIlIIIIIIIIllIIIIIII, final IInventory llllllllllllIIlIIIIIIIIlIlllllll) {
        if (!llllllllllllIIlIIIIIIIIllIIIIIIl.isEntityAlive() || (llllllllllllIIlIIIIIIIIllIIIIIIl instanceof EntityPlayerMP && ((EntityPlayerMP)llllllllllllIIlIIIIIIIIllIIIIIIl).func_193105_t())) {
            for (int llllllllllllIIlIIIIIIIIllIIIIIll = 0; llllllllllllIIlIIIIIIIIllIIIIIll < llllllllllllIIlIIIIIIIIlIlllllll.getSizeInventory(); ++llllllllllllIIlIIIIIIIIllIIIIIll) {
                llllllllllllIIlIIIIIIIIllIIIIIIl.dropItem(llllllllllllIIlIIIIIIIIlIlllllll.removeStackFromSlot(llllllllllllIIlIIIIIIIIllIIIIIll), false);
            }
        }
        else {
            for (int llllllllllllIIlIIIIIIIIllIIIIIlI = 0; llllllllllllIIlIIIIIIIIllIIIIIlI < llllllllllllIIlIIIIIIIIlIlllllll.getSizeInventory(); ++llllllllllllIIlIIIIIIIIllIIIIIlI) {
                llllllllllllIIlIIIIIIIIllIIIIIIl.inventory.func_191975_a(llllllllllllIIlIIIIIIIIllIIIIIII, llllllllllllIIlIIIIIIIIlIlllllll.removeStackFromSlot(llllllllllllIIlIIIIIIIIllIIIIIlI));
            }
        }
    }
    
    public Container() {
        this.inventoryItemStacks = NonNullList.func_191196_a();
        this.inventorySlots = (List<Slot>)Lists.newArrayList();
        this.dragMode = -1;
        this.dragSlots = (Set<Slot>)Sets.newHashSet();
        this.listeners = (List<IContainerListener>)Lists.newArrayList();
        this.playerList = (Set<EntityPlayer>)Sets.newHashSet();
    }
    
    public abstract boolean canInteractWith(final EntityPlayer p0);
    
    public void func_190896_a(final List<ItemStack> llllllllllllIIlIIIIIIIIlIllIlIIl) {
        for (int llllllllllllIIlIIIIIIIIlIllIlIll = 0; llllllllllllIIlIIIIIIIIlIllIlIll < llllllllllllIIlIIIIIIIIlIllIlIIl.size(); ++llllllllllllIIlIIIIIIIIlIllIlIll) {
            this.getSlot(llllllllllllIIlIIIIIIIIlIllIlIll).putStack(llllllllllllIIlIIIIIIIIlIllIlIIl.get(llllllllllllIIlIIIIIIIIlIllIlIll));
        }
    }
    
    public void updateProgressBar(final int llllllllllllIIlIIIIIIIIlIllIIllI, final int llllllllllllIIlIIIIIIIIlIllIIlIl) {
    }
    
    public void onContainerClosed(final EntityPlayer llllllllllllIIlIIIIIIIIllIIIllll) {
        final InventoryPlayer llllllllllllIIlIIIIIIIIllIIIlllI = llllllllllllIIlIIIIIIIIllIIIllll.inventory;
        if (!llllllllllllIIlIIIIIIIIllIIIlllI.getItemStack().func_190926_b()) {
            llllllllllllIIlIIIIIIIIllIIIllll.dropItem(llllllllllllIIlIIIIIIIIllIIIlllI.getItemStack(), false);
            llllllllllllIIlIIIIIIIIllIIIlllI.setItemStack(ItemStack.field_190927_a);
        }
    }
    
    public NonNullList<ItemStack> getInventory() {
        final NonNullList<ItemStack> llllllllllllIIlIIIIIIIlIIIIllIlI = NonNullList.func_191196_a();
        for (int llllllllllllIIlIIIIIIIlIIIIllIIl = 0; llllllllllllIIlIIIIIIIlIIIIllIIl < this.inventorySlots.size(); ++llllllllllllIIlIIIIIIIlIIIIllIIl) {
            llllllllllllIIlIIIIIIIlIIIIllIlI.add(this.inventorySlots.get(llllllllllllIIlIIIIIIIlIIIIllIIl).getStack());
        }
        return llllllllllllIIlIIIIIIIlIIIIllIlI;
    }
    
    public static void computeStackSize(final Set<Slot> llllllllllllIIlIIIIIIIIlIIIIlIII, final int llllllllllllIIlIIIIIIIIlIIIIlIll, final ItemStack llllllllllllIIlIIIIIIIIlIIIIIllI, final int llllllllllllIIlIIIIIIIIlIIIIIlIl) {
        switch (llllllllllllIIlIIIIIIIIlIIIIlIll) {
            case 0: {
                llllllllllllIIlIIIIIIIIlIIIIIllI.func_190920_e(MathHelper.floor(llllllllllllIIlIIIIIIIIlIIIIIllI.func_190916_E() / (float)llllllllllllIIlIIIIIIIIlIIIIlIII.size()));
                break;
            }
            case 1: {
                llllllllllllIIlIIIIIIIIlIIIIIllI.func_190920_e(1);
                break;
            }
            case 2: {
                llllllllllllIIlIIIIIIIIlIIIIIllI.func_190920_e(llllllllllllIIlIIIIIIIIlIIIIIllI.getItem().getItemStackLimit());
                break;
            }
        }
        llllllllllllIIlIIIIIIIIlIIIIIllI.func_190917_f(llllllllllllIIlIIIIIIIIlIIIIIlIl);
    }
    
    public boolean canMergeSlot(final ItemStack llllllllllllIIlIIIIIIIIllIIlIlII, final Slot llllllllllllIIlIIIIIIIIllIIlIIll) {
        return true;
    }
    
    public void addListener(final IContainerListener llllllllllllIIlIIIIIIIlIIIlIIlll) {
        if (this.listeners.contains(llllllllllllIIlIIIIIIIlIIIlIIlll)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.listeners.add(llllllllllllIIlIIIIIIIlIIIlIIlll);
        llllllllllllIIlIIIIIIIlIIIlIIlll.updateCraftingInventory(this, this.getInventory());
        this.detectAndSendChanges();
    }
    
    public Slot getSlot(final int llllllllllllIIlIIIIIIIIlllllIIIl) {
        return this.inventorySlots.get(llllllllllllIIlIIIIIIIIlllllIIIl);
    }
    
    public static boolean isValidDragMode(final int llllllllllllIIlIIIIIIIIlIIlIIIll, final EntityPlayer llllllllllllIIlIIIIIIIIlIIlIIIII) {
        return llllllllllllIIlIIIIIIIIlIIlIIIll == 0 || llllllllllllIIlIIIIIIIIlIIlIIIll == 1 || (llllllllllllIIlIIIIIIIIlIIlIIIll == 2 && llllllllllllIIlIIIIIIIIlIIlIIIII.capabilities.isCreativeMode);
    }
    
    public static int calcRedstone(@Nullable final TileEntity llllllllllllIIlIIIIIIIIlIIIIIIIl) {
        return (llllllllllllIIlIIIIIIIIlIIIIIIIl instanceof IInventory) ? calcRedstoneFromInventory((IInventory)llllllllllllIIlIIIIIIIIlIIIIIIIl) : 0;
    }
    
    public boolean enchantItem(final EntityPlayer llllllllllllIIlIIIIIIIlIIIIIIlIl, final int llllllllllllIIlIIIIIIIlIIIIIIlII) {
        return false;
    }
    
    public short getNextTransactionID(final InventoryPlayer llllllllllllIIlIIIIIIIIlIllIIIlI) {
        ++this.transactionID;
        return this.transactionID;
    }
    
    protected boolean mergeItemStack(final ItemStack llllllllllllIIlIIIIIIIIlIlIIIllI, final int llllllllllllIIlIIIIIIIIlIIlllIIl, final int llllllllllllIIlIIIIIIIIlIlIIIlII, final boolean llllllllllllIIlIIIIIIIIlIIllIlll) {
        boolean llllllllllllIIlIIIIIIIIlIlIIIIlI = false;
        int llllllllllllIIlIIIIIIIIlIlIIIIIl = llllllllllllIIlIIIIIIIIlIIlllIIl;
        if (llllllllllllIIlIIIIIIIIlIIllIlll) {
            llllllllllllIIlIIIIIIIIlIlIIIIIl = llllllllllllIIlIIIIIIIIlIlIIIlII - 1;
        }
        if (llllllllllllIIlIIIIIIIIlIlIIIllI.isStackable()) {
            while (!llllllllllllIIlIIIIIIIIlIlIIIllI.func_190926_b()) {
                if (llllllllllllIIlIIIIIIIIlIIllIlll) {
                    if (llllllllllllIIlIIIIIIIIlIlIIIIIl < llllllllllllIIlIIIIIIIIlIIlllIIl) {
                        break;
                    }
                }
                else if (llllllllllllIIlIIIIIIIIlIlIIIIIl >= llllllllllllIIlIIIIIIIIlIlIIIlII) {
                    break;
                }
                final Slot llllllllllllIIlIIIIIIIIlIlIIIIII = this.inventorySlots.get(llllllllllllIIlIIIIIIIIlIlIIIIIl);
                final ItemStack llllllllllllIIlIIIIIIIIlIIllllll = llllllllllllIIlIIIIIIIIlIlIIIIII.getStack();
                if (!llllllllllllIIlIIIIIIIIlIIllllll.func_190926_b() && llllllllllllIIlIIIIIIIIlIIllllll.getItem() == llllllllllllIIlIIIIIIIIlIlIIIllI.getItem() && (!llllllllllllIIlIIIIIIIIlIlIIIllI.getHasSubtypes() || llllllllllllIIlIIIIIIIIlIlIIIllI.getMetadata() == llllllllllllIIlIIIIIIIIlIIllllll.getMetadata()) && ItemStack.areItemStackTagsEqual(llllllllllllIIlIIIIIIIIlIlIIIllI, llllllllllllIIlIIIIIIIIlIIllllll)) {
                    final int llllllllllllIIlIIIIIIIIlIIlllllI = llllllllllllIIlIIIIIIIIlIIllllll.func_190916_E() + llllllllllllIIlIIIIIIIIlIlIIIllI.func_190916_E();
                    if (llllllllllllIIlIIIIIIIIlIIlllllI <= llllllllllllIIlIIIIIIIIlIlIIIllI.getMaxStackSize()) {
                        llllllllllllIIlIIIIIIIIlIlIIIllI.func_190920_e(0);
                        llllllllllllIIlIIIIIIIIlIIllllll.func_190920_e(llllllllllllIIlIIIIIIIIlIIlllllI);
                        llllllllllllIIlIIIIIIIIlIlIIIIII.onSlotChanged();
                        llllllllllllIIlIIIIIIIIlIlIIIIlI = true;
                    }
                    else if (llllllllllllIIlIIIIIIIIlIIllllll.func_190916_E() < llllllllllllIIlIIIIIIIIlIlIIIllI.getMaxStackSize()) {
                        llllllllllllIIlIIIIIIIIlIlIIIllI.func_190918_g(llllllllllllIIlIIIIIIIIlIlIIIllI.getMaxStackSize() - llllllllllllIIlIIIIIIIIlIIllllll.func_190916_E());
                        llllllllllllIIlIIIIIIIIlIIllllll.func_190920_e(llllllllllllIIlIIIIIIIIlIlIIIllI.getMaxStackSize());
                        llllllllllllIIlIIIIIIIIlIlIIIIII.onSlotChanged();
                        llllllllllllIIlIIIIIIIIlIlIIIIlI = true;
                    }
                }
                if (llllllllllllIIlIIIIIIIIlIIllIlll) {
                    --llllllllllllIIlIIIIIIIIlIlIIIIIl;
                }
                else {
                    ++llllllllllllIIlIIIIIIIIlIlIIIIIl;
                }
            }
        }
        if (!llllllllllllIIlIIIIIIIIlIlIIIllI.func_190926_b()) {
            if (llllllllllllIIlIIIIIIIIlIIllIlll) {
                llllllllllllIIlIIIIIIIIlIlIIIIIl = llllllllllllIIlIIIIIIIIlIlIIIlII - 1;
            }
            else {
                llllllllllllIIlIIIIIIIIlIlIIIIIl = llllllllllllIIlIIIIIIIIlIIlllIIl;
            }
            while (true) {
                if (llllllllllllIIlIIIIIIIIlIIllIlll) {
                    if (llllllllllllIIlIIIIIIIIlIlIIIIIl < llllllllllllIIlIIIIIIIIlIIlllIIl) {
                        break;
                    }
                }
                else if (llllllllllllIIlIIIIIIIIlIlIIIIIl >= llllllllllllIIlIIIIIIIIlIlIIIlII) {
                    break;
                }
                final Slot llllllllllllIIlIIIIIIIIlIIllllIl = this.inventorySlots.get(llllllllllllIIlIIIIIIIIlIlIIIIIl);
                final ItemStack llllllllllllIIlIIIIIIIIlIIllllII = llllllllllllIIlIIIIIIIIlIIllllIl.getStack();
                if (llllllllllllIIlIIIIIIIIlIIllllII.func_190926_b() && llllllllllllIIlIIIIIIIIlIIllllIl.isItemValid(llllllllllllIIlIIIIIIIIlIlIIIllI)) {
                    if (llllllllllllIIlIIIIIIIIlIlIIIllI.func_190916_E() > llllllllllllIIlIIIIIIIIlIIllllIl.getSlotStackLimit()) {
                        llllllllllllIIlIIIIIIIIlIIllllIl.putStack(llllllllllllIIlIIIIIIIIlIlIIIllI.splitStack(llllllllllllIIlIIIIIIIIlIIllllIl.getSlotStackLimit()));
                    }
                    else {
                        llllllllllllIIlIIIIIIIIlIIllllIl.putStack(llllllllllllIIlIIIIIIIIlIlIIIllI.splitStack(llllllllllllIIlIIIIIIIIlIlIIIllI.func_190916_E()));
                    }
                    llllllllllllIIlIIIIIIIIlIIllllIl.onSlotChanged();
                    llllllllllllIIlIIIIIIIIlIlIIIIlI = true;
                    break;
                }
                if (llllllllllllIIlIIIIIIIIlIIllIlll) {
                    --llllllllllllIIlIIIIIIIIlIlIIIIIl;
                }
                else {
                    ++llllllllllllIIlIIIIIIIIlIlIIIIIl;
                }
            }
        }
        return llllllllllllIIlIIIIIIIIlIlIIIIlI;
    }
    
    public static boolean canAddItemToSlot(@Nullable final Slot llllllllllllIIlIIIIIIIIlIIIlIlII, final ItemStack llllllllllllIIlIIIIIIIIlIIIlIlll, final boolean llllllllllllIIlIIIIIIIIlIIIlIIlI) {
        final boolean llllllllllllIIlIIIIIIIIlIIIlIlIl = llllllllllllIIlIIIIIIIIlIIIlIlII == null || !llllllllllllIIlIIIIIIIIlIIIlIlII.getHasStack();
        if (!llllllllllllIIlIIIIIIIIlIIIlIlIl && llllllllllllIIlIIIIIIIIlIIIlIlll.isItemEqual(llllllllllllIIlIIIIIIIIlIIIlIlII.getStack()) && ItemStack.areItemStackTagsEqual(llllllllllllIIlIIIIIIIIlIIIlIlII.getStack(), llllllllllllIIlIIIIIIIIlIIIlIlll)) {
            return llllllllllllIIlIIIIIIIIlIIIlIlII.getStack().func_190916_E() + (llllllllllllIIlIIIIIIIIlIIIlIIlI ? 0 : llllllllllllIIlIIIIIIIIlIIIlIlll.func_190916_E()) <= llllllllllllIIlIIIIIIIIlIIIlIlll.getMaxStackSize();
        }
        return llllllllllllIIlIIIIIIIIlIIIlIlIl;
    }
    
    public void putStackInSlot(final int llllllllllllIIlIIIIIIIIlIlllIIlI, final ItemStack llllllllllllIIlIIIIIIIIlIlllIlII) {
        this.getSlot(llllllllllllIIlIIIIIIIIlIlllIIlI).putStack(llllllllllllIIlIIIIIIIIlIlllIlII);
    }
    
    protected void func_192389_a(final World llllllllllllIIlIIIIIIIIIllIlllll, final EntityPlayer llllllllllllIIlIIIIIIIIIllIllllI, final InventoryCrafting llllllllllllIIlIIIIIIIIIlllIIlIl, final InventoryCraftResult llllllllllllIIlIIIIIIIIIllIlllII) {
        if (!llllllllllllIIlIIIIIIIIIllIlllll.isRemote) {
            final EntityPlayerMP llllllllllllIIlIIIIIIIIIlllIIIll = (EntityPlayerMP)llllllllllllIIlIIIIIIIIIllIllllI;
            ItemStack llllllllllllIIlIIIIIIIIIlllIIIlI = ItemStack.field_190927_a;
            final IRecipe llllllllllllIIlIIIIIIIIIlllIIIIl = CraftingManager.func_192413_b(llllllllllllIIlIIIIIIIIIlllIIlIl, llllllllllllIIlIIIIIIIIIllIlllll);
            if (llllllllllllIIlIIIIIIIIIlllIIIIl != null && (llllllllllllIIlIIIIIIIIIlllIIIIl.func_192399_d() || !llllllllllllIIlIIIIIIIIIllIlllll.getGameRules().getBoolean("doLimitedCrafting") || llllllllllllIIlIIIIIIIIIlllIIIll.func_192037_E().func_193830_f(llllllllllllIIlIIIIIIIIIlllIIIIl))) {
                llllllllllllIIlIIIIIIIIIllIlllII.func_193056_a(llllllllllllIIlIIIIIIIIIlllIIIIl);
                llllllllllllIIlIIIIIIIIIlllIIIlI = llllllllllllIIlIIIIIIIIIlllIIIIl.getCraftingResult(llllllllllllIIlIIIIIIIIIlllIIlIl);
            }
            llllllllllllIIlIIIIIIIIIllIlllII.setInventorySlotContents(0, llllllllllllIIlIIIIIIIIIlllIIIlI);
            llllllllllllIIlIIIIIIIIIlllIIIll.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, llllllllllllIIlIIIIIIIIIlllIIIlI));
        }
    }
    
    protected void resetDrag() {
        this.dragEvent = 0;
        this.dragSlots.clear();
    }
    
    public static int getQuickcraftMask(final int llllllllllllIIlIIIIIIIIlIIlIlIIl, final int llllllllllllIIlIIIIIIIIlIIlIlIII) {
        return (llllllllllllIIlIIIIIIIIlIIlIlIIl & 0x3) | (llllllllllllIIlIIIIIIIIlIIlIlIII & 0x3) << 2;
    }
    
    public ItemStack slotClick(final int llllllllllllIIlIIIIIIIIllIlIIlIl, final int llllllllllllIIlIIIIIIIIlllIlIIIl, final ClickType llllllllllllIIlIIIIIIIIllIlIIIll, final EntityPlayer llllllllllllIIlIIIIIIIIllIlIIIlI) {
        ItemStack llllllllllllIIlIIIIIIIIlllIIlllI = ItemStack.field_190927_a;
        final InventoryPlayer llllllllllllIIlIIIIIIIIlllIIllIl = llllllllllllIIlIIIIIIIIllIlIIIlI.inventory;
        if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.QUICK_CRAFT) {
            final int llllllllllllIIlIIIIIIIIlllIIllII = this.dragEvent;
            this.dragEvent = getDragEvent(llllllllllllIIlIIIIIIIIlllIlIIIl);
            if ((llllllllllllIIlIIIIIIIIlllIIllII != 1 || this.dragEvent != 2) && llllllllllllIIlIIIIIIIIlllIIllII != this.dragEvent) {
                this.resetDrag();
            }
            else if (llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().func_190926_b()) {
                this.resetDrag();
            }
            else if (this.dragEvent == 0) {
                this.dragMode = extractDragMode(llllllllllllIIlIIIIIIIIlllIlIIIl);
                if (isValidDragMode(this.dragMode, llllllllllllIIlIIIIIIIIllIlIIIlI)) {
                    this.dragEvent = 1;
                    this.dragSlots.clear();
                }
                else {
                    this.resetDrag();
                }
            }
            else if (this.dragEvent == 1) {
                final Slot llllllllllllIIlIIIIIIIIlllIIlIll = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
                final ItemStack llllllllllllIIlIIIIIIIIlllIIlIlI = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack();
                if (llllllllllllIIlIIIIIIIIlllIIlIll != null && canAddItemToSlot(llllllllllllIIlIIIIIIIIlllIIlIll, llllllllllllIIlIIIIIIIIlllIIlIlI, true) && llllllllllllIIlIIIIIIIIlllIIlIll.isItemValid(llllllllllllIIlIIIIIIIIlllIIlIlI) && (this.dragMode == 2 || llllllllllllIIlIIIIIIIIlllIIlIlI.func_190916_E() > this.dragSlots.size()) && this.canDragIntoSlot(llllllllllllIIlIIIIIIIIlllIIlIll)) {
                    this.dragSlots.add(llllllllllllIIlIIIIIIIIlllIIlIll);
                }
            }
            else if (this.dragEvent == 2) {
                if (!this.dragSlots.isEmpty()) {
                    final ItemStack llllllllllllIIlIIIIIIIIlllIIlIIl = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().copy();
                    int llllllllllllIIlIIIIIIIIlllIIlIII = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().func_190916_E();
                    for (final Slot llllllllllllIIlIIIIIIIIlllIIIlll : this.dragSlots) {
                        final ItemStack llllllllllllIIlIIIIIIIIlllIIIllI = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack();
                        if (llllllllllllIIlIIIIIIIIlllIIIlll != null && canAddItemToSlot(llllllllllllIIlIIIIIIIIlllIIIlll, llllllllllllIIlIIIIIIIIlllIIIllI, true) && llllllllllllIIlIIIIIIIIlllIIIlll.isItemValid(llllllllllllIIlIIIIIIIIlllIIIllI) && (this.dragMode == 2 || llllllllllllIIlIIIIIIIIlllIIIllI.func_190916_E() >= this.dragSlots.size()) && this.canDragIntoSlot(llllllllllllIIlIIIIIIIIlllIIIlll)) {
                            final ItemStack llllllllllllIIlIIIIIIIIlllIIIlIl = llllllllllllIIlIIIIIIIIlllIIlIIl.copy();
                            final int llllllllllllIIlIIIIIIIIlllIIIlII = llllllllllllIIlIIIIIIIIlllIIIlll.getHasStack() ? llllllllllllIIlIIIIIIIIlllIIIlll.getStack().func_190916_E() : 0;
                            computeStackSize(this.dragSlots, this.dragMode, llllllllllllIIlIIIIIIIIlllIIIlIl, llllllllllllIIlIIIIIIIIlllIIIlII);
                            final int llllllllllllIIlIIIIIIIIlllIIIIll = Math.min(llllllllllllIIlIIIIIIIIlllIIIlIl.getMaxStackSize(), llllllllllllIIlIIIIIIIIlllIIIlll.getItemStackLimit(llllllllllllIIlIIIIIIIIlllIIIlIl));
                            if (llllllllllllIIlIIIIIIIIlllIIIlIl.func_190916_E() > llllllllllllIIlIIIIIIIIlllIIIIll) {
                                llllllllllllIIlIIIIIIIIlllIIIlIl.func_190920_e(llllllllllllIIlIIIIIIIIlllIIIIll);
                            }
                            llllllllllllIIlIIIIIIIIlllIIlIII -= llllllllllllIIlIIIIIIIIlllIIIlIl.func_190916_E() - llllllllllllIIlIIIIIIIIlllIIIlII;
                            llllllllllllIIlIIIIIIIIlllIIIlll.putStack(llllllllllllIIlIIIIIIIIlllIIIlIl);
                        }
                    }
                    llllllllllllIIlIIIIIIIIlllIIlIIl.func_190920_e(llllllllllllIIlIIIIIIIIlllIIlIII);
                    llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(llllllllllllIIlIIIIIIIIlllIIlIIl);
                }
                this.resetDrag();
            }
            else {
                this.resetDrag();
            }
        }
        else if (this.dragEvent != 0) {
            this.resetDrag();
        }
        else if ((llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.PICKUP || llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.QUICK_MOVE) && (llllllllllllIIlIIIIIIIIlllIlIIIl == 0 || llllllllllllIIlIIIIIIIIlllIlIIIl == 1)) {
            if (llllllllllllIIlIIIIIIIIllIlIIlIl == -999) {
                if (!llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().func_190926_b()) {
                    if (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) {
                        llllllllllllIIlIIIIIIIIllIlIIIlI.dropItem(llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack(), true);
                        llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(ItemStack.field_190927_a);
                    }
                    if (llllllllllllIIlIIIIIIIIlllIlIIIl == 1) {
                        llllllllllllIIlIIIIIIIIllIlIIIlI.dropItem(llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().splitStack(1), true);
                    }
                }
            }
            else if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.QUICK_MOVE) {
                if (llllllllllllIIlIIIIIIIIllIlIIlIl < 0) {
                    return ItemStack.field_190927_a;
                }
                final Slot llllllllllllIIlIIIIIIIIlllIIIIlI = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
                if (llllllllllllIIlIIIIIIIIlllIIIIlI == null || !llllllllllllIIlIIIIIIIIlllIIIIlI.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI)) {
                    return ItemStack.field_190927_a;
                }
                for (ItemStack llllllllllllIIlIIIIIIIIlllIIIIIl = this.transferStackInSlot(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIlIIlIl); !llllllllllllIIlIIIIIIIIlllIIIIIl.func_190926_b(); llllllllllllIIlIIIIIIIIlllIIIIIl = this.transferStackInSlot(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIlIIlIl)) {
                    if (!ItemStack.areItemsEqual(llllllllllllIIlIIIIIIIIlllIIIIlI.getStack(), llllllllllllIIlIIIIIIIIlllIIIIIl)) {
                        break;
                    }
                    llllllllllllIIlIIIIIIIIlllIIlllI = llllllllllllIIlIIIIIIIIlllIIIIIl.copy();
                }
            }
            else {
                if (llllllllllllIIlIIIIIIIIllIlIIlIl < 0) {
                    return ItemStack.field_190927_a;
                }
                final Slot llllllllllllIIlIIIIIIIIlllIIIIII = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
                if (llllllllllllIIlIIIIIIIIlllIIIIII != null) {
                    ItemStack llllllllllllIIlIIIIIIIIllIllllll = llllllllllllIIlIIIIIIIIlllIIIIII.getStack();
                    final ItemStack llllllllllllIIlIIIIIIIIllIlllllI = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack();
                    if (!llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                        llllllllllllIIlIIIIIIIIlllIIlllI = llllllllllllIIlIIIIIIIIllIllllll.copy();
                    }
                    if (llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                        if (!llllllllllllIIlIIIIIIIIllIlllllI.func_190926_b() && llllllllllllIIlIIIIIIIIlllIIIIII.isItemValid(llllllllllllIIlIIIIIIIIllIlllllI)) {
                            int llllllllllllIIlIIIIIIIIllIllllIl = (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? llllllllllllIIlIIIIIIIIllIlllllI.func_190916_E() : 1;
                            if (llllllllllllIIlIIIIIIIIllIllllIl > llllllllllllIIlIIIIIIIIlllIIIIII.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllllI)) {
                                llllllllllllIIlIIIIIIIIllIllllIl = llllllllllllIIlIIIIIIIIlllIIIIII.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllllI);
                            }
                            llllllllllllIIlIIIIIIIIlllIIIIII.putStack(llllllllllllIIlIIIIIIIIllIlllllI.splitStack(llllllllllllIIlIIIIIIIIllIllllIl));
                        }
                    }
                    else if (llllllllllllIIlIIIIIIIIlllIIIIII.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI)) {
                        if (llllllllllllIIlIIIIIIIIllIlllllI.func_190926_b()) {
                            if (llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                                llllllllllllIIlIIIIIIIIlllIIIIII.putStack(ItemStack.field_190927_a);
                                llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(ItemStack.field_190927_a);
                            }
                            else {
                                final int llllllllllllIIlIIIIIIIIllIllllII = (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? llllllllllllIIlIIIIIIIIllIllllll.func_190916_E() : ((llllllllllllIIlIIIIIIIIllIllllll.func_190916_E() + 1) / 2);
                                llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(llllllllllllIIlIIIIIIIIlllIIIIII.decrStackSize(llllllllllllIIlIIIIIIIIllIllllII));
                                if (llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                                    llllllllllllIIlIIIIIIIIlllIIIIII.putStack(ItemStack.field_190927_a);
                                }
                                llllllllllllIIlIIIIIIIIlllIIIIII.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack());
                            }
                        }
                        else if (llllllllllllIIlIIIIIIIIlllIIIIII.isItemValid(llllllllllllIIlIIIIIIIIllIlllllI)) {
                            if (llllllllllllIIlIIIIIIIIllIllllll.getItem() == llllllllllllIIlIIIIIIIIllIlllllI.getItem() && llllllllllllIIlIIIIIIIIllIllllll.getMetadata() == llllllllllllIIlIIIIIIIIllIlllllI.getMetadata() && ItemStack.areItemStackTagsEqual(llllllllllllIIlIIIIIIIIllIllllll, llllllllllllIIlIIIIIIIIllIlllllI)) {
                                int llllllllllllIIlIIIIIIIIllIlllIll = (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? llllllllllllIIlIIIIIIIIllIlllllI.func_190916_E() : 1;
                                if (llllllllllllIIlIIIIIIIIllIlllIll > llllllllllllIIlIIIIIIIIlllIIIIII.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllllI) - llllllllllllIIlIIIIIIIIllIllllll.func_190916_E()) {
                                    llllllllllllIIlIIIIIIIIllIlllIll = llllllllllllIIlIIIIIIIIlllIIIIII.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllllI) - llllllllllllIIlIIIIIIIIllIllllll.func_190916_E();
                                }
                                if (llllllllllllIIlIIIIIIIIllIlllIll > llllllllllllIIlIIIIIIIIllIlllllI.getMaxStackSize() - llllllllllllIIlIIIIIIIIllIllllll.func_190916_E()) {
                                    llllllllllllIIlIIIIIIIIllIlllIll = llllllllllllIIlIIIIIIIIllIlllllI.getMaxStackSize() - llllllllllllIIlIIIIIIIIllIllllll.func_190916_E();
                                }
                                llllllllllllIIlIIIIIIIIllIlllllI.func_190918_g(llllllllllllIIlIIIIIIIIllIlllIll);
                                llllllllllllIIlIIIIIIIIllIllllll.func_190917_f(llllllllllllIIlIIIIIIIIllIlllIll);
                            }
                            else if (llllllllllllIIlIIIIIIIIllIlllllI.func_190916_E() <= llllllllllllIIlIIIIIIIIlllIIIIII.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllllI)) {
                                llllllllllllIIlIIIIIIIIlllIIIIII.putStack(llllllllllllIIlIIIIIIIIllIlllllI);
                                llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(llllllllllllIIlIIIIIIIIllIllllll);
                            }
                        }
                        else if (llllllllllllIIlIIIIIIIIllIllllll.getItem() == llllllllllllIIlIIIIIIIIllIlllllI.getItem() && llllllllllllIIlIIIIIIIIllIlllllI.getMaxStackSize() > 1 && (!llllllllllllIIlIIIIIIIIllIllllll.getHasSubtypes() || llllllllllllIIlIIIIIIIIllIllllll.getMetadata() == llllllllllllIIlIIIIIIIIllIlllllI.getMetadata()) && ItemStack.areItemStackTagsEqual(llllllllllllIIlIIIIIIIIllIllllll, llllllllllllIIlIIIIIIIIllIlllllI) && !llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                            final int llllllllllllIIlIIIIIIIIllIlllIlI = llllllllllllIIlIIIIIIIIllIllllll.func_190916_E();
                            if (llllllllllllIIlIIIIIIIIllIlllIlI + llllllllllllIIlIIIIIIIIllIlllllI.func_190916_E() <= llllllllllllIIlIIIIIIIIllIlllllI.getMaxStackSize()) {
                                llllllllllllIIlIIIIIIIIllIlllllI.func_190917_f(llllllllllllIIlIIIIIIIIllIlllIlI);
                                llllllllllllIIlIIIIIIIIllIllllll = llllllllllllIIlIIIIIIIIlllIIIIII.decrStackSize(llllllllllllIIlIIIIIIIIllIlllIlI);
                                if (llllllllllllIIlIIIIIIIIllIllllll.func_190926_b()) {
                                    llllllllllllIIlIIIIIIIIlllIIIIII.putStack(ItemStack.field_190927_a);
                                }
                                llllllllllllIIlIIIIIIIIlllIIIIII.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack());
                            }
                        }
                    }
                    llllllllllllIIlIIIIIIIIlllIIIIII.onSlotChanged();
                }
            }
        }
        else if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.SWAP && llllllllllllIIlIIIIIIIIlllIlIIIl >= 0 && llllllllllllIIlIIIIIIIIlllIlIIIl < 9) {
            final Slot llllllllllllIIlIIIIIIIIllIlllIIl = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
            final ItemStack llllllllllllIIlIIIIIIIIllIlllIII = llllllllllllIIlIIIIIIIIlllIIllIl.getStackInSlot(llllllllllllIIlIIIIIIIIlllIlIIIl);
            final ItemStack llllllllllllIIlIIIIIIIIllIllIlll = llllllllllllIIlIIIIIIIIllIlllIIl.getStack();
            if (!llllllllllllIIlIIIIIIIIllIlllIII.func_190926_b() || !llllllllllllIIlIIIIIIIIllIllIlll.func_190926_b()) {
                if (llllllllllllIIlIIIIIIIIllIlllIII.func_190926_b()) {
                    if (llllllllllllIIlIIIIIIIIllIlllIIl.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI)) {
                        llllllllllllIIlIIIIIIIIlllIIllIl.setInventorySlotContents(llllllllllllIIlIIIIIIIIlllIlIIIl, llllllllllllIIlIIIIIIIIllIllIlll);
                        llllllllllllIIlIIIIIIIIllIlllIIl.func_190900_b(llllllllllllIIlIIIIIIIIllIllIlll.func_190916_E());
                        llllllllllllIIlIIIIIIIIllIlllIIl.putStack(ItemStack.field_190927_a);
                        llllllllllllIIlIIIIIIIIllIlllIIl.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIllIlll);
                    }
                }
                else if (llllllllllllIIlIIIIIIIIllIllIlll.func_190926_b()) {
                    if (llllllllllllIIlIIIIIIIIllIlllIIl.isItemValid(llllllllllllIIlIIIIIIIIllIlllIII)) {
                        final int llllllllllllIIlIIIIIIIIllIllIllI = llllllllllllIIlIIIIIIIIllIlllIIl.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllIII);
                        if (llllllllllllIIlIIIIIIIIllIlllIII.func_190916_E() > llllllllllllIIlIIIIIIIIllIllIllI) {
                            llllllllllllIIlIIIIIIIIllIlllIIl.putStack(llllllllllllIIlIIIIIIIIllIlllIII.splitStack(llllllllllllIIlIIIIIIIIllIllIllI));
                        }
                        else {
                            llllllllllllIIlIIIIIIIIllIlllIIl.putStack(llllllllllllIIlIIIIIIIIllIlllIII);
                            llllllllllllIIlIIIIIIIIlllIIllIl.setInventorySlotContents(llllllllllllIIlIIIIIIIIlllIlIIIl, ItemStack.field_190927_a);
                        }
                    }
                }
                else if (llllllllllllIIlIIIIIIIIllIlllIIl.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI) && llllllllllllIIlIIIIIIIIllIlllIIl.isItemValid(llllllllllllIIlIIIIIIIIllIlllIII)) {
                    final int llllllllllllIIlIIIIIIIIllIllIlIl = llllllllllllIIlIIIIIIIIllIlllIIl.getItemStackLimit(llllllllllllIIlIIIIIIIIllIlllIII);
                    if (llllllllllllIIlIIIIIIIIllIlllIII.func_190916_E() > llllllllllllIIlIIIIIIIIllIllIlIl) {
                        llllllllllllIIlIIIIIIIIllIlllIIl.putStack(llllllllllllIIlIIIIIIIIllIlllIII.splitStack(llllllllllllIIlIIIIIIIIllIllIlIl));
                        llllllllllllIIlIIIIIIIIllIlllIIl.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIllIlll);
                        if (!llllllllllllIIlIIIIIIIIlllIIllIl.addItemStackToInventory(llllllllllllIIlIIIIIIIIllIllIlll)) {
                            llllllllllllIIlIIIIIIIIllIlIIIlI.dropItem(llllllllllllIIlIIIIIIIIllIllIlll, true);
                        }
                    }
                    else {
                        llllllllllllIIlIIIIIIIIllIlllIIl.putStack(llllllllllllIIlIIIIIIIIllIlllIII);
                        llllllllllllIIlIIIIIIIIlllIIllIl.setInventorySlotContents(llllllllllllIIlIIIIIIIIlllIlIIIl, llllllllllllIIlIIIIIIIIllIllIlll);
                        llllllllllllIIlIIIIIIIIllIlllIIl.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIllIlll);
                    }
                }
            }
        }
        else if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.CLONE && llllllllllllIIlIIIIIIIIllIlIIIlI.capabilities.isCreativeMode && llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().func_190926_b() && llllllllllllIIlIIIIIIIIllIlIIlIl >= 0) {
            final Slot llllllllllllIIlIIIIIIIIllIllIlII = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
            if (llllllllllllIIlIIIIIIIIllIllIlII != null && llllllllllllIIlIIIIIIIIllIllIlII.getHasStack()) {
                final ItemStack llllllllllllIIlIIIIIIIIllIllIIll = llllllllllllIIlIIIIIIIIllIllIlII.getStack().copy();
                llllllllllllIIlIIIIIIIIllIllIIll.func_190920_e(llllllllllllIIlIIIIIIIIllIllIIll.getMaxStackSize());
                llllllllllllIIlIIIIIIIIlllIIllIl.setItemStack(llllllllllllIIlIIIIIIIIllIllIIll);
            }
        }
        else if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.THROW && llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack().func_190926_b() && llllllllllllIIlIIIIIIIIllIlIIlIl >= 0) {
            final Slot llllllllllllIIlIIIIIIIIllIllIIlI = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
            if (llllllllllllIIlIIIIIIIIllIllIIlI != null && llllllllllllIIlIIIIIIIIllIllIIlI.getHasStack() && llllllllllllIIlIIIIIIIIllIllIIlI.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI)) {
                final ItemStack llllllllllllIIlIIIIIIIIllIllIIIl = llllllllllllIIlIIIIIIIIllIllIIlI.decrStackSize((llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? 1 : llllllllllllIIlIIIIIIIIllIllIIlI.getStack().func_190916_E());
                llllllllllllIIlIIIIIIIIllIllIIlI.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIllIIIl);
                llllllllllllIIlIIIIIIIIllIlIIIlI.dropItem(llllllllllllIIlIIIIIIIIllIllIIIl, true);
            }
        }
        else if (llllllllllllIIlIIIIIIIIllIlIIIll == ClickType.PICKUP_ALL && llllllllllllIIlIIIIIIIIllIlIIlIl >= 0) {
            final Slot llllllllllllIIlIIIIIIIIllIllIIII = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIIlIl);
            final ItemStack llllllllllllIIlIIIIIIIIllIlIllll = llllllllllllIIlIIIIIIIIlllIIllIl.getItemStack();
            if (!llllllllllllIIlIIIIIIIIllIlIllll.func_190926_b() && (llllllllllllIIlIIIIIIIIllIllIIII == null || !llllllllllllIIlIIIIIIIIllIllIIII.getHasStack() || !llllllllllllIIlIIIIIIIIllIllIIII.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI))) {
                final int llllllllllllIIlIIIIIIIIllIlIlllI = (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? 0 : (this.inventorySlots.size() - 1);
                final int llllllllllllIIlIIIIIIIIllIlIllIl = (llllllllllllIIlIIIIIIIIlllIlIIIl == 0) ? 1 : -1;
                for (int llllllllllllIIlIIIIIIIIllIlIllII = 0; llllllllllllIIlIIIIIIIIllIlIllII < 2; ++llllllllllllIIlIIIIIIIIllIlIllII) {
                    for (int llllllllllllIIlIIIIIIIIllIlIlIll = llllllllllllIIlIIIIIIIIllIlIlllI; llllllllllllIIlIIIIIIIIllIlIlIll >= 0 && llllllllllllIIlIIIIIIIIllIlIlIll < this.inventorySlots.size() && llllllllllllIIlIIIIIIIIllIlIllll.func_190916_E() < llllllllllllIIlIIIIIIIIllIlIllll.getMaxStackSize(); llllllllllllIIlIIIIIIIIllIlIlIll += llllllllllllIIlIIIIIIIIllIlIllIl) {
                        final Slot llllllllllllIIlIIIIIIIIllIlIlIlI = this.inventorySlots.get(llllllllllllIIlIIIIIIIIllIlIlIll);
                        if (llllllllllllIIlIIIIIIIIllIlIlIlI.getHasStack() && canAddItemToSlot(llllllllllllIIlIIIIIIIIllIlIlIlI, llllllllllllIIlIIIIIIIIllIlIllll, true) && llllllllllllIIlIIIIIIIIllIlIlIlI.canTakeStack(llllllllllllIIlIIIIIIIIllIlIIIlI) && this.canMergeSlot(llllllllllllIIlIIIIIIIIllIlIllll, llllllllllllIIlIIIIIIIIllIlIlIlI)) {
                            final ItemStack llllllllllllIIlIIIIIIIIllIlIlIIl = llllllllllllIIlIIIIIIIIllIlIlIlI.getStack();
                            if (llllllllllllIIlIIIIIIIIllIlIllII != 0 || llllllllllllIIlIIIIIIIIllIlIlIIl.func_190916_E() != llllllllllllIIlIIIIIIIIllIlIlIIl.getMaxStackSize()) {
                                final int llllllllllllIIlIIIIIIIIllIlIlIII = Math.min(llllllllllllIIlIIIIIIIIllIlIllll.getMaxStackSize() - llllllllllllIIlIIIIIIIIllIlIllll.func_190916_E(), llllllllllllIIlIIIIIIIIllIlIlIIl.func_190916_E());
                                final ItemStack llllllllllllIIlIIIIIIIIllIlIIlll = llllllllllllIIlIIIIIIIIllIlIlIlI.decrStackSize(llllllllllllIIlIIIIIIIIllIlIlIII);
                                llllllllllllIIlIIIIIIIIllIlIllll.func_190917_f(llllllllllllIIlIIIIIIIIllIlIlIII);
                                if (llllllllllllIIlIIIIIIIIllIlIIlll.func_190926_b()) {
                                    llllllllllllIIlIIIIIIIIllIlIlIlI.putStack(ItemStack.field_190927_a);
                                }
                                llllllllllllIIlIIIIIIIIllIlIlIlI.func_190901_a(llllllllllllIIlIIIIIIIIllIlIIIlI, llllllllllllIIlIIIIIIIIllIlIIlll);
                            }
                        }
                    }
                }
            }
            this.detectAndSendChanges();
        }
        return llllllllllllIIlIIIIIIIIlllIIlllI;
    }
    
    public static int extractDragMode(final int llllllllllllIIlIIIIIIIIlIIllIIII) {
        return llllllllllllIIlIIIIIIIIlIIllIIII >> 2 & 0x3;
    }
    
    protected Slot addSlotToContainer(final Slot llllllllllllIIlIIIIIIIlIIIlIlIll) {
        llllllllllllIIlIIIIIIIlIIIlIlIll.slotNumber = this.inventorySlots.size();
        this.inventorySlots.add(llllllllllllIIlIIIIIIIlIIIlIlIll);
        this.inventoryItemStacks.add(ItemStack.field_190927_a);
        return llllllllllllIIlIIIIIIIlIIIlIlIll;
    }
    
    public void onCraftMatrixChanged(final IInventory llllllllllllIIlIIIIIIIIlIllllIll) {
        this.detectAndSendChanges();
    }
    
    public void removeListener(final IContainerListener llllllllllllIIlIIIIIIIlIIIlIIIIl) {
        this.listeners.remove(llllllllllllIIlIIIIIIIlIIIlIIIIl);
    }
    
    public void detectAndSendChanges() {
        for (int llllllllllllIIlIIIIIIIlIIIIIllll = 0; llllllllllllIIlIIIIIIIlIIIIIllll < this.inventorySlots.size(); ++llllllllllllIIlIIIIIIIlIIIIIllll) {
            final ItemStack llllllllllllIIlIIIIIIIlIIIIIlllI = this.inventorySlots.get(llllllllllllIIlIIIIIIIlIIIIIllll).getStack();
            ItemStack llllllllllllIIlIIIIIIIlIIIIIllIl = this.inventoryItemStacks.get(llllllllllllIIlIIIIIIIlIIIIIllll);
            if (!ItemStack.areItemStacksEqual(llllllllllllIIlIIIIIIIlIIIIIllIl, llllllllllllIIlIIIIIIIlIIIIIlllI)) {
                llllllllllllIIlIIIIIIIlIIIIIllIl = (llllllllllllIIlIIIIIIIlIIIIIlllI.func_190926_b() ? ItemStack.field_190927_a : llllllllllllIIlIIIIIIIlIIIIIlllI.copy());
                this.inventoryItemStacks.set(llllllllllllIIlIIIIIIIlIIIIIllll, llllllllllllIIlIIIIIIIlIIIIIllIl);
                for (int llllllllllllIIlIIIIIIIlIIIIIllII = 0; llllllllllllIIlIIIIIIIlIIIIIllII < this.listeners.size(); ++llllllllllllIIlIIIIIIIlIIIIIllII) {
                    this.listeners.get(llllllllllllIIlIIIIIIIlIIIIIllII).sendSlotContents(this, llllllllllllIIlIIIIIIIlIIIIIllll, llllllllllllIIlIIIIIIIlIIIIIllIl);
                }
            }
        }
    }
    
    public boolean getCanCraft(final EntityPlayer llllllllllllIIlIIIIIIIIlIlIlllIl) {
        return !this.playerList.contains(llllllllllllIIlIIIIIIIIlIlIlllIl);
    }
    
    public static int getDragEvent(final int llllllllllllIIlIIIIIIIIlIIlIllII) {
        return llllllllllllIIlIIIIIIIIlIIlIllII & 0x3;
    }
}
