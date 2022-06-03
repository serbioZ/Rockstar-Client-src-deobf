// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandMessage extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIlIlllIIlIIlllIIlI, final int lllllllllllIllIlIlllIIlIIlllIIII) {
        return lllllllllllIllIlIlllIIlIIlllIIII == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIllIlIlllIIlIlIIlIlII) {
        return "commands.message.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIllIlIlllIIlIIllllIlI, final ICommandSender lllllllllllIllIlIlllIIlIIllllIIl, final String[] lllllllllllIllIlIlllIIlIIllllIII, @Nullable final BlockPos lllllllllllIllIlIlllIIlIIlllIlll) {
        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIlIlllIIlIIllllIII, lllllllllllIllIlIlllIIlIIllllIlI.getAllUsernames());
    }
    
    @Override
    public String getCommandName() {
        return "tell";
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("w", "msg");
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIllIlIlllIIlIlIIIlIll, final ICommandSender lllllllllllIllIlIlllIIlIlIIIlIlI, final String[] lllllllllllIllIlIlllIIlIlIIIlIIl) throws CommandException {
        if (lllllllllllIllIlIlllIIlIlIIIlIIl.length < 2) {
            throw new WrongUsageException("commands.message.usage", new Object[0]);
        }
        final EntityPlayer lllllllllllIllIlIlllIIlIlIIIlIII = CommandBase.getPlayer(lllllllllllIllIlIlllIIlIlIIIlIll, lllllllllllIllIlIlllIIlIlIIIlIlI, lllllllllllIllIlIlllIIlIlIIIlIIl[0]);
        if (lllllllllllIllIlIlllIIlIlIIIlIII == lllllllllllIllIlIlllIIlIlIIIlIlI) {
            throw new PlayerNotFoundException("commands.message.sameTarget");
        }
        final ITextComponent lllllllllllIllIlIlllIIlIlIIIIlll = CommandBase.getChatComponentFromNthArg(lllllllllllIllIlIlllIIlIlIIIlIlI, lllllllllllIllIlIlllIIlIlIIIlIIl, 1, !(lllllllllllIllIlIlllIIlIlIIIlIlI instanceof EntityPlayer));
        final TextComponentTranslation lllllllllllIllIlIlllIIlIlIIIIllI = new TextComponentTranslation("commands.message.display.incoming", new Object[] { lllllllllllIllIlIlllIIlIlIIIlIlI.getDisplayName(), lllllllllllIllIlIlllIIlIlIIIIlll.createCopy() });
        final TextComponentTranslation lllllllllllIllIlIlllIIlIlIIIIlIl = new TextComponentTranslation("commands.message.display.outgoing", new Object[] { lllllllllllIllIlIlllIIlIlIIIlIII.getDisplayName(), lllllllllllIllIlIlllIIlIlIIIIlll.createCopy() });
        lllllllllllIllIlIlllIIlIlIIIIllI.getStyle().setColor(TextFormatting.GRAY).setItalic(true);
        lllllllllllIllIlIlllIIlIlIIIIlIl.getStyle().setColor(TextFormatting.GRAY).setItalic(true);
        lllllllllllIllIlIlllIIlIlIIIlIII.addChatMessage(lllllllllllIllIlIlllIIlIlIIIIllI);
        lllllllllllIllIlIlllIIlIlIIIlIlI.addChatMessage(lllllllllllIllIlIlllIIlIlIIIIlIl);
    }
}
