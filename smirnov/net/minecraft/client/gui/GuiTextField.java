// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import com.google.common.base.Predicates;
import net.minecraft.util.math.MathHelper;
import ru.rockstar.api.utils.render.AnimationHelper;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.util.ChatAllowedCharacters;
import com.google.common.base.Predicate;

public class GuiTextField extends Gui
{
    private final /* synthetic */ int height;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ Predicate<String> validator;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean enableBackgroundDrawing;
    /* synthetic */ float xd;
    private /* synthetic */ String text;
    private final /* synthetic */ int id;
    private /* synthetic */ int disabledColor;
    public /* synthetic */ int yPosition;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ boolean isFocused;
    private /* synthetic */ int maxStringLength;
    private final /* synthetic */ FontRenderer fontRendererInstance;
    private /* synthetic */ int cursorPosition;
    private final /* synthetic */ int width;
    private /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    private /* synthetic */ int cursorCounter;
    public /* synthetic */ int xPosition;
    private /* synthetic */ int lineScrollOffset;
    private /* synthetic */ boolean isEnabled;
    
    public int getNthWordFromCursor(final int llllllllllllIIIIllIllIIIlIllIIll) {
        return this.getNthWordFromPos(llllllllllllIIIIllIllIIIlIllIIll, this.getCursorPosition());
    }
    
