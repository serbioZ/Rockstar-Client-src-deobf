// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import ru.rockstar.client.features.impl.movement.DamageFly;
import ru.rockstar.client.features.impl.display.DamageFlyIndicator;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class DmgflyComponent extends DraggableModule
{
    public static /* synthetic */ int y2;
    public static /* synthetic */ int x2;
    
    @Override
    public int getHeight() {
        return 100;
    }
    
    public DmgflyComponent() {
        super("TimerComponent", DmgflyComponent.sr.getScaledWidth() - 300, DmgflyComponent.sr.getScaledHeight() - 200);
    }
    
    @Override
    public void draw() {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        DmgflyComponent.x2 = this.getX();
        DmgflyComponent.y2 = this.getY();
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(DmgflyComponent.x2, DmgflyComponent.y2, DmgflyComponent.x2 + 45, DmgflyComponent.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 140));
        DrawHelper.drawGradientRect1(DmgflyComponent.x2 - 3.0f, DmgflyComponent.y2 - 2.3f, DmgflyComponent.x2 + 48, DmgflyComponent.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_19.drawStringWithShadow("DMGFLY", DmgflyComponent.x2 + 1, DmgflyComponent.y2 + 3, -1);
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 0.0f, 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        super.draw();
    }
    
    @Override
    public int getWidth() {
        return 100;
    }
    
    @Override
    public void render(final int llllllllllllIlIIlIIIIllIIlllIIIl, final int llllllllllllIlIIlIIIIllIIllIllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.enableTexture2D();
        DmgflyComponent.x2 = this.getX();
        DmgflyComponent.y2 = this.getY();
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        DrawHelper.drawRectWithGlow(DmgflyComponent.x2, DmgflyComponent.y2, DmgflyComponent.x2 + 45, DmgflyComponent.y2 + 40, 7.0, 9.0, new Color(0, 0, 0, 140));
        DrawHelper.drawGradientRect1(DmgflyComponent.x2 - 3.0f, DmgflyComponent.y2 - 2.3f, DmgflyComponent.x2 + 48, DmgflyComponent.y2, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        this.mc.mntsb_19.drawStringWithShadow("DMGFLY", DmgflyComponent.x2 + 1, DmgflyComponent.y2 + 3, -1);
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 0.0f, 400.0f, 9.0f, 5.5f, false, new Color(50, 50, 50, 150));
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks) + 10.0f, 9.0f, 5.5f, false, new Color(-1));
        DrawHelper.drawCircle(DmgflyComponent.x2 + 21.5f, (float)(DmgflyComponent.y2 + 25), 0.0f, 400.0f - DamageFlyIndicator.indicatorTimer * (400 / DamageFly.ticks), 9.0f, 5.5f, false, ClientHelper.getClientColor());
        GlStateManager.popMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        super.render(llllllllllllIlIIlIIIIllIIlllIIIl, llllllllllllIlIIlIIIIllIIllIllIl);
    }
}
