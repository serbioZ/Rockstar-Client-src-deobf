// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import javax.annotation.Nullable;
import java.util.Collection;
import net.minecraft.scoreboard.ScoreObjective;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.server.MinecraftServer;

public class CommandStats extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllIllIIlIlllIlllIlIlIIl, final ICommandSender lllllllllllIllIIlIlllIlllIlIlIII, final String[] lllllllllllIllIIlIlllIlllIlIIlll) throws CommandException {
        if (lllllllllllIllIIlIlllIlllIlIIlll.length < 1) {
            throw new WrongUsageException("commands.stats.usage", new Object[0]);
        }
        boolean lllllllllllIllIIlIlllIlllIlllIlI = false;
        if ("entity".equals(lllllllllllIllIIlIlllIlllIlIIlll[0])) {
            final boolean lllllllllllIllIIlIlllIlllIlllIll = false;
        }
        else {
            if (!"block".equals(lllllllllllIllIIlIlllIlllIlIIlll[0])) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            lllllllllllIllIIlIlllIlllIlllIlI = true;
        }
        int lllllllllllIllIIlIlllIlllIlllIII = 0;
        if (lllllllllllIllIIlIlllIlllIlllIlI) {
            if (lllllllllllIllIIlIlllIlllIlIIlll.length < 5) {
                throw new WrongUsageException("commands.stats.block.usage", new Object[0]);
            }
            final int lllllllllllIllIIlIlllIlllIlllIIl = 4;
        }
        else {
            if (lllllllllllIllIIlIlllIlllIlIIlll.length < 3) {
                throw new WrongUsageException("commands.stats.entity.usage", new Object[0]);
            }
            lllllllllllIllIIlIlllIlllIlllIII = 2;
        }
        final String lllllllllllIllIIlIlllIlllIllIlll = lllllllllllIllIIlIlllIlllIlIIlll[lllllllllllIllIIlIlllIlllIlllIII++];
        if ("set".equals(lllllllllllIllIIlIlllIlllIllIlll)) {
            if (lllllllllllIllIIlIlllIlllIlIIlll.length < lllllllllllIllIIlIlllIlllIlllIII + 3) {
                if (lllllllllllIllIIlIlllIlllIlllIII == 5) {
                    throw new WrongUsageException("commands.stats.block.set.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.set.usage", new Object[0]);
            }
        }
        else {
            if (!"clear".equals(lllllllllllIllIIlIlllIlllIllIlll)) {
                throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }
            if (lllllllllllIllIIlIlllIlllIlIIlll.length < lllllllllllIllIIlIlllIlllIlllIII + 1) {
                if (lllllllllllIllIIlIlllIlllIlllIII == 5) {
                    throw new WrongUsageException("commands.stats.block.clear.usage", new Object[0]);
                }
                throw new WrongUsageException("commands.stats.entity.clear.usage", new Object[0]);
            }
        }
        final CommandResultStats.Type lllllllllllIllIIlIlllIlllIllIllI = CommandResultStats.Type.getTypeByName(lllllllllllIllIIlIlllIlllIlIIlll[lllllllllllIllIIlIlllIlllIlllIII++]);
        if (lllllllllllIllIIlIlllIlllIllIllI == null) {
            throw new CommandException("commands.stats.failed", new Object[0]);
        }
        final World lllllllllllIllIIlIlllIlllIllIlIl = lllllllllllIllIIlIlllIlllIlIlIII.getEntityWorld();
        CommandResultStats lllllllllllIllIIlIlllIlllIllIIlI;
        if (lllllllllllIllIIlIlllIlllIlllIlI) {
            final BlockPos lllllllllllIllIIlIlllIlllIllIIIl = CommandBase.parseBlockPos(lllllllllllIllIIlIlllIlllIlIlIII, lllllllllllIllIIlIlllIlllIlIIlll, 1, false);
            final TileEntity lllllllllllIllIIlIlllIlllIllIIII = lllllllllllIllIIlIlllIlllIllIlIl.getTileEntity(lllllllllllIllIIlIlllIlllIllIIIl);
            if (lllllllllllIllIIlIlllIlllIllIIII == null) {
                throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { lllllllllllIllIIlIlllIlllIllIIIl.getX(), lllllllllllIllIIlIlllIlllIllIIIl.getY(), lllllllllllIllIIlIlllIlllIllIIIl.getZ() });
            }
            if (lllllllllllIllIIlIlllIlllIllIIII instanceof TileEntityCommandBlock) {
                final CommandResultStats lllllllllllIllIIlIlllIlllIllIlII = ((TileEntityCommandBlock)lllllllllllIllIIlIlllIlllIllIIII).getCommandResultStats();
            }
            else {
                if (!(lllllllllllIllIIlIlllIlllIllIIII instanceof TileEntitySign)) {
                    throw new CommandException("commands.stats.noCompatibleBlock", new Object[] { lllllllllllIllIIlIlllIlllIllIIIl.getX(), lllllllllllIllIIlIlllIlllIllIIIl.getY(), lllllllllllIllIIlIlllIlllIllIIIl.getZ() });
                }
                final CommandResultStats lllllllllllIllIIlIlllIlllIllIIll = ((TileEntitySign)lllllllllllIllIIlIlllIlllIllIIII).getStats();
            }
        }
        else {
            final Entity lllllllllllIllIIlIlllIlllIlIllll = CommandBase.getEntity(lllllllllllIllIIlIlllIlllIlIlIIl, lllllllllllIllIIlIlllIlllIlIlIII, lllllllllllIllIIlIlllIlllIlIIlll[1]);
            lllllllllllIllIIlIlllIlllIllIIlI = lllllllllllIllIIlIlllIlllIlIllll.getCommandStats();
        }
        if ("set".equals(lllllllllllIllIIlIlllIlllIllIlll)) {
            final String lllllllllllIllIIlIlllIlllIlIlllI = lllllllllllIllIIlIlllIlllIlIIlll[lllllllllllIllIIlIlllIlllIlllIII++];
            final String lllllllllllIllIIlIlllIlllIlIllIl = lllllllllllIllIIlIlllIlllIlIIlll[lllllllllllIllIIlIlllIlllIlllIII];
            if (lllllllllllIllIIlIlllIlllIlIlllI.isEmpty() || lllllllllllIllIIlIlllIlllIlIllIl.isEmpty()) {
                throw new CommandException("commands.stats.failed", new Object[0]);
            }
            CommandResultStats.setScoreBoardStat(lllllllllllIllIIlIlllIlllIllIIlI, lllllllllllIllIIlIlllIlllIllIllI, lllllllllllIllIIlIlllIlllIlIlllI, lllllllllllIllIIlIlllIlllIlIllIl);
            CommandBase.notifyCommandListener(lllllllllllIllIIlIlllIlllIlIlIII, this, "commands.stats.success", lllllllllllIllIIlIlllIlllIllIllI.getTypeName(), lllllllllllIllIIlIlllIlllIlIllIl, lllllllllllIllIIlIlllIlllIlIlllI);
        }
        else if ("clear".equals(lllllllllllIllIIlIlllIlllIllIlll)) {
            CommandResultStats.setScoreBoardStat(lllllllllllIllIIlIlllIlllIllIIlI, lllllllllllIllIIlIlllIlllIllIllI, null, null);
            CommandBase.notifyCommandListener(lllllllllllIllIIlIlllIlllIlIlIII, this, "commands.stats.cleared", lllllllllllIllIIlIlllIlllIllIllI.getTypeName());
        }
        if (lllllllllllIllIIlIlllIlllIlllIlI) {
            final BlockPos lllllllllllIllIIlIlllIlllIlIllII = CommandBase.parseBlockPos(lllllllllllIllIIlIlllIlllIlIlIII, lllllllllllIllIIlIlllIlllIlIIlll, 1, false);
            final TileEntity lllllllllllIllIIlIlllIlllIlIlIll = lllllllllllIllIIlIlllIlllIllIlIl.getTileEntity(lllllllllllIllIIlIlllIlllIlIllII);
            lllllllllllIllIIlIlllIlllIlIlIll.markDirty();
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIIlIlllIllIlllllIl, final int lllllllllllIllIIlIlllIllIlllllII) {
        return lllllllllllIllIIlIlllIllIlllllIl.length > 0 && "entity".equals(lllllllllllIllIIlIlllIllIlllllIl[0]) && lllllllllllIllIIlIlllIllIlllllII == 1;
    }
    
