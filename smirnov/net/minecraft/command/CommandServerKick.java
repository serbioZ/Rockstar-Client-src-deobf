// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandServerKick extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllIllllIlIIIllIlIlI) {
        return "commands.kick.usage";
    }
    
    @Override
    public String getCommandName() {
        return "kick";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllIllllIlIIIlIlIIII, final ICommandSender lllllllllllIIllIllllIlIIIlIlIIll, final String[] lllllllllllIIllIllllIlIIIlIlIIlI, @Nullable final BlockPos lllllllllllIIllIllllIlIIIlIlIIIl) {
        return (lllllllllllIIllIllllIlIIIlIlIIlI.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIllllIlIIIlIlIIlI, lllllllllllIIllIllllIlIIIlIlIIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllIllllIlIIIlIlllII, final ICommandSender lllllllllllIIllIllllIlIIIlIllIll, final String[] lllllllllllIIllIllllIlIIIllIIIII) throws CommandException {
        if (lllllllllllIIllIllllIlIIIllIIIII.length <= 0 || lllllllllllIIllIllllIlIIIllIIIII[0].length() <= 1) {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllIIllIllllIlIIIlIlllll = lllllllllllIIllIllllIlIIIlIlllII.getPlayerList().getPlayerByUsername(lllllllllllIIllIllllIlIIIllIIIII[0]);
        if (lllllllllllIIllIllllIlIIIlIlllll == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { lllllllllllIIllIllllIlIIIllIIIII[0] });
        }
        if (lllllllllllIIllIllllIlIIIllIIIII.length >= 2) {
            final ITextComponent lllllllllllIIllIllllIlIIIlIllllI = CommandBase.getChatComponentFromNthArg(lllllllllllIIllIllllIlIIIlIllIll, lllllllllllIIllIllllIlIIIllIIIII, 1);
            lllllllllllIIllIllllIlIIIlIlllll.connection.func_194028_b(lllllllllllIIllIllllIlIIIlIllllI);
            CommandBase.notifyCommandListener(lllllllllllIIllIllllIlIIIlIllIll, this, "commands.kick.success.reason", lllllllllllIIllIllllIlIIIlIlllll.getName(), lllllllllllIIllIllllIlIIIlIllllI.getUnformattedText());
        }
        else {
            lllllllllllIIllIllllIlIIIlIlllll.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.kicked", new Object[0]));
            CommandBase.notifyCommandListener(lllllllllllIIllIllllIlIIIlIllIll, this, "commands.kick.success", lllllllllllIIllIllllIlIIIlIlllll.getName());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