    public void setText(final String llllllllllllIIIIllIllIIlIIIIlIII) {
        if (this.validator.apply((Object)llllllllllllIIIIllIllIIlIIIIlIII)) {
            if (llllllllllllIIIIllIllIIlIIIIlIII.length() > this.maxStringLength) {
                this.text = llllllllllllIIIIllIllIIlIIIIlIII.substring(0, this.maxStringLength);
            }
            else {
                this.text = llllllllllllIIIIllIllIIlIIIIlIII;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void writeText(final String llllllllllllIIIIllIllIIIlllIllII) {
        String llllllllllllIIIIllIllIIIlllIlIll = "";
        final String llllllllllllIIIIllIllIIIlllIlIlI = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllIIIIllIllIIIlllIllII);
        final int llllllllllllIIIIllIllIIIlllIlIIl = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllIIIIllIllIIIlllIlIII = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llllllllllllIIIIllIllIIIlllIIlll = this.maxStringLength - this.text.length() - (llllllllllllIIIIllIllIIIlllIlIIl - llllllllllllIIIIllIllIIIlllIlIII);
        if (!this.text.isEmpty()) {
            llllllllllllIIIIllIllIIIlllIlIll = String.valueOf(llllllllllllIIIIllIllIIIlllIlIll) + this.text.substring(0, llllllllllllIIIIllIllIIIlllIlIIl);
        }
        int llllllllllllIIIIllIllIIIlllIIlIl = 0;
        if (llllllllllllIIIIllIllIIIlllIIlll < llllllllllllIIIIllIllIIIlllIlIlI.length()) {
            llllllllllllIIIIllIllIIIlllIlIll = String.valueOf(llllllllllllIIIIllIllIIIlllIlIll) + llllllllllllIIIIllIllIIIlllIlIlI.substring(0, llllllllllllIIIIllIllIIIlllIIlll);
            final int llllllllllllIIIIllIllIIIlllIIllI = llllllllllllIIIIllIllIIIlllIIlll;
        }
        else {
            llllllllllllIIIIllIllIIIlllIlIll = String.valueOf(llllllllllllIIIIllIllIIIlllIlIll) + llllllllllllIIIIllIllIIIlllIlIlI;
            llllllllllllIIIIllIllIIIlllIIlIl = llllllllllllIIIIllIllIIIlllIlIlI.length();
        }
        if (!this.text.isEmpty() && llllllllllllIIIIllIllIIIlllIlIII < this.text.length()) {
            llllllllllllIIIIllIllIIIlllIlIll = String.valueOf(llllllllllllIIIIllIllIIIlllIlIll) + this.text.substring(llllllllllllIIIIllIllIIIlllIlIII);
        }
        if (this.validator.apply((Object)llllllllllllIIIIllIllIIIlllIlIll)) {
            this.text = llllllllllllIIIIllIllIIIlllIlIll;
            this.moveCursorBy(llllllllllllIIIIllIllIIIlllIlIIl - this.selectionEnd + llllllllllllIIIIllIllIIIlllIIlIl);
            this.func_190516_a(this.id, this.text);
        }
    }
    
    public void setGuiResponder(final GuiPageButtonList.GuiResponder llllllllllllIIIIllIllIIlIIIlIIIl) {
        this.guiResponder = llllllllllllIIIIllIllIIlIIIlIIIl;
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public boolean mouseClicked(final int llllllllllllIIIIllIllIIIIllIIIIl, final int llllllllllllIIIIllIllIIIIllIIIII, final int llllllllllllIIIIllIllIIIIlIlllll) {
        final boolean llllllllllllIIIIllIllIIIIllIIlIl = llllllllllllIIIIllIllIIIIllIIIIl >= this.xPosition && llllllllllllIIIIllIllIIIIllIIIIl < this.xPosition + this.width && llllllllllllIIIIllIllIIIIllIIIII >= this.yPosition && llllllllllllIIIIllIllIIIIllIIIII < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(llllllllllllIIIIllIllIIIIllIIlIl);
        }
        if (this.isFocused && llllllllllllIIIIllIllIIIIllIIlIl && llllllllllllIIIIllIllIIIIlIlllll == 0) {
            int llllllllllllIIIIllIllIIIIllIIlII = llllllllllllIIIIllIllIIIIllIIIIl - this.xPosition;
            if (this.enableBackgroundDrawing) {
                llllllllllllIIIIllIllIIIIllIIlII -= 4;
            }
            final String llllllllllllIIIIllIllIIIIllIIIll = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRendererInstance.trimStringToWidth(llllllllllllIIIIllIllIIIIllIIIll, llllllllllllIIIIllIllIIIIllIIlII).length() + this.lineScrollOffset);
            return true;
        }
        return false;
    }
    
    public void drawTextBox() {
        if (this.getVisible() && this.getEnableBackgroundDrawing()) {
            DrawHelper.drawRectWithGlow(this.xPosition - 1.5, this.yPosition - 1.5, this.xPosition + this.width + 1.5 - 60.0, this.yPosition + this.height - 1.5, 5.0, 10.0, new Color(1, 1, 1, 130));
        }
        final int llllllllllllIIIIllIllIIIIIlIIlIl = this.isEnabled ? this.enabledColor : this.disabledColor;
        final int llllllllllllIIIIllIllIIIIIlIIlII = this.cursorPosition - this.lineScrollOffset;
        int llllllllllllIIIIllIllIIIIIlIIIll = this.selectionEnd - this.lineScrollOffset;
        final String llllllllllllIIIIllIllIIIIIlIIIlI = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
        final boolean llllllllllllIIIIllIllIIIIIlIIIIl = llllllllllllIIIIllIllIIIIIlIIlII >= 0 && llllllllllllIIIIllIllIIIIIlIIlII <= llllllllllllIIIIllIllIIIIIlIIIlI.length();
        final boolean llllllllllllIIIIllIllIIIIIlIIIII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllIIIIllIllIIIIIlIIIIl;
        final int llllllllllllIIIIllIllIIIIIIlllll = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
        final int llllllllllllIIIIllIllIIIIIIllllI = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
        int llllllllllllIIIIllIllIIIIIIlllIl = llllllllllllIIIIllIllIIIIIIlllll;
        if (llllllllllllIIIIllIllIIIIIlIIIll > llllllllllllIIIIllIllIIIIIlIIIlI.length()) {
            llllllllllllIIIIllIllIIIIIlIIIll = llllllllllllIIIIllIllIIIIIlIIIlI.length();
        }
        if (!llllllllllllIIIIllIllIIIIIlIIIlI.isEmpty()) {
            final String llllllllllllIIIIllIllIIIIIIlllII = llllllllllllIIIIllIllIIIIIlIIIIl ? llllllllllllIIIIllIllIIIIIlIIIlI.substring(0, llllllllllllIIIIllIllIIIIIlIIlII) : llllllllllllIIIIllIllIIIIIlIIIlI;
            llllllllllllIIIIllIllIIIIIIlllIl = this.fontRendererInstance.drawStringWithShadow(llllllllllllIIIIllIllIIIIIIlllII, (float)llllllllllllIIIIllIllIIIIIIlllll, (float)llllllllllllIIIIllIllIIIIIIllllI, llllllllllllIIIIllIllIIIIIlIIlIl);
        }
        final boolean llllllllllllIIIIllIllIIIIIIllIll = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
        int llllllllllllIIIIllIllIIIIIIllIlI = llllllllllllIIIIllIllIIIIIIlllIl;
        if (!llllllllllllIIIIllIllIIIIIlIIIIl) {
            llllllllllllIIIIllIllIIIIIIllIlI = ((llllllllllllIIIIllIllIIIIIlIIlII > 0) ? (llllllllllllIIIIllIllIIIIIIlllll + this.width) : llllllllllllIIIIllIllIIIIIIlllll);
        }
        else if (llllllllllllIIIIllIllIIIIIIllIll) {
            llllllllllllIIIIllIllIIIIIIllIlI = llllllllllllIIIIllIllIIIIIIlllIl - 1;
            --llllllllllllIIIIllIllIIIIIIlllIl;
        }
        if (!llllllllllllIIIIllIllIIIIIlIIIlI.isEmpty() && llllllllllllIIIIllIllIIIIIlIIIIl && llllllllllllIIIIllIllIIIIIlIIlII < llllllllllllIIIIllIllIIIIIlIIIlI.length()) {
            llllllllllllIIIIllIllIIIIIIlllIl = this.fontRendererInstance.drawStringWithShadow(llllllllllllIIIIllIllIIIIIlIIIlI.substring(llllllllllllIIIIllIllIIIIIlIIlII), (float)llllllllllllIIIIllIllIIIIIIlllIl, (float)llllllllllllIIIIllIllIIIIIIllllI, llllllllllllIIIIllIllIIIIIlIIlIl);
        }
        if (llllllllllllIIIIllIllIIIIIlIIIII) {
            if (llllllllllllIIIIllIllIIIIIIllIll) {
                Gui.drawRect(llllllllllllIIIIllIllIIIIIIllIlI, llllllllllllIIIIllIllIIIIIIllllI - 1, llllllllllllIIIIllIllIIIIIIllIlI + 1, llllllllllllIIIIllIllIIIIIIllllI + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
            }
            else {
                this.fontRendererInstance.drawStringWithShadow("_", (float)llllllllllllIIIIllIllIIIIIIllIlI, llllllllllllIIIIllIllIIIIIIllllI - 1.0f, llllllllllllIIIIllIllIIIIIlIIlIl);
            }
        }
        if (llllllllllllIIIIllIllIIIIIlIIIll != llllllllllllIIIIllIllIIIIIlIIlII) {
            final int llllllllllllIIIIllIllIIIIIIllIIl = llllllllllllIIIIllIllIIIIIIlllll + this.fontRendererInstance.getStringWidth(llllllllllllIIIIllIllIIIIIlIIIlI.substring(0, llllllllllllIIIIllIllIIIIIlIIIll));
            this.drawCursorVertical(llllllllllllIIIIllIllIIIIIIllIlI, llllllllllllIIIIllIllIIIIIIllllI - 1, llllllllllllIIIIllIllIIIIIIllIIl - 1, llllllllllllIIIIllIllIIIIIIllllI + 1 + this.fontRendererInstance.FONT_HEIGHT);
        }
    }
    
    public String getSelectedText() {
        final int llllllllllllIIIIllIllIIlIIIIIIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllIIIIllIllIIIllllllll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llllllllllllIIIIllIllIIlIIIIIIII, llllllllllllIIIIllIllIIIllllllll);
    }
    
    public void setVisible(final boolean llllllllllllIIIIllIlIlllIlllIIll) {
        this.visible = llllllllllllIIIIllIlIlllIlllIIll;
    }
    
    public void drawTextBox1() {
        if (this.getVisible()) {
            final ScaledResolution llllllllllllIIIIllIlIlllllllllII = new ScaledResolution(Minecraft.getMinecraft());
            final int llllllllllllIIIIllIlIllllllllIll = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int llllllllllllIIIIllIlIllllllllIlI = this.cursorPosition - this.lineScrollOffset;
            int llllllllllllIIIIllIlIllllllllIIl = this.selectionEnd - this.lineScrollOffset;
            Minecraft.getMinecraft();
            final String llllllllllllIIIIllIlIllllllllIII = Minecraft.fontRendererObj.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean llllllllllllIIIIllIlIlllllllIlll = llllllllllllIIIIllIlIllllllllIlI >= 0 && llllllllllllIIIIllIlIllllllllIlI <= llllllllllllIIIIllIlIllllllllIII.length();
            final boolean llllllllllllIIIIllIlIlllllllIllI = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllIIIIllIlIlllllllIlll;
            final int llllllllllllIIIIllIlIlllllllIlIl = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int llllllllllllIIIIllIlIlllllllIlII = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int llllllllllllIIIIllIlIlllllllIIll = llllllllllllIIIIllIlIlllllllIlIl;
            if (llllllllllllIIIIllIlIllllllllIIl > llllllllllllIIIIllIlIllllllllIII.length()) {
                llllllllllllIIIIllIlIllllllllIIl = llllllllllllIIIIllIlIllllllllIII.length();
            }
            this.xd = AnimationHelper.animation(this.xd, (Minecraft.getMinecraft().currentScreen instanceof GuiChat) ? ((float)(llllllllllllIIIIllIlIlllllllllII.getScaledHeight() - 22)) : ((float)(llllllllllllIIIIllIlIlllllllllII.getScaledHeight() - 9)), 0.01f);
            llllllllllllIIIIllIlIllllllllIII.isEmpty();
            if (!llllllllllllIIIIllIlIllllllllIII.isEmpty()) {
                final String llllllllllllIIIIllIlIlllllllIIlI = llllllllllllIIIIllIlIlllllllIlll ? llllllllllllIIIIllIlIllllllllIII.substring(0, llllllllllllIIIIllIlIllllllllIlI) : llllllllllllIIIIllIlIllllllllIII;
                Minecraft.getMinecraft();
                llllllllllllIIIIllIlIlllllllIIll = Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllIIIIllIlIlllllllIIlI, llllllllllllIIIIllIlIlllllllIlIl + 0.5f, llllllllllllIIIIllIlIlllllllIlII - 0.5f, llllllllllllIIIIllIlIllllllllIll);
            }
            final boolean llllllllllllIIIIllIlIlllllllIIIl = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llllllllllllIIIIllIlIlllllllIIII = llllllllllllIIIIllIlIlllllllIIll;
            if (!llllllllllllIIIIllIlIlllllllIlll) {
                llllllllllllIIIIllIlIlllllllIIII = ((llllllllllllIIIIllIlIllllllllIlI > 0) ? (llllllllllllIIIIllIlIlllllllIlIl + this.width) : llllllllllllIIIIllIlIlllllllIlIl);
            }
            else if (llllllllllllIIIIllIlIlllllllIIIl) {
                llllllllllllIIIIllIlIlllllllIIII = llllllllllllIIIIllIlIlllllllIIll - 1;
                --llllllllllllIIIIllIlIlllllllIIll;
            }
            if (!llllllllllllIIIIllIlIllllllllIII.isEmpty() && llllllllllllIIIIllIlIlllllllIlll && llllllllllllIIIIllIlIllllllllIlI < llllllllllllIIIIllIlIllllllllIII.length()) {
                Minecraft.getMinecraft();
                llllllllllllIIIIllIlIlllllllIIll = Minecraft.fontRendererObj.drawStringWithShadow(llllllllllllIIIIllIlIllllllllIII.substring(llllllllllllIIIIllIlIllllllllIlI), (float)llllllllllllIIIIllIlIlllllllIIll, (float)llllllllllllIIIIllIlIlllllllIlII, llllllllllllIIIIllIlIllllllllIll);
            }
            if (llllllllllllIIIIllIlIlllllllIllI) {
                if (llllllllllllIIIIllIlIlllllllIIIl) {
                    Gui.drawRect(llllllllllllIIIIllIlIlllllllIIII, llllllllllllIIIIllIlIlllllllIlII - 1, llllllllllllIIIIllIlIlllllllIIII + 1, llllllllllllIIIIllIlIlllllllIlII + 1 + Minecraft.getMinecraft().sfui16.getFontHeight(), -3092272);
                }
                else if (llllllllllllIIIIllIlIllllllllIII.isEmpty()) {
                    Minecraft.getMinecraft();
                    Minecraft.fontRendererObj.drawStringWithShadow("", llllllllllllIIIIllIlIlllllllIIII + 1.0f, llllllllllllIIIIllIlIlllllllIlII + 2.0f, llllllllllllIIIIllIlIllllllllIll);
                }
                else {
                    Minecraft.getMinecraft();
                    Minecraft.fontRendererObj.drawStringWithShadow("_", llllllllllllIIIIllIlIlllllllIIII + 1.0f, llllllllllllIIIIllIlIlllllllIlII + 2.0f, llllllllllllIIIIllIlIllllllllIll);
                }
            }
            if (llllllllllllIIIIllIlIllllllllIIl != llllllllllllIIIIllIlIllllllllIlI) {
                final int llllllllllllIIIIllIlIllllllIllll = llllllllllllIIIIllIlIlllllllIlIl + Minecraft.getMinecraft().sfui16.getStringWidth(llllllllllllIIIIllIlIllllllllIII.substring(0, llllllllllllIIIIllIlIllllllllIIl));
                this.drawCursorVertical(llllllllllllIIIIllIlIlllllllIIII, llllllllllllIIIIllIlIlllllllIlII - 1, llllllllllllIIIIllIlIllllllIllll - 1, llllllllllllIIIIllIlIlllllllIlII + 1 + Minecraft.getMinecraft().sfui16.getFontHeight());
            }
        }
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public int getNthWordFromPos(final int llllllllllllIIIIllIllIIIlIlIlllI, final int llllllllllllIIIIllIllIIIlIlIllIl) {
        return this.getNthWordFromPosWS(llllllllllllIIIIllIllIIIlIlIlllI, llllllllllllIIIIllIllIIIlIlIllIl, true);
    }
    
    public void drawTextBoxalt() {
        if (this.getVisible() && this.getEnableBackgroundDrawing()) {
            DrawHelper.drawNewRect(this.xPosition - 1.5, this.yPosition - 1.2, this.xPosition + this.width + 1.5, this.yPosition + this.height - 1.5, new Color(0, 0, 0, 95).getRGB());
        }
        final int llllllllllllIIIIllIllIIIIlIIllIl = this.isEnabled ? this.enabledColor : this.disabledColor;
        final int llllllllllllIIIIllIllIIIIlIIllII = this.cursorPosition - this.lineScrollOffset;
        int llllllllllllIIIIllIllIIIIlIIlIll = this.selectionEnd - this.lineScrollOffset;
        final String llllllllllllIIIIllIllIIIIlIIlIlI = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
        final boolean llllllllllllIIIIllIllIIIIlIIlIIl = llllllllllllIIIIllIllIIIIlIIllII >= 0 && llllllllllllIIIIllIllIIIIlIIllII <= llllllllllllIIIIllIllIIIIlIIlIlI.length();
        final boolean llllllllllllIIIIllIllIIIIlIIlIII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllIIIIllIllIIIIlIIlIIl;
        final int llllllllllllIIIIllIllIIIIlIIIlll = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
        final int llllllllllllIIIIllIllIIIIlIIIllI = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
        int llllllllllllIIIIllIllIIIIlIIIlIl = llllllllllllIIIIllIllIIIIlIIIlll;
        if (llllllllllllIIIIllIllIIIIlIIlIll > llllllllllllIIIIllIllIIIIlIIlIlI.length()) {
            llllllllllllIIIIllIllIIIIlIIlIll = llllllllllllIIIIllIllIIIIlIIlIlI.length();
        }
        if (!llllllllllllIIIIllIllIIIIlIIlIlI.isEmpty()) {
            final String llllllllllllIIIIllIllIIIIlIIIlII = llllllllllllIIIIllIllIIIIlIIlIIl ? llllllllllllIIIIllIllIIIIlIIlIlI.substring(0, llllllllllllIIIIllIllIIIIlIIllII) : llllllllllllIIIIllIllIIIIlIIlIlI;
            llllllllllllIIIIllIllIIIIlIIIlIl = this.fontRendererInstance.drawStringWithShadow(llllllllllllIIIIllIllIIIIlIIIlII, (float)llllllllllllIIIIllIllIIIIlIIIlll, (float)llllllllllllIIIIllIllIIIIlIIIllI, llllllllllllIIIIllIllIIIIlIIllIl);
        }
        final boolean llllllllllllIIIIllIllIIIIlIIIIll = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
        int llllllllllllIIIIllIllIIIIlIIIIlI = llllllllllllIIIIllIllIIIIlIIIlIl;
        if (!llllllllllllIIIIllIllIIIIlIIlIIl) {
            llllllllllllIIIIllIllIIIIlIIIIlI = ((llllllllllllIIIIllIllIIIIlIIllII > 0) ? (llllllllllllIIIIllIllIIIIlIIIlll + this.width) : llllllllllllIIIIllIllIIIIlIIIlll);
        }
        else if (llllllllllllIIIIllIllIIIIlIIIIll) {
            llllllllllllIIIIllIllIIIIlIIIIlI = llllllllllllIIIIllIllIIIIlIIIlIl - 1;
            --llllllllllllIIIIllIllIIIIlIIIlIl;
        }
        if (!llllllllllllIIIIllIllIIIIlIIlIlI.isEmpty() && llllllllllllIIIIllIllIIIIlIIlIIl && llllllllllllIIIIllIllIIIIlIIllII < llllllllllllIIIIllIllIIIIlIIlIlI.length()) {
            llllllllllllIIIIllIllIIIIlIIIlIl = this.fontRendererInstance.drawStringWithShadow(llllllllllllIIIIllIllIIIIlIIlIlI.substring(llllllllllllIIIIllIllIIIIlIIllII), (float)llllllllllllIIIIllIllIIIIlIIIlIl, (float)llllllllllllIIIIllIllIIIIlIIIllI, llllllllllllIIIIllIllIIIIlIIllIl);
        }
        if (llllllllllllIIIIllIllIIIIlIIlIII) {
            if (llllllllllllIIIIllIllIIIIlIIIIll) {
                Gui.drawRect(llllllllllllIIIIllIllIIIIlIIIIlI, llllllllllllIIIIllIllIIIIlIIIllI - 1, llllllllllllIIIIllIllIIIIlIIIIlI + 1, llllllllllllIIIIllIllIIIIlIIIllI + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
            }
            else {
                this.fontRendererInstance.drawStringWithShadow("_", (float)llllllllllllIIIIllIllIIIIlIIIIlI, llllllllllllIIIIllIllIIIIlIIIllI - 1.0f, llllllllllllIIIIllIllIIIIlIIllIl);
            }
        }
        if (llllllllllllIIIIllIllIIIIlIIlIll != llllllllllllIIIIllIllIIIIlIIllII) {
            final int llllllllllllIIIIllIllIIIIlIIIIIl = llllllllllllIIIIllIllIIIIlIIIlll + this.fontRendererInstance.getStringWidth(llllllllllllIIIIllIllIIIIlIIlIlI.substring(0, llllllllllllIIIIllIllIIIIlIIlIll));
            this.drawCursorVertical(llllllllllllIIIIllIllIIIIlIIIIlI, llllllllllllIIIIllIllIIIIlIIIllI - 1, llllllllllllIIIIllIllIIIIlIIIIIl - 1, llllllllllllIIIIllIllIIIIlIIIllI + 1 + this.fontRendererInstance.FONT_HEIGHT);
        }
    }
    
    public void setSelectionPos(int llllllllllllIIIIllIlIllllIIIIllI) {
        final int llllllllllllIIIIllIlIllllIIIlIll = this.text.length();
        if (llllllllllllIIIIllIlIllllIIIIllI > llllllllllllIIIIllIlIllllIIIlIll) {
            llllllllllllIIIIllIlIllllIIIIllI = llllllllllllIIIIllIlIllllIIIlIll;
        }
        if (llllllllllllIIIIllIlIllllIIIIllI < 0) {
            llllllllllllIIIIllIlIllllIIIIllI = 0;
        }
        this.selectionEnd = llllllllllllIIIIllIlIllllIIIIllI;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > llllllllllllIIIIllIlIllllIIIlIll) {
                this.lineScrollOffset = llllllllllllIIIIllIlIllllIIIlIll;
            }
            final int llllllllllllIIIIllIlIllllIIIlIlI = this.getWidth();
            final String llllllllllllIIIIllIlIllllIIIlIIl = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), llllllllllllIIIIllIlIllllIIIlIlI);
            final int llllllllllllIIIIllIlIllllIIIlIII = llllllllllllIIIIllIlIllllIIIlIIl.length() + this.lineScrollOffset;
            if (llllllllllllIIIIllIlIllllIIIIllI == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.trimStringToWidth(this.text, llllllllllllIIIIllIlIllllIIIlIlI, true).length();
            }
            if (llllllllllllIIIIllIlIllllIIIIllI > llllllllllllIIIIllIlIllllIIIlIII) {
                this.lineScrollOffset += llllllllllllIIIIllIlIllllIIIIllI - llllllllllllIIIIllIlIllllIIIlIII;
            }
            else if (llllllllllllIIIIllIlIllllIIIIllI <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - llllllllllllIIIIllIlIllllIIIIllI;
            }
            this.lineScrollOffset = MathHelper.clamp(this.lineScrollOffset, 0, llllllllllllIIIIllIlIllllIIIlIll);
        }
    }
    
    public void deleteFromCursor(final int llllllllllllIIIIllIllIIIllIIIllI) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llllllllllllIIIIllIllIIIllIIIlIl = llllllllllllIIIIllIllIIIllIIIllI < 0;
                final int llllllllllllIIIIllIllIIIllIIIlII = llllllllllllIIIIllIllIIIllIIIlIl ? (this.cursorPosition + llllllllllllIIIIllIllIIIllIIIllI) : this.cursorPosition;
                final int llllllllllllIIIIllIllIIIllIIIIll = llllllllllllIIIIllIllIIIllIIIlIl ? this.cursorPosition : (this.cursorPosition + llllllllllllIIIIllIllIIIllIIIllI);
                String llllllllllllIIIIllIllIIIllIIIIlI = "";
                if (llllllllllllIIIIllIllIIIllIIIlII >= 0) {
                    llllllllllllIIIIllIllIIIllIIIIlI = this.text.substring(0, llllllllllllIIIIllIllIIIllIIIlII);
                }
                if (llllllllllllIIIIllIllIIIllIIIIll < this.text.length()) {
                    llllllllllllIIIIllIllIIIllIIIIlI = String.valueOf(llllllllllllIIIIllIllIIIllIIIIlI) + this.text.substring(llllllllllllIIIIllIllIIIllIIIIll);
                }
                if (this.validator.apply((Object)llllllllllllIIIIllIllIIIllIIIIlI)) {
                    this.text = llllllllllllIIIIllIllIIIllIIIIlI;
                    if (llllllllllllIIIIllIllIIIllIIIlIl) {
                        this.moveCursorBy(llllllllllllIIIIllIllIIIllIIIllI);
                    }
                    this.func_190516_a(this.id, this.text);
                }
            }
        }
    }
    
    public void setDisabledTextColour(final int llllllllllllIIIIllIlIllllIlIlIIl) {
        this.disabledColor = llllllllllllIIIIllIlIllllIlIlIIl;
    }
    
    public GuiTextField(final int llllllllllllIIIIllIllIIlIIIlllII, final FontRenderer llllllllllllIIIIllIllIIlIIIllIll, final int llllllllllllIIIIllIllIIlIIIllIlI, final int llllllllllllIIIIllIllIIlIIlIIIII, final int llllllllllllIIIIllIllIIlIIIlllll, final int llllllllllllIIIIllIllIIlIIIllllI) {
        this.xd = 0.0f;
        this.text = "";
        this.maxStringLength = 32;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.validator = (Predicate<String>)Predicates.alwaysTrue();
        this.id = llllllllllllIIIIllIllIIlIIIlllII;
        this.fontRendererInstance = llllllllllllIIIIllIllIIlIIIllIll;
        this.xPosition = llllllllllllIIIIllIllIIlIIIllIlI;
        this.yPosition = llllllllllllIIIIllIllIIlIIlIIIII;
        this.width = llllllllllllIIIIllIllIIlIIIlllll;
        this.height = llllllllllllIIIIllIllIIlIIIllllI;
    }
    
    public void func_190516_a(final int llllllllllllIIIIllIllIIIllIllIII, final String llllllllllllIIIIllIllIIIllIlIlll) {
        if (this.guiResponder != null) {
            this.guiResponder.setEntryValue(llllllllllllIIIIllIllIIIllIllIII, llllllllllllIIIIllIllIIIllIlIlll);
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void setEnableBackgroundDrawing(final boolean llllllllllllIIIIllIlIllllIllIlll) {
        this.enableBackgroundDrawing = llllllllllllIIIIllIlIllllIllIlll;
    }
    
    public boolean textboxKeyTyped(final char llllllllllllIIIIllIllIIIIlllIIlI, final int llllllllllllIIIIllIllIIIIlllIlII) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(llllllllllllIIIIllIllIIIIlllIlII)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(llllllllllllIIIIllIllIIIIlllIlII)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(llllllllllllIIIIllIllIIIIlllIlII)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(llllllllllllIIIIllIllIIIIlllIlII)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (llllllllllllIIIIllIllIIIIlllIlII) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(-1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(0);
                }
                else {
                    this.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() - 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(-1));
                }
                else {
                    this.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() + 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(1));
                }
                else {
                    this.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(this.text.length());
                }
                else {
                    this.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(1);
                }
                return true;
            }
            default: {
                if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllIIIIllIllIIIIlllIIlI)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(llllllllllllIIIIllIllIIIIlllIIlI));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public void setEnabled(final boolean llllllllllllIIIIllIlIllllIIlllII) {
        this.isEnabled = llllllllllllIIIIllIlIllllIIlllII;
    }
    
    private void drawCursorVertical(int llllllllllllIIIIllIlIlllllIIllll, int llllllllllllIIIIllIlIlllllIIlllI, int llllllllllllIIIIllIlIlllllIIllIl, int llllllllllllIIIIllIlIlllllIIllII) {
        if (llllllllllllIIIIllIlIlllllIIllll < llllllllllllIIIIllIlIlllllIIllIl) {
            final int llllllllllllIIIIllIlIlllllIlIlII = llllllllllllIIIIllIlIlllllIIllll;
            llllllllllllIIIIllIlIlllllIIllll = llllllllllllIIIIllIlIlllllIIllIl;
            llllllllllllIIIIllIlIlllllIIllIl = llllllllllllIIIIllIlIlllllIlIlII;
        }
        if (llllllllllllIIIIllIlIlllllIIlllI < llllllllllllIIIIllIlIlllllIIllII) {
            final int llllllllllllIIIIllIlIlllllIlIIll = llllllllllllIIIIllIlIlllllIIlllI;
            llllllllllllIIIIllIlIlllllIIlllI = llllllllllllIIIIllIlIlllllIIllII;
            llllllllllllIIIIllIlIlllllIIllII = llllllllllllIIIIllIlIlllllIlIIll;
        }
        if (llllllllllllIIIIllIlIlllllIIllIl > this.xPosition + this.width) {
            llllllllllllIIIIllIlIlllllIIllIl = this.xPosition + this.width;
        }
        if (llllllllllllIIIIllIlIlllllIIllll > this.xPosition + this.width) {
            llllllllllllIIIIllIlIlllllIIllll = this.xPosition + this.width;
        }
        final Tessellator llllllllllllIIIIllIlIlllllIlIIlI = Tessellator.getInstance();
        final BufferBuilder llllllllllllIIIIllIlIlllllIlIIIl = llllllllllllIIIIllIlIlllllIlIIlI.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        llllllllllllIIIIllIlIlllllIlIIIl.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllIIIIllIlIlllllIlIIIl.pos(llllllllllllIIIIllIlIlllllIIllll, llllllllllllIIIIllIlIlllllIIllII, 0.0).endVertex();
        llllllllllllIIIIllIlIlllllIlIIIl.pos(llllllllllllIIIIllIlIlllllIIllIl, llllllllllllIIIIllIlIlllllIIllII, 0.0).endVertex();
        llllllllllllIIIIllIlIlllllIlIIIl.pos(llllllllllllIIIIllIlIlllllIIllIl, llllllllllllIIIIllIlIlllllIIlllI, 0.0).endVertex();
        llllllllllllIIIIllIlIlllllIlIIIl.pos(llllllllllllIIIIllIlIlllllIIllll, llllllllllllIIIIllIlIlllllIIlllI, 0.0).endVertex();
        llllllllllllIIIIllIlIlllllIlIIlI.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }
    
    public void setCursorPosition(final int llllllllllllIIIIllIllIIIlIIIIlII) {
        this.cursorPosition = llllllllllllIIIIllIllIIIlIIIIlII;
        final int llllllllllllIIIIllIllIIIlIIIIIll = this.text.length();
        this.cursorPosition = MathHelper.clamp(this.cursorPosition, 0, llllllllllllIIIIllIllIIIlIIIIIll);
        this.setSelectionPos(this.cursorPosition);
    }
    
    public int getNthWordFromPosWS(final int llllllllllllIIIIllIllIIIlIIlllll, final int llllllllllllIIIIllIllIIIlIIllllI, final boolean llllllllllllIIIIllIllIIIlIIlllIl) {
        int llllllllllllIIIIllIllIIIlIIlllII = llllllllllllIIIIllIllIIIlIIllllI;
        final boolean llllllllllllIIIIllIllIIIlIIllIll = llllllllllllIIIIllIllIIIlIIlllll < 0;
        for (int llllllllllllIIIIllIllIIIlIIllIlI = Math.abs(llllllllllllIIIIllIllIIIlIIlllll), llllllllllllIIIIllIllIIIlIIllIIl = 0; llllllllllllIIIIllIllIIIlIIllIIl < llllllllllllIIIIllIllIIIlIIllIlI; ++llllllllllllIIIIllIllIIIlIIllIIl) {
            if (!llllllllllllIIIIllIllIIIlIIllIll) {
                final int llllllllllllIIIIllIllIIIlIIllIII = this.text.length();
                llllllllllllIIIIllIllIIIlIIlllII = this.text.indexOf(32, llllllllllllIIIIllIllIIIlIIlllII);
                if (llllllllllllIIIIllIllIIIlIIlllII == -1) {
                    llllllllllllIIIIllIllIIIlIIlllII = llllllllllllIIIIllIllIIIlIIllIII;
                }
                else {
                    while (llllllllllllIIIIllIllIIIlIIlllIl && llllllllllllIIIIllIllIIIlIIlllII < llllllllllllIIIIllIllIIIlIIllIII) {
                        if (this.text.charAt(llllllllllllIIIIllIllIIIlIIlllII) != ' ') {
                            break;
                        }
                        ++llllllllllllIIIIllIllIIIlIIlllII;
                    }
                }
            }
            else {
                while (llllllllllllIIIIllIllIIIlIIlllIl && llllllllllllIIIIllIllIIIlIIlllII > 0) {
                    if (this.text.charAt(llllllllllllIIIIllIllIIIlIIlllII - 1) != ' ') {
                        break;
                    }
                    --llllllllllllIIIIllIllIIIlIIlllII;
                }
                while (llllllllllllIIIIllIllIIIlIIlllII > 0 && this.text.charAt(llllllllllllIIIIllIllIIIlIIlllII - 1) != ' ') {
                    --llllllllllllIIIIllIllIIIlIIlllII;
                }
            }
        }
        return llllllllllllIIIIllIllIIIlIIlllII;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public void setMaxStringLength(final int llllllllllllIIIIllIlIlllllIIIllI) {
        this.maxStringLength = llllllllllllIIIIllIlIlllllIIIllI;
        if (this.text.length() > llllllllllllIIIIllIlIlllllIIIllI) {
            this.text = this.text.substring(0, llllllllllllIIIIllIlIlllllIIIllI);
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public void setTextColor(final int llllllllllllIIIIllIlIllllIllIIIl) {
        this.enabledColor = llllllllllllIIIIllIlIllllIllIIIl;
    }
    
    public void setCanLoseFocus(final boolean llllllllllllIIIIllIlIlllIlllllII) {
        this.canLoseFocus = llllllllllllIIIIllIlIlllIlllllII;
    }
    
    public void deleteWords(final int llllllllllllIIIIllIllIIIllIIlllI) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llllllllllllIIIIllIllIIIllIIlllI) - this.cursorPosition);
            }
        }
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void moveCursorBy(final int llllllllllllIIIIllIllIIIlIIIlIll) {
        this.setCursorPosition(this.selectionEnd + llllllllllllIIIIllIllIIIlIIIlIll);
    }
    
    public void setValidator(final Predicate<String> llllllllllllIIIIllIllIIIlllllIII) {
        this.validator = llllllllllllIIIIllIllIIIlllllIII;
    }
    
    public void setFocused(final boolean llllllllllllIIIIllIlIllllIlIIIll) {
        if (llllllllllllIIIIllIlIllllIlIIIll && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llllllllllllIIIIllIlIllllIlIIIll;
        if (Minecraft.getMinecraft().currentScreen != null) {
            Minecraft.getMinecraft().currentScreen.func_193975_a(llllllllllllIIIIllIlIllllIlIIIll);
        }
    }
    
    public int getId() {
        return this.id;
    }
}
