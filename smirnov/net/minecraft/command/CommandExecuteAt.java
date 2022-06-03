// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;

public class CommandExecuteAt extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIIIlIIIlllIlIlIIlllI, final int lllllllllllIIIIlIIIlllIlIlIIllIl) {
        return lllllllllllIIIIlIIIlllIlIlIIllIl == 0;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIIIlIIIlllIlIllIlIll, final ICommandSender lllllllllllIIIIlIIIlllIlIllIlIlI, final String[] lllllllllllIIIIlIIIlllIlIlllllIl) throws CommandException {
        if (lllllllllllIIIIlIIIlllIlIlllllIl.length < 5) {
            throw new WrongUsageException("commands.execute.usage", new Object[0]);
        }
        final Entity lllllllllllIIIIlIIIlllIlIlllllII = CommandBase.getEntity(lllllllllllIIIIlIIIlllIlIllIlIll, lllllllllllIIIIlIIIlllIlIllIlIlI, lllllllllllIIIIlIIIlllIlIlllllIl[0], (Class<? extends Entity>)Entity.class);
        final double lllllllllllIIIIlIIIlllIlIllllIll = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIlllllII.posX, lllllllllllIIIIlIIIlllIlIlllllIl[1], false);
        final double lllllllllllIIIIlIIIlllIlIllllIlI = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIlllllII.posY, lllllllllllIIIIlIIIlllIlIlllllIl[2], false);
        final double lllllllllllIIIIlIIIlllIlIllllIIl = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIlllllII.posZ, lllllllllllIIIIlIIIlllIlIlllllIl[3], false);
        new BlockPos(lllllllllllIIIIlIIIlllIlIllllIll, lllllllllllIIIIlIIIlllIlIllllIlI, lllllllllllIIIIlIIIlllIlIllllIIl);
        int lllllllllllIIIIlIIIlllIlIllllIII = 4;
        if ("detect".equals(lllllllllllIIIIlIIIlllIlIlllllIl[4]) && lllllllllllIIIIlIIIlllIlIlllllIl.length > 10) {
            final World lllllllllllIIIIlIIIlllIlIlllIlll = lllllllllllIIIIlIIIlllIlIlllllII.getEntityWorld();
            final double lllllllllllIIIIlIIIlllIlIlllIllI = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIllllIll, lllllllllllIIIIlIIIlllIlIlllllIl[5], false);
            final double lllllllllllIIIIlIIIlllIlIlllIlIl = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIllllIlI, lllllllllllIIIIlIIIlllIlIlllllIl[6], false);
            final double lllllllllllIIIIlIIIlllIlIlllIlII = CommandBase.parseDouble(lllllllllllIIIIlIIIlllIlIllllIIl, lllllllllllIIIIlIIIlllIlIlllllIl[7], false);
            final Block lllllllllllIIIIlIIIlllIlIlllIIll = CommandBase.getBlockByText(lllllllllllIIIIlIIIlllIlIllIlIlI, lllllllllllIIIIlIIIlllIlIlllllIl[8]);
            final BlockPos lllllllllllIIIIlIIIlllIlIlllIIlI = new BlockPos(lllllllllllIIIIlIIIlllIlIlllIllI, lllllllllllIIIIlIIIlllIlIlllIlIl, lllllllllllIIIIlIIIlllIlIlllIlII);
            if (!lllllllllllIIIIlIIIlllIlIlllIlll.isBlockLoaded(lllllllllllIIIIlIIIlllIlIlllIIlI)) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", lllllllllllIIIIlIIIlllIlIlllllII.getName() });
            }
            final IBlockState lllllllllllIIIIlIIIlllIlIlllIIIl = lllllllllllIIIIlIIIlllIlIlllIlll.getBlockState(lllllllllllIIIIlIIIlllIlIlllIIlI);
            if (lllllllllllIIIIlIIIlllIlIlllIIIl.getBlock() != lllllllllllIIIIlIIIlllIlIlllIIll) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", lllllllllllIIIIlIIIlllIlIlllllII.getName() });
            }
            if (!CommandBase.func_190791_b(lllllllllllIIIIlIIIlllIlIlllIIll, lllllllllllIIIIlIIIlllIlIlllllIl[9]).apply((Object)lllllllllllIIIIlIIIlllIlIlllIIIl)) {
                throw new CommandException("commands.execute.failed", new Object[] { "detect", lllllllllllIIIIlIIIlllIlIlllllII.getName() });
            }
            lllllllllllIIIIlIIIlllIlIllllIII = 10;
        }
        final String lllllllllllIIIIlIIIlllIlIlllIIII = CommandBase.buildString(lllllllllllIIIIlIIIlllIlIlllllIl, lllllllllllIIIIlIIIlllIlIllllIII);
        final ICommandSender lllllllllllIIIIlIIIlllIlIllIllll = CommandSenderWrapper.func_193998_a(lllllllllllIIIIlIIIlllIlIllIlIlI).func_193997_a(lllllllllllIIIIlIIIlllIlIlllllII, new Vec3d(lllllllllllIIIIlIIIlllIlIllllIll, lllllllllllIIIIlIIIlllIlIllllIlI, lllllllllllIIIIlIIIlllIlIllllIIl)).func_194001_a(lllllllllllIIIIlIIIlllIlIllIlIll.worldServers[0].getGameRules().getBoolean("commandBlockOutput"));
        final ICommandManager lllllllllllIIIIlIIIlllIlIllIlllI = lllllllllllIIIIlIIIlllIlIllIlIll.getCommandManager();
        try {
            final int lllllllllllIIIIlIIIlllIlIllIllIl = lllllllllllIIIIlIIIlllIlIllIlllI.executeCommand(lllllllllllIIIIlIIIlllIlIllIllll, lllllllllllIIIIlIIIlllIlIlllIIII);
            if (lllllllllllIIIIlIIIlllIlIllIllIl < 1) {
                throw new CommandException("commands.execute.allInvocationsFailed", new Object[] { lllllllllllIIIIlIIIlllIlIlllIIII });
            }
        }
        catch (Throwable lllllllllllIIIIlIIIlllIlIllIllII) {
            throw new CommandException("commands.execute.failed", new Object[] { lllllllllllIIIIlIIIlllIlIlllIIII, lllllllllllIIIIlIIIlllIlIlllllII.getName() });
        }
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIIIlIIIlllIllIIlIIIl) {
        return "commands.execute.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIIIlIIIlllIlIlIlIIll, final ICommandSender lllllllllllIIIIlIIIlllIlIlIlIllI, final String[] lllllllllllIIIIlIIIlllIlIlIlIlIl, @Nullable final BlockPos lllllllllllIIIIlIIIlllIlIlIlIlII) {
        if (lllllllllllIIIIlIIIlllIlIlIlIlIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIIlIIIlllIlIlIlIlIl, lllllllllllIIIIlIIIlllIlIlIlIIll.getAllUsernames());
        }
        if (lllllllllllIIIIlIIIlllIlIlIlIlIl.length > 1 && lllllllllllIIIIlIIIlllIlIlIlIlIl.length <= 4) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIIIIlIIIlllIlIlIlIlIl, 1, lllllllllllIIIIlIIIlllIlIlIlIlII);
        }
        if (lllllllllllIIIIlIIIlllIlIlIlIlIl.length > 5 && lllllllllllIIIIlIIIlllIlIlIlIlIl.length <= 8 && "detect".equals(lllllllllllIIIIlIIIlllIlIlIlIlIl[4])) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIIIIlIIIlllIlIlIlIlIl, 5, lllllllllllIIIIlIIIlllIlIlIlIlII);
        }
        return (lllllllllllIIIIlIIIlllIlIlIlIlIl.length == 9 && "detect".equals(lllllllllllIIIIlIIIlllIlIlIlIlIl[4])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIIIlIIIlllIlIlIlIlIl, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "execute";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
