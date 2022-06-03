// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Map;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public interface ICommandManager
{
    List<ICommand> getPossibleCommands(final ICommandSender p0);
    
    int executeCommand(final ICommandSender p0, final String p1);
    
    List<String> getTabCompletionOptions(final ICommandSender p0, final String p1, final BlockPos p2);
    
    Map<String, ICommand> getCommands();
}
