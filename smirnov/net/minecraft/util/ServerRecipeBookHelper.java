// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.apache.logging.log4j.LogManager;
import net.minecraft.inventory.Container;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.item.crafting.ShapedRecipes;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import java.util.List;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.client.util.RecipeItemHelper;
import org.apache.logging.log4j.Logger;
import net.minecraft.inventory.InventoryCraftResult;

public class ServerRecipeBookHelper
{
    private /* synthetic */ InventoryCraftResult field_194335_f;
    private final /* synthetic */ Logger field_194330_a;
    private final /* synthetic */ RecipeItemHelper field_194331_b;
    private /* synthetic */ IRecipe field_194333_d;
    private /* synthetic */ List<Slot> field_194337_h;
    private /* synthetic */ boolean field_194334_e;
    private /* synthetic */ InventoryCrafting field_194336_g;
    private /* synthetic */ EntityPlayerMP field_194332_c;
    
    private void func_194325_a(final Slot llllllllllllIlIIlIIlIIIlIlIllIII, final ItemStack llllllllllllIlIIlIIlIIIlIlIlIIIl) {
        final InventoryPlayer llllllllllllIlIIlIIlIIIlIlIlIllI = this.field_194332_c.inventory;
        final int llllllllllllIlIIlIIlIIIlIlIlIlIl = llllllllllllIlIIlIIlIIIlIlIlIllI.func_194014_c(llllllllllllIlIIlIIlIIIlIlIlIIIl);
        if (llllllllllllIlIIlIIlIIIlIlIlIlIl != -1) {
            final ItemStack llllllllllllIlIIlIIlIIIlIlIlIlII = llllllllllllIlIIlIIlIIIlIlIlIllI.getStackInSlot(llllllllllllIlIIlIIlIIIlIlIlIlIl).copy();
            if (!llllllllllllIlIIlIIlIIIlIlIlIlII.func_190926_b()) {
                if (llllllllllllIlIIlIIlIIIlIlIlIlII.func_190916_E() > 1) {
                    llllllllllllIlIIlIIlIIIlIlIlIllI.decrStackSize(llllllllllllIlIIlIIlIIIlIlIlIlIl, 1);
                }
                else {
                    llllllllllllIlIIlIIlIIIlIlIlIllI.removeStackFromSlot(llllllllllllIlIIlIIlIIIlIlIlIlIl);
                }
                llllllllllllIlIIlIIlIIIlIlIlIlII.func_190920_e(1);
                if (llllllllllllIlIIlIIlIIIlIlIllIII.getStack().func_190926_b()) {
                    llllllllllllIlIIlIIlIIIlIlIllIII.putStack(llllllllllllIlIIlIIlIIIlIlIlIlII);
                }
                else {
                    llllllllllllIlIIlIIlIIIlIlIllIII.getStack().func_190917_f(1);
                }
            }
        }
    }
    
