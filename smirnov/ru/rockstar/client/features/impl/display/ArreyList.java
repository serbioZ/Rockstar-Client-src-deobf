// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import java.awt.Color;
import ru.rockstar.api.event.event.EventRender2D;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class ArreyList extends Feature
{
    public static /* synthetic */ BooleanSetting shadow;
    public static /* synthetic */ ListSetting borderMode;
    public static /* synthetic */ NumberSetting height;
    public static /* synthetic */ BooleanSetting rectRight;
    public static /* synthetic */ NumberSetting y;
    public static /* synthetic */ ColorSetting twocolor;
    public static /* synthetic */ NumberSetting fonty;
    public static /* synthetic */ ListSetting arrayColor;
    public static /* synthetic */ BooleanSetting border;
    public static /* synthetic */ NumberSetting backGroundAlpha;
    public static /* synthetic */ BooleanSetting backGround;
    public static /* synthetic */ ColorSetting onecolor;
    public static /* synthetic */ ColorSetting shadowcolor;
    public static /* synthetic */ NumberSetting time;
    public static /* synthetic */ NumberSetting x;
    public static /* synthetic */ ColorSetting backGroundColor;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIlllIIIlIIlllIlllllI) {
        final String lllllllllllIIlllIIIlIIlllIllllIl = ArreyList.arrayColor.getOptions();
        this.setModuleName("ArrayList §7" + lllllllllllIIlllIIIlIIlllIllllIl);
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllIIlllIIIlIIlllIllIlll) {
        final HUD lllllllllllIIlllIIIlIIlllIllIllI = new HUD();
        lllllllllllIIlllIIIlIIlllIllIllI.renderArrayList(lllllllllllIIlllIIIlIIlllIllIlll.getResolution());
    }
    
    static {
        ArreyList.onecolor = new ColorSetting("One Color", new Color(16777215).getRGB(), () -> ArreyList.arrayColor.currentMode.equals("Custom"));
        ArreyList.twocolor = new ColorSetting("Two Color", new Color(16711680).getRGB(), () -> ArreyList.arrayColor.currentMode.equals("Custom"));
    }
    
    public ArreyList() {
        super("ArrayList", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0441\u043f\u0438\u0441\u043e\u043a \u0432\u0441\u0435\u0445 \u0432\u043a\u043b\u044e\u0447\u0435\u043d\u043d\u044b\u0445 \u043c\u043e\u0434\u0443\u043b\u0435\u0439", 0, Category.DISPLAY);
        ArreyList.arrayColor = new ListSetting("ArrayList Color", "Custom", () -> true, new String[] { "Custom", "Rainbow", "Pulse", "Astolfo", "None" });
        ArreyList.backGround = new BooleanSetting("Background", true, () -> true);
        ArreyList.backGroundColor = new ColorSetting("Background Color", new Color(0).getRGB(), () -> ArreyList.backGround.getBoolValue());
        ArreyList.backGroundAlpha = new NumberSetting("Background Alpha", 255.0f, 1.0f, 255.0f, 1.0f, () -> true);
        ArreyList.border = new BooleanSetting("Border", false, () -> true);
        ArreyList.rectRight = new BooleanSetting("RectRight", true, () -> true);
        ArreyList.shadow = new BooleanSetting("Shadow", false, () -> true);
        ArreyList.shadowcolor = new ColorSetting("Shadow Color", new Color(0).getRGB(), () -> ArreyList.shadow.getBoolValue());
        ArreyList.time = new NumberSetting("Color Time", 10.0f, 1.0f, 100.0f, 1.0f, () -> true);
        ArreyList.x = new NumberSetting("ArrayList X", 0.0f, 0.0f, 500.0f, 1.0f, () -> true);
        ArreyList.y = new NumberSetting("ArrayList Y", 0.0f, 0.0f, 500.0f, 1.0f, () -> true);
        ArreyList.fonty = new NumberSetting("Font Y", 1.0f, 0.0f, 10.0f, 1.0f, () -> true);
        ArreyList.borderMode = new ListSetting("Border Mode", "Single", () -> true, new String[] { "All", "Single" });
        ArreyList.height = new NumberSetting("Font Height", "\u0420\u0430\u0437\u043c\u0435\u0440 \u0430\u0440\u0440\u0430\u0439-\u043b\u0438\u0441\u0442\u0430", 10.0f, 7.0f, 20.0f, 1.0f, () -> true);
        this.addSettings(ArreyList.arrayColor, ArreyList.onecolor, ArreyList.twocolor, ArreyList.backGround, ArreyList.backGroundColor, ArreyList.backGroundAlpha, ArreyList.border, ArreyList.borderMode, ArreyList.rectRight, ArreyList.shadow, ArreyList.shadowcolor, ArreyList.time, ArreyList.x, ArreyList.y, ArreyList.height, ArreyList.fonty);
    }
}
