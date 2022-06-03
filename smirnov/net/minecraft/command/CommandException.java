// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class CommandException extends Exception
{
    private final /* synthetic */ Object[] errorObjects;
    
    public Object[] getErrorObjects() {
        return this.errorObjects;
    }
    
    public CommandException(final String lllllllllllIlIIIlIllllIlIIlIlIll, final Object... lllllllllllIlIIIlIllllIlIIlIlIlI) {
        super(lllllllllllIlIIIlIllllIlIIlIlIll);
        this.errorObjects = lllllllllllIlIIIlIllllIlIIlIlIlI;
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
