// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class BedrockClip extends Feature
{
    public BedrockClip() {
        super("BedrockClip", "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u0443\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u0430 \u043f\u043e\u0434 \u0431\u0435\u0434\u0440\u043e\u043a", 0, Category.MOVEMENT);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIlIllIIllIIlIlIlIll) {
        if (BedrockClip.mc.player.isInWater() || BedrockClip.mc.player.hurtTime > 0) {
            BedrockClip.mc.player.setPosition(BedrockClip.mc.player.posX, BedrockClip.mc.player.posY - (BedrockClip.mc.player.posY + 2.0), BedrockClip.mc.player.posZ);
            this.toggle();
        }
    }
}
