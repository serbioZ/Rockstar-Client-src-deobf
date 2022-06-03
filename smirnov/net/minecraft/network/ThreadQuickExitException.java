// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

public final class ThreadQuickExitException extends RuntimeException
{
    private ThreadQuickExitException() {
        this.setStackTrace(new StackTraceElement[0]);
    }
    
    static {
        INSTANCE = new ThreadQuickExitException();
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
