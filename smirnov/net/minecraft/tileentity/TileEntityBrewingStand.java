// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockBrewingStand;
import java.util.Arrays;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.InventoryHelper;
import java.util.List;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.util.EnumFacing;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.potion.PotionHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.ITickable;

public class TileEntityBrewingStand extends TileEntityLockable implements ITickable, ISidedInventory
{
    private /* synthetic */ int brewTime;
    private /* synthetic */ NonNullList<ItemStack> brewingItemStacks;
    private /* synthetic */ String customName;
    private static final /* synthetic */ int[] SLOTS_FOR_UP;
    private /* synthetic */ Item ingredientID;
    private static final /* synthetic */ int[] SLOTS_FOR_DOWN;
    private /* synthetic */ int fuel;
    private static final /* synthetic */ int[] OUTPUT_SLOTS;
    private /* synthetic */ boolean[] filledSlots;
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:brewing_stand";
    }
    
    public void setName(final String llllllllllllIIIIlIlIlIlIlIllIIlI) {
        this.customName = llllllllllllIIIIlIlIlIlIlIllIIlI;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllIIIIlIlIlIlIIIlIlIlI, final ItemStack llllllllllllIIIIlIlIlIlIIIlIllIl) {
        if (llllllllllllIIIIlIlIlIlIIIlIlIlI == 3) {
            return PotionHelper.isReagent(llllllllllllIIIIlIlIlIlIIIlIllIl);
        }
        final Item llllllllllllIIIIlIlIlIlIIIlIllII = llllllllllllIIIIlIlIlIlIIIlIllIl.getItem();
        if (llllllllllllIIIIlIlIlIlIIIlIlIlI == 4) {
            return llllllllllllIIIIlIlIlIlIIIlIllII == Items.BLAZE_POWDER;
        }
        return (llllllllllllIIIIlIlIlIlIIIlIllII == Items.POTIONITEM || llllllllllllIIIIlIlIlIlIIIlIllII == Items.SPLASH_POTION || llllllllllllIIIIlIlIlIlIIIlIllII == Items.LINGERING_POTION || llllllllllllIIIIlIlIlIlIIIlIllII == Items.GLASS_BOTTLE) && this.getStackInSlot(llllllllllllIIIIlIlIlIlIIIlIlIlI).func_190926_b();
    }
    
    public boolean[] createFilledSlotsArray() {
        final boolean[] llllllllllllIIIIlIlIlIlIlIIIlIIl = new boolean[3];
        for (int llllllllllllIIIIlIlIlIlIlIIIlIII = 0; llllllllllllIIIIlIlIlIlIlIIIlIII < 3; ++llllllllllllIIIIlIlIlIlIlIIIlIII) {
            if (!this.brewingItemStacks.get(llllllllllllIIIIlIlIlIlIlIIIlIII).func_190926_b()) {
                llllllllllllIIIIlIlIlIlIlIIIlIIl[llllllllllllIIIIlIlIlIlIlIIIlIII] = true;
            }
        }
        return llllllllllllIIIIlIlIlIlIlIIIlIIl;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.brewing";
    }
    
    private boolean canBrew() {
        final ItemStack llllllllllllIIIIlIlIlIlIIlllllll = this.brewingItemStacks.get(3);
        if (llllllllllllIIIIlIlIlIlIIlllllll.func_190926_b()) {
            return false;
        }
        if (!PotionHelper.isReagent(llllllllllllIIIIlIlIlIlIIlllllll)) {
            return false;
        }
        for (int llllllllllllIIIIlIlIlIlIIllllllI = 0; llllllllllllIIIIlIlIlIlIIllllllI < 3; ++llllllllllllIIIIlIlIlIlIIllllllI) {
            final ItemStack llllllllllllIIIIlIlIlIlIIlllllIl = this.brewingItemStacks.get(llllllllllllIIIIlIlIlIlIIllllllI);
            if (!llllllllllllIIIIlIlIlIlIIlllllIl.func_190926_b() && PotionHelper.hasConversions(llllllllllllIIIIlIlIlIlIIlllllIl, llllllllllllIIIIlIlIlIlIIlllllll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIIIIlIlIlIlIIIIIlIlI, final EntityPlayer llllllllllllIIIIlIlIlIlIIIIIllII) {
        return new ContainerBrewingStand(llllllllllllIIIIlIlIlIlIIIIIlIlI, this);
    }
    
    @Override
    public int getField(final int llllllllllllIIIIlIlIlIlIIIIIIlII) {
        switch (llllllllllllIIIIlIlIlIlIIIIIIlII) {
            case 0: {
                return this.brewTime;
            }
            case 1: {
                return this.fuel;
            }
            default: {
                return 0;
            }
        }
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing llllllllllllIIIIlIlIlIlIIIlIIlII) {
        if (llllllllllllIIIIlIlIlIlIIIlIIlII == EnumFacing.UP) {
            return TileEntityBrewingStand.SLOTS_FOR_UP;
        }
        return (llllllllllllIIIIlIlIlIlIIIlIIlII == EnumFacing.DOWN) ? TileEntityBrewingStand.SLOTS_FOR_DOWN : TileEntityBrewingStand.OUTPUT_SLOTS;
    }
    
    public TileEntityBrewingStand() {
        this.brewingItemStacks = NonNullList.func_191197_a(5, ItemStack.field_190927_a);
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllIIIIlIlIlIlIIlIIlIII) {
        return ItemStackHelper.getAndRemove(this.brewingItemStacks, llllllllllllIIIIlIlIlIlIIlIIlIII);
    }
    
    private void brewPotions() {
        ItemStack llllllllllllIIIIlIlIlIlIIlllIIll = this.brewingItemStacks.get(3);
        for (int llllllllllllIIIIlIlIlIlIIlllIIlI = 0; llllllllllllIIIIlIlIlIlIIlllIIlI < 3; ++llllllllllllIIIIlIlIlIlIIlllIIlI) {
            this.brewingItemStacks.set(llllllllllllIIIIlIlIlIlIIlllIIlI, PotionHelper.doReaction(llllllllllllIIIIlIlIlIlIIlllIIll, this.brewingItemStacks.get(llllllllllllIIIIlIlIlIlIIlllIIlI)));
        }
        llllllllllllIIIIlIlIlIlIIlllIIll.func_190918_g(1);
        final BlockPos llllllllllllIIIIlIlIlIlIIlllIIIl = this.getPos();
        if (llllllllllllIIIIlIlIlIlIIlllIIll.getItem().hasContainerItem()) {
            final ItemStack llllllllllllIIIIlIlIlIlIIlllIIII = new ItemStack(llllllllllllIIIIlIlIlIlIIlllIIll.getItem().getContainerItem());
            if (llllllllllllIIIIlIlIlIlIIlllIIll.func_190926_b()) {
                llllllllllllIIIIlIlIlIlIIlllIIll = llllllllllllIIIIlIlIlIlIIlllIIII;
            }
            else {
                InventoryHelper.spawnItemStack(this.world, llllllllllllIIIIlIlIlIlIIlllIIIl.getX(), llllllllllllIIIIlIlIlIlIIlllIIIl.getY(), llllllllllllIIIIlIlIlIlIIlllIIIl.getZ(), llllllllllllIIIIlIlIlIlIIlllIIII);
            }
        }
        this.brewingItemStacks.set(3, llllllllllllIIIIlIlIlIlIIlllIIll);
        this.world.playEvent(1035, llllllllllllIIIIlIlIlIlIIlllIIIl, 0);
    }
    
    @Override
    public int getSizeInventory() {
        return this.brewingItemStacks.size();
    }
    
    @Override
    public void update() {
        final ItemStack llllllllllllIIIIlIlIlIlIlIIlllIl = this.brewingItemStacks.get(4);
        if (this.fuel <= 0 && llllllllllllIIIIlIlIlIlIlIIlllIl.getItem() == Items.BLAZE_POWDER) {
            this.fuel = 20;
            llllllllllllIIIIlIlIlIlIlIIlllIl.func_190918_g(1);
            this.markDirty();
        }
        final boolean llllllllllllIIIIlIlIlIlIlIIlllII = this.canBrew();
        final boolean llllllllllllIIIIlIlIlIlIlIIllIll = this.brewTime > 0;
        final ItemStack llllllllllllIIIIlIlIlIlIlIIllIlI = this.brewingItemStacks.get(3);
        if (llllllllllllIIIIlIlIlIlIlIIllIll) {
            --this.brewTime;
            final boolean llllllllllllIIIIlIlIlIlIlIIllIIl = this.brewTime == 0;
            if (llllllllllllIIIIlIlIlIlIlIIllIIl && llllllllllllIIIIlIlIlIlIlIIlllII) {
                this.brewPotions();
                this.markDirty();
            }
            else if (!llllllllllllIIIIlIlIlIlIlIIlllII) {
                this.brewTime = 0;
                this.markDirty();
            }
            else if (this.ingredientID != llllllllllllIIIIlIlIlIlIlIIllIlI.getItem()) {
                this.brewTime = 0;
                this.markDirty();
            }
        }
        else if (llllllllllllIIIIlIlIlIlIlIIlllII && this.fuel > 0) {
            --this.fuel;
            this.brewTime = 400;
            this.ingredientID = llllllllllllIIIIlIlIlIlIlIIllIlI.getItem();
            this.markDirty();
        }
        if (!this.world.isRemote) {
            final boolean[] llllllllllllIIIIlIlIlIlIlIIllIII = this.createFilledSlotsArray();
            if (!Arrays.equals(llllllllllllIIIIlIlIlIlIlIIllIII, this.filledSlots)) {
                this.filledSlots = llllllllllllIIIIlIlIlIlIlIIllIII;
                IBlockState llllllllllllIIIIlIlIlIlIlIIlIlll = this.world.getBlockState(this.getPos());
                if (!(llllllllllllIIIIlIlIlIlIlIIlIlll.getBlock() instanceof BlockBrewingStand)) {
                    return;
                }
                for (int llllllllllllIIIIlIlIlIlIlIIlIllI = 0; llllllllllllIIIIlIlIlIlIlIIlIllI < BlockBrewingStand.HAS_BOTTLE.length; ++llllllllllllIIIIlIlIlIlIlIIlIllI) {
                    llllllllllllIIIIlIlIlIlIlIIlIlll = llllllllllllIIIIlIlIlIlIlIIlIlll.withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[llllllllllllIIIIlIlIlIlIlIIlIllI], llllllllllllIIIIlIlIlIlIlIIllIII[llllllllllllIIIIlIlIlIlIlIIlIllI]);
                }
                this.world.setBlockState(this.pos, llllllllllllIIIIlIlIlIlIlIIlIlll, 2);
            }
        }
    }
    
    @Override
    public int getFieldCount() {
        return 2;
    }
    
    @Override
    public void clear() {
        this.brewingItemStacks.clear();
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllIIIIlIlIlIlIIIlllIlI) {
        return this.world.getTileEntity(this.pos) == this && llllllllllllIIIIlIlIlIlIIIlllIlI.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIIIIlIlIlIlIIllIIIll) {
        super.readFromNBT(llllllllllllIIIIlIlIlIlIIllIIIll);
        this.brewingItemStacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b(llllllllllllIIIIlIlIlIlIIllIIIll, this.brewingItemStacks);
        this.brewTime = llllllllllllIIIIlIlIlIlIIllIIIll.getShort("BrewTime");
        if (llllllllllllIIIIlIlIlIlIIllIIIll.hasKey("CustomName", 8)) {
            this.customName = llllllllllllIIIIlIlIlIlIIllIIIll.getString("CustomName");
        }
        this.fuel = llllllllllllIIIIlIlIlIlIIllIIIll.getByte("Fuel");
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIIIIlIlIlIlIIIllIllI) {
    }
    
    @Override
    public void setField(final int llllllllllllIIIIlIlIlIIlllllllll, final int llllllllllllIIIIlIlIlIIllllllllI) {
        switch (llllllllllllIIIIlIlIlIIlllllllll) {
            case 0: {
                this.brewTime = llllllllllllIIIIlIlIlIIllllllllI;
                break;
            }
            case 1: {
                this.fuel = llllllllllllIIIIlIlIlIIllllllllI;
                break;
            }
        }
    }
    
    static {
        SLOTS_FOR_UP = new int[] { 3 };
        SLOTS_FOR_DOWN = new int[] { 0, 1, 2, 3 };
        OUTPUT_SLOTS = new int[] { 0, 1, 2, 4 };
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllIIIIlIlIlIlIlIlIlIlI : this.brewingItemStacks) {
            if (!llllllllllllIIIIlIlIlIlIlIlIlIlI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllIIIIlIlIlIlIIlIIIIll, final ItemStack llllllllllllIIIIlIlIlIlIIlIIIIlI) {
        if (llllllllllllIIIIlIlIlIlIIlIIIIll >= 0 && llllllllllllIIIIlIlIlIlIIlIIIIll < this.brewingItemStacks.size()) {
            this.brewingItemStacks.set(llllllllllllIIIIlIlIlIlIIlIIIIll, llllllllllllIIIIlIlIlIlIIlIIIIlI);
        }
    }
    
    @Override
    public boolean canExtractItem(final int llllllllllllIIIIlIlIlIlIIIIlIllI, final ItemStack llllllllllllIIIIlIlIlIlIIIIlIlIl, final EnumFacing llllllllllllIIIIlIlIlIlIIIIlIlII) {
        return llllllllllllIIIIlIlIlIlIIIIlIllI != 3 || llllllllllllIIIIlIlIlIlIIIIlIlIl.getItem() == Items.GLASS_BOTTLE;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIIIIlIlIlIlIIlIIllll, final int llllllllllllIIIIlIlIlIlIIlIlIIIl) {
        return ItemStackHelper.getAndSplit(this.brewingItemStacks, llllllllllllIIIIlIlIlIlIIlIIllll, llllllllllllIIIIlIlIlIlIIlIlIIIl);
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIIIIlIlIlIlIIIllIlII) {
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIIIIlIlIlIlIIlIlllll) {
        super.writeToNBT(llllllllllllIIIIlIlIlIlIIlIlllll);
        llllllllllllIIIIlIlIlIlIIlIlllll.setShort("BrewTime", (short)this.brewTime);
        ItemStackHelper.func_191282_a(llllllllllllIIIIlIlIlIlIIlIlllll, this.brewingItemStacks);
        if (this.hasCustomName()) {
            llllllllllllIIIIlIlIlIlIIlIlllll.setString("CustomName", this.customName);
        }
        llllllllllllIIIIlIlIlIlIIlIlllll.setByte("Fuel", (byte)this.fuel);
        return llllllllllllIIIIlIlIlIlIIlIlllll;
    }
    
    public static void registerFixesBrewingStand(final DataFixer llllllllllllIIIIlIlIlIlIIllIlIIl) {
        llllllllllllIIIIlIlIlIlIIllIlIIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityBrewingStand.class, new String[] { "Items" }));
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllIIIIlIlIlIlIIlIllIIl) {
        return (llllllllllllIIIIlIlIlIlIIlIllIIl >= 0 && llllllllllllIIIIlIlIlIlIIlIllIIl < this.brewingItemStacks.size()) ? this.brewingItemStacks.get(llllllllllllIIIIlIlIlIlIIlIllIIl) : ItemStack.field_190927_a;
    }
    
    @Override
    public boolean canInsertItem(final int llllllllllllIIIIlIlIlIlIIIIllIll, final ItemStack llllllllllllIIIIlIlIlIlIIIIllIlI, final EnumFacing llllllllllllIIIIlIlIlIlIIIIlllIl) {
        return this.isItemValidForSlot(llllllllllllIIIIlIlIlIlIIIIllIll, llllllllllllIIIIlIlIlIlIIIIllIlI);
    }
}
