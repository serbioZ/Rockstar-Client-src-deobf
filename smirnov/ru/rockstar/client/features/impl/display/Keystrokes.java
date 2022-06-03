// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.ui.draggable.impl.KeystrokesComponent;
import ru.rockstar.api.event.event.EventRender2D;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Keystrokes extends Feature
{
    public static /* synthetic */ NumberSetting x;
    public /* synthetic */ int lastJ;
    public /* synthetic */ int lastA;
    public static /* synthetic */ NumberSetting y;
    public /* synthetic */ int lastD;
    public /* synthetic */ long deltaAnim;
    public /* synthetic */ int lastS2;
    public /* synthetic */ int lastW;
    public /* synthetic */ int lastS;
    
    @EventTarget
    public void onRender2D(final EventRender2D llllllllllllllIlIIlIlIllIlIIIIII) {
        final float llllllllllllllIlIIlIlIllIIllllll = (float)KeystrokesComponent.x;
        final float llllllllllllllIlIIlIlIllIIlllllI = (float)KeystrokesComponent.y;
        final boolean llllllllllllllIlIIlIlIllIIllllIl = Keystrokes.mc.gameSettings.keyBindLeft.pressed;
        final boolean llllllllllllllIlIIlIlIllIIllllII = Keystrokes.mc.gameSettings.keyBindForward.pressed;
        final boolean llllllllllllllIlIIlIlIllIIlllIll = Keystrokes.mc.gameSettings.keyBindBack.pressed;
        final boolean llllllllllllllIlIIlIlIllIIlllIlI = Keystrokes.mc.gameSettings.keyBindRight.pressed;
        final boolean llllllllllllllIlIIlIlIllIIlllIIl = Keystrokes.mc.gameSettings.keyBindJump.pressed;
        final boolean llllllllllllllIlIIlIlIllIIlllIII = Keystrokes.mc.gameSettings.keyBindSneak.pressed;
        final int llllllllllllllIlIIlIlIllIIllIlll = llllllllllllllIlIIlIlIllIIllllIl ? 255 : 0;
        final int llllllllllllllIlIIlIlIllIIllIllI = llllllllllllllIlIIlIlIllIIllllII ? 255 : 0;
        final int llllllllllllllIlIIlIlIllIIllIlIl = llllllllllllllIlIIlIlIllIIlllIll ? 255 : 0;
        final int llllllllllllllIlIIlIlIllIIllIlII = llllllllllllllIlIIlIlIllIIlllIlI ? 255 : 0;
        final int llllllllllllllIlIIlIlIllIIllIIll = llllllllllllllIlIIlIlIllIIlllIIl ? 255 : 0;
        final int llllllllllllllIlIIlIlIllIIllIIlI = llllllllllllllIlIIlIlIllIIlllIII ? 255 : 0;
        if (this.lastA != llllllllllllllIlIIlIlIllIIllIlll) {
            final float llllllllllllllIlIIlIlIllIIllIIIl = (float)(llllllllllllllIlIIlIlIllIIllIlll - this.lastA);
            this.lastA += (int)(llllllllllllllIlIIlIlIllIIllIIIl / 40.0f);
        }
        if (this.lastW != llllllllllllllIlIIlIlIllIIllIllI) {
            final float llllllllllllllIlIIlIlIllIIllIIII = (float)(llllllllllllllIlIIlIlIllIIllIllI - this.lastW);
            this.lastW += (int)(llllllllllllllIlIIlIlIllIIllIIII / 40.0f);
        }
        if (this.lastS != llllllllllllllIlIIlIlIllIIllIlIl) {
            final float llllllllllllllIlIIlIlIllIIlIllll = (float)(llllllllllllllIlIIlIlIllIIllIlIl - this.lastS);
            this.lastS += (int)(llllllllllllllIlIIlIlIllIIlIllll / 40.0f);
        }
        if (this.lastD != llllllllllllllIlIIlIlIllIIllIlII) {
            final float llllllllllllllIlIIlIlIllIIlIlllI = (float)(llllllllllllllIlIIlIlIllIIllIlII - this.lastD);
            this.lastD += (int)(llllllllllllllIlIIlIlIllIIlIlllI / 40.0f);
        }
        if (this.lastJ != llllllllllllllIlIIlIlIllIIllIIll) {
            final float llllllllllllllIlIIlIlIllIIlIllIl = (float)(llllllllllllllIlIIlIlIllIIllIIll - this.lastJ);
            this.lastJ += (int)(llllllllllllllIlIIlIlIllIIlIllIl / 40.0f);
        }
        if (this.lastS2 != llllllllllllllIlIIlIlIllIIllIIlI) {
            final float llllllllllllllIlIIlIlIllIIlIllII = (float)(llllllllllllllIlIIlIlIllIIllIIlI - this.lastS2);
            this.lastS2 += (int)(llllllllllllllIlIIlIlIllIIlIllII / 40.0f);
        }
        DrawHelper.drawRect(llllllllllllllIlIIlIlIllIIllllll, llllllllllllllIlIIlIlIllIIlllllI + 20.0f, llllllllllllllIlIIlIlIllIIllllll + 74.0f, llllllllllllllIlIIlIlIllIIlllllI + 74.0f, new Color(30, 30, 30, 255).getRGB());
        DrawHelper.drawGradientRect1(llllllllllllllIlIIlIlIllIIllllll - 2.0f, llllllllllllllIlIIlIlIllIIlllllI + 8.0f, llllllllllllllIlIIlIlIllIIllllll + 76.0f, llllllllllllllIlIIlIlIllIIlllllI + 22.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
        Keystrokes.mc.mntsb_16.drawStringWithShadow("Keystrokes", llllllllllllllIlIIlIlIllIIllllll + 12.0f, llllllllllllllIlIIlIlIllIIlllllI + 13.0f, -1);
        DrawHelper.drawRect(5.0f + llllllllllllllIlIIlIlIllIIllllll, 49.0f + llllllllllllllIlIIlIlIllIIlllllI, 25.0f + llllllllllllllIlIIlIlIllIIllllll, 69.0f + llllllllllllllIlIIlIlIllIIlllllI, new Color(this.lastA, this.lastA, this.lastA, 40).getRGB());
        Keystrokes.mc.mntsb_18.drawCenteredString("A", 15.0f + llllllllllllllIlIIlIlIllIIllllll, 56.0f + llllllllllllllIlIIlIlIllIIlllllI, ClientHelper.getClientColor().getRGB());
        DrawHelper.drawRect(27.0f + llllllllllllllIlIIlIlIllIIllllll, 27.0f + llllllllllllllIlIIlIlIllIIlllllI, 47.0f + llllllllllllllIlIIlIlIllIIllllll, 47.0f + llllllllllllllIlIIlIlIllIIlllllI, new Color(this.lastW, this.lastW, this.lastW, 40).getRGB());
        Keystrokes.mc.mntsb_18.drawCenteredString("W", 37.0f + llllllllllllllIlIIlIlIllIIllllll, 34.0f + llllllllllllllIlIIlIlIllIIlllllI, ClientHelper.getClientColor().getRGB());
        DrawHelper.drawRect(27.0f + llllllllllllllIlIIlIlIllIIllllll, 49.0f + llllllllllllllIlIIlIlIllIIlllllI, 47.0f + llllllllllllllIlIIlIlIllIIllllll, 69.0f + llllllllllllllIlIIlIlIllIIlllllI, new Color(this.lastS, this.lastS, this.lastS, 40).getRGB());
        Keystrokes.mc.mntsb_18.drawCenteredString("S", 37.0f + llllllllllllllIlIIlIlIllIIllllll, 56.0f + llllllllllllllIlIIlIlIllIIlllllI, ClientHelper.getClientColor().getRGB());
        DrawHelper.drawRect(49.0f + llllllllllllllIlIIlIlIllIIllllll, 49.0f + llllllllllllllIlIIlIlIllIIlllllI, 69.0f + llllllllllllllIlIIlIlIllIIllllll, 69.0f + llllllllllllllIlIIlIlIllIIlllllI, new Color(this.lastD, this.lastD, this.lastD, 40).getRGB());
        Keystrokes.mc.mntsb_18.drawCenteredString("D", 59.0f + llllllllllllllIlIIlIlIllIIllllll, 56.0f + llllllllllllllIlIIlIlIllIIlllllI, ClientHelper.getClientColor().getRGB());
    }
    
    public Keystrokes() {
        super("Keystrokes", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043d\u0430\u0436\u0430\u0442\u044b\u0435 \u043a\u043b\u0430\u0432\u0438\u0448\u0438", 0, Category.DISPLAY);
        this.lastA = 0;
        this.lastW = 0;
        this.lastS = 0;
        this.lastD = 0;
        this.lastJ = 0;
        this.lastS2 = 0;
        this.deltaAnim = 0L;
        Keystrokes.x = new NumberSetting("Indicators X", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
        Keystrokes.y = new NumberSetting("Indicators Y", 0.0f, 0.0f, 1500.0f, 1.0f, () -> true);
    }
}
