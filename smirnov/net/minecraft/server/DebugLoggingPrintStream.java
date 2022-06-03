// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server;

import java.io.OutputStream;
import net.minecraft.util.LoggingPrintStream;

public class DebugLoggingPrintStream extends LoggingPrintStream
{
    @Override
    protected void logString(final String llllllllllllIIIIllllIlllllIlIlll) {
        final StackTraceElement[] llllllllllllIIIIllllIlllllIllIlI = Thread.currentThread().getStackTrace();
        final StackTraceElement llllllllllllIIIIllllIlllllIllIIl = llllllllllllIIIIllllIlllllIllIlI[Math.min(3, llllllllllllIIIIllllIlllllIllIlI.length)];
        DebugLoggingPrintStream.LOGGER.info("[{}]@.({}:{}): {}", (Object)this.domain, (Object)llllllllllllIIIIllllIlllllIllIIl.getFileName(), (Object)llllllllllllIIIIllllIlllllIllIIl.getLineNumber(), (Object)llllllllllllIIIIllllIlllllIlIlll);
    }
    
    public DebugLoggingPrintStream(final String llllllllllllIIIIllllIllllllIIlIl, final OutputStream llllllllllllIIIIllllIllllllIIIIl) {
        super(llllllllllllIIIIllllIllllllIIlIl, llllllllllllIIIIllllIllllllIIIIl);
    }
}