    private void func_194323_a(final int llllllllllllIlIIlIIlIIIlIllIlIlI, final IntList llllllllllllIlIIlIIlIIIlIllIlIIl) {
        int llllllllllllIlIIlIIlIIIlIlllIlIl = this.field_194336_g.getWidth();
        int llllllllllllIlIIlIIlIIIlIlllIlII = this.field_194336_g.getHeight();
        if (this.field_194333_d instanceof ShapedRecipes) {
            final ShapedRecipes llllllllllllIlIIlIIlIIIlIlllIIll = (ShapedRecipes)this.field_194333_d;
            llllllllllllIlIIlIIlIIIlIlllIlIl = llllllllllllIlIIlIIlIIIlIlllIIll.func_192403_f();
            llllllllllllIlIIlIIlIIIlIlllIlII = llllllllllllIlIIlIIlIIIlIlllIIll.func_192404_g();
        }
        int llllllllllllIlIIlIIlIIIlIlllIIlI = 1;
        final Iterator<Integer> llllllllllllIlIIlIIlIIIlIlllIIIl = (Iterator<Integer>)llllllllllllIlIIlIIlIIIlIllIlIIl.iterator();
        for (int llllllllllllIlIIlIIlIIIlIlllIIII = 0; llllllllllllIlIIlIIlIIIlIlllIIII < this.field_194336_g.getWidth() && llllllllllllIlIIlIIlIIIlIlllIlII != llllllllllllIlIIlIIlIIIlIlllIIII; ++llllllllllllIlIIlIIlIIIlIlllIIII) {
            for (int llllllllllllIlIIlIIlIIIlIllIllll = 0; llllllllllllIlIIlIIlIIIlIllIllll < this.field_194336_g.getHeight(); ++llllllllllllIlIIlIIlIIIlIllIllll) {
                if (llllllllllllIlIIlIIlIIIlIlllIlIl == llllllllllllIlIIlIIlIIIlIllIllll || !llllllllllllIlIIlIIlIIIlIlllIIIl.hasNext()) {
                    llllllllllllIlIIlIIlIIIlIlllIIlI += this.field_194336_g.getWidth() - llllllllllllIlIIlIIlIIIlIllIllll;
                    break;
                }
                final Slot llllllllllllIlIIlIIlIIIlIllIlllI = this.field_194337_h.get(llllllllllllIlIIlIIlIIIlIlllIIlI);
                final ItemStack llllllllllllIlIIlIIlIIIlIllIllIl = RecipeItemHelper.func_194115_b(llllllllllllIlIIlIIlIIIlIlllIIIl.next());
                if (llllllllllllIlIIlIIlIIIlIllIllIl.func_190926_b()) {
                    ++llllllllllllIlIIlIIlIIIlIlllIIlI;
                }
                else {
                    for (int llllllllllllIlIIlIIlIIIlIllIllII = 0; llllllllllllIlIIlIIlIIIlIllIllII < llllllllllllIlIIlIIlIIIlIllIlIlI; ++llllllllllllIlIIlIIlIIIlIllIllII) {
                        this.func_194325_a(llllllllllllIlIIlIIlIIIlIllIlllI, llllllllllllIlIIlIIlIIIlIllIllIl);
                    }
                    ++llllllllllllIlIIlIIlIIIlIlllIIlI;
                }
            }
            if (!llllllllllllIlIIlIIlIIIlIlllIIIl.hasNext()) {
                break;
            }
        }
    }
    
    public void func_194327_a(final EntityPlayerMP llllllllllllIlIIlIIlIIIlllIIllll, @Nullable final IRecipe llllllllllllIlIIlIIlIIIlllIIlllI, final boolean llllllllllllIlIIlIIlIIIlllIIllIl) {
        if (llllllllllllIlIIlIIlIIIlllIIlllI != null && llllllllllllIlIIlIIlIIIlllIIllll.func_192037_E().func_193830_f(llllllllllllIlIIlIIlIIIlllIIlllI)) {
            this.field_194332_c = llllllllllllIlIIlIIlIIIlllIIllll;
            this.field_194333_d = llllllllllllIlIIlIIlIIIlllIIlllI;
            this.field_194334_e = llllllllllllIlIIlIIlIIIlllIIllIl;
            this.field_194337_h = llllllllllllIlIIlIIlIIIlllIIllll.openContainer.inventorySlots;
            final Container llllllllllllIlIIlIIlIIIlllIIllII = llllllllllllIlIIlIIlIIIlllIIllll.openContainer;
            this.field_194335_f = null;
            this.field_194336_g = null;
            if (llllllllllllIlIIlIIlIIIlllIIllII instanceof ContainerWorkbench) {
                this.field_194335_f = ((ContainerWorkbench)llllllllllllIlIIlIIlIIIlllIIllII).craftResult;
                this.field_194336_g = ((ContainerWorkbench)llllllllllllIlIIlIIlIIIlllIIllII).craftMatrix;
            }
            else if (llllllllllllIlIIlIIlIIIlllIIllII instanceof ContainerPlayer) {
                this.field_194335_f = ((ContainerPlayer)llllllllllllIlIIlIIlIIIlllIIllII).craftResult;
                this.field_194336_g = ((ContainerPlayer)llllllllllllIlIIlIIlIIIlllIIllII).craftMatrix;
            }
            if (this.field_194335_f != null && this.field_194336_g != null && (this.func_194328_c() || llllllllllllIlIIlIIlIIIlllIIllll.isCreative())) {
                this.field_194331_b.func_194119_a();
                llllllllllllIlIIlIIlIIIlllIIllll.inventory.func_194016_a(this.field_194331_b, false);
                this.field_194336_g.func_194018_a(this.field_194331_b);
                if (this.field_194331_b.func_194116_a(llllllllllllIlIIlIIlIIIlllIIlllI, null)) {
                    this.func_194329_b();
                }
                else {
                    this.func_194326_a();
                    llllllllllllIlIIlIIlIIIlllIIllll.connection.sendPacket(new SPacketPlaceGhostRecipe(llllllllllllIlIIlIIlIIIlllIIllll.openContainer.windowId, llllllllllllIlIIlIIlIIIlllIIlllI));
                }
                llllllllllllIlIIlIIlIIIlllIIllll.inventory.markDirty();
            }
        }
    }
    
