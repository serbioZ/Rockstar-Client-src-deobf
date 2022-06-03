// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.util.math.MathHelper;
import com.google.common.collect.Lists;
import net.minecraft.item.crafting.Ingredient;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;

public class GhostRecipe
{
    private final /* synthetic */ List<GhostIngredient> field_192688_b;
    private /* synthetic */ IRecipe field_192687_a;
    private /* synthetic */ float field_194190_c;
    
    public void func_194188_a(final Minecraft lllllllllllIIlIlIIlllIIlIlIIllII, final int lllllllllllIIlIlIIlllIIlIlIIlIll, final int lllllllllllIIlIlIIlllIIlIlIIlIlI, final boolean lllllllllllIIlIlIIlllIIlIlIlIlIl, final float lllllllllllIIlIlIIlllIIlIlIIlIII) {
        if (!GuiScreen.isCtrlKeyDown()) {
            this.field_194190_c += lllllllllllIIlIlIIlllIIlIlIIlIII;
        }
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableLighting();
        for (int lllllllllllIIlIlIIlllIIlIlIlIIll = 0; lllllllllllIIlIlIIlllIIlIlIlIIll < this.field_192688_b.size(); ++lllllllllllIIlIlIIlllIIlIlIlIIll) {
            final GhostIngredient lllllllllllIIlIlIIlllIIlIlIlIIlI = this.field_192688_b.get(lllllllllllIIlIlIIlllIIlIlIlIIll);
            final int lllllllllllIIlIlIIlllIIlIlIlIIIl = lllllllllllIIlIlIIlllIIlIlIlIIlI.func_193713_b() + lllllllllllIIlIlIIlllIIlIlIIlIll;
            final int lllllllllllIIlIlIIlllIIlIlIlIIII = lllllllllllIIlIlIIlllIIlIlIlIIlI.func_193712_c() + lllllllllllIIlIlIIlllIIlIlIIlIlI;
            if (lllllllllllIIlIlIIlllIIlIlIlIIll == 0 && lllllllllllIIlIlIIlllIIlIlIlIlIl) {
                Gui.drawRect(lllllllllllIIlIlIIlllIIlIlIlIIIl - 4, lllllllllllIIlIlIIlllIIlIlIlIIII - 4, lllllllllllIIlIlIIlllIIlIlIlIIIl + 20, lllllllllllIIlIlIIlllIIlIlIlIIII + 20, 822018048);
            }
            else {
                Gui.drawRect(lllllllllllIIlIlIIlllIIlIlIlIIIl, lllllllllllIIlIlIIlllIIlIlIlIIII, lllllllllllIIlIlIIlllIIlIlIlIIIl + 16, lllllllllllIIlIlIIlllIIlIlIlIIII + 16, 822018048);
            }
            GlStateManager.disableLighting();
            final ItemStack lllllllllllIIlIlIIlllIIlIlIIllll = lllllllllllIIlIlIIlllIIlIlIlIIlI.func_194184_c();
            final RenderItem lllllllllllIIlIlIIlllIIlIlIIlllI = lllllllllllIIlIlIIlllIIlIlIIllII.getRenderItem();
            lllllllllllIIlIlIIlllIIlIlIIlllI.renderItemAndEffectIntoGUI(lllllllllllIIlIlIIlllIIlIlIIllII.player, lllllllllllIIlIlIIlllIIlIlIIllll, lllllllllllIIlIlIIlllIIlIlIlIIIl, lllllllllllIIlIlIIlllIIlIlIlIIII);
            GlStateManager.depthFunc(516);
            Gui.drawRect(lllllllllllIIlIlIIlllIIlIlIlIIIl, lllllllllllIIlIlIIlllIIlIlIlIIII, lllllllllllIIlIlIIlllIIlIlIlIIIl + 16, lllllllllllIIlIlIIlllIIlIlIlIIII + 16, 822083583);
            GlStateManager.depthFunc(515);
            if (lllllllllllIIlIlIIlllIIlIlIlIIll == 0) {
                lllllllllllIIlIlIIlllIIlIlIIlllI.renderItemOverlays(Minecraft.fontRendererObj, lllllllllllIIlIlIIlllIIlIlIIllll, lllllllllllIIlIlIIlllIIlIlIlIIIl, lllllllllllIIlIlIIlllIIlIlIlIIII);
            }
            GlStateManager.enableLighting();
        }
        RenderHelper.disableStandardItemLighting();
    }
    
    @Nullable
    public IRecipe func_192686_c() {
        return this.field_192687_a;
    }
    
    public void func_194187_a(final Ingredient lllllllllllIIlIlIIlllIIlIllllIlI, final int lllllllllllIIlIlIIlllIIlIllllIIl, final int lllllllllllIIlIlIIlllIIlIlllllII) {
        this.field_192688_b.add(new GhostIngredient(lllllllllllIIlIlIIlllIIlIllllIlI, lllllllllllIIlIlIIlllIIlIllllIIl, lllllllllllIIlIlIIlllIIlIlllllII));
    }
    
    public GhostIngredient func_192681_a(final int lllllllllllIIlIlIIlllIIlIlllIlII) {
        return this.field_192688_b.get(lllllllllllIIlIlIIlllIIlIlllIlII);
    }
    
    public void func_192682_a() {
        this.field_192687_a = null;
        this.field_192688_b.clear();
        this.field_194190_c = 0.0f;
    }
    
    public int func_192684_b() {
        return this.field_192688_b.size();
    }
    
    public void func_192685_a(final IRecipe lllllllllllIIlIlIIlllIIlIllIIllI) {
        this.field_192687_a = lllllllllllIIlIlIIlllIIlIllIIllI;
    }
    
    public GhostRecipe() {
        this.field_192688_b = (List<GhostIngredient>)Lists.newArrayList();
    }
    
    public class GhostIngredient
    {
        private final /* synthetic */ int field_192678_b;
        private final /* synthetic */ Ingredient field_194186_b;
        private final /* synthetic */ int field_192679_c;
        
        public ItemStack func_194184_c() {
            final ItemStack[] llllllllllIllllIllIlllIIIllIIIll = this.field_194186_b.func_193365_a();
            return llllllllllIllllIllIlllIIIllIIIll[MathHelper.floor(GhostRecipe.this.field_194190_c / 30.0f) % llllllllllIllllIllIlllIIIllIIIll.length];
        }
        
        public int func_193712_c() {
            return this.field_192679_c;
        }
        
        public GhostIngredient(final Ingredient llllllllllIllllIllIlllIIIlllIlII, final int llllllllllIllllIllIlllIIIllIlllI, final int llllllllllIllllIllIlllIIIlllIIlI) {
            this.field_194186_b = llllllllllIllllIllIlllIIIlllIlII;
            this.field_192678_b = llllllllllIllllIllIlllIIIllIlllI;
            this.field_192679_c = llllllllllIllllIllIlllIIIlllIIlI;
        }
        
        public int func_193713_b() {
            return this.field_192678_b;
        }
    }
}
