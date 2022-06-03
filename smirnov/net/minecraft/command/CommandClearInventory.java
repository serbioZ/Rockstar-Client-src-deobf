// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.item.Item;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandClearInventory extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlIIIIlIIllllIlIllII, final ICommandSender llllllllllllIlIIIIlIIllllIlIllll, final String[] llllllllllllIlIIIIlIIllllIlIlllI, @Nullable final BlockPos llllllllllllIlIIIIlIIllllIlIllIl) {
        if (llllllllllllIlIIIIlIIllllIlIlllI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIIIIlIIllllIlIlllI, llllllllllllIlIIIIlIIllllIlIllII.getAllUsernames());
        }
        return (llllllllllllIlIIIIlIIllllIlIlllI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIIIIlIIllllIlIlllI, Item.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIlIIIIlIIllllIlIlIII, final int llllllllllllIlIIIIlIIllllIlIIllI) {
        return llllllllllllIlIIIIlIIllllIlIIllI == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIIIIlIIlllllIlIlII) {
        return "commands.clear.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIIIIlIIllllIllllII, final ICommandSender llllllllllllIlIIIIlIIlllllIIIllI, final String[] llllllllllllIlIIIIlIIllllIlllIlI) throws CommandException {
        final EntityPlayerMP llllllllllllIlIIIIlIIlllllIIIlII = (llllllllllllIlIIIIlIIllllIlllIlI.length == 0) ? CommandBase.getCommandSenderAsPlayer(llllllllllllIlIIIIlIIlllllIIIllI) : CommandBase.getPlayer(llllllllllllIlIIIIlIIllllIllllII, llllllllllllIlIIIIlIIlllllIIIllI, llllllllllllIlIIIIlIIllllIlllIlI[0]);
        final Item llllllllllllIlIIIIlIIlllllIIIIll = (llllllllllllIlIIIIlIIllllIlllIlI.length >= 2) ? CommandBase.getItemByText(llllllllllllIlIIIIlIIlllllIIIllI, llllllllllllIlIIIIlIIllllIlllIlI[1]) : null;
        final int llllllllllllIlIIIIlIIlllllIIIIlI = (llllllllllllIlIIIIlIIllllIlllIlI.length >= 3) ? CommandBase.parseInt(llllllllllllIlIIIIlIIllllIlllIlI[2], -1) : -1;
        final int llllllllllllIlIIIIlIIlllllIIIIIl = (llllllllllllIlIIIIlIIllllIlllIlI.length >= 4) ? CommandBase.parseInt(llllllllllllIlIIIIlIIllllIlllIlI[3], -1) : -1;
        NBTTagCompound llllllllllllIlIIIIlIIlllllIIIIII = null;
        if (llllllllllllIlIIIIlIIllllIlllIlI.length >= 5) {
            try {
                llllllllllllIlIIIIlIIlllllIIIIII = JsonToNBT.getTagFromJson(CommandBase.buildString(llllllllllllIlIIIIlIIllllIlllIlI, 4));
            }
            catch (NBTException llllllllllllIlIIIIlIIllllIllllll) {
                throw new CommandException("commands.clear.tagError", new Object[] { llllllllllllIlIIIIlIIllllIllllll.getMessage() });
            }
        }
        if (llllllllllllIlIIIIlIIllllIlllIlI.length >= 2 && llllllllllllIlIIIIlIIlllllIIIIll == null) {
            throw new CommandException("commands.clear.failure", new Object[] { llllllllllllIlIIIIlIIlllllIIIlII.getName() });
        }
        final int llllllllllllIlIIIIlIIllllIlllllI = llllllllllllIlIIIIlIIlllllIIIlII.inventory.clearMatchingItems(llllllllllllIlIIIIlIIlllllIIIIll, llllllllllllIlIIIIlIIlllllIIIIlI, llllllllllllIlIIIIlIIlllllIIIIIl, llllllllllllIlIIIIlIIlllllIIIIII);
        llllllllllllIlIIIIlIIlllllIIIlII.inventoryContainer.detectAndSendChanges();
        if (!llllllllllllIlIIIIlIIlllllIIIlII.capabilities.isCreativeMode) {
            llllllllllllIlIIIIlIIlllllIIIlII.updateHeldItem();
        }
        llllllllllllIlIIIIlIIlllllIIIllI.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, llllllllllllIlIIIIlIIllllIlllllI);
        if (llllllllllllIlIIIIlIIllllIlllllI == 0) {
            throw new CommandException("commands.clear.failure", new Object[] { llllllllllllIlIIIIlIIlllllIIIlII.getName() });
        }
        if (llllllllllllIlIIIIlIIlllllIIIIIl == 0) {
            llllllllllllIlIIIIlIIlllllIIIllI.addChatMessage(new TextComponentTranslation("commands.clear.testing", new Object[] { llllllllllllIlIIIIlIIlllllIIIlII.getName(), llllllllllllIlIIIIlIIllllIlllllI }));
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllIlIIIIlIIlllllIIIllI, this, "commands.clear.success", llllllllllllIlIIIIlIIlllllIIIlII.getName(), llllllllllllIlIIIIlIIllllIlllllI);
        }
    }
    
    @Override
    public String getCommandName() {
        return "clear";
    }
}
