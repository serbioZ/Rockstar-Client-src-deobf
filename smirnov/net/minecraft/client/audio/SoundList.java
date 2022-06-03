// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import javax.annotation.Nullable;
import java.util.List;

public class SoundList
{
    private final /* synthetic */ boolean replaceExisting;
    private final /* synthetic */ List<Sound> sounds;
    private final /* synthetic */ String subtitle;
    
    public boolean canReplaceExisting() {
        return this.replaceExisting;
    }
    
    public SoundList(final List<Sound> llllllllllIlllIlIlIllllIIIIIllll, final boolean llllllllllIlllIlIlIllllIIIIIlIlI, final String llllllllllIlllIlIlIllllIIIIIllIl) {
        this.sounds = llllllllllIlllIlIlIllllIIIIIllll;
        this.replaceExisting = llllllllllIlllIlIlIllllIIIIIlIlI;
        this.subtitle = llllllllllIlllIlIlIllllIIIIIllIl;
    }
    
    @Nullable
    public String getSubtitle() {
        return this.subtitle;
    }
    
    public List<Sound> getSounds() {
        return this.sounds;
    }
}
