// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.server.MinecraftServer;

public class CommandDifficulty extends CommandBase
{
    @Override
    public void execute(final MinecraftServer llllllllllllIllIlIIIllIIllIIllIl, final ICommandSender llllllllllllIllIlIIIllIIllIIIlll, final String[] llllllllllllIllIlIIIllIIllIIIllI) throws CommandException {
        if (llllllllllllIllIlIIIllIIllIIIllI.length <= 0) {
            throw new WrongUsageException("commands.difficulty.usage", new Object[0]);
        }
        final EnumDifficulty llllllllllllIllIlIIIllIIllIIlIlI = this.getDifficultyFromCommand(llllllllllllIllIlIIIllIIllIIIllI[0]);
        llllllllllllIllIlIIIllIIllIIllIl.setDifficultyForAllWorlds(llllllllllllIllIlIIIllIIllIIlIlI);
        CommandBase.notifyCommandListener(llllllllllllIllIlIIIllIIllIIIlll, this, "commands.difficulty.success", new TextComponentTranslation(llllllllllllIllIlIIIllIIllIIlIlI.getDifficultyResourceKey(), new Object[0]));
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "difficulty";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIllIlIIIllIIllIlIlII) {
        return "commands.difficulty.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIllIlIIIllIIlIlllllI, final ICommandSender llllllllllllIllIlIIIllIIlIllllIl, final String[] llllllllllllIllIlIIIllIIlIlllIlI, @Nullable final BlockPos llllllllllllIllIlIIIllIIlIlllIll) {
        return (llllllllllllIllIlIIIllIIlIlllIlI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIllIlIIIllIIlIlllIlI, "peaceful", "easy", "normal", "hard") : Collections.emptyList();
    }
    
    protected EnumDifficulty getDifficultyFromCommand(final String llllllllllllIllIlIIIllIIllIIIIlI) throws CommandException, NumberInvalidException {
        if ("peaceful".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI) || "p".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI)) {
            return EnumDifficulty.PEACEFUL;
        }
        if ("easy".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI) || "e".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI)) {
            return EnumDifficulty.EASY;
        }
        if (!"normal".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI) && !"n".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI)) {
            return (!"hard".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI) && !"h".equalsIgnoreCase(llllllllllllIllIlIIIllIIllIIIIlI)) ? EnumDifficulty.getDifficultyEnum(CommandBase.parseInt(llllllllllllIllIlIIIllIIllIIIIlI, 0, 3)) : EnumDifficulty.HARD;
        }
        return EnumDifficulty.NORMAL;
    }
}
