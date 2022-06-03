// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiButtonToggle extends GuiButton
{
    protected /* synthetic */ ResourceLocation field_191760_o;
    protected /* synthetic */ boolean field_191755_p;
    protected /* synthetic */ int field_191757_r;
    protected /* synthetic */ int field_191758_s;
    protected /* synthetic */ int field_191759_t;
    protected /* synthetic */ int field_191756_q;
    
    public void func_191751_a(final int llllllllllllIlIllllIIllIlIIIlIII, final int llllllllllllIlIllllIIllIlIIIIlll, final int llllllllllllIlIllllIIllIlIIIllII, final int llllllllllllIlIllllIIllIlIIIlIll, final ResourceLocation llllllllllllIlIllllIIllIlIIIlIlI) {
        this.field_191756_q = llllllllllllIlIllllIIllIlIIIlIII;
        this.field_191757_r = llllllllllllIlIllllIIllIlIIIIlll;
        this.field_191758_s = llllllllllllIlIllllIIllIlIIIllII;
        this.field_191759_t = llllllllllllIlIllllIIllIlIIIlIll;
        this.field_191760_o = llllllllllllIlIllllIIllIlIIIlIlI;
    }
    
    public void func_191753_b(final boolean llllllllllllIlIllllIIllIlIIIIIII) {
        this.field_191755_p = llllllllllllIlIllllIIllIlIIIIIII;
    }
    
    public GuiButtonToggle(final int llllllllllllIlIllllIIllIlIlIIIlI, final int llllllllllllIlIllllIIllIlIIllIlI, final int llllllllllllIlIllllIIllIlIIllIIl, final int llllllllllllIlIllllIIllIlIIllIII, final int llllllllllllIlIllllIIllIlIIllllI, final boolean llllllllllllIlIllllIIllIlIIlIllI) {
        super(llllllllllllIlIllllIIllIlIlIIIlI, llllllllllllIlIllllIIllIlIIllIlI, llllllllllllIlIllllIIllIlIIllIIl, llllllllllllIlIllllIIllIlIIllIII, llllllllllllIlIllllIIllIlIIllllI, "");
        this.field_191755_p = llllllllllllIlIllllIIllIlIIlIllI;
    }
    
    public void func_191745_a(final Minecraft llllllllllllIlIllllIIllIIllIIIll, final int llllllllllllIlIllllIIllIIllIlIIl, final int llllllllllllIlIllllIIllIIllIlIII, final float llllllllllllIlIllllIIllIIllIIlll) {
        if (this.visible) {
            this.hovered = (llllllllllllIlIllllIIllIIllIlIIl >= this.xPosition && llllllllllllIlIllllIIllIIllIlIII >= this.yPosition && llllllllllllIlIllllIIllIIllIlIIl < this.xPosition + this.width && llllllllllllIlIllllIIllIIllIlIII < this.yPosition + this.height);
            llllllllllllIlIllllIIllIIllIIIll.getTextureManager().bindTexture(this.field_191760_o);
            GlStateManager.disableDepth();
            int llllllllllllIlIllllIIllIIllIIllI = this.field_191756_q;
            int llllllllllllIlIllllIIllIIllIIlIl = this.field_191757_r;
            if (this.field_191755_p) {
                llllllllllllIlIllllIIllIIllIIllI += this.field_191758_s;
            }
            if (this.hovered) {
                llllllllllllIlIllllIIllIIllIIlIl += this.field_191759_t;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllIlIllllIIllIIllIIllI, llllllllllllIlIllllIIllIIllIIlIl, this.width, this.height);
            GlStateManager.enableDepth();
        }
    }
    
    public void func_191752_c(final int llllllllllllIlIllllIIllIIlllIIll, final int llllllllllllIlIllllIIllIIlllIlIl) {
        this.xPosition = llllllllllllIlIllllIIllIIlllIIll;
        this.yPosition = llllllllllllIlIllllIIllIIlllIlIl;
    }
    
    public boolean func_191754_c() {
        return this.field_191755_p;
    }
}
