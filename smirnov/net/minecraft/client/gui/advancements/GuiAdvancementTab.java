// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.advancements;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.TextureManager;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import java.util.Map;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.Gui;

public class GuiAdvancementTab extends Gui
{
    private /* synthetic */ int field_193939_q;
    private /* synthetic */ int field_191814_q;
    private /* synthetic */ int field_191811_n;
    private /* synthetic */ boolean field_192992_s;
    private /* synthetic */ int field_193940_r;
    private final /* synthetic */ GuiAdvancement field_191809_l;
    private final /* synthetic */ String field_191808_k;
    private final /* synthetic */ GuiScreenAdvancements field_193938_f;
    private final /* synthetic */ AdvancementTabType field_191803_f;
    private final /* synthetic */ Advancement field_191805_h;
    private /* synthetic */ float field_191815_r;
    private /* synthetic */ int field_191813_p;
    private final /* synthetic */ ItemStack field_191807_j;
    private final /* synthetic */ DisplayInfo field_191806_i;
    private final /* synthetic */ Map<Advancement, GuiAdvancement> field_191810_m;
    private /* synthetic */ int field_191812_o;
    private final /* synthetic */ Minecraft field_191802_a;
    private final /* synthetic */ int field_191804_g;
    
    public Advancement func_193935_c() {
        return this.field_191805_h;
    }
    
    public String func_191795_d() {
        return this.field_191808_k;
    }
    
    private void func_193937_a(final GuiAdvancement lllllllllllllIIIIIIIlIIIIIlIlIlI, final Advancement lllllllllllllIIIIIIIlIIIIIlIlIIl) {
        this.field_191810_m.put(lllllllllllllIIIIIIIlIIIIIlIlIIl, lllllllllllllIIIIIIIlIIIIIlIlIlI);
        final int lllllllllllllIIIIIIIlIIIIIlIlIII = lllllllllllllIIIIIIIlIIIIIlIlIlI.func_191823_d();
        final int lllllllllllllIIIIIIIlIIIIIlIIlll = lllllllllllllIIIIIIIlIIIIIlIlIII + 28;
        final int lllllllllllllIIIIIIIlIIIIIlIIllI = lllllllllllllIIIIIIIlIIIIIlIlIlI.func_191820_c();
        final int lllllllllllllIIIIIIIlIIIIIlIIlIl = lllllllllllllIIIIIIIlIIIIIlIIllI + 27;
        this.field_193939_q = Math.min(this.field_193939_q, lllllllllllllIIIIIIIlIIIIIlIlIII);
        this.field_191813_p = Math.max(this.field_191813_p, lllllllllllllIIIIIIIlIIIIIlIIlll);
        this.field_193940_r = Math.min(this.field_193940_r, lllllllllllllIIIIIIIlIIIIIlIIllI);
        this.field_191814_q = Math.max(this.field_191814_q, lllllllllllllIIIIIIIlIIIIIlIIlIl);
        for (final GuiAdvancement lllllllllllllIIIIIIIlIIIIIlIIlII : this.field_191810_m.values()) {
            lllllllllllllIIIIIIIlIIIIIlIIlII.func_191825_b();
        }
    }
    
