// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.Set;

public abstract class CommandHandler implements ICommandManager
{
    private final /* synthetic */ Set<ICommand> commandSet;
    private final /* synthetic */ Map<String, ICommand> commandMap;
    private static final /* synthetic */ Logger LOGGER;
    
    private static String[] dropFirstString(final String[] lllllllllllllIlllIllllIIIIlllIll) {
        final String[] lllllllllllllIlllIllllIIIIllllII = new String[lllllllllllllIlllIllllIIIIlllIll.length - 1];
        System.arraycopy(lllllllllllllIlllIllllIIIIlllIll, 1, lllllllllllllIlllIllllIIIIllllII, 0, lllllllllllllIlllIllllIIIIlllIll.length - 1);
        return lllllllllllllIlllIllllIIIIllllII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public List<String> getTabCompletionOptions(final ICommandSender lllllllllllllIlllIllllIIIIlIIllI, final String lllllllllllllIlllIllllIIIIlIlllI, @Nullable final BlockPos lllllllllllllIlllIllllIIIIlIIlII) {
        final String[] lllllllllllllIlllIllllIIIIlIllII = lllllllllllllIlllIllllIIIIlIlllI.split(" ", -1);
        final String lllllllllllllIlllIllllIIIIlIlIll = lllllllllllllIlllIllllIIIIlIllII[0];
        if (lllllllllllllIlllIllllIIIIlIllII.length == 1) {
            final List<String> lllllllllllllIlllIllllIIIIlIlIlI = (List<String>)Lists.newArrayList();
            for (final Map.Entry<String, ICommand> lllllllllllllIlllIllllIIIIlIlIIl : this.commandMap.entrySet()) {
                if (CommandBase.doesStringStartWith(lllllllllllllIlllIllllIIIIlIlIll, lllllllllllllIlllIllllIIIIlIlIIl.getKey()) && lllllllllllllIlllIllllIIIIlIlIIl.getValue().checkPermission(this.getServer(), lllllllllllllIlllIllllIIIIlIIllI)) {
                    lllllllllllllIlllIllllIIIIlIlIlI.add(lllllllllllllIlllIllllIIIIlIlIIl.getKey());
                }
            }
            return lllllllllllllIlllIllllIIIIlIlIlI;
        }
        if (lllllllllllllIlllIllllIIIIlIllII.length > 1) {
            final ICommand lllllllllllllIlllIllllIIIIlIlIII = this.commandMap.get(lllllllllllllIlllIllllIIIIlIlIll);
            if (lllllllllllllIlllIllllIIIIlIlIII != null && lllllllllllllIlllIllllIIIIlIlIII.checkPermission(this.getServer(), lllllllllllllIlllIllllIIIIlIIllI)) {
                return lllllllllllllIlllIllllIIIIlIlIII.getTabCompletionOptions(this.getServer(), lllllllllllllIlllIllllIIIIlIIllI, dropFirstString(lllllllllllllIlllIllllIIIIlIllII), lllllllllllllIlllIllllIIIIlIIlII);
            }
        }
        return Collections.emptyList();
    }
    
    public CommandHandler() {
        this.commandMap = (Map<String, ICommand>)Maps.newHashMap();
        this.commandSet = (Set<ICommand>)Sets.newHashSet();
    }
    
    protected boolean tryExecute(final ICommandSender lllllllllllllIlllIllllIIIlIlIIll, final String[] lllllllllllllIlllIllllIIIlIlllIl, final ICommand lllllllllllllIlllIllllIIIlIlllII, final String lllllllllllllIlllIllllIIIlIllIll) {
        try {
            lllllllllllllIlllIllllIIIlIlllII.execute(this.getServer(), lllllllllllllIlllIllllIIIlIlIIll, lllllllllllllIlllIllllIIIlIlllIl);
            return true;
        }
        catch (WrongUsageException lllllllllllllIlllIllllIIIlIllIlI) {
            final TextComponentTranslation lllllllllllllIlllIllllIIIlIllIIl = new TextComponentTranslation("commands.generic.usage", new Object[] { new TextComponentTranslation(lllllllllllllIlllIllllIIIlIllIlI.getMessage(), lllllllllllllIlllIllllIIIlIllIlI.getErrorObjects()) });
            lllllllllllllIlllIllllIIIlIllIIl.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllllIIIlIlIIll.addChatMessage(lllllllllllllIlllIllllIIIlIllIIl);
        }
        catch (CommandException lllllllllllllIlllIllllIIIlIllIII) {
            final TextComponentTranslation lllllllllllllIlllIllllIIIlIlIlll = new TextComponentTranslation(lllllllllllllIlllIllllIIIlIllIII.getMessage(), lllllllllllllIlllIllllIIIlIllIII.getErrorObjects());
            lllllllllllllIlllIllllIIIlIlIlll.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllllIIIlIlIIll.addChatMessage(lllllllllllllIlllIllllIIIlIlIlll);
        }
        catch (Throwable lllllllllllllIlllIllllIIIlIlIllI) {
            final TextComponentTranslation lllllllllllllIlllIllllIIIlIlIlIl = new TextComponentTranslation("commands.generic.exception", new Object[0]);
            lllllllllllllIlllIllllIIIlIlIlIl.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllllIIIlIlIIll.addChatMessage(lllllllllllllIlllIllllIIIlIlIlIl);
            CommandHandler.LOGGER.warn("Couldn't process command: " + lllllllllllllIlllIllllIIIlIllIll, lllllllllllllIlllIllllIIIlIlIllI);
        }
        return false;
    }
    
    @Override
    public int executeCommand(final ICommandSender lllllllllllllIlllIllllIIlIIIIIII, String lllllllllllllIlllIllllIIIlllIIII) {
        lllllllllllllIlllIllllIIIlllIIII = lllllllllllllIlllIllllIIIlllIIII.trim();
        if (lllllllllllllIlllIllllIIIlllIIII.startsWith("/")) {
            lllllllllllllIlllIllllIIIlllIIII = lllllllllllllIlllIllllIIIlllIIII.substring(1);
        }
        String[] lllllllllllllIlllIllllIIIllllllI = lllllllllllllIlllIllllIIIlllIIII.split(" ");
        final String lllllllllllllIlllIllllIIIlllllIl = lllllllllllllIlllIllllIIIllllllI[0];
        lllllllllllllIlllIllllIIIllllllI = dropFirstString(lllllllllllllIlllIllllIIIllllllI);
        final ICommand lllllllllllllIlllIllllIIIlllllII = this.commandMap.get(lllllllllllllIlllIllllIIIlllllIl);
        int lllllllllllllIlllIllllIIIllllIll = 0;
        try {
            final int lllllllllllllIlllIllllIIIllllIlI = this.getUsernameIndex(lllllllllllllIlllIllllIIIlllllII, lllllllllllllIlllIllllIIIllllllI);
            if (lllllllllllllIlllIllllIIIlllllII == null) {
                final TextComponentTranslation lllllllllllllIlllIllllIIIllllIIl = new TextComponentTranslation("commands.generic.notFound", new Object[0]);
                lllllllllllllIlllIllllIIIllllIIl.getStyle().setColor(TextFormatting.RED);
                lllllllllllllIlllIllllIIlIIIIIII.addChatMessage(lllllllllllllIlllIllllIIIllllIIl);
            }
            else if (lllllllllllllIlllIllllIIIlllllII.checkPermission(this.getServer(), lllllllllllllIlllIllllIIlIIIIIII)) {
                if (lllllllllllllIlllIllllIIIllllIlI > -1) {
                    final List<Entity> lllllllllllllIlllIllllIIIllllIII = EntitySelector.matchEntities(lllllllllllllIlllIllllIIlIIIIIII, lllllllllllllIlllIllllIIIllllllI[lllllllllllllIlllIllllIIIllllIlI], (Class<? extends Entity>)Entity.class);
                    final String lllllllllllllIlllIllllIIIlllIlll = lllllllllllllIlllIllllIIIllllllI[lllllllllllllIlllIllllIIIllllIlI];
                    lllllllllllllIlllIllllIIlIIIIIII.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, lllllllllllllIlllIllllIIIllllIII.size());
                    if (lllllllllllllIlllIllllIIIllllIII.isEmpty()) {
                        throw new PlayerNotFoundException("commands.generic.selector.notFound", new Object[] { lllllllllllllIlllIllllIIIllllllI[lllllllllllllIlllIllllIIIllllIlI] });
                    }
                    for (final Entity lllllllllllllIlllIllllIIIlllIllI : lllllllllllllIlllIllllIIIllllIII) {
                        lllllllllllllIlllIllllIIIllllllI[lllllllllllllIlllIllllIIIllllIlI] = lllllllllllllIlllIllllIIIlllIllI.getCachedUniqueIdString();
                        if (this.tryExecute(lllllllllllllIlllIllllIIlIIIIIII, lllllllllllllIlllIllllIIIllllllI, lllllllllllllIlllIllllIIIlllllII, lllllllllllllIlllIllllIIIlllIIII)) {
                            ++lllllllllllllIlllIllllIIIllllIll;
                        }
                    }
                    lllllllllllllIlllIllllIIIllllllI[lllllllllllllIlllIllllIIIllllIlI] = lllllllllllllIlllIllllIIIlllIlll;
                }
                else {
                    lllllllllllllIlllIllllIIlIIIIIII.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, 1);
                    if (this.tryExecute(lllllllllllllIlllIllllIIlIIIIIII, lllllllllllllIlllIllllIIIllllllI, lllllllllllllIlllIllllIIIlllllII, lllllllllllllIlllIllllIIIlllIIII)) {
                        ++lllllllllllllIlllIllllIIIllllIll;
                    }
                }
            }
            else {
                final TextComponentTranslation lllllllllllllIlllIllllIIIlllIlIl = new TextComponentTranslation("commands.generic.permission", new Object[0]);
                lllllllllllllIlllIllllIIIlllIlIl.getStyle().setColor(TextFormatting.RED);
                lllllllllllllIlllIllllIIlIIIIIII.addChatMessage(lllllllllllllIlllIllllIIIlllIlIl);
            }
        }
        catch (CommandException lllllllllllllIlllIllllIIIlllIlII) {
            final TextComponentTranslation lllllllllllllIlllIllllIIIlllIIll = new TextComponentTranslation(lllllllllllllIlllIllllIIIlllIlII.getMessage(), lllllllllllllIlllIllllIIIlllIlII.getErrorObjects());
            lllllllllllllIlllIllllIIIlllIIll.getStyle().setColor(TextFormatting.RED);
            lllllllllllllIlllIllllIIlIIIIIII.addChatMessage(lllllllllllllIlllIllllIIIlllIIll);
        }
        lllllllllllllIlllIllllIIlIIIIIII.setCommandStat(CommandResultStats.Type.SUCCESS_COUNT, lllllllllllllIlllIllllIIIllllIll);
        return lllllllllllllIlllIllllIIIllllIll;
    }
    
    @Override
    public Map<String, ICommand> getCommands() {
        return this.commandMap;
    }
    
    private int getUsernameIndex(final ICommand lllllllllllllIlllIllllIIIIIIIllI, final String[] lllllllllllllIlllIllllIIIIIIlIII) throws CommandException {
        if (lllllllllllllIlllIllllIIIIIIIllI == null) {
            return -1;
        }
        for (int lllllllllllllIlllIllllIIIIIIIlll = 0; lllllllllllllIlllIllllIIIIIIIlll < lllllllllllllIlllIllllIIIIIIlIII.length; ++lllllllllllllIlllIllllIIIIIIIlll) {
            if (lllllllllllllIlllIllllIIIIIIIllI.isUsernameIndex(lllllllllllllIlllIllllIIIIIIlIII, lllllllllllllIlllIllllIIIIIIIlll) && EntitySelector.matchesMultiplePlayers(lllllllllllllIlllIllllIIIIIIlIII[lllllllllllllIlllIllllIIIIIIIlll])) {
                return lllllllllllllIlllIllllIIIIIIIlll;
            }
        }
        return -1;
    }
    
    protected abstract MinecraftServer getServer();
    
    public ICommand registerCommand(final ICommand lllllllllllllIlllIllllIIIlIIIlll) {
        this.commandMap.put(lllllllllllllIlllIllllIIIlIIIlll.getCommandName(), lllllllllllllIlllIllllIIIlIIIlll);
        this.commandSet.add(lllllllllllllIlllIllllIIIlIIIlll);
        for (final String lllllllllllllIlllIllllIIIlIIIllI : lllllllllllllIlllIllllIIIlIIIlll.getCommandAliases()) {
            final ICommand lllllllllllllIlllIllllIIIlIIIlIl = this.commandMap.get(lllllllllllllIlllIllllIIIlIIIllI);
            if (lllllllllllllIlllIllllIIIlIIIlIl == null || !lllllllllllllIlllIllllIIIlIIIlIl.getCommandName().equals(lllllllllllllIlllIllllIIIlIIIllI)) {
                this.commandMap.put(lllllllllllllIlllIllllIIIlIIIllI, lllllllllllllIlllIllllIIIlIIIlll);
            }
        }
        return lllllllllllllIlllIllllIIIlIIIlll;
    }
    
    @Override
    public List<ICommand> getPossibleCommands(final ICommandSender lllllllllllllIlllIllllIIIIIllIII) {
        final List<ICommand> lllllllllllllIlllIllllIIIIIlIlll = (List<ICommand>)Lists.newArrayList();
        for (final ICommand lllllllllllllIlllIllllIIIIIlIllI : this.commandSet) {
            if (lllllllllllllIlllIllllIIIIIlIllI.checkPermission(this.getServer(), lllllllllllllIlllIllllIIIIIllIII)) {
                lllllllllllllIlllIllllIIIIIlIlll.add(lllllllllllllIlllIllllIIIIIlIllI);
            }
        }
        return lllllllllllllIlllIllllIIIIIlIlll;
    }
}
