// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.server.management.UserList;
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

public class CommandPardonPlayer extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllIllllllIIlIlIIllIlIIIl, final ICommandSender llllllllllIllllllIIlIlIIllIlIlII, final String[] llllllllllIllllllIIlIlIIllIlIIII, @Nullable final BlockPos llllllllllIllllllIIlIlIIllIlIIlI) {
        return (llllllllllIllllllIIlIlIIllIlIIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllIllllllIIlIlIIllIlIIII, llllllllllIllllllIIlIlIIllIlIIIl.getPlayerList().getBannedPlayers().getKeys()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllIllllllIIlIlIIlllIIIIl, final ICommandSender llllllllllIllllllIIlIlIIlllIIIII, final String[] llllllllllIllllllIIlIlIIllIlllll) throws CommandException {
        if (llllllllllIllllllIIlIlIIllIlllll.length != 1 || llllllllllIllllllIIlIlIIllIlllll[0].length() <= 0) {
            throw new WrongUsageException("commands.unban.usage", new Object[0]);
        }
        final GameProfile llllllllllIllllllIIlIlIIllIllllI = llllllllllIllllllIIlIlIIlllIIIIl.getPlayerList().getBannedPlayers().getBannedProfile(llllllllllIllllllIIlIlIIllIlllll[0]);
        if (llllllllllIllllllIIlIlIIllIllllI == null) {
            throw new CommandException("commands.unban.failed", new Object[] { llllllllllIllllllIIlIlIIllIlllll[0] });
        }
        ((UserList<GameProfile, V>)llllllllllIllllllIIlIlIIlllIIIIl.getPlayerList().getBannedPlayers()).removeEntry(llllllllllIllllllIIlIlIIllIllllI);
        CommandBase.notifyCommandListener(llllllllllIllllllIIlIlIIlllIIIII, this, "commands.unban.success", llllllllllIllllllIIlIlIIllIlllll[0]);
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer llllllllllIllllllIIlIlIIlllIllII, final ICommandSender llllllllllIllllllIIlIlIIlllIlIII) {
        return llllllllllIllllllIIlIlIIlllIllII.getPlayerList().getBannedPlayers().isLanServer() && super.checkPermission(llllllllllIllllllIIlIlIIlllIllII, llllllllllIllllllIIlIlIIlllIlIII);
    }
    
    @Override
    public String getCommandName() {
        return "pardon";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllIllllllIIlIlIIllllIIIl) {
        return "commands.unban.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
