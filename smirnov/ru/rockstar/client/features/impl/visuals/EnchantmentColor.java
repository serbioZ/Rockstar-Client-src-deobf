// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class EnchantmentColor extends Feature
{
    public static /* synthetic */ ColorSetting customColor;
    public static /* synthetic */ ListSetting colorMode;
    
    public EnchantmentColor() {
        super("EnchantmentColor", "\u0418\u0437\u043c\u0435\u043d\u044f\u0435\u0442 \u0446\u0432\u0435\u0442 \u0437\u0430\u0447\u0430\u0440\u043e\u0432\u0430\u043d\u0438\u0439", 0, Category.VISUALS);
        EnchantmentColor.colorMode = new ListSetting("Crumbs Color", "Rainbow", () -> true, new String[] { "Rainbow", "Client", "Custom" });
        EnchantmentColor.customColor = new ColorSetting("Custom Enchantment", new Color(16777215).getRGB(), () -> EnchantmentColor.colorMode.currentMode.equals("Custom"));
        this.addSettings(EnchantmentColor.colorMode, EnchantmentColor.customColor);
    }
}
