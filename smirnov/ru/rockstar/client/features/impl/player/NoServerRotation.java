// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.client.features.Feature;

public class NoServerRotation extends Feature
{
    @EventTarget
    public void onReceivePacket(final EventReceivePacket lllllllllllIIllIllIlIIIlIllIIIll) {
        if (lllllllllllIIllIllIlIIIlIllIIIll.getPacket() instanceof SPacketPlayerPosLook) {
            final SPacketPlayerPosLook lllllllllllIIllIllIlIIIlIllIIlII = (SPacketPlayerPosLook)lllllllllllIIllIllIlIIIlIllIIIll.getPacket();
            lllllllllllIIllIllIlIIIlIllIIlII.yaw = NoServerRotation.mc.player.rotationYaw;
            lllllllllllIIllIllIlIIIlIllIIlII.pitch = NoServerRotation.mc.player.rotationPitch;
        }
    }
    
    public NoServerRotation() {
        super("NoServerRotation", "\u0423\u0431\u0438\u0440\u0430\u0435\u0442 \u0440\u043e\u0442\u0430\u0446\u0438\u044e \u0441\u043e \u0441\u0442\u043e\u0440\u043e\u043d\u044b \u0441\u0435\u0440\u0432\u0435\u0440\u0430", 0, Category.PLAYER);
    }
}
