// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.advancements;

import java.util.regex.Matcher;
import java.util.Collections;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import java.util.regex.Pattern;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.AdvancementProgress;
import java.util.List;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.gui.Gui;

public class GuiAdvancement extends Gui
{
    private final /* synthetic */ Advancement field_191829_g;
    private final /* synthetic */ List<GuiAdvancement> field_191835_m;
    private /* synthetic */ AdvancementProgress field_191836_n;
    private final /* synthetic */ GuiAdvancementTab field_191828_f;
    private final /* synthetic */ String field_191831_i;
    private final /* synthetic */ int field_191826_p;
    private final /* synthetic */ DisplayInfo field_191830_h;
    private final /* synthetic */ List<String> field_192997_l;
    private final /* synthetic */ Minecraft field_191833_k;
    private static final /* synthetic */ ResourceLocation field_191827_a;
    private /* synthetic */ GuiAdvancement field_191834_l;
    private final /* synthetic */ int field_191832_j;
    private final /* synthetic */ int field_191837_o;
    private static final /* synthetic */ Pattern field_192996_f;
    
    public void func_191824_a(final AdvancementProgress llllllllllllllIIIllIIIllIlIIlIll) {
        this.field_191836_n = llllllllllllllIIIllIIIllIlIIlIll;
    }
    
    public int func_191820_c() {
        return this.field_191826_p;
    }
    
