// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.item.ItemStack;
import java.util.Iterator;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.client.gui.GuiButton;
import java.util.Collections;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.client.gui.Gui;

public class GuiRecipeOverlay extends Gui
{
    private /* synthetic */ boolean field_191850_h;
    private /* synthetic */ IRecipe field_193973_l;
    private /* synthetic */ float field_193974_m;
    private /* synthetic */ RecipeList field_191848_f;
    private /* synthetic */ int field_191851_i;
    private /* synthetic */ Minecraft field_191853_k;
    private static final /* synthetic */ ResourceLocation field_191847_a;
    private /* synthetic */ int field_191852_j;
    private final /* synthetic */ List<Button> field_193972_f;
    
    private void func_191846_c(final int lllllllllllIllllIIlIIllIIlIIIlII, final int lllllllllllIllllIIlIIllIIlIIIIll, final int lllllllllllIllllIIlIIllIIlIIlIll, final int lllllllllllIllllIIlIIllIIlIIlIlI, final int lllllllllllIllllIIlIIllIIlIIlIIl, final int lllllllllllIllllIIlIIllIIIllllll) {
        this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j, lllllllllllIllllIIlIIllIIlIIlIIl, lllllllllllIllllIIlIIllIIIllllll, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
        this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIlII * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
        this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIIll * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
        this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIlII * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIIll * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
        for (int lllllllllllIllllIIlIIllIIlIIIlll = 0; lllllllllllIllllIIlIIllIIlIIIlll < lllllllllllIllllIIlIIllIIlIIIlII; ++lllllllllllIllllIIlIIllIIlIIIlll) {
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIlll * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll, lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIlI);
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIlll + 1) * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
            for (int lllllllllllIllllIIlIIllIIlIIIllI = 0; lllllllllllIllllIIlIIllIIlIIIllI < lllllllllllIllllIIlIIllIIlIIIIll; ++lllllllllllIllllIIlIIllIIlIIIllI) {
                if (lllllllllllIllllIIlIIllIIlIIIlll == 0) {
                    this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIllI * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll);
                    this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIllI + 1) * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
                }
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIlll * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIllI * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIll);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIlll + 1) * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIllI * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIlll * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIllI + 1) * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIlI);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIlll + 1) * lllllllllllIllllIIlIIllIIlIIlIll - 1, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIllI + 1) * lllllllllllIllllIIlIIllIIlIIlIll - 1, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI + 1, lllllllllllIllllIIlIIllIIlIIlIlI + 1);
                if (lllllllllllIllllIIlIIllIIlIIIlll == lllllllllllIllllIIlIIllIIlIIIlII - 1) {
                    this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIlII * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIllI * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll);
                    this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIlII * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIllI + 1) * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
                }
            }
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + lllllllllllIllllIIlIIllIIlIIIlll * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIIll * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIlI);
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllIllllIIlIIllIIlIIlIlI + (lllllllllllIllllIIlIIllIIlIIIlll + 1) * lllllllllllIllllIIlIIllIIlIIlIll, this.field_191852_j + lllllllllllIllllIIlIIllIIlIIlIlI * 2 + lllllllllllIllllIIlIIllIIlIIIIll * lllllllllllIllllIIlIIllIIlIIlIll, lllllllllllIllllIIlIIllIIlIIlIIl + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIIllllll + lllllllllllIllllIIlIIllIIlIIlIll + lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI, lllllllllllIllllIIlIIllIIlIIlIlI);
        }
    }
    
    public boolean func_191839_a() {
        return this.field_191850_h;
    }
    
    public GuiRecipeOverlay() {
        this.field_193972_f = (List<Button>)Lists.newArrayList();
    }
    
    public IRecipe func_193967_b() {
        return this.field_193973_l;
    }
    
    public RecipeList func_193971_a() {
        return this.field_191848_f;
    }
    
    public void func_191842_a(final int lllllllllllIllllIIlIIllIIllIIIll, final int lllllllllllIllllIIlIIllIIllIIIlI, final float lllllllllllIllllIIlIIllIIllIllIl) {
        if (this.field_191850_h) {
            this.field_193974_m += lllllllllllIllllIIlIIllIIllIllIl;
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_191853_k.getTextureManager().bindTexture(GuiRecipeOverlay.field_191847_a);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 170.0f);
            final int lllllllllllIllllIIlIIllIIllIllII = (this.field_193972_f.size() <= 16) ? 4 : 5;
            final int lllllllllllIllllIIlIIllIIllIlIll = Math.min(this.field_193972_f.size(), lllllllllllIllllIIlIIllIIllIllII);
            final int lllllllllllIllllIIlIIllIIllIlIlI = MathHelper.ceil(this.field_193972_f.size() / (float)lllllllllllIllllIIlIIllIIllIllII);
            final int lllllllllllIllllIIlIIllIIllIlIIl = 24;
            final int lllllllllllIllllIIlIIllIIllIlIII = 4;
            final int lllllllllllIllllIIlIIllIIllIIlll = 82;
            final int lllllllllllIllllIIlIIllIIllIIllI = 208;
            this.func_191846_c(lllllllllllIllllIIlIIllIIllIlIll, lllllllllllIllllIIlIIllIIllIlIlI, 24, 4, 82, 208);
            GlStateManager.disableBlend();
            RenderHelper.disableStandardItemLighting();
            for (final Button lllllllllllIllllIIlIIllIIllIIlIl : this.field_193972_f) {
                lllllllllllIllllIIlIIllIIllIIlIl.func_191745_a(this.field_191853_k, lllllllllllIllllIIlIIllIIllIIIll, lllllllllllIllllIIlIIllIIllIIIlI, lllllllllllIllllIIlIIllIIllIllIl);
            }
            GlStateManager.popMatrix();
        }
    }
    
    public void func_192999_a(final boolean lllllllllllIllllIIlIIllIIIllIlll) {
        this.field_191850_h = lllllllllllIllllIIlIIllIIIllIlll;
    }
    
    static {
        field_191847_a = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public void func_191845_a(final Minecraft lllllllllllIllllIIlIIllIllIIIlIl, final RecipeList lllllllllllIllllIIlIIllIllIIIlII, final int lllllllllllIllllIIlIIllIllIIIIll, final int lllllllllllIllllIIlIIllIllIIIIlI, final int lllllllllllIllllIIlIIllIlIlIlIII, final int lllllllllllIllllIIlIIllIlIlIIlll, final float lllllllllllIllllIIlIIllIlIlIIllI, final RecipeBook lllllllllllIllllIIlIIllIlIlllllI) {
        this.field_191853_k = lllllllllllIllllIIlIIllIllIIIlIl;
        this.field_191848_f = lllllllllllIllllIIlIIllIllIIIlII;
        final boolean lllllllllllIllllIIlIIllIlIllllIl = lllllllllllIllllIIlIIllIlIlllllI.func_192815_c();
        final List<IRecipe> lllllllllllIllllIIlIIllIlIllllII = lllllllllllIllllIIlIIllIllIIIlII.func_194207_b(true);
        final List<IRecipe> lllllllllllIllllIIlIIllIlIlllIll = lllllllllllIllllIIlIIllIlIllllIl ? Collections.emptyList() : lllllllllllIllllIIlIIllIllIIIlII.func_194207_b(false);
        final int lllllllllllIllllIIlIIllIlIlllIlI = lllllllllllIllllIIlIIllIlIllllII.size();
        final int lllllllllllIllllIIlIIllIlIlllIIl = lllllllllllIllllIIlIIllIlIlllIlI + lllllllllllIllllIIlIIllIlIlllIll.size();
        final int lllllllllllIllllIIlIIllIlIlllIII = (lllllllllllIllllIIlIIllIlIlllIIl <= 16) ? 4 : 5;
        final int lllllllllllIllllIIlIIllIlIllIlll = (int)Math.ceil(lllllllllllIllllIIlIIllIlIlllIIl / (float)lllllllllllIllllIIlIIllIlIlllIII);
        this.field_191851_i = lllllllllllIllllIIlIIllIllIIIIll;
        this.field_191852_j = lllllllllllIllllIIlIIllIllIIIIlI;
        final int lllllllllllIllllIIlIIllIlIllIllI = 25;
        final float lllllllllllIllllIIlIIllIlIllIlIl = (float)(this.field_191851_i + Math.min(lllllllllllIllllIIlIIllIlIlllIIl, lllllllllllIllllIIlIIllIlIlllIII) * 25);
        final float lllllllllllIllllIIlIIllIlIllIlII = (float)(lllllllllllIllllIIlIIllIlIlIlIII + 50);
        if (lllllllllllIllllIIlIIllIlIllIlIl > lllllllllllIllllIIlIIllIlIllIlII) {
            this.field_191851_i -= (int)(lllllllllllIllllIIlIIllIlIlIIllI * (int)((lllllllllllIllllIIlIIllIlIllIlIl - lllllllllllIllllIIlIIllIlIllIlII) / lllllllllllIllllIIlIIllIlIlIIllI));
        }
        final float lllllllllllIllllIIlIIllIlIllIIll = (float)(this.field_191852_j + lllllllllllIllllIIlIIllIlIllIlll * 25);
        final float lllllllllllIllllIIlIIllIlIllIIlI = (float)(lllllllllllIllllIIlIIllIlIlIIlll + 50);
        if (lllllllllllIllllIIlIIllIlIllIIll > lllllllllllIllllIIlIIllIlIllIIlI) {
            this.field_191852_j -= (int)(lllllllllllIllllIIlIIllIlIlIIllI * MathHelper.ceil((lllllllllllIllllIIlIIllIlIllIIll - lllllllllllIllllIIlIIllIlIllIIlI) / lllllllllllIllllIIlIIllIlIlIIllI));
        }
        final float lllllllllllIllllIIlIIllIlIllIIIl = (float)this.field_191852_j;
        final float lllllllllllIllllIIlIIllIlIllIIII = (float)(lllllllllllIllllIIlIIllIlIlIIlll - 100);
        if (lllllllllllIllllIIlIIllIlIllIIIl < lllllllllllIllllIIlIIllIlIllIIII) {
            this.field_191852_j -= (int)(lllllllllllIllllIIlIIllIlIlIIllI * MathHelper.ceil((lllllllllllIllllIIlIIllIlIllIIIl - lllllllllllIllllIIlIIllIlIllIIII) / lllllllllllIllllIIlIIllIlIlIIllI));
        }
        this.field_191850_h = true;
        this.field_193972_f.clear();
        for (int lllllllllllIllllIIlIIllIlIlIllll = 0; lllllllllllIllllIIlIIllIlIlIllll < lllllllllllIllllIIlIIllIlIlllIIl; ++lllllllllllIllllIIlIIllIlIlIllll) {
            final boolean lllllllllllIllllIIlIIllIlIlIlllI = lllllllllllIllllIIlIIllIlIlIllll < lllllllllllIllllIIlIIllIlIlllIlI;
            this.field_193972_f.add(new Button(this.field_191851_i + 4 + 25 * (lllllllllllIllllIIlIIllIlIlIllll % lllllllllllIllllIIlIIllIlIlllIII), this.field_191852_j + 5 + 25 * (lllllllllllIllllIIlIIllIlIlIllll / lllllllllllIllllIIlIIllIlIlllIII), lllllllllllIllllIIlIIllIlIlIlllI ? lllllllllllIllllIIlIIllIlIllllII.get(lllllllllllIllllIIlIIllIlIlIllll) : lllllllllllIllllIIlIIllIlIlllIll.get(lllllllllllIllllIIlIIllIlIlIllll - lllllllllllIllllIIlIIllIlIlllIlI), lllllllllllIllllIIlIIllIlIlIlllI));
        }
        this.field_193973_l = null;
    }
    
    public boolean func_193968_a(final int lllllllllllIllllIIlIIllIlIIIIIlI, final int lllllllllllIllllIIlIIllIlIIIIllI, final int lllllllllllIllllIIlIIllIlIIIIlIl) {
        if (lllllllllllIllllIIlIIllIlIIIIlIl != 0) {
            return false;
        }
        for (final Button lllllllllllIllllIIlIIllIlIIIIlII : this.field_193972_f) {
            if (lllllllllllIllllIIlIIllIlIIIIlII.mousePressed(this.field_191853_k, lllllllllllIllllIIlIIllIlIIIIIlI, lllllllllllIllllIIlIIllIlIIIIllI)) {
                this.field_193973_l = lllllllllllIllllIIlIIllIlIIIIlII.field_193924_p;
                return true;
            }
        }
        return false;
    }
    
    class Button extends GuiButton
    {
        private final /* synthetic */ boolean field_193925_q;
        private final /* synthetic */ IRecipe field_193924_p;
        
        public Button(final int llllllllllllIIlIllllllIlIllIllll, final int llllllllllllIIlIllllllIlIllIlIII, final IRecipe llllllllllllIIlIllllllIlIllIllIl, final boolean llllllllllllIIlIllllllIlIllIllII) {
            super(0, llllllllllllIIlIllllllIlIllIllll, llllllllllllIIlIllllllIlIllIlIII, "");
            this.width = 24;
            this.height = 24;
            this.field_193924_p = llllllllllllIIlIllllllIlIllIllIl;
            this.field_193925_q = llllllllllllIIlIllllllIlIllIllII;
        }
        
        public void func_191745_a(final Minecraft llllllllllllIIlIllllllIlIlIlIIll, final int llllllllllllIIlIllllllIlIlIlIIlI, final int llllllllllllIIlIllllllIlIIlllllI, final float llllllllllllIIlIllllllIlIlIlIIII) {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableAlpha();
            llllllllllllIIlIllllllIlIlIlIIll.getTextureManager().bindTexture(GuiRecipeOverlay.field_191847_a);
            this.hovered = (llllllllllllIIlIllllllIlIlIlIIlI >= this.xPosition && llllllllllllIIlIllllllIlIIlllllI >= this.yPosition && llllllllllllIIlIllllllIlIlIlIIlI < this.xPosition + this.width && llllllllllllIIlIllllllIlIIlllllI < this.yPosition + this.height);
            int llllllllllllIIlIllllllIlIlIIllll = 152;
            if (!this.field_193925_q) {
                llllllllllllIIlIllllllIlIlIIllll += 26;
            }
            int llllllllllllIIlIllllllIlIlIIlllI = 78;
            if (this.hovered) {
                llllllllllllIIlIllllllIlIlIIlllI += 26;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllIIlIllllllIlIlIIllll, llllllllllllIIlIllllllIlIlIIlllI, this.width, this.height);
            int llllllllllllIIlIllllllIlIlIIllIl = 3;
            int llllllllllllIIlIllllllIlIlIIllII = 3;
            if (this.field_193924_p instanceof ShapedRecipes) {
                final ShapedRecipes llllllllllllIIlIllllllIlIlIIlIll = (ShapedRecipes)this.field_193924_p;
                llllllllllllIIlIllllllIlIlIIllIl = llllllllllllIIlIllllllIlIlIIlIll.func_192403_f();
                llllllllllllIIlIllllllIlIlIIllII = llllllllllllIIlIllllllIlIlIIlIll.func_192404_g();
            }
            final Iterator<Ingredient> llllllllllllIIlIllllllIlIlIIlIlI = this.field_193924_p.func_192400_c().iterator();
            for (int llllllllllllIIlIllllllIlIlIIlIIl = 0; llllllllllllIIlIllllllIlIlIIlIIl < llllllllllllIIlIllllllIlIlIIllII; ++llllllllllllIIlIllllllIlIlIIlIIl) {
                final int llllllllllllIIlIllllllIlIlIIlIII = 3 + llllllllllllIIlIllllllIlIlIIlIIl * 7;
                for (int llllllllllllIIlIllllllIlIlIIIlll = 0; llllllllllllIIlIllllllIlIlIIIlll < llllllllllllIIlIllllllIlIlIIllIl; ++llllllllllllIIlIllllllIlIlIIIlll) {
                    if (llllllllllllIIlIllllllIlIlIIlIlI.hasNext()) {
                        final ItemStack[] llllllllllllIIlIllllllIlIlIIIllI = llllllllllllIIlIllllllIlIlIIlIlI.next().func_193365_a();
                        if (llllllllllllIIlIllllllIlIlIIIllI.length != 0) {
                            final int llllllllllllIIlIllllllIlIlIIIlIl = 3 + llllllllllllIIlIllllllIlIlIIIlll * 7;
                            GlStateManager.pushMatrix();
                            final float llllllllllllIIlIllllllIlIlIIIlII = 0.42f;
                            final int llllllllllllIIlIllllllIlIlIIIIll = (int)((this.xPosition + llllllllllllIIlIllllllIlIlIIIlIl) / 0.42f - 3.0f);
                            final int llllllllllllIIlIllllllIlIlIIIIlI = (int)((this.yPosition + llllllllllllIIlIllllllIlIlIIlIII) / 0.42f - 3.0f);
                            GlStateManager.scale(0.42f, 0.42f, 1.0f);
                            GlStateManager.enableLighting();
                            llllllllllllIIlIllllllIlIlIlIIll.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllIIlIllllllIlIlIIIllI[MathHelper.floor(GuiRecipeOverlay.this.field_193974_m / 30.0f) % llllllllllllIIlIllllllIlIlIIIllI.length], llllllllllllIIlIllllllIlIlIIIIll, llllllllllllIIlIllllllIlIlIIIIlI);
                            GlStateManager.disableLighting();
                            GlStateManager.popMatrix();
                        }
                    }
                }
            }
            GlStateManager.disableAlpha();
            RenderHelper.disableStandardItemLighting();
        }
    }
}
