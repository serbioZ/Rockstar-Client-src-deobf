// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.GuiScreen;
import javax.annotation.Nullable;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Collection;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.client.util.RecipeBookClient;
import com.google.common.collect.Lists;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import java.util.Iterator;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.item.crafting.IRecipe;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.LanguageManager;
import java.util.Locale;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.stats.RecipeBook;
import net.minecraft.client.gui.GuiButtonToggle;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.client.gui.Gui;

public class GuiRecipeBook extends Gui implements IRecipeUpdateListener
{
    private /* synthetic */ RecipeItemHelper field_193965_u;
    private /* synthetic */ GuiButtonRecipeTab field_191913_x;
    private final /* synthetic */ GhostRecipe field_191915_z;
    private /* synthetic */ int field_191904_o;
    private /* synthetic */ Minecraft field_191888_F;
    private /* synthetic */ GuiTextField field_193962_q;
    protected static final /* synthetic */ ResourceLocation field_191894_a;
    private /* synthetic */ int field_191905_p;
    private /* synthetic */ InventoryCrafting field_193961_o;
    private /* synthetic */ String field_193963_r;
    private final /* synthetic */ RecipeBookPage field_193022_s;
    private /* synthetic */ int field_191903_n;
    private final /* synthetic */ List<GuiButtonRecipeTab> field_193018_j;
    private /* synthetic */ int field_193966_v;
    private /* synthetic */ GuiButtonToggle field_193960_m;
    private /* synthetic */ RecipeBook field_193964_s;
    
