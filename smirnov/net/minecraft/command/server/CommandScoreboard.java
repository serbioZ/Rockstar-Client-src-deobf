// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import java.util.Collections;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.Team;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.scoreboard.ScorePlayerTeam;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.command.WrongUsageException;
import java.util.Set;
import net.minecraft.command.EntitySelector;
import net.minecraft.entity.player.EntityPlayer;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.command.CommandResultStats;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.command.ICommand;
import net.minecraft.nbt.NBTException;
import net.minecraft.command.CommandException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.command.SyntaxErrorException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandScoreboard extends CommandBase
{
    protected void addPlayerScore(final ICommandSender llllllllllllIllIlIIIIIIllIIlIIIl, final String[] llllllllllllIllIlIIIIIIllIlIIIII, int llllllllllllIllIlIIIIIIllIIlllll, final MinecraftServer llllllllllllIllIlIIIIIIllIIIlllI) throws CommandException {
        final String llllllllllllIllIlIIIIIIllIIlllIl = llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllll - 1];
        final int llllllllllllIllIlIIIIIIllIIlllII = llllllllllllIllIlIIIIIIllIIlllll;
        final String llllllllllllIllIlIIIIIIllIIllIll = CommandBase.getEntityName(llllllllllllIllIlIIIIIIllIIIlllI, llllllllllllIllIlIIIIIIllIIlIIIl, llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllll++]);
        if (llllllllllllIllIlIIIIIIllIIllIll.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { llllllllllllIllIlIIIIIIllIIllIll, 40 });
        }
        final ScoreObjective llllllllllllIllIlIIIIIIllIIllIlI = this.convertToObjective(llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllll++], true, llllllllllllIllIlIIIIIIllIIIlllI);
        final int llllllllllllIllIlIIIIIIllIIllIIl = "set".equalsIgnoreCase(llllllllllllIllIlIIIIIIllIIlllIl) ? CommandBase.parseInt(llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllll++]) : CommandBase.parseInt(llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllll++], 0);
        if (llllllllllllIllIlIIIIIIllIlIIIII.length > llllllllllllIllIlIIIIIIllIIlllll) {
            final Entity llllllllllllIllIlIIIIIIllIIllIII = CommandBase.getEntity(llllllllllllIllIlIIIIIIllIIIlllI, llllllllllllIllIlIIIIIIllIIlIIIl, llllllllllllIllIlIIIIIIllIlIIIII[llllllllllllIllIlIIIIIIllIIlllII]);
            try {
                final NBTTagCompound llllllllllllIllIlIIIIIIllIIlIlll = JsonToNBT.getTagFromJson(CommandBase.buildString(llllllllllllIllIlIIIIIIllIlIIIII, llllllllllllIllIlIIIIIIllIIlllll));
                final NBTTagCompound llllllllllllIllIlIIIIIIllIIlIllI = CommandBase.entityToNBT(llllllllllllIllIlIIIIIIllIIllIII);
                if (!NBTUtil.areNBTEquals(llllllllllllIllIlIIIIIIllIIlIlll, llllllllllllIllIlIIIIIIllIIlIllI, true)) {
                    throw new CommandException("commands.scoreboard.players.set.tagMismatch", new Object[] { llllllllllllIllIlIIIIIIllIIllIll });
                }
            }
            catch (NBTException llllllllllllIllIlIIIIIIllIIlIlIl) {
                throw new CommandException("commands.scoreboard.players.set.tagError", new Object[] { llllllllllllIllIlIIIIIIllIIlIlIl.getMessage() });
            }
        }
        final Scoreboard llllllllllllIllIlIIIIIIllIIlIlII = this.getScoreboard(llllllllllllIllIlIIIIIIllIIIlllI);
        final Score llllllllllllIllIlIIIIIIllIIlIIll = llllllllllllIllIlIIIIIIllIIlIlII.getOrCreateScore(llllllllllllIllIlIIIIIIllIIllIll, llllllllllllIllIlIIIIIIllIIllIlI);
        if ("set".equalsIgnoreCase(llllllllllllIllIlIIIIIIllIIlllIl)) {
            llllllllllllIllIlIIIIIIllIIlIIll.setScorePoints(llllllllllllIllIlIIIIIIllIIllIIl);
        }
        else if ("add".equalsIgnoreCase(llllllllllllIllIlIIIIIIllIIlllIl)) {
            llllllllllllIllIlIIIIIIllIIlIIll.increaseScore(llllllllllllIllIlIIIIIIllIIllIIl);
        }
        else {
            llllllllllllIllIlIIIIIIllIIlIIll.decreaseScore(llllllllllllIllIlIIIIIIllIIllIIl);
        }
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIllIIlIIIl, this, "commands.scoreboard.players.set.success", llllllllllllIllIlIIIIIIllIIllIlI.getName(), llllllllllllIllIlIIIIIIllIIllIll, llllllllllllIllIlIIIIIIllIIlIIll.getScorePoints());
    }
    
    protected void listPlayers(final ICommandSender llllllllllllIllIlIIIIIIlllIIIlIl, final String[] llllllllllllIllIlIIIIIIllIlllIII, final int llllllllllllIllIlIIIIIIllIllIlll, final MinecraftServer llllllllllllIllIlIIIIIIlllIIIIlI) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlllIIIIIl = this.getScoreboard(llllllllllllIllIlIIIIIIlllIIIIlI);
        if (llllllllllllIllIlIIIIIIllIlllIII.length > llllllllllllIllIlIIIIIIllIllIlll) {
            final String llllllllllllIllIlIIIIIIlllIIIIII = CommandBase.getEntityName(llllllllllllIllIlIIIIIIlllIIIIlI, llllllllllllIllIlIIIIIIlllIIIlIl, llllllllllllIllIlIIIIIIllIlllIII[llllllllllllIllIlIIIIIIllIllIlll]);
            final Map<ScoreObjective, Score> llllllllllllIllIlIIIIIIllIllllll = llllllllllllIllIlIIIIIIlllIIIIIl.getObjectivesForEntity(llllllllllllIllIlIIIIIIlllIIIIII);
            llllllllllllIllIlIIIIIIlllIIIlIl.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIllIlIIIIIIllIllllll.size());
            if (llllllllllllIllIlIIIIIIllIllllll.isEmpty()) {
                throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] { llllllllllllIllIlIIIIIIlllIIIIII });
            }
            final TextComponentTranslation llllllllllllIllIlIIIIIIllIlllllI = new TextComponentTranslation("commands.scoreboard.players.list.player.count", new Object[] { llllllllllllIllIlIIIIIIllIllllll.size(), llllllllllllIllIlIIIIIIlllIIIIII });
            llllllllllllIllIlIIIIIIllIlllllI.getStyle().setColor(TextFormatting.DARK_GREEN);
            llllllllllllIllIlIIIIIIlllIIIlIl.addChatMessage(llllllllllllIllIlIIIIIIllIlllllI);
            for (final Score llllllllllllIllIlIIIIIIllIllllIl : llllllllllllIllIlIIIIIIllIllllll.values()) {
                llllllllllllIllIlIIIIIIlllIIIlIl.addChatMessage(new TextComponentTranslation("commands.scoreboard.players.list.player.entry", new Object[] { llllllllllllIllIlIIIIIIllIllllIl.getScorePoints(), llllllllllllIllIlIIIIIIllIllllIl.getObjective().getDisplayName(), llllllllllllIllIlIIIIIIllIllllIl.getObjective().getName() }));
            }
        }
        else {
            final Collection<String> llllllllllllIllIlIIIIIIllIllllII = llllllllllllIllIlIIIIIIlllIIIIIl.getObjectiveNames();
            llllllllllllIllIlIIIIIIlllIIIlIl.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIllIlIIIIIIllIllllII.size());
            if (llllllllllllIllIlIIIIIIllIllllII.isEmpty()) {
                throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
            }
            final TextComponentTranslation llllllllllllIllIlIIIIIIllIlllIll = new TextComponentTranslation("commands.scoreboard.players.list.count", new Object[] { llllllllllllIllIlIIIIIIllIllllII.size() });
            llllllllllllIllIlIIIIIIllIlllIll.getStyle().setColor(TextFormatting.DARK_GREEN);
            llllllllllllIllIlIIIIIIlllIIIlIl.addChatMessage(llllllllllllIllIlIIIIIIllIlllIll);
            llllllllllllIllIlIIIIIIlllIIIlIl.addChatMessage(new TextComponentString(CommandBase.joinNiceString(llllllllllllIllIlIIIIIIllIllllII.toArray())));
        }
    }
    
    protected void joinTeam(final ICommandSender llllllllllllIllIlIIIIIlIIllIIIll, final String[] llllllllllllIllIlIIIIIlIIllIIIlI, int llllllllllllIllIlIIIIIlIIllIIIIl, final MinecraftServer llllllllllllIllIlIIIIIlIIllIIIII) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIIllIllIl = this.getScoreboard(llllllllllllIllIlIIIIIlIIllIIIII);
        final String llllllllllllIllIlIIIIIlIIllIllII = llllllllllllIllIlIIIIIlIIllIIIlI[llllllllllllIllIlIIIIIlIIllIIIIl++];
        final Set<String> llllllllllllIllIlIIIIIlIIllIlIll = (Set<String>)Sets.newHashSet();
        final Set<String> llllllllllllIllIlIIIIIlIIllIlIlI = (Set<String>)Sets.newHashSet();
        if (llllllllllllIllIlIIIIIlIIllIIIll instanceof EntityPlayer && llllllllllllIllIlIIIIIlIIllIIIIl == llllllllllllIllIlIIIIIlIIllIIIlI.length) {
            final String llllllllllllIllIlIIIIIlIIllIlIIl = CommandBase.getCommandSenderAsPlayer(llllllllllllIllIlIIIIIlIIllIIIll).getName();
            if (llllllllllllIllIlIIIIIlIIllIllIl.addPlayerToTeam(llllllllllllIllIlIIIIIlIIllIlIIl, llllllllllllIllIlIIIIIlIIllIllII)) {
                llllllllllllIllIlIIIIIlIIllIlIll.add(llllllllllllIllIlIIIIIlIIllIlIIl);
            }
            else {
                llllllllllllIllIlIIIIIlIIllIlIlI.add(llllllllllllIllIlIIIIIlIIllIlIIl);
            }
        }
        else {
            while (llllllllllllIllIlIIIIIlIIllIIIIl < llllllllllllIllIlIIIIIlIIllIIIlI.length) {
                final String llllllllllllIllIlIIIIIlIIllIlIII = llllllllllllIllIlIIIIIlIIllIIIlI[llllllllllllIllIlIIIIIlIIllIIIIl++];
                if (EntitySelector.hasArguments(llllllllllllIllIlIIIIIlIIllIlIII)) {
                    for (final Entity llllllllllllIllIlIIIIIlIIllIIlll : CommandBase.getEntityList(llllllllllllIllIlIIIIIlIIllIIIII, llllllllllllIllIlIIIIIlIIllIIIll, llllllllllllIllIlIIIIIlIIllIlIII)) {
                        final String llllllllllllIllIlIIIIIlIIllIIllI = CommandBase.getEntityName(llllllllllllIllIlIIIIIlIIllIIIII, llllllllllllIllIlIIIIIlIIllIIIll, llllllllllllIllIlIIIIIlIIllIIlll.getCachedUniqueIdString());
                        if (llllllllllllIllIlIIIIIlIIllIllIl.addPlayerToTeam(llllllllllllIllIlIIIIIlIIllIIllI, llllllllllllIllIlIIIIIlIIllIllII)) {
                            llllllllllllIllIlIIIIIlIIllIlIll.add(llllllllllllIllIlIIIIIlIIllIIllI);
                        }
                        else {
                            llllllllllllIllIlIIIIIlIIllIlIlI.add(llllllllllllIllIlIIIIIlIIllIIllI);
                        }
                    }
                }
                else {
                    final String llllllllllllIllIlIIIIIlIIllIIlIl = CommandBase.getEntityName(llllllllllllIllIlIIIIIlIIllIIIII, llllllllllllIllIlIIIIIlIIllIIIll, llllllllllllIllIlIIIIIlIIllIlIII);
                    if (llllllllllllIllIlIIIIIlIIllIllIl.addPlayerToTeam(llllllllllllIllIlIIIIIlIIllIIlIl, llllllllllllIllIlIIIIIlIIllIllII)) {
                        llllllllllllIllIlIIIIIlIIllIlIll.add(llllllllllllIllIlIIIIIlIIllIIlIl);
                    }
                    else {
                        llllllllllllIllIlIIIIIlIIllIlIlI.add(llllllllllllIllIlIIIIIlIIllIIlIl);
                    }
                }
            }
        }
        if (!llllllllllllIllIlIIIIIlIIllIlIll.isEmpty()) {
            llllllllllllIllIlIIIIIlIIllIIIll.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllIllIlIIIIIlIIllIlIll.size());
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIIllIIIll, this, "commands.scoreboard.teams.join.success", llllllllllllIllIlIIIIIlIIllIlIll.size(), llllllllllllIllIlIIIIIlIIllIllII, CommandBase.joinNiceString(llllllllllllIllIlIIIIIlIIllIlIll.toArray(new String[llllllllllllIllIlIIIIIlIIllIlIll.size()])));
        }
        if (!llllllllllllIllIlIIIIIlIIllIlIlI.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.join.failure", new Object[] { llllllllllllIllIlIIIIIlIIllIlIlI.size(), llllllllllllIllIlIIIIIlIIllIllII, CommandBase.joinNiceString(llllllllllllIllIlIIIIIlIIllIlIlI.toArray(new String[llllllllllllIllIlIIIIIlIIllIlIlI.size()])) });
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIllIlIIIIIIIlIlIlIll, final int llllllllllllIllIlIIIIIIIlIlIlIlI) {
        if (!"players".equalsIgnoreCase(llllllllllllIllIlIIIIIIIlIlIlIll[0])) {
            return "teams".equalsIgnoreCase(llllllllllllIllIlIIIIIIIlIlIlIll[0]) && llllllllllllIllIlIIIIIIIlIlIlIlI == 2;
        }
        if (llllllllllllIllIlIIIIIIIlIlIlIll.length > 1 && "operation".equalsIgnoreCase(llllllllllllIllIlIIIIIIIlIlIlIll[1])) {
            return llllllllllllIllIlIIIIIIIlIlIlIlI == 2 || llllllllllllIllIlIIIIIIIlIlIlIlI == 5;
        }
        return llllllllllllIllIlIIIIIIIlIlIlIlI == 2;
    }
    
    protected void addTeam(final ICommandSender llllllllllllIllIlIIIIIlIllIllIIl, final String[] llllllllllllIllIlIIIIIlIlllIIIII, int llllllllllllIllIlIIIIIlIllIlllll, final MinecraftServer llllllllllllIllIlIIIIIlIllIllllI) throws CommandException {
        final String llllllllllllIllIlIIIIIlIllIlllIl = llllllllllllIllIlIIIIIlIlllIIIII[llllllllllllIllIlIIIIIlIllIlllll++];
        final Scoreboard llllllllllllIllIlIIIIIlIllIlllII = this.getScoreboard(llllllllllllIllIlIIIIIlIllIllllI);
        if (llllllllllllIllIlIIIIIlIllIlllII.getTeam(llllllllllllIllIlIIIIIlIllIlllIl) != null) {
            throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] { llllllllllllIllIlIIIIIlIllIlllIl });
        }
        if (llllllllllllIllIlIIIIIlIllIlllIl.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.teams.add.tooLong", new Object[] { llllllllllllIllIlIIIIIlIllIlllIl, 16 });
        }
        if (llllllllllllIllIlIIIIIlIllIlllIl.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (llllllllllllIllIlIIIIIlIlllIIIII.length > llllllllllllIllIlIIIIIlIllIlllll) {
            final String llllllllllllIllIlIIIIIlIllIllIll = CommandBase.getChatComponentFromNthArg(llllllllllllIllIlIIIIIlIllIllIIl, llllllllllllIllIlIIIIIlIlllIIIII, llllllllllllIllIlIIIIIlIllIlllll).getUnformattedText();
            if (llllllllllllIllIlIIIIIlIllIllIll.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.teams.add.displayTooLong", new Object[] { llllllllllllIllIlIIIIIlIllIllIll, 32 });
            }
            if (llllllllllllIllIlIIIIIlIllIllIll.isEmpty()) {
                llllllllllllIllIlIIIIIlIllIlllII.createTeam(llllllllllllIllIlIIIIIlIllIlllIl);
            }
            else {
                llllllllllllIllIlIIIIIlIllIlllII.createTeam(llllllllllllIllIlIIIIIlIllIlllIl).setTeamName(llllllllllllIllIlIIIIIlIllIllIll);
            }
        }
        else {
            llllllllllllIllIlIIIIIlIllIlllII.createTeam(llllllllllllIllIlIIIIIlIllIlllIl);
        }
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIllIllIIl, this, "commands.scoreboard.teams.add.success", llllllllllllIllIlIIIIIlIllIlllIl);
    }
    
    private boolean handleUserWildcards(final MinecraftServer llllllllllllIllIlIIIIIllIIlllIII, final ICommandSender llllllllllllIllIlIIIIIllIlIIIIll, final String[] llllllllllllIllIlIIIIIllIIllIllI) throws CommandException {
        int llllllllllllIllIlIIIIIllIlIIIIIl = -1;
        for (int llllllllllllIllIlIIIIIllIlIIIIII = 0; llllllllllllIllIlIIIIIllIlIIIIII < llllllllllllIllIlIIIIIllIIllIllI.length; ++llllllllllllIllIlIIIIIllIlIIIIII) {
            if (this.isUsernameIndex(llllllllllllIllIlIIIIIllIIllIllI, llllllllllllIllIlIIIIIllIlIIIIII) && "*".equals(llllllllllllIllIlIIIIIllIIllIllI[llllllllllllIllIlIIIIIllIlIIIIII])) {
                if (llllllllllllIllIlIIIIIllIlIIIIIl >= 0) {
                    throw new CommandException("commands.scoreboard.noMultiWildcard", new Object[0]);
                }
                llllllllllllIllIlIIIIIllIlIIIIIl = llllllllllllIllIlIIIIIllIlIIIIII;
            }
        }
        if (llllllllllllIllIlIIIIIllIlIIIIIl < 0) {
            return false;
        }
        final List<String> llllllllllllIllIlIIIIIllIIllllll = (List<String>)Lists.newArrayList((Iterable)this.getScoreboard(llllllllllllIllIlIIIIIllIIlllIII).getObjectiveNames());
        final String llllllllllllIllIlIIIIIllIIlllllI = llllllllllllIllIlIIIIIllIIllIllI[llllllllllllIllIlIIIIIllIlIIIIIl];
        final List<String> llllllllllllIllIlIIIIIllIIllllIl = (List<String>)Lists.newArrayList();
        for (final String llllllllllllIllIlIIIIIllIIllllII : llllllllllllIllIlIIIIIllIIllllll) {
            llllllllllllIllIlIIIIIllIIllIllI[llllllllllllIllIlIIIIIllIlIIIIIl] = llllllllllllIllIlIIIIIllIIllllII;
            try {
                this.execute(llllllllllllIllIlIIIIIllIIlllIII, llllllllllllIllIlIIIIIllIlIIIIll, llllllllllllIllIlIIIIIllIIllIllI);
                llllllllllllIllIlIIIIIllIIllllIl.add(llllllllllllIllIlIIIIIllIIllllII);
            }
            catch (CommandException llllllllllllIllIlIIIIIllIIlllIll) {
                final TextComponentTranslation llllllllllllIllIlIIIIIllIIlllIlI = new TextComponentTranslation(llllllllllllIllIlIIIIIllIIlllIll.getMessage(), llllllllllllIllIlIIIIIllIIlllIll.getErrorObjects());
                llllllllllllIllIlIIIIIllIIlllIlI.getStyle().setColor(TextFormatting.RED);
                llllllllllllIllIlIIIIIllIlIIIIll.addChatMessage(llllllllllllIllIlIIIIIllIIlllIlI);
            }
        }
        llllllllllllIllIlIIIIIllIIllIllI[llllllllllllIllIlIIIIIllIlIIIIIl] = llllllllllllIllIlIIIIIllIIlllllI;
        llllllllllllIllIlIIIIIllIlIIIIll.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllIllIlIIIIIllIIllllIl.size());
        if (llllllllllllIllIlIIIIIllIIllllIl.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.allMatchesFailed", new Object[0]);
        }
        return true;
    }
    
    protected void removeTeam(final ICommandSender llllllllllllIllIlIIIIIlIlIlIllII, final String[] llllllllllllIllIlIIIIIlIlIlIlIll, final int llllllllllllIllIlIIIIIlIlIlIlIlI, final MinecraftServer llllllllllllIllIlIIIIIlIlIlIIIlI) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIlIlIlIII = this.getScoreboard(llllllllllllIllIlIIIIIlIlIlIIIlI);
        final ScorePlayerTeam llllllllllllIllIlIIIIIlIlIlIIlll = this.convertToTeam(llllllllllllIllIlIIIIIlIlIlIlIll[llllllllllllIllIlIIIIIlIlIlIlIlI], llllllllllllIllIlIIIIIlIlIlIIIlI);
        if (llllllllllllIllIlIIIIIlIlIlIIlll != null) {
            llllllllllllIllIlIIIIIlIlIlIlIII.removeTeam(llllllllllllIllIlIIIIIlIlIlIIlll);
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIlIlIllII, this, "commands.scoreboard.teams.remove.success", llllllllllllIllIlIIIIIlIlIlIIlll.getRegisteredName());
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllIlIIIIIllIlIllllI) {
        return "commands.scoreboard.usage";
    }
    
    protected void applyPlayerOperation(final ICommandSender llllllllllllIllIlIIIIIIlIIlIIIlI, final String[] llllllllllllIllIlIIIIIIlIIlIIIIl, int llllllllllllIllIlIIIIIIlIIlIIIII, final MinecraftServer llllllllllllIllIlIIIIIIlIIIlllll) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlIIIllllI = this.getScoreboard(llllllllllllIllIlIIIIIIlIIIlllll);
        final String llllllllllllIllIlIIIIIIlIIIlllIl = CommandBase.getEntityName(llllllllllllIllIlIIIIIIlIIIlllll, llllllllllllIllIlIIIIIIlIIlIIIlI, llllllllllllIllIlIIIIIIlIIlIIIIl[llllllllllllIllIlIIIIIIlIIlIIIII++]);
        final ScoreObjective llllllllllllIllIlIIIIIIlIIIlllII = this.convertToObjective(llllllllllllIllIlIIIIIIlIIlIIIIl[llllllllllllIllIlIIIIIIlIIlIIIII++], true, llllllllllllIllIlIIIIIIlIIIlllll);
        final String llllllllllllIllIlIIIIIIlIIIllIll = llllllllllllIllIlIIIIIIlIIlIIIIl[llllllllllllIllIlIIIIIIlIIlIIIII++];
        final String llllllllllllIllIlIIIIIIlIIIllIlI = CommandBase.getEntityName(llllllllllllIllIlIIIIIIlIIIlllll, llllllllllllIllIlIIIIIIlIIlIIIlI, llllllllllllIllIlIIIIIIlIIlIIIIl[llllllllllllIllIlIIIIIIlIIlIIIII++]);
        final ScoreObjective llllllllllllIllIlIIIIIIlIIIllIIl = this.convertToObjective(llllllllllllIllIlIIIIIIlIIlIIIIl[llllllllllllIllIlIIIIIIlIIlIIIII], false, llllllllllllIllIlIIIIIIlIIIlllll);
        if (llllllllllllIllIlIIIIIIlIIIlllIl.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { llllllllllllIllIlIIIIIIlIIIlllIl, 40 });
        }
        if (llllllllllllIllIlIIIIIIlIIIllIlI.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { llllllllllllIllIlIIIIIIlIIIllIlI, 40 });
        }
        final Score llllllllllllIllIlIIIIIIlIIIllIII = llllllllllllIllIlIIIIIIlIIIllllI.getOrCreateScore(llllllllllllIllIlIIIIIIlIIIlllIl, llllllllllllIllIlIIIIIIlIIIlllII);
        if (!llllllllllllIllIlIIIIIIlIIIllllI.entityHasObjective(llllllllllllIllIlIIIIIIlIIIllIlI, llllllllllllIllIlIIIIIIlIIIllIIl)) {
            throw new CommandException("commands.scoreboard.players.operation.notFound", new Object[] { llllllllllllIllIlIIIIIIlIIIllIIl.getName(), llllllllllllIllIlIIIIIIlIIIllIlI });
        }
        final Score llllllllllllIllIlIIIIIIlIIIlIlll = llllllllllllIllIlIIIIIIlIIIllllI.getOrCreateScore(llllllllllllIllIlIIIIIIlIIIllIlI, llllllllllllIllIlIIIIIIlIIIllIIl);
        if ("+=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints() + llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
        }
        else if ("-=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints() - llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
        }
        else if ("*=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints() * llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
        }
        else if ("/=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            if (llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints() != 0) {
                llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints() / llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
            }
        }
        else if ("%=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            if (llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints() != 0) {
                llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints() % llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
            }
        }
        else if ("=".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
        }
        else if ("<".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(Math.min(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints(), llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints()));
        }
        else if (">".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(Math.max(llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints(), llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints()));
        }
        else {
            if (!"><".equals(llllllllllllIllIlIIIIIIlIIIllIll)) {
                throw new CommandException("commands.scoreboard.players.operation.invalidOperation", new Object[] { llllllllllllIllIlIIIIIIlIIIllIll });
            }
            final int llllllllllllIllIlIIIIIIlIIIlIllI = llllllllllllIllIlIIIIIIlIIIllIII.getScorePoints();
            llllllllllllIllIlIIIIIIlIIIllIII.setScorePoints(llllllllllllIllIlIIIIIIlIIIlIlll.getScorePoints());
            llllllllllllIllIlIIIIIIlIIIlIlll.setScorePoints(llllllllllllIllIlIIIIIIlIIIlIllI);
        }
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIlIIlIIIlI, this, "commands.scoreboard.players.operation.success", new Object[0]);
    }
    
    protected void listObjectives(final ICommandSender llllllllllllIllIlIIIIIIlllllIIll, final MinecraftServer llllllllllllIllIlIIIIIIlllllIIlI) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIllllllIII = this.getScoreboard(llllllllllllIllIlIIIIIIlllllIIlI);
        final Collection<ScoreObjective> llllllllllllIllIlIIIIIIlllllIlll = llllllllllllIllIlIIIIIIllllllIII.getScoreObjectives();
        if (llllllllllllIllIlIIIIIIlllllIlll.isEmpty()) {
            throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
        final TextComponentTranslation llllllllllllIllIlIIIIIIlllllIllI = new TextComponentTranslation("commands.scoreboard.objectives.list.count", new Object[] { llllllllllllIllIlIIIIIIlllllIlll.size() });
        llllllllllllIllIlIIIIIIlllllIllI.getStyle().setColor(TextFormatting.DARK_GREEN);
        llllllllllllIllIlIIIIIIlllllIIll.addChatMessage(llllllllllllIllIlIIIIIIlllllIllI);
        for (final ScoreObjective llllllllllllIllIlIIIIIIlllllIlIl : llllllllllllIllIlIIIIIIlllllIlll) {
            llllllllllllIllIlIIIIIIlllllIIll.addChatMessage(new TextComponentTranslation("commands.scoreboard.objectives.list.entry", new Object[] { llllllllllllIllIlIIIIIIlllllIlIl.getName(), llllllllllllIllIlIIIIIIlllllIlIl.getDisplayName(), llllllllllllIllIlIIIIIIlllllIlIl.getCriteria().getName() }));
        }
    }
    
    protected void removeObjective(final ICommandSender llllllllllllIllIlIIIIIlIIIIIlllI, final String llllllllllllIllIlIIIIIlIIIIIllIl, final MinecraftServer llllllllllllIllIlIIIIIlIIIIIllII) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIIIIIlIll = this.getScoreboard(llllllllllllIllIlIIIIIlIIIIIllII);
        final ScoreObjective llllllllllllIllIlIIIIIlIIIIIlIlI = this.convertToObjective(llllllllllllIllIlIIIIIlIIIIIllIl, false, llllllllllllIllIlIIIIIlIIIIIllII);
        llllllllllllIllIlIIIIIlIIIIIlIll.removeObjective(llllllllllllIllIlIIIIIlIIIIIlIlI);
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIIIIIlllI, this, "commands.scoreboard.objectives.remove.success", llllllllllllIllIlIIIIIlIIIIIllIl);
    }
    
    protected void setTeamOption(final ICommandSender llllllllllllIllIlIIIIIlIlIllllII, final String[] llllllllllllIllIlIIIIIlIllIIIlll, int llllllllllllIllIlIIIIIlIlIlllIlI, final MinecraftServer llllllllllllIllIlIIIIIlIllIIIlIl) throws CommandException {
        final ScorePlayerTeam llllllllllllIllIlIIIIIlIllIIIlII = this.convertToTeam(llllllllllllIllIlIIIIIlIllIIIlll[llllllllllllIllIlIIIIIlIlIlllIlI++], llllllllllllIllIlIIIIIlIllIIIlIl);
        if (llllllllllllIllIlIIIIIlIllIIIlII != null) {
            final String llllllllllllIllIlIIIIIlIllIIIIll = llllllllllllIllIlIIIIIlIllIIIlll[llllllllllllIllIlIIIIIlIlIlllIlI++].toLowerCase(Locale.ROOT);
            if (!"color".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) && !"friendlyfire".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) && !"seeFriendlyInvisibles".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) && !"nametagVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) && !"deathMessageVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) && !"collisionRule".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            if (llllllllllllIllIlIIIIIlIllIIIlll.length == 4) {
                if ("color".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceStringFromCollection(TextFormatting.getValidValues(true, false)) });
                }
                if ("friendlyfire".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) || "seeFriendlyInvisibles".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                }
                if ("nametagVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll) || "deathMessageVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                }
                if ("collisionRule".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceString(Team.CollisionRule.getNames()) });
                }
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            else {
                final String llllllllllllIllIlIIIIIlIllIIIIlI = llllllllllllIllIlIIIIIlIllIIIlll[llllllllllllIllIlIIIIIlIlIlllIlI];
                if ("color".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    final TextFormatting llllllllllllIllIlIIIIIlIllIIIIIl = TextFormatting.getValueByName(llllllllllllIllIlIIIIIlIllIIIIlI);
                    if (llllllllllllIllIlIIIIIlIllIIIIIl == null || llllllllllllIllIlIIIIIlIllIIIIIl.isFancyStyling()) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceStringFromCollection(TextFormatting.getValidValues(true, false)) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setChatFormat(llllllllllllIllIlIIIIIlIllIIIIIl);
                    llllllllllllIllIlIIIIIlIllIIIlII.setNamePrefix(llllllllllllIllIlIIIIIlIllIIIIIl.toString());
                    llllllllllllIllIlIIIIIlIllIIIlII.setNameSuffix(TextFormatting.RESET.toString());
                }
                else if ("friendlyfire".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    if (!"true".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI) && !"false".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI)) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setAllowFriendlyFire("true".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI));
                }
                else if ("seeFriendlyInvisibles".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    if (!"true".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI) && !"false".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI)) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceStringFromCollection(Arrays.asList("true", "false")) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setSeeFriendlyInvisiblesEnabled("true".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIlI));
                }
                else if ("nametagVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    final Team.EnumVisible llllllllllllIllIlIIIIIlIllIIIIII = Team.EnumVisible.getByName(llllllllllllIllIlIIIIIlIllIIIIlI);
                    if (llllllllllllIllIlIIIIIlIllIIIIII == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setNameTagVisibility(llllllllllllIllIlIIIIIlIllIIIIII);
                }
                else if ("deathMessageVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    final Team.EnumVisible llllllllllllIllIlIIIIIlIlIllllll = Team.EnumVisible.getByName(llllllllllllIllIlIIIIIlIllIIIIlI);
                    if (llllllllllllIllIlIIIIIlIlIllllll == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceString(Team.EnumVisible.getNames()) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setDeathMessageVisibility(llllllllllllIllIlIIIIIlIlIllllll);
                }
                else if ("collisionRule".equalsIgnoreCase(llllllllllllIllIlIIIIIlIllIIIIll)) {
                    final Team.CollisionRule llllllllllllIllIlIIIIIlIlIlllllI = Team.CollisionRule.getByName(llllllllllllIllIlIIIIIlIllIIIIlI);
                    if (llllllllllllIllIlIIIIIlIlIlllllI == null) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { llllllllllllIllIlIIIIIlIllIIIIll, CommandBase.joinNiceString(Team.CollisionRule.getNames()) });
                    }
                    llllllllllllIllIlIIIIIlIllIIIlII.setCollisionRule(llllllllllllIllIlIIIIIlIlIlllllI);
                }
                CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIlIllllII, this, "commands.scoreboard.teams.option.success", llllllllllllIllIlIIIIIlIllIIIIll, llllllllllllIllIlIIIIIlIllIIIlII.getRegisteredName(), llllllllllllIllIlIIIIIlIllIIIIlI);
            }
        }
    }
    
    protected void enablePlayerTrigger(final ICommandSender llllllllllllIllIlIIIIIIlIllIIIll, final String[] llllllllllllIllIlIIIIIIlIlIllIIl, int llllllllllllIllIlIIIIIIlIlIllIII, final MinecraftServer llllllllllllIllIlIIIIIIlIllIIIII) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlIlIlllll = this.getScoreboard(llllllllllllIllIlIIIIIIlIllIIIII);
        final String llllllllllllIllIlIIIIIIlIlIllllI = CommandBase.getPlayerName(llllllllllllIllIlIIIIIIlIllIIIII, llllllllllllIllIlIIIIIIlIllIIIll, llllllllllllIllIlIIIIIIlIlIllIIl[llllllllllllIllIlIIIIIIlIlIllIII++]);
        if (llllllllllllIllIlIIIIIIlIlIllllI.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { llllllllllllIllIlIIIIIIlIlIllllI, 40 });
        }
        final ScoreObjective llllllllllllIllIlIIIIIIlIlIlllIl = this.convertToObjective(llllllllllllIllIlIIIIIIlIlIllIIl[llllllllllllIllIlIIIIIIlIlIllIII], false, llllllllllllIllIlIIIIIIlIllIIIII);
        if (llllllllllllIllIlIIIIIIlIlIlllIl.getCriteria() != IScoreCriteria.TRIGGER) {
            throw new CommandException("commands.scoreboard.players.enable.noTrigger", new Object[] { llllllllllllIllIlIIIIIIlIlIlllIl.getName() });
        }
        final Score llllllllllllIllIlIIIIIIlIlIlllII = llllllllllllIllIlIIIIIIlIlIlllll.getOrCreateScore(llllllllllllIllIlIIIIIIlIlIllllI, llllllllllllIllIlIIIIIIlIlIlllIl);
        llllllllllllIllIlIIIIIIlIlIlllII.setLocked(false);
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIlIllIIIll, this, "commands.scoreboard.players.enable.success", llllllllllllIllIlIIIIIIlIlIlllIl.getName(), llllllllllllIllIlIIIIIIlIlIllllI);
    }
    
    protected Scoreboard getScoreboard(final MinecraftServer llllllllllllIllIlIIIIIllIIlIlIll) {
        return llllllllllllIllIlIIIIIllIIlIlIll.worldServerForDimension(0).getScoreboard();
    }
    
    protected void testPlayerScore(final ICommandSender llllllllllllIllIlIIIIIIlIIlllIll, final String[] llllllllllllIllIlIIIIIIlIIlllIlI, int llllllllllllIllIlIIIIIIlIlIIIlII, final MinecraftServer llllllllllllIllIlIIIIIIlIIlllIII) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlIlIIIIlI = this.getScoreboard(llllllllllllIllIlIIIIIIlIIlllIII);
        final String llllllllllllIllIlIIIIIIlIlIIIIIl = CommandBase.getEntityName(llllllllllllIllIlIIIIIIlIIlllIII, llllllllllllIllIlIIIIIIlIIlllIll, llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII++]);
        if (llllllllllllIllIlIIIIIIlIlIIIIIl.length() > 40) {
            throw new SyntaxErrorException("commands.scoreboard.players.name.tooLong", new Object[] { llllllllllllIllIlIIIIIIlIlIIIIIl, 40 });
        }
        final ScoreObjective llllllllllllIllIlIIIIIIlIlIIIIII = this.convertToObjective(llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII++], false, llllllllllllIllIlIIIIIIlIIlllIII);
        if (!llllllllllllIllIlIIIIIIlIlIIIIlI.entityHasObjective(llllllllllllIllIlIIIIIIlIlIIIIIl, llllllllllllIllIlIIIIIIlIlIIIIII)) {
            throw new CommandException("commands.scoreboard.players.test.notFound", new Object[] { llllllllllllIllIlIIIIIIlIlIIIIII.getName(), llllllllllllIllIlIIIIIIlIlIIIIIl });
        }
        final int llllllllllllIllIlIIIIIIlIIllllll = llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII].equals("*") ? Integer.MIN_VALUE : CommandBase.parseInt(llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII]);
        final int llllllllllllIllIlIIIIIIlIIlllllI = (++llllllllllllIllIlIIIIIIlIlIIIlII < llllllllllllIllIlIIIIIIlIIlllIlI.length && !llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII].equals("*")) ? CommandBase.parseInt(llllllllllllIllIlIIIIIIlIIlllIlI[llllllllllllIllIlIIIIIIlIlIIIlII], llllllllllllIllIlIIIIIIlIIllllll) : Integer.MAX_VALUE;
        final Score llllllllllllIllIlIIIIIIlIIllllIl = llllllllllllIllIlIIIIIIlIlIIIIlI.getOrCreateScore(llllllllllllIllIlIIIIIIlIlIIIIIl, llllllllllllIllIlIIIIIIlIlIIIIII);
        if (llllllllllllIllIlIIIIIIlIIllllIl.getScorePoints() >= llllllllllllIllIlIIIIIIlIIllllll && llllllllllllIllIlIIIIIIlIIllllIl.getScorePoints() <= llllllllllllIllIlIIIIIIlIIlllllI) {
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIlIIlllIll, this, "commands.scoreboard.players.test.success", llllllllllllIllIlIIIIIIlIIllllIl.getScorePoints(), llllllllllllIllIlIIIIIIlIIllllll, llllllllllllIllIlIIIIIIlIIlllllI);
            return;
        }
        throw new CommandException("commands.scoreboard.players.test.failed", new Object[] { llllllllllllIllIlIIIIIIlIIllllIl.getScorePoints(), llllllllllllIllIlIIIIIIlIIllllll, llllllllllllIllIlIIIIIIlIIlllllI });
    }
    
    protected void applyPlayerTag(final MinecraftServer llllllllllllIllIlIIIIIIIlllllIlI, final ICommandSender llllllllllllIllIlIIIIIIIlllllIIl, final String[] llllllllllllIllIlIIIIIIIlllIlIlI, int llllllllllllIllIlIIIIIIIllllIlll) throws CommandException {
        final String llllllllllllIllIlIIIIIIIllllIllI = CommandBase.getEntityName(llllllllllllIllIlIIIIIIIlllllIlI, llllllllllllIllIlIIIIIIIlllllIIl, llllllllllllIllIlIIIIIIIlllIlIlI[llllllllllllIllIlIIIIIIIllllIlll]);
        final Entity llllllllllllIllIlIIIIIIIllllIlIl = CommandBase.getEntity(llllllllllllIllIlIIIIIIIlllllIlI, llllllllllllIllIlIIIIIIIlllllIIl, llllllllllllIllIlIIIIIIIlllIlIlI[llllllllllllIllIlIIIIIIIllllIlll++]);
        final String llllllllllllIllIlIIIIIIIllllIlII = llllllllllllIllIlIIIIIIIlllIlIlI[llllllllllllIllIlIIIIIIIllllIlll++];
        final Set<String> llllllllllllIllIlIIIIIIIllllIIll = llllllllllllIllIlIIIIIIIllllIlIl.getTags();
        if ("list".equals(llllllllllllIllIlIIIIIIIllllIlII)) {
            if (!llllllllllllIllIlIIIIIIIllllIIll.isEmpty()) {
                final TextComponentTranslation llllllllllllIllIlIIIIIIIllllIIlI = new TextComponentTranslation("commands.scoreboard.players.tag.list", new Object[] { llllllllllllIllIlIIIIIIIllllIllI });
                llllllllllllIllIlIIIIIIIllllIIlI.getStyle().setColor(TextFormatting.DARK_GREEN);
                llllllllllllIllIlIIIIIIIlllllIIl.addChatMessage(llllllllllllIllIlIIIIIIIllllIIlI);
                llllllllllllIllIlIIIIIIIlllllIIl.addChatMessage(new TextComponentString(CommandBase.joinNiceString(llllllllllllIllIlIIIIIIIllllIIll.toArray())));
            }
            llllllllllllIllIlIIIIIIIlllllIIl.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIllIlIIIIIIIllllIIll.size());
        }
        else {
            if (llllllllllllIllIlIIIIIIIlllIlIlI.length < 5) {
                throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
            }
            final String llllllllllllIllIlIIIIIIIllllIIIl = llllllllllllIllIlIIIIIIIlllIlIlI[llllllllllllIllIlIIIIIIIllllIlll++];
            if (llllllllllllIllIlIIIIIIIlllIlIlI.length > llllllllllllIllIlIIIIIIIllllIlll) {
                try {
                    final NBTTagCompound llllllllllllIllIlIIIIIIIllllIIII = JsonToNBT.getTagFromJson(CommandBase.buildString(llllllllllllIllIlIIIIIIIlllIlIlI, llllllllllllIllIlIIIIIIIllllIlll));
                    final NBTTagCompound llllllllllllIllIlIIIIIIIlllIllll = CommandBase.entityToNBT(llllllllllllIllIlIIIIIIIllllIlIl);
                    if (!NBTUtil.areNBTEquals(llllllllllllIllIlIIIIIIIllllIIII, llllllllllllIllIlIIIIIIIlllIllll, true)) {
                        throw new CommandException("commands.scoreboard.players.tag.tagMismatch", new Object[] { llllllllllllIllIlIIIIIIIllllIllI });
                    }
                }
                catch (NBTException llllllllllllIllIlIIIIIIIlllIlllI) {
                    throw new CommandException("commands.scoreboard.players.tag.tagError", new Object[] { llllllllllllIllIlIIIIIIIlllIlllI.getMessage() });
                }
            }
            if ("add".equals(llllllllllllIllIlIIIIIIIllllIlII)) {
                if (!llllllllllllIllIlIIIIIIIllllIlIl.addTag(llllllllllllIllIlIIIIIIIllllIIIl)) {
                    throw new CommandException("commands.scoreboard.players.tag.tooMany", new Object[] { 1024 });
                }
                CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIIlllllIIl, this, "commands.scoreboard.players.tag.success.add", llllllllllllIllIlIIIIIIIllllIIIl);
            }
            else {
                if (!"remove".equals(llllllllllllIllIlIIIIIIIllllIlII)) {
                    throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
                }
                if (!llllllllllllIllIlIIIIIIIllllIlIl.removeTag(llllllllllllIllIlIIIIIIIllllIIIl)) {
                    throw new CommandException("commands.scoreboard.players.tag.notFound", new Object[] { llllllllllllIllIlIIIIIIIllllIIIl });
                }
                CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIIlllllIIl, this, "commands.scoreboard.players.tag.success.remove", llllllllllllIllIlIIIIIIIllllIIIl);
            }
        }
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIllIlIIIIIllIlIllIII, final ICommandSender llllllllllllIllIlIIIIIllIlIlIlll, final String[] llllllllllllIllIlIIIIIllIlIlIllI) throws CommandException {
        if (!this.handleUserWildcards(llllllllllllIllIlIIIIIllIlIllIII, llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI)) {
            if (llllllllllllIllIlIIIIIllIlIlIllI.length < 1) {
                throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
            }
            if ("objectives".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[0])) {
                if (llllllllllllIllIlIIIIIllIlIlIllI.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    this.listObjectives(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("add".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
                    }
                    this.addObjective(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("remove".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.objectives.remove.usage", new Object[0]);
                    }
                    this.removeObjective(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI[2], llllllllllllIllIlIIIIIllIlIllIII);
                }
                else {
                    if (!"setdisplay".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                        throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                    }
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 3 && llllllllllllIllIlIIIIIllIlIlIllI.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                    }
                    this.setDisplayObjective(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
            }
            else if ("players".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[0])) {
                if (llllllllllllIllIlIIIIIllIlIlIllI.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.players.list.usage", new Object[0]);
                    }
                    this.listPlayers(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("add".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.add.usage", new Object[0]);
                    }
                    this.addPlayerScore(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("remove".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.remove.usage", new Object[0]);
                    }
                    this.addPlayerScore(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("set".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 5) {
                        throw new WrongUsageException("commands.scoreboard.players.set.usage", new Object[0]);
                    }
                    this.addPlayerScore(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("reset".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 3 && llllllllllllIllIlIIIIIllIlIlIllI.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.reset.usage", new Object[0]);
                    }
                    this.resetPlayerScore(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("enable".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 4) {
                        throw new WrongUsageException("commands.scoreboard.players.enable.usage", new Object[0]);
                    }
                    this.enablePlayerTrigger(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("test".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 5 && llllllllllllIllIlIIIIIllIlIlIllI.length != 6) {
                        throw new WrongUsageException("commands.scoreboard.players.test.usage", new Object[0]);
                    }
                    this.testPlayerScore(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("operation".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 7) {
                        throw new WrongUsageException("commands.scoreboard.players.operation.usage", new Object[0]);
                    }
                    this.applyPlayerOperation(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else {
                    if (!"tag".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                        throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                    }
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 4) {
                        throw new WrongUsageException("commands.scoreboard.players.tag.usage", new Object[0]);
                    }
                    this.applyPlayerTag(llllllllllllIllIlIIIIIllIlIllIII, llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2);
                }
            }
            else {
                if (!"teams".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[0])) {
                    throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
                }
                if (llllllllllllIllIlIIIIIllIlIlIllI.length == 1) {
                    throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                }
                if ("list".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length > 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.list.usage", new Object[0]);
                    }
                    this.listTeams(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("add".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
                    }
                    this.addTeam(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("remove".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.remove.usage", new Object[0]);
                    }
                    this.removeTeam(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("empty".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 3) {
                        throw new WrongUsageException("commands.scoreboard.teams.empty.usage", new Object[0]);
                    }
                    this.emptyTeam(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("join".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 4 && (llllllllllllIllIlIIIIIllIlIlIllI.length != 3 || !(llllllllllllIllIlIIIIIllIlIlIlll instanceof EntityPlayer))) {
                        throw new WrongUsageException("commands.scoreboard.teams.join.usage", new Object[0]);
                    }
                    this.joinTeam(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else if ("leave".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length < 3 && !(llllllllllllIllIlIIIIIllIlIlIlll instanceof EntityPlayer)) {
                        throw new WrongUsageException("commands.scoreboard.teams.leave.usage", new Object[0]);
                    }
                    this.leaveTeam(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
                else {
                    if (!"option".equalsIgnoreCase(llllllllllllIllIlIIIIIllIlIlIllI[1])) {
                        throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                    }
                    if (llllllllllllIllIlIIIIIllIlIlIllI.length != 4 && llllllllllllIllIlIIIIIllIlIlIllI.length != 5) {
                        throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
                    }
                    this.setTeamOption(llllllllllllIllIlIIIIIllIlIlIlll, llllllllllllIllIlIIIIIllIlIlIllI, 2, llllllllllllIllIlIIIIIllIlIllIII);
                }
            }
        }
    }
    
    protected void resetPlayerScore(final ICommandSender llllllllllllIllIlIIIIIIlIlllllII, final String[] llllllllllllIllIlIIIIIIlIllllIll, int llllllllllllIllIlIIIIIIlIllllIlI, final MinecraftServer llllllllllllIllIlIIIIIIlIllllIIl) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlIllllIII = this.getScoreboard(llllllllllllIllIlIIIIIIlIllllIIl);
        final String llllllllllllIllIlIIIIIIlIlllIlll = CommandBase.getEntityName(llllllllllllIllIlIIIIIIlIllllIIl, llllllllllllIllIlIIIIIIlIlllllII, llllllllllllIllIlIIIIIIlIllllIll[llllllllllllIllIlIIIIIIlIllllIlI++]);
        if (llllllllllllIllIlIIIIIIlIllllIll.length > llllllllllllIllIlIIIIIIlIllllIlI) {
            final ScoreObjective llllllllllllIllIlIIIIIIlIlllIllI = this.convertToObjective(llllllllllllIllIlIIIIIIlIllllIll[llllllllllllIllIlIIIIIIlIllllIlI++], false, llllllllllllIllIlIIIIIIlIllllIIl);
            llllllllllllIllIlIIIIIIlIllllIII.removeObjectiveFromEntity(llllllllllllIllIlIIIIIIlIlllIlll, llllllllllllIllIlIIIIIIlIlllIllI);
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIlIlllllII, this, "commands.scoreboard.players.resetscore.success", llllllllllllIllIlIIIIIIlIlllIllI.getName(), llllllllllllIllIlIIIIIIlIlllIlll);
        }
        else {
            llllllllllllIllIlIIIIIIlIllllIII.removeObjectiveFromEntity(llllllllllllIllIlIIIIIIlIlllIlll, null);
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIlIlllllII, this, "commands.scoreboard.players.reset.success", llllllllllllIllIlIIIIIIlIlllIlll);
        }
    }
    
    protected ScorePlayerTeam convertToTeam(final String llllllllllllIllIlIIIIIllIIIlIIIl, final MinecraftServer llllllllllllIllIlIIIIIllIIIIlIll) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIllIIIIllll = this.getScoreboard(llllllllllllIllIlIIIIIllIIIIlIll);
        final ScorePlayerTeam llllllllllllIllIlIIIIIllIIIIlllI = llllllllllllIllIlIIIIIllIIIIllll.getTeam(llllllllllllIllIlIIIIIllIIIlIIIl);
        if (llllllllllllIllIlIIIIIllIIIIlllI == null) {
            throw new CommandException("commands.scoreboard.teamNotFound", new Object[] { llllllllllllIllIlIIIIIllIIIlIIIl });
        }
        return llllllllllllIllIlIIIIIllIIIIlllI;
    }
    
    protected void addObjective(final ICommandSender llllllllllllIllIlIIIIIlIllllIIll, final String[] llllllllllllIllIlIIIIIlIllllllII, int llllllllllllIllIlIIIIIlIlllllIll, final MinecraftServer llllllllllllIllIlIIIIIlIlllllIlI) throws CommandException {
        final String llllllllllllIllIlIIIIIlIlllllIIl = llllllllllllIllIlIIIIIlIllllllII[llllllllllllIllIlIIIIIlIlllllIll++];
        final String llllllllllllIllIlIIIIIlIlllllIII = llllllllllllIllIlIIIIIlIllllllII[llllllllllllIllIlIIIIIlIlllllIll++];
        final Scoreboard llllllllllllIllIlIIIIIlIllllIlll = this.getScoreboard(llllllllllllIllIlIIIIIlIlllllIlI);
        final IScoreCriteria llllllllllllIllIlIIIIIlIllllIllI = IScoreCriteria.INSTANCES.get(llllllllllllIllIlIIIIIlIlllllIII);
        if (llllllllllllIllIlIIIIIlIllllIllI == null) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.wrongType", new Object[] { llllllllllllIllIlIIIIIlIlllllIII });
        }
        if (llllllllllllIllIlIIIIIlIllllIlll.getObjective(llllllllllllIllIlIIIIIlIlllllIIl) != null) {
            throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] { llllllllllllIllIlIIIIIlIlllllIIl });
        }
        if (llllllllllllIllIlIIIIIlIlllllIIl.length() > 16) {
            throw new SyntaxErrorException("commands.scoreboard.objectives.add.tooLong", new Object[] { llllllllllllIllIlIIIIIlIlllllIIl, 16 });
        }
        if (llllllllllllIllIlIIIIIlIlllllIIl.isEmpty()) {
            throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (llllllllllllIllIlIIIIIlIllllllII.length > llllllllllllIllIlIIIIIlIlllllIll) {
            final String llllllllllllIllIlIIIIIlIllllIlIl = CommandBase.getChatComponentFromNthArg(llllllllllllIllIlIIIIIlIllllIIll, llllllllllllIllIlIIIIIlIllllllII, llllllllllllIllIlIIIIIlIlllllIll).getUnformattedText();
            if (llllllllllllIllIlIIIIIlIllllIlIl.length() > 32) {
                throw new SyntaxErrorException("commands.scoreboard.objectives.add.displayTooLong", new Object[] { llllllllllllIllIlIIIIIlIllllIlIl, 32 });
            }
            if (llllllllllllIllIlIIIIIlIllllIlIl.isEmpty()) {
                llllllllllllIllIlIIIIIlIllllIlll.addScoreObjective(llllllllllllIllIlIIIIIlIlllllIIl, llllllllllllIllIlIIIIIlIllllIllI);
            }
            else {
                llllllllllllIllIlIIIIIlIllllIlll.addScoreObjective(llllllllllllIllIlIIIIIlIlllllIIl, llllllllllllIllIlIIIIIlIllllIllI).setDisplayName(llllllllllllIllIlIIIIIlIllllIlIl);
            }
        }
        else {
            llllllllllllIllIlIIIIIlIllllIlll.addScoreObjective(llllllllllllIllIlIIIIIlIlllllIIl, llllllllllllIllIlIIIIIlIllllIllI);
        }
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIllllIIll, this, "commands.scoreboard.objectives.add.success", llllllllllllIllIlIIIIIlIlllllIIl);
    }
    
    protected void listTeams(final ICommandSender llllllllllllIllIlIIIIIlIlIIlIlII, final String[] llllllllllllIllIlIIIIIlIlIIlIIll, final int llllllllllllIllIlIIIIIlIlIIlIIlI, final MinecraftServer llllllllllllIllIlIIIIIlIlIIIIlIl) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIlIIlIIII = this.getScoreboard(llllllllllllIllIlIIIIIlIlIIIIlIl);
        if (llllllllllllIllIlIIIIIlIlIIlIIll.length > llllllllllllIllIlIIIIIlIlIIlIIlI) {
            final ScorePlayerTeam llllllllllllIllIlIIIIIlIlIIIllll = this.convertToTeam(llllllllllllIllIlIIIIIlIlIIlIIll[llllllllllllIllIlIIIIIlIlIIlIIlI], llllllllllllIllIlIIIIIlIlIIIIlIl);
            if (llllllllllllIllIlIIIIIlIlIIIllll == null) {
                return;
            }
            final Collection<String> llllllllllllIllIlIIIIIlIlIIIlllI = llllllllllllIllIlIIIIIlIlIIIllll.getMembershipCollection();
            llllllllllllIllIlIIIIIlIlIIlIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIllIlIIIIIlIlIIIlllI.size());
            if (llllllllllllIllIlIIIIIlIlIIIlllI.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] { llllllllllllIllIlIIIIIlIlIIIllll.getRegisteredName() });
            }
            final TextComponentTranslation llllllllllllIllIlIIIIIlIlIIIllIl = new TextComponentTranslation("commands.scoreboard.teams.list.player.count", new Object[] { llllllllllllIllIlIIIIIlIlIIIlllI.size(), llllllllllllIllIlIIIIIlIlIIIllll.getRegisteredName() });
            llllllllllllIllIlIIIIIlIlIIIllIl.getStyle().setColor(TextFormatting.DARK_GREEN);
            llllllllllllIllIlIIIIIlIlIIlIlII.addChatMessage(llllllllllllIllIlIIIIIlIlIIIllIl);
            llllllllllllIllIlIIIIIlIlIIlIlII.addChatMessage(new TextComponentString(CommandBase.joinNiceString(llllllllllllIllIlIIIIIlIlIIIlllI.toArray())));
        }
        else {
            final Collection<ScorePlayerTeam> llllllllllllIllIlIIIIIlIlIIIllII = llllllllllllIllIlIIIIIlIlIIlIIII.getTeams();
            llllllllllllIllIlIIIIIlIlIIlIlII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllIllIlIIIIIlIlIIIllII.size());
            if (llllllllllllIllIlIIIIIlIlIIIllII.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
            }
            final TextComponentTranslation llllllllllllIllIlIIIIIlIlIIIlIll = new TextComponentTranslation("commands.scoreboard.teams.list.count", new Object[] { llllllllllllIllIlIIIIIlIlIIIllII.size() });
            llllllllllllIllIlIIIIIlIlIIIlIll.getStyle().setColor(TextFormatting.DARK_GREEN);
            llllllllllllIllIlIIIIIlIlIIlIlII.addChatMessage(llllllllllllIllIlIIIIIlIlIIIlIll);
            for (final ScorePlayerTeam llllllllllllIllIlIIIIIlIlIIIlIlI : llllllllllllIllIlIIIIIlIlIIIllII) {
                llllllllllllIllIlIIIIIlIlIIlIlII.addChatMessage(new TextComponentTranslation("commands.scoreboard.teams.list.entry", new Object[] { llllllllllllIllIlIIIIIlIlIIIlIlI.getRegisteredName(), llllllllllllIllIlIIIIIlIlIIIlIlI.getTeamName(), llllllllllllIllIlIIIIIlIlIIIlIlI.getMembershipCollection().size() }));
            }
        }
    }
    
    protected ScoreObjective convertToObjective(final String llllllllllllIllIlIIIIIllIIIlllII, final boolean llllllllllllIllIlIIIIIllIIIllIll, final MinecraftServer llllllllllllIllIlIIIIIllIIIllIlI) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIllIIIlllll = this.getScoreboard(llllllllllllIllIlIIIIIllIIIllIlI);
        final ScoreObjective llllllllllllIllIlIIIIIllIIIllllI = llllllllllllIllIlIIIIIllIIIlllll.getObjective(llllllllllllIllIlIIIIIllIIIlllII);
        if (llllllllllllIllIlIIIIIllIIIllllI == null) {
            throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] { llllllllllllIllIlIIIIIllIIIlllII });
        }
        if (llllllllllllIllIlIIIIIllIIIllIll && llllllllllllIllIlIIIIIllIIIllllI.getCriteria().isReadOnly()) {
            throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] { llllllllllllIllIlIIIIIllIIIlllII });
        }
        return llllllllllllIllIlIIIIIllIIIllllI;
    }
    
    @Override
    public String getCommandName() {
        return "scoreboard";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIllIlIIIIIIIllIlllII, final ICommandSender llllllllllllIllIlIIIIIIIllIllIll, final String[] llllllllllllIllIlIIIIIIIllIllIlI, @Nullable final BlockPos llllllllllllIllIlIIIIIIIllIllIIl) {
        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "objectives", "players", "teams");
        }
        if ("objectives".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[0])) {
            if (llllllllllllIllIlIIIIIIIllIllIlI.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "list", "add", "remove", "setdisplay");
            }
            if ("add".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                    final Set<String> llllllllllllIllIlIIIIIIIllIllIII = IScoreCriteria.INSTANCES.keySet();
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIllIII);
                }
            }
            else if ("remove".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(false, llllllllllllIllIlIIIIIIIllIlllII));
                }
            }
            else if ("setdisplay".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, Scoreboard.getDisplaySlotStrings());
                }
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(false, llllllllllllIllIlIIIIIIIllIlllII));
                }
            }
        }
        else if ("players".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[0])) {
            if (llllllllllllIllIlIIIIIIIllIllIlI.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "set", "add", "remove", "reset", "list", "enable", "test", "operation", "tag");
            }
            if (!"set".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"add".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"remove".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"reset".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                if ("enable".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                    if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                        return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIlllII.getAllUsernames());
                    }
                    if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                        return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getTriggerNames(llllllllllllIllIlIIIIIIIllIlllII));
                    }
                }
                else if (!"list".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"test".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                    if ("operation".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getObjectiveNames());
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(true, llllllllllllIllIlIIIIIIIllIlllII));
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 5) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><");
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 6) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIlllII.getAllUsernames());
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 7) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(false, llllllllllllIllIlIIIIIIIllIlllII));
                        }
                    }
                    else if ("tag".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getObjectiveNames());
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "add", "remove", "list");
                        }
                    }
                }
                else {
                    if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                        return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getObjectiveNames());
                    }
                    if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4 && "test".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                        return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(false, llllllllllllIllIlIIIIIIIllIlllII));
                    }
                }
            }
            else {
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIlllII.getAllUsernames());
                }
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getObjectiveNames(true, llllllllllllIllIlIIIIIIIllIlllII));
                }
            }
        }
        else if ("teams".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[0])) {
            if (llllllllllllIllIlIIIIIIIllIllIlI.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if ("join".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getTeamNames());
                }
                if (llllllllllllIllIlIIIIIIIllIllIlI.length >= 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIlllII.getAllUsernames());
                }
            }
            else {
                if ("leave".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, llllllllllllIllIlIIIIIIIllIlllII.getAllUsernames());
                }
                if (!"empty".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"list".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1]) && !"remove".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                    if ("option".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[1])) {
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getTeamNames());
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 4) {
                            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "color", "friendlyfire", "seeFriendlyInvisibles", "nametagVisibility", "deathMessageVisibility", "collisionRule");
                        }
                        if (llllllllllllIllIlIIIIIIIllIllIlI.length == 5) {
                            if ("color".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, TextFormatting.getValidValues(true, false));
                            }
                            if ("nametagVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3]) || "deathMessageVisibility".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, Team.EnumVisible.getNames());
                            }
                            if ("collisionRule".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, Team.CollisionRule.getNames());
                            }
                            if ("friendlyfire".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3]) || "seeFriendlyInvisibles".equalsIgnoreCase(llllllllllllIllIlIIIIIIIllIllIlI[3])) {
                                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, "true", "false");
                            }
                        }
                    }
                }
                else if (llllllllllllIllIlIIIIIIIllIllIlI.length == 3) {
                    return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIIIIIllIllIlI, this.getScoreboard(llllllllllllIllIlIIIIIIIllIlllII).getTeamNames());
                }
            }
        }
        return Collections.emptyList();
    }
    
    protected void emptyTeam(final ICommandSender llllllllllllIllIlIIIIIlIIIIllllI, final String[] llllllllllllIllIlIIIIIlIIIIlllIl, final int llllllllllllIllIlIIIIIlIIIIlllII, final MinecraftServer llllllllllllIllIlIIIIIlIIIlIIlII) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIIIlIIIll = this.getScoreboard(llllllllllllIllIlIIIIIlIIIlIIlII);
        final ScorePlayerTeam llllllllllllIllIlIIIIIlIIIlIIIlI = this.convertToTeam(llllllllllllIllIlIIIIIlIIIIlllIl[llllllllllllIllIlIIIIIlIIIIlllII], llllllllllllIllIlIIIIIlIIIlIIlII);
        if (llllllllllllIllIlIIIIIlIIIlIIIlI != null) {
            final Collection<String> llllllllllllIllIlIIIIIlIIIlIIIIl = (Collection<String>)Lists.newArrayList((Iterable)llllllllllllIllIlIIIIIlIIIlIIIlI.getMembershipCollection());
            llllllllllllIllIlIIIIIlIIIIllllI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllIllIlIIIIIlIIIlIIIIl.size());
            if (llllllllllllIllIlIIIIIlIIIlIIIIl.isEmpty()) {
                throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { llllllllllllIllIlIIIIIlIIIlIIIlI.getRegisteredName() });
            }
            for (final String llllllllllllIllIlIIIIIlIIIlIIIII : llllllllllllIllIlIIIIIlIIIlIIIIl) {
                llllllllllllIllIlIIIIIlIIIlIIIll.removePlayerFromTeam(llllllllllllIllIlIIIIIlIIIlIIIII, llllllllllllIllIlIIIIIlIIIlIIIlI);
            }
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIIIIllllI, this, "commands.scoreboard.teams.empty.success", llllllllllllIllIlIIIIIlIIIlIIIIl.size(), llllllllllllIllIlIIIIIlIIIlIIIlI.getRegisteredName());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    protected List<String> getTriggerNames(final MinecraftServer llllllllllllIllIlIIIIIIIlIlllIII) {
        final Collection<ScoreObjective> llllllllllllIllIlIIIIIIIlIllIlll = this.getScoreboard(llllllllllllIllIlIIIIIIIlIlllIII).getScoreObjectives();
        final List<String> llllllllllllIllIlIIIIIIIlIllIllI = (List<String>)Lists.newArrayList();
        for (final ScoreObjective llllllllllllIllIlIIIIIIIlIllIlIl : llllllllllllIllIlIIIIIIIlIllIlll) {
            if (llllllllllllIllIlIIIIIIIlIllIlIl.getCriteria() == IScoreCriteria.TRIGGER) {
                llllllllllllIllIlIIIIIIIlIllIllI.add(llllllllllllIllIlIIIIIIIlIllIlIl.getName());
            }
        }
        return llllllllllllIllIlIIIIIIIlIllIllI;
    }
    
    protected void leaveTeam(final ICommandSender llllllllllllIllIlIIIIIlIIlIIlIlI, final String[] llllllllllllIllIlIIIIIlIIlIIlIIl, int llllllllllllIllIlIIIIIlIIIlllIll, final MinecraftServer llllllllllllIllIlIIIIIlIIIlllIlI) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIlIIlIIIllI = this.getScoreboard(llllllllllllIllIlIIIIIlIIIlllIlI);
        final Set<String> llllllllllllIllIlIIIIIlIIlIIIlIl = (Set<String>)Sets.newHashSet();
        final Set<String> llllllllllllIllIlIIIIIlIIlIIIlII = (Set<String>)Sets.newHashSet();
        if (llllllllllllIllIlIIIIIlIIlIIlIlI instanceof EntityPlayer && llllllllllllIllIlIIIIIlIIIlllIll == llllllllllllIllIlIIIIIlIIlIIlIIl.length) {
            final String llllllllllllIllIlIIIIIlIIlIIIIll = CommandBase.getCommandSenderAsPlayer(llllllllllllIllIlIIIIIlIIlIIlIlI).getName();
            if (llllllllllllIllIlIIIIIlIIlIIIllI.removePlayerFromTeams(llllllllllllIllIlIIIIIlIIlIIIIll)) {
                llllllllllllIllIlIIIIIlIIlIIIlIl.add(llllllllllllIllIlIIIIIlIIlIIIIll);
            }
            else {
                llllllllllllIllIlIIIIIlIIlIIIlII.add(llllllllllllIllIlIIIIIlIIlIIIIll);
            }
        }
        else {
            while (llllllllllllIllIlIIIIIlIIIlllIll < llllllllllllIllIlIIIIIlIIlIIlIIl.length) {
                final String llllllllllllIllIlIIIIIlIIlIIIIlI = llllllllllllIllIlIIIIIlIIlIIlIIl[llllllllllllIllIlIIIIIlIIIlllIll++];
                if (EntitySelector.hasArguments(llllllllllllIllIlIIIIIlIIlIIIIlI)) {
                    for (final Entity llllllllllllIllIlIIIIIlIIlIIIIIl : CommandBase.getEntityList(llllllllllllIllIlIIIIIlIIIlllIlI, llllllllllllIllIlIIIIIlIIlIIlIlI, llllllllllllIllIlIIIIIlIIlIIIIlI)) {
                        final String llllllllllllIllIlIIIIIlIIlIIIIII = CommandBase.getEntityName(llllllllllllIllIlIIIIIlIIIlllIlI, llllllllllllIllIlIIIIIlIIlIIlIlI, llllllllllllIllIlIIIIIlIIlIIIIIl.getCachedUniqueIdString());
                        if (llllllllllllIllIlIIIIIlIIlIIIllI.removePlayerFromTeams(llllllllllllIllIlIIIIIlIIlIIIIII)) {
                            llllllllllllIllIlIIIIIlIIlIIIlIl.add(llllllllllllIllIlIIIIIlIIlIIIIII);
                        }
                        else {
                            llllllllllllIllIlIIIIIlIIlIIIlII.add(llllllllllllIllIlIIIIIlIIlIIIIII);
                        }
                    }
                }
                else {
                    final String llllllllllllIllIlIIIIIlIIIllllll = CommandBase.getEntityName(llllllllllllIllIlIIIIIlIIIlllIlI, llllllllllllIllIlIIIIIlIIlIIlIlI, llllllllllllIllIlIIIIIlIIlIIIIlI);
                    if (llllllllllllIllIlIIIIIlIIlIIIllI.removePlayerFromTeams(llllllllllllIllIlIIIIIlIIIllllll)) {
                        llllllllllllIllIlIIIIIlIIlIIIlIl.add(llllllllllllIllIlIIIIIlIIIllllll);
                    }
                    else {
                        llllllllllllIllIlIIIIIlIIlIIIlII.add(llllllllllllIllIlIIIIIlIIIllllll);
                    }
                }
            }
        }
        if (!llllllllllllIllIlIIIIIlIIlIIIlIl.isEmpty()) {
            llllllllllllIllIlIIIIIlIIlIIlIlI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllIllIlIIIIIlIIlIIIlIl.size());
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIlIIlIIlIlI, this, "commands.scoreboard.teams.leave.success", llllllllllllIllIlIIIIIlIIlIIIlIl.size(), CommandBase.joinNiceString(llllllllllllIllIlIIIIIlIIlIIIlIl.toArray(new String[llllllllllllIllIlIIIIIlIIlIIIlIl.size()])));
        }
        if (!llllllllllllIllIlIIIIIlIIlIIIlII.isEmpty()) {
            throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] { llllllllllllIllIlIIIIIlIIlIIIlII.size(), CommandBase.joinNiceString(llllllllllllIllIlIIIIIlIIlIIIlII.toArray(new String[llllllllllllIllIlIIIIIlIIlIIIlII.size()])) });
        }
    }
    
    protected void setDisplayObjective(final ICommandSender llllllllllllIllIlIIIIIIllllIIIlI, final String[] llllllllllllIllIlIIIIIIlllIllIII, int llllllllllllIllIlIIIIIIllllIIIII, final MinecraftServer llllllllllllIllIlIIIIIIlllIlllll) throws CommandException {
        final Scoreboard llllllllllllIllIlIIIIIIlllIllllI = this.getScoreboard(llllllllllllIllIlIIIIIIlllIlllll);
        final String llllllllllllIllIlIIIIIIlllIlllIl = llllllllllllIllIlIIIIIIlllIllIII[llllllllllllIllIlIIIIIIllllIIIII++];
        final int llllllllllllIllIlIIIIIIlllIlllII = Scoreboard.getObjectiveDisplaySlotNumber(llllllllllllIllIlIIIIIIlllIlllIl);
        ScoreObjective llllllllllllIllIlIIIIIIlllIllIll = null;
        if (llllllllllllIllIlIIIIIIlllIllIII.length == 4) {
            llllllllllllIllIlIIIIIIlllIllIll = this.convertToObjective(llllllllllllIllIlIIIIIIlllIllIII[llllllllllllIllIlIIIIIIllllIIIII], false, llllllllllllIllIlIIIIIIlllIlllll);
        }
        if (llllllllllllIllIlIIIIIIlllIlllII < 0) {
            throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { llllllllllllIllIlIIIIIIlllIlllIl });
        }
        llllllllllllIllIlIIIIIIlllIllllI.setObjectiveInDisplaySlot(llllllllllllIllIlIIIIIIlllIlllII, llllllllllllIllIlIIIIIIlllIllIll);
        if (llllllllllllIllIlIIIIIIlllIllIll != null) {
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIllllIIIlI, this, "commands.scoreboard.objectives.setdisplay.successSet", Scoreboard.getObjectiveDisplaySlot(llllllllllllIllIlIIIIIIlllIlllII), llllllllllllIllIlIIIIIIlllIllIll.getName());
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllIllIlIIIIIIllllIIIlI, this, "commands.scoreboard.objectives.setdisplay.successCleared", Scoreboard.getObjectiveDisplaySlot(llllllllllllIllIlIIIIIIlllIlllII));
        }
    }
    
    protected List<String> getObjectiveNames(final boolean llllllllllllIllIlIIIIIIIllIIlIll, final MinecraftServer llllllllllllIllIlIIIIIIIllIIlIlI) {
        final Collection<ScoreObjective> llllllllllllIllIlIIIIIIIllIIlIIl = this.getScoreboard(llllllllllllIllIlIIIIIIIllIIlIlI).getScoreObjectives();
        final List<String> llllllllllllIllIlIIIIIIIllIIlIII = (List<String>)Lists.newArrayList();
        for (final ScoreObjective llllllllllllIllIlIIIIIIIllIIIlll : llllllllllllIllIlIIIIIIIllIIlIIl) {
            if (!llllllllllllIllIlIIIIIIIllIIlIll || !llllllllllllIllIlIIIIIIIllIIIlll.getCriteria().isReadOnly()) {
                llllllllllllIllIlIIIIIIIllIIlIII.add(llllllllllllIllIlIIIIIIIllIIIlll.getName());
            }
        }
        return llllllllllllIllIlIIIIIIIllIIlIII;
    }
}
