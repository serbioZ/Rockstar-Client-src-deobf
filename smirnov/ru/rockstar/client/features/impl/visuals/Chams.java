// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class Chams extends Feature
{
    public static /* synthetic */ ColorSetting colorChams;
    public static /* synthetic */ ListSetting chamsMode;
    public static /* synthetic */ BooleanSetting clientColor;
    
    public Chams() {
        super("Chams", "\u041f\u043e\u0434\u0441\u0432\u0435\u0447\u0438\u0432\u0430\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u043e\u0432", 0, Category.VISUALS);
        Chams.chamsMode = new ListSetting("Chams Mode", "Fill", () -> true, new String[] { "Fill", "Walls" });
        Chams.clientColor = new BooleanSetting("Client Colored", false, () -> !Chams.chamsMode.currentMode.equals("Walls"));
        Chams.colorChams = new ColorSetting("Chams Color", new Color(16777215).getRGB(), () -> !Chams.chamsMode.currentMode.equals("Walls") && !Chams.clientColor.getBoolValue());
        this.addSettings(Chams.chamsMode, Chams.colorChams, Chams.clientColor);
    }
}