    protected List<String> getObjectiveNames(final MinecraftServer lllllllllllIllIIlIlllIlllIIIlIll) {
        final Collection<ScoreObjective> lllllllllllIllIIlIlllIlllIIIlIlI = lllllllllllIllIIlIlllIlllIIIlIll.worldServerForDimension(0).getScoreboard().getScoreObjectives();
        final List<String> lllllllllllIllIIlIlllIlllIIIlIIl = (List<String>)Lists.newArrayList();
        for (final ScoreObjective lllllllllllIllIIlIlllIlllIIIlIII : lllllllllllIllIIlIlllIlllIIIlIlI) {
            if (!lllllllllllIllIIlIlllIlllIIIlIII.getCriteria().isReadOnly()) {
                lllllllllllIllIIlIlllIlllIIIlIIl.add(lllllllllllIllIIlIlllIlllIIIlIII.getName());
            }
        }
        return lllllllllllIllIIlIlllIlllIIIlIIl;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIllIIlIlllIlllIIllIIl, final ICommandSender lllllllllllIllIIlIlllIlllIIllIII, final String[] lllllllllllIllIIlIlllIlllIIlIlll, @Nullable final BlockPos lllllllllllIllIIlIlllIlllIIlIllI) {
        if (lllllllllllIllIIlIlllIlllIIlIlll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIIlIlllIlllIIlIlll, "entity", "block");
        }
        if (lllllllllllIllIIlIlllIlllIIlIlll.length == 2 && "entity".equals(lllllllllllIllIIlIlllIlllIIlIlll[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIIlIlllIlllIIlIlll, lllllllllllIllIIlIlllIlllIIllIIl.getAllUsernames());
        }
        if (lllllllllllIllIIlIlllIlllIIlIlll.length >= 2 && lllllllllllIllIIlIlllIlllIIlIlll.length <= 4 && "block".equals(lllllllllllIllIIlIlllIlllIIlIlll[0])) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIllIIlIlllIlllIIlIlll, 1, lllllllllllIllIIlIlllIlllIIlIllI);
        }
        if ((lllllllllllIllIIlIlllIlllIIlIlll.length == 3 && "entity".equals(lllllllllllIllIIlIlllIlllIIlIlll[0])) || (lllllllllllIllIIlIlllIlllIIlIlll.length == 5 && "block".equals(lllllllllllIllIIlIlllIlllIIlIlll[0]))) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIIlIlllIlllIIlIlll, "set", "clear");
        }
        if ((lllllllllllIllIIlIlllIlllIIlIlll.length != 4 || !"entity".equals(lllllllllllIllIIlIlllIlllIIlIlll[0])) && (lllllllllllIllIIlIlllIlllIIlIlll.length != 6 || !"block".equals(lllllllllllIllIIlIlllIlllIIlIlll[0]))) {
            return ((lllllllllllIllIIlIlllIlllIIlIlll.length != 6 || !"entity".equals(lllllllllllIllIIlIlllIlllIIlIlll[0])) && (lllllllllllIllIIlIlllIlllIIlIlll.length != 8 || !"block".equals(lllllllllllIllIIlIlllIlllIIlIlll[0]))) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIIlIlllIlllIIlIlll, this.getObjectiveNames(lllllllllllIllIIlIlllIlllIIllIIl));
        }
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIIlIlllIlllIIlIlll, CommandResultStats.Type.getTypeNames());
    }
    
    @Override
    public String getCommandName() {
        return "stats";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIllIIlIlllIllllIIllII) {
        return "commands.stats.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
