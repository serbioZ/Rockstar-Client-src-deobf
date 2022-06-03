// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiButtonImage extends GuiButton
{
    private final /* synthetic */ int field_191747_p;
    private final /* synthetic */ int field_191749_r;
    private final /* synthetic */ ResourceLocation field_191750_o;
    private final /* synthetic */ int field_191748_q;
    
    public void func_191745_a(final Minecraft lllllllllllllIllIlIlIllIlllIlIlI, final int lllllllllllllIllIlIlIllIlllIlIIl, final int lllllllllllllIllIlIlIllIlllIIIIl, final float lllllllllllllIllIlIlIllIlllIIlll) {
        if (this.visible) {
            this.hovered = (lllllllllllllIllIlIlIllIlllIlIIl >= this.xPosition && lllllllllllllIllIlIlIllIlllIIIIl >= this.yPosition && lllllllllllllIllIlIlIllIlllIlIIl < this.xPosition + this.width && lllllllllllllIllIlIlIllIlllIIIIl < this.yPosition + this.height);
            lllllllllllllIllIlIlIllIlllIlIlI.getTextureManager().bindTexture(this.field_191750_o);
            GlStateManager.disableDepth();
            final int lllllllllllllIllIlIlIllIlllIIllI = this.field_191747_p;
            int lllllllllllllIllIlIlIllIlllIIlIl = this.field_191748_q;
            if (this.hovered) {
                lllllllllllllIllIlIlIllIlllIIlIl += this.field_191749_r;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllIllIlIlIllIlllIIllI, lllllllllllllIllIlIlIllIlllIIlIl, this.width, this.height);
            GlStateManager.enableDepth();
        }
    }
    
    public GuiButtonImage(final int lllllllllllllIllIlIlIlllIIIIIIll, final int lllllllllllllIllIlIlIlllIIIIllII, final int lllllllllllllIllIlIlIlllIIIIlIll, final int lllllllllllllIllIlIlIlllIIIIIIII, final int lllllllllllllIllIlIlIlllIIIIlIIl, final int lllllllllllllIllIlIlIllIlllllllI, final int lllllllllllllIllIlIlIlllIIIIIlll, final int lllllllllllllIllIlIlIllIllllllII, final ResourceLocation lllllllllllllIllIlIlIlllIIIIIlIl) {
        super(lllllllllllllIllIlIlIlllIIIIIIll, lllllllllllllIllIlIlIlllIIIIllII, lllllllllllllIllIlIlIlllIIIIlIll, lllllllllllllIllIlIlIlllIIIIIIII, lllllllllllllIllIlIlIlllIIIIlIIl, "");
        this.field_191747_p = lllllllllllllIllIlIlIllIlllllllI;
        this.field_191748_q = lllllllllllllIllIlIlIlllIIIIIlll;
        this.field_191749_r = lllllllllllllIllIlIlIllIllllllII;
        this.field_191750_o = lllllllllllllIllIlIlIlllIIIIIlIl;
    }
    
    public void func_191746_c(final int lllllllllllllIllIlIlIllIllllIIll, final int lllllllllllllIllIlIlIllIllllIlIl) {
        this.xPosition = lllllllllllllIllIlIlIllIllllIIll;
        this.yPosition = lllllllllllllIllIlIlIllIllllIlIl;
    }
}
