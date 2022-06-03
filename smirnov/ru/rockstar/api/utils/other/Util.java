// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.other;

import net.minecraft.world.World;
import net.minecraft.util.EnumHand;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPotion;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemArmor;
import net.minecraft.inventory.Container;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSoup;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.world.TimerHelper;

public class Util
{
    static /* synthetic */ TimerHelper timer;
    private static /* synthetic */ Minecraft mc;
    
    public static int findEmptyPotion() {
        for (int lllllllllllIlIIIllIllIIlIIlIlIII = 36; lllllllllllIlIIIllIllIIlIIlIlIII < 45; ++lllllllllllIlIIIllIllIIlIIlIlIII) {
            final ItemStack lllllllllllIlIIIllIllIIlIIlIIlll = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIIlIlIII).getStack();
            if (lllllllllllIlIIIllIllIIlIIlIIlll == null) {
                return lllllllllllIlIIIllIllIIlIIlIlIII;
            }
            if (lllllllllllIlIIIllIllIIlIIlIIlll.getItem() instanceof ItemGlassBottle) {
                return lllllllllllIlIIIllIllIIlIIlIlIII;
            }
        }
        return -1;
    }
    
    public static void drawHead2(final ResourceLocation lllllllllllIlIIIllIllIIlIlIlIlII, final int lllllllllllIlIIIllIllIIlIlIlIllI, final int lllllllllllIlIIIllIllIIlIlIlIlIl) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Util.mc.getTextureManager().bindTexture(lllllllllllIlIIIllIllIIlIlIlIlII);
        Gui.drawScaledCustomSizeModalRect(lllllllllllIlIIIllIllIIlIlIlIllI, lllllllllllIlIIIllIllIIlIlIlIlIl, 8.0f, 8.0f, 8, 8, 30, 30, 64.0f, 64.0f);
    }
    
    public static boolean doesNextSlotHaveSoup() {
        for (int lllllllllllIlIIIllIllIIIIlllllll = 0; lllllllllllIlIIIllIllIIIIlllllll < 9; ++lllllllllllIlIIIllIllIIIIlllllll) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlllllll) != null && Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlllllll).getItem() instanceof ItemSoup) {
                return true;
            }
        }
        return false;
    }
    
    public static int getBlockInHotbar(final Block lllllllllllIlIIIllIllIIIlllllIIl) {
        for (int lllllllllllIlIIIllIllIIIlllllIll = 0; lllllllllllIlIIIllIllIIIlllllIll < 9; ++lllllllllllIlIIIllIllIIIlllllIll) {
            final Item lllllllllllIlIIIllIllIIIlllllIlI = Minecraft.getMinecraft().player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIlllllIll).getItem();
            if (lllllllllllIlIIIllIllIIIlllllIlI instanceof ItemBlock && ((ItemBlock)lllllllllllIlIIIllIllIIIlllllIlI).getBlock().equals(lllllllllllIlIIIllIllIIIlllllIIl)) {
                return lllllllllllIlIIIllIllIIIlllllIll;
            }
        }
        return -1;
    }
    
    public static boolean isPotion(final ItemStack lllllllllllIlIIIllIllIIlIIIlIIII) {
        if (lllllllllllIlIIIllIllIIlIIIlIIII.getItem() instanceof ItemSplashPotion) {
            for (final PotionEffect lllllllllllIlIIIllIllIIlIIIlIIIl : PotionUtils.getEffectsFromStack(lllllllllllIlIIIllIllIIlIIIlIIII)) {
                final Potion potion = lllllllllllIlIIIllIllIIlIIIlIIIl.getPotion();
                lllllllllllIlIIIllIllIIlIIIlIIIl.getPotion();
                if (potion == Potion.getPotionById(5)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int getSlotWithPot() {
        for (int lllllllllllIlIIIllIllIIIIlllllII = 0; lllllllllllIlIIIllIllIIIIlllllII < 9; ++lllllllllllIlIIIllIllIIIIlllllII) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlllllII) != null && Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlllllII).getItem() == Items.SPLASH_POTION) {
                return lllllllllllIlIIIllIllIIIIlllllII;
            }
        }
        return 0;
    }
    
    public static int findHotbarPotion() {
        for (int lllllllllllIlIIIllIllIIlIIlIlllI = 0; lllllllllllIlIIIllIllIIlIIlIlllI < 9; ++lllllllllllIlIIIllIllIIlIIlIlllI) {
            final ItemStack lllllllllllIlIIIllIllIIlIIlIllIl = Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIlIIlIlllI);
            if (lllllllllllIlIIIllIllIIlIIlIllIl != null && isPotion(lllllllllllIlIIIllIllIIlIIlIllIl)) {
                return lllllllllllIlIIIllIllIIlIIlIlllI;
            }
        }
        return -1;
    }
    
    public static int getSlotWithSoup() {
        for (int lllllllllllIlIIIllIllIIIIllllIIl = 0; lllllllllllIlIIIllIllIIIIllllIIl < 9; ++lllllllllllIlIIIllIllIIIIllllIIl) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIllllIIl) != null && Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIllllIIl).getItem() instanceof ItemSoup) {
                return lllllllllllIlIIIllIllIIIIllllIIl;
            }
        }
        return 0;
    }
    
    public boolean inventoryIsFull() {
        for (int lllllllllllIlIIIllIllIIIlllIIlII = 9; lllllllllllIlIIIllIllIIIlllIIlII < 45; ++lllllllllllIlIIIllIllIIIlllIIlII) {
            final ItemStack lllllllllllIlIIIllIllIIIlllIIIll = Minecraft.getMinecraft().player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIlllIIlII).getStack();
            if (lllllllllllIlIIIllIllIIIlllIIIll == null) {
                return false;
            }
        }
        return true;
    }
    
    public static int getAnyBlockInHotbar() {
        for (int lllllllllllIlIIIllIllIIIllllIlII = 0; lllllllllllIlIIIllIllIIIllllIlII < 9; ++lllllllllllIlIIIllIllIIIllllIlII) {
            final Item lllllllllllIlIIIllIllIIIllllIIll = Minecraft.getMinecraft().player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIllllIlII).getItem();
            if (lllllllllllIlIIIllIllIIIllllIIll instanceof ItemBlock) {
                return lllllllllllIlIIIllIllIIIllllIlII;
            }
        }
        return -1;
    }
    
    public static int getItemCount(final Container lllllllllllIlIIIllIllIIllIIIlIll, final Item lllllllllllIlIIIllIllIIllIIIlIlI) {
        int lllllllllllIlIIIllIllIIllIIIlIIl = 0;
        for (int lllllllllllIlIIIllIllIIllIIIlIII = 0; lllllllllllIlIIIllIllIIllIIIlIII < 45; ++lllllllllllIlIIIllIllIIllIIIlIII) {
            if (lllllllllllIlIIIllIllIIllIIIlIll.getSlot(lllllllllllIlIIIllIllIIllIIIlIII).getHasStack()) {
                final ItemStack lllllllllllIlIIIllIllIIllIIIIlll = lllllllllllIlIIIllIllIIllIIIlIll.getSlot(lllllllllllIlIIIllIllIIllIIIlIII).getStack();
                if (lllllllllllIlIIIllIllIIllIIIIlll.getItem() == lllllllllllIlIIIllIllIIllIIIlIlI) {
                    lllllllllllIlIIIllIllIIllIIIlIIl += lllllllllllIlIIIllIllIIllIIIIlll.getMaxStackSize();
                }
            }
        }
        return lllllllllllIlIIIllIllIIllIIIlIIl;
    }
    
    public static float getProtection(final ItemStack lllllllllllIlIIIllIllIIIIIlIlllI) {
        float lllllllllllIlIIIllIllIIIIIllIIII = 0.0f;
        if (lllllllllllIlIIIllIllIIIIIlIlllI.getItem() instanceof ItemArmor) {
            final ItemArmor lllllllllllIlIIIllIllIIIIIlIllll = (ItemArmor)lllllllllllIlIIIllIllIIIIIlIlllI.getItem();
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(lllllllllllIlIIIllIllIIIIIlIllll.damageReduceAmount + (100 - lllllllllllIlIIIllIllIIIIIlIllll.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(0), lllllllllllIlIIIllIllIIIIIlIlllI) * 0.0075);
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(3), lllllllllllIlIIIllIllIIIIIlIlllI) / 100.0);
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(1), lllllllllllIlIIIllIllIIIIIlIlllI) / 100.0);
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(7), lllllllllllIlIIIllIllIIIIIlIlllI) / 100.0);
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(34), lllllllllllIlIIIllIllIIIIIlIlllI) / 50.0);
            lllllllllllIlIIIllIllIIIIIllIIII += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(4), lllllllllllIlIIIllIllIIIIIlIlllI) / 100.0);
        }
        return lllllllllllIlIIIllIllIIIIIllIIII;
    }
    
    private int getArmorDurability() {
        int lllllllllllIlIIIllIllIIIIllIllII = 0;
        for (final ItemStack lllllllllllIlIIIllIllIIIIllIlIll : Util.mc.player.inventory.armorInventory) {
            lllllllllllIlIIIllIllIIIIllIllII += lllllllllllIlIIIllIllIIIIllIlIll.getItemDamage();
        }
        return lllllllllllIlIIIllIllIIIIllIllII;
    }
    
    public static void swapInventoryItems(final int lllllllllllIlIIIllIllIIlIIllIlII, final int lllllllllllIlIIIllIllIIlIIllIIll) {
        final short lllllllllllIlIIIllIllIIlIIllIllI = Minecraft.getMinecraft().player.inventoryContainer.getNextTransactionID(Minecraft.getMinecraft().player.inventory);
        ItemStack lllllllllllIlIIIllIllIIlIIllIlIl = Minecraft.getMinecraft().player.inventoryContainer.slotClick(lllllllllllIlIIIllIllIIlIIllIlII, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().player.connection.sendPacket(new CPacketClickWindow(Minecraft.getMinecraft().player.inventoryContainer.windowId, lllllllllllIlIIIllIllIIlIIllIlII, 0, ClickType.PICKUP, lllllllllllIlIIIllIllIIlIIllIlIl, lllllllllllIlIIIllIllIIlIIllIllI));
        lllllllllllIlIIIllIllIIlIIllIlIl = Minecraft.getMinecraft().player.inventoryContainer.slotClick(lllllllllllIlIIIllIllIIlIIllIIll, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
        lllllllllllIlIIIllIllIIlIIllIlIl = Minecraft.getMinecraft().player.inventoryContainer.slotClick(lllllllllllIlIIIllIllIIlIIllIlII, 0, ClickType.PICKUP, Minecraft.getMinecraft().player);
        Minecraft.getMinecraft().player.connection.sendPacket(new CPacketClickWindow(Minecraft.getMinecraft().player.inventoryContainer.windowId, lllllllllllIlIIIllIllIIlIIllIlII, 0, ClickType.PICKUP, lllllllllllIlIIIllIllIIlIIllIlIl, lllllllllllIlIIIllIllIIlIIllIllI));
        Minecraft.getMinecraft().playerController.updateController();
    }
    
    public static int getSwordSlot() {
        int lllllllllllIlIIIllIllIIIllIlIIIl = -1;
        float lllllllllllIlIIIllIllIIIllIlIIII = 1.0f;
        for (int lllllllllllIlIIIllIllIIIllIIllll = 9; lllllllllllIlIIIllIllIIIllIIllll < 45; ++lllllllllllIlIIIllIllIIIllIIllll) {
            if (Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIllIIllll).getHasStack()) {
                final ItemStack lllllllllllIlIIIllIllIIIllIIlllI = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIllIIllll).getStack();
                if (lllllllllllIlIIIllIllIIIllIIlllI != null && lllllllllllIlIIIllIllIIIllIIlllI.getItem() instanceof ItemSword) {
                    final ItemSword lllllllllllIlIIIllIllIIIllIIllIl = (ItemSword)lllllllllllIlIIIllIllIIIllIIlllI.getItem();
                    float lllllllllllIlIIIllIllIIIllIIllII = lllllllllllIlIIIllIllIIIllIIllIl.getDamageVsEntity();
                    lllllllllllIlIIIllIllIIIllIIllII += EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(16), lllllllllllIlIIIllIllIIIllIIlllI) * 1.26f + EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(20), lllllllllllIlIIIllIllIIIllIIlllI) * 0.01f;
                    if (lllllllllllIlIIIllIllIIIllIIllII > lllllllllllIlIIIllIllIIIllIlIIII) {
                        lllllllllllIlIIIllIllIIIllIlIIII = lllllllllllIlIIIllIllIIIllIIllII;
                        lllllllllllIlIIIllIllIIIllIlIIIl = lllllllllllIlIIIllIllIIIllIIllll;
                    }
                }
            }
        }
        return lllllllllllIlIIIllIllIIIllIlIIIl;
    }
    
    public static boolean isBestArmor(final ItemStack lllllllllllIlIIIllIllIIIIlIIIIII, final int lllllllllllIlIIIllIllIIIIIllllll) {
        final float lllllllllllIlIIIllIllIIIIIlllllI = getProtection(lllllllllllIlIIIllIllIIIIlIIIIII);
        String lllllllllllIlIIIllIllIIIIIllllIl = "";
        if (lllllllllllIlIIIllIllIIIIIllllll == 1) {
            lllllllllllIlIIIllIllIIIIIllllIl = "helmet";
        }
        else if (lllllllllllIlIIIllIllIIIIIllllll == 2) {
            lllllllllllIlIIIllIllIIIIIllllIl = "chestplate";
        }
        else if (lllllllllllIlIIIllIllIIIIIllllll == 3) {
            lllllllllllIlIIIllIllIIIIIllllIl = "leggings";
        }
        else if (lllllllllllIlIIIllIllIIIIIllllll == 4) {
            lllllllllllIlIIIllIllIIIIIllllIl = "boots";
        }
        if (!lllllllllllIlIIIllIllIIIIlIIIIII.getUnlocalizedName().contains(lllllllllllIlIIIllIllIIIIIllllIl)) {
            return false;
        }
        for (int lllllllllllIlIIIllIllIIIIIllllII = 5; lllllllllllIlIIIllIllIIIIIllllII < 45; ++lllllllllllIlIIIllIllIIIIIllllII) {
            if (Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIIIllllII).getHasStack()) {
                final ItemStack lllllllllllIlIIIllIllIIIIIlllIll = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIIIllllII).getStack();
                if (getProtection(lllllllllllIlIIIllIllIIIIIlllIll) > lllllllllllIlIIIllIllIIIIIlllllI && lllllllllllIlIIIllIllIIIIIlllIll.getUnlocalizedName().contains(lllllllllllIlIIIllIllIIIIIllllIl)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isIntercepted(final BlockPos lllllllllllIlIIIllIllIIlIIIIIIlI) {
        for (final Entity lllllllllllIlIIIllIllIIlIIIIIIll : Minecraft.getMinecraft().world.loadedEntityList) {
            if (new AxisAlignedBB(lllllllllllIlIIIllIllIIlIIIIIIlI).intersectsWith(lllllllllllIlIIIllIllIIlIIIIIIll.getEntityBoundingBox())) {
                return true;
            }
        }
        return false;
    }
    
    public static int getSwordAtHotbar() {
        for (int lllllllllllIlIIIllIllIIlIlIIIllI = 0; lllllllllllIlIIIllIllIIlIlIIIllI < 9; ++lllllllllllIlIIIllIllIIlIlIIIllI) {
            final ItemStack lllllllllllIlIIIllIllIIlIlIIIlIl = Minecraft.getMinecraft().player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIlIlIIIllI);
            if (lllllllllllIlIIIllIllIIlIlIIIlIl.getItem() instanceof ItemSword) {
                return lllllllllllIlIIIllIllIIlIlIIIllI;
            }
        }
        return 0;
    }
    
    public static boolean isInventoryFull() {
        for (int lllllllllllIlIIIllIllIIlIlIIIIII = 9; lllllllllllIlIIIllIllIIlIlIIIIII <= 44; ++lllllllllllIlIIIllIllIIlIlIIIIII) {
            final ItemStack lllllllllllIlIIIllIllIIlIIllllll = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIlIIIIII).getStack();
            if (lllllllllllIlIIIllIllIIlIIllllll == null) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isShiftable(final ItemStack lllllllllllIlIIIllIllIIlIIIllllI) {
        if (lllllllllllIlIIIllIllIIlIIIllllI == null) {
            return true;
        }
        for (int lllllllllllIlIIIllIllIIlIIlIIIII = 36; lllllllllllIlIIIllIllIIlIIlIIIII < 45; ++lllllllllllIlIIIllIllIIlIIlIIIII) {
            if (!Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIIlIIIII).getHasStack()) {
                return true;
            }
            final ItemStack lllllllllllIlIIIllIllIIlIIIlllll = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIIlIIIII).getStack();
            if (lllllllllllIlIIIllIllIIlIIIlllll == null) {
                return true;
            }
            if (Item.getIdFromItem(lllllllllllIlIIIllIllIIlIIIlllll.getItem()) == Item.getIdFromItem(lllllllllllIlIIIllIllIIlIIIllllI.getItem()) && lllllllllllIlIIIllIllIIlIIIlllll.getMaxStackSize() + lllllllllllIlIIIllIllIIlIIIllllI.getMaxStackSize() <= lllllllllllIlIIIllIllIIlIIIllllI.getMaxStackSize()) {
                return true;
            }
        }
        return false;
    }
    
    public static int getItemSlot(final Container lllllllllllIlIIIllIllIIIIllIIIlI, final Item lllllllllllIlIIIllIllIIIIllIIIIl) {
        int lllllllllllIlIIIllIllIIIIllIIIII = 0;
        for (int lllllllllllIlIIIllIllIIIIlIlllll = 9; lllllllllllIlIIIllIllIIIIlIlllll < 45; ++lllllllllllIlIIIllIllIIIIlIlllll) {
            if (lllllllllllIlIIIllIllIIIIllIIIlI.getSlot(lllllllllllIlIIIllIllIIIIlIlllll).getHasStack()) {
                final ItemStack lllllllllllIlIIIllIllIIIIlIllllI = lllllllllllIlIIIllIllIIIIllIIIlI.getSlot(lllllllllllIlIIIllIllIIIIlIlllll).getStack();
                if (lllllllllllIlIIIllIllIIIIlIllllI.getItem() == lllllllllllIlIIIllIllIIIIllIIIIl) {
                    lllllllllllIlIIIllIllIIIIllIIIII = lllllllllllIlIIIllIllIIIIlIlllll;
                }
            }
        }
        return lllllllllllIlIIIllIllIIIIllIIIII;
    }
    
    public static boolean doesNextSlotHavePot() {
        for (int lllllllllllIlIIIllIllIIIlIIIIIlI = 0; lllllllllllIlIIIllIllIIIlIIIIIlI < 9; ++lllllllllllIlIIIllIllIIIlIIIIIlI) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIlIIIIIlI) != null && Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIlIIIIIlI).getItem() instanceof ItemPotion) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkcrit() {
        return Minecraft.getMinecraft().player.isInLava() || Minecraft.getMinecraft().player.isInWater() || Minecraft.getMinecraft().player.isOnLadder() || Minecraft.getMinecraft().player.isInWeb;
    }
    
    public static void drawHead(final ResourceLocation lllllllllllIlIIIllIllIIlIllIIllI, final int lllllllllllIlIIIllIllIIlIllIlIII, final int lllllllllllIlIIIllIllIIlIllIIlII) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Util.mc.getTextureManager().bindTexture(lllllllllllIlIIIllIllIIlIllIIllI);
        Gui.drawScaledCustomSizeModalRect(lllllllllllIlIIIllIllIIlIllIlIII, lllllllllllIlIIIllIllIIlIllIIlII, 8.0f, 8.0f, 8, 8, 37, 37, 64.0f, 64.0f);
    }
    
    public static int getArmorItemsEquipSlot(final ItemStack lllllllllllIlIIIllIllIIIllIlllII, final boolean lllllllllllIlIIIllIllIIIllIlllIl) {
        if (lllllllllllIlIIIllIllIIIllIlllII.getUnlocalizedName().contains("helmet")) {
            return lllllllllllIlIIIllIllIIIllIlllIl ? 4 : 5;
        }
        if (lllllllllllIlIIIllIllIIIllIlllII.getUnlocalizedName().contains("chestplate")) {
            return lllllllllllIlIIIllIllIIIllIlllIl ? 3 : 6;
        }
        if (lllllllllllIlIIIllIllIIIllIlllII.getUnlocalizedName().contains("leggings")) {
            return lllllllllllIlIIIllIllIIIllIlllIl ? 2 : 7;
        }
        if (lllllllllllIlIIIllIllIIIllIlllII.getUnlocalizedName().contains("boots")) {
            return lllllllllllIlIIIllIllIIIllIlllIl ? 1 : 8;
        }
        return -1;
    }
    
    public static void drawHead3(final ResourceLocation lllllllllllIlIIIllIllIIlIlllIIIl, final int lllllllllllIlIIIllIllIIlIlllIlIl, final int lllllllllllIlIIIllIllIIlIlllIlII, final int lllllllllllIlIIIllIllIIlIllIlllI, final int lllllllllllIlIIIllIllIIlIllIllIl) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Util.mc.getTextureManager().bindTexture(lllllllllllIlIIIllIllIIlIlllIIIl);
        Gui.drawScaledCustomSizeModalRect(lllllllllllIlIIIllIllIIlIlllIlIl, lllllllllllIlIIIllIllIIlIlllIlII, 8.0f, 8.0f, 8, 8, lllllllllllIlIIIllIllIIlIllIlllI, lllllllllllIlIIIllIllIIlIllIllIl, 64.0f, 64.0f);
    }
    
    public static int getBestSword() {
        int lllllllllllIlIIIllIllIIIlIllllll = -1;
        float lllllllllllIlIIIllIllIIIlIlllllI = 1.0f;
        for (int lllllllllllIlIIIllIllIIIlIllllIl = 0; lllllllllllIlIIIllIllIIIlIllllIl < Util.mc.player.inventory.mainInventory.size(); ++lllllllllllIlIIIllIllIIIlIllllIl) {
            final ItemStack lllllllllllIlIIIllIllIIIlIllllII = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIIlIllllIl).getStack();
            if (lllllllllllIlIIIllIllIIIlIllllII != null && lllllllllllIlIIIllIllIIIlIllllII.getItem() instanceof ItemSword) {
                final ItemSword lllllllllllIlIIIllIllIIIlIlllIll = (ItemSword)lllllllllllIlIIIllIllIIIlIllllII.getItem();
                float lllllllllllIlIIIllIllIIIlIlllIlI = (float)lllllllllllIlIIIllIllIIIlIlllIll.getMaxDamage();
                lllllllllllIlIIIllIllIIIlIlllIlI += EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(20), lllllllllllIlIIIllIllIIIlIllllII);
                if (lllllllllllIlIIIllIllIIIlIlllIlI > lllllllllllIlIIIllIllIIIlIlllllI) {
                    lllllllllllIlIIIllIllIIIlIlllllI = lllllllllllIlIIIllIllIIIlIlllIlI;
                    lllllllllllIlIIIllIllIIIlIllllll = lllllllllllIlIIIllIllIIIlIllllIl;
                }
            }
        }
        return lllllllllllIlIIIllIllIIIlIllllll;
    }
    
    public static boolean doesHotbarHaveBlock() {
        for (int lllllllllllIlIIIllIllIIIllIllIIl = 0; lllllllllllIlIIIllIllIIIllIllIIl < 9; ++lllllllllllIlIIIllIllIIIllIllIIl) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIllIllIIl) != null && Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIllIllIIl).getItem() instanceof ItemBlock) {
                return true;
            }
        }
        return false;
    }
    
    private int findExpInHotbar() {
        int lllllllllllIlIIIllIllIIIIlllIlII = 0;
        for (int lllllllllllIlIIIllIllIIIIlllIIll = 0; lllllllllllIlIIIllIllIIIIlllIIll < 9; ++lllllllllllIlIIIllIllIIIIlllIIll) {
            if (Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlllIIll).getItem() == Items.EXPERIENCE_BOTTLE) {
                lllllllllllIlIIIllIllIIIIlllIlII = lllllllllllIlIIIllIllIIIIlllIIll;
                break;
            }
        }
        return lllllllllllIlIIIllIllIIIIlllIlII;
    }
    
    public static int getItemSlotInHotbar(final Item lllllllllllIlIIIllIllIIIIlIlIIII) {
        int lllllllllllIlIIIllIllIIIIlIlIIll = 0;
        for (int lllllllllllIlIIIllIllIIIIlIlIIlI = 0; lllllllllllIlIIIllIllIIIIlIlIIlI < 9; ++lllllllllllIlIIIllIllIIIIlIlIIlI) {
            final ItemStack lllllllllllIlIIIllIllIIIIlIlIIIl = Util.mc.player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIIlIlIIlI);
            if (lllllllllllIlIIIllIllIIIIlIlIIIl.getItem() == lllllllllllIlIIIllIllIIIIlIlIIII) {
                lllllllllllIlIIIllIllIIIIlIlIIll = lllllllllllIlIIIllIllIIIIlIlIIlI;
                break;
            }
        }
        return lllllllllllIlIIIllIllIIIIlIlIIll;
    }
    
    public static void swap(final int lllllllllllIlIIIllIllIIIIlIIlIII, final int lllllllllllIlIIIllIllIIIIlIIlIIl) {
        Util.mc.playerController.windowClick(Util.mc.player.inventoryContainer.windowId, lllllllllllIlIIIllIllIIIIlIIlIII, 0, ClickType.PICKUP, Util.mc.player);
        Util.mc.playerController.windowClick(Util.mc.player.inventoryContainer.windowId, lllllllllllIlIIIllIllIIIIlIIlIIl, 0, ClickType.PICKUP, Util.mc.player);
        Util.mc.playerController.windowClick(Util.mc.player.inventoryContainer.windowId, lllllllllllIlIIIllIllIIIIlIIlIII, 0, ClickType.PICKUP, Util.mc.player);
        Util.mc.playerController.updateController();
    }
    
    public static int getAxeAtHotbar() {
        for (int lllllllllllIlIIIllIllIIlIlllllll = 0; lllllllllllIlIIIllIllIIlIlllllll < 9; ++lllllllllllIlIIIllIllIIlIlllllll) {
            final ItemStack lllllllllllIlIIIllIllIIlIllllllI = Minecraft.getMinecraft().player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIlIlllllll);
            if (lllllllllllIlIIIllIllIIlIllllllI.getItem() instanceof ItemAxe) {
                return lllllllllllIlIIIllIllIIlIlllllll;
            }
        }
        return 1;
    }
    
    public static double getProtectionValue(final ItemStack lllllllllllIlIIIllIllIIIIIlIlIlI) {
        return (lllllllllllIlIIIllIllIIIIIlIlIlI.getItem() instanceof ItemArmor) ? (((ItemArmor)lllllllllllIlIIIllIllIIIIIlIlIlI.getItem()).damageReduceAmount + (100 - ((ItemArmor)lllllllllllIlIIIllIllIIIIIlIlIlI.getItem()).damageReduceAmount * 4) * EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(0), lllllllllllIlIIIllIllIIIIIlIlIlI) * 4 * 0.0075) : 0.0;
    }
    
    public static void drawHead3(final ResourceLocation lllllllllllIlIIIllIllIIlIlIIlllI, final int lllllllllllIlIIIllIllIIlIlIIlIlI, final int lllllllllllIlIIIllIllIIlIlIIlIIl) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Util.mc.getTextureManager().bindTexture(lllllllllllIlIIIllIllIIlIlIIlllI);
        Gui.drawScaledCustomSizeModalRect(lllllllllllIlIIIllIllIIlIlIIlIlI, lllllllllllIlIIIllIllIIlIlIIlIIl, 8.0f, 8.0f, 8, 8, 31, 31, 64.0f, 64.0f);
    }
    
    public static void drawEntityOnScreen(final int lllllllllllIlIIIllIllIIIlIIIllll, final int lllllllllllIlIIIllIllIIIlIIllIlI, final int lllllllllllIlIIIllIllIIIlIIIllIl, final float lllllllllllIlIIIllIllIIIlIIIllII, final float lllllllllllIlIIIllIllIIIlIIlIlll, final EntityLivingBase lllllllllllIlIIIllIllIIIlIIlIllI) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIlIIIllIllIIIlIIIllll, (float)lllllllllllIlIIIllIllIIIlIIllIlI, 40.0f);
        GlStateManager.scale((float)(-lllllllllllIlIIIllIllIIIlIIIllIl), (float)lllllllllllIlIIIllIllIIIlIIIllIl, (float)lllllllllllIlIIIllIllIIIlIIIllIl);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float lllllllllllIlIIIllIllIIIlIIlIlIl = lllllllllllIlIIIllIllIIIlIIlIllI.renderYawOffset;
        final float lllllllllllIlIIIllIllIIIlIIlIlII = lllllllllllIlIIIllIllIIIlIIlIllI.rotationYaw;
        final float lllllllllllIlIIIllIllIIIlIIlIIll = lllllllllllIlIIIllIllIIIlIIlIllI.rotationPitch;
        final float lllllllllllIlIIIllIllIIIlIIlIIlI = lllllllllllIlIIIllIllIIIlIIlIllI.prevRotationYawHead;
        final float lllllllllllIlIIIllIllIIIlIIlIIIl = lllllllllllIlIIIllIllIIIlIIlIllI.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(lllllllllllIlIIIllIllIIIlIIlIlll / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        lllllllllllIlIIIllIllIIIlIIlIllI.renderYawOffset = (float)Math.atan(lllllllllllIlIIIllIllIIIlIIIllII / 40.0f) * -14.0f;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationYaw = (float)Math.atan(lllllllllllIlIIIllIllIIIlIIIllII / 40.0f) * -14.0f;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationPitch = -(float)Math.atan(lllllllllllIlIIIllIllIIIlIIlIlll / 40.0f) * 15.0f;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationYawHead = lllllllllllIlIIIllIllIIIlIIlIllI.rotationYaw;
        lllllllllllIlIIIllIllIIIlIIlIllI.prevRotationYawHead = lllllllllllIlIIIllIllIIIlIIlIllI.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager lllllllllllIlIIIllIllIIIlIIlIIII = Minecraft.getMinecraft().getRenderManager();
        lllllllllllIlIIIllIllIIIlIIlIIII.setPlayerViewY(180.0f);
        lllllllllllIlIIIllIllIIIlIIlIIII.setRenderShadow(false);
        lllllllllllIlIIIllIllIIIlIIlIIII.doRenderEntity(lllllllllllIlIIIllIllIIIlIIlIllI, 0.0, 0.0, 0.0, 0.0f, 1.0f, true);
        lllllllllllIlIIIllIllIIIlIIlIIII.setRenderShadow(true);
        lllllllllllIlIIIllIllIIIlIIlIllI.renderYawOffset = lllllllllllIlIIIllIllIIIlIIlIlIl;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationYaw = lllllllllllIlIIIllIllIIIlIIlIlII;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationPitch = lllllllllllIlIIIllIllIIIlIIlIIll;
        lllllllllllIlIIIllIllIIIlIIlIllI.prevRotationYawHead = lllllllllllIlIIIllIllIIIlIIlIIlI;
        lllllllllllIlIIIllIllIIIlIIlIllI.rotationYawHead = lllllllllllIlIIIllIllIIIlIIlIIIl;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    static {
        Util.mc = Minecraft.getMinecraft();
        Util.timer = new TimerHelper();
    }
    
    public static int getUseablePotion() {
        for (int lllllllllllIlIIIllIllIIlIIIllIIl = 9; lllllllllllIlIIIllIllIIlIIIllIIl < 36; ++lllllllllllIlIIIllIllIIlIIIllIIl) {
            if (Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIIIllIIl).getHasStack()) {
                final ItemStack lllllllllllIlIIIllIllIIlIIIllIII = Util.mc.player.inventoryContainer.getSlot(lllllllllllIlIIIllIllIIlIIIllIIl).getStack();
                if (isPotion(lllllllllllIlIIIllIllIIlIIIllIII)) {
                    return lllllllllllIlIIIllIllIIlIIIllIIl;
                }
            }
        }
        return -1;
    }
    
    public static void drawHead1(final ResourceLocation lllllllllllIlIIIllIllIIlIlIlllIl, final int lllllllllllIlIIIllIllIIlIlIlllll, final int lllllllllllIlIIIllIllIIlIlIllllI) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Util.mc.getTextureManager().bindTexture(lllllllllllIlIIIllIllIIlIlIlllIl);
        Gui.drawScaledCustomSizeModalRect(lllllllllllIlIIIllIllIIlIlIlllll, lllllllllllIlIIIllIllIIlIlIllllI, 8.0f, 8.0f, 8, 8, 23, 22, 64.0f, 64.0f);
    }
    
    public static int getItemInHotbar(final Item lllllllllllIlIIIllIllIIIlllIlIlI) {
        for (int lllllllllllIlIIIllIllIIIlllIllII = 0; lllllllllllIlIIIllIllIIIlllIllII < 9; ++lllllllllllIlIIIllIllIIIlllIllII) {
            final Item lllllllllllIlIIIllIllIIIlllIlIll = Minecraft.getMinecraft().player.inventory.getStackInSlot(lllllllllllIlIIIllIllIIIlllIllII).getItem();
            if (lllllllllllIlIIIllIllIIIlllIlIll instanceof Item && lllllllllllIlIIIllIllIIIlllIlIll.equals(lllllllllllIlIIIllIllIIIlllIlIlI)) {
                return lllllllllllIlIIIllIllIIIlllIllII;
            }
        }
        return -1;
    }
    
    private boolean isBadPotion(final ItemStack lllllllllllIlIIIllIllIIIlIlIlIll) {
        if (lllllllllllIlIIIllIllIIIlIlIlIll != null && lllllllllllIlIIIllIllIIIlIlIlIll.getItem() instanceof ItemPotion) {
            for (final Object lllllllllllIlIIIllIllIIIlIlIllIl : PotionUtils.getEffectsFromStack(lllllllllllIlIIIllIllIIIlIlIlIll)) {
                final PotionEffect lllllllllllIlIIIllIllIIIlIlIllII = (PotionEffect)lllllllllllIlIIIllIllIIIlIlIllIl;
                if (lllllllllllIlIIIllIllIIIlIlIllII.getPotion() == Potion.getPotionById(19) || lllllllllllIlIIIllIllIIIlIlIllII.getPotion() == Potion.getPotionById(7) || lllllllllllIlIIIllIllIIIlIlIllII.getPotion() == Potion.getPotionById(2) || lllllllllllIlIIIllIllIIIlIlIllII.getPotion() == Potion.getPotionById(18)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void usePotion() {
        final EnumHand lllllllllllIlIIIllIllIIlIIIIlIll = EnumHand.MAIN_HAND;
        final ItemStack lllllllllllIlIIIllIllIIlIIIIlIlI = Util.mc.player.getHeldItem(EnumHand.MAIN_HAND);
        if (lllllllllllIlIIIllIllIIlIIIIlIlI != null) {
            Util.mc.playerController.processRightClick(Util.mc.player, Util.mc.world, lllllllllllIlIIIllIllIIlIIIIlIll);
        }
    }
}
