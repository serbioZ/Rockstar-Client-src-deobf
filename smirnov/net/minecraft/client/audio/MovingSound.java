// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public abstract class MovingSound extends PositionedSound implements ITickableSound
{
    protected /* synthetic */ boolean donePlaying;
    
    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }
    
    protected MovingSound(final SoundEvent lllllllllllIIIIIIIIlIIlIIIIllIII, final SoundCategory lllllllllllIIIIIIIIlIIlIIIIlIlII) {
        super(lllllllllllIIIIIIIIlIIlIIIIllIII, lllllllllllIIIIIIIIlIIlIIIIlIlII);
    }
}
