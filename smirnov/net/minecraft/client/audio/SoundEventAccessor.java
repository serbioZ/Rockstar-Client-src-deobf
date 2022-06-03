// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.text.TextComponentTranslation;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.util.Random;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;

public class SoundEventAccessor implements ISoundEventAccessor<Sound>
{
    private final /* synthetic */ ResourceLocation location;
    private final /* synthetic */ ITextComponent subtitle;
    private final /* synthetic */ List<ISoundEventAccessor<Sound>> accessorList;
    private final /* synthetic */ Random rnd;
    
    public ResourceLocation getLocation() {
        return this.location;
    }
    
    @Override
    public Sound cloneEntry() {
        final int llllllllllllIIlIllllIlIIIllIllll = this.getWeight();
        if (!this.accessorList.isEmpty() && llllllllllllIIlIllllIlIIIllIllll != 0) {
            int llllllllllllIIlIllllIlIIIllIlllI = this.rnd.nextInt(llllllllllllIIlIllllIlIIIllIllll);
            for (final ISoundEventAccessor<Sound> llllllllllllIIlIllllIlIIIllIllIl : this.accessorList) {
                llllllllllllIIlIllllIlIIIllIlllI -= llllllllllllIIlIllllIlIIIllIllIl.getWeight();
                if (llllllllllllIIlIllllIlIIIllIlllI < 0) {
                    return llllllllllllIIlIllllIlIIIllIllIl.cloneEntry();
                }
            }
            return SoundHandler.MISSING_SOUND;
        }
        return SoundHandler.MISSING_SOUND;
    }
    
    public void addSound(final ISoundEventAccessor<Sound> llllllllllllIIlIllllIlIIIllIIIlI) {
        this.accessorList.add(llllllllllllIIlIllllIlIIIllIIIlI);
    }
    
    @Nullable
    public ITextComponent getSubtitle() {
        return this.subtitle;
    }
    
    public SoundEventAccessor(final ResourceLocation llllllllllllIIlIllllIlIIlIIIIIlI, @Nullable final String llllllllllllIIlIllllIlIIlIIIIIIl) {
        this.accessorList = (List<ISoundEventAccessor<Sound>>)Lists.newArrayList();
        this.rnd = new Random();
        this.location = llllllllllllIIlIllllIlIIlIIIIIlI;
        this.subtitle = ((llllllllllllIIlIllllIlIIlIIIIIIl == null) ? null : new TextComponentTranslation(llllllllllllIIlIllllIlIIlIIIIIIl, new Object[0]));
    }
    
    @Override
    public int getWeight() {
        int llllllllllllIIlIllllIlIIIllllIll = 0;
        for (final ISoundEventAccessor<Sound> llllllllllllIIlIllllIlIIIllllIlI : this.accessorList) {
            llllllllllllIIlIllllIlIIIllllIll += llllllllllllIIlIllllIlIIIllllIlI.getWeight();
        }
        return llllllllllllIIlIllllIlIIIllllIll;
    }
}
