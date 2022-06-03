// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import net.minecraft.util.text.TextComponentString;
import ru.rockstar.api.event.event.EventReceiveMessage;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.HUD;
import ru.rockstar.client.features.impl.visuals.NoRender;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.Minecraft;

public class GuiNewChat extends Gui
{
    private final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean isScrolled;
    private /* synthetic */ double deltaY;
    private /* synthetic */ float offset;
    private /* synthetic */ int scrollPos;
    private final /* synthetic */ List<ChatLine> drawnChatLines;
    private final /* synthetic */ List<String> sentMessages;
    private final /* synthetic */ List<ChatLine> chatLines;
    
    public int getLineCount() {
        return this.getChatHeight() / 9;
    }
    
    public void scroll(final int lllllllllllIIIIIllIlIIIllIIIllIl) {
        this.scrollPos += lllllllllllIIIIIllIlIIIllIIIllIl;
        final int lllllllllllIIIIIllIlIIIllIIIllII = this.drawnChatLines.size();
        if (this.scrollPos > lllllllllllIIIIIllIlIIIllIIIllII - this.getLineCount()) {
            this.scrollPos = lllllllllllIIIIIllIlIIIllIIIllII - this.getLineCount();
        }
        if (this.scrollPos <= 0) {
            this.scrollPos = 0;
            this.isScrolled = false;
        }
    }
    
    public void addToSentMessages(final String lllllllllllIIIIIllIlIIIllIIlIlIl) {
        if (this.sentMessages.isEmpty() || !this.sentMessages.get(this.sentMessages.size() - 1).equals(lllllllllllIIIIIllIlIIIllIIlIlIl)) {
            this.sentMessages.add(lllllllllllIIIIIllIlIIIllIIlIlIl);
        }
    }
    
    public void deleteChatLine(final int lllllllllllIIIIIllIlIIIlIlIlIlll) {
        Iterator<ChatLine> lllllllllllIIIIIllIlIIIlIlIlIllI = this.drawnChatLines.iterator();
        while (lllllllllllIIIIIllIlIIIlIlIlIllI.hasNext()) {
            final ChatLine lllllllllllIIIIIllIlIIIlIlIlIlIl = lllllllllllIIIIIllIlIIIlIlIlIllI.next();
            if (lllllllllllIIIIIllIlIIIlIlIlIlIl.getChatLineID() == lllllllllllIIIIIllIlIIIlIlIlIlll) {
                lllllllllllIIIIIllIlIIIlIlIlIllI.remove();
            }
        }
        lllllllllllIIIIIllIlIIIlIlIlIllI = this.chatLines.iterator();
        while (lllllllllllIIIIIllIlIIIlIlIlIllI.hasNext()) {
            final ChatLine lllllllllllIIIIIllIlIIIlIlIlIlII = lllllllllllIIIIIllIlIIIlIlIlIllI.next();
            if (lllllllllllIIIIIllIlIIIlIlIlIlII.getChatLineID() == lllllllllllIIIIIllIlIIIlIlIlIlll) {
                lllllllllllIIIIIllIlIIIlIlIlIllI.remove();
                break;
            }
        }
    }
    
    public static int calculateChatboxWidth(final float lllllllllllIIIIIllIlIIIlIlIIIIII) {
        final int lllllllllllIIIIIllIlIIIlIlIIIIlI = 320;
        final int lllllllllllIIIIIllIlIIIlIlIIIIIl = 40;
        return MathHelper.floor(lllllllllllIIIIIllIlIIIlIlIIIIII * 280.0f + 40.0f);
    }
    
    public void resetScroll() {
        this.scrollPos = 0;
        this.isScrolled = false;
    }
    
    public float getChatScale() {
        return this.mc.gameSettings.chatScale;
    }
    
