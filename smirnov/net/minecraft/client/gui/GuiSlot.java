// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.math.MathHelper;
import org.lwjgl.input.Mouse;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;

public abstract class GuiSlot
{
    protected /* synthetic */ boolean centerListVertically;
    protected /* synthetic */ int top;
    protected /* synthetic */ float scrollMultiplier;
    private /* synthetic */ int scrollDownButtonID;
    protected /* synthetic */ int height;
    protected final /* synthetic */ int slotHeight;
    protected /* synthetic */ int initialClickY;
    protected /* synthetic */ int headerPadding;
    private /* synthetic */ int scrollUpButtonID;
    protected /* synthetic */ long lastClicked;
    protected /* synthetic */ int right;
    protected /* synthetic */ int left;
    protected /* synthetic */ int width;
    protected /* synthetic */ boolean hasListHeader;
    protected /* synthetic */ boolean showSelectionBox;
    protected /* synthetic */ boolean visible;
    protected /* synthetic */ int bottom;
    protected /* synthetic */ int selectedElement;
    protected /* synthetic */ int mouseY;
    private /* synthetic */ boolean enabled;
    protected final /* synthetic */ Minecraft mc;
    protected /* synthetic */ int mouseX;
    protected /* synthetic */ float amountScrolled;
    
    protected void overlayBackground(final int llllllllllllIlIIIlIIlIIIIlllIIIl, final int llllllllllllIlIIIlIIlIIIIllIlIII, final int llllllllllllIlIIIlIIlIIIIllIllll, final int llllllllllllIlIIIlIIlIIIIllIIllI) {
        final Tessellator llllllllllllIlIIIlIIlIIIIllIllIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllIlIIIlIIlIIIIllIllII = llllllllllllIlIIIlIIlIIIIllIllIl.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllIlIIIlIIlIIIIllIlIll = 32.0f;
        llllllllllllIlIIIlIIlIIIIllIllII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllIlIIIlIIlIIIIllIllII.pos(this.left, llllllllllllIlIIIlIIlIIIIllIlIII, 0.0).tex(0.0, llllllllllllIlIIIlIIlIIIIllIlIII / 32.0f).color(64, 64, 64, llllllllllllIlIIIlIIlIIIIllIIllI).endVertex();
        llllllllllllIlIIIlIIlIIIIllIllII.pos(this.left + this.width, llllllllllllIlIIIlIIlIIIIllIlIII, 0.0).tex(this.width / 32.0f, llllllllllllIlIIIlIIlIIIIllIlIII / 32.0f).color(64, 64, 64, llllllllllllIlIIIlIIlIIIIllIIllI).endVertex();
        llllllllllllIlIIIlIIlIIIIllIllII.pos(this.left + this.width, llllllllllllIlIIIlIIlIIIIlllIIIl, 0.0).tex(this.width / 32.0f, llllllllllllIlIIIlIIlIIIIlllIIIl / 32.0f).color(64, 64, 64, llllllllllllIlIIIlIIlIIIIllIllll).endVertex();
        llllllllllllIlIIIlIIlIIIIllIllII.pos(this.left, llllllllllllIlIIIlIIlIIIIlllIIIl, 0.0).tex(0.0, llllllllllllIlIIIlIIlIIIIlllIIIl / 32.0f).color(64, 64, 64, llllllllllllIlIIIlIIlIIIIllIllll).endVertex();
        llllllllllllIlIIIlIIlIIIIllIllIl.draw();
    }
    
    public int getListWidth() {
        return 220;
    }
    
