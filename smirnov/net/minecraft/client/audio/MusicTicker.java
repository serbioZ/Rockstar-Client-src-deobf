// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ITickable;

public class MusicTicker implements ITickable
{
    private /* synthetic */ ISound currentMusic;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ int timeUntilNextMusic;
    private final /* synthetic */ Random rand;
    
    @Override
    public void update() {
        final MusicType llllllllllIlllIllIlIlIIlIlIIIIlI = this.mc.getAmbientMusicType();
        if (this.currentMusic != null) {
            if (!llllllllllIlllIllIlIlIIlIlIIIIlI.getMusicLocation().getSoundName().equals(this.currentMusic.getSoundLocation())) {
                this.mc.getSoundHandler().stopSound(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.getInt(this.rand, 0, llllllllllIlllIllIlIlIIlIlIIIIlI.getMinDelay() / 2);
            }
            if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, llllllllllIlllIllIlIlIIlIlIIIIlI.getMinDelay(), llllllllllIlllIllIlIlIIlIlIIIIlI.getMaxDelay()), this.timeUntilNextMusic);
            }
        }
        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, llllllllllIlllIllIlIlIIlIlIIIIlI.getMaxDelay());
        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
            this.playMusic(llllllllllIlllIllIlIlIIlIlIIIIlI);
        }
    }
    
    public void playMusic(final MusicType llllllllllIlllIllIlIlIIlIIlllIlI) {
        this.currentMusic = PositionedSoundRecord.getMusicRecord(llllllllllIlllIllIlIlIIlIIlllIlI.getMusicLocation());
        this.mc.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = Integer.MAX_VALUE;
    }
    
    public MusicTicker(final Minecraft llllllllllIlllIllIlIlIIlIlIIIllI) {
        this.rand = new Random();
        this.timeUntilNextMusic = 100;
        this.mc = llllllllllIlllIllIlIlIIlIlIIIllI;
    }
    
    public enum MusicType
    {
        private final /* synthetic */ int maxDelay;
        
        NETHER("NETHER", 4, SoundEvents.MUSIC_NETHER, 1200, 3600), 
        GAME("GAME", 1, SoundEvents.MUSIC_GAME, 12000, 24000), 
        END_BOSS("END_BOSS", 5, SoundEvents.MUSIC_DRAGON, 0, 0);
        
        private final /* synthetic */ int minDelay;
        
        CREDITS("CREDITS", 3, SoundEvents.MUSIC_CREDITS, 0, 0), 
        CREATIVE("CREATIVE", 2, SoundEvents.MUSIC_CREATIVE, 1200, 3600), 
        MENU("MENU", 0, SoundEvents.MUSIC_MENU, 20, 600);
        
        private final /* synthetic */ SoundEvent musicLocation;
        
        END("END", 6, SoundEvents.MUSIC_END, 6000, 24000);
        
        public int getMaxDelay() {
            return this.maxDelay;
        }
        
        public int getMinDelay() {
            return this.minDelay;
        }
        
        public SoundEvent getMusicLocation() {
            return this.musicLocation;
        }
        
        private MusicType(final String lllllllllllIIIlIlIIIlIlIlIIllIlI, final int lllllllllllIIIlIlIIIlIlIlIIllIIl, final SoundEvent lllllllllllIIIlIlIIIlIlIlIIllIII, final int lllllllllllIIIlIlIIIlIlIlIIlIlll, final int lllllllllllIIIlIlIIIlIlIlIIlllII) {
            this.musicLocation = lllllllllllIIIlIlIIIlIlIlIIllIII;
            this.minDelay = lllllllllllIIIlIlIIIlIlIlIIlIlll;
            this.maxDelay = lllllllllllIIIlIlIIIlIlIlIIlllII;
        }
    }
}
