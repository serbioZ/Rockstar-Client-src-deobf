// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayer;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandXP extends CommandBase
{
    @Override
    public String getCommandName() {
        return "xp";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllllllIIIIIllIlllll) {
        return "commands.xp.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllllllIIIIIllIIIIII, final ICommandSender lllllllllllIIllllllIIIIIlIllllll, final String[] lllllllllllIIllllllIIIIIlIlllllI, @Nullable final BlockPos lllllllllllIIllllllIIIIIlIllllIl) {
        return (lllllllllllIIllllllIIIIIlIlllllI.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllllllIIIIIlIlllllI, lllllllllllIIllllllIIIIIllIIIIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllllllIIIIIllIlIlII, final ICommandSender lllllllllllIIllllllIIIIIllIlIIll, final String[] lllllllllllIIllllllIIIIIllIIlIIl) throws CommandException {
        if (lllllllllllIIllllllIIIIIllIIlIIl.length <= 0) {
            throw new WrongUsageException("commands.xp.usage", new Object[0]);
        }
        String lllllllllllIIllllllIIIIIllIlIIIl = lllllllllllIIllllllIIIIIllIIlIIl[0];
        final boolean lllllllllllIIllllllIIIIIllIlIIII = lllllllllllIIllllllIIIIIllIlIIIl.endsWith("l") || lllllllllllIIllllllIIIIIllIlIIIl.endsWith("L");
        if (lllllllllllIIllllllIIIIIllIlIIII && lllllllllllIIllllllIIIIIllIlIIIl.length() > 1) {
            lllllllllllIIllllllIIIIIllIlIIIl = lllllllllllIIllllllIIIIIllIlIIIl.substring(0, lllllllllllIIllllllIIIIIllIlIIIl.length() - 1);
        }
        int lllllllllllIIllllllIIIIIllIIllll = CommandBase.parseInt(lllllllllllIIllllllIIIIIllIlIIIl);
        final boolean lllllllllllIIllllllIIIIIllIIlllI = lllllllllllIIllllllIIIIIllIIllll < 0;
        if (lllllllllllIIllllllIIIIIllIIlllI) {
            lllllllllllIIllllllIIIIIllIIllll = -lllllllllllIIllllllIIIIIllIIllll;
        }
        final EntityPlayer lllllllllllIIllllllIIIIIllIIllIl = (lllllllllllIIllllllIIIIIllIIlIIl.length > 1) ? CommandBase.getPlayer(lllllllllllIIllllllIIIIIllIlIlII, lllllllllllIIllllllIIIIIllIlIIll, lllllllllllIIllllllIIIIIllIIlIIl[1]) : CommandBase.getCommandSenderAsPlayer(lllllllllllIIllllllIIIIIllIlIIll);
        if (lllllllllllIIllllllIIIIIllIlIIII) {
            lllllllllllIIllllllIIIIIllIlIIll.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIIllllllIIIIIllIIllIl.experienceLevel);
            if (lllllllllllIIllllllIIIIIllIIlllI) {
                lllllllllllIIllllllIIIIIllIIllIl.addExperienceLevel(-lllllllllllIIllllllIIIIIllIIllll);
                CommandBase.notifyCommandListener(lllllllllllIIllllllIIIIIllIlIIll, this, "commands.xp.success.negative.levels", lllllllllllIIllllllIIIIIllIIllll, lllllllllllIIllllllIIIIIllIIllIl.getName());
            }
            else {
                lllllllllllIIllllllIIIIIllIIllIl.addExperienceLevel(lllllllllllIIllllllIIIIIllIIllll);
                CommandBase.notifyCommandListener(lllllllllllIIllllllIIIIIllIlIIll, this, "commands.xp.success.levels", lllllllllllIIllllllIIIIIllIIllll, lllllllllllIIllllllIIIIIllIIllIl.getName());
            }
        }
        else {
            lllllllllllIIllllllIIIIIllIlIIll.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIIllllllIIIIIllIIllIl.experienceTotal);
            if (lllllllllllIIllllllIIIIIllIIlllI) {
                throw new CommandException("commands.xp.failure.widthdrawXp", new Object[0]);
            }
            lllllllllllIIllllllIIIIIllIIllIl.addExperience(lllllllllllIIllllllIIIIIllIIllll);
            CommandBase.notifyCommandListener(lllllllllllIIllllllIIIIIllIlIIll, this, "commands.xp.success", lllllllllllIIllllllIIIIIllIIllll, lllllllllllIIllllllIIIIIllIIllIl.getName());
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIllllllIIIIIlIlllIII, final int lllllllllllIIllllllIIIIIlIllIllI) {
        return lllllllllllIIllllllIIIIIlIllIllI == 1;
    }
}
