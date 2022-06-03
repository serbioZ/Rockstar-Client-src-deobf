// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class ClientFont extends Feature
{
    public static /* synthetic */ ListSetting fontMode;
    public static /* synthetic */ BooleanSetting minecraftfont;
    
    public ClientFont() {
        super("Font", "\u041c\u0435\u043d\u044f\u0435\u0442 \u0448\u0440\u0438\u0444\u0442 \u0432\u043e \u0432\u0441\u0451\u043c \u043a\u043b\u0438\u0435\u043d\u0442\u0435", 0, Category.DISPLAY);
        ClientFont.fontMode = new ListSetting("FontList", "URWGeometric", () -> !ClientFont.minecraftfont.getBoolValue(), new String[] { "URWGeometric", "Myseo", "SFUI", "Lato", "Roboto Regular", "WexSide", "NeverLose", "Comic Sans" });
        ClientFont.minecraftfont = new BooleanSetting("Minecraft Font", false, () -> true);
        this.addSettings(ClientFont.fontMode, ClientFont.minecraftfont);
    }
    
    @Override
    public void onEnable() {
        this.toggle();
        super.onEnable();
    }
}
