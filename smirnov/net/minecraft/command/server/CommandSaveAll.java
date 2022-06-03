// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.CommandException;
import net.minecraft.world.WorldServer;
import net.minecraft.world.MinecraftException;
import net.minecraft.command.ICommand;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandSaveAll extends CommandBase
{
    @Override
    public void execute(final MinecraftServer llllllllllllIlIllIllIlllIIIIIIII, final ICommandSender llllllllllllIlIllIllIlllIIIIlIlI, final String[] llllllllllllIlIllIllIllIlllllllI) throws CommandException {
        llllllllllllIlIllIllIlllIIIIlIlI.addChatMessage(new TextComponentTranslation("commands.save.start", new Object[0]));
        if (llllllllllllIlIllIllIlllIIIIIIII.getPlayerList() != null) {
            llllllllllllIlIllIllIlllIIIIIIII.getPlayerList().saveAllPlayerData();
        }
        try {
            for (int llllllllllllIlIllIllIlllIIIIlIII = 0; llllllllllllIlIllIllIlllIIIIlIII < llllllllllllIlIllIllIlllIIIIIIII.worldServers.length; ++llllllllllllIlIllIllIlllIIIIlIII) {
                if (llllllllllllIlIllIllIlllIIIIIIII.worldServers[llllllllllllIlIllIllIlllIIIIlIII] != null) {
                    final WorldServer llllllllllllIlIllIllIlllIIIIIlll = llllllllllllIlIllIllIlllIIIIIIII.worldServers[llllllllllllIlIllIllIlllIIIIlIII];
                    final boolean llllllllllllIlIllIllIlllIIIIIllI = llllllllllllIlIllIllIlllIIIIIlll.disableLevelSaving;
                    llllllllllllIlIllIllIlllIIIIIlll.disableLevelSaving = false;
                    llllllllllllIlIllIllIlllIIIIIlll.saveAllChunks(true, null);
                    llllllllllllIlIllIllIlllIIIIIlll.disableLevelSaving = llllllllllllIlIllIllIlllIIIIIllI;
                }
            }
            if (llllllllllllIlIllIllIllIlllllllI.length > 0 && "flush".equals(llllllllllllIlIllIllIllIlllllllI[0])) {
                llllllllllllIlIllIllIlllIIIIlIlI.addChatMessage(new TextComponentTranslation("commands.save.flushStart", new Object[0]));
                for (int llllllllllllIlIllIllIlllIIIIIlIl = 0; llllllllllllIlIllIllIlllIIIIIlIl < llllllllllllIlIllIllIlllIIIIIIII.worldServers.length; ++llllllllllllIlIllIllIlllIIIIIlIl) {
                    if (llllllllllllIlIllIllIlllIIIIIIII.worldServers[llllllllllllIlIllIllIlllIIIIIlIl] != null) {
                        final WorldServer llllllllllllIlIllIllIlllIIIIIlII = llllllllllllIlIllIllIlllIIIIIIII.worldServers[llllllllllllIlIllIllIlllIIIIIlIl];
                        final boolean llllllllllllIlIllIllIlllIIIIIIll = llllllllllllIlIllIllIlllIIIIIlII.disableLevelSaving;
                        llllllllllllIlIllIllIlllIIIIIlII.disableLevelSaving = false;
                        llllllllllllIlIllIllIlllIIIIIlII.saveChunkData();
                        llllllllllllIlIllIllIlllIIIIIlII.disableLevelSaving = llllllllllllIlIllIllIlllIIIIIIll;
                    }
                }
                llllllllllllIlIllIllIlllIIIIlIlI.addChatMessage(new TextComponentTranslation("commands.save.flushEnd", new Object[0]));
            }
        }
        catch (MinecraftException llllllllllllIlIllIllIlllIIIIIIlI) {
            CommandBase.notifyCommandListener(llllllllllllIlIllIllIlllIIIIlIlI, this, "commands.save.failed", llllllllllllIlIllIllIlllIIIIIIlI.getMessage());
            return;
        }
        CommandBase.notifyCommandListener(llllllllllllIlIllIllIlllIIIIlIlI, this, "commands.save.success", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "save-all";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlIllIllIllIlllllIII, final ICommandSender llllllllllllIlIllIllIllIllllIlll, final String[] llllllllllllIlIllIllIllIllllIllI, @Nullable final BlockPos llllllllllllIlIllIllIllIllllIlIl) {
        return (llllllllllllIlIllIllIllIllllIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIllIllIllIllllIllI, "flush") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIllIllIlllIIIlIlII) {
        return "commands.save.usage";
    }
}
