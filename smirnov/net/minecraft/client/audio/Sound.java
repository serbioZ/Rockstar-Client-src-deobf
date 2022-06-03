// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;

public class Sound implements ISoundEventAccessor<Sound>
{
    private final /* synthetic */ ResourceLocation name;
    private final /* synthetic */ boolean streaming;
    private final /* synthetic */ int weight;
    private final /* synthetic */ float pitch;
    private final /* synthetic */ Type type;
    private final /* synthetic */ float volume;
    
    public boolean isStreaming() {
        return this.streaming;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    @Override
    public Sound cloneEntry() {
        return this;
    }
    
    public ResourceLocation getSoundAsOggLocation() {
        return new ResourceLocation(this.name.getResourceDomain(), "sounds/" + this.name.getResourcePath() + ".ogg");
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
    
    public ResourceLocation getSoundLocation() {
        return this.name;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    public Sound(final String llllllllllllIlllllIIlIIlIlllIlll, final float llllllllllllIlllllIIlIIlIlllllIl, final float llllllllllllIlllllIIlIIlIlllllII, final int llllllllllllIlllllIIlIIlIlllIlII, final Type llllllllllllIlllllIIlIIlIlllIIll, final boolean llllllllllllIlllllIIlIIlIllllIIl) {
        this.name = new ResourceLocation(llllllllllllIlllllIIlIIlIlllIlll);
        this.volume = llllllllllllIlllllIIlIIlIlllllIl;
        this.pitch = llllllllllllIlllllIIlIIlIlllllII;
        this.weight = llllllllllllIlllllIIlIIlIlllIlII;
        this.type = llllllllllllIlllllIIlIIlIlllIIll;
        this.streaming = llllllllllllIlllllIIlIIlIllllIIl;
    }
    
    public enum Type
    {
        SOUND_EVENT("SOUND_EVENT", 1, "event"), 
        FILE("FILE", 0, "file");
        
        private final /* synthetic */ String name;
        
        private Type(final String llllllllllIllllIIIllIlllIlIlllll, final int llllllllllIllllIIIllIlllIlIllllI, final String llllllllllIllllIIIllIlllIllIIIIl) {
            this.name = llllllllllIllllIIIllIlllIllIIIIl;
        }
        
        public static Type getByName(final String llllllllllIllllIIIllIlllIlIlIlll) {
            final boolean llllllllllIllllIIIllIlllIlIlIIIl;
            final boolean llllllllllIllllIIIllIlllIlIlIIlI = ((Type[])(Object)(llllllllllIllllIIIllIlllIlIlIIIl = (boolean)(Object)values())).length != 0;
            for (byte llllllllllIllllIIIllIlllIlIlIIll = 0; llllllllllIllllIIIllIlllIlIlIIll < (llllllllllIllllIIIllIlllIlIlIIlI ? 1 : 0); ++llllllllllIllllIIIllIlllIlIlIIll) {
                final Type llllllllllIllllIIIllIlllIlIlIllI = llllllllllIllllIIIllIlllIlIlIIIl[llllllllllIllllIIIllIlllIlIlIIll];
                if (llllllllllIllllIIIllIlllIlIlIllI.name.equals(llllllllllIllllIIIllIlllIlIlIlll)) {
                    return llllllllllIllllIIIllIlllIlIlIllI;
                }
            }
            return null;
        }
    }
}
