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

public class CommandSaveOn extends CommandBase
{
    @Override
    public void execute(final MinecraftServer llllllllllllIIlllIIllIIlIlIlllIl, final ICommandSender llllllllllllIIlllIIllIIlIlIlllII, final String[] llllllllllllIIlllIIllIIlIllIIIlI) throws CommandException {
        boolean llllllllllllIIlllIIllIIlIllIIIIl = false;
        for (int llllllllllllIIlllIIllIIlIllIIIII = 0; llllllllllllIIlllIIllIIlIllIIIII < llllllllllllIIlllIIllIIlIlIlllIl.worldServers.length; ++llllllllllllIIlllIIllIIlIllIIIII) {
            if (llllllllllllIIlllIIllIIlIlIlllIl.worldServers[llllllllllllIIlllIIllIIlIllIIIII] != null) {
                final WorldServer llllllllllllIIlllIIllIIlIlIlllll = llllllllllllIIlllIIllIIlIlIlllIl.worldServers[llllllllllllIIlllIIllIIlIllIIIII];
                if (llllllllllllIIlllIIllIIlIlIlllll.disableLevelSaving) {
                    llllllllllllIIlllIIllIIlIlIlllll.disableLevelSaving = false;
                    llllllllllllIIlllIIllIIlIllIIIIl = true;
                }
            }
        }
        if (llllllllllllIIlllIIllIIlIllIIIIl) {
            CommandBase.notifyCommandListener(llllllllllllIIlllIIllIIlIlIlllII, this, "commands.save.enabled", new Object[0]);
            return;
        }
        throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlllIIllIIlIllIllII) {
        return "commands.save-on.usage";
    }
    
    @Override
    public String getCommandName() {
        return "save-on";
    }
}
