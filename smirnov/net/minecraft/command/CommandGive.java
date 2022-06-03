// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class CommandGive extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllIIIIlIIIIIlllIlIIIlll, final ICommandSender lllllllllllIIIIlIIIIIlllIlIIIllI, final String[] lllllllllllIIIIlIIIIIlllIIllIlll) throws CommandException {
        if (lllllllllllIIIIlIIIIIlllIIllIlll.length < 2) {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
        final EntityPlayer lllllllllllIIIIlIIIIIlllIlIIIlII = CommandBase.getPlayer(lllllllllllIIIIlIIIIIlllIlIIIlll, lllllllllllIIIIlIIIIIlllIlIIIllI, lllllllllllIIIIlIIIIIlllIIllIlll[0]);
        final Item lllllllllllIIIIlIIIIIlllIlIIIIll = CommandBase.getItemByText(lllllllllllIIIIlIIIIIlllIlIIIllI, lllllllllllIIIIlIIIIIlllIIllIlll[1]);
        final int lllllllllllIIIIlIIIIIlllIlIIIIlI = (lllllllllllIIIIlIIIIIlllIIllIlll.length >= 3) ? CommandBase.parseInt(lllllllllllIIIIlIIIIIlllIIllIlll[2], 1, lllllllllllIIIIlIIIIIlllIlIIIIll.getItemStackLimit()) : 1;
        final int lllllllllllIIIIlIIIIIlllIlIIIIIl = (lllllllllllIIIIlIIIIIlllIIllIlll.length >= 4) ? CommandBase.parseInt(lllllllllllIIIIlIIIIIlllIIllIlll[3]) : 0;
        final ItemStack lllllllllllIIIIlIIIIIlllIlIIIIII = new ItemStack(lllllllllllIIIIlIIIIIlllIlIIIIll, lllllllllllIIIIlIIIIIlllIlIIIIlI, lllllllllllIIIIlIIIIIlllIlIIIIIl);
        if (lllllllllllIIIIlIIIIIlllIIllIlll.length >= 5) {
            final String lllllllllllIIIIlIIIIIlllIIllllll = CommandBase.buildString(lllllllllllIIIIlIIIIIlllIIllIlll, 4);
            try {
                lllllllllllIIIIlIIIIIlllIlIIIIII.setTagCompound(JsonToNBT.getTagFromJson(lllllllllllIIIIlIIIIIlllIIllllll));
            }
            catch (NBTException lllllllllllIIIIlIIIIIlllIIlllllI) {
                throw new CommandException("commands.give.tagError", new Object[] { lllllllllllIIIIlIIIIIlllIIlllllI.getMessage() });
            }
        }
        final boolean lllllllllllIIIIlIIIIIlllIIllllIl = lllllllllllIIIIlIIIIIlllIlIIIlII.inventory.addItemStackToInventory(lllllllllllIIIIlIIIIIlllIlIIIIII);
        if (lllllllllllIIIIlIIIIIlllIIllllIl) {
            lllllllllllIIIIlIIIIIlllIlIIIlII.world.playSound(null, lllllllllllIIIIlIIIIIlllIlIIIlII.posX, lllllllllllIIIIlIIIIIlllIlIIIlII.posY, lllllllllllIIIIlIIIIIlllIlIIIlII.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, ((lllllllllllIIIIlIIIIIlllIlIIIlII.getRNG().nextFloat() - lllllllllllIIIIlIIIIIlllIlIIIlII.getRNG().nextFloat()) * 0.7f + 1.0f) * 2.0f);
            lllllllllllIIIIlIIIIIlllIlIIIlII.inventoryContainer.detectAndSendChanges();
        }
        if (lllllllllllIIIIlIIIIIlllIIllllIl && lllllllllllIIIIlIIIIIlllIlIIIIII.func_190926_b()) {
            lllllllllllIIIIlIIIIIlllIlIIIIII.func_190920_e(1);
            lllllllllllIIIIlIIIIIlllIlIIIllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, lllllllllllIIIIlIIIIIlllIlIIIIlI);
            final EntityItem lllllllllllIIIIlIIIIIlllIIllllII = lllllllllllIIIIlIIIIIlllIlIIIlII.dropItem(lllllllllllIIIIlIIIIIlllIlIIIIII, false);
            if (lllllllllllIIIIlIIIIIlllIIllllII != null) {
                lllllllllllIIIIlIIIIIlllIIllllII.makeFakeItem();
            }
        }
        else {
            lllllllllllIIIIlIIIIIlllIlIIIllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, lllllllllllIIIIlIIIIIlllIlIIIIlI - lllllllllllIIIIlIIIIIlllIlIIIIII.func_190916_E());
            final EntityItem lllllllllllIIIIlIIIIIlllIIlllIll = lllllllllllIIIIlIIIIIlllIlIIIlII.dropItem(lllllllllllIIIIlIIIIIlllIlIIIIII, false);
            if (lllllllllllIIIIlIIIIIlllIIlllIll != null) {
                lllllllllllIIIIlIIIIIlllIIlllIll.setNoPickupDelay();
                lllllllllllIIIIlIIIIIlllIIlllIll.setOwner(lllllllllllIIIIlIIIIIlllIlIIIlII.getName());
            }
        }
        CommandBase.notifyCommandListener(lllllllllllIIIIlIIIIIlllIlIIIllI, this, "commands.give.success", lllllllllllIIIIlIIIIIlllIlIIIIII.getTextComponent(), lllllllllllIIIIlIIIIIlllIlIIIIlI, lllllllllllIIIIlIIIIIlllIlIIIlII.getName());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIIIlIIIIIlllIlIlIlII) {
        return "commands.give.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIIIlIIIIIlllIIlIIlII, final int lllllllllllIIIIlIIIIIlllIIlIIIll) {
        return lllllllllllIIIIlIIIIIlllIIlIIIll == 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIIIlIIIIIlllIIlIlIII, final ICommandSender lllllllllllIIIIlIIIIIlllIIlIlIll, final String[] lllllllllllIIIIlIIIIIlllIIlIIlll, @Nullable final BlockPos lllllllllllIIIIlIIIIIlllIIlIlIIl) {
        if (lllllllllllIIIIlIIIIIlllIIlIIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIIlIIIIIlllIIlIIlll, lllllllllllIIIIlIIIIIlllIIlIlIII.getAllUsernames());
        }
        return (lllllllllllIIIIlIIIIIlllIIlIIlll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIIlIIIIIlllIIlIIlll, Item.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "give";
    }
}
