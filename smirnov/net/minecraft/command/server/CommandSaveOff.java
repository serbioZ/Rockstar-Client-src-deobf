// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.world.WorldServer;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandSaveOff extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lIIIIlIIIIIll, final ICommandSender lIIIIlIIIIIlI, final String[] lIIIIlIIIIIIl) throws CommandException {
        boolean lIIIIlIIIIIII = false;
        for (int lIIIIIlllllll = 0; lIIIIIlllllll < lIIIIlIIIIIll.worldServers.length; ++lIIIIIlllllll) {
            if (lIIIIlIIIIIll.worldServers[lIIIIIlllllll] != null) {
                final WorldServer lIIIIIllllllI = lIIIIlIIIIIll.worldServers[lIIIIIlllllll];
                if (!lIIIIIllllllI.disableLevelSaving) {
                    lIIIIIllllllI.disableLevelSaving = true;
                    lIIIIlIIIIIII = true;
                }
            }
        }
        if (lIIIIlIIIIIII) {
            CommandBase.notifyCommandListener(lIIIIlIIIIIlI, this, "commands.save.disabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-off.alreadyOff", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lIIIIlIIIlIll) {
        return "commands.save-off.usage";
    }
    
    @Override
    public String getCommandName() {
        return "save-off";
    }
}
