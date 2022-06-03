// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.util.Arrays;
import java.awt.datatransfer.DataFlavor;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.text.event.HoverEvent;
import java.util.Iterator;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.input.Mouse;
import java.io.File;
import java.util.Locale;
import java.net.URISyntaxException;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.util.ITooltipFlag;
import com.google.common.collect.Lists;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import java.io.IOException;
import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.Minecraft;
import java.util.Set;
import java.net.URI;
import org.apache.logging.log4j.Logger;
import java.util.List;
import com.google.common.base.Splitter;

public abstract class GuiScreen extends Gui implements GuiYesNoCallback
{
    public /* synthetic */ int height;
    protected /* synthetic */ List<GuiLabel> labelList;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ int width;
    private /* synthetic */ URI clickedLinkURI;
    public /* synthetic */ int eventButton;
    private /* synthetic */ boolean field_193977_u;
    protected /* synthetic */ GuiButton selectedButton;
    private /* synthetic */ int touchValue;
    private static final /* synthetic */ Set<String> PROTOCOLS;
    private /* synthetic */ long lastMouseEvent;
    protected /* synthetic */ Minecraft mc;
    protected /* synthetic */ RenderItem itemRender;
    protected /* synthetic */ List<GuiButton> buttonList;
    protected /* synthetic */ FontRenderer fontRendererObj;
    
    public void func_193975_a(final boolean lllllllllllIIIlllllllIIIlIIIIIIl) {
        this.field_193977_u = lllllllllllIIIlllllllIIIlIIIIIIl;
    }
    
    public static boolean isShiftKeyDown() {
        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
    }
    
    protected void renderToolTip(final ItemStack lllllllllllIIIlllllllIIIlIlIIIIl, final int lllllllllllIIIlllllllIIIlIlIIIII, final int lllllllllllIIIlllllllIIIlIIlllll) {
        this.drawHoveringText(this.func_191927_a(lllllllllllIIIlllllllIIIlIlIIIIl), lllllllllllIIIlllllllIIIlIlIIIII, lllllllllllIIIlllllllIIIlIIlllll);
    }
    
    public void setGuiSize(final int lllllllllllIIIllllllIlllllIllllI, final int lllllllllllIIIllllllIlllllIlllIl) {
        this.width = lllllllllllIIIllllllIlllllIllllI;
        this.height = lllllllllllIIIllllllIlllllIlllIl;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        PROTOCOLS = Sets.newHashSet((Object[])new String[] { "http", "https" });
        NEWLINE_SPLITTER = Splitter.on('\n');
    }
    
    public static boolean isCtrlKeyDown() {
        if (Minecraft.IS_RUNNING_ON_MAC) {
            return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
        }
        return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
    }
    
    protected void mouseClicked(final int lllllllllllIIIlllllllIIIIIIIllll, final int lllllllllllIIIlllllllIIIIIIIlIII, final int lllllllllllIIIlllllllIIIIIIIIlll) throws IOException {
        if (lllllllllllIIIlllllllIIIIIIIIlll == 0) {
            for (int lllllllllllIIIlllllllIIIIIIIllII = 0; lllllllllllIIIlllllllIIIIIIIllII < this.buttonList.size(); ++lllllllllllIIIlllllllIIIIIIIllII) {
                final GuiButton lllllllllllIIIlllllllIIIIIIIlIll = this.buttonList.get(lllllllllllIIIlllllllIIIIIIIllII);
                if (lllllllllllIIIlllllllIIIIIIIlIll.mousePressed(this.mc, lllllllllllIIIlllllllIIIIIIIllll, lllllllllllIIIlllllllIIIIIIIlIII)) {
                    this.selectedButton = lllllllllllIIIlllllllIIIIIIIlIll;
                    lllllllllllIIIlllllllIIIIIIIlIll.playPressSound(this.mc.getSoundHandler());
                    this.actionPerformed(lllllllllllIIIlllllllIIIIIIIlIll);
                }
            }
        }
    }
    
