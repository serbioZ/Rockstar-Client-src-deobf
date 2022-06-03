// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandLocate extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIllIIlllIlIlllIII, final ICommandSender llllllllllllllIIllIIlllIlIllIlll, final String[] llllllllllllllIIllIIlllIlIllIllI, @Nullable final BlockPos llllllllllllllIIllIIlllIlIllIlIl) {
        return (llllllllllllllIIllIIlllIlIllIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIllIIlllIlIllIllI, "Stronghold", "Monument", "Village", "Mansion", "EndCity", "Fortress", "Temple", "Mineshaft") : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIllIIlllIllIIlIIl) {
        return "commands.locate.usage";
    }
    
    @Override
    public String getCommandName() {
        return "locate";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIllIIlllIllIIIIll, final ICommandSender llllllllllllllIIllIIlllIllIIIIlI, final String[] llllllllllllllIIllIIlllIllIIIIIl) throws CommandException {
        if (llllllllllllllIIllIIlllIllIIIIIl.length != 1) {
            throw new WrongUsageException("commands.locate.usage", new Object[0]);
        }
        final String llllllllllllllIIllIIlllIllIIIIII = llllllllllllllIIllIIlllIllIIIIIl[0];
        final BlockPos llllllllllllllIIllIIlllIlIllllll = llllllllllllllIIllIIlllIllIIIIlI.getEntityWorld().func_190528_a(llllllllllllllIIllIIlllIllIIIIII, llllllllllllllIIllIIlllIllIIIIlI.getPosition(), false);
        if (llllllllllllllIIllIIlllIlIllllll != null) {
            llllllllllllllIIllIIlllIllIIIIlI.addChatMessage(new TextComponentTranslation("commands.locate.success", new Object[] { llllllllllllllIIllIIlllIllIIIIII, llllllllllllllIIllIIlllIlIllllll.getX(), llllllllllllllIIllIIlllIlIllllll.getZ() }));
            return;
        }
        throw new CommandException("commands.locate.failure", new Object[] { llllllllllllllIIllIIlllIllIIIIII });
    }
}
