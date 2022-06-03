// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.server.management.UserList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.CommandException;
import java.util.regex.Matcher;
import net.minecraft.command.SyntaxErrorException;
import net.minecraft.command.ICommand;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandPardonIp extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllIlIlIIIIIIllIIIIlIllI, final ICommandSender lllllllllllIlIlIIIIIIllIIIIlIIII, final String[] lllllllllllIlIlIIIIIIllIIIIlIlII) throws CommandException {
        if (lllllllllllIlIlIIIIIIllIIIIlIlII.length != 1 || lllllllllllIlIlIIIIIIllIIIIlIlII[0].length() <= 1) {
            throw new WrongUsageException("commands.unbanip.usage", new Object[0]);
        }
        final Matcher lllllllllllIlIlIIIIIIllIIIIlIIll = CommandBanIp.IP_PATTERN.matcher(lllllllllllIlIlIIIIIIllIIIIlIlII[0]);
        if (lllllllllllIlIlIIIIIIllIIIIlIIll.matches()) {
            ((UserList<String, V>)lllllllllllIlIlIIIIIIllIIIIlIllI.getPlayerList().getBannedIPs()).removeEntry(lllllllllllIlIlIIIIIIllIIIIlIlII[0]);
            CommandBase.notifyCommandListener(lllllllllllIlIlIIIIIIllIIIIlIIII, this, "commands.unbanip.success", lllllllllllIlIlIIIIIIllIIIIlIlII[0]);
            return;
        }
        throw new SyntaxErrorException("commands.unbanip.invalid", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "pardon-ip";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllIlIlIIIIIIllIIIlIIIll, final ICommandSender lllllllllllIlIlIIIIIIllIIIlIIIlI) {
        return lllllllllllIlIlIIIIIIllIIIlIIIll.getPlayerList().getBannedIPs().isLanServer() && super.checkPermission(lllllllllllIlIlIIIIIIllIIIlIIIll, lllllllllllIlIlIIIIIIllIIIlIIIlI);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIlIIIIIIllIIIIlllIl) {
        return "commands.unbanip.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIlIIIIIIllIIIIIIllI, final ICommandSender lllllllllllIlIlIIIIIIllIIIIIlIIl, final String[] lllllllllllIlIlIIIIIIllIIIIIIlIl, @Nullable final BlockPos lllllllllllIlIlIIIIIIllIIIIIIlll) {
        return (lllllllllllIlIlIIIIIIllIIIIIIlIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIlIIIIIIllIIIIIIlIl, lllllllllllIlIlIIIIIIllIIIIIIllI.getPlayerList().getBannedIPs().getKeys()) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
