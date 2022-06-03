// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.ITickable;

public interface ITickableSound extends ITickable, ISound
{
    boolean isDonePlaying();
}
