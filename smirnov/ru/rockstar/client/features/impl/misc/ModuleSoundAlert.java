// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class ModuleSoundAlert extends Feature
{
    public static /* synthetic */ ListSetting soundMode;
    
    public ModuleSoundAlert() {
        super("ModuleSoundAlert", "\u0417\u0432\u0443\u043a\u0438 \u043f\u0440\u0438 \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0438 \u0444\u0443\u043d\u043a\u0446\u0438\u0438 \u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0438", 0, Category.MISC);
        ModuleSoundAlert.soundMode = new ListSetting("Sound Mode", "Minecraft", () -> true, new String[] { "Minecraft", "Cosmo", "Default" });
        this.addSettings(ModuleSoundAlert.soundMode);
    }
}
