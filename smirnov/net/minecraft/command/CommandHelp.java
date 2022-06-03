// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Arrays;
import java.util.Map;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import java.util.Random;

public class CommandHelp extends CommandBase
{
    private final /* synthetic */ Random rand;
    private static final /* synthetic */ String[] seargeSays;
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIllIIlIIIIllIIIlII, final ICommandSender lllllllllllllIIllIIlIIIIllIIIIll, final String[] lllllllllllllIIllIIlIIIIllIIIIlI, @Nullable final BlockPos lllllllllllllIIllIIlIIIIllIIIIIl) {
        if (lllllllllllllIIllIIlIIIIllIIIIlI.length == 1) {
            final Set<String> lllllllllllllIIllIIlIIIIllIIIIII = this.getCommandMap(lllllllllllllIIllIIlIIIIllIIIlII).keySet();
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIllIIlIIIIllIIIIlI, (String[])lllllllllllllIIllIIlIIIIllIIIIII.toArray(new String[lllllllllllllIIllIIlIIIIllIIIIII.size()]));
        }
        return Collections.emptyList();
    }
    
    static {
        seargeSays = new String[] { "Yolo", "Ask for help on twitter", "/deop @p", "Scoreboard deleted, commands blocked", "Contact helpdesk for help", "/testfornoob @p", "/trigger warning", "Oh my god, it's full of stats", "/kill @p[name=!Searge]", "Have you tried turning it off and on again?", "Sorry, no help today" };
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIllIIlIIIIlllIIIll, final ICommandSender lllllllllllllIIllIIlIIIIlllIIIlI, final String[] lllllllllllllIIllIIlIIIIlllIIIIl) throws CommandException {
        if (lllllllllllllIIllIIlIIIIlllIIIlI instanceof CommandBlockBaseLogic) {
            lllllllllllllIIllIIlIIIIlllIIIlI.addChatMessage(new TextComponentString("Searge says: ").appendText(CommandHelp.seargeSays[this.rand.nextInt(CommandHelp.seargeSays.length) % CommandHelp.seargeSays.length]));
        }
        else {
            final List<ICommand> lllllllllllllIIllIIlIIIIllllIIIl = this.getSortedPossibleCommands(lllllllllllllIIllIIlIIIIlllIIIlI, lllllllllllllIIllIIlIIIIlllIIIll);
            final int lllllllllllllIIllIIlIIIIllllIIII = 7;
            final int lllllllllllllIIllIIlIIIIlllIllll = (lllllllllllllIIllIIlIIIIllllIIIl.size() - 1) / 7;
            int lllllllllllllIIllIIlIIIIlllIlllI = 0;
            try {
                lllllllllllllIIllIIlIIIIlllIlllI = ((lllllllllllllIIllIIlIIIIlllIIIIl.length == 0) ? 0 : (CommandBase.parseInt(lllllllllllllIIllIIlIIIIlllIIIIl[0], 1, lllllllllllllIIllIIlIIIIlllIllll + 1) - 1));
            }
            catch (NumberInvalidException lllllllllllllIIllIIlIIIIlllIllIl) {
                final Map<String, ICommand> lllllllllllllIIllIIlIIIIlllIllII = this.getCommandMap(lllllllllllllIIllIIlIIIIlllIIIll);
                final ICommand lllllllllllllIIllIIlIIIIlllIlIll = lllllllllllllIIllIIlIIIIlllIllII.get(lllllllllllllIIllIIlIIIIlllIIIIl[0]);
                if (lllllllllllllIIllIIlIIIIlllIlIll != null) {
                    throw new WrongUsageException(lllllllllllllIIllIIlIIIIlllIlIll.getCommandUsage(lllllllllllllIIllIIlIIIIlllIIIlI), new Object[0]);
                }
                if (MathHelper.getInt(lllllllllllllIIllIIlIIIIlllIIIIl[0], -1) == -1 && MathHelper.getInt(lllllllllllllIIllIIlIIIIlllIIIIl[0], -2) == -2) {
                    throw new CommandNotFoundException();
                }
                throw lllllllllllllIIllIIlIIIIlllIllIl;
            }
            final int lllllllllllllIIllIIlIIIIlllIlIlI = Math.min((lllllllllllllIIllIIlIIIIlllIlllI + 1) * 7, lllllllllllllIIllIIlIIIIllllIIIl.size());
            final TextComponentTranslation lllllllllllllIIllIIlIIIIlllIlIIl = new TextComponentTranslation("commands.help.header", new Object[] { lllllllllllllIIllIIlIIIIlllIlllI + 1, lllllllllllllIIllIIlIIIIlllIllll + 1 });
            lllllllllllllIIllIIlIIIIlllIlIIl.getStyle().setColor(TextFormatting.DARK_GREEN);
            lllllllllllllIIllIIlIIIIlllIIIlI.addChatMessage(lllllllllllllIIllIIlIIIIlllIlIIl);
            for (int lllllllllllllIIllIIlIIIIlllIlIII = lllllllllllllIIllIIlIIIIlllIlllI * 7; lllllllllllllIIllIIlIIIIlllIlIII < lllllllllllllIIllIIlIIIIlllIlIlI; ++lllllllllllllIIllIIlIIIIlllIlIII) {
                final ICommand lllllllllllllIIllIIlIIIIlllIIlll = lllllllllllllIIllIIlIIIIllllIIIl.get(lllllllllllllIIllIIlIIIIlllIlIII);
                final TextComponentTranslation lllllllllllllIIllIIlIIIIlllIIllI = new TextComponentTranslation(lllllllllllllIIllIIlIIIIlllIIlll.getCommandUsage(lllllllllllllIIllIIlIIIIlllIIIlI), new Object[0]);
                lllllllllllllIIllIIlIIIIlllIIllI.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + lllllllllllllIIllIIlIIIIlllIIlll.getCommandName() + " "));
                lllllllllllllIIllIIlIIIIlllIIIlI.addChatMessage(lllllllllllllIIllIIlIIIIlllIIllI);
            }
            if (lllllllllllllIIllIIlIIIIlllIlllI == 0) {
                final TextComponentTranslation lllllllllllllIIllIIlIIIIlllIIlIl = new TextComponentTranslation("commands.help.footer", new Object[0]);
                lllllllllllllIIllIIlIIIIlllIIlIl.getStyle().setColor(TextFormatting.GREEN);
                lllllllllllllIIllIIlIIIIlllIIIlI.addChatMessage(lllllllllllllIIllIIlIIIIlllIIlIl);
            }
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIllIIlIIIlIIIIIlII) {
        return "commands.help.usage";
    }
    
    protected List<ICommand> getSortedPossibleCommands(final ICommandSender lllllllllllllIIllIIlIIIIllIlIIll, final MinecraftServer lllllllllllllIIllIIlIIIIllIlIIlI) {
        final List<ICommand> lllllllllllllIIllIIlIIIIllIlIIIl = lllllllllllllIIllIIlIIIIllIlIIlI.getCommandManager().getPossibleCommands(lllllllllllllIIllIIlIIIIllIlIIll);
        Collections.sort(lllllllllllllIIllIIlIIIIllIlIIIl);
        return lllllllllllllIIllIIlIIIIllIlIIIl;
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("?");
    }
    
    protected Map<String, ICommand> getCommandMap(final MinecraftServer lllllllllllllIIllIIlIIIIllIIlIlI) {
        return lllllllllllllIIllIIlIIIIllIIlIlI.getCommandManager().getCommands();
    }
    
    public CommandHelp() {
        this.rand = new Random();
    }
    
    @Override
    public String getCommandName() {
        return "help";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
