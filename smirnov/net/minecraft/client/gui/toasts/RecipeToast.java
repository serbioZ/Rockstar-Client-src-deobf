// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.crafting.IRecipe;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import java.util.List;

public class RecipeToast implements IToast
{
    private /* synthetic */ boolean field_193668_e;
    private final /* synthetic */ List<ItemStack> field_193666_c;
    private /* synthetic */ long field_193667_d;
    
    public RecipeToast(final ItemStack lllllllllllIIIIIllIIlllIIllIIIll) {
        this.field_193666_c = (List<ItemStack>)Lists.newArrayList();
        this.field_193666_c.add(lllllllllllIIIIIllIIlllIIllIIIll);
    }
    
    public static void func_193665_a(final GuiToast lllllllllllIIIIIllIIlllIIlIIlllI, final IRecipe lllllllllllIIIIIllIIlllIIlIIlIlI) {
        final RecipeToast lllllllllllIIIIIllIIlllIIlIIllII = lllllllllllIIIIIllIIlllIIlIIlllI.func_192990_a((Class<? extends RecipeToast>)RecipeToast.class, RecipeToast.field_193655_b);
        if (lllllllllllIIIIIllIIlllIIlIIllII == null) {
            lllllllllllIIIIIllIIlllIIlIIlllI.func_192988_a(new RecipeToast(lllllllllllIIIIIllIIlllIIlIIlIlI.getRecipeOutput()));
        }
        else {
            lllllllllllIIIIIllIIlllIIlIIllII.func_193664_a(lllllllllllIIIIIllIIlllIIlIIlIlI.getRecipeOutput());
        }
    }
    
    public void func_193664_a(final ItemStack lllllllllllIIIIIllIIlllIIlIlIIlI) {
        if (this.field_193666_c.add(lllllllllllIIIIIllIIlllIIlIlIIlI)) {
            this.field_193668_e = true;
        }
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast lllllllllllIIIIIllIIlllIIlIlllII, final long lllllllllllIIIIIllIIlllIIlIllIII) {
        if (this.field_193668_e) {
            this.field_193667_d = lllllllllllIIIIIllIIlllIIlIllIII;
            this.field_193668_e = false;
        }
        if (this.field_193666_c.isEmpty()) {
            return Visibility.HIDE;
        }
        lllllllllllIIIIIllIIlllIIlIlllII.func_192989_b().getTextureManager().bindTexture(RecipeToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        lllllllllllIIIIIllIIlllIIlIlllII.drawTexturedModalRect(0, 0, 0, 32, 160, 32);
        lllllllllllIIIIIllIIlllIIlIlllII.func_192989_b();
        Minecraft.fontRendererObj.drawString(I18n.format("recipe.toast.title", new Object[0]), 30.0f, 7.0f, -11534256);
        lllllllllllIIIIIllIIlllIIlIlllII.func_192989_b();
        Minecraft.fontRendererObj.drawString(I18n.format("recipe.toast.description", new Object[0]), 30.0f, 18.0f, -16777216);
        RenderHelper.enableGUIStandardItemLighting();
        lllllllllllIIIIIllIIlllIIlIlllII.func_192989_b().getRenderItem().renderItemAndEffectIntoGUI(null, this.field_193666_c.get((int)(lllllllllllIIIIIllIIlllIIlIllIII / (5000L / this.field_193666_c.size()) % this.field_193666_c.size())), 8, 8);
        return (lllllllllllIIIIIllIIlllIIlIllIII - this.field_193667_d >= 5000L) ? Visibility.HIDE : Visibility.SHOW;
    }
}
