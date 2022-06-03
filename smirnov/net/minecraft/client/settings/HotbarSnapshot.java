// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.settings;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;

public class HotbarSnapshot extends ArrayList<ItemStack>
{
    public static final /* synthetic */ int field_192835_a;
    
    @Override
    public boolean isEmpty() {
        for (int llllllllllllIlllIIllIlllIllIllIl = 0; llllllllllllIlllIIllIlllIllIllIl < HotbarSnapshot.field_192835_a; ++llllllllllllIlllIIllIlllIllIllIl) {
            if (!this.get(llllllllllllIlllIIllIlllIllIllIl).func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public void func_192833_a(final NBTTagList llllllllllllIlllIIllIlllIlllIlIl) {
        for (int llllllllllllIlllIIllIlllIlllIlII = 0; llllllllllllIlllIIllIlllIlllIlII < HotbarSnapshot.field_192835_a; ++llllllllllllIlllIIllIlllIlllIlII) {
            this.set(llllllllllllIlllIIllIlllIlllIlII, new ItemStack(llllllllllllIlllIIllIlllIlllIlIl.getCompoundTagAt(llllllllllllIlllIIllIlllIlllIlII)));
        }
    }
    
    static {
        field_192835_a = InventoryPlayer.getHotbarSize();
    }
    
    public HotbarSnapshot() {
        this.ensureCapacity(HotbarSnapshot.field_192835_a);
        for (int llllllllllllIlllIIllIllllIIIIlIl = 0; llllllllllllIlllIIllIllllIIIIlIl < HotbarSnapshot.field_192835_a; ++llllllllllllIlllIIllIllllIIIIlIl) {
            this.add(ItemStack.field_190927_a);
        }
    }
    
    public NBTTagList func_192834_a() {
        final NBTTagList llllllllllllIlllIIllIlllIllllllI = new NBTTagList();
        for (int llllllllllllIlllIIllIlllIlllllIl = 0; llllllllllllIlllIIllIlllIlllllIl < HotbarSnapshot.field_192835_a; ++llllllllllllIlllIIllIlllIlllllIl) {
            llllllllllllIlllIIllIlllIllllllI.appendTag(this.get(llllllllllllIlllIIllIlllIlllllIl).writeToNBT(new NBTTagCompound()));
        }
        return llllllllllllIlllIIllIlllIllllllI;
    }
}
