// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import javax.annotation.Nullable;

public interface ISound
{
    float getXPosF();
    
    @Nullable
    SoundEventAccessor createAccessor(final SoundHandler p0);
    
    AttenuationType getAttenuationType();
    
    float getVolume();
    
    float getZPosF();
    
    ResourceLocation getSoundLocation();
    
    float getPitch();
    
    float getYPosF();
    
    Sound getSound();
    
    int getRepeatDelay();
    
    SoundCategory getCategory();
    
    boolean canRepeat();
    
    public enum AttenuationType
    {
        LINEAR("LINEAR", 1, 2);
        
        private final /* synthetic */ int type;
        
        NONE("NONE", 0, 0);
        
        public int getTypeInt() {
            return this.type;
        }
        
        private AttenuationType(final String lllllllllllllllIlllllllIIlIlllIl, final int lllllllllllllllIlllllllIIlIlllII, final int lllllllllllllllIlllllllIIlIlllll) {
            this.type = lllllllllllllllIlllllllIIlIlllll;
        }
    }
}
