// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.ui.draggable.impl.DmgflyComponent;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.Main;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.client.features.impl.movement.DamageFly;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class DamageFlyIndicator extends Feature
{
    public static /* synthetic */ NumberSetting x;
    /* synthetic */ int x2;
    public static /* synthetic */ NumberSetting y;
    public static /* synthetic */ float indicatorTimer;
    /* synthetic */ int y2;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIlllllllIIIlIlIIIIIlI) {
        DamageFlyIndicator.indicatorTimer = (float)DamageFly.tick;
    }
    
    public DamageFlyIndicator() {
        super("DamageFlyIndicator", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u0440\u043e\u0446\u0435\u043d\u0442 \u0434\u043e \u043e\u043a\u043e\u043d\u0447\u0430\u043d\u0438\u044f \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u0442\u0430\u0439\u043c\u0435\u0440\u0430", 0, Category.DISPLAY);
        DamageFlyIndicator.x = new NumberSetting("Indicators X", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        DamageFlyIndicator.y = new NumberSetting("Indicators Y", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
    }
    
    @Override
    public void onEnable() {
        Main.featureDirector.getFeatureByClass(DamageFly.class).onToggle();
        Main.featureDirector.getFeatureByClass(DamageFly.class).onToggle();
        DamageFlyIndicator.indicatorTimer = 0.0f;
        super.onEnable();
    }
    
    @EventTarget
    public void ebatkopat(final Event2D lllllllllllIlllllllIIIlIlIIIIlIl) {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        this.x2 = DmgflyComponent.x2;
        this.y2 = DmgflyComponent.y2;
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(this.x2, this.y2, this.x2 + 45, this.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 140));
        DrawHelper.drawGradientRect1(this.x2 - 3.0f, this.y2 - 2.3f, this.x2 + 48, this.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        DamageFlyIndicator.mc.mntsb_19.drawStringWithShadow("DMGFLY", this.x2 + 1, this.y2 + 3, -1);
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
    }
}
