// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui.component.impl;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.clickgui.component.PropertyComponent;
import ru.rockstar.client.ui.clickgui.component.Component;

public class BooleanSettingComponent extends Component implements PropertyComponent
{
    /* synthetic */ Minecraft mc;
    public /* synthetic */ BooleanSetting booleanSetting;
    public /* synthetic */ float textHoverAnimate;
    public /* synthetic */ float rightRectAnimation;
    public /* synthetic */ float leftRectAnimation;
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIIIIlIIIIllIlllIlIlIl, final int lllllllllllIIIIlIIIIllIlllIIIlll, final int lllllllllllIIIIlIIIIllIlllIlIIll) {
        if (this.booleanSetting.isVisible()) {
            final int lllllllllllIIIIlIIIIllIlllIlIIlI = this.getX();
            final int lllllllllllIIIIlIIIIllIlllIlIIIl = this.getY();
            final int lllllllllllIIIIlIIIIllIlllIlIIII = this.getWidth();
            final int lllllllllllIIIIlIIIIllIlllIIllll = this.getHeight();
            final int lllllllllllIIIIlIIIIllIlllIIlllI = this.getHeight() / 2;
            final boolean lllllllllllIIIIlIIIIllIlllIIllIl = this.isHovered(lllllllllllIIIIlIIIIllIlllIIIlll, lllllllllllIIIIlIIIIllIlllIlIIll);
            int lllllllllllIIIIlIIIIllIlllIIllII = 0;
            final Color lllllllllllIIIIlIIIIllIlllIIlIll = new Color(ClickGUI.color.getColorValue());
            final Color lllllllllllIIIIlIIIIllIlllIIlIlI = new Color(ClickGUI.colorTwo.getColorValue());
            final double lllllllllllIIIIlIIIIllIlllIIlIIl = ClickGUI.speed.getNumberValue();
            final String lllllllllllIIIIlIIIIllIllIlllIll;
            switch (lllllllllllIIIIlIIIIllIllIlllIll = ClickGUI.clickGuiColor.currentMode) {
                case "Static": {
                    lllllllllllIIIIlIIIIllIlllIIllII = lllllllllllIIIIlIIIIllIlllIIlIll.getRGB();
                    break;
                }
                case "Rainbow": {
                    lllllllllllIIIIlIIIIllIlllIIllII = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                    break;
                }
                case "Color Two": {
                    lllllllllllIIIIlIIIIllIlllIIllII = DrawHelper.fadeColor(lllllllllllIIIIlIIIIllIlllIIlIll.getRGB(), lllllllllllIIIIlIIIIllIlllIIlIlI.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIIlIIIIllIlllIIlIIl / lllllllllllIIIIlIIIIllIlllIIlIIl + lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIllll * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                    break;
                }
                case "Fade": {
                    lllllllllllIIIIlIIIIllIlllIIllII = DrawHelper.fadeColor(lllllllllllIIIIlIIIIllIlllIIlIll.getRGB(), lllllllllllIIIIlIIIIllIlllIIlIll.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIIlIIIIllIlllIIlIIl / lllllllllllIIIIlIIIIllIlllIIlIIl + lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIllll * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                    break;
                }
                case "Astolfo": {
                    lllllllllllIIIIlIIIIllIlllIIllII = DrawHelper.astolfo(true, lllllllllllIIIIlIIIIllIlllIlIIIl).getRGB();
                    break;
                }
                case "Client": {
                    lllllllllllIIIIlIIIIllIlllIIllII = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIIIIlIIIIllIlllIIlIIl / lllllllllllIIIIlIIIIllIlllIIlIIl + lllllllllllIIIIlIIIIllIlllIlIIIl * 6L / 60L * 2L) % 2.0 - 1.0));
                    break;
                }
                default:
                    break;
            }
            this.mc.neverlose500_13.drawString(this.getName(), (float)(lllllllllllIIIIlIIIIllIlllIlIIlI + 3), (float)(lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIlllI - 2), Color.GRAY.getRGB());
            this.textHoverAnimate = AnimationHelper.animation(this.textHoverAnimate, lllllllllllIIIIlIIIIllIlllIIllIl ? 2.3f : 2.0f, 0.0f);
            this.leftRectAnimation = AnimationHelper.animation(this.leftRectAnimation, (float)(this.booleanSetting.getBoolValue() ? 10 : 17), 0.0f);
            this.rightRectAnimation = AnimationHelper.animation(this.rightRectAnimation, (float)(this.booleanSetting.getBoolValue() ? 3 : 10), 0.0f);
            DrawHelper.drawSmoothRect((float)(lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - 16), (float)(lllllllllllIIIIlIIIIllIlllIlIIIl + 5), lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - 5.0f, lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIllll - 6.4f, new Color(0, 0, 0, 255).getRGB());
            DrawHelper.drawCircle((float)(lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - 15), lllllllllllIIIIlIIIIllIlllIlIIIl + 8.5f, 0.0f, 360.0f, 3.5f, 2.0f, true, new Color(0, 0, 0, 255));
            DrawHelper.drawCircle((float)(lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - 7), lllllllllllIIIIlIIIIllIlllIlIIIl + 8.5f, 0.0f, 360.0f, 3.5f, 2.0f, true, new Color(0, 0, 0, 255));
            if (this.booleanSetting.getBoolValue()) {
                DrawHelper.drawCircle(lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - this.leftRectAnimation + 2.5f, lllllllllllIIIIlIIIIllIlllIlIIIl + 8.5f, 0.0f, 360.0f, 4.0f, 1.0f, true, new Color(lllllllllllIIIIlIIIIllIlllIIllII));
                if (ClickGUI.glow.getBoolValue()) {
                    DrawHelper.drawGlow(lllllllllllIIIIlIIIIllIlllIlIIlI - 1 + lllllllllllIIIIlIIIIllIlllIlIIII - this.leftRectAnimation + 2.5f, lllllllllllIIIIlIIIIllIlllIlIIIl - 6 + 8.5f, lllllllllllIIIIlIIIIllIlllIlIIlI + 1 + lllllllllllIIIIlIIIIllIlllIlIIII - this.leftRectAnimation + 2.5f, lllllllllllIIIIlIIIIllIlllIlIIIl + 6 + 8.5f, new Color(lllllllllllIIIIlIIIIllIlllIIllII).getRGB());
                }
            }
            else {
                DrawHelper.drawCircle(lllllllllllIIIIlIIIIllIlllIlIIlI + lllllllllllIIIIlIIIIllIlllIlIIII - this.leftRectAnimation + 2.5f, lllllllllllIIIIlIIIIllIlllIlIIIl + 8.5f, 0.0f, 360.0f, 4.0f, 1.0f, true, new Color(100, 100, 100, 255));
            }
            if (lllllllllllIIIIlIIIIllIlllIIllIl && this.booleanSetting.getDesc() != null) {
                DrawHelper.drawNewRect(lllllllllllIIIIlIIIIllIlllIlIIlI + 120, lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIllll / 1.5f + 3.5f, lllllllllllIIIIlIIIIllIlllIlIIlI + 138 + Minecraft.fontRendererObj.getStringWidth(this.booleanSetting.getDesc()) - 10, lllllllllllIIIIlIIIIllIlllIlIIIl + 3.5f, new Color(30, 30, 30, 255).getRGB());
                this.mc.neverlose500_13.drawStringWithShadow(this.booleanSetting.getDesc(), lllllllllllIIIIlIIIIllIlllIlIIlI + 124, lllllllllllIIIIlIIIIllIlllIlIIIl + lllllllllllIIIIlIIIIllIlllIIllll / 1.5f - 6.0f, -1);
            }
        }
    }
    
    @Override
    public Setting getSetting() {
        return this.booleanSetting;
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIIIIlIIIIllIllIllIlIl, final int lllllllllllIIIIlIIIIllIllIllIIII, final int lllllllllllIIIIlIIIIllIllIlIllll) {
        if (lllllllllllIIIIlIIIIllIllIlIllll == 0 && this.isHovered(lllllllllllIIIIlIIIIllIllIllIlIl, lllllllllllIIIIlIIIIllIllIllIIII) && this.booleanSetting.isVisible()) {
            this.booleanSetting.setBoolValue(!this.booleanSetting.getBoolValue());
        }
    }
    
    public BooleanSettingComponent(final Component lllllllllllIIIIlIIIIllIllllIlIlI, final BooleanSetting lllllllllllIIIIlIIIIllIlllllIIII, final int lllllllllllIIIIlIIIIllIllllIllll, final int lllllllllllIIIIlIIIIllIllllIlllI, final int lllllllllllIIIIlIIIIllIllllIllIl, final int lllllllllllIIIIlIIIIllIllllIIlIl) {
        super(lllllllllllIIIIlIIIIllIllllIlIlI, lllllllllllIIIIlIIIIllIlllllIIII.getName(), lllllllllllIIIIlIIIIllIllllIllll, lllllllllllIIIIlIIIIllIllllIlllI, lllllllllllIIIIlIIIIllIllllIllIl, lllllllllllIIIIlIIIIllIllllIIlIl);
        this.textHoverAnimate = 0.0f;
        this.leftRectAnimation = 0.0f;
        this.rightRectAnimation = 0.0f;
        this.mc = Minecraft.getMinecraft();
        this.booleanSetting = lllllllllllIIIIlIIIIllIlllllIIII;
    }
}
