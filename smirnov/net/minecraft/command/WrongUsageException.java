// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class WrongUsageException extends SyntaxErrorException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public WrongUsageException(final String llllllllllllIllIlIllIlIlIllIlllI, final Object... llllllllllllIllIlIllIlIlIlllIIII) {
        super(llllllllllllIllIlIllIlIlIllIlllI, llllllllllllIllIlIllIlIlIlllIIII);
    }
}
