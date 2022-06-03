// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.scoreboard.Score;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Scoreboard;
import java.util.Collections;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandTrigger extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandName() {
        return "trigger";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIIIlllIlIIlIIlIlIlI, final ICommandSender llllllllllllIIIIlllIlIIlIIllIIII, final String[] llllllllllllIIIIlllIlIIlIIlIllll, @Nullable final BlockPos llllllllllllIIIIlllIlIIlIIlIlllI) {
        if (llllllllllllIIIIlllIlIIlIIlIllll.length == 1) {
            final Scoreboard llllllllllllIIIIlllIlIIlIIlIllIl = llllllllllllIIIIlllIlIIlIIlIlIlI.worldServerForDimension(0).getScoreboard();
            final List<String> llllllllllllIIIIlllIlIIlIIlIllII = (List<String>)Lists.newArrayList();
            for (final ScoreObjective llllllllllllIIIIlllIlIIlIIlIlIll : llllllllllllIIIIlllIlIIlIIlIllIl.getScoreObjectives()) {
                if (llllllllllllIIIIlllIlIIlIIlIlIll.getCriteria() == IScoreCriteria.TRIGGER) {
                    llllllllllllIIIIlllIlIIlIIlIllII.add(llllllllllllIIIIlllIlIIlIIlIlIll.getName());
                }
            }
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIIlllIlIIlIIlIllll, (String[])llllllllllllIIIIlllIlIIlIIlIllII.toArray(new String[llllllllllllIIIIlllIlIIlIIlIllII.size()]));
        }
        return (llllllllllllIIIIlllIlIIlIIlIllll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIIlllIlIIlIIlIllll, "add", "set") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIIIlllIlIIlIlIlIllI) {
        return "commands.trigger.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIIIlllIlIIlIlIIlIll, final ICommandSender llllllllllllIIIIlllIlIIlIlIIlIlI, final String[] llllllllllllIIIIlllIlIIlIIlllllI) throws CommandException {
        if (llllllllllllIIIIlllIlIIlIIlllllI.length < 3) {
            throw new WrongUsageException("commands.trigger.usage", new Object[0]);
        }
        EntityPlayerMP llllllllllllIIIIlllIlIIlIlIIIlll = null;
        if (llllllllllllIIIIlllIlIIlIlIIlIlI instanceof EntityPlayerMP) {
            final EntityPlayerMP llllllllllllIIIIlllIlIIlIlIIlIII = (EntityPlayerMP)llllllllllllIIIIlllIlIIlIlIIlIlI;
        }
        else {
            final Entity llllllllllllIIIIlllIlIIlIlIIIllI = llllllllllllIIIIlllIlIIlIlIIlIlI.getCommandSenderEntity();
            if (!(llllllllllllIIIIlllIlIIlIlIIIllI instanceof EntityPlayerMP)) {
                throw new CommandException("commands.trigger.invalidPlayer", new Object[0]);
            }
            llllllllllllIIIIlllIlIIlIlIIIlll = (EntityPlayerMP)llllllllllllIIIIlllIlIIlIlIIIllI;
        }
        final Scoreboard llllllllllllIIIIlllIlIIlIlIIIlIl = llllllllllllIIIIlllIlIIlIlIIlIll.worldServerForDimension(0).getScoreboard();
        final ScoreObjective llllllllllllIIIIlllIlIIlIlIIIlII = llllllllllllIIIIlllIlIIlIlIIIlIl.getObjective(llllllllllllIIIIlllIlIIlIIlllllI[0]);
        if (llllllllllllIIIIlllIlIIlIlIIIlII == null || llllllllllllIIIIlllIlIIlIlIIIlII.getCriteria() != IScoreCriteria.TRIGGER) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { llllllllllllIIIIlllIlIIlIIlllllI[0] });
        }
        final int llllllllllllIIIIlllIlIIlIlIIIIll = CommandBase.parseInt(llllllllllllIIIIlllIlIIlIIlllllI[2]);
        if (!llllllllllllIIIIlllIlIIlIlIIIlIl.entityHasObjective(llllllllllllIIIIlllIlIIlIlIIIlll.getName(), llllllllllllIIIIlllIlIIlIlIIIlII)) {
            throw new CommandException("commands.trigger.invalidObjective", new Object[] { llllllllllllIIIIlllIlIIlIIlllllI[0] });
        }
        final Score llllllllllllIIIIlllIlIIlIlIIIIlI = llllllllllllIIIIlllIlIIlIlIIIlIl.getOrCreateScore(llllllllllllIIIIlllIlIIlIlIIIlll.getName(), llllllllllllIIIIlllIlIIlIlIIIlII);
        if (llllllllllllIIIIlllIlIIlIlIIIIlI.isLocked()) {
            throw new CommandException("commands.trigger.disabled", new Object[] { llllllllllllIIIIlllIlIIlIIlllllI[0] });
        }
        if ("set".equals(llllllllllllIIIIlllIlIIlIIlllllI[1])) {
            llllllllllllIIIIlllIlIIlIlIIIIlI.setScorePoints(llllllllllllIIIIlllIlIIlIlIIIIll);
        }
        else {
            if (!"add".equals(llllllllllllIIIIlllIlIIlIIlllllI[1])) {
                throw new CommandException("commands.trigger.invalidMode", new Object[] { llllllllllllIIIIlllIlIIlIIlllllI[1] });
            }
            llllllllllllIIIIlllIlIIlIlIIIIlI.increaseScore(llllllllllllIIIIlllIlIIlIlIIIIll);
        }
        llllllllllllIIIIlllIlIIlIlIIIIlI.setLocked(true);
        if (llllllllllllIIIIlllIlIIlIlIIIlll.interactionManager.isCreative()) {
            CommandBase.notifyCommandListener(llllllllllllIIIIlllIlIIlIlIIlIlI, this, "commands.trigger.success", llllllllllllIIIIlllIlIIlIIlllllI[0], llllllllllllIIIIlllIlIIlIIlllllI[1], llllllllllllIIIIlllIlIIlIIlllllI[2]);
        }
    }
}
