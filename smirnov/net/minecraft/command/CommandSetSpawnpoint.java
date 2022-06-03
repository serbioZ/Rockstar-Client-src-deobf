// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandSetSpawnpoint extends CommandBase
{
    @Override
    public void execute(final MinecraftServer lllllllllllIllIlIllIlIIlIllIIllI, final ICommandSender lllllllllllIllIlIllIlIIlIllIIlIl, final String[] lllllllllllIllIlIllIlIIlIllIIlII) throws CommandException {
        if (lllllllllllIllIlIllIlIIlIllIIlII.length > 1 && lllllllllllIllIlIllIlIIlIllIIlII.length < 4) {
            throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
        }
        final EntityPlayerMP lllllllllllIllIlIllIlIIlIllIIIll = (lllllllllllIllIlIllIlIIlIllIIlII.length > 0) ? CommandBase.getPlayer(lllllllllllIllIlIllIlIIlIllIIllI, lllllllllllIllIlIllIlIIlIllIIlIl, lllllllllllIllIlIllIlIIlIllIIlII[0]) : CommandBase.getCommandSenderAsPlayer(lllllllllllIllIlIllIlIIlIllIIlIl);
        final BlockPos lllllllllllIllIlIllIlIIlIllIIIlI = (lllllllllllIllIlIllIlIIlIllIIlII.length > 3) ? CommandBase.parseBlockPos(lllllllllllIllIlIllIlIIlIllIIlIl, lllllllllllIllIlIllIlIIlIllIIlII, 1, true) : lllllllllllIllIlIllIlIIlIllIIIll.getPosition();
        if (lllllllllllIllIlIllIlIIlIllIIIll.world != null) {
            lllllllllllIllIlIllIlIIlIllIIIll.setSpawnPoint(lllllllllllIllIlIllIlIIlIllIIIlI, true);
            CommandBase.notifyCommandListener(lllllllllllIllIlIllIlIIlIllIIlIl, this, "commands.spawnpoint.success", lllllllllllIllIlIllIlIIlIllIIIll.getName(), lllllllllllIllIlIllIlIIlIllIIIlI.getX(), lllllllllllIllIlIllIlIIlIllIIIlI.getY(), lllllllllllIllIlIllIlIIlIllIIIlI.getZ());
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIllIlIllIlIIlIlIlIlll, final ICommandSender lllllllllllIllIlIllIlIIlIlIlIllI, final String[] lllllllllllIllIlIllIlIIlIlIlIIlI, @Nullable final BlockPos lllllllllllIllIlIllIlIIlIlIlIIIl) {
        if (lllllllllllIllIlIllIlIIlIlIlIIlI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIlIllIlIIlIlIlIIlI, lllllllllllIllIlIllIlIIlIlIlIlll.getAllUsernames());
        }
        return (lllllllllllIllIlIllIlIIlIlIlIIlI.length > 1 && lllllllllllIllIlIllIlIIlIlIlIIlI.length <= 4) ? CommandBase.getTabCompletionCoordinate(lllllllllllIllIlIllIlIIlIlIlIIlI, 1, lllllllllllIllIlIllIlIIlIlIlIIIl) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "spawnpoint";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIllIlIllIlIIlIllIlllI) {
        return "commands.spawnpoint.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIlIllIlIIlIlIIlllI, final int lllllllllllIllIlIllIlIIlIlIIllIl) {
        return lllllllllllIllIlIllIlIIlIlIIllIl == 0;
    }
}
