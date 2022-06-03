// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import net.minecraft.world.EnumSkyBlock;
import ru.rockstar.api.event.event.EventRenderWorldLight;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.init.MobEffects;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class NoRender extends Feature
{
    public static /* synthetic */ BooleanSetting blindness;
    public static /* synthetic */ BooleanSetting noExp;
    public static /* synthetic */ BooleanSetting chatRect;
    public static /* synthetic */ BooleanSetting light;
    public static /* synthetic */ BooleanSetting cameraClip;
    public static /* synthetic */ BooleanSetting glintEffect;
    public static /* synthetic */ BooleanSetting noBoss;
    public static /* synthetic */ BooleanSetting noArrow;
    public static /* synthetic */ BooleanSetting antiTotem;
    public static /* synthetic */ BooleanSetting noPotion;
    public static /* synthetic */ BooleanSetting noFire;
    public static /* synthetic */ BooleanSetting noPumpkin;
    public static /* synthetic */ BooleanSetting fog;
    public static /* synthetic */ BooleanSetting hurtcam;
    public static /* synthetic */ BooleanSetting itemGui;
    public static /* synthetic */ BooleanSetting noArmor;
    public static /* synthetic */ BooleanSetting rain;
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIllIIIIllIlllIIIlIlI) {
        if ((NoRender.blindness.getBoolValue() && NoRender.mc.player.isPotionActive(MobEffects.BLINDNESS)) || NoRender.mc.player.isPotionActive(MobEffects.NAUSEA)) {
            NoRender.mc.player.removePotionEffect(MobEffects.NAUSEA);
            NoRender.mc.player.removePotionEffect(MobEffects.BLINDNESS);
        }
    }
    
    public NoRender() {
        super("NoRender", "\u0423\u0431\u0438\u0440\u0430\u0435\u0442 \u043e\u043f\u0440\u0435\u0434\u043b\u0435\u043d\u043d\u044b\u0435 \u044d\u043b\u0435\u043c\u0435\u043d\u0442\u044b \u0440\u0435\u043d\u0434\u0435\u0440\u0430 \u0432 \u0438\u0433\u0440\u0435", 0, Category.VISUALS);
        NoRender.rain = new BooleanSetting("Rain", true, () -> true);
        NoRender.hurtcam = new BooleanSetting("HurtCam", true, () -> true);
        NoRender.cameraClip = new BooleanSetting("Camera Clip", true, () -> true);
        NoRender.antiTotem = new BooleanSetting("AntiTotemAnimation", false, () -> true);
        NoRender.noFire = new BooleanSetting("NoFireOverlay", false, () -> true);
        NoRender.noPotion = new BooleanSetting("NoPotionDebug", false, () -> true);
        NoRender.noExp = new BooleanSetting("NoExpBar", false, () -> true);
        NoRender.fog = new BooleanSetting("Fog", false, () -> true);
        NoRender.noPumpkin = new BooleanSetting("NoPumpkinOverlay", false, () -> true);
        NoRender.chatRect = new BooleanSetting("Chat Rect", false, () -> true);
        NoRender.light = new BooleanSetting("Light", false, () -> true);
        NoRender.blindness = new BooleanSetting("Blindness", true, () -> true);
        NoRender.noBoss = new BooleanSetting("NoBossBar", false, () -> true);
        NoRender.glintEffect = new BooleanSetting("Glint Effect", false, () -> true);
        NoRender.noArrow = new BooleanSetting("NoArrowInPlayer", false, () -> true);
        NoRender.noArmor = new BooleanSetting("NoArmor", false, () -> true);
        NoRender.itemGui = new BooleanSetting("Item Gui", false, () -> true);
        this.addSettings(NoRender.rain, NoRender.fog, NoRender.hurtcam, NoRender.cameraClip, NoRender.antiTotem, NoRender.noArmor, NoRender.noFire, NoRender.chatRect, NoRender.blindness, NoRender.light, NoRender.noPotion, NoRender.noExp, NoRender.noPumpkin, NoRender.noBoss, NoRender.glintEffect, NoRender.noArrow, NoRender.itemGui);
    }
    
    @EventTarget
    public void onWorldLight(final EventRenderWorldLight llllllllllllIllIIIIllIlllIIIIllI) {
        if (!this.isToggled()) {
            return;
        }
        if (NoRender.light.getBoolValue() && llllllllllllIllIIIIllIlllIIIIllI.getEnumSkyBlock() == EnumSkyBlock.SKY) {
            llllllllllllIllIIIIllIlllIIIIllI.setCancelled(true);
        }
    }
}
