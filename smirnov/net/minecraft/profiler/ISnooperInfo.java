// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.profiler;

public interface ISnooperInfo
{
    void addServerTypeToSnooper(final Snooper p0);
    
    boolean isSnooperEnabled();
    
    void addServerStatsToSnooper(final Snooper p0);
}
