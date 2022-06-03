// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.text.TextComponentString;
import javax.annotation.Nullable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.text.ITextComponent;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import java.io.IOException;
import org.lwjgl.input.Mouse;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.TabCompleter;
import net.minecraft.util.ITabCompleter;

public class GuiChat extends GuiScreen implements ITabCompleter
{
    private /* synthetic */ int sentHistoryCursor;
    protected /* synthetic */ GuiTextField inputField;
    private /* synthetic */ TabCompleter tabCompleter;
    private /* synthetic */ String defaultInputFieldText;
    private /* synthetic */ String historyBuffer;
    
    @Override
    protected void setText(final String lllllllllllIIIIIIlIlllIllIIIIlII, final boolean lllllllllllIIIIIIlIlllIllIIIIllI) {
        if (lllllllllllIIIIIIlIlllIllIIIIllI) {
            this.inputField.setText(lllllllllllIIIIIIlIlllIllIIIIlII);
        }
        else {
            this.inputField.writeText(lllllllllllIIIIIIlIlllIllIIIIlII);
        }
    }
    
    public GuiChat() {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.defaultInputFieldText = "";
    }
    
    public void getSentHistory(final int lllllllllllIIIIIIlIlllIlIllllIIl) {
        int lllllllllllIIIIIIlIlllIlIlllllII = this.sentHistoryCursor + lllllllllllIIIIIIlIlllIlIllllIIl;
        final int lllllllllllIIIIIIlIlllIlIllllIll = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        lllllllllllIIIIIIlIlllIlIlllllII = MathHelper.clamp(lllllllllllIIIIIIlIlllIlIlllllII, 0, lllllllllllIIIIIIlIlllIlIllllIll);
        if (lllllllllllIIIIIIlIlllIlIlllllII != this.sentHistoryCursor) {
            if (lllllllllllIIIIIIlIlllIlIlllllII == lllllllllllIIIIIIlIlllIlIllllIll) {
                this.sentHistoryCursor = lllllllllllIIIIIIlIlllIlIllllIll;
                this.inputField.setText(this.historyBuffer);
            }
            else {
                if (this.sentHistoryCursor == lllllllllllIIIIIIlIlllIlIllllIll) {
                    this.historyBuffer = this.inputField.getText();
                }
                this.inputField.setText(this.mc.ingameGUI.getChatGUI().getSentMessages().get(lllllllllllIIIIIIlIlllIlIlllllII));
                this.sentHistoryCursor = lllllllllllIIIIIIlIlllIlIlllllII;
            }
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int lllllllllllIIIIIIlIlllIllIIlllIl = Mouse.getEventDWheel();
        if (lllllllllllIIIIIIlIlllIllIIlllIl != 0) {
            if (lllllllllllIIIIIIlIlllIllIIlllIl > 1) {
                lllllllllllIIIIIIlIlllIllIIlllIl = 1;
            }
            if (lllllllllllIIIIIIlIlllIllIIlllIl < -1) {
                lllllllllllIIIIIIlIlllIllIIlllIl = -1;
            }
            if (!GuiScreen.isShiftKeyDown()) {
                lllllllllllIIIIIIlIlllIllIIlllIl *= 7;
            }
            this.mc.ingameGUI.getChatGUI().scroll(lllllllllllIIIIIIlIlllIllIIlllIl);
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIIIIlIlllIlIlllIIII, final int lllllllllllIIIIIIlIlllIlIllIlIlI, final float lllllllllllIIIIIIlIlllIlIllIlIIl) {
        DrawHelper.drawRectWithGlow(4.0, this.height - 14.0, this.width - 4.0, this.height - 2.0, 7.0, 7.0, new Color(1, 1, 1, 200));
        this.inputField.drawTextBox1();
        final ITextComponent lllllllllllIIIIIIlIlllIlIllIllIl = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
        if (lllllllllllIIIIIIlIlllIlIllIllIl != null && lllllllllllIIIIIIlIlllIlIllIllIl.getStyle().getHoverEvent() != null) {
            this.handleComponentHover(lllllllllllIIIIIIlIlllIlIllIllIl, lllllllllllIIIIIIlIlllIlIlllIIII, lllllllllllIIIIIIlIlllIlIllIlIlI);
        }
        super.drawScreen(lllllllllllIIIIIIlIlllIlIlllIIII, lllllllllllIIIIIIlIlllIlIllIlIlI, lllllllllllIIIIIIlIlllIlIllIlIIl);
    }
    
    @Override
    public void setCompletions(final String... lllllllllllIIIIIIlIlllIlIllIIIll) {
        this.tabCompleter.setCompletions(lllllllllllIIIIIIlIlllIlIllIIIll);
    }
    
    public GuiChat(final String lllllllllllIIIIIIlIlllIllIllIllI) {
        this.historyBuffer = "";
        this.sentHistoryCursor = -1;
        this.defaultInputFieldText = "";
        this.defaultInputFieldText = lllllllllllIIIIIIlIlllIllIllIllI;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.ingameGUI.getChatGUI().resetScroll();
    }
    
    @Override
    public void updateScreen() {
        this.inputField.updateCursorCounter();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIIIIlIlllIllIlIIIll, final int lllllllllllIIIIIIlIlllIllIlIIllI) throws IOException {
        this.tabCompleter.resetRequested();
        if (lllllllllllIIIIIIlIlllIllIlIIllI == 15) {
            this.tabCompleter.complete();
        }
        else {
            this.tabCompleter.resetDidComplete();
        }
        if (lllllllllllIIIIIIlIlllIllIlIIllI == 1) {
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllIIIIIIlIlllIllIlIIllI != 28 && lllllllllllIIIIIIlIlllIllIlIIllI != 156) {
            if (lllllllllllIIIIIIlIlllIllIlIIllI == 200) {
                this.getSentHistory(-1);
            }
            else if (lllllllllllIIIIIIlIlllIllIlIIllI == 208) {
                this.getSentHistory(1);
            }
            else if (lllllllllllIIIIIIlIlllIllIlIIllI == 201) {
                this.mc.ingameGUI.getChatGUI().scroll(this.mc.ingameGUI.getChatGUI().getLineCount() - 1);
            }
            else if (lllllllllllIIIIIIlIlllIllIlIIllI == 209) {
                this.mc.ingameGUI.getChatGUI().scroll(-this.mc.ingameGUI.getChatGUI().getLineCount() + 1);
            }
            else {
                this.inputField.textboxKeyTyped(lllllllllllIIIIIIlIlllIllIlIIIll, lllllllllllIIIIIIlIlllIllIlIIllI);
            }
        }
        else {
            final String lllllllllllIIIIIIlIlllIllIlIIlIl = this.inputField.getText().trim();
            if (!lllllllllllIIIIIIlIlllIllIlIIlIl.isEmpty()) {
                this.sendChatMessage(lllllllllllIIIIIIlIlllIllIlIIlIl);
            }
            this.mc.displayGuiScreen(null);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.sentHistoryCursor = this.mc.ingameGUI.getChatGUI().getSentMessages().size();
        this.inputField = new GuiTextField(0, this.fontRendererObj, 4, this.height - 12, this.width - 4, 12);
        this.inputField.setMaxStringLength(256);
        this.inputField.setEnableBackgroundDrawing(false);
        this.inputField.setFocused(true);
        this.inputField.setText(this.defaultInputFieldText);
        this.inputField.setCanLoseFocus(false);
        this.tabCompleter = new ChatTabCompleter(this.inputField);
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIIIIIlIlllIllIIlIlII, final int lllllllllllIIIIIIlIlllIllIIlIIll, final int lllllllllllIIIIIIlIlllIllIIlIIlI) throws IOException {
        if (lllllllllllIIIIIIlIlllIllIIlIIlI == 0) {
            final ITextComponent lllllllllllIIIIIIlIlllIllIIlIIIl = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
            if (lllllllllllIIIIIIlIlllIllIIlIIIl != null && this.handleComponentClick(lllllllllllIIIIIIlIlllIllIIlIIIl)) {
                return;
            }
        }
        this.inputField.mouseClicked(lllllllllllIIIIIIlIlllIllIIlIlII, lllllllllllIIIIIIlIlllIllIIlIIll, lllllllllllIIIIIIlIlllIllIIlIIlI);
        super.mouseClicked(lllllllllllIIIIIIlIlllIllIIlIlII, lllllllllllIIIIIIlIlllIllIIlIIll, lllllllllllIIIIIIlIlllIllIIlIIlI);
    }
    
    public static class ChatTabCompleter extends TabCompleter
    {
        private final /* synthetic */ Minecraft clientInstance;
        
        public ChatTabCompleter(final GuiTextField lllllllllllllIIllIllIIIIIllIIllI) {
            super(lllllllllllllIIllIllIIIIIllIIllI, false);
            this.clientInstance = Minecraft.getMinecraft();
        }
        
        @Nullable
        @Override
        public BlockPos getTargetBlockPos() {
            BlockPos lllllllllllllIIllIllIIIIIlIlIlll = null;
            if (this.clientInstance.objectMouseOver != null && this.clientInstance.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                lllllllllllllIIllIllIIIIIlIlIlll = this.clientInstance.objectMouseOver.getBlockPos();
            }
            return lllllllllllllIIllIllIIIIIlIlIlll;
        }
        
        @Override
        public void complete() {
            super.complete();
            if (this.completions.size() > 1) {
                final StringBuilder lllllllllllllIIllIllIIIIIllIIIII = new StringBuilder();
                for (final String lllllllllllllIIllIllIIIIIlIlllll : this.completions) {
                    if (lllllllllllllIIllIllIIIIIllIIIII.length() > 0) {
                        lllllllllllllIIllIllIIIIIllIIIII.append(", ");
                    }
                    lllllllllllllIIllIllIIIIIllIIIII.append(lllllllllllllIIllIllIIIIIlIlllll);
                }
                this.clientInstance.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString(lllllllllllllIIllIllIIIIIllIIIII.toString()), 1);
            }
        }
    }
}
