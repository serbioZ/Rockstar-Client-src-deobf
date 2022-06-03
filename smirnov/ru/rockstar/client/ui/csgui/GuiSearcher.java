// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui;

import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import com.google.common.base.Predicates;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.client.gui.FontRenderer;
import com.google.common.base.Predicate;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.Gui;

public class GuiSearcher extends Gui
{
    private /* synthetic */ int lineScrollOffset;
    private /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    public /* synthetic */ int yPosition;
    private /* synthetic */ String text;
    private /* synthetic */ int disabledColor;
    private /* synthetic */ int cursorPosition;
    private /* synthetic */ Predicate<String> validator;
    private final /* synthetic */ int height;
    public /* synthetic */ int maxStringLength;
    private /* synthetic */ boolean canLoseFocus;
    private final /* synthetic */ int width;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ boolean enableBackgroundDrawing;
    public /* synthetic */ int xPosition;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean isEnabled;
    private final /* synthetic */ FontRenderer fontRendererInstance;
    private final /* synthetic */ int id;
    public /* synthetic */ boolean isFocused;
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void setEnableBackgroundDrawing(final boolean lllllllllllllIlIllIllIIIlllllIIl) {
        this.enableBackgroundDrawing = lllllllllllllIlIllIllIIIlllllIIl;
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void setMaxStringLength(final int lllllllllllllIlIllIllIIlIIIIllII) {
        this.maxStringLength = lllllllllllllIlIllIllIIlIIIIllII;
        if (this.text.length() > lllllllllllllIlIllIllIIlIIIIllII) {
            this.text = this.text.substring(0, lllllllllllllIlIllIllIIlIIIIllII);
        }
    }
    
    public void writeText(final String lllllllllllllIlIllIllIIlllIllIll) {
        String lllllllllllllIlIllIllIIlllIllIlI = "";
        final String lllllllllllllIlIllIllIIlllIllIIl = ChatAllowedCharacters.filterAllowedCharacters(lllllllllllllIlIllIllIIlllIllIll);
        final int lllllllllllllIlIllIllIIlllIllIII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIlIllIllIIlllIlIlll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int lllllllllllllIlIllIllIIlllIlIllI = this.maxStringLength - this.text.length() - (lllllllllllllIlIllIllIIlllIllIII - lllllllllllllIlIllIllIIlllIlIlll);
        if (!this.text.isEmpty()) {
            lllllllllllllIlIllIllIIlllIllIlI = String.valueOf(lllllllllllllIlIllIllIIlllIllIlI) + this.text.substring(0, lllllllllllllIlIllIllIIlllIllIII);
        }
        int lllllllllllllIlIllIllIIlllIlIlII = 0;
        if (lllllllllllllIlIllIllIIlllIlIllI < lllllllllllllIlIllIllIIlllIllIIl.length()) {
            lllllllllllllIlIllIllIIlllIllIlI = String.valueOf(lllllllllllllIlIllIllIIlllIllIlI) + lllllllllllllIlIllIllIIlllIllIIl.substring(0, lllllllllllllIlIllIllIIlllIlIllI);
            final int lllllllllllllIlIllIllIIlllIlIlIl = lllllllllllllIlIllIllIIlllIlIllI;
        }
        else {
            lllllllllllllIlIllIllIIlllIllIlI = String.valueOf(lllllllllllllIlIllIllIIlllIllIlI) + lllllllllllllIlIllIllIIlllIllIIl;
            lllllllllllllIlIllIllIIlllIlIlII = lllllllllllllIlIllIllIIlllIllIIl.length();
        }
        if (!this.text.isEmpty() && lllllllllllllIlIllIllIIlllIlIlll < this.text.length()) {
            lllllllllllllIlIllIllIIlllIllIlI = String.valueOf(lllllllllllllIlIllIllIIlllIllIlI) + this.text.substring(lllllllllllllIlIllIllIIlllIlIlll);
        }
        if (this.validator.apply((Object)lllllllllllllIlIllIllIIlllIllIlI)) {
            this.text = lllllllllllllIlIllIllIIlllIllIlI;
            this.moveCursorBy(lllllllllllllIlIllIllIIlllIllIII - this.selectionEnd + lllllllllllllIlIllIllIIlllIlIlII);
            this.func_190516_a(this.id, this.text);
        }
    }
    
    public void setTextColor(final int lllllllllllllIlIllIllIIIllllIIll) {
        this.enabledColor = lllllllllllllIlIllIllIIIllllIIll;
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public int getNthWordFromPosWS(final int lllllllllllllIlIllIllIIllIIIlllI, final int lllllllllllllIlIllIllIIllIIIllIl, final boolean lllllllllllllIlIllIllIIllIIIIIll) {
        int lllllllllllllIlIllIllIIllIIIlIll = lllllllllllllIlIllIllIIllIIIllIl;
        final boolean lllllllllllllIlIllIllIIllIIIlIlI = lllllllllllllIlIllIllIIllIIIlllI < 0;
        for (int lllllllllllllIlIllIllIIllIIIlIIl = Math.abs(lllllllllllllIlIllIllIIllIIIlllI), lllllllllllllIlIllIllIIllIIIlIII = 0; lllllllllllllIlIllIllIIllIIIlIII < lllllllllllllIlIllIllIIllIIIlIIl; ++lllllllllllllIlIllIllIIllIIIlIII) {
            if (!lllllllllllllIlIllIllIIllIIIlIlI) {
                final int lllllllllllllIlIllIllIIllIIIIlll = this.text.length();
                lllllllllllllIlIllIllIIllIIIlIll = this.text.indexOf(32, lllllllllllllIlIllIllIIllIIIlIll);
                if (lllllllllllllIlIllIllIIllIIIlIll == -1) {
                    lllllllllllllIlIllIllIIllIIIlIll = lllllllllllllIlIllIllIIllIIIIlll;
                }
                else {
                    while (lllllllllllllIlIllIllIIllIIIIIll && lllllllllllllIlIllIllIIllIIIlIll < lllllllllllllIlIllIllIIllIIIIlll) {
                        if (this.text.charAt(lllllllllllllIlIllIllIIllIIIlIll) != ' ') {
                            break;
                        }
                        ++lllllllllllllIlIllIllIIllIIIlIll;
                    }
                }
            }
            else {
                while (lllllllllllllIlIllIllIIllIIIIIll && lllllllllllllIlIllIllIIllIIIlIll > 0) {
                    if (this.text.charAt(lllllllllllllIlIllIllIIllIIIlIll - 1) != ' ') {
                        break;
                    }
                    --lllllllllllllIlIllIllIIllIIIlIll;
                }
                while (lllllllllllllIlIllIllIIllIIIlIll > 0 && this.text.charAt(lllllllllllllIlIllIllIIllIIIlIll - 1) != ' ') {
                    --lllllllllllllIlIllIllIIllIIIlIll;
                }
            }
        }
        return lllllllllllllIlIllIllIIllIIIlIll;
    }
    
    public int getId() {
        return this.id;
    }
    
    public GuiSearcher(final int lllllllllllllIlIllIllIlIIIIlIIlI, final FontRenderer lllllllllllllIlIllIllIlIIIIIlIlI, final int lllllllllllllIlIllIllIlIIIIlIIII, final int lllllllllllllIlIllIllIlIIIIIlIII, final int lllllllllllllIlIllIllIlIIIIIIlll, final int lllllllllllllIlIllIllIlIIIIIIllI) {
        this.maxStringLength = 32;
        this.text = "";
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.validator = (Predicate<String>)Predicates.alwaysTrue();
        this.id = lllllllllllllIlIllIllIlIIIIlIIlI;
        this.fontRendererInstance = lllllllllllllIlIllIllIlIIIIIlIlI;
        this.xPosition = lllllllllllllIlIllIllIlIIIIlIIII;
        this.yPosition = lllllllllllllIlIllIllIlIIIIIlIII;
        this.width = lllllllllllllIlIllIllIlIIIIIIlll;
        this.height = lllllllllllllIlIllIllIlIIIIIIllI;
    }
    
    public void setEnabled(final boolean lllllllllllllIlIllIllIIIllIllllI) {
        this.isEnabled = lllllllllllllIlIllIllIIIllIllllI;
    }
    
    public void setFocused(final boolean lllllllllllllIlIllIllIIIlllIIIlI) {
        if (lllllllllllllIlIllIllIIIlllIIIlI && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = lllllllllllllIlIllIllIIIlllIIIlI;
        if (Minecraft.getMinecraft().currentScreen != null) {
            Minecraft.getMinecraft().currentScreen.func_193975_a(lllllllllllllIlIllIllIIIlllIIIlI);
        }
    }
    
    public boolean mouseClicked(final int lllllllllllllIlIllIllIIlIlIllIIl, final int lllllllllllllIlIllIllIIlIlIllIII, final int lllllllllllllIlIllIllIIlIlIlIlll) {
        final boolean lllllllllllllIlIllIllIIlIlIlllIl = lllllllllllllIlIllIllIIlIlIllIIl >= this.xPosition && lllllllllllllIlIllIllIIlIlIllIIl < this.xPosition + this.width && lllllllllllllIlIllIllIIlIlIllIII >= this.yPosition && lllllllllllllIlIllIllIIlIlIllIII < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(lllllllllllllIlIllIllIIlIlIlllIl);
        }
        if (this.isFocused && lllllllllllllIlIllIllIIlIlIlllIl && lllllllllllllIlIllIllIIlIlIlIlll == 0) {
            int lllllllllllllIlIllIllIIlIlIlllII = lllllllllllllIlIllIllIIlIlIllIIl - this.xPosition;
            if (this.enableBackgroundDrawing) {
                lllllllllllllIlIllIllIIlIlIlllII -= 4;
            }
            final String lllllllllllllIlIllIllIIlIlIllIll = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRendererInstance.trimStringToWidth(lllllllllllllIlIllIllIIlIlIllIll, lllllllllllllIlIllIllIIlIlIlllII).length() + this.lineScrollOffset);
            return true;
        }
        return false;
    }
    
    public void moveCursorBy(final int lllllllllllllIlIllIllIIlIllllIII) {
        this.setCursorPosition(this.selectionEnd + lllllllllllllIlIllIllIIlIllllIII);
    }
    
    public boolean textboxKeyTyped(final char lllllllllllllIlIllIllIIlIllIllIl, final int lllllllllllllIlIllIllIIlIllIlIIl) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(lllllllllllllIlIllIllIIlIllIlIIl)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(lllllllllllllIlIllIllIIlIllIlIIl)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(lllllllllllllIlIllIllIIlIllIlIIl)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(lllllllllllllIlIllIllIIlIllIlIIl)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (lllllllllllllIlIllIllIIlIllIlIIl) {
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
                if (ChatAllowedCharacters.isAllowedCharacter(lllllllllllllIlIllIllIIlIllIllIl)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(lllllllllllllIlIllIllIIlIllIllIl));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void setText(final String lllllllllllllIlIllIllIIlllllIllI) {
        if (this.validator.apply((Object)lllllllllllllIlIllIllIIlllllIllI)) {
            if (lllllllllllllIlIllIllIIlllllIllI.length() > this.maxStringLength) {
                this.text = lllllllllllllIlIllIllIIlllllIllI.substring(0, this.maxStringLength);
            }
            else {
                this.text = lllllllllllllIlIllIllIIlllllIllI;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public void setCursorPosition(final int lllllllllllllIlIllIllIIlIIIIIIIl) {
        this.cursorPosition = lllllllllllllIlIllIllIIlIIIIIIIl;
        final int lllllllllllllIlIllIllIIlIIIIIIll = this.text.length();
        this.cursorPosition = MathHelper.clamp(this.cursorPosition, 0, lllllllllllllIlIllIllIIlIIIIIIll);
        this.setSelectionPos(this.cursorPosition);
    }
    
    public int getNthWordFromPos(final int lllllllllllllIlIllIllIIllIIllIlI, final int lllllllllllllIlIllIllIIllIIlllII) {
        return this.getNthWordFromPosWS(lllllllllllllIlIllIllIIllIIllIlI, lllllllllllllIlIllIllIIllIIlllII, true);
    }
    
    public void setCanLoseFocus(final boolean lllllllllllllIlIllIllIIIllIIIIII) {
        this.canLoseFocus = lllllllllllllIlIllIllIIIllIIIIII;
    }
    
    private void drawCursorVertical(int lllllllllllllIlIllIllIIlIIIllIlI, int lllllllllllllIlIllIllIIlIIIllIIl, int lllllllllllllIlIllIllIIlIIIllIII, int lllllllllllllIlIllIllIIlIIIlIlll) {
        if (lllllllllllllIlIllIllIIlIIIllIlI < lllllllllllllIlIllIllIIlIIIllIII) {
            final int lllllllllllllIlIllIllIIlIIIlllll = (int)lllllllllllllIlIllIllIIlIIIllIlI;
            lllllllllllllIlIllIllIIlIIIllIlI = lllllllllllllIlIllIllIIlIIIllIII;
            lllllllllllllIlIllIllIIlIIIllIII = lllllllllllllIlIllIllIIlIIIlllll;
        }
        if (lllllllllllllIlIllIllIIlIIIllIIl < lllllllllllllIlIllIllIIlIIIlIlll) {
            final int lllllllllllllIlIllIllIIlIIIllllI = lllllllllllllIlIllIllIIlIIIllIIl;
            lllllllllllllIlIllIllIIlIIIllIIl = (int)lllllllllllllIlIllIllIIlIIIlIlll;
            lllllllllllllIlIllIllIIlIIIlIlll = lllllllllllllIlIllIllIIlIIIllllI;
        }
        if (lllllllllllllIlIllIllIIlIIIllIII > this.xPosition + this.width) {
            lllllllllllllIlIllIllIIlIIIllIII = this.xPosition + this.width;
        }
        if (lllllllllllllIlIllIllIIlIIIllIlI > this.xPosition + this.width) {
            lllllllllllllIlIllIllIIlIIIllIlI = this.xPosition + this.width;
        }
        final Tessellator lllllllllllllIlIllIllIIlIIIlllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIlIllIllIIlIIIlllII = lllllllllllllIlIllIllIIlIIIlllIl.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        lllllllllllllIlIllIllIIlIIIlllII.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIlIllIllIIlIIIlllII.pos((double)lllllllllllllIlIllIllIIlIIIllIlI, (double)lllllllllllllIlIllIllIIlIIIlIlll, 0.0).endVertex();
        lllllllllllllIlIllIllIIlIIIlllII.pos(lllllllllllllIlIllIllIIlIIIllIII, (double)lllllllllllllIlIllIllIIlIIIlIlll, 0.0).endVertex();
        lllllllllllllIlIllIllIIlIIIlllII.pos(lllllllllllllIlIllIllIIlIIIllIII, lllllllllllllIlIllIllIIlIIIllIIl, 0.0).endVertex();
        lllllllllllllIlIllIllIIlIIIlllII.pos((double)lllllllllllllIlIllIllIIlIIIllIlI, lllllllllllllIlIllIllIIlIIIllIIl, 0.0).endVertex();
        lllllllllllllIlIllIllIIlIIIlllIl.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }
    
    public void setDisabledTextColour(final int lllllllllllllIlIllIllIIIlllIllIl) {
        this.disabledColor = lllllllllllllIlIllIllIIIlllIllIl;
    }
    
    public String getSelectedText() {
        final int lllllllllllllIlIllIllIIllllIllll = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIlIllIllIIllllIlllI = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(lllllllllllllIlIllIllIIllllIllll, lllllllllllllIlIllIllIIllllIlllI);
    }
    
    public void setSelectionPos(int lllllllllllllIlIllIllIIIllIIlIII) {
        final int lllllllllllllIlIllIllIIIllIIllIl = this.text.length();
        if (lllllllllllllIlIllIllIIIllIIlIII > lllllllllllllIlIllIllIIIllIIllIl) {
            lllllllllllllIlIllIllIIIllIIlIII = lllllllllllllIlIllIllIIIllIIllIl;
        }
        if (lllllllllllllIlIllIllIIIllIIlIII < 0) {
            lllllllllllllIlIllIllIIIllIIlIII = 0;
        }
        this.selectionEnd = (int)lllllllllllllIlIllIllIIIllIIlIII;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > lllllllllllllIlIllIllIIIllIIllIl) {
                this.lineScrollOffset = lllllllllllllIlIllIllIIIllIIllIl;
            }
            final int lllllllllllllIlIllIllIIIllIIllII = this.getWidth();
            final String lllllllllllllIlIllIllIIIllIIlIll = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), lllllllllllllIlIllIllIIIllIIllII);
            final int lllllllllllllIlIllIllIIIllIIlIlI = lllllllllllllIlIllIllIIIllIIlIll.length() + this.lineScrollOffset;
            if (lllllllllllllIlIllIllIIIllIIlIII == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.trimStringToWidth(this.text, lllllllllllllIlIllIllIIIllIIllII, true).length();
            }
            if (lllllllllllllIlIllIllIIIllIIlIII > lllllllllllllIlIllIllIIIllIIlIlI) {
                this.lineScrollOffset += (int)(lllllllllllllIlIllIllIIIllIIlIII - lllllllllllllIlIllIllIIIllIIlIlI);
            }
            else if (lllllllllllllIlIllIllIIIllIIlIII <= this.lineScrollOffset) {
                this.lineScrollOffset -= (int)(this.lineScrollOffset - lllllllllllllIlIllIllIIIllIIlIII);
            }
            this.lineScrollOffset = MathHelper.clamp(this.lineScrollOffset, 0, lllllllllllllIlIllIllIIIllIIllIl);
        }
    }
    
    public void setVisible(final boolean lllllllllllllIlIllIllIIIlIllIlIl) {
        this.visible = lllllllllllllIlIllIllIIIlIllIlIl;
    }
    
    public void deleteFromCursor(final int lllllllllllllIlIllIllIIllIlIllll) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean lllllllllllllIlIllIllIIllIllIlII = lllllllllllllIlIllIllIIllIlIllll < 0;
                final int lllllllllllllIlIllIllIIllIllIIll = lllllllllllllIlIllIllIIllIllIlII ? (this.cursorPosition + lllllllllllllIlIllIllIIllIlIllll) : this.cursorPosition;
                final int lllllllllllllIlIllIllIIllIllIIlI = lllllllllllllIlIllIllIIllIllIlII ? this.cursorPosition : (this.cursorPosition + lllllllllllllIlIllIllIIllIlIllll);
                String lllllllllllllIlIllIllIIllIllIIIl = "";
                if (lllllllllllllIlIllIllIIllIllIIll >= 0) {
                    lllllllllllllIlIllIllIIllIllIIIl = this.text.substring(0, lllllllllllllIlIllIllIIllIllIIll);
                }
                if (lllllllllllllIlIllIllIIllIllIIlI < this.text.length()) {
                    lllllllllllllIlIllIllIIllIllIIIl = String.valueOf(lllllllllllllIlIllIllIIllIllIIIl) + this.text.substring(lllllllllllllIlIllIllIIllIllIIlI);
                }
                if (this.validator.apply((Object)lllllllllllllIlIllIllIIllIllIIIl)) {
                    this.text = lllllllllllllIlIllIllIIllIllIIIl;
                    if (lllllllllllllIlIllIllIIllIllIlII) {
                        this.moveCursorBy(lllllllllllllIlIllIllIIllIlIllll);
                    }
                    this.func_190516_a(this.id, this.text);
                }
            }
        }
    }
    
    public void setValidator(final Predicate<String> lllllllllllllIlIllIllIIllllIIlIl) {
        this.validator = lllllllllllllIlIllIllIIllllIIlIl;
    }
    
    public void deleteWords(final int lllllllllllllIlIllIllIIllIllllIl) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(lllllllllllllIlIllIllIIllIllllIl) - this.cursorPosition);
            }
        }
    }
    
    public void func_190516_a(final int lllllllllllllIlIllIllIIlllIIIlll, final String lllllllllllllIlIllIllIIlllIIIIll) {
        if (this.guiResponder != null) {
            this.guiResponder.setEntryValue(lllllllllllllIlIllIllIIlllIIIlll, lllllllllllllIlIllIllIIlllIIIIll);
        }
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public String getText() {
        return this.text;
    }
    
    public void drawTextBox() {
        if (this.getVisible()) {
            if (this.getEnableBackgroundDrawing()) {
                DrawHelper.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(30, 30, 30, 185).getRGB());
                DrawHelper.drawGradientRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(30, 30, 30, 190).getRGB(), new Color(30, 30, 30, 190).getRGB());
            }
            final int lllllllllllllIlIllIllIIlIlIIIlIl = -1;
            final int lllllllllllllIlIllIllIIlIlIIIlII = this.cursorPosition - this.lineScrollOffset;
            int lllllllllllllIlIllIllIIlIlIIIIll = this.selectionEnd - this.lineScrollOffset;
            final String lllllllllllllIlIllIllIIlIlIIIIlI = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean lllllllllllllIlIllIllIIlIlIIIIIl = lllllllllllllIlIllIllIIlIlIIIlII >= 0 && lllllllllllllIlIllIllIIlIlIIIlII <= lllllllllllllIlIllIllIIlIlIIIIlI.length();
            final boolean lllllllllllllIlIllIllIIlIlIIIIII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && lllllllllllllIlIllIllIIlIlIIIIIl;
            final int lllllllllllllIlIllIllIIlIIllllll = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int lllllllllllllIlIllIllIIlIIlllllI = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int lllllllllllllIlIllIllIIlIIllllIl = lllllllllllllIlIllIllIIlIIllllll;
            if (lllllllllllllIlIllIllIIlIlIIIIll > lllllllllllllIlIllIllIIlIlIIIIlI.length()) {
                lllllllllllllIlIllIllIIlIlIIIIll = lllllllllllllIlIllIllIIlIlIIIIlI.length();
            }
            if (!lllllllllllllIlIllIllIIlIlIIIIlI.isEmpty()) {
                String lllllllllllllIlIllIllIIlIIllllII = lllllllllllllIlIllIllIIlIlIIIIIl ? lllllllllllllIlIllIllIIlIlIIIIlI.substring(0, lllllllllllllIlIllIllIIlIlIIIlII) : lllllllllllllIlIllIllIIlIlIIIIlI;
                if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && lllllllllllllIlIllIllIIlIIllllII.startsWith("/warp")) {
                    lllllllllllllIlIllIllIIlIIllllII = "/warp ";
                }
                if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && lllllllllllllIlIllIllIIlIIllllII.startsWith("/l")) {
                    lllllllllllllIlIllIllIIlIIllllII = "/l ";
                }
                lllllllllllllIlIllIllIIlIIllllIl = this.fontRendererInstance.drawStringWithShadow(lllllllllllllIlIllIllIIlIIllllII, (float)lllllllllllllIlIllIllIIlIIllllll, (float)lllllllllllllIlIllIllIIlIIlllllI, lllllllllllllIlIllIllIIlIlIIIlIl);
            }
            final boolean lllllllllllllIlIllIllIIlIIlllIll = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int lllllllllllllIlIllIllIIlIIlllIlI = lllllllllllllIlIllIllIIlIIllllIl;
            if (!lllllllllllllIlIllIllIIlIlIIIIIl) {
                lllllllllllllIlIllIllIIlIIlllIlI = ((lllllllllllllIlIllIllIIlIlIIIlII > 0) ? (lllllllllllllIlIllIllIIlIIllllll + this.width) : lllllllllllllIlIllIllIIlIIllllll);
            }
            else if (lllllllllllllIlIllIllIIlIIlllIll) {
                lllllllllllllIlIllIllIIlIIlllIlI = lllllllllllllIlIllIllIIlIIllllIl - 1;
                --lllllllllllllIlIllIllIIlIIllllIl;
            }
            if (!lllllllllllllIlIllIllIIlIlIIIIlI.isEmpty() && lllllllllllllIlIllIllIIlIlIIIIIl && lllllllllllllIlIllIllIIlIlIIIlII < lllllllllllllIlIllIllIIlIlIIIIlI.length()) {
                lllllllllllllIlIllIllIIlIIllllIl = this.fontRendererInstance.drawStringWithShadow(lllllllllllllIlIllIllIIlIlIIIIlI.substring(lllllllllllllIlIllIllIIlIlIIIlII), (float)lllllllllllllIlIllIllIIlIIllllIl, (float)lllllllllllllIlIllIllIIlIIlllllI, lllllllllllllIlIllIllIIlIlIIIlIl);
            }
            if (lllllllllllllIlIllIllIIlIlIIIIII) {
                if (lllllllllllllIlIllIllIIlIIlllIll) {
                    Gui.drawRect(lllllllllllllIlIllIllIIlIIlllIlI, lllllllllllllIlIllIllIIlIIlllllI - 1, lllllllllllllIlIllIllIIlIIlllIlI + 1, lllllllllllllIlIllIllIIlIIlllllI + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
                }
                else {
                    this.fontRendererInstance.drawStringWithShadow("_", (float)lllllllllllllIlIllIllIIlIIlllIlI, (float)lllllllllllllIlIllIllIIlIIlllllI, lllllllllllllIlIllIllIIlIlIIIlIl);
                }
            }
            if (lllllllllllllIlIllIllIIlIlIIIIll != lllllllllllllIlIllIllIIlIlIIIlII) {
                final int lllllllllllllIlIllIllIIlIIlllIIl = lllllllllllllIlIllIllIIlIIllllll + this.fontRendererInstance.getStringWidth(lllllllllllllIlIllIllIIlIlIIIIlI.substring(0, lllllllllllllIlIllIllIIlIlIIIIll));
                this.drawCursorVertical(lllllllllllllIlIllIllIIlIIlllIlI, lllllllllllllIlIllIllIIlIIlllllI - 1, lllllllllllllIlIllIllIIlIIlllIIl - 1, lllllllllllllIlIllIllIIlIIlllllI + 1 + this.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }
    
    public void setGuiResponder(final GuiPageButtonList.GuiResponder lllllllllllllIlIllIllIlIIIIIIIlI) {
        this.guiResponder = lllllllllllllIlIllIllIlIIIIIIIlI;
    }
    
    public int getNthWordFromCursor(final int lllllllllllllIlIllIllIIllIlIIIlI) {
        return this.getNthWordFromPos(lllllllllllllIlIllIllIIllIlIIIlI, this.getCursorPosition());
    }
}
