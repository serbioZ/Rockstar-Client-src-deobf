// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import ru.rockstar.client.features.impl.movement.Timer;
import ru.rockstar.client.features.impl.misc.TimerIndicator;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class TimerComponent extends DraggableModule
{
    /* synthetic */ int y2;
    public static /* synthetic */ int x;
    public static /* synthetic */ int y;
    /* synthetic */ int x2;
    
    public TimerComponent() {
        super("TimerComponent", TimerComponent.sr.getScaledWidth() - 100, TimerComponent.sr.getScaledHeight() - 20);
    }
    
    @Override
    public void render(final int lllllllllllIllIIIllIlIllIllllIlI, final int lllllllllllIllIIIllIlIllIlllIllI) {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        this.x2 = this.getX();
        this.y2 = this.getY();
        TimerComponent.x = this.getX();
        TimerComponent.y = this.getY();
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(this.x2, this.y2, this.x2 + 45, this.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 150));
        DrawHelper.drawGradientRect1(this.x2 - 3, this.y2 - 2.3f, this.x2 + 48, this.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_19.drawStringWithShadow("TIMER ", this.x2 + 6, this.y2 + 3, -1);
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        super.render(lllllllllllIllIIIllIlIllIllllIlI, lllllllllllIllIIIllIlIllIlllIllI);
    }
    
    @Override
    public int getHeight() {
        return 100;
    }
    
    @Override
    public int getWidth() {
        return 100;
    }
    
    @Override
    public void draw() {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        this.x2 = this.getX();
        TimerComponent.x = this.getX();
        TimerComponent.y = this.getY();
        this.y2 = this.getY();
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(this.x2, this.y2, this.x2 + 45, this.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 150));
        DrawHelper.drawGradientRect1(this.x2 - 3, this.y2 - 2.3f, this.x2 + 48, this.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_19.drawStringWithShadow("TIMER ", this.x2 + 6, this.y2 + 3, -1);
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(this.x2 + 21.5f, (float)(this.y2 + 25), 0.0f, 400.0f - TimerIndicator.indicatorTimer * (400 / Timer.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        super.draw();
    }
}
