// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.other;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import ru.rockstar.Main;
import javax.sound.sampled.AudioSystem;

public class SoundHelper
{
    public static void playSound(final String lllllllllllIlIIIllIlllllIlIIIIIl) {
        Clip lllllllllllIlIIIllIlllllIIllllIl;
        AudioInputStream lllllllllllIlIIIllIlllllIIllllII;
        new Thread(() -> {
            try {
                lllllllllllIlIIIllIlllllIIllllIl = AudioSystem.getClip();
                lllllllllllIlIIIllIlllllIIllllII = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/assets/minecraft/rockstar/songs/" + lllllllllllIlIIIllIlllllIlIIIIIl));
                lllllllllllIlIIIllIlllllIIllllIl.open(lllllllllllIlIIIllIlllllIIllllII);
                lllllllllllIlIIIllIlllllIIllllIl.start();
            }
            catch (Exception ex) {}
        }).start();
    }
}
