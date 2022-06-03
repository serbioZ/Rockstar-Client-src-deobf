// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandStop extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllllIlIllllIIIIIIIIIIll, final ICommandSender lllllllllllllIlIllllIIIIIIIIIIlI, final String[] lllllllllllllIlIllllIIIIIIIIIlIl) throws CommandException {
        if (lllllllllllllIlIllllIIIIIIIIIIll.worldServers != null) {
            CommandBase.notifyCommandListener(lllllllllllllIlIllllIIIIIIIIIIlI, this, "commands.stop.start", new Object[0]);
        }
        lllllllllllllIlIllllIIIIIIIIIIll.initiateShutdown();
    }
    
    @Override
    public String getCommandName() {
        return "stop";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIlIllllIIIIIIIIllII) {
        return "commands.stop.usage";
    }
}
