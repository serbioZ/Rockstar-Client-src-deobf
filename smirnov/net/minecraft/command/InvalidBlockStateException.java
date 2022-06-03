// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class InvalidBlockStateException extends CommandException
{
    public InvalidBlockStateException(final String llllllllllllIlllllIIlIlIllIIllll, final Object... llllllllllllIlllllIIlIlIllIIlllI) {
        super(llllllllllllIlllllIIlIlIllIIllll, llllllllllllIlllllIIlIlIllIIlllI);
    }
    
    public InvalidBlockStateException() {
        this("commands.generic.blockstate.invalid", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
