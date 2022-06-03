// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public interface ICommand extends Comparable<ICommand>
{
    String getCommandUsage(final ICommandSender p0);
    
    void execute(final MinecraftServer p0, final ICommandSender p1, final String[] p2) throws CommandException;
    
    boolean checkPermission(final MinecraftServer p0, final ICommandSender p1);
    
    List<String> getTabCompletionOptions(final MinecraftServer p0, final ICommandSender p1, final String[] p2, final BlockPos p3);
    
    String getCommandName();
    
    boolean isUsernameIndex(final String[] p0, final int p1);
    
    List<String> getCommandAliases();
}
