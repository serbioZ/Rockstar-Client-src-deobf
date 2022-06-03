// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui.component.impl;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.api.utils.render.AnimationHelper;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.csgui.component.PropertyComponent;
import ru.rockstar.client.ui.csgui.component.Component;

public class BooleanSettingComponent extends Component implements PropertyComponent
{
    public /* synthetic */ float textHoverAnimate;
    public /* synthetic */ float leftRectAnimation;
    public /* synthetic */ float rightRectAnimation;
    public /* synthetic */ BooleanSetting booleanSetting;
    /* synthetic */ Minecraft mc;
    
    @Override
    public void drawComponent(final ScaledResolution lllllllllllIlIIIlIIlIlIIlIllIllI, final int lllllllllllIlIIIlIIlIlIIlIlIlIII, final int lllllllllllIlIIIlIIlIlIIlIllIlII) {
        if (this.booleanSetting.isVisible()) {
            final int lllllllllllIlIIIlIIlIlIIlIllIIll = this.getX();
            final int lllllllllllIlIIIlIIlIlIIlIllIIlI = this.getY();
            final int lllllllllllIlIIIlIIlIlIIlIllIIIl = this.getWidth();
            final int lllllllllllIlIIIlIIlIlIIlIllIIII = this.getHeight();
            final int lllllllllllIlIIIlIIlIlIIlIlIllll = this.getHeight() / 2;
            final boolean lllllllllllIlIIIlIIlIlIIlIlIlllI = this.isHovered(lllllllllllIlIIIlIIlIlIIlIlIlIII, lllllllllllIlIIIlIIlIlIIlIllIlII);
            int lllllllllllIlIIIlIIlIlIIlIlIllIl = 0;
            final Color lllllllllllIlIIIlIIlIlIIlIlIllII = new Color(ClickGUI.color.getColorValue());
            final Color lllllllllllIlIIIlIIlIlIIlIlIlIll = new Color(ClickGUI.colorTwo.getColorValue());
            final double lllllllllllIlIIIlIIlIlIIlIlIlIlI = ClickGUI.speed.getNumberValue();
            final boolean lllllllllllIlIIIlIIlIlIIlIIlllII;
            switch (((String)(lllllllllllIlIIIlIIlIlIIlIIlllII = (boolean)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
                case -1808614770: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Static")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = lllllllllllIlIIIlIIlIlIIlIlIllII.getRGB();
                    break;
                }
                case -1656737386: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Rainbow")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = DrawHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                    break;
                }
                case -311641137: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Color Two")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = DrawHelper.fadeColor(lllllllllllIlIIIlIIlIlIIlIlIllII.getRGB(), lllllllllllIlIIIlIIlIlIIlIlIlIll.getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIlIIIlIIlIlIIlIlIlIlI / lllllllllllIlIIIlIIlIlIIlIlIlIlI + lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIllIIII * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                    break;
                }
                case 2181788: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Fade")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = DrawHelper.fadeColor(lllllllllllIlIIIlIIlIlIIlIlIllII.getRGB(), lllllllllllIlIIIlIIlIlIIlIlIllII.darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIlIIIlIIlIlIIlIlIlIlI / lllllllllllIlIIIlIIlIlIIlIlIlIlI + lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIllIIII * 6L / 60.0f * 2.0f) % 2.0 - 1.0));
                    break;
                }
                case 961091784: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Astolfo")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = DrawHelper.astolfo(true, lllllllllllIlIIIlIIlIlIIlIllIIlI).getRGB();
                    break;
                }
                case 2021122027: {
                    if (!((String)lllllllllllIlIIIlIIlIlIIlIIlllII).equals("Client")) {
                        break;
                    }
                    lllllllllllIlIIIlIIlIlIIlIlIllIl = DrawHelper.fadeColor(ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().darker().getRGB(), (float)Math.abs((System.currentTimeMillis() / lllllllllllIlIIIlIIlIlIIlIlIlIlI / lllllllllllIlIIIlIIlIlIIlIlIlIlI + lllllllllllIlIIIlIIlIlIIlIllIIlI * 6L / 60L * 2L) % 2.0 - 1.0));
                    break;
                }
            }
            this.mc.neverlose500_13.drawString(this.getName(), (float)(lllllllllllIlIIIlIIlIlIIlIllIIll + 3), (float)(lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIlIllll - 2), Color.GRAY.getRGB());
            this.textHoverAnimate = AnimationHelper.animation(this.textHoverAnimate, lllllllllllIlIIIlIIlIlIIlIlIlllI ? 2.3f : 2.0f, 0.0f);
            this.leftRectAnimation = AnimationHelper.animation(this.leftRectAnimation, (float)(this.booleanSetting.getBoolValue() ? 10 : 17), 0.0f);
            this.rightRectAnimation = AnimationHelper.animation(this.rightRectAnimation, (float)(this.booleanSetting.getBoolValue() ? 3 : 10), 0.0f);
            DrawHelper.drawSmoothRect((float)(lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - 16), (float)(lllllllllllIlIIIlIIlIlIIlIllIIlI + 5), lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - 5.0f, lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIllIIII - 6.4f, new Color(0, 0, 0, 255).getRGB());
            DrawHelper.drawCircle((float)(lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - 15), lllllllllllIlIIIlIIlIlIIlIllIIlI + 8.5f, 0.0f, 360.0f, 3.5f, 2.0f, true, new Color(0, 0, 0, 255));
            DrawHelper.drawCircle((float)(lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - 7), lllllllllllIlIIIlIIlIlIIlIllIIlI + 8.5f, 0.0f, 360.0f, 3.5f, 2.0f, true, new Color(0, 0, 0, 255));
            if (this.booleanSetting.getBoolValue()) {
                DrawHelper.drawCircle(lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - this.leftRectAnimation + 2.5f, lllllllllllIlIIIlIIlIlIIlIllIIlI + 8.5f, 0.0f, 360.0f, 4.0f, 1.0f, true, new Color(lllllllllllIlIIIlIIlIlIIlIlIllIl));
                if (ClickGUI.glow.getBoolValue()) {
                    DrawHelper.drawGlow(lllllllllllIlIIIlIIlIlIIlIllIIll - 1 + lllllllllllIlIIIlIIlIlIIlIllIIIl - this.leftRectAnimation + 2.5f, lllllllllllIlIIIlIIlIlIIlIllIIlI - 6 + 8.5f, lllllllllllIlIIIlIIlIlIIlIllIIll + 1 + lllllllllllIlIIIlIIlIlIIlIllIIIl - this.leftRectAnimation + 2.5f, lllllllllllIlIIIlIIlIlIIlIllIIlI + 6 + 8.5f, new Color(lllllllllllIlIIIlIIlIlIIlIlIllIl).getRGB());
                }
            }
            else {
                DrawHelper.drawCircle(lllllllllllIlIIIlIIlIlIIlIllIIll + lllllllllllIlIIIlIIlIlIIlIllIIIl - this.leftRectAnimation + 2.5f, lllllllllllIlIIIlIIlIlIIlIllIIlI + 8.5f, 0.0f, 360.0f, 4.0f, 1.0f, true, new Color(100, 100, 100, 255));
            }
            if (lllllllllllIlIIIlIIlIlIIlIlIlllI && this.booleanSetting.getDesc() != null) {
                DrawHelper.drawNewRect(lllllllllllIlIIIlIIlIlIIlIllIIll + 120, lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIllIIII / 1.5f + 3.5f, lllllllllllIlIIIlIIlIlIIlIllIIll + 138 + Minecraft.fontRendererObj.getStringWidth(this.booleanSetting.getDesc()) - 10, lllllllllllIlIIIlIIlIlIIlIllIIlI + 3.5f, new Color(30, 30, 30, 255).getRGB());
                this.mc.neverlose500_13.drawStringWithShadow(this.booleanSetting.getDesc(), lllllllllllIlIIIlIIlIlIIlIllIIll + 124, lllllllllllIlIIIlIIlIlIIlIllIIlI + lllllllllllIlIIIlIIlIlIIlIllIIII / 1.5f - 6.0f, -1);
            }
        }
    }
    
    @Override
    public Setting getSetting() {
        return this.booleanSetting;
    }
    
    public BooleanSettingComponent(final Component lllllllllllIlIIIlIIlIlIIllIlIIlI, final BooleanSetting lllllllllllIlIIIlIIlIlIIllIlIIIl, final int lllllllllllIlIIIlIIlIlIIllIIlIIl, final int lllllllllllIlIIIlIIlIlIIllIIlIII, final int lllllllllllIlIIIlIIlIlIIllIIlllI, final int lllllllllllIlIIIlIIlIlIIllIIIllI) {
        super(lllllllllllIlIIIlIIlIlIIllIlIIlI, lllllllllllIlIIIlIIlIlIIllIlIIIl.getName(), lllllllllllIlIIIlIIlIlIIllIIlIIl, lllllllllllIlIIIlIIlIlIIllIIlIII, lllllllllllIlIIIlIIlIlIIllIIlllI, lllllllllllIlIIIlIIlIlIIllIIIllI);
        this.textHoverAnimate = 0.0f;
        this.leftRectAnimation = 0.0f;
        this.rightRectAnimation = 0.0f;
        this.mc = Minecraft.getMinecraft();
        this.booleanSetting = lllllllllllIlIIIlIIlIlIIllIlIIIl;
    }
    
    @Override
    public void onMouseClick(final int lllllllllllIlIIIlIIlIlIIlIIlIllI, final int lllllllllllIlIIIlIIlIlIIlIIlIIIl, final int lllllllllllIlIIIlIIlIlIIlIIlIlII) {
        if (lllllllllllIlIIIlIIlIlIIlIIlIlII == 0 && this.isHovered(lllllllllllIlIIIlIIlIlIIlIIlIllI, lllllllllllIlIIIlIIlIlIIlIIlIIIl) && this.booleanSetting.isVisible()) {
            this.booleanSetting.setBoolValue(!this.booleanSetting.getBoolValue());
        }
    }
}
