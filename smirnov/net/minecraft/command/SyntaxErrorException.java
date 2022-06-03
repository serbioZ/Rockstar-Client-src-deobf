// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class SyntaxErrorException extends CommandException
{
    public SyntaxErrorException() {
        this("commands.generic.snytax", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public SyntaxErrorException(final String lllllllllllIIIllIIIIIlIIIIllIIll, final Object... lllllllllllIIIllIIIIIlIIIIllIIlI) {
        super(lllllllllllIIIllIIIIIlIIIIllIIll, lllllllllllIIIllIIIIIlIIIIllIIlI);
    }
}
