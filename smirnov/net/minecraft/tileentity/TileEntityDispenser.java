// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import java.util.Random;

public class TileEntityDispenser extends TileEntityLockableLoot
{
    private static final /* synthetic */ Random RNG;
    private /* synthetic */ NonNullList<ItemStack> stacks;
    
    static {
        RNG = new Random();
    }
    
    public TileEntityDispenser() {
        this.stacks = NonNullList.func_191197_a(9, ItemStack.field_190927_a);
    }
    
    public int getDispenseSlot() {
        this.fillWithLoot(null);
        int lllllllllllIIlllIllIIIllllIIllIl = -1;
        int lllllllllllIIlllIllIIIllllIIllII = 1;
        for (int lllllllllllIIlllIllIIIllllIIlIll = 0; lllllllllllIIlllIllIIIllllIIlIll < this.stacks.size(); ++lllllllllllIIlllIllIIIllllIIlIll) {
            if (!this.stacks.get(lllllllllllIIlllIllIIIllllIIlIll).func_190926_b() && TileEntityDispenser.RNG.nextInt(lllllllllllIIlllIllIIIllllIIllII++) == 0) {
                lllllllllllIIlllIllIIIllllIIllIl = lllllllllllIIlllIllIIIllllIIlIll;
            }
        }
        return lllllllllllIIlllIllIIIllllIIllIl;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public int addItemStack(final ItemStack lllllllllllIIlllIllIIIllllIIIIlI) {
        for (int lllllllllllIIlllIllIIIllllIIIIIl = 0; lllllllllllIIlllIllIIIllllIIIIIl < this.stacks.size(); ++lllllllllllIIlllIllIIIllllIIIIIl) {
            if (this.stacks.get(lllllllllllIIlllIllIIIllllIIIIIl).func_190926_b()) {
                this.setInventorySlotContents(lllllllllllIIlllIllIIIllllIIIIIl, lllllllllllIIlllIllIIIllllIIIIlI);
                return lllllllllllIIlllIllIIIllllIIIIIl;
            }
        }
        return -1;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllIIlllIllIIIllllIlIllI : this.stacks) {
            if (!lllllllllllIIlllIllIIIllllIlIllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int getSizeInventory() {
        return 9;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIlllIllIIIlllIlIlllI) {
        super.writeToNBT(lllllllllllIIlllIllIIIlllIlIlllI);
        if (!this.checkLootAndWrite(lllllllllllIIlllIllIIIlllIlIlllI)) {
            ItemStackHelper.func_191282_a(lllllllllllIIlllIllIIIlllIlIlllI, this.stacks);
        }
        if (this.hasCustomName()) {
            lllllllllllIIlllIllIIIlllIlIlllI.setString("CustomName", this.field_190577_o);
        }
        return lllllllllllIIlllIllIIIlllIlIlllI;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dispenser";
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.dispenser";
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllIIlllIllIIIlllIlIIlIl, final EntityPlayer lllllllllllIIlllIllIIIlllIlIIlII) {
        this.fillWithLoot(lllllllllllIIlllIllIIIlllIlIIlII);
        return new ContainerDispenser(lllllllllllIIlllIllIIIlllIlIIlIl, this);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIIlllIllIIIlllIllIlII) {
        super.readFromNBT(lllllllllllIIlllIllIIIlllIllIlII);
        this.stacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllIIlllIllIIIlllIllIlII)) {
            ItemStackHelper.func_191283_b(lllllllllllIIlllIllIIIlllIllIlII, this.stacks);
        }
        if (lllllllllllIIlllIllIIIlllIllIlII.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllIIlllIllIIIlllIllIlII.getString("CustomName");
        }
    }
    
    public static void registerFixes(final DataFixer lllllllllllIIlllIllIIIlllIlllIIl) {
        lllllllllllIIlllIllIIIlllIlllIIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityDispenser.class, new String[] { "Items" }));
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.stacks;
    }
}
