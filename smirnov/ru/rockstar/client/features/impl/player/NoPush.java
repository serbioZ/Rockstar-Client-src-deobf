// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NoPush extends Feature
{
    public static /* synthetic */ BooleanSetting pushblocks;
    public static /* synthetic */ BooleanSetting pushplayers;
    public static /* synthetic */ BooleanSetting pushwater;
    
    public NoPush() {
        super("NoPush", "\u041d\u0435 \u043e\u0442\u0442\u0430\u043b\u043a\u0438\u0432\u0430\u0435\u0442 \u0432\u0430\u0441 \u043e\u0442 \u0432\u043e\u0434\u044b,\u0431\u043b\u043e\u043a\u043e\u0432,\u0438\u0433\u0440\u043e\u043a\u043e\u0432", 0, Category.PLAYER);
        this.addSettings(NoPush.pushblocks, NoPush.pushplayers, NoPush.pushwater);
    }
    
    static {
        NoPush.pushplayers = new BooleanSetting("Players", true, () -> true);
        NoPush.pushblocks = new BooleanSetting("Blocks", true, () -> true);
        NoPush.pushwater = new BooleanSetting("Water", true, () -> true);
    }
}
