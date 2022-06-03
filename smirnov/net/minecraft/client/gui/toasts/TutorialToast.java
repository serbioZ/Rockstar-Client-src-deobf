// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;

public class TutorialToast implements IToast
{
    private final /* synthetic */ String field_193672_d;
    private final /* synthetic */ String field_193673_e;
    private /* synthetic */ float field_193676_h;
    private final /* synthetic */ Icons field_193671_c;
    private /* synthetic */ long field_193675_g;
    private final /* synthetic */ boolean field_193678_j;
    private /* synthetic */ float field_193677_i;
    private /* synthetic */ Visibility field_193674_f;
    
    public void func_193670_a() {
        this.field_193674_f = Visibility.HIDE;
    }
    
    public void func_193669_a(final float lllllllllllIllIIlIlIllIlllIlllIl) {
        this.field_193677_i = lllllllllllIllIIlIlIllIlllIlllIl;
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllIllIIlIlIllIllllIlIIl, final long lllllllllllIllIIlIlIllIllllIlIII) {
        lllllllllllIllIIlIlIllIllllIlIIl.func_192989_b().getTextureManager().bindTexture(TutorialToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        lllllllllllIllIIlIlIllIllllIlIIl.drawTexturedModalRect(0, 0, 0, 96, 160, 32);
        this.field_193671_c.func_193697_a(lllllllllllIllIIlIlIllIllllIlIIl, 6, 6);
        if (this.field_193673_e == null) {
            lllllllllllIllIIlIlIllIllllIlIIl.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193672_d, 30.0f, 12.0f, -11534256);
        }
        else {
            lllllllllllIllIIlIlIllIllllIlIIl.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193672_d, 30.0f, 7.0f, -11534256);
            lllllllllllIllIIlIlIllIllllIlIIl.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193673_e, 30.0f, 18.0f, -16777216);
        }
        if (this.field_193678_j) {
            Gui.drawRect(3.0, 28.0, 157.0, 29.0, -1);
            final float lllllllllllIllIIlIlIllIllllIllIl = (float)MathHelper.clampedLerp(this.field_193676_h, this.field_193677_i, (lllllllllllIllIIlIlIllIllllIlIII - this.field_193675_g) / 100.0f);
            int lllllllllllIllIIlIlIllIllllIlIll = 0;
            if (this.field_193677_i >= this.field_193676_h) {
                final int lllllllllllIllIIlIlIllIllllIllII = -16755456;
            }
            else {
                lllllllllllIllIIlIlIllIllllIlIll = -11206656;
            }
            Gui.drawRect(3.0, 28.0, (int)(3.0f + 154.0f * lllllllllllIllIIlIlIllIllllIllIl), 29.0, lllllllllllIllIIlIlIllIllllIlIll);
            this.field_193676_h = lllllllllllIllIIlIlIllIllllIllIl;
            this.field_193675_g = lllllllllllIllIIlIlIllIllllIlIII;
        }
        return this.field_193674_f;
    }
    
    public TutorialToast(final Icons lllllllllllIllIIlIlIllIllllllllI, final ITextComponent lllllllllllIllIIlIlIllIlllllllIl, @Nullable final ITextComponent lllllllllllIllIIlIlIllIlllllIlll, final boolean lllllllllllIllIIlIlIllIlllllIllI) {
        this.field_193674_f = Visibility.SHOW;
        this.field_193671_c = lllllllllllIllIIlIlIllIllllllllI;
        this.field_193672_d = lllllllllllIllIIlIlIllIlllllllIl.getFormattedText();
        this.field_193673_e = ((lllllllllllIllIIlIlIllIlllllIlll == null) ? null : lllllllllllIllIIlIlIllIlllllIlll.getFormattedText());
        this.field_193678_j = lllllllllllIllIIlIlIllIlllllIllI;
    }
    
    public enum Icons
    {
        RECIPE_BOOK("RECIPE_BOOK", 3, 0, 1);
        
        private final /* synthetic */ int field_193703_f;
        
        TREE("TREE", 2, 2, 0), 
        MOUSE("MOUSE", 1, 1, 0), 
        MOVEMENT_KEYS("MOVEMENT_KEYS", 0, 0, 0), 
        WOODEN_PLANKS("WOODEN_PLANKS", 4, 1, 1);
        
        private final /* synthetic */ int field_193704_g;
        
        private Icons(final String llllllllllllIlllIIIIllllIIIIlllI, final int llllllllllllIlllIIIIllllIIIIllIl, final int llllllllllllIlllIIIIllllIIIlIIIl, final int llllllllllllIlllIIIIllllIIIIlIll) {
            this.field_193703_f = llllllllllllIlllIIIIllllIIIlIIIl;
            this.field_193704_g = llllllllllllIlllIIIIllllIIIIlIll;
        }
        
        public void func_193697_a(final Gui llllllllllllIlllIIIIllllIIIIIIIl, final int llllllllllllIlllIIIIllllIIIIIIII, final int llllllllllllIlllIIIIlllIllllllll) {
            GlStateManager.enableBlend();
            llllllllllllIlllIIIIllllIIIIIIIl.drawTexturedModalRect(llllllllllllIlllIIIIllllIIIIIIII, llllllllllllIlllIIIIlllIllllllll, 176 + this.field_193703_f * 20, this.field_193704_g * 20, 20, 20);
            GlStateManager.enableBlend();
        }
    }
}
