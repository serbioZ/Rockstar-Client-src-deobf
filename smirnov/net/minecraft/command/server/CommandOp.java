// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.ICommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import com.mojang.authlib.GameProfile;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandOp extends CommandBase
{
    @Override
    public String getCommandName() {
        return "op";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIlIIIlIIIlIlllIllll, final ICommandSender lllllllllllIlIlIIIlIIIlIllllIlIl, final String[] lllllllllllIlIlIIIlIIIlIllllIlII, @Nullable final BlockPos lllllllllllIlIlIIIlIIIlIllllIIll) {
        if (lllllllllllIlIlIIIlIIIlIllllIlII.length == 1) {
            final String lllllllllllIlIlIIIlIIIlIllllIIlI = lllllllllllIlIlIIIlIIIlIllllIlII[lllllllllllIlIlIIIlIIIlIllllIlII.length - 1];
            final List<String> lllllllllllIlIlIIIlIIIlIllllIIIl = (List<String>)Lists.newArrayList();
            final float lllllllllllIlIlIIIlIIIlIlllIlIII;
            final Exception lllllllllllIlIlIIIlIIIlIlllIlIIl = (Exception)((GameProfile[])(Object)(lllllllllllIlIlIIIlIIIlIlllIlIII = (float)(Object)lllllllllllIlIlIIIlIIIlIlllIllll.getGameProfiles())).length;
            for (long lllllllllllIlIlIIIlIIIlIlllIlIlI = 0; lllllllllllIlIlIIIlIIIlIlllIlIlI < lllllllllllIlIlIIIlIIIlIlllIlIIl; ++lllllllllllIlIlIIIlIIIlIlllIlIlI) {
                final GameProfile lllllllllllIlIlIIIlIIIlIllllIIII = lllllllllllIlIlIIIlIIIlIlllIlIII[lllllllllllIlIlIIIlIIIlIlllIlIlI];
                if (!lllllllllllIlIlIIIlIIIlIlllIllll.getPlayerList().canSendCommands(lllllllllllIlIlIIIlIIIlIllllIIII) && CommandBase.doesStringStartWith(lllllllllllIlIlIIIlIIIlIllllIIlI, lllllllllllIlIlIIIlIIIlIllllIIII.getName())) {
                    lllllllllllIlIlIIIlIIIlIllllIIIl.add(lllllllllllIlIlIIIlIIIlIllllIIII.getName());
                }
            }
            return lllllllllllIlIlIIIlIIIlIllllIIIl;
        }
        return Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlIlIIIlIIIllIIIIIIll, final ICommandSender lllllllllllIlIlIIIlIIIllIIIIIlll, final String[] lllllllllllIlIlIIIlIIIllIIIIIIIl) throws CommandException {
        if (lllllllllllIlIlIIIlIIIllIIIIIIIl.length != 1 || lllllllllllIlIlIIIlIIIllIIIIIIIl[0].length() <= 0) {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
        final GameProfile lllllllllllIlIlIIIlIIIllIIIIIlIl = lllllllllllIlIlIIIlIIIllIIIIIIll.getPlayerProfileCache().getGameProfileForUsername(lllllllllllIlIlIIIlIIIllIIIIIIIl[0]);
        if (lllllllllllIlIlIIIlIIIllIIIIIlIl == null) {
            throw new CommandException("commands.op.failed", new Object[] { lllllllllllIlIlIIIlIIIllIIIIIIIl[0] });
        }
        lllllllllllIlIlIIIlIIIllIIIIIIll.getPlayerList().addOp(lllllllllllIlIlIIIlIIIllIIIIIlIl);
        CommandBase.notifyCommandListener(lllllllllllIlIlIIIlIIIllIIIIIlll, this, "commands.op.success", lllllllllllIlIlIIIlIIIllIIIIIIIl[0]);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIlIIIlIIIllIIIIllll) {
        return "commands.op.usage";
    }
}
