// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.combat.KillAura;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Indicators extends Feature
{
    /* synthetic */ int y2;
    public static /* synthetic */ NumberSetting y;
    public static /* synthetic */ NumberSetting x;
    /* synthetic */ int x2;
    
    public Indicators() {
        super("Indicators", "Client logo.", 0, Category.DISPLAY);
        Indicators.x = new NumberSetting("Indicators X", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        Indicators.y = new NumberSetting("Indicators Y", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        this.addSettings(Indicators.x, Indicators.y);
    }
    
    @EventTarget
    public void onEvent3D(final Event3D llllllllllIlllIIIllIlIIIIIIlIIlI) {
    }
    
    @EventTarget
    public void ebatkopat(final Event2D llllllllllIlllIIIllIlIIIIIIllIll) {
        if (KillAura.target != null && Main.featureDirector.getFeatureByClass(KillAura.class).isToggled()) {
            this.x2 = (int)Indicators.x.getNumberValue();
            this.y2 = (int)Indicators.y.getNumberValue();
            final boolean llllllllllIlllIIIllIlIIIIIIllIlI = Indicators.mc.player.getHealth() - KillAura.target.getHealth() > 0.0f;
            final boolean llllllllllIlllIIIllIlIIIIIIllIIl = KillAura.target.getHealth() < Indicators.mc.player.getHealth();
            final boolean llllllllllIlllIIIllIlIIIIIIllIII = KillAura.target.isBlocking() && KillAura.target.isHandActive() && KillAura.target.isActiveItemStackBlocking(2) && KillAura.mc.player.getDistanceToEntity(KillAura.target) < KillAura.range.getNumberValue();
            GlStateManager.pushMatrix();
            GlStateManager.enableAlpha();
            DrawHelper.drawRectWithGlow(this.x2, this.y2, this.x2 + 100, this.y2 + 35, 7.0, 9.0, new Color(0, 0, 0, 150));
            DrawHelper.drawGradientRect(this.x2 - 3, this.y2 - 2.3f, this.x2 + 103, this.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
            Indicators.mc.neverlose500_13.drawStringWithShadow("KILL-AURA DEBUG ", this.x2 + 3, this.y2 + 5, -1);
            DrawHelper.drawCircle(this.x2 + 86.5f, (float)(this.y2 + 12), -95.0f, -95.0f + Indicators.mc.player.getCooledAttackStrength(0.5f) * 400.0f, 7.0f, 4.0f, false, ClientHelper.getClientColor());
            DrawHelper.drawNewRect(this.x2 + 3, this.y2 + 14, this.x2 + 3 + 3, this.y2 + 14 + 7, llllllllllIlllIIIllIlIIIIIIllIII ? new Color(0, 200, 0, 255).getRGB() : new Color(255, 0, 0, 255).getRGB());
            Indicators.mc.neverlose500_13.drawStringWithShadow("SHIELDED (" + llllllllllIlllIIIllIlIIIIIIllIII + ")", this.x2 + 8, this.y2 + 16, -1);
            Indicators.mc.neverlose500_13.drawStringWithShadow("WIN", this.x2 + 3, this.y2 + 27.5f, -1);
            DrawHelper.drawNewRect(this.x2 + 3 + 16, this.y2 + 26.0f, this.x2 + 16 + 3 + 40, this.y2 + 28.5f + 3.0f, new Color(100, 100, 100, 255).getRGB());
            DrawHelper.drawNewRect(this.x2 + 3 + 16, this.y2 + 26.0f, this.x2 + 16 + 3 + (llllllllllIlllIIIllIlIIIIIIllIlI ? ((Indicators.mc.player.getHealth() - KillAura.target.getHealth()) * 2.0f) : 2.0f), this.y2 + 28.5f + 3.0f, llllllllllIlllIIIllIlIIIIIIllIIl ? new Color(0, 200, 0, 255).getRGB() : new Color(255, 0, 0, 255).getRGB());
            GlStateManager.disableAlpha();
            GlStateManager.popMatrix();
        }
    }
}
