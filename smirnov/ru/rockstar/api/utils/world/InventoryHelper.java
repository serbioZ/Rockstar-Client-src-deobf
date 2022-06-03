// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.world;

import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemArmor;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemSword;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;
import net.minecraft.client.Minecraft;

public class InventoryHelper
{
    static /* synthetic */ TimerHelper timer;
    private static final /* synthetic */ Minecraft mc;
    
    public static boolean doesHotbarHaveAxe() {
        for (int llllllllllllllIIIIlllIlIIllIlIll = 0; llllllllllllllIIIIlllIlIIllIlIll < 9; ++llllllllllllllIIIIlllIlIIllIlIll) {
            InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIllIlIll);
            if (InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIllIlIll).getItem() instanceof ItemAxe) {
                return true;
            }
        }
        return false;
    }
    
    static {
        mc = Minecraft.getMinecraft();
        InventoryHelper.timer = new TimerHelper();
    }
    
    public static boolean isArmorPlayer(final Entity llllllllllllllIIIIlllIlIlIIIIlll) {
        for (final ItemStack llllllllllllllIIIIlllIlIlIIIlIII : llllllllllllllIIIIlllIlIlIIIIlll.getArmorInventoryList()) {
            if (llllllllllllllIIIIlllIlIlIIIlIII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isIntercepted(final BlockPos llllllllllllllIIIIlllIlIIIllllIl) {
        for (final Entity llllllllllllllIIIIlllIlIIIllllII : Minecraft.getMinecraft().world.loadedEntityList) {
            if (!new AxisAlignedBB(llllllllllllllIIIIlllIlIIIllllIl).intersectsWith(llllllllllllllIIIIlllIlIIIllllII.getEntityBoundingBox())) {
                continue;
            }
            return true;
        }
        return false;
    }
    
    public static int getAxe() {
        for (int llllllllllllllIIIIlllIlIIIlIlIlI = 0; llllllllllllllIIIIlllIlIIIlIlIlI < 9; ++llllllllllllllIIIIlllIlIIIlIlIlI) {
            final ItemStack llllllllllllllIIIIlllIlIIIlIlIIl = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIlIlIlI);
            if (llllllllllllllIIIIlllIlIIIlIlIIl.getItem() instanceof ItemAxe) {
                return llllllllllllllIIIIlllIlIIIlIlIlI;
            }
        }
        return 1;
    }
    
    public static void usePotion() {
        final EnumHand llllllllllllllIIIIlllIlIIlIIIlII = EnumHand.MAIN_HAND;
        final ItemStack llllllllllllllIIIIlllIlIIlIIIIll = InventoryHelper.mc.player.getHeldItem(EnumHand.MAIN_HAND);
        if (llllllllllllllIIIIlllIlIIlIIIIll != null) {
            InventoryHelper.mc.playerController.processRightClick(InventoryHelper.mc.player, InventoryHelper.mc.world, llllllllllllllIIIIlllIlIIlIIIlII);
        }
    }
    
    public static int getPearl() {
        for (int llllllllllllllIIIIlllIlIIIllIIII = 0; llllllllllllllIIIIlllIlIIIllIIII < 9; ++llllllllllllllIIIIlllIlIIIllIIII) {
            final ItemStack llllllllllllllIIIIlllIlIIIlIllll = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIllIIII);
            if (llllllllllllllIIIIlllIlIIIlIllll.getItem() instanceof ItemEnderPearl) {
                return llllllllllllllIIIIlllIlIIIllIIII;
            }
        }
        return 1;
    }
    
    public static int getElytraAtHotbar() {
        for (int llllllllllllllIIIIlllIlIIlllIllI = 0; llllllllllllllIIIIlllIlIIlllIllI < 45; ++llllllllllllllIIIIlllIlIIlllIllI) {
            final ItemStack llllllllllllllIIIIlllIlIIlllIlIl = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIlllIllI).getStack();
            if (llllllllllllllIIIIlllIlIIlllIlIl.getItem() == Items.ELYTRA) {
                return llllllllllllllIIIIlllIlIIlllIllI;
            }
        }
        return -1;
    }
    
    public static int getSwordSlot() {
        int llllllllllllllIIIIlllIlIIIIIlIll = -1;
        float llllllllllllllIIIIlllIlIIIIIlIlI = 1.0f;
        for (int llllllllllllllIIIIlllIlIIIIIlIIl = 9; llllllllllllllIIIIlllIlIIIIIlIIl < 45; ++llllllllllllllIIIIlllIlIIIIIlIIl) {
            if (InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIIIIlIIl).getHasStack()) {
                final ItemStack llllllllllllllIIIIlllIlIIIIIlIII = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIIIIlIIl).getStack();
                if (llllllllllllllIIIIlllIlIIIIIlIII != null) {
                    if (llllllllllllllIIIIlllIlIIIIIlIII.getItem() instanceof ItemSword) {
                        final ItemSword llllllllllllllIIIIlllIlIIIIIIlll = (ItemSword)llllllllllllllIIIIlllIlIIIIIlIII.getItem();
                        float llllllllllllllIIIIlllIlIIIIIIllI = llllllllllllllIIIIlllIlIIIIIIlll.getDamageVsEntity();
                        if ((llllllllllllllIIIIlllIlIIIIIIllI += EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(16), llllllllllllllIIIIlllIlIIIIIlIII) * 1.26f + EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(20), llllllllllllllIIIIlllIlIIIIIlIII) * 0.01f) > llllllllllllllIIIIlllIlIIIIIlIlI) {
                            llllllllllllllIIIIlllIlIIIIIlIlI = llllllllllllllIIIIlllIlIIIIIIllI;
                            llllllllllllllIIIIlllIlIIIIIlIll = llllllllllllllIIIIlllIlIIIIIlIIl;
                        }
                    }
                }
            }
        }
        return llllllllllllllIIIIlllIlIIIIIlIll;
    }
    
    public static boolean isBestArmor(final ItemStack llllllllllllllIIIIlllIIllllIIIll, final int llllllllllllllIIIIlllIIllllIIIlI) {
        final float llllllllllllllIIIIlllIIllllIIIIl = getProtection(llllllllllllllIIIIlllIIllllIIIll);
        String llllllllllllllIIIIlllIIllllIIIII = "";
        if (llllllllllllllIIIIlllIIllllIIIlI == 1) {
            llllllllllllllIIIIlllIIllllIIIII = "helmet";
        }
        else if (llllllllllllllIIIIlllIIllllIIIlI == 2) {
            llllllllllllllIIIIlllIIllllIIIII = "chestplate";
        }
        else if (llllllllllllllIIIIlllIIllllIIIlI == 3) {
            llllllllllllllIIIIlllIIllllIIIII = "leggings";
        }
        else if (llllllllllllllIIIIlllIIllllIIIlI == 4) {
            llllllllllllllIIIIlllIIllllIIIII = "boots";
        }
        if (!llllllllllllllIIIIlllIIllllIIIll.getUnlocalizedName().contains(llllllllllllllIIIIlllIIllllIIIII)) {
            return false;
        }
        for (int llllllllllllllIIIIlllIIlllIlllll = 5; llllllllllllllIIIIlllIIlllIlllll < 45; ++llllllllllllllIIIIlllIIlllIlllll) {
            if (InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIIlllIlllll).getHasStack()) {
                final ItemStack llllllllllllllIIIIlllIIlllIllllI = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIIlllIlllll).getStack();
                if (getProtection(llllllllllllllIIIIlllIIlllIllllI) > llllllllllllllIIIIlllIIllllIIIIl) {
                    if (llllllllllllllIIIIlllIIlllIllllI.getUnlocalizedName().contains(llllllllllllllIIIIlllIIllllIIIII)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean hasAnyBlock() {
        for (int llllllllllllllIIIIlllIlIIlIllllI = 0; llllllllllllllIIIIlllIlIIlIllllI < 9; ++llllllllllllllIIIIlllIlIIlIllllI) {
            Minecraft.getMinecraft();
            final Item llllllllllllllIIIIlllIlIIlIlllIl = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIlIllllI).getItem();
            if (llllllllllllllIIIIlllIlIIlIlllIl instanceof ItemBlock) {
                return true;
            }
        }
        return false;
    }
    
    public static int getItemCount(final Container llllllllllllllIIIIlllIlIlIIlIIIl, final Item llllllllllllllIIIIlllIlIlIIlIllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2        /* llllllllllllllIIIIlllIlIlIIIllll */
        //     2: iconst_0       
        //     3: istore_3        /* llllllllllllllIIIIlllIlIlIIIlllI */
        //     4: goto            50
        //     7: aload_0         /* llllllllllllllIIIIlllIlIlIIlIlll */
        //     8: iload_3         /* llllllllllllllIIIIlllIlIlIIlIlII */
        //     9: invokevirtual   net/minecraft/inventory/Container.getSlot:(I)Lnet/minecraft/inventory/Slot;
        //    12: invokevirtual   net/minecraft/inventory/Slot.getHasStack:()Z
        //    15: ifeq            47
        //    18: aload_0         /* llllllllllllllIIIIlllIlIlIIlIlll */
        //    19: iload_3         /* llllllllllllllIIIIlllIlIlIIlIlII */
        //    20: invokevirtual   net/minecraft/inventory/Container.getSlot:(I)Lnet/minecraft/inventory/Slot;
        //    23: invokevirtual   net/minecraft/inventory/Slot.getStack:()Lnet/minecraft/item/ItemStack;
        //    26: dup            
        //    27: astore          llllllllllllllIIIIlllIlIlIIlIIll
        //    29: invokevirtual   net/minecraft/item/ItemStack.getItem:()Lnet/minecraft/item/Item;
        //    32: aload_1         /* llllllllllllllIIIIlllIlIlIIlIIII */
        //    33: if_acmpeq       39
        //    36: goto            47
        //    39: iload_2         /* llllllllllllllIIIIlllIlIlIIlIlIl */
        //    40: aload           llllllllllllllIIIIlllIlIlIIlIIlI
        //    42: invokevirtual   net/minecraft/item/ItemStack.getMaxStackSize:()I
        //    45: iadd           
        //    46: istore_2        /* llllllllllllllIIIIlllIlIlIIlIlIl */
        //    47: iinc            llllllllllllllIIIIlllIlIlIIlIlII, 1
        //    50: iload_3         /* llllllllllllllIIIIlllIlIlIIlIlII */
        //    51: bipush          45
        //    53: if_icmplt       7
        //    56: iload_2         /* llllllllllllllIIIIlllIlIlIIlIlIl */
        //    57: ireturn        
        //    StackMapTable: 00 04 FD 00 07 01 01 FC 00 1F 07 00 28 FA 00 07 02
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int getArmorItemsEquipSlot(final ItemStack llllllllllllllIIIIlllIlIIIIlllII, final boolean llllllllllllllIIIIlllIlIIIIlllIl) {
        if (llllllllllllllIIIIlllIlIIIIlllII.getUnlocalizedName().contains("helmet")) {
            return llllllllllllllIIIIlllIlIIIIlllIl ? 4 : 5;
        }
        if (llllllllllllllIIIIlllIlIIIIlllII.getUnlocalizedName().contains("chestplate")) {
            return llllllllllllllIIIIlllIlIIIIlllIl ? 3 : 6;
        }
        if (llllllllllllllIIIIlllIlIIIIlllII.getUnlocalizedName().contains("leggings")) {
            return llllllllllllllIIIIlllIlIIIIlllIl ? 2 : 7;
        }
        if (llllllllllllllIIIIlllIlIIIIlllII.getUnlocalizedName().contains("boots")) {
            return llllllllllllllIIIIlllIlIIIIlllIl ? 1 : 8;
        }
        return -1;
    }
    
    public static boolean doesHotbarHaveBlock() {
        for (int llllllllllllllIIIIlllIlIIIIllIIl = 0; llllllllllllllIIIIlllIlIIIIllIIl < 9; ++llllllllllllllIIIIlllIlIIIIllIIl) {
            if (InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIIllIIl).getItem() instanceof ItemBlock) {
                return true;
            }
        }
        return false;
    }
    
    public static int getSwordH() {
        for (int llllllllllllllIIIIlllIlIIIIlIlIl = 1; llllllllllllllIIIIlllIlIIIIlIlIl < 9; ++llllllllllllllIIIIlllIlIIIIlIlIl) {
            final ItemStack llllllllllllllIIIIlllIlIIIIlIlII = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIIlIlIl);
            if (llllllllllllllIIIIlllIlIIIIlIlII.getItem() instanceof ItemSword) {
                return llllllllllllllIIIIlllIlIIIIlIlIl;
            }
        }
        return 0;
    }
    
    public static int getAnyBlockInHotbar() {
        for (int llllllllllllllIIIIlllIlIIIlIIlII = 0; llllllllllllllIIIIlllIlIIIlIIlII < 9; ++llllllllllllllIIIIlllIlIIIlIIlII) {
            Minecraft.getMinecraft();
            final Item llllllllllllllIIIIlllIlIIIlIIIll = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIlIIlII).getItem();
            if (llllllllllllllIIIIlllIlIIIlIIIll instanceof ItemBlock) {
                return llllllllllllllIIIIlllIlIIIlIIlII;
            }
        }
        return -1;
    }
    
    public static int getTotemAtHotbar() {
        for (int llllllllllllllIIIIlllIlIlIIIIIlI = 0; llllllllllllllIIIIlllIlIlIIIIIlI < 45; ++llllllllllllllIIIIlllIlIlIIIIIlI) {
            final ItemStack llllllllllllllIIIIlllIlIlIIIIIIl = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIlIIIIIlI).getStack();
            if (llllllllllllllIIIIlllIlIlIIIIIIl.getItem() == Items.TOTEM_OF_UNDYING) {
                return llllllllllllllIIIIlllIlIlIIIIIlI;
            }
        }
        return -1;
    }
    
    public static int getItemSlot(final Container llllllllllllllIIIIlllIIlllllIlII, final Item llllllllllllllIIIIlllIIllllllIIl) {
        int llllllllllllllIIIIlllIIllllllIII = 0;
        for (int llllllllllllllIIIIlllIIlllllIlll = 9; llllllllllllllIIIIlllIIlllllIlll < 45; ++llllllllllllllIIIIlllIIlllllIlll) {
            if (llllllllllllllIIIIlllIIlllllIlII.getSlot(llllllllllllllIIIIlllIIlllllIlll).getHasStack()) {
                final ItemStack llllllllllllllIIIIlllIIlllllIllI;
                if ((llllllllllllllIIIIlllIIlllllIllI = llllllllllllllIIIIlllIIlllllIlII.getSlot(llllllllllllllIIIIlllIIlllllIlll).getStack()).getItem() == llllllllllllllIIIIlllIIllllllIIl) {
                    llllllllllllllIIIIlllIIllllllIII = llllllllllllllIIIIlllIIlllllIlll;
                }
            }
        }
        return llllllllllllllIIIIlllIIllllllIII;
    }
    
    public static boolean isPotion(final ItemStack llllllllllllllIIIIlllIlIIlIIllIl) {
        if (llllllllllllllIIIIlllIlIIlIIllIl.getItem() instanceof ItemSplashPotion) {
            for (final PotionEffect llllllllllllllIIIIlllIlIIlIIllII : PotionUtils.getEffectsFromStack(llllllllllllllIIIIlllIlIIlIIllIl)) {
                final Potion llllllllllllllIIIIlllIlIIlIIlIll = llllllllllllllIIIIlllIlIIlIIllII.getPotion();
                llllllllllllllIIIIlllIlIIlIIllII.getPotion();
                if (llllllllllllllIIIIlllIlIIlIIlIll != Potion.getPotionById(5)) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
    
    public static void attackEntity(final Entity llllllllllllllIIIIlllIlIIllIIIll, final boolean llllllllllllllIIIIlllIlIIllIIIlI, final boolean llllllllllllllIIIIlllIlIIllIIIIl) {
        if (llllllllllllllIIIIlllIlIIllIIIlI) {
            InventoryHelper.mc.player.connection.sendPacket(new CPacketUseEntity(llllllllllllllIIIIlllIlIIllIIIll));
        }
        else {
            InventoryHelper.mc.playerController.attackEntity(InventoryHelper.mc.player, llllllllllllllIIIIlllIlIIllIIIll);
        }
        if (llllllllllllllIIIIlllIlIIllIIIIl) {
            InventoryHelper.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }
    
    public static int getShieldAtHotbar() {
        for (int llllllllllllllIIIIlllIlIIlllIIII = 0; llllllllllllllIIIIlllIlIIlllIIII < 45; ++llllllllllllllIIIIlllIlIIlllIIII) {
            final ItemStack llllllllllllllIIIIlllIlIIllIllll = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIlllIIII).getStack();
            if (llllllllllllllIIIIlllIlIIllIllll.getItem() == Items.SHIELD) {
                return llllllllllllllIIIIlllIlIIlllIIII;
            }
        }
        return -1;
    }
    
    public static double getProtectionValue(final ItemStack llllllllllllllIIIIlllIIlllIIllII) {
        return (llllllllllllllIIIIlllIIlllIIllII.getItem() instanceof ItemArmor) ? (((ItemArmor)llllllllllllllIIIIlllIIlllIIllII.getItem()).damageReduceAmount + (100 - ((ItemArmor)llllllllllllllIIIIlllIIlllIIllII.getItem()).damageReduceAmount * 4) * EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(0), llllllllllllllIIIIlllIIlllIIllII) * 4 * 0.0075) : 0.0;
    }
    
    public static boolean isShiftable(final ItemStack llllllllllllllIIIIlllIlIIlIlIlll) {
        if (llllllllllllllIIIIlllIlIIlIlIlll == null) {
            return true;
        }
        for (int llllllllllllllIIIIlllIlIIlIlIllI = 36; llllllllllllllIIIIlllIlIIlIlIllI < 45; ++llllllllllllllIIIIlllIlIIlIlIllI) {
            if (!InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIlIlIllI).getHasStack()) {
                return true;
            }
            final ItemStack llllllllllllllIIIIlllIlIIlIlIlIl = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIlIlIllI).getStack();
            if (llllllllllllllIIIIlllIlIIlIlIlIl == null) {
                return true;
            }
            if (Item.getIdFromItem(llllllllllllllIIIIlllIlIIlIlIlIl.getItem()) == Item.getIdFromItem(llllllllllllllIIIIlllIlIIlIlIlll.getItem()) && llllllllllllllIIIIlllIlIIlIlIlIl.getMaxStackSize() + llllllllllllllIIIIlllIlIIlIlIlll.getMaxStackSize() <= llllllllllllllIIIIlllIlIIlIlIlll.getMaxStackSize()) {
                return true;
            }
        }
        return false;
    }
    
    public static int getSwordAtHotbar() {
        for (int llllllllllllllIIIIlllIlIIIllIllI = 0; llllllllllllllIIIIlllIlIIIllIllI < 9; ++llllllllllllllIIIIlllIlIIIllIllI) {
            final ItemStack llllllllllllllIIIIlllIlIIIllIlIl = InventoryHelper.mc.player.inventory.getStackInSlot(llllllllllllllIIIIlllIlIIIllIllI);
            if (llllllllllllllIIIIlllIlIIIllIlIl.getItem() instanceof ItemSword) {
                return llllllllllllllIIIIlllIlIIIllIllI;
            }
        }
        return 1;
    }
    
    public static void swap(final int llllllllllllllIIIIlllIIllllIlIll, final int llllllllllllllIIIIlllIIllllIllII) {
        InventoryHelper.mc.playerController.windowClick(InventoryHelper.mc.player.inventoryContainer.windowId, llllllllllllllIIIIlllIIllllIlIll, 0, ClickType.PICKUP, InventoryHelper.mc.player);
        InventoryHelper.mc.playerController.windowClick(InventoryHelper.mc.player.inventoryContainer.windowId, llllllllllllllIIIIlllIIllllIllII, 0, ClickType.PICKUP, InventoryHelper.mc.player);
        InventoryHelper.mc.playerController.windowClick(InventoryHelper.mc.player.inventoryContainer.windowId, llllllllllllllIIIIlllIIllllIlIll, 0, ClickType.PICKUP, InventoryHelper.mc.player);
        InventoryHelper.mc.playerController.updateController();
    }
    
    public static int getItemAtHotbar() {
        for (int llllllllllllllIIIIlllIlIIlllllII = 0; llllllllllllllIIIIlllIlIIlllllII < 45; ++llllllllllllllIIIIlllIlIIlllllII) {
            final ItemStack llllllllllllllIIIIlllIlIIllllIll = InventoryHelper.mc.player.inventoryContainer.getSlot(llllllllllllllIIIIlllIlIIlllllII).getStack();
            if (llllllllllllllIIIIlllIlIIllllIll.getItem() == Items.GOLDEN_APPLE) {
                return llllllllllllllIIIIlllIlIIlllllII;
            }
        }
        return -1;
    }
    
    public static float getProtection(final ItemStack llllllllllllllIIIIlllIIlllIlIlII) {
        float llllllllllllllIIIIlllIIlllIlIIll = 0.0f;
        if (llllllllllllllIIIIlllIIlllIlIlII.getItem() instanceof ItemArmor) {
            final ItemArmor llllllllllllllIIIIlllIIlllIlIIlI = (ItemArmor)llllllllllllllIIIIlllIIlllIlIlII.getItem();
            llllllllllllllIIIIlllIIlllIlIIll += (float)(llllllllllllllIIIIlllIIlllIlIIlI.damageReduceAmount + (100 - llllllllllllllIIIIlllIIlllIlIIlI.damageReduceAmount) * EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(0), llllllllllllllIIIIlllIIlllIlIlII) * 0.0075);
            llllllllllllllIIIIlllIIlllIlIIll += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(3), llllllllllllllIIIIlllIIlllIlIlII) / 100.0);
            llllllllllllllIIIIlllIIlllIlIIll += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(1), llllllllllllllIIIIlllIIlllIlIlII) / 100.0);
            llllllllllllllIIIIlllIIlllIlIIll += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(7), llllllllllllllIIIIlllIIlllIlIlII) / 100.0);
            llllllllllllllIIIIlllIIlllIlIIll += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(34), llllllllllllllIIIIlllIIlllIlIlII) / 50.0);
            llllllllllllllIIIIlllIIlllIlIIll += (float)(EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByID(4), llllllllllllllIIIIlllIIlllIlIlII) / 100.0);
        }
        return llllllllllllllIIIIlllIIlllIlIIll;
    }
}
