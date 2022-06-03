// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.alt;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class PasswordField extends Gui
{
    private /* synthetic */ int selectionEnd;
    private final /* synthetic */ int xPos;
    private final /* synthetic */ int height;
    private final /* synthetic */ int width;
    private /* synthetic */ String text;
    private /* synthetic */ int cursorPosition;
    private final /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ int i;
    private /* synthetic */ int enabledColor;
    public /* synthetic */ boolean isFocused;
    private final /* synthetic */ int yPos;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ int maxStringLength;
    private /* synthetic */ boolean b;
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void func_73794_g(final int lllllllllllllIllllIlllIIlIllIlll) {
        this.enabledColor = lllllllllllllIllllIlllIIlIllIlll;
    }
    
    public String getSelectedtext() {
        final int lllllllllllllIllllIlllIllIlIIllI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIllllIlllIllIlIIlIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(lllllllllllllIllllIlllIllIlIIllI, lllllllllllllIllllIlllIllIlIIlIl);
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void writeText(final String lllllllllllllIllllIlllIllIIIllIl) {
        String lllllllllllllIllllIlllIllIIlIlII = "";
        final String lllllllllllllIllllIlllIllIIlIIll = ChatAllowedCharacters.filterAllowedCharacters(lllllllllllllIllllIlllIllIIIllIl);
        final int lllllllllllllIllllIlllIllIIlIIlI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIllllIlllIllIIlIIIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int lllllllllllllIllllIlllIllIIlIIII = this.maxStringLength - this.text.length() - lllllllllllllIllllIlllIllIIlIIlI - this.selectionEnd;
        final boolean lllllllllllllIllllIlllIllIIIllll = false;
        if (this.text.length() > 0) {
            lllllllllllllIllllIlllIllIIlIlII = String.valueOf(lllllllllllllIllllIlllIllIIlIlII) + this.text.substring(0, lllllllllllllIllllIlllIllIIlIIlI);
        }
        int lllllllllllllIllllIlllIllIIlIlIl = 0;
        if (lllllllllllllIllllIlllIllIIlIIII < lllllllllllllIllllIlllIllIIlIIll.length()) {
            lllllllllllllIllllIlllIllIIlIlII = String.valueOf(lllllllllllllIllllIlllIllIIlIlII) + lllllllllllllIllllIlllIllIIlIIll.substring(0, lllllllllllllIllllIlllIllIIlIIII);
            final int lllllllllllllIllllIlllIllIIlIllI = lllllllllllllIllllIlllIllIIlIIII;
        }
        else {
            lllllllllllllIllllIlllIllIIlIlII = String.valueOf(lllllllllllllIllllIlllIllIIlIlII) + lllllllllllllIllllIlllIllIIlIIll;
            lllllllllllllIllllIlllIllIIlIlIl = lllllllllllllIllllIlllIllIIlIIll.length();
        }
        if (this.text.length() > 0 && lllllllllllllIllllIlllIllIIlIIIl < this.text.length()) {
            lllllllllllllIllllIlllIllIIlIlII = String.valueOf(lllllllllllllIllllIlllIllIIlIlII) + this.text.substring(lllllllllllllIllllIlllIllIIlIIIl);
        }
        this.text = lllllllllllllIllllIlllIllIIlIlII.replaceAll(" ", "");
        this.cursorPos(lllllllllllllIllllIlllIllIIlIIlI - this.selectionEnd + lllllllllllllIllllIlllIllIIlIlIl);
    }
    
    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                DrawHelper.drawNewRect(this.xPos - 1.5, this.yPos - 1, this.xPos + this.width + 1.5, this.yPos + this.height - 1.5, new Color(0, 0, 0, 95).getRGB());
            }
            final int lllllllllllllIllllIlllIlIIIIIIIl = this.enabledColor;
            final int lllllllllllllIllllIlllIlIIIIIIII = this.cursorPosition - this.i;
            int lllllllllllllIllllIlllIIllllllll = this.selectionEnd - this.i;
            final String lllllllllllllIllllIlllIIlllllllI = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            final boolean lllllllllllllIllllIlllIIllllllIl = lllllllllllllIllllIlllIlIIIIIIII >= 0 && lllllllllllllIllllIlllIlIIIIIIII <= lllllllllllllIllllIlllIIlllllllI.length();
            final boolean lllllllllllllIllllIlllIIllllllII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && lllllllllllllIllllIlllIIllllllIl;
            final int lllllllllllllIllllIlllIIlllllIll = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
            final int lllllllllllllIllllIlllIIlllllIlI = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
            int lllllllllllllIllllIlllIIlllllIIl = lllllllllllllIllllIlllIIlllllIll;
            if (lllllllllllllIllllIlllIIllllllll > lllllllllllllIllllIlllIIlllllllI.length()) {
                lllllllllllllIllllIlllIIllllllll = lllllllllllllIllllIlllIIlllllllI.length();
            }
            if (lllllllllllllIllllIlllIIlllllllI.length() > 0) {
                if (lllllllllllllIllllIlllIIllllllIl) {
                    lllllllllllllIllllIlllIIlllllllI.substring(0, lllllllllllllIllllIlllIlIIIIIIII);
                }
                Minecraft.getMinecraft();
                lllllllllllllIllllIlllIIlllllIIl = Minecraft.fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), (float)lllllllllllllIllllIlllIIlllllIll, (float)lllllllllllllIllllIlllIIlllllIlI, lllllllllllllIllllIlllIlIIIIIIIl);
            }
            final boolean lllllllllllllIllllIlllIIlllllIII = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int lllllllllllllIllllIlllIIllllIlll = lllllllllllllIllllIlllIIlllllIIl;
            if (!lllllllllllllIllllIlllIIllllllIl) {
                lllllllllllllIllllIlllIIllllIlll = ((lllllllllllllIllllIlllIlIIIIIIII > 0) ? (lllllllllllllIllllIlllIIlllllIll + this.width) : lllllllllllllIllllIlllIIlllllIll);
            }
            else if (lllllllllllllIllllIlllIIlllllIII) {
                lllllllllllllIllllIlllIIllllIlll = lllllllllllllIllllIlllIIlllllIIl - 1;
                --lllllllllllllIllllIlllIIlllllIIl;
            }
            if (lllllllllllllIllllIlllIIlllllllI.length() > 0 && lllllllllllllIllllIlllIIllllllIl && lllllllllllllIllllIlllIlIIIIIIII < lllllllllllllIllllIlllIIlllllllI.length()) {
                Minecraft.getMinecraft();
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllllIllllIlllIIlllllllI.substring(lllllllllllllIllllIlllIlIIIIIIII), (float)lllllllllllllIllllIlllIIlllllIIl, (float)lllllllllllllIllllIlllIIlllllIlI, lllllllllllllIllllIlllIlIIIIIIIl);
            }
            if (lllllllllllllIllllIlllIIllllllII) {
                if (lllllllllllllIllllIlllIIlllllIII) {
                    Gui.drawRect(lllllllllllllIllllIlllIIllllIlll, lllllllllllllIllllIlllIIlllllIlI - 1, lllllllllllllIllllIlllIIllllIlll + 1, lllllllllllllIllllIlllIIlllllIlI + 1 + Minecraft.getMinecraft().neverlose500_16.getFontHeight(), -3092272);
                }
                else {
                    Minecraft.getMinecraft();
                    Minecraft.fontRendererObj.drawStringWithShadow("_", (float)lllllllllllllIllllIlllIIllllIlll, (float)lllllllllllllIllllIlllIIlllllIlI, lllllllllllllIllllIlllIlIIIIIIIl);
                }
            }
            if (lllllllllllllIllllIlllIIllllllll != lllllllllllllIllllIlllIlIIIIIIII) {
                final int lllllllllllllIllllIlllIIllllIllI = lllllllllllllIllllIlllIIlllllIll + this.fontRenderer.getStringWidth(lllllllllllllIllllIlllIIlllllllI.substring(0, lllllllllllllIllllIlllIIllllllll));
                this.drawCursorVertical(lllllllllllllIllllIlllIIllllIlll, lllllllllllllIllllIlllIIlllllIlI - 1, lllllllllllllIllllIlllIIllllIllI - 1, lllllllllllllIllllIlllIIlllllIlI + 1 + Minecraft.getMinecraft().neverlose500_16.getFontHeight());
            }
        }
    }
    
    public int getNthWordFromCursor(final int lllllllllllllIllllIlllIlIllIlIlI) {
        return this.getNthWordFromPos(lllllllllllllIllllIlllIlIllIlIlI, this.getCursorPosition());
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void mouseClicked(final int lllllllllllllIllllIlllIlIIIllllI, final int lllllllllllllIllllIlllIlIIIlIlIl, final int lllllllllllllIllllIlllIlIIIlllII) {
        final boolean lllllllllllllIllllIlllIlIIIllIlI;
        final boolean lllllllllllllIllllIlllIlIIIllIll = lllllllllllllIllllIlllIlIIIllIlI = (lllllllllllllIllllIlllIlIIIllllI >= this.xPos && lllllllllllllIllllIlllIlIIIllllI < this.xPos + this.width && lllllllllllllIllllIlllIlIIIlIlIl >= this.yPos && lllllllllllllIllllIlllIlIIIlIlIl < this.yPos + this.height);
        if (this.canLoseFocus) {
            this.setFocused(lllllllllllllIllllIlllIlIIIllIll);
        }
        if (this.isFocused && lllllllllllllIllllIlllIlIIIlllII == 0) {
            int lllllllllllllIllllIlllIlIIIllIIl = lllllllllllllIllllIlllIlIIIllllI - this.xPos;
            if (this.enableBackgroundDrawing) {
                lllllllllllllIllllIlllIlIIIllIIl -= 4;
            }
            final String lllllllllllllIllllIlllIlIIIllIII = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            this.setCursorPosition(this.fontRenderer.trimStringToWidth(lllllllllllllIllllIlllIlIIIllIII, lllllllllllllIllllIlllIlIIIllIIl).length() + this.i);
        }
    }
    
    public int type(final int lllllllllllllIllllIlllIlIlIlIllI, final int lllllllllllllIllllIlllIlIlIIllII, final boolean lllllllllllllIllllIlllIlIlIlIlII) {
        int lllllllllllllIllllIlllIlIlIlIIll = lllllllllllllIllllIlllIlIlIIllII;
        final boolean lllllllllllllIllllIlllIlIlIlIIlI = lllllllllllllIllllIlllIlIlIlIllI < 0;
        for (int lllllllllllllIllllIlllIlIlIlIIIl = Math.abs(lllllllllllllIllllIlllIlIlIlIllI), lllllllllllllIllllIlllIlIlIlIIII = 0; lllllllllllllIllllIlllIlIlIlIIII < lllllllllllllIllllIlllIlIlIlIIIl; ++lllllllllllllIllllIlllIlIlIlIIII) {
            if (!lllllllllllllIllllIlllIlIlIlIIlI) {
                final int lllllllllllllIllllIlllIlIlIIllll = this.text.length();
                if ((lllllllllllllIllllIlllIlIlIlIIll = this.text.indexOf(32, lllllllllllllIllllIlllIlIlIlIIll)) == -1) {
                    lllllllllllllIllllIlllIlIlIlIIll = lllllllllllllIllllIlllIlIlIIllll;
                }
                else {
                    while (lllllllllllllIllllIlllIlIlIlIlII && lllllllllllllIllllIlllIlIlIlIIll < lllllllllllllIllllIlllIlIlIIllll) {
                        if (this.text.charAt(lllllllllllllIllllIlllIlIlIlIIll) != ' ') {
                            break;
                        }
                        ++lllllllllllllIllllIlllIlIlIlIIll;
                    }
                }
            }
            else {
                while (lllllllllllllIllllIlllIlIlIlIlII && lllllllllllllIllllIlllIlIlIlIIll > 0) {
                    if (this.text.charAt(lllllllllllllIllllIlllIlIlIlIIll - 1) != ' ') {
                        break;
                    }
                    --lllllllllllllIllllIlllIlIlIlIIll;
                }
                while (lllllllllllllIllllIlllIlIlIlIIll > 0 && this.text.charAt(lllllllllllllIllllIlllIlIlIlIIll - 1) != ' ') {
                    --lllllllllllllIllllIlllIlIlIlIIll;
                }
            }
        }
        return lllllllllllllIllllIlllIlIlIlIIll;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public void setEnableBackgroundDrawing(final boolean lllllllllllllIllllIlllIIlIllllll) {
        this.enableBackgroundDrawing = lllllllllllllIllllIlllIIlIllllll;
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public void setCursorPosition(final int lllllllllllllIllllIlllIlIIlllIll) {
        this.cursorPosition = lllllllllllllIllllIlllIlIIlllIll;
        final int lllllllllllllIllllIlllIlIIlllIlI = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > lllllllllllllIllllIlllIlIIlllIlI) {
            this.cursorPosition = lllllllllllllIllllIlllIlIIlllIlI;
        }
        this.func_73800_i(this.cursorPosition);
    }
    
    public void func_73790_e(final boolean lllllllllllllIllllIlllIIlIIIlIIl) {
        this.b = lllllllllllllIllllIlllIIlIIIlIIl;
    }
    
    public String getText() {
        final String lllllllllllllIllllIlllIllIlIllIl = this.text.replaceAll(" ", "");
        return lllllllllllllIllllIlllIllIlIllIl;
    }
    
    public void cursorPos(final int lllllllllllllIllllIlllIlIlIIIIlI) {
        this.setCursorPosition(this.selectionEnd + lllllllllllllIllllIlllIlIlIIIIlI);
    }
    
    public PasswordField(final FontRenderer lllllllllllllIllllIlllIlllIIIlII, final int lllllllllllllIllllIlllIllIllllIl, final int lllllllllllllIllllIlllIllIllllII, final int lllllllllllllIllllIlllIllIlllIll, final int lllllllllllllIllllIlllIllIlllIlI) {
        this.text = "";
        this.maxStringLength = 50;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isFocused = false;
        this.i = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.b = true;
        this.fontRenderer = lllllllllllllIllllIlllIlllIIIlII;
        this.xPos = lllllllllllllIllllIlllIllIllllIl;
        this.yPos = lllllllllllllIllllIlllIllIllllII;
        this.width = lllllllllllllIllllIlllIllIlllIll;
        this.height = lllllllllllllIllllIlllIllIlllIlI;
    }
    
    public void setText(final String lllllllllllllIllllIlllIllIllIIIl) {
        this.text = ((lllllllllllllIllllIlllIllIllIIIl.length() > this.maxStringLength) ? lllllllllllllIllllIlllIllIllIIIl.substring(0, this.maxStringLength) : lllllllllllllIllllIlllIllIllIIIl);
        this.setCursorPositionEnd();
    }
    
    public int getNthWordFromPos(final int lllllllllllllIllllIlllIlIllIIIIl, final int lllllllllllllIllllIlllIlIllIIIll) {
        return this.type(lllllllllllllIllllIlllIlIllIIIIl, this.getCursorPosition(), true);
    }
    
    private void drawCursorVertical(int lllllllllllllIllllIlllIIllIllIII, int lllllllllllllIllllIlllIIllIlIlll, int lllllllllllllIllllIlllIIllIlIllI, int lllllllllllllIllllIlllIIllIlIlIl) {
        if (lllllllllllllIllllIlllIIllIllIII < lllllllllllllIllllIlllIIllIlIllI) {
            final int lllllllllllllIllllIlllIIllIlllII = lllllllllllllIllllIlllIIllIllIII;
            lllllllllllllIllllIlllIIllIllIII = (int)lllllllllllllIllllIlllIIllIlIllI;
            lllllllllllllIllllIlllIIllIlIllI = lllllllllllllIllllIlllIIllIlllII;
        }
        if (lllllllllllllIllllIlllIIllIlIlll < lllllllllllllIllllIlllIIllIlIlIl) {
            final int lllllllllllllIllllIlllIIllIllIll = lllllllllllllIllllIlllIIllIlIlll;
            lllllllllllllIllllIlllIIllIlIlll = lllllllllllllIllllIlllIIllIlIlIl;
            lllllllllllllIllllIlllIIllIlIlIl = lllllllllllllIllllIlllIIllIllIll;
        }
        final Tessellator lllllllllllllIllllIlllIIllIllIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllllIlllIIllIllIIl = lllllllllllllIllllIlllIIllIllIlI.getBuffer();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        lllllllllllllIllllIlllIIllIllIIl.begin(7, lllllllllllllIllllIlllIIllIllIIl.getVertexFormat());
        lllllllllllllIllllIlllIIllIllIIl.pos(lllllllllllllIllllIlllIIllIllIII, lllllllllllllIllllIlllIIllIlIlIl, 0.0);
        lllllllllllllIllllIlllIIllIllIIl.pos(lllllllllllllIllllIlllIIllIlIllI, lllllllllllllIllllIlllIIllIlIlIl, 0.0);
        lllllllllllllIllllIlllIIllIllIIl.pos(lllllllllllllIllllIlllIIllIlIllI, lllllllllllllIllllIlllIIllIlIlll, 0.0);
        lllllllllllllIllllIlllIIllIllIIl.pos(lllllllllllllIllllIlllIIllIllIII, lllllllllllllIllllIlllIIllIlIlll, 0.0);
        lllllllllllllIllllIlllIIllIllIIl.finishDrawing();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }
    
    public void func_73779_a(final int lllllllllllllIllllIlllIllIIIIIII) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(lllllllllllllIllllIlllIllIIIIIII) - this.cursorPosition);
            }
        }
    }
    
    public boolean textboxKeyTyped(final char lllllllllllllIllllIlllIlIIlIlIIl, final int lllllllllllllIllllIlllIlIIlIlIll) {
        if (!this.isFocused) {
            return false;
        }
        switch (lllllllllllllIllllIlllIlIIlIlIIl) {
            case '\u0001': {
                this.setCursorPositionEnd();
                this.func_73800_i(0);
                return true;
            }
            case '\u0003': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                return true;
            }
            case '\u0016': {
                this.writeText(GuiScreen.getClipboardString());
                return true;
            }
            case '\u0018': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                this.writeText("");
                return true;
            }
            default: {
                switch (lllllllllllllIllllIlllIlIIlIlIll) {
                    case 14: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(-1);
                        }
                        else {
                            this.deleteFromCursor(-1);
                        }
                        return true;
                    }
                    case 199: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(0);
                        }
                        else {
                            this.setCursorPositionZero();
                        }
                        return true;
                    }
                    case 203: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() - 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(-1));
                        }
                        else {
                            this.cursorPos(-1);
                        }
                        return true;
                    }
                    case 205: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() + 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(1));
                        }
                        else {
                            this.cursorPos(1);
                        }
                        return true;
                    }
                    case 207: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(this.text.length());
                        }
                        else {
                            this.setCursorPositionEnd();
                        }
                        return true;
                    }
                    case 211: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(1);
                        }
                        else {
                            this.deleteFromCursor(1);
                        }
                        return true;
                    }
                    default: {
                        if (ChatAllowedCharacters.isAllowedCharacter(lllllllllllllIllllIlllIlIIlIlIIl)) {
                            this.writeText(Character.toString(lllllllllllllIllllIlllIlIIlIlIIl));
                            return true;
                        }
                        return false;
                    }
                }
                break;
            }
        }
    }
    
    public void func_73800_i(int lllllllllllllIllllIlllIIlIIllIlI) {
        final int lllllllllllllIllllIlllIIlIIlllll = this.text.length();
        if (lllllllllllllIllllIlllIIlIIllIlI > lllllllllllllIllllIlllIIlIIlllll) {
            lllllllllllllIllllIlllIIlIIllIlI = lllllllllllllIllllIlllIIlIIlllll;
        }
        if (lllllllllllllIllllIlllIIlIIllIlI < 0) {
            lllllllllllllIllllIlllIIlIIllIlI = 0;
        }
        this.selectionEnd = lllllllllllllIllllIlllIIlIIllIlI;
        if (this.fontRenderer != null) {
            if (this.i > lllllllllllllIllllIlllIIlIIlllll) {
                this.i = lllllllllllllIllllIlllIIlIIlllll;
            }
            final int lllllllllllllIllllIlllIIlIIllllI = this.getWidth();
            final String lllllllllllllIllllIlllIIlIIlllIl = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), lllllllllllllIllllIlllIIlIIllllI);
            final int lllllllllllllIllllIlllIIlIIlllII = lllllllllllllIllllIlllIIlIIlllIl.length() + this.i;
            if (lllllllllllllIllllIlllIIlIIllIlI == this.i) {
                this.i -= this.fontRenderer.trimStringToWidth(this.text, lllllllllllllIllllIlllIIlIIllllI, true).length();
            }
            if (lllllllllllllIllllIlllIIlIIllIlI > lllllllllllllIllllIlllIIlIIlllII) {
                this.i += lllllllllllllIllllIlllIIlIIllIlI - lllllllllllllIllllIlllIIlIIlllII;
            }
            else if (lllllllllllllIllllIlllIIlIIllIlI <= this.i) {
                this.i -= this.i - lllllllllllllIllllIlllIIlIIllIlI;
            }
            if (this.i < 0) {
                this.i = 0;
            }
            if (this.i > lllllllllllllIllllIlllIIlIIlllll) {
                this.i = lllllllllllllIllllIlllIIlIIlllll;
            }
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void deleteFromCursor(final int lllllllllllllIllllIlllIlIlllIIlI) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean lllllllllllllIllllIlllIlIlllIlll = lllllllllllllIllllIlllIlIlllIIlI < 0;
                final int lllllllllllllIllllIlllIlIlllIllI = lllllllllllllIllllIlllIlIlllIlll ? (this.cursorPosition + lllllllllllllIllllIlllIlIlllIIlI) : this.cursorPosition;
                final int lllllllllllllIllllIlllIlIlllIlIl = lllllllllllllIllllIlllIlIlllIlll ? this.cursorPosition : (this.cursorPosition + lllllllllllllIllllIlllIlIlllIIlI);
                String lllllllllllllIllllIlllIlIlllIlII = "";
                if (lllllllllllllIllllIlllIlIlllIllI >= 0) {
                    lllllllllllllIllllIlllIlIlllIlII = this.text.substring(0, lllllllllllllIllllIlllIlIlllIllI);
                }
                if (lllllllllllllIllllIlllIlIlllIlIl < this.text.length()) {
                    lllllllllllllIllllIlllIlIlllIlII = String.valueOf(lllllllllllllIllllIlllIlIlllIlII) + this.text.substring(lllllllllllllIllllIlllIlIlllIlIl);
                }
                this.text = lllllllllllllIllllIlllIlIlllIlII;
                if (lllllllllllllIllllIlllIlIlllIlll) {
                    this.cursorPos(lllllllllllllIllllIlllIlIlllIIlI);
                }
            }
        }
    }
    
    public void setCanLoseFocus(final boolean lllllllllllllIllllIlllIIlIIlIIlI) {
        this.canLoseFocus = lllllllllllllIllllIlllIIlIIlIIlI;
    }
    
    public boolean func_73778_q() {
        return this.b;
    }
    
    public void setMaxStringLength(final int lllllllllllllIllllIlllIIllIIlllI) {
        this.maxStringLength = lllllllllllllIllllIlllIIllIIlllI;
        if (this.text.length() > lllllllllllllIllllIlllIIllIIlllI) {
            this.text = this.text.substring(0, lllllllllllllIllllIlllIIllIIlllI);
        }
    }
    
    public void setFocused(final boolean lllllllllllllIllllIlllIIlIllIIll) {
        if (lllllllllllllIllllIlllIIlIllIIll && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = lllllllllllllIllllIlllIIlIllIIll;
    }
}