    public void printChatMessageWithOptionalDeletion(final ITextComponent lllllllllllIIIIIllIlIIIlllIIIlIl, final int lllllllllllIIIIIllIlIIIlllIIIlII) {
        this.setChatLine(lllllllllllIIIIIllIlIIIlllIIIlIl, lllllllllllIIIIIllIlIIIlllIIIlII, this.mc.ingameGUI.getUpdateCounter(), false);
        GuiNewChat.LOGGER.info("[CHAT] {}", (Object)lllllllllllIIIIIllIlIIIlllIIIlIl.getUnformattedText().replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n"));
    }
    
    public static int calculateChatboxHeight(final float lllllllllllIIIIIllIlIIIlIIllIlll) {
        final int lllllllllllIIIIIllIlIIIlIIlllIIl = 180;
        final int lllllllllllIIIIIllIlIIIlIIlllIII = 20;
        return MathHelper.floor(lllllllllllIIIIIllIlIIIlIIllIlll * 160.0f + 20.0f);
    }
    
    public int getChatHeight() {
        return calculateChatboxHeight(this.getChatOpen() ? this.mc.gameSettings.chatHeightFocused : this.mc.gameSettings.chatHeightUnfocused);
    }
    
    public void drawChat(final int lllllllllllIIIIIllIlIIlIIIIIIlII) {
        this.offset += (float)this.deltaY;
        this.deltaY /= Math.pow(0.99, -Minecraft.frameTime);
        if ((int)this.offset != 0 && (int)this.offset % 8 == 0) {
            this.offset = 8.0f;
        }
        if (this.mc.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN) {
            final int lllllllllllIIIIIllIlIIlIIIIIIIll = this.getLineCount();
            final int lllllllllllIIIIIllIlIIlIIIIIIIlI = this.drawnChatLines.size();
            final float lllllllllllIIIIIllIlIIlIIIIIIIIl = this.mc.gameSettings.chatOpacity * 0.9f + 0.1f;
            if (lllllllllllIIIIIllIlIIlIIIIIIIlI > 0) {
                final boolean lllllllllllIIIIIllIlIIlIIIIIIIII = this.getChatOpen();
                final float lllllllllllIIIIIllIlIIIlllllllll = this.getChatScale();
                final int lllllllllllIIIIIllIlIIIllllllllI = MathHelper.ceil(this.getChatWidth() / lllllllllllIIIIIllIlIIIlllllllll);
                GlStateManager.pushMatrix();
                GlStateManager.translate(2.0f, 8.0f, 0.0f);
                GlStateManager.scale(lllllllllllIIIIIllIlIIIlllllllll, lllllllllllIIIIIllIlIIIlllllllll, 1.0f);
                int lllllllllllIIIIIllIlIIIlllllllIl = 0;
                for (int lllllllllllIIIIIllIlIIIlllllllII = 0; lllllllllllIIIIIllIlIIIlllllllII + this.scrollPos < this.drawnChatLines.size() && lllllllllllIIIIIllIlIIIlllllllII < lllllllllllIIIIIllIlIIlIIIIIIIll; ++lllllllllllIIIIIllIlIIIlllllllII) {
                    final ChatLine lllllllllllIIIIIllIlIIIllllllIll = this.drawnChatLines.get(lllllllllllIIIIIllIlIIIlllllllII + this.scrollPos);
                    if (lllllllllllIIIIIllIlIIIllllllIll != null) {
                        final int lllllllllllIIIIIllIlIIIllllllIlI = lllllllllllIIIIIllIlIIlIIIIIIlII - lllllllllllIIIIIllIlIIIllllllIll.getUpdatedCounter();
                        if (lllllllllllIIIIIllIlIIIllllllIlI < 200 || lllllllllllIIIIIllIlIIlIIIIIIIII) {
                            double lllllllllllIIIIIllIlIIIllllllIIl = lllllllllllIIIIIllIlIIIllllllIlI / 200.0;
                            lllllllllllIIIIIllIlIIIllllllIIl = 1.0 - lllllllllllIIIIIllIlIIIllllllIIl;
                            lllllllllllIIIIIllIlIIIllllllIIl *= 10.0;
                            lllllllllllIIIIIllIlIIIllllllIIl = MathHelper.clamp(lllllllllllIIIIIllIlIIIllllllIIl, 0.0, 1.0);
                            lllllllllllIIIIIllIlIIIllllllIIl *= lllllllllllIIIIIllIlIIIllllllIIl;
                            int lllllllllllIIIIIllIlIIIllllllIII = (int)(255.0 * lllllllllllIIIIIllIlIIIllllllIIl);
                            if (lllllllllllIIIIIllIlIIlIIIIIIIII) {
                                lllllllllllIIIIIllIlIIIllllllIII = 255;
                            }
                            lllllllllllIIIIIllIlIIIllllllIII *= (int)lllllllllllIIIIIllIlIIlIIIIIIIIl;
                            ++lllllllllllIIIIIllIlIIIlllllllIl;
                            if (lllllllllllIIIIIllIlIIIllllllIII > 3) {
                                final int lllllllllllIIIIIllIlIIIlllllIlll = 0;
                                final int lllllllllllIIIIIllIlIIIlllllIllI = -lllllllllllIIIIIllIlIIIlllllllII * 9;
                                if (!NoRender.chatRect.getBoolValue()) {
                                    DrawHelper.drawRectWithGlow(-2.0, lllllllllllIIIIIllIlIIIlllllIllI - 1 - this.offset - HUD.globalOffset / 5.0f, lllllllllllIIIIIllIlIIIllllllllI + 4, lllllllllllIIIIIllIlIIIlllllIllI + 6 - this.offset - HUD.globalOffset / 5.0f, 3.0, 20.0, new Color(lllllllllllIIIIIllIlIIIllllllIII / 2 << 24));
                                }
                                final String lllllllllllIIIIIllIlIIIlllllIlIl = lllllllllllIIIIIllIlIIIllllllIll.getChatComponent().getFormattedText();
                                GlStateManager.enableBlend();
                                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIIIIIllIlIIIlllllIlIl, 0.0f, lllllllllllIIIIIllIlIIIlllllIllI - this.offset - HUD.globalOffset / 5.0f, 16777215 + (lllllllllllIIIIIllIlIIIllllllIII << 24));
                                GlStateManager.disableAlpha();
                                GlStateManager.disableBlend();
                            }
                        }
                    }
                }
                if (lllllllllllIIIIIllIlIIlIIIIIIIII) {
                    final int lllllllllllIIIIIllIlIIIlllllIlII = Minecraft.fontRendererObj.FONT_HEIGHT;
                    GlStateManager.translate(-3.0f, 0.0f, 0.0f);
                    final int lllllllllllIIIIIllIlIIIlllllIIll = lllllllllllIIIIIllIlIIlIIIIIIIlI * lllllllllllIIIIIllIlIIIlllllIlII + lllllllllllIIIIIllIlIIlIIIIIIIlI;
                    final int lllllllllllIIIIIllIlIIIlllllIIlI = lllllllllllIIIIIllIlIIIlllllllIl * lllllllllllIIIIIllIlIIIlllllIlII + lllllllllllIIIIIllIlIIIlllllllIl;
                    final int lllllllllllIIIIIllIlIIIlllllIIIl = this.scrollPos * lllllllllllIIIIIllIlIIIlllllIIlI / lllllllllllIIIIIllIlIIlIIIIIIIlI;
                    final int lllllllllllIIIIIllIlIIIlllllIIII = lllllllllllIIIIIllIlIIIlllllIIlI * lllllllllllIIIIIllIlIIIlllllIIlI / lllllllllllIIIIIllIlIIIlllllIIll;
                    if (lllllllllllIIIIIllIlIIIlllllIIll != lllllllllllIIIIIllIlIIIlllllIIlI) {
                        final int lllllllllllIIIIIllIlIIIllllIllll = (lllllllllllIIIIIllIlIIIlllllIIIl > 0) ? 170 : 96;
                        final int lllllllllllIIIIIllIlIIIllllIlllI = this.isScrolled ? 13382451 : 3355562;
                        Gui.drawRect(0.0, -lllllllllllIIIIIllIlIIIlllllIIIl, 2.0, -lllllllllllIIIIIllIlIIIlllllIIIl - lllllllllllIIIIIllIlIIIlllllIIII, lllllllllllIIIIIllIlIIIllllIlllI + (lllllllllllIIIIIllIlIIIllllIllll << 24));
                        Gui.drawRect(2.0, -lllllllllllIIIIIllIlIIIlllllIIIl, 1.0, -lllllllllllIIIIIllIlIIIlllllIIIl - lllllllllllIIIIIllIlIIIlllllIIII, 13421772 + (lllllllllllIIIIIllIlIIIllllIllll << 24));
                    }
                }
                GlStateManager.popMatrix();
            }
        }
    }
    
