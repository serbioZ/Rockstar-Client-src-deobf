// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.block.BlockFurnace;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.SlotFurnaceFuel;
import java.util.List;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.ITickable;

public class TileEntityFurnace extends TileEntityLockable implements ITickable, ISidedInventory
{
    private /* synthetic */ int cookTime;
    private static final /* synthetic */ int[] SLOTS_SIDES;
    private static final /* synthetic */ int[] SLOTS_TOP;
    private /* synthetic */ int totalCookTime;
    private /* synthetic */ int currentItemBurnTime;
    private static final /* synthetic */ int[] SLOTS_BOTTOM;
    private /* synthetic */ String furnaceCustomName;
    private /* synthetic */ NonNullList<ItemStack> furnaceItemStacks;
    private /* synthetic */ int furnaceBurnTime;
    
    public static int getItemBurnTime(final ItemStack llllllllllllIllllIIIIlIllIIlIlII) {
        if (llllllllllllIllllIIIIlIllIIlIlII.func_190926_b()) {
            return 0;
        }
        final Item llllllllllllIllllIIIIlIllIIlIlIl = llllllllllllIllllIIIIlIllIIlIlII.getItem();
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
            return 150;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.WOOL)) {
            return 100;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.CARPET)) {
            return 67;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.LADDER)) {
            return 300;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
            return 100;
        }
        if (Block.getBlockFromItem(llllllllllllIllllIIIIlIllIIlIlIl).getDefaultState().getMaterial() == Material.WOOD) {
            return 300;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
            return 16000;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl instanceof ItemTool && "WOOD".equals(((ItemTool)llllllllllllIllllIIIIlIllIIlIlIl).getToolMaterialName())) {
            return 200;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl instanceof ItemSword && "WOOD".equals(((ItemSword)llllllllllllIllllIIIIlIllIIlIlIl).getToolMaterialName())) {
            return 200;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl instanceof ItemHoe && "WOOD".equals(((ItemHoe)llllllllllllIllllIIIIlIllIIlIlIl).getMaterialName())) {
            return 200;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.STICK) {
            return 100;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.BOW || llllllllllllIllllIIIIlIllIIlIlIl == Items.FISHING_ROD) {
            return 300;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.SIGN) {
            return 200;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.COAL) {
            return 1600;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.LAVA_BUCKET) {
            return 20000;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Item.getItemFromBlock(Blocks.SAPLING) || llllllllllllIllllIIIIlIllIIlIlIl == Items.BOWL) {
            return 100;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl == Items.BLAZE_ROD) {
            return 2400;
        }
        if (llllllllllllIllllIIIIlIllIIlIlIl instanceof ItemDoor && llllllllllllIllllIIIIlIllIIlIlIl != Items.IRON_DOOR) {
            return 200;
        }
        return (llllllllllllIllllIIIIlIllIIlIlIl instanceof ItemBoat) ? 400 : 0;
    }
    
    @Override
    public boolean canInsertItem(final int llllllllllllIllllIIIIlIlIlllIIIl, final ItemStack llllllllllllIllllIIIIlIlIlllIIII, final EnumFacing llllllllllllIllllIIIIlIlIllIllll) {
        return this.isItemValidForSlot(llllllllllllIllllIIIIlIlIlllIIIl, llllllllllllIllllIIIIlIlIlllIIII);
    }
    
    @Override
    public int getField(final int llllllllllllIllllIIIIlIlIlIlIIIl) {
        switch (llllllllllllIllllIIIIlIlIlIlIIIl) {
            case 0: {
                return this.furnaceBurnTime;
            }
            case 1: {
                return this.currentItemBurnTime;
            }
            case 2: {
                return this.cookTime;
            }
            case 3: {
                return this.totalCookTime;
            }
            default: {
                return 0;
            }
        }
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            final ItemStack llllllllllllIllllIIIIlIllIIlllll = this.furnaceItemStacks.get(0);
            final ItemStack llllllllllllIllllIIIIlIllIIllllI = FurnaceRecipes.instance().getSmeltingResult(llllllllllllIllllIIIIlIllIIlllll);
            final ItemStack llllllllllllIllllIIIIlIllIIlllIl = this.furnaceItemStacks.get(2);
            if (llllllllllllIllllIIIIlIllIIlllIl.func_190926_b()) {
                this.furnaceItemStacks.set(2, llllllllllllIllllIIIIlIllIIllllI.copy());
            }
            else if (llllllllllllIllllIIIIlIllIIlllIl.getItem() == llllllllllllIllllIIIIlIllIIllllI.getItem()) {
                llllllllllllIllllIIIIlIllIIlllIl.func_190917_f(1);
            }
            if (llllllllllllIllllIIIIlIllIIlllll.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && llllllllllllIllllIIIIlIllIIlllll.getMetadata() == 1 && !this.furnaceItemStacks.get(1).func_190926_b() && this.furnaceItemStacks.get(1).getItem() == Items.BUCKET) {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }
            llllllllllllIllllIIIIlIllIIlllll.func_190918_g(1);
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIllllIIIIlIlllllllIl, final int llllllllllllIllllIIIIlIlllllllII) {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, llllllllllllIllllIIIIlIlllllllIl, llllllllllllIllllIIIIlIlllllllII);
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllIllllIIIIllIIIIIlIll : this.furnaceItemStacks) {
            if (!llllllllllllIllllIIIIllIIIIIlIll.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:furnace";
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllIllllIIIIlIllIIIIIII, final ItemStack llllllllllllIllllIIIIlIlIllllIll) {
        if (llllllllllllIllllIIIIlIllIIIIIII == 2) {
            return false;
        }
        if (llllllllllllIllllIIIIlIllIIIIIII != 1) {
            return true;
        }
        final ItemStack llllllllllllIllllIIIIlIlIllllllI = this.furnaceItemStacks.get(1);
        return isItemFuel(llllllllllllIllllIIIIlIlIllllIll) || (SlotFurnaceFuel.isBucket(llllllllllllIllllIIIIlIlIllllIll) && llllllllllllIllllIIIIlIlIllllllI.getItem() != Items.BUCKET);
    }
    
    @Override
    public int getFieldCount() {
        return 4;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIllllIIIIlIlIlIlIlll, final EntityPlayer llllllllllllIllllIIIIlIlIlIllIIl) {
        return new ContainerFurnace(llllllllllllIllllIIIIlIlIlIlIlll, this);
    }
    
    public void setCustomInventoryName(final String llllllllllllIllllIIIIlIlllIllIlI) {
        this.furnaceCustomName = llllllllllllIllllIIIIlIlllIllIlI;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIllllIIIIlIlllIIlIll) {
        super.writeToNBT(llllllllllllIllllIIIIlIlllIIlIll);
        llllllllllllIllllIIIIlIlllIIlIll.setShort("BurnTime", (short)this.furnaceBurnTime);
        llllllllllllIllllIIIIlIlllIIlIll.setShort("CookTime", (short)this.cookTime);
        llllllllllllIllllIIIIlIlllIIlIll.setShort("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.func_191282_a(llllllllllllIllllIIIIlIlllIIlIll, this.furnaceItemStacks);
        if (this.hasCustomName()) {
            llllllllllllIllllIIIIlIlllIIlIll.setString("CustomName", this.furnaceCustomName);
        }
        return llllllllllllIllllIIIIlIlllIIlIll;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllIllllIIIIlIllllIIlll, final ItemStack llllllllllllIllllIIIIlIllllIIllI) {
        final ItemStack llllllllllllIllllIIIIlIllllIlIlI = this.furnaceItemStacks.get(llllllllllllIllllIIIIlIllllIIlll);
        final boolean llllllllllllIllllIIIIlIllllIlIIl = !llllllllllllIllllIIIIlIllllIIllI.func_190926_b() && llllllllllllIllllIIIIlIllllIIllI.isItemEqual(llllllllllllIllllIIIIlIllllIlIlI) && ItemStack.areItemStackTagsEqual(llllllllllllIllllIIIIlIllllIIllI, llllllllllllIllllIIIIlIllllIlIlI);
        this.furnaceItemStacks.set(llllllllllllIllllIIIIlIllllIIlll, llllllllllllIllllIIIIlIllllIIllI);
        if (llllllllllllIllllIIIIlIllllIIllI.func_190916_E() > this.getInventoryStackLimit()) {
            llllllllllllIllllIIIIlIllllIIllI.func_190920_e(this.getInventoryStackLimit());
        }
        if (llllllllllllIllllIIIIlIllllIIlll == 0 && !llllllllllllIllllIIIIlIllllIlIIl) {
            this.totalCookTime = this.getCookTime(llllllllllllIllllIIIIlIllllIIllI);
            this.cookTime = 0;
            this.markDirty();
        }
    }
    
    @Override
    public void clear() {
        this.furnaceItemStacks.clear();
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllIllllIIIIlIlllllIIll) {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, llllllllllllIllllIIIIlIlllllIIll);
    }
    
    @Override
    public boolean canExtractItem(final int llllllllllllIllllIIIIlIlIllIIIlI, final ItemStack llllllllllllIllllIIIIlIlIllIIIIl, final EnumFacing llllllllllllIllllIIIIlIlIllIIlII) {
        if (llllllllllllIllllIIIIlIlIllIIlII == EnumFacing.DOWN && llllllllllllIllllIIIIlIlIllIIIlI == 1) {
            final Item llllllllllllIllllIIIIlIlIllIIIll = llllllllllllIllllIIIIlIlIllIIIIl.getItem();
            if (llllllllllllIllllIIIIlIlIllIIIll != Items.WATER_BUCKET && llllllllllllIllllIIIIlIlIllIIIll != Items.BUCKET) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isBurning(final IInventory llllllllllllIllllIIIIlIlllIIIIll) {
        return llllllllllllIllllIIIIlIlllIIIIll.getField(0) > 0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIllllIIIIlIllIIIIllI) {
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIllllIIIIlIlllIlIIIl) {
        super.readFromNBT(llllllllllllIllllIIIIlIlllIlIIIl);
        this.furnaceItemStacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b(llllllllllllIllllIIIIlIlllIlIIIl, this.furnaceItemStacks);
        this.furnaceBurnTime = llllllllllllIllllIIIIlIlllIlIIIl.getShort("BurnTime");
        this.cookTime = llllllllllllIllllIIIIlIlllIlIIIl.getShort("CookTime");
        this.totalCookTime = llllllllllllIllllIIIIlIlllIlIIIl.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));
        if (llllllllllllIllllIIIIlIlllIlIIIl.hasKey("CustomName", 8)) {
            this.furnaceCustomName = llllllllllllIllllIIIIlIlllIlIIIl.getString("CustomName");
        }
    }
    
    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.size();
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing llllllllllllIllllIIIIlIlIlllIllI) {
        if (llllllllllllIllllIIIIlIlIlllIllI == EnumFacing.DOWN) {
            return TileEntityFurnace.SLOTS_BOTTOM;
        }
        return (llllllllllllIllllIIIIlIlIlllIllI == EnumFacing.UP) ? TileEntityFurnace.SLOTS_TOP : TileEntityFurnace.SLOTS_SIDES;
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    public static void registerFixesFurnace(final DataFixer llllllllllllIllllIIIIlIlllIlIllI) {
        llllllllllllIllllIIIIlIlllIlIllI.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityFurnace.class, new String[] { "Items" }));
    }
    
    private boolean canSmelt() {
        if (this.furnaceItemStacks.get(0).func_190926_b()) {
            return false;
        }
        final ItemStack llllllllllllIllllIIIIlIllIlIlIIl = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));
        if (llllllllllllIllllIIIIlIllIlIlIIl.func_190926_b()) {
            return false;
        }
        final ItemStack llllllllllllIllllIIIIlIllIlIlIII = this.furnaceItemStacks.get(2);
        return llllllllllllIllllIIIIlIllIlIlIII.func_190926_b() || (llllllllllllIllllIIIIlIllIlIlIII.isItemEqual(llllllllllllIllllIIIIlIllIlIlIIl) && ((llllllllllllIllllIIIIlIllIlIlIII.func_190916_E() < this.getInventoryStackLimit() && llllllllllllIllllIIIIlIllIlIlIII.func_190916_E() < llllllllllllIllllIIIIlIllIlIlIII.getMaxStackSize()) || llllllllllllIllllIIIIlIllIlIlIII.func_190916_E() < llllllllllllIllllIIIIlIllIlIlIIl.getMaxStackSize()));
    }
    
    public static boolean isItemFuel(final ItemStack llllllllllllIllllIIIIlIllIIlIIII) {
        return getItemBurnTime(llllllllllllIllllIIIIlIllIIlIIII) > 0;
    }
    
    public int getCookTime(final ItemStack llllllllllllIllllIIIIlIllIlIlllI) {
        return 200;
    }
    
    @Override
    public void update() {
        final boolean llllllllllllIllllIIIIlIllIlllIlI = this.isBurning();
        boolean llllllllllllIllllIIIIlIllIlllIIl = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }
        if (!this.world.isRemote) {
            final ItemStack llllllllllllIllllIIIIlIllIlllIII = this.furnaceItemStacks.get(1);
            if (this.isBurning() || (!llllllllllllIllllIIIIlIllIlllIII.func_190926_b() && !this.furnaceItemStacks.get(0).func_190926_b())) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.furnaceBurnTime = getItemBurnTime(llllllllllllIllllIIIIlIllIlllIII);
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()) {
                        llllllllllllIllllIIIIlIllIlllIIl = true;
                        if (!llllllllllllIllllIIIIlIllIlllIII.func_190926_b()) {
                            final Item llllllllllllIllllIIIIlIllIllIlll = llllllllllllIllllIIIIlIllIlllIII.getItem();
                            llllllllllllIllllIIIIlIllIlllIII.func_190918_g(1);
                            if (llllllllllllIllllIIIIlIllIlllIII.func_190926_b()) {
                                final Item llllllllllllIllllIIIIlIllIllIllI = llllllllllllIllllIIIIlIllIllIlll.getContainerItem();
                                this.furnaceItemStacks.set(1, (llllllllllllIllllIIIIlIllIllIllI == null) ? ItemStack.field_190927_a : new ItemStack(llllllllllllIllllIIIIlIllIllIllI));
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;
                    if (this.cookTime == this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks.get(0));
                        this.smeltItem();
                        llllllllllllIllllIIIIlIllIlllIIl = true;
                    }
                }
                else {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (llllllllllllIllllIIIIlIllIlllIlI != this.isBurning()) {
                llllllllllllIllllIIIIlIllIlllIIl = true;
                BlockFurnace.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if (llllllllllllIllllIIIIlIllIlllIIl) {
            this.markDirty();
        }
    }
    
    public TileEntityFurnace() {
        this.furnaceItemStacks = NonNullList.func_191197_a(3, ItemStack.field_190927_a);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllIllllIIIIlIllIIIlIlI) {
        return this.world.getTileEntity(this.pos) == this && llllllllllllIllllIIIIlIllIIIlIlI.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    static {
        SLOTS_TOP = new int[1];
        SLOTS_BOTTOM = new int[] { 2, 1 };
        SLOTS_SIDES = new int[] { 1 };
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllIllllIIIIllIIIIIIlII) {
        return this.furnaceItemStacks.get(llllllllllllIllllIIIIllIIIIIIlII);
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIllllIIIIlIllIIIlIII) {
    }
    
    @Override
    public void setField(final int llllllllllllIllllIIIIlIlIlIIlIIl, final int llllllllllllIllllIIIIlIlIlIIlIll) {
        switch (llllllllllllIllllIIIIlIlIlIIlIIl) {
            case 0: {
                this.furnaceBurnTime = llllllllllllIllllIIIIlIlIlIIlIll;
                break;
            }
            case 1: {
                this.currentItemBurnTime = llllllllllllIllllIIIIlIlIlIIlIll;
                break;
            }
            case 2: {
                this.cookTime = llllllllllllIllllIIIIlIlIlIIlIll;
                break;
            }
            case 3: {
                this.totalCookTime = llllllllllllIllllIIIIlIlIlIIlIll;
                break;
            }
        }
    }
}