    public void func_192991_a(final int lllllllllllllIIIIIIIlIIIIllllIII, final int lllllllllllllIIIIIIIlIIIIlllIlll, final int lllllllllllllIIIIIIIlIIIIllIllll, final int lllllllllllllIIIIIIIlIIIIllIlllI) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 200.0f);
        Gui.drawRect(0.0, 0.0, 234.0, 113.0, MathHelper.floor(this.field_191815_r * 255.0f) << 24);
        boolean lllllllllllllIIIIIIIlIIIIlllIlII = false;
        if (lllllllllllllIIIIIIIlIIIIllllIII > 0 && lllllllllllllIIIIIIIlIIIIllllIII < 234 && lllllllllllllIIIIIIIlIIIIlllIlll > 0 && lllllllllllllIIIIIIIlIIIIlllIlll < 113) {
            for (final GuiAdvancement lllllllllllllIIIIIIIlIIIIlllIIll : this.field_191810_m.values()) {
                if (lllllllllllllIIIIIIIlIIIIlllIIll.func_191816_c(this.field_191811_n, this.field_191812_o, lllllllllllllIIIIIIIlIIIIllllIII, lllllllllllllIIIIIIIlIIIIlllIlll)) {
                    lllllllllllllIIIIIIIlIIIIlllIlII = true;
                    lllllllllllllIIIIIIIlIIIIlllIIll.func_191821_a(this.field_191811_n, this.field_191812_o, this.field_191815_r, lllllllllllllIIIIIIIlIIIIllIllll, lllllllllllllIIIIIIIlIIIIllIlllI);
                    break;
                }
            }
        }
        GlStateManager.popMatrix();
        if (lllllllllllllIIIIIIIlIIIIlllIlII) {
            this.field_191815_r = MathHelper.clamp(this.field_191815_r + 0.02f, 0.0f, 0.3f);
        }
        else {
            this.field_191815_r = MathHelper.clamp(this.field_191815_r - 0.04f, 0.0f, 1.0f);
        }
    }
    
    @Nullable
    public GuiAdvancement func_191794_b(final Advancement lllllllllllllIIIIIIIlIIIIIIlIlIl) {
        return this.field_191810_m.get(lllllllllllllIIIIIIIlIIIIIIlIlIl);
    }
    
    public void func_191797_b(final int lllllllllllllIIIIIIIlIIIIIllllll, final int lllllllllllllIIIIIIIlIIIIIlllllI) {
        if (this.field_191813_p - this.field_193939_q > 234) {
            this.field_191811_n = MathHelper.clamp(this.field_191811_n + lllllllllllllIIIIIIIlIIIIIllllll, -(this.field_191813_p - 234), 0);
        }
        if (this.field_191814_q - this.field_193940_r > 113) {
            this.field_191812_o = MathHelper.clamp(this.field_191812_o + lllllllllllllIIIIIIIlIIIIIlllllI, -(this.field_191814_q - 113), 0);
        }
    }
    
    public void func_191798_a(final int lllllllllllllIIIIIIIlIIIlIlIIIlI, final int lllllllllllllIIIIIIIlIIIlIlIIIIl, final boolean lllllllllllllIIIIIIIlIIIlIlIIIII) {
        this.field_191803_f.func_192651_a(this, lllllllllllllIIIIIIIlIIIlIlIIIlI, lllllllllllllIIIIIIIlIIIlIlIIIIl, lllllllllllllIIIIIIIlIIIlIlIIIII, this.field_191804_g);
    }
    
    public GuiAdvancementTab(final Minecraft lllllllllllllIIIIIIIlIIIlIlllllI, final GuiScreenAdvancements lllllllllllllIIIIIIIlIIIlIllllIl, final AdvancementTabType lllllllllllllIIIIIIIlIIIlIllllII, final int lllllllllllllIIIIIIIlIIIlIlllIll, final Advancement lllllllllllllIIIIIIIlIIIlIlllIlI, final DisplayInfo lllllllllllllIIIIIIIlIIIlIlllIIl) {
        this.field_191810_m = (Map<Advancement, GuiAdvancement>)Maps.newLinkedHashMap();
        this.field_193939_q = Integer.MAX_VALUE;
        this.field_193940_r = Integer.MAX_VALUE;
        this.field_191813_p = Integer.MIN_VALUE;
        this.field_191814_q = Integer.MIN_VALUE;
        this.field_191802_a = lllllllllllllIIIIIIIlIIIlIlllllI;
        this.field_193938_f = lllllllllllllIIIIIIIlIIIlIllllIl;
        this.field_191803_f = lllllllllllllIIIIIIIlIIIlIllllII;
        this.field_191804_g = lllllllllllllIIIIIIIlIIIlIlllIll;
        this.field_191805_h = lllllllllllllIIIIIIIlIIIlIlllIlI;
        this.field_191806_i = lllllllllllllIIIIIIIlIIIlIlllIIl;
        this.field_191807_j = lllllllllllllIIIIIIIlIIIlIlllIIl.func_192298_b();
        this.field_191808_k = lllllllllllllIIIIIIIlIIIlIlllIIl.func_192297_a().getFormattedText();
        this.field_191809_l = new GuiAdvancement(this, lllllllllllllIIIIIIIlIIIlIlllllI, lllllllllllllIIIIIIIlIIIlIlllIlI, lllllllllllllIIIIIIIlIIIlIlllIIl);
        this.func_193937_a(this.field_191809_l, lllllllllllllIIIIIIIlIIIlIlllIlI);
    }
    
    public GuiScreenAdvancements func_193934_g() {
        return this.field_193938_f;
    }
    
    public void func_191799_a() {
        if (!this.field_192992_s) {
            this.field_191811_n = 117 - (this.field_191813_p + this.field_193939_q) / 2;
            this.field_191812_o = 56 - (this.field_191814_q + this.field_193940_r) / 2;
            this.field_192992_s = true;
        }
        GlStateManager.depthFunc(518);
        Gui.drawRect(0.0, 0.0, 234.0, 113.0, -16777216);
        GlStateManager.depthFunc(515);
        final ResourceLocation lllllllllllllIIIIIIIlIIIlIIIllII = this.field_191806_i.func_192293_c();
        if (lllllllllllllIIIIIIIlIIIlIIIllII != null) {
            this.field_191802_a.getTextureManager().bindTexture(lllllllllllllIIIIIIIlIIIlIIIllII);
        }
        else {
            this.field_191802_a.getTextureManager().bindTexture(TextureManager.field_194008_a);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllllIIIIIIIlIIIlIIIlIll = this.field_191811_n % 16;
        final int lllllllllllllIIIIIIIlIIIlIIIlIlI = this.field_191812_o % 16;
        for (int lllllllllllllIIIIIIIlIIIlIIIlIIl = -1; lllllllllllllIIIIIIIlIIIlIIIlIIl <= 15; ++lllllllllllllIIIIIIIlIIIlIIIlIIl) {
            for (int lllllllllllllIIIIIIIlIIIlIIIlIII = -1; lllllllllllllIIIIIIIlIIIlIIIlIII <= 8; ++lllllllllllllIIIIIIIlIIIlIIIlIII) {
                Gui.drawModalRectWithCustomSizedTexture((float)(lllllllllllllIIIIIIIlIIIlIIIlIll + 16 * lllllllllllllIIIIIIIlIIIlIIIlIIl), (float)(lllllllllllllIIIIIIIlIIIlIIIlIlI + 16 * lllllllllllllIIIIIIIlIIIlIIIlIII), 0.0f, 0.0f, 16.0f, 16.0f, 16.0f, 16.0f);
            }
        }
        this.field_191809_l.func_191819_a(this.field_191811_n, this.field_191812_o, true);
        this.field_191809_l.func_191819_a(this.field_191811_n, this.field_191812_o, false);
        this.field_191809_l.func_191817_b(this.field_191811_n, this.field_191812_o);
    }
    
    public void func_191796_a(final int lllllllllllllIIIIIIIlIIIlIIlIllI, final int lllllllllllllIIIIIIIlIIIlIIlIlIl, final RenderItem lllllllllllllIIIIIIIlIIIlIIlIlII) {
        this.field_191803_f.func_192652_a(lllllllllllllIIIIIIIlIIIlIIlIllI, lllllllllllllIIIIIIIlIIIlIIlIlIl, this.field_191804_g, lllllllllllllIIIIIIIlIIIlIIlIlII, this.field_191807_j);
    }
    
    @Nullable
    public static GuiAdvancementTab func_193936_a(final Minecraft lllllllllllllIIIIIIIlIIIIlIIlllI, final GuiScreenAdvancements lllllllllllllIIIIIIIlIIIIlIIllIl, int lllllllllllllIIIIIIIlIIIIlIIllII, final Advancement lllllllllllllIIIIIIIlIIIIlIIlIll) {
        if (lllllllllllllIIIIIIIlIIIIlIIlIll.func_192068_c() == null) {
            return null;
        }
        final double lllllllllllllIIIIIIIlIIIIlIIIlll;
        final byte lllllllllllllIIIIIIIlIIIIlIIlIII = (byte)((AdvancementTabType[])(Object)(lllllllllllllIIIIIIIlIIIIlIIIlll = (double)(Object)AdvancementTabType.values())).length;
        for (short lllllllllllllIIIIIIIlIIIIlIIlIIl = 0; lllllllllllllIIIIIIIlIIIIlIIlIIl < lllllllllllllIIIIIIIlIIIIlIIlIII; ++lllllllllllllIIIIIIIlIIIIlIIlIIl) {
            final AdvancementTabType lllllllllllllIIIIIIIlIIIIlIIllll = lllllllllllllIIIIIIIlIIIIlIIIlll[lllllllllllllIIIIIIIlIIIIlIIlIIl];
            if (lllllllllllllIIIIIIIlIIIIlIIllII < lllllllllllllIIIIIIIlIIIIlIIllll.func_192650_a()) {
                return new GuiAdvancementTab(lllllllllllllIIIIIIIlIIIIlIIlllI, lllllllllllllIIIIIIIlIIIIlIIllIl, lllllllllllllIIIIIIIlIIIIlIIllll, lllllllllllllIIIIIIIlIIIIlIIllII, lllllllllllllIIIIIIIlIIIIlIIlIll, lllllllllllllIIIIIIIlIIIIlIIlIll.func_192068_c());
            }
            lllllllllllllIIIIIIIlIIIIlIIllII -= lllllllllllllIIIIIIIlIIIIlIIllll.func_192650_a();
        }
        return null;
    }
    
    public void func_191800_a(final Advancement lllllllllllllIIIIIIIlIIIIIllIllI) {
        if (lllllllllllllIIIIIIIlIIIIIllIllI.func_192068_c() != null) {
            final GuiAdvancement lllllllllllllIIIIIIIlIIIIIlllIII = new GuiAdvancement(this, this.field_191802_a, lllllllllllllIIIIIIIlIIIIIllIllI, lllllllllllllIIIIIIIlIIIIIllIllI.func_192068_c());
            this.func_193937_a(lllllllllllllIIIIIIIlIIIIIlllIII, lllllllllllllIIIIIIIlIIIIIllIllI);
        }
    }
    
    public boolean func_191793_c(final int lllllllllllllIIIIIIIlIIIIllIIlII, final int lllllllllllllIIIIIIIlIIIIlIllllI, final int lllllllllllllIIIIIIIlIIIIllIIIlI, final int lllllllllllllIIIIIIIlIIIIlIlllII) {
        return this.field_191803_f.func_192654_a(lllllllllllllIIIIIIIlIIIIllIIlII, lllllllllllllIIIIIIIlIIIIlIllllI, this.field_191804_g, lllllllllllllIIIIIIIlIIIIllIIIlI, lllllllllllllIIIIIIIlIIIIlIlllII);
    }
}
