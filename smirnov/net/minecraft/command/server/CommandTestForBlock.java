// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.command.ICommand;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.command.CommandException;
import net.minecraft.command.NumberInvalidException;
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

public class CommandTestForBlock extends CommandBase
{
    @Override
    public String getCommandName() {
        return "testforblock";
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllIlllIlIlllIIlllIllIlII) {
        return "commands.testforblock.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllIlllIlIlllIIlllIIIIlll, final ICommandSender llllllllllIlllIlIlllIIlllIIIIllI, final String[] llllllllllIlllIlIlllIIlllIIIIIll, @Nullable final BlockPos llllllllllIlllIlIlllIIlllIIIIlII) {
        if (llllllllllIlllIlIlllIIlllIIIIIll.length > 0 && llllllllllIlllIlIlllIIlllIIIIIll.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(llllllllllIlllIlIlllIIlllIIIIIll, 0, llllllllllIlllIlIlllIIlllIIIIlII);
        }
        return (llllllllllIlllIlIlllIIlllIIIIIll.length == 4) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllIlllIlIlllIIlllIIIIIll, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllIlllIlIlllIIlllIlIIllI, final ICommandSender llllllllllIlllIlIlllIIlllIlIIlIl, final String[] llllllllllIlllIlIlllIIlllIIlIlII) throws CommandException {
        if (llllllllllIlllIlIlllIIlllIIlIlII.length < 4) {
            throw new WrongUsageException("commands.testforblock.usage", new Object[0]);
        }
        llllllllllIlllIlIlllIIlllIlIIlIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllIlllIlIlllIIlllIlIIIll = CommandBase.parseBlockPos(llllllllllIlllIlIlllIIlllIlIIlIl, llllllllllIlllIlIlllIIlllIIlIlII, 0, false);
        final Block llllllllllIlllIlIlllIIlllIlIIIlI = CommandBase.getBlockByText(llllllllllIlllIlIlllIIlllIlIIlIl, llllllllllIlllIlIlllIIlllIIlIlII[3]);
        if (llllllllllIlllIlIlllIIlllIlIIIlI == null) {
            throw new NumberInvalidException("commands.setblock.notFound", new Object[] { llllllllllIlllIlIlllIIlllIIlIlII[3] });
        }
        final World llllllllllIlllIlIlllIIlllIlIIIIl = llllllllllIlllIlIlllIIlllIlIIlIl.getEntityWorld();
        if (!llllllllllIlllIlIlllIIlllIlIIIIl.isBlockLoaded(llllllllllIlllIlIlllIIlllIlIIIll)) {
            throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound llllllllllIlllIlIlllIIlllIlIIIII = new NBTTagCompound();
        boolean llllllllllIlllIlIlllIIlllIIlllll = false;
        if (llllllllllIlllIlIlllIIlllIIlIlII.length >= 6 && llllllllllIlllIlIlllIIlllIlIIIlI.hasTileEntity()) {
            final String llllllllllIlllIlIlllIIlllIIllllI = CommandBase.buildString(llllllllllIlllIlIlllIIlllIIlIlII, 5);
            try {
                llllllllllIlllIlIlllIIlllIlIIIII = JsonToNBT.getTagFromJson(llllllllllIlllIlIlllIIlllIIllllI);
                llllllllllIlllIlIlllIIlllIIlllll = true;
            }
            catch (NBTException llllllllllIlllIlIlllIIlllIIlllIl) {
                throw new CommandException("commands.setblock.tagError", new Object[] { llllllllllIlllIlIlllIIlllIIlllIl.getMessage() });
            }
        }
        final IBlockState llllllllllIlllIlIlllIIlllIIlllII = llllllllllIlllIlIlllIIlllIlIIIIl.getBlockState(llllllllllIlllIlIlllIIlllIlIIIll);
        final Block llllllllllIlllIlIlllIIlllIIllIll = llllllllllIlllIlIlllIIlllIIlllII.getBlock();
        if (llllllllllIlllIlIlllIIlllIIllIll != llllllllllIlllIlIlllIIlllIlIIIlI) {
            throw new CommandException("commands.testforblock.failed.tile", new Object[] { llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ(), llllllllllIlllIlIlllIIlllIIllIll.getLocalizedName(), llllllllllIlllIlIlllIIlllIlIIIlI.getLocalizedName() });
        }
        if (llllllllllIlllIlIlllIIlllIIlIlII.length >= 5 && !CommandBase.func_190791_b(llllllllllIlllIlIlllIIlllIlIIIlI, llllllllllIlllIlIlllIIlllIIlIlII[4]).apply((Object)llllllllllIlllIlIlllIIlllIIlllII)) {
            try {
                final int llllllllllIlllIlIlllIIlllIIllIlI = llllllllllIlllIlIlllIIlllIIlllII.getBlock().getMetaFromState(llllllllllIlllIlIlllIIlllIIlllII);
                throw new CommandException("commands.testforblock.failed.data", new Object[] { llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ(), llllllllllIlllIlIlllIIlllIIllIlI, Integer.parseInt(llllllllllIlllIlIlllIIlllIIlIlII[4]) });
            }
            catch (NumberFormatException llllllllllIlllIlIlllIIlllIIllIIl) {
                throw new CommandException("commands.testforblock.failed.data", new Object[] { llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ(), llllllllllIlllIlIlllIIlllIIlllII.toString(), llllllllllIlllIlIlllIIlllIIlIlII[4] });
            }
        }
        if (llllllllllIlllIlIlllIIlllIIlllll) {
            final TileEntity llllllllllIlllIlIlllIIlllIIllIII = llllllllllIlllIlIlllIIlllIlIIIIl.getTileEntity(llllllllllIlllIlIlllIIlllIlIIIll);
            if (llllllllllIlllIlIlllIIlllIIllIII == null) {
                throw new CommandException("commands.testforblock.failed.tileEntity", new Object[] { llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ() });
            }
            final NBTTagCompound llllllllllIlllIlIlllIIlllIIlIlll = llllllllllIlllIlIlllIIlllIIllIII.writeToNBT(new NBTTagCompound());
            if (!NBTUtil.areNBTEquals(llllllllllIlllIlIlllIIlllIlIIIII, llllllllllIlllIlIlllIIlllIIlIlll, true)) {
                throw new CommandException("commands.testforblock.failed.nbt", new Object[] { llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ() });
            }
        }
        llllllllllIlllIlIlllIIlllIlIIlIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
        CommandBase.notifyCommandListener(llllllllllIlllIlIlllIIlllIlIIlIl, this, "commands.testforblock.success", llllllllllIlllIlIlllIIlllIlIIIll.getX(), llllllllllIlllIlIlllIIlllIlIIIll.getY(), llllllllllIlllIlIlllIIlllIlIIIll.getZ());
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
