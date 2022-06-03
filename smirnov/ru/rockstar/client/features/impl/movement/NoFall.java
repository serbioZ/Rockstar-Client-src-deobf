// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.event.event.EventPreMotion;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class NoFall extends Feature
{
    public static /* synthetic */ ListSetting noFallMode;
    public /* synthetic */ TimerHelper timerHelper;
    
    @EventTarget
    public void noFall(final EventUpdate llllllllllllIIIIlIlIIlllIllIllIl) {
        final String llllllllllllIIIIlIlIIlllIllIllII = NoFall.noFallMode.getOptions();
        this.setSuffix(llllllllllllIIIIlIlIIlllIllIllII, true);
        if (llllllllllllIIIIlIlIIlllIllIllII.equalsIgnoreCase("Matrix New") && NoFall.mc.player.fallDistance > 2.5f) {
            NoFall.mc.player.connection.sendPacket(new CPacketPlayer.Position(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, true));
            NoFall.mc.player.fallDistance = 1.0f;
        }
    }
    
    public NoFall() {
        super("NoFall", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043c\u0435\u043d\u044c\u0448\u0438\u0439 \u0434\u0430\u043c\u0430\u0433 \u043f\u0440\u0438 \u043f\u0430\u0434\u0435\u043d\u0438\u0438", 0, Category.PLAYER);
        this.timerHelper = new TimerHelper();
        NoFall.noFallMode = new ListSetting("NoFall Mode", "Vanilla", () -> true, new String[] { "Vanilla", "GroundCancel", "Spartan", "AAC-Flags", "Matrix", "Matrix New", "Hypixel" });
        this.addSettings(NoFall.noFallMode);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion llllllllllllIIIIlIlIIlllIlllIIlI) {
        final String llllllllllllIIIIlIlIIlllIlllIlII = NoFall.noFallMode.getOptions();
        this.setSuffix(llllllllllllIIIIlIlIIlllIlllIlII, true);
        if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("Vanilla")) {
            if (NoFall.mc.player.fallDistance > 3.0f) {
                llllllllllllIIIIlIlIIlllIlllIIlI.setOnGround(true);
                NoFall.mc.player.connection.sendPacket(new CPacketPlayer(true));
            }
        }
        else if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("Spartan")) {
            if (NoFall.mc.player.fallDistance > 7.0f) {
                if (this.timerHelper.hasReached(150.0)) {
                    NoFall.mc.timer.timerSpeed = 4.0f;
                    NoFall.mc.player.connection.sendPacket(new CPacketPlayer.Position(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, true));
                    this.timerHelper.reset();
                }
                else {
                    NoFall.mc.timer.timerSpeed = 1.0f;
                    NoFall.mc.player.onGround = false;
                }
            }
        }
        else if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("AAC-Flags")) {
            final EntityPlayerSP player = NoFall.mc.player;
            player.motionY -= 0.1;
            llllllllllllIIIIlIlIIlllIlllIIlI.setOnGround(false);
            NoFall.mc.player.capabilities.disableDamage = true;
        }
        else if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("Hypixel")) {
            if (NoFall.mc.player.fallDistance > 3.4) {
                llllllllllllIIIIlIlIIlllIlllIIlI.setOnGround(NoFall.mc.player.ticksExisted % 2 == 0);
            }
        }
        else if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("Matrix")) {
            if (NoFall.mc.player.fallDistance > 3.0f) {
                NoFall.mc.player.connection.sendPacket(new CPacketPlayer.Position(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, true));
                NoFall.mc.player.fallDistance = 1.0f;
            }
        }
        else if (llllllllllllIIIIlIlIIlllIlllIlII.equalsIgnoreCase("GroundCancel")) {
            llllllllllllIIIIlIlIIlllIlllIIlI.setOnGround(false);
        }
    }
}
