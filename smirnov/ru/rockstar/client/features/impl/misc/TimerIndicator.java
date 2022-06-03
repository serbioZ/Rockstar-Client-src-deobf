// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.Main;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.client.features.impl.movement.Timer;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.ui.draggable.impl.TimerComponent;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class TimerIndicator extends Feature
{
    /* synthetic */ int x2;
    public static /* synthetic */ NumberSetting x;
    public static /* synthetic */ NumberSetting y;
    /* synthetic */ int y2;
    public static /* synthetic */ float indicatorTimer;
    
    public TimerIndicator() {
        super("TimerIndicator", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u0440\u043e\u0446\u0435\u043d\u0442 \u0444\u043b\u0430\u0433\u0430 \u0442\u0430\u0439\u043c\u0435\u0440\u0430", 0, Category.DISPLAY);
        TimerIndicator.x = new NumberSetting("Indicators X", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        TimerIndicator.y = new NumberSetting("Indicators Y", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
    }
    
    @EventTarget
    public void ebatkopat(final Event2D lllllllllllIllllllIIIlIlIIlIIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        this.x2 = TimerComponent.x;
        this.y2 = TimerComponent.y;
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(this.x2, this.y2, this.x2 + 45, this.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 150));
        DrawHelper.drawGradientRect1(this.x2 - 3, this.y2 - 2.3f, this.x2 + 48, this.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        TimerIndicator.mc.mntsb_19.drawStringWithShadow("TIMER ", this.x2 + 6, this.y2 + 3, -1);
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
    }
    
    @Override
    public void onEnable() {
        Main.featureDirector.getFeatureByClass(Timer.class).onToggle();
        Main.featureDirector.getFeatureByClass(Timer.class).onToggle();
        TimerIndicator.indicatorTimer = 0.0f;
        super.onEnable();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIllllllIIIlIlIIIlllIl) {
        if (Main.featureDirector.getFeatureByClass(Timer.class).isToggled()) {
            TimerIndicator.indicatorTimer = (float)Timer.tick;
        }
        else {
            if (TimerIndicator.indicatorTimer >= 0.0f && !MovementHelper.isMoving()) {
                TimerIndicator.indicatorTimer -= 0.5;
            }
            else if (TimerIndicator.indicatorTimer >= 0.0f) {
                if (MovementHelper.isMoving()) {
                    TimerIndicator.indicatorTimer -= (float)0.2;
                }
                if (TimerIndicator.mc.player.motionY > 0.0) {
                    TimerIndicator.indicatorTimer -= (float)TimerIndicator.mc.player.motionY;
                }
                if (TimerIndicator.mc.player.motionY < 0.0) {
                    TimerIndicator.indicatorTimer -= (float)TimerIndicator.mc.player.motionY;
                }
            }
            if (TimerIndicator.indicatorTimer < 0.0f) {
                TimerIndicator.indicatorTimer = 0.0f;
            }
        }
    }
}
