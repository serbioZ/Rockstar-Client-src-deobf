// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandListBans extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllllllllIIlIIlllIIl, final ICommandSender lllllllllllIIllllllllIIlIIlllIII, final String[] lllllllllllIIllllllllIIlIIllIlll, @Nullable final BlockPos lllllllllllIIllllllllIIlIIllIllI) {
        return (lllllllllllIIllllllllIIlIIllIlll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllllllllIIlIIllIlll, "players", "ips") : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllIIllllllllIIlIlIIlIIl, final ICommandSender lllllllllllIIllllllllIIlIlIIlIll) {
        return (lllllllllllIIllllllllIIlIlIIlIIl.getPlayerList().getBannedIPs().isLanServer() || lllllllllllIIllllllllIIlIlIIlIIl.getPlayerList().getBannedPlayers().isLanServer()) && super.checkPermission(lllllllllllIIllllllllIIlIlIIlIIl, lllllllllllIIllllllllIIlIlIIlIll);
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllllllllIIlIlIIIIIl, final ICommandSender lllllllllllIIllllllllIIlIIllllIl, final String[] lllllllllllIIllllllllIIlIIllllll) throws CommandException {
        if (lllllllllllIIllllllllIIlIIllllll.length >= 1 && "ips".equalsIgnoreCase(lllllllllllIIllllllllIIlIIllllll[0])) {
            lllllllllllIIllllllllIIlIIllllIl.addChatMessage(new TextComponentTranslation("commands.banlist.ips", new Object[] { lllllllllllIIllllllllIIlIlIIIIIl.getPlayerList().getBannedIPs().getKeys().length }));
            lllllllllllIIllllllllIIlIIllllIl.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllIIllllllllIIlIlIIIIIl.getPlayerList().getBannedIPs().getKeys())));
        }
        else {
            lllllllllllIIllllllllIIlIIllllIl.addChatMessage(new TextComponentTranslation("commands.banlist.players", new Object[] { lllllllllllIIllllllllIIlIlIIIIIl.getPlayerList().getBannedPlayers().getKeys().length }));
            lllllllllllIIllllllllIIlIIllllIl.addChatMessage(new TextComponentString(CommandBase.joinNiceString(lllllllllllIIllllllllIIlIlIIIIIl.getPlayerList().getBannedPlayers().getKeys())));
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllllllllIIlIlIIIllI) {
        return "commands.banlist.usage";
    }
    
    @Override
    public String getCommandName() {
        return "banlist";
    }
}
