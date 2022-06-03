// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class CommandNotFoundException extends CommandException
{
    public CommandNotFoundException(final String llllllllllllIllllIIIIIIIlIlIlIll, final Object... llllllllllllIllllIIIIIIIlIlIllIl) {
        super(llllllllllllIllllIIIIIIIlIlIlIll, llllllllllllIllllIIIIIIIlIlIllIl);
    }
    
    public CommandNotFoundException() {
        this("commands.generic.notFound", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
