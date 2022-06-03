// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandListPlayers extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIIllIIlIllIIIIlIll) {
        return "commands.players.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIIllIIlIllIIIIIlIl, final ICommandSender llllllllllllIlIIllIIlIllIIIIIlII, final String[] llllllllllllIlIIllIIlIllIIIIIIll) throws CommandException {
        final int llllllllllllIlIIllIIlIllIIIIIIlI = llllllllllllIlIIllIIlIllIIIIIlIl.getCurrentPlayerCount();
        llllllllllllIlIIllIIlIllIIIIIlII.addChatMessage(new TextComponentTranslation("commands.players.list", new Object[] { llllllllllllIlIIllIIlIllIIIIIIlI, llllllllllllIlIIllIIlIllIIIIIlIl.getMaxPlayers() }));
        llllllllllllIlIIllIIlIllIIIIIlII.addChatMessage(new TextComponentString(llllllllllllIlIIllIIlIllIIIIIlIl.getPlayerList().getFormattedListOfPlayers(llllllllllllIlIIllIIlIllIIIIIIll.length > 0 && "uuids".equalsIgnoreCase(llllllllllllIlIIllIIlIllIIIIIIll[0]))));
        llllllllllllIlIIllIIlIllIIIIIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIlIIllIIlIllIIIIIIlI);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandName() {
        return "list";
    }
}
