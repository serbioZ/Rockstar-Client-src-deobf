// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommand;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTException;
import net.minecraft.command.CommandException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandTestFor extends CommandBase
{
    @Override
    public void execute(final MinecraftServer llllllllllllIllllIlIlIlIIlIlIlIl, final ICommandSender llllllllllllIllllIlIlIlIIlIlIlII, final String[] llllllllllllIllllIlIlIlIIlIllIll) throws CommandException {
        if (llllllllllllIllllIlIlIlIIlIllIll.length < 1) {
            throw new WrongUsageException("commands.testfor.usage", new Object[0]);
        }
        final Entity llllllllllllIllllIlIlIlIIlIllIlI = CommandBase.getEntity(llllllllllllIllllIlIlIlIIlIlIlIl, llllllllllllIllllIlIlIlIIlIlIlII, llllllllllllIllllIlIlIlIIlIllIll[0]);
        NBTTagCompound llllllllllllIllllIlIlIlIIlIllIIl = null;
        if (llllllllllllIllllIlIlIlIIlIllIll.length >= 2) {
            try {
                llllllllllllIllllIlIlIlIIlIllIIl = JsonToNBT.getTagFromJson(CommandBase.buildString(llllllllllllIllllIlIlIlIIlIllIll, 1));
            }
            catch (NBTException llllllllllllIllllIlIlIlIIlIllIII) {
                throw new CommandException("commands.testfor.tagError", new Object[] { llllllllllllIllllIlIlIlIIlIllIII.getMessage() });
            }
        }
        if (llllllllllllIllllIlIlIlIIlIllIIl != null) {
            final NBTTagCompound llllllllllllIllllIlIlIlIIlIlIlll = CommandBase.entityToNBT(llllllllllllIllllIlIlIlIIlIllIlI);
            if (!NBTUtil.areNBTEquals(llllllllllllIllllIlIlIlIIlIllIIl, llllllllllllIllllIlIlIlIIlIlIlll, true)) {
                throw new CommandException("commands.testfor.failure", new Object[] { llllllllllllIllllIlIlIlIIlIllIlI.getName() });
            }
        }
        CommandBase.notifyCommandListener(llllllllllllIllllIlIlIlIIlIlIlII, this, "commands.testfor.success", llllllllllllIllllIlIlIlIIlIllIlI.getName());
    }
    
    @Override
    public String getCommandName() {
        return "testfor";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllllIlIlIlIIllIIllI) {
        return "commands.testfor.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIllllIlIlIlIIlIIIlll, final ICommandSender llllllllllllIllllIlIlIlIIlIIIllI, final String[] llllllllllllIllllIlIlIlIIlIIIlIl, @Nullable final BlockPos llllllllllllIllllIlIlIlIIlIIIlII) {
        return (llllllllllllIllllIlIlIlIIlIIIlIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllllIlIlIlIIlIIIlIl, llllllllllllIllllIlIlIlIIlIIIlll.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIllllIlIlIlIIlIIllIl, final int llllllllllllIllllIlIlIlIIlIIlIll) {
        return llllllllllllIllllIlIlIlIIlIIlIll == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
