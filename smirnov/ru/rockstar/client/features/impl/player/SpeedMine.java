// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import net.minecraft.potion.PotionEffect;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.event.event.EventBlockInteract;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.init.MobEffects;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class SpeedMine extends Feature
{
    public /* synthetic */ ListSetting mode;
    public /* synthetic */ NumberSetting damageValue;
    
    @Override
    public void onDisable() {
        SpeedMine.mc.player.removePotionEffect(MobEffects.HASTE);
        super.onDisable();
    }
    
    public SpeedMine() {
        super("SpeedMine", "\u0423\u0441\u043a\u043e\u0440\u044f\u0435\u0442 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u043b\u043e\u043c\u0430\u043d\u0438\u044f \u0431\u043b\u043e\u043a\u043e\u0432", 0, Category.PLAYER);
        this.damageValue = new NumberSetting("Damage Value", 0.8f, 0.7f, 4.0f, 0.1f, () -> this.mode.currentMode.equals("Damage"));
        this.mode = new ListSetting("SpeedMine Mode", "Packet", () -> true, new String[] { "Packet", "Damage", "Potion" });
        this.addSettings(this.mode, this.damageValue);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllIlIIllIlllIIIIllII) {
        this.setSuffix(this.mode.currentMode, true);
    }
    
    @EventTarget
    public void onBlockInteract(final EventBlockInteract lllllllllllIllIlIIllIlllIIIIIllI) {
        final Exception lllllllllllIllIlIIllIlllIIIIIIll;
        switch (lllllllllllIllIlIIllIlllIIIIIIll = (Exception)this.mode.currentMode) {
            case "Packet": {
                SpeedMine.mc.player.swingArm(EnumHand.MAIN_HAND);
                SpeedMine.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, lllllllllllIllIlIIllIlllIIIIIllI.getPos(), lllllllllllIllIlIIllIlllIIIIIllI.getFace()));
                SpeedMine.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, lllllllllllIllIlIIllIlllIIIIIllI.getPos(), lllllllllllIllIlIIllIlllIIIIIllI.getFace()));
                lllllllllllIllIlIIllIlllIIIIIllI.setCancelled(true);
                break;
            }
            case "Potion": {
                SpeedMine.mc.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 817, 1));
                break;
            }
            case "Damage": {
                if (SpeedMine.mc.playerController.curBlockDamageMP >= 0.7) {
                    SpeedMine.mc.playerController.curBlockDamageMP = this.damageValue.getNumberValue();
                    break;
                }
                break;
            }
            default:
                break;
        }
    }
}
