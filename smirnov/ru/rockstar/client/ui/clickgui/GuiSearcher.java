// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.client.gui.GuiScreen;
import com.google.common.base.Predicates;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiPageButtonList;
import com.google.common.base.Predicate;
import net.minecraft.client.gui.Gui;

public class GuiSearcher extends Gui
{
    public /* synthetic */ int xPosition;
    private /* synthetic */ int disabledColor;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ String text;
    public /* synthetic */ boolean isFocused;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private /* synthetic */ boolean isEnabled;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ int lineScrollOffset;
    private final /* synthetic */ int id;
    private /* synthetic */ Predicate<String> validator;
    private /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    private /* synthetic */ int cursorCounter;
    public /* synthetic */ int maxStringLength;
    public /* synthetic */ int yPosition;
    private final /* synthetic */ int height;
    private /* synthetic */ int selectionEnd;
    private final /* synthetic */ FontRenderer fontRendererInstance;
    private /* synthetic */ int cursorPosition;
    private final /* synthetic */ int width;
    
    public void setDisabledTextColour(final int llIlIIlllllllII) {
        this.disabledColor = llIlIIlllllllII;
    }
    
    public void moveCursorBy(final int llIlIlIlIIIlIIl) {
        this.setCursorPosition(this.selectionEnd + llIlIlIlIIIlIIl);
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void setFocused(final boolean llIlIIlllllIIIl) {
        if (llIlIIlllllIIIl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llIlIIlllllIIIl;
        if (Minecraft.getMinecraft().currentScreen != null) {
            Minecraft.getMinecraft().currentScreen.func_193975_a(llIlIIlllllIIIl);
        }
    }
    
    public void setTextColor(final int llIlIlIIIIIIIII) {
        this.enabledColor = llIlIlIIIIIIIII;
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public void setValidator(final Predicate<String> llIlIlIllllIllI) {
        this.validator = llIlIlIllllIllI;
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void drawTextBox() {
        if (this.getVisible()) {
            if (this.getEnableBackgroundDrawing()) {
                DrawHelper.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(30, 30, 30, 185).getRGB());
                DrawHelper.drawGradientRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(30, 30, 30, 190).getRGB(), new Color(30, 30, 30, 190).getRGB());
            }
            final int llIlIlIIlIlIlII = -1;
            final int llIlIlIIlIlIIll = this.cursorPosition - this.lineScrollOffset;
            int llIlIlIIlIlIIlI = this.selectionEnd - this.lineScrollOffset;
            final String llIlIlIIlIlIIIl = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean llIlIlIIlIlIIII = llIlIlIIlIlIIll >= 0 && llIlIlIIlIlIIll <= llIlIlIIlIlIIIl.length();
            final boolean llIlIlIIlIIllll = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llIlIlIIlIlIIII;
            final int llIlIlIIlIIlllI = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int llIlIlIIlIIllIl = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int llIlIlIIlIIllII = llIlIlIIlIIlllI;
            if (llIlIlIIlIlIIlI > llIlIlIIlIlIIIl.length()) {
                llIlIlIIlIlIIlI = llIlIlIIlIlIIIl.length();
            }
            if (!llIlIlIIlIlIIIl.isEmpty()) {
                String llIlIlIIlIIlIll = llIlIlIIlIlIIII ? llIlIlIIlIlIIIl.substring(0, llIlIlIIlIlIIll) : llIlIlIIlIlIIIl;
                if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && llIlIlIIlIIlIll.startsWith("/warp")) {
                    llIlIlIIlIIlIll = "/warp ";
                }
                if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && llIlIlIIlIIlIll.startsWith("/l")) {
                    llIlIlIIlIIlIll = "/l ";
                }
                llIlIlIIlIIllII = this.fontRendererInstance.drawStringWithShadow(llIlIlIIlIIlIll, (float)llIlIlIIlIIlllI, (float)llIlIlIIlIIllIl, llIlIlIIlIlIlII);
            }
            final boolean llIlIlIIlIIlIlI = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llIlIlIIlIIlIIl = llIlIlIIlIIllII;
            if (!llIlIlIIlIlIIII) {
                llIlIlIIlIIlIIl = ((llIlIlIIlIlIIll > 0) ? (llIlIlIIlIIlllI + this.width) : llIlIlIIlIIlllI);
            }
            else if (llIlIlIIlIIlIlI) {
                llIlIlIIlIIlIIl = llIlIlIIlIIllII - 1;
                --llIlIlIIlIIllII;
            }
            if (!llIlIlIIlIlIIIl.isEmpty() && llIlIlIIlIlIIII && llIlIlIIlIlIIll < llIlIlIIlIlIIIl.length()) {
                llIlIlIIlIIllII = this.fontRendererInstance.drawStringWithShadow(llIlIlIIlIlIIIl.substring(llIlIlIIlIlIIll), (float)llIlIlIIlIIllII, (float)llIlIlIIlIIllIl, llIlIlIIlIlIlII);
            }
            if (llIlIlIIlIIllll) {
                if (llIlIlIIlIIlIlI) {
                    Gui.drawRect(llIlIlIIlIIlIIl, llIlIlIIlIIllIl - 1, llIlIlIIlIIlIIl + 1, llIlIlIIlIIllIl + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
                }
                else {
                    this.fontRendererInstance.drawStringWithShadow("_", (float)llIlIlIIlIIlIIl, (float)llIlIlIIlIIllIl, llIlIlIIlIlIlII);
                }
            }
            if (llIlIlIIlIlIIlI != llIlIlIIlIlIIll) {
                final int llIlIlIIlIIlIII = llIlIlIIlIIlllI + this.fontRendererInstance.getStringWidth(llIlIlIIlIlIIIl.substring(0, llIlIlIIlIlIIlI));
                this.drawCursorVertical(llIlIlIIlIIlIIl, llIlIlIIlIIllIl - 1, llIlIlIIlIIlIII - 1, llIlIlIIlIIllIl + 1 + this.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }
    
    public void setCanLoseFocus(final boolean llIlIIlllIIllIl) {
        this.canLoseFocus = llIlIIlllIIllIl;
    }
    
    public void setMaxStringLength(final int llIlIlIIIIllIll) {
        this.maxStringLength = llIlIlIIIIllIll;
        if (this.text.length() > llIlIlIIIIllIll) {
            this.text = this.text.substring(0, llIlIlIIIIllIll);
        }
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public int getNthWordFromPosWS(final int llIlIlIlIIlllIl, final int llIlIlIlIIlIIll, final boolean llIlIlIlIIllIll) {
        int llIlIlIlIIllIlI = llIlIlIlIIlIIll;
        final boolean llIlIlIlIIllIIl = llIlIlIlIIlllIl < 0;
        for (int llIlIlIlIIllIII = Math.abs(llIlIlIlIIlllIl), llIlIlIlIIlIlll = 0; llIlIlIlIIlIlll < llIlIlIlIIllIII; ++llIlIlIlIIlIlll) {
            if (!llIlIlIlIIllIIl) {
                final int llIlIlIlIIlIllI = this.text.length();
                llIlIlIlIIllIlI = this.text.indexOf(32, llIlIlIlIIllIlI);
                if (llIlIlIlIIllIlI == -1) {
                    llIlIlIlIIllIlI = llIlIlIlIIlIllI;
                }
                else {
                    while (llIlIlIlIIllIll && llIlIlIlIIllIlI < llIlIlIlIIlIllI) {
                        if (this.text.charAt(llIlIlIlIIllIlI) != ' ') {
                            break;
                        }
                        ++llIlIlIlIIllIlI;
                    }
                }
            }
            else {
                while (llIlIlIlIIllIll && llIlIlIlIIllIlI > 0) {
                    if (this.text.charAt(llIlIlIlIIllIlI - 1) != ' ') {
                        break;
                    }
                    --llIlIlIlIIllIlI;
                }
                while (llIlIlIlIIllIlI > 0 && this.text.charAt(llIlIlIlIIllIlI - 1) != ' ') {
                    --llIlIlIlIIllIlI;
                }
            }
        }
        return llIlIlIlIIllIlI;
    }
    
    public GuiSearcher(final int llIlIllIIIllIlI, final FontRenderer llIlIllIIIllIIl, final int llIlIllIIIllIII, final int llIlIllIIIlIlll, final int llIlIllIIIlllIl, final int llIlIllIIIlllII) {
        this.maxStringLength = 32;
        this.text = "";
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.validator = (Predicate<String>)Predicates.alwaysTrue();
        this.id = llIlIllIIIllIlI;
        this.fontRendererInstance = llIlIllIIIllIIl;
        this.xPosition = llIlIllIIIllIII;
        this.yPosition = llIlIllIIIlIlll;
        this.width = llIlIllIIIlllIl;
        this.height = llIlIllIIIlllII;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public boolean textboxKeyTyped(final char llIlIlIIlllllII, final int llIlIlIIllllIII) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(llIlIlIIllllIII)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(llIlIlIIllllIII)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(llIlIlIIllllIII)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(llIlIlIIllllIII)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (llIlIlIIllllIII) {
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
                if (ChatAllowedCharacters.isAllowedCharacter(llIlIlIIlllllII)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(llIlIlIIlllllII));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public void setEnableBackgroundDrawing(final boolean llIlIlIIIIIlIII) {
        this.enableBackgroundDrawing = llIlIlIIIIIlIII;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public void setCursorPosition(final int llIlIlIIIIlIIII) {
        this.cursorPosition = llIlIlIIIIlIIII;
        final int llIlIlIIIIlIIlI = this.text.length();
        this.cursorPosition = MathHelper.clamp(this.cursorPosition, 0, llIlIlIIIIlIIlI);
        this.setSelectionPos(this.cursorPosition);
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void setEnabled(final boolean llIlIIllllIlIll) {
        this.isEnabled = llIlIIllllIlIll;
    }
    
    public void deleteFromCursor(final int llIlIlIlIlllllI) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llIlIlIllIIIIll = llIlIlIlIlllllI < 0;
                final int llIlIlIllIIIIlI = llIlIlIllIIIIll ? (this.cursorPosition + llIlIlIlIlllllI) : this.cursorPosition;
                final int llIlIlIllIIIIIl = llIlIlIllIIIIll ? this.cursorPosition : (this.cursorPosition + llIlIlIlIlllllI);
                String llIlIlIllIIIIII = "";
                if (llIlIlIllIIIIlI >= 0) {
                    llIlIlIllIIIIII = this.text.substring(0, llIlIlIllIIIIlI);
                }
                if (llIlIlIllIIIIIl < this.text.length()) {
                    llIlIlIllIIIIII = String.valueOf(llIlIlIllIIIIII) + this.text.substring(llIlIlIllIIIIIl);
                }
                if (this.validator.apply((Object)llIlIlIllIIIIII)) {
                    this.text = llIlIlIllIIIIII;
                    if (llIlIlIllIIIIll) {
                        this.moveCursorBy(llIlIlIlIlllllI);
                    }
                    this.func_190516_a(this.id, this.text);
                }
            }
        }
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setVisible(final boolean llIlIIlllIIIlII) {
        this.visible = llIlIIlllIIIlII;
    }
    
    public void setText(final String llIlIllIIIIIlIl) {
        if (this.validator.apply((Object)llIlIllIIIIIlIl)) {
            if (llIlIllIIIIIlIl.length() > this.maxStringLength) {
                this.text = llIlIllIIIIIlIl.substring(0, this.maxStringLength);
            }
            else {
                this.text = llIlIllIIIIIlIl;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public int getNthWordFromCursor(final int llIlIlIlIllIIIl) {
        return this.getNthWordFromPos(llIlIlIlIllIIIl, this.getCursorPosition());
    }
    
    public void deleteWords(final int llIlIlIllIIllII) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llIlIlIllIIllII) - this.cursorPosition);
            }
        }
    }
    
    public void setGuiResponder(final GuiPageButtonList.GuiResponder llIlIllIIIlIIIl) {
        this.guiResponder = llIlIllIIIlIIIl;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void writeText(final String llIlIlIlllIIIIl) {
        String llIlIlIlllIlIIl = "";
        final String llIlIlIlllIlIII = ChatAllowedCharacters.filterAllowedCharacters(llIlIlIlllIIIIl);
        final int llIlIlIlllIIlll = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llIlIlIlllIIllI = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llIlIlIlllIIlIl = this.maxStringLength - this.text.length() - (llIlIlIlllIIlll - llIlIlIlllIIllI);
        if (!this.text.isEmpty()) {
            llIlIlIlllIlIIl = String.valueOf(llIlIlIlllIlIIl) + this.text.substring(0, llIlIlIlllIIlll);
        }
        int llIlIlIlllIIIll = 0;
        if (llIlIlIlllIIlIl < llIlIlIlllIlIII.length()) {
            llIlIlIlllIlIIl = String.valueOf(llIlIlIlllIlIIl) + llIlIlIlllIlIII.substring(0, llIlIlIlllIIlIl);
            final int llIlIlIlllIIlII = llIlIlIlllIIlIl;
        }
        else {
            llIlIlIlllIlIIl = String.valueOf(llIlIlIlllIlIIl) + llIlIlIlllIlIII;
            llIlIlIlllIIIll = llIlIlIlllIlIII.length();
        }
        if (!this.text.isEmpty() && llIlIlIlllIIllI < this.text.length()) {
            llIlIlIlllIlIIl = String.valueOf(llIlIlIlllIlIIl) + this.text.substring(llIlIlIlllIIllI);
        }
        if (this.validator.apply((Object)llIlIlIlllIlIIl)) {
            this.text = llIlIlIlllIlIIl;
            this.moveCursorBy(llIlIlIlllIIlll - this.selectionEnd + llIlIlIlllIIIll);
            this.func_190516_a(this.id, this.text);
        }
    }
    
    public String getSelectedText() {
        final int llIlIlIlllllllI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llIlIlIllllllIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llIlIlIlllllllI, llIlIlIllllllIl);
    }
    
    private void drawCursorVertical(int llIlIlIIIlIlIIl, int llIlIlIIIlIlIII, int llIlIlIIIlIIlll, int llIlIlIIIlIIllI) {
        if (llIlIlIIIlIlIIl < llIlIlIIIlIIlll) {
            final int llIlIlIIIlIlllI = llIlIlIIIlIlIIl;
            llIlIlIIIlIlIIl = llIlIlIIIlIIlll;
            llIlIlIIIlIIlll = llIlIlIIIlIlllI;
        }
        if (llIlIlIIIlIlIII < llIlIlIIIlIIllI) {
            final int llIlIlIIIlIllIl = llIlIlIIIlIlIII;
            llIlIlIIIlIlIII = llIlIlIIIlIIllI;
            llIlIlIIIlIIllI = llIlIlIIIlIllIl;
        }
        if (llIlIlIIIlIIlll > this.xPosition + this.width) {
            llIlIlIIIlIIlll = this.xPosition + this.width;
        }
        if (llIlIlIIIlIlIIl > this.xPosition + this.width) {
            llIlIlIIIlIlIIl = this.xPosition + this.width;
        }
        final Tessellator llIlIlIIIlIllII = Tessellator.getInstance();
        final BufferBuilder llIlIlIIIlIlIll = llIlIlIIIlIllII.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        llIlIlIIIlIlIll.begin(7, DefaultVertexFormats.POSITION);
        llIlIlIIIlIlIll.pos(llIlIlIIIlIlIIl, llIlIlIIIlIIllI, 0.0).endVertex();
        llIlIlIIIlIlIll.pos(llIlIlIIIlIIlll, llIlIlIIIlIIllI, 0.0).endVertex();
        llIlIlIIIlIlIll.pos(llIlIlIIIlIIlll, llIlIlIIIlIlIII, 0.0).endVertex();
        llIlIlIIIlIlIll.pos(llIlIlIIIlIlIIl, llIlIlIIIlIlIII, 0.0).endVertex();
        llIlIlIIIlIllII.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }
    
    public boolean mouseClicked(final int llIlIlIIllIllll, final int llIlIlIIllIlllI, final int llIlIlIIllIllIl) {
        final boolean llIlIlIIllIllII = llIlIlIIllIllll >= this.xPosition && llIlIlIIllIllll < this.xPosition + this.width && llIlIlIIllIlllI >= this.yPosition && llIlIlIIllIlllI < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(llIlIlIIllIllII);
        }
        if (this.isFocused && llIlIlIIllIllII && llIlIlIIllIllIl == 0) {
            int llIlIlIIllIlIll = llIlIlIIllIllll - this.xPosition;
            if (this.enableBackgroundDrawing) {
                llIlIlIIllIlIll -= 4;
            }
            final String llIlIlIIllIlIlI = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRendererInstance.trimStringToWidth(llIlIlIIllIlIlI, llIlIlIIllIlIll).length() + this.lineScrollOffset);
            return true;
        }
        return false;
    }
    
    public void func_190516_a(final int llIlIlIllIlIllI, final String llIlIlIllIlIIlI) {
        if (this.guiResponder != null) {
            this.guiResponder.setEntryValue(llIlIlIllIlIllI, llIlIlIllIlIIlI);
        }
    }
    
    public void setSelectionPos(int llIlIIlllIlIlll) {
        final int llIlIIlllIlllII = this.text.length();
        if (llIlIIlllIlIlll > llIlIIlllIlllII) {
            llIlIIlllIlIlll = llIlIIlllIlllII;
        }
        if (llIlIIlllIlIlll < 0) {
            llIlIIlllIlIlll = 0;
        }
        this.selectionEnd = (int)llIlIIlllIlIlll;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > llIlIIlllIlllII) {
                this.lineScrollOffset = llIlIIlllIlllII;
            }
            final int llIlIIlllIllIll = this.getWidth();
            final String llIlIIlllIllIlI = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), llIlIIlllIllIll);
            final int llIlIIlllIllIIl = llIlIIlllIllIlI.length() + this.lineScrollOffset;
            if (llIlIIlllIlIlll == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.trimStringToWidth(this.text, llIlIIlllIllIll, true).length();
            }
            if (llIlIIlllIlIlll > llIlIIlllIllIIl) {
                this.lineScrollOffset += (int)(llIlIIlllIlIlll - llIlIIlllIllIIl);
            }
            else if (llIlIIlllIlIlll <= this.lineScrollOffset) {
                this.lineScrollOffset -= (int)(this.lineScrollOffset - llIlIIlllIlIlll);
            }
            this.lineScrollOffset = MathHelper.clamp(this.lineScrollOffset, 0, llIlIIlllIlllII);
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public int getNthWordFromPos(final int llIlIlIlIlIllII, final int llIlIlIlIlIlIII) {
        return this.getNthWordFromPosWS(llIlIlIlIlIllII, llIlIlIlIlIlIII, true);
    }
}