    protected void func_192638_a(final int llllllllllllIlIIIlIIlIIIlIIIlIlI, final int llllllllllllIlIIIlIIlIIIlIIIlIIl, final int llllllllllllIlIIIlIIlIIIlIIIlIII, final int llllllllllllIlIIIlIIlIIIlIIlIlIl, final float llllllllllllIlIIIlIIlIIIlIIlIlII) {
        final int llllllllllllIlIIIlIIlIIIlIIlIIll = this.getSize();
        final Tessellator llllllllllllIlIIIlIIlIIIlIIlIIlI = Tessellator.getInstance();
        final BufferBuilder llllllllllllIlIIIlIIlIIIlIIlIIIl = llllllllllllIlIIIlIIlIIIlIIlIIlI.getBuffer();
        for (int llllllllllllIlIIIlIIlIIIlIIlIIII = 0; llllllllllllIlIIIlIIlIIIlIIlIIII < llllllllllllIlIIIlIIlIIIlIIlIIll; ++llllllllllllIlIIIlIIlIIIlIIlIIII) {
            final int llllllllllllIlIIIlIIlIIIlIIIllll = llllllllllllIlIIIlIIlIIIlIIIlIIl + llllllllllllIlIIIlIIlIIIlIIlIIII * this.slotHeight + this.headerPadding;
            final int llllllllllllIlIIIlIIlIIIlIIIlllI = this.slotHeight - 4;
            if (llllllllllllIlIIIlIIlIIIlIIIllll > this.bottom || llllllllllllIlIIIlIIlIIIlIIIllll + llllllllllllIlIIIlIIlIIIlIIIlllI < this.top) {
                this.func_192639_a(llllllllllllIlIIIlIIlIIIlIIlIIII, llllllllllllIlIIIlIIlIIIlIIIlIlI, llllllllllllIlIIIlIIlIIIlIIIllll, llllllllllllIlIIIlIIlIIIlIIlIlII);
            }
            if (this.showSelectionBox && this.isSelected(llllllllllllIlIIIlIIlIIIlIIlIIII)) {
                final int llllllllllllIlIIIlIIlIIIlIIIllIl = this.left + (this.width / 2 - this.getListWidth() / 2);
                final int llllllllllllIlIIIlIIlIIIlIIIllII = this.left + this.width / 2 + this.getListWidth() / 2;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.disableTexture2D();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllIl, llllllllllllIlIIIlIIlIIIlIIIllll + llllllllllllIlIIIlIIlIIIlIIIlllI + 2, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllII, llllllllllllIlIIIlIIlIIIlIIIllll + llllllllllllIlIIIlIIlIIIlIIIlllI + 2, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllII, llllllllllllIlIIIlIIlIIIlIIIllll - 2, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllIl, llllllllllllIlIIIlIIlIIIlIIIllll - 2, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllIl + 1, llllllllllllIlIIIlIIlIIIlIIIllll + llllllllllllIlIIIlIIlIIIlIIIlllI + 1, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllII - 1, llllllllllllIlIIIlIIlIIIlIIIllll + llllllllllllIlIIIlIIlIIIlIIIlllI + 1, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllII - 1, llllllllllllIlIIIlIIlIIIlIIIllll - 1, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIIl.pos(llllllllllllIlIIIlIIlIIIlIIIllIl + 1, llllllllllllIlIIIlIIlIIIlIIIllll - 1, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlIIlIIlI.draw();
                GlStateManager.enableTexture2D();
            }
            if (llllllllllllIlIIIlIIlIIIlIIIllll >= this.top - this.slotHeight && llllllllllllIlIIIlIIlIIIlIIIllll <= this.bottom) {
                this.func_192637_a(llllllllllllIlIIIlIIlIIIlIIlIIII, llllllllllllIlIIIlIIlIIIlIIIlIlI, llllllllllllIlIIIlIIlIIIlIIIllll, llllllllllllIlIIIlIIlIIIlIIIlllI, llllllllllllIlIIIlIIlIIIlIIIlIII, llllllllllllIlIIIlIIlIIIlIIlIlIl, llllllllllllIlIIIlIIlIIIlIIlIlII);
            }
        }
    }
    
    protected abstract int getSize();
    
    public GuiSlot(final Minecraft llllllllllllIlIIIlIIlIIlIllIlllI, final int llllllllllllIlIIIlIIlIIlIllIllIl, final int llllllllllllIlIIIlIIlIIlIllIllII, final int llllllllllllIlIIIlIIlIIlIlllIIlI, final int llllllllllllIlIIIlIIlIIlIlllIIIl, final int llllllllllllIlIIIlIIlIIlIlllIIII) {
        this.centerListVertically = true;
        this.initialClickY = -2;
        this.selectedElement = -1;
        this.visible = true;
        this.showSelectionBox = true;
        this.enabled = true;
        this.mc = llllllllllllIlIIIlIIlIIlIllIlllI;
        this.width = llllllllllllIlIIIlIIlIIlIllIllIl;
        this.height = llllllllllllIlIIIlIIlIIlIllIllII;
        this.top = llllllllllllIlIIIlIIlIIlIlllIIlI;
        this.bottom = llllllllllllIlIIIlIIlIIlIlllIIIl;
        this.slotHeight = llllllllllllIlIIIlIIlIIlIlllIIII;
        this.left = 0;
        this.right = llllllllllllIlIIIlIIlIIlIllIllIl;
    }
    
    public int getMaxScroll() {
        return Math.max(0, this.getContentHeight() - (this.bottom - this.top - 4));
    }
    
    public void actionPerformed(final GuiButton llllllllllllIlIIIlIIlIIlIIIIIIII) {
        if (llllllllllllIlIIIlIIlIIlIIIIIIII.enabled) {
            if (llllllllllllIlIIIlIIlIIlIIIIIIII.id == this.scrollUpButtonID) {
                this.amountScrolled -= this.slotHeight * 2 / 3;
                this.initialClickY = -2;
                this.bindAmountScrolled();
            }
            else if (llllllllllllIlIIIlIIlIIlIIIIIIII.id == this.scrollDownButtonID) {
                this.amountScrolled += this.slotHeight * 2 / 3;
                this.initialClickY = -2;
                this.bindAmountScrolled();
            }
        }
    }
    
    public int getAmountScrolled() {
        return (int)this.amountScrolled;
    }
    
    public void setSlotXBoundsFromLeft(final int llllllllllllIlIIIlIIlIIIIlIlllIl) {
        this.left = llllllllllllIlIIIlIIlIIIIlIlllIl;
        this.right = llllllllllllIlIIIlIIlIIIIlIlllIl + this.width;
    }
    
    protected abstract boolean isSelected(final int p0);
    
    protected abstract void func_192637_a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final float p6);
    
