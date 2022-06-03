// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import org.apache.logging.log4j.LogManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.player.InventoryPlayer;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.init.Items;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerRepair extends Container
{
    private final /* synthetic */ World theWorld;
    private final /* synthetic */ IInventory inputSlots;
    private final /* synthetic */ BlockPos selfPosition;
    private /* synthetic */ String repairedItemName;
    private /* synthetic */ int materialCost;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
    private final /* synthetic */ EntityPlayer thePlayer;
    public /* synthetic */ int maximumCost;
    private final /* synthetic */ IInventory outputSlot;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllIlIlIIlIlllllIlllIIll, final int lllllllllllIlIlIIlIlllllIlllIIlI) {
        ItemStack lllllllllllIlIlIIlIlllllIlllIlll = ItemStack.field_190927_a;
        final Slot lllllllllllIlIlIIlIlllllIlllIllI = this.inventorySlots.get(lllllllllllIlIlIIlIlllllIlllIIlI);
        if (lllllllllllIlIlIIlIlllllIlllIllI != null && lllllllllllIlIlIIlIlllllIlllIllI.getHasStack()) {
            final ItemStack lllllllllllIlIlIIlIlllllIlllIlIl = lllllllllllIlIlIIlIlllllIlllIllI.getStack();
            lllllllllllIlIlIIlIlllllIlllIlll = lllllllllllIlIlIIlIlllllIlllIlIl.copy();
            if (lllllllllllIlIlIIlIlllllIlllIIlI == 2) {
                if (!this.mergeItemStack(lllllllllllIlIlIIlIlllllIlllIlIl, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllIlIlIIlIlllllIlllIllI.onSlotChange(lllllllllllIlIlIIlIlllllIlllIlIl, lllllllllllIlIlIIlIlllllIlllIlll);
            }
            else if (lllllllllllIlIlIIlIlllllIlllIIlI != 0 && lllllllllllIlIlIIlIlllllIlllIIlI != 1) {
                if (lllllllllllIlIlIIlIlllllIlllIIlI >= 3 && lllllllllllIlIlIIlIlllllIlllIIlI < 39 && !this.mergeItemStack(lllllllllllIlIlIIlIlllllIlllIlIl, 0, 2, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllIlIlIIlIlllllIlllIlIl, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllIlIlIIlIlllllIlllIlIl.func_190926_b()) {
                lllllllllllIlIlIIlIlllllIlllIllI.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllIlIlIIlIlllllIlllIllI.onSlotChanged();
            }
            if (lllllllllllIlIlIIlIlllllIlllIlIl.func_190916_E() == lllllllllllIlIlIIlIlllllIlllIlll.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllIlIlIIlIlllllIlllIllI.func_190901_a(lllllllllllIlIlIIlIlllllIlllIIll, lllllllllllIlIlIIlIlllllIlllIlIl);
        }
        return lllllllllllIlIlIIlIlllllIlllIlll;
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllIlIlIIlIllllllIIIIIll) {
        return this.theWorld.getBlockState(this.selfPosition).getBlock() == Blocks.ANVIL && lllllllllllIlIlIIlIllllllIIIIIll.getDistanceSq(this.selfPosition.getX() + 0.5, this.selfPosition.getY() + 0.5, this.selfPosition.getZ() + 0.5) <= 64.0;
    }
    
    public void updateRepairOutput() {
        final ItemStack lllllllllllIlIlIIlIlllllllIIlIII = this.inputSlots.getStackInSlot(0);
        this.maximumCost = 1;
        int lllllllllllIlIlIIlIlllllllIIIlll = 0;
        int lllllllllllIlIlIIlIlllllllIIIllI = 0;
        int lllllllllllIlIlIIlIlllllllIIIlIl = 0;
        if (lllllllllllIlIlIIlIlllllllIIlIII.func_190926_b()) {
            this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
            this.maximumCost = 0;
        }
        else {
            ItemStack lllllllllllIlIlIIlIlllllllIIIlII = lllllllllllIlIlIIlIlllllllIIlIII.copy();
            final ItemStack lllllllllllIlIlIIlIlllllllIIIIll = this.inputSlots.getStackInSlot(1);
            final Map<Enchantment, Integer> lllllllllllIlIlIIlIlllllllIIIIlI = EnchantmentHelper.getEnchantments(lllllllllllIlIlIIlIlllllllIIIlII);
            lllllllllllIlIlIIlIlllllllIIIllI = lllllllllllIlIlIIlIlllllllIIIllI + lllllllllllIlIlIIlIlllllllIIlIII.getRepairCost() + (lllllllllllIlIlIIlIlllllllIIIIll.func_190926_b() ? 0 : lllllllllllIlIlIIlIlllllllIIIIll.getRepairCost());
            this.materialCost = 0;
            if (!lllllllllllIlIlIIlIlllllllIIIIll.func_190926_b()) {
                final boolean lllllllllllIlIlIIlIlllllllIIIIIl = lllllllllllIlIlIIlIlllllllIIIIll.getItem() == Items.ENCHANTED_BOOK && !ItemEnchantedBook.getEnchantments(lllllllllllIlIlIIlIlllllllIIIIll).hasNoTags();
                if (lllllllllllIlIlIIlIlllllllIIIlII.isItemStackDamageable() && lllllllllllIlIlIIlIlllllllIIIlII.getItem().getIsRepairable(lllllllllllIlIlIIlIlllllllIIlIII, lllllllllllIlIlIIlIlllllllIIIIll)) {
                    int lllllllllllIlIlIIlIlllllllIIIIII = Math.min(lllllllllllIlIlIIlIlllllllIIIlII.getItemDamage(), lllllllllllIlIlIIlIlllllllIIIlII.getMaxDamage() / 4);
                    if (lllllllllllIlIlIIlIlllllllIIIIII <= 0) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                    int lllllllllllIlIlIIlIllllllIllllll;
                    for (lllllllllllIlIlIIlIllllllIllllll = 0; lllllllllllIlIlIIlIlllllllIIIIII > 0 && lllllllllllIlIlIIlIllllllIllllll < lllllllllllIlIlIIlIlllllllIIIIll.func_190916_E(); lllllllllllIlIlIIlIlllllllIIIIII = Math.min(lllllllllllIlIlIIlIlllllllIIIlII.getItemDamage(), lllllllllllIlIlIIlIlllllllIIIlII.getMaxDamage() / 4), ++lllllllllllIlIlIIlIllllllIllllll) {
                        final int lllllllllllIlIlIIlIllllllIlllllI = lllllllllllIlIlIIlIlllllllIIIlII.getItemDamage() - lllllllllllIlIlIIlIlllllllIIIIII;
                        lllllllllllIlIlIIlIlllllllIIIlII.setItemDamage(lllllllllllIlIlIIlIllllllIlllllI);
                        ++lllllllllllIlIlIIlIlllllllIIIlll;
                    }
                    this.materialCost = lllllllllllIlIlIIlIllllllIllllll;
                }
                else {
                    if (!lllllllllllIlIlIIlIlllllllIIIIIl && (lllllllllllIlIlIIlIlllllllIIIlII.getItem() != lllllllllllIlIlIIlIlllllllIIIIll.getItem() || !lllllllllllIlIlIIlIlllllllIIIlII.isItemStackDamageable())) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                    if (lllllllllllIlIlIIlIlllllllIIIlII.isItemStackDamageable() && !lllllllllllIlIlIIlIlllllllIIIIIl) {
                        final int lllllllllllIlIlIIlIllllllIllllIl = lllllllllllIlIlIIlIlllllllIIlIII.getMaxDamage() - lllllllllllIlIlIIlIlllllllIIlIII.getItemDamage();
                        final int lllllllllllIlIlIIlIllllllIllllII = lllllllllllIlIlIIlIlllllllIIIIll.getMaxDamage() - lllllllllllIlIlIIlIlllllllIIIIll.getItemDamage();
                        final int lllllllllllIlIlIIlIllllllIlllIll = lllllllllllIlIlIIlIllllllIllllII + lllllllllllIlIlIIlIlllllllIIIlII.getMaxDamage() * 12 / 100;
                        final int lllllllllllIlIlIIlIllllllIlllIlI = lllllllllllIlIlIIlIllllllIllllIl + lllllllllllIlIlIIlIllllllIlllIll;
                        int lllllllllllIlIlIIlIllllllIlllIIl = lllllllllllIlIlIIlIlllllllIIIlII.getMaxDamage() - lllllllllllIlIlIIlIllllllIlllIlI;
                        if (lllllllllllIlIlIIlIllllllIlllIIl < 0) {
                            lllllllllllIlIlIIlIllllllIlllIIl = 0;
                        }
                        if (lllllllllllIlIlIIlIllllllIlllIIl < lllllllllllIlIlIIlIlllllllIIIlII.getMetadata()) {
                            lllllllllllIlIlIIlIlllllllIIIlII.setItemDamage(lllllllllllIlIlIIlIllllllIlllIIl);
                            lllllllllllIlIlIIlIlllllllIIIlll += 2;
                        }
                    }
                    final Map<Enchantment, Integer> lllllllllllIlIlIIlIllllllIlllIII = EnchantmentHelper.getEnchantments(lllllllllllIlIlIIlIlllllllIIIIll);
                    boolean lllllllllllIlIlIIlIllllllIllIlll = false;
                    boolean lllllllllllIlIlIIlIllllllIllIllI = false;
                    for (final Enchantment lllllllllllIlIlIIlIllllllIllIlIl : lllllllllllIlIlIIlIllllllIlllIII.keySet()) {
                        if (lllllllllllIlIlIIlIllllllIllIlIl != null) {
                            final int lllllllllllIlIlIIlIllllllIllIlII = lllllllllllIlIlIIlIlllllllIIIIlI.containsKey(lllllllllllIlIlIIlIllllllIllIlIl) ? lllllllllllIlIlIIlIlllllllIIIIlI.get(lllllllllllIlIlIIlIllllllIllIlIl) : 0;
                            int lllllllllllIlIlIIlIllllllIllIIll = lllllllllllIlIlIIlIllllllIlllIII.get(lllllllllllIlIlIIlIllllllIllIlIl);
                            lllllllllllIlIlIIlIllllllIllIIll = ((lllllllllllIlIlIIlIllllllIllIlII == lllllllllllIlIlIIlIllllllIllIIll) ? (lllllllllllIlIlIIlIllllllIllIIll + 1) : Math.max(lllllllllllIlIlIIlIllllllIllIIll, lllllllllllIlIlIIlIllllllIllIlII));
                            boolean lllllllllllIlIlIIlIllllllIllIIlI = lllllllllllIlIlIIlIllllllIllIlIl.canApply(lllllllllllIlIlIIlIlllllllIIlIII);
                            if (this.thePlayer.capabilities.isCreativeMode || lllllllllllIlIlIIlIlllllllIIlIII.getItem() == Items.ENCHANTED_BOOK) {
                                lllllllllllIlIlIIlIllllllIllIIlI = true;
                            }
                            for (final Enchantment lllllllllllIlIlIIlIllllllIllIIIl : lllllllllllIlIlIIlIlllllllIIIIlI.keySet()) {
                                if (lllllllllllIlIlIIlIllllllIllIIIl != lllllllllllIlIlIIlIllllllIllIlIl && !lllllllllllIlIlIIlIllllllIllIlIl.func_191560_c(lllllllllllIlIlIIlIllllllIllIIIl)) {
                                    lllllllllllIlIlIIlIllllllIllIIlI = false;
                                    ++lllllllllllIlIlIIlIlllllllIIIlll;
                                }
                            }
                            if (!lllllllllllIlIlIIlIllllllIllIIlI) {
                                lllllllllllIlIlIIlIllllllIllIllI = true;
                            }
                            else {
                                lllllllllllIlIlIIlIllllllIllIlll = true;
                                if (lllllllllllIlIlIIlIllllllIllIIll > lllllllllllIlIlIIlIllllllIllIlIl.getMaxLevel()) {
                                    lllllllllllIlIlIIlIllllllIllIIll = lllllllllllIlIlIIlIllllllIllIlIl.getMaxLevel();
                                }
                                lllllllllllIlIlIIlIlllllllIIIIlI.put(lllllllllllIlIlIIlIllllllIllIlIl, lllllllllllIlIlIIlIllllllIllIIll);
                                int lllllllllllIlIlIIlIllllllIllIIII = 0;
                                switch ($SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity()[lllllllllllIlIlIIlIllllllIllIlIl.getRarity().ordinal()]) {
                                    case 1: {
                                        lllllllllllIlIlIIlIllllllIllIIII = 1;
                                        break;
                                    }
                                    case 2: {
                                        lllllllllllIlIlIIlIllllllIllIIII = 2;
                                        break;
                                    }
                                    case 3: {
                                        lllllllllllIlIlIIlIllllllIllIIII = 4;
                                        break;
                                    }
                                    case 4: {
                                        lllllllllllIlIlIIlIllllllIllIIII = 8;
                                        break;
                                    }
                                }
                                if (lllllllllllIlIlIIlIlllllllIIIIIl) {
                                    lllllllllllIlIlIIlIllllllIllIIII = Math.max(1, lllllllllllIlIlIIlIllllllIllIIII / 2);
                                }
                                lllllllllllIlIlIIlIlllllllIIIlll += lllllllllllIlIlIIlIllllllIllIIII * lllllllllllIlIlIIlIllllllIllIIll;
                                if (lllllllllllIlIlIIlIlllllllIIlIII.func_190916_E() <= 1) {
                                    continue;
                                }
                                lllllllllllIlIlIIlIlllllllIIIlll = 40;
                            }
                        }
                    }
                    if (lllllllllllIlIlIIlIllllllIllIllI && !lllllllllllIlIlIIlIllllllIllIlll) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                }
            }
            if (StringUtils.isBlank((CharSequence)this.repairedItemName)) {
                if (lllllllllllIlIlIIlIlllllllIIlIII.hasDisplayName()) {
                    lllllllllllIlIlIIlIlllllllIIIlIl = 1;
                    lllllllllllIlIlIIlIlllllllIIIlll += lllllllllllIlIlIIlIlllllllIIIlIl;
                    lllllllllllIlIlIIlIlllllllIIIlII.clearCustomName();
                }
            }
            else if (!this.repairedItemName.equals(lllllllllllIlIlIIlIlllllllIIlIII.getDisplayName())) {
                lllllllllllIlIlIIlIlllllllIIIlIl = 1;
                lllllllllllIlIlIIlIlllllllIIIlll += lllllllllllIlIlIIlIlllllllIIIlIl;
                lllllllllllIlIlIIlIlllllllIIIlII.setStackDisplayName(this.repairedItemName);
            }
            this.maximumCost = lllllllllllIlIlIIlIlllllllIIIllI + lllllllllllIlIlIIlIlllllllIIIlll;
            if (lllllllllllIlIlIIlIlllllllIIIlll <= 0) {
                lllllllllllIlIlIIlIlllllllIIIlII = ItemStack.field_190927_a;
            }
            if (lllllllllllIlIlIIlIlllllllIIIlIl == lllllllllllIlIlIIlIlllllllIIIlll && lllllllllllIlIlIIlIlllllllIIIlIl > 0 && this.maximumCost >= 40) {
                this.maximumCost = 39;
            }
            if (this.maximumCost >= 40 && !this.thePlayer.capabilities.isCreativeMode) {
                lllllllllllIlIlIIlIlllllllIIIlII = ItemStack.field_190927_a;
            }
            if (!lllllllllllIlIlIIlIlllllllIIIlII.func_190926_b()) {
                int lllllllllllIlIlIIlIllllllIlIllll = lllllllllllIlIlIIlIlllllllIIIlII.getRepairCost();
                if (!lllllllllllIlIlIIlIlllllllIIIIll.func_190926_b() && lllllllllllIlIlIIlIllllllIlIllll < lllllllllllIlIlIIlIlllllllIIIIll.getRepairCost()) {
                    lllllllllllIlIlIIlIllllllIlIllll = lllllllllllIlIlIIlIlllllllIIIIll.getRepairCost();
                }
                if (lllllllllllIlIlIIlIlllllllIIIlIl != lllllllllllIlIlIIlIlllllllIIIlll || lllllllllllIlIlIIlIlllllllIIIlIl == 0) {
                    lllllllllllIlIlIIlIllllllIlIllll = lllllllllllIlIlIIlIllllllIlIllll * 2 + 1;
                }
                lllllllllllIlIlIIlIlllllllIIIlII.setRepairCost(lllllllllllIlIlIIlIllllllIlIllll);
                EnchantmentHelper.setEnchantments(lllllllllllIlIlIIlIlllllllIIIIlI, lllllllllllIlIlIIlIlllllllIIIlII);
            }
            this.outputSlot.setInventorySlotContents(0, lllllllllllIlIlIIlIlllllllIIIlII);
            this.detectAndSendChanges();
        }
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory lllllllllllIlIlIIlIlllllllIlllIl) {
        super.onCraftMatrixChanged(lllllllllllIlIlIIlIlllllllIlllIl);
        if (lllllllllllIlIlIIlIlllllllIlllIl == this.inputSlots) {
            this.updateRepairOutput();
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllIlIlIIlIllllllIIIIlll) {
        super.onContainerClosed(lllllllllllIlIlIIlIllllllIIIIlll);
        if (!this.theWorld.isRemote) {
            this.func_193327_a(lllllllllllIlIlIIlIllllllIIIIlll, this.theWorld, this.inputSlots);
        }
    }
    
    public ContainerRepair(final InventoryPlayer lllllllllllIlIlIIlIllllllllllIll, final World lllllllllllIlIlIIlIllllllllllIlI, final EntityPlayer lllllllllllIlIlIIlIlllllllllllIl) {
        this(lllllllllllIlIlIIlIllllllllllIll, lllllllllllIlIlIIlIllllllllllIlI, BlockPos.ORIGIN, lllllllllllIlIlIIlIlllllllllllIl);
    }
    
    public void updateItemName(final String lllllllllllIlIlIIlIlllllIllIlIlI) {
        this.repairedItemName = lllllllllllIlIlIIlIlllllIllIlIlI;
        if (this.getSlot(2).getHasStack()) {
            final ItemStack lllllllllllIlIlIIlIlllllIllIlIIl = this.getSlot(2).getStack();
            if (StringUtils.isBlank((CharSequence)lllllllllllIlIlIIlIlllllIllIlIlI)) {
                lllllllllllIlIlIIlIlllllIllIlIIl.clearCustomName();
            }
            else {
                lllllllllllIlIlIIlIlllllIllIlIIl.setStackDisplayName(this.repairedItemName);
            }
        }
        this.updateRepairOutput();
    }
    
    public ContainerRepair(final InventoryPlayer lllllllllllIlIlIIlIllllllllIlIII, final World lllllllllllIlIlIIlIllllllllIIlll, final BlockPos lllllllllllIlIlIIlIllllllllIlllI, final EntityPlayer lllllllllllIlIlIIlIllllllllIIlIl) {
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Repair", true, 2) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerRepair.this.onCraftMatrixChanged(this);
            }
        };
        this.selfPosition = lllllllllllIlIlIIlIllllllllIlllI;
        this.theWorld = lllllllllllIlIlIIlIllllllllIIlll;
        this.thePlayer = lllllllllllIlIlIIlIllllllllIIlIl;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {
            @Override
            public boolean isItemValid(final ItemStack lllllllllllIIlllIlllIIlllIIIIIII) {
                return false;
            }
            
            @Override
            public boolean canTakeStack(final EntityPlayer lllllllllllIIlllIlllIIllIllllIlI) {
                return (lllllllllllIIlllIlllIIllIllllIlI.capabilities.isCreativeMode || lllllllllllIIlllIlllIIllIllllIlI.experienceLevel >= ContainerRepair.this.maximumCost) && ContainerRepair.this.maximumCost > 0 && this.getHasStack();
            }
            
            @Override
            public ItemStack func_190901_a(final EntityPlayer lllllllllllIIlllIlllIIllIlllIIll, final ItemStack lllllllllllIIlllIlllIIllIllIllII) {
                if (!lllllllllllIIlllIlllIIllIlllIIll.capabilities.isCreativeMode) {
                    lllllllllllIIlllIlllIIllIlllIIll.addExperienceLevel(-ContainerRepair.this.maximumCost);
                }
                ContainerRepair.this.inputSlots.setInventorySlotContents(0, ItemStack.field_190927_a);
                if (ContainerRepair.this.materialCost > 0) {
                    final ItemStack lllllllllllIIlllIlllIIllIlllIIIl = ContainerRepair.this.inputSlots.getStackInSlot(1);
                    if (!lllllllllllIIlllIlllIIllIlllIIIl.func_190926_b() && lllllllllllIIlllIlllIIllIlllIIIl.func_190916_E() > ContainerRepair.this.materialCost) {
                        lllllllllllIIlllIlllIIllIlllIIIl.func_190918_g(ContainerRepair.this.materialCost);
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, lllllllllllIIlllIlllIIllIlllIIIl);
                    }
                    else {
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, ItemStack.field_190927_a);
                    }
                }
                else {
                    ContainerRepair.this.inputSlots.setInventorySlotContents(1, ItemStack.field_190927_a);
                }
                ContainerRepair.this.maximumCost = 0;
                final IBlockState lllllllllllIIlllIlllIIllIlllIIII = lllllllllllIlIlIIlIllllllllIIlll.getBlockState(lllllllllllIlIlIIlIllllllllIlllI);
                if (!lllllllllllIIlllIlllIIllIlllIIll.capabilities.isCreativeMode && !lllllllllllIlIlIIlIllllllllIIlll.isRemote && lllllllllllIIlllIlllIIllIlllIIII.getBlock() == Blocks.ANVIL && lllllllllllIIlllIlllIIllIlllIIll.getRNG().nextFloat() < 0.12f) {
                    int lllllllllllIIlllIlllIIllIllIllll = lllllllllllIIlllIlllIIllIlllIIII.getValue((IProperty<Integer>)BlockAnvil.DAMAGE);
                    if (++lllllllllllIIlllIlllIIllIllIllll > 2) {
                        lllllllllllIlIlIIlIllllllllIIlll.setBlockToAir(lllllllllllIlIlIIlIllllllllIlllI);
                        lllllllllllIlIlIIlIllllllllIIlll.playEvent(1029, lllllllllllIlIlIIlIllllllllIlllI, 0);
                    }
                    else {
                        lllllllllllIlIlIIlIllllllllIIlll.setBlockState(lllllllllllIlIlIIlIllllllllIlllI, lllllllllllIIlllIlllIIllIlllIIII.withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, lllllllllllIIlllIlllIIllIllIllll), 2);
                        lllllllllllIlIlIIlIllllllllIIlll.playEvent(1030, lllllllllllIlIlIIlIllllllllIlllI, 0);
                    }
                }
                else if (!lllllllllllIlIlIIlIllllllllIIlll.isRemote) {
                    lllllllllllIlIlIIlIllllllllIIlll.playEvent(1030, lllllllllllIlIlIIlIllllllllIlllI, 0);
                }
                return lllllllllllIIlllIlllIIllIllIllII;
            }
        });
        for (int lllllllllllIlIlIIlIllllllllIllII = 0; lllllllllllIlIlIIlIllllllllIllII < 3; ++lllllllllllIlIlIIlIllllllllIllII) {
            for (int lllllllllllIlIlIIlIllllllllIlIll = 0; lllllllllllIlIlIIlIllllllllIlIll < 9; ++lllllllllllIlIlIIlIllllllllIlIll) {
                this.addSlotToContainer(new Slot(lllllllllllIlIlIIlIllllllllIlIII, lllllllllllIlIlIIlIllllllllIlIll + lllllllllllIlIlIIlIllllllllIllII * 9 + 9, 8 + lllllllllllIlIlIIlIllllllllIlIll * 18, 84 + lllllllllllIlIlIIlIllllllllIllII * 18));
            }
        }
        for (int lllllllllllIlIlIIlIllllllllIlIlI = 0; lllllllllllIlIlIIlIllllllllIlIlI < 9; ++lllllllllllIlIlIIlIllllllllIlIlI) {
            this.addSlotToContainer(new Slot(lllllllllllIlIlIIlIllllllllIlIII, lllllllllllIlIlIIlIllllllllIlIlI, 8 + lllllllllllIlIlIIlIllllllllIlIlI * 18, 142));
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity() {
        final int[] $switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity = ContainerRepair.$SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
        if ($switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity != null) {
            return $switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
        }
        final int lllllllllllIlIlIIlIlllllIllIIIII = (Object)new int[Enchantment.Rarity.values().length];
        try {
            lllllllllllIlIlIIlIlllllIllIIIII[Enchantment.Rarity.COMMON.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIlIIlIlllllIllIIIII[Enchantment.Rarity.RARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIlIIlIlllllIllIIIII[Enchantment.Rarity.UNCOMMON.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIlIIlIlllllIllIIIII[Enchantment.Rarity.VERY_RARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ContainerRepair.$SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity = (int[])(Object)lllllllllllIlIlIIlIlllllIllIIIII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllIlIlIIlIllllllIIlIIIl, final int lllllllllllIlIlIIlIllllllIIlIIII) {
        if (lllllllllllIlIlIIlIllllllIIlIIIl == 0) {
            this.maximumCost = lllllllllllIlIlIIlIllllllIIlIIII;
        }
    }
    
    @Override
    public void addListener(final IContainerListener lllllllllllIlIlIIlIllllllIIllIII) {
        super.addListener(lllllllllllIlIlIIlIllllllIIllIII);
        lllllllllllIlIlIIlIllllllIIllIII.sendProgressBarUpdate(this, 0, this.maximumCost);
    }
}
