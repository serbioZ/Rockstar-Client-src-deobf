// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import com.mojang.authlib.GameProfile;
import net.minecraft.command.ICommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandDeOp extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIlIlIIIlIlIllllIIll, final ICommandSender llllllllllllIIlIlIIIlIlIllllIllI, final String[] llllllllllllIIlIlIIIlIlIllllIlIl, @Nullable final BlockPos llllllllllllIIlIlIIIlIlIllllIlII) {
        return (llllllllllllIIlIlIIIlIlIllllIlIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlIlIIIlIlIllllIlIl, llllllllllllIIlIlIIIlIlIllllIIll.getPlayerList().getOppedPlayerNames()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIlIlIIIlIlIlllllllI, final ICommandSender llllllllllllIIlIlIIIlIlIllllllIl, final String[] llllllllllllIIlIlIIIlIllIIIIIIIl) throws CommandException {
        if (llllllllllllIIlIlIIIlIllIIIIIIIl.length != 1 || llllllllllllIIlIlIIIlIllIIIIIIIl[0].length() <= 0) {
            throw new WrongUsageException("commands.deop.usage", new Object[0]);
        }
        final GameProfile llllllllllllIIlIlIIIlIllIIIIIIII = llllllllllllIIlIlIIIlIlIlllllllI.getPlayerList().getOppedPlayers().getGameProfileFromName(llllllllllllIIlIlIIIlIllIIIIIIIl[0]);
        if (llllllllllllIIlIlIIIlIllIIIIIIII == null) {
            throw new CommandException("commands.deop.failed", new Object[] { llllllllllllIIlIlIIIlIllIIIIIIIl[0] });
        }
        llllllllllllIIlIlIIIlIlIlllllllI.getPlayerList().removeOp(llllllllllllIIlIlIIIlIllIIIIIIII);
        CommandBase.notifyCommandListener(llllllllllllIIlIlIIIlIlIllllllIl, this, "commands.deop.success", llllllllllllIIlIlIIIlIllIIIIIIIl[0]);
    }
    
    @Override
    public String getCommandName() {
        return "deop";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlIlIIIlIllIIIIlIlI) {
        return "commands.deop.usage";
    }
}
