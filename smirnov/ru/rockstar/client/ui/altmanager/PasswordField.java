// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.client.gui.GuiScreen;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class PasswordField extends Gui
{
    private /* synthetic */ boolean field_73823_s;
    private final /* synthetic */ int xPos;
    public /* synthetic */ boolean isFocused;
    private /* synthetic */ int field_73816_n;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ int cursorCounter;
    public /* synthetic */ String text;
    private final /* synthetic */ int width;
    private /* synthetic */ int cursorPosition;
    private /* synthetic */ int selectionEnd;
    public /* synthetic */ int maxStringLength;
    private final /* synthetic */ int height;
    private final /* synthetic */ int yPos;
    private final /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ boolean enableBackgroundDrawing;
    
    public void func_73790_e(final boolean lllllllllllIIllIlIlIIIlllllllllI) {
        this.field_73823_s = lllllllllllIIllIlIlIIIlllllllllI;
    }
    
    public void setCanLoseFocus(final boolean lllllllllllIIllIlIlIIlIIIIIIIlll) {
        this.canLoseFocus = lllllllllllIIllIlIlIIlIIIIIIIlll;
    }
    
    public void deleteFromCursor(final int lllllllllllIIllIlIlIIlIIlllIllII) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean lllllllllllIIllIlIlIIlIIlllIlIll = lllllllllllIIllIlIlIIlIIlllIllII < 0;
                final int lllllllllllIIllIlIlIIlIIlllIlIlI = lllllllllllIIllIlIlIIlIIlllIlIll ? (this.cursorPosition + lllllllllllIIllIlIlIIlIIlllIllII) : this.cursorPosition;
                final int lllllllllllIIllIlIlIIlIIlllIlIIl = lllllllllllIIllIlIlIIlIIlllIlIll ? this.cursorPosition : (this.cursorPosition + lllllllllllIIllIlIlIIlIIlllIllII);
                String lllllllllllIIllIlIlIIlIIlllIlIII = "";
                if (lllllllllllIIllIlIlIIlIIlllIlIlI >= 0) {
                    lllllllllllIIllIlIlIIlIIlllIlIII = this.text.substring(0, lllllllllllIIllIlIlIIlIIlllIlIlI);
                }
                if (lllllllllllIIllIlIlIIlIIlllIlIIl < this.text.length()) {
                    lllllllllllIIllIlIlIIlIIlllIlIII = String.valueOf(lllllllllllIIllIlIlIIlIIlllIlIII) + this.text.substring(lllllllllllIIllIlIlIIlIIlllIlIIl);
                }
                this.text = lllllllllllIIllIlIlIIlIIlllIlIII;
                if (lllllllllllIIllIlIlIIlIIlllIlIll) {
                    this.func_73784_d(lllllllllllIIllIlIlIIlIIlllIllII);
                }
            }
        }
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public void setMaxStringLength(final int lllllllllllIIllIlIlIIlIIIlIIlIIl) {
        this.maxStringLength = lllllllllllIIllIlIlIIlIIIlIIlIIl;
        if (this.text.length() > lllllllllllIIllIlIlIIlIIIlIIlIIl) {
            this.text = this.text.substring(0, lllllllllllIIllIlIlIIlIIIlIIlIIl);
        }
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public String getText() {
        return this.text.replaceAll(" ", "");
    }
    
    private void drawCursorVertical(int lllllllllllIIllIlIlIIlIIIlIllIII, int lllllllllllIIllIlIlIIlIIIlIlIlll, int lllllllllllIIllIlIlIIlIIIlIlIllI, int lllllllllllIIllIlIlIIlIIIlIlIlIl) {
        if (lllllllllllIIllIlIlIIlIIIlIllIII < lllllllllllIIllIlIlIIlIIIlIlIllI) {
            final int lllllllllllIIllIlIlIIlIIIlIlllII = (int)lllllllllllIIllIlIlIIlIIIlIllIII;
            lllllllllllIIllIlIlIIlIIIlIllIII = (double)lllllllllllIIllIlIlIIlIIIlIlIllI;
            lllllllllllIIllIlIlIIlIIIlIlIllI = lllllllllllIIllIlIlIIlIIIlIlllII;
        }
        if (lllllllllllIIllIlIlIIlIIIlIlIlll < lllllllllllIIllIlIlIIlIIIlIlIlIl) {
            final int lllllllllllIIllIlIlIIlIIIlIllIll = lllllllllllIIllIlIlIIlIIIlIlIlll;
            lllllllllllIIllIlIlIIlIIIlIlIlll = (int)lllllllllllIIllIlIlIIlIIIlIlIlIl;
            lllllllllllIIllIlIlIIlIIIlIlIlIl = lllllllllllIIllIlIlIIlIIIlIllIll;
        }
        final Tessellator lllllllllllIIllIlIlIIlIIIlIllIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIllIlIlIIlIIIlIllIIl = lllllllllllIIllIlIlIIlIIIlIllIlI.getBuffer();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        lllllllllllIIllIlIlIIlIIIlIllIIl.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllIIllIlIlIIlIIIlIllIIl.pos(lllllllllllIIllIlIlIIlIIIlIllIII, (double)lllllllllllIIllIlIlIIlIIIlIlIlIl, 0.0).endVertex();
        lllllllllllIIllIlIlIIlIIIlIllIIl.pos((double)lllllllllllIIllIlIlIIlIIIlIlIllI, (double)lllllllllllIIllIlIlIIlIIIlIlIlIl, 0.0).endVertex();
        lllllllllllIIllIlIlIIlIIIlIllIIl.pos((double)lllllllllllIIllIlIlIIlIIIlIlIllI, lllllllllllIIllIlIlIIlIIIlIlIlll, 0.0).endVertex();
        lllllllllllIIllIlIlIIlIIIlIllIIl.pos(lllllllllllIIllIlIlIIlIIIlIllIII, lllllllllllIIllIlIlIIlIIIlIlIlll, 0.0).endVertex();
        lllllllllllIIllIlIlIIlIIIlIllIlI.draw();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }
    
    public void setCursorPosition(final int lllllllllllIIllIlIlIIlIIIlIIIIIl) {
        this.cursorPosition = lllllllllllIIllIlIlIIlIIIlIIIIIl;
        final int lllllllllllIIllIlIlIIlIIIlIIIIII = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > lllllllllllIIllIlIlIIlIIIlIIIIII) {
            this.cursorPosition = lllllllllllIIllIlIlIIlIIIlIIIIII;
        }
        this.func_73800_i(this.cursorPosition);
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public int getNthWordFromPos(final int lllllllllllIIllIlIlIIlIIllIlIlIl, final int lllllllllllIIllIlIlIIlIIllIlIlll) {
        return this.func_73798_a(lllllllllllIIllIlIlIIlIIllIlIlIl, this.getCursorPosition(), true);
    }
    
    public int getNthWordFromCursor(final int lllllllllllIIllIlIlIIlIIllIllllI) {
        return this.getNthWordFromPos(lllllllllllIIllIlIlIIlIIllIllllI, this.getCursorPosition());
    }
    
    public void setFocused(final boolean lllllllllllIIllIlIlIIlIIIIlIIlIl) {
        if (lllllllllllIIllIlIlIIlIIIIlIIlIl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = lllllllllllIIllIlIlIIlIIIIlIIlIl;
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public PasswordField(final FontRenderer lllllllllllIIllIlIlIIlIlIIllIlIl, final int lllllllllllIIllIlIlIIlIlIIllIlII, final int lllllllllllIIllIlIlIIlIlIIllIIll, final int lllllllllllIIllIlIlIIlIlIIlIllII, final int lllllllllllIIllIlIlIIlIlIIlIlIll) {
        this.text = "";
        this.maxStringLength = 50;
        this.isFocused = false;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.field_73816_n = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.field_73823_s = true;
        this.fontRenderer = lllllllllllIIllIlIlIIlIlIIllIlIl;
        this.xPos = lllllllllllIIllIlIlIIlIlIIllIlII;
        this.yPos = lllllllllllIIllIlIlIIlIlIIllIIll;
        this.width = lllllllllllIIllIlIlIIlIlIIlIllII;
        this.height = lllllllllllIIllIlIlIIlIlIIlIlIll;
    }
    
    public void setEnableBackgroundDrawing(final boolean lllllllllllIIllIlIlIIlIIIIllIllI) {
        this.enableBackgroundDrawing = lllllllllllIIllIlIlIIlIIIIllIllI;
    }
    
    public void setText(final String lllllllllllIIllIlIlIIlIlIIlIIIIl) {
        if (lllllllllllIIllIlIlIIlIlIIlIIIIl.length() > this.maxStringLength) {
            this.text = lllllllllllIIllIlIlIIlIlIIlIIIIl.substring(0, this.maxStringLength);
        }
        else {
            this.text = lllllllllllIIllIlIlIIlIlIIlIIIIl;
        }
        this.setCursorPositionEnd();
    }
    
    public int func_73798_a(final int lllllllllllIIllIlIlIIlIIllIIIIIl, final int lllllllllllIIllIlIlIIlIIllIIlIIl, final boolean lllllllllllIIllIlIlIIlIIllIIlIII) {
        int lllllllllllIIllIlIlIIlIIllIIIlll = lllllllllllIIllIlIlIIlIIllIIlIIl;
        final boolean lllllllllllIIllIlIlIIlIIllIIIllI = lllllllllllIIllIlIlIIlIIllIIIIIl < 0;
        for (int lllllllllllIIllIlIlIIlIIllIIIlIl = Math.abs(lllllllllllIIllIlIlIIlIIllIIIIIl), lllllllllllIIllIlIlIIlIIllIIIlII = 0; lllllllllllIIllIlIlIIlIIllIIIlII < lllllllllllIIllIlIlIIlIIllIIIlIl; ++lllllllllllIIllIlIlIIlIIllIIIlII) {
            if (!lllllllllllIIllIlIlIIlIIllIIIllI) {
                final int lllllllllllIIllIlIlIIlIIllIIIIll = this.text.length();
                lllllllllllIIllIlIlIIlIIllIIIlll = this.text.indexOf(32, lllllllllllIIllIlIlIIlIIllIIIlll);
                if (lllllllllllIIllIlIlIIlIIllIIIlll == -1) {
                    lllllllllllIIllIlIlIIlIIllIIIlll = lllllllllllIIllIlIlIIlIIllIIIIll;
                }
                else {
                    while (lllllllllllIIllIlIlIIlIIllIIlIII && lllllllllllIIllIlIlIIlIIllIIIlll < lllllllllllIIllIlIlIIlIIllIIIIll) {
                        if (this.text.charAt(lllllllllllIIllIlIlIIlIIllIIIlll) != ' ') {
                            break;
                        }
                        ++lllllllllllIIllIlIlIIlIIllIIIlll;
                    }
                }
            }
            else {
                while (lllllllllllIIllIlIlIIlIIllIIlIII && lllllllllllIIllIlIlIIlIIllIIIlll > 0) {
                    if (this.text.charAt(lllllllllllIIllIlIlIIlIIllIIIlll - 1) != ' ') {
                        break;
                    }
                    --lllllllllllIIllIlIlIIlIIllIIIlll;
                }
                while (lllllllllllIIllIlIlIIlIIllIIIlll > 0 && this.text.charAt(lllllllllllIIllIlIlIIlIIllIIIlll - 1) != ' ') {
                    --lllllllllllIIllIlIlIIlIIllIIIlll;
                }
            }
        }
        return lllllllllllIIllIlIlIIlIIllIIIlll;
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                DrawHelper.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, new Color(30, 30, 30, 185).getRGB());
                DrawHelper.drawGradientRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, new Color(1, 1, 1, 255).getRGB(), new Color(5, 5, 5, 255).getRGB());
            }
            this.getClass();
            final int lllllllllllIIllIlIlIIlIIlIIIIIIl = this.enabledColor;
            final int lllllllllllIIllIlIlIIlIIlIIIIIII = this.cursorPosition - this.field_73816_n;
            int lllllllllllIIllIlIlIIlIIIlllllll = this.selectionEnd - this.field_73816_n;
            final String lllllllllllIIllIlIlIIlIIIllllllI = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_73816_n), this.getWidth());
            final boolean lllllllllllIIllIlIlIIlIIIlllllIl = lllllllllllIIllIlIlIIlIIlIIIIIII >= 0 && lllllllllllIIllIlIlIIlIIlIIIIIII <= lllllllllllIIllIlIlIIlIIIllllllI.length();
            final boolean lllllllllllIIllIlIlIIlIIIlllllII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && lllllllllllIIllIlIlIIlIIIlllllIl;
            final int lllllllllllIIllIlIlIIlIIIllllIll = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
            final int lllllllllllIIllIlIlIIlIIIllllIlI = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
            int lllllllllllIIllIlIlIIlIIIllllIIl = lllllllllllIIllIlIlIIlIIIllllIll;
            if (lllllllllllIIllIlIlIIlIIIlllllll > lllllllllllIIllIlIlIIlIIIllllllI.length()) {
                lllllllllllIIllIlIlIIlIIIlllllll = lllllllllllIIllIlIlIIlIIIllllllI.length();
            }
            if (lllllllllllIIllIlIlIIlIIIllllllI.length() > 0 && lllllllllllIIllIlIlIIlIIIlllllIl) {
                lllllllllllIIllIlIlIIlIIIllllllI.substring(0, lllllllllllIIllIlIlIIlIIlIIIIIII);
            }
            final boolean lllllllllllIIllIlIlIIlIIIllllIII = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int lllllllllllIIllIlIlIIlIIIlllIlll = lllllllllllIIllIlIlIIlIIIllllIIl;
            if (!lllllllllllIIllIlIlIIlIIIlllllIl) {
                lllllllllllIIllIlIlIIlIIIlllIlll = ((lllllllllllIIllIlIlIIlIIlIIIIIII > 0) ? (lllllllllllIIllIlIlIIlIIIllllIll + this.width) : lllllllllllIIllIlIlIIlIIIllllIll);
            }
            else if (lllllllllllIIllIlIlIIlIIIllllIII) {
                lllllllllllIIllIlIlIIlIIIlllIlll = lllllllllllIIllIlIlIIlIIIllllIIl - 1;
                --lllllllllllIIllIlIlIIlIIIllllIIl;
            }
            if (lllllllllllIIllIlIlIIlIIIllllllI.length() > 0 && lllllllllllIIllIlIlIIlIIIlllllIl) {
                lllllllllllIIllIlIlIIlIIIllllllI.length();
            }
            if (lllllllllllIIllIlIlIIlIIIlllllII && lllllllllllIIllIlIlIIlIIIllllIII) {
                Gui.drawRect(lllllllllllIIllIlIlIIlIIIlllIlll, lllllllllllIIllIlIlIIlIIIllllIlI - 1, lllllllllllIIllIlIlIIlIIIlllIlll + 1, lllllllllllIIllIlIlIIlIIIllllIlI + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
            }
            if (lllllllllllIIllIlIlIIlIIIlllllll != lllllllllllIIllIlIlIIlIIlIIIIIII) {
                final int lllllllllllIIllIlIlIIlIIIlllIllI = lllllllllllIIllIlIlIIlIIIllllIll + this.fontRenderer.getStringWidth(lllllllllllIIllIlIlIIlIIIllllllI.substring(0, lllllllllllIIllIlIlIIlIIIlllllll));
                this.drawCursorVertical(lllllllllllIIllIlIlIIlIIIlllIlll, lllllllllllIIllIlIlIIlIIIllllIlI - 1, lllllllllllIIllIlIlIIlIIIlllIllI - 1, lllllllllllIIllIlIlIIlIIIllllIlI + 1 + this.fontRenderer.FONT_HEIGHT);
            }
        }
    }
    
    public boolean textboxKeyTyped(final char lllllllllllIIllIlIlIIlIIlIlIIllI, final int lllllllllllIIllIlIlIIlIIlIlIlIII) {
        this.getClass();
        if (!this.isFocused) {
            return false;
        }
        switch (lllllllllllIIllIlIlIIlIIlIlIIllI) {
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
                switch (lllllllllllIIllIlIlIIlIIlIlIlIII) {
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
                            this.func_73784_d(-1);
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
                            this.func_73784_d(1);
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
                        if (ChatAllowedCharacters.isAllowedCharacter(lllllllllllIIllIlIlIIlIIlIlIIllI)) {
                            this.writeText(Character.toString(lllllllllllIIllIlIlIIlIIlIlIIllI));
                            return true;
                        }
                        return false;
                    }
                }
                break;
            }
        }
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public boolean func_73778_q() {
        return this.field_73823_s;
    }
    
    public String getSelectedtext() {
        final int lllllllllllIIllIlIlIIlIlIIIllIlI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllIIllIlIlIIlIlIIIllIIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(lllllllllllIIllIlIlIIlIlIIIllIlI, lllllllllllIIllIlIlIIlIlIIIllIIl);
    }
    
    public void func_73800_i(int lllllllllllIIllIlIlIIlIIIIIlIIIl) {
        final int lllllllllllIIllIlIlIIlIIIIIlIllI = this.text.length();
        if (lllllllllllIIllIlIlIIlIIIIIlIIIl > lllllllllllIIllIlIlIIlIIIIIlIllI) {
            lllllllllllIIllIlIlIIlIIIIIlIIIl = lllllllllllIIllIlIlIIlIIIIIlIllI;
        }
        if (lllllllllllIIllIlIlIIlIIIIIlIIIl < 0) {
            lllllllllllIIllIlIlIIlIIIIIlIIIl = 0;
        }
        this.selectionEnd = lllllllllllIIllIlIlIIlIIIIIlIIIl;
        if (this.fontRenderer != null) {
            if (this.field_73816_n > lllllllllllIIllIlIlIIlIIIIIlIllI) {
                this.field_73816_n = lllllllllllIIllIlIlIIlIIIIIlIllI;
            }
            final int lllllllllllIIllIlIlIIlIIIIIlIlIl = this.getWidth();
            final String lllllllllllIIllIlIlIIlIIIIIlIlII = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_73816_n), lllllllllllIIllIlIlIIlIIIIIlIlIl);
            final int lllllllllllIIllIlIlIIlIIIIIlIIll = lllllllllllIIllIlIlIIlIIIIIlIlII.length() + this.field_73816_n;
            if (lllllllllllIIllIlIlIIlIIIIIlIIIl == this.field_73816_n) {
                this.field_73816_n -= this.fontRenderer.trimStringToWidth(this.text, lllllllllllIIllIlIlIIlIIIIIlIlIl, true).length();
            }
            if (lllllllllllIIllIlIlIIlIIIIIlIIIl > lllllllllllIIllIlIlIIlIIIIIlIIll) {
                this.field_73816_n += lllllllllllIIllIlIlIIlIIIIIlIIIl - lllllllllllIIllIlIlIIlIIIIIlIIll;
            }
            else if (lllllllllllIIllIlIlIIlIIIIIlIIIl <= this.field_73816_n) {
                this.field_73816_n -= this.field_73816_n - lllllllllllIIllIlIlIIlIIIIIlIIIl;
            }
            if (this.field_73816_n < 0) {
                this.field_73816_n = 0;
            }
            if (this.field_73816_n > lllllllllllIIllIlIlIIlIIIIIlIllI) {
                this.field_73816_n = lllllllllllIIllIlIlIIlIIIIIlIllI;
            }
        }
    }
    
    public void mouseClicked(final int lllllllllllIIllIlIlIIlIIlIIlllII, final int lllllllllllIIllIlIlIIlIIlIIllIll, final int lllllllllllIIllIlIlIIlIIlIIllIlI) {
        final boolean lllllllllllIIllIlIlIIlIIlIIllIIl = lllllllllllIIllIlIlIIlIIlIIlllII >= this.xPos && lllllllllllIIllIlIlIIlIIlIIlllII < this.xPos + this.width && lllllllllllIIllIlIlIIlIIlIIllIll >= this.yPos && lllllllllllIIllIlIlIIlIIlIIllIll < this.yPos + this.height;
        if (this.canLoseFocus) {
            this.getClass();
            this.setFocused(lllllllllllIIllIlIlIIlIIlIIllIIl);
        }
        if (this.isFocused && lllllllllllIIllIlIlIIlIIlIIllIlI == 0) {
            int lllllllllllIIllIlIlIIlIIlIIllIII = lllllllllllIIllIlIlIIlIIlIIlllII - this.xPos;
            if (this.enableBackgroundDrawing) {
                lllllllllllIIllIlIlIIlIIlIIllIII -= 4;
            }
            final String lllllllllllIIllIlIlIIlIIlIIlIlll = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_73816_n), this.getWidth());
            this.setCursorPosition(this.fontRenderer.trimStringToWidth(lllllllllllIIllIlIlIIlIIlIIlIlll, lllllllllllIIllIlIlIIlIIlIIllIII).length() + this.field_73816_n);
        }
    }
    
    public void func_73794_g(final int lllllllllllIIllIlIlIIlIIIIlIlllI) {
        this.enabledColor = lllllllllllIIllIlIlIIlIIIIlIlllI;
    }
    
    public void writeText(final String lllllllllllIIllIlIlIIlIlIIIIlIll) {
        String lllllllllllIIllIlIlIIlIlIIIIlIlI = "";
        final String lllllllllllIIllIlIlIIlIlIIIIlIIl = ChatAllowedCharacters.filterAllowedCharacters(lllllllllllIIllIlIlIIlIlIIIIlIll);
        final int lllllllllllIIllIlIlIIlIlIIIIlIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllIIllIlIlIIlIlIIIIIlll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int lllllllllllIIllIlIlIIlIlIIIIIllI = this.maxStringLength - this.text.length() - (lllllllllllIIllIlIlIIlIlIIIIlIII - this.selectionEnd);
        final boolean lllllllllllIIllIlIlIIlIlIIIIIlIl = false;
        if (this.text.length() > 0) {
            lllllllllllIIllIlIlIIlIlIIIIlIlI = String.valueOf(lllllllllllIIllIlIlIIlIlIIIIlIlI) + this.text.substring(0, lllllllllllIIllIlIlIIlIlIIIIlIII);
        }
        int lllllllllllIIllIlIlIIlIlIIIIIIll = 0;
        if (lllllllllllIIllIlIlIIlIlIIIIIllI < lllllllllllIIllIlIlIIlIlIIIIlIIl.length()) {
            lllllllllllIIllIlIlIIlIlIIIIlIlI = String.valueOf(lllllllllllIIllIlIlIIlIlIIIIlIlI) + lllllllllllIIllIlIlIIlIlIIIIlIIl.substring(0, lllllllllllIIllIlIlIIlIlIIIIIllI);
            final int lllllllllllIIllIlIlIIlIlIIIIIlII = lllllllllllIIllIlIlIIlIlIIIIIllI;
        }
        else {
            lllllllllllIIllIlIlIIlIlIIIIlIlI = String.valueOf(lllllllllllIIllIlIlIIlIlIIIIlIlI) + lllllllllllIIllIlIlIIlIlIIIIlIIl;
            lllllllllllIIllIlIlIIlIlIIIIIIll = lllllllllllIIllIlIlIIlIlIIIIlIIl.length();
        }
        if (this.text.length() > 0 && lllllllllllIIllIlIlIIlIlIIIIIlll < this.text.length()) {
            lllllllllllIIllIlIlIIlIlIIIIlIlI = String.valueOf(lllllllllllIIllIlIlIIlIlIIIIlIlI) + this.text.substring(lllllllllllIIllIlIlIIlIlIIIIIlll);
        }
        this.text = lllllllllllIIllIlIlIIlIlIIIIlIlI.replaceAll(" ", "");
        this.func_73784_d(lllllllllllIIllIlIlIIlIlIIIIlIII - this.selectionEnd + lllllllllllIIllIlIlIIlIlIIIIIIll);
    }
    
    public void func_73784_d(final int lllllllllllIIllIlIlIIlIIlIllIlII) {
        this.setCursorPosition(this.selectionEnd + lllllllllllIIllIlIlIIlIIlIllIlII);
    }
    
    public void func_73779_a(final int lllllllllllIIllIlIlIIlIIllllIlII) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(lllllllllllIIllIlIlIIlIIllllIlII) - this.cursorPosition);
            }
        }
    }
}
