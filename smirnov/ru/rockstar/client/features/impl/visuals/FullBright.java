// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.potion.PotionEffect;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.potion.Potion;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class FullBright extends Feature
{
    public static /* synthetic */ ListSetting brightMode;
    
    @Override
    public void onDisable() {
        super.onDisable();
        FullBright.mc.gameSettings.gammaSetting = 1.0f;
        FullBright.mc.player.removePotionEffect(Potion.getPotionById(16));
    }
    
    public FullBright() {
        super("FullBright", "\u0423\u0431\u0438\u0440\u0430\u0435\u0442 \u0442\u0435\u043c\u043d\u043e\u0442\u0443 \u0432 \u0438\u0433\u0440\u0435", 0, Category.VISUALS);
        FullBright.brightMode = new ListSetting("FullBright Mode", "Gamma", () -> true, new String[] { "Gamma", "Potion" });
        this.addSettings(FullBright.brightMode);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIllllIllIIIIlllIIlIl) {
        if (this.isToggled()) {
            final String llllllllllllIllllIllIIIIlllIIlII = FullBright.brightMode.getOptions();
            if (llllllllllllIllllIllIIIIlllIIlII.equalsIgnoreCase("Gamma")) {
                FullBright.mc.gameSettings.gammaSetting = 1000.0f;
            }
            if (llllllllllllIllllIllIIIIlllIIlII.equalsIgnoreCase("Potion")) {
                FullBright.mc.player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 817, 1));
            }
            else {
                FullBright.mc.player.removePotionEffect(Potion.getPotionById(16));
            }
        }
    }
}
