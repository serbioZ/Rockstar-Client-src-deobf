// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.world.GameType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandPublishLocalServer extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIlllllIIIlIIIlIl) {
        return "commands.publish.usage";
    }
    
    @Override
    public String getCommandName() {
        return "publish";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIlllllIIIIllllll, final ICommandSender lllllllllllllIllIlllllIIIIlllllI, final String[] lllllllllllllIllIlllllIIIIllllIl) throws CommandException {
        final String lllllllllllllIllIlllllIIIIllllII = lllllllllllllIllIlllllIIIIllllll.shareToLAN(GameType.SURVIVAL, false);
        if (lllllllllllllIllIlllllIIIIllllII != null) {
            CommandBase.notifyCommandListener(lllllllllllllIllIlllllIIIIlllllI, this, "commands.publish.started", lllllllllllllIllIlllllIIIIllllII);
        }
        else {
            CommandBase.notifyCommandListener(lllllllllllllIllIlllllIIIIlllllI, this, "commands.publish.failed", new Object[0]);
        }
    }
}
