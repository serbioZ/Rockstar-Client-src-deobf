// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.gui.GuiChat;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.client.gui.inventory.GuiInventory;
import ru.rockstar.api.event.event.EventPreMotion;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemBlock;
import ru.rockstar.api.utils.world.InventoryHelper;
import net.minecraft.item.ItemArmor;
import net.minecraft.enchantment.EnchantmentHelper;
import java.util.Objects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import java.util.Arrays;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import net.minecraft.block.Block;
import java.util.List;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class InventoryManager extends Feature
{
    public static /* synthetic */ BooleanSetting dropBlocks;
    public static /* synthetic */ int pickaxeSlot;
    public static /* synthetic */ int weaponSlot;
    public static /* synthetic */ BooleanSetting cleaner;
    public static /* synthetic */ int shovelSlot;
    public static /* synthetic */ BooleanSetting nomoveswap;
    private final /* synthetic */ TimerHelper timer;
    public static /* synthetic */ List<Block> invalidBlocks;
    public static /* synthetic */ int axeSlot;
    public static /* synthetic */ NumberSetting delay1;
    public static /* synthetic */ BooleanSetting openinv;
    
    private void getBestShovel() {
        for (int lllllllllllIIlllIIIlIllllllIIllI = 9; lllllllllllIIlllIIIlIllllllIIllI < 45; ++lllllllllllIIlllIIIlIllllllIIllI) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllIIllI).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIllllllIIlIl = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllIIllI).getStack();
                if (this.isBestShovel(lllllllllllIIlllIIIlIllllllIIlIl) && InventoryManager.shovelSlot != lllllllllllIIlllIIIlIllllllIIllI && !this.isBestWeapon(lllllllllllIIlllIIIlIllllllIIlIl)) {
                    if (!InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.shovelSlot).getHasStack()) {
                        this.swap(lllllllllllIIlllIIIlIllllllIIllI, InventoryManager.shovelSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                    else if (!this.isBestShovel(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.shovelSlot).getStack())) {
                        this.swap(lllllllllllIIlllIIIlIllllllIIllI, InventoryManager.shovelSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                }
            }
        }
    }
    
    public InventoryManager() {
        super("InventoryManager", "\u0427\u0438\u0441\u0442\u0438\u0442, \u0441\u043e\u0440\u0442\u0438\u0440\u0443\u0435\u0442 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c \u0437\u0430 \u0432\u0430\u0441", 0, Category.PLAYER);
        this.timer = new TimerHelper();
        InventoryManager.delay1 = new NumberSetting("Sort Delay", 1.0f, 0.0f, 10.0f, 0.1f, () -> true);
        InventoryManager.cleaner = new BooleanSetting("Cleaner", true, () -> true);
        InventoryManager.openinv = new BooleanSetting("Open Inv", true, () -> true);
        InventoryManager.nomoveswap = new BooleanSetting("No Moving Swap", false, () -> true);
        InventoryManager.dropBlocks = new BooleanSetting("Drop Blocks", false, () -> InventoryManager.cleaner.getBoolValue());
        this.addSettings(InventoryManager.delay1, InventoryManager.cleaner, InventoryManager.dropBlocks, InventoryManager.openinv, InventoryManager.nomoveswap);
    }
    
    public void swap(final int lllllllllllIIlllIIIllIIIIIlllllI, final int lllllllllllIIlllIIIllIIIIIllllIl) {
        InventoryManager.mc.playerController.windowClick(InventoryManager.mc.player.inventoryContainer.windowId, lllllllllllIIlllIIIllIIIIIlllllI, lllllllllllIIlllIIIllIIIIIllllIl, ClickType.SWAP, InventoryManager.mc.player);
    }
    
    public boolean isBestWeapon(final ItemStack lllllllllllIIlllIIIllIIIIIlIllIl) {
        final float lllllllllllIIlllIIIllIIIIIllIIIl = this.getDamage(lllllllllllIIlllIIIllIIIIIlIllIl);
        for (int lllllllllllIIlllIIIllIIIIIllIIII = 9; lllllllllllIIlllIIIllIIIIIllIIII < 45; ++lllllllllllIIlllIIIllIIIIIllIIII) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIIllIIII).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIllIIIIIlIllll = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIIllIIII).getStack();
                if (this.getDamage(lllllllllllIIlllIIIllIIIIIlIllll) > lllllllllllIIlllIIIllIIIIIllIIIl && lllllllllllIIlllIIIllIIIIIlIllll.getItem() instanceof ItemSword) {
                    return false;
                }
            }
        }
        return lllllllllllIIlllIIIllIIIIIlIllIl.getItem() instanceof ItemSword;
    }
    
    private boolean isBestPickaxe(final ItemStack lllllllllllIIlllIIIlIlllllIIlIll) {
        final Item lllllllllllIIlllIIIlIlllllIlIIII = lllllllllllIIlllIIIlIlllllIIlIll.getItem();
        if (!(lllllllllllIIlllIIIlIlllllIlIIII instanceof ItemPickaxe)) {
            return false;
        }
        final float lllllllllllIIlllIIIlIlllllIIllll = this.getToolEffect(lllllllllllIIlllIIIlIlllllIIlIll);
        for (int lllllllllllIIlllIIIlIlllllIIlllI = 9; lllllllllllIIlllIIIlIlllllIIlllI < 45; ++lllllllllllIIlllIIIlIlllllIIlllI) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIlllllIIlllI).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIlllllIIllIl = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIlllllIIlllI).getStack();
                if (this.getToolEffect(lllllllllllIIlllIIIlIlllllIIllIl) > lllllllllllIIlllIIIlIlllllIIllll && lllllllllllIIlllIIIlIlllllIIllIl.getItem() instanceof ItemPickaxe) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static {
        InventoryManager.weaponSlot = 36;
        InventoryManager.pickaxeSlot = 37;
        InventoryManager.axeSlot = 38;
        InventoryManager.shovelSlot = 39;
        InventoryManager.invalidBlocks = Arrays.asList(Blocks.ENCHANTING_TABLE, Blocks.FURNACE, Blocks.CARPET, Blocks.CRAFTING_TABLE, Blocks.TRAPPED_CHEST, Blocks.CHEST, Blocks.DISPENSER, Blocks.AIR, Blocks.WATER, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.FLOWING_LAVA, Blocks.SAND, Blocks.SNOW_LAYER, Blocks.TORCH, Blocks.ANVIL, Blocks.JUKEBOX, Blocks.STONE_BUTTON, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.STONE_PRESSURE_PLATE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.WOODEN_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.STONE_SLAB, Blocks.WOODEN_SLAB, Blocks.STONE_SLAB2, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM, Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.ANVIL, Blocks.GLASS_PANE, Blocks.STAINED_GLASS_PANE, Blocks.IRON_BARS, Blocks.CACTUS, Blocks.LADDER, Blocks.WEB);
    }
    
    public void getBestWeapon(final int lllllllllllIIlllIIIllIIIIIlIIIII) {
        for (int lllllllllllIIlllIIIllIIIIIlIIIll = 9; lllllllllllIIlllIIIllIIIIIlIIIll < 45; ++lllllllllllIIlllIIIllIIIIIlIIIll) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIIlIIIll).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIllIIIIIlIIIlI = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIIlIIIll).getStack();
                if (this.isBestWeapon(lllllllllllIIlllIIIllIIIIIlIIIlI) && this.getDamage(lllllllllllIIlllIIIllIIIIIlIIIlI) > 0.0f && lllllllllllIIlllIIIllIIIIIlIIIlI.getItem() instanceof ItemSword) {
                    this.swap(lllllllllllIIlllIIIllIIIIIlIIIll, lllllllllllIIlllIIIllIIIIIlIIIII - 36);
                    this.timer.reset();
                    break;
                }
            }
        }
    }
    
    private float getToolEffect(final ItemStack lllllllllllIIlllIIIlIllllIIlIlIl) {
        final Item lllllllllllIIlllIIIlIllllIIllIll = lllllllllllIIlllIIIlIllllIIlIlIl.getItem();
        if (!(lllllllllllIIlllIIIlIllllIIllIll instanceof ItemTool)) {
            return 0.0f;
        }
        final String lllllllllllIIlllIIIlIllllIIllIlI = lllllllllllIIlllIIIlIllllIIllIll.getUnlocalizedName();
        final ItemTool lllllllllllIIlllIIIlIllllIIllIIl = (ItemTool)lllllllllllIIlllIIIlIllllIIllIll;
        float lllllllllllIIlllIIIlIllllIIlIllI = 0.0f;
        if (lllllllllllIIlllIIIlIllllIIllIll instanceof ItemPickaxe) {
            float lllllllllllIIlllIIIlIllllIIllIII = lllllllllllIIlllIIIlIllllIIllIIl.getStrVsBlock(lllllllllllIIlllIIIlIllllIIlIlIl, Blocks.STONE.getDefaultState());
            if (lllllllllllIIlllIIIlIllllIIllIlI.toLowerCase().contains("gold")) {
                lllllllllllIIlllIIIlIllllIIllIII -= 5.0f;
            }
        }
        else if (lllllllllllIIlllIIIlIllllIIllIll instanceof ItemSpade) {
            float lllllllllllIIlllIIIlIllllIIlIlll = lllllllllllIIlllIIIlIllllIIllIIl.getStrVsBlock(lllllllllllIIlllIIIlIllllIIlIlIl, Blocks.DIRT.getDefaultState());
            if (lllllllllllIIlllIIIlIllllIIllIlI.toLowerCase().contains("gold")) {
                lllllllllllIIlllIIIlIllllIIlIlll -= 5.0f;
            }
        }
        else {
            if (!(lllllllllllIIlllIIIlIllllIIllIll instanceof ItemAxe)) {
                return 1.0f;
            }
            lllllllllllIIlllIIIlIllllIIlIllI = lllllllllllIIlllIIIlIllllIIllIIl.getStrVsBlock(lllllllllllIIlllIIIlIllllIIlIlIl, Blocks.LOG.getDefaultState());
            if (lllllllllllIIlllIIIlIllllIIllIlI.toLowerCase().contains("gold")) {
                lllllllllllIIlllIIIlIllllIIlIllI -= 5.0f;
            }
        }
        lllllllllllIIlllIIIlIllllIIlIllI += (float)(EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(32)), lllllllllllIIlllIIIlIllllIIlIlIl) * 0.0075);
        lllllllllllIIlllIIIlIllllIIlIllI += (float)(EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(34)), lllllllllllIIlllIIIlIllllIIlIlIl) / 100.0);
        return lllllllllllIIlllIIIlIllllIIlIllI;
    }
    
    public void drop(final int lllllllllllIIlllIIIllIIIIIlllIIl) {
        InventoryManager.mc.playerController.windowClick(InventoryManager.mc.player.inventoryContainer.windowId, lllllllllllIIlllIIIllIIIIIlllIIl, 1, ClickType.THROW, InventoryManager.mc.player);
    }
    
    private void getBestPickaxe() {
        for (int lllllllllllIIlllIIIlIllllllIllll = 9; lllllllllllIIlllIIIlIllllllIllll < 45; ++lllllllllllIIlllIIIlIllllllIllll) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllIllll).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIllllllIlllI = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllIllll).getStack();
                if (this.isBestPickaxe(lllllllllllIIlllIIIlIllllllIlllI) && InventoryManager.pickaxeSlot != lllllllllllIIlllIIIlIllllllIllll && !this.isBestWeapon(lllllllllllIIlllIIIlIllllllIlllI)) {
                    if (!InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.pickaxeSlot).getHasStack()) {
                        this.swap(lllllllllllIIlllIIIlIllllllIllll, InventoryManager.pickaxeSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                    else if (!this.isBestPickaxe(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.pickaxeSlot).getStack())) {
                        this.swap(lllllllllllIIlllIIIlIllllllIllll, InventoryManager.pickaxeSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                }
            }
        }
    }
    
    public boolean shouldDrop(final ItemStack lllllllllllIIlllIIIllIIIIIIIIlII, final int lllllllllllIIlllIIIllIIIIIIIIIll) {
        if (lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("/")) {
            return false;
        }
        if (lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("\u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b")) {
            return false;
        }
        if (lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("§k||")) {
            return false;
        }
        if (lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("kit")) {
            return false;
        }
        if (lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("\u043b\u043e\u0431\u0431\u0438")) {
            return false;
        }
        if (lllllllllllIIlllIIIllIIIIIIIIIll != InventoryManager.weaponSlot || !this.isBestWeapon(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.weaponSlot).getStack())) {
            if (lllllllllllIIlllIIIllIIIIIIIIIll != InventoryManager.pickaxeSlot || !this.isBestPickaxe(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.pickaxeSlot).getStack())) {
                if (lllllllllllIIlllIIIllIIIIIIIIIll != InventoryManager.axeSlot || !this.isBestAxe(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.axeSlot).getStack())) {
                    if (lllllllllllIIlllIIIllIIIIIIIIIll != InventoryManager.shovelSlot || !this.isBestShovel(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.shovelSlot).getStack())) {
                        if (lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemArmor) {
                            for (int lllllllllllIIlllIIIllIIIIIIIIlll = 1; lllllllllllIIlllIIIllIIIIIIIIlll < 5; ++lllllllllllIIlllIIIllIIIIIIIIlll) {
                                if (InventoryManager.mc.player.inventoryContainer.getSlot(4 + lllllllllllIIlllIIIllIIIIIIIIlll).getHasStack()) {
                                    final ItemStack lllllllllllIIlllIIIllIIIIIIIIllI = InventoryManager.mc.player.inventoryContainer.getSlot(4 + lllllllllllIIlllIIIllIIIIIIIIlll).getStack();
                                    if (InventoryHelper.isBestArmor(lllllllllllIIlllIIIllIIIIIIIIllI, lllllllllllIIlllIIIllIIIIIIIIlll)) {
                                        continue;
                                    }
                                }
                                if (InventoryHelper.isBestArmor(lllllllllllIIlllIIIllIIIIIIIIlII, lllllllllllIIlllIIIllIIIIIIIIlll)) {
                                    return false;
                                }
                            }
                        }
                        return (InventoryManager.dropBlocks.getBoolValue() && lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemBlock) || (lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemPotion && this.isBadPotion(lllllllllllIIlllIIIllIIIIIIIIlII)) || ((!(lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemFood) || lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemAppleGold) && (lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemHoe || lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemTool || lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemSword || lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemArmor || (!(lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemBow) && !lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("arrow") && (lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("tnt") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("stick") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("bed") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("egg") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("string") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("cake") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("mushroom") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("flint") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("dyePowder") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("feather") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("bucket") || (lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("chest") && !lllllllllllIIlllIIIllIIIIIIIIlII.getDisplayName().toLowerCase().contains("collect")) || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("snow") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("fish") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("enchant") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("exp") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("shears") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("anvil") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("torch") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("seeds") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("leather") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("reeds") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("skull") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("wool") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("record") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("snowball") || lllllllllllIIlllIIIllIIIIIIIIlII.getItem() instanceof ItemGlassBottle || lllllllllllIIlllIIIllIIIIIIIIlII.getItem().getUnlocalizedName().contains("piston")))));
                    }
                }
            }
        }
        return false;
    }
    
    private int getBlockCount() {
        int lllllllllllIIlllIIIlIllllllllIll = 0;
        for (int lllllllllllIIlllIIIlIllllllllIlI = 0; lllllllllllIIlllIIIlIllllllllIlI < 45; ++lllllllllllIIlllIIIlIllllllllIlI) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllllIlI).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIllllllllIIl = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllllllIlI).getStack();
                final Item lllllllllllIIlllIIIlIllllllllIII = lllllllllllIIlllIIIlIllllllllIIl.getItem();
                if (lllllllllllIIlllIIIlIllllllllIIl.getItem() instanceof ItemBlock && !InventoryManager.invalidBlocks.contains(((ItemBlock)lllllllllllIIlllIIIlIllllllllIII).getBlock())) {
                    lllllllllllIIlllIIIlIllllllllIll += lllllllllllIIlllIIIlIllllllllIIl.stackSize;
                }
            }
        }
        return lllllllllllIIlllIIIlIllllllllIll;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion lllllllllllIIlllIIIllIIIIlIIlIll) {
        final long lllllllllllIIlllIIIllIIIIlIIlIlI = (long)InventoryManager.delay1.getNumberValue() * 50L;
        if (!(InventoryManager.mc.currentScreen instanceof GuiInventory) && InventoryManager.openinv.getBoolValue()) {
            return;
        }
        if (MovementHelper.isMoving() && InventoryManager.nomoveswap.getBoolValue()) {
            return;
        }
        if (InventoryManager.mc.currentScreen == null || InventoryManager.mc.currentScreen instanceof GuiInventory || InventoryManager.mc.currentScreen instanceof GuiChat) {
            if (this.timer.hasReached((double)lllllllllllIIlllIIIllIIIIlIIlIlI) && InventoryManager.weaponSlot >= 36) {
                if (!InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.weaponSlot).getHasStack()) {
                    this.getBestWeapon(InventoryManager.weaponSlot);
                }
                else if (!this.isBestWeapon(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.weaponSlot).getStack())) {
                    this.getBestWeapon(InventoryManager.weaponSlot);
                }
            }
            if (this.timer.hasReached((double)lllllllllllIIlllIIIllIIIIlIIlIlI) && InventoryManager.axeSlot >= 36) {
                this.getBestAxe();
            }
            if (this.timer.hasReached((double)lllllllllllIIlllIIIllIIIIlIIlIlI) && InventoryManager.cleaner.getBoolValue()) {
                for (int lllllllllllIIlllIIIllIIIIlIIlIIl = 9; lllllllllllIIlllIIIllIIIIlIIlIIl < 45; ++lllllllllllIIlllIIIllIIIIlIIlIIl) {
                    if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIlIIlIIl).getHasStack()) {
                        final ItemStack lllllllllllIIlllIIIllIIIIlIIlIII = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIllIIIIlIIlIIl).getStack();
                        if (this.shouldDrop(lllllllllllIIlllIIIllIIIIlIIlIII, lllllllllllIIlllIIIllIIIIlIIlIIl)) {
                            this.drop(lllllllllllIIlllIIIllIIIIlIIlIIl);
                            if (lllllllllllIIlllIIIllIIIIlIIlIlI == 0L) {
                                InventoryManager.mc.player.closeScreen();
                            }
                            this.timer.reset();
                            if (lllllllllllIIlllIIIllIIIIlIIlIlI > 0L) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void getBestAxe() {
        for (int lllllllllllIIlllIIIlIlllllIlllIl = 9; lllllllllllIIlllIIIlIlllllIlllIl < 45; ++lllllllllllIIlllIIIlIlllllIlllIl) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIlllllIlllIl).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIlllllIlllII = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIlllllIlllIl).getStack();
                if (this.isBestAxe(lllllllllllIIlllIIIlIlllllIlllII) && InventoryManager.axeSlot != lllllllllllIIlllIIIlIlllllIlllIl && !this.isBestWeapon(lllllllllllIIlllIIIlIlllllIlllII)) {
                    if (!InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.axeSlot).getHasStack()) {
                        this.swap(lllllllllllIIlllIIIlIlllllIlllIl, InventoryManager.axeSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                    else if (!this.isBestAxe(InventoryManager.mc.player.inventoryContainer.getSlot(InventoryManager.axeSlot).getStack())) {
                        this.swap(lllllllllllIIlllIIIlIlllllIlllIl, InventoryManager.axeSlot - 36);
                        this.timer.reset();
                        if (InventoryManager.delay1.getNumberValue() > 0.0f) {
                            return;
                        }
                    }
                }
            }
        }
    }
    
    private boolean isBadPotion(final ItemStack lllllllllllIIlllIIIlIllllIIIllII) {
        if (lllllllllllIIlllIIIlIllllIIIllII != null && lllllllllllIIlllIIIlIllllIIIllII.getItem() instanceof ItemPotion) {
            for (final PotionEffect lllllllllllIIlllIIIlIllllIIIlIll : PotionUtils.getEffectsFromStack(lllllllllllIIlllIIIlIllllIIIllII)) {
                if (lllllllllllIIlllIIIlIllllIIIlIll.getPotion() == Potion.getPotionById(19) || lllllllllllIIlllIIIlIllllIIIlIll.getPotion() == Potion.getPotionById(7) || lllllllllllIIlllIIIlIllllIIIlIll.getPotion() == Potion.getPotionById(2) || lllllllllllIIlllIIIlIllllIIIlIll.getPotion() == Potion.getPotionById(18)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private float getDamage(final ItemStack lllllllllllIIlllIIIllIIIIIIllIII) {
        float lllllllllllIIlllIIIllIIIIIIlIlll = 0.0f;
        final Item lllllllllllIIlllIIIllIIIIIIlIllI = lllllllllllIIlllIIIllIIIIIIllIII.getItem();
        if (lllllllllllIIlllIIIllIIIIIIlIllI instanceof ItemTool) {
            final ItemTool lllllllllllIIlllIIIllIIIIIIlIlIl = (ItemTool)lllllllllllIIlllIIIllIIIIIIlIllI;
            lllllllllllIIlllIIIllIIIIIIlIlll += lllllllllllIIlllIIIllIIIIIIlIlIl.getDamageVsEntity();
        }
        if (lllllllllllIIlllIIIllIIIIIIlIllI instanceof ItemSword) {
            final ItemSword lllllllllllIIlllIIIllIIIIIIlIlII = (ItemSword)lllllllllllIIlllIIIllIIIIIIlIllI;
            lllllllllllIIlllIIIllIIIIIIlIlll += lllllllllllIIlllIIIllIIIIIIlIlII.getDamageVsEntity();
        }
        lllllllllllIIlllIIIllIIIIIIlIlll += EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(16)), lllllllllllIIlllIIIllIIIIIIllIII) * 1.25f + EnchantmentHelper.getEnchantmentLevel(Objects.requireNonNull(Enchantment.getEnchantmentByID(20)), lllllllllllIIlllIIIllIIIIIIllIII) * 0.01f;
        return lllllllllllIIlllIIIllIIIIIIlIlll;
    }
    
    private boolean isBestAxe(final ItemStack lllllllllllIIlllIIIlIllllIlIIlll) {
        final Item lllllllllllIIlllIIIlIllllIlIllII = lllllllllllIIlllIIIlIllllIlIIlll.getItem();
        if (!(lllllllllllIIlllIIIlIllllIlIllII instanceof ItemAxe)) {
            return false;
        }
        final float lllllllllllIIlllIIIlIllllIlIlIll = this.getToolEffect(lllllllllllIIlllIIIlIllllIlIIlll);
        for (int lllllllllllIIlllIIIlIllllIlIlIlI = 9; lllllllllllIIlllIIIlIllllIlIlIlI < 45; ++lllllllllllIIlllIIIlIllllIlIlIlI) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllIlIlIlI).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIllllIlIlIIl = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllIlIlIlI).getStack();
                if (this.getToolEffect(lllllllllllIIlllIIIlIllllIlIlIIl) > lllllllllllIIlllIIIlIllllIlIlIll && lllllllllllIIlllIIIlIllllIlIlIIl.getItem() instanceof ItemAxe && !this.isBestWeapon(lllllllllllIIlllIIIlIllllIlIIlll)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isBestShovel(final ItemStack lllllllllllIIlllIIIlIllllIlllIIl) {
        final Item lllllllllllIIlllIIIlIllllIlllllI = lllllllllllIIlllIIIlIllllIlllIIl.getItem();
        if (!(lllllllllllIIlllIIIlIllllIlllllI instanceof ItemSpade)) {
            return false;
        }
        final float lllllllllllIIlllIIIlIllllIllllIl = this.getToolEffect(lllllllllllIIlllIIIlIllllIlllIIl);
        for (int lllllllllllIIlllIIIlIllllIllllII = 9; lllllllllllIIlllIIIlIllllIllllII < 45; ++lllllllllllIIlllIIIlIllllIllllII) {
            if (InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllIllllII).getHasStack()) {
                final ItemStack lllllllllllIIlllIIIlIllllIlllIll = InventoryManager.mc.player.inventoryContainer.getSlot(lllllllllllIIlllIIIlIllllIllllII).getStack();
                if (this.getToolEffect(lllllllllllIIlllIIIlIllllIlllIll) > lllllllllllIIlllIIIlIllllIllllIl && lllllllllllIIlllIIIlIllllIlllIll.getItem() instanceof ItemSpade) {
                    return false;
                }
            }
        }
        return true;
    }
}
