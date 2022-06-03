// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventMessage;

public class CommandHandler
{
    public /* synthetic */ CommandManager commandManager;
    
    @EventTarget
    public void onMessage(final EventMessage llllllllllllIlIIIIlIIllIllIlllll) {
        final String llllllllllllIlIIIIlIIllIllIllllI = llllllllllllIlIIIIlIIllIllIlllll.getMessage();
        if (llllllllllllIlIIIIlIIllIllIllllI.length() > 0 && llllllllllllIlIIIIlIIllIllIllllI.startsWith(".")) {
            llllllllllllIlIIIIlIIllIllIlllll.setCancelled(this.commandManager.execute(llllllllllllIlIIIIlIIllIllIllllI));
        }
    }
    
    public CommandHandler(final CommandManager llllllllllllIlIIIIlIIllIlllIIllI) {
        this.commandManager = llllllllllllIlIIIIlIIllIlllIIllI;
    }
}
