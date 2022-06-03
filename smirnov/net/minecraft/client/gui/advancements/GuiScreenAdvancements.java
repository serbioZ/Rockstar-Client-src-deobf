// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.advancements;

import net.minecraft.advancements.AdvancementProgress;
import org.lwjgl.input.Mouse;
import com.google.common.collect.Maps;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import java.io.IOException;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenAdvancements extends GuiScreen implements ClientAdvancementManager.IListener
{
    private /* synthetic */ int field_191941_t;
    private /* synthetic */ int field_191942_u;
    private final /* synthetic */ ClientAdvancementManager field_191946_h;
    private /* synthetic */ boolean field_191944_v;
    private /* synthetic */ GuiAdvancementTab field_191940_s;
    private static final /* synthetic */ ResourceLocation field_191943_f;
    private static final /* synthetic */ ResourceLocation field_191945_g;
    private final /* synthetic */ Map<Advancement, GuiAdvancementTab> field_191947_i;
    
    @Override
    public void func_191930_a() {
        this.field_191947_i.clear();
        this.field_191940_s = null;
    }
    
    @Nullable
    public GuiAdvancement func_191938_e(final Advancement llllllllllllIlIIIllIllllIIlIlIll) {
        final GuiAdvancementTab llllllllllllIlIIIllIllllIIlIllIl = this.func_191935_f(llllllllllllIlIIIllIllllIIlIlIll);
        return (llllllllllllIlIIIllIllllIIlIllIl == null) ? null : llllllllllllIlIIIllIllllIIlIllIl.func_191794_b(llllllllllllIlIIIllIllllIIlIlIll);
    }
    
    @Override
    public void func_193982_e(@Nullable final Advancement llllllllllllIlIIIllIllllIIlllIII) {
        this.field_191940_s = this.field_191947_i.get(llllllllllllIlIIIllIllllIIlllIII);
    }
    
    @Nullable
    private GuiAdvancementTab func_191935_f(Advancement llllllllllllIlIIIllIllllIIlIIlII) {
        while (llllllllllllIlIIIllIllllIIlIIlII.func_192070_b() != null) {
            llllllllllllIlIIIllIllllIIlIIlII = llllllllllllIlIIIllIllllIIlIIlII.func_192070_b();
        }
        return this.field_191947_i.get(llllllllllllIlIIIllIllllIIlIIlII);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIlIIIllIlllllIlIlIIl, final int llllllllllllIlIIIllIlllllIlIIlIl) throws IOException {
        if (llllllllllllIlIIIllIlllllIlIIlIl == this.mc.gameSettings.field_194146_ao.getKeyCode()) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        else {
            super.keyTyped(llllllllllllIlIIIllIlllllIlIlIIl, llllllllllllIlIIIllIlllllIlIIlIl);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIlIIIllIlllllIllIlII, final int llllllllllllIlIIIllIlllllIlllIlI, final int llllllllllllIlIIIllIlllllIlllIIl) throws IOException {
        if (llllllllllllIlIIIllIlllllIlllIIl == 0) {
            final int llllllllllllIlIIIllIlllllIlllIII = (this.width - 252) / 2;
            final int llllllllllllIlIIIllIlllllIllIlll = (this.height - 140) / 2;
            for (final GuiAdvancementTab llllllllllllIlIIIllIlllllIllIllI : this.field_191947_i.values()) {
                if (llllllllllllIlIIIllIlllllIllIllI.func_191793_c(llllllllllllIlIIIllIlllllIlllIII, llllllllllllIlIIIllIlllllIllIlll, llllllllllllIlIIIllIlllllIllIlII, llllllllllllIlIIIllIlllllIlllIlI)) {
                    this.field_191946_h.func_194230_a(llllllllllllIlIIIllIlllllIllIllI.func_193935_c(), true);
                    break;
                }
            }
        }
        super.mouseClicked(llllllllllllIlIIIllIlllllIllIlII, llllllllllllIlIIIllIlllllIlllIlI, llllllllllllIlIIIllIlllllIlllIIl);
    }
    
    @Override
    public void onGuiClosed() {
        this.field_191946_h.func_192798_a(null);
        final NetHandlerPlayClient llllllllllllIlIIIllIllllllIIIlll = this.mc.getConnection();
        if (llllllllllllIlIIIllIllllllIIIlll != null) {
            llllllllllllIlIIIllIllllllIIIlll.sendPacket(CPacketSeenAdvancements.func_194164_a());
        }
    }
    
    public void func_191934_b(final int llllllllllllIlIIIllIllllIllllIlI, final int llllllllllllIlIIIllIllllIllllIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        RenderHelper.disableStandardItemLighting();
        this.mc.getTextureManager().bindTexture(GuiScreenAdvancements.field_191943_f);
        this.drawTexturedModalRect(llllllllllllIlIIIllIllllIllllIlI, llllllllllllIlIIIllIllllIllllIIl, 0, 0, 252, 140);
        if (this.field_191947_i.size() > 1) {
            this.mc.getTextureManager().bindTexture(GuiScreenAdvancements.field_191945_g);
            for (final GuiAdvancementTab llllllllllllIlIIIllIllllIllllIII : this.field_191947_i.values()) {
                llllllllllllIlIIIllIllllIllllIII.func_191798_a(llllllllllllIlIIIllIllllIllllIlI, llllllllllllIlIIIllIllllIllllIIl, llllllllllllIlIIIllIllllIllllIII == this.field_191940_s);
            }
            GlStateManager.enableRescaleNormal();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.enableGUIStandardItemLighting();
            for (final GuiAdvancementTab llllllllllllIlIIIllIllllIlllIlll : this.field_191947_i.values()) {
                llllllllllllIlIIIllIllllIlllIlll.func_191796_a(llllllllllllIlIIIllIllllIllllIlI, llllllllllllIlIIIllIllllIllllIIl, this.itemRender);
            }
            GlStateManager.disableBlend();
        }
        this.fontRendererObj.drawString(I18n.format("gui.advancements", new Object[0]), (float)(llllllllllllIlIIIllIllllIllllIlI + 8), (float)(llllllllllllIlIIIllIllllIllllIIl + 6), 4210752);
    }
    
    @Override
    public void initGui() {
        this.field_191947_i.clear();
        this.field_191940_s = null;
        this.field_191946_h.func_192798_a(this);
        if (this.field_191940_s == null && !this.field_191947_i.isEmpty()) {
            this.field_191946_h.func_194230_a(this.field_191947_i.values().iterator().next().func_193935_c(), true);
        }
        else {
            this.field_191946_h.func_194230_a((this.field_191940_s == null) ? null : this.field_191940_s.func_193935_c(), true);
        }
    }
    
    private void func_191937_d(final int llllllllllllIlIIIllIllllIllIIIll, final int llllllllllllIlIIIllIllllIllIlIII, final int llllllllllllIlIIIllIllllIllIIIIl, final int llllllllllllIlIIIllIllllIllIIllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.field_191940_s != null) {
            GlStateManager.pushMatrix();
            GlStateManager.enableDepth();
            GlStateManager.translate((float)(llllllllllllIlIIIllIllllIllIIIIl + 9), (float)(llllllllllllIlIIIllIllllIllIIllI + 18), 400.0f);
            this.field_191940_s.func_192991_a(llllllllllllIlIIIllIllllIllIIIll - llllllllllllIlIIIllIllllIllIIIIl - 9, llllllllllllIlIIIllIllllIllIlIII - llllllllllllIlIIIllIllllIllIIllI - 18, llllllllllllIlIIIllIllllIllIIIIl, llllllllllllIlIIIllIllllIllIIllI);
            GlStateManager.disableDepth();
            GlStateManager.popMatrix();
        }
        if (this.field_191947_i.size() > 1) {
            for (final GuiAdvancementTab llllllllllllIlIIIllIllllIllIIlIl : this.field_191947_i.values()) {
                if (llllllllllllIlIIIllIllllIllIIlIl.func_191793_c(llllllllllllIlIIIllIllllIllIIIIl, llllllllllllIlIIIllIllllIllIIllI, llllllllllllIlIIIllIllllIllIIIll, llllllllllllIlIIIllIllllIllIlIII)) {
                    this.drawCreativeTabHoveringText(llllllllllllIlIIIllIllllIllIIlIl.func_191795_d(), llllllllllllIlIIIllIllllIllIIIll, llllllllllllIlIIIllIllllIllIlIII);
                }
            }
        }
    }
    
    @Override
    public void func_191929_d(final Advancement llllllllllllIlIIIllIllllIlIIlIII) {
    }
    
    private void func_191936_c(final int llllllllllllIlIIIllIlllllIIIllIl, final int llllllllllllIlIIIllIlllllIIIllII, final int llllllllllllIlIIIllIlllllIIIlIll, final int llllllllllllIlIIIllIlllllIIIlIlI) {
        final GuiAdvancementTab llllllllllllIlIIIllIlllllIIIlIIl = this.field_191940_s;
        if (llllllllllllIlIIIllIlllllIIIlIIl == null) {
            Gui.drawRect(llllllllllllIlIIIllIlllllIIIlIll + 9, llllllllllllIlIIIllIlllllIIIlIlI + 18, llllllllllllIlIIIllIlllllIIIlIll + 9 + 234, llllllllllllIlIIIllIlllllIIIlIlI + 18 + 113, -16777216);
            final String llllllllllllIlIIIllIlllllIIIlIII = I18n.format("advancements.empty", new Object[0]);
            final int llllllllllllIlIIIllIlllllIIIIlll = this.fontRendererObj.getStringWidth(llllllllllllIlIIIllIlllllIIIlIII);
            this.fontRendererObj.drawString(llllllllllllIlIIIllIlllllIIIlIII, (float)(llllllllllllIlIIIllIlllllIIIlIll + 9 + 117 - llllllllllllIlIIIllIlllllIIIIlll / 2), (float)(llllllllllllIlIIIllIlllllIIIlIlI + 18 + 56 - this.fontRendererObj.FONT_HEIGHT / 2), -1);
            this.fontRendererObj.drawString(":(", (float)(llllllllllllIlIIIllIlllllIIIlIll + 9 + 117 - this.fontRendererObj.getStringWidth(":(") / 2), (float)(llllllllllllIlIIIllIlllllIIIlIlI + 18 + 113 - this.fontRendererObj.FONT_HEIGHT), -1);
        }
        else {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)(llllllllllllIlIIIllIlllllIIIlIll + 9), (float)(llllllllllllIlIIIllIlllllIIIlIlI + 18), -400.0f);
            GlStateManager.enableDepth();
            llllllllllllIlIIIllIlllllIIIlIIl.func_191799_a();
            GlStateManager.popMatrix();
            GlStateManager.depthFunc(515);
            GlStateManager.disableDepth();
        }
    }
    
    public GuiScreenAdvancements(final ClientAdvancementManager llllllllllllIlIIIllIllllllIlIIII) {
        this.field_191947_i = (Map<Advancement, GuiAdvancementTab>)Maps.newLinkedHashMap();
        this.field_191946_h = llllllllllllIlIIIllIllllllIlIIII;
    }
    
    static {
        field_191943_f = new ResourceLocation("textures/gui/advancements/window.png");
        field_191945_g = new ResourceLocation("textures/gui/advancements/tabs.png");
    }
    
    @Override
    public void func_191931_a(final Advancement llllllllllllIlIIIllIllllIlIllIIl) {
        final GuiAdvancementTab llllllllllllIlIIIllIllllIlIllIII = GuiAdvancementTab.func_193936_a(this.mc, this, this.field_191947_i.size(), llllllllllllIlIIIllIllllIlIllIIl);
        if (llllllllllllIlIIIllIllllIlIllIII != null) {
            this.field_191947_i.put(llllllllllllIlIIIllIllllIlIllIIl, llllllllllllIlIIIllIllllIlIllIII);
        }
    }
    
    @Override
    public void func_191928_b(final Advancement llllllllllllIlIIIllIllllIlIlIIll) {
    }
    
    @Override
    public void drawScreen(final int llllllllllllIlIIIllIlllllIIllIII, final int llllllllllllIlIIIllIlllllIIlllIl, final float llllllllllllIlIIIllIlllllIIlllII) {
        final int llllllllllllIlIIIllIlllllIIllIll = (this.width - 252) / 2;
        final int llllllllllllIlIIIllIlllllIIllIlI = (this.height - 140) / 2;
        if (Mouse.isButtonDown(0)) {
            if (!this.field_191944_v) {
                this.field_191944_v = true;
            }
            else if (this.field_191940_s != null) {
                this.field_191940_s.func_191797_b(llllllllllllIlIIIllIlllllIIllIII - this.field_191941_t, llllllllllllIlIIIllIlllllIIlllIl - this.field_191942_u);
            }
            this.field_191941_t = llllllllllllIlIIIllIlllllIIllIII;
            this.field_191942_u = llllllllllllIlIIIllIlllllIIlllIl;
        }
        else {
            this.field_191944_v = false;
        }
        this.drawDefaultBackground();
        this.func_191936_c(llllllllllllIlIIIllIlllllIIllIII, llllllllllllIlIIIllIlllllIIlllIl, llllllllllllIlIIIllIlllllIIllIll, llllllllllllIlIIIllIlllllIIllIlI);
        this.func_191934_b(llllllllllllIlIIIllIlllllIIllIll, llllllllllllIlIIIllIlllllIIllIlI);
        this.func_191937_d(llllllllllllIlIIIllIlllllIIllIII, llllllllllllIlIIIllIlllllIIlllIl, llllllllllllIlIIIllIlllllIIllIll, llllllllllllIlIIIllIlllllIIllIlI);
    }
    
    @Override
    public void func_191932_c(final Advancement llllllllllllIlIIIllIllllIlIIlIll) {
        final GuiAdvancementTab llllllllllllIlIIIllIllllIlIIllIl = this.func_191935_f(llllllllllllIlIIIllIllllIlIIlIll);
        if (llllllllllllIlIIIllIllllIlIIllIl != null) {
            llllllllllllIlIIIllIllllIlIIllIl.func_191800_a(llllllllllllIlIIIllIllllIlIIlIll);
        }
    }
    
    @Override
    public void func_191933_a(final Advancement llllllllllllIlIIIllIllllIlIIIIlI, final AdvancementProgress llllllllllllIlIIIllIllllIlIIIIIl) {
        final GuiAdvancement llllllllllllIlIIIllIllllIlIIIIII = this.func_191938_e(llllllllllllIlIIIllIllllIlIIIIlI);
        if (llllllllllllIlIIIllIllllIlIIIIII != null) {
            llllllllllllIlIIIllIllllIlIIIIII.func_191824_a(llllllllllllIlIIIllIllllIlIIIIIl);
        }
    }
}
