// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.NonNullList;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.WorldServer;
import java.util.Random;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ILootContainer;

public abstract class TileEntityLockableLoot extends TileEntityLockable implements ILootContainer
{
    protected /* synthetic */ long lootTableSeed;
    protected /* synthetic */ ResourceLocation lootTable;
    protected /* synthetic */ String field_190577_o;
    
    protected boolean checkLootAndRead(final NBTTagCompound lllllllllllIlIIlIlIIlIlIlIIlIllI) {
        if (lllllllllllIlIIlIlIIlIlIlIIlIllI.hasKey("LootTable", 8)) {
            this.lootTable = new ResourceLocation(lllllllllllIlIIlIlIIlIlIlIIlIllI.getString("LootTable"));
            this.lootTableSeed = lllllllllllIlIIlIlIIlIlIlIIlIllI.getLong("LootTableSeed");
            return true;
        }
        return false;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllIlIIlIlIIlIlIIlIlIlIl) {
        this.fillWithLoot(null);
        return ItemStackHelper.getAndRemove(this.func_190576_q(), lllllllllllIlIIlIlIIlIlIIlIlIlIl);
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllIlIIlIlIIlIlIIllIIlll) {
        this.fillWithLoot(null);
        return this.func_190576_q().get(lllllllllllIlIIlIlIIlIlIIllIIlll);
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_190577_o != null && !this.field_190577_o.isEmpty();
    }
    
    @Override
    public int getField(final int lllllllllllIlIIlIlIIlIlIIIlllIll) {
        return 0;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public void func_190575_a(final String lllllllllllIlIIlIlIIlIlIIllIllIl) {
        this.field_190577_o = lllllllllllIlIIlIlIIlIlIIllIllIl;
    }
    
    public void fillWithLoot(@Nullable final EntityPlayer lllllllllllIlIIlIlIIlIlIlIIIlIIl) {
        if (this.lootTable != null) {
            final LootTable lllllllllllIlIIlIlIIlIlIlIIIlIII = this.world.getLootTableManager().getLootTableFromLocation(this.lootTable);
            this.lootTable = null;
            Random lllllllllllIlIIlIlIIlIlIlIIIIllI = null;
            if (this.lootTableSeed == 0L) {
                final Random lllllllllllIlIIlIlIIlIlIlIIIIlll = new Random();
            }
            else {
                lllllllllllIlIIlIlIIlIlIlIIIIllI = new Random(this.lootTableSeed);
            }
            final LootContext.Builder lllllllllllIlIIlIlIIlIlIlIIIIlIl = new LootContext.Builder((WorldServer)this.world);
            if (lllllllllllIlIIlIlIIlIlIlIIIlIIl != null) {
                lllllllllllIlIIlIlIIlIlIlIIIIlIl.withLuck(lllllllllllIlIIlIlIIlIlIlIIIlIIl.getLuck());
            }
            lllllllllllIlIIlIlIIlIlIlIIIlIII.fillInventory(this, lllllllllllIlIIlIlIIlIlIlIIIIllI, lllllllllllIlIIlIlIIlIlIlIIIIlIl.build());
        }
    }
    
    public void setLootTable(final ResourceLocation lllllllllllIlIIlIlIIlIlIIllllIII, final long lllllllllllIlIIlIlIIlIlIIlllIlII) {
        this.lootTable = lllllllllllIlIIlIlIIlIlIIllllIII;
        this.lootTableSeed = lllllllllllIlIIlIlIIlIlIIlllIlII;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllIlIIlIlIIlIlIIlIllIll, final int lllllllllllIlIIlIlIIlIlIIlIllIlI) {
        this.fillWithLoot(null);
        final ItemStack lllllllllllIlIIlIlIIlIlIIlIlllIl = ItemStackHelper.getAndSplit(this.func_190576_q(), lllllllllllIlIIlIlIIlIlIIlIllIll, lllllllllllIlIIlIlIIlIlIIlIllIlI);
        if (!lllllllllllIlIIlIlIIlIlIIlIlllIl.func_190926_b()) {
            this.markDirty();
        }
        return lllllllllllIlIIlIlIIlIlIIlIlllIl;
    }
    
    @Override
    public void clear() {
        this.fillWithLoot(null);
        this.func_190576_q().clear();
    }
    
    @Override
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }
    
    protected boolean checkLootAndWrite(final NBTTagCompound lllllllllllIlIIlIlIIlIlIlIIlIIII) {
        if (this.lootTable != null) {
            lllllllllllIlIIlIlIIlIlIlIIlIIII.setString("LootTable", this.lootTable.toString());
            if (this.lootTableSeed != 0L) {
                lllllllllllIlIIlIlIIlIlIlIIlIIII.setLong("LootTableSeed", this.lootTableSeed);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllIlIIlIlIIlIlIIlIIIIII) {
    }
    
    protected abstract NonNullList<ItemStack> func_190576_q();
    
    @Override
    public void setField(final int lllllllllllIlIIlIlIIlIlIIIlllIIl, final int lllllllllllIlIIlIlIIlIlIIIlllIII) {
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllIlIIlIlIIlIlIIlIIIIlI) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllIlIIlIlIIlIlIIlIIlIll, @Nullable final ItemStack lllllllllllIlIIlIlIIlIlIIlIIlIlI) {
        this.fillWithLoot(null);
        this.func_190576_q().set(lllllllllllIlIIlIlIIlIlIIlIIlIll, lllllllllllIlIIlIlIIlIlIIlIIlIlI);
        if (lllllllllllIlIIlIlIIlIlIIlIIlIlI.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllIlIIlIlIIlIlIIlIIlIlI.func_190920_e(this.getInventoryStackLimit());
        }
        this.markDirty();
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllIlIIlIlIIlIlIIlIIIllI) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllIlIIlIlIIlIlIIlIIIllI.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllIlIIlIlIIlIlIIIlllllI, final ItemStack lllllllllllIlIIlIlIIlIlIIIllllIl) {
        return true;
    }
}
