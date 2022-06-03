// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import java.util.Iterator;
import net.minecraft.client.renderer.RenderHelper;
import javax.annotation.Nullable;
import com.google.common.collect.Lists;
import net.minecraft.stats.RecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;
import net.minecraft.client.gui.GuiButtonToggle;

public class RecipeBookPage
{
    private /* synthetic */ GuiButtonToggle field_193741_f;
    private /* synthetic */ List<RecipeList> field_194203_f;
    private /* synthetic */ IRecipe field_194205_l;
    private /* synthetic */ List<GuiButtonRecipe> field_193743_h;
    private /* synthetic */ int field_193738_c;
    private /* synthetic */ Minecraft field_193754_s;
    private /* synthetic */ RecipeList field_194206_m;
    private /* synthetic */ GuiButtonRecipe field_194201_b;
    private /* synthetic */ GuiButtonToggle field_193740_e;
    private /* synthetic */ int field_193737_b;
    private /* synthetic */ List<IRecipeUpdateListener> field_193757_v;
    private /* synthetic */ GuiRecipeOverlay field_194202_c;
    private /* synthetic */ RecipeBook field_194204_k;
    
    private void func_194198_d() {
        final int lllllllllllIIllllllllIIIIlIlIlIl = 20 * this.field_193738_c;
        for (int lllllllllllIIllllllllIIIIlIlIlII = 0; lllllllllllIIllllllllIIIIlIlIlII < this.field_193743_h.size(); ++lllllllllllIIllllllllIIIIlIlIlII) {
            final GuiButtonRecipe lllllllllllIIllllllllIIIIlIlIIll = this.field_193743_h.get(lllllllllllIIllllllllIIIIlIlIlII);
            if (lllllllllllIIllllllllIIIIlIlIlIl + lllllllllllIIllllllllIIIIlIlIlII < this.field_194203_f.size()) {
                final RecipeList lllllllllllIIllllllllIIIIlIlIIlI = this.field_194203_f.get(lllllllllllIIllllllllIIIIlIlIlIl + lllllllllllIIllllllllIIIIlIlIlII);
                lllllllllllIIllllllllIIIIlIlIIll.func_193928_a(lllllllllllIIllllllllIIIIlIlIIlI, this, this.field_194204_k);
                lllllllllllIIllllllllIIIIlIlIIll.visible = true;
            }
            else {
                lllllllllllIIllllllllIIIIlIlIIll.visible = false;
            }
        }
        this.func_194197_e();
    }
    
    public void func_194192_a(final List<RecipeList> lllllllllllIIllllllllIIIIllIIIII, final boolean lllllllllllIIllllllllIIIIlIlllll) {
        this.field_194203_f = lllllllllllIIllllllllIIIIllIIIII;
        this.field_193737_b = (int)Math.ceil(lllllllllllIIllllllllIIIIllIIIII.size() / 20.0);
        if (this.field_193737_b <= this.field_193738_c || lllllllllllIIllllllllIIIIlIlllll) {
            this.field_193738_c = 0;
        }
        this.func_194198_d();
    }
    
    public void func_193721_a(final int lllllllllllIIllllllllIIIIIlIlIIl, final int lllllllllllIIllllllllIIIIIlIlIll) {
        if (this.field_193754_s.currentScreen != null && this.field_194201_b != null && !this.field_194202_c.func_191839_a()) {
            this.field_193754_s.currentScreen.drawHoveringText(this.field_194201_b.func_191772_a(this.field_193754_s.currentScreen), lllllllllllIIllllllllIIIIIlIlIIl, lllllllllllIIllllllllIIIIIlIlIll);
        }
    }
    
    public RecipeBookPage() {
        this.field_193743_h = (List<GuiButtonRecipe>)Lists.newArrayListWithCapacity(20);
        this.field_194202_c = new GuiRecipeOverlay();
        this.field_193757_v = (List<IRecipeUpdateListener>)Lists.newArrayList();
        for (int lllllllllllIIllllllllIIIIlllllII = 0; lllllllllllIIllllllllIIIIlllllII < 20; ++lllllllllllIIllllllllIIIIlllllII) {
            this.field_193743_h.add(new GuiButtonRecipe());
        }
    }
    
    @Nullable
    public IRecipe func_194193_a() {
        return this.field_194205_l;
    }
    
    @Nullable
    public RecipeList func_194199_b() {
        return this.field_194206_m;
    }
    