    public ServerRecipeBookHelper() {
        this.field_194330_a = LogManager.getLogger();
        this.field_194331_b = new RecipeItemHelper();
    }
    
    private int func_194324_a(final int llllllllllllIlIIlIIlIIIllIIIlIIl, final boolean llllllllllllIlIIlIIlIIIllIIIlllI) {
        int llllllllllllIlIIlIIlIIIllIIIllIl = 1;
        if (this.field_194334_e) {
            llllllllllllIlIIlIIlIIIllIIIllIl = llllllllllllIlIIlIIlIIIllIIIlIIl;
        }
        else if (llllllllllllIlIIlIIlIIIllIIIlllI) {
            llllllllllllIlIIlIIlIIIllIIIllIl = 64;
            for (int llllllllllllIlIIlIIlIIIllIIIllII = 0; llllllllllllIlIIlIIlIIIllIIIllII < this.field_194336_g.getSizeInventory(); ++llllllllllllIlIIlIIlIIIllIIIllII) {
                final ItemStack llllllllllllIlIIlIIlIIIllIIIlIll = this.field_194336_g.getStackInSlot(llllllllllllIlIIlIIlIIIllIIIllII);
                if (!llllllllllllIlIIlIIlIIIllIIIlIll.func_190926_b() && llllllllllllIlIIlIIlIIIllIIIllIl > llllllllllllIlIIlIIlIIIllIIIlIll.func_190916_E()) {
                    llllllllllllIlIIlIIlIIIllIIIllIl = llllllllllllIlIIlIIlIIIllIIIlIll.func_190916_E();
                }
            }
            if (llllllllllllIlIIlIIlIIIllIIIllIl < 64) {
                ++llllllllllllIlIIlIIlIIIllIIIllIl;
            }
        }
        return llllllllllllIlIIlIIlIIIllIIIllIl;
    }
    
    private void func_194329_b() {
        final boolean llllllllllllIlIIlIIlIIIllIlIlIlI = this.field_194333_d.matches(this.field_194336_g, this.field_194332_c.world);
        final int llllllllllllIlIIlIIlIIIllIlIlIIl = this.field_194331_b.func_194114_b(this.field_194333_d, null);
        if (llllllllllllIlIIlIIlIIIllIlIlIlI) {
            boolean llllllllllllIlIIlIIlIIIllIlIlIII = true;
            for (int llllllllllllIlIIlIIlIIIllIlIIlll = 0; llllllllllllIlIIlIIlIIIllIlIIlll < this.field_194336_g.getSizeInventory(); ++llllllllllllIlIIlIIlIIIllIlIIlll) {
                final ItemStack llllllllllllIlIIlIIlIIIllIlIIllI = this.field_194336_g.getStackInSlot(llllllllllllIlIIlIIlIIIllIlIIlll);
                if (!llllllllllllIlIIlIIlIIIllIlIIllI.func_190926_b() && Math.min(llllllllllllIlIIlIIlIIIllIlIlIIl, llllllllllllIlIIlIIlIIIllIlIIllI.getMaxStackSize()) > llllllllllllIlIIlIIlIIIllIlIIllI.func_190916_E()) {
                    llllllllllllIlIIlIIlIIIllIlIlIII = false;
                }
            }
            if (llllllllllllIlIIlIIlIIIllIlIlIII) {
                return;
            }
        }
        final int llllllllllllIlIIlIIlIIIllIlIIlIl = this.func_194324_a(llllllllllllIlIIlIIlIIIllIlIlIIl, llllllllllllIlIIlIIlIIIllIlIlIlI);
        final IntList llllllllllllIlIIlIIlIIIllIlIIlII = (IntList)new IntArrayList();
        if (this.field_194331_b.func_194118_a(this.field_194333_d, llllllllllllIlIIlIIlIIIllIlIIlII, llllllllllllIlIIlIIlIIIllIlIIlIl)) {
            int llllllllllllIlIIlIIlIIIllIlIIIll = llllllllllllIlIIlIIlIIIllIlIIlIl;
            for (final int llllllllllllIlIIlIIlIIIllIlIIIIl : llllllllllllIlIIlIIlIIIllIlIIlII) {
                final int llllllllllllIlIIlIIlIIIllIlIIIII = RecipeItemHelper.func_194115_b(llllllllllllIlIIlIIlIIIllIlIIIIl).getMaxStackSize();
                if (llllllllllllIlIIlIIlIIIllIlIIIII < llllllllllllIlIIlIIlIIIllIlIIIll) {
                    llllllllllllIlIIlIIlIIIllIlIIIll = llllllllllllIlIIlIIlIIIllIlIIIII;
                }
            }
            if (this.field_194331_b.func_194118_a(this.field_194333_d, llllllllllllIlIIlIIlIIIllIlIIlII, llllllllllllIlIIlIIlIIIllIlIIIll)) {
                this.func_194326_a();
                this.func_194323_a(llllllllllllIlIIlIIlIIIllIlIIIll, llllllllllllIlIIlIIlIIIllIlIIlII);
            }
        }
    }
    
