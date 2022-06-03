// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.server.MinecraftServer;

public class CommandSetPlayerTimeout extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "setidletimeout";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllIllllIlllIIlllIlIlIlII) {
        return "commands.setidletimeout.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllIllllIlllIIlllIlIIllIl, final ICommandSender llllllllllIllllIlllIIlllIlIIllII, final String[] llllllllllIllllIlllIIlllIlIIlIll) throws CommandException {
        if (llllllllllIllllIlllIIlllIlIIlIll.length != 1) {
            throw new WrongUsageException("commands.setidletimeout.usage", new Object[0]);
        }
        final int llllllllllIllllIlllIIlllIlIIlIlI = CommandBase.parseInt(llllllllllIllllIlllIIlllIlIIlIll[0], 0);
        llllllllllIllllIlllIIlllIlIIllIl.setPlayerIdleTimeout(llllllllllIllllIlllIIlllIlIIlIlI);
        CommandBase.notifyCommandListener(llllllllllIllllIlllIIlllIlIIllII, this, "commands.setidletimeout.success", llllllllllIllllIlllIIlllIlIIlIlI);
    }
}
