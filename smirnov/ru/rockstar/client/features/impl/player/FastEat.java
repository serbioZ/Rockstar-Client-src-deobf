// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.event.event.EventPreMotion;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class FastEat extends Feature
{
    private final /* synthetic */ ListSetting modeFastEat;
    
    @Override
    public void onDisable() {
        FastEat.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
    
    public FastEat() {
        super("FastEat", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u044b\u0441\u0442\u0440\u043e \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0435\u0434\u0443", 0, Category.PLAYER);
        this.modeFastEat = new ListSetting("FastEat Mode", "Matrix", () -> true, new String[] { "Matrix", "Vanilla" });
        this.addSettings(this.modeFastEat);
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotion lllllllllllIIllIIIllIIIlIllIIlII) {
        final String lllllllllllIIllIIIllIIIlIllIIIll = this.modeFastEat.getOptions();
        this.setSuffix(lllllllllllIIllIIIllIIIlIllIIIll, true);
        if (lllllllllllIIllIIIllIIIlIllIIIll.equalsIgnoreCase("Matrix")) {
            if (FastEat.mc.player.getItemInUseMaxCount() >= 12 && (FastEat.mc.player.isEating() || FastEat.mc.player.isDrinking())) {
                for (int lllllllllllIIllIIIllIIIlIllIIIlI = 0; lllllllllllIIllIIIllIIIlIllIIIlI < 10; ++lllllllllllIIllIIIllIIIlIllIIIlI) {
                    FastEat.mc.player.connection.sendPacket(new CPacketPlayer(FastEat.mc.player.onGround));
                }
                FastEat.mc.player.stopActiveHand();
            }
        }
        else if (lllllllllllIIllIIIllIIIlIllIIIll.equalsIgnoreCase("Vanilla") && FastEat.mc.player.getItemInUseMaxCount() == 16 && (FastEat.mc.player.isEating() || FastEat.mc.player.isDrinking())) {
            for (int lllllllllllIIllIIIllIIIlIllIIIIl = 0; lllllllllllIIllIIIllIIIlIllIIIIl < 21; ++lllllllllllIIllIIIllIIIlIllIIIIl) {
                FastEat.mc.player.connection.sendPacket(new CPacketPlayer(true));
            }
            FastEat.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        }
    }
}
