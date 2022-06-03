// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.client.features.Category;
import net.minecraft.network.play.client.CPacketKeepAlive;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import ru.rockstar.api.event.event.EventSendPacket;
import ru.rockstar.client.features.Feature;

public class AntiAim extends Feature
{
    /* synthetic */ int twid;
    /* synthetic */ short tsid;
    /* synthetic */ long id;
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIlIlIlIlllIllllllIIl) {
    }
    
    public AntiAim() {
        super("AntiAim", "\u0423\u043c\u0435\u043d\u044c\u0448\u0430\u0435\u0442 \u0448\u0430\u043d\u0441 \u043f\u043e\u043f\u0430\u0434\u0430\u043d\u0438\u044f \u043f\u043e \u0432\u0430\u043c", 0, Category.COMBAT);
    }
    
    @EventTarget
    public void onSend(final EventSendPacket lllllllllllIIlIlIlIlllIlllllIIIl) {
        final long lllllllllllIIlIlIlIlllIlllllIIll = 25000L;
        this.setSuffix(new StringBuilder().append((int)lllllllllllIIlIlIlIlllIlllllIIll).toString(), true);
        if (!AntiAim.mc.isSingleplayer()) {
            if (lllllllllllIIlIlIlIlllIlllllIIIl.getPacket() instanceof CPacketConfirmTransaction) {
                if (this.tsid == ((CPacketConfirmTransaction)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getUid() && this.twid == ((CPacketConfirmTransaction)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getWindowId()) {
                    return;
                }
                lllllllllllIIlIlIlIlllIlllllIIIl.setCancelled(true);
                final long n;
                new Thread(() -> {
                    try {
                        Thread.sleep(n);
                    }
                    catch (InterruptedException lllllllllllIIlIlIlIlllIllllIlIlI) {
                        lllllllllllIIlIlIlIlllIllllIlIlI.printStackTrace();
                    }
                    this.tsid = ((CPacketConfirmTransaction)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getUid();
                    this.twid = ((CPacketConfirmTransaction)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getWindowId();
                    if (AntiAim.mc.player == null) {
                        return;
                    }
                    else if (AntiAim.mc.player.connection == null) {
                        return;
                    }
                    else {
                        AntiAim.mc.player.connection.sendPacket(lllllllllllIIlIlIlIlllIlllllIIIl.getPacket());
                        return;
                    }
                }).start();
            }
            if (lllllllllllIIlIlIlIlllIlllllIIIl.getPacket() instanceof CPacketKeepAlive) {
                if (this.id == ((CPacketKeepAlive)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getKey()) {
                    return;
                }
                lllllllllllIIlIlIlIlllIlllllIIIl.setCancelled(true);
                final long n2;
                new Thread(() -> {
                    try {
                        Thread.sleep(n2);
                    }
                    catch (InterruptedException lllllllllllIIlIlIlIlllIllllIIIII) {
                        lllllllllllIIlIlIlIlllIllllIIIII.printStackTrace();
                    }
                    this.id = ((CPacketKeepAlive)lllllllllllIIlIlIlIlllIlllllIIIl.getPacket()).getKey();
                    AntiAim.mc.player.connection.sendPacket(lllllllllllIIlIlIlIlllIlllllIIIl.getPacket());
                }).start();
            }
        }
    }
}