    public boolean getEnabled() {
        return this.enabled;
    }
    
    protected void setHasListHeader(final boolean llllllllllllIlIIIlIIlIIlIlIIllII, final int llllllllllllIlIIIlIIlIIlIlIIlllI) {
        this.hasListHeader = llllllllllllIlIIIlIIlIIlIlIIllII;
        this.headerPadding = llllllllllllIlIIIlIIlIIlIlIIlllI;
        if (!llllllllllllIlIIIlIIlIIlIlIIllII) {
            this.headerPadding = 0;
        }
    }
    
    public void func_193651_b(final boolean llllllllllllIlIIIlIIlIIlIlIlIllI) {
        this.showSelectionBox = llllllllllllIlIIIlIIlIIlIlIlIllI;
    }
    
    public void setDimensions(final int llllllllllllIlIIIlIIlIIlIlIlllIl, final int llllllllllllIlIIIlIIlIIlIlIlllII, final int llllllllllllIlIIIlIIlIIlIlIllIll, final int llllllllllllIlIIIlIIlIIlIlIllIlI) {
        this.width = llllllllllllIlIIIlIIlIIlIlIlllIl;
        this.height = llllllllllllIlIIIlIIlIIlIlIlllII;
        this.top = llllllllllllIlIIIlIIlIIlIlIllIll;
        this.bottom = llllllllllllIlIIIlIIlIIlIlIllIlI;
        this.left = 0;
        this.right = llllllllllllIlIIIlIIlIIlIlIlllIl;
    }
    
