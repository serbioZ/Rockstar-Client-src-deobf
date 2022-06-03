// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.WorldServer;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandTime extends CommandBase
{
    protected void setAllWorldTimes(final MinecraftServer lllllllllllIIIllIIIlIlllIIIllIII, final int lllllllllllIIIllIIIlIlllIIIlIlII) {
        for (int lllllllllllIIIllIIIlIlllIIIlIllI = 0; lllllllllllIIIllIIIlIlllIIIlIllI < lllllllllllIIIllIIIlIlllIIIllIII.worldServers.length; ++lllllllllllIIIllIIIlIlllIIIlIllI) {
            lllllllllllIIIllIIIlIlllIIIllIII.worldServers[lllllllllllIIIllIIIlIlllIIIlIllI].setWorldTime(lllllllllllIIIllIIIlIlllIIIlIlII);
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIIllIIIlIlllIIlIIIIl, final ICommandSender lllllllllllIIIllIIIlIlllIIlIIIII, final String[] lllllllllllIIIllIIIlIlllIIIlllll, @Nullable final BlockPos lllllllllllIIIllIIIlIlllIIIllllI) {
        if (lllllllllllIIIllIIIlIlllIIIlllll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIllIIIlIlllIIIlllll, "set", "add", "query");
        }
        if (lllllllllllIIIllIIIlIlllIIIlllll.length == 2 && "set".equals(lllllllllllIIIllIIIlIlllIIIlllll[0])) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIllIIIlIlllIIIlllll, "day", "night");
        }
        return (lllllllllllIIIllIIIlIlllIIIlllll.length == 2 && "query".equals(lllllllllllIIIllIIIlIlllIIIlllll[0])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIllIIIlIlllIIIlllll, "daytime", "gametime", "day") : Collections.emptyList();
    }
    
    protected void incrementAllWorldTimes(final MinecraftServer lllllllllllIIIllIIIlIlllIIIIlIIl, final int lllllllllllIIIllIIIlIlllIIIIlIII) {
        for (int lllllllllllIIIllIIIlIlllIIIIlIll = 0; lllllllllllIIIllIIIlIlllIIIIlIll < lllllllllllIIIllIIIlIlllIIIIlIIl.worldServers.length; ++lllllllllllIIIllIIIlIlllIIIIlIll) {
            final WorldServer lllllllllllIIIllIIIlIlllIIIIlIlI = lllllllllllIIIllIIIlIlllIIIIlIIl.worldServers[lllllllllllIIIllIIIlIlllIIIIlIll];
            lllllllllllIIIllIIIlIlllIIIIlIlI.setWorldTime(lllllllllllIIIllIIIlIlllIIIIlIlI.getWorldTime() + lllllllllllIIIllIIIlIlllIIIIlIII);
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIIllIIIlIlllIIllIIlI, final ICommandSender lllllllllllIIIllIIIlIlllIIlIIllI, final String[] lllllllllllIIIllIIIlIlllIIllIIII) throws CommandException {
        if (lllllllllllIIIllIIIlIlllIIllIIII.length > 1) {
            if ("set".equals(lllllllllllIIIllIIIlIlllIIllIIII[0])) {
                int lllllllllllIIIllIIIlIlllIIlIllIl = 0;
                if ("day".equals(lllllllllllIIIllIIIlIlllIIllIIII[1])) {
                    final int lllllllllllIIIllIIIlIlllIIlIllll = 1000;
                }
                else if ("night".equals(lllllllllllIIIllIIIlIlllIIllIIII[1])) {
                    final int lllllllllllIIIllIIIlIlllIIlIlllI = 13000;
                }
                else {
                    lllllllllllIIIllIIIlIlllIIlIllIl = CommandBase.parseInt(lllllllllllIIIllIIIlIlllIIllIIII[1], 0);
                }
                this.setAllWorldTimes(lllllllllllIIIllIIIlIlllIIllIIlI, lllllllllllIIIllIIIlIlllIIlIllIl);
                CommandBase.notifyCommandListener(lllllllllllIIIllIIIlIlllIIlIIllI, this, "commands.time.set", lllllllllllIIIllIIIlIlllIIlIllIl);
                return;
            }
            if ("add".equals(lllllllllllIIIllIIIlIlllIIllIIII[0])) {
                final int lllllllllllIIIllIIIlIlllIIlIllII = CommandBase.parseInt(lllllllllllIIIllIIIlIlllIIllIIII[1], 0);
                this.incrementAllWorldTimes(lllllllllllIIIllIIIlIlllIIllIIlI, lllllllllllIIIllIIIlIlllIIlIllII);
                CommandBase.notifyCommandListener(lllllllllllIIIllIIIlIlllIIlIIllI, this, "commands.time.added", lllllllllllIIIllIIIlIlllIIlIllII);
                return;
            }
            if ("query".equals(lllllllllllIIIllIIIlIlllIIllIIII[0])) {
                if ("daytime".equals(lllllllllllIIIllIIIlIlllIIllIIII[1])) {
                    final int lllllllllllIIIllIIIlIlllIIlIlIll = (int)(lllllllllllIIIllIIIlIlllIIlIIllI.getEntityWorld().getWorldTime() % 24000L);
                    lllllllllllIIIllIIIlIlllIIlIIllI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIIIllIIIlIlllIIlIlIll);
                    CommandBase.notifyCommandListener(lllllllllllIIIllIIIlIlllIIlIIllI, this, "commands.time.query", lllllllllllIIIllIIIlIlllIIlIlIll);
                    return;
                }
                if ("day".equals(lllllllllllIIIllIIIlIlllIIllIIII[1])) {
                    final int lllllllllllIIIllIIIlIlllIIlIlIlI = (int)(lllllllllllIIIllIIIlIlllIIlIIllI.getEntityWorld().getWorldTime() / 24000L % 2147483647L);
                    lllllllllllIIIllIIIlIlllIIlIIllI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIIIllIIIlIlllIIlIlIlI);
                    CommandBase.notifyCommandListener(lllllllllllIIIllIIIlIlllIIlIIllI, this, "commands.time.query", lllllllllllIIIllIIIlIlllIIlIlIlI);
                    return;
                }
                if ("gametime".equals(lllllllllllIIIllIIIlIlllIIllIIII[1])) {
                    final int lllllllllllIIIllIIIlIlllIIlIlIIl = (int)(lllllllllllIIIllIIIlIlllIIlIIllI.getEntityWorld().getTotalWorldTime() % 2147483647L);
                    lllllllllllIIIllIIIlIlllIIlIIllI.setCommandStat(CommandResultStats.Type.QUERY_RESULT, lllllllllllIIIllIIIlIlllIIlIlIIl);
                    CommandBase.notifyCommandListener(lllllllllllIIIllIIIlIlllIIlIIllI, this, "commands.time.query", lllllllllllIIIllIIIlIlllIIlIlIIl);
                    return;
                }
            }
        }
        throw new WrongUsageException("commands.time.usage", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "time";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIIllIIIlIlllIIlllIIl) {
        return "commands.time.usage";
    }
}
