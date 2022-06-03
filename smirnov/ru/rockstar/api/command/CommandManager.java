// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command;

import ru.rockstar.api.command.impl.HelpCommand;
import ru.rockstar.api.command.impl.ConfigCommand;
import ru.rockstar.api.command.impl.MacroCommand;
import ru.rockstar.api.command.impl.PanicCommand;
import ru.rockstar.api.command.impl.FriendCommand;
import ru.rockstar.api.command.impl.PClipCommand;
import ru.rockstar.api.command.impl.ClipCommand;
import ru.rockstar.api.command.impl.BindCommand;
import ru.rockstar.api.event.EventManager;
import java.util.List;
import java.util.ArrayList;

public class CommandManager
{
    private final /* synthetic */ ArrayList<Command> commands;
    
    public boolean execute(final String lllllllllllIlIIlllIIlIIlllIIlIIl) {
        final String lllllllllllIlIIlllIIlIIlllIlIIII = lllllllllllIlIIlllIIlIIlllIIlIIl.substring(1);
        final String[] lllllllllllIlIIlllIIlIIlllIIllll = lllllllllllIlIIlllIIlIIlllIlIIII.split(" ");
        if (lllllllllllIlIIlllIIlIIlllIIllll.length > 0) {
            for (final Command lllllllllllIlIIlllIIlIIlllIIlllI : this.commands) {
                final CommandAbstract lllllllllllIlIIlllIIlIIlllIIllIl = (CommandAbstract)lllllllllllIlIIlllIIlIIlllIIlllI;
                final String[] lllllllllllIlIIlllIIlIIlllIIllII = lllllllllllIlIIlllIIlIIlllIIllIl.getAliases();
                final short lllllllllllIlIIlllIIlIIllIllllll;
                final byte lllllllllllIlIIlllIIlIIlllIIIIII = (byte)((String[])(Object)(lllllllllllIlIIlllIIlIIllIllllll = (short)(Object)lllllllllllIlIIlllIIlIIlllIIllII)).length;
                for (long lllllllllllIlIIlllIIlIIlllIIIIIl = 0; lllllllllllIlIIlllIIlIIlllIIIIIl < lllllllllllIlIIlllIIlIIlllIIIIII; ++lllllllllllIlIIlllIIlIIlllIIIIIl) {
                    final String lllllllllllIlIIlllIIlIIlllIIlIll = lllllllllllIlIIlllIIlIIllIllllll[lllllllllllIlIIlllIIlIIlllIIIIIl];
                    if (lllllllllllIlIIlllIIlIIlllIIllll[0].equalsIgnoreCase(lllllllllllIlIIlllIIlIIlllIIlIll)) {
                        lllllllllllIlIIlllIIlIIlllIIllIl.execute(lllllllllllIlIIlllIIlIIlllIIllll);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public List<Command> getCommands() {
        return this.commands;
    }
    
    public CommandManager() {
        this.commands = new ArrayList<Command>();
        EventManager.register(new CommandHandler(this));
        this.commands.add(new BindCommand());
        this.commands.add(new ClipCommand());
        this.commands.add(new PClipCommand());
        this.commands.add(new FriendCommand());
        this.commands.add(new PanicCommand());
        this.commands.add(new MacroCommand());
        this.commands.add(new ConfigCommand());
        this.commands.add(new HelpCommand());
    }
}
