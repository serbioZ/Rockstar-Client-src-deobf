// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.server.MinecraftServer;
import net.minecraft.inventory.EntityEquipmentSlot;
import com.google.common.collect.Maps;
import java.util.Map;

public class CommandReplaceItem extends CommandBase
{
    private static final /* synthetic */ Map<String, Integer> SHORTCUTS;
    
    static {
        SHORTCUTS = Maps.newHashMap();
        for (int lllllllllllIIllIlIlIllIlIIIlIIIl = 0; lllllllllllIIllIlIlIllIlIIIlIIIl < 54; ++lllllllllllIIllIlIlIllIlIIIlIIIl) {
            CommandReplaceItem.SHORTCUTS.put("slot.container." + lllllllllllIIllIlIlIllIlIIIlIIIl, lllllllllllIIllIlIlIllIlIIIlIIIl);
        }
        for (int lllllllllllIIllIlIlIllIlIIIlIIII = 0; lllllllllllIIllIlIlIllIlIIIlIIII < 9; ++lllllllllllIIllIlIlIllIlIIIlIIII) {
            CommandReplaceItem.SHORTCUTS.put("slot.hotbar." + lllllllllllIIllIlIlIllIlIIIlIIII, lllllllllllIIllIlIlIllIlIIIlIIII);
        }
        for (int lllllllllllIIllIlIlIllIlIIIIllll = 0; lllllllllllIIllIlIlIllIlIIIIllll < 27; ++lllllllllllIIllIlIlIllIlIIIIllll) {
            CommandReplaceItem.SHORTCUTS.put("slot.inventory." + lllllllllllIIllIlIlIllIlIIIIllll, 9 + lllllllllllIIllIlIlIllIlIIIIllll);
        }
        for (int lllllllllllIIllIlIlIllIlIIIIlllI = 0; lllllllllllIIllIlIlIllIlIIIIlllI < 27; ++lllllllllllIIllIlIlIllIlIIIIlllI) {
            CommandReplaceItem.SHORTCUTS.put("slot.enderchest." + lllllllllllIIllIlIlIllIlIIIIlllI, 200 + lllllllllllIIllIlIlIllIlIIIIlllI);
        }
        for (int lllllllllllIIllIlIlIllIlIIIIllIl = 0; lllllllllllIIllIlIlIllIlIIIIllIl < 8; ++lllllllllllIIllIlIlIllIlIIIIllIl) {
            CommandReplaceItem.SHORTCUTS.put("slot.villager." + lllllllllllIIllIlIlIllIlIIIIllIl, 300 + lllllllllllIIllIlIlIllIlIIIIllIl);
        }
        for (int lllllllllllIIllIlIlIllIlIIIIllII = 0; lllllllllllIIllIlIlIllIlIIIIllII < 15; ++lllllllllllIIllIlIlIllIlIIIIllII) {
            CommandReplaceItem.SHORTCUTS.put("slot.horse." + lllllllllllIIllIlIlIllIlIIIIllII, 500 + lllllllllllIIllIlIlIllIlIIIIllII);
        }
        CommandReplaceItem.SHORTCUTS.put("slot.weapon", 98);
        CommandReplaceItem.SHORTCUTS.put("slot.weapon.mainhand", 98);
        CommandReplaceItem.SHORTCUTS.put("slot.weapon.offhand", 99);
        CommandReplaceItem.SHORTCUTS.put("slot.armor.head", 100 + EntityEquipmentSlot.HEAD.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.chest", 100 + EntityEquipmentSlot.CHEST.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.legs", 100 + EntityEquipmentSlot.LEGS.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.armor.feet", 100 + EntityEquipmentSlot.FEET.getIndex());
        CommandReplaceItem.SHORTCUTS.put("slot.horse.saddle", 400);
        CommandReplaceItem.SHORTCUTS.put("slot.horse.armor", 401);
        CommandReplaceItem.SHORTCUTS.put("slot.horse.chest", 499);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllIlIlIllIlIIIIIlII) {
        return "commands.replaceitem.usage";
    }
    
    @Override
    public String getCommandName() {
        return "replaceitem";
    }
    
    private int getSlotForShortcut(final String lllllllllllIIllIlIlIllIIllIIlIIl) throws CommandException {
        if (!CommandReplaceItem.SHORTCUTS.containsKey(lllllllllllIIllIlIlIllIIllIIlIIl)) {
            throw new CommandException("commands.generic.parameter.invalid", new Object[] { lllllllllllIIllIlIlIllIIllIIlIIl });
        }
        return CommandReplaceItem.SHORTCUTS.get(lllllllllllIIllIlIlIllIIllIIlIIl);
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIllIlIlIllIIlIlllIlI, final int lllllllllllIIllIlIlIllIIlIlllIIl) {
        return lllllllllllIIllIlIlIllIIlIlllIlI.length > 0 && "entity".equals(lllllllllllIIllIlIlIllIIlIlllIlI[0]) && lllllllllllIIllIlIlIllIIlIlllIIl == 1;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllIlIlIllIIllIllIll, final ICommandSender lllllllllllIIllIlIlIllIIllIllIlI, final String[] lllllllllllIIllIlIlIllIIllllIIII) throws CommandException {
        if (lllllllllllIIllIlIlIllIIllllIIII.length < 1) {
            throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
        }
        boolean lllllllllllIIllIlIlIllIIlllIlllI = false;
        if ("entity".equals(lllllllllllIIllIlIlIllIIllllIIII[0])) {
            final boolean lllllllllllIIllIlIlIllIIlllIllll = false;
        }
        else {
            if (!"block".equals(lllllllllllIIllIlIlIllIIllllIIII[0])) {
                throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
            }
            lllllllllllIIllIlIlIllIIlllIlllI = true;
        }
        int lllllllllllIIllIlIlIllIIlllIllII = 0;
        if (lllllllllllIIllIlIlIllIIlllIlllI) {
            if (lllllllllllIIllIlIlIllIIllllIIII.length < 6) {
                throw new WrongUsageException("commands.replaceitem.block.usage", new Object[0]);
            }
            final int lllllllllllIIllIlIlIllIIlllIllIl = 4;
        }
        else {
            if (lllllllllllIIllIlIlIllIIllllIIII.length < 4) {
                throw new WrongUsageException("commands.replaceitem.entity.usage", new Object[0]);
            }
            lllllllllllIIllIlIlIllIIlllIllII = 2;
        }
        final String lllllllllllIIllIlIlIllIIlllIlIll = lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII];
        final int lllllllllllIIllIlIlIllIIlllIlIlI = this.getSlotForShortcut(lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII++]);
        Item lllllllllllIIllIlIlIllIIlllIlIII = null;
        try {
            final Item lllllllllllIIllIlIlIllIIlllIlIIl = CommandBase.getItemByText(lllllllllllIIllIlIlIllIIllIllIlI, lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII]);
        }
        catch (NumberInvalidException lllllllllllIIllIlIlIllIIlllIIlll) {
            if (Block.getBlockFromName(lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII]) != Blocks.AIR) {
                throw lllllllllllIIllIlIlIllIIlllIIlll;
            }
            lllllllllllIIllIlIlIllIIlllIlIII = null;
        }
        ++lllllllllllIIllIlIlIllIIlllIllII;
        final int lllllllllllIIllIlIlIllIIlllIIllI = (lllllllllllIIllIlIlIllIIllllIIII.length > lllllllllllIIllIlIlIllIIlllIllII) ? CommandBase.parseInt(lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII++], 1, lllllllllllIIllIlIlIllIIlllIlIII.getItemStackLimit()) : 1;
        final int lllllllllllIIllIlIlIllIIlllIIlIl = (lllllllllllIIllIlIlIllIIllllIIII.length > lllllllllllIIllIlIlIllIIlllIllII) ? CommandBase.parseInt(lllllllllllIIllIlIlIllIIllllIIII[lllllllllllIIllIlIlIllIIlllIllII++]) : 0;
        final ItemStack lllllllllllIIllIlIlIllIIlllIIlII = new ItemStack(lllllllllllIIllIlIlIllIIlllIlIII, lllllllllllIIllIlIlIllIIlllIIllI, lllllllllllIIllIlIlIllIIlllIIlIl);
        if (lllllllllllIIllIlIlIllIIllllIIII.length > lllllllllllIIllIlIlIllIIlllIllII) {
            final String lllllllllllIIllIlIlIllIIlllIIIll = CommandBase.buildString(lllllllllllIIllIlIlIllIIllllIIII, lllllllllllIIllIlIlIllIIlllIllII);
            try {
                lllllllllllIIllIlIlIllIIlllIIlII.setTagCompound(JsonToNBT.getTagFromJson(lllllllllllIIllIlIlIllIIlllIIIll));
            }
            catch (NBTException lllllllllllIIllIlIlIllIIlllIIIlI) {
                throw new CommandException("commands.replaceitem.tagError", new Object[] { lllllllllllIIllIlIlIllIIlllIIIlI.getMessage() });
            }
        }
        if (lllllllllllIIllIlIlIllIIlllIlllI) {
            lllllllllllIIllIlIlIllIIllIllIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            final BlockPos lllllllllllIIllIlIlIllIIlllIIIIl = CommandBase.parseBlockPos(lllllllllllIIllIlIlIllIIllIllIlI, lllllllllllIIllIlIlIllIIllllIIII, 1, false);
            final World lllllllllllIIllIlIlIllIIlllIIIII = lllllllllllIIllIlIlIllIIllIllIlI.getEntityWorld();
            final TileEntity lllllllllllIIllIlIlIllIIllIlllll = lllllllllllIIllIlIlIllIIlllIIIII.getTileEntity(lllllllllllIIllIlIlIllIIlllIIIIl);
            if (lllllllllllIIllIlIlIllIIllIlllll == null || !(lllllllllllIIllIlIlIllIIllIlllll instanceof IInventory)) {
                throw new CommandException("commands.replaceitem.noContainer", new Object[] { lllllllllllIIllIlIlIllIIlllIIIIl.getX(), lllllllllllIIllIlIlIllIIlllIIIIl.getY(), lllllllllllIIllIlIlIllIIlllIIIIl.getZ() });
            }
            final IInventory lllllllllllIIllIlIlIllIIllIllllI = (IInventory)lllllllllllIIllIlIlIllIIllIlllll;
            if (lllllllllllIIllIlIlIllIIlllIlIlI >= 0 && lllllllllllIIllIlIlIllIIlllIlIlI < lllllllllllIIllIlIlIllIIllIllllI.getSizeInventory()) {
                lllllllllllIIllIlIlIllIIllIllllI.setInventorySlotContents(lllllllllllIIllIlIlIllIIlllIlIlI, lllllllllllIIllIlIlIllIIlllIIlII);
            }
        }
        else {
            final Entity lllllllllllIIllIlIlIllIIllIlllIl = CommandBase.getEntity(lllllllllllIIllIlIlIllIIllIllIll, lllllllllllIIllIlIlIllIIllIllIlI, lllllllllllIIllIlIlIllIIllllIIII[1]);
            lllllllllllIIllIlIlIllIIllIllIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            if (lllllllllllIIllIlIlIllIIllIlllIl instanceof EntityPlayer) {
                ((EntityPlayer)lllllllllllIIllIlIlIllIIllIlllIl).inventoryContainer.detectAndSendChanges();
            }
            if (!lllllllllllIIllIlIlIllIIllIlllIl.replaceItemInInventory(lllllllllllIIllIlIlIllIIlllIlIlI, lllllllllllIIllIlIlIllIIlllIIlII)) {
                throw new CommandException("commands.replaceitem.failed", new Object[] { lllllllllllIIllIlIlIllIIlllIlIll, lllllllllllIIllIlIlIllIIlllIIllI, lllllllllllIIllIlIlIllIIlllIIlII.func_190926_b() ? "Air" : lllllllllllIIllIlIlIllIIlllIIlII.getTextComponent() });
            }
            if (lllllllllllIIllIlIlIllIIllIlllIl instanceof EntityPlayer) {
                ((EntityPlayer)lllllllllllIIllIlIlIllIIllIlllIl).inventoryContainer.detectAndSendChanges();
            }
        }
        lllllllllllIIllIlIlIllIIllIllIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, lllllllllllIIllIlIlIllIIlllIIllI);
        CommandBase.notifyCommandListener(lllllllllllIIllIlIlIllIIllIllIlI, this, "commands.replaceitem.success", lllllllllllIIllIlIlIllIIlllIlIll, lllllllllllIIllIlIlIllIIlllIIllI, lllllllllllIIllIlIlIllIIlllIIlII.func_190926_b() ? "Air" : lllllllllllIIllIlIlIllIIlllIIlII.getTextComponent());
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllIlIlIllIIllIIIIII, final ICommandSender lllllllllllIIllIlIlIllIIllIIIIll, final String[] lllllllllllIIllIlIlIllIIllIIIIlI, @Nullable final BlockPos lllllllllllIIllIlIlIllIIllIIIIIl) {
        if (lllllllllllIIllIlIlIllIIllIIIIlI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIlIllIIllIIIIlI, "entity", "block");
        }
        if (lllllllllllIIllIlIlIllIIllIIIIlI.length == 2 && "entity".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIlIllIIllIIIIlI, lllllllllllIIllIlIlIllIIllIIIIII.getAllUsernames());
        }
        if (lllllllllllIIllIlIlIllIIllIIIIlI.length >= 2 && lllllllllllIIllIlIlIllIIllIIIIlI.length <= 4 && "block".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0])) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIIllIlIlIllIIllIIIIlI, 1, lllllllllllIIllIlIlIllIIllIIIIIl);
        }
        if ((lllllllllllIIllIlIlIllIIllIIIIlI.length != 3 || !"entity".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0])) && (lllllllllllIIllIlIlIllIIllIIIIlI.length != 5 || !"block".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0]))) {
            return ((lllllllllllIIllIlIlIllIIllIIIIlI.length != 4 || !"entity".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0])) && (lllllllllllIIllIlIlIllIIllIIIIlI.length != 6 || !"block".equals(lllllllllllIIllIlIlIllIIllIIIIlI[0]))) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIlIllIIllIIIIlI, Item.REGISTRY.getKeys());
        }
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIlIllIIllIIIIlI, CommandReplaceItem.SHORTCUTS.keySet());
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
