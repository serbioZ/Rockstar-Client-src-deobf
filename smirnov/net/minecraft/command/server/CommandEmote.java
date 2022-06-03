// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.CommandException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandEmote extends CommandBase
{
    @Override
    public void execute(final MinecraftServer llIllllllllllIl, final ICommandSender lllIIIIIIIIIIII, final String[] llIllllllllllll) throws CommandException {
        if (llIllllllllllll.length <= 0) {
            throw new WrongUsageException("commands.me.usage", new Object[0]);
        }
        final ITextComponent llIlllllllllllI = CommandBase.getChatComponentFromNthArg(lllIIIIIIIIIIII, llIllllllllllll, 0, !(lllIIIIIIIIIIII instanceof EntityPlayer));
        llIllllllllllIl.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.emote", new Object[] { lllIIIIIIIIIIII.getDisplayName(), llIlllllllllllI }));
    }
    
    @Override
    public String getCommandName() {
        return "me";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llIllllllllIIlI, final ICommandSender llIllllllllIlIl, final String[] llIllllllllIlII, @Nullable final BlockPos llIllllllllIIll) {
        return CommandBase.getListOfStringsMatchingLastWord(llIllllllllIlII, llIllllllllIIlI.getAllUsernames());
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllIIIIIIIIIlll) {
        return "commands.me.usage";
    }
}
