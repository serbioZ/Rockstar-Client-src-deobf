// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.WorldSettings;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.GameType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.server.MinecraftServer;

public class CommandGameMode extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIIIIIIIllIIlllIIIl) {
        return "commands.gamemode.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIIIIIIIllIIllIIIIl, final ICommandSender llllllllllllIlIIIIIIIllIIllIIlll, final String[] llllllllllllIlIIIIIIIllIIllIIllI) throws CommandException {
        if (llllllllllllIlIIIIIIIllIIllIIllI.length <= 0) {
            throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
        }
        final GameType llllllllllllIlIIIIIIIllIIllIIlIl = this.getGameModeFromCommand(llllllllllllIlIIIIIIIllIIllIIlll, llllllllllllIlIIIIIIIllIIllIIllI[0]);
        final EntityPlayer llllllllllllIlIIIIIIIllIIllIIlII = (llllllllllllIlIIIIIIIllIIllIIllI.length >= 2) ? CommandBase.getPlayer(llllllllllllIlIIIIIIIllIIllIIIIl, llllllllllllIlIIIIIIIllIIllIIlll, llllllllllllIlIIIIIIIllIIllIIllI[1]) : CommandBase.getCommandSenderAsPlayer(llllllllllllIlIIIIIIIllIIllIIlll);
        llllllllllllIlIIIIIIIllIIllIIlII.setGameType(llllllllllllIlIIIIIIIllIIllIIlIl);
        final ITextComponent llllllllllllIlIIIIIIIllIIllIIIll = new TextComponentTranslation("gameMode." + llllllllllllIlIIIIIIIllIIllIIlIl.getName(), new Object[0]);
        if (llllllllllllIlIIIIIIIllIIllIIlll.getEntityWorld().getGameRules().getBoolean("sendCommandFeedback")) {
            llllllllllllIlIIIIIIIllIIllIIlII.addChatMessage(new TextComponentTranslation("gameMode.changed", new Object[] { llllllllllllIlIIIIIIIllIIllIIIll }));
        }
        if (llllllllllllIlIIIIIIIllIIllIIlII == llllllllllllIlIIIIIIIllIIllIIlll) {
            CommandBase.notifyCommandListener(llllllllllllIlIIIIIIIllIIllIIlll, this, 1, "commands.gamemode.success.self", llllllllllllIlIIIIIIIllIIllIIIll);
        }
        else {
            CommandBase.notifyCommandListener(llllllllllllIlIIIIIIIllIIllIIlll, this, 1, "commands.gamemode.success.other", llllllllllllIlIIIIIIIllIIllIIlII.getName(), llllllllllllIlIIIIIIIllIIllIIIll);
        }
    }
    
    @Override
    public String getCommandName() {
        return "gamemode";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlIIIIIIIllIIlIlIIII, final ICommandSender llllllllllllIlIIIIIIIllIIlIIllll, final String[] llllllllllllIlIIIIIIIllIIlIIlIll, @Nullable final BlockPos llllllllllllIlIIIIIIIllIIlIIllIl) {
        if (llllllllllllIlIIIIIIIllIIlIIlIll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIIIIIIIllIIlIIlIll, "survival", "creative", "adventure", "spectator");
        }
        return (llllllllllllIlIIIIIIIllIIlIIlIll.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIIIIIIIllIIlIIlIll, llllllllllllIlIIIIIIIllIIlIlIIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIlIIIIIIIllIIlIIlIII, final int llllllllllllIlIIIIIIIllIIlIIIllI) {
        return llllllllllllIlIIIIIIIllIIlIIIllI == 1;
    }
    
    protected GameType getGameModeFromCommand(final ICommandSender llllllllllllIlIIIIIIIllIIlIllIII, final String llllllllllllIlIIIIIIIllIIlIlIlll) throws CommandException, NumberInvalidException {
        final GameType llllllllllllIlIIIIIIIllIIlIlIllI = GameType.parseGameTypeWithDefault(llllllllllllIlIIIIIIIllIIlIlIlll, GameType.NOT_SET);
        return (llllllllllllIlIIIIIIIllIIlIlIllI == GameType.NOT_SET) ? WorldSettings.getGameTypeById(CommandBase.parseInt(llllllllllllIlIIIIIIIllIIlIlIlll, 0, GameType.values().length - 2)) : llllllllllllIlIIIIIIIllIIlIlIllI;
    }
}