    public void drawBackground(final int lllllllllllIIIllllllIllllIllIIlI) {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        final Tessellator lllllllllllIIIllllllIllllIllIIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIllllllIllllIllIIII = lllllllllllIIIllllllIllllIllIIIl.getBuffer();
        this.mc.getTextureManager().bindTexture(GuiScreen.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float lllllllllllIIIllllllIllllIlIllll = 32.0f;
        lllllllllllIIIllllllIllllIllIIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllIIIllllllIllllIllIIII.pos(0.0, this.height, 0.0).tex(0.0, this.height / 32.0f + lllllllllllIIIllllllIllllIllIIlI).color(64, 64, 64, 255).endVertex();
        lllllllllllIIIllllllIllllIllIIII.pos(this.width, this.height, 0.0).tex(this.width / 32.0f, this.height / 32.0f + lllllllllllIIIllllllIllllIllIIlI).color(64, 64, 64, 255).endVertex();
        lllllllllllIIIllllllIllllIllIIII.pos(this.width, 0.0, 0.0).tex(this.width / 32.0f, lllllllllllIIIllllllIllllIllIIlI).color(64, 64, 64, 255).endVertex();
        lllllllllllIIIllllllIllllIllIIII.pos(0.0, 0.0, 0.0).tex(0.0, lllllllllllIIIllllllIllllIllIIlI).color(64, 64, 64, 255).endVertex();
        lllllllllllIIIllllllIllllIllIIIl.draw();
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllIIIllllllIllllIlIIIIl, final int lllllllllllIIIllllllIllllIlIIIII) {
        if (lllllllllllIIIllllllIllllIlIIIII == 31102009) {
            if (lllllllllllIIIllllllIllllIlIIIIl) {
                this.openWebLink(this.clickedLinkURI);
            }
            this.clickedLinkURI = null;
            this.mc.displayGuiScreen(this);
        }
    }
    
    public static boolean isKeyComboCtrlA(final int lllllllllllIIIllllllIllllIIIlIIl) {
        return lllllllllllIIIllllllIllllIIIlIIl == 30 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    public static void setClipboardString(final String lllllllllllIIIlllllllIIIlIlIllII) {
        if (!StringUtils.isEmpty((CharSequence)lllllllllllIIIlllllllIIIlIlIllII)) {
            try {
                final StringSelection lllllllllllIIIlllllllIIIlIlIllIl = new StringSelection(lllllllllllIIIlllllllIIIlIlIllII);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(lllllllllllIIIlllllllIIIlIlIllIl, null);
            }
            catch (Exception ex) {}
        }
    }
    
    public GuiScreen() {
        this.buttonList = (List<GuiButton>)Lists.newArrayList();
        this.labelList = (List<GuiLabel>)Lists.newArrayList();
    }
    
    public void updateScreen() {
    }
    
    public void drawWorldBackground(final int lllllllllllIIIllllllIllllIlllIIl) {
        if (this.mc.world != null) {
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        }
        else {
            this.drawBackground(lllllllllllIIIllllllIllllIlllIIl);
        }
    }
    
    public static boolean isAltKeyDown() {
        return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
    }
    
    public void onGuiClosed() {
    }
    
    public List<String> func_191927_a(final ItemStack lllllllllllIIIlllllllIIIlIIlIlIl) {
        final List<String> lllllllllllIIIlllllllIIIlIIllIII = lllllllllllIIIlllllllIIIlIIlIlIl.getTooltip(this.mc.player, this.mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
        for (int lllllllllllIIIlllllllIIIlIIlIlll = 0; lllllllllllIIIlllllllIIIlIIlIlll < lllllllllllIIIlllllllIIIlIIllIII.size(); ++lllllllllllIIIlllllllIIIlIIlIlll) {
            if (lllllllllllIIIlllllllIIIlIIlIlll == 0) {
                lllllllllllIIIlllllllIIIlIIllIII.set(lllllllllllIIIlllllllIIIlIIlIlll, lllllllllllIIIlllllllIIIlIIlIlIl.getRarity().rarityColor + lllllllllllIIIlllllllIIIlIIllIII.get(lllllllllllIIIlllllllIIIlIIlIlll));
            }
            else {
                lllllllllllIIIlllllllIIIlIIllIII.set(lllllllllllIIIlllllllIIIlIIlIlll, TextFormatting.GRAY + lllllllllllIIIlllllllIIIlIIllIII.get(lllllllllllIIIlllllllIIIlIIlIlll));
            }
        }
        return lllllllllllIIIlllllllIIIlIIllIII;
    }
    
    public void sendChatMessage(final String lllllllllllIIIlllllllIIIIIlIIIII) {
        this.sendChatMessage(lllllllllllIIIlllllllIIIIIlIIIII, true);
    }
    
    protected void mouseClickMove(final int lllllllllllIIIllllllIlllllllIlll, final int lllllllllllIIIllllllIlllllllIllI, final int lllllllllllIIIllllllIlllllllIlIl, final long lllllllllllIIIllllllIlllllllIlII) {
    }
    
    public void drawScreen(final int lllllllllllIIIlllllllIIIllIIlIll, final int lllllllllllIIIlllllllIIIllIIlIlI, final float lllllllllllIIIlllllllIIIllIIIIll) {
        for (final GuiButton lllllllllllIIIlllllllIIIllIIlIII : this.buttonList) {
            lllllllllllIIIlllllllIIIllIIlIII.drawButton(this.mc, lllllllllllIIIlllllllIIIllIIlIll, lllllllllllIIIlllllllIIIllIIlIlI, lllllllllllIIIlllllllIIIllIIIIll);
        }
        for (final GuiLabel lllllllllllIIIlllllllIIIllIIIlll : this.labelList) {
            lllllllllllIIIlllllllIIIllIIIlll.drawLabel(this.mc, lllllllllllIIIlllllllIIIllIIlIll, lllllllllllIIIlllllllIIIllIIlIlI);
        }
    }
    
    public void handleKeyboardInput() throws IOException {
        final char lllllllllllIIIllllllIlllllIIIllI = Keyboard.getEventCharacter();
        if ((Keyboard.getEventKey() == 0 && lllllllllllIIIllllllIlllllIIIllI >= ' ') || Keyboard.getEventKeyState()) {
            this.keyTyped(lllllllllllIIIllllllIlllllIIIllI, Keyboard.getEventKey());
        }
        this.mc.dispatchKeypresses();
    }
    
    public void drawDefaultBackground() {
        this.drawWorldBackground(0);
    }
    
    public boolean handleComponentClick(final ITextComponent lllllllllllIIIlllllllIIIIIlIlIIl) {
        if (lllllllllllIIIlllllllIIIIIlIlIIl == null) {
            return false;
        }
        final ClickEvent lllllllllllIIIlllllllIIIIIlIllll = lllllllllllIIIlllllllIIIIIlIlIIl.getStyle().getClickEvent();
        if (isShiftKeyDown()) {
            if (lllllllllllIIIlllllllIIIIIlIlIIl.getStyle().getInsertion() != null) {
                this.setText(lllllllllllIIIlllllllIIIIIlIlIIl.getStyle().getInsertion(), false);
            }
        }
        else if (lllllllllllIIIlllllllIIIIIlIllll != null) {
            if (lllllllllllIIIlllllllIIIIIlIllll.getAction() == ClickEvent.Action.OPEN_URL) {
                if (!this.mc.gameSettings.chatLinks) {
                    return false;
                }
                try {
                    final URI lllllllllllIIIlllllllIIIIIlIlllI = new URI(lllllllllllIIIlllllllIIIIIlIllll.getValue());
                    final String lllllllllllIIIlllllllIIIIIlIllIl = lllllllllllIIIlllllllIIIIIlIlllI.getScheme();
                    if (lllllllllllIIIlllllllIIIIIlIllIl == null) {
                        throw new URISyntaxException(lllllllllllIIIlllllllIIIIIlIllll.getValue(), "Missing protocol");
                    }
                    if (!GuiScreen.PROTOCOLS.contains(lllllllllllIIIlllllllIIIIIlIllIl.toLowerCase(Locale.ROOT))) {
                        throw new URISyntaxException(lllllllllllIIIlllllllIIIIIlIllll.getValue(), "Unsupported protocol: " + lllllllllllIIIlllllllIIIIIlIllIl.toLowerCase(Locale.ROOT));
                    }
                    if (this.mc.gameSettings.chatLinksPrompt) {
                        this.clickedLinkURI = lllllllllllIIIlllllllIIIIIlIlllI;
                        this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, lllllllllllIIIlllllllIIIIIlIllll.getValue(), 31102009, false));
                    }
                    else {
                        this.openWebLink(lllllllllllIIIlllllllIIIIIlIlllI);
                    }
                }
                catch (URISyntaxException lllllllllllIIIlllllllIIIIIlIllII) {
                    GuiScreen.LOGGER.error("Can't open url for {}", (Object)lllllllllllIIIlllllllIIIIIlIllll, (Object)lllllllllllIIIlllllllIIIIIlIllII);
                }
            }
            else if (lllllllllllIIIlllllllIIIIIlIllll.getAction() == ClickEvent.Action.OPEN_FILE) {
                final URI lllllllllllIIIlllllllIIIIIlIlIll = new File(lllllllllllIIIlllllllIIIIIlIllll.getValue()).toURI();
                this.openWebLink(lllllllllllIIIlllllllIIIIIlIlIll);
            }
            else if (lllllllllllIIIlllllllIIIIIlIllll.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
                this.setText(lllllllllllIIIlllllllIIIIIlIllll.getValue(), true);
            }
            else if (lllllllllllIIIlllllllIIIIIlIllll.getAction() == ClickEvent.Action.RUN_COMMAND) {
                this.sendChatMessage(lllllllllllIIIlllllllIIIIIlIllll.getValue(), false);
            }
            else {
                GuiScreen.LOGGER.error("Don't know how to handle {}", (Object)lllllllllllIIIlllllllIIIIIlIllll);
            }
            return true;
        }
        return false;
    }
    
    protected void actionPerformed(final GuiButton lllllllllllIIIllllllIlllllllIIlI) throws IOException {
    }
    
    protected void mouseReleased(final int lllllllllllIIIllllllIllllllllIll, final int lllllllllllIIIllllllIllllllllIlI, final int lllllllllllIIIllllllIllllllllIIl) {
        if (this.selectedButton != null && lllllllllllIIIllllllIllllllllIIl == 0) {
            this.selectedButton.mouseReleased(lllllllllllIIIllllllIllllllllIll, lllllllllllIIIllllllIllllllllIlI);
            this.selectedButton = null;
        }
    }
    
    public void handleInput() throws IOException {
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                this.handleMouseInput();
            }
        }
        if (Keyboard.isCreated()) {
            while (Keyboard.next()) {
                this.handleKeyboardInput();
            }
        }
    }
    
    public void onResize(final Minecraft lllllllllllIIIllllllIlllIllllllI, final int lllllllllllIIIllllllIlllIlllllIl, final int lllllllllllIIIllllllIllllIIIIIII) {
        this.setWorldAndResolution(lllllllllllIIIllllllIlllIllllllI, lllllllllllIIIllllllIlllIlllllIl, lllllllllllIIIllllllIllllIIIIIII);
    }
    
    public void initGui() {
    }
    
    public static boolean isKeyComboCtrlC(final int lllllllllllIIIllllllIllllIIIllII) {
        return lllllllllllIIIllllllIllllIIIllII == 46 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    private void openWebLink(final URI lllllllllllIIIllllllIllllIIlIllI) {
        try {
            final Class<?> lllllllllllIIIllllllIllllIIllIlI = Class.forName("java.awt.Desktop");
            final Object lllllllllllIIIllllllIllllIIllIIl = lllllllllllIIIllllllIllllIIllIlI.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            lllllllllllIIIllllllIllllIIllIlI.getMethod("browse", URI.class).invoke(lllllllllllIIIllllllIllllIIllIIl, lllllllllllIIIllllllIllllIIlIllI);
        }
        catch (Throwable lllllllllllIIIllllllIllllIIllIII) {
            final Throwable lllllllllllIIIllllllIllllIIlIlll = lllllllllllIIIllllllIllllIIllIII.getCause();
            GuiScreen.LOGGER.error("Couldn't open link: {}", (Object)((lllllllllllIIIllllllIllllIIlIlll == null) ? "<UNKNOWN>" : lllllllllllIIIllllllIllllIIlIlll.getMessage()));
        }
    }
    
    protected <T extends GuiButton> T addButton(final T lllllllllllIIIlllllllIIIlIllIlII) {
        this.buttonList.add(lllllllllllIIIlllllllIIIlIllIlII);
        return lllllllllllIIIlllllllIIIlIllIlII;
    }
    
    public void handleMouseInput() throws IOException {
        final int lllllllllllIIIllllllIlllllIlIIlI = Mouse.getEventX() * this.width / this.mc.displayWidth;
        final int lllllllllllIIIllllllIlllllIlIIIl = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
        final int lllllllllllIIIllllllIlllllIlIIII = Mouse.getEventButton();
        if (Mouse.getEventButtonState()) {
            if (this.mc.gameSettings.touchscreen && this.touchValue++ > 0) {
                return;
            }
            this.eventButton = lllllllllllIIIllllllIlllllIlIIII;
            this.lastMouseEvent = Minecraft.getSystemTime();
            this.mouseClicked(lllllllllllIIIllllllIlllllIlIIlI, lllllllllllIIIllllllIlllllIlIIIl, this.eventButton);
        }
        else if (lllllllllllIIIllllllIlllllIlIIII != -1) {
            if (this.mc.gameSettings.touchscreen && --this.touchValue > 0) {
                return;
            }
            this.eventButton = -1;
            this.mouseReleased(lllllllllllIIIllllllIlllllIlIIlI, lllllllllllIIIllllllIlllllIlIIIl, lllllllllllIIIllllllIlllllIlIIII);
        }
        else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
            final long lllllllllllIIIllllllIlllllIIllll = Minecraft.getSystemTime() - this.lastMouseEvent;
            this.mouseClickMove(lllllllllllIIIllllllIlllllIlIIlI, lllllllllllIIIllllllIlllllIlIIIl, this.eventButton, lllllllllllIIIllllllIlllllIIllll);
        }
    }
    
    protected void setText(final String lllllllllllIIIlllllllIIIIIlllIII, final boolean lllllllllllIIIlllllllIIIIIllIlll) {
    }
    
    public static boolean isKeyComboCtrlV(final int lllllllllllIIIllllllIllllIIIllll) {
        return lllllllllllIIIllllllIllllIIIllll == 47 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    public boolean func_193976_p() {
        return this.field_193977_u;
    }
    
    public void drawHoveringText(final List<String> lllllllllllIIIlllllllIIIIllIllll, final int lllllllllllIIIlllllllIIIIllIlllI, final int lllllllllllIIIlllllllIIIIllIllIl) {
        if (!lllllllllllIIIlllllllIIIIllIllll.isEmpty()) {
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int lllllllllllIIIlllllllIIIIllIllII = 0;
            for (final String lllllllllllIIIlllllllIIIIllIlIll : lllllllllllIIIlllllllIIIIllIllll) {
                final int lllllllllllIIIlllllllIIIIllIlIlI = this.fontRendererObj.getStringWidth(lllllllllllIIIlllllllIIIIllIlIll);
                if (lllllllllllIIIlllllllIIIIllIlIlI > lllllllllllIIIlllllllIIIIllIllII) {
                    lllllllllllIIIlllllllIIIIllIllII = lllllllllllIIIlllllllIIIIllIlIlI;
                }
            }
            int lllllllllllIIIlllllllIIIIllIlIIl = lllllllllllIIIlllllllIIIIllIlllI + 12;
            int lllllllllllIIIlllllllIIIIllIlIII = lllllllllllIIIlllllllIIIIllIllIl - 12;
            int lllllllllllIIIlllllllIIIIllIIlll = 8;
            if (lllllllllllIIIlllllllIIIIllIllll.size() > 1) {
                lllllllllllIIIlllllllIIIIllIIlll += 2 + (lllllllllllIIIlllllllIIIIllIllll.size() - 1) * 10;
            }
            if (lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII > this.width) {
                lllllllllllIIIlllllllIIIIllIlIIl -= 28 + lllllllllllIIIlllllllIIIIllIllII;
            }
            if (lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 6 > this.height) {
                lllllllllllIIIlllllllIIIIllIlIII = this.height - lllllllllllIIIlllllllIIIIllIIlll - 6;
            }
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            final int lllllllllllIIIlllllllIIIIllIIllI = -267386864;
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII - 4, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII - 3, -267386864, -267386864);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 4, -267386864, -267386864);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII - 3, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3, -267386864, -267386864);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 4, lllllllllllIIIlllllllIIIIllIlIII - 3, lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3, -267386864, -267386864);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII - 3, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 4, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3, -267386864, -267386864);
            final int lllllllllllIIIlllllllIIIIllIIlIl = 1347420415;
            final int lllllllllllIIIlllllllIIIIllIIlII = 1344798847;
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII - 3 + 1, lllllllllllIIIlllllllIIIIllIlIIl - 3 + 1, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3 - 1, 1347420415, 1344798847);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 2, lllllllllllIIIlllllllIIIIllIlIII - 3 + 1, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3 - 1, 1347420415, 1344798847);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII - 3, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII - 3 + 1, 1347420415, 1347420415);
            this.drawGradientRect(lllllllllllIIIlllllllIIIIllIlIIl - 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 2, lllllllllllIIIlllllllIIIIllIlIIl + lllllllllllIIIlllllllIIIIllIllII + 3, lllllllllllIIIlllllllIIIIllIlIII + lllllllllllIIIlllllllIIIIllIIlll + 3, 1344798847, 1344798847);
            for (int lllllllllllIIIlllllllIIIIllIIIll = 0; lllllllllllIIIlllllllIIIIllIIIll < lllllllllllIIIlllllllIIIIllIllll.size(); ++lllllllllllIIIlllllllIIIIllIIIll) {
                final String lllllllllllIIIlllllllIIIIllIIIlI = lllllllllllIIIlllllllIIIIllIllll.get(lllllllllllIIIlllllllIIIIllIIIll);
                this.fontRendererObj.drawStringWithShadow(lllllllllllIIIlllllllIIIIllIIIlI, (float)lllllllllllIIIlllllllIIIIllIlIIl, (float)lllllllllllIIIlllllllIIIIllIlIII, -1);
                if (lllllllllllIIIlllllllIIIIllIIIll == 0) {
                    lllllllllllIIIlllllllIIIIllIlIII += 2;
                }
                lllllllllllIIIlllllllIIIIllIlIII += 10;
            }
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
        }
    }
    
    public void sendChatMessage(final String lllllllllllIIIlllllllIIIIIIllIll, final boolean lllllllllllIIIlllllllIIIIIIlIlll) {
        if (lllllllllllIIIlllllllIIIIIIlIlll) {
            this.mc.ingameGUI.getChatGUI().addToSentMessages(lllllllllllIIIlllllllIIIIIIllIll);
        }
        this.mc.player.sendChatMessage(lllllllllllIIIlllllllIIIIIIllIll);
    }
    
    public static boolean isKeyComboCtrlX(final int lllllllllllIIIllllllIllllIIlIIIl) {
        return lllllllllllIIIllllllIllllIIlIIIl == 45 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
    }
    
    protected void keyTyped(final char lllllllllllIIIlllllllIIIlIllllIl, final int lllllllllllIIIlllllllIIIlIlllIlI) throws IOException {
        if (lllllllllllIIIlllllllIIIlIlllIlI == 1) {
            this.mc.displayGuiScreen(null);
            if (this.mc.currentScreen == null) {
                this.mc.setIngameFocus();
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    protected void handleComponentHover(final ITextComponent lllllllllllIIIlllllllIIIIlIIIIII, final int lllllllllllIIIlllllllIIIIIllllll, final int lllllllllllIIIlllllllIIIIIlllllI) {
        if (lllllllllllIIIlllllllIIIIlIIIIII != null && lllllllllllIIIlllllllIIIIlIIIIII.getStyle().getHoverEvent() != null) {
            final HoverEvent lllllllllllIIIlllllllIIIIlIIlIII = lllllllllllIIIlllllllIIIIlIIIIII.getStyle().getHoverEvent();
            if (lllllllllllIIIlllllllIIIIlIIlIII.getAction() == HoverEvent.Action.SHOW_ITEM) {
                ItemStack lllllllllllIIIlllllllIIIIlIIIlll = ItemStack.field_190927_a;
                try {
                    final NBTBase lllllllllllIIIlllllllIIIIlIIIllI = JsonToNBT.getTagFromJson(lllllllllllIIIlllllllIIIIlIIlIII.getValue().getUnformattedText());
                    if (lllllllllllIIIlllllllIIIIlIIIllI instanceof NBTTagCompound) {
                        lllllllllllIIIlllllllIIIIlIIIlll = new ItemStack((NBTTagCompound)lllllllllllIIIlllllllIIIIlIIIllI);
                    }
                }
                catch (NBTException ex) {}
                if (lllllllllllIIIlllllllIIIIlIIIlll.isEmpty()) {
                    this.drawCreativeTabHoveringText(TextFormatting.RED + "Invalid Item!", lllllllllllIIIlllllllIIIIIllllll, lllllllllllIIIlllllllIIIIIlllllI);
                }
                else {
                    this.renderToolTip(lllllllllllIIIlllllllIIIIlIIIlll, lllllllllllIIIlllllllIIIIIllllll, lllllllllllIIIlllllllIIIIIlllllI);
                }
            }
            else if (lllllllllllIIIlllllllIIIIlIIlIII.getAction() == HoverEvent.Action.SHOW_ENTITY) {
                if (this.mc.gameSettings.advancedItemTooltips) {
                    try {
                        final NBTTagCompound lllllllllllIIIlllllllIIIIlIIIlIl = JsonToNBT.getTagFromJson(lllllllllllIIIlllllllIIIIlIIlIII.getValue().getUnformattedText());
                        final List<String> lllllllllllIIIlllllllIIIIlIIIlII = (List<String>)Lists.newArrayList();
                        lllllllllllIIIlllllllIIIIlIIIlII.add(lllllllllllIIIlllllllIIIIlIIIlIl.getString("name"));
                        if (lllllllllllIIIlllllllIIIIlIIIlIl.hasKey("type", 8)) {
                            final String lllllllllllIIIlllllllIIIIlIIIIll = lllllllllllIIIlllllllIIIIlIIIlIl.getString("type");
                            lllllllllllIIIlllllllIIIIlIIIlII.add("Type: " + lllllllllllIIIlllllllIIIIlIIIIll);
                        }
                        lllllllllllIIIlllllllIIIIlIIIlII.add(lllllllllllIIIlllllllIIIIlIIIlIl.getString("id"));
                        this.drawHoveringText(lllllllllllIIIlllllllIIIIlIIIlII, lllllllllllIIIlllllllIIIIIllllll, lllllllllllIIIlllllllIIIIIlllllI);
                    }
                    catch (NBTException lllllllllllIIIlllllllIIIIlIIIIlI) {
                        this.drawCreativeTabHoveringText(TextFormatting.RED + "Invalid Entity!", lllllllllllIIIlllllllIIIIIllllll, lllllllllllIIIlllllllIIIIIlllllI);
                    }
                }
            }
            else if (lllllllllllIIIlllllllIIIIlIIlIII.getAction() == HoverEvent.Action.SHOW_TEXT) {
                this.drawHoveringText(Minecraft.fontRendererObj.listFormattedStringToWidth(lllllllllllIIIlllllllIIIIlIIlIII.getValue().getFormattedText(), Math.max(this.width / 2, 200)), lllllllllllIIIlllllllIIIIIllllll, lllllllllllIIIlllllllIIIIIlllllI);
            }
            GlStateManager.disableLighting();
        }
    }
    
    public static String getClipboardString() {
        try {
            final Transferable lllllllllllIIIlllllllIIIlIllIIlI = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (lllllllllllIIIlllllllIIIlIllIIlI != null && lllllllllllIIIlllllllIIIlIllIIlI.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String)lllllllllllIIIlllllllIIIlIllIIlI.getTransferData(DataFlavor.stringFlavor);
            }
        }
        catch (Exception ex) {}
        return "";
    }
    
    public void drawCreativeTabHoveringText(final String lllllllllllIIIlllllllIIIlIIIlIIl, final int lllllllllllIIIlllllllIIIlIIIlIII, final int lllllllllllIIIlllllllIIIlIIIlIll) {
        this.drawHoveringText(Arrays.asList(lllllllllllIIIlllllllIIIlIIIlIIl), lllllllllllIIIlllllllIIIlIIIlIII, lllllllllllIIIlllllllIIIlIIIlIll);
    }
    
    public void setWorldAndResolution(final Minecraft lllllllllllIIIllllllIllllllIllII, final int lllllllllllIIIllllllIllllllIlIll, final int lllllllllllIIIllllllIllllllIIllI) {
        this.mc = lllllllllllIIIllllllIllllllIllII;
        this.itemRender = lllllllllllIIIllllllIllllllIllII.getRenderItem();
        this.fontRendererObj = Minecraft.fontRendererObj;
        this.width = lllllllllllIIIllllllIllllllIlIll;
        this.height = lllllllllllIIIllllllIllllllIIllI;
        this.buttonList.clear();
        this.initGui();
    }
}
