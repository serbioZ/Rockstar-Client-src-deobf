// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandKill extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllIIIIIIllIlllIlIll) {
        return "commands.kill.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllIIIIIIllIllIllllI, final ICommandSender lllllllllllIIllIIIIIIllIllIlllIl, final String[] lllllllllllIIllIIIIIIllIllIlllII) throws CommandException {
        if (lllllllllllIIllIIIIIIllIllIlllII.length == 0) {
            final EntityPlayer lllllllllllIIllIIIIIIllIlllIIIIl = CommandBase.getCommandSenderAsPlayer(lllllllllllIIllIIIIIIllIllIlllIl);
            lllllllllllIIllIIIIIIllIlllIIIIl.onKillCommand();
            CommandBase.notifyCommandListener(lllllllllllIIllIIIIIIllIllIlllIl, this, "commands.kill.successful", lllllllllllIIllIIIIIIllIlllIIIIl.getDisplayName());
        }
        else {
            final Entity lllllllllllIIllIIIIIIllIlllIIIII = CommandBase.getEntity(lllllllllllIIllIIIIIIllIllIllllI, lllllllllllIIllIIIIIIllIllIlllIl, lllllllllllIIllIIIIIIllIllIlllII[0]);
            lllllllllllIIllIIIIIIllIlllIIIII.onKillCommand();
            CommandBase.notifyCommandListener(lllllllllllIIllIIIIIIllIllIlllIl, this, "commands.kill.successful", lllllllllllIIllIIIIIIllIlllIIIII.getDisplayName());
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIllIIIIIIllIllIllIII, final int lllllllllllIIllIIIIIIllIllIlIllI) {
        return lllllllllllIIllIIIIIIllIllIlIllI == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllIIIIIIllIllIlIIlI, final ICommandSender lllllllllllIIllIIIIIIllIllIlIIIl, final String[] lllllllllllIIllIIIIIIllIllIIllIl, @Nullable final BlockPos lllllllllllIIllIIIIIIllIllIIllll) {
        return (lllllllllllIIllIIIIIIllIllIIllIl.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIIIIIIllIllIIllIl, lllllllllllIIllIIIIIIllIllIlIIlI.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "kill";
    }
}
