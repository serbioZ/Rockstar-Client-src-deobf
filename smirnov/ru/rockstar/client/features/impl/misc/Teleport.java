// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.event.event.EventMouseKey;
import ru.rockstar.client.features.Feature;

public class Teleport extends Feature
{
    @EventTarget
    public void onMouse(final EventMouseKey llllllllllllIllllIlllIlIIIIlllll) {
        if (!this.isToggled()) {
            return;
        }
        final BlockPos llllllllllllIllllIlllIlIIIIllllI = Teleport.mc.objectMouseOver.getBlockPos();
        if (llllllllllllIllllIlllIlIIIIlllll.getKey() == 2) {
            final int llllllllllllIllllIlllIlIIIIlllIl = (int)(llllllllllllIllllIlllIlIIIIllllI.getX() - Teleport.mc.player.posX);
            final int llllllllllllIllllIlllIlIIIIlllII = (int)(llllllllllllIllllIlllIlIIIIllllI.getY() - Teleport.mc.player.posY);
            final int llllllllllllIllllIlllIlIIIIllIll = (int)(llllllllllllIllllIlllIlIIIIllllI.getZ() - Teleport.mc.player.posZ);
            Teleport.mc.player.setPosition(llllllllllllIllllIlllIlIIIIllllI.getX(), llllllllllllIllllIlllIlIIIIllllI.getY(), llllllllllllIllllIlllIlIIIIllllI.getZ());
            Teleport.mc.player.connection.sendPacket(new CPacketPlayer.Position(llllllllllllIllllIlllIlIIIIlllIl, llllllllllllIllllIlllIlIIIIlllII, llllllllllllIllllIlllIlIIIIllIll, true));
            Teleport.mc.player.connection.sendPacket(new CPacketPlayer.Position(llllllllllllIllllIlllIlIIIIlllIl, llllllllllllIllllIlllIlIIIIlllII, llllllllllllIllllIlllIlIIIIllIll, false));
        }
    }
    
    @Override
    public void onDisable() {
        Teleport.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
    
    public Teleport() {
        super("Teleport", "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442\u0438\u0440\u0443\u0435\u0442 \u0432\u0430\u0441 \u043a\u043e\u0433\u0434\u0430 \u0432\u044b \u043d\u0430\u0436\u0438\u043c\u0430\u0435\u0442\u0435 \u043d\u0430 \u043a\u043e\u043b\u0451\u0441\u0438\u043a\u043e \u043c\u044b\u0448\u0438", 0, Category.PLAYER);
    }
}
