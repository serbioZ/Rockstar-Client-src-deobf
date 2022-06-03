// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.ui.settings.Setting;
import java.util.concurrent.ConcurrentLinkedQueue;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.api.utils.world.TimerHelper;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import java.util.Queue;
import ru.rockstar.client.features.Feature;

public class Disabler extends Feature
{
    /* synthetic */ Queue<SPacketPlayerPosLook> packetList;
    /* synthetic */ TimerHelper timer;
    public /* synthetic */ ListSetting disablerMode;
    
    @EventTarget
    public void onPreUpdate(final EventPreMotionUpdate llllllllllllIIIlIllllIllIllIIIlI) {
        if (this.disablerMode.currentMode.equals("Storm Movement")) {
            llllllllllllIIIlIllllIllIllIIIlI.setGround(false);
        }
        if (this.disablerMode.currentMode.equals("ReallyWorld") && Disabler.mc.player.ticksExisted % 6 == 0) {
            llllllllllllIIIlIllllIllIllIIIlI.setGround(true);
        }
    }
    
    public Disabler() {
        super("Disabler", "\u0427\u0430\u0441\u0442\u0438\u0447\u043d\u043e \u043e\u0442\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0430\u043d\u0442\u0438 \u0447\u0438\u0442 \u043d\u0430 \u0432\u0430\u0441", 0, Category.MISC);
        this.packetList = new ConcurrentLinkedQueue<SPacketPlayerPosLook>();
        this.timer = new TimerHelper();
        this.disablerMode = new ListSetting("Disabler Mode", "ReallyWorld", () -> true, new String[] { "ReallyWorld", "Storm Movement" });
        this.addSettings(this.disablerMode);
    }
}
