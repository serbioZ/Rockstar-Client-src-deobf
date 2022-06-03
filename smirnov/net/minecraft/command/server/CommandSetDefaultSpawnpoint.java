// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandSetDefaultSpawnpoint extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "setworldspawn";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllIIIlIllIIlIlIIIII) {
        return "commands.setworldspawn.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIllIIIlIllIIlIIIllII, final ICommandSender llllllllllllIllIIIlIllIIlIIIlIll, final String[] llllllllllllIllIIIlIllIIlIIIlIlI, @Nullable final BlockPos llllllllllllIllIIIlIllIIlIIIIlll) {
        return (llllllllllllIllIIIlIllIIlIIIlIlI.length > 0 && llllllllllllIllIIIlIllIIlIIIlIlI.length <= 3) ? CommandBase.getTabCompletionCoordinate(llllllllllllIllIIIlIllIIlIIIlIlI, 0, llllllllllllIllIIIlIllIIlIIIIlll) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIllIIIlIllIIlIIllIIl, final ICommandSender llllllllllllIllIIIlIllIIlIIllIII, final String[] llllllllllllIllIIIlIllIIlIIlIIIl) throws CommandException {
        BlockPos llllllllllllIllIIIlIllIIlIIlIlIl = null;
        if (llllllllllllIllIIIlIllIIlIIlIIIl.length == 0) {
            final BlockPos llllllllllllIllIIIlIllIIlIIlIllI = CommandBase.getCommandSenderAsPlayer(llllllllllllIllIIIlIllIIlIIllIII).getPosition();
        }
        else {
            if (llllllllllllIllIIIlIllIIlIIlIIIl.length != 3 || llllllllllllIllIIIlIllIIlIIllIII.getEntityWorld() == null) {
                throw new WrongUsageException("commands.setworldspawn.usage", new Object[0]);
            }
            llllllllllllIllIIIlIllIIlIIlIlIl = CommandBase.parseBlockPos(llllllllllllIllIIIlIllIIlIIllIII, llllllllllllIllIIIlIllIIlIIlIIIl, 0, true);
        }
        llllllllllllIllIIIlIllIIlIIllIII.getEntityWorld().setSpawnPoint(llllllllllllIllIIIlIllIIlIIlIlIl);
        llllllllllllIllIIIlIllIIlIIllIIl.getPlayerList().sendPacketToAllPlayers(new SPacketSpawnPosition(llllllllllllIllIIIlIllIIlIIlIlIl));
        CommandBase.notifyCommandListener(llllllllllllIllIIIlIllIIlIIllIII, this, "commands.setworldspawn.success", llllllllllllIllIIIlIllIIlIIlIlIl.getX(), llllllllllllIllIIIlIllIIlIIlIlIl.getY(), llllllllllllIllIIIlIllIIlIIlIlIl.getZ());
    }
}
