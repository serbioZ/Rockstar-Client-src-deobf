// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Feature;

public class AirJump extends Feature
{
    @EventTarget
    public void sdd(final EventUpdate lllllllllllIllllIlIlIlIlIlIlllIl) {
        if (AirJump.mc.gameSettings.keyBindJump.isKeyDown()) {
            AirJump.mc.player.jump();
        }
    }
    
    public AirJump() {
        super("AirJump", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043f\u0440\u044b\u0433\u0430\u0442\u044c \u043f\u043e \u0432\u043e\u0437\u0434\u0443\u0445\u0443", 0, Category.MOVEMENT);
    }
}
