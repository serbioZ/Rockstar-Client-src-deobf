// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NameProtect extends Feature
{
    public static /* synthetic */ BooleanSetting skinSpoof;
    public static /* synthetic */ BooleanSetting tabSpoof;
    public static /* synthetic */ BooleanSetting scoreBoardSpoof;
    public static /* synthetic */ BooleanSetting otherNames;
    
    public NameProtect() {
        super("NameProtect", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0441\u043a\u0440\u044b\u0432\u0430\u0442\u044c \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043e \u0441\u0435\u0431\u0435 \u0438 \u0434\u0440\u0443\u0433\u0438\u0445 \u0438\u0433\u0440\u043e\u043a\u0430\u0445 \u043d\u0430 \u0432\u0438\u0434\u0435\u043e \u0438\u043b\u0438 \u0441\u0442\u0440\u0438\u043c\u0435", 0, Category.MISC);
        NameProtect.otherNames = new BooleanSetting("Other Names", true, () -> true);
        NameProtect.tabSpoof = new BooleanSetting("Tab Spoof", true, () -> true);
        NameProtect.skinSpoof = new BooleanSetting("Skin Spoof", true, () -> true);
        NameProtect.scoreBoardSpoof = new BooleanSetting("ScoreBoard Spoof", true, () -> true);
        this.addSettings(NameProtect.otherNames, NameProtect.tabSpoof, NameProtect.skinSpoof, NameProtect.scoreBoardSpoof);
    }
}
