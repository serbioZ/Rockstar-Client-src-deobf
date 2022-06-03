// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class PositionedSoundRecord extends PositionedSound
{
    public static PositionedSoundRecord getMasterRecord(final SoundEvent llllllllllllIIIIIIlIIIIlIlllIIll, final float llllllllllllIIIIIIlIIIIlIlllIIlI) {
        return func_194007_a(llllllllllllIIIIIIlIIIIlIlllIIll, llllllllllllIIIIIIlIIIIlIlllIIlI, 0.25f);
    }
    
    public static PositionedSoundRecord func_194007_a(final SoundEvent llllllllllllIIIIIIlIIIIlIllIlIIl, final float llllllllllllIIIIIIlIIIIlIllIlIll, final float llllllllllllIIIIIIlIIIIlIllIlIlI) {
        return new PositionedSoundRecord(llllllllllllIIIIIIlIIIIlIllIlIIl, SoundCategory.MASTER, llllllllllllIIIIIIlIIIIlIllIlIlI, llllllllllllIIIIIIlIIIIlIllIlIll, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
    
    public static PositionedSoundRecord getRecordSoundRecord(final SoundEvent llllllllllllIIIIIIlIIIIlIlIllIll, final float llllllllllllIIIIIIlIIIIlIlIllIlI, final float llllllllllllIIIIIIlIIIIlIlIllIIl, final float llllllllllllIIIIIIlIIIIlIlIlllII) {
        return new PositionedSoundRecord(llllllllllllIIIIIIlIIIIlIlIllIll, SoundCategory.RECORDS, 4.0f, 1.0f, false, 0, ISound.AttenuationType.LINEAR, llllllllllllIIIIIIlIIIIlIlIllIlI, llllllllllllIIIIIIlIIIIlIlIllIIl, llllllllllllIIIIIIlIIIIlIlIlllII);
    }
    
    public PositionedSoundRecord(final ResourceLocation llllllllllllIIIIIIlIIIIlIIIlIIlI, final SoundCategory llllllllllllIIIIIIlIIIIlIIIlIIIl, final float llllllllllllIIIIIIlIIIIlIIIlIIII, final float llllllllllllIIIIIIlIIIIlIIIIIlII, final boolean llllllllllllIIIIIIlIIIIlIIIIlllI, final int llllllllllllIIIIIIlIIIIlIIIIIIlI, final ISound.AttenuationType llllllllllllIIIIIIlIIIIlIIIIllII, final float llllllllllllIIIIIIlIIIIlIIIIlIll, final float llllllllllllIIIIIIlIIIIIllllllll, final float llllllllllllIIIIIIlIIIIIlllllllI) {
        super(llllllllllllIIIIIIlIIIIlIIIlIIlI, llllllllllllIIIIIIlIIIIlIIIlIIIl);
        this.volume = llllllllllllIIIIIIlIIIIlIIIlIIII;
        this.pitch = llllllllllllIIIIIIlIIIIlIIIIIlII;
        this.xPosF = llllllllllllIIIIIIlIIIIlIIIIlIll;
        this.yPosF = llllllllllllIIIIIIlIIIIIllllllll;
        this.zPosF = llllllllllllIIIIIIlIIIIIlllllllI;
        this.repeat = llllllllllllIIIIIIlIIIIlIIIIlllI;
        this.repeatDelay = llllllllllllIIIIIIlIIIIlIIIIIIlI;
        this.attenuationType = llllllllllllIIIIIIlIIIIlIIIIllII;
    }
    
    public PositionedSoundRecord(final SoundEvent llllllllllllIIIIIIlIIIIllIIIIIII, final SoundCategory llllllllllllIIIIIIlIIIIlIllllIIl, final float llllllllllllIIIIIIlIIIIlIllllllI, final float llllllllllllIIIIIIlIIIIlIlllllIl, final BlockPos llllllllllllIIIIIIlIIIIlIlllIllI) {
        this(llllllllllllIIIIIIlIIIIllIIIIIII, llllllllllllIIIIIIlIIIIlIllllIIl, llllllllllllIIIIIIlIIIIlIllllllI, llllllllllllIIIIIIlIIIIlIlllllIl, llllllllllllIIIIIIlIIIIlIlllIllI.getX() + 0.5f, llllllllllllIIIIIIlIIIIlIlllIllI.getY() + 0.5f, llllllllllllIIIIIIlIIIIlIlllIllI.getZ() + 0.5f);
    }
    
    public PositionedSoundRecord(final SoundEvent llllllllllllIIIIIIlIIIIlIlIIlllI, final SoundCategory llllllllllllIIIIIIlIIIIlIlIIIlIl, final float llllllllllllIIIIIIlIIIIlIlIIIlII, final float llllllllllllIIIIIIlIIIIlIlIIlIll, final float llllllllllllIIIIIIlIIIIlIlIIlIlI, final float llllllllllllIIIIIIlIIIIlIlIIlIIl, final float llllllllllllIIIIIIlIIIIlIlIIlIII) {
        this(llllllllllllIIIIIIlIIIIlIlIIlllI, llllllllllllIIIIIIlIIIIlIlIIIlIl, llllllllllllIIIIIIlIIIIlIlIIIlII, llllllllllllIIIIIIlIIIIlIlIIlIll, false, 0, ISound.AttenuationType.LINEAR, llllllllllllIIIIIIlIIIIlIlIIlIlI, llllllllllllIIIIIIlIIIIlIlIIlIIl, llllllllllllIIIIIIlIIIIlIlIIlIII);
    }
    
    private PositionedSoundRecord(final SoundEvent llllllllllllIIIIIIlIIIIlIIlIlIII, final SoundCategory llllllllllllIIIIIIlIIIIlIIlIIlll, final float llllllllllllIIIIIIlIIIIlIIlIIllI, final float llllllllllllIIIIIIlIIIIlIIllIIII, final boolean llllllllllllIIIIIIlIIIIlIIlIIlII, final int llllllllllllIIIIIIlIIIIlIIlIIIll, final ISound.AttenuationType llllllllllllIIIIIIlIIIIlIIlIIIlI, final float llllllllllllIIIIIIlIIIIlIIlIllII, final float llllllllllllIIIIIIlIIIIlIIlIIIII, final float llllllllllllIIIIIIlIIIIlIIIlllll) {
        this(llllllllllllIIIIIIlIIIIlIIlIlIII.getSoundName(), llllllllllllIIIIIIlIIIIlIIlIIlll, llllllllllllIIIIIIlIIIIlIIlIIllI, llllllllllllIIIIIIlIIIIlIIllIIII, llllllllllllIIIIIIlIIIIlIIlIIlII, llllllllllllIIIIIIlIIIIlIIlIIIll, llllllllllllIIIIIIlIIIIlIIlIIIlI, llllllllllllIIIIIIlIIIIlIIlIllII, llllllllllllIIIIIIlIIIIlIIlIIIII, llllllllllllIIIIIIlIIIIlIIIlllll);
    }
    
    public static PositionedSoundRecord getMusicRecord(final SoundEvent llllllllllllIIIIIIlIIIIlIllIIlII) {
        return new PositionedSoundRecord(llllllllllllIIIIIIlIIIIlIllIIlII, SoundCategory.MUSIC, 1.0f, 1.0f, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
}