    public void handleMouseInput() {
        if (this.isMouseYWithinSlotBounds(this.mouseY)) {
            if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.mouseY >= this.top && this.mouseY <= this.bottom) {
                final int llllllllllllIlIIIlIIlIIIllIIlIlI = (this.width - this.getListWidth()) / 2;
                final int llllllllllllIlIIIlIIlIIIllIIlIIl = (this.width + this.getListWidth()) / 2;
                final int llllllllllllIlIIIlIIlIIIllIIlIII = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
                final int llllllllllllIlIIIlIIlIIIllIIIlll = llllllllllllIlIIIlIIlIIIllIIlIII / this.slotHeight;
                if (llllllllllllIlIIIlIIlIIIllIIIlll < this.getSize() && this.mouseX >= llllllllllllIlIIIlIIlIIIllIIlIlI && this.mouseX <= llllllllllllIlIIIlIIlIIIllIIlIIl && llllllllllllIlIIIlIIlIIIllIIIlll >= 0 && llllllllllllIlIIIlIIlIIIllIIlIII >= 0) {
                    this.elementClicked(llllllllllllIlIIIlIIlIIIllIIIlll, false, this.mouseX, this.mouseY);
                    this.selectedElement = llllllllllllIlIIIlIIlIIIllIIIlll;
                }
                else if (this.mouseX >= llllllllllllIlIIIlIIlIIIllIIlIlI && this.mouseX <= llllllllllllIlIIIlIIlIIIllIIlIIl && llllllllllllIlIIIlIIlIIIllIIlIII < 0) {
                    this.clickedHeader(this.mouseX - llllllllllllIlIIIlIIlIIIllIIlIlI, this.mouseY - this.top + (int)this.amountScrolled - 4);
                }
            }
            if (Mouse.isButtonDown(0) && this.getEnabled()) {
                if (this.initialClickY != -1) {
                    if (this.initialClickY >= 0) {
                        this.amountScrolled -= (this.mouseY - this.initialClickY) * this.scrollMultiplier;
                        this.initialClickY = this.mouseY;
                    }
                }
                else {
                    boolean llllllllllllIlIIIlIIlIIIllIIIllI = true;
                    if (this.mouseY >= this.top && this.mouseY <= this.bottom) {
                        final int llllllllllllIlIIIlIIlIIIllIIIlIl = (this.width - this.getListWidth()) / 2;
                        final int llllllllllllIlIIIlIIlIIIllIIIlII = (this.width + this.getListWidth()) / 2;
                        final int llllllllllllIlIIIlIIlIIIllIIIIll = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
                        final int llllllllllllIlIIIlIIlIIIllIIIIlI = llllllllllllIlIIIlIIlIIIllIIIIll / this.slotHeight;
                        if (llllllllllllIlIIIlIIlIIIllIIIIlI < this.getSize() && this.mouseX >= llllllllllllIlIIIlIIlIIIllIIIlIl && this.mouseX <= llllllllllllIlIIIlIIlIIIllIIIlII && llllllllllllIlIIIlIIlIIIllIIIIlI >= 0 && llllllllllllIlIIIlIIlIIIllIIIIll >= 0) {
                            final boolean llllllllllllIlIIIlIIlIIIllIIIIIl = llllllllllllIlIIIlIIlIIIllIIIIlI == this.selectedElement && Minecraft.getSystemTime() - this.lastClicked < 250L;
                            this.elementClicked(llllllllllllIlIIIlIIlIIIllIIIIlI, llllllllllllIlIIIlIIlIIIllIIIIIl, this.mouseX, this.mouseY);
                            this.selectedElement = llllllllllllIlIIIlIIlIIIllIIIIlI;
                            this.lastClicked = Minecraft.getSystemTime();
                        }
                        else if (this.mouseX >= llllllllllllIlIIIlIIlIIIllIIIlIl && this.mouseX <= llllllllllllIlIIIlIIlIIIllIIIlII && llllllllllllIlIIIlIIlIIIllIIIIll < 0) {
                            this.clickedHeader(this.mouseX - llllllllllllIlIIIlIIlIIIllIIIlIl, this.mouseY - this.top + (int)this.amountScrolled - 4);
                            llllllllllllIlIIIlIIlIIIllIIIllI = false;
                        }
                        final int llllllllllllIlIIIlIIlIIIllIIIIII = this.getScrollBarX();
                        final int llllllllllllIlIIIlIIlIIIlIllllll = llllllllllllIlIIIlIIlIIIllIIIIII + 6;
                        if (this.mouseX >= llllllllllllIlIIIlIIlIIIllIIIIII && this.mouseX <= llllllllllllIlIIIlIIlIIIlIllllll) {
                            this.scrollMultiplier = -1.0f;
                            int llllllllllllIlIIIlIIlIIIlIlllllI = this.getMaxScroll();
                            if (llllllllllllIlIIIlIIlIIIlIlllllI < 1) {
                                llllllllllllIlIIIlIIlIIIlIlllllI = 1;
                            }
                            int llllllllllllIlIIIlIIlIIIlIllllIl = (int)((this.bottom - this.top) * (this.bottom - this.top) / (float)this.getContentHeight());
                            llllllllllllIlIIIlIIlIIIlIllllIl = MathHelper.clamp(llllllllllllIlIIIlIIlIIIlIllllIl, 32, this.bottom - this.top - 8);
                            this.scrollMultiplier /= (this.bottom - this.top - llllllllllllIlIIIlIIlIIIlIllllIl) / (float)llllllllllllIlIIIlIIlIIIlIlllllI;
                        }
                        else {
                            this.scrollMultiplier = 1.0f;
                        }
                        if (llllllllllllIlIIIlIIlIIIllIIIllI) {
                            this.initialClickY = this.mouseY;
                        }
                        else {
                            this.initialClickY = -2;
                        }
                    }
                    else {
                        this.initialClickY = -2;
                    }
                }
            }
            else {
                this.initialClickY = -1;
            }
            int llllllllllllIlIIIlIIlIIIlIllllII = Mouse.getEventDWheel();
            if (llllllllllllIlIIIlIIlIIIlIllllII != 0) {
                if (llllllllllllIlIIIlIIlIIIlIllllII > 0) {
                    llllllllllllIlIIIlIIlIIIlIllllII = -1;
                }
                else if (llllllllllllIlIIIlIIlIIIlIllllII < 0) {
                    llllllllllllIlIIIlIIlIIIlIllllII = 1;
                }
                this.amountScrolled += llllllllllllIlIIIlIIlIIIlIllllII * this.slotHeight / 2;
            }
        }
    }
    
    protected void bindAmountScrolled() {
        this.amountScrolled = MathHelper.clamp(this.amountScrolled, 0.0f, (float)this.getMaxScroll());
    }
    
    protected void func_192639_a(final int llllllllllllIlIIIlIIlIIlIlIIIllI, final int llllllllllllIlIIIlIIlIIlIlIIIlIl, final int llllllllllllIlIIIlIIlIIlIlIIIlII, final float llllllllllllIlIIIlIIlIIlIlIIIIll) {
    }
    
    protected abstract void elementClicked(final int p0, final boolean p1, final int p2, final int p3);
    
    protected void drawContainerBackground(final Tessellator llllllllllllIlIIIlIIlIIIIlIlIIII) {
        final BufferBuilder llllllllllllIlIIIlIIlIIIIlIlIIll = llllllllllllIlIIIlIIlIIIIlIlIIII.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllIlIIIlIIlIIIIlIlIIlI = 32.0f;
        llllllllllllIlIIIlIIlIIIIlIlIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllIlIIIlIIlIIIIlIlIIll.pos(this.left, this.bottom, 0.0).tex(this.left / 32.0f, (this.bottom + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllIlIIIlIIlIIIIlIlIIll.pos(this.right, this.bottom, 0.0).tex(this.right / 32.0f, (this.bottom + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllIlIIIlIIlIIIIlIlIIll.pos(this.right, this.top, 0.0).tex(this.right / 32.0f, (this.top + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllIlIIIlIIlIIIIlIlIIll.pos(this.left, this.top, 0.0).tex(this.left / 32.0f, (this.top + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllIlIIIlIIlIIIIlIlIIII.draw();
    }
    
    protected void drawListHeader(final int llllllllllllIlIIIlIIlIIlIlIIIIIl, final int llllllllllllIlIIIlIIlIIlIlIIIIII, final Tessellator llllllllllllIlIIIlIIlIIlIIllllll) {
    }
    
    public void drawScreen(final int llllllllllllIlIIIlIIlIIIllllIIII, final int llllllllllllIlIIIlIIlIIIlllIIIIl, final float llllllllllllIlIIIlIIlIIIlllIlllI) {
        if (this.visible) {
            this.mouseX = llllllllllllIlIIIlIIlIIIllllIIII;
            this.mouseY = llllllllllllIlIIIlIIlIIIlllIIIIl;
            this.drawBackground();
            final int llllllllllllIlIIIlIIlIIIlllIllIl = this.getScrollBarX();
            final int llllllllllllIlIIIlIIlIIIlllIllII = llllllllllllIlIIIlIIlIIIlllIllIl + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator llllllllllllIlIIIlIIlIIIlllIlIll = Tessellator.getInstance();
            final BufferBuilder llllllllllllIlIIIlIIlIIIlllIlIlI = llllllllllllIlIIIlIIlIIIlllIlIll.getBuffer();
            this.drawContainerBackground(llllllllllllIlIIIlIIlIIIlllIlIll);
            final int llllllllllllIlIIIlIIlIIIlllIlIIl = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllIlIIIlIIlIIIlllIlIII = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(llllllllllllIlIIIlIIlIIIlllIlIIl, llllllllllllIlIIIlIIlIIIlllIlIII, llllllllllllIlIIIlIIlIIIlllIlIll);
            }
            this.func_192638_a(llllllllllllIlIIIlIIlIIIlllIlIIl, llllllllllllIlIIIlIIlIIIlllIlIII, llllllllllllIlIIIlIIlIIIllllIIII, llllllllllllIlIIIlIIlIIIlllIIIIl, llllllllllllIlIIIlIIlIIIlllIlllI);
            GlStateManager.disableDepth();
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.disableTexture2D();
            final int llllllllllllIlIIIlIIlIIIlllIIlll = 4;
            llllllllllllIlIIIlIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.left, this.top + 4, 0.0).tex(0.0, 1.0).color(0, 0, 0, 0).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.right, this.top + 4, 0.0).tex(1.0, 1.0).color(0, 0, 0, 0).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.right, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.left, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIll.draw();
            llllllllllllIlIIIlIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.left, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.right, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.right, this.bottom - 4, 0.0).tex(1.0, 0.0).color(0, 0, 0, 0).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIlI.pos(this.left, this.bottom - 4, 0.0).tex(0.0, 0.0).color(0, 0, 0, 0).endVertex();
            llllllllllllIlIIIlIIlIIIlllIlIll.draw();
            final int llllllllllllIlIIIlIIlIIIlllIIllI = this.getMaxScroll();
            if (llllllllllllIlIIIlIIlIIIlllIIllI > 0) {
                int llllllllllllIlIIIlIIlIIIlllIIlIl = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                llllllllllllIlIIIlIIlIIIlllIIlIl = MathHelper.clamp(llllllllllllIlIIIlIIlIIIlllIIlIl, 32, this.bottom - this.top - 8);
                int llllllllllllIlIIIlIIlIIIlllIIlII = (int)this.amountScrolled * (this.bottom - this.top - llllllllllllIlIIIlIIlIIIlllIIlIl) / llllllllllllIlIIIlIIlIIIlllIIllI + this.top;
                if (llllllllllllIlIIIlIIlIIIlllIIlII < this.top) {
                    llllllllllllIlIIIlIIlIIIlllIIlII = this.top;
                }
                llllllllllllIlIIIlIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIll.draw();
                llllllllllllIlIIIlIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, llllllllllllIlIIIlIIlIIIlllIIlII + llllllllllllIlIIIlIIlIIIlllIIlIl, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII, llllllllllllIlIIIlIIlIIIlllIIlII + llllllllllllIlIIIlIIlIIIlllIIlIl, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII, llllllllllllIlIIIlIIlIIIlllIIlII, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, llllllllllllIlIIIlIIlIIIlllIIlII, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIll.draw();
                llllllllllllIlIIIlIIlIIIlllIlIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, llllllllllllIlIIIlIIlIIIlllIIlII + llllllllllllIlIIIlIIlIIIlllIIlIl - 1, 0.0).tex(0.0, 1.0).color(192, 192, 192, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII - 1, llllllllllllIlIIIlIIlIIIlllIIlII + llllllllllllIlIIIlIIlIIIlllIIlIl - 1, 0.0).tex(1.0, 1.0).color(192, 192, 192, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllII - 1, llllllllllllIlIIIlIIlIIIlllIIlII, 0.0).tex(1.0, 0.0).color(192, 192, 192, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIlI.pos(llllllllllllIlIIIlIIlIIIlllIllIl, llllllllllllIlIIIlIIlIIIlllIIlII, 0.0).tex(0.0, 0.0).color(192, 192, 192, 255).endVertex();
                llllllllllllIlIIIlIIlIIIlllIlIll.draw();
            }
            this.renderDecorations(llllllllllllIlIIIlIIlIIIllllIIII, llllllllllllIlIIIlIIlIIIlllIIIIl);
            GlStateManager.enableTexture2D();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    protected void clickedHeader(final int llllllllllllIlIIIlIIlIIlIIllllIl, final int llllllllllllIlIIIlIIlIIlIIllllII) {
    }
    
    protected int getScrollBarX() {
        return this.width / 2 + 124;
    }
    
    public int getSlotHeight() {
        return this.slotHeight;
    }
    
    public void setEnabled(final boolean llllllllllllIlIIIlIIlIIIlIlIlllI) {
        this.enabled = llllllllllllIlIIIlIIlIIIlIlIlllI;
    }
    
    public int getSlotIndexFromScreenCoords(final int llllllllllllIlIIIlIIlIIlIIlIlIIl, final int llllllllllllIlIIIlIIlIIlIIlIllll) {
        final int llllllllllllIlIIIlIIlIIlIIlIlllI = this.left + this.width / 2 - this.getListWidth() / 2;
        final int llllllllllllIlIIIlIIlIIlIIlIllIl = this.left + this.width / 2 + this.getListWidth() / 2;
        final int llllllllllllIlIIIlIIlIIlIIlIllII = llllllllllllIlIIIlIIlIIlIIlIllll - this.top - this.headerPadding + (int)this.amountScrolled - 4;
        final int llllllllllllIlIIIlIIlIIlIIlIlIll = llllllllllllIlIIIlIIlIIlIIlIllII / this.slotHeight;
        return (llllllllllllIlIIIlIIlIIlIIlIlIIl < this.getScrollBarX() && llllllllllllIlIIIlIIlIIlIIlIlIIl >= llllllllllllIlIIIlIIlIIlIIlIlllI && llllllllllllIlIIIlIIlIIlIIlIlIIl <= llllllllllllIlIIIlIIlIIlIIlIllIl && llllllllllllIlIIIlIIlIIlIIlIlIll >= 0 && llllllllllllIlIIIlIIlIIlIIlIllII >= 0 && llllllllllllIlIIIlIIlIIlIIlIlIll < this.getSize()) ? llllllllllllIlIIIlIIlIIlIIlIlIll : -1;
    }
    
    protected void renderDecorations(final int llllllllllllIlIIIlIIlIIlIIlllIlI, final int llllllllllllIlIIIlIIlIIlIIlllIIl) {
    }
    
    public void scrollBy(final int llllllllllllIlIIIlIIlIIlIIIIlIII) {
        this.amountScrolled += llllllllllllIlIIIlIIlIIlIIIIlIII;
        this.bindAmountScrolled();
        this.initialClickY = -2;
    }
    
    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + this.headerPadding;
    }
    
    protected abstract void drawBackground();
    
    public void registerScrollButtons(final int llllllllllllIlIIIlIIlIIlIIIlllII, final int llllllllllllIlIIIlIIlIIlIIIllllI) {
        this.scrollUpButtonID = llllllllllllIlIIIlIIlIIlIIIlllII;
        this.scrollDownButtonID = llllllllllllIlIIIlIIlIIlIIIllllI;
    }
    
    public boolean isMouseYWithinSlotBounds(final int llllllllllllIlIIIlIIlIIlIIIIlllI) {
        return llllllllllllIlIIIlIIlIIlIIIIlllI >= this.top && llllllllllllIlIIIlIIlIIlIIIIlllI <= this.bottom && this.mouseX >= this.left && this.mouseX <= this.right;
    }
}
