// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class ScoreBoard extends Feature
{
    public static /* synthetic */ BooleanSetting noScore;
    public /* synthetic */ NumberSetting y;
    
    public ScoreBoard() {
        super("Scoreboard", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043d\u0430\u0441\u0442\u0440\u043e\u0438\u0442\u044c \u0441\u043a\u043e\u0440\u0431\u043e\u0440\u0434 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435", 0, Category.VISUALS);
        this.y = new NumberSetting("PositionY", "\u041f\u043e\u0437\u0438\u0446\u0438\u044f \u0441\u043a\u043e\u0440\u0431\u043e\u0440\u0434\u0430 \u043f\u043e Y", 5.0f, 0.0f, 215.0f, 1.0f, () -> !ScoreBoard.noScore.getBoolValue());
        ScoreBoard.noScore = new BooleanSetting("No Scoreboard", false, () -> true);
        this.addSettings(ScoreBoard.noScore, this.y);
    }
}