    public void func_191861_a(final int llllllllllllIIllllIlIlllIIlllllI, final int llllllllllllIIllllIlIlllIIllllIl, final float llllllllllllIIllllIlIlllIIllllII) {
        if (this.func_191878_b()) {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 100.0f);
            this.field_191888_F.getTextureManager().bindTexture(GuiRecipeBook.field_191894_a);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int llllllllllllIIllllIlIlllIlIIIIlI = (this.field_191904_o - 147) / 2 - this.field_191903_n;
            final int llllllllllllIIllllIlIlllIlIIIIIl = (this.field_191905_p - 166) / 2;
            this.drawTexturedModalRect(llllllllllllIIllllIlIlllIlIIIIlI, llllllllllllIIllllIlIlllIlIIIIIl, 1, 1, 147, 166);
            this.field_193962_q.drawTextBox();
            RenderHelper.disableStandardItemLighting();
            for (final GuiButtonRecipeTab llllllllllllIIllllIlIlllIlIIIIII : this.field_193018_j) {
                llllllllllllIIllllIlIlllIlIIIIII.func_191745_a(this.field_191888_F, llllllllllllIIllllIlIlllIIlllllI, llllllllllllIIllllIlIlllIIllllIl, llllllllllllIIllllIlIlllIIllllII);
            }
            this.field_193960_m.func_191745_a(this.field_191888_F, llllllllllllIIllllIlIlllIIlllllI, llllllllllllIIllllIlIlllIIllllIl, llllllllllllIIllllIlIlllIIllllII);
            this.field_193022_s.func_194191_a(llllllllllllIIllllIlIlllIlIIIIlI, llllllllllllIIllllIlIlllIlIIIIIl, llllllllllllIIllllIlIlllIIlllllI, llllllllllllIIllllIlIlllIIllllIl, llllllllllllIIllllIlIlllIIllllII);
            GlStateManager.popMatrix();
        }
    }
    
    public boolean func_191859_a(final char llllllllllllIIllllIlIllIllIIIIII, final int llllllllllllIIllllIlIllIlIllllll) {
        if (!this.func_191878_b() || this.field_191888_F.player.isSpectator()) {
            return false;
        }
        if (llllllllllllIIllllIlIllIlIllllll == 1 && !this.func_191880_f()) {
            this.func_193006_a(false);
            return true;
        }
        if (GameSettings.isKeyDown(this.field_191888_F.gameSettings.keyBindChat) && !this.field_193962_q.isFocused()) {
            this.field_193962_q.setFocused(true);
        }
        else if (this.field_193962_q.textboxKeyTyped(llllllllllllIIllllIlIllIllIIIIII, llllllllllllIIllllIlIllIlIllllll)) {
            final String llllllllllllIIllllIlIllIllIIIIlI = this.field_193962_q.getText().toLowerCase(Locale.ROOT);
            this.func_193716_a(llllllllllllIIllllIlIllIllIIIIlI);
            if (!llllllllllllIIllllIlIllIllIIIIlI.equals(this.field_193963_r)) {
                this.func_193003_g(false);
                this.field_193963_r = llllllllllllIIllllIlIllIllIIIIlI;
            }
            return true;
        }
        return false;
    }
    
    private void func_193716_a(final String llllllllllllIIllllIlIllIlIllIlII) {
        if ("excitedze".equals(llllllllllllIIllllIlIllIlIllIlII)) {
            final LanguageManager llllllllllllIIllllIlIllIlIllIlll = this.field_191888_F.getLanguageManager();
            final Language llllllllllllIIllllIlIllIlIllIllI = llllllllllllIIllllIlIllIlIllIlll.func_191960_a("en_pt");
            if (llllllllllllIIllllIlIllIlIllIlll.getCurrentLanguage().compareTo(llllllllllllIIllllIlIllIlIllIllI) == 0) {
                return;
            }
            llllllllllllIIllllIlIllIlIllIlll.setCurrentLanguage(llllllllllllIIllllIlIllIlIllIllI);
            this.field_191888_F.gameSettings.language = llllllllllllIIllllIlIllIlIllIllI.getLanguageCode();
            this.field_191888_F.refreshResources();
            Minecraft.fontRendererObj.setUnicodeFlag(this.field_191888_F.getLanguageManager().isCurrentLocaleUnicode() || this.field_191888_F.gameSettings.forceUnicodeFont);
            Minecraft.fontRendererObj.setBidiFlag(llllllllllllIIllllIlIllIlIllIlll.isCurrentLanguageBidirectional());
            this.field_191888_F.gameSettings.saveOptions();
        }
    }
    
    public void func_191864_a(final int llllllllllllIIllllIlIllIllllllII, final int llllllllllllIIllllIlIllIlllllIll, final boolean llllllllllllIIllllIlIllIllllllll, final float llllllllllllIIllllIlIllIlllllllI) {
        this.field_191915_z.func_194188_a(this.field_191888_F, llllllllllllIIllllIlIllIllllllII, llllllllllllIIllllIlIllIlllllIll, llllllllllllIIllllIlIllIllllllll, llllllllllllIIllllIlIllIlllllllI);
    }
    
    private void func_193949_f() {
        final int llllllllllllIIllllIlIlllIllIIIlI = (this.field_191904_o - 147) / 2 - this.field_191903_n - 30;
        final int llllllllllllIIllllIlIlllIllIIIIl = (this.field_191905_p - 166) / 2 + 3;
        final int llllllllllllIIllllIlIlllIllIIIII = 27;
        int llllllllllllIIllllIlIlllIlIlllll = 0;
        for (final GuiButtonRecipeTab llllllllllllIIllllIlIlllIlIllllI : this.field_193018_j) {
            final CreativeTabs llllllllllllIIllllIlIlllIlIlllIl = llllllllllllIIllllIlIlllIlIllllI.func_191764_e();
            if (llllllllllllIIllllIlIlllIlIlllIl == CreativeTabs.SEARCH) {
                llllllllllllIIllllIlIlllIlIllllI.visible = true;
                llllllllllllIIllllIlIlllIlIllllI.func_191752_c(llllllllllllIIllllIlIlllIllIIIlI, llllllllllllIIllllIlIlllIllIIIIl + 27 * llllllllllllIIllllIlIlllIlIlllll++);
            }
            else {
                if (!llllllllllllIIllllIlIlllIlIllllI.func_193919_e()) {
                    continue;
                }
                llllllllllllIIllllIlIlllIlIllllI.func_191752_c(llllllllllllIIllllIlIlllIllIIIlI, llllllllllllIIllllIlIlllIllIIIIl + 27 * llllllllllllIIllllIlIlllIlIlllll++);
                llllllllllllIIllllIlIlllIlIllllI.func_193918_a(this.field_191888_F);
            }
        }
    }
    
    public void func_191876_c(final int llllllllllllIIllllIlIlllIIlIlIlI, final int llllllllllllIIllllIlIlllIIlIlIIl, final int llllllllllllIIllllIlIlllIIlIlllI, final int llllllllllllIIllllIlIlllIIlIllIl) {
        if (this.func_191878_b()) {
            this.field_193022_s.func_193721_a(llllllllllllIIllllIlIlllIIlIlllI, llllllllllllIIllllIlIlllIIlIllIl);
            if (this.field_193960_m.isMouseOver()) {
                final String llllllllllllIIllllIlIlllIIlIllII = I18n.format(this.field_193960_m.func_191754_c() ? "gui.recipebook.toggleRecipes.craftable" : "gui.recipebook.toggleRecipes.all", new Object[0]);
                if (this.field_191888_F.currentScreen != null) {
                    this.field_191888_F.currentScreen.drawCreativeTabHoveringText(llllllllllllIIllllIlIlllIIlIllII, llllllllllllIIllllIlIlllIIlIlllI, llllllllllllIIllllIlIlllIIlIllIl);
                }
            }
            this.func_193015_d(llllllllllllIIllllIlIlllIIlIlIlI, llllllllllllIIllllIlIlllIIlIlIIl, llllllllllllIIllllIlIlllIIlIlllI, llllllllllllIIllllIlIlllIIlIllIl);
        }
    }
    
    public void func_194303_a(final int llllllllllllIIllllIlIllllIlllIlI, final int llllllllllllIIllllIlIllllIllIIll, final Minecraft llllllllllllIIllllIlIllllIlllIII, final boolean llllllllllllIIllllIlIllllIllIIIl, final InventoryCrafting llllllllllllIIllllIlIllllIllIIII) {
        this.field_191888_F = llllllllllllIIllllIlIllllIlllIII;
        this.field_191904_o = llllllllllllIIllllIlIllllIlllIlI;
        this.field_191905_p = llllllllllllIIllllIlIllllIllIIll;
        this.field_193961_o = llllllllllllIIllllIlIllllIllIIII;
        this.field_193964_s = llllllllllllIIllllIlIllllIlllIII.player.func_192035_E();
        this.field_193966_v = llllllllllllIIllllIlIllllIlllIII.player.inventory.func_194015_p();
        this.field_191913_x = this.field_193018_j.get(0);
        this.field_191913_x.func_191753_b(true);
        if (this.func_191878_b()) {
            this.func_193014_a(llllllllllllIIllllIlIllllIllIIIl, llllllllllllIIllllIlIllllIllIIII);
        }
        Keyboard.enableRepeatEvents(true);
    }
    
    public void func_193951_a(final IRecipe llllllllllllIIllllIlIllIlIIlIIlI, final List<Slot> llllllllllllIIllllIlIllIlIIlIIIl) {
        final ItemStack llllllllllllIIllllIlIllIlIIlIIII = llllllllllllIIllllIlIllIlIIlIIlI.getRecipeOutput();
        this.field_191915_z.func_192685_a(llllllllllllIIllllIlIllIlIIlIIlI);
        this.field_191915_z.func_194187_a(Ingredient.func_193369_a(llllllllllllIIllllIlIllIlIIlIIII), llllllllllllIIllllIlIllIlIIlIIIl.get(0).xDisplayPosition, llllllllllllIIllllIlIllIlIIlIIIl.get(0).yDisplayPosition);
        final int llllllllllllIIllllIlIllIlIIIllll = this.field_193961_o.getWidth();
        final int llllllllllllIIllllIlIllIlIIIlllI = this.field_193961_o.getHeight();
        final int llllllllllllIIllllIlIllIlIIIllIl = (llllllllllllIIllllIlIllIlIIlIIlI instanceof ShapedRecipes) ? ((ShapedRecipes)llllllllllllIIllllIlIllIlIIlIIlI).func_192403_f() : llllllllllllIIllllIlIllIlIIIllll;
        int llllllllllllIIllllIlIllIlIIIllII = 1;
        final Iterator<Ingredient> llllllllllllIIllllIlIllIlIIIlIll = llllllllllllIIllllIlIllIlIIlIIlI.func_192400_c().iterator();
        for (int llllllllllllIIllllIlIllIlIIIlIlI = 0; llllllllllllIIllllIlIllIlIIIlIlI < llllllllllllIIllllIlIllIlIIIlllI; ++llllllllllllIIllllIlIllIlIIIlIlI) {
            for (int llllllllllllIIllllIlIllIlIIIlIIl = 0; llllllllllllIIllllIlIllIlIIIlIIl < llllllllllllIIllllIlIllIlIIIllIl; ++llllllllllllIIllllIlIllIlIIIlIIl) {
                if (!llllllllllllIIllllIlIllIlIIIlIll.hasNext()) {
                    return;
                }
                final Ingredient llllllllllllIIllllIlIllIlIIIlIII = llllllllllllIIllllIlIllIlIIIlIll.next();
                if (llllllllllllIIllllIlIllIlIIIlIII != Ingredient.field_193370_a) {
                    final Slot llllllllllllIIllllIlIllIlIIIIlll = llllllllllllIIllllIlIllIlIIlIIIl.get(llllllllllllIIllllIlIllIlIIIllII);
                    this.field_191915_z.func_194187_a(llllllllllllIIllllIlIllIlIIIlIII, llllllllllllIIllllIlIllIlIIIIlll.xDisplayPosition, llllllllllllIIllllIlIllIlIIIIlll.yDisplayPosition);
                }
                ++llllllllllllIIllllIlIllIlIIIllII;
            }
            if (llllllllllllIIllllIlIllIlIIIllIl < llllllllllllIIllllIlIllIlIIIllll) {
                llllllllllllIIllllIlIllIlIIIllII += llllllllllllIIllllIlIllIlIIIllll - llllllllllllIIllllIlIllIlIIIllIl;
            }
        }
    }
    
    private void func_193956_j() {
        if (this.field_191888_F.getConnection() != null) {
            this.field_191888_F.getConnection().sendPacket(new CPacketRecipeInfo(this.func_191878_b(), this.field_193964_s.func_192815_c()));
        }
    }
    
    public boolean func_193955_c(final int llllllllllllIIllllIlIllIllIllIlI, final int llllllllllllIIllllIlIllIllIllIIl, final int llllllllllllIIllllIlIllIllIllIII, final int llllllllllllIIllllIlIllIllIIlllI, final int llllllllllllIIllllIlIllIllIIllIl, final int llllllllllllIIllllIlIllIllIlIlIl) {
        if (!this.func_191878_b()) {
            return true;
        }
        final boolean llllllllllllIIllllIlIllIllIlIlII = llllllllllllIIllllIlIllIllIllIlI < llllllllllllIIllllIlIllIllIllIII || llllllllllllIIllllIlIllIllIllIIl < llllllllllllIIllllIlIllIllIIlllI || llllllllllllIIllllIlIllIllIllIlI >= llllllllllllIIllllIlIllIllIllIII + llllllllllllIIllllIlIllIllIIllIl || llllllllllllIIllllIlIllIllIllIIl >= llllllllllllIIllllIlIllIllIIlllI + llllllllllllIIllllIlIllIllIlIlIl;
        final boolean llllllllllllIIllllIlIllIllIlIIll = llllllllllllIIllllIlIllIllIllIII - 147 < llllllllllllIIllllIlIllIllIllIlI && llllllllllllIIllllIlIllIllIllIlI < llllllllllllIIllllIlIllIllIllIII && llllllllllllIIllllIlIllIllIIlllI < llllllllllllIIllllIlIllIllIllIIl && llllllllllllIIllllIlIllIllIllIIl < llllllllllllIIllllIlIllIllIIlllI + llllllllllllIIllllIlIllIllIlIlIl;
        return llllllllllllIIllllIlIllIllIlIlII && !llllllllllllIIllllIlIllIllIlIIll && !this.field_191913_x.mousePressed(this.field_191888_F, llllllllllllIIllllIlIllIllIllIlI, llllllllllllIIllllIlIllIllIllIIl);
    }
    
    public void func_193948_e() {
        this.func_193949_f();
        if (this.func_191878_b()) {
            this.func_193003_g(false);
        }
    }
    
    public void func_193014_a(final boolean llllllllllllIIllllIlIllllIlIlIIl, final InventoryCrafting llllllllllllIIllllIlIllllIlIlIII) {
        this.field_191903_n = (llllllllllllIIllllIlIllllIlIlIIl ? 0 : 86);
        final int llllllllllllIIllllIlIllllIlIIlll = (this.field_191904_o - 147) / 2 - this.field_191903_n;
        final int llllllllllllIIllllIlIllllIlIIllI = (this.field_191905_p - 166) / 2;
        this.field_193965_u.func_194119_a();
        this.field_191888_F.player.inventory.func_194016_a(this.field_193965_u, false);
        llllllllllllIIllllIlIllllIlIlIII.func_194018_a(this.field_193965_u);
        this.field_193962_q = new GuiTextField(0, Minecraft.fontRendererObj, llllllllllllIIllllIlIllllIlIIlll + 25, llllllllllllIIllllIlIllllIlIIllI + 14, 80, Minecraft.fontRendererObj.FONT_HEIGHT + 5);
        this.field_193962_q.setMaxStringLength(50);
        this.field_193962_q.setEnableBackgroundDrawing(false);
        this.field_193962_q.setVisible(true);
        this.field_193962_q.setTextColor(16777215);
        this.field_193022_s.func_194194_a(this.field_191888_F, llllllllllllIIllllIlIllllIlIIlll, llllllllllllIIllllIlIllllIlIIllI);
        this.field_193022_s.func_193732_a(this);
        this.field_193960_m = new GuiButtonToggle(0, llllllllllllIIllllIlIllllIlIIlll + 110, llllllllllllIIllllIlIllllIlIIllI + 12, 26, 16, this.field_193964_s.func_192815_c());
        this.field_193960_m.func_191751_a(152, 41, 28, 18, GuiRecipeBook.field_191894_a);
        this.func_193003_g(false);
        this.func_193949_f();
    }
    
    private boolean func_191880_f() {
        return this.field_191903_n == 86;
    }
    
    private void func_193015_d(final int llllllllllllIIllllIlIlllIIIllIlI, final int llllllllllllIIllllIlIlllIIIIllll, final int llllllllllllIIllllIlIlllIIIllIII, final int llllllllllllIIllllIlIlllIIIlIlll) {
        ItemStack llllllllllllIIllllIlIlllIIIlIllI = null;
        for (int llllllllllllIIllllIlIlllIIIlIlIl = 0; llllllllllllIIllllIlIlllIIIlIlIl < this.field_191915_z.func_192684_b(); ++llllllllllllIIllllIlIlllIIIlIlIl) {
            final GhostRecipe.GhostIngredient llllllllllllIIllllIlIlllIIIlIlII = this.field_191915_z.func_192681_a(llllllllllllIIllllIlIlllIIIlIlIl);
            final int llllllllllllIIllllIlIlllIIIlIIll = llllllllllllIIllllIlIlllIIIlIlII.func_193713_b() + llllllllllllIIllllIlIlllIIIllIlI;
            final int llllllllllllIIllllIlIlllIIIlIIlI = llllllllllllIIllllIlIlllIIIlIlII.func_193712_c() + llllllllllllIIllllIlIlllIIIIllll;
            if (llllllllllllIIllllIlIlllIIIllIII >= llllllllllllIIllllIlIlllIIIlIIll && llllllllllllIIllllIlIlllIIIlIlll >= llllllllllllIIllllIlIlllIIIlIIlI && llllllllllllIIllllIlIlllIIIllIII < llllllllllllIIllllIlIlllIIIlIIll + 16 && llllllllllllIIllllIlIlllIIIlIlll < llllllllllllIIllllIlIlllIIIlIIlI + 16) {
                llllllllllllIIllllIlIlllIIIlIllI = llllllllllllIIllllIlIlllIIIlIlII.func_194184_c();
            }
        }
        if (llllllllllllIIllllIlIlllIIIlIllI != null && this.field_191888_F.currentScreen != null) {
            this.field_191888_F.currentScreen.drawHoveringText(this.field_191888_F.currentScreen.func_191927_a(llllllllllllIIllllIlIlllIIIlIllI), llllllllllllIIllllIlIlllIIIllIII, llllllllllllIIllllIlIlllIIIlIlll);
        }
    }
    
    public void func_191871_c() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private void func_193006_a(final boolean llllllllllllIIllllIlIllllIIIIllI) {
        this.field_193964_s.func_192813_a(llllllllllllIIllllIlIllllIIIIllI);
        if (!llllllllllllIIllllIlIllllIIIIllI) {
            this.field_193022_s.func_194200_c();
        }
        this.func_193956_j();
    }
    
    public void func_191866_a() {
        this.func_193006_a(!this.func_191878_b());
    }
    
    static {
        field_191894_a = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public GuiRecipeBook() {
        this.field_191915_z = new GhostRecipe();
        this.field_193018_j = (List<GuiButtonRecipeTab>)Lists.newArrayList((Object[])new GuiButtonRecipeTab[] { new GuiButtonRecipeTab(0, CreativeTabs.SEARCH), new GuiButtonRecipeTab(0, CreativeTabs.TOOLS), new GuiButtonRecipeTab(0, CreativeTabs.BUILDING_BLOCKS), new GuiButtonRecipeTab(0, CreativeTabs.MISC), new GuiButtonRecipeTab(0, CreativeTabs.REDSTONE) });
        this.field_193963_r = "";
        this.field_193022_s = new RecipeBookPage();
        this.field_193965_u = new RecipeItemHelper();
    }
    
    private void func_193942_g() {
        this.field_193965_u.func_194119_a();
        this.field_191888_F.player.inventory.func_194016_a(this.field_193965_u, false);
        this.field_193961_o.func_194018_a(this.field_193965_u);
        this.func_193003_g(false);
    }
    
    public void func_193957_d() {
        if (this.func_191878_b() && this.field_193966_v != this.field_191888_F.player.inventory.func_194015_p()) {
            this.func_193942_g();
            this.field_193966_v = this.field_191888_F.player.inventory.func_194015_p();
        }
    }
    
    @Override
    public void func_193001_a(final List<IRecipe> llllllllllllIIllllIlIllIlIlIIllI) {
        for (final IRecipe llllllllllllIIllllIlIllIlIlIIlIl : llllllllllllIIllllIlIllIlIlIIllI) {
            this.field_191888_F.player.func_193103_a(llllllllllllIIllllIlIllIlIlIIlIl);
        }
    }
    
    private void func_193003_g(final boolean llllllllllllIIllllIlIlllIlllIIII) {
        final List<RecipeList> llllllllllllIIllllIlIlllIlllIlIl = RecipeBookClient.field_194086_e.get(this.field_191913_x.func_191764_e());
        llllllllllllIIllllIlIlllIlllIlIl.forEach(llllllllllllIIllllIlIllIIlllIIIl -> llllllllllllIIllllIlIllIIlllIIIl.func_194210_a(this.field_193965_u, this.field_193961_o.getWidth(), this.field_193961_o.getHeight(), this.field_193964_s));
        final List<RecipeList> llllllllllllIIllllIlIlllIlllIlII = (List<RecipeList>)Lists.newArrayList((Iterable)llllllllllllIIllllIlIlllIlllIlIl);
        llllllllllllIIllllIlIlllIlllIlII.removeIf(llllllllllllIIllllIlIllIIllIllll -> !llllllllllllIIllllIlIllIIllIllll.func_194209_a());
        llllllllllllIIllllIlIlllIlllIlII.removeIf(llllllllllllIIllllIlIllIIllIllII -> !llllllllllllIIllllIlIllIIllIllII.func_194212_c());
        final String llllllllllllIIllllIlIlllIlllIIll = this.field_193962_q.getText();
        if (!llllllllllllIIllllIlIlllIlllIIll.isEmpty()) {
            final ObjectSet<RecipeList> llllllllllllIIllllIlIlllIlllIIlI = (ObjectSet<RecipeList>)new ObjectLinkedOpenHashSet((Collection)this.field_191888_F.func_193987_a(SearchTreeManager.field_194012_b).func_194038_a(llllllllllllIIllllIlIlllIlllIIll.toLowerCase(Locale.ROOT)));
            llllllllllllIIllllIlIlllIlllIlII.removeIf(llllllllllllIIllllIlIllIIllIIllI -> !llllllllllllIIllllIlIlllIlllIIlI.contains((Object)llllllllllllIIllllIlIllIIllIIllI));
        }
        if (this.field_193964_s.func_192815_c()) {
            llllllllllllIIllllIlIlllIlllIlII.removeIf(llllllllllllIIllllIlIllIIllIIIll -> !llllllllllllIIllllIlIllIIllIIIll.func_192708_c());
        }
        this.field_193022_s.func_194192_a(llllllllllllIIllllIlIlllIlllIlII, llllllllllllIIllllIlIlllIlllIIII);
    }
    
    public int func_193011_a(final boolean llllllllllllIIllllIlIllllIIllIIl, final int llllllllllllIIllllIlIllllIIlIIlI, final int llllllllllllIIllllIlIllllIIlIIIl) {
        int llllllllllllIIllllIlIllllIIlIlIl = 0;
        if (this.func_191878_b() && !llllllllllllIIllllIlIllllIIllIIl) {
            final int llllllllllllIIllllIlIllllIIlIllI = 177 + (llllllllllllIIllllIlIllllIIlIIlI - llllllllllllIIllllIlIllllIIlIIIl - 200) / 2;
        }
        else {
            llllllllllllIIllllIlIllllIIlIlIl = (llllllllllllIIllllIlIllllIIlIIlI - llllllllllllIIllllIlIllllIIlIIIl) / 2;
        }
        return llllllllllllIIllllIlIllllIIlIlIl;
    }
    
    public void func_191874_a(@Nullable final Slot llllllllllllIIllllIlIlllIllllllI) {
        if (llllllllllllIIllllIlIlllIllllllI != null && llllllllllllIIllllIlIlllIllllllI.slotNumber <= 9) {
            this.field_191915_z.func_192682_a();
            if (this.func_191878_b()) {
                this.func_193942_g();
            }
        }
    }
    
    public boolean func_191862_a(final int llllllllllllIIllllIlIllIlllIlIIl, final int llllllllllllIIllllIlIllIlllIlIII, final int llllllllllllIIllllIlIllIlllIllll) {
        if (!this.func_191878_b() || this.field_191888_F.player.isSpectator()) {
            return false;
        }
        if (this.field_193022_s.func_194196_a(llllllllllllIIllllIlIllIlllIlIIl, llllllllllllIIllllIlIllIlllIlIII, llllllllllllIIllllIlIllIlllIllll, (this.field_191904_o - 147) / 2 - this.field_191903_n, (this.field_191905_p - 166) / 2, 147, 166)) {
            final IRecipe llllllllllllIIllllIlIllIlllIlllI = this.field_193022_s.func_194193_a();
            final RecipeList llllllllllllIIllllIlIllIlllIllIl = this.field_193022_s.func_194199_b();
            if (llllllllllllIIllllIlIllIlllIlllI != null && llllllllllllIIllllIlIllIlllIllIl != null) {
                if (!llllllllllllIIllllIlIllIlllIllIl.func_194213_a(llllllllllllIIllllIlIllIlllIlllI) && this.field_191915_z.func_192686_c() == llllllllllllIIllllIlIllIlllIlllI) {
                    return false;
                }
                this.field_191915_z.func_192682_a();
                this.field_191888_F.playerController.func_194338_a(this.field_191888_F.player.openContainer.windowId, llllllllllllIIllllIlIllIlllIlllI, GuiScreen.isShiftKeyDown(), this.field_191888_F.player);
                if (!this.func_191880_f() && llllllllllllIIllllIlIllIlllIllll == 0) {
                    this.func_193006_a(false);
                }
            }
            return true;
        }
        if (llllllllllllIIllllIlIllIlllIllll != 0) {
            return false;
        }
        if (this.field_193962_q.mouseClicked(llllllllllllIIllllIlIllIlllIlIIl, llllllllllllIIllllIlIllIlllIlIII, llllllllllllIIllllIlIllIlllIllll)) {
            return true;
        }
        if (this.field_193960_m.mousePressed(this.field_191888_F, llllllllllllIIllllIlIllIlllIlIIl, llllllllllllIIllllIlIllIlllIlIII)) {
            final boolean llllllllllllIIllllIlIllIlllIllII = !this.field_193964_s.func_192815_c();
            this.field_193964_s.func_192810_b(llllllllllllIIllllIlIllIlllIllII);
            this.field_193960_m.func_191753_b(llllllllllllIIllllIlIllIlllIllII);
            this.field_193960_m.playPressSound(this.field_191888_F.getSoundHandler());
            this.func_193956_j();
            this.func_193003_g(false);
            return true;
        }
        for (final GuiButtonRecipeTab llllllllllllIIllllIlIllIlllIlIll : this.field_193018_j) {
            if (llllllllllllIIllllIlIllIlllIlIll.mousePressed(this.field_191888_F, llllllllllllIIllllIlIllIlllIlIIl, llllllllllllIIllllIlIllIlllIlIII)) {
                if (this.field_191913_x != llllllllllllIIllllIlIllIlllIlIll) {
                    llllllllllllIIllllIlIllIlllIlIll.playPressSound(this.field_191888_F.getSoundHandler());
                    this.field_191913_x.func_191753_b(false);
                    this.field_191913_x = llllllllllllIIllllIlIllIlllIlIll;
                    this.field_191913_x.func_191753_b(true);
                    this.func_193003_g(true);
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean func_191878_b() {
        return this.field_193964_s.func_192812_b();
    }
}
