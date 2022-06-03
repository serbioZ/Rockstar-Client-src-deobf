// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.enchantment.EnchantmentHelper;
import java.util.List;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatList;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

public class ContainerEnchantment extends Container
{
    public /* synthetic */ int xpSeed;
    public /* synthetic */ int[] worldClue;
    private final /* synthetic */ BlockPos position;
    public /* synthetic */ int[] enchantLevels;
    private final /* synthetic */ World worldPointer;
    public /* synthetic */ int[] enchantClue;
    private final /* synthetic */ Random rand;
    public /* synthetic */ IInventory tableInventory;
    
    @Override
    public void addListener(final IContainerListener lllllllllllllIllIIlIlIIlIllllIll) {
        super.addListener(lllllllllllllIllIIlIlIIlIllllIll);
        this.broadcastData(lllllllllllllIllIIlIlIIlIllllIll);
    }
    
    @Override
    public boolean enchantItem(final EntityPlayer lllllllllllllIllIIlIlIIlIIlllIII, final int lllllllllllllIllIIlIlIIlIlIIIIIl) {
        ItemStack lllllllllllllIllIIlIlIIlIlIIIIII = this.tableInventory.getStackInSlot(0);
        final ItemStack lllllllllllllIllIIlIlIIlIIllllll = this.tableInventory.getStackInSlot(1);
        final int lllllllllllllIllIIlIlIIlIIlllllI = lllllllllllllIllIIlIlIIlIlIIIIIl + 1;
        if ((lllllllllllllIllIIlIlIIlIIllllll.func_190926_b() || lllllllllllllIllIIlIlIIlIIllllll.func_190916_E() < lllllllllllllIllIIlIlIIlIIlllllI) && !lllllllllllllIllIIlIlIIlIIlllIII.capabilities.isCreativeMode) {
            return false;
        }
        if (this.enchantLevels[lllllllllllllIllIIlIlIIlIlIIIIIl] > 0 && !lllllllllllllIllIIlIlIIlIlIIIIII.func_190926_b() && ((lllllllllllllIllIIlIlIIlIIlllIII.experienceLevel >= lllllllllllllIllIIlIlIIlIIlllllI && lllllllllllllIllIIlIlIIlIIlllIII.experienceLevel >= this.enchantLevels[lllllllllllllIllIIlIlIIlIlIIIIIl]) || lllllllllllllIllIIlIlIIlIIlllIII.capabilities.isCreativeMode)) {
            if (!this.worldPointer.isRemote) {
                final List<EnchantmentData> lllllllllllllIllIIlIlIIlIIllllIl = this.getEnchantmentList(lllllllllllllIllIIlIlIIlIlIIIIII, lllllllllllllIllIIlIlIIlIlIIIIIl, this.enchantLevels[lllllllllllllIllIIlIlIIlIlIIIIIl]);
                if (!lllllllllllllIllIIlIlIIlIIllllIl.isEmpty()) {
                    lllllllllllllIllIIlIlIIlIIlllIII.func_192024_a(lllllllllllllIllIIlIlIIlIlIIIIII, lllllllllllllIllIIlIlIIlIIlllllI);
                    final boolean lllllllllllllIllIIlIlIIlIIllllII = lllllllllllllIllIIlIlIIlIlIIIIII.getItem() == Items.BOOK;
                    if (lllllllllllllIllIIlIlIIlIIllllII) {
                        lllllllllllllIllIIlIlIIlIlIIIIII = new ItemStack(Items.ENCHANTED_BOOK);
                        this.tableInventory.setInventorySlotContents(0, lllllllllllllIllIIlIlIIlIlIIIIII);
                    }
                    for (int lllllllllllllIllIIlIlIIlIIlllIll = 0; lllllllllllllIllIIlIlIIlIIlllIll < lllllllllllllIllIIlIlIIlIIllllIl.size(); ++lllllllllllllIllIIlIlIIlIIlllIll) {
                        final EnchantmentData lllllllllllllIllIIlIlIIlIIlllIlI = lllllllllllllIllIIlIlIIlIIllllIl.get(lllllllllllllIllIIlIlIIlIIlllIll);
                        if (lllllllllllllIllIIlIlIIlIIllllII) {
                            ItemEnchantedBook.addEnchantment(lllllllllllllIllIIlIlIIlIlIIIIII, lllllllllllllIllIIlIlIIlIIlllIlI);
                        }
                        else {
                            lllllllllllllIllIIlIlIIlIlIIIIII.addEnchantment(lllllllllllllIllIIlIlIIlIIlllIlI.enchantmentobj, lllllllllllllIllIIlIlIIlIIlllIlI.enchantmentLevel);
                        }
                    }
                    if (!lllllllllllllIllIIlIlIIlIIlllIII.capabilities.isCreativeMode) {
                        lllllllllllllIllIIlIlIIlIIllllll.func_190918_g(lllllllllllllIllIIlIlIIlIIlllllI);
                        if (lllllllllllllIllIIlIlIIlIIllllll.func_190926_b()) {
                            this.tableInventory.setInventorySlotContents(1, ItemStack.field_190927_a);
                        }
                    }
                    lllllllllllllIllIIlIlIIlIIlllIII.addStat(StatList.ITEM_ENCHANTED);
                    if (lllllllllllllIllIIlIlIIlIIlllIII instanceof EntityPlayerMP) {
                        CriteriaTriggers.field_192129_i.func_192190_a((EntityPlayerMP)lllllllllllllIllIIlIlIIlIIlllIII, lllllllllllllIllIIlIlIIlIlIIIIII, lllllllllllllIllIIlIlIIlIIlllllI);
                    }
                    this.tableInventory.markDirty();
                    this.xpSeed = lllllllllllllIllIIlIlIIlIIlllIII.getXPSeed();
                    this.onCraftMatrixChanged(this.tableInventory);
                    this.worldPointer.playSound(null, this.position, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0f, this.worldPointer.rand.nextFloat() * 0.1f + 0.9f);
                }
            }
            return true;
        }
        return false;
    }
    
