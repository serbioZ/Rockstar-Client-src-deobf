// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.event.event.EventPostMotionUpdate;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class NoSlowDown extends Feature
{
    public static /* synthetic */ ListSetting noSlowMode;
    public static /* synthetic */ int usingTicks;
    public static /* synthetic */ NumberSetting percentage;
    
    @EventTarget
    public void onPlayerState(final EventPostMotionUpdate llllllllllllIlIIlIllllIIIlIlllIl) {
        if (!NoSlowDown.mc.player.isUsingItem()) {
            return;
        }
        if (NoSlowDown.noSlowMode.currentMode.equals("AAC")) {
            NoSlowDown.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        }
    }
    
    public NoSlowDown() {
        super("NoSlowDown", "\u0423\u0431\u0438\u0440\u0430\u0435\u0442 \u0437\u0430\u043c\u0435\u0434\u043b\u0435\u043d\u0438\u0435 \u043f\u0440\u0438 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438 \u0435\u0434\u044b \u0438 \u0434\u0440\u0443\u0433\u0438\u0445 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432", 0, Category.PLAYER);
        NoSlowDown.percentage = new NumberSetting("Percentage", 100.0f, 0.0f, 100.0f, 1.0f, () -> true);
        NoSlowDown.noSlowMode = new ListSetting("NoSlow Mode", "Default", () -> true, new String[] { "Default", "Matrix", "AAC" });
        this.addSettings(NoSlowDown.noSlowMode, NoSlowDown.percentage);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIlIIlIllllIIIlIllIlI) {
        this.setModuleName("NoSlowDown " + TextFormatting.GRAY + NoSlowDown.noSlowMode.getCurrentMode());
        NoSlowDown.usingTicks = (NoSlowDown.mc.player.isUsingItem() ? (++NoSlowDown.usingTicks) : 0);
        if (!this.isToggled() || !NoSlowDown.mc.player.isUsingItem()) {
            return;
        }
        if (NoSlowDown.noSlowMode.currentMode.equals("Matrix") && NoSlowDown.mc.player.isUsingItem()) {
            if (NoSlowDown.mc.player.onGround && !NoSlowDown.mc.gameSettings.keyBindJump.isKeyDown()) {
                if (NoSlowDown.mc.player.ticksExisted % 2 == 0) {
                    final EntityPlayerSP player = NoSlowDown.mc.player;
                    player.motionX *= 0.46;
                    final EntityPlayerSP player2 = NoSlowDown.mc.player;
                    player2.motionZ *= 0.46;
                }
            }
            else if (NoSlowDown.mc.player.fallDistance > 0.2) {
                final EntityPlayerSP player3 = NoSlowDown.mc.player;
                player3.motionX *= 0.9100000262260437;
                final EntityPlayerSP player4 = NoSlowDown.mc.player;
                player4.motionZ *= 0.9100000262260437;
            }
        }
    }
    
    @Override
    public void onDisable() {
        NoSlowDown.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
}
