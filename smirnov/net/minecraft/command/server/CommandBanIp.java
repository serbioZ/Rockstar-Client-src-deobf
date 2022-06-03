// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.server.management.UserList;
import net.minecraft.command.ICommand;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Date;
import net.minecraft.server.management.UserListIPBansEntry;
import net.minecraft.command.CommandException;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.regex.Matcher;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.PlayerNotFoundException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import java.util.regex.Pattern;
import net.minecraft.command.CommandBase;

public class CommandBanIp extends CommandBase
{
    public static final /* synthetic */ Pattern IP_PATTERN;
    
    @Override
    public String getCommandName() {
        return "ban-ip";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIlIIIllllIlIIIlIlII, final ICommandSender llllllllllllIIlIIIllllIlIIIlIlll, final String[] llllllllllllIIlIIIllllIlIIIlIllI, @Nullable final BlockPos llllllllllllIIlIIIllllIlIIIlIlIl) {
        return (llllllllllllIIlIIIllllIlIIIlIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlIIIllllIlIIIlIllI, llllllllllllIIlIIIllllIlIIIlIlII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIlIIIllllIlIIlIIIIl, final ICommandSender llllllllllllIIlIIIllllIlIIlIIlll, final String[] llllllllllllIIlIIIllllIlIIIlllll) throws CommandException {
        if (llllllllllllIIlIIIllllIlIIIlllll.length >= 1 && llllllllllllIIlIIIllllIlIIIlllll[0].length() > 1) {
            final ITextComponent llllllllllllIIlIIIllllIlIIlIIlIl = (llllllllllllIIlIIIllllIlIIIlllll.length >= 2) ? CommandBase.getChatComponentFromNthArg(llllllllllllIIlIIIllllIlIIlIIlll, llllllllllllIIlIIIllllIlIIIlllll, 1) : null;
            final Matcher llllllllllllIIlIIIllllIlIIlIIlII = CommandBanIp.IP_PATTERN.matcher(llllllllllllIIlIIIllllIlIIIlllll[0]);
            if (llllllllllllIIlIIIllllIlIIlIIlII.matches()) {
                this.banIp(llllllllllllIIlIIIllllIlIIlIIIIl, llllllllllllIIlIIIllllIlIIlIIlll, llllllllllllIIlIIIllllIlIIIlllll[0], (llllllllllllIIlIIIllllIlIIlIIlIl == null) ? null : llllllllllllIIlIIIllllIlIIlIIlIl.getUnformattedText());
            }
            else {
                final EntityPlayerMP llllllllllllIIlIIIllllIlIIlIIIll = llllllllllllIIlIIIllllIlIIlIIIIl.getPlayerList().getPlayerByUsername(llllllllllllIIlIIIllllIlIIIlllll[0]);
                if (llllllllllllIIlIIIllllIlIIlIIIll == null) {
                    throw new PlayerNotFoundException("commands.banip.invalid");
                }
                this.banIp(llllllllllllIIlIIIllllIlIIlIIIIl, llllllllllllIIlIIIllllIlIIlIIlll, llllllllllllIIlIIIllllIlIIlIIIll.getPlayerIP(), (llllllllllllIIlIIIllllIlIIlIIlIl == null) ? null : llllllllllllIIlIIIllllIlIIlIIlIl.getUnformattedText());
            }
            return;
        }
        throw new WrongUsageException("commands.banip.usage", new Object[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    protected void banIp(final MinecraftServer llllllllllllIIlIIIllllIIllllllII, final ICommandSender llllllllllllIIlIIIllllIlIIIIIlIl, final String llllllllllllIIlIIIllllIIlllllIlI, @Nullable final String llllllllllllIIlIIIllllIIlllllIIl) {
        final UserListIPBansEntry llllllllllllIIlIIIllllIlIIIIIIlI = new UserListIPBansEntry(llllllllllllIIlIIIllllIIlllllIlI, null, llllllllllllIIlIIIllllIlIIIIIlIl.getName(), null, llllllllllllIIlIIIllllIIlllllIIl);
        ((UserList<K, UserListIPBansEntry>)llllllllllllIIlIIIllllIIllllllII.getPlayerList().getBannedIPs()).addEntry(llllllllllllIIlIIIllllIlIIIIIIlI);
        final List<EntityPlayerMP> llllllllllllIIlIIIllllIlIIIIIIIl = llllllllllllIIlIIIllllIIllllllII.getPlayerList().getPlayersMatchingAddress(llllllllllllIIlIIIllllIIlllllIlI);
        final String[] llllllllllllIIlIIIllllIlIIIIIIII = new String[llllllllllllIIlIIIllllIlIIIIIIIl.size()];
        int llllllllllllIIlIIIllllIIllllllll = 0;
        for (final EntityPlayerMP llllllllllllIIlIIIllllIIlllllllI : llllllllllllIIlIIIllllIlIIIIIIIl) {
            llllllllllllIIlIIIllllIIlllllllI.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.ip_banned", new Object[0]));
            llllllllllllIIlIIIllllIlIIIIIIII[llllllllllllIIlIIIllllIIllllllll++] = llllllllllllIIlIIIllllIIlllllllI.getName();
        }
        if (llllllllllllIIlIIIllllIlIIIIIIIl.isEmpty()) {
            CommandBase.notifyCommandListener(llllllllllllIIlIIIllllIlIIIIIlIl, this, "commands.banip.success", llllllllllllIIlIIIllllIIlllllIlI);
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllIIlIIIllllIlIIIIIlIl, this, "commands.banip.success.players", llllllllllllIIlIIIllllIIlllllIlI, CommandBase.joinNiceString(llllllllllllIIlIIIllllIlIIIIIIII));
        }
    }
    
    static {
        IP_PATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlIIIllllIlIIllIIIl) {
        return "commands.banip.usage";
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer llllllllllllIIlIIIllllIlIIllIlll, final ICommandSender llllllllllllIIlIIIllllIlIIllIIll) {
        return llllllllllllIIlIIIllllIlIIllIlll.getPlayerList().getBannedIPs().isLanServer() && super.checkPermission(llllllllllllIIlIIIllllIlIIllIlll, llllllllllllIIlIIIllllIlIIllIIll);
    }
}