    public void refreshChat() {
        this.drawnChatLines.clear();
        this.resetScroll();
        for (int lllllllllllIIIIIllIlIIIllIlIIIlI = this.chatLines.size() - 1; lllllllllllIIIIIllIlIIIllIlIIIlI >= 0; --lllllllllllIIIIIllIlIIIllIlIIIlI) {
            final ChatLine lllllllllllIIIIIllIlIIIllIlIIIIl = this.chatLines.get(lllllllllllIIIIIllIlIIIllIlIIIlI);
            this.setChatLine(lllllllllllIIIIIllIlIIIllIlIIIIl.getChatComponent(), lllllllllllIIIIIllIlIIIllIlIIIIl.getChatLineID(), lllllllllllIIIIIllIlIIIllIlIIIIl.getUpdatedCounter(), true);
        }
    }
    
    public void printChatMessage(final ITextComponent lllllllllllIIIIIllIlIIIlllIlIIIl) {
        this.deltaY = 1.0;
        this.offset = 0.0f;
        this.printChatMessageWithOptionalDeletion(lllllllllllIIIIIllIlIIIlllIlIIIl, 0);
        final EventReceiveMessage lllllllllllIIIIIllIlIIIlllIlIIII = new EventReceiveMessage(lllllllllllIIIIIllIlIIIlllIlIIIl.getUnformattedText());
        lllllllllllIIIIIllIlIIIlllIlIIII.call();
    }
    
