// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import javax.annotation.Nullable;

public abstract class PositionedSound implements ISound
{
    @Nullable
    private /* synthetic */ SoundEventAccessor soundEvent;
    protected /* synthetic */ AttenuationType attenuationType;
    protected /* synthetic */ float volume;
    protected /* synthetic */ SoundCategory category;
    protected /* synthetic */ float zPosF;
    protected /* synthetic */ int repeatDelay;
    protected /* synthetic */ float yPosF;
    protected /* synthetic */ float pitch;
    protected /* synthetic */ ResourceLocation positionedSoundLocation;
    protected /* synthetic */ float xPosF;
    protected /* synthetic */ boolean repeat;
    protected /* synthetic */ Sound sound;
    
    @Override
    public Sound getSound() {
        return this.sound;
    }
    
    @Override
    public float getVolume() {
        return this.volume * this.sound.getVolume();
    }
    
    @Override
    public float getPitch() {
        return this.pitch * this.sound.getPitch();
    }
    
    @Override
    public SoundEventAccessor createAccessor(final SoundHandler llllllllllIlllllIlllIlIIIllIllIl) {
        this.soundEvent = llllllllllIlllllIlllIlIIIllIllIl.getAccessor(this.positionedSoundLocation);
        if (this.soundEvent == null) {
            this.sound = SoundHandler.MISSING_SOUND;
        }
        else {
            this.sound = this.soundEvent.cloneEntry();
        }
        return this.soundEvent;
    }
    
    @Override
    public float getXPosF() {
        return this.xPosF;
    }
    
    protected PositionedSound(final ResourceLocation llllllllllIlllllIlllIlIIIllllIII, final SoundCategory llllllllllIlllllIlllIlIIIlllIlII) {
        this.volume = 1.0f;
        this.pitch = 1.0f;
        this.attenuationType = AttenuationType.LINEAR;
        this.positionedSoundLocation = llllllllllIlllllIlllIlIIIllllIII;
        this.category = llllllllllIlllllIlllIlIIIlllIlII;
    }
    
    @Override
    public float getYPosF() {
        return this.yPosF;
    }
    
    @Override
    public ResourceLocation getSoundLocation() {
        return this.positionedSoundLocation;
    }
    
    @Override
    public int getRepeatDelay() {
        return this.repeatDelay;
    }
    
    @Override
    public boolean canRepeat() {
        return this.repeat;
    }
    
    protected PositionedSound(final SoundEvent llllllllllIlllllIlllIlIIIllllllI, final SoundCategory llllllllllIlllllIlllIlIIlIIIIIII) {
        this(llllllllllIlllllIlllIlIIIllllllI.getSoundName(), llllllllllIlllllIlllIlIIlIIIIIII);
    }
    
    @Override
    public float getZPosF() {
        return this.zPosF;
    }
    
    @Override
    public AttenuationType getAttenuationType() {
        return this.attenuationType;
    }
    
    @Override
    public SoundCategory getCategory() {
        return this.category;
    }
}
