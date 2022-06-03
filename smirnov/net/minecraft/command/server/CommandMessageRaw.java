// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.command.CommandException;
import net.minecraft.entity.player.EntityPlayer;
import com.google.gson.JsonParseException;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandMessageRaw extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIllIlllIIIIIllIlllIlI, final ICommandSender lllllllllllIllIlllIIIIIllIlllIIl, final String[] lllllllllllIllIlllIIIIIllIlllIII, @Nullable final BlockPos lllllllllllIllIlllIIIIIllIllIlll) {
        return (lllllllllllIllIlllIIIIIllIlllIII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIlllIIIIIllIlllIII, lllllllllllIllIlllIIIIIllIlllIlI.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIlllIIIIIllIllIIlI, final int lllllllllllIllIlllIIIIIllIllIIIl) {
        return lllllllllllIllIlllIIIIIllIllIIIl == 0;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIllIlllIIIIIlllIIlIlI, final ICommandSender lllllllllllIllIlllIIIIIlllIIlIIl, final String[] lllllllllllIllIlllIIIIIlllIIlIII) throws CommandException {
        if (lllllllllllIllIlllIIIIIlllIIlIII.length < 2) {
            throw new WrongUsageException("commands.tellraw.usage", new Object[0]);
        }
        final EntityPlayer lllllllllllIllIlllIIIIIlllIIIlll = CommandBase.getPlayer(lllllllllllIllIlllIIIIIlllIIlIlI, lllllllllllIllIlllIIIIIlllIIlIIl, lllllllllllIllIlllIIIIIlllIIlIII[0]);
        final String lllllllllllIllIlllIIIIIlllIIIllI = CommandBase.buildString(lllllllllllIllIlllIIIIIlllIIlIII, 1);
        try {
            final ITextComponent lllllllllllIllIlllIIIIIlllIIIlIl = ITextComponent.Serializer.jsonToComponent(lllllllllllIllIlllIIIIIlllIIIllI);
            lllllllllllIllIlllIIIIIlllIIIlll.addChatMessage(TextComponentUtils.processComponent(lllllllllllIllIlllIIIIIlllIIlIIl, lllllllllllIllIlllIIIIIlllIIIlIl, lllllllllllIllIlllIIIIIlllIIIlll));
        }
        catch (JsonParseException lllllllllllIllIlllIIIIIlllIIIlII) {
            throw CommandBase.toSyntaxException(lllllllllllIllIlllIIIIIlllIIIlII);
        }
    }
    
    @Override
    public String getCommandName() {
        return "tellraw";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIllIlllIIIIIlllIlIIlI) {
        return "commands.tellraw.usage";
    }
}
