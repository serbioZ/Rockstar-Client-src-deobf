// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandBroadcast extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIIIIIllIlIIlIIlIlIl, final ICommandSender lllllllllllIlIIIIIllIlIIlIIlIlII, final String[] lllllllllllIlIIIIIllIlIIlIIlIIII, @Nullable final BlockPos lllllllllllIlIIIIIllIlIIlIIlIIlI) {
        return (lllllllllllIlIIIIIllIlIIlIIlIIII.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIIIIIllIlIIlIIlIIII, lllllllllllIlIIIIIllIlIIlIIlIlIl.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlIIIIIllIlIIlIIlllII, final ICommandSender lllllllllllIlIIIIIllIlIIlIIlllll, final String[] lllllllllllIlIIIIIllIlIIlIIllllI) throws CommandException {
        if (lllllllllllIlIIIIIllIlIIlIIllllI.length > 0 && lllllllllllIlIIIIIllIlIIlIIllllI[0].length() > 0) {
            final ITextComponent lllllllllllIlIIIIIllIlIIlIIlllIl = CommandBase.getChatComponentFromNthArg(lllllllllllIlIIIIIllIlIIlIIlllll, lllllllllllIlIIIIIllIlIIlIIllllI, 0, true);
            lllllllllllIlIIIIIllIlIIlIIlllII.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.announcement", new Object[] { lllllllllllIlIIIIIllIlIIlIIlllll.getDisplayName(), lllllllllllIlIIIIIllIlIIlIIlllIl }));
            return;
        }
        throw new WrongUsageException("commands.say.usage", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "say";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIIIIIllIlIIlIlIIllI) {
        return "commands.say.usage";
    }
}
