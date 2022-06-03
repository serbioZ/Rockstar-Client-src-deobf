// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventRender2D;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class Crosshair extends Feature
{
    public static /* synthetic */ ColorSetting colorGlobal;
    public /* synthetic */ BooleanSetting dynamic;
    public /* synthetic */ NumberSetting gap;
    public /* synthetic */ NumberSetting length;
    public /* synthetic */ BooleanSetting circle;
    public /* synthetic */ NumberSetting dynamicGap;
    public /* synthetic */ NumberSetting width;
    public /* synthetic */ BooleanSetting tmode;
    
    public Crosshair() {
        super("Crosshair", "\u0418\u0437\u043c\u0435\u043d\u044f\u0435\u0442 \u0432\u0430\u0448 \u043f\u0440\u0438\u0446\u0435\u043b", 0, Category.VISUALS);
        this.circle = new BooleanSetting("Circle", false, () -> true);
        this.dynamic = new BooleanSetting("Dynamic", false, () -> true);
        this.dynamicGap = new NumberSetting("Dynamic Gap", 3.0f, 1.0f, 20.0f, 1.0f, this.dynamic::getBoolValue);
        this.gap = new NumberSetting("Gap", 2.0f, 0.0f, 10.0f, 0.1f, () -> true);
        this.tmode = new BooleanSetting("T-Mode", false, () -> true);
        Crosshair.colorGlobal = new ColorSetting("Crosshair Color", new Color(16777215).getRGB(), () -> true);
        this.width = new NumberSetting("Width", 1.0f, 0.0f, 8.0f, 1.0f, () -> true);
        this.length = new NumberSetting("Length", 3.0f, 0.5f, 30.0f, 1.0f, () -> true);
        this.addSettings(this.circle, this.tmode, this.dynamic, this.dynamicGap, this.gap, Crosshair.colorGlobal, this.width, this.length);
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllIlIIIIIIlllIllIIIlllI) {
        final int lllllllllllIlIIIIIIlllIllIlIIIIl = Crosshair.colorGlobal.getColorValue();
        final float lllllllllllIlIIIIIIlllIllIlIIIII = (float)lllllllllllIlIIIIIIlllIllIIIlllI.getResolution().getScaledWidth();
        final float lllllllllllIlIIIIIIlllIllIIlllll = (float)lllllllllllIlIIIIIIlllIllIIIlllI.getResolution().getScaledHeight();
        final float lllllllllllIlIIIIIIlllIllIIllllI = lllllllllllIlIIIIIIlllIllIlIIIII / 2.0f;
        final float lllllllllllIlIIIIIIlllIllIIlllIl = lllllllllllIlIIIIIIlllIllIIlllll / 2.0f;
        final boolean lllllllllllIlIIIIIIlllIllIIlllII = this.dynamic.getBoolValue();
        final float lllllllllllIlIIIIIIlllIllIIllIll = this.dynamicGap.getNumberValue();
        final float lllllllllllIlIIIIIIlllIllIIllIlI = this.width.getNumberValue();
        final float lllllllllllIlIIIIIIlllIllIIllIIl = this.length.getNumberValue();
        final boolean lllllllllllIlIIIIIIlllIllIIllIII = lllllllllllIlIIIIIIlllIllIIlllII && MovementHelper.isMoving();
        final float lllllllllllIlIIIIIIlllIllIIlIlll = lllllllllllIlIIIIIIlllIllIIllIII ? lllllllllllIlIIIIIIlllIllIIllIll : this.gap.getNumberValue();
        if (this.circle.getBoolValue()) {
            final ScaledResolution lllllllllllIlIIIIIIlllIllIIlIllI = new ScaledResolution(Crosshair.mc);
            final float lllllllllllIlIIIIIIlllIllIIlIlIl = Crosshair.mc.player.getCooledAttackStrength(0.0f);
            final double lllllllllllIlIIIIIIlllIllIIlIlII = 360.0 * lllllllllllIlIIIIIIlllIllIIlIlIl;
            final int lllllllllllIlIIIIIIlllIllIIlIIll = lllllllllllIlIIIIIIlllIllIIlIllI.getScaledWidth();
            final int lllllllllllIlIIIIIIlllIllIIlIIlI = lllllllllllIlIIIIIIlllIllIIlIllI.getScaledHeight();
            final float lllllllllllIlIIIIIIlllIllIIlIIIl = lllllllllllIlIIIIIIlllIllIIlIIll / 2.0f;
            final float lllllllllllIlIIIIIIlllIllIIlIIII = lllllllllllIlIIIIIIlllIllIIlIIlI / 2.0f;
            DrawHelper.drawCircle(lllllllllllIlIIIIIIlllIllIIlIIIl, lllllllllllIlIIIIIIlllIllIIlIIII, 0.0f, (float)lllllllllllIlIIIIIIlllIllIIlIlII, 3.0f, 3.0f, false, new Color(lllllllllllIlIIIIIIlllIllIlIIIIl));
        }
        else {
            DrawHelper.drawRect(lllllllllllIlIIIIIIlllIllIIllllI - lllllllllllIlIIIIIIlllIllIIlIlll - lllllllllllIlIIIIIIlllIllIIllIIl, lllllllllllIlIIIIIIlllIllIIlllIl - lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIllllI - lllllllllllIlIIIIIIlllIllIIlIlll, lllllllllllIlIIIIIIlllIllIIlllIl + lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIlIIIIl);
            DrawHelper.drawRect(lllllllllllIlIIIIIIlllIllIIllllI + lllllllllllIlIIIIIIlllIllIIlIlll, lllllllllllIlIIIIIIlllIllIIlllIl - lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIllllI + lllllllllllIlIIIIIIlllIllIIlIlll + lllllllllllIlIIIIIIlllIllIIllIIl, lllllllllllIlIIIIIIlllIllIIlllIl + lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIlIIIIl);
            if (!this.tmode.getBoolValue()) {
                DrawHelper.drawRect(lllllllllllIlIIIIIIlllIllIIllllI - lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIlllIl - lllllllllllIlIIIIIIlllIllIIlIlll - lllllllllllIlIIIIIIlllIllIIllIIl, lllllllllllIlIIIIIIlllIllIIllllI + lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIlllIl - lllllllllllIlIIIIIIlllIllIIlIlll, lllllllllllIlIIIIIIlllIllIlIIIIl);
            }
            DrawHelper.drawRect(lllllllllllIlIIIIIIlllIllIIllllI - lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIlllIl + lllllllllllIlIIIIIIlllIllIIlIlll, lllllllllllIlIIIIIIlllIllIIllllI + lllllllllllIlIIIIIIlllIllIIllIlI / 2.0f, lllllllllllIlIIIIIIlllIllIIlllIl + lllllllllllIlIIIIIIlllIllIIlIlll + lllllllllllIlIIIIIIlllIllIIllIIl, lllllllllllIlIIIIIIlllIllIlIIIIl);
        }
    }
}
