// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.draggable.impl;

import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.display.Keystrokes;
import ru.rockstar.Main;
import ru.rockstar.client.ui.draggable.DraggableModule;

public class KeystrokesComponent extends DraggableModule
{
    public static /* synthetic */ int y;
    public /* synthetic */ int lastA;
    public /* synthetic */ int lastS;
    public static /* synthetic */ int x;
    public /* synthetic */ int lastW;
    public /* synthetic */ int lastS2;
    public /* synthetic */ int lastJ;
    public /* synthetic */ int lastD;
    
    @Override
    public void render(final int lllllllllllIlIlIlIIlIIlllllIIIIl, final int lllllllllllIlIlIlIIlIIlllllIIIII) {
        if (Main.featureDirector.getFeatureByClass(Keystrokes.class).isToggled()) {
            GlStateManager.pushMatrix();
            GlStateManager.enableTexture2D();
            this.drag.setCanRender(true);
            KeystrokesComponent.x = this.getX();
            KeystrokesComponent.y = this.getY();
            final float lllllllllllIlIlIlIIlIIllllIlllll = (float)this.getX();
            final float lllllllllllIlIlIlIIlIIllllIllllI = (float)this.getY();
            final boolean lllllllllllIlIlIlIIlIIllllIlllIl = this.mc.gameSettings.keyBindLeft.pressed;
            final boolean lllllllllllIlIlIlIIlIIllllIlllII = this.mc.gameSettings.keyBindForward.pressed;
            final boolean lllllllllllIlIlIlIIlIIllllIllIll = this.mc.gameSettings.keyBindBack.pressed;
            final boolean lllllllllllIlIlIlIIlIIllllIllIlI = this.mc.gameSettings.keyBindRight.pressed;
            final boolean lllllllllllIlIlIlIIlIIllllIllIIl = this.mc.gameSettings.keyBindJump.pressed;
            final boolean lllllllllllIlIlIlIIlIIllllIllIII = this.mc.gameSettings.keyBindSneak.pressed;
            final int lllllllllllIlIlIlIIlIIllllIlIlll = lllllllllllIlIlIlIIlIIllllIlllIl ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIllllIlIllI = lllllllllllIlIlIlIIlIIllllIlllII ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIllllIlIlIl = lllllllllllIlIlIlIIlIIllllIllIll ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIllllIlIlII = lllllllllllIlIlIlIIlIIllllIllIlI ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIllllIlIIll = lllllllllllIlIlIlIIlIIllllIllIIl ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIllllIlIIlI = lllllllllllIlIlIlIIlIIllllIllIII ? 255 : 0;
            if (this.lastA != lllllllllllIlIlIlIIlIIllllIlIlll) {
                final float lllllllllllIlIlIlIIlIIllllIlIIIl = (float)(lllllllllllIlIlIlIIlIIllllIlIlll - this.lastA);
                this.lastA += (int)(lllllllllllIlIlIlIIlIIllllIlIIIl / 40.0f);
            }
            if (this.lastW != lllllllllllIlIlIlIIlIIllllIlIllI) {
                final float lllllllllllIlIlIlIIlIIllllIlIIII = (float)(lllllllllllIlIlIlIIlIIllllIlIllI - this.lastW);
                this.lastW += (int)(lllllllllllIlIlIlIIlIIllllIlIIII / 40.0f);
            }
            if (this.lastS != lllllllllllIlIlIlIIlIIllllIlIlIl) {
                final float lllllllllllIlIlIlIIlIIllllIIllll = (float)(lllllllllllIlIlIlIIlIIllllIlIlIl - this.lastS);
                this.lastS += (int)(lllllllllllIlIlIlIIlIIllllIIllll / 40.0f);
            }
            if (this.lastD != lllllllllllIlIlIlIIlIIllllIlIlII) {
                final float lllllllllllIlIlIlIIlIIllllIIlllI = (float)(lllllllllllIlIlIlIIlIIllllIlIlII - this.lastD);
                this.lastD += (int)(lllllllllllIlIlIlIIlIIllllIIlllI / 40.0f);
            }
            if (this.lastJ != lllllllllllIlIlIlIIlIIllllIlIIll) {
                final float lllllllllllIlIlIlIIlIIllllIIllIl = (float)(lllllllllllIlIlIlIIlIIllllIlIIll - this.lastJ);
                this.lastJ += (int)(lllllllllllIlIlIlIIlIIllllIIllIl / 40.0f);
            }
            if (this.lastS2 != lllllllllllIlIlIlIIlIIllllIlIIlI) {
                final float lllllllllllIlIlIlIIlIIllllIIllII = (float)(lllllllllllIlIlIlIIlIIllllIlIIlI - this.lastS2);
                this.lastS2 += (int)(lllllllllllIlIlIlIIlIIllllIIllII / 40.0f);
            }
            DrawHelper.drawRect(lllllllllllIlIlIlIIlIIllllIlllll, lllllllllllIlIlIlIIlIIllllIllllI + 20.0f, lllllllllllIlIlIlIIlIIllllIlllll + 74.0f, lllllllllllIlIlIlIIlIIllllIllllI + 74.0f, new Color(30, 30, 30, 255).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllIlIlIlIIlIIllllIlllll - 2.0f, lllllllllllIlIlIlIIlIIllllIllllI + 8.0f, lllllllllllIlIlIlIIlIIllllIlllll + 76.0f, lllllllllllIlIlIlIIlIIllllIllllI + 22.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
            this.mc.mntsb_16.drawStringWithShadow("Keystrokes", lllllllllllIlIlIlIIlIIllllIlllll + 12.0f, lllllllllllIlIlIlIIlIIllllIllllI + 13.0f, -1);
            DrawHelper.drawRect(5.0f + lllllllllllIlIlIlIIlIIllllIlllll, 49.0f + lllllllllllIlIlIlIIlIIllllIllllI, 25.0f + lllllllllllIlIlIlIIlIIllllIlllll, 69.0f + lllllllllllIlIlIlIIlIIllllIllllI, new Color(this.lastA, this.lastA, this.lastA, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("A", 15.0f + lllllllllllIlIlIlIIlIIllllIlllll, 56.0f + lllllllllllIlIlIlIIlIIllllIllllI, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(27.0f + lllllllllllIlIlIlIIlIIllllIlllll, 27.0f + lllllllllllIlIlIlIIlIIllllIllllI, 47.0f + lllllllllllIlIlIlIIlIIllllIlllll, 47.0f + lllllllllllIlIlIlIIlIIllllIllllI, new Color(this.lastW, this.lastW, this.lastW, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("W", 37.0f + lllllllllllIlIlIlIIlIIllllIlllll, 34.0f + lllllllllllIlIlIlIIlIIllllIllllI, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(27.0f + lllllllllllIlIlIlIIlIIllllIlllll, 49.0f + lllllllllllIlIlIlIIlIIllllIllllI, 47.0f + lllllllllllIlIlIlIIlIIllllIlllll, 69.0f + lllllllllllIlIlIlIIlIIllllIllllI, new Color(this.lastS, this.lastS, this.lastS, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("S", 37.0f + lllllllllllIlIlIlIIlIIllllIlllll, 56.0f + lllllllllllIlIlIlIIlIIllllIllllI, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(49.0f + lllllllllllIlIlIlIIlIIllllIlllll, 49.0f + lllllllllllIlIlIlIIlIIllllIllllI, 69.0f + lllllllllllIlIlIlIIlIIllllIlllll, 69.0f + lllllllllllIlIlIlIIlIIllllIllllI, new Color(this.lastD, this.lastD, this.lastD, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("D", 59.0f + lllllllllllIlIlIlIIlIIllllIlllll, 56.0f + lllllllllllIlIlIlIIlIIllllIllllI, ClientHelper.getClientColor().getRGB());
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
            GlStateManager.popMatrix();
        }
        super.render(lllllllllllIlIlIlIIlIIlllllIIIIl, lllllllllllIlIlIlIIlIIlllllIIIII);
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
        if (Main.featureDirector.getFeatureByClass(Keystrokes.class).isToggled()) {
            GlStateManager.pushMatrix();
            GlStateManager.enableTexture2D();
            final float lllllllllllIlIlIlIIlIIlllIlIlIII = (float)this.getX();
            final float lllllllllllIlIlIlIIlIIlllIlIIlll = (float)this.getY();
            KeystrokesComponent.x = this.getX();
            KeystrokesComponent.y = this.getY();
            final boolean lllllllllllIlIlIlIIlIIlllIlIIllI = this.mc.gameSettings.keyBindLeft.pressed;
            final boolean lllllllllllIlIlIlIIlIIlllIlIIlIl = this.mc.gameSettings.keyBindForward.pressed;
            final boolean lllllllllllIlIlIlIIlIIlllIlIIlII = this.mc.gameSettings.keyBindBack.pressed;
            final boolean lllllllllllIlIlIlIIlIIlllIlIIIll = this.mc.gameSettings.keyBindRight.pressed;
            final boolean lllllllllllIlIlIlIIlIIlllIlIIIlI = this.mc.gameSettings.keyBindJump.pressed;
            final boolean lllllllllllIlIlIlIIlIIlllIlIIIIl = this.mc.gameSettings.keyBindSneak.pressed;
            final int lllllllllllIlIlIlIIlIIlllIlIIIII = lllllllllllIlIlIlIIlIIlllIlIIllI ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIlllIIlllll = lllllllllllIlIlIlIIlIIlllIlIIlIl ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIlllIIllllI = lllllllllllIlIlIlIIlIIlllIlIIlII ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIlllIIlllIl = lllllllllllIlIlIlIIlIIlllIlIIIll ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIlllIIlllII = lllllllllllIlIlIlIIlIIlllIlIIIlI ? 255 : 0;
            final int lllllllllllIlIlIlIIlIIlllIIllIll = lllllllllllIlIlIlIIlIIlllIlIIIIl ? 255 : 0;
            if (this.lastA != lllllllllllIlIlIlIIlIIlllIlIIIII) {
                final float lllllllllllIlIlIlIIlIIlllIIllIlI = (float)(lllllllllllIlIlIlIIlIIlllIlIIIII - this.lastA);
                this.lastA += (int)(lllllllllllIlIlIlIIlIIlllIIllIlI / 40.0f);
            }
            if (this.lastW != lllllllllllIlIlIlIIlIIlllIIlllll) {
                final float lllllllllllIlIlIlIIlIIlllIIllIIl = (float)(lllllllllllIlIlIlIIlIIlllIIlllll - this.lastW);
                this.lastW += (int)(lllllllllllIlIlIlIIlIIlllIIllIIl / 40.0f);
            }
            if (this.lastS != lllllllllllIlIlIlIIlIIlllIIllllI) {
                final float lllllllllllIlIlIlIIlIIlllIIllIII = (float)(lllllllllllIlIlIlIIlIIlllIIllllI - this.lastS);
                this.lastS += (int)(lllllllllllIlIlIlIIlIIlllIIllIII / 40.0f);
            }
            if (this.lastD != lllllllllllIlIlIlIIlIIlllIIlllIl) {
                final float lllllllllllIlIlIlIIlIIlllIIlIlll = (float)(lllllllllllIlIlIlIIlIIlllIIlllIl - this.lastD);
                this.lastD += (int)(lllllllllllIlIlIlIIlIIlllIIlIlll / 40.0f);
            }
            if (this.lastJ != lllllllllllIlIlIlIIlIIlllIIlllII) {
                final float lllllllllllIlIlIlIIlIIlllIIlIllI = (float)(lllllllllllIlIlIlIIlIIlllIIlllII - this.lastJ);
                this.lastJ += (int)(lllllllllllIlIlIlIIlIIlllIIlIllI / 40.0f);
            }
            if (this.lastS2 != lllllllllllIlIlIlIIlIIlllIIllIll) {
                final float lllllllllllIlIlIlIIlIIlllIIlIlIl = (float)(lllllllllllIlIlIlIIlIIlllIIllIll - this.lastS2);
                this.lastS2 += (int)(lllllllllllIlIlIlIIlIIlllIIlIlIl / 40.0f);
            }
            DrawHelper.drawRect(lllllllllllIlIlIlIIlIIlllIlIlIII, lllllllllllIlIlIlIIlIIlllIlIIlll + 20.0f, lllllllllllIlIlIlIIlIIlllIlIlIII + 74.0f, lllllllllllIlIlIlIIlIIlllIlIIlll + 74.0f, new Color(30, 30, 30, 255).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllIlIlIlIIlIIlllIlIlIII - 2.0f, lllllllllllIlIlIlIIlIIlllIlIIlll + 8.0f, lllllllllllIlIlIlIIlIIlllIlIlIII + 76.0f, lllllllllllIlIlIlIIlIIlllIlIIlll + 22.0f, ClientHelper.getClientColor().getRGB(), ClientHelper.getClientColor().getRGB() - 100);
            this.mc.mntsb_16.drawStringWithShadow("Keystrokes", lllllllllllIlIlIlIIlIIlllIlIlIII + 12.0f, lllllllllllIlIlIlIIlIIlllIlIIlll + 13.0f, -1);
            DrawHelper.drawRect(5.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 49.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, 25.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 69.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, new Color(this.lastA, this.lastA, this.lastA, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("A", 15.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 56.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(27.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 27.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, 47.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 47.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, new Color(this.lastW, this.lastW, this.lastW, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("W", 37.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 34.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(27.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 49.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, 47.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 69.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, new Color(this.lastS, this.lastS, this.lastS, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("S", 37.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 56.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, ClientHelper.getClientColor().getRGB());
            DrawHelper.drawRect(49.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 49.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, 69.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 69.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, new Color(this.lastD, this.lastD, this.lastD, 40).getRGB());
            this.mc.mntsb_18.drawCenteredString("D", 59.0f + lllllllllllIlIlIlIIlIIlllIlIlIII, 56.0f + lllllllllllIlIlIlIIlIIlllIlIIlll, ClientHelper.getClientColor().getRGB());
            GlStateManager.enableDepth();
            GlStateManager.disableLighting();
            GlStateManager.popMatrix();
        }
        super.draw();
    }
    
    public KeystrokesComponent() {
        super("KeystrokesComponent", 100, 100);
        this.lastA = 0;
        this.lastW = 0;
        this.lastS = 0;
        this.lastD = 0;
        this.lastJ = 0;
        this.lastS2 = 0;
    }
}
