// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.server.management.UserList;
import net.minecraft.entity.player.EntityPlayerMP;
import com.mojang.authlib.GameProfile;
import net.minecraft.command.ICommand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Date;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandBanPlayer extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIIIIIIllIlIIIIllIIl) {
        return "commands.ban.usage";
    }
    
    @Override
    public String getCommandName() {
        return "ban";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllIlIIIIIIllIlIIIIlIIIl, final ICommandSender lllllllllllIlIIIIIIllIlIIIIlIIII) {
        return lllllllllllIlIIIIIIllIlIIIIlIIIl.getPlayerList().getBannedPlayers().isLanServer() && super.checkPermission(lllllllllllIlIIIIIIllIlIIIIlIIIl, lllllllllllIlIIIIIIllIlIIIIlIIII);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIIIIIIllIIlllllIIII, final ICommandSender lllllllllllIlIIIIIIllIIlllllIIll, final String[] lllllllllllIlIIIIIIllIIllllIllll, @Nullable final BlockPos lllllllllllIlIIIIIIllIIlllllIIIl) {
        return (lllllllllllIlIIIIIIllIIllllIllll.length >= 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIIIIIIllIIllllIllll, lllllllllllIlIIIIIIllIIlllllIIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlIIIIIIllIIllllllllI, final ICommandSender lllllllllllIlIIIIIIllIIlllllllIl, final String[] lllllllllllIlIIIIIIllIlIIIIIIlII) throws CommandException {
        if (lllllllllllIlIIIIIIllIlIIIIIIlII.length < 1 || lllllllllllIlIIIIIIllIlIIIIIIlII[0].length() <= 0) {
            throw new WrongUsageException("commands.ban.usage", new Object[0]);
        }
        final GameProfile lllllllllllIlIIIIIIllIlIIIIIIIll = lllllllllllIlIIIIIIllIIllllllllI.getPlayerProfileCache().getGameProfileForUsername(lllllllllllIlIIIIIIllIlIIIIIIlII[0]);
        if (lllllllllllIlIIIIIIllIlIIIIIIIll == null) {
            throw new CommandException("commands.ban.failed", new Object[] { lllllllllllIlIIIIIIllIlIIIIIIlII[0] });
        }
        String lllllllllllIlIIIIIIllIlIIIIIIIlI = null;
        if (lllllllllllIlIIIIIIllIlIIIIIIlII.length >= 2) {
            lllllllllllIlIIIIIIllIlIIIIIIIlI = CommandBase.getChatComponentFromNthArg(lllllllllllIlIIIIIIllIIlllllllIl, lllllllllllIlIIIIIIllIlIIIIIIlII, 1).getUnformattedText();
        }
        final UserListBansEntry lllllllllllIlIIIIIIllIlIIIIIIIIl = new UserListBansEntry(lllllllllllIlIIIIIIllIlIIIIIIIll, null, lllllllllllIlIIIIIIllIIlllllllIl.getName(), null, lllllllllllIlIIIIIIllIlIIIIIIIlI);
        ((UserList<K, UserListBansEntry>)lllllllllllIlIIIIIIllIIllllllllI.getPlayerList().getBannedPlayers()).addEntry(lllllllllllIlIIIIIIllIlIIIIIIIIl);
        final EntityPlayerMP lllllllllllIlIIIIIIllIlIIIIIIIII = lllllllllllIlIIIIIIllIIllllllllI.getPlayerList().getPlayerByUsername(lllllllllllIlIIIIIIllIlIIIIIIlII[0]);
        if (lllllllllllIlIIIIIIllIlIIIIIIIII != null) {
            lllllllllllIlIIIIIIllIlIIIIIIIII.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.banned", new Object[0]));
        }
        CommandBase.notifyCommandListener(lllllllllllIlIIIIIIllIIlllllllIl, this, "commands.ban.success", lllllllllllIlIIIIIIllIlIIIIIIlII[0]);
    }
}
