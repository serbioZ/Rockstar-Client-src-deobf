// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import com.mojang.authlib.GameProfile;
import net.minecraft.command.CommandException;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.command.ICommand;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandWhitelist extends CommandBase
{
    @Override
    public String getCommandName() {
        return "whitelist";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllIlIIllIllIIIIllII) {
        return "commands.whitelist.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllIlIIllIlIllllIIll, final ICommandSender lllllllllllIIllIlIIllIlIllllIllI, final String[] lllllllllllIIllIlIIllIlIllllIlIl, @Nullable final BlockPos lllllllllllIIllIlIIllIlIllllIlII) {
        if (lllllllllllIIllIlIIllIlIllllIlIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIIllIlIllllIlIl, "on", "off", "list", "add", "remove", "reload");
        }
        if (lllllllllllIIllIlIIllIlIllllIlIl.length == 2) {
            if ("remove".equals(lllllllllllIIllIlIIllIlIllllIlIl[0])) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIIllIlIllllIlIl, lllllllllllIIllIlIIllIlIllllIIll.getPlayerList().getWhitelistedPlayerNames());
            }
            if ("add".equals(lllllllllllIIllIlIIllIlIllllIlIl[0])) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIlIIllIlIllllIlIl, lllllllllllIIllIlIIllIlIllllIIll.getPlayerProfileCache().getUsernames());
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllIlIIllIllIIIIIlIl, final ICommandSender lllllllllllIIllIlIIllIlIllllllIl, final String[] lllllllllllIIllIlIIllIlIllllllII) throws CommandException {
        if (lllllllllllIIllIlIIllIlIllllllII.length < 1) {
            throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
        }
        if ("on".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().setWhiteListEnabled(true);
            CommandBase.notifyCommandListener(lllllllllllIIllIlIIllIlIllllllIl, this, "commands.whitelist.enabled", new Object[0]);
        }
        else if ("off".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().setWhiteListEnabled(false);
            CommandBase.notifyCommandListener(lllllllllllIIllIlIIllIlIllllllIl, this, "commands.whitelist.disabled", new Object[0]);
        }
        else if ("list".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            lllllllllllIIllIlIIllIlIllllllIl.addChatMessage(new TextComponentTranslation("commands.whitelist.list", new Object[] { lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().getWhitelistedPlayerNames().length, lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().getAvailablePlayerDat().length }));
            final String[] lllllllllllIIllIlIIllIllIIIIIIlI = lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().getWhitelistedPlayerNames();
            lllllllllllIIllIlIIllIlIllllllIl.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllIIllIlIIllIllIIIIIIlI)));
        }
        else if ("add".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            if (lllllllllllIIllIlIIllIlIllllllII.length < 2) {
                throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
            }
            final GameProfile lllllllllllIIllIlIIllIllIIIIIIIl = lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerProfileCache().getGameProfileForUsername(lllllllllllIIllIlIIllIlIllllllII[1]);
            if (lllllllllllIIllIlIIllIllIIIIIIIl == null) {
                throw new CommandException("commands.whitelist.add.failed", new Object[] { lllllllllllIIllIlIIllIlIllllllII[1] });
            }
            lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().addWhitelistedPlayer(lllllllllllIIllIlIIllIllIIIIIIIl);
            CommandBase.notifyCommandListener(lllllllllllIIllIlIIllIlIllllllIl, this, "commands.whitelist.add.success", lllllllllllIIllIlIIllIlIllllllII[1]);
        }
        else if ("remove".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            if (lllllllllllIIllIlIIllIlIllllllII.length < 2) {
                throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
            }
            final GameProfile lllllllllllIIllIlIIllIllIIIIIIII = lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().getWhitelistedPlayers().getByName(lllllllllllIIllIlIIllIlIllllllII[1]);
            if (lllllllllllIIllIlIIllIllIIIIIIII == null) {
                throw new CommandException("commands.whitelist.remove.failed", new Object[] { lllllllllllIIllIlIIllIlIllllllII[1] });
            }
            lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().removePlayerFromWhitelist(lllllllllllIIllIlIIllIllIIIIIIII);
            CommandBase.notifyCommandListener(lllllllllllIIllIlIIllIlIllllllIl, this, "commands.whitelist.remove.success", lllllllllllIIllIlIIllIlIllllllII[1]);
        }
        else if ("reload".equals(lllllllllllIIllIlIIllIlIllllllII[0])) {
            lllllllllllIIllIlIIllIllIIIIIlIl.getPlayerList().reloadWhitelist();
            CommandBase.notifyCommandListener(lllllllllllIIllIlIIllIlIllllllIl, this, "commands.whitelist.reloaded", new Object[0]);
        }
    }
}
