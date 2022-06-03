// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandCompare extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIlllIIIIlIllIIIIIlI) {
        return "commands.compare.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIlllIIIIlIlIIlllIII, final ICommandSender llllllllllllIIlllIIIIlIlIIllIlll, final String[] llllllllllllIIlllIIIIlIlIIllIlII, @Nullable final BlockPos llllllllllllIIlllIIIIlIlIIllIlIl) {
        if (llllllllllllIIlllIIIIlIlIIllIlII.length > 0 && llllllllllllIIlllIIIIlIlIIllIlII.length <= 3) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllIIlllIIIIlIlIIllIlII, 0, llllllllllllIIlllIIIIlIlIIllIlIl);
        }
        if (llllllllllllIIlllIIIIlIlIIllIlII.length > 3 && llllllllllllIIlllIIIIlIlIIllIlII.length <= 6) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllIIlllIIIIlIlIIllIlII, 3, llllllllllllIIlllIIIIlIlIIllIlIl);
        }
        if (llllllllllllIIlllIIIIlIlIIllIlII.length > 6 && llllllllllllIIlllIIIIlIlIIllIlII.length <= 9) {
            return CommandBase.getTabCompletionCoordinate(llllllllllllIIlllIIIIlIlIIllIlII, 6, llllllllllllIIlllIIIIlIlIIllIlIl);
        }
        return (llllllllllllIIlllIIIIlIlIIllIlII.length == 10) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIlllIIIIlIlIIllIlII, "masked", "all") : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIlllIIIIlIlIllIlIIl, final ICommandSender llllllllllllIIlllIIIIlIlIllIlIII, final String[] llllllllllllIIlllIIIIlIlIllIIlll) throws CommandException {
        if (llllllllllllIIlllIIIIlIlIllIIlll.length < 9) {
            throw new WrongUsageException("commands.compare.usage", new Object[0]);
        }
        llllllllllllIIlllIIIIlIlIllIlIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        final BlockPos llllllllllllIIlllIIIIlIlIllIIllI = CommandBase.parseBlockPos(llllllllllllIIlllIIIIlIlIllIlIII, llllllllllllIIlllIIIIlIlIllIIlll, 0, false);
        final BlockPos llllllllllllIIlllIIIIlIlIllIIlIl = CommandBase.parseBlockPos(llllllllllllIIlllIIIIlIlIllIlIII, llllllllllllIIlllIIIIlIlIllIIlll, 3, false);
        final BlockPos llllllllllllIIlllIIIIlIlIllIIlII = CommandBase.parseBlockPos(llllllllllllIIlllIIIIlIlIllIlIII, llllllllllllIIlllIIIIlIlIllIIlll, 6, false);
        final StructureBoundingBox llllllllllllIIlllIIIIlIlIllIIIll = new StructureBoundingBox(llllllllllllIIlllIIIIlIlIllIIllI, llllllllllllIIlllIIIIlIlIllIIlIl);
        final StructureBoundingBox llllllllllllIIlllIIIIlIlIllIIIlI = new StructureBoundingBox(llllllllllllIIlllIIIIlIlIllIIlII, llllllllllllIIlllIIIIlIlIllIIlII.add(llllllllllllIIlllIIIIlIlIllIIIll.getLength()));
        int llllllllllllIIlllIIIIlIlIllIIIIl = llllllllllllIIlllIIIIlIlIllIIIll.getXSize() * llllllllllllIIlllIIIIlIlIllIIIll.getYSize() * llllllllllllIIlllIIIIlIlIllIIIll.getZSize();
        if (llllllllllllIIlllIIIIlIlIllIIIIl > 524288) {
            throw new CommandException("commands.compare.tooManyBlocks", new Object[] { llllllllllllIIlllIIIIlIlIllIIIIl, 524288 });
        }
        if (llllllllllllIIlllIIIIlIlIllIIIll.minY < 0 || llllllllllllIIlllIIIIlIlIllIIIll.maxY >= 256 || llllllllllllIIlllIIIIlIlIllIIIlI.minY < 0 || llllllllllllIIlllIIIIlIlIllIIIlI.maxY >= 256) {
            throw new CommandException("commands.compare.outOfWorld", new Object[0]);
        }
        final World llllllllllllIIlllIIIIlIlIllIIIII = llllllllllllIIlllIIIIlIlIllIlIII.getEntityWorld();
        if (llllllllllllIIlllIIIIlIlIllIIIII.isAreaLoaded(llllllllllllIIlllIIIIlIlIllIIIll) && llllllllllllIIlllIIIIlIlIllIIIII.isAreaLoaded(llllllllllllIIlllIIIIlIlIllIIIlI)) {
            boolean llllllllllllIIlllIIIIlIlIlIlllll = false;
            if (llllllllllllIIlllIIIIlIlIllIIlll.length > 9 && "masked".equals(llllllllllllIIlllIIIIlIlIllIIlll[9])) {
                llllllllllllIIlllIIIIlIlIlIlllll = true;
            }
            llllllllllllIIlllIIIIlIlIllIIIIl = 0;
            final BlockPos llllllllllllIIlllIIIIlIlIlIllllI = new BlockPos(llllllllllllIIlllIIIIlIlIllIIIlI.minX - llllllllllllIIlllIIIIlIlIllIIIll.minX, llllllllllllIIlllIIIIlIlIllIIIlI.minY - llllllllllllIIlllIIIIlIlIllIIIll.minY, llllllllllllIIlllIIIIlIlIllIIIlI.minZ - llllllllllllIIlllIIIIlIlIllIIIll.minZ);
            final BlockPos.MutableBlockPos llllllllllllIIlllIIIIlIlIlIlllIl = new BlockPos.MutableBlockPos();
            final BlockPos.MutableBlockPos llllllllllllIIlllIIIIlIlIlIlllII = new BlockPos.MutableBlockPos();
            for (int llllllllllllIIlllIIIIlIlIlIllIll = llllllllllllIIlllIIIIlIlIllIIIll.minZ; llllllllllllIIlllIIIIlIlIlIllIll <= llllllllllllIIlllIIIIlIlIllIIIll.maxZ; ++llllllllllllIIlllIIIIlIlIlIllIll) {
                for (int llllllllllllIIlllIIIIlIlIlIllIlI = llllllllllllIIlllIIIIlIlIllIIIll.minY; llllllllllllIIlllIIIIlIlIlIllIlI <= llllllllllllIIlllIIIIlIlIllIIIll.maxY; ++llllllllllllIIlllIIIIlIlIlIllIlI) {
                    for (int llllllllllllIIlllIIIIlIlIlIllIIl = llllllllllllIIlllIIIIlIlIllIIIll.minX; llllllllllllIIlllIIIIlIlIlIllIIl <= llllllllllllIIlllIIIIlIlIllIIIll.maxX; ++llllllllllllIIlllIIIIlIlIlIllIIl) {
                        llllllllllllIIlllIIIIlIlIlIlllIl.setPos(llllllllllllIIlllIIIIlIlIlIllIIl, llllllllllllIIlllIIIIlIlIlIllIlI, llllllllllllIIlllIIIIlIlIlIllIll);
                        llllllllllllIIlllIIIIlIlIlIlllII.setPos(llllllllllllIIlllIIIIlIlIlIllIIl + llllllllllllIIlllIIIIlIlIlIllllI.getX(), llllllllllllIIlllIIIIlIlIlIllIlI + llllllllllllIIlllIIIIlIlIlIllllI.getY(), llllllllllllIIlllIIIIlIlIlIllIll + llllllllllllIIlllIIIIlIlIlIllllI.getZ());
                        boolean llllllllllllIIlllIIIIlIlIlIllIII = false;
                        final IBlockState llllllllllllIIlllIIIIlIlIlIlIlll = llllllllllllIIlllIIIIlIlIllIIIII.getBlockState(llllllllllllIIlllIIIIlIlIlIlllIl);
                        if (!llllllllllllIIlllIIIIlIlIlIlllll || llllllllllllIIlllIIIIlIlIlIlIlll.getBlock() != Blocks.AIR) {
                            if (llllllllllllIIlllIIIIlIlIlIlIlll == llllllllllllIIlllIIIIlIlIllIIIII.getBlockState(llllllllllllIIlllIIIIlIlIlIlllII)) {
                                final TileEntity llllllllllllIIlllIIIIlIlIlIlIllI = llllllllllllIIlllIIIIlIlIllIIIII.getTileEntity(llllllllllllIIlllIIIIlIlIlIlllIl);
                                final TileEntity llllllllllllIIlllIIIIlIlIlIlIlIl = llllllllllllIIlllIIIIlIlIllIIIII.getTileEntity(llllllllllllIIlllIIIIlIlIlIlllII);
                                if (llllllllllllIIlllIIIIlIlIlIlIllI != null && llllllllllllIIlllIIIIlIlIlIlIlIl != null) {
                                    final NBTTagCompound llllllllllllIIlllIIIIlIlIlIlIlII = llllllllllllIIlllIIIIlIlIlIlIllI.writeToNBT(new NBTTagCompound());
                                    llllllllllllIIlllIIIIlIlIlIlIlII.removeTag("x");
                                    llllllllllllIIlllIIIIlIlIlIlIlII.removeTag("y");
                                    llllllllllllIIlllIIIIlIlIlIlIlII.removeTag("z");
                                    final NBTTagCompound llllllllllllIIlllIIIIlIlIlIlIIll = llllllllllllIIlllIIIIlIlIlIlIlIl.writeToNBT(new NBTTagCompound());
                                    llllllllllllIIlllIIIIlIlIlIlIIll.removeTag("x");
                                    llllllllllllIIlllIIIIlIlIlIlIIll.removeTag("y");
                                    llllllllllllIIlllIIIIlIlIlIlIIll.removeTag("z");
                                    if (!llllllllllllIIlllIIIIlIlIlIlIlII.equals(llllllllllllIIlllIIIIlIlIlIlIIll)) {
                                        llllllllllllIIlllIIIIlIlIlIllIII = true;
                                    }
                                }
                                else if (llllllllllllIIlllIIIIlIlIlIlIllI != null) {
                                    llllllllllllIIlllIIIIlIlIlIllIII = true;
                                }
                            }
                            else {
                                llllllllllllIIlllIIIIlIlIlIllIII = true;
                            }
                            ++llllllllllllIIlllIIIIlIlIllIIIIl;
                            if (llllllllllllIIlllIIIIlIlIlIllIII) {
                                throw new CommandException("commands.compare.failed", new Object[0]);
                            }
                        }
                    }
                }
            }
            llllllllllllIIlllIIIIlIlIllIlIII.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, llllllllllllIIlllIIIIlIlIllIIIIl);
            CommandBase.notifyCommandListener(llllllllllllIIlllIIIIlIlIllIlIII, this, "commands.compare.success", llllllllllllIIlllIIIIlIlIllIIIIl);
            return;
        }
        throw new CommandException("commands.compare.outOfWorld", new Object[0]);
    }
    
    @Override
    public String getCommandName() {
        return "testforblocks";
    }
}
