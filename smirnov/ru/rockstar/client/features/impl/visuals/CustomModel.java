// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class CustomModel extends Feature
{
    public static /* synthetic */ ListSetting eyeColor;
    public static /* synthetic */ ListSetting modelMode;
    public static /* synthetic */ BooleanSetting onlyMe;
    public static /* synthetic */ ListSetting bodyColor;
    public static /* synthetic */ ColorSetting legsCustomColor;
    public static /* synthetic */ ColorSetting bodyCustomColor;
    public static /* synthetic */ ListSetting legsColor;
    public static /* synthetic */ BooleanSetting googlyEyes;
    public static /* synthetic */ NumberSetting googlyEyesSize;
    public static /* synthetic */ BooleanSetting friends;
    public static /* synthetic */ ColorSetting eyeCustomColor;
    public static /* synthetic */ BooleanSetting friendHighlight;
    
    public CustomModel() {
        super("CustomModel", "\u041c\u0435\u043d\u044f\u0435\u0442 \u043c\u043e\u0434\u0435\u043b\u044c \u0438\u0433\u0440\u043e\u043a\u0430", 0, Category.VISUALS);
        CustomModel.friendHighlight = new BooleanSetting("Friend Highlight", true, () -> CustomModel.modelMode.currentMode.equals("Amogus"));
        CustomModel.bodyColor = new ListSetting("Amogus Body Color Mode", "Custom", () -> CustomModel.modelMode.currentMode.equals("Amogus"), new String[] { "Custom", "Client", "Rainbow", "Astolfo" });
        CustomModel.eyeColor = new ListSetting("Amogus Eye Color Mode", "Custom", () -> CustomModel.modelMode.currentMode.equals("Amogus"), new String[] { "Custom", "Client", "Rainbow", "Astolfo" });
        CustomModel.legsColor = new ListSetting("Amogus Legs Color Mode", "Custom", () -> CustomModel.modelMode.currentMode.equals("Amogus"), new String[] { "Custom", "Client", "Rainbow", "Astolfo" });
        CustomModel.bodyCustomColor = new ColorSetting("Amogus Body Color", Color.RED.getRGB(), () -> CustomModel.modelMode.currentMode.equals("Amogus") && CustomModel.bodyColor.currentMode.equals("Custom"));
        CustomModel.eyeCustomColor = new ColorSetting("Amogus Eye Color", Color.CYAN.getRGB(), () -> CustomModel.modelMode.currentMode.equals("Amogus") && CustomModel.bodyColor.currentMode.equals("Custom"));
        CustomModel.legsCustomColor = new ColorSetting("Amogus Legs Color", Color.RED.getRGB(), () -> CustomModel.modelMode.currentMode.equals("Amogus") && CustomModel.bodyColor.currentMode.equals("Custom"));
        CustomModel.googlyEyes = new BooleanSetting("Googly Eyes", false, () -> CustomModel.modelMode.currentMode.equals("None"));
        CustomModel.googlyEyesSize = new NumberSetting("Google Eyes Size", 0.75f, 0.7f, 1.5f, 0.01f, () -> CustomModel.googlyEyes.getBoolValue() && CustomModel.modelMode.currentMode.equals("None"));
        CustomModel.onlyMe = new BooleanSetting("Only Me", true, () -> true);
        CustomModel.friends = new BooleanSetting("Friends", false, () -> CustomModel.onlyMe.getBoolValue());
        this.addSettings(CustomModel.modelMode, CustomModel.friendHighlight, CustomModel.bodyColor, CustomModel.bodyCustomColor, CustomModel.eyeColor, CustomModel.eyeCustomColor, CustomModel.legsColor, CustomModel.legsCustomColor, CustomModel.googlyEyes, CustomModel.googlyEyesSize, CustomModel.onlyMe, CustomModel.friends);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIllIIIllIIIIIIllIIlI) {
        this.setSuffix(CustomModel.modelMode.getCurrentMode(), true);
    }
    
    static {
        CustomModel.modelMode = new ListSetting("Model Mode", "Amogus", () -> true, new String[] { "Amogus", "Jeff Killer", "Crab", "Demon", "Freddy Bear", "Crazy Rabbit" });
    }
}
