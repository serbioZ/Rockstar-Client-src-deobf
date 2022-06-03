// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

public class EntityNotFoundException extends CommandException
{
    public EntityNotFoundException(final String lllllllllllIlIlIIIllIIllIlIlIIIl, final Object... lllllllllllIlIlIIIllIIllIlIIllIl) {
        super(lllllllllllIlIlIIIllIIllIlIlIIIl, lllllllllllIlIlIIIllIIllIlIIllIl);
    }
    
    public EntityNotFoundException(final String lllllllllllIlIlIIIllIIllIlIllIII) {
        this("commands.generic.entity.notFound", new Object[] { lllllllllllIlIlIIIllIIllIlIllIII });
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
