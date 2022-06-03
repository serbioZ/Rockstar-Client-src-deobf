// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import java.awt.Color;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class NightMode extends Feature
{
    public static /* synthetic */ ColorSetting worldColor;
    
    static {
        NightMode.worldColor = new ColorSetting("World Color", Color.RED.getRGB(), () -> true);
    }
    
    public NightMode() {
        super("NightMode", "\u041c\u0435\u043d\u044f\u0435\u0442 \u0446\u0432\u0435\u0442 \u043c\u0438\u0440\u0430", 0, Category.VISUALS);
        this.addSettings(NightMode.worldColor);
    }
}
