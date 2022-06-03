// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.recipebook;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderItem;
import java.util.Iterator;
import net.minecraft.stats.RecipeBook;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.client.util.RecipeBookClient;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.gui.GuiButtonToggle;

public class GuiButtonRecipeTab extends GuiButtonToggle
{
    private final /* synthetic */ CreativeTabs field_193921_u;
    private /* synthetic */ float field_193922_v;
    
    public void func_193918_a(final Minecraft lllllllllllIIIllllllllIIlllllIIl) {
        final RecipeBook lllllllllllIIIllllllllIIlllllIII = lllllllllllIIIllllllllIIlllllIIl.player.func_192035_E();
        for (final RecipeList lllllllllllIIIllllllllIIllllIlll : RecipeBookClient.field_194086_e.get(this.field_193921_u)) {
            for (final IRecipe lllllllllllIIIllllllllIIllllIlIl : lllllllllllIIIllllllllIIllllIlll.func_194208_a(lllllllllllIIIllllllllIIlllllIII.func_192815_c())) {
                if (lllllllllllIIIllllllllIIlllllIII.func_194076_e(lllllllllllIIIllllllllIIllllIlIl)) {
                    this.field_193922_v = 15.0f;
                }
            }
        }
    }
    
    public boolean func_193919_e() {
        final List<RecipeList> lllllllllllIIIllllllllIIllIIIIll = RecipeBookClient.field_194086_e.get(this.field_193921_u);
        this.visible = false;
        for (final RecipeList lllllllllllIIIllllllllIIllIIIIlI : lllllllllllIIIllllllllIIllIIIIll) {
            if (lllllllllllIIIllllllllIIllIIIIlI.func_194209_a() && lllllllllllIIIllllllllIIllIIIIlI.func_194212_c()) {
                this.visible = true;
                break;
            }
        }
        return this.visible;
    }
    
    public CreativeTabs func_191764_e() {
        return this.field_193921_u;
    }
    
    private void func_193920_a(final RenderItem lllllllllllIIIllllllllIIllIIllIl) {
        final ItemStack lllllllllllIIIllllllllIIllIIllll = this.field_193921_u.getIconItemStack();
        if (this.field_193921_u == CreativeTabs.TOOLS) {
            lllllllllllIIIllllllllIIllIIllIl.renderItemAndEffectIntoGUI(lllllllllllIIIllllllllIIllIIllll, this.xPosition + 3, this.yPosition + 5);
            lllllllllllIIIllllllllIIllIIllIl.renderItemAndEffectIntoGUI(CreativeTabs.COMBAT.getIconItemStack(), this.xPosition + 14, this.yPosition + 5);
        }
        else if (this.field_193921_u == CreativeTabs.MISC) {
            lllllllllllIIIllllllllIIllIIllIl.renderItemAndEffectIntoGUI(lllllllllllIIIllllllllIIllIIllll, this.xPosition + 3, this.yPosition + 5);
            lllllllllllIIIllllllllIIllIIllIl.renderItemAndEffectIntoGUI(CreativeTabs.FOOD.getIconItemStack(), this.xPosition + 14, this.yPosition + 5);
        }
        else {
            lllllllllllIIIllllllllIIllIIllIl.renderItemAndEffectIntoGUI(lllllllllllIIIllllllllIIllIIllll, this.xPosition + 9, this.yPosition + 5);
        }
    }
    
    public GuiButtonRecipeTab(final int lllllllllllIIIllllllllIlIIIIIllI, final CreativeTabs lllllllllllIIIllllllllIlIIIIIIlI) {
        super(lllllllllllIIIllllllllIlIIIIIllI, 0, 0, 35, 27, false);
        this.field_193921_u = lllllllllllIIIllllllllIlIIIIIIlI;
        this.func_191751_a(153, 2, 35, 0, GuiRecipeBook.field_191894_a);
    }
    
    @Override
    public void func_191745_a(final Minecraft lllllllllllIIIllllllllIIllIllIll, final int lllllllllllIIIllllllllIIllIllIlI, final int lllllllllllIIIllllllllIIlllIIIlI, final float lllllllllllIIIllllllllIIllIllIII) {
        if (this.visible) {
            if (this.field_193922_v > 0.0f) {
                final float lllllllllllIIIllllllllIIlllIIIII = 1.0f + 0.1f * (float)Math.sin(this.field_193922_v / 15.0f * 3.1415927f);
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(this.xPosition + 8), (float)(this.yPosition + 12), 0.0f);
                GlStateManager.scale(1.0f, lllllllllllIIIllllllllIIlllIIIII, 1.0f);
                GlStateManager.translate((float)(-(this.xPosition + 8)), (float)(-(this.yPosition + 12)), 0.0f);
            }
            this.hovered = (lllllllllllIIIllllllllIIllIllIlI >= this.xPosition && lllllllllllIIIllllllllIIlllIIIlI >= this.yPosition && lllllllllllIIIllllllllIIllIllIlI < this.xPosition + this.width && lllllllllllIIIllllllllIIlllIIIlI < this.yPosition + this.height);
            lllllllllllIIIllllllllIIllIllIll.getTextureManager().bindTexture(this.field_191760_o);
            GlStateManager.disableDepth();
            int lllllllllllIIIllllllllIIllIlllll = this.field_191756_q;
            int lllllllllllIIIllllllllIIllIllllI = this.field_191757_r;
            if (this.field_191755_p) {
                lllllllllllIIIllllllllIIllIlllll += this.field_191758_s;
            }
            if (this.hovered) {
                lllllllllllIIIllllllllIIllIllllI += this.field_191759_t;
            }
            int lllllllllllIIIllllllllIIllIlllIl = this.xPosition;
            if (this.field_191755_p) {
                lllllllllllIIIllllllllIIllIlllIl -= 2;
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(lllllllllllIIIllllllllIIllIlllIl, this.yPosition, lllllllllllIIIllllllllIIllIlllll, lllllllllllIIIllllllllIIllIllllI, this.width, this.height);
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            this.func_193920_a(lllllllllllIIIllllllllIIllIllIll.getRenderItem());
            GlStateManager.enableLighting();
            RenderHelper.disableStandardItemLighting();
            if (this.field_193922_v > 0.0f) {
                GlStateManager.popMatrix();
                this.field_193922_v -= lllllllllllIIIllllllllIIllIllIII;
            }
        }
    }
}
