// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;

public class CommandFunction extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIllIIlIIlIlIllIlII) {
        return "commands.function.usage";
    }
    
    @Override
    public String getCommandName() {
        return "function";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIllIIlIIlIlIIlllIl, final ICommandSender llllllllllllIlIllIIlIIlIlIIlllII, final String[] llllllllllllIlIllIIlIIlIlIIllIll) throws CommandException {
        if (llllllllllllIlIllIIlIIlIlIIllIll.length != 1 && llllllllllllIlIllIIlIIlIlIIllIll.length != 3) {
            throw new WrongUsageException("commands.function.usage", new Object[0]);
        }
        final ResourceLocation llllllllllllIlIllIIlIIlIlIlIIlIl = new ResourceLocation(llllllllllllIlIllIIlIIlIlIIllIll[0]);
        final FunctionObject llllllllllllIlIllIIlIIlIlIlIIlII = llllllllllllIlIllIIlIIlIlIIlllIl.func_193030_aL().func_193058_a(llllllllllllIlIllIIlIIlIlIlIIlIl);
        if (llllllllllllIlIllIIlIIlIlIlIIlII == null) {
            throw new CommandException("commands.function.unknown", new Object[] { llllllllllllIlIllIIlIIlIlIlIIlIl });
        }
        if (llllllllllllIlIllIIlIIlIlIIllIll.length == 3) {
            final String llllllllllllIlIllIIlIIlIlIlIIIll = llllllllllllIlIllIIlIIlIlIIllIll[1];
            boolean llllllllllllIlIllIIlIIlIlIlIIIIl = false;
            if ("if".equals(llllllllllllIlIllIIlIIlIlIlIIIll)) {
                final boolean llllllllllllIlIllIIlIIlIlIlIIIlI = true;
            }
            else {
                if (!"unless".equals(llllllllllllIlIllIIlIIlIlIlIIIll)) {
                    throw new WrongUsageException("commands.function.usage", new Object[0]);
                }
                llllllllllllIlIllIIlIIlIlIlIIIIl = false;
            }
            boolean llllllllllllIlIllIIlIIlIlIlIIIII = false;
            try {
                llllllllllllIlIllIIlIIlIlIlIIIII = !CommandBase.getEntityList(llllllllllllIlIllIIlIIlIlIIlllIl, llllllllllllIlIllIIlIIlIlIIlllII, llllllllllllIlIllIIlIIlIlIIllIll[2]).isEmpty();
            }
            catch (EntityNotFoundException ex) {}
            if (llllllllllllIlIllIIlIIlIlIlIIIIl != llllllllllllIlIllIIlIIlIlIlIIIII) {
                throw new CommandException("commands.function.skipped", new Object[] { llllllllllllIlIllIIlIIlIlIlIIlIl });
            }
        }
        final int llllllllllllIlIllIIlIIlIlIIlllll = llllllllllllIlIllIIlIIlIlIIlllIl.func_193030_aL().func_194019_a(llllllllllllIlIllIIlIIlIlIlIIlII, CommandSenderWrapper.func_193998_a(llllllllllllIlIllIIlIIlIlIIlllII).func_194000_i().func_193999_a(2).func_194001_a(false));
        CommandBase.notifyCommandListener(llllllllllllIlIllIIlIIlIlIIlllII, this, "commands.function.success", llllllllllllIlIllIIlIIlIlIlIIlIl, llllllllllllIlIllIIlIIlIlIIlllll);
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlIllIIlIIlIlIIIllIl, final ICommandSender llllllllllllIlIllIIlIIlIlIIlIIII, final String[] llllllllllllIlIllIIlIIlIlIIIllll, @Nullable final BlockPos llllllllllllIlIllIIlIIlIlIIIlllI) {
        if (llllllllllllIlIllIIlIIlIlIIIllll.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIllIIlIIlIlIIIllll, llllllllllllIlIllIIlIIlIlIIIllIl.func_193030_aL().func_193066_d().keySet());
        }
        if (llllllllllllIlIllIIlIIlIlIIIllll.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIllIIlIIlIlIIIllll, "if", "unless");
        }
        return (llllllllllllIlIllIIlIIlIlIIIllll.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIllIIlIIlIlIIIllll, llllllllllllIlIllIIlIIlIlIIIllIl.getAllUsernames()) : Collections.emptyList();
    }
}