    private List<EnchantmentData> getEnchantmentList(final ItemStack lllllllllllllIllIIlIlIIlIIlIIlII, final int lllllllllllllIllIIlIlIIlIIlIIIll, final int lllllllllllllIllIIlIlIIlIIlIIlll) {
        this.rand.setSeed(this.xpSeed + lllllllllllllIllIIlIlIIlIIlIIIll);
        final List<EnchantmentData> lllllllllllllIllIIlIlIIlIIlIIllI = EnchantmentHelper.buildEnchantmentList(this.rand, lllllllllllllIllIIlIlIIlIIlIIlII, lllllllllllllIllIIlIlIIlIIlIIlll, false);
        if (lllllllllllllIllIIlIlIIlIIlIIlII.getItem() == Items.BOOK && lllllllllllllIllIIlIlIIlIIlIIllI.size() > 1) {
            lllllllllllllIllIIlIlIIlIIlIIllI.remove(this.rand.nextInt(lllllllllllllIllIIlIlIIlIIlIIllI.size()));
        }
        return lllllllllllllIllIIlIlIIlIIlIIllI;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllIllIIlIlIIlIIIlIlIl) {
        super.onContainerClosed(lllllllllllllIllIIlIlIIlIIIlIlIl);
        if (!this.worldPointer.isRemote) {
            this.func_193327_a(lllllllllllllIllIIlIlIIlIIIlIlIl, lllllllllllllIllIIlIlIIlIIIlIlIl.world, this.tableInventory);
        }
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllllIllIIlIlIIlIllIlIII, final int lllllllllllllIllIIlIlIIlIllIIlll) {
        if (lllllllllllllIllIIlIlIIlIllIlIII >= 0 && lllllllllllllIllIIlIlIIlIllIlIII <= 2) {
            this.enchantLevels[lllllllllllllIllIIlIlIIlIllIlIII] = lllllllllllllIllIIlIlIIlIllIIlll;
        }
        else if (lllllllllllllIllIIlIlIIlIllIlIII == 3) {
            this.xpSeed = lllllllllllllIllIIlIlIIlIllIIlll;
        }
        else if (lllllllllllllIllIIlIlIIlIllIlIII >= 4 && lllllllllllllIllIIlIlIIlIllIlIII <= 6) {
            this.enchantClue[lllllllllllllIllIIlIlIIlIllIlIII - 4] = lllllllllllllIllIIlIlIIlIllIIlll;
        }
        else if (lllllllllllllIllIIlIlIIlIllIlIII >= 7 && lllllllllllllIllIIlIlIIlIllIlIII <= 9) {
            this.worldClue[lllllllllllllIllIIlIlIIlIllIlIII - 7] = lllllllllllllIllIIlIlIIlIllIIlll;
        }
        else {
            super.updateProgressBar(lllllllllllllIllIIlIlIIlIllIlIII, lllllllllllllIllIIlIlIIlIllIIlll);
        }
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllIllIIlIlIIllIIlIIII, final World lllllllllllllIllIIlIlIIllIIIlIII, final BlockPos lllllllllllllIllIIlIlIIllIIIIlll) {
        this.tableInventory = new InventoryBasic("Enchant", true, 2) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerEnchantment.this.onCraftMatrixChanged(this);
            }
            
