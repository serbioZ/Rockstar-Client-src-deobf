// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.server.MinecraftServer;

public class CommandReload extends CommandBase
{
    @Override
    public String getCommandName() {
        return "reload";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllIIIllllllIllIllll) {
        return "commands.reload.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIllIIIllllllIllIIlIl, final ICommandSender llllllllllllIllIIIllllllIllIIlII, final String[] llllllllllllIllIIIllllllIllIIlll) throws CommandException {
        if (llllllllllllIllIIIllllllIllIIlll.length > 0) {
            throw new WrongUsageException("commands.reload.usage", new Object[0]);
        }
        llllllllllllIllIIIllllllIllIIlIl.func_193031_aM();
        CommandBase.notifyCommandListener(llllllllllllIllIIIllllllIllIIlII, this, "commands.reload.success", new Object[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
