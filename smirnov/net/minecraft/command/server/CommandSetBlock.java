// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.command.ICommand;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.block.Block;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandSetBlock extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIllIlIIIlIllIIlIlII) {
        return "commands.setblock.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIllIlIIIlIlIllIlIll, final ICommandSender lllllllllllllIllIlIIIlIlIllIlIlI, final String[] lllllllllllllIllIlIIIlIlIllIIlll, @Nullable final BlockPos lllllllllllllIllIlIIIlIlIllIIllI) {
        if (lllllllllllllIllIlIIIlIlIllIIlll.length > 0 && lllllllllllllIllIlIIIlIlIllIIlll.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllllIllIlIIIlIlIllIIlll, 0, lllllllllllllIllIlIIIlIlIllIIllI);
        }
        if (lllllllllllllIllIlIIIlIlIllIIlll.length == 4) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIlIIIlIlIllIIlll, Block.REGISTRY.getKeys());
        }
        return (lllllllllllllIllIlIIIlIlIllIIlll.length == 6) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIllIlIIIlIlIllIIlll, "replace", "destroy", "keep") : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIllIlIIIlIllIIIIlll, final ICommandSender lllllllllllllIllIlIIIlIlIllllIII, final String[] lllllllllllllIllIlIIIlIlIlllIlll) throws CommandException {
        if (lllllllllllllIllIlIIIlIlIlllIlll.length < 4) {
            throw new WrongUsageException("commands.setblock.usage", new Object[0]);
        }
        lllllllllllllIllIlIIIlIlIllllIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllllIllIlIIIlIllIIIIlII = CommandBase.parseBlockPos(lllllllllllllIllIlIIIlIlIllllIII, lllllllllllllIllIlIIIlIlIlllIlll, 0, false);
        final Block lllllllllllllIllIlIIIlIllIIIIIll = CommandBase.getBlockByText(lllllllllllllIllIlIIIlIlIllllIII, lllllllllllllIllIlIIIlIlIlllIlll[3]);
        IBlockState lllllllllllllIllIlIIIlIllIIIIIIl = null;
        if (lllllllllllllIllIlIIIlIlIlllIlll.length >= 5) {
            final IBlockState lllllllllllllIllIlIIIlIllIIIIIlI = CommandBase.func_190794_a(lllllllllllllIllIlIIIlIllIIIIIll, lllllllllllllIllIlIIIlIlIlllIlll[4]);
        }
        else {
            lllllllllllllIllIlIIIlIllIIIIIIl = lllllllllllllIllIlIIIlIllIIIIIll.getDefaultState();
        }
        final World lllllllllllllIllIlIIIlIllIIIIIII = lllllllllllllIllIlIIIlIlIllllIII.getEntityWorld();
        if (!lllllllllllllIllIlIIIlIllIIIIIII.isBlockLoaded(lllllllllllllIllIlIIIlIllIIIIlII)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound lllllllllllllIllIlIIIlIlIlllllll = new NBTTagCompound();
        boolean lllllllllllllIllIlIIIlIlIllllllI = false;
        if (lllllllllllllIllIlIIIlIlIlllIlll.length >= 7 && lllllllllllllIllIlIIIlIllIIIIIll.hasTileEntity()) {
            final String lllllllllllllIllIlIIIlIlIlllllIl = CommandBase.buildString(lllllllllllllIllIlIIIlIlIlllIlll, 6);
            try {
                lllllllllllllIllIlIIIlIlIlllllll = JsonToNBT.getTagFromJson(lllllllllllllIllIlIIIlIlIlllllIl);
                lllllllllllllIllIlIIIlIlIllllllI = true;
            }
            catch (NBTException lllllllllllllIllIlIIIlIlIlllllII) {
                throw new CommandException("commands.setblock.tagError", new Object[] { lllllllllllllIllIlIIIlIlIlllllII.getMessage() });
            }
        }
        if (lllllllllllllIllIlIIIlIlIlllIlll.length >= 6) {
            if ("destroy".equals(lllllllllllllIllIlIIIlIlIlllIlll[5])) {
                lllllllllllllIllIlIIIlIllIIIIIII.destroyBlock(lllllllllllllIllIlIIIlIllIIIIlII, true);
                if (lllllllllllllIllIlIIIlIllIIIIIll == Blocks.AIR) {
                    CommandBase.notifyCommandListener(lllllllllllllIllIlIIIlIlIllllIII, this, "commands.setblock.success", new Object[0]);
                    return;
                }
            }
            else if ("keep".equals(lllllllllllllIllIlIIIlIlIlllIlll[5]) && !lllllllllllllIllIlIIIlIllIIIIIII.isAirBlock(lllllllllllllIllIlIIIlIllIIIIlII)) {
                throw new CommandException("commands.setblock.noChange", new Object[0]);
            }
        }
        final TileEntity lllllllllllllIllIlIIIlIlIllllIll = lllllllllllllIllIlIIIlIllIIIIIII.getTileEntity(lllllllllllllIllIlIIIlIllIIIIlII);
        if (lllllllllllllIllIlIIIlIlIllllIll != null && lllllllllllllIllIlIIIlIlIllllIll instanceof IInventory) {
            ((IInventory)lllllllllllllIllIlIIIlIlIllllIll).clear();
        }
        if (!lllllllllllllIllIlIIIlIllIIIIIII.setBlockState(lllllllllllllIllIlIIIlIllIIIIlII, lllllllllllllIllIlIIIlIllIIIIIIl, 2)) {
            throw new CommandException("commands.setblock.noChange", new Object[0]);
        }
        if (lllllllllllllIllIlIIIlIlIllllllI) {
            final TileEntity lllllllllllllIllIlIIIlIlIllllIlI = lllllllllllllIllIlIIIlIllIIIIIII.getTileEntity(lllllllllllllIllIlIIIlIllIIIIlII);
            if (lllllllllllllIllIlIIIlIlIllllIlI != null) {
                lllllllllllllIllIlIIIlIlIlllllll.setInteger("x", lllllllllllllIllIlIIIlIllIIIIlII.getX());
                lllllllllllllIllIlIIIlIlIlllllll.setInteger("y", lllllllllllllIllIlIIIlIllIIIIlII.getY());
                lllllllllllllIllIlIIIlIlIlllllll.setInteger("z", lllllllllllllIllIlIIIlIllIIIIlII.getZ());
                lllllllllllllIllIlIIIlIlIllllIlI.readFromNBT(lllllllllllllIllIlIIIlIlIlllllll);
            }
        }
        lllllllllllllIllIlIIIlIllIIIIIII.notifyNeighborsRespectDebug(lllllllllllllIllIlIIIlIllIIIIlII, lllllllllllllIllIlIIIlIllIIIIIIl.getBlock(), false);
        lllllllllllllIllIlIIIlIlIllllIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyCommandListener(lllllllllllllIllIlIIIlIlIllllIII, this, "commands.setblock.success", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "setblock";
    }
}