            @Override
            public int getInventoryStackLimit() {
                return 64;
            }
        };
        this.rand = new Random();
        this.enchantLevels = new int[3];
        this.enchantClue = new int[] { -1, -1, -1 };
        this.worldClue = new int[] { -1, -1, -1 };
        this.worldPointer = lllllllllllllIllIIlIlIIllIIIlIII;
        this.position = lllllllllllllIllIIlIlIIllIIIIlll;
        this.xpSeed = lllllllllllllIllIIlIlIIllIIlIIII.player.getXPSeed();
        this.addSlotToContainer(new Slot(this.tableInventory, 0, 15, 47) {
            @Override
            public int getSlotStackLimit() {
                return 1;
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllllIIIllIIIIlIIlIIII) {
                return true;
            }
        });
        this.addSlotToContainer(new Slot(this.tableInventory, 1, 35, 47) {
            @Override
            public boolean isItemValid(final ItemStack llllllllllIllllIIlIlIIIIIIllIlIl) {
                return llllllllllIllllIIlIlIIIIIIllIlIl.getItem() == Items.DYE && EnumDyeColor.byDyeDamage(llllllllllIllllIIlIlIIIIIIllIlIl.getMetadata()) == EnumDyeColor.BLUE;
            }
        });
        for (int lllllllllllllIllIIlIlIIllIIIllIl = 0; lllllllllllllIllIIlIlIIllIIIllIl < 3; ++lllllllllllllIllIIlIlIIllIIIllIl) {
            for (int lllllllllllllIllIIlIlIIllIIIllII = 0; lllllllllllllIllIIlIlIIllIIIllII < 9; ++lllllllllllllIllIIlIlIIllIIIllII) {
                this.addSlotToContainer(new Slot(lllllllllllllIllIIlIlIIllIIlIIII, lllllllllllllIllIIlIlIIllIIIllII + lllllllllllllIllIIlIlIIllIIIllIl * 9 + 9, 8 + lllllllllllllIllIIlIlIIllIIIllII * 18, 84 + lllllllllllllIllIIlIlIIllIIIllIl * 18));
            }
        }
        for (int lllllllllllllIllIIlIlIIllIIIlIll = 0; lllllllllllllIllIIlIlIIllIIIlIll < 9; ++lllllllllllllIllIIlIlIIllIIIlIll) {
            this.addSlotToContainer(new Slot(lllllllllllllIllIIlIlIIllIIlIIII, lllllllllllllIllIIlIlIIllIIIlIll, 8 + lllllllllllllIllIIlIlIIllIIIlIll * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIllIIlIlIIlIIIIIIIl, final int lllllllllllllIllIIlIlIIlIIIIIIII) {
        ItemStack lllllllllllllIllIIlIlIIlIIIIIlIl = ItemStack.field_190927_a;
        final Slot lllllllllllllIllIIlIlIIlIIIIIlII = this.inventorySlots.get(lllllllllllllIllIIlIlIIlIIIIIIII);
        if (lllllllllllllIllIIlIlIIlIIIIIlII != null && lllllllllllllIllIIlIlIIlIIIIIlII.getHasStack()) {
            final ItemStack lllllllllllllIllIIlIlIIlIIIIIIll = lllllllllllllIllIIlIlIIlIIIIIlII.getStack();
            lllllllllllllIllIIlIlIIlIIIIIlIl = lllllllllllllIllIIlIlIIlIIIIIIll.copy();
            if (lllllllllllllIllIIlIlIIlIIIIIIII == 0) {
                if (!this.mergeItemStack(lllllllllllllIllIIlIlIIlIIIIIIll, 2, 38, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllllIllIIlIlIIlIIIIIIII == 1) {
                if (!this.mergeItemStack(lllllllllllllIllIIlIlIIlIIIIIIll, 2, 38, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (lllllllllllllIllIIlIlIIlIIIIIIll.getItem() == Items.DYE && EnumDyeColor.byDyeDamage(lllllllllllllIllIIlIlIIlIIIIIIll.getMetadata()) == EnumDyeColor.BLUE) {
                if (!this.mergeItemStack(lllllllllllllIllIIlIlIIlIIIIIIll, 1, 2, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else {
                if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(lllllllllllllIllIIlIlIIlIIIIIIll)) {
                    return ItemStack.field_190927_a;
                }
                if (lllllllllllllIllIIlIlIIlIIIIIIll.hasTagCompound() && lllllllllllllIllIIlIlIIlIIIIIIll.func_190916_E() == 1) {
                    this.inventorySlots.get(0).putStack(lllllllllllllIllIIlIlIIlIIIIIIll.copy());
                    lllllllllllllIllIIlIlIIlIIIIIIll.func_190920_e(0);
                }
                else if (!lllllllllllllIllIIlIlIIlIIIIIIll.func_190926_b()) {
                    this.inventorySlots.get(0).putStack(new ItemStack(lllllllllllllIllIIlIlIIlIIIIIIll.getItem(), 1, lllllllllllllIllIIlIlIIlIIIIIIll.getMetadata()));
                    lllllllllllllIllIIlIlIIlIIIIIIll.func_190918_g(1);
                }
            }
            if (lllllllllllllIllIIlIlIIlIIIIIIll.func_190926_b()) {
                lllllllllllllIllIIlIlIIlIIIIIlII.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllIllIIlIlIIlIIIIIlII.onSlotChanged();
            }
            if (lllllllllllllIllIIlIlIIlIIIIIIll.func_190916_E() == lllllllllllllIllIIlIlIIlIIIIIlIl.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllllIllIIlIlIIlIIIIIlII.func_190901_a(lllllllllllllIllIIlIlIIlIIIIIIIl, lllllllllllllIllIIlIlIIlIIIIIIll);
        }
        return lllllllllllllIllIIlIlIIlIIIIIlIl;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllllIllIIlIlIIlIlIlIIll) {
        if (lllllllllllllIllIIlIlIIlIlIlIIll == this.tableInventory) {
            final ItemStack lllllllllllllIllIIlIlIIlIlIlllIl = lllllllllllllIllIIlIlIIlIlIlIIll.getStackInSlot(0);
            if (!lllllllllllllIllIIlIlIIlIlIlllIl.func_190926_b() && lllllllllllllIllIIlIlIIlIlIlllIl.isItemEnchantable()) {
                if (!this.worldPointer.isRemote) {
                    int lllllllllllllIllIIlIlIIlIlIlllII = 0;
                    for (int lllllllllllllIllIIlIlIIlIlIllIll = -1; lllllllllllllIllIIlIlIIlIlIllIll <= 1; ++lllllllllllllIllIIlIlIIlIlIllIll) {
                        for (int lllllllllllllIllIIlIlIIlIlIllIlI = -1; lllllllllllllIllIIlIlIIlIlIllIlI <= 1; ++lllllllllllllIllIIlIlIIlIlIllIlI) {
                            if ((lllllllllllllIllIIlIlIIlIlIllIll != 0 || lllllllllllllIllIIlIlIIlIlIllIlI != 0) && this.worldPointer.isAirBlock(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI, 0, lllllllllllllIllIIlIlIIlIlIllIll)) && this.worldPointer.isAirBlock(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI, 1, lllllllllllllIllIIlIlIIlIlIllIll))) {
                                if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI * 2, 0, lllllllllllllIllIIlIlIIlIlIllIll * 2)).getBlock() == Blocks.BOOKSHELF) {
                                    ++lllllllllllllIllIIlIlIIlIlIlllII;
                                }
                                if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI * 2, 1, lllllllllllllIllIIlIlIIlIlIllIll * 2)).getBlock() == Blocks.BOOKSHELF) {
                                    ++lllllllllllllIllIIlIlIIlIlIlllII;
                                }
                                if (lllllllllllllIllIIlIlIIlIlIllIlI != 0 && lllllllllllllIllIIlIlIIlIlIllIll != 0) {
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI * 2, 0, lllllllllllllIllIIlIlIIlIlIllIll)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIlIlIIlIlIlllII;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI * 2, 1, lllllllllllllIllIIlIlIIlIlIllIll)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIlIlIIlIlIlllII;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI, 0, lllllllllllllIllIIlIlIIlIlIllIll * 2)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIlIlIIlIlIlllII;
                                    }
                                    if (this.worldPointer.getBlockState(this.position.add(lllllllllllllIllIIlIlIIlIlIllIlI, 1, lllllllllllllIllIIlIlIIlIlIllIll * 2)).getBlock() == Blocks.BOOKSHELF) {
                                        ++lllllllllllllIllIIlIlIIlIlIlllII;
                                    }
                                }
                            }
                        }
                    }
                    this.rand.setSeed(this.xpSeed);
                    for (int lllllllllllllIllIIlIlIIlIlIllIIl = 0; lllllllllllllIllIIlIlIIlIlIllIIl < 3; ++lllllllllllllIllIIlIlIIlIlIllIIl) {
                        this.enchantLevels[lllllllllllllIllIIlIlIIlIlIllIIl] = EnchantmentHelper.calcItemStackEnchantability(this.rand, lllllllllllllIllIIlIlIIlIlIllIIl, lllllllllllllIllIIlIlIIlIlIlllII, lllllllllllllIllIIlIlIIlIlIlllIl);
                        this.enchantClue[lllllllllllllIllIIlIlIIlIlIllIIl] = -1;
                        this.worldClue[lllllllllllllIllIIlIlIIlIlIllIIl] = -1;
                        if (this.enchantLevels[lllllllllllllIllIIlIlIIlIlIllIIl] < lllllllllllllIllIIlIlIIlIlIllIIl + 1) {
                            this.enchantLevels[lllllllllllllIllIIlIlIIlIlIllIIl] = 0;
                        }
                    }
                    for (int lllllllllllllIllIIlIlIIlIlIllIII = 0; lllllllllllllIllIIlIlIIlIlIllIII < 3; ++lllllllllllllIllIIlIlIIlIlIllIII) {
                        if (this.enchantLevels[lllllllllllllIllIIlIlIIlIlIllIII] > 0) {
                            final List<EnchantmentData> lllllllllllllIllIIlIlIIlIlIlIlll = this.getEnchantmentList(lllllllllllllIllIIlIlIIlIlIlllIl, lllllllllllllIllIIlIlIIlIlIllIII, this.enchantLevels[lllllllllllllIllIIlIlIIlIlIllIII]);
                            if (lllllllllllllIllIIlIlIIlIlIlIlll != null && !lllllllllllllIllIIlIlIIlIlIlIlll.isEmpty()) {
                                final EnchantmentData lllllllllllllIllIIlIlIIlIlIlIllI = lllllllllllllIllIIlIlIIlIlIlIlll.get(this.rand.nextInt(lllllllllllllIllIIlIlIIlIlIlIlll.size()));
                                this.enchantClue[lllllllllllllIllIIlIlIIlIlIllIII] = Enchantment.getEnchantmentID(lllllllllllllIllIIlIlIIlIlIlIllI.enchantmentobj);
                                this.worldClue[lllllllllllllIllIIlIlIIlIlIllIII] = lllllllllllllIllIIlIlIIlIlIlIllI.enchantmentLevel;
                            }
                        }
                    }
                    this.detectAndSendChanges();
                }
            }
            else {
                for (int lllllllllllllIllIIlIlIIlIlIlIlIl = 0; lllllllllllllIllIIlIlIIlIlIlIlIl < 3; ++lllllllllllllIllIIlIlIIlIlIlIlIl) {
                    this.enchantLevels[lllllllllllllIllIIlIlIIlIlIlIlIl] = 0;
                    this.enchantClue[lllllllllllllIllIIlIlIIlIlIlIlIl] = -1;
                    this.worldClue[lllllllllllllIllIIlIlIIlIlIlIlIl] = -1;
                }
            }
        }
    }
    
    public int getLapisAmount() {
        final ItemStack lllllllllllllIllIIlIlIIlIIIlllIl = this.tableInventory.getStackInSlot(1);
        return lllllllllllllIllIIlIlIIlIIIlllIl.func_190926_b() ? 0 : lllllllllllllIllIIlIlIIlIIIlllIl.func_190916_E();
    }
    
    protected void broadcastData(final IContainerListener lllllllllllllIllIIlIlIIlIlllllll) {
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 0, this.enchantLevels[0]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 1, this.enchantLevels[1]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 2, this.enchantLevels[2]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 3, this.xpSeed & 0xFFFFFFF0);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 4, this.enchantClue[0]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 5, this.enchantClue[1]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 6, this.enchantClue[2]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 7, this.worldClue[0]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 8, this.worldClue[1]);
        lllllllllllllIllIIlIlIIlIlllllll.sendProgressBarUpdate(this, 9, this.worldClue[2]);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllIllIIlIlIIlIIIlIIIl) {
        return this.worldPointer.getBlockState(this.position).getBlock() == Blocks.ENCHANTING_TABLE && lllllllllllllIllIIlIlIIlIIIlIIIl.getDistanceSq(this.position.getX() + 0.5, this.position.getY() + 0.5, this.position.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllllIllIIlIlIIlIlllIlII = 0; lllllllllllllIllIIlIlIIlIlllIlII < this.listeners.size(); ++lllllllllllllIllIIlIlIIlIlllIlII) {
            final IContainerListener lllllllllllllIllIIlIlIIlIlllIIll = this.listeners.get(lllllllllllllIllIIlIlIIlIlllIlII);
            this.broadcastData(lllllllllllllIllIIlIlIIlIlllIIll);
        }
    }
    
    public ContainerEnchantment(final InventoryPlayer lllllllllllllIllIIlIlIIllIIllIIl, final World lllllllllllllIllIIlIlIIllIIllIII) {
        this(lllllllllllllIllIIlIlIIllIIllIIl, lllllllllllllIllIIlIlIIllIIllIII, BlockPos.ORIGIN);
    }
}
