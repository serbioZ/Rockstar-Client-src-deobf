// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.utils.other.DiscordUtils;
import ru.rockstar.client.features.Feature;

public class DiscordRPC extends Feature
{
    @Override
    public void onDisable() {
        DiscordUtils.stopRPC();
        super.onDisable();
    }
    
    public DiscordRPC() {
        super("DiscordRPC", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0447\u0438\u0442 \u0432 \u043f\u0440\u043e\u0444\u0438\u043b\u0435 \u0434\u0438\u0441\u043a\u043e\u0440\u0434\u0430", 0, Category.MISC);
    }
    
    @Override
    public void onEnable() {
        DiscordUtils.startRPC();
        super.onEnable();
    }
}
