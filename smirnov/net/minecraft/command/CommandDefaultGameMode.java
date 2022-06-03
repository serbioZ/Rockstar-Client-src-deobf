// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameType;

public class CommandDefaultGameMode extends CommandGameMode
{
    @Override
    public String getCommandName() {
        return "defaultgamemode";
    }
    
    protected void setDefaultGameType(final GameType llllllllllllIlIIllllIlIlllIIlIll, final MinecraftServer llllllllllllIlIIllllIlIlllIIllIl) {
        llllllllllllIlIIllllIlIlllIIllIl.setGameType(llllllllllllIlIIllllIlIlllIIlIll);
        if (llllllllllllIlIIllllIlIlllIIllIl.getForceGamemode()) {
            for (final EntityPlayerMP llllllllllllIlIIllllIlIlllIIllII : llllllllllllIlIIllllIlIlllIIllIl.getPlayerList().getPlayerList()) {
                llllllllllllIlIIllllIlIlllIIllII.setGameType(llllllllllllIlIIllllIlIlllIIlIll);
            }
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIIllllIlIllllIIIll) {
        return "commands.defaultgamemode.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIIllllIlIlllIlIlll, final ICommandSender llllllllllllIlIIllllIlIlllIllIll, final String[] llllllllllllIlIIllllIlIlllIlIlIl) throws CommandException {
        if (llllllllllllIlIIllllIlIlllIlIlIl.length <= 0) {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
        final GameType llllllllllllIlIIllllIlIlllIllIIl = this.getGameModeFromCommand(llllllllllllIlIIllllIlIlllIllIll, llllllllllllIlIIllllIlIlllIlIlIl[0]);
        this.setDefaultGameType(llllllllllllIlIIllllIlIlllIllIIl, llllllllllllIlIIllllIlIlllIlIlll);
        CommandBase.notifyCommandListener(llllllllllllIlIIllllIlIlllIllIll, this, "commands.defaultgamemode.success", new TextComponentTranslation("gameMode." + llllllllllllIlIIllllIlIlllIllIIl.getName(), new Object[0]));
    }
}
