// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.other.SoundHelper;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.event.event.EventAttackSilent;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class HitSounds extends Feature
{
    public static /* synthetic */ ListSetting soundMode;
    
    @EventTarget
    public void onAttackSilent(final EventAttackSilent lllllllllllllIllllIlIIIIlIIlllll) {
        if (lllllllllllllIllllIlIIIIlIIlllll.getTargetEntity() instanceof EntityPlayer) {
            final String lllllllllllllIllllIlIIIIlIlIIIII = HitSounds.soundMode.getOptions();
            if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Neverlose")) {
                SoundHelper.playSound("neverlose.wav");
            }
            else if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Metallic")) {
                SoundHelper.playSound("metallic.wav");
            }
            else if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Skeet")) {
                SoundHelper.playSound("skeet.wav");
            }
            else if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Tyan")) {
                SoundHelper.playSound("tyan.wav");
            }
            else if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Punch")) {
                SoundHelper.playSound("punch.wav");
            }
            else if (lllllllllllllIllllIlIIIIlIlIIIII.equalsIgnoreCase("Fee")) {
                SoundHelper.playSound("fee.wav");
            }
        }
    }
    
    public HitSounds() {
        super("HitSounds", "\u0418\u0437\u0434\u0430\u0451\u0442 \u0437\u0432\u0443\u043a \u043f\u0440\u0438 \u0443\u0434\u0430\u0440\u0435 ", 0, Category.MISC);
        HitSounds.soundMode = new ListSetting("Sound Mode", "Neverlose", () -> true, new String[] { "Neverlose", "Metallic", "Skeet", "Tyan", "Punch", "Fee" });
        this.addSettings(HitSounds.soundMode);
    }
}