    public boolean getChatOpen() {
        return this.mc.currentScreen instanceof GuiChat;
    }
    
    public void clearChatMessages(final boolean lllllllllllIIIIIllIlIIIlllIllIII) {
        this.drawnChatLines.clear();
        this.chatLines.clear();
        if (lllllllllllIIIIIllIlIIIlllIllIII) {
            this.sentMessages.clear();
        }
    }
    
    public int getChatWidth() {
        return calculateChatboxWidth(this.mc.gameSettings.chatWidth);
    }
    
    public List<String> getSentMessages() {
        return this.sentMessages;
    }
    
    private void setChatLine(final ITextComponent lllllllllllIIIIIllIlIIIllIlllIII, final int lllllllllllIIIIIllIlIIIllIllIlll, final int lllllllllllIIIIIllIlIIIllIlIllIl, final boolean lllllllllllIIIIIllIlIIIllIllIlIl) {
        if (lllllllllllIIIIIllIlIIIllIllIlll != 0) {
            this.deleteChatLine(lllllllllllIIIIIllIlIIIllIllIlll);
        }
        final int lllllllllllIIIIIllIlIIIllIllIlII = MathHelper.floor(this.getChatWidth() / this.getChatScale());
        final List<ITextComponent> lllllllllllIIIIIllIlIIIllIllIIll = GuiUtilRenderComponents.splitText(lllllllllllIIIIIllIlIIIllIlllIII, lllllllllllIIIIIllIlIIIllIllIlII, Minecraft.fontRendererObj, false, false);
        final boolean lllllllllllIIIIIllIlIIIllIllIIlI = this.getChatOpen();
        for (final ITextComponent lllllllllllIIIIIllIlIIIllIllIIIl : lllllllllllIIIIIllIlIIIllIllIIll) {
            if (lllllllllllIIIIIllIlIIIllIllIIlI && this.scrollPos > 0) {
                this.isScrolled = true;
                this.scroll(1);
            }
            this.drawnChatLines.add(0, new ChatLine(lllllllllllIIIIIllIlIIIllIlIllIl, lllllllllllIIIIIllIlIIIllIllIIIl, lllllllllllIIIIIllIlIIIllIllIlll));
        }
        while (this.drawnChatLines.size() > 100) {
            this.drawnChatLines.remove(this.drawnChatLines.size() - 1);
        }
        if (!lllllllllllIIIIIllIlIIIllIllIlIl) {
            this.chatLines.add(0, new ChatLine(lllllllllllIIIIIllIlIIIllIlIllIl, lllllllllllIIIIIllIlIIIllIlllIII, lllllllllllIIIIIllIlIIIllIllIlll));
            while (this.chatLines.size() > 100) {
                this.chatLines.remove(this.chatLines.size() - 1);
            }
        }
    }
    
