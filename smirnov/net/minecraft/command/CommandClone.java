// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.tileentity.TileEntity;
import java.util.Deque;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.world.NextTickListEntry;
import java.util.List;
import java.util.Collection;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import com.google.common.collect.Lists;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.server.MinecraftServer;

public class CommandClone extends CommandBase
{
    @Override
    public String getCommandName() {
        return "clone";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlllIllIIlIllIIIIllII) {
        return "commands.clone.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlllIllIIlIlIlllIllll, final ICommandSender lllllllllllIlllIllIIlIlIllIIIlIl, final String[] lllllllllllIlllIllIIlIlIllIIIlII) throws CommandException {
        if (lllllllllllIlllIllIIlIlIllIIIlII.length < 9) {
            throw new WrongUsageException("commands.clone.usage", new Object[0]);
        }
        lllllllllllIlllIllIIlIlIllIIIlIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos lllllllllllIlllIllIIlIlIlllIllII = CommandBase.parseBlockPos(lllllllllllIlllIllIIlIlIllIIIlIl, lllllllllllIlllIllIIlIlIllIIIlII, 0, false);
        final BlockPos lllllllllllIlllIllIIlIlIlllIlIll = CommandBase.parseBlockPos(lllllllllllIlllIllIIlIlIllIIIlIl, lllllllllllIlllIllIIlIlIllIIIlII, 3, false);
        final BlockPos lllllllllllIlllIllIIlIlIlllIlIlI = CommandBase.parseBlockPos(lllllllllllIlllIllIIlIlIllIIIlIl, lllllllllllIlllIllIIlIlIllIIIlII, 6, false);
        final StructureBoundingBox lllllllllllIlllIllIIlIlIlllIlIIl = new StructureBoundingBox(lllllllllllIlllIllIIlIlIlllIllII, lllllllllllIlllIllIIlIlIlllIlIll);
        final StructureBoundingBox lllllllllllIlllIllIIlIlIlllIlIII = new StructureBoundingBox(lllllllllllIlllIllIIlIlIlllIlIlI, lllllllllllIlllIllIIlIlIlllIlIlI.add(lllllllllllIlllIllIIlIlIlllIlIIl.getLength()));
        int lllllllllllIlllIllIIlIlIlllIIlll = lllllllllllIlllIllIIlIlIlllIlIIl.getXSize() * lllllllllllIlllIllIIlIlIlllIlIIl.getYSize() * lllllllllllIlllIllIIlIlIlllIlIIl.getZSize();
        if (lllllllllllIlllIllIIlIlIlllIIlll > 32768) {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[] { lllllllllllIlllIllIIlIlIlllIIlll, 32768 });
        }
        boolean lllllllllllIlllIllIIlIlIlllIIllI = false;
        Block lllllllllllIlllIllIIlIlIlllIIlIl = null;
        Predicate<IBlockState> lllllllllllIlllIllIIlIlIlllIIlII = null;
        if ((lllllllllllIlllIllIIlIlIllIIIlII.length < 11 || (!"force".equals(lllllllllllIlllIllIIlIlIllIIIlII[10]) && !"move".equals(lllllllllllIlllIllIIlIlIllIIIlII[10]))) && lllllllllllIlllIllIIlIlIlllIlIIl.intersectsWith(lllllllllllIlllIllIIlIlIlllIlIII)) {
            throw new CommandException("commands.clone.noOverlap", new Object[0]);
        }
        if (lllllllllllIlllIllIIlIlIllIIIlII.length >= 11 && "move".equals(lllllllllllIlllIllIIlIlIllIIIlII[10])) {
            lllllllllllIlllIllIIlIlIlllIIllI = true;
        }
        if (lllllllllllIlllIllIIlIlIlllIlIIl.minY < 0 || lllllllllllIlllIllIIlIlIlllIlIIl.maxY >= 256 || lllllllllllIlllIllIIlIlIlllIlIII.minY < 0 || lllllllllllIlllIllIIlIlIlllIlIII.maxY >= 256) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        final World lllllllllllIlllIllIIlIlIlllIIIll = lllllllllllIlllIllIIlIlIllIIIlIl.getEntityWorld();
        if (!lllllllllllIlllIllIIlIlIlllIIIll.isAreaLoaded(lllllllllllIlllIllIIlIlIlllIlIIl) || !lllllllllllIlllIllIIlIlIlllIIIll.isAreaLoaded(lllllllllllIlllIllIIlIlIlllIlIII)) {
            throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        }
        boolean lllllllllllIlllIllIIlIlIlllIIIlI = false;
        if (lllllllllllIlllIllIIlIlIllIIIlII.length >= 10) {
            if ("masked".equals(lllllllllllIlllIllIIlIlIllIIIlII[9])) {
                lllllllllllIlllIllIIlIlIlllIIIlI = true;
            }
            else if ("filtered".equals(lllllllllllIlllIllIIlIlIllIIIlII[9])) {
                if (lllllllllllIlllIllIIlIlIllIIIlII.length < 12) {
                    throw new WrongUsageException("commands.clone.usage", new Object[0]);
                }
                lllllllllllIlllIllIIlIlIlllIIlIl = CommandBase.getBlockByText(lllllllllllIlllIllIIlIlIllIIIlIl, lllllllllllIlllIllIIlIlIllIIIlII[11]);
                if (lllllllllllIlllIllIIlIlIllIIIlII.length >= 13) {
                    lllllllllllIlllIllIIlIlIlllIIlII = CommandBase.func_190791_b(lllllllllllIlllIllIIlIlIlllIIlIl, lllllllllllIlllIllIIlIlIllIIIlII[12]);
                }
            }
        }
        final List<StaticCloneData> lllllllllllIlllIllIIlIlIlllIIIIl = (List<StaticCloneData>)Lists.newArrayList();
        final List<StaticCloneData> lllllllllllIlllIllIIlIlIlllIIIII = (List<StaticCloneData>)Lists.newArrayList();
        final List<StaticCloneData> lllllllllllIlllIllIIlIlIllIlllll = (List<StaticCloneData>)Lists.newArrayList();
        final Deque<BlockPos> lllllllllllIlllIllIIlIlIllIllllI = (Deque<BlockPos>)Lists.newLinkedList();
        final BlockPos lllllllllllIlllIllIIlIlIllIlllIl = new BlockPos(lllllllllllIlllIllIIlIlIlllIlIII.minX - lllllllllllIlllIllIIlIlIlllIlIIl.minX, lllllllllllIlllIllIIlIlIlllIlIII.minY - lllllllllllIlllIllIIlIlIlllIlIIl.minY, lllllllllllIlllIllIIlIlIlllIlIII.minZ - lllllllllllIlllIllIIlIlIlllIlIIl.minZ);
        for (int lllllllllllIlllIllIIlIlIllIlllII = lllllllllllIlllIllIIlIlIlllIlIIl.minZ; lllllllllllIlllIllIIlIlIllIlllII <= lllllllllllIlllIllIIlIlIlllIlIIl.maxZ; ++lllllllllllIlllIllIIlIlIllIlllII) {
            for (int lllllllllllIlllIllIIlIlIllIllIll = lllllllllllIlllIllIIlIlIlllIlIIl.minY; lllllllllllIlllIllIIlIlIllIllIll <= lllllllllllIlllIllIIlIlIlllIlIIl.maxY; ++lllllllllllIlllIllIIlIlIllIllIll) {
                for (int lllllllllllIlllIllIIlIlIllIllIlI = lllllllllllIlllIllIIlIlIlllIlIIl.minX; lllllllllllIlllIllIIlIlIllIllIlI <= lllllllllllIlllIllIIlIlIlllIlIIl.maxX; ++lllllllllllIlllIllIIlIlIllIllIlI) {
                    final BlockPos lllllllllllIlllIllIIlIlIllIllIIl = new BlockPos(lllllllllllIlllIllIIlIlIllIllIlI, lllllllllllIlllIllIIlIlIllIllIll, lllllllllllIlllIllIIlIlIllIlllII);
                    final BlockPos lllllllllllIlllIllIIlIlIllIllIII = lllllllllllIlllIllIIlIlIllIllIIl.add(lllllllllllIlllIllIIlIlIllIlllIl);
                    final IBlockState lllllllllllIlllIllIIlIlIllIlIlll = lllllllllllIlllIllIIlIlIlllIIIll.getBlockState(lllllllllllIlllIllIIlIlIllIllIIl);
                    if ((!lllllllllllIlllIllIIlIlIlllIIIlI || lllllllllllIlllIllIIlIlIllIlIlll.getBlock() != Blocks.AIR) && (lllllllllllIlllIllIIlIlIlllIIlIl == null || (lllllllllllIlllIllIIlIlIllIlIlll.getBlock() == lllllllllllIlllIllIIlIlIlllIIlIl && (lllllllllllIlllIllIIlIlIlllIIlII == null || lllllllllllIlllIllIIlIlIlllIIlII.apply((Object)lllllllllllIlllIllIIlIlIllIlIlll))))) {
                        final TileEntity lllllllllllIlllIllIIlIlIllIlIllI = lllllllllllIlllIllIIlIlIlllIIIll.getTileEntity(lllllllllllIlllIllIIlIlIllIllIIl);
                        if (lllllllllllIlllIllIIlIlIllIlIllI != null) {
                            final NBTTagCompound lllllllllllIlllIllIIlIlIllIlIlIl = lllllllllllIlllIllIIlIlIllIlIllI.writeToNBT(new NBTTagCompound());
                            lllllllllllIlllIllIIlIlIlllIIIII.add(new StaticCloneData(lllllllllllIlllIllIIlIlIllIllIII, lllllllllllIlllIllIIlIlIllIlIlll, lllllllllllIlllIllIIlIlIllIlIlIl));
                            lllllllllllIlllIllIIlIlIllIllllI.addLast(lllllllllllIlllIllIIlIlIllIllIIl);
                        }
                        else if (!lllllllllllIlllIllIIlIlIllIlIlll.isFullBlock() && !lllllllllllIlllIllIIlIlIllIlIlll.isFullCube()) {
                            lllllllllllIlllIllIIlIlIllIlllll.add(new StaticCloneData(lllllllllllIlllIllIIlIlIllIllIII, lllllllllllIlllIllIIlIlIllIlIlll, null));
                            lllllllllllIlllIllIIlIlIllIllllI.addFirst(lllllllllllIlllIllIIlIlIllIllIIl);
                        }
                        else {
                            lllllllllllIlllIllIIlIlIlllIIIIl.add(new StaticCloneData(lllllllllllIlllIllIIlIlIllIllIII, lllllllllllIlllIllIIlIlIllIlIlll, null));
                            lllllllllllIlllIllIIlIlIllIllllI.addLast(lllllllllllIlllIllIIlIlIllIllIIl);
                        }
                    }
                }
            }
        }
        if (lllllllllllIlllIllIIlIlIlllIIllI) {
            for (final BlockPos lllllllllllIlllIllIIlIlIllIlIlII : lllllllllllIlllIllIIlIlIllIllllI) {
                final TileEntity lllllllllllIlllIllIIlIlIllIlIIll = lllllllllllIlllIllIIlIlIlllIIIll.getTileEntity(lllllllllllIlllIllIIlIlIllIlIlII);
                if (lllllllllllIlllIllIIlIlIllIlIIll instanceof IInventory) {
                    ((IInventory)lllllllllllIlllIllIIlIlIllIlIIll).clear();
                }
                lllllllllllIlllIllIIlIlIlllIIIll.setBlockState(lllllllllllIlllIllIIlIlIllIlIlII, Blocks.BARRIER.getDefaultState(), 2);
            }
            for (final BlockPos lllllllllllIlllIllIIlIlIllIlIIlI : lllllllllllIlllIllIIlIlIllIllllI) {
                lllllllllllIlllIllIIlIlIlllIIIll.setBlockState(lllllllllllIlllIllIIlIlIllIlIIlI, Blocks.AIR.getDefaultState(), 3);
            }
        }
        final List<StaticCloneData> lllllllllllIlllIllIIlIlIllIlIIIl = (List<StaticCloneData>)Lists.newArrayList();
        lllllllllllIlllIllIIlIlIllIlIIIl.addAll(lllllllllllIlllIllIIlIlIlllIIIIl);
        lllllllllllIlllIllIIlIlIllIlIIIl.addAll(lllllllllllIlllIllIIlIlIlllIIIII);
        lllllllllllIlllIllIIlIlIllIlIIIl.addAll(lllllllllllIlllIllIIlIlIllIlllll);
        final List<StaticCloneData> lllllllllllIlllIllIIlIlIllIlIIII = (List<StaticCloneData>)Lists.reverse((List)lllllllllllIlllIllIIlIlIllIlIIIl);
        for (final StaticCloneData lllllllllllIlllIllIIlIlIllIIllll : lllllllllllIlllIllIIlIlIllIlIIII) {
            final TileEntity lllllllllllIlllIllIIlIlIllIIlllI = lllllllllllIlllIllIIlIlIlllIIIll.getTileEntity(lllllllllllIlllIllIIlIlIllIIllll.pos);
            if (lllllllllllIlllIllIIlIlIllIIlllI instanceof IInventory) {
                ((IInventory)lllllllllllIlllIllIIlIlIllIIlllI).clear();
            }
            lllllllllllIlllIllIIlIlIlllIIIll.setBlockState(lllllllllllIlllIllIIlIlIllIIllll.pos, Blocks.BARRIER.getDefaultState(), 2);
        }
        lllllllllllIlllIllIIlIlIlllIIlll = 0;
        for (final StaticCloneData lllllllllllIlllIllIIlIlIllIIllIl : lllllllllllIlllIllIIlIlIllIlIIIl) {
            if (lllllllllllIlllIllIIlIlIlllIIIll.setBlockState(lllllllllllIlllIllIIlIlIllIIllIl.pos, lllllllllllIlllIllIIlIlIllIIllIl.blockState, 2)) {
                ++lllllllllllIlllIllIIlIlIlllIIlll;
            }
        }
        for (final StaticCloneData lllllllllllIlllIllIIlIlIllIIllII : lllllllllllIlllIllIIlIlIlllIIIII) {
            final TileEntity lllllllllllIlllIllIIlIlIllIIlIll = lllllllllllIlllIllIIlIlIlllIIIll.getTileEntity(lllllllllllIlllIllIIlIlIllIIllII.pos);
            if (lllllllllllIlllIllIIlIlIllIIllII.nbt != null && lllllllllllIlllIllIIlIlIllIIlIll != null) {
                lllllllllllIlllIllIIlIlIllIIllII.nbt.setInteger("x", lllllllllllIlllIllIIlIlIllIIllII.pos.getX());
                lllllllllllIlllIllIIlIlIllIIllII.nbt.setInteger("y", lllllllllllIlllIllIIlIlIllIIllII.pos.getY());
                lllllllllllIlllIllIIlIlIllIIllII.nbt.setInteger("z", lllllllllllIlllIllIIlIlIllIIllII.pos.getZ());
                lllllllllllIlllIllIIlIlIllIIlIll.readFromNBT(lllllllllllIlllIllIIlIlIllIIllII.nbt);
                lllllllllllIlllIllIIlIlIllIIlIll.markDirty();
            }
            lllllllllllIlllIllIIlIlIlllIIIll.setBlockState(lllllllllllIlllIllIIlIlIllIIllII.pos, lllllllllllIlllIllIIlIlIllIIllII.blockState, 2);
        }
        for (final StaticCloneData lllllllllllIlllIllIIlIlIllIIlIlI : lllllllllllIlllIllIIlIlIllIlIIII) {
            lllllllllllIlllIllIIlIlIlllIIIll.notifyNeighborsRespectDebug(lllllllllllIlllIllIIlIlIllIIlIlI.pos, lllllllllllIlllIllIIlIlIllIIlIlI.blockState.getBlock(), false);
        }
        final List<NextTickListEntry> lllllllllllIlllIllIIlIlIllIIlIIl = lllllllllllIlllIllIIlIlIlllIIIll.getPendingBlockUpdates(lllllllllllIlllIllIIlIlIlllIlIIl, false);
        if (lllllllllllIlllIllIIlIlIllIIlIIl != null) {
            for (final NextTickListEntry lllllllllllIlllIllIIlIlIllIIlIII : lllllllllllIlllIllIIlIlIllIIlIIl) {
                if (lllllllllllIlllIllIIlIlIlllIlIIl.isVecInside(lllllllllllIlllIllIIlIlIllIIlIII.position)) {
                    final BlockPos lllllllllllIlllIllIIlIlIllIIIlll = lllllllllllIlllIllIIlIlIllIIlIII.position.add(lllllllllllIlllIllIIlIlIllIlllIl);
                    lllllllllllIlllIllIIlIlIlllIIIll.scheduleBlockUpdate(lllllllllllIlllIllIIlIlIllIIIlll, lllllllllllIlllIllIIlIlIllIIlIII.getBlock(), (int)(lllllllllllIlllIllIIlIlIllIIlIII.scheduledTime - lllllllllllIlllIllIIlIlIlllIIIll.getWorldInfo().getWorldTotalTime()), lllllllllllIlllIllIIlIlIllIIlIII.priority);
                }
            }
        }
        if (lllllllllllIlllIllIIlIlIlllIIlll <= 0) {
            throw new CommandException("commands.clone.failed", new Object[0]);
        }
        lllllllllllIlllIllIIlIlIllIIIlIl.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, lllllllllllIlllIllIIlIlIlllIIlll);
        CommandBase.notifyCommandListener(lllllllllllIlllIllIIlIlIllIIIlIl, this, "commands.clone.success", lllllllllllIlllIllIIlIlIlllIIlll);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlllIllIIlIlIlIlIlIII, final ICommandSender lllllllllllIlllIllIIlIlIlIlIIlll, final String[] lllllllllllIlllIllIIlIlIlIlIIllI, @Nullable final BlockPos lllllllllllIlllIllIIlIlIlIlIIlIl) {
        if (lllllllllllIlllIllIIlIlIlIlIIllI.length > 0 && lllllllllllIlllIllIIlIlIlIlIIllI.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIlllIllIIlIlIlIlIIllI, 0, lllllllllllIlllIllIIlIlIlIlIIlIl);
        }
        if (lllllllllllIlllIllIIlIlIlIlIIllI.length > 3 && lllllllllllIlllIllIIlIlIlIlIIllI.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIlllIllIIlIlIlIlIIllI, 3, lllllllllllIlllIllIIlIlIlIlIIlIl);
        }
        if (lllllllllllIlllIllIIlIlIlIlIIllI.length > 6 && lllllllllllIlllIllIIlIlIlIlIIllI.length <= 9) {
            return CommandBase.getTabCompletionCoordinate(lllllllllllIlllIllIIlIlIlIlIIllI, 6, lllllllllllIlllIllIIlIlIlIlIIlIl);
        }
        if (lllllllllllIlllIllIIlIlIlIlIIllI.length == 10) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlllIllIIlIlIlIlIIllI, "replace", "masked", "filtered");
        }
        if (lllllllllllIlllIllIIlIlIlIlIIllI.length == 11) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlllIllIIlIlIlIlIIllI, "normal", "force", "move");
        }
        return (lllllllllllIlllIllIIlIlIlIlIIllI.length == 12 && "filtered".equals(lllllllllllIlllIllIIlIlIlIlIIllI[9])) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlllIllIIlIlIlIlIIllI, Block.REGISTRY.getKeys()) : Collections.emptyList();
    }
    
    static class StaticCloneData
    {
        public final /* synthetic */ NBTTagCompound nbt;
        public final /* synthetic */ IBlockState blockState;
        public final /* synthetic */ BlockPos pos;
        
        public StaticCloneData(final BlockPos llllllllllllllllllIllIIIlIIIIlII, final IBlockState llllllllllllllllllIllIIIIlllllll, final NBTTagCompound llllllllllllllllllIllIIIIllllllI) {
            this.pos = llllllllllllllllllIllIIIlIIIIlII;
            this.blockState = llllllllllllllllllIllIIIIlllllll;
            this.nbt = llllllllllllllllllIllIIIIllllllI;
        }
    }
}
