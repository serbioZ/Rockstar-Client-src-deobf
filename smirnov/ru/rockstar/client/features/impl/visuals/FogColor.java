// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import java.awt.Color;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.api.event.event.EventFogColor;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class FogColor extends Feature
{
    public /* synthetic */ ColorSetting customColor;
    public /* synthetic */ ListSetting colorMode;
    public static /* synthetic */ NumberSetting distance;
    
    @EventTarget
    public void onFogColor(final EventFogColor lllllllllllllllIIllIlllllIllIlll) {
        final String lllllllllllllllIIllIlllllIllllII = this.colorMode.getOptions();
        if (lllllllllllllllIIllIlllllIllllII.equalsIgnoreCase("Rainbow")) {
            final Color lllllllllllllllIIllIlllllIlllIll = DrawHelper.rainbow(1, 1.0f, 1.0f);
            lllllllllllllllIIllIlllllIllIlll.setRed((float)lllllllllllllllIIllIlllllIlllIll.getRed());
            lllllllllllllllIIllIlllllIllIlll.setGreen((float)lllllllllllllllIIllIlllllIlllIll.getGreen());
            lllllllllllllllIIllIlllllIllIlll.setBlue((float)lllllllllllllllIIllIlllllIlllIll.getBlue());
        }
        else if (lllllllllllllllIIllIlllllIllllII.equalsIgnoreCase("Client")) {
            final Color lllllllllllllllIIllIlllllIlllIlI = ClientHelper.getClientColor();
            lllllllllllllllIIllIlllllIllIlll.setRed((float)lllllllllllllllIIllIlllllIlllIlI.getRed());
            lllllllllllllllIIllIlllllIllIlll.setGreen((float)lllllllllllllllIIllIlllllIlllIlI.getGreen());
            lllllllllllllllIIllIlllllIllIlll.setBlue((float)lllllllllllllllIIllIlllllIlllIlI.getBlue());
        }
        else if (lllllllllllllllIIllIlllllIllllII.equalsIgnoreCase("Custom")) {
            final Color lllllllllllllllIIllIlllllIlllIIl = new Color(this.customColor.getColorValue());
            lllllllllllllllIIllIlllllIllIlll.setRed((float)lllllllllllllllIIllIlllllIlllIIl.getRed());
            lllllllllllllllIIllIlllllIllIlll.setGreen((float)lllllllllllllllIIllIlllllIlllIIl.getGreen());
            lllllllllllllllIIllIlllllIllIlll.setBlue((float)lllllllllllllllIIllIlllllIlllIIl.getBlue());
        }
    }
    
    public FogColor() {
        super("FogColor", "\u041c\u0435\u043d\u044f\u0435\u0442 \u0446\u0432\u0435\u0442 \u0442\u0443\u043c\u0430\u043d\u0430", 0, Category.VISUALS);
        this.colorMode = new ListSetting("Fog Color", "Rainbow", () -> true, new String[] { "Rainbow", "Client", "Custom" });
        FogColor.distance = new NumberSetting("Distance", 0.1f, 0.001f, 2.0f, 0.01f, () -> true);
        this.customColor = new ColorSetting("Custom Fog", new Color(11219403).getRGB(), () -> this.colorMode.currentMode.equals("Custom"));
        this.addSettings(this.colorMode, FogColor.distance, this.customColor);
    }
}
