// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.nbt.NBTBase;
import java.util.List;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.nbt.NBTTagCompound;

public class ItemStackHelper
{
    public static void func_191283_b(final NBTTagCompound llllllllllllllIIIIllIlllIIlllIll, final NonNullList<ItemStack> llllllllllllllIIIIllIlllIlIIIIII) {
        final NBTTagList llllllllllllllIIIIllIlllIIllllll = llllllllllllllIIIIllIlllIIlllIll.getTagList("Items", 10);
        for (int llllllllllllllIIIIllIlllIIlllllI = 0; llllllllllllllIIIIllIlllIIlllllI < llllllllllllllIIIIllIlllIIllllll.tagCount(); ++llllllllllllllIIIIllIlllIIlllllI) {
            final NBTTagCompound llllllllllllllIIIIllIlllIIllllIl = llllllllllllllIIIIllIlllIIllllll.getCompoundTagAt(llllllllllllllIIIIllIlllIIlllllI);
            final int llllllllllllllIIIIllIlllIIllllII = llllllllllllllIIIIllIlllIIllllIl.getByte("Slot") & 0xFF;
            if (llllllllllllllIIIIllIlllIIllllII >= 0 && llllllllllllllIIIIllIlllIIllllII < llllllllllllllIIIIllIlllIlIIIIII.size()) {
                llllllllllllllIIIIllIlllIlIIIIII.set(llllllllllllllIIIIllIlllIIllllII, new ItemStack(llllllllllllllIIIIllIlllIIllllIl));
            }
        }
    }
    
    public static ItemStack getAndSplit(final List<ItemStack> llllllllllllllIIIIllIlllIllIlIll, final int llllllllllllllIIIIllIlllIllIllIl, final int llllllllllllllIIIIllIlllIllIllII) {
        return (llllllllllllllIIIIllIlllIllIllIl >= 0 && llllllllllllllIIIIllIlllIllIllIl < llllllllllllllIIIIllIlllIllIlIll.size() && !llllllllllllllIIIIllIlllIllIlIll.get(llllllllllllllIIIIllIlllIllIllIl).func_190926_b() && llllllllllllllIIIIllIlllIllIllII > 0) ? llllllllllllllIIIIllIlllIllIlIll.get(llllllllllllllIIIIllIlllIllIllIl).splitStack(llllllllllllllIIIIllIlllIllIllII) : ItemStack.field_190927_a;
    }
    
    public static NBTTagCompound func_191281_a(final NBTTagCompound llllllllllllllIIIIllIlllIlIIlllI, final NonNullList<ItemStack> llllllllllllllIIIIllIlllIlIIllIl, final boolean llllllllllllllIIIIllIlllIlIIllII) {
        final NBTTagList llllllllllllllIIIIllIlllIlIlIIlI = new NBTTagList();
        for (int llllllllllllllIIIIllIlllIlIlIIIl = 0; llllllllllllllIIIIllIlllIlIlIIIl < llllllllllllllIIIIllIlllIlIIllIl.size(); ++llllllllllllllIIIIllIlllIlIlIIIl) {
            final ItemStack llllllllllllllIIIIllIlllIlIlIIII = llllllllllllllIIIIllIlllIlIIllIl.get(llllllllllllllIIIIllIlllIlIlIIIl);
            if (!llllllllllllllIIIIllIlllIlIlIIII.func_190926_b()) {
                final NBTTagCompound llllllllllllllIIIIllIlllIlIIllll = new NBTTagCompound();
                llllllllllllllIIIIllIlllIlIIllll.setByte("Slot", (byte)llllllllllllllIIIIllIlllIlIlIIIl);
                llllllllllllllIIIIllIlllIlIlIIII.writeToNBT(llllllllllllllIIIIllIlllIlIIllll);
                llllllllllllllIIIIllIlllIlIlIIlI.appendTag(llllllllllllllIIIIllIlllIlIIllll);
            }
        }
        if (!llllllllllllllIIIIllIlllIlIlIIlI.hasNoTags() || llllllllllllllIIIIllIlllIlIIllII) {
            llllllllllllllIIIIllIlllIlIIlllI.setTag("Items", llllllllllllllIIIIllIlllIlIlIIlI);
        }
        return llllllllllllllIIIIllIlllIlIIlllI;
    }
    
    public static NBTTagCompound func_191282_a(final NBTTagCompound llllllllllllllIIIIllIlllIllIIIII, final NonNullList<ItemStack> llllllllllllllIIIIllIlllIlIlllll) {
        return func_191281_a(llllllllllllllIIIIllIlllIllIIIII, llllllllllllllIIIIllIlllIlIlllll, true);
    }
    
    public static ItemStack getAndRemove(final List<ItemStack> llllllllllllllIIIIllIlllIllIIllI, final int llllllllllllllIIIIllIlllIllIIlIl) {
        return (llllllllllllllIIIIllIlllIllIIlIl >= 0 && llllllllllllllIIIIllIlllIllIIlIl < llllllllllllllIIIIllIlllIllIIllI.size()) ? llllllllllllllIIIIllIlllIllIIllI.set(llllllllllllllIIIIllIlllIllIIlIl, ItemStack.field_190927_a) : ItemStack.field_190927_a;
    }
}
