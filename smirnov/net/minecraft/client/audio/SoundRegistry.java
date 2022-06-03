// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistrySimple;

public class SoundRegistry extends RegistrySimple<ResourceLocation, SoundEventAccessor>
{
    private /* synthetic */ Map<ResourceLocation, SoundEventAccessor> soundRegistry;
    
    public void clearMap() {
        this.soundRegistry.clear();
    }
    
    @Override
    protected Map<ResourceLocation, SoundEventAccessor> createUnderlyingMap() {
        this.soundRegistry = (Map<ResourceLocation, SoundEventAccessor>)Maps.newHashMap();
        return this.soundRegistry;
    }
    
    public void add(final SoundEventAccessor llllllllllllllIIlllIIIlIlIIlIllI) {
        this.putObject(llllllllllllllIIlllIIIlIlIIlIllI.getLocation(), llllllllllllllIIlllIIIlIlIIlIllI);
    }
}