    public void func_194195_a(final List<IRecipe> lllllllllllIIlllllllIllllllllIIl) {
        for (final IRecipeUpdateListener lllllllllllIIlllllllIllllllllIll : this.field_193757_v) {
            lllllllllllIIlllllllIllllllllIll.func_193001_a(lllllllllllIIlllllllIllllllllIIl);
        }
    }
    
    public void func_194191_a(final int lllllllllllIIllllllllIIIIlIIIIII, final int lllllllllllIIllllllllIIIIIllllll, final int lllllllllllIIllllllllIIIIIlllllI, final int lllllllllllIIllllllllIIIIIllIlII, final float lllllllllllIIllllllllIIIIIllllII) {
        if (this.field_193737_b > 1) {
            final String lllllllllllIIllllllllIIIIIlllIll = String.valueOf(this.field_193738_c + 1) + "/" + this.field_193737_b;
            final int lllllllllllIIllllllllIIIIIlllIlI = Minecraft.fontRendererObj.getStringWidth(lllllllllllIIllllllllIIIIIlllIll);
            Minecraft.fontRendererObj.drawString(lllllllllllIIllllllllIIIIIlllIll, (float)(lllllllllllIIllllllllIIIIlIIIIII - lllllllllllIIllllllllIIIIIlllIlI / 2 + 73), (float)(lllllllllllIIllllllllIIIIIllllll + 141), -1);
        }
        RenderHelper.disableStandardItemLighting();
        this.field_194201_b = null;
        for (final GuiButtonRecipe lllllllllllIIllllllllIIIIIlllIIl : this.field_193743_h) {
            lllllllllllIIllllllllIIIIIlllIIl.func_191745_a(this.field_193754_s, lllllllllllIIllllllllIIIIIlllllI, lllllllllllIIllllllllIIIIIllIlII, lllllllllllIIllllllllIIIIIllllII);
            if (lllllllllllIIllllllllIIIIIlllIIl.visible && lllllllllllIIllllllllIIIIIlllIIl.isMouseOver()) {
                this.field_194201_b = lllllllllllIIllllllllIIIIIlllIIl;
            }
        }
        this.field_193741_f.func_191745_a(this.field_193754_s, lllllllllllIIllllllllIIIIIlllllI, lllllllllllIIllllllllIIIIIllIlII, lllllllllllIIllllllllIIIIIllllII);
        this.field_193740_e.func_191745_a(this.field_193754_s, lllllllllllIIllllllllIIIIIlllllI, lllllllllllIIllllllllIIIIIllIlII, lllllllllllIIllllllllIIIIIllllII);
        this.field_194202_c.func_191842_a(lllllllllllIIllllllllIIIIIlllllI, lllllllllllIIllllllllIIIIIllIlII, lllllllllllIIllllllllIIIIIllllII);
    }
    
    public void func_194200_c() {
        this.field_194202_c.func_192999_a(false);
    }
    
    private void func_194197_e() {
        this.field_193740_e.visible = (this.field_193737_b > 1 && this.field_193738_c < this.field_193737_b - 1);
        this.field_193741_f.visible = (this.field_193737_b > 1 && this.field_193738_c > 0);
    }
    