    @Nullable
    public ITextComponent getChatComponent(final int lllllllllllIIIIIllIlIIIlIllllIIl, final int lllllllllllIIIIIllIlIIIlIllIlIll) {
        if (!this.getChatOpen()) {
            return null;
        }
        final ScaledResolution lllllllllllIIIIIllIlIIIlIlllIlll = new ScaledResolution(this.mc);
        final int lllllllllllIIIIIllIlIIIlIlllIllI = ScaledResolution.getScaleFactor();
        final float lllllllllllIIIIIllIlIIIlIlllIlIl = this.getChatScale();
        int lllllllllllIIIIIllIlIIIlIlllIlII = lllllllllllIIIIIllIlIIIlIllllIIl / lllllllllllIIIIIllIlIIIlIlllIllI - 2;
        int lllllllllllIIIIIllIlIIIlIlllIIll = lllllllllllIIIIIllIlIIIlIllIlIll / lllllllllllIIIIIllIlIIIlIlllIllI - 40;
        lllllllllllIIIIIllIlIIIlIlllIlII = MathHelper.floor(lllllllllllIIIIIllIlIIIlIlllIlII / lllllllllllIIIIIllIlIIIlIlllIlIl);
        lllllllllllIIIIIllIlIIIlIlllIIll = MathHelper.floor(lllllllllllIIIIIllIlIIIlIlllIIll / lllllllllllIIIIIllIlIIIlIlllIlIl);
        if (lllllllllllIIIIIllIlIIIlIlllIlII < 0 || lllllllllllIIIIIllIlIIIlIlllIIll < 0) {
            return null;
        }
        final int lllllllllllIIIIIllIlIIIlIlllIIlI = Math.min(this.getLineCount(), this.drawnChatLines.size());
        if (lllllllllllIIIIIllIlIIIlIlllIlII <= MathHelper.floor(this.getChatWidth() / this.getChatScale()) && lllllllllllIIIIIllIlIIIlIlllIIll < Minecraft.fontRendererObj.FONT_HEIGHT * lllllllllllIIIIIllIlIIIlIlllIIlI + lllllllllllIIIIIllIlIIIlIlllIIlI) {
            final int lllllllllllIIIIIllIlIIIlIlllIIIl = lllllllllllIIIIIllIlIIIlIlllIIll / Minecraft.fontRendererObj.FONT_HEIGHT + this.scrollPos;
            if (lllllllllllIIIIIllIlIIIlIlllIIIl >= 0 && lllllllllllIIIIIllIlIIIlIlllIIIl < this.drawnChatLines.size()) {
                final ChatLine lllllllllllIIIIIllIlIIIlIlllIIII = this.drawnChatLines.get(lllllllllllIIIIIllIlIIIlIlllIIIl);
                int lllllllllllIIIIIllIlIIIlIllIllll = 0;
                for (final ITextComponent lllllllllllIIIIIllIlIIIlIllIlllI : lllllllllllIIIIIllIlIIIlIlllIIII.getChatComponent()) {
                    if (lllllllllllIIIIIllIlIIIlIllIlllI instanceof TextComponentString) {
                        lllllllllllIIIIIllIlIIIlIllIllll += Minecraft.fontRendererObj.getStringWidth(GuiUtilRenderComponents.removeTextColorsIfConfigured(((TextComponentString)lllllllllllIIIIIllIlIIIlIllIlllI).getText(), false));
                        if (lllllllllllIIIIIllIlIIIlIllIllll > lllllllllllIIIIIllIlIIIlIlllIlII) {
                            return lllllllllllIIIIIllIlIIIlIllIlllI;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    public GuiNewChat(final Minecraft lllllllllllIIIIIllIlIIlIIIIllIII) {
        this.sentMessages = (List<String>)Lists.newArrayList();
        this.chatLines = (List<ChatLine>)Lists.newArrayList();
        this.drawnChatLines = (List<ChatLine>)Lists.newArrayList();
        this.mc = lllllllllllIIIIIllIlIIlIIIIllIII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
