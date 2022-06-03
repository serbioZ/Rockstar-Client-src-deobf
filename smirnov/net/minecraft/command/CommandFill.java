// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.IInventory;
import net.minecraft.init.Blocks;
import com.google.common.collect.Lists;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.block.Block;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandFill extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIllIIIlIlIIlllIlllIl, final ICommandSender lllllllllllIIllIIIlIlIIlllIlllII, final String[] lllllllllllIIllIIIlIlIIlllIllIll, @Nullable final BlockPos lllllllllllIIllIIIlIlIIlllIllIII) {
        if (lllllllllllIIllIIIlIlIIlllIllIll.length > 0 && lllllllllllIIllIIIlIlIIlllIllIll.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIIllIIIlIlIIlllIllIll, 0, lllllllllllIIllIIIlIlIIlllIllIII);
        }
        if (lllllllllllIIllIIIlIlIIlllIllIll.length > 3 && lllllllllllIIllIIIlIlIIlllIllIll.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIIllIIIlIlIIlllIllIll, 3, lllllllllllIIllIIIlIlIIlllIllIII);
        }
        if (lllllllllllIIllIIIlIlIIlllIllIll.length == 7) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIIIlIlIIlllIllIll, Block.REGISTRY.getKeys());
        }
        if (lllllllllllIIllIIIlIlIIlllIllIll.length == 9) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIIIlIlIIlllIllIll, "replace", "destroy", "keep", "hollow", "outline");
        }
        return (lllllllllllIIllIIIlIlIIlllIllIll.length == 10 && "replace".equals(lllllllllllIIllIIIlIlIIlllIllIll[8])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIIllIIIlIlIIlllIllIll, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIIllIIIlIlIlIIIlIIllI) {
        return "commands.fill.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "fill";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIIllIIIlIlIlIIIIlIIII, final ICommandSender lllllllllllIIllIIIlIlIIlllllIIll, final String[] lllllllllllIIllIIIlIlIIlllllIIlI) throws CommandException {
        if (lllllllllllIIllIIIlIlIIlllllIIlI.length < 7) {
            throw new WrongUsageException("commands.fill.usage", new Object[0]);
        }
        lllllllllllIIllIIIlIlIIlllllIIll.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllIIllIIIlIlIlIIIIIllIl = CommandBase.parseBlockPos(lllllllllllIIllIIIlIlIIlllllIIll, lllllllllllIIllIIIlIlIIlllllIIlI, 0, false);
        final BlockPos lllllllllllIIllIIIlIlIlIIIIIllII = CommandBase.parseBlockPos(lllllllllllIIllIIIlIlIIlllllIIll, lllllllllllIIllIIIlIlIIlllllIIlI, 3, false);
        final Block lllllllllllIIllIIIlIlIlIIIIIlIll = CommandBase.getBlockByText(lllllllllllIIllIIIlIlIIlllllIIll, lllllllllllIIllIIIlIlIIlllllIIlI[6]);
        IBlockState lllllllllllIIllIIIlIlIlIIIIIlIIl = null;
        if (lllllllllllIIllIIIlIlIIlllllIIlI.length >= 8) {
            final IBlockState lllllllllllIIllIIIlIlIlIIIIIlIlI = CommandBase.func_190794_a(lllllllllllIIllIIIlIlIlIIIIIlIll, lllllllllllIIllIIIlIlIIlllllIIlI[7]);
        }
        else {
            lllllllllllIIllIIIlIlIlIIIIIlIIl = lllllllllllIIllIIIlIlIlIIIIIlIll.getDefaultState();
        }
        final BlockPos lllllllllllIIllIIIlIlIlIIIIIlIII = new BlockPos(Math.min(lllllllllllIIllIIIlIlIlIIIIIllIl.getX(), lllllllllllIIllIIIlIlIlIIIIIllII.getX()), Math.min(lllllllllllIIllIIIlIlIlIIIIIllIl.getY(), lllllllllllIIllIIIlIlIlIIIIIllII.getY()), Math.min(lllllllllllIIllIIIlIlIlIIIIIllIl.getZ(), lllllllllllIIllIIIlIlIlIIIIIllII.getZ()));
        final BlockPos lllllllllllIIllIIIlIlIlIIIIIIlll = new BlockPos(Math.max(lllllllllllIIllIIIlIlIlIIIIIllIl.getX(), lllllllllllIIllIIIlIlIlIIIIIllII.getX()), Math.max(lllllllllllIIllIIIlIlIlIIIIIllIl.getY(), lllllllllllIIllIIIlIlIlIIIIIllII.getY()), Math.max(lllllllllllIIllIIIlIlIlIIIIIllIl.getZ(), lllllllllllIIllIIIlIlIlIIIIIllII.getZ()));
        int lllllllllllIIllIIIlIlIlIIIIIIllI = (lllllllllllIIllIIIlIlIlIIIIIIlll.getX() - lllllllllllIIllIIIlIlIlIIIIIlIII.getX() + 1) * (lllllllllllIIllIIIlIlIlIIIIIIlll.getY() - lllllllllllIIllIIIlIlIlIIIIIlIII.getY() + 1) * (lllllllllllIIllIIIlIlIlIIIIIIlll.getZ() - lllllllllllIIllIIIlIlIlIIIIIlIII.getZ() + 1);
        if (lllllllllllIIllIIIlIlIlIIIIIIllI > 32768) {
            throw new CommandException("commands.fill.tooManyBlocks", new Object[] { lllllllllllIIllIIIlIlIlIIIIIIllI, 32768 });
        }
        if (lllllllllllIIllIIIlIlIlIIIIIlIII.getY() < 0 || lllllllllllIIllIIIlIlIlIIIIIIlll.getY() >= 256) {
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
        }
        final World lllllllllllIIllIIIlIlIlIIIIIIlIl = lllllllllllIIllIIIlIlIIlllllIIll.getEntityWorld();
        for (int lllllllllllIIllIIIlIlIlIIIIIIlII = lllllllllllIIllIIIlIlIlIIIIIlIII.getZ(); lllllllllllIIllIIIlIlIlIIIIIIlII <= lllllllllllIIllIIIlIlIlIIIIIIlll.getZ(); lllllllllllIIllIIIlIlIlIIIIIIlII += 16) {
            for (int lllllllllllIIllIIIlIlIlIIIIIIIll = lllllllllllIIllIIIlIlIlIIIIIlIII.getX(); lllllllllllIIllIIIlIlIlIIIIIIIll <= lllllllllllIIllIIIlIlIlIIIIIIlll.getX(); lllllllllllIIllIIIlIlIlIIIIIIIll += 16) {
                if (!lllllllllllIIllIIIlIlIlIIIIIIlIl.isBlockLoaded(new BlockPos(lllllllllllIIllIIIlIlIlIIIIIIIll, lllllllllllIIllIIIlIlIlIIIIIIlll.getY() - lllllllllllIIllIIIlIlIlIIIIIlIII.getY(), lllllllllllIIllIIIlIlIlIIIIIIlII))) {
                    throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                }
            }
        }
        NBTTagCompound lllllllllllIIllIIIlIlIlIIIIIIIlI = new NBTTagCompound();
        boolean lllllllllllIIllIIIlIlIlIIIIIIIIl = false;
        if (lllllllllllIIllIIIlIlIIlllllIIlI.length >= 10 && lllllllllllIIllIIIlIlIlIIIIIlIll.hasTileEntity()) {
            final String lllllllllllIIllIIIlIlIlIIIIIIIII = CommandBase.buildString(lllllllllllIIllIIIlIlIIlllllIIlI, 9);
            try {
                lllllllllllIIllIIIlIlIlIIIIIIIlI = JsonToNBT.getTagFromJson(lllllllllllIIllIIIlIlIlIIIIIIIII);
                lllllllllllIIllIIIlIlIlIIIIIIIIl = true;
            }
            catch (NBTException lllllllllllIIllIIIlIlIIlllllllll) {
                throw new CommandException("commands.fill.tagError", new Object[] { lllllllllllIIllIIIlIlIIlllllllll.getMessage() });
            }
        }
        final List<BlockPos> lllllllllllIIllIIIlIlIIllllllllI = (List<BlockPos>)Lists.newArrayList();
        lllllllllllIIllIIIlIlIlIIIIIIllI = 0;
        for (int lllllllllllIIllIIIlIlIIlllllllIl = lllllllllllIIllIIIlIlIlIIIIIlIII.getZ(); lllllllllllIIllIIIlIlIIlllllllIl <= lllllllllllIIllIIIlIlIlIIIIIIlll.getZ(); ++lllllllllllIIllIIIlIlIIlllllllIl) {
            for (int lllllllllllIIllIIIlIlIIlllllllII = lllllllllllIIllIIIlIlIlIIIIIlIII.getY(); lllllllllllIIllIIIlIlIIlllllllII <= lllllllllllIIllIIIlIlIlIIIIIIlll.getY(); ++lllllllllllIIllIIIlIlIIlllllllII) {
                for (int lllllllllllIIllIIIlIlIIllllllIll = lllllllllllIIllIIIlIlIlIIIIIlIII.getX(); lllllllllllIIllIIIlIlIIllllllIll <= lllllllllllIIllIIIlIlIlIIIIIIlll.getX(); ++lllllllllllIIllIIIlIlIIllllllIll) {
                    final BlockPos lllllllllllIIllIIIlIlIIllllllIlI = new BlockPos(lllllllllllIIllIIIlIlIIllllllIll, lllllllllllIIllIIIlIlIIlllllllII, lllllllllllIIllIIIlIlIIlllllllIl);
                    if (lllllllllllIIllIIIlIlIIlllllIIlI.length >= 9) {
                        if (!"outline".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8]) && !"hollow".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8])) {
                            if ("destroy".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8])) {
                                lllllllllllIIllIIIlIlIlIIIIIIlIl.destroyBlock(lllllllllllIIllIIIlIlIIllllllIlI, true);
                            }
                            else if ("keep".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8])) {
                                if (!lllllllllllIIllIIIlIlIlIIIIIIlIl.isAirBlock(lllllllllllIIllIIIlIlIIllllllIlI)) {
                                    continue;
                                }
                            }
                            else if ("replace".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8]) && !lllllllllllIIllIIIlIlIlIIIIIlIll.hasTileEntity() && lllllllllllIIllIIIlIlIIlllllIIlI.length > 9) {
                                final Block lllllllllllIIllIIIlIlIIllllllIIl = CommandBase.getBlockByText(lllllllllllIIllIIIlIlIIlllllIIll, lllllllllllIIllIIIlIlIIlllllIIlI[9]);
                                if (lllllllllllIIllIIIlIlIlIIIIIIlIl.getBlockState(lllllllllllIIllIIIlIlIIllllllIlI).getBlock() != lllllllllllIIllIIIlIlIIllllllIIl) {
                                    continue;
                                }
                                if (lllllllllllIIllIIIlIlIIlllllIIlI.length > 10 && !"-1".equals(lllllllllllIIllIIIlIlIIlllllIIlI[10]) && !"*".equals(lllllllllllIIllIIIlIlIIlllllIIlI[10]) && !CommandBase.func_190791_b(lllllllllllIIllIIIlIlIIllllllIIl, lllllllllllIIllIIIlIlIIlllllIIlI[10]).apply((Object)lllllllllllIIllIIIlIlIlIIIIIIlIl.getBlockState(lllllllllllIIllIIIlIlIIllllllIlI))) {
                                    continue;
                                }
                            }
                        }
                        else if (lllllllllllIIllIIIlIlIIllllllIll != lllllllllllIIllIIIlIlIlIIIIIlIII.getX() && lllllllllllIIllIIIlIlIIllllllIll != lllllllllllIIllIIIlIlIlIIIIIIlll.getX() && lllllllllllIIllIIIlIlIIlllllllII != lllllllllllIIllIIIlIlIlIIIIIlIII.getY() && lllllllllllIIllIIIlIlIIlllllllII != lllllllllllIIllIIIlIlIlIIIIIIlll.getY() && lllllllllllIIllIIIlIlIIlllllllIl != lllllllllllIIllIIIlIlIlIIIIIlIII.getZ() && lllllllllllIIllIIIlIlIIlllllllIl != lllllllllllIIllIIIlIlIlIIIIIIlll.getZ()) {
                            if ("hollow".equals(lllllllllllIIllIIIlIlIIlllllIIlI[8])) {
                                lllllllllllIIllIIIlIlIlIIIIIIlIl.setBlockState(lllllllllllIIllIIIlIlIIllllllIlI, Blocks.AIR.getDefaultState(), 2);
                                lllllllllllIIllIIIlIlIIllllllllI.add(lllllllllllIIllIIIlIlIIllllllIlI);
                            }
                            continue;
                        }
                    }
                    final TileEntity lllllllllllIIllIIIlIlIIllllllIII = lllllllllllIIllIIIlIlIlIIIIIIlIl.getTileEntity(lllllllllllIIllIIIlIlIIllllllIlI);
                    if (lllllllllllIIllIIIlIlIIllllllIII != null && lllllllllllIIllIIIlIlIIllllllIII instanceof IInventory) {
                        ((IInventory)lllllllllllIIllIIIlIlIIllllllIII).clear();
                    }
                    if (lllllllllllIIllIIIlIlIlIIIIIIlIl.setBlockState(lllllllllllIIllIIIlIlIIllllllIlI, lllllllllllIIllIIIlIlIlIIIIIlIIl, 2)) {
                        lllllllllllIIllIIIlIlIIllllllllI.add(lllllllllllIIllIIIlIlIIllllllIlI);
                        ++lllllllllllIIllIIIlIlIlIIIIIIllI;
                        if (lllllllllllIIllIIIlIlIlIIIIIIIIl) {
                            final TileEntity lllllllllllIIllIIIlIlIIlllllIlll = lllllllllllIIllIIIlIlIlIIIIIIlIl.getTileEntity(lllllllllllIIllIIIlIlIIllllllIlI);
                            if (lllllllllllIIllIIIlIlIIlllllIlll != null) {
                                lllllllllllIIllIIIlIlIlIIIIIIIlI.setInteger("x", lllllllllllIIllIIIlIlIIllllllIlI.getX());
                                lllllllllllIIllIIIlIlIlIIIIIIIlI.setInteger("y", lllllllllllIIllIIIlIlIIllllllIlI.getY());
                                lllllllllllIIllIIIlIlIlIIIIIIIlI.setInteger("z", lllllllllllIIllIIIlIlIIllllllIlI.getZ());
                                lllllllllllIIllIIIlIlIIlllllIlll.readFromNBT(lllllllllllIIllIIIlIlIlIIIIIIIlI);
                            }
                        }
                    }
                }
            }
        }
        for (final BlockPos lllllllllllIIllIIIlIlIIlllllIllI : lllllllllllIIllIIIlIlIIllllllllI) {
            final Block lllllllllllIIllIIIlIlIIlllllIlIl = lllllllllllIIllIIIlIlIlIIIIIIlIl.getBlockState(lllllllllllIIllIIIlIlIIlllllIllI).getBlock();
            lllllllllllIIllIIIlIlIlIIIIIIlIl.notifyNeighborsRespectDebug(lllllllllllIIllIIIlIlIIlllllIllI, lllllllllllIIllIIIlIlIIlllllIlIl, false);
        }
        if (lllllllllllIIllIIIlIlIlIIIIIIllI <= 0) {
            throw new CommandException("commands.fill.failed", new Object[0]);
        }
        lllllllllllIIllIIIlIlIIlllllIIll.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, lllllllllllIIllIIIlIlIlIIIIIIllI);
        CommandBase.notifyCommandListener(lllllllllllIIllIIIlIlIIlllllIIll, this, "commands.fill.success", lllllllllllIIllIIIlIlIlIIIIIIllI);
    }
}
