// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class Weather extends Feature
{
    public static /* synthetic */ ColorSetting weatherColor;
    
    public Weather() {
        super("Weather", "\u0414\u043e\u0431\u0430\u0432\u043b\u044f\u0435\u0442 \u0447\u0430\u0441\u0442\u0438\u0447\u043a\u0438 \u0441\u043d\u0435\u0433\u0430 \u0432 \u043c\u0438\u0440", 0, Category.VISUALS);
        Weather.weatherColor = new ColorSetting("Weather", new Color(16777215).getRGB(), () -> true);
        this.addSettings(Weather.weatherColor);
    }
}
