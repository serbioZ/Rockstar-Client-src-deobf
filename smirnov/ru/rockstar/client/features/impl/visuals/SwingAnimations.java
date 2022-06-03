// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import ru.rockstar.api.event.event.EventTransformSideFirstPerson;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.features.Feature;

public class SwingAnimations extends Feature
{
    public static /* synthetic */ ListSetting item360Hand;
    public static /* synthetic */ NumberSetting item360Speed;
    public static /* synthetic */ NumberSetting fapSmooth;
    public static /* synthetic */ ListSetting swordAnim;
    public static /* synthetic */ boolean blocking;
    public static /* synthetic */ BooleanSetting item360;
    public static /* synthetic */ NumberSetting spinSpeed;
    public static /* synthetic */ ListSetting item360Mode;
    public static /* synthetic */ NumberSetting swingSpeed;
    public static /* synthetic */ BooleanSetting auraOnly;
    
    public SwingAnimations() {
        super("SwingAnimations", "\u0414\u043e\u0431\u0430\u0432\u043b\u044f\u0435\u0442 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u044e \u043d\u0430 \u043c\u0435\u0447", 0, Category.VISUALS);
        SwingAnimations.swordAnim = new ListSetting("Blocking Animation Mode", "Astolfo", () -> true, new String[] { "Astolfo", "Rockstar", "Spin", "Fap", "Big" });
        SwingAnimations.auraOnly = new BooleanSetting("Aura Only", false, () -> true);
        SwingAnimations.swingSpeed = new NumberSetting("Swing Speed", "\u0421\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0443\u0434\u0430\u0440\u0430 \u043c\u0435\u0447\u0430", 8.0f, 1.0f, 20.0f, 1.0f, () -> true);
        SwingAnimations.spinSpeed = new NumberSetting("Spin Speed", 4.0f, 1.0f, 10.0f, 1.0f, () -> SwingAnimations.swordAnim.currentMode.equals("Astolfo") || SwingAnimations.swordAnim.currentMode.equals("Spin"));
        SwingAnimations.fapSmooth = new NumberSetting("Fap Smooth", 4.0f, 0.5f, 10.0f, 0.5f, () -> SwingAnimations.swordAnim.currentMode.equals("Fap"));
        SwingAnimations.item360 = new BooleanSetting("Item360", false, () -> true);
        SwingAnimations.item360Mode = new ListSetting("Item360 Mode", "Horizontal", () -> SwingAnimations.item360.getBoolValue(), new String[] { "Horizontal", "Vertical", "Zoom" });
        SwingAnimations.item360Hand = new ListSetting("Item360 Hand", "All", () -> SwingAnimations.item360.getBoolValue(), new String[] { "All", "Left", "Right" });
        SwingAnimations.item360Speed = new NumberSetting("Item360 Speed", 8.0f, 1.0f, 15.0f, 1.0f, () -> SwingAnimations.item360.getBoolValue());
        this.addSettings(SwingAnimations.auraOnly, SwingAnimations.swordAnim, SwingAnimations.spinSpeed, SwingAnimations.fapSmooth, SwingAnimations.swingSpeed, SwingAnimations.item360, SwingAnimations.item360Mode, SwingAnimations.item360Hand, SwingAnimations.item360Speed);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIlIIIlllllllllllIIlII) {
        final String lllllllllllIlIIIlllllllllllIIIll = SwingAnimations.swordAnim.getOptions();
        SwingAnimations.blocking = (Main.featureDirector.getFeatureByClass(KillAura.class).isToggled() && KillAura.target != null);
        this.setModuleName("SwingAnimations " + TextFormatting.GRAY + lllllllllllIlIIIlllllllllllIIIll);
    }
    
    @EventTarget
    public void onSidePerson(final EventTransformSideFirstPerson lllllllllllIlIIIllllllllllIlllIl) {
        if (SwingAnimations.blocking && lllllllllllIlIIIllllllllllIlllIl.getEnumHandSide() == EnumHandSide.RIGHT) {
            GlStateManager.translate(0.29, 0.1, -0.31);
        }
    }
}
