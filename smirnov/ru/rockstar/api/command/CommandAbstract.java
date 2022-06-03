// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command;

import ru.rockstar.Main;
import ru.rockstar.api.utils.Helper;

public abstract class CommandAbstract implements Command, Helper
{
    private final /* synthetic */ String name;
    private final /* synthetic */ String usage;
    private final /* synthetic */ String description;
    private final /* synthetic */ String[] aliases;
    
    public CommandAbstract(final String llllllllllllIlIIlIlIllIlIllIIIII, final String llllllllllllIlIIlIlIllIlIllIIlII, final String llllllllllllIlIIlIlIllIlIlIllllI, final String... llllllllllllIlIIlIlIllIlIllIIIlI) {
        this.name = llllllllllllIlIIlIlIllIlIllIIIII;
        this.description = llllllllllllIlIIlIlIllIlIllIIlII;
        this.aliases = llllllllllllIlIIlIlIllIlIllIIIlI;
        this.usage = llllllllllllIlIIlIlIllIlIlIllllI;
    }
    
    public String[] getAliases() {
        return this.aliases;
    }
    
    public void usage() {
        Main.msg("§cInvalid usage, try: " + this.usage + " or .help", true);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public String getDescription() {
        return this.description;
    }
}