    public void func_191821_a(final int llllllllllllllIIIllIIIllIIIlIIlI, final int llllllllllllllIIIllIIIllIIllIIII, final float llllllllllllllIIIllIIIllIIlIllll, final int llllllllllllllIIIllIIIllIIIlIIII, final int llllllllllllllIIIllIIIllIIlIllIl) {
        final boolean llllllllllllllIIIllIIIllIIlIllII = llllllllllllllIIIllIIIllIIIlIIII + llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o + this.field_191832_j + 26 >= this.field_191828_f.func_193934_g().width;
        final String llllllllllllllIIIllIIIllIIlIlIll = (this.field_191836_n == null) ? null : this.field_191836_n.func_193126_d();
        final int llllllllllllllIIIllIIIllIIlIlIlI = (llllllllllllllIIIllIIIllIIlIlIll == null) ? 0 : Minecraft.fontRendererObj.getStringWidth(llllllllllllllIIIllIIIllIIlIlIll);
        final boolean llllllllllllllIIIllIIIllIIlIlIIl = 113 - llllllllllllllIIIllIIIllIIllIIII - this.field_191826_p - 26 <= 6 + this.field_192997_l.size() * Minecraft.fontRendererObj.FONT_HEIGHT;
        final float llllllllllllllIIIllIIIllIIlIlIII = (this.field_191836_n == null) ? 0.0f : this.field_191836_n.func_192103_c();
        int llllllllllllllIIIllIIIllIIlIIlll = MathHelper.floor(llllllllllllllIIIllIIIllIIlIlIII * this.field_191832_j);
        AdvancementState llllllllllllllIIIllIIIllIIlIIIll = null;
        AdvancementState llllllllllllllIIIllIIIllIIIlllll = null;
        AdvancementState llllllllllllllIIIllIIIllIIIllIll = null;
        if (llllllllllllllIIIllIIIllIIlIlIII >= 1.0f) {
            llllllllllllllIIIllIIIllIIlIIlll = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIllI = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIIlI = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIIllllI = AdvancementState.OBTAINED;
        }
        else if (llllllllllllllIIIllIIIllIIlIIlll < 2) {
            llllllllllllllIIIllIIIllIIlIIlll = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIlIl = AdvancementState.UNOBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIIIl = AdvancementState.UNOBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIIlllIl = AdvancementState.UNOBTAINED;
        }
        else if (llllllllllllllIIIllIIIllIIlIIlll > this.field_191832_j - 2) {
            llllllllllllllIIIllIIIllIIlIIlll = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIlII = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIlIIIII = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIllIIIllIIIlllII = AdvancementState.UNOBTAINED;
        }
        else {
            llllllllllllllIIIllIIIllIIlIIIll = AdvancementState.OBTAINED;
            llllllllllllllIIIllIIIllIIIlllll = AdvancementState.UNOBTAINED;
            llllllllllllllIIIllIIIllIIIllIll = AdvancementState.UNOBTAINED;
        }
        final int llllllllllllllIIIllIIIllIIIllIlI = this.field_191832_j - llllllllllllllIIIllIIIllIIlIIlll;
        this.field_191833_k.getTextureManager().bindTexture(GuiAdvancement.field_191827_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        final int llllllllllllllIIIllIIIllIIIllIIl = llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p;
        int llllllllllllllIIIllIIIllIIIlIlll = 0;
        if (llllllllllllllIIIllIIIllIIlIllII) {
            final int llllllllllllllIIIllIIIllIIIllIII = llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o - this.field_191832_j + 26 + 6;
        }
        else {
            llllllllllllllIIIllIIIllIIIlIlll = llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o;
        }
        final int llllllllllllllIIIllIIIllIIIlIllI = 32 + this.field_192997_l.size() * Minecraft.fontRendererObj.FONT_HEIGHT;
        if (!this.field_192997_l.isEmpty()) {
            if (llllllllllllllIIIllIIIllIIlIlIIl) {
                this.func_192994_a(llllllllllllllIIIllIIIllIIIlIlll, llllllllllllllIIIllIIIllIIIllIIl + 26 - llllllllllllllIIIllIIIllIIIlIllI, this.field_191832_j, llllllllllllllIIIllIIIllIIIlIllI, 10, 200, 26, 0, 52);
            }
            else {
                this.func_192994_a(llllllllllllllIIIllIIIllIIIlIlll, llllllllllllllIIIllIIIllIIIllIIl, this.field_191832_j, llllllllllllllIIIllIIIllIIIlIllI, 10, 200, 26, 0, 52);
            }
        }
        this.drawTexturedModalRect(llllllllllllllIIIllIIIllIIIlIlll, llllllllllllllIIIllIIIllIIIllIIl, 0, llllllllllllllIIIllIIIllIIlIIIll.func_192667_a() * 26, llllllllllllllIIIllIIIllIIlIIlll, 26);
        this.drawTexturedModalRect(llllllllllllllIIIllIIIllIIIlIlll + llllllllllllllIIIllIIIllIIlIIlll, llllllllllllllIIIllIIIllIIIllIIl, 200 - llllllllllllllIIIllIIIllIIIllIlI, llllllllllllllIIIllIIIllIIIlllll.func_192667_a() * 26, llllllllllllllIIIllIIIllIIIllIlI, 26);
        this.drawTexturedModalRect(llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o + 3, llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p, this.field_191830_h.func_192291_d().func_192309_b(), 128 + llllllllllllllIIIllIIIllIIIllIll.func_192667_a() * 26, 26, 26);
        if (llllllllllllllIIIllIIIllIIlIllII) {
            Minecraft.fontRendererObj.drawString(this.field_191831_i, (float)(llllllllllllllIIIllIIIllIIIlIlll + 5), (float)(llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 9), -1, true);
            if (llllllllllllllIIIllIIIllIIlIlIll != null) {
                Minecraft.fontRendererObj.drawString(llllllllllllllIIIllIIIllIIlIlIll, (float)(llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o - llllllllllllllIIIllIIIllIIlIlIlI), (float)(llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 9), -1, true);
            }
        }
        else {
            Minecraft.fontRendererObj.drawString(this.field_191831_i, (float)(llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o + 32), (float)(llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 9), -1, true);
            if (llllllllllllllIIIllIIIllIIlIlIll != null) {
                Minecraft.fontRendererObj.drawString(llllllllllllllIIIllIIIllIIlIlIll, (float)(llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o + this.field_191832_j - llllllllllllllIIIllIIIllIIlIlIlI - 5), (float)(llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 9), -1, true);
            }
        }
        if (llllllllllllllIIIllIIIllIIlIlIIl) {
            for (int llllllllllllllIIIllIIIllIIIlIlIl = 0; llllllllllllllIIIllIIIllIIIlIlIl < this.field_192997_l.size(); ++llllllllllllllIIIllIIIllIIIlIlIl) {
                Minecraft.fontRendererObj.drawString(this.field_192997_l.get(llllllllllllllIIIllIIIllIIIlIlIl), (float)(llllllllllllllIIIllIIIllIIIlIlll + 5), (float)(llllllllllllllIIIllIIIllIIIllIIl + 26 - llllllllllllllIIIllIIIllIIIlIllI + 7 + llllllllllllllIIIllIIIllIIIlIlIl * Minecraft.fontRendererObj.FONT_HEIGHT), -5592406, false);
            }
        }
        else {
            for (int llllllllllllllIIIllIIIllIIIlIlII = 0; llllllllllllllIIIllIIIllIIIlIlII < this.field_192997_l.size(); ++llllllllllllllIIIllIIIllIIIlIlII) {
                Minecraft.fontRendererObj.drawString(this.field_192997_l.get(llllllllllllllIIIllIIIllIIIlIlII), (float)(llllllllllllllIIIllIIIllIIIlIlll + 5), (float)(llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 9 + 17 + llllllllllllllIIIllIIIllIIIlIlII * Minecraft.fontRendererObj.FONT_HEIGHT), -5592406, false);
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.field_191833_k.getRenderItem().renderItemAndEffectIntoGUI(null, this.field_191830_h.func_192298_b(), llllllllllllllIIIllIIIllIIIlIIlI + this.field_191837_o + 8, llllllllllllllIIIllIIIllIIllIIII + this.field_191826_p + 5);
    }
    
    public void func_191817_b(final int llllllllllllllIIIllIIIllIlIlIlII, final int llllllllllllllIIIllIIIllIlIllIlI) {
        if (!this.field_191830_h.func_193224_j() || (this.field_191836_n != null && this.field_191836_n.func_192105_a())) {
            final float llllllllllllllIIIllIIIllIlIllIIl = (this.field_191836_n == null) ? 0.0f : this.field_191836_n.func_192103_c();
            AdvancementState llllllllllllllIIIllIIIllIlIlIlll = null;
            if (llllllllllllllIIIllIIIllIlIllIIl >= 1.0f) {
                final AdvancementState llllllllllllllIIIllIIIllIlIllIII = AdvancementState.OBTAINED;
            }
            else {
                llllllllllllllIIIllIIIllIlIlIlll = AdvancementState.UNOBTAINED;
            }
            this.field_191833_k.getTextureManager().bindTexture(GuiAdvancement.field_191827_a);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableBlend();
            this.drawTexturedModalRect(llllllllllllllIIIllIIIllIlIlIlII + this.field_191837_o + 3, llllllllllllllIIIllIIIllIlIllIlI + this.field_191826_p, this.field_191830_h.func_192291_d().func_192309_b(), 128 + llllllllllllllIIIllIIIllIlIlIlll.func_192667_a() * 26, 26, 26);
            RenderHelper.enableGUIStandardItemLighting();
            this.field_191833_k.getRenderItem().renderItemAndEffectIntoGUI(null, this.field_191830_h.func_192298_b(), llllllllllllllIIIllIIIllIlIlIlII + this.field_191837_o + 8, llllllllllllllIIIllIIIllIlIllIlI + this.field_191826_p + 5);
        }
        for (final GuiAdvancement llllllllllllllIIIllIIIllIlIlIllI : this.field_191835_m) {
            llllllllllllllIIIllIIIllIlIlIllI.func_191817_b(llllllllllllllIIIllIIIllIlIlIlII, llllllllllllllIIIllIIIllIlIllIlI);
        }
    }
    
    @Nullable
    private GuiAdvancement func_191818_a(Advancement llllllllllllllIIIllIIIlllIIIIIIl) {
        do {
            llllllllllllllIIIllIIIlllIIIIIIl = ((Advancement)llllllllllllllIIIllIIIlllIIIIIIl).func_192070_b();
        } while (llllllllllllllIIIllIIIlllIIIIIIl != null && ((Advancement)llllllllllllllIIIllIIIlllIIIIIIl).func_192068_c() == null);
        if (llllllllllllllIIIllIIIlllIIIIIIl != null && ((Advancement)llllllllllllllIIIllIIIlllIIIIIIl).func_192068_c() != null) {
            return this.field_191828_f.func_191794_b((Advancement)llllllllllllllIIIllIIIlllIIIIIIl);
        }
        return null;
    }
    
    public void func_191825_b() {
        if (this.field_191834_l == null && this.field_191829_g.func_192070_b() != null) {
            this.field_191834_l = this.func_191818_a(this.field_191829_g);
            if (this.field_191834_l != null) {
                this.field_191834_l.func_191822_a(this);
            }
        }
    }
    
    public boolean func_191816_c(final int llllllllllllllIIIllIIIlIlIlIIIll, final int llllllllllllllIIIllIIIlIlIlIIIlI, final int llllllllllllllIIIllIIIlIlIlIIIIl, final int llllllllllllllIIIllIIIlIlIlIIIII) {
        if (!this.field_191830_h.func_193224_j() || (this.field_191836_n != null && this.field_191836_n.func_192105_a())) {
            final int llllllllllllllIIIllIIIlIlIlIlIII = llllllllllllllIIIllIIIlIlIlIIIll + this.field_191837_o;
            final int llllllllllllllIIIllIIIlIlIlIIlll = llllllllllllllIIIllIIIlIlIlIlIII + 26;
            final int llllllllllllllIIIllIIIlIlIlIIllI = llllllllllllllIIIllIIIlIlIlIIIlI + this.field_191826_p;
            final int llllllllllllllIIIllIIIlIlIlIIlIl = llllllllllllllIIIllIIIlIlIlIIllI + 26;
            return llllllllllllllIIIllIIIlIlIlIIIIl >= llllllllllllllIIIllIIIlIlIlIlIII && llllllllllllllIIIllIIIlIlIlIIIIl <= llllllllllllllIIIllIIIlIlIlIIlll && llllllllllllllIIIllIIIlIlIlIIIII >= llllllllllllllIIIllIIIlIlIlIIllI && llllllllllllllIIIllIIIlIlIlIIIII <= llllllllllllllIIIllIIIlIlIlIIlIl;
        }
        return false;
    }
    
    protected void func_192994_a(final int llllllllllllllIIIllIIIlIlllIllII, final int llllllllllllllIIIllIIIlIlllIlIll, final int llllllllllllllIIIllIIIlIllllIlII, final int llllllllllllllIIIllIIIlIlllIlIIl, final int llllllllllllllIIIllIIIlIllllIIlI, final int llllllllllllllIIIllIIIlIllllIIIl, final int llllllllllllllIIIllIIIlIlllIIllI, final int llllllllllllllIIIllIIIlIlllIIlIl, final int llllllllllllllIIIllIIIlIlllIlllI) {
        this.drawTexturedModalRect(llllllllllllllIIIllIIIlIlllIllII, llllllllllllllIIIllIIIlIlllIlIll, llllllllllllllIIIllIIIlIlllIIlIl, llllllllllllllIIIllIIIlIlllIlllI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI);
        this.func_192993_a(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll, llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI, llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIllI);
        this.drawTexturedModalRect(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI);
        this.drawTexturedModalRect(llllllllllllllIIIllIIIlIlllIllII, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI);
        this.func_192993_a(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIllI);
        this.drawTexturedModalRect(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI);
        this.func_192993_a(llllllllllllllIIIllIIIlIlllIllII, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIIl, llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI);
        this.func_192993_a(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI);
        this.func_192993_a(llllllllllllllIIIllIIIlIlllIllII + llllllllllllllIIIllIIIlIllllIlII - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIll + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlIIl - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIIlIl + llllllllllllllIIIllIIIlIllllIIIl - llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIlllIlllI + llllllllllllllIIIllIIIlIllllIIlI, llllllllllllllIIIllIIIlIllllIIIl, llllllllllllllIIIllIIIlIlllIIllI - llllllllllllllIIIllIIIlIllllIIlI - llllllllllllllIIIllIIIlIllllIIlI);
    }
    
    public void func_191822_a(final GuiAdvancement llllllllllllllIIIllIIIllIlIIIlIl) {
        this.field_191835_m.add(llllllllllllllIIIllIIIllIlIIIlIl);
    }
    
    protected void func_192993_a(final int llllllllllllllIIIllIIIlIllIlIIll, final int llllllllllllllIIIllIIIlIllIlIIlI, final int llllllllllllllIIIllIIIlIllIlIIIl, final int llllllllllllllIIIllIIIlIllIIIIIl, final int llllllllllllllIIIllIIIlIllIIIIII, final int llllllllllllllIIIllIIIlIlIllllll, final int llllllllllllllIIIllIIIlIlIlllllI, final int llllllllllllllIIIllIIIlIllIIllII) {
        for (int llllllllllllllIIIllIIIlIllIIlIll = 0; llllllllllllllIIIllIIIlIllIIlIll < llllllllllllllIIIllIIIlIllIlIIIl; llllllllllllllIIIllIIIlIllIIlIll += llllllllllllllIIIllIIIlIlIlllllI) {
            final int llllllllllllllIIIllIIIlIllIIlIlI = llllllllllllllIIIllIIIlIllIlIIll + llllllllllllllIIIllIIIlIllIIlIll;
            final int llllllllllllllIIIllIIIlIllIIlIIl = Math.min(llllllllllllllIIIllIIIlIlIlllllI, llllllllllllllIIIllIIIlIllIlIIIl - llllllllllllllIIIllIIIlIllIIlIll);
            for (int llllllllllllllIIIllIIIlIllIIlIII = 0; llllllllllllllIIIllIIIlIllIIlIII < llllllllllllllIIIllIIIlIllIIIIIl; llllllllllllllIIIllIIIlIllIIlIII += llllllllllllllIIIllIIIlIllIIllII) {
                final int llllllllllllllIIIllIIIlIllIIIlll = llllllllllllllIIIllIIIlIllIlIIlI + llllllllllllllIIIllIIIlIllIIlIII;
                final int llllllllllllllIIIllIIIlIllIIIllI = Math.min(llllllllllllllIIIllIIIlIllIIllII, llllllllllllllIIIllIIIlIllIIIIIl - llllllllllllllIIIllIIIlIllIIlIII);
                this.drawTexturedModalRect(llllllllllllllIIIllIIIlIllIIlIlI, llllllllllllllIIIllIIIlIllIIIlll, llllllllllllllIIIllIIIlIllIIIIII, llllllllllllllIIIllIIIlIlIllllll, llllllllllllllIIIllIIIlIllIIlIIl, llllllllllllllIIIllIIIlIllIIIllI);
            }
        }
    }
    
    static {
        field_191827_a = new ResourceLocation("textures/gui/advancements/widgets.png");
        field_192996_f = Pattern.compile("(.+) \\S+");
    }
    
    public GuiAdvancement(final GuiAdvancementTab llllllllllllllIIIllIIIlllIlIlIlI, final Minecraft llllllllllllllIIIllIIIlllIllIlII, final Advancement llllllllllllllIIIllIIIlllIllIIll, final DisplayInfo llllllllllllllIIIllIIIlllIlIIlll) {
        this.field_191835_m = (List<GuiAdvancement>)Lists.newArrayList();
        this.field_191828_f = llllllllllllllIIIllIIIlllIlIlIlI;
        this.field_191829_g = llllllllllllllIIIllIIIlllIllIIll;
        this.field_191830_h = llllllllllllllIIIllIIIlllIlIIlll;
        this.field_191833_k = llllllllllllllIIIllIIIlllIllIlII;
        this.field_191831_i = Minecraft.fontRendererObj.trimStringToWidth(llllllllllllllIIIllIIIlllIlIIlll.func_192297_a().getFormattedText(), 163);
        this.field_191837_o = MathHelper.floor(llllllllllllllIIIllIIIlllIlIIlll.func_192299_e() * 28.0f);
        this.field_191826_p = MathHelper.floor(llllllllllllllIIIllIIIlllIlIIlll.func_192296_f() * 27.0f);
        final int llllllllllllllIIIllIIIlllIllIIIl = llllllllllllllIIIllIIIlllIllIIll.func_193124_g();
        final int llllllllllllllIIIllIIIlllIllIIII = String.valueOf(llllllllllllllIIIllIIIlllIllIIIl).length();
        final int llllllllllllllIIIllIIIlllIlIllll = (llllllllllllllIIIllIIIlllIllIIIl > 1) ? (Minecraft.fontRendererObj.getStringWidth("  ") + Minecraft.fontRendererObj.getStringWidth("0") * llllllllllllllIIIllIIIlllIllIIII * 2 + Minecraft.fontRendererObj.getStringWidth("/")) : 0;
        int llllllllllllllIIIllIIIlllIlIlllI = 29 + Minecraft.fontRendererObj.getStringWidth(this.field_191831_i) + llllllllllllllIIIllIIIlllIlIllll;
        final String llllllllllllllIIIllIIIlllIlIllIl = llllllllllllllIIIllIIIlllIlIIlll.func_193222_b().getFormattedText();
        this.field_192997_l = this.func_192995_a(llllllllllllllIIIllIIIlllIlIllIl, llllllllllllllIIIllIIIlllIlIlllI);
        for (final String llllllllllllllIIIllIIIlllIlIllII : this.field_192997_l) {
            llllllllllllllIIIllIIIlllIlIlllI = Math.max(llllllllllllllIIIllIIIlllIlIlllI, Minecraft.fontRendererObj.getStringWidth(llllllllllllllIIIllIIIlllIlIllII));
        }
        this.field_191832_j = llllllllllllllIIIllIIIlllIlIlllI + 3 + 5;
    }
    
    public void func_191819_a(final int llllllllllllllIIIllIIIllIllIlIlI, final int llllllllllllllIIIllIIIllIlllIlII, final boolean llllllllllllllIIIllIIIllIllIlIII) {
        if (this.field_191834_l != null) {
            final int llllllllllllllIIIllIIIllIlllIIlI = llllllllllllllIIIllIIIllIllIlIlI + this.field_191834_l.field_191837_o + 13;
            final int llllllllllllllIIIllIIIllIlllIIIl = llllllllllllllIIIllIIIllIllIlIlI + this.field_191834_l.field_191837_o + 26 + 4;
            final int llllllllllllllIIIllIIIllIlllIIII = llllllllllllllIIIllIIIllIlllIlII + this.field_191834_l.field_191826_p + 13;
            final int llllllllllllllIIIllIIIllIllIllll = llllllllllllllIIIllIIIllIllIlIlI + this.field_191837_o + 13;
            final int llllllllllllllIIIllIIIllIllIlllI = llllllllllllllIIIllIIIllIlllIlII + this.field_191826_p + 13;
            final int llllllllllllllIIIllIIIllIllIllIl = llllllllllllllIIIllIIIllIllIlIII ? -16777216 : -1;
            if (llllllllllllllIIIllIIIllIllIlIII) {
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIlllIIIl, llllllllllllllIIIllIIIllIlllIIlI, llllllllllllllIIIllIIIllIlllIIII - 1, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIlllIIIl + 1, llllllllllllllIIIllIIIllIlllIIlI, llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIlllIIIl, llllllllllllllIIIllIIIllIlllIIlI, llllllllllllllIIIllIIIllIlllIIII + 1, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIllIllll, llllllllllllllIIIllIIIllIlllIIIl - 1, llllllllllllllIIIllIIIllIllIlllI - 1, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIllIllll, llllllllllllllIIIllIIIllIlllIIIl - 1, llllllllllllllIIIllIIIllIllIlllI, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIllIllll, llllllllllllllIIIllIIIllIlllIIIl - 1, llllllllllllllIIIllIIIllIllIlllI + 1, llllllllllllllIIIllIIIllIllIllIl);
                this.drawVerticalLine(llllllllllllllIIIllIIIllIlllIIIl - 1, llllllllllllllIIIllIIIllIllIlllI, llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllIl);
                this.drawVerticalLine(llllllllllllllIIIllIIIllIlllIIIl + 1, llllllllllllllIIIllIIIllIllIlllI, llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllIl);
            }
            else {
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIlllIIIl, llllllllllllllIIIllIIIllIlllIIlI, llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllIl);
                this.drawHorizontalLine(llllllllllllllIIIllIIIllIllIllll, llllllllllllllIIIllIIIllIlllIIIl, llllllllllllllIIIllIIIllIllIlllI, llllllllllllllIIIllIIIllIllIllIl);
                this.drawVerticalLine(llllllllllllllIIIllIIIllIlllIIIl, llllllllllllllIIIllIIIllIllIlllI, llllllllllllllIIIllIIIllIlllIIII, llllllllllllllIIIllIIIllIllIllIl);
            }
        }
        for (final GuiAdvancement llllllllllllllIIIllIIIllIllIllII : this.field_191835_m) {
            llllllllllllllIIIllIIIllIllIllII.func_191819_a(llllllllllllllIIIllIIIllIllIlIlI, llllllllllllllIIIllIIIllIlllIlII, llllllllllllllIIIllIIIllIllIlIII);
        }
    }
    
    private List<String> func_192995_a(final String llllllllllllllIIIllIIIlllIIlIllI, final int llllllllllllllIIIllIIIlllIIIllIl) {
        if (llllllllllllllIIIllIIIlllIIlIllI.isEmpty()) {
            return Collections.emptyList();
        }
        final List<String> llllllllllllllIIIllIIIlllIIlIlII = Minecraft.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIllIIIlllIIlIllI, llllllllllllllIIIllIIIlllIIIllIl);
        if (llllllllllllllIIIllIIIlllIIlIlII.size() < 2) {
            return llllllllllllllIIIllIIIlllIIlIlII;
        }
        final String llllllllllllllIIIllIIIlllIIlIIll = llllllllllllllIIIllIIIlllIIlIlII.get(0);
        final String llllllllllllllIIIllIIIlllIIlIIlI = llllllllllllllIIIllIIIlllIIlIlII.get(1);
        final int llllllllllllllIIIllIIIlllIIlIIIl = Minecraft.fontRendererObj.getStringWidth(String.valueOf(llllllllllllllIIIllIIIlllIIlIIll) + ' ' + llllllllllllllIIIllIIIlllIIlIIlI.split(" ")[0]);
        if (llllllllllllllIIIllIIIlllIIlIIIl - llllllllllllllIIIllIIIlllIIIllIl <= 10) {
            return Minecraft.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIllIIIlllIIlIllI, llllllllllllllIIIllIIIlllIIlIIIl);
        }
        final Matcher llllllllllllllIIIllIIIlllIIlIIII = GuiAdvancement.field_192996_f.matcher(llllllllllllllIIIllIIIlllIIlIIll);
        if (llllllllllllllIIIllIIIlllIIlIIII.matches()) {
            final int llllllllllllllIIIllIIIlllIIIllll = Minecraft.fontRendererObj.getStringWidth(llllllllllllllIIIllIIIlllIIlIIII.group(1));
            if (llllllllllllllIIIllIIIlllIIIllIl - llllllllllllllIIIllIIIlllIIIllll <= 10) {
                return Minecraft.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIllIIIlllIIlIllI, llllllllllllllIIIllIIIlllIIIllll);
            }
        }
        return llllllllllllllIIIllIIIlllIIlIlII;
    }
    
    public int func_191823_d() {
        return this.field_191837_o;
    }
}
