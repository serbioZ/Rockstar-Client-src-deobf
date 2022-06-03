// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.client.resources.I18n;
import java.util.Collection;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonRecipe extends GuiButton
{
    private /* synthetic */ RecipeList field_191774_p;
    private /* synthetic */ float field_193931_r;
    private /* synthetic */ float field_191778_t;
    private static final /* synthetic */ ResourceLocation field_191780_o;
    private /* synthetic */ int field_193932_t;
    private /* synthetic */ RecipeBook field_193930_p;
    
    public void func_191745_a(final Minecraft llllllllllllllIIlIIIIllIIIIllIIl, final int llllllllllllllIIlIIIIllIIIlIIlII, final int llllllllllllllIIlIIIIllIIIIlIlll, final float llllllllllllllIIlIIIIllIIIlIIIlI) {
        if (this.visible) {
            if (!GuiScreen.isCtrlKeyDown()) {
                this.field_193931_r += llllllllllllllIIlIIIIllIIIlIIIlI;
            }
            this.hovered = (llllllllllllllIIlIIIIllIIIlIIlII >= this.xPosition && llllllllllllllIIlIIIIllIIIIlIlll >= this.yPosition && llllllllllllllIIlIIIIllIIIlIIlII < this.xPosition + this.width && llllllllllllllIIlIIIIllIIIIlIlll < this.yPosition + this.height);
            RenderHelper.enableGUIStandardItemLighting();
            llllllllllllllIIlIIIIllIIIIllIIl.getTextureManager().bindTexture(GuiButtonRecipe.field_191780_o);
            GlStateManager.disableLighting();
            int llllllllllllllIIlIIIIllIIIlIIIIl = 29;
            if (!this.field_191774_p.func_192708_c()) {
                llllllllllllllIIlIIIIllIIIlIIIIl += 25;
            }
            int llllllllllllllIIlIIIIllIIIlIIIII = 206;
            if (this.field_191774_p.func_194208_a(this.field_193930_p.func_192815_c()).size() > 1) {
                llllllllllllllIIlIIIIllIIIlIIIII += 25;
            }
            final boolean llllllllllllllIIlIIIIllIIIIlllll = this.field_191778_t > 0.0f;
            if (llllllllllllllIIlIIIIllIIIIlllll) {
                final float llllllllllllllIIlIIIIllIIIIllllI = 1.0f + 0.1f * (float)Math.sin(this.field_191778_t / 15.0f * 3.1415927f);
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(this.xPosition + 8), (float)(this.yPosition + 12), 0.0f);
                GlStateManager.scale(llllllllllllllIIlIIIIllIIIIllllI, llllllllllllllIIlIIIIllIIIIllllI, 1.0f);
                GlStateManager.translate((float)(-(this.xPosition + 8)), (float)(-(this.yPosition + 12)), 0.0f);
                this.field_191778_t -= llllllllllllllIIlIIIIllIIIlIIIlI;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllIIlIIIIllIIIlIIIIl, llllllllllllllIIlIIIIllIIIlIIIII, this.width, this.height);
            final List<IRecipe> llllllllllllllIIlIIIIllIIIIlllIl = this.func_193927_f();
            this.field_193932_t = MathHelper.floor(this.field_193931_r / 30.0f) % llllllllllllllIIlIIIIllIIIIlllIl.size();
            final ItemStack llllllllllllllIIlIIIIllIIIIlllII = llllllllllllllIIlIIIIllIIIIlllIl.get(this.field_193932_t).getRecipeOutput();
            int llllllllllllllIIlIIIIllIIIIllIll = 4;
            if (this.field_191774_p.func_194211_e() && this.func_193927_f().size() > 1) {
                llllllllllllllIIlIIIIllIIIIllIIl.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllIIlIIIIllIIIIlllII, this.xPosition + llllllllllllllIIlIIIIllIIIIllIll + 1, this.yPosition + llllllllllllllIIlIIIIllIIIIllIll + 1);
                --llllllllllllllIIlIIIIllIIIIllIll;
            }
            llllllllllllllIIlIIIIllIIIIllIIl.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllIIlIIIIllIIIIlllII, this.xPosition + llllllllllllllIIlIIIIllIIIIllIll, this.yPosition + llllllllllllllIIlIIIIllIIIIllIll);
            if (llllllllllllllIIlIIIIllIIIIlllll) {
                GlStateManager.popMatrix();
            }
            GlStateManager.enableLighting();
            RenderHelper.disableStandardItemLighting();
        }
    }
    
    public GuiButtonRecipe() {
        super(0, 0, 0, 25, 25, "");
    }
    
    public RecipeList func_191771_c() {
        return this.field_191774_p;
    }
    
    public IRecipe func_193760_e() {
        final List<IRecipe> llllllllllllllIIlIIIIllIIIIIIIll = this.func_193927_f();
        return llllllllllllllIIlIIIIllIIIIIIIll.get(this.field_193932_t);
    }
    
    private List<IRecipe> func_193927_f() {
        final List<IRecipe> llllllllllllllIIlIIIIllIIIIIllII = this.field_191774_p.func_194207_b(true);
        if (!this.field_193930_p.func_192815_c()) {
            llllllllllllllIIlIIIIllIIIIIllII.addAll(this.field_191774_p.func_194207_b(false));
        }
        return llllllllllllllIIlIIIIllIIIIIllII;
    }
    
    static {
        field_191780_o = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public List<String> func_191772_a(final GuiScreen llllllllllllllIIlIIIIlIllllllIll) {
        final ItemStack llllllllllllllIIlIIIIlIllllllIlI = this.func_193927_f().get(this.field_193932_t).getRecipeOutput();
        final List<String> llllllllllllllIIlIIIIlIllllllIIl = llllllllllllllIIlIIIIlIllllllIll.func_191927_a(llllllllllllllIIlIIIIlIllllllIlI);
        if (this.field_191774_p.func_194208_a(this.field_193930_p.func_192815_c()).size() > 1) {
            llllllllllllllIIlIIIIlIllllllIIl.add(I18n.format("gui.recipebook.moreRecipes", new Object[0]));
        }
        return llllllllllllllIIlIIIIlIllllllIIl;
    }
    
    public boolean func_193929_d() {
        return this.func_193927_f().size() == 1;
    }
    
    @Override
    public int getButtonWidth() {
        return 25;
    }
    
    public void func_193928_a(final RecipeList llllllllllllllIIlIIIIllIIlIIlIIl, final RecipeBookPage llllllllllllllIIlIIIIllIIlIIIIlI, final RecipeBook llllllllllllllIIlIIIIllIIlIIIlll) {
        this.field_191774_p = llllllllllllllIIlIIIIllIIlIIlIIl;
        this.field_193930_p = llllllllllllllIIlIIIIllIIlIIIlll;
        final List<IRecipe> llllllllllllllIIlIIIIllIIlIIIllI = llllllllllllllIIlIIIIllIIlIIlIIl.func_194208_a(llllllllllllllIIlIIIIllIIlIIIlll.func_192815_c());
        for (final IRecipe llllllllllllllIIlIIIIllIIlIIIlIl : llllllllllllllIIlIIIIllIIlIIIllI) {
            if (llllllllllllllIIlIIIIllIIlIIIlll.func_194076_e(llllllllllllllIIlIIIIllIIlIIIlIl)) {
                llllllllllllllIIlIIIIllIIlIIIIlI.func_194195_a(llllllllllllllIIlIIIIllIIlIIIllI);
                this.field_191778_t = 15.0f;
                break;
            }
        }
    }
    
    public void func_191770_c(final int llllllllllllllIIlIIIIllIIIllIIll, final int llllllllllllllIIlIIIIllIIIllIIlI) {
        this.xPosition = llllllllllllllIIlIIIIllIIIllIIll;
        this.yPosition = llllllllllllllIIlIIIIllIIIllIIlI;
    }
}