    public boolean func_194196_a(final int lllllllllllIIllllllllIIIIIIIlIlI, final int lllllllllllIIllllllllIIIIIIIlIIl, final int lllllllllllIIllllllllIIIIIIIlIII, final int lllllllllllIIllllllllIIIIIIIIlll, final int lllllllllllIIllllllllIIIIIIIIllI, final int lllllllllllIIllllllllIIIIIIIIlIl, final int lllllllllllIIllllllllIIIIIIIIlII) {
        this.field_194205_l = null;
        this.field_194206_m = null;
        if (this.field_194202_c.func_191839_a()) {
            if (this.field_194202_c.func_193968_a(lllllllllllIIllllllllIIIIIIIlIlI, lllllllllllIIllllllllIIIIIIIlIIl, lllllllllllIIllllllllIIIIIIIlIII)) {
                this.field_194205_l = this.field_194202_c.func_193967_b();
                this.field_194206_m = this.field_194202_c.func_193971_a();
            }
            else {
                this.field_194202_c.func_192999_a(false);
            }
            return true;
        }
        if (this.field_193740_e.mousePressed(this.field_193754_s, lllllllllllIIllllllllIIIIIIIlIlI, lllllllllllIIllllllllIIIIIIIlIIl) && lllllllllllIIllllllllIIIIIIIlIII == 0) {
            this.field_193740_e.playPressSound(this.field_193754_s.getSoundHandler());
            ++this.field_193738_c;
            this.func_194198_d();
            return true;
        }
        if (this.field_193741_f.mousePressed(this.field_193754_s, lllllllllllIIllllllllIIIIIIIlIlI, lllllllllllIIllllllllIIIIIIIlIIl) && lllllllllllIIllllllllIIIIIIIlIII == 0) {
            this.field_193741_f.playPressSound(this.field_193754_s.getSoundHandler());
            --this.field_193738_c;
            this.func_194198_d();
            return true;
        }
        for (final GuiButtonRecipe lllllllllllIIllllllllIIIIIIIllII : this.field_193743_h) {
            if (lllllllllllIIllllllllIIIIIIIllII.mousePressed(this.field_193754_s, lllllllllllIIllllllllIIIIIIIlIlI, lllllllllllIIllllllllIIIIIIIlIIl)) {
                lllllllllllIIllllllllIIIIIIIllII.playPressSound(this.field_193754_s.getSoundHandler());
                if (lllllllllllIIllllllllIIIIIIIlIII == 0) {
                    this.field_194205_l = lllllllllllIIllllllllIIIIIIIllII.func_193760_e();
                    this.field_194206_m = lllllllllllIIllllllllIIIIIIIllII.func_191771_c();
                }
                else if (!this.field_194202_c.func_191839_a() && !lllllllllllIIllllllllIIIIIIIllII.func_193929_d()) {
                    this.field_194202_c.func_191845_a(this.field_193754_s, lllllllllllIIllllllllIIIIIIIllII.func_191771_c(), lllllllllllIIllllllllIIIIIIIllII.xPosition, lllllllllllIIllllllllIIIIIIIllII.yPosition, lllllllllllIIllllllllIIIIIIIIlll + lllllllllllIIllllllllIIIIIIIIlIl / 2, lllllllllllIIllllllllIIIIIIIIllI + 13 + lllllllllllIIllllllllIIIIIIIIlII / 2, (float)lllllllllllIIllllllllIIIIIIIllII.getButtonWidth(), this.field_194204_k);
                }
                return true;
            }
        }
        return false;
    }
    
    public void func_194194_a(final Minecraft lllllllllllIIllllllllIIIIllIlllI, final int lllllllllllIIllllllllIIIIllIllIl, final int lllllllllllIIllllllllIIIIllIllII) {
        this.field_193754_s = lllllllllllIIllllllllIIIIllIlllI;
        this.field_194204_k = lllllllllllIIllllllllIIIIllIlllI.player.func_192035_E();
        for (int lllllllllllIIllllllllIIIIlllIIII = 0; lllllllllllIIllllllllIIIIlllIIII < this.field_193743_h.size(); ++lllllllllllIIllllllllIIIIlllIIII) {
            this.field_193743_h.get(lllllllllllIIllllllllIIIIlllIIII).func_191770_c(lllllllllllIIllllllllIIIIllIllIl + 11 + 25 * (lllllllllllIIllllllllIIIIlllIIII % 5), lllllllllllIIllllllllIIIIllIllII + 31 + 25 * (lllllllllllIIllllllllIIIIlllIIII / 5));
        }
        this.field_193740_e = new GuiButtonToggle(0, lllllllllllIIllllllllIIIIllIllIl + 93, lllllllllllIIllllllllIIIIllIllII + 137, 12, 17, false);
        this.field_193740_e.func_191751_a(1, 208, 13, 18, GuiRecipeBook.field_191894_a);
        this.field_193741_f = new GuiButtonToggle(0, lllllllllllIIllllllllIIIIllIllIl + 38, lllllllllllIIllllllllIIIIllIllII + 137, 12, 17, true);
        this.field_193741_f.func_191751_a(1, 208, 13, 18, GuiRecipeBook.field_191894_a);
    }
    
    public void func_193732_a(final GuiRecipeBook lllllllllllIIllllllllIIIIllIIlll) {
        this.field_193757_v.remove(lllllllllllIIllllllllIIIIllIIlll);
        this.field_193757_v.add(lllllllllllIIllllllllIIIIllIIlll);
    }
}