    private boolean func_194328_c() {
        final InventoryPlayer llllllllllllIlIIlIIlIIIlIlIIIlll = this.field_194332_c.inventory;
        for (int llllllllllllIlIIlIIlIIIlIlIIIllI = 0; llllllllllllIlIIlIIlIIIlIlIIIllI < this.field_194336_g.getSizeInventory(); ++llllllllllllIlIIlIIlIIIlIlIIIllI) {
            final ItemStack llllllllllllIlIIlIIlIIIlIlIIIlIl = this.field_194336_g.getStackInSlot(llllllllllllIlIIlIIlIIIlIlIIIllI);
            if (!llllllllllllIlIIlIIlIIIlIlIIIlIl.func_190926_b()) {
                int llllllllllllIlIIlIIlIIIlIlIIIlII = llllllllllllIlIIlIIlIIIlIlIIIlll.storeItemStack(llllllllllllIlIIlIIlIIIlIlIIIlIl);
                if (llllllllllllIlIIlIIlIIIlIlIIIlII == -1) {
                    llllllllllllIlIIlIIlIIIlIlIIIlII = llllllllllllIlIIlIIlIIIlIlIIIlll.getFirstEmptyStack();
                }
                if (llllllllllllIlIIlIIlIIIlIlIIIlII == -1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void func_194326_a() {
        final InventoryPlayer llllllllllllIlIIlIIlIIIllIllllll = this.field_194332_c.inventory;
        for (int llllllllllllIlIIlIIlIIIllIlllllI = 0; llllllllllllIlIIlIIlIIIllIlllllI < this.field_194336_g.getSizeInventory(); ++llllllllllllIlIIlIIlIIIllIlllllI) {
            final ItemStack llllllllllllIlIIlIIlIIIllIllllIl = this.field_194336_g.getStackInSlot(llllllllllllIlIIlIIlIIIllIlllllI);
            if (!llllllllllllIlIIlIIlIIIllIllllIl.func_190926_b()) {
                while (llllllllllllIlIIlIIlIIIllIllllIl.func_190916_E() > 0) {
                    int llllllllllllIlIIlIIlIIIllIllllII = llllllllllllIlIIlIIlIIIllIllllll.storeItemStack(llllllllllllIlIIlIIlIIIllIllllIl);
                    if (llllllllllllIlIIlIIlIIIllIllllII == -1) {
                        llllllllllllIlIIlIIlIIIllIllllII = llllllllllllIlIIlIIlIIIllIllllll.getFirstEmptyStack();
                    }
                    final ItemStack llllllllllllIlIIlIIlIIIllIlllIll = llllllllllllIlIIlIIlIIIllIllllIl.copy();
                    llllllllllllIlIIlIIlIIIllIlllIll.func_190920_e(1);
                    llllllllllllIlIIlIIlIIIllIllllll.func_191971_c(llllllllllllIlIIlIIlIIIllIllllII, llllllllllllIlIIlIIlIIIllIlllIll);
                    this.field_194336_g.decrStackSize(llllllllllllIlIIlIIlIIIllIlllllI, 1);
                }
            }
        }
        this.field_194336_g.clear();
        this.field_194335_f.clear();
    }
}
