// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class NumberInvalidException extends CommandException
{
    public NumberInvalidException() {
        this("commands.generic.num.invalid", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public NumberInvalidException(final String lllllllllllllllIlllIIIlIIlllIIll, final Object... lllllllllllllllIlllIIIlIIllIllll) {
        super(lllllllllllllllIlllIIIlIIlllIIll, lllllllllllllllIlllIIIlIIllIllll);
    }
}
