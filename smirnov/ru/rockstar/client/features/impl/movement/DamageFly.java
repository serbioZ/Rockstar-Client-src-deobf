// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.item.ItemBow;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class DamageFly extends Feature
{
    /* synthetic */ boolean velocity;
    /* synthetic */ boolean isVelocity;
    /* synthetic */ boolean hui;
    public static /* synthetic */ int ticks;
    public static /* synthetic */ BooleanSetting autoBow;
    /* synthetic */ double motion;
    public static /* synthetic */ BooleanSetting autoDisable;
    public static /* synthetic */ int tick;
    public /* synthetic */ TimerHelper timerUtils;
    private final /* synthetic */ NumberSetting Speed;
    private final /* synthetic */ NumberSetting Ticks;
    /* synthetic */ boolean getDamage;
    
    @Override
    public void onDisable() {
        this.getDamage = false;
        DamageFly.tick = 0;
        DamageFly.mc.timer.timerSpeed = 1.0f;
        super.onDisable();
    }
    
    public DamageFly() {
        super("DamageFly", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0432\u0430\u043c \u043b\u0435\u0442\u0430\u0442\u044c \u043e\u0442 \u0434\u0430\u043c\u0430\u0433\u0430", 0, Category.MOVEMENT);
        this.timerUtils = new TimerHelper();
        this.hui = false;
        this.Ticks = new NumberSetting("Ticks", 24.0f, 1.0f, 40.0f, 1.0f, () -> true);
        this.Speed = new NumberSetting("Speed", 35.0f, 1.0f, 50.0f, 5.0f, () -> true);
        DamageFly.autoDisable = new BooleanSetting("AutoDisable", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0434\u0430\u043c\u0430\u0433\u0444\u043b\u0430\u0439", false, () -> true);
        DamageFly.autoBow = new BooleanSetting("AutoFastBow", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u0441\u0442\u0440\u0435\u043b\u0438\u0432\u0430\u0435\u0442, \u043a\u0430\u043a \u0442\u043e\u043b\u044c\u043a\u043e \u043b\u0443\u043a \u043d\u0430\u0442\u044f\u043d\u0443\u043b\u0441\u044f", false, () -> true);
        this.addSettings(this.Ticks, this.Speed, DamageFly.autoDisable, DamageFly.autoBow);
    }
    
    @EventTarget
    private void onPacket(final EventReceivePacket llllllllllIlllIIIIlllllIllllIIlI) {
        if (llllllllllIlllIIIIlllllIllllIIlI.getPacket() instanceof SPacketEntityVelocity) {
            if (((SPacketEntityVelocity)llllllllllIlllIIIIlllllIllllIIlI.getPacket()).getMotionY() > 0) {
                this.isVelocity = true;
            }
            if (((SPacketEntityVelocity)llllllllllIlllIIIIlllllIllllIIlI.getPacket()).getMotionY() / 8000.0 > 0.2) {
                this.motion = ((SPacketEntityVelocity)llllllllllIlllIIIIlllllIllllIIlI.getPacket()).getMotionY() / 8000.0;
                this.velocity = true;
            }
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllIlllIIIIlllllIlllIllIl) {
        DamageFly.ticks = (int)this.Ticks.getNumberValue();
        if (DamageFly.mc.player.hurtTime == 9) {
            this.getDamage = true;
        }
        if (this.getDamage) {
            DamageFly.mc.gameSettings.keyBindUseItem.pressed = false;
            DamageFly.tick += (int)(1.0f / DamageFly.mc.timer.timerSpeed);
            DamageFly.mc.player.motionY = this.motion;
            DamageFly.mc.player.jumpMovementFactor = 0.01f * this.Speed.getNumberValue();
            MovementHelper.setSpeed(MovementHelper.getSpeed());
        }
        if (DamageFly.tick >= this.Ticks.getNumberValue()) {
            this.getDamage = false;
            if (DamageFly.mc.player.onGround) {
                DamageFly.tick = 0;
            }
            if (DamageFly.autoDisable.getBoolValue()) {
                this.toggle();
            }
        }
        if (DamageFly.mc.player.onGround && !this.getDamage && DamageFly.autoBow.getBoolValue() && DamageFly.mc.gameSettings.keyBindForward.pressed && DamageFly.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && DamageFly.mc.player.isBowing() && DamageFly.mc.player.getItemInUseMaxCount() >= 1.5) {
            DamageFly.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, DamageFly.mc.player.getHorizontalFacing()));
            DamageFly.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            DamageFly.mc.player.stopActiveHand();
        }
    }
}
