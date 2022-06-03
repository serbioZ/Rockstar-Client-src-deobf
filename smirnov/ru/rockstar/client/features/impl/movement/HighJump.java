// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.features.Category;
import java.util.concurrent.TimeUnit;
import ru.rockstar.client.features.Feature;

public class HighJump extends Feature
{
    @Override
    public void onEnable() {
        if (HighJump.mc.player.onGround) {
            if (HighJump.mc.player.onGround) {
                HighJump.mc.player.jump();
            }
            new Thread(() -> {
                HighJump.mc.player.motionY = 9.0;
                try {
                    TimeUnit.MILLISECONDS.sleep(200L);
                }
                catch (InterruptedException lllllllllllllIlIIlIIIIIIllIIIIIl) {
                    lllllllllllllIlIIlIIIIIIllIIIIIl.printStackTrace();
                }
                HighJump.mc.player.motionY = 8.741999626159668;
                this.toggle();
            }).start();
        }
    }
    
    public HighJump() {
        super("HighJump", "\u041f\u043e\u0434\u043a\u0438\u0434\u044b\u0432\u0430\u0435\u0442 \u0432\u0430\u0441 \u0432\u044b\u0441\u043e\u043a\u043e \u0432\u0432\u0435\u0440\u0445", 0, Category.MOVEMENT);
    }
}
