// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class SelfDamage extends Feature
{
    private /* synthetic */ int jumps;
    
    public SelfDamage() {
        super("SelfDamage", "\u0412\u044b \u043d\u0430\u043d\u043e\u0441\u0438\u0442\u0435 \u0441\u0435\u0431\u0435 \u0434\u0430\u043c\u0430\u0433", 0, Category.PLAYER);
        this.jumps = 0;
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate lllllllllllllIllIlllIllIlllIIlII) {
        if (this.jumps < 1) {
            SelfDamage.mc.timer.renderPartialTicks = 4.0f;
            for (int lllllllllllllIllIlllIllIlllIIllI = 0; lllllllllllllIllIlllIllIlllIIllI < 20; ++lllllllllllllIllIlllIllIlllIIllI) {
                lllllllllllllIllIlllIllIlllIIlII.setGround(false);
                SelfDamage.mc.player.hurtTime = 1;
            }
        }
        if (SelfDamage.mc.player.onGround && this.jumps < 1) {
            SelfDamage.mc.player.jump();
            ++this.jumps;
        }
    }
    
    @Override
    public void onEnable() {
        this.jumps = 0;
        super.onEnable();
    }
}
