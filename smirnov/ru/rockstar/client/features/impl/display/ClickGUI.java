// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import net.minecraft.client.gui.GuiScreen;
import ru.rockstar.Main;
import ru.rockstar.client.ui.settings.Setting;
import net.minecraft.client.gui.ScaledResolution;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class ClickGUI extends Feature
{
    public static /* synthetic */ NumberSetting speed;
    public static /* synthetic */ ListSetting style;
    public /* synthetic */ ListSetting mode;
    public static /* synthetic */ ColorSetting color;
    public static /* synthetic */ NumberSetting imagex;
    public static /* synthetic */ ListSetting clickGuiColor;
    public static /* synthetic */ ColorSetting colorTwo;
    public static /* synthetic */ ListSetting imagemode;
    public static /* synthetic */ BooleanSetting glow;
    public static /* synthetic */ NumberSetting fontY;
    public static /* synthetic */ BooleanSetting image;
    public static /* synthetic */ NumberSetting imagey;
    public static /* synthetic */ ListSetting backGroundMode;
    public static /* synthetic */ BooleanSetting blur;
    public static /* synthetic */ BooleanSetting background;
    
    public ClickGUI() {
        super("ClickGUI", "Cheat menu.", 54, Category.DISPLAY);
        this.mode = new ListSetting("ClickGui Mode", "Default", () -> true, new String[] { "Small", "Default" });
        this.setKey(54);
        ClickGUI.color = new ColorSetting("Color One", new Color(255, 255, 255, 120).getRGB(), () -> ClickGUI.clickGuiColor.currentMode.equals("Fade") || ClickGUI.clickGuiColor.currentMode.equals("Color Two") || ClickGUI.clickGuiColor.currentMode.equals("Static"));
        ClickGUI.colorTwo = new ColorSetting("Color Two", new Color(154, 154, 154, 120).getRGB(), () -> ClickGUI.clickGuiColor.currentMode.equals("Color Two"));
        ClickGUI.background = new BooleanSetting("Background", false, () -> true);
        ClickGUI.imagemode = new ListSetting("Image Mode", "DeadInside", () -> ClickGUI.image.getBoolValue(), new String[] { "DeadInside", "DeadInside2", "DeadInside3", "DeadInside4", "DeadInside5", "DeadInside6", "DeadInside7", "DeadInside8", "Allax", "Cat", "Floppa", "Floppa2", "Selli324", "Minecraft", "Putin", "Slava Bebrow", "Simple", "Tyan", "Tyan2", "Tyan3", "Tyan4", "Tyan5", "Tyan6", "Tyan7", "Tyan8", "Tyan9", "Tyan10", "Tyan11", "Tyan12", "Tyan13", "Tyan14", "Tyan15", "Tyan16", "Tyan17", "Tyan18", "Tyan19", "Tyan20", "Tyan21", "Tyan22", "Tyan23", "Tyan24", "Brawl", "Brawl2", "Brawl3", "Brawl4", "Brawl5" });
        ClickGUI.backGroundMode = new ListSetting("Background Mode", "Bottom", () -> ClickGUI.background.getBoolValue(), new String[] { "Bottom", "Top", "Everywhere" });
        ClickGUI.fontY = new NumberSetting("FontY", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043c\u0435\u043d\u044f\u0442\u044c \u0432\u0430\u043c \u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0448\u0440\u0438\u0444\u0442\u0430", 0.0f, 0.0f, 5.0f, 1.0f, () -> true);
        final ScaledResolution llllllllllllIlllllIlIIllIlIlllII = new ScaledResolution(ClickGUI.mc);
        ClickGUI.style = new ListSetting("Style", "Rockstar", () -> true, new String[] { "Rockstar", "Default Dark", "Default Light", "NeverLose", "Clear", "Dark" });
        ClickGUI.imagex = new NumberSetting("Image X", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043c\u0435\u043d\u044f\u0442\u044c \u0432\u0430\u043c \u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438", 0.0f, 0.0f, 1000.0f, 10.0f, () -> ClickGUI.image.getBoolValue());
        ClickGUI.imagey = new NumberSetting("Image Y", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043c\u0435\u043d\u044f\u0442\u044c \u0432\u0430\u043c \u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u043a\u0430\u0440\u0442\u0438\u043d\u043a\u0438", 0.0f, 0.0f, 1000.0f, 10.0f, () -> ClickGUI.image.getBoolValue());
        this.addSettings(this.mode, ClickGUI.style, ClickGUI.clickGuiColor, ClickGUI.color, ClickGUI.colorTwo, ClickGUI.image, ClickGUI.imagemode, ClickGUI.imagex, ClickGUI.imagey, ClickGUI.speed, ClickGUI.background, ClickGUI.backGroundMode, ClickGUI.blur, ClickGUI.glow, ClickGUI.fontY);
    }
    
    @Override
    public void onEnable() {
        if (this.mode.currentMode.equals("Default")) {
            ClickGUI.mc.displayGuiScreen(Main.instance.clickGui);
        }
        else if (this.mode.currentMode.equals("Small")) {
            ClickGUI.mc.displayGuiScreen(Main.instance.csgui);
        }
        Main.featureDirector.getFeatureByClass(ClickGUI.class).setEnabled(false);
        super.onEnable();
    }
    
    static {
        ClickGUI.glow = new BooleanSetting("Glow", true, () -> true);
        ClickGUI.blur = new BooleanSetting("Blur", true, () -> true);
        ClickGUI.clickGuiColor = new ListSetting("ClickGui Color", "Astolfo", () -> true, new String[] { "Astolfo", "Rainbow", "Static", "Color Two", "Client", "Fade" });
        ClickGUI.image = new BooleanSetting("Image", true, () -> true);
        ClickGUI.speed = new NumberSetting("Speed", 35.0f, 10.0f, 100.0f, 1.0f, () -> true);
    }
}
