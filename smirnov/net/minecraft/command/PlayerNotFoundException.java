// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class PlayerNotFoundException extends CommandException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public PlayerNotFoundException(final String llllllllllllIlllIIIIlIIIIlIIIllI) {
        super(llllllllllllIlllIIIIlIIIIlIIIllI, new Object[0]);
    }
    
    public PlayerNotFoundException(final String llllllllllllIlllIIIIlIIIIIllllII, final Object... llllllllllllIlllIIIIlIIIIIlllllI) {
        super(llllllllllllIlllIIIIlIIIIIllllII, llllllllllllIlllIIIIlIIIIIlllllI);
    }
}
