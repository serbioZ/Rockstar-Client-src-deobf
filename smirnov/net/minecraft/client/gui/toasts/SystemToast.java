// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;

public class SystemToast implements IToast
{
    private /* synthetic */ String field_193660_d;
    private /* synthetic */ long field_193662_f;
    private /* synthetic */ boolean field_193663_g;
    private /* synthetic */ String field_193661_e;
    private final /* synthetic */ Type field_193659_c;
    
    public static void func_193657_a(final GuiToast lllllllllllIllllIllIIIIlIllIllIl, final Type lllllllllllIllllIllIIIIlIllIIlll, final ITextComponent lllllllllllIllllIllIIIIlIllIlIll, @Nullable final ITextComponent lllllllllllIllllIllIIIIlIllIlIlI) {
        final SystemToast lllllllllllIllllIllIIIIlIllIlIIl = lllllllllllIllllIllIIIIlIllIllIl.func_192990_a((Class<? extends SystemToast>)SystemToast.class, (Object)lllllllllllIllllIllIIIIlIllIIlll);
        if (lllllllllllIllllIllIIIIlIllIlIIl == null) {
            lllllllllllIllllIllIIIIlIllIllIl.func_192988_a(new SystemToast(lllllllllllIllllIllIIIIlIllIIlll, lllllllllllIllllIllIIIIlIllIlIll, lllllllllllIllllIllIIIIlIllIlIlI));
        }
        else {
            lllllllllllIllllIllIIIIlIllIlIIl.func_193656_a(lllllllllllIllllIllIIIIlIllIlIll, lllllllllllIllllIllIIIIlIllIlIlI);
        }
    }
    
    public SystemToast(final Type lllllllllllIllllIllIIIIllIIIlIlI, final ITextComponent lllllllllllIllllIllIIIIllIIIllIl, @Nullable final ITextComponent lllllllllllIllllIllIIIIllIIIllII) {
        this.field_193659_c = lllllllllllIllllIllIIIIllIIIlIlI;
        this.field_193660_d = lllllllllllIllllIllIIIIllIIIllIl.getUnformattedText();
        this.field_193661_e = ((lllllllllllIllllIllIIIIllIIIllII == null) ? null : lllllllllllIllllIllIIIIllIIIllII.getUnformattedText());
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllIllllIllIIIIllIIIIIll, final long lllllllllllIllllIllIIIIlIlllllll) {
        if (this.field_193663_g) {
            this.field_193662_f = lllllllllllIllllIllIIIIlIlllllll;
            this.field_193663_g = false;
        }
        lllllllllllIllllIllIIIIllIIIIIll.func_192989_b().getTextureManager().bindTexture(SystemToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        lllllllllllIllllIllIIIIllIIIIIll.drawTexturedModalRect(0, 0, 0, 64, 160, 32);
        if (this.field_193661_e == null) {
            lllllllllllIllllIllIIIIllIIIIIll.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193660_d, 18.0f, 12.0f, -256);
        }
        else {
            lllllllllllIllllIllIIIIllIIIIIll.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193660_d, 18.0f, 7.0f, -256);
            lllllllllllIllllIllIIIIllIIIIIll.func_192989_b();
            Minecraft.fontRendererObj.drawString(this.field_193661_e, 18.0f, 18.0f, -1);
        }
        return (lllllllllllIllllIllIIIIlIlllllll - this.field_193662_f < 5000L) ? Visibility.SHOW : Visibility.HIDE;
    }
    
    @Override
    public Type func_193652_b() {
        return this.field_193659_c;
    }
    
    public void func_193656_a(final ITextComponent lllllllllllIllllIllIIIIlIllllIlI, @Nullable final ITextComponent lllllllllllIllllIllIIIIlIlllIllI) {
        this.field_193660_d = lllllllllllIllllIllIIIIlIllllIlI.getUnformattedText();
        this.field_193661_e = ((lllllllllllIllllIllIIIIlIlllIllI == null) ? null : lllllllllllIllllIllIIIIlIlllIllI.getUnformattedText());
        this.field_193663_g = true;
    }
    
    public enum Type
    {
        NARRATOR_TOGGLE("NARRATOR_TOGGLE", 1), 
        TUTORIAL_HINT("TUTORIAL_HINT", 0);
        
        private Type(final String llllllllllIllllIlIlllllIIlIIIlll, final int llllllllllIllllIlIlllllIIlIIIllI) {
        }
    }
}
