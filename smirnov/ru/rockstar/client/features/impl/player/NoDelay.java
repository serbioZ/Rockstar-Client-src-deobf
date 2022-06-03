// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NoDelay extends Feature
{
    public /* synthetic */ BooleanSetting rightClickDelay;
    public /* synthetic */ BooleanSetting jumpDelay;
    
    public NoDelay() {
        super("NoDelay", "\u0423\u0431\u0438\u0440\u0430\u0435\u0442 \u0437\u0430\u0434\u0435\u0440\u0436\u043a\u0443", 0, Category.PLAYER);
        this.rightClickDelay = new BooleanSetting("NoRightClickDelay", true, () -> true);
        this.jumpDelay = new BooleanSetting("NoJumpDelay", true, () -> true);
        this.addSettings(this.rightClickDelay, this.jumpDelay);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIlIlIIlllIlIlIIIIlII) {
        if (!this.isToggled()) {
            return;
        }
        if (this.rightClickDelay.getBoolValue()) {
            NoDelay.mc.rightClickDelayTimer = 0;
        }
        if (this.jumpDelay.getBoolValue()) {
            NoDelay.mc.player.jumpTicks = 0;
        }
    }
    
    @Override
    public void onDisable() {
        NoDelay.mc.rightClickDelayTimer = 4;
        super.onDisable();
    }
}
